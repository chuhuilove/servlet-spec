/*
 * Copyright (c) 1997-2018 Oracle and/or its affiliates. All rights reserved.
 * Copyright 2004 The Apache Software Foundation
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package javax.servlet;

import java.util.EventListener;

/** 
 * Interface for receiving notification events about ServletContext
 * lifecycle changes.
 *
 * 用于接收和ServletContext生命周期更改有关的事件通知接口.
 *
 * {@link javax.servlet.http.HttpSessionListener} 是用于接收有关HttpSession生命周期更改的通知事件的接口.
 *
 * 声明方式和{@link javax.servlet.http.HttpSessionListener}一样
 *
 * 此接口的实现在其{@link #contextInitialized}方法中按声明它们的顺序调用,
 * 在其{@link #contextDestroyed}方法中按相反的顺序调用.
 *
 * @see ServletContextEvent
 * @see javax.servlet.http.HttpSessionListener
 *
 * @since Servlet 2.3
 */
public interface ServletContextListener extends EventListener {

    /**
     *
     * 接收web应用程序初始化程序正在启动的通知.
     *
     * Receives notification that the web application initialization
     * process is starting.
     *
     * <p>All ServletContextListeners are notified of context
     * initialization before any filters or servlets in the web
     * application are initialized.
     *
     * <p>在初始化web应用程序中的任何过滤器或servlet之前,
     * 所有的ServletContextListeners都会收到上下文初始化的通知.
     *
     * @param sce 包含正在初始化的ServletContext的ServletContextEvent
     *
     * @implSpec
     * The default implementation takes no action.
     */
    default public void contextInitialized(ServletContextEvent sce) {}

    /**
     * Receives notification that the ServletContext is about to be
     * shut down.
     *
     * 接收servlet上下文即将关闭的通知.
     *
     * <p>All servlets and filters will have been destroyed before any
     * ServletContextListeners are notified of context
     * destruction.
     *
     * @param sce the ServletContextEvent containing the ServletContext
     * that is being destroyed
     *
     * @implSpec
     * The default implementation takes no action.
     */
    default public void contextDestroyed(ServletContextEvent sce) {}
}


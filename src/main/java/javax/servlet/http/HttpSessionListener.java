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

package javax.servlet.http;

import java.util.EventListener;

/** 
 * Interface for receiving notification events about HttpSession
 * lifecycle changes.
 *
 * 用于接收有关HttpSession生命周期更改的通知事件的接口.
 *
 * 为了接收这些通知事件,实现类必须在web应用程序的部署描述符中声明,声明方式有两种:
 *
 * 1.使用{@link javax.servlet.annotation.WebListener}注解
 * 2. 通过{@link javax.servlet.ServletContext}中的{@code addListener}注册
 *
 *
 * 这个接口的实现在它们的{@link #sessionCreated}方法中按声明它们的顺序调用,
 * 在它们的{@link #sessionDestroyed}方法中按相反的顺序调用.
 *
 * <p>Implementations of this interface are invoked at their
 * {@link #sessionCreated} method in the order in which they have been
 * declared, and at their {@link #sessionDestroyed} method in reverse
 * order.
 *
 * @see HttpSessionEvent
 *
 * @since Servlet 2.3
 */
public interface HttpSessionListener extends EventListener {
    
    /** 
     * Receives notification that a session has been created.
     * 接收创建session的通知
     *
     * @implSpec
     * The default implementation takes no action.
     *
     * @param se the HttpSessionEvent containing the session
     */
    default public void sessionCreated(HttpSessionEvent se) {}
    
    /** 
     * Receives notification that a session is about to be invalidated.
     * 接收session即将失效的通知
     *
     * @implSpec
     * The default implementation takes no action.
     *
     * @param se the HttpSessionEvent containing the session
     */
    default public void sessionDestroyed(HttpSessionEvent se) {}
}

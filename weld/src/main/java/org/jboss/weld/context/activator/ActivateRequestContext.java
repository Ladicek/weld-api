/*
 * JBoss, Home of Professional Open Source
 * Copyright 2016, Red Hat, Inc. and/or its affiliates, and individual
 * contributors by the @authors tag. See the copyright.txt in the
 * distribution for a full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jboss.weld.context.activator;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.util.AnnotationLiteral;
import jakarta.interceptor.InterceptorBinding;

/**
 * This interceptor binding can be used to activate the request context within a business method invocation.
 * <p>
 * If the request context is already active then the associated interceptor does nothing.
 * <p>
 * The interceptor is registered with a priority of {@link jakarta.interceptor.Interceptor.Priority#PLATFORM_BEFORE} + 100. The
 * same value is used for
 * {@link jakarta.enterprise.context.control.ActivateRequestContext}.
 *
 * @author Tomas Remes
 * @author Martin Kouba
 * @see RequestScoped
 */
@InterceptorBinding
@Retention(RUNTIME)
@Target({ METHOD, TYPE })
public @interface ActivateRequestContext {

    /**
     * Annotation literal for {@link ActivateRequestContext}
     */
    class Literal extends AnnotationLiteral<ActivateRequestContext> implements ActivateRequestContext {

        /**
         * An instance of {@link ActivateRequestContext} annotation literal
         */
        public static final Literal INSTANCE = new Literal();

        private static final long serialVersionUID = 1L;
    }
}

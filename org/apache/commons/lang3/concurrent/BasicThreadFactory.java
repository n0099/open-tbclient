package org.apache.commons.lang3.concurrent;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.Thread;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes2.dex */
public class BasicThreadFactory implements ThreadFactory {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Boolean daemonFlag;
    public final String namingPattern;
    public final Integer priority;
    public final AtomicLong threadCounter;
    public final Thread.UncaughtExceptionHandler uncaughtExceptionHandler;
    public final ThreadFactory wrappedFactory;

    /* renamed from: org.apache.commons.lang3.concurrent.BasicThreadFactory$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes2.dex */
    public static class Builder implements org.apache.commons.lang3.builder.Builder<BasicThreadFactory> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public Boolean daemonFlag;
        public Thread.UncaughtExceptionHandler exceptionHandler;
        public String namingPattern;
        public Integer priority;
        public ThreadFactory wrappedFactory;

        public Builder() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public Builder daemon(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z)) == null) {
                this.daemonFlag = Boolean.valueOf(z);
                return this;
            }
            return (Builder) invokeZ.objValue;
        }

        public Builder namingPattern(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
                if (str != null) {
                    this.namingPattern = str;
                    return this;
                }
                throw new NullPointerException("Naming pattern must not be null!");
            }
            return (Builder) invokeL.objValue;
        }

        public Builder priority(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i2)) == null) {
                this.priority = Integer.valueOf(i2);
                return this;
            }
            return (Builder) invokeI.objValue;
        }

        public void reset() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
                this.wrappedFactory = null;
                this.exceptionHandler = null;
                this.namingPattern = null;
                this.priority = null;
                this.daemonFlag = null;
            }
        }

        public Builder uncaughtExceptionHandler(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, uncaughtExceptionHandler)) == null) {
                if (uncaughtExceptionHandler != null) {
                    this.exceptionHandler = uncaughtExceptionHandler;
                    return this;
                }
                throw new NullPointerException("Uncaught exception handler must not be null!");
            }
            return (Builder) invokeL.objValue;
        }

        public Builder wrappedFactory(ThreadFactory threadFactory) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, threadFactory)) == null) {
                if (threadFactory != null) {
                    this.wrappedFactory = threadFactory;
                    return this;
                }
                throw new NullPointerException("Wrapped ThreadFactory must not be null!");
            }
            return (Builder) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // org.apache.commons.lang3.builder.Builder
        public BasicThreadFactory build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                BasicThreadFactory basicThreadFactory = new BasicThreadFactory(this, null);
                reset();
                return basicThreadFactory;
            }
            return (BasicThreadFactory) invokeV.objValue;
        }
    }

    public /* synthetic */ BasicThreadFactory(Builder builder, AnonymousClass1 anonymousClass1) {
        this(builder);
    }

    private void initializeThread(Thread thread) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, thread) == null) {
            if (getNamingPattern() != null) {
                thread.setName(String.format(getNamingPattern(), Long.valueOf(this.threadCounter.incrementAndGet())));
            }
            if (getUncaughtExceptionHandler() != null) {
                thread.setUncaughtExceptionHandler(getUncaughtExceptionHandler());
            }
            if (getPriority() != null) {
                thread.setPriority(getPriority().intValue());
            }
            if (getDaemonFlag() != null) {
                thread.setDaemon(getDaemonFlag().booleanValue());
            }
        }
    }

    public final Boolean getDaemonFlag() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.daemonFlag : (Boolean) invokeV.objValue;
    }

    public final String getNamingPattern() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.namingPattern : (String) invokeV.objValue;
    }

    public final Integer getPriority() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.priority : (Integer) invokeV.objValue;
    }

    public long getThreadCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.threadCounter.get() : invokeV.longValue;
    }

    public final Thread.UncaughtExceptionHandler getUncaughtExceptionHandler() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.uncaughtExceptionHandler : (Thread.UncaughtExceptionHandler) invokeV.objValue;
    }

    public final ThreadFactory getWrappedFactory() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.wrappedFactory : (ThreadFactory) invokeV.objValue;
    }

    @Override // java.util.concurrent.ThreadFactory
    public Thread newThread(Runnable runnable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, runnable)) == null) {
            Thread newThread = getWrappedFactory().newThread(runnable);
            initializeThread(newThread);
            return newThread;
        }
        return (Thread) invokeL.objValue;
    }

    public BasicThreadFactory(Builder builder) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {builder};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (builder.wrappedFactory != null) {
            this.wrappedFactory = builder.wrappedFactory;
        } else {
            this.wrappedFactory = Executors.defaultThreadFactory();
        }
        this.namingPattern = builder.namingPattern;
        this.priority = builder.priority;
        this.daemonFlag = builder.daemonFlag;
        this.uncaughtExceptionHandler = builder.exceptionHandler;
        this.threadCounter = new AtomicLong();
    }
}

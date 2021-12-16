package com.google.common.util.concurrent;

import c.i.d.a.n;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.Thread;
import java.util.Locale;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes3.dex */
public final class ThreadFactoryBuilder {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ThreadFactory backingThreadFactory;
    public Boolean daemon;
    public String nameFormat;
    public Integer priority;
    public Thread.UncaughtExceptionHandler uncaughtExceptionHandler;

    public ThreadFactoryBuilder() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.nameFormat = null;
        this.daemon = null;
        this.priority = null;
        this.uncaughtExceptionHandler = null;
        this.backingThreadFactory = null;
    }

    public static ThreadFactory doBuild(ThreadFactoryBuilder threadFactoryBuilder) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, threadFactoryBuilder)) == null) {
            String str = threadFactoryBuilder.nameFormat;
            Boolean bool = threadFactoryBuilder.daemon;
            Integer num = threadFactoryBuilder.priority;
            Thread.UncaughtExceptionHandler uncaughtExceptionHandler = threadFactoryBuilder.uncaughtExceptionHandler;
            ThreadFactory threadFactory = threadFactoryBuilder.backingThreadFactory;
            if (threadFactory == null) {
                threadFactory = Executors.defaultThreadFactory();
            }
            return new ThreadFactory(threadFactory, str, str != null ? new AtomicLong(0L) : null, bool, num, uncaughtExceptionHandler) { // from class: com.google.common.util.concurrent.ThreadFactoryBuilder.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ ThreadFactory val$backingThreadFactory;
                public final /* synthetic */ AtomicLong val$count;
                public final /* synthetic */ Boolean val$daemon;
                public final /* synthetic */ String val$nameFormat;
                public final /* synthetic */ Integer val$priority;
                public final /* synthetic */ Thread.UncaughtExceptionHandler val$uncaughtExceptionHandler;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {threadFactory, str, r8, bool, num, uncaughtExceptionHandler};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.val$backingThreadFactory = threadFactory;
                    this.val$nameFormat = str;
                    this.val$count = r8;
                    this.val$daemon = bool;
                    this.val$priority = num;
                    this.val$uncaughtExceptionHandler = uncaughtExceptionHandler;
                }

                @Override // java.util.concurrent.ThreadFactory
                public Thread newThread(Runnable runnable) {
                    InterceptResult invokeL2;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL2 = interceptable2.invokeL(1048576, this, runnable)) == null) {
                        Thread newThread = this.val$backingThreadFactory.newThread(runnable);
                        String str2 = this.val$nameFormat;
                        if (str2 != null) {
                            newThread.setName(ThreadFactoryBuilder.format(str2, Long.valueOf(this.val$count.getAndIncrement())));
                        }
                        Boolean bool2 = this.val$daemon;
                        if (bool2 != null) {
                            newThread.setDaemon(bool2.booleanValue());
                        }
                        Integer num2 = this.val$priority;
                        if (num2 != null) {
                            newThread.setPriority(num2.intValue());
                        }
                        Thread.UncaughtExceptionHandler uncaughtExceptionHandler2 = this.val$uncaughtExceptionHandler;
                        if (uncaughtExceptionHandler2 != null) {
                            newThread.setUncaughtExceptionHandler(uncaughtExceptionHandler2);
                        }
                        return newThread;
                    }
                    return (Thread) invokeL2.objValue;
                }
            };
        }
        return (ThreadFactory) invokeL.objValue;
    }

    public static String format(String str, Object... objArr) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(65539, null, str, objArr)) == null) ? String.format(Locale.ROOT, str, objArr) : (String) invokeLL.objValue;
    }

    public ThreadFactory build() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? doBuild(this) : (ThreadFactory) invokeV.objValue;
    }

    public ThreadFactoryBuilder setDaemon(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) {
            this.daemon = Boolean.valueOf(z);
            return this;
        }
        return (ThreadFactoryBuilder) invokeZ.objValue;
    }

    public ThreadFactoryBuilder setNameFormat(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            format(str, 0);
            this.nameFormat = str;
            return this;
        }
        return (ThreadFactoryBuilder) invokeL.objValue;
    }

    public ThreadFactoryBuilder setPriority(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
            n.g(i2 >= 1, "Thread priority (%s) must be >= %s", i2, 1);
            n.g(i2 <= 10, "Thread priority (%s) must be <= %s", i2, 10);
            this.priority = Integer.valueOf(i2);
            return this;
        }
        return (ThreadFactoryBuilder) invokeI.objValue;
    }

    public ThreadFactoryBuilder setThreadFactory(ThreadFactory threadFactory) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, threadFactory)) == null) {
            n.p(threadFactory);
            this.backingThreadFactory = threadFactory;
            return this;
        }
        return (ThreadFactoryBuilder) invokeL.objValue;
    }

    public ThreadFactoryBuilder setUncaughtExceptionHandler(Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, uncaughtExceptionHandler)) == null) {
            n.p(uncaughtExceptionHandler);
            this.uncaughtExceptionHandler = uncaughtExceptionHandler;
            return this;
        }
        return (ThreadFactoryBuilder) invokeL.objValue;
    }
}

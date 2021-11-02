package com.kwad.sdk.crash.c;

import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.crash.model.message.JavaExceptionMessage;
import java.lang.Thread;
/* loaded from: classes2.dex */
public class d implements Thread.UncaughtExceptionHandler {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public volatile boolean f65458a;

    /* renamed from: b  reason: collision with root package name */
    public Thread.UncaughtExceptionHandler f65459b;

    /* renamed from: c  reason: collision with root package name */
    public Context f65460c;

    public d(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f65458a = false;
        this.f65459b = Thread.getDefaultUncaughtExceptionHandler();
        this.f65460c = context;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, thread, th) == null) {
            if (this.f65458a) {
                com.kwad.sdk.core.d.a.a("ExceptionCollector", "SDK捕获 uncaughtException 正在处理 ex=" + th.getMessage());
                this.f65459b.uncaughtException(thread, th);
                return;
            }
            this.f65458a = true;
            com.kwad.sdk.core.d.a.a("ExceptionCollector", "thread=" + thread + " ex=" + th.getMessage());
            if (th != null && com.kwad.sdk.crash.b.a.a(th)) {
                c.d().a(th, new JavaExceptionMessage(), this.f65460c);
            }
            this.f65459b.uncaughtException(thread, th);
        }
    }
}

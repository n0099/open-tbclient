package com.ss.android.socialbase.downloader.h;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
/* loaded from: classes2.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Object f69421a;

    /* renamed from: b  reason: collision with root package name */
    public Queue<b> f69422b;

    /* renamed from: c  reason: collision with root package name */
    public a f69423c;

    /* renamed from: d  reason: collision with root package name */
    public Handler f69424d;

    /* loaded from: classes2.dex */
    public class a extends HandlerThread {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g f69425a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(g gVar, String str) {
            super(str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((String) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f69425a = gVar;
        }

        @Override // android.os.HandlerThread
        public void onLooperPrepared() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                super.onLooperPrepared();
                Looper looper = getLooper();
                synchronized (this.f69425a.f69421a) {
                    this.f69425a.f69424d = new Handler(looper);
                }
                while (!this.f69425a.f69422b.isEmpty()) {
                    b bVar = (b) this.f69425a.f69422b.poll();
                    this.f69425a.f69424d.postDelayed(bVar.f69426a, bVar.f69427b);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public Runnable f69426a;

        /* renamed from: b  reason: collision with root package name */
        public long f69427b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ g f69428c;

        public b(g gVar, Runnable runnable, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, runnable, Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f69428c = gVar;
            this.f69426a = runnable;
            this.f69427b = j;
        }
    }

    public g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f69421a = new Object();
        this.f69422b = new ConcurrentLinkedQueue();
        this.f69423c = new a(this, str);
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f69423c.quit();
        }
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f69423c.start();
        }
    }

    public void a(Runnable runnable) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, runnable) == null) {
            a(runnable, 0L);
        }
    }

    public void a(Runnable runnable, long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_SEND_USER_MSG, this, runnable, j) == null) {
            if (this.f69424d == null) {
                synchronized (this.f69421a) {
                    if (this.f69424d == null) {
                        this.f69422b.add(new b(this, runnable, j));
                        return;
                    }
                }
            }
            this.f69424d.postDelayed(runnable, j);
        }
    }
}

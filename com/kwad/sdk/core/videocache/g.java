package com.kwad.sdk.core.videocache;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.net.Socket;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
/* loaded from: classes2.dex */
public final class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final AtomicInteger f66083a;

    /* renamed from: b  reason: collision with root package name */
    public final String f66084b;

    /* renamed from: c  reason: collision with root package name */
    public volatile e f66085c;

    /* renamed from: d  reason: collision with root package name */
    public final List<b> f66086d;

    /* renamed from: e  reason: collision with root package name */
    public final b f66087e;

    /* renamed from: f  reason: collision with root package name */
    public final c f66088f;

    /* loaded from: classes2.dex */
    public static final class a extends Handler implements b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final String f66089a;

        /* renamed from: b  reason: collision with root package name */
        public final List<b> f66090b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(String str, List<b> list) {
            super(Looper.getMainLooper());
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, list};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Looper) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f66089a = str;
            this.f66090b = list;
        }

        @Override // com.kwad.sdk.core.videocache.b
        public void a(File file, String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, file, str, i2) == null) {
                Message obtainMessage = obtainMessage();
                obtainMessage.arg1 = i2;
                obtainMessage.obj = file;
                sendMessage(obtainMessage);
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, message) == null) {
                for (b bVar : this.f66090b) {
                    bVar.a((File) message.obj, this.f66089a, message.arg1);
                }
            }
        }
    }

    public g(String str, c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, cVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f66083a = new AtomicInteger(0);
        this.f66086d = new CopyOnWriteArrayList();
        this.f66084b = (String) j.a(str);
        this.f66088f = (c) j.a(cVar);
        this.f66087e = new a(str, this.f66086d);
    }

    private synchronized void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            synchronized (this) {
                this.f66085c = this.f66085c == null ? e() : this.f66085c;
            }
        }
    }

    private synchronized void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            synchronized (this) {
                if (this.f66083a.decrementAndGet() <= 0) {
                    this.f66085c.a();
                    this.f66085c = null;
                }
            }
        }
    }

    private e e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            String str = this.f66084b;
            c cVar = this.f66088f;
            e eVar = new e(new h(str, cVar.f66055d, cVar.f66056e), new com.kwad.sdk.core.videocache.a.b(this.f66088f.a(this.f66084b), this.f66088f.f66054c));
            eVar.a(this.f66087e);
            return eVar;
        }
        return (e) invokeV.objValue;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f66086d.clear();
            if (this.f66085c != null) {
                this.f66085c.a((b) null);
                this.f66085c.a();
                this.f66085c = null;
            }
            this.f66083a.set(0);
        }
    }

    public void a(d dVar, Socket socket) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dVar, socket) == null) {
            c();
            try {
                this.f66083a.incrementAndGet();
                this.f66085c.a(dVar, socket);
            } finally {
                d();
            }
        }
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f66083a.get() : invokeV.intValue;
    }
}

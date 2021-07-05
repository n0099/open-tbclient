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
/* loaded from: classes7.dex */
public final class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final AtomicInteger f36695a;

    /* renamed from: b  reason: collision with root package name */
    public final String f36696b;

    /* renamed from: c  reason: collision with root package name */
    public volatile e f36697c;

    /* renamed from: d  reason: collision with root package name */
    public final List<b> f36698d;

    /* renamed from: e  reason: collision with root package name */
    public final b f36699e;

    /* renamed from: f  reason: collision with root package name */
    public final c f36700f;

    /* loaded from: classes7.dex */
    public static final class a extends Handler implements b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final String f36701a;

        /* renamed from: b  reason: collision with root package name */
        public final List<b> f36702b;

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
            this.f36701a = str;
            this.f36702b = list;
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
                for (b bVar : this.f36702b) {
                    bVar.a((File) message.obj, this.f36701a, message.arg1);
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
        this.f36695a = new AtomicInteger(0);
        this.f36698d = new CopyOnWriteArrayList();
        this.f36696b = (String) j.a(str);
        this.f36700f = (c) j.a(cVar);
        this.f36699e = new a(str, this.f36698d);
    }

    private synchronized void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65537, this) == null) {
            synchronized (this) {
                this.f36697c = this.f36697c == null ? e() : this.f36697c;
            }
        }
    }

    private synchronized void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            synchronized (this) {
                if (this.f36695a.decrementAndGet() <= 0) {
                    this.f36697c.a();
                    this.f36697c = null;
                }
            }
        }
    }

    private e e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, this)) == null) {
            String str = this.f36696b;
            c cVar = this.f36700f;
            e eVar = new e(new h(str, cVar.f36667d, cVar.f36668e), new com.kwad.sdk.core.videocache.a.b(this.f36700f.a(this.f36696b), this.f36700f.f36666c));
            eVar.a(this.f36699e);
            return eVar;
        }
        return (e) invokeV.objValue;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f36698d.clear();
            if (this.f36697c != null) {
                this.f36697c.a((b) null);
                this.f36697c.a();
                this.f36697c = null;
            }
            this.f36695a.set(0);
        }
    }

    public void a(d dVar, Socket socket) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dVar, socket) == null) {
            c();
            try {
                this.f36695a.incrementAndGet();
                this.f36697c.a(dVar, socket);
            } finally {
                d();
            }
        }
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f36695a.get() : invokeV.intValue;
    }
}

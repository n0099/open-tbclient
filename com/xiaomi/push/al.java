package com.xiaomi.push;

import android.os.Handler;
import android.os.Looper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
/* loaded from: classes4.dex */
public class al {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: a  reason: collision with other field name */
    public Handler f117a;

    /* renamed from: a  reason: collision with other field name */
    public a f118a;

    /* renamed from: a  reason: collision with other field name */
    public volatile b f119a;

    /* renamed from: a  reason: collision with other field name */
    public volatile boolean f120a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f63290b;

    /* loaded from: classes4.dex */
    public class a extends Thread {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ al a;

        /* renamed from: a  reason: collision with other field name */
        public final LinkedBlockingQueue<b> f121a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(al alVar) {
            super("PackageProcessor");
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alVar};
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
            this.a = alVar;
            this.f121a = new LinkedBlockingQueue<>();
        }

        private void a(int i2, b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(65537, this, i2, bVar) == null) {
                try {
                    this.a.f117a.sendMessage(this.a.f117a.obtainMessage(i2, bVar));
                } catch (Exception e2) {
                    com.xiaomi.channel.commonutils.logger.b.a(e2);
                }
            }
        }

        public void a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
                try {
                    this.f121a.add(bVar);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                long j2 = this.a.a > 0 ? this.a.a : Long.MAX_VALUE;
                while (!this.a.f120a) {
                    try {
                        b poll = this.f121a.poll(j2, TimeUnit.SECONDS);
                        this.a.f119a = poll;
                        if (poll != null) {
                            a(0, poll);
                            poll.b();
                            a(1, poll);
                        } else if (this.a.a > 0) {
                            this.a.a();
                        }
                    } catch (InterruptedException e2) {
                        com.xiaomi.channel.commonutils.logger.b.a(e2);
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public static abstract class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b() {
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

        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            }
        }

        public abstract void b();

        /* renamed from: c */
        public void mo294c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public al() {
        this(false);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                this(((Boolean) newInitContext.callArgs[0]).booleanValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public al(boolean z) {
        this(z, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this(((Boolean) objArr2[0]).booleanValue(), ((Integer) objArr2[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public al(boolean z, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f117a = null;
        this.f120a = false;
        this.a = 0;
        this.f117a = new am(this, Looper.getMainLooper());
        this.f63290b = z;
        this.a = i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, this) == null) {
            synchronized (this) {
                this.f118a = null;
                this.f120a = true;
            }
        }
    }

    public synchronized void a(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            synchronized (this) {
                if (this.f118a == null) {
                    a aVar = new a(this);
                    this.f118a = aVar;
                    aVar.setDaemon(this.f63290b);
                    this.f120a = false;
                    this.f118a.start();
                }
                this.f118a.a(bVar);
            }
        }
    }

    public void a(b bVar, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar, j2) == null) {
            this.f117a.postDelayed(new an(this, bVar), j2);
        }
    }
}

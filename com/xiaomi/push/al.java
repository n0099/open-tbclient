package com.xiaomi.push;

import android.os.Handler;
import android.os.Looper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
/* loaded from: classes10.dex */
public class al {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f77164a;

    /* renamed from: a  reason: collision with other field name */
    public Handler f116a;

    /* renamed from: a  reason: collision with other field name */
    public a f117a;

    /* renamed from: a  reason: collision with other field name */
    public volatile b f118a;

    /* renamed from: a  reason: collision with other field name */
    public volatile boolean f119a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f77165b;

    /* loaded from: classes10.dex */
    public class a extends Thread {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ al f77166a;

        /* renamed from: a  reason: collision with other field name */
        public final LinkedBlockingQueue<b> f120a;

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
            this.f77166a = alVar;
            this.f120a = new LinkedBlockingQueue<>();
        }

        private void a(int i2, b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(65537, this, i2, bVar) == null) {
                try {
                    this.f77166a.f116a.sendMessage(this.f77166a.f116a.obtainMessage(i2, bVar));
                } catch (Exception e2) {
                    com.xiaomi.channel.commonutils.logger.b.a(e2);
                }
            }
        }

        public void a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
                try {
                    this.f120a.add(bVar);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                long j2 = this.f77166a.f77164a > 0 ? this.f77166a.f77164a : Long.MAX_VALUE;
                while (!this.f77166a.f119a) {
                    try {
                        b poll = this.f120a.poll(j2, TimeUnit.SECONDS);
                        this.f77166a.f118a = poll;
                        if (poll != null) {
                            a(0, poll);
                            poll.b();
                            a(1, poll);
                        } else if (this.f77166a.f77164a > 0) {
                            this.f77166a.a();
                        }
                    } catch (InterruptedException e2) {
                        com.xiaomi.channel.commonutils.logger.b.a(e2);
                    }
                }
            }
        }
    }

    /* loaded from: classes10.dex */
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
        public void mo245c() {
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
        this.f116a = null;
        this.f119a = false;
        this.f77164a = 0;
        this.f116a = new am(this, Looper.getMainLooper());
        this.f77165b = z;
        this.f77164a = i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this) == null) {
            synchronized (this) {
                this.f117a = null;
                this.f119a = true;
            }
        }
    }

    public synchronized void a(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            synchronized (this) {
                if (this.f117a == null) {
                    a aVar = new a(this);
                    this.f117a = aVar;
                    aVar.setDaemon(this.f77165b);
                    this.f119a = false;
                    this.f117a.start();
                }
                this.f117a.a(bVar);
            }
        }
    }

    public void a(b bVar, long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLJ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar, j2) == null) {
            this.f116a.postDelayed(new an(this, bVar), j2);
        }
    }
}

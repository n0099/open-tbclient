package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.xiaomi.push.gv;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.av;
/* loaded from: classes6.dex */
public class gs implements av.b.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f40501a;

    /* renamed from: a  reason: collision with other field name */
    public fl f450a;

    /* renamed from: a  reason: collision with other field name */
    public XMPushService f451a;

    /* renamed from: a  reason: collision with other field name */
    public av.b f452a;

    /* renamed from: a  reason: collision with other field name */
    public av.c f453a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f454a;

    public gs(XMPushService xMPushService, av.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {xMPushService, bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f454a = false;
        this.f451a = xMPushService;
        this.f453a = av.c.f40889b;
        this.f452a = bVar;
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            this.f452a.b(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:39:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void c() {
        ew ewVar;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeV(65539, this) != null) {
            return;
        }
        b();
        if (!this.f454a || this.f40501a == 11) {
            return;
        }
        ex m365a = gx.m363a().m365a();
        int i2 = gu.f40503a[this.f453a.ordinal()];
        if (i2 != 1) {
            if (i2 == 3) {
                ewVar = ew.H;
            }
            if (m365a != null) {
                m365a.b(this.f450a.m321a());
                m365a.d(this.f452a.f914b);
                m365a.f348b = 1;
                try {
                    m365a.a((byte) Integer.parseInt(this.f452a.f40880g));
                } catch (NumberFormatException unused) {
                }
                gx.m363a().a(m365a);
                return;
            }
            return;
        }
        int i3 = this.f40501a;
        if (i3 == 17) {
            ewVar = ew.L;
        } else if (i3 == 21) {
            ewVar = ew.S;
        } else {
            try {
                gv.a c2 = gv.c(gx.a().a());
                m365a.f345a = c2.f40504a.a();
                m365a.c(c2.f455a);
            } catch (NullPointerException unused2) {
                m365a = null;
            }
            if (m365a != null) {
            }
        }
        m365a.f345a = ewVar.a();
        if (m365a != null) {
        }
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f452a.a(this);
            this.f450a = this.f451a.m560a();
        }
    }

    @Override // com.xiaomi.push.service.av.b.a
    public void a(av.c cVar, av.c cVar2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar, cVar2, i2) == null) {
            if (!this.f454a && cVar == av.c.f40889b) {
                this.f453a = cVar2;
                this.f40501a = i2;
                this.f454a = true;
            }
            this.f451a.a(new gt(this, 4));
        }
    }
}

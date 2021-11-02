package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.xiaomi.push.gv;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.av;
/* loaded from: classes2.dex */
public class gs implements av.b.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f71050a;

    /* renamed from: a  reason: collision with other field name */
    public fl f455a;

    /* renamed from: a  reason: collision with other field name */
    public XMPushService f456a;

    /* renamed from: a  reason: collision with other field name */
    public av.b f457a;

    /* renamed from: a  reason: collision with other field name */
    public av.c f458a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f459a;

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
        this.f459a = false;
        this.f456a = xMPushService;
        this.f458a = av.c.f71438b;
        this.f457a = bVar;
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            this.f457a.b(this);
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
        if (!this.f459a || this.f71050a == 11) {
            return;
        }
        ex m368a = gx.m366a().m368a();
        int i2 = gu.f71052a[this.f458a.ordinal()];
        if (i2 != 1) {
            if (i2 == 3) {
                ewVar = ew.H;
            }
            if (m368a != null) {
                m368a.b(this.f455a.m324a());
                m368a.d(this.f457a.f919b);
                m368a.f353b = 1;
                try {
                    m368a.a((byte) Integer.parseInt(this.f457a.f71429g));
                } catch (NumberFormatException unused) {
                }
                gx.m366a().a(m368a);
                return;
            }
            return;
        }
        int i3 = this.f71050a;
        if (i3 == 17) {
            ewVar = ew.L;
        } else if (i3 == 21) {
            ewVar = ew.S;
        } else {
            try {
                gv.a c2 = gv.c(gx.a().a());
                m368a.f350a = c2.f71053a.a();
                m368a.c(c2.f460a);
            } catch (NullPointerException unused2) {
                m368a = null;
            }
            if (m368a != null) {
            }
        }
        m368a.f350a = ewVar.a();
        if (m368a != null) {
        }
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f457a.a(this);
            this.f455a = this.f456a.m563a();
        }
    }

    @Override // com.xiaomi.push.service.av.b.a
    public void a(av.c cVar, av.c cVar2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar, cVar2, i2) == null) {
            if (!this.f459a && cVar == av.c.f71438b) {
                this.f458a = cVar2;
                this.f71050a = i2;
                this.f459a = true;
            }
            this.f456a.a(new gt(this, 4));
        }
    }
}

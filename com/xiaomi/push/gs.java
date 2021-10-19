package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.xiaomi.push.gv;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.av;
/* loaded from: classes10.dex */
public class gs implements av.b.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f78095a;

    /* renamed from: a  reason: collision with other field name */
    public fl f454a;

    /* renamed from: a  reason: collision with other field name */
    public XMPushService f455a;

    /* renamed from: a  reason: collision with other field name */
    public av.b f456a;

    /* renamed from: a  reason: collision with other field name */
    public av.c f457a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f458a;

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
        this.f458a = false;
        this.f455a = xMPushService;
        this.f457a = av.c.f78499b;
        this.f456a = bVar;
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            this.f456a.b(this);
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
        if (!this.f458a || this.f78095a == 11) {
            return;
        }
        ex m368a = gx.m366a().m368a();
        int i2 = gu.f78097a[this.f457a.ordinal()];
        if (i2 != 1) {
            if (i2 == 3) {
                ewVar = ew.H;
            }
            if (m368a != null) {
                m368a.b(this.f454a.m324a());
                m368a.d(this.f456a.f918b);
                m368a.f352b = 1;
                try {
                    m368a.a((byte) Integer.parseInt(this.f456a.f78490g));
                } catch (NumberFormatException unused) {
                }
                gx.m366a().a(m368a);
                return;
            }
            return;
        }
        int i3 = this.f78095a;
        if (i3 == 17) {
            ewVar = ew.L;
        } else if (i3 == 21) {
            ewVar = ew.S;
        } else {
            try {
                gv.a c2 = gv.c(gx.a().a());
                m368a.f349a = c2.f78098a.a();
                m368a.c(c2.f459a);
            } catch (NullPointerException unused2) {
                m368a = null;
            }
            if (m368a != null) {
            }
        }
        m368a.f349a = ewVar.a();
        if (m368a != null) {
        }
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f456a.a(this);
            this.f454a = this.f455a.m563a();
        }
    }

    @Override // com.xiaomi.push.service.av.b.a
    public void a(av.c cVar, av.c cVar2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar, cVar2, i2) == null) {
            if (!this.f458a && cVar == av.c.f78499b) {
                this.f457a = cVar2;
                this.f78095a = i2;
                this.f458a = true;
            }
            this.f455a.a(new gt(this, 4));
        }
    }
}

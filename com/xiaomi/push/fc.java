package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.xiaomi.push.ff;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.bg;
/* loaded from: classes8.dex */
public class fc implements bg.b.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: a  reason: collision with other field name */
    public fw f1072a;

    /* renamed from: a  reason: collision with other field name */
    public XMPushService f1073a;

    /* renamed from: a  reason: collision with other field name */
    public bg.b f1074a;

    /* renamed from: a  reason: collision with other field name */
    public bg.c f1075a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f1076a;

    public fc(XMPushService xMPushService, bg.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {xMPushService, bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f1076a = false;
        this.f1073a = xMPushService;
        this.f1075a = bg.c.b;
        this.f1074a = bVar;
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            this.f1074a.b(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:39:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void c() {
        ez ezVar;
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeV(65539, this) != null) {
            return;
        }
        b();
        if (!this.f1076a || this.a == 11) {
            return;
        }
        fa m1268a = fh.m1266a().m1268a();
        int i = fe.a[this.f1075a.ordinal()];
        if (i != 1) {
            if (i == 3) {
                ezVar = ez.H;
            }
            if (m1268a != null) {
                m1268a.b(this.f1072a.m1292a());
                m1268a.d(this.f1074a.f1656b);
                m1268a.f1061b = 1;
                try {
                    m1268a.a((byte) Integer.parseInt(this.f1074a.g));
                } catch (NumberFormatException unused) {
                }
                fh.m1266a().a(m1268a);
                return;
            }
            return;
        }
        int i2 = this.a;
        if (i2 == 17) {
            ezVar = ez.L;
        } else if (i2 == 21) {
            ezVar = ez.S;
        } else {
            try {
                ff.a c = ff.c(fh.a().a());
                m1268a.f1058a = c.a.a();
                m1268a.c(c.f1077a);
            } catch (NullPointerException unused2) {
                m1268a = null;
            }
            if (m1268a != null) {
            }
        }
        m1268a.f1058a = ezVar.a();
        if (m1268a != null) {
        }
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f1074a.a(this);
            this.f1072a = this.f1073a.m1527a();
        }
    }

    @Override // com.xiaomi.push.service.bg.b.a
    public void a(bg.c cVar, bg.c cVar2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar, cVar2, i) == null) {
            if (!this.f1076a && cVar == bg.c.b) {
                this.f1075a = cVar2;
                this.a = i;
                this.f1076a = true;
            }
            this.f1073a.a(new fd(this, 4));
        }
    }
}

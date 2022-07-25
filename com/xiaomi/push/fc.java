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
    public fw f352a;

    /* renamed from: a  reason: collision with other field name */
    public XMPushService f353a;

    /* renamed from: a  reason: collision with other field name */
    public bg.b f354a;

    /* renamed from: a  reason: collision with other field name */
    public bg.c f355a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f356a;

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
        this.f356a = false;
        this.f353a = xMPushService;
        this.f355a = bg.c.b;
        this.f354a = bVar;
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            this.f354a.b(this);
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
        if (!this.f356a || this.a == 11) {
            return;
        }
        fa m330a = fh.m328a().m330a();
        int i = fe.a[this.f355a.ordinal()];
        if (i != 1) {
            if (i == 3) {
                ezVar = ez.H;
            }
            if (m330a != null) {
                m330a.b(this.f352a.m354a());
                m330a.d(this.f354a.f936b);
                m330a.f341b = 1;
                try {
                    m330a.a((byte) Integer.parseInt(this.f354a.g));
                } catch (NumberFormatException unused) {
                }
                fh.m328a().a(m330a);
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
                m330a.f338a = c.a.a();
                m330a.c(c.f357a);
            } catch (NullPointerException unused2) {
                m330a = null;
            }
            if (m330a != null) {
            }
        }
        m330a.f338a = ezVar.a();
        if (m330a != null) {
        }
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f354a.a(this);
            this.f352a = this.f353a.m589a();
        }
    }

    @Override // com.xiaomi.push.service.bg.b.a
    public void a(bg.c cVar, bg.c cVar2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar, cVar2, i) == null) {
            if (!this.f356a && cVar == bg.c.b) {
                this.f355a = cVar2;
                this.a = i;
                this.f356a = true;
            }
            this.f353a.a(new fd(this, 4));
        }
    }
}

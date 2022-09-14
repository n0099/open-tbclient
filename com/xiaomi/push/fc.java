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
    public fw f353a;

    /* renamed from: a  reason: collision with other field name */
    public XMPushService f354a;

    /* renamed from: a  reason: collision with other field name */
    public bg.b f355a;

    /* renamed from: a  reason: collision with other field name */
    public bg.c f356a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f357a;

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
        this.f357a = false;
        this.f354a = xMPushService;
        this.f356a = bg.c.b;
        this.f355a = bVar;
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            this.f355a.b(this);
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
        if (!this.f357a || this.a == 11) {
            return;
        }
        fa m331a = fh.m329a().m331a();
        int i = fe.a[this.f356a.ordinal()];
        if (i != 1) {
            if (i == 3) {
                ezVar = ez.H;
            }
            if (m331a != null) {
                m331a.b(this.f353a.m355a());
                m331a.d(this.f355a.f937b);
                m331a.f342b = 1;
                try {
                    m331a.a((byte) Integer.parseInt(this.f355a.g));
                } catch (NumberFormatException unused) {
                }
                fh.m329a().a(m331a);
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
                m331a.f339a = c.a.a();
                m331a.c(c.f358a);
            } catch (NullPointerException unused2) {
                m331a = null;
            }
            if (m331a != null) {
            }
        }
        m331a.f339a = ezVar.a();
        if (m331a != null) {
        }
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f355a.a(this);
            this.f353a = this.f354a.m590a();
        }
    }

    @Override // com.xiaomi.push.service.bg.b.a
    public void a(bg.c cVar, bg.c cVar2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar, cVar2, i) == null) {
            if (!this.f357a && cVar == bg.c.b) {
                this.f356a = cVar2;
                this.a = i;
                this.f357a = true;
            }
            this.f354a.a(new fd(this, 4));
        }
    }
}

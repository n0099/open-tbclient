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
    public fw f376a;

    /* renamed from: a  reason: collision with other field name */
    public XMPushService f377a;

    /* renamed from: a  reason: collision with other field name */
    public bg.b f378a;

    /* renamed from: a  reason: collision with other field name */
    public bg.c f379a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f380a;

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
        this.f380a = false;
        this.f377a = xMPushService;
        this.f379a = bg.c.b;
        this.f378a = bVar;
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            this.f378a.b(this);
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
        if (!this.f380a || this.a == 11) {
            return;
        }
        fa m401a = fh.m399a().m401a();
        int i = fe.a[this.f379a.ordinal()];
        if (i != 1) {
            if (i == 3) {
                ezVar = ez.H;
            }
            if (m401a != null) {
                m401a.b(this.f376a.mo428a());
                m401a.d(this.f378a.f960b);
                m401a.f365b = 1;
                try {
                    m401a.a((byte) Integer.parseInt(this.f378a.g));
                } catch (NumberFormatException unused) {
                }
                fh.m399a().a(m401a);
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
                m401a.f362a = c.a.a();
                m401a.c(c.f381a);
            } catch (NullPointerException unused2) {
                m401a = null;
            }
            if (m401a != null) {
            }
        }
        m401a.f362a = ezVar.a();
        if (m401a != null) {
        }
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f378a.a(this);
            this.f376a = this.f377a.m665a();
        }
    }

    @Override // com.xiaomi.push.service.bg.b.a
    public void a(bg.c cVar, bg.c cVar2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar, cVar2, i) == null) {
            if (!this.f380a && cVar == bg.c.b) {
                this.f379a = cVar2;
                this.a = i;
                this.f380a = true;
            }
            this.f377a.a(new fd(this, 4));
        }
    }
}

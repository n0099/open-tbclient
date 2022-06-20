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
    public fw f345a;

    /* renamed from: a  reason: collision with other field name */
    public XMPushService f346a;

    /* renamed from: a  reason: collision with other field name */
    public bg.b f347a;

    /* renamed from: a  reason: collision with other field name */
    public bg.c f348a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f349a;

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
        this.f349a = false;
        this.f346a = xMPushService;
        this.f348a = bg.c.b;
        this.f347a = bVar;
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            this.f347a.b(this);
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
        if (!this.f349a || this.a == 11) {
            return;
        }
        fa m325a = fh.m323a().m325a();
        int i = fe.a[this.f348a.ordinal()];
        if (i != 1) {
            if (i == 3) {
                ezVar = ez.H;
            }
            if (m325a != null) {
                m325a.b(this.f345a.m349a());
                m325a.d(this.f347a.f929b);
                m325a.f334b = 1;
                try {
                    m325a.a((byte) Integer.parseInt(this.f347a.g));
                } catch (NumberFormatException unused) {
                }
                fh.m323a().a(m325a);
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
                m325a.f331a = c.a.a();
                m325a.c(c.f350a);
            } catch (NullPointerException unused2) {
                m325a = null;
            }
            if (m325a != null) {
            }
        }
        m325a.f331a = ezVar.a();
        if (m325a != null) {
        }
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f347a.a(this);
            this.f345a = this.f346a.m584a();
        }
    }

    @Override // com.xiaomi.push.service.bg.b.a
    public void a(bg.c cVar, bg.c cVar2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar, cVar2, i) == null) {
            if (!this.f349a && cVar == bg.c.b) {
                this.f348a = cVar2;
                this.a = i;
                this.f349a = true;
            }
            this.f346a.a(new fd(this, 4));
        }
    }
}

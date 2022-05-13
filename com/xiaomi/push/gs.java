package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.xiaomi.push.gv;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.av;
/* loaded from: classes8.dex */
public class gs implements av.b.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;

    /* renamed from: a  reason: collision with other field name */
    public fl f431a;

    /* renamed from: a  reason: collision with other field name */
    public XMPushService f432a;

    /* renamed from: a  reason: collision with other field name */
    public av.b f433a;

    /* renamed from: a  reason: collision with other field name */
    public av.c f434a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f435a;

    public gs(XMPushService xMPushService, av.b bVar) {
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
        this.f435a = false;
        this.f432a = xMPushService;
        this.f434a = av.c.b;
        this.f433a = bVar;
    }

    private void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, this) == null) {
            this.f433a.b(this);
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
        if (!this.f435a || this.a == 11) {
            return;
        }
        ex m404a = gx.m402a().m404a();
        int i = gu.a[this.f434a.ordinal()];
        if (i != 1) {
            if (i == 3) {
                ewVar = ew.H;
            }
            if (m404a != null) {
                m404a.b(this.f431a.m360a());
                m404a.d(this.f433a.f895b);
                m404a.f329b = 1;
                try {
                    m404a.a((byte) Integer.parseInt(this.f433a.g));
                } catch (NumberFormatException unused) {
                }
                gx.m402a().a(m404a);
                return;
            }
            return;
        }
        int i2 = this.a;
        if (i2 == 17) {
            ewVar = ew.L;
        } else if (i2 == 21) {
            ewVar = ew.S;
        } else {
            try {
                gv.a c = gv.c(gx.a().a());
                m404a.f326a = c.a.a();
                m404a.c(c.f436a);
            } catch (NullPointerException unused2) {
                m404a = null;
            }
            if (m404a != null) {
            }
        }
        m404a.f326a = ewVar.a();
        if (m404a != null) {
        }
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f433a.a(this);
            this.f431a = this.f432a.m599a();
        }
    }

    @Override // com.xiaomi.push.service.av.b.a
    public void a(av.c cVar, av.c cVar2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar, cVar2, i) == null) {
            if (!this.f435a && cVar == av.c.b) {
                this.f434a = cVar2;
                this.a = i;
                this.f435a = true;
            }
            this.f432a.a(new gt(this, 4));
        }
    }
}

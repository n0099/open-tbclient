package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.tieba.video.VideoItemModel;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.xiaomi.push.du;
import com.xiaomi.push.fl;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
/* loaded from: classes10.dex */
public class fj implements fx {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static boolean f77252a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public a f388a;

    /* renamed from: a  reason: collision with other field name */
    public fl f389a;

    /* renamed from: a  reason: collision with other field name */
    public fo f390a;

    /* renamed from: a  reason: collision with other field name */
    public final String f391a;

    /* renamed from: a  reason: collision with other field name */
    public SimpleDateFormat f392a;

    /* renamed from: b  reason: collision with root package name */
    public a f77253b;

    /* loaded from: classes10.dex */
    public class a implements fq, fy {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ fj f77254a;

        /* renamed from: a  reason: collision with other field name */
        public String f393a;

        /* renamed from: a  reason: collision with other field name */
        public boolean f394a;

        public a(fj fjVar, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fjVar, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f77254a = fjVar;
            this.f394a = true;
            this.f394a = z;
            this.f393a = z ? " RCV " : " Sent ";
        }

        @Override // com.xiaomi.push.fq
        public void a(fa faVar) {
            StringBuilder sb;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, faVar) == null) {
                if (fj.f77252a) {
                    sb = new StringBuilder();
                    sb.append("[Slim] ");
                    sb.append(this.f77254a.f392a.format(new Date()));
                    sb.append(this.f393a);
                    str = faVar.toString();
                } else {
                    sb = new StringBuilder();
                    sb.append("[Slim] ");
                    sb.append(this.f77254a.f392a.format(new Date()));
                    sb.append(this.f393a);
                    sb.append(" Blob [");
                    sb.append(faVar.m305a());
                    sb.append(",");
                    sb.append(faVar.a());
                    sb.append(",");
                    sb.append(faVar.e());
                    str = PreferencesUtil.RIGHT_MOUNT;
                }
                sb.append(str);
                com.xiaomi.channel.commonutils.logger.b.c(sb.toString());
                if (faVar == null || faVar.a() != 99999) {
                    return;
                }
                String m305a = faVar.m305a();
                fa faVar2 = null;
                if (!this.f394a) {
                    if ("BIND".equals(m305a)) {
                        com.xiaomi.channel.commonutils.logger.b.m73a("build binded result for loopback.");
                        du.d dVar = new du.d();
                        dVar.a(true);
                        dVar.c("login success.");
                        dVar.b("success");
                        dVar.a("success");
                        fa faVar3 = new fa();
                        faVar3.a(dVar.m284a(), (String) null);
                        faVar3.a((short) 2);
                        faVar3.a(VideoItemModel.TYPE_LOADING);
                        faVar3.a("BIND", (String) null);
                        faVar3.a(faVar.e());
                        faVar3.b(null);
                        faVar3.c(faVar.g());
                        faVar2 = faVar3;
                    } else if (!"UBND".equals(m305a) && "SECMSG".equals(m305a)) {
                        fa faVar4 = new fa();
                        faVar4.a(VideoItemModel.TYPE_LOADING);
                        faVar4.a("SECMSG", (String) null);
                        faVar4.c(faVar.g());
                        faVar4.a(faVar.e());
                        faVar4.a(faVar.m307a());
                        faVar4.b(faVar.f());
                        faVar4.a(faVar.m310a(com.xiaomi.push.service.av.a().a(String.valueOf((int) VideoItemModel.TYPE_LOADING), faVar.g()).f77756h), (String) null);
                        faVar2 = faVar4;
                    }
                }
                if (faVar2 != null) {
                    for (Map.Entry<fq, fl.a> entry : this.f77254a.f389a.m325a().entrySet()) {
                        if (this.f77254a.f388a != entry.getKey()) {
                            entry.getValue().a(faVar2);
                        }
                    }
                }
            }
        }

        @Override // com.xiaomi.push.fq, com.xiaomi.push.fy
        public void a(gc gcVar) {
            StringBuilder sb;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gcVar) == null) {
                if (fj.f77252a) {
                    sb = new StringBuilder();
                    sb.append("[Slim] ");
                    sb.append(this.f77254a.f392a.format(new Date()));
                    sb.append(this.f393a);
                    sb.append(" PKT ");
                    str = gcVar.m348a();
                } else {
                    sb = new StringBuilder();
                    sb.append("[Slim] ");
                    sb.append(this.f77254a.f392a.format(new Date()));
                    sb.append(this.f393a);
                    sb.append(" PKT [");
                    sb.append(gcVar.k());
                    sb.append(",");
                    sb.append(gcVar.j());
                    str = PreferencesUtil.RIGHT_MOUNT;
                }
                sb.append(str);
                com.xiaomi.channel.commonutils.logger.b.c(sb.toString());
            }
        }

        @Override // com.xiaomi.push.fq, com.xiaomi.push.fy
        public boolean a(gc gcVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, gcVar)) == null) {
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-56374788, "Lcom/xiaomi/push/fj;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-56374788, "Lcom/xiaomi/push/fj;");
        }
    }

    public fj(fl flVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {flVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f392a = new SimpleDateFormat("hh:mm:ss aaa");
        this.f389a = null;
        this.f388a = null;
        this.f77253b = null;
        this.f390a = null;
        this.f391a = "[Slim] ";
        this.f389a = flVar;
        a();
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this) == null) {
            this.f388a = new a(this, true);
            this.f77253b = new a(this, false);
            fl flVar = this.f389a;
            a aVar = this.f388a;
            flVar.a(aVar, aVar);
            fl flVar2 = this.f389a;
            a aVar2 = this.f77253b;
            flVar2.b(aVar2, aVar2);
            this.f390a = new fk(this);
        }
    }
}

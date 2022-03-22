package com.xiaomi.push;

import com.baidu.android.imsdk.internal.Constants;
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
/* loaded from: classes7.dex */
public class fj implements fx {
    public static /* synthetic */ Interceptable $ic;
    public static boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public a f365a;

    /* renamed from: a  reason: collision with other field name */
    public fl f366a;

    /* renamed from: a  reason: collision with other field name */
    public fo f367a;

    /* renamed from: a  reason: collision with other field name */
    public final String f368a;

    /* renamed from: a  reason: collision with other field name */
    public SimpleDateFormat f369a;

    /* renamed from: b  reason: collision with root package name */
    public a f44245b;

    /* loaded from: classes7.dex */
    public class a implements fq, fy {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fj a;

        /* renamed from: a  reason: collision with other field name */
        public String f370a;

        /* renamed from: a  reason: collision with other field name */
        public boolean f371a;

        public a(fj fjVar, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fjVar, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fjVar;
            this.f371a = true;
            this.f371a = z;
            this.f370a = z ? " RCV " : " Sent ";
        }

        @Override // com.xiaomi.push.fq
        public void a(fa faVar) {
            StringBuilder sb;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, faVar) == null) {
                if (fj.a) {
                    sb = new StringBuilder();
                    sb.append("[Slim] ");
                    sb.append(this.a.f369a.format(new Date()));
                    sb.append(this.f370a);
                    str = faVar.toString();
                } else {
                    sb = new StringBuilder();
                    sb.append("[Slim] ");
                    sb.append(this.a.f369a.format(new Date()));
                    sb.append(this.f370a);
                    sb.append(" Blob [");
                    sb.append(faVar.m344a());
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
                String m344a = faVar.m344a();
                fa faVar2 = null;
                if (!this.f371a) {
                    if ("BIND".equals(m344a)) {
                        com.xiaomi.channel.commonutils.logger.b.m112a("build binded result for loopback.");
                        du.d dVar = new du.d();
                        dVar.a(true);
                        dVar.c("login success.");
                        dVar.b("success");
                        dVar.a("success");
                        fa faVar3 = new fa();
                        faVar3.a(dVar.m323a(), (String) null);
                        faVar3.a((short) 2);
                        faVar3.a(VideoItemModel.TYPE_LOADING);
                        faVar3.a("BIND", (String) null);
                        faVar3.a(faVar.e());
                        faVar3.b(null);
                        faVar3.c(faVar.g());
                        faVar2 = faVar3;
                    } else if (!"UBND".equals(m344a) && "SECMSG".equals(m344a)) {
                        fa faVar4 = new fa();
                        faVar4.a(VideoItemModel.TYPE_LOADING);
                        faVar4.a("SECMSG", (String) null);
                        faVar4.c(faVar.g());
                        faVar4.a(faVar.e());
                        faVar4.a(faVar.m346a());
                        faVar4.b(faVar.f());
                        faVar4.a(faVar.m349a(com.xiaomi.push.service.av.a().a(String.valueOf((int) VideoItemModel.TYPE_LOADING), faVar.g()).f44552h), (String) null);
                        faVar2 = faVar4;
                    }
                }
                if (faVar2 != null) {
                    for (Map.Entry<fq, fl.a> entry : this.a.f366a.m364a().entrySet()) {
                        if (this.a.f365a != entry.getKey()) {
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
                if (fj.a) {
                    sb = new StringBuilder();
                    sb.append("[Slim] ");
                    sb.append(this.a.f369a.format(new Date()));
                    sb.append(this.f370a);
                    sb.append(" PKT ");
                    str = gcVar.m387a();
                } else {
                    sb = new StringBuilder();
                    sb.append("[Slim] ");
                    sb.append(this.a.f369a.format(new Date()));
                    sb.append(this.f370a);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f369a = new SimpleDateFormat("hh:mm:ss aaa");
        this.f366a = null;
        this.f365a = null;
        this.f44245b = null;
        this.f367a = null;
        this.f368a = "[Slim] ";
        this.f366a = flVar;
        a();
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, this) == null) {
            this.f365a = new a(this, true);
            this.f44245b = new a(this, false);
            fl flVar = this.f366a;
            a aVar = this.f365a;
            flVar.a(aVar, aVar);
            fl flVar2 = this.f366a;
            a aVar2 = this.f44245b;
            flVar2.b(aVar2, aVar2);
            this.f367a = new fk(this);
        }
    }
}

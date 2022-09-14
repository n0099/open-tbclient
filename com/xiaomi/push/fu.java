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
import com.xiaomi.push.dx;
import com.xiaomi.push.fw;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
/* loaded from: classes8.dex */
public class fu implements gi {
    public static /* synthetic */ Interceptable $ic;
    public static boolean a;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with other field name */
    public a f397a;

    /* renamed from: a  reason: collision with other field name */
    public fw f398a;

    /* renamed from: a  reason: collision with other field name */
    public fz f399a;

    /* renamed from: a  reason: collision with other field name */
    public final String f400a;

    /* renamed from: a  reason: collision with other field name */
    public SimpleDateFormat f401a;
    public a b;

    /* loaded from: classes8.dex */
    public class a implements gb, gj {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fu a;

        /* renamed from: a  reason: collision with other field name */
        public String f402a;

        /* renamed from: a  reason: collision with other field name */
        public boolean f403a;

        public a(fu fuVar, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fuVar, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fuVar;
            this.f403a = true;
            this.f403a = z;
            this.f402a = z ? " RCV " : " Sent ";
        }

        @Override // com.xiaomi.push.gb
        public void a(fl flVar) {
            StringBuilder sb;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, flVar) == null) {
                if (fu.a) {
                    sb = new StringBuilder();
                    sb.append("[Slim] ");
                    sb.append(this.a.f401a.format(new Date()));
                    sb.append(this.f402a);
                    str = flVar.toString();
                } else {
                    sb = new StringBuilder();
                    sb.append("[Slim] ");
                    sb.append(this.a.f401a.format(new Date()));
                    sb.append(this.f402a);
                    sb.append(" Blob [");
                    sb.append(flVar.m336a());
                    sb.append(",");
                    sb.append(flVar.a());
                    sb.append(",");
                    sb.append(flVar.e());
                    str = PreferencesUtil.RIGHT_MOUNT;
                }
                sb.append(str);
                com.xiaomi.channel.commonutils.logger.b.c(sb.toString());
                if (flVar == null || flVar.a() != 99999) {
                    return;
                }
                String m336a = flVar.m336a();
                fl flVar2 = null;
                if (!this.f403a) {
                    if ("BIND".equals(m336a)) {
                        com.xiaomi.channel.commonutils.logger.b.m90a("build binded result for loopback.");
                        dx.d dVar = new dx.d();
                        dVar.a(true);
                        dVar.c("login success.");
                        dVar.b("success");
                        dVar.a("success");
                        fl flVar3 = new fl();
                        flVar3.a(dVar.m304a(), (String) null);
                        flVar3.a((short) 2);
                        flVar3.a(VideoItemModel.TYPE_LOADING);
                        flVar3.a("BIND", (String) null);
                        flVar3.a(flVar.e());
                        flVar3.b((String) null);
                        flVar3.c(flVar.g());
                        flVar2 = flVar3;
                    } else if (!"UBND".equals(m336a) && "SECMSG".equals(m336a)) {
                        fl flVar4 = new fl();
                        flVar4.a(VideoItemModel.TYPE_LOADING);
                        flVar4.a("SECMSG", (String) null);
                        flVar4.c(flVar.g());
                        flVar4.a(flVar.e());
                        flVar4.a(flVar.m338a());
                        flVar4.b(flVar.f());
                        flVar4.a(flVar.m341a(com.xiaomi.push.service.bg.a().a(String.valueOf((int) VideoItemModel.TYPE_LOADING), flVar.g()).h), (String) null);
                        flVar2 = flVar4;
                    }
                }
                if (flVar2 != null) {
                    for (Map.Entry<gb, fw.a> entry : this.a.f398a.m356a().entrySet()) {
                        if (this.a.f397a != entry.getKey()) {
                            entry.getValue().a(flVar2);
                        }
                    }
                }
            }
        }

        @Override // com.xiaomi.push.gb, com.xiaomi.push.gj
        public void a(gn gnVar) {
            StringBuilder sb;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gnVar) == null) {
                if (fu.a) {
                    sb = new StringBuilder();
                    sb.append("[Slim] ");
                    sb.append(this.a.f401a.format(new Date()));
                    sb.append(this.f402a);
                    sb.append(" PKT ");
                    str = gnVar.m372a();
                } else {
                    sb = new StringBuilder();
                    sb.append("[Slim] ");
                    sb.append(this.a.f401a.format(new Date()));
                    sb.append(this.f402a);
                    sb.append(" PKT [");
                    sb.append(gnVar.k());
                    sb.append(",");
                    sb.append(gnVar.j());
                    str = PreferencesUtil.RIGHT_MOUNT;
                }
                sb.append(str);
                com.xiaomi.channel.commonutils.logger.b.c(sb.toString());
            }
        }

        @Override // com.xiaomi.push.gb, com.xiaomi.push.gj
        public boolean a(gn gnVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, gnVar)) == null) {
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-56374447, "Lcom/xiaomi/push/fu;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-56374447, "Lcom/xiaomi/push/fu;");
        }
    }

    public fu(fw fwVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fwVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f401a = new SimpleDateFormat("hh:mm:ss aaa");
        this.f398a = null;
        this.f397a = null;
        this.b = null;
        this.f399a = null;
        this.f400a = "[Slim] ";
        this.f398a = fwVar;
        a();
    }

    private void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, this) == null) {
            this.f397a = new a(this, true);
            this.b = new a(this, false);
            fw fwVar = this.f398a;
            a aVar = this.f397a;
            fwVar.a(aVar, aVar);
            fw fwVar2 = this.f398a;
            a aVar2 = this.b;
            fwVar2.b(aVar2, aVar2);
            this.f399a = new fv(this);
        }
    }
}

package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kuaishou.weapon.p0.jni.Engine;
import com.kwad.sdk.c.b;
import org.json.JSONObject;
/* renamed from: com.kuaishou.weapon.p0.ʻᵢ  reason: contains not printable characters */
/* loaded from: classes5.dex */
public class C0313 {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: ʾ  reason: contains not printable characters */
    public static final byte[] f55;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: ʻ  reason: contains not printable characters */
    public Context f56;

    /* renamed from: ʼ  reason: contains not printable characters */
    public boolean f57;

    /* renamed from: ʽ  reason: contains not printable characters */
    public int f58;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(335392176, "Lcom/kuaishou/weapon/p0/ʻᵢ;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(335392176, "Lcom/kuaishou/weapon/p0/ʻᵢ;");
                return;
            }
        }
        f55 = new byte[0];
    }

    public C0313(Context context, int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i), Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f56 = context;
        this.f57 = z;
        this.f58 = i;
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public String m213(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            try {
                synchronized (f55) {
                    JSONObject m253 = new C0333(str, C0331.f85).m253(this.f56);
                    if (m253 == null) {
                        return null;
                    }
                    JSONObject m214 = m214();
                    if (m214 == null) {
                        return null;
                    }
                    m253.put("module_section", m214);
                    return m253.toString();
                }
            } catch (Throwable unused) {
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r3v3 double)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r3v4 double)] */
    /* JADX WARN: Removed duplicated region for block: B:223:0x04ee A[Catch: all -> 0x0551, TRY_ENTER, TryCatch #1 {all -> 0x0551, blocks: (B:164:0x0393, B:166:0x039b, B:167:0x03a0, B:170:0x03b8, B:172:0x03c5, B:174:0x03ce, B:176:0x03d7, B:178:0x03e0, B:180:0x03e9, B:182:0x03f2, B:184:0x03fb, B:186:0x0404, B:188:0x040d, B:190:0x0416, B:192:0x041f, B:194:0x0428, B:196:0x0431, B:198:0x043a, B:200:0x0443, B:202:0x044c, B:204:0x0455, B:206:0x045e, B:208:0x0467, B:210:0x0470, B:214:0x04b6, B:216:0x04c1, B:218:0x04cc, B:220:0x04d5, B:223:0x04ee, B:225:0x04fb, B:227:0x0501, B:229:0x050a, B:231:0x0510, B:233:0x0519, B:235:0x051f, B:237:0x0528, B:238:0x052c, B:240:0x0530, B:209:0x046c, B:205:0x045a, B:201:0x0448, B:197:0x0436, B:193:0x0424, B:189:0x0412, B:185:0x0400, B:181:0x03ee, B:177:0x03dc, B:173:0x03ca, B:211:0x0474), top: B:263:0x0393 }] */
    /* JADX WARN: Removed duplicated region for block: B:268:0x0530 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: ʻ  reason: contains not printable characters */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public JSONObject m214() {
        InterceptResult invokeV;
        Object m121;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            try {
                JSONObject jSONObject = new JSONObject();
                C0374 m389 = C0374.m389(this.f56);
                C0374 m3892 = C0374.m389(this.f56);
                boolean m408 = m3892.m408("a1_p_s_p_s");
                boolean m4082 = m3892.m408("a1_p_s_p_s_c_b");
                jSONObject.put("11006", m408 ? 1 : 0);
                jSONObject.put("11029", m4082 ? 1 : 0);
                if (m389.m392(C0374.f239, 1) == 1 && (m408 || m4082)) {
                    String m885 = C0433.m885(this.f56);
                    if (!TextUtils.isEmpty(m885) && !m885.startsWith("RISK")) {
                        jSONObject.put("01001", C0304.m174(m885));
                    }
                    String m894 = C0433.m894(this.f56);
                    if (!TextUtils.isEmpty(m894) && !m894.startsWith("RISK")) {
                        jSONObject.put("01003", m894);
                    }
                    String m870 = C0433.m870(this.f56, 0);
                    if (!TextUtils.isEmpty(m870) && !m870.startsWith("RISK")) {
                        jSONObject.put("01019", m870);
                    }
                    String m8702 = C0433.m870(this.f56, 1);
                    if (!TextUtils.isEmpty(m8702) && !m8702.startsWith("RISK")) {
                        jSONObject.put("01004", C0304.m174(m8702));
                    }
                }
                int m392 = m389.m392(C0374.f238, 1);
                if (m392 == 1 && (m408 || m4082)) {
                    String m865 = C0433.m865(this.f56);
                    if (!TextUtils.isEmpty(m865) && !m865.startsWith("RISK")) {
                        jSONObject.put("01013", m865);
                    }
                }
                if (m389.m392(C0374.f240, 1) == 1 && (m408 || m4082)) {
                    String m898 = C0433.m898(this.f56);
                    if (!TextUtils.isEmpty(m898) && !m898.startsWith("RISK")) {
                        jSONObject.put("01007", m898);
                    }
                }
                if (m389.m392(C0374.f241, 1) == 1 && (m408 || m4082)) {
                    jSONObject.put("01011", C0433.m893(this.f56));
                }
                if (m408 || m4082) {
                    String m878 = C0433.m878();
                    if ((TextUtils.isEmpty(m878) || m878.startsWith("RISK")) && m878 == null) {
                        jSONObject.put("07005", "");
                    } else {
                        jSONObject.put("07005", m878);
                    }
                }
                if (m389.m392(C0374.f243, 1) == 1 && (m408 || m4082)) {
                    String m879 = C0433.m879(this.f56);
                    if (!TextUtils.isEmpty(m879) && !m879.startsWith("RISK")) {
                        jSONObject.put("01016", m879);
                    }
                }
                if (m408 || m4082) {
                    try {
                        double m873 = C0433.m873();
                        if (m873 > 0.0d) {
                            StringBuilder sb = new StringBuilder();
                            sb.append(m873);
                            jSONObject.put("09002", sb.toString());
                        }
                        double m876 = C0433.m876();
                        if (m876 > 0.0d) {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append(m876);
                            jSONObject.put("09003", sb2.toString());
                        }
                    } catch (Exception unused) {
                    }
                }
                jSONObject.put("11013", Integer.parseInt(C0314.m215(this.f56.getApplicationContext()), 2));
                jSONObject.put("11012", C0314.m220(this.f56));
                jSONObject.put("11011", C0433.m901(this.f56));
                try {
                    jSONObject.put("11202", C0433.m858(b.t().c()));
                    jSONObject.put("11203", C0433.m858(b.t().p()));
                    jSONObject.put("11204", C0433.m858(b.t().k()));
                    jSONObject.put("11205", C0433.m858(b.t().l()));
                    jSONObject.put("11206", C0433.m858(b.t().h()));
                    jSONObject.put("11207", C0433.m858(b.t().a()));
                    jSONObject.put("11208", C0433.m858(b.t().e()));
                    jSONObject.put("11209", C0433.m858(b.t().f()));
                    jSONObject.put("11210", C0433.m858(b.t().g()));
                    jSONObject.put("11211", C0433.m858(b.t().m()));
                    jSONObject.put("11212", C0433.m858(b.t().o()));
                    jSONObject.put("11213", C0433.m858(b.t().b()));
                    jSONObject.put("11214", C0433.m858(b.t().d()));
                    jSONObject.put("11215", C0433.m858(b.t().j()));
                    jSONObject.put("11216", C0433.m858(b.t().i()));
                    jSONObject.put("11301", C0433.m867(b.t().q()));
                    jSONObject.put("11302", C0433.m867(b.t().r()));
                    jSONObject.put("11303", C0433.m867(b.t().s()));
                    jSONObject.put("11104", b.t().k());
                    jSONObject.put("11105", b.t().l());
                    jSONObject.put("11106", b.t().h());
                    jSONObject.put("11107", b.t().a());
                    jSONObject.put("11108", b.t().e());
                    jSONObject.put("11109", b.t().f());
                    jSONObject.put("11110", b.t().g());
                    jSONObject.put("11111", b.t().m());
                    jSONObject.put("11112", b.t().o());
                    jSONObject.put("11113", b.t().b());
                    jSONObject.put("11114", b.t().d());
                    jSONObject.put("11115", b.t().j());
                    jSONObject.put("11116", b.t().i());
                } catch (Throwable unused2) {
                }
                String m903 = C0433.m903(this.f56);
                if (!TextUtils.isEmpty(m903)) {
                    jSONObject.put("01026", m903);
                }
                if (m392 == 1) {
                    try {
                        Object m954 = C0443.m954(this.f56);
                        if (m954 != null) {
                            jSONObject.put("11015", m954);
                        }
                        if (Engine.loadSuccess) {
                            C0323 c0323 = new C0323(this.f56);
                            jSONObject.put("02001", c0323.m231("02001") != null ? c0323.m231("02001") : C0295.m135());
                            jSONObject.put("02002", c0323.m231("02002") != null ? c0323.m231("02002") : C0295.m114());
                            jSONObject.put("02003", c0323.m231("02003") != null ? c0323.m231("02003") : C0295.m136());
                            jSONObject.put("02007", c0323.m231("02007") != null ? c0323.m231("02007") : C0295.m109());
                            jSONObject.put("02006", c0323.m231("02006") != null ? c0323.m231("02006") : C0295.m123());
                            jSONObject.put("02004", c0323.m231("02004") != null ? c0323.m231("02004") : C0295.m128());
                            jSONObject.put("02005", c0323.m231("02005") != null ? c0323.m231("02005") : C0295.m139());
                            jSONObject.put("02018", c0323.m231("02018") != null ? c0323.m231("02018") : C0295.m125());
                            jSONObject.put("02013", c0323.m231("02013") != null ? c0323.m231("02013") : C0295.m117());
                            if (c0323.m231("02016") != null) {
                                m121 = c0323.m231("02016");
                                jSONObject.put("02016", m121);
                                jSONObject.put("02021", C0295.m106(this.f56));
                                jSONObject.put("02022", C0295.m115(this.f56));
                                jSONObject.put("02044", C0295.m107());
                                jSONObject.put("11009", C0309.m196(this.f56.getApplicationContext()));
                                if (Engine.loadSuccess) {
                                    try {
                                        C0293 m90 = C0294.m90();
                                        jSONObject.put("04001", C0294.m89());
                                        jSONObject.put("04002", m90.m88());
                                        jSONObject.put("04003", m90.m83());
                                        jSONObject.put("04004", m90.m86());
                                    } catch (Exception unused3) {
                                    }
                                } else {
                                    C0316 c0316 = new C0316(this.f56);
                                    jSONObject.put("04001", c0316.m223("04001") != null ? c0316.m223("04001") : "");
                                    jSONObject.put("04002", c0316.m223("04002") != null ? c0316.m223("04002") : "");
                                    jSONObject.put("04003", c0316.m223("04003") != null ? c0316.m223("04003") : "");
                                    jSONObject.put("04004", c0316.m223("04004") != null ? c0316.m223("04004") : "");
                                }
                            }
                        } else {
                            jSONObject.put("02001", C0295.m135());
                            jSONObject.put("02002", C0295.m114());
                            jSONObject.put("02003", C0295.m136());
                            jSONObject.put("02004", C0295.m128());
                            jSONObject.put("02005", C0295.m139());
                            jSONObject.put("02006", C0295.m123());
                            jSONObject.put("02007", C0295.m109());
                            jSONObject.put("02018", C0295.m125());
                            jSONObject.put("02013", C0295.m117());
                        }
                        m121 = C0295.m121();
                        jSONObject.put("02016", m121);
                        jSONObject.put("02021", C0295.m106(this.f56));
                        jSONObject.put("02022", C0295.m115(this.f56));
                        jSONObject.put("02044", C0295.m107());
                        jSONObject.put("11009", C0309.m196(this.f56.getApplicationContext()));
                        if (Engine.loadSuccess) {
                        }
                    } catch (Throwable unused4) {
                        return null;
                    }
                }
                if (this.f57) {
                    jSONObject.put("20004", 1);
                }
                jSONObject.put("11017", jSONObject.toString().length());
                jSONObject.put("20000", this.f58);
                jSONObject.put("11028", WeaponHI.sKSSdkver);
                return jSONObject;
            } catch (Throwable unused5) {
                return null;
            }
        }
        return (JSONObject) invokeV.objValue;
    }
}

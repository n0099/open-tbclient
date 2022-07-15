package com.kuaishou.weapon.p0;

import android.content.Context;
import android.os.SystemClock;
import android.provider.Settings;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kuaishou.weapon.p0.jni.A;
import com.kuaishou.weapon.p0.jni.Engine;
import com.kwad.sdk.c.b;
import org.json.JSONArray;
import org.json.JSONObject;
/* renamed from: com.kuaishou.weapon.p0.ʼـ  reason: contains not printable characters */
/* loaded from: classes5.dex */
public class C0334 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: ʻ  reason: contains not printable characters */
    public Context f118;

    /* renamed from: ʼ  reason: contains not printable characters */
    public int f119;

    public C0334(Context context, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f118 = context;
        this.f119 = i;
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public String m277(String str) {
        InterceptResult invokeL;
        JSONObject m278;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            try {
                JSONObject m253 = new C0333(str, C0331.f85).m253(this.f118);
                if (m253 == null || (m278 = m278()) == null) {
                    return null;
                }
                m253.put("module_section", m278);
                return m253.toString();
            } catch (Throwable unused) {
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r6v2 double)] */
    /* JADX DEBUG: TODO: convert one arg to string using `String.valueOf()`, args: [(r6v3 double)] */
    /* JADX DEBUG: Throwable added to exception handler: 'Exception', keep only Throwable */
    /* renamed from: ʻ  reason: contains not printable characters */
    public JSONObject m278() {
        InterceptResult invokeV;
        long j;
        C0374 c0374;
        boolean z;
        boolean z2;
        String str;
        String str2;
        C0334 c0334;
        String m234;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            try {
                long currentTimeMillis = System.currentTimeMillis();
                JSONObject jSONObject = new JSONObject();
                C0374 m389 = C0374.m389(this.f118);
                C0374 m3892 = C0374.m389(this.f118);
                boolean m408 = m3892.m408("a1_p_s_p_s");
                boolean m4082 = m3892.m408("a1_p_s_p_s_c_b");
                if (m389.m392(C0374.f260, 1) == 1 && (m408 || m4082)) {
                    String m885 = C0433.m885(this.f118);
                    if (!TextUtils.isEmpty(m885) && !m885.startsWith("RISK")) {
                        jSONObject.put("01001", m885);
                    }
                    String m894 = C0433.m894(this.f118);
                    if (!TextUtils.isEmpty(m894) && !m894.startsWith("RISK")) {
                        jSONObject.put("01003", m894);
                    }
                    String m870 = C0433.m870(this.f118, 0);
                    if (!TextUtils.isEmpty(m870) && !m870.startsWith("RISK")) {
                        jSONObject.put("01019", m870);
                    }
                    String m8702 = C0433.m870(this.f118, 1);
                    if (!TextUtils.isEmpty(m8702) && !m8702.startsWith("RISK")) {
                        jSONObject.put("01004", m8702);
                    }
                }
                if (m389.m392(C0374.f261, 1) == 1 && (m408 || m4082)) {
                    String m898 = C0433.m898(this.f118);
                    if (!TextUtils.isEmpty(m898) && !m898.startsWith("RISK")) {
                        jSONObject.put("01007", m898);
                    }
                }
                if (m389.m392(C0374.f262, 1) == 1 && (m408 || m4082)) {
                    jSONObject.put("01011", C0433.m893(this.f118));
                }
                if (m389.m392(C0374.f263, 1) == 1 && (m408 || m4082)) {
                    String m879 = C0433.m879(this.f118);
                    if (!TextUtils.isEmpty(m879) && !m879.startsWith("RISK")) {
                        jSONObject.put("01016", m879);
                    }
                }
                try {
                    if (m389.m392(C0374.f251, 1) == 1) {
                        if (m408 || m4082) {
                            String m865 = C0433.m865(this.f118);
                            if (!TextUtils.isEmpty(m865) && !m865.startsWith("RISK")) {
                                jSONObject.put("01013", m865);
                            }
                            jSONObject.put("02042", C0433.m850(this.f118));
                            jSONObject.put("02024", C0325.m235(this.f118));
                            jSONObject.put("02066", C0325.m236(this.f118));
                        }
                        jSONObject.put("02054", C0433.m868(this.f118));
                        j = currentTimeMillis;
                        str = "RISK";
                        z = m4082;
                        z2 = m408;
                        try {
                            if (Engine.loadSuccess) {
                                try {
                                    jSONObject.put("02019", C0295.m118(this.f118));
                                    jSONObject.put("02021", C0295.m106(this.f118));
                                    jSONObject.put("02022", C0295.m115(this.f118));
                                    jSONObject.put("02030", C0295.m97(this.f118));
                                    C0323 c0323 = new C0323(this.f118);
                                    try {
                                        jSONObject.put("01014", c0323.m231("01014") != null ? c0323.m231("01014") : "");
                                        jSONObject.put("02001", c0323.m231("02001") != null ? c0323.m231("02001") : C0295.m135());
                                        jSONObject.put("02002", c0323.m231("02002") != null ? c0323.m231("02002") : C0295.m114());
                                        jSONObject.put("02003", c0323.m231("02003") != null ? c0323.m231("02003") : C0295.m136());
                                        jSONObject.put("02004", c0323.m231("02004") != null ? c0323.m231("02004") : C0295.m128());
                                        jSONObject.put("02005", c0323.m231("02005") != null ? c0323.m231("02005") : C0295.m139());
                                        jSONObject.put("02006", c0323.m231("02006") != null ? c0323.m231("02006") : C0295.m123());
                                        jSONObject.put("02007", c0323.m231("02007") != null ? c0323.m231("02007") : C0295.m109());
                                        jSONObject.put("02008", c0323.m231("02008") != null ? c0323.m231("02008") : C0295.m131());
                                        jSONObject.put("02009", c0323.m231("02009") != null ? c0323.m231("02009") : C0295.m116());
                                        jSONObject.put("02010", c0323.m231("02010") != null ? c0323.m231("02010") : C0295.m110());
                                        jSONObject.put("02011", c0323.m231("02011") != null ? c0323.m231("02011") : C0295.m104());
                                        jSONObject.put("02012", c0323.m231("02012") != null ? c0323.m231("02012") : C0295.m112());
                                        jSONObject.put("02013", c0323.m231("02013") != null ? c0323.m231("02013") : C0295.m117());
                                        jSONObject.put("02014", c0323.m231("02014") != null ? c0323.m231("02014") : C0295.m124());
                                        jSONObject.put("02015", c0323.m231("02015") != null ? c0323.m231("02015") : C0295.m134());
                                        jSONObject.put("02016", c0323.m231("02016") != null ? c0323.m231("02016") : C0295.m121());
                                        jSONObject.put("02017", c0323.m231("02017") != null ? c0323.m231("02017") : Integer.valueOf(C0295.m92()));
                                        jSONObject.put("02018", c0323.m231("02018") != null ? c0323.m231("02018") : C0295.m125());
                                        jSONObject.put("02020", c0323.m231("02020") != null ? c0323.m231("02020") : C0295.m113());
                                        if (c0323.m231("02023") != null) {
                                            m234 = c0323.m231("02023");
                                            c0334 = this;
                                        } else {
                                            c0334 = this;
                                            try {
                                                m234 = C0325.m234(c0334.f118);
                                            } catch (Exception unused) {
                                            }
                                        }
                                        jSONObject.put("02023", m234);
                                        jSONObject.put("02031", c0323.m231("02031") != null ? c0323.m231("02031") : C0295.m137());
                                        jSONObject.put("02032", c0323.m231("02032") != null ? c0323.m231("02032") : C0295.m120());
                                        jSONObject.put("02033", c0323.m231("02033") != null ? c0323.m231("02033") : C0295.m133());
                                        jSONObject.put("02034", c0323.m231("02034") != null ? c0323.m231("02034") : C0295.m129());
                                        jSONObject.put("02035", c0323.m231("02035") != null ? c0323.m231("02035") : C0295.m103());
                                        jSONObject.put("02036", c0323.m231("02036") != null ? c0323.m231("02036") : "");
                                        jSONObject.put("02037", c0323.m231("02037") != null ? c0323.m231("02037") : C0295.m122());
                                        jSONObject.put("02038", c0323.m231("02038") != null ? c0323.m231("02038") : C0295.m140());
                                        jSONObject.put("02045", c0323.m231("02045") != null ? c0323.m231("02045") : C0295.m105());
                                    } catch (Exception unused2) {
                                        c0334 = this;
                                    }
                                } catch (Exception unused3) {
                                    c0334 = this;
                                }
                            } else {
                                jSONObject.put("02001", C0295.m135());
                                jSONObject.put("02002", C0295.m114());
                                jSONObject.put("02003", C0295.m136());
                                jSONObject.put("02004", C0295.m128());
                                jSONObject.put("02005", C0295.m139());
                                jSONObject.put("02006", C0295.m123());
                                jSONObject.put("02007", C0295.m109());
                                jSONObject.put("02008", C0295.m131());
                                jSONObject.put("02009", C0295.m116());
                                jSONObject.put("02010", C0295.m110());
                                jSONObject.put("02011", C0295.m104());
                                jSONObject.put("02012", C0295.m112());
                                jSONObject.put("02013", C0295.m117());
                                jSONObject.put("02014", C0295.m124());
                                jSONObject.put("02015", C0295.m134());
                                jSONObject.put("02016", C0295.m121());
                                jSONObject.put("02017", C0295.m92());
                                jSONObject.put("02018", C0295.m125());
                                c0334 = this;
                                jSONObject.put("02019", C0295.m118(c0334.f118));
                                jSONObject.put("02020", C0295.m113());
                                jSONObject.put("02021", C0295.m106(c0334.f118));
                                jSONObject.put("02022", C0295.m115(c0334.f118));
                                jSONObject.put("02023", C0325.m234(c0334.f118));
                                jSONObject.put("02030", C0295.m97(c0334.f118));
                                jSONObject.put("02031", C0295.m137());
                                jSONObject.put("02032", C0295.m120());
                                jSONObject.put("02033", C0295.m133());
                                jSONObject.put("02034", C0295.m129());
                                jSONObject.put("02035", C0295.m103());
                                jSONObject.put("02037", C0295.m122());
                                jSONObject.put("02038", C0295.m140());
                                jSONObject.put("02045", C0295.m105());
                            }
                            str2 = "";
                            jSONObject.put("02067", c0334.f118.getApplicationContext().getPackageResourcePath().replace("/data/app/", str2).replace("/base.apk", str2));
                            jSONObject.put("02039", C0433.m859());
                            jSONObject.put("02040", C0433.m864());
                            jSONObject.put("02041", C0433.m905(c0334.f118));
                            jSONObject.put("02043", C0433.m902(c0334.f118));
                            jSONObject.put("02044", C0295.m107());
                            jSONObject.put("02046", C0295.m138());
                            String m854 = C0433.m854("persist.service.adb.enable");
                            if (!TextUtils.isEmpty(m854)) {
                                jSONObject.put("03058", m854);
                            }
                            String m8542 = C0433.m854("sys.resettype");
                            if (!TextUtils.isEmpty(m8542)) {
                                jSONObject.put("03057", m8542);
                            }
                            String m8543 = C0433.m854("ro.boot.bootreason");
                            if (!TextUtils.isEmpty(m8543)) {
                                jSONObject.put("03056", m8543);
                            }
                            String m8544 = C0433.m854("ro.runtime.firstboot");
                            if (!TextUtils.isEmpty(m8544)) {
                                jSONObject.put("03055", m8544);
                            }
                            String m8545 = C0433.m854("init.svc.atcmdserver");
                            if (!TextUtils.isEmpty(m8545)) {
                                jSONObject.put("03054", m8545);
                            }
                            String m8546 = C0433.m854("ro.build.date.utc");
                            if (!TextUtils.isEmpty(m8546)) {
                                jSONObject.put("03061", m8546);
                            }
                            String m8547 = C0433.m854("ro.bootimage.build.date.utc");
                            if (!TextUtils.isEmpty(m8547)) {
                                jSONObject.put("03062", m8547);
                            }
                            String m8548 = C0433.m854("ro.build.date.YmdHM");
                            if (!TextUtils.isEmpty(m8548)) {
                                jSONObject.put("03063", m8548);
                            }
                            String m8549 = C0433.m854("dhcp.ipv6.wlan0.dns1");
                            if (!TextUtils.isEmpty(m8549)) {
                                jSONObject.put("03067", m8549);
                            }
                            String m85410 = C0433.m854("dhcp.ipv6.wlan0.dns2");
                            if (!TextUtils.isEmpty(m85410)) {
                                jSONObject.put("03068", m85410);
                            }
                            String m85411 = C0433.m854("dhcp.wlan0.dns1");
                            if (!TextUtils.isEmpty(m85411)) {
                                jSONObject.put("03069", m85411);
                            }
                            String m85412 = C0433.m854("dhcp.wlan0.dns2");
                            if (!TextUtils.isEmpty(m85412)) {
                                jSONObject.put("03070", m85412);
                            }
                            String m85413 = C0433.m854("net.change");
                            if (!TextUtils.isEmpty(m85413)) {
                                jSONObject.put("03071", m85413);
                            }
                            String m85414 = C0433.m854("net.dns1");
                            if (!TextUtils.isEmpty(m85414)) {
                                jSONObject.put("03072", m85414);
                            }
                            String m85415 = C0433.m854("net.dns2");
                            if (!TextUtils.isEmpty(m85415)) {
                                jSONObject.put("03073", m85415);
                            }
                            c0374 = m389;
                            long m393 = c0374.m393(C0374.f295, -1L);
                            if (m393 != -1) {
                                jSONObject.put("03074", m393 + System.currentTimeMillis());
                            }
                            jSONObject.put("03064", Settings.System.getInt(c0334.f118.getContentResolver(), "screen_brightness_mode"));
                            jSONObject.put("03065", Settings.System.getInt(c0334.f118.getContentResolver(), "accelerometer_rotation"));
                            jSONObject.put("03081", C0295.m130());
                            jSONObject.put("03053", C0433.m904(c0334.f118));
                            jSONObject.put("03052", C0295.m119(c0334.f118));
                            jSONObject.put("03050", C0295.m108(c0334.f118));
                            jSONObject.put("03049", C0295.m111(c0334.f118));
                            jSONObject.put("02027", C0295.m132());
                            jSONObject.put("02028", C0295.m127());
                            jSONObject.put("02029", C0295.m100());
                            jSONObject.put("02057", C0295.m101());
                            jSONObject.put("02058", C0295.m94());
                        } catch (Throwable unused4) {
                            return null;
                        }
                    } else {
                        j = currentTimeMillis;
                        c0374 = m389;
                        z = m4082;
                        z2 = m408;
                        str = "RISK";
                        str2 = "";
                        c0334 = this;
                    }
                    if (c0374.m392(C0374.f252, 1) == 1) {
                        jSONObject.put("03001", C0298.m154());
                        jSONObject.put("03002", C0298.m156());
                        jSONObject.put("03001", C0298.m154());
                        jSONObject.put("03002", C0298.m156());
                        jSONObject.put("03043", SystemClock.elapsedRealtime());
                        jSONObject.put("03044", SystemClock.uptimeMillis());
                        jSONObject.put("03045", System.currentTimeMillis() - SystemClock.elapsedRealtime());
                        C0315 c0315 = new C0315(c0334.f118);
                        if (Engine.loadSuccess) {
                            jSONObject.put("03004", c0315.m222("03004") != null ? c0315.m222("03004") : str2);
                            jSONObject.put("03036", c0315.m221("03036") != null ? c0315.m221("03036") : str2);
                            jSONObject.put("03039", c0315.m222("03039") != null ? c0315.m222("03039") : str2);
                            jSONObject.put("03040", c0315.m222("03040") != null ? c0315.m222("03040") : str2);
                            jSONObject.put("03041", c0315.m222("03041") != null ? c0315.m222("03041") : str2);
                            jSONObject.put("03042", c0315.m222("03042") != null ? c0315.m222("03042") : str2);
                            jSONObject.put("03079", c0315.m222("03079") != null ? c0315.m222("03079") : null);
                            jSONObject.put("03080", c0315.m222("03080") != null ? c0315.m222("03080") : null);
                        }
                        jSONObject.put("03007", C0312.m211(c0334.f118));
                        jSONObject.put("03008", C0312.m210(c0334.f118));
                        jSONObject.put("03011", C0455.m1017(c0334.f118));
                        jSONObject.put("03012", C0455.m1016());
                        jSONObject.put("03014", C0433.m875(c0334.f118));
                        jSONObject.put("03034", C0433.m872(c0334.f118));
                        jSONObject.put("03020", C0312.m209(c0334.f118));
                        jSONObject.put("03037", C0295.m96());
                        jSONObject.put("03038", C0295.m98());
                        jSONObject.put("03077", C0295.m126());
                    }
                    try {
                        C0451 c0451 = new C0451();
                        jSONObject.put("03006", c0451.m1009(c0334.f118));
                        jSONObject.put("03010", c0451.m1012(c0334.f118));
                        jSONObject.put("03033", c0451.m1013(c0334.f118));
                        jSONObject.put("03013", c0451.m1010());
                        jSONObject.put("03021", c0451.m1008(c0334.f118));
                        jSONObject.put("03030", C0451.m1004(c0334.f118));
                        jSONObject.put("10020", c0451.m1011(c0334.f118));
                        jSONObject.put("10031", c0451.m1007());
                    } catch (Exception unused5) {
                    }
                    if (c0374.m392(C0374.f266, 1) == 1) {
                        jSONObject.put("03019", C0433.m883(c0334.f118));
                        String m900 = C0433.m900(c0334.f118);
                        if (!TextUtils.isEmpty(m900)) {
                            jSONObject.put("03046", m900);
                        }
                        String m888 = C0433.m888(c0334.f118);
                        if (!TextUtils.isEmpty(m888)) {
                            jSONObject.put("03047", m888);
                        }
                        jSONObject.put("03018", C0433.m860(c0334.f118));
                    }
                    if (c0374.m392(C0374.f267, 1) == 1) {
                        jSONObject.put("02059", C0296.m141(c0334.f118));
                        jSONObject.put("02060", C0296.m146());
                        jSONObject.put("02061", C0296.m145());
                        jSONObject.put("02062", C0296.m143());
                        if (Engine.loadSuccess) {
                            C0317 c0317 = new C0317(c0334.f118);
                            jSONObject.put("08001", c0317.m224("08001") != null ? c0317.m224("08001") : str2);
                        }
                        JSONObject m142 = C0296.m142();
                        if (m142 != null && m142.length() > 0) {
                            jSONObject.put("10050", m142);
                        }
                    }
                    if (c0374.m392(C0374.f265, 1) == 1 && (z2 || z)) {
                        jSONObject.put("03029", C0433.m899(c0334.f118));
                    }
                    if (c0374.m392(C0374.f253, 1) == 1) {
                        if (Engine.loadSuccess) {
                            C0316 c0316 = new C0316(c0334.f118);
                            jSONObject.put("04001", c0316.m223("04001") != null ? c0316.m223("04001") : str2);
                            jSONObject.put("04002", c0316.m223("04002") != null ? c0316.m223("04002") : str2);
                            jSONObject.put("04003", c0316.m223("04003") != null ? c0316.m223("04003") : str2);
                            jSONObject.put("04004", c0316.m223("04004") != null ? c0316.m223("04004") : str2);
                        } else {
                            try {
                                C0293 m90 = C0294.m90();
                                jSONObject.put("04001", C0294.m89());
                                jSONObject.put("04002", m90.m88());
                                jSONObject.put("04003", m90.m83());
                                jSONObject.put("04004", m90.m86());
                            } catch (Exception unused6) {
                            }
                        }
                    }
                    if (c0374.m392(C0374.f256, 0) == 1 && (z2 || z)) {
                        JSONArray m889 = C0433.m889();
                        if (m889 != null) {
                            jSONObject.put("06014", m889);
                        }
                        if (Engine.loadSuccess) {
                            C0324 c0324 = new C0324(c0334.f118);
                            jSONObject.put("06015", c0324.m232("06015") != null ? c0324.m232("06015") : str2);
                        }
                    }
                    if (z2 || z) {
                        String m878 = C0433.m878();
                        if ((TextUtils.isEmpty(m878) || m878.startsWith(str)) && m878 == null) {
                            jSONObject.put("07005", str2);
                        } else {
                            jSONObject.put("07005", m878);
                        }
                    }
                    if (c0374.m392(C0374.f254, 0) == 1 && (z2 || z)) {
                        if (Engine.loadSuccess) {
                            jSONObject.put("07007", new C0321(c0334.f118).m229("07007"));
                        }
                        JSONArray m178 = C0305.m178(c0334.f118);
                        if (m178 != null && m178.length() > 0) {
                            jSONObject.put("03035", m178);
                        }
                    }
                    if (z2 || z) {
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
                            jSONObject.put("09001", C0433.m884());
                        } catch (Exception unused7) {
                        }
                    }
                    if (c0374.m392(C0374.f258, 1) == 1 && (z2 || z)) {
                        jSONObject.put("10002", new C0408(c0334.f118).m582(1));
                    }
                    if (c0374.m392(C0374.f255, 1) == 1 && Engine.loadSuccess) {
                        String m230 = new C0322(c0334.f118).m230("05001");
                        try {
                            if (!TextUtils.isEmpty(m230) && m230.length() > 10) {
                                jSONObject.put("05001", new JSONArray(m230));
                            }
                        } catch (Exception unused8) {
                        }
                    }
                    if (Engine.loadSuccess) {
                        C0319 c0319 = new C0319(c0334.f118);
                        jSONObject.put("13001", c0319.m227("13001") != null ? c0319.m227("13001") : str2);
                    }
                    jSONObject.put("11000", Engine.loadSuccess ? 1 : 0);
                    jSONObject.put("11002", Engine.soVersion);
                    jSONObject.put("11003", C0453.f720);
                    jSONObject.put("11004", Engine.loadSoCount);
                    jSONObject.put("11006", z2 ? 1 : 0);
                    jSONObject.put("11029", z ? 1 : 0);
                    jSONObject.put("11008", c0374.m395(C0374.f301, C0303.f37));
                    jSONObject.put("11009", C0309.m196(c0334.f118.getApplicationContext()));
                    try {
                        String m903 = C0433.m903(c0334.f118);
                        if (!TextUtils.isEmpty(m903)) {
                            jSONObject.put("01026", m903);
                        }
                        if (c0374.m392(C0374.f257, 1) == 1) {
                            String c = b.t().c();
                            if (!TextUtils.isEmpty(c)) {
                                jSONObject.put("11102", c);
                            }
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
                        }
                    } catch (Throwable unused9) {
                    }
                    try {
                        jSONObject.put("02078", A.getE("W_S_V"));
                        jSONObject.put("02079", A.getE("W_S_S_V"));
                    } catch (Throwable unused10) {
                    }
                    jSONObject.put("11007", System.currentTimeMillis() - j);
                    jSONObject.put("11017", jSONObject.toString().length());
                    return jSONObject;
                } catch (Throwable unused11) {
                    return null;
                }
            } catch (Throwable unused12) {
                return null;
            }
        }
        return (JSONObject) invokeV.objValue;
    }
}

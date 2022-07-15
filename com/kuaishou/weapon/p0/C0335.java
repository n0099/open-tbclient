package com.kuaishou.weapon.p0;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.player.ubc.VideoPlayerUbcConstants;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kuaishou.weapon.p0.jni.Engine;
import com.kwad.sdk.c.b;
import java.net.InetAddress;
import java.net.UnknownHostException;
import org.json.JSONObject;
/* renamed from: com.kuaishou.weapon.p0.ʼٴ  reason: contains not printable characters */
/* loaded from: classes5.dex */
public class C0335 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: ʻ  reason: contains not printable characters */
    public Context f120;

    public C0335(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f120 = context;
    }

    /* JADX DEBUG: Throwable added to exception handler: 'Exception', keep only Throwable */
    /* renamed from: ʻ  reason: contains not printable characters */
    private JSONObject m279() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
            try {
                System.currentTimeMillis();
                JSONObject jSONObject = new JSONObject();
                C0374 m389 = C0374.m389(this.f120);
                boolean m408 = m389.m408("a1_p_s_p_s");
                boolean m4082 = m389.m408("a1_p_s_p_s_c_b");
                C0445 c0445 = new C0445(this.f120);
                jSONObject.put("0", c0445.m969());
                jSONObject.put("1", c0445.m959());
                jSONObject.put("2", c0445.m965());
                jSONObject.put("3", c0445.m967());
                jSONObject.put("24", c0445.m968());
                jSONObject.put("35", C0430.m830() ? 1 : 0);
                jSONObject.put(VideoPlayerUbcConstants.UBC_VIDEO_PLAY_ERROR, C0430.m831(this.f120) ? 1 : 0);
                Object m954 = C0443.m954(this.f120);
                if (m954 != null) {
                    jSONObject.put("4", m954);
                }
                if (C0374.m389(this.f120).m392(C0374.f227, 0) == 1 && (m408 || m4082)) {
                    jSONObject.put("25", C0454.m1015(this.f120) ? 1 : 0);
                }
                C0432 c0432 = new C0432();
                jSONObject.put("7", c0432.m844() ? 1 : 0);
                boolean m847 = c0432.m847(this.f120);
                jSONObject.put("8", m847 ? 1 : 0);
                if (m847) {
                    jSONObject.put("61", c0432.m846(this.f120));
                }
                jSONObject.put("10", c0432.m849(this.f120));
                jSONObject.put("11", c0432.m845(this.f120));
                C0437 c0437 = new C0437();
                jSONObject.put("26", c0437.m919("cpuinfo") ? 1 : 0);
                jSONObject.put("27", c0437.m919("meminfo") ? 1 : 0);
                C0436 c0436 = new C0436();
                jSONObject.put("65", c0436.m915() ? 1 : 0);
                boolean m914 = c0436.m914();
                jSONObject.put("66", m914 ? 1 : 0);
                if (m914) {
                    jSONObject.put("67", c0436.m916() ? 1 : 0);
                }
                jSONObject.put("68", c0436.m912() ? 1 : 0);
                jSONObject.put("69", c0436.m911());
                jSONObject.put("101", c0436.m913() ? 1 : 0);
                jSONObject.put("102", c0436.m910() ? 1 : 0);
                jSONObject.put("99", new C0439().m937());
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("03007", C0312.m211(this.f120));
                jSONObject2.put("03014", C0433.m875(this.f120));
                jSONObject2.put("03020", C0312.m209(this.f120));
                jSONObject2.put("03030", C0451.m1004(this.f120));
                jSONObject.put("51", jSONObject2);
                jSONObject.put(TbEnum.SystemMessage.EVENT_ID_DISMISS_GROUP, new C0438().m931());
                jSONObject.put("60", C0430.m833(this.f120) ? 1 : 0);
                try {
                    jSONObject.put("11028", WeaponHI.sKSSdkver);
                    jSONObject.put("11301", C0433.m867(b.t().q()));
                    jSONObject.put("11302", C0433.m867(b.t().r()));
                    jSONObject.put("11303", C0433.m867(b.t().s()));
                    jSONObject.put("11002", Engine.soVersion);
                } catch (Throwable unused) {
                }
                return jSONObject;
            } catch (Throwable unused2) {
                return null;
            }
        }
        return (JSONObject) invokeV.objValue;
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public String m280(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            try {
                if (TextUtils.isEmpty(str)) {
                    return null;
                }
                String hostAddress = InetAddress.getByName(C0380.m450(str)).getHostAddress();
                try {
                    if (!TextUtils.isEmpty(hostAddress)) {
                        if (hostAddress.contains(".")) {
                            return hostAddress;
                        }
                    }
                    return "";
                } catch (UnknownHostException unused) {
                    return hostAddress;
                }
            } catch (UnknownHostException unused2) {
                return "";
            }
        }
        return (String) invokeL.objValue;
    }

    /* renamed from: ʼ  reason: contains not printable characters */
    public String m281(String str) {
        InterceptResult invokeL;
        JSONObject m253;
        JSONObject m279;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            try {
                C0333 c0333 = new C0333(str, C0331.f85);
                String m450 = C0380.m450(C0345.f141);
                String m280 = m280(m450);
                if (TextUtils.isEmpty(m280) || (m253 = c0333.m253(this.f120)) == null) {
                    return null;
                }
                String str2 = C0345.f148 + "?" + C0355.m363(this.f120);
                if (C0345.m301() && C0345.f141.contains("api")) {
                    str2 = "/api" + str2;
                }
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("ip", m280);
                jSONObject.put("host", m450);
                jSONObject.put("path", str2);
                String str3 = WeaponHI.cookieData;
                if (!TextUtils.isEmpty(str3) && str3.length() > 10) {
                    jSONObject.put("cookie", str3);
                }
                jSONObject.put("head", m253);
                StringBuilder sb = new StringBuilder();
                sb.append("sdk=" + Build.VERSION.SDK_INT);
                jSONObject.put("parame", sb.toString());
                if (str.equals(C0331.f83) && (m279 = m279()) != null) {
                    jSONObject.put("sjd", m279);
                }
                return jSONObject.toString();
            } catch (Throwable unused) {
                return null;
            }
        }
        return (String) invokeL.objValue;
    }
}

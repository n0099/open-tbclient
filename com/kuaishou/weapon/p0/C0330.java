package com.kuaishou.weapon.p0;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;
import androidx.room.RoomMasterTable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.utils.BaseUtils;
import com.baidu.sapi2.ecommerce.activity.AddressEditActivity;
import com.baidu.searchbox.http.HttpConfig;
import com.baidu.searchbox.player.ubc.VideoPlayerUbcConstants;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tbadk.pay.PayConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.WebKitFactory;
import com.kuaishou.weapon.p0.jni.Engine;
import com.kwad.sdk.c.b;
import com.yy.mobile.framework.revenuesdk.statistics.hiido.eventtype.UVEventType;
import org.json.JSONObject;
/* renamed from: com.kuaishou.weapon.p0.ʼˎ  reason: contains not printable characters */
/* loaded from: classes5.dex */
public class C0330 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: ʻ  reason: contains not printable characters */
    public Context f75;

    public C0330(Context context) {
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
        this.f75 = context;
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public String m245(String str) {
        InterceptResult invokeL;
        JSONObject m246;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            try {
                JSONObject m253 = new C0333(str, C0331.f85).m253(this.f75);
                if (m253 == null || (m246 = m246()) == null) {
                    return null;
                }
                m253.put("module_section", m246);
                return m253.toString();
            } catch (Throwable unused) {
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public JSONObject m246() {
        InterceptResult invokeV;
        String str;
        String str2;
        JSONObject m1005;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            try {
                JSONObject jSONObject = new JSONObject();
                C0374 m389 = C0374.m389(this.f75);
                boolean m408 = m389.m408("a1_p_s_p_s");
                boolean m4082 = m389.m408("a1_p_s_p_s_c_b");
                C0374 m3892 = C0374.m389(this.f75);
                if (m3892.m392(C0374.f312, 1) == 1) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (m3892.m392(C0374.f302, 1) == 1 && Engine.loadSuccess) {
                        C0292 c0292 = new C0292(this.f75);
                        jSONObject.put("0", c0292.m81("0"));
                        jSONObject.put("1", c0292.m81("1"));
                        jSONObject.put("2", c0292.m81("2"));
                        jSONObject.put("3", c0292.m81("3"));
                        jSONObject.put("4", c0292.m81("4"));
                        jSONObject.put("5", c0292.m81("5"));
                        jSONObject.put("6", c0292.m81("6"));
                        jSONObject.put("7", c0292.m81("7"));
                        jSONObject.put("8", c0292.m81("8"));
                        jSONObject.put("9", c0292.m81("9"));
                        jSONObject.put("10", c0292.m81("10"));
                        jSONObject.put("11", c0292.m81("11"));
                        jSONObject.put("12", c0292.m81("12"));
                        jSONObject.put("13", c0292.m81("13"));
                        jSONObject.put("14", c0292.m81("14"));
                        jSONObject.put("15", c0292.m81("15"));
                        jSONObject.put("16", c0292.m81("16"));
                        jSONObject.put("17", c0292.m81("17"));
                        jSONObject.put("18", c0292.m81("18"));
                        jSONObject.put("19", c0292.m81("19"));
                        jSONObject.put(UVEventType.PAY_WALLET_BANNER_SHOW, c0292.m81(UVEventType.PAY_WALLET_BANNER_SHOW));
                        jSONObject.put("21", c0292.m81("21"));
                        jSONObject.put("22", c0292.m81("22"));
                        jSONObject.put("23", c0292.m81("23"));
                        jSONObject.put("24", c0292.m81("24"));
                        jSONObject.put("25", c0292.m81("25"));
                        jSONObject.put("26", c0292.m81("26"));
                        jSONObject.put("27", c0292.m81("27"));
                        jSONObject.put(com.tencent.connect.common.Constants.VIA_ACT_TYPE_TWENTY_EIGHT, c0292.m81(com.tencent.connect.common.Constants.VIA_ACT_TYPE_TWENTY_EIGHT));
                        jSONObject.put("29", c0292.m81("29"));
                        jSONObject.put("30", c0292.m81("30"));
                        jSONObject.put("31", c0292.m81("31"));
                        jSONObject.put("32", c0292.m81("32"));
                        jSONObject.put("33", c0292.m81("33"));
                        jSONObject.put("34", c0292.m81("34"));
                        jSONObject.put("35", c0292.m81("35"));
                        jSONObject.put(VideoPlayerUbcConstants.UBC_VIDEO_PLAY_ERROR, c0292.m81(VideoPlayerUbcConstants.UBC_VIDEO_PLAY_ERROR));
                        jSONObject.put(PayConfig.PAYMENT_POS_KEY_MANGA, c0292.m81(PayConfig.PAYMENT_POS_KEY_MANGA));
                        jSONObject.put("38", c0292.m81("38"));
                        jSONObject.put("39", c0292.m81("39"));
                        jSONObject.put("40", c0292.m81("40"));
                        jSONObject.put("41", c0292.m81("41"));
                        jSONObject.put(RoomMasterTable.DEFAULT_ID, c0292.m81(RoomMasterTable.DEFAULT_ID));
                        jSONObject.put("43", c0292.m82("43"));
                        jSONObject.put("44", c0292.m82("44"));
                        jSONObject.put("101", c0292.m81("101"));
                        jSONObject.put("102", c0292.m81("102"));
                        jSONObject.put(TbEnum.SystemMessage.EVENT_ID_GROUP_JOIN, c0292.m81(TbEnum.SystemMessage.EVENT_ID_GROUP_JOIN));
                        jSONObject.put(TbEnum.SystemMessage.EVENT_ID_GROUP_QUIT, c0292.m81(TbEnum.SystemMessage.EVENT_ID_GROUP_QUIT));
                        jSONObject.put("49", C0380.m453(this.f75));
                        jSONObject.put("50", C0380.m451(this.f75));
                    }
                    if (m3892.m392(C0374.f296, 1) == 1 && Engine.loadSuccess) {
                        C0431 c0431 = new C0431(this.f75);
                        jSONObject.put("45", c0431.m838("45"));
                        if (c0431.m839()) {
                            i = 1;
                            jSONObject.put(BaseUtils.METHOD_RECEIVEESSAGE, 1);
                        } else {
                            i = 1;
                        }
                        if (c0431.m837()) {
                            jSONObject.put(HttpConfig.UBC_HTTP_ID, i);
                        }
                        jSONObject.put("46", c0431.m838("46"));
                        jSONObject.put("48", c0431.m841("48"));
                        jSONObject.put("51", c0431.m836("51"));
                        jSONObject.put("52", c0431.m835(this.f75, "52", 0));
                        jSONObject.put(BaseUtils.METHOD_SENDMESSAGE, c0431.m840(BaseUtils.METHOD_SENDMESSAGE));
                        jSONObject.put("66", c0431.m841("66"));
                        jSONObject.put("67", C0377.m438());
                        jSONObject.put("78", c0431.m841("78"));
                        jSONObject.put("79", c0431.m841("79"));
                        C0409 c0409 = new C0409(this.f75, 200);
                        jSONObject.put("70", c0409.m584("70"));
                        jSONObject.put("71", c0409.m584("71"));
                        jSONObject.put("72", c0409.m584("72"));
                        jSONObject.put("73", c0409.m584("73"));
                        jSONObject.put("74", c0409.m584("74"));
                    }
                    if (m3892.m392(C0374.f306, 1) == 1) {
                        C0405 c0405 = new C0405(this.f75);
                        jSONObject.put("53", c0405.m551(this.f75, "53", 1));
                        jSONObject.put("56", c0405.m549("56"));
                        jSONObject.put("57", c0405.m549("57"));
                        if (m408 || m4082) {
                            C0450 c0450 = new C0450();
                            jSONObject.put("47", c0450.m999(this.f75));
                            jSONObject.put("59", c0450.m1000(this.f75));
                            jSONObject.put("60", c0450.m998(this.f75));
                            jSONObject.put("61", c0450.m992(this.f75));
                            jSONObject.put("62", c0450.m1001(this.f75));
                            jSONObject.put("65", c0450.m1002(this.f75));
                            jSONObject.put("69", c0450.m997(this.f75));
                            jSONObject.put("75", c0450.m991(this.f75));
                            jSONObject.put("80", C0450.m983());
                            jSONObject.put("85", c0450.m994(this.f75));
                            jSONObject.put("87", c0450.m996(this.f75));
                            jSONObject.put("91", c0450.m993(this.f75));
                            jSONObject.put("92", c0450.m995(this.f75));
                        }
                        jSONObject.put(WebKitFactory.OS_64, C0377.m434());
                    }
                    if (m3892.m392(C0374.f304, 1) == 1) {
                        C0341 c0341 = new C0341();
                        jSONObject.put("98", c0341.m291());
                        jSONObject.put(TbEnum.SystemMessage.EVENT_ID_DISMISS_GROUP, c0341.m292());
                        String m1021 = C0455.m1021();
                        if (!TextUtils.isEmpty(m1021)) {
                            jSONObject.put("77", m1021);
                        }
                        jSONObject.put(TbEnum.SystemMessage.EVENT_ID_GROUP_UPGRADE, C0455.m1020());
                        jSONObject.put(TbEnum.SystemMessage.EVENT_ID_INVITE_GROUP, C0380.m454(this.f75));
                        C0445 c0445 = new C0445(this.f75);
                        jSONObject.put("82", c0445.m963());
                        String m961 = c0445.m961();
                        if (!TextUtils.isEmpty(m961)) {
                            jSONObject.put("83", m961);
                        }
                        String m962 = c0445.m962();
                        if (!TextUtils.isEmpty(m962)) {
                            jSONObject.put("84", m962);
                        }
                        String m966 = c0445.m966();
                        if (!TextUtils.isEmpty(m966)) {
                            jSONObject.put(AddressEditActivity.CHINA_REGION_CODE, m966);
                        }
                    }
                    if (m3892.m392(C0374.f300, 1) == 1) {
                        C0395 c0395 = new C0395(this.f75);
                        jSONObject.put("95", c0395.m504("95"));
                        jSONObject.put("96", c0395.m505() ? 1 : 0);
                        jSONObject.put("97", C0377.m439());
                        try {
                            jSONObject.put("11301", C0433.m867(b.t().q()));
                            jSONObject.put("11302", C0433.m867(b.t().r()));
                            jSONObject.put("11303", C0433.m867(b.t().s()));
                        } catch (Throwable unused) {
                        }
                    }
                    try {
                        if (C0374.m389(this.f75).m392(C0374.f255, 1) == 1) {
                            JSONObject m813 = new C0425(this.f75, 100, Environment.getExternalStorageDirectory().getAbsolutePath(), C0425.m809(this.f75)).m813();
                            if (m813 == null || m813.length() <= 10) {
                                str = "16102";
                                str2 = new C0425(this.f75, 200, "", true).m811(str);
                            } else {
                                str = "16002";
                                str2 = m813;
                            }
                            jSONObject.put(str, str2);
                            if ((m408 || m4082) && (m1005 = C0451.m1005(this.f75)) != null && m1005.length() > 0) {
                                jSONObject.put("16116", m1005);
                            }
                        }
                    } catch (Throwable unused2) {
                    }
                    jSONObject.put("11006", m408 ? 1 : 0);
                    jSONObject.put("11029", m4082 ? 1 : 0);
                    jSONObject.put("11002", Engine.soVersion);
                    jSONObject.put("11007", System.currentTimeMillis() - currentTimeMillis);
                    jSONObject.put("11017", jSONObject.toString().length());
                    return jSONObject;
                }
            } catch (Throwable unused3) {
            }
            return null;
        }
        return (JSONObject) invokeV.objValue;
    }
}

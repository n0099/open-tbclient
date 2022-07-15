package com.kuaishou.weapon.p0;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import androidx.room.RoomMasterTable;
import com.baidu.adp.ApsConstants;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.utils.BaseUtils;
import com.baidu.searchbox.aideviceperformance.utils.HardwareInfoUtils;
import com.baidu.searchbox.http.HttpConfig;
import com.baidu.searchbox.performance.speed.SpeedStats;
import com.baidu.searchbox.player.ubc.VideoPlayerUbcConstants;
import com.baidu.searchbox.unitedscheme.UnitedSchemeMainDispatcher;
import com.baidu.tbadk.core.util.TbEnum;
import com.baidu.tbadk.pay.PayConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.sdk.WebKitFactory;
import com.kuaishou.weapon.p0.jni.A;
import com.kuaishou.weapon.p0.jni.Engine;
import com.kwad.sdk.c.b;
import com.yy.mobile.framework.revenuesdk.statistics.hiido.eventtype.UVEventType;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;
/* renamed from: com.kuaishou.weapon.p0.ʼˑ  reason: contains not printable characters */
/* loaded from: classes5.dex */
public class C0332 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: ʻ  reason: contains not printable characters */
    public Context f103;

    /* renamed from: ʼ  reason: contains not printable characters */
    public int f104;

    /* renamed from: ʽ  reason: contains not printable characters */
    public int f105;

    public C0332(Context context, int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i), Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f103 = context;
        this.f104 = i;
        this.f105 = i2;
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public String m247(String str) {
        InterceptResult invokeL;
        JSONObject m248;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            try {
                JSONObject m253 = new C0333(str, C0331.f85).m253(this.f103);
                if (m253 == null || (m248 = m248()) == null) {
                    return null;
                }
                m253.put("module_section", m248);
                return m253.toString();
            } catch (Throwable unused) {
                return null;
            }
        }
        return (String) invokeL.objValue;
    }

    /* renamed from: ʻ  reason: contains not printable characters */
    public JSONObject m248() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            try {
                long currentTimeMillis = System.currentTimeMillis();
                JSONObject jSONObject = new JSONObject();
                C0374 m389 = C0374.m389(this.f103);
                boolean m408 = m389.m408("a1_p_s_p_s");
                boolean m4082 = m389.m408("a1_p_s_p_s_c_b");
                C0445 c0445 = new C0445(this.f103);
                jSONObject.put("0", c0445.m969());
                jSONObject.put("1", c0445.m959());
                jSONObject.put("2", c0445.m965());
                jSONObject.put("3", c0445.m967());
                jSONObject.put("24", c0445.m968());
                jSONObject.put("35", C0430.m830() ? 1 : 0);
                jSONObject.put(VideoPlayerUbcConstants.UBC_VIDEO_PLAY_ERROR, C0430.m831(this.f103) ? 1 : 0);
                Object m954 = C0443.m954(this.f103);
                if (m954 != null) {
                    jSONObject.put("4", m954);
                }
                C0426 c0426 = new C0426();
                JSONArray m815 = c0426.m815(this.f103);
                jSONObject.put("49", m815);
                jSONObject.put("146", c0426.m818());
                jSONObject.put("154", c0426.m816());
                jSONObject.put("168", C0378.m441(m815));
                jSONObject.put("169", C0378.m444(m815));
                jSONObject.put("185", c0426.m819());
                jSONObject.put("191", c0426.m814());
                if (c0426.m817() != null) {
                    jSONObject.put("161", c0426.m817());
                }
                jSONObject.put("22", C0430.m832());
                C0432 c0432 = new C0432();
                jSONObject.put("7", c0432.m844() ? 1 : 0);
                boolean m847 = c0432.m847(this.f103);
                jSONObject.put("8", m847 ? 1 : 0);
                if (m847) {
                    jSONObject.put("61", c0432.m846(this.f103));
                }
                jSONObject.put("181", c0432.m848(this.f103) ? 1 : 0);
                jSONObject.put("9", c0432.m843(this.f103));
                jSONObject.put("10", c0432.m849(this.f103));
                jSONObject.put("11", c0432.m845(this.f103));
                C0437 c0437 = new C0437();
                jSONObject.put("26", c0437.m919("cpuinfo") ? 1 : 0);
                jSONObject.put("27", c0437.m919("meminfo") ? 1 : 0);
                jSONObject.put(com.tencent.connect.common.Constants.VIA_ACT_TYPE_TWENTY_EIGHT, c0437.m922(C0294.f19) ? 1 : 0);
                jSONObject.put("29", c0437.m922(HardwareInfoUtils.MEM_INFO_FILE) ? 1 : 0);
                jSONObject.put("96", c0437.m918());
                jSONObject.put("134", c0437.m921());
                C0438 c0438 = new C0438();
                Set<String> m935 = c0438.m935();
                Set<String> m936 = c0438.m936();
                if (m936 != null) {
                    jSONObject.put("30", 1);
                    jSONObject.put("32", new JSONArray((Collection) m936));
                } else {
                    jSONObject.put("30", 0);
                }
                if (m935 != null) {
                    jSONObject.put("31", 1);
                    jSONObject.put("33", new JSONArray((Collection) m935));
                } else {
                    jSONObject.put("31", 0);
                }
                Object m934 = c0438.m934();
                if (m934 != null) {
                    jSONObject.put("34", m934);
                    if (m935 != null || m936 != null) {
                        HashSet hashSet = new HashSet();
                        if (m935 != null) {
                            hashSet.add(m935);
                        }
                        if (m936 != null) {
                            hashSet.add(m936);
                        }
                        jSONObject.put("13", c0438.m926(this.f103, 13, hashSet));
                        jSONObject.put("14", c0438.m926(this.f103, 14, hashSet));
                        jSONObject.put("15", c0438.m926(this.f103, 15, hashSet));
                        jSONObject.put("16", c0438.m926(this.f103, 16, hashSet));
                        jSONObject.put("17", c0438.m926(this.f103, 17, hashSet));
                        jSONObject.put("18", c0438.m926(this.f103, 18, hashSet));
                        jSONObject.put("19", c0438.m926(this.f103, 19, hashSet));
                        jSONObject.put(UVEventType.PAY_WALLET_BANNER_SHOW, c0438.m926(this.f103, 20, hashSet));
                        jSONObject.put("21", c0438.m926(this.f103, 21, hashSet));
                        jSONObject.put("130", c0438.m928(hashSet));
                    }
                }
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
                jSONObject.put(TbEnum.SystemMessage.EVENT_ID_INTRO_MODIFY, new C0435().m908() ? 1 : 0);
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("03007", C0312.m211(this.f103));
                jSONObject2.put("03014", C0433.m875(this.f103));
                jSONObject2.put("03020", C0312.m209(this.f103));
                jSONObject2.put("03030", C0451.m1004(this.f103));
                jSONObject.put("51", jSONObject2);
                C0438 c04382 = new C0438();
                jSONObject.put(TbEnum.SystemMessage.EVENT_ID_DISMISS_GROUP, c04382.m931());
                jSONObject.put("155", c04382.m932());
                jSONObject.put("170", c04382.m933());
                jSONObject.put("190", c04382.m927());
                C0441 c0441 = new C0441();
                jSONObject.put("131", c0441.m946());
                jSONObject.put("145", c0441.m947(this.f103));
                jSONObject.put("132", C0379.m446());
                jSONObject.put("133", new C0445(this.f103).m970());
                C0374 m3892 = C0374.m389(this.f103);
                if (m3892.m392(C0374.f232, 1) == 1) {
                    jSONObject.put("139", C0380.m456(this.f103));
                    jSONObject.put("140", C0380.m455(this.f103));
                    jSONObject.put("143", C0298.m153(this.f103));
                    jSONObject.put("147", C0380.m447());
                    jSONObject.put("148", C0377.m440());
                    jSONObject.put("149", C0377.m437());
                    jSONObject.put("151", C0379.m445());
                }
                if (m3892.m392(C0374.f227, 0) == 1) {
                    if (m408 || m4082) {
                        jSONObject.put("25", C0454.m1015(this.f103) ? 1 : 0);
                    }
                    jSONObject.put("128", C0435.m907() ? 1 : 0);
                }
                if (Engine.loadSuccess) {
                    C0397 c0397 = new C0397(this.f103, 100);
                    jSONObject.put("6", c0397.m524("6"));
                    JSONArray m427 = c0397.m427(c0397.m522(), "41");
                    if (m427 != null && m427.length() > 0) {
                        JSONArray m428 = c0397.m428(c0397.m522(), "41");
                        JSONArray m426 = c0397.m426(c0397.m522(), "41");
                        jSONObject.put(RoomMasterTable.DEFAULT_ID, m428);
                        jSONObject.put("43", m426);
                        jSONObject.put("41", c0397.m425(c0397.m425(m427, m428), m426));
                    }
                    jSONObject.put("47", c0397.m524("47"));
                    jSONObject.put("48", c0397.m524("48"));
                    jSONObject.put("23", c0397.m524("23"));
                    jSONObject.put(PayConfig.PAYMENT_POS_KEY_MANGA, c0397.m524(PayConfig.PAYMENT_POS_KEY_MANGA));
                    jSONObject.put("38", c0397.m524("38"));
                    jSONObject.put("40", c0397.m525("40"));
                    jSONObject.put("45", c0397.m525("45"));
                    jSONObject.put("46", c0397.m526("46"));
                    jSONObject.put("91", c0397.m524("91"));
                    jSONObject.put("62", c0397.m521("62"));
                    jSONObject.put("63", c0397.m521("63"));
                    jSONObject.put(WebKitFactory.OS_64, c0397.m521(WebKitFactory.OS_64));
                    jSONObject.put("85", c0397.m523("85"));
                    jSONObject.put("50", c0397.m524("50"));
                    jSONObject.put("70", c0397.m521("70"));
                    jSONObject.put("39", c0397.m524("39"));
                    jSONObject.put("52", c0397.m524("52"));
                    jSONObject.put("53", c0397.m524("53"));
                    jSONObject.put("54", c0397.m524("54"));
                    jSONObject.put(BaseUtils.METHOD_SENDMESSAGE, c0397.m524(BaseUtils.METHOD_SENDMESSAGE));
                    jSONObject.put("73", c0397.m524("73"));
                    jSONObject.put("74", c0397.m524("74"));
                    jSONObject.put(TbEnum.SystemMessage.EVENT_ID_GROUP_UPGRADE, c0397.m524(TbEnum.SystemMessage.EVENT_ID_GROUP_UPGRADE));
                    if (m3892.m392(C0374.f222, 1) == 1 && Build.VERSION.SDK_INT < 23) {
                        C0320 c0320 = new C0320(this.f103);
                        String m228 = c0320.m228("57");
                        if (!TextUtils.isEmpty(m228)) {
                            jSONObject.put("57", m228);
                            jSONObject.put("56", c0320.m228("56"));
                        }
                    }
                    jSONObject.put("77", c0397.m524("77"));
                    jSONObject.put("78", c0397.m524("78"));
                    jSONObject.put("79", c0397.m524("79"));
                    jSONObject.put("84", c0397.m524("84"));
                    jSONObject.put("80", c0397.m524("80"));
                    jSONObject.put("81", c0397.m524("81"));
                    jSONObject.put("82", c0397.m524("82"));
                    jSONObject.put("83", c0397.m524("83"));
                    jSONObject.put("87", c0397.m524("87"));
                    jSONObject.put("89", c0397.m524("89"));
                    jSONObject.put("90", c0397.m523("90"));
                    jSONObject.put("75", c0397.m524("75"));
                    jSONObject.put("88", c0397.m524("88"));
                    jSONObject.put("92", c0397.m524("92"));
                    jSONObject.put(BaseUtils.METHOD_RECEIVEESSAGE, c0397.m524(BaseUtils.METHOD_RECEIVEESSAGE));
                    jSONObject.put(HttpConfig.UBC_HTTP_ID, c0397.m524(HttpConfig.UBC_HTTP_ID));
                    jSONObject.put("95", c0397.m524("95"));
                    jSONObject.put("98", c0397.m524("98"));
                    jSONObject.put("100", c0397.m524("100"));
                    jSONObject.put(TbEnum.SystemMessage.EVENT_ID_GROUP_JOIN, c0397.m524(TbEnum.SystemMessage.EVENT_ID_GROUP_JOIN));
                    if (m3892.m392(C0374.f224, 1) == 1) {
                        C0354 c0354 = new C0354(this.f103, 0);
                        jSONObject.put("108", c0354.m356("108"));
                        jSONObject.put(TbEnum.SystemMessage.EVENT_ID_INVITE_GROUP, c0354.m356(TbEnum.SystemMessage.EVENT_ID_INVITE_GROUP));
                        jSONObject.put("111", c0354.m356("111"));
                    }
                    if (m3892.m392(C0374.f226, 1) == 1) {
                        C0354 c03542 = new C0354(this.f103, 1);
                        jSONObject.put("112", c03542.m355("112"));
                        jSONObject.put("113", c03542.m356("113"));
                        jSONObject.put("114", c03542.m356("114"));
                        jSONObject.put("115", c03542.m356("115"));
                        jSONObject.put(ApsConstants.TYPE_ANDROID_PLUGIN, c03542.m356(ApsConstants.TYPE_ANDROID_PLUGIN));
                        jSONObject.put("117", c03542.m356("117"));
                        jSONObject.put("120", c03542.m356("120"));
                        C0354 c03543 = new C0354(this.f103, 4);
                        jSONObject.put("124", c03543.m356("124"));
                        jSONObject.put("125", c03543.m356("125"));
                        jSONObject.put("126", c03543.m356("126"));
                        jSONObject.put(SpeedStats.UBC_LAUNCH_SPEED_ID, c03543.m356(SpeedStats.UBC_LAUNCH_SPEED_ID));
                    }
                    if (m3892.m392(C0374.f228, 0) == 1) {
                        C0399 c0399 = new C0399(this.f103, 100);
                        jSONObject.put("97", c0399.m527("97"));
                        jSONObject.put("118", c0399.m527("118"));
                        jSONObject.put("119", c0399.m527("119"));
                        jSONObject.put("135", c0399.m527("135"));
                        jSONObject.put("174", c0399.m527("174"));
                        C0399 c03992 = new C0399(this.f103, 200);
                        jSONObject.put("173", c03992.m527("173"));
                        jSONObject.put("182", c03992.m527("182"));
                    }
                    if (m3892.m392(C0374.f223, 1) == 1) {
                        jSONObject.put("129", new C0429(this.f103, 4).m828("129"));
                        C0429 c0429 = new C0429(this.f103, 1);
                        jSONObject.put(TbEnum.SystemMessage.EVENT_ID_HIDE_GROUP_WARN, c0429.m427(c0429.m829(), TbEnum.SystemMessage.EVENT_ID_HIDE_GROUP_WARN));
                        C0429 c04292 = new C0429(this.f103, 2);
                        jSONObject.put("137", c04292.m828("137"));
                        jSONObject.put(UnitedSchemeMainDispatcher.UBC_OUTER_INVOKE_TO_TAYGET_ID, c04292.m828(UnitedSchemeMainDispatcher.UBC_OUTER_INVOKE_TO_TAYGET_ID));
                        jSONObject.put("141", c04292.m828("141"));
                        jSONObject.put("142", c04292.m828("142"));
                        C0442 c0442 = new C0442(this.f103, 3);
                        JSONArray m949 = c0442.m949("150");
                        jSONObject.put("150", m949);
                        if (m949 != null) {
                            jSONObject.put("188", c0442.m951(m949));
                        }
                    }
                    if (m3892.m392(C0374.f328, 1) == 1) {
                        C0407 c0407 = new C0407(this.f103, 100);
                        jSONObject.put("152", c0407.m576("152"));
                        jSONObject.put("153", c0407.m576("153"));
                        jSONObject.put("156", c0407.m576("156"));
                        jSONObject.put("157", c0407.m576("157"));
                        jSONObject.put("163", c0407.m576("163"));
                        jSONObject.put("171", c0407.m573("171", true));
                        jSONObject.put("172", c0407.m577("172"));
                        jSONObject.put("177", new C0407(this.f103, 500).m578("177"));
                    }
                    if ((m408 || m4082) && m3892.m392(C0374.f330, 0) == 1) {
                        jSONObject.put("158", new C0407(this.f103, 300).m577("158"));
                    }
                    if (m3892.m392(C0374.f231, 0) == 1) {
                        C0427 c0427 = new C0427(this.f103);
                        jSONObject.put("162", c0427.m820("162"));
                        jSONObject.put("160", c0427.m427(c0427.m822(), "160"));
                        C0407 c04072 = new C0407(this.f103, 400);
                        jSONObject.put("164", c04072.m576("164"));
                        jSONObject.put("165", c04072.m576("165"));
                        jSONObject.put("166", c04072.m572("166"));
                        jSONObject.put("167", c04072.m576("167"));
                    }
                    if (m3892.m392(C0374.f229, 1) == 1) {
                        C0402 c0402 = new C0402(this.f103, 600);
                        jSONObject.put("179", c0402.m545("179"));
                        jSONObject.put("186", c0402.m545("186"));
                        jSONObject.put("189", c0402.m545("189"));
                    }
                }
                jSONObject.put("58", C0437.m917(this.f103));
                jSONObject.put("60", C0430.m833(this.f103) ? 1 : 0);
                jSONObject.put("11000", Engine.loadSuccess ? 1 : 0);
                jSONObject.put("11002", Engine.soVersion);
                jSONObject.put("11008", m3892.m395(C0374.f301, C0303.f37));
                jSONObject.put("11009", C0309.m196(this.f103.getApplicationContext()));
                try {
                    jSONObject.put("11301", C0433.m867(b.t().q()));
                    jSONObject.put("11302", C0433.m867(b.t().r()));
                    jSONObject.put("11303", C0433.m867(b.t().s()));
                } catch (Throwable unused) {
                }
                String m396 = m3892.m396(C0374.f309, "", true);
                if (!TextUtils.isEmpty(m396)) {
                    jSONObject.put("183", m396);
                    m3892.m406(C0374.f309, "");
                }
                jSONObject.put("187", C0452.m1014(this.f103) ? 1 : 0);
                jSONObject.put("11006", m408 ? 1 : 0);
                jSONObject.put("11029", m4082 ? 1 : 0);
                jSONObject.put("11028", WeaponHI.sKSSdkver);
                jSONObject.put("20000", this.f104);
                jSONObject.put("20001", this.f105);
                try {
                    jSONObject.put("02078", A.getE("W_S_V"));
                    jSONObject.put("02079", A.getE("W_S_S_V"));
                } catch (Throwable unused2) {
                }
                jSONObject.put("11007", System.currentTimeMillis() - currentTimeMillis);
                jSONObject.put("11017", jSONObject.toString().length());
                return jSONObject;
            } catch (Throwable unused3) {
                return null;
            }
        }
        return (JSONObject) invokeV.objValue;
    }
}

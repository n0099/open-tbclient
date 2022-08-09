package com.repackage;

import android.text.TextUtils;
import com.baidu.ala.data.SdkLiveInfoData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForumUserLiveActiivtyConfig;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes6.dex */
public class ms5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(gq5 gq5Var, String str, String str2) {
        SdkLiveInfoData sdkLiveInfoData;
        String str3;
        String str4;
        String str5;
        String str6;
        SdkLiveInfoData.YYExt yYExt;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65536, null, gq5Var, str, str2) == null) || gq5Var == null || (sdkLiveInfoData = gq5Var.a) == null) {
            return;
        }
        SdkLiveInfoData.AlaLiveInfo alaLiveInfo = sdkLiveInfoData.liveInfo;
        if (alaLiveInfo == null || (yYExt = alaLiveInfo.yyExt) == null) {
            str3 = "";
            str4 = str3;
            str5 = str4;
            str6 = str5;
        } else {
            str4 = yYExt.sid;
            str5 = yYExt.ssid;
            str6 = yYExt.yyUid;
            str3 = yYExt.templateId;
        }
        TiebaStatic.log(new StatisticItem(str).param("fid", gq5Var.c).param("liveid", gq5Var.a.liveId).param("hdid", TbadkCoreApplication.getInst().getHdid()).param(TiebaStatic.YYParams.YYSID, str4).param(TiebaStatic.YYParams.YYSSID, str5).param(TiebaStatic.YYParams.YYUID, str6).param("template_id", str3).param(TiebaStatic.YYParams.YYLIVEID, TextUtils.isEmpty(str4) ? "" : "1").param(TiebaStatic.Params.VID, gq5Var.a.nid).param("obj_source", TextUtils.equals(ForumUserLiveActiivtyConfig.KEY_FROM_FRS_CARD, str2) ? 1 : 2));
    }

    public static void b(gq5 gq5Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, gq5Var, str) == null) {
            a(gq5Var, "c14705", str);
        }
    }

    public static void c(gq5 gq5Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, gq5Var, str) == null) {
            a(gq5Var, "c14704", str);
        }
    }
}

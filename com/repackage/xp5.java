package com.repackage;

import android.text.TextUtils;
import com.baidu.ala.data.SdkLiveInfoData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes7.dex */
public class xp5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(ln5 ln5Var, String str) {
        SdkLiveInfoData sdkLiveInfoData;
        String str2;
        String str3;
        String str4;
        String str5;
        SdkLiveInfoData.YYExt yYExt;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65536, null, ln5Var, str) == null) || ln5Var == null || (sdkLiveInfoData = ln5Var.a) == null) {
            return;
        }
        SdkLiveInfoData.AlaLiveInfo alaLiveInfo = sdkLiveInfoData.liveInfo;
        if (alaLiveInfo == null || (yYExt = alaLiveInfo.yyExt) == null) {
            str2 = "";
            str3 = str2;
            str4 = str3;
            str5 = str4;
        } else {
            str3 = yYExt.sid;
            str4 = yYExt.ssid;
            str5 = yYExt.yyUid;
            str2 = yYExt.templateId;
        }
        TiebaStatic.log(new StatisticItem(str).param("fid", ln5Var.c).param("liveid", ln5Var.a.liveId).param("hdid", TbadkCoreApplication.getInst().getHdid()).param(TiebaStatic.YYParams.YYSID, str3).param(TiebaStatic.YYParams.YYSSID, str4).param(TiebaStatic.YYParams.YYUID, str5).param("template_id", str2).param(TiebaStatic.YYParams.YYLIVEID, TextUtils.isEmpty(str3) ? "" : "1").param(TiebaStatic.Params.VID, ln5Var.a.nid));
    }

    public static void b(ln5 ln5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65537, null, ln5Var) == null) {
            a(ln5Var, "c14705");
        }
    }

    public static void c(ln5 ln5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, null, ln5Var) == null) {
            a(ln5Var, "c14704");
        }
    }
}

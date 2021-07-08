package d.a.p0.v.d.c;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.ala.data.SdkLiveInfoData;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.data.YyExtData;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.YYLiveUtil;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import d.a.c.e.p.j;
import d.a.c.e.p.k;
import d.a.c.e.p.l;
import d.a.o0.r.q.b2;
/* loaded from: classes8.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static int a(SdkLiveInfoData.AlaLiveInfo alaLiveInfo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65536, null, alaLiveInfo)) == null) {
            SdkLiveInfoData.YYExt yYExt = alaLiveInfo.yyExt;
            if (yYExt != null) {
                return yYExt.isYYGame == 1 ? 3 : 2;
            }
            return alaLiveInfo.liveType != 1 ? 5 : 1;
        }
        return invokeL.intValue;
    }

    public static int[] b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            int dimensionPixelSize = l.p(context)[0] - (context.getResources().getDimensionPixelSize(R.dimen.tbds44) * 2);
            return new int[]{dimensionPixelSize, (int) ((dimensionPixelSize * 9.0d) / 16.0d)};
        }
        return (int[]) invokeL.objValue;
    }

    public static boolean c(SdkLiveInfoData sdkLiveInfoData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, sdkLiveInfoData)) == null) ? (sdkLiveInfoData == null || sdkLiveInfoData.liveInfo == null || k.isEmpty(sdkLiveInfoData.liveId) || k.isEmpty(sdkLiveInfoData.roomId) || !StringHelper.equals(sdkLiveInfoData.source, "jiaoyoufang") || sdkLiveInfoData.liveInfo.roomStatus != 2) ? false : true : invokeL.booleanValue;
    }

    public static boolean d(SdkLiveInfoData sdkLiveInfoData) {
        InterceptResult invokeL;
        SdkLiveInfoData.AlaLiveInfo alaLiveInfo;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, sdkLiveInfoData)) == null) ? (sdkLiveInfoData == null || (alaLiveInfo = sdkLiveInfoData.liveInfo) == null || alaLiveInfo.yyExt == null || k.isEmpty(sdkLiveInfoData.roomId) || k.isEmpty(sdkLiveInfoData.liveInfo.yyExt.sid) || k.isEmpty(sdkLiveInfoData.liveInfo.yyExt.ssid) || k.isEmpty(sdkLiveInfoData.liveInfo.yyExt.templateId)) ? false : true : invokeL.booleanValue;
    }

    public static boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? TbSingleton.getInstance().getSyncYYSwitch() || TbSingleton.getInstance().isYYSwitchStatusIsOn() : invokeV.booleanValue;
    }

    public static void f(TbPageContext tbPageContext, SdkLiveInfoData sdkLiveInfoData, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(AdIconUtil.AD_TEXT_ID, null, tbPageContext, sdkLiveInfoData, str) == null) || tbPageContext == null || sdkLiveInfoData == null) {
            return;
        }
        UrlManager urlManager = UrlManager.getInstance();
        urlManager.dealOneLink(tbPageContext, new String[]{"bdtiebalive://video/live?room_id=" + sdkLiveInfoData.roomId + "&live_id=" + sdkLiveInfoData.liveId + "&enterroom_type=1&from=" + str});
    }

    public static void g(Context context, b2 b2Var, String str) {
        String str2;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(AdIconUtil.BAIDU_LOGO_ID, null, context, b2Var, str) == null) {
            if (!j.z()) {
                l.J(context, context.getString(R.string.no_network_guide));
            } else if (context == null || b2Var == null || b2Var.H() == null || b2Var.g1() == null) {
            } else {
                if (TbadkCoreApplication.getCurrentAccount() != null) {
                    String userId = b2Var.H().getUserId();
                    String currentAccount = TbadkCoreApplication.getCurrentAccount();
                    z = TextUtils.equals(userId, currentAccount);
                    str2 = currentAccount;
                } else {
                    str2 = "";
                    z = false;
                }
                AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
                alaLiveInfoCoreData.fillWithInfoData(b2Var.g1());
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(context, alaLiveInfoCoreData, null, str, str2, z, null, null)));
            }
        }
    }

    public static void h(Context context, SdkLiveInfoData sdkLiveInfoData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65543, null, context, sdkLiveInfoData) == null) || sdkLiveInfoData == null) {
            return;
        }
        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
        alaLiveInfoCoreData.liveID = d.a.c.e.m.b.f(sdkLiveInfoData.liveId, 0L);
        alaLiveInfoCoreData.threadId = d.a.c.e.m.b.f(sdkLiveInfoData.tid, 0L);
        SdkLiveInfoData.LiveAuthor liveAuthor = sdkLiveInfoData.liveAuthor;
        if (liveAuthor != null) {
            alaLiveInfoCoreData.userName = liveAuthor.name;
        }
        SdkLiveInfoData.AlaLiveInfo alaLiveInfo = sdkLiveInfoData.liveInfo;
        if (alaLiveInfo != null) {
            alaLiveInfoCoreData.sessionID = alaLiveInfo.sessionId;
            alaLiveInfoCoreData.liveType = alaLiveInfo.liveType;
            alaLiveInfoCoreData.screenDirection = alaLiveInfo.screenDirection;
            alaLiveInfoCoreData.hslUrl = alaLiveInfo.hlsUrl;
            alaLiveInfoCoreData.liveCover = alaLiveInfo.cover;
            alaLiveInfoCoreData.rtmpUrl = alaLiveInfo.rtmpUrl;
            alaLiveInfoCoreData.liveTitle = sdkLiveInfoData.title;
            alaLiveInfoCoreData.audienceCount = alaLiveInfo.audienceCount;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(context, alaLiveInfoCoreData, null, AlaLiveRoomActivityConfig.FROM_TYPE_HOME_LIVE_TAB_MAIN, TbadkCoreApplication.getCurrentAccount(), false, "", null)));
    }

    public static void i(Context context, b2 b2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, context, b2Var) == null) {
            g(context, b2Var, AlaLiveRoomActivityConfig.FROM_TYPE_HOME_LIVE_TAB_MY_CONCERN);
        }
    }

    public static void j(TbPageContext tbPageContext, SdkLiveInfoData sdkLiveInfoData, String str) {
        SdkLiveInfoData.AlaLiveInfo alaLiveInfo;
        SdkLiveInfoData.YYExt yYExt;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65545, null, tbPageContext, sdkLiveInfoData, str) == null) || sdkLiveInfoData == null || (alaLiveInfo = sdkLiveInfoData.liveInfo) == null || (yYExt = alaLiveInfo.yyExt) == null || k.isEmpty(yYExt.sid) || k.isEmpty(sdkLiveInfoData.liveInfo.yyExt.ssid)) {
            return;
        }
        SdkLiveInfoData.YYExt yYExt2 = sdkLiveInfoData.liveInfo.yyExt;
        YYLiveUtil.jumpToYYLiveRoom(tbPageContext, yYExt2.sid, yYExt2.ssid, yYExt2.templateId, sdkLiveInfoData.roomId, str);
    }

    public static YyExtData k(SdkLiveInfoData.YYExt yYExt) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65546, null, yYExt)) == null) {
            YyExtData yyExtData = new YyExtData();
            yyExtData.mSid = yYExt.sid;
            yyExtData.mSsid = yYExt.ssid;
            yyExtData.mYyUid = yYExt.yyUid;
            return yyExtData;
        }
        return (YyExtData) invokeL.objValue;
    }
}

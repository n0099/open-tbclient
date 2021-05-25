package d.a.n0.v.d.c;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.ala.data.SdkLiveInfoData;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.data.YyExtData;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tieba.R;
import d.a.c.e.p.j;
import d.a.c.e.p.k;
import d.a.c.e.p.l;
import d.a.m0.r.q.a2;
/* loaded from: classes4.dex */
public class c {
    public static int a(SdkLiveInfoData.AlaLiveInfo alaLiveInfo) {
        SdkLiveInfoData.YYExt yYExt = alaLiveInfo.yyExt;
        if (yYExt != null) {
            return yYExt.isYYGame == 1 ? 3 : 2;
        }
        return alaLiveInfo.liveType != 1 ? 5 : 1;
    }

    public static int[] b(Context context) {
        int dimensionPixelSize = l.p(context)[0] - (context.getResources().getDimensionPixelSize(R.dimen.tbds44) * 2);
        return new int[]{dimensionPixelSize, (int) ((dimensionPixelSize * 9.0d) / 16.0d)};
    }

    public static boolean c(SdkLiveInfoData sdkLiveInfoData) {
        return (sdkLiveInfoData == null || sdkLiveInfoData.liveInfo == null || k.isEmpty(sdkLiveInfoData.liveId) || k.isEmpty(sdkLiveInfoData.roomId) || !StringHelper.equals(sdkLiveInfoData.source, "jiaoyoufang") || sdkLiveInfoData.liveInfo.roomStatus != 2) ? false : true;
    }

    public static boolean d(SdkLiveInfoData sdkLiveInfoData) {
        SdkLiveInfoData.AlaLiveInfo alaLiveInfo;
        return (sdkLiveInfoData == null || (alaLiveInfo = sdkLiveInfoData.liveInfo) == null || alaLiveInfo.yyExt == null || k.isEmpty(sdkLiveInfoData.roomId) || k.isEmpty(sdkLiveInfoData.liveInfo.yyExt.sid) || k.isEmpty(sdkLiveInfoData.liveInfo.yyExt.ssid) || k.isEmpty(sdkLiveInfoData.liveInfo.yyExt.templateId)) ? false : true;
    }

    public static boolean e() {
        return TbSingleton.getInstance().getSyncYYSwitch() || TbSingleton.getInstance().isYYSwitchStatusIsOn();
    }

    public static void f(TbPageContext tbPageContext, SdkLiveInfoData sdkLiveInfoData, String str) {
        if (tbPageContext == null || sdkLiveInfoData == null) {
            return;
        }
        UrlManager urlManager = UrlManager.getInstance();
        urlManager.dealOneLink(tbPageContext, new String[]{"bdtiebalive://video/live?room_id=" + sdkLiveInfoData.roomId + "&live_id=" + sdkLiveInfoData.liveId + "&enterroom_type=1&from=" + str});
    }

    public static void g(Context context, a2 a2Var, String str) {
        String str2;
        boolean z;
        if (!j.z()) {
            l.J(context, context.getString(R.string.no_network_guide));
        } else if (context == null || a2Var == null || a2Var.T() == null || a2Var.r1() == null) {
        } else {
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                String userId = a2Var.T().getUserId();
                String currentAccount = TbadkCoreApplication.getCurrentAccount();
                z = TextUtils.equals(userId, currentAccount);
                str2 = currentAccount;
            } else {
                str2 = "";
                z = false;
            }
            AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
            alaLiveInfoCoreData.fillWithInfoData(a2Var.r1());
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(context, alaLiveInfoCoreData, null, str, str2, z, null, null)));
        }
    }

    public static void h(Context context, SdkLiveInfoData sdkLiveInfoData) {
        if (sdkLiveInfoData == null) {
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

    public static void i(Context context, a2 a2Var) {
        g(context, a2Var, AlaLiveRoomActivityConfig.FROM_TYPE_HOME_LIVE_TAB_MY_CONCERN);
    }

    public static void j(TbPageContext tbPageContext, SdkLiveInfoData sdkLiveInfoData) {
        SdkLiveInfoData.AlaLiveInfo alaLiveInfo;
        SdkLiveInfoData.YYExt yYExt;
        if (sdkLiveInfoData == null || (alaLiveInfo = sdkLiveInfoData.liveInfo) == null || (yYExt = alaLiveInfo.yyExt) == null || k.isEmpty(yYExt.sid) || k.isEmpty(sdkLiveInfoData.liveInfo.yyExt.ssid)) {
            return;
        }
        UrlManager.getInstance().dealOneLink(tbPageContext, new String[]{UrlSchemaHelper.SCHEMA_YY_LIVE_JOIN_LIVE_PREFIX + "sid=" + sdkLiveInfoData.liveInfo.yyExt.sid + "&ssid=" + sdkLiveInfoData.liveInfo.yyExt.ssid + "&templateId=" + sdkLiveInfoData.liveInfo.yyExt.templateId + "&roomId=" + sdkLiveInfoData.roomId});
    }

    public static YyExtData k(SdkLiveInfoData.YYExt yYExt) {
        YyExtData yyExtData = new YyExtData();
        yyExtData.mSid = yYExt.sid;
        String str = yYExt.ssid;
        yyExtData.mSsid = str;
        yyExtData.mYyUid = str;
        return yyExtData;
    }
}

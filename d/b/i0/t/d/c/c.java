package d.b.i0.t.d.c;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.ala.data.SdkLiveInfoData;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tieba.R;
import d.b.c.e.p.j;
import d.b.c.e.p.k;
import d.b.c.e.p.l;
import d.b.h0.r.q.a2;
/* loaded from: classes4.dex */
public class c {
    public static int[] a(Context context) {
        int dimensionPixelSize = l.p(context)[0] - (context.getResources().getDimensionPixelSize(R.dimen.tbds44) * 2);
        return new int[]{dimensionPixelSize, (int) ((dimensionPixelSize * 9.0d) / 16.0d)};
    }

    public static boolean b(SdkLiveInfoData sdkLiveInfoData) {
        return (sdkLiveInfoData == null || sdkLiveInfoData.liveInfo == null || k.isEmpty(sdkLiveInfoData.liveId) || k.isEmpty(sdkLiveInfoData.roomId) || !StringHelper.equals(sdkLiveInfoData.source, "jiaoyoufang") || sdkLiveInfoData.liveInfo.roomStatus != 2) ? false : true;
    }

    public static final void c(TbPageContext tbPageContext, String str, String str2) {
        UrlManager urlManager = UrlManager.getInstance();
        urlManager.dealOneLink(tbPageContext, new String[]{"tiebachushou://liveroom?roomid=" + str + "&livetype=" + str2});
    }

    public static void d(TbPageContext tbPageContext, SdkLiveInfoData sdkLiveInfoData, String str) {
        if (tbPageContext == null || sdkLiveInfoData == null) {
            return;
        }
        UrlManager urlManager = UrlManager.getInstance();
        urlManager.dealOneLink(tbPageContext, new String[]{"bdtiebalive://video/live?room_id=" + sdkLiveInfoData.roomId + "&live_id=" + sdkLiveInfoData.liveId + "&enterroom_type=1&from=" + str});
    }

    public static void e(Context context, a2 a2Var, String str) {
        String str2;
        boolean z;
        if (!j.z()) {
            l.I(context, context.getString(R.string.no_network_guide));
        } else if (context == null || a2Var == null || a2Var.T() == null || a2Var.q1() == null) {
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
            alaLiveInfoCoreData.fillWithInfoData(a2Var.q1());
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(context, alaLiveInfoCoreData, null, str, str2, z, null, null)));
        }
    }

    public static void f(Context context, SdkLiveInfoData sdkLiveInfoData) {
        if (sdkLiveInfoData == null) {
            return;
        }
        AlaLiveInfoCoreData alaLiveInfoCoreData = new AlaLiveInfoCoreData();
        alaLiveInfoCoreData.liveID = d.b.c.e.m.b.f(sdkLiveInfoData.liveId, 0L);
        alaLiveInfoCoreData.threadId = d.b.c.e.m.b.f(sdkLiveInfoData.tid, 0L);
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

    public static void g(Context context, a2 a2Var) {
        e(context, a2Var, AlaLiveRoomActivityConfig.FROM_TYPE_HOME_LIVE_TAB_MY_CONCERN);
    }
}

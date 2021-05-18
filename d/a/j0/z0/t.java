package d.a.j0.z0;

import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.core.atomData.VideoMiddlePageActivityConfig;
import com.baidu.tbadk.core.atomData.VideoMiddlePageLightActivityConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import com.baidu.tieba.video.VideoItemData;
import d.a.j0.r.q.a2;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class t {
    public static void a(boolean z, Context context, a2 a2Var, String str) {
        if (a2Var != null) {
            VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
            if (z) {
                videoSerializeVideoThreadInfo.copyFromTransmitThreadData(a2Var);
            } else {
                videoSerializeVideoThreadInfo.copyFromThreadInfo(a2Var);
            }
            VideoMiddlePageLightActivityConfig videoMiddlePageLightActivityConfig = new VideoMiddlePageLightActivityConfig(context, str, videoSerializeVideoThreadInfo.threadId, d.a.k0.x.m.g(), a2Var.l(), videoSerializeVideoThreadInfo);
            BaijiahaoData baijiahaoData = videoSerializeVideoThreadInfo.mBaijiahaoData;
            if (baijiahaoData != null && !TextUtils.isEmpty(baijiahaoData.oriUgcNid)) {
                videoMiddlePageLightActivityConfig.setNid(videoSerializeVideoThreadInfo.mBaijiahaoData.oriUgcNid);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, videoMiddlePageLightActivityConfig));
        }
    }

    public static void b(Context context, a2 a2Var, String str) {
        if (a2Var != null) {
            VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
            videoSerializeVideoThreadInfo.copyFromTransmitThreadData(a2Var);
            c(context, a2Var, str, videoSerializeVideoThreadInfo.threadId, d.a.k0.x.m.g(), a2Var.l(), videoSerializeVideoThreadInfo);
        }
    }

    public static void c(Context context, a2 a2Var, String str, String str2, String str3, String str4, VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo) {
        VideoMiddlePageActivityConfig videoMiddlePageActivityConfig = new VideoMiddlePageActivityConfig(context, str, str2, str3, str4, videoSerializeVideoThreadInfo);
        BaijiahaoData baijiahaoData = videoSerializeVideoThreadInfo.mBaijiahaoData;
        if (baijiahaoData != null && !TextUtils.isEmpty(baijiahaoData.oriUgcNid)) {
            videoMiddlePageActivityConfig.setNid(videoSerializeVideoThreadInfo.mBaijiahaoData.oriUgcNid);
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, videoMiddlePageActivityConfig));
    }

    public static void d(int i2, boolean z, Context context, a2 a2Var, int i3, Rect rect, String str, String str2, String str3, String str4, String str5) {
        if (a2Var == null) {
            return;
        }
        if (d.a.j0.b.d.K()) {
            a(true, context, a2Var, str4);
        } else if (d.a.j0.b.d.M()) {
            a2Var.m();
            f(true, context, a2Var, i3, rect, str, str2, str3, str4, str5);
        } else if (d.a.j0.b.d.P()) {
            ThreadCardUtils.jumpToPB(a2Var.r1, context, i2);
        } else if (z) {
            a2Var.m();
            f(true, context, a2Var, i3, rect, str, str2, str3, str4, str5);
        } else {
            b(context, a2Var, str4);
        }
    }

    public static void e(int i2, Context context, a2 a2Var, int i3, Rect rect, String str, String str2, String str3, String str4, String str5) {
        if (a2Var == null) {
            return;
        }
        if (d.a.j0.b.d.J()) {
            a(true, context, a2Var, str4);
        } else if (d.a.j0.b.d.L()) {
            a2Var.m();
            f(true, context, a2Var, i3, rect, str, str2, str3, str4, str5);
        } else {
            ThreadCardUtils.jumpToPB(a2Var.r1, context, i2);
        }
    }

    public static void f(boolean z, Context context, a2 a2Var, int i2, Rect rect, String str, String str2, String str3, String str4, String str5) {
        boolean z2;
        BaijiahaoData baijiahaoData;
        if (a2Var != null) {
            ArrayList arrayList = new ArrayList();
            VideoItemData videoItemData = new VideoItemData();
            if (z) {
                videoItemData.buildWithOriginThreadData(a2Var.r1);
            } else {
                videoItemData.buildWithThreadData(a2Var);
            }
            arrayList.add(videoItemData);
            OriginalThreadInfo originalThreadInfo = a2Var.r1;
            if (originalThreadInfo == null || originalThreadInfo.r == null) {
                z2 = true;
            } else {
                a2Var.m();
                z2 = a2Var.r1.r.is_vertical.intValue() == 1;
            }
            VideoPlayActivityConfig videoPlayActivityConfig = new VideoPlayActivityConfig(context, arrayList, i2, rect, str, str2, str3, str4, str5);
            videoPlayActivityConfig.setParamIsVertail(z2);
            OriginalThreadInfo originalThreadInfo2 = a2Var.r1;
            if (originalThreadInfo2 != null && (baijiahaoData = originalThreadInfo2.p) != null) {
                videoPlayActivityConfig.setNid(baijiahaoData.oriUgcNid);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, videoPlayActivityConfig));
        }
    }
}

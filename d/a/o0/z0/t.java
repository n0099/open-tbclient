package d.a.o0.z0;

import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.core.atomData.VideoMiddlePageActivityConfig;
import com.baidu.tbadk.core.atomData.VideoMiddlePageLightActivityConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tieba.play.monitor.VideoSerializeVideoThreadInfo;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import d.a.o0.r.q.b2;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public class t {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(boolean z, Context context, b2 b2Var, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65536, null, new Object[]{Boolean.valueOf(z), context, b2Var, str}) == null) || b2Var == null) {
            return;
        }
        VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
        if (z) {
            videoSerializeVideoThreadInfo.copyFromTransmitThreadData(b2Var);
        } else {
            videoSerializeVideoThreadInfo.copyFromThreadInfo(b2Var);
        }
        VideoMiddlePageLightActivityConfig videoMiddlePageLightActivityConfig = new VideoMiddlePageLightActivityConfig(context, str, videoSerializeVideoThreadInfo.threadId, d.a.p0.a0.m.g(), b2Var.getPbInputLocate(), videoSerializeVideoThreadInfo);
        BaijiahaoData baijiahaoData = videoSerializeVideoThreadInfo.mBaijiahaoData;
        if (baijiahaoData != null && !TextUtils.isEmpty(baijiahaoData.oriUgcNid)) {
            videoMiddlePageLightActivityConfig.setNid(videoSerializeVideoThreadInfo.mBaijiahaoData.oriUgcNid);
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, videoMiddlePageLightActivityConfig));
    }

    public static void b(Context context, b2 b2Var, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(65537, null, context, b2Var, str) == null) || b2Var == null) {
            return;
        }
        VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo = new VideoSerializeVideoThreadInfo();
        videoSerializeVideoThreadInfo.copyFromTransmitThreadData(b2Var);
        c(context, b2Var, str, videoSerializeVideoThreadInfo.threadId, d.a.p0.a0.m.g(), b2Var.getPbInputLocate(), videoSerializeVideoThreadInfo);
    }

    public static void c(Context context, b2 b2Var, String str, String str2, String str3, String str4, VideoSerializeVideoThreadInfo videoSerializeVideoThreadInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{context, b2Var, str, str2, str3, str4, videoSerializeVideoThreadInfo}) == null) {
            VideoMiddlePageActivityConfig videoMiddlePageActivityConfig = new VideoMiddlePageActivityConfig(context, str, str2, str3, str4, videoSerializeVideoThreadInfo);
            BaijiahaoData baijiahaoData = videoSerializeVideoThreadInfo.mBaijiahaoData;
            if (baijiahaoData != null && !TextUtils.isEmpty(baijiahaoData.oriUgcNid)) {
                videoMiddlePageActivityConfig.setNid(videoSerializeVideoThreadInfo.mBaijiahaoData.oriUgcNid);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, videoMiddlePageActivityConfig));
        }
    }

    public static void d(int i2, boolean z, Context context, b2 b2Var, int i3, Rect rect, String str, String str2, String str3, String str4, String str5) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{Integer.valueOf(i2), Boolean.valueOf(z), context, b2Var, Integer.valueOf(i3), rect, str, str2, str3, str4, str5}) == null) || b2Var == null) {
            return;
        }
        if (d.a.o0.b.d.V()) {
            a(true, context, b2Var, str4);
        } else if (d.a.o0.b.d.X()) {
            b2Var.getThreadData();
            f(true, context, b2Var, i3, rect, str, str2, str3, str4, str5);
        } else if (d.a.o0.b.d.a0()) {
            ThreadCardUtils.jumpToPB(b2Var.u1, context, i2);
        } else if (z) {
            b2Var.getThreadData();
            f(true, context, b2Var, i3, rect, str, str2, str3, str4, str5);
        } else {
            b(context, b2Var, str4);
        }
    }

    public static void e(int i2, Context context, b2 b2Var, int i3, Rect rect, String str, String str2, String str3, String str4, String str5) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{Integer.valueOf(i2), context, b2Var, Integer.valueOf(i3), rect, str, str2, str3, str4, str5}) == null) || b2Var == null) {
            return;
        }
        if (d.a.o0.b.d.U()) {
            a(true, context, b2Var, str4);
        } else if (d.a.o0.b.d.W()) {
            b2Var.getThreadData();
            f(true, context, b2Var, i3, rect, str, str2, str3, str4, str5);
        } else {
            ThreadCardUtils.jumpToPB(b2Var.u1, context, i2);
        }
    }

    public static void f(boolean z, Context context, b2 b2Var, int i2, Rect rect, String str, String str2, String str3, String str4, String str5) {
        boolean z2;
        BaijiahaoData baijiahaoData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(AdIconUtil.AD_TEXT_ID, null, new Object[]{Boolean.valueOf(z), context, b2Var, Integer.valueOf(i2), rect, str, str2, str3, str4, str5}) == null) || b2Var == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        VideoItemData videoItemData = new VideoItemData();
        if (z) {
            videoItemData.buildWithOriginThreadData(b2Var.u1);
        } else {
            videoItemData.buildWithThreadData(b2Var);
        }
        arrayList.add(videoItemData);
        OriginalThreadInfo originalThreadInfo = b2Var.u1;
        if (originalThreadInfo == null || originalThreadInfo.r == null) {
            z2 = true;
        } else {
            b2Var.getThreadData();
            z2 = b2Var.u1.r.is_vertical.intValue() == 1;
        }
        VideoPlayActivityConfig videoPlayActivityConfig = new VideoPlayActivityConfig(context, arrayList, i2, rect, str, str2, str3, str4, str5);
        videoPlayActivityConfig.setParamIsVertail(z2);
        OriginalThreadInfo originalThreadInfo2 = b2Var.u1;
        if (originalThreadInfo2 != null && (baijiahaoData = originalThreadInfo2.p) != null) {
            videoPlayActivityConfig.setNid(baijiahaoData.oriUgcNid);
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, videoPlayActivityConfig));
    }
}

package com.repackage;

import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.searchbox.fluency.BdTracesManager;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.atomData.FrsVideoTabPlayActivityConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.video.VideoItemData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class qd5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(int i, boolean z, Context context, ThreadData threadData, int i2, Rect rect, String str, String str2, String str3, String str4, String str5) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65536, null, new Object[]{Integer.valueOf(i), Boolean.valueOf(z), context, threadData, Integer.valueOf(i2), rect, str, str2, str3, str4, str5}) == null) || threadData == null) {
            return;
        }
        c(true, context, threadData.getThreadData(), i2, rect, str, str2, str3, str4, str5, threadData.isJumpToFrsVideoTabPlay);
    }

    public static void b(int i, Context context, ThreadData threadData, int i2, Rect rect, String str, String str2, String str3, String str4, String str5) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{Integer.valueOf(i), context, threadData, Integer.valueOf(i2), rect, str, str2, str3, str4, str5}) == null) || threadData == null) {
            return;
        }
        c(true, context, threadData.getThreadData(), i2, rect, str, str2, str3, str4, str5, threadData.isJumpToFrsVideoTabPlay);
    }

    public static void c(boolean z, Context context, ThreadData threadData, int i, Rect rect, String str, String str2, String str3, String str4, String str5, boolean z2) {
        BaijiahaoData baijiahaoData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{Boolean.valueOf(z), context, threadData, Integer.valueOf(i), rect, str, str2, str3, str4, str5, Boolean.valueOf(z2)}) == null) || threadData == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        VideoItemData videoItemData = new VideoItemData();
        if (z) {
            videoItemData.buildWithOriginThreadData(threadData.originalThreadData);
        } else {
            videoItemData.buildWithThreadData(threadData);
        }
        arrayList.add(videoItemData);
        OriginalThreadInfo originalThreadInfo = threadData.originalThreadData;
        boolean z3 = true;
        if (originalThreadInfo != null && originalThreadInfo.r != null && threadData.getThreadData().originalThreadData.r.is_vertical.intValue() != 1) {
            z3 = false;
        }
        String str6 = null;
        OriginalThreadInfo originalThreadInfo2 = threadData.originalThreadData;
        if (originalThreadInfo2 != null && (baijiahaoData = originalThreadInfo2.p) != null) {
            str6 = baijiahaoData.oriUgcNid;
        }
        e(context, arrayList, str6, z3, i, rect, str, str2, str3, str4, str5, false, z2, true);
    }

    public static void d(Context context, List<VideoItemData> list, String str, boolean z, int i, Rect rect, String str2, String str3, String str4, String str5, String str6, boolean z2, boolean z3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{context, list, str, Boolean.valueOf(z), Integer.valueOf(i), rect, str2, str3, str4, str5, str6, Boolean.valueOf(z2), Boolean.valueOf(z3)}) == null) {
            e(context, list, str, z, i, rect, str2, str3, str4, str5, str6, z2, z3, false);
        }
    }

    public static void e(Context context, List<VideoItemData> list, String str, boolean z, int i, Rect rect, String str2, String str3, String str4, String str5, String str6, boolean z2, boolean z3, boolean z4) {
        String str7;
        String str8;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, null, new Object[]{context, list, str, Boolean.valueOf(z), Integer.valueOf(i), rect, str2, str3, str4, str5, str6, Boolean.valueOf(z2), Boolean.valueOf(z3), Boolean.valueOf(z4)}) == null) {
            VideoPlayActivityConfig videoPlayActivityConfig = new VideoPlayActivityConfig(context, list, i, rect, str2, str3, str4, str5, str6);
            if (z4) {
                videoPlayActivityConfig.setForceUseBigDataList(list);
            }
            videoPlayActivityConfig.setParamIsVertail(z);
            TbSingleton.getInstance().setIsNeedShowPbCommentFloat(z2);
            if (str != null) {
                videoPlayActivityConfig.setNid(str);
            }
            if (UbsABTestHelper.isFeedVideoImmersionTransition()) {
                TbSingleton.getInstance().setIsNeedReuseVideoPlayer(true);
            }
            if (z3) {
                if (ListUtils.getCount(list) <= 0 || list.get(0) == null || TextUtils.isEmpty(list.get(0).thread_id)) {
                    str7 = "";
                } else {
                    String str9 = list.get(0).thread_id;
                    str7 = list.get(0).forum_id;
                    List<VideoItemData> videoTabListByFid = FrsVideoTabPlayActivityConfig.getVideoTabListByFid(str7);
                    int size = videoTabListByFid.size();
                    for (int i3 = 0; i3 < size; i3++) {
                        if (videoTabListByFid.get(i3) != null && str9.equals(videoTabListByFid.get(i3).thread_id)) {
                            str8 = str7;
                            i2 = i3;
                            break;
                        }
                    }
                }
                str8 = str7;
                i2 = 0;
                FrsVideoTabPlayActivityConfig frsVideoTabPlayActivityConfig = new FrsVideoTabPlayActivityConfig(context, null, i2, rect, str2, str3, str4, str5, str6);
                frsVideoTabPlayActivityConfig.setIsShowPbCommentFloat(z2);
                frsVideoTabPlayActivityConfig.setFid(str8);
                if ("frs".equals(str5)) {
                    BdTracesManager.INSTANCE.getFpsTracer().beginFpsCollect(FrsVideoTabPlayActivityConfig.KEY_FPS_MIDDLE_VIDEO_FROM, FrsVideoTabPlayActivityConfig.KEY_FPS_MIDDLE_VIDEO_PAGE, "tran");
                }
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, frsVideoTabPlayActivityConfig));
                return;
            }
            if ("frs".equals(str5)) {
                BdTracesManager.INSTANCE.getFpsTracer().beginFpsCollect(VideoPlayActivityConfig.KEY_FPS_VIDEO_FROM_FRS, "video", "tran");
            } else if ("index".equals(str5)) {
                BdTracesManager.INSTANCE.getFpsTracer().beginFpsCollect(VideoPlayActivityConfig.KEY_FPS_VIDEO_FROM_HOME, "video", "tran");
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, videoPlayActivityConfig));
        }
    }
}

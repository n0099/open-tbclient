package com.repackage;

import android.view.View;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.TiebaStaticHelper;
import com.baidu.tbadk.core.util.YYLiveUtil;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
import tbclient.DiscoverHotForum;
import tbclient.DiscoverTabCard;
import tbclient.RecommendForumInfo;
/* loaded from: classes7.dex */
public class ou6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(ThreadData threadData, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65536, null, threadData, i) == null) {
            TiebaStatic.log(i != 1 ? null : bj8.k("c13692", threadData, 3));
        }
    }

    public static void b(View view2, fo4 fo4Var, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(65537, null, view2, fo4Var, i) == null) || view2 == null || fo4Var == null || fo4Var.getThreadData() == null || StringUtils.isNull(fo4Var.getThreadData().getTid())) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.CONCERN_TAB_THREAD_CLICK);
        ThreadData threadData = fo4Var.getThreadData();
        if (threadData.isLinkThread()) {
            statisticItem.param("obj_type", 4);
        } else if (threadData.isShareThread) {
            statisticItem.param("obj_type", 5);
        } else if (threadData.isBJHArticleThreadType()) {
            statisticItem.param("obj_type", 6);
        } else if (threadData.isBJHNormalThreadType()) {
            statisticItem.param("obj_type", 7);
        } else if (threadData.isBJHVideoThreadType()) {
            statisticItem.param("obj_type", 8);
        } else if (threadData.isBJHVideoDynamicThreadType()) {
            statisticItem.param("obj_type", 9);
        } else if (threadData.getType() == ThreadData.TYPE_NORMAL) {
            statisticItem.param("obj_type", 1);
        } else if (threadData.isVideoThreadType()) {
            statisticItem.param("obj_type", 2);
        }
        statisticItem.param("obj_locate", i);
        if (i == 3 || (i == 6 && (view2 instanceof TbImageView))) {
            statisticItem.param(TiebaStatic.Params.OBJ_TO, UbsABTestHelper.isImgClickToPb() ? 1 : 2);
        }
        statisticItem.param("tid", fo4Var.getThreadData().getTid());
        statisticItem.param("fid", fo4Var.getThreadData().getFid());
        statisticItem.param("fname", fo4Var.getThreadData().getForum_name());
        statisticItem.param("obj_source", 1);
        if (fo4Var instanceof f06) {
            statisticItem.param("obj_param1", ((f06) fo4Var).E() ? 2 : 1);
        }
        if (fo4Var.getThreadData().getAuthor() != null) {
            statisticItem.param("uid", fo4Var.getThreadData().getAuthor().getUserId());
        }
        if (threadData.getBaijiahaoData() != null) {
            statisticItem.param("obj_id", threadData.getBaijiahaoData().oriUgcNid);
        } else {
            statisticItem.param("obj_id", threadData.getTid());
        }
        if (fo4Var.getThreadData().getThreadAlaInfo() != null) {
            int calculateLiveType = YYLiveUtil.calculateLiveType(fo4Var.getThreadData().getThreadAlaInfo());
            if (fo4Var.getThreadData().getThreadAlaInfo().mYyExtData != null) {
                TiebaStaticHelper.addYYParam(statisticItem, fo4Var.getThreadData().getThreadAlaInfo().mYyExtData);
            }
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, calculateLiveType);
        }
        TiebaStatic.log(statisticItem);
        a(threadData, i);
    }

    public static boolean c(DiscoverHotForum.Builder builder, long j, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65538, null, new Object[]{builder, Long.valueOf(j), Boolean.valueOf(z)})) == null) {
            if (j != 0 && builder != null) {
                List<DiscoverTabCard> list = builder.tab_list;
                if (ListUtils.isEmpty(list)) {
                    return false;
                }
                for (int i = 0; i < list.size(); i++) {
                    DiscoverTabCard.Builder builder2 = new DiscoverTabCard.Builder(list.get(i));
                    List<RecommendForumInfo> list2 = builder2.forum_list;
                    if (!ListUtils.isEmpty(list2)) {
                        for (int i2 = 0; i2 < list2.size(); i2++) {
                            RecommendForumInfo.Builder builder3 = new RecommendForumInfo.Builder(list2.get(i2));
                            if (builder3.forum_id.longValue() == j && builder3.is_like.intValue() != z) {
                                builder3.is_like = Integer.valueOf(z ? 1 : 0);
                                list2.set(i2, builder3.build(true));
                                list.set(i, builder2.build(true));
                                return true;
                            }
                        }
                        continue;
                    }
                }
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }
}

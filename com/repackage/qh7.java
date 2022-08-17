package com.repackage;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.ArrayList;
import java.util.List;
import tbclient.Item;
import tbclient.RecommendForumInfo;
import tbclient.SearchSug.DataRes;
import tbclient.SugLiveInfo;
import tbclient.SugRankingInfo;
/* loaded from: classes7.dex */
public class qh7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static List<on> a(DataRes dataRes, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, dataRes, str)) == null) {
            if (dataRes == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            RecommendForumInfo recommendForumInfo = dataRes.forum_card;
            if (recommendForumInfo != null) {
                mh7 mh7Var = new mh7();
                mh7Var.j(recommendForumInfo);
                arrayList.add(mh7Var);
            }
            Item item = dataRes.item_card;
            if (item != null) {
                nh7 nh7Var = new nh7();
                nh7Var.j(item);
                arrayList.add(nh7Var);
            }
            for (SugLiveInfo sugLiveInfo : dataRes.live_card) {
                oh7 oh7Var = new oh7();
                oh7Var.o(str);
                oh7Var.n(sugLiveInfo);
                arrayList.add(oh7Var);
            }
            SugRankingInfo sugRankingInfo = dataRes.ranking_card;
            if (sugRankingInfo != null) {
                ph7 ph7Var = new ph7();
                ph7Var.h(str);
                ph7Var.g(sugRankingInfo);
                arrayList.add(ph7Var);
            }
            int size = arrayList.size();
            for (String str2 : dataRes.list) {
                lh7 lh7Var = new lh7();
                lh7Var.c(str);
                lh7Var.f(str2);
                if (!StringUtils.isNull(str2) && !StringUtils.isNull(str) && str2.trim().equals(str.trim())) {
                    arrayList.add(size, lh7Var);
                } else {
                    arrayList.add(lh7Var);
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }
}

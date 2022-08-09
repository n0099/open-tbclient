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
public class rh7 {
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
                nh7 nh7Var = new nh7();
                nh7Var.j(recommendForumInfo);
                arrayList.add(nh7Var);
            }
            Item item = dataRes.item_card;
            if (item != null) {
                oh7 oh7Var = new oh7();
                oh7Var.j(item);
                arrayList.add(oh7Var);
            }
            for (SugLiveInfo sugLiveInfo : dataRes.live_card) {
                ph7 ph7Var = new ph7();
                ph7Var.o(str);
                ph7Var.n(sugLiveInfo);
                arrayList.add(ph7Var);
            }
            SugRankingInfo sugRankingInfo = dataRes.ranking_card;
            if (sugRankingInfo != null) {
                qh7 qh7Var = new qh7();
                qh7Var.h(str);
                qh7Var.g(sugRankingInfo);
                arrayList.add(qh7Var);
            }
            int size = arrayList.size();
            for (String str2 : dataRes.list) {
                mh7 mh7Var = new mh7();
                mh7Var.c(str);
                mh7Var.f(str2);
                if (!StringUtils.isNull(str2) && !StringUtils.isNull(str) && str2.trim().equals(str.trim())) {
                    arrayList.add(size, mh7Var);
                } else {
                    arrayList.add(mh7Var);
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }
}

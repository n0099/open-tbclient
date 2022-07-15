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
public class wf7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static List<nn> a(DataRes dataRes, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, dataRes, str)) == null) {
            if (dataRes == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            RecommendForumInfo recommendForumInfo = dataRes.forum_card;
            if (recommendForumInfo != null) {
                sf7 sf7Var = new sf7();
                sf7Var.i(recommendForumInfo);
                arrayList.add(sf7Var);
            }
            Item item = dataRes.item_card;
            if (item != null) {
                tf7 tf7Var = new tf7();
                tf7Var.i(item);
                arrayList.add(tf7Var);
            }
            for (SugLiveInfo sugLiveInfo : dataRes.live_card) {
                uf7 uf7Var = new uf7();
                uf7Var.o(str);
                uf7Var.m(sugLiveInfo);
                arrayList.add(uf7Var);
            }
            SugRankingInfo sugRankingInfo = dataRes.ranking_card;
            if (sugRankingInfo != null) {
                vf7 vf7Var = new vf7();
                vf7Var.h(str);
                vf7Var.g(sugRankingInfo);
                arrayList.add(vf7Var);
            }
            int size = arrayList.size();
            for (String str2 : dataRes.list) {
                rf7 rf7Var = new rf7();
                rf7Var.c(str);
                rf7Var.d(str2);
                if (!StringUtils.isNull(str2) && !StringUtils.isNull(str) && str2.trim().equals(str.trim())) {
                    arrayList.add(size, rf7Var);
                } else {
                    arrayList.add(rf7Var);
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }
}

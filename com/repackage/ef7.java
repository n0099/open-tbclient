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
/* loaded from: classes5.dex */
public class ef7 {
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
                af7 af7Var = new af7();
                af7Var.j(recommendForumInfo);
                arrayList.add(af7Var);
            }
            Item item = dataRes.item_card;
            if (item != null) {
                bf7 bf7Var = new bf7();
                bf7Var.j(item);
                arrayList.add(bf7Var);
            }
            for (SugLiveInfo sugLiveInfo : dataRes.live_card) {
                cf7 cf7Var = new cf7();
                cf7Var.o(str);
                cf7Var.n(sugLiveInfo);
                arrayList.add(cf7Var);
            }
            SugRankingInfo sugRankingInfo = dataRes.ranking_card;
            if (sugRankingInfo != null) {
                df7 df7Var = new df7();
                df7Var.h(str);
                df7Var.g(sugRankingInfo);
                arrayList.add(df7Var);
            }
            int size = arrayList.size();
            for (String str2 : dataRes.list) {
                ze7 ze7Var = new ze7();
                ze7Var.c(str);
                ze7Var.f(str2);
                if (!StringUtils.isNull(str2) && !StringUtils.isNull(str) && str2.trim().equals(str.trim())) {
                    arrayList.add(size, ze7Var);
                } else {
                    arrayList.add(ze7Var);
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }
}

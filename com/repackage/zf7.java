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
public class zf7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static List<uo> a(DataRes dataRes, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, dataRes, str)) == null) {
            if (dataRes == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            RecommendForumInfo recommendForumInfo = dataRes.forum_card;
            if (recommendForumInfo != null) {
                vf7 vf7Var = new vf7();
                vf7Var.j(recommendForumInfo);
                arrayList.add(vf7Var);
            }
            Item item = dataRes.item_card;
            if (item != null) {
                wf7 wf7Var = new wf7();
                wf7Var.j(item);
                arrayList.add(wf7Var);
            }
            for (SugLiveInfo sugLiveInfo : dataRes.live_card) {
                xf7 xf7Var = new xf7();
                xf7Var.p(str);
                xf7Var.n(sugLiveInfo);
                arrayList.add(xf7Var);
            }
            SugRankingInfo sugRankingInfo = dataRes.ranking_card;
            if (sugRankingInfo != null) {
                yf7 yf7Var = new yf7();
                yf7Var.i(str);
                yf7Var.g(sugRankingInfo);
                arrayList.add(yf7Var);
            }
            int size = arrayList.size();
            for (String str2 : dataRes.list) {
                uf7 uf7Var = new uf7();
                uf7Var.e(str);
                uf7Var.f(str2);
                if (!StringUtils.isNull(str2) && !StringUtils.isNull(str) && str2.trim().equals(str.trim())) {
                    arrayList.add(size, uf7Var);
                } else {
                    arrayList.add(uf7Var);
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }
}

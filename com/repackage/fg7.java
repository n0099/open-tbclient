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
/* loaded from: classes6.dex */
public class fg7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static List<ro> a(DataRes dataRes, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, dataRes, str)) == null) {
            if (dataRes == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            RecommendForumInfo recommendForumInfo = dataRes.forum_card;
            if (recommendForumInfo != null) {
                bg7 bg7Var = new bg7();
                bg7Var.j(recommendForumInfo);
                arrayList.add(bg7Var);
            }
            Item item = dataRes.item_card;
            if (item != null) {
                cg7 cg7Var = new cg7();
                cg7Var.j(item);
                arrayList.add(cg7Var);
            }
            for (SugLiveInfo sugLiveInfo : dataRes.live_card) {
                dg7 dg7Var = new dg7();
                dg7Var.p(str);
                dg7Var.n(sugLiveInfo);
                arrayList.add(dg7Var);
            }
            SugRankingInfo sugRankingInfo = dataRes.ranking_card;
            if (sugRankingInfo != null) {
                eg7 eg7Var = new eg7();
                eg7Var.i(str);
                eg7Var.g(sugRankingInfo);
                arrayList.add(eg7Var);
            }
            int size = arrayList.size();
            for (String str2 : dataRes.list) {
                ag7 ag7Var = new ag7();
                ag7Var.e(str);
                ag7Var.f(str2);
                if (!StringUtils.isNull(str2) && !StringUtils.isNull(str) && str2.trim().equals(str.trim())) {
                    arrayList.add(size, ag7Var);
                } else {
                    arrayList.add(ag7Var);
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }
}

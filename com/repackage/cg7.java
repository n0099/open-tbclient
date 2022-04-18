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
public class cg7 {
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
                yf7 yf7Var = new yf7();
                yf7Var.j(recommendForumInfo);
                arrayList.add(yf7Var);
            }
            Item item = dataRes.item_card;
            if (item != null) {
                zf7 zf7Var = new zf7();
                zf7Var.j(item);
                arrayList.add(zf7Var);
            }
            for (SugLiveInfo sugLiveInfo : dataRes.live_card) {
                ag7 ag7Var = new ag7();
                ag7Var.p(str);
                ag7Var.n(sugLiveInfo);
                arrayList.add(ag7Var);
            }
            SugRankingInfo sugRankingInfo = dataRes.ranking_card;
            if (sugRankingInfo != null) {
                bg7 bg7Var = new bg7();
                bg7Var.i(str);
                bg7Var.g(sugRankingInfo);
                arrayList.add(bg7Var);
            }
            int size = arrayList.size();
            for (String str2 : dataRes.list) {
                xf7 xf7Var = new xf7();
                xf7Var.e(str);
                xf7Var.f(str2);
                if (!StringUtils.isNull(str2) && !StringUtils.isNull(str) && str2.trim().equals(str.trim())) {
                    arrayList.add(size, xf7Var);
                } else {
                    arrayList.add(xf7Var);
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }
}

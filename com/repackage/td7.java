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
public class td7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static List<jn> a(DataRes dataRes, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65536, null, dataRes, str)) == null) {
            if (dataRes == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            RecommendForumInfo recommendForumInfo = dataRes.forum_card;
            if (recommendForumInfo != null) {
                pd7 pd7Var = new pd7();
                pd7Var.j(recommendForumInfo);
                arrayList.add(pd7Var);
            }
            Item item = dataRes.item_card;
            if (item != null) {
                qd7 qd7Var = new qd7();
                qd7Var.j(item);
                arrayList.add(qd7Var);
            }
            for (SugLiveInfo sugLiveInfo : dataRes.live_card) {
                rd7 rd7Var = new rd7();
                rd7Var.p(str);
                rd7Var.n(sugLiveInfo);
                arrayList.add(rd7Var);
            }
            SugRankingInfo sugRankingInfo = dataRes.ranking_card;
            if (sugRankingInfo != null) {
                sd7 sd7Var = new sd7();
                sd7Var.i(str);
                sd7Var.g(sugRankingInfo);
                arrayList.add(sd7Var);
            }
            int size = arrayList.size();
            for (String str2 : dataRes.list) {
                od7 od7Var = new od7();
                od7Var.e(str);
                od7Var.f(str2);
                if (!StringUtils.isNull(str2) && !StringUtils.isNull(str) && str2.trim().equals(str.trim())) {
                    arrayList.add(size, od7Var);
                } else {
                    arrayList.add(od7Var);
                }
            }
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }
}

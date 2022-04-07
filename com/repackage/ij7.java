package com.repackage;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import tbclient.GetVipInfo.DataRes;
import tbclient.GetVipInfo.VipBasicList;
import tbclient.GetVipInfo.VipSpecialItem;
/* loaded from: classes6.dex */
public class ij7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<String> a;
    public vi7 b;
    public LinkedHashMap<String, yi7> c;

    public ij7(DataRes dataRes) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {dataRes};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        if (dataRes == null) {
            return;
        }
        String str = dataRes.grade_intro_title;
        String str2 = dataRes.grade_intro_link;
        new hj7(dataRes);
        new jj7(dataRes.special_list);
        new aj7(dataRes.cooperate_list);
        new ej7(dataRes.theme_list);
        new wi7(dataRes.banner_list);
        new mj7(dataRes.task_list);
        new lj7(dataRes.rank, dataRes.user);
        new cj7(dataRes.daily_list);
        vi7 vi7Var = new vi7();
        this.b = vi7Var;
        vi7Var.a(dataRes);
        List<VipBasicList> list = dataRes.basic_list;
        if (list != null && list.size() > 0) {
            this.c = new LinkedHashMap<>();
            for (VipBasicList vipBasicList : dataRes.basic_list) {
                List<VipSpecialItem> list2 = vipBasicList.item;
                if (list2 != null && list2.size() > 0) {
                    yi7 yi7Var = new yi7(vipBasicList);
                    if (yi7Var.c != 3 || yi7Var.a().size() >= 2) {
                        this.c.put(yi7Var.d, yi7Var);
                    }
                }
            }
        }
        List<String> list3 = dataRes.card_order;
        if (list3 == null || list3.size() <= 0) {
            return;
        }
        this.a = new ArrayList<>();
        for (String str3 : dataRes.card_order) {
            if (!StringUtils.isNull(str3)) {
                this.a.add(str3);
            }
        }
    }
}

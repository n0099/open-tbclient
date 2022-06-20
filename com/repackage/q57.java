package com.repackage;

import com.baidu.tieba.im.db.pojo.ApkDetailPojo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import protobuf.Item;
/* loaded from: classes6.dex */
public class q57 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Long a;
    public String b;
    public Double c;
    public String d;
    public List<String> e;
    public Double f;
    public Integer g;
    public String h;
    public String i;
    public String j;
    public Integer k;
    public Integer l;
    public String m;
    public String n;
    public ApkDetailPojo o;

    public q57() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static q57 a(Item item) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, item)) == null) {
            if (item == null) {
                return null;
            }
            q57 q57Var = new q57();
            q57Var.a = item.itemId;
            q57Var.b = item.itemName;
            q57Var.c = item.iconSize;
            q57Var.d = item.iconUrl;
            q57Var.e = item.tags;
            q57Var.f = item.score;
            q57Var.g = item.star;
            q57Var.h = item.buttonName;
            q57Var.i = item.buttonLink;
            q57Var.j = item.itemAppid;
            q57Var.k = item.categoryId;
            q57Var.l = item.buttonLinkType;
            q57Var.m = item.apkName;
            q57Var.n = item.forumName;
            q57Var.o = ApkDetailPojo.z(item.apkDetail);
            return q57Var;
        }
        return (q57) invokeL.objValue;
    }

    public static q57 b(tbclient.Item item) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, item)) == null) {
            if (item == null) {
                return null;
            }
            q57 q57Var = new q57();
            q57Var.a = item.item_id;
            q57Var.b = item.item_name;
            q57Var.c = item.icon_size;
            q57Var.d = item.icon_url;
            q57Var.e = item.tags;
            q57Var.f = item.score;
            q57Var.g = item.star;
            q57Var.h = item.button_name;
            q57Var.i = item.button_link;
            q57Var.j = item.item_appid;
            q57Var.k = item.category_id;
            q57Var.l = item.button_link_type;
            q57Var.m = item.apk_name;
            q57Var.n = item.forum_name;
            q57Var.o = ApkDetailPojo.A(item.apk_detail);
            return q57Var;
        }
        return (q57) invokeL.objValue;
    }
}

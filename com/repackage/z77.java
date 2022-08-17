package com.repackage;

import com.baidu.tieba.im.db.pojo.ApkDetailPojo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import protobuf.Item;
/* loaded from: classes7.dex */
public class z77 {
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

    public z77() {
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

    public static z77 a(Item item) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, item)) == null) {
            if (item == null) {
                return null;
            }
            z77 z77Var = new z77();
            z77Var.a = item.itemId;
            z77Var.b = item.itemName;
            z77Var.c = item.iconSize;
            z77Var.d = item.iconUrl;
            z77Var.e = item.tags;
            z77Var.f = item.score;
            z77Var.g = item.star;
            z77Var.h = item.buttonName;
            z77Var.i = item.buttonLink;
            z77Var.j = item.itemAppid;
            z77Var.k = item.categoryId;
            z77Var.l = item.buttonLinkType;
            z77Var.m = item.apkName;
            z77Var.n = item.forumName;
            z77Var.o = ApkDetailPojo.z(item.apkDetail);
            return z77Var;
        }
        return (z77) invokeL.objValue;
    }

    public static z77 b(tbclient.Item item) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, item)) == null) {
            if (item == null) {
                return null;
            }
            z77 z77Var = new z77();
            z77Var.a = item.item_id;
            z77Var.b = item.item_name;
            z77Var.c = item.icon_size;
            z77Var.d = item.icon_url;
            z77Var.e = item.tags;
            z77Var.f = item.score;
            z77Var.g = item.star;
            z77Var.h = item.button_name;
            z77Var.i = item.button_link;
            z77Var.j = item.item_appid;
            z77Var.k = item.category_id;
            z77Var.l = item.button_link_type;
            z77Var.m = item.apk_name;
            z77Var.n = item.forum_name;
            z77Var.o = ApkDetailPojo.A(item.apk_detail);
            return z77Var;
        }
        return (z77) invokeL.objValue;
    }
}

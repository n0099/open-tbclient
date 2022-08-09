package com.repackage;

import com.baidu.tieba.im.db.pojo.ApkDetailPojo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import protobuf.Item;
/* loaded from: classes5.dex */
public class b87 {
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

    public b87() {
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

    public static b87 a(Item item) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, item)) == null) {
            if (item == null) {
                return null;
            }
            b87 b87Var = new b87();
            b87Var.a = item.itemId;
            b87Var.b = item.itemName;
            b87Var.c = item.iconSize;
            b87Var.d = item.iconUrl;
            b87Var.e = item.tags;
            b87Var.f = item.score;
            b87Var.g = item.star;
            b87Var.h = item.buttonName;
            b87Var.i = item.buttonLink;
            b87Var.j = item.itemAppid;
            b87Var.k = item.categoryId;
            b87Var.l = item.buttonLinkType;
            b87Var.m = item.apkName;
            b87Var.n = item.forumName;
            b87Var.o = ApkDetailPojo.z(item.apkDetail);
            return b87Var;
        }
        return (b87) invokeL.objValue;
    }

    public static b87 b(tbclient.Item item) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, item)) == null) {
            if (item == null) {
                return null;
            }
            b87 b87Var = new b87();
            b87Var.a = item.item_id;
            b87Var.b = item.item_name;
            b87Var.c = item.icon_size;
            b87Var.d = item.icon_url;
            b87Var.e = item.tags;
            b87Var.f = item.score;
            b87Var.g = item.star;
            b87Var.h = item.button_name;
            b87Var.i = item.button_link;
            b87Var.j = item.item_appid;
            b87Var.k = item.category_id;
            b87Var.l = item.button_link_type;
            b87Var.m = item.apk_name;
            b87Var.n = item.forum_name;
            b87Var.o = ApkDetailPojo.A(item.apk_detail);
            return b87Var;
        }
        return (b87) invokeL.objValue;
    }
}

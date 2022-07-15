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
public class h67 {
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

    public h67() {
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

    public static h67 a(Item item) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, item)) == null) {
            if (item == null) {
                return null;
            }
            h67 h67Var = new h67();
            h67Var.a = item.itemId;
            h67Var.b = item.itemName;
            h67Var.c = item.iconSize;
            h67Var.d = item.iconUrl;
            h67Var.e = item.tags;
            h67Var.f = item.score;
            h67Var.g = item.star;
            h67Var.h = item.buttonName;
            h67Var.i = item.buttonLink;
            h67Var.j = item.itemAppid;
            h67Var.k = item.categoryId;
            h67Var.l = item.buttonLinkType;
            h67Var.m = item.apkName;
            h67Var.n = item.forumName;
            h67Var.o = ApkDetailPojo.A(item.apkDetail);
            return h67Var;
        }
        return (h67) invokeL.objValue;
    }

    public static h67 b(tbclient.Item item) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, item)) == null) {
            if (item == null) {
                return null;
            }
            h67 h67Var = new h67();
            h67Var.a = item.item_id;
            h67Var.b = item.item_name;
            h67Var.c = item.icon_size;
            h67Var.d = item.icon_url;
            h67Var.e = item.tags;
            h67Var.f = item.score;
            h67Var.g = item.star;
            h67Var.h = item.button_name;
            h67Var.i = item.button_link;
            h67Var.j = item.item_appid;
            h67Var.k = item.category_id;
            h67Var.l = item.button_link_type;
            h67Var.m = item.apk_name;
            h67Var.n = item.forum_name;
            h67Var.o = ApkDetailPojo.B(item.apk_detail);
            return h67Var;
        }
        return (h67) invokeL.objValue;
    }
}

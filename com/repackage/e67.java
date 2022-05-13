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
public class e67 {
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

    public e67() {
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

    public static e67 a(Item item) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, item)) == null) {
            if (item == null) {
                return null;
            }
            e67 e67Var = new e67();
            e67Var.a = item.itemId;
            e67Var.b = item.itemName;
            e67Var.c = item.iconSize;
            e67Var.d = item.iconUrl;
            e67Var.e = item.tags;
            e67Var.f = item.score;
            e67Var.g = item.star;
            e67Var.h = item.buttonName;
            e67Var.i = item.buttonLink;
            e67Var.j = item.itemAppid;
            e67Var.k = item.categoryId;
            e67Var.l = item.buttonLinkType;
            e67Var.m = item.apkName;
            e67Var.n = item.forumName;
            e67Var.o = ApkDetailPojo.y(item.apkDetail);
            return e67Var;
        }
        return (e67) invokeL.objValue;
    }

    public static e67 b(tbclient.Item item) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, item)) == null) {
            if (item == null) {
                return null;
            }
            e67 e67Var = new e67();
            e67Var.a = item.item_id;
            e67Var.b = item.item_name;
            e67Var.c = item.icon_size;
            e67Var.d = item.icon_url;
            e67Var.e = item.tags;
            e67Var.f = item.score;
            e67Var.g = item.star;
            e67Var.h = item.button_name;
            e67Var.i = item.button_link;
            e67Var.j = item.item_appid;
            e67Var.k = item.category_id;
            e67Var.l = item.button_link_type;
            e67Var.m = item.apk_name;
            e67Var.n = item.forum_name;
            e67Var.o = ApkDetailPojo.z(item.apk_detail);
            return e67Var;
        }
        return (e67) invokeL.objValue;
    }
}

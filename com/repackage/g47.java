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
public class g47 {
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

    public g47() {
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

    public static g47 a(Item item) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, item)) == null) {
            if (item == null) {
                return null;
            }
            g47 g47Var = new g47();
            g47Var.a = item.itemId;
            g47Var.b = item.itemName;
            g47Var.c = item.iconSize;
            g47Var.d = item.iconUrl;
            g47Var.e = item.tags;
            g47Var.f = item.score;
            g47Var.g = item.star;
            g47Var.h = item.buttonName;
            g47Var.i = item.buttonLink;
            g47Var.j = item.itemAppid;
            g47Var.k = item.categoryId;
            g47Var.l = item.buttonLinkType;
            g47Var.m = item.apkName;
            g47Var.n = item.forumName;
            g47Var.o = ApkDetailPojo.y(item.apkDetail);
            return g47Var;
        }
        return (g47) invokeL.objValue;
    }

    public static g47 b(tbclient.Item item) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, item)) == null) {
            if (item == null) {
                return null;
            }
            g47 g47Var = new g47();
            g47Var.a = item.item_id;
            g47Var.b = item.item_name;
            g47Var.c = item.icon_size;
            g47Var.d = item.icon_url;
            g47Var.e = item.tags;
            g47Var.f = item.score;
            g47Var.g = item.star;
            g47Var.h = item.button_name;
            g47Var.i = item.button_link;
            g47Var.j = item.item_appid;
            g47Var.k = item.category_id;
            g47Var.l = item.button_link_type;
            g47Var.m = item.apk_name;
            g47Var.n = item.forum_name;
            g47Var.o = ApkDetailPojo.z(item.apk_detail);
            return g47Var;
        }
        return (g47) invokeL.objValue;
    }
}

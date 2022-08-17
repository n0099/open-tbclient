package com.repackage;

import android.content.Context;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.SearchSug.DataRes;
/* loaded from: classes6.dex */
public class eh7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdTypeRecyclerView a;
    public final List<bn> b;
    public gh7 c;
    public jh7 d;
    public hh7 e;
    public ih7 f;
    public kh7 g;

    public eh7(Context context, BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, bdTypeRecyclerView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = new ArrayList();
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        a(context, bdTypeRecyclerView);
    }

    public final void a(Context context, BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, context, bdTypeRecyclerView) == null) {
            this.c = new gh7(context, lh7.c);
            this.d = new jh7(context, oh7.l);
            this.e = new hh7(context, mh7.g);
            this.f = new ih7(context, nh7.g);
            this.g = new kh7(context, ph7.e);
            this.b.add(this.c);
            this.b.add(this.d);
            this.b.add(this.e);
            this.b.add(this.f);
            this.b.add(this.g);
            this.a = bdTypeRecyclerView;
            bdTypeRecyclerView.a(this.b);
        }
    }

    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            gh7 gh7Var = this.c;
            if (gh7Var != null) {
                gh7Var.notifyDataSetChanged();
            }
            jh7 jh7Var = this.d;
            if (jh7Var != null) {
                jh7Var.notifyDataSetChanged();
            }
            hh7 hh7Var = this.e;
            if (hh7Var != null) {
                hh7Var.notifyDataSetChanged();
            }
            ih7 ih7Var = this.f;
            if (ih7Var != null) {
                ih7Var.notifyDataSetChanged();
            }
            kh7 kh7Var = this.g;
            if (kh7Var != null) {
                kh7Var.notifyDataSetChanged();
            }
        }
    }

    public void c(DataRes dataRes, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, dataRes, str) == null) || this.a == null) {
            return;
        }
        List<on> a = qh7.a(dataRes, str);
        if (ListUtils.isEmpty(a)) {
            return;
        }
        this.a.setData(a);
    }
}

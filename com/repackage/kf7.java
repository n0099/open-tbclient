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
public class kf7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdTypeRecyclerView a;
    public final List<an> b;
    public mf7 c;
    public pf7 d;
    public nf7 e;
    public of7 f;
    public qf7 g;

    public kf7(Context context, BdTypeRecyclerView bdTypeRecyclerView) {
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
            this.c = new mf7(context, rf7.c);
            this.d = new pf7(context, uf7.l);
            this.e = new nf7(context, sf7.g);
            this.f = new of7(context, tf7.g);
            this.g = new qf7(context, vf7.e);
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
            mf7 mf7Var = this.c;
            if (mf7Var != null) {
                mf7Var.G();
            }
            pf7 pf7Var = this.d;
            if (pf7Var != null) {
                pf7Var.G();
            }
            nf7 nf7Var = this.e;
            if (nf7Var != null) {
                nf7Var.G();
            }
            of7 of7Var = this.f;
            if (of7Var != null) {
                of7Var.G();
            }
            qf7 qf7Var = this.g;
            if (qf7Var != null) {
                qf7Var.G();
            }
        }
    }

    public void c(DataRes dataRes, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, dataRes, str) == null) || this.a == null) {
            return;
        }
        List<nn> a = wf7.a(dataRes, str);
        if (ListUtils.isEmpty(a)) {
            return;
        }
        this.a.setData(a);
    }
}

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
public class hd7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdTypeRecyclerView a;
    public final List<wm> b;
    public jd7 c;
    public md7 d;
    public kd7 e;
    public ld7 f;
    public nd7 g;

    public hd7(Context context, BdTypeRecyclerView bdTypeRecyclerView) {
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
            this.c = new jd7(context, od7.c);
            this.d = new md7(context, rd7.l);
            this.e = new kd7(context, pd7.g);
            this.f = new ld7(context, qd7.g);
            this.g = new nd7(context, sd7.e);
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
            jd7 jd7Var = this.c;
            if (jd7Var != null) {
                jd7Var.H();
            }
            md7 md7Var = this.d;
            if (md7Var != null) {
                md7Var.H();
            }
            kd7 kd7Var = this.e;
            if (kd7Var != null) {
                kd7Var.H();
            }
            ld7 ld7Var = this.f;
            if (ld7Var != null) {
                ld7Var.H();
            }
            nd7 nd7Var = this.g;
            if (nd7Var != null) {
                nd7Var.H();
            }
        }
    }

    public void c(DataRes dataRes, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, dataRes, str) == null) || this.a == null) {
            return;
        }
        List<jn> a = td7.a(dataRes, str);
        if (ListUtils.isEmpty(a)) {
            return;
        }
        this.a.setData(a);
    }
}

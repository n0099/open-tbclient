package com.repackage;

import android.content.Context;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class zm5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public Context b;
    public BdTypeRecyclerView c;
    public List<wm> d;
    public fn5 e;
    public fn5 f;
    public en5 g;
    public dn5 h;
    public cn5 i;
    public int j;

    public zm5(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdTypeRecyclerView, Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = tbPageContext;
        this.b = tbPageContext.getPageActivity();
        this.c = bdTypeRecyclerView;
        this.j = i;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.d = new ArrayList();
            this.e = new fn5(this.a, this.j, false);
            this.f = new fn5(this.a, this.j, true);
            this.g = new en5(this.a);
            this.h = new dn5(this.a);
            this.i = new cn5(this.a);
            this.d.add(this.e);
            this.d.add(this.f);
            this.d.add(this.g);
            this.d.add(this.h);
            this.d.add(this.i);
            this.c.a(this.d);
        }
    }

    public void b() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (bdTypeRecyclerView = this.c) == null) {
            return;
        }
        bdTypeRecyclerView.getListAdapter().notifyDataSetChanged();
    }

    public void c(List<jn> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
            this.c.setData(list);
        }
    }
}

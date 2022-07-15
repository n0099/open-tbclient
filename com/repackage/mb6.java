package com.repackage;

import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class mb6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<an> a;
    public BdTypeListView b;
    public ib6 c;
    public kb6 d;

    public mb6(BaseActivity<?> baseActivity, BdTypeListView bdTypeListView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseActivity, bdTypeListView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        ArrayList arrayList = new ArrayList();
        this.a = arrayList;
        this.b = bdTypeListView;
        arrayList.add(new eb6(baseActivity.getPageContext(), fb6.d));
        this.a.add(new gb6(baseActivity.getPageContext(), hb6.c));
        this.a.add(new db6(baseActivity.getPageContext(), fd6.c));
        this.a.add(new ua6(baseActivity.getPageContext(), va6.b));
        this.a.add(new wa6(baseActivity.getPageContext(), xa6.g));
        this.a.add(new ya6(baseActivity.getPageContext()));
        ib6 ib6Var = new ib6(baseActivity.getPageContext(), jb6.e);
        this.c = ib6Var;
        this.a.add(ib6Var);
        kb6 kb6Var = new kb6(baseActivity.getPageContext(), lb6.d);
        this.d = kb6Var;
        this.a.add(kb6Var);
    }

    public List<an> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : (List) invokeV.objValue;
    }

    public void b() {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (bdTypeListView = this.b) != null && (bdTypeListView.getAdapter2() instanceof en)) {
            this.b.getAdapter2().notifyDataSetChanged();
        }
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.c.onDestroy();
            this.d.onDestroy();
        }
    }
}

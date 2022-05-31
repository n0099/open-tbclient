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
public class p96 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<wm> a;
    public BdTypeListView b;
    public l96 c;
    public n96 d;

    public p96(BaseActivity<?> baseActivity, BdTypeListView bdTypeListView) {
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
        arrayList.add(new h96(baseActivity.getPageContext(), i96.d));
        this.a.add(new j96(baseActivity.getPageContext(), k96.c));
        this.a.add(new g96(baseActivity.getPageContext(), ib6.c));
        this.a.add(new x86(baseActivity.getPageContext(), y86.b));
        this.a.add(new z86(baseActivity.getPageContext(), a96.g));
        this.a.add(new b96(baseActivity.getPageContext()));
        l96 l96Var = new l96(baseActivity.getPageContext(), m96.e);
        this.c = l96Var;
        this.a.add(l96Var);
        n96 n96Var = new n96(baseActivity.getPageContext(), o96.d);
        this.d = n96Var;
        this.a.add(n96Var);
    }

    public List<wm> a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a : (List) invokeV.objValue;
    }

    public void b() {
        BdTypeListView bdTypeListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (bdTypeListView = this.b) != null && (bdTypeListView.getAdapter2() instanceof an)) {
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

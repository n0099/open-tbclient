package com.repackage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.TabMenuPopView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.mo6;
import java.util.List;
/* loaded from: classes6.dex */
public class oo6 implements io6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public mo6.e b;
    public List<xe6> c;
    public View d;
    public View e;
    public TabMenuPopView f;
    public mo6 g;
    public TabMenuPopView.c h;

    /* loaded from: classes6.dex */
    public class a implements TabMenuPopView.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ oo6 a;

        public a(oo6 oo6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {oo6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = oo6Var;
        }

        @Override // com.baidu.tieba.frs.TabMenuPopView.c
        public void a(View view2, xe6 xe6Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, view2, xe6Var) == null) {
                if (this.a.g != null) {
                    this.a.g.c();
                }
                this.a.b.a(xe6Var.b);
            }
        }
    }

    public oo6() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.h = new a(this);
    }

    @Override // com.repackage.io6
    public void a(Context context, mo6 mo6Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, context, mo6Var) == null) || context == null || mo6Var == null) {
            return;
        }
        this.a = context;
        this.g = mo6Var;
        this.b = mo6Var.d();
        View inflate = LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d07f9, (ViewGroup) null);
        this.d = inflate;
        this.e = inflate.findViewById(R.id.obfuscated_res_0x7f092148);
        TabMenuPopView tabMenuPopView = (TabMenuPopView) this.d.findViewById(R.id.obfuscated_res_0x7f090587);
        this.f = tabMenuPopView;
        tabMenuPopView.setOnItemClickCallBack(this.h);
    }

    @Override // com.repackage.io6
    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            this.d.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            return this.d.getMeasuredHeight();
        }
        return invokeV.intValue;
    }

    @Override // com.repackage.io6
    public View getView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.d : (View) invokeV.objValue;
    }

    @Override // com.repackage.io6
    public void setData(List<xe6> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, list) == null) || list == null) {
            return;
        }
        this.c = list;
        xe6 xe6Var = new xe6();
        xe6Var.b = 0;
        xe6Var.a = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0265);
        xe6Var.c = false;
        SkinManager.setBackgroundColor(this.d, R.color.CAM_X0201);
        SkinManager.setBackgroundColor(this.e, R.color.CAM_X0204);
        this.f.setData(this.c, xe6Var);
    }
}

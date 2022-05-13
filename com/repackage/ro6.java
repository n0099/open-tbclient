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
import com.repackage.po6;
import java.util.List;
/* loaded from: classes7.dex */
public class ro6 implements lo6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public po6.e b;
    public List<je6> c;
    public View d;
    public View e;
    public TabMenuPopView f;
    public po6 g;
    public TabMenuPopView.c h;

    /* loaded from: classes7.dex */
    public class a implements TabMenuPopView.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ro6 a;

        public a(ro6 ro6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ro6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ro6Var;
        }

        @Override // com.baidu.tieba.frs.TabMenuPopView.c
        public void a(View view2, je6 je6Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, view2, je6Var) == null) {
                if (this.a.g != null) {
                    this.a.g.c();
                }
                this.a.b.a(je6Var.b);
            }
        }
    }

    public ro6() {
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

    @Override // com.repackage.lo6
    public void a(Context context, po6 po6Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, context, po6Var) == null) || context == null || po6Var == null) {
            return;
        }
        this.a = context;
        this.g = po6Var;
        this.b = po6Var.d();
        View inflate = LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d07e9, (ViewGroup) null);
        this.d = inflate;
        this.e = inflate.findViewById(R.id.obfuscated_res_0x7f092101);
        TabMenuPopView tabMenuPopView = (TabMenuPopView) this.d.findViewById(R.id.obfuscated_res_0x7f0905ac);
        this.f = tabMenuPopView;
        tabMenuPopView.setOnItemClickCallBack(this.h);
    }

    @Override // com.repackage.lo6
    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            this.d.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            return this.d.getMeasuredHeight();
        }
        return invokeV.intValue;
    }

    @Override // com.repackage.lo6
    public View getView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.d : (View) invokeV.objValue;
    }

    @Override // com.repackage.lo6
    public void setData(List<je6> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, list) == null) || list == null) {
            return;
        }
        this.c = list;
        je6 je6Var = new je6();
        je6Var.b = 0;
        je6Var.a = this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0262);
        je6Var.c = false;
        SkinManager.setBackgroundColor(this.d, R.color.CAM_X0201);
        SkinManager.setBackgroundColor(this.e, R.color.CAM_X0204);
        this.f.setData(this.c, je6Var);
    }
}

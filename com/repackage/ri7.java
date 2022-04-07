package com.repackage;

import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.memberCenter.bubble.BubbleChooseActivity;
import com.baidu.tieba.memberCenter.bubble.BubbleListData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes7.dex */
public class ri7 extends z8<BubbleChooseActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public NavigationBar a;
    public ViewGroup b;
    public GridView c;
    public View d;
    public qi7 e;
    public BubbleChooseActivity f;
    public ProgressBar g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ri7(TbPageContext<BubbleChooseActivity> tbPageContext) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((b9) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        BubbleChooseActivity orignalPage = tbPageContext.getOrignalPage();
        this.f = orignalPage;
        orignalPage.setContentView(R.layout.obfuscated_res_0x7f0d0167);
        NavigationBar navigationBar = (NavigationBar) this.f.findViewById(R.id.obfuscated_res_0x7f0911af);
        this.a = navigationBar;
        navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.a.setTitleText(R.string.obfuscated_res_0x7f0f0528);
        this.d = this.a.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.obfuscated_res_0x7f0d0168, this.f);
        this.b = (ViewGroup) this.f.findViewById(R.id.obfuscated_res_0x7f0906d2);
        this.c = (GridView) this.f.findViewById(R.id.obfuscated_res_0x7f090d10);
        qi7 qi7Var = new qi7(tbPageContext);
        this.e = qi7Var;
        this.c.setAdapter((ListAdapter) qi7Var);
        this.g = (ProgressBar) this.f.findViewById(R.id.obfuscated_res_0x7f09045d);
    }

    public qi7 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.e : (qi7) invokeV.objValue;
    }

    public View f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.d : (View) invokeV.objValue;
    }

    public GridView g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.c : (GridView) invokeV.objValue;
    }

    public BubbleListData.BubbleData h(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            qi7 qi7Var = this.e;
            if (qi7Var == null) {
                return null;
            }
            return qi7Var.getItem(i);
        }
        return (BubbleListData.BubbleData) invokeI.objValue;
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.g.setVisibility(8);
        }
    }

    public void j(List<BubbleListData.BubbleData> list, boolean z) {
        qi7 qi7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048581, this, list, z) == null) || (qi7Var = this.e) == null) {
            return;
        }
        qi7Var.d(z);
        this.e.c(list);
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.g.setVisibility(0);
        }
    }

    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.a.onChangeSkinType((TbPageContext) getPageContext(), i);
            this.f.getLayoutMode().k(i == 1);
            this.f.getLayoutMode().j(this.b);
        }
    }
}

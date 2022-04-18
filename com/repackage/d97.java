package com.repackage;

import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.im.data.ValidateItemData;
import com.baidu.tieba.im.validate.ValidateActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes5.dex */
public class d97 extends z8<ValidateActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;
    public ImageView b;
    public ValidateActivity c;
    public BdListView d;
    public b97 e;
    public ProgressBar f;
    public NavigationBar g;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d97 a;

        public a(d97 d97Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d97Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = d97Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.c.finish();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d97(ValidateActivity validateActivity) {
        super(validateActivity.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {validateActivity};
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
        this.c = validateActivity;
        h();
        b97 b97Var = new b97(this.c);
        this.e = b97Var;
        this.d.setAdapter((ListAdapter) b97Var);
        this.d.setOnSrollToBottomListener(this.c);
    }

    @Override // com.repackage.z8
    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.destroy();
            b97 b97Var = this.e;
            if (b97Var != null) {
                b97Var.a();
                this.e = null;
            }
            this.c = null;
        }
    }

    public ImageView f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.b : (ImageView) invokeV.objValue;
    }

    public b97 g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.e : (b97) invokeV.objValue;
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            View inflate = View.inflate(this.c.getPageContext().getPageActivity(), R.layout.obfuscated_res_0x7f0d0861, null);
            this.a = inflate;
            this.c.setContentView(inflate);
            NavigationBar navigationBar = (NavigationBar) this.c.findViewById(R.id.obfuscated_res_0x7f0923ac);
            this.g = navigationBar;
            navigationBar.setTitleText(this.c.getPageContext().getString(R.string.obfuscated_res_0x7f0f14b7));
            this.g.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new a(this));
            this.d = (BdListView) this.a.findViewById(R.id.obfuscated_res_0x7f0922cd);
            this.f = (ProgressBar) this.a.findViewById(R.id.obfuscated_res_0x7f091908);
            j(false);
        }
    }

    public void i(List<ValidateItemData> list) {
        b97 b97Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, list) == null) || (b97Var = this.e) == null) {
            return;
        }
        b97Var.c(list);
    }

    public void j(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.f.setVisibility(z ? 0 : 8);
        }
    }

    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            this.c.getLayoutMode().k(i == 1);
            this.c.getLayoutMode().j(this.a);
            this.g.onChangeSkinType(this.c.getPageContext(), i);
            if (i != 1 && i != 4) {
                this.d.setDivider(new ColorDrawable(this.c.getResources().getColor(R.color.common_color_10241)));
                this.d.setDividerHeight(this.c.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701d4));
                return;
            }
            this.d.setDivider(new ColorDrawable(this.c.getResources().getColor(R.color.common_color_10179)));
            this.d.setDividerHeight(this.c.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701d4));
        }
    }
}

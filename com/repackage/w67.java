package com.repackage;

import android.view.View;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.im.data.UpdatesItemData;
import com.baidu.tieba.im.groupUpdates.UpdatesActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes7.dex */
public class w67 extends z8<UpdatesActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;
    public View b;
    public UpdatesActivity c;
    public BdListView d;
    public u67 e;
    public ProgressBar f;
    public Button g;
    public Button h;
    public Button i;
    public NavigationBar j;
    public View k;
    public View l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public w67(UpdatesActivity updatesActivity) {
        super(updatesActivity.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {updatesActivity};
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
        this.c = updatesActivity;
        m();
        u67 u67Var = new u67(this.c);
        this.e = u67Var;
        this.d.setAdapter((ListAdapter) u67Var);
        this.d.setOnScrollListener(this.c);
    }

    @Override // com.repackage.z8
    public void destroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.destroy();
            u67 u67Var = this.e;
            if (u67Var != null) {
                u67Var.a();
                this.e = null;
            }
            this.c = null;
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.g.setVisibility(0);
            this.b.setVisibility(0);
            this.h.setVisibility(8);
            this.k.setVisibility(8);
            p(0);
            n();
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.g.setVisibility(8);
            this.b.setVisibility(8);
            this.h.setVisibility(0);
            this.k.setVisibility(0);
            n();
        }
    }

    public View g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.b : (View) invokeV.objValue;
    }

    public Button h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.h : (Button) invokeV.objValue;
    }

    public Button i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.i : (Button) invokeV.objValue;
    }

    public Button j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.g : (Button) invokeV.objValue;
    }

    public u67 k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.e : (u67) invokeV.objValue;
    }

    public BdListView l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.d : (BdListView) invokeV.objValue;
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            View inflate = View.inflate(this.c.getPageContext().getPageActivity(), R.layout.obfuscated_res_0x7f0d0855, null);
            this.a = inflate;
            this.c.setContentView(inflate);
            NavigationBar navigationBar = (NavigationBar) this.c.findViewById(R.id.obfuscated_res_0x7f0923ab);
            this.j = navigationBar;
            this.b = navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.j.setTitleText(this.c.getPageContext().getString(R.string.obfuscated_res_0x7f0f1495));
            this.k = this.j.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.obfuscated_res_0x7f0d0856, (View.OnClickListener) null);
            this.l = this.j.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.obfuscated_res_0x7f0d0857, (View.OnClickListener) null);
            Button button = (Button) this.k.findViewById(R.id.obfuscated_res_0x7f09041a);
            this.i = button;
            button.setOnClickListener(this.c);
            this.b.setOnClickListener(this.c);
            this.d = (BdListView) this.a.findViewById(R.id.obfuscated_res_0x7f09226b);
            this.f = (ProgressBar) this.a.findViewById(R.id.obfuscated_res_0x7f091907);
            Button button2 = (Button) this.l.findViewById(R.id.obfuscated_res_0x7f09041b);
            this.g = button2;
            button2.setOnClickListener(this.c);
            Button button3 = (Button) this.l.findViewById(R.id.obfuscated_res_0x7f090412);
            this.h = button3;
            button3.setOnClickListener(this.c);
            p(0);
            r(false);
        }
    }

    public void n() {
        u67 u67Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (u67Var = this.e) == null) {
            return;
        }
        u67Var.notifyDataSetChanged();
    }

    public void o(List<UpdatesItemData> list) {
        u67 u67Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, list) == null) || (u67Var = this.e) == null) {
            return;
        }
        u67Var.c(list);
    }

    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            this.c.getLayoutMode().k(i == 1);
            this.c.getLayoutMode().j(this.a);
            this.j.onChangeSkinType(this.c.getPageContext(), i);
            SkinManager.setBackgroundResource(this.i, R.drawable.btn_delete_groupupdates);
        }
    }

    public void p(int i) {
        Button button;
        UpdatesActivity updatesActivity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048589, this, i) == null) || (button = this.i) == null || (updatesActivity = this.c) == null) {
            return;
        }
        button.setText(String.format(updatesActivity.getPageContext().getString(R.string.obfuscated_res_0x7f0f048b), Integer.valueOf(i)));
        if (i == 0) {
            this.i.setEnabled(false);
        } else {
            this.i.setEnabled(true);
        }
    }

    public void r(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048590, this, z) == null) {
            this.f.setVisibility(z ? 0 : 8);
        }
    }
}

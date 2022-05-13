package com.repackage;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.im.searchGroup.AddGroupActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class k77 extends z8<AddGroupActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View a;
    public NavigationBar b;
    public View c;
    public EditText d;
    public ImageButton e;
    public ProgressBar f;
    public View g;
    public View h;
    public AddGroupActivity i;

    /* loaded from: classes6.dex */
    public class a implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ k77 a;

        public a(k77 k77Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {k77Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = k77Var;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, editable) == null) {
                this.a.g.setTag(editable.toString().trim());
            }
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i, i2, i3) == null) {
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i, i2, i3) == null) {
                if (this.a.d.length() > 0) {
                    this.a.e.setVisibility(0);
                } else {
                    this.a.e.setVisibility(8);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k77(AddGroupActivity addGroupActivity) {
        super(addGroupActivity.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {addGroupActivity};
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
        this.a = null;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.g = null;
        this.i = null;
        this.i = addGroupActivity;
        o();
    }

    public void i(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            this.i.getLayoutMode().k(i == 1);
            this.i.getLayoutMode().j(this.a);
            this.b.onChangeSkinType(this.i.getPageContext(), i);
        }
    }

    public void j() {
        EditText editText;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (editText = this.d) == null) {
            return;
        }
        editText.setText("");
    }

    public View k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.c : (View) invokeV.objValue;
    }

    public View l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.e : (View) invokeV.objValue;
    }

    public View m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.g : (View) invokeV.objValue;
    }

    public View n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.h : (View) invokeV.objValue;
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.i.setContentView(R.layout.obfuscated_res_0x7f0d03bb);
            this.a = this.i.findViewById(R.id.obfuscated_res_0x7f090120);
            NavigationBar navigationBar = (NavigationBar) this.i.findViewById(R.id.obfuscated_res_0x7f09011e);
            this.b = navigationBar;
            this.c = navigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.b.setTitleText(this.i.getResources().getString(R.string.obfuscated_res_0x7f0f00c8));
            EditText editText = (EditText) this.i.findViewById(R.id.obfuscated_res_0x7f09011d);
            this.d = editText;
            editText.setInputType(2);
            this.e = (ImageButton) this.i.findViewById(R.id.obfuscated_res_0x7f09011c);
            this.g = this.i.findViewById(R.id.obfuscated_res_0x7f090121);
            this.h = this.i.findViewById(R.id.obfuscated_res_0x7f090122);
            this.d.addTextChangedListener(new a(this));
            this.g = this.i.findViewById(R.id.obfuscated_res_0x7f090121);
            this.f = (ProgressBar) this.i.findViewById(R.id.obfuscated_res_0x7f09011f);
            this.c.setOnClickListener(this.i);
            this.e.setOnClickListener(this.i);
            this.g.setOnClickListener(this.i);
            this.h.setOnClickListener(this.i);
            if (TbadkCoreApplication.getInst().appResponseToCmd(2902030)) {
                return;
            }
            this.h.setVisibility(8);
        }
    }

    public void q(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.f.setVisibility(z ? 0 : 8);
        }
    }
}

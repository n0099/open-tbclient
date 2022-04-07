package com.repackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class f75 extends io implements sj8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContextSupport b;
    public TextView c;
    public ProgressBar d;
    public View.OnClickListener e;
    public View f;
    public View g;
    public int h;
    public ViewGroup i;
    public int j;

    public f75(TbPageContextSupport tbPageContextSupport) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContextSupport};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = null;
        this.f = null;
        this.b = tbPageContextSupport;
        this.h = tbPageContextSupport.getPageContext().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701be);
    }

    @Override // com.repackage.io
    public View a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.i == null) {
                this.f = LayoutInflater.from(this.b.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0600, (ViewGroup) null);
            } else {
                this.f = LayoutInflater.from(this.b.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0600, this.i, false);
            }
            View view2 = this.f;
            int i = this.h;
            view2.setPadding(0, i, 0, i);
            if (this.j != 0) {
                ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(this.f.getLayoutParams());
                layoutParams.height = this.j;
                this.f.setLayoutParams(layoutParams);
            }
            this.c = (TextView) this.f.findViewById(R.id.obfuscated_res_0x7f0916ea);
            View findViewById = this.f.findViewById(R.id.obfuscated_res_0x7f0916ed);
            this.g = findViewById;
            findViewById.setVisibility(8);
            this.d = (ProgressBar) this.f.findViewById(R.id.obfuscated_res_0x7f09191c);
            onChangeSkinType(this.b.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
            this.g.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            return this.f;
        }
        return (View) invokeV.objValue;
    }

    @Override // com.repackage.io
    public void c() {
        View.OnClickListener onClickListener;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (onClickListener = this.e) == null) {
            return;
        }
        onClickListener.onClick(this.f);
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.g.setVisibility(0);
            View view2 = this.f;
            int i = this.h;
            view2.setPadding(0, i, 0, i);
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.g.setVisibility(8);
            this.f.setPadding(0, 0, 0, 0);
        }
    }

    public void f(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            this.d.setVisibility(0);
            this.c.setText(i);
            this.g.setVisibility(0);
        }
    }

    public void g(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            this.d.setVisibility(8);
            this.c.setText(i);
        }
    }

    public void h(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            this.j = i;
        }
    }

    @Override // com.repackage.sj8
    public boolean onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048583, this, tbPageContext, i)) == null) {
            this.b.getPageContext().getLayoutMode().j(this.g);
            return true;
        }
        return invokeLI.booleanValue;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public f75(TbPageContextSupport tbPageContextSupport, ViewGroup viewGroup) {
        this(tbPageContextSupport);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContextSupport, viewGroup};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                this((TbPageContextSupport) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.i = viewGroup;
    }
}

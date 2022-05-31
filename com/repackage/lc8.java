package com.repackage;

import android.annotation.SuppressLint;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.MemberPrivilegeActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tieba.R;
import com.baidu.tieba.signall.SignAllForumActivity;
import com.baidu.tieba.signall.SignAllForumProgressView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ft4;
import java.util.ArrayList;
@SuppressLint({"ResourceAsColor"})
/* loaded from: classes6.dex */
public class lc8 extends z8<SignAllForumActivity> {
    public static /* synthetic */ Interceptable $ic;
    public static int o;
    public transient /* synthetic */ FieldHolder $fh;
    public SignAllForumActivity a;
    public NavigationBar b;
    public RelativeLayout c;
    public SignAllForumProgressView d;
    public ProgressBar e;
    public BdListView f;
    public gt4 g;
    public ic8 h;
    public ec8 i;
    public RelativeLayout j;
    public TextView k;
    public TextView l;
    public LinearLayout m;
    public TextView n;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ lc8 a;

        public a(lc8 lc8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {lc8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = lc8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.a.finish();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public lc8(SignAllForumActivity signAllForumActivity) {
        super(signAllForumActivity.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {signAllForumActivity};
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
        this.g = null;
        this.a = signAllForumActivity;
        signAllForumActivity.setContentView(R.layout.obfuscated_res_0x7f0d0762);
        this.c = (RelativeLayout) this.a.findViewById(R.id.obfuscated_res_0x7f091cee);
        NavigationBar navigationBar = (NavigationBar) this.a.findViewById(R.id.obfuscated_res_0x7f0923a2);
        this.b = navigationBar;
        navigationBar.setCenterTextTitle(this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f119c));
        this.b.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new a(this));
        this.b.showBottomLine();
        BdListView bdListView = (BdListView) this.a.findViewById(R.id.obfuscated_res_0x7f091d0e);
        this.f = bdListView;
        bdListView.setOnItemClickListener(signAllForumActivity);
        gt4 gt4Var = new gt4(signAllForumActivity.getPageContext());
        this.g = gt4Var;
        this.f.setPullRefresh(gt4Var);
        TextView textView = (TextView) LayoutInflater.from(this.a.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0760, (ViewGroup) null);
        this.n = textView;
        this.f.addFooterView(textView);
        SignAllForumProgressView signAllForumProgressView = new SignAllForumProgressView(this.a.getPageContext().getPageActivity());
        this.d = signAllForumProgressView;
        ProgressBar progressBar = signAllForumProgressView.getProgressBar();
        this.e = progressBar;
        progressBar.setOnClickListener(this.a);
        this.f.addHeaderView(this.d);
        this.d.setVisibility(8);
        this.j = (RelativeLayout) this.d.findViewById(R.id.obfuscated_res_0x7f090cbd);
        this.m = (LinearLayout) this.d.findViewById(R.id.obfuscated_res_0x7f090cbf);
        this.k = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f090cc0);
        this.l = (TextView) this.d.findViewById(R.id.obfuscated_res_0x7f090cbe);
        this.m.setOnClickListener(this.a);
        ic8 ic8Var = new ic8(this.a, null);
        this.h = ic8Var;
        this.f.setAdapter((ListAdapter) ic8Var);
        this.f.setOnScrollListener(this.h);
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f.A(0L);
        }
    }

    public final void g() {
        ec8 ec8Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (ec8Var = this.i) == null) {
            return;
        }
        this.d.setHasPrivilege(ec8Var.B());
        this.d.setmCurrentStatus(this.i.q());
        TextView message1 = this.d.getMessage1();
        SpannableString spannableString = new SpannableString(this.i.v() + this.i.t() + this.i.u());
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(TbadkApplication.getInst().getResources().getColor(R.color.common_color_10191));
        int length = this.i.v().length();
        spannableString.setSpan(foregroundColorSpan, length, this.i.t().length() + length, 33);
        message1.setText(spannableString);
        this.d.getMessage2().setText(this.i.w());
        this.k.setText(this.i.h());
        if (TextUtils.isEmpty(this.i.g())) {
            this.l.setText(R.string.obfuscated_res_0x7f0f0aae);
        } else {
            this.l.setText(this.i.g());
        }
        this.d.setVisibility(0);
        if (!this.i.B() && TbadkApplication.getInst().getIntentClass(MemberPrivilegeActivityConfig.class) != null) {
            this.j.setVisibility(0);
        } else {
            this.j.setVisibility(8);
        }
    }

    public ic8 h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.h : (ic8) invokeV.objValue;
    }

    public ec8 i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.i : (ec8) invokeV.objValue;
    }

    public LinearLayout j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.m : (LinearLayout) invokeV.objValue;
    }

    public BdListView k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f : (BdListView) invokeV.objValue;
    }

    public ProgressBar l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.e : (ProgressBar) invokeV.objValue;
    }

    public SignAllForumProgressView m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.d : (SignAllForumProgressView) invokeV.objValue;
    }

    public RelativeLayout n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.c : (RelativeLayout) invokeV.objValue;
    }

    public void o(ec8 ec8Var, boolean z) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLZ(1048585, this, ec8Var, z) == null) || ec8Var == null) {
            return;
        }
        this.i = ec8Var;
        g();
        ArrayList<fc8> k = ec8Var.k();
        this.h.h(this.i);
        if (k.size() == o) {
            this.n.setVisibility(0);
            this.n.setText(ec8Var.m());
        } else {
            this.n.setVisibility(8);
        }
        String y = this.i.y();
        if (!StringUtils.isNull(y)) {
            this.d.l(this.a, y, this.i.z());
            return;
        }
        this.d.i();
    }

    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            this.a.getLayoutMode().k(i == 1);
            this.a.getLayoutMode().j(this.c);
            this.a.getLayoutMode().j(this.n);
            this.a.getLayoutMode().j(this.d);
            SkinManager.setBackgroundColor(this.c, R.color.CAM_X0201);
            this.b.onChangeSkinType(getPageContext(), i);
            SignAllForumProgressView signAllForumProgressView = this.d;
            if (signAllForumProgressView != null) {
                signAllForumProgressView.k();
            }
            this.g.H(i);
            this.h.notifyDataSetChanged();
        }
    }

    public void q(ft4.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, gVar) == null) {
            this.g.e(gVar);
        }
    }

    public void r(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048588, this, i) == null) {
            this.f.setSelection(i);
        }
    }

    public void s(AdapterView.OnItemClickListener onItemClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, onItemClickListener) == null) {
            this.f.setOnItemClickListener(onItemClickListener);
        }
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            this.f.F();
        }
    }
}

package com.repackage;

import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.GiftTabActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tieba.R;
import com.baidu.tieba.gift.myGiftList.MyGiftListActivity;
import com.baidu.tieba.wallet.CurrencyHelper;
import com.baidu.tieba.wallet.CurrencyJumpHelper;
import com.baidu.tieba.wallet.CurrencySwitchUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.cu4;
import com.repackage.dt6;
/* loaded from: classes6.dex */
public class ft6 extends z8<MyGiftListActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public MyGiftListActivity a;
    public NavigationBar b;
    public NoNetworkView c;
    public h45 d;
    public BdListView e;
    public View f;
    public View g;
    public View h;
    public View i;
    public View j;
    public du4 k;
    public BdListView.p l;
    public TextView m;
    public TextView n;
    public TextView o;
    public TextView p;
    public TextView q;
    public LinearLayout r;
    public et6 s;
    public boolean t;
    public LinearLayout u;
    public View v;
    public TextView w;
    public ImageView x;
    public AdapterView.OnItemClickListener y;
    public View.OnClickListener z;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ft6 a;

        public a(ft6 ft6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ft6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ft6Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.m();
                this.a.v();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ft6 a;

        public b(ft6 ft6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ft6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ft6Var;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
            dt6.a item;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) == null) || (item = this.a.s.getItem(i)) == null || item.a <= 0 || StringUtils.isNull(item.b)) {
                return;
            }
            if (this.a.t) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GiftTabActivityConfig(this.a.a.getPageContext().getPageActivity(), item.a, item.b, item.i, GiftTabActivityConfig.FROM_PERSON_CENTER)));
            } else if (!mi.z()) {
                this.a.a.showToast(R.string.obfuscated_res_0x7f0f0c17);
            } else {
                this.a.a.sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(TbadkApplication.getInst().getContext(), String.valueOf(item.a), item.b)));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ft6 a;

        public c(ft6 ft6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ft6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ft6Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && view2 != null && view2 == this.a.o) {
                if (oi.C()) {
                    CurrencyJumpHelper.buyGiftGotoBuyTBeanPage(this.a.a.getPageContext().getPageActivity());
                } else {
                    UtilHelper.showToast(this.a.a.getPageContext().getPageActivity(), this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f0c17));
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ft6(MyGiftListActivity myGiftListActivity, BdListView.p pVar, boolean z) {
        super(myGiftListActivity.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {myGiftListActivity, pVar, Boolean.valueOf(z)};
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
        this.k = null;
        this.y = new b(this);
        this.z = new c(this);
        this.a = myGiftListActivity;
        this.t = z;
        this.l = pVar;
        o();
        n();
        if (!this.t && TbadkApplication.getInst().isGiftSwitchOn()) {
            this.u.setVisibility(0);
        } else {
            this.u.setVisibility(8);
        }
    }

    public void i(NoNetworkView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            this.c.a(bVar);
        }
    }

    public final SpannableString j(int i, String str, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2)})) == null) {
            String str2 = "[icon]" + str;
            SpannableString spannableString = new SpannableString(str2);
            Drawable drawable = SkinManager.getDrawable(i);
            int f = oi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.obfuscated_res_0x7f070201);
            if (i2 == 2) {
                drawable.setBounds(0, 3, f, oi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.obfuscated_res_0x7f0701f0));
            } else {
                drawable.setBounds(0, 0, f, f);
            }
            if (TbadkApplication.getInst().getSkinType() == 1) {
                drawable.setAlpha(179);
            } else {
                drawable.setAlpha(255);
            }
            ud5 ud5Var = new ud5(drawable);
            ud5Var.c(oi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.obfuscated_res_0x7f070234));
            UtilHelper.setSpan(spannableString, str2, "[icon]", ud5Var);
            AbsoluteSizeSpan absoluteSizeSpan = new AbsoluteSizeSpan(oi.f(this.a.getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f07032f));
            UtilHelper.setSpan(spannableString, str2, this.a.getResources().getString(R.string.obfuscated_res_0x7f0f1474), absoluteSizeSpan);
            UtilHelper.setSpan(spannableString, str2, this.a.getResources().getString(R.string.obfuscated_res_0x7f0f1475), absoluteSizeSpan);
            return spannableString;
        }
        return (SpannableString) invokeCommon.objValue;
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.e.A(0L);
        }
    }

    public View l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.j : (View) invokeV.objValue;
    }

    public void m() {
        h45 h45Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (h45Var = this.d) == null) {
            return;
        }
        h45Var.dettachView(this.f);
        this.d = null;
        this.e.setVisibility(0);
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.u = (LinearLayout) this.a.findViewById(R.id.obfuscated_res_0x7f090cbf);
            this.w = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f090cc0);
            this.u.setOnClickListener(this.a.getSendGiftClickListener());
            this.v = this.a.findViewById(R.id.obfuscated_res_0x7f090cc2);
            this.x = (ImageView) this.a.findViewById(R.id.obfuscated_res_0x7f090cc1);
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.a.setContentView(R.layout.obfuscated_res_0x7f0d0590);
            View findViewById = this.a.findViewById(R.id.obfuscated_res_0x7f091ac8);
            this.f = findViewById;
            this.e = (BdListView) findViewById.findViewById(R.id.obfuscated_res_0x7f091275);
            NavigationBar navigationBar = (NavigationBar) this.f.findViewById(R.id.obfuscated_res_0x7f091515);
            this.b = navigationBar;
            MyGiftListActivity myGiftListActivity = this.a;
            if (myGiftListActivity.userType == 1) {
                navigationBar.setCenterTextTitle(myGiftListActivity.getPageContext().getString(R.string.obfuscated_res_0x7f0f0666));
            } else {
                String format = String.format(this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f081b), myGiftListActivity.getUserSex());
                if (this.t) {
                    this.b.setCenterTextTitle(this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0b2a));
                } else {
                    this.b.setTitleText(format);
                }
            }
            this.b.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.c = (NoNetworkView) this.f.findViewById(R.id.obfuscated_res_0x7f09159a);
            View inflate = LayoutInflater.from(this.a.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0594, (ViewGroup) null, false);
            this.h = inflate;
            inflate.setVisibility(8);
            View inflate2 = LayoutInflater.from(this.a.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0592, (ViewGroup) null, false);
            this.g = inflate2;
            inflate2.setVisibility(8);
            this.r = (LinearLayout) this.g.findViewById(R.id.obfuscated_res_0x7f0923a7);
            this.m = (TextView) this.g.findViewById(R.id.obfuscated_res_0x7f091f59);
            this.n = (TextView) this.g.findViewById(R.id.obfuscated_res_0x7f091f5f);
            this.p = (TextView) this.g.findViewById(R.id.obfuscated_res_0x7f091f60);
            this.o = (TextView) this.g.findViewById(R.id.obfuscated_res_0x7f0923a2);
            if (CurrencySwitchUtil.isYyIsConvert()) {
                this.p.setText(R.string.obfuscated_res_0x7f0f0b3a);
                this.o.setText(R.string.obfuscated_res_0x7f0f0794);
            } else {
                this.p.setText(R.string.obfuscated_res_0x7f0f0b37);
                this.o.setText(R.string.obfuscated_res_0x7f0f0791);
            }
            this.q = (TextView) this.g.findViewById(R.id.obfuscated_res_0x7f091f58);
            this.o.setOnClickListener(this.z);
            View inflate3 = LayoutInflater.from(this.a.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0591, (ViewGroup) null, false);
            this.i = inflate3;
            this.j = inflate3.findViewById(R.id.obfuscated_res_0x7f090cb1);
            if (this.t) {
                this.e.addHeaderView(this.g);
            } else {
                if (this.a.userType == 1) {
                    this.h.setVisibility(0);
                    this.e.addHeaderView(this.h);
                }
                if (TbadkApplication.getInst().isGiftSwitchOn()) {
                    this.i.setPadding(0, 0, 0, oi.f(this.a.getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f070254));
                }
            }
            this.e.addFooterView(this.i);
            et6 et6Var = new et6(this.a, this.t);
            this.s = et6Var;
            this.e.setAdapter((ListAdapter) et6Var);
            du4 du4Var = new du4(this.a.getPageContext());
            this.k = du4Var;
            this.e.setPullRefresh(du4Var);
            this.e.setOnSrollToBottomListener(this.l);
            this.e.setOnItemClickListener(this.y);
        }
    }

    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.a.getLayoutMode().k(i == 1);
            this.a.getLayoutMode().j(this.f);
            this.a.getLayoutMode().j(this.g);
            this.a.getLayoutMode().j(this.h);
            this.a.getLayoutMode().j(this.i);
            this.b.onChangeSkinType(getPageContext(), i);
            this.c.c(this.a.getPageContext(), i);
            this.k.H(i);
            et6 et6Var = this.s;
            if (et6Var != null) {
                et6Var.notifyDataSetChanged();
            }
            SkinManager.setBackgroundColor(this.v, R.color.CAM_X0204);
            SkinManager.setBackgroundColor(this.u, R.color.CAM_X0201);
            SkinManager.setViewTextColor(this.w, (int) R.color.CAM_X0302);
            SkinManager.setImageResource(this.x, R.drawable.icon_gift_list);
            vr4.d(this.p).v(R.color.CAM_X0101);
            vr4.d(this.q).v(R.color.CAM_X0101);
            vr4.d(this.m).v(R.color.CAM_X0101);
            vr4.d(this.o).v(R.color.CAM_X0101);
            vr4.d(this.n).v(R.color.CAM_X0101);
            vr4 d = vr4.d(this.g);
            d.e(R.string.A_X02);
            d.f(R.color.CAM_X0310);
        }
    }

    public final void p(dt6 dt6Var) {
        String formatOverBaiwanNum;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, dt6Var) == null) {
            if (dt6Var != null && this.t) {
                this.g.setVisibility(0);
                String str = dt6Var.d().b;
                String str2 = dt6Var.d().a;
                String str3 = dt6Var.g.b;
                this.m.setText(j(R.drawable.icon_gift_my_gift, StringHelper.formatOverBaiwanNum(dt6Var.b()), 0));
                if (CurrencySwitchUtil.isYyIsConvert(dt6Var.h)) {
                    formatOverBaiwanNum = CurrencyHelper.getFormatOverBaiwanNum(dt6Var.h, dt6Var.e());
                } else {
                    formatOverBaiwanNum = StringHelper.formatOverBaiwanNum(dt6Var.e());
                }
                this.n.setText(j(CurrencySwitchUtil.getGiftMoneyIconResId(dt6Var.h), formatOverBaiwanNum, 1));
                if (CurrencySwitchUtil.isYyIsConvert(dt6Var.h)) {
                    this.p.setText(R.string.obfuscated_res_0x7f0f0b3a);
                    this.o.setText(R.string.obfuscated_res_0x7f0f0794);
                    return;
                }
                this.p.setText(R.string.obfuscated_res_0x7f0f0b37);
                this.o.setText(R.string.obfuscated_res_0x7f0f0791);
                return;
            }
            this.g.setVisibility(8);
        }
    }

    public final void r(dt6 dt6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, dt6Var) == null) {
            if (dt6Var != null && dt6Var.a() != null && dt6Var.a().size() > 0) {
                if (dt6Var.c() != null) {
                    if (dt6Var.c().b == 1) {
                        this.i.setVisibility(0);
                    } else {
                        this.i.setVisibility(8);
                    }
                }
                this.s.e(dt6Var.a(), dt6Var.h);
                return;
            }
            this.i.setVisibility(8);
            this.u.setVisibility(8);
            this.s.e(null, -1);
        }
    }

    public void s(dt6 dt6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, dt6Var) == null) {
            if (!this.t && TbadkApplication.getInst().isGiftSwitchOn()) {
                this.u.setVisibility(0);
            } else {
                this.u.setVisibility(8);
            }
            if (dt6Var != null) {
                TbadkCoreApplication.getInst().currentAccountTdouNum = dt6Var.e();
            }
            m();
            p(dt6Var);
            r(dt6Var);
        }
    }

    public void t(cu4.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, gVar) == null) {
            this.k.f(gVar);
        }
    }

    public void u(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048588, this, str, z) == null) {
            if (this.d == null) {
                this.d = new h45(this.mContext.getContext(), new a(this));
            }
            this.d.k(this.mContext.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070295));
            this.d.attachView(this.f, z);
            this.d.p();
            this.u.setVisibility(8);
            this.e.setVisibility(8);
        }
    }

    public void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.e.setVisibility(0);
            this.e.F();
        }
    }
}

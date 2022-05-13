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
import com.repackage.ds6;
import com.repackage.pu4;
/* loaded from: classes6.dex */
public class fs6 extends z8<MyGiftListActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public MyGiftListActivity a;
    public NavigationBar b;
    public NoNetworkView c;
    public y45 d;
    public BdListView e;
    public View f;
    public View g;
    public View h;
    public View i;
    public View j;
    public qu4 k;
    public BdListView.p l;
    public TextView m;
    public TextView n;
    public TextView o;
    public TextView p;
    public TextView q;
    public LinearLayout r;
    public es6 s;
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
        public final /* synthetic */ fs6 a;

        public a(fs6 fs6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fs6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fs6Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.n();
                this.a.w();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fs6 a;

        public b(fs6 fs6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fs6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fs6Var;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
            ds6.a item;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) == null) || (item = this.a.s.getItem(i)) == null || item.a <= 0 || StringUtils.isNull(item.b)) {
                return;
            }
            if (this.a.t) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GiftTabActivityConfig(this.a.a.getPageContext().getPageActivity(), item.a, item.b, item.i, GiftTabActivityConfig.FROM_PERSON_CENTER)));
            } else if (!ki.z()) {
                this.a.a.showToast(R.string.obfuscated_res_0x7f0f0c2d);
            } else {
                this.a.a.sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(TbadkApplication.getInst().getContext(), String.valueOf(item.a), item.b)));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fs6 a;

        public c(fs6 fs6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fs6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fs6Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && view2 != null && view2 == this.a.o) {
                if (mi.C()) {
                    CurrencyJumpHelper.buyGiftGotoBuyTBeanPage(this.a.a.getPageContext().getPageActivity());
                } else {
                    UtilHelper.showToast(this.a.a.getPageContext().getPageActivity(), this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f0c2d));
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public fs6(MyGiftListActivity myGiftListActivity, BdListView.p pVar, boolean z) {
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
        q();
        o();
        if (!this.t && TbadkApplication.getInst().isGiftSwitchOn()) {
            this.u.setVisibility(0);
        } else {
            this.u.setVisibility(8);
        }
    }

    public void j(NoNetworkView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            this.c.a(bVar);
        }
    }

    public final SpannableString k(int i, String str, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2)})) == null) {
            String str2 = "[icon]" + str;
            SpannableString spannableString = new SpannableString(str2);
            Drawable drawable = SkinManager.getDrawable(i);
            int f = mi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.obfuscated_res_0x7f070201);
            if (i2 == 2) {
                drawable.setBounds(0, 3, f, mi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.obfuscated_res_0x7f0701f0));
            } else {
                drawable.setBounds(0, 0, f, f);
            }
            if (TbadkApplication.getInst().getSkinType() == 1) {
                drawable.setAlpha(179);
            } else {
                drawable.setAlpha(255);
            }
            ne5 ne5Var = new ne5(drawable);
            ne5Var.c(mi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.obfuscated_res_0x7f070234));
            UtilHelper.setSpan(spannableString, str2, "[icon]", ne5Var);
            AbsoluteSizeSpan absoluteSizeSpan = new AbsoluteSizeSpan(mi.f(this.a.getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f07032f));
            UtilHelper.setSpan(spannableString, str2, this.a.getResources().getString(R.string.obfuscated_res_0x7f0f149f), absoluteSizeSpan);
            UtilHelper.setSpan(spannableString, str2, this.a.getResources().getString(R.string.obfuscated_res_0x7f0f14a0), absoluteSizeSpan);
            return spannableString;
        }
        return (SpannableString) invokeCommon.objValue;
    }

    public void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.e.A(0L);
        }
    }

    public View m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.j : (View) invokeV.objValue;
    }

    public void n() {
        y45 y45Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (y45Var = this.d) == null) {
            return;
        }
        y45Var.dettachView(this.f);
        this.d = null;
        this.e.setVisibility(0);
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.u = (LinearLayout) this.a.findViewById(R.id.obfuscated_res_0x7f090cab);
            this.w = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f090cac);
            this.u.setOnClickListener(this.a.getSendGiftClickListener());
            this.v = this.a.findViewById(R.id.obfuscated_res_0x7f090cae);
            this.x = (ImageView) this.a.findViewById(R.id.obfuscated_res_0x7f090cad);
        }
    }

    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            this.a.getLayoutMode().k(i == 1);
            this.a.getLayoutMode().j(this.f);
            this.a.getLayoutMode().j(this.g);
            this.a.getLayoutMode().j(this.h);
            this.a.getLayoutMode().j(this.i);
            this.b.onChangeSkinType(getPageContext(), i);
            this.c.c(this.a.getPageContext(), i);
            this.k.H(i);
            es6 es6Var = this.s;
            if (es6Var != null) {
                es6Var.notifyDataSetChanged();
            }
            SkinManager.setBackgroundColor(this.v, R.color.CAM_X0204);
            SkinManager.setBackgroundColor(this.u, R.color.CAM_X0201);
            SkinManager.setViewTextColor(this.w, (int) R.color.CAM_X0302);
            SkinManager.setImageResource(this.x, R.drawable.icon_gift_list);
            gs4.d(this.p).v(R.color.CAM_X0101);
            gs4.d(this.q).v(R.color.CAM_X0101);
            gs4.d(this.m).v(R.color.CAM_X0101);
            gs4.d(this.o).v(R.color.CAM_X0101);
            gs4.d(this.n).v(R.color.CAM_X0101);
            gs4 d = gs4.d(this.g);
            d.e(R.string.A_X02);
            d.f(R.color.CAM_X0310);
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.a.setContentView(R.layout.obfuscated_res_0x7f0d0583);
            View findViewById = this.a.findViewById(R.id.obfuscated_res_0x7f091b16);
            this.f = findViewById;
            this.e = (BdListView) findViewById.findViewById(R.id.obfuscated_res_0x7f091284);
            NavigationBar navigationBar = (NavigationBar) this.f.findViewById(R.id.obfuscated_res_0x7f091534);
            this.b = navigationBar;
            MyGiftListActivity myGiftListActivity = this.a;
            if (myGiftListActivity.userType == 1) {
                navigationBar.setCenterTextTitle(myGiftListActivity.getPageContext().getString(R.string.obfuscated_res_0x7f0f066e));
            } else {
                String format = String.format(this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0823), myGiftListActivity.getUserSex());
                if (this.t) {
                    this.b.setCenterTextTitle(this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0b3e));
                } else {
                    this.b.setTitleText(format);
                }
            }
            this.b.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.c = (NoNetworkView) this.f.findViewById(R.id.obfuscated_res_0x7f0915ae);
            View inflate = LayoutInflater.from(this.a.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0587, (ViewGroup) null, false);
            this.h = inflate;
            inflate.setVisibility(8);
            View inflate2 = LayoutInflater.from(this.a.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0585, (ViewGroup) null, false);
            this.g = inflate2;
            inflate2.setVisibility(8);
            this.r = (LinearLayout) this.g.findViewById(R.id.obfuscated_res_0x7f0923f8);
            this.m = (TextView) this.g.findViewById(R.id.obfuscated_res_0x7f091fb2);
            this.n = (TextView) this.g.findViewById(R.id.obfuscated_res_0x7f091fb8);
            this.p = (TextView) this.g.findViewById(R.id.obfuscated_res_0x7f091fb9);
            this.o = (TextView) this.g.findViewById(R.id.obfuscated_res_0x7f0923f3);
            if (CurrencySwitchUtil.isYyIsConvert()) {
                this.p.setText(R.string.obfuscated_res_0x7f0f0b4e);
                this.o.setText(R.string.obfuscated_res_0x7f0f079d);
            } else {
                this.p.setText(R.string.obfuscated_res_0x7f0f0b4b);
                this.o.setText(R.string.obfuscated_res_0x7f0f079a);
            }
            this.q = (TextView) this.g.findViewById(R.id.obfuscated_res_0x7f091fb1);
            this.o.setOnClickListener(this.z);
            View inflate3 = LayoutInflater.from(this.a.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0584, (ViewGroup) null, false);
            this.i = inflate3;
            this.j = inflate3.findViewById(R.id.obfuscated_res_0x7f090c9d);
            if (this.t) {
                this.e.addHeaderView(this.g);
            } else {
                if (this.a.userType == 1) {
                    this.h.setVisibility(0);
                    this.e.addHeaderView(this.h);
                }
                if (TbadkApplication.getInst().isGiftSwitchOn()) {
                    this.i.setPadding(0, 0, 0, mi.f(this.a.getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f070254));
                }
            }
            this.e.addFooterView(this.i);
            es6 es6Var = new es6(this.a, this.t);
            this.s = es6Var;
            this.e.setAdapter((ListAdapter) es6Var);
            qu4 qu4Var = new qu4(this.a.getPageContext());
            this.k = qu4Var;
            this.e.setPullRefresh(qu4Var);
            this.e.setOnSrollToBottomListener(this.l);
            this.e.setOnItemClickListener(this.y);
        }
    }

    public final void r(ds6 ds6Var) {
        String formatOverBaiwanNum;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, ds6Var) == null) {
            if (ds6Var != null && this.t) {
                this.g.setVisibility(0);
                String str = ds6Var.d().b;
                String str2 = ds6Var.d().a;
                String str3 = ds6Var.g.b;
                this.m.setText(k(R.drawable.icon_gift_my_gift, StringHelper.formatOverBaiwanNum(ds6Var.b()), 0));
                if (CurrencySwitchUtil.isYyIsConvert(ds6Var.h)) {
                    formatOverBaiwanNum = CurrencyHelper.getFormatOverBaiwanNum(ds6Var.h, ds6Var.e());
                } else {
                    formatOverBaiwanNum = StringHelper.formatOverBaiwanNum(ds6Var.e());
                }
                this.n.setText(k(CurrencySwitchUtil.getGiftMoneyIconResId(ds6Var.h), formatOverBaiwanNum, 1));
                if (CurrencySwitchUtil.isYyIsConvert(ds6Var.h)) {
                    this.p.setText(R.string.obfuscated_res_0x7f0f0b4e);
                    this.o.setText(R.string.obfuscated_res_0x7f0f079d);
                    return;
                }
                this.p.setText(R.string.obfuscated_res_0x7f0f0b4b);
                this.o.setText(R.string.obfuscated_res_0x7f0f079a);
                return;
            }
            this.g.setVisibility(8);
        }
    }

    public final void s(ds6 ds6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, ds6Var) == null) {
            if (ds6Var != null && ds6Var.a() != null && ds6Var.a().size() > 0) {
                if (ds6Var.c() != null) {
                    if (ds6Var.c().b == 1) {
                        this.i.setVisibility(0);
                    } else {
                        this.i.setVisibility(8);
                    }
                }
                this.s.e(ds6Var.a(), ds6Var.h);
                return;
            }
            this.i.setVisibility(8);
            this.u.setVisibility(8);
            this.s.e(null, -1);
        }
    }

    public void t(ds6 ds6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, ds6Var) == null) {
            if (!this.t && TbadkApplication.getInst().isGiftSwitchOn()) {
                this.u.setVisibility(0);
            } else {
                this.u.setVisibility(8);
            }
            if (ds6Var != null) {
                TbadkCoreApplication.getInst().currentAccountTdouNum = ds6Var.e();
            }
            n();
            r(ds6Var);
            s(ds6Var);
        }
    }

    public void u(pu4.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, gVar) == null) {
            this.k.e(gVar);
        }
    }

    public void v(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048588, this, str, z) == null) {
            if (this.d == null) {
                this.d = new y45(this.mContext.getContext(), new a(this));
            }
            this.d.k(this.mContext.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070295));
            this.d.attachView(this.f, z);
            this.d.p();
            this.u.setVisibility(8);
            this.e.setVisibility(8);
        }
    }

    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.e.setVisibility(0);
            this.e.F();
        }
    }
}

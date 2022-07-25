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
import com.repackage.gu4;
import com.repackage.yr6;
/* loaded from: classes5.dex */
public class as6 extends b9<MyGiftListActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public MyGiftListActivity a;
    public NavigationBar b;
    public NoNetworkView c;
    public l55 d;
    public BdListView e;
    public View f;
    public View g;
    public View h;
    public View i;
    public View j;
    public hu4 k;
    public BdListView.p l;
    public TextView m;
    public TextView n;
    public TextView o;
    public TextView p;
    public TextView q;
    public LinearLayout r;
    public zr6 s;
    public boolean t;
    public LinearLayout u;
    public View v;
    public TextView w;
    public ImageView x;
    public AdapterView.OnItemClickListener y;
    public View.OnClickListener z;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ as6 a;

        public a(as6 as6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {as6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = as6Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.p();
                this.a.x();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ as6 a;

        public b(as6 as6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {as6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = as6Var;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
            yr6.a item;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) == null) || (item = this.a.s.getItem(i)) == null || item.a <= 0 || StringUtils.isNull(item.b)) {
                return;
            }
            if (this.a.t) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GiftTabActivityConfig(this.a.a.getPageContext().getPageActivity(), item.a, item.b, item.i, GiftTabActivityConfig.FROM_PERSON_CENTER)));
            } else if (!ni.z()) {
                this.a.a.showToast(R.string.obfuscated_res_0x7f0f0c17);
            } else {
                this.a.a.sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(TbadkApplication.getInst().getContext(), String.valueOf(item.a), item.b)));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ as6 a;

        public c(as6 as6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {as6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = as6Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && view2 != null && view2 == this.a.o) {
                if (pi.D()) {
                    CurrencyJumpHelper.buyGiftGotoBuyTBeanPage(this.a.a.getPageContext().getPageActivity());
                } else {
                    UtilHelper.showToast(this.a.a.getPageContext().getPageActivity(), this.a.a.getResources().getString(R.string.obfuscated_res_0x7f0f0c17));
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public as6(MyGiftListActivity myGiftListActivity, BdListView.p pVar, boolean z) {
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
                super((d9) newInitContext.callArgs[0]);
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
        r();
        q();
        if (!this.t && TbadkApplication.getInst().isGiftSwitchOn()) {
            this.u.setVisibility(0);
        } else {
            this.u.setVisibility(8);
        }
    }

    public void l(NoNetworkView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            this.c.a(bVar);
        }
    }

    public final SpannableString m(int i, String str, int i2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), str, Integer.valueOf(i2)})) == null) {
            String str2 = "[icon]" + str;
            SpannableString spannableString = new SpannableString(str2);
            Drawable drawable = SkinManager.getDrawable(i);
            int f = pi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.obfuscated_res_0x7f070201);
            if (i2 == 2) {
                drawable.setBounds(0, 3, f, pi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.obfuscated_res_0x7f0701f0));
            } else {
                drawable.setBounds(0, 0, f, f);
            }
            if (TbadkApplication.getInst().getSkinType() == 1) {
                drawable.setAlpha(179);
            } else {
                drawable.setAlpha(255);
            }
            ze5 ze5Var = new ze5(drawable);
            ze5Var.c(pi.f(TbadkCoreApplication.getInst().getContext(), R.dimen.obfuscated_res_0x7f070230));
            UtilHelper.setSpan(spannableString, str2, "[icon]", ze5Var);
            AbsoluteSizeSpan absoluteSizeSpan = new AbsoluteSizeSpan(pi.f(this.a.getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f07032c));
            UtilHelper.setSpan(spannableString, str2, this.a.getResources().getString(R.string.obfuscated_res_0x7f0f1469), absoluteSizeSpan);
            UtilHelper.setSpan(spannableString, str2, this.a.getResources().getString(R.string.obfuscated_res_0x7f0f146a), absoluteSizeSpan);
            return spannableString;
        }
        return (SpannableString) invokeCommon.objValue;
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.e.A(0L);
        }
    }

    public View o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.j : (View) invokeV.objValue;
    }

    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            this.a.getLayoutMode().k(i == 1);
            this.a.getLayoutMode().j(this.f);
            this.a.getLayoutMode().j(this.g);
            this.a.getLayoutMode().j(this.h);
            this.a.getLayoutMode().j(this.i);
            this.b.onChangeSkinType(getPageContext(), i);
            this.c.d(this.a.getPageContext(), i);
            this.k.H(i);
            zr6 zr6Var = this.s;
            if (zr6Var != null) {
                zr6Var.notifyDataSetChanged();
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

    public void p() {
        l55 l55Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048581, this) == null) || (l55Var = this.d) == null) {
            return;
        }
        l55Var.dettachView(this.f);
        this.d = null;
        this.e.setVisibility(0);
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.u = (LinearLayout) this.a.findViewById(R.id.obfuscated_res_0x7f090c61);
            this.w = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f090c62);
            this.u.setOnClickListener(this.a.H1());
            this.v = this.a.findViewById(R.id.obfuscated_res_0x7f090c64);
            this.x = (ImageView) this.a.findViewById(R.id.obfuscated_res_0x7f090c63);
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.a.setContentView(R.layout.obfuscated_res_0x7f0d059a);
            View findViewById = this.a.findViewById(R.id.obfuscated_res_0x7f091b36);
            this.f = findViewById;
            this.e = (BdListView) findViewById.findViewById(R.id.obfuscated_res_0x7f0912b8);
            NavigationBar navigationBar = (NavigationBar) this.f.findViewById(R.id.obfuscated_res_0x7f091568);
            this.b = navigationBar;
            MyGiftListActivity myGiftListActivity = this.a;
            if (myGiftListActivity.j == 1) {
                navigationBar.setCenterTextTitle(myGiftListActivity.getPageContext().getString(R.string.obfuscated_res_0x7f0f066f));
            } else {
                String format = String.format(this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f082d), myGiftListActivity.I1());
                if (this.t) {
                    this.b.setCenterTextTitle(this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f0b23));
                } else {
                    this.b.setTitleText(format);
                }
            }
            this.b.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.c = (NoNetworkView) this.f.findViewById(R.id.obfuscated_res_0x7f0915e4);
            View inflate = LayoutInflater.from(this.a.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d059e, (ViewGroup) null, false);
            this.h = inflate;
            inflate.setVisibility(8);
            View inflate2 = LayoutInflater.from(this.a.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d059c, (ViewGroup) null, false);
            this.g = inflate2;
            inflate2.setVisibility(8);
            this.r = (LinearLayout) this.g.findViewById(R.id.obfuscated_res_0x7f092434);
            this.m = (TextView) this.g.findViewById(R.id.obfuscated_res_0x7f092000);
            this.n = (TextView) this.g.findViewById(R.id.obfuscated_res_0x7f092006);
            this.p = (TextView) this.g.findViewById(R.id.obfuscated_res_0x7f092007);
            this.o = (TextView) this.g.findViewById(R.id.obfuscated_res_0x7f09242f);
            if (CurrencySwitchUtil.isYyIsConvert()) {
                this.p.setText(R.string.obfuscated_res_0x7f0f0b34);
                this.o.setText(R.string.obfuscated_res_0x7f0f07a6);
            } else {
                this.p.setText(R.string.obfuscated_res_0x7f0f0b30);
                this.o.setText(R.string.obfuscated_res_0x7f0f07a3);
            }
            this.q = (TextView) this.g.findViewById(R.id.obfuscated_res_0x7f091fff);
            this.o.setOnClickListener(this.z);
            View inflate3 = LayoutInflater.from(this.a.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d059b, (ViewGroup) null, false);
            this.i = inflate3;
            this.j = inflate3.findViewById(R.id.obfuscated_res_0x7f090c54);
            if (this.t) {
                this.e.addHeaderView(this.g);
            } else {
                if (this.a.j == 1) {
                    this.h.setVisibility(0);
                    this.e.addHeaderView(this.h);
                }
                if (TbadkApplication.getInst().isGiftSwitchOn()) {
                    this.i.setPadding(0, 0, 0, pi.f(this.a.getPageContext().getPageActivity(), R.dimen.obfuscated_res_0x7f070250));
                }
            }
            this.e.addFooterView(this.i);
            zr6 zr6Var = new zr6(this.a, this.t);
            this.s = zr6Var;
            this.e.setAdapter((ListAdapter) zr6Var);
            hu4 hu4Var = new hu4(this.a.getPageContext());
            this.k = hu4Var;
            this.e.setPullRefresh(hu4Var);
            this.e.setOnSrollToBottomListener(this.l);
            this.e.setOnItemClickListener(this.y);
        }
    }

    public final void s(yr6 yr6Var) {
        String formatOverBaiwanNum;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, yr6Var) == null) {
            if (yr6Var != null && this.t) {
                this.g.setVisibility(0);
                String str = yr6Var.d().b;
                String str2 = yr6Var.d().a;
                String str3 = yr6Var.g.b;
                this.m.setText(m(R.drawable.icon_gift_my_gift, StringHelper.formatOverBaiwanNum(yr6Var.b()), 0));
                if (CurrencySwitchUtil.isYyIsConvert(yr6Var.h)) {
                    formatOverBaiwanNum = CurrencyHelper.getFormatOverBaiwanNum(yr6Var.h, yr6Var.e());
                } else {
                    formatOverBaiwanNum = StringHelper.formatOverBaiwanNum(yr6Var.e());
                }
                this.n.setText(m(CurrencySwitchUtil.getGiftMoneyIconResId(yr6Var.h), formatOverBaiwanNum, 1));
                if (CurrencySwitchUtil.isYyIsConvert(yr6Var.h)) {
                    this.p.setText(R.string.obfuscated_res_0x7f0f0b34);
                    this.o.setText(R.string.obfuscated_res_0x7f0f07a6);
                    return;
                }
                this.p.setText(R.string.obfuscated_res_0x7f0f0b30);
                this.o.setText(R.string.obfuscated_res_0x7f0f07a3);
                return;
            }
            this.g.setVisibility(8);
        }
    }

    public final void t(yr6 yr6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, yr6Var) == null) {
            if (yr6Var != null && yr6Var.a() != null && yr6Var.a().size() > 0) {
                if (yr6Var.c() != null) {
                    if (yr6Var.c().b == 1) {
                        this.i.setVisibility(0);
                    } else {
                        this.i.setVisibility(8);
                    }
                }
                this.s.e(yr6Var.a(), yr6Var.h);
                return;
            }
            this.i.setVisibility(8);
            this.u.setVisibility(8);
            this.s.e(null, -1);
        }
    }

    public void u(yr6 yr6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, yr6Var) == null) {
            if (!this.t && TbadkApplication.getInst().isGiftSwitchOn()) {
                this.u.setVisibility(0);
            } else {
                this.u.setVisibility(8);
            }
            if (yr6Var != null) {
                TbadkCoreApplication.getInst().currentAccountTdouNum = yr6Var.e();
            }
            p();
            s(yr6Var);
            t(yr6Var);
        }
    }

    public void v(gu4.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, gVar) == null) {
            this.k.f(gVar);
        }
    }

    public void w(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048588, this, str, z) == null) {
            if (this.d == null) {
                this.d = new l55(this.mContext.getContext(), new a(this));
            }
            this.d.k(this.mContext.getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070292));
            this.d.attachView(this.f, z);
            this.d.p();
            this.u.setVisibility(8);
            this.e.setVisibility(8);
        }
    }

    public void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.e.setVisibility(0);
            this.e.F();
        }
    }
}

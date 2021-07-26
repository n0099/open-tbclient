package d.a.q0.y0.c;

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
import com.baidu.tbadk.core.util.UrlManager;
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
import d.a.d.a.d;
import d.a.d.a.f;
import d.a.d.e.p.j;
import d.a.d.e.p.l;
import d.a.p0.f0.h;
import d.a.p0.s.f0.f;
import d.a.p0.s.f0.g;
import d.a.q0.y0.c.a;
/* loaded from: classes8.dex */
public class c extends d<MyGiftListActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AdapterView.OnItemClickListener A;
    public View.OnClickListener B;

    /* renamed from: a  reason: collision with root package name */
    public MyGiftListActivity f67057a;

    /* renamed from: b  reason: collision with root package name */
    public NavigationBar f67058b;

    /* renamed from: c  reason: collision with root package name */
    public NoNetworkView f67059c;

    /* renamed from: d  reason: collision with root package name */
    public h f67060d;

    /* renamed from: e  reason: collision with root package name */
    public BdListView f67061e;

    /* renamed from: f  reason: collision with root package name */
    public View f67062f;

    /* renamed from: g  reason: collision with root package name */
    public View f67063g;

    /* renamed from: h  reason: collision with root package name */
    public View f67064h;

    /* renamed from: i  reason: collision with root package name */
    public View f67065i;
    public View j;
    public g k;
    public BdListView.p l;
    public TextView m;
    public TextView n;
    public TextView o;
    public TextView p;
    public TextView q;
    public TextView r;
    public LinearLayout s;
    public d.a.q0.y0.c.b t;
    public boolean u;
    public String v;
    public LinearLayout w;
    public View x;
    public TextView y;
    public ImageView z;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f67066e;

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f67066e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f67066e.o();
                this.f67066e.w();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f67067e;

        public b(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f67067e = cVar;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
            a.C1856a item;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j)}) == null) || (item = this.f67067e.t.getItem(i2)) == null || item.f67028a <= 0 || StringUtils.isNull(item.f67029b)) {
                return;
            }
            if (this.f67067e.u) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GiftTabActivityConfig(this.f67067e.f67057a.getPageContext().getPageActivity(), item.f67028a, item.f67029b, item.k, GiftTabActivityConfig.FROM_PERSON_CENTER)));
            } else if (!j.z()) {
                this.f67067e.f67057a.showToast(R.string.neterror);
            } else {
                this.f67067e.f67057a.sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(TbadkApplication.getInst().getContext(), String.valueOf(item.f67028a), item.f67029b)));
            }
        }
    }

    /* renamed from: d.a.q0.y0.c.c$c  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class View$OnClickListenerC1858c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f67068e;

        public View$OnClickListenerC1858c(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f67068e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || view == null) {
                return;
            }
            if (view != this.f67068e.o) {
                if (view != this.f67068e.r || StringUtils.isNull(this.f67068e.v)) {
                    return;
                }
                UrlManager.getInstance().dealOneLink(this.f67068e.f67057a.getPageContext(), new String[]{this.f67068e.v});
            } else if (l.D()) {
                CurrencyJumpHelper.buyGiftGotoBuyTBeanPage(this.f67068e.f67057a.getPageContext().getPageActivity());
            } else {
                UtilHelper.showToast(this.f67068e.f67057a.getPageContext().getPageActivity(), this.f67068e.f67057a.getResources().getString(R.string.neterror));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(MyGiftListActivity myGiftListActivity, BdListView.p pVar, boolean z) {
        super(myGiftListActivity.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {myGiftListActivity, pVar, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.k = null;
        this.A = new b(this);
        this.B = new View$OnClickListenerC1858c(this);
        this.f67057a = myGiftListActivity;
        this.u = z;
        this.l = pVar;
        q();
        p();
        if (!this.u && TbadkApplication.getInst().isGiftSwitchOn()) {
            this.w.setVisibility(0);
        } else {
            this.w.setVisibility(8);
        }
    }

    public void k(NoNetworkView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            this.f67059c.a(bVar);
        }
    }

    public final SpannableString l(int i2, String str, int i3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i2), str, Integer.valueOf(i3)})) == null) {
            String str2 = "[icon]" + str;
            SpannableString spannableString = new SpannableString(str2);
            Drawable drawable = SkinManager.getDrawable(i2);
            int g2 = l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.ds30);
            if (i3 == 2) {
                drawable.setBounds(0, 3, g2, l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.ds26));
            } else {
                drawable.setBounds(0, 0, g2, g2);
            }
            if (TbadkApplication.getInst().getSkinType() == 1) {
                drawable.setAlpha(179);
            } else {
                drawable.setAlpha(255);
            }
            d.a.p0.d1.d dVar = new d.a.p0.d1.d(drawable);
            dVar.c(l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.ds10));
            UtilHelper.setSpan(spannableString, str2, "[icon]", dVar);
            AbsoluteSizeSpan absoluteSizeSpan = new AbsoluteSizeSpan(l.g(this.f67057a.getPageContext().getPageActivity(), R.dimen.fontsize22));
            UtilHelper.setSpan(spannableString, str2, this.f67057a.getResources().getString(R.string.unit_wan), absoluteSizeSpan);
            UtilHelper.setSpan(spannableString, str2, this.f67057a.getResources().getString(R.string.unit_yi), absoluteSizeSpan);
            return spannableString;
        }
        return (SpannableString) invokeCommon.objValue;
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f67061e.A(0L);
        }
    }

    public View n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.j : (View) invokeV.objValue;
    }

    public void o() {
        h hVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (hVar = this.f67060d) == null) {
            return;
        }
        hVar.dettachView(this.f67062f);
        this.f67060d = null;
        this.f67061e.setVisibility(0);
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            this.f67057a.getLayoutMode().k(i2 == 1);
            this.f67057a.getLayoutMode().j(this.f67062f);
            this.f67057a.getLayoutMode().j(this.f67063g);
            this.f67057a.getLayoutMode().j(this.f67064h);
            this.f67057a.getLayoutMode().j(this.f67065i);
            this.f67058b.onChangeSkinType(getPageContext(), i2);
            this.f67059c.c(this.f67057a.getPageContext(), i2);
            this.k.I(i2);
            d.a.q0.y0.c.b bVar = this.t;
            if (bVar != null) {
                bVar.notifyDataSetChanged();
            }
            SkinManager.setBackgroundColor(this.x, R.color.CAM_X0204);
            SkinManager.setBackgroundColor(this.w, R.color.CAM_X0201);
            SkinManager.setViewTextColor(this.y, R.color.CAM_X0302);
            SkinManager.setImageResource(this.z, R.drawable.icon_gift_list);
        }
    }

    public final void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.w = (LinearLayout) this.f67057a.findViewById(R.id.gift_relation_ll);
            this.y = (TextView) this.f67057a.findViewById(R.id.gift_relation_text);
            this.w.setOnClickListener(this.f67057a.getSendGiftClickListener());
            this.x = this.f67057a.findViewById(R.id.gift_send_gift_top_line);
            this.z = (ImageView) this.f67057a.findViewById(R.id.gift_send_gift_icon);
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f67057a.setContentView(R.layout.my_gift_list_activity);
            View findViewById = this.f67057a.findViewById(R.id.root);
            this.f67062f = findViewById;
            this.f67061e = (BdListView) findViewById.findViewById(R.id.list_view);
            NavigationBar navigationBar = (NavigationBar) this.f67062f.findViewById(R.id.navigation_bar);
            this.f67058b = navigationBar;
            MyGiftListActivity myGiftListActivity = this.f67057a;
            if (myGiftListActivity.userType == 1) {
                navigationBar.setCenterTextTitle(myGiftListActivity.getPageContext().getString(R.string.forum_gift_list));
            } else {
                String format = String.format(this.f67057a.getPageContext().getString(R.string.he_gift_title), myGiftListActivity.getUserSex());
                if (this.u) {
                    this.f67058b.setCenterTextTitle(this.f67057a.getPageContext().getString(R.string.my_gift_list));
                } else {
                    this.f67058b.setTitleText(format);
                }
            }
            this.f67058b.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.f67059c = (NoNetworkView) this.f67062f.findViewById(R.id.no_networkview);
            View inflate = LayoutInflater.from(this.f67057a.getPageContext().getPageActivity()).inflate(R.layout.my_gift_list_rank_head, (ViewGroup) null, false);
            this.f67064h = inflate;
            inflate.setVisibility(8);
            View inflate2 = LayoutInflater.from(this.f67057a.getPageContext().getPageActivity()).inflate(R.layout.my_gift_list_head, (ViewGroup) null, false);
            this.f67063g = inflate2;
            inflate2.setVisibility(8);
            this.s = (LinearLayout) this.f67063g.findViewById(R.id.view_link_info);
            this.m = (TextView) this.f67063g.findViewById(R.id.textview_gift_number);
            this.n = (TextView) this.f67063g.findViewById(R.id.textview_tdou_number);
            this.p = (TextView) this.f67063g.findViewById(R.id.textview_tdou_number_title);
            this.o = (TextView) this.f67063g.findViewById(R.id.view_get_tdou);
            if (CurrencySwitchUtil.isYyIsConvert()) {
                this.p.setText(R.string.my_ybean);
                this.o.setText(R.string.get_ybean);
            } else {
                this.p.setText(R.string.my_tdou);
                this.o.setText(R.string.get_tdou);
            }
            this.q = (TextView) this.f67063g.findViewById(R.id.textview_blue_number);
            TextView textView = (TextView) this.f67063g.findViewById(R.id.view_get_blue);
            this.r = textView;
            textView.setOnClickListener(this.B);
            this.o.setOnClickListener(this.B);
            View inflate3 = LayoutInflater.from(this.f67057a.getPageContext().getPageActivity()).inflate(R.layout.my_gift_list_footer, (ViewGroup) null, false);
            this.f67065i = inflate3;
            this.j = inflate3.findViewById(R.id.gift_footer_lay);
            if (this.u) {
                this.f67061e.addHeaderView(this.f67063g);
            } else {
                if (this.f67057a.userType == 1) {
                    this.f67064h.setVisibility(0);
                    this.f67061e.addHeaderView(this.f67064h);
                }
                if (TbadkApplication.getInst().isGiftSwitchOn()) {
                    this.f67065i.setPadding(0, 0, 0, l.g(this.f67057a.getPageContext().getPageActivity(), R.dimen.ds156));
                }
            }
            this.f67061e.addFooterView(this.f67065i);
            d.a.q0.y0.c.b bVar = new d.a.q0.y0.c.b(this.f67057a, this.u);
            this.t = bVar;
            this.f67061e.setAdapter((ListAdapter) bVar);
            g gVar = new g(this.f67057a.getPageContext());
            this.k = gVar;
            this.f67061e.setPullRefresh(gVar);
            this.f67061e.setOnSrollToBottomListener(this.l);
            this.f67061e.setOnItemClickListener(this.A);
        }
    }

    public final void r(d.a.q0.y0.c.a aVar) {
        String formatOverBaiwanNum;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, aVar) == null) {
            if (aVar != null && this.u) {
                this.f67063g.setVisibility(0);
                String str = aVar.d().f67041b;
                String str2 = aVar.d().f67040a;
                this.v = aVar.f67026g.f53375b;
                this.m.setText(l(R.drawable.icon_gift_my_gift, StringHelper.formatOverBaiwanNum(aVar.b()), 0));
                if (CurrencySwitchUtil.isYyIsConvert(aVar.f67027h)) {
                    formatOverBaiwanNum = CurrencyHelper.getFormatOverBaiwanNum(aVar.f67027h, aVar.e());
                } else {
                    formatOverBaiwanNum = StringHelper.formatOverBaiwanNum(aVar.e());
                }
                this.q.setText(l(R.drawable.icon_gift_bluedrill, StringHelper.formatOverBaiwanNum(aVar.f67025f), 2));
                this.r.setText(aVar.f67026g.f53374a);
                this.n.setText(l(CurrencySwitchUtil.getGiftMoneyIconResId(aVar.f67027h), formatOverBaiwanNum, 1));
                if (CurrencySwitchUtil.isYyIsConvert(aVar.f67027h)) {
                    this.p.setText(R.string.my_ybean);
                    this.o.setText(R.string.get_ybean);
                    return;
                }
                this.p.setText(R.string.my_tdou);
                this.o.setText(R.string.get_tdou);
                return;
            }
            this.f67063g.setVisibility(8);
        }
    }

    public final void s(d.a.q0.y0.c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, aVar) == null) {
            if (aVar != null && aVar.a() != null && aVar.a().size() > 0) {
                if (aVar.c() != null) {
                    if (aVar.c().f67038b == 1) {
                        this.f67065i.setVisibility(0);
                    } else {
                        this.f67065i.setVisibility(8);
                    }
                }
                this.t.e(aVar.a(), aVar.f67027h);
                return;
            }
            this.f67065i.setVisibility(8);
            this.w.setVisibility(8);
            this.t.e(null, -1);
        }
    }

    public void t(d.a.q0.y0.c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, aVar) == null) {
            if (!this.u && TbadkApplication.getInst().isGiftSwitchOn()) {
                this.w.setVisibility(0);
            } else {
                this.w.setVisibility(8);
            }
            if (aVar != null) {
                TbadkCoreApplication.getInst().currentAccountTdouNum = aVar.e();
            }
            o();
            r(aVar);
            s(aVar);
        }
    }

    public void u(f.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, gVar) == null) {
            this.k.a(gVar);
        }
    }

    public void v(String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048588, this, str, z) == null) {
            if (this.f67060d == null) {
                this.f67060d = new h(this.mContext.getContext(), new a(this));
            }
            this.f67060d.j(this.mContext.getResources().getDimensionPixelSize(R.dimen.ds280));
            this.f67060d.attachView(this.f67062f, z);
            this.f67060d.o();
            this.w.setVisibility(8);
            this.f67061e.setVisibility(8);
        }
    }

    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.f67061e.setVisibility(0);
            this.f67061e.F();
        }
    }
}

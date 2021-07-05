package d.a.s0.y0.c;

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
import d.a.c.a.d;
import d.a.c.a.f;
import d.a.c.e.p.j;
import d.a.c.e.p.l;
import d.a.r0.d0.h;
import d.a.r0.r.f0.f;
import d.a.r0.r.f0.g;
import d.a.s0.y0.c.a;
/* loaded from: classes9.dex */
public class c extends d<MyGiftListActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public AdapterView.OnItemClickListener A;
    public View.OnClickListener B;

    /* renamed from: a  reason: collision with root package name */
    public MyGiftListActivity f69576a;

    /* renamed from: b  reason: collision with root package name */
    public NavigationBar f69577b;

    /* renamed from: c  reason: collision with root package name */
    public NoNetworkView f69578c;

    /* renamed from: d  reason: collision with root package name */
    public h f69579d;

    /* renamed from: e  reason: collision with root package name */
    public BdListView f69580e;

    /* renamed from: f  reason: collision with root package name */
    public View f69581f;

    /* renamed from: g  reason: collision with root package name */
    public View f69582g;

    /* renamed from: h  reason: collision with root package name */
    public View f69583h;

    /* renamed from: i  reason: collision with root package name */
    public View f69584i;
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
    public d.a.s0.y0.c.b t;
    public boolean u;
    public String v;
    public LinearLayout w;
    public View x;
    public TextView y;
    public ImageView z;

    /* loaded from: classes9.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f69585e;

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
            this.f69585e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f69585e.o();
                this.f69585e.w();
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f69586e;

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
            this.f69586e = cVar;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
            a.C1892a item;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view, Integer.valueOf(i2), Long.valueOf(j)}) == null) || (item = this.f69586e.t.getItem(i2)) == null || item.f69547a <= 0 || StringUtils.isNull(item.f69548b)) {
                return;
            }
            if (this.f69586e.u) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new GiftTabActivityConfig(this.f69586e.f69576a.getPageContext().getPageActivity(), item.f69547a, item.f69548b, item.k, GiftTabActivityConfig.FROM_PERSON_CENTER)));
            } else if (!j.z()) {
                this.f69586e.f69576a.showToast(R.string.neterror);
            } else {
                this.f69586e.f69576a.sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(TbadkApplication.getInst().getContext(), String.valueOf(item.f69547a), item.f69548b)));
            }
        }
    }

    /* renamed from: d.a.s0.y0.c.c$c  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class View$OnClickListenerC1894c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f69587e;

        public View$OnClickListenerC1894c(c cVar) {
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
            this.f69587e = cVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || view == null) {
                return;
            }
            if (view != this.f69587e.o) {
                if (view != this.f69587e.r || StringUtils.isNull(this.f69587e.v)) {
                    return;
                }
                UrlManager.getInstance().dealOneLink(this.f69587e.f69576a.getPageContext(), new String[]{this.f69587e.v});
            } else if (l.D()) {
                CurrencyJumpHelper.buyGiftGotoBuyTBeanPage(this.f69587e.f69576a.getPageContext().getPageActivity());
            } else {
                UtilHelper.showToast(this.f69587e.f69576a.getPageContext().getPageActivity(), this.f69587e.f69576a.getResources().getString(R.string.neterror));
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
        this.B = new View$OnClickListenerC1894c(this);
        this.f69576a = myGiftListActivity;
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
            this.f69578c.a(bVar);
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
            d.a.r0.b1.d dVar = new d.a.r0.b1.d(drawable);
            dVar.c(l.g(TbadkCoreApplication.getInst().getContext(), R.dimen.ds10));
            UtilHelper.setSpan(spannableString, str2, "[icon]", dVar);
            AbsoluteSizeSpan absoluteSizeSpan = new AbsoluteSizeSpan(l.g(this.f69576a.getPageContext().getPageActivity(), R.dimen.fontsize22));
            UtilHelper.setSpan(spannableString, str2, this.f69576a.getResources().getString(R.string.unit_wan), absoluteSizeSpan);
            UtilHelper.setSpan(spannableString, str2, this.f69576a.getResources().getString(R.string.unit_yi), absoluteSizeSpan);
            return spannableString;
        }
        return (SpannableString) invokeCommon.objValue;
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f69580e.A(0L);
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
        if (!(interceptable == null || interceptable.invokeV(1048580, this) == null) || (hVar = this.f69579d) == null) {
            return;
        }
        hVar.dettachView(this.f69581f);
        this.f69579d = null;
        this.f69580e.setVisibility(0);
    }

    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            this.f69576a.getLayoutMode().k(i2 == 1);
            this.f69576a.getLayoutMode().j(this.f69581f);
            this.f69576a.getLayoutMode().j(this.f69582g);
            this.f69576a.getLayoutMode().j(this.f69583h);
            this.f69576a.getLayoutMode().j(this.f69584i);
            this.f69577b.onChangeSkinType(getPageContext(), i2);
            this.f69578c.c(this.f69576a.getPageContext(), i2);
            this.k.I(i2);
            d.a.s0.y0.c.b bVar = this.t;
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
            this.w = (LinearLayout) this.f69576a.findViewById(R.id.gift_relation_ll);
            this.y = (TextView) this.f69576a.findViewById(R.id.gift_relation_text);
            this.w.setOnClickListener(this.f69576a.getSendGiftClickListener());
            this.x = this.f69576a.findViewById(R.id.gift_send_gift_top_line);
            this.z = (ImageView) this.f69576a.findViewById(R.id.gift_send_gift_icon);
        }
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.f69576a.setContentView(R.layout.my_gift_list_activity);
            View findViewById = this.f69576a.findViewById(R.id.root);
            this.f69581f = findViewById;
            this.f69580e = (BdListView) findViewById.findViewById(R.id.list_view);
            NavigationBar navigationBar = (NavigationBar) this.f69581f.findViewById(R.id.navigation_bar);
            this.f69577b = navigationBar;
            MyGiftListActivity myGiftListActivity = this.f69576a;
            if (myGiftListActivity.userType == 1) {
                navigationBar.setCenterTextTitle(myGiftListActivity.getPageContext().getString(R.string.forum_gift_list));
            } else {
                String format = String.format(this.f69576a.getPageContext().getString(R.string.he_gift_title), myGiftListActivity.getUserSex());
                if (this.u) {
                    this.f69577b.setCenterTextTitle(this.f69576a.getPageContext().getString(R.string.my_gift_list));
                } else {
                    this.f69577b.setTitleText(format);
                }
            }
            this.f69577b.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
            this.f69578c = (NoNetworkView) this.f69581f.findViewById(R.id.no_networkview);
            View inflate = LayoutInflater.from(this.f69576a.getPageContext().getPageActivity()).inflate(R.layout.my_gift_list_rank_head, (ViewGroup) null, false);
            this.f69583h = inflate;
            inflate.setVisibility(8);
            View inflate2 = LayoutInflater.from(this.f69576a.getPageContext().getPageActivity()).inflate(R.layout.my_gift_list_head, (ViewGroup) null, false);
            this.f69582g = inflate2;
            inflate2.setVisibility(8);
            this.s = (LinearLayout) this.f69582g.findViewById(R.id.view_link_info);
            this.m = (TextView) this.f69582g.findViewById(R.id.textview_gift_number);
            this.n = (TextView) this.f69582g.findViewById(R.id.textview_tdou_number);
            this.p = (TextView) this.f69582g.findViewById(R.id.textview_tdou_number_title);
            this.o = (TextView) this.f69582g.findViewById(R.id.view_get_tdou);
            if (CurrencySwitchUtil.isYyIsConvert()) {
                this.p.setText(R.string.my_ybean);
                this.o.setText(R.string.get_ybean);
            } else {
                this.p.setText(R.string.my_tdou);
                this.o.setText(R.string.get_tdou);
            }
            this.q = (TextView) this.f69582g.findViewById(R.id.textview_blue_number);
            TextView textView = (TextView) this.f69582g.findViewById(R.id.view_get_blue);
            this.r = textView;
            textView.setOnClickListener(this.B);
            this.o.setOnClickListener(this.B);
            View inflate3 = LayoutInflater.from(this.f69576a.getPageContext().getPageActivity()).inflate(R.layout.my_gift_list_footer, (ViewGroup) null, false);
            this.f69584i = inflate3;
            this.j = inflate3.findViewById(R.id.gift_footer_lay);
            if (this.u) {
                this.f69580e.addHeaderView(this.f69582g);
            } else {
                if (this.f69576a.userType == 1) {
                    this.f69583h.setVisibility(0);
                    this.f69580e.addHeaderView(this.f69583h);
                }
                if (TbadkApplication.getInst().isGiftSwitchOn()) {
                    this.f69584i.setPadding(0, 0, 0, l.g(this.f69576a.getPageContext().getPageActivity(), R.dimen.ds156));
                }
            }
            this.f69580e.addFooterView(this.f69584i);
            d.a.s0.y0.c.b bVar = new d.a.s0.y0.c.b(this.f69576a, this.u);
            this.t = bVar;
            this.f69580e.setAdapter((ListAdapter) bVar);
            g gVar = new g(this.f69576a.getPageContext());
            this.k = gVar;
            this.f69580e.setPullRefresh(gVar);
            this.f69580e.setOnSrollToBottomListener(this.l);
            this.f69580e.setOnItemClickListener(this.A);
        }
    }

    public final void r(d.a.s0.y0.c.a aVar) {
        String formatOverBaiwanNum;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, aVar) == null) {
            if (aVar != null && this.u) {
                this.f69582g.setVisibility(0);
                String str = aVar.d().f69560b;
                String str2 = aVar.d().f69559a;
                this.v = aVar.f69545g.f55995b;
                this.m.setText(l(R.drawable.icon_gift_my_gift, StringHelper.formatOverBaiwanNum(aVar.b()), 0));
                if (CurrencySwitchUtil.isYyIsConvert(aVar.f69546h)) {
                    formatOverBaiwanNum = CurrencyHelper.getFormatOverBaiwanNum(aVar.f69546h, aVar.e());
                } else {
                    formatOverBaiwanNum = StringHelper.formatOverBaiwanNum(aVar.e());
                }
                this.q.setText(l(R.drawable.icon_gift_bluedrill, StringHelper.formatOverBaiwanNum(aVar.f69544f), 2));
                this.r.setText(aVar.f69545g.f55994a);
                this.n.setText(l(CurrencySwitchUtil.getGiftMoneyIconResId(aVar.f69546h), formatOverBaiwanNum, 1));
                if (CurrencySwitchUtil.isYyIsConvert(aVar.f69546h)) {
                    this.p.setText(R.string.my_ybean);
                    this.o.setText(R.string.get_ybean);
                    return;
                }
                this.p.setText(R.string.my_tdou);
                this.o.setText(R.string.get_tdou);
                return;
            }
            this.f69582g.setVisibility(8);
        }
    }

    public final void s(d.a.s0.y0.c.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, aVar) == null) {
            if (aVar != null && aVar.a() != null && aVar.a().size() > 0) {
                if (aVar.c() != null) {
                    if (aVar.c().f69557b == 1) {
                        this.f69584i.setVisibility(0);
                    } else {
                        this.f69584i.setVisibility(8);
                    }
                }
                this.t.e(aVar.a(), aVar.f69546h);
                return;
            }
            this.f69584i.setVisibility(8);
            this.w.setVisibility(8);
            this.t.e(null, -1);
        }
    }

    public void t(d.a.s0.y0.c.a aVar) {
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
            if (this.f69579d == null) {
                this.f69579d = new h(this.mContext.getContext(), new a(this));
            }
            this.f69579d.j(this.mContext.getResources().getDimensionPixelSize(R.dimen.ds280));
            this.f69579d.attachView(this.f69581f, z);
            this.f69579d.o();
            this.w.setVisibility(8);
            this.f69580e.setVisibility(8);
        }
    }

    public void w() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.f69580e.setVisibility(0);
            this.f69580e.F();
        }
    }
}

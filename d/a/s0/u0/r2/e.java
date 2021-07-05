package d.a.s0.u0.r2;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BarVoteActivityConfig;
import com.baidu.tbadk.core.atomData.BookCoverActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.l;
import d.a.c.k.e.n;
import d.a.c.k.e.w;
import d.a.r0.r.q.b2;
import d.a.r0.r.s.a;
import d.a.s0.h3.j0.a;
import d.a.s0.h3.k;
import d.a.s0.h3.o;
import d.a.s0.h3.p;
import d.a.s0.z3.i;
import java.util.HashSet;
import java.util.List;
/* loaded from: classes9.dex */
public class e extends BaseAdapter implements d.a.s0.u0.j2.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public List<n> f67000e;

    /* renamed from: f  reason: collision with root package name */
    public Context f67001f;

    /* renamed from: g  reason: collision with root package name */
    public TbPageContext f67002g;

    /* renamed from: h  reason: collision with root package name */
    public String f67003h;

    /* renamed from: i  reason: collision with root package name */
    public String f67004i;
    public UserData j;
    public w k;
    public int l;
    public String m;
    public HashSet<String> n;
    public boolean o;
    public d.a.s0.u0.j2.b p;
    public final View.OnClickListener q;
    public View.OnClickListener r;

    /* loaded from: classes9.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f67005e;

        public a(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f67005e = eVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            C1767e c1767e;
            TextView textView;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if ((this.f67005e.f67001f == null || ViewHelper.checkUpIsLogin(this.f67005e.f67001f)) && view != null) {
                    if ((view.getTag() instanceof k) || (view.getTag() instanceof C1767e)) {
                        k kVar = null;
                        if (view.getTag() instanceof k) {
                            kVar = (k) view.getTag();
                        } else if ((view.getTag() instanceof C1767e) && (textView = (c1767e = (C1767e) view.getTag()).f67014c) != null && (textView.getTag() instanceof k)) {
                            kVar = (k) c1767e.f67014c.getTag();
                        }
                        if (kVar != null && kVar.j() == 2) {
                            if (StringUtils.isNull(kVar.i())) {
                                return;
                            }
                            String i2 = kVar.i();
                            if ((i2.contains("nohead:url") || i2.contains("booktown")) && !TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                                l.L(this.f67005e.f67001f, R.string.book_plugin_not_install_tip);
                                return;
                            }
                            UrlManager.getInstance().dealOneLink(this.f67005e.f67002g, new String[]{i2});
                            a.b b2 = d.a.s0.h3.j0.a.b("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "CLICK", kVar.c(), this.f67005e.f67003h, this.f67005e.f67004i, null);
                            b2.e(TiebaStatic.Params.OBJ_URL, kVar.i());
                            b2.f();
                        } else if (kVar == null || kVar.j() != 3) {
                        } else {
                            new StatisticItem("c13442").param("forum_id", this.f67005e.f67003h).eventStat();
                            if (this.f67005e.f67002g == null || TextUtils.isEmpty(this.f67005e.f67003h)) {
                                return;
                            }
                            MessageManager.getInstance().sendMessage(new CustomMessage(2921408, new BarVoteActivityConfig(this.f67005e.f67002g.getPageActivity()).createNormalConfig(d.a.c.e.m.b.f(this.f67005e.f67003h, 0L), 1)));
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f67006e;

        public b(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f67006e = eVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            C1767e c1767e;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                view.setPressed(false);
                if (this.f67006e.k == null || !(view.getTag() instanceof C1767e) || (c1767e = (C1767e) view.getTag()) == null) {
                    return;
                }
                n nVar = (n) ListUtils.getItem(this.f67006e.f67000e, c1767e.f67012a);
                if (nVar instanceof b2) {
                    b2 b2Var = (b2) nVar;
                    this.f67006e.k.b(view, b2Var, BdUniqueId.gen(), null, this.f67006e.o ? c1767e.f67012a + 1 : c1767e.f67012a, 0L);
                    TiebaStatic.log(new StatisticItem("c13124").param("fid", b2Var.Q()).param("tid", b2Var.n1()).param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_locate", c1767e.f67012a + 1));
                } else if (nVar instanceof p) {
                    this.f67006e.k.b(view, (p) nVar, BdUniqueId.gen(), null, c1767e.f67012a, 0L);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ f f67007e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f67008f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f67009g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ e f67010h;

        public c(e eVar, f fVar, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, fVar, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f67010h = eVar;
            this.f67007e = fVar;
            this.f67008f = str;
            this.f67009g = str2;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f67007e.f67014c.getLayout().getEllipsisCount(this.f67007e.f67014c.getLineCount() - 1) <= 0) {
                return;
            }
            this.f67010h.x(this.f67008f, this.f67009g);
        }
    }

    /* loaded from: classes9.dex */
    public class d implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.r0.r.s.a f67011e;

        public d(e eVar, d.a.r0.r.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f67011e = aVar;
        }

        @Override // d.a.r0.r.s.a.e
        public void onClick(d.a.r0.r.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                this.f67011e.dismiss();
            }
        }
    }

    /* renamed from: d.a.s0.u0.r2.e$e  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C1767e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f67012a;

        /* renamed from: b  reason: collision with root package name */
        public View f67013b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f67014c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f67015d;

        public C1767e(e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class f extends C1767e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public TextView f67016e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(e eVar) {
            super(eVar);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((e) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class g extends C1767e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public TbImageView f67017e;

        /* renamed from: f  reason: collision with root package name */
        public TextView f67018f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(e eVar) {
            super(eVar);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((e) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }
    }

    public e(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f67003h = "";
        this.f67004i = "";
        this.l = SkinManager.getColor(R.color.CAM_X0302);
        this.m = "";
        this.n = new HashSet<>();
        this.p = new d.a.s0.u0.j2.b();
        this.q = new a(this);
        this.r = new b(this);
        this.f67001f = context;
        this.f67002g = p();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? ListUtils.getCount(this.f67000e) : invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2)) == null) ? ListUtils.getItem(this.f67000e, i2) : invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2)) == null) {
            return 0L;
        }
        return invokeI.longValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i2)) == null) {
            return 2;
        }
        return invokeI.intValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        f fVar;
        g gVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048580, this, i2, view, viewGroup)) == null) {
            if (getItemViewType(i2) == 1) {
                if (view != null && (view.getTag() instanceof g)) {
                    gVar = (g) view.getTag();
                } else {
                    gVar = new g(this);
                    view = LayoutInflater.from(this.f67001f).inflate(R.layout.frs_header_top_item_single, (ViewGroup) null, false);
                    gVar.f67013b = view;
                    gVar.f67017e = (TbImageView) view.findViewById(R.id.frs_header_top_item_image);
                    gVar.f67014c = (TextView) view.findViewById(R.id.frs_header_top_item_title);
                    gVar.f67015d = (TextView) view.findViewById(R.id.top_item_type);
                    gVar.f67018f = (TextView) view.findViewById(R.id.top_item_rank);
                    view.setTag(gVar);
                }
                m(gVar, (n) ListUtils.getItem(this.f67000e, i2));
            } else if (getItemViewType(i2) == 2) {
                if (view != null && (view.getTag() instanceof f)) {
                    fVar = (f) view.getTag();
                } else {
                    fVar = new f(this);
                    view = LayoutInflater.from(this.f67001f).inflate(R.layout.frs_header_top_item_double, (ViewGroup) null, false);
                    fVar.f67013b = view;
                    fVar.f67015d = (TextView) view.findViewById(R.id.top_item_type);
                    fVar.f67014c = (TextView) view.findViewById(R.id.top_item_title);
                    fVar.f67016e = (TextView) view.findViewById(R.id.top_item_rank);
                    view.setTag(fVar);
                }
                n nVar = (n) ListUtils.getItem(this.f67000e, i2);
                if (nVar instanceof b2) {
                    i(fVar, (b2) nVar, i2);
                    fVar.f67012a = i2;
                } else if (nVar instanceof k) {
                    k(fVar, (k) nVar);
                } else if (nVar instanceof o) {
                    y((o) nVar, fVar, i2);
                } else if (nVar instanceof p) {
                    fVar.f67012a = i2;
                    l(fVar, (p) nVar, i2);
                }
            }
            return view;
        }
        return (View) invokeILL.objValue;
    }

    public final void h(C1767e c1767e) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, c1767e) == null) || c1767e == null) {
            return;
        }
        SkinManager.setViewTextColor(c1767e.f67014c, R.color.CAM_X0105);
        SkinManager.setViewTextColor(c1767e.f67015d, R.color.CAM_X0101);
    }

    public final void i(f fVar, b2 b2Var, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(1048582, this, fVar, b2Var, i2) == null) || fVar == null || b2Var == null) {
            return;
        }
        fVar.f67015d.setText(TbadkCoreApplication.getInst().getString(R.string.top));
        TBSelector.makeDrawableSelector().setShape(0).cornerRadius(l.g(this.f67001f, R.dimen.tbds10)).defaultColorValueNotAutoChangeSkinType(this.l).into(fVar.f67015d);
        b2Var.L2();
        SpannableStringBuilder b1 = b2Var.b1();
        if ((b1 == null || d.a.c.e.p.k.isEmptyStringAfterTrim(b1.toString())) && b2Var.j() != null) {
            b1 = new SpannableStringBuilder(b2Var.j());
        }
        fVar.f67014c.setOnTouchListener(new i(b1));
        fVar.f67014c.setText(b1);
        fVar.f67013b.setOnClickListener(this.r);
        h(fVar);
    }

    @Override // d.a.s0.u0.j2.d
    public d.a.s0.u0.j2.b j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.p : (d.a.s0.u0.j2.b) invokeV.objValue;
    }

    public final void k(f fVar, k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, fVar, kVar) == null) {
            String o = o(kVar);
            fVar.f67014c.setText(kVar.e());
            fVar.f67015d.setText(o);
            TBSelector.makeDrawableSelector().setShape(0).cornerRadius(l.g(this.f67001f, R.dimen.tbds10)).defaultColorValueNotAutoChangeSkinType(this.l).into(fVar.f67015d);
            if (kVar.d() != 0) {
                fVar.f67016e.setVisibility(0);
                if (kVar.d() == -1) {
                    fVar.f67016e.setText(this.f67001f.getString(R.string.no_rank));
                } else if (kVar.d() > 999) {
                    fVar.f67016e.setText(this.f67001f.getString(R.string.rang_orer_thousand));
                } else {
                    TextView textView = fVar.f67016e;
                    textView.setText(this.f67001f.getString(R.string.rang_identify) + kVar.d());
                }
                if (!StringUtils.isNull(kVar.e())) {
                    fVar.f67014c.setText(kVar.e());
                }
            } else {
                fVar.f67016e.setVisibility(8);
            }
            h(fVar);
            fVar.f67014c.setTag(kVar);
            View.OnClickListener onClickListener = this.q;
            if (onClickListener != null) {
                fVar.f67013b.setOnClickListener(onClickListener);
            }
            HashSet<String> hashSet = this.n;
            if (hashSet == null || !hashSet.add(kVar.c())) {
                return;
            }
            a.b b2 = d.a.s0.h3.j0.a.b("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "VIEW_TRUE", kVar.c(), this.f67003h, this.f67004i, null);
            b2.e(TiebaStatic.Params.OBJ_URL, kVar.i());
            b2.f();
        }
    }

    public final void l(f fVar, p pVar, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLI(1048585, this, fVar, pVar, i2) == null) || fVar == null || pVar == null || pVar.b() == null || this.j == null) {
            return;
        }
        fVar.f67015d.setText(TbadkCoreApplication.getInst().getString(R.string.frs_top_forum_rules));
        TBSelector.makeDrawableSelector().setShape(0).cornerRadius(l.g(this.f67001f, R.dimen.tbds10)).defaultColorValueNotAutoChangeSkinType(this.l).into(fVar.f67015d);
        if (this.j.getIs_manager() == 1) {
            if (pVar.b().audit_status.intValue() == 0 && pVar.b().has_forum_rule.intValue() == 0) {
                fVar.f67014c.setText(TbadkCoreApplication.getInst().getString(R.string.frs_top_forum_rules_none));
            } else if (pVar.b().audit_status.intValue() == 0) {
                fVar.f67014c.setText(pVar.b().title);
            } else if (pVar.b().audit_status.intValue() == 1) {
                fVar.f67014c.setText(TbadkCoreApplication.getInst().getString(R.string.frs_top_forum_rules_chenking));
            } else if (pVar.b().audit_status.intValue() == 2) {
                fVar.f67014c.setText(TbadkCoreApplication.getInst().getString(R.string.frs_top_forum_rules_refuse));
            }
        } else {
            fVar.f67014c.setText(pVar.b().title);
        }
        fVar.f67013b.setOnClickListener(this.r);
        h(fVar);
    }

    public final void m(g gVar, n nVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048586, this, gVar, nVar) == null) || gVar == null || nVar == null) {
            return;
        }
        if (nVar instanceof b2) {
            b2 b2Var = (b2) nVar;
            b2Var.L2();
            SpannableStringBuilder b1 = b2Var.b1();
            if ((b1 == null || d.a.c.e.p.k.isEmptyStringAfterTrim(b1.toString())) && b2Var.j() != null) {
                b1 = new SpannableStringBuilder(b2Var.j());
            }
            gVar.f67015d.setText(TbadkCoreApplication.getInst().getString(R.string.top));
            gVar.f67014c.setOnTouchListener(new i(b1));
            gVar.f67014c.setText(b1);
            if (StringUtils.isNull(this.m)) {
                gVar.f67017e.setVisibility(8);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) gVar.f67015d.getLayoutParams();
                layoutParams.setMargins((int) this.f67001f.getResources().getDimension(R.dimen.tbds56), layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin);
            } else {
                gVar.f67017e.setVisibility(0);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) gVar.f67015d.getLayoutParams();
                layoutParams2.setMargins((int) this.f67001f.getResources().getDimension(R.dimen.tbds26), layoutParams2.topMargin, layoutParams2.rightMargin, layoutParams2.bottomMargin);
                gVar.f67017e.M(this.m, 10, false);
            }
            gVar.f67015d.setTextColor(this.l);
            gVar.f67013b.setOnClickListener(this.r);
            h(gVar);
        } else if (nVar instanceof k) {
            k kVar = (k) nVar;
            String o = o(kVar);
            if (StringUtils.isNull(this.m)) {
                gVar.f67015d.setText(o);
                gVar.f67015d.setVisibility(0);
                gVar.f67014c.setText(kVar.e());
                gVar.f67017e.setVisibility(8);
            } else {
                gVar.f67015d.setVisibility(8);
                gVar.f67017e.setVisibility(0);
                TextView textView = gVar.f67014c;
                textView.setText(o + "：" + kVar.e());
                gVar.f67017e.M(this.m, 10, false);
            }
            if (kVar.d() != 0) {
                gVar.f67018f.setVisibility(0);
                if (kVar.d() == -1) {
                    gVar.f67018f.setText(this.f67001f.getString(R.string.no_rank));
                } else if (kVar.d() > 999) {
                    gVar.f67018f.setText(this.f67001f.getString(R.string.rang_orer_thousand));
                } else {
                    TextView textView2 = gVar.f67018f;
                    textView2.setText(this.f67001f.getString(R.string.rang_identify) + kVar.d());
                }
                if (!StringUtils.isNull(kVar.e())) {
                    gVar.f67014c.setText(kVar.e());
                }
            } else {
                gVar.f67018f.setVisibility(8);
            }
            gVar.f67015d.setTextColor(this.l);
            h(gVar);
            gVar.f67014c.setTag(kVar);
            View.OnClickListener onClickListener = this.q;
            if (onClickListener != null) {
                gVar.f67013b.setOnClickListener(onClickListener);
            }
            HashSet<String> hashSet = this.n;
            if (hashSet == null || !hashSet.add(kVar.c())) {
                return;
            }
            a.b b2 = d.a.s0.h3.j0.a.b("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "VIEW_TRUE", kVar.c(), this.f67003h, this.f67004i, null);
            b2.e(TiebaStatic.Params.OBJ_URL, kVar.i());
            b2.f();
        }
    }

    public List<n> n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f67000e : (List) invokeV.objValue;
    }

    public final String o(k kVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, kVar)) == null) {
            if (!TextUtils.isEmpty(kVar.h()) && kVar.h().trim().length() != 0) {
                return kVar.h();
            }
            if (kVar.b() == 1) {
                return TbadkCoreApplication.getInst().getString(R.string.thread_recruit);
            }
            return TbadkCoreApplication.getInst().getString(R.string.top_announcement);
        }
        return (String) invokeL.objValue;
    }

    public TbPageContext p() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            Context context = this.f67001f;
            if (context instanceof BaseFragmentActivity) {
                return ((BaseFragmentActivity) context).getPageContext();
            }
            return null;
        }
        return (TbPageContext) invokeV.objValue;
    }

    public void q(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, bdUniqueId) == null) {
        }
    }

    public void r(List<n> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, list) == null) {
            this.f67000e = list;
            notifyDataSetChanged();
        }
    }

    public void s(String str, String str2, UserData userData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048592, this, str, str2, userData) == null) {
            this.f67003h = str;
            this.f67004i = str2;
            this.j = userData;
        }
    }

    public void t(ForumData forumData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, forumData) == null) {
        }
    }

    public void u(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, str) == null) {
            this.m = str;
        }
    }

    public void v(w wVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, wVar) == null) {
            this.k = wVar;
        }
    }

    public void w(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i2) == null) {
            this.l = i2;
        }
    }

    public final void x(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048597, this, str, str2) == null) || d.a.c.e.p.k.isEmpty(str) || d.a.c.e.p.k.isEmpty(str2)) {
            return;
        }
        d.a.r0.r.s.a aVar = new d.a.r0.r.s.a((BaseFragmentActivity) this.f67001f);
        aVar.setTitle(str2);
        aVar.setTitleShowCenter(true);
        aVar.setMessage(str);
        aVar.setPositiveButton(R.string.frs_risk_dialog_button_text, new d(this, aVar));
        aVar.create(p()).show();
    }

    public final boolean y(o oVar, f fVar, int i2) {
        InterceptResult invokeLLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLI = interceptable.invokeLLI(1048598, this, oVar, fVar, i2)) == null) {
            if (i2 != 0 || oVar == null || oVar.b() == null) {
                return false;
            }
            ForumData b2 = oVar.b();
            boolean z = oVar.c() && !ListUtils.isEmpty(b2.getTipInfos());
            String riskTipNotice = z ? b2.getTipInfos().get(0).tip_notice : b2.getRiskTipNotice();
            String riskTipPopTitle = z ? b2.getTipInfos().get(0).tip_pop_title : b2.getRiskTipPopTitle();
            String riskTipPop = z ? b2.getTipInfos().get(0).tip_pop : b2.getRiskTipPop();
            if (StringUtils.isNull(riskTipNotice)) {
                return false;
            }
            fVar.f67015d.setText(TbadkCoreApplication.getInst().getString(R.string.risk_notice_title));
            TBSelector.makeDrawableSelector().setShape(0).cornerRadius(l.g(this.f67001f, R.dimen.tbds10)).defaultColorValueNotAutoChangeSkinType(this.l).into(fVar.f67015d);
            fVar.f67014c.setText(riskTipNotice);
            fVar.f67014c.setOnClickListener(new c(this, fVar, riskTipPop, riskTipPopTitle));
            h(fVar);
            return true;
        }
        return invokeLLI.booleanValue;
    }
}

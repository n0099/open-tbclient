package d.a.s0.v.e.d;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.j;
import d.a.c.e.p.k;
import d.a.c.e.p.l;
import d.a.r0.r.q.b2;
import d.a.r0.z0.j0;
/* loaded from: classes9.dex */
public class b implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f67938e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext<?> f67939f;

    /* renamed from: g  reason: collision with root package name */
    public C1813b f67940g;

    /* renamed from: h  reason: collision with root package name */
    public View f67941h;

    /* renamed from: i  reason: collision with root package name */
    public b2 f67942i;
    public d.a.s0.v.c j;
    public View.OnClickListener k;

    /* loaded from: classes9.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f67943e;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f67943e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f67943e.f67942i == null || this.f67943e.f67942i.H() == null || StringUtils.isNull(this.f67943e.f67942i.H().getUserId())) {
                return;
            }
            long f2 = d.a.c.e.m.b.f(this.f67943e.f67942i.H().getUserId(), 0L);
            boolean z = f2 == d.a.c.e.m.b.f(TbadkCoreApplication.getCurrentAccount(), 0L);
            d.a.s0.v.b.b().c();
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.f67943e.f67939f.getPageActivity()).createNormalConfig(f2, z, this.f67943e.f67942i.H().isBigV())));
        }
    }

    /* renamed from: d.a.s0.v.e.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C1813b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public View f67944a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f67945b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f67946c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f67947d;

        /* renamed from: e  reason: collision with root package name */
        public RelativeLayout f67948e;

        /* renamed from: f  reason: collision with root package name */
        public ClickableHeaderImageView f67949f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f67950g;

        /* renamed from: h  reason: collision with root package name */
        public TbImageView f67951h;

        /* renamed from: i  reason: collision with root package name */
        public RelativeLayout f67952i;
        public TextView j;
        public LinearLayout k;
        public View l;
        public TextView m;
        public LinearLayout.LayoutParams n;
        public LinearLayout.LayoutParams o;

        public C1813b(View view) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f67944a = view;
            this.f67945b = (TbImageView) view.findViewById(R.id.imgSquareView);
            this.f67946c = (TextView) view.findViewById(R.id.tvLiveFrom);
            this.f67947d = (TextView) view.findViewById(R.id.tvLiveCount);
            this.f67948e = (RelativeLayout) view.findViewById(R.id.rlSquareLivePanel);
            this.f67949f = (ClickableHeaderImageView) view.findViewById(R.id.imgUserCover);
            this.f67950g = (TextView) view.findViewById(R.id.tvUserName);
            this.f67952i = (RelativeLayout) view.findViewById(R.id.rlSquareUserInfo);
            this.j = (TextView) view.findViewById(R.id.tvSquareTitle);
            this.k = (LinearLayout) view.findViewById(R.id.llSquareTitlePanel);
            this.f67951h = (TbImageView) view.findViewById(R.id.imgUserGameLabel);
            this.l = view.findViewById(R.id.living_logo);
            TextView textView = (TextView) view.findViewById(R.id.tvAlaLivingLogView);
            this.m = textView;
            textView.setTextSize(0, view.getContext().getResources().getDimension(R.dimen.fontsize20));
            this.n = (LinearLayout.LayoutParams) this.j.getLayoutParams();
            this.o = (LinearLayout.LayoutParams) this.k.getLayoutParams();
            this.f67951h.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.f67945b.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f67948e.getLayoutParams();
            layoutParams.width = (l.k(view.getContext()) - view.getContext().getResources().getDimensionPixelSize(R.dimen.ds16)) / 2;
            this.o.leftMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds20);
            this.o.rightMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds20);
            this.n.bottomMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds40);
            this.n.topMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds16);
            this.j.setTextSize(0, view.getContext().getResources().getDimension(R.dimen.fontsize24));
            layoutParams.height = layoutParams.width;
            this.f67952i.setVisibility(8);
            this.k.setLayoutParams(this.o);
            this.j.setLayoutParams(this.n);
            this.f67948e.setLayoutParams(layoutParams);
        }
    }

    public b(TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f67938e = 3;
        this.k = new a(this);
        this.f67939f = tbPageContext;
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.ala_game_frs_game_live_view, (ViewGroup) null, false);
        this.f67941h = inflate;
        this.f67940g = new C1813b(inflate);
        c().setOnClickListener(this);
        this.f67939f.getPageActivity().getResources().getString(R.string.ala_live_entry_name_yanzhi);
    }

    public View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f67941h : (View) invokeV.objValue;
    }

    public void d(b2 b2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, b2Var) == null) {
            if (b2Var == null) {
                c().setVisibility(4);
                return;
            }
            c().setVisibility(0);
            this.f67942i = b2Var;
            this.f67940g.f67945b.setDrawerType(0);
            this.f67940g.f67945b.setBorderSurroundContent(true);
            this.f67940g.f67945b.setDrawBorder(true);
            this.f67940g.f67945b.M(this.f67942i.g1().cover, 10, false);
            this.f67940g.f67947d.setText(this.f67939f.getPageActivity().getResources().getString(R.string.ala_list_audience_label, StringHelper.numberUniformFormatExtra(this.f67942i.g1().audience_count)));
            this.f67940g.f67949f.setData(this.f67942i);
            this.f67940g.f67949f.setIsRound(true);
            this.f67940g.f67949f.setBorderSurroundContent(true);
            this.f67940g.j.setText(this.f67942i.getTitle());
            if (this.f67942i.H() != null) {
                String name_show = this.f67942i.H().getName_show();
                if (j0.d(name_show) > 10) {
                    name_show = j0.m(name_show, 10) + StringHelper.STRING_MORE;
                }
                this.f67940g.f67950g.setText(name_show);
            }
            this.f67940g.l.setVisibility(0);
            this.f67940g.f67946c.setBackgroundResource(R.drawable.transparent_bg);
            this.f67940g.f67946c.setText(this.f67942i.g1().label_name);
            this.f67940g.f67946c.setVisibility(0);
            if (this.f67942i.H() != null && this.f67942i.H().getAlaUserData() != null && !k.isEmpty(this.f67942i.H().getAlaUserData().great_anchor_icon)) {
                this.f67940g.f67951h.setVisibility(0);
                this.f67940g.f67951h.M(this.f67942i.H().getAlaUserData().great_anchor_icon, 10, false);
            } else {
                this.f67940g.f67951h.setVisibility(8);
            }
            this.f67940g.f67950g.setOnClickListener(this.k);
            e(this.f67939f, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void e(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i2) == null) || this.f67938e == i2) {
            return;
        }
        SkinManager.setBackgroundResource(this.f67940g.f67948e, R.drawable.addresslist_item_bg);
        SkinManager.setViewTextColor(this.f67940g.f67946c, R.color.CAM_X0111);
        SkinManager.setViewTextColor(this.f67940g.f67947d, R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.f67940g.f67950g, R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.f67940g.j, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f67940g.m, R.color.CAM_X0101);
        this.f67938e = i2;
    }

    public void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
        }
    }

    public void g(d.a.s0.v.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, cVar) == null) {
            this.j = cVar;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, view) == null) {
            if (!j.z()) {
                l.J(this.f67939f.getPageActivity(), this.f67939f.getPageActivity().getString(R.string.no_network_guide));
                return;
            }
            b2 b2Var = this.f67942i;
            if (b2Var == null || b2Var.g1() == null) {
                return;
            }
            d.a.s0.v.c cVar = this.j;
            if (cVar != null) {
                cVar.a(this.f67942i);
            }
            d.a.s0.v.b.b().c();
            TiebaStatic.log(new StatisticItem("c12116").param("obj_id", this.f67942i.g1().live_id));
        }
    }
}

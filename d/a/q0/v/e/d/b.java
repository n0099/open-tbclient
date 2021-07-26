package d.a.q0.v.e.d;

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
import d.a.d.e.p.j;
import d.a.d.e.p.k;
import d.a.d.e.p.l;
import d.a.p0.b1.j0;
import d.a.p0.s.q.b2;
/* loaded from: classes8.dex */
public class b implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f65365e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext<?> f65366f;

    /* renamed from: g  reason: collision with root package name */
    public C1774b f65367g;

    /* renamed from: h  reason: collision with root package name */
    public View f65368h;

    /* renamed from: i  reason: collision with root package name */
    public b2 f65369i;
    public d.a.q0.v.c j;
    public View.OnClickListener k;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f65370e;

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
            this.f65370e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f65370e.f65369i == null || this.f65370e.f65369i.H() == null || StringUtils.isNull(this.f65370e.f65369i.H().getUserId())) {
                return;
            }
            long f2 = d.a.d.e.m.b.f(this.f65370e.f65369i.H().getUserId(), 0L);
            boolean z = f2 == d.a.d.e.m.b.f(TbadkCoreApplication.getCurrentAccount(), 0L);
            d.a.q0.v.b.b().c();
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.f65370e.f65366f.getPageActivity()).createNormalConfig(f2, z, this.f65370e.f65369i.H().isBigV())));
        }
    }

    /* renamed from: d.a.q0.v.e.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C1774b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public View f65371a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f65372b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f65373c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f65374d;

        /* renamed from: e  reason: collision with root package name */
        public RelativeLayout f65375e;

        /* renamed from: f  reason: collision with root package name */
        public ClickableHeaderImageView f65376f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f65377g;

        /* renamed from: h  reason: collision with root package name */
        public TbImageView f65378h;

        /* renamed from: i  reason: collision with root package name */
        public RelativeLayout f65379i;
        public TextView j;
        public LinearLayout k;
        public View l;
        public TextView m;
        public LinearLayout.LayoutParams n;
        public LinearLayout.LayoutParams o;

        public C1774b(View view) {
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
            this.f65371a = view;
            this.f65372b = (TbImageView) view.findViewById(R.id.imgSquareView);
            this.f65373c = (TextView) view.findViewById(R.id.tvLiveFrom);
            this.f65374d = (TextView) view.findViewById(R.id.tvLiveCount);
            this.f65375e = (RelativeLayout) view.findViewById(R.id.rlSquareLivePanel);
            this.f65376f = (ClickableHeaderImageView) view.findViewById(R.id.imgUserCover);
            this.f65377g = (TextView) view.findViewById(R.id.tvUserName);
            this.f65379i = (RelativeLayout) view.findViewById(R.id.rlSquareUserInfo);
            this.j = (TextView) view.findViewById(R.id.tvSquareTitle);
            this.k = (LinearLayout) view.findViewById(R.id.llSquareTitlePanel);
            this.f65378h = (TbImageView) view.findViewById(R.id.imgUserGameLabel);
            this.l = view.findViewById(R.id.living_logo);
            TextView textView = (TextView) view.findViewById(R.id.tvAlaLivingLogView);
            this.m = textView;
            textView.setTextSize(0, view.getContext().getResources().getDimension(R.dimen.fontsize20));
            this.n = (LinearLayout.LayoutParams) this.j.getLayoutParams();
            this.o = (LinearLayout.LayoutParams) this.k.getLayoutParams();
            this.f65378h.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.f65372b.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f65375e.getLayoutParams();
            layoutParams.width = (l.k(view.getContext()) - view.getContext().getResources().getDimensionPixelSize(R.dimen.ds16)) / 2;
            this.o.leftMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds20);
            this.o.rightMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds20);
            this.n.bottomMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds40);
            this.n.topMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds16);
            this.j.setTextSize(0, view.getContext().getResources().getDimension(R.dimen.fontsize24));
            layoutParams.height = layoutParams.width;
            this.f65379i.setVisibility(8);
            this.k.setLayoutParams(this.o);
            this.j.setLayoutParams(this.n);
            this.f65375e.setLayoutParams(layoutParams);
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
        this.f65365e = 3;
        this.k = new a(this);
        this.f65366f = tbPageContext;
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.ala_game_frs_game_live_view, (ViewGroup) null, false);
        this.f65368h = inflate;
        this.f65367g = new C1774b(inflate);
        c().setOnClickListener(this);
        this.f65366f.getPageActivity().getResources().getString(R.string.ala_live_entry_name_yanzhi);
    }

    public View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f65368h : (View) invokeV.objValue;
    }

    public void d(b2 b2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, b2Var) == null) {
            if (b2Var == null) {
                c().setVisibility(4);
                return;
            }
            c().setVisibility(0);
            this.f65369i = b2Var;
            this.f65367g.f65372b.setDrawerType(0);
            this.f65367g.f65372b.setBorderSurroundContent(true);
            this.f65367g.f65372b.setDrawBorder(true);
            this.f65367g.f65372b.M(this.f65369i.h1().cover, 10, false);
            this.f65367g.f65374d.setText(this.f65366f.getPageActivity().getResources().getString(R.string.ala_list_audience_label, StringHelper.numberUniformFormatExtra(this.f65369i.h1().audience_count)));
            this.f65367g.f65376f.setData(this.f65369i);
            this.f65367g.f65376f.setIsRound(true);
            this.f65367g.f65376f.setBorderSurroundContent(true);
            this.f65367g.j.setText(this.f65369i.getTitle());
            if (this.f65369i.H() != null) {
                String name_show = this.f65369i.H().getName_show();
                if (j0.d(name_show) > 10) {
                    name_show = j0.m(name_show, 10) + StringHelper.STRING_MORE;
                }
                this.f65367g.f65377g.setText(name_show);
            }
            this.f65367g.l.setVisibility(0);
            this.f65367g.f65373c.setBackgroundResource(R.drawable.transparent_bg);
            this.f65367g.f65373c.setText(this.f65369i.h1().label_name);
            this.f65367g.f65373c.setVisibility(0);
            if (this.f65369i.H() != null && this.f65369i.H().getAlaUserData() != null && !k.isEmpty(this.f65369i.H().getAlaUserData().great_anchor_icon)) {
                this.f65367g.f65378h.setVisibility(0);
                this.f65367g.f65378h.M(this.f65369i.H().getAlaUserData().great_anchor_icon, 10, false);
            } else {
                this.f65367g.f65378h.setVisibility(8);
            }
            this.f65367g.f65377g.setOnClickListener(this.k);
            e(this.f65366f, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void e(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i2) == null) || this.f65365e == i2) {
            return;
        }
        SkinManager.setBackgroundResource(this.f65367g.f65375e, R.drawable.addresslist_item_bg);
        SkinManager.setViewTextColor(this.f65367g.f65373c, R.color.CAM_X0111);
        SkinManager.setViewTextColor(this.f65367g.f65374d, R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.f65367g.f65377g, R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.f65367g.j, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f65367g.m, R.color.CAM_X0101);
        this.f65365e = i2;
    }

    public void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
        }
    }

    public void g(d.a.q0.v.c cVar) {
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
                l.J(this.f65366f.getPageActivity(), this.f65366f.getPageActivity().getString(R.string.no_network_guide));
                return;
            }
            b2 b2Var = this.f65369i;
            if (b2Var == null || b2Var.h1() == null) {
                return;
            }
            d.a.q0.v.c cVar = this.j;
            if (cVar != null) {
                cVar.a(this.f65369i);
            }
            d.a.q0.v.b.b().c();
            TiebaStatic.log(new StatisticItem("c12116").param("obj_id", this.f65369i.h1().live_id));
        }
    }
}

package d.a.p0.v.e.d;

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
import d.a.o0.r.q.b2;
import d.a.o0.z0.j0;
/* loaded from: classes8.dex */
public class a implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public int f64705e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext<?> f64706f;

    /* renamed from: g  reason: collision with root package name */
    public b f64707g;

    /* renamed from: h  reason: collision with root package name */
    public View f64708h;

    /* renamed from: i  reason: collision with root package name */
    public b2 f64709i;
    public d.a.p0.v.c j;
    public View.OnClickListener k;

    /* renamed from: d.a.p0.v.e.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class View$OnClickListenerC1770a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f64710e;

        public View$OnClickListenerC1770a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f64710e = aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f64710e.f64709i == null || this.f64710e.f64709i.H() == null || StringUtils.isNull(this.f64710e.f64709i.H().getUserId())) {
                return;
            }
            long f2 = d.a.c.e.m.b.f(this.f64710e.f64709i.H().getUserId(), 0L);
            boolean z = f2 == d.a.c.e.m.b.f(TbadkCoreApplication.getCurrentAccount(), 0L);
            d.a.p0.v.b.b().c();
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.f64710e.f64706f.getPageActivity()).createNormalConfig(f2, z, this.f64710e.f64709i.H().isBigV())));
        }
    }

    /* loaded from: classes8.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public View f64711a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f64712b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f64713c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f64714d;

        /* renamed from: e  reason: collision with root package name */
        public RelativeLayout f64715e;

        /* renamed from: f  reason: collision with root package name */
        public ClickableHeaderImageView f64716f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f64717g;

        /* renamed from: h  reason: collision with root package name */
        public TbImageView f64718h;

        /* renamed from: i  reason: collision with root package name */
        public RelativeLayout f64719i;
        public TextView j;
        public LinearLayout k;
        public View l;
        public TextView m;
        public LinearLayout.LayoutParams n;
        public LinearLayout.LayoutParams o;

        public b(View view) {
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
            this.f64711a = view;
            this.f64712b = (TbImageView) view.findViewById(R.id.imgSquareView);
            this.f64713c = (TextView) view.findViewById(R.id.tvLiveFrom);
            this.f64714d = (TextView) view.findViewById(R.id.tvLiveCount);
            this.f64715e = (RelativeLayout) view.findViewById(R.id.rlSquareLivePanel);
            this.f64716f = (ClickableHeaderImageView) view.findViewById(R.id.imgUserCover);
            this.f64717g = (TextView) view.findViewById(R.id.tvUserName);
            this.f64719i = (RelativeLayout) view.findViewById(R.id.rlSquareUserInfo);
            this.j = (TextView) view.findViewById(R.id.tvSquareTitle);
            this.k = (LinearLayout) view.findViewById(R.id.llSquareTitlePanel);
            this.f64718h = (TbImageView) view.findViewById(R.id.imgUserGameLabel);
            this.l = view.findViewById(R.id.living_logo);
            TextView textView = (TextView) view.findViewById(R.id.tvAlaLivingLogView);
            this.m = textView;
            textView.setTextSize(0, view.getContext().getResources().getDimension(R.dimen.fontsize20));
            this.n = (LinearLayout.LayoutParams) this.j.getLayoutParams();
            this.o = (LinearLayout.LayoutParams) this.k.getLayoutParams();
            this.f64718h.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.f64712b.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f64715e.getLayoutParams();
            layoutParams.width = (l.k(view.getContext()) - view.getContext().getResources().getDimensionPixelSize(R.dimen.ds16)) / 2;
            this.o.leftMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds40);
            this.o.rightMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds40);
            this.n.bottomMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds40);
            this.n.topMargin = (int) view.getContext().getResources().getDimension(R.dimen.ds16);
            this.j.setTextSize(0, view.getContext().getResources().getDimension(R.dimen.fontsize32));
            layoutParams.height = (layoutParams.width * 9) / 16;
            this.f64719i.setVisibility(0);
            this.k.setLayoutParams(this.o);
            this.j.setLayoutParams(this.n);
            this.f64715e.setLayoutParams(layoutParams);
        }
    }

    public a(TbPageContext<?> tbPageContext) {
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
        this.f64705e = 3;
        this.k = new View$OnClickListenerC1770a(this);
        this.f64706f = tbPageContext;
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.ala_game_frs_game_live_view, (ViewGroup) null, false);
        this.f64708h = inflate;
        this.f64707g = new b(inflate);
        c().setOnClickListener(this);
        this.f64706f.getPageActivity().getResources().getString(R.string.ala_live_entry_name_yanzhi);
    }

    public View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f64708h : (View) invokeV.objValue;
    }

    public void d(b2 b2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, b2Var) == null) {
            if (b2Var == null) {
                c().setVisibility(4);
                return;
            }
            c().setVisibility(0);
            this.f64709i = b2Var;
            this.f64707g.f64712b.setDrawerType(0);
            this.f64707g.f64712b.setBorderSurroundContent(true);
            this.f64707g.f64712b.setDrawBorder(true);
            this.f64707g.f64712b.M(this.f64709i.g1().cover, 10, false);
            this.f64707g.f64714d.setText(this.f64706f.getPageActivity().getResources().getString(R.string.ala_list_audience_label, StringHelper.numberUniformFormatExtra(this.f64709i.g1().audience_count)));
            this.f64707g.f64716f.setData(this.f64709i);
            this.f64707g.f64716f.setIsRound(true);
            this.f64707g.f64716f.setBorderSurroundContent(true);
            this.f64707g.j.setText(this.f64709i.getTitle());
            if (this.f64709i.H() != null) {
                String name_show = this.f64709i.H().getName_show();
                if (j0.d(name_show) > 10) {
                    name_show = j0.m(name_show, 10) + StringHelper.STRING_MORE;
                }
                this.f64707g.f64717g.setText(name_show);
            }
            this.f64707g.l.setVisibility(0);
            this.f64707g.f64713c.setBackgroundResource(R.drawable.transparent_bg);
            this.f64707g.f64713c.setText(this.f64709i.g1().label_name);
            this.f64707g.f64713c.setVisibility(0);
            if (this.f64709i.H() != null && this.f64709i.H().getAlaUserData() != null && !k.isEmpty(this.f64709i.H().getAlaUserData().great_anchor_icon)) {
                this.f64707g.f64718h.setVisibility(0);
                this.f64707g.f64718h.M(this.f64709i.H().getAlaUserData().great_anchor_icon, 10, false);
            } else {
                this.f64707g.f64718h.setVisibility(8);
            }
            this.f64707g.f64717g.setOnClickListener(this.k);
            e(this.f64706f, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void e(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i2) == null) || this.f64705e == i2) {
            return;
        }
        SkinManager.setBackgroundResource(this.f64707g.f64715e, R.drawable.addresslist_item_bg);
        SkinManager.setViewTextColor(this.f64707g.f64713c, R.color.CAM_X0111);
        SkinManager.setViewTextColor(this.f64707g.f64714d, R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.f64707g.f64717g, R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.f64707g.j, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f64707g.m, R.color.CAM_X0101);
        this.f64705e = i2;
    }

    public void f(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
        }
    }

    public void g(d.a.p0.v.c cVar) {
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
                l.J(this.f64706f.getPageActivity(), this.f64706f.getPageActivity().getString(R.string.no_network_guide));
                return;
            }
            b2 b2Var = this.f64709i;
            if (b2Var == null || b2Var.g1() == null) {
                return;
            }
            d.a.p0.v.c cVar = this.j;
            if (cVar != null) {
                cVar.a(this.f64709i);
            }
            d.a.p0.v.b.b().c();
            TiebaStatic.log(new StatisticItem("c12116").param("obj_id", this.f64709i.g1().live_id));
        }
    }
}

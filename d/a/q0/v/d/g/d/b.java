package d.a.q0.v.d.g.d;

import android.text.TextUtils;
import android.view.View;
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
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.view.ClickableHeaderImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.e.p.j;
import d.a.d.e.p.l;
import d.a.p0.b1.j0;
import d.a.p0.s.q.b2;
/* loaded from: classes8.dex */
public class b extends d.a.q0.a0.b<d.a.q0.v.d.a.c> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int m;
    public TbPageContext<?> n;
    public c o;
    public f p;
    public b2 q;
    public int r;
    public String s;
    public boolean t;
    public View.OnClickListener u;
    public View.OnClickListener v;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f65252e;

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
            this.f65252e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (j.z()) {
                    if (this.f65252e.q == null || this.f65252e.q.h1() == null || this.f65252e.p == null) {
                        return;
                    }
                    this.f65252e.p.a(this.f65252e.r, this.f65252e.s, this.f65252e.q);
                    return;
                }
                l.J(this.f65252e.n.getPageActivity(), this.f65252e.n.getPageActivity().getString(R.string.no_network_guide));
            }
        }
    }

    /* renamed from: d.a.q0.v.d.g.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class View$OnClickListenerC1770b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f65253e;

        public View$OnClickListenerC1770b(b bVar) {
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
            this.f65253e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f65253e.q == null || this.f65253e.q.H() == null || StringUtils.isNull(this.f65253e.q.H().getUserId())) {
                return;
            }
            long f2 = d.a.d.e.m.b.f(this.f65253e.q.H().getUserId(), 0L);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.f65253e.n.getPageActivity()).createNormalConfig(f2, f2 == d.a.d.e.m.b.f(TbadkCoreApplication.getCurrentAccount(), 0L), this.f65253e.q.H().isBigV())));
        }
    }

    /* loaded from: classes8.dex */
    public class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public View f65254a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f65255b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f65256c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f65257d;

        /* renamed from: e  reason: collision with root package name */
        public RelativeLayout f65258e;

        /* renamed from: f  reason: collision with root package name */
        public ClickableHeaderImageView f65259f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f65260g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f65261h;

        /* renamed from: i  reason: collision with root package name */
        public TextView f65262i;

        public c(b bVar, View view) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, view};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f65254a = view;
            this.f65255b = (TbImageView) view.findViewById(R.id.imgSquareView);
            this.f65256c = (TextView) view.findViewById(R.id.tvLiveFrom);
            this.f65257d = (TextView) view.findViewById(R.id.tvLiveCount);
            this.f65258e = (RelativeLayout) view.findViewById(R.id.rlSquareLivePanel);
            this.f65259f = (ClickableHeaderImageView) view.findViewById(R.id.imgUserCover);
            this.f65260g = (TextView) view.findViewById(R.id.tvUserName);
            this.f65261h = (TextView) view.findViewById(R.id.tvSquareTitle);
            this.f65262i = (TextView) view.findViewById(R.id.tvSquareDistance);
            view.setOnClickListener(bVar.u);
            this.f65255b.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.f65255b.setDrawerType(0);
            this.f65259f.setIsRound(true);
            this.f65259f.setDrawBorder(true);
            this.f65259f.setBorderColor(bVar.n.getPageActivity().getResources().getColor(R.color.white_alpha100));
            this.f65259f.setBorderWidth(bVar.n.getPageActivity().getResources().getDimensionPixelOffset(R.dimen.ds1));
            this.f65259f.setIsGod(false);
            this.f65259f.setIsBigV(false);
            this.f65259f.setShowV(false);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f65258e.getLayoutParams();
            int k = (l.k(view.getContext()) - view.getContext().getResources().getDimensionPixelSize(R.dimen.ds4)) / 2;
            layoutParams.width = k;
            layoutParams.height = (k * 9) / 16;
            this.f65258e.setLayoutParams(layoutParams);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(TbPageContext<?> tbPageContext, boolean z) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((TbPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.m = 3;
        this.t = false;
        this.u = new a(this);
        this.v = new View$OnClickListenerC1770b(this);
        this.n = tbPageContext;
        this.o = new c(this, k());
        this.t = z;
    }

    @Override // d.a.q0.a0.b
    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.ala_sub_list_game_item_view : invokeV.intValue;
    }

    @Override // d.a.q0.a0.b
    public void m(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i2) == null) || this.m == i2) {
            return;
        }
        SkinManager.setBackgroundResource(this.o.f65258e, R.drawable.addresslist_item_bg);
        SkinManager.setViewTextColor(this.o.f65257d, R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.o.f65260g, R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.o.f65261h, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.o.f65262i, R.color.CAM_X0109);
        this.m = i2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.q0.a0.b
    /* renamed from: x */
    public void l(d.a.q0.v.d.a.c cVar) {
        b2 b2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, cVar) == null) {
            if (cVar != null && (b2Var = cVar.f64863h) != null && b2Var.h1() != null) {
                k().setVisibility(0);
                this.q = cVar.f64863h;
                this.r = cVar.f64860e;
                this.s = !TextUtils.isEmpty(cVar.f64862g) ? cVar.f64862g : cVar.f64861f;
                this.o.f65255b.M(this.q.h1().cover, 10, false);
                this.o.f65257d.setText(this.n.getPageActivity().getResources().getString(R.string.square_sub_live_audience_label, StringHelper.numberUniformFormatExtra(this.q.h1().audience_count)));
                this.o.f65259f.setData(this.q, false);
                this.o.f65261h.setText(this.q.getTitle());
                if (this.q.H() != null) {
                    String name_show = this.q.H().getName_show();
                    if (j0.d(name_show) > 10) {
                        name_show = j0.m(name_show, 10) + StringHelper.STRING_MORE;
                    }
                    this.o.f65260g.setText(name_show);
                }
                String str = this.q.h1().label_name;
                if (this.t && !StringUtils.isNull(str)) {
                    this.o.f65256c.setText(str);
                    this.o.f65256c.setVisibility(0);
                } else {
                    this.o.f65256c.setVisibility(8);
                }
                if (cVar.f64864i) {
                    this.o.f65262i.setText(this.n.getPageActivity().getResources().getString(R.string.square_sub_live_audience_distance, StringHelper.numberUniformFormatExtra((long) (this.q.h1().distance / 1000.0d))));
                    this.o.f65262i.setVisibility(0);
                } else {
                    this.o.f65262i.setVisibility(8);
                }
                this.o.f65260g.setOnClickListener(this.v);
                m(this.n, TbadkCoreApplication.getInst().getSkinType());
                return;
            }
            k().setVisibility(4);
        }
    }

    public void y(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, fVar) == null) {
            this.p = fVar;
        }
    }
}

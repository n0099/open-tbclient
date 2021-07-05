package d.a.s0.v.d.g.d;

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
import d.a.c.e.p.j;
import d.a.c.e.p.l;
import d.a.r0.r.q.b2;
import d.a.r0.z0.j0;
/* loaded from: classes9.dex */
public class b extends d.a.s0.a0.b<d.a.s0.v.d.a.c> {
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

    /* loaded from: classes9.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f67825e;

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
            this.f67825e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (j.z()) {
                    if (this.f67825e.q == null || this.f67825e.q.g1() == null || this.f67825e.p == null) {
                        return;
                    }
                    this.f67825e.p.a(this.f67825e.r, this.f67825e.s, this.f67825e.q);
                    return;
                }
                l.J(this.f67825e.n.getPageActivity(), this.f67825e.n.getPageActivity().getString(R.string.no_network_guide));
            }
        }
    }

    /* renamed from: d.a.s0.v.d.g.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class View$OnClickListenerC1809b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f67826e;

        public View$OnClickListenerC1809b(b bVar) {
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
            this.f67826e = bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f67826e.q == null || this.f67826e.q.H() == null || StringUtils.isNull(this.f67826e.q.H().getUserId())) {
                return;
            }
            long f2 = d.a.c.e.m.b.f(this.f67826e.q.H().getUserId(), 0L);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.f67826e.n.getPageActivity()).createNormalConfig(f2, f2 == d.a.c.e.m.b.f(TbadkCoreApplication.getCurrentAccount(), 0L), this.f67826e.q.H().isBigV())));
        }
    }

    /* loaded from: classes9.dex */
    public class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public View f67827a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f67828b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f67829c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f67830d;

        /* renamed from: e  reason: collision with root package name */
        public RelativeLayout f67831e;

        /* renamed from: f  reason: collision with root package name */
        public ClickableHeaderImageView f67832f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f67833g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f67834h;

        /* renamed from: i  reason: collision with root package name */
        public TextView f67835i;

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
            this.f67827a = view;
            this.f67828b = (TbImageView) view.findViewById(R.id.imgSquareView);
            this.f67829c = (TextView) view.findViewById(R.id.tvLiveFrom);
            this.f67830d = (TextView) view.findViewById(R.id.tvLiveCount);
            this.f67831e = (RelativeLayout) view.findViewById(R.id.rlSquareLivePanel);
            this.f67832f = (ClickableHeaderImageView) view.findViewById(R.id.imgUserCover);
            this.f67833g = (TextView) view.findViewById(R.id.tvUserName);
            this.f67834h = (TextView) view.findViewById(R.id.tvSquareTitle);
            this.f67835i = (TextView) view.findViewById(R.id.tvSquareDistance);
            view.setOnClickListener(bVar.u);
            this.f67828b.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.f67828b.setDrawerType(0);
            this.f67832f.setIsRound(true);
            this.f67832f.setDrawBorder(true);
            this.f67832f.setBorderColor(bVar.n.getPageActivity().getResources().getColor(R.color.white_alpha100));
            this.f67832f.setBorderWidth(bVar.n.getPageActivity().getResources().getDimensionPixelOffset(R.dimen.ds1));
            this.f67832f.setIsGod(false);
            this.f67832f.setIsBigV(false);
            this.f67832f.setShowV(false);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f67831e.getLayoutParams();
            int k = (l.k(view.getContext()) - view.getContext().getResources().getDimensionPixelSize(R.dimen.ds4)) / 2;
            layoutParams.width = k;
            layoutParams.height = (k * 9) / 16;
            this.f67831e.setLayoutParams(layoutParams);
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
        this.v = new View$OnClickListenerC1809b(this);
        this.n = tbPageContext;
        this.o = new c(this, l());
        this.t = z;
    }

    @Override // d.a.s0.a0.b
    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.ala_sub_list_game_item_view : invokeV.intValue;
    }

    @Override // d.a.s0.a0.b
    public void n(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i2) == null) || this.m == i2) {
            return;
        }
        SkinManager.setBackgroundResource(this.o.f67831e, R.drawable.addresslist_item_bg);
        SkinManager.setViewTextColor(this.o.f67830d, R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.o.f67833g, R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.o.f67834h, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.o.f67835i, R.color.CAM_X0109);
        this.m = i2;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.s0.a0.b
    /* renamed from: y */
    public void m(d.a.s0.v.d.a.c cVar) {
        b2 b2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, cVar) == null) {
            if (cVar != null && (b2Var = cVar.f67436h) != null && b2Var.g1() != null) {
                l().setVisibility(0);
                this.q = cVar.f67436h;
                this.r = cVar.f67433e;
                this.s = !TextUtils.isEmpty(cVar.f67435g) ? cVar.f67435g : cVar.f67434f;
                this.o.f67828b.M(this.q.g1().cover, 10, false);
                this.o.f67830d.setText(this.n.getPageActivity().getResources().getString(R.string.square_sub_live_audience_label, StringHelper.numberUniformFormatExtra(this.q.g1().audience_count)));
                this.o.f67832f.setData(this.q, false);
                this.o.f67834h.setText(this.q.getTitle());
                if (this.q.H() != null) {
                    String name_show = this.q.H().getName_show();
                    if (j0.d(name_show) > 10) {
                        name_show = j0.m(name_show, 10) + StringHelper.STRING_MORE;
                    }
                    this.o.f67833g.setText(name_show);
                }
                String str = this.q.g1().label_name;
                if (this.t && !StringUtils.isNull(str)) {
                    this.o.f67829c.setText(str);
                    this.o.f67829c.setVisibility(0);
                } else {
                    this.o.f67829c.setVisibility(8);
                }
                if (cVar.f67437i) {
                    this.o.f67835i.setText(this.n.getPageActivity().getResources().getString(R.string.square_sub_live_audience_distance, StringHelper.numberUniformFormatExtra((long) (this.q.g1().distance / 1000.0d))));
                    this.o.f67835i.setVisibility(0);
                } else {
                    this.o.f67835i.setVisibility(8);
                }
                this.o.f67833g.setOnClickListener(this.v);
                n(this.n, TbadkCoreApplication.getInst().getSkinType());
                return;
            }
            l().setVisibility(4);
        }
    }

    public void z(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, fVar) == null) {
            this.p = fVar;
        }
    }
}

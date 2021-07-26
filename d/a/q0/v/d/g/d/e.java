package d.a.q0.v.d.g.d;

import android.text.TextUtils;
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
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f65279a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext<?> f65280b;

    /* renamed from: c  reason: collision with root package name */
    public c f65281c;

    /* renamed from: d  reason: collision with root package name */
    public View f65282d;

    /* renamed from: e  reason: collision with root package name */
    public int f65283e;

    /* renamed from: f  reason: collision with root package name */
    public String f65284f;

    /* renamed from: g  reason: collision with root package name */
    public b2 f65285g;

    /* renamed from: h  reason: collision with root package name */
    public f f65286h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f65287i;
    public View.OnClickListener j;
    public View.OnClickListener k;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f65288e;

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
            this.f65288e = eVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (j.z()) {
                    if (this.f65288e.f65285g == null || this.f65288e.f65285g.h1() == null || this.f65288e.f65286h == null) {
                        return;
                    }
                    this.f65288e.f65286h.a(this.f65288e.f65283e, this.f65288e.f65284f, this.f65288e.f65285g);
                    return;
                }
                l.J(this.f65288e.f65280b.getPageActivity(), this.f65288e.f65280b.getPageActivity().getString(R.string.no_network_guide));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f65289e;

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
            this.f65289e = eVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f65289e.f65285g == null || this.f65289e.f65285g.H() == null || StringUtils.isNull(this.f65289e.f65285g.H().getUserId())) {
                return;
            }
            long f2 = d.a.d.e.m.b.f(this.f65289e.f65285g.H().getUserId(), 0L);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.f65289e.f65280b.getPageActivity()).createNormalConfig(f2, f2 == d.a.d.e.m.b.f(TbadkCoreApplication.getCurrentAccount(), 0L), this.f65289e.f65285g.H().isBigV())));
        }
    }

    /* loaded from: classes8.dex */
    public class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public View f65290a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f65291b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f65292c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f65293d;

        /* renamed from: e  reason: collision with root package name */
        public RelativeLayout f65294e;

        /* renamed from: f  reason: collision with root package name */
        public ClickableHeaderImageView f65295f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f65296g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f65297h;

        /* renamed from: i  reason: collision with root package name */
        public TextView f65298i;

        public c(e eVar, View view) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, view};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f65290a = view;
            this.f65291b = (TbImageView) view.findViewById(R.id.imgSquareView);
            this.f65292c = (TextView) view.findViewById(R.id.tvLiveFrom);
            this.f65293d = (TextView) view.findViewById(R.id.tvLiveCount);
            this.f65294e = (RelativeLayout) view.findViewById(R.id.rlSquareLivePanel);
            this.f65295f = (ClickableHeaderImageView) view.findViewById(R.id.imgUserCover);
            this.f65296g = (TextView) view.findViewById(R.id.tvUserName);
            this.f65297h = (TextView) view.findViewById(R.id.tvSquareTitle);
            this.f65298i = (TextView) view.findViewById(R.id.tvSquareDistance);
            view.setOnClickListener(eVar.j);
            this.f65291b.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.f65291b.setDrawerType(0);
            this.f65295f.setIsRound(true);
            this.f65295f.setDrawBorder(true);
            this.f65295f.setBorderColor(eVar.f65280b.getPageActivity().getResources().getColor(R.color.white_alpha100));
            this.f65295f.setBorderWidth(eVar.f65280b.getPageActivity().getResources().getDimensionPixelOffset(R.dimen.ds1));
            this.f65295f.setIsGod(false);
            this.f65295f.setIsBigV(false);
            this.f65295f.setShowV(false);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f65294e.getLayoutParams();
            int k = (l.k(view.getContext()) - view.getContext().getResources().getDimensionPixelSize(R.dimen.ds2)) / 2;
            layoutParams.width = k;
            layoutParams.height = k;
            this.f65294e.setLayoutParams(layoutParams);
        }
    }

    public e(TbPageContext<?> tbPageContext, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f65279a = 3;
        this.j = new a(this);
        this.k = new b(this);
        this.f65280b = tbPageContext;
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.ala_sub_list_live_item_view, (ViewGroup) null, false);
        this.f65282d = inflate;
        this.f65281c = new c(this, inflate);
        this.f65287i = z;
    }

    public View g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f65282d : (View) invokeV.objValue;
    }

    public void h(d.a.q0.v.d.a.c cVar) {
        b2 b2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
            if (cVar != null && (b2Var = cVar.f64863h) != null && b2Var.h1() != null) {
                g().setVisibility(0);
                this.f65285g = cVar.f64863h;
                this.f65283e = cVar.f64860e;
                this.f65284f = !TextUtils.isEmpty(cVar.f64862g) ? cVar.f64862g : cVar.f64861f;
                this.f65281c.f65291b.setDrawerType(0);
                this.f65281c.f65291b.setBorderSurroundContent(true);
                this.f65281c.f65291b.setDrawBorder(true);
                this.f65281c.f65291b.M(this.f65285g.h1().cover, 10, false);
                this.f65281c.f65293d.setText(this.f65280b.getPageActivity().getResources().getString(R.string.square_sub_live_audience_label, StringHelper.numberUniformFormatExtra(this.f65285g.h1().audience_count)));
                this.f65281c.f65295f.setData(this.f65285g, false);
                this.f65281c.f65297h.setText(this.f65285g.getTitle());
                if (this.f65285g.H() != null) {
                    String name_show = this.f65285g.H().getName_show();
                    if (j0.d(name_show) > 10) {
                        name_show = j0.m(name_show, 10) + StringHelper.STRING_MORE;
                    }
                    this.f65281c.f65296g.setText(name_show);
                }
                String str = this.f65285g.h1().label_name;
                if (this.f65287i && !StringUtils.isNull(str)) {
                    this.f65281c.f65292c.setText(str);
                    this.f65281c.f65292c.setVisibility(0);
                } else {
                    this.f65281c.f65292c.setVisibility(8);
                }
                if (cVar.f64864i) {
                    this.f65281c.f65298i.setText(this.f65280b.getPageActivity().getResources().getString(R.string.square_sub_live_audience_distance, StringHelper.numberUniformFormatExtra((long) (this.f65285g.h1().distance / 1000.0d))));
                    this.f65281c.f65298i.setVisibility(0);
                } else {
                    this.f65281c.f65298i.setVisibility(8);
                }
                this.f65281c.f65296g.setOnClickListener(this.k);
                i(this.f65280b, TbadkCoreApplication.getInst().getSkinType());
                return;
            }
            g().setVisibility(4);
        }
    }

    public void i(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i2) == null) || this.f65279a == i2) {
            return;
        }
        SkinManager.setBackgroundResource(this.f65281c.f65294e, R.drawable.addresslist_item_bg);
        SkinManager.setViewTextColor(this.f65281c.f65293d, R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.f65281c.f65296g, R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.f65281c.f65297h, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f65281c.f65298i, R.color.CAM_X0109);
        this.f65279a = i2;
    }

    public void j(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, fVar) == null) {
            this.f65286h = fVar;
        }
    }
}

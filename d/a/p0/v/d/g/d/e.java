package d.a.p0.v.d.g.d;

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
import d.a.c.e.p.j;
import d.a.c.e.p.l;
import d.a.o0.r.q.b2;
import d.a.o0.z0.j0;
/* loaded from: classes8.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f64634a;

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext<?> f64635b;

    /* renamed from: c  reason: collision with root package name */
    public c f64636c;

    /* renamed from: d  reason: collision with root package name */
    public View f64637d;

    /* renamed from: e  reason: collision with root package name */
    public int f64638e;

    /* renamed from: f  reason: collision with root package name */
    public String f64639f;

    /* renamed from: g  reason: collision with root package name */
    public b2 f64640g;

    /* renamed from: h  reason: collision with root package name */
    public f f64641h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f64642i;
    public View.OnClickListener j;
    public View.OnClickListener k;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f64643e;

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
            this.f64643e = eVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (j.z()) {
                    if (this.f64643e.f64640g == null || this.f64643e.f64640g.g1() == null || this.f64643e.f64641h == null) {
                        return;
                    }
                    this.f64643e.f64641h.a(this.f64643e.f64638e, this.f64643e.f64639f, this.f64643e.f64640g);
                    return;
                }
                l.J(this.f64643e.f64635b.getPageActivity(), this.f64643e.f64635b.getPageActivity().getString(R.string.no_network_guide));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ e f64644e;

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
            this.f64644e = eVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || this.f64644e.f64640g == null || this.f64644e.f64640g.H() == null || StringUtils.isNull(this.f64644e.f64640g.H().getUserId())) {
                return;
            }
            long f2 = d.a.c.e.m.b.f(this.f64644e.f64640g.H().getUserId(), 0L);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.f64644e.f64635b.getPageActivity()).createNormalConfig(f2, f2 == d.a.c.e.m.b.f(TbadkCoreApplication.getCurrentAccount(), 0L), this.f64644e.f64640g.H().isBigV())));
        }
    }

    /* loaded from: classes8.dex */
    public class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public View f64645a;

        /* renamed from: b  reason: collision with root package name */
        public TbImageView f64646b;

        /* renamed from: c  reason: collision with root package name */
        public TextView f64647c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f64648d;

        /* renamed from: e  reason: collision with root package name */
        public RelativeLayout f64649e;

        /* renamed from: f  reason: collision with root package name */
        public ClickableHeaderImageView f64650f;

        /* renamed from: g  reason: collision with root package name */
        public TextView f64651g;

        /* renamed from: h  reason: collision with root package name */
        public TextView f64652h;

        /* renamed from: i  reason: collision with root package name */
        public TextView f64653i;

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
            this.f64645a = view;
            this.f64646b = (TbImageView) view.findViewById(R.id.imgSquareView);
            this.f64647c = (TextView) view.findViewById(R.id.tvLiveFrom);
            this.f64648d = (TextView) view.findViewById(R.id.tvLiveCount);
            this.f64649e = (RelativeLayout) view.findViewById(R.id.rlSquareLivePanel);
            this.f64650f = (ClickableHeaderImageView) view.findViewById(R.id.imgUserCover);
            this.f64651g = (TextView) view.findViewById(R.id.tvUserName);
            this.f64652h = (TextView) view.findViewById(R.id.tvSquareTitle);
            this.f64653i = (TextView) view.findViewById(R.id.tvSquareDistance);
            view.setOnClickListener(eVar.j);
            this.f64646b.setDefaultBgResource(R.drawable.pic_bg_video_frs);
            this.f64646b.setDrawerType(0);
            this.f64650f.setIsRound(true);
            this.f64650f.setDrawBorder(true);
            this.f64650f.setBorderColor(eVar.f64635b.getPageActivity().getResources().getColor(R.color.white_alpha100));
            this.f64650f.setBorderWidth(eVar.f64635b.getPageActivity().getResources().getDimensionPixelOffset(R.dimen.ds1));
            this.f64650f.setIsGod(false);
            this.f64650f.setIsBigV(false);
            this.f64650f.setShowV(false);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f64649e.getLayoutParams();
            int k = (l.k(view.getContext()) - view.getContext().getResources().getDimensionPixelSize(R.dimen.ds2)) / 2;
            layoutParams.width = k;
            layoutParams.height = k;
            this.f64649e.setLayoutParams(layoutParams);
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
        this.f64634a = 3;
        this.j = new a(this);
        this.k = new b(this);
        this.f64635b = tbPageContext;
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.ala_sub_list_live_item_view, (ViewGroup) null, false);
        this.f64637d = inflate;
        this.f64636c = new c(this, inflate);
        this.f64642i = z;
    }

    public View g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f64637d : (View) invokeV.objValue;
    }

    public void h(d.a.p0.v.d.a.c cVar) {
        b2 b2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
            if (cVar != null && (b2Var = cVar.f64218h) != null && b2Var.g1() != null) {
                g().setVisibility(0);
                this.f64640g = cVar.f64218h;
                this.f64638e = cVar.f64215e;
                this.f64639f = !TextUtils.isEmpty(cVar.f64217g) ? cVar.f64217g : cVar.f64216f;
                this.f64636c.f64646b.setDrawerType(0);
                this.f64636c.f64646b.setBorderSurroundContent(true);
                this.f64636c.f64646b.setDrawBorder(true);
                this.f64636c.f64646b.M(this.f64640g.g1().cover, 10, false);
                this.f64636c.f64648d.setText(this.f64635b.getPageActivity().getResources().getString(R.string.square_sub_live_audience_label, StringHelper.numberUniformFormatExtra(this.f64640g.g1().audience_count)));
                this.f64636c.f64650f.setData(this.f64640g, false);
                this.f64636c.f64652h.setText(this.f64640g.getTitle());
                if (this.f64640g.H() != null) {
                    String name_show = this.f64640g.H().getName_show();
                    if (j0.d(name_show) > 10) {
                        name_show = j0.m(name_show, 10) + StringHelper.STRING_MORE;
                    }
                    this.f64636c.f64651g.setText(name_show);
                }
                String str = this.f64640g.g1().label_name;
                if (this.f64642i && !StringUtils.isNull(str)) {
                    this.f64636c.f64647c.setText(str);
                    this.f64636c.f64647c.setVisibility(0);
                } else {
                    this.f64636c.f64647c.setVisibility(8);
                }
                if (cVar.f64219i) {
                    this.f64636c.f64653i.setText(this.f64635b.getPageActivity().getResources().getString(R.string.square_sub_live_audience_distance, StringHelper.numberUniformFormatExtra((long) (this.f64640g.g1().distance / 1000.0d))));
                    this.f64636c.f64653i.setVisibility(0);
                } else {
                    this.f64636c.f64653i.setVisibility(8);
                }
                this.f64636c.f64651g.setOnClickListener(this.k);
                i(this.f64635b, TbadkCoreApplication.getInst().getSkinType());
                return;
            }
            g().setVisibility(4);
        }
    }

    public void i(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i2) == null) || this.f64634a == i2) {
            return;
        }
        SkinManager.setBackgroundResource(this.f64636c.f64649e, R.drawable.addresslist_item_bg);
        SkinManager.setViewTextColor(this.f64636c.f64648d, R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.f64636c.f64651g, R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.f64636c.f64652h, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.f64636c.f64653i, R.color.CAM_X0109);
        this.f64634a = i2;
    }

    public void j(f fVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, fVar) == null) {
            this.f64641h = fVar;
        }
    }
}

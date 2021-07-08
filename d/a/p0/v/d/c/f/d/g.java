package d.a.p0.v.d.c.f.d;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.view.HeadImageView;
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
/* loaded from: classes8.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<?> f64377a;

    /* renamed from: b  reason: collision with root package name */
    public View f64378b;

    /* renamed from: c  reason: collision with root package name */
    public HeadImageView f64379c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f64380d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f64381e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f64382f;

    /* renamed from: g  reason: collision with root package name */
    public i f64383g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.p0.v.d.a.c f64384h;

    /* renamed from: i  reason: collision with root package name */
    public View.OnClickListener f64385i;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f64386e;

        public a(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f64386e = gVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (j.z()) {
                    if (this.f64386e.f64384h == null || this.f64386e.f64384h.f64218h == null || view != this.f64386e.f64378b || this.f64386e.f64383g == null) {
                        return;
                    }
                    this.f64386e.f64383g.a(this.f64386e.f64384h);
                    return;
                }
                l.J(this.f64386e.f64377a.getPageActivity(), this.f64386e.f64377a.getPageActivity().getString(R.string.no_network_guide));
            }
        }
    }

    public g(TbPageContext<?> tbPageContext) {
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
        this.f64385i = new a(this);
        this.f64377a = tbPageContext;
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.tab_sub_recommend_item_view, (ViewGroup) null);
        this.f64378b = inflate;
        this.f64382f = (LinearLayout) inflate.findViewById(R.id.tab_sub_wrapper);
        this.f64379c = (HeadImageView) this.f64378b.findViewById(R.id.iv_anchor_avatar);
        this.f64380d = (TextView) this.f64378b.findViewById(R.id.tv_anchor_name);
        this.f64381e = (TextView) this.f64378b.findViewById(R.id.tv_live_aud_num);
        this.f64378b.setOnClickListener(this.f64385i);
        this.f64379c.setBorderWidth(l.g(tbPageContext.getPageActivity(), R.dimen.tbds1));
        this.f64379c.setIsRound(true);
        this.f64379c.setPlaceHolder(1);
        this.f64379c.setAutoChangeStyle(true);
        this.f64379c.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.f64382f.setLayoutParams(new LinearLayout.LayoutParams((l.k(this.f64377a.getPageActivity()) - (this.f64377a.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds44) * 2)) / 3, this.f64377a.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds366)));
        g(tbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    public View e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f64378b : (View) invokeV.objValue;
    }

    public void f(d.a.p0.v.d.a.c cVar) {
        b2 b2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
            if (cVar != null && (b2Var = cVar.f64218h) != null && b2Var.H() != null) {
                e().setVisibility(0);
                this.f64384h = cVar;
                cVar.f64218h.H().getUserId();
                this.f64379c.N(cVar.f64218h.H().getPortrait(), 25, false, false);
                String name_show = cVar.f64218h.H().getName_show();
                if (!StringUtils.isNull(name_show)) {
                    if (k.byteLength(name_show) > 16) {
                        name_show = StringHelper.cutChineseAndEnglishWithSuffix(name_show, 16, StringHelper.STRING_MORE);
                    }
                    this.f64380d.setText(name_show);
                }
                if (cVar.f64218h.g1() != null) {
                    this.f64381e.setText(String.format(this.f64377a.getPageActivity().getResources().getString(R.string.live_tab_audience_watch_label), StringHelper.numberUniformFormatExtraWithRound(cVar.f64218h.g1().audience_count)));
                }
                g(this.f64377a, TbadkCoreApplication.getInst().getSkinType());
                return;
            }
            e().setVisibility(4);
        }
    }

    public void g(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i2) == null) {
            SkinManager.setViewTextColor(this.f64380d, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f64381e, R.color.CAM_X0109);
            if (i2 == 1) {
                this.f64379c.setBorderColor(this.f64377a.getResources().getColor(R.color.CAM_X0903_1));
            } else {
                this.f64379c.setBorderColor(this.f64377a.getResources().getColor(R.color.CAM_X0903));
            }
            Drawable drawable = SkinManager.getDrawable(this.f64377a.getResources(), R.drawable.tab_icon_living_seeding);
            drawable.setBounds(0, 0, this.f64377a.getResources().getDimensionPixelOffset(R.dimen.tbds18), this.f64377a.getResources().getDimensionPixelOffset(R.dimen.tbds18));
            this.f64381e.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            this.f64381e.setCompoundDrawablePadding(this.f64377a.getResources().getDimensionPixelOffset(R.dimen.tbds8));
        }
    }

    public void h(i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, iVar) == null) {
            this.f64383g = iVar;
        }
    }
}

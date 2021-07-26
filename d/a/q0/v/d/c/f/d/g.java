package d.a.q0.v.d.c.f.d;

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
import d.a.d.e.p.j;
import d.a.d.e.p.k;
import d.a.d.e.p.l;
import d.a.p0.s.q.b2;
/* loaded from: classes8.dex */
public class g {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext<?> f65022a;

    /* renamed from: b  reason: collision with root package name */
    public View f65023b;

    /* renamed from: c  reason: collision with root package name */
    public HeadImageView f65024c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f65025d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f65026e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f65027f;

    /* renamed from: g  reason: collision with root package name */
    public i f65028g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.q0.v.d.a.c f65029h;

    /* renamed from: i  reason: collision with root package name */
    public View.OnClickListener f65030i;

    /* loaded from: classes8.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f65031e;

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
            this.f65031e = gVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (j.z()) {
                    if (this.f65031e.f65029h == null || this.f65031e.f65029h.f64863h == null || view != this.f65031e.f65023b || this.f65031e.f65028g == null) {
                        return;
                    }
                    this.f65031e.f65028g.a(this.f65031e.f65029h);
                    return;
                }
                l.J(this.f65031e.f65022a.getPageActivity(), this.f65031e.f65022a.getPageActivity().getString(R.string.no_network_guide));
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
        this.f65030i = new a(this);
        this.f65022a = tbPageContext;
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.tab_sub_recommend_item_view, (ViewGroup) null);
        this.f65023b = inflate;
        this.f65027f = (LinearLayout) inflate.findViewById(R.id.tab_sub_wrapper);
        this.f65024c = (HeadImageView) this.f65023b.findViewById(R.id.iv_anchor_avatar);
        this.f65025d = (TextView) this.f65023b.findViewById(R.id.tv_anchor_name);
        this.f65026e = (TextView) this.f65023b.findViewById(R.id.tv_live_aud_num);
        this.f65023b.setOnClickListener(this.f65030i);
        this.f65024c.setBorderWidth(l.g(tbPageContext.getPageActivity(), R.dimen.tbds1));
        this.f65024c.setIsRound(true);
        this.f65024c.setPlaceHolder(1);
        this.f65024c.setAutoChangeStyle(true);
        this.f65024c.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.f65027f.setLayoutParams(new LinearLayout.LayoutParams((l.k(this.f65022a.getPageActivity()) - (this.f65022a.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds44) * 2)) / 3, this.f65022a.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds366)));
        g(tbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    public View e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f65023b : (View) invokeV.objValue;
    }

    public void f(d.a.q0.v.d.a.c cVar) {
        b2 b2Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cVar) == null) {
            if (cVar != null && (b2Var = cVar.f64863h) != null && b2Var.H() != null) {
                e().setVisibility(0);
                this.f65029h = cVar;
                cVar.f64863h.H().getUserId();
                this.f65024c.N(cVar.f64863h.H().getPortrait(), 25, false, false);
                String name_show = cVar.f64863h.H().getName_show();
                if (!StringUtils.isNull(name_show)) {
                    if (k.byteLength(name_show) > 16) {
                        name_show = StringHelper.cutChineseAndEnglishWithSuffix(name_show, 16, StringHelper.STRING_MORE);
                    }
                    this.f65025d.setText(name_show);
                }
                if (cVar.f64863h.h1() != null) {
                    this.f65026e.setText(String.format(this.f65022a.getPageActivity().getResources().getString(R.string.live_tab_audience_watch_label), StringHelper.numberUniformFormatExtraWithRound(cVar.f64863h.h1().audience_count)));
                }
                g(this.f65022a, TbadkCoreApplication.getInst().getSkinType());
                return;
            }
            e().setVisibility(4);
        }
    }

    public void g(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i2) == null) {
            SkinManager.setViewTextColor(this.f65025d, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.f65026e, R.color.CAM_X0109);
            if (i2 == 1) {
                this.f65024c.setBorderColor(this.f65022a.getResources().getColor(R.color.CAM_X0903_1));
            } else {
                this.f65024c.setBorderColor(this.f65022a.getResources().getColor(R.color.CAM_X0903));
            }
            Drawable drawable = SkinManager.getDrawable(this.f65022a.getResources(), R.drawable.tab_icon_living_seeding);
            drawable.setBounds(0, 0, this.f65022a.getResources().getDimensionPixelOffset(R.dimen.tbds18), this.f65022a.getResources().getDimensionPixelOffset(R.dimen.tbds18));
            this.f65026e.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            this.f65026e.setCompoundDrawablePadding(this.f65022a.getResources().getDimensionPixelOffset(R.dimen.tbds8));
        }
    }

    public void h(i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, iVar) == null) {
            this.f65028g = iVar;
        }
    }
}

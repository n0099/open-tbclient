package d.a.q0.u0.g1;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.e.p.l;
/* loaded from: classes8.dex */
public class b extends d.a.q0.a0.b<c> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbImageView m;
    public TextView n;
    public TextView o;
    public View p;
    public RelativeLayout q;
    public ConstrainImageGroup r;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
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
        View k = k();
        this.m = (TbImageView) k.findViewById(R.id.ad_portrait);
        this.n = (TextView) k.findViewById(R.id.ad_title);
        this.o = (TextView) k.findViewById(R.id.ad_desc);
        this.r = (ConstrainImageGroup) k.findViewById(R.id.ad_img_layout);
        this.p = k.findViewById(R.id.item_divider);
        this.q = (RelativeLayout) k.findViewById(R.id.frs_ad_list_item_view);
        k.setOnClickListener(this);
    }

    @Override // d.a.q0.a0.b
    public int g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.frs_ad_list_item_view : invokeV.intValue;
    }

    @Override // d.a.q0.a0.b
    public void m(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i2) == null) || this.f54319e == i2) {
            return;
        }
        this.f54319e = i2;
        SkinManager.setViewTextColor(this.n, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.o, R.color.CAM_X0109);
        SkinManager.setBackgroundResource(this.q, R.drawable.ad_list_item_bg);
        this.r.b();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.q0.a0.b
    /* renamed from: q */
    public void l(c cVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, cVar) == null) || cVar == null) {
            return;
        }
        this.m.setPlaceHolder(1);
        this.m.M(cVar.e(), 10, false);
        this.m.setRadius(l.g(b(), R.dimen.tbds26));
        this.m.setDrawerType(1);
        this.m.setDrawBorder(true);
        this.m.setBorderColor(SkinManager.getColor(R.color.black_alpha15));
        this.m.setBorderWidth(l.g(b(), R.dimen.tbds1));
        this.m.setDefaultResource(R.drawable.transparent_bg);
        this.m.setDefaultBgResource(R.drawable.transparent_bg);
        this.n.setText(cVar.d());
        this.o.setText(cVar.c());
        SkinManager.setViewTextColor(this.n, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.o, R.color.CAM_X0109);
        SkinManager.setBackgroundResource(this.q, R.drawable.ad_list_item_bg);
        if (ListUtils.getCount(cVar.o()) > 0) {
            d.a.p0.d1.j.f fVar = new d.a.p0.d1.j.f(3);
            fVar.d(1.0d);
            this.r.setVisibility(0);
            this.r.setFromCDN(true);
            this.r.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20));
            this.r.setImageProcessor(fVar);
            this.r.setImageMediaList(cVar.o());
            if (!cVar.j()) {
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, l.g(b(), R.dimen.tbds16));
                layoutParams.addRule(12);
                this.p.setLayoutParams(layoutParams);
                SkinManager.setBackgroundColor(this.p, R.color.CAM_X0204);
                this.p.setVisibility(0);
                return;
            }
            this.p.setVisibility(8);
            return;
        }
        this.r.setVisibility(8);
        if (!cVar.j()) {
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, l.g(b(), R.dimen.tbds1));
            layoutParams2.addRule(12);
            this.p.setLayoutParams(layoutParams2);
            SkinManager.setBackgroundColor(this.p, R.color.CAM_X0204);
            this.p.setVisibility(0);
            return;
        }
        this.p.setVisibility(8);
    }

    public void s(d.a.d.e.k.b<TbImageView> bVar) {
        ConstrainImageGroup constrainImageGroup;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) || (constrainImageGroup = this.r) == null) {
            return;
        }
        constrainImageGroup.setImageViewPool(bVar);
    }

    public void t(d.a.d.e.k.b<ConstrainImageLayout> bVar) {
        ConstrainImageGroup constrainImageGroup;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, bVar) == null) || (constrainImageGroup = this.r) == null) {
            return;
        }
        constrainImageGroup.setConstrainLayoutPool(bVar);
    }

    public void u(double d2) {
        ConstrainImageGroup constrainImageGroup;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{Double.valueOf(d2)}) == null) || (constrainImageGroup = this.r) == null) {
            return;
        }
        constrainImageGroup.setSingleImageRatio(d2);
    }
}

package d.a.s0.v.d.c.f.d;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.l;
/* loaded from: classes9.dex */
public class f extends d.a.s0.a0.b<d.a.s0.v.d.c.f.b.b> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView m;
    public TextView n;
    public HeadImageView o;
    public TextView p;
    public View q;
    public d.a.s0.v.d.c.f.b.b r;
    public RelativeLayout s;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(TbPageContext tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, viewGroup};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (ViewGroup) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.q = l();
        this.s = (RelativeLayout) l().findViewById(R.id.id_tab_live_sub_offline_item_wrapper);
        this.m = (TextView) l().findViewById(R.id.id_tab_live_sub_offline_item_name);
        this.n = (TextView) l().findViewById(R.id.id_tab_live_sub_offline_item_description);
        HeadImageView headImageView = (HeadImageView) l().findViewById(R.id.id_tab_live_sub_offline_item_avatar);
        this.o = headImageView;
        headImageView.setAutoChangeStyle(true);
        this.o.setIsRound(true);
        this.o.setDrawBorder(true);
        this.o.setPlaceHolder(1);
        this.o.setBorderWidth(l.g(tbPageContext.getPageActivity(), R.dimen.tbds1));
        this.o.setDefaultScaleType(ImageView.ScaleType.CENTER_CROP);
        this.p = (TextView) l().findViewById(R.id.id_tab_live_sub_offline_item_time);
        this.s.setOnClickListener(this);
        n(tbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // d.a.s0.a0.b
    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.tab_sub_live_offline_item_view : invokeV.intValue;
    }

    @Override // d.a.s0.a0.b
    public void n(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i2) == null) {
            SkinManager.setBackgroundResource(this.q, R.color.CAM_X0201);
            SkinManager.setViewTextColor(this.m, R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.n, R.color.CAM_X0108);
            SkinManager.setViewTextColor(this.p, R.color.CAM_X0108);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, view) == null) || i() == null) {
            return;
        }
        i().a(view, this.r);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.s0.a0.b
    /* renamed from: s */
    public void m(d.a.s0.v.d.c.f.b.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, bVar) == null) || bVar == null) {
            return;
        }
        this.r = bVar;
        String str = bVar.f67554g;
        if (StringUtils.isNull(str)) {
            str = StringUtils.isNull(bVar.f67553f) ? "" : bVar.f67553f;
        }
        this.m.setText(str);
        this.n.setText(StringUtils.isNull(bVar.f67556i) ? "" : bVar.f67556i);
        this.o.M(bVar.f67555h, 10, false);
        this.p.setText(StringUtils.isNull(bVar.j) ? "" : bVar.j);
    }
}

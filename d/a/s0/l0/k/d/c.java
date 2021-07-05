package d.a.s0.l0.k.d;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.s0.a0.b0;
/* loaded from: classes9.dex */
public class c extends d.a.s0.a0.b<d.a.s0.l0.k.c.d> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext m;
    public int n;
    public TextView o;
    public View p;
    public TextView q;
    public d.a.s0.l0.k.c.d r;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(TbPageContext<?> tbPageContext) {
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
        this.n = 3;
        this.m = tbPageContext;
        s();
    }

    @Override // d.a.s0.a0.b
    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.recommend_forum_title_layout : invokeV.intValue;
    }

    @Override // d.a.s0.a0.b
    public void n(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i2) == null) {
            this.n = i2;
            SkinManager.setViewTextColor(this.o, R.color.CAM_X0105);
            SkinManager.setBackgroundColor(l(), R.color.CAM_X0205);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        b0<d.a.s0.l0.k.c.d> i2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, view) == null) || view != this.q || (i2 = i()) == null || this.r.h() >= this.r.d().size()) {
            return;
        }
        i2.a(view, this.r);
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            View l = l();
            this.o = (TextView) l.findViewById(R.id.recommend_title);
            this.p = l.findViewById(R.id.top_line);
            TextView textView = (TextView) l.findViewById(R.id.recommend_update);
            this.q = textView;
            textView.setOnClickListener(this);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.s0.a0.b
    /* renamed from: t */
    public void m(d.a.s0.l0.k.c.d dVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, dVar) == null) || dVar == null) {
            return;
        }
        this.r = dVar;
        n(this.m, this.n);
        if (StringUtils.isNull(dVar.getTitle())) {
            return;
        }
        this.o.setText(dVar.getTitle());
    }

    public void u(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.p.setVisibility(z ? 0 : 8);
        }
    }
}

package d.a.s0.m2.j;

import android.view.View;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class i extends d.a.s0.a0.b<d.a.s0.m2.e.k> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView m;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(TbPageContext<?> tbPageContext) {
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
        this.m = (TextView) l();
    }

    @Override // d.a.s0.a0.b
    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.card_person_title_layout : invokeV.intValue;
    }

    @Override // d.a.s0.a0.b
    public void n(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i2) == null) || this.f57031e == i2) {
            return;
        }
        this.f57031e = i2;
        SkinManager.setViewTextColor(this.m, R.color.CAM_X0105, 1);
        SkinManager.setBackgroundResource(this.m, R.color.CAM_X0201);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view) == null) {
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.s0.a0.b
    /* renamed from: s */
    public void m(d.a.s0.m2.e.k kVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, kVar) == null) || kVar == null) {
            return;
        }
        this.m.setPadding(kVar.f63505f, kVar.f63506g, 0, kVar.f63507h);
        this.m.setText(this.f57033g.getString(kVar.f63504e));
    }
}

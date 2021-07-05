package d.a.s0.m2.j;

import android.view.View;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class n extends d.a.s0.a0.b<d.a.s0.m2.e.o> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext m;
    public View n;
    public TbImageView o;
    public TextView p;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(TbPageContext tbPageContext) {
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
        View l = l();
        this.n = l;
        this.m = tbPageContext;
        l.setTag(this);
        this.o = (TbImageView) this.n.findViewById(R.id.gift_pic);
        this.p = (TextView) this.n.findViewById(R.id.gift_num_text);
    }

    @Override // d.a.s0.a0.b
    public int h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? R.layout.item_gift_view : invokeV.intValue;
    }

    @Override // d.a.s0.a0.b
    public void n(TbPageContext<?> tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i2) == null) {
            SkinManager.setBackgroundColor(this.n, R.color.CAM_X0201);
            SkinManager.setBackgroundResource(this.o, R.drawable.item_gift_selector);
            SkinManager.setBackgroundColor(this.p, R.color.common_color_10294);
            SkinManager.setViewTextColor(this.p, R.color.CAM_X0302);
        }
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
    public void m(d.a.s0.m2.e.o oVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, oVar) == null) {
            if (oVar == null) {
                this.n.setVisibility(8);
                return;
            }
            n(this.m, TbadkCoreApplication.getInst().getSkinType());
            this.o.M(oVar.f63519e, 10, false);
            this.n.setOnClickListener(this);
            if (oVar.f63520f > 0) {
                this.p.setVisibility(0);
                long j = oVar.f63520f;
                if (j > 99) {
                    this.p.setText("99");
                    return;
                } else {
                    this.p.setText(String.valueOf(j));
                    return;
                }
            }
            this.p.setVisibility(8);
        }
    }
}

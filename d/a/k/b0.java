package d.a.k;

import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.Align;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.p0.s.q.w0;
/* loaded from: classes7.dex */
public class b0 extends c implements p<w0>, q {
    public static /* synthetic */ Interceptable $ic;
    public static final int l;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: i  reason: collision with root package name */
    public NEGFeedBackView f43137i;
    public Align j;
    public boolean k;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-464843356, "Ld/a/k/b0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-464843356, "Ld/a/k/b0;");
                return;
            }
        }
        l = d.a.d.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds124);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public b0(TbPageContext tbPageContext, boolean z) {
        this(tbPageContext, z ? Align.ALIGN_RIGHT_BOTTOM : Align.ALIGN_RIGHT_TOP);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((TbPageContext) objArr2[0], (Align) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            int g2 = d.a.d.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds57);
            int g3 = d.a.d.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.M_W_X005);
            int g4 = d.a.d.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds34);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(g2, g2);
            layoutParams.addRule(11);
            layoutParams.addRule(10);
            layoutParams.rightMargin = g3;
            layoutParams.topMargin = g4;
            i(layoutParams);
            this.f43137i.setWebPResId(R.drawable.icon_pure_card_close22, R.color.CAM_X0111);
            this.f43137i.setPadding(0, 0, 0, 0);
            this.f43137i.setLayoutParams(layoutParams);
        }
    }

    public void l(Align align) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, align) == null) || this.j == align) {
            return;
        }
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds57);
        if (align == Align.ALIGN_RIGHT_TOP) {
            int dimenPixelSize2 = UtilHelper.getDimenPixelSize(R.dimen.tbds60);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dimenPixelSize, dimenPixelSize);
            layoutParams.addRule(11);
            layoutParams.addRule(10);
            layoutParams.rightMargin = dimenPixelSize - UtilHelper.getDimenPixelSize(R.dimen.M_W_X005);
            layoutParams.topMargin = dimenPixelSize2;
            i(layoutParams);
            this.f43137i.setWebPResId(R.drawable.icon_pure_card_close22, R.color.CAM_X0111);
            this.f43137i.setPadding(dimenPixelSize, dimenPixelSize, dimenPixelSize, dimenPixelSize);
            this.f43137i.setLayoutParams(layoutParams);
        } else if (align == Align.ALIGN_RIGHT_CENTER) {
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(dimenPixelSize, dimenPixelSize);
            layoutParams2.addRule(11);
            layoutParams2.addRule(15);
            layoutParams2.rightMargin = dimenPixelSize - UtilHelper.getDimenPixelSize(R.dimen.M_W_X005);
            layoutParams2.bottomMargin = 0;
            i(layoutParams2);
            this.f43137i.setWebPResId(R.drawable.icon_pure_card_close22, R.color.CAM_X0111);
            this.f43137i.setPadding(dimenPixelSize, dimenPixelSize, dimenPixelSize, dimenPixelSize);
            this.f43137i.setLayoutParams(layoutParams2);
        } else if (align == Align.ALIGN_RIGHT_BOTTOM) {
            int i2 = l;
            int g2 = d.a.d.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds30);
            int g3 = d.a.d.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds14);
            int g4 = d.a.d.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds20);
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(i2, i2);
            layoutParams3.addRule(11);
            layoutParams3.addRule(12);
            layoutParams3.rightMargin = g3;
            layoutParams3.bottomMargin = g4;
            i(layoutParams3);
            this.f43137i.setWebPResId(R.drawable.icon_pure_card_more22, R.color.CAM_X0111);
            this.f43137i.setPadding(g2, g2, g2, g2);
            this.f43137i.setLayoutParams(layoutParams3);
        }
        this.j = align;
    }

    public void m(d.a.p0.s.q.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) || aVar == null || aVar.getNegFeedBackData() == null) {
            return;
        }
        if (aVar.getNegFeedBackData().g() <= 0 && aVar.getThreadData() != null) {
            if (!aVar.showCardBottomOpWeight() && !aVar.isFromFrs()) {
                l(Align.ALIGN_RIGHT_BOTTOM);
            } else if (aVar.isSupportTop()) {
                v((!p(aVar) || d.a.p0.b.d.o0()) ? UtilHelper.getDimenPixelSize(R.dimen.tbds60) : o(R.dimen.tbds64));
            } else if (aVar.isSupportBottom()) {
                l0 l0Var = this.f43141h;
                if (l0Var != null) {
                    l0Var.n(this);
                }
            } else {
                l(Align.ALIGN_RIGHT_TOP);
            }
        } else if (this.k) {
            k();
        } else {
            r(aVar);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.k.c
    /* renamed from: n */
    public NEGFeedBackView b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f43137i : (NEGFeedBackView) invokeV.objValue;
    }

    public final int o(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i2)) == null) ? d.a.d.e.p.l.g(TbadkCoreApplication.getInst(), i2) : invokeI.intValue;
    }

    @Override // d.a.k.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048583, this, tbPageContext, i2) == null) {
            this.f43137i.q();
        }
    }

    public final boolean p(d.a.p0.s.q.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, aVar)) == null) ? (aVar instanceof d.a.q0.a0.e0.k) && ((d.a.q0.a0.e0.k) aVar).s : invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.k.p
    /* renamed from: q */
    public void a(w0 w0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, w0Var) == null) {
            if (w0Var == null) {
                this.f43137i.setVisibility(8);
                return;
            }
            this.f43137i.setData(w0Var);
            this.f43137i.setFirstRowSingleColumn(true);
            this.f43137i.setVisibility(0);
        }
    }

    public final void r(d.a.p0.s.q.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, aVar) == null) {
            if (aVar.showCardBottomOpWeight()) {
                int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds57);
                int dimenPixelSize2 = UtilHelper.getDimenPixelSize(R.dimen.tbds60);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dimenPixelSize, dimenPixelSize);
                layoutParams.addRule(11);
                layoutParams.addRule(10);
                layoutParams.rightMargin = dimenPixelSize - UtilHelper.getDimenPixelSize(R.dimen.M_W_X005);
                layoutParams.topMargin = dimenPixelSize2;
                i(layoutParams);
                this.f43137i.setWebPResId(R.drawable.icon_pure_card_close22, R.color.CAM_X0111);
                this.f43137i.setPadding(dimenPixelSize, dimenPixelSize, dimenPixelSize, dimenPixelSize);
                this.f43137i.setLayoutParams(layoutParams);
                return;
            }
            int i2 = l;
            int g2 = d.a.d.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds30);
            int g3 = d.a.d.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds14);
            int g4 = d.a.d.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds17);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(i2, i2);
            layoutParams2.addRule(11);
            layoutParams2.addRule(10);
            layoutParams2.rightMargin = g3;
            layoutParams2.topMargin = g4;
            i(layoutParams2);
            this.f43137i.setWebPResId(R.drawable.icon_pure_card_more22, R.color.CAM_X0111);
            this.f43137i.setPadding(g2, g2, g2, g2);
            this.f43137i.setLayoutParams(layoutParams2);
        }
    }

    public void s(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.f43137i.setAutoProcess(z);
        }
    }

    public void t(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            this.f43137i.setHeadText(str);
        }
    }

    public void u(NEGFeedBackView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, bVar) == null) {
            this.f43137i.setEventCallback(bVar);
        }
    }

    public final void v(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f43137i.getLayoutParams();
            if (this.f43137i.getParent() == null || layoutParams == null || layoutParams.topMargin != i2) {
                int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds57);
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(dimenPixelSize, dimenPixelSize);
                layoutParams2.addRule(11);
                layoutParams2.addRule(10);
                layoutParams2.rightMargin = dimenPixelSize - UtilHelper.getDimenPixelSize(R.dimen.M_W_X005);
                layoutParams2.topMargin = i2;
                i(layoutParams2);
                this.f43137i.setWebPResId(R.drawable.icon_pure_card_close22, R.color.CAM_X0111);
                this.f43137i.setPadding(dimenPixelSize, dimenPixelSize, dimenPixelSize, dimenPixelSize);
                this.f43137i.setLayoutParams(layoutParams2);
            }
        }
    }

    public void w(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            this.f43137i.s(z);
        }
    }

    public b0(TbPageContext tbPageContext, Align align) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, align};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        h(-1);
        NEGFeedBackView nEGFeedBackView = new NEGFeedBackView(tbPageContext);
        this.f43137i = nEGFeedBackView;
        nEGFeedBackView.setId(R.id.decor_item_right_id);
        g(this.f43137i);
        l(align);
    }
}

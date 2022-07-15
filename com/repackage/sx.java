package com.repackage;

import android.widget.RelativeLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.Align;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.abtest.UbsABTestHelper;
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
/* loaded from: classes7.dex */
public class sx extends sw implements gx<kp4>, hx {
    public static /* synthetic */ Interceptable $ic;
    public static final int h;
    public transient /* synthetic */ FieldHolder $fh;
    public NEGFeedBackView e;
    public Align f;
    public boolean g;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1964027328, "Lcom/repackage/sx;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1964027328, "Lcom/repackage/sx;");
                return;
            }
        }
        h = pi.f(TbadkCoreApplication.getInst(), R.dimen.tbds124);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public sx(TbPageContext tbPageContext, boolean z) {
        this(tbPageContext, z ? Align.ALIGN_RIGHT_BOTTOM : Align.ALIGN_RIGHT_TOP);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
            int f = pi.f(TbadkCoreApplication.getInst(), R.dimen.tbds57);
            int f2 = pi.f(TbadkCoreApplication.getInst(), R.dimen.M_W_X005);
            int f3 = pi.f(TbadkCoreApplication.getInst(), R.dimen.tbds34);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(f, f);
            layoutParams.addRule(11);
            layoutParams.addRule(10);
            layoutParams.rightMargin = f2;
            layoutParams.topMargin = f3;
            i(layoutParams);
            this.e.setWebPResId(R.drawable.icon_pure_card_close22, R.color.CAM_X0111);
            this.e.setPadding(0, 0, 0, 0);
            this.e.setLayoutParams(layoutParams);
        }
    }

    public void l(Align align) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, align) == null) || this.f == align) {
            return;
        }
        int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds80);
        int dimenPixelSize2 = UtilHelper.getDimenPixelSize(R.dimen.tbds88);
        if (align == Align.ALIGN_RIGHT_TOP) {
            int dimenPixelSize3 = UtilHelper.getDimenPixelSize(R.dimen.M_W_X005);
            int dimenPixelSize4 = UtilHelper.getDimenPixelSize(R.dimen.tbds50);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dimenPixelSize2, dimenPixelSize2);
            layoutParams.addRule(11);
            layoutParams.addRule(10);
            layoutParams.rightMargin = dimenPixelSize3;
            layoutParams.topMargin = dimenPixelSize4;
            i(layoutParams);
            this.e.setWebPResId(R.drawable.icon_pure_card_close22, R.color.CAM_X0111);
            this.e.setPadding(dimenPixelSize, dimenPixelSize, dimenPixelSize, dimenPixelSize);
            this.e.setLayoutParams(layoutParams);
        } else if (align == Align.ALIGN_RIGHT_CENTER) {
            int dimenPixelSize5 = UtilHelper.getDimenPixelSize(R.dimen.M_W_X005);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(dimenPixelSize2, dimenPixelSize2);
            layoutParams2.addRule(11);
            layoutParams2.addRule(15);
            layoutParams2.rightMargin = dimenPixelSize5;
            layoutParams2.bottomMargin = 0;
            i(layoutParams2);
            this.e.setWebPResId(R.drawable.icon_pure_card_close22, R.color.CAM_X0111);
            this.e.setPadding(dimenPixelSize, dimenPixelSize, dimenPixelSize, dimenPixelSize);
            this.e.setLayoutParams(layoutParams2);
        } else if (align == Align.ALIGN_RIGHT_BOTTOM) {
            int i = h;
            int f = pi.f(TbadkCoreApplication.getInst(), R.dimen.tbds30);
            int f2 = pi.f(TbadkCoreApplication.getInst(), R.dimen.tbds14);
            int f3 = pi.f(TbadkCoreApplication.getInst(), R.dimen.tbds20);
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(i, i);
            layoutParams3.addRule(11);
            layoutParams3.addRule(12);
            layoutParams3.rightMargin = f2;
            layoutParams3.bottomMargin = f3;
            i(layoutParams3);
            this.e.setWebPResId(R.drawable.obfuscated_res_0x7f0808f9, R.color.CAM_X0111);
            this.e.setPadding(f, f, f, f);
            this.e.setLayoutParams(layoutParams3);
        }
        this.f = align;
    }

    public void m(nn4 nn4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, nn4Var) == null) || nn4Var == null || nn4Var.getNegFeedBackData() == null) {
            return;
        }
        if (nn4Var.getNegFeedBackData().h() <= 0 && nn4Var.getThreadData() != null) {
            if (!nn4Var.showCardBottomOpWeight() && !nn4Var.isFromFrs()) {
                l(Align.ALIGN_RIGHT_BOTTOM);
            } else if (nn4Var.isSupportTop()) {
                v((!p(nn4Var) || UbsABTestHelper.showNewUI()) ? UtilHelper.getDimenPixelSize(R.dimen.tbds50) : o(R.dimen.tbds64));
            } else if (nn4Var.isSupportBottom()) {
                cy cyVar = this.d;
                if (cyVar != null) {
                    cyVar.n(this);
                }
            } else {
                l(Align.ALIGN_RIGHT_TOP);
            }
        } else if (this.g) {
            k();
        } else {
            r(nn4Var);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.sw
    /* renamed from: n */
    public NEGFeedBackView b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.e : (NEGFeedBackView) invokeV.objValue;
    }

    public final int o(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) ? pi.f(TbadkCoreApplication.getInst(), i) : invokeI.intValue;
    }

    @Override // com.repackage.hx
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048583, this, tbPageContext, i) == null) {
            this.e.q();
        }
    }

    public final boolean p(nn4 nn4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, nn4Var)) == null) ? (nn4Var instanceof vy5) && ((vy5) nn4Var).n : invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.gx
    /* renamed from: q */
    public void a(kp4 kp4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, kp4Var) == null) {
            if (kp4Var == null) {
                this.e.setVisibility(8);
                return;
            }
            this.e.setData(kp4Var);
            this.e.setFirstRowSingleColumn(true);
            this.e.setVisibility(0);
        }
    }

    public final void r(nn4 nn4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, nn4Var) == null) {
            if (nn4Var.showCardBottomOpWeight()) {
                int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds80);
                int dimenPixelSize2 = UtilHelper.getDimenPixelSize(R.dimen.tbds88);
                int dimenPixelSize3 = UtilHelper.getDimenPixelSize(R.dimen.M_W_X005);
                int dimenPixelSize4 = UtilHelper.getDimenPixelSize(R.dimen.tbds50);
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dimenPixelSize2, dimenPixelSize2);
                layoutParams.addRule(11);
                layoutParams.addRule(10);
                layoutParams.rightMargin = dimenPixelSize3;
                layoutParams.topMargin = dimenPixelSize4;
                i(layoutParams);
                this.e.setWebPResId(R.drawable.icon_pure_card_close22, R.color.CAM_X0111);
                this.e.setPadding(dimenPixelSize, dimenPixelSize, dimenPixelSize, dimenPixelSize);
                this.e.setLayoutParams(layoutParams);
                return;
            }
            int i = h;
            int f = pi.f(TbadkCoreApplication.getInst(), R.dimen.tbds30);
            int f2 = pi.f(TbadkCoreApplication.getInst(), R.dimen.tbds14);
            int f3 = pi.f(TbadkCoreApplication.getInst(), R.dimen.tbds17);
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(i, i);
            layoutParams2.addRule(11);
            layoutParams2.addRule(10);
            layoutParams2.rightMargin = f2;
            layoutParams2.topMargin = f3;
            i(layoutParams2);
            this.e.setWebPResId(R.drawable.obfuscated_res_0x7f0808f9, R.color.CAM_X0111);
            this.e.setPadding(f, f, f, f);
            this.e.setLayoutParams(layoutParams2);
        }
    }

    public void s(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.e.setAutoProcess(z);
        }
    }

    public void t(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            this.e.setHeadText(str);
        }
    }

    public void u(NEGFeedBackView.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, bVar) == null) {
            this.e.setEventCallback(bVar);
        }
    }

    public final void v(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.e.getLayoutParams();
            if (this.e.getParent() == null || layoutParams == null || layoutParams.topMargin != i) {
                int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds80);
                int dimenPixelSize2 = UtilHelper.getDimenPixelSize(R.dimen.tbds88);
                int dimenPixelSize3 = UtilHelper.getDimenPixelSize(R.dimen.M_W_X005);
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(dimenPixelSize2, dimenPixelSize2);
                layoutParams2.addRule(11);
                layoutParams2.addRule(10);
                layoutParams2.rightMargin = dimenPixelSize3;
                layoutParams2.topMargin = i;
                i(layoutParams2);
                this.e.setWebPResId(R.drawable.icon_pure_card_close22, R.color.CAM_X0111);
                this.e.setPadding(dimenPixelSize, dimenPixelSize, dimenPixelSize, dimenPixelSize);
                this.e.setLayoutParams(layoutParams2);
            }
        }
    }

    public void w(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            this.e.t(z);
        }
    }

    public sx(TbPageContext tbPageContext, Align align) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, align};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        h(-1);
        NEGFeedBackView nEGFeedBackView = new NEGFeedBackView(tbPageContext);
        this.e = nEGFeedBackView;
        nEGFeedBackView.setId(R.id.obfuscated_res_0x7f090740);
        g(this.e);
        l(align);
    }
}

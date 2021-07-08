package d.a.j;

import android.widget.RelativeLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.Align;
import com.baidu.card.view.UnfollowedDecorView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.r.q.b2;
/* loaded from: classes7.dex */
public class r0 extends c implements p<b2>, q {
    public static /* synthetic */ Interceptable $ic;
    public static final int k;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: i  reason: collision with root package name */
    public UnfollowedDecorView f42687i;
    public Align j;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-465751501, "Ld/a/j/r0;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-465751501, "Ld/a/j/r0;");
                return;
            }
        }
        k = d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds124);
    }

    public r0(TbPageContext tbPageContext, Align align) {
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
        UnfollowedDecorView unfollowedDecorView = new UnfollowedDecorView(tbPageContext.getPageActivity());
        this.f42687i = unfollowedDecorView;
        unfollowedDecorView.setId(R.id.decor_item_right_id);
        g(this.f42687i);
        k(align);
    }

    public void k(Align align) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, align) == null) || align == this.j) {
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
            this.f42687i.setWebPResId(R.drawable.icon_pure_card_close22, R.color.CAM_X0111);
            this.f42687i.setPadding(dimenPixelSize, dimenPixelSize, dimenPixelSize, dimenPixelSize);
            this.f42687i.setLayoutParams(layoutParams);
        } else if (align == Align.ALIGN_RIGHT_CENTER) {
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(dimenPixelSize, dimenPixelSize);
            layoutParams2.addRule(11);
            layoutParams2.addRule(15);
            layoutParams2.rightMargin = dimenPixelSize - UtilHelper.getDimenPixelSize(R.dimen.M_W_X005);
            layoutParams2.bottomMargin = 0;
            i(layoutParams2);
            this.f42687i.setWebPResId(R.drawable.icon_pure_card_close22, R.color.CAM_X0111);
            this.f42687i.setPadding(dimenPixelSize, dimenPixelSize, dimenPixelSize, dimenPixelSize);
            this.f42687i.setLayoutParams(layoutParams2);
        } else if (align == Align.ALIGN_RIGHT_BOTTOM) {
            int i2 = k;
            int g2 = d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds30);
            int g3 = d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds14);
            int g4 = d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds20);
            RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(i2, i2);
            layoutParams3.addRule(11);
            layoutParams3.addRule(12);
            layoutParams3.rightMargin = g3;
            layoutParams3.bottomMargin = g4;
            i(layoutParams3);
            this.f42687i.setWebPResId(R.drawable.icon_pure_card_more22, R.color.CAM_X0111);
            this.f42687i.setPadding(g2, g2, g2, g2);
            this.f42687i.setLayoutParams(layoutParams3);
        }
        this.j = align;
    }

    public void l(d.a.o0.r.q.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
            if (aVar.isSupportTop()) {
                k(Align.ALIGN_RIGHT_TOP);
            } else if (aVar.isSupportBottom()) {
                l0 l0Var = this.f42637h;
                if (l0Var != null) {
                    l0Var.n(this);
                }
            } else {
                k(Align.ALIGN_RIGHT_TOP);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.j.p
    /* renamed from: m */
    public void a(b2 b2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, b2Var) == null) {
            this.f42687i.a(b2Var);
        }
    }

    @Override // d.a.j.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048580, this, tbPageContext, i2) == null) {
            this.f42687i.i();
        }
    }
}

package d.a.j;

import android.widget.RelativeLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.view.CardForumHeadLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.r.q.b2;
/* loaded from: classes7.dex */
public class f extends c implements p<b2>, q {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: i  reason: collision with root package name */
    public final CardForumHeadLayout f42641i;
    public int j;
    public int k;
    public int l;

    public f(TbPageContext tbPageContext) {
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
        this.j = d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds10);
        this.k = d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds44);
        this.l = d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds60);
        this.f42641i = new CardForumHeadLayout(tbPageContext.getPageActivity());
        h(-1);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.leftMargin = this.k;
        layoutParams.topMargin = this.j;
        layoutParams.bottomMargin = this.l;
        i(layoutParams);
        g(this.f42641i);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.j.p
    /* renamed from: k */
    public void a(b2 b2Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, b2Var) == null) {
            if (b2Var != null && b2Var.H() != null) {
                this.f42641i.setVisibility(0);
                this.f42641i.setData(b2Var);
                this.f42641i.setTag(b2Var);
                return;
            }
            this.f42641i.setVisibility(8);
        }
    }

    @Override // d.a.j.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, i2) == null) {
            this.f42641i.b();
        }
    }
}

package d.a.j;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.view.BjhArticleLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.j.a;
/* loaded from: classes7.dex */
public class o0 extends h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LinearLayout l;
    public BjhArticleLayout m;
    public d.a.o0.r.q.a n;
    public int o;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ o0 f42685e;

        public a(o0 o0Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {o0Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f42685e = o0Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            o0 o0Var;
            a.InterfaceC0609a interfaceC0609a;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view) == null) || (interfaceC0609a = (o0Var = this.f42685e).f42630i) == null) {
                return;
            }
            interfaceC0609a.a(o0Var.n);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o0(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.o = 3;
    }

    @Override // d.a.j.a
    public View g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.l == null) {
                LinearLayout linearLayout = new LinearLayout(this.f42627f);
                this.l = linearLayout;
                SkinManager.setBackgroundColor(linearLayout, R.color.CAM_X0206);
                this.l.setOrientation(1);
                this.l.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            }
            this.l.removeAllViews();
            if (this.m == null) {
                BjhArticleLayout bjhArticleLayout = new BjhArticleLayout(this.f42627f);
                this.m = bjhArticleLayout;
                bjhArticleLayout.setJumpToPbListener(new a(this));
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.topMargin = this.f42627f.getResources().getDimensionPixelSize(R.dimen.M_H_X004);
            layoutParams.leftMargin = this.f42627f.getResources().getDimensionPixelSize(R.dimen.M_W_X007);
            layoutParams.rightMargin = this.f42627f.getResources().getDimensionPixelSize(R.dimen.M_W_X007);
            layoutParams.bottomMargin = this.f42627f.getResources().getDimensionPixelSize(R.dimen.M_H_X005);
            this.l.addView(this.m, layoutParams);
            return this.l;
        }
        return (View) invokeV.objValue;
    }

    @Override // d.a.j.a
    public void l(d.a.p0.a0.b0<d.a.o0.r.q.a> b0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, b0Var) == null) {
            super.l(b0Var);
            BjhArticleLayout bjhArticleLayout = this.m;
            if (bjhArticleLayout != null) {
                bjhArticleLayout.setSubClickListener(b0Var);
            }
        }
    }

    @Override // d.a.j.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048579, this, tbPageContext, i2) == null) || i2 == this.o) {
            return;
        }
        this.o = i2;
        SkinManager.setBackgroundColor(this.l, R.color.CAM_X0206);
        BjhArticleLayout bjhArticleLayout = this.m;
        if (bjhArticleLayout != null) {
            bjhArticleLayout.onChangeSkinType(tbPageContext, i2);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.j.p
    /* renamed from: t */
    public void a(d.a.o0.r.q.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) {
            this.n = aVar;
            BjhArticleLayout bjhArticleLayout = this.m;
            if (bjhArticleLayout != null) {
                bjhArticleLayout.a(aVar);
            }
        }
    }

    public void u(a.InterfaceC0609a interfaceC0609a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, interfaceC0609a) == null) {
            this.f42630i = interfaceC0609a;
        }
    }
}

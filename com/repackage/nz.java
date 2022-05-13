package com.repackage;

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
import com.repackage.zx;
/* loaded from: classes6.dex */
public class nz extends gy {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LinearLayout h;
    public BjhArticleLayout i;
    public zn4 j;
    public int k;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ nz a;

        public a(nz nzVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {nzVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = nzVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            nz nzVar;
            zx.a aVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || (aVar = (nzVar = this.a).e) == null) {
                return;
            }
            aVar.a(nzVar.j);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public nz(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.k = 3;
    }

    @Override // com.repackage.zx
    public View g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (this.h == null) {
                LinearLayout linearLayout = new LinearLayout(this.b);
                this.h = linearLayout;
                SkinManager.setBackgroundColor(linearLayout, R.color.CAM_X0206);
                this.h.setOrientation(1);
                this.h.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            }
            this.h.removeAllViews();
            if (this.i == null) {
                BjhArticleLayout bjhArticleLayout = new BjhArticleLayout(this.b);
                this.i = bjhArticleLayout;
                bjhArticleLayout.setJumpToPbListener(new a(this));
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            layoutParams.topMargin = this.b.getResources().getDimensionPixelSize(R.dimen.M_H_X004);
            layoutParams.leftMargin = this.b.getResources().getDimensionPixelSize(R.dimen.M_W_X007);
            layoutParams.rightMargin = this.b.getResources().getDimensionPixelSize(R.dimen.M_W_X007);
            layoutParams.bottomMargin = this.b.getResources().getDimensionPixelSize(R.dimen.M_H_X005);
            this.h.addView(this.i, layoutParams);
            return this.h;
        }
        return (View) invokeV.objValue;
    }

    @Override // com.repackage.zx
    public void l(ux5<zn4> ux5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, ux5Var) == null) {
            super.l(ux5Var);
            BjhArticleLayout bjhArticleLayout = this.i;
            if (bjhArticleLayout != null) {
                bjhArticleLayout.setSubClickListener(ux5Var);
            }
        }
    }

    @Override // com.repackage.py
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048579, this, tbPageContext, i) == null) || i == this.k) {
            return;
        }
        this.k = i;
        SkinManager.setBackgroundColor(this.h, R.color.CAM_X0206);
        BjhArticleLayout bjhArticleLayout = this.i;
        if (bjhArticleLayout != null) {
            bjhArticleLayout.onChangeSkinType(tbPageContext, i);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.oy
    /* renamed from: t */
    public void a(zn4 zn4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, zn4Var) == null) {
            this.j = zn4Var;
            BjhArticleLayout bjhArticleLayout = this.i;
            if (bjhArticleLayout != null) {
                bjhArticleLayout.a(zn4Var);
            }
        }
    }

    public void u(zx.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, aVar) == null) {
            this.e = aVar;
        }
    }
}

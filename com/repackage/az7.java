package com.repackage;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.rw;
/* loaded from: classes5.dex */
public class az7 extends ty7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ThreadData f;
    public fo4 g;
    public gx h;
    public View i;

    /* loaded from: classes5.dex */
    public class a extends fo4 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ az7 a;

        public a(az7 az7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {az7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = az7Var;
        }

        @Override // com.repackage.fo4
        public cq4 getNegFeedBackData() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return null;
            }
            return (cq4) invokeV.objValue;
        }

        @Override // com.repackage.fo4
        public ThreadData getThreadData() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.a.f : (ThreadData) invokeV.objValue;
        }

        @Override // com.baidu.tieba.card.data.BaseCardInfo, com.repackage.on
        public BdUniqueId getType() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
                return null;
            }
            return (BdUniqueId) invokeV.objValue;
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ az7 a;

        public b(az7 az7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {az7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = az7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            az7 az7Var;
            rw.a aVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || (aVar = (az7Var = this.a).c) == null) {
                return;
            }
            aVar.a(az7Var.g);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public az7(TbPageContext tbPageContext, int i) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, Integer.valueOf(i)};
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
    }

    @Override // com.repackage.ty7
    public View a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.h == null) {
                gx gxVar = new gx(this.a.getPageActivity());
                this.h = gxVar;
                gxVar.o(Boolean.TRUE);
                this.h.y("pb");
                this.h.A(0);
                this.h.F(this.a.getResources().getDimensionPixelOffset(R.dimen.M_W_X007), this.a.getResources().getDimensionPixelOffset(R.dimen.M_H_X005), this.a.getResources().getDimensionPixelOffset(R.dimen.M_W_X007), this.a.getResources().getDimensionPixelSize(R.dimen.M_H_X005));
                this.h.G(false);
                this.h.E(true);
            }
            View h = this.h.h();
            this.i = h;
            return h;
        }
        return (View) invokeV.objValue;
    }

    @Override // com.repackage.ty7
    public void b(TbPageContext tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbPageContext, i) == null) || this.e == i) {
            return;
        }
        this.e = i;
        SkinManager.setBackgroundColor(this.i, R.color.CAM_X0204);
        gx gxVar = this.h;
        if (gxVar != null) {
            gxVar.onChangeSkinType(tbPageContext, i);
        }
    }

    @Override // com.repackage.ty7
    public void c(OriginalThreadInfo originalThreadInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, originalThreadInfo) == null) {
            this.d = originalThreadInfo;
            this.f = originalThreadInfo == null ? null : originalThreadInfo.b();
            a aVar = new a(this);
            this.g = aVar;
            gx gxVar = this.h;
            if (gxVar != null) {
                gxVar.a(aVar);
            }
        }
    }

    @Override // com.repackage.ty7
    public void d(rw.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, aVar) == null) {
            super.d(aVar);
            gx gxVar = this.h;
            if (gxVar != null) {
                gxVar.B(aVar);
            }
            View view2 = this.i;
            if (view2 != null) {
                view2.setOnClickListener(new b(this));
            }
        }
    }

    @Override // com.repackage.ty7
    public void e(b06 b06Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, b06Var) == null) {
            super.e(b06Var);
            gx gxVar = this.h;
            if (gxVar != null) {
                gxVar.m(this.b);
            }
        }
    }
}

package com.repackage;

import android.content.Context;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.view.CardUserInfoLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class pw extends mw<om4> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public CardUserInfoLayout f;
    public int g;
    public om4 h;
    public b i;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pw a;

        public a(pw pwVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {pwVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = pwVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.i != null) {
                    this.a.i.a(this.a.h, view2);
                }
                if (this.a.d() != null) {
                    this.a.d().a(view2, this.a.h);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public interface b {
        void a(om4 om4Var, View view2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public pw(Context context) {
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
        this.g = 34053;
        if ((TbadkCoreApplication.getInst().getPersonalizeViewData().c instanceof CardUserInfoLayout) && TbadkCoreApplication.getInst().getPersonalizeViewData().c.getParent() == null) {
            this.f = (CardUserInfoLayout) TbadkCoreApplication.getInst().getPersonalizeViewData().c;
        } else {
            this.f = new CardUserInfoLayout(context);
        }
        this.f.setShowFlag(this.g);
        this.f.setUserAfterClickListener(new a(this));
    }

    @Override // com.repackage.mw
    public void b(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            int i2 = i | this.g;
            this.g = i2;
            u(i2);
        }
    }

    @Override // com.repackage.mw
    public void c(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            int i2 = (~i) & this.g;
            this.g = i2;
            u(i2);
        }
    }

    @Override // com.repackage.mw
    public View g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.f : (View) invokeV.objValue;
    }

    @Override // com.repackage.cx
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048580, this, tbPageContext, i) == null) {
            this.f.onChangeSkinType(tbPageContext, i);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.bx
    /* renamed from: q */
    public void a(om4 om4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, om4Var) == null) {
            this.h = om4Var;
            this.f.setData(om4Var.getThreadData());
        }
    }

    public void r(boolean z) {
        CardUserInfoLayout cardUserInfoLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048582, this, z) == null) || (cardUserInfoLayout = this.f) == null || cardUserInfoLayout.getAvatar() == null) {
            return;
        }
        this.f.getAvatar().setClickable(z);
    }

    public void s(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bVar) == null) {
            this.i = bVar;
        }
    }

    public void t(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bdUniqueId) == null) {
            this.f.setPageUniqueId(bdUniqueId);
        }
    }

    public void u(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i) == null) {
            this.f.setShowFlag(this.g);
        }
    }

    public void v(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, tbPageContext) == null) {
            this.f.setPageContext(tbPageContext);
        }
    }

    public void w(boolean z) {
        CardUserInfoLayout cardUserInfoLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048587, this, z) == null) || (cardUserInfoLayout = this.f) == null || cardUserInfoLayout.getUserName() == null) {
            return;
        }
        this.f.getUserName().setClickable(z);
    }
}

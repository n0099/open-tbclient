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
/* loaded from: classes7.dex */
public class tw extends qw<nn4> implements fw8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public CardUserInfoLayout f;
    public int g;
    public nn4 h;
    public b i;

    /* loaded from: classes7.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ tw a;

        public a(tw twVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {twVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = twVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.a.i != null) {
                    this.a.i.a(this.a.h, view2);
                }
                if (this.a.e() != null) {
                    this.a.e().a(view2, this.a.h);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface b {
        void a(nn4 nn4Var, View view2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public tw(Context context) {
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

    @Override // com.repackage.fw8
    public void b() {
        CardUserInfoLayout cardUserInfoLayout;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (cardUserInfoLayout = this.f) != null && cardUserInfoLayout.isHasPlayVirtualImage()) {
            this.f.recoverVirtualImageAnimate();
            this.f.setHasPlayVirtualImage(false);
        }
    }

    @Override // com.repackage.qw
    public void c(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            int i2 = i | this.g;
            this.g = i2;
            v(i2);
        }
    }

    @Override // com.repackage.qw
    public void d(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            int i2 = (~i) & this.g;
            this.g = i2;
            v(i2);
        }
    }

    @Override // com.repackage.qw
    public View h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f : (View) invokeV.objValue;
    }

    @Override // com.repackage.hx
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048581, this, tbPageContext, i) == null) {
            this.f.onChangeSkinType(tbPageContext, i);
        }
    }

    @Override // com.repackage.fw8
    public void play() {
        CardUserInfoLayout cardUserInfoLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || (cardUserInfoLayout = this.f) == null || !cardUserInfoLayout.isVirtualImage() || this.h.getThreadData().isHasPlayVirtualImage()) {
            return;
        }
        this.f.startVirtualImageAnimate();
        this.f.setHasPlayVirtualImage(true);
        this.h.getThreadData().setHasPlayVirtualImage(true);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.gx
    /* renamed from: r */
    public void a(nn4 nn4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, nn4Var) == null) {
            this.h = nn4Var;
            this.f.setData(nn4Var.getThreadData());
        }
    }

    public void s(boolean z) {
        CardUserInfoLayout cardUserInfoLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) || (cardUserInfoLayout = this.f) == null || cardUserInfoLayout.getAvatar() == null) {
            return;
        }
        this.f.getAvatar().setClickable(z);
    }

    public void t(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bVar) == null) {
            this.i = bVar;
        }
    }

    public void u(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, bdUniqueId) == null) {
            this.f.setPageUniqueId(bdUniqueId);
        }
    }

    public void v(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i) == null) {
            this.f.setShowFlag(this.g);
        }
    }

    public void w(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, tbPageContext) == null) {
            this.f.setPageContext(tbPageContext);
        }
    }

    public void x(boolean z) {
        CardUserInfoLayout cardUserInfoLayout;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048589, this, z) == null) || (cardUserInfoLayout = this.f) == null || cardUserInfoLayout.getUserName() == null) {
            return;
        }
        this.f.getUserName().setClickable(z);
    }
}

package com.repackage;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class qu4 implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public LikeModel b;
    public pu4 c;
    public ru4 d;
    public View.OnClickListener e;
    public CustomMessageListener f;
    public CustomMessageListener g;
    public a9 h;

    /* loaded from: classes7.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qu4 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(qu4 qu4Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qu4Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qu4Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof cn8)) {
                cn8 cn8Var = (cn8) customResponsedMessage.getData();
                String l = Long.toString(cn8Var.a);
                if (this.a.d != null && l.equals(this.a.d.b()) && cn8Var.b) {
                    this.a.d.setIsLike(true);
                    this.a.d.c(true);
                    this.a.c.c(true);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qu4 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(qu4 qu4Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qu4Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qu4Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof cn8)) {
                cn8 cn8Var = (cn8) customResponsedMessage.getData();
                String l = Long.toString(cn8Var.a);
                if (this.a.d != null && l.equals(this.a.d.b()) && cn8Var.b) {
                    this.a.d.setIsLike(false);
                    this.a.d.c(false);
                    this.a.c.c(false);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c extends a9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qu4 a;

        public c(qu4 qu4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qu4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qu4Var;
        }

        @Override // com.repackage.a9
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, obj) == null) && (obj instanceof ck8) && ((ck8) obj).d() != 0) {
                if (AntiHelper.m(this.a.b.getErrorCode(), this.a.b.getErrorString())) {
                    AntiHelper.u(this.a.a.getPageActivity(), this.a.b.getErrorString());
                } else {
                    this.a.a.showToast(this.a.b.getErrorString());
                }
            }
        }
    }

    public qu4(TbPageContext tbPageContext, pu4 pu4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, pu4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f = new a(this, 2001437);
        this.g = new b(this, 2001438);
        this.h = new c(this);
        this.a = tbPageContext;
        LikeModel likeModel = new LikeModel(tbPageContext);
        this.b = likeModel;
        likeModel.setLoadDataCallBack(this.h);
        this.c = pu4Var;
        pu4Var.b(this);
        tbPageContext.registerListener(this.f);
        tbPageContext.registerListener(this.g);
    }

    public void e(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, onClickListener) == null) {
            this.e = onClickListener;
        }
    }

    public void f(ru4 ru4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ru4Var) == null) || ru4Var == null) {
            return;
        }
        this.d = ru4Var;
        this.c.c(ru4Var.getIsLike());
    }

    public void g(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bdUniqueId) == null) {
            this.f.setTag(bdUniqueId);
            this.g.setTag(bdUniqueId);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, view2) == null) {
            pu4 pu4Var = this.c;
            if (pu4Var != null) {
                pu4Var.a(view2);
            }
            if (!mi.z()) {
                this.a.showToast(R.string.obfuscated_res_0x7f0f0c17);
                return;
            }
            if (ViewHelper.checkUpIsLogin(this.a.getPageActivity())) {
                ru4 ru4Var = this.d;
                if (ru4Var == null) {
                    return;
                }
                this.b.P(ru4Var.a(), this.d.b());
            }
            View.OnClickListener onClickListener = this.e;
            if (onClickListener != null) {
                onClickListener.onClick(view2);
            }
        }
    }
}

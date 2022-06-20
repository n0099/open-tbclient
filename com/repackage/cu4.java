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
/* loaded from: classes5.dex */
public class cu4 implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public LikeModel b;
    public bu4 c;
    public du4 d;
    public View.OnClickListener e;
    public CustomMessageListener f;
    public CustomMessageListener g;
    public c9 h;

    /* loaded from: classes5.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cu4 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(cu4 cu4Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cu4Var, Integer.valueOf(i)};
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
            this.a = cu4Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof sj8)) {
                sj8 sj8Var = (sj8) customResponsedMessage.getData();
                String l = Long.toString(sj8Var.a);
                if (this.a.d != null && l.equals(this.a.d.d()) && sj8Var.b) {
                    this.a.d.setIsLike(true);
                    this.a.d.e(true);
                    this.a.c.c(true);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cu4 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(cu4 cu4Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cu4Var, Integer.valueOf(i)};
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
            this.a = cu4Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof sj8)) {
                sj8 sj8Var = (sj8) customResponsedMessage.getData();
                String l = Long.toString(sj8Var.a);
                if (this.a.d != null && l.equals(this.a.d.d()) && sj8Var.b) {
                    this.a.d.setIsLike(false);
                    this.a.d.e(false);
                    this.a.c.c(false);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends c9 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cu4 a;

        public c(cu4 cu4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cu4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cu4Var;
        }

        @Override // com.repackage.c9
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, obj) == null) && (obj instanceof tg8) && ((tg8) obj).d() != 0) {
                if (AntiHelper.m(this.a.b.getErrorCode(), this.a.b.getErrorString())) {
                    AntiHelper.u(this.a.a.getPageActivity(), this.a.b.getErrorString());
                } else {
                    this.a.a.showToast(this.a.b.getErrorString());
                }
            }
        }
    }

    public cu4(TbPageContext tbPageContext, bu4 bu4Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bu4Var};
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
        this.c = bu4Var;
        bu4Var.b(this);
        tbPageContext.registerListener(this.f);
        tbPageContext.registerListener(this.g);
    }

    public void e(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, onClickListener) == null) {
            this.e = onClickListener;
        }
    }

    public void f(du4 du4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, du4Var) == null) || du4Var == null) {
            return;
        }
        this.d = du4Var;
        this.c.c(du4Var.getIsLike());
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
            bu4 bu4Var = this.c;
            if (bu4Var != null) {
                bu4Var.a(view2);
            }
            if (!ni.z()) {
                this.a.showToast(R.string.obfuscated_res_0x7f0f0c37);
                return;
            }
            if (ViewHelper.checkUpIsLogin(this.a.getPageActivity())) {
                du4 du4Var = this.d;
                if (du4Var == null) {
                    return;
                }
                this.b.Q(du4Var.c(), this.d.d());
            }
            View.OnClickListener onClickListener = this.e;
            if (onClickListener != null) {
                onClickListener.onClick(view2);
            }
        }
    }
}

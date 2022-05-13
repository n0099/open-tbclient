package com.repackage;

import android.content.Context;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.view.ThreadGodReplyLayout;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.vz;
/* loaded from: classes6.dex */
public class my extends gy {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ThreadGodReplyLayout h;
    public zn4 i;
    public StatisticItem j;

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ my a;

        public a(my myVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {myVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = myVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, view2) == null) || this.a.d() == null) {
                return;
            }
            this.a.d().a(view2, this.a.i);
        }
    }

    /* loaded from: classes6.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ View.OnClickListener a;
        public final /* synthetic */ my b;

        public b(my myVar, View.OnClickListener onClickListener) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {myVar, onClickListener};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = myVar;
            this.a = onClickListener;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                PbActivityConfig pbActivityConfig = new PbActivityConfig(this.b.b);
                String tid = this.b.i.getThreadData().getTid();
                PbActivityConfig createNormalCfg = pbActivityConfig.createNormalCfg(tid, this.b.i.getThreadData().getTopAgreePost().I() + "", 1, "other");
                createNormalCfg.setStartFrom(this.b.a.i());
                MessageManager.getInstance().sendMessage(new CustomMessage(2004001, createNormalCfg));
                this.b.a.o(new vz.a(1));
                this.a.onClick(view2);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements vz.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ my a;

        public c(my myVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {myVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = myVar;
        }

        @Override // com.repackage.vz.b
        public boolean a(vz.a aVar) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) {
                fx5.l(this.a.h.getGodReplyContent(), this.a.i.getThreadData().getId(), R.color.CAM_X0105, R.color.CAM_X0109);
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public my(Context context) {
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
        r(mi.f(context, R.dimen.M_H_X003));
        if ((TbadkCoreApplication.getInst().getPersonalizeViewData().q instanceof ThreadGodReplyLayout) && TbadkCoreApplication.getInst().getPersonalizeViewData().q.getParent() == null) {
            this.h = (ThreadGodReplyLayout) TbadkCoreApplication.getInst().getPersonalizeViewData().q;
        } else {
            this.h = new ThreadGodReplyLayout(context);
        }
        a aVar = new a(this);
        this.h.setAfterClickListener(aVar);
        this.h.setOnClickListener(new b(this, aVar));
    }

    @Override // com.repackage.zx
    public View g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.h : (View) invokeV.objValue;
    }

    @Override // com.repackage.zx
    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            i(1, new c(this));
        }
    }

    @Override // com.repackage.py
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, tbPageContext, i) == null) {
            this.h.k();
        }
    }

    public boolean u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            ThreadGodReplyLayout threadGodReplyLayout = this.h;
            return threadGodReplyLayout == null || threadGodReplyLayout.getVisibility() != 8;
        }
        return invokeV.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.oy
    /* renamed from: v */
    public void a(zn4 zn4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, zn4Var) == null) {
            this.i = zn4Var;
            PostData topAgreePost = zn4Var.getThreadData().getTopAgreePost();
            if (this.j != null && topAgreePost != null && topAgreePost.s() != null && topAgreePost.s().getUserId() != null) {
                this.j.param("tid", zn4Var.getThreadData().tid).param("post_id", topAgreePost.I()).param("uid", topAgreePost.s().getUserId());
                nx5.b().a(this.j);
            }
            this.h.setData(zn4Var.getThreadData());
        }
    }

    public void w(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.h.setFrom(str);
        }
    }

    public void x(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.h.setFromCDN(z);
        }
    }

    public void y(StatisticItem statisticItem) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, statisticItem) == null) {
            this.j = statisticItem;
        }
    }
}

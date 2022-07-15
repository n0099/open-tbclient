package com.repackage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.ThreadCardViewHolder;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.NetWork;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.NEGFeedBack.NEGFeedBackView;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.cy;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public class qt6 extends an<zt6, ThreadCardViewHolder<zt6>> implements ck5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BdUniqueId i;
    public TbPageContext<?> j;
    public tn k;
    public String l;
    public NEGFeedBackView.b m;

    /* loaded from: classes7.dex */
    public class a implements NEGFeedBackView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qt6 a;

        public a(qt6 qt6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qt6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qt6Var;
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
        public void a(ArrayList<Integer> arrayList, String str, kp4 kp4Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeLLL(1048576, this, arrayList, str, kp4Var) == null) || arrayList == null || kp4Var == null) {
                return;
            }
            CustomMessage customMessage = new CustomMessage(2921425, this.a.j.getUniqueId());
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2921425);
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            new b(this.a, null).execute(new Integer[0]);
            TiebaStatic.log(new StatisticItem("c13572"));
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
        public void b(kp4 kp4Var, CompoundButton compoundButton, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, kp4Var, compoundButton, z) == null) {
            }
        }

        @Override // com.baidu.tieba.NEGFeedBack.NEGFeedBackView.b
        public void c(kp4 kp4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, kp4Var) == null) {
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends BdAsyncTask<Integer, Integer, String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public NetWork a;

        public b(qt6 qt6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qt6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = null;
        }

        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void cancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                super.cancel(true);
                NetWork netWork = this.a;
                if (netWork != null) {
                    netWork.cancelNetConnect();
                    this.a = null;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public String doInBackground(Integer... numArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, numArr)) == null) {
                try {
                    NetWork netWork = new NetWork();
                    this.a = netWork;
                    netWork.setUrl(TbConfig.SERVER_ADDRESS + TbConfig.CONCERN_RECOMMEND_FEEDBACK);
                    this.a.addPostData("dislike_from", "concernpage");
                    this.a.addPostData("dislike_type", "1");
                    this.a.getNetContext().getRequest().mIsNeedTbs = true;
                    return this.a.postNetData();
                } catch (Exception e) {
                    BdLog.e(e.getMessage());
                    return null;
                }
            }
            return (String) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
                super.onPostExecute((b) str);
            }
        }

        public /* synthetic */ b(qt6 qt6Var, a aVar) {
            this(qt6Var);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public qt6(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.m = new a(this);
        this.j = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.an
    /* renamed from: a0 */
    public ThreadCardViewHolder M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            cy.b bVar = new cy.b(this.j.getPageActivity(), false);
            gu6 gu6Var = new gu6(this.j, this.i);
            gu6Var.q(true);
            bVar.n(gu6Var);
            bVar.l().c(0);
            bVar.l().f(0);
            bVar.l().e(0);
            bVar.l().h(0);
            ThreadCardViewHolder threadCardViewHolder = new ThreadCardViewHolder(bVar.k(BaseCardInfo.SupportType.FULL, viewGroup, this.k));
            threadCardViewHolder.k(this.i);
            sx q = threadCardViewHolder.q(false);
            q.u(this.m);
            q.s(false);
            q.t(this.a.getString(R.string.obfuscated_res_0x7f0f0421));
            q.w(true);
            q.g = true;
            return threadCardViewHolder;
        }
        return (ThreadCardViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.an
    /* renamed from: b0 */
    public View S(int i, View view2, ViewGroup viewGroup, zt6 zt6Var, ThreadCardViewHolder<zt6> threadCardViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), view2, viewGroup, zt6Var, threadCardViewHolder})) == null) {
            if (zt6Var == null || threadCardViewHolder == null || threadCardViewHolder.b() == null) {
                return null;
            }
            StatisticItem statisticItem = new StatisticItem("c13565");
            statisticItem.param("obj_source", zt6Var.g() ? 1 : 2);
            cy5.b().a(statisticItem);
            threadCardViewHolder.c().q(i);
            if (threadCardViewHolder.c() instanceof bk5) {
                threadCardViewHolder.c().b(this.l);
            }
            threadCardViewHolder.g(zt6Var);
            threadCardViewHolder.c().onChangeSkinType(this.j, TbadkCoreApplication.getInst().getSkinType());
            return threadCardViewHolder.b();
        }
        return (View) invokeCommon.objValue;
    }

    public void c0(tn tnVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, tnVar) == null) {
            this.k = tnVar;
        }
    }

    @Override // com.repackage.ck5
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.l = str;
        }
    }
}

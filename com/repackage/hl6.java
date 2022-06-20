package com.repackage;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.TiebaStaticHelper;
import com.baidu.tbadk.core.util.YYLiveUtil;
import com.baidu.tbadk.pageInfo.TbPageTag;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class hl6 implements CustomMessageTask.CustomRunnable<ThreadData>, kx5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public qn6 a;
    public TbPageTag b;
    public BdUniqueId c;
    public int d;

    public hl6(qn6 qn6Var, TbPageTag tbPageTag, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {qn6Var, tbPageTag, bdUniqueId};
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
        this.b = null;
        this.a = qn6Var;
        this.b = tbPageTag;
        this.c = bdUniqueId;
    }

    @Override // com.repackage.kx5
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
        }
    }

    public final void b(ThreadData threadData) {
        String str;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, threadData) == null) || threadData == null || threadData.getAuthor() == null || threadData.getThreadAlaInfo() == null) {
            return;
        }
        long j = threadData.getThreadAlaInfo().user_info != null ? threadData.getThreadAlaInfo().user_info.ala_id : 0L;
        StatisticItem statisticItem = new StatisticItem("c13615");
        statisticItem.param("uid", threadData.getAuthor().getUserId());
        statisticItem.param("fid", threadData.getFid());
        statisticItem.param("ab_tag", threadData.mRecomAbTag);
        statisticItem.param("obj_type", threadData.getThreadAlaInfo().isChushou ? 2 : 1);
        statisticItem.param("tid", threadData.getTid());
        statisticItem.param("liveid", threadData.getThreadAlaInfo().live_id);
        statisticItem.param(TiebaStatic.Params.STAR_ID, j);
        statisticItem.param("extra", threadData.mRecomExtra);
        statisticItem.param("source_from", threadData.mRecomSource);
        int i = this.d;
        if (i == 14) {
            statisticItem.param("obj_locate", 1);
        } else if (i == 13) {
            statisticItem.param("obj_locate", 2);
        }
        if (threadData.getAuthor() != null && threadData.getAuthor().getAlaInfo() != null) {
            statisticItem.param("obj_param1", YYLiveUtil.calculateLiveType(threadData.getAuthor().getAlaInfo()));
            if (threadData.getAuthor().getAlaInfo().mYyExtData != null) {
                TiebaStaticHelper.addYYParam(statisticItem, threadData.getAuthor().getAlaInfo().mYyExtData);
                str = TiebaStatic.YYValues.YY_LIVE;
            } else {
                str = "";
            }
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, str);
        }
        TiebaStatic.log(statisticItem);
    }

    public final void c(ThreadData threadData) {
        String str;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, threadData) == null) || threadData == null || threadData.getAuthor() == null || threadData.getThreadAlaInfo() == null) {
            return;
        }
        long j = threadData.getThreadAlaInfo().user_info != null ? threadData.getThreadAlaInfo().user_info.ala_id : 0L;
        StatisticItem statisticItem = new StatisticItem("c13614");
        statisticItem.param("uid", threadData.getAuthor().getUserId());
        statisticItem.param("fid", threadData.getFid());
        statisticItem.param("ab_tag", threadData.mRecomAbTag);
        statisticItem.param("obj_type", threadData.getThreadAlaInfo().isChushou ? 2 : 1);
        statisticItem.param("tid", threadData.getTid());
        statisticItem.param("liveid", threadData.getThreadAlaInfo().live_id);
        statisticItem.param(TiebaStatic.Params.STAR_ID, j);
        statisticItem.param("extra", threadData.mRecomExtra);
        statisticItem.param("source_from", threadData.mRecomSource);
        int i = this.d;
        if (i == 14) {
            statisticItem.param("obj_locate", 1);
        } else if (i == 13) {
            statisticItem.param("obj_locate", 2);
        }
        if (threadData.getAuthor() != null && threadData.getAuthor().getAlaInfo() != null) {
            statisticItem.param("obj_param1", YYLiveUtil.calculateLiveType(threadData.getAuthor().getAlaInfo()));
            if (threadData.getAuthor().getAlaInfo().mYyExtData != null) {
                TiebaStaticHelper.addYYParam(statisticItem, threadData.getAuthor().getAlaInfo().mYyExtData);
                str = TiebaStatic.YYValues.YY_LIVE;
            } else {
                str = "";
            }
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, str);
        }
        fx5.b().a(statisticItem);
    }

    public void d(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            this.d = i;
        }
    }

    @Override // com.repackage.kx5
    public void q(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.CustomMessage] */
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<ThreadData> customMessage) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, customMessage)) == null) {
            if (customMessage != null && (customMessage.getData() instanceof ThreadData)) {
                ThreadData data = customMessage.getData();
                if (customMessage.getCmd() == 2921018) {
                    b(data);
                    rn6.k().h(this.a, data, 1);
                    pn6.e(data, 1, this.c, this.a, this.b);
                } else if (customMessage.getCmd() == 2921016) {
                    b(data);
                    rn6.k().h(this.a, data, 2);
                    pn6.e(data, 2, this.c, this.a, this.b);
                } else if (customMessage.getCmd() == 2921019) {
                    b(data);
                    rn6.k().h(this.a, data, 4);
                    pn6.e(data, 1, this.c, this.a, this.b);
                } else if (customMessage.getCmd() == 2921017) {
                    c(data);
                    rn6.k().c(this.a, data);
                    pn6.o(data, this.c, this.a, this.b);
                }
            }
            return null;
        }
        return (CustomResponsedMessage) invokeL.objValue;
    }
}

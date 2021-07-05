package d.a.s0.u0.c2;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.ala.atomdata.AlaSDKShareEmptyActivityConfig;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.pageInfo.TbPageTag;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.r0.r.q.b2;
import d.a.s0.a0.t;
import d.a.s0.a0.z;
/* loaded from: classes9.dex */
public class b implements CustomMessageTask.CustomRunnable<b2>, z {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public d.a.s0.u0.j2.b f65821e;

    /* renamed from: f  reason: collision with root package name */
    public TbPageTag f65822f;

    /* renamed from: g  reason: collision with root package name */
    public BdUniqueId f65823g;

    /* renamed from: h  reason: collision with root package name */
    public int f65824h;

    public b(d.a.s0.u0.j2.b bVar, TbPageTag tbPageTag, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar, tbPageTag, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f65821e = null;
        this.f65822f = null;
        this.f65821e = bVar;
        this.f65822f = tbPageTag;
        this.f65823g = bdUniqueId;
    }

    @Override // d.a.s0.a0.z
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
        }
    }

    public final void b(b2 b2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, b2Var) == null) || b2Var == null || b2Var.H() == null || b2Var.g1() == null) {
            return;
        }
        long j = b2Var.g1().user_info != null ? b2Var.g1().user_info.ala_id : 0L;
        StatisticItem statisticItem = new StatisticItem("c13615");
        statisticItem.param("uid", b2Var.H().getUserId());
        statisticItem.param("fid", b2Var.Q());
        statisticItem.param("ab_tag", b2Var.V0);
        statisticItem.param("obj_type", b2Var.g1().isChushou ? 2 : 1);
        statisticItem.param("tid", b2Var.n1());
        statisticItem.param(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_LIVE_ID, b2Var.g1().live_id);
        statisticItem.param(TiebaStatic.Params.STAR_ID, j);
        statisticItem.param("extra", b2Var.W0);
        statisticItem.param("source_from", b2Var.T0);
        int i2 = this.f65824h;
        if (i2 == 14) {
            statisticItem.param("obj_locate", 1);
        } else if (i2 == 13) {
            statisticItem.param("obj_locate", 2);
        }
        TiebaStatic.log(statisticItem);
    }

    public final void c(b2 b2Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, b2Var) == null) || b2Var == null || b2Var.H() == null || b2Var.g1() == null) {
            return;
        }
        long j = b2Var.g1().user_info != null ? b2Var.g1().user_info.ala_id : 0L;
        StatisticItem statisticItem = new StatisticItem("c13614");
        statisticItem.param("uid", b2Var.H().getUserId());
        statisticItem.param("fid", b2Var.Q());
        statisticItem.param("ab_tag", b2Var.V0);
        statisticItem.param("obj_type", b2Var.g1().isChushou ? 2 : 1);
        statisticItem.param("tid", b2Var.n1());
        statisticItem.param(AlaSDKShareEmptyActivityConfig.SHARE_ALA_SDK_LIVE_ID, b2Var.g1().live_id);
        statisticItem.param(TiebaStatic.Params.STAR_ID, j);
        statisticItem.param("extra", b2Var.W0);
        statisticItem.param("source_from", b2Var.T0);
        int i2 = this.f65824h;
        if (i2 == 14) {
            statisticItem.param("obj_locate", 1);
        } else if (i2 == 13) {
            statisticItem.param("obj_locate", 2);
        }
        t.b().a(statisticItem);
    }

    public void d(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.f65824h = i2;
        }
    }

    @Override // d.a.s0.a0.z
    public void r(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.baidu.adp.framework.message.CustomMessage] */
    @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
    public CustomResponsedMessage<?> run(CustomMessage<b2> customMessage) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, customMessage)) == null) {
            if (customMessage != null && (customMessage.getData() instanceof b2)) {
                b2 data = customMessage.getData();
                if (customMessage.getCmd() == 2921018) {
                    b(data);
                    d.a.s0.u0.j2.c.j().g(this.f65821e, data, 1);
                    d.a.s0.u0.j2.a.c(data, 1, this.f65823g, this.f65821e, this.f65822f);
                } else if (customMessage.getCmd() == 2921016) {
                    b(data);
                    d.a.s0.u0.j2.c.j().g(this.f65821e, data, 2);
                    d.a.s0.u0.j2.a.c(data, 2, this.f65823g, this.f65821e, this.f65822f);
                } else if (customMessage.getCmd() == 2921019) {
                    b(data);
                    d.a.s0.u0.j2.c.j().g(this.f65821e, data, 4);
                    d.a.s0.u0.j2.a.c(data, 1, this.f65823g, this.f65821e, this.f65822f);
                } else if (customMessage.getCmd() == 2921017) {
                    c(data);
                    d.a.s0.u0.j2.c.j().c(this.f65821e, data);
                    d.a.s0.u0.j2.a.j(data, this.f65823g, this.f65821e, this.f65822f);
                }
            }
            return null;
        }
        return (CustomResponsedMessage) invokeL.objValue;
    }
}

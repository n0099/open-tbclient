package d.a.s0.l0.i.d;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.hotuserrank.model.HotUserRankHttpResMsg;
import com.baidu.tieba.enterForum.hotuserrank.model.HotUserRankReqMsg;
import com.baidu.tieba.enterForum.hotuserrank.model.HotUserRankSocketResMsg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.s0.l0.i.c.c;
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public BdUniqueId f62927a;

    /* renamed from: b  reason: collision with root package name */
    public int f62928b;

    /* renamed from: c  reason: collision with root package name */
    public c f62929c;

    /* renamed from: d  reason: collision with root package name */
    public b f62930d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.c.c.g.a f62931e;

    /* renamed from: d.a.s0.l0.i.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C1567a extends d.a.c.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f62932a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1567a(a aVar, int i2, int i3) {
            super(i2, i3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f62932a = aVar;
        }

        @Override // d.a.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) || responsedMessage == null) {
                return;
            }
            if (responsedMessage.getOrginalMessage() == null || responsedMessage.getOrginalMessage().getTag() == this.f62932a.f62927a) {
                c cVar = null;
                if (responsedMessage instanceof HotUserRankHttpResMsg) {
                    cVar = ((HotUserRankHttpResMsg) responsedMessage).getPageData();
                } else if (responsedMessage instanceof HotUserRankSocketResMsg) {
                    cVar = ((HotUserRankSocketResMsg) responsedMessage).getPageData();
                }
                if (responsedMessage.getError() == 0) {
                    if (this.f62932a.f62928b == 1 && (cVar == null || ListUtils.isEmpty(cVar.f62919b))) {
                        if (this.f62932a.f62930d != null) {
                            this.f62932a.f62930d.onError(-1, TbadkCoreApplication.getInst().getString(R.string.neterror));
                        }
                    } else if (cVar != null) {
                        this.f62932a.f62929c.f62918a = cVar.f62918a;
                        this.f62932a.f62929c.f62919b.addAll(cVar.f62919b);
                        this.f62932a.f62929c.f62920c = cVar.f62920c;
                        this.f62932a.f62929c.f62921d = cVar.f62921d;
                        this.f62932a.f62929c.f62922e = cVar.f62922e;
                        this.f62932a.f62929c.f62923f = cVar.f62923f;
                        if (ListUtils.isEmpty(cVar.f62919b)) {
                            this.f62932a.f62929c.f62924g = false;
                        } else {
                            this.f62932a.f62929c.f62924g = cVar.f62924g;
                            a.c(this.f62932a);
                        }
                        if (this.f62932a.f62930d != null) {
                            this.f62932a.f62930d.a(cVar);
                        }
                    }
                } else if (this.f62932a.f62930d != null) {
                    this.f62932a.f62930d.onError(responsedMessage.getError(), responsedMessage.getErrorString());
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public interface b {
        void a(c cVar);

        void onError(int i2, String str);
    }

    public a(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f62928b = 1;
        C1567a c1567a = new C1567a(this, CmdConfigHttp.CMD_HOT_USER_RANK, 309652);
        this.f62931e = c1567a;
        this.f62927a = bdUniqueId;
        c1567a.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.f62931e);
        m();
        l();
        this.f62929c = new c();
    }

    public static /* synthetic */ int c(a aVar) {
        int i2 = aVar.f62928b;
        aVar.f62928b = i2 + 1;
        return i2;
    }

    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f62928b : invokeV.intValue;
    }

    public c g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f62929c : (c) invokeV.objValue;
    }

    public void h(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j) == null) {
            HotUserRankReqMsg hotUserRankReqMsg = new HotUserRankReqMsg();
            hotUserRankReqMsg.forumId = j;
            hotUserRankReqMsg.pageSize = 20;
            hotUserRankReqMsg.pageNum = this.f62928b;
            hotUserRankReqMsg.setTag(this.f62927a);
            MessageManager.getInstance().sendMessage(hotUserRankReqMsg);
        }
    }

    public void i(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            HotUserRankReqMsg hotUserRankReqMsg = new HotUserRankReqMsg();
            hotUserRankReqMsg.category = str;
            hotUserRankReqMsg.pageSize = 20;
            hotUserRankReqMsg.pageNum = this.f62928b;
            hotUserRankReqMsg.setTag(this.f62927a);
            MessageManager.getInstance().sendMessage(hotUserRankReqMsg);
        }
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f62929c.f62924g : invokeV.booleanValue;
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            MessageManager.getInstance().removeMessage(this.f62927a);
            MessageManager.getInstance().unRegisterListener(this.f62927a);
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_HOT_USER_RANK, d.a.s0.h3.d0.a.a(TbConfig.HOT_USER_RANK_URL, 309652));
            tbHttpMessageTask.setIsNeedAddCommenParam(false);
            tbHttpMessageTask.setResponsedClass(HotUserRankHttpResMsg.class);
            tbHttpMessageTask.setPriority(4);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            d.a.r0.v0.b bVar = new d.a.r0.v0.b(309652);
            bVar.setResponsedClass(HotUserRankSocketResMsg.class);
            bVar.g(true);
            bVar.setPriority(4);
            MessageManager.getInstance().registerTask(bVar);
        }
    }

    public void n(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar) == null) {
            this.f62930d = bVar;
        }
    }
}

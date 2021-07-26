package d.a.q0.l0.i.d;

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
import d.a.q0.l0.i.c.c;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public BdUniqueId f60304a;

    /* renamed from: b  reason: collision with root package name */
    public int f60305b;

    /* renamed from: c  reason: collision with root package name */
    public c f60306c;

    /* renamed from: d  reason: collision with root package name */
    public b f60307d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.d.c.g.a f60308e;

    /* renamed from: d.a.q0.l0.i.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C1528a extends d.a.d.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f60309a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1528a(a aVar, int i2, int i3) {
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
            this.f60309a = aVar;
        }

        @Override // d.a.d.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) || responsedMessage == null) {
                return;
            }
            if (responsedMessage.getOrginalMessage() == null || responsedMessage.getOrginalMessage().getTag() == this.f60309a.f60304a) {
                c cVar = null;
                if (responsedMessage instanceof HotUserRankHttpResMsg) {
                    cVar = ((HotUserRankHttpResMsg) responsedMessage).getPageData();
                } else if (responsedMessage instanceof HotUserRankSocketResMsg) {
                    cVar = ((HotUserRankSocketResMsg) responsedMessage).getPageData();
                }
                if (responsedMessage.getError() == 0) {
                    if (this.f60309a.f60305b == 1 && (cVar == null || ListUtils.isEmpty(cVar.f60296b))) {
                        if (this.f60309a.f60307d != null) {
                            this.f60309a.f60307d.onError(-1, TbadkCoreApplication.getInst().getString(R.string.neterror));
                        }
                    } else if (cVar != null) {
                        this.f60309a.f60306c.f60295a = cVar.f60295a;
                        this.f60309a.f60306c.f60296b.addAll(cVar.f60296b);
                        this.f60309a.f60306c.f60297c = cVar.f60297c;
                        this.f60309a.f60306c.f60298d = cVar.f60298d;
                        this.f60309a.f60306c.f60299e = cVar.f60299e;
                        this.f60309a.f60306c.f60300f = cVar.f60300f;
                        if (ListUtils.isEmpty(cVar.f60296b)) {
                            this.f60309a.f60306c.f60301g = false;
                        } else {
                            this.f60309a.f60306c.f60301g = cVar.f60301g;
                            a.c(this.f60309a);
                        }
                        if (this.f60309a.f60307d != null) {
                            this.f60309a.f60307d.a(cVar);
                        }
                    }
                } else if (this.f60309a.f60307d != null) {
                    this.f60309a.f60307d.onError(responsedMessage.getError(), responsedMessage.getErrorString());
                }
            }
        }
    }

    /* loaded from: classes8.dex */
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
        this.f60305b = 1;
        C1528a c1528a = new C1528a(this, CmdConfigHttp.CMD_HOT_USER_RANK, 309652);
        this.f60308e = c1528a;
        this.f60304a = bdUniqueId;
        c1528a.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.f60308e);
        m();
        l();
        this.f60306c = new c();
    }

    public static /* synthetic */ int c(a aVar) {
        int i2 = aVar.f60305b;
        aVar.f60305b = i2 + 1;
        return i2;
    }

    public int f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f60305b : invokeV.intValue;
    }

    public c g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f60306c : (c) invokeV.objValue;
    }

    public void h(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j) == null) {
            HotUserRankReqMsg hotUserRankReqMsg = new HotUserRankReqMsg();
            hotUserRankReqMsg.forumId = j;
            hotUserRankReqMsg.pageSize = 20;
            hotUserRankReqMsg.pageNum = this.f60305b;
            hotUserRankReqMsg.setTag(this.f60304a);
            MessageManager.getInstance().sendMessage(hotUserRankReqMsg);
        }
    }

    public void i(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            HotUserRankReqMsg hotUserRankReqMsg = new HotUserRankReqMsg();
            hotUserRankReqMsg.category = str;
            hotUserRankReqMsg.pageSize = 20;
            hotUserRankReqMsg.pageNum = this.f60305b;
            hotUserRankReqMsg.setTag(this.f60304a);
            MessageManager.getInstance().sendMessage(hotUserRankReqMsg);
        }
    }

    public boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f60306c.f60301g : invokeV.booleanValue;
    }

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            MessageManager.getInstance().removeMessage(this.f60304a);
            MessageManager.getInstance().unRegisterListener(this.f60304a);
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_HOT_USER_RANK, d.a.q0.h3.d0.a.a(TbConfig.HOT_USER_RANK_URL, 309652));
            tbHttpMessageTask.setIsNeedAddCommenParam(false);
            tbHttpMessageTask.setResponsedClass(HotUserRankHttpResMsg.class);
            tbHttpMessageTask.setPriority(4);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            d.a.p0.x0.b bVar = new d.a.p0.x0.b(309652);
            bVar.setResponsedClass(HotUserRankSocketResMsg.class);
            bVar.g(true);
            bVar.setPriority(4);
            MessageManager.getInstance().registerTask(bVar);
        }
    }

    public void n(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar) == null) {
            this.f60307d = bVar;
        }
    }
}

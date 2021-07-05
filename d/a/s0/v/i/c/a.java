package d.a.s0.v.i.c;

import android.text.TextUtils;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.ala.AlaCmdConfigSocket;
import com.baidu.ala.liveroom.messages.AlaMGetLiveStatusHttpResponseMessage;
import com.baidu.ala.liveroom.messages.AlaMGetLiveStatusSocketResponseMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.ala.livecard.models.FrsPageAlaTabRequestMessage;
import com.baidu.tieba.ala.livecard.models.FrsPageAlaTabResponseMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.k.e.n;
import d.a.r0.r.q.b2;
import d.a.s0.u0.b1;
import d.a.s0.u0.o0;
import d.a.s0.u0.s0;
import d.a.s0.u0.y0;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class a implements o0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public BdUniqueId f68001e;

    /* renamed from: f  reason: collision with root package name */
    public int f68002f;

    /* renamed from: g  reason: collision with root package name */
    public b1 f68003g;

    /* renamed from: h  reason: collision with root package name */
    public ArrayList<n> f68004h;

    /* renamed from: i  reason: collision with root package name */
    public s0 f68005i;
    public d.a.c.c.g.a j;
    public HttpMessageListener k;

    /* renamed from: d.a.s0.v.i.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C1817a extends d.a.c.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f68006a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1817a(a aVar, int i2, int i3) {
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
            this.f68006a = aVar;
        }

        @Override // d.a.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            b2 b2Var;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) && responsedMessage != null && responsedMessage.getOrginalMessage().getTag() == this.f68006a.f68001e) {
                List<Long> closedIds = responsedMessage instanceof AlaMGetLiveStatusHttpResponseMessage ? ((AlaMGetLiveStatusHttpResponseMessage) responsedMessage).getClosedIds() : null;
                if (responsedMessage instanceof AlaMGetLiveStatusSocketResponseMessage) {
                    closedIds = ((AlaMGetLiveStatusSocketResponseMessage) responsedMessage).getClosedIds();
                }
                if (ListUtils.isEmpty(this.f68006a.f68004h) || ListUtils.isEmpty(closedIds)) {
                    return;
                }
                boolean z = false;
                for (int size = this.f68006a.f68004h.size() - 1; size >= 0; size--) {
                    if (this.f68006a.f68004h.get(size).getType() == b2.m3 && (b2Var = (b2) this.f68006a.f68004h.get(size)) != null && b2Var.g1() != null && closedIds.contains(Long.valueOf(b2Var.g1().live_id))) {
                        this.f68006a.f68004h.remove(size);
                        z = true;
                    }
                }
                if (!z || this.f68006a.f68005i == null) {
                    return;
                }
                this.f68006a.f68005i.a(49, this.f68006a.f68002f, this.f68006a.f68003g, this.f68006a.f68004h);
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f68007a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(a aVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f68007a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021038) {
                if (httpResponsedMessage.getStatusCode() != 200 || !(httpResponsedMessage instanceof FrsPageAlaTabResponseMessage)) {
                    this.f68007a.f68005i.a(49, this.f68007a.f68002f, null, null);
                    return;
                }
                FrsPageAlaTabResponseMessage frsPageAlaTabResponseMessage = (FrsPageAlaTabResponseMessage) httpResponsedMessage;
                if (frsPageAlaTabResponseMessage.errCode != 0) {
                    if (this.f68007a.f68005i != null) {
                        this.f68007a.f68005i.a(49, this.f68007a.f68002f, null, null);
                        return;
                    }
                    return;
                }
                ArrayList<n> arrayList = frsPageAlaTabResponseMessage.mThreadList;
                ArrayList<n> arrayList2 = frsPageAlaTabResponseMessage.mAltList;
                b1 b1Var = frsPageAlaTabResponseMessage.pageInfo;
                int i2 = frsPageAlaTabResponseMessage.alaLiveCount;
                this.f68007a.f68003g = b1Var;
                if (b1Var.f67232c == 1) {
                    this.f68007a.f68004h.clear();
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001606, Integer.valueOf(i2)));
                if (this.f68007a.f68005i != null) {
                    if (arrayList != null && arrayList.size() > 0) {
                        this.f68007a.f68004h.addAll(arrayList);
                        this.f68007a.f68005i.a(49, this.f68007a.f68002f, b1Var, this.f68007a.f68004h);
                        return;
                    }
                    b2 b2Var = new b2();
                    b2Var.d4(51);
                    if (this.f68007a.f68004h.size() == 0 || (this.f68007a.f68004h.size() > 0 && ((b2) this.f68007a.f68004h.get(0)).j1() != 51)) {
                        this.f68007a.f68004h.add(0, b2Var);
                    }
                    if (arrayList2 != null && arrayList2.size() > 0) {
                        b2Var.e1 = true;
                        if (arrayList2.get(0) != null) {
                            ((b2) arrayList2.get(0)).d1 = true;
                        }
                        this.f68007a.f68004h.addAll(arrayList2);
                    }
                    this.f68007a.f68005i.a(49, this.f68007a.f68002f, b1Var, this.f68007a.f68004h);
                }
            }
        }
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f68004h = new ArrayList<>();
        this.j = new C1817a(this, AlaCmdConfigHttp.CMD_ALA_LIVE_GET_CLOSED_STATUS, AlaCmdConfigSocket.ALA_SOCKET_GET_LIVE_STATUS2);
        this.k = new b(this, AlaCmdConfigHttp.FRS_ALA_LIVE_TAB_CMD);
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            BdUniqueId bdUniqueId = this.f68001e;
            if (bdUniqueId != null) {
                this.k.setTag(bdUniqueId);
                this.j.setTag(this.f68001e);
            }
            MessageManager.getInstance().registerListener(this.j);
            MessageManager.getInstance().registerListener(this.k);
        }
    }

    public void g(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bdUniqueId) == null) || bdUniqueId == null) {
            return;
        }
        this.f68001e = bdUniqueId;
    }

    @Override // d.a.s0.u0.o0
    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            MessageManager.getInstance().unRegisterTask(AlaCmdConfigHttp.FRS_ALA_LIVE_TAB_CMD);
            i();
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.j);
            MessageManager.getInstance().unRegisterListener(this.k);
        }
    }

    @Override // d.a.s0.u0.o0
    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(AlaCmdConfigHttp.FRS_ALA_LIVE_TAB_CMD, TbConfig.SERVER_ADDRESS + "c/f/frs/getFrsLiveThreads");
            tbHttpMessageTask.setResponsedClass(FrsPageAlaTabResponseMessage.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
            f();
        }
    }

    @Override // d.a.s0.u0.o0
    public void q(int i2, int i3, y0 y0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048581, this, i2, i3, y0Var) == null) {
            this.f68002f = i3;
            if (y0Var != null && !TextUtils.isEmpty(y0Var.f67230a) && !TextUtils.isEmpty(y0Var.f67231b)) {
                if (y0Var.f67232c <= 0) {
                    y0Var.f67232c = 1;
                }
                MessageManager.getInstance().sendMessage(new FrsPageAlaTabRequestMessage(AlaCmdConfigHttp.FRS_ALA_LIVE_TAB_CMD, y0Var.f67230a, y0Var.f67231b, y0Var.f67232c));
                return;
            }
            this.f68005i.a(49, this.f68002f, null, null);
        }
    }

    @Override // d.a.s0.u0.o0
    public void t(s0 s0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, s0Var) == null) {
            this.f68005i = s0Var;
        }
    }
}

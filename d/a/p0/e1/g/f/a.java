package d.a.p0.e1.g.f;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.homepage.lowFlows.message.MoreTreasureTroveReqMsg;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.j;
import d.a.c.k.e.n;
import d.a.p0.e1.g.b;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes7.dex */
public class a implements d.a.p0.e1.g.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f55435a;

    /* renamed from: b  reason: collision with root package name */
    public BdUniqueId f55436b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.c.c.g.a f55437c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f55438d;

    /* renamed from: e  reason: collision with root package name */
    public b f55439e;

    /* renamed from: f  reason: collision with root package name */
    public final HashMap<String, List<n>> f55440f;

    /* renamed from: d.a.p0.e1.g.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C1340a extends d.a.c.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f55441a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1340a(a aVar, int i2, int i3) {
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
            this.f55441a = aVar;
        }

        @Override // d.a.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                this.f55441a.f55438d = false;
                if (this.f55441a.f55439e == null) {
                    return;
                }
                if (!(responsedMessage instanceof d.a.p0.e1.g.e.a)) {
                    this.f55441a.f55439e.c(-1);
                } else if (responsedMessage.getOrginalMessage() == null || this.f55441a.f55436b != responsedMessage.getOrginalMessage().getTag()) {
                    this.f55441a.f55439e.c(-1);
                } else if (responsedMessage.hasError() && responsedMessage.getError() == 0) {
                    this.f55441a.f55439e.c(responsedMessage.getError());
                } else {
                    d.a.p0.e1.g.e.a aVar = (d.a.p0.e1.g.e.a) responsedMessage;
                    if (aVar.getDataList() == null || aVar.getDataList().size() <= 0) {
                        this.f55441a.f55439e.c(-1);
                        return;
                    }
                    if (!StringUtils.isNull(this.f55441a.f55435a)) {
                        this.f55441a.f55440f.put(this.f55441a.f55435a, aVar.getDataList());
                    }
                    this.f55441a.f55439e.b(responsedMessage.getError(), aVar);
                }
            }
        }
    }

    public a(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f55436b = null;
        this.f55440f = new HashMap<>();
        this.f55439e = bVar;
        g();
    }

    @Override // d.a.p0.e1.g.a
    public boolean a(BdUniqueId bdUniqueId, String str, String str2, String str3) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(1048576, this, bdUniqueId, str, str2, str3)) == null) {
            if (j.A() && bdUniqueId != null && !StringUtils.isNull(str) && !StringUtils.isNull(str2)) {
                if (this.f55438d) {
                    return false;
                }
                String str4 = this.f55435a;
                if (str4 != null && str4.equals(str) && this.f55440f.size() > 0) {
                    this.f55439e.setData(this.f55440f.get(str));
                    return true;
                }
                k(bdUniqueId);
                i(str);
                h(str2);
                j(str3);
                MoreTreasureTroveReqMsg moreTreasureTroveReqMsg = new MoreTreasureTroveReqMsg();
                moreTreasureTroveReqMsg.setTag(bdUniqueId);
                moreTreasureTroveReqMsg.setTabCode(str);
                moreTreasureTroveReqMsg.setLfUser(str2);
                moreTreasureTroveReqMsg.setTaskId(str3);
                boolean sendMessage = MessageManager.getInstance().sendMessage(moreTreasureTroveReqMsg);
                this.f55438d = sendMessage;
                return sendMessage;
            }
            b bVar = this.f55439e;
            if (bVar != null) {
                bVar.c(-1);
            }
            return false;
        }
        return invokeLLLL.booleanValue;
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.f55437c = new C1340a(this, CmdConfigHttp.CMD_LOW_FLOWS_PAGE, 309691);
            MessageManager.getInstance().registerListener(this.f55437c);
        }
    }

    public void h(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
        }
    }

    public void i(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.f55435a = str;
        }
    }

    public void j(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
        }
    }

    public void k(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bdUniqueId) == null) {
            this.f55436b = bdUniqueId;
        }
    }
}

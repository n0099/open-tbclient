package d.a.q0.a4.q.d;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.write.transmit.model.GetRepostForumHttpResMessage;
import com.baidu.tieba.write.transmit.model.GetRepostForumReqMessage;
import com.baidu.tieba.write.transmit.model.GetRepostForumSocketResMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import tbclient.SimpleForum;
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public BdUniqueId f54846a;

    /* renamed from: b  reason: collision with root package name */
    public List<SimpleForum> f54847b;

    /* renamed from: c  reason: collision with root package name */
    public String f54848c;

    /* renamed from: d  reason: collision with root package name */
    public b f54849d;

    /* renamed from: e  reason: collision with root package name */
    public String f54850e;

    /* renamed from: f  reason: collision with root package name */
    public String f54851f;

    /* renamed from: g  reason: collision with root package name */
    public int f54852g;

    /* renamed from: h  reason: collision with root package name */
    public String f54853h;

    /* renamed from: i  reason: collision with root package name */
    public BdUniqueId f54854i;
    public d.a.d.c.g.a j;

    /* renamed from: d.a.q0.a4.q.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C1280a extends d.a.d.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f54855a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1280a(a aVar, int i2, int i3) {
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
            this.f54855a = aVar;
        }

        @Override // d.a.d.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) || responsedMessage == null) {
                return;
            }
            boolean z = responsedMessage instanceof GetRepostForumHttpResMessage;
            if (z || (responsedMessage instanceof GetRepostForumSocketResMessage)) {
                if (responsedMessage.getOrginalMessage() == null || !(responsedMessage.getOrginalMessage().getExtra() instanceof GetRepostForumReqMessage) || this.f54855a.f54854i == ((GetRepostForumReqMessage) responsedMessage.getOrginalMessage().getExtra()).getRequestId()) {
                    if (responsedMessage.hasError()) {
                        if (this.f54855a.f54849d != null) {
                            this.f54855a.f54849d.onError();
                            return;
                        }
                        return;
                    }
                    if (z) {
                        GetRepostForumHttpResMessage getRepostForumHttpResMessage = (GetRepostForumHttpResMessage) responsedMessage;
                        this.f54855a.f54847b = getRepostForumHttpResMessage.getForumList();
                        this.f54855a.f54848c = getRepostForumHttpResMessage.getRecommendExtension();
                        this.f54855a.f54852g = getRepostForumHttpResMessage.getPrivateThread();
                    }
                    if (responsedMessage instanceof GetRepostForumSocketResMessage) {
                        GetRepostForumSocketResMessage getRepostForumSocketResMessage = (GetRepostForumSocketResMessage) responsedMessage;
                        this.f54855a.f54847b = getRepostForumSocketResMessage.getForumList();
                        this.f54855a.f54848c = getRepostForumSocketResMessage.getRecommendExtension();
                        this.f54855a.f54852g = getRepostForumSocketResMessage.getPrivateThread();
                    }
                    if (this.f54855a.f54849d != null) {
                        this.f54855a.f54849d.a(this.f54855a.f54847b, this.f54855a.f54852g);
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface b {
        void a(List<SimpleForum> list, int i2);

        void onError();
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
        C1280a c1280a = new C1280a(this, CmdConfigHttp.CMD_GET_REPOST_RECOMMEND_FORUM, 309450);
        this.j = c1280a;
        this.f54846a = bdUniqueId;
        c1280a.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.j);
        this.j.getHttpMessageListener().setSelfListener(true);
        this.j.getSocketMessageListener().setSelfListener(true);
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            GetRepostForumReqMessage getRepostForumReqMessage = new GetRepostForumReqMessage();
            getRepostForumReqMessage.setThreadTitle(this.f54850e);
            getRepostForumReqMessage.setThreadContent(this.f54851f);
            getRepostForumReqMessage.setForumId(this.f54853h);
            getRepostForumReqMessage.setTag(this.f54846a);
            getRepostForumReqMessage.setRequestId(this.f54854i);
            MessageManager.getInstance().sendMessage(getRepostForumReqMessage);
        }
    }

    public void i(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
            this.f54849d = bVar;
        }
    }

    public void j(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bdUniqueId) == null) {
            this.f54854i = bdUniqueId;
        }
    }

    public void k(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.f54851f = str;
        }
    }

    public void l(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.f54850e = str;
        }
    }
}

package d.a.s0.w1;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.personExtra.RecommendGodHttpResponseMessage;
import com.baidu.tieba.personExtra.RecommendGodReqMsg;
import com.baidu.tieba.personExtra.RecommendGodSocketResponseMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.s0.m2.e.q;
/* loaded from: classes9.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public BdUniqueId f68968a;

    /* renamed from: b  reason: collision with root package name */
    public q f68969b;

    /* renamed from: c  reason: collision with root package name */
    public b f68970c;

    /* renamed from: d  reason: collision with root package name */
    public int f68971d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f68972e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.c.c.g.a f68973f;

    /* loaded from: classes9.dex */
    public class a extends d.a.c.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f68974a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(c cVar, int i2, int i3) {
            super(i2, i3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, Integer.valueOf(i2), Integer.valueOf(i3)};
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
            this.f68974a = cVar;
        }

        @Override // d.a.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                this.f68974a.f68969b = null;
                if (responsedMessage == null) {
                    return;
                }
                if (responsedMessage.getOrginalMessage() == null || responsedMessage.getOrginalMessage().getTag() == this.f68974a.f68968a) {
                    if (responsedMessage instanceof RecommendGodSocketResponseMessage) {
                        this.f68974a.f68969b = ((RecommendGodSocketResponseMessage) responsedMessage).recommendGodData;
                    } else if (responsedMessage instanceof RecommendGodHttpResponseMessage) {
                        this.f68974a.f68969b = ((RecommendGodHttpResponseMessage) responsedMessage).recommendGodData;
                    }
                    if (this.f68974a.f68969b != null) {
                        c cVar = this.f68974a;
                        cVar.f68971d = cVar.f68969b.f63521a;
                    }
                    int error = responsedMessage.getError();
                    if (error != 0 || this.f68974a.f68969b == null) {
                        error = 1;
                    } else if (ListUtils.isEmpty(this.f68974a.f68969b.f63522b)) {
                        error = this.f68974a.f68972e ? 3 : 2;
                    }
                    if (this.f68974a.f68970c != null) {
                        this.f68974a.f68970c.a(this.f68974a.f68969b, error);
                    }
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public interface b {
        void a(q qVar, int i2);
    }

    public c(BdUniqueId bdUniqueId) {
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
        this.f68971d = 0;
        a aVar = new a(this, CmdConfigHttp.CMD_GET_RECOMMEND_GOD_LIST, 309684);
        this.f68973f = aVar;
        this.f68968a = bdUniqueId;
        aVar.setTag(bdUniqueId);
        MessageManager.getInstance().registerListener(this.f68973f);
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            MessageManager.getInstance().removeMessage(this.f68968a);
            MessageManager.getInstance().unRegisterListener(this.f68968a);
        }
    }

    public void h(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            RecommendGodReqMsg recommendGodReqMsg = new RecommendGodReqMsg();
            recommendGodReqMsg.portrait = str;
            if (this.f68971d == 0) {
                this.f68972e = false;
            } else {
                this.f68972e = true;
            }
            recommendGodReqMsg.pageNum = this.f68971d + 1;
            recommendGodReqMsg.setTag(this.f68968a);
            MessageManager.getInstance().sendMessage(recommendGodReqMsg);
        }
    }

    public void i(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, str, i2) == null) {
            this.f68971d = i2;
            h(str);
        }
    }

    public void j(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bVar) == null) {
            this.f68970c = bVar;
        }
    }
}

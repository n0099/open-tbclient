package d.a.r0.s.e;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.coreExtra.message.ChannelConfigResponseMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.r0.s.c.n;
import d.a.r0.s.c.o;
/* loaded from: classes9.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public o f56530a;

    /* renamed from: b  reason: collision with root package name */
    public InterfaceC1273b f56531b;

    /* renamed from: c  reason: collision with root package name */
    public int f56532c;

    /* renamed from: d  reason: collision with root package name */
    public int f56533d;

    /* renamed from: e  reason: collision with root package name */
    public n f56534e;

    /* renamed from: f  reason: collision with root package name */
    public HttpMessageListener f56535f;

    /* loaded from: classes9.dex */
    public class a extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f56536a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(b bVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, Integer.valueOf(i2)};
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
            this.f56536a = bVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && (httpResponsedMessage instanceof ChannelConfigResponseMessage)) {
                ChannelConfigResponseMessage channelConfigResponseMessage = (ChannelConfigResponseMessage) httpResponsedMessage;
                this.f56536a.f56530a = channelConfigResponseMessage.getData();
                if (this.f56536a.f56531b != null) {
                    this.f56536a.f56531b.a(channelConfigResponseMessage.isSuccess(), channelConfigResponseMessage.getData());
                }
                if (channelConfigResponseMessage.isSuccess()) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921493, null));
                }
            }
        }
    }

    /* renamed from: d.a.r0.s.e.b$b  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public interface InterfaceC1273b {
        void a(boolean z, o oVar);
    }

    public b() {
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
        this.f56535f = new a(this, CmdConfigHttp.CMD_GET_CHANNEL_CONFIG);
        MessageManager.getInstance().registerListener(this.f56535f);
        this.f56532c = d.a.r0.r.d0.b.j().k("key_common_category_version", 0);
        this.f56533d = d.a.r0.r.d0.b.j().k("key_special_category_version", 0);
    }

    public n c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            n nVar = this.f56534e;
            if (nVar != null) {
                return nVar;
            }
            if (this.f56530a == null) {
                return null;
            }
            n nVar2 = new n();
            o oVar = this.f56530a;
            if (oVar != null && oVar.b() != null && this.f56533d < this.f56530a.b().e()) {
                nVar2.g(this.f56530a.b().a());
                nVar2.h(this.f56530a.b().b());
                nVar2.i(this.f56530a.b().c());
                nVar2.j(this.f56530a.b().d());
                nVar2.f(n.f56419h);
            } else {
                o oVar2 = this.f56530a;
                if (oVar2 != null && oVar2.a() > 0 && this.f56532c < this.f56530a.a()) {
                    nVar2.f(n.f56418g);
                } else {
                    nVar2.f(n.f56417f);
                }
            }
            this.f56534e = nVar2;
            return nVar2;
        }
        return (n) invokeV.objValue;
    }

    public void d(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            if (i2 == n.f56419h) {
                if (this.f56530a.b() != null) {
                    d.a.r0.r.d0.b.j().v("key_special_category_version", this.f56530a.b().e());
                }
            } else if (i2 == n.f56418g) {
                d.a.r0.r.d0.b.j().v("key_common_category_version", this.f56530a.a());
            }
        }
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            MessageManager.getInstance().sendMessage(new HttpMessage(CmdConfigHttp.CMD_GET_CHANNEL_CONFIG));
        }
    }
}

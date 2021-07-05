package d.a.d.m.f;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.afd.videopaster.data.VideoPasterRequestData;
import com.baidu.afd.videopaster.data.VideoPasterResponseData;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public b f45216a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f45217b;

    /* renamed from: c  reason: collision with root package name */
    public BdUniqueId f45218c;

    /* renamed from: d  reason: collision with root package name */
    public VideoPasterResponseData f45219d;

    /* renamed from: e  reason: collision with root package name */
    public final HttpMessageListener f45220e;

    /* renamed from: d.a.d.m.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C0612a extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f45221a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0612a(a aVar, int i2) {
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
            this.f45221a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) {
                this.f45221a.f45217b = false;
                VideoPasterResponseData videoPasterResponseData = (VideoPasterResponseData) httpResponsedMessage;
                this.f45221a.f45219d = videoPasterResponseData;
                if (httpResponsedMessage == null || httpResponsedMessage.getCmd() != 1003431) {
                    return;
                }
                if (httpResponsedMessage instanceof VideoPasterResponseData) {
                    if (this.f45221a.f45216a != null) {
                        this.f45221a.f45216a.b(videoPasterResponseData.getPasterData());
                    }
                } else if (this.f45221a.f45216a != null) {
                    this.f45221a.f45216a.a(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString());
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public interface b {
        void a(int i2, String str);

        void b(d.a.d.m.e.a aVar);
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
        this.f45220e = new C0612a(this, CmdConfigHttp.CMD_VIDEO_PASTER_AD_REQUEST);
        this.f45218c = BdUniqueId.gen();
        this.f45220e.setSelfListener(true);
        this.f45220e.setTag(this.f45218c);
        MessageManager.getInstance().registerListener(this.f45220e);
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f45218c == null) {
            return;
        }
        MessageManager.getInstance().removeMessage(this.f45218c);
    }

    public VideoPasterResponseData e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f45219d : (VideoPasterResponseData) invokeV.objValue;
    }

    public boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f45217b : invokeV.booleanValue;
    }

    public void g(VideoPasterRequestData videoPasterRequestData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, videoPasterRequestData) == null) || videoPasterRequestData == null) {
            return;
        }
        this.f45217b = true;
        videoPasterRequestData.setTag(this.f45218c);
        MessageManager.getInstance().sendMessage(videoPasterRequestData);
    }

    public void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (this.f45220e != null) {
                MessageManager.getInstance().unRegisterListener(this.f45220e);
            }
            if (this.f45216a != null) {
                this.f45216a = null;
            }
        }
    }

    public void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            d();
            this.f45217b = false;
            this.f45219d = null;
        }
    }

    public void j(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, bVar) == null) {
            this.f45216a = bVar;
        }
    }
}

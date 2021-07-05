package d.a.s0;

import android.content.Intent;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.sapi2.activity.LoginActivity;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.LogoActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.s0.w2.r;
import d.a.s0.w2.w;
/* loaded from: classes9.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: h  reason: collision with root package name */
    public static volatile c f57879h;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public long f57880a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f57881b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.r0.k.c f57882c;

    /* renamed from: d  reason: collision with root package name */
    public CustomMessageListener f57883d;

    /* renamed from: e  reason: collision with root package name */
    public CustomMessageListener f57884e;

    /* renamed from: f  reason: collision with root package name */
    public CustomMessageListener f57885f;

    /* renamed from: g  reason: collision with root package name */
    public CustomMessageListener f57886g;

    /* loaded from: classes9.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(c cVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, Integer.valueOf(i2)};
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
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getCmd() != 2016522 || w.p().o() == null) {
                return;
            }
            w.p().o().b();
        }
    }

    /* loaded from: classes9.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f57887a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(c cVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, Integer.valueOf(i2)};
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
            this.f57887a = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2016521) {
                this.f57887a.e();
            }
        }
    }

    /* renamed from: d.a.s0.c$c  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public class C1341c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f57888a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C1341c(c cVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, Integer.valueOf(i2)};
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
            this.f57888a = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getCmd() != 2016520 || this.f57888a.f57880a == 0) {
                return;
            }
            Object data = customResponsedMessage.getData();
            if (data.getClass().getSimpleName().equals(LoginActivity.D)) {
                return;
            }
            if (this.f57888a.f()) {
                if (data instanceof BaseActivity) {
                    BaseActivity baseActivity = (BaseActivity) data;
                    Intent intent = new Intent(baseActivity.getActivity(), LogoActivity.class);
                    intent.putExtra("splash", true);
                    intent.setFlags(65536);
                    baseActivity.startActivity(intent);
                } else if (data instanceof BaseFragmentActivity) {
                    BaseFragmentActivity baseFragmentActivity = (BaseFragmentActivity) data;
                    Intent intent2 = new Intent(baseFragmentActivity.getActivity(), LogoActivity.class);
                    intent2.putExtra("splash", true);
                    intent2.setFlags(65536);
                    baseFragmentActivity.getActivity().startActivity(intent2);
                }
                TbadkCoreApplication.getInst().setCanShowHotSplash(2);
                return;
            }
            TbadkCoreApplication.getInst().setCanShowHotSplash(1);
        }
    }

    /* loaded from: classes9.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f57889a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(c cVar, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, Integer.valueOf(i2)};
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
            this.f57889a = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2016523) {
                Object data = customResponsedMessage.getData();
                if (data instanceof Boolean) {
                    long currentTimeMillis = System.currentTimeMillis() / 1000;
                    if (((Boolean) data).booleanValue()) {
                        c cVar = this.f57889a;
                        cVar.f57881b = currentTimeMillis - cVar.f57880a <= 1;
                    }
                }
            }
        }
    }

    public c() {
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
        this.f57883d = new a(this, 2016522);
        this.f57884e = new b(this, 2016521);
        this.f57885f = new C1341c(this, 2016520);
        this.f57886g = new d(this, 2016523);
        this.f57881b = false;
        MessageManager.getInstance().registerListener(this.f57884e);
        MessageManager.getInstance().registerListener(this.f57885f);
        MessageManager.getInstance().registerListener(this.f57883d);
        MessageManager.getInstance().registerListener(this.f57886g);
        if (w.p().o() != null) {
            w.p().o().c();
        }
    }

    public static c g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) {
            if (f57879h == null) {
                synchronized (c.class) {
                    if (f57879h == null) {
                        f57879h = new c();
                    }
                }
            }
            return f57879h;
        }
        return (c) invokeV.objValue;
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f57880a = System.currentTimeMillis() / 1000;
        }
    }

    public final boolean f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            int h2 = h();
            int i2 = i();
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            if (this.f57881b) {
                this.f57881b = false;
                return false;
            }
            long j = this.f57880a;
            if (currentTimeMillis - j > 2 && currentTimeMillis - j > h2) {
                r o = w.p().o();
                return (o != null ? o.a() : i2) < i2;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final int h() {
        InterceptResult invokeV;
        CustomResponsedMessage runTask;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            if (this.f57882c == null && (runTask = MessageManager.getInstance().runTask(2921564, d.a.r0.k.c.class)) != null) {
                this.f57882c = (d.a.r0.k.c) runTask.getData();
            }
            d.a.r0.k.c cVar = this.f57882c;
            if (cVar != null) {
                return (int) (cVar.a() * 60.0f);
            }
            d.a.r0.s.c.d adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
            if (adAdSense != null) {
                int b2 = adAdSense.b();
                if (b2 <= 0) {
                    return 86400;
                }
                return b2;
            }
            return 300;
        }
        return invokeV.intValue;
    }

    public final int i() {
        InterceptResult invokeV;
        CustomResponsedMessage runTask;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (this.f57882c == null && (runTask = MessageManager.getInstance().runTask(2921564, d.a.r0.k.c.class)) != null) {
                this.f57882c = (d.a.r0.k.c) runTask.getData();
            }
            d.a.r0.k.c cVar = this.f57882c;
            if (cVar != null) {
                return cVar.b();
            }
            return 3;
        }
        return invokeV.intValue;
    }
}

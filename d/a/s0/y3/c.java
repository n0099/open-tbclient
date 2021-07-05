package d.a.s0.y3;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.e.p.k;
import d.a.r0.s.c.j0;
import d.a.s0.y3.b;
import java.io.File;
/* loaded from: classes9.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f69662a;

    /* renamed from: b  reason: collision with root package name */
    public String f69663b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f69664c;

    /* renamed from: d  reason: collision with root package name */
    public b.a f69665d;

    /* renamed from: e  reason: collision with root package name */
    public CustomMessageListener f69666e;

    /* loaded from: classes9.dex */
    public class a implements b.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f69667a;

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f69667a = cVar;
        }

        @Override // d.a.s0.y3.b.a
        public void a(boolean z, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), str, str2}) == null) {
                this.f69667a.f69664c = false;
                if (z) {
                    this.f69667a.f69663b = str;
                    d.a.r0.r.d0.b.j().x("key_video_splash_path", this.f69667a.f69663b);
                    this.f69667a.f69662a = str2;
                    d.a.r0.r.d0.b.j().x("key_video_splash_url", this.f69667a.f69662a);
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f69668a;

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
            this.f69668a = cVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null) {
                return;
            }
            String p = d.a.r0.r.d0.b.j().p("key_video_splash_config", "");
            j0 j0Var = new j0();
            j0Var.g(p);
            this.f69668a.n(j0Var.f());
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
        this.f69664c = false;
        this.f69665d = new a(this);
        this.f69666e = new b(this, 2001371);
        j();
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || k.isEmpty(h())) {
            return;
        }
        FileHelper.deleteFileOrDir(new File(h()));
        this.f69663b = null;
        d.a.r0.r.d0.b.j().x("key_video_splash_path", this.f69663b);
        this.f69662a = null;
        d.a.r0.r.d0.b.j().x("key_video_splash_url", this.f69662a);
    }

    public final String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return TbadkCoreApplication.getInst().getCacheDir().getAbsolutePath() + "/videosplash";
        }
        return (String) invokeV.objValue;
    }

    public String i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f69663b : (String) invokeV.objValue;
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.f69664c = false;
            this.f69662a = d.a.r0.r.d0.b.j().p("key_video_splash_url", null);
            this.f69663b = d.a.r0.r.d0.b.j().p("key_video_splash_path", null);
            MessageManager.getInstance().registerListener(this.f69666e);
        }
    }

    public final boolean k(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) ? (k.isEmpty(str) || str.equals(this.f69662a)) ? false : true : invokeL.booleanValue;
    }

    public boolean l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.f69664c || k.isEmpty(i())) {
                return false;
            }
            if (new File(i()).exists()) {
                return true;
            }
            this.f69663b = null;
            d.a.r0.r.d0.b.j().x("key_video_splash_path", this.f69663b);
            this.f69662a = null;
            d.a.r0.r.d0.b.j().x("key_video_splash_url", this.f69662a);
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void m(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.f69664c = true;
            new d.a.s0.y3.b(h(), str, this.f69665d).execute(new Void[0]);
        }
    }

    public final void n(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            if ((d.a.r0.r.d0.b.j().k("key_video_splash_switch", 0) == 1) && !this.f69664c && k(str)) {
                m(str);
            }
        }
    }
}

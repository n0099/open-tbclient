package d.a.q0.w2;

import android.text.TextUtils;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.FacePackageDetailActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.util.TbPatternsCompat;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.coreExtra.view.BannerView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.p0.s.q.g0;
import d.a.q0.e.a.a;
import d.a.q0.h3.j0.a;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes8.dex */
public class g implements d.a.q0.e.a.a {
    public static /* synthetic */ Interceptable $ic;
    public static final Pattern j;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public BannerView f66637a;

    /* renamed from: b  reason: collision with root package name */
    public g0 f66638b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f66639c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.q0.e.e.c f66640d;

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext f66641e;

    /* renamed from: f  reason: collision with root package name */
    public a.InterfaceC1330a f66642f;

    /* renamed from: g  reason: collision with root package name */
    public String f66643g;

    /* renamed from: h  reason: collision with root package name */
    public String f66644h;

    /* renamed from: i  reason: collision with root package name */
    public BannerView.b f66645i;

    /* loaded from: classes8.dex */
    public class a implements TbImageView.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g f66646a;

        public a(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f66646a = gVar;
        }

        @Override // com.baidu.tbadk.widget.TbImageView.f
        public void a(String str, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLZ(1048576, this, str, z) == null) && z) {
                if (this.f66646a.f66638b != null && this.f66646a.f66638b.f53336i) {
                    String c2 = this.f66646a.f66638b.c();
                    if (!StringUtils.isNULL(c2)) {
                        this.f66646a.B(c2);
                    }
                    this.f66646a.f66638b.f53336i = false;
                }
                if (this.f66646a.f66637a == null || !this.f66646a.f66637a.i() || this.f66646a.f66639c) {
                    return;
                }
                this.f66646a.f66639c = true;
                this.f66646a.f66642f.a(this.f66646a.f66640d, this.f66646a.f66637a);
            }
        }

        @Override // com.baidu.tbadk.widget.TbImageView.f
        public void onCancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements BannerView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ g f66647a;

        public b(g gVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f66647a = gVar;
        }

        @Override // com.baidu.tbadk.coreExtra.view.BannerView.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f66647a.A();
            }
        }

        @Override // com.baidu.tbadk.coreExtra.view.BannerView.b
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.f66647a.y();
            }
        }
    }

    /* loaded from: classes8.dex */
    public static /* synthetic */ class c {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f66648a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1797945890, "Ld/a/q0/w2/g$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1797945890, "Ld/a/q0/w2/g$c;");
                    return;
                }
            }
            int[] iArr = new int[UtilHelper.NativePageType.values().length];
            f66648a = iArr;
            try {
                iArr[UtilHelper.NativePageType.FRS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f66648a[UtilHelper.NativePageType.PB.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(185838397, "Ld/a/q0/w2/g;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(185838397, "Ld/a/q0/w2/g;");
                return;
            }
        }
        j = Pattern.compile("(/p/){1}(\\d+)");
    }

    public g() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f66637a = null;
        this.f66639c = false;
        this.f66645i = new b(this);
    }

    public final void A() {
        BannerView bannerView;
        a.InterfaceC1330a interfaceC1330a;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (bannerView = this.f66637a) == null || (interfaceC1330a = this.f66642f) == null) {
            return;
        }
        this.f66639c = false;
        interfaceC1330a.b(this.f66640d, bannerView);
        this.f66637a = null;
    }

    public final void B(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) || StringUtils.isNULL(str)) {
            return;
        }
        a.b b2 = d.a.q0.h3.j0.a.b("ad_tpoint", "PT", "FRS", "c0129", "ad_plat", "VIEW_TRUE", str, this.f66644h, this.f66643g, null);
        b2.e(TiebaStatic.Params.OBJ_URL, this.f66638b.b());
        b2.f();
    }

    public final void C(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, str2) == null) || StringUtils.isNULL(str)) {
            return;
        }
        a.b b2 = d.a.q0.h3.j0.a.b("ad_tpoint", "PT", "FRS", "c0129", "ad_plat", "CLICK", str, this.f66644h, this.f66643g, null);
        b2.e(TiebaStatic.Params.OBJ_URL, str2);
        b2.f();
    }

    @Override // d.a.q0.e.a.a
    public void a(int i2) {
        BannerView bannerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048579, this, i2) == null) || (bannerView = this.f66637a) == null) {
            return;
        }
        bannerView.j();
    }

    @Override // d.a.q0.e.e.a
    public void b(Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, map) == null) || map == null || map.isEmpty()) {
            return;
        }
        this.f66643g = map.get("forum_name");
        this.f66644h = map.get("forum_id");
    }

    @Override // d.a.q0.e.a.a
    public void c(Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, obj) == null) && (obj instanceof g0)) {
            this.f66638b = (g0) obj;
        }
    }

    @Override // d.a.q0.e.a.a
    public void g(a.InterfaceC1330a interfaceC1330a) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, interfaceC1330a) == null) {
            this.f66642f = interfaceC1330a;
        }
    }

    @Override // d.a.q0.e.a.a
    public View getView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.f66637a : (View) invokeV.objValue;
    }

    @Override // d.a.q0.e.a.a
    public void i() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) || this.f66641e == null || this.f66642f == null) {
            return;
        }
        g0 g0Var = this.f66638b;
        if (g0Var == null) {
            A();
        } else if (!g0Var.f()) {
            A();
        } else {
            if (!this.f66639c) {
                if (this.f66637a != null) {
                    return;
                }
                BannerView bannerView = new BannerView(this.f66641e.getPageActivity());
                this.f66637a = bannerView;
                bannerView.setVisibility(8);
                this.f66637a.setBannerViewClickListener(this.f66645i);
                this.f66637a.setBannerViewEvent(new a(this));
                if (this.f66638b.e().startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL)) {
                    TiebaStatic.eventStat(this.f66641e.getPageActivity(), "game_show", "show", 1, "ref_id", "4000601", "ref_type", "603");
                }
            } else {
                this.f66642f.a(this.f66640d, this.f66637a);
            }
            this.f66637a.setBannerData(this.f66638b);
            this.f66637a.k();
            if (this.f66638b.d() != 1 || TextUtils.isEmpty(this.f66638b.b())) {
                return;
            }
            this.f66637a.setData(this.f66641e, this.f66638b.b());
        }
    }

    @Override // d.a.q0.e.a.a
    public void k(int i2) {
        BannerView bannerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048585, this, i2) == null) || (bannerView = this.f66637a) == null) {
            return;
        }
        bannerView.setBannerMaskColor(i2);
    }

    public final void y() {
        g0 g0Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (g0Var = this.f66638b) == null) {
            return;
        }
        String e2 = g0Var.e();
        String c2 = this.f66638b.c();
        if (this.f66638b.a() == 1) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new FacePackageDetailActivityConfig(this.f66641e.getPageActivity(), e2, false, "frs_banner")));
            C(c2, e2);
        } else if (this.f66638b.a() == 2) {
            if (e2.contains(TbPatternsCompat.TB_DOMAIN_NAME)) {
                Matcher matcher = j.matcher(e2);
                if (matcher.find()) {
                    try {
                        PbActivityConfig createNormalCfg = new PbActivityConfig(this.f66641e.getPageActivity()).createNormalCfg(matcher.group(2), null, "frs_banner");
                        createNormalCfg.setVideo_source("frs");
                        this.f66641e.sendMessage(new CustomMessage(2004001, createNormalCfg));
                        C(c2, e2);
                    } catch (Exception e3) {
                        BdLog.e(e3.toString());
                    }
                }
            }
        } else if (this.f66638b.a() == 3) {
            new UtilHelper.NativePage();
            UtilHelper.NativePage isNativeAddress = UtilHelper.isNativeAddress(e2);
            UtilHelper.NativePageType nativePageType = isNativeAddress.type;
            if (nativePageType != UtilHelper.NativePageType.NONE) {
                int i2 = c.f66648a[nativePageType.ordinal()];
                if (i2 == 1) {
                    this.f66641e.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.f66641e.getPageActivity()).createNormalCfg(isNativeAddress.id, "frs_banner")));
                } else if (i2 == 2) {
                    PbActivityConfig createNormalCfg2 = new PbActivityConfig(this.f66641e.getPageActivity()).createNormalCfg(isNativeAddress.id, null, "frs_banner");
                    createNormalCfg2.setVideo_source("frs");
                    this.f66641e.sendMessage(new CustomMessage(2004001, createNormalCfg2));
                }
            } else {
                w.o().e().c(this.f66641e.getPageActivity(), new String[]{e2}, null);
                if (!StringUtils.isNull(e2) && e2.startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL)) {
                    TiebaStatic.eventStat(this.f66641e.getPageActivity(), "frs_banner", PrefetchEvent.STATE_CLICK, 1, "ref_id", "4000601", "ref_type", "603");
                }
            }
            C(c2, e2);
        } else if (this.f66638b.a() == 4) {
            this.f66641e.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.f66641e.getPageActivity()).createNormalCfg(e2, "frs_banner")));
            C(c2, e2);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.q0.e.e.a
    /* renamed from: z */
    public void o(d.a.q0.e.e.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, cVar) == null) {
            this.f66640d = cVar;
            if (cVar == null || !(cVar.a() instanceof TbPageContext)) {
                return;
            }
            this.f66641e = (TbPageContext) this.f66640d.a();
        }
    }
}

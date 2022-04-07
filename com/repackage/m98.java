package com.repackage;

import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.FacePackageDetailActivityConfig;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.util.GameCenterCoreUtils;
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
import com.repackage.al8;
import com.repackage.yg5;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes6.dex */
public class m98 implements yg5 {
    public static /* synthetic */ Interceptable $ic;
    public static final Pattern j;
    public transient /* synthetic */ FieldHolder $fh;
    public BannerView a;
    public xo4 b;
    public boolean c;
    public hh5 d;
    public TbPageContext e;
    public yg5.a f;
    public String g;
    public String h;
    public BannerView.b i;

    /* loaded from: classes6.dex */
    public class a implements TbImageView.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m98 a;

        public a(m98 m98Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m98Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = m98Var;
        }

        @Override // com.baidu.tbadk.widget.TbImageView.g
        public void a(String str, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLZ(1048576, this, str, z) == null) && z) {
                if (this.a.b != null && this.a.b.i) {
                    String c = this.a.b.c();
                    if (!StringUtils.isNULL(c)) {
                        this.a.A(c);
                    }
                    this.a.b.i = false;
                }
                if (this.a.a == null || !this.a.a.i() || this.a.c) {
                    return;
                }
                this.a.c = true;
                this.a.f.a(this.a.d, this.a.a);
            }
        }

        @Override // com.baidu.tbadk.widget.TbImageView.g
        public void onCancel() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements BannerView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ m98 a;

        public b(m98 m98Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {m98Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = m98Var;
        }

        @Override // com.baidu.tbadk.coreExtra.view.BannerView.b
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.z();
            }
        }

        @Override // com.baidu.tbadk.coreExtra.view.BannerView.b
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.x();
            }
        }
    }

    /* loaded from: classes6.dex */
    public static /* synthetic */ class c {
        public static /* synthetic */ Interceptable $ic;
        public static final /* synthetic */ int[] a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-228663418, "Lcom/repackage/m98$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-228663418, "Lcom/repackage/m98$c;");
                    return;
                }
            }
            int[] iArr = new int[UtilHelper.NativePageType.values().length];
            a = iArr;
            try {
                iArr[UtilHelper.NativePageType.FRS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[UtilHelper.NativePageType.PB.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755544347, "Lcom/repackage/m98;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755544347, "Lcom/repackage/m98;");
                return;
            }
        }
        j = Pattern.compile("(/p/){1}(\\d+)");
    }

    public m98() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = null;
        this.c = false;
        this.i = new b(this);
    }

    public final void A(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || StringUtils.isNULL(str)) {
            return;
        }
        al8.b b2 = al8.b("ad_tpoint", "PT", "FRS", "c0129", "ad_plat", "VIEW_TRUE", str, this.h, this.g, null);
        b2.d(TiebaStatic.Params.OBJ_URL, this.b.b());
        b2.e();
    }

    public final void B(String str, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, str2) == null) || StringUtils.isNULL(str)) {
            return;
        }
        al8.b b2 = al8.b("ad_tpoint", "PT", "FRS", "c0129", "ad_plat", "CLICK", str, this.h, this.g, null);
        b2.d(TiebaStatic.Params.OBJ_URL, str2);
        b2.e();
    }

    @Override // com.repackage.yg5
    public void a(int i) {
        BannerView bannerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) || (bannerView = this.a) == null) {
            return;
        }
        bannerView.j();
    }

    @Override // com.repackage.yg5
    public void b(Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, obj) == null) && (obj instanceof xo4)) {
            this.b = (xo4) obj;
        }
    }

    @Override // com.repackage.yg5
    public void f(yg5.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, aVar) == null) {
            this.f = aVar;
        }
    }

    @Override // com.repackage.yg5
    public View getView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.a : (View) invokeV.objValue;
    }

    @Override // com.repackage.yg5
    public void h() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || this.e == null || this.f == null) {
            return;
        }
        xo4 xo4Var = this.b;
        if (xo4Var == null) {
            z();
        } else if (!xo4Var.e()) {
            z();
        } else {
            if (!this.c) {
                if (this.a != null) {
                    return;
                }
                BannerView bannerView = new BannerView(this.e.getPageActivity());
                this.a = bannerView;
                bannerView.setVisibility(8);
                this.a.setBannerViewClickListener(this.i);
                this.a.setBannerViewEvent(new a(this));
                if (this.b.d().startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL)) {
                    TiebaStatic.eventStat(this.e.getPageActivity(), "game_show", "show", 1, "ref_id", "4000601", "ref_type", GameCenterCoreUtils.REF_TYPE_FROM_FRS);
                }
            } else {
                this.f.a(this.d, this.a);
            }
            this.a.setBannerData(this.b);
            this.a.k();
            if (this.b.getType() != 1 || TextUtils.isEmpty(this.b.b())) {
                return;
            }
            this.a.setData(this.e, this.b.b());
        }
    }

    @Override // com.repackage.yg5
    public void j(int i) {
        BannerView bannerView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048583, this, i) == null) || (bannerView = this.a) == null) {
            return;
        }
        bannerView.setBannerMaskColor(i);
    }

    @Override // com.repackage.fh5
    public void setParams(Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, map) == null) || map == null || map.isEmpty()) {
            return;
        }
        this.g = map.get("forum_name");
        this.h = map.get("forum_id");
    }

    public final void x() {
        xo4 xo4Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048586, this) == null) || (xo4Var = this.b) == null) {
            return;
        }
        String d = xo4Var.d();
        String c2 = this.b.c();
        if (this.b.a() == 1) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new FacePackageDetailActivityConfig(this.e.getPageActivity(), d, false, "frs_banner")));
            B(c2, d);
        } else if (this.b.a() == 2) {
            if (d.contains(TbPatternsCompat.TB_DOMAIN_NAME)) {
                Matcher matcher = j.matcher(d);
                if (matcher.find()) {
                    try {
                        PbActivityConfig createNormalCfg = new PbActivityConfig(this.e.getPageActivity()).createNormalCfg(matcher.group(2), null, "frs_banner");
                        createNormalCfg.setVideo_source("frs");
                        this.e.sendMessage(new CustomMessage(2004001, createNormalCfg));
                        B(c2, d);
                    } catch (Exception e) {
                        BdLog.e(e.toString());
                    }
                }
            }
        } else if (this.b.a() == 3) {
            new UtilHelper.NativePage();
            UtilHelper.NativePage isNativeAddress = UtilHelper.isNativeAddress(d);
            UtilHelper.NativePageType nativePageType = isNativeAddress.type;
            if (nativePageType != UtilHelper.NativePageType.NONE) {
                int i = c.a[nativePageType.ordinal()];
                if (i == 1) {
                    this.e.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.e.getPageActivity()).createNormalCfg(isNativeAddress.id, "frs_banner")));
                } else if (i == 2) {
                    PbActivityConfig createNormalCfg2 = new PbActivityConfig(this.e.getPageActivity()).createNormalCfg(isNativeAddress.id, null, "frs_banner");
                    createNormalCfg2.setVideo_source("frs");
                    this.e.sendMessage(new CustomMessage(2004001, createNormalCfg2));
                }
            } else {
                fa8.q().e().c(this.e.getPageActivity(), new String[]{d}, null);
                if (!StringUtils.isNull(d) && d.startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL)) {
                    TiebaStatic.eventStat(this.e.getPageActivity(), "frs_banner", "click", 1, "ref_id", "4000601", "ref_type", GameCenterCoreUtils.REF_TYPE_FROM_FRS);
                }
            }
            B(c2, d);
        } else if (this.b.a() == 4) {
            this.e.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.e.getPageActivity()).createNormalCfg(d, "frs_banner")));
            B(c2, d);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.fh5
    /* renamed from: y */
    public void n(hh5 hh5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, hh5Var) == null) {
            this.d = hh5Var;
            if (hh5Var == null || !(hh5Var.a() instanceof TbPageContext)) {
                return;
            }
            this.e = (TbPageContext) this.d.a();
        }
    }

    public final void z() {
        BannerView bannerView;
        yg5.a aVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (bannerView = this.a) == null || (aVar = this.f) == null) {
            return;
        }
        this.c = false;
        aVar.b(this.d, bannerView);
        this.a = null;
    }
}

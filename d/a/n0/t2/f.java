package d.a.n0.t2;

import android.text.TextUtils;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
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
import d.a.m0.r.q.f0;
import d.a.n0.e.a.a;
import d.a.n0.e3.j0.a;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes5.dex */
public class f implements d.a.n0.e.a.a {
    public static final Pattern j = Pattern.compile("(/p/){1}(\\d+)");

    /* renamed from: b  reason: collision with root package name */
    public f0 f61047b;

    /* renamed from: d  reason: collision with root package name */
    public d.a.n0.e.e.c f61049d;

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext f61050e;

    /* renamed from: f  reason: collision with root package name */
    public a.InterfaceC1247a f61051f;

    /* renamed from: g  reason: collision with root package name */
    public String f61052g;

    /* renamed from: h  reason: collision with root package name */
    public String f61053h;

    /* renamed from: a  reason: collision with root package name */
    public BannerView f61046a = null;

    /* renamed from: c  reason: collision with root package name */
    public boolean f61048c = false;

    /* renamed from: i  reason: collision with root package name */
    public BannerView.b f61054i = new b();

    /* loaded from: classes5.dex */
    public class a implements TbImageView.f {
        public a() {
        }

        @Override // com.baidu.tbadk.widget.TbImageView.f
        public void a(String str, boolean z) {
            if (z) {
                if (f.this.f61047b != null && f.this.f61047b.f50019i) {
                    String c2 = f.this.f61047b.c();
                    if (!StringUtils.isNULL(c2)) {
                        f.this.B(c2);
                    }
                    f.this.f61047b.f50019i = false;
                }
                if (f.this.f61046a == null || !f.this.f61046a.i() || f.this.f61048c) {
                    return;
                }
                f.this.f61048c = true;
                f.this.f61051f.a(f.this.f61049d, f.this.f61046a);
            }
        }

        @Override // com.baidu.tbadk.widget.TbImageView.f
        public void onCancel() {
        }
    }

    /* loaded from: classes5.dex */
    public class b implements BannerView.b {
        public b() {
        }

        @Override // com.baidu.tbadk.coreExtra.view.BannerView.b
        public void a() {
            f.this.A();
        }

        @Override // com.baidu.tbadk.coreExtra.view.BannerView.b
        public void b() {
            f.this.y();
        }
    }

    /* loaded from: classes5.dex */
    public static /* synthetic */ class c {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f61057a;

        static {
            int[] iArr = new int[UtilHelper.NativePageType.values().length];
            f61057a = iArr;
            try {
                iArr[UtilHelper.NativePageType.FRS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f61057a[UtilHelper.NativePageType.PB.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public final void A() {
        a.InterfaceC1247a interfaceC1247a;
        BannerView bannerView = this.f61046a;
        if (bannerView == null || (interfaceC1247a = this.f61051f) == null) {
            return;
        }
        this.f61048c = false;
        interfaceC1247a.b(this.f61049d, bannerView);
        this.f61046a = null;
    }

    public final void B(String str) {
        if (StringUtils.isNULL(str)) {
            return;
        }
        a.b b2 = d.a.n0.e3.j0.a.b("ad_tpoint", "PT", "FRS", "c0129", "ad_plat", "VIEW_TRUE", str, this.f61053h, this.f61052g, null);
        b2.e(TiebaStatic.Params.OBJ_URL, this.f61047b.b());
        b2.f();
    }

    public final void C(String str, String str2) {
        if (StringUtils.isNULL(str)) {
            return;
        }
        a.b b2 = d.a.n0.e3.j0.a.b("ad_tpoint", "PT", "FRS", "c0129", "ad_plat", "CLICK", str, this.f61053h, this.f61052g, null);
        b2.e(TiebaStatic.Params.OBJ_URL, str2);
        b2.f();
    }

    @Override // d.a.n0.e.a.a
    public void a(int i2) {
        BannerView bannerView = this.f61046a;
        if (bannerView != null) {
            bannerView.j();
        }
    }

    @Override // d.a.n0.e.e.a
    public void b(Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            return;
        }
        this.f61052g = map.get("forum_name");
        this.f61053h = map.get("forum_id");
    }

    @Override // d.a.n0.e.a.a
    public void c(Object obj) {
        if (obj instanceof f0) {
            this.f61047b = (f0) obj;
        }
    }

    @Override // d.a.n0.e.a.a
    public void g(a.InterfaceC1247a interfaceC1247a) {
        this.f61051f = interfaceC1247a;
    }

    @Override // d.a.n0.e.a.a
    public View getView() {
        return this.f61046a;
    }

    @Override // d.a.n0.e.a.a
    public void i() {
        if (this.f61050e == null || this.f61051f == null) {
            return;
        }
        f0 f0Var = this.f61047b;
        if (f0Var == null) {
            A();
        } else if (!f0Var.f()) {
            A();
        } else {
            if (!this.f61048c) {
                if (this.f61046a != null) {
                    return;
                }
                BannerView bannerView = new BannerView(this.f61050e.getPageActivity());
                this.f61046a = bannerView;
                bannerView.setVisibility(8);
                this.f61046a.setBannerViewClickListener(this.f61054i);
                this.f61046a.setBannerViewEvent(new a());
                if (this.f61047b.e().startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL)) {
                    TiebaStatic.eventStat(this.f61050e.getPageActivity(), "game_show", "show", 1, "ref_id", "4000601", "ref_type", "603");
                }
            } else {
                this.f61051f.a(this.f61049d, this.f61046a);
            }
            this.f61046a.setBannerData(this.f61047b);
            this.f61046a.k();
            if (this.f61047b.d() != 1 || TextUtils.isEmpty(this.f61047b.b())) {
                return;
            }
            this.f61046a.setData(this.f61050e, this.f61047b.b());
        }
    }

    @Override // d.a.n0.e.a.a
    public void k(int i2) {
        BannerView bannerView = this.f61046a;
        if (bannerView != null) {
            bannerView.setBannerMaskColor(i2);
        }
    }

    public final void y() {
        f0 f0Var = this.f61047b;
        if (f0Var == null) {
            return;
        }
        String e2 = f0Var.e();
        String c2 = this.f61047b.c();
        if (this.f61047b.a() == 1) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new FacePackageDetailActivityConfig(this.f61050e.getPageActivity(), e2, false, "frs_banner")));
            C(c2, e2);
        } else if (this.f61047b.a() == 2) {
            if (e2.contains(TbPatternsCompat.TB_DOMAIN_NAME)) {
                Matcher matcher = j.matcher(e2);
                if (matcher.find()) {
                    try {
                        PbActivityConfig createNormalCfg = new PbActivityConfig(this.f61050e.getPageActivity()).createNormalCfg(matcher.group(2), null, "frs_banner");
                        createNormalCfg.setVideo_source("frs");
                        this.f61050e.sendMessage(new CustomMessage(2004001, createNormalCfg));
                        C(c2, e2);
                    } catch (Exception e3) {
                        BdLog.e(e3.toString());
                    }
                }
            }
        } else if (this.f61047b.a() == 3) {
            new UtilHelper.NativePage();
            UtilHelper.NativePage isNativeAddress = UtilHelper.isNativeAddress(e2);
            UtilHelper.NativePageType nativePageType = isNativeAddress.type;
            if (nativePageType != UtilHelper.NativePageType.NONE) {
                int i2 = c.f61057a[nativePageType.ordinal()];
                if (i2 == 1) {
                    this.f61050e.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.f61050e.getPageActivity()).createNormalCfg(isNativeAddress.id, "frs_banner")));
                } else if (i2 == 2) {
                    PbActivityConfig createNormalCfg2 = new PbActivityConfig(this.f61050e.getPageActivity()).createNormalCfg(isNativeAddress.id, null, "frs_banner");
                    createNormalCfg2.setVideo_source("frs");
                    this.f61050e.sendMessage(new CustomMessage(2004001, createNormalCfg2));
                }
            } else {
                x.p().g().c(this.f61050e.getPageActivity(), new String[]{e2}, null);
                if (!StringUtils.isNull(e2) && e2.startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL)) {
                    TiebaStatic.eventStat(this.f61050e.getPageActivity(), "frs_banner", PrefetchEvent.STATE_CLICK, 1, "ref_id", "4000601", "ref_type", "603");
                }
            }
            C(c2, e2);
        } else if (this.f61047b.a() == 4) {
            this.f61050e.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.f61050e.getPageActivity()).createNormalCfg(e2, "frs_banner")));
            C(c2, e2);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.n0.e.e.a
    /* renamed from: z */
    public void o(d.a.n0.e.e.c cVar) {
        this.f61049d = cVar;
        if (cVar == null || !(cVar.a() instanceof TbPageContext)) {
            return;
        }
        this.f61050e = (TbPageContext) this.f61049d.a();
    }
}

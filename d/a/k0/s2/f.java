package d.a.k0.s2;

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
import d.a.j0.r.q.f0;
import d.a.k0.d3.j0.a;
import d.a.k0.e.a.a;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes5.dex */
public class f implements d.a.k0.e.a.a {
    public static final Pattern j = Pattern.compile("(/p/){1}(\\d+)");

    /* renamed from: b  reason: collision with root package name */
    public f0 f60945b;

    /* renamed from: d  reason: collision with root package name */
    public d.a.k0.e.e.c f60947d;

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext f60948e;

    /* renamed from: f  reason: collision with root package name */
    public a.InterfaceC1283a f60949f;

    /* renamed from: g  reason: collision with root package name */
    public String f60950g;

    /* renamed from: h  reason: collision with root package name */
    public String f60951h;

    /* renamed from: a  reason: collision with root package name */
    public BannerView f60944a = null;

    /* renamed from: c  reason: collision with root package name */
    public boolean f60946c = false;

    /* renamed from: i  reason: collision with root package name */
    public BannerView.b f60952i = new b();

    /* loaded from: classes5.dex */
    public class a implements TbImageView.f {
        public a() {
        }

        @Override // com.baidu.tbadk.widget.TbImageView.f
        public void a(String str, boolean z) {
            if (z) {
                if (f.this.f60945b != null && f.this.f60945b.f49975i) {
                    String c2 = f.this.f60945b.c();
                    if (!StringUtils.isNULL(c2)) {
                        f.this.B(c2);
                    }
                    f.this.f60945b.f49975i = false;
                }
                if (f.this.f60944a == null || !f.this.f60944a.i() || f.this.f60946c) {
                    return;
                }
                f.this.f60946c = true;
                f.this.f60949f.a(f.this.f60947d, f.this.f60944a);
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
        public static final /* synthetic */ int[] f60955a;

        static {
            int[] iArr = new int[UtilHelper.NativePageType.values().length];
            f60955a = iArr;
            try {
                iArr[UtilHelper.NativePageType.FRS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f60955a[UtilHelper.NativePageType.PB.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public final void A() {
        a.InterfaceC1283a interfaceC1283a;
        BannerView bannerView = this.f60944a;
        if (bannerView == null || (interfaceC1283a = this.f60949f) == null) {
            return;
        }
        this.f60946c = false;
        interfaceC1283a.b(this.f60947d, bannerView);
        this.f60944a = null;
    }

    public final void B(String str) {
        if (StringUtils.isNULL(str)) {
            return;
        }
        a.b b2 = d.a.k0.d3.j0.a.b("ad_tpoint", "PT", "FRS", "c0129", "ad_plat", "VIEW_TRUE", str, this.f60951h, this.f60950g, null);
        b2.e(TiebaStatic.Params.OBJ_URL, this.f60945b.b());
        b2.f();
    }

    public final void C(String str, String str2) {
        if (StringUtils.isNULL(str)) {
            return;
        }
        a.b b2 = d.a.k0.d3.j0.a.b("ad_tpoint", "PT", "FRS", "c0129", "ad_plat", "CLICK", str, this.f60951h, this.f60950g, null);
        b2.e(TiebaStatic.Params.OBJ_URL, str2);
        b2.f();
    }

    @Override // d.a.k0.e.a.a
    public void a(int i2) {
        BannerView bannerView = this.f60944a;
        if (bannerView != null) {
            bannerView.j();
        }
    }

    @Override // d.a.k0.e.e.a
    public void b(Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            return;
        }
        this.f60950g = map.get("forum_name");
        this.f60951h = map.get("forum_id");
    }

    @Override // d.a.k0.e.a.a
    public void c(Object obj) {
        if (obj instanceof f0) {
            this.f60945b = (f0) obj;
        }
    }

    @Override // d.a.k0.e.a.a
    public void g(a.InterfaceC1283a interfaceC1283a) {
        this.f60949f = interfaceC1283a;
    }

    @Override // d.a.k0.e.a.a
    public View getView() {
        return this.f60944a;
    }

    @Override // d.a.k0.e.a.a
    public void i() {
        if (this.f60948e == null || this.f60949f == null) {
            return;
        }
        f0 f0Var = this.f60945b;
        if (f0Var == null) {
            A();
        } else if (!f0Var.f()) {
            A();
        } else {
            if (!this.f60946c) {
                if (this.f60944a != null) {
                    return;
                }
                BannerView bannerView = new BannerView(this.f60948e.getPageActivity());
                this.f60944a = bannerView;
                bannerView.setVisibility(8);
                this.f60944a.setBannerViewClickListener(this.f60952i);
                this.f60944a.setBannerViewEvent(new a());
                if (this.f60945b.e().startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL)) {
                    TiebaStatic.eventStat(this.f60948e.getPageActivity(), "game_show", "show", 1, "ref_id", "4000601", "ref_type", "603");
                }
            } else {
                this.f60949f.a(this.f60947d, this.f60944a);
            }
            this.f60944a.setBannerData(this.f60945b);
            this.f60944a.k();
            if (this.f60945b.d() != 1 || TextUtils.isEmpty(this.f60945b.b())) {
                return;
            }
            this.f60944a.setData(this.f60948e, this.f60945b.b());
        }
    }

    @Override // d.a.k0.e.a.a
    public void k(int i2) {
        BannerView bannerView = this.f60944a;
        if (bannerView != null) {
            bannerView.setBannerMaskColor(i2);
        }
    }

    public final void y() {
        f0 f0Var = this.f60945b;
        if (f0Var == null) {
            return;
        }
        String e2 = f0Var.e();
        String c2 = this.f60945b.c();
        if (this.f60945b.a() == 1) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new FacePackageDetailActivityConfig(this.f60948e.getPageActivity(), e2, false, "frs_banner")));
            C(c2, e2);
        } else if (this.f60945b.a() == 2) {
            if (e2.contains(TbPatternsCompat.TB_DOMAIN_NAME)) {
                Matcher matcher = j.matcher(e2);
                if (matcher.find()) {
                    try {
                        PbActivityConfig createNormalCfg = new PbActivityConfig(this.f60948e.getPageActivity()).createNormalCfg(matcher.group(2), null, "frs_banner");
                        createNormalCfg.setVideo_source("frs");
                        this.f60948e.sendMessage(new CustomMessage(2004001, createNormalCfg));
                        C(c2, e2);
                    } catch (Exception e3) {
                        BdLog.e(e3.toString());
                    }
                }
            }
        } else if (this.f60945b.a() == 3) {
            new UtilHelper.NativePage();
            UtilHelper.NativePage isNativeAddress = UtilHelper.isNativeAddress(e2);
            UtilHelper.NativePageType nativePageType = isNativeAddress.type;
            if (nativePageType != UtilHelper.NativePageType.NONE) {
                int i2 = c.f60955a[nativePageType.ordinal()];
                if (i2 == 1) {
                    this.f60948e.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.f60948e.getPageActivity()).createNormalCfg(isNativeAddress.id, "frs_banner")));
                } else if (i2 == 2) {
                    PbActivityConfig createNormalCfg2 = new PbActivityConfig(this.f60948e.getPageActivity()).createNormalCfg(isNativeAddress.id, null, "frs_banner");
                    createNormalCfg2.setVideo_source("frs");
                    this.f60948e.sendMessage(new CustomMessage(2004001, createNormalCfg2));
                }
            } else {
                x.p().g().c(this.f60948e.getPageActivity(), new String[]{e2}, null);
                if (!StringUtils.isNull(e2) && e2.startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL)) {
                    TiebaStatic.eventStat(this.f60948e.getPageActivity(), "frs_banner", PrefetchEvent.STATE_CLICK, 1, "ref_id", "4000601", "ref_type", "603");
                }
            }
            C(c2, e2);
        } else if (this.f60945b.a() == 4) {
            this.f60948e.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.f60948e.getPageActivity()).createNormalCfg(e2, "frs_banner")));
            C(c2, e2);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.k0.e.e.a
    /* renamed from: z */
    public void o(d.a.k0.e.e.c cVar) {
        this.f60947d = cVar;
        if (cVar == null || !(cVar.a() instanceof TbPageContext)) {
            return;
        }
        this.f60948e = (TbPageContext) this.f60947d.a();
    }
}

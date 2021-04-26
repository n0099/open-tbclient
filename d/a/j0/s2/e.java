package d.a.j0.s2;

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
import d.a.i0.r.q.f0;
import d.a.j0.d3.j0.a;
import d.a.j0.e.a.a;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes3.dex */
public class e implements d.a.j0.e.a.a {
    public static final Pattern j = Pattern.compile("(/p/){1}(\\d+)");

    /* renamed from: b  reason: collision with root package name */
    public f0 f60216b;

    /* renamed from: d  reason: collision with root package name */
    public d.a.j0.e.e.c f60218d;

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext f60219e;

    /* renamed from: f  reason: collision with root package name */
    public a.InterfaceC1211a f60220f;

    /* renamed from: g  reason: collision with root package name */
    public String f60221g;

    /* renamed from: h  reason: collision with root package name */
    public String f60222h;

    /* renamed from: a  reason: collision with root package name */
    public BannerView f60215a = null;

    /* renamed from: c  reason: collision with root package name */
    public boolean f60217c = false;

    /* renamed from: i  reason: collision with root package name */
    public BannerView.b f60223i = new b();

    /* loaded from: classes3.dex */
    public class a implements TbImageView.f {
        public a() {
        }

        @Override // com.baidu.tbadk.widget.TbImageView.f
        public void a(String str, boolean z) {
            if (z) {
                if (e.this.f60216b != null && e.this.f60216b.f49156i) {
                    String c2 = e.this.f60216b.c();
                    if (!StringUtils.isNULL(c2)) {
                        e.this.B(c2);
                    }
                    e.this.f60216b.f49156i = false;
                }
                if (e.this.f60215a == null || !e.this.f60215a.i() || e.this.f60217c) {
                    return;
                }
                e.this.f60217c = true;
                e.this.f60220f.a(e.this.f60218d, e.this.f60215a);
            }
        }

        @Override // com.baidu.tbadk.widget.TbImageView.f
        public void onCancel() {
        }
    }

    /* loaded from: classes3.dex */
    public class b implements BannerView.b {
        public b() {
        }

        @Override // com.baidu.tbadk.coreExtra.view.BannerView.b
        public void a() {
            e.this.A();
        }

        @Override // com.baidu.tbadk.coreExtra.view.BannerView.b
        public void b() {
            e.this.y();
        }
    }

    /* loaded from: classes3.dex */
    public static /* synthetic */ class c {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f60226a;

        static {
            int[] iArr = new int[UtilHelper.NativePageType.values().length];
            f60226a = iArr;
            try {
                iArr[UtilHelper.NativePageType.FRS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f60226a[UtilHelper.NativePageType.PB.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public final void A() {
        a.InterfaceC1211a interfaceC1211a;
        BannerView bannerView = this.f60215a;
        if (bannerView == null || (interfaceC1211a = this.f60220f) == null) {
            return;
        }
        this.f60217c = false;
        interfaceC1211a.b(this.f60218d, bannerView);
        this.f60215a = null;
    }

    public final void B(String str) {
        if (StringUtils.isNULL(str)) {
            return;
        }
        a.b b2 = d.a.j0.d3.j0.a.b("ad_tpoint", "PT", "FRS", "c0129", "ad_plat", "VIEW_TRUE", str, this.f60222h, this.f60221g, null);
        b2.e(TiebaStatic.Params.OBJ_URL, this.f60216b.b());
        b2.f();
    }

    public final void C(String str, String str2) {
        if (StringUtils.isNULL(str)) {
            return;
        }
        a.b b2 = d.a.j0.d3.j0.a.b("ad_tpoint", "PT", "FRS", "c0129", "ad_plat", "CLICK", str, this.f60222h, this.f60221g, null);
        b2.e(TiebaStatic.Params.OBJ_URL, str2);
        b2.f();
    }

    @Override // d.a.j0.e.a.a
    public void a(int i2) {
        BannerView bannerView = this.f60215a;
        if (bannerView != null) {
            bannerView.j();
        }
    }

    @Override // d.a.j0.e.e.a
    public void b(Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            return;
        }
        this.f60221g = map.get("forum_name");
        this.f60222h = map.get("forum_id");
    }

    @Override // d.a.j0.e.a.a
    public void c(Object obj) {
        if (obj instanceof f0) {
            this.f60216b = (f0) obj;
        }
    }

    @Override // d.a.j0.e.a.a
    public void g(a.InterfaceC1211a interfaceC1211a) {
        this.f60220f = interfaceC1211a;
    }

    @Override // d.a.j0.e.a.a
    public View getView() {
        return this.f60215a;
    }

    @Override // d.a.j0.e.a.a
    public void i() {
        if (this.f60219e == null || this.f60220f == null) {
            return;
        }
        f0 f0Var = this.f60216b;
        if (f0Var == null) {
            A();
        } else if (!f0Var.f()) {
            A();
        } else {
            if (!this.f60217c) {
                if (this.f60215a != null) {
                    return;
                }
                BannerView bannerView = new BannerView(this.f60219e.getPageActivity());
                this.f60215a = bannerView;
                bannerView.setVisibility(8);
                this.f60215a.setBannerViewClickListener(this.f60223i);
                this.f60215a.setBannerViewEvent(new a());
                if (this.f60216b.e().startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL)) {
                    TiebaStatic.eventStat(this.f60219e.getPageActivity(), "game_show", "show", 1, "ref_id", "4000601", "ref_type", "603");
                }
            } else {
                this.f60220f.a(this.f60218d, this.f60215a);
            }
            this.f60215a.setBannerData(this.f60216b);
            this.f60215a.k();
            if (this.f60216b.d() != 1 || TextUtils.isEmpty(this.f60216b.b())) {
                return;
            }
            this.f60215a.setData(this.f60219e, this.f60216b.b());
        }
    }

    @Override // d.a.j0.e.a.a
    public void k(int i2) {
        BannerView bannerView = this.f60215a;
        if (bannerView != null) {
            bannerView.setBannerMaskColor(i2);
        }
    }

    public final void y() {
        f0 f0Var = this.f60216b;
        if (f0Var == null) {
            return;
        }
        String e2 = f0Var.e();
        String c2 = this.f60216b.c();
        if (this.f60216b.a() == 1) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new FacePackageDetailActivityConfig(this.f60219e.getPageActivity(), e2, false, "frs_banner")));
            C(c2, e2);
        } else if (this.f60216b.a() == 2) {
            if (e2.contains(TbPatternsCompat.TB_DOMAIN_NAME)) {
                Matcher matcher = j.matcher(e2);
                if (matcher.find()) {
                    try {
                        PbActivityConfig createNormalCfg = new PbActivityConfig(this.f60219e.getPageActivity()).createNormalCfg(matcher.group(2), null, "frs_banner");
                        createNormalCfg.setVideo_source("frs");
                        this.f60219e.sendMessage(new CustomMessage(2004001, createNormalCfg));
                        C(c2, e2);
                    } catch (Exception e3) {
                        BdLog.e(e3.toString());
                    }
                }
            }
        } else if (this.f60216b.a() == 3) {
            new UtilHelper.NativePage();
            UtilHelper.NativePage isNativeAddress = UtilHelper.isNativeAddress(e2);
            UtilHelper.NativePageType nativePageType = isNativeAddress.type;
            if (nativePageType != UtilHelper.NativePageType.NONE) {
                int i2 = c.f60226a[nativePageType.ordinal()];
                if (i2 == 1) {
                    this.f60219e.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.f60219e.getPageActivity()).createNormalCfg(isNativeAddress.id, "frs_banner")));
                } else if (i2 == 2) {
                    PbActivityConfig createNormalCfg2 = new PbActivityConfig(this.f60219e.getPageActivity()).createNormalCfg(isNativeAddress.id, null, "frs_banner");
                    createNormalCfg2.setVideo_source("frs");
                    this.f60219e.sendMessage(new CustomMessage(2004001, createNormalCfg2));
                }
            } else {
                w.p().g().c(this.f60219e.getPageActivity(), new String[]{e2}, null);
                if (!StringUtils.isNull(e2) && e2.startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL)) {
                    TiebaStatic.eventStat(this.f60219e.getPageActivity(), "frs_banner", PrefetchEvent.STATE_CLICK, 1, "ref_id", "4000601", "ref_type", "603");
                }
            }
            C(c2, e2);
        } else if (this.f60216b.a() == 4) {
            this.f60219e.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.f60219e.getPageActivity()).createNormalCfg(e2, "frs_banner")));
            C(c2, e2);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.j0.e.e.a
    /* renamed from: z */
    public void o(d.a.j0.e.e.c cVar) {
        this.f60218d = cVar;
        if (cVar == null || !(cVar.a() instanceof TbPageContext)) {
            return;
        }
        this.f60219e = (TbPageContext) this.f60218d.a();
    }
}

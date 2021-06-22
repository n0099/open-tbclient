package d.a.o0.t2;

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
import d.a.n0.r.q.f0;
import d.a.o0.e.a.a;
import d.a.o0.e3.j0.a;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes5.dex */
public class f implements d.a.o0.e.a.a {
    public static final Pattern j = Pattern.compile("(/p/){1}(\\d+)");

    /* renamed from: b  reason: collision with root package name */
    public f0 f64864b;

    /* renamed from: d  reason: collision with root package name */
    public d.a.o0.e.e.c f64866d;

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext f64867e;

    /* renamed from: f  reason: collision with root package name */
    public a.InterfaceC1307a f64868f;

    /* renamed from: g  reason: collision with root package name */
    public String f64869g;

    /* renamed from: h  reason: collision with root package name */
    public String f64870h;

    /* renamed from: a  reason: collision with root package name */
    public BannerView f64863a = null;

    /* renamed from: c  reason: collision with root package name */
    public boolean f64865c = false;

    /* renamed from: i  reason: collision with root package name */
    public BannerView.b f64871i = new b();

    /* loaded from: classes5.dex */
    public class a implements TbImageView.f {
        public a() {
        }

        @Override // com.baidu.tbadk.widget.TbImageView.f
        public void a(String str, boolean z) {
            if (z) {
                if (f.this.f64864b != null && f.this.f64864b.f53802i) {
                    String c2 = f.this.f64864b.c();
                    if (!StringUtils.isNULL(c2)) {
                        f.this.B(c2);
                    }
                    f.this.f64864b.f53802i = false;
                }
                if (f.this.f64863a == null || !f.this.f64863a.i() || f.this.f64865c) {
                    return;
                }
                f.this.f64865c = true;
                f.this.f64868f.a(f.this.f64866d, f.this.f64863a);
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
        public static final /* synthetic */ int[] f64874a;

        static {
            int[] iArr = new int[UtilHelper.NativePageType.values().length];
            f64874a = iArr;
            try {
                iArr[UtilHelper.NativePageType.FRS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f64874a[UtilHelper.NativePageType.PB.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public final void A() {
        a.InterfaceC1307a interfaceC1307a;
        BannerView bannerView = this.f64863a;
        if (bannerView == null || (interfaceC1307a = this.f64868f) == null) {
            return;
        }
        this.f64865c = false;
        interfaceC1307a.b(this.f64866d, bannerView);
        this.f64863a = null;
    }

    public final void B(String str) {
        if (StringUtils.isNULL(str)) {
            return;
        }
        a.b b2 = d.a.o0.e3.j0.a.b("ad_tpoint", "PT", "FRS", "c0129", "ad_plat", "VIEW_TRUE", str, this.f64870h, this.f64869g, null);
        b2.e(TiebaStatic.Params.OBJ_URL, this.f64864b.b());
        b2.f();
    }

    public final void C(String str, String str2) {
        if (StringUtils.isNULL(str)) {
            return;
        }
        a.b b2 = d.a.o0.e3.j0.a.b("ad_tpoint", "PT", "FRS", "c0129", "ad_plat", "CLICK", str, this.f64870h, this.f64869g, null);
        b2.e(TiebaStatic.Params.OBJ_URL, str2);
        b2.f();
    }

    @Override // d.a.o0.e.a.a
    public void a(int i2) {
        BannerView bannerView = this.f64863a;
        if (bannerView != null) {
            bannerView.j();
        }
    }

    @Override // d.a.o0.e.e.a
    public void b(Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            return;
        }
        this.f64869g = map.get("forum_name");
        this.f64870h = map.get("forum_id");
    }

    @Override // d.a.o0.e.a.a
    public void c(Object obj) {
        if (obj instanceof f0) {
            this.f64864b = (f0) obj;
        }
    }

    @Override // d.a.o0.e.a.a
    public void g(a.InterfaceC1307a interfaceC1307a) {
        this.f64868f = interfaceC1307a;
    }

    @Override // d.a.o0.e.a.a
    public View getView() {
        return this.f64863a;
    }

    @Override // d.a.o0.e.a.a
    public void i() {
        if (this.f64867e == null || this.f64868f == null) {
            return;
        }
        f0 f0Var = this.f64864b;
        if (f0Var == null) {
            A();
        } else if (!f0Var.f()) {
            A();
        } else {
            if (!this.f64865c) {
                if (this.f64863a != null) {
                    return;
                }
                BannerView bannerView = new BannerView(this.f64867e.getPageActivity());
                this.f64863a = bannerView;
                bannerView.setVisibility(8);
                this.f64863a.setBannerViewClickListener(this.f64871i);
                this.f64863a.setBannerViewEvent(new a());
                if (this.f64864b.e().startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL)) {
                    TiebaStatic.eventStat(this.f64867e.getPageActivity(), "game_show", "show", 1, "ref_id", "4000601", "ref_type", "603");
                }
            } else {
                this.f64868f.a(this.f64866d, this.f64863a);
            }
            this.f64863a.setBannerData(this.f64864b);
            this.f64863a.k();
            if (this.f64864b.d() != 1 || TextUtils.isEmpty(this.f64864b.b())) {
                return;
            }
            this.f64863a.setData(this.f64867e, this.f64864b.b());
        }
    }

    @Override // d.a.o0.e.a.a
    public void k(int i2) {
        BannerView bannerView = this.f64863a;
        if (bannerView != null) {
            bannerView.setBannerMaskColor(i2);
        }
    }

    public final void y() {
        f0 f0Var = this.f64864b;
        if (f0Var == null) {
            return;
        }
        String e2 = f0Var.e();
        String c2 = this.f64864b.c();
        if (this.f64864b.a() == 1) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new FacePackageDetailActivityConfig(this.f64867e.getPageActivity(), e2, false, "frs_banner")));
            C(c2, e2);
        } else if (this.f64864b.a() == 2) {
            if (e2.contains(TbPatternsCompat.TB_DOMAIN_NAME)) {
                Matcher matcher = j.matcher(e2);
                if (matcher.find()) {
                    try {
                        PbActivityConfig createNormalCfg = new PbActivityConfig(this.f64867e.getPageActivity()).createNormalCfg(matcher.group(2), null, "frs_banner");
                        createNormalCfg.setVideo_source("frs");
                        this.f64867e.sendMessage(new CustomMessage(2004001, createNormalCfg));
                        C(c2, e2);
                    } catch (Exception e3) {
                        BdLog.e(e3.toString());
                    }
                }
            }
        } else if (this.f64864b.a() == 3) {
            new UtilHelper.NativePage();
            UtilHelper.NativePage isNativeAddress = UtilHelper.isNativeAddress(e2);
            UtilHelper.NativePageType nativePageType = isNativeAddress.type;
            if (nativePageType != UtilHelper.NativePageType.NONE) {
                int i2 = c.f64874a[nativePageType.ordinal()];
                if (i2 == 1) {
                    this.f64867e.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.f64867e.getPageActivity()).createNormalCfg(isNativeAddress.id, "frs_banner")));
                } else if (i2 == 2) {
                    PbActivityConfig createNormalCfg2 = new PbActivityConfig(this.f64867e.getPageActivity()).createNormalCfg(isNativeAddress.id, null, "frs_banner");
                    createNormalCfg2.setVideo_source("frs");
                    this.f64867e.sendMessage(new CustomMessage(2004001, createNormalCfg2));
                }
            } else {
                x.p().g().c(this.f64867e.getPageActivity(), new String[]{e2}, null);
                if (!StringUtils.isNull(e2) && e2.startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL)) {
                    TiebaStatic.eventStat(this.f64867e.getPageActivity(), "frs_banner", PrefetchEvent.STATE_CLICK, 1, "ref_id", "4000601", "ref_type", "603");
                }
            }
            C(c2, e2);
        } else if (this.f64864b.a() == 4) {
            this.f64867e.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.f64867e.getPageActivity()).createNormalCfg(e2, "frs_banner")));
            C(c2, e2);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.o0.e.e.a
    /* renamed from: z */
    public void o(d.a.o0.e.e.c cVar) {
        this.f64866d = cVar;
        if (cVar == null || !(cVar.a() instanceof TbPageContext)) {
            return;
        }
        this.f64867e = (TbPageContext) this.f64866d.a();
    }
}

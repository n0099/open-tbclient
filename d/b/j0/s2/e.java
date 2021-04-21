package d.b.j0.s2;

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
import d.b.i0.r.q.f0;
import d.b.j0.d3.j0.a;
import d.b.j0.e.a.a;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes4.dex */
public class e implements d.b.j0.e.a.a {
    public static final Pattern j = Pattern.compile("(/p/){1}(\\d+)");

    /* renamed from: b  reason: collision with root package name */
    public f0 f62076b;

    /* renamed from: d  reason: collision with root package name */
    public d.b.j0.e.e.c f62078d;

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext f62079e;

    /* renamed from: f  reason: collision with root package name */
    public a.InterfaceC1272a f62080f;

    /* renamed from: g  reason: collision with root package name */
    public String f62081g;

    /* renamed from: h  reason: collision with root package name */
    public String f62082h;

    /* renamed from: a  reason: collision with root package name */
    public BannerView f62075a = null;

    /* renamed from: c  reason: collision with root package name */
    public boolean f62077c = false;
    public BannerView.b i = new b();

    /* loaded from: classes4.dex */
    public class a implements TbImageView.f {
        public a() {
        }

        @Override // com.baidu.tbadk.widget.TbImageView.f
        public void a(String str, boolean z) {
            if (z) {
                if (e.this.f62076b != null && e.this.f62076b.i) {
                    String c2 = e.this.f62076b.c();
                    if (!StringUtils.isNULL(c2)) {
                        e.this.B(c2);
                    }
                    e.this.f62076b.i = false;
                }
                if (e.this.f62075a == null || !e.this.f62075a.i() || e.this.f62077c) {
                    return;
                }
                e.this.f62077c = true;
                e.this.f62080f.a(e.this.f62078d, e.this.f62075a);
            }
        }

        @Override // com.baidu.tbadk.widget.TbImageView.f
        public void onCancel() {
        }
    }

    /* loaded from: classes4.dex */
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

    /* loaded from: classes4.dex */
    public static /* synthetic */ class c {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f62085a;

        static {
            int[] iArr = new int[UtilHelper.NativePageType.values().length];
            f62085a = iArr;
            try {
                iArr[UtilHelper.NativePageType.FRS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f62085a[UtilHelper.NativePageType.PB.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public final void A() {
        a.InterfaceC1272a interfaceC1272a;
        BannerView bannerView = this.f62075a;
        if (bannerView == null || (interfaceC1272a = this.f62080f) == null) {
            return;
        }
        this.f62077c = false;
        interfaceC1272a.b(this.f62078d, bannerView);
        this.f62075a = null;
    }

    public final void B(String str) {
        if (StringUtils.isNULL(str)) {
            return;
        }
        a.b b2 = d.b.j0.d3.j0.a.b("ad_tpoint", "PT", "FRS", "c0129", "ad_plat", "VIEW_TRUE", str, this.f62082h, this.f62081g, null);
        b2.e(TiebaStatic.Params.OBJ_URL, this.f62076b.b());
        b2.f();
    }

    public final void C(String str, String str2) {
        if (StringUtils.isNULL(str)) {
            return;
        }
        a.b b2 = d.b.j0.d3.j0.a.b("ad_tpoint", "PT", "FRS", "c0129", "ad_plat", "CLICK", str, this.f62082h, this.f62081g, null);
        b2.e(TiebaStatic.Params.OBJ_URL, str2);
        b2.f();
    }

    @Override // d.b.j0.e.a.a
    public void a(int i) {
        BannerView bannerView = this.f62075a;
        if (bannerView != null) {
            bannerView.j();
        }
    }

    @Override // d.b.j0.e.e.a
    public void b(Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            return;
        }
        this.f62081g = map.get("forum_name");
        this.f62082h = map.get("forum_id");
    }

    @Override // d.b.j0.e.a.a
    public void c(Object obj) {
        if (obj instanceof f0) {
            this.f62076b = (f0) obj;
        }
    }

    @Override // d.b.j0.e.a.a
    public void d(a.InterfaceC1272a interfaceC1272a) {
        this.f62080f = interfaceC1272a;
    }

    @Override // d.b.j0.e.a.a
    public void g() {
        if (this.f62079e == null || this.f62080f == null) {
            return;
        }
        f0 f0Var = this.f62076b;
        if (f0Var == null) {
            A();
        } else if (!f0Var.f()) {
            A();
        } else {
            if (!this.f62077c) {
                if (this.f62075a != null) {
                    return;
                }
                BannerView bannerView = new BannerView(this.f62079e.getPageActivity());
                this.f62075a = bannerView;
                bannerView.setVisibility(8);
                this.f62075a.setBannerViewClickListener(this.i);
                this.f62075a.setBannerViewEvent(new a());
                if (this.f62076b.e().startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL)) {
                    TiebaStatic.eventStat(this.f62079e.getPageActivity(), "game_show", "show", 1, "ref_id", "4000601", "ref_type", "603");
                }
            } else {
                this.f62080f.a(this.f62078d, this.f62075a);
            }
            this.f62075a.setBannerData(this.f62076b);
            this.f62075a.k();
            if (this.f62076b.d() != 1 || TextUtils.isEmpty(this.f62076b.b())) {
                return;
            }
            this.f62075a.setData(this.f62079e, this.f62076b.b());
        }
    }

    @Override // d.b.j0.e.a.a
    public View getView() {
        return this.f62075a;
    }

    @Override // d.b.j0.e.a.a
    public void j(int i) {
        BannerView bannerView = this.f62075a;
        if (bannerView != null) {
            bannerView.setBannerMaskColor(i);
        }
    }

    public final void y() {
        f0 f0Var = this.f62076b;
        if (f0Var == null) {
            return;
        }
        String e2 = f0Var.e();
        String c2 = this.f62076b.c();
        if (this.f62076b.a() == 1) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new FacePackageDetailActivityConfig(this.f62079e.getPageActivity(), e2, false, "frs_banner")));
            C(c2, e2);
        } else if (this.f62076b.a() == 2) {
            if (e2.contains(TbPatternsCompat.TB_DOMAIN_NAME)) {
                Matcher matcher = j.matcher(e2);
                if (matcher.find()) {
                    try {
                        PbActivityConfig createNormalCfg = new PbActivityConfig(this.f62079e.getPageActivity()).createNormalCfg(matcher.group(2), null, "frs_banner");
                        createNormalCfg.setVideo_source("frs");
                        this.f62079e.sendMessage(new CustomMessage(2004001, createNormalCfg));
                        C(c2, e2);
                    } catch (Exception e3) {
                        BdLog.e(e3.toString());
                    }
                }
            }
        } else if (this.f62076b.a() == 3) {
            new UtilHelper.NativePage();
            UtilHelper.NativePage isNativeAddress = UtilHelper.isNativeAddress(e2);
            UtilHelper.NativePageType nativePageType = isNativeAddress.type;
            if (nativePageType != UtilHelper.NativePageType.NONE) {
                int i = c.f62085a[nativePageType.ordinal()];
                if (i == 1) {
                    this.f62079e.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.f62079e.getPageActivity()).createNormalCfg(isNativeAddress.id, "frs_banner")));
                } else if (i == 2) {
                    PbActivityConfig createNormalCfg2 = new PbActivityConfig(this.f62079e.getPageActivity()).createNormalCfg(isNativeAddress.id, null, "frs_banner");
                    createNormalCfg2.setVideo_source("frs");
                    this.f62079e.sendMessage(new CustomMessage(2004001, createNormalCfg2));
                }
            } else {
                v.p().i().c(this.f62079e.getPageActivity(), new String[]{e2}, null);
                if (!StringUtils.isNull(e2) && e2.startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL)) {
                    TiebaStatic.eventStat(this.f62079e.getPageActivity(), "frs_banner", PrefetchEvent.STATE_CLICK, 1, "ref_id", "4000601", "ref_type", "603");
                }
            }
            C(c2, e2);
        } else if (this.f62076b.a() == 4) {
            this.f62079e.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.f62079e.getPageActivity()).createNormalCfg(e2, "frs_banner")));
            C(c2, e2);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.j0.e.e.a
    /* renamed from: z */
    public void n(d.b.j0.e.e.c cVar) {
        this.f62078d = cVar;
        if (cVar == null || !(cVar.a() instanceof TbPageContext)) {
            return;
        }
        this.f62079e = (TbPageContext) this.f62078d.a();
    }
}

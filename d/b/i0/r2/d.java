package d.b.i0.r2;

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
import d.b.h0.r.q.f0;
import d.b.i0.c3.j0.a;
import d.b.i0.e.a.a;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes5.dex */
public class d implements d.b.i0.e.a.a {
    public static final Pattern j = Pattern.compile("(/p/){1}(\\d+)");

    /* renamed from: b  reason: collision with root package name */
    public f0 f59800b;

    /* renamed from: d  reason: collision with root package name */
    public d.b.i0.e.e.c f59802d;

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext f59803e;

    /* renamed from: f  reason: collision with root package name */
    public a.InterfaceC1224a f59804f;

    /* renamed from: g  reason: collision with root package name */
    public String f59805g;

    /* renamed from: h  reason: collision with root package name */
    public String f59806h;

    /* renamed from: a  reason: collision with root package name */
    public BannerView f59799a = null;

    /* renamed from: c  reason: collision with root package name */
    public boolean f59801c = false;
    public BannerView.b i = new b();

    /* loaded from: classes5.dex */
    public class a implements TbImageView.f {
        public a() {
        }

        @Override // com.baidu.tbadk.widget.TbImageView.f
        public void a(String str, boolean z) {
            if (z) {
                if (d.this.f59800b != null && d.this.f59800b.i) {
                    String c2 = d.this.f59800b.c();
                    if (!StringUtils.isNULL(c2)) {
                        d.this.B(c2);
                    }
                    d.this.f59800b.i = false;
                }
                if (d.this.f59799a == null || !d.this.f59799a.i() || d.this.f59801c) {
                    return;
                }
                d.this.f59801c = true;
                d.this.f59804f.a(d.this.f59802d, d.this.f59799a);
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
            d.this.A();
        }

        @Override // com.baidu.tbadk.coreExtra.view.BannerView.b
        public void b() {
            d.this.y();
        }
    }

    /* loaded from: classes5.dex */
    public static /* synthetic */ class c {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f59809a;

        static {
            int[] iArr = new int[UtilHelper.NativePageType.values().length];
            f59809a = iArr;
            try {
                iArr[UtilHelper.NativePageType.FRS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f59809a[UtilHelper.NativePageType.PB.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public final void A() {
        a.InterfaceC1224a interfaceC1224a;
        BannerView bannerView = this.f59799a;
        if (bannerView == null || (interfaceC1224a = this.f59804f) == null) {
            return;
        }
        this.f59801c = false;
        interfaceC1224a.b(this.f59802d, bannerView);
        this.f59799a = null;
    }

    public final void B(String str) {
        if (StringUtils.isNULL(str)) {
            return;
        }
        a.b b2 = d.b.i0.c3.j0.a.b("ad_tpoint", "PT", "FRS", "c0129", "ad_plat", "VIEW_TRUE", str, this.f59806h, this.f59805g, null);
        b2.e(TiebaStatic.Params.OBJ_URL, this.f59800b.b());
        b2.f();
    }

    public final void C(String str, String str2) {
        if (StringUtils.isNULL(str)) {
            return;
        }
        a.b b2 = d.b.i0.c3.j0.a.b("ad_tpoint", "PT", "FRS", "c0129", "ad_plat", "CLICK", str, this.f59806h, this.f59805g, null);
        b2.e(TiebaStatic.Params.OBJ_URL, str2);
        b2.f();
    }

    @Override // d.b.i0.e.a.a
    public void a(int i) {
        BannerView bannerView = this.f59799a;
        if (bannerView != null) {
            bannerView.j();
        }
    }

    @Override // d.b.i0.e.e.a
    public void b(Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            return;
        }
        this.f59805g = map.get("forum_name");
        this.f59806h = map.get("forum_id");
    }

    @Override // d.b.i0.e.a.a
    public void c(Object obj) {
        if (obj instanceof f0) {
            this.f59800b = (f0) obj;
        }
    }

    @Override // d.b.i0.e.a.a
    public void d(a.InterfaceC1224a interfaceC1224a) {
        this.f59804f = interfaceC1224a;
    }

    @Override // d.b.i0.e.a.a
    public void g() {
        if (this.f59803e == null || this.f59804f == null) {
            return;
        }
        f0 f0Var = this.f59800b;
        if (f0Var == null) {
            A();
        } else if (!f0Var.f()) {
            A();
        } else {
            if (!this.f59801c) {
                if (this.f59799a != null) {
                    return;
                }
                BannerView bannerView = new BannerView(this.f59803e.getPageActivity());
                this.f59799a = bannerView;
                bannerView.setVisibility(8);
                this.f59799a.setBannerViewClickListener(this.i);
                this.f59799a.setBannerViewEvent(new a());
                if (this.f59800b.e().startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL)) {
                    TiebaStatic.eventStat(this.f59803e.getPageActivity(), "game_show", "show", 1, "ref_id", "4000601", "ref_type", "603");
                }
            } else {
                this.f59804f.a(this.f59802d, this.f59799a);
            }
            this.f59799a.setBannerData(this.f59800b);
            this.f59799a.k();
            if (this.f59800b.d() != 1 || TextUtils.isEmpty(this.f59800b.b())) {
                return;
            }
            this.f59799a.setData(this.f59803e, this.f59800b.b());
        }
    }

    @Override // d.b.i0.e.a.a
    public View getView() {
        return this.f59799a;
    }

    @Override // d.b.i0.e.a.a
    public void j(int i) {
        BannerView bannerView = this.f59799a;
        if (bannerView != null) {
            bannerView.setBannerMaskColor(i);
        }
    }

    public final void y() {
        f0 f0Var = this.f59800b;
        if (f0Var == null) {
            return;
        }
        String e2 = f0Var.e();
        String c2 = this.f59800b.c();
        if (this.f59800b.a() == 1) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new FacePackageDetailActivityConfig(this.f59803e.getPageActivity(), e2, false, "frs_banner")));
            C(c2, e2);
        } else if (this.f59800b.a() == 2) {
            if (e2.contains(TbPatternsCompat.TB_DOMAIN_NAME)) {
                Matcher matcher = j.matcher(e2);
                if (matcher.find()) {
                    try {
                        PbActivityConfig createNormalCfg = new PbActivityConfig(this.f59803e.getPageActivity()).createNormalCfg(matcher.group(2), null, "frs_banner");
                        createNormalCfg.setVideo_source("frs");
                        this.f59803e.sendMessage(new CustomMessage(2004001, createNormalCfg));
                        C(c2, e2);
                    } catch (Exception e3) {
                        BdLog.e(e3.toString());
                    }
                }
            }
        } else if (this.f59800b.a() == 3) {
            new UtilHelper.NativePage();
            UtilHelper.NativePage isNativeAddress = UtilHelper.isNativeAddress(e2);
            UtilHelper.NativePageType nativePageType = isNativeAddress.type;
            if (nativePageType != UtilHelper.NativePageType.NONE) {
                int i = c.f59809a[nativePageType.ordinal()];
                if (i == 1) {
                    this.f59803e.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.f59803e.getPageActivity()).createNormalCfg(isNativeAddress.id, "frs_banner")));
                } else if (i == 2) {
                    PbActivityConfig createNormalCfg2 = new PbActivityConfig(this.f59803e.getPageActivity()).createNormalCfg(isNativeAddress.id, null, "frs_banner");
                    createNormalCfg2.setVideo_source("frs");
                    this.f59803e.sendMessage(new CustomMessage(2004001, createNormalCfg2));
                }
            } else {
                s.o().h().c(this.f59803e.getPageActivity(), new String[]{e2}, null);
                if (!StringUtils.isNull(e2) && e2.startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL)) {
                    TiebaStatic.eventStat(this.f59803e.getPageActivity(), "frs_banner", PrefetchEvent.STATE_CLICK, 1, "ref_id", "4000601", "ref_type", "603");
                }
            }
            C(c2, e2);
        } else if (this.f59800b.a() == 4) {
            this.f59803e.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.f59803e.getPageActivity()).createNormalCfg(e2, "frs_banner")));
            C(c2, e2);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.i0.e.e.a
    /* renamed from: z */
    public void n(d.b.i0.e.e.c cVar) {
        this.f59802d = cVar;
        if (cVar == null || !(cVar.a() instanceof TbPageContext)) {
            return;
        }
        this.f59803e = (TbPageContext) this.f59802d.a();
    }
}

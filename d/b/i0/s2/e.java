package d.b.i0.s2;

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
import d.b.i0.d3.j0.a;
import d.b.i0.e.a.a;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes4.dex */
public class e implements d.b.i0.e.a.a {
    public static final Pattern j = Pattern.compile("(/p/){1}(\\d+)");

    /* renamed from: b  reason: collision with root package name */
    public f0 f61655b;

    /* renamed from: d  reason: collision with root package name */
    public d.b.i0.e.e.c f61657d;

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext f61658e;

    /* renamed from: f  reason: collision with root package name */
    public a.InterfaceC1249a f61659f;

    /* renamed from: g  reason: collision with root package name */
    public String f61660g;

    /* renamed from: h  reason: collision with root package name */
    public String f61661h;

    /* renamed from: a  reason: collision with root package name */
    public BannerView f61654a = null;

    /* renamed from: c  reason: collision with root package name */
    public boolean f61656c = false;
    public BannerView.b i = new b();

    /* loaded from: classes4.dex */
    public class a implements TbImageView.f {
        public a() {
        }

        @Override // com.baidu.tbadk.widget.TbImageView.f
        public void a(String str, boolean z) {
            if (z) {
                if (e.this.f61655b != null && e.this.f61655b.i) {
                    String c2 = e.this.f61655b.c();
                    if (!StringUtils.isNULL(c2)) {
                        e.this.B(c2);
                    }
                    e.this.f61655b.i = false;
                }
                if (e.this.f61654a == null || !e.this.f61654a.i() || e.this.f61656c) {
                    return;
                }
                e.this.f61656c = true;
                e.this.f61659f.a(e.this.f61657d, e.this.f61654a);
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
        public static final /* synthetic */ int[] f61664a;

        static {
            int[] iArr = new int[UtilHelper.NativePageType.values().length];
            f61664a = iArr;
            try {
                iArr[UtilHelper.NativePageType.FRS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f61664a[UtilHelper.NativePageType.PB.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public final void A() {
        a.InterfaceC1249a interfaceC1249a;
        BannerView bannerView = this.f61654a;
        if (bannerView == null || (interfaceC1249a = this.f61659f) == null) {
            return;
        }
        this.f61656c = false;
        interfaceC1249a.b(this.f61657d, bannerView);
        this.f61654a = null;
    }

    public final void B(String str) {
        if (StringUtils.isNULL(str)) {
            return;
        }
        a.b b2 = d.b.i0.d3.j0.a.b("ad_tpoint", "PT", "FRS", "c0129", "ad_plat", "VIEW_TRUE", str, this.f61661h, this.f61660g, null);
        b2.e(TiebaStatic.Params.OBJ_URL, this.f61655b.b());
        b2.f();
    }

    public final void C(String str, String str2) {
        if (StringUtils.isNULL(str)) {
            return;
        }
        a.b b2 = d.b.i0.d3.j0.a.b("ad_tpoint", "PT", "FRS", "c0129", "ad_plat", "CLICK", str, this.f61661h, this.f61660g, null);
        b2.e(TiebaStatic.Params.OBJ_URL, str2);
        b2.f();
    }

    @Override // d.b.i0.e.a.a
    public void a(int i) {
        BannerView bannerView = this.f61654a;
        if (bannerView != null) {
            bannerView.j();
        }
    }

    @Override // d.b.i0.e.e.a
    public void b(Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            return;
        }
        this.f61660g = map.get("forum_name");
        this.f61661h = map.get("forum_id");
    }

    @Override // d.b.i0.e.a.a
    public void c(Object obj) {
        if (obj instanceof f0) {
            this.f61655b = (f0) obj;
        }
    }

    @Override // d.b.i0.e.a.a
    public void d(a.InterfaceC1249a interfaceC1249a) {
        this.f61659f = interfaceC1249a;
    }

    @Override // d.b.i0.e.a.a
    public void g() {
        if (this.f61658e == null || this.f61659f == null) {
            return;
        }
        f0 f0Var = this.f61655b;
        if (f0Var == null) {
            A();
        } else if (!f0Var.f()) {
            A();
        } else {
            if (!this.f61656c) {
                if (this.f61654a != null) {
                    return;
                }
                BannerView bannerView = new BannerView(this.f61658e.getPageActivity());
                this.f61654a = bannerView;
                bannerView.setVisibility(8);
                this.f61654a.setBannerViewClickListener(this.i);
                this.f61654a.setBannerViewEvent(new a());
                if (this.f61655b.e().startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL)) {
                    TiebaStatic.eventStat(this.f61658e.getPageActivity(), "game_show", "show", 1, "ref_id", "4000601", "ref_type", "603");
                }
            } else {
                this.f61659f.a(this.f61657d, this.f61654a);
            }
            this.f61654a.setBannerData(this.f61655b);
            this.f61654a.k();
            if (this.f61655b.d() != 1 || TextUtils.isEmpty(this.f61655b.b())) {
                return;
            }
            this.f61654a.setData(this.f61658e, this.f61655b.b());
        }
    }

    @Override // d.b.i0.e.a.a
    public View getView() {
        return this.f61654a;
    }

    @Override // d.b.i0.e.a.a
    public void j(int i) {
        BannerView bannerView = this.f61654a;
        if (bannerView != null) {
            bannerView.setBannerMaskColor(i);
        }
    }

    public final void y() {
        f0 f0Var = this.f61655b;
        if (f0Var == null) {
            return;
        }
        String e2 = f0Var.e();
        String c2 = this.f61655b.c();
        if (this.f61655b.a() == 1) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new FacePackageDetailActivityConfig(this.f61658e.getPageActivity(), e2, false, "frs_banner")));
            C(c2, e2);
        } else if (this.f61655b.a() == 2) {
            if (e2.contains(TbPatternsCompat.TB_DOMAIN_NAME)) {
                Matcher matcher = j.matcher(e2);
                if (matcher.find()) {
                    try {
                        PbActivityConfig createNormalCfg = new PbActivityConfig(this.f61658e.getPageActivity()).createNormalCfg(matcher.group(2), null, "frs_banner");
                        createNormalCfg.setVideo_source("frs");
                        this.f61658e.sendMessage(new CustomMessage(2004001, createNormalCfg));
                        C(c2, e2);
                    } catch (Exception e3) {
                        BdLog.e(e3.toString());
                    }
                }
            }
        } else if (this.f61655b.a() == 3) {
            new UtilHelper.NativePage();
            UtilHelper.NativePage isNativeAddress = UtilHelper.isNativeAddress(e2);
            UtilHelper.NativePageType nativePageType = isNativeAddress.type;
            if (nativePageType != UtilHelper.NativePageType.NONE) {
                int i = c.f61664a[nativePageType.ordinal()];
                if (i == 1) {
                    this.f61658e.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.f61658e.getPageActivity()).createNormalCfg(isNativeAddress.id, "frs_banner")));
                } else if (i == 2) {
                    PbActivityConfig createNormalCfg2 = new PbActivityConfig(this.f61658e.getPageActivity()).createNormalCfg(isNativeAddress.id, null, "frs_banner");
                    createNormalCfg2.setVideo_source("frs");
                    this.f61658e.sendMessage(new CustomMessage(2004001, createNormalCfg2));
                }
            } else {
                v.p().i().c(this.f61658e.getPageActivity(), new String[]{e2}, null);
                if (!StringUtils.isNull(e2) && e2.startsWith(UrlSchemaHelper.SCHEMA_TYPE_GAME_DETAIL)) {
                    TiebaStatic.eventStat(this.f61658e.getPageActivity(), "frs_banner", PrefetchEvent.STATE_CLICK, 1, "ref_id", "4000601", "ref_type", "603");
                }
            }
            C(c2, e2);
        } else if (this.f61655b.a() == 4) {
            this.f61658e.sendMessage(new CustomMessage(2003000, new FrsActivityConfig(this.f61658e.getPageActivity()).createNormalCfg(e2, "frs_banner")));
            C(c2, e2);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.i0.e.e.a
    /* renamed from: z */
    public void n(d.b.i0.e.e.c cVar) {
        this.f61657d = cVar;
        if (cVar == null || !(cVar.a() instanceof TbPageContext)) {
            return;
        }
        this.f61658e = (TbPageContext) this.f61657d.a();
    }
}

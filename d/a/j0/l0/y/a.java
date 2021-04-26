package d.a.j0.l0.y;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.flow.CoverFlowView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import d.a.c.e.p.l;
import d.a.i0.r.w.b.d;
import d.a.i0.r.w.b.e;
import d.a.j0.l0.y.c.c;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext<?> f56502b;

    /* renamed from: c  reason: collision with root package name */
    public View f56503c;

    /* renamed from: a  reason: collision with root package name */
    public Pattern f56501a = Pattern.compile("http[s]?://tieba.baidu.com/p/([\\d]+)");

    /* renamed from: d  reason: collision with root package name */
    public CoverFlowView<d.a.i0.r.w.b.a> f56504d = null;

    /* renamed from: e  reason: collision with root package name */
    public c f56505e = null;

    /* renamed from: f  reason: collision with root package name */
    public d<d.a.i0.r.w.b.a> f56506f = new b();

    /* renamed from: d.a.j0.l0.y.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1344a extends d.a.i0.r.w.b.b {
        public C1344a() {
        }

        @Override // d.a.i0.r.w.b.b, d.a.i0.r.w.a
        public d.a.i0.r.w.b.c a() {
            d.a.i0.r.w.b.c a2 = super.a();
            if (a2 != null) {
                a2.d(81);
                a2.e(R.dimen.ds20);
            }
            return a2;
        }

        @Override // d.a.i0.r.w.b.b, d.a.i0.r.w.a
        public e c() {
            e eVar = new e();
            eVar.a((int) (l.k(a.this.f56502b.getPageActivity()) / 2.5714285f));
            return eVar;
        }

        @Override // d.a.i0.r.w.b.b, d.a.i0.r.w.a
        public TbImageView d(Context context) {
            TbImageView tbImageView = new TbImageView(context);
            tbImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            tbImageView.setGifIconSupport(false);
            return tbImageView;
        }
    }

    /* loaded from: classes4.dex */
    public class b implements d<d.a.i0.r.w.b.a> {
        public b() {
        }

        @Override // d.a.i0.r.w.b.d
        public void a(int i2, d.a.i0.r.w.b.a aVar) {
            if (aVar == null) {
                return;
            }
            boolean z = aVar instanceof c.a;
        }

        @Override // d.a.i0.r.w.b.d
        public void b(int i2, String str) {
            c.a aVar = (c.a) a.this.f56504d.n(i2);
            if (aVar == null) {
                return;
            }
            Matcher matcher = a.this.f56501a.matcher(aVar.b());
            if (matcher.find()) {
                a.this.f56502b.sendMessage(new CustomMessage(2004001, new PbActivityConfig(a.this.f56502b.getPageActivity()).createNormalCfg(matcher.group(1), null, null)));
            }
        }
    }

    public a(TbPageContext<?> tbPageContext) {
        this.f56502b = null;
        this.f56502b = tbPageContext;
        d();
    }

    public View c() {
        return this.f56503c;
    }

    public final void d() {
        TbPageContext<?> tbPageContext = this.f56502b;
        if (tbPageContext == null) {
            return;
        }
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.square_banner_layout, (ViewGroup) null);
        this.f56503c = inflate;
        if (inflate == null) {
            return;
        }
        this.f56504d = (CoverFlowView) inflate.findViewById(R.id.square_banner_cover_flow_view);
        C1344a c1344a = new C1344a();
        this.f56504d.setDisableParentEvent(false);
        this.f56504d.setCoverFlowFactory(c1344a);
        this.f56504d.setCallback(this.f56506f);
    }

    public void e(c cVar) {
        if (cVar == null || cVar == this.f56505e) {
            return;
        }
        this.f56504d.setData(cVar.a());
        this.f56505e = cVar;
    }

    public void f(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null) {
        }
    }

    public void g() {
        CoverFlowView<d.a.i0.r.w.b.a> coverFlowView = this.f56504d;
        if (coverFlowView != null) {
            coverFlowView.v();
        }
    }
}

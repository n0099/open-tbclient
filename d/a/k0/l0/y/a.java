package d.a.k0.l0.y;

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
import d.a.j0.r.w.b.d;
import d.a.j0.r.w.b.e;
import d.a.k0.l0.y.c.c;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext<?> f57209b;

    /* renamed from: c  reason: collision with root package name */
    public View f57210c;

    /* renamed from: a  reason: collision with root package name */
    public Pattern f57208a = Pattern.compile("http[s]?://tieba.baidu.com/p/([\\d]+)");

    /* renamed from: d  reason: collision with root package name */
    public CoverFlowView<d.a.j0.r.w.b.a> f57211d = null;

    /* renamed from: e  reason: collision with root package name */
    public c f57212e = null;

    /* renamed from: f  reason: collision with root package name */
    public d<d.a.j0.r.w.b.a> f57213f = new b();

    /* renamed from: d.a.k0.l0.y.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1416a extends d.a.j0.r.w.b.b {
        public C1416a() {
        }

        @Override // d.a.j0.r.w.b.b, d.a.j0.r.w.a
        public d.a.j0.r.w.b.c a() {
            d.a.j0.r.w.b.c a2 = super.a();
            if (a2 != null) {
                a2.d(81);
                a2.e(R.dimen.ds20);
            }
            return a2;
        }

        @Override // d.a.j0.r.w.b.b, d.a.j0.r.w.a
        public e c() {
            e eVar = new e();
            eVar.a((int) (l.k(a.this.f57209b.getPageActivity()) / 2.5714285f));
            return eVar;
        }

        @Override // d.a.j0.r.w.b.b, d.a.j0.r.w.a
        public TbImageView d(Context context) {
            TbImageView tbImageView = new TbImageView(context);
            tbImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            tbImageView.setGifIconSupport(false);
            return tbImageView;
        }
    }

    /* loaded from: classes4.dex */
    public class b implements d<d.a.j0.r.w.b.a> {
        public b() {
        }

        @Override // d.a.j0.r.w.b.d
        public void a(int i2, d.a.j0.r.w.b.a aVar) {
            if (aVar == null) {
                return;
            }
            boolean z = aVar instanceof c.a;
        }

        @Override // d.a.j0.r.w.b.d
        public void b(int i2, String str) {
            c.a aVar = (c.a) a.this.f57211d.n(i2);
            if (aVar == null) {
                return;
            }
            Matcher matcher = a.this.f57208a.matcher(aVar.b());
            if (matcher.find()) {
                a.this.f57209b.sendMessage(new CustomMessage(2004001, new PbActivityConfig(a.this.f57209b.getPageActivity()).createNormalCfg(matcher.group(1), null, null)));
            }
        }
    }

    public a(TbPageContext<?> tbPageContext) {
        this.f57209b = null;
        this.f57209b = tbPageContext;
        d();
    }

    public View c() {
        return this.f57210c;
    }

    public final void d() {
        TbPageContext<?> tbPageContext = this.f57209b;
        if (tbPageContext == null) {
            return;
        }
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.square_banner_layout, (ViewGroup) null);
        this.f57210c = inflate;
        if (inflate == null) {
            return;
        }
        this.f57211d = (CoverFlowView) inflate.findViewById(R.id.square_banner_cover_flow_view);
        C1416a c1416a = new C1416a();
        this.f57211d.setDisableParentEvent(false);
        this.f57211d.setCoverFlowFactory(c1416a);
        this.f57211d.setCallback(this.f57213f);
    }

    public void e(c cVar) {
        if (cVar == null || cVar == this.f57212e) {
            return;
        }
        this.f57211d.setData(cVar.a());
        this.f57212e = cVar;
    }

    public void f(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null) {
        }
    }

    public void g() {
        CoverFlowView<d.a.j0.r.w.b.a> coverFlowView = this.f57211d;
        if (coverFlowView != null) {
            coverFlowView.v();
        }
    }
}

package d.a.n0.m0.y;

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
import d.a.m0.r.w.b.d;
import d.a.m0.r.w.b.e;
import d.a.n0.m0.y.c.c;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext<?> f61088b;

    /* renamed from: c  reason: collision with root package name */
    public View f61089c;

    /* renamed from: a  reason: collision with root package name */
    public Pattern f61087a = Pattern.compile("http[s]?://tieba.baidu.com/p/([\\d]+)");

    /* renamed from: d  reason: collision with root package name */
    public CoverFlowView<d.a.m0.r.w.b.a> f61090d = null;

    /* renamed from: e  reason: collision with root package name */
    public c f61091e = null;

    /* renamed from: f  reason: collision with root package name */
    public d<d.a.m0.r.w.b.a> f61092f = new b();

    /* renamed from: d.a.n0.m0.y.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1490a extends d.a.m0.r.w.b.b {
        public C1490a() {
        }

        @Override // d.a.m0.r.w.b.b, d.a.m0.r.w.a
        public d.a.m0.r.w.b.c a() {
            d.a.m0.r.w.b.c a2 = super.a();
            if (a2 != null) {
                a2.d(81);
                a2.e(R.dimen.ds20);
            }
            return a2;
        }

        @Override // d.a.m0.r.w.b.b, d.a.m0.r.w.a
        public e c() {
            e eVar = new e();
            eVar.a((int) (l.k(a.this.f61088b.getPageActivity()) / 2.5714285f));
            return eVar;
        }

        @Override // d.a.m0.r.w.b.b, d.a.m0.r.w.a
        public TbImageView d(Context context) {
            TbImageView tbImageView = new TbImageView(context);
            tbImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            tbImageView.setGifIconSupport(false);
            return tbImageView;
        }
    }

    /* loaded from: classes4.dex */
    public class b implements d<d.a.m0.r.w.b.a> {
        public b() {
        }

        @Override // d.a.m0.r.w.b.d
        public void a(int i2, d.a.m0.r.w.b.a aVar) {
            if (aVar == null) {
                return;
            }
            boolean z = aVar instanceof c.a;
        }

        @Override // d.a.m0.r.w.b.d
        public void b(int i2, String str) {
            c.a aVar = (c.a) a.this.f61090d.n(i2);
            if (aVar == null) {
                return;
            }
            Matcher matcher = a.this.f61087a.matcher(aVar.b());
            if (matcher.find()) {
                a.this.f61088b.sendMessage(new CustomMessage(2004001, new PbActivityConfig(a.this.f61088b.getPageActivity()).createNormalCfg(matcher.group(1), null, null)));
            }
        }
    }

    public a(TbPageContext<?> tbPageContext) {
        this.f61088b = null;
        this.f61088b = tbPageContext;
        d();
    }

    public View c() {
        return this.f61089c;
    }

    public final void d() {
        TbPageContext<?> tbPageContext = this.f61088b;
        if (tbPageContext == null) {
            return;
        }
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.square_banner_layout, (ViewGroup) null);
        this.f61089c = inflate;
        if (inflate == null) {
            return;
        }
        this.f61090d = (CoverFlowView) inflate.findViewById(R.id.square_banner_cover_flow_view);
        C1490a c1490a = new C1490a();
        this.f61090d.setDisableParentEvent(false);
        this.f61090d.setCoverFlowFactory(c1490a);
        this.f61090d.setCallback(this.f61092f);
    }

    public void e(c cVar) {
        if (cVar == null || cVar == this.f61091e) {
            return;
        }
        this.f61090d.setData(cVar.a());
        this.f61091e = cVar;
    }

    public void f(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null) {
        }
    }

    public void g() {
        CoverFlowView<d.a.m0.r.w.b.a> coverFlowView = this.f61090d;
        if (coverFlowView != null) {
            coverFlowView.v();
        }
    }
}

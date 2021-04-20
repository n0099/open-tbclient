package d.b.i0.l0.y;

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
import d.b.c.e.p.l;
import d.b.h0.r.w.b.d;
import d.b.h0.r.w.b.e;
import d.b.i0.l0.y.c.c;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext<?> f58075b;

    /* renamed from: c  reason: collision with root package name */
    public View f58076c;

    /* renamed from: a  reason: collision with root package name */
    public Pattern f58074a = Pattern.compile("http[s]?://tieba.baidu.com/p/([\\d]+)");

    /* renamed from: d  reason: collision with root package name */
    public CoverFlowView<d.b.h0.r.w.b.a> f58077d = null;

    /* renamed from: e  reason: collision with root package name */
    public c f58078e = null;

    /* renamed from: f  reason: collision with root package name */
    public d<d.b.h0.r.w.b.a> f58079f = new b();

    /* renamed from: d.b.i0.l0.y.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1382a extends d.b.h0.r.w.b.b {
        public C1382a() {
        }

        @Override // d.b.h0.r.w.b.b, d.b.h0.r.w.a
        public d.b.h0.r.w.b.c a() {
            d.b.h0.r.w.b.c a2 = super.a();
            if (a2 != null) {
                a2.d(81);
                a2.e(R.dimen.ds20);
            }
            return a2;
        }

        @Override // d.b.h0.r.w.b.b, d.b.h0.r.w.a
        public TbImageView c(Context context) {
            TbImageView tbImageView = new TbImageView(context);
            tbImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            tbImageView.setGifIconSupport(false);
            return tbImageView;
        }

        @Override // d.b.h0.r.w.b.b, d.b.h0.r.w.a
        public e d() {
            e eVar = new e();
            eVar.a((int) (l.k(a.this.f58075b.getPageActivity()) / 2.5714285f));
            return eVar;
        }
    }

    /* loaded from: classes4.dex */
    public class b implements d<d.b.h0.r.w.b.a> {
        public b() {
        }

        @Override // d.b.h0.r.w.b.d
        public void a(int i, d.b.h0.r.w.b.a aVar) {
            if (aVar == null) {
                return;
            }
            boolean z = aVar instanceof c.a;
        }

        @Override // d.b.h0.r.w.b.d
        public void b(int i, String str) {
            c.a aVar = (c.a) a.this.f58077d.n(i);
            if (aVar == null) {
                return;
            }
            Matcher matcher = a.this.f58074a.matcher(aVar.b());
            if (matcher.find()) {
                a.this.f58075b.sendMessage(new CustomMessage(2004001, new PbActivityConfig(a.this.f58075b.getPageActivity()).createNormalCfg(matcher.group(1), null, null)));
            }
        }
    }

    public a(TbPageContext<?> tbPageContext) {
        this.f58075b = null;
        this.f58075b = tbPageContext;
        d();
    }

    public View c() {
        return this.f58076c;
    }

    public final void d() {
        TbPageContext<?> tbPageContext = this.f58075b;
        if (tbPageContext == null) {
            return;
        }
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.square_banner_layout, (ViewGroup) null);
        this.f58076c = inflate;
        if (inflate == null) {
            return;
        }
        this.f58077d = (CoverFlowView) inflate.findViewById(R.id.square_banner_cover_flow_view);
        C1382a c1382a = new C1382a();
        this.f58077d.setDisableParentEvent(false);
        this.f58077d.setCoverFlowFactory(c1382a);
        this.f58077d.setCallback(this.f58079f);
    }

    public void e(c cVar) {
        if (cVar == null || cVar == this.f58078e) {
            return;
        }
        this.f58077d.setData(cVar.a());
        this.f58078e = cVar;
    }

    public void f(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null) {
        }
    }

    public void g() {
        CoverFlowView<d.b.h0.r.w.b.a> coverFlowView = this.f58077d;
        if (coverFlowView != null) {
            coverFlowView.v();
        }
    }
}

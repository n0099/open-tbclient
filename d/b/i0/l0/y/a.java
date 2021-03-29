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
import d.b.b.e.p.l;
import d.b.h0.r.w.b.d;
import d.b.h0.r.w.b.e;
import d.b.i0.l0.y.c.c;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: b  reason: collision with root package name */
    public TbPageContext<?> f56669b;

    /* renamed from: c  reason: collision with root package name */
    public View f56670c;

    /* renamed from: a  reason: collision with root package name */
    public Pattern f56668a = Pattern.compile("http[s]?://tieba.baidu.com/p/([\\d]+)");

    /* renamed from: d  reason: collision with root package name */
    public CoverFlowView<d.b.h0.r.w.b.a> f56671d = null;

    /* renamed from: e  reason: collision with root package name */
    public c f56672e = null;

    /* renamed from: f  reason: collision with root package name */
    public d<d.b.h0.r.w.b.a> f56673f = new b();

    /* renamed from: d.b.i0.l0.y.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1329a extends d.b.h0.r.w.b.b {
        public C1329a() {
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
            eVar.a((int) (l.k(a.this.f56669b.getPageActivity()) / 2.5714285f));
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
            c.a aVar = (c.a) a.this.f56671d.n(i);
            if (aVar == null) {
                return;
            }
            Matcher matcher = a.this.f56668a.matcher(aVar.b());
            if (matcher.find()) {
                a.this.f56669b.sendMessage(new CustomMessage(2004001, new PbActivityConfig(a.this.f56669b.getPageActivity()).createNormalCfg(matcher.group(1), null, null)));
            }
        }
    }

    public a(TbPageContext<?> tbPageContext) {
        this.f56669b = null;
        this.f56669b = tbPageContext;
        d();
    }

    public View c() {
        return this.f56670c;
    }

    public final void d() {
        TbPageContext<?> tbPageContext = this.f56669b;
        if (tbPageContext == null) {
            return;
        }
        View inflate = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.square_banner_layout, (ViewGroup) null);
        this.f56670c = inflate;
        if (inflate == null) {
            return;
        }
        this.f56671d = (CoverFlowView) inflate.findViewById(R.id.square_banner_cover_flow_view);
        C1329a c1329a = new C1329a();
        this.f56671d.setDisableParentEvent(false);
        this.f56671d.setCoverFlowFactory(c1329a);
        this.f56671d.setCallback(this.f56673f);
    }

    public void e(c cVar) {
        if (cVar == null || cVar == this.f56672e) {
            return;
        }
        this.f56671d.setData(cVar.a());
        this.f56672e = cVar;
    }

    public void f(BdUniqueId bdUniqueId) {
        if (bdUniqueId == null) {
        }
    }

    public void g() {
        CoverFlowView<d.b.h0.r.w.b.a> coverFlowView = this.f56671d;
        if (coverFlowView != null) {
            coverFlowView.v();
        }
    }
}

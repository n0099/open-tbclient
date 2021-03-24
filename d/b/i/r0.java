package d.b.i;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.card.view.VideoImageNoPlayerLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import d.b.i.a;
import tbclient.VideoInfo;
/* loaded from: classes2.dex */
public class r0 extends h {
    public static final int v = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004) * 2;
    public static int w = d.b.b.e.p.l.k(TbadkCoreApplication.getInst());
    public int l;
    public int m;
    public int n;
    public Context o;
    public d.b.h0.r.q.a p;
    public VideoImageNoPlayerLayout q;
    public int r;
    public String s;
    public int t;
    public d.b.i.v0.a u;

    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            r0 r0Var = r0.this;
            a.InterfaceC1115a interfaceC1115a = r0Var.i;
            if (interfaceC1115a != null) {
                interfaceC1115a.a(r0Var.p);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements d.b.i.v0.a {
        public b() {
        }

        @Override // d.b.i.v0.a
        public void a(d.b.h0.r.q.a aVar) {
            if (r0.this.u != null) {
                r0.this.u.a(r0.this.p);
            }
        }
    }

    public r0(Context context) {
        super(context);
        int i = w;
        this.l = i;
        this.m = i / 2;
        this.n = i / 3;
        this.r = 0;
        this.t = 3;
        this.o = context;
        this.q = new VideoImageNoPlayerLayout(context);
        n(Boolean.TRUE);
    }

    @Override // d.b.i.a
    public View g() {
        return this.q;
    }

    @Override // d.b.i.a
    public void l(d.b.i0.x.b0<d.b.h0.r.q.a> b0Var) {
        super.l(b0Var);
        this.q.setOnCardSubClickListener(b0Var);
    }

    @Override // d.b.i.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        if (this.t != i) {
            this.q.h(tbPageContext, i);
        }
        this.t = i;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00d8, code lost:
        if (r3 != r11.height) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00e1, code lost:
        if (r3 != r11.height) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00e4, code lost:
        r5 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00e5, code lost:
        r1 = d.b.h0.b.g.b.l(r11, r0, r2, r3, r5);
     */
    @Override // d.b.i.p
    /* renamed from: u */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(d.b.h0.r.q.a aVar) {
        int k = d.b.b.e.p.l.k(TbadkCoreApplication.getInst());
        if (k != this.r) {
            w = d.b.b.e.p.l.k(TbadkCoreApplication.getInst());
            if (!"pb".equals(this.s)) {
                this.l = w - v;
            } else {
                this.l = w;
            }
            int i = this.l;
            this.m = i / 2;
            this.n = i / 3;
            this.r = k;
        }
        this.p = aVar;
        if (aVar != null && aVar.n() != null && this.p.n().r1 != null && !this.p.n().r1.m) {
            this.q.setVisibility(0);
            this.q.a(aVar);
            ViewGroup.LayoutParams layoutParams = this.q.getLayoutParams();
            ViewGroup.LayoutParams layoutParams2 = this.q.n.getLayoutParams();
            int i2 = layoutParams.width;
            int i3 = layoutParams.height;
            boolean z = true;
            if (this.p.n().r1.r.is_vertical.intValue() == 1) {
                VideoInfo videoInfo = this.p.n().r1.r;
                if (videoInfo == null) {
                    return;
                }
                int i4 = (this.m / 9) * 16;
                int i5 = this.n;
                int intValue = videoInfo.video_width.intValue();
                int intValue2 = videoInfo.video_height.intValue();
                layoutParams.width = this.l;
                layoutParams2.width = this.m;
                r1 = i2 != layoutParams.width;
                if (intValue != 0 && intValue2 != 0) {
                    int i6 = (int) (((intValue2 * 1.0f) / intValue) * this.m);
                    if (i6 < i5) {
                        i4 = i5;
                    } else if (i6 <= i4) {
                        i4 = i6;
                    }
                    layoutParams.height = i4;
                    layoutParams2.height = i4;
                } else {
                    layoutParams.height = i4;
                    layoutParams2.height = i4;
                }
            } else {
                int i7 = this.l;
                layoutParams.width = i7;
                layoutParams2.width = i7;
                layoutParams.height = ((i7 / 16) * 9) - d.b.b.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds6);
                layoutParams2.height = ((this.l / 16) * 9) - d.b.b.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds6);
                if (i3 != layoutParams.height || i2 != layoutParams.width) {
                    r1 = true;
                }
            }
            if (r1) {
                this.q.setLayoutParams(layoutParams);
                this.q.n.setLayoutParams(layoutParams2);
            }
            this.q.setJumpToPbListener(new a());
            this.q.setData(this.p);
            d();
            return;
        }
        this.q.setVisibility(8);
    }

    public void v(String str) {
        this.s = str;
    }

    public void w(a.InterfaceC1115a interfaceC1115a) {
        this.i = interfaceC1115a;
    }

    public void x(d.b.i.v0.a aVar) {
        this.u = aVar;
        if (aVar != null) {
            y();
        }
    }

    public final void y() {
        VideoImageNoPlayerLayout videoImageNoPlayerLayout = this.q;
        if (videoImageNoPlayerLayout != null) {
            videoImageNoPlayerLayout.setVideoAreaClickListener(new b());
        }
    }
}

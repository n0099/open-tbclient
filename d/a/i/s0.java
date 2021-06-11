package d.a.i;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.card.view.VideoImageNoPlayerLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import d.a.i.a;
import tbclient.VideoInfo;
/* loaded from: classes.dex */
public class s0 extends h {
    public static final int v = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004) * 2;
    public static int w = d.a.c.e.p.l.k(TbadkCoreApplication.getInst());
    public int l;
    public int m;
    public int n;
    public Context o;
    public d.a.m0.r.q.a p;
    public VideoImageNoPlayerLayout q;
    public int r;
    public String s;
    public int t;
    public d.a.i.w0.a u;

    /* loaded from: classes.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            s0 s0Var = s0.this;
            a.InterfaceC0598a interfaceC0598a = s0Var.f43692i;
            if (interfaceC0598a != null) {
                interfaceC0598a.a(s0Var.p);
            }
        }
    }

    /* loaded from: classes.dex */
    public class b implements d.a.i.w0.a {
        public b() {
        }

        @Override // d.a.i.w0.a
        public void a(d.a.m0.r.q.a aVar) {
            if (s0.this.u != null) {
                s0.this.u.a(s0.this.p);
            }
        }
    }

    public s0(Context context) {
        super(context);
        int i2 = w;
        this.l = i2;
        this.m = i2 / 2;
        this.n = i2 / 3;
        this.r = 0;
        this.t = 3;
        this.o = context;
        this.q = new VideoImageNoPlayerLayout(context);
        n(Boolean.TRUE);
    }

    @Override // d.a.i.a
    public View g() {
        return this.q;
    }

    @Override // d.a.i.a
    public void l(d.a.n0.z.b0<d.a.m0.r.q.a> b0Var) {
        super.l(b0Var);
        this.q.setOnCardSubClickListener(b0Var);
    }

    @Override // d.a.i.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i2) {
        if (this.t != i2) {
            this.q.h(tbPageContext, i2);
        }
        this.t = i2;
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
        r1 = d.a.m0.b.g.b.l(r11, r0, r2, r3, r5);
     */
    @Override // d.a.i.p
    /* renamed from: u */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(d.a.m0.r.q.a aVar) {
        int k = d.a.c.e.p.l.k(TbadkCoreApplication.getInst());
        if (k != this.r) {
            w = d.a.c.e.p.l.k(TbadkCoreApplication.getInst());
            if (!"pb".equals(this.s)) {
                this.l = w - v;
            } else {
                this.l = w;
            }
            int i2 = this.l;
            this.m = i2 / 2;
            this.n = i2 / 3;
            this.r = k;
        }
        this.p = aVar;
        if (aVar != null && aVar.i() != null && this.p.i().t1 != null && !this.p.i().t1.m) {
            this.q.setVisibility(0);
            this.q.a(aVar);
            ViewGroup.LayoutParams layoutParams = this.q.getLayoutParams();
            ViewGroup.LayoutParams layoutParams2 = this.q.n.getLayoutParams();
            int i3 = layoutParams.width;
            int i4 = layoutParams.height;
            boolean z = true;
            if (this.p.i().t1.r.is_vertical.intValue() == 1) {
                VideoInfo videoInfo = this.p.i().t1.r;
                if (videoInfo == null) {
                    return;
                }
                int i5 = (this.m / 9) * 16;
                int i6 = this.n;
                int intValue = videoInfo.video_width.intValue();
                int intValue2 = videoInfo.video_height.intValue();
                layoutParams.width = this.l;
                layoutParams2.width = this.m;
                r1 = i3 != layoutParams.width;
                if (intValue != 0 && intValue2 != 0) {
                    int i7 = (int) (((intValue2 * 1.0f) / intValue) * this.m);
                    if (i7 < i6) {
                        i5 = i6;
                    } else if (i7 <= i5) {
                        i5 = i7;
                    }
                    layoutParams.height = i5;
                    layoutParams2.height = i5;
                } else {
                    layoutParams.height = i5;
                    layoutParams2.height = i5;
                }
            } else {
                int i8 = this.l;
                layoutParams.width = i8;
                layoutParams2.width = i8;
                layoutParams.height = ((i8 / 16) * 9) - d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds6);
                layoutParams2.height = ((this.l / 16) * 9) - d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds6);
                if (i4 != layoutParams.height || i3 != layoutParams.width) {
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

    public void w(a.InterfaceC0598a interfaceC0598a) {
        this.f43692i = interfaceC0598a;
    }

    public void x(d.a.i.w0.a aVar) {
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

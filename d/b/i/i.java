package d.b.i;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.view.RoundCornerFrameLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.play.operableVideoView.FakeVideoContainer;
import d.b.i.u0.a;
/* loaded from: classes.dex */
public class i extends d.b.i.a<d.b.h0.r.q.a> {
    public static final int r = (d.b.b.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.M_W_X005) + d.b.b.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.M_W_X004)) * 2;
    public static int s;
    public static int t;
    public static int u;
    public static int v;
    public View j;
    public TextView k;
    public d.b.h0.r.q.a l;
    public RoundCornerFrameLayout m;
    public FakeVideoContainer n;
    public int o;
    public boolean p;
    public a.b q;

    /* loaded from: classes.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ViewGroup.LayoutParams f51776e;

        public a(ViewGroup.LayoutParams layoutParams) {
            this.f51776e = layoutParams;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f51776e.width = i.this.j.getWidth();
            this.f51776e.height = (i.this.j.getWidth() / 16) * 9;
            i.this.m.setLayoutParams(this.f51776e);
        }
    }

    /* loaded from: classes.dex */
    public class b implements a.b {
        public b() {
        }

        @Override // d.b.i.u0.a.b
        public boolean a(a.C1118a c1118a) {
            RoundCornerFrameLayout roundCornerFrameLayout;
            if (c1118a.b() != 7 || (roundCornerFrameLayout = i.this.m) == null) {
                return false;
            }
            roundCornerFrameLayout.d(((Boolean) c1118a.c()).booleanValue());
            return false;
        }
    }

    static {
        int k = d.b.b.e.p.l.k(TbadkCoreApplication.getInst());
        s = k;
        int i = k - r;
        t = i;
        u = i / 2;
        v = i / 3;
    }

    public i(Context context) {
        super(context);
        this.o = 0;
        this.p = false;
        this.q = new b();
    }

    @Override // d.b.i.a
    public View g() {
        if (this.j == null) {
            View inflate = LayoutInflater.from(this.f51763f).inflate(R.layout.card_video_layout, (ViewGroup) null, true);
            this.j = inflate;
            this.k = (TextView) inflate.findViewById(R.id.video_seg_title);
            this.m = (RoundCornerFrameLayout) this.j.findViewById(R.id.frame_video);
            FakeVideoContainer fakeVideoContainer = new FakeVideoContainer(this.f51763f);
            this.n = fakeVideoContainer;
            fakeVideoContainer.setBackgroundResource(R.color.transparent);
            this.m.addView(this.n);
        }
        return this.j;
    }

    @Override // d.b.i.a
    public void h() {
        i(7, this.q);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00b1, code lost:
        if (r1 != r2) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00b6, code lost:
        if (r1 != r2) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00b8, code lost:
        r8 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00b9, code lost:
        r0 = d.b.h0.b.g.b.m(r11, r8, null, r0, r1);
     */
    @Override // d.b.i.p
    /* renamed from: o */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(d.b.h0.r.q.a aVar) {
        boolean z;
        int k = d.b.b.e.p.l.k(TbadkCoreApplication.getInst());
        if (k != this.o) {
            int k2 = d.b.b.e.p.l.k(TbadkCoreApplication.getInst());
            s = k2;
            int i = k2 - r;
            t = i;
            u = i / 2;
            v = i / 3;
            this.o = k;
        }
        this.l = aVar;
        if (aVar == null || aVar.n() == null || this.l.n().u1() == null) {
            return;
        }
        this.n.setData(aVar.n());
        ViewGroup.LayoutParams layoutParams = this.m.getLayoutParams();
        int i2 = layoutParams.width;
        int i3 = layoutParams.height;
        boolean z2 = false;
        if (this.l.n().u1().is_vertical.intValue() == 1) {
            int i4 = (u / 9) * 16;
            int i5 = v;
            int intValue = this.l.n().u1().video_width.intValue();
            int intValue2 = this.l.n().u1().video_height.intValue();
            int i6 = u;
            layoutParams.width = i6;
            boolean z3 = i2 != i6;
            if (intValue != 0 && intValue2 != 0) {
                int i7 = (int) (((intValue2 * 1.0f) / intValue) * u);
                if (i7 < i5) {
                    i4 = i5;
                } else if (i7 <= i4) {
                    i4 = i7;
                }
                layoutParams.height = i4;
            } else {
                layoutParams.height = i4;
            }
        } else {
            int i8 = t;
            layoutParams.width = i8;
            int i9 = (i8 / 16) * 9;
            layoutParams.height = i9;
            z = (i3 == i9 && i2 == i8) ? false : true;
        }
        if (z) {
            if (this.l.n().u1().is_vertical.intValue() == 1) {
                this.m.setLayoutParams(layoutParams);
            } else {
                this.m.post(new a(layoutParams));
            }
        }
        if (this.l.n().Q1()) {
            this.k.setMaxLines(5);
            ThreadCardUtils.setTitle(this.k, this.l.n(), t, this.p);
        } else {
            this.k.setMaxLines(2);
            ThreadCardUtils.setTitle(this.k, this.l.n(), 0, this.p);
        }
        TextView textView = this.k;
        ThreadCardUtils.dealMainViewTopMargin(this.m, (textView == null || textView.getVisibility() != 0) ? true : true, UtilHelper.getDimenPixelSize(R.dimen.M_H_X003));
    }

    @Override // d.b.i.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        d.b.h0.r.q.a aVar = this.l;
        if (aVar == null || aVar.n() == null) {
            return;
        }
        d.b.i0.x.m.l(this.k, this.l.n().o0(), R.color.CAM_X0105, R.color.CAM_X0109);
        this.m.c(i);
        this.m.setBackgroundColor(SkinManager.getColor(R.color.CAM_X0209));
    }

    public void p(boolean z) {
        this.p = z;
    }

    public void q(BdUniqueId bdUniqueId) {
    }
}

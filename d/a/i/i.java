package d.a.i;

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
import d.a.i.v0.a;
/* loaded from: classes.dex */
public class i extends d.a.i.a<d.a.m0.r.q.a> {
    public static final int r = (d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.M_W_X005) + d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.M_W_X004)) * 2;
    public static int s;
    public static int t;
    public static int u;
    public static int v;
    public View j;
    public TextView k;
    public d.a.m0.r.q.a l;
    public RoundCornerFrameLayout m;
    public FakeVideoContainer n;
    public int o;
    public boolean p;
    public a.b q;

    /* loaded from: classes.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ViewGroup.LayoutParams f43706e;

        public a(ViewGroup.LayoutParams layoutParams) {
            this.f43706e = layoutParams;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f43706e.width = i.this.j.getWidth();
            this.f43706e.height = (i.this.j.getWidth() / 16) * 9;
            i.this.m.setLayoutParams(this.f43706e);
        }
    }

    /* loaded from: classes.dex */
    public class b implements a.b {
        public b() {
        }

        @Override // d.a.i.v0.a.b
        public boolean a(a.C0600a c0600a) {
            RoundCornerFrameLayout roundCornerFrameLayout;
            if (c0600a.b() != 7 || (roundCornerFrameLayout = i.this.m) == null) {
                return false;
            }
            roundCornerFrameLayout.d(((Boolean) c0600a.c()).booleanValue());
            return false;
        }
    }

    static {
        int k = d.a.c.e.p.l.k(TbadkCoreApplication.getInst());
        s = k;
        int i2 = k - r;
        t = i2;
        u = i2 / 2;
        v = i2 / 3;
    }

    public i(Context context) {
        super(context);
        this.o = 0;
        this.p = false;
        this.q = new b();
    }

    @Override // d.a.i.a
    public View g() {
        if (this.j == null) {
            View inflate = LayoutInflater.from(this.f43689f).inflate(R.layout.card_video_layout, (ViewGroup) null, true);
            this.j = inflate;
            this.k = (TextView) inflate.findViewById(R.id.video_seg_title);
            this.m = (RoundCornerFrameLayout) this.j.findViewById(R.id.frame_video);
            FakeVideoContainer fakeVideoContainer = new FakeVideoContainer(this.f43689f);
            this.n = fakeVideoContainer;
            fakeVideoContainer.setBackgroundResource(R.color.transparent);
            this.m.addView(this.n);
        }
        return this.j;
    }

    @Override // d.a.i.a
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
        r0 = d.a.m0.b.g.b.m(r11, r8, null, r0, r1);
     */
    @Override // d.a.i.p
    /* renamed from: o */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(d.a.m0.r.q.a aVar) {
        boolean z;
        int k = d.a.c.e.p.l.k(TbadkCoreApplication.getInst());
        if (k != this.o) {
            int k2 = d.a.c.e.p.l.k(TbadkCoreApplication.getInst());
            s = k2;
            int i2 = k2 - r;
            t = i2;
            u = i2 / 2;
            v = i2 / 3;
            this.o = k;
        }
        this.l = aVar;
        if (aVar == null || aVar.i() == null || this.l.i().x1() == null) {
            return;
        }
        this.n.setData(aVar.i());
        ViewGroup.LayoutParams layoutParams = this.m.getLayoutParams();
        int i3 = layoutParams.width;
        int i4 = layoutParams.height;
        boolean z2 = false;
        if (this.l.i().x1().is_vertical.intValue() == 1) {
            int i5 = (u / 9) * 16;
            int i6 = v;
            int intValue = this.l.i().x1().video_width.intValue();
            int intValue2 = this.l.i().x1().video_height.intValue();
            int i7 = u;
            layoutParams.width = i7;
            boolean z3 = i3 != i7;
            if (intValue != 0 && intValue2 != 0) {
                int i8 = (int) (((intValue2 * 1.0f) / intValue) * u);
                if (i8 < i6) {
                    i5 = i6;
                } else if (i8 <= i5) {
                    i5 = i8;
                }
                layoutParams.height = i5;
            } else {
                layoutParams.height = i5;
            }
        } else {
            int i9 = t;
            layoutParams.width = i9;
            int i10 = (i9 / 16) * 9;
            layoutParams.height = i10;
            z = (i4 == i10 && i3 == i9) ? false : true;
        }
        if (z) {
            if (this.l.i().x1().is_vertical.intValue() == 1) {
                this.m.setLayoutParams(layoutParams);
            } else {
                this.m.post(new a(layoutParams));
            }
        }
        if (this.l.i().T1()) {
            this.k.setMaxLines(5);
            ThreadCardUtils.setTitle(this.k, this.l.i(), t, this.p);
        } else {
            this.k.setMaxLines(2);
            ThreadCardUtils.setTitle(this.k, this.l.i(), 0, this.p);
        }
        TextView textView = this.k;
        ThreadCardUtils.dealMainViewTopMargin(this.m, (textView == null || textView.getVisibility() != 0) ? true : true, UtilHelper.getDimenPixelSize(R.dimen.M_H_X003));
    }

    @Override // d.a.i.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i2) {
        d.a.m0.r.q.a aVar = this.l;
        if (aVar == null || aVar.i() == null) {
            return;
        }
        d.a.n0.z.m.l(this.k, this.l.i().o0(), R.color.CAM_X0105, R.color.CAM_X0109);
        this.m.c(i2);
        this.m.setBackgroundColor(SkinManager.getColor(R.color.CAM_X0209));
    }

    public void p(boolean z) {
        this.p = z;
    }

    public void q(BdUniqueId bdUniqueId) {
    }
}

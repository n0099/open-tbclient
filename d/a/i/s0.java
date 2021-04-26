package d.a.i;

import android.content.Context;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.card.view.RoundCornerFrameLayout;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.ThreadCardUtils;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.videoPreload.IVideoNeedPreload;
import com.baidu.tieba.R;
import d.a.i.a;
import d.a.i.u0.a;
/* loaded from: classes.dex */
public abstract class s0 extends d.a.i.a<d.a.i0.r.q.a> implements d.a.j0.j2.e {
    public static int A;
    public static int B;
    public static final int x = (d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.M_W_X005) + d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.M_W_X004)) * 2;
    public static int y;
    public static int z;
    public View j;
    public TextView k;
    public d.a.i0.r.q.a l;
    public RoundCornerFrameLayout m;
    public d.a.j0.j2.q.a n;
    public String o;
    public String p;
    public BdUniqueId q;
    public int r;
    public boolean s;
    public View.OnClickListener t;
    public final View.OnClickListener u;
    public final View.OnClickListener v;
    public a.b w;

    /* loaded from: classes.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ViewGroup.LayoutParams f47753e;

        public a(ViewGroup.LayoutParams layoutParams) {
            this.f47753e = layoutParams;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f47753e.width = s0.this.j.getWidth();
            this.f47753e.height = (s0.this.j.getWidth() / 16) * 9;
            s0.this.m.setLayoutParams(this.f47753e);
        }
    }

    /* loaded from: classes.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            s0 s0Var;
            d.a.i0.r.q.a aVar;
            if (d.a.i0.b.d.J() && (aVar = (s0Var = s0.this).l) != null) {
                d.a.i0.z0.t.a(false, s0Var.f47690f, aVar.m(), s0.this.o);
            } else if (d.a.i0.b.d.L()) {
                d.a.i0.r.q.a aVar2 = s0.this.l;
                if (aVar2 == null || aVar2.m() == null) {
                    return;
                }
                s0 s0Var2 = s0.this;
                d.a.i0.z0.t.f(false, s0Var2.f47690f, s0Var2.l.m(), 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "personalize_page", "", s0.this.o, s0.this.o);
            } else {
                s0 s0Var3 = s0.this;
                a.InterfaceC1009a interfaceC1009a = s0Var3.f47693i;
                if (interfaceC1009a != null) {
                    interfaceC1009a.a(s0Var3.l);
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            s0 s0Var = s0.this;
            a.InterfaceC1009a interfaceC1009a = s0Var.f47693i;
            if (interfaceC1009a != null) {
                interfaceC1009a.a(s0Var.l);
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (s0.this.d() != null) {
                s0.this.d().a(view, s0.this.l);
            }
        }
    }

    /* loaded from: classes.dex */
    public class e implements a.b {
        public e() {
        }

        @Override // d.a.i.u0.a.b
        public boolean a(a.C1011a c1011a) {
            if (c1011a.b() == 1) {
                s0 s0Var = s0.this;
                d.a.j0.x.m.l(s0Var.k, s0Var.l.m().o0(), R.color.CAM_X0105, R.color.CAM_X0109);
                return false;
            } else if (c1011a.b() == 2) {
                d.a.j0.j2.q.a aVar = s0.this.n;
                if (aVar != null) {
                    aVar.l0();
                    return false;
                }
                return false;
            } else if (c1011a.b() == 3) {
                d.a.j0.j2.q.a aVar2 = s0.this.n;
                if (aVar2 != null) {
                    aVar2.c0();
                    return false;
                }
                return false;
            } else if (c1011a.b() == 6) {
                d.a.j0.j2.q.a aVar3 = s0.this.n;
                if (aVar3 != null) {
                    return aVar3.D();
                }
                return false;
            } else if (c1011a.b() == 7) {
                RoundCornerFrameLayout roundCornerFrameLayout = s0.this.m;
                if (roundCornerFrameLayout != null) {
                    roundCornerFrameLayout.d(((Boolean) c1011a.c()).booleanValue());
                    return false;
                }
                return false;
            } else if (c1011a.b() == 8 && s0.this.n != null && (c1011a.c() instanceof Boolean)) {
                return s0.this.n.o0(((Boolean) c1011a.c()).booleanValue());
            } else {
                return false;
            }
        }
    }

    static {
        int k = d.a.c.e.p.l.k(TbadkCoreApplication.getInst());
        y = k;
        int i2 = k - x;
        z = i2;
        A = i2 / 2;
        B = i2 / 3;
    }

    public s0(Context context) {
        super(context);
        this.r = 0;
        this.s = false;
        this.t = new b();
        this.u = new c();
        this.v = new d();
        this.w = new e();
    }

    @Override // d.a.j0.j2.e
    public boolean C() {
        d.a.j0.j2.q.a aVar = this.n;
        if (aVar == null) {
            return false;
        }
        return aVar.C();
    }

    @Override // d.a.i.a
    public View g() {
        if (this.j == null) {
            View inflate = LayoutInflater.from(this.f47690f).inflate(R.layout.card_video_layout, (ViewGroup) null, true);
            this.j = inflate;
            this.k = (TextView) inflate.findViewById(R.id.video_seg_title);
            this.m = (RoundCornerFrameLayout) this.j.findViewById(R.id.frame_video);
            d.a.j0.j2.q.a q = q();
            this.n = q;
            q.E().setBackgroundResource(R.color.transparent);
            this.n.setUniqueId(this.q);
            this.n.setFrom(this.o);
            this.n.setStageType(this.p);
        }
        return this.j;
    }

    @Override // d.a.j0.j2.e
    public int getCurrentPosition() {
        return this.n.getCurrentPosition();
    }

    @Override // d.a.j0.j2.e
    public String getPlayUrl() {
        d.a.i0.r.q.a aVar = this.l;
        if (aVar == null || aVar.m() == null) {
            return null;
        }
        return this.l.m().getVideoUrl();
    }

    @Override // d.a.j0.j2.e
    public View getVideoContainer() {
        return this.m;
    }

    @Override // d.a.i.a
    public void h() {
        i(1, this.w);
        i(2, this.w);
        i(3, this.w);
        i(6, this.w);
        i(7, this.w);
        i(8, this.w);
    }

    @Override // d.a.j0.j2.e
    public boolean isPlayStarted() {
        return this.n.isPlaying();
    }

    @Override // d.a.j0.j2.e
    public boolean isPlaying() {
        return this.n.isPlaying();
    }

    @Override // d.a.i.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i2) {
        d.a.i0.r.q.a aVar = this.l;
        if (aVar == null || aVar.m() == null) {
            return;
        }
        d.a.j0.x.m.l(this.k, this.l.m().o0(), R.color.CAM_X0105, R.color.CAM_X0109);
        this.m.c(i2);
        this.m.setBackgroundColor(SkinManager.getColor(R.color.CAM_X0209));
    }

    public d.a.j0.j2.q.a p() {
        return this.n;
    }

    public abstract d.a.j0.j2.q.a q();

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x00b1, code lost:
        if (r1 != r2) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00b6, code lost:
        if (r1 != r2) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00b8, code lost:
        r8 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00b9, code lost:
        r0 = d.a.i0.b.g.b.m(r11, r8, r10.n, r0, r1);
     */
    @Override // d.a.i.p
    /* renamed from: r */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(d.a.i0.r.q.a aVar) {
        boolean z2;
        int k = d.a.c.e.p.l.k(TbadkCoreApplication.getInst());
        if (k != this.r) {
            int k2 = d.a.c.e.p.l.k(TbadkCoreApplication.getInst());
            y = k2;
            int i2 = k2 - x;
            z = i2;
            A = i2 / 2;
            B = i2 / 3;
            this.r = k;
        }
        this.l = aVar;
        if (aVar == null || aVar.m() == null || this.l.m().u1() == null) {
            return;
        }
        this.n.setData(aVar.m());
        ViewGroup.LayoutParams layoutParams = this.m.getLayoutParams();
        int i3 = layoutParams.width;
        int i4 = layoutParams.height;
        boolean z3 = false;
        if (this.l.m().u1().is_vertical.intValue() == 1) {
            int i5 = (A / 9) * 16;
            int i6 = B;
            int intValue = this.l.m().u1().video_width.intValue();
            int intValue2 = this.l.m().u1().video_height.intValue();
            int i7 = A;
            layoutParams.width = i7;
            boolean z4 = i3 != i7;
            if (intValue != 0 && intValue2 != 0) {
                int i8 = (int) (((intValue2 * 1.0f) / intValue) * A);
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
            int i9 = z;
            layoutParams.width = i9;
            int i10 = (i9 / 16) * 9;
            layoutParams.height = i10;
            z2 = (i4 == i10 && i3 == i9) ? false : true;
        }
        if (z2) {
            if (this.l.m().u1().is_vertical.intValue() == 1) {
                this.m.setLayoutParams(layoutParams);
            } else {
                this.m.post(new a(layoutParams));
            }
        }
        if (this.l.m().Q1()) {
            this.k.setMaxLines(5);
            ThreadCardUtils.setTitle(this.k, this.l.m(), z, this.s);
        } else {
            this.k.setMaxLines(2);
            ThreadCardUtils.setTitle(this.k, this.l.m(), 0, this.s);
        }
        TextView textView = this.k;
        ThreadCardUtils.dealMainViewTopMargin(this.m, (textView == null || textView.getVisibility() != 0) ? true : true, UtilHelper.getDimenPixelSize(R.dimen.M_H_X003));
        if (this.f47693i != null) {
            this.n.s0(this.u);
        }
        if (d() != null) {
            this.n.setAfterClickListener(this.v);
        }
        TextView textView2 = this.k;
        if (textView2 == null || this.j == null) {
            return;
        }
        textView2.setOnClickListener(this.t);
        this.k.setMovementMethod(LinkMovementMethod.getInstance());
        this.j.setOnClickListener(this.t);
    }

    public void s() {
    }

    @Override // d.a.j0.j2.e
    public void startPlay() {
        Context context = this.f47690f;
        if ((context instanceof IVideoNeedPreload) && ((IVideoNeedPreload) context).videoNeedPreload()) {
            this.n.startPlay();
        }
    }

    @Override // d.a.j0.j2.e
    public void stopPlay() {
        this.n.stopPlay();
    }

    public void t() {
    }

    public void u(String str) {
        this.o = str;
        d.a.j0.j2.q.a aVar = this.n;
        if (aVar != null) {
            aVar.setFrom(str);
        }
    }

    public void v(a.InterfaceC1009a interfaceC1009a) {
        this.f47693i = interfaceC1009a;
    }

    public void w(boolean z2) {
        this.s = z2;
    }

    public void x(BdUniqueId bdUniqueId) {
        this.q = bdUniqueId;
    }

    public void y(String str) {
        this.p = str;
        d.a.j0.j2.q.a aVar = this.n;
        if (aVar != null) {
            aVar.setStageType(str);
        }
    }

    public void z(d.a.j0.j2.o oVar) {
        d.a.j0.j2.q.a aVar = this.n;
        if (aVar != null) {
            aVar.k0(oVar);
        }
    }
}

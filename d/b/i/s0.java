package d.b.i;

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
import d.b.i.a;
import d.b.i.u0.a;
/* loaded from: classes.dex */
public abstract class s0 extends d.b.i.a<d.b.i0.r.q.a> implements d.b.j0.j2.e {
    public static int A;
    public static int B;
    public static final int x = (d.b.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.M_W_X005) + d.b.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.M_W_X004)) * 2;
    public static int y;
    public static int z;
    public View j;
    public TextView k;
    public d.b.i0.r.q.a l;
    public RoundCornerFrameLayout m;
    public d.b.j0.j2.q.a n;
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
        public final /* synthetic */ ViewGroup.LayoutParams f50209e;

        public a(ViewGroup.LayoutParams layoutParams) {
            this.f50209e = layoutParams;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f50209e.width = s0.this.j.getWidth();
            this.f50209e.height = (s0.this.j.getWidth() / 16) * 9;
            s0.this.m.setLayoutParams(this.f50209e);
        }
    }

    /* loaded from: classes.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            s0 s0Var;
            d.b.i0.r.q.a aVar;
            if (d.b.i0.b.d.J() && (aVar = (s0Var = s0.this).l) != null) {
                d.b.i0.z0.t.a(false, s0Var.f50155f, aVar.n(), s0.this.o);
            } else if (d.b.i0.b.d.L()) {
                d.b.i0.r.q.a aVar2 = s0.this.l;
                if (aVar2 == null || aVar2.n() == null) {
                    return;
                }
                s0 s0Var2 = s0.this;
                d.b.i0.z0.t.f(false, s0Var2.f50155f, s0Var2.l.n(), 0, null, VideoPlayActivityConfig.FROM_NANI_VIDEO, "personalize_page", "", s0.this.o, s0.this.o);
            } else {
                s0 s0Var3 = s0.this;
                a.InterfaceC1070a interfaceC1070a = s0Var3.i;
                if (interfaceC1070a != null) {
                    interfaceC1070a.a(s0Var3.l);
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
            a.InterfaceC1070a interfaceC1070a = s0Var.i;
            if (interfaceC1070a != null) {
                interfaceC1070a.a(s0Var.l);
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

        @Override // d.b.i.u0.a.b
        public boolean a(a.C1072a c1072a) {
            if (c1072a.b() == 1) {
                s0 s0Var = s0.this;
                d.b.j0.x.m.l(s0Var.k, s0Var.l.n().o0(), R.color.CAM_X0105, R.color.CAM_X0109);
                return false;
            } else if (c1072a.b() == 2) {
                d.b.j0.j2.q.a aVar = s0.this.n;
                if (aVar != null) {
                    aVar.a0();
                    return false;
                }
                return false;
            } else if (c1072a.b() == 3) {
                d.b.j0.j2.q.a aVar2 = s0.this.n;
                if (aVar2 != null) {
                    aVar2.N();
                    return false;
                }
                return false;
            } else if (c1072a.b() == 6) {
                d.b.j0.j2.q.a aVar3 = s0.this.n;
                if (aVar3 != null) {
                    return aVar3.H();
                }
                return false;
            } else if (c1072a.b() == 7) {
                RoundCornerFrameLayout roundCornerFrameLayout = s0.this.m;
                if (roundCornerFrameLayout != null) {
                    roundCornerFrameLayout.d(((Boolean) c1072a.c()).booleanValue());
                    return false;
                }
                return false;
            } else if (c1072a.b() == 8 && s0.this.n != null && (c1072a.c() instanceof Boolean)) {
                return s0.this.n.e0(((Boolean) c1072a.c()).booleanValue());
            } else {
                return false;
            }
        }
    }

    static {
        int k = d.b.c.e.p.l.k(TbadkCoreApplication.getInst());
        y = k;
        int i = k - x;
        z = i;
        A = i / 2;
        B = i / 3;
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

    @Override // d.b.j0.j2.e
    public boolean D() {
        d.b.j0.j2.q.a aVar = this.n;
        if (aVar == null) {
            return false;
        }
        return aVar.D();
    }

    @Override // d.b.i.a
    public View g() {
        if (this.j == null) {
            View inflate = LayoutInflater.from(this.f50155f).inflate(R.layout.card_video_layout, (ViewGroup) null, true);
            this.j = inflate;
            this.k = (TextView) inflate.findViewById(R.id.video_seg_title);
            this.m = (RoundCornerFrameLayout) this.j.findViewById(R.id.frame_video);
            d.b.j0.j2.q.a q = q();
            this.n = q;
            q.C().setBackgroundResource(R.color.transparent);
            this.n.setUniqueId(this.q);
            this.n.setFrom(this.o);
            this.n.setStageType(this.p);
        }
        return this.j;
    }

    @Override // d.b.j0.j2.e
    public int getCurrentPosition() {
        return this.n.getCurrentPosition();
    }

    @Override // d.b.j0.j2.e
    public String getPlayUrl() {
        d.b.i0.r.q.a aVar = this.l;
        if (aVar == null || aVar.n() == null) {
            return null;
        }
        return this.l.n().getVideoUrl();
    }

    @Override // d.b.j0.j2.e
    public View getVideoContainer() {
        return this.m;
    }

    @Override // d.b.i.a
    public void h() {
        i(1, this.w);
        i(2, this.w);
        i(3, this.w);
        i(6, this.w);
        i(7, this.w);
        i(8, this.w);
    }

    @Override // d.b.j0.j2.e
    public boolean isPlayStarted() {
        return this.n.isPlaying();
    }

    @Override // d.b.j0.j2.e
    public boolean isPlaying() {
        return this.n.isPlaying();
    }

    @Override // d.b.i.q
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        d.b.i0.r.q.a aVar = this.l;
        if (aVar == null || aVar.n() == null) {
            return;
        }
        d.b.j0.x.m.l(this.k, this.l.n().o0(), R.color.CAM_X0105, R.color.CAM_X0109);
        this.m.c(i);
        this.m.setBackgroundColor(SkinManager.getColor(R.color.CAM_X0209));
    }

    public d.b.j0.j2.q.a p() {
        return this.n;
    }

    public abstract d.b.j0.j2.q.a q();

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
        r0 = d.b.i0.b.g.b.m(r11, r8, r10.n, r0, r1);
     */
    @Override // d.b.i.p
    /* renamed from: r */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(d.b.i0.r.q.a aVar) {
        boolean z2;
        int k = d.b.c.e.p.l.k(TbadkCoreApplication.getInst());
        if (k != this.r) {
            int k2 = d.b.c.e.p.l.k(TbadkCoreApplication.getInst());
            y = k2;
            int i = k2 - x;
            z = i;
            A = i / 2;
            B = i / 3;
            this.r = k;
        }
        this.l = aVar;
        if (aVar == null || aVar.n() == null || this.l.n().u1() == null) {
            return;
        }
        this.n.setData(aVar.n());
        ViewGroup.LayoutParams layoutParams = this.m.getLayoutParams();
        int i2 = layoutParams.width;
        int i3 = layoutParams.height;
        boolean z3 = false;
        if (this.l.n().u1().is_vertical.intValue() == 1) {
            int i4 = (A / 9) * 16;
            int i5 = B;
            int intValue = this.l.n().u1().video_width.intValue();
            int intValue2 = this.l.n().u1().video_height.intValue();
            int i6 = A;
            layoutParams.width = i6;
            boolean z4 = i2 != i6;
            if (intValue != 0 && intValue2 != 0) {
                int i7 = (int) (((intValue2 * 1.0f) / intValue) * A);
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
            int i8 = z;
            layoutParams.width = i8;
            int i9 = (i8 / 16) * 9;
            layoutParams.height = i9;
            z2 = (i3 == i9 && i2 == i8) ? false : true;
        }
        if (z2) {
            if (this.l.n().u1().is_vertical.intValue() == 1) {
                this.m.setLayoutParams(layoutParams);
            } else {
                this.m.post(new a(layoutParams));
            }
        }
        if (this.l.n().Q1()) {
            this.k.setMaxLines(5);
            ThreadCardUtils.setTitle(this.k, this.l.n(), z, this.s);
        } else {
            this.k.setMaxLines(2);
            ThreadCardUtils.setTitle(this.k, this.l.n(), 0, this.s);
        }
        TextView textView = this.k;
        ThreadCardUtils.dealMainViewTopMargin(this.m, (textView == null || textView.getVisibility() != 0) ? true : true, UtilHelper.getDimenPixelSize(R.dimen.M_H_X003));
        if (this.i != null) {
            this.n.k0(this.u);
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

    @Override // d.b.j0.j2.e
    public void startPlay() {
        Context context = this.f50155f;
        if ((context instanceof IVideoNeedPreload) && ((IVideoNeedPreload) context).videoNeedPreload()) {
            this.n.startPlay();
        }
    }

    @Override // d.b.j0.j2.e
    public void stopPlay() {
        this.n.stopPlay();
    }

    public void t() {
    }

    public void u(String str) {
        this.o = str;
        d.b.j0.j2.q.a aVar = this.n;
        if (aVar != null) {
            aVar.setFrom(str);
        }
    }

    public void v(a.InterfaceC1070a interfaceC1070a) {
        this.i = interfaceC1070a;
    }

    public void w(boolean z2) {
        this.s = z2;
    }

    public void x(BdUniqueId bdUniqueId) {
        this.q = bdUniqueId;
    }

    public void y(String str) {
        this.p = str;
        d.b.j0.j2.q.a aVar = this.n;
        if (aVar != null) {
            aVar.setStageType(str);
        }
    }

    public void z(d.b.j0.j2.o oVar) {
        d.b.j0.j2.q.a aVar = this.n;
        if (aVar != null) {
            aVar.Z(oVar);
        }
    }
}

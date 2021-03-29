package d.b.i0.f1;

import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.coreExtra.view.ImagePagerAdapter;
import com.baidu.tbadk.widget.DragImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.image.ImageViewerActivity;
import d.b.b.e.p.l;
import d.b.i0.q0.a;
/* loaded from: classes3.dex */
public class c implements ImagePagerAdapter.a {

    /* renamed from: b  reason: collision with root package name */
    public boolean f54631b;

    /* renamed from: c  reason: collision with root package name */
    public TbPageContext f54632c;

    /* renamed from: d  reason: collision with root package name */
    public ImageViewerActivity f54633d;

    /* renamed from: e  reason: collision with root package name */
    public RelativeLayout f54634e;

    /* renamed from: f  reason: collision with root package name */
    public ViewGroup f54635f;

    /* renamed from: a  reason: collision with root package name */
    public int f54630a = 0;

    /* renamed from: g  reason: collision with root package name */
    public boolean f54636g = false;

    /* renamed from: h  reason: collision with root package name */
    public boolean f54637h = false;
    public boolean i = false;
    public final a.f j = new b();

    /* loaded from: classes3.dex */
    public class a implements a.d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f54638a;

        public a(int i) {
            this.f54638a = i;
        }

        @Override // d.b.i0.q0.a.d
        public void a(String str, int i) {
            c.this.i = false;
            c.this.f54637h = true;
            if (d.b.i0.q0.a.h().k(str)) {
                c.this.t(1);
                c.this.v(this.f54638a);
                c.this.j(0);
                return;
            }
            c.this.t(0);
            c.this.j(1);
        }

        @Override // d.b.i0.q0.a.d
        public void onError(String str) {
            c.this.i = false;
            c.this.t(0);
            c.this.j(1);
        }
    }

    /* loaded from: classes3.dex */
    public class b extends a.f {
        public b() {
        }

        @Override // d.b.i0.q0.a.e
        public void onAdClicked(String str) {
            c.this.i();
        }

        @Override // d.b.i0.q0.a.e
        public void onAdClose(String str) {
            if (c.this.f54633d != null) {
                c.this.f54633d.finish();
            }
        }

        @Override // d.b.i0.q0.a.e
        public void onAdError(String str) {
            c.this.t(0);
            c.this.k(1);
        }

        @Override // d.b.i0.q0.a.e
        public void onAdShow(String str) {
            c.this.f54636g = true;
        }
    }

    public c(@NonNull ImageViewerActivity imageViewerActivity, boolean z) {
        this.f54633d = imageViewerActivity;
        this.f54632c = imageViewerActivity.getPageContext();
        this.f54631b = z;
        this.f54634e = new RelativeLayout(this.f54633d);
        ViewGroup g2 = d.b.i0.q0.a.h().g(imageViewerActivity, "6051001774-1519133515");
        this.f54635f = g2;
        if (g2 != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(l.k(this.f54633d), -2);
            layoutParams.addRule(14, -1);
            layoutParams.addRule(15, -1);
            this.f54634e.addView(this.f54635f, layoutParams);
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.ImagePagerAdapter.a
    public View a(ViewGroup viewGroup, int i) {
        if (this.f54632c != null && this.f54635f != null && this.f54631b && l(i) && n()) {
            if (this.f54634e.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.f54634e.getParent()).removeView(this.f54634e);
            }
            viewGroup.addView(this.f54634e);
            return this.f54634e;
        }
        return null;
    }

    public final void i() {
        StatisticItem.make(TbadkCoreStatisticKey.FUN_AD_CLICK).param("obj_source", 6).param("obj_type", "a008").eventStat();
    }

    public final void j(int i) {
        StatisticItem.make(TbadkCoreStatisticKey.FUN_AD_REQUEST).param("obj_source", 6).param("obj_type", "a008").param("obj_locate", i).eventStat();
    }

    public final void k(int i) {
        StatisticItem.make(TbadkCoreStatisticKey.FUN_AD_SHOW).param("obj_source", 6).param("obj_type", "a008").param("obj_locate", i).eventStat();
    }

    public final boolean l(int i) {
        int i2 = this.f54630a;
        return i2 != 0 && i == i2;
    }

    public boolean m() {
        return this.f54631b && this.f54635f != null && this.f54637h;
    }

    public boolean n() {
        return this.f54637h;
    }

    public boolean o() {
        return this.f54636g;
    }

    public boolean p(int i, int i2, int i3) {
        return i == 1;
    }

    public void q() {
    }

    public void r() {
        d.b.i0.q0.a.h().c("6051001774-1519133515");
    }

    public void s(int i, int i2, int i3) {
        if (!this.f54631b || this.f54635f == null || this.i || this.f54637h || !p(i, i2, i3)) {
            return;
        }
        this.i = true;
        d.b.i0.q0.a.h().l(this.f54633d, "6051001774-1519133515", new a(i3), d.b.i0.q0.a.a("pic", d.b.h0.b.d.B() ? "1" : "0"));
    }

    public void t(int i) {
        ImageViewerActivity imageViewerActivity = this.f54633d;
        if (imageViewerActivity != null) {
            imageViewerActivity.setAddSize(i);
        }
    }

    public void u(DragImageView.h hVar) {
    }

    public boolean v(int i) {
        if (this.f54632c == null || this.f54635f == null || !this.f54631b || this.f54636g || !l(i) || !n()) {
            return false;
        }
        d.b.i0.q0.a.h().n(this.f54632c.getPageActivity(), "6051001774-1519133515", this.f54635f, this.j, d.b.i0.q0.a.a("pic", d.b.h0.b.d.B() ? "1" : "0"));
        SkinManager.setBackgroundColor(this.f54635f, R.color.CAM_X0101, 0);
        k(0);
        return true;
    }

    public void w(int i, int i2) {
        this.f54630a = i;
    }
}

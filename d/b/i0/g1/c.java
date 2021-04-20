package d.b.i0.g1;

import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.view.ImagePagerAdapter;
import com.baidu.tbadk.widget.DragImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.image.ImageViewerActivity;
import d.b.c.e.p.l;
import d.b.i0.r0.a;
/* loaded from: classes4.dex */
public class c implements ImagePagerAdapter.a {

    /* renamed from: b  reason: collision with root package name */
    public boolean f56094b;

    /* renamed from: c  reason: collision with root package name */
    public TbPageContext f56095c;

    /* renamed from: d  reason: collision with root package name */
    public ImageViewerActivity f56096d;

    /* renamed from: e  reason: collision with root package name */
    public RelativeLayout f56097e;

    /* renamed from: f  reason: collision with root package name */
    public ViewGroup f56098f;
    public String j;
    public String k;

    /* renamed from: a  reason: collision with root package name */
    public int f56093a = 0;

    /* renamed from: g  reason: collision with root package name */
    public boolean f56099g = false;

    /* renamed from: h  reason: collision with root package name */
    public boolean f56100h = false;
    public boolean i = false;
    public final a.g l = new b();

    /* loaded from: classes4.dex */
    public class a implements a.e {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f56101a;

        public a(int i) {
            this.f56101a = i;
        }

        @Override // d.b.i0.r0.a.e
        public void a(String str, int i) {
            c.this.i = false;
            c.this.f56100h = true;
            if (d.b.i0.r0.a.h().k(str)) {
                c.this.t(1);
                c.this.v(this.f56101a);
                c.this.j(0);
                return;
            }
            c.this.t(0);
            c.this.j(1);
        }

        @Override // d.b.i0.r0.a.e
        public void onError(String str) {
            c.this.i = false;
            c.this.t(0);
            c.this.j(1);
        }
    }

    /* loaded from: classes4.dex */
    public class b extends a.g {
        public b() {
        }

        @Override // d.b.i0.r0.a.f
        public void onAdClicked(String str) {
            c.this.i();
        }

        @Override // d.b.i0.r0.a.f
        public void onAdClose(String str) {
            if (c.this.f56096d != null) {
                c.this.f56096d.finish();
            }
        }

        @Override // d.b.i0.r0.a.f
        public void onAdError(String str) {
            c.this.t(0);
            c.this.k(1);
        }

        @Override // d.b.i0.r0.a.f
        public void onAdShow(String str) {
            c.this.f56099g = true;
        }
    }

    public c(@NonNull ImageViewerActivity imageViewerActivity, boolean z) {
        this.f56096d = imageViewerActivity;
        this.f56095c = imageViewerActivity.getPageContext();
        this.f56094b = z;
        this.f56097e = new RelativeLayout(this.f56096d);
        ViewGroup g2 = d.b.i0.r0.a.h().g(imageViewerActivity, "6051001643-679358748");
        this.f56098f = g2;
        if (g2 != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(l.k(this.f56096d), -2);
            layoutParams.addRule(14, -1);
            layoutParams.addRule(15, -1);
            this.f56097e.addView(this.f56098f, layoutParams);
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.ImagePagerAdapter.a
    public View a(ViewGroup viewGroup, int i) {
        if (this.f56095c != null && this.f56098f != null && this.f56094b && l(i) && n()) {
            if (this.f56097e.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.f56097e.getParent()).removeView(this.f56097e);
            }
            viewGroup.addView(this.f56097e);
            return this.f56097e;
        }
        return null;
    }

    public final void i() {
        StatisticItem.make(TbadkCoreStatisticKey.FUN_AD_CLICK).param("obj_source", 6).param("obj_type", "a008").eventStat();
    }

    public final void j(int i) {
        StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.FUN_AD_REQUEST).param("obj_source", 6).param("obj_type", "a008").param("obj_locate", i);
        if (i == 1) {
            param.param(TiebaStatic.Params.RESOURCE_ID, 0);
        }
        TiebaStatic.log(param);
    }

    public final void k(int i) {
        StatisticItem.make(TbadkCoreStatisticKey.FUN_AD_SHOW).param("obj_source", 6).param("obj_type", "a008").param("tid", this.j).param("fid", this.k).param("obj_locate", i).eventStat();
    }

    public final boolean l(int i) {
        int i2 = this.f56093a;
        return i2 != 0 && i == i2;
    }

    public boolean m() {
        return this.f56094b && this.f56098f != null && this.f56100h;
    }

    public boolean n() {
        return this.f56100h;
    }

    public boolean o() {
        return this.f56099g;
    }

    public boolean p(int i, int i2, int i3) {
        return i == 1;
    }

    public void q() {
    }

    public void r() {
        d.b.i0.r0.a.h().c("6051001643-679358748");
    }

    public void s(int i, int i2, int i3, String str, String str2) {
        if (!this.f56094b || this.f56098f == null || this.i || this.f56100h || !p(i, i2, i3)) {
            return;
        }
        this.i = true;
        this.j = str;
        this.k = str2;
        StatisticItem.make(TbadkCoreStatisticKey.FUN_AD_REQUEST).param("obj_source", 6).param("tid", str).param("fid", str2).param("obj_type", "a008").eventStat();
        d.b.i0.r0.a.h().l(this.f56096d, "6051001643-679358748", new a(i3), d.b.i0.r0.a.a("pic", d.b.h0.b.d.D() ? "1" : "0"));
    }

    public void t(int i) {
        ImageViewerActivity imageViewerActivity = this.f56096d;
        if (imageViewerActivity != null) {
            imageViewerActivity.setAddSize(i);
        }
    }

    public void u(DragImageView.h hVar) {
    }

    public boolean v(int i) {
        if (this.f56095c == null || this.f56098f == null || !this.f56094b || this.f56099g || !l(i) || !n()) {
            return false;
        }
        d.b.i0.r0.a.h().n(this.f56095c.getPageActivity(), "6051001643-679358748", this.f56098f, this.l, d.b.i0.r0.a.a("pic", d.b.h0.b.d.D() ? "1" : "0"));
        SkinManager.setBackgroundColor(this.f56098f, R.color.CAM_X0101, 0);
        k(0);
        return true;
    }

    public void w(int i, int i2) {
        this.f56093a = i;
    }
}

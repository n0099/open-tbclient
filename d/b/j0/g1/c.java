package d.b.j0.g1;

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
import d.b.j0.r0.a;
/* loaded from: classes4.dex */
public class c implements ImagePagerAdapter.a {

    /* renamed from: b  reason: collision with root package name */
    public boolean f56515b;

    /* renamed from: c  reason: collision with root package name */
    public TbPageContext f56516c;

    /* renamed from: d  reason: collision with root package name */
    public ImageViewerActivity f56517d;

    /* renamed from: e  reason: collision with root package name */
    public RelativeLayout f56518e;

    /* renamed from: f  reason: collision with root package name */
    public ViewGroup f56519f;
    public String j;
    public String k;

    /* renamed from: a  reason: collision with root package name */
    public int f56514a = 0;

    /* renamed from: g  reason: collision with root package name */
    public boolean f56520g = false;

    /* renamed from: h  reason: collision with root package name */
    public boolean f56521h = false;
    public boolean i = false;
    public final a.g l = new b();

    /* loaded from: classes4.dex */
    public class a implements a.e {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f56522a;

        public a(int i) {
            this.f56522a = i;
        }

        @Override // d.b.j0.r0.a.e
        public void a(String str, int i) {
            c.this.i = false;
            c.this.f56521h = true;
            if (d.b.j0.r0.a.h().k(str)) {
                c.this.t(1);
                c.this.v(this.f56522a);
                c.this.j(0);
                return;
            }
            c.this.t(0);
            c.this.j(1);
        }

        @Override // d.b.j0.r0.a.e
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

        @Override // d.b.j0.r0.a.f
        public void onAdClicked(String str) {
            c.this.i();
        }

        @Override // d.b.j0.r0.a.f
        public void onAdClose(String str) {
            if (c.this.f56517d != null) {
                c.this.f56517d.finish();
            }
        }

        @Override // d.b.j0.r0.a.f
        public void onAdError(String str) {
            c.this.t(0);
            c.this.k(1);
        }

        @Override // d.b.j0.r0.a.f
        public void onAdShow(String str) {
            c.this.f56520g = true;
        }
    }

    public c(@NonNull ImageViewerActivity imageViewerActivity, boolean z) {
        this.f56517d = imageViewerActivity;
        this.f56516c = imageViewerActivity.getPageContext();
        this.f56515b = z;
        this.f56518e = new RelativeLayout(this.f56517d);
        ViewGroup g2 = d.b.j0.r0.a.h().g(imageViewerActivity, "6051001643-679358748");
        this.f56519f = g2;
        if (g2 != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(l.k(this.f56517d), -2);
            layoutParams.addRule(14, -1);
            layoutParams.addRule(15, -1);
            this.f56518e.addView(this.f56519f, layoutParams);
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.ImagePagerAdapter.a
    public View a(ViewGroup viewGroup, int i) {
        if (this.f56516c != null && this.f56519f != null && this.f56515b && l(i) && n()) {
            if (this.f56518e.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.f56518e.getParent()).removeView(this.f56518e);
            }
            viewGroup.addView(this.f56518e);
            return this.f56518e;
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
        int i2 = this.f56514a;
        return i2 != 0 && i == i2;
    }

    public boolean m() {
        return this.f56515b && this.f56519f != null && this.f56521h;
    }

    public boolean n() {
        return this.f56521h;
    }

    public boolean o() {
        return this.f56520g;
    }

    public boolean p(int i, int i2, int i3) {
        return i == 1;
    }

    public void q() {
    }

    public void r() {
        d.b.j0.r0.a.h().c("6051001643-679358748");
    }

    public void s(int i, int i2, int i3, String str, String str2) {
        if (!this.f56515b || this.f56519f == null || this.i || this.f56521h || !p(i, i2, i3)) {
            return;
        }
        this.i = true;
        this.j = str;
        this.k = str2;
        StatisticItem.make(TbadkCoreStatisticKey.FUN_AD_REQUEST).param("obj_source", 6).param("tid", str).param("fid", str2).param("obj_type", "a008").eventStat();
        d.b.j0.r0.a.h().l(this.f56517d, "6051001643-679358748", new a(i3), d.b.j0.r0.a.a("pic", d.b.i0.b.d.D() ? "1" : "0"));
    }

    public void t(int i) {
        ImageViewerActivity imageViewerActivity = this.f56517d;
        if (imageViewerActivity != null) {
            imageViewerActivity.setAddSize(i);
        }
    }

    public void u(DragImageView.h hVar) {
    }

    public boolean v(int i) {
        if (this.f56516c == null || this.f56519f == null || !this.f56515b || this.f56520g || !l(i) || !n()) {
            return false;
        }
        d.b.j0.r0.a.h().n(this.f56516c.getPageActivity(), "6051001643-679358748", this.f56519f, this.l, d.b.j0.r0.a.a("pic", d.b.i0.b.d.D() ? "1" : "0"));
        SkinManager.setBackgroundColor(this.f56519f, R.color.CAM_X0101, 0);
        k(0);
        return true;
    }

    public void w(int i, int i2) {
        this.f56514a = i;
    }
}

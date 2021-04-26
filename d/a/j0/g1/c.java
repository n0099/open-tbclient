package d.a.j0.g1;

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
import d.a.c.e.p.l;
import d.a.j0.r0.a;
/* loaded from: classes4.dex */
public class c implements ImagePagerAdapter.a {

    /* renamed from: b  reason: collision with root package name */
    public boolean f54406b;

    /* renamed from: c  reason: collision with root package name */
    public TbPageContext f54407c;

    /* renamed from: d  reason: collision with root package name */
    public ImageViewerActivity f54408d;

    /* renamed from: e  reason: collision with root package name */
    public RelativeLayout f54409e;

    /* renamed from: f  reason: collision with root package name */
    public ViewGroup f54410f;
    public String j;
    public String k;

    /* renamed from: a  reason: collision with root package name */
    public int f54405a = 0;

    /* renamed from: g  reason: collision with root package name */
    public boolean f54411g = false;

    /* renamed from: h  reason: collision with root package name */
    public boolean f54412h = false;

    /* renamed from: i  reason: collision with root package name */
    public boolean f54413i = false;
    public final a.g l = new b();

    /* loaded from: classes4.dex */
    public class a implements a.e {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f54414a;

        public a(int i2) {
            this.f54414a = i2;
        }

        @Override // d.a.j0.r0.a.e
        public void a(String str, int i2) {
            c.this.f54413i = false;
            c.this.f54412h = true;
            if (d.a.j0.r0.a.h().k(str)) {
                c.this.t(1);
                c.this.v(this.f54414a);
                c.this.j(0);
                return;
            }
            c.this.t(0);
            c.this.j(1);
        }

        @Override // d.a.j0.r0.a.e
        public void onError(String str) {
            c.this.f54413i = false;
            c.this.t(0);
            c.this.j(1);
        }
    }

    /* loaded from: classes4.dex */
    public class b extends a.g {
        public b() {
        }

        @Override // d.a.j0.r0.a.f
        public void onAdClicked(String str) {
            c.this.i();
        }

        @Override // d.a.j0.r0.a.f
        public void onAdClose(String str) {
            if (c.this.f54408d != null) {
                c.this.f54408d.finish();
            }
        }

        @Override // d.a.j0.r0.a.f
        public void onAdError(String str) {
            c.this.t(0);
            c.this.k(1);
        }

        @Override // d.a.j0.r0.a.f
        public void onAdShow(String str) {
            c.this.f54411g = true;
        }
    }

    public c(@NonNull ImageViewerActivity imageViewerActivity, boolean z) {
        this.f54408d = imageViewerActivity;
        this.f54407c = imageViewerActivity.getPageContext();
        this.f54406b = z;
        this.f54409e = new RelativeLayout(this.f54408d);
        ViewGroup g2 = d.a.j0.r0.a.h().g(imageViewerActivity, "6051001643-679358748");
        this.f54410f = g2;
        if (g2 != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(l.k(this.f54408d), -2);
            layoutParams.addRule(14, -1);
            layoutParams.addRule(15, -1);
            this.f54409e.addView(this.f54410f, layoutParams);
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.ImagePagerAdapter.a
    public View a(ViewGroup viewGroup, int i2) {
        if (this.f54407c != null && this.f54410f != null && this.f54406b && l(i2) && n()) {
            if (this.f54409e.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.f54409e.getParent()).removeView(this.f54409e);
            }
            viewGroup.addView(this.f54409e);
            return this.f54409e;
        }
        return null;
    }

    public final void i() {
        StatisticItem.make(TbadkCoreStatisticKey.FUN_AD_CLICK).param("obj_source", 6).param("obj_type", "a008").eventStat();
    }

    public final void j(int i2) {
        StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.FUN_AD_REQUEST).param("obj_source", 6).param("obj_type", "a008").param("obj_locate", i2);
        if (i2 == 1) {
            param.param(TiebaStatic.Params.RESOURCE_ID, 0);
        }
        TiebaStatic.log(param);
    }

    public final void k(int i2) {
        StatisticItem.make(TbadkCoreStatisticKey.FUN_AD_SHOW).param("obj_source", 6).param("obj_type", "a008").param("tid", this.j).param("fid", this.k).param("obj_locate", i2).eventStat();
    }

    public final boolean l(int i2) {
        int i3 = this.f54405a;
        return i3 != 0 && i2 == i3;
    }

    public boolean m() {
        return this.f54406b && this.f54410f != null && this.f54412h;
    }

    public boolean n() {
        return this.f54412h;
    }

    public boolean o() {
        return this.f54411g;
    }

    public boolean p(int i2, int i3, int i4) {
        return i2 == 1;
    }

    public void q() {
    }

    public void r() {
        d.a.j0.r0.a.h().c("6051001643-679358748");
    }

    public void s(int i2, int i3, int i4, String str, String str2) {
        if (!this.f54406b || this.f54410f == null || this.f54413i || this.f54412h || !p(i2, i3, i4)) {
            return;
        }
        this.f54413i = true;
        this.j = str;
        this.k = str2;
        StatisticItem.make(TbadkCoreStatisticKey.FUN_AD_REQUEST).param("obj_source", 6).param("tid", str).param("fid", str2).param("obj_type", "a008").eventStat();
        d.a.j0.r0.a.h().l(this.f54408d, "6051001643-679358748", new a(i4), d.a.j0.r0.a.a("pic", d.a.i0.b.d.D() ? "1" : "0"));
    }

    public void t(int i2) {
        ImageViewerActivity imageViewerActivity = this.f54408d;
        if (imageViewerActivity != null) {
            imageViewerActivity.setAddSize(i2);
        }
    }

    public void u(DragImageView.h hVar) {
    }

    public boolean v(int i2) {
        if (this.f54407c == null || this.f54410f == null || !this.f54406b || this.f54411g || !l(i2) || !n()) {
            return false;
        }
        d.a.j0.r0.a.h().n(this.f54407c.getPageActivity(), "6051001643-679358748", this.f54410f, this.l, d.a.j0.r0.a.a("pic", d.a.i0.b.d.D() ? "1" : "0"));
        SkinManager.setBackgroundColor(this.f54410f, R.color.CAM_X0101, 0);
        k(0);
        return true;
    }

    public void w(int i2, int i3) {
        this.f54405a = i2;
    }
}

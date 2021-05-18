package d.a.k0.g1;

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
import d.a.k0.r0.a;
/* loaded from: classes4.dex */
public class c implements ImagePagerAdapter.a {

    /* renamed from: b  reason: collision with root package name */
    public boolean f55113b;

    /* renamed from: c  reason: collision with root package name */
    public TbPageContext f55114c;

    /* renamed from: d  reason: collision with root package name */
    public ImageViewerActivity f55115d;

    /* renamed from: e  reason: collision with root package name */
    public RelativeLayout f55116e;

    /* renamed from: f  reason: collision with root package name */
    public ViewGroup f55117f;
    public String j;
    public String k;

    /* renamed from: a  reason: collision with root package name */
    public int f55112a = 0;

    /* renamed from: g  reason: collision with root package name */
    public boolean f55118g = false;

    /* renamed from: h  reason: collision with root package name */
    public boolean f55119h = false;

    /* renamed from: i  reason: collision with root package name */
    public boolean f55120i = false;
    public final a.g l = new b();

    /* loaded from: classes4.dex */
    public class a implements a.e {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f55121a;

        public a(int i2) {
            this.f55121a = i2;
        }

        @Override // d.a.k0.r0.a.e
        public void a(String str, int i2) {
            c.this.f55120i = false;
            c.this.f55119h = true;
            if (d.a.k0.r0.a.h().k(str)) {
                c.this.t(1);
                c.this.v(this.f55121a);
                c.this.j(0);
                return;
            }
            c.this.t(0);
            c.this.j(1);
        }

        @Override // d.a.k0.r0.a.e
        public void onError(String str) {
            c.this.f55120i = false;
            c.this.t(0);
            c.this.j(1);
        }
    }

    /* loaded from: classes4.dex */
    public class b extends a.g {
        public b() {
        }

        @Override // d.a.k0.r0.a.f
        public void onAdClicked(String str) {
            c.this.i();
        }

        @Override // d.a.k0.r0.a.f
        public void onAdClose(String str) {
            if (c.this.f55115d != null) {
                c.this.f55115d.finish();
            }
        }

        @Override // d.a.k0.r0.a.f
        public void onAdError(String str) {
            c.this.t(0);
            c.this.k(1);
        }

        @Override // d.a.k0.r0.a.f
        public void onAdShow(String str) {
            c.this.f55118g = true;
        }
    }

    public c(@NonNull ImageViewerActivity imageViewerActivity, boolean z) {
        this.f55115d = imageViewerActivity;
        this.f55114c = imageViewerActivity.getPageContext();
        this.f55113b = z;
        this.f55116e = new RelativeLayout(this.f55115d);
        ViewGroup g2 = d.a.k0.r0.a.h().g(imageViewerActivity, "6051001643-679358748");
        this.f55117f = g2;
        if (g2 != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(l.k(this.f55115d), -2);
            layoutParams.addRule(14, -1);
            layoutParams.addRule(15, -1);
            this.f55116e.addView(this.f55117f, layoutParams);
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.ImagePagerAdapter.a
    public View a(ViewGroup viewGroup, int i2) {
        if (this.f55114c != null && this.f55117f != null && this.f55113b && l(i2) && n()) {
            if (this.f55116e.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.f55116e.getParent()).removeView(this.f55116e);
            }
            viewGroup.addView(this.f55116e);
            return this.f55116e;
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
        int i3 = this.f55112a;
        return i3 != 0 && i2 == i3;
    }

    public boolean m() {
        return this.f55113b && this.f55117f != null && this.f55119h;
    }

    public boolean n() {
        return this.f55119h;
    }

    public boolean o() {
        return this.f55118g;
    }

    public boolean p(int i2, int i3, int i4) {
        return i2 == 1;
    }

    public void q() {
    }

    public void r() {
        d.a.k0.r0.a.h().c("6051001643-679358748");
    }

    public void s(int i2, int i3, int i4, String str, String str2) {
        if (!this.f55113b || this.f55117f == null || this.f55120i || this.f55119h || !p(i2, i3, i4)) {
            return;
        }
        this.f55120i = true;
        this.j = str;
        this.k = str2;
        StatisticItem.make(TbadkCoreStatisticKey.FUN_AD_REQUEST).param("obj_source", 6).param("tid", str).param("fid", str2).param("obj_type", "a008").eventStat();
        d.a.k0.r0.a.h().l(this.f55115d, "6051001643-679358748", new a(i4), d.a.k0.r0.a.a("pic", d.a.j0.b.d.D() ? "1" : "0"));
    }

    public void t(int i2) {
        ImageViewerActivity imageViewerActivity = this.f55115d;
        if (imageViewerActivity != null) {
            imageViewerActivity.setAddSize(i2);
        }
    }

    public void u(DragImageView.h hVar) {
    }

    public boolean v(int i2) {
        if (this.f55114c == null || this.f55117f == null || !this.f55113b || this.f55118g || !l(i2) || !n()) {
            return false;
        }
        d.a.k0.r0.a.h().n(this.f55114c.getPageActivity(), "6051001643-679358748", this.f55117f, this.l, d.a.k0.r0.a.a("pic", d.a.j0.b.d.D() ? "1" : "0"));
        SkinManager.setBackgroundColor(this.f55117f, R.color.CAM_X0101, 0);
        k(0);
        return true;
    }

    public void w(int i2, int i3) {
        this.f55112a = i2;
    }
}

package d.a.n0.h1;

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
import com.baidu.tieba.funAd.http.FunAdRecordHttpMessage;
import com.baidu.tieba.image.ImageViewerActivity;
import d.a.c.e.p.l;
import d.a.n0.s0.a;
/* loaded from: classes4.dex */
public class c implements ImagePagerAdapter.a {

    /* renamed from: b  reason: collision with root package name */
    public boolean f55387b;

    /* renamed from: c  reason: collision with root package name */
    public TbPageContext f55388c;

    /* renamed from: d  reason: collision with root package name */
    public ImageViewerActivity f55389d;

    /* renamed from: e  reason: collision with root package name */
    public RelativeLayout f55390e;

    /* renamed from: f  reason: collision with root package name */
    public ViewGroup f55391f;
    public String j;
    public String k;

    /* renamed from: a  reason: collision with root package name */
    public int f55386a = 0;

    /* renamed from: g  reason: collision with root package name */
    public boolean f55392g = false;

    /* renamed from: h  reason: collision with root package name */
    public boolean f55393h = false;

    /* renamed from: i  reason: collision with root package name */
    public boolean f55394i = false;
    public final a.g l = new b();

    /* loaded from: classes4.dex */
    public class a implements a.e {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ int f55395a;

        public a(int i2) {
            this.f55395a = i2;
        }

        @Override // d.a.n0.s0.a.e
        public void a(String str, int i2) {
            c.this.f55394i = false;
            c.this.f55393h = true;
            if (d.a.n0.s0.a.h().k(str)) {
                c.this.t(1);
                c.this.v(this.f55395a);
                c.this.j(0);
                return;
            }
            c.this.t(0);
            c.this.j(1);
        }

        @Override // d.a.n0.s0.a.e
        public void onError(String str) {
            c.this.f55394i = false;
            c.this.t(0);
            c.this.j(1);
        }
    }

    /* loaded from: classes4.dex */
    public class b extends a.g {
        public b() {
        }

        @Override // d.a.n0.s0.a.f
        public void onAdClicked(String str) {
            c.this.i();
        }

        @Override // d.a.n0.s0.a.f
        public void onAdClose(String str) {
            if (c.this.f55389d != null) {
                c.this.f55389d.finish();
            }
        }

        @Override // d.a.n0.s0.a.f
        public void onAdError(String str) {
            c.this.t(0);
            c.this.k(1);
        }

        @Override // d.a.n0.s0.a.f
        public void onAdShow(String str) {
            c.this.f55392g = true;
        }
    }

    public c(@NonNull ImageViewerActivity imageViewerActivity, boolean z) {
        this.f55389d = imageViewerActivity;
        this.f55388c = imageViewerActivity.getPageContext();
        this.f55387b = z;
        this.f55390e = new RelativeLayout(this.f55389d);
        ViewGroup g2 = d.a.n0.s0.a.h().g(imageViewerActivity, "6051001643-679358748");
        this.f55391f = g2;
        if (g2 != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(l.k(this.f55389d), -2);
            layoutParams.addRule(14, -1);
            layoutParams.addRule(15, -1);
            this.f55390e.addView(this.f55391f, layoutParams);
        }
    }

    @Override // com.baidu.tbadk.coreExtra.view.ImagePagerAdapter.a
    public View a(ViewGroup viewGroup, int i2) {
        if (this.f55388c != null && this.f55391f != null && this.f55387b && l(i2) && n()) {
            if (this.f55390e.getParent() instanceof ViewGroup) {
                ((ViewGroup) this.f55390e.getParent()).removeView(this.f55390e);
            }
            viewGroup.addView(this.f55390e);
            return this.f55390e;
        }
        return null;
    }

    public final void i() {
        StatisticItem.make(TbadkCoreStatisticKey.FUN_AD_CLICK).param("obj_source", 6).param("obj_type", "a008").eventStat();
        FunAdRecordHttpMessage.uploadShowOrClickRecord(FunAdRecordHttpMessage.CLICK_AD_RECORD, "a008", "0", this.j, this.k, null, null, null, null, null);
    }

    public final void j(int i2) {
        StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.FUN_AD_REQUEST).param("obj_source", 6).param("obj_type", "a008").param("obj_locate", i2);
        if (i2 == 1) {
            param.param(TiebaStatic.Params.RESOURCE_ID, 0);
            FunAdRecordHttpMessage.uploadRequestRecord("a008", String.valueOf(i2), this.j, this.k, "0");
        } else {
            FunAdRecordHttpMessage.uploadRequestRecord("a008", String.valueOf(i2), this.j, this.k, null);
        }
        TiebaStatic.log(param);
    }

    public final void k(int i2) {
        StatisticItem.make(TbadkCoreStatisticKey.FUN_AD_SHOW).param("obj_source", 6).param("obj_type", "a008").param("tid", this.j).param("fid", this.k).param("obj_locate", i2).eventStat();
        FunAdRecordHttpMessage.uploadShowOrClickRecord(FunAdRecordHttpMessage.SHOW_AD_RECORD, "a008", String.valueOf(i2), this.j, this.k, null, null, null, null, null);
    }

    public final boolean l(int i2) {
        int i3 = this.f55386a;
        return i3 != 0 && i2 == i3;
    }

    public boolean m() {
        return this.f55387b && this.f55391f != null && this.f55393h;
    }

    public boolean n() {
        return this.f55393h;
    }

    public boolean o() {
        return this.f55392g;
    }

    public boolean p(int i2, int i3, int i4) {
        return i2 == 1;
    }

    public void q() {
    }

    public void r() {
        d.a.n0.s0.a.h().c("6051001643-679358748");
    }

    public void s(int i2, int i3, int i4, String str, String str2) {
        if (!this.f55387b || this.f55391f == null || this.f55394i || this.f55393h || !p(i2, i3, i4)) {
            return;
        }
        this.f55394i = true;
        this.j = str;
        this.k = str2;
        FunAdRecordHttpMessage.uploadRequestRecord("a008", null, str, str2, null);
        StatisticItem.make(TbadkCoreStatisticKey.FUN_AD_REQUEST).param("obj_source", 6).param("tid", str).param("fid", str2).param("obj_type", "a008").eventStat();
        d.a.n0.s0.a.h().l(this.f55389d, "6051001643-679358748", new a(i4), d.a.n0.s0.a.a("pic", d.a.m0.b.d.D() ? "1" : "0"));
    }

    public void t(int i2) {
        ImageViewerActivity imageViewerActivity = this.f55389d;
        if (imageViewerActivity != null) {
            imageViewerActivity.setAddSize(i2);
        }
    }

    public void u(DragImageView.h hVar) {
    }

    public boolean v(int i2) {
        if (this.f55388c == null || this.f55391f == null || !this.f55387b || this.f55392g || !l(i2) || !n()) {
            return false;
        }
        d.a.n0.s0.a.h().n(this.f55388c.getPageActivity(), "6051001643-679358748", this.f55391f, this.l, d.a.n0.s0.a.a("pic", d.a.m0.b.d.D() ? "1" : "0"));
        SkinManager.setBackgroundColor(this.f55391f, R.color.CAM_X0101, 0);
        k(0);
        return true;
    }

    public void w(int i2, int i3) {
        this.f55386a = i2;
    }
}

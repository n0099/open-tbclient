package d.a.i0.r.s;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.util.MaskView;
import com.baidu.tieba.R;
import d.a.i0.r.s.l;
/* loaded from: classes3.dex */
public class h implements k {
    public static final int q = d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds251);
    public static final int r = d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds231);

    /* renamed from: a  reason: collision with root package name */
    public int f49388a;

    /* renamed from: b  reason: collision with root package name */
    public l f49389b;

    /* renamed from: c  reason: collision with root package name */
    public View f49390c;

    /* renamed from: d  reason: collision with root package name */
    public EMTextView f49391d;

    /* renamed from: e  reason: collision with root package name */
    public View f49392e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f49393f;

    /* renamed from: g  reason: collision with root package name */
    public Drawable f49394g;

    /* renamed from: h  reason: collision with root package name */
    public String f49395h;

    /* renamed from: i  reason: collision with root package name */
    public int f49396i;
    public int j;
    public int k;
    public l.d l;
    public boolean m;
    public boolean n;
    public boolean o;
    public final View.OnClickListener p;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (h.this.l != null) {
                h.this.l.onClick();
            }
            if (h.this.f49389b == null || h.this.f49389b.e() == null) {
                return;
            }
            h.this.f49389b.e().onItemClick(h.this.f49389b, h.this.f49388a, h.this.f49391d);
        }
    }

    public h(l lVar) {
        this(null, lVar);
    }

    @Override // d.a.i0.r.s.k
    public void a() {
        SkinManager.setBackgroundResource(this.f49391d, this.j);
        SkinManager.setViewTextColorSelector(this.f49391d, this.f49396i);
        SkinManager.setBackgroundColor(this.f49392e, R.color.CAM_X0204);
        MaskView.b(this.f49391d, this.n);
    }

    public void e() {
        h();
    }

    public int f() {
        return this.f49388a;
    }

    public String g() {
        return this.f49395h;
    }

    @Override // d.a.i0.r.s.k
    public View getView() {
        return this.f49390c;
    }

    public final void h() {
        l lVar = this.f49389b;
        if (lVar == null || lVar.d() == null) {
            return;
        }
        View inflate = LayoutInflater.from(this.f49389b.d()).inflate(R.layout.popup_dialog_view_horizal_item, this.f49389b.g(), false);
        this.f49390c = inflate;
        inflate.getLayoutParams().width = this.o ? r : q;
        Object tag = this.f49391d.getTag();
        EMTextView eMTextView = (EMTextView) this.f49390c.findViewById(R.id.item_view);
        this.f49391d = eMTextView;
        eMTextView.setText(this.f49395h);
        this.f49391d.setGravity(this.k);
        this.f49391d.setTag(tag);
        View findViewById = this.f49390c.findViewById(R.id.divider_line);
        this.f49392e = findViewById;
        findViewById.setVisibility(8);
        ImageView imageView = (ImageView) this.f49390c.findViewById(R.id.item_image);
        this.f49393f = imageView;
        imageView.setImageDrawable(this.f49394g);
        a();
        this.f49390c.setOnClickListener(this.p);
    }

    public final void i() {
        EMTextView eMTextView = this.f49391d;
        if (eMTextView != null) {
            eMTextView.setOnClickListener(this.p);
        }
    }

    public final void j() {
        l lVar = this.f49389b;
        if (lVar == null || lVar.d() == null) {
            return;
        }
        View inflate = LayoutInflater.from(this.f49389b.d()).inflate(R.layout.popup_dialog_view_item, this.f49389b.g(), false);
        this.f49390c = inflate;
        EMTextView eMTextView = (EMTextView) inflate.findViewById(R.id.item_view);
        this.f49391d = eMTextView;
        eMTextView.setText(this.f49395h);
        this.f49391d.setGravity(this.k);
        View findViewById = this.f49390c.findViewById(R.id.divider_line);
        this.f49392e = findViewById;
        if (this.m) {
            findViewById.setVisibility(0);
        } else {
            findViewById.setVisibility(8);
        }
        a();
    }

    public void k(boolean z) {
        this.o = z;
    }

    public void l(Drawable drawable) {
        this.f49394g = drawable;
    }

    public void m(l.d dVar) {
        this.l = dVar;
        i();
    }

    public void n(String str) {
        this.f49395h = str;
        this.f49391d.setText(str);
    }

    public void o(int i2) {
        this.f49396i = i2;
        SkinManager.setViewTextColor(this.f49391d, i2);
    }

    public void p(boolean z) {
        this.n = z;
        MaskView.b(this.f49391d, z);
    }

    public h(String str, l lVar) {
        this.f49396i = R.color.CAM_X0105;
        this.j = R.color.CAM_X0204;
        this.k = 17;
        this.m = false;
        this.n = false;
        this.o = false;
        this.p = new a();
        this.f49395h = str;
        this.f49389b = lVar;
        this.f49388a = hashCode();
        j();
        i();
    }

    public h(int i2, String str, l lVar) {
        this.f49396i = R.color.CAM_X0105;
        this.j = R.color.CAM_X0204;
        this.k = 17;
        this.m = false;
        this.n = false;
        this.o = false;
        this.p = new a();
        this.f49388a = i2;
        this.f49395h = str;
        this.f49389b = lVar;
        j();
        i();
    }
}

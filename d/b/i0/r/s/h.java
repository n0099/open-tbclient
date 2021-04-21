package d.b.i0.r.s;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.util.MaskView;
import com.baidu.tieba.R;
import d.b.i0.r.s.l;
/* loaded from: classes3.dex */
public class h implements k {
    public static final int q = d.b.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds251);
    public static final int r = d.b.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds231);

    /* renamed from: a  reason: collision with root package name */
    public int f51745a;

    /* renamed from: b  reason: collision with root package name */
    public l f51746b;

    /* renamed from: c  reason: collision with root package name */
    public View f51747c;

    /* renamed from: d  reason: collision with root package name */
    public EMTextView f51748d;

    /* renamed from: e  reason: collision with root package name */
    public View f51749e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f51750f;

    /* renamed from: g  reason: collision with root package name */
    public Drawable f51751g;

    /* renamed from: h  reason: collision with root package name */
    public String f51752h;
    public int i;
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
            if (h.this.f51746b == null || h.this.f51746b.e() == null) {
                return;
            }
            h.this.f51746b.e().onItemClick(h.this.f51746b, h.this.f51745a, h.this.f51748d);
        }
    }

    public h(l lVar) {
        this(null, lVar);
    }

    @Override // d.b.i0.r.s.k
    public void a() {
        SkinManager.setBackgroundResource(this.f51748d, this.j);
        SkinManager.setViewTextColorSelector(this.f51748d, this.i);
        SkinManager.setBackgroundColor(this.f51749e, R.color.CAM_X0204);
        MaskView.b(this.f51748d, this.n);
    }

    public void e() {
        h();
    }

    public int f() {
        return this.f51745a;
    }

    public String g() {
        return this.f51752h;
    }

    @Override // d.b.i0.r.s.k
    public View getView() {
        return this.f51747c;
    }

    public final void h() {
        l lVar = this.f51746b;
        if (lVar == null || lVar.d() == null) {
            return;
        }
        View inflate = LayoutInflater.from(this.f51746b.d()).inflate(R.layout.popup_dialog_view_horizal_item, this.f51746b.g(), false);
        this.f51747c = inflate;
        inflate.getLayoutParams().width = this.o ? r : q;
        Object tag = this.f51748d.getTag();
        EMTextView eMTextView = (EMTextView) this.f51747c.findViewById(R.id.item_view);
        this.f51748d = eMTextView;
        eMTextView.setText(this.f51752h);
        this.f51748d.setGravity(this.k);
        this.f51748d.setTag(tag);
        View findViewById = this.f51747c.findViewById(R.id.divider_line);
        this.f51749e = findViewById;
        findViewById.setVisibility(8);
        ImageView imageView = (ImageView) this.f51747c.findViewById(R.id.item_image);
        this.f51750f = imageView;
        imageView.setImageDrawable(this.f51751g);
        a();
        this.f51747c.setOnClickListener(this.p);
    }

    public final void i() {
        EMTextView eMTextView = this.f51748d;
        if (eMTextView != null) {
            eMTextView.setOnClickListener(this.p);
        }
    }

    public final void j() {
        l lVar = this.f51746b;
        if (lVar == null || lVar.d() == null) {
            return;
        }
        View inflate = LayoutInflater.from(this.f51746b.d()).inflate(R.layout.popup_dialog_view_item, this.f51746b.g(), false);
        this.f51747c = inflate;
        EMTextView eMTextView = (EMTextView) inflate.findViewById(R.id.item_view);
        this.f51748d = eMTextView;
        eMTextView.setText(this.f51752h);
        this.f51748d.setGravity(this.k);
        View findViewById = this.f51747c.findViewById(R.id.divider_line);
        this.f51749e = findViewById;
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
        this.f51751g = drawable;
    }

    public void m(l.d dVar) {
        this.l = dVar;
        i();
    }

    public void n(String str) {
        this.f51752h = str;
        this.f51748d.setText(str);
    }

    public void o(int i) {
        this.i = i;
        SkinManager.setViewTextColor(this.f51748d, i);
    }

    public void p(boolean z) {
        this.n = z;
        MaskView.b(this.f51748d, z);
    }

    public h(String str, l lVar) {
        this.i = R.color.CAM_X0105;
        this.j = R.color.CAM_X0204;
        this.k = 17;
        this.m = false;
        this.n = false;
        this.o = false;
        this.p = new a();
        this.f51752h = str;
        this.f51746b = lVar;
        this.f51745a = hashCode();
        j();
        i();
    }

    public h(int i, String str, l lVar) {
        this.i = R.color.CAM_X0105;
        this.j = R.color.CAM_X0204;
        this.k = 17;
        this.m = false;
        this.n = false;
        this.o = false;
        this.p = new a();
        this.f51745a = i;
        this.f51752h = str;
        this.f51746b = lVar;
        j();
        i();
    }
}

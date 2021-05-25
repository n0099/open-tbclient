package d.a.m0.r.s;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.util.MaskView;
import com.baidu.tieba.R;
import d.a.m0.r.s.l;
/* loaded from: classes3.dex */
public class h implements k {
    public static final int q = d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds251);
    public static final int r = d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds231);

    /* renamed from: a  reason: collision with root package name */
    public int f50251a;

    /* renamed from: b  reason: collision with root package name */
    public l f50252b;

    /* renamed from: c  reason: collision with root package name */
    public View f50253c;

    /* renamed from: d  reason: collision with root package name */
    public EMTextView f50254d;

    /* renamed from: e  reason: collision with root package name */
    public View f50255e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f50256f;

    /* renamed from: g  reason: collision with root package name */
    public Drawable f50257g;

    /* renamed from: h  reason: collision with root package name */
    public String f50258h;

    /* renamed from: i  reason: collision with root package name */
    public int f50259i;
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
            if (h.this.f50252b == null || h.this.f50252b.e() == null) {
                return;
            }
            h.this.f50252b.e().onItemClick(h.this.f50252b, h.this.f50251a, h.this.f50254d);
        }
    }

    public h(l lVar) {
        this(null, lVar);
    }

    @Override // d.a.m0.r.s.k
    public void a() {
        SkinManager.setBackgroundResource(this.f50254d, this.j);
        SkinManager.setViewTextColorSelector(this.f50254d, this.f50259i);
        SkinManager.setBackgroundColor(this.f50255e, R.color.CAM_X0204);
        MaskView.b(this.f50254d, this.n);
    }

    public void e() {
        h();
    }

    public int f() {
        return this.f50251a;
    }

    public String g() {
        return this.f50258h;
    }

    @Override // d.a.m0.r.s.k
    public View getView() {
        return this.f50253c;
    }

    public final void h() {
        l lVar = this.f50252b;
        if (lVar == null || lVar.d() == null) {
            return;
        }
        View inflate = LayoutInflater.from(this.f50252b.d()).inflate(R.layout.popup_dialog_view_horizal_item, this.f50252b.g(), false);
        this.f50253c = inflate;
        inflate.getLayoutParams().width = this.o ? r : q;
        Object tag = this.f50254d.getTag();
        EMTextView eMTextView = (EMTextView) this.f50253c.findViewById(R.id.item_view);
        this.f50254d = eMTextView;
        eMTextView.setText(this.f50258h);
        this.f50254d.setGravity(this.k);
        this.f50254d.setTag(tag);
        View findViewById = this.f50253c.findViewById(R.id.divider_line);
        this.f50255e = findViewById;
        findViewById.setVisibility(8);
        ImageView imageView = (ImageView) this.f50253c.findViewById(R.id.item_image);
        this.f50256f = imageView;
        imageView.setImageDrawable(this.f50257g);
        a();
        this.f50253c.setOnClickListener(this.p);
    }

    public final void i() {
        EMTextView eMTextView = this.f50254d;
        if (eMTextView != null) {
            eMTextView.setOnClickListener(this.p);
        }
    }

    public final void j() {
        l lVar = this.f50252b;
        if (lVar == null || lVar.d() == null) {
            return;
        }
        View inflate = LayoutInflater.from(this.f50252b.d()).inflate(R.layout.popup_dialog_view_item, this.f50252b.g(), false);
        this.f50253c = inflate;
        EMTextView eMTextView = (EMTextView) inflate.findViewById(R.id.item_view);
        this.f50254d = eMTextView;
        eMTextView.setText(this.f50258h);
        this.f50254d.setGravity(this.k);
        View findViewById = this.f50253c.findViewById(R.id.divider_line);
        this.f50255e = findViewById;
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
        this.f50257g = drawable;
    }

    public void m(l.d dVar) {
        this.l = dVar;
        i();
    }

    public void n(String str) {
        this.f50258h = str;
        this.f50254d.setText(str);
    }

    public void o(int i2) {
        this.f50259i = i2;
        SkinManager.setViewTextColor(this.f50254d, i2);
    }

    public void p(boolean z) {
        this.n = z;
        MaskView.b(this.f50254d, z);
    }

    public h(String str, l lVar) {
        this.f50259i = R.color.CAM_X0105;
        this.j = R.color.CAM_X0204;
        this.k = 17;
        this.m = false;
        this.n = false;
        this.o = false;
        this.p = new a();
        this.f50258h = str;
        this.f50252b = lVar;
        this.f50251a = hashCode();
        j();
        i();
    }

    public h(int i2, String str, l lVar) {
        this.f50259i = R.color.CAM_X0105;
        this.j = R.color.CAM_X0204;
        this.k = 17;
        this.m = false;
        this.n = false;
        this.o = false;
        this.p = new a();
        this.f50251a = i2;
        this.f50258h = str;
        this.f50252b = lVar;
        j();
        i();
    }
}

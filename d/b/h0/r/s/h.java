package d.b.h0.r.s;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.util.MaskView;
import com.baidu.tieba.R;
import d.b.h0.r.s.l;
/* loaded from: classes3.dex */
public class h implements k {
    public static final int q = d.b.b.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds251);
    public static final int r = d.b.b.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds231);

    /* renamed from: a  reason: collision with root package name */
    public int f51001a;

    /* renamed from: b  reason: collision with root package name */
    public l f51002b;

    /* renamed from: c  reason: collision with root package name */
    public View f51003c;

    /* renamed from: d  reason: collision with root package name */
    public EMTextView f51004d;

    /* renamed from: e  reason: collision with root package name */
    public View f51005e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f51006f;

    /* renamed from: g  reason: collision with root package name */
    public Drawable f51007g;

    /* renamed from: h  reason: collision with root package name */
    public String f51008h;
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
            if (h.this.f51002b == null || h.this.f51002b.e() == null) {
                return;
            }
            h.this.f51002b.e().onItemClick(h.this.f51002b, h.this.f51001a, h.this.f51004d);
        }
    }

    public h(l lVar) {
        this(null, lVar);
    }

    @Override // d.b.h0.r.s.k
    public void a() {
        SkinManager.setBackgroundResource(this.f51004d, this.j);
        SkinManager.setViewTextColorSelector(this.f51004d, this.i);
        SkinManager.setBackgroundColor(this.f51005e, R.color.CAM_X0204);
        MaskView.b(this.f51004d, this.n);
    }

    public void e() {
        h();
    }

    public int f() {
        return this.f51001a;
    }

    public String g() {
        return this.f51008h;
    }

    @Override // d.b.h0.r.s.k
    public View getView() {
        return this.f51003c;
    }

    public final void h() {
        l lVar = this.f51002b;
        if (lVar == null || lVar.d() == null) {
            return;
        }
        View inflate = LayoutInflater.from(this.f51002b.d()).inflate(R.layout.popup_dialog_view_horizal_item, this.f51002b.g(), false);
        this.f51003c = inflate;
        inflate.getLayoutParams().width = this.o ? r : q;
        Object tag = this.f51004d.getTag();
        EMTextView eMTextView = (EMTextView) this.f51003c.findViewById(R.id.item_view);
        this.f51004d = eMTextView;
        eMTextView.setText(this.f51008h);
        this.f51004d.setGravity(this.k);
        this.f51004d.setTag(tag);
        View findViewById = this.f51003c.findViewById(R.id.divider_line);
        this.f51005e = findViewById;
        findViewById.setVisibility(8);
        ImageView imageView = (ImageView) this.f51003c.findViewById(R.id.item_image);
        this.f51006f = imageView;
        imageView.setImageDrawable(this.f51007g);
        a();
        this.f51003c.setOnClickListener(this.p);
    }

    public final void i() {
        EMTextView eMTextView = this.f51004d;
        if (eMTextView != null) {
            eMTextView.setOnClickListener(this.p);
        }
    }

    public final void j() {
        l lVar = this.f51002b;
        if (lVar == null || lVar.d() == null) {
            return;
        }
        View inflate = LayoutInflater.from(this.f51002b.d()).inflate(R.layout.popup_dialog_view_item, this.f51002b.g(), false);
        this.f51003c = inflate;
        EMTextView eMTextView = (EMTextView) inflate.findViewById(R.id.item_view);
        this.f51004d = eMTextView;
        eMTextView.setText(this.f51008h);
        this.f51004d.setGravity(this.k);
        View findViewById = this.f51003c.findViewById(R.id.divider_line);
        this.f51005e = findViewById;
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
        this.f51007g = drawable;
    }

    public void m(l.d dVar) {
        this.l = dVar;
        i();
    }

    public void n(String str) {
        this.f51008h = str;
        this.f51004d.setText(str);
    }

    public void o(int i) {
        this.i = i;
        SkinManager.setViewTextColor(this.f51004d, i);
    }

    public void p(boolean z) {
        this.n = z;
        MaskView.b(this.f51004d, z);
    }

    public h(String str, l lVar) {
        this.i = R.color.CAM_X0105;
        this.j = R.color.CAM_X0204;
        this.k = 17;
        this.m = false;
        this.n = false;
        this.o = false;
        this.p = new a();
        this.f51008h = str;
        this.f51002b = lVar;
        this.f51001a = hashCode();
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
        this.f51001a = i;
        this.f51008h = str;
        this.f51002b = lVar;
        j();
        i();
    }
}

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
    public static final int q = d.b.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds251);
    public static final int r = d.b.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds231);

    /* renamed from: a  reason: collision with root package name */
    public int f51409a;

    /* renamed from: b  reason: collision with root package name */
    public l f51410b;

    /* renamed from: c  reason: collision with root package name */
    public View f51411c;

    /* renamed from: d  reason: collision with root package name */
    public EMTextView f51412d;

    /* renamed from: e  reason: collision with root package name */
    public View f51413e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f51414f;

    /* renamed from: g  reason: collision with root package name */
    public Drawable f51415g;

    /* renamed from: h  reason: collision with root package name */
    public String f51416h;
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
            if (h.this.f51410b == null || h.this.f51410b.e() == null) {
                return;
            }
            h.this.f51410b.e().onItemClick(h.this.f51410b, h.this.f51409a, h.this.f51412d);
        }
    }

    public h(l lVar) {
        this(null, lVar);
    }

    @Override // d.b.h0.r.s.k
    public void a() {
        SkinManager.setBackgroundResource(this.f51412d, this.j);
        SkinManager.setViewTextColorSelector(this.f51412d, this.i);
        SkinManager.setBackgroundColor(this.f51413e, R.color.CAM_X0204);
        MaskView.b(this.f51412d, this.n);
    }

    public void e() {
        h();
    }

    public int f() {
        return this.f51409a;
    }

    public String g() {
        return this.f51416h;
    }

    @Override // d.b.h0.r.s.k
    public View getView() {
        return this.f51411c;
    }

    public final void h() {
        l lVar = this.f51410b;
        if (lVar == null || lVar.d() == null) {
            return;
        }
        View inflate = LayoutInflater.from(this.f51410b.d()).inflate(R.layout.popup_dialog_view_horizal_item, this.f51410b.g(), false);
        this.f51411c = inflate;
        inflate.getLayoutParams().width = this.o ? r : q;
        Object tag = this.f51412d.getTag();
        EMTextView eMTextView = (EMTextView) this.f51411c.findViewById(R.id.item_view);
        this.f51412d = eMTextView;
        eMTextView.setText(this.f51416h);
        this.f51412d.setGravity(this.k);
        this.f51412d.setTag(tag);
        View findViewById = this.f51411c.findViewById(R.id.divider_line);
        this.f51413e = findViewById;
        findViewById.setVisibility(8);
        ImageView imageView = (ImageView) this.f51411c.findViewById(R.id.item_image);
        this.f51414f = imageView;
        imageView.setImageDrawable(this.f51415g);
        a();
        this.f51411c.setOnClickListener(this.p);
    }

    public final void i() {
        EMTextView eMTextView = this.f51412d;
        if (eMTextView != null) {
            eMTextView.setOnClickListener(this.p);
        }
    }

    public final void j() {
        l lVar = this.f51410b;
        if (lVar == null || lVar.d() == null) {
            return;
        }
        View inflate = LayoutInflater.from(this.f51410b.d()).inflate(R.layout.popup_dialog_view_item, this.f51410b.g(), false);
        this.f51411c = inflate;
        EMTextView eMTextView = (EMTextView) inflate.findViewById(R.id.item_view);
        this.f51412d = eMTextView;
        eMTextView.setText(this.f51416h);
        this.f51412d.setGravity(this.k);
        View findViewById = this.f51411c.findViewById(R.id.divider_line);
        this.f51413e = findViewById;
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
        this.f51415g = drawable;
    }

    public void m(l.d dVar) {
        this.l = dVar;
        i();
    }

    public void n(String str) {
        this.f51416h = str;
        this.f51412d.setText(str);
    }

    public void o(int i) {
        this.i = i;
        SkinManager.setViewTextColor(this.f51412d, i);
    }

    public void p(boolean z) {
        this.n = z;
        MaskView.b(this.f51412d, z);
    }

    public h(String str, l lVar) {
        this.i = R.color.CAM_X0105;
        this.j = R.color.CAM_X0204;
        this.k = 17;
        this.m = false;
        this.n = false;
        this.o = false;
        this.p = new a();
        this.f51416h = str;
        this.f51410b = lVar;
        this.f51409a = hashCode();
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
        this.f51409a = i;
        this.f51416h = str;
        this.f51410b = lVar;
        j();
        i();
    }
}

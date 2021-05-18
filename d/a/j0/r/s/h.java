package d.a.j0.r.s;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.util.MaskView;
import com.baidu.tieba.R;
import d.a.j0.r.s.l;
/* loaded from: classes3.dex */
public class h implements k {
    public static final int q = d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds251);
    public static final int r = d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds231);

    /* renamed from: a  reason: collision with root package name */
    public int f50207a;

    /* renamed from: b  reason: collision with root package name */
    public l f50208b;

    /* renamed from: c  reason: collision with root package name */
    public View f50209c;

    /* renamed from: d  reason: collision with root package name */
    public EMTextView f50210d;

    /* renamed from: e  reason: collision with root package name */
    public View f50211e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f50212f;

    /* renamed from: g  reason: collision with root package name */
    public Drawable f50213g;

    /* renamed from: h  reason: collision with root package name */
    public String f50214h;

    /* renamed from: i  reason: collision with root package name */
    public int f50215i;
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
            if (h.this.f50208b == null || h.this.f50208b.e() == null) {
                return;
            }
            h.this.f50208b.e().onItemClick(h.this.f50208b, h.this.f50207a, h.this.f50210d);
        }
    }

    public h(l lVar) {
        this(null, lVar);
    }

    @Override // d.a.j0.r.s.k
    public void a() {
        SkinManager.setBackgroundResource(this.f50210d, this.j);
        SkinManager.setViewTextColorSelector(this.f50210d, this.f50215i);
        SkinManager.setBackgroundColor(this.f50211e, R.color.CAM_X0204);
        MaskView.b(this.f50210d, this.n);
    }

    public void e() {
        h();
    }

    public int f() {
        return this.f50207a;
    }

    public String g() {
        return this.f50214h;
    }

    @Override // d.a.j0.r.s.k
    public View getView() {
        return this.f50209c;
    }

    public final void h() {
        l lVar = this.f50208b;
        if (lVar == null || lVar.d() == null) {
            return;
        }
        View inflate = LayoutInflater.from(this.f50208b.d()).inflate(R.layout.popup_dialog_view_horizal_item, this.f50208b.g(), false);
        this.f50209c = inflate;
        inflate.getLayoutParams().width = this.o ? r : q;
        Object tag = this.f50210d.getTag();
        EMTextView eMTextView = (EMTextView) this.f50209c.findViewById(R.id.item_view);
        this.f50210d = eMTextView;
        eMTextView.setText(this.f50214h);
        this.f50210d.setGravity(this.k);
        this.f50210d.setTag(tag);
        View findViewById = this.f50209c.findViewById(R.id.divider_line);
        this.f50211e = findViewById;
        findViewById.setVisibility(8);
        ImageView imageView = (ImageView) this.f50209c.findViewById(R.id.item_image);
        this.f50212f = imageView;
        imageView.setImageDrawable(this.f50213g);
        a();
        this.f50209c.setOnClickListener(this.p);
    }

    public final void i() {
        EMTextView eMTextView = this.f50210d;
        if (eMTextView != null) {
            eMTextView.setOnClickListener(this.p);
        }
    }

    public final void j() {
        l lVar = this.f50208b;
        if (lVar == null || lVar.d() == null) {
            return;
        }
        View inflate = LayoutInflater.from(this.f50208b.d()).inflate(R.layout.popup_dialog_view_item, this.f50208b.g(), false);
        this.f50209c = inflate;
        EMTextView eMTextView = (EMTextView) inflate.findViewById(R.id.item_view);
        this.f50210d = eMTextView;
        eMTextView.setText(this.f50214h);
        this.f50210d.setGravity(this.k);
        View findViewById = this.f50209c.findViewById(R.id.divider_line);
        this.f50211e = findViewById;
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
        this.f50213g = drawable;
    }

    public void m(l.d dVar) {
        this.l = dVar;
        i();
    }

    public void n(String str) {
        this.f50214h = str;
        this.f50210d.setText(str);
    }

    public void o(int i2) {
        this.f50215i = i2;
        SkinManager.setViewTextColor(this.f50210d, i2);
    }

    public void p(boolean z) {
        this.n = z;
        MaskView.b(this.f50210d, z);
    }

    public h(String str, l lVar) {
        this.f50215i = R.color.CAM_X0105;
        this.j = R.color.CAM_X0204;
        this.k = 17;
        this.m = false;
        this.n = false;
        this.o = false;
        this.p = new a();
        this.f50214h = str;
        this.f50208b = lVar;
        this.f50207a = hashCode();
        j();
        i();
    }

    public h(int i2, String str, l lVar) {
        this.f50215i = R.color.CAM_X0105;
        this.j = R.color.CAM_X0204;
        this.k = 17;
        this.m = false;
        this.n = false;
        this.o = false;
        this.p = new a();
        this.f50207a = i2;
        this.f50214h = str;
        this.f50208b = lVar;
        j();
        i();
    }
}

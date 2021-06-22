package d.a.n0.r.s;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.util.MaskView;
import com.baidu.tieba.R;
import d.a.n0.r.s.l;
/* loaded from: classes3.dex */
public class h implements k {
    public static final int q = d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds251);
    public static final int r = d.a.c.e.p.l.g(TbadkCoreApplication.getInst(), R.dimen.tbds231);

    /* renamed from: a  reason: collision with root package name */
    public int f54034a;

    /* renamed from: b  reason: collision with root package name */
    public l f54035b;

    /* renamed from: c  reason: collision with root package name */
    public View f54036c;

    /* renamed from: d  reason: collision with root package name */
    public EMTextView f54037d;

    /* renamed from: e  reason: collision with root package name */
    public View f54038e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f54039f;

    /* renamed from: g  reason: collision with root package name */
    public Drawable f54040g;

    /* renamed from: h  reason: collision with root package name */
    public String f54041h;

    /* renamed from: i  reason: collision with root package name */
    public int f54042i;
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
            if (h.this.f54035b == null || h.this.f54035b.e() == null) {
                return;
            }
            h.this.f54035b.e().onItemClick(h.this.f54035b, h.this.f54034a, h.this.f54037d);
        }
    }

    public h(l lVar) {
        this(null, lVar);
    }

    @Override // d.a.n0.r.s.k
    public void a() {
        SkinManager.setBackgroundResource(this.f54037d, this.j);
        SkinManager.setViewTextColorSelector(this.f54037d, this.f54042i);
        SkinManager.setBackgroundColor(this.f54038e, R.color.CAM_X0204);
        MaskView.b(this.f54037d, this.n);
    }

    public void e() {
        h();
    }

    public int f() {
        return this.f54034a;
    }

    public String g() {
        return this.f54041h;
    }

    @Override // d.a.n0.r.s.k
    public View getView() {
        return this.f54036c;
    }

    public final void h() {
        l lVar = this.f54035b;
        if (lVar == null || lVar.d() == null) {
            return;
        }
        View inflate = LayoutInflater.from(this.f54035b.d()).inflate(R.layout.popup_dialog_view_horizal_item, this.f54035b.g(), false);
        this.f54036c = inflate;
        inflate.getLayoutParams().width = this.o ? r : q;
        Object tag = this.f54037d.getTag();
        EMTextView eMTextView = (EMTextView) this.f54036c.findViewById(R.id.item_view);
        this.f54037d = eMTextView;
        eMTextView.setText(this.f54041h);
        this.f54037d.setGravity(this.k);
        this.f54037d.setTag(tag);
        View findViewById = this.f54036c.findViewById(R.id.divider_line);
        this.f54038e = findViewById;
        findViewById.setVisibility(8);
        ImageView imageView = (ImageView) this.f54036c.findViewById(R.id.item_image);
        this.f54039f = imageView;
        imageView.setImageDrawable(this.f54040g);
        a();
        this.f54036c.setOnClickListener(this.p);
    }

    public final void i() {
        EMTextView eMTextView = this.f54037d;
        if (eMTextView != null) {
            eMTextView.setOnClickListener(this.p);
        }
    }

    public final void j() {
        l lVar = this.f54035b;
        if (lVar == null || lVar.d() == null) {
            return;
        }
        View inflate = LayoutInflater.from(this.f54035b.d()).inflate(R.layout.popup_dialog_view_item, this.f54035b.g(), false);
        this.f54036c = inflate;
        EMTextView eMTextView = (EMTextView) inflate.findViewById(R.id.item_view);
        this.f54037d = eMTextView;
        eMTextView.setText(this.f54041h);
        this.f54037d.setGravity(this.k);
        View findViewById = this.f54036c.findViewById(R.id.divider_line);
        this.f54038e = findViewById;
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
        this.f54040g = drawable;
    }

    public void m(l.d dVar) {
        this.l = dVar;
        i();
    }

    public void n(String str) {
        this.f54041h = str;
        this.f54037d.setText(str);
    }

    public void o(int i2) {
        this.f54042i = i2;
        SkinManager.setViewTextColor(this.f54037d, i2);
    }

    public void p(boolean z) {
        this.n = z;
        MaskView.b(this.f54037d, z);
    }

    public h(String str, l lVar) {
        this.f54042i = R.color.CAM_X0105;
        this.j = R.color.CAM_X0204;
        this.k = 17;
        this.m = false;
        this.n = false;
        this.o = false;
        this.p = new a();
        this.f54041h = str;
        this.f54035b = lVar;
        this.f54034a = hashCode();
        j();
        i();
    }

    public h(int i2, String str, l lVar) {
        this.f54042i = R.color.CAM_X0105;
        this.j = R.color.CAM_X0204;
        this.k = 17;
        this.m = false;
        this.n = false;
        this.o = false;
        this.p = new a();
        this.f54034a = i2;
        this.f54041h = str;
        this.f54035b = lVar;
        j();
        i();
    }
}

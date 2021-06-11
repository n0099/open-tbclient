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
    public int f53927a;

    /* renamed from: b  reason: collision with root package name */
    public l f53928b;

    /* renamed from: c  reason: collision with root package name */
    public View f53929c;

    /* renamed from: d  reason: collision with root package name */
    public EMTextView f53930d;

    /* renamed from: e  reason: collision with root package name */
    public View f53931e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f53932f;

    /* renamed from: g  reason: collision with root package name */
    public Drawable f53933g;

    /* renamed from: h  reason: collision with root package name */
    public String f53934h;

    /* renamed from: i  reason: collision with root package name */
    public int f53935i;
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
            if (h.this.f53928b == null || h.this.f53928b.e() == null) {
                return;
            }
            h.this.f53928b.e().onItemClick(h.this.f53928b, h.this.f53927a, h.this.f53930d);
        }
    }

    public h(l lVar) {
        this(null, lVar);
    }

    @Override // d.a.m0.r.s.k
    public void a() {
        SkinManager.setBackgroundResource(this.f53930d, this.j);
        SkinManager.setViewTextColorSelector(this.f53930d, this.f53935i);
        SkinManager.setBackgroundColor(this.f53931e, R.color.CAM_X0204);
        MaskView.b(this.f53930d, this.n);
    }

    public void e() {
        h();
    }

    public int f() {
        return this.f53927a;
    }

    public String g() {
        return this.f53934h;
    }

    @Override // d.a.m0.r.s.k
    public View getView() {
        return this.f53929c;
    }

    public final void h() {
        l lVar = this.f53928b;
        if (lVar == null || lVar.d() == null) {
            return;
        }
        View inflate = LayoutInflater.from(this.f53928b.d()).inflate(R.layout.popup_dialog_view_horizal_item, this.f53928b.g(), false);
        this.f53929c = inflate;
        inflate.getLayoutParams().width = this.o ? r : q;
        Object tag = this.f53930d.getTag();
        EMTextView eMTextView = (EMTextView) this.f53929c.findViewById(R.id.item_view);
        this.f53930d = eMTextView;
        eMTextView.setText(this.f53934h);
        this.f53930d.setGravity(this.k);
        this.f53930d.setTag(tag);
        View findViewById = this.f53929c.findViewById(R.id.divider_line);
        this.f53931e = findViewById;
        findViewById.setVisibility(8);
        ImageView imageView = (ImageView) this.f53929c.findViewById(R.id.item_image);
        this.f53932f = imageView;
        imageView.setImageDrawable(this.f53933g);
        a();
        this.f53929c.setOnClickListener(this.p);
    }

    public final void i() {
        EMTextView eMTextView = this.f53930d;
        if (eMTextView != null) {
            eMTextView.setOnClickListener(this.p);
        }
    }

    public final void j() {
        l lVar = this.f53928b;
        if (lVar == null || lVar.d() == null) {
            return;
        }
        View inflate = LayoutInflater.from(this.f53928b.d()).inflate(R.layout.popup_dialog_view_item, this.f53928b.g(), false);
        this.f53929c = inflate;
        EMTextView eMTextView = (EMTextView) inflate.findViewById(R.id.item_view);
        this.f53930d = eMTextView;
        eMTextView.setText(this.f53934h);
        this.f53930d.setGravity(this.k);
        View findViewById = this.f53929c.findViewById(R.id.divider_line);
        this.f53931e = findViewById;
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
        this.f53933g = drawable;
    }

    public void m(l.d dVar) {
        this.l = dVar;
        i();
    }

    public void n(String str) {
        this.f53934h = str;
        this.f53930d.setText(str);
    }

    public void o(int i2) {
        this.f53935i = i2;
        SkinManager.setViewTextColor(this.f53930d, i2);
    }

    public void p(boolean z) {
        this.n = z;
        MaskView.b(this.f53930d, z);
    }

    public h(String str, l lVar) {
        this.f53935i = R.color.CAM_X0105;
        this.j = R.color.CAM_X0204;
        this.k = 17;
        this.m = false;
        this.n = false;
        this.o = false;
        this.p = new a();
        this.f53934h = str;
        this.f53928b = lVar;
        this.f53927a = hashCode();
        j();
        i();
    }

    public h(int i2, String str, l lVar) {
        this.f53935i = R.color.CAM_X0105;
        this.j = R.color.CAM_X0204;
        this.k = 17;
        this.m = false;
        this.n = false;
        this.o = false;
        this.p = new a();
        this.f53927a = i2;
        this.f53934h = str;
        this.f53928b = lVar;
        j();
        i();
    }
}

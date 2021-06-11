package d.a.n0.w3.t.c;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import d.a.c.a.f;
/* loaded from: classes5.dex */
public class b extends a {

    /* renamed from: g  reason: collision with root package name */
    public static int f66693g;

    /* renamed from: c  reason: collision with root package name */
    public TextView f66694c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f66695d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f66696e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f66697f;

    public b(f fVar) {
        super(fVar);
        f66693g = fVar.getResources().getDimensionPixelOffset(R.dimen.ds8);
    }

    @Override // d.a.n0.w3.t.c.a
    public void d() {
        View inflate = LayoutInflater.from(this.f66691a.getPageActivity()).inflate(R.layout.pic_rorate_view, (ViewGroup) null);
        this.f66692b = inflate;
        this.f66694c = (TextView) inflate.findViewById(R.id.rotate_left);
        this.f66695d = (TextView) this.f66692b.findViewById(R.id.rotate_right);
        this.f66696e = (TextView) this.f66692b.findViewById(R.id.rotate_left_right);
        this.f66697f = (TextView) this.f66692b.findViewById(R.id.rotate_up_down);
    }

    public View e() {
        return this.f66692b;
    }

    public void f() {
        SkinManager.setViewTextColor(this.f66694c, R.color.CAM_X0107);
        SkinManager.setViewTextColor(this.f66695d, R.color.CAM_X0107);
        SkinManager.setViewTextColor(this.f66696e, R.color.CAM_X0107);
        SkinManager.setViewTextColor(this.f66697f, R.color.CAM_X0107);
        this.f66694c.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SkinManager.getDrawable(R.drawable.filter_rotate_left), (Drawable) null, (Drawable) null);
        this.f66695d.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SkinManager.getDrawable(R.drawable.filter_rotate_right), (Drawable) null, (Drawable) null);
        this.f66697f.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SkinManager.getDrawable(R.drawable.filter_flip_up_down), (Drawable) null, (Drawable) null);
        this.f66696e.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SkinManager.getDrawable(R.drawable.filter_flip_left_right), (Drawable) null, (Drawable) null);
        this.f66694c.setCompoundDrawablePadding(f66693g);
        this.f66695d.setCompoundDrawablePadding(f66693g);
        this.f66697f.setCompoundDrawablePadding(f66693g);
        this.f66696e.setCompoundDrawablePadding(f66693g);
    }

    public void g(View.OnClickListener onClickListener) {
        this.f66694c.setTag(0);
        this.f66695d.setTag(1);
        this.f66696e.setTag(2);
        this.f66697f.setTag(3);
        this.f66694c.setOnClickListener(onClickListener);
        this.f66695d.setOnClickListener(onClickListener);
        this.f66696e.setOnClickListener(onClickListener);
        this.f66697f.setOnClickListener(onClickListener);
    }
}

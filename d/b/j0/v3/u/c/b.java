package d.b.j0.v3.u.c;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import d.b.c.a.f;
/* loaded from: classes5.dex */
public class b extends a {

    /* renamed from: g  reason: collision with root package name */
    public static int f63903g;

    /* renamed from: c  reason: collision with root package name */
    public TextView f63904c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f63905d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f63906e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f63907f;

    public b(f fVar) {
        super(fVar);
        f63903g = fVar.getResources().getDimensionPixelOffset(R.dimen.ds8);
    }

    @Override // d.b.j0.v3.u.c.a
    public void d() {
        View inflate = LayoutInflater.from(this.f63901a.getPageActivity()).inflate(R.layout.pic_rorate_view, (ViewGroup) null);
        this.f63902b = inflate;
        this.f63904c = (TextView) inflate.findViewById(R.id.rotate_left);
        this.f63905d = (TextView) this.f63902b.findViewById(R.id.rotate_right);
        this.f63906e = (TextView) this.f63902b.findViewById(R.id.rotate_left_right);
        this.f63907f = (TextView) this.f63902b.findViewById(R.id.rotate_up_down);
    }

    public View e() {
        return this.f63902b;
    }

    public void f() {
        SkinManager.setViewTextColor(this.f63904c, R.color.CAM_X0107);
        SkinManager.setViewTextColor(this.f63905d, R.color.CAM_X0107);
        SkinManager.setViewTextColor(this.f63906e, R.color.CAM_X0107);
        SkinManager.setViewTextColor(this.f63907f, R.color.CAM_X0107);
        this.f63904c.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SkinManager.getDrawable(R.drawable.filter_rotate_left), (Drawable) null, (Drawable) null);
        this.f63905d.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SkinManager.getDrawable(R.drawable.filter_rotate_right), (Drawable) null, (Drawable) null);
        this.f63907f.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SkinManager.getDrawable(R.drawable.filter_flip_up_down), (Drawable) null, (Drawable) null);
        this.f63906e.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SkinManager.getDrawable(R.drawable.filter_flip_left_right), (Drawable) null, (Drawable) null);
        this.f63904c.setCompoundDrawablePadding(f63903g);
        this.f63905d.setCompoundDrawablePadding(f63903g);
        this.f63907f.setCompoundDrawablePadding(f63903g);
        this.f63906e.setCompoundDrawablePadding(f63903g);
    }

    public void g(View.OnClickListener onClickListener) {
        this.f63904c.setTag(0);
        this.f63905d.setTag(1);
        this.f63906e.setTag(2);
        this.f63907f.setTag(3);
        this.f63904c.setOnClickListener(onClickListener);
        this.f63905d.setOnClickListener(onClickListener);
        this.f63906e.setOnClickListener(onClickListener);
        this.f63907f.setOnClickListener(onClickListener);
    }
}

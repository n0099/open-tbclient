package d.a.k0.v3.t.c;

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
    public static int f62869g;

    /* renamed from: c  reason: collision with root package name */
    public TextView f62870c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f62871d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f62872e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f62873f;

    public b(f fVar) {
        super(fVar);
        f62869g = fVar.getResources().getDimensionPixelOffset(R.dimen.ds8);
    }

    @Override // d.a.k0.v3.t.c.a
    public void d() {
        View inflate = LayoutInflater.from(this.f62867a.getPageActivity()).inflate(R.layout.pic_rorate_view, (ViewGroup) null);
        this.f62868b = inflate;
        this.f62870c = (TextView) inflate.findViewById(R.id.rotate_left);
        this.f62871d = (TextView) this.f62868b.findViewById(R.id.rotate_right);
        this.f62872e = (TextView) this.f62868b.findViewById(R.id.rotate_left_right);
        this.f62873f = (TextView) this.f62868b.findViewById(R.id.rotate_up_down);
    }

    public View e() {
        return this.f62868b;
    }

    public void f() {
        SkinManager.setViewTextColor(this.f62870c, R.color.CAM_X0107);
        SkinManager.setViewTextColor(this.f62871d, R.color.CAM_X0107);
        SkinManager.setViewTextColor(this.f62872e, R.color.CAM_X0107);
        SkinManager.setViewTextColor(this.f62873f, R.color.CAM_X0107);
        this.f62870c.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SkinManager.getDrawable(R.drawable.filter_rotate_left), (Drawable) null, (Drawable) null);
        this.f62871d.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SkinManager.getDrawable(R.drawable.filter_rotate_right), (Drawable) null, (Drawable) null);
        this.f62873f.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SkinManager.getDrawable(R.drawable.filter_flip_up_down), (Drawable) null, (Drawable) null);
        this.f62872e.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SkinManager.getDrawable(R.drawable.filter_flip_left_right), (Drawable) null, (Drawable) null);
        this.f62870c.setCompoundDrawablePadding(f62869g);
        this.f62871d.setCompoundDrawablePadding(f62869g);
        this.f62873f.setCompoundDrawablePadding(f62869g);
        this.f62872e.setCompoundDrawablePadding(f62869g);
    }

    public void g(View.OnClickListener onClickListener) {
        this.f62870c.setTag(0);
        this.f62871d.setTag(1);
        this.f62872e.setTag(2);
        this.f62873f.setTag(3);
        this.f62870c.setOnClickListener(onClickListener);
        this.f62871d.setOnClickListener(onClickListener);
        this.f62872e.setOnClickListener(onClickListener);
        this.f62873f.setOnClickListener(onClickListener);
    }
}

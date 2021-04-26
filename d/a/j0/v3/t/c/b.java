package d.a.j0.v3.t.c;

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
    public static int f62145g;

    /* renamed from: c  reason: collision with root package name */
    public TextView f62146c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f62147d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f62148e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f62149f;

    public b(f fVar) {
        super(fVar);
        f62145g = fVar.getResources().getDimensionPixelOffset(R.dimen.ds8);
    }

    @Override // d.a.j0.v3.t.c.a
    public void d() {
        View inflate = LayoutInflater.from(this.f62143a.getPageActivity()).inflate(R.layout.pic_rorate_view, (ViewGroup) null);
        this.f62144b = inflate;
        this.f62146c = (TextView) inflate.findViewById(R.id.rotate_left);
        this.f62147d = (TextView) this.f62144b.findViewById(R.id.rotate_right);
        this.f62148e = (TextView) this.f62144b.findViewById(R.id.rotate_left_right);
        this.f62149f = (TextView) this.f62144b.findViewById(R.id.rotate_up_down);
    }

    public View e() {
        return this.f62144b;
    }

    public void f() {
        SkinManager.setViewTextColor(this.f62146c, R.color.CAM_X0107);
        SkinManager.setViewTextColor(this.f62147d, R.color.CAM_X0107);
        SkinManager.setViewTextColor(this.f62148e, R.color.CAM_X0107);
        SkinManager.setViewTextColor(this.f62149f, R.color.CAM_X0107);
        this.f62146c.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SkinManager.getDrawable(R.drawable.filter_rotate_left), (Drawable) null, (Drawable) null);
        this.f62147d.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SkinManager.getDrawable(R.drawable.filter_rotate_right), (Drawable) null, (Drawable) null);
        this.f62149f.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SkinManager.getDrawable(R.drawable.filter_flip_up_down), (Drawable) null, (Drawable) null);
        this.f62148e.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SkinManager.getDrawable(R.drawable.filter_flip_left_right), (Drawable) null, (Drawable) null);
        this.f62146c.setCompoundDrawablePadding(f62145g);
        this.f62147d.setCompoundDrawablePadding(f62145g);
        this.f62149f.setCompoundDrawablePadding(f62145g);
        this.f62148e.setCompoundDrawablePadding(f62145g);
    }

    public void g(View.OnClickListener onClickListener) {
        this.f62146c.setTag(0);
        this.f62147d.setTag(1);
        this.f62148e.setTag(2);
        this.f62149f.setTag(3);
        this.f62146c.setOnClickListener(onClickListener);
        this.f62147d.setOnClickListener(onClickListener);
        this.f62148e.setOnClickListener(onClickListener);
        this.f62149f.setOnClickListener(onClickListener);
    }
}

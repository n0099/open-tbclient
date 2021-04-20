package d.b.i0.v3.u.c;

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
    public static int f63482g;

    /* renamed from: c  reason: collision with root package name */
    public TextView f63483c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f63484d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f63485e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f63486f;

    public b(f fVar) {
        super(fVar);
        f63482g = fVar.getResources().getDimensionPixelOffset(R.dimen.ds8);
    }

    @Override // d.b.i0.v3.u.c.a
    public void d() {
        View inflate = LayoutInflater.from(this.f63480a.getPageActivity()).inflate(R.layout.pic_rorate_view, (ViewGroup) null);
        this.f63481b = inflate;
        this.f63483c = (TextView) inflate.findViewById(R.id.rotate_left);
        this.f63484d = (TextView) this.f63481b.findViewById(R.id.rotate_right);
        this.f63485e = (TextView) this.f63481b.findViewById(R.id.rotate_left_right);
        this.f63486f = (TextView) this.f63481b.findViewById(R.id.rotate_up_down);
    }

    public View e() {
        return this.f63481b;
    }

    public void f() {
        SkinManager.setViewTextColor(this.f63483c, R.color.CAM_X0107);
        SkinManager.setViewTextColor(this.f63484d, R.color.CAM_X0107);
        SkinManager.setViewTextColor(this.f63485e, R.color.CAM_X0107);
        SkinManager.setViewTextColor(this.f63486f, R.color.CAM_X0107);
        this.f63483c.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SkinManager.getDrawable(R.drawable.filter_rotate_left), (Drawable) null, (Drawable) null);
        this.f63484d.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SkinManager.getDrawable(R.drawable.filter_rotate_right), (Drawable) null, (Drawable) null);
        this.f63486f.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SkinManager.getDrawable(R.drawable.filter_flip_up_down), (Drawable) null, (Drawable) null);
        this.f63485e.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SkinManager.getDrawable(R.drawable.filter_flip_left_right), (Drawable) null, (Drawable) null);
        this.f63483c.setCompoundDrawablePadding(f63482g);
        this.f63484d.setCompoundDrawablePadding(f63482g);
        this.f63486f.setCompoundDrawablePadding(f63482g);
        this.f63485e.setCompoundDrawablePadding(f63482g);
    }

    public void g(View.OnClickListener onClickListener) {
        this.f63483c.setTag(0);
        this.f63484d.setTag(1);
        this.f63485e.setTag(2);
        this.f63486f.setTag(3);
        this.f63483c.setOnClickListener(onClickListener);
        this.f63484d.setOnClickListener(onClickListener);
        this.f63485e.setOnClickListener(onClickListener);
        this.f63486f.setOnClickListener(onClickListener);
    }
}

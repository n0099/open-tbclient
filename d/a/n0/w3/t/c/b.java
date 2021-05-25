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
    public static int f62978g;

    /* renamed from: c  reason: collision with root package name */
    public TextView f62979c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f62980d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f62981e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f62982f;

    public b(f fVar) {
        super(fVar);
        f62978g = fVar.getResources().getDimensionPixelOffset(R.dimen.ds8);
    }

    @Override // d.a.n0.w3.t.c.a
    public void d() {
        View inflate = LayoutInflater.from(this.f62976a.getPageActivity()).inflate(R.layout.pic_rorate_view, (ViewGroup) null);
        this.f62977b = inflate;
        this.f62979c = (TextView) inflate.findViewById(R.id.rotate_left);
        this.f62980d = (TextView) this.f62977b.findViewById(R.id.rotate_right);
        this.f62981e = (TextView) this.f62977b.findViewById(R.id.rotate_left_right);
        this.f62982f = (TextView) this.f62977b.findViewById(R.id.rotate_up_down);
    }

    public View e() {
        return this.f62977b;
    }

    public void f() {
        SkinManager.setViewTextColor(this.f62979c, R.color.CAM_X0107);
        SkinManager.setViewTextColor(this.f62980d, R.color.CAM_X0107);
        SkinManager.setViewTextColor(this.f62981e, R.color.CAM_X0107);
        SkinManager.setViewTextColor(this.f62982f, R.color.CAM_X0107);
        this.f62979c.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SkinManager.getDrawable(R.drawable.filter_rotate_left), (Drawable) null, (Drawable) null);
        this.f62980d.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SkinManager.getDrawable(R.drawable.filter_rotate_right), (Drawable) null, (Drawable) null);
        this.f62982f.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SkinManager.getDrawable(R.drawable.filter_flip_up_down), (Drawable) null, (Drawable) null);
        this.f62981e.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SkinManager.getDrawable(R.drawable.filter_flip_left_right), (Drawable) null, (Drawable) null);
        this.f62979c.setCompoundDrawablePadding(f62978g);
        this.f62980d.setCompoundDrawablePadding(f62978g);
        this.f62982f.setCompoundDrawablePadding(f62978g);
        this.f62981e.setCompoundDrawablePadding(f62978g);
    }

    public void g(View.OnClickListener onClickListener) {
        this.f62979c.setTag(0);
        this.f62980d.setTag(1);
        this.f62981e.setTag(2);
        this.f62982f.setTag(3);
        this.f62979c.setOnClickListener(onClickListener);
        this.f62980d.setOnClickListener(onClickListener);
        this.f62981e.setOnClickListener(onClickListener);
        this.f62982f.setOnClickListener(onClickListener);
    }
}

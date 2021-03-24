package d.b.i0.u3.u.c;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import d.b.b.a.f;
/* loaded from: classes5.dex */
public class b extends a {

    /* renamed from: g  reason: collision with root package name */
    public static int f61743g;

    /* renamed from: c  reason: collision with root package name */
    public TextView f61744c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f61745d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f61746e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f61747f;

    public b(f fVar) {
        super(fVar);
        f61743g = fVar.getResources().getDimensionPixelOffset(R.dimen.ds8);
    }

    @Override // d.b.i0.u3.u.c.a
    public void d() {
        View inflate = LayoutInflater.from(this.f61741a.getPageActivity()).inflate(R.layout.pic_rorate_view, (ViewGroup) null);
        this.f61742b = inflate;
        this.f61744c = (TextView) inflate.findViewById(R.id.rotate_left);
        this.f61745d = (TextView) this.f61742b.findViewById(R.id.rotate_right);
        this.f61746e = (TextView) this.f61742b.findViewById(R.id.rotate_left_right);
        this.f61747f = (TextView) this.f61742b.findViewById(R.id.rotate_up_down);
    }

    public View e() {
        return this.f61742b;
    }

    public void f() {
        SkinManager.setViewTextColor(this.f61744c, R.color.CAM_X0107);
        SkinManager.setViewTextColor(this.f61745d, R.color.CAM_X0107);
        SkinManager.setViewTextColor(this.f61746e, R.color.CAM_X0107);
        SkinManager.setViewTextColor(this.f61747f, R.color.CAM_X0107);
        this.f61744c.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SkinManager.getDrawable(R.drawable.filter_rotate_left), (Drawable) null, (Drawable) null);
        this.f61745d.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SkinManager.getDrawable(R.drawable.filter_rotate_right), (Drawable) null, (Drawable) null);
        this.f61747f.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SkinManager.getDrawable(R.drawable.filter_flip_up_down), (Drawable) null, (Drawable) null);
        this.f61746e.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SkinManager.getDrawable(R.drawable.filter_flip_left_right), (Drawable) null, (Drawable) null);
        this.f61744c.setCompoundDrawablePadding(f61743g);
        this.f61745d.setCompoundDrawablePadding(f61743g);
        this.f61747f.setCompoundDrawablePadding(f61743g);
        this.f61746e.setCompoundDrawablePadding(f61743g);
    }

    public void g(View.OnClickListener onClickListener) {
        this.f61744c.setTag(0);
        this.f61745d.setTag(1);
        this.f61746e.setTag(2);
        this.f61747f.setTag(3);
        this.f61744c.setOnClickListener(onClickListener);
        this.f61745d.setOnClickListener(onClickListener);
        this.f61746e.setOnClickListener(onClickListener);
        this.f61747f.setOnClickListener(onClickListener);
    }
}

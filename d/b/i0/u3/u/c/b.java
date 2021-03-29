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
    public static int f61744g;

    /* renamed from: c  reason: collision with root package name */
    public TextView f61745c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f61746d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f61747e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f61748f;

    public b(f fVar) {
        super(fVar);
        f61744g = fVar.getResources().getDimensionPixelOffset(R.dimen.ds8);
    }

    @Override // d.b.i0.u3.u.c.a
    public void d() {
        View inflate = LayoutInflater.from(this.f61742a.getPageActivity()).inflate(R.layout.pic_rorate_view, (ViewGroup) null);
        this.f61743b = inflate;
        this.f61745c = (TextView) inflate.findViewById(R.id.rotate_left);
        this.f61746d = (TextView) this.f61743b.findViewById(R.id.rotate_right);
        this.f61747e = (TextView) this.f61743b.findViewById(R.id.rotate_left_right);
        this.f61748f = (TextView) this.f61743b.findViewById(R.id.rotate_up_down);
    }

    public View e() {
        return this.f61743b;
    }

    public void f() {
        SkinManager.setViewTextColor(this.f61745c, R.color.CAM_X0107);
        SkinManager.setViewTextColor(this.f61746d, R.color.CAM_X0107);
        SkinManager.setViewTextColor(this.f61747e, R.color.CAM_X0107);
        SkinManager.setViewTextColor(this.f61748f, R.color.CAM_X0107);
        this.f61745c.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SkinManager.getDrawable(R.drawable.filter_rotate_left), (Drawable) null, (Drawable) null);
        this.f61746d.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SkinManager.getDrawable(R.drawable.filter_rotate_right), (Drawable) null, (Drawable) null);
        this.f61748f.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SkinManager.getDrawable(R.drawable.filter_flip_up_down), (Drawable) null, (Drawable) null);
        this.f61747e.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SkinManager.getDrawable(R.drawable.filter_flip_left_right), (Drawable) null, (Drawable) null);
        this.f61745c.setCompoundDrawablePadding(f61744g);
        this.f61746d.setCompoundDrawablePadding(f61744g);
        this.f61748f.setCompoundDrawablePadding(f61744g);
        this.f61747e.setCompoundDrawablePadding(f61744g);
    }

    public void g(View.OnClickListener onClickListener) {
        this.f61745c.setTag(0);
        this.f61746d.setTag(1);
        this.f61747e.setTag(2);
        this.f61748f.setTag(3);
        this.f61745c.setOnClickListener(onClickListener);
        this.f61746d.setOnClickListener(onClickListener);
        this.f61747e.setOnClickListener(onClickListener);
        this.f61748f.setOnClickListener(onClickListener);
    }
}

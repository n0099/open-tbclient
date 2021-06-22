package d.a.o0.w3.t.c;

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
    public static int f66818g;

    /* renamed from: c  reason: collision with root package name */
    public TextView f66819c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f66820d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f66821e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f66822f;

    public b(f fVar) {
        super(fVar);
        f66818g = fVar.getResources().getDimensionPixelOffset(R.dimen.ds8);
    }

    @Override // d.a.o0.w3.t.c.a
    public void d() {
        View inflate = LayoutInflater.from(this.f66816a.getPageActivity()).inflate(R.layout.pic_rorate_view, (ViewGroup) null);
        this.f66817b = inflate;
        this.f66819c = (TextView) inflate.findViewById(R.id.rotate_left);
        this.f66820d = (TextView) this.f66817b.findViewById(R.id.rotate_right);
        this.f66821e = (TextView) this.f66817b.findViewById(R.id.rotate_left_right);
        this.f66822f = (TextView) this.f66817b.findViewById(R.id.rotate_up_down);
    }

    public View e() {
        return this.f66817b;
    }

    public void f() {
        SkinManager.setViewTextColor(this.f66819c, R.color.CAM_X0107);
        SkinManager.setViewTextColor(this.f66820d, R.color.CAM_X0107);
        SkinManager.setViewTextColor(this.f66821e, R.color.CAM_X0107);
        SkinManager.setViewTextColor(this.f66822f, R.color.CAM_X0107);
        this.f66819c.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SkinManager.getDrawable(R.drawable.filter_rotate_left), (Drawable) null, (Drawable) null);
        this.f66820d.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SkinManager.getDrawable(R.drawable.filter_rotate_right), (Drawable) null, (Drawable) null);
        this.f66822f.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SkinManager.getDrawable(R.drawable.filter_flip_up_down), (Drawable) null, (Drawable) null);
        this.f66821e.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, SkinManager.getDrawable(R.drawable.filter_flip_left_right), (Drawable) null, (Drawable) null);
        this.f66819c.setCompoundDrawablePadding(f66818g);
        this.f66820d.setCompoundDrawablePadding(f66818g);
        this.f66822f.setCompoundDrawablePadding(f66818g);
        this.f66821e.setCompoundDrawablePadding(f66818g);
    }

    public void g(View.OnClickListener onClickListener) {
        this.f66819c.setTag(0);
        this.f66820d.setTag(1);
        this.f66821e.setTag(2);
        this.f66822f.setTag(3);
        this.f66819c.setOnClickListener(onClickListener);
        this.f66820d.setOnClickListener(onClickListener);
        this.f66821e.setOnClickListener(onClickListener);
        this.f66822f.setOnClickListener(onClickListener);
    }
}

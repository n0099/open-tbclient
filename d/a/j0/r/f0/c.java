package d.a.j0.r.f0;

import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class c {

    /* renamed from: b  reason: collision with root package name */
    public Context f49666b;

    /* renamed from: f  reason: collision with root package name */
    public Toast f49670f;

    /* renamed from: a  reason: collision with root package name */
    public long f49665a = 3000;

    /* renamed from: c  reason: collision with root package name */
    public View f49667c = null;

    /* renamed from: d  reason: collision with root package name */
    public TextView f49668d = null;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f49669e = null;

    /* renamed from: h  reason: collision with root package name */
    public Runnable f49672h = new a();

    /* renamed from: g  reason: collision with root package name */
    public Handler f49671g = new Handler();

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (c.this.f49670f != null) {
                c.this.f49670f.cancel();
            }
        }
    }

    public c() {
        this.f49666b = null;
        this.f49666b = TbadkCoreApplication.getInst().getContext();
    }

    public void b(CharSequence charSequence) {
        View inflate = LayoutInflater.from(this.f49666b).inflate(R.layout.image_toast_view, (ViewGroup) null);
        this.f49667c = inflate;
        this.f49668d = (TextView) inflate.findViewById(R.id.tip_text);
        this.f49669e = (ImageView) this.f49667c.findViewById(R.id.tip_iamge);
        this.f49667c.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(d.a.c.e.p.l.g(this.f49666b, R.dimen.tbds32), SkinManager.getColor(R.color.CAM_X0701)));
        SkinManager.setViewTextColor(this.f49668d, R.color.CAM_X0101);
        this.f49668d.setText(charSequence);
        this.f49669e.setImageResource(R.drawable.icon_toast_game_error);
        e(this.f49667c);
    }

    public void c(CharSequence charSequence) {
        View inflate = LayoutInflater.from(this.f49666b).inflate(R.layout.image_toast_view, (ViewGroup) null);
        this.f49667c = inflate;
        this.f49668d = (TextView) inflate.findViewById(R.id.tip_text);
        this.f49669e = (ImageView) this.f49667c.findViewById(R.id.tip_iamge);
        this.f49667c.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(d.a.c.e.p.l.g(this.f49666b, R.dimen.tbds32), SkinManager.getColor(R.color.CAM_X0701)));
        SkinManager.setViewTextColor(this.f49668d, R.color.CAM_X0101);
        this.f49668d.setText(charSequence);
        this.f49669e.setImageResource(R.drawable.icon_toast_game_ok);
        e(this.f49667c);
    }

    public void d(int i2, int i3) {
        View inflate = LayoutInflater.from(this.f49666b).inflate(R.layout.image_toast_view, (ViewGroup) null);
        this.f49667c = inflate;
        this.f49668d = (TextView) inflate.findViewById(R.id.tip_text);
        this.f49669e = (ImageView) this.f49667c.findViewById(R.id.tip_iamge);
        this.f49667c.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(d.a.c.e.p.l.g(this.f49666b, R.dimen.tbds32), SkinManager.getColor(R.color.CAM_X0701)));
        SkinManager.setViewTextColor(this.f49668d, R.color.CAM_X0101);
        this.f49668d.setText(i3);
        this.f49669e.setImageResource(i2);
        e(this.f49667c);
    }

    public void e(View view) {
        this.f49671g.removeCallbacks(this.f49672h);
        if (this.f49670f == null) {
            this.f49670f = new Toast(this.f49666b);
        }
        this.f49671g.postDelayed(this.f49672h, this.f49665a);
        this.f49670f.setView(view);
        this.f49670f.setDuration(1);
        this.f49670f.setGravity(17, 0, 0);
        this.f49670f.show();
    }
}

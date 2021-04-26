package d.a.i0.r.f0;

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
    public Context f48837b;

    /* renamed from: f  reason: collision with root package name */
    public Toast f48841f;

    /* renamed from: a  reason: collision with root package name */
    public long f48836a = 3000;

    /* renamed from: c  reason: collision with root package name */
    public View f48838c = null;

    /* renamed from: d  reason: collision with root package name */
    public TextView f48839d = null;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f48840e = null;

    /* renamed from: h  reason: collision with root package name */
    public Runnable f48843h = new a();

    /* renamed from: g  reason: collision with root package name */
    public Handler f48842g = new Handler();

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (c.this.f48841f != null) {
                c.this.f48841f.cancel();
            }
        }
    }

    public c() {
        this.f48837b = null;
        this.f48837b = TbadkCoreApplication.getInst().getContext();
    }

    public void b(CharSequence charSequence) {
        View inflate = LayoutInflater.from(this.f48837b).inflate(R.layout.image_toast_view, (ViewGroup) null);
        this.f48838c = inflate;
        this.f48839d = (TextView) inflate.findViewById(R.id.tip_text);
        this.f48840e = (ImageView) this.f48838c.findViewById(R.id.tip_iamge);
        this.f48838c.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(d.a.c.e.p.l.g(this.f48837b, R.dimen.tbds32), SkinManager.getColor(R.color.CAM_X0701)));
        SkinManager.setViewTextColor(this.f48839d, R.color.CAM_X0101);
        this.f48839d.setText(charSequence);
        this.f48840e.setImageResource(R.drawable.icon_toast_game_error);
        e(this.f48838c);
    }

    public void c(CharSequence charSequence) {
        View inflate = LayoutInflater.from(this.f48837b).inflate(R.layout.image_toast_view, (ViewGroup) null);
        this.f48838c = inflate;
        this.f48839d = (TextView) inflate.findViewById(R.id.tip_text);
        this.f48840e = (ImageView) this.f48838c.findViewById(R.id.tip_iamge);
        this.f48838c.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(d.a.c.e.p.l.g(this.f48837b, R.dimen.tbds32), SkinManager.getColor(R.color.CAM_X0701)));
        SkinManager.setViewTextColor(this.f48839d, R.color.CAM_X0101);
        this.f48839d.setText(charSequence);
        this.f48840e.setImageResource(R.drawable.icon_toast_game_ok);
        e(this.f48838c);
    }

    public void d(int i2, int i3) {
        View inflate = LayoutInflater.from(this.f48837b).inflate(R.layout.image_toast_view, (ViewGroup) null);
        this.f48838c = inflate;
        this.f48839d = (TextView) inflate.findViewById(R.id.tip_text);
        this.f48840e = (ImageView) this.f48838c.findViewById(R.id.tip_iamge);
        this.f48838c.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(d.a.c.e.p.l.g(this.f48837b, R.dimen.tbds32), SkinManager.getColor(R.color.CAM_X0701)));
        SkinManager.setViewTextColor(this.f48839d, R.color.CAM_X0101);
        this.f48839d.setText(i3);
        this.f48840e.setImageResource(i2);
        e(this.f48838c);
    }

    public void e(View view) {
        this.f48842g.removeCallbacks(this.f48843h);
        if (this.f48841f == null) {
            this.f48841f = new Toast(this.f48837b);
        }
        this.f48842g.postDelayed(this.f48843h, this.f48836a);
        this.f48841f.setView(view);
        this.f48841f.setDuration(1);
        this.f48841f.setGravity(17, 0, 0);
        this.f48841f.show();
    }
}

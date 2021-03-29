package d.b.h0.r.f0;

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
    public Context f50485b;

    /* renamed from: f  reason: collision with root package name */
    public Toast f50489f;

    /* renamed from: a  reason: collision with root package name */
    public long f50484a = 3000;

    /* renamed from: c  reason: collision with root package name */
    public View f50486c = null;

    /* renamed from: d  reason: collision with root package name */
    public TextView f50487d = null;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f50488e = null;

    /* renamed from: h  reason: collision with root package name */
    public Runnable f50491h = new a();

    /* renamed from: g  reason: collision with root package name */
    public Handler f50490g = new Handler();

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (c.this.f50489f != null) {
                c.this.f50489f.cancel();
            }
        }
    }

    public c() {
        this.f50485b = null;
        this.f50485b = TbadkCoreApplication.getInst().getContext();
    }

    public void b(CharSequence charSequence) {
        View inflate = LayoutInflater.from(this.f50485b).inflate(R.layout.image_toast_view, (ViewGroup) null);
        this.f50486c = inflate;
        this.f50487d = (TextView) inflate.findViewById(R.id.tip_text);
        this.f50488e = (ImageView) this.f50486c.findViewById(R.id.tip_iamge);
        this.f50486c.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(d.b.b.e.p.l.g(this.f50485b, R.dimen.tbds32), SkinManager.getColor(R.color.CAM_X0701)));
        SkinManager.setViewTextColor(this.f50487d, R.color.CAM_X0101);
        this.f50487d.setText(charSequence);
        this.f50488e.setImageResource(R.drawable.icon_toast_game_error);
        e(this.f50486c);
    }

    public void c(CharSequence charSequence) {
        View inflate = LayoutInflater.from(this.f50485b).inflate(R.layout.image_toast_view, (ViewGroup) null);
        this.f50486c = inflate;
        this.f50487d = (TextView) inflate.findViewById(R.id.tip_text);
        this.f50488e = (ImageView) this.f50486c.findViewById(R.id.tip_iamge);
        this.f50486c.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(d.b.b.e.p.l.g(this.f50485b, R.dimen.tbds32), SkinManager.getColor(R.color.CAM_X0701)));
        SkinManager.setViewTextColor(this.f50487d, R.color.CAM_X0101);
        this.f50487d.setText(charSequence);
        this.f50488e.setImageResource(R.drawable.icon_toast_game_ok);
        e(this.f50486c);
    }

    public void d(int i, int i2) {
        View inflate = LayoutInflater.from(this.f50485b).inflate(R.layout.image_toast_view, (ViewGroup) null);
        this.f50486c = inflate;
        this.f50487d = (TextView) inflate.findViewById(R.id.tip_text);
        this.f50488e = (ImageView) this.f50486c.findViewById(R.id.tip_iamge);
        this.f50486c.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(d.b.b.e.p.l.g(this.f50485b, R.dimen.tbds32), SkinManager.getColor(R.color.CAM_X0701)));
        SkinManager.setViewTextColor(this.f50487d, R.color.CAM_X0101);
        this.f50487d.setText(i2);
        this.f50488e.setImageResource(i);
        e(this.f50486c);
    }

    public void e(View view) {
        this.f50490g.removeCallbacks(this.f50491h);
        if (this.f50489f == null) {
            this.f50489f = new Toast(this.f50485b);
        }
        this.f50490g.postDelayed(this.f50491h, this.f50484a);
        this.f50489f.setView(view);
        this.f50489f.setDuration(1);
        this.f50489f.setGravity(17, 0, 0);
        this.f50489f.show();
    }
}

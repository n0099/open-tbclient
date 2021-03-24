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
    public Context f50484b;

    /* renamed from: f  reason: collision with root package name */
    public Toast f50488f;

    /* renamed from: a  reason: collision with root package name */
    public long f50483a = 3000;

    /* renamed from: c  reason: collision with root package name */
    public View f50485c = null;

    /* renamed from: d  reason: collision with root package name */
    public TextView f50486d = null;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f50487e = null;

    /* renamed from: h  reason: collision with root package name */
    public Runnable f50490h = new a();

    /* renamed from: g  reason: collision with root package name */
    public Handler f50489g = new Handler();

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (c.this.f50488f != null) {
                c.this.f50488f.cancel();
            }
        }
    }

    public c() {
        this.f50484b = null;
        this.f50484b = TbadkCoreApplication.getInst().getContext();
    }

    public void b(CharSequence charSequence) {
        View inflate = LayoutInflater.from(this.f50484b).inflate(R.layout.image_toast_view, (ViewGroup) null);
        this.f50485c = inflate;
        this.f50486d = (TextView) inflate.findViewById(R.id.tip_text);
        this.f50487e = (ImageView) this.f50485c.findViewById(R.id.tip_iamge);
        this.f50485c.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(d.b.b.e.p.l.g(this.f50484b, R.dimen.tbds32), SkinManager.getColor(R.color.CAM_X0701)));
        SkinManager.setViewTextColor(this.f50486d, R.color.CAM_X0101);
        this.f50486d.setText(charSequence);
        this.f50487e.setImageResource(R.drawable.icon_toast_game_error);
        e(this.f50485c);
    }

    public void c(CharSequence charSequence) {
        View inflate = LayoutInflater.from(this.f50484b).inflate(R.layout.image_toast_view, (ViewGroup) null);
        this.f50485c = inflate;
        this.f50486d = (TextView) inflate.findViewById(R.id.tip_text);
        this.f50487e = (ImageView) this.f50485c.findViewById(R.id.tip_iamge);
        this.f50485c.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(d.b.b.e.p.l.g(this.f50484b, R.dimen.tbds32), SkinManager.getColor(R.color.CAM_X0701)));
        SkinManager.setViewTextColor(this.f50486d, R.color.CAM_X0101);
        this.f50486d.setText(charSequence);
        this.f50487e.setImageResource(R.drawable.icon_toast_game_ok);
        e(this.f50485c);
    }

    public void d(int i, int i2) {
        View inflate = LayoutInflater.from(this.f50484b).inflate(R.layout.image_toast_view, (ViewGroup) null);
        this.f50485c = inflate;
        this.f50486d = (TextView) inflate.findViewById(R.id.tip_text);
        this.f50487e = (ImageView) this.f50485c.findViewById(R.id.tip_iamge);
        this.f50485c.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(d.b.b.e.p.l.g(this.f50484b, R.dimen.tbds32), SkinManager.getColor(R.color.CAM_X0701)));
        SkinManager.setViewTextColor(this.f50486d, R.color.CAM_X0101);
        this.f50486d.setText(i2);
        this.f50487e.setImageResource(i);
        e(this.f50485c);
    }

    public void e(View view) {
        this.f50489g.removeCallbacks(this.f50490h);
        if (this.f50488f == null) {
            this.f50488f = new Toast(this.f50484b);
        }
        this.f50489g.postDelayed(this.f50490h, this.f50483a);
        this.f50488f.setView(view);
        this.f50488f.setDuration(1);
        this.f50488f.setGravity(17, 0, 0);
        this.f50488f.show();
    }
}

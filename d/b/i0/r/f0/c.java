package d.b.i0.r.f0;

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
    public Context f51228b;

    /* renamed from: f  reason: collision with root package name */
    public Toast f51232f;

    /* renamed from: a  reason: collision with root package name */
    public long f51227a = 3000;

    /* renamed from: c  reason: collision with root package name */
    public View f51229c = null;

    /* renamed from: d  reason: collision with root package name */
    public TextView f51230d = null;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f51231e = null;

    /* renamed from: h  reason: collision with root package name */
    public Runnable f51234h = new a();

    /* renamed from: g  reason: collision with root package name */
    public Handler f51233g = new Handler();

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (c.this.f51232f != null) {
                c.this.f51232f.cancel();
            }
        }
    }

    public c() {
        this.f51228b = null;
        this.f51228b = TbadkCoreApplication.getInst().getContext();
    }

    public void b(CharSequence charSequence) {
        View inflate = LayoutInflater.from(this.f51228b).inflate(R.layout.image_toast_view, (ViewGroup) null);
        this.f51229c = inflate;
        this.f51230d = (TextView) inflate.findViewById(R.id.tip_text);
        this.f51231e = (ImageView) this.f51229c.findViewById(R.id.tip_iamge);
        this.f51229c.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(d.b.c.e.p.l.g(this.f51228b, R.dimen.tbds32), SkinManager.getColor(R.color.CAM_X0701)));
        SkinManager.setViewTextColor(this.f51230d, R.color.CAM_X0101);
        this.f51230d.setText(charSequence);
        this.f51231e.setImageResource(R.drawable.icon_toast_game_error);
        e(this.f51229c);
    }

    public void c(CharSequence charSequence) {
        View inflate = LayoutInflater.from(this.f51228b).inflate(R.layout.image_toast_view, (ViewGroup) null);
        this.f51229c = inflate;
        this.f51230d = (TextView) inflate.findViewById(R.id.tip_text);
        this.f51231e = (ImageView) this.f51229c.findViewById(R.id.tip_iamge);
        this.f51229c.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(d.b.c.e.p.l.g(this.f51228b, R.dimen.tbds32), SkinManager.getColor(R.color.CAM_X0701)));
        SkinManager.setViewTextColor(this.f51230d, R.color.CAM_X0101);
        this.f51230d.setText(charSequence);
        this.f51231e.setImageResource(R.drawable.icon_toast_game_ok);
        e(this.f51229c);
    }

    public void d(int i, int i2) {
        View inflate = LayoutInflater.from(this.f51228b).inflate(R.layout.image_toast_view, (ViewGroup) null);
        this.f51229c = inflate;
        this.f51230d = (TextView) inflate.findViewById(R.id.tip_text);
        this.f51231e = (ImageView) this.f51229c.findViewById(R.id.tip_iamge);
        this.f51229c.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(d.b.c.e.p.l.g(this.f51228b, R.dimen.tbds32), SkinManager.getColor(R.color.CAM_X0701)));
        SkinManager.setViewTextColor(this.f51230d, R.color.CAM_X0101);
        this.f51230d.setText(i2);
        this.f51231e.setImageResource(i);
        e(this.f51229c);
    }

    public void e(View view) {
        this.f51233g.removeCallbacks(this.f51234h);
        if (this.f51232f == null) {
            this.f51232f = new Toast(this.f51228b);
        }
        this.f51233g.postDelayed(this.f51234h, this.f51227a);
        this.f51232f.setView(view);
        this.f51232f.setDuration(1);
        this.f51232f.setGravity(17, 0, 0);
        this.f51232f.show();
    }
}

package d.a.n0.r.f0;

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
    public Context f53492b;

    /* renamed from: f  reason: collision with root package name */
    public Toast f53496f;

    /* renamed from: a  reason: collision with root package name */
    public long f53491a = 3000;

    /* renamed from: c  reason: collision with root package name */
    public View f53493c = null;

    /* renamed from: d  reason: collision with root package name */
    public TextView f53494d = null;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f53495e = null;

    /* renamed from: h  reason: collision with root package name */
    public Runnable f53498h = new a();

    /* renamed from: g  reason: collision with root package name */
    public Handler f53497g = new Handler();

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (c.this.f53496f != null) {
                c.this.f53496f.cancel();
            }
        }
    }

    public c() {
        this.f53492b = null;
        this.f53492b = TbadkCoreApplication.getInst().getContext();
    }

    public void b(CharSequence charSequence) {
        View inflate = LayoutInflater.from(this.f53492b).inflate(R.layout.image_toast_view, (ViewGroup) null);
        this.f53493c = inflate;
        this.f53494d = (TextView) inflate.findViewById(R.id.tip_text);
        this.f53495e = (ImageView) this.f53493c.findViewById(R.id.tip_iamge);
        this.f53493c.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(d.a.c.e.p.l.g(this.f53492b, R.dimen.tbds32), SkinManager.getColor(R.color.CAM_X0701)));
        SkinManager.setViewTextColor(this.f53494d, R.color.CAM_X0101);
        this.f53494d.setText(charSequence);
        this.f53495e.setImageResource(R.drawable.icon_toast_game_error);
        e(this.f53493c);
    }

    public void c(CharSequence charSequence) {
        View inflate = LayoutInflater.from(this.f53492b).inflate(R.layout.image_toast_view, (ViewGroup) null);
        this.f53493c = inflate;
        this.f53494d = (TextView) inflate.findViewById(R.id.tip_text);
        this.f53495e = (ImageView) this.f53493c.findViewById(R.id.tip_iamge);
        this.f53493c.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(d.a.c.e.p.l.g(this.f53492b, R.dimen.tbds32), SkinManager.getColor(R.color.CAM_X0701)));
        SkinManager.setViewTextColor(this.f53494d, R.color.CAM_X0101);
        this.f53494d.setText(charSequence);
        this.f53495e.setImageResource(R.drawable.icon_toast_game_ok);
        e(this.f53493c);
    }

    public void d(int i2, int i3) {
        View inflate = LayoutInflater.from(this.f53492b).inflate(R.layout.image_toast_view, (ViewGroup) null);
        this.f53493c = inflate;
        this.f53494d = (TextView) inflate.findViewById(R.id.tip_text);
        this.f53495e = (ImageView) this.f53493c.findViewById(R.id.tip_iamge);
        this.f53493c.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(d.a.c.e.p.l.g(this.f53492b, R.dimen.tbds32), SkinManager.getColor(R.color.CAM_X0701)));
        SkinManager.setViewTextColor(this.f53494d, R.color.CAM_X0101);
        this.f53494d.setText(i3);
        this.f53495e.setImageResource(i2);
        e(this.f53493c);
    }

    public void e(View view) {
        this.f53497g.removeCallbacks(this.f53498h);
        if (this.f53496f == null) {
            this.f53496f = new Toast(this.f53492b);
        }
        this.f53497g.postDelayed(this.f53498h, this.f53491a);
        this.f53496f.setView(view);
        this.f53496f.setDuration(1);
        this.f53496f.setGravity(17, 0, 0);
        this.f53496f.show();
    }
}

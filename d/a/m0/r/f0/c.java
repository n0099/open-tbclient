package d.a.m0.r.f0;

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
    public Context f53385b;

    /* renamed from: f  reason: collision with root package name */
    public Toast f53389f;

    /* renamed from: a  reason: collision with root package name */
    public long f53384a = 3000;

    /* renamed from: c  reason: collision with root package name */
    public View f53386c = null;

    /* renamed from: d  reason: collision with root package name */
    public TextView f53387d = null;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f53388e = null;

    /* renamed from: h  reason: collision with root package name */
    public Runnable f53391h = new a();

    /* renamed from: g  reason: collision with root package name */
    public Handler f53390g = new Handler();

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (c.this.f53389f != null) {
                c.this.f53389f.cancel();
            }
        }
    }

    public c() {
        this.f53385b = null;
        this.f53385b = TbadkCoreApplication.getInst().getContext();
    }

    public void b(CharSequence charSequence) {
        View inflate = LayoutInflater.from(this.f53385b).inflate(R.layout.image_toast_view, (ViewGroup) null);
        this.f53386c = inflate;
        this.f53387d = (TextView) inflate.findViewById(R.id.tip_text);
        this.f53388e = (ImageView) this.f53386c.findViewById(R.id.tip_iamge);
        this.f53386c.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(d.a.c.e.p.l.g(this.f53385b, R.dimen.tbds32), SkinManager.getColor(R.color.CAM_X0701)));
        SkinManager.setViewTextColor(this.f53387d, R.color.CAM_X0101);
        this.f53387d.setText(charSequence);
        this.f53388e.setImageResource(R.drawable.icon_toast_game_error);
        e(this.f53386c);
    }

    public void c(CharSequence charSequence) {
        View inflate = LayoutInflater.from(this.f53385b).inflate(R.layout.image_toast_view, (ViewGroup) null);
        this.f53386c = inflate;
        this.f53387d = (TextView) inflate.findViewById(R.id.tip_text);
        this.f53388e = (ImageView) this.f53386c.findViewById(R.id.tip_iamge);
        this.f53386c.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(d.a.c.e.p.l.g(this.f53385b, R.dimen.tbds32), SkinManager.getColor(R.color.CAM_X0701)));
        SkinManager.setViewTextColor(this.f53387d, R.color.CAM_X0101);
        this.f53387d.setText(charSequence);
        this.f53388e.setImageResource(R.drawable.icon_toast_game_ok);
        e(this.f53386c);
    }

    public void d(int i2, int i3) {
        View inflate = LayoutInflater.from(this.f53385b).inflate(R.layout.image_toast_view, (ViewGroup) null);
        this.f53386c = inflate;
        this.f53387d = (TextView) inflate.findViewById(R.id.tip_text);
        this.f53388e = (ImageView) this.f53386c.findViewById(R.id.tip_iamge);
        this.f53386c.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(d.a.c.e.p.l.g(this.f53385b, R.dimen.tbds32), SkinManager.getColor(R.color.CAM_X0701)));
        SkinManager.setViewTextColor(this.f53387d, R.color.CAM_X0101);
        this.f53387d.setText(i3);
        this.f53388e.setImageResource(i2);
        e(this.f53386c);
    }

    public void e(View view) {
        this.f53390g.removeCallbacks(this.f53391h);
        if (this.f53389f == null) {
            this.f53389f = new Toast(this.f53385b);
        }
        this.f53390g.postDelayed(this.f53391h, this.f53384a);
        this.f53389f.setView(view);
        this.f53389f.setDuration(1);
        this.f53389f.setGravity(17, 0, 0);
        this.f53389f.show();
    }
}

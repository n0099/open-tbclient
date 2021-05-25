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
    public Context f49710b;

    /* renamed from: f  reason: collision with root package name */
    public Toast f49714f;

    /* renamed from: a  reason: collision with root package name */
    public long f49709a = 3000;

    /* renamed from: c  reason: collision with root package name */
    public View f49711c = null;

    /* renamed from: d  reason: collision with root package name */
    public TextView f49712d = null;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f49713e = null;

    /* renamed from: h  reason: collision with root package name */
    public Runnable f49716h = new a();

    /* renamed from: g  reason: collision with root package name */
    public Handler f49715g = new Handler();

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (c.this.f49714f != null) {
                c.this.f49714f.cancel();
            }
        }
    }

    public c() {
        this.f49710b = null;
        this.f49710b = TbadkCoreApplication.getInst().getContext();
    }

    public void b(CharSequence charSequence) {
        View inflate = LayoutInflater.from(this.f49710b).inflate(R.layout.image_toast_view, (ViewGroup) null);
        this.f49711c = inflate;
        this.f49712d = (TextView) inflate.findViewById(R.id.tip_text);
        this.f49713e = (ImageView) this.f49711c.findViewById(R.id.tip_iamge);
        this.f49711c.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(d.a.c.e.p.l.g(this.f49710b, R.dimen.tbds32), SkinManager.getColor(R.color.CAM_X0701)));
        SkinManager.setViewTextColor(this.f49712d, R.color.CAM_X0101);
        this.f49712d.setText(charSequence);
        this.f49713e.setImageResource(R.drawable.icon_toast_game_error);
        e(this.f49711c);
    }

    public void c(CharSequence charSequence) {
        View inflate = LayoutInflater.from(this.f49710b).inflate(R.layout.image_toast_view, (ViewGroup) null);
        this.f49711c = inflate;
        this.f49712d = (TextView) inflate.findViewById(R.id.tip_text);
        this.f49713e = (ImageView) this.f49711c.findViewById(R.id.tip_iamge);
        this.f49711c.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(d.a.c.e.p.l.g(this.f49710b, R.dimen.tbds32), SkinManager.getColor(R.color.CAM_X0701)));
        SkinManager.setViewTextColor(this.f49712d, R.color.CAM_X0101);
        this.f49712d.setText(charSequence);
        this.f49713e.setImageResource(R.drawable.icon_toast_game_ok);
        e(this.f49711c);
    }

    public void d(int i2, int i3) {
        View inflate = LayoutInflater.from(this.f49710b).inflate(R.layout.image_toast_view, (ViewGroup) null);
        this.f49711c = inflate;
        this.f49712d = (TextView) inflate.findViewById(R.id.tip_text);
        this.f49713e = (ImageView) this.f49711c.findViewById(R.id.tip_iamge);
        this.f49711c.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(d.a.c.e.p.l.g(this.f49710b, R.dimen.tbds32), SkinManager.getColor(R.color.CAM_X0701)));
        SkinManager.setViewTextColor(this.f49712d, R.color.CAM_X0101);
        this.f49712d.setText(i3);
        this.f49713e.setImageResource(i2);
        e(this.f49711c);
    }

    public void e(View view) {
        this.f49715g.removeCallbacks(this.f49716h);
        if (this.f49714f == null) {
            this.f49714f = new Toast(this.f49710b);
        }
        this.f49715g.postDelayed(this.f49716h, this.f49709a);
        this.f49714f.setView(view);
        this.f49714f.setDuration(1);
        this.f49714f.setGravity(17, 0, 0);
        this.f49714f.show();
    }
}

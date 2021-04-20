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
    public Context f50892b;

    /* renamed from: f  reason: collision with root package name */
    public Toast f50896f;

    /* renamed from: a  reason: collision with root package name */
    public long f50891a = 3000;

    /* renamed from: c  reason: collision with root package name */
    public View f50893c = null;

    /* renamed from: d  reason: collision with root package name */
    public TextView f50894d = null;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f50895e = null;

    /* renamed from: h  reason: collision with root package name */
    public Runnable f50898h = new a();

    /* renamed from: g  reason: collision with root package name */
    public Handler f50897g = new Handler();

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (c.this.f50896f != null) {
                c.this.f50896f.cancel();
            }
        }
    }

    public c() {
        this.f50892b = null;
        this.f50892b = TbadkCoreApplication.getInst().getContext();
    }

    public void b(CharSequence charSequence) {
        View inflate = LayoutInflater.from(this.f50892b).inflate(R.layout.image_toast_view, (ViewGroup) null);
        this.f50893c = inflate;
        this.f50894d = (TextView) inflate.findViewById(R.id.tip_text);
        this.f50895e = (ImageView) this.f50893c.findViewById(R.id.tip_iamge);
        this.f50893c.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(d.b.c.e.p.l.g(this.f50892b, R.dimen.tbds32), SkinManager.getColor(R.color.CAM_X0701)));
        SkinManager.setViewTextColor(this.f50894d, R.color.CAM_X0101);
        this.f50894d.setText(charSequence);
        this.f50895e.setImageResource(R.drawable.icon_toast_game_error);
        e(this.f50893c);
    }

    public void c(CharSequence charSequence) {
        View inflate = LayoutInflater.from(this.f50892b).inflate(R.layout.image_toast_view, (ViewGroup) null);
        this.f50893c = inflate;
        this.f50894d = (TextView) inflate.findViewById(R.id.tip_text);
        this.f50895e = (ImageView) this.f50893c.findViewById(R.id.tip_iamge);
        this.f50893c.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(d.b.c.e.p.l.g(this.f50892b, R.dimen.tbds32), SkinManager.getColor(R.color.CAM_X0701)));
        SkinManager.setViewTextColor(this.f50894d, R.color.CAM_X0101);
        this.f50894d.setText(charSequence);
        this.f50895e.setImageResource(R.drawable.icon_toast_game_ok);
        e(this.f50893c);
    }

    public void d(int i, int i2) {
        View inflate = LayoutInflater.from(this.f50892b).inflate(R.layout.image_toast_view, (ViewGroup) null);
        this.f50893c = inflate;
        this.f50894d = (TextView) inflate.findViewById(R.id.tip_text);
        this.f50895e = (ImageView) this.f50893c.findViewById(R.id.tip_iamge);
        this.f50893c.setBackgroundDrawable(SkinManager.createShapeDrawableFromColor(d.b.c.e.p.l.g(this.f50892b, R.dimen.tbds32), SkinManager.getColor(R.color.CAM_X0701)));
        SkinManager.setViewTextColor(this.f50894d, R.color.CAM_X0101);
        this.f50894d.setText(i2);
        this.f50895e.setImageResource(i);
        e(this.f50893c);
    }

    public void e(View view) {
        this.f50897g.removeCallbacks(this.f50898h);
        if (this.f50896f == null) {
            this.f50896f = new Toast(this.f50892b);
        }
        this.f50897g.postDelayed(this.f50898h, this.f50891a);
        this.f50896f.setView(view);
        this.f50896f.setDuration(1);
        this.f50896f.setGravity(17, 0, 0);
        this.f50896f.show();
    }
}

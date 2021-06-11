package d.a.n0.t3.a;

import android.app.Activity;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tieba.R;
import d.a.c.e.g.d;
/* loaded from: classes5.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public String f64896a;

    /* renamed from: b  reason: collision with root package name */
    public String f64897b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.c.e.g.c f64898c;

    /* renamed from: d  reason: collision with root package name */
    public Runnable f64899d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.c.e.g.b f64900e;

    /* renamed from: f  reason: collision with root package name */
    public final Handler f64901f = new Handler();

    /* renamed from: g  reason: collision with root package name */
    public final Activity f64902g;

    /* renamed from: h  reason: collision with root package name */
    public final ViewGroup f64903h;

    /* renamed from: d.a.n0.t3.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class RunnableC1679a implements Runnable {
        public RunnableC1679a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.f64898c != null) {
                a.this.f64898c.e(a.this.f64903h);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements d.a {
        public b() {
        }

        @Override // d.a.c.e.g.d.a
        public void onDismiss() {
            a.this.f64898c = null;
            a.this.f64901f.removeCallbacks(a.this.f64899d);
        }

        @Override // d.a.c.e.g.d.a
        public void onShown() {
        }
    }

    /* loaded from: classes5.dex */
    public class c implements d.a.c.e.g.b {
        public c() {
        }

        @Override // d.a.c.e.g.b
        public int a() {
            return 3;
        }

        @Override // d.a.c.e.g.b
        public int b() {
            return 32;
        }

        @Override // d.a.c.e.g.b
        public View c(LayoutInflater layoutInflater) {
            View inflate = LayoutInflater.from(a.this.f64902g).inflate(R.layout.warning_toast, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(R.id.toast_title);
            TextView textView2 = (TextView) inflate.findViewById(R.id.toast_tip);
            SkinManager.setViewTextColor(textView, R.color.CAM_X0101);
            SkinManager.setViewTextColor(textView2, R.color.CAM_X0101);
            ((ImageView) inflate.findViewById(R.id.toast_img)).setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_toast_mistake_40, SkinManager.getColor(R.color.CAM_X0101), null));
            textView.setText(a.this.f64896a);
            if (!StringUtils.isNull(a.this.f64897b)) {
                textView2.setText(a.this.f64897b);
            } else {
                textView2.setVisibility(8);
            }
            return inflate;
        }

        @Override // d.a.c.e.g.b
        public int getXOffset() {
            return 0;
        }

        @Override // d.a.c.e.g.b
        public int getYOffset() {
            return 0;
        }
    }

    public a(Activity activity, ViewGroup viewGroup) {
        this.f64902g = activity;
        this.f64903h = viewGroup;
    }

    public final d.a.c.e.g.b i() {
        return new c();
    }

    public void j() {
        d.a.c.e.g.c cVar = this.f64898c;
        if (cVar != null) {
            cVar.e(this.f64903h);
            this.f64903h.setVisibility(8);
        }
    }

    public a k(String str) {
        this.f64896a = str;
        return this;
    }

    public void l() {
        ViewGroup viewGroup = this.f64903h;
        if (viewGroup == null) {
            return;
        }
        viewGroup.setVisibility(0);
        d.a.c.e.g.c cVar = this.f64898c;
        if (cVar != null) {
            cVar.e(this.f64903h);
        }
        this.f64899d = new RunnableC1679a();
        d dVar = new d();
        dVar.d(true);
        dVar.g(new b());
        if (this.f64900e == null) {
            this.f64900e = i();
        }
        dVar.a(this.f64900e);
        d.a.c.e.g.c b2 = dVar.b();
        this.f64898c = b2;
        b2.r(this.f64902g, this.f64903h, false);
        this.f64901f.postDelayed(this.f64899d, 3000L);
    }
}

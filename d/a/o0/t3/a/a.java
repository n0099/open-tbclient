package d.a.o0.t3.a;

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
    public String f65021a;

    /* renamed from: b  reason: collision with root package name */
    public String f65022b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.c.e.g.c f65023c;

    /* renamed from: d  reason: collision with root package name */
    public Runnable f65024d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.c.e.g.b f65025e;

    /* renamed from: f  reason: collision with root package name */
    public final Handler f65026f = new Handler();

    /* renamed from: g  reason: collision with root package name */
    public final Activity f65027g;

    /* renamed from: h  reason: collision with root package name */
    public final ViewGroup f65028h;

    /* renamed from: d.a.o0.t3.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class RunnableC1683a implements Runnable {
        public RunnableC1683a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.f65023c != null) {
                a.this.f65023c.e(a.this.f65028h);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements d.a {
        public b() {
        }

        @Override // d.a.c.e.g.d.a
        public void onDismiss() {
            a.this.f65023c = null;
            a.this.f65026f.removeCallbacks(a.this.f65024d);
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
            View inflate = LayoutInflater.from(a.this.f65027g).inflate(R.layout.warning_toast, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(R.id.toast_title);
            TextView textView2 = (TextView) inflate.findViewById(R.id.toast_tip);
            SkinManager.setViewTextColor(textView, R.color.CAM_X0101);
            SkinManager.setViewTextColor(textView2, R.color.CAM_X0101);
            ((ImageView) inflate.findViewById(R.id.toast_img)).setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_toast_mistake_40, SkinManager.getColor(R.color.CAM_X0101), null));
            textView.setText(a.this.f65021a);
            if (!StringUtils.isNull(a.this.f65022b)) {
                textView2.setText(a.this.f65022b);
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
        this.f65027g = activity;
        this.f65028h = viewGroup;
    }

    public final d.a.c.e.g.b i() {
        return new c();
    }

    public void j() {
        d.a.c.e.g.c cVar = this.f65023c;
        if (cVar != null) {
            cVar.e(this.f65028h);
            this.f65028h.setVisibility(8);
        }
    }

    public a k(String str) {
        this.f65021a = str;
        return this;
    }

    public void l() {
        ViewGroup viewGroup = this.f65028h;
        if (viewGroup == null) {
            return;
        }
        viewGroup.setVisibility(0);
        d.a.c.e.g.c cVar = this.f65023c;
        if (cVar != null) {
            cVar.e(this.f65028h);
        }
        this.f65024d = new RunnableC1683a();
        d dVar = new d();
        dVar.d(true);
        dVar.g(new b());
        if (this.f65025e == null) {
            this.f65025e = i();
        }
        dVar.a(this.f65025e);
        d.a.c.e.g.c b2 = dVar.b();
        this.f65023c = b2;
        b2.r(this.f65027g, this.f65028h, false);
        this.f65026f.postDelayed(this.f65024d, 3000L);
    }
}

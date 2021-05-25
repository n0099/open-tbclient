package d.a.l0.a.r1.o;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import d.a.l0.a.a2.e;
import d.a.l0.a.f;
import d.a.l0.a.g;
import java.text.SimpleDateFormat;
import java.util.Locale;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public boolean f44547a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f44548b;

    public void a() {
        this.f44547a = true;
    }

    public final ViewGroup b() {
        ViewGroup viewGroup;
        if (e.Q() == null || e.Q().x() == null || (viewGroup = (ViewGroup) e.Q().x().findViewById(16908290)) == null) {
            return null;
        }
        ViewGroup viewGroup2 = (ViewGroup) viewGroup.findViewById(f.start_up_root_container);
        if (viewGroup2 != null) {
            return viewGroup2;
        }
        ViewGroup viewGroup3 = (ViewGroup) LayoutInflater.from(e.Q().x()).inflate(g.swan_app_startup_window, viewGroup);
        this.f44548b = true;
        return viewGroup3;
    }

    public void c() {
        if (this.f44548b) {
            d();
        }
    }

    public final void d() {
        e Q = e.Q();
        if (Q == null || Q.x() == null) {
            return;
        }
        ViewGroup viewGroup = (ViewGroup) Q.x().findViewById(f.start_up_root_container);
        if (viewGroup != null && (viewGroup.getParent() instanceof ViewGroup)) {
            ((ViewGroup) viewGroup.getParent()).removeView(viewGroup);
        }
        this.f44548b = false;
    }

    public void e() {
        this.f44547a = false;
        c();
        k();
    }

    public void f(long j) {
        j(f.fcp, j, "#80ff0000", "FCP");
    }

    public void g(long j) {
        j(f.fip, j, "#80ff0000", "FIP");
    }

    public void h(long j) {
        j(f.fmp, j, "#8000ff00", "FMP");
    }

    public void i(long j) {
        j(f.ftp, j, "#80ff0000", "FTP");
    }

    public final void j(int i2, long j, String str, String str2) {
        ViewGroup b2;
        if (this.f44547a || (b2 = b()) == null) {
            return;
        }
        TextView textView = (TextView) b2.findViewById(i2);
        textView.setText(String.format(str2 + ":[%s]ms", Long.valueOf(j)));
        textView.setBackgroundColor(Color.parseColor(str));
    }

    public void k() {
        if (this.f44548b) {
            return;
        }
        b();
    }

    public void l(long j, long j2) {
        ViewGroup b2;
        if (this.f44547a || (b2 = b()) == null) {
            return;
        }
        ((TextView) b2.findViewById(f.sum)).setText(String.format("启动:[%s] 耗时:[%s]ms", new SimpleDateFormat("HH:mm:ss:SSS", Locale.getDefault()).format(Long.valueOf(j)), Long.valueOf(j2)));
    }
}

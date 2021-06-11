package d.a.n0.o2;

import android.view.View;
import androidx.viewpager.widget.ViewPager;
import com.baidu.tieba.R;
import com.baidu.tieba.postsearch.PostSearchActivity;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public PostSearchActivity f61589a;

    /* renamed from: b  reason: collision with root package name */
    public View f61590b;

    /* renamed from: c  reason: collision with root package name */
    public a f61591c;

    /* renamed from: d  reason: collision with root package name */
    public c f61592d;

    /* renamed from: e  reason: collision with root package name */
    public f f61593e;

    public g(PostSearchActivity postSearchActivity) {
        this.f61589a = postSearchActivity;
    }

    public int a() {
        return this.f61593e.d();
    }

    public void b() {
        this.f61592d.e();
    }

    public void c() {
        this.f61592d.f();
    }

    public void d() {
        this.f61591c.h();
    }

    public void e() {
        this.f61589a.setContentView(R.layout.post_search_activity);
        View findViewById = this.f61589a.findViewById(R.id.search_rootview);
        this.f61590b = findViewById;
        this.f61591c = new a(this.f61589a, findViewById);
        this.f61592d = new c(this.f61589a, this.f61590b);
        this.f61593e = new f(this.f61589a, this.f61590b);
    }

    public boolean f() {
        return this.f61592d.i();
    }

    public void g(int i2) {
        this.f61591c.j(i2);
        this.f61592d.j(i2);
        this.f61593e.g(i2);
        d.a.m0.s0.a.a(this.f61589a.getPageContext(), this.f61590b);
    }

    public void h() {
        a aVar = this.f61591c;
        if (aVar != null) {
            aVar.k();
        }
    }

    public void i(ArrayList<String> arrayList) {
        this.f61593e.j(false);
        this.f61592d.k(arrayList);
    }

    public void j(int i2, b bVar, boolean z) {
        this.f61593e.h(i2, bVar, z);
    }

    public void k(String str) {
        this.f61591c.l(str);
    }

    public void l(ViewPager.OnPageChangeListener onPageChangeListener) {
        f fVar = this.f61593e;
        if (fVar != null) {
            fVar.i(onPageChangeListener);
        }
    }

    public void m() {
        this.f61592d.m();
        this.f61592d.g();
    }

    public void n() {
        this.f61592d.p();
    }

    public void o(int i2) {
        this.f61591c.g();
        d();
        this.f61591c.f();
        this.f61593e.j(true);
        this.f61593e.k(i2);
    }
}

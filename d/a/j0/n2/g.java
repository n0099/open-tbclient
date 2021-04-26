package d.a.j0.n2;

import android.view.View;
import androidx.viewpager.widget.ViewPager;
import com.baidu.tieba.R;
import com.baidu.tieba.postsearch.PostSearchActivity;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public PostSearchActivity f57019a;

    /* renamed from: b  reason: collision with root package name */
    public View f57020b;

    /* renamed from: c  reason: collision with root package name */
    public a f57021c;

    /* renamed from: d  reason: collision with root package name */
    public c f57022d;

    /* renamed from: e  reason: collision with root package name */
    public f f57023e;

    public g(PostSearchActivity postSearchActivity) {
        this.f57019a = postSearchActivity;
    }

    public int a() {
        return this.f57023e.d();
    }

    public void b() {
        this.f57022d.e();
    }

    public void c() {
        this.f57022d.f();
    }

    public void d() {
        this.f57021c.h();
    }

    public void e() {
        this.f57019a.setContentView(R.layout.post_search_activity);
        View findViewById = this.f57019a.findViewById(R.id.search_rootview);
        this.f57020b = findViewById;
        this.f57021c = new a(this.f57019a, findViewById);
        this.f57022d = new c(this.f57019a, this.f57020b);
        this.f57023e = new f(this.f57019a, this.f57020b);
    }

    public boolean f() {
        return this.f57022d.i();
    }

    public void g(int i2) {
        this.f57021c.j(i2);
        this.f57022d.j(i2);
        this.f57023e.g(i2);
        d.a.i0.s0.a.a(this.f57019a.getPageContext(), this.f57020b);
    }

    public void h() {
        a aVar = this.f57021c;
        if (aVar != null) {
            aVar.k();
        }
    }

    public void i(ArrayList<String> arrayList) {
        this.f57023e.j(false);
        this.f57022d.k(arrayList);
    }

    public void j(int i2, b bVar, boolean z) {
        this.f57023e.h(i2, bVar, z);
    }

    public void k(String str) {
        this.f57021c.l(str);
    }

    public void l(ViewPager.OnPageChangeListener onPageChangeListener) {
        f fVar = this.f57023e;
        if (fVar != null) {
            fVar.i(onPageChangeListener);
        }
    }

    public void m() {
        this.f57022d.m();
        this.f57022d.g();
    }

    public void n() {
        this.f57022d.p();
    }

    public void o(int i2) {
        this.f57021c.g();
        d();
        this.f57021c.f();
        this.f57023e.j(true);
        this.f57023e.k(i2);
    }
}

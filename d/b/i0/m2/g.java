package d.b.i0.m2;

import android.view.View;
import androidx.viewpager.widget.ViewPager;
import com.baidu.tieba.R;
import com.baidu.tieba.postsearch.PostSearchActivity;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public PostSearchActivity f56940a;

    /* renamed from: b  reason: collision with root package name */
    public View f56941b;

    /* renamed from: c  reason: collision with root package name */
    public a f56942c;

    /* renamed from: d  reason: collision with root package name */
    public c f56943d;

    /* renamed from: e  reason: collision with root package name */
    public f f56944e;

    public g(PostSearchActivity postSearchActivity) {
        this.f56940a = postSearchActivity;
    }

    public int a() {
        return this.f56944e.d();
    }

    public void b() {
        this.f56943d.e();
    }

    public void c() {
        this.f56943d.f();
    }

    public void d() {
        this.f56942c.h();
    }

    public void e() {
        this.f56940a.setContentView(R.layout.post_search_activity);
        View findViewById = this.f56940a.findViewById(R.id.search_rootview);
        this.f56941b = findViewById;
        this.f56942c = new a(this.f56940a, findViewById);
        this.f56943d = new c(this.f56940a, this.f56941b);
        this.f56944e = new f(this.f56940a, this.f56941b);
    }

    public boolean f() {
        return this.f56943d.i();
    }

    public void g(int i) {
        this.f56942c.j(i);
        this.f56943d.j(i);
        this.f56944e.g(i);
        d.b.h0.s0.a.a(this.f56940a.getPageContext(), this.f56941b);
    }

    public void h() {
        a aVar = this.f56942c;
        if (aVar != null) {
            aVar.k();
        }
    }

    public void i(ArrayList<String> arrayList) {
        this.f56944e.j(false);
        this.f56943d.k(arrayList);
    }

    public void j(int i, b bVar, boolean z) {
        this.f56944e.h(i, bVar, z);
    }

    public void k(String str) {
        this.f56942c.l(str);
    }

    public void l(ViewPager.OnPageChangeListener onPageChangeListener) {
        f fVar = this.f56944e;
        if (fVar != null) {
            fVar.i(onPageChangeListener);
        }
    }

    public void m() {
        this.f56943d.m();
        this.f56943d.g();
    }

    public void n() {
        this.f56943d.p();
    }

    public void o(int i) {
        this.f56942c.g();
        d();
        this.f56942c.f();
        this.f56944e.j(true);
        this.f56944e.k(i);
    }
}

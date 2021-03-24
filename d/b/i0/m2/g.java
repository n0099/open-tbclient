package d.b.i0.m2;

import android.view.View;
import androidx.viewpager.widget.ViewPager;
import com.baidu.tieba.R;
import com.baidu.tieba.postsearch.PostSearchActivity;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public PostSearchActivity f56939a;

    /* renamed from: b  reason: collision with root package name */
    public View f56940b;

    /* renamed from: c  reason: collision with root package name */
    public a f56941c;

    /* renamed from: d  reason: collision with root package name */
    public c f56942d;

    /* renamed from: e  reason: collision with root package name */
    public f f56943e;

    public g(PostSearchActivity postSearchActivity) {
        this.f56939a = postSearchActivity;
    }

    public int a() {
        return this.f56943e.d();
    }

    public void b() {
        this.f56942d.e();
    }

    public void c() {
        this.f56942d.f();
    }

    public void d() {
        this.f56941c.h();
    }

    public void e() {
        this.f56939a.setContentView(R.layout.post_search_activity);
        View findViewById = this.f56939a.findViewById(R.id.search_rootview);
        this.f56940b = findViewById;
        this.f56941c = new a(this.f56939a, findViewById);
        this.f56942d = new c(this.f56939a, this.f56940b);
        this.f56943e = new f(this.f56939a, this.f56940b);
    }

    public boolean f() {
        return this.f56942d.i();
    }

    public void g(int i) {
        this.f56941c.j(i);
        this.f56942d.j(i);
        this.f56943e.g(i);
        d.b.h0.s0.a.a(this.f56939a.getPageContext(), this.f56940b);
    }

    public void h() {
        a aVar = this.f56941c;
        if (aVar != null) {
            aVar.k();
        }
    }

    public void i(ArrayList<String> arrayList) {
        this.f56943e.j(false);
        this.f56942d.k(arrayList);
    }

    public void j(int i, b bVar, boolean z) {
        this.f56943e.h(i, bVar, z);
    }

    public void k(String str) {
        this.f56941c.l(str);
    }

    public void l(ViewPager.OnPageChangeListener onPageChangeListener) {
        f fVar = this.f56943e;
        if (fVar != null) {
            fVar.i(onPageChangeListener);
        }
    }

    public void m() {
        this.f56942d.m();
        this.f56942d.g();
    }

    public void n() {
        this.f56942d.p();
    }

    public void o(int i) {
        this.f56941c.g();
        d();
        this.f56941c.f();
        this.f56943e.j(true);
        this.f56943e.k(i);
    }
}

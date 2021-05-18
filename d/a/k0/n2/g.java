package d.a.k0.n2;

import android.view.View;
import androidx.viewpager.widget.ViewPager;
import com.baidu.tieba.R;
import com.baidu.tieba.postsearch.PostSearchActivity;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public PostSearchActivity f57726a;

    /* renamed from: b  reason: collision with root package name */
    public View f57727b;

    /* renamed from: c  reason: collision with root package name */
    public a f57728c;

    /* renamed from: d  reason: collision with root package name */
    public c f57729d;

    /* renamed from: e  reason: collision with root package name */
    public f f57730e;

    public g(PostSearchActivity postSearchActivity) {
        this.f57726a = postSearchActivity;
    }

    public int a() {
        return this.f57730e.d();
    }

    public void b() {
        this.f57729d.e();
    }

    public void c() {
        this.f57729d.f();
    }

    public void d() {
        this.f57728c.h();
    }

    public void e() {
        this.f57726a.setContentView(R.layout.post_search_activity);
        View findViewById = this.f57726a.findViewById(R.id.search_rootview);
        this.f57727b = findViewById;
        this.f57728c = new a(this.f57726a, findViewById);
        this.f57729d = new c(this.f57726a, this.f57727b);
        this.f57730e = new f(this.f57726a, this.f57727b);
    }

    public boolean f() {
        return this.f57729d.i();
    }

    public void g(int i2) {
        this.f57728c.j(i2);
        this.f57729d.j(i2);
        this.f57730e.g(i2);
        d.a.j0.s0.a.a(this.f57726a.getPageContext(), this.f57727b);
    }

    public void h() {
        a aVar = this.f57728c;
        if (aVar != null) {
            aVar.k();
        }
    }

    public void i(ArrayList<String> arrayList) {
        this.f57730e.j(false);
        this.f57729d.k(arrayList);
    }

    public void j(int i2, b bVar, boolean z) {
        this.f57730e.h(i2, bVar, z);
    }

    public void k(String str) {
        this.f57728c.l(str);
    }

    public void l(ViewPager.OnPageChangeListener onPageChangeListener) {
        f fVar = this.f57730e;
        if (fVar != null) {
            fVar.i(onPageChangeListener);
        }
    }

    public void m() {
        this.f57729d.m();
        this.f57729d.g();
    }

    public void n() {
        this.f57729d.p();
    }

    public void o(int i2) {
        this.f57728c.g();
        d();
        this.f57728c.f();
        this.f57730e.j(true);
        this.f57730e.k(i2);
    }
}

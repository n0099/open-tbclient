package d.a.n0.o2;

import android.view.View;
import androidx.viewpager.widget.ViewPager;
import com.baidu.tieba.R;
import com.baidu.tieba.postsearch.PostSearchActivity;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public PostSearchActivity f57898a;

    /* renamed from: b  reason: collision with root package name */
    public View f57899b;

    /* renamed from: c  reason: collision with root package name */
    public a f57900c;

    /* renamed from: d  reason: collision with root package name */
    public c f57901d;

    /* renamed from: e  reason: collision with root package name */
    public f f57902e;

    public g(PostSearchActivity postSearchActivity) {
        this.f57898a = postSearchActivity;
    }

    public int a() {
        return this.f57902e.d();
    }

    public void b() {
        this.f57901d.e();
    }

    public void c() {
        this.f57901d.f();
    }

    public void d() {
        this.f57900c.h();
    }

    public void e() {
        this.f57898a.setContentView(R.layout.post_search_activity);
        View findViewById = this.f57898a.findViewById(R.id.search_rootview);
        this.f57899b = findViewById;
        this.f57900c = new a(this.f57898a, findViewById);
        this.f57901d = new c(this.f57898a, this.f57899b);
        this.f57902e = new f(this.f57898a, this.f57899b);
    }

    public boolean f() {
        return this.f57901d.i();
    }

    public void g(int i2) {
        this.f57900c.j(i2);
        this.f57901d.j(i2);
        this.f57902e.g(i2);
        d.a.m0.s0.a.a(this.f57898a.getPageContext(), this.f57899b);
    }

    public void h() {
        a aVar = this.f57900c;
        if (aVar != null) {
            aVar.k();
        }
    }

    public void i(ArrayList<String> arrayList) {
        this.f57902e.j(false);
        this.f57901d.k(arrayList);
    }

    public void j(int i2, b bVar, boolean z) {
        this.f57902e.h(i2, bVar, z);
    }

    public void k(String str) {
        this.f57900c.l(str);
    }

    public void l(ViewPager.OnPageChangeListener onPageChangeListener) {
        f fVar = this.f57902e;
        if (fVar != null) {
            fVar.i(onPageChangeListener);
        }
    }

    public void m() {
        this.f57901d.m();
        this.f57901d.g();
    }

    public void n() {
        this.f57901d.p();
    }

    public void o(int i2) {
        this.f57900c.g();
        d();
        this.f57900c.f();
        this.f57902e.j(true);
        this.f57902e.k(i2);
    }
}

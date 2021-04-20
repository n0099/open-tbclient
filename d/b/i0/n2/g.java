package d.b.i0.n2;

import android.view.View;
import androidx.viewpager.widget.ViewPager;
import com.baidu.tieba.R;
import com.baidu.tieba.postsearch.PostSearchActivity;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public PostSearchActivity f58577a;

    /* renamed from: b  reason: collision with root package name */
    public View f58578b;

    /* renamed from: c  reason: collision with root package name */
    public a f58579c;

    /* renamed from: d  reason: collision with root package name */
    public c f58580d;

    /* renamed from: e  reason: collision with root package name */
    public f f58581e;

    public g(PostSearchActivity postSearchActivity) {
        this.f58577a = postSearchActivity;
    }

    public int a() {
        return this.f58581e.d();
    }

    public void b() {
        this.f58580d.e();
    }

    public void c() {
        this.f58580d.f();
    }

    public void d() {
        this.f58579c.h();
    }

    public void e() {
        this.f58577a.setContentView(R.layout.post_search_activity);
        View findViewById = this.f58577a.findViewById(R.id.search_rootview);
        this.f58578b = findViewById;
        this.f58579c = new a(this.f58577a, findViewById);
        this.f58580d = new c(this.f58577a, this.f58578b);
        this.f58581e = new f(this.f58577a, this.f58578b);
    }

    public boolean f() {
        return this.f58580d.i();
    }

    public void g(int i) {
        this.f58579c.j(i);
        this.f58580d.j(i);
        this.f58581e.g(i);
        d.b.h0.s0.a.a(this.f58577a.getPageContext(), this.f58578b);
    }

    public void h() {
        a aVar = this.f58579c;
        if (aVar != null) {
            aVar.k();
        }
    }

    public void i(ArrayList<String> arrayList) {
        this.f58581e.j(false);
        this.f58580d.k(arrayList);
    }

    public void j(int i, b bVar, boolean z) {
        this.f58581e.h(i, bVar, z);
    }

    public void k(String str) {
        this.f58579c.l(str);
    }

    public void l(ViewPager.OnPageChangeListener onPageChangeListener) {
        f fVar = this.f58581e;
        if (fVar != null) {
            fVar.i(onPageChangeListener);
        }
    }

    public void m() {
        this.f58580d.m();
        this.f58580d.g();
    }

    public void n() {
        this.f58580d.p();
    }

    public void o(int i) {
        this.f58579c.g();
        d();
        this.f58579c.f();
        this.f58581e.j(true);
        this.f58581e.k(i);
    }
}

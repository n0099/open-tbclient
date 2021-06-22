package d.a.o0.o2;

import android.view.View;
import androidx.viewpager.widget.ViewPager;
import com.baidu.tieba.R;
import com.baidu.tieba.postsearch.PostSearchActivity;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public PostSearchActivity f61714a;

    /* renamed from: b  reason: collision with root package name */
    public View f61715b;

    /* renamed from: c  reason: collision with root package name */
    public a f61716c;

    /* renamed from: d  reason: collision with root package name */
    public c f61717d;

    /* renamed from: e  reason: collision with root package name */
    public f f61718e;

    public g(PostSearchActivity postSearchActivity) {
        this.f61714a = postSearchActivity;
    }

    public int a() {
        return this.f61718e.d();
    }

    public void b() {
        this.f61717d.e();
    }

    public void c() {
        this.f61717d.f();
    }

    public void d() {
        this.f61716c.h();
    }

    public void e() {
        this.f61714a.setContentView(R.layout.post_search_activity);
        View findViewById = this.f61714a.findViewById(R.id.search_rootview);
        this.f61715b = findViewById;
        this.f61716c = new a(this.f61714a, findViewById);
        this.f61717d = new c(this.f61714a, this.f61715b);
        this.f61718e = new f(this.f61714a, this.f61715b);
    }

    public boolean f() {
        return this.f61717d.i();
    }

    public void g(int i2) {
        this.f61716c.j(i2);
        this.f61717d.j(i2);
        this.f61718e.g(i2);
        d.a.n0.s0.a.a(this.f61714a.getPageContext(), this.f61715b);
    }

    public void h() {
        a aVar = this.f61716c;
        if (aVar != null) {
            aVar.k();
        }
    }

    public void i(ArrayList<String> arrayList) {
        this.f61718e.j(false);
        this.f61717d.k(arrayList);
    }

    public void j(int i2, b bVar, boolean z) {
        this.f61718e.h(i2, bVar, z);
    }

    public void k(String str) {
        this.f61716c.l(str);
    }

    public void l(ViewPager.OnPageChangeListener onPageChangeListener) {
        f fVar = this.f61718e;
        if (fVar != null) {
            fVar.i(onPageChangeListener);
        }
    }

    public void m() {
        this.f61717d.m();
        this.f61717d.g();
    }

    public void n() {
        this.f61717d.p();
    }

    public void o(int i2) {
        this.f61716c.g();
        d();
        this.f61716c.f();
        this.f61718e.j(true);
        this.f61718e.k(i2);
    }
}

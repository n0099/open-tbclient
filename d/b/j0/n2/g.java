package d.b.j0.n2;

import android.view.View;
import androidx.viewpager.widget.ViewPager;
import com.baidu.tieba.R;
import com.baidu.tieba.postsearch.PostSearchActivity;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public PostSearchActivity f58998a;

    /* renamed from: b  reason: collision with root package name */
    public View f58999b;

    /* renamed from: c  reason: collision with root package name */
    public a f59000c;

    /* renamed from: d  reason: collision with root package name */
    public c f59001d;

    /* renamed from: e  reason: collision with root package name */
    public f f59002e;

    public g(PostSearchActivity postSearchActivity) {
        this.f58998a = postSearchActivity;
    }

    public int a() {
        return this.f59002e.d();
    }

    public void b() {
        this.f59001d.e();
    }

    public void c() {
        this.f59001d.f();
    }

    public void d() {
        this.f59000c.h();
    }

    public void e() {
        this.f58998a.setContentView(R.layout.post_search_activity);
        View findViewById = this.f58998a.findViewById(R.id.search_rootview);
        this.f58999b = findViewById;
        this.f59000c = new a(this.f58998a, findViewById);
        this.f59001d = new c(this.f58998a, this.f58999b);
        this.f59002e = new f(this.f58998a, this.f58999b);
    }

    public boolean f() {
        return this.f59001d.i();
    }

    public void g(int i) {
        this.f59000c.j(i);
        this.f59001d.j(i);
        this.f59002e.g(i);
        d.b.i0.s0.a.a(this.f58998a.getPageContext(), this.f58999b);
    }

    public void h() {
        a aVar = this.f59000c;
        if (aVar != null) {
            aVar.k();
        }
    }

    public void i(ArrayList<String> arrayList) {
        this.f59002e.j(false);
        this.f59001d.k(arrayList);
    }

    public void j(int i, b bVar, boolean z) {
        this.f59002e.h(i, bVar, z);
    }

    public void k(String str) {
        this.f59000c.l(str);
    }

    public void l(ViewPager.OnPageChangeListener onPageChangeListener) {
        f fVar = this.f59002e;
        if (fVar != null) {
            fVar.i(onPageChangeListener);
        }
    }

    public void m() {
        this.f59001d.m();
        this.f59001d.g();
    }

    public void n() {
        this.f59001d.p();
    }

    public void o(int i) {
        this.f59000c.g();
        d();
        this.f59000c.f();
        this.f59002e.j(true);
        this.f59002e.k(i);
    }
}

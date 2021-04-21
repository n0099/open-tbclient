package d.b.h0.m.a.a;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import com.baidu.swan.support.v4.app.Fragment;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public final j<?> f49814a;

    public i(j<?> jVar) {
        this.f49814a = jVar;
    }

    public static final i b(j<?> jVar) {
        return new i(jVar);
    }

    public void A() {
        this.f49814a.f49818d.U();
    }

    public View B(View view, String str, Context context, AttributeSet attributeSet) {
        return this.f49814a.f49818d.onCreateView(view, str, context, attributeSet);
    }

    public void C() {
        this.f49814a.v();
    }

    public void D(Parcelable parcelable, List<Fragment> list) {
        this.f49814a.f49818d.a0(parcelable, list);
    }

    public void E(d.b.h0.m.a.c.f<String, o> fVar) {
        this.f49814a.w(fVar);
    }

    public d.b.h0.m.a.c.f<String, o> F() {
        return this.f49814a.x();
    }

    public List<Fragment> G() {
        return this.f49814a.f49818d.b0();
    }

    public Parcelable H() {
        return this.f49814a.f49818d.d0();
    }

    public void a(Fragment fragment) {
        j<?> jVar = this.f49814a;
        jVar.f49818d.i(jVar, jVar, fragment);
    }

    public void c() {
        this.f49814a.f49818d.m();
    }

    public void d(Configuration configuration) {
        this.f49814a.f49818d.n(configuration);
    }

    public boolean e(MenuItem menuItem) {
        return this.f49814a.f49818d.o(menuItem);
    }

    public void f() {
        this.f49814a.f49818d.p();
    }

    public boolean g(Menu menu, MenuInflater menuInflater) {
        return this.f49814a.f49818d.q(menu, menuInflater);
    }

    public void h() {
        this.f49814a.f49818d.r();
    }

    public void i() {
        this.f49814a.f49818d.t();
    }

    public boolean j(MenuItem menuItem) {
        return this.f49814a.f49818d.u(menuItem);
    }

    public void k(Menu menu) {
        this.f49814a.f49818d.v(menu);
    }

    public void l() {
        this.f49814a.f49818d.w();
    }

    public boolean m(Menu menu) {
        return this.f49814a.f49818d.x(menu);
    }

    public void n() {
        this.f49814a.f49818d.y();
    }

    public void o() {
        this.f49814a.f49818d.z();
    }

    public void p() {
        this.f49814a.f49818d.A();
    }

    public void q() {
        this.f49814a.f49818d.B();
    }

    public void r() {
        this.f49814a.c();
    }

    public void s() {
        this.f49814a.d();
    }

    public void t(boolean z) {
        this.f49814a.e(z);
    }

    public void u(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        this.f49814a.f(str, fileDescriptor, printWriter, strArr);
    }

    public boolean v() {
        return this.f49814a.f49818d.D();
    }

    public List<Fragment> w(List<Fragment> list) {
        if (this.f49814a.f49818d.f49826d == null) {
            return null;
        }
        if (list == null) {
            list = new ArrayList<>(x());
        }
        list.addAll(this.f49814a.f49818d.f49826d);
        return list;
    }

    public int x() {
        ArrayList<Fragment> arrayList = this.f49814a.f49818d.f49826d;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    public k y() {
        return this.f49814a.i();
    }

    public o z() {
        return this.f49814a.l();
    }
}

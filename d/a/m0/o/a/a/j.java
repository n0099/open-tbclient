package d.a.m0.o.a.a;

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
public class j {

    /* renamed from: a  reason: collision with root package name */
    public final k<?> f52005a;

    public j(k<?> kVar) {
        this.f52005a = kVar;
    }

    public static final j b(k<?> kVar) {
        return new j(kVar);
    }

    public void A() {
        this.f52005a.f52009d.V();
    }

    public View B(View view, String str, Context context, AttributeSet attributeSet) {
        return this.f52005a.f52009d.onCreateView(view, str, context, attributeSet);
    }

    public void C() {
        this.f52005a.v();
    }

    public void D(Parcelable parcelable, List<Fragment> list) {
        this.f52005a.f52009d.b0(parcelable, list);
    }

    public void E(d.a.m0.o.a.c.f<String, p> fVar) {
        this.f52005a.w(fVar);
    }

    public d.a.m0.o.a.c.f<String, p> F() {
        return this.f52005a.x();
    }

    public List<Fragment> G() {
        return this.f52005a.f52009d.c0();
    }

    public Parcelable H() {
        return this.f52005a.f52009d.e0();
    }

    public void a(Fragment fragment) {
        k<?> kVar = this.f52005a;
        kVar.f52009d.j(kVar, kVar, fragment);
    }

    public void c() {
        this.f52005a.f52009d.n();
    }

    public void d(Configuration configuration) {
        this.f52005a.f52009d.o(configuration);
    }

    public boolean e(MenuItem menuItem) {
        return this.f52005a.f52009d.p(menuItem);
    }

    public void f() {
        this.f52005a.f52009d.q();
    }

    public boolean g(Menu menu, MenuInflater menuInflater) {
        return this.f52005a.f52009d.r(menu, menuInflater);
    }

    public void h() {
        this.f52005a.f52009d.s();
    }

    public void i() {
        this.f52005a.f52009d.u();
    }

    public boolean j(MenuItem menuItem) {
        return this.f52005a.f52009d.v(menuItem);
    }

    public void k(Menu menu) {
        this.f52005a.f52009d.w(menu);
    }

    public void l() {
        this.f52005a.f52009d.x();
    }

    public boolean m(Menu menu) {
        return this.f52005a.f52009d.y(menu);
    }

    public void n() {
        this.f52005a.f52009d.z();
    }

    public void o() {
        this.f52005a.f52009d.A();
    }

    public void p() {
        this.f52005a.f52009d.B();
    }

    public void q() {
        this.f52005a.f52009d.C();
    }

    public void r() {
        this.f52005a.c();
    }

    public void s() {
        this.f52005a.d();
    }

    public void t(boolean z) {
        this.f52005a.e(z);
    }

    public void u(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        this.f52005a.f(str, fileDescriptor, printWriter, strArr);
    }

    public boolean v() {
        return this.f52005a.f52009d.E();
    }

    public List<Fragment> w(List<Fragment> list) {
        if (this.f52005a.f52009d.f52017d == null) {
            return null;
        }
        if (list == null) {
            list = new ArrayList<>(x());
        }
        list.addAll(this.f52005a.f52009d.f52017d);
        return list;
    }

    public int x() {
        ArrayList<Fragment> arrayList = this.f52005a.f52009d.f52017d;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    public l y() {
        return this.f52005a.i();
    }

    public p z() {
        return this.f52005a.l();
    }
}

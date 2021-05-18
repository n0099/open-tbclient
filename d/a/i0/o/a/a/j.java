package d.a.i0.o.a.a;

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
    public final k<?> f48047a;

    public j(k<?> kVar) {
        this.f48047a = kVar;
    }

    public static final j b(k<?> kVar) {
        return new j(kVar);
    }

    public void A() {
        this.f48047a.f48051d.V();
    }

    public View B(View view, String str, Context context, AttributeSet attributeSet) {
        return this.f48047a.f48051d.onCreateView(view, str, context, attributeSet);
    }

    public void C() {
        this.f48047a.v();
    }

    public void D(Parcelable parcelable, List<Fragment> list) {
        this.f48047a.f48051d.b0(parcelable, list);
    }

    public void E(d.a.i0.o.a.c.f<String, p> fVar) {
        this.f48047a.w(fVar);
    }

    public d.a.i0.o.a.c.f<String, p> F() {
        return this.f48047a.x();
    }

    public List<Fragment> G() {
        return this.f48047a.f48051d.c0();
    }

    public Parcelable H() {
        return this.f48047a.f48051d.e0();
    }

    public void a(Fragment fragment) {
        k<?> kVar = this.f48047a;
        kVar.f48051d.j(kVar, kVar, fragment);
    }

    public void c() {
        this.f48047a.f48051d.n();
    }

    public void d(Configuration configuration) {
        this.f48047a.f48051d.o(configuration);
    }

    public boolean e(MenuItem menuItem) {
        return this.f48047a.f48051d.p(menuItem);
    }

    public void f() {
        this.f48047a.f48051d.q();
    }

    public boolean g(Menu menu, MenuInflater menuInflater) {
        return this.f48047a.f48051d.r(menu, menuInflater);
    }

    public void h() {
        this.f48047a.f48051d.s();
    }

    public void i() {
        this.f48047a.f48051d.u();
    }

    public boolean j(MenuItem menuItem) {
        return this.f48047a.f48051d.v(menuItem);
    }

    public void k(Menu menu) {
        this.f48047a.f48051d.w(menu);
    }

    public void l() {
        this.f48047a.f48051d.x();
    }

    public boolean m(Menu menu) {
        return this.f48047a.f48051d.y(menu);
    }

    public void n() {
        this.f48047a.f48051d.z();
    }

    public void o() {
        this.f48047a.f48051d.A();
    }

    public void p() {
        this.f48047a.f48051d.B();
    }

    public void q() {
        this.f48047a.f48051d.C();
    }

    public void r() {
        this.f48047a.c();
    }

    public void s() {
        this.f48047a.d();
    }

    public void t(boolean z) {
        this.f48047a.e(z);
    }

    public void u(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        this.f48047a.f(str, fileDescriptor, printWriter, strArr);
    }

    public boolean v() {
        return this.f48047a.f48051d.E();
    }

    public List<Fragment> w(List<Fragment> list) {
        if (this.f48047a.f48051d.f48059d == null) {
            return null;
        }
        if (list == null) {
            list = new ArrayList<>(x());
        }
        list.addAll(this.f48047a.f48051d.f48059d);
        return list;
    }

    public int x() {
        ArrayList<Fragment> arrayList = this.f48047a.f48051d.f48059d;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    public l y() {
        return this.f48047a.i();
    }

    public p z() {
        return this.f48047a.l();
    }
}

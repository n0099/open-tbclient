package d.a.l0.o.a.a;

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
    public final k<?> f48223a;

    public j(k<?> kVar) {
        this.f48223a = kVar;
    }

    public static final j b(k<?> kVar) {
        return new j(kVar);
    }

    public void A() {
        this.f48223a.f48227d.V();
    }

    public View B(View view, String str, Context context, AttributeSet attributeSet) {
        return this.f48223a.f48227d.onCreateView(view, str, context, attributeSet);
    }

    public void C() {
        this.f48223a.v();
    }

    public void D(Parcelable parcelable, List<Fragment> list) {
        this.f48223a.f48227d.b0(parcelable, list);
    }

    public void E(d.a.l0.o.a.c.f<String, p> fVar) {
        this.f48223a.w(fVar);
    }

    public d.a.l0.o.a.c.f<String, p> F() {
        return this.f48223a.x();
    }

    public List<Fragment> G() {
        return this.f48223a.f48227d.c0();
    }

    public Parcelable H() {
        return this.f48223a.f48227d.e0();
    }

    public void a(Fragment fragment) {
        k<?> kVar = this.f48223a;
        kVar.f48227d.j(kVar, kVar, fragment);
    }

    public void c() {
        this.f48223a.f48227d.n();
    }

    public void d(Configuration configuration) {
        this.f48223a.f48227d.o(configuration);
    }

    public boolean e(MenuItem menuItem) {
        return this.f48223a.f48227d.p(menuItem);
    }

    public void f() {
        this.f48223a.f48227d.q();
    }

    public boolean g(Menu menu, MenuInflater menuInflater) {
        return this.f48223a.f48227d.r(menu, menuInflater);
    }

    public void h() {
        this.f48223a.f48227d.s();
    }

    public void i() {
        this.f48223a.f48227d.u();
    }

    public boolean j(MenuItem menuItem) {
        return this.f48223a.f48227d.v(menuItem);
    }

    public void k(Menu menu) {
        this.f48223a.f48227d.w(menu);
    }

    public void l() {
        this.f48223a.f48227d.x();
    }

    public boolean m(Menu menu) {
        return this.f48223a.f48227d.y(menu);
    }

    public void n() {
        this.f48223a.f48227d.z();
    }

    public void o() {
        this.f48223a.f48227d.A();
    }

    public void p() {
        this.f48223a.f48227d.B();
    }

    public void q() {
        this.f48223a.f48227d.C();
    }

    public void r() {
        this.f48223a.c();
    }

    public void s() {
        this.f48223a.d();
    }

    public void t(boolean z) {
        this.f48223a.e(z);
    }

    public void u(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        this.f48223a.f(str, fileDescriptor, printWriter, strArr);
    }

    public boolean v() {
        return this.f48223a.f48227d.E();
    }

    public List<Fragment> w(List<Fragment> list) {
        if (this.f48223a.f48227d.f48235d == null) {
            return null;
        }
        if (list == null) {
            list = new ArrayList<>(x());
        }
        list.addAll(this.f48223a.f48227d.f48235d);
        return list;
    }

    public int x() {
        ArrayList<Fragment> arrayList = this.f48223a.f48227d.f48235d;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    public l y() {
        return this.f48223a.i();
    }

    public p z() {
        return this.f48223a.l();
    }
}

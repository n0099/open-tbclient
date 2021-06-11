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
    public final k<?> f51897a;

    public j(k<?> kVar) {
        this.f51897a = kVar;
    }

    public static final j b(k<?> kVar) {
        return new j(kVar);
    }

    public void A() {
        this.f51897a.f51901d.V();
    }

    public View B(View view, String str, Context context, AttributeSet attributeSet) {
        return this.f51897a.f51901d.onCreateView(view, str, context, attributeSet);
    }

    public void C() {
        this.f51897a.v();
    }

    public void D(Parcelable parcelable, List<Fragment> list) {
        this.f51897a.f51901d.b0(parcelable, list);
    }

    public void E(d.a.l0.o.a.c.f<String, p> fVar) {
        this.f51897a.w(fVar);
    }

    public d.a.l0.o.a.c.f<String, p> F() {
        return this.f51897a.x();
    }

    public List<Fragment> G() {
        return this.f51897a.f51901d.c0();
    }

    public Parcelable H() {
        return this.f51897a.f51901d.e0();
    }

    public void a(Fragment fragment) {
        k<?> kVar = this.f51897a;
        kVar.f51901d.j(kVar, kVar, fragment);
    }

    public void c() {
        this.f51897a.f51901d.n();
    }

    public void d(Configuration configuration) {
        this.f51897a.f51901d.o(configuration);
    }

    public boolean e(MenuItem menuItem) {
        return this.f51897a.f51901d.p(menuItem);
    }

    public void f() {
        this.f51897a.f51901d.q();
    }

    public boolean g(Menu menu, MenuInflater menuInflater) {
        return this.f51897a.f51901d.r(menu, menuInflater);
    }

    public void h() {
        this.f51897a.f51901d.s();
    }

    public void i() {
        this.f51897a.f51901d.u();
    }

    public boolean j(MenuItem menuItem) {
        return this.f51897a.f51901d.v(menuItem);
    }

    public void k(Menu menu) {
        this.f51897a.f51901d.w(menu);
    }

    public void l() {
        this.f51897a.f51901d.x();
    }

    public boolean m(Menu menu) {
        return this.f51897a.f51901d.y(menu);
    }

    public void n() {
        this.f51897a.f51901d.z();
    }

    public void o() {
        this.f51897a.f51901d.A();
    }

    public void p() {
        this.f51897a.f51901d.B();
    }

    public void q() {
        this.f51897a.f51901d.C();
    }

    public void r() {
        this.f51897a.c();
    }

    public void s() {
        this.f51897a.d();
    }

    public void t(boolean z) {
        this.f51897a.e(z);
    }

    public void u(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        this.f51897a.f(str, fileDescriptor, printWriter, strArr);
    }

    public boolean v() {
        return this.f51897a.f51901d.E();
    }

    public List<Fragment> w(List<Fragment> list) {
        if (this.f51897a.f51901d.f51909d == null) {
            return null;
        }
        if (list == null) {
            list = new ArrayList<>(x());
        }
        list.addAll(this.f51897a.f51901d.f51909d);
        return list;
    }

    public int x() {
        ArrayList<Fragment> arrayList = this.f51897a.f51901d.f51909d;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    public l y() {
        return this.f51897a.i();
    }

    public p z() {
        return this.f51897a.l();
    }
}

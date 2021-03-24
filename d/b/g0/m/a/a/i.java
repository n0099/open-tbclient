package d.b.g0.m.a.a;

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
    public final j<?> f49092a;

    public i(j<?> jVar) {
        this.f49092a = jVar;
    }

    public static final i b(j<?> jVar) {
        return new i(jVar);
    }

    public void A() {
        this.f49092a.f49096d.U();
    }

    public View B(View view, String str, Context context, AttributeSet attributeSet) {
        return this.f49092a.f49096d.onCreateView(view, str, context, attributeSet);
    }

    public void C() {
        this.f49092a.v();
    }

    public void D(Parcelable parcelable, List<Fragment> list) {
        this.f49092a.f49096d.a0(parcelable, list);
    }

    public void E(d.b.g0.m.a.c.f<String, o> fVar) {
        this.f49092a.w(fVar);
    }

    public d.b.g0.m.a.c.f<String, o> F() {
        return this.f49092a.x();
    }

    public List<Fragment> G() {
        return this.f49092a.f49096d.b0();
    }

    public Parcelable H() {
        return this.f49092a.f49096d.d0();
    }

    public void a(Fragment fragment) {
        j<?> jVar = this.f49092a;
        jVar.f49096d.i(jVar, jVar, fragment);
    }

    public void c() {
        this.f49092a.f49096d.m();
    }

    public void d(Configuration configuration) {
        this.f49092a.f49096d.n(configuration);
    }

    public boolean e(MenuItem menuItem) {
        return this.f49092a.f49096d.o(menuItem);
    }

    public void f() {
        this.f49092a.f49096d.p();
    }

    public boolean g(Menu menu, MenuInflater menuInflater) {
        return this.f49092a.f49096d.q(menu, menuInflater);
    }

    public void h() {
        this.f49092a.f49096d.r();
    }

    public void i() {
        this.f49092a.f49096d.t();
    }

    public boolean j(MenuItem menuItem) {
        return this.f49092a.f49096d.u(menuItem);
    }

    public void k(Menu menu) {
        this.f49092a.f49096d.v(menu);
    }

    public void l() {
        this.f49092a.f49096d.w();
    }

    public boolean m(Menu menu) {
        return this.f49092a.f49096d.x(menu);
    }

    public void n() {
        this.f49092a.f49096d.y();
    }

    public void o() {
        this.f49092a.f49096d.z();
    }

    public void p() {
        this.f49092a.f49096d.A();
    }

    public void q() {
        this.f49092a.f49096d.B();
    }

    public void r() {
        this.f49092a.c();
    }

    public void s() {
        this.f49092a.d();
    }

    public void t(boolean z) {
        this.f49092a.e(z);
    }

    public void u(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        this.f49092a.f(str, fileDescriptor, printWriter, strArr);
    }

    public boolean v() {
        return this.f49092a.f49096d.D();
    }

    public List<Fragment> w(List<Fragment> list) {
        if (this.f49092a.f49096d.f49104d == null) {
            return null;
        }
        if (list == null) {
            list = new ArrayList<>(x());
        }
        list.addAll(this.f49092a.f49096d.f49104d);
        return list;
    }

    public int x() {
        ArrayList<Fragment> arrayList = this.f49092a.f49096d.f49104d;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    public k y() {
        return this.f49092a.i();
    }

    public o z() {
        return this.f49092a.l();
    }
}

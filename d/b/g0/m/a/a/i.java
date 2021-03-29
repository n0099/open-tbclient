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
    public final j<?> f49093a;

    public i(j<?> jVar) {
        this.f49093a = jVar;
    }

    public static final i b(j<?> jVar) {
        return new i(jVar);
    }

    public void A() {
        this.f49093a.f49097d.U();
    }

    public View B(View view, String str, Context context, AttributeSet attributeSet) {
        return this.f49093a.f49097d.onCreateView(view, str, context, attributeSet);
    }

    public void C() {
        this.f49093a.v();
    }

    public void D(Parcelable parcelable, List<Fragment> list) {
        this.f49093a.f49097d.a0(parcelable, list);
    }

    public void E(d.b.g0.m.a.c.f<String, o> fVar) {
        this.f49093a.w(fVar);
    }

    public d.b.g0.m.a.c.f<String, o> F() {
        return this.f49093a.x();
    }

    public List<Fragment> G() {
        return this.f49093a.f49097d.b0();
    }

    public Parcelable H() {
        return this.f49093a.f49097d.d0();
    }

    public void a(Fragment fragment) {
        j<?> jVar = this.f49093a;
        jVar.f49097d.i(jVar, jVar, fragment);
    }

    public void c() {
        this.f49093a.f49097d.m();
    }

    public void d(Configuration configuration) {
        this.f49093a.f49097d.n(configuration);
    }

    public boolean e(MenuItem menuItem) {
        return this.f49093a.f49097d.o(menuItem);
    }

    public void f() {
        this.f49093a.f49097d.p();
    }

    public boolean g(Menu menu, MenuInflater menuInflater) {
        return this.f49093a.f49097d.q(menu, menuInflater);
    }

    public void h() {
        this.f49093a.f49097d.r();
    }

    public void i() {
        this.f49093a.f49097d.t();
    }

    public boolean j(MenuItem menuItem) {
        return this.f49093a.f49097d.u(menuItem);
    }

    public void k(Menu menu) {
        this.f49093a.f49097d.v(menu);
    }

    public void l() {
        this.f49093a.f49097d.w();
    }

    public boolean m(Menu menu) {
        return this.f49093a.f49097d.x(menu);
    }

    public void n() {
        this.f49093a.f49097d.y();
    }

    public void o() {
        this.f49093a.f49097d.z();
    }

    public void p() {
        this.f49093a.f49097d.A();
    }

    public void q() {
        this.f49093a.f49097d.B();
    }

    public void r() {
        this.f49093a.c();
    }

    public void s() {
        this.f49093a.d();
    }

    public void t(boolean z) {
        this.f49093a.e(z);
    }

    public void u(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        this.f49093a.f(str, fileDescriptor, printWriter, strArr);
    }

    public boolean v() {
        return this.f49093a.f49097d.D();
    }

    public List<Fragment> w(List<Fragment> list) {
        if (this.f49093a.f49097d.f49105d == null) {
            return null;
        }
        if (list == null) {
            list = new ArrayList<>(x());
        }
        list.addAll(this.f49093a.f49097d.f49105d);
        return list;
    }

    public int x() {
        ArrayList<Fragment> arrayList = this.f49093a.f49097d.f49105d;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    public k y() {
        return this.f49093a.i();
    }

    public o z() {
        return this.f49093a.l();
    }
}

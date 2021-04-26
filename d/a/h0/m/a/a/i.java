package d.a.h0.m.a.a;

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
    public final j<?> f47332a;

    public i(j<?> jVar) {
        this.f47332a = jVar;
    }

    public static final i b(j<?> jVar) {
        return new i(jVar);
    }

    public void A() {
        this.f47332a.f47336d.U();
    }

    public View B(View view, String str, Context context, AttributeSet attributeSet) {
        return this.f47332a.f47336d.onCreateView(view, str, context, attributeSet);
    }

    public void C() {
        this.f47332a.v();
    }

    public void D(Parcelable parcelable, List<Fragment> list) {
        this.f47332a.f47336d.a0(parcelable, list);
    }

    public void E(d.a.h0.m.a.c.f<String, o> fVar) {
        this.f47332a.w(fVar);
    }

    public d.a.h0.m.a.c.f<String, o> F() {
        return this.f47332a.x();
    }

    public List<Fragment> G() {
        return this.f47332a.f47336d.b0();
    }

    public Parcelable H() {
        return this.f47332a.f47336d.d0();
    }

    public void a(Fragment fragment) {
        j<?> jVar = this.f47332a;
        jVar.f47336d.i(jVar, jVar, fragment);
    }

    public void c() {
        this.f47332a.f47336d.m();
    }

    public void d(Configuration configuration) {
        this.f47332a.f47336d.n(configuration);
    }

    public boolean e(MenuItem menuItem) {
        return this.f47332a.f47336d.o(menuItem);
    }

    public void f() {
        this.f47332a.f47336d.p();
    }

    public boolean g(Menu menu, MenuInflater menuInflater) {
        return this.f47332a.f47336d.q(menu, menuInflater);
    }

    public void h() {
        this.f47332a.f47336d.r();
    }

    public void i() {
        this.f47332a.f47336d.t();
    }

    public boolean j(MenuItem menuItem) {
        return this.f47332a.f47336d.u(menuItem);
    }

    public void k(Menu menu) {
        this.f47332a.f47336d.v(menu);
    }

    public void l() {
        this.f47332a.f47336d.w();
    }

    public boolean m(Menu menu) {
        return this.f47332a.f47336d.x(menu);
    }

    public void n() {
        this.f47332a.f47336d.y();
    }

    public void o() {
        this.f47332a.f47336d.z();
    }

    public void p() {
        this.f47332a.f47336d.A();
    }

    public void q() {
        this.f47332a.f47336d.B();
    }

    public void r() {
        this.f47332a.c();
    }

    public void s() {
        this.f47332a.d();
    }

    public void t(boolean z) {
        this.f47332a.e(z);
    }

    public void u(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        this.f47332a.f(str, fileDescriptor, printWriter, strArr);
    }

    public boolean v() {
        return this.f47332a.f47336d.D();
    }

    public List<Fragment> w(List<Fragment> list) {
        if (this.f47332a.f47336d.f47344d == null) {
            return null;
        }
        if (list == null) {
            list = new ArrayList<>(x());
        }
        list.addAll(this.f47332a.f47336d.f47344d);
        return list;
    }

    public int x() {
        ArrayList<Fragment> arrayList = this.f47332a.f47336d.f47344d;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    public k y() {
        return this.f47332a.i();
    }

    public o z() {
        return this.f47332a.l();
    }
}

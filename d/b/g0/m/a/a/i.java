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
    public final j<?> f49485a;

    public i(j<?> jVar) {
        this.f49485a = jVar;
    }

    public static final i b(j<?> jVar) {
        return new i(jVar);
    }

    public void A() {
        this.f49485a.f49489d.U();
    }

    public View B(View view, String str, Context context, AttributeSet attributeSet) {
        return this.f49485a.f49489d.onCreateView(view, str, context, attributeSet);
    }

    public void C() {
        this.f49485a.v();
    }

    public void D(Parcelable parcelable, List<Fragment> list) {
        this.f49485a.f49489d.a0(parcelable, list);
    }

    public void E(d.b.g0.m.a.c.f<String, o> fVar) {
        this.f49485a.w(fVar);
    }

    public d.b.g0.m.a.c.f<String, o> F() {
        return this.f49485a.x();
    }

    public List<Fragment> G() {
        return this.f49485a.f49489d.b0();
    }

    public Parcelable H() {
        return this.f49485a.f49489d.d0();
    }

    public void a(Fragment fragment) {
        j<?> jVar = this.f49485a;
        jVar.f49489d.i(jVar, jVar, fragment);
    }

    public void c() {
        this.f49485a.f49489d.m();
    }

    public void d(Configuration configuration) {
        this.f49485a.f49489d.n(configuration);
    }

    public boolean e(MenuItem menuItem) {
        return this.f49485a.f49489d.o(menuItem);
    }

    public void f() {
        this.f49485a.f49489d.p();
    }

    public boolean g(Menu menu, MenuInflater menuInflater) {
        return this.f49485a.f49489d.q(menu, menuInflater);
    }

    public void h() {
        this.f49485a.f49489d.r();
    }

    public void i() {
        this.f49485a.f49489d.t();
    }

    public boolean j(MenuItem menuItem) {
        return this.f49485a.f49489d.u(menuItem);
    }

    public void k(Menu menu) {
        this.f49485a.f49489d.v(menu);
    }

    public void l() {
        this.f49485a.f49489d.w();
    }

    public boolean m(Menu menu) {
        return this.f49485a.f49489d.x(menu);
    }

    public void n() {
        this.f49485a.f49489d.y();
    }

    public void o() {
        this.f49485a.f49489d.z();
    }

    public void p() {
        this.f49485a.f49489d.A();
    }

    public void q() {
        this.f49485a.f49489d.B();
    }

    public void r() {
        this.f49485a.c();
    }

    public void s() {
        this.f49485a.d();
    }

    public void t(boolean z) {
        this.f49485a.e(z);
    }

    public void u(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        this.f49485a.f(str, fileDescriptor, printWriter, strArr);
    }

    public boolean v() {
        return this.f49485a.f49489d.D();
    }

    public List<Fragment> w(List<Fragment> list) {
        if (this.f49485a.f49489d.f49497d == null) {
            return null;
        }
        if (list == null) {
            list = new ArrayList<>(x());
        }
        list.addAll(this.f49485a.f49489d.f49497d);
        return list;
    }

    public int x() {
        ArrayList<Fragment> arrayList = this.f49485a.f49489d.f49497d;
        if (arrayList == null) {
            return 0;
        }
        return arrayList.size();
    }

    public k y() {
        return this.f49485a.i();
    }

    public o z() {
        return this.f49485a.l();
    }
}

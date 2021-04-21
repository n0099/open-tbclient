package d.b.j0.d2.o;

import android.graphics.Rect;
import androidx.lifecycle.MutableLiveData;
import com.baidu.tbadk.core.util.ListUtils;
import d.b.i0.r.q.a2;
import java.util.LinkedList;
/* loaded from: classes3.dex */
public class k {

    /* renamed from: a  reason: collision with root package name */
    public d.b.j0.d2.h.e f55024a;

    /* renamed from: b  reason: collision with root package name */
    public d.b.j0.d2.h.e f55025b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f55026c;

    /* renamed from: e  reason: collision with root package name */
    public Rect f55028e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f55029f;
    public MutableLiveData<Boolean> l;
    public MutableLiveData<Integer> m;

    /* renamed from: d  reason: collision with root package name */
    public MutableLiveData<a2> f55027d = new MutableLiveData<>();

    /* renamed from: g  reason: collision with root package name */
    public LinkedList<d.b.j0.d2.h.e> f55030g = new LinkedList<>();

    /* renamed from: h  reason: collision with root package name */
    public MutableLiveData<a2> f55031h = new MutableLiveData<>();
    public MutableLiveData<a2> i = new MutableLiveData<>();
    public MutableLiveData<Boolean> j = new MutableLiveData<>();
    public MutableLiveData<Boolean> k = new MutableLiveData<>();

    public k() {
        new MutableLiveData();
        this.l = new MutableLiveData<>();
        this.m = new MutableLiveData<>();
    }

    public MutableLiveData<Integer> a() {
        return this.m;
    }

    public d.b.j0.d2.h.e b() {
        return this.f55025b;
    }

    public d.b.j0.d2.h.e c() {
        return this.f55024a;
    }

    public MutableLiveData<Boolean> d() {
        return this.j;
    }

    public MutableLiveData<Boolean> e() {
        return this.k;
    }

    public MutableLiveData<a2> f() {
        return this.i;
    }

    public Rect g() {
        return this.f55028e;
    }

    public MutableLiveData<a2> h() {
        return this.f55031h;
    }

    public MutableLiveData<a2> i() {
        return this.f55027d;
    }

    public LinkedList<d.b.j0.d2.h.e> j() {
        return this.f55030g;
    }

    public boolean k() {
        return this.f55026c;
    }

    public boolean l() {
        return this.f55029f;
    }

    public MutableLiveData<Boolean> m() {
        return this.l;
    }

    public void n(d.b.j0.d2.h.e eVar) {
        this.f55025b = eVar;
        if (eVar != null) {
            this.f55027d.setValue(eVar.L());
            if (ListUtils.isEmpty(eVar.f())) {
                return;
            }
            u(eVar.f().get(0));
        }
    }

    public void o(d.b.j0.d2.h.e eVar) {
        this.f55024a = eVar;
        n(eVar);
        this.f55031h.setValue(null);
        this.f55027d.setValue(eVar.L());
    }

    public void p(boolean z) {
        this.f55026c = z;
    }

    public void q(boolean z) {
        this.j.setValue(Boolean.valueOf(z));
    }

    public void r(boolean z) {
        this.l.setValue(Boolean.valueOf(z));
    }

    public void s(boolean z) {
        this.k.postValue(Boolean.valueOf(z));
    }

    public void t(boolean z) {
        this.f55029f = z;
    }

    public void u(a2 a2Var) {
        this.i.setValue(a2Var);
    }

    public void v(Rect rect) {
        this.f55028e = rect;
    }

    public void w(a2 a2Var) {
        this.f55031h.setValue(a2Var);
    }
}

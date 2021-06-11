package d.a.n0.e2.o;

import android.graphics.Rect;
import androidx.lifecycle.MutableLiveData;
import com.baidu.tbadk.core.util.ListUtils;
import d.a.m0.r.q.a2;
import java.util.LinkedList;
/* loaded from: classes5.dex */
public class k {

    /* renamed from: a  reason: collision with root package name */
    public d.a.n0.e2.h.e f57451a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.n0.e2.h.e f57452b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f57453c;

    /* renamed from: e  reason: collision with root package name */
    public Rect f57455e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f57456f;
    public MutableLiveData<Boolean> l;
    public MutableLiveData<Integer> m;

    /* renamed from: d  reason: collision with root package name */
    public MutableLiveData<a2> f57454d = new MutableLiveData<>();

    /* renamed from: g  reason: collision with root package name */
    public LinkedList<d.a.n0.e2.h.e> f57457g = new LinkedList<>();

    /* renamed from: h  reason: collision with root package name */
    public MutableLiveData<a2> f57458h = new MutableLiveData<>();

    /* renamed from: i  reason: collision with root package name */
    public MutableLiveData<a2> f57459i = new MutableLiveData<>();
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

    public d.a.n0.e2.h.e b() {
        return this.f57452b;
    }

    public d.a.n0.e2.h.e c() {
        return this.f57451a;
    }

    public MutableLiveData<Boolean> d() {
        return this.j;
    }

    public MutableLiveData<Boolean> e() {
        return this.k;
    }

    public MutableLiveData<a2> f() {
        return this.f57459i;
    }

    public Rect g() {
        return this.f57455e;
    }

    public MutableLiveData<a2> h() {
        return this.f57458h;
    }

    public MutableLiveData<a2> i() {
        return this.f57454d;
    }

    public LinkedList<d.a.n0.e2.h.e> j() {
        return this.f57457g;
    }

    public boolean k() {
        return this.f57453c;
    }

    public boolean l() {
        return this.f57456f;
    }

    public MutableLiveData<Boolean> m() {
        return this.l;
    }

    public void n(d.a.n0.e2.h.e eVar) {
        this.f57452b = eVar;
        if (eVar != null) {
            this.f57454d.setValue(eVar.L());
            if (ListUtils.isEmpty(eVar.f())) {
                return;
            }
            u(eVar.f().get(0));
        }
    }

    public void o(d.a.n0.e2.h.e eVar) {
        this.f57451a = eVar;
        n(eVar);
        this.f57458h.setValue(null);
        this.f57454d.setValue(eVar.L());
    }

    public void p(boolean z) {
        this.f57453c = z;
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
        this.f57456f = z;
    }

    public void u(a2 a2Var) {
        this.f57459i.setValue(a2Var);
    }

    public void v(Rect rect) {
        this.f57455e = rect;
    }

    public void w(a2 a2Var) {
        this.f57458h.setValue(a2Var);
    }
}

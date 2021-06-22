package d.a.o0.e2.o;

import android.graphics.Rect;
import androidx.lifecycle.MutableLiveData;
import com.baidu.tbadk.core.util.ListUtils;
import d.a.n0.r.q.a2;
import java.util.LinkedList;
/* loaded from: classes5.dex */
public class k {

    /* renamed from: a  reason: collision with root package name */
    public d.a.o0.e2.h.e f57576a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.o0.e2.h.e f57577b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f57578c;

    /* renamed from: e  reason: collision with root package name */
    public Rect f57580e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f57581f;
    public MutableLiveData<Boolean> l;
    public MutableLiveData<Integer> m;

    /* renamed from: d  reason: collision with root package name */
    public MutableLiveData<a2> f57579d = new MutableLiveData<>();

    /* renamed from: g  reason: collision with root package name */
    public LinkedList<d.a.o0.e2.h.e> f57582g = new LinkedList<>();

    /* renamed from: h  reason: collision with root package name */
    public MutableLiveData<a2> f57583h = new MutableLiveData<>();

    /* renamed from: i  reason: collision with root package name */
    public MutableLiveData<a2> f57584i = new MutableLiveData<>();
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

    public d.a.o0.e2.h.e b() {
        return this.f57577b;
    }

    public d.a.o0.e2.h.e c() {
        return this.f57576a;
    }

    public MutableLiveData<Boolean> d() {
        return this.j;
    }

    public MutableLiveData<Boolean> e() {
        return this.k;
    }

    public MutableLiveData<a2> f() {
        return this.f57584i;
    }

    public Rect g() {
        return this.f57580e;
    }

    public MutableLiveData<a2> h() {
        return this.f57583h;
    }

    public MutableLiveData<a2> i() {
        return this.f57579d;
    }

    public LinkedList<d.a.o0.e2.h.e> j() {
        return this.f57582g;
    }

    public boolean k() {
        return this.f57578c;
    }

    public boolean l() {
        return this.f57581f;
    }

    public MutableLiveData<Boolean> m() {
        return this.l;
    }

    public void n(d.a.o0.e2.h.e eVar) {
        this.f57577b = eVar;
        if (eVar != null) {
            this.f57579d.setValue(eVar.L());
            if (ListUtils.isEmpty(eVar.f())) {
                return;
            }
            u(eVar.f().get(0));
        }
    }

    public void o(d.a.o0.e2.h.e eVar) {
        this.f57576a = eVar;
        n(eVar);
        this.f57583h.setValue(null);
        this.f57579d.setValue(eVar.L());
    }

    public void p(boolean z) {
        this.f57578c = z;
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
        this.f57581f = z;
    }

    public void u(a2 a2Var) {
        this.f57584i.setValue(a2Var);
    }

    public void v(Rect rect) {
        this.f57580e = rect;
    }

    public void w(a2 a2Var) {
        this.f57583h.setValue(a2Var);
    }
}

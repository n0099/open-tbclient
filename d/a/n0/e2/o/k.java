package d.a.n0.e2.o;

import android.graphics.Rect;
import androidx.lifecycle.MutableLiveData;
import com.baidu.tbadk.core.util.ListUtils;
import d.a.m0.r.q.a2;
import java.util.LinkedList;
/* loaded from: classes5.dex */
public class k {

    /* renamed from: a  reason: collision with root package name */
    public d.a.n0.e2.h.e f53762a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.n0.e2.h.e f53763b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f53764c;

    /* renamed from: e  reason: collision with root package name */
    public Rect f53766e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f53767f;
    public MutableLiveData<Boolean> l;
    public MutableLiveData<Integer> m;

    /* renamed from: d  reason: collision with root package name */
    public MutableLiveData<a2> f53765d = new MutableLiveData<>();

    /* renamed from: g  reason: collision with root package name */
    public LinkedList<d.a.n0.e2.h.e> f53768g = new LinkedList<>();

    /* renamed from: h  reason: collision with root package name */
    public MutableLiveData<a2> f53769h = new MutableLiveData<>();

    /* renamed from: i  reason: collision with root package name */
    public MutableLiveData<a2> f53770i = new MutableLiveData<>();
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
        return this.f53763b;
    }

    public d.a.n0.e2.h.e c() {
        return this.f53762a;
    }

    public MutableLiveData<Boolean> d() {
        return this.j;
    }

    public MutableLiveData<Boolean> e() {
        return this.k;
    }

    public MutableLiveData<a2> f() {
        return this.f53770i;
    }

    public Rect g() {
        return this.f53766e;
    }

    public MutableLiveData<a2> h() {
        return this.f53769h;
    }

    public MutableLiveData<a2> i() {
        return this.f53765d;
    }

    public LinkedList<d.a.n0.e2.h.e> j() {
        return this.f53768g;
    }

    public boolean k() {
        return this.f53764c;
    }

    public boolean l() {
        return this.f53767f;
    }

    public MutableLiveData<Boolean> m() {
        return this.l;
    }

    public void n(d.a.n0.e2.h.e eVar) {
        this.f53763b = eVar;
        if (eVar != null) {
            this.f53765d.setValue(eVar.L());
            if (ListUtils.isEmpty(eVar.f())) {
                return;
            }
            u(eVar.f().get(0));
        }
    }

    public void o(d.a.n0.e2.h.e eVar) {
        this.f53762a = eVar;
        n(eVar);
        this.f53769h.setValue(null);
        this.f53765d.setValue(eVar.L());
    }

    public void p(boolean z) {
        this.f53764c = z;
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
        this.f53767f = z;
    }

    public void u(a2 a2Var) {
        this.f53770i.setValue(a2Var);
    }

    public void v(Rect rect) {
        this.f53766e = rect;
    }

    public void w(a2 a2Var) {
        this.f53769h.setValue(a2Var);
    }
}

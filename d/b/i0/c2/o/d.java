package d.b.i0.c2.o;

import android.graphics.Rect;
import androidx.lifecycle.MutableLiveData;
import com.baidu.tbadk.core.util.ListUtils;
import d.b.h0.r.q.a2;
import java.util.LinkedList;
/* loaded from: classes5.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public d.b.i0.c2.h.e f53179a;

    /* renamed from: b  reason: collision with root package name */
    public d.b.i0.c2.h.e f53180b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f53181c;

    /* renamed from: e  reason: collision with root package name */
    public Rect f53183e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f53184f;
    public MutableLiveData<Boolean> l;
    public MutableLiveData<Integer> m;

    /* renamed from: d  reason: collision with root package name */
    public MutableLiveData<a2> f53182d = new MutableLiveData<>();

    /* renamed from: g  reason: collision with root package name */
    public LinkedList<d.b.i0.c2.h.e> f53185g = new LinkedList<>();

    /* renamed from: h  reason: collision with root package name */
    public MutableLiveData<a2> f53186h = new MutableLiveData<>();
    public MutableLiveData<a2> i = new MutableLiveData<>();
    public MutableLiveData<Boolean> j = new MutableLiveData<>();
    public MutableLiveData<Boolean> k = new MutableLiveData<>();

    public d() {
        new MutableLiveData();
        this.l = new MutableLiveData<>();
        this.m = new MutableLiveData<>();
    }

    public MutableLiveData<Integer> a() {
        return this.m;
    }

    public d.b.i0.c2.h.e b() {
        return this.f53180b;
    }

    public d.b.i0.c2.h.e c() {
        return this.f53179a;
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
        return this.f53183e;
    }

    public MutableLiveData<a2> h() {
        return this.f53186h;
    }

    public MutableLiveData<a2> i() {
        return this.f53182d;
    }

    public LinkedList<d.b.i0.c2.h.e> j() {
        return this.f53185g;
    }

    public boolean k() {
        return this.f53181c;
    }

    public boolean l() {
        return this.f53184f;
    }

    public MutableLiveData<Boolean> m() {
        return this.l;
    }

    public void n(d.b.i0.c2.h.e eVar) {
        this.f53180b = eVar;
        if (eVar != null) {
            this.f53182d.setValue(eVar.L());
            if (ListUtils.isEmpty(eVar.f())) {
                return;
            }
            u(eVar.f().get(0));
        }
    }

    public void o(d.b.i0.c2.h.e eVar) {
        this.f53179a = eVar;
        n(eVar);
        this.f53186h.setValue(null);
        this.f53182d.setValue(eVar.L());
    }

    public void p(boolean z) {
        this.f53181c = z;
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
        this.f53184f = z;
    }

    public void u(a2 a2Var) {
        this.i.setValue(a2Var);
    }

    public void v(Rect rect) {
        this.f53183e = rect;
    }

    public void w(a2 a2Var) {
        this.f53186h.setValue(a2Var);
    }
}

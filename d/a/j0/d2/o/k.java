package d.a.j0.d2.o;

import android.graphics.Rect;
import androidx.lifecycle.MutableLiveData;
import com.baidu.tbadk.core.util.ListUtils;
import d.a.i0.r.q.a2;
import java.util.LinkedList;
/* loaded from: classes3.dex */
public class k {

    /* renamed from: a  reason: collision with root package name */
    public d.a.j0.d2.h.e f52849a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.j0.d2.h.e f52850b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f52851c;

    /* renamed from: e  reason: collision with root package name */
    public Rect f52853e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f52854f;
    public MutableLiveData<Boolean> l;
    public MutableLiveData<Integer> m;

    /* renamed from: d  reason: collision with root package name */
    public MutableLiveData<a2> f52852d = new MutableLiveData<>();

    /* renamed from: g  reason: collision with root package name */
    public LinkedList<d.a.j0.d2.h.e> f52855g = new LinkedList<>();

    /* renamed from: h  reason: collision with root package name */
    public MutableLiveData<a2> f52856h = new MutableLiveData<>();

    /* renamed from: i  reason: collision with root package name */
    public MutableLiveData<a2> f52857i = new MutableLiveData<>();
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

    public d.a.j0.d2.h.e b() {
        return this.f52850b;
    }

    public d.a.j0.d2.h.e c() {
        return this.f52849a;
    }

    public MutableLiveData<Boolean> d() {
        return this.j;
    }

    public MutableLiveData<Boolean> e() {
        return this.k;
    }

    public MutableLiveData<a2> f() {
        return this.f52857i;
    }

    public Rect g() {
        return this.f52853e;
    }

    public MutableLiveData<a2> h() {
        return this.f52856h;
    }

    public MutableLiveData<a2> i() {
        return this.f52852d;
    }

    public LinkedList<d.a.j0.d2.h.e> j() {
        return this.f52855g;
    }

    public boolean k() {
        return this.f52851c;
    }

    public boolean l() {
        return this.f52854f;
    }

    public MutableLiveData<Boolean> m() {
        return this.l;
    }

    public void n(d.a.j0.d2.h.e eVar) {
        this.f52850b = eVar;
        if (eVar != null) {
            this.f52852d.setValue(eVar.L());
            if (ListUtils.isEmpty(eVar.f())) {
                return;
            }
            u(eVar.f().get(0));
        }
    }

    public void o(d.a.j0.d2.h.e eVar) {
        this.f52849a = eVar;
        n(eVar);
        this.f52856h.setValue(null);
        this.f52852d.setValue(eVar.L());
    }

    public void p(boolean z) {
        this.f52851c = z;
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
        this.f52854f = z;
    }

    public void u(a2 a2Var) {
        this.f52857i.setValue(a2Var);
    }

    public void v(Rect rect) {
        this.f52853e = rect;
    }

    public void w(a2 a2Var) {
        this.f52856h.setValue(a2Var);
    }
}

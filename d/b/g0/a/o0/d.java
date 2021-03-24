package d.b.g0.a.o0;

import android.view.KeyEvent;
import androidx.annotation.NonNull;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes3.dex */
public class d implements b {

    /* renamed from: a  reason: collision with root package name */
    public List<b> f45422a = new CopyOnWriteArrayList();

    @Override // d.b.g0.a.o0.b
    public void a() {
        List<b> list = this.f45422a;
        if (list == null || list.size() <= 0) {
            return;
        }
        for (b bVar : this.f45422a) {
            if (bVar != null) {
                bVar.a();
            }
        }
    }

    @Override // d.b.g0.a.o0.b
    public void b() {
        List<b> list = this.f45422a;
        if (list == null || list.size() <= 0) {
            return;
        }
        for (b bVar : this.f45422a) {
            bVar.b();
        }
    }

    @Override // d.b.g0.a.o0.b
    public void c() {
        List<b> list = this.f45422a;
        if (list == null || list.size() <= 0) {
            return;
        }
        for (b bVar : this.f45422a) {
            bVar.c();
        }
    }

    @Override // d.b.g0.a.o0.b
    public void d() {
        List<b> list = this.f45422a;
        if (list == null || list.size() <= 0) {
            return;
        }
        for (b bVar : this.f45422a) {
            bVar.d();
        }
    }

    @Override // d.b.g0.a.o0.b
    public void e() {
        List<b> list = this.f45422a;
        if (list == null || list.size() <= 0) {
            return;
        }
        for (b bVar : this.f45422a) {
            bVar.e();
        }
    }

    @Override // d.b.g0.a.o0.b
    public void f() {
        List<b> list = this.f45422a;
        if (list == null || list.size() <= 0) {
            return;
        }
        for (b bVar : this.f45422a) {
            bVar.f();
        }
    }

    @Override // d.b.g0.a.o0.b
    public void g() {
        List<b> list = this.f45422a;
        if (list == null || list.size() <= 0) {
            return;
        }
        for (b bVar : this.f45422a) {
            bVar.g();
        }
    }

    public void h(@NonNull b bVar) {
        this.f45422a.add(bVar);
    }

    public void i(@NonNull b bVar) {
        this.f45422a.remove(bVar);
    }

    @Override // d.b.g0.a.o0.b
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        boolean z;
        List<b> list = this.f45422a;
        if (list == null || list.size() <= 0) {
            return false;
        }
        while (true) {
            for (b bVar : this.f45422a) {
                z = z || bVar.onKeyDown(i, keyEvent);
            }
            return z;
        }
    }
}

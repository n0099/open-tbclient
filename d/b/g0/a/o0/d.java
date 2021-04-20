package d.b.g0.a.o0;

import android.view.KeyEvent;
import androidx.annotation.NonNull;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes2.dex */
public class d implements b {

    /* renamed from: a  reason: collision with root package name */
    public List<b> f45815a = new CopyOnWriteArrayList();

    @Override // d.b.g0.a.o0.b
    public void a() {
        List<b> list = this.f45815a;
        if (list == null || list.size() <= 0) {
            return;
        }
        for (b bVar : this.f45815a) {
            if (bVar != null) {
                bVar.a();
            }
        }
    }

    @Override // d.b.g0.a.o0.b
    public void b() {
        List<b> list = this.f45815a;
        if (list == null || list.size() <= 0) {
            return;
        }
        for (b bVar : this.f45815a) {
            bVar.b();
        }
    }

    @Override // d.b.g0.a.o0.b
    public void c() {
        List<b> list = this.f45815a;
        if (list == null || list.size() <= 0) {
            return;
        }
        for (b bVar : this.f45815a) {
            bVar.c();
        }
    }

    @Override // d.b.g0.a.o0.b
    public void d() {
        List<b> list = this.f45815a;
        if (list == null || list.size() <= 0) {
            return;
        }
        for (b bVar : this.f45815a) {
            bVar.d();
        }
    }

    @Override // d.b.g0.a.o0.b
    public void e() {
        List<b> list = this.f45815a;
        if (list == null || list.size() <= 0) {
            return;
        }
        for (b bVar : this.f45815a) {
            bVar.e();
        }
    }

    @Override // d.b.g0.a.o0.b
    public void f() {
        List<b> list = this.f45815a;
        if (list == null || list.size() <= 0) {
            return;
        }
        for (b bVar : this.f45815a) {
            bVar.f();
        }
    }

    @Override // d.b.g0.a.o0.b
    public void g() {
        List<b> list = this.f45815a;
        if (list == null || list.size() <= 0) {
            return;
        }
        for (b bVar : this.f45815a) {
            bVar.g();
        }
    }

    public void h(@NonNull b bVar) {
        this.f45815a.add(bVar);
    }

    public void i(@NonNull b bVar) {
        this.f45815a.remove(bVar);
    }

    @Override // d.b.g0.a.o0.b
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        boolean z;
        List<b> list = this.f45815a;
        if (list == null || list.size() <= 0) {
            return false;
        }
        while (true) {
            for (b bVar : this.f45815a) {
                z = z || bVar.onKeyDown(i, keyEvent);
            }
            return z;
        }
    }
}

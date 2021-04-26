package d.a.h0.a.o0;

import android.view.KeyEvent;
import androidx.annotation.NonNull;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes2.dex */
public class d implements b {

    /* renamed from: a  reason: collision with root package name */
    public List<b> f43491a = new CopyOnWriteArrayList();

    @Override // d.a.h0.a.o0.b
    public void a() {
        List<b> list = this.f43491a;
        if (list == null || list.size() <= 0) {
            return;
        }
        for (b bVar : this.f43491a) {
            if (bVar != null) {
                bVar.a();
            }
        }
    }

    @Override // d.a.h0.a.o0.b
    public void b() {
        List<b> list = this.f43491a;
        if (list == null || list.size() <= 0) {
            return;
        }
        for (b bVar : this.f43491a) {
            bVar.b();
        }
    }

    @Override // d.a.h0.a.o0.b
    public void c() {
        List<b> list = this.f43491a;
        if (list == null || list.size() <= 0) {
            return;
        }
        for (b bVar : this.f43491a) {
            bVar.c();
        }
    }

    @Override // d.a.h0.a.o0.b
    public void d() {
        List<b> list = this.f43491a;
        if (list == null || list.size() <= 0) {
            return;
        }
        for (b bVar : this.f43491a) {
            bVar.d();
        }
    }

    @Override // d.a.h0.a.o0.b
    public void e() {
        List<b> list = this.f43491a;
        if (list == null || list.size() <= 0) {
            return;
        }
        for (b bVar : this.f43491a) {
            bVar.e();
        }
    }

    @Override // d.a.h0.a.o0.b
    public void f() {
        List<b> list = this.f43491a;
        if (list == null || list.size() <= 0) {
            return;
        }
        for (b bVar : this.f43491a) {
            bVar.f();
        }
    }

    @Override // d.a.h0.a.o0.b
    public void g() {
        List<b> list = this.f43491a;
        if (list == null || list.size() <= 0) {
            return;
        }
        for (b bVar : this.f43491a) {
            bVar.g();
        }
    }

    public void h(@NonNull b bVar) {
        this.f43491a.add(bVar);
    }

    public void i(@NonNull b bVar) {
        this.f43491a.remove(bVar);
    }

    @Override // d.a.h0.a.o0.b
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        boolean z;
        List<b> list = this.f43491a;
        if (list == null || list.size() <= 0) {
            return false;
        }
        while (true) {
            for (b bVar : this.f43491a) {
                z = z || bVar.onKeyDown(i2, keyEvent);
            }
            return z;
        }
    }
}

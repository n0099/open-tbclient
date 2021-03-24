package d.b.b.e.b.b.a.c;

import android.content.Intent;
import java.lang.reflect.Type;
import java.util.Set;
/* loaded from: classes.dex */
public class d implements c {

    /* renamed from: a  reason: collision with root package name */
    public a f41631a;

    public d(Intent intent) {
        this.f41631a = new a(intent.getExtras());
    }

    @Override // d.b.b.e.b.b.a.c.c
    public Set<String> a() {
        return this.f41631a.a();
    }

    @Override // d.b.b.e.b.b.a.c.c
    public void b(String str, Object obj) {
        this.f41631a.b(str, obj);
    }

    @Override // d.b.b.e.b.b.a.c.c
    public Object c(String str, Type type) {
        return this.f41631a.c(str, type);
    }
}

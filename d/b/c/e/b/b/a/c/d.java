package d.b.c.e.b.b.a.c;

import android.content.Intent;
import java.lang.reflect.Type;
import java.util.Set;
/* loaded from: classes.dex */
public class d implements c {

    /* renamed from: a  reason: collision with root package name */
    public a f42129a;

    public d(Intent intent) {
        this.f42129a = new a(intent.getExtras());
    }

    @Override // d.b.c.e.b.b.a.c.c
    public Set<String> a() {
        return this.f42129a.a();
    }

    @Override // d.b.c.e.b.b.a.c.c
    public void b(String str, Object obj) {
        this.f42129a.b(str, obj);
    }

    @Override // d.b.c.e.b.b.a.c.c
    public Object c(String str, Type type) {
        return this.f42129a.c(str, type);
    }
}

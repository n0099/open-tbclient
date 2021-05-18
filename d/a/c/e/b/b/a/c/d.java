package d.a.c.e.b.b.a.c;

import android.content.Intent;
import java.lang.reflect.Type;
import java.util.Set;
/* loaded from: classes.dex */
public class d implements c {

    /* renamed from: a  reason: collision with root package name */
    public a f38807a;

    public d(Intent intent) {
        this.f38807a = new a(intent.getExtras());
    }

    @Override // d.a.c.e.b.b.a.c.c
    public Set<String> a() {
        return this.f38807a.a();
    }

    @Override // d.a.c.e.b.b.a.c.c
    public void b(String str, Object obj) {
        this.f38807a.b(str, obj);
    }

    @Override // d.a.c.e.b.b.a.c.c
    public Object c(String str, Type type) {
        return this.f38807a.c(str, type);
    }
}

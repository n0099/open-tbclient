package d.b.c.e.b.b.a.c;

import com.squareup.wire.Message;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/* loaded from: classes.dex */
public class g implements c {

    /* renamed from: a  reason: collision with root package name */
    public Message f42372a;

    /* renamed from: b  reason: collision with root package name */
    public Set<String> f42373b;

    public g(Message message) {
        this.f42372a = message;
        List<Field> b2 = d.b.c.e.b.a.a.b(message.getClass());
        this.f42373b = new HashSet();
        if (b2 == null || b2.size() <= 0) {
            return;
        }
        for (Field field : b2) {
            if (field != null) {
                this.f42373b.add(field.getName());
            }
        }
    }

    @Override // d.b.c.e.b.b.a.c.c
    public Set<String> a() {
        return this.f42373b;
    }

    @Override // d.b.c.e.b.b.a.c.c
    public void b(String str, Object obj) {
        d.b.c.e.b.a.a.j(this.f42372a, str, obj);
    }

    @Override // d.b.c.e.b.b.a.c.c
    public Object c(String str, Type type) {
        Object d2 = d(str);
        if (d2 != null) {
            d.b.c.e.b.b.a.e.c cVar = new d.b.c.e.b.b.a.e.c(type);
            d.b.c.e.b.b.a.d.h a2 = d.b.c.e.b.b.a.e.g.a(d2);
            return a2 != null ? a2.a(cVar) : d2;
        }
        return d2;
    }

    public Object d(String str) {
        return d.b.c.e.b.a.a.d(this.f42372a, str);
    }
}

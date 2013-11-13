package javassist.bytecode.annotation;

import java.util.Iterator;
import java.util.LinkedHashMap;
import javassist.bytecode.y;
import javassist.bytecode.z;
/* loaded from: classes.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    y f2788a;
    int b;
    LinkedHashMap c = null;

    public a(int i, y yVar) {
        this.f2788a = yVar;
        this.b = i;
    }

    public void a(int i, d dVar) {
        b bVar = new b();
        bVar.f2789a = i;
        bVar.b = dVar;
        a(bVar);
    }

    private void a(b bVar) {
        String w = this.f2788a.w(bVar.f2789a);
        if (this.c == null) {
            this.c = new LinkedHashMap();
        }
        this.c.put(w, bVar);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("@");
        stringBuffer.append(a());
        if (this.c != null) {
            stringBuffer.append("(");
            Iterator it = this.c.keySet().iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                stringBuffer.append(str).append("=").append(a(str));
                if (it.hasNext()) {
                    stringBuffer.append(", ");
                }
            }
            stringBuffer.append(")");
        }
        return stringBuffer.toString();
    }

    public String a() {
        return z.c(this.f2788a.w(this.b));
    }

    public d a(String str) {
        b bVar;
        if (this.c != null && (bVar = (b) this.c.get(str)) != null) {
            return bVar.b;
        }
        return null;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        if (a().equals(aVar.a())) {
            LinkedHashMap linkedHashMap = aVar.c;
            if (this.c != linkedHashMap) {
                if (this.c == null) {
                    return linkedHashMap == null;
                } else if (linkedHashMap == null) {
                    return false;
                } else {
                    return this.c.equals(linkedHashMap);
                }
            }
            return true;
        }
        return false;
    }
}

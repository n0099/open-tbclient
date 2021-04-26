package g.c.i;

import java.util.Collections;
import java.util.Iterator;
import java.util.TreeMap;
/* loaded from: classes7.dex */
public class g implements c {

    /* renamed from: a  reason: collision with root package name */
    public byte[] f67660a;

    /* renamed from: b  reason: collision with root package name */
    public TreeMap<String, String> f67661b = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);

    @Override // g.c.i.f
    public String d(String str) {
        String str2 = this.f67661b.get(str);
        return str2 == null ? "" : str2;
    }

    @Override // g.c.i.f
    public boolean e(String str) {
        return this.f67661b.containsKey(str);
    }

    @Override // g.c.i.f
    public Iterator<String> g() {
        return Collections.unmodifiableSet(this.f67661b.keySet()).iterator();
    }

    @Override // g.c.i.f
    public byte[] getContent() {
        return this.f67660a;
    }

    @Override // g.c.i.c
    public void put(String str, String str2) {
        this.f67661b.put(str, str2);
    }
}

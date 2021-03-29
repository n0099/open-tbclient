package g.c.i;

import java.util.Collections;
import java.util.Iterator;
import java.util.TreeMap;
/* loaded from: classes7.dex */
public class g implements c {

    /* renamed from: a  reason: collision with root package name */
    public byte[] f67645a;

    /* renamed from: b  reason: collision with root package name */
    public TreeMap<String, String> f67646b = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);

    @Override // g.c.i.c
    public void a(String str, String str2) {
        this.f67646b.put(str, str2);
    }

    @Override // g.c.i.f
    public boolean c(String str) {
        return this.f67646b.containsKey(str);
    }

    @Override // g.c.i.f
    public Iterator<String> e() {
        return Collections.unmodifiableSet(this.f67646b.keySet()).iterator();
    }

    @Override // g.c.i.f
    public byte[] getContent() {
        return this.f67645a;
    }

    @Override // g.c.i.f
    public String i(String str) {
        String str2 = this.f67646b.get(str);
        return str2 == null ? "" : str2;
    }
}

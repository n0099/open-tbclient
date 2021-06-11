package g.c.i;

import java.util.Collections;
import java.util.Iterator;
import java.util.TreeMap;
/* loaded from: classes8.dex */
public class g implements c {

    /* renamed from: a  reason: collision with root package name */
    public byte[] f71645a;

    /* renamed from: b  reason: collision with root package name */
    public TreeMap<String, String> f71646b = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);

    @Override // g.c.i.f
    public String d(String str) {
        String str2 = this.f71646b.get(str);
        return str2 == null ? "" : str2;
    }

    @Override // g.c.i.f
    public boolean e(String str) {
        return this.f71646b.containsKey(str);
    }

    @Override // g.c.i.f
    public Iterator<String> g() {
        return Collections.unmodifiableSet(this.f71646b.keySet()).iterator();
    }

    @Override // g.c.i.f
    public byte[] getContent() {
        return this.f71645a;
    }

    @Override // g.c.i.c
    public void put(String str, String str2) {
        this.f71646b.put(str, str2);
    }
}

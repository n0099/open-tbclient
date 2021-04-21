package g.c.i;

import java.util.Collections;
import java.util.Iterator;
import java.util.TreeMap;
/* loaded from: classes7.dex */
public class g implements c {

    /* renamed from: a  reason: collision with root package name */
    public byte[] f68798a;

    /* renamed from: b  reason: collision with root package name */
    public TreeMap<String, String> f68799b = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);

    @Override // g.c.i.f
    public boolean b(String str) {
        return this.f68799b.containsKey(str);
    }

    @Override // g.c.i.f
    public Iterator<String> d() {
        return Collections.unmodifiableSet(this.f68799b.keySet()).iterator();
    }

    @Override // g.c.i.f
    public byte[] getContent() {
        return this.f68798a;
    }

    @Override // g.c.i.f
    public String h(String str) {
        String str2 = this.f68799b.get(str);
        return str2 == null ? "" : str2;
    }

    @Override // g.c.i.c
    public void put(String str, String str2) {
        this.f68799b.put(str, str2);
    }
}

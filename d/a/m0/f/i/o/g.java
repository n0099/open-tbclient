package d.a.m0.f.i.o;

import android.content.Context;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class g extends e {
    public String q;
    public String r;
    public String s;
    public String t;

    public g(Context context, c cVar) {
        super(context, cVar);
        this.q = "rvideo";
        this.r = "10";
        this.s = "MSSP,ANTI,VIDEO,NMON";
        this.t = "LP,DL";
    }

    @Override // d.a.m0.f.i.o.e
    public HashMap<String, String> a() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("act", this.t);
        hashMap.put("prod", this.q);
        hashMap.put("at", this.r);
        hashMap.put("fet", this.s);
        return hashMap;
    }

    @Override // d.a.m0.f.i.o.e
    public String e() {
        return "";
    }
}

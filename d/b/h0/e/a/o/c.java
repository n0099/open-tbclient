package d.b.h0.e.a.o;

import android.content.Context;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class c extends d {
    public String r;
    public String s;
    public String t;
    public String u;

    public c(Context context, b bVar) {
        super(context, bVar);
        this.r = "banner";
        this.s = "32";
        this.t = "MSSP,ANTI,NMON";
        this.u = "LP,DL";
    }

    @Override // d.b.h0.e.a.o.d
    public HashMap<String, String> a() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("act", this.u);
        hashMap.put("prod", this.r);
        hashMap.put("at", this.s);
        hashMap.put("fet", this.t);
        if (this.i != null) {
            hashMap.put("w", "" + this.i.d());
            hashMap.put("h", "" + this.i.a());
        }
        return hashMap;
    }

    @Override // d.b.h0.e.a.o.d
    public String e() {
        return "";
    }
}

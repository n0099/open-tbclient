package d.b.h0.e.a.o;

import android.content.Context;
import android.text.TextUtils;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class f extends d {
    public String r;
    public String s;
    public String t;
    public String u;
    public String v;
    public String w;
    public String x;
    public String y;

    public f(Context context, b bVar) {
        super(context, bVar);
        this.r = "rvideo";
        this.s = "10";
        this.t = "MSSP,ANTI,VIDEO,NMON";
        this.u = "LP,DL";
        this.v = "70300";
        this.w = "70301";
        this.x = "70302";
        this.y = "70303";
    }

    @Override // d.b.h0.e.a.o.d
    public HashMap<String, String> a() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("act", this.u);
        hashMap.put("prod", this.r);
        hashMap.put("at", this.s);
        hashMap.put("fet", this.t);
        return hashMap;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0021  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0024  */
    @Override // d.b.h0.e.a.o.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String e() {
        String str;
        String str2 = "";
        if (d.b.h0.g.k0.e.c.f()) {
            if (d.b.h0.g.k0.e.c.e()) {
                str = this.w;
            } else if (d.b.h0.g.k0.e.c.d()) {
                str = this.v;
            }
            if (!d.b.h0.e.a.l.a.a()) {
                str2 = this.y;
            } else if (d.b.h0.e.a.l.a.b()) {
                str2 = this.x;
            }
            if (TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                return str + "," + str2;
            }
            return str + str2;
        }
        str = "";
        if (!d.b.h0.e.a.l.a.a()) {
        }
        if (TextUtils.isEmpty(str)) {
        }
        return str + str2;
    }
}

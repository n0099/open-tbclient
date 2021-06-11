package d.a.l0.f.i.o;

import android.content.Context;
import com.yy.mobile.framework.revenuesdk.baseapi.reporter.EventType;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class d extends e {
    public String q;
    public String r;
    public String s;
    public String t;

    public d(Context context, c cVar) {
        super(context, cVar);
        this.q = "banner";
        this.r = EventType.GiftEventID.SEND_GIFT_TO_MULTIUSER_SUCCESS;
        this.s = "MSSP,ANTI,NMON";
        this.t = "LP,DL";
    }

    @Override // d.a.l0.f.i.o.e
    public HashMap<String, String> a() {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("act", this.t);
        hashMap.put("prod", this.q);
        hashMap.put("at", this.r);
        hashMap.put("fet", this.s);
        if (this.f50473i != null) {
            hashMap.put("w", "" + this.f50473i.d());
            hashMap.put("h", "" + this.f50473i.a());
        }
        return hashMap;
    }

    @Override // d.a.l0.f.i.o.e
    public String e() {
        return "";
    }
}

package d.a.i0.h.f;

import androidx.annotation.NonNull;
import d.a.i0.a.v2.k;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c extends d.a.i0.a.o0.d.b {

    /* renamed from: d  reason: collision with root package name */
    public String f47159d;

    /* renamed from: e  reason: collision with root package name */
    public String f47160e;

    /* renamed from: f  reason: collision with root package name */
    public String f47161f;

    public c(@NonNull String str, String str2, String str3, String str4) {
        super(str);
        this.f47159d = str2;
        this.f47160e = str3;
        this.f47161f = str4;
    }

    public static d.a.i0.a.o0.d.b h(String str, String str2) {
        return new c("sconsole_console", "%s.message = { type:'log',logType:'%s',logs:[%s, %s] };", str, str2);
    }

    public static d.a.i0.a.o0.d.b i(boolean z) {
        return new c("sconsole_entirety", "%s.message = { type:'act',act:'%s' };", null, z ? "show" : "hide");
    }

    public static d.a.i0.a.o0.d.b j(String str, String str2) {
        return new c("sconsole_system", "%s.message = { type:'log',logType:'%s',logs:[%s] };", str, str2);
    }

    @Override // d.a.i0.a.o0.d.b, d.a.i0.a.o0.d.a
    public String f(String str) {
        char c2;
        String str2 = this.f47159d;
        int hashCode = str2.hashCode();
        if (hashCode == -2011830027) {
            if (str2.equals("%s.message = { type:'act',act:'%s' };")) {
                c2 = 2;
            }
            c2 = 65535;
        } else if (hashCode != -774049378) {
            if (hashCode == 2080164540 && str2.equals("%s.message = { type:'log',logType:'%s',logs:[%s] };")) {
                c2 = 1;
            }
            c2 = 65535;
        } else {
            if (str2.equals("%s.message = { type:'log',logType:'%s',logs:[%s, %s] };")) {
                c2 = 0;
            }
            c2 = 65535;
        }
        if (c2 != 0) {
            return c2 != 1 ? c2 != 2 ? "" : String.format("%s.message = { type:'act',act:'%s' };", str, this.f47161f) : String.format("%s.message = { type:'log',logType:'%s',logs:[%s] };", str, this.f47160e, JSONObject.quote(this.f47161f));
        }
        return String.format("%s.message = { type:'log',logType:'%s',logs:[%s, %s] };", str, this.f47160e, JSONObject.quote(k.b(k.a(), "yyyy-MM-dd HH:mm:ss")), JSONObject.quote(this.f47161f));
    }
}

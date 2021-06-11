package d.a.l0.h.f;

import androidx.annotation.NonNull;
import d.a.l0.a.v2.k;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c extends d.a.l0.a.o0.d.b {

    /* renamed from: d  reason: collision with root package name */
    public String f51009d;

    /* renamed from: e  reason: collision with root package name */
    public String f51010e;

    /* renamed from: f  reason: collision with root package name */
    public String f51011f;

    public c(@NonNull String str, String str2, String str3, String str4) {
        super(str);
        this.f51009d = str2;
        this.f51010e = str3;
        this.f51011f = str4;
    }

    public static d.a.l0.a.o0.d.b h(String str, String str2) {
        return new c("sconsole_console", "%s.message = { type:'log',logType:'%s',logs:[%s, %s] };", str, str2);
    }

    public static d.a.l0.a.o0.d.b i(boolean z) {
        return new c("sconsole_entirety", "%s.message = { type:'act',act:'%s' };", null, z ? "show" : "hide");
    }

    public static d.a.l0.a.o0.d.b j(String str, String str2) {
        return new c("sconsole_system", "%s.message = { type:'log',logType:'%s',logs:[%s] };", str, str2);
    }

    @Override // d.a.l0.a.o0.d.b, d.a.l0.a.o0.d.a
    public String f(String str) {
        char c2;
        String str2 = this.f51009d;
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
            return c2 != 1 ? c2 != 2 ? "" : String.format("%s.message = { type:'act',act:'%s' };", str, this.f51011f) : String.format("%s.message = { type:'log',logType:'%s',logs:[%s] };", str, this.f51010e, JSONObject.quote(this.f51011f));
        }
        return String.format("%s.message = { type:'log',logType:'%s',logs:[%s, %s] };", str, this.f51010e, JSONObject.quote(k.b(k.a(), "yyyy-MM-dd HH:mm:ss")), JSONObject.quote(this.f51011f));
    }
}

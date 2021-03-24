package d.b.g0.g.f;

import androidx.annotation.NonNull;
import d.b.g0.a.i2.j;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c extends d.b.g0.a.k0.b.b {

    /* renamed from: c  reason: collision with root package name */
    public String f48107c;

    /* renamed from: d  reason: collision with root package name */
    public String f48108d;

    /* renamed from: e  reason: collision with root package name */
    public String f48109e;

    public c(@NonNull String str, String str2, String str3, String str4) {
        super(str);
        this.f48107c = str2;
        this.f48108d = str3;
        this.f48109e = str4;
    }

    public static d.b.g0.a.k0.b.b b(String str, String str2) {
        return new c("sconsole_console", "%s.message = { type:'log',logType:'%s',logs:[%s, %s] };", str, str2);
    }

    public static d.b.g0.a.k0.b.b c(boolean z) {
        return new c("sconsole_entirety", "%s.message = { type:'act',act:'%s' };", null, z ? "show" : "hide");
    }

    public static d.b.g0.a.k0.b.b d(String str, String str2) {
        return new c("sconsole_system", "%s.message = { type:'log',logType:'%s',logs:[%s] };", str, str2);
    }

    @Override // d.b.g0.a.k0.b.b, d.b.g0.a.k0.b.a
    public String a(String str) {
        char c2;
        String str2 = this.f48107c;
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
            return c2 != 1 ? c2 != 2 ? "" : String.format("%s.message = { type:'act',act:'%s' };", str, this.f48109e) : String.format("%s.message = { type:'log',logType:'%s',logs:[%s] };", str, this.f48108d, JSONObject.quote(this.f48109e));
        }
        return String.format("%s.message = { type:'log',logType:'%s',logs:[%s, %s] };", str, this.f48108d, JSONObject.quote(j.b(j.a(), "yyyy-MM-dd HH:mm:ss")), JSONObject.quote(this.f48109e));
    }
}

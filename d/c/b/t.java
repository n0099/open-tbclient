package d.c.b;

import android.content.SharedPreferences;
import com.baidu.android.imsdk.internal.Constants;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class t extends h2 {

    /* renamed from: e  reason: collision with root package name */
    public final i f65919e;

    public t(i iVar) {
        super(true, false, false);
        this.f65919e = iVar;
    }

    @Override // d.c.b.h2
    public boolean b(JSONObject jSONObject) {
        SharedPreferences A = this.f65919e.A();
        String string = A.getString("install_id", null);
        String string2 = A.getString(Constants.KEY_DEVICE_ID, null);
        String string3 = A.getString("ssid", null);
        j.f(jSONObject, "install_id", string);
        j.f(jSONObject, Constants.KEY_DEVICE_ID, string2);
        j.f(jSONObject, "ssid", string3);
        long j = 0;
        long j2 = A.getLong("register_time", 0L);
        if ((j.p(string) && j.p(string2)) || j2 == 0) {
            j = j2;
        } else {
            A.edit().putLong("register_time", 0L).apply();
        }
        jSONObject.put("register_time", j);
        return true;
    }
}

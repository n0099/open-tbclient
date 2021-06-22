package d.b.b;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobstat.Config;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class n extends h2 {

    /* renamed from: e  reason: collision with root package name */
    public final Context f68902e;

    public n(Context context, i iVar) {
        super(true, false);
        this.f68902e = context;
    }

    @Override // d.b.b.h2
    public boolean b(JSONObject jSONObject) {
        String a2 = a.l() != null ? a.l().E().a() : "";
        if (TextUtils.isEmpty(a2)) {
            return true;
        }
        jSONObject.put(Config.DEVICE_MAC_ID, a2);
        return true;
    }
}

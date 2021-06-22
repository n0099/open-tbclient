package d.a.c.e.n.k;

import android.text.TextUtils;
import com.baidu.adp.lib.Disk.ops.DiskFileOperate;
import d.a.c.e.a.f.d;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public long f42549a = 0;

    /* renamed from: b  reason: collision with root package name */
    public String f42550b = null;

    public boolean a() {
        d dVar = new d("statisticConfig", "switchsConfig", DiskFileOperate.Action.READ);
        dVar.setSdCard(false);
        dVar.setOperateType(DiskFileOperate.OperateType.MUST_SUCCESS);
        d.a.c.e.a.d.g().d(dVar);
        String a2 = dVar.isSuccess() ? dVar.a() : null;
        if (TextUtils.isEmpty(a2)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(a2);
            this.f42549a = jSONObject.getLong("time");
            this.f42550b = jSONObject.getString("data");
            return true;
        } catch (JSONException e2) {
            e2.printStackTrace();
            return true;
        }
    }

    public void b(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("time", currentTimeMillis);
            jSONObject.put("data", str);
            d dVar = new d("statisticConfig", "switchsConfig", DiskFileOperate.Action.WRITE_FORCE);
            dVar.setSdCard(false);
            dVar.b(jSONObject.toString());
            dVar.setOperateType(DiskFileOperate.OperateType.MUST_SUCCESS);
            d.a.c.e.a.d.g().d(dVar);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }
}

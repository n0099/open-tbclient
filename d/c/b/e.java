package d.c.b;

import android.annotation.SuppressLint;
import android.os.Build;
import com.baidu.mobads.container.adrequest.IAdRequestParam;
import com.baidu.searchbox.pms.constants.PmsConstant;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class e extends h2 {
    public e() {
        super(true, false);
    }

    @Override // d.c.b.h2
    @SuppressLint({"MissingPermission"})
    public boolean b(JSONObject jSONObject) {
        jSONObject.put(IAdRequestParam.OS, "Android");
        jSONObject.put("os_version", Build.VERSION.RELEASE);
        jSONObject.put("os_api", Build.VERSION.SDK_INT);
        jSONObject.put("device_model", Build.MODEL);
        jSONObject.put("device_brand", Build.BRAND);
        jSONObject.put("device_manufacturer", Build.MANUFACTURER);
        jSONObject.put(PmsConstant.EnvParam.Key.CPU_ABI, Build.CPU_ABI);
        jSONObject.put("build_serial", Build.SERIAL);
        if (Build.VERSION.SDK_INT >= 26) {
            jSONObject.put("build_serial", Build.getSerial());
            return true;
        }
        return true;
    }
}

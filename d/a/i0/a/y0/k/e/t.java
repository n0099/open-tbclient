package d.a.i0.a.y0.k.e;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class t extends d.a.i0.a.y0.a<d.a.i0.a.y0.k.g.a> {

    /* renamed from: b  reason: collision with root package name */
    public int f45709b = 1;

    /* renamed from: c  reason: collision with root package name */
    public int f45710c = 3;

    @Override // d.a.i0.a.y0.a
    @NonNull
    public String b() {
        return "setZeusVideoExt";
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.i0.a.y0.a
    /* renamed from: e */
    public void a(@NonNull ZeusPlugin.Command command, @NonNull d.a.i0.a.y0.k.g.a aVar) {
        Object obj = command.obj;
        if (!(obj instanceof String)) {
            if (d.a.i0.a.y0.a.f45595a) {
                StringBuilder sb = new StringBuilder();
                sb.append("setZeusVideoExt with a illegal obj ");
                sb.append(obj == null);
                throw new RuntimeException(sb.toString());
            }
            return;
        }
        String str = command.what;
        d(aVar, str, "setZeusVideoExt:" + obj, false);
        try {
            JSONObject jSONObject = new JSONObject((String) obj);
            if (jSONObject.has("instance-error")) {
                HashMap hashMap = new HashMap();
                hashMap.put("instance-error", jSONObject.optString("instance-error"));
                aVar.X(hashMap);
            }
            String optString = jSONObject.optString("firstPlayStatus");
            if (!TextUtils.isEmpty(optString)) {
                aVar.f0(optString);
            }
            this.f45709b = jSONObject.optInt("min-cache", this.f45709b);
            int optInt = jSONObject.optInt("max-cache", this.f45710c);
            this.f45710c = optInt;
            if (this.f45709b <= optInt) {
                if (jSONObject.has("min-cache")) {
                    aVar.J(this.f45709b);
                }
                if (jSONObject.has("max-cache")) {
                    aVar.k0(this.f45710c);
                }
            } else if (d.a.i0.a.y0.a.f45595a) {
                Log.w("【InlineCommand】", "setZeusVideoExt: minCache " + this.f45709b + " > maxCache " + this.f45710c);
            }
        } catch (Exception e2) {
            if (d.a.i0.a.y0.a.f45595a) {
                throw new RuntimeException("setZeusVideoExt with a illegal str", e2);
            }
        }
    }
}

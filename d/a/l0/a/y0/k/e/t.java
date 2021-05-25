package d.a.l0.a.y0.k.e;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class t extends d.a.l0.a.y0.a<d.a.l0.a.y0.k.g.a> {

    /* renamed from: b  reason: collision with root package name */
    public int f45885b = 1;

    /* renamed from: c  reason: collision with root package name */
    public int f45886c = 3;

    @Override // d.a.l0.a.y0.a
    @NonNull
    public String b() {
        return "setZeusVideoExt";
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.l0.a.y0.a
    /* renamed from: e */
    public void a(@NonNull ZeusPlugin.Command command, @NonNull d.a.l0.a.y0.k.g.a aVar) {
        Object obj = command.obj;
        if (!(obj instanceof String)) {
            if (d.a.l0.a.y0.a.f45771a) {
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
            this.f45885b = jSONObject.optInt("min-cache", this.f45885b);
            int optInt = jSONObject.optInt("max-cache", this.f45886c);
            this.f45886c = optInt;
            if (this.f45885b <= optInt) {
                if (jSONObject.has("min-cache")) {
                    aVar.J(this.f45885b);
                }
                if (jSONObject.has("max-cache")) {
                    aVar.k0(this.f45886c);
                }
            } else if (d.a.l0.a.y0.a.f45771a) {
                Log.w("【InlineCommand】", "setZeusVideoExt: minCache " + this.f45885b + " > maxCache " + this.f45886c);
            }
        } catch (Exception e2) {
            if (d.a.l0.a.y0.a.f45771a) {
                throw new RuntimeException("setZeusVideoExt with a illegal str", e2);
            }
        }
    }
}

package d.b.g0.a.s0.k.e;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class r extends d.b.g0.a.s0.a<d.b.g0.a.s0.k.g.a> {

    /* renamed from: b  reason: collision with root package name */
    public int f46283b = 1;

    /* renamed from: c  reason: collision with root package name */
    public int f46284c = 3;

    @Override // d.b.g0.a.s0.a
    @NonNull
    public String b() {
        return "setZeusVideoExt";
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.g0.a.s0.a
    /* renamed from: e */
    public void a(@NonNull ZeusPlugin.Command command, @NonNull d.b.g0.a.s0.k.g.a aVar) {
        Object obj = command.obj;
        if (!(obj instanceof String)) {
            if (d.b.g0.a.s0.a.f46175a) {
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
            String optString = jSONObject.optString("firstPlayStatus");
            if (!TextUtils.isEmpty(optString)) {
                aVar.O(optString);
            }
            this.f46283b = jSONObject.optInt("min-cache", this.f46283b);
            int optInt = jSONObject.optInt("max-cache", this.f46284c);
            this.f46284c = optInt;
            if (this.f46283b <= optInt) {
                if (jSONObject.has("min-cache")) {
                    aVar.d0(this.f46283b);
                }
                if (jSONObject.has("max-cache")) {
                    aVar.Y(this.f46284c);
                }
            } else if (d.b.g0.a.s0.a.f46175a) {
                Log.w("【InlineCommand】", "setZeusVideoExt: minCache " + this.f46283b + " > maxCache " + this.f46284c);
            }
        } catch (Exception unused) {
        }
    }
}

package d.b.h0.a.s0.k.e;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class r extends d.b.h0.a.s0.a<d.b.h0.a.s0.k.g.a> {

    /* renamed from: b  reason: collision with root package name */
    public int f46612b = 1;

    /* renamed from: c  reason: collision with root package name */
    public int f46613c = 3;

    @Override // d.b.h0.a.s0.a
    @NonNull
    public String b() {
        return "setZeusVideoExt";
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.h0.a.s0.a
    /* renamed from: e */
    public void a(@NonNull ZeusPlugin.Command command, @NonNull d.b.h0.a.s0.k.g.a aVar) {
        Object obj = command.obj;
        if (!(obj instanceof String)) {
            if (d.b.h0.a.s0.a.f46504a) {
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
            this.f46612b = jSONObject.optInt("min-cache", this.f46612b);
            int optInt = jSONObject.optInt("max-cache", this.f46613c);
            this.f46613c = optInt;
            if (this.f46612b <= optInt) {
                if (jSONObject.has("min-cache")) {
                    aVar.d0(this.f46612b);
                }
                if (jSONObject.has("max-cache")) {
                    aVar.Y(this.f46613c);
                }
            } else if (d.b.h0.a.s0.a.f46504a) {
                Log.w("【InlineCommand】", "setZeusVideoExt: minCache " + this.f46612b + " > maxCache " + this.f46613c);
            }
        } catch (Exception unused) {
        }
    }
}

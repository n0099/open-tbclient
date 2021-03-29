package d.b.g0.a.s0.k.e;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class r extends d.b.g0.a.s0.a<d.b.g0.a.s0.k.g.a> {

    /* renamed from: b  reason: collision with root package name */
    public int f45891b = 1;

    /* renamed from: c  reason: collision with root package name */
    public int f45892c = 3;

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
            if (d.b.g0.a.s0.a.f45783a) {
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
            this.f45891b = jSONObject.optInt("min-cache", this.f45891b);
            int optInt = jSONObject.optInt("max-cache", this.f45892c);
            this.f45892c = optInt;
            if (this.f45891b <= optInt) {
                if (jSONObject.has("min-cache")) {
                    aVar.d0(this.f45891b);
                }
                if (jSONObject.has("max-cache")) {
                    aVar.Y(this.f45892c);
                }
            } else if (d.b.g0.a.s0.a.f45783a) {
                Log.w("【InlineCommand】", "setZeusVideoExt: minCache " + this.f45891b + " > maxCache " + this.f45892c);
            }
        } catch (Exception unused) {
        }
    }
}

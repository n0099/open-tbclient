package d.a.h0.a.s0.k.e;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class r extends d.a.h0.a.s0.a<d.a.h0.a.s0.k.g.a> {

    /* renamed from: b  reason: collision with root package name */
    public int f43983b = 1;

    /* renamed from: c  reason: collision with root package name */
    public int f43984c = 3;

    @Override // d.a.h0.a.s0.a
    @NonNull
    public String b() {
        return "setZeusVideoExt";
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.h0.a.s0.a
    /* renamed from: e */
    public void a(@NonNull ZeusPlugin.Command command, @NonNull d.a.h0.a.s0.k.g.a aVar) {
        Object obj = command.obj;
        if (!(obj instanceof String)) {
            if (d.a.h0.a.s0.a.f43869a) {
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
                aVar.X(optString);
            }
            this.f43983b = jSONObject.optInt("min-cache", this.f43983b);
            int optInt = jSONObject.optInt("max-cache", this.f43984c);
            this.f43984c = optInt;
            if (this.f43983b <= optInt) {
                if (jSONObject.has("min-cache")) {
                    aVar.F(this.f43983b);
                }
                if (jSONObject.has("max-cache")) {
                    aVar.b0(this.f43984c);
                }
            } else if (d.a.h0.a.s0.a.f43869a) {
                Log.w("【InlineCommand】", "setZeusVideoExt: minCache " + this.f43983b + " > maxCache " + this.f43984c);
            }
        } catch (Exception unused) {
        }
    }
}

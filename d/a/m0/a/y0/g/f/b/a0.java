package d.a.m0.a.y0.g.f.b;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
/* loaded from: classes3.dex */
public class a0 extends d.a.m0.a.y0.a<d.a.m0.a.y0.g.h.b> {
    @Override // d.a.m0.a.y0.a
    @NonNull
    public String b() {
        return "setSoundModel";
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.m0.a.y0.a
    /* renamed from: e */
    public void a(@NonNull ZeusPlugin.Command command, @NonNull d.a.m0.a.y0.g.h.b bVar) {
        String str = command.what;
        d(bVar, str, "" + command.obj, true);
        Object obj = command.obj;
        if (obj instanceof String) {
            String str2 = (String) obj;
            if (TextUtils.equals(str2, "ear")) {
                bVar.q(str2);
            } else if (TextUtils.equals(str2, "speaker")) {
                bVar.q(str2);
            }
        }
    }
}

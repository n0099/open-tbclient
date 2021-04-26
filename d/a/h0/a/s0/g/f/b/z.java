package d.a.h0.a.s0.g.f.b;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
/* loaded from: classes2.dex */
public class z extends d.a.h0.a.s0.a<d.a.h0.a.s0.g.h.b> {
    @Override // d.a.h0.a.s0.a
    @NonNull
    public String b() {
        return "setSoundModel";
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.h0.a.s0.a
    /* renamed from: e */
    public void a(@NonNull ZeusPlugin.Command command, @NonNull d.a.h0.a.s0.g.h.b bVar) {
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

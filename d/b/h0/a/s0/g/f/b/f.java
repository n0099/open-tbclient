package d.b.h0.a.s0.g.f.b;

import androidx.annotation.NonNull;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
/* loaded from: classes2.dex */
public class f extends d.b.h0.a.s0.a<d.b.h0.a.s0.g.h.b> {
    @Override // d.b.h0.a.s0.a
    @NonNull
    public String b() {
        return "enableMicPhone";
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.h0.a.s0.a
    /* renamed from: e */
    public void a(@NonNull ZeusPlugin.Command command, @NonNull d.b.h0.a.s0.g.h.b bVar) {
        String str = command.what;
        d(bVar, str, "" + command.obj, true);
        Object obj = command.obj;
        if (obj instanceof Boolean) {
            bVar.W(((Boolean) obj).booleanValue());
        }
    }
}

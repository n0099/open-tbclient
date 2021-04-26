package d.a.h0.a.s0.k.e;

import androidx.annotation.NonNull;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
/* loaded from: classes2.dex */
public class n extends d.a.h0.a.s0.a<d.a.h0.a.s0.k.g.a> {
    @Override // d.a.h0.a.s0.a
    @NonNull
    public String b() {
        return "setMuted";
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.h0.a.s0.a
    /* renamed from: e */
    public void a(@NonNull ZeusPlugin.Command command, @NonNull d.a.h0.a.s0.k.g.a aVar) {
        Object obj = command.obj;
        if (obj instanceof Boolean) {
            aVar.k(((Boolean) obj).booleanValue());
            String str = command.what;
            d(aVar, str, "setMuted:" + command.obj, false);
        }
    }
}

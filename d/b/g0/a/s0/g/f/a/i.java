package d.b.g0.a.s0.g.f.a;

import androidx.annotation.NonNull;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
/* loaded from: classes2.dex */
public class i extends d.b.g0.a.s0.a<d.b.g0.a.s0.g.h.a> {
    @Override // d.b.g0.a.s0.a
    @NonNull
    public String b() {
        return "onZoom";
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.g0.a.s0.a
    /* renamed from: e */
    public void a(@NonNull ZeusPlugin.Command command, @NonNull d.b.g0.a.s0.g.h.a aVar) {
        String str = command.what;
        d(aVar, str, "" + command.obj, true);
        Object obj = command.obj;
        if (obj instanceof Integer) {
            aVar.S(((Integer) obj).intValue());
        }
    }
}

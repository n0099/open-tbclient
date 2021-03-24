package d.b.g0.a.s0.g.f.a;

import androidx.annotation.NonNull;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
/* loaded from: classes3.dex */
public class e extends d.b.g0.a.s0.a<d.b.g0.a.s0.g.h.a> {
    @Override // d.b.g0.a.s0.a
    @NonNull
    public String b() {
        return "setItemType";
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.g0.a.s0.a
    /* renamed from: e */
    public void a(@NonNull ZeusPlugin.Command command, @NonNull d.b.g0.a.s0.g.h.a aVar) {
        String str = command.what;
        d(aVar, str, "" + command.obj, true);
        Object obj = command.obj;
        if (obj instanceof String) {
            aVar.s((String) obj);
        }
    }
}

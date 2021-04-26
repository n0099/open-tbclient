package d.a.h0.a.s0.g.f.b;

import androidx.annotation.NonNull;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
/* loaded from: classes2.dex */
public class v extends d.a.h0.a.s0.a<d.a.h0.a.s0.g.h.b> {
    @Override // d.a.h0.a.s0.a
    @NonNull
    public String b() {
        return "setCheekThin";
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.h0.a.s0.a
    /* renamed from: e */
    public void a(@NonNull ZeusPlugin.Command command, @NonNull d.a.h0.a.s0.g.h.b bVar) {
        String str = command.what;
        d(bVar, str, "" + command.obj, true);
        Object obj = command.obj;
        if (obj instanceof Integer) {
            bVar.H(((Integer) obj).intValue());
        }
    }
}

package d.a.i0.a.y0.g.f.b;

import androidx.annotation.NonNull;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
/* loaded from: classes.dex */
public class m extends d.a.i0.a.y0.a<d.a.i0.a.y0.g.h.b> {
    @Override // d.a.i0.a.y0.a
    @NonNull
    public String b() {
        return "kickOutUser";
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.i0.a.y0.a
    /* renamed from: e */
    public void a(@NonNull ZeusPlugin.Command command, @NonNull d.a.i0.a.y0.g.h.b bVar) {
        Object obj = command.obj;
        if (obj instanceof Long) {
            bVar.H(((Long) obj).longValue());
        }
        d(bVar, command.what, null, true);
    }
}

package d.a.i0.a.y0.g.f.b;

import androidx.annotation.NonNull;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
/* loaded from: classes.dex */
public class e0 extends d.a.i0.a.y0.a<d.a.i0.a.y0.g.h.b> {
    @Override // d.a.i0.a.y0.a
    @NonNull
    public String b() {
        return "unsubscribeRemoteStream";
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.i0.a.y0.a
    /* renamed from: e */
    public void a(@NonNull ZeusPlugin.Command command, @NonNull d.a.i0.a.y0.g.h.b bVar) {
        String str = command.what;
        d(bVar, str, "" + command.obj, true);
        Object obj = command.obj;
        if (obj instanceof Long) {
            long longValue = ((Long) obj).longValue();
            if (d.a.i0.a.y0.g.g.a.a(longValue)) {
                bVar.j(longValue);
            }
        }
    }
}

package d.a.l0.a.y0.g.f.b;

import androidx.annotation.NonNull;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
/* loaded from: classes3.dex */
public class b0 extends d.a.l0.a.y0.a<d.a.l0.a.y0.g.h.b> {
    @Override // d.a.l0.a.y0.a
    @NonNull
    public String b() {
        return "subscribeRemoteStream";
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.l0.a.y0.a
    /* renamed from: e */
    public void a(@NonNull ZeusPlugin.Command command, @NonNull d.a.l0.a.y0.g.h.b bVar) {
        String str = command.what;
        d(bVar, str, "" + command.obj, true);
        Object obj = command.obj;
        if (obj instanceof Long) {
            long longValue = ((Long) obj).longValue();
            if (d.a.l0.a.y0.g.g.a.a(longValue)) {
                bVar.l0(longValue);
            }
        }
    }
}

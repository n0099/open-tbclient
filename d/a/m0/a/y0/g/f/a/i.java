package d.a.m0.a.y0.g.f.a;

import androidx.annotation.NonNull;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
/* loaded from: classes3.dex */
public class i extends d.a.m0.a.y0.a<d.a.m0.a.y0.g.h.a> {
    @Override // d.a.m0.a.y0.a
    @NonNull
    public String b() {
        return "onZoom";
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.m0.a.y0.a
    /* renamed from: e */
    public void a(@NonNull ZeusPlugin.Command command, @NonNull d.a.m0.a.y0.g.h.a aVar) {
        String str = command.what;
        d(aVar, str, "" + command.obj, true);
        Object obj = command.obj;
        if (obj instanceof Integer) {
            aVar.z(((Integer) obj).intValue());
        }
    }
}

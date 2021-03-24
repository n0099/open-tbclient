package d.b.g0.a.s0.g.f.b;

import androidx.annotation.NonNull;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
/* loaded from: classes3.dex */
public class c extends d.b.g0.a.s0.a<d.b.g0.a.s0.g.h.b> {
    @Override // d.b.g0.a.s0.a
    @NonNull
    public String b() {
        return "enableCameraAutoFocus";
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.g0.a.s0.a
    /* renamed from: e */
    public void a(@NonNull ZeusPlugin.Command command, @NonNull d.b.g0.a.s0.g.h.b bVar) {
        String str = command.what;
        d(bVar, str, "" + command.obj, true);
        Object obj = command.obj;
        if (obj instanceof Boolean) {
            bVar.E(((Boolean) obj).booleanValue());
        }
    }
}

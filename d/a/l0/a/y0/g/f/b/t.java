package d.a.l0.a.y0.g.f.b;

import androidx.annotation.NonNull;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
/* loaded from: classes3.dex */
public class t extends d.a.l0.a.y0.a<d.a.l0.a.y0.g.h.b> {
    @Override // d.a.l0.a.y0.a
    @NonNull
    public String b() {
        return "setBeautyBlur";
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.l0.a.y0.a
    /* renamed from: e */
    public void a(@NonNull ZeusPlugin.Command command, @NonNull d.a.l0.a.y0.g.h.b bVar) {
        String str = command.what;
        d(bVar, str, "" + command.obj, true);
        Object obj = command.obj;
        if (obj instanceof Integer) {
            bVar.W(((Integer) obj).intValue());
        }
    }
}

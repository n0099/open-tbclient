package d.a.l0.a.y0.g.f.a;

import androidx.annotation.NonNull;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
/* loaded from: classes3.dex */
public class e extends d.a.l0.a.y0.a<d.a.l0.a.y0.g.h.a> {
    @Override // d.a.l0.a.y0.a
    @NonNull
    public String b() {
        return "setItemType";
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.l0.a.y0.a
    /* renamed from: e */
    public void a(@NonNull ZeusPlugin.Command command, @NonNull d.a.l0.a.y0.g.h.a aVar) {
        String str = command.what;
        d(aVar, str, "" + command.obj, true);
        Object obj = command.obj;
        if (obj instanceof String) {
            aVar.m((String) obj);
        }
    }
}

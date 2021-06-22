package d.a.m0.a.y0.g.f.b;

import androidx.annotation.NonNull;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
/* loaded from: classes3.dex */
public class w extends d.a.m0.a.y0.a<d.a.m0.a.y0.g.h.b> {
    @Override // d.a.m0.a.y0.a
    @NonNull
    public String b() {
        return "setCheekThin";
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.m0.a.y0.a
    /* renamed from: e */
    public void a(@NonNull ZeusPlugin.Command command, @NonNull d.a.m0.a.y0.g.h.b bVar) {
        String str = command.what;
        d(bVar, str, "" + command.obj, true);
        Object obj = command.obj;
        if (obj instanceof Integer) {
            bVar.J(((Integer) obj).intValue());
        }
    }
}

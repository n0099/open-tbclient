package d.a.i0.a.y0.g.f.a;

import androidx.annotation.NonNull;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
/* loaded from: classes.dex */
public class d extends d.a.i0.a.y0.a<d.a.i0.a.y0.g.h.a> {
    @Override // d.a.i0.a.y0.a
    @NonNull
    public String b() {
        return "onItemRelease";
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.i0.a.y0.a
    /* renamed from: e */
    public void a(@NonNull ZeusPlugin.Command command, @NonNull d.a.i0.a.y0.g.h.a aVar) {
        d(aVar, command.what, null, true);
        aVar.onRelease();
    }
}

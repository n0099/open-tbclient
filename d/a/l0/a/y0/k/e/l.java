package d.a.l0.a.y0.k.e;

import androidx.annotation.NonNull;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
/* loaded from: classes3.dex */
public class l extends d.a.l0.a.y0.a<d.a.l0.a.y0.k.g.a> {
    @Override // d.a.l0.a.y0.a
    @NonNull
    public String b() {
        return "prepareAsync";
    }

    @Override // d.a.l0.a.y0.a
    public void c(@NonNull ZeusPlugin.Command command) {
        command.ret = 1;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.l0.a.y0.a
    /* renamed from: e */
    public void a(@NonNull ZeusPlugin.Command command, @NonNull d.a.l0.a.y0.k.g.a aVar) {
        command.ret = aVar.I() ? 1 : 0;
        String str = command.what;
        d(aVar, str, "isSupport: " + command.ret, false);
    }
}

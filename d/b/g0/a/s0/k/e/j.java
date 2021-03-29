package d.b.g0.a.s0.k.e;

import androidx.annotation.NonNull;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
/* loaded from: classes2.dex */
public class j extends d.b.g0.a.s0.a<d.b.g0.a.s0.k.g.a> {
    @Override // d.b.g0.a.s0.a
    @NonNull
    public String b() {
        return "prepareAsync";
    }

    @Override // d.b.g0.a.s0.a
    public void c(@NonNull ZeusPlugin.Command command) {
        command.ret = 1;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.g0.a.s0.a
    /* renamed from: e */
    public void a(@NonNull ZeusPlugin.Command command, @NonNull d.b.g0.a.s0.k.g.a aVar) {
        command.ret = aVar.prepareAsync() ? 1 : 0;
        String str = command.what;
        d(aVar, str, "isSupport: " + command.ret, false);
    }
}

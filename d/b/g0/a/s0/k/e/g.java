package d.b.g0.a.s0.k.e;

import androidx.annotation.NonNull;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
/* loaded from: classes3.dex */
public class g extends d.b.g0.a.s0.a<d.b.g0.a.s0.k.g.a> {
    @Override // d.b.g0.a.s0.a
    @NonNull
    public String b() {
        return "isPlaying";
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.g0.a.s0.a
    /* renamed from: e */
    public void a(@NonNull ZeusPlugin.Command command, @NonNull d.b.g0.a.s0.k.g.a aVar) {
        command.ret = aVar.isPlaying() ? 1 : 0;
        String str = command.what;
        d(aVar, str, "isPlaying: " + aVar.isPlaying(), false);
    }
}

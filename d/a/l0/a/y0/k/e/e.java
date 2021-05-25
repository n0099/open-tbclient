package d.a.l0.a.y0.k.e;

import androidx.annotation.NonNull;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
/* loaded from: classes3.dex */
public class e extends d.a.l0.a.y0.a<d.a.l0.a.y0.k.g.a> {
    @Override // d.a.l0.a.y0.a
    @NonNull
    public String b() {
        return "getVideoSarNum";
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.l0.a.y0.a
    /* renamed from: e */
    public void a(@NonNull ZeusPlugin.Command command, @NonNull d.a.l0.a.y0.k.g.a aVar) {
        command.ret = aVar.g();
        String str = command.what;
        d(aVar, str, "SarNum: " + command.ret, false);
    }
}

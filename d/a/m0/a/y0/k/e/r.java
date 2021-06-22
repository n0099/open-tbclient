package d.a.m0.a.y0.k.e;

import androidx.annotation.NonNull;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
/* loaded from: classes3.dex */
public class r extends d.a.m0.a.y0.a<d.a.m0.a.y0.k.g.a> {
    @Override // d.a.m0.a.y0.a
    @NonNull
    public String b() {
        return "setUseFreeFlow";
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.m0.a.y0.a
    /* renamed from: e */
    public void a(@NonNull ZeusPlugin.Command command, @NonNull d.a.m0.a.y0.k.g.a aVar) {
        aVar.B(command.arg1 == 1);
        d(aVar, command.what, null, false);
    }
}

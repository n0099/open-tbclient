package d.a.l0.a.y0.e.d;

import androidx.annotation.NonNull;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
/* loaded from: classes3.dex */
public class b extends d.a.l0.a.y0.a<d.a.l0.a.y0.e.c> {
    @Override // d.a.l0.a.y0.a
    @NonNull
    public String b() {
        return "releasekeyboard";
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.l0.a.y0.a
    /* renamed from: e */
    public void a(@NonNull ZeusPlugin.Command command, @NonNull d.a.l0.a.y0.e.c cVar) {
        d(cVar, command.what, null, false);
        cVar.release();
    }
}

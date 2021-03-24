package d.b.g0.a.s0.i.d;

import androidx.annotation.NonNull;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
/* loaded from: classes3.dex */
public class e extends d.b.g0.a.s0.a<d.b.g0.a.s0.i.c> {
    @Override // d.b.g0.a.s0.a
    @NonNull
    public String b() {
        return "showConfirmBar";
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.g0.a.s0.a
    /* renamed from: e */
    public void a(@NonNull ZeusPlugin.Command command, @NonNull d.b.g0.a.s0.i.c cVar) {
        int i = command.arg1;
        String str = command.what;
        d(cVar, str, "(keyboardHeight)" + i, false);
        cVar.s0(i);
    }
}

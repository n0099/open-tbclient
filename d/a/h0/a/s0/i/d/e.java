package d.a.h0.a.s0.i.d;

import androidx.annotation.NonNull;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
/* loaded from: classes2.dex */
public class e extends d.a.h0.a.s0.a<d.a.h0.a.s0.i.c> {
    @Override // d.a.h0.a.s0.a
    @NonNull
    public String b() {
        return "showConfirmBar";
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.h0.a.s0.a
    /* renamed from: e */
    public void a(@NonNull ZeusPlugin.Command command, @NonNull d.a.h0.a.s0.i.c cVar) {
        int i2 = command.arg1;
        String str = command.what;
        d(cVar, str, "(keyboardHeight)" + i2, false);
        cVar.t0(i2);
    }
}

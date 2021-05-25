package d.a.l0.a.y0.i.d;

import androidx.annotation.NonNull;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
/* loaded from: classes3.dex */
public class e extends d.a.l0.a.y0.a<d.a.l0.a.y0.i.c> {
    @Override // d.a.l0.a.y0.a
    @NonNull
    public String b() {
        return "showConfirmBar";
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.l0.a.y0.a
    /* renamed from: e */
    public void a(@NonNull ZeusPlugin.Command command, @NonNull d.a.l0.a.y0.i.c cVar) {
        int i2 = command.arg1;
        String str = command.what;
        d(cVar, str, "(keyboardHeight)" + i2, false);
        cVar.D0(i2);
    }
}

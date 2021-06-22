package d.a.m0.a.y0.e.d;

import androidx.annotation.NonNull;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
/* loaded from: classes3.dex */
public class e extends d.a.m0.a.y0.a<d.a.m0.a.y0.e.c> {
    @Override // d.a.m0.a.y0.a
    @NonNull
    public String b() {
        return "showsoftkeyboard";
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.m0.a.y0.a
    /* renamed from: e */
    public void a(@NonNull ZeusPlugin.Command command, @NonNull d.a.m0.a.y0.e.c cVar) {
        int i2 = command.arg1;
        String str = command.what;
        d(cVar, str, "Type:" + i2, false);
        cVar.A0(i2);
    }
}

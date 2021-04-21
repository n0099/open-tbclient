package d.b.h0.a.s0.k.e;

import android.view.Surface;
import androidx.annotation.NonNull;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
/* loaded from: classes2.dex */
public class o extends d.b.h0.a.s0.a<d.b.h0.a.s0.k.g.a> {
    @Override // d.b.h0.a.s0.a
    @NonNull
    public String b() {
        return "setSurface";
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.h0.a.s0.a
    /* renamed from: e */
    public void a(@NonNull ZeusPlugin.Command command, @NonNull d.b.h0.a.s0.k.g.a aVar) {
        Object obj = command.obj;
        if (obj == null) {
            return;
        }
        aVar.setSurface((Surface) obj);
        String str = command.what;
        d(aVar, str, "Surface:" + command.obj.hashCode(), false);
    }
}

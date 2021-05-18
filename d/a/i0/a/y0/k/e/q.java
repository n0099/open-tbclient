package d.a.i0.a.y0.k.e;

import android.view.Surface;
import androidx.annotation.NonNull;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
/* loaded from: classes3.dex */
public class q extends d.a.i0.a.y0.a<d.a.i0.a.y0.k.g.a> {
    @Override // d.a.i0.a.y0.a
    @NonNull
    public String b() {
        return "setSurface";
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.i0.a.y0.a
    /* renamed from: e */
    public void a(@NonNull ZeusPlugin.Command command, @NonNull d.a.i0.a.y0.k.g.a aVar) {
        Object obj = command.obj;
        if (obj == null) {
            return;
        }
        aVar.setSurface((Surface) obj);
        String str = command.what;
        d(aVar, str, "Surface:" + command.obj.hashCode(), false);
    }
}

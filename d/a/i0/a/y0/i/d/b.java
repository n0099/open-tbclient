package d.a.i0.a.y0.i.d;

import androidx.annotation.NonNull;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
/* loaded from: classes.dex */
public class b extends d.a.i0.a.y0.a<d.a.i0.a.y0.i.c> {
    @Override // d.a.i0.a.y0.a
    @NonNull
    public String b() {
        return "release";
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.i0.a.y0.a
    /* renamed from: e */
    public void a(@NonNull ZeusPlugin.Command command, @NonNull d.a.i0.a.y0.i.c cVar) {
        d(cVar, command.what, null, false);
        cVar.release();
    }
}

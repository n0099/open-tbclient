package d.a.i0.a.y0.k.e;

import androidx.annotation.NonNull;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
/* loaded from: classes3.dex */
public class n extends d.a.i0.a.y0.a<d.a.i0.a.y0.k.g.a> {
    @Override // d.a.i0.a.y0.a
    @NonNull
    public String b() {
        return "seekTo";
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.i0.a.y0.a
    /* renamed from: e */
    public void a(@NonNull ZeusPlugin.Command command, @NonNull d.a.i0.a.y0.k.g.a aVar) {
        aVar.seekTo(command.arg1);
        String str = command.what;
        d(aVar, str, "SeekTo: " + command.arg1, false);
    }
}

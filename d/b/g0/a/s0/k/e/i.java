package d.b.g0.a.s0.k.e;

import androidx.annotation.NonNull;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
/* loaded from: classes2.dex */
public class i extends d.b.g0.a.s0.a<d.b.g0.a.s0.k.g.a> {
    @Override // d.b.g0.a.s0.a
    @NonNull
    public String b() {
        return "setRate";
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.b.g0.a.s0.a
    /* renamed from: e */
    public void a(@NonNull ZeusPlugin.Command command, @NonNull d.b.g0.a.s0.k.g.a aVar) {
        float floatValue;
        Object obj = command.obj;
        if (obj == null) {
            return;
        }
        if (obj instanceof Float) {
            floatValue = ((Float) obj).floatValue();
        } else {
            floatValue = obj instanceof Double ? ((Double) obj).floatValue() : Float.MIN_VALUE;
        }
        if (floatValue != Float.MIN_VALUE) {
            aVar.setSpeed(floatValue);
            String str = command.what;
            d(aVar, str, "playbackRate: " + command.obj, false);
        }
    }
}

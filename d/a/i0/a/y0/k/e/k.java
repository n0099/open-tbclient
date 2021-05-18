package d.a.i0.a.y0.k.e;

import androidx.annotation.NonNull;
import com.baidu.webkit.sdk.plugin.ZeusPlugin;
/* loaded from: classes3.dex */
public class k extends d.a.i0.a.y0.a<d.a.i0.a.y0.k.g.a> {
    @Override // d.a.i0.a.y0.a
    @NonNull
    public String b() {
        return "setRate";
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.i0.a.y0.a
    /* renamed from: e */
    public void a(@NonNull ZeusPlugin.Command command, @NonNull d.a.i0.a.y0.k.g.a aVar) {
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

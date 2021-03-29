package d.b.m;

import android.content.Context;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.StandardMessageCodec;
import io.flutter.plugin.platform.PlatformView;
import io.flutter.plugin.platform.PlatformViewFactory;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public final class b extends PlatformViewFactory {

    /* renamed from: b  reason: collision with root package name */
    public static HashMap<String, a> f64027b = new HashMap<>();

    /* renamed from: a  reason: collision with root package name */
    public final BinaryMessenger f64028a;

    public b(BinaryMessenger binaryMessenger) {
        super(StandardMessageCodec.INSTANCE);
        this.f64028a = binaryMessenger;
    }

    public static void a(int i) {
        if (f64027b.containsKey(String.valueOf(i))) {
            f64027b.remove(Integer.valueOf(i));
        }
    }

    @Override // io.flutter.plugin.platform.PlatformViewFactory
    public PlatformView create(Context context, int i, Object obj) {
        Map map = (obj == null || !(obj instanceof Map)) ? null : (Map) obj;
        String valueOf = map == null ? "0" : String.valueOf(map.get("persistentViewId"));
        if (Integer.parseInt(valueOf) < 0) {
            a aVar = f64027b.get(valueOf);
            if (aVar == null) {
                a aVar2 = new a(context, this.f64028a, i, map);
                f64027b.put(valueOf, aVar2);
                return aVar2;
            }
            return aVar;
        }
        return new a(context, this.f64028a, i, map);
    }
}

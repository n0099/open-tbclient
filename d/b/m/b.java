package d.b.m;

import android.content.Context;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.StandardMessageCodec;
import io.flutter.plugin.platform.PlatformView;
import io.flutter.plugin.platform.PlatformViewFactory;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public final class b extends PlatformViewFactory {

    /* renamed from: b  reason: collision with root package name */
    public static HashMap<String, a> f64026b = new HashMap<>();

    /* renamed from: a  reason: collision with root package name */
    public final BinaryMessenger f64027a;

    public b(BinaryMessenger binaryMessenger) {
        super(StandardMessageCodec.INSTANCE);
        this.f64027a = binaryMessenger;
    }

    public static void a(int i) {
        if (f64026b.containsKey(String.valueOf(i))) {
            f64026b.remove(Integer.valueOf(i));
        }
    }

    @Override // io.flutter.plugin.platform.PlatformViewFactory
    public PlatformView create(Context context, int i, Object obj) {
        Map map = (obj == null || !(obj instanceof Map)) ? null : (Map) obj;
        String valueOf = map == null ? "0" : String.valueOf(map.get("persistentViewId"));
        if (Integer.parseInt(valueOf) < 0) {
            a aVar = f64026b.get(valueOf);
            if (aVar == null) {
                a aVar2 = new a(context, this.f64027a, i, map);
                f64026b.put(valueOf, aVar2);
                return aVar2;
            }
            return aVar;
        }
        return new a(context, this.f64027a, i, map);
    }
}

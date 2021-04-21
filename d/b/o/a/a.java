package d.b.o.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.LongSparseArray;
import androidx.annotation.NonNull;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.flutter.cyberplayer.CyberRemotePlayerService;
import d.b.o.a.c;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.view.TextureRegistry;
import java.util.HashMap;
/* loaded from: classes.dex */
public class a implements FlutterPlugin, MethodChannel.MethodCallHandler {

    /* renamed from: e  reason: collision with root package name */
    public MethodChannel f65115e;

    /* renamed from: f  reason: collision with root package name */
    public Context f65116f;

    /* renamed from: g  reason: collision with root package name */
    public d f65117g;

    /* renamed from: h  reason: collision with root package name */
    public LongSparseArray<d.b.o.a.c> f65118h;
    public final BroadcastReceiver i = new c();

    /* renamed from: d.b.o.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C1769a implements c.a {
        public C1769a() {
        }

        @Override // d.b.o.a.c.a
        public void a(long j) {
            a.this.f65118h.delete(j);
        }
    }

    /* loaded from: classes.dex */
    public class b implements CyberPlayerManager.OnDeleteListener {
        public b() {
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnDeleteListener
        public void onDeleteComplete(int i, long j) {
            HashMap hashMap = new HashMap();
            hashMap.put("result", Integer.valueOf(i));
            hashMap.put("freeSpaceSize", Long.valueOf(j));
            a.this.f65115e.invokeMethod("onDeleteComplete", hashMap);
        }
    }

    /* loaded from: classes.dex */
    public class c extends BroadcastReceiver {
        public c() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("android.intent.action.HEADSET_PLUG") && intent.hasExtra("state")) {
                int intExtra = intent.getIntExtra("state", 0);
                boolean z = true;
                z = (intExtra == 0 || intExtra != 1) ? false : false;
                for (int i = 0; i < a.this.f65118h.size(); i++) {
                    d.b.o.a.c valueAt = a.this.f65118h.valueAt(i);
                    if (valueAt != null) {
                        valueAt.b(z);
                    }
                }
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class d {

        /* renamed from: a  reason: collision with root package name */
        public final Context f65121a;

        /* renamed from: b  reason: collision with root package name */
        public final BinaryMessenger f65122b;

        /* renamed from: c  reason: collision with root package name */
        public final TextureRegistry f65123c;

        public d(Context context, BinaryMessenger binaryMessenger, TextureRegistry textureRegistry) {
            this.f65121a = context;
            this.f65122b = binaryMessenger;
            this.f65123c = textureRegistry;
        }
    }

    public void b(String str, int i, HashMap hashMap, String str2) {
        if (CyberPlayerManager.isCoreLoaded(1)) {
            return;
        }
        try {
            CyberPlayerManager.install(this.f65116f, str, str2, i, CyberRemotePlayerService.class, hashMap, null);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void c(String str, int i) {
        CyberPlayerManager.prefetch(str, null, null, i, null);
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onAttachedToEngine(@NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        this.f65117g = new d(flutterPluginBinding.getApplicationContext(), flutterPluginBinding.getBinaryMessenger(), flutterPluginBinding.getTextureRegistry());
        MethodChannel methodChannel = new MethodChannel(flutterPluginBinding.getFlutterEngine().getDartExecutor(), "cyberplayer");
        this.f65115e = methodChannel;
        methodChannel.setMethodCallHandler(this);
        this.f65116f = flutterPluginBinding.getApplicationContext();
        this.f65118h = new LongSparseArray<>();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.HEADSET_PLUG");
        this.f65116f.registerReceiver(this.i, intentFilter);
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onDetachedFromEngine(@NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        this.f65115e.setMethodCallHandler(null);
        this.f65116f.unregisterReceiver(this.i);
        for (int i = 0; i < this.f65118h.size(); i++) {
            d.b.o.a.c valueAt = this.f65118h.valueAt(i);
            if (valueAt != null) {
                valueAt.a();
            }
        }
    }

    @Override // io.flutter.plugin.common.MethodChannel.MethodCallHandler
    public void onMethodCall(@NonNull MethodCall methodCall, @NonNull MethodChannel.Result result) {
        if (methodCall.method.equals("create")) {
            String str = (String) methodCall.argument("url");
            boolean booleanValue = ((Boolean) methodCall.argument("isLoop")).booleanValue();
            String str2 = (String) methodCall.argument("clarityInfo");
            int intValue = ((Integer) methodCall.argument("switchMediaSource")).intValue();
            HashMap hashMap = (HashMap) methodCall.argument("options");
            TextureRegistry.SurfaceTextureEntry createSurfaceTexture = this.f65117g.f65123c.createSurfaceTexture();
            d.b.o.a.c cVar = new d.b.o.a.c(this.f65117g.f65121a, this.f65117g.f65122b, createSurfaceTexture, hashMap, str, str2, intValue, booleanValue);
            cVar.e(new C1769a());
            this.f65118h.put(createSurfaceTexture.id(), cVar);
            result.success(Long.valueOf(createSurfaceTexture.id()));
        } else if (methodCall.method.equals("init")) {
            HashMap hashMap2 = (HashMap) methodCall.arguments;
            b((String) hashMap2.get("clientId"), ((Integer) hashMap2.get("installType")).intValue(), (HashMap) hashMap2.get("opt"), (String) hashMap2.get("downloadCoreServer"));
        } else if (methodCall.method.equals("startPreload")) {
            HashMap hashMap3 = (HashMap) methodCall.arguments;
            c((String) hashMap3.get("url"), ((Integer) hashMap3.get("length")).intValue());
        } else if (methodCall.method.equals("stopPreload")) {
            CyberPlayerManager.stopPrefetch((String) methodCall.arguments);
        } else if (methodCall.method.equals("hasCacheFile")) {
            CyberPlayerManager.hasCacheFile((String) methodCall.arguments);
        } else if (methodCall.method.equals("deleteVideoCache")) {
            CyberPlayerManager.deleteVideoCache(new b());
        } else if (methodCall.method.equals("getDevicePlayQualityScore")) {
            CyberPlayerManager.getDevicePlayQualityScore((String) methodCall.argument("mimeType"), ((Integer) methodCall.argument("decodeMode")).intValue(), ((Integer) methodCall.argument("width")).intValue(), ((Integer) methodCall.argument("height")).intValue(), (HashMap) methodCall.argument("options"));
        } else {
            result.notImplemented();
        }
    }
}

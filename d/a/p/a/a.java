package d.a.p.a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.LongSparseArray;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.flutter.cyberplayer.CyberRemotePlayerService;
import com.baidu.searchbox.cloudcontrol.utils.CloudStabilityUBCUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.p.a.c;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.view.TextureRegistry;
import java.util.HashMap;
/* loaded from: classes8.dex */
public class a implements FlutterPlugin, MethodChannel.MethodCallHandler {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public MethodChannel f46479e;

    /* renamed from: f  reason: collision with root package name */
    public Context f46480f;

    /* renamed from: g  reason: collision with root package name */
    public d f46481g;

    /* renamed from: h  reason: collision with root package name */
    public LongSparseArray<d.a.p.a.c> f46482h;

    /* renamed from: i  reason: collision with root package name */
    public final BroadcastReceiver f46483i;

    /* renamed from: d.a.p.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C0677a implements c.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f46484a;

        public C0677a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46484a = aVar;
        }

        @Override // d.a.p.a.c.a
        public void a(long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
                this.f46484a.f46482h.delete(j);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements CyberPlayerManager.OnDeleteListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f46485a;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46485a = aVar;
        }

        @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnDeleteListener
        public void onDeleteComplete(int i2, long j) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Integer.valueOf(i2), Long.valueOf(j)}) == null) {
                HashMap hashMap = new HashMap();
                hashMap.put("result", Integer.valueOf(i2));
                hashMap.put("freeSpaceSize", Long.valueOf(j));
                this.f46485a.f46479e.invokeMethod("onDeleteComplete", hashMap);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c extends BroadcastReceiver {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a this$0;

        public c(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.this$0 = aVar;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, context, intent) == null) && intent.getAction().equals("android.intent.action.HEADSET_PLUG") && intent.hasExtra("state")) {
                int intExtra = intent.getIntExtra("state", 0);
                boolean z = true;
                z = (intExtra == 0 || intExtra != 1) ? false : false;
                for (int i2 = 0; i2 < this.this$0.f46482h.size(); i2++) {
                    d.a.p.a.c valueAt = this.this$0.f46482h.valueAt(i2);
                    if (valueAt != null) {
                        valueAt.b(z);
                    }
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public static final class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final Context f46486a;

        /* renamed from: b  reason: collision with root package name */
        public final BinaryMessenger f46487b;

        /* renamed from: c  reason: collision with root package name */
        public final TextureRegistry f46488c;

        public d(Context context, BinaryMessenger binaryMessenger, TextureRegistry textureRegistry) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, binaryMessenger, textureRegistry};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f46486a = context;
            this.f46487b = binaryMessenger;
            this.f46488c = textureRegistry;
        }
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f46483i = new c(this);
    }

    public void b(String str, int i2, HashMap hashMap, String str2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLILL(1048576, this, str, i2, hashMap, str2) == null) || CyberPlayerManager.isCoreLoaded(1)) {
            return;
        }
        try {
            CyberPlayerManager.install(this.f46480f, str, str2, i2, CyberRemotePlayerService.class, hashMap, null);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void c(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str, i2) == null) {
            CyberPlayerManager.prefetch(str, null, null, i2, null);
        }
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onAttachedToEngine(@NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, flutterPluginBinding) == null) {
            this.f46481g = new d(flutterPluginBinding.getApplicationContext(), flutterPluginBinding.getBinaryMessenger(), flutterPluginBinding.getTextureRegistry());
            MethodChannel methodChannel = new MethodChannel(flutterPluginBinding.getFlutterEngine().getDartExecutor(), "cyberplayer");
            this.f46479e = methodChannel;
            methodChannel.setMethodCallHandler(this);
            this.f46480f = flutterPluginBinding.getApplicationContext();
            this.f46482h = new LongSparseArray<>();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.HEADSET_PLUG");
            this.f46480f.registerReceiver(this.f46483i, intentFilter);
        }
    }

    @Override // io.flutter.embedding.engine.plugins.FlutterPlugin
    public void onDetachedFromEngine(@NonNull FlutterPlugin.FlutterPluginBinding flutterPluginBinding) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, flutterPluginBinding) == null) {
            this.f46479e.setMethodCallHandler(null);
            this.f46480f.unregisterReceiver(this.f46483i);
            for (int i2 = 0; i2 < this.f46482h.size(); i2++) {
                d.a.p.a.c valueAt = this.f46482h.valueAt(i2);
                if (valueAt != null) {
                    valueAt.a();
                }
            }
        }
    }

    @Override // io.flutter.plugin.common.MethodChannel.MethodCallHandler
    public void onMethodCall(@NonNull MethodCall methodCall, @NonNull MethodChannel.Result result) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, methodCall, result) == null) {
            if (methodCall.method.equals("create")) {
                String str = (String) methodCall.argument("url");
                boolean booleanValue = ((Boolean) methodCall.argument("isLoop")).booleanValue();
                String str2 = (String) methodCall.argument("clarityInfo");
                int intValue = ((Integer) methodCall.argument("switchMediaSource")).intValue();
                HashMap hashMap = (HashMap) methodCall.argument("options");
                TextureRegistry.SurfaceTextureEntry createSurfaceTexture = this.f46481g.f46488c.createSurfaceTexture();
                d.a.p.a.c cVar = new d.a.p.a.c(this.f46481g.f46486a, this.f46481g.f46487b, createSurfaceTexture, hashMap, str, str2, intValue, booleanValue);
                cVar.e(new C0677a(this));
                this.f46482h.put(createSurfaceTexture.id(), cVar);
                result.success(Long.valueOf(createSurfaceTexture.id()));
            } else if (methodCall.method.equals("init")) {
                HashMap hashMap2 = (HashMap) methodCall.arguments;
                b((String) hashMap2.get("clientId"), ((Integer) hashMap2.get("installType")).intValue(), (HashMap) hashMap2.get("opt"), (String) hashMap2.get("downloadCoreServer"));
            } else if (methodCall.method.equals("startPreload")) {
                HashMap hashMap3 = (HashMap) methodCall.arguments;
                c((String) hashMap3.get("url"), ((Integer) hashMap3.get(CloudStabilityUBCUtils.KEY_LENGTH)).intValue());
            } else if (methodCall.method.equals("stopPreload")) {
                CyberPlayerManager.stopPrefetch((String) methodCall.arguments);
            } else if (methodCall.method.equals("hasCacheFile")) {
                CyberPlayerManager.hasCacheFile((String) methodCall.arguments);
            } else if (methodCall.method.equals("deleteVideoCache")) {
                CyberPlayerManager.deleteVideoCache(new b(this));
            } else if (methodCall.method.equals("getDevicePlayQualityScore")) {
                CyberPlayerManager.getDevicePlayQualityScore((String) methodCall.argument("mimeType"), ((Integer) methodCall.argument("decodeMode")).intValue(), ((Integer) methodCall.argument("width")).intValue(), ((Integer) methodCall.argument("height")).intValue(), (HashMap) methodCall.argument("options"));
            } else {
                result.notImplemented();
            }
        }
    }
}

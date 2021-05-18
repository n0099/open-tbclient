package d.a.o.a;

import android.content.Context;
import android.view.Surface;
import androidx.annotation.NonNull;
import com.baidu.cyberplayer.sdk.CyberPlayer;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.flutter.cyberplayer.FlutterCyberView;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.view.TextureRegistry;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public class c implements CyberPlayerManager.OnPreparedListener, CyberPlayerManager.OnCompletionListener, CyberPlayerManager.OnInfoListener, CyberPlayerManager.OnErrorListener, CyberPlayerManager.OnVideoSizeChangedListener, CyberPlayerManager.OnBufferingUpdateListener, CyberPlayerManager.OnSeekCompleteListener, CyberPlayerManager.OnMediaSourceChangedListener, MethodChannel.MethodCallHandler {

    /* renamed from: e  reason: collision with root package name */
    public TextureRegistry.SurfaceTextureEntry f64033e;

    /* renamed from: f  reason: collision with root package name */
    public WeakReference<Context> f64034f;

    /* renamed from: g  reason: collision with root package name */
    public String f64035g;

    /* renamed from: h  reason: collision with root package name */
    public Context f64036h;

    /* renamed from: i  reason: collision with root package name */
    public FlutterCyberView f64037i;
    public Surface j;
    public CyberPlayer k;
    public long l;
    public MethodChannel m;
    public a n;

    /* loaded from: classes2.dex */
    public interface a {
        void a(long j);
    }

    public c(Context context, BinaryMessenger binaryMessenger, TextureRegistry.SurfaceTextureEntry surfaceTextureEntry, HashMap<String, String> hashMap, String str, String str2, int i2, boolean z) {
        this.f64034f = new WeakReference<>(context);
        this.f64033e = surfaceTextureEntry;
        this.f64035g = str;
        this.f64036h = context;
        FlutterCyberView flutterCyberView = new FlutterCyberView(context);
        this.f64037i = flutterCyberView;
        flutterCyberView.setOnPreparedListener(this);
        this.f64037i.setOnCompletionListener(this);
        this.f64037i.setOnErrorListener(this);
        this.f64037i.setOnInfoListener(this);
        this.f64037i.setOnBufferingUpdateListener(this);
        this.f64037i.setOnSeekCompleteListener(this);
        this.f64037i.setOnMediaSourceChangedListener(this);
        if (hashMap != null) {
            g(hashMap);
        }
        if (str2 != null) {
            this.f64037i.setClarityInfo(str2);
        }
        if (i2 != -1) {
            this.f64037i.switchMediaSource(i2);
        }
        this.f64037i.setVideoPath(str);
        this.f64037i.setLooping(z);
        this.f64037i.setContinuePlayEnable(true);
        this.j = new Surface(surfaceTextureEntry.surfaceTexture());
        CyberPlayer cyberPlayer = this.f64037i.getCyberPlayer();
        this.k = cyberPlayer;
        cyberPlayer.setSurface(this.j);
        this.l = surfaceTextureEntry.id();
        MethodChannel methodChannel = new MethodChannel(binaryMessenger, "bd_video_player_" + this.l);
        this.m = methodChannel;
        methodChannel.setMethodCallHandler(this);
    }

    public void a() {
        MethodChannel methodChannel = this.m;
        if (methodChannel != null) {
            methodChannel.setMethodCallHandler(null);
            this.m = null;
        }
        FlutterCyberView flutterCyberView = this.f64037i;
        if (flutterCyberView != null) {
            flutterCyberView.t();
        }
        Surface surface = this.j;
        if (surface != null) {
            surface.release();
        }
        TextureRegistry.SurfaceTextureEntry surfaceTextureEntry = this.f64033e;
        if (surfaceTextureEntry != null) {
            surfaceTextureEntry.release();
        }
        a aVar = this.n;
        if (aVar != null) {
            aVar.a(this.l);
        }
    }

    public void b(boolean z) {
        if (isPlaying()) {
            this.m.invokeMethod("onHeadSetPlugged", Boolean.valueOf(z));
        }
    }

    public void c(MethodCall methodCall, @NonNull MethodChannel.Result result) {
        if (methodCall.method.equals("contentURL")) {
            this.f64037i.setVideoPath((String) methodCall.arguments);
            result.success(Boolean.TRUE);
        } else if (methodCall.method.equals("scalModel")) {
            this.f64037i.setVideoScalingMode(((Integer) methodCall.arguments).intValue());
            result.success(Boolean.TRUE);
        } else if (methodCall.method.equals("setVideoRotation")) {
            this.f64037i.setVideoRotation(((Integer) methodCall.arguments).intValue());
            result.success(Boolean.TRUE);
        } else if (methodCall.method.equals("setVideoDecodeMode")) {
            this.f64037i.setDecodeMode(((Integer) methodCall.arguments).intValue());
            result.success(Boolean.TRUE);
        } else if (methodCall.method.equals("getNaturalSize")) {
            int videoWidth = this.k.getVideoWidth();
            int videoHeight = this.k.getVideoHeight();
            HashMap hashMap = new HashMap();
            hashMap.put("width", Integer.valueOf(videoWidth));
            hashMap.put("height", Integer.valueOf(videoHeight));
            result.success(hashMap);
        }
    }

    public final void d() {
        this.f64037i.pause();
    }

    public void e(a aVar) {
        this.n = aVar;
    }

    public void f(boolean z) {
        if (z) {
            this.k.setVolume(0.0f, 0.0f);
            b.a(this.f64034f, true);
            return;
        }
        this.k.setVolume(1.0f, 1.0f);
        b.a(this.f64034f, false);
    }

    public void g(HashMap<String, String> hashMap) {
        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
            this.f64037i.setOption(entry.getKey(), entry.getValue());
        }
    }

    public boolean isPlaying() {
        return this.f64037i.isPlaying();
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnBufferingUpdateListener
    public void onBufferingUpdate(int i2) {
        this.m.invokeMethod("onBufferingUpdate", Integer.valueOf(i2));
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
    public void onCompletion() {
        d.b().c(this.f64035g);
        this.m.invokeMethod("onCompletion", "");
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
    public boolean onError(int i2, int i3, Object obj) {
        this.m.invokeMethod("onError", Integer.valueOf(i2));
        return false;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
    public boolean onInfo(int i2, int i3, Object obj) {
        this.m.invokeMethod("onInfo", Integer.valueOf(i2));
        return false;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnMediaSourceChangedListener
    public boolean onMediaSourceChanged(int i2, int i3, Object obj) {
        HashMap hashMap = new HashMap();
        hashMap.put("result", Integer.valueOf(i2));
        hashMap.put("rank", Integer.valueOf(i3));
        this.m.invokeMethod("onMediaSourceChanged", hashMap);
        return false;
    }

    @Override // io.flutter.plugin.common.MethodChannel.MethodCallHandler
    public void onMethodCall(@NonNull MethodCall methodCall, @NonNull MethodChannel.Result result) {
        if (methodCall.method.equals("play")) {
            startPlay();
            result.success(Boolean.TRUE);
        } else if (methodCall.method.equals("pause")) {
            d();
            result.success(Boolean.TRUE);
        } else if (methodCall.method.equals(IntentConfig.STOP)) {
            a();
            result.success(Boolean.TRUE);
        } else if (methodCall.method.equals("reset")) {
            this.f64037i.reset();
            result.success(Boolean.TRUE);
        } else if (methodCall.method.equals("setMute")) {
            f(((Boolean) methodCall.arguments).booleanValue());
            result.success(Boolean.TRUE);
        } else if (methodCall.method.equals("getDuration")) {
            result.success(Double.valueOf(this.k.getDuration() / 1000));
        } else if (methodCall.method.equals("getCurrentDuration")) {
            result.success(Double.valueOf(this.k.getCurrentPositionSync() / 1000));
        } else if (methodCall.method.equals("getPlayedTime")) {
            result.success(Long.valueOf(this.k.getPlayedTime()));
        } else if (methodCall.method.equals("playbackRate")) {
            this.k.setSpeed((float) ((Double) methodCall.arguments).doubleValue());
            result.success(Boolean.TRUE);
        } else if (methodCall.method.equals("playbackVolume")) {
            float doubleValue = (float) ((Double) methodCall.arguments).doubleValue();
            this.k.setVolume(doubleValue, doubleValue);
            result.success(Boolean.TRUE);
        } else if (methodCall.method.equals("seek")) {
            int doubleValue2 = ((int) ((Double) methodCall.arguments).doubleValue()) * 1000;
            int duration = this.k.getDuration();
            if (doubleValue2 > duration) {
                doubleValue2 = duration;
            }
            this.f64037i.seekTo(doubleValue2);
            result.success(Boolean.TRUE);
        } else if (methodCall.method.equals("setEnableLooping")) {
            this.f64037i.setLooping(((Boolean) methodCall.arguments).booleanValue());
            result.success(Boolean.TRUE);
        } else if (methodCall.method.equals("getDownloadSpeed")) {
            result.success(Long.valueOf(this.f64037i.getDownloadSpeed()));
        } else if (methodCall.method.equals("setDecodeMode")) {
            this.f64037i.setDecodeMode(((Integer) methodCall.arguments).intValue());
            result.success(Boolean.TRUE);
        } else if (methodCall.method.equals("setExternalInfo")) {
            this.f64037i.setExternalInfo((String) methodCall.argument("what"), (HashMap) methodCall.argument("info"));
            result.success(Boolean.TRUE);
        } else if (methodCall.method.equals("setClarityInfo")) {
            this.f64037i.setClarityInfo((String) methodCall.arguments);
            result.success(Boolean.TRUE);
        } else if (methodCall.method.equals("setPlayJson")) {
            this.f64037i.setPlayJson((String) methodCall.arguments);
            result.success(Boolean.TRUE);
        } else if (methodCall.method.equals("switchMediaSource")) {
            this.f64037i.switchMediaSource(((Integer) methodCall.arguments).intValue());
            result.success(Boolean.TRUE);
        } else {
            c(methodCall, result);
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
    public void onPrepared() {
        this.m.invokeMethod("onPrepared", "");
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnSeekCompleteListener
    public void onSeekComplete() {
        this.m.invokeMethod("onSeekComplete", "");
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnVideoSizeChangedListener
    public void onVideoSizeChanged(int i2, int i3, int i4, int i5) {
        HashMap hashMap = new HashMap();
        hashMap.put("width", Integer.valueOf(i2));
        hashMap.put("height", Integer.valueOf(i3));
        this.m.invokeMethod("onVideoSizeChanged", hashMap);
    }

    public final void startPlay() {
        if (isPlaying()) {
            return;
        }
        this.f64037i.start();
    }
}

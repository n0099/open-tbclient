package d.b.p.a;

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
    public TextureRegistry.SurfaceTextureEntry f64235e;

    /* renamed from: f  reason: collision with root package name */
    public WeakReference<Context> f64236f;

    /* renamed from: g  reason: collision with root package name */
    public String f64237g;

    /* renamed from: h  reason: collision with root package name */
    public Context f64238h;
    public FlutterCyberView i;
    public Surface j;
    public CyberPlayer k;
    public long l;
    public MethodChannel m;
    public a n;

    /* loaded from: classes2.dex */
    public interface a {
        void a(long j);
    }

    public c(Context context, BinaryMessenger binaryMessenger, TextureRegistry.SurfaceTextureEntry surfaceTextureEntry, HashMap<String, String> hashMap, String str, String str2, int i, boolean z) {
        this.f64236f = new WeakReference<>(context);
        this.f64235e = surfaceTextureEntry;
        this.f64237g = str;
        this.f64238h = context;
        FlutterCyberView flutterCyberView = new FlutterCyberView(context);
        this.i = flutterCyberView;
        flutterCyberView.setOnPreparedListener(this);
        this.i.setOnCompletionListener(this);
        this.i.setOnErrorListener(this);
        this.i.setOnInfoListener(this);
        this.i.setOnBufferingUpdateListener(this);
        this.i.setOnSeekCompleteListener(this);
        this.i.setOnMediaSourceChangedListener(this);
        if (hashMap != null) {
            g(hashMap);
        }
        if (str2 != null) {
            this.i.setClarityInfo(str2);
        }
        if (i != -1) {
            this.i.switchMediaSource(i);
        }
        this.i.setVideoPath(str);
        this.i.setLooping(z);
        this.i.setContinuePlayEnable(true);
        this.j = new Surface(surfaceTextureEntry.surfaceTexture());
        CyberPlayer cyberPlayer = this.i.getCyberPlayer();
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
        FlutterCyberView flutterCyberView = this.i;
        if (flutterCyberView != null) {
            flutterCyberView.u();
        }
        Surface surface = this.j;
        if (surface != null) {
            surface.release();
        }
        TextureRegistry.SurfaceTextureEntry surfaceTextureEntry = this.f64235e;
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
            this.i.setVideoPath((String) methodCall.arguments);
            result.success(Boolean.TRUE);
        } else if (methodCall.method.equals("scalModel")) {
            this.i.setVideoScalingMode(((Integer) methodCall.arguments).intValue());
            result.success(Boolean.TRUE);
        } else if (methodCall.method.equals("setVideoRotation")) {
            this.i.setVideoRotation(((Integer) methodCall.arguments).intValue());
            result.success(Boolean.TRUE);
        } else if (methodCall.method.equals("setVideoDecodeMode")) {
            this.i.setDecodeMode(((Integer) methodCall.arguments).intValue());
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
        this.i.pause();
    }

    public void e(a aVar) {
        this.n = aVar;
    }

    public void f(boolean z) {
        if (z) {
            this.k.setVolume(0.0f, 0.0f);
            b.a(this.f64236f, true);
            return;
        }
        this.k.setVolume(1.0f, 1.0f);
        b.a(this.f64236f, false);
    }

    public void g(HashMap<String, String> hashMap) {
        for (Map.Entry<String, String> entry : hashMap.entrySet()) {
            this.i.setOption(entry.getKey(), entry.getValue());
        }
    }

    public boolean isPlaying() {
        return this.i.isPlaying();
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnBufferingUpdateListener
    public void onBufferingUpdate(int i) {
        this.m.invokeMethod("onBufferingUpdate", Integer.valueOf(i));
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
    public void onCompletion() {
        d.b().c(this.f64237g);
        this.m.invokeMethod("onCompletion", "");
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
    public boolean onError(int i, int i2, Object obj) {
        this.m.invokeMethod("onError", Integer.valueOf(i));
        return false;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
    public boolean onInfo(int i, int i2, Object obj) {
        this.m.invokeMethod("onInfo", Integer.valueOf(i));
        return false;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnMediaSourceChangedListener
    public boolean onMediaSourceChanged(int i, int i2, Object obj) {
        HashMap hashMap = new HashMap();
        hashMap.put("result", Integer.valueOf(i));
        hashMap.put("rank", Integer.valueOf(i2));
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
            this.i.reset();
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
            this.i.seekTo(doubleValue2);
            result.success(Boolean.TRUE);
        } else if (methodCall.method.equals("setEnableLooping")) {
            this.i.setLooping(((Boolean) methodCall.arguments).booleanValue());
            result.success(Boolean.TRUE);
        } else if (methodCall.method.equals("getDownloadSpeed")) {
            result.success(Long.valueOf(this.i.getDownloadSpeed()));
        } else if (methodCall.method.equals("setDecodeMode")) {
            this.i.setDecodeMode(((Integer) methodCall.arguments).intValue());
            result.success(Boolean.TRUE);
        } else if (methodCall.method.equals("setExternalInfo")) {
            this.i.setExternalInfo((String) methodCall.argument("what"), (HashMap) methodCall.argument("info"));
            result.success(Boolean.TRUE);
        } else if (methodCall.method.equals("setClarityInfo")) {
            this.i.setClarityInfo((String) methodCall.arguments);
            result.success(Boolean.TRUE);
        } else if (methodCall.method.equals("setPlayJson")) {
            this.i.setPlayJson((String) methodCall.arguments);
            result.success(Boolean.TRUE);
        } else if (methodCall.method.equals("switchMediaSource")) {
            this.i.switchMediaSource(((Integer) methodCall.arguments).intValue());
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
    public void onVideoSizeChanged(int i, int i2, int i3, int i4) {
        HashMap hashMap = new HashMap();
        hashMap.put("width", Integer.valueOf(i));
        hashMap.put("height", Integer.valueOf(i2));
        this.m.invokeMethod("onVideoSizeChanged", hashMap);
    }

    public final void startPlay() {
        if (isPlaying()) {
            return;
        }
        this.i.start();
    }
}

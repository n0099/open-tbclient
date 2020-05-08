package top.kikt.ijkplayer;

import android.annotation.TargetApi;
import android.app.Activity;
import android.media.AudioManager;
import android.view.Window;
import android.view.WindowManager;
import com.baidu.sapi2.outsdk.c;
import com.baidu.tbadk.core.TbadkCoreApplication;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.PluginRegistry;
import java.util.Map;
import kotlin.jvm.internal.q;
import tv.danmaku.ijk.media.player.IjkMediaPlayerLocal;
/* loaded from: classes6.dex */
public class IjkplayerPlugin implements MethodChannel.MethodCallHandler {
    private IjkManager manager;
    private PluginRegistry.Registrar registrar;

    public static void registerWith(PluginRegistry.Registrar registrar) {
        new MethodChannel(registrar.messenger(), "top.kikt/ijkplayer").setMethodCallHandler(new IjkplayerPlugin(registrar, new IjkManager(registrar)));
    }

    public IjkplayerPlugin(PluginRegistry.Registrar registrar, IjkManager ijkManager) {
        this.manager = null;
        q.j(registrar, "registrar");
        this.registrar = registrar;
        this.manager = ijkManager;
    }

    public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        IjkMediaPlayerLocal.loadLibrariesOnce(null);
        IjkMediaPlayerLocal.native_profileBegin("libijkplayer.so");
        handleMethodCall(methodCall, result);
    }

    private void handleMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        if (c.l.equals(methodCall.method)) {
            this.manager.disposeAll();
            result.success(true);
        } else if ("create".equals(methodCall.method)) {
            try {
                result.success(Long.valueOf(this.manager.create((Map) methodCall.arguments()).getId()));
            } catch (Exception e) {
                e.printStackTrace();
                result.error("1", "创建失败", e);
            }
        } else if ("dispose".equals(methodCall.method)) {
            this.manager.dispose(((Integer) methodCall.argument("id")).intValue());
            result.success(true);
        } else if ("setSystemVolume".equals(methodCall.method)) {
            setVolume(((Integer) methodCall.argument("volume")).intValue());
            result.success(true);
        } else if ("getSystemVolume".equals(methodCall.method)) {
            result.success(Integer.valueOf(getSystemVolume()));
        } else if ("volumeUp".equals(methodCall.method)) {
            volumeUp();
            result.success(Integer.valueOf(getSystemVolume()));
        } else if ("volumeDown".equals(methodCall.method)) {
            volumeDown();
            result.success(Integer.valueOf(getSystemVolume()));
        } else if ("setSystemBrightness".equals(methodCall.method)) {
            setBrightness((float) ((Double) methodCall.argument("brightness")).doubleValue());
            result.success(true);
        } else if ("getSystemBrightness".equals(methodCall.method)) {
            result.success(Double.valueOf(getBrightness()));
        } else if ("resetBrightness".equals(methodCall.method)) {
            setBrightness(-1.0f);
            result.success(true);
        } else {
            result.notImplemented();
        }
    }

    private int getSystemVolume() {
        return (int) ((getAudioManager().getStreamVolume(3) / getAudioManager().getStreamMaxVolume(3)) * 100.0f);
    }

    private void setVolume(int i) {
        float streamMaxVolume = (100.0f / getAudioManager().getStreamMaxVolume(3)) * getSystemVolume();
        if (i == 0) {
            volumeMute();
        } else if (i == 100) {
            volumeUnMute();
        } else if (i > streamMaxVolume) {
            volumeDown();
        } else if (i < streamMaxVolume) {
            volumeUp();
        }
    }

    private void volumeUp() {
        getAudioManager().adjustStreamVolume(3, 1, 4);
    }

    private void volumeDown() {
        getAudioManager().adjustStreamVolume(3, -1, 4);
    }

    private void volumeMute() {
        getAudioManager().adjustStreamVolume(3, -100, 4);
    }

    private void volumeUnMute() {
        getAudioManager().adjustStreamVolume(3, 100, 4);
    }

    private AudioManager getAudioManager() {
        return (AudioManager) TbadkCoreApplication.getInst().getSystemService("audio");
    }

    @TargetApi(3)
    private void setBrightness(float f) {
        Window window;
        Activity activity = this.registrar.activity();
        if (activity != null && (window = activity.getWindow()) != null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.screenBrightness = f;
            window.setAttributes(attributes);
        }
    }

    @TargetApi(3)
    private float getBrightness() {
        Window window;
        Activity activity = this.registrar.activity();
        if (activity == null || (window = activity.getWindow()) == null) {
            return 0.0f;
        }
        return window.getAttributes().screenBrightness;
    }
}

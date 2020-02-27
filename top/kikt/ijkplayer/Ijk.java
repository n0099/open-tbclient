package top.kikt.ijkplayer;

import android.annotation.TargetApi;
import android.content.Context;
import android.net.Uri;
import android.util.Base64;
import com.baidu.adp.plugin.util.Util;
import com.baidu.down.request.db.DownloadDataConstants;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.live.tbadk.statics.AlaStaticKeys;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.PluginRegistry;
import io.flutter.view.TextureRegistry;
import java.io.File;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import top.kikt.ijkplayer.entity.IjkOption;
import top.kikt.ijkplayer.entity.Info;
import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.IjkMediaPlayerLocal;
import tv.danmaku.ijk.media.player.TextureMediaPlayer;
/* loaded from: classes6.dex */
public class Ijk {
    private Context appContext;
    private int degree;
    private boolean isDisposed;
    private MethodChannel methodChannel;
    private NotifyChannel notifyChannel;
    private Map options;
    private PluginRegistry.Registrar registry;
    private TextureRegistry.SurfaceTextureEntry textureEntry;
    private IjkMediaPlayerLocal mediaPlayer = new IjkMediaPlayerLocal();
    private TextureMediaPlayer textureMediaPlayer = new TextureMediaPlayer(this.mediaPlayer);

    public Ijk(PluginRegistry.Registrar registrar, Map map) {
        this.registry = registrar;
        this.options = map;
        this.appContext = registrar.activity().getApplication();
        this.textureEntry = this.registry.textures().createSurfaceTexture();
        this.methodChannel = new MethodChannel(this.registry.messenger(), "top.kikt/ijkplayer/" + getId());
        this.notifyChannel = new NotifyChannel(this.registry, getId(), this);
        configOptions();
        this.textureMediaPlayer.setSurfaceTexture(this.textureEntry.surfaceTexture());
        this.methodChannel.setMethodCallHandler(new MethodChannel.MethodCallHandler() { // from class: top.kikt.ijkplayer.Ijk.1
            public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
                if (!Ijk.this.isDisposed) {
                    if ("setNetworkDataSource".equals(methodCall.method)) {
                        String str = (String) methodCall.argument(DownloadDataConstants.Columns.COLUMN_URI);
                        Map map2 = (Map) methodCall.argument("headers");
                        if (str == null) {
                            Ijk.this.handleSetUriResult(new Exception("uri是必传参数"), result);
                        }
                        try {
                            Ijk.this.setUri(str, map2);
                        } catch (Exception e) {
                            e.printStackTrace();
                            Ijk.this.handleSetUriResult(e, result);
                        }
                    } else if ("setAssetDataSource".equals(methodCall.method)) {
                        String str2 = (String) methodCall.argument("name");
                        String str3 = (String) methodCall.argument("package");
                        if (str2 != null) {
                            try {
                                Ijk.this.setAssetUri(str2, str3);
                                return;
                            } catch (Throwable th) {
                                th.printStackTrace();
                                Ijk.this.handleSetUriResult(th, result);
                                return;
                            }
                        }
                        Ijk.this.handleSetUriResult(new Exception("资源名为空"), result);
                    } else if ("setFileDataSource".equals(methodCall.method)) {
                        String str4 = (String) methodCall.argument("path");
                        if (str4 != null) {
                            try {
                                Ijk.this.setUri("file://" + str4, null);
                            } catch (Exception e2) {
                                e2.printStackTrace();
                                Ijk.this.handleSetUriResult(e2, result);
                            }
                        }
                    } else if (AlaStaticKeys.ALA_STATIC_VALUE_PLAY.equals(methodCall.method)) {
                        Ijk.this.play();
                        result.success(true);
                    } else if ("pause".equals(methodCall.method)) {
                        Ijk.this.pause();
                        result.success(true);
                    } else if ("stop".equals(methodCall.method)) {
                        Ijk.this.stop();
                        result.success(true);
                    } else if ("getInfo".equals(methodCall.method)) {
                        result.success(Ijk.this.getInfo().toMap());
                    } else if ("seekTo".equals(methodCall.method)) {
                        Double d = (Double) methodCall.argument("target");
                        if (d != null) {
                            Ijk.this.seekTo((long) (d.doubleValue() * 1000.0d));
                        }
                        result.success(true);
                    } else if ("setVolume".equals(methodCall.method)) {
                        Ijk.this.setVolume((Integer) methodCall.argument("volume"));
                        result.success(true);
                    } else if (!"getVolume".equals(methodCall.method)) {
                        if ("screenShot".equals(methodCall.method)) {
                            result.success(Ijk.this.screenShot());
                        } else if ("setSpeed".equals(methodCall.method)) {
                            Ijk.this.mediaPlayer.setSpeed((float) ((Double) methodCall.arguments()).doubleValue());
                        } else {
                            result.notImplemented();
                        }
                    }
                }
            }
        });
    }

    public long getId() {
        return this.textureEntry.id();
    }

    private void configOptions() {
        this.mediaPlayer.setOption(1, "fflags", "fastseek");
        this.mediaPlayer.setOption(4, LogConfig.RECONNECT, 5L);
        this.mediaPlayer.setOption(4, "framedrop", 5L);
        this.mediaPlayer.setOption(4, "enable-accurate-seek", 1L);
        this.mediaPlayer.setOption(4, "mediacodec", 1L);
        this.mediaPlayer.setOption(4, "packet-buffering", 1L);
        if (this.options.get("options") instanceof List) {
            for (Object obj : (List) this.options.get("options")) {
                if (obj instanceof Map) {
                    IjkOption ijkOption = new IjkOption((Map) obj);
                    int convertTocategory = IjkOption.convertTocategory(ijkOption.type);
                    if (convertTocategory != -1) {
                        if ((ijkOption.value instanceof Integer) || (ijkOption.value instanceof Long)) {
                            this.mediaPlayer.setOption(convertTocategory, ijkOption.key, ((Integer) ijkOption.value).intValue());
                        } else if (ijkOption.value instanceof String) {
                            this.mediaPlayer.setOption(convertTocategory, ijkOption.key, (String) ijkOption.value);
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public byte[] screenShot() {
        return null;
    }

    public Info getInfo() {
        long duration = this.mediaPlayer.getDuration();
        long currentPosition = this.mediaPlayer.getCurrentPosition();
        return new Info(duration / 1000.0d, 8888, currentPosition / 1000.0d, this.mediaPlayer.getVideoWidth(), this.mediaPlayer.getVideoHeight(), this.textureMediaPlayer.isPlaying(), this.degree, this.mediaPlayer.getTcpSpeed(), this.mediaPlayer.getVideoOutputFramesPerSecond());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleSetUriResult(Throwable th, MethodChannel.Result result) {
        if (result != null) {
            if (th == null) {
                result.success(true);
                return;
            }
            th.printStackTrace();
            result.error("1", "set resource error", th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setUri(String str, Map map) throws Exception {
        this.mediaPlayer.setDataSource(this.appContext, Uri.parse(str), map);
        this.mediaPlayer.setAudioStreamType(3);
        this.mediaPlayer.prepareAsync();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @TargetApi(9)
    public void setAssetUri(String str, String str2) throws Throwable {
        this.mediaPlayer.setOnPreparedListener(new IMediaPlayer.OnPreparedListener() { // from class: top.kikt.ijkplayer.Ijk.2
            @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnPreparedListener
            public void onPrepared(IMediaPlayer iMediaPlayer) {
            }
        });
        String lookupKeyForAsset = str2 == null ? this.registry.lookupKeyForAsset(str) : this.registry.lookupKeyForAsset(str, str2);
        InputStream open = this.registry.context().getAssets().open(lookupKeyForAsset);
        File file = new File(this.registry.context().getCacheDir().getAbsoluteFile().getPath(), Base64.encodeToString(lookupKeyForAsset.getBytes(), 0));
        Util.b(open, file);
        this.mediaPlayer.setDataSource(new FileMediaDataSource(file));
        this.mediaPlayer.prepareAsync();
    }

    public final void dispose() {
        if (!this.isDisposed) {
            this.isDisposed = true;
            try {
                this.notifyChannel.dispose();
                this.methodChannel.setMethodCallHandler((MethodChannel.MethodCallHandler) null);
                this.textureMediaPlayer.stop();
                this.textureMediaPlayer.release();
                this.textureEntry.release();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void play() {
        try {
            this.mediaPlayer.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pause() {
        this.textureMediaPlayer.pause();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void stop() {
        this.textureMediaPlayer.stop();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void seekTo(long j) {
        this.textureMediaPlayer.seekTo(j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setVolume(Integer num) {
        if (num != null) {
            float intValue = num.intValue() / 100.0f;
            this.mediaPlayer.setVolume(intValue, intValue);
        }
    }

    public IjkMediaPlayerLocal getMediaPlayer() {
        return this.mediaPlayer;
    }
}

package top.kikt.ijkplayer;

import android.os.Bundle;
import com.baidu.adp.lib.util.BdLog;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.PluginRegistry;
import java.util.Map;
import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.IjkMediaPlayerLocal;
/* loaded from: classes6.dex */
public class NotifyChannel {
    private MethodChannel channel;
    private Ijk ijk;
    private PluginRegistry.Registrar registry;
    private long textureId;

    /* JADX INFO: Access modifiers changed from: private */
    public IjkMediaPlayerLocal getPlayer() {
        return this.ijk.getMediaPlayer();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Map getInfo() {
        return this.ijk.getInfo().toMap();
    }

    public void dispose() {
        getPlayer().resetListeners();
    }

    public NotifyChannel(PluginRegistry.Registrar registrar, long j, Ijk ijk) {
        this.registry = registrar;
        this.textureId = j;
        this.ijk = ijk;
        this.channel = new MethodChannel(this.registry.messenger(), "top.kikt/ijkplayer/event/" + this.textureId);
        getPlayer().setOnPreparedListener(new IMediaPlayer.OnPreparedListener() { // from class: top.kikt.ijkplayer.NotifyChannel.1
            @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnPreparedListener
            public void onPrepared(IMediaPlayer iMediaPlayer) {
                BdLog.i("prepare " + NotifyChannel.this.getInfo());
                NotifyChannel.this.channel.invokeMethod("prepare", NotifyChannel.this.getInfo());
            }
        });
        getPlayer().setOnCompletionListener(new IMediaPlayer.OnCompletionListener() { // from class: top.kikt.ijkplayer.NotifyChannel.2
            @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnCompletionListener
            public void onCompletion(IMediaPlayer iMediaPlayer) {
                BdLog.i("completion " + NotifyChannel.this.getInfo());
                NotifyChannel.this.channel.invokeMethod("finish", NotifyChannel.this.getInfo());
            }
        });
        getPlayer().setOnBufferingUpdateListener(new IMediaPlayer.OnBufferingUpdateListener() { // from class: top.kikt.ijkplayer.NotifyChannel.3
            @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnBufferingUpdateListener
            public void onBufferingUpdate(IMediaPlayer iMediaPlayer, int i) {
                BdLog.i("completion buffer update " + NotifyChannel.this.getInfo() + ' ' + i);
            }
        });
        getPlayer().setOnSeekCompleteListener(new IMediaPlayer.OnSeekCompleteListener() { // from class: top.kikt.ijkplayer.NotifyChannel.4
            @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnSeekCompleteListener
            public void onSeekComplete(IMediaPlayer iMediaPlayer) {
                BdLog.i("onSeekCompletion " + NotifyChannel.this.getInfo());
            }
        });
        getPlayer().setOnInfoListener(new IMediaPlayer.OnInfoListener() { // from class: top.kikt.ijkplayer.NotifyChannel.5
            @Override // tv.danmaku.ijk.media.player.IMediaPlayer.OnInfoListener
            public boolean onInfo(IMediaPlayer iMediaPlayer, int i, int i2) {
                BdLog.i("onInfoListener " + i + ", extra = " + i2 + ", isPlaying = " + NotifyChannel.this.getPlayer().isPlaying());
                return false;
            }
        });
        getPlayer().setOnNativeInvokeListener(new IjkMediaPlayerLocal.OnNativeInvokeListener() { // from class: top.kikt.ijkplayer.NotifyChannel.6
            @Override // tv.danmaku.ijk.media.player.IjkMediaPlayerLocal.OnNativeInvokeListener
            public boolean onNativeInvoke(int i, Bundle bundle) {
                BdLog.i("onNativeInvoke " + i);
                return false;
            }
        });
        getPlayer().setOnControlMessageListener(new IjkMediaPlayerLocal.OnControlMessageListener() { // from class: top.kikt.ijkplayer.NotifyChannel.7
            @Override // tv.danmaku.ijk.media.player.IjkMediaPlayerLocal.OnControlMessageListener
            public String onControlResolveSegmentUrl(int i) {
                BdLog.i("onController message " + i + ", isPlaying = " + NotifyChannel.this.getPlayer().isPlaying());
                return "";
            }
        });
    }
}

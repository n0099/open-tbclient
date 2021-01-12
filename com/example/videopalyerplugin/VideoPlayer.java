package com.example.videopalyerplugin;

import android.content.Context;
import android.view.Surface;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.f.e;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
import com.baidu.cyberplayer.sdk.CyberPlayer;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
import com.baidu.live.adp.framework.MessageConfig;
import com.baidu.live.tbadk.statics.AlaStaticKeys;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.util.ah;
import com.baidu.tieba.play.cyberPlayer.TbCyberVideoView;
import com.baidu.tieba.play.n;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.view.TextureRegistry;
import java.lang.ref.WeakReference;
/* loaded from: classes14.dex */
public class VideoPlayer implements CyberPlayerManager.OnCompletionListener, CyberPlayerManager.OnErrorListener, CyberPlayerManager.OnInfoListener, CyberPlayerManager.OnPreparedListener, TbCyberVideoView.a, MethodChannel.MethodCallHandler {
    private Context context;
    private CyberPlayer cyberPlayer;
    private TbCyberVideoView cyberVideoView;
    private String dataSource;
    private MethodChannel methodChannel;
    private Surface surface;
    private TextureRegistry.SurfaceTextureEntry textureEntry;
    private long viewId;
    private boolean isForceSound = false;
    private boolean isChangingOrientation = false;
    private final CustomMessageListener mHeadSetPlugListener = new CustomMessageListener(2921398) { // from class: com.example.videopalyerplugin.VideoPlayer.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2921398 && (customResponsedMessage.getData() instanceof Boolean)) {
                if (!((Boolean) customResponsedMessage.getData()).booleanValue()) {
                    VideoPlayer.this.isForceSound = false;
                    VideoPlayer.this.initVideoMute();
                } else {
                    if (VideoPlayer.this.isPlaying()) {
                        ah.a(VideoPlayer.this.mWeakContext, true);
                    }
                    VideoPlayer.this.cyberVideoView.setVolume(1.0f, 1.0f);
                    VideoPlayer.this.isForceSound = true;
                    TbSingleton.getInstance().setVideoCardMute(false);
                }
                VideoPlayer.this.methodChannel.invokeMethod("event", "isHeadsetPlugged");
            }
        }
    };
    private final CustomMessageListener mNetworkChangedMessageListener = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.example.videopalyerplugin.VideoPlayer.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage)) {
                VideoPlayer.this.methodChannel.invokeMethod("event", "networkChange");
            }
        }
    };
    private final Runnable mFakePlayerToSpeedRunnable = new Runnable() { // from class: com.example.videopalyerplugin.VideoPlayer.3
        @Override // java.lang.Runnable
        public void run() {
            new TbCyberVideoView(VideoPlayer.this.context).setVideoPath(VideoPlayer.this.dataSource);
        }
    };
    private WeakReference<Context> mWeakContext = new WeakReference<>(TbadkCoreApplication.getInst());

    /* JADX INFO: Access modifiers changed from: package-private */
    public VideoPlayer(Context context, BinaryMessenger binaryMessenger, TextureRegistry.SurfaceTextureEntry surfaceTextureEntry, String str) {
        this.textureEntry = surfaceTextureEntry;
        this.dataSource = str;
        this.context = context;
        this.cyberVideoView = new TbCyberVideoView(context);
        this.cyberVideoView.setOnPreparedListener(this);
        this.cyberVideoView.setOnCompletionListener(this);
        this.cyberVideoView.setOnErrorListener(this);
        this.cyberVideoView.setOnInfoListener(this);
        this.cyberVideoView.setOnSurfaceDestroyedListener(this);
        this.cyberVideoView.setVideoPath(str);
        this.cyberVideoView.setIsUseInflutter(true);
        this.cyberVideoView.setLooping(true);
        this.cyberVideoView.setContinuePlayEnable(true);
        this.surface = new Surface(surfaceTextureEntry.surfaceTexture());
        this.cyberPlayer = this.cyberVideoView.getCyberPlayer();
        this.cyberPlayer.setSurface(this.surface);
        this.viewId = surfaceTextureEntry.id();
        this.methodChannel = new MethodChannel(binaryMessenger, "tb_video_player_" + this.viewId);
        this.methodChannel.setMethodCallHandler(this);
        e.mB().postDelayed(this.mFakePlayerToSpeedRunnable, 200L);
    }

    @Override // io.flutter.plugin.common.MethodChannel.MethodCallHandler
    public void onMethodCall(MethodCall methodCall, MethodChannel.Result result) {
        if (methodCall.method.equals(AlaStaticKeys.ALA_STATIC_VALUE_PLAY) || methodCall.method.equals("startAutoPlay")) {
            int PL = n.dxY().PL(this.dataSource);
            if (PL > 0) {
                this.cyberVideoView.seekTo(PL);
            }
            startPlay();
        } else if (methodCall.method.equals("pause")) {
            pause();
        } else if (methodCall.method.equals("stop")) {
            dispose();
        } else if (methodCall.method.equals("dispose")) {
            dispose();
        } else if (methodCall.method.equals("isMute")) {
            result.success(Boolean.valueOf(this.isForceSound || TbSingleton.getInstance().isVideoCardMute()));
        } else if (methodCall.method.equals("mute")) {
            result.success(Boolean.valueOf(doVideoMute()));
        } else {
            result.notImplemented();
        }
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnPreparedListener
    public void onPrepared() {
        initVideoMute();
        this.methodChannel.invokeMethod("event", "onPrepared");
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnCompletionListener
    public void onCompletion() {
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnErrorListener
    public boolean onError(int i, int i2, Object obj) {
        this.methodChannel.invokeMethod("event", "onError");
        return false;
    }

    @Override // com.baidu.cyberplayer.sdk.CyberPlayerManager.OnInfoListener
    public boolean onInfo(int i, int i2, Object obj) {
        if (i == 3 || i == 904) {
            this.methodChannel.invokeMethod("event", "onInfo");
            return false;
        }
        return false;
    }

    @Override // com.baidu.tieba.play.cyberPlayer.TbCyberVideoView.a
    public void onSurfaceDestroyed() {
        if (!this.isChangingOrientation) {
            stopPlayForSurfaceDestroy();
            this.methodChannel.invokeMethod("event", "onError");
        }
    }

    private void stopPlayForSurfaceDestroy() {
        dispose();
    }

    protected void initVideoMute() {
        if (TbSingleton.getInstance().isVideoCardMute()) {
            this.cyberVideoView.setVolume(0.0f, 0.0f);
        } else {
            this.cyberVideoView.setVolume(1.0f, 1.0f);
        }
    }

    boolean doVideoMute() {
        boolean isVideoCardMute = TbSingleton.getInstance().isVideoCardMute();
        if (isVideoCardMute) {
            this.cyberPlayer.setVolume(1.0f, 1.0f);
            ah.a(this.mWeakContext, true);
        } else {
            this.cyberPlayer.setVolume(0.0f, 0.0f);
            ah.a(this.mWeakContext, false);
        }
        TbSingleton.getInstance().setVideoCardMute(!isVideoCardMute);
        return !isVideoCardMute;
    }

    void dispose() {
        if (this.methodChannel != null) {
            this.methodChannel.setMethodCallHandler(null);
            this.methodChannel = null;
        }
        if (this.surface != null) {
            this.surface.release();
        }
        if (this.cyberVideoView != null) {
            this.cyberVideoView.stop();
            this.cyberVideoView.dyj();
        }
        if (this.textureEntry != null) {
            this.textureEntry.release();
        }
        MessageManager.getInstance().unRegisterListener(this.mNetworkChangedMessageListener);
        MessageManager.getInstance().unRegisterListener(this.mHeadSetPlugListener);
    }

    boolean isPlaying() {
        return this.cyberVideoView.isPlaying();
    }

    private void startPlay() {
        MessageManager.getInstance().registerListener(this.mNetworkChangedMessageListener);
        MessageManager.getInstance().registerListener(this.mHeadSetPlugListener);
        if (!this.cyberVideoView.isPlaying()) {
            this.cyberVideoView.start();
        }
    }

    private void pause() {
        this.cyberVideoView.pause();
    }
}

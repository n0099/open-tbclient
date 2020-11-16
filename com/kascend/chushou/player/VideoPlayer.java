package com.kascend.chushou.player;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.PowerManager;
import android.provider.Settings;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.IMConnection;
import com.baidu.live.tbadk.core.util.TbEnum;
import com.baidu.searchbox.player.event.VideoReceiver;
import com.baidu.searchbox.websocket.WebSocketRequest;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.kascend.chushou.a;
import com.kascend.chushou.a.a;
import com.kascend.chushou.b.a.a.i;
import com.kascend.chushou.b.a.a.k;
import com.kascend.chushou.b.a.a.l;
import com.kascend.chushou.b.a.a.m;
import com.kascend.chushou.b.a.a.n;
import com.kascend.chushou.b.a.a.o;
import com.kascend.chushou.constants.AutoBang;
import com.kascend.chushou.constants.BangInfo;
import com.kascend.chushou.constants.CycleLiveRoomInfo;
import com.kascend.chushou.constants.FullRoomInfo;
import com.kascend.chushou.constants.IconConfig;
import com.kascend.chushou.constants.ListItem;
import com.kascend.chushou.constants.ParserRet;
import com.kascend.chushou.constants.PkNotifyInfo;
import com.kascend.chushou.constants.PlayUrl;
import com.kascend.chushou.constants.PrivilegeInfo;
import com.kascend.chushou.constants.RoomExpandInfo;
import com.kascend.chushou.constants.RoomInfo;
import com.kascend.chushou.constants.SkinConfig;
import com.kascend.chushou.constants.UrlDetails;
import com.kascend.chushou.constants.VideoPlayInfo;
import com.kascend.chushou.d.j;
import com.kascend.chushou.player.c.a;
import com.kascend.chushou.player.ui.a.a;
import com.kascend.chushou.player.ui.h5.a.a;
import com.kascend.chushou.player.ui.h5.b.b;
import com.kascend.chushou.player.ui.h5.d.a;
import com.kascend.chushou.player.ui.h5.redpacket.a;
import com.kascend.chushou.toolkit.d;
import com.kascend.chushou.view.b.a.a;
import com.kascend.chushou.view.base.BaseActivity;
import com.kascend.chushou.widget.gifts.RoomSendGiftView;
import com.kascend.cstvsdk.receiver.CSTVWifiReceiver;
import com.tencent.connect.common.Constants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;
import org.webrtc.MediaStreamTrack;
import tv.chushou.basis.rxjava.RxExecutor;
import tv.chushou.basis.rxjava.annotation.Subscribe;
import tv.chushou.basis.rxjava.thread.EventThread;
import tv.chushou.zues.utils.h;
import tv.chushou.zues.widget.animation.AnimationImageView;
import tv.chushou.zues.widget.fresco.FrescoThumbnailView;
import tv.chushou.zues.widget.kpswitch.widget.KPSwitchRootRelativeLayout;
/* loaded from: classes6.dex */
public class VideoPlayer extends BaseActivity implements a.InterfaceC1001a, a.InterfaceC1004a, b.a, a.InterfaceC1006a, a.InterfaceC1007a, RoomSendGiftView.a {
    private static int A = 60000;

    /* renamed from: a  reason: collision with root package name */
    public static String f4089a = null;
    public static int n = 0;
    private String P;
    private String Q;
    private String R;
    private String S;
    private String ab;
    private String ag;
    private c pjB;
    b pjE;
    public PrivilegeInfo pjF;
    com.kascend.chushou.widget.a.b pjH;
    private KPSwitchRootRelativeLayout pjJ;
    private FrameLayout pjK;
    private ImageView pjL;
    private LinearLayout pjM;
    private com.kascend.chushou.toolkit.d pjN;
    com.kascend.chushou.view.b.a.a pjO;
    private FrescoThumbnailView pjR;
    private FrameLayout pjS;
    public com.kascend.chushou.player.feedback.a pka;
    private a pkc;
    private CSTVWifiReceiver pkd;
    private boolean B = true;
    private boolean C = false;
    private Uri pjx = null;
    private tv.chushou.common.player.a pjy = null;
    public tv.chushou.common.player.a pjz = null;
    public tv.chushou.common.player.a pjA = null;
    public boolean d = false;
    public boolean e = false;
    private e pjC = null;
    private boolean H = false;
    private com.kascend.chushou.view.user.b pjD = null;
    private boolean J = false;
    private boolean K = false;
    private boolean L = false;
    private boolean M = false;
    private long N = 0;
    private int O = 0;
    public boolean g = false;
    private ImageView T = null;
    private TextView U = null;
    private AnimationImageView pjG = null;
    private View cem = null;
    public boolean j = false;
    public float k = 0.0f;
    public float l = 0.0f;
    public boolean m = false;
    public AudioManager pjI = null;
    private d.a pjP = new d.a() { // from class: com.kascend.chushou.player.VideoPlayer.1
        @Override // com.kascend.chushou.toolkit.d.a
        public void a() {
            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.pke != null) {
                VideoPlayer.this.pke.Sv(4);
            }
        }
    };
    private boolean ae = false;
    public boolean q = true;
    public long r = -1;
    public long s = -1;
    private PowerManager.WakeLock pjQ = null;
    public String t = null;
    private final com.kascend.chushou.player.ui.h5.redpacket.a pjT = new com.kascend.chushou.player.ui.h5.redpacket.a(this);
    private final com.kascend.chushou.player.ui.h5.b.b pjU = new com.kascend.chushou.player.ui.h5.b.b(this);
    private final com.kascend.chushou.player.ui.h5.d.a pjV = new com.kascend.chushou.player.ui.h5.d.a(this);
    private final com.kascend.chushou.player.ui.a.a pjW = new com.kascend.chushou.player.ui.a.a(this);
    private final com.kascend.chushou.player.e.a pjX = new com.kascend.chushou.player.e.a();
    private final com.kascend.chushou.player.ui.h5.a.a pjY = new com.kascend.chushou.player.ui.h5.a.a(this);
    private String pjZ = "1";
    private String aq = "2";
    private io.reactivex.disposables.a pkb = new io.reactivex.disposables.a();
    private tv.chushou.zues.c pke = new tv.chushou.zues.c(new Handler.Callback() { // from class: com.kascend.chushou.player.VideoPlayer.6
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            try {
                if (!VideoPlayer.this.isFinishing()) {
                    switch (message.what) {
                        case 1:
                            VideoPlayer.this.pke.removeMessages(1);
                            com.kascend.chushou.c.c.etT().a(VideoPlayer.this.P, VideoPlayer.this.pjE != null ? VideoPlayer.this.pjE.h : null, System.currentTimeMillis());
                            VideoPlayer.this.pke.D(1, VideoPlayer.A);
                            break;
                        case 2:
                            VideoPlayer.this.a(true, (Uri) null, false);
                            break;
                        case 3:
                            VideoPlayer.this.S();
                            break;
                        case 4:
                            if (VideoPlayer.this.pjC != null) {
                                VideoPlayer.this.pjC.a(true);
                            }
                            if (VideoPlayer.this.pjN != null) {
                                VideoPlayer.this.pjN.d();
                                VideoPlayer.this.pjN = null;
                                break;
                            }
                            break;
                        case 5:
                            int i = message.arg1;
                            if (i == 1) {
                                if (VideoPlayer.this.pjC != null) {
                                    VideoPlayer.this.pjC.p();
                                    break;
                                }
                            } else if (i == 2 && VideoPlayer.this.pjC != null) {
                                VideoPlayer.this.pjC.e(message.arg2);
                                break;
                            }
                            break;
                        case 6:
                            if (!com.kascend.chushou.b.etQ().f4066a && !com.kascend.chushou.b.etQ().b && VideoPlayer.this.pjC != null) {
                                VideoPlayer.this.pjC.g(true);
                                break;
                            } else {
                                VideoPlayer.this.c();
                                break;
                            }
                            break;
                        case 7:
                            tv.chushou.zues.utils.e.d(VideoPlayer.this.v, "MSG_BUFFER_DEALY: ");
                            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.pjC != null && VideoPlayer.this.M && !VideoPlayer.this.e) {
                                VideoPlayer.this.pjC.h(true);
                                VideoPlayer.this.N = 0L;
                                VideoPlayer.this.O = 0;
                                VideoPlayer.this.M = false;
                                break;
                            }
                            break;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return false;
        }
    });
    private boolean pkf = false;
    private boolean aw = true;
    private boolean pkh = false;
    private tv.chushou.common.player.b pki = new tv.chushou.common.player.b() { // from class: com.kascend.chushou.player.VideoPlayer.14
        @Override // tv.chushou.common.player.b
        public void euz() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerACallback onSetVideoViewLayout");
            if (!VideoPlayer.this.isFinishing()) {
                if ((VideoPlayer.this.pjC == null || !VideoPlayer.this.pjC.H) && VideoPlayer.this.pjC != null && !VideoPlayer.this.d) {
                    VideoPlayer.this.pjC.y();
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void Rb(int i) {
            if (!VideoPlayer.this.isFinishing()) {
                if ((VideoPlayer.this.pjC == null || !VideoPlayer.this.pjC.H) && VideoPlayer.this.pjC != null && !VideoPlayer.this.d) {
                    VideoPlayer.this.pjC.g(i);
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void euA() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerACallback onCompletePlayback");
            if (!VideoPlayer.this.isFinishing()) {
                if (!h.isEmpty(VideoPlayer.this.P)) {
                    j.eue().a(VideoPlayer.this.P, 0);
                }
                VideoPlayer.this.K = false;
                if (VideoPlayer.this.pke != null) {
                    VideoPlayer.this.pke.removeMessages(1);
                }
                if ((VideoPlayer.this.pjC == null || !VideoPlayer.this.pjC.H) && VideoPlayer.this.pjC != null && !VideoPlayer.this.d) {
                    VideoPlayer.this.pke.removeMessages(7);
                    VideoPlayer.this.M = false;
                    VideoPlayer.this.pjC.z();
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void euB() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerACallback onVideoRenderingStart");
            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.pjC != null) {
                VideoPlayer.this.pjC.G();
            }
        }

        @Override // tv.chushou.common.player.b
        public void euC() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerACallback onPreparedPlayback");
            if (!VideoPlayer.this.isFinishing()) {
                if (VideoPlayer.this.pjC == null || !VideoPlayer.this.pjC.H) {
                    VideoPlayer.this.pke.removeMessages(6);
                    VideoPlayer.this.N = 0L;
                    VideoPlayer.this.O = 0;
                    if (VideoPlayer.this.pjy != null && VideoPlayer.this.pjC != null) {
                        VideoPlayer.this.pjy.setVolume(VideoPlayer.this.pjC.J, VideoPlayer.this.pjC.J);
                    }
                    if (VideoPlayer.this.pjE != null) {
                        VideoPlayer.this.K = false;
                        FullRoomInfo euJ = VideoPlayer.this.eum() ? null : VideoPlayer.this.pjE.euJ();
                        if (VideoPlayer.this.L || euJ != null) {
                            if (VideoPlayer.this.pjE.e) {
                                VideoPlayer.this.pjE.e = false;
                                VideoPlayer.this.pjE.d = !VideoPlayer.this.pjE.d;
                            }
                            if (VideoPlayer.this.pjC != null) {
                                VideoPlayer.this.c("1", (String) null);
                                if (!VideoPlayer.this.d) {
                                    VideoPlayer.this.pjC.i(true);
                                } else if (VideoPlayer.this.e) {
                                    VideoPlayer.this.e = false;
                                    VideoPlayer.this.pjC.B();
                                }
                            }
                        }
                    }
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void Rc(int i) {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerACallback onErrorAppeared");
            if (!VideoPlayer.this.isFinishing()) {
                VideoPlayer.this.c();
                VideoPlayer.this.K = false;
                if (VideoPlayer.this.pke != null) {
                    VideoPlayer.this.pke.removeMessages(7);
                }
                if (VideoPlayer.this.pke != null) {
                    VideoPlayer.this.pke.removeMessages(1);
                }
                if ((VideoPlayer.this.pjC == null || !VideoPlayer.this.pjC.H) && !VideoPlayer.this.eug()) {
                    if (!"10004".equals(VideoPlayer.this.t)) {
                        if (VideoPlayer.this.pjC != null) {
                            if (VideoPlayer.this.d) {
                                VideoPlayer.this.pjz.stop();
                                VideoPlayer.this.pjz.release();
                                VideoPlayer.this.e = false;
                                VideoPlayer.this.pjC.C();
                            }
                            if (!com.kascend.chushou.b.etQ().f4066a && !com.kascend.chushou.b.etQ().b) {
                                VideoPlayer.this.pjC.g(true);
                            } else if (VideoPlayer.this.d) {
                                VideoPlayer.this.pjC.a(i, true);
                            } else {
                                VideoPlayer.this.pjC.a(i, false);
                            }
                            VideoPlayer.this.c("2", (String) null);
                            return;
                        }
                        return;
                    }
                    euA();
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void euD() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerACallback onBufferingStart");
            if (!VideoPlayer.this.isFinishing()) {
                if ((VideoPlayer.this.pjC == null || !VideoPlayer.this.pjC.H) && VideoPlayer.this.pjC != null && !VideoPlayer.this.d) {
                    VideoPlayer.this.pjC.E();
                    VideoPlayer.this.M = true;
                    long currentTimeMillis = System.currentTimeMillis();
                    VideoPlayer.this.pke.removeMessages(7);
                    if (!VideoPlayer.this.g) {
                        VideoPlayer.y(VideoPlayer.this);
                    }
                    tv.chushou.zues.utils.e.d(VideoPlayer.this.v, "currentTime: -- >" + currentTimeMillis + "  bufferTime-->" + VideoPlayer.this.N + "  bufferCount-->" + VideoPlayer.this.O);
                    if (currentTimeMillis - VideoPlayer.this.N >= 20000 || VideoPlayer.this.O < 2 || VideoPlayer.this.pjC.H) {
                        if (VideoPlayer.this.O == 1) {
                            VideoPlayer.this.N = currentTimeMillis;
                        }
                        VideoPlayer.this.pke.D(7, 5000L);
                    } else {
                        VideoPlayer.this.pke.Sv(7);
                    }
                    if (VideoPlayer.this.g) {
                        VideoPlayer.this.g = false;
                    }
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void euE() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerACallback onBufferingEnd");
            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.pjC != null && !VideoPlayer.this.d) {
                VideoPlayer.this.pke.removeMessages(7);
                VideoPlayer.this.M = false;
                if (VideoPlayer.this.pjC == null || !VideoPlayer.this.pjC.H) {
                    if (VideoPlayer.this.pjy == null) {
                        VideoPlayer.this.pjC.a(false, true, false);
                    } else {
                        VideoPlayer.this.pjC.a(true, VideoPlayer.this.pjy.getPlayState() == 4, VideoPlayer.this.pjy.getPlayState() == 5);
                    }
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void onPlayerStart() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerACallback onPlayerStart");
            if (!VideoPlayer.this.isFinishing()) {
                if (VideoPlayer.this.pjC == null || !VideoPlayer.this.pjC.H) {
                    if (VideoPlayer.this.pjC != null && !VideoPlayer.this.d) {
                        if (VideoPlayer.this.pjy != null) {
                            VideoPlayer.this.pjC.F();
                            VideoPlayer.this.pjC.a(true, VideoPlayer.this.pjy.getPlayState() == 4, VideoPlayer.this.pjy.getPlayState() == 5);
                        } else {
                            VideoPlayer.this.pjC.a(false, true, false);
                        }
                    }
                    if (VideoPlayer.this.pke != null && !VideoPlayer.this.eum()) {
                        VideoPlayer.this.pke.removeMessages(1);
                        VideoPlayer.this.pke.D(1, VideoPlayer.A);
                    }
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void euF() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerACallback onPlayerPause");
            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.pke != null) {
                VideoPlayer.this.pke.removeMessages(1);
            }
        }

        @Override // tv.chushou.common.player.b
        public void euG() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerACallback onPlayerStop");
            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.eum() && VideoPlayer.this.pjz != null && !h.isEmpty(VideoPlayer.this.P) && VideoPlayer.this.pjz.getCurrentPos() > 0) {
                j.eue().a(VideoPlayer.this.P, VideoPlayer.this.pjz.getCurrentPos());
            }
        }
    };
    private tv.chushou.common.player.b pkj = new tv.chushou.common.player.b() { // from class: com.kascend.chushou.player.VideoPlayer.15
        @Override // tv.chushou.common.player.b
        public void euz() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerBCallback onSetVideoViewLayout");
            if (!VideoPlayer.this.isFinishing()) {
                if ((VideoPlayer.this.pjC == null || !VideoPlayer.this.pjC.H) && VideoPlayer.this.pjC != null && VideoPlayer.this.d) {
                    VideoPlayer.this.pjC.y();
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void Rb(int i) {
            if (!VideoPlayer.this.isFinishing()) {
                if ((VideoPlayer.this.pjC == null || !VideoPlayer.this.pjC.H) && VideoPlayer.this.pjC != null && VideoPlayer.this.d) {
                    VideoPlayer.this.pjC.g(i);
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void euA() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerBCallback onCompletePlayback");
            if (!VideoPlayer.this.isFinishing()) {
                if (!h.isEmpty(VideoPlayer.this.P)) {
                    j.eue().a(VideoPlayer.this.P, 0);
                }
                VideoPlayer.this.K = false;
                if (VideoPlayer.this.pke != null) {
                    VideoPlayer.this.pke.removeMessages(1);
                }
                if ((VideoPlayer.this.pjC == null || !VideoPlayer.this.pjC.H) && VideoPlayer.this.pjC != null && VideoPlayer.this.d) {
                    VideoPlayer.this.pke.removeMessages(7);
                    VideoPlayer.this.M = false;
                    VideoPlayer.this.pjC.z();
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void euB() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerBCallback onVideoRenderingStart");
            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.pjC != null) {
                VideoPlayer.this.pjC.G();
            }
        }

        @Override // tv.chushou.common.player.b
        public void euC() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerBCallback onPreparedPlayback");
            if (!VideoPlayer.this.isFinishing()) {
                if (VideoPlayer.this.pjC == null || !VideoPlayer.this.pjC.H) {
                    VideoPlayer.this.pke.removeMessages(6);
                    VideoPlayer.this.N = 0L;
                    VideoPlayer.this.O = 0;
                    if (VideoPlayer.this.pjy != null && VideoPlayer.this.pjC != null) {
                        VideoPlayer.this.pjy.setVolume(VideoPlayer.this.pjC.J, VideoPlayer.this.pjC.J);
                    }
                    if (VideoPlayer.this.pjE != null) {
                        VideoPlayer.this.K = false;
                        FullRoomInfo euJ = VideoPlayer.this.eum() ? null : VideoPlayer.this.pjE.euJ();
                        if (VideoPlayer.this.L || euJ != null) {
                            if (VideoPlayer.this.pjE.e) {
                                VideoPlayer.this.pjE.e = false;
                                VideoPlayer.this.pjE.d = !VideoPlayer.this.pjE.d;
                            }
                            if (VideoPlayer.this.pjC != null) {
                                VideoPlayer.this.c("1", (String) null);
                                if (VideoPlayer.this.d) {
                                    VideoPlayer.this.pjC.i(true);
                                } else if (VideoPlayer.this.e) {
                                    VideoPlayer.this.e = false;
                                    VideoPlayer.this.pjC.B();
                                }
                            }
                        }
                    }
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void Rc(int i) {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerBCallback onErrorAppeared");
            if (!VideoPlayer.this.isFinishing()) {
                VideoPlayer.this.c();
                VideoPlayer.this.K = false;
                if (VideoPlayer.this.pke != null) {
                    VideoPlayer.this.pke.removeMessages(7);
                }
                if (VideoPlayer.this.pke != null) {
                    VideoPlayer.this.pke.removeMessages(1);
                }
                if ((VideoPlayer.this.pjC == null || !VideoPlayer.this.pjC.H) && !VideoPlayer.this.eug()) {
                    if (!"10004".equals(VideoPlayer.this.t)) {
                        if (VideoPlayer.this.pjC != null) {
                            if (!VideoPlayer.this.d) {
                                VideoPlayer.this.pjA.stop();
                                VideoPlayer.this.pjA.release();
                                VideoPlayer.this.pjC.C();
                                VideoPlayer.this.e = false;
                            }
                            if (!com.kascend.chushou.b.etQ().f4066a && !com.kascend.chushou.b.etQ().b) {
                                VideoPlayer.this.pjC.g(true);
                            } else if (VideoPlayer.this.d) {
                                VideoPlayer.this.pjC.a(i, false);
                            } else {
                                VideoPlayer.this.pjC.a(i, true);
                            }
                            VideoPlayer.this.c("2", (String) null);
                            return;
                        }
                        return;
                    }
                    euA();
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void euD() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerBCallback onBufferingStart");
            if (!VideoPlayer.this.isFinishing()) {
                if ((VideoPlayer.this.pjC == null || !VideoPlayer.this.pjC.H) && VideoPlayer.this.pjC != null && VideoPlayer.this.d) {
                    VideoPlayer.this.pjC.E();
                    VideoPlayer.this.M = true;
                    VideoPlayer.this.pke.removeMessages(7);
                    long currentTimeMillis = System.currentTimeMillis();
                    if (!VideoPlayer.this.g) {
                        VideoPlayer.y(VideoPlayer.this);
                    }
                    tv.chushou.zues.utils.e.d(VideoPlayer.this.v, "currentTime: -- >" + currentTimeMillis + "  bufferTime-->" + VideoPlayer.this.N + "  bufferCount-->" + VideoPlayer.this.O);
                    if (currentTimeMillis - VideoPlayer.this.N >= 20000 || VideoPlayer.this.O < 2 || VideoPlayer.this.pjC.H) {
                        if (VideoPlayer.this.O == 1) {
                            VideoPlayer.this.N = currentTimeMillis;
                        }
                        VideoPlayer.this.pke.D(7, 5000L);
                    } else {
                        VideoPlayer.this.N = 0L;
                        VideoPlayer.this.O = 0;
                        VideoPlayer.this.pke.Sv(7);
                    }
                    if (VideoPlayer.this.g) {
                        VideoPlayer.this.g = false;
                    }
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void euE() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerBCallback onBufferingEnd");
            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.pjC != null && VideoPlayer.this.d) {
                VideoPlayer.this.M = false;
                VideoPlayer.this.pke.removeMessages(7);
                if (VideoPlayer.this.pjC == null || !VideoPlayer.this.pjC.H) {
                    if (VideoPlayer.this.pjy == null) {
                        VideoPlayer.this.pjC.a(false, true, false);
                    } else {
                        VideoPlayer.this.pjC.a(true, VideoPlayer.this.pjy.getPlayState() == 4, VideoPlayer.this.pjy.getPlayState() == 5);
                    }
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void onPlayerStart() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerBCallback onPlayerStart");
            if (!VideoPlayer.this.isFinishing()) {
                if (VideoPlayer.this.pjC == null || !VideoPlayer.this.pjC.H) {
                    if (VideoPlayer.this.pjC != null && VideoPlayer.this.d) {
                        if (VideoPlayer.this.pjy != null) {
                            VideoPlayer.this.pjC.F();
                            VideoPlayer.this.pjC.a(true, VideoPlayer.this.pjy.getPlayState() == 4, VideoPlayer.this.pjy.getPlayState() == 5);
                        } else {
                            VideoPlayer.this.pjC.a(false, true, false);
                        }
                    }
                    if (VideoPlayer.this.pke != null && !VideoPlayer.this.eum()) {
                        VideoPlayer.this.pke.removeMessages(1);
                        VideoPlayer.this.pke.D(1, VideoPlayer.A);
                    }
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void euF() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerBCallback onPlayerPause");
            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.pke != null) {
                VideoPlayer.this.pke.removeMessages(1);
            }
        }

        @Override // tv.chushou.common.player.b
        public void euG() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerBCallback onPlayerStop");
            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.eum() && VideoPlayer.this.pjA != null && !h.isEmpty(VideoPlayer.this.P) && VideoPlayer.this.pjA.getCurrentPos() > 0) {
                j.eue().a(VideoPlayer.this.P, VideoPlayer.this.pjA.getCurrentPos());
            }
        }
    };

    static /* synthetic */ int y(VideoPlayer videoPlayer) {
        int i = videoPlayer.O;
        videoPlayer.O = i + 1;
        return i;
    }

    @Override // com.kascend.chushou.view.base.BaseActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        tv.chushou.zues.utils.e.d(this.v, "VideoPlayer onCreate");
        super.onCreate(bundle);
        Intent intent = getIntent();
        this.pjx = intent.getData();
        if (this.pjx == null) {
            finish();
            return;
        }
        com.kascend.chushou.d.e.j();
        if (this.pkd == null) {
            this.pkd = new CSTVWifiReceiver();
            registerReceiver(this.pkd, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        }
        com.kascend.chushou.toolkit.d.a.ewg().b();
        tv.chushou.zues.utils.e.i(this.v, "intent.getData=" + this.pjx.toString());
        String scheme = this.pjx.getScheme();
        if (scheme == null || !scheme.equals("chushou")) {
            tv.chushou.zues.utils.e.e(this.v, "not support scheme :" + scheme);
            finish();
            return;
        }
        a(intent);
    }

    private void a(Intent intent) {
        this.P = this.pjx.getQueryParameter("roomId");
        this.Q = this.P;
        this.S = this.pjx.getQueryParameter(WebSocketRequest.PARAM_KEY_PROTOCOLS);
        this.aq = this.pjx.getQueryParameter("liveType");
        if ("2".equals(this.aq) || "3".equals(this.aq) || "4".equals(this.aq)) {
            this.pjZ = "2";
            this.pka = new com.kascend.chushou.player.feedback.a();
            if (this.pka.pst != null) {
                this.pka.pst.reset();
                this.pka.pst.roomId = this.P;
                this.pka.pst.enterType = 1;
                this.pka.b = System.currentTimeMillis();
            }
        }
        if (h.isEmpty(this.P) || h.isEmpty(this.S)) {
            tv.chushou.zues.utils.e.e(this.v, "invalid param mItemID=" + this.P + " protocols=" + this.S);
            finish();
            return;
        }
        if (com.kascend.chushou.b.etQ().d == -1) {
            com.kascend.chushou.b.etQ().d = com.kascend.chushou.d.g.b() ? 1 : 0;
        }
        this.pjQ = ((PowerManager) getSystemService("power")).newWakeLock(536870938, this.v);
        this.pjQ.acquire();
        this.pjE = new b(this.P);
        this.pjE.d = intent.getBooleanExtra("room_play_audio", false);
        this.pjH = new com.kascend.chushou.widget.a.b();
        String stringExtra = intent.getStringExtra("json_str");
        this.R = "1";
        if (stringExtra != null && stringExtra.length() > 0) {
            try {
                JSONObject jSONObject = new JSONObject(stringExtra);
                this.R = jSONObject.optString("_viewType");
                this.ab = jSONObject.optString("_thumb");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (h.isEmpty(this.R)) {
                this.R = "1";
            }
        }
        if ("1".equals(this.R)) {
            com.kascend.chushou.player.c.a.b();
        }
        this.s = intent.getLongExtra("action_video_pos", -1L);
        a(stringExtra, true);
        getWindow().setFormat(-2);
        tv.chushou.zues.a.a.register(this);
        super.setContentView(a.h.activity_fragment_video);
        getWindow().setBackgroundDrawable(null);
        this.pjJ = (KPSwitchRootRelativeLayout) findViewById(a.f.rlRoot);
        if (!"2".equals(this.pjZ) && com.kascend.chushou.b.etQ().d == 1) {
            this.pjJ.setFitsSystemWindows(true);
        }
        this.pjK = (FrameLayout) this.pjJ.findViewById(a.f.fl_fragment);
        this.cem = this.pjJ.findViewById(a.f.rl_empty);
        this.T = (ImageView) this.cem.findViewById(a.f.iv_empty);
        this.U = (TextView) this.cem.findViewById(a.f.tv_empty);
        this.pjM = (LinearLayout) this.pjJ.findViewById(a.f.rl_title);
        this.pjL = (ImageView) this.pjM.findViewById(a.f.back_icon);
        this.pjL.setOnClickListener(new View.OnClickListener() { // from class: com.kascend.chushou.player.VideoPlayer.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayer.this.finish();
            }
        });
        this.pjG = (AnimationImageView) this.cem.findViewById(a.f.iv_loading);
        this.pjR = (FrescoThumbnailView) this.pjJ.findViewById(a.f.live_cover);
        this.pjS = (FrameLayout) this.pjJ.findViewById(a.f.fl_cover);
        this.k = euf();
        try {
            this.pjI = (AudioManager) getApplicationContext().getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
            n = this.pjI.getStreamVolume(3);
            this.pjI.requestAudioFocus(null, 3, 1);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (this.B) {
            a(1, eum() ? "3" : "1");
        } else {
            r();
        }
        if (com.kascend.chushou.b.etQ().b && !com.kascend.chushou.b.etQ().f4066a) {
            RxExecutor.postDelayed(this.pkb, EventThread.MAIN_THREAD, 60L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.VideoPlayer.5
                @Override // java.lang.Runnable
                public void run() {
                    if (!VideoPlayer.this.isFinishing() && com.kascend.chushou.b.etQ().b && !com.kascend.chushou.b.etQ().f4066a) {
                        tv.chushou.zues.utils.g.d(VideoPlayer.this.w, VideoPlayer.this.getString(a.i.str_monet_notify));
                    }
                }
            });
        }
        com.kascend.chushou.c.c.etT().a(this.P, stringExtra, System.currentTimeMillis());
    }

    @Override // com.kascend.chushou.view.base.BaseActivity
    public void a() {
    }

    @Override // com.kascend.chushou.view.base.BaseActivity
    public void b() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.pkc == null) {
            this.pkc = new a();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(VideoReceiver.ACTION_VOLUME_CHANGED);
            registerReceiver(this.pkc, intentFilter);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        j(false);
        if (this.pkc != null) {
            unregisterReceiver(this.pkc);
            this.pkc = null;
        }
        super.onStop();
    }

    @Override // com.kascend.chushou.view.base.BaseActivity
    protected void a(boolean z) {
        if (this.pjC != null) {
            this.pjC.k(z);
        }
    }

    @Subscribe
    public void onHideGiftEffectEvent(com.kascend.chushou.b.a.a.f fVar) {
        if (fVar.b) {
            this.pjC.k();
            return;
        }
        this.pjC.m();
        this.pjC.l();
    }

    private float euf() {
        int i = 0;
        try {
            i = Settings.System.getInt(getContentResolver(), "screen_brightness");
        } catch (Settings.SettingNotFoundException e) {
            e.printStackTrace();
        }
        return i;
    }

    private void a(String str, boolean z) {
        JSONObject jSONObject;
        this.ag = str;
        R();
        try {
            if (h.isEmpty(str)) {
                jSONObject = new JSONObject();
            } else {
                jSONObject = new JSONObject(str);
            }
            jSONObject.put("_fbroomid", this.P);
            this.pjE.h = jSONObject.toString();
            String optString = jSONObject.optString("_thumb");
            jSONObject.optBoolean("tag_from_game_mic", false);
            if (!h.isEmpty(optString)) {
                this.ab = optString;
            }
        } catch (JSONException e) {
            e.printStackTrace();
            this.pjE.h = str;
        }
        if (eum()) {
            a(this.P, str);
            bo(this.P, z);
            return;
        }
        f4089a = this.P;
        b(this.P, str);
        a(this.P, euw(), z);
        w();
    }

    private void O() {
        this.m = true;
        j();
        if (this.pjC != null) {
            this.pjC.r();
        }
        s();
    }

    @Subscribe
    public void onStartRoomEvent(o oVar) {
        if (!isFinishing() && oVar.pjf != null && oVar.c != null && !h.isEmpty(oVar.pjf.mTargetKey)) {
            if (oVar.c != this) {
                tv.chushou.zues.utils.e.e(this.v, "different player!");
                return;
            }
            if (this.pjE != null) {
                this.pjE.a();
                this.pjE.f4119a = oVar.pjf.mTargetKey;
                this.pjE.d = oVar.d;
                if (this.pjE.ple != null) {
                    this.pjE.ple.e();
                }
                if (this.pjE.ple != null) {
                    this.pjE.ple.b();
                }
                this.pjE.plh = null;
                this.pjE.plg = null;
                this.pjE.plk = null;
                this.pjE.plj = null;
                this.pjE.pln = null;
                this.pjE.pll = null;
                this.pjE.plm = null;
            }
            if (this.pjI != null) {
                n = this.pjI.getStreamVolume(3);
            }
            if (!h.isEmpty(oVar.pjf.mType) && oVar.pjf.mType.equals("3")) {
                this.B = false;
                this.pjZ = "1";
                r();
                this.P = oVar.pjf.mTargetKey;
                this.R = "3";
                if (this.pjH != null) {
                    this.pjH.a();
                }
                if (this.pjE != null) {
                    this.pjE.a((PlayUrl) null);
                    this.pjE.f();
                    if (this.pjE.c() != null) {
                        this.pjE.c().clear();
                    }
                    this.pjE.i.clear();
                }
                if (this.pjC != null) {
                    this.pjC.j();
                }
                s();
                if (this.pjN != null) {
                    this.pjN.d();
                    this.pjN = null;
                }
                if (this.pkb != null) {
                    this.pkb.dispose();
                    this.pkb = new io.reactivex.disposables.a();
                }
                a(oVar.e, false);
                return;
            }
            boolean z = this.R != null && this.R.equals("1");
            this.R = "1";
            this.pjW.a();
            this.pjV.a();
            this.pjU.a();
            this.pjT.c();
            this.pjY.a();
            if (this.pkb != null) {
                this.pkb.dispose();
                this.pkb = new io.reactivex.disposables.a();
            }
            if ("1".equals(oVar.f)) {
                this.H = false;
                if (this.pjE != null && !h.isEmpty(this.pjE.t)) {
                    this.pjE.t.clear();
                }
                this.ab = oVar.pjf.mCover;
                this.pjS.setVisibility(0);
                this.pjR.setBlur(true);
                this.pjR.i(oVar.pjf.mCover, 0, 0, 0);
            }
            if (!oVar.pjf.mTargetKey.equals(this.P)) {
                this.aq = oVar.g;
                if (!z) {
                    this.B = false;
                    r();
                } else if (!"2".equals(this.pjZ) && ("2".equals(this.aq) || "3".equals(this.aq) || "4".equals(this.aq))) {
                    this.pjZ = "2";
                    this.pka = new com.kascend.chushou.player.feedback.a();
                    if (this.pka.pst != null) {
                        this.pka.pst.reset();
                        this.pka.pst.roomId = oVar.pjf.mTargetKey;
                        this.pka.pst.enterType = 1;
                        this.pka.b = System.currentTimeMillis();
                    }
                }
                this.B = false;
                this.P = oVar.pjf.mTargetKey;
                this.Q = this.P;
                this.ab = oVar.pjf.mCover;
                String str = "8";
                if (oVar.b != null) {
                    if (oVar.b.equals("recommend")) {
                        str = "20";
                    } else if (oVar.b.equals("fromvideo")) {
                        str = Constants.VIA_ACT_TYPE_NINETEEN;
                    }
                }
                if ("1".equals(oVar.f)) {
                    str = "73";
                }
                JSONObject O = com.kascend.chushou.d.e.O("_fromView", str, "_sc", oVar.pjf.mSC);
                com.kascend.chushou.toolkit.a.c.a(this.w, O);
                if (this.pjH != null) {
                    this.pjH.a();
                    this.pjH.a(this.P);
                }
                if (this.pjE != null) {
                    this.pjE.a((PlayUrl) null);
                    this.pjE.f();
                    if (this.pjE.c() != null) {
                        this.pjE.c().clear();
                    }
                    this.pjE.i.clear();
                }
                if (this.pjC != null) {
                    this.pjC.j();
                }
                a(O.toString(), false);
                return;
            }
            tv.chushou.zues.utils.g.SE(a.i.str_same_room);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean eug() {
        FullRoomInfo euJ;
        String str;
        RoomInfo roomInfo;
        if (eum()) {
            str = null;
            euJ = null;
        } else {
            euJ = this.pjE.euJ();
            str = (euJ == null || (roomInfo = euJ.mRoominfo) == null) ? null : roomInfo.mGameId;
        }
        return !this.L && (euJ == null || h.isEmpty(str));
    }

    @Subscribe
    public void onMessageEvent(i iVar) {
        if (!isFinishing() && iVar.f4073a != 21 && iVar.f4073a != 22) {
            if (iVar.f4073a == 0 && (iVar.b instanceof Boolean)) {
                if (((Boolean) iVar.b).booleanValue() && !isFinishing()) {
                    w();
                    if (this.pjC != null) {
                        this.pjC.f();
                    }
                }
            } else if (iVar.f4073a == 46) {
                if ((iVar.b instanceof String) && this.pjC != null) {
                    this.pjC.c((String) iVar.b);
                }
            } else if (iVar.f4073a == 54) {
                if (iVar.b instanceof String) {
                    this.pjU.a((String) iVar.b);
                }
            } else if (iVar.f4073a == 55) {
                if (this.pjC != null) {
                    this.pjC.O();
                }
            } else if (iVar.f4073a == 56 && this.pjC != null) {
                this.pjC.P();
            }
        }
    }

    @Subscribe
    public void onRefreshSubscribeEvent(m mVar) {
        if (isFinishing() && this.pjE != null && this.pjE.euL() != null) {
            RoomInfo euL = this.pjE.euL();
            if (mVar.a(euL.mCreatorUID, euL.mRoomID)) {
                euL.mIsSubscribed = mVar.c;
            }
        }
    }

    @Subscribe
    public void onPlayerEvent(k kVar) {
        if (kVar.f4075a == 1 && !isFinishing()) {
            O();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        tv.chushou.zues.utils.e.d(this.v, "VideoPlayer.onNewIntent: ");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        tv.chushou.zues.utils.e.d(this.v, MissionEvent.MESSAGE_RESUME);
        j(true);
        if (this.m || this.pjz == null || this.pjA == null) {
            R();
        }
        if (this.pjH != null) {
            this.pjH.d();
        }
        if (!eum()) {
            if (this.pjN != null && !this.pjN.c()) {
                this.pjN.a();
            }
            v();
            if (this.pjE != null && this.pjE.euJ() != null && this.pjE.euJ().cycleLiveRoomInfo != null && !h.isEmpty(this.pjE.euJ().cycleLiveRoomInfo.roomId)) {
                u();
            }
        }
        super.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.view.base.BaseActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        tv.chushou.zues.utils.e.e(this.v, MissionEvent.MESSAGE_DESTROY);
        if (this.pjE != null && this.pjE.euJ() != null && this.pjE.euJ().cycleLiveRoomInfo != null && !h.isEmpty(this.pjE.euJ().cycleLiveRoomInfo.eventName)) {
            j.eue().a(this.P + euw());
        }
        if ("2".equals(this.pjZ) && this.pka != null && this.pka.pst != null) {
            this.pka.pst.time = System.currentTimeMillis() - this.pka.b;
            this.pka.a();
            this.pka.b();
        }
        this.pjT.d();
        this.pjU.b();
        this.pjV.b();
        O();
        this.ag = null;
        f4089a = null;
        if (this.pke != null) {
            this.pke.ct(null);
            this.pke = null;
        }
        if (this.pjN != null) {
            this.pjN.d();
            this.pjN = null;
        }
        if (this.pjH != null) {
            this.pjH.c();
            this.pjH = null;
        }
        if (this.pjE != null) {
            this.pjE.plh = null;
            this.pjE.plg = null;
        }
        if (this.pjE != null) {
            this.pjE.b();
            this.pjE = null;
        }
        this.pjx = null;
        this.pjC = null;
        this.pjD = null;
        this.pjF = null;
        this.T = null;
        this.U = null;
        this.pjG = null;
        this.cem = null;
        this.pjI = null;
        this.pjJ = null;
        this.pjK = null;
        this.pjL = null;
        this.pjM = null;
        if (this.pjQ != null && this.pjQ.isHeld()) {
            this.pjQ.release();
            this.pjQ = null;
        }
        if (this.pkd != null) {
            unregisterReceiver(this.pkd);
            this.pkd = null;
        }
        h.eHT();
        tv.chushou.zues.a.a.cu(this);
        this.pkb.dispose();
        this.pjV.b();
        this.pjW.b();
        this.pjT.d();
        this.pjU.b();
        this.pjY.b();
        super.onDestroy();
        System.gc();
    }

    @Subscribe
    public void onSendGameGiftEvent(n nVar) {
        if (!isFinishing() && this.pjC != null) {
            this.pjC.a(nVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.view.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        tv.chushou.zues.utils.e.d(this.v, MissionEvent.MESSAGE_PAUSE);
        if (this.pjN != null) {
            this.pjN.b();
        }
        if (this.pjH != null) {
            this.pjH.b(false);
        }
        k();
        this.m = true;
        super.onPause();
    }

    @Override // android.app.Activity
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.pjC != null ? this.pjC.a(motionEvent) : super.onTouchEvent(motionEvent);
    }

    public void c() {
        if ("1".equals(this.R)) {
            j.eue().a(this.P + euw());
        } else {
            j.eue().b(this.P);
        }
    }

    private void a(boolean z, boolean z2) {
        int i = 0;
        tv.chushou.zues.utils.e.i(this.v, "startLoadingVideo <------------- mbPrepareingVideo = " + this.K);
        if (this.pjz != null) {
            this.pjz.setHardwearDecod(com.kascend.chushou.d.h.etY().f4087a);
        }
        if (this.pjA != null) {
            this.pjA.setHardwearDecod(com.kascend.chushou.d.h.etY().f4087a);
        }
        if (this.pjy != null) {
            this.pjy.setHardwearDecod(com.kascend.chushou.d.h.etY().f4087a);
        }
        if (!this.K) {
            if (z && this.pjC != null) {
                if (!z2) {
                    this.t = null;
                    this.pjC.e();
                }
            } else if (this.pjC != null && !z2) {
                this.t = null;
                this.pjC.H = false;
                RxExecutor.post(null, EventThread.MAIN_THREAD, new Runnable() { // from class: com.kascend.chushou.player.VideoPlayer.7
                    @Override // java.lang.Runnable
                    public void run() {
                        VideoPlayer.this.pjC.x();
                    }
                });
            }
            this.K = true;
            if (this.pjE != null && this.pjE.euK() != null) {
                PlayUrl euK = this.pjE.euK();
                while (true) {
                    int i2 = i;
                    if (i2 >= euK.mUrlDetails.size()) {
                        break;
                    }
                    UrlDetails urlDetails = euK.mUrlDetails.get(i2);
                    if (urlDetails.mUrl.equals(euK.mSelectedUrl)) {
                        String str = euK.mUrlDetails.get(i2).mDefinitionType;
                        String str2 = urlDetails.mBitrate;
                    }
                    i = i2 + 1;
                }
            }
            if (z2) {
                if (this.d) {
                    this.pjz.setVideoURI(this.pjx);
                    this.pjz.open();
                    return;
                }
                this.pjA.setVideoURI(this.pjx);
                this.pjA.open();
                return;
            }
            this.pjy.setVideoURI(this.pjx);
            this.pjy.open();
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        try {
            if (motionEvent.getAction() == 0) {
                if (this.pjC != null && this.pjC.b(motionEvent)) {
                    return true;
                }
                if ("2".equals(this.pjZ) && this.pjC != null) {
                    this.pjC.a(motionEvent);
                }
            } else if (this.pjC != null && this.pjC.b(motionEvent)) {
                return true;
            }
            return super.dispatchTouchEvent(motionEvent);
        } catch (Exception e) {
            return false;
        }
    }

    @Override // android.support.v7.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.pjC != null && this.pjC.a(i, keyEvent)) {
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // android.support.v7.app.AppCompatActivity, android.app.Activity, android.view.Window.Callback
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent.getRepeatCount() <= 0 || keyEvent.getKeyCode() != 82) {
            return super.dispatchKeyEvent(keyEvent);
        }
        return true;
    }

    public void d() {
        if (this.pjE != null && this.pjE.euJ() != null && this.pjE.euJ().cycleLiveRoomInfo != null && !h.isEmpty(this.pjE.euJ().cycleLiveRoomInfo.roomId)) {
            this.pjS.setVisibility(0);
            this.pjR.setBlur(true);
            this.pjR.i(this.pjE.euJ().cycleLiveRoomInfo.avatar, 0, 0, 0);
            this.pjR.setVisibility(0);
            j.eue().a(this.P + euw());
            this.pjx = null;
            R();
            this.Q = this.pjE.euJ().cycleLiveRoomInfo.roomId;
            a(this.P, euw(), false);
        }
    }

    public void b(boolean z) {
        if (this.pjC != null) {
            this.pjC.j(z);
        }
    }

    public void a(boolean z, Uri uri, boolean z2) {
        tv.chushou.zues.utils.e.d(this.v, "loadIfNecessary reload=" + z + " isChangeLines-->" + z2);
        if (this.pjz != null && this.pjA != null) {
            if (uri != null) {
                this.pjx = uri;
            }
            if (z2) {
                this.e = z2;
            }
            this.M = false;
            this.N = 0L;
            this.O = 0;
            this.pke.removeMessages(7);
            if (z) {
                if (z2) {
                    if (!this.d) {
                        this.pjA.setOnActivityCallBack(this.pkj);
                    } else {
                        this.pjz.setOnActivityCallBack(this.pki);
                    }
                } else if (this.d) {
                    this.pjA.setOnActivityCallBack(this.pkj);
                } else {
                    this.pjz.setOnActivityCallBack(this.pki);
                }
                this.K = false;
                b(true, z2);
            } else if (!this.J) {
                b(true, z2);
            }
            this.pke.D(6, IMConnection.RETRY_DELAY_TIMES);
        }
    }

    private void b(boolean z, boolean z2) {
        VideoPlayInfo R;
        if ("1".equals(this.R)) {
            R = j.eue().Q(this.P + euw(), 600000L);
        } else {
            R = j.eue().R(this.P, 600000L);
        }
        if (R != null) {
            a(z, z2);
        } else if ("1".equals(this.R)) {
            a(this.P, euw(), false);
        } else {
            bo(this.P, false);
        }
    }

    public tv.chushou.common.player.a euh() {
        return this.pjy;
    }

    public tv.chushou.common.player.a eui() {
        return this.pjz;
    }

    public tv.chushou.common.player.a euj() {
        return this.pjA;
    }

    public void a(tv.chushou.common.player.a aVar) {
        this.pjy = aVar;
    }

    public b euk() {
        return this.pjE;
    }

    public com.kascend.chushou.widget.a.b eul() {
        return this.pjH;
    }

    public void a(int i, String str) {
        b(i, str, false, this.B);
    }

    public void a(int i, String str, boolean z) {
        a(i, str, false, this.B, z);
    }

    public void b(int i, String str, boolean z, boolean z2) {
        a(i, str, z, z2, false);
    }

    public void a(int i, String str, boolean z, boolean z2, boolean z3) {
        a(i, str, z, z2, z3, false);
    }

    public void a(int i, String str, boolean z, boolean z2, boolean z3, boolean z4) {
        boolean z5;
        FullRoomInfo euJ;
        this.r = -1L;
        if (this.s != -1 && this.s != 0) {
            this.r = this.s;
            this.s = -1L;
        }
        if (eum() && this.pjy != null && this.pjy.getPlayState() == 4) {
            this.r = this.pjy.getCurrentPos();
        }
        this.pkf = false;
        tv.chushou.zues.utils.e.d(this.v, "screenChange()<-----");
        tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard(this);
        if (str != null) {
            this.R = str;
        }
        if (!this.C || !z3 || "3".equals(this.R) || this.pjE == null || (euJ = this.pjE.euJ()) == null || euJ.mRoominfo == null || euJ.mRoominfo.mStyle != 1) {
            z5 = false;
        } else {
            z5 = true;
            i = 0;
        }
        if ("2".equals(this.pjZ)) {
            setRequestedOrientation(1);
            ((VideoPlayer) this.w).g(true);
            WindowManager.LayoutParams attributes = getWindow().getAttributes();
            attributes.flags &= -1025;
            getWindow().setAttributes(attributes);
            View decorView = getWindow().getDecorView();
            getWindow().clearFlags(512);
            decorView.setSystemUiVisibility(1792);
            getWindow().clearFlags(67108864);
            if (Build.VERSION.SDK_INT >= 21) {
                getWindow().addFlags(Integer.MIN_VALUE);
                getWindow().setStatusBarColor(0);
            }
        } else if (1 == i) {
            setRequestedOrientation(1);
            ((VideoPlayer) this.w).g(true);
            if (com.kascend.chushou.b.etQ().d == 1) {
                WindowManager.LayoutParams attributes2 = getWindow().getAttributes();
                attributes2.flags &= -1025;
                getWindow().setAttributes(attributes2);
                getWindow().addFlags(256);
                getWindow().clearFlags(512);
            } else {
                WindowManager.LayoutParams attributes3 = getWindow().getAttributes();
                attributes3.flags &= -1025;
                getWindow().setAttributes(attributes3);
                View decorView2 = getWindow().getDecorView();
                getWindow().clearFlags(512);
                getWindow().addFlags(256);
                decorView2.setSystemUiVisibility(1796);
                if (Build.VERSION.SDK_INT >= 21) {
                    getWindow().setStatusBarColor(0);
                }
            }
        } else {
            ((VideoPlayer) this.w).AK(false);
            ((VideoPlayer) this.w).g(true);
            if (z5) {
                setRequestedOrientation(1);
            } else {
                setRequestedOrientation(6);
            }
            getWindow().addFlags(512);
            getWindow().addFlags(256);
        }
        if (this.pjH == null) {
            this.pjH = new com.kascend.chushou.widget.a.b();
        }
        if (this.pjH != null) {
            this.pjH.a(this.P);
        }
        if (this.R.equals("5")) {
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            if (this.pjC != null) {
                beginTransaction.remove(this.pjC);
                this.pjC = null;
            }
            if (this.pjD != null) {
                beginTransaction.remove(this.pjD);
                this.pjD = null;
            }
            this.pjD = new com.kascend.chushou.view.user.b();
            beginTransaction.add(a.f.fl_fragment, this.pjD);
            beginTransaction.commitAllowingStateLoss();
        } else {
            FragmentTransaction beginTransaction2 = getSupportFragmentManager().beginTransaction();
            if (this.pjC != null) {
                beginTransaction2.remove(this.pjC);
                this.pjC = null;
            }
            if (this.pjD != null) {
                beginTransaction2.remove(this.pjD);
                this.pjD = null;
            }
            if ("2".equals(this.pjZ)) {
                this.pjC = com.kascend.chushou.player.e.e.b(this.ab, z2, this.aq, this.P);
            } else if (1 == i) {
                if (!this.R.equals("3")) {
                    if (z4) {
                        v();
                    }
                    this.pjC = new com.kascend.chushou.player.d.a();
                    Bundle bundle = new Bundle();
                    bundle.putString("mCover", this.ab);
                    bundle.putBoolean("mInitViewAsync", z2);
                    this.pjC.setArguments(bundle);
                }
            } else {
                this.pjC = new com.kascend.chushou.player.d.b();
                Bundle bundle2 = new Bundle();
                if (z5) {
                    i = 1;
                }
                bundle2.putInt("mExtraOrientation", i);
                bundle2.putString("mViewType", this.R);
                this.pjC.setArguments(bundle2);
            }
            beginTransaction2.add(a.f.fl_fragment, this.pjC);
            beginTransaction2.commitAllowingStateLoss();
            this.H = true;
        }
        tv.chushou.zues.utils.e.d(this.v, "screenChange()----->");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean eum() {
        return this.R != null && this.R.equals("3");
    }

    private void R() {
        if (this.pjC != null) {
            this.pjC.poC = null;
        }
        if (this.pjy != null) {
            this.pjy.release();
            this.pjy = null;
            this.K = false;
        }
        if (this.pjz != null) {
            this.pjz.release();
            this.pjz = null;
        }
        if (this.pjA != null) {
            this.pjA.release();
            this.pjA = null;
        }
        if (this.pjB != null) {
            this.pjB.c();
        }
        this.d = false;
        this.e = false;
        this.M = false;
        this.pjB = new c();
        this.pjz = this.pjB.euO();
        this.pjz.setOnActivityCallBack(this.pki);
        this.pjA = this.pjB.euP();
        this.pjA.setOnActivityCallBack(this.pkj);
        if (!this.d) {
            this.pjy = this.pjz;
        } else {
            this.pjy = this.pjA;
        }
        if (this.pjC != null) {
            this.pjC.poC = this.pjy;
        }
    }

    public void j() {
        if (this.pjy != null) {
            this.pjy.pause();
            this.pjy.stop();
            this.pjy.release();
            this.pjy = null;
        }
        if (this.pjz != null) {
            this.pjz.stop();
            this.pjz.release();
            this.pjz = null;
        }
        if (this.pjA != null) {
            this.pjA.stop();
            this.pjA.release();
            this.pjA = null;
        }
        if (this.pjB != null) {
            this.pjB.c();
        }
    }

    public void k() {
        tv.chushou.common.player.a aVar = this.pjy;
        if (aVar != null) {
            aVar.pause();
            aVar.stop();
        }
        tv.chushou.common.player.a aVar2 = this.pjz;
        if (aVar2 != null) {
            aVar2.stop();
        }
        tv.chushou.common.player.a aVar3 = this.pjA;
        if (aVar3 != null) {
            aVar3.stop();
        }
    }

    private void a(String str, String str2) {
        if (!h.isEmpty(str2)) {
            try {
                JSONObject jSONObject = new JSONObject(str2);
                String optString = jSONObject.optString("listTargetKey");
                if (!h.isEmpty(optString)) {
                    jSONObject.put("fromKey", optString);
                }
                String optString2 = jSONObject.optString("tag_from_type");
                if (!h.isEmpty(optString2)) {
                    jSONObject.put("fromType", optString2);
                }
                jSONObject.toString();
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void S() {
        if (this.pkf) {
            if (this.pjC != null) {
                this.pjC.s();
            }
        } else if (this.pke != null) {
            this.pke.b(this.pke.Sx(3), 20L);
        }
    }

    private void b(final String str, String str2) {
        com.kascend.chushou.c.c.etT().a(new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.VideoPlayer.8
            @Override // com.kascend.chushou.c.b
            public void a() {
                VideoPlayer.this.L = true;
            }

            @Override // com.kascend.chushou.c.b
            public void a(String str3, JSONObject jSONObject) {
                boolean z = false;
                if (!VideoPlayer.this.isFinishing()) {
                    ParserRet u = com.kascend.chushou.c.f.u(str, jSONObject);
                    if (u.mRc != 0 || u.mData == null) {
                        VideoPlayer.this.b(u.mMessage, u.mRc);
                        return;
                    }
                    FullRoomInfo fullRoomInfo = (FullRoomInfo) u.mData;
                    VideoPlayer.this.euu().a(fullRoomInfo.mBangMap);
                    if (h.isEmpty(fullRoomInfo.mRoominfo.mRoomID)) {
                        fullRoomInfo.mRoominfo.mRoomID = VideoPlayer.this.P;
                    }
                    if (!h.isEmpty(fullRoomInfo.mGeneralTabGifts)) {
                        com.kascend.chushou.d.e.a(VideoPlayer.this.pkb, new ArrayList(fullRoomInfo.mGeneralTabGifts));
                    }
                    if (VideoPlayer.this.pjE != null) {
                        VideoPlayer.this.pjE.a(fullRoomInfo);
                    }
                    VideoPlayer.this.L = false;
                    if (VideoPlayer.this.B) {
                        if (VideoPlayer.this.C && !"3".equals(VideoPlayer.this.R) && fullRoomInfo != null && fullRoomInfo.mRoominfo != null && fullRoomInfo.mRoominfo.mStyle == 1 && !h.isEmpty(fullRoomInfo.mRoominfo.mGameId)) {
                            z = true;
                        }
                        if (!z) {
                            if (VideoPlayer.this.pjC != null) {
                                VideoPlayer.this.pjC.a(VideoPlayer.this.pjE);
                            }
                            if (!h.isEmpty(fullRoomInfo.mRoominfo.mGameId)) {
                                VideoPlayer.this.S();
                            } else {
                                if (VideoPlayer.this.pjE != null) {
                                    VideoPlayer.this.pjE.f = null;
                                }
                                VideoPlayer.this.S();
                            }
                        } else {
                            VideoPlayer.this.a(1, "1", true);
                            if (VideoPlayer.this.pjC != null) {
                                VideoPlayer.this.pjC.a(VideoPlayer.this.pjE);
                            }
                        }
                    } else {
                        if (h.isEmpty(fullRoomInfo.mRoominfo.mGameId)) {
                            if (VideoPlayer.this.pjE != null) {
                                VideoPlayer.this.pjE.f = null;
                            }
                            VideoPlayer.this.a(1, "1");
                        } else {
                            VideoPlayer.this.a(1, "1", true);
                        }
                        if (VideoPlayer.this.pjC != null) {
                            VideoPlayer.this.pjC.a(VideoPlayer.this.pjE);
                        }
                    }
                    if (VideoPlayer.this.pjE != null && !VideoPlayer.this.pjE.m()) {
                        if (VideoPlayer.this.pjN != null) {
                            VideoPlayer.this.pjN.d();
                            VideoPlayer.this.pjN = null;
                        }
                        VideoPlayer.this.pjN = new com.kascend.chushou.toolkit.d(900000L, VideoPlayer.this.pjP, VideoPlayer.this.pke);
                        VideoPlayer.this.pjN.a();
                    }
                }
            }

            @Override // com.kascend.chushou.c.b
            public void a(int i, String str3) {
                if (!VideoPlayer.this.isFinishing()) {
                    VideoPlayer.this.b(str3, i);
                }
            }
        }, str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str, int i) {
        if (this.pjE != null) {
            this.pjE.a((FullRoomInfo) null);
        }
        this.L = false;
        bX(str, i);
        if (this.pjy != null) {
            this.pjy.stop();
        }
        if (this.pjz != null) {
            this.pjz.stop();
        }
        if (this.pjA != null) {
            this.pjA.stop();
        }
    }

    public void l() {
        tv.chushou.zues.utils.e.d(this.v, "retryGetPlayList");
        c();
        if (eum()) {
            bo(this.P, false);
        } else {
            a(this.P, euw(), false);
        }
    }

    public void m() {
        a(this.ag, false);
    }

    private void a(final String str, String str2, boolean z) {
        this.J = true;
        VideoPlayInfo Q = j.eue().Q(str + str2, 600000L);
        if (Q != null) {
            a((ArrayList) Q.mPlayUrls);
            this.J = false;
        } else if (z) {
            ParserRet ha = com.kascend.chushou.player.c.a.euQ().ha(str, str2);
            if (ha.mRc != 0) {
                tv.chushou.zues.utils.e.e(this.v, "getPlayUrlSync fail, try to getPlaylist");
                a(str, str2, false);
                return;
            }
            a(ha, str);
        } else {
            com.kascend.chushou.player.c.a.euQ().a(str, str2, new a.InterfaceC0996a() { // from class: com.kascend.chushou.player.VideoPlayer.9
                @Override // com.kascend.chushou.player.c.a.InterfaceC0996a
                public void a(ParserRet parserRet) {
                    VideoPlayer.this.a(parserRet, str);
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x005c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void bo(final String str, boolean z) {
        boolean equals;
        this.J = true;
        VideoPlayInfo R = j.eue().R(str, 600000L);
        if (R != null) {
            a((ArrayList) R.mPlayUrls);
            this.J = false;
            return;
        }
        if (!h.isEmpty(this.ag)) {
            try {
                equals = "1".equals(new JSONObject(this.ag).optString("auto"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (!z) {
                ParserRet bp = com.kascend.chushou.player.c.a.euQ().bp(str, equals);
                if (bp.mRc != 0) {
                    tv.chushou.zues.utils.e.e(this.v, "getVideoPlayUrlSync fail, try to getVideoPlaylist");
                    bo(str, false);
                    return;
                }
                a(bp, str);
                return;
            }
            com.kascend.chushou.player.c.a.euQ().a(str, new a.InterfaceC0996a() { // from class: com.kascend.chushou.player.VideoPlayer.10
                @Override // com.kascend.chushou.player.c.a.InterfaceC0996a
                public void a(ParserRet parserRet) {
                    VideoPlayer.this.a(parserRet, str);
                }
            }, equals);
            return;
        }
        equals = false;
        if (!z) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ParserRet parserRet, String str) {
        if (!isFinishing()) {
            this.J = false;
            if (parserRet.mRc == 0 && parserRet.mData != null) {
                ArrayList<PlayUrl> arrayList = (ArrayList) parserRet.mData;
                if (this.pjE.f == null) {
                    this.pjE.f = new ArrayList<>();
                }
                this.pjE.f.clear();
                this.pjE.f.addAll(arrayList);
                if ("1".equals(this.R)) {
                    j.eue().a(str + euw(), arrayList);
                } else {
                    j.eue().s(str, arrayList);
                }
                a(arrayList);
                return;
            }
            if (this.pjE != null) {
                this.pjE.f = null;
            }
            if (this.pke != null) {
                Message Sx = this.pke.Sx(5);
                Sx.arg1 = 2;
                Sx.arg2 = parserRet.mRc;
                this.pke.X(Sx);
            }
        }
    }

    private void bX(String str, int i) {
        s();
        if (this.pjH != null) {
            this.pjH.a();
        }
        if (h.isEmpty(str)) {
            str = getString(a.i.str_load_data_failed);
        }
        a(str, i);
    }

    public void n() {
        if (this.pjK != null && this.cem != null && this.pjM != null) {
            this.pjK.setVisibility(0);
            this.cem.setVisibility(8);
            this.pjM.setVisibility(8);
        }
    }

    public void o() {
        if (this.pjR != null && this.pjR.getVisibility() == 0) {
            this.pjR.Ev(0);
            this.pjR.setVisibility(8);
        }
    }

    public void p() {
        if (this.pjS != null && this.pjS.getVisibility() == 0) {
            this.pjS.setVisibility(8);
        }
    }

    public void q() {
        this.pkf = true;
    }

    protected void r() {
        this.pjK.setVisibility(8);
        this.pjM.setVisibility(0);
        this.cem.setVisibility(0);
        if (this.pjG != null) {
            this.T.setVisibility(8);
            this.pjG.setVisibility(0);
            this.U.setText(getString(a.i.str_dialog_loading_content));
            this.U.setVisibility(8);
        }
    }

    protected void a(String str, int i) {
        this.pjK.setVisibility(8);
        this.pjM.setVisibility(0);
        this.cem.setVisibility(0);
        if (this.pjG != null) {
            if (str == null) {
                str = getString(a.i.str_nodata);
            }
            if (str != null) {
                this.U.setText(str);
                if (str.equals(getString(a.i.s_no_available_network))) {
                    this.T.setImageResource(a.e.commonres_pagestatus_net_error);
                } else if (str.equals(getString(a.i.str_nodata)) || str.equals(getString(a.i.str_nohistory)) || str.equals(getString(a.i.str_nolive)) || str.equals(getString(a.i.str_nosubscribe))) {
                    this.T.setClickable(true);
                    this.T.setImageResource(a.e.commonres_pagestatus_empty);
                } else if (str.equals(getString(a.i.str_inbox_login_notify)) || str.equals(getString(a.i.push_login)) || str.equals(getString(a.i.str_login_timeout))) {
                    this.T.setImageResource(a.e.commonres_pagestatus_need_login);
                    this.T.setClickable(true);
                } else {
                    this.T.setImageResource(a.e.commonres_pagestatus_unknown_error);
                    this.T.setClickable(true);
                }
            }
            if (i == 4001) {
                this.T.setImageResource(a.e.commonres_pagestatus_net_error);
                this.T.setClickable(false);
                this.U.setVisibility(0);
                this.U.setText(getString(a.i.str_dissubscribe_btn));
                this.U.setOnClickListener(new View.OnClickListener() { // from class: com.kascend.chushou.player.VideoPlayer.11
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (!VideoPlayer.this.j) {
                            com.kascend.chushou.c.c.etT().b(new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.VideoPlayer.11.1
                                @Override // com.kascend.chushou.c.b
                                public void a() {
                                    VideoPlayer.this.j = true;
                                }

                                @Override // com.kascend.chushou.c.b
                                public void a(String str2, JSONObject jSONObject) {
                                    VideoPlayer.this.j = false;
                                    if (!VideoPlayer.this.isFinishing()) {
                                        VideoPlayer.this.finish();
                                    }
                                }

                                @Override // com.kascend.chushou.c.b
                                public void a(int i2, String str2) {
                                    VideoPlayer.this.j = false;
                                    if (!VideoPlayer.this.isFinishing()) {
                                        tv.chushou.zues.utils.g.O(VideoPlayer.this, a.i.subscribe_failed);
                                    }
                                }
                            }, VideoPlayer.this.P, (String) null, VideoPlayer.this.pjE.h);
                        }
                    }
                });
            } else if (i == 404) {
                this.U.setText(str);
                this.U.setVisibility(0);
                this.T.setClickable(false);
                this.T.setImageResource(a.e.commonres_pagestatus_empty);
            } else if (i == 4002) {
                if (h.isEmpty(str)) {
                    this.U.setVisibility(8);
                } else {
                    this.U.setVisibility(0);
                    this.U.setText(str);
                }
            } else {
                this.U.setVisibility(8);
            }
            this.T.setVisibility(0);
            this.pjG.setVisibility(8);
            this.pjS.setVisibility(8);
        }
    }

    public void s() {
        if (this.pke != null) {
            this.pke.removeMessages(1);
        }
    }

    private void a(ArrayList<PlayUrl> arrayList) {
        boolean z;
        if (this.pjE.f == null) {
            this.pjE.f = new ArrayList<>();
        }
        this.pjE.f.clear();
        this.pjE.f.addAll(arrayList);
        if (com.kascend.chushou.d.e.b() && !"4".equals(this.aq)) {
            int c = com.kascend.chushou.d.e.c();
            if (c == -1) {
                b(arrayList);
                return;
            } else if (this.aw) {
                this.aw = false;
                if (c == 0) {
                    this.pjE.d = false;
                    g(arrayList, true);
                    return;
                }
                if (this.pjE != null && this.pjE.f != null) {
                    Iterator<PlayUrl> it = this.pjE.f.iterator();
                    while (it.hasNext()) {
                        if ("2".equals(it.next().mType)) {
                            z = true;
                            break;
                        }
                    }
                }
                z = false;
                this.pjE.d = z;
                g(arrayList, true);
                return;
            } else {
                if (this.pjE.e) {
                    this.pjE.d = !this.pjE.d;
                    this.pjE.e = false;
                    this.pkh = true;
                } else if ("4".equals(this.aq)) {
                    this.pjE.d = true;
                }
                g(arrayList, true);
                return;
            }
        }
        if (this.pjE.e) {
            this.pjE.d = !this.pjE.d;
            this.pjE.e = false;
            this.pkh = true;
        } else if ("4".equals(this.aq)) {
            this.pjE.d = true;
        }
        g(arrayList, true);
    }

    private void b(ArrayList<PlayUrl> arrayList) {
        if ("1".equals(this.R)) {
            if ("2".equals(this.pjZ)) {
                d(false, arrayList);
            } else if (this.pjC != null) {
                this.pjC.g(arrayList, false);
            }
        } else if (this.pjC != null) {
            this.pjC.g(arrayList, false);
        }
    }

    public void c(boolean z) {
        this.pjE.d = false;
        com.kascend.chushou.d.e.a(0);
        ArrayList<PlayUrl> arrayList = this.pjE.f;
        if (!h.isEmpty(arrayList)) {
            if (z) {
                g(arrayList, false);
                if (this.pke != null) {
                    this.pke.Sv(2);
                    return;
                }
                return;
            }
            g(arrayList, true);
        }
    }

    public void d(boolean z) {
        this.pjE.d = true;
        com.kascend.chushou.d.e.a(1);
        ArrayList<PlayUrl> arrayList = this.pjE.f;
        if (!h.isEmpty(arrayList)) {
            if (z) {
                g(arrayList, false);
                if (this.pke != null) {
                    this.pke.Sv(2);
                    return;
                }
                return;
            }
            g(arrayList, true);
        }
    }

    @Subscribe
    public void onNotifyEvent(com.kascend.chushou.b.a.a.j jVar) {
        if (!isFinishing() && jVar.f4074a == 1 && !"5".equals(this.R) && !eug()) {
            tv.chushou.zues.utils.e.d(this.v, "onNetworkChangeEvent 3G=" + com.kascend.chushou.b.etQ().b + "  wifi=" + com.kascend.chushou.b.etQ().f4066a);
            if (com.kascend.chushou.d.e.b() && !"4".equals(this.aq)) {
                if (com.kascend.chushou.d.e.c() == -1) {
                    if (this.pjC != null) {
                        this.pjC.e(false);
                    }
                    if ("1".equals(this.R)) {
                        if ("2".equals(this.pjZ)) {
                            d(true, null);
                            return;
                        } else if (this.pjC != null) {
                            this.pjC.g(this.pjE.f, true);
                            return;
                        } else {
                            return;
                        }
                    } else if (this.pjC != null) {
                        this.pjC.g(this.pjE.f, true);
                        return;
                    } else {
                        return;
                    }
                }
                RxExecutor.postDelayed(this.pkb, EventThread.MAIN_THREAD, 10L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.VideoPlayer.12
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!VideoPlayer.this.isFinishing() && com.kascend.chushou.b.etQ().b && !com.kascend.chushou.b.etQ().f4066a) {
                            tv.chushou.zues.utils.g.d(VideoPlayer.this.w, VideoPlayer.this.getString(a.i.str_monet_notify));
                        }
                    }
                });
            } else if (com.kascend.chushou.b.etQ().f4066a || com.kascend.chushou.b.etQ().b) {
                t();
                if (this.pke != null) {
                    this.pke.Sv(2);
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x002a, code lost:
        if (0 == 0) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void g(ArrayList<PlayUrl> arrayList, boolean z) {
        PlayUrl playUrl;
        PlayUrl playUrl2;
        String str;
        String str2;
        boolean z2;
        PlayUrl playUrl3;
        if (arrayList.size() > 0) {
            if (this.pjE.d) {
                Iterator<PlayUrl> it = arrayList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    playUrl3 = it.next();
                    if ("2".equals(playUrl3.mType)) {
                    }
                }
                playUrl3 = null;
                if (playUrl3 == null) {
                    playUrl3 = arrayList.get(0);
                }
                playUrl2 = playUrl3;
            } else {
                Iterator<PlayUrl> it2 = arrayList.iterator();
                PlayUrl playUrl4 = null;
                while (true) {
                    if (!it2.hasNext()) {
                        playUrl = playUrl4;
                        playUrl2 = null;
                        break;
                    }
                    PlayUrl next = it2.next();
                    if ("1".equals(next.mType)) {
                        if (playUrl4 == null) {
                            playUrl4 = next;
                        }
                        if ("2".equals(next.mProtocal)) {
                            PlayUrl playUrl5 = playUrl4;
                            playUrl2 = next;
                            playUrl = playUrl5;
                            break;
                        }
                    }
                }
                if (playUrl2 == null) {
                    playUrl2 = playUrl == null ? arrayList.get(0) : playUrl;
                }
            }
            String d = com.kascend.chushou.d.h.etY().d();
            String str3 = h.isEmpty(d) ? "2" : d;
            if (this.pjE.d) {
                str2 = playUrl2.mUrlDetails.get(0).mUrl;
                playUrl2.mSelectedSourceId = playUrl2.mUrlDetails.get(0).mSourceId;
                playUrl2.mSelectedType = playUrl2.mUrlDetails.get(0).mDefinitionType;
            } else {
                int i = 0;
                while (true) {
                    if (i >= playUrl2.mUrlDetails.size()) {
                        str = "";
                        break;
                    }
                    UrlDetails urlDetails = playUrl2.mUrlDetails.get(i);
                    if (!str3.equals(urlDetails.mDefinitionType)) {
                        i++;
                    } else {
                        str = urlDetails.mUrl;
                        break;
                    }
                }
                str2 = h.isEmpty(str) ? playUrl2.mUrlDetails.get(0).mUrl : str;
                playUrl2.mSelectedSourceId = playUrl2.mUrlDetails.get(0).mSourceId;
                playUrl2.mSelectedType = playUrl2.mUrlDetails.get(0).mDefinitionType;
            }
            tv.chushou.zues.utils.e.d(this.v, "definition=" + str3 + " url=" + str2);
            if (!h.isEmpty(str2)) {
                playUrl2.mSelectedUrl = str2;
                if (this.pjE != null) {
                    this.pjE.a(playUrl2);
                    if (this.pke != null) {
                        Message Sx = this.pke.Sx(5);
                        Sx.arg1 = 1;
                        this.pke.X(Sx);
                    }
                }
                String b = com.kascend.chushou.player.c.a.b(playUrl2);
                if (!h.isEmpty(b)) {
                    this.pjx = Uri.parse(b);
                    if (this.pkh) {
                        this.pkh = false;
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (z && this.pjy != null) {
                        a(false, z2);
                    }
                }
            }
        }
    }

    public void d(final boolean z, ArrayList<PlayUrl> arrayList) {
        if (this.pjO == null || this.pjO.f4226a <= 0) {
            this.pjO = com.kascend.chushou.view.b.a.a.ewh();
            this.pjO.a(new a.InterfaceC1015a() { // from class: com.kascend.chushou.player.VideoPlayer.13
                @Override // com.kascend.chushou.view.b.a.a.InterfaceC1015a
                public void a(int i) {
                    if (i == a.f.tv_play_video) {
                        VideoPlayer.this.pjO.dismissAllowingStateLoss();
                        VideoPlayer.this.c(z);
                    } else if (i == a.f.tv_play_audio) {
                        VideoPlayer.this.pjO.dismissAllowingStateLoss();
                        VideoPlayer.this.d(z);
                    } else if (i == a.f.iv_close) {
                        VideoPlayer.this.finish();
                    } else {
                        if (i == a.f.tv_union_proxy) {
                        }
                    }
                }
            });
            this.pjO.show(getSupportFragmentManager(), "showRoom");
        }
    }

    public void t() {
        if (this.pjO != null) {
            this.pjO.dismissAllowingStateLoss();
        }
        if (this.pjC != null) {
            this.pjC.v();
        }
    }

    public void u() {
        com.kascend.chushou.c.c.etT().c(this.P, new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.VideoPlayer.16
            @Override // com.kascend.chushou.c.b
            public void a() {
            }

            @Override // com.kascend.chushou.c.b
            public void a(String str, JSONObject jSONObject) {
                if (!VideoPlayer.this.isFinishing()) {
                    ParserRet eH = com.kascend.chushou.c.e.eH(jSONObject);
                    if (eH.mRc == 0 && eH.mData != null) {
                        CycleLiveRoomInfo cycleLiveRoomInfo = (CycleLiveRoomInfo) eH.mData;
                        if (VideoPlayer.this.pjE != null && cycleLiveRoomInfo != null && !h.isEmpty(cycleLiveRoomInfo.roomId)) {
                            FullRoomInfo euJ = VideoPlayer.this.pjE.euJ();
                            if (euJ.cycleLiveRoomInfo == null) {
                                euJ.cycleLiveRoomInfo = cycleLiveRoomInfo;
                                VideoPlayer.this.d();
                            } else if (euJ.cycleLiveRoomInfo != null && !cycleLiveRoomInfo.roomId.equals(euJ.cycleLiveRoomInfo.roomId)) {
                                euJ.cycleLiveRoomInfo.copyCycleLiveRoomInfo(cycleLiveRoomInfo);
                                VideoPlayer.this.d();
                            } else {
                                euJ.cycleLiveRoomInfo.copyCycleLiveRoomInfo(cycleLiveRoomInfo);
                            }
                            VideoPlayer.this.T();
                        }
                    }
                }
            }

            @Override // com.kascend.chushou.c.b
            public void a(int i, String str) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void T() {
        if (this.pjC != null) {
            this.pjC.N();
        }
    }

    public void v() {
        com.kascend.chushou.c.c.etT().a(this.P, new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.VideoPlayer.17
            @Override // com.kascend.chushou.c.b
            public void a() {
            }

            @Override // com.kascend.chushou.c.b
            public void a(String str, JSONObject jSONObject) {
                if (!VideoPlayer.this.isFinishing()) {
                    ParserRet eI = com.kascend.chushou.c.e.eI(jSONObject);
                    if (eI.mRc == 0 && eI.mData != null) {
                        PkNotifyInfo pkNotifyInfo = (PkNotifyInfo) eI.mData;
                        VideoPlayer.this.pjX.b = VideoPlayer.this.P;
                        if (pkNotifyInfo != null) {
                            VideoPlayer.this.pjX.poD = pkNotifyInfo;
                            if (VideoPlayer.this.pjC != null) {
                                VideoPlayer.this.pjC.a(pkNotifyInfo, VideoPlayer.this.P);
                            }
                        }
                    }
                }
            }

            @Override // com.kascend.chushou.c.b
            public void a(int i, String str) {
            }
        });
    }

    public void w() {
        if (this.pjF != null) {
            this.pjF.release();
            this.pjF = null;
        }
        com.kascend.chushou.c.c.etT().a(this.P, new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.VideoPlayer.18
            @Override // com.kascend.chushou.c.b
            public void a() {
            }

            @Override // com.kascend.chushou.c.b
            public void a(String str, JSONObject jSONObject) {
                if (!VideoPlayer.this.isFinishing()) {
                    ParserRet eJ = com.kascend.chushou.c.e.eJ(jSONObject);
                    if (eJ.mRc == 0 && eJ.mData != null) {
                        RoomExpandInfo roomExpandInfo = (RoomExpandInfo) eJ.mData;
                        if (VideoPlayer.this.pjE != null) {
                            VideoPlayer.this.pjE.pli = roomExpandInfo.mTopWebAdItem;
                            if (VideoPlayer.this.pjE.plo == null) {
                                VideoPlayer.this.pjE.plo = new ArrayList();
                            }
                            VideoPlayer.this.pjE.plo.clear();
                            VideoPlayer.this.pjE.plo.addAll(roomExpandInfo.mGiftTopRightIcons);
                            tv.chushou.zues.a.a.post(new i(50, VideoPlayer.this.pjE.pli));
                        }
                        if (VideoPlayer.this.pjE != null) {
                            VideoPlayer.this.pjE.gF(roomExpandInfo.mExpandNavList);
                        }
                        VideoPlayer.this.a(roomExpandInfo.mExpandNavList);
                        com.kascend.chushou.player.ui.h5.c.a aVar = roomExpandInfo.mH5Tips;
                        if (aVar != null) {
                            if (aVar.c == 0) {
                                aVar.d = 2;
                            }
                            VideoPlayer.this.c(aVar);
                        }
                        List<com.kascend.chushou.player.ui.h5.c.e> list = roomExpandInfo.mRedpacketBeanList;
                        if (!h.isEmpty(list)) {
                            VideoPlayer.this.pjT.a(list);
                        }
                        List<com.kascend.chushou.player.ui.h5.c.c> list2 = roomExpandInfo.mLuckList;
                        if (!h.isEmpty(list2)) {
                            VideoPlayer.this.pjU.a(list2);
                        }
                        com.kascend.chushou.player.ui.h5.c.c cVar = roomExpandInfo.mVoteItem;
                        if (cVar != null) {
                            VideoPlayer.this.pjV.a(cVar);
                        }
                        List<com.kascend.chushou.player.ui.h5.c.b> list3 = roomExpandInfo.mInteractH5Item;
                        if (!h.isEmpty(list3)) {
                            VideoPlayer.this.pjY.a(list3);
                        }
                        List<com.kascend.chushou.player.ui.h5.c.b> list4 = roomExpandInfo.mInteractNavItem;
                        if (!h.isEmpty(list4)) {
                            VideoPlayer.this.pjY.a(list4);
                        }
                        VideoPlayer.this.pjF = (PrivilegeInfo) eJ.mData1;
                        if (VideoPlayer.this.pjF != null) {
                            tv.chushou.zues.a.a.post(new l());
                        }
                        if (VideoPlayer.this.pjE != null) {
                            VideoPlayer.this.pjE.plp = roomExpandInfo.mIconConfig;
                            VideoPlayer.this.euu().a(roomExpandInfo.mIconConfig.bangConfig);
                        }
                        List<SkinConfig> list5 = roomExpandInfo.skinConfig;
                        if (list5 != null && VideoPlayer.this.pjE != null) {
                            VideoPlayer.this.pjE.pls.clear();
                            int i = 0;
                            while (true) {
                                int i2 = i;
                                if (i2 >= list5.size()) {
                                    break;
                                }
                                SkinConfig skinConfig = list5.get(i2);
                                VideoPlayer.this.pjE.pls.put(skinConfig.position, skinConfig.resource);
                                i = i2 + 1;
                            }
                            VideoPlayer.this.C();
                        }
                        VideoPlayer.this.a(roomExpandInfo.mIconConfig, VideoPlayer.this.pjE != null ? VideoPlayer.this.pjE.pls : null);
                        if (roomExpandInfo.mColorMap != null && roomExpandInfo.mColorMap.size() > 0 && com.kascend.chushou.b.etQ().c != null && com.kascend.chushou.b.etQ().c.size() <= 0) {
                            com.kascend.chushou.b.etQ().c.putAll(roomExpandInfo.mColorMap);
                            tv.chushou.zues.a.a.post(new i(52, null));
                        }
                        AutoBang autoBang = roomExpandInfo.mAutoBang;
                        if (autoBang != null && autoBang.currentTime != 0 && autoBang.bangTime != 0) {
                            VideoPlayer.this.euu().a(autoBang);
                        }
                        if (!h.isEmpty(roomExpandInfo.mRelatedRoomList) && VideoPlayer.this.pjE != null) {
                            VideoPlayer.this.pjE.t = roomExpandInfo.mRelatedRoomList;
                            if (VideoPlayer.this.pjC != null && VideoPlayer.this.H) {
                                VideoPlayer.this.pjC.w();
                            }
                        }
                        if (roomExpandInfo.mRoomNewUserInfo != null && roomExpandInfo.mRoomNewUserInfo.mBarrierNoviceGuide && !com.kascend.chushou.d.h.etY().k() && VideoPlayer.this.pjC != null) {
                            VideoPlayer.this.pjC.J();
                        }
                        if (roomExpandInfo.mRoomNewUserInfo != null && roomExpandInfo.mRoomNewUserInfo.mRewardNoviceGuide && !com.kascend.chushou.d.h.etY().l() && VideoPlayer.this.pjC != null) {
                            VideoPlayer.this.pjC.K();
                        }
                        if (!h.isEmpty(roomExpandInfo.mShopWindowInfos)) {
                            if (VideoPlayer.this.pjE != null) {
                                if (VideoPlayer.this.pjE.plq == null) {
                                    VideoPlayer.this.pjE.plq = new ArrayList();
                                }
                                VideoPlayer.this.pjE.plq.addAll(roomExpandInfo.mShopWindowInfos);
                            }
                            if (VideoPlayer.this.pjC != null) {
                                VideoPlayer.this.pjC.L();
                            }
                        }
                        VideoPlayer.this.pjX.b = VideoPlayer.this.P;
                        if (roomExpandInfo.mPkNotifyInfo != null) {
                            VideoPlayer.this.pjX.poD = roomExpandInfo.mPkNotifyInfo;
                            if (VideoPlayer.this.pjC != null) {
                                VideoPlayer.this.pjC.a(roomExpandInfo.mPkNotifyInfo, VideoPlayer.this.P);
                            }
                        } else {
                            VideoPlayer.this.pjX.poD = null;
                        }
                        if (roomExpandInfo.mTrumpetPocket != null && VideoPlayer.this.pjE != null) {
                            VideoPlayer.this.pjE.plr = roomExpandInfo.mTrumpetPocket;
                            if (VideoPlayer.this.pjC != null) {
                                VideoPlayer.this.pjC.M();
                            }
                        }
                        if (!h.isEmpty(roomExpandInfo.hotwordContentList)) {
                            if (VideoPlayer.this.pjE != null) {
                                if (VideoPlayer.this.pjE.w == null) {
                                    VideoPlayer.this.pjE.w = new ArrayList();
                                }
                                VideoPlayer.this.pjE.w.clear();
                                VideoPlayer.this.pjE.w.addAll(roomExpandInfo.hotwordContentList);
                            }
                            if (VideoPlayer.this.pjC != null) {
                                VideoPlayer.this.pjC.b(roomExpandInfo.hotwordContentList);
                            }
                        }
                        VideoPlayer.this.U();
                        return;
                    }
                    a(eJ.mRc, eJ.mMessage);
                }
            }

            @Override // com.kascend.chushou.c.b
            public void a(int i, String str) {
                tv.chushou.zues.utils.e.e(VideoPlayer.this.v, "get room gift popup list failed, rc =" + i + ", errorMsg=" + str);
            }
        }, this.ag, this.pjZ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U() {
        if (!h.isEmpty(com.kascend.chushou.a.a.etR().z)) {
            StringBuilder sb = new StringBuilder();
            if (com.kascend.chushou.a.a.etR().z.contains(com.kascend.chushou.a.a.f)) {
                if (sb.length() > 0) {
                    sb.append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                sb.append(com.kascend.chushou.a.a.f);
            }
            if (com.kascend.chushou.a.a.etR().z.contains(com.kascend.chushou.a.a.g)) {
                if (sb.length() > 0) {
                    sb.append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                sb.append(com.kascend.chushou.a.a.g);
            }
            if (com.kascend.chushou.a.a.etR().z.contains(com.kascend.chushou.a.a.i)) {
                if (sb.length() > 0) {
                    sb.append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                sb.append(com.kascend.chushou.a.a.i);
            }
            if (com.kascend.chushou.a.a.etR().z.contains(com.kascend.chushou.a.a.h)) {
                if (sb.length() > 0) {
                    sb.append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                sb.append(com.kascend.chushou.a.a.h);
            }
            if (com.kascend.chushou.a.a.etR().z.contains(com.kascend.chushou.a.a.j)) {
                if (sb.length() > 0) {
                    sb.append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                sb.append(com.kascend.chushou.a.a.j);
            }
            if (com.kascend.chushou.a.a.etR().z.contains(com.kascend.chushou.a.a.l)) {
                if (sb.length() > 0) {
                    sb.append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                sb.append(com.kascend.chushou.a.a.l);
            }
            if (com.kascend.chushou.a.a.etR().z.contains(com.kascend.chushou.a.a.m)) {
                if (sb.length() > 0) {
                    sb.append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                sb.append(com.kascend.chushou.a.a.m);
            }
            if (sb.length() != 0) {
                com.kascend.chushou.a.a.etR().a(sb.toString(), this.P, new a.c() { // from class: com.kascend.chushou.player.VideoPlayer.19
                    @Override // com.kascend.chushou.a.a.c
                    public void a(List<ListItem> list) {
                        if (VideoPlayer.this.pjE != null && list != null) {
                            int i = 0;
                            while (true) {
                                int i2 = i;
                                if (i2 >= list.size()) {
                                    break;
                                }
                                if (list.get(i2).mAdExtraInfo != null) {
                                    if (com.kascend.chushou.a.a.f.equals(list.get(i2).mAdExtraInfo.mCode)) {
                                        VideoPlayer.this.pjE.plh = list.get(i2);
                                    } else if (com.kascend.chushou.a.a.g.equals(list.get(i2).mAdExtraInfo.mCode)) {
                                        VideoPlayer.this.pjE.plg = list.get(i2);
                                    } else if (com.kascend.chushou.a.a.i.equals(list.get(i2).mAdExtraInfo.mCode)) {
                                        VideoPlayer.this.pjE.plj = list.get(i2);
                                    } else if (com.kascend.chushou.a.a.h.equals(list.get(i2).mAdExtraInfo.mCode)) {
                                        VideoPlayer.this.pjE.plk = list.get(i2);
                                    } else if (com.kascend.chushou.a.a.j.equals(list.get(i2).mAdExtraInfo.mCode)) {
                                        VideoPlayer.this.pjE.pln = list.get(i2);
                                    } else if (com.kascend.chushou.a.a.l.equals(list.get(i2).mAdExtraInfo.mCode)) {
                                        VideoPlayer.this.pjE.pll = list.get(i2);
                                    } else if (com.kascend.chushou.a.a.m.equals(list.get(i2).mAdExtraInfo.mCode)) {
                                        VideoPlayer.this.pjE.plm = list.get(i2);
                                    }
                                }
                                i = i2 + 1;
                            }
                            if (VideoPlayer.this.pjC != null) {
                                VideoPlayer.this.pjC.H();
                            }
                        }
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str, String str2) {
        if (eum()) {
            com.kascend.chushou.toolkit.a.a.a("type", "1", "value", str, "desc", str2, "videoId", this.P);
        }
    }

    public void e(boolean z) {
        Window window;
        int i;
        if (Build.VERSION.SDK_INT >= 11 && (window = getWindow()) != null && window.getDecorView() != null) {
            if (!z) {
                if (Build.VERSION.SDK_INT >= 19) {
                    i = 5894;
                } else {
                    i = 1799;
                }
                this.pjJ.setSystemUiVisibility(i);
                return;
            }
            this.pjJ.setSystemUiVisibility(1792);
        }
    }

    public void f(boolean z) {
        Window window;
        View decorView;
        if (com.kascend.chushou.b.etQ().d != 1 && (window = getWindow()) != null && (decorView = window.getDecorView()) != null) {
            if (!z) {
                decorView.setSystemUiVisibility(1796);
                window.clearFlags(67108864);
                if (Build.VERSION.SDK_INT >= 21) {
                    window.addFlags(Integer.MIN_VALUE);
                    window.setStatusBarColor(0);
                    return;
                }
                return;
            }
            decorView.setSystemUiVisibility(1792);
            window.clearFlags(67108864);
            if (Build.VERSION.SDK_INT >= 21) {
                window.addFlags(Integer.MIN_VALUE);
                window.setStatusBarColor(0);
            }
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.pjC != null) {
            this.pjC.a(i, i2, intent);
        }
    }

    public Uri eun() {
        return this.pjx;
    }

    @Override // com.kascend.chushou.view.base.BaseActivity
    protected int y() {
        return 0;
    }

    public void AK(boolean z) {
        if (this.pjJ != null) {
            this.pjJ.qrr = z;
        }
    }

    public void euo() {
        if (this.pjJ != null) {
            this.pjJ.euo();
        }
    }

    public boolean eup() {
        return this.ae;
    }

    public void g(boolean z) {
        this.ae = z;
    }

    public void h(boolean z) {
        if (this.pjJ != null) {
            this.pjJ.setIsTranslucentStatus(z);
        }
    }

    public void z() {
        if (this.pjJ != null) {
            this.pjJ.eIm();
        }
    }

    @Override // com.kascend.chushou.widget.gifts.RoomSendGiftView.a
    public void A() {
        if (this.pjH != null) {
            this.pjH.b();
        }
        if (this.pjE != null) {
            this.pjE.z = true;
        }
    }

    @Override // com.kascend.chushou.widget.gifts.RoomSendGiftView.a
    public void B() {
        if (this.pjH != null) {
            this.pjH.b();
        }
    }

    public void a(List<ListItem> list) {
        if (this.pjC != null) {
            this.pjC.a(list);
        }
    }

    public void a(IconConfig iconConfig, Map<String, SkinConfig.SkinRes> map) {
        if (this.pjC != null) {
            this.pjC.a(iconConfig, map);
        }
    }

    public void C() {
        if (this.pjC != null) {
            this.pjC.I();
        }
    }

    @Override // com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC1007a
    public void a(int i) {
        if (this.pjC != null) {
            this.pjC.a(i);
        }
    }

    @Override // com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC1007a
    public void D() {
        if (!isFinishing() && this.pjC != null) {
            this.pjC.D();
        }
    }

    @Override // com.kascend.chushou.player.ui.h5.b.b.a
    public void a(long j) {
        if (!isFinishing() && this.pjC != null) {
            this.pjC.a(j);
        }
    }

    @Override // com.kascend.chushou.player.ui.h5.b.b.a
    public void a(com.kascend.chushou.player.ui.h5.c.a aVar) {
        if (aVar != null && this.pjC != null) {
            this.pjC.a(aVar);
        }
    }

    @Override // com.kascend.chushou.player.ui.h5.b.b.a
    public void b(int i) {
        if (this.pjC != null) {
            this.pjC.b(i);
        }
    }

    @Override // com.kascend.chushou.player.ui.h5.d.a.InterfaceC1006a
    public void b(long j) {
        if (!isFinishing() && this.pjC != null) {
            this.pjC.b(j);
        }
    }

    @Override // com.kascend.chushou.player.ui.h5.a.a.InterfaceC1004a
    public void c(int i) {
        if (!isFinishing() && this.pjC != null) {
            this.pjC.c(i);
        }
    }

    @Override // com.kascend.chushou.player.ui.h5.d.a.InterfaceC1006a
    public void b(com.kascend.chushou.player.ui.h5.c.a aVar) {
        if (aVar != null && this.pjC != null) {
            this.pjC.b(aVar);
        }
    }

    @Override // com.kascend.chushou.player.ui.a.a.InterfaceC1001a
    public void a(IconConfig.Config config) {
        if (this.pjC != null) {
            this.pjC.a(config);
        }
    }

    @Override // com.kascend.chushou.player.ui.a.a.InterfaceC1001a
    public void a(BangInfo bangInfo, String str) {
        if (this.pjC != null) {
            this.pjC.a(bangInfo, str);
        }
    }

    @Override // com.kascend.chushou.player.ui.a.a.InterfaceC1001a
    public void a(long j, BangInfo bangInfo, String str) {
        if (this.pjC != null) {
            this.pjC.a(j, bangInfo, str);
        }
    }

    public com.kascend.chushou.player.ui.h5.redpacket.a euq() {
        return this.pjT;
    }

    public com.kascend.chushou.player.ui.h5.b.b eur() {
        return this.pjU;
    }

    public com.kascend.chushou.player.ui.h5.d.a eus() {
        return this.pjV;
    }

    public com.kascend.chushou.player.ui.h5.a.a eut() {
        return this.pjY;
    }

    public com.kascend.chushou.player.ui.a.a euu() {
        return this.pjW;
    }

    public com.kascend.chushou.player.e.a euv() {
        return this.pjX;
    }

    @Override // com.kascend.chushou.view.base.BaseActivity, android.app.Activity
    public void finish() {
        super.finish();
        if ("3".equals(this.R)) {
            overridePendingTransition(17432576, a.C0991a.commonres_activity_exit_bottom);
        }
    }

    public void c(com.kascend.chushou.player.ui.h5.c.a aVar) {
        if (aVar != null) {
            if (aVar.c == 0) {
                d(aVar);
            } else if (aVar.c == 2) {
                e(aVar);
            } else {
                tv.chushou.zues.utils.e.d(this.v, "Unknown h5item h5type=" + aVar.c);
            }
        }
    }

    private void d(final com.kascend.chushou.player.ui.h5.c.a aVar) {
        if (aVar.d < 0) {
            aVar.d = 0;
        }
        RxExecutor.postDelayed(this.pkb, EventThread.MAIN_THREAD, aVar.d, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.VideoPlayer.2
            @Override // java.lang.Runnable
            public void run() {
                if (VideoPlayer.this.pjC != null) {
                    VideoPlayer.this.pjC.c(aVar);
                }
            }
        });
    }

    private void e(final com.kascend.chushou.player.ui.h5.c.a aVar) {
        if (!com.kascend.chushou.d.h.etY().eub().contains(aVar.b)) {
            if (aVar.d < 0) {
                aVar.d = 0;
            }
            RxExecutor.postDelayed(this.pkb, EventThread.MAIN_THREAD, aVar.d, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.VideoPlayer.3
                @Override // java.lang.Runnable
                public void run() {
                    if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.pjC != null) {
                        VideoPlayer.this.pjC.c(aVar);
                    }
                }
            });
        }
    }

    private String euw() {
        if ("4".equals(this.aq)) {
            return TbEnum.SystemMessage.EVENT_ID_GROUP_NAME_MODIFY + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP + TbEnum.SystemMessage.EVENT_ID_NOTICE_MODIFY;
        }
        return "2" + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP + "1" + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP + TbEnum.SystemMessage.EVENT_ID_GROUP_NAME_MODIFY + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP + TbEnum.SystemMessage.EVENT_ID_NOTICE_MODIFY;
    }

    /* loaded from: classes6.dex */
    private class a extends BroadcastReceiver {
        private a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (VideoReceiver.ACTION_VOLUME_CHANGED.equals(intent.getAction())) {
                if (VideoPlayer.this.pjI != null && !VideoPlayer.this.isFinishing()) {
                    VideoPlayer.n = VideoPlayer.this.pjI.getStreamVolume(3);
                }
                if (!VideoPlayer.this.isFinishing() && (VideoPlayer.this.pjC instanceof f)) {
                    ((f) VideoPlayer.this.pjC).ab();
                }
            }
        }
    }

    public String a(String str) {
        HashMap hashMap = new HashMap(tv.chushou.zues.utils.d.aan(str));
        if ("1".equals(this.R)) {
            hashMap.put("roomId", this.P);
        } else if ("3".equals(this.R)) {
            hashMap.put("videoId", this.P);
        }
        return tv.chushou.zues.utils.d.toJson(hashMap);
    }

    public boolean eux() {
        if (this.pjC instanceof com.kascend.chushou.player.d.a) {
            return ((com.kascend.chushou.player.d.a) this.pjC).evv();
        }
        if (this.pjC instanceof com.kascend.chushou.player.e.e) {
            return true;
        }
        return false;
    }
}

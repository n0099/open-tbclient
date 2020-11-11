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
public class VideoPlayer extends BaseActivity implements a.InterfaceC0998a, a.InterfaceC1001a, b.a, a.InterfaceC1003a, a.InterfaceC1004a, RoomSendGiftView.a {
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
    private c phV;
    b phY;
    public PrivilegeInfo phZ;
    private CSTVWifiReceiver piA;
    com.kascend.chushou.widget.a.b pib;
    private KPSwitchRootRelativeLayout pif;
    private FrameLayout pig;
    private ImageView pih;
    private LinearLayout pii;
    private com.kascend.chushou.toolkit.d pij;
    com.kascend.chushou.view.b.a.a pik;
    private FrescoThumbnailView pio;
    private FrameLayout pip;
    public com.kascend.chushou.player.feedback.a pix;
    private a piz;
    private boolean B = true;
    private boolean C = false;
    private Uri phR = null;
    private tv.chushou.common.player.a phS = null;
    public tv.chushou.common.player.a phT = null;
    public tv.chushou.common.player.a phU = null;
    public boolean d = false;
    public boolean e = false;
    private e phW = null;
    private boolean H = false;
    private com.kascend.chushou.view.user.b phX = null;
    private boolean J = false;
    private boolean K = false;
    private boolean L = false;
    private boolean M = false;
    private long N = 0;
    private int O = 0;
    public boolean g = false;
    private ImageView T = null;
    private TextView U = null;
    private AnimationImageView pia = null;
    private View cfX = null;
    public boolean j = false;
    public float k = 0.0f;
    public float l = 0.0f;
    public boolean m = false;
    public AudioManager pie = null;
    private d.a pil = new d.a() { // from class: com.kascend.chushou.player.VideoPlayer.1
        @Override // com.kascend.chushou.toolkit.d.a
        public void a() {
            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.piB != null) {
                VideoPlayer.this.piB.RT(4);
            }
        }
    };
    private boolean ae = false;
    public boolean q = true;
    public long r = -1;
    public long s = -1;
    private PowerManager.WakeLock pim = null;
    public String t = null;
    private final com.kascend.chushou.player.ui.h5.redpacket.a piq = new com.kascend.chushou.player.ui.h5.redpacket.a(this);
    private final com.kascend.chushou.player.ui.h5.b.b pir = new com.kascend.chushou.player.ui.h5.b.b(this);
    private final com.kascend.chushou.player.ui.h5.d.a pis = new com.kascend.chushou.player.ui.h5.d.a(this);
    private final com.kascend.chushou.player.ui.a.a pit = new com.kascend.chushou.player.ui.a.a(this);
    private final com.kascend.chushou.player.e.a piu = new com.kascend.chushou.player.e.a();
    private final com.kascend.chushou.player.ui.h5.a.a piv = new com.kascend.chushou.player.ui.h5.a.a(this);
    private String piw = "1";
    private String aq = "2";
    private io.reactivex.disposables.a piy = new io.reactivex.disposables.a();
    private tv.chushou.zues.c piB = new tv.chushou.zues.c(new Handler.Callback() { // from class: com.kascend.chushou.player.VideoPlayer.6
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            try {
                if (!VideoPlayer.this.isFinishing()) {
                    switch (message.what) {
                        case 1:
                            VideoPlayer.this.piB.removeMessages(1);
                            com.kascend.chushou.c.c.etT().a(VideoPlayer.this.P, VideoPlayer.this.phY != null ? VideoPlayer.this.phY.h : null, System.currentTimeMillis());
                            VideoPlayer.this.piB.D(1, VideoPlayer.A);
                            break;
                        case 2:
                            VideoPlayer.this.a(true, (Uri) null, false);
                            break;
                        case 3:
                            VideoPlayer.this.S();
                            break;
                        case 4:
                            if (VideoPlayer.this.phW != null) {
                                VideoPlayer.this.phW.a(true);
                            }
                            if (VideoPlayer.this.pij != null) {
                                VideoPlayer.this.pij.d();
                                VideoPlayer.this.pij = null;
                                break;
                            }
                            break;
                        case 5:
                            int i = message.arg1;
                            if (i == 1) {
                                if (VideoPlayer.this.phW != null) {
                                    VideoPlayer.this.phW.p();
                                    break;
                                }
                            } else if (i == 2 && VideoPlayer.this.phW != null) {
                                VideoPlayer.this.phW.e(message.arg2);
                                break;
                            }
                            break;
                        case 6:
                            if (!com.kascend.chushou.b.etQ().f4066a && !com.kascend.chushou.b.etQ().b && VideoPlayer.this.phW != null) {
                                VideoPlayer.this.phW.g(true);
                                break;
                            } else {
                                VideoPlayer.this.c();
                                break;
                            }
                            break;
                        case 7:
                            tv.chushou.zues.utils.e.d(VideoPlayer.this.v, "MSG_BUFFER_DEALY: ");
                            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.phW != null && VideoPlayer.this.M && !VideoPlayer.this.e) {
                                VideoPlayer.this.phW.h(true);
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
    private boolean piC = false;
    private boolean aw = true;
    private boolean piD = false;
    private tv.chushou.common.player.b piE = new tv.chushou.common.player.b() { // from class: com.kascend.chushou.player.VideoPlayer.14
        @Override // tv.chushou.common.player.b
        public void euz() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerACallback onSetVideoViewLayout");
            if (!VideoPlayer.this.isFinishing()) {
                if ((VideoPlayer.this.phW == null || !VideoPlayer.this.phW.H) && VideoPlayer.this.phW != null && !VideoPlayer.this.d) {
                    VideoPlayer.this.phW.y();
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void Qy(int i) {
            if (!VideoPlayer.this.isFinishing()) {
                if ((VideoPlayer.this.phW == null || !VideoPlayer.this.phW.H) && VideoPlayer.this.phW != null && !VideoPlayer.this.d) {
                    VideoPlayer.this.phW.g(i);
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
                if (VideoPlayer.this.piB != null) {
                    VideoPlayer.this.piB.removeMessages(1);
                }
                if ((VideoPlayer.this.phW == null || !VideoPlayer.this.phW.H) && VideoPlayer.this.phW != null && !VideoPlayer.this.d) {
                    VideoPlayer.this.piB.removeMessages(7);
                    VideoPlayer.this.M = false;
                    VideoPlayer.this.phW.z();
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void euB() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerACallback onVideoRenderingStart");
            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.phW != null) {
                VideoPlayer.this.phW.G();
            }
        }

        @Override // tv.chushou.common.player.b
        public void euC() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerACallback onPreparedPlayback");
            if (!VideoPlayer.this.isFinishing()) {
                if (VideoPlayer.this.phW == null || !VideoPlayer.this.phW.H) {
                    VideoPlayer.this.piB.removeMessages(6);
                    VideoPlayer.this.N = 0L;
                    VideoPlayer.this.O = 0;
                    if (VideoPlayer.this.phS != null && VideoPlayer.this.phW != null) {
                        VideoPlayer.this.phS.setVolume(VideoPlayer.this.phW.J, VideoPlayer.this.phW.J);
                    }
                    if (VideoPlayer.this.phY != null) {
                        VideoPlayer.this.K = false;
                        FullRoomInfo euJ = VideoPlayer.this.eum() ? null : VideoPlayer.this.phY.euJ();
                        if (VideoPlayer.this.L || euJ != null) {
                            if (VideoPlayer.this.phY.e) {
                                VideoPlayer.this.phY.e = false;
                                VideoPlayer.this.phY.d = !VideoPlayer.this.phY.d;
                            }
                            if (VideoPlayer.this.phW != null) {
                                VideoPlayer.this.c("1", (String) null);
                                if (!VideoPlayer.this.d) {
                                    VideoPlayer.this.phW.i(true);
                                } else if (VideoPlayer.this.e) {
                                    VideoPlayer.this.e = false;
                                    VideoPlayer.this.phW.B();
                                }
                            }
                        }
                    }
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void Qz(int i) {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerACallback onErrorAppeared");
            if (!VideoPlayer.this.isFinishing()) {
                VideoPlayer.this.c();
                VideoPlayer.this.K = false;
                if (VideoPlayer.this.piB != null) {
                    VideoPlayer.this.piB.removeMessages(7);
                }
                if (VideoPlayer.this.piB != null) {
                    VideoPlayer.this.piB.removeMessages(1);
                }
                if ((VideoPlayer.this.phW == null || !VideoPlayer.this.phW.H) && !VideoPlayer.this.eug()) {
                    if (!"10004".equals(VideoPlayer.this.t)) {
                        if (VideoPlayer.this.phW != null) {
                            if (VideoPlayer.this.d) {
                                VideoPlayer.this.phT.stop();
                                VideoPlayer.this.phT.release();
                                VideoPlayer.this.e = false;
                                VideoPlayer.this.phW.C();
                            }
                            if (!com.kascend.chushou.b.etQ().f4066a && !com.kascend.chushou.b.etQ().b) {
                                VideoPlayer.this.phW.g(true);
                            } else if (VideoPlayer.this.d) {
                                VideoPlayer.this.phW.a(i, true);
                            } else {
                                VideoPlayer.this.phW.a(i, false);
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
                if ((VideoPlayer.this.phW == null || !VideoPlayer.this.phW.H) && VideoPlayer.this.phW != null && !VideoPlayer.this.d) {
                    VideoPlayer.this.phW.E();
                    VideoPlayer.this.M = true;
                    long currentTimeMillis = System.currentTimeMillis();
                    VideoPlayer.this.piB.removeMessages(7);
                    if (!VideoPlayer.this.g) {
                        VideoPlayer.y(VideoPlayer.this);
                    }
                    tv.chushou.zues.utils.e.d(VideoPlayer.this.v, "currentTime: -- >" + currentTimeMillis + "  bufferTime-->" + VideoPlayer.this.N + "  bufferCount-->" + VideoPlayer.this.O);
                    if (currentTimeMillis - VideoPlayer.this.N >= 20000 || VideoPlayer.this.O < 2 || VideoPlayer.this.phW.H) {
                        if (VideoPlayer.this.O == 1) {
                            VideoPlayer.this.N = currentTimeMillis;
                        }
                        VideoPlayer.this.piB.D(7, 5000L);
                    } else {
                        VideoPlayer.this.piB.RT(7);
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
            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.phW != null && !VideoPlayer.this.d) {
                VideoPlayer.this.piB.removeMessages(7);
                VideoPlayer.this.M = false;
                if (VideoPlayer.this.phW == null || !VideoPlayer.this.phW.H) {
                    if (VideoPlayer.this.phS == null) {
                        VideoPlayer.this.phW.a(false, true, false);
                    } else {
                        VideoPlayer.this.phW.a(true, VideoPlayer.this.phS.getPlayState() == 4, VideoPlayer.this.phS.getPlayState() == 5);
                    }
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void onPlayerStart() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerACallback onPlayerStart");
            if (!VideoPlayer.this.isFinishing()) {
                if (VideoPlayer.this.phW == null || !VideoPlayer.this.phW.H) {
                    if (VideoPlayer.this.phW != null && !VideoPlayer.this.d) {
                        if (VideoPlayer.this.phS != null) {
                            VideoPlayer.this.phW.F();
                            VideoPlayer.this.phW.a(true, VideoPlayer.this.phS.getPlayState() == 4, VideoPlayer.this.phS.getPlayState() == 5);
                        } else {
                            VideoPlayer.this.phW.a(false, true, false);
                        }
                    }
                    if (VideoPlayer.this.piB != null && !VideoPlayer.this.eum()) {
                        VideoPlayer.this.piB.removeMessages(1);
                        VideoPlayer.this.piB.D(1, VideoPlayer.A);
                    }
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void euF() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerACallback onPlayerPause");
            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.piB != null) {
                VideoPlayer.this.piB.removeMessages(1);
            }
        }

        @Override // tv.chushou.common.player.b
        public void euG() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerACallback onPlayerStop");
            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.eum() && VideoPlayer.this.phT != null && !h.isEmpty(VideoPlayer.this.P) && VideoPlayer.this.phT.getCurrentPos() > 0) {
                j.eue().a(VideoPlayer.this.P, VideoPlayer.this.phT.getCurrentPos());
            }
        }
    };
    private tv.chushou.common.player.b piF = new tv.chushou.common.player.b() { // from class: com.kascend.chushou.player.VideoPlayer.15
        @Override // tv.chushou.common.player.b
        public void euz() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerBCallback onSetVideoViewLayout");
            if (!VideoPlayer.this.isFinishing()) {
                if ((VideoPlayer.this.phW == null || !VideoPlayer.this.phW.H) && VideoPlayer.this.phW != null && VideoPlayer.this.d) {
                    VideoPlayer.this.phW.y();
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void Qy(int i) {
            if (!VideoPlayer.this.isFinishing()) {
                if ((VideoPlayer.this.phW == null || !VideoPlayer.this.phW.H) && VideoPlayer.this.phW != null && VideoPlayer.this.d) {
                    VideoPlayer.this.phW.g(i);
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
                if (VideoPlayer.this.piB != null) {
                    VideoPlayer.this.piB.removeMessages(1);
                }
                if ((VideoPlayer.this.phW == null || !VideoPlayer.this.phW.H) && VideoPlayer.this.phW != null && VideoPlayer.this.d) {
                    VideoPlayer.this.piB.removeMessages(7);
                    VideoPlayer.this.M = false;
                    VideoPlayer.this.phW.z();
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void euB() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerBCallback onVideoRenderingStart");
            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.phW != null) {
                VideoPlayer.this.phW.G();
            }
        }

        @Override // tv.chushou.common.player.b
        public void euC() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerBCallback onPreparedPlayback");
            if (!VideoPlayer.this.isFinishing()) {
                if (VideoPlayer.this.phW == null || !VideoPlayer.this.phW.H) {
                    VideoPlayer.this.piB.removeMessages(6);
                    VideoPlayer.this.N = 0L;
                    VideoPlayer.this.O = 0;
                    if (VideoPlayer.this.phS != null && VideoPlayer.this.phW != null) {
                        VideoPlayer.this.phS.setVolume(VideoPlayer.this.phW.J, VideoPlayer.this.phW.J);
                    }
                    if (VideoPlayer.this.phY != null) {
                        VideoPlayer.this.K = false;
                        FullRoomInfo euJ = VideoPlayer.this.eum() ? null : VideoPlayer.this.phY.euJ();
                        if (VideoPlayer.this.L || euJ != null) {
                            if (VideoPlayer.this.phY.e) {
                                VideoPlayer.this.phY.e = false;
                                VideoPlayer.this.phY.d = !VideoPlayer.this.phY.d;
                            }
                            if (VideoPlayer.this.phW != null) {
                                VideoPlayer.this.c("1", (String) null);
                                if (VideoPlayer.this.d) {
                                    VideoPlayer.this.phW.i(true);
                                } else if (VideoPlayer.this.e) {
                                    VideoPlayer.this.e = false;
                                    VideoPlayer.this.phW.B();
                                }
                            }
                        }
                    }
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void Qz(int i) {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerBCallback onErrorAppeared");
            if (!VideoPlayer.this.isFinishing()) {
                VideoPlayer.this.c();
                VideoPlayer.this.K = false;
                if (VideoPlayer.this.piB != null) {
                    VideoPlayer.this.piB.removeMessages(7);
                }
                if (VideoPlayer.this.piB != null) {
                    VideoPlayer.this.piB.removeMessages(1);
                }
                if ((VideoPlayer.this.phW == null || !VideoPlayer.this.phW.H) && !VideoPlayer.this.eug()) {
                    if (!"10004".equals(VideoPlayer.this.t)) {
                        if (VideoPlayer.this.phW != null) {
                            if (!VideoPlayer.this.d) {
                                VideoPlayer.this.phU.stop();
                                VideoPlayer.this.phU.release();
                                VideoPlayer.this.phW.C();
                                VideoPlayer.this.e = false;
                            }
                            if (!com.kascend.chushou.b.etQ().f4066a && !com.kascend.chushou.b.etQ().b) {
                                VideoPlayer.this.phW.g(true);
                            } else if (VideoPlayer.this.d) {
                                VideoPlayer.this.phW.a(i, false);
                            } else {
                                VideoPlayer.this.phW.a(i, true);
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
                if ((VideoPlayer.this.phW == null || !VideoPlayer.this.phW.H) && VideoPlayer.this.phW != null && VideoPlayer.this.d) {
                    VideoPlayer.this.phW.E();
                    VideoPlayer.this.M = true;
                    VideoPlayer.this.piB.removeMessages(7);
                    long currentTimeMillis = System.currentTimeMillis();
                    if (!VideoPlayer.this.g) {
                        VideoPlayer.y(VideoPlayer.this);
                    }
                    tv.chushou.zues.utils.e.d(VideoPlayer.this.v, "currentTime: -- >" + currentTimeMillis + "  bufferTime-->" + VideoPlayer.this.N + "  bufferCount-->" + VideoPlayer.this.O);
                    if (currentTimeMillis - VideoPlayer.this.N >= 20000 || VideoPlayer.this.O < 2 || VideoPlayer.this.phW.H) {
                        if (VideoPlayer.this.O == 1) {
                            VideoPlayer.this.N = currentTimeMillis;
                        }
                        VideoPlayer.this.piB.D(7, 5000L);
                    } else {
                        VideoPlayer.this.N = 0L;
                        VideoPlayer.this.O = 0;
                        VideoPlayer.this.piB.RT(7);
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
            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.phW != null && VideoPlayer.this.d) {
                VideoPlayer.this.M = false;
                VideoPlayer.this.piB.removeMessages(7);
                if (VideoPlayer.this.phW == null || !VideoPlayer.this.phW.H) {
                    if (VideoPlayer.this.phS == null) {
                        VideoPlayer.this.phW.a(false, true, false);
                    } else {
                        VideoPlayer.this.phW.a(true, VideoPlayer.this.phS.getPlayState() == 4, VideoPlayer.this.phS.getPlayState() == 5);
                    }
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void onPlayerStart() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerBCallback onPlayerStart");
            if (!VideoPlayer.this.isFinishing()) {
                if (VideoPlayer.this.phW == null || !VideoPlayer.this.phW.H) {
                    if (VideoPlayer.this.phW != null && VideoPlayer.this.d) {
                        if (VideoPlayer.this.phS != null) {
                            VideoPlayer.this.phW.F();
                            VideoPlayer.this.phW.a(true, VideoPlayer.this.phS.getPlayState() == 4, VideoPlayer.this.phS.getPlayState() == 5);
                        } else {
                            VideoPlayer.this.phW.a(false, true, false);
                        }
                    }
                    if (VideoPlayer.this.piB != null && !VideoPlayer.this.eum()) {
                        VideoPlayer.this.piB.removeMessages(1);
                        VideoPlayer.this.piB.D(1, VideoPlayer.A);
                    }
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void euF() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerBCallback onPlayerPause");
            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.piB != null) {
                VideoPlayer.this.piB.removeMessages(1);
            }
        }

        @Override // tv.chushou.common.player.b
        public void euG() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerBCallback onPlayerStop");
            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.eum() && VideoPlayer.this.phU != null && !h.isEmpty(VideoPlayer.this.P) && VideoPlayer.this.phU.getCurrentPos() > 0) {
                j.eue().a(VideoPlayer.this.P, VideoPlayer.this.phU.getCurrentPos());
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
        this.phR = intent.getData();
        if (this.phR == null) {
            finish();
            return;
        }
        com.kascend.chushou.d.e.j();
        if (this.piA == null) {
            this.piA = new CSTVWifiReceiver();
            registerReceiver(this.piA, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        }
        com.kascend.chushou.toolkit.d.a.ewg().b();
        tv.chushou.zues.utils.e.i(this.v, "intent.getData=" + this.phR.toString());
        String scheme = this.phR.getScheme();
        if (scheme == null || !scheme.equals("chushou")) {
            tv.chushou.zues.utils.e.e(this.v, "not support scheme :" + scheme);
            finish();
            return;
        }
        a(intent);
    }

    private void a(Intent intent) {
        this.P = this.phR.getQueryParameter("roomId");
        this.Q = this.P;
        this.S = this.phR.getQueryParameter(WebSocketRequest.PARAM_KEY_PROTOCOLS);
        this.aq = this.phR.getQueryParameter("liveType");
        if ("2".equals(this.aq) || "3".equals(this.aq) || "4".equals(this.aq)) {
            this.piw = "2";
            this.pix = new com.kascend.chushou.player.feedback.a();
            if (this.pix.pqQ != null) {
                this.pix.pqQ.reset();
                this.pix.pqQ.roomId = this.P;
                this.pix.pqQ.enterType = 1;
                this.pix.b = System.currentTimeMillis();
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
        this.pim = ((PowerManager) getSystemService("power")).newWakeLock(536870938, this.v);
        this.pim.acquire();
        this.phY = new b(this.P);
        this.phY.d = intent.getBooleanExtra("room_play_audio", false);
        this.pib = new com.kascend.chushou.widget.a.b();
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
        this.pif = (KPSwitchRootRelativeLayout) findViewById(a.f.rlRoot);
        if (!"2".equals(this.piw) && com.kascend.chushou.b.etQ().d == 1) {
            this.pif.setFitsSystemWindows(true);
        }
        this.pig = (FrameLayout) this.pif.findViewById(a.f.fl_fragment);
        this.cfX = this.pif.findViewById(a.f.rl_empty);
        this.T = (ImageView) this.cfX.findViewById(a.f.iv_empty);
        this.U = (TextView) this.cfX.findViewById(a.f.tv_empty);
        this.pii = (LinearLayout) this.pif.findViewById(a.f.rl_title);
        this.pih = (ImageView) this.pii.findViewById(a.f.back_icon);
        this.pih.setOnClickListener(new View.OnClickListener() { // from class: com.kascend.chushou.player.VideoPlayer.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayer.this.finish();
            }
        });
        this.pia = (AnimationImageView) this.cfX.findViewById(a.f.iv_loading);
        this.pio = (FrescoThumbnailView) this.pif.findViewById(a.f.live_cover);
        this.pip = (FrameLayout) this.pif.findViewById(a.f.fl_cover);
        this.k = euf();
        try {
            this.pie = (AudioManager) getApplicationContext().getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
            n = this.pie.getStreamVolume(3);
            this.pie.requestAudioFocus(null, 3, 1);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (this.B) {
            a(1, eum() ? "3" : "1");
        } else {
            r();
        }
        if (com.kascend.chushou.b.etQ().b && !com.kascend.chushou.b.etQ().f4066a) {
            RxExecutor.postDelayed(this.piy, EventThread.MAIN_THREAD, 60L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.VideoPlayer.5
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
        if (this.piz == null) {
            this.piz = new a();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(VideoReceiver.ACTION_VOLUME_CHANGED);
            registerReceiver(this.piz, intentFilter);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        j(false);
        if (this.piz != null) {
            unregisterReceiver(this.piz);
            this.piz = null;
        }
        super.onStop();
    }

    @Override // com.kascend.chushou.view.base.BaseActivity
    protected void a(boolean z) {
        if (this.phW != null) {
            this.phW.k(z);
        }
    }

    @Subscribe
    public void onHideGiftEffectEvent(com.kascend.chushou.b.a.a.f fVar) {
        if (fVar.b) {
            this.phW.k();
            return;
        }
        this.phW.m();
        this.phW.l();
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
            this.phY.h = jSONObject.toString();
            String optString = jSONObject.optString("_thumb");
            jSONObject.optBoolean("tag_from_game_mic", false);
            if (!h.isEmpty(optString)) {
                this.ab = optString;
            }
        } catch (JSONException e) {
            e.printStackTrace();
            this.phY.h = str;
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
        if (this.phW != null) {
            this.phW.r();
        }
        s();
    }

    @Subscribe
    public void onStartRoomEvent(o oVar) {
        if (!isFinishing() && oVar.phz != null && oVar.c != null && !h.isEmpty(oVar.phz.mTargetKey)) {
            if (oVar.c != this) {
                tv.chushou.zues.utils.e.e(this.v, "different player!");
                return;
            }
            if (this.phY != null) {
                this.phY.a();
                this.phY.f4119a = oVar.phz.mTargetKey;
                this.phY.d = oVar.d;
                if (this.phY.pjA != null) {
                    this.phY.pjA.e();
                }
                if (this.phY.pjA != null) {
                    this.phY.pjA.b();
                }
                this.phY.pjD = null;
                this.phY.pjC = null;
                this.phY.pjG = null;
                this.phY.pjF = null;
                this.phY.pjJ = null;
                this.phY.pjH = null;
                this.phY.pjI = null;
            }
            if (this.pie != null) {
                n = this.pie.getStreamVolume(3);
            }
            if (!h.isEmpty(oVar.phz.mType) && oVar.phz.mType.equals("3")) {
                this.B = false;
                this.piw = "1";
                r();
                this.P = oVar.phz.mTargetKey;
                this.R = "3";
                if (this.pib != null) {
                    this.pib.a();
                }
                if (this.phY != null) {
                    this.phY.a((PlayUrl) null);
                    this.phY.f();
                    if (this.phY.c() != null) {
                        this.phY.c().clear();
                    }
                    this.phY.i.clear();
                }
                if (this.phW != null) {
                    this.phW.j();
                }
                s();
                if (this.pij != null) {
                    this.pij.d();
                    this.pij = null;
                }
                if (this.piy != null) {
                    this.piy.dispose();
                    this.piy = new io.reactivex.disposables.a();
                }
                a(oVar.e, false);
                return;
            }
            boolean z = this.R != null && this.R.equals("1");
            this.R = "1";
            this.pit.a();
            this.pis.a();
            this.pir.a();
            this.piq.c();
            this.piv.a();
            if (this.piy != null) {
                this.piy.dispose();
                this.piy = new io.reactivex.disposables.a();
            }
            if ("1".equals(oVar.f)) {
                this.H = false;
                if (this.phY != null && !h.isEmpty(this.phY.t)) {
                    this.phY.t.clear();
                }
                this.ab = oVar.phz.mCover;
                this.pip.setVisibility(0);
                this.pio.setBlur(true);
                this.pio.i(oVar.phz.mCover, 0, 0, 0);
            }
            if (!oVar.phz.mTargetKey.equals(this.P)) {
                this.aq = oVar.g;
                if (!z) {
                    this.B = false;
                    r();
                } else if (!"2".equals(this.piw) && ("2".equals(this.aq) || "3".equals(this.aq) || "4".equals(this.aq))) {
                    this.piw = "2";
                    this.pix = new com.kascend.chushou.player.feedback.a();
                    if (this.pix.pqQ != null) {
                        this.pix.pqQ.reset();
                        this.pix.pqQ.roomId = oVar.phz.mTargetKey;
                        this.pix.pqQ.enterType = 1;
                        this.pix.b = System.currentTimeMillis();
                    }
                }
                this.B = false;
                this.P = oVar.phz.mTargetKey;
                this.Q = this.P;
                this.ab = oVar.phz.mCover;
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
                JSONObject O = com.kascend.chushou.d.e.O("_fromView", str, "_sc", oVar.phz.mSC);
                com.kascend.chushou.toolkit.a.c.a(this.w, O);
                if (this.pib != null) {
                    this.pib.a();
                    this.pib.a(this.P);
                }
                if (this.phY != null) {
                    this.phY.a((PlayUrl) null);
                    this.phY.f();
                    if (this.phY.c() != null) {
                        this.phY.c().clear();
                    }
                    this.phY.i.clear();
                }
                if (this.phW != null) {
                    this.phW.j();
                }
                a(O.toString(), false);
                return;
            }
            tv.chushou.zues.utils.g.Sc(a.i.str_same_room);
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
            euJ = this.phY.euJ();
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
                    if (this.phW != null) {
                        this.phW.f();
                    }
                }
            } else if (iVar.f4073a == 46) {
                if ((iVar.b instanceof String) && this.phW != null) {
                    this.phW.c((String) iVar.b);
                }
            } else if (iVar.f4073a == 54) {
                if (iVar.b instanceof String) {
                    this.pir.a((String) iVar.b);
                }
            } else if (iVar.f4073a == 55) {
                if (this.phW != null) {
                    this.phW.O();
                }
            } else if (iVar.f4073a == 56 && this.phW != null) {
                this.phW.P();
            }
        }
    }

    @Subscribe
    public void onRefreshSubscribeEvent(m mVar) {
        if (isFinishing() && this.phY != null && this.phY.euL() != null) {
            RoomInfo euL = this.phY.euL();
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
        if (this.m || this.phT == null || this.phU == null) {
            R();
        }
        if (this.pib != null) {
            this.pib.d();
        }
        if (!eum()) {
            if (this.pij != null && !this.pij.c()) {
                this.pij.a();
            }
            v();
            if (this.phY != null && this.phY.euJ() != null && this.phY.euJ().cycleLiveRoomInfo != null && !h.isEmpty(this.phY.euJ().cycleLiveRoomInfo.roomId)) {
                u();
            }
        }
        super.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.view.base.BaseActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        tv.chushou.zues.utils.e.e(this.v, MissionEvent.MESSAGE_DESTROY);
        if (this.phY != null && this.phY.euJ() != null && this.phY.euJ().cycleLiveRoomInfo != null && !h.isEmpty(this.phY.euJ().cycleLiveRoomInfo.eventName)) {
            j.eue().a(this.P + euw());
        }
        if ("2".equals(this.piw) && this.pix != null && this.pix.pqQ != null) {
            this.pix.pqQ.time = System.currentTimeMillis() - this.pix.b;
            this.pix.a();
            this.pix.b();
        }
        this.piq.d();
        this.pir.b();
        this.pis.b();
        O();
        this.ag = null;
        f4089a = null;
        if (this.piB != null) {
            this.piB.cs(null);
            this.piB = null;
        }
        if (this.pij != null) {
            this.pij.d();
            this.pij = null;
        }
        if (this.pib != null) {
            this.pib.c();
            this.pib = null;
        }
        if (this.phY != null) {
            this.phY.pjD = null;
            this.phY.pjC = null;
        }
        if (this.phY != null) {
            this.phY.b();
            this.phY = null;
        }
        this.phR = null;
        this.phW = null;
        this.phX = null;
        this.phZ = null;
        this.T = null;
        this.U = null;
        this.pia = null;
        this.cfX = null;
        this.pie = null;
        this.pif = null;
        this.pig = null;
        this.pih = null;
        this.pii = null;
        if (this.pim != null && this.pim.isHeld()) {
            this.pim.release();
            this.pim = null;
        }
        if (this.piA != null) {
            unregisterReceiver(this.piA);
            this.piA = null;
        }
        h.eHS();
        tv.chushou.zues.a.a.ct(this);
        this.piy.dispose();
        this.pis.b();
        this.pit.b();
        this.piq.d();
        this.pir.b();
        this.piv.b();
        super.onDestroy();
        System.gc();
    }

    @Subscribe
    public void onSendGameGiftEvent(n nVar) {
        if (!isFinishing() && this.phW != null) {
            this.phW.a(nVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.view.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        tv.chushou.zues.utils.e.d(this.v, MissionEvent.MESSAGE_PAUSE);
        if (this.pij != null) {
            this.pij.b();
        }
        if (this.pib != null) {
            this.pib.b(false);
        }
        k();
        this.m = true;
        super.onPause();
    }

    @Override // android.app.Activity
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.phW != null ? this.phW.a(motionEvent) : super.onTouchEvent(motionEvent);
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
        if (this.phT != null) {
            this.phT.setHardwearDecod(com.kascend.chushou.d.h.etY().f4087a);
        }
        if (this.phU != null) {
            this.phU.setHardwearDecod(com.kascend.chushou.d.h.etY().f4087a);
        }
        if (this.phS != null) {
            this.phS.setHardwearDecod(com.kascend.chushou.d.h.etY().f4087a);
        }
        if (!this.K) {
            if (z && this.phW != null) {
                if (!z2) {
                    this.t = null;
                    this.phW.e();
                }
            } else if (this.phW != null && !z2) {
                this.t = null;
                this.phW.H = false;
                RxExecutor.post(null, EventThread.MAIN_THREAD, new Runnable() { // from class: com.kascend.chushou.player.VideoPlayer.7
                    @Override // java.lang.Runnable
                    public void run() {
                        VideoPlayer.this.phW.x();
                    }
                });
            }
            this.K = true;
            if (this.phY != null && this.phY.euK() != null) {
                PlayUrl euK = this.phY.euK();
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
                    this.phT.setVideoURI(this.phR);
                    this.phT.open();
                    return;
                }
                this.phU.setVideoURI(this.phR);
                this.phU.open();
                return;
            }
            this.phS.setVideoURI(this.phR);
            this.phS.open();
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        try {
            if (motionEvent.getAction() == 0) {
                if (this.phW != null && this.phW.b(motionEvent)) {
                    return true;
                }
                if ("2".equals(this.piw) && this.phW != null) {
                    this.phW.a(motionEvent);
                }
            } else if (this.phW != null && this.phW.b(motionEvent)) {
                return true;
            }
            return super.dispatchTouchEvent(motionEvent);
        } catch (Exception e) {
            return false;
        }
    }

    @Override // android.support.v7.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.phW != null && this.phW.a(i, keyEvent)) {
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
        if (this.phY != null && this.phY.euJ() != null && this.phY.euJ().cycleLiveRoomInfo != null && !h.isEmpty(this.phY.euJ().cycleLiveRoomInfo.roomId)) {
            this.pip.setVisibility(0);
            this.pio.setBlur(true);
            this.pio.i(this.phY.euJ().cycleLiveRoomInfo.avatar, 0, 0, 0);
            this.pio.setVisibility(0);
            j.eue().a(this.P + euw());
            this.phR = null;
            R();
            this.Q = this.phY.euJ().cycleLiveRoomInfo.roomId;
            a(this.P, euw(), false);
        }
    }

    public void b(boolean z) {
        if (this.phW != null) {
            this.phW.j(z);
        }
    }

    public void a(boolean z, Uri uri, boolean z2) {
        tv.chushou.zues.utils.e.d(this.v, "loadIfNecessary reload=" + z + " isChangeLines-->" + z2);
        if (this.phT != null && this.phU != null) {
            if (uri != null) {
                this.phR = uri;
            }
            if (z2) {
                this.e = z2;
            }
            this.M = false;
            this.N = 0L;
            this.O = 0;
            this.piB.removeMessages(7);
            if (z) {
                if (z2) {
                    if (!this.d) {
                        this.phU.setOnActivityCallBack(this.piF);
                    } else {
                        this.phT.setOnActivityCallBack(this.piE);
                    }
                } else if (this.d) {
                    this.phU.setOnActivityCallBack(this.piF);
                } else {
                    this.phT.setOnActivityCallBack(this.piE);
                }
                this.K = false;
                b(true, z2);
            } else if (!this.J) {
                b(true, z2);
            }
            this.piB.D(6, IMConnection.RETRY_DELAY_TIMES);
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
        return this.phS;
    }

    public tv.chushou.common.player.a eui() {
        return this.phT;
    }

    public tv.chushou.common.player.a euj() {
        return this.phU;
    }

    public void a(tv.chushou.common.player.a aVar) {
        this.phS = aVar;
    }

    public b euk() {
        return this.phY;
    }

    public com.kascend.chushou.widget.a.b eul() {
        return this.pib;
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
        if (eum() && this.phS != null && this.phS.getPlayState() == 4) {
            this.r = this.phS.getCurrentPos();
        }
        this.piC = false;
        tv.chushou.zues.utils.e.d(this.v, "screenChange()<-----");
        tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard(this);
        if (str != null) {
            this.R = str;
        }
        if (!this.C || !z3 || "3".equals(this.R) || this.phY == null || (euJ = this.phY.euJ()) == null || euJ.mRoominfo == null || euJ.mRoominfo.mStyle != 1) {
            z5 = false;
        } else {
            z5 = true;
            i = 0;
        }
        if ("2".equals(this.piw)) {
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
            ((VideoPlayer) this.w).AD(false);
            ((VideoPlayer) this.w).g(true);
            if (z5) {
                setRequestedOrientation(1);
            } else {
                setRequestedOrientation(6);
            }
            getWindow().addFlags(512);
            getWindow().addFlags(256);
        }
        if (this.pib == null) {
            this.pib = new com.kascend.chushou.widget.a.b();
        }
        if (this.pib != null) {
            this.pib.a(this.P);
        }
        if (this.R.equals("5")) {
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            if (this.phW != null) {
                beginTransaction.remove(this.phW);
                this.phW = null;
            }
            if (this.phX != null) {
                beginTransaction.remove(this.phX);
                this.phX = null;
            }
            this.phX = new com.kascend.chushou.view.user.b();
            beginTransaction.add(a.f.fl_fragment, this.phX);
            beginTransaction.commitAllowingStateLoss();
        } else {
            FragmentTransaction beginTransaction2 = getSupportFragmentManager().beginTransaction();
            if (this.phW != null) {
                beginTransaction2.remove(this.phW);
                this.phW = null;
            }
            if (this.phX != null) {
                beginTransaction2.remove(this.phX);
                this.phX = null;
            }
            if ("2".equals(this.piw)) {
                this.phW = com.kascend.chushou.player.e.e.b(this.ab, z2, this.aq, this.P);
            } else if (1 == i) {
                if (!this.R.equals("3")) {
                    if (z4) {
                        v();
                    }
                    this.phW = new com.kascend.chushou.player.d.a();
                    Bundle bundle = new Bundle();
                    bundle.putString("mCover", this.ab);
                    bundle.putBoolean("mInitViewAsync", z2);
                    this.phW.setArguments(bundle);
                }
            } else {
                this.phW = new com.kascend.chushou.player.d.b();
                Bundle bundle2 = new Bundle();
                if (z5) {
                    i = 1;
                }
                bundle2.putInt("mExtraOrientation", i);
                bundle2.putString("mViewType", this.R);
                this.phW.setArguments(bundle2);
            }
            beginTransaction2.add(a.f.fl_fragment, this.phW);
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
        if (this.phW != null) {
            this.phW.pmW = null;
        }
        if (this.phS != null) {
            this.phS.release();
            this.phS = null;
            this.K = false;
        }
        if (this.phT != null) {
            this.phT.release();
            this.phT = null;
        }
        if (this.phU != null) {
            this.phU.release();
            this.phU = null;
        }
        if (this.phV != null) {
            this.phV.c();
        }
        this.d = false;
        this.e = false;
        this.M = false;
        this.phV = new c();
        this.phT = this.phV.euO();
        this.phT.setOnActivityCallBack(this.piE);
        this.phU = this.phV.euP();
        this.phU.setOnActivityCallBack(this.piF);
        if (!this.d) {
            this.phS = this.phT;
        } else {
            this.phS = this.phU;
        }
        if (this.phW != null) {
            this.phW.pmW = this.phS;
        }
    }

    public void j() {
        if (this.phS != null) {
            this.phS.pause();
            this.phS.stop();
            this.phS.release();
            this.phS = null;
        }
        if (this.phT != null) {
            this.phT.stop();
            this.phT.release();
            this.phT = null;
        }
        if (this.phU != null) {
            this.phU.stop();
            this.phU.release();
            this.phU = null;
        }
        if (this.phV != null) {
            this.phV.c();
        }
    }

    public void k() {
        tv.chushou.common.player.a aVar = this.phS;
        if (aVar != null) {
            aVar.pause();
            aVar.stop();
        }
        tv.chushou.common.player.a aVar2 = this.phT;
        if (aVar2 != null) {
            aVar2.stop();
        }
        tv.chushou.common.player.a aVar3 = this.phU;
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
        if (this.piC) {
            if (this.phW != null) {
                this.phW.s();
            }
        } else if (this.piB != null) {
            this.piB.b(this.piB.RV(3), 20L);
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
                    ParserRet w = com.kascend.chushou.c.f.w(str, jSONObject);
                    if (w.mRc != 0 || w.mData == null) {
                        VideoPlayer.this.b(w.mMessage, w.mRc);
                        return;
                    }
                    FullRoomInfo fullRoomInfo = (FullRoomInfo) w.mData;
                    VideoPlayer.this.euu().a(fullRoomInfo.mBangMap);
                    if (h.isEmpty(fullRoomInfo.mRoominfo.mRoomID)) {
                        fullRoomInfo.mRoominfo.mRoomID = VideoPlayer.this.P;
                    }
                    if (!h.isEmpty(fullRoomInfo.mGeneralTabGifts)) {
                        com.kascend.chushou.d.e.a(VideoPlayer.this.piy, new ArrayList(fullRoomInfo.mGeneralTabGifts));
                    }
                    if (VideoPlayer.this.phY != null) {
                        VideoPlayer.this.phY.a(fullRoomInfo);
                    }
                    VideoPlayer.this.L = false;
                    if (VideoPlayer.this.B) {
                        if (VideoPlayer.this.C && !"3".equals(VideoPlayer.this.R) && fullRoomInfo != null && fullRoomInfo.mRoominfo != null && fullRoomInfo.mRoominfo.mStyle == 1 && !h.isEmpty(fullRoomInfo.mRoominfo.mGameId)) {
                            z = true;
                        }
                        if (!z) {
                            if (VideoPlayer.this.phW != null) {
                                VideoPlayer.this.phW.a(VideoPlayer.this.phY);
                            }
                            if (!h.isEmpty(fullRoomInfo.mRoominfo.mGameId)) {
                                VideoPlayer.this.S();
                            } else {
                                if (VideoPlayer.this.phY != null) {
                                    VideoPlayer.this.phY.f = null;
                                }
                                VideoPlayer.this.S();
                            }
                        } else {
                            VideoPlayer.this.a(1, "1", true);
                            if (VideoPlayer.this.phW != null) {
                                VideoPlayer.this.phW.a(VideoPlayer.this.phY);
                            }
                        }
                    } else {
                        if (h.isEmpty(fullRoomInfo.mRoominfo.mGameId)) {
                            if (VideoPlayer.this.phY != null) {
                                VideoPlayer.this.phY.f = null;
                            }
                            VideoPlayer.this.a(1, "1");
                        } else {
                            VideoPlayer.this.a(1, "1", true);
                        }
                        if (VideoPlayer.this.phW != null) {
                            VideoPlayer.this.phW.a(VideoPlayer.this.phY);
                        }
                    }
                    if (VideoPlayer.this.phY != null && !VideoPlayer.this.phY.m()) {
                        if (VideoPlayer.this.pij != null) {
                            VideoPlayer.this.pij.d();
                            VideoPlayer.this.pij = null;
                        }
                        VideoPlayer.this.pij = new com.kascend.chushou.toolkit.d(900000L, VideoPlayer.this.pil, VideoPlayer.this.piB);
                        VideoPlayer.this.pij.a();
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
        if (this.phY != null) {
            this.phY.a((FullRoomInfo) null);
        }
        this.L = false;
        bY(str, i);
        if (this.phS != null) {
            this.phS.stop();
        }
        if (this.phT != null) {
            this.phT.stop();
        }
        if (this.phU != null) {
            this.phU.stop();
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
            com.kascend.chushou.player.c.a.euQ().a(str, str2, new a.InterfaceC0993a() { // from class: com.kascend.chushou.player.VideoPlayer.9
                @Override // com.kascend.chushou.player.c.a.InterfaceC0993a
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
            com.kascend.chushou.player.c.a.euQ().a(str, new a.InterfaceC0993a() { // from class: com.kascend.chushou.player.VideoPlayer.10
                @Override // com.kascend.chushou.player.c.a.InterfaceC0993a
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
                if (this.phY.f == null) {
                    this.phY.f = new ArrayList<>();
                }
                this.phY.f.clear();
                this.phY.f.addAll(arrayList);
                if ("1".equals(this.R)) {
                    j.eue().a(str + euw(), arrayList);
                } else {
                    j.eue().s(str, arrayList);
                }
                a(arrayList);
                return;
            }
            if (this.phY != null) {
                this.phY.f = null;
            }
            if (this.piB != null) {
                Message RV = this.piB.RV(5);
                RV.arg1 = 2;
                RV.arg2 = parserRet.mRc;
                this.piB.X(RV);
            }
        }
    }

    private void bY(String str, int i) {
        s();
        if (this.pib != null) {
            this.pib.a();
        }
        if (h.isEmpty(str)) {
            str = getString(a.i.str_load_data_failed);
        }
        a(str, i);
    }

    public void n() {
        if (this.pig != null && this.cfX != null && this.pii != null) {
            this.pig.setVisibility(0);
            this.cfX.setVisibility(8);
            this.pii.setVisibility(8);
        }
    }

    public void o() {
        if (this.pio != null && this.pio.getVisibility() == 0) {
            this.pio.DX(0);
            this.pio.setVisibility(8);
        }
    }

    public void p() {
        if (this.pip != null && this.pip.getVisibility() == 0) {
            this.pip.setVisibility(8);
        }
    }

    public void q() {
        this.piC = true;
    }

    protected void r() {
        this.pig.setVisibility(8);
        this.pii.setVisibility(0);
        this.cfX.setVisibility(0);
        if (this.pia != null) {
            this.T.setVisibility(8);
            this.pia.setVisibility(0);
            this.U.setText(getString(a.i.str_dialog_loading_content));
            this.U.setVisibility(8);
        }
    }

    protected void a(String str, int i) {
        this.pig.setVisibility(8);
        this.pii.setVisibility(0);
        this.cfX.setVisibility(0);
        if (this.pia != null) {
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
                            }, VideoPlayer.this.P, (String) null, VideoPlayer.this.phY.h);
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
            this.pia.setVisibility(8);
            this.pip.setVisibility(8);
        }
    }

    public void s() {
        if (this.piB != null) {
            this.piB.removeMessages(1);
        }
    }

    private void a(ArrayList<PlayUrl> arrayList) {
        boolean z;
        if (this.phY.f == null) {
            this.phY.f = new ArrayList<>();
        }
        this.phY.f.clear();
        this.phY.f.addAll(arrayList);
        if (com.kascend.chushou.d.e.b() && !"4".equals(this.aq)) {
            int c = com.kascend.chushou.d.e.c();
            if (c == -1) {
                b(arrayList);
                return;
            } else if (this.aw) {
                this.aw = false;
                if (c == 0) {
                    this.phY.d = false;
                    g(arrayList, true);
                    return;
                }
                if (this.phY != null && this.phY.f != null) {
                    Iterator<PlayUrl> it = this.phY.f.iterator();
                    while (it.hasNext()) {
                        if ("2".equals(it.next().mType)) {
                            z = true;
                            break;
                        }
                    }
                }
                z = false;
                this.phY.d = z;
                g(arrayList, true);
                return;
            } else {
                if (this.phY.e) {
                    this.phY.d = !this.phY.d;
                    this.phY.e = false;
                    this.piD = true;
                } else if ("4".equals(this.aq)) {
                    this.phY.d = true;
                }
                g(arrayList, true);
                return;
            }
        }
        if (this.phY.e) {
            this.phY.d = !this.phY.d;
            this.phY.e = false;
            this.piD = true;
        } else if ("4".equals(this.aq)) {
            this.phY.d = true;
        }
        g(arrayList, true);
    }

    private void b(ArrayList<PlayUrl> arrayList) {
        if ("1".equals(this.R)) {
            if ("2".equals(this.piw)) {
                d(false, arrayList);
            } else if (this.phW != null) {
                this.phW.g(arrayList, false);
            }
        } else if (this.phW != null) {
            this.phW.g(arrayList, false);
        }
    }

    public void c(boolean z) {
        this.phY.d = false;
        com.kascend.chushou.d.e.a(0);
        ArrayList<PlayUrl> arrayList = this.phY.f;
        if (!h.isEmpty(arrayList)) {
            if (z) {
                g(arrayList, false);
                if (this.piB != null) {
                    this.piB.RT(2);
                    return;
                }
                return;
            }
            g(arrayList, true);
        }
    }

    public void d(boolean z) {
        this.phY.d = true;
        com.kascend.chushou.d.e.a(1);
        ArrayList<PlayUrl> arrayList = this.phY.f;
        if (!h.isEmpty(arrayList)) {
            if (z) {
                g(arrayList, false);
                if (this.piB != null) {
                    this.piB.RT(2);
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
                    if (this.phW != null) {
                        this.phW.e(false);
                    }
                    if ("1".equals(this.R)) {
                        if ("2".equals(this.piw)) {
                            d(true, null);
                            return;
                        } else if (this.phW != null) {
                            this.phW.g(this.phY.f, true);
                            return;
                        } else {
                            return;
                        }
                    } else if (this.phW != null) {
                        this.phW.g(this.phY.f, true);
                        return;
                    } else {
                        return;
                    }
                }
                RxExecutor.postDelayed(this.piy, EventThread.MAIN_THREAD, 10L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.VideoPlayer.12
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!VideoPlayer.this.isFinishing() && com.kascend.chushou.b.etQ().b && !com.kascend.chushou.b.etQ().f4066a) {
                            tv.chushou.zues.utils.g.d(VideoPlayer.this.w, VideoPlayer.this.getString(a.i.str_monet_notify));
                        }
                    }
                });
            } else if (com.kascend.chushou.b.etQ().f4066a || com.kascend.chushou.b.etQ().b) {
                t();
                if (this.piB != null) {
                    this.piB.RT(2);
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
            if (this.phY.d) {
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
            if (this.phY.d) {
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
                if (this.phY != null) {
                    this.phY.a(playUrl2);
                    if (this.piB != null) {
                        Message RV = this.piB.RV(5);
                        RV.arg1 = 1;
                        this.piB.X(RV);
                    }
                }
                String b = com.kascend.chushou.player.c.a.b(playUrl2);
                if (!h.isEmpty(b)) {
                    this.phR = Uri.parse(b);
                    if (this.piD) {
                        this.piD = false;
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (z && this.phS != null) {
                        a(false, z2);
                    }
                }
            }
        }
    }

    public void d(final boolean z, ArrayList<PlayUrl> arrayList) {
        if (this.pik == null || this.pik.f4226a <= 0) {
            this.pik = com.kascend.chushou.view.b.a.a.ewh();
            this.pik.a(new a.InterfaceC1012a() { // from class: com.kascend.chushou.player.VideoPlayer.13
                @Override // com.kascend.chushou.view.b.a.a.InterfaceC1012a
                public void a(int i) {
                    if (i == a.f.tv_play_video) {
                        VideoPlayer.this.pik.dismissAllowingStateLoss();
                        VideoPlayer.this.c(z);
                    } else if (i == a.f.tv_play_audio) {
                        VideoPlayer.this.pik.dismissAllowingStateLoss();
                        VideoPlayer.this.d(z);
                    } else if (i == a.f.iv_close) {
                        VideoPlayer.this.finish();
                    } else {
                        if (i == a.f.tv_union_proxy) {
                        }
                    }
                }
            });
            this.pik.show(getSupportFragmentManager(), "showRoom");
        }
    }

    public void t() {
        if (this.pik != null) {
            this.pik.dismissAllowingStateLoss();
        }
        if (this.phW != null) {
            this.phW.v();
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
                    ParserRet eM = com.kascend.chushou.c.e.eM(jSONObject);
                    if (eM.mRc == 0 && eM.mData != null) {
                        CycleLiveRoomInfo cycleLiveRoomInfo = (CycleLiveRoomInfo) eM.mData;
                        if (VideoPlayer.this.phY != null && cycleLiveRoomInfo != null && !h.isEmpty(cycleLiveRoomInfo.roomId)) {
                            FullRoomInfo euJ = VideoPlayer.this.phY.euJ();
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
        if (this.phW != null) {
            this.phW.N();
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
                    ParserRet eN = com.kascend.chushou.c.e.eN(jSONObject);
                    if (eN.mRc == 0 && eN.mData != null) {
                        PkNotifyInfo pkNotifyInfo = (PkNotifyInfo) eN.mData;
                        VideoPlayer.this.piu.b = VideoPlayer.this.P;
                        if (pkNotifyInfo != null) {
                            VideoPlayer.this.piu.pmX = pkNotifyInfo;
                            if (VideoPlayer.this.phW != null) {
                                VideoPlayer.this.phW.a(pkNotifyInfo, VideoPlayer.this.P);
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
        if (this.phZ != null) {
            this.phZ.release();
            this.phZ = null;
        }
        com.kascend.chushou.c.c.etT().a(this.P, new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.VideoPlayer.18
            @Override // com.kascend.chushou.c.b
            public void a() {
            }

            @Override // com.kascend.chushou.c.b
            public void a(String str, JSONObject jSONObject) {
                if (!VideoPlayer.this.isFinishing()) {
                    ParserRet eO = com.kascend.chushou.c.e.eO(jSONObject);
                    if (eO.mRc == 0 && eO.mData != null) {
                        RoomExpandInfo roomExpandInfo = (RoomExpandInfo) eO.mData;
                        if (VideoPlayer.this.phY != null) {
                            VideoPlayer.this.phY.pjE = roomExpandInfo.mTopWebAdItem;
                            if (VideoPlayer.this.phY.pjK == null) {
                                VideoPlayer.this.phY.pjK = new ArrayList();
                            }
                            VideoPlayer.this.phY.pjK.clear();
                            VideoPlayer.this.phY.pjK.addAll(roomExpandInfo.mGiftTopRightIcons);
                            tv.chushou.zues.a.a.post(new i(50, VideoPlayer.this.phY.pjE));
                        }
                        if (VideoPlayer.this.phY != null) {
                            VideoPlayer.this.phY.gF(roomExpandInfo.mExpandNavList);
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
                            VideoPlayer.this.piq.a(list);
                        }
                        List<com.kascend.chushou.player.ui.h5.c.c> list2 = roomExpandInfo.mLuckList;
                        if (!h.isEmpty(list2)) {
                            VideoPlayer.this.pir.a(list2);
                        }
                        com.kascend.chushou.player.ui.h5.c.c cVar = roomExpandInfo.mVoteItem;
                        if (cVar != null) {
                            VideoPlayer.this.pis.a(cVar);
                        }
                        List<com.kascend.chushou.player.ui.h5.c.b> list3 = roomExpandInfo.mInteractH5Item;
                        if (!h.isEmpty(list3)) {
                            VideoPlayer.this.piv.a(list3);
                        }
                        List<com.kascend.chushou.player.ui.h5.c.b> list4 = roomExpandInfo.mInteractNavItem;
                        if (!h.isEmpty(list4)) {
                            VideoPlayer.this.piv.a(list4);
                        }
                        VideoPlayer.this.phZ = (PrivilegeInfo) eO.mData1;
                        if (VideoPlayer.this.phZ != null) {
                            tv.chushou.zues.a.a.post(new l());
                        }
                        if (VideoPlayer.this.phY != null) {
                            VideoPlayer.this.phY.pjL = roomExpandInfo.mIconConfig;
                            VideoPlayer.this.euu().a(roomExpandInfo.mIconConfig.bangConfig);
                        }
                        List<SkinConfig> list5 = roomExpandInfo.skinConfig;
                        if (list5 != null && VideoPlayer.this.phY != null) {
                            VideoPlayer.this.phY.pjO.clear();
                            int i = 0;
                            while (true) {
                                int i2 = i;
                                if (i2 >= list5.size()) {
                                    break;
                                }
                                SkinConfig skinConfig = list5.get(i2);
                                VideoPlayer.this.phY.pjO.put(skinConfig.position, skinConfig.resource);
                                i = i2 + 1;
                            }
                            VideoPlayer.this.C();
                        }
                        VideoPlayer.this.a(roomExpandInfo.mIconConfig, VideoPlayer.this.phY != null ? VideoPlayer.this.phY.pjO : null);
                        if (roomExpandInfo.mColorMap != null && roomExpandInfo.mColorMap.size() > 0 && com.kascend.chushou.b.etQ().c != null && com.kascend.chushou.b.etQ().c.size() <= 0) {
                            com.kascend.chushou.b.etQ().c.putAll(roomExpandInfo.mColorMap);
                            tv.chushou.zues.a.a.post(new i(52, null));
                        }
                        AutoBang autoBang = roomExpandInfo.mAutoBang;
                        if (autoBang != null && autoBang.currentTime != 0 && autoBang.bangTime != 0) {
                            VideoPlayer.this.euu().a(autoBang);
                        }
                        if (!h.isEmpty(roomExpandInfo.mRelatedRoomList) && VideoPlayer.this.phY != null) {
                            VideoPlayer.this.phY.t = roomExpandInfo.mRelatedRoomList;
                            if (VideoPlayer.this.phW != null && VideoPlayer.this.H) {
                                VideoPlayer.this.phW.w();
                            }
                        }
                        if (roomExpandInfo.mRoomNewUserInfo != null && roomExpandInfo.mRoomNewUserInfo.mBarrierNoviceGuide && !com.kascend.chushou.d.h.etY().k() && VideoPlayer.this.phW != null) {
                            VideoPlayer.this.phW.J();
                        }
                        if (roomExpandInfo.mRoomNewUserInfo != null && roomExpandInfo.mRoomNewUserInfo.mRewardNoviceGuide && !com.kascend.chushou.d.h.etY().l() && VideoPlayer.this.phW != null) {
                            VideoPlayer.this.phW.K();
                        }
                        if (!h.isEmpty(roomExpandInfo.mShopWindowInfos)) {
                            if (VideoPlayer.this.phY != null) {
                                if (VideoPlayer.this.phY.pjM == null) {
                                    VideoPlayer.this.phY.pjM = new ArrayList();
                                }
                                VideoPlayer.this.phY.pjM.addAll(roomExpandInfo.mShopWindowInfos);
                            }
                            if (VideoPlayer.this.phW != null) {
                                VideoPlayer.this.phW.L();
                            }
                        }
                        VideoPlayer.this.piu.b = VideoPlayer.this.P;
                        if (roomExpandInfo.mPkNotifyInfo != null) {
                            VideoPlayer.this.piu.pmX = roomExpandInfo.mPkNotifyInfo;
                            if (VideoPlayer.this.phW != null) {
                                VideoPlayer.this.phW.a(roomExpandInfo.mPkNotifyInfo, VideoPlayer.this.P);
                            }
                        } else {
                            VideoPlayer.this.piu.pmX = null;
                        }
                        if (roomExpandInfo.mTrumpetPocket != null && VideoPlayer.this.phY != null) {
                            VideoPlayer.this.phY.pjN = roomExpandInfo.mTrumpetPocket;
                            if (VideoPlayer.this.phW != null) {
                                VideoPlayer.this.phW.M();
                            }
                        }
                        if (!h.isEmpty(roomExpandInfo.hotwordContentList)) {
                            if (VideoPlayer.this.phY != null) {
                                if (VideoPlayer.this.phY.w == null) {
                                    VideoPlayer.this.phY.w = new ArrayList();
                                }
                                VideoPlayer.this.phY.w.clear();
                                VideoPlayer.this.phY.w.addAll(roomExpandInfo.hotwordContentList);
                            }
                            if (VideoPlayer.this.phW != null) {
                                VideoPlayer.this.phW.b(roomExpandInfo.hotwordContentList);
                            }
                        }
                        VideoPlayer.this.U();
                        return;
                    }
                    a(eO.mRc, eO.mMessage);
                }
            }

            @Override // com.kascend.chushou.c.b
            public void a(int i, String str) {
                tv.chushou.zues.utils.e.e(VideoPlayer.this.v, "get room gift popup list failed, rc =" + i + ", errorMsg=" + str);
            }
        }, this.ag, this.piw);
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
                        if (VideoPlayer.this.phY != null && list != null) {
                            int i = 0;
                            while (true) {
                                int i2 = i;
                                if (i2 >= list.size()) {
                                    break;
                                }
                                if (list.get(i2).mAdExtraInfo != null) {
                                    if (com.kascend.chushou.a.a.f.equals(list.get(i2).mAdExtraInfo.mCode)) {
                                        VideoPlayer.this.phY.pjD = list.get(i2);
                                    } else if (com.kascend.chushou.a.a.g.equals(list.get(i2).mAdExtraInfo.mCode)) {
                                        VideoPlayer.this.phY.pjC = list.get(i2);
                                    } else if (com.kascend.chushou.a.a.i.equals(list.get(i2).mAdExtraInfo.mCode)) {
                                        VideoPlayer.this.phY.pjF = list.get(i2);
                                    } else if (com.kascend.chushou.a.a.h.equals(list.get(i2).mAdExtraInfo.mCode)) {
                                        VideoPlayer.this.phY.pjG = list.get(i2);
                                    } else if (com.kascend.chushou.a.a.j.equals(list.get(i2).mAdExtraInfo.mCode)) {
                                        VideoPlayer.this.phY.pjJ = list.get(i2);
                                    } else if (com.kascend.chushou.a.a.l.equals(list.get(i2).mAdExtraInfo.mCode)) {
                                        VideoPlayer.this.phY.pjH = list.get(i2);
                                    } else if (com.kascend.chushou.a.a.m.equals(list.get(i2).mAdExtraInfo.mCode)) {
                                        VideoPlayer.this.phY.pjI = list.get(i2);
                                    }
                                }
                                i = i2 + 1;
                            }
                            if (VideoPlayer.this.phW != null) {
                                VideoPlayer.this.phW.H();
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
                this.pif.setSystemUiVisibility(i);
                return;
            }
            this.pif.setSystemUiVisibility(1792);
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
        if (this.phW != null) {
            this.phW.a(i, i2, intent);
        }
    }

    public Uri eun() {
        return this.phR;
    }

    @Override // com.kascend.chushou.view.base.BaseActivity
    protected int y() {
        return 0;
    }

    public void AD(boolean z) {
        if (this.pif != null) {
            this.pif.qpO = z;
        }
    }

    public void euo() {
        if (this.pif != null) {
            this.pif.euo();
        }
    }

    public boolean eup() {
        return this.ae;
    }

    public void g(boolean z) {
        this.ae = z;
    }

    public void h(boolean z) {
        if (this.pif != null) {
            this.pif.setIsTranslucentStatus(z);
        }
    }

    public void z() {
        if (this.pif != null) {
            this.pif.eIl();
        }
    }

    @Override // com.kascend.chushou.widget.gifts.RoomSendGiftView.a
    public void A() {
        if (this.pib != null) {
            this.pib.b();
        }
        if (this.phY != null) {
            this.phY.z = true;
        }
    }

    @Override // com.kascend.chushou.widget.gifts.RoomSendGiftView.a
    public void B() {
        if (this.pib != null) {
            this.pib.b();
        }
    }

    public void a(List<ListItem> list) {
        if (this.phW != null) {
            this.phW.a(list);
        }
    }

    public void a(IconConfig iconConfig, Map<String, SkinConfig.SkinRes> map) {
        if (this.phW != null) {
            this.phW.a(iconConfig, map);
        }
    }

    public void C() {
        if (this.phW != null) {
            this.phW.I();
        }
    }

    @Override // com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC1004a
    public void a(int i) {
        if (this.phW != null) {
            this.phW.a(i);
        }
    }

    @Override // com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC1004a
    public void D() {
        if (!isFinishing() && this.phW != null) {
            this.phW.D();
        }
    }

    @Override // com.kascend.chushou.player.ui.h5.b.b.a
    public void a(long j) {
        if (!isFinishing() && this.phW != null) {
            this.phW.a(j);
        }
    }

    @Override // com.kascend.chushou.player.ui.h5.b.b.a
    public void a(com.kascend.chushou.player.ui.h5.c.a aVar) {
        if (aVar != null && this.phW != null) {
            this.phW.a(aVar);
        }
    }

    @Override // com.kascend.chushou.player.ui.h5.b.b.a
    public void b(int i) {
        if (this.phW != null) {
            this.phW.b(i);
        }
    }

    @Override // com.kascend.chushou.player.ui.h5.d.a.InterfaceC1003a
    public void b(long j) {
        if (!isFinishing() && this.phW != null) {
            this.phW.b(j);
        }
    }

    @Override // com.kascend.chushou.player.ui.h5.a.a.InterfaceC1001a
    public void c(int i) {
        if (!isFinishing() && this.phW != null) {
            this.phW.c(i);
        }
    }

    @Override // com.kascend.chushou.player.ui.h5.d.a.InterfaceC1003a
    public void b(com.kascend.chushou.player.ui.h5.c.a aVar) {
        if (aVar != null && this.phW != null) {
            this.phW.b(aVar);
        }
    }

    @Override // com.kascend.chushou.player.ui.a.a.InterfaceC0998a
    public void a(IconConfig.Config config) {
        if (this.phW != null) {
            this.phW.a(config);
        }
    }

    @Override // com.kascend.chushou.player.ui.a.a.InterfaceC0998a
    public void a(BangInfo bangInfo, String str) {
        if (this.phW != null) {
            this.phW.a(bangInfo, str);
        }
    }

    @Override // com.kascend.chushou.player.ui.a.a.InterfaceC0998a
    public void a(long j, BangInfo bangInfo, String str) {
        if (this.phW != null) {
            this.phW.a(j, bangInfo, str);
        }
    }

    public com.kascend.chushou.player.ui.h5.redpacket.a euq() {
        return this.piq;
    }

    public com.kascend.chushou.player.ui.h5.b.b eur() {
        return this.pir;
    }

    public com.kascend.chushou.player.ui.h5.d.a eus() {
        return this.pis;
    }

    public com.kascend.chushou.player.ui.h5.a.a eut() {
        return this.piv;
    }

    public com.kascend.chushou.player.ui.a.a euu() {
        return this.pit;
    }

    public com.kascend.chushou.player.e.a euv() {
        return this.piu;
    }

    @Override // com.kascend.chushou.view.base.BaseActivity, android.app.Activity
    public void finish() {
        super.finish();
        if ("3".equals(this.R)) {
            overridePendingTransition(17432576, a.C0988a.commonres_activity_exit_bottom);
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
        RxExecutor.postDelayed(this.piy, EventThread.MAIN_THREAD, aVar.d, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.VideoPlayer.2
            @Override // java.lang.Runnable
            public void run() {
                if (VideoPlayer.this.phW != null) {
                    VideoPlayer.this.phW.c(aVar);
                }
            }
        });
    }

    private void e(final com.kascend.chushou.player.ui.h5.c.a aVar) {
        if (!com.kascend.chushou.d.h.etY().eub().contains(aVar.b)) {
            if (aVar.d < 0) {
                aVar.d = 0;
            }
            RxExecutor.postDelayed(this.piy, EventThread.MAIN_THREAD, aVar.d, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.VideoPlayer.3
                @Override // java.lang.Runnable
                public void run() {
                    if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.phW != null) {
                        VideoPlayer.this.phW.c(aVar);
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
                if (VideoPlayer.this.pie != null && !VideoPlayer.this.isFinishing()) {
                    VideoPlayer.n = VideoPlayer.this.pie.getStreamVolume(3);
                }
                if (!VideoPlayer.this.isFinishing() && (VideoPlayer.this.phW instanceof f)) {
                    ((f) VideoPlayer.this.phW).ab();
                }
            }
        }
    }

    public String a(String str) {
        HashMap hashMap = new HashMap(tv.chushou.zues.utils.d.aaC(str));
        if ("1".equals(this.R)) {
            hashMap.put("roomId", this.P);
        } else if ("3".equals(this.R)) {
            hashMap.put("videoId", this.P);
        }
        return tv.chushou.zues.utils.d.toJson(hashMap);
    }

    public boolean eux() {
        if (this.phW instanceof com.kascend.chushou.player.d.a) {
            return ((com.kascend.chushou.player.d.a) this.phW).evv();
        }
        if (this.phW instanceof com.kascend.chushou.player.e.e) {
            return true;
        }
        return false;
    }
}

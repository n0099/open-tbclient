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
public class VideoPlayer extends BaseActivity implements a.InterfaceC0907a, a.InterfaceC0910a, b.a, a.InterfaceC0912a, a.InterfaceC0913a, RoomSendGiftView.a {
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
    private FrescoThumbnailView ohB;
    private FrameLayout ohC;
    public com.kascend.chushou.player.feedback.a ohK;
    private a ohM;
    private CSTVWifiReceiver ohN;
    private c ohl;
    b oho;
    public PrivilegeInfo ohp;
    com.kascend.chushou.widget.a.b ohr;
    private KPSwitchRootRelativeLayout oht;
    private FrameLayout ohu;
    private ImageView ohv;
    private LinearLayout ohw;
    private com.kascend.chushou.toolkit.d ohx;
    com.kascend.chushou.view.b.a.a ohy;
    private boolean B = true;
    private boolean C = false;
    private Uri ohh = null;
    private tv.chushou.common.player.a ohi = null;
    public tv.chushou.common.player.a ohj = null;
    public tv.chushou.common.player.a ohk = null;
    public boolean d = false;
    public boolean e = false;
    private e ohm = null;
    private boolean H = false;
    private com.kascend.chushou.view.user.b ohn = null;
    private boolean J = false;
    private boolean K = false;
    private boolean L = false;
    private boolean M = false;
    private long N = 0;
    private int O = 0;
    public boolean g = false;
    private ImageView T = null;
    private TextView U = null;
    private AnimationImageView ohq = null;
    private View bRO = null;
    public boolean j = false;
    public float k = 0.0f;
    public float l = 0.0f;
    public boolean m = false;
    public AudioManager ohs = null;
    private d.a ohz = new d.a() { // from class: com.kascend.chushou.player.VideoPlayer.1
        @Override // com.kascend.chushou.toolkit.d.a
        public void a() {
            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.ohO != null) {
                VideoPlayer.this.ohO.PH(4);
            }
        }
    };
    private boolean ae = false;
    public boolean q = true;
    public long r = -1;
    public long s = -1;
    private PowerManager.WakeLock ohA = null;
    public String t = null;
    private final com.kascend.chushou.player.ui.h5.redpacket.a ohD = new com.kascend.chushou.player.ui.h5.redpacket.a(this);
    private final com.kascend.chushou.player.ui.h5.b.b ohE = new com.kascend.chushou.player.ui.h5.b.b(this);
    private final com.kascend.chushou.player.ui.h5.d.a ohF = new com.kascend.chushou.player.ui.h5.d.a(this);
    private final com.kascend.chushou.player.ui.a.a ohG = new com.kascend.chushou.player.ui.a.a(this);
    private final com.kascend.chushou.player.e.a ohH = new com.kascend.chushou.player.e.a();
    private final com.kascend.chushou.player.ui.h5.a.a ohI = new com.kascend.chushou.player.ui.h5.a.a(this);
    private String ohJ = "1";
    private String aq = "2";
    private io.reactivex.disposables.a ohL = new io.reactivex.disposables.a();
    private tv.chushou.zues.c ohO = new tv.chushou.zues.c(new Handler.Callback() { // from class: com.kascend.chushou.player.VideoPlayer.6
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            try {
                if (!VideoPlayer.this.isFinishing()) {
                    switch (message.what) {
                        case 1:
                            VideoPlayer.this.ohO.removeMessages(1);
                            com.kascend.chushou.c.c.ege().a(VideoPlayer.this.P, VideoPlayer.this.oho != null ? VideoPlayer.this.oho.h : null, System.currentTimeMillis());
                            VideoPlayer.this.ohO.D(1, VideoPlayer.A);
                            break;
                        case 2:
                            VideoPlayer.this.a(true, (Uri) null, false);
                            break;
                        case 3:
                            VideoPlayer.this.S();
                            break;
                        case 4:
                            if (VideoPlayer.this.ohm != null) {
                                VideoPlayer.this.ohm.a(true);
                            }
                            if (VideoPlayer.this.ohx != null) {
                                VideoPlayer.this.ohx.d();
                                VideoPlayer.this.ohx = null;
                                break;
                            }
                            break;
                        case 5:
                            int i = message.arg1;
                            if (i == 1) {
                                if (VideoPlayer.this.ohm != null) {
                                    VideoPlayer.this.ohm.p();
                                    break;
                                }
                            } else if (i == 2 && VideoPlayer.this.ohm != null) {
                                VideoPlayer.this.ohm.e(message.arg2);
                                break;
                            }
                            break;
                        case 6:
                            if (!com.kascend.chushou.b.egb().f4066a && !com.kascend.chushou.b.egb().b && VideoPlayer.this.ohm != null) {
                                VideoPlayer.this.ohm.g(true);
                                break;
                            } else {
                                VideoPlayer.this.c();
                                break;
                            }
                            break;
                        case 7:
                            tv.chushou.zues.utils.e.d(VideoPlayer.this.v, "MSG_BUFFER_DEALY: ");
                            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.ohm != null && VideoPlayer.this.M && !VideoPlayer.this.e) {
                                VideoPlayer.this.ohm.h(true);
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
    private boolean ohP = false;
    private boolean aw = true;
    private boolean ohQ = false;
    private tv.chushou.common.player.b ohR = new tv.chushou.common.player.b() { // from class: com.kascend.chushou.player.VideoPlayer.14
        @Override // tv.chushou.common.player.b
        public void egK() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerACallback onSetVideoViewLayout");
            if (!VideoPlayer.this.isFinishing()) {
                if ((VideoPlayer.this.ohm == null || !VideoPlayer.this.ohm.H) && VideoPlayer.this.ohm != null && !VideoPlayer.this.d) {
                    VideoPlayer.this.ohm.y();
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void Om(int i) {
            if (!VideoPlayer.this.isFinishing()) {
                if ((VideoPlayer.this.ohm == null || !VideoPlayer.this.ohm.H) && VideoPlayer.this.ohm != null && !VideoPlayer.this.d) {
                    VideoPlayer.this.ohm.g(i);
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void egL() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerACallback onCompletePlayback");
            if (!VideoPlayer.this.isFinishing()) {
                if (!h.isEmpty(VideoPlayer.this.P)) {
                    j.egp().a(VideoPlayer.this.P, 0);
                }
                VideoPlayer.this.K = false;
                if (VideoPlayer.this.ohO != null) {
                    VideoPlayer.this.ohO.removeMessages(1);
                }
                if ((VideoPlayer.this.ohm == null || !VideoPlayer.this.ohm.H) && VideoPlayer.this.ohm != null && !VideoPlayer.this.d) {
                    VideoPlayer.this.ohO.removeMessages(7);
                    VideoPlayer.this.M = false;
                    VideoPlayer.this.ohm.z();
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void egM() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerACallback onVideoRenderingStart");
            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.ohm != null) {
                VideoPlayer.this.ohm.G();
            }
        }

        @Override // tv.chushou.common.player.b
        public void egN() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerACallback onPreparedPlayback");
            if (!VideoPlayer.this.isFinishing()) {
                if (VideoPlayer.this.ohm == null || !VideoPlayer.this.ohm.H) {
                    VideoPlayer.this.ohO.removeMessages(6);
                    VideoPlayer.this.N = 0L;
                    VideoPlayer.this.O = 0;
                    if (VideoPlayer.this.ohi != null && VideoPlayer.this.ohm != null) {
                        VideoPlayer.this.ohi.setVolume(VideoPlayer.this.ohm.J, VideoPlayer.this.ohm.J);
                    }
                    if (VideoPlayer.this.oho != null) {
                        VideoPlayer.this.K = false;
                        FullRoomInfo egU = VideoPlayer.this.egx() ? null : VideoPlayer.this.oho.egU();
                        if (VideoPlayer.this.L || egU != null) {
                            if (VideoPlayer.this.oho.e) {
                                VideoPlayer.this.oho.e = false;
                                VideoPlayer.this.oho.d = !VideoPlayer.this.oho.d;
                            }
                            if (VideoPlayer.this.ohm != null) {
                                VideoPlayer.this.c("1", (String) null);
                                if (!VideoPlayer.this.d) {
                                    VideoPlayer.this.ohm.i(true);
                                } else if (VideoPlayer.this.e) {
                                    VideoPlayer.this.e = false;
                                    VideoPlayer.this.ohm.B();
                                }
                            }
                        }
                    }
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void On(int i) {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerACallback onErrorAppeared");
            if (!VideoPlayer.this.isFinishing()) {
                VideoPlayer.this.c();
                VideoPlayer.this.K = false;
                if (VideoPlayer.this.ohO != null) {
                    VideoPlayer.this.ohO.removeMessages(7);
                }
                if (VideoPlayer.this.ohO != null) {
                    VideoPlayer.this.ohO.removeMessages(1);
                }
                if ((VideoPlayer.this.ohm == null || !VideoPlayer.this.ohm.H) && !VideoPlayer.this.egr()) {
                    if (!"10004".equals(VideoPlayer.this.t)) {
                        if (VideoPlayer.this.ohm != null) {
                            if (VideoPlayer.this.d) {
                                VideoPlayer.this.ohj.stop();
                                VideoPlayer.this.ohj.release();
                                VideoPlayer.this.e = false;
                                VideoPlayer.this.ohm.C();
                            }
                            if (!com.kascend.chushou.b.egb().f4066a && !com.kascend.chushou.b.egb().b) {
                                VideoPlayer.this.ohm.g(true);
                            } else if (VideoPlayer.this.d) {
                                VideoPlayer.this.ohm.a(i, true);
                            } else {
                                VideoPlayer.this.ohm.a(i, false);
                            }
                            VideoPlayer.this.c("2", (String) null);
                            return;
                        }
                        return;
                    }
                    egL();
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void egO() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerACallback onBufferingStart");
            if (!VideoPlayer.this.isFinishing()) {
                if ((VideoPlayer.this.ohm == null || !VideoPlayer.this.ohm.H) && VideoPlayer.this.ohm != null && !VideoPlayer.this.d) {
                    VideoPlayer.this.ohm.E();
                    VideoPlayer.this.M = true;
                    long currentTimeMillis = System.currentTimeMillis();
                    VideoPlayer.this.ohO.removeMessages(7);
                    if (!VideoPlayer.this.g) {
                        VideoPlayer.y(VideoPlayer.this);
                    }
                    tv.chushou.zues.utils.e.d(VideoPlayer.this.v, "currentTime: -- >" + currentTimeMillis + "  bufferTime-->" + VideoPlayer.this.N + "  bufferCount-->" + VideoPlayer.this.O);
                    if (currentTimeMillis - VideoPlayer.this.N >= 20000 || VideoPlayer.this.O < 2 || VideoPlayer.this.ohm.H) {
                        if (VideoPlayer.this.O == 1) {
                            VideoPlayer.this.N = currentTimeMillis;
                        }
                        VideoPlayer.this.ohO.D(7, 5000L);
                    } else {
                        VideoPlayer.this.ohO.PH(7);
                    }
                    if (VideoPlayer.this.g) {
                        VideoPlayer.this.g = false;
                    }
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void egP() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerACallback onBufferingEnd");
            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.ohm != null && !VideoPlayer.this.d) {
                VideoPlayer.this.ohO.removeMessages(7);
                VideoPlayer.this.M = false;
                if (VideoPlayer.this.ohm == null || !VideoPlayer.this.ohm.H) {
                    if (VideoPlayer.this.ohi == null) {
                        VideoPlayer.this.ohm.a(false, true, false);
                    } else {
                        VideoPlayer.this.ohm.a(true, VideoPlayer.this.ohi.getPlayState() == 4, VideoPlayer.this.ohi.getPlayState() == 5);
                    }
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void onPlayerStart() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerACallback onPlayerStart");
            if (!VideoPlayer.this.isFinishing()) {
                if (VideoPlayer.this.ohm == null || !VideoPlayer.this.ohm.H) {
                    if (VideoPlayer.this.ohm != null && !VideoPlayer.this.d) {
                        if (VideoPlayer.this.ohi != null) {
                            VideoPlayer.this.ohm.F();
                            VideoPlayer.this.ohm.a(true, VideoPlayer.this.ohi.getPlayState() == 4, VideoPlayer.this.ohi.getPlayState() == 5);
                        } else {
                            VideoPlayer.this.ohm.a(false, true, false);
                        }
                    }
                    if (VideoPlayer.this.ohO != null && !VideoPlayer.this.egx()) {
                        VideoPlayer.this.ohO.removeMessages(1);
                        VideoPlayer.this.ohO.D(1, VideoPlayer.A);
                    }
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void egQ() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerACallback onPlayerPause");
            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.ohO != null) {
                VideoPlayer.this.ohO.removeMessages(1);
            }
        }

        @Override // tv.chushou.common.player.b
        public void egR() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerACallback onPlayerStop");
            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.egx() && VideoPlayer.this.ohj != null && !h.isEmpty(VideoPlayer.this.P) && VideoPlayer.this.ohj.getCurrentPos() > 0) {
                j.egp().a(VideoPlayer.this.P, VideoPlayer.this.ohj.getCurrentPos());
            }
        }
    };
    private tv.chushou.common.player.b ohS = new tv.chushou.common.player.b() { // from class: com.kascend.chushou.player.VideoPlayer.15
        @Override // tv.chushou.common.player.b
        public void egK() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerBCallback onSetVideoViewLayout");
            if (!VideoPlayer.this.isFinishing()) {
                if ((VideoPlayer.this.ohm == null || !VideoPlayer.this.ohm.H) && VideoPlayer.this.ohm != null && VideoPlayer.this.d) {
                    VideoPlayer.this.ohm.y();
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void Om(int i) {
            if (!VideoPlayer.this.isFinishing()) {
                if ((VideoPlayer.this.ohm == null || !VideoPlayer.this.ohm.H) && VideoPlayer.this.ohm != null && VideoPlayer.this.d) {
                    VideoPlayer.this.ohm.g(i);
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void egL() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerBCallback onCompletePlayback");
            if (!VideoPlayer.this.isFinishing()) {
                if (!h.isEmpty(VideoPlayer.this.P)) {
                    j.egp().a(VideoPlayer.this.P, 0);
                }
                VideoPlayer.this.K = false;
                if (VideoPlayer.this.ohO != null) {
                    VideoPlayer.this.ohO.removeMessages(1);
                }
                if ((VideoPlayer.this.ohm == null || !VideoPlayer.this.ohm.H) && VideoPlayer.this.ohm != null && VideoPlayer.this.d) {
                    VideoPlayer.this.ohO.removeMessages(7);
                    VideoPlayer.this.M = false;
                    VideoPlayer.this.ohm.z();
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void egM() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerBCallback onVideoRenderingStart");
            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.ohm != null) {
                VideoPlayer.this.ohm.G();
            }
        }

        @Override // tv.chushou.common.player.b
        public void egN() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerBCallback onPreparedPlayback");
            if (!VideoPlayer.this.isFinishing()) {
                if (VideoPlayer.this.ohm == null || !VideoPlayer.this.ohm.H) {
                    VideoPlayer.this.ohO.removeMessages(6);
                    VideoPlayer.this.N = 0L;
                    VideoPlayer.this.O = 0;
                    if (VideoPlayer.this.ohi != null && VideoPlayer.this.ohm != null) {
                        VideoPlayer.this.ohi.setVolume(VideoPlayer.this.ohm.J, VideoPlayer.this.ohm.J);
                    }
                    if (VideoPlayer.this.oho != null) {
                        VideoPlayer.this.K = false;
                        FullRoomInfo egU = VideoPlayer.this.egx() ? null : VideoPlayer.this.oho.egU();
                        if (VideoPlayer.this.L || egU != null) {
                            if (VideoPlayer.this.oho.e) {
                                VideoPlayer.this.oho.e = false;
                                VideoPlayer.this.oho.d = !VideoPlayer.this.oho.d;
                            }
                            if (VideoPlayer.this.ohm != null) {
                                VideoPlayer.this.c("1", (String) null);
                                if (VideoPlayer.this.d) {
                                    VideoPlayer.this.ohm.i(true);
                                } else if (VideoPlayer.this.e) {
                                    VideoPlayer.this.e = false;
                                    VideoPlayer.this.ohm.B();
                                }
                            }
                        }
                    }
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void On(int i) {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerBCallback onErrorAppeared");
            if (!VideoPlayer.this.isFinishing()) {
                VideoPlayer.this.c();
                VideoPlayer.this.K = false;
                if (VideoPlayer.this.ohO != null) {
                    VideoPlayer.this.ohO.removeMessages(7);
                }
                if (VideoPlayer.this.ohO != null) {
                    VideoPlayer.this.ohO.removeMessages(1);
                }
                if ((VideoPlayer.this.ohm == null || !VideoPlayer.this.ohm.H) && !VideoPlayer.this.egr()) {
                    if (!"10004".equals(VideoPlayer.this.t)) {
                        if (VideoPlayer.this.ohm != null) {
                            if (!VideoPlayer.this.d) {
                                VideoPlayer.this.ohk.stop();
                                VideoPlayer.this.ohk.release();
                                VideoPlayer.this.ohm.C();
                                VideoPlayer.this.e = false;
                            }
                            if (!com.kascend.chushou.b.egb().f4066a && !com.kascend.chushou.b.egb().b) {
                                VideoPlayer.this.ohm.g(true);
                            } else if (VideoPlayer.this.d) {
                                VideoPlayer.this.ohm.a(i, false);
                            } else {
                                VideoPlayer.this.ohm.a(i, true);
                            }
                            VideoPlayer.this.c("2", (String) null);
                            return;
                        }
                        return;
                    }
                    egL();
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void egO() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerBCallback onBufferingStart");
            if (!VideoPlayer.this.isFinishing()) {
                if ((VideoPlayer.this.ohm == null || !VideoPlayer.this.ohm.H) && VideoPlayer.this.ohm != null && VideoPlayer.this.d) {
                    VideoPlayer.this.ohm.E();
                    VideoPlayer.this.M = true;
                    VideoPlayer.this.ohO.removeMessages(7);
                    long currentTimeMillis = System.currentTimeMillis();
                    if (!VideoPlayer.this.g) {
                        VideoPlayer.y(VideoPlayer.this);
                    }
                    tv.chushou.zues.utils.e.d(VideoPlayer.this.v, "currentTime: -- >" + currentTimeMillis + "  bufferTime-->" + VideoPlayer.this.N + "  bufferCount-->" + VideoPlayer.this.O);
                    if (currentTimeMillis - VideoPlayer.this.N >= 20000 || VideoPlayer.this.O < 2 || VideoPlayer.this.ohm.H) {
                        if (VideoPlayer.this.O == 1) {
                            VideoPlayer.this.N = currentTimeMillis;
                        }
                        VideoPlayer.this.ohO.D(7, 5000L);
                    } else {
                        VideoPlayer.this.N = 0L;
                        VideoPlayer.this.O = 0;
                        VideoPlayer.this.ohO.PH(7);
                    }
                    if (VideoPlayer.this.g) {
                        VideoPlayer.this.g = false;
                    }
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void egP() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerBCallback onBufferingEnd");
            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.ohm != null && VideoPlayer.this.d) {
                VideoPlayer.this.M = false;
                VideoPlayer.this.ohO.removeMessages(7);
                if (VideoPlayer.this.ohm == null || !VideoPlayer.this.ohm.H) {
                    if (VideoPlayer.this.ohi == null) {
                        VideoPlayer.this.ohm.a(false, true, false);
                    } else {
                        VideoPlayer.this.ohm.a(true, VideoPlayer.this.ohi.getPlayState() == 4, VideoPlayer.this.ohi.getPlayState() == 5);
                    }
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void onPlayerStart() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerBCallback onPlayerStart");
            if (!VideoPlayer.this.isFinishing()) {
                if (VideoPlayer.this.ohm == null || !VideoPlayer.this.ohm.H) {
                    if (VideoPlayer.this.ohm != null && VideoPlayer.this.d) {
                        if (VideoPlayer.this.ohi != null) {
                            VideoPlayer.this.ohm.F();
                            VideoPlayer.this.ohm.a(true, VideoPlayer.this.ohi.getPlayState() == 4, VideoPlayer.this.ohi.getPlayState() == 5);
                        } else {
                            VideoPlayer.this.ohm.a(false, true, false);
                        }
                    }
                    if (VideoPlayer.this.ohO != null && !VideoPlayer.this.egx()) {
                        VideoPlayer.this.ohO.removeMessages(1);
                        VideoPlayer.this.ohO.D(1, VideoPlayer.A);
                    }
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void egQ() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerBCallback onPlayerPause");
            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.ohO != null) {
                VideoPlayer.this.ohO.removeMessages(1);
            }
        }

        @Override // tv.chushou.common.player.b
        public void egR() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerBCallback onPlayerStop");
            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.egx() && VideoPlayer.this.ohk != null && !h.isEmpty(VideoPlayer.this.P) && VideoPlayer.this.ohk.getCurrentPos() > 0) {
                j.egp().a(VideoPlayer.this.P, VideoPlayer.this.ohk.getCurrentPos());
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
        this.ohh = intent.getData();
        if (this.ohh == null) {
            finish();
            return;
        }
        com.kascend.chushou.d.e.j();
        if (this.ohN == null) {
            this.ohN = new CSTVWifiReceiver();
            registerReceiver(this.ohN, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        }
        com.kascend.chushou.toolkit.d.a.eir().b();
        tv.chushou.zues.utils.e.i(this.v, "intent.getData=" + this.ohh.toString());
        String scheme = this.ohh.getScheme();
        if (scheme == null || !scheme.equals("chushou")) {
            tv.chushou.zues.utils.e.e(this.v, "not support scheme :" + scheme);
            finish();
            return;
        }
        a(intent);
    }

    private void a(Intent intent) {
        this.P = this.ohh.getQueryParameter("roomId");
        this.Q = this.P;
        this.S = this.ohh.getQueryParameter(WebSocketRequest.PARAM_KEY_PROTOCOLS);
        this.aq = this.ohh.getQueryParameter("liveType");
        if ("2".equals(this.aq) || "3".equals(this.aq) || "4".equals(this.aq)) {
            this.ohJ = "2";
            this.ohK = new com.kascend.chushou.player.feedback.a();
            if (this.ohK.oqa != null) {
                this.ohK.oqa.reset();
                this.ohK.oqa.roomId = this.P;
                this.ohK.oqa.enterType = 1;
                this.ohK.b = System.currentTimeMillis();
            }
        }
        if (h.isEmpty(this.P) || h.isEmpty(this.S)) {
            tv.chushou.zues.utils.e.e(this.v, "invalid param mItemID=" + this.P + " protocols=" + this.S);
            finish();
            return;
        }
        if (com.kascend.chushou.b.egb().d == -1) {
            com.kascend.chushou.b.egb().d = com.kascend.chushou.d.g.b() ? 1 : 0;
        }
        this.ohA = ((PowerManager) getSystemService("power")).newWakeLock(536870938, this.v);
        this.ohA.acquire();
        this.oho = new b(this.P);
        this.oho.d = intent.getBooleanExtra("room_play_audio", false);
        this.ohr = new com.kascend.chushou.widget.a.b();
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
        this.oht = (KPSwitchRootRelativeLayout) findViewById(a.f.rlRoot);
        if (!"2".equals(this.ohJ) && com.kascend.chushou.b.egb().d == 1) {
            this.oht.setFitsSystemWindows(true);
        }
        this.ohu = (FrameLayout) this.oht.findViewById(a.f.fl_fragment);
        this.bRO = this.oht.findViewById(a.f.rl_empty);
        this.T = (ImageView) this.bRO.findViewById(a.f.iv_empty);
        this.U = (TextView) this.bRO.findViewById(a.f.tv_empty);
        this.ohw = (LinearLayout) this.oht.findViewById(a.f.rl_title);
        this.ohv = (ImageView) this.ohw.findViewById(a.f.back_icon);
        this.ohv.setOnClickListener(new View.OnClickListener() { // from class: com.kascend.chushou.player.VideoPlayer.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayer.this.finish();
            }
        });
        this.ohq = (AnimationImageView) this.bRO.findViewById(a.f.iv_loading);
        this.ohB = (FrescoThumbnailView) this.oht.findViewById(a.f.live_cover);
        this.ohC = (FrameLayout) this.oht.findViewById(a.f.fl_cover);
        this.k = egq();
        try {
            this.ohs = (AudioManager) getApplicationContext().getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
            n = this.ohs.getStreamVolume(3);
            this.ohs.requestAudioFocus(null, 3, 1);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (this.B) {
            a(1, egx() ? "3" : "1");
        } else {
            r();
        }
        if (com.kascend.chushou.b.egb().b && !com.kascend.chushou.b.egb().f4066a) {
            RxExecutor.postDelayed(this.ohL, EventThread.MAIN_THREAD, 60L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.VideoPlayer.5
                @Override // java.lang.Runnable
                public void run() {
                    if (!VideoPlayer.this.isFinishing() && com.kascend.chushou.b.egb().b && !com.kascend.chushou.b.egb().f4066a) {
                        tv.chushou.zues.utils.g.c(VideoPlayer.this.w, VideoPlayer.this.getString(a.i.str_monet_notify));
                    }
                }
            });
        }
        com.kascend.chushou.c.c.ege().a(this.P, stringExtra, System.currentTimeMillis());
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
        if (this.ohM == null) {
            this.ohM = new a();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(VideoReceiver.ACTION_VOLUME_CHANGED);
            registerReceiver(this.ohM, intentFilter);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        j(false);
        if (this.ohM != null) {
            unregisterReceiver(this.ohM);
            this.ohM = null;
        }
        super.onStop();
    }

    @Override // com.kascend.chushou.view.base.BaseActivity
    protected void a(boolean z) {
        if (this.ohm != null) {
            this.ohm.k(z);
        }
    }

    @Subscribe
    public void onHideGiftEffectEvent(com.kascend.chushou.b.a.a.f fVar) {
        if (fVar.b) {
            this.ohm.k();
            return;
        }
        this.ohm.m();
        this.ohm.l();
    }

    private float egq() {
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
            this.oho.h = jSONObject.toString();
            String optString = jSONObject.optString("_thumb");
            jSONObject.optBoolean("tag_from_game_mic", false);
            if (!h.isEmpty(optString)) {
                this.ab = optString;
            }
        } catch (JSONException e) {
            e.printStackTrace();
            this.oho.h = str;
        }
        if (egx()) {
            a(this.P, str);
            bg(this.P, z);
            return;
        }
        f4089a = this.P;
        b(this.P, str);
        a(this.P, egH(), z);
        w();
    }

    private void O() {
        this.m = true;
        j();
        if (this.ohm != null) {
            this.ohm.r();
        }
        s();
    }

    @Subscribe
    public void onStartRoomEvent(o oVar) {
        if (!isFinishing() && oVar.ogP != null && oVar.c != null && !h.isEmpty(oVar.ogP.mTargetKey)) {
            if (oVar.c != this) {
                tv.chushou.zues.utils.e.e(this.v, "different player!");
                return;
            }
            if (this.oho != null) {
                this.oho.a();
                this.oho.f4119a = oVar.ogP.mTargetKey;
                this.oho.d = oVar.d;
                if (this.oho.oiN != null) {
                    this.oho.oiN.e();
                }
                if (this.oho.oiN != null) {
                    this.oho.oiN.b();
                }
                this.oho.oiQ = null;
                this.oho.oiP = null;
                this.oho.oiT = null;
                this.oho.oiS = null;
                this.oho.oiW = null;
                this.oho.oiU = null;
                this.oho.oiV = null;
            }
            if (this.ohs != null) {
                n = this.ohs.getStreamVolume(3);
            }
            if (!h.isEmpty(oVar.ogP.mType) && oVar.ogP.mType.equals("3")) {
                this.B = false;
                this.ohJ = "1";
                r();
                this.P = oVar.ogP.mTargetKey;
                this.R = "3";
                if (this.ohr != null) {
                    this.ohr.a();
                }
                if (this.oho != null) {
                    this.oho.a((PlayUrl) null);
                    this.oho.f();
                    if (this.oho.c() != null) {
                        this.oho.c().clear();
                    }
                    this.oho.i.clear();
                }
                if (this.ohm != null) {
                    this.ohm.j();
                }
                s();
                if (this.ohx != null) {
                    this.ohx.d();
                    this.ohx = null;
                }
                if (this.ohL != null) {
                    this.ohL.dispose();
                    this.ohL = new io.reactivex.disposables.a();
                }
                a(oVar.e, false);
                return;
            }
            boolean z = this.R != null && this.R.equals("1");
            this.R = "1";
            this.ohG.a();
            this.ohF.a();
            this.ohE.a();
            this.ohD.c();
            this.ohI.a();
            if (this.ohL != null) {
                this.ohL.dispose();
                this.ohL = new io.reactivex.disposables.a();
            }
            if ("1".equals(oVar.f)) {
                this.H = false;
                if (this.oho != null && !h.isEmpty(this.oho.t)) {
                    this.oho.t.clear();
                }
                this.ab = oVar.ogP.mCover;
                this.ohC.setVisibility(0);
                this.ohB.setBlur(true);
                this.ohB.i(oVar.ogP.mCover, 0, 0, 0);
            }
            if (!oVar.ogP.mTargetKey.equals(this.P)) {
                this.aq = oVar.g;
                if (!z) {
                    this.B = false;
                    r();
                } else if (!"2".equals(this.ohJ) && ("2".equals(this.aq) || "3".equals(this.aq) || "4".equals(this.aq))) {
                    this.ohJ = "2";
                    this.ohK = new com.kascend.chushou.player.feedback.a();
                    if (this.ohK.oqa != null) {
                        this.ohK.oqa.reset();
                        this.ohK.oqa.roomId = oVar.ogP.mTargetKey;
                        this.ohK.oqa.enterType = 1;
                        this.ohK.b = System.currentTimeMillis();
                    }
                }
                this.B = false;
                this.P = oVar.ogP.mTargetKey;
                this.Q = this.P;
                this.ab = oVar.ogP.mCover;
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
                JSONObject O = com.kascend.chushou.d.e.O("_fromView", str, "_sc", oVar.ogP.mSC);
                com.kascend.chushou.toolkit.a.c.a(this.w, O);
                if (this.ohr != null) {
                    this.ohr.a();
                    this.ohr.a(this.P);
                }
                if (this.oho != null) {
                    this.oho.a((PlayUrl) null);
                    this.oho.f();
                    if (this.oho.c() != null) {
                        this.oho.c().clear();
                    }
                    this.oho.i.clear();
                }
                if (this.ohm != null) {
                    this.ohm.j();
                }
                a(O.toString(), false);
                return;
            }
            tv.chushou.zues.utils.g.PQ(a.i.str_same_room);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean egr() {
        FullRoomInfo egU;
        String str;
        RoomInfo roomInfo;
        if (egx()) {
            str = null;
            egU = null;
        } else {
            egU = this.oho.egU();
            str = (egU == null || (roomInfo = egU.mRoominfo) == null) ? null : roomInfo.mGameId;
        }
        return !this.L && (egU == null || h.isEmpty(str));
    }

    @Subscribe
    public void onMessageEvent(i iVar) {
        if (!isFinishing() && iVar.f4073a != 21 && iVar.f4073a != 22) {
            if (iVar.f4073a == 0 && (iVar.b instanceof Boolean)) {
                if (((Boolean) iVar.b).booleanValue() && !isFinishing()) {
                    w();
                    if (this.ohm != null) {
                        this.ohm.f();
                    }
                }
            } else if (iVar.f4073a == 46) {
                if ((iVar.b instanceof String) && this.ohm != null) {
                    this.ohm.c((String) iVar.b);
                }
            } else if (iVar.f4073a == 54) {
                if (iVar.b instanceof String) {
                    this.ohE.a((String) iVar.b);
                }
            } else if (iVar.f4073a == 55) {
                if (this.ohm != null) {
                    this.ohm.O();
                }
            } else if (iVar.f4073a == 56 && this.ohm != null) {
                this.ohm.P();
            }
        }
    }

    @Subscribe
    public void onRefreshSubscribeEvent(m mVar) {
        if (isFinishing() && this.oho != null && this.oho.egW() != null) {
            RoomInfo egW = this.oho.egW();
            if (mVar.a(egW.mCreatorUID, egW.mRoomID)) {
                egW.mIsSubscribed = mVar.c;
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
        if (this.m || this.ohj == null || this.ohk == null) {
            R();
        }
        if (this.ohr != null) {
            this.ohr.d();
        }
        if (!egx()) {
            if (this.ohx != null && !this.ohx.c()) {
                this.ohx.a();
            }
            v();
            if (this.oho != null && this.oho.egU() != null && this.oho.egU().cycleLiveRoomInfo != null && !h.isEmpty(this.oho.egU().cycleLiveRoomInfo.roomId)) {
                u();
            }
        }
        super.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.view.base.BaseActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        tv.chushou.zues.utils.e.e(this.v, MissionEvent.MESSAGE_DESTROY);
        if (this.oho != null && this.oho.egU() != null && this.oho.egU().cycleLiveRoomInfo != null && !h.isEmpty(this.oho.egU().cycleLiveRoomInfo.eventName)) {
            j.egp().a(this.P + egH());
        }
        if ("2".equals(this.ohJ) && this.ohK != null && this.ohK.oqa != null) {
            this.ohK.oqa.time = System.currentTimeMillis() - this.ohK.b;
            this.ohK.a();
            this.ohK.b();
        }
        this.ohD.d();
        this.ohE.b();
        this.ohF.b();
        O();
        this.ag = null;
        f4089a = null;
        if (this.ohO != null) {
            this.ohO.co(null);
            this.ohO = null;
        }
        if (this.ohx != null) {
            this.ohx.d();
            this.ohx = null;
        }
        if (this.ohr != null) {
            this.ohr.c();
            this.ohr = null;
        }
        if (this.oho != null) {
            this.oho.oiQ = null;
            this.oho.oiP = null;
        }
        if (this.oho != null) {
            this.oho.b();
            this.oho = null;
        }
        this.ohh = null;
        this.ohm = null;
        this.ohn = null;
        this.ohp = null;
        this.T = null;
        this.U = null;
        this.ohq = null;
        this.bRO = null;
        this.ohs = null;
        this.oht = null;
        this.ohu = null;
        this.ohv = null;
        this.ohw = null;
        if (this.ohA != null && this.ohA.isHeld()) {
            this.ohA.release();
            this.ohA = null;
        }
        if (this.ohN != null) {
            unregisterReceiver(this.ohN);
            this.ohN = null;
        }
        h.euf();
        tv.chushou.zues.a.a.cp(this);
        this.ohL.dispose();
        this.ohF.b();
        this.ohG.b();
        this.ohD.d();
        this.ohE.b();
        this.ohI.b();
        super.onDestroy();
        System.gc();
    }

    @Subscribe
    public void onSendGameGiftEvent(n nVar) {
        if (!isFinishing() && this.ohm != null) {
            this.ohm.a(nVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.view.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        tv.chushou.zues.utils.e.d(this.v, MissionEvent.MESSAGE_PAUSE);
        if (this.ohx != null) {
            this.ohx.b();
        }
        if (this.ohr != null) {
            this.ohr.b(false);
        }
        k();
        this.m = true;
        super.onPause();
    }

    @Override // android.app.Activity
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.ohm != null ? this.ohm.a(motionEvent) : super.onTouchEvent(motionEvent);
    }

    public void c() {
        if ("1".equals(this.R)) {
            j.egp().a(this.P + egH());
        } else {
            j.egp().b(this.P);
        }
    }

    private void a(boolean z, boolean z2) {
        int i = 0;
        tv.chushou.zues.utils.e.i(this.v, "startLoadingVideo <------------- mbPrepareingVideo = " + this.K);
        if (this.ohj != null) {
            this.ohj.setHardwearDecod(com.kascend.chushou.d.h.egj().f4087a);
        }
        if (this.ohk != null) {
            this.ohk.setHardwearDecod(com.kascend.chushou.d.h.egj().f4087a);
        }
        if (this.ohi != null) {
            this.ohi.setHardwearDecod(com.kascend.chushou.d.h.egj().f4087a);
        }
        if (!this.K) {
            if (z && this.ohm != null) {
                if (!z2) {
                    this.t = null;
                    this.ohm.e();
                }
            } else if (this.ohm != null && !z2) {
                this.t = null;
                this.ohm.H = false;
                RxExecutor.post(null, EventThread.MAIN_THREAD, new Runnable() { // from class: com.kascend.chushou.player.VideoPlayer.7
                    @Override // java.lang.Runnable
                    public void run() {
                        VideoPlayer.this.ohm.x();
                    }
                });
            }
            this.K = true;
            if (this.oho != null && this.oho.egV() != null) {
                PlayUrl egV = this.oho.egV();
                while (true) {
                    int i2 = i;
                    if (i2 >= egV.mUrlDetails.size()) {
                        break;
                    }
                    UrlDetails urlDetails = egV.mUrlDetails.get(i2);
                    if (urlDetails.mUrl.equals(egV.mSelectedUrl)) {
                        String str = egV.mUrlDetails.get(i2).mDefinitionType;
                        String str2 = urlDetails.mBitrate;
                    }
                    i = i2 + 1;
                }
            }
            if (z2) {
                if (this.d) {
                    this.ohj.setVideoURI(this.ohh);
                    this.ohj.open();
                    return;
                }
                this.ohk.setVideoURI(this.ohh);
                this.ohk.open();
                return;
            }
            this.ohi.setVideoURI(this.ohh);
            this.ohi.open();
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        try {
            if (motionEvent.getAction() == 0) {
                if (this.ohm != null && this.ohm.b(motionEvent)) {
                    return true;
                }
                if ("2".equals(this.ohJ) && this.ohm != null) {
                    this.ohm.a(motionEvent);
                }
            } else if (this.ohm != null && this.ohm.b(motionEvent)) {
                return true;
            }
            return super.dispatchTouchEvent(motionEvent);
        } catch (Exception e) {
            return false;
        }
    }

    @Override // android.support.v7.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.ohm != null && this.ohm.a(i, keyEvent)) {
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
        if (this.oho != null && this.oho.egU() != null && this.oho.egU().cycleLiveRoomInfo != null && !h.isEmpty(this.oho.egU().cycleLiveRoomInfo.roomId)) {
            this.ohC.setVisibility(0);
            this.ohB.setBlur(true);
            this.ohB.i(this.oho.egU().cycleLiveRoomInfo.avatar, 0, 0, 0);
            this.ohB.setVisibility(0);
            j.egp().a(this.P + egH());
            this.ohh = null;
            R();
            this.Q = this.oho.egU().cycleLiveRoomInfo.roomId;
            a(this.P, egH(), false);
        }
    }

    public void b(boolean z) {
        if (this.ohm != null) {
            this.ohm.j(z);
        }
    }

    public void a(boolean z, Uri uri, boolean z2) {
        tv.chushou.zues.utils.e.d(this.v, "loadIfNecessary reload=" + z + " isChangeLines-->" + z2);
        if (this.ohj != null && this.ohk != null) {
            if (uri != null) {
                this.ohh = uri;
            }
            if (z2) {
                this.e = z2;
            }
            this.M = false;
            this.N = 0L;
            this.O = 0;
            this.ohO.removeMessages(7);
            if (z) {
                if (z2) {
                    if (!this.d) {
                        this.ohk.setOnActivityCallBack(this.ohS);
                    } else {
                        this.ohj.setOnActivityCallBack(this.ohR);
                    }
                } else if (this.d) {
                    this.ohk.setOnActivityCallBack(this.ohS);
                } else {
                    this.ohj.setOnActivityCallBack(this.ohR);
                }
                this.K = false;
                b(true, z2);
            } else if (!this.J) {
                b(true, z2);
            }
            this.ohO.D(6, IMConnection.RETRY_DELAY_TIMES);
        }
    }

    private void b(boolean z, boolean z2) {
        VideoPlayInfo O;
        if ("1".equals(this.R)) {
            O = j.egp().N(this.P + egH(), 600000L);
        } else {
            O = j.egp().O(this.P, 600000L);
        }
        if (O != null) {
            a(z, z2);
        } else if ("1".equals(this.R)) {
            a(this.P, egH(), false);
        } else {
            bg(this.P, false);
        }
    }

    public tv.chushou.common.player.a egs() {
        return this.ohi;
    }

    public tv.chushou.common.player.a egt() {
        return this.ohj;
    }

    public tv.chushou.common.player.a egu() {
        return this.ohk;
    }

    public void a(tv.chushou.common.player.a aVar) {
        this.ohi = aVar;
    }

    public b egv() {
        return this.oho;
    }

    public com.kascend.chushou.widget.a.b egw() {
        return this.ohr;
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
        FullRoomInfo egU;
        this.r = -1L;
        if (this.s != -1 && this.s != 0) {
            this.r = this.s;
            this.s = -1L;
        }
        if (egx() && this.ohi != null && this.ohi.getPlayState() == 4) {
            this.r = this.ohi.getCurrentPos();
        }
        this.ohP = false;
        tv.chushou.zues.utils.e.d(this.v, "screenChange()<-----");
        tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard(this);
        if (str != null) {
            this.R = str;
        }
        if (!this.C || !z3 || "3".equals(this.R) || this.oho == null || (egU = this.oho.egU()) == null || egU.mRoominfo == null || egU.mRoominfo.mStyle != 1) {
            z5 = false;
        } else {
            z5 = true;
            i = 0;
        }
        if ("2".equals(this.ohJ)) {
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
            if (com.kascend.chushou.b.egb().d == 1) {
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
            ((VideoPlayer) this.w).zk(false);
            ((VideoPlayer) this.w).g(true);
            if (z5) {
                setRequestedOrientation(1);
            } else {
                setRequestedOrientation(6);
            }
            getWindow().addFlags(512);
            getWindow().addFlags(256);
        }
        if (this.ohr == null) {
            this.ohr = new com.kascend.chushou.widget.a.b();
        }
        if (this.ohr != null) {
            this.ohr.a(this.P);
        }
        if (this.R.equals("5")) {
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            if (this.ohm != null) {
                beginTransaction.remove(this.ohm);
                this.ohm = null;
            }
            if (this.ohn != null) {
                beginTransaction.remove(this.ohn);
                this.ohn = null;
            }
            this.ohn = new com.kascend.chushou.view.user.b();
            beginTransaction.add(a.f.fl_fragment, this.ohn);
            beginTransaction.commitAllowingStateLoss();
        } else {
            FragmentTransaction beginTransaction2 = getSupportFragmentManager().beginTransaction();
            if (this.ohm != null) {
                beginTransaction2.remove(this.ohm);
                this.ohm = null;
            }
            if (this.ohn != null) {
                beginTransaction2.remove(this.ohn);
                this.ohn = null;
            }
            if ("2".equals(this.ohJ)) {
                this.ohm = com.kascend.chushou.player.e.e.b(this.ab, z2, this.aq, this.P);
            } else if (1 == i) {
                if (!this.R.equals("3")) {
                    if (z4) {
                        v();
                    }
                    this.ohm = new com.kascend.chushou.player.d.a();
                    Bundle bundle = new Bundle();
                    bundle.putString("mCover", this.ab);
                    bundle.putBoolean("mInitViewAsync", z2);
                    this.ohm.setArguments(bundle);
                }
            } else {
                this.ohm = new com.kascend.chushou.player.d.b();
                Bundle bundle2 = new Bundle();
                if (z5) {
                    i = 1;
                }
                bundle2.putInt("mExtraOrientation", i);
                bundle2.putString("mViewType", this.R);
                this.ohm.setArguments(bundle2);
            }
            beginTransaction2.add(a.f.fl_fragment, this.ohm);
            beginTransaction2.commitAllowingStateLoss();
            this.H = true;
        }
        tv.chushou.zues.utils.e.d(this.v, "screenChange()----->");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean egx() {
        return this.R != null && this.R.equals("3");
    }

    private void R() {
        if (this.ohm != null) {
            this.ohm.omi = null;
        }
        if (this.ohi != null) {
            this.ohi.release();
            this.ohi = null;
            this.K = false;
        }
        if (this.ohj != null) {
            this.ohj.release();
            this.ohj = null;
        }
        if (this.ohk != null) {
            this.ohk.release();
            this.ohk = null;
        }
        if (this.ohl != null) {
            this.ohl.c();
        }
        this.d = false;
        this.e = false;
        this.M = false;
        this.ohl = new c();
        this.ohj = this.ohl.egZ();
        this.ohj.setOnActivityCallBack(this.ohR);
        this.ohk = this.ohl.eha();
        this.ohk.setOnActivityCallBack(this.ohS);
        if (!this.d) {
            this.ohi = this.ohj;
        } else {
            this.ohi = this.ohk;
        }
        if (this.ohm != null) {
            this.ohm.omi = this.ohi;
        }
    }

    public void j() {
        if (this.ohi != null) {
            this.ohi.pause();
            this.ohi.stop();
            this.ohi.release();
            this.ohi = null;
        }
        if (this.ohj != null) {
            this.ohj.stop();
            this.ohj.release();
            this.ohj = null;
        }
        if (this.ohk != null) {
            this.ohk.stop();
            this.ohk.release();
            this.ohk = null;
        }
        if (this.ohl != null) {
            this.ohl.c();
        }
    }

    public void k() {
        tv.chushou.common.player.a aVar = this.ohi;
        if (aVar != null) {
            aVar.pause();
            aVar.stop();
        }
        tv.chushou.common.player.a aVar2 = this.ohj;
        if (aVar2 != null) {
            aVar2.stop();
        }
        tv.chushou.common.player.a aVar3 = this.ohk;
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
        if (this.ohP) {
            if (this.ohm != null) {
                this.ohm.s();
            }
        } else if (this.ohO != null) {
            this.ohO.b(this.ohO.PJ(3), 20L);
        }
    }

    private void b(final String str, String str2) {
        com.kascend.chushou.c.c.ege().a(new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.VideoPlayer.8
            @Override // com.kascend.chushou.c.b
            public void a() {
                VideoPlayer.this.L = true;
            }

            @Override // com.kascend.chushou.c.b
            public void a(String str3, JSONObject jSONObject) {
                boolean z = false;
                if (!VideoPlayer.this.isFinishing()) {
                    ParserRet r = com.kascend.chushou.c.f.r(str, jSONObject);
                    if (r.mRc != 0 || r.mData == null) {
                        VideoPlayer.this.b(r.mMessage, r.mRc);
                        return;
                    }
                    FullRoomInfo fullRoomInfo = (FullRoomInfo) r.mData;
                    VideoPlayer.this.egF().a(fullRoomInfo.mBangMap);
                    if (h.isEmpty(fullRoomInfo.mRoominfo.mRoomID)) {
                        fullRoomInfo.mRoominfo.mRoomID = VideoPlayer.this.P;
                    }
                    if (!h.isEmpty(fullRoomInfo.mGeneralTabGifts)) {
                        com.kascend.chushou.d.e.a(VideoPlayer.this.ohL, new ArrayList(fullRoomInfo.mGeneralTabGifts));
                    }
                    if (VideoPlayer.this.oho != null) {
                        VideoPlayer.this.oho.a(fullRoomInfo);
                    }
                    VideoPlayer.this.L = false;
                    if (VideoPlayer.this.B) {
                        if (VideoPlayer.this.C && !"3".equals(VideoPlayer.this.R) && fullRoomInfo != null && fullRoomInfo.mRoominfo != null && fullRoomInfo.mRoominfo.mStyle == 1 && !h.isEmpty(fullRoomInfo.mRoominfo.mGameId)) {
                            z = true;
                        }
                        if (!z) {
                            if (VideoPlayer.this.ohm != null) {
                                VideoPlayer.this.ohm.a(VideoPlayer.this.oho);
                            }
                            if (!h.isEmpty(fullRoomInfo.mRoominfo.mGameId)) {
                                VideoPlayer.this.S();
                            } else {
                                if (VideoPlayer.this.oho != null) {
                                    VideoPlayer.this.oho.f = null;
                                }
                                VideoPlayer.this.S();
                            }
                        } else {
                            VideoPlayer.this.a(1, "1", true);
                            if (VideoPlayer.this.ohm != null) {
                                VideoPlayer.this.ohm.a(VideoPlayer.this.oho);
                            }
                        }
                    } else {
                        if (h.isEmpty(fullRoomInfo.mRoominfo.mGameId)) {
                            if (VideoPlayer.this.oho != null) {
                                VideoPlayer.this.oho.f = null;
                            }
                            VideoPlayer.this.a(1, "1");
                        } else {
                            VideoPlayer.this.a(1, "1", true);
                        }
                        if (VideoPlayer.this.ohm != null) {
                            VideoPlayer.this.ohm.a(VideoPlayer.this.oho);
                        }
                    }
                    if (VideoPlayer.this.oho != null && !VideoPlayer.this.oho.m()) {
                        if (VideoPlayer.this.ohx != null) {
                            VideoPlayer.this.ohx.d();
                            VideoPlayer.this.ohx = null;
                        }
                        VideoPlayer.this.ohx = new com.kascend.chushou.toolkit.d(900000L, VideoPlayer.this.ohz, VideoPlayer.this.ohO);
                        VideoPlayer.this.ohx.a();
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
        if (this.oho != null) {
            this.oho.a((FullRoomInfo) null);
        }
        this.L = false;
        bS(str, i);
        if (this.ohi != null) {
            this.ohi.stop();
        }
        if (this.ohj != null) {
            this.ohj.stop();
        }
        if (this.ohk != null) {
            this.ohk.stop();
        }
    }

    public void l() {
        tv.chushou.zues.utils.e.d(this.v, "retryGetPlayList");
        c();
        if (egx()) {
            bg(this.P, false);
        } else {
            a(this.P, egH(), false);
        }
    }

    public void m() {
        a(this.ag, false);
    }

    private void a(final String str, String str2, boolean z) {
        this.J = true;
        VideoPlayInfo N = j.egp().N(str + str2, 600000L);
        if (N != null) {
            a((ArrayList) N.mPlayUrls);
            this.J = false;
        } else if (z) {
            ParserRet gI = com.kascend.chushou.player.c.a.ehb().gI(str, str2);
            if (gI.mRc != 0) {
                tv.chushou.zues.utils.e.e(this.v, "getPlayUrlSync fail, try to getPlaylist");
                a(str, str2, false);
                return;
            }
            a(gI, str);
        } else {
            com.kascend.chushou.player.c.a.ehb().a(str, str2, new a.InterfaceC0902a() { // from class: com.kascend.chushou.player.VideoPlayer.9
                @Override // com.kascend.chushou.player.c.a.InterfaceC0902a
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
    private void bg(final String str, boolean z) {
        boolean equals;
        this.J = true;
        VideoPlayInfo O = j.egp().O(str, 600000L);
        if (O != null) {
            a((ArrayList) O.mPlayUrls);
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
                ParserRet bh = com.kascend.chushou.player.c.a.ehb().bh(str, equals);
                if (bh.mRc != 0) {
                    tv.chushou.zues.utils.e.e(this.v, "getVideoPlayUrlSync fail, try to getVideoPlaylist");
                    bg(str, false);
                    return;
                }
                a(bh, str);
                return;
            }
            com.kascend.chushou.player.c.a.ehb().a(str, new a.InterfaceC0902a() { // from class: com.kascend.chushou.player.VideoPlayer.10
                @Override // com.kascend.chushou.player.c.a.InterfaceC0902a
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
                if (this.oho.f == null) {
                    this.oho.f = new ArrayList<>();
                }
                this.oho.f.clear();
                this.oho.f.addAll(arrayList);
                if ("1".equals(this.R)) {
                    j.egp().a(str + egH(), arrayList);
                } else {
                    j.egp().s(str, arrayList);
                }
                a(arrayList);
                return;
            }
            if (this.oho != null) {
                this.oho.f = null;
            }
            if (this.ohO != null) {
                Message PJ = this.ohO.PJ(5);
                PJ.arg1 = 2;
                PJ.arg2 = parserRet.mRc;
                this.ohO.S(PJ);
            }
        }
    }

    private void bS(String str, int i) {
        s();
        if (this.ohr != null) {
            this.ohr.a();
        }
        if (h.isEmpty(str)) {
            str = getString(a.i.str_load_data_failed);
        }
        a(str, i);
    }

    public void n() {
        if (this.ohu != null && this.bRO != null && this.ohw != null) {
            this.ohu.setVisibility(0);
            this.bRO.setVisibility(8);
            this.ohw.setVisibility(8);
        }
    }

    public void o() {
        if (this.ohB != null && this.ohB.getVisibility() == 0) {
            this.ohB.Dr(0);
            this.ohB.setVisibility(8);
        }
    }

    public void p() {
        if (this.ohC != null && this.ohC.getVisibility() == 0) {
            this.ohC.setVisibility(8);
        }
    }

    public void q() {
        this.ohP = true;
    }

    protected void r() {
        this.ohu.setVisibility(8);
        this.ohw.setVisibility(0);
        this.bRO.setVisibility(0);
        if (this.ohq != null) {
            this.T.setVisibility(8);
            this.ohq.setVisibility(0);
            this.U.setText(getString(a.i.str_dialog_loading_content));
            this.U.setVisibility(8);
        }
    }

    protected void a(String str, int i) {
        this.ohu.setVisibility(8);
        this.ohw.setVisibility(0);
        this.bRO.setVisibility(0);
        if (this.ohq != null) {
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
                            com.kascend.chushou.c.c.ege().b(new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.VideoPlayer.11.1
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
                                        tv.chushou.zues.utils.g.K(VideoPlayer.this, a.i.subscribe_failed);
                                    }
                                }
                            }, VideoPlayer.this.P, (String) null, VideoPlayer.this.oho.h);
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
            this.ohq.setVisibility(8);
            this.ohC.setVisibility(8);
        }
    }

    public void s() {
        if (this.ohO != null) {
            this.ohO.removeMessages(1);
        }
    }

    private void a(ArrayList<PlayUrl> arrayList) {
        boolean z;
        if (this.oho.f == null) {
            this.oho.f = new ArrayList<>();
        }
        this.oho.f.clear();
        this.oho.f.addAll(arrayList);
        if (com.kascend.chushou.d.e.b() && !"4".equals(this.aq)) {
            int c = com.kascend.chushou.d.e.c();
            if (c == -1) {
                b(arrayList);
                return;
            } else if (this.aw) {
                this.aw = false;
                if (c == 0) {
                    this.oho.d = false;
                    g(arrayList, true);
                    return;
                }
                if (this.oho != null && this.oho.f != null) {
                    Iterator<PlayUrl> it = this.oho.f.iterator();
                    while (it.hasNext()) {
                        if ("2".equals(it.next().mType)) {
                            z = true;
                            break;
                        }
                    }
                }
                z = false;
                this.oho.d = z;
                g(arrayList, true);
                return;
            } else {
                if (this.oho.e) {
                    this.oho.d = !this.oho.d;
                    this.oho.e = false;
                    this.ohQ = true;
                } else if ("4".equals(this.aq)) {
                    this.oho.d = true;
                }
                g(arrayList, true);
                return;
            }
        }
        if (this.oho.e) {
            this.oho.d = !this.oho.d;
            this.oho.e = false;
            this.ohQ = true;
        } else if ("4".equals(this.aq)) {
            this.oho.d = true;
        }
        g(arrayList, true);
    }

    private void b(ArrayList<PlayUrl> arrayList) {
        if ("1".equals(this.R)) {
            if ("2".equals(this.ohJ)) {
                d(false, arrayList);
            } else if (this.ohm != null) {
                this.ohm.g(arrayList, false);
            }
        } else if (this.ohm != null) {
            this.ohm.g(arrayList, false);
        }
    }

    public void c(boolean z) {
        this.oho.d = false;
        com.kascend.chushou.d.e.a(0);
        ArrayList<PlayUrl> arrayList = this.oho.f;
        if (!h.isEmpty(arrayList)) {
            if (z) {
                g(arrayList, false);
                if (this.ohO != null) {
                    this.ohO.PH(2);
                    return;
                }
                return;
            }
            g(arrayList, true);
        }
    }

    public void d(boolean z) {
        this.oho.d = true;
        com.kascend.chushou.d.e.a(1);
        ArrayList<PlayUrl> arrayList = this.oho.f;
        if (!h.isEmpty(arrayList)) {
            if (z) {
                g(arrayList, false);
                if (this.ohO != null) {
                    this.ohO.PH(2);
                    return;
                }
                return;
            }
            g(arrayList, true);
        }
    }

    @Subscribe
    public void onNotifyEvent(com.kascend.chushou.b.a.a.j jVar) {
        if (!isFinishing() && jVar.f4074a == 1 && !"5".equals(this.R) && !egr()) {
            tv.chushou.zues.utils.e.d(this.v, "onNetworkChangeEvent 3G=" + com.kascend.chushou.b.egb().b + "  wifi=" + com.kascend.chushou.b.egb().f4066a);
            if (com.kascend.chushou.d.e.b() && !"4".equals(this.aq)) {
                if (com.kascend.chushou.d.e.c() == -1) {
                    if (this.ohm != null) {
                        this.ohm.e(false);
                    }
                    if ("1".equals(this.R)) {
                        if ("2".equals(this.ohJ)) {
                            d(true, null);
                            return;
                        } else if (this.ohm != null) {
                            this.ohm.g(this.oho.f, true);
                            return;
                        } else {
                            return;
                        }
                    } else if (this.ohm != null) {
                        this.ohm.g(this.oho.f, true);
                        return;
                    } else {
                        return;
                    }
                }
                RxExecutor.postDelayed(this.ohL, EventThread.MAIN_THREAD, 10L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.VideoPlayer.12
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!VideoPlayer.this.isFinishing() && com.kascend.chushou.b.egb().b && !com.kascend.chushou.b.egb().f4066a) {
                            tv.chushou.zues.utils.g.c(VideoPlayer.this.w, VideoPlayer.this.getString(a.i.str_monet_notify));
                        }
                    }
                });
            } else if (com.kascend.chushou.b.egb().f4066a || com.kascend.chushou.b.egb().b) {
                t();
                if (this.ohO != null) {
                    this.ohO.PH(2);
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
            if (this.oho.d) {
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
            String d = com.kascend.chushou.d.h.egj().d();
            String str3 = h.isEmpty(d) ? "2" : d;
            if (this.oho.d) {
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
                if (this.oho != null) {
                    this.oho.a(playUrl2);
                    if (this.ohO != null) {
                        Message PJ = this.ohO.PJ(5);
                        PJ.arg1 = 1;
                        this.ohO.S(PJ);
                    }
                }
                String b = com.kascend.chushou.player.c.a.b(playUrl2);
                if (!h.isEmpty(b)) {
                    this.ohh = Uri.parse(b);
                    if (this.ohQ) {
                        this.ohQ = false;
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (z && this.ohi != null) {
                        a(false, z2);
                    }
                }
            }
        }
    }

    public void d(final boolean z, ArrayList<PlayUrl> arrayList) {
        if (this.ohy == null || this.ohy.f4226a <= 0) {
            this.ohy = com.kascend.chushou.view.b.a.a.eis();
            this.ohy.a(new a.InterfaceC0921a() { // from class: com.kascend.chushou.player.VideoPlayer.13
                @Override // com.kascend.chushou.view.b.a.a.InterfaceC0921a
                public void a(int i) {
                    if (i == a.f.tv_play_video) {
                        VideoPlayer.this.ohy.dismissAllowingStateLoss();
                        VideoPlayer.this.c(z);
                    } else if (i == a.f.tv_play_audio) {
                        VideoPlayer.this.ohy.dismissAllowingStateLoss();
                        VideoPlayer.this.d(z);
                    } else if (i == a.f.iv_close) {
                        VideoPlayer.this.finish();
                    } else {
                        if (i == a.f.tv_union_proxy) {
                        }
                    }
                }
            });
            this.ohy.show(getSupportFragmentManager(), "showRoom");
        }
    }

    public void t() {
        if (this.ohy != null) {
            this.ohy.dismissAllowingStateLoss();
        }
        if (this.ohm != null) {
            this.ohm.v();
        }
    }

    public void u() {
        com.kascend.chushou.c.c.ege().c(this.P, new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.VideoPlayer.16
            @Override // com.kascend.chushou.c.b
            public void a() {
            }

            @Override // com.kascend.chushou.c.b
            public void a(String str, JSONObject jSONObject) {
                if (!VideoPlayer.this.isFinishing()) {
                    ParserRet ey = com.kascend.chushou.c.e.ey(jSONObject);
                    if (ey.mRc == 0 && ey.mData != null) {
                        CycleLiveRoomInfo cycleLiveRoomInfo = (CycleLiveRoomInfo) ey.mData;
                        if (VideoPlayer.this.oho != null && cycleLiveRoomInfo != null && !h.isEmpty(cycleLiveRoomInfo.roomId)) {
                            FullRoomInfo egU = VideoPlayer.this.oho.egU();
                            if (egU.cycleLiveRoomInfo == null) {
                                egU.cycleLiveRoomInfo = cycleLiveRoomInfo;
                                VideoPlayer.this.d();
                            } else if (egU.cycleLiveRoomInfo != null && !cycleLiveRoomInfo.roomId.equals(egU.cycleLiveRoomInfo.roomId)) {
                                egU.cycleLiveRoomInfo.copyCycleLiveRoomInfo(cycleLiveRoomInfo);
                                VideoPlayer.this.d();
                            } else {
                                egU.cycleLiveRoomInfo.copyCycleLiveRoomInfo(cycleLiveRoomInfo);
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
        if (this.ohm != null) {
            this.ohm.N();
        }
    }

    public void v() {
        com.kascend.chushou.c.c.ege().a(this.P, new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.VideoPlayer.17
            @Override // com.kascend.chushou.c.b
            public void a() {
            }

            @Override // com.kascend.chushou.c.b
            public void a(String str, JSONObject jSONObject) {
                if (!VideoPlayer.this.isFinishing()) {
                    ParserRet ez = com.kascend.chushou.c.e.ez(jSONObject);
                    if (ez.mRc == 0 && ez.mData != null) {
                        PkNotifyInfo pkNotifyInfo = (PkNotifyInfo) ez.mData;
                        VideoPlayer.this.ohH.b = VideoPlayer.this.P;
                        if (pkNotifyInfo != null) {
                            VideoPlayer.this.ohH.omj = pkNotifyInfo;
                            if (VideoPlayer.this.ohm != null) {
                                VideoPlayer.this.ohm.a(pkNotifyInfo, VideoPlayer.this.P);
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
        if (this.ohp != null) {
            this.ohp.release();
            this.ohp = null;
        }
        com.kascend.chushou.c.c.ege().a(this.P, new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.VideoPlayer.18
            @Override // com.kascend.chushou.c.b
            public void a() {
            }

            @Override // com.kascend.chushou.c.b
            public void a(String str, JSONObject jSONObject) {
                if (!VideoPlayer.this.isFinishing()) {
                    ParserRet eA = com.kascend.chushou.c.e.eA(jSONObject);
                    if (eA.mRc == 0 && eA.mData != null) {
                        RoomExpandInfo roomExpandInfo = (RoomExpandInfo) eA.mData;
                        if (VideoPlayer.this.oho != null) {
                            VideoPlayer.this.oho.oiR = roomExpandInfo.mTopWebAdItem;
                            if (VideoPlayer.this.oho.oiX == null) {
                                VideoPlayer.this.oho.oiX = new ArrayList();
                            }
                            VideoPlayer.this.oho.oiX.clear();
                            VideoPlayer.this.oho.oiX.addAll(roomExpandInfo.mGiftTopRightIcons);
                            tv.chushou.zues.a.a.post(new i(50, VideoPlayer.this.oho.oiR));
                        }
                        if (VideoPlayer.this.oho != null) {
                            VideoPlayer.this.oho.ga(roomExpandInfo.mExpandNavList);
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
                            VideoPlayer.this.ohD.a(list);
                        }
                        List<com.kascend.chushou.player.ui.h5.c.c> list2 = roomExpandInfo.mLuckList;
                        if (!h.isEmpty(list2)) {
                            VideoPlayer.this.ohE.a(list2);
                        }
                        com.kascend.chushou.player.ui.h5.c.c cVar = roomExpandInfo.mVoteItem;
                        if (cVar != null) {
                            VideoPlayer.this.ohF.a(cVar);
                        }
                        List<com.kascend.chushou.player.ui.h5.c.b> list3 = roomExpandInfo.mInteractH5Item;
                        if (!h.isEmpty(list3)) {
                            VideoPlayer.this.ohI.a(list3);
                        }
                        List<com.kascend.chushou.player.ui.h5.c.b> list4 = roomExpandInfo.mInteractNavItem;
                        if (!h.isEmpty(list4)) {
                            VideoPlayer.this.ohI.a(list4);
                        }
                        VideoPlayer.this.ohp = (PrivilegeInfo) eA.mData1;
                        if (VideoPlayer.this.ohp != null) {
                            tv.chushou.zues.a.a.post(new l());
                        }
                        if (VideoPlayer.this.oho != null) {
                            VideoPlayer.this.oho.oiY = roomExpandInfo.mIconConfig;
                            VideoPlayer.this.egF().a(roomExpandInfo.mIconConfig.bangConfig);
                        }
                        List<SkinConfig> list5 = roomExpandInfo.skinConfig;
                        if (list5 != null && VideoPlayer.this.oho != null) {
                            VideoPlayer.this.oho.ojb.clear();
                            int i = 0;
                            while (true) {
                                int i2 = i;
                                if (i2 >= list5.size()) {
                                    break;
                                }
                                SkinConfig skinConfig = list5.get(i2);
                                VideoPlayer.this.oho.ojb.put(skinConfig.position, skinConfig.resource);
                                i = i2 + 1;
                            }
                            VideoPlayer.this.C();
                        }
                        VideoPlayer.this.a(roomExpandInfo.mIconConfig, VideoPlayer.this.oho != null ? VideoPlayer.this.oho.ojb : null);
                        if (roomExpandInfo.mColorMap != null && roomExpandInfo.mColorMap.size() > 0 && com.kascend.chushou.b.egb().c != null && com.kascend.chushou.b.egb().c.size() <= 0) {
                            com.kascend.chushou.b.egb().c.putAll(roomExpandInfo.mColorMap);
                            tv.chushou.zues.a.a.post(new i(52, null));
                        }
                        AutoBang autoBang = roomExpandInfo.mAutoBang;
                        if (autoBang != null && autoBang.currentTime != 0 && autoBang.bangTime != 0) {
                            VideoPlayer.this.egF().a(autoBang);
                        }
                        if (!h.isEmpty(roomExpandInfo.mRelatedRoomList) && VideoPlayer.this.oho != null) {
                            VideoPlayer.this.oho.t = roomExpandInfo.mRelatedRoomList;
                            if (VideoPlayer.this.ohm != null && VideoPlayer.this.H) {
                                VideoPlayer.this.ohm.w();
                            }
                        }
                        if (roomExpandInfo.mRoomNewUserInfo != null && roomExpandInfo.mRoomNewUserInfo.mBarrierNoviceGuide && !com.kascend.chushou.d.h.egj().k() && VideoPlayer.this.ohm != null) {
                            VideoPlayer.this.ohm.J();
                        }
                        if (roomExpandInfo.mRoomNewUserInfo != null && roomExpandInfo.mRoomNewUserInfo.mRewardNoviceGuide && !com.kascend.chushou.d.h.egj().l() && VideoPlayer.this.ohm != null) {
                            VideoPlayer.this.ohm.K();
                        }
                        if (!h.isEmpty(roomExpandInfo.mShopWindowInfos)) {
                            if (VideoPlayer.this.oho != null) {
                                if (VideoPlayer.this.oho.oiZ == null) {
                                    VideoPlayer.this.oho.oiZ = new ArrayList();
                                }
                                VideoPlayer.this.oho.oiZ.addAll(roomExpandInfo.mShopWindowInfos);
                            }
                            if (VideoPlayer.this.ohm != null) {
                                VideoPlayer.this.ohm.L();
                            }
                        }
                        VideoPlayer.this.ohH.b = VideoPlayer.this.P;
                        if (roomExpandInfo.mPkNotifyInfo != null) {
                            VideoPlayer.this.ohH.omj = roomExpandInfo.mPkNotifyInfo;
                            if (VideoPlayer.this.ohm != null) {
                                VideoPlayer.this.ohm.a(roomExpandInfo.mPkNotifyInfo, VideoPlayer.this.P);
                            }
                        } else {
                            VideoPlayer.this.ohH.omj = null;
                        }
                        if (roomExpandInfo.mTrumpetPocket != null && VideoPlayer.this.oho != null) {
                            VideoPlayer.this.oho.oja = roomExpandInfo.mTrumpetPocket;
                            if (VideoPlayer.this.ohm != null) {
                                VideoPlayer.this.ohm.M();
                            }
                        }
                        if (!h.isEmpty(roomExpandInfo.hotwordContentList)) {
                            if (VideoPlayer.this.oho != null) {
                                if (VideoPlayer.this.oho.w == null) {
                                    VideoPlayer.this.oho.w = new ArrayList();
                                }
                                VideoPlayer.this.oho.w.clear();
                                VideoPlayer.this.oho.w.addAll(roomExpandInfo.hotwordContentList);
                            }
                            if (VideoPlayer.this.ohm != null) {
                                VideoPlayer.this.ohm.b(roomExpandInfo.hotwordContentList);
                            }
                        }
                        VideoPlayer.this.U();
                        return;
                    }
                    a(eA.mRc, eA.mMessage);
                }
            }

            @Override // com.kascend.chushou.c.b
            public void a(int i, String str) {
                tv.chushou.zues.utils.e.e(VideoPlayer.this.v, "get room gift popup list failed, rc =" + i + ", errorMsg=" + str);
            }
        }, this.ag, this.ohJ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U() {
        if (!h.isEmpty(com.kascend.chushou.a.a.egc().z)) {
            StringBuilder sb = new StringBuilder();
            if (com.kascend.chushou.a.a.egc().z.contains(com.kascend.chushou.a.a.f)) {
                if (sb.length() > 0) {
                    sb.append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                sb.append(com.kascend.chushou.a.a.f);
            }
            if (com.kascend.chushou.a.a.egc().z.contains(com.kascend.chushou.a.a.g)) {
                if (sb.length() > 0) {
                    sb.append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                sb.append(com.kascend.chushou.a.a.g);
            }
            if (com.kascend.chushou.a.a.egc().z.contains(com.kascend.chushou.a.a.i)) {
                if (sb.length() > 0) {
                    sb.append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                sb.append(com.kascend.chushou.a.a.i);
            }
            if (com.kascend.chushou.a.a.egc().z.contains(com.kascend.chushou.a.a.h)) {
                if (sb.length() > 0) {
                    sb.append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                sb.append(com.kascend.chushou.a.a.h);
            }
            if (com.kascend.chushou.a.a.egc().z.contains(com.kascend.chushou.a.a.j)) {
                if (sb.length() > 0) {
                    sb.append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                sb.append(com.kascend.chushou.a.a.j);
            }
            if (com.kascend.chushou.a.a.egc().z.contains(com.kascend.chushou.a.a.l)) {
                if (sb.length() > 0) {
                    sb.append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                sb.append(com.kascend.chushou.a.a.l);
            }
            if (com.kascend.chushou.a.a.egc().z.contains(com.kascend.chushou.a.a.m)) {
                if (sb.length() > 0) {
                    sb.append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                sb.append(com.kascend.chushou.a.a.m);
            }
            if (sb.length() != 0) {
                com.kascend.chushou.a.a.egc().a(sb.toString(), this.P, new a.c() { // from class: com.kascend.chushou.player.VideoPlayer.19
                    @Override // com.kascend.chushou.a.a.c
                    public void a(List<ListItem> list) {
                        if (VideoPlayer.this.oho != null && list != null) {
                            int i = 0;
                            while (true) {
                                int i2 = i;
                                if (i2 >= list.size()) {
                                    break;
                                }
                                if (list.get(i2).mAdExtraInfo != null) {
                                    if (com.kascend.chushou.a.a.f.equals(list.get(i2).mAdExtraInfo.mCode)) {
                                        VideoPlayer.this.oho.oiQ = list.get(i2);
                                    } else if (com.kascend.chushou.a.a.g.equals(list.get(i2).mAdExtraInfo.mCode)) {
                                        VideoPlayer.this.oho.oiP = list.get(i2);
                                    } else if (com.kascend.chushou.a.a.i.equals(list.get(i2).mAdExtraInfo.mCode)) {
                                        VideoPlayer.this.oho.oiS = list.get(i2);
                                    } else if (com.kascend.chushou.a.a.h.equals(list.get(i2).mAdExtraInfo.mCode)) {
                                        VideoPlayer.this.oho.oiT = list.get(i2);
                                    } else if (com.kascend.chushou.a.a.j.equals(list.get(i2).mAdExtraInfo.mCode)) {
                                        VideoPlayer.this.oho.oiW = list.get(i2);
                                    } else if (com.kascend.chushou.a.a.l.equals(list.get(i2).mAdExtraInfo.mCode)) {
                                        VideoPlayer.this.oho.oiU = list.get(i2);
                                    } else if (com.kascend.chushou.a.a.m.equals(list.get(i2).mAdExtraInfo.mCode)) {
                                        VideoPlayer.this.oho.oiV = list.get(i2);
                                    }
                                }
                                i = i2 + 1;
                            }
                            if (VideoPlayer.this.ohm != null) {
                                VideoPlayer.this.ohm.H();
                            }
                        }
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str, String str2) {
        if (egx()) {
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
                this.oht.setSystemUiVisibility(i);
                return;
            }
            this.oht.setSystemUiVisibility(1792);
        }
    }

    public void f(boolean z) {
        Window window;
        View decorView;
        if (com.kascend.chushou.b.egb().d != 1 && (window = getWindow()) != null && (decorView = window.getDecorView()) != null) {
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
        if (this.ohm != null) {
            this.ohm.a(i, i2, intent);
        }
    }

    public Uri egy() {
        return this.ohh;
    }

    @Override // com.kascend.chushou.view.base.BaseActivity
    protected int y() {
        return 0;
    }

    public void zk(boolean z) {
        if (this.oht != null) {
            this.oht.pph = z;
        }
    }

    public void egz() {
        if (this.oht != null) {
            this.oht.egz();
        }
    }

    public boolean egA() {
        return this.ae;
    }

    public void g(boolean z) {
        this.ae = z;
    }

    public void h(boolean z) {
        if (this.oht != null) {
            this.oht.setIsTranslucentStatus(z);
        }
    }

    public void z() {
        if (this.oht != null) {
            this.oht.euy();
        }
    }

    @Override // com.kascend.chushou.widget.gifts.RoomSendGiftView.a
    public void A() {
        if (this.ohr != null) {
            this.ohr.b();
        }
        if (this.oho != null) {
            this.oho.z = true;
        }
    }

    @Override // com.kascend.chushou.widget.gifts.RoomSendGiftView.a
    public void B() {
        if (this.ohr != null) {
            this.ohr.b();
        }
    }

    public void a(List<ListItem> list) {
        if (this.ohm != null) {
            this.ohm.a(list);
        }
    }

    public void a(IconConfig iconConfig, Map<String, SkinConfig.SkinRes> map) {
        if (this.ohm != null) {
            this.ohm.a(iconConfig, map);
        }
    }

    public void C() {
        if (this.ohm != null) {
            this.ohm.I();
        }
    }

    @Override // com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC0913a
    public void a(int i) {
        if (this.ohm != null) {
            this.ohm.a(i);
        }
    }

    @Override // com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC0913a
    public void D() {
        if (!isFinishing() && this.ohm != null) {
            this.ohm.D();
        }
    }

    @Override // com.kascend.chushou.player.ui.h5.b.b.a
    public void a(long j) {
        if (!isFinishing() && this.ohm != null) {
            this.ohm.a(j);
        }
    }

    @Override // com.kascend.chushou.player.ui.h5.b.b.a
    public void a(com.kascend.chushou.player.ui.h5.c.a aVar) {
        if (aVar != null && this.ohm != null) {
            this.ohm.a(aVar);
        }
    }

    @Override // com.kascend.chushou.player.ui.h5.b.b.a
    public void b(int i) {
        if (this.ohm != null) {
            this.ohm.b(i);
        }
    }

    @Override // com.kascend.chushou.player.ui.h5.d.a.InterfaceC0912a
    public void b(long j) {
        if (!isFinishing() && this.ohm != null) {
            this.ohm.b(j);
        }
    }

    @Override // com.kascend.chushou.player.ui.h5.a.a.InterfaceC0910a
    public void c(int i) {
        if (!isFinishing() && this.ohm != null) {
            this.ohm.c(i);
        }
    }

    @Override // com.kascend.chushou.player.ui.h5.d.a.InterfaceC0912a
    public void b(com.kascend.chushou.player.ui.h5.c.a aVar) {
        if (aVar != null && this.ohm != null) {
            this.ohm.b(aVar);
        }
    }

    @Override // com.kascend.chushou.player.ui.a.a.InterfaceC0907a
    public void a(IconConfig.Config config) {
        if (this.ohm != null) {
            this.ohm.a(config);
        }
    }

    @Override // com.kascend.chushou.player.ui.a.a.InterfaceC0907a
    public void a(BangInfo bangInfo, String str) {
        if (this.ohm != null) {
            this.ohm.a(bangInfo, str);
        }
    }

    @Override // com.kascend.chushou.player.ui.a.a.InterfaceC0907a
    public void a(long j, BangInfo bangInfo, String str) {
        if (this.ohm != null) {
            this.ohm.a(j, bangInfo, str);
        }
    }

    public com.kascend.chushou.player.ui.h5.redpacket.a egB() {
        return this.ohD;
    }

    public com.kascend.chushou.player.ui.h5.b.b egC() {
        return this.ohE;
    }

    public com.kascend.chushou.player.ui.h5.d.a egD() {
        return this.ohF;
    }

    public com.kascend.chushou.player.ui.h5.a.a egE() {
        return this.ohI;
    }

    public com.kascend.chushou.player.ui.a.a egF() {
        return this.ohG;
    }

    public com.kascend.chushou.player.e.a egG() {
        return this.ohH;
    }

    @Override // com.kascend.chushou.view.base.BaseActivity, android.app.Activity
    public void finish() {
        super.finish();
        if ("3".equals(this.R)) {
            overridePendingTransition(17432576, a.C0897a.commonres_activity_exit_bottom);
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
        RxExecutor.postDelayed(this.ohL, EventThread.MAIN_THREAD, aVar.d, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.VideoPlayer.2
            @Override // java.lang.Runnable
            public void run() {
                if (VideoPlayer.this.ohm != null) {
                    VideoPlayer.this.ohm.c(aVar);
                }
            }
        });
    }

    private void e(final com.kascend.chushou.player.ui.h5.c.a aVar) {
        if (!com.kascend.chushou.d.h.egj().egm().contains(aVar.b)) {
            if (aVar.d < 0) {
                aVar.d = 0;
            }
            RxExecutor.postDelayed(this.ohL, EventThread.MAIN_THREAD, aVar.d, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.VideoPlayer.3
                @Override // java.lang.Runnable
                public void run() {
                    if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.ohm != null) {
                        VideoPlayer.this.ohm.c(aVar);
                    }
                }
            });
        }
    }

    private String egH() {
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
                if (VideoPlayer.this.ohs != null && !VideoPlayer.this.isFinishing()) {
                    VideoPlayer.n = VideoPlayer.this.ohs.getStreamVolume(3);
                }
                if (!VideoPlayer.this.isFinishing() && (VideoPlayer.this.ohm instanceof f)) {
                    ((f) VideoPlayer.this.ohm).ab();
                }
            }
        }
    }

    public String a(String str) {
        HashMap hashMap = new HashMap(tv.chushou.zues.utils.d.Yl(str));
        if ("1".equals(this.R)) {
            hashMap.put("roomId", this.P);
        } else if ("3".equals(this.R)) {
            hashMap.put("videoId", this.P);
        }
        return tv.chushou.zues.utils.d.toJson(hashMap);
    }

    public boolean egI() {
        if (this.ohm instanceof com.kascend.chushou.player.d.a) {
            return ((com.kascend.chushou.player.d.a) this.ohm).ehG();
        }
        if (this.ohm instanceof com.kascend.chushou.player.e.e) {
            return true;
        }
        return false;
    }
}

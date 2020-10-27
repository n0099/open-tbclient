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
public class VideoPlayer extends BaseActivity implements a.InterfaceC0979a, a.InterfaceC0982a, b.a, a.InterfaceC0984a, a.InterfaceC0985a, RoomSendGiftView.a {
    private static int A = 60000;

    /* renamed from: a  reason: collision with root package name */
    public static String f4087a = null;
    public static int n = 0;
    private String P;
    private String Q;
    private String R;
    private String S;
    private String ab;
    private String ag;
    private c oYA;
    b oYD;
    public PrivilegeInfo oYE;
    com.kascend.chushou.widget.a.b oYG;
    private KPSwitchRootRelativeLayout oYI;
    private FrameLayout oYJ;
    private ImageView oYK;
    private LinearLayout oYL;
    private com.kascend.chushou.toolkit.d oYM;
    com.kascend.chushou.view.b.a.a oYN;
    private FrescoThumbnailView oYQ;
    private FrameLayout oYR;
    public com.kascend.chushou.player.feedback.a oYZ;
    private a oZb;
    private CSTVWifiReceiver oZc;
    private boolean B = true;
    private boolean C = false;
    private Uri oYw = null;
    private tv.chushou.common.player.a oYx = null;
    public tv.chushou.common.player.a oYy = null;
    public tv.chushou.common.player.a oYz = null;
    public boolean d = false;
    public boolean e = false;
    private e oYB = null;
    private boolean H = false;
    private com.kascend.chushou.view.user.b oYC = null;
    private boolean J = false;
    private boolean K = false;
    private boolean L = false;
    private boolean M = false;
    private long N = 0;
    private int O = 0;
    public boolean g = false;
    private ImageView T = null;
    private TextView U = null;
    private AnimationImageView oYF = null;
    private View cal = null;
    public boolean j = false;
    public float k = 0.0f;
    public float l = 0.0f;
    public boolean m = false;
    public AudioManager oYH = null;
    private d.a oYO = new d.a() { // from class: com.kascend.chushou.player.VideoPlayer.1
        @Override // com.kascend.chushou.toolkit.d.a
        public void a() {
            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.oZd != null) {
                VideoPlayer.this.oZd.Ry(4);
            }
        }
    };
    private boolean ae = false;
    public boolean q = true;
    public long r = -1;
    public long s = -1;
    private PowerManager.WakeLock oYP = null;
    public String t = null;
    private final com.kascend.chushou.player.ui.h5.redpacket.a oYS = new com.kascend.chushou.player.ui.h5.redpacket.a(this);
    private final com.kascend.chushou.player.ui.h5.b.b oYT = new com.kascend.chushou.player.ui.h5.b.b(this);
    private final com.kascend.chushou.player.ui.h5.d.a oYU = new com.kascend.chushou.player.ui.h5.d.a(this);
    private final com.kascend.chushou.player.ui.a.a oYV = new com.kascend.chushou.player.ui.a.a(this);
    private final com.kascend.chushou.player.e.a oYW = new com.kascend.chushou.player.e.a();
    private final com.kascend.chushou.player.ui.h5.a.a oYX = new com.kascend.chushou.player.ui.h5.a.a(this);
    private String oYY = "1";
    private String aq = "2";
    private io.reactivex.disposables.a oZa = new io.reactivex.disposables.a();
    private tv.chushou.zues.c oZd = new tv.chushou.zues.c(new Handler.Callback() { // from class: com.kascend.chushou.player.VideoPlayer.6
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            try {
                if (!VideoPlayer.this.isFinishing()) {
                    switch (message.what) {
                        case 1:
                            VideoPlayer.this.oZd.removeMessages(1);
                            com.kascend.chushou.c.c.eqe().a(VideoPlayer.this.P, VideoPlayer.this.oYD != null ? VideoPlayer.this.oYD.h : null, System.currentTimeMillis());
                            VideoPlayer.this.oZd.E(1, VideoPlayer.A);
                            break;
                        case 2:
                            VideoPlayer.this.a(true, (Uri) null, false);
                            break;
                        case 3:
                            VideoPlayer.this.S();
                            break;
                        case 4:
                            if (VideoPlayer.this.oYB != null) {
                                VideoPlayer.this.oYB.a(true);
                            }
                            if (VideoPlayer.this.oYM != null) {
                                VideoPlayer.this.oYM.d();
                                VideoPlayer.this.oYM = null;
                                break;
                            }
                            break;
                        case 5:
                            int i = message.arg1;
                            if (i == 1) {
                                if (VideoPlayer.this.oYB != null) {
                                    VideoPlayer.this.oYB.p();
                                    break;
                                }
                            } else if (i == 2 && VideoPlayer.this.oYB != null) {
                                VideoPlayer.this.oYB.e(message.arg2);
                                break;
                            }
                            break;
                        case 6:
                            if (!com.kascend.chushou.b.eqb().f4064a && !com.kascend.chushou.b.eqb().b && VideoPlayer.this.oYB != null) {
                                VideoPlayer.this.oYB.g(true);
                                break;
                            } else {
                                VideoPlayer.this.c();
                                break;
                            }
                            break;
                        case 7:
                            tv.chushou.zues.utils.e.d(VideoPlayer.this.v, "MSG_BUFFER_DEALY: ");
                            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.oYB != null && VideoPlayer.this.M && !VideoPlayer.this.e) {
                                VideoPlayer.this.oYB.h(true);
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
    private boolean oZe = false;
    private boolean aw = true;
    private boolean oZf = false;
    private tv.chushou.common.player.b oZg = new tv.chushou.common.player.b() { // from class: com.kascend.chushou.player.VideoPlayer.14
        @Override // tv.chushou.common.player.b
        public void eqK() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerACallback onSetVideoViewLayout");
            if (!VideoPlayer.this.isFinishing()) {
                if ((VideoPlayer.this.oYB == null || !VideoPlayer.this.oYB.H) && VideoPlayer.this.oYB != null && !VideoPlayer.this.d) {
                    VideoPlayer.this.oYB.y();
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void Qd(int i) {
            if (!VideoPlayer.this.isFinishing()) {
                if ((VideoPlayer.this.oYB == null || !VideoPlayer.this.oYB.H) && VideoPlayer.this.oYB != null && !VideoPlayer.this.d) {
                    VideoPlayer.this.oYB.g(i);
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void eqL() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerACallback onCompletePlayback");
            if (!VideoPlayer.this.isFinishing()) {
                if (!h.isEmpty(VideoPlayer.this.P)) {
                    j.eqp().a(VideoPlayer.this.P, 0);
                }
                VideoPlayer.this.K = false;
                if (VideoPlayer.this.oZd != null) {
                    VideoPlayer.this.oZd.removeMessages(1);
                }
                if ((VideoPlayer.this.oYB == null || !VideoPlayer.this.oYB.H) && VideoPlayer.this.oYB != null && !VideoPlayer.this.d) {
                    VideoPlayer.this.oZd.removeMessages(7);
                    VideoPlayer.this.M = false;
                    VideoPlayer.this.oYB.z();
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void eqM() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerACallback onVideoRenderingStart");
            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.oYB != null) {
                VideoPlayer.this.oYB.G();
            }
        }

        @Override // tv.chushou.common.player.b
        public void eqN() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerACallback onPreparedPlayback");
            if (!VideoPlayer.this.isFinishing()) {
                if (VideoPlayer.this.oYB == null || !VideoPlayer.this.oYB.H) {
                    VideoPlayer.this.oZd.removeMessages(6);
                    VideoPlayer.this.N = 0L;
                    VideoPlayer.this.O = 0;
                    if (VideoPlayer.this.oYx != null && VideoPlayer.this.oYB != null) {
                        VideoPlayer.this.oYx.setVolume(VideoPlayer.this.oYB.J, VideoPlayer.this.oYB.J);
                    }
                    if (VideoPlayer.this.oYD != null) {
                        VideoPlayer.this.K = false;
                        FullRoomInfo eqU = VideoPlayer.this.eqx() ? null : VideoPlayer.this.oYD.eqU();
                        if (VideoPlayer.this.L || eqU != null) {
                            if (VideoPlayer.this.oYD.e) {
                                VideoPlayer.this.oYD.e = false;
                                VideoPlayer.this.oYD.d = !VideoPlayer.this.oYD.d;
                            }
                            if (VideoPlayer.this.oYB != null) {
                                VideoPlayer.this.c("1", (String) null);
                                if (!VideoPlayer.this.d) {
                                    VideoPlayer.this.oYB.i(true);
                                } else if (VideoPlayer.this.e) {
                                    VideoPlayer.this.e = false;
                                    VideoPlayer.this.oYB.B();
                                }
                            }
                        }
                    }
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void Qe(int i) {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerACallback onErrorAppeared");
            if (!VideoPlayer.this.isFinishing()) {
                VideoPlayer.this.c();
                VideoPlayer.this.K = false;
                if (VideoPlayer.this.oZd != null) {
                    VideoPlayer.this.oZd.removeMessages(7);
                }
                if (VideoPlayer.this.oZd != null) {
                    VideoPlayer.this.oZd.removeMessages(1);
                }
                if ((VideoPlayer.this.oYB == null || !VideoPlayer.this.oYB.H) && !VideoPlayer.this.eqr()) {
                    if (!"10004".equals(VideoPlayer.this.t)) {
                        if (VideoPlayer.this.oYB != null) {
                            if (VideoPlayer.this.d) {
                                VideoPlayer.this.oYy.stop();
                                VideoPlayer.this.oYy.release();
                                VideoPlayer.this.e = false;
                                VideoPlayer.this.oYB.C();
                            }
                            if (!com.kascend.chushou.b.eqb().f4064a && !com.kascend.chushou.b.eqb().b) {
                                VideoPlayer.this.oYB.g(true);
                            } else if (VideoPlayer.this.d) {
                                VideoPlayer.this.oYB.a(i, true);
                            } else {
                                VideoPlayer.this.oYB.a(i, false);
                            }
                            VideoPlayer.this.c("2", (String) null);
                            return;
                        }
                        return;
                    }
                    eqL();
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void eqO() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerACallback onBufferingStart");
            if (!VideoPlayer.this.isFinishing()) {
                if ((VideoPlayer.this.oYB == null || !VideoPlayer.this.oYB.H) && VideoPlayer.this.oYB != null && !VideoPlayer.this.d) {
                    VideoPlayer.this.oYB.E();
                    VideoPlayer.this.M = true;
                    long currentTimeMillis = System.currentTimeMillis();
                    VideoPlayer.this.oZd.removeMessages(7);
                    if (!VideoPlayer.this.g) {
                        VideoPlayer.y(VideoPlayer.this);
                    }
                    tv.chushou.zues.utils.e.d(VideoPlayer.this.v, "currentTime: -- >" + currentTimeMillis + "  bufferTime-->" + VideoPlayer.this.N + "  bufferCount-->" + VideoPlayer.this.O);
                    if (currentTimeMillis - VideoPlayer.this.N >= 20000 || VideoPlayer.this.O < 2 || VideoPlayer.this.oYB.H) {
                        if (VideoPlayer.this.O == 1) {
                            VideoPlayer.this.N = currentTimeMillis;
                        }
                        VideoPlayer.this.oZd.E(7, 5000L);
                    } else {
                        VideoPlayer.this.oZd.Ry(7);
                    }
                    if (VideoPlayer.this.g) {
                        VideoPlayer.this.g = false;
                    }
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void eqP() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerACallback onBufferingEnd");
            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.oYB != null && !VideoPlayer.this.d) {
                VideoPlayer.this.oZd.removeMessages(7);
                VideoPlayer.this.M = false;
                if (VideoPlayer.this.oYB == null || !VideoPlayer.this.oYB.H) {
                    if (VideoPlayer.this.oYx == null) {
                        VideoPlayer.this.oYB.a(false, true, false);
                    } else {
                        VideoPlayer.this.oYB.a(true, VideoPlayer.this.oYx.getPlayState() == 4, VideoPlayer.this.oYx.getPlayState() == 5);
                    }
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void onPlayerStart() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerACallback onPlayerStart");
            if (!VideoPlayer.this.isFinishing()) {
                if (VideoPlayer.this.oYB == null || !VideoPlayer.this.oYB.H) {
                    if (VideoPlayer.this.oYB != null && !VideoPlayer.this.d) {
                        if (VideoPlayer.this.oYx != null) {
                            VideoPlayer.this.oYB.F();
                            VideoPlayer.this.oYB.a(true, VideoPlayer.this.oYx.getPlayState() == 4, VideoPlayer.this.oYx.getPlayState() == 5);
                        } else {
                            VideoPlayer.this.oYB.a(false, true, false);
                        }
                    }
                    if (VideoPlayer.this.oZd != null && !VideoPlayer.this.eqx()) {
                        VideoPlayer.this.oZd.removeMessages(1);
                        VideoPlayer.this.oZd.E(1, VideoPlayer.A);
                    }
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void eqQ() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerACallback onPlayerPause");
            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.oZd != null) {
                VideoPlayer.this.oZd.removeMessages(1);
            }
        }

        @Override // tv.chushou.common.player.b
        public void eqR() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerACallback onPlayerStop");
            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.eqx() && VideoPlayer.this.oYy != null && !h.isEmpty(VideoPlayer.this.P) && VideoPlayer.this.oYy.getCurrentPos() > 0) {
                j.eqp().a(VideoPlayer.this.P, VideoPlayer.this.oYy.getCurrentPos());
            }
        }
    };
    private tv.chushou.common.player.b oZh = new tv.chushou.common.player.b() { // from class: com.kascend.chushou.player.VideoPlayer.15
        @Override // tv.chushou.common.player.b
        public void eqK() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerBCallback onSetVideoViewLayout");
            if (!VideoPlayer.this.isFinishing()) {
                if ((VideoPlayer.this.oYB == null || !VideoPlayer.this.oYB.H) && VideoPlayer.this.oYB != null && VideoPlayer.this.d) {
                    VideoPlayer.this.oYB.y();
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void Qd(int i) {
            if (!VideoPlayer.this.isFinishing()) {
                if ((VideoPlayer.this.oYB == null || !VideoPlayer.this.oYB.H) && VideoPlayer.this.oYB != null && VideoPlayer.this.d) {
                    VideoPlayer.this.oYB.g(i);
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void eqL() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerBCallback onCompletePlayback");
            if (!VideoPlayer.this.isFinishing()) {
                if (!h.isEmpty(VideoPlayer.this.P)) {
                    j.eqp().a(VideoPlayer.this.P, 0);
                }
                VideoPlayer.this.K = false;
                if (VideoPlayer.this.oZd != null) {
                    VideoPlayer.this.oZd.removeMessages(1);
                }
                if ((VideoPlayer.this.oYB == null || !VideoPlayer.this.oYB.H) && VideoPlayer.this.oYB != null && VideoPlayer.this.d) {
                    VideoPlayer.this.oZd.removeMessages(7);
                    VideoPlayer.this.M = false;
                    VideoPlayer.this.oYB.z();
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void eqM() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerBCallback onVideoRenderingStart");
            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.oYB != null) {
                VideoPlayer.this.oYB.G();
            }
        }

        @Override // tv.chushou.common.player.b
        public void eqN() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerBCallback onPreparedPlayback");
            if (!VideoPlayer.this.isFinishing()) {
                if (VideoPlayer.this.oYB == null || !VideoPlayer.this.oYB.H) {
                    VideoPlayer.this.oZd.removeMessages(6);
                    VideoPlayer.this.N = 0L;
                    VideoPlayer.this.O = 0;
                    if (VideoPlayer.this.oYx != null && VideoPlayer.this.oYB != null) {
                        VideoPlayer.this.oYx.setVolume(VideoPlayer.this.oYB.J, VideoPlayer.this.oYB.J);
                    }
                    if (VideoPlayer.this.oYD != null) {
                        VideoPlayer.this.K = false;
                        FullRoomInfo eqU = VideoPlayer.this.eqx() ? null : VideoPlayer.this.oYD.eqU();
                        if (VideoPlayer.this.L || eqU != null) {
                            if (VideoPlayer.this.oYD.e) {
                                VideoPlayer.this.oYD.e = false;
                                VideoPlayer.this.oYD.d = !VideoPlayer.this.oYD.d;
                            }
                            if (VideoPlayer.this.oYB != null) {
                                VideoPlayer.this.c("1", (String) null);
                                if (VideoPlayer.this.d) {
                                    VideoPlayer.this.oYB.i(true);
                                } else if (VideoPlayer.this.e) {
                                    VideoPlayer.this.e = false;
                                    VideoPlayer.this.oYB.B();
                                }
                            }
                        }
                    }
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void Qe(int i) {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerBCallback onErrorAppeared");
            if (!VideoPlayer.this.isFinishing()) {
                VideoPlayer.this.c();
                VideoPlayer.this.K = false;
                if (VideoPlayer.this.oZd != null) {
                    VideoPlayer.this.oZd.removeMessages(7);
                }
                if (VideoPlayer.this.oZd != null) {
                    VideoPlayer.this.oZd.removeMessages(1);
                }
                if ((VideoPlayer.this.oYB == null || !VideoPlayer.this.oYB.H) && !VideoPlayer.this.eqr()) {
                    if (!"10004".equals(VideoPlayer.this.t)) {
                        if (VideoPlayer.this.oYB != null) {
                            if (!VideoPlayer.this.d) {
                                VideoPlayer.this.oYz.stop();
                                VideoPlayer.this.oYz.release();
                                VideoPlayer.this.oYB.C();
                                VideoPlayer.this.e = false;
                            }
                            if (!com.kascend.chushou.b.eqb().f4064a && !com.kascend.chushou.b.eqb().b) {
                                VideoPlayer.this.oYB.g(true);
                            } else if (VideoPlayer.this.d) {
                                VideoPlayer.this.oYB.a(i, false);
                            } else {
                                VideoPlayer.this.oYB.a(i, true);
                            }
                            VideoPlayer.this.c("2", (String) null);
                            return;
                        }
                        return;
                    }
                    eqL();
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void eqO() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerBCallback onBufferingStart");
            if (!VideoPlayer.this.isFinishing()) {
                if ((VideoPlayer.this.oYB == null || !VideoPlayer.this.oYB.H) && VideoPlayer.this.oYB != null && VideoPlayer.this.d) {
                    VideoPlayer.this.oYB.E();
                    VideoPlayer.this.M = true;
                    VideoPlayer.this.oZd.removeMessages(7);
                    long currentTimeMillis = System.currentTimeMillis();
                    if (!VideoPlayer.this.g) {
                        VideoPlayer.y(VideoPlayer.this);
                    }
                    tv.chushou.zues.utils.e.d(VideoPlayer.this.v, "currentTime: -- >" + currentTimeMillis + "  bufferTime-->" + VideoPlayer.this.N + "  bufferCount-->" + VideoPlayer.this.O);
                    if (currentTimeMillis - VideoPlayer.this.N >= 20000 || VideoPlayer.this.O < 2 || VideoPlayer.this.oYB.H) {
                        if (VideoPlayer.this.O == 1) {
                            VideoPlayer.this.N = currentTimeMillis;
                        }
                        VideoPlayer.this.oZd.E(7, 5000L);
                    } else {
                        VideoPlayer.this.N = 0L;
                        VideoPlayer.this.O = 0;
                        VideoPlayer.this.oZd.Ry(7);
                    }
                    if (VideoPlayer.this.g) {
                        VideoPlayer.this.g = false;
                    }
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void eqP() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerBCallback onBufferingEnd");
            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.oYB != null && VideoPlayer.this.d) {
                VideoPlayer.this.M = false;
                VideoPlayer.this.oZd.removeMessages(7);
                if (VideoPlayer.this.oYB == null || !VideoPlayer.this.oYB.H) {
                    if (VideoPlayer.this.oYx == null) {
                        VideoPlayer.this.oYB.a(false, true, false);
                    } else {
                        VideoPlayer.this.oYB.a(true, VideoPlayer.this.oYx.getPlayState() == 4, VideoPlayer.this.oYx.getPlayState() == 5);
                    }
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void onPlayerStart() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerBCallback onPlayerStart");
            if (!VideoPlayer.this.isFinishing()) {
                if (VideoPlayer.this.oYB == null || !VideoPlayer.this.oYB.H) {
                    if (VideoPlayer.this.oYB != null && VideoPlayer.this.d) {
                        if (VideoPlayer.this.oYx != null) {
                            VideoPlayer.this.oYB.F();
                            VideoPlayer.this.oYB.a(true, VideoPlayer.this.oYx.getPlayState() == 4, VideoPlayer.this.oYx.getPlayState() == 5);
                        } else {
                            VideoPlayer.this.oYB.a(false, true, false);
                        }
                    }
                    if (VideoPlayer.this.oZd != null && !VideoPlayer.this.eqx()) {
                        VideoPlayer.this.oZd.removeMessages(1);
                        VideoPlayer.this.oZd.E(1, VideoPlayer.A);
                    }
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void eqQ() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerBCallback onPlayerPause");
            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.oZd != null) {
                VideoPlayer.this.oZd.removeMessages(1);
            }
        }

        @Override // tv.chushou.common.player.b
        public void eqR() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerBCallback onPlayerStop");
            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.eqx() && VideoPlayer.this.oYz != null && !h.isEmpty(VideoPlayer.this.P) && VideoPlayer.this.oYz.getCurrentPos() > 0) {
                j.eqp().a(VideoPlayer.this.P, VideoPlayer.this.oYz.getCurrentPos());
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
        this.oYw = intent.getData();
        if (this.oYw == null) {
            finish();
            return;
        }
        com.kascend.chushou.d.e.j();
        if (this.oZc == null) {
            this.oZc = new CSTVWifiReceiver();
            registerReceiver(this.oZc, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        }
        com.kascend.chushou.toolkit.d.a.esr().b();
        tv.chushou.zues.utils.e.i(this.v, "intent.getData=" + this.oYw.toString());
        String scheme = this.oYw.getScheme();
        if (scheme == null || !scheme.equals("chushou")) {
            tv.chushou.zues.utils.e.e(this.v, "not support scheme :" + scheme);
            finish();
            return;
        }
        a(intent);
    }

    private void a(Intent intent) {
        this.P = this.oYw.getQueryParameter("roomId");
        this.Q = this.P;
        this.S = this.oYw.getQueryParameter(WebSocketRequest.PARAM_KEY_PROTOCOLS);
        this.aq = this.oYw.getQueryParameter("liveType");
        if ("2".equals(this.aq) || "3".equals(this.aq) || "4".equals(this.aq)) {
            this.oYY = "2";
            this.oYZ = new com.kascend.chushou.player.feedback.a();
            if (this.oYZ.php != null) {
                this.oYZ.php.reset();
                this.oYZ.php.roomId = this.P;
                this.oYZ.php.enterType = 1;
                this.oYZ.b = System.currentTimeMillis();
            }
        }
        if (h.isEmpty(this.P) || h.isEmpty(this.S)) {
            tv.chushou.zues.utils.e.e(this.v, "invalid param mItemID=" + this.P + " protocols=" + this.S);
            finish();
            return;
        }
        if (com.kascend.chushou.b.eqb().d == -1) {
            com.kascend.chushou.b.eqb().d = com.kascend.chushou.d.g.b() ? 1 : 0;
        }
        this.oYP = ((PowerManager) getSystemService("power")).newWakeLock(536870938, this.v);
        this.oYP.acquire();
        this.oYD = new b(this.P);
        this.oYD.d = intent.getBooleanExtra("room_play_audio", false);
        this.oYG = new com.kascend.chushou.widget.a.b();
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
        this.oYI = (KPSwitchRootRelativeLayout) findViewById(a.f.rlRoot);
        if (!"2".equals(this.oYY) && com.kascend.chushou.b.eqb().d == 1) {
            this.oYI.setFitsSystemWindows(true);
        }
        this.oYJ = (FrameLayout) this.oYI.findViewById(a.f.fl_fragment);
        this.cal = this.oYI.findViewById(a.f.rl_empty);
        this.T = (ImageView) this.cal.findViewById(a.f.iv_empty);
        this.U = (TextView) this.cal.findViewById(a.f.tv_empty);
        this.oYL = (LinearLayout) this.oYI.findViewById(a.f.rl_title);
        this.oYK = (ImageView) this.oYL.findViewById(a.f.back_icon);
        this.oYK.setOnClickListener(new View.OnClickListener() { // from class: com.kascend.chushou.player.VideoPlayer.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayer.this.finish();
            }
        });
        this.oYF = (AnimationImageView) this.cal.findViewById(a.f.iv_loading);
        this.oYQ = (FrescoThumbnailView) this.oYI.findViewById(a.f.live_cover);
        this.oYR = (FrameLayout) this.oYI.findViewById(a.f.fl_cover);
        this.k = eqq();
        try {
            this.oYH = (AudioManager) getApplicationContext().getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
            n = this.oYH.getStreamVolume(3);
            this.oYH.requestAudioFocus(null, 3, 1);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (this.B) {
            a(1, eqx() ? "3" : "1");
        } else {
            r();
        }
        if (com.kascend.chushou.b.eqb().b && !com.kascend.chushou.b.eqb().f4064a) {
            RxExecutor.postDelayed(this.oZa, EventThread.MAIN_THREAD, 60L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.VideoPlayer.5
                @Override // java.lang.Runnable
                public void run() {
                    if (!VideoPlayer.this.isFinishing() && com.kascend.chushou.b.eqb().b && !com.kascend.chushou.b.eqb().f4064a) {
                        tv.chushou.zues.utils.g.d(VideoPlayer.this.w, VideoPlayer.this.getString(a.i.str_monet_notify));
                    }
                }
            });
        }
        com.kascend.chushou.c.c.eqe().a(this.P, stringExtra, System.currentTimeMillis());
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
        if (this.oZb == null) {
            this.oZb = new a();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(VideoReceiver.ACTION_VOLUME_CHANGED);
            registerReceiver(this.oZb, intentFilter);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        j(false);
        if (this.oZb != null) {
            unregisterReceiver(this.oZb);
            this.oZb = null;
        }
        super.onStop();
    }

    @Override // com.kascend.chushou.view.base.BaseActivity
    protected void a(boolean z) {
        if (this.oYB != null) {
            this.oYB.k(z);
        }
    }

    @Subscribe
    public void onHideGiftEffectEvent(com.kascend.chushou.b.a.a.f fVar) {
        if (fVar.b) {
            this.oYB.k();
            return;
        }
        this.oYB.m();
        this.oYB.l();
    }

    private float eqq() {
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
            this.oYD.h = jSONObject.toString();
            String optString = jSONObject.optString("_thumb");
            jSONObject.optBoolean("tag_from_game_mic", false);
            if (!h.isEmpty(optString)) {
                this.ab = optString;
            }
        } catch (JSONException e) {
            e.printStackTrace();
            this.oYD.h = str;
        }
        if (eqx()) {
            a(this.P, str);
            bm(this.P, z);
            return;
        }
        f4087a = this.P;
        b(this.P, str);
        a(this.P, eqH(), z);
        w();
    }

    private void O() {
        this.m = true;
        j();
        if (this.oYB != null) {
            this.oYB.r();
        }
        s();
    }

    @Subscribe
    public void onStartRoomEvent(o oVar) {
        if (!isFinishing() && oVar.oYe != null && oVar.c != null && !h.isEmpty(oVar.oYe.mTargetKey)) {
            if (oVar.c != this) {
                tv.chushou.zues.utils.e.e(this.v, "different player!");
                return;
            }
            if (this.oYD != null) {
                this.oYD.a();
                this.oYD.f4117a = oVar.oYe.mTargetKey;
                this.oYD.d = oVar.d;
                if (this.oYD.pac != null) {
                    this.oYD.pac.e();
                }
                if (this.oYD.pac != null) {
                    this.oYD.pac.b();
                }
                this.oYD.pag = null;
                this.oYD.paf = null;
                this.oYD.paj = null;
                this.oYD.pai = null;
                this.oYD.pam = null;
                this.oYD.pak = null;
                this.oYD.pal = null;
            }
            if (this.oYH != null) {
                n = this.oYH.getStreamVolume(3);
            }
            if (!h.isEmpty(oVar.oYe.mType) && oVar.oYe.mType.equals("3")) {
                this.B = false;
                this.oYY = "1";
                r();
                this.P = oVar.oYe.mTargetKey;
                this.R = "3";
                if (this.oYG != null) {
                    this.oYG.a();
                }
                if (this.oYD != null) {
                    this.oYD.a((PlayUrl) null);
                    this.oYD.f();
                    if (this.oYD.c() != null) {
                        this.oYD.c().clear();
                    }
                    this.oYD.i.clear();
                }
                if (this.oYB != null) {
                    this.oYB.j();
                }
                s();
                if (this.oYM != null) {
                    this.oYM.d();
                    this.oYM = null;
                }
                if (this.oZa != null) {
                    this.oZa.dispose();
                    this.oZa = new io.reactivex.disposables.a();
                }
                a(oVar.e, false);
                return;
            }
            boolean z = this.R != null && this.R.equals("1");
            this.R = "1";
            this.oYV.a();
            this.oYU.a();
            this.oYT.a();
            this.oYS.c();
            this.oYX.a();
            if (this.oZa != null) {
                this.oZa.dispose();
                this.oZa = new io.reactivex.disposables.a();
            }
            if ("1".equals(oVar.f)) {
                this.H = false;
                if (this.oYD != null && !h.isEmpty(this.oYD.t)) {
                    this.oYD.t.clear();
                }
                this.ab = oVar.oYe.mCover;
                this.oYR.setVisibility(0);
                this.oYQ.setBlur(true);
                this.oYQ.j(oVar.oYe.mCover, 0, 0, 0);
            }
            if (!oVar.oYe.mTargetKey.equals(this.P)) {
                this.aq = oVar.g;
                if (!z) {
                    this.B = false;
                    r();
                } else if (!"2".equals(this.oYY) && ("2".equals(this.aq) || "3".equals(this.aq) || "4".equals(this.aq))) {
                    this.oYY = "2";
                    this.oYZ = new com.kascend.chushou.player.feedback.a();
                    if (this.oYZ.php != null) {
                        this.oYZ.php.reset();
                        this.oYZ.php.roomId = oVar.oYe.mTargetKey;
                        this.oYZ.php.enterType = 1;
                        this.oYZ.b = System.currentTimeMillis();
                    }
                }
                this.B = false;
                this.P = oVar.oYe.mTargetKey;
                this.Q = this.P;
                this.ab = oVar.oYe.mCover;
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
                JSONObject O = com.kascend.chushou.d.e.O("_fromView", str, "_sc", oVar.oYe.mSC);
                com.kascend.chushou.toolkit.a.c.a(this.w, O);
                if (this.oYG != null) {
                    this.oYG.a();
                    this.oYG.a(this.P);
                }
                if (this.oYD != null) {
                    this.oYD.a((PlayUrl) null);
                    this.oYD.f();
                    if (this.oYD.c() != null) {
                        this.oYD.c().clear();
                    }
                    this.oYD.i.clear();
                }
                if (this.oYB != null) {
                    this.oYB.j();
                }
                a(O.toString(), false);
                return;
            }
            tv.chushou.zues.utils.g.RH(a.i.str_same_room);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean eqr() {
        FullRoomInfo eqU;
        String str;
        RoomInfo roomInfo;
        if (eqx()) {
            str = null;
            eqU = null;
        } else {
            eqU = this.oYD.eqU();
            str = (eqU == null || (roomInfo = eqU.mRoominfo) == null) ? null : roomInfo.mGameId;
        }
        return !this.L && (eqU == null || h.isEmpty(str));
    }

    @Subscribe
    public void onMessageEvent(i iVar) {
        if (!isFinishing() && iVar.f4071a != 21 && iVar.f4071a != 22) {
            if (iVar.f4071a == 0 && (iVar.b instanceof Boolean)) {
                if (((Boolean) iVar.b).booleanValue() && !isFinishing()) {
                    w();
                    if (this.oYB != null) {
                        this.oYB.f();
                    }
                }
            } else if (iVar.f4071a == 46) {
                if ((iVar.b instanceof String) && this.oYB != null) {
                    this.oYB.c((String) iVar.b);
                }
            } else if (iVar.f4071a == 54) {
                if (iVar.b instanceof String) {
                    this.oYT.a((String) iVar.b);
                }
            } else if (iVar.f4071a == 55) {
                if (this.oYB != null) {
                    this.oYB.O();
                }
            } else if (iVar.f4071a == 56 && this.oYB != null) {
                this.oYB.P();
            }
        }
    }

    @Subscribe
    public void onRefreshSubscribeEvent(m mVar) {
        if (isFinishing() && this.oYD != null && this.oYD.eqW() != null) {
            RoomInfo eqW = this.oYD.eqW();
            if (mVar.a(eqW.mCreatorUID, eqW.mRoomID)) {
                eqW.mIsSubscribed = mVar.c;
            }
        }
    }

    @Subscribe
    public void onPlayerEvent(k kVar) {
        if (kVar.f4073a == 1 && !isFinishing()) {
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
        if (this.m || this.oYy == null || this.oYz == null) {
            R();
        }
        if (this.oYG != null) {
            this.oYG.d();
        }
        if (!eqx()) {
            if (this.oYM != null && !this.oYM.c()) {
                this.oYM.a();
            }
            v();
            if (this.oYD != null && this.oYD.eqU() != null && this.oYD.eqU().cycleLiveRoomInfo != null && !h.isEmpty(this.oYD.eqU().cycleLiveRoomInfo.roomId)) {
                u();
            }
        }
        super.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.view.base.BaseActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        tv.chushou.zues.utils.e.e(this.v, MissionEvent.MESSAGE_DESTROY);
        if (this.oYD != null && this.oYD.eqU() != null && this.oYD.eqU().cycleLiveRoomInfo != null && !h.isEmpty(this.oYD.eqU().cycleLiveRoomInfo.eventName)) {
            j.eqp().a(this.P + eqH());
        }
        if ("2".equals(this.oYY) && this.oYZ != null && this.oYZ.php != null) {
            this.oYZ.php.time = System.currentTimeMillis() - this.oYZ.b;
            this.oYZ.a();
            this.oYZ.b();
        }
        this.oYS.d();
        this.oYT.b();
        this.oYU.b();
        O();
        this.ag = null;
        f4087a = null;
        if (this.oZd != null) {
            this.oZd.cs(null);
            this.oZd = null;
        }
        if (this.oYM != null) {
            this.oYM.d();
            this.oYM = null;
        }
        if (this.oYG != null) {
            this.oYG.c();
            this.oYG = null;
        }
        if (this.oYD != null) {
            this.oYD.pag = null;
            this.oYD.paf = null;
        }
        if (this.oYD != null) {
            this.oYD.b();
            this.oYD = null;
        }
        this.oYw = null;
        this.oYB = null;
        this.oYC = null;
        this.oYE = null;
        this.T = null;
        this.U = null;
        this.oYF = null;
        this.cal = null;
        this.oYH = null;
        this.oYI = null;
        this.oYJ = null;
        this.oYK = null;
        this.oYL = null;
        if (this.oYP != null && this.oYP.isHeld()) {
            this.oYP.release();
            this.oYP = null;
        }
        if (this.oZc != null) {
            unregisterReceiver(this.oZc);
            this.oZc = null;
        }
        h.eEd();
        tv.chushou.zues.a.a.ct(this);
        this.oZa.dispose();
        this.oYU.b();
        this.oYV.b();
        this.oYS.d();
        this.oYT.b();
        this.oYX.b();
        super.onDestroy();
        System.gc();
    }

    @Subscribe
    public void onSendGameGiftEvent(n nVar) {
        if (!isFinishing() && this.oYB != null) {
            this.oYB.a(nVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.view.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        tv.chushou.zues.utils.e.d(this.v, MissionEvent.MESSAGE_PAUSE);
        if (this.oYM != null) {
            this.oYM.b();
        }
        if (this.oYG != null) {
            this.oYG.b(false);
        }
        k();
        this.m = true;
        super.onPause();
    }

    @Override // android.app.Activity
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.oYB != null ? this.oYB.a(motionEvent) : super.onTouchEvent(motionEvent);
    }

    public void c() {
        if ("1".equals(this.R)) {
            j.eqp().a(this.P + eqH());
        } else {
            j.eqp().b(this.P);
        }
    }

    private void a(boolean z, boolean z2) {
        int i = 0;
        tv.chushou.zues.utils.e.i(this.v, "startLoadingVideo <------------- mbPrepareingVideo = " + this.K);
        if (this.oYy != null) {
            this.oYy.setHardwearDecod(com.kascend.chushou.d.h.eqj().f4085a);
        }
        if (this.oYz != null) {
            this.oYz.setHardwearDecod(com.kascend.chushou.d.h.eqj().f4085a);
        }
        if (this.oYx != null) {
            this.oYx.setHardwearDecod(com.kascend.chushou.d.h.eqj().f4085a);
        }
        if (!this.K) {
            if (z && this.oYB != null) {
                if (!z2) {
                    this.t = null;
                    this.oYB.e();
                }
            } else if (this.oYB != null && !z2) {
                this.t = null;
                this.oYB.H = false;
                RxExecutor.post(null, EventThread.MAIN_THREAD, new Runnable() { // from class: com.kascend.chushou.player.VideoPlayer.7
                    @Override // java.lang.Runnable
                    public void run() {
                        VideoPlayer.this.oYB.x();
                    }
                });
            }
            this.K = true;
            if (this.oYD != null && this.oYD.eqV() != null) {
                PlayUrl eqV = this.oYD.eqV();
                while (true) {
                    int i2 = i;
                    if (i2 >= eqV.mUrlDetails.size()) {
                        break;
                    }
                    UrlDetails urlDetails = eqV.mUrlDetails.get(i2);
                    if (urlDetails.mUrl.equals(eqV.mSelectedUrl)) {
                        String str = eqV.mUrlDetails.get(i2).mDefinitionType;
                        String str2 = urlDetails.mBitrate;
                    }
                    i = i2 + 1;
                }
            }
            if (z2) {
                if (this.d) {
                    this.oYy.setVideoURI(this.oYw);
                    this.oYy.open();
                    return;
                }
                this.oYz.setVideoURI(this.oYw);
                this.oYz.open();
                return;
            }
            this.oYx.setVideoURI(this.oYw);
            this.oYx.open();
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        try {
            if (motionEvent.getAction() == 0) {
                if (this.oYB != null && this.oYB.b(motionEvent)) {
                    return true;
                }
                if ("2".equals(this.oYY) && this.oYB != null) {
                    this.oYB.a(motionEvent);
                }
            } else if (this.oYB != null && this.oYB.b(motionEvent)) {
                return true;
            }
            return super.dispatchTouchEvent(motionEvent);
        } catch (Exception e) {
            return false;
        }
    }

    @Override // android.support.v7.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.oYB != null && this.oYB.a(i, keyEvent)) {
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
        if (this.oYD != null && this.oYD.eqU() != null && this.oYD.eqU().cycleLiveRoomInfo != null && !h.isEmpty(this.oYD.eqU().cycleLiveRoomInfo.roomId)) {
            this.oYR.setVisibility(0);
            this.oYQ.setBlur(true);
            this.oYQ.j(this.oYD.eqU().cycleLiveRoomInfo.avatar, 0, 0, 0);
            this.oYQ.setVisibility(0);
            j.eqp().a(this.P + eqH());
            this.oYw = null;
            R();
            this.Q = this.oYD.eqU().cycleLiveRoomInfo.roomId;
            a(this.P, eqH(), false);
        }
    }

    public void b(boolean z) {
        if (this.oYB != null) {
            this.oYB.j(z);
        }
    }

    public void a(boolean z, Uri uri, boolean z2) {
        tv.chushou.zues.utils.e.d(this.v, "loadIfNecessary reload=" + z + " isChangeLines-->" + z2);
        if (this.oYy != null && this.oYz != null) {
            if (uri != null) {
                this.oYw = uri;
            }
            if (z2) {
                this.e = z2;
            }
            this.M = false;
            this.N = 0L;
            this.O = 0;
            this.oZd.removeMessages(7);
            if (z) {
                if (z2) {
                    if (!this.d) {
                        this.oYz.setOnActivityCallBack(this.oZh);
                    } else {
                        this.oYy.setOnActivityCallBack(this.oZg);
                    }
                } else if (this.d) {
                    this.oYz.setOnActivityCallBack(this.oZh);
                } else {
                    this.oYy.setOnActivityCallBack(this.oZg);
                }
                this.K = false;
                b(true, z2);
            } else if (!this.J) {
                b(true, z2);
            }
            this.oZd.E(6, IMConnection.RETRY_DELAY_TIMES);
        }
    }

    private void b(boolean z, boolean z2) {
        VideoPlayInfo R;
        if ("1".equals(this.R)) {
            R = j.eqp().Q(this.P + eqH(), 600000L);
        } else {
            R = j.eqp().R(this.P, 600000L);
        }
        if (R != null) {
            a(z, z2);
        } else if ("1".equals(this.R)) {
            a(this.P, eqH(), false);
        } else {
            bm(this.P, false);
        }
    }

    public tv.chushou.common.player.a eqs() {
        return this.oYx;
    }

    public tv.chushou.common.player.a eqt() {
        return this.oYy;
    }

    public tv.chushou.common.player.a equ() {
        return this.oYz;
    }

    public void a(tv.chushou.common.player.a aVar) {
        this.oYx = aVar;
    }

    public b eqv() {
        return this.oYD;
    }

    public com.kascend.chushou.widget.a.b eqw() {
        return this.oYG;
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
        FullRoomInfo eqU;
        this.r = -1L;
        if (this.s != -1 && this.s != 0) {
            this.r = this.s;
            this.s = -1L;
        }
        if (eqx() && this.oYx != null && this.oYx.getPlayState() == 4) {
            this.r = this.oYx.getCurrentPos();
        }
        this.oZe = false;
        tv.chushou.zues.utils.e.d(this.v, "screenChange()<-----");
        tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard(this);
        if (str != null) {
            this.R = str;
        }
        if (!this.C || !z3 || "3".equals(this.R) || this.oYD == null || (eqU = this.oYD.eqU()) == null || eqU.mRoominfo == null || eqU.mRoominfo.mStyle != 1) {
            z5 = false;
        } else {
            z5 = true;
            i = 0;
        }
        if ("2".equals(this.oYY)) {
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
            if (com.kascend.chushou.b.eqb().d == 1) {
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
            ((VideoPlayer) this.w).As(false);
            ((VideoPlayer) this.w).g(true);
            if (z5) {
                setRequestedOrientation(1);
            } else {
                setRequestedOrientation(6);
            }
            getWindow().addFlags(512);
            getWindow().addFlags(256);
        }
        if (this.oYG == null) {
            this.oYG = new com.kascend.chushou.widget.a.b();
        }
        if (this.oYG != null) {
            this.oYG.a(this.P);
        }
        if (this.R.equals("5")) {
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            if (this.oYB != null) {
                beginTransaction.remove(this.oYB);
                this.oYB = null;
            }
            if (this.oYC != null) {
                beginTransaction.remove(this.oYC);
                this.oYC = null;
            }
            this.oYC = new com.kascend.chushou.view.user.b();
            beginTransaction.add(a.f.fl_fragment, this.oYC);
            beginTransaction.commitAllowingStateLoss();
        } else {
            FragmentTransaction beginTransaction2 = getSupportFragmentManager().beginTransaction();
            if (this.oYB != null) {
                beginTransaction2.remove(this.oYB);
                this.oYB = null;
            }
            if (this.oYC != null) {
                beginTransaction2.remove(this.oYC);
                this.oYC = null;
            }
            if ("2".equals(this.oYY)) {
                this.oYB = com.kascend.chushou.player.e.e.b(this.ab, z2, this.aq, this.P);
            } else if (1 == i) {
                if (!this.R.equals("3")) {
                    if (z4) {
                        v();
                    }
                    this.oYB = new com.kascend.chushou.player.d.a();
                    Bundle bundle = new Bundle();
                    bundle.putString("mCover", this.ab);
                    bundle.putBoolean("mInitViewAsync", z2);
                    this.oYB.setArguments(bundle);
                }
            } else {
                this.oYB = new com.kascend.chushou.player.d.b();
                Bundle bundle2 = new Bundle();
                if (z5) {
                    i = 1;
                }
                bundle2.putInt("mExtraOrientation", i);
                bundle2.putString("mViewType", this.R);
                this.oYB.setArguments(bundle2);
            }
            beginTransaction2.add(a.f.fl_fragment, this.oYB);
            beginTransaction2.commitAllowingStateLoss();
            this.H = true;
        }
        tv.chushou.zues.utils.e.d(this.v, "screenChange()----->");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean eqx() {
        return this.R != null && this.R.equals("3");
    }

    private void R() {
        if (this.oYB != null) {
            this.oYB.pdz = null;
        }
        if (this.oYx != null) {
            this.oYx.release();
            this.oYx = null;
            this.K = false;
        }
        if (this.oYy != null) {
            this.oYy.release();
            this.oYy = null;
        }
        if (this.oYz != null) {
            this.oYz.release();
            this.oYz = null;
        }
        if (this.oYA != null) {
            this.oYA.c();
        }
        this.d = false;
        this.e = false;
        this.M = false;
        this.oYA = new c();
        this.oYy = this.oYA.eqZ();
        this.oYy.setOnActivityCallBack(this.oZg);
        this.oYz = this.oYA.era();
        this.oYz.setOnActivityCallBack(this.oZh);
        if (!this.d) {
            this.oYx = this.oYy;
        } else {
            this.oYx = this.oYz;
        }
        if (this.oYB != null) {
            this.oYB.pdz = this.oYx;
        }
    }

    public void j() {
        if (this.oYx != null) {
            this.oYx.pause();
            this.oYx.stop();
            this.oYx.release();
            this.oYx = null;
        }
        if (this.oYy != null) {
            this.oYy.stop();
            this.oYy.release();
            this.oYy = null;
        }
        if (this.oYz != null) {
            this.oYz.stop();
            this.oYz.release();
            this.oYz = null;
        }
        if (this.oYA != null) {
            this.oYA.c();
        }
    }

    public void k() {
        tv.chushou.common.player.a aVar = this.oYx;
        if (aVar != null) {
            aVar.pause();
            aVar.stop();
        }
        tv.chushou.common.player.a aVar2 = this.oYy;
        if (aVar2 != null) {
            aVar2.stop();
        }
        tv.chushou.common.player.a aVar3 = this.oYz;
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
        if (this.oZe) {
            if (this.oYB != null) {
                this.oYB.s();
            }
        } else if (this.oZd != null) {
            this.oZd.b(this.oZd.RA(3), 20L);
        }
    }

    private void b(final String str, String str2) {
        com.kascend.chushou.c.c.eqe().a(new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.VideoPlayer.8
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
                    VideoPlayer.this.eqF().a(fullRoomInfo.mBangMap);
                    if (h.isEmpty(fullRoomInfo.mRoominfo.mRoomID)) {
                        fullRoomInfo.mRoominfo.mRoomID = VideoPlayer.this.P;
                    }
                    if (!h.isEmpty(fullRoomInfo.mGeneralTabGifts)) {
                        com.kascend.chushou.d.e.a(VideoPlayer.this.oZa, new ArrayList(fullRoomInfo.mGeneralTabGifts));
                    }
                    if (VideoPlayer.this.oYD != null) {
                        VideoPlayer.this.oYD.a(fullRoomInfo);
                    }
                    VideoPlayer.this.L = false;
                    if (VideoPlayer.this.B) {
                        if (VideoPlayer.this.C && !"3".equals(VideoPlayer.this.R) && fullRoomInfo != null && fullRoomInfo.mRoominfo != null && fullRoomInfo.mRoominfo.mStyle == 1 && !h.isEmpty(fullRoomInfo.mRoominfo.mGameId)) {
                            z = true;
                        }
                        if (!z) {
                            if (VideoPlayer.this.oYB != null) {
                                VideoPlayer.this.oYB.a(VideoPlayer.this.oYD);
                            }
                            if (!h.isEmpty(fullRoomInfo.mRoominfo.mGameId)) {
                                VideoPlayer.this.S();
                            } else {
                                if (VideoPlayer.this.oYD != null) {
                                    VideoPlayer.this.oYD.f = null;
                                }
                                VideoPlayer.this.S();
                            }
                        } else {
                            VideoPlayer.this.a(1, "1", true);
                            if (VideoPlayer.this.oYB != null) {
                                VideoPlayer.this.oYB.a(VideoPlayer.this.oYD);
                            }
                        }
                    } else {
                        if (h.isEmpty(fullRoomInfo.mRoominfo.mGameId)) {
                            if (VideoPlayer.this.oYD != null) {
                                VideoPlayer.this.oYD.f = null;
                            }
                            VideoPlayer.this.a(1, "1");
                        } else {
                            VideoPlayer.this.a(1, "1", true);
                        }
                        if (VideoPlayer.this.oYB != null) {
                            VideoPlayer.this.oYB.a(VideoPlayer.this.oYD);
                        }
                    }
                    if (VideoPlayer.this.oYD != null && !VideoPlayer.this.oYD.m()) {
                        if (VideoPlayer.this.oYM != null) {
                            VideoPlayer.this.oYM.d();
                            VideoPlayer.this.oYM = null;
                        }
                        VideoPlayer.this.oYM = new com.kascend.chushou.toolkit.d(900000L, VideoPlayer.this.oYO, VideoPlayer.this.oZd);
                        VideoPlayer.this.oYM.a();
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
        if (this.oYD != null) {
            this.oYD.a((FullRoomInfo) null);
        }
        this.L = false;
        bW(str, i);
        if (this.oYx != null) {
            this.oYx.stop();
        }
        if (this.oYy != null) {
            this.oYy.stop();
        }
        if (this.oYz != null) {
            this.oYz.stop();
        }
    }

    public void l() {
        tv.chushou.zues.utils.e.d(this.v, "retryGetPlayList");
        c();
        if (eqx()) {
            bm(this.P, false);
        } else {
            a(this.P, eqH(), false);
        }
    }

    public void m() {
        a(this.ag, false);
    }

    private void a(final String str, String str2, boolean z) {
        this.J = true;
        VideoPlayInfo Q = j.eqp().Q(str + str2, 600000L);
        if (Q != null) {
            a((ArrayList) Q.mPlayUrls);
            this.J = false;
        } else if (z) {
            ParserRet gY = com.kascend.chushou.player.c.a.erb().gY(str, str2);
            if (gY.mRc != 0) {
                tv.chushou.zues.utils.e.e(this.v, "getPlayUrlSync fail, try to getPlaylist");
                a(str, str2, false);
                return;
            }
            a(gY, str);
        } else {
            com.kascend.chushou.player.c.a.erb().a(str, str2, new a.InterfaceC0974a() { // from class: com.kascend.chushou.player.VideoPlayer.9
                @Override // com.kascend.chushou.player.c.a.InterfaceC0974a
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
    private void bm(final String str, boolean z) {
        boolean equals;
        this.J = true;
        VideoPlayInfo R = j.eqp().R(str, 600000L);
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
                ParserRet bn = com.kascend.chushou.player.c.a.erb().bn(str, equals);
                if (bn.mRc != 0) {
                    tv.chushou.zues.utils.e.e(this.v, "getVideoPlayUrlSync fail, try to getVideoPlaylist");
                    bm(str, false);
                    return;
                }
                a(bn, str);
                return;
            }
            com.kascend.chushou.player.c.a.erb().a(str, new a.InterfaceC0974a() { // from class: com.kascend.chushou.player.VideoPlayer.10
                @Override // com.kascend.chushou.player.c.a.InterfaceC0974a
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
                if (this.oYD.f == null) {
                    this.oYD.f = new ArrayList<>();
                }
                this.oYD.f.clear();
                this.oYD.f.addAll(arrayList);
                if ("1".equals(this.R)) {
                    j.eqp().a(str + eqH(), arrayList);
                } else {
                    j.eqp().s(str, arrayList);
                }
                a(arrayList);
                return;
            }
            if (this.oYD != null) {
                this.oYD.f = null;
            }
            if (this.oZd != null) {
                Message RA = this.oZd.RA(5);
                RA.arg1 = 2;
                RA.arg2 = parserRet.mRc;
                this.oZd.X(RA);
            }
        }
    }

    private void bW(String str, int i) {
        s();
        if (this.oYG != null) {
            this.oYG.a();
        }
        if (h.isEmpty(str)) {
            str = getString(a.i.str_load_data_failed);
        }
        a(str, i);
    }

    public void n() {
        if (this.oYJ != null && this.cal != null && this.oYL != null) {
            this.oYJ.setVisibility(0);
            this.cal.setVisibility(8);
            this.oYL.setVisibility(8);
        }
    }

    public void o() {
        if (this.oYQ != null && this.oYQ.getVisibility() == 0) {
            this.oYQ.DK(0);
            this.oYQ.setVisibility(8);
        }
    }

    public void p() {
        if (this.oYR != null && this.oYR.getVisibility() == 0) {
            this.oYR.setVisibility(8);
        }
    }

    public void q() {
        this.oZe = true;
    }

    protected void r() {
        this.oYJ.setVisibility(8);
        this.oYL.setVisibility(0);
        this.cal.setVisibility(0);
        if (this.oYF != null) {
            this.T.setVisibility(8);
            this.oYF.setVisibility(0);
            this.U.setText(getString(a.i.str_dialog_loading_content));
            this.U.setVisibility(8);
        }
    }

    protected void a(String str, int i) {
        this.oYJ.setVisibility(8);
        this.oYL.setVisibility(0);
        this.cal.setVisibility(0);
        if (this.oYF != null) {
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
                            com.kascend.chushou.c.c.eqe().b(new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.VideoPlayer.11.1
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
                                        tv.chushou.zues.utils.g.N(VideoPlayer.this, a.i.subscribe_failed);
                                    }
                                }
                            }, VideoPlayer.this.P, (String) null, VideoPlayer.this.oYD.h);
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
            this.oYF.setVisibility(8);
            this.oYR.setVisibility(8);
        }
    }

    public void s() {
        if (this.oZd != null) {
            this.oZd.removeMessages(1);
        }
    }

    private void a(ArrayList<PlayUrl> arrayList) {
        boolean z;
        if (this.oYD.f == null) {
            this.oYD.f = new ArrayList<>();
        }
        this.oYD.f.clear();
        this.oYD.f.addAll(arrayList);
        if (com.kascend.chushou.d.e.b() && !"4".equals(this.aq)) {
            int c = com.kascend.chushou.d.e.c();
            if (c == -1) {
                b(arrayList);
                return;
            } else if (this.aw) {
                this.aw = false;
                if (c == 0) {
                    this.oYD.d = false;
                    g(arrayList, true);
                    return;
                }
                if (this.oYD != null && this.oYD.f != null) {
                    Iterator<PlayUrl> it = this.oYD.f.iterator();
                    while (it.hasNext()) {
                        if ("2".equals(it.next().mType)) {
                            z = true;
                            break;
                        }
                    }
                }
                z = false;
                this.oYD.d = z;
                g(arrayList, true);
                return;
            } else {
                if (this.oYD.e) {
                    this.oYD.d = !this.oYD.d;
                    this.oYD.e = false;
                    this.oZf = true;
                } else if ("4".equals(this.aq)) {
                    this.oYD.d = true;
                }
                g(arrayList, true);
                return;
            }
        }
        if (this.oYD.e) {
            this.oYD.d = !this.oYD.d;
            this.oYD.e = false;
            this.oZf = true;
        } else if ("4".equals(this.aq)) {
            this.oYD.d = true;
        }
        g(arrayList, true);
    }

    private void b(ArrayList<PlayUrl> arrayList) {
        if ("1".equals(this.R)) {
            if ("2".equals(this.oYY)) {
                d(false, arrayList);
            } else if (this.oYB != null) {
                this.oYB.g(arrayList, false);
            }
        } else if (this.oYB != null) {
            this.oYB.g(arrayList, false);
        }
    }

    public void c(boolean z) {
        this.oYD.d = false;
        com.kascend.chushou.d.e.a(0);
        ArrayList<PlayUrl> arrayList = this.oYD.f;
        if (!h.isEmpty(arrayList)) {
            if (z) {
                g(arrayList, false);
                if (this.oZd != null) {
                    this.oZd.Ry(2);
                    return;
                }
                return;
            }
            g(arrayList, true);
        }
    }

    public void d(boolean z) {
        this.oYD.d = true;
        com.kascend.chushou.d.e.a(1);
        ArrayList<PlayUrl> arrayList = this.oYD.f;
        if (!h.isEmpty(arrayList)) {
            if (z) {
                g(arrayList, false);
                if (this.oZd != null) {
                    this.oZd.Ry(2);
                    return;
                }
                return;
            }
            g(arrayList, true);
        }
    }

    @Subscribe
    public void onNotifyEvent(com.kascend.chushou.b.a.a.j jVar) {
        if (!isFinishing() && jVar.f4072a == 1 && !"5".equals(this.R) && !eqr()) {
            tv.chushou.zues.utils.e.d(this.v, "onNetworkChangeEvent 3G=" + com.kascend.chushou.b.eqb().b + "  wifi=" + com.kascend.chushou.b.eqb().f4064a);
            if (com.kascend.chushou.d.e.b() && !"4".equals(this.aq)) {
                if (com.kascend.chushou.d.e.c() == -1) {
                    if (this.oYB != null) {
                        this.oYB.e(false);
                    }
                    if ("1".equals(this.R)) {
                        if ("2".equals(this.oYY)) {
                            d(true, null);
                            return;
                        } else if (this.oYB != null) {
                            this.oYB.g(this.oYD.f, true);
                            return;
                        } else {
                            return;
                        }
                    } else if (this.oYB != null) {
                        this.oYB.g(this.oYD.f, true);
                        return;
                    } else {
                        return;
                    }
                }
                RxExecutor.postDelayed(this.oZa, EventThread.MAIN_THREAD, 10L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.VideoPlayer.12
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!VideoPlayer.this.isFinishing() && com.kascend.chushou.b.eqb().b && !com.kascend.chushou.b.eqb().f4064a) {
                            tv.chushou.zues.utils.g.d(VideoPlayer.this.w, VideoPlayer.this.getString(a.i.str_monet_notify));
                        }
                    }
                });
            } else if (com.kascend.chushou.b.eqb().f4064a || com.kascend.chushou.b.eqb().b) {
                t();
                if (this.oZd != null) {
                    this.oZd.Ry(2);
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
            if (this.oYD.d) {
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
            String d = com.kascend.chushou.d.h.eqj().d();
            String str3 = h.isEmpty(d) ? "2" : d;
            if (this.oYD.d) {
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
                if (this.oYD != null) {
                    this.oYD.a(playUrl2);
                    if (this.oZd != null) {
                        Message RA = this.oZd.RA(5);
                        RA.arg1 = 1;
                        this.oZd.X(RA);
                    }
                }
                String b = com.kascend.chushou.player.c.a.b(playUrl2);
                if (!h.isEmpty(b)) {
                    this.oYw = Uri.parse(b);
                    if (this.oZf) {
                        this.oZf = false;
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (z && this.oYx != null) {
                        a(false, z2);
                    }
                }
            }
        }
    }

    public void d(final boolean z, ArrayList<PlayUrl> arrayList) {
        if (this.oYN == null || this.oYN.f4224a <= 0) {
            this.oYN = com.kascend.chushou.view.b.a.a.ess();
            this.oYN.a(new a.InterfaceC0993a() { // from class: com.kascend.chushou.player.VideoPlayer.13
                @Override // com.kascend.chushou.view.b.a.a.InterfaceC0993a
                public void a(int i) {
                    if (i == a.f.tv_play_video) {
                        VideoPlayer.this.oYN.dismissAllowingStateLoss();
                        VideoPlayer.this.c(z);
                    } else if (i == a.f.tv_play_audio) {
                        VideoPlayer.this.oYN.dismissAllowingStateLoss();
                        VideoPlayer.this.d(z);
                    } else if (i == a.f.iv_close) {
                        VideoPlayer.this.finish();
                    } else {
                        if (i == a.f.tv_union_proxy) {
                        }
                    }
                }
            });
            this.oYN.show(getSupportFragmentManager(), "showRoom");
        }
    }

    public void t() {
        if (this.oYN != null) {
            this.oYN.dismissAllowingStateLoss();
        }
        if (this.oYB != null) {
            this.oYB.v();
        }
    }

    public void u() {
        com.kascend.chushou.c.c.eqe().c(this.P, new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.VideoPlayer.16
            @Override // com.kascend.chushou.c.b
            public void a() {
            }

            @Override // com.kascend.chushou.c.b
            public void a(String str, JSONObject jSONObject) {
                if (!VideoPlayer.this.isFinishing()) {
                    ParserRet eG = com.kascend.chushou.c.e.eG(jSONObject);
                    if (eG.mRc == 0 && eG.mData != null) {
                        CycleLiveRoomInfo cycleLiveRoomInfo = (CycleLiveRoomInfo) eG.mData;
                        if (VideoPlayer.this.oYD != null && cycleLiveRoomInfo != null && !h.isEmpty(cycleLiveRoomInfo.roomId)) {
                            FullRoomInfo eqU = VideoPlayer.this.oYD.eqU();
                            if (eqU.cycleLiveRoomInfo == null) {
                                eqU.cycleLiveRoomInfo = cycleLiveRoomInfo;
                                VideoPlayer.this.d();
                            } else if (eqU.cycleLiveRoomInfo != null && !cycleLiveRoomInfo.roomId.equals(eqU.cycleLiveRoomInfo.roomId)) {
                                eqU.cycleLiveRoomInfo.copyCycleLiveRoomInfo(cycleLiveRoomInfo);
                                VideoPlayer.this.d();
                            } else {
                                eqU.cycleLiveRoomInfo.copyCycleLiveRoomInfo(cycleLiveRoomInfo);
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
        if (this.oYB != null) {
            this.oYB.N();
        }
    }

    public void v() {
        com.kascend.chushou.c.c.eqe().a(this.P, new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.VideoPlayer.17
            @Override // com.kascend.chushou.c.b
            public void a() {
            }

            @Override // com.kascend.chushou.c.b
            public void a(String str, JSONObject jSONObject) {
                if (!VideoPlayer.this.isFinishing()) {
                    ParserRet eH = com.kascend.chushou.c.e.eH(jSONObject);
                    if (eH.mRc == 0 && eH.mData != null) {
                        PkNotifyInfo pkNotifyInfo = (PkNotifyInfo) eH.mData;
                        VideoPlayer.this.oYW.b = VideoPlayer.this.P;
                        if (pkNotifyInfo != null) {
                            VideoPlayer.this.oYW.pdA = pkNotifyInfo;
                            if (VideoPlayer.this.oYB != null) {
                                VideoPlayer.this.oYB.a(pkNotifyInfo, VideoPlayer.this.P);
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
        if (this.oYE != null) {
            this.oYE.release();
            this.oYE = null;
        }
        com.kascend.chushou.c.c.eqe().a(this.P, new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.VideoPlayer.18
            @Override // com.kascend.chushou.c.b
            public void a() {
            }

            @Override // com.kascend.chushou.c.b
            public void a(String str, JSONObject jSONObject) {
                if (!VideoPlayer.this.isFinishing()) {
                    ParserRet eI = com.kascend.chushou.c.e.eI(jSONObject);
                    if (eI.mRc == 0 && eI.mData != null) {
                        RoomExpandInfo roomExpandInfo = (RoomExpandInfo) eI.mData;
                        if (VideoPlayer.this.oYD != null) {
                            VideoPlayer.this.oYD.pah = roomExpandInfo.mTopWebAdItem;
                            if (VideoPlayer.this.oYD.pan == null) {
                                VideoPlayer.this.oYD.pan = new ArrayList();
                            }
                            VideoPlayer.this.oYD.pan.clear();
                            VideoPlayer.this.oYD.pan.addAll(roomExpandInfo.mGiftTopRightIcons);
                            tv.chushou.zues.a.a.post(new i(50, VideoPlayer.this.oYD.pah));
                        }
                        if (VideoPlayer.this.oYD != null) {
                            VideoPlayer.this.oYD.gw(roomExpandInfo.mExpandNavList);
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
                            VideoPlayer.this.oYS.a(list);
                        }
                        List<com.kascend.chushou.player.ui.h5.c.c> list2 = roomExpandInfo.mLuckList;
                        if (!h.isEmpty(list2)) {
                            VideoPlayer.this.oYT.a(list2);
                        }
                        com.kascend.chushou.player.ui.h5.c.c cVar = roomExpandInfo.mVoteItem;
                        if (cVar != null) {
                            VideoPlayer.this.oYU.a(cVar);
                        }
                        List<com.kascend.chushou.player.ui.h5.c.b> list3 = roomExpandInfo.mInteractH5Item;
                        if (!h.isEmpty(list3)) {
                            VideoPlayer.this.oYX.a(list3);
                        }
                        List<com.kascend.chushou.player.ui.h5.c.b> list4 = roomExpandInfo.mInteractNavItem;
                        if (!h.isEmpty(list4)) {
                            VideoPlayer.this.oYX.a(list4);
                        }
                        VideoPlayer.this.oYE = (PrivilegeInfo) eI.mData1;
                        if (VideoPlayer.this.oYE != null) {
                            tv.chushou.zues.a.a.post(new l());
                        }
                        if (VideoPlayer.this.oYD != null) {
                            VideoPlayer.this.oYD.pao = roomExpandInfo.mIconConfig;
                            VideoPlayer.this.eqF().a(roomExpandInfo.mIconConfig.bangConfig);
                        }
                        List<SkinConfig> list5 = roomExpandInfo.skinConfig;
                        if (list5 != null && VideoPlayer.this.oYD != null) {
                            VideoPlayer.this.oYD.par.clear();
                            int i = 0;
                            while (true) {
                                int i2 = i;
                                if (i2 >= list5.size()) {
                                    break;
                                }
                                SkinConfig skinConfig = list5.get(i2);
                                VideoPlayer.this.oYD.par.put(skinConfig.position, skinConfig.resource);
                                i = i2 + 1;
                            }
                            VideoPlayer.this.C();
                        }
                        VideoPlayer.this.a(roomExpandInfo.mIconConfig, VideoPlayer.this.oYD != null ? VideoPlayer.this.oYD.par : null);
                        if (roomExpandInfo.mColorMap != null && roomExpandInfo.mColorMap.size() > 0 && com.kascend.chushou.b.eqb().c != null && com.kascend.chushou.b.eqb().c.size() <= 0) {
                            com.kascend.chushou.b.eqb().c.putAll(roomExpandInfo.mColorMap);
                            tv.chushou.zues.a.a.post(new i(52, null));
                        }
                        AutoBang autoBang = roomExpandInfo.mAutoBang;
                        if (autoBang != null && autoBang.currentTime != 0 && autoBang.bangTime != 0) {
                            VideoPlayer.this.eqF().a(autoBang);
                        }
                        if (!h.isEmpty(roomExpandInfo.mRelatedRoomList) && VideoPlayer.this.oYD != null) {
                            VideoPlayer.this.oYD.t = roomExpandInfo.mRelatedRoomList;
                            if (VideoPlayer.this.oYB != null && VideoPlayer.this.H) {
                                VideoPlayer.this.oYB.w();
                            }
                        }
                        if (roomExpandInfo.mRoomNewUserInfo != null && roomExpandInfo.mRoomNewUserInfo.mBarrierNoviceGuide && !com.kascend.chushou.d.h.eqj().k() && VideoPlayer.this.oYB != null) {
                            VideoPlayer.this.oYB.J();
                        }
                        if (roomExpandInfo.mRoomNewUserInfo != null && roomExpandInfo.mRoomNewUserInfo.mRewardNoviceGuide && !com.kascend.chushou.d.h.eqj().l() && VideoPlayer.this.oYB != null) {
                            VideoPlayer.this.oYB.K();
                        }
                        if (!h.isEmpty(roomExpandInfo.mShopWindowInfos)) {
                            if (VideoPlayer.this.oYD != null) {
                                if (VideoPlayer.this.oYD.pap == null) {
                                    VideoPlayer.this.oYD.pap = new ArrayList();
                                }
                                VideoPlayer.this.oYD.pap.addAll(roomExpandInfo.mShopWindowInfos);
                            }
                            if (VideoPlayer.this.oYB != null) {
                                VideoPlayer.this.oYB.L();
                            }
                        }
                        VideoPlayer.this.oYW.b = VideoPlayer.this.P;
                        if (roomExpandInfo.mPkNotifyInfo != null) {
                            VideoPlayer.this.oYW.pdA = roomExpandInfo.mPkNotifyInfo;
                            if (VideoPlayer.this.oYB != null) {
                                VideoPlayer.this.oYB.a(roomExpandInfo.mPkNotifyInfo, VideoPlayer.this.P);
                            }
                        } else {
                            VideoPlayer.this.oYW.pdA = null;
                        }
                        if (roomExpandInfo.mTrumpetPocket != null && VideoPlayer.this.oYD != null) {
                            VideoPlayer.this.oYD.paq = roomExpandInfo.mTrumpetPocket;
                            if (VideoPlayer.this.oYB != null) {
                                VideoPlayer.this.oYB.M();
                            }
                        }
                        if (!h.isEmpty(roomExpandInfo.hotwordContentList)) {
                            if (VideoPlayer.this.oYD != null) {
                                if (VideoPlayer.this.oYD.w == null) {
                                    VideoPlayer.this.oYD.w = new ArrayList();
                                }
                                VideoPlayer.this.oYD.w.clear();
                                VideoPlayer.this.oYD.w.addAll(roomExpandInfo.hotwordContentList);
                            }
                            if (VideoPlayer.this.oYB != null) {
                                VideoPlayer.this.oYB.b(roomExpandInfo.hotwordContentList);
                            }
                        }
                        VideoPlayer.this.U();
                        return;
                    }
                    a(eI.mRc, eI.mMessage);
                }
            }

            @Override // com.kascend.chushou.c.b
            public void a(int i, String str) {
                tv.chushou.zues.utils.e.e(VideoPlayer.this.v, "get room gift popup list failed, rc =" + i + ", errorMsg=" + str);
            }
        }, this.ag, this.oYY);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U() {
        if (!h.isEmpty(com.kascend.chushou.a.a.eqc().z)) {
            StringBuilder sb = new StringBuilder();
            if (com.kascend.chushou.a.a.eqc().z.contains(com.kascend.chushou.a.a.f)) {
                if (sb.length() > 0) {
                    sb.append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                sb.append(com.kascend.chushou.a.a.f);
            }
            if (com.kascend.chushou.a.a.eqc().z.contains(com.kascend.chushou.a.a.g)) {
                if (sb.length() > 0) {
                    sb.append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                sb.append(com.kascend.chushou.a.a.g);
            }
            if (com.kascend.chushou.a.a.eqc().z.contains(com.kascend.chushou.a.a.i)) {
                if (sb.length() > 0) {
                    sb.append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                sb.append(com.kascend.chushou.a.a.i);
            }
            if (com.kascend.chushou.a.a.eqc().z.contains(com.kascend.chushou.a.a.h)) {
                if (sb.length() > 0) {
                    sb.append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                sb.append(com.kascend.chushou.a.a.h);
            }
            if (com.kascend.chushou.a.a.eqc().z.contains(com.kascend.chushou.a.a.j)) {
                if (sb.length() > 0) {
                    sb.append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                sb.append(com.kascend.chushou.a.a.j);
            }
            if (com.kascend.chushou.a.a.eqc().z.contains(com.kascend.chushou.a.a.l)) {
                if (sb.length() > 0) {
                    sb.append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                sb.append(com.kascend.chushou.a.a.l);
            }
            if (com.kascend.chushou.a.a.eqc().z.contains(com.kascend.chushou.a.a.m)) {
                if (sb.length() > 0) {
                    sb.append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                sb.append(com.kascend.chushou.a.a.m);
            }
            if (sb.length() != 0) {
                com.kascend.chushou.a.a.eqc().a(sb.toString(), this.P, new a.c() { // from class: com.kascend.chushou.player.VideoPlayer.19
                    @Override // com.kascend.chushou.a.a.c
                    public void a(List<ListItem> list) {
                        if (VideoPlayer.this.oYD != null && list != null) {
                            int i = 0;
                            while (true) {
                                int i2 = i;
                                if (i2 >= list.size()) {
                                    break;
                                }
                                if (list.get(i2).mAdExtraInfo != null) {
                                    if (com.kascend.chushou.a.a.f.equals(list.get(i2).mAdExtraInfo.mCode)) {
                                        VideoPlayer.this.oYD.pag = list.get(i2);
                                    } else if (com.kascend.chushou.a.a.g.equals(list.get(i2).mAdExtraInfo.mCode)) {
                                        VideoPlayer.this.oYD.paf = list.get(i2);
                                    } else if (com.kascend.chushou.a.a.i.equals(list.get(i2).mAdExtraInfo.mCode)) {
                                        VideoPlayer.this.oYD.pai = list.get(i2);
                                    } else if (com.kascend.chushou.a.a.h.equals(list.get(i2).mAdExtraInfo.mCode)) {
                                        VideoPlayer.this.oYD.paj = list.get(i2);
                                    } else if (com.kascend.chushou.a.a.j.equals(list.get(i2).mAdExtraInfo.mCode)) {
                                        VideoPlayer.this.oYD.pam = list.get(i2);
                                    } else if (com.kascend.chushou.a.a.l.equals(list.get(i2).mAdExtraInfo.mCode)) {
                                        VideoPlayer.this.oYD.pak = list.get(i2);
                                    } else if (com.kascend.chushou.a.a.m.equals(list.get(i2).mAdExtraInfo.mCode)) {
                                        VideoPlayer.this.oYD.pal = list.get(i2);
                                    }
                                }
                                i = i2 + 1;
                            }
                            if (VideoPlayer.this.oYB != null) {
                                VideoPlayer.this.oYB.H();
                            }
                        }
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str, String str2) {
        if (eqx()) {
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
                this.oYI.setSystemUiVisibility(i);
                return;
            }
            this.oYI.setSystemUiVisibility(1792);
        }
    }

    public void f(boolean z) {
        Window window;
        View decorView;
        if (com.kascend.chushou.b.eqb().d != 1 && (window = getWindow()) != null && (decorView = window.getDecorView()) != null) {
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
        if (this.oYB != null) {
            this.oYB.a(i, i2, intent);
        }
    }

    public Uri eqy() {
        return this.oYw;
    }

    @Override // com.kascend.chushou.view.base.BaseActivity
    protected int y() {
        return 0;
    }

    public void As(boolean z) {
        if (this.oYI != null) {
            this.oYI.qgt = z;
        }
    }

    public void eqz() {
        if (this.oYI != null) {
            this.oYI.eqz();
        }
    }

    public boolean eqA() {
        return this.ae;
    }

    public void g(boolean z) {
        this.ae = z;
    }

    public void h(boolean z) {
        if (this.oYI != null) {
            this.oYI.setIsTranslucentStatus(z);
        }
    }

    public void z() {
        if (this.oYI != null) {
            this.oYI.eEw();
        }
    }

    @Override // com.kascend.chushou.widget.gifts.RoomSendGiftView.a
    public void A() {
        if (this.oYG != null) {
            this.oYG.b();
        }
        if (this.oYD != null) {
            this.oYD.z = true;
        }
    }

    @Override // com.kascend.chushou.widget.gifts.RoomSendGiftView.a
    public void B() {
        if (this.oYG != null) {
            this.oYG.b();
        }
    }

    public void a(List<ListItem> list) {
        if (this.oYB != null) {
            this.oYB.a(list);
        }
    }

    public void a(IconConfig iconConfig, Map<String, SkinConfig.SkinRes> map) {
        if (this.oYB != null) {
            this.oYB.a(iconConfig, map);
        }
    }

    public void C() {
        if (this.oYB != null) {
            this.oYB.I();
        }
    }

    @Override // com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC0985a
    public void a(int i) {
        if (this.oYB != null) {
            this.oYB.a(i);
        }
    }

    @Override // com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC0985a
    public void D() {
        if (!isFinishing() && this.oYB != null) {
            this.oYB.D();
        }
    }

    @Override // com.kascend.chushou.player.ui.h5.b.b.a
    public void a(long j) {
        if (!isFinishing() && this.oYB != null) {
            this.oYB.a(j);
        }
    }

    @Override // com.kascend.chushou.player.ui.h5.b.b.a
    public void a(com.kascend.chushou.player.ui.h5.c.a aVar) {
        if (aVar != null && this.oYB != null) {
            this.oYB.a(aVar);
        }
    }

    @Override // com.kascend.chushou.player.ui.h5.b.b.a
    public void b(int i) {
        if (this.oYB != null) {
            this.oYB.b(i);
        }
    }

    @Override // com.kascend.chushou.player.ui.h5.d.a.InterfaceC0984a
    public void b(long j) {
        if (!isFinishing() && this.oYB != null) {
            this.oYB.b(j);
        }
    }

    @Override // com.kascend.chushou.player.ui.h5.a.a.InterfaceC0982a
    public void c(int i) {
        if (!isFinishing() && this.oYB != null) {
            this.oYB.c(i);
        }
    }

    @Override // com.kascend.chushou.player.ui.h5.d.a.InterfaceC0984a
    public void b(com.kascend.chushou.player.ui.h5.c.a aVar) {
        if (aVar != null && this.oYB != null) {
            this.oYB.b(aVar);
        }
    }

    @Override // com.kascend.chushou.player.ui.a.a.InterfaceC0979a
    public void a(IconConfig.Config config) {
        if (this.oYB != null) {
            this.oYB.a(config);
        }
    }

    @Override // com.kascend.chushou.player.ui.a.a.InterfaceC0979a
    public void a(BangInfo bangInfo, String str) {
        if (this.oYB != null) {
            this.oYB.a(bangInfo, str);
        }
    }

    @Override // com.kascend.chushou.player.ui.a.a.InterfaceC0979a
    public void a(long j, BangInfo bangInfo, String str) {
        if (this.oYB != null) {
            this.oYB.a(j, bangInfo, str);
        }
    }

    public com.kascend.chushou.player.ui.h5.redpacket.a eqB() {
        return this.oYS;
    }

    public com.kascend.chushou.player.ui.h5.b.b eqC() {
        return this.oYT;
    }

    public com.kascend.chushou.player.ui.h5.d.a eqD() {
        return this.oYU;
    }

    public com.kascend.chushou.player.ui.h5.a.a eqE() {
        return this.oYX;
    }

    public com.kascend.chushou.player.ui.a.a eqF() {
        return this.oYV;
    }

    public com.kascend.chushou.player.e.a eqG() {
        return this.oYW;
    }

    @Override // com.kascend.chushou.view.base.BaseActivity, android.app.Activity
    public void finish() {
        super.finish();
        if ("3".equals(this.R)) {
            overridePendingTransition(17432576, a.C0969a.commonres_activity_exit_bottom);
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
        RxExecutor.postDelayed(this.oZa, EventThread.MAIN_THREAD, aVar.d, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.VideoPlayer.2
            @Override // java.lang.Runnable
            public void run() {
                if (VideoPlayer.this.oYB != null) {
                    VideoPlayer.this.oYB.c(aVar);
                }
            }
        });
    }

    private void e(final com.kascend.chushou.player.ui.h5.c.a aVar) {
        if (!com.kascend.chushou.d.h.eqj().eqm().contains(aVar.b)) {
            if (aVar.d < 0) {
                aVar.d = 0;
            }
            RxExecutor.postDelayed(this.oZa, EventThread.MAIN_THREAD, aVar.d, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.VideoPlayer.3
                @Override // java.lang.Runnable
                public void run() {
                    if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.oYB != null) {
                        VideoPlayer.this.oYB.c(aVar);
                    }
                }
            });
        }
    }

    private String eqH() {
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
                if (VideoPlayer.this.oYH != null && !VideoPlayer.this.isFinishing()) {
                    VideoPlayer.n = VideoPlayer.this.oYH.getStreamVolume(3);
                }
                if (!VideoPlayer.this.isFinishing() && (VideoPlayer.this.oYB instanceof f)) {
                    ((f) VideoPlayer.this.oYB).ab();
                }
            }
        }
    }

    public String a(String str) {
        HashMap hashMap = new HashMap(tv.chushou.zues.utils.d.ZY(str));
        if ("1".equals(this.R)) {
            hashMap.put("roomId", this.P);
        } else if ("3".equals(this.R)) {
            hashMap.put("videoId", this.P);
        }
        return tv.chushou.zues.utils.d.toJson(hashMap);
    }

    public boolean eqI() {
        if (this.oYB instanceof com.kascend.chushou.player.d.a) {
            return ((com.kascend.chushou.player.d.a) this.oYB).erG();
        }
        if (this.oYB instanceof com.kascend.chushou.player.e.e) {
            return true;
        }
        return false;
    }
}

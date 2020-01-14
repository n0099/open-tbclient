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
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.baidu.live.tbadk.core.util.TbEnum;
import com.baidu.searchbox.websocket.WebSocketRequest;
import com.baidu.tbadk.mutiprocess.mission.MissionEvent;
import com.baidu.tieba.keepLive.jobScheduler.KeepJobService;
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
import tv.chushou.basis.rxjava.RxExecutor;
import tv.chushou.basis.rxjava.annotation.Subscribe;
import tv.chushou.basis.rxjava.thread.EventThread;
import tv.chushou.zues.utils.h;
import tv.chushou.zues.widget.animation.AnimationImageView;
import tv.chushou.zues.widget.fresco.FrescoThumbnailView;
import tv.chushou.zues.widget.kpswitch.widget.KPSwitchRootRelativeLayout;
/* loaded from: classes4.dex */
public class VideoPlayer extends BaseActivity implements a.InterfaceC0692a, a.InterfaceC0695a, b.a, a.InterfaceC0697a, a.InterfaceC0698a, RoomSendGiftView.a {
    private static int A = 60000;
    public static String a = null;
    public static int n = 0;
    private String P;
    private String Q;
    private String R;
    private String S;
    private ImageView Z;
    private String ab;
    private c mOF;
    b mOI;
    public PrivilegeInfo mOJ;
    com.kascend.chushou.widget.a.b mON;
    private KPSwitchRootRelativeLayout mOP;
    private FrameLayout mOQ;
    private LinearLayout mOR;
    private com.kascend.chushou.toolkit.d mOS;
    com.kascend.chushou.view.b.a.a mOT;
    private String mOW;
    private FrescoThumbnailView mOX;
    private FrameLayout mOY;
    public com.kascend.chushou.player.feedback.a mPg;
    private a mPi;
    private CSTVWifiReceiver mPj;
    private boolean B = true;
    private boolean C = false;
    private Uri mOB = null;
    private tv.chushou.common.player.a mOC = null;
    public tv.chushou.common.player.a mOD = null;
    public tv.chushou.common.player.a mOE = null;
    public boolean d = false;
    public boolean e = false;
    private e mOG = null;
    private boolean H = false;
    private com.kascend.chushou.view.user.b mOH = null;
    private boolean J = false;
    private boolean K = false;
    private boolean L = false;
    private boolean M = false;
    private long N = 0;
    private int O = 0;
    public boolean g = false;
    private ImageView mOK = null;
    private TextView mOL = null;
    private AnimationImageView mOM = null;
    private View aQb = null;
    public boolean j = false;
    public float k = 0.0f;
    public float l = 0.0f;
    public boolean m = false;
    public AudioManager mOO = null;
    private d.a mOU = new d.a() { // from class: com.kascend.chushou.player.VideoPlayer.1
        @Override // com.kascend.chushou.toolkit.d.a
        public void a() {
            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.mPk != null) {
                VideoPlayer.this.mPk.Oc(4);
            }
        }
    };
    private boolean ae = false;
    public boolean q = true;
    public long r = -1;
    public long s = -1;
    private PowerManager.WakeLock mOV = null;
    public String t = null;
    private final com.kascend.chushou.player.ui.h5.redpacket.a mOZ = new com.kascend.chushou.player.ui.h5.redpacket.a(this);
    private final com.kascend.chushou.player.ui.h5.b.b mPa = new com.kascend.chushou.player.ui.h5.b.b(this);
    private final com.kascend.chushou.player.ui.h5.d.a mPb = new com.kascend.chushou.player.ui.h5.d.a(this);
    private final com.kascend.chushou.player.ui.a.a mPc = new com.kascend.chushou.player.ui.a.a(this);
    private final com.kascend.chushou.player.e.a mPd = new com.kascend.chushou.player.e.a();
    private final com.kascend.chushou.player.ui.h5.a.a mPe = new com.kascend.chushou.player.ui.h5.a.a(this);
    private String mPf = "1";
    private String aq = "2";
    private io.reactivex.disposables.a mPh = new io.reactivex.disposables.a();
    private tv.chushou.zues.c mPk = new tv.chushou.zues.c(new Handler.Callback() { // from class: com.kascend.chushou.player.VideoPlayer.6
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            try {
                if (!VideoPlayer.this.isFinishing()) {
                    switch (message.what) {
                        case 1:
                            VideoPlayer.this.mPk.removeMessages(1);
                            com.kascend.chushou.c.c.dAI().a(VideoPlayer.this.P, VideoPlayer.this.mOI != null ? VideoPlayer.this.mOI.h : null, System.currentTimeMillis());
                            VideoPlayer.this.mPk.L(1, VideoPlayer.A);
                            break;
                        case 2:
                            VideoPlayer.this.a(true, (Uri) null, false);
                            break;
                        case 3:
                            VideoPlayer.this.cWe();
                            break;
                        case 4:
                            if (VideoPlayer.this.mOG != null) {
                                VideoPlayer.this.mOG.a(true);
                            }
                            if (VideoPlayer.this.mOS != null) {
                                VideoPlayer.this.mOS.d();
                                VideoPlayer.this.mOS = null;
                                break;
                            }
                            break;
                        case 5:
                            int i = message.arg1;
                            if (i == 1) {
                                if (VideoPlayer.this.mOG != null) {
                                    VideoPlayer.this.mOG.p();
                                    break;
                                }
                            } else if (i == 2 && VideoPlayer.this.mOG != null) {
                                VideoPlayer.this.mOG.e(message.arg2);
                                break;
                            }
                            break;
                        case 6:
                            if (!com.kascend.chushou.b.dAF().a && !com.kascend.chushou.b.dAF().b && VideoPlayer.this.mOG != null) {
                                VideoPlayer.this.mOG.g(true);
                                break;
                            } else {
                                VideoPlayer.this.c();
                                break;
                            }
                            break;
                        case 7:
                            tv.chushou.zues.utils.e.d(VideoPlayer.this.v, "MSG_BUFFER_DEALY: ");
                            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.mOG != null && VideoPlayer.this.M && !VideoPlayer.this.e) {
                                VideoPlayer.this.mOG.h(true);
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
    private boolean mPl = false;
    private boolean mPo = false;
    private tv.chushou.common.player.b mPp = new tv.chushou.common.player.b() { // from class: com.kascend.chushou.player.VideoPlayer.14
        @Override // tv.chushou.common.player.b
        public void dBl() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerACallback onSetVideoViewLayout");
            if (!VideoPlayer.this.isFinishing()) {
                if ((VideoPlayer.this.mOG == null || !VideoPlayer.this.mOG.H) && VideoPlayer.this.mOG != null && !VideoPlayer.this.d) {
                    VideoPlayer.this.mOG.y();
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void MD(int i) {
            if (!VideoPlayer.this.isFinishing()) {
                if ((VideoPlayer.this.mOG == null || !VideoPlayer.this.mOG.H) && VideoPlayer.this.mOG != null && !VideoPlayer.this.d) {
                    VideoPlayer.this.mOG.g(i);
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void dBm() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerACallback onCompletePlayback");
            if (!VideoPlayer.this.isFinishing()) {
                if (!h.isEmpty(VideoPlayer.this.P)) {
                    j.dAR().a(VideoPlayer.this.P, 0);
                }
                VideoPlayer.this.K = false;
                if (VideoPlayer.this.mPk != null) {
                    VideoPlayer.this.mPk.removeMessages(1);
                }
                if ((VideoPlayer.this.mOG == null || !VideoPlayer.this.mOG.H) && VideoPlayer.this.mOG != null && !VideoPlayer.this.d) {
                    VideoPlayer.this.mPk.removeMessages(7);
                    VideoPlayer.this.M = false;
                    VideoPlayer.this.mOG.z();
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void dBn() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerACallback onVideoRenderingStart");
            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.mOG != null) {
                VideoPlayer.this.mOG.G();
            }
        }

        @Override // tv.chushou.common.player.b
        public void dBo() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerACallback onPreparedPlayback");
            if (!VideoPlayer.this.isFinishing()) {
                if (VideoPlayer.this.mOG == null || !VideoPlayer.this.mOG.H) {
                    VideoPlayer.this.mPk.removeMessages(6);
                    VideoPlayer.this.N = 0L;
                    VideoPlayer.this.O = 0;
                    if (VideoPlayer.this.mOC != null && VideoPlayer.this.mOG != null) {
                        VideoPlayer.this.mOC.setVolume(VideoPlayer.this.mOG.J, VideoPlayer.this.mOG.J);
                    }
                    if (VideoPlayer.this.mOI != null) {
                        VideoPlayer.this.K = false;
                        FullRoomInfo dBw = VideoPlayer.this.nC() ? null : VideoPlayer.this.mOI.dBw();
                        if (VideoPlayer.this.L || dBw != null) {
                            if (VideoPlayer.this.mOI.e) {
                                VideoPlayer.this.mOI.e = false;
                                VideoPlayer.this.mOI.d = !VideoPlayer.this.mOI.d;
                            }
                            if (VideoPlayer.this.mOG != null) {
                                VideoPlayer.this.c("1", (String) null);
                                if (!VideoPlayer.this.d) {
                                    VideoPlayer.this.mOG.i(true);
                                } else if (VideoPlayer.this.e) {
                                    VideoPlayer.this.e = false;
                                    VideoPlayer.this.mOG.B();
                                }
                            }
                        }
                    }
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void ME(int i) {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerACallback onErrorAppeared");
            if (!VideoPlayer.this.isFinishing()) {
                VideoPlayer.this.c();
                VideoPlayer.this.K = false;
                if (VideoPlayer.this.mPk != null) {
                    VideoPlayer.this.mPk.removeMessages(7);
                }
                if (VideoPlayer.this.mPk != null) {
                    VideoPlayer.this.mPk.removeMessages(1);
                }
                if ((VideoPlayer.this.mOG == null || !VideoPlayer.this.mOG.H) && !VideoPlayer.this.dAT()) {
                    if (!"10004".equals(VideoPlayer.this.t)) {
                        if (VideoPlayer.this.mOG != null) {
                            if (VideoPlayer.this.d) {
                                VideoPlayer.this.mOD.stop();
                                VideoPlayer.this.mOD.release();
                                VideoPlayer.this.e = false;
                                VideoPlayer.this.mOG.C();
                            }
                            if (!com.kascend.chushou.b.dAF().a && !com.kascend.chushou.b.dAF().b) {
                                VideoPlayer.this.mOG.g(true);
                            } else if (VideoPlayer.this.d) {
                                VideoPlayer.this.mOG.a(i, true);
                            } else {
                                VideoPlayer.this.mOG.a(i, false);
                            }
                            VideoPlayer.this.c("2", (String) null);
                            return;
                        }
                        return;
                    }
                    dBm();
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void dBp() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerACallback onBufferingStart");
            if (!VideoPlayer.this.isFinishing()) {
                if ((VideoPlayer.this.mOG == null || !VideoPlayer.this.mOG.H) && VideoPlayer.this.mOG != null && !VideoPlayer.this.d) {
                    VideoPlayer.this.mOG.E();
                    VideoPlayer.this.M = true;
                    long currentTimeMillis = System.currentTimeMillis();
                    VideoPlayer.this.mPk.removeMessages(7);
                    if (!VideoPlayer.this.g) {
                        VideoPlayer.y(VideoPlayer.this);
                    }
                    tv.chushou.zues.utils.e.d(VideoPlayer.this.v, "currentTime: -- >" + currentTimeMillis + "  bufferTime-->" + VideoPlayer.this.N + "  bufferCount-->" + VideoPlayer.this.O);
                    if (currentTimeMillis - VideoPlayer.this.N >= 20000 || VideoPlayer.this.O < 2 || VideoPlayer.this.mOG.H) {
                        if (VideoPlayer.this.O == 1) {
                            VideoPlayer.this.N = currentTimeMillis;
                        }
                        VideoPlayer.this.mPk.L(7, 5000L);
                    } else {
                        VideoPlayer.this.mPk.Oc(7);
                    }
                    if (VideoPlayer.this.g) {
                        VideoPlayer.this.g = false;
                    }
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void dBq() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerACallback onBufferingEnd");
            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.mOG != null && !VideoPlayer.this.d) {
                VideoPlayer.this.mPk.removeMessages(7);
                VideoPlayer.this.M = false;
                if (VideoPlayer.this.mOG == null || !VideoPlayer.this.mOG.H) {
                    if (VideoPlayer.this.mOC == null) {
                        VideoPlayer.this.mOG.a(false, true, false);
                    } else {
                        VideoPlayer.this.mOG.a(true, VideoPlayer.this.mOC.getPlayState() == 4, VideoPlayer.this.mOC.getPlayState() == 5);
                    }
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void dBr() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerACallback onPlayerStart");
            if (!VideoPlayer.this.isFinishing()) {
                if (VideoPlayer.this.mOG == null || !VideoPlayer.this.mOG.H) {
                    if (VideoPlayer.this.mOG != null && !VideoPlayer.this.d) {
                        if (VideoPlayer.this.mOC != null) {
                            VideoPlayer.this.mOG.F();
                            VideoPlayer.this.mOG.a(true, VideoPlayer.this.mOC.getPlayState() == 4, VideoPlayer.this.mOC.getPlayState() == 5);
                        } else {
                            VideoPlayer.this.mOG.a(false, true, false);
                        }
                    }
                    if (VideoPlayer.this.mPk != null && !VideoPlayer.this.nC()) {
                        VideoPlayer.this.mPk.removeMessages(1);
                        VideoPlayer.this.mPk.L(1, VideoPlayer.A);
                    }
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void dBs() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerACallback onPlayerPause");
            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.mPk != null) {
                VideoPlayer.this.mPk.removeMessages(1);
            }
        }

        @Override // tv.chushou.common.player.b
        public void dBt() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerACallback onPlayerStop");
            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.nC() && VideoPlayer.this.mOD != null && !h.isEmpty(VideoPlayer.this.P) && VideoPlayer.this.mOD.getCurrentPos() > 0) {
                j.dAR().a(VideoPlayer.this.P, VideoPlayer.this.mOD.getCurrentPos());
            }
        }
    };
    private tv.chushou.common.player.b mPq = new tv.chushou.common.player.b() { // from class: com.kascend.chushou.player.VideoPlayer.15
        @Override // tv.chushou.common.player.b
        public void dBl() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerBCallback onSetVideoViewLayout");
            if (!VideoPlayer.this.isFinishing()) {
                if ((VideoPlayer.this.mOG == null || !VideoPlayer.this.mOG.H) && VideoPlayer.this.mOG != null && VideoPlayer.this.d) {
                    VideoPlayer.this.mOG.y();
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void MD(int i) {
            if (!VideoPlayer.this.isFinishing()) {
                if ((VideoPlayer.this.mOG == null || !VideoPlayer.this.mOG.H) && VideoPlayer.this.mOG != null && VideoPlayer.this.d) {
                    VideoPlayer.this.mOG.g(i);
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void dBm() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerBCallback onCompletePlayback");
            if (!VideoPlayer.this.isFinishing()) {
                if (!h.isEmpty(VideoPlayer.this.P)) {
                    j.dAR().a(VideoPlayer.this.P, 0);
                }
                VideoPlayer.this.K = false;
                if (VideoPlayer.this.mPk != null) {
                    VideoPlayer.this.mPk.removeMessages(1);
                }
                if ((VideoPlayer.this.mOG == null || !VideoPlayer.this.mOG.H) && VideoPlayer.this.mOG != null && VideoPlayer.this.d) {
                    VideoPlayer.this.mPk.removeMessages(7);
                    VideoPlayer.this.M = false;
                    VideoPlayer.this.mOG.z();
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void dBn() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerBCallback onVideoRenderingStart");
            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.mOG != null) {
                VideoPlayer.this.mOG.G();
            }
        }

        @Override // tv.chushou.common.player.b
        public void dBo() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerBCallback onPreparedPlayback");
            if (!VideoPlayer.this.isFinishing()) {
                if (VideoPlayer.this.mOG == null || !VideoPlayer.this.mOG.H) {
                    VideoPlayer.this.mPk.removeMessages(6);
                    VideoPlayer.this.N = 0L;
                    VideoPlayer.this.O = 0;
                    if (VideoPlayer.this.mOC != null && VideoPlayer.this.mOG != null) {
                        VideoPlayer.this.mOC.setVolume(VideoPlayer.this.mOG.J, VideoPlayer.this.mOG.J);
                    }
                    if (VideoPlayer.this.mOI != null) {
                        VideoPlayer.this.K = false;
                        FullRoomInfo dBw = VideoPlayer.this.nC() ? null : VideoPlayer.this.mOI.dBw();
                        if (VideoPlayer.this.L || dBw != null) {
                            if (VideoPlayer.this.mOI.e) {
                                VideoPlayer.this.mOI.e = false;
                                VideoPlayer.this.mOI.d = !VideoPlayer.this.mOI.d;
                            }
                            if (VideoPlayer.this.mOG != null) {
                                VideoPlayer.this.c("1", (String) null);
                                if (VideoPlayer.this.d) {
                                    VideoPlayer.this.mOG.i(true);
                                } else if (VideoPlayer.this.e) {
                                    VideoPlayer.this.e = false;
                                    VideoPlayer.this.mOG.B();
                                }
                            }
                        }
                    }
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void ME(int i) {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerBCallback onErrorAppeared");
            if (!VideoPlayer.this.isFinishing()) {
                VideoPlayer.this.c();
                VideoPlayer.this.K = false;
                if (VideoPlayer.this.mPk != null) {
                    VideoPlayer.this.mPk.removeMessages(7);
                }
                if (VideoPlayer.this.mPk != null) {
                    VideoPlayer.this.mPk.removeMessages(1);
                }
                if ((VideoPlayer.this.mOG == null || !VideoPlayer.this.mOG.H) && !VideoPlayer.this.dAT()) {
                    if (!"10004".equals(VideoPlayer.this.t)) {
                        if (VideoPlayer.this.mOG != null) {
                            if (!VideoPlayer.this.d) {
                                VideoPlayer.this.mOE.stop();
                                VideoPlayer.this.mOE.release();
                                VideoPlayer.this.mOG.C();
                                VideoPlayer.this.e = false;
                            }
                            if (!com.kascend.chushou.b.dAF().a && !com.kascend.chushou.b.dAF().b) {
                                VideoPlayer.this.mOG.g(true);
                            } else if (VideoPlayer.this.d) {
                                VideoPlayer.this.mOG.a(i, false);
                            } else {
                                VideoPlayer.this.mOG.a(i, true);
                            }
                            VideoPlayer.this.c("2", (String) null);
                            return;
                        }
                        return;
                    }
                    dBm();
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void dBp() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerBCallback onBufferingStart");
            if (!VideoPlayer.this.isFinishing()) {
                if ((VideoPlayer.this.mOG == null || !VideoPlayer.this.mOG.H) && VideoPlayer.this.mOG != null && VideoPlayer.this.d) {
                    VideoPlayer.this.mOG.E();
                    VideoPlayer.this.M = true;
                    VideoPlayer.this.mPk.removeMessages(7);
                    long currentTimeMillis = System.currentTimeMillis();
                    if (!VideoPlayer.this.g) {
                        VideoPlayer.y(VideoPlayer.this);
                    }
                    tv.chushou.zues.utils.e.d(VideoPlayer.this.v, "currentTime: -- >" + currentTimeMillis + "  bufferTime-->" + VideoPlayer.this.N + "  bufferCount-->" + VideoPlayer.this.O);
                    if (currentTimeMillis - VideoPlayer.this.N >= 20000 || VideoPlayer.this.O < 2 || VideoPlayer.this.mOG.H) {
                        if (VideoPlayer.this.O == 1) {
                            VideoPlayer.this.N = currentTimeMillis;
                        }
                        VideoPlayer.this.mPk.L(7, 5000L);
                    } else {
                        VideoPlayer.this.N = 0L;
                        VideoPlayer.this.O = 0;
                        VideoPlayer.this.mPk.Oc(7);
                    }
                    if (VideoPlayer.this.g) {
                        VideoPlayer.this.g = false;
                    }
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void dBq() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerBCallback onBufferingEnd");
            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.mOG != null && VideoPlayer.this.d) {
                VideoPlayer.this.M = false;
                VideoPlayer.this.mPk.removeMessages(7);
                if (VideoPlayer.this.mOG == null || !VideoPlayer.this.mOG.H) {
                    if (VideoPlayer.this.mOC == null) {
                        VideoPlayer.this.mOG.a(false, true, false);
                    } else {
                        VideoPlayer.this.mOG.a(true, VideoPlayer.this.mOC.getPlayState() == 4, VideoPlayer.this.mOC.getPlayState() == 5);
                    }
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void dBr() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerBCallback onPlayerStart");
            if (!VideoPlayer.this.isFinishing()) {
                if (VideoPlayer.this.mOG == null || !VideoPlayer.this.mOG.H) {
                    if (VideoPlayer.this.mOG != null && VideoPlayer.this.d) {
                        if (VideoPlayer.this.mOC != null) {
                            VideoPlayer.this.mOG.F();
                            VideoPlayer.this.mOG.a(true, VideoPlayer.this.mOC.getPlayState() == 4, VideoPlayer.this.mOC.getPlayState() == 5);
                        } else {
                            VideoPlayer.this.mOG.a(false, true, false);
                        }
                    }
                    if (VideoPlayer.this.mPk != null && !VideoPlayer.this.nC()) {
                        VideoPlayer.this.mPk.removeMessages(1);
                        VideoPlayer.this.mPk.L(1, VideoPlayer.A);
                    }
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void dBs() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerBCallback onPlayerPause");
            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.mPk != null) {
                VideoPlayer.this.mPk.removeMessages(1);
            }
        }

        @Override // tv.chushou.common.player.b
        public void dBt() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerBCallback onPlayerStop");
            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.nC() && VideoPlayer.this.mOE != null && !h.isEmpty(VideoPlayer.this.P) && VideoPlayer.this.mOE.getCurrentPos() > 0) {
                j.dAR().a(VideoPlayer.this.P, VideoPlayer.this.mOE.getCurrentPos());
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
        if (intent == null || intent.getAction() == null || intent.getAction().compareTo("android.intent.action.VIEW") != 0 || intent.getData() == null) {
            tv.chushou.zues.utils.e.e(this.v, "intent is null!");
            finish();
            return;
        }
        com.kascend.chushou.d.e.j();
        if (this.mPj == null) {
            this.mPj = new CSTVWifiReceiver();
            registerReceiver(this.mPj, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        }
        com.kascend.chushou.toolkit.d.a.dDe().b();
        this.mOB = intent.getData();
        tv.chushou.zues.utils.e.i(this.v, "intent.getData=" + this.mOB.toString());
        String scheme = this.mOB.getScheme();
        if (scheme == null || !scheme.equals("chushou")) {
            tv.chushou.zues.utils.e.e(this.v, "not support scheme :" + scheme);
            finish();
            return;
        }
        a(intent);
    }

    private void a(Intent intent) {
        this.P = this.mOB.getQueryParameter("roomId");
        this.Q = this.P;
        this.S = this.mOB.getQueryParameter(WebSocketRequest.PARAM_KEY_PROTOCOLS);
        this.aq = this.mOB.getQueryParameter("liveType");
        if ("2".equals(this.aq) || "3".equals(this.aq) || "4".equals(this.aq)) {
            this.mPf = "2";
            this.mPg = new com.kascend.chushou.player.feedback.a();
            if (this.mPg.mXI != null) {
                this.mPg.mXI.reset();
                this.mPg.mXI.roomId = this.P;
                this.mPg.mXI.enterType = 1;
                this.mPg.b = System.currentTimeMillis();
            }
        }
        if (h.isEmpty(this.P) || h.isEmpty(this.S)) {
            tv.chushou.zues.utils.e.e(this.v, "invalid param mItemID=" + this.P + " protocols=" + this.S);
            finish();
            return;
        }
        if (com.kascend.chushou.b.dAF().d == -1) {
            com.kascend.chushou.b.dAF().d = com.kascend.chushou.d.g.b() ? 1 : 0;
        }
        this.mOV = ((PowerManager) getSystemService("power")).newWakeLock(536870938, this.v);
        this.mOV.acquire();
        this.mOI = new b(this.P);
        this.mOI.d = intent.getBooleanExtra("room_play_audio", false);
        this.mON = new com.kascend.chushou.widget.a.b();
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
        this.mOP = (KPSwitchRootRelativeLayout) findViewById(a.f.rlRoot);
        if (!"2".equals(this.mPf) && com.kascend.chushou.b.dAF().d == 1) {
            this.mOP.setFitsSystemWindows(true);
        }
        this.mOQ = (FrameLayout) this.mOP.findViewById(a.f.fl_fragment);
        this.aQb = this.mOP.findViewById(a.f.rl_empty);
        this.mOK = (ImageView) this.aQb.findViewById(a.f.iv_empty);
        this.mOL = (TextView) this.aQb.findViewById(a.f.tv_empty);
        this.mOR = (LinearLayout) this.mOP.findViewById(a.f.rl_title);
        this.Z = (ImageView) this.mOR.findViewById(a.f.back_icon);
        this.Z.setOnClickListener(new View.OnClickListener() { // from class: com.kascend.chushou.player.VideoPlayer.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayer.this.finish();
            }
        });
        this.mOM = (AnimationImageView) this.aQb.findViewById(a.f.iv_loading);
        this.mOX = (FrescoThumbnailView) this.mOP.findViewById(a.f.live_cover);
        this.mOY = (FrameLayout) this.mOP.findViewById(a.f.fl_cover);
        this.k = dAS();
        try {
            this.mOO = (AudioManager) getApplicationContext().getSystemService("audio");
            n = this.mOO.getStreamVolume(3);
            this.mOO.requestAudioFocus(null, 3, 1);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (this.B) {
            a(1, nC() ? "3" : "1");
        } else {
            r();
        }
        if (com.kascend.chushou.b.dAF().b && !com.kascend.chushou.b.dAF().a) {
            RxExecutor.postDelayed(this.mPh, EventThread.MAIN_THREAD, 60L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.VideoPlayer.5
                @Override // java.lang.Runnable
                public void run() {
                    if (!VideoPlayer.this.isFinishing() && com.kascend.chushou.b.dAF().b && !com.kascend.chushou.b.dAF().a) {
                        tv.chushou.zues.utils.g.c(VideoPlayer.this.w, VideoPlayer.this.getString(a.i.str_monet_notify));
                    }
                }
            });
        }
        com.kascend.chushou.c.c.dAI().a(this.P, stringExtra, System.currentTimeMillis());
    }

    @Override // com.kascend.chushou.view.base.BaseActivity
    public void a() {
    }

    @Override // com.kascend.chushou.view.base.BaseActivity
    public void b() {
    }

    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        super.onStart();
        if (this.mPi == null) {
            this.mPi = new a();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.media.VOLUME_CHANGED_ACTION");
            registerReceiver(this.mPi, intentFilter);
        }
    }

    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        if (this.mPi != null) {
            unregisterReceiver(this.mPi);
            this.mPi = null;
        }
        super.onStop();
    }

    @Subscribe
    public void onHideGiftEffectEvent(com.kascend.chushou.b.a.a.f fVar) {
        if (fVar.b) {
            this.mOG.k();
            return;
        }
        this.mOG.m();
        this.mOG.l();
    }

    private float dAS() {
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
        this.mOW = str;
        R();
        try {
            if (h.isEmpty(str)) {
                jSONObject = new JSONObject();
            } else {
                jSONObject = new JSONObject(str);
            }
            jSONObject.put("_fbroomid", this.P);
            this.mOI.h = jSONObject.toString();
            String optString = jSONObject.optString("_thumb");
            jSONObject.optBoolean("tag_from_game_mic", false);
            if (!h.isEmpty(optString)) {
                this.ab = optString;
            }
        } catch (JSONException e) {
            e.printStackTrace();
            this.mOI.h = str;
        }
        if (nC()) {
            a(this.P, str);
            aO(this.P, z);
            return;
        }
        a = this.P;
        b(this.P, str);
        a(this.P, dBi(), z);
        w();
    }

    private void O() {
        this.m = true;
        j();
        if (this.mOG != null) {
            this.mOG.r();
        }
        s();
    }

    @Subscribe
    public void onStartRoomEvent(o oVar) {
        if (!isFinishing() && oVar.mOj != null && oVar.c != null && !h.isEmpty(oVar.mOj.mTargetKey)) {
            if (oVar.c != this) {
                tv.chushou.zues.utils.e.e(this.v, "different player!");
                return;
            }
            if (this.mOI != null) {
                this.mOI.a();
                this.mOI.a = oVar.mOj.mTargetKey;
                this.mOI.d = oVar.d;
                if (this.mOI.mQj != null) {
                    this.mOI.mQj.e();
                }
                if (this.mOI.mQj != null) {
                    this.mOI.mQj.b();
                }
                this.mOI.mQn = null;
                this.mOI.mQm = null;
                this.mOI.mQq = null;
                this.mOI.mQp = null;
                this.mOI.mQt = null;
                this.mOI.mQr = null;
                this.mOI.mQs = null;
            }
            if (this.mOO != null) {
                n = this.mOO.getStreamVolume(3);
            }
            if (!h.isEmpty(oVar.mOj.mType) && oVar.mOj.mType.equals("3")) {
                this.B = false;
                this.mPf = "1";
                r();
                this.P = oVar.mOj.mTargetKey;
                this.R = "3";
                if (this.mON != null) {
                    this.mON.a();
                }
                if (this.mOI != null) {
                    this.mOI.a((PlayUrl) null);
                    this.mOI.f();
                    if (this.mOI.c() != null) {
                        this.mOI.c().clear();
                    }
                    this.mOI.i.clear();
                }
                if (this.mOG != null) {
                    this.mOG.j();
                }
                s();
                if (this.mOS != null) {
                    this.mOS.d();
                    this.mOS = null;
                }
                if (this.mPh != null) {
                    this.mPh.dispose();
                    this.mPh = new io.reactivex.disposables.a();
                }
                a(oVar.e, false);
                return;
            }
            boolean z = this.R != null && this.R.equals("1");
            this.R = "1";
            this.mPc.a();
            this.mPb.a();
            this.mPa.a();
            this.mOZ.c();
            this.mPe.a();
            if (this.mPh != null) {
                this.mPh.dispose();
                this.mPh = new io.reactivex.disposables.a();
            }
            if ("1".equals(oVar.f)) {
                this.H = false;
                if (this.mOI != null && !h.isEmpty(this.mOI.t)) {
                    this.mOI.t.clear();
                }
                this.ab = oVar.mOj.mCover;
                this.mOY.setVisibility(0);
                this.mOX.setBlur(true);
                this.mOX.i(oVar.mOj.mCover, 0, 0, 0);
            }
            if (!oVar.mOj.mTargetKey.equals(this.P)) {
                this.aq = oVar.g;
                if (!z) {
                    this.B = false;
                    r();
                } else if (!"2".equals(this.mPf) && ("2".equals(this.aq) || "3".equals(this.aq) || "4".equals(this.aq))) {
                    this.mPf = "2";
                    this.mPg = new com.kascend.chushou.player.feedback.a();
                    if (this.mPg.mXI != null) {
                        this.mPg.mXI.reset();
                        this.mPg.mXI.roomId = oVar.mOj.mTargetKey;
                        this.mPg.mXI.enterType = 1;
                        this.mPg.b = System.currentTimeMillis();
                    }
                }
                this.B = false;
                this.P = oVar.mOj.mTargetKey;
                this.Q = this.P;
                this.ab = oVar.mOj.mCover;
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
                JSONObject M = com.kascend.chushou.d.e.M("_fromView", str, "_sc", oVar.mOj.mSC);
                com.kascend.chushou.toolkit.a.c.a(this.w, M);
                if (this.mON != null) {
                    this.mON.a();
                    this.mON.a(this.P);
                }
                if (this.mOI != null) {
                    this.mOI.a((PlayUrl) null);
                    this.mOI.f();
                    if (this.mOI.c() != null) {
                        this.mOI.c().clear();
                    }
                    this.mOI.i.clear();
                }
                if (this.mOG != null) {
                    this.mOG.j();
                }
                a(M.toString(), false);
                return;
            }
            Toast.makeText(this, a.i.str_same_room, 0).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dAT() {
        FullRoomInfo dBw;
        String str;
        RoomInfo roomInfo;
        if (nC()) {
            str = null;
            dBw = null;
        } else {
            dBw = this.mOI.dBw();
            str = (dBw == null || (roomInfo = dBw.mRoominfo) == null) ? null : roomInfo.mGameId;
        }
        return !this.L && (dBw == null || h.isEmpty(str));
    }

    @Subscribe
    public void onMessageEvent(i iVar) {
        if (!isFinishing() && iVar.a != 21 && iVar.a != 22) {
            if (iVar.a == 0 && (iVar.b instanceof Boolean)) {
                if (((Boolean) iVar.b).booleanValue() && !isFinishing()) {
                    w();
                    if (this.mOG != null) {
                        this.mOG.f();
                    }
                }
            } else if (iVar.a == 46) {
                if ((iVar.b instanceof String) && this.mOG != null) {
                    this.mOG.c((String) iVar.b);
                }
            } else if (iVar.a == 54) {
                if (iVar.b instanceof String) {
                    this.mPa.a((String) iVar.b);
                }
            } else if (iVar.a == 55) {
                if (this.mOG != null) {
                    this.mOG.O();
                }
            } else if (iVar.a == 56 && this.mOG != null) {
                this.mOG.P();
            }
        }
    }

    @Subscribe
    public void onRefreshSubscribeEvent(m mVar) {
        if (isFinishing() && this.mOI != null && this.mOI.dBy() != null) {
            RoomInfo dBy = this.mOI.dBy();
            if (mVar.a(dBy.mCreatorUID, dBy.mRoomID)) {
                dBy.mIsSubscribed = mVar.c;
            }
        }
    }

    @Subscribe
    public void onPlayerEvent(k kVar) {
        if (kVar.a == 1 && !isFinishing()) {
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
        if (this.m || this.mOD == null || this.mOE == null) {
            R();
        }
        if (this.mON != null) {
            this.mON.d();
        }
        if (!nC()) {
            if (this.mOS != null && !this.mOS.c()) {
                this.mOS.a();
            }
            v();
            if (this.mOI != null && this.mOI.dBw() != null && this.mOI.dBw().cycleLiveRoomInfo != null && !h.isEmpty(this.mOI.dBw().cycleLiveRoomInfo.roomId)) {
                u();
            }
        }
        super.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.view.base.BaseActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        tv.chushou.zues.utils.e.e(this.v, MissionEvent.MESSAGE_DESTROY);
        if (this.mOI != null && this.mOI.dBw() != null && this.mOI.dBw().cycleLiveRoomInfo != null && !h.isEmpty(this.mOI.dBw().cycleLiveRoomInfo.eventName)) {
            j.dAR().a(this.P + dBi());
        }
        if ("2".equals(this.mPf) && this.mPg != null && this.mPg.mXI != null) {
            this.mPg.mXI.time = System.currentTimeMillis() - this.mPg.b;
            this.mPg.a();
            this.mPg.b();
        }
        this.mOZ.d();
        this.mPa.b();
        this.mPb.b();
        O();
        this.mOW = null;
        a = null;
        if (this.mPk != null) {
            this.mPk.cp(null);
            this.mPk = null;
        }
        if (this.mOS != null) {
            this.mOS.d();
            this.mOS = null;
        }
        if (this.mON != null) {
            this.mON.c();
            this.mON = null;
        }
        if (this.mOI != null) {
            this.mOI.mQn = null;
            this.mOI.mQm = null;
        }
        if (this.mOI != null) {
            this.mOI.b();
            this.mOI = null;
        }
        this.mOB = null;
        this.mOG = null;
        this.mOH = null;
        this.mOJ = null;
        this.mOK = null;
        this.mOL = null;
        this.mOM = null;
        this.aQb = null;
        this.mOO = null;
        this.mOP = null;
        this.mOQ = null;
        this.Z = null;
        this.mOR = null;
        if (this.mOV != null && this.mOV.isHeld()) {
            this.mOV.release();
            this.mOV = null;
        }
        if (this.mPj != null) {
            unregisterReceiver(this.mPj);
            this.mPj = null;
        }
        h.dPg();
        tv.chushou.zues.a.a.cq(this);
        this.mPh.dispose();
        this.mPb.b();
        this.mPc.b();
        this.mOZ.d();
        this.mPa.b();
        this.mPe.b();
        super.onDestroy();
        System.gc();
    }

    @Subscribe
    public void onSendGameGiftEvent(n nVar) {
        if (!isFinishing() && this.mOG != null) {
            this.mOG.a(nVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.view.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        tv.chushou.zues.utils.e.d(this.v, MissionEvent.MESSAGE_PAUSE);
        if (this.mOS != null) {
            this.mOS.b();
        }
        if (this.mON != null) {
            this.mON.b(false);
        }
        k();
        this.m = true;
        super.onPause();
    }

    @Override // android.app.Activity
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.mOG != null ? this.mOG.a(motionEvent) : super.onTouchEvent(motionEvent);
    }

    public void c() {
        if ("1".equals(this.R)) {
            j.dAR().a(this.P + dBi());
        } else {
            j.dAR().b(this.P);
        }
    }

    private void a(boolean z, boolean z2) {
        int i = 0;
        tv.chushou.zues.utils.e.i(this.v, "startLoadingVideo <------------- mbPrepareingVideo = " + this.K);
        if (this.mOD != null) {
            this.mOD.setHardwearDecod(com.kascend.chushou.d.h.dAM().a);
        }
        if (this.mOE != null) {
            this.mOE.setHardwearDecod(com.kascend.chushou.d.h.dAM().a);
        }
        if (this.mOC != null) {
            this.mOC.setHardwearDecod(com.kascend.chushou.d.h.dAM().a);
        }
        if (!this.K) {
            if (z && this.mOG != null) {
                if (!z2) {
                    this.t = null;
                    this.mOG.e();
                }
            } else if (this.mOG != null && !z2) {
                this.t = null;
                this.mOG.H = false;
                RxExecutor.post(null, EventThread.MAIN_THREAD, new Runnable() { // from class: com.kascend.chushou.player.VideoPlayer.7
                    @Override // java.lang.Runnable
                    public void run() {
                        VideoPlayer.this.mOG.x();
                    }
                });
            }
            this.K = true;
            if (this.mOI != null && this.mOI.dBx() != null) {
                PlayUrl dBx = this.mOI.dBx();
                while (true) {
                    int i2 = i;
                    if (i2 >= dBx.mUrlDetails.size()) {
                        break;
                    }
                    UrlDetails urlDetails = dBx.mUrlDetails.get(i2);
                    if (urlDetails.mUrl.equals(dBx.mSelectedUrl)) {
                        String str = dBx.mUrlDetails.get(i2).mDefinitionType;
                        String str2 = urlDetails.mBitrate;
                    }
                    i = i2 + 1;
                }
            }
            if (z2) {
                if (this.d) {
                    this.mOD.setVideoURI(this.mOB);
                    this.mOD.open();
                    return;
                }
                this.mOE.setVideoURI(this.mOB);
                this.mOE.open();
                return;
            }
            this.mOC.setVideoURI(this.mOB);
            this.mOC.open();
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        try {
            if (motionEvent.getAction() == 0) {
                if (this.mOG != null && this.mOG.b(motionEvent)) {
                    return true;
                }
                if ("2".equals(this.mPf) && this.mOG != null) {
                    this.mOG.a(motionEvent);
                }
            } else if (this.mOG != null && this.mOG.b(motionEvent)) {
                return true;
            }
            return super.dispatchTouchEvent(motionEvent);
        } catch (Exception e) {
            return false;
        }
    }

    @Override // android.support.v7.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.mOG != null && this.mOG.a(i, keyEvent)) {
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
        if (this.mOI != null && this.mOI.dBw() != null && this.mOI.dBw().cycleLiveRoomInfo != null && !h.isEmpty(this.mOI.dBw().cycleLiveRoomInfo.roomId)) {
            this.mOY.setVisibility(0);
            this.mOX.setBlur(true);
            this.mOX.i(this.mOI.dBw().cycleLiveRoomInfo.avatar, 0, 0, 0);
            this.mOX.setVisibility(0);
            j.dAR().a(this.P + dBi());
            this.mOB = null;
            R();
            this.Q = this.mOI.dBw().cycleLiveRoomInfo.roomId;
            a(this.P, dBi(), false);
        }
    }

    public void a(boolean z) {
        if (this.mOG != null) {
            this.mOG.j(z);
        }
    }

    public void a(boolean z, Uri uri, boolean z2) {
        tv.chushou.zues.utils.e.d(this.v, "loadIfNecessary reload=" + z + " isChangeLines-->" + z2);
        if (this.mOD != null && this.mOE != null) {
            if (uri != null) {
                this.mOB = uri;
            }
            if (z2) {
                this.e = z2;
            }
            this.M = false;
            this.N = 0L;
            this.O = 0;
            this.mPk.removeMessages(7);
            if (z) {
                if (z2) {
                    if (!this.d) {
                        this.mOE.setOnActivityCallBack(this.mPq);
                    } else {
                        this.mOD.setOnActivityCallBack(this.mPp);
                    }
                } else if (this.d) {
                    this.mOE.setOnActivityCallBack(this.mPq);
                } else {
                    this.mOD.setOnActivityCallBack(this.mPp);
                }
                this.K = false;
                b(true, z2);
            } else if (!this.J) {
                b(true, z2);
            }
            this.mPk.L(6, 3000L);
        }
    }

    private void b(boolean z, boolean z2) {
        VideoPlayInfo O;
        if ("1".equals(this.R)) {
            O = j.dAR().N(this.P + dBi(), KeepJobService.JOB_CHECK_PERIODIC);
        } else {
            O = j.dAR().O(this.P, KeepJobService.JOB_CHECK_PERIODIC);
        }
        if (O != null) {
            a(z, z2);
        } else if ("1".equals(this.R)) {
            a(this.P, dBi(), false);
        } else {
            aO(this.P, false);
        }
    }

    public tv.chushou.common.player.a dAU() {
        return this.mOC;
    }

    public tv.chushou.common.player.a dAV() {
        return this.mOD;
    }

    public tv.chushou.common.player.a dAW() {
        return this.mOE;
    }

    public void a(tv.chushou.common.player.a aVar) {
        this.mOC = aVar;
    }

    public b dAX() {
        return this.mOI;
    }

    public com.kascend.chushou.widget.a.b dAY() {
        return this.mON;
    }

    public void a(int i, String str) {
        a(i, str, false, this.B);
    }

    public void a(int i, String str, boolean z) {
        a(i, str, false, this.B, z);
    }

    public void a(int i, String str, boolean z, boolean z2) {
        a(i, str, z, z2, false);
    }

    public void a(int i, String str, boolean z, boolean z2, boolean z3) {
        a(i, str, z, z2, z3, false);
    }

    public void a(int i, String str, boolean z, boolean z2, boolean z3, boolean z4) {
        boolean z5;
        FullRoomInfo dBw;
        this.r = -1L;
        if (this.s != -1 && this.s != 0) {
            this.r = this.s;
            this.s = -1L;
        }
        if (nC() && this.mOC != null && this.mOC.getPlayState() == 4) {
            this.r = this.mOC.getCurrentPos();
        }
        this.mPl = false;
        tv.chushou.zues.utils.e.d(this.v, "screenChange()<-----");
        tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard(this);
        if (str != null) {
            this.R = str;
        }
        if (!this.C || !z3 || "3".equals(this.R) || this.mOI == null || (dBw = this.mOI.dBw()) == null || dBw.mRoominfo == null || dBw.mRoominfo.mStyle != 1) {
            z5 = false;
        } else {
            z5 = true;
            i = 0;
        }
        if ("2".equals(this.mPf)) {
            setRequestedOrientation(1);
            ((VideoPlayer) this.w).f(true);
            WindowManager.LayoutParams attributes = getWindow().getAttributes();
            attributes.flags &= -1025;
            getWindow().setAttributes(attributes);
            View decorView = getWindow().getDecorView();
            getWindow().clearFlags(512);
            decorView.setSystemUiVisibility(1792);
            if (Build.VERSION.SDK_INT >= 21) {
                getWindow().setStatusBarColor(0);
            }
            getWindow().addFlags(256);
            if (this.mOP != null) {
                this.mOP.setSystemUiVisibility(1792);
            }
        } else if (1 == i) {
            setRequestedOrientation(1);
            ((VideoPlayer) this.w).f(true);
            if (com.kascend.chushou.b.dAF().d == 1) {
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
                decorView2.setSystemUiVisibility(1792);
                if (Build.VERSION.SDK_INT >= 21) {
                    getWindow().setStatusBarColor(0);
                }
                getWindow().addFlags(256);
            }
        } else {
            ((VideoPlayer) this.w).wd(false);
            ((VideoPlayer) this.w).f(true);
            if (z5) {
                setRequestedOrientation(1);
            } else if (Build.VERSION.SDK_INT > 8) {
                setRequestedOrientation(6);
            } else {
                setRequestedOrientation(0);
            }
            getWindow().addFlags(512);
            getWindow().addFlags(256);
        }
        if (this.mON == null) {
            this.mON = new com.kascend.chushou.widget.a.b();
        }
        if (this.mON != null) {
            this.mON.a(this.P);
        }
        if (this.R.equals("5")) {
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            if (this.mOG != null) {
                beginTransaction.remove(this.mOG);
                this.mOG = null;
            }
            if (this.mOH != null) {
                beginTransaction.remove(this.mOH);
                this.mOH = null;
            }
            this.mOH = new com.kascend.chushou.view.user.b();
            beginTransaction.add(a.f.fl_fragment, this.mOH);
            beginTransaction.commitAllowingStateLoss();
        } else {
            FragmentTransaction beginTransaction2 = getSupportFragmentManager().beginTransaction();
            if (this.mOG != null) {
                beginTransaction2.remove(this.mOG);
                this.mOG = null;
            }
            if (this.mOH != null) {
                beginTransaction2.remove(this.mOH);
                this.mOH = null;
            }
            if ("2".equals(this.mPf)) {
                this.mOG = com.kascend.chushou.player.e.e.a(this.ab, z2, this.aq, this.P);
            } else if (1 == i) {
                if (!this.R.equals("3")) {
                    if (z4) {
                        v();
                    }
                    this.mOG = new com.kascend.chushou.player.d.a();
                    Bundle bundle = new Bundle();
                    bundle.putString("mCover", this.ab);
                    bundle.putBoolean("mInitViewAsync", z2);
                    this.mOG.setArguments(bundle);
                }
            } else {
                this.mOG = new com.kascend.chushou.player.d.b();
                Bundle bundle2 = new Bundle();
                if (z5) {
                    i = 1;
                }
                bundle2.putInt("mExtraOrientation", i);
                bundle2.putString("mViewType", this.R);
                this.mOG.setArguments(bundle2);
            }
            beginTransaction2.add(a.f.fl_fragment, this.mOG);
            beginTransaction2.commitAllowingStateLoss();
            this.H = true;
        }
        tv.chushou.zues.utils.e.d(this.v, "screenChange()----->");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean nC() {
        return this.R != null && this.R.equals("3");
    }

    private void R() {
        if (this.mOG != null) {
            this.mOG.mTO = null;
        }
        if (this.mOC != null) {
            this.mOC.release();
            this.mOC = null;
            this.K = false;
        }
        if (this.mOD != null) {
            this.mOD.release();
            this.mOD = null;
        }
        if (this.mOE != null) {
            this.mOE.release();
            this.mOE = null;
        }
        if (this.mOF != null) {
            this.mOF.c();
        }
        this.d = false;
        this.e = false;
        this.M = false;
        this.mOF = new c();
        this.mOD = this.mOF.dBA();
        this.mOD.setOnActivityCallBack(this.mPp);
        this.mOE = this.mOF.dBB();
        this.mOE.setOnActivityCallBack(this.mPq);
        if (!this.d) {
            this.mOC = this.mOD;
        } else {
            this.mOC = this.mOE;
        }
        if (this.mOG != null) {
            this.mOG.mTO = this.mOC;
        }
    }

    public void j() {
        if (this.mOC != null) {
            this.mOC.pause();
            this.mOC.stop();
            this.mOC.release();
            this.mOC = null;
        }
        if (this.mOD != null) {
            this.mOD.stop();
            this.mOD.release();
            this.mOD = null;
        }
        if (this.mOE != null) {
            this.mOE.stop();
            this.mOE.release();
            this.mOE = null;
        }
        if (this.mOF != null) {
            this.mOF.c();
        }
    }

    public void k() {
        tv.chushou.common.player.a aVar = this.mOC;
        if (aVar != null) {
            aVar.pause();
            aVar.stop();
        }
        tv.chushou.common.player.a aVar2 = this.mOD;
        if (aVar2 != null) {
            aVar2.stop();
        }
        tv.chushou.common.player.a aVar3 = this.mOE;
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
    public void cWe() {
        if (this.mPl) {
            if (this.mOG != null) {
                this.mOG.s();
            }
        } else if (this.mPk != null) {
            this.mPk.a(this.mPk.Oe(3), 20L);
        }
    }

    private void b(final String str, String str2) {
        com.kascend.chushou.c.c.dAI().a(new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.VideoPlayer.8
            @Override // com.kascend.chushou.c.b
            public void a() {
                VideoPlayer.this.L = true;
            }

            @Override // com.kascend.chushou.c.b
            public void a(String str3, JSONObject jSONObject) {
                boolean z = false;
                if (!VideoPlayer.this.isFinishing()) {
                    ParserRet s = com.kascend.chushou.c.f.s(str, jSONObject);
                    if (s.mRc != 0 || s.mData == null) {
                        VideoPlayer.this.bN(s.mMessage, s.mRc);
                        return;
                    }
                    FullRoomInfo fullRoomInfo = (FullRoomInfo) s.mData;
                    VideoPlayer.this.dBg().a(fullRoomInfo.mBangMap);
                    if (h.isEmpty(fullRoomInfo.mRoominfo.mRoomID)) {
                        fullRoomInfo.mRoominfo.mRoomID = VideoPlayer.this.P;
                    }
                    if (!h.isEmpty(fullRoomInfo.mGeneralTabGifts)) {
                        com.kascend.chushou.d.e.a(VideoPlayer.this.mPh, new ArrayList(fullRoomInfo.mGeneralTabGifts));
                    }
                    if (VideoPlayer.this.mOI != null) {
                        VideoPlayer.this.mOI.a(fullRoomInfo);
                    }
                    VideoPlayer.this.L = false;
                    if (VideoPlayer.this.B) {
                        if (VideoPlayer.this.C && !"3".equals(VideoPlayer.this.R) && fullRoomInfo != null && fullRoomInfo.mRoominfo != null && fullRoomInfo.mRoominfo.mStyle == 1 && !h.isEmpty(fullRoomInfo.mRoominfo.mGameId)) {
                            z = true;
                        }
                        if (!z) {
                            if (VideoPlayer.this.mOG != null) {
                                VideoPlayer.this.mOG.a(VideoPlayer.this.mOI);
                            }
                            if (!h.isEmpty(fullRoomInfo.mRoominfo.mGameId)) {
                                VideoPlayer.this.cWe();
                            } else {
                                if (VideoPlayer.this.mOI != null) {
                                    VideoPlayer.this.mOI.f = null;
                                }
                                VideoPlayer.this.cWe();
                            }
                        } else {
                            VideoPlayer.this.a(1, "1", true);
                            if (VideoPlayer.this.mOG != null) {
                                VideoPlayer.this.mOG.a(VideoPlayer.this.mOI);
                            }
                        }
                    } else {
                        if (h.isEmpty(fullRoomInfo.mRoominfo.mGameId)) {
                            if (VideoPlayer.this.mOI != null) {
                                VideoPlayer.this.mOI.f = null;
                            }
                            VideoPlayer.this.a(1, "1");
                        } else {
                            VideoPlayer.this.a(1, "1", true);
                        }
                        if (VideoPlayer.this.mOG != null) {
                            VideoPlayer.this.mOG.a(VideoPlayer.this.mOI);
                        }
                    }
                    if (VideoPlayer.this.mOI != null && !VideoPlayer.this.mOI.m()) {
                        if (VideoPlayer.this.mOS != null) {
                            VideoPlayer.this.mOS.d();
                            VideoPlayer.this.mOS = null;
                        }
                        VideoPlayer.this.mOS = new com.kascend.chushou.toolkit.d(900000L, VideoPlayer.this.mOU, VideoPlayer.this.mPk);
                        VideoPlayer.this.mOS.a();
                    }
                }
            }

            @Override // com.kascend.chushou.c.b
            public void a(int i, String str3) {
                if (!VideoPlayer.this.isFinishing()) {
                    VideoPlayer.this.bN(str3, i);
                }
            }
        }, str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bN(String str, int i) {
        if (this.mOI != null) {
            this.mOI.a((FullRoomInfo) null);
        }
        this.L = false;
        bO(str, i);
        if (this.mOC != null) {
            this.mOC.stop();
        }
        if (this.mOD != null) {
            this.mOD.stop();
        }
        if (this.mOE != null) {
            this.mOE.stop();
        }
    }

    public void l() {
        tv.chushou.zues.utils.e.d(this.v, "retryGetPlayList");
        c();
        if (nC()) {
            aO(this.P, false);
        } else {
            a(this.P, dBi(), false);
        }
    }

    public void m() {
        a(this.mOW, false);
    }

    private void a(final String str, String str2, boolean z) {
        this.J = true;
        VideoPlayInfo N = j.dAR().N(str + str2, KeepJobService.JOB_CHECK_PERIODIC);
        if (N != null) {
            a((ArrayList) N.mPlayUrls);
            this.J = false;
        } else if (z) {
            ParserRet fm = com.kascend.chushou.player.c.a.dBC().fm(str, str2);
            if (fm.mRc != 0) {
                tv.chushou.zues.utils.e.e(this.v, "getPlayUrlSync fail, try to getPlaylist");
                a(str, str2, false);
                return;
            }
            a(fm, str);
        } else {
            com.kascend.chushou.player.c.a.dBC().a(str, str2, new a.InterfaceC0687a() { // from class: com.kascend.chushou.player.VideoPlayer.9
                @Override // com.kascend.chushou.player.c.a.InterfaceC0687a
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
    private void aO(final String str, boolean z) {
        boolean equals;
        this.J = true;
        VideoPlayInfo O = j.dAR().O(str, KeepJobService.JOB_CHECK_PERIODIC);
        if (O != null) {
            a((ArrayList) O.mPlayUrls);
            this.J = false;
            return;
        }
        if (!h.isEmpty(this.mOW)) {
            try {
                equals = "1".equals(new JSONObject(this.mOW).optString("auto"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (!z) {
                ParserRet aP = com.kascend.chushou.player.c.a.dBC().aP(str, equals);
                if (aP.mRc != 0) {
                    tv.chushou.zues.utils.e.e(this.v, "getVideoPlayUrlSync fail, try to getVideoPlaylist");
                    aO(str, false);
                    return;
                }
                a(aP, str);
                return;
            }
            com.kascend.chushou.player.c.a.dBC().a(str, new a.InterfaceC0687a() { // from class: com.kascend.chushou.player.VideoPlayer.10
                @Override // com.kascend.chushou.player.c.a.InterfaceC0687a
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
                if (this.mOI.f == null) {
                    this.mOI.f = new ArrayList<>();
                }
                this.mOI.f.clear();
                this.mOI.f.addAll(arrayList);
                if ("1".equals(this.R)) {
                    j.dAR().a(str + dBi(), arrayList);
                } else {
                    j.dAR().r(str, arrayList);
                }
                a(arrayList);
                return;
            }
            if (this.mOI != null) {
                this.mOI.f = null;
            }
            if (this.mPk != null) {
                Message Oe = this.mPk.Oe(5);
                Oe.arg1 = 2;
                Oe.arg2 = parserRet.mRc;
                this.mPk.O(Oe);
            }
        }
    }

    private void bO(String str, int i) {
        s();
        if (this.mON != null) {
            this.mON.a();
        }
        if (h.isEmpty(str)) {
            str = getString(a.i.str_load_data_failed);
        }
        a(str, i);
    }

    public void n() {
        if (this.mOQ != null && this.aQb != null && this.mOR != null) {
            this.mOQ.setVisibility(0);
            this.aQb.setVisibility(8);
            this.mOR.setVisibility(8);
        }
    }

    public void o() {
        if (this.mOX != null && this.mOX.getVisibility() == 0) {
            this.mOX.xi(0);
            this.mOX.setVisibility(8);
        }
    }

    public void p() {
        if (this.mOY != null && this.mOY.getVisibility() == 0) {
            this.mOY.setVisibility(8);
        }
    }

    public void q() {
        this.mPl = true;
    }

    protected void r() {
        this.mOQ.setVisibility(8);
        this.mOR.setVisibility(0);
        this.aQb.setVisibility(0);
        if (this.mOM != null) {
            this.mOK.setVisibility(8);
            this.mOM.setVisibility(0);
            this.mOL.setText(getString(a.i.str_dialog_loading_content));
            this.mOL.setVisibility(8);
        }
    }

    protected void a(String str, int i) {
        this.mOQ.setVisibility(8);
        this.mOR.setVisibility(0);
        this.aQb.setVisibility(0);
        if (this.mOM != null) {
            if (str == null) {
                str = getString(a.i.str_nodata);
            }
            if (str != null) {
                this.mOL.setText(str);
                if (str.equals(getString(a.i.s_no_available_network))) {
                    this.mOK.setImageResource(a.e.commonres_pagestatus_net_error);
                } else if (str.equals(getString(a.i.str_nodata)) || str.equals(getString(a.i.str_nohistory)) || str.equals(getString(a.i.str_nolive)) || str.equals(getString(a.i.str_nosubscribe))) {
                    this.mOK.setClickable(true);
                    this.mOK.setImageResource(a.e.commonres_pagestatus_empty);
                } else if (str.equals(getString(a.i.str_inbox_login_notify)) || str.equals(getString(a.i.push_login)) || str.equals(getString(a.i.str_login_timeout))) {
                    this.mOK.setImageResource(a.e.commonres_pagestatus_need_login);
                    this.mOK.setClickable(true);
                } else {
                    this.mOK.setImageResource(a.e.commonres_pagestatus_unknown_error);
                    this.mOK.setClickable(true);
                }
            }
            if (i == 4001) {
                this.mOK.setImageResource(a.e.commonres_pagestatus_net_error);
                this.mOK.setClickable(false);
                this.mOL.setVisibility(0);
                this.mOL.setText(getString(a.i.str_dissubscribe_btn));
                this.mOL.setOnClickListener(new View.OnClickListener() { // from class: com.kascend.chushou.player.VideoPlayer.11
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (!VideoPlayer.this.j) {
                            com.kascend.chushou.c.c.dAI().b(new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.VideoPlayer.11.1
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
                                        tv.chushou.zues.utils.g.M(VideoPlayer.this, a.i.subscribe_failed);
                                    }
                                }
                            }, VideoPlayer.this.P, (String) null, VideoPlayer.this.mOI.h);
                        }
                    }
                });
            } else if (i == 404) {
                this.mOL.setText(str);
                this.mOL.setVisibility(0);
                this.mOK.setClickable(false);
                this.mOK.setImageResource(a.e.commonres_pagestatus_empty);
            } else if (i == 4002) {
                if (h.isEmpty(str)) {
                    this.mOL.setVisibility(8);
                } else {
                    this.mOL.setVisibility(0);
                    this.mOL.setText(str);
                }
            } else {
                this.mOL.setVisibility(8);
            }
            this.mOK.setVisibility(0);
            this.mOM.setVisibility(8);
            this.mOY.setVisibility(8);
        }
    }

    public void s() {
        if (this.mPk != null) {
            this.mPk.removeMessages(1);
        }
    }

    private void a(ArrayList<PlayUrl> arrayList) {
        boolean z;
        if (this.mOI.f == null) {
            this.mOI.f = new ArrayList<>();
        }
        this.mOI.f.clear();
        this.mOI.f.addAll(arrayList);
        if (com.kascend.chushou.d.e.b() && !"4".equals(this.aq)) {
            int c = com.kascend.chushou.d.e.c();
            if (c == -1) {
                b(arrayList);
                return;
            } else if (c == 0) {
                this.mOI.d = false;
                f(arrayList, true);
                return;
            } else {
                if (this.mOI != null && this.mOI.f != null) {
                    Iterator<PlayUrl> it = this.mOI.f.iterator();
                    while (it.hasNext()) {
                        if ("2".equals(it.next().mType)) {
                            z = true;
                            break;
                        }
                    }
                }
                z = false;
                this.mOI.d = z;
                f(arrayList, true);
                return;
            }
        }
        if (this.mOI.e) {
            this.mOI.d = !this.mOI.d;
            this.mOI.e = false;
            this.mPo = true;
        } else {
            this.mOI.d = "4".equals(this.aq);
        }
        f(arrayList, true);
    }

    private void b(ArrayList<PlayUrl> arrayList) {
        if ("1".equals(this.R)) {
            if ("2".equals(this.mPf)) {
                d(false, arrayList);
            } else if (this.mOG != null) {
                this.mOG.f(arrayList, false);
            }
        } else if (this.mOG != null) {
            this.mOG.f(arrayList, false);
        }
    }

    public void b(boolean z) {
        this.mOI.d = false;
        com.kascend.chushou.d.e.a(0);
        ArrayList<PlayUrl> arrayList = this.mOI.f;
        if (!h.isEmpty(arrayList)) {
            if (z) {
                f(arrayList, false);
                if (this.mPk != null) {
                    this.mPk.Oc(2);
                    return;
                }
                return;
            }
            f(arrayList, true);
        }
    }

    public void c(boolean z) {
        this.mOI.d = true;
        com.kascend.chushou.d.e.a(1);
        ArrayList<PlayUrl> arrayList = this.mOI.f;
        if (!h.isEmpty(arrayList)) {
            if (z) {
                f(arrayList, false);
                if (this.mPk != null) {
                    this.mPk.Oc(2);
                    return;
                }
                return;
            }
            f(arrayList, true);
        }
    }

    @Subscribe
    public void onNotifyEvent(com.kascend.chushou.b.a.a.j jVar) {
        if (!isFinishing() && jVar.a == 1 && !"5".equals(this.R) && !dAT()) {
            tv.chushou.zues.utils.e.d(this.v, "onNetworkChangeEvent 3G=" + com.kascend.chushou.b.dAF().b + "  wifi=" + com.kascend.chushou.b.dAF().a);
            if (com.kascend.chushou.d.e.b() && !"4".equals(this.aq)) {
                if (com.kascend.chushou.d.e.c() == -1) {
                    if (this.mOG != null) {
                        this.mOG.e(false);
                    }
                    if ("1".equals(this.R)) {
                        if ("2".equals(this.mPf)) {
                            d(true, null);
                            return;
                        } else if (this.mOG != null) {
                            this.mOG.f(this.mOI.f, true);
                            return;
                        } else {
                            return;
                        }
                    } else if (this.mOG != null) {
                        this.mOG.f(this.mOI.f, true);
                        return;
                    } else {
                        return;
                    }
                }
                RxExecutor.postDelayed(this.mPh, EventThread.MAIN_THREAD, 10L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.VideoPlayer.12
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!VideoPlayer.this.isFinishing() && com.kascend.chushou.b.dAF().b && !com.kascend.chushou.b.dAF().a) {
                            tv.chushou.zues.utils.g.c(VideoPlayer.this.w, VideoPlayer.this.getString(a.i.str_monet_notify));
                        }
                    }
                });
            } else if (com.kascend.chushou.b.dAF().a || com.kascend.chushou.b.dAF().b) {
                t();
                if (this.mPk != null) {
                    this.mPk.Oc(2);
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
    private void f(ArrayList<PlayUrl> arrayList, boolean z) {
        PlayUrl playUrl;
        PlayUrl playUrl2;
        String str;
        String str2;
        boolean z2;
        PlayUrl playUrl3;
        if (arrayList.size() > 0) {
            if (this.mOI.d) {
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
            String d = com.kascend.chushou.d.h.dAM().d();
            String str3 = h.isEmpty(d) ? "2" : d;
            if (this.mOI.d) {
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
                if (this.mOI != null) {
                    this.mOI.a(playUrl2);
                    if (this.mPk != null) {
                        Message Oe = this.mPk.Oe(5);
                        Oe.arg1 = 1;
                        this.mPk.O(Oe);
                    }
                }
                String b = com.kascend.chushou.player.c.a.b(playUrl2);
                if (!h.isEmpty(b)) {
                    this.mOB = Uri.parse(b);
                    if (this.mPo) {
                        this.mPo = false;
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (z && this.mOC != null) {
                        a(false, z2);
                    }
                }
            }
        }
    }

    public void d(final boolean z, ArrayList<PlayUrl> arrayList) {
        if (this.mOT == null || this.mOT.a <= 0) {
            this.mOT = com.kascend.chushou.view.b.a.a.dDf();
            this.mOT.a(new a.InterfaceC0706a() { // from class: com.kascend.chushou.player.VideoPlayer.13
                @Override // com.kascend.chushou.view.b.a.a.InterfaceC0706a
                public void a(int i) {
                    if (i == a.f.tv_play_video) {
                        VideoPlayer.this.mOT.dismissAllowingStateLoss();
                        VideoPlayer.this.b(z);
                    } else if (i == a.f.tv_play_audio) {
                        VideoPlayer.this.mOT.dismissAllowingStateLoss();
                        VideoPlayer.this.c(z);
                    } else if (i == a.f.iv_close) {
                        VideoPlayer.this.finish();
                    } else {
                        if (i == a.f.tv_union_proxy) {
                        }
                    }
                }
            });
            this.mOT.show(getSupportFragmentManager(), "showRoom");
        }
    }

    public void t() {
        if (this.mOT != null) {
            this.mOT.dismissAllowingStateLoss();
        }
        if (this.mOG != null) {
            this.mOG.v();
        }
    }

    public void u() {
        com.kascend.chushou.c.c.dAI().c(this.P, new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.VideoPlayer.16
            @Override // com.kascend.chushou.c.b
            public void a() {
            }

            @Override // com.kascend.chushou.c.b
            public void a(String str, JSONObject jSONObject) {
                if (!VideoPlayer.this.isFinishing()) {
                    ParserRet dA = com.kascend.chushou.c.e.dA(jSONObject);
                    if (dA.mRc == 0 && dA.mData != null) {
                        CycleLiveRoomInfo cycleLiveRoomInfo = (CycleLiveRoomInfo) dA.mData;
                        if (VideoPlayer.this.mOI != null && cycleLiveRoomInfo != null && !h.isEmpty(cycleLiveRoomInfo.roomId)) {
                            FullRoomInfo dBw = VideoPlayer.this.mOI.dBw();
                            if (dBw.cycleLiveRoomInfo == null) {
                                dBw.cycleLiveRoomInfo = cycleLiveRoomInfo;
                                VideoPlayer.this.d();
                            } else if (dBw.cycleLiveRoomInfo != null && !cycleLiveRoomInfo.roomId.equals(dBw.cycleLiveRoomInfo.roomId)) {
                                dBw.cycleLiveRoomInfo.copyCycleLiveRoomInfo(cycleLiveRoomInfo);
                                VideoPlayer.this.d();
                            } else {
                                dBw.cycleLiveRoomInfo.copyCycleLiveRoomInfo(cycleLiveRoomInfo);
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
        if (this.mOG != null) {
            this.mOG.N();
        }
    }

    public void v() {
        com.kascend.chushou.c.c.dAI().a(this.P, new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.VideoPlayer.17
            @Override // com.kascend.chushou.c.b
            public void a() {
            }

            @Override // com.kascend.chushou.c.b
            public void a(String str, JSONObject jSONObject) {
                if (!VideoPlayer.this.isFinishing()) {
                    ParserRet dB = com.kascend.chushou.c.e.dB(jSONObject);
                    if (dB.mRc == 0 && dB.mData != null) {
                        PkNotifyInfo pkNotifyInfo = (PkNotifyInfo) dB.mData;
                        VideoPlayer.this.mPd.b = VideoPlayer.this.P;
                        if (pkNotifyInfo != null) {
                            VideoPlayer.this.mPd.mTP = pkNotifyInfo;
                            if (VideoPlayer.this.mOG != null) {
                                VideoPlayer.this.mOG.a(pkNotifyInfo, VideoPlayer.this.P);
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
        if (this.mOJ != null) {
            this.mOJ.release();
            this.mOJ = null;
        }
        com.kascend.chushou.c.c.dAI().a(this.P, new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.VideoPlayer.18
            @Override // com.kascend.chushou.c.b
            public void a() {
            }

            @Override // com.kascend.chushou.c.b
            public void a(String str, JSONObject jSONObject) {
                if (!VideoPlayer.this.isFinishing()) {
                    ParserRet dC = com.kascend.chushou.c.e.dC(jSONObject);
                    if (dC.mRc == 0 && dC.mData != null) {
                        RoomExpandInfo roomExpandInfo = (RoomExpandInfo) dC.mData;
                        if (VideoPlayer.this.mOI != null) {
                            VideoPlayer.this.mOI.mQo = roomExpandInfo.mTopWebAdItem;
                            if (VideoPlayer.this.mOI.s == null) {
                                VideoPlayer.this.mOI.s = new ArrayList();
                            }
                            VideoPlayer.this.mOI.s.clear();
                            VideoPlayer.this.mOI.s.addAll(roomExpandInfo.mGiftTopRightIcons);
                            tv.chushou.zues.a.a.post(new i(50, VideoPlayer.this.mOI.mQo));
                        }
                        if (VideoPlayer.this.mOI != null) {
                            VideoPlayer.this.mOI.fr(roomExpandInfo.mExpandNavList);
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
                            VideoPlayer.this.mOZ.a(list);
                        }
                        List<com.kascend.chushou.player.ui.h5.c.c> list2 = roomExpandInfo.mLuckList;
                        if (!h.isEmpty(list2)) {
                            VideoPlayer.this.mPa.a(list2);
                        }
                        com.kascend.chushou.player.ui.h5.c.c cVar = roomExpandInfo.mVoteItem;
                        if (cVar != null) {
                            VideoPlayer.this.mPb.a(cVar);
                        }
                        List<com.kascend.chushou.player.ui.h5.c.b> list3 = roomExpandInfo.mInteractH5Item;
                        if (!h.isEmpty(list3)) {
                            VideoPlayer.this.mPe.a(list3);
                        }
                        List<com.kascend.chushou.player.ui.h5.c.b> list4 = roomExpandInfo.mInteractNavItem;
                        if (!h.isEmpty(list4)) {
                            VideoPlayer.this.mPe.a(list4);
                        }
                        VideoPlayer.this.mOJ = (PrivilegeInfo) dC.mData1;
                        if (VideoPlayer.this.mOJ != null) {
                            tv.chushou.zues.a.a.post(new l());
                        }
                        if (VideoPlayer.this.mOI != null) {
                            VideoPlayer.this.mOI.mQu = roomExpandInfo.mIconConfig;
                            VideoPlayer.this.dBg().a(roomExpandInfo.mIconConfig.bangConfig);
                        }
                        List<SkinConfig> list5 = roomExpandInfo.skinConfig;
                        if (list5 != null && VideoPlayer.this.mOI != null) {
                            VideoPlayer.this.mOI.mQy.clear();
                            int i = 0;
                            while (true) {
                                int i2 = i;
                                if (i2 >= list5.size()) {
                                    break;
                                }
                                SkinConfig skinConfig = list5.get(i2);
                                VideoPlayer.this.mOI.mQy.put(skinConfig.position, skinConfig.resource);
                                i = i2 + 1;
                            }
                            VideoPlayer.this.C();
                        }
                        VideoPlayer.this.a(roomExpandInfo.mIconConfig, VideoPlayer.this.mOI != null ? VideoPlayer.this.mOI.mQy : null);
                        if (roomExpandInfo.mColorMap != null && roomExpandInfo.mColorMap.size() > 0 && com.kascend.chushou.b.dAF().c != null && com.kascend.chushou.b.dAF().c.size() <= 0) {
                            com.kascend.chushou.b.dAF().c.putAll(roomExpandInfo.mColorMap);
                            tv.chushou.zues.a.a.post(new i(52, null));
                        }
                        AutoBang autoBang = roomExpandInfo.mAutoBang;
                        if (autoBang != null && autoBang.currentTime != 0 && autoBang.bangTime != 0) {
                            VideoPlayer.this.dBg().a(autoBang);
                        }
                        if (!h.isEmpty(roomExpandInfo.mRelatedRoomList) && VideoPlayer.this.mOI != null) {
                            VideoPlayer.this.mOI.t = roomExpandInfo.mRelatedRoomList;
                            if (VideoPlayer.this.mOG != null && VideoPlayer.this.H) {
                                VideoPlayer.this.mOG.w();
                            }
                        }
                        if (roomExpandInfo.mRoomNewUserInfo != null && roomExpandInfo.mRoomNewUserInfo.mBarrierNoviceGuide && !com.kascend.chushou.d.h.dAM().k() && VideoPlayer.this.mOG != null) {
                            VideoPlayer.this.mOG.J();
                        }
                        if (roomExpandInfo.mRoomNewUserInfo != null && roomExpandInfo.mRoomNewUserInfo.mRewardNoviceGuide && !com.kascend.chushou.d.h.dAM().l() && VideoPlayer.this.mOG != null) {
                            VideoPlayer.this.mOG.K();
                        }
                        if (!h.isEmpty(roomExpandInfo.mShopWindowInfos)) {
                            if (VideoPlayer.this.mOI != null) {
                                if (VideoPlayer.this.mOI.mQv == null) {
                                    VideoPlayer.this.mOI.mQv = new ArrayList();
                                }
                                VideoPlayer.this.mOI.mQv.addAll(roomExpandInfo.mShopWindowInfos);
                            }
                            if (VideoPlayer.this.mOG != null) {
                                VideoPlayer.this.mOG.L();
                            }
                        }
                        VideoPlayer.this.mPd.b = VideoPlayer.this.P;
                        if (roomExpandInfo.mPkNotifyInfo != null) {
                            VideoPlayer.this.mPd.mTP = roomExpandInfo.mPkNotifyInfo;
                            if (VideoPlayer.this.mOG != null) {
                                VideoPlayer.this.mOG.a(roomExpandInfo.mPkNotifyInfo, VideoPlayer.this.P);
                            }
                        } else {
                            VideoPlayer.this.mPd.mTP = null;
                        }
                        if (roomExpandInfo.mTrumpetPocket != null && VideoPlayer.this.mOI != null) {
                            VideoPlayer.this.mOI.mQx = roomExpandInfo.mTrumpetPocket;
                            if (VideoPlayer.this.mOG != null) {
                                VideoPlayer.this.mOG.M();
                            }
                        }
                        if (!h.isEmpty(roomExpandInfo.hotwordContentList)) {
                            if (VideoPlayer.this.mOI != null) {
                                if (VideoPlayer.this.mOI.mQw == null) {
                                    VideoPlayer.this.mOI.mQw = new ArrayList();
                                }
                                VideoPlayer.this.mOI.mQw.clear();
                                VideoPlayer.this.mOI.mQw.addAll(roomExpandInfo.hotwordContentList);
                            }
                            if (VideoPlayer.this.mOG != null) {
                                VideoPlayer.this.mOG.b(roomExpandInfo.hotwordContentList);
                            }
                        }
                        VideoPlayer.this.U();
                        return;
                    }
                    a(dC.mRc, dC.mMessage);
                }
            }

            @Override // com.kascend.chushou.c.b
            public void a(int i, String str) {
                tv.chushou.zues.utils.e.e(VideoPlayer.this.v, "get room gift popup list failed, rc =" + i + ", errorMsg=" + str);
            }
        }, this.mOW, this.mPf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U() {
        if (!h.isEmpty(com.kascend.chushou.a.a.dAG().z)) {
            StringBuilder sb = new StringBuilder();
            if (com.kascend.chushou.a.a.dAG().z.contains(com.kascend.chushou.a.a.f)) {
                if (sb.length() > 0) {
                    sb.append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                sb.append(com.kascend.chushou.a.a.f);
            }
            if (com.kascend.chushou.a.a.dAG().z.contains(com.kascend.chushou.a.a.g)) {
                if (sb.length() > 0) {
                    sb.append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                sb.append(com.kascend.chushou.a.a.g);
            }
            if (com.kascend.chushou.a.a.dAG().z.contains(com.kascend.chushou.a.a.i)) {
                if (sb.length() > 0) {
                    sb.append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                sb.append(com.kascend.chushou.a.a.i);
            }
            if (com.kascend.chushou.a.a.dAG().z.contains(com.kascend.chushou.a.a.h)) {
                if (sb.length() > 0) {
                    sb.append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                sb.append(com.kascend.chushou.a.a.h);
            }
            if (com.kascend.chushou.a.a.dAG().z.contains(com.kascend.chushou.a.a.j)) {
                if (sb.length() > 0) {
                    sb.append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                sb.append(com.kascend.chushou.a.a.j);
            }
            if (com.kascend.chushou.a.a.dAG().z.contains(com.kascend.chushou.a.a.l)) {
                if (sb.length() > 0) {
                    sb.append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                sb.append(com.kascend.chushou.a.a.l);
            }
            if (com.kascend.chushou.a.a.dAG().z.contains(com.kascend.chushou.a.a.m)) {
                if (sb.length() > 0) {
                    sb.append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                sb.append(com.kascend.chushou.a.a.m);
            }
            if (sb.length() != 0) {
                com.kascend.chushou.a.a.dAG().a(sb.toString(), this.P, new a.c() { // from class: com.kascend.chushou.player.VideoPlayer.19
                    @Override // com.kascend.chushou.a.a.c
                    public void a(List<ListItem> list) {
                        if (VideoPlayer.this.mOI != null && list != null) {
                            int i = 0;
                            while (true) {
                                int i2 = i;
                                if (i2 >= list.size()) {
                                    break;
                                }
                                if (list.get(i2).mAdExtraInfo != null) {
                                    if (com.kascend.chushou.a.a.f.equals(list.get(i2).mAdExtraInfo.mCode)) {
                                        VideoPlayer.this.mOI.mQn = list.get(i2);
                                    } else if (com.kascend.chushou.a.a.g.equals(list.get(i2).mAdExtraInfo.mCode)) {
                                        VideoPlayer.this.mOI.mQm = list.get(i2);
                                    } else if (com.kascend.chushou.a.a.i.equals(list.get(i2).mAdExtraInfo.mCode)) {
                                        VideoPlayer.this.mOI.mQp = list.get(i2);
                                    } else if (com.kascend.chushou.a.a.h.equals(list.get(i2).mAdExtraInfo.mCode)) {
                                        VideoPlayer.this.mOI.mQq = list.get(i2);
                                    } else if (com.kascend.chushou.a.a.j.equals(list.get(i2).mAdExtraInfo.mCode)) {
                                        VideoPlayer.this.mOI.mQt = list.get(i2);
                                    } else if (com.kascend.chushou.a.a.l.equals(list.get(i2).mAdExtraInfo.mCode)) {
                                        VideoPlayer.this.mOI.mQr = list.get(i2);
                                    } else if (com.kascend.chushou.a.a.m.equals(list.get(i2).mAdExtraInfo.mCode)) {
                                        VideoPlayer.this.mOI.mQs = list.get(i2);
                                    }
                                }
                                i = i2 + 1;
                            }
                            if (VideoPlayer.this.mOG != null) {
                                VideoPlayer.this.mOG.H();
                            }
                        }
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str, String str2) {
        if (nC()) {
            com.kascend.chushou.toolkit.a.a.j("type", "1", "value", str, "desc", str2, "videoId", this.P);
        }
    }

    public void d(boolean z) {
        int i;
        if (Build.VERSION.SDK_INT >= 11 && this.mOP != null) {
            if (!z) {
                if (Build.VERSION.SDK_INT >= 19) {
                    i = 5894;
                } else {
                    i = 1799;
                }
                this.mOP.setSystemUiVisibility(i);
                return;
            }
            this.mOP.setSystemUiVisibility(1792);
        }
    }

    public void e(boolean z) {
        int i;
        if (com.kascend.chushou.b.dAF().d != 1 && Build.VERSION.SDK_INT >= 11 && this.mOP != null) {
            if (!z) {
                if (Build.VERSION.SDK_INT >= 19) {
                    i = 5892;
                } else {
                    i = 1797;
                }
                this.mOP.setSystemUiVisibility(i);
                return;
            }
            this.mOP.setSystemUiVisibility(1792);
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.mOG != null) {
            this.mOG.a(i, i2, intent);
        }
    }

    public Uri dAZ() {
        return this.mOB;
    }

    @Override // com.kascend.chushou.view.base.BaseActivity
    protected int y() {
        return 0;
    }

    public void wd(boolean z) {
        if (this.mOP != null) {
            this.mOP.nYS = z;
        }
    }

    public void dBa() {
        if (this.mOP != null) {
            this.mOP.dBa();
        }
    }

    public boolean dBb() {
        return this.ae;
    }

    public void f(boolean z) {
        this.ae = z;
    }

    public void g(boolean z) {
        if (this.mOP != null) {
            this.mOP.setIsTranslucentStatus(z);
        }
    }

    public void z() {
        if (this.mOP != null) {
            this.mOP.dPB();
        }
    }

    @Override // com.kascend.chushou.widget.gifts.RoomSendGiftView.a
    public void A() {
        if (this.mON != null) {
            this.mON.b();
        }
    }

    @Override // com.kascend.chushou.widget.gifts.RoomSendGiftView.a
    public void B() {
        if (this.mON != null) {
            this.mON.b();
        }
    }

    public void a(List<ListItem> list) {
        if (this.mOG != null) {
            this.mOG.a(list);
        }
    }

    public void a(IconConfig iconConfig, Map<String, SkinConfig.SkinRes> map) {
        if (this.mOG != null) {
            this.mOG.a(iconConfig, map);
        }
    }

    public void C() {
        if (this.mOG != null) {
            this.mOG.I();
        }
    }

    @Override // com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC0698a
    public void a(int i) {
        if (this.mOG != null) {
            this.mOG.a(i);
        }
    }

    @Override // com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC0698a
    public void D() {
        if (!isFinishing() && this.mOG != null) {
            this.mOG.D();
        }
    }

    @Override // com.kascend.chushou.player.ui.h5.b.b.a
    public void a(long j) {
        if (!isFinishing() && this.mOG != null) {
            this.mOG.a(j);
        }
    }

    @Override // com.kascend.chushou.player.ui.h5.b.b.a
    public void a(com.kascend.chushou.player.ui.h5.c.a aVar) {
        if (aVar != null && this.mOG != null) {
            this.mOG.a(aVar);
        }
    }

    @Override // com.kascend.chushou.player.ui.h5.b.b.a
    public void b(int i) {
        if (this.mOG != null) {
            this.mOG.b(i);
        }
    }

    @Override // com.kascend.chushou.player.ui.h5.d.a.InterfaceC0697a
    public void b(long j) {
        if (!isFinishing() && this.mOG != null) {
            this.mOG.b(j);
        }
    }

    @Override // com.kascend.chushou.player.ui.h5.a.a.InterfaceC0695a
    public void c(int i) {
        if (!isFinishing() && this.mOG != null) {
            this.mOG.c(i);
        }
    }

    @Override // com.kascend.chushou.player.ui.h5.d.a.InterfaceC0697a
    public void b(com.kascend.chushou.player.ui.h5.c.a aVar) {
        if (aVar != null && this.mOG != null) {
            this.mOG.b(aVar);
        }
    }

    @Override // com.kascend.chushou.player.ui.a.a.InterfaceC0692a
    public void a(IconConfig.Config config) {
        if (this.mOG != null) {
            this.mOG.a(config);
        }
    }

    @Override // com.kascend.chushou.player.ui.a.a.InterfaceC0692a
    public void a(BangInfo bangInfo, String str) {
        if (this.mOG != null) {
            this.mOG.a(bangInfo, str);
        }
    }

    @Override // com.kascend.chushou.player.ui.a.a.InterfaceC0692a
    public void a(long j, BangInfo bangInfo, String str) {
        if (this.mOG != null) {
            this.mOG.a(j, bangInfo, str);
        }
    }

    public com.kascend.chushou.player.ui.h5.redpacket.a dBc() {
        return this.mOZ;
    }

    public com.kascend.chushou.player.ui.h5.b.b dBd() {
        return this.mPa;
    }

    public com.kascend.chushou.player.ui.h5.d.a dBe() {
        return this.mPb;
    }

    public com.kascend.chushou.player.ui.h5.a.a dBf() {
        return this.mPe;
    }

    public com.kascend.chushou.player.ui.a.a dBg() {
        return this.mPc;
    }

    public com.kascend.chushou.player.e.a dBh() {
        return this.mPd;
    }

    @Override // com.kascend.chushou.view.base.BaseActivity, android.app.Activity
    public void finish() {
        super.finish();
        if ("3".equals(this.R)) {
            overridePendingTransition(17432576, a.C0682a.commonres_activity_exit_bottom);
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
        RxExecutor.postDelayed(this.mPh, EventThread.MAIN_THREAD, aVar.d, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.VideoPlayer.2
            @Override // java.lang.Runnable
            public void run() {
                if (VideoPlayer.this.mOG != null) {
                    VideoPlayer.this.mOG.c(aVar);
                }
            }
        });
    }

    private void e(final com.kascend.chushou.player.ui.h5.c.a aVar) {
        if (!com.kascend.chushou.d.h.dAM().dAP().contains(aVar.b)) {
            if (aVar.d < 0) {
                aVar.d = 0;
            }
            RxExecutor.postDelayed(this.mPh, EventThread.MAIN_THREAD, aVar.d, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.VideoPlayer.3
                @Override // java.lang.Runnable
                public void run() {
                    if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.mOG != null) {
                        VideoPlayer.this.mOG.c(aVar);
                    }
                }
            });
        }
    }

    private String dBi() {
        if ("4".equals(this.aq)) {
            return TbEnum.SystemMessage.EVENT_ID_GROUP_NAME_MODIFY + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP + TbEnum.SystemMessage.EVENT_ID_NOTICE_MODIFY;
        }
        return "2" + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP + "1" + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP + TbEnum.SystemMessage.EVENT_ID_GROUP_NAME_MODIFY + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP + TbEnum.SystemMessage.EVENT_ID_NOTICE_MODIFY;
    }

    /* loaded from: classes4.dex */
    private class a extends BroadcastReceiver {
        private a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("android.media.VOLUME_CHANGED_ACTION".equals(intent.getAction())) {
                if (VideoPlayer.this.mOO != null && !VideoPlayer.this.isFinishing()) {
                    VideoPlayer.n = VideoPlayer.this.mOO.getStreamVolume(3);
                }
                if (!VideoPlayer.this.isFinishing() && (VideoPlayer.this.mOG instanceof f)) {
                    ((f) VideoPlayer.this.mOG).ab();
                }
            }
        }
    }

    public String a(String str) {
        HashMap hashMap = new HashMap(tv.chushou.zues.utils.d.SJ(str));
        if ("1".equals(this.R)) {
            hashMap.put("roomId", this.P);
        } else if ("3".equals(this.R)) {
            hashMap.put("videoId", this.P);
        }
        return tv.chushou.zues.utils.d.toJson(hashMap);
    }

    public boolean dBj() {
        if (this.mOG instanceof com.kascend.chushou.player.d.a) {
            return ((com.kascend.chushou.player.d.a) this.mOG).dCp();
        }
        if (this.mOG instanceof com.kascend.chushou.player.e.e) {
            return true;
        }
        return false;
    }
}

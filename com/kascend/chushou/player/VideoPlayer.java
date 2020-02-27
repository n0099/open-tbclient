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
/* loaded from: classes5.dex */
public class VideoPlayer extends BaseActivity implements a.InterfaceC0700a, a.InterfaceC0703a, b.a, a.InterfaceC0705a, a.InterfaceC0706a, RoomSendGiftView.a {
    private static int A = 60000;
    public static String a = null;
    public static int n = 0;
    private String P;
    private String Q;
    private String R;
    private String S;
    private ImageView Z;
    private String ab;
    private String mPA;
    private FrescoThumbnailView mPB;
    private FrameLayout mPC;
    public com.kascend.chushou.player.feedback.a mPK;
    private a mPM;
    private CSTVWifiReceiver mPN;
    private c mPh;
    b mPk;
    public PrivilegeInfo mPl;
    com.kascend.chushou.widget.a.b mPr;
    private KPSwitchRootRelativeLayout mPt;
    private FrameLayout mPu;
    private LinearLayout mPv;
    private com.kascend.chushou.toolkit.d mPw;
    com.kascend.chushou.view.b.a.a mPx;
    private boolean B = true;
    private boolean C = false;
    private Uri mPd = null;
    private tv.chushou.common.player.a mPe = null;
    public tv.chushou.common.player.a mPf = null;
    public tv.chushou.common.player.a mPg = null;
    public boolean d = false;
    public boolean e = false;
    private e mPi = null;
    private boolean H = false;
    private com.kascend.chushou.view.user.b mPj = null;
    private boolean J = false;
    private boolean K = false;
    private boolean L = false;
    private boolean M = false;
    private long N = 0;
    private int O = 0;
    public boolean g = false;
    private ImageView mPo = null;
    private TextView mPp = null;
    private AnimationImageView mPq = null;
    private View aUA = null;
    public boolean j = false;
    public float k = 0.0f;
    public float l = 0.0f;
    public boolean m = false;
    public AudioManager mPs = null;
    private d.a mPy = new d.a() { // from class: com.kascend.chushou.player.VideoPlayer.1
        @Override // com.kascend.chushou.toolkit.d.a
        public void a() {
            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.mPO != null) {
                VideoPlayer.this.mPO.Of(4);
            }
        }
    };
    private boolean ae = false;
    public boolean q = true;
    public long r = -1;
    public long s = -1;
    private PowerManager.WakeLock mPz = null;
    public String t = null;
    private final com.kascend.chushou.player.ui.h5.redpacket.a mPD = new com.kascend.chushou.player.ui.h5.redpacket.a(this);
    private final com.kascend.chushou.player.ui.h5.b.b mPE = new com.kascend.chushou.player.ui.h5.b.b(this);
    private final com.kascend.chushou.player.ui.h5.d.a mPF = new com.kascend.chushou.player.ui.h5.d.a(this);
    private final com.kascend.chushou.player.ui.a.a mPG = new com.kascend.chushou.player.ui.a.a(this);
    private final com.kascend.chushou.player.e.a mPH = new com.kascend.chushou.player.e.a();
    private final com.kascend.chushou.player.ui.h5.a.a mPI = new com.kascend.chushou.player.ui.h5.a.a(this);
    private String mPJ = "1";
    private String aq = "2";
    private io.reactivex.disposables.a mPL = new io.reactivex.disposables.a();
    private tv.chushou.zues.c mPO = new tv.chushou.zues.c(new Handler.Callback() { // from class: com.kascend.chushou.player.VideoPlayer.6
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            try {
                if (!VideoPlayer.this.isFinishing()) {
                    switch (message.what) {
                        case 1:
                            VideoPlayer.this.mPO.removeMessages(1);
                            com.kascend.chushou.c.c.dBO().a(VideoPlayer.this.P, VideoPlayer.this.mPk != null ? VideoPlayer.this.mPk.h : null, System.currentTimeMillis());
                            VideoPlayer.this.mPO.K(1, VideoPlayer.A);
                            break;
                        case 2:
                            VideoPlayer.this.a(true, (Uri) null, false);
                            break;
                        case 3:
                            VideoPlayer.this.cXs();
                            break;
                        case 4:
                            if (VideoPlayer.this.mPi != null) {
                                VideoPlayer.this.mPi.a(true);
                            }
                            if (VideoPlayer.this.mPw != null) {
                                VideoPlayer.this.mPw.d();
                                VideoPlayer.this.mPw = null;
                                break;
                            }
                            break;
                        case 5:
                            int i = message.arg1;
                            if (i == 1) {
                                if (VideoPlayer.this.mPi != null) {
                                    VideoPlayer.this.mPi.p();
                                    break;
                                }
                            } else if (i == 2 && VideoPlayer.this.mPi != null) {
                                VideoPlayer.this.mPi.e(message.arg2);
                                break;
                            }
                            break;
                        case 6:
                            if (!com.kascend.chushou.b.dBL().a && !com.kascend.chushou.b.dBL().b && VideoPlayer.this.mPi != null) {
                                VideoPlayer.this.mPi.g(true);
                                break;
                            } else {
                                VideoPlayer.this.c();
                                break;
                            }
                            break;
                        case 7:
                            tv.chushou.zues.utils.e.d(VideoPlayer.this.v, "MSG_BUFFER_DEALY: ");
                            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.mPi != null && VideoPlayer.this.M && !VideoPlayer.this.e) {
                                VideoPlayer.this.mPi.h(true);
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
    private boolean mPP = false;
    private boolean mPQ = true;
    private boolean mPR = false;
    private tv.chushou.common.player.b mPS = new tv.chushou.common.player.b() { // from class: com.kascend.chushou.player.VideoPlayer.14
        @Override // tv.chushou.common.player.b
        public void dCr() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerACallback onSetVideoViewLayout");
            if (!VideoPlayer.this.isFinishing()) {
                if ((VideoPlayer.this.mPi == null || !VideoPlayer.this.mPi.H) && VideoPlayer.this.mPi != null && !VideoPlayer.this.d) {
                    VideoPlayer.this.mPi.y();
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void MI(int i) {
            if (!VideoPlayer.this.isFinishing()) {
                if ((VideoPlayer.this.mPi == null || !VideoPlayer.this.mPi.H) && VideoPlayer.this.mPi != null && !VideoPlayer.this.d) {
                    VideoPlayer.this.mPi.g(i);
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void dCs() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerACallback onCompletePlayback");
            if (!VideoPlayer.this.isFinishing()) {
                if (!h.isEmpty(VideoPlayer.this.P)) {
                    j.dBX().a(VideoPlayer.this.P, 0);
                }
                VideoPlayer.this.K = false;
                if (VideoPlayer.this.mPO != null) {
                    VideoPlayer.this.mPO.removeMessages(1);
                }
                if ((VideoPlayer.this.mPi == null || !VideoPlayer.this.mPi.H) && VideoPlayer.this.mPi != null && !VideoPlayer.this.d) {
                    VideoPlayer.this.mPO.removeMessages(7);
                    VideoPlayer.this.M = false;
                    VideoPlayer.this.mPi.z();
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void dCt() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerACallback onVideoRenderingStart");
            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.mPi != null) {
                VideoPlayer.this.mPi.G();
            }
        }

        @Override // tv.chushou.common.player.b
        public void dCu() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerACallback onPreparedPlayback");
            if (!VideoPlayer.this.isFinishing()) {
                if (VideoPlayer.this.mPi == null || !VideoPlayer.this.mPi.H) {
                    VideoPlayer.this.mPO.removeMessages(6);
                    VideoPlayer.this.N = 0L;
                    VideoPlayer.this.O = 0;
                    if (VideoPlayer.this.mPe != null && VideoPlayer.this.mPi != null) {
                        VideoPlayer.this.mPe.setVolume(VideoPlayer.this.mPi.J, VideoPlayer.this.mPi.J);
                    }
                    if (VideoPlayer.this.mPk != null) {
                        VideoPlayer.this.K = false;
                        FullRoomInfo dCC = VideoPlayer.this.ol() ? null : VideoPlayer.this.mPk.dCC();
                        if (VideoPlayer.this.L || dCC != null) {
                            if (VideoPlayer.this.mPk.e) {
                                VideoPlayer.this.mPk.e = false;
                                VideoPlayer.this.mPk.d = !VideoPlayer.this.mPk.d;
                            }
                            if (VideoPlayer.this.mPi != null) {
                                VideoPlayer.this.c("1", (String) null);
                                if (!VideoPlayer.this.d) {
                                    VideoPlayer.this.mPi.i(true);
                                } else if (VideoPlayer.this.e) {
                                    VideoPlayer.this.e = false;
                                    VideoPlayer.this.mPi.B();
                                }
                            }
                        }
                    }
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void MJ(int i) {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerACallback onErrorAppeared");
            if (!VideoPlayer.this.isFinishing()) {
                VideoPlayer.this.c();
                VideoPlayer.this.K = false;
                if (VideoPlayer.this.mPO != null) {
                    VideoPlayer.this.mPO.removeMessages(7);
                }
                if (VideoPlayer.this.mPO != null) {
                    VideoPlayer.this.mPO.removeMessages(1);
                }
                if ((VideoPlayer.this.mPi == null || !VideoPlayer.this.mPi.H) && !VideoPlayer.this.dBZ()) {
                    if (!"10004".equals(VideoPlayer.this.t)) {
                        if (VideoPlayer.this.mPi != null) {
                            if (VideoPlayer.this.d) {
                                VideoPlayer.this.mPf.stop();
                                VideoPlayer.this.mPf.release();
                                VideoPlayer.this.e = false;
                                VideoPlayer.this.mPi.C();
                            }
                            if (!com.kascend.chushou.b.dBL().a && !com.kascend.chushou.b.dBL().b) {
                                VideoPlayer.this.mPi.g(true);
                            } else if (VideoPlayer.this.d) {
                                VideoPlayer.this.mPi.a(i, true);
                            } else {
                                VideoPlayer.this.mPi.a(i, false);
                            }
                            VideoPlayer.this.c("2", (String) null);
                            return;
                        }
                        return;
                    }
                    dCs();
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void dCv() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerACallback onBufferingStart");
            if (!VideoPlayer.this.isFinishing()) {
                if ((VideoPlayer.this.mPi == null || !VideoPlayer.this.mPi.H) && VideoPlayer.this.mPi != null && !VideoPlayer.this.d) {
                    VideoPlayer.this.mPi.E();
                    VideoPlayer.this.M = true;
                    long currentTimeMillis = System.currentTimeMillis();
                    VideoPlayer.this.mPO.removeMessages(7);
                    if (!VideoPlayer.this.g) {
                        VideoPlayer.y(VideoPlayer.this);
                    }
                    tv.chushou.zues.utils.e.d(VideoPlayer.this.v, "currentTime: -- >" + currentTimeMillis + "  bufferTime-->" + VideoPlayer.this.N + "  bufferCount-->" + VideoPlayer.this.O);
                    if (currentTimeMillis - VideoPlayer.this.N >= 20000 || VideoPlayer.this.O < 2 || VideoPlayer.this.mPi.H) {
                        if (VideoPlayer.this.O == 1) {
                            VideoPlayer.this.N = currentTimeMillis;
                        }
                        VideoPlayer.this.mPO.K(7, 5000L);
                    } else {
                        VideoPlayer.this.mPO.Of(7);
                    }
                    if (VideoPlayer.this.g) {
                        VideoPlayer.this.g = false;
                    }
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void dCw() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerACallback onBufferingEnd");
            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.mPi != null && !VideoPlayer.this.d) {
                VideoPlayer.this.mPO.removeMessages(7);
                VideoPlayer.this.M = false;
                if (VideoPlayer.this.mPi == null || !VideoPlayer.this.mPi.H) {
                    if (VideoPlayer.this.mPe == null) {
                        VideoPlayer.this.mPi.a(false, true, false);
                    } else {
                        VideoPlayer.this.mPi.a(true, VideoPlayer.this.mPe.getPlayState() == 4, VideoPlayer.this.mPe.getPlayState() == 5);
                    }
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void dCx() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerACallback onPlayerStart");
            if (!VideoPlayer.this.isFinishing()) {
                if (VideoPlayer.this.mPi == null || !VideoPlayer.this.mPi.H) {
                    if (VideoPlayer.this.mPi != null && !VideoPlayer.this.d) {
                        if (VideoPlayer.this.mPe != null) {
                            VideoPlayer.this.mPi.F();
                            VideoPlayer.this.mPi.a(true, VideoPlayer.this.mPe.getPlayState() == 4, VideoPlayer.this.mPe.getPlayState() == 5);
                        } else {
                            VideoPlayer.this.mPi.a(false, true, false);
                        }
                    }
                    if (VideoPlayer.this.mPO != null && !VideoPlayer.this.ol()) {
                        VideoPlayer.this.mPO.removeMessages(1);
                        VideoPlayer.this.mPO.K(1, VideoPlayer.A);
                    }
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void dCy() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerACallback onPlayerPause");
            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.mPO != null) {
                VideoPlayer.this.mPO.removeMessages(1);
            }
        }

        @Override // tv.chushou.common.player.b
        public void dCz() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerACallback onPlayerStop");
            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.ol() && VideoPlayer.this.mPf != null && !h.isEmpty(VideoPlayer.this.P) && VideoPlayer.this.mPf.getCurrentPos() > 0) {
                j.dBX().a(VideoPlayer.this.P, VideoPlayer.this.mPf.getCurrentPos());
            }
        }
    };
    private tv.chushou.common.player.b mPT = new tv.chushou.common.player.b() { // from class: com.kascend.chushou.player.VideoPlayer.15
        @Override // tv.chushou.common.player.b
        public void dCr() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerBCallback onSetVideoViewLayout");
            if (!VideoPlayer.this.isFinishing()) {
                if ((VideoPlayer.this.mPi == null || !VideoPlayer.this.mPi.H) && VideoPlayer.this.mPi != null && VideoPlayer.this.d) {
                    VideoPlayer.this.mPi.y();
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void MI(int i) {
            if (!VideoPlayer.this.isFinishing()) {
                if ((VideoPlayer.this.mPi == null || !VideoPlayer.this.mPi.H) && VideoPlayer.this.mPi != null && VideoPlayer.this.d) {
                    VideoPlayer.this.mPi.g(i);
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void dCs() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerBCallback onCompletePlayback");
            if (!VideoPlayer.this.isFinishing()) {
                if (!h.isEmpty(VideoPlayer.this.P)) {
                    j.dBX().a(VideoPlayer.this.P, 0);
                }
                VideoPlayer.this.K = false;
                if (VideoPlayer.this.mPO != null) {
                    VideoPlayer.this.mPO.removeMessages(1);
                }
                if ((VideoPlayer.this.mPi == null || !VideoPlayer.this.mPi.H) && VideoPlayer.this.mPi != null && VideoPlayer.this.d) {
                    VideoPlayer.this.mPO.removeMessages(7);
                    VideoPlayer.this.M = false;
                    VideoPlayer.this.mPi.z();
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void dCt() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerBCallback onVideoRenderingStart");
            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.mPi != null) {
                VideoPlayer.this.mPi.G();
            }
        }

        @Override // tv.chushou.common.player.b
        public void dCu() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerBCallback onPreparedPlayback");
            if (!VideoPlayer.this.isFinishing()) {
                if (VideoPlayer.this.mPi == null || !VideoPlayer.this.mPi.H) {
                    VideoPlayer.this.mPO.removeMessages(6);
                    VideoPlayer.this.N = 0L;
                    VideoPlayer.this.O = 0;
                    if (VideoPlayer.this.mPe != null && VideoPlayer.this.mPi != null) {
                        VideoPlayer.this.mPe.setVolume(VideoPlayer.this.mPi.J, VideoPlayer.this.mPi.J);
                    }
                    if (VideoPlayer.this.mPk != null) {
                        VideoPlayer.this.K = false;
                        FullRoomInfo dCC = VideoPlayer.this.ol() ? null : VideoPlayer.this.mPk.dCC();
                        if (VideoPlayer.this.L || dCC != null) {
                            if (VideoPlayer.this.mPk.e) {
                                VideoPlayer.this.mPk.e = false;
                                VideoPlayer.this.mPk.d = !VideoPlayer.this.mPk.d;
                            }
                            if (VideoPlayer.this.mPi != null) {
                                VideoPlayer.this.c("1", (String) null);
                                if (VideoPlayer.this.d) {
                                    VideoPlayer.this.mPi.i(true);
                                } else if (VideoPlayer.this.e) {
                                    VideoPlayer.this.e = false;
                                    VideoPlayer.this.mPi.B();
                                }
                            }
                        }
                    }
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void MJ(int i) {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerBCallback onErrorAppeared");
            if (!VideoPlayer.this.isFinishing()) {
                VideoPlayer.this.c();
                VideoPlayer.this.K = false;
                if (VideoPlayer.this.mPO != null) {
                    VideoPlayer.this.mPO.removeMessages(7);
                }
                if (VideoPlayer.this.mPO != null) {
                    VideoPlayer.this.mPO.removeMessages(1);
                }
                if ((VideoPlayer.this.mPi == null || !VideoPlayer.this.mPi.H) && !VideoPlayer.this.dBZ()) {
                    if (!"10004".equals(VideoPlayer.this.t)) {
                        if (VideoPlayer.this.mPi != null) {
                            if (!VideoPlayer.this.d) {
                                VideoPlayer.this.mPg.stop();
                                VideoPlayer.this.mPg.release();
                                VideoPlayer.this.mPi.C();
                                VideoPlayer.this.e = false;
                            }
                            if (!com.kascend.chushou.b.dBL().a && !com.kascend.chushou.b.dBL().b) {
                                VideoPlayer.this.mPi.g(true);
                            } else if (VideoPlayer.this.d) {
                                VideoPlayer.this.mPi.a(i, false);
                            } else {
                                VideoPlayer.this.mPi.a(i, true);
                            }
                            VideoPlayer.this.c("2", (String) null);
                            return;
                        }
                        return;
                    }
                    dCs();
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void dCv() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerBCallback onBufferingStart");
            if (!VideoPlayer.this.isFinishing()) {
                if ((VideoPlayer.this.mPi == null || !VideoPlayer.this.mPi.H) && VideoPlayer.this.mPi != null && VideoPlayer.this.d) {
                    VideoPlayer.this.mPi.E();
                    VideoPlayer.this.M = true;
                    VideoPlayer.this.mPO.removeMessages(7);
                    long currentTimeMillis = System.currentTimeMillis();
                    if (!VideoPlayer.this.g) {
                        VideoPlayer.y(VideoPlayer.this);
                    }
                    tv.chushou.zues.utils.e.d(VideoPlayer.this.v, "currentTime: -- >" + currentTimeMillis + "  bufferTime-->" + VideoPlayer.this.N + "  bufferCount-->" + VideoPlayer.this.O);
                    if (currentTimeMillis - VideoPlayer.this.N >= 20000 || VideoPlayer.this.O < 2 || VideoPlayer.this.mPi.H) {
                        if (VideoPlayer.this.O == 1) {
                            VideoPlayer.this.N = currentTimeMillis;
                        }
                        VideoPlayer.this.mPO.K(7, 5000L);
                    } else {
                        VideoPlayer.this.N = 0L;
                        VideoPlayer.this.O = 0;
                        VideoPlayer.this.mPO.Of(7);
                    }
                    if (VideoPlayer.this.g) {
                        VideoPlayer.this.g = false;
                    }
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void dCw() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerBCallback onBufferingEnd");
            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.mPi != null && VideoPlayer.this.d) {
                VideoPlayer.this.M = false;
                VideoPlayer.this.mPO.removeMessages(7);
                if (VideoPlayer.this.mPi == null || !VideoPlayer.this.mPi.H) {
                    if (VideoPlayer.this.mPe == null) {
                        VideoPlayer.this.mPi.a(false, true, false);
                    } else {
                        VideoPlayer.this.mPi.a(true, VideoPlayer.this.mPe.getPlayState() == 4, VideoPlayer.this.mPe.getPlayState() == 5);
                    }
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void dCx() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerBCallback onPlayerStart");
            if (!VideoPlayer.this.isFinishing()) {
                if (VideoPlayer.this.mPi == null || !VideoPlayer.this.mPi.H) {
                    if (VideoPlayer.this.mPi != null && VideoPlayer.this.d) {
                        if (VideoPlayer.this.mPe != null) {
                            VideoPlayer.this.mPi.F();
                            VideoPlayer.this.mPi.a(true, VideoPlayer.this.mPe.getPlayState() == 4, VideoPlayer.this.mPe.getPlayState() == 5);
                        } else {
                            VideoPlayer.this.mPi.a(false, true, false);
                        }
                    }
                    if (VideoPlayer.this.mPO != null && !VideoPlayer.this.ol()) {
                        VideoPlayer.this.mPO.removeMessages(1);
                        VideoPlayer.this.mPO.K(1, VideoPlayer.A);
                    }
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void dCy() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerBCallback onPlayerPause");
            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.mPO != null) {
                VideoPlayer.this.mPO.removeMessages(1);
            }
        }

        @Override // tv.chushou.common.player.b
        public void dCz() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerBCallback onPlayerStop");
            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.ol() && VideoPlayer.this.mPg != null && !h.isEmpty(VideoPlayer.this.P) && VideoPlayer.this.mPg.getCurrentPos() > 0) {
                j.dBX().a(VideoPlayer.this.P, VideoPlayer.this.mPg.getCurrentPos());
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
        this.mPd = intent.getData();
        if (this.mPd == null) {
            finish();
            return;
        }
        com.kascend.chushou.d.e.j();
        if (this.mPN == null) {
            this.mPN = new CSTVWifiReceiver();
            registerReceiver(this.mPN, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        }
        com.kascend.chushou.toolkit.d.a.dEl().b();
        tv.chushou.zues.utils.e.i(this.v, "intent.getData=" + this.mPd.toString());
        String scheme = this.mPd.getScheme();
        if (scheme == null || !scheme.equals("chushou")) {
            tv.chushou.zues.utils.e.e(this.v, "not support scheme :" + scheme);
            finish();
            return;
        }
        a(intent);
    }

    private void a(Intent intent) {
        this.P = this.mPd.getQueryParameter("roomId");
        this.Q = this.P;
        this.S = this.mPd.getQueryParameter(WebSocketRequest.PARAM_KEY_PROTOCOLS);
        this.aq = this.mPd.getQueryParameter("liveType");
        if ("2".equals(this.aq) || "3".equals(this.aq) || "4".equals(this.aq)) {
            this.mPJ = "2";
            this.mPK = new com.kascend.chushou.player.feedback.a();
            if (this.mPK.mYl != null) {
                this.mPK.mYl.reset();
                this.mPK.mYl.roomId = this.P;
                this.mPK.mYl.enterType = 1;
                this.mPK.b = System.currentTimeMillis();
            }
        }
        if (h.isEmpty(this.P) || h.isEmpty(this.S)) {
            tv.chushou.zues.utils.e.e(this.v, "invalid param mItemID=" + this.P + " protocols=" + this.S);
            finish();
            return;
        }
        if (com.kascend.chushou.b.dBL().d == -1) {
            com.kascend.chushou.b.dBL().d = com.kascend.chushou.d.g.b() ? 1 : 0;
        }
        this.mPz = ((PowerManager) getSystemService("power")).newWakeLock(536870938, this.v);
        this.mPz.acquire();
        this.mPk = new b(this.P);
        this.mPk.d = intent.getBooleanExtra("room_play_audio", false);
        this.mPr = new com.kascend.chushou.widget.a.b();
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
        this.mPt = (KPSwitchRootRelativeLayout) findViewById(a.f.rlRoot);
        if (!"2".equals(this.mPJ) && com.kascend.chushou.b.dBL().d == 1) {
            this.mPt.setFitsSystemWindows(true);
        }
        this.mPu = (FrameLayout) this.mPt.findViewById(a.f.fl_fragment);
        this.aUA = this.mPt.findViewById(a.f.rl_empty);
        this.mPo = (ImageView) this.aUA.findViewById(a.f.iv_empty);
        this.mPp = (TextView) this.aUA.findViewById(a.f.tv_empty);
        this.mPv = (LinearLayout) this.mPt.findViewById(a.f.rl_title);
        this.Z = (ImageView) this.mPv.findViewById(a.f.back_icon);
        this.Z.setOnClickListener(new View.OnClickListener() { // from class: com.kascend.chushou.player.VideoPlayer.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayer.this.finish();
            }
        });
        this.mPq = (AnimationImageView) this.aUA.findViewById(a.f.iv_loading);
        this.mPB = (FrescoThumbnailView) this.mPt.findViewById(a.f.live_cover);
        this.mPC = (FrameLayout) this.mPt.findViewById(a.f.fl_cover);
        this.k = dBY();
        try {
            this.mPs = (AudioManager) getApplicationContext().getSystemService("audio");
            n = this.mPs.getStreamVolume(3);
            this.mPs.requestAudioFocus(null, 3, 1);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (this.B) {
            a(1, ol() ? "3" : "1");
        } else {
            r();
        }
        if (com.kascend.chushou.b.dBL().b && !com.kascend.chushou.b.dBL().a) {
            RxExecutor.postDelayed(this.mPL, EventThread.MAIN_THREAD, 60L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.VideoPlayer.5
                @Override // java.lang.Runnable
                public void run() {
                    if (!VideoPlayer.this.isFinishing() && com.kascend.chushou.b.dBL().b && !com.kascend.chushou.b.dBL().a) {
                        tv.chushou.zues.utils.g.c(VideoPlayer.this.w, VideoPlayer.this.getString(a.i.str_monet_notify));
                    }
                }
            });
        }
        com.kascend.chushou.c.c.dBO().a(this.P, stringExtra, System.currentTimeMillis());
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
        if (this.mPM == null) {
            this.mPM = new a();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.media.VOLUME_CHANGED_ACTION");
            registerReceiver(this.mPM, intentFilter);
        }
    }

    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        if (this.mPM != null) {
            unregisterReceiver(this.mPM);
            this.mPM = null;
        }
        super.onStop();
    }

    @Subscribe
    public void onHideGiftEffectEvent(com.kascend.chushou.b.a.a.f fVar) {
        if (fVar.b) {
            this.mPi.k();
            return;
        }
        this.mPi.m();
        this.mPi.l();
    }

    private float dBY() {
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
        this.mPA = str;
        R();
        try {
            if (h.isEmpty(str)) {
                jSONObject = new JSONObject();
            } else {
                jSONObject = new JSONObject(str);
            }
            jSONObject.put("_fbroomid", this.P);
            this.mPk.h = jSONObject.toString();
            String optString = jSONObject.optString("_thumb");
            jSONObject.optBoolean("tag_from_game_mic", false);
            if (!h.isEmpty(optString)) {
                this.ab = optString;
            }
        } catch (JSONException e) {
            e.printStackTrace();
            this.mPk.h = str;
        }
        if (ol()) {
            a(this.P, str);
            aO(this.P, z);
            return;
        }
        a = this.P;
        b(this.P, str);
        a(this.P, dCo(), z);
        w();
    }

    private void O() {
        this.m = true;
        j();
        if (this.mPi != null) {
            this.mPi.r();
        }
        s();
    }

    @Subscribe
    public void onStartRoomEvent(o oVar) {
        if (!isFinishing() && oVar.mOL != null && oVar.c != null && !h.isEmpty(oVar.mOL.mTargetKey)) {
            if (oVar.c != this) {
                tv.chushou.zues.utils.e.e(this.v, "different player!");
                return;
            }
            if (this.mPk != null) {
                this.mPk.a();
                this.mPk.a = oVar.mOL.mTargetKey;
                this.mPk.d = oVar.d;
                if (this.mPk.mQM != null) {
                    this.mPk.mQM.e();
                }
                if (this.mPk.mQM != null) {
                    this.mPk.mQM.b();
                }
                this.mPk.mQQ = null;
                this.mPk.mQP = null;
                this.mPk.mQT = null;
                this.mPk.mQS = null;
                this.mPk.mQW = null;
                this.mPk.mQU = null;
                this.mPk.mQV = null;
            }
            if (this.mPs != null) {
                n = this.mPs.getStreamVolume(3);
            }
            if (!h.isEmpty(oVar.mOL.mType) && oVar.mOL.mType.equals("3")) {
                this.B = false;
                this.mPJ = "1";
                r();
                this.P = oVar.mOL.mTargetKey;
                this.R = "3";
                if (this.mPr != null) {
                    this.mPr.a();
                }
                if (this.mPk != null) {
                    this.mPk.a((PlayUrl) null);
                    this.mPk.f();
                    if (this.mPk.c() != null) {
                        this.mPk.c().clear();
                    }
                    this.mPk.i.clear();
                }
                if (this.mPi != null) {
                    this.mPi.j();
                }
                s();
                if (this.mPw != null) {
                    this.mPw.d();
                    this.mPw = null;
                }
                if (this.mPL != null) {
                    this.mPL.dispose();
                    this.mPL = new io.reactivex.disposables.a();
                }
                a(oVar.e, false);
                return;
            }
            boolean z = this.R != null && this.R.equals("1");
            this.R = "1";
            this.mPG.a();
            this.mPF.a();
            this.mPE.a();
            this.mPD.c();
            this.mPI.a();
            if (this.mPL != null) {
                this.mPL.dispose();
                this.mPL = new io.reactivex.disposables.a();
            }
            if ("1".equals(oVar.f)) {
                this.H = false;
                if (this.mPk != null && !h.isEmpty(this.mPk.t)) {
                    this.mPk.t.clear();
                }
                this.ab = oVar.mOL.mCover;
                this.mPC.setVisibility(0);
                this.mPB.setBlur(true);
                this.mPB.i(oVar.mOL.mCover, 0, 0, 0);
            }
            if (!oVar.mOL.mTargetKey.equals(this.P)) {
                this.aq = oVar.g;
                if (!z) {
                    this.B = false;
                    r();
                } else if (!"2".equals(this.mPJ) && ("2".equals(this.aq) || "3".equals(this.aq) || "4".equals(this.aq))) {
                    this.mPJ = "2";
                    this.mPK = new com.kascend.chushou.player.feedback.a();
                    if (this.mPK.mYl != null) {
                        this.mPK.mYl.reset();
                        this.mPK.mYl.roomId = oVar.mOL.mTargetKey;
                        this.mPK.mYl.enterType = 1;
                        this.mPK.b = System.currentTimeMillis();
                    }
                }
                this.B = false;
                this.P = oVar.mOL.mTargetKey;
                this.Q = this.P;
                this.ab = oVar.mOL.mCover;
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
                JSONObject M = com.kascend.chushou.d.e.M("_fromView", str, "_sc", oVar.mOL.mSC);
                com.kascend.chushou.toolkit.a.c.a(this.w, M);
                if (this.mPr != null) {
                    this.mPr.a();
                    this.mPr.a(this.P);
                }
                if (this.mPk != null) {
                    this.mPk.a((PlayUrl) null);
                    this.mPk.f();
                    if (this.mPk.c() != null) {
                        this.mPk.c().clear();
                    }
                    this.mPk.i.clear();
                }
                if (this.mPi != null) {
                    this.mPi.j();
                }
                a(M.toString(), false);
                return;
            }
            tv.chushou.zues.utils.g.Om(a.i.str_same_room);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dBZ() {
        FullRoomInfo dCC;
        String str;
        RoomInfo roomInfo;
        if (ol()) {
            str = null;
            dCC = null;
        } else {
            dCC = this.mPk.dCC();
            str = (dCC == null || (roomInfo = dCC.mRoominfo) == null) ? null : roomInfo.mGameId;
        }
        return !this.L && (dCC == null || h.isEmpty(str));
    }

    @Subscribe
    public void onMessageEvent(i iVar) {
        if (!isFinishing() && iVar.a != 21 && iVar.a != 22) {
            if (iVar.a == 0 && (iVar.b instanceof Boolean)) {
                if (((Boolean) iVar.b).booleanValue() && !isFinishing()) {
                    w();
                    if (this.mPi != null) {
                        this.mPi.f();
                    }
                }
            } else if (iVar.a == 46) {
                if ((iVar.b instanceof String) && this.mPi != null) {
                    this.mPi.c((String) iVar.b);
                }
            } else if (iVar.a == 54) {
                if (iVar.b instanceof String) {
                    this.mPE.a((String) iVar.b);
                }
            } else if (iVar.a == 55) {
                if (this.mPi != null) {
                    this.mPi.O();
                }
            } else if (iVar.a == 56 && this.mPi != null) {
                this.mPi.P();
            }
        }
    }

    @Subscribe
    public void onRefreshSubscribeEvent(m mVar) {
        if (isFinishing() && this.mPk != null && this.mPk.dCE() != null) {
            RoomInfo dCE = this.mPk.dCE();
            if (mVar.a(dCE.mCreatorUID, dCE.mRoomID)) {
                dCE.mIsSubscribed = mVar.c;
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
        if (this.m || this.mPf == null || this.mPg == null) {
            R();
        }
        if (this.mPr != null) {
            this.mPr.d();
        }
        if (!ol()) {
            if (this.mPw != null && !this.mPw.c()) {
                this.mPw.a();
            }
            v();
            if (this.mPk != null && this.mPk.dCC() != null && this.mPk.dCC().cycleLiveRoomInfo != null && !h.isEmpty(this.mPk.dCC().cycleLiveRoomInfo.roomId)) {
                u();
            }
        }
        super.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.view.base.BaseActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        tv.chushou.zues.utils.e.e(this.v, MissionEvent.MESSAGE_DESTROY);
        if (this.mPk != null && this.mPk.dCC() != null && this.mPk.dCC().cycleLiveRoomInfo != null && !h.isEmpty(this.mPk.dCC().cycleLiveRoomInfo.eventName)) {
            j.dBX().a(this.P + dCo());
        }
        if ("2".equals(this.mPJ) && this.mPK != null && this.mPK.mYl != null) {
            this.mPK.mYl.time = System.currentTimeMillis() - this.mPK.b;
            this.mPK.a();
            this.mPK.b();
        }
        this.mPD.d();
        this.mPE.b();
        this.mPF.b();
        O();
        this.mPA = null;
        a = null;
        if (this.mPO != null) {
            this.mPO.cq(null);
            this.mPO = null;
        }
        if (this.mPw != null) {
            this.mPw.d();
            this.mPw = null;
        }
        if (this.mPr != null) {
            this.mPr.c();
            this.mPr = null;
        }
        if (this.mPk != null) {
            this.mPk.mQQ = null;
            this.mPk.mQP = null;
        }
        if (this.mPk != null) {
            this.mPk.b();
            this.mPk = null;
        }
        this.mPd = null;
        this.mPi = null;
        this.mPj = null;
        this.mPl = null;
        this.mPo = null;
        this.mPp = null;
        this.mPq = null;
        this.aUA = null;
        this.mPs = null;
        this.mPt = null;
        this.mPu = null;
        this.Z = null;
        this.mPv = null;
        if (this.mPz != null && this.mPz.isHeld()) {
            this.mPz.release();
            this.mPz = null;
        }
        if (this.mPN != null) {
            unregisterReceiver(this.mPN);
            this.mPN = null;
        }
        h.dQt();
        tv.chushou.zues.a.a.cr(this);
        this.mPL.dispose();
        this.mPF.b();
        this.mPG.b();
        this.mPD.d();
        this.mPE.b();
        this.mPI.b();
        super.onDestroy();
        System.gc();
    }

    @Subscribe
    public void onSendGameGiftEvent(n nVar) {
        if (!isFinishing() && this.mPi != null) {
            this.mPi.a(nVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.view.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        tv.chushou.zues.utils.e.d(this.v, MissionEvent.MESSAGE_PAUSE);
        if (this.mPw != null) {
            this.mPw.b();
        }
        if (this.mPr != null) {
            this.mPr.b(false);
        }
        k();
        this.m = true;
        super.onPause();
    }

    @Override // android.app.Activity
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.mPi != null ? this.mPi.a(motionEvent) : super.onTouchEvent(motionEvent);
    }

    public void c() {
        if ("1".equals(this.R)) {
            j.dBX().a(this.P + dCo());
        } else {
            j.dBX().b(this.P);
        }
    }

    private void a(boolean z, boolean z2) {
        int i = 0;
        tv.chushou.zues.utils.e.i(this.v, "startLoadingVideo <------------- mbPrepareingVideo = " + this.K);
        if (this.mPf != null) {
            this.mPf.setHardwearDecod(com.kascend.chushou.d.h.dBS().a);
        }
        if (this.mPg != null) {
            this.mPg.setHardwearDecod(com.kascend.chushou.d.h.dBS().a);
        }
        if (this.mPe != null) {
            this.mPe.setHardwearDecod(com.kascend.chushou.d.h.dBS().a);
        }
        if (!this.K) {
            if (z && this.mPi != null) {
                if (!z2) {
                    this.t = null;
                    this.mPi.e();
                }
            } else if (this.mPi != null && !z2) {
                this.t = null;
                this.mPi.H = false;
                RxExecutor.post(null, EventThread.MAIN_THREAD, new Runnable() { // from class: com.kascend.chushou.player.VideoPlayer.7
                    @Override // java.lang.Runnable
                    public void run() {
                        VideoPlayer.this.mPi.x();
                    }
                });
            }
            this.K = true;
            if (this.mPk != null && this.mPk.dCD() != null) {
                PlayUrl dCD = this.mPk.dCD();
                while (true) {
                    int i2 = i;
                    if (i2 >= dCD.mUrlDetails.size()) {
                        break;
                    }
                    UrlDetails urlDetails = dCD.mUrlDetails.get(i2);
                    if (urlDetails.mUrl.equals(dCD.mSelectedUrl)) {
                        String str = dCD.mUrlDetails.get(i2).mDefinitionType;
                        String str2 = urlDetails.mBitrate;
                    }
                    i = i2 + 1;
                }
            }
            if (z2) {
                if (this.d) {
                    this.mPf.setVideoURI(this.mPd);
                    this.mPf.open();
                    return;
                }
                this.mPg.setVideoURI(this.mPd);
                this.mPg.open();
                return;
            }
            this.mPe.setVideoURI(this.mPd);
            this.mPe.open();
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        try {
            if (motionEvent.getAction() == 0) {
                if (this.mPi != null && this.mPi.b(motionEvent)) {
                    return true;
                }
                if ("2".equals(this.mPJ) && this.mPi != null) {
                    this.mPi.a(motionEvent);
                }
            } else if (this.mPi != null && this.mPi.b(motionEvent)) {
                return true;
            }
            return super.dispatchTouchEvent(motionEvent);
        } catch (Exception e) {
            return false;
        }
    }

    @Override // android.support.v7.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.mPi != null && this.mPi.a(i, keyEvent)) {
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
        if (this.mPk != null && this.mPk.dCC() != null && this.mPk.dCC().cycleLiveRoomInfo != null && !h.isEmpty(this.mPk.dCC().cycleLiveRoomInfo.roomId)) {
            this.mPC.setVisibility(0);
            this.mPB.setBlur(true);
            this.mPB.i(this.mPk.dCC().cycleLiveRoomInfo.avatar, 0, 0, 0);
            this.mPB.setVisibility(0);
            j.dBX().a(this.P + dCo());
            this.mPd = null;
            R();
            this.Q = this.mPk.dCC().cycleLiveRoomInfo.roomId;
            a(this.P, dCo(), false);
        }
    }

    public void a(boolean z) {
        if (this.mPi != null) {
            this.mPi.j(z);
        }
    }

    public void a(boolean z, Uri uri, boolean z2) {
        tv.chushou.zues.utils.e.d(this.v, "loadIfNecessary reload=" + z + " isChangeLines-->" + z2);
        if (this.mPf != null && this.mPg != null) {
            if (uri != null) {
                this.mPd = uri;
            }
            if (z2) {
                this.e = z2;
            }
            this.M = false;
            this.N = 0L;
            this.O = 0;
            this.mPO.removeMessages(7);
            if (z) {
                if (z2) {
                    if (!this.d) {
                        this.mPg.setOnActivityCallBack(this.mPT);
                    } else {
                        this.mPf.setOnActivityCallBack(this.mPS);
                    }
                } else if (this.d) {
                    this.mPg.setOnActivityCallBack(this.mPT);
                } else {
                    this.mPf.setOnActivityCallBack(this.mPS);
                }
                this.K = false;
                b(true, z2);
            } else if (!this.J) {
                b(true, z2);
            }
            this.mPO.K(6, 3000L);
        }
    }

    private void b(boolean z, boolean z2) {
        VideoPlayInfo O;
        if ("1".equals(this.R)) {
            O = j.dBX().N(this.P + dCo(), KeepJobService.JOB_CHECK_PERIODIC);
        } else {
            O = j.dBX().O(this.P, KeepJobService.JOB_CHECK_PERIODIC);
        }
        if (O != null) {
            a(z, z2);
        } else if ("1".equals(this.R)) {
            a(this.P, dCo(), false);
        } else {
            aO(this.P, false);
        }
    }

    public tv.chushou.common.player.a dCa() {
        return this.mPe;
    }

    public tv.chushou.common.player.a dCb() {
        return this.mPf;
    }

    public tv.chushou.common.player.a dCc() {
        return this.mPg;
    }

    public void a(tv.chushou.common.player.a aVar) {
        this.mPe = aVar;
    }

    public b dCd() {
        return this.mPk;
    }

    public com.kascend.chushou.widget.a.b dCe() {
        return this.mPr;
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
        FullRoomInfo dCC;
        this.r = -1L;
        if (this.s != -1 && this.s != 0) {
            this.r = this.s;
            this.s = -1L;
        }
        if (ol() && this.mPe != null && this.mPe.getPlayState() == 4) {
            this.r = this.mPe.getCurrentPos();
        }
        this.mPP = false;
        tv.chushou.zues.utils.e.d(this.v, "screenChange()<-----");
        tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard(this);
        if (str != null) {
            this.R = str;
        }
        if (!this.C || !z3 || "3".equals(this.R) || this.mPk == null || (dCC = this.mPk.dCC()) == null || dCC.mRoominfo == null || dCC.mRoominfo.mStyle != 1) {
            z5 = false;
        } else {
            z5 = true;
            i = 0;
        }
        if ("2".equals(this.mPJ)) {
            setRequestedOrientation(1);
            ((VideoPlayer) this.w).f(true);
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
            ((VideoPlayer) this.w).f(true);
            if (com.kascend.chushou.b.dBL().d == 1) {
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
            ((VideoPlayer) this.w).wh(false);
            ((VideoPlayer) this.w).f(true);
            if (z5) {
                setRequestedOrientation(1);
            } else {
                setRequestedOrientation(6);
            }
            getWindow().addFlags(512);
            getWindow().addFlags(256);
        }
        if (this.mPr == null) {
            this.mPr = new com.kascend.chushou.widget.a.b();
        }
        if (this.mPr != null) {
            this.mPr.a(this.P);
        }
        if (this.R.equals("5")) {
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            if (this.mPi != null) {
                beginTransaction.remove(this.mPi);
                this.mPi = null;
            }
            if (this.mPj != null) {
                beginTransaction.remove(this.mPj);
                this.mPj = null;
            }
            this.mPj = new com.kascend.chushou.view.user.b();
            beginTransaction.add(a.f.fl_fragment, this.mPj);
            beginTransaction.commitAllowingStateLoss();
        } else {
            FragmentTransaction beginTransaction2 = getSupportFragmentManager().beginTransaction();
            if (this.mPi != null) {
                beginTransaction2.remove(this.mPi);
                this.mPi = null;
            }
            if (this.mPj != null) {
                beginTransaction2.remove(this.mPj);
                this.mPj = null;
            }
            if ("2".equals(this.mPJ)) {
                this.mPi = com.kascend.chushou.player.e.e.a(this.ab, z2, this.aq, this.P);
            } else if (1 == i) {
                if (!this.R.equals("3")) {
                    if (z4) {
                        v();
                    }
                    this.mPi = new com.kascend.chushou.player.d.a();
                    Bundle bundle = new Bundle();
                    bundle.putString("mCover", this.ab);
                    bundle.putBoolean("mInitViewAsync", z2);
                    this.mPi.setArguments(bundle);
                }
            } else {
                this.mPi = new com.kascend.chushou.player.d.b();
                Bundle bundle2 = new Bundle();
                if (z5) {
                    i = 1;
                }
                bundle2.putInt("mExtraOrientation", i);
                bundle2.putString("mViewType", this.R);
                this.mPi.setArguments(bundle2);
            }
            beginTransaction2.add(a.f.fl_fragment, this.mPi);
            beginTransaction2.commitAllowingStateLoss();
            this.H = true;
        }
        tv.chushou.zues.utils.e.d(this.v, "screenChange()----->");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ol() {
        return this.R != null && this.R.equals("3");
    }

    private void R() {
        if (this.mPi != null) {
            this.mPi.mUs = null;
        }
        if (this.mPe != null) {
            this.mPe.release();
            this.mPe = null;
            this.K = false;
        }
        if (this.mPf != null) {
            this.mPf.release();
            this.mPf = null;
        }
        if (this.mPg != null) {
            this.mPg.release();
            this.mPg = null;
        }
        if (this.mPh != null) {
            this.mPh.c();
        }
        this.d = false;
        this.e = false;
        this.M = false;
        this.mPh = new c();
        this.mPf = this.mPh.dCG();
        this.mPf.setOnActivityCallBack(this.mPS);
        this.mPg = this.mPh.dCH();
        this.mPg.setOnActivityCallBack(this.mPT);
        if (!this.d) {
            this.mPe = this.mPf;
        } else {
            this.mPe = this.mPg;
        }
        if (this.mPi != null) {
            this.mPi.mUs = this.mPe;
        }
    }

    public void j() {
        if (this.mPe != null) {
            this.mPe.pause();
            this.mPe.stop();
            this.mPe.release();
            this.mPe = null;
        }
        if (this.mPf != null) {
            this.mPf.stop();
            this.mPf.release();
            this.mPf = null;
        }
        if (this.mPg != null) {
            this.mPg.stop();
            this.mPg.release();
            this.mPg = null;
        }
        if (this.mPh != null) {
            this.mPh.c();
        }
    }

    public void k() {
        tv.chushou.common.player.a aVar = this.mPe;
        if (aVar != null) {
            aVar.pause();
            aVar.stop();
        }
        tv.chushou.common.player.a aVar2 = this.mPf;
        if (aVar2 != null) {
            aVar2.stop();
        }
        tv.chushou.common.player.a aVar3 = this.mPg;
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
    public void cXs() {
        if (this.mPP) {
            if (this.mPi != null) {
                this.mPi.s();
            }
        } else if (this.mPO != null) {
            this.mPO.a(this.mPO.Oh(3), 20L);
        }
    }

    private void b(final String str, String str2) {
        com.kascend.chushou.c.c.dBO().a(new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.VideoPlayer.8
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
                        VideoPlayer.this.bM(s.mMessage, s.mRc);
                        return;
                    }
                    FullRoomInfo fullRoomInfo = (FullRoomInfo) s.mData;
                    VideoPlayer.this.dCm().a(fullRoomInfo.mBangMap);
                    if (h.isEmpty(fullRoomInfo.mRoominfo.mRoomID)) {
                        fullRoomInfo.mRoominfo.mRoomID = VideoPlayer.this.P;
                    }
                    if (!h.isEmpty(fullRoomInfo.mGeneralTabGifts)) {
                        com.kascend.chushou.d.e.a(VideoPlayer.this.mPL, new ArrayList(fullRoomInfo.mGeneralTabGifts));
                    }
                    if (VideoPlayer.this.mPk != null) {
                        VideoPlayer.this.mPk.a(fullRoomInfo);
                    }
                    VideoPlayer.this.L = false;
                    if (VideoPlayer.this.B) {
                        if (VideoPlayer.this.C && !"3".equals(VideoPlayer.this.R) && fullRoomInfo != null && fullRoomInfo.mRoominfo != null && fullRoomInfo.mRoominfo.mStyle == 1 && !h.isEmpty(fullRoomInfo.mRoominfo.mGameId)) {
                            z = true;
                        }
                        if (!z) {
                            if (VideoPlayer.this.mPi != null) {
                                VideoPlayer.this.mPi.a(VideoPlayer.this.mPk);
                            }
                            if (!h.isEmpty(fullRoomInfo.mRoominfo.mGameId)) {
                                VideoPlayer.this.cXs();
                            } else {
                                if (VideoPlayer.this.mPk != null) {
                                    VideoPlayer.this.mPk.f = null;
                                }
                                VideoPlayer.this.cXs();
                            }
                        } else {
                            VideoPlayer.this.a(1, "1", true);
                            if (VideoPlayer.this.mPi != null) {
                                VideoPlayer.this.mPi.a(VideoPlayer.this.mPk);
                            }
                        }
                    } else {
                        if (h.isEmpty(fullRoomInfo.mRoominfo.mGameId)) {
                            if (VideoPlayer.this.mPk != null) {
                                VideoPlayer.this.mPk.f = null;
                            }
                            VideoPlayer.this.a(1, "1");
                        } else {
                            VideoPlayer.this.a(1, "1", true);
                        }
                        if (VideoPlayer.this.mPi != null) {
                            VideoPlayer.this.mPi.a(VideoPlayer.this.mPk);
                        }
                    }
                    if (VideoPlayer.this.mPk != null && !VideoPlayer.this.mPk.m()) {
                        if (VideoPlayer.this.mPw != null) {
                            VideoPlayer.this.mPw.d();
                            VideoPlayer.this.mPw = null;
                        }
                        VideoPlayer.this.mPw = new com.kascend.chushou.toolkit.d(900000L, VideoPlayer.this.mPy, VideoPlayer.this.mPO);
                        VideoPlayer.this.mPw.a();
                    }
                }
            }

            @Override // com.kascend.chushou.c.b
            public void a(int i, String str3) {
                if (!VideoPlayer.this.isFinishing()) {
                    VideoPlayer.this.bM(str3, i);
                }
            }
        }, str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bM(String str, int i) {
        if (this.mPk != null) {
            this.mPk.a((FullRoomInfo) null);
        }
        this.L = false;
        bN(str, i);
        if (this.mPe != null) {
            this.mPe.stop();
        }
        if (this.mPf != null) {
            this.mPf.stop();
        }
        if (this.mPg != null) {
            this.mPg.stop();
        }
    }

    public void l() {
        tv.chushou.zues.utils.e.d(this.v, "retryGetPlayList");
        c();
        if (ol()) {
            aO(this.P, false);
        } else {
            a(this.P, dCo(), false);
        }
    }

    public void m() {
        a(this.mPA, false);
    }

    private void a(final String str, String str2, boolean z) {
        this.J = true;
        VideoPlayInfo N = j.dBX().N(str + str2, KeepJobService.JOB_CHECK_PERIODIC);
        if (N != null) {
            a((ArrayList) N.mPlayUrls);
            this.J = false;
        } else if (z) {
            ParserRet fu = com.kascend.chushou.player.c.a.dCI().fu(str, str2);
            if (fu.mRc != 0) {
                tv.chushou.zues.utils.e.e(this.v, "getPlayUrlSync fail, try to getPlaylist");
                a(str, str2, false);
                return;
            }
            a(fu, str);
        } else {
            com.kascend.chushou.player.c.a.dCI().a(str, str2, new a.InterfaceC0695a() { // from class: com.kascend.chushou.player.VideoPlayer.9
                @Override // com.kascend.chushou.player.c.a.InterfaceC0695a
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
        VideoPlayInfo O = j.dBX().O(str, KeepJobService.JOB_CHECK_PERIODIC);
        if (O != null) {
            a((ArrayList) O.mPlayUrls);
            this.J = false;
            return;
        }
        if (!h.isEmpty(this.mPA)) {
            try {
                equals = "1".equals(new JSONObject(this.mPA).optString("auto"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (!z) {
                ParserRet aP = com.kascend.chushou.player.c.a.dCI().aP(str, equals);
                if (aP.mRc != 0) {
                    tv.chushou.zues.utils.e.e(this.v, "getVideoPlayUrlSync fail, try to getVideoPlaylist");
                    aO(str, false);
                    return;
                }
                a(aP, str);
                return;
            }
            com.kascend.chushou.player.c.a.dCI().a(str, new a.InterfaceC0695a() { // from class: com.kascend.chushou.player.VideoPlayer.10
                @Override // com.kascend.chushou.player.c.a.InterfaceC0695a
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
                if (this.mPk.f == null) {
                    this.mPk.f = new ArrayList<>();
                }
                this.mPk.f.clear();
                this.mPk.f.addAll(arrayList);
                if ("1".equals(this.R)) {
                    j.dBX().a(str + dCo(), arrayList);
                } else {
                    j.dBX().s(str, arrayList);
                }
                a(arrayList);
                return;
            }
            if (this.mPk != null) {
                this.mPk.f = null;
            }
            if (this.mPO != null) {
                Message Oh = this.mPO.Oh(5);
                Oh.arg1 = 2;
                Oh.arg2 = parserRet.mRc;
                this.mPO.O(Oh);
            }
        }
    }

    private void bN(String str, int i) {
        s();
        if (this.mPr != null) {
            this.mPr.a();
        }
        if (h.isEmpty(str)) {
            str = getString(a.i.str_load_data_failed);
        }
        a(str, i);
    }

    public void n() {
        if (this.mPu != null && this.aUA != null && this.mPv != null) {
            this.mPu.setVisibility(0);
            this.aUA.setVisibility(8);
            this.mPv.setVisibility(8);
        }
    }

    public void o() {
        if (this.mPB != null && this.mPB.getVisibility() == 0) {
            this.mPB.xo(0);
            this.mPB.setVisibility(8);
        }
    }

    public void p() {
        if (this.mPC != null && this.mPC.getVisibility() == 0) {
            this.mPC.setVisibility(8);
        }
    }

    public void q() {
        this.mPP = true;
    }

    protected void r() {
        this.mPu.setVisibility(8);
        this.mPv.setVisibility(0);
        this.aUA.setVisibility(0);
        if (this.mPq != null) {
            this.mPo.setVisibility(8);
            this.mPq.setVisibility(0);
            this.mPp.setText(getString(a.i.str_dialog_loading_content));
            this.mPp.setVisibility(8);
        }
    }

    protected void a(String str, int i) {
        this.mPu.setVisibility(8);
        this.mPv.setVisibility(0);
        this.aUA.setVisibility(0);
        if (this.mPq != null) {
            if (str == null) {
                str = getString(a.i.str_nodata);
            }
            if (str != null) {
                this.mPp.setText(str);
                if (str.equals(getString(a.i.s_no_available_network))) {
                    this.mPo.setImageResource(a.e.commonres_pagestatus_net_error);
                } else if (str.equals(getString(a.i.str_nodata)) || str.equals(getString(a.i.str_nohistory)) || str.equals(getString(a.i.str_nolive)) || str.equals(getString(a.i.str_nosubscribe))) {
                    this.mPo.setClickable(true);
                    this.mPo.setImageResource(a.e.commonres_pagestatus_empty);
                } else if (str.equals(getString(a.i.str_inbox_login_notify)) || str.equals(getString(a.i.push_login)) || str.equals(getString(a.i.str_login_timeout))) {
                    this.mPo.setImageResource(a.e.commonres_pagestatus_need_login);
                    this.mPo.setClickable(true);
                } else {
                    this.mPo.setImageResource(a.e.commonres_pagestatus_unknown_error);
                    this.mPo.setClickable(true);
                }
            }
            if (i == 4001) {
                this.mPo.setImageResource(a.e.commonres_pagestatus_net_error);
                this.mPo.setClickable(false);
                this.mPp.setVisibility(0);
                this.mPp.setText(getString(a.i.str_dissubscribe_btn));
                this.mPp.setOnClickListener(new View.OnClickListener() { // from class: com.kascend.chushou.player.VideoPlayer.11
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (!VideoPlayer.this.j) {
                            com.kascend.chushou.c.c.dBO().b(new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.VideoPlayer.11.1
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
                            }, VideoPlayer.this.P, (String) null, VideoPlayer.this.mPk.h);
                        }
                    }
                });
            } else if (i == 404) {
                this.mPp.setText(str);
                this.mPp.setVisibility(0);
                this.mPo.setClickable(false);
                this.mPo.setImageResource(a.e.commonres_pagestatus_empty);
            } else if (i == 4002) {
                if (h.isEmpty(str)) {
                    this.mPp.setVisibility(8);
                } else {
                    this.mPp.setVisibility(0);
                    this.mPp.setText(str);
                }
            } else {
                this.mPp.setVisibility(8);
            }
            this.mPo.setVisibility(0);
            this.mPq.setVisibility(8);
            this.mPC.setVisibility(8);
        }
    }

    public void s() {
        if (this.mPO != null) {
            this.mPO.removeMessages(1);
        }
    }

    private void a(ArrayList<PlayUrl> arrayList) {
        boolean z;
        if (this.mPk.f == null) {
            this.mPk.f = new ArrayList<>();
        }
        this.mPk.f.clear();
        this.mPk.f.addAll(arrayList);
        if (com.kascend.chushou.d.e.b() && !"4".equals(this.aq)) {
            int c = com.kascend.chushou.d.e.c();
            if (c == -1) {
                b(arrayList);
                return;
            } else if (this.mPQ) {
                this.mPQ = false;
                if (c == 0) {
                    this.mPk.d = false;
                    f(arrayList, true);
                    return;
                }
                if (this.mPk != null && this.mPk.f != null) {
                    Iterator<PlayUrl> it = this.mPk.f.iterator();
                    while (it.hasNext()) {
                        if ("2".equals(it.next().mType)) {
                            z = true;
                            break;
                        }
                    }
                }
                z = false;
                this.mPk.d = z;
                f(arrayList, true);
                return;
            } else {
                if (this.mPk.e) {
                    this.mPk.d = !this.mPk.d;
                    this.mPk.e = false;
                    this.mPR = true;
                } else if ("4".equals(this.aq)) {
                    this.mPk.d = true;
                }
                f(arrayList, true);
                return;
            }
        }
        if (this.mPk.e) {
            this.mPk.d = !this.mPk.d;
            this.mPk.e = false;
            this.mPR = true;
        } else if ("4".equals(this.aq)) {
            this.mPk.d = true;
        }
        f(arrayList, true);
    }

    private void b(ArrayList<PlayUrl> arrayList) {
        if ("1".equals(this.R)) {
            if ("2".equals(this.mPJ)) {
                d(false, arrayList);
            } else if (this.mPi != null) {
                this.mPi.f(arrayList, false);
            }
        } else if (this.mPi != null) {
            this.mPi.f(arrayList, false);
        }
    }

    public void b(boolean z) {
        this.mPk.d = false;
        com.kascend.chushou.d.e.a(0);
        ArrayList<PlayUrl> arrayList = this.mPk.f;
        if (!h.isEmpty(arrayList)) {
            if (z) {
                f(arrayList, false);
                if (this.mPO != null) {
                    this.mPO.Of(2);
                    return;
                }
                return;
            }
            f(arrayList, true);
        }
    }

    public void c(boolean z) {
        this.mPk.d = true;
        com.kascend.chushou.d.e.a(1);
        ArrayList<PlayUrl> arrayList = this.mPk.f;
        if (!h.isEmpty(arrayList)) {
            if (z) {
                f(arrayList, false);
                if (this.mPO != null) {
                    this.mPO.Of(2);
                    return;
                }
                return;
            }
            f(arrayList, true);
        }
    }

    @Subscribe
    public void onNotifyEvent(com.kascend.chushou.b.a.a.j jVar) {
        if (!isFinishing() && jVar.a == 1 && !"5".equals(this.R) && !dBZ()) {
            tv.chushou.zues.utils.e.d(this.v, "onNetworkChangeEvent 3G=" + com.kascend.chushou.b.dBL().b + "  wifi=" + com.kascend.chushou.b.dBL().a);
            if (com.kascend.chushou.d.e.b() && !"4".equals(this.aq)) {
                if (com.kascend.chushou.d.e.c() == -1) {
                    if (this.mPi != null) {
                        this.mPi.e(false);
                    }
                    if ("1".equals(this.R)) {
                        if ("2".equals(this.mPJ)) {
                            d(true, null);
                            return;
                        } else if (this.mPi != null) {
                            this.mPi.f(this.mPk.f, true);
                            return;
                        } else {
                            return;
                        }
                    } else if (this.mPi != null) {
                        this.mPi.f(this.mPk.f, true);
                        return;
                    } else {
                        return;
                    }
                }
                RxExecutor.postDelayed(this.mPL, EventThread.MAIN_THREAD, 10L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.VideoPlayer.12
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!VideoPlayer.this.isFinishing() && com.kascend.chushou.b.dBL().b && !com.kascend.chushou.b.dBL().a) {
                            tv.chushou.zues.utils.g.c(VideoPlayer.this.w, VideoPlayer.this.getString(a.i.str_monet_notify));
                        }
                    }
                });
            } else if (com.kascend.chushou.b.dBL().a || com.kascend.chushou.b.dBL().b) {
                t();
                if (this.mPO != null) {
                    this.mPO.Of(2);
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
            if (this.mPk.d) {
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
            String d = com.kascend.chushou.d.h.dBS().d();
            String str3 = h.isEmpty(d) ? "2" : d;
            if (this.mPk.d) {
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
                if (this.mPk != null) {
                    this.mPk.a(playUrl2);
                    if (this.mPO != null) {
                        Message Oh = this.mPO.Oh(5);
                        Oh.arg1 = 1;
                        this.mPO.O(Oh);
                    }
                }
                String b = com.kascend.chushou.player.c.a.b(playUrl2);
                if (!h.isEmpty(b)) {
                    this.mPd = Uri.parse(b);
                    if (this.mPR) {
                        this.mPR = false;
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (z && this.mPe != null) {
                        a(false, z2);
                    }
                }
            }
        }
    }

    public void d(final boolean z, ArrayList<PlayUrl> arrayList) {
        if (this.mPx == null || this.mPx.a <= 0) {
            this.mPx = com.kascend.chushou.view.b.a.a.dEm();
            this.mPx.a(new a.InterfaceC0714a() { // from class: com.kascend.chushou.player.VideoPlayer.13
                @Override // com.kascend.chushou.view.b.a.a.InterfaceC0714a
                public void a(int i) {
                    if (i == a.f.tv_play_video) {
                        VideoPlayer.this.mPx.dismissAllowingStateLoss();
                        VideoPlayer.this.b(z);
                    } else if (i == a.f.tv_play_audio) {
                        VideoPlayer.this.mPx.dismissAllowingStateLoss();
                        VideoPlayer.this.c(z);
                    } else if (i == a.f.iv_close) {
                        VideoPlayer.this.finish();
                    } else {
                        if (i == a.f.tv_union_proxy) {
                        }
                    }
                }
            });
            this.mPx.show(getSupportFragmentManager(), "showRoom");
        }
    }

    public void t() {
        if (this.mPx != null) {
            this.mPx.dismissAllowingStateLoss();
        }
        if (this.mPi != null) {
            this.mPi.v();
        }
    }

    public void u() {
        com.kascend.chushou.c.c.dBO().c(this.P, new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.VideoPlayer.16
            @Override // com.kascend.chushou.c.b
            public void a() {
            }

            @Override // com.kascend.chushou.c.b
            public void a(String str, JSONObject jSONObject) {
                if (!VideoPlayer.this.isFinishing()) {
                    ParserRet dA = com.kascend.chushou.c.e.dA(jSONObject);
                    if (dA.mRc == 0 && dA.mData != null) {
                        CycleLiveRoomInfo cycleLiveRoomInfo = (CycleLiveRoomInfo) dA.mData;
                        if (VideoPlayer.this.mPk != null && cycleLiveRoomInfo != null && !h.isEmpty(cycleLiveRoomInfo.roomId)) {
                            FullRoomInfo dCC = VideoPlayer.this.mPk.dCC();
                            if (dCC.cycleLiveRoomInfo == null) {
                                dCC.cycleLiveRoomInfo = cycleLiveRoomInfo;
                                VideoPlayer.this.d();
                            } else if (dCC.cycleLiveRoomInfo != null && !cycleLiveRoomInfo.roomId.equals(dCC.cycleLiveRoomInfo.roomId)) {
                                dCC.cycleLiveRoomInfo.copyCycleLiveRoomInfo(cycleLiveRoomInfo);
                                VideoPlayer.this.d();
                            } else {
                                dCC.cycleLiveRoomInfo.copyCycleLiveRoomInfo(cycleLiveRoomInfo);
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
        if (this.mPi != null) {
            this.mPi.N();
        }
    }

    public void v() {
        com.kascend.chushou.c.c.dBO().a(this.P, new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.VideoPlayer.17
            @Override // com.kascend.chushou.c.b
            public void a() {
            }

            @Override // com.kascend.chushou.c.b
            public void a(String str, JSONObject jSONObject) {
                if (!VideoPlayer.this.isFinishing()) {
                    ParserRet dB = com.kascend.chushou.c.e.dB(jSONObject);
                    if (dB.mRc == 0 && dB.mData != null) {
                        PkNotifyInfo pkNotifyInfo = (PkNotifyInfo) dB.mData;
                        VideoPlayer.this.mPH.b = VideoPlayer.this.P;
                        if (pkNotifyInfo != null) {
                            VideoPlayer.this.mPH.mUt = pkNotifyInfo;
                            if (VideoPlayer.this.mPi != null) {
                                VideoPlayer.this.mPi.a(pkNotifyInfo, VideoPlayer.this.P);
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
        if (this.mPl != null) {
            this.mPl.release();
            this.mPl = null;
        }
        com.kascend.chushou.c.c.dBO().a(this.P, new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.VideoPlayer.18
            @Override // com.kascend.chushou.c.b
            public void a() {
            }

            @Override // com.kascend.chushou.c.b
            public void a(String str, JSONObject jSONObject) {
                if (!VideoPlayer.this.isFinishing()) {
                    ParserRet dC = com.kascend.chushou.c.e.dC(jSONObject);
                    if (dC.mRc == 0 && dC.mData != null) {
                        RoomExpandInfo roomExpandInfo = (RoomExpandInfo) dC.mData;
                        if (VideoPlayer.this.mPk != null) {
                            VideoPlayer.this.mPk.mQR = roomExpandInfo.mTopWebAdItem;
                            if (VideoPlayer.this.mPk.s == null) {
                                VideoPlayer.this.mPk.s = new ArrayList();
                            }
                            VideoPlayer.this.mPk.s.clear();
                            VideoPlayer.this.mPk.s.addAll(roomExpandInfo.mGiftTopRightIcons);
                            tv.chushou.zues.a.a.post(new i(50, VideoPlayer.this.mPk.mQR));
                        }
                        if (VideoPlayer.this.mPk != null) {
                            VideoPlayer.this.mPk.fm(roomExpandInfo.mExpandNavList);
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
                            VideoPlayer.this.mPD.a(list);
                        }
                        List<com.kascend.chushou.player.ui.h5.c.c> list2 = roomExpandInfo.mLuckList;
                        if (!h.isEmpty(list2)) {
                            VideoPlayer.this.mPE.a(list2);
                        }
                        com.kascend.chushou.player.ui.h5.c.c cVar = roomExpandInfo.mVoteItem;
                        if (cVar != null) {
                            VideoPlayer.this.mPF.a(cVar);
                        }
                        List<com.kascend.chushou.player.ui.h5.c.b> list3 = roomExpandInfo.mInteractH5Item;
                        if (!h.isEmpty(list3)) {
                            VideoPlayer.this.mPI.a(list3);
                        }
                        List<com.kascend.chushou.player.ui.h5.c.b> list4 = roomExpandInfo.mInteractNavItem;
                        if (!h.isEmpty(list4)) {
                            VideoPlayer.this.mPI.a(list4);
                        }
                        VideoPlayer.this.mPl = (PrivilegeInfo) dC.mData1;
                        if (VideoPlayer.this.mPl != null) {
                            tv.chushou.zues.a.a.post(new l());
                        }
                        if (VideoPlayer.this.mPk != null) {
                            VideoPlayer.this.mPk.mQX = roomExpandInfo.mIconConfig;
                            VideoPlayer.this.dCm().a(roomExpandInfo.mIconConfig.bangConfig);
                        }
                        List<SkinConfig> list5 = roomExpandInfo.skinConfig;
                        if (list5 != null && VideoPlayer.this.mPk != null) {
                            VideoPlayer.this.mPk.mRb.clear();
                            int i = 0;
                            while (true) {
                                int i2 = i;
                                if (i2 >= list5.size()) {
                                    break;
                                }
                                SkinConfig skinConfig = list5.get(i2);
                                VideoPlayer.this.mPk.mRb.put(skinConfig.position, skinConfig.resource);
                                i = i2 + 1;
                            }
                            VideoPlayer.this.C();
                        }
                        VideoPlayer.this.a(roomExpandInfo.mIconConfig, VideoPlayer.this.mPk != null ? VideoPlayer.this.mPk.mRb : null);
                        if (roomExpandInfo.mColorMap != null && roomExpandInfo.mColorMap.size() > 0 && com.kascend.chushou.b.dBL().c != null && com.kascend.chushou.b.dBL().c.size() <= 0) {
                            com.kascend.chushou.b.dBL().c.putAll(roomExpandInfo.mColorMap);
                            tv.chushou.zues.a.a.post(new i(52, null));
                        }
                        AutoBang autoBang = roomExpandInfo.mAutoBang;
                        if (autoBang != null && autoBang.currentTime != 0 && autoBang.bangTime != 0) {
                            VideoPlayer.this.dCm().a(autoBang);
                        }
                        if (!h.isEmpty(roomExpandInfo.mRelatedRoomList) && VideoPlayer.this.mPk != null) {
                            VideoPlayer.this.mPk.t = roomExpandInfo.mRelatedRoomList;
                            if (VideoPlayer.this.mPi != null && VideoPlayer.this.H) {
                                VideoPlayer.this.mPi.w();
                            }
                        }
                        if (roomExpandInfo.mRoomNewUserInfo != null && roomExpandInfo.mRoomNewUserInfo.mBarrierNoviceGuide && !com.kascend.chushou.d.h.dBS().k() && VideoPlayer.this.mPi != null) {
                            VideoPlayer.this.mPi.J();
                        }
                        if (roomExpandInfo.mRoomNewUserInfo != null && roomExpandInfo.mRoomNewUserInfo.mRewardNoviceGuide && !com.kascend.chushou.d.h.dBS().l() && VideoPlayer.this.mPi != null) {
                            VideoPlayer.this.mPi.K();
                        }
                        if (!h.isEmpty(roomExpandInfo.mShopWindowInfos)) {
                            if (VideoPlayer.this.mPk != null) {
                                if (VideoPlayer.this.mPk.mQY == null) {
                                    VideoPlayer.this.mPk.mQY = new ArrayList();
                                }
                                VideoPlayer.this.mPk.mQY.addAll(roomExpandInfo.mShopWindowInfos);
                            }
                            if (VideoPlayer.this.mPi != null) {
                                VideoPlayer.this.mPi.L();
                            }
                        }
                        VideoPlayer.this.mPH.b = VideoPlayer.this.P;
                        if (roomExpandInfo.mPkNotifyInfo != null) {
                            VideoPlayer.this.mPH.mUt = roomExpandInfo.mPkNotifyInfo;
                            if (VideoPlayer.this.mPi != null) {
                                VideoPlayer.this.mPi.a(roomExpandInfo.mPkNotifyInfo, VideoPlayer.this.P);
                            }
                        } else {
                            VideoPlayer.this.mPH.mUt = null;
                        }
                        if (roomExpandInfo.mTrumpetPocket != null && VideoPlayer.this.mPk != null) {
                            VideoPlayer.this.mPk.mRa = roomExpandInfo.mTrumpetPocket;
                            if (VideoPlayer.this.mPi != null) {
                                VideoPlayer.this.mPi.M();
                            }
                        }
                        if (!h.isEmpty(roomExpandInfo.hotwordContentList)) {
                            if (VideoPlayer.this.mPk != null) {
                                if (VideoPlayer.this.mPk.mQZ == null) {
                                    VideoPlayer.this.mPk.mQZ = new ArrayList();
                                }
                                VideoPlayer.this.mPk.mQZ.clear();
                                VideoPlayer.this.mPk.mQZ.addAll(roomExpandInfo.hotwordContentList);
                            }
                            if (VideoPlayer.this.mPi != null) {
                                VideoPlayer.this.mPi.b(roomExpandInfo.hotwordContentList);
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
        }, this.mPA, this.mPJ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U() {
        if (!h.isEmpty(com.kascend.chushou.a.a.dBM().z)) {
            StringBuilder sb = new StringBuilder();
            if (com.kascend.chushou.a.a.dBM().z.contains(com.kascend.chushou.a.a.f)) {
                if (sb.length() > 0) {
                    sb.append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                sb.append(com.kascend.chushou.a.a.f);
            }
            if (com.kascend.chushou.a.a.dBM().z.contains(com.kascend.chushou.a.a.g)) {
                if (sb.length() > 0) {
                    sb.append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                sb.append(com.kascend.chushou.a.a.g);
            }
            if (com.kascend.chushou.a.a.dBM().z.contains(com.kascend.chushou.a.a.i)) {
                if (sb.length() > 0) {
                    sb.append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                sb.append(com.kascend.chushou.a.a.i);
            }
            if (com.kascend.chushou.a.a.dBM().z.contains(com.kascend.chushou.a.a.h)) {
                if (sb.length() > 0) {
                    sb.append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                sb.append(com.kascend.chushou.a.a.h);
            }
            if (com.kascend.chushou.a.a.dBM().z.contains(com.kascend.chushou.a.a.j)) {
                if (sb.length() > 0) {
                    sb.append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                sb.append(com.kascend.chushou.a.a.j);
            }
            if (com.kascend.chushou.a.a.dBM().z.contains(com.kascend.chushou.a.a.l)) {
                if (sb.length() > 0) {
                    sb.append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                sb.append(com.kascend.chushou.a.a.l);
            }
            if (com.kascend.chushou.a.a.dBM().z.contains(com.kascend.chushou.a.a.m)) {
                if (sb.length() > 0) {
                    sb.append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                sb.append(com.kascend.chushou.a.a.m);
            }
            if (sb.length() != 0) {
                com.kascend.chushou.a.a.dBM().a(sb.toString(), this.P, new a.c() { // from class: com.kascend.chushou.player.VideoPlayer.19
                    @Override // com.kascend.chushou.a.a.c
                    public void a(List<ListItem> list) {
                        if (VideoPlayer.this.mPk != null && list != null) {
                            int i = 0;
                            while (true) {
                                int i2 = i;
                                if (i2 >= list.size()) {
                                    break;
                                }
                                if (list.get(i2).mAdExtraInfo != null) {
                                    if (com.kascend.chushou.a.a.f.equals(list.get(i2).mAdExtraInfo.mCode)) {
                                        VideoPlayer.this.mPk.mQQ = list.get(i2);
                                    } else if (com.kascend.chushou.a.a.g.equals(list.get(i2).mAdExtraInfo.mCode)) {
                                        VideoPlayer.this.mPk.mQP = list.get(i2);
                                    } else if (com.kascend.chushou.a.a.i.equals(list.get(i2).mAdExtraInfo.mCode)) {
                                        VideoPlayer.this.mPk.mQS = list.get(i2);
                                    } else if (com.kascend.chushou.a.a.h.equals(list.get(i2).mAdExtraInfo.mCode)) {
                                        VideoPlayer.this.mPk.mQT = list.get(i2);
                                    } else if (com.kascend.chushou.a.a.j.equals(list.get(i2).mAdExtraInfo.mCode)) {
                                        VideoPlayer.this.mPk.mQW = list.get(i2);
                                    } else if (com.kascend.chushou.a.a.l.equals(list.get(i2).mAdExtraInfo.mCode)) {
                                        VideoPlayer.this.mPk.mQU = list.get(i2);
                                    } else if (com.kascend.chushou.a.a.m.equals(list.get(i2).mAdExtraInfo.mCode)) {
                                        VideoPlayer.this.mPk.mQV = list.get(i2);
                                    }
                                }
                                i = i2 + 1;
                            }
                            if (VideoPlayer.this.mPi != null) {
                                VideoPlayer.this.mPi.H();
                            }
                        }
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str, String str2) {
        if (ol()) {
            com.kascend.chushou.toolkit.a.a.j("type", "1", "value", str, "desc", str2, "videoId", this.P);
        }
    }

    public void d(boolean z) {
        int i;
        if (Build.VERSION.SDK_INT >= 11 && this.mPt != null) {
            if (!z) {
                if (Build.VERSION.SDK_INT >= 19) {
                    i = 5894;
                } else {
                    i = 1799;
                }
                this.mPt.setSystemUiVisibility(i);
                return;
            }
            this.mPt.setSystemUiVisibility(1792);
        }
    }

    public void e(boolean z) {
        Window window;
        View decorView;
        if (com.kascend.chushou.b.dBL().d != 1 && (window = getWindow()) != null && (decorView = window.getDecorView()) != null) {
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
        if (this.mPi != null) {
            this.mPi.a(i, i2, intent);
        }
    }

    public Uri dCf() {
        return this.mPd;
    }

    @Override // com.kascend.chushou.view.base.BaseActivity
    protected int y() {
        return 0;
    }

    public void wh(boolean z) {
        if (this.mPt != null) {
            this.mPt.nZG = z;
        }
    }

    public void dCg() {
        if (this.mPt != null) {
            this.mPt.dCg();
        }
    }

    public boolean dCh() {
        return this.ae;
    }

    public void f(boolean z) {
        this.ae = z;
    }

    public void g(boolean z) {
        if (this.mPt != null) {
            this.mPt.setIsTranslucentStatus(z);
        }
    }

    public void z() {
        if (this.mPt != null) {
            this.mPt.dQO();
        }
    }

    @Override // com.kascend.chushou.widget.gifts.RoomSendGiftView.a
    public void A() {
        if (this.mPr != null) {
            this.mPr.b();
        }
    }

    @Override // com.kascend.chushou.widget.gifts.RoomSendGiftView.a
    public void B() {
        if (this.mPr != null) {
            this.mPr.b();
        }
    }

    public void a(List<ListItem> list) {
        if (this.mPi != null) {
            this.mPi.a(list);
        }
    }

    public void a(IconConfig iconConfig, Map<String, SkinConfig.SkinRes> map) {
        if (this.mPi != null) {
            this.mPi.a(iconConfig, map);
        }
    }

    public void C() {
        if (this.mPi != null) {
            this.mPi.I();
        }
    }

    @Override // com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC0706a
    public void a(int i) {
        if (this.mPi != null) {
            this.mPi.a(i);
        }
    }

    @Override // com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC0706a
    public void D() {
        if (!isFinishing() && this.mPi != null) {
            this.mPi.D();
        }
    }

    @Override // com.kascend.chushou.player.ui.h5.b.b.a
    public void a(long j) {
        if (!isFinishing() && this.mPi != null) {
            this.mPi.a(j);
        }
    }

    @Override // com.kascend.chushou.player.ui.h5.b.b.a
    public void a(com.kascend.chushou.player.ui.h5.c.a aVar) {
        if (aVar != null && this.mPi != null) {
            this.mPi.a(aVar);
        }
    }

    @Override // com.kascend.chushou.player.ui.h5.b.b.a
    public void b(int i) {
        if (this.mPi != null) {
            this.mPi.b(i);
        }
    }

    @Override // com.kascend.chushou.player.ui.h5.d.a.InterfaceC0705a
    public void b(long j) {
        if (!isFinishing() && this.mPi != null) {
            this.mPi.b(j);
        }
    }

    @Override // com.kascend.chushou.player.ui.h5.a.a.InterfaceC0703a
    public void c(int i) {
        if (!isFinishing() && this.mPi != null) {
            this.mPi.c(i);
        }
    }

    @Override // com.kascend.chushou.player.ui.h5.d.a.InterfaceC0705a
    public void b(com.kascend.chushou.player.ui.h5.c.a aVar) {
        if (aVar != null && this.mPi != null) {
            this.mPi.b(aVar);
        }
    }

    @Override // com.kascend.chushou.player.ui.a.a.InterfaceC0700a
    public void a(IconConfig.Config config) {
        if (this.mPi != null) {
            this.mPi.a(config);
        }
    }

    @Override // com.kascend.chushou.player.ui.a.a.InterfaceC0700a
    public void a(BangInfo bangInfo, String str) {
        if (this.mPi != null) {
            this.mPi.a(bangInfo, str);
        }
    }

    @Override // com.kascend.chushou.player.ui.a.a.InterfaceC0700a
    public void a(long j, BangInfo bangInfo, String str) {
        if (this.mPi != null) {
            this.mPi.a(j, bangInfo, str);
        }
    }

    public com.kascend.chushou.player.ui.h5.redpacket.a dCi() {
        return this.mPD;
    }

    public com.kascend.chushou.player.ui.h5.b.b dCj() {
        return this.mPE;
    }

    public com.kascend.chushou.player.ui.h5.d.a dCk() {
        return this.mPF;
    }

    public com.kascend.chushou.player.ui.h5.a.a dCl() {
        return this.mPI;
    }

    public com.kascend.chushou.player.ui.a.a dCm() {
        return this.mPG;
    }

    public com.kascend.chushou.player.e.a dCn() {
        return this.mPH;
    }

    @Override // com.kascend.chushou.view.base.BaseActivity, android.app.Activity
    public void finish() {
        super.finish();
        if ("3".equals(this.R)) {
            overridePendingTransition(17432576, a.C0690a.commonres_activity_exit_bottom);
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
        RxExecutor.postDelayed(this.mPL, EventThread.MAIN_THREAD, aVar.d, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.VideoPlayer.2
            @Override // java.lang.Runnable
            public void run() {
                if (VideoPlayer.this.mPi != null) {
                    VideoPlayer.this.mPi.c(aVar);
                }
            }
        });
    }

    private void e(final com.kascend.chushou.player.ui.h5.c.a aVar) {
        if (!com.kascend.chushou.d.h.dBS().dBV().contains(aVar.b)) {
            if (aVar.d < 0) {
                aVar.d = 0;
            }
            RxExecutor.postDelayed(this.mPL, EventThread.MAIN_THREAD, aVar.d, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.VideoPlayer.3
                @Override // java.lang.Runnable
                public void run() {
                    if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.mPi != null) {
                        VideoPlayer.this.mPi.c(aVar);
                    }
                }
            });
        }
    }

    private String dCo() {
        if ("4".equals(this.aq)) {
            return TbEnum.SystemMessage.EVENT_ID_GROUP_NAME_MODIFY + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP + TbEnum.SystemMessage.EVENT_ID_NOTICE_MODIFY;
        }
        return "2" + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP + "1" + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP + TbEnum.SystemMessage.EVENT_ID_GROUP_NAME_MODIFY + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP + TbEnum.SystemMessage.EVENT_ID_NOTICE_MODIFY;
    }

    /* loaded from: classes5.dex */
    private class a extends BroadcastReceiver {
        private a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("android.media.VOLUME_CHANGED_ACTION".equals(intent.getAction())) {
                if (VideoPlayer.this.mPs != null && !VideoPlayer.this.isFinishing()) {
                    VideoPlayer.n = VideoPlayer.this.mPs.getStreamVolume(3);
                }
                if (!VideoPlayer.this.isFinishing() && (VideoPlayer.this.mPi instanceof f)) {
                    ((f) VideoPlayer.this.mPi).ab();
                }
            }
        }
    }

    public String a(String str) {
        HashMap hashMap = new HashMap(tv.chushou.zues.utils.d.SU(str));
        if ("1".equals(this.R)) {
            hashMap.put("roomId", this.P);
        } else if ("3".equals(this.R)) {
            hashMap.put("videoId", this.P);
        }
        return tv.chushou.zues.utils.d.toJson(hashMap);
    }

    public boolean dCp() {
        if (this.mPi instanceof com.kascend.chushou.player.d.a) {
            return ((com.kascend.chushou.player.d.a) this.mPi).dDv();
        }
        if (this.mPi instanceof com.kascend.chushou.player.e.e) {
            return true;
        }
        return false;
    }
}

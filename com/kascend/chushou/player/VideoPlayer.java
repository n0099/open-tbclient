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
    private c mOA;
    b mOD;
    public PrivilegeInfo mOE;
    com.kascend.chushou.widget.a.b mOI;
    private KPSwitchRootRelativeLayout mOK;
    private FrameLayout mOL;
    private LinearLayout mOM;
    private com.kascend.chushou.toolkit.d mON;
    com.kascend.chushou.view.b.a.a mOO;
    private String mOR;
    private FrescoThumbnailView mOS;
    private FrameLayout mOT;
    public com.kascend.chushou.player.feedback.a mPb;
    private a mPd;
    private CSTVWifiReceiver mPe;
    private boolean B = true;
    private boolean C = false;
    private Uri mOw = null;
    private tv.chushou.common.player.a mOx = null;
    public tv.chushou.common.player.a mOy = null;
    public tv.chushou.common.player.a mOz = null;
    public boolean d = false;
    public boolean e = false;
    private e mOB = null;
    private boolean H = false;
    private com.kascend.chushou.view.user.b mOC = null;
    private boolean J = false;
    private boolean K = false;
    private boolean L = false;
    private boolean M = false;
    private long N = 0;
    private int O = 0;
    public boolean g = false;
    private ImageView mOF = null;
    private TextView mOG = null;
    private AnimationImageView mOH = null;
    private View aQb = null;
    public boolean j = false;
    public float k = 0.0f;
    public float l = 0.0f;
    public boolean m = false;
    public AudioManager mOJ = null;
    private d.a mOP = new d.a() { // from class: com.kascend.chushou.player.VideoPlayer.1
        @Override // com.kascend.chushou.toolkit.d.a
        public void a() {
            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.mPf != null) {
                VideoPlayer.this.mPf.Oc(4);
            }
        }
    };
    private boolean ae = false;
    public boolean q = true;
    public long r = -1;
    public long s = -1;
    private PowerManager.WakeLock mOQ = null;
    public String t = null;
    private final com.kascend.chushou.player.ui.h5.redpacket.a mOU = new com.kascend.chushou.player.ui.h5.redpacket.a(this);
    private final com.kascend.chushou.player.ui.h5.b.b mOV = new com.kascend.chushou.player.ui.h5.b.b(this);
    private final com.kascend.chushou.player.ui.h5.d.a mOW = new com.kascend.chushou.player.ui.h5.d.a(this);
    private final com.kascend.chushou.player.ui.a.a mOX = new com.kascend.chushou.player.ui.a.a(this);
    private final com.kascend.chushou.player.e.a mOY = new com.kascend.chushou.player.e.a();
    private final com.kascend.chushou.player.ui.h5.a.a mOZ = new com.kascend.chushou.player.ui.h5.a.a(this);
    private String mPa = "1";
    private String aq = "2";
    private io.reactivex.disposables.a mPc = new io.reactivex.disposables.a();
    private tv.chushou.zues.c mPf = new tv.chushou.zues.c(new Handler.Callback() { // from class: com.kascend.chushou.player.VideoPlayer.6
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            try {
                if (!VideoPlayer.this.isFinishing()) {
                    switch (message.what) {
                        case 1:
                            VideoPlayer.this.mPf.removeMessages(1);
                            com.kascend.chushou.c.c.dAG().a(VideoPlayer.this.P, VideoPlayer.this.mOD != null ? VideoPlayer.this.mOD.h : null, System.currentTimeMillis());
                            VideoPlayer.this.mPf.L(1, VideoPlayer.A);
                            break;
                        case 2:
                            VideoPlayer.this.a(true, (Uri) null, false);
                            break;
                        case 3:
                            VideoPlayer.this.cWc();
                            break;
                        case 4:
                            if (VideoPlayer.this.mOB != null) {
                                VideoPlayer.this.mOB.a(true);
                            }
                            if (VideoPlayer.this.mON != null) {
                                VideoPlayer.this.mON.d();
                                VideoPlayer.this.mON = null;
                                break;
                            }
                            break;
                        case 5:
                            int i = message.arg1;
                            if (i == 1) {
                                if (VideoPlayer.this.mOB != null) {
                                    VideoPlayer.this.mOB.p();
                                    break;
                                }
                            } else if (i == 2 && VideoPlayer.this.mOB != null) {
                                VideoPlayer.this.mOB.e(message.arg2);
                                break;
                            }
                            break;
                        case 6:
                            if (!com.kascend.chushou.b.dAD().a && !com.kascend.chushou.b.dAD().b && VideoPlayer.this.mOB != null) {
                                VideoPlayer.this.mOB.g(true);
                                break;
                            } else {
                                VideoPlayer.this.c();
                                break;
                            }
                            break;
                        case 7:
                            tv.chushou.zues.utils.e.d(VideoPlayer.this.v, "MSG_BUFFER_DEALY: ");
                            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.mOB != null && VideoPlayer.this.M && !VideoPlayer.this.e) {
                                VideoPlayer.this.mOB.h(true);
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
    private boolean mPg = false;
    private boolean mPh = false;
    private tv.chushou.common.player.b mPi = new tv.chushou.common.player.b() { // from class: com.kascend.chushou.player.VideoPlayer.14
        @Override // tv.chushou.common.player.b
        public void dBj() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerACallback onSetVideoViewLayout");
            if (!VideoPlayer.this.isFinishing()) {
                if ((VideoPlayer.this.mOB == null || !VideoPlayer.this.mOB.H) && VideoPlayer.this.mOB != null && !VideoPlayer.this.d) {
                    VideoPlayer.this.mOB.y();
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void MD(int i) {
            if (!VideoPlayer.this.isFinishing()) {
                if ((VideoPlayer.this.mOB == null || !VideoPlayer.this.mOB.H) && VideoPlayer.this.mOB != null && !VideoPlayer.this.d) {
                    VideoPlayer.this.mOB.g(i);
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void dBk() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerACallback onCompletePlayback");
            if (!VideoPlayer.this.isFinishing()) {
                if (!h.isEmpty(VideoPlayer.this.P)) {
                    j.dAP().a(VideoPlayer.this.P, 0);
                }
                VideoPlayer.this.K = false;
                if (VideoPlayer.this.mPf != null) {
                    VideoPlayer.this.mPf.removeMessages(1);
                }
                if ((VideoPlayer.this.mOB == null || !VideoPlayer.this.mOB.H) && VideoPlayer.this.mOB != null && !VideoPlayer.this.d) {
                    VideoPlayer.this.mPf.removeMessages(7);
                    VideoPlayer.this.M = false;
                    VideoPlayer.this.mOB.z();
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void dBl() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerACallback onVideoRenderingStart");
            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.mOB != null) {
                VideoPlayer.this.mOB.G();
            }
        }

        @Override // tv.chushou.common.player.b
        public void dBm() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerACallback onPreparedPlayback");
            if (!VideoPlayer.this.isFinishing()) {
                if (VideoPlayer.this.mOB == null || !VideoPlayer.this.mOB.H) {
                    VideoPlayer.this.mPf.removeMessages(6);
                    VideoPlayer.this.N = 0L;
                    VideoPlayer.this.O = 0;
                    if (VideoPlayer.this.mOx != null && VideoPlayer.this.mOB != null) {
                        VideoPlayer.this.mOx.setVolume(VideoPlayer.this.mOB.J, VideoPlayer.this.mOB.J);
                    }
                    if (VideoPlayer.this.mOD != null) {
                        VideoPlayer.this.K = false;
                        FullRoomInfo dBu = VideoPlayer.this.nC() ? null : VideoPlayer.this.mOD.dBu();
                        if (VideoPlayer.this.L || dBu != null) {
                            if (VideoPlayer.this.mOD.e) {
                                VideoPlayer.this.mOD.e = false;
                                VideoPlayer.this.mOD.d = !VideoPlayer.this.mOD.d;
                            }
                            if (VideoPlayer.this.mOB != null) {
                                VideoPlayer.this.c("1", (String) null);
                                if (!VideoPlayer.this.d) {
                                    VideoPlayer.this.mOB.i(true);
                                } else if (VideoPlayer.this.e) {
                                    VideoPlayer.this.e = false;
                                    VideoPlayer.this.mOB.B();
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
                if (VideoPlayer.this.mPf != null) {
                    VideoPlayer.this.mPf.removeMessages(7);
                }
                if (VideoPlayer.this.mPf != null) {
                    VideoPlayer.this.mPf.removeMessages(1);
                }
                if ((VideoPlayer.this.mOB == null || !VideoPlayer.this.mOB.H) && !VideoPlayer.this.dAR()) {
                    if (!"10004".equals(VideoPlayer.this.t)) {
                        if (VideoPlayer.this.mOB != null) {
                            if (VideoPlayer.this.d) {
                                VideoPlayer.this.mOy.stop();
                                VideoPlayer.this.mOy.release();
                                VideoPlayer.this.e = false;
                                VideoPlayer.this.mOB.C();
                            }
                            if (!com.kascend.chushou.b.dAD().a && !com.kascend.chushou.b.dAD().b) {
                                VideoPlayer.this.mOB.g(true);
                            } else if (VideoPlayer.this.d) {
                                VideoPlayer.this.mOB.a(i, true);
                            } else {
                                VideoPlayer.this.mOB.a(i, false);
                            }
                            VideoPlayer.this.c("2", (String) null);
                            return;
                        }
                        return;
                    }
                    dBk();
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void dBn() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerACallback onBufferingStart");
            if (!VideoPlayer.this.isFinishing()) {
                if ((VideoPlayer.this.mOB == null || !VideoPlayer.this.mOB.H) && VideoPlayer.this.mOB != null && !VideoPlayer.this.d) {
                    VideoPlayer.this.mOB.E();
                    VideoPlayer.this.M = true;
                    long currentTimeMillis = System.currentTimeMillis();
                    VideoPlayer.this.mPf.removeMessages(7);
                    if (!VideoPlayer.this.g) {
                        VideoPlayer.y(VideoPlayer.this);
                    }
                    tv.chushou.zues.utils.e.d(VideoPlayer.this.v, "currentTime: -- >" + currentTimeMillis + "  bufferTime-->" + VideoPlayer.this.N + "  bufferCount-->" + VideoPlayer.this.O);
                    if (currentTimeMillis - VideoPlayer.this.N >= 20000 || VideoPlayer.this.O < 2 || VideoPlayer.this.mOB.H) {
                        if (VideoPlayer.this.O == 1) {
                            VideoPlayer.this.N = currentTimeMillis;
                        }
                        VideoPlayer.this.mPf.L(7, 5000L);
                    } else {
                        VideoPlayer.this.mPf.Oc(7);
                    }
                    if (VideoPlayer.this.g) {
                        VideoPlayer.this.g = false;
                    }
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void dBo() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerACallback onBufferingEnd");
            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.mOB != null && !VideoPlayer.this.d) {
                VideoPlayer.this.mPf.removeMessages(7);
                VideoPlayer.this.M = false;
                if (VideoPlayer.this.mOB == null || !VideoPlayer.this.mOB.H) {
                    if (VideoPlayer.this.mOx == null) {
                        VideoPlayer.this.mOB.a(false, true, false);
                    } else {
                        VideoPlayer.this.mOB.a(true, VideoPlayer.this.mOx.getPlayState() == 4, VideoPlayer.this.mOx.getPlayState() == 5);
                    }
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void dBp() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerACallback onPlayerStart");
            if (!VideoPlayer.this.isFinishing()) {
                if (VideoPlayer.this.mOB == null || !VideoPlayer.this.mOB.H) {
                    if (VideoPlayer.this.mOB != null && !VideoPlayer.this.d) {
                        if (VideoPlayer.this.mOx != null) {
                            VideoPlayer.this.mOB.F();
                            VideoPlayer.this.mOB.a(true, VideoPlayer.this.mOx.getPlayState() == 4, VideoPlayer.this.mOx.getPlayState() == 5);
                        } else {
                            VideoPlayer.this.mOB.a(false, true, false);
                        }
                    }
                    if (VideoPlayer.this.mPf != null && !VideoPlayer.this.nC()) {
                        VideoPlayer.this.mPf.removeMessages(1);
                        VideoPlayer.this.mPf.L(1, VideoPlayer.A);
                    }
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void dBq() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerACallback onPlayerPause");
            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.mPf != null) {
                VideoPlayer.this.mPf.removeMessages(1);
            }
        }

        @Override // tv.chushou.common.player.b
        public void dBr() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerACallback onPlayerStop");
            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.nC() && VideoPlayer.this.mOy != null && !h.isEmpty(VideoPlayer.this.P) && VideoPlayer.this.mOy.getCurrentPos() > 0) {
                j.dAP().a(VideoPlayer.this.P, VideoPlayer.this.mOy.getCurrentPos());
            }
        }
    };
    private tv.chushou.common.player.b mPj = new tv.chushou.common.player.b() { // from class: com.kascend.chushou.player.VideoPlayer.15
        @Override // tv.chushou.common.player.b
        public void dBj() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerBCallback onSetVideoViewLayout");
            if (!VideoPlayer.this.isFinishing()) {
                if ((VideoPlayer.this.mOB == null || !VideoPlayer.this.mOB.H) && VideoPlayer.this.mOB != null && VideoPlayer.this.d) {
                    VideoPlayer.this.mOB.y();
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void MD(int i) {
            if (!VideoPlayer.this.isFinishing()) {
                if ((VideoPlayer.this.mOB == null || !VideoPlayer.this.mOB.H) && VideoPlayer.this.mOB != null && VideoPlayer.this.d) {
                    VideoPlayer.this.mOB.g(i);
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void dBk() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerBCallback onCompletePlayback");
            if (!VideoPlayer.this.isFinishing()) {
                if (!h.isEmpty(VideoPlayer.this.P)) {
                    j.dAP().a(VideoPlayer.this.P, 0);
                }
                VideoPlayer.this.K = false;
                if (VideoPlayer.this.mPf != null) {
                    VideoPlayer.this.mPf.removeMessages(1);
                }
                if ((VideoPlayer.this.mOB == null || !VideoPlayer.this.mOB.H) && VideoPlayer.this.mOB != null && VideoPlayer.this.d) {
                    VideoPlayer.this.mPf.removeMessages(7);
                    VideoPlayer.this.M = false;
                    VideoPlayer.this.mOB.z();
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void dBl() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerBCallback onVideoRenderingStart");
            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.mOB != null) {
                VideoPlayer.this.mOB.G();
            }
        }

        @Override // tv.chushou.common.player.b
        public void dBm() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerBCallback onPreparedPlayback");
            if (!VideoPlayer.this.isFinishing()) {
                if (VideoPlayer.this.mOB == null || !VideoPlayer.this.mOB.H) {
                    VideoPlayer.this.mPf.removeMessages(6);
                    VideoPlayer.this.N = 0L;
                    VideoPlayer.this.O = 0;
                    if (VideoPlayer.this.mOx != null && VideoPlayer.this.mOB != null) {
                        VideoPlayer.this.mOx.setVolume(VideoPlayer.this.mOB.J, VideoPlayer.this.mOB.J);
                    }
                    if (VideoPlayer.this.mOD != null) {
                        VideoPlayer.this.K = false;
                        FullRoomInfo dBu = VideoPlayer.this.nC() ? null : VideoPlayer.this.mOD.dBu();
                        if (VideoPlayer.this.L || dBu != null) {
                            if (VideoPlayer.this.mOD.e) {
                                VideoPlayer.this.mOD.e = false;
                                VideoPlayer.this.mOD.d = !VideoPlayer.this.mOD.d;
                            }
                            if (VideoPlayer.this.mOB != null) {
                                VideoPlayer.this.c("1", (String) null);
                                if (VideoPlayer.this.d) {
                                    VideoPlayer.this.mOB.i(true);
                                } else if (VideoPlayer.this.e) {
                                    VideoPlayer.this.e = false;
                                    VideoPlayer.this.mOB.B();
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
                if (VideoPlayer.this.mPf != null) {
                    VideoPlayer.this.mPf.removeMessages(7);
                }
                if (VideoPlayer.this.mPf != null) {
                    VideoPlayer.this.mPf.removeMessages(1);
                }
                if ((VideoPlayer.this.mOB == null || !VideoPlayer.this.mOB.H) && !VideoPlayer.this.dAR()) {
                    if (!"10004".equals(VideoPlayer.this.t)) {
                        if (VideoPlayer.this.mOB != null) {
                            if (!VideoPlayer.this.d) {
                                VideoPlayer.this.mOz.stop();
                                VideoPlayer.this.mOz.release();
                                VideoPlayer.this.mOB.C();
                                VideoPlayer.this.e = false;
                            }
                            if (!com.kascend.chushou.b.dAD().a && !com.kascend.chushou.b.dAD().b) {
                                VideoPlayer.this.mOB.g(true);
                            } else if (VideoPlayer.this.d) {
                                VideoPlayer.this.mOB.a(i, false);
                            } else {
                                VideoPlayer.this.mOB.a(i, true);
                            }
                            VideoPlayer.this.c("2", (String) null);
                            return;
                        }
                        return;
                    }
                    dBk();
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void dBn() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerBCallback onBufferingStart");
            if (!VideoPlayer.this.isFinishing()) {
                if ((VideoPlayer.this.mOB == null || !VideoPlayer.this.mOB.H) && VideoPlayer.this.mOB != null && VideoPlayer.this.d) {
                    VideoPlayer.this.mOB.E();
                    VideoPlayer.this.M = true;
                    VideoPlayer.this.mPf.removeMessages(7);
                    long currentTimeMillis = System.currentTimeMillis();
                    if (!VideoPlayer.this.g) {
                        VideoPlayer.y(VideoPlayer.this);
                    }
                    tv.chushou.zues.utils.e.d(VideoPlayer.this.v, "currentTime: -- >" + currentTimeMillis + "  bufferTime-->" + VideoPlayer.this.N + "  bufferCount-->" + VideoPlayer.this.O);
                    if (currentTimeMillis - VideoPlayer.this.N >= 20000 || VideoPlayer.this.O < 2 || VideoPlayer.this.mOB.H) {
                        if (VideoPlayer.this.O == 1) {
                            VideoPlayer.this.N = currentTimeMillis;
                        }
                        VideoPlayer.this.mPf.L(7, 5000L);
                    } else {
                        VideoPlayer.this.N = 0L;
                        VideoPlayer.this.O = 0;
                        VideoPlayer.this.mPf.Oc(7);
                    }
                    if (VideoPlayer.this.g) {
                        VideoPlayer.this.g = false;
                    }
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void dBo() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerBCallback onBufferingEnd");
            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.mOB != null && VideoPlayer.this.d) {
                VideoPlayer.this.M = false;
                VideoPlayer.this.mPf.removeMessages(7);
                if (VideoPlayer.this.mOB == null || !VideoPlayer.this.mOB.H) {
                    if (VideoPlayer.this.mOx == null) {
                        VideoPlayer.this.mOB.a(false, true, false);
                    } else {
                        VideoPlayer.this.mOB.a(true, VideoPlayer.this.mOx.getPlayState() == 4, VideoPlayer.this.mOx.getPlayState() == 5);
                    }
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void dBp() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerBCallback onPlayerStart");
            if (!VideoPlayer.this.isFinishing()) {
                if (VideoPlayer.this.mOB == null || !VideoPlayer.this.mOB.H) {
                    if (VideoPlayer.this.mOB != null && VideoPlayer.this.d) {
                        if (VideoPlayer.this.mOx != null) {
                            VideoPlayer.this.mOB.F();
                            VideoPlayer.this.mOB.a(true, VideoPlayer.this.mOx.getPlayState() == 4, VideoPlayer.this.mOx.getPlayState() == 5);
                        } else {
                            VideoPlayer.this.mOB.a(false, true, false);
                        }
                    }
                    if (VideoPlayer.this.mPf != null && !VideoPlayer.this.nC()) {
                        VideoPlayer.this.mPf.removeMessages(1);
                        VideoPlayer.this.mPf.L(1, VideoPlayer.A);
                    }
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void dBq() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerBCallback onPlayerPause");
            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.mPf != null) {
                VideoPlayer.this.mPf.removeMessages(1);
            }
        }

        @Override // tv.chushou.common.player.b
        public void dBr() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerBCallback onPlayerStop");
            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.nC() && VideoPlayer.this.mOz != null && !h.isEmpty(VideoPlayer.this.P) && VideoPlayer.this.mOz.getCurrentPos() > 0) {
                j.dAP().a(VideoPlayer.this.P, VideoPlayer.this.mOz.getCurrentPos());
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
        if (this.mPe == null) {
            this.mPe = new CSTVWifiReceiver();
            registerReceiver(this.mPe, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        }
        com.kascend.chushou.toolkit.d.a.dDc().b();
        this.mOw = intent.getData();
        tv.chushou.zues.utils.e.i(this.v, "intent.getData=" + this.mOw.toString());
        String scheme = this.mOw.getScheme();
        if (scheme == null || !scheme.equals("chushou")) {
            tv.chushou.zues.utils.e.e(this.v, "not support scheme :" + scheme);
            finish();
            return;
        }
        a(intent);
    }

    private void a(Intent intent) {
        this.P = this.mOw.getQueryParameter("roomId");
        this.Q = this.P;
        this.S = this.mOw.getQueryParameter(WebSocketRequest.PARAM_KEY_PROTOCOLS);
        this.aq = this.mOw.getQueryParameter("liveType");
        if ("2".equals(this.aq) || "3".equals(this.aq) || "4".equals(this.aq)) {
            this.mPa = "2";
            this.mPb = new com.kascend.chushou.player.feedback.a();
            if (this.mPb.mXD != null) {
                this.mPb.mXD.reset();
                this.mPb.mXD.roomId = this.P;
                this.mPb.mXD.enterType = 1;
                this.mPb.b = System.currentTimeMillis();
            }
        }
        if (h.isEmpty(this.P) || h.isEmpty(this.S)) {
            tv.chushou.zues.utils.e.e(this.v, "invalid param mItemID=" + this.P + " protocols=" + this.S);
            finish();
            return;
        }
        if (com.kascend.chushou.b.dAD().d == -1) {
            com.kascend.chushou.b.dAD().d = com.kascend.chushou.d.g.b() ? 1 : 0;
        }
        this.mOQ = ((PowerManager) getSystemService("power")).newWakeLock(536870938, this.v);
        this.mOQ.acquire();
        this.mOD = new b(this.P);
        this.mOD.d = intent.getBooleanExtra("room_play_audio", false);
        this.mOI = new com.kascend.chushou.widget.a.b();
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
        this.mOK = (KPSwitchRootRelativeLayout) findViewById(a.f.rlRoot);
        if (!"2".equals(this.mPa) && com.kascend.chushou.b.dAD().d == 1) {
            this.mOK.setFitsSystemWindows(true);
        }
        this.mOL = (FrameLayout) this.mOK.findViewById(a.f.fl_fragment);
        this.aQb = this.mOK.findViewById(a.f.rl_empty);
        this.mOF = (ImageView) this.aQb.findViewById(a.f.iv_empty);
        this.mOG = (TextView) this.aQb.findViewById(a.f.tv_empty);
        this.mOM = (LinearLayout) this.mOK.findViewById(a.f.rl_title);
        this.Z = (ImageView) this.mOM.findViewById(a.f.back_icon);
        this.Z.setOnClickListener(new View.OnClickListener() { // from class: com.kascend.chushou.player.VideoPlayer.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayer.this.finish();
            }
        });
        this.mOH = (AnimationImageView) this.aQb.findViewById(a.f.iv_loading);
        this.mOS = (FrescoThumbnailView) this.mOK.findViewById(a.f.live_cover);
        this.mOT = (FrameLayout) this.mOK.findViewById(a.f.fl_cover);
        this.k = dAQ();
        try {
            this.mOJ = (AudioManager) getApplicationContext().getSystemService("audio");
            n = this.mOJ.getStreamVolume(3);
            this.mOJ.requestAudioFocus(null, 3, 1);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (this.B) {
            a(1, nC() ? "3" : "1");
        } else {
            r();
        }
        if (com.kascend.chushou.b.dAD().b && !com.kascend.chushou.b.dAD().a) {
            RxExecutor.postDelayed(this.mPc, EventThread.MAIN_THREAD, 60L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.VideoPlayer.5
                @Override // java.lang.Runnable
                public void run() {
                    if (!VideoPlayer.this.isFinishing() && com.kascend.chushou.b.dAD().b && !com.kascend.chushou.b.dAD().a) {
                        tv.chushou.zues.utils.g.c(VideoPlayer.this.w, VideoPlayer.this.getString(a.i.str_monet_notify));
                    }
                }
            });
        }
        com.kascend.chushou.c.c.dAG().a(this.P, stringExtra, System.currentTimeMillis());
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
        if (this.mPd == null) {
            this.mPd = new a();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.media.VOLUME_CHANGED_ACTION");
            registerReceiver(this.mPd, intentFilter);
        }
    }

    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        if (this.mPd != null) {
            unregisterReceiver(this.mPd);
            this.mPd = null;
        }
        super.onStop();
    }

    @Subscribe
    public void onHideGiftEffectEvent(com.kascend.chushou.b.a.a.f fVar) {
        if (fVar.b) {
            this.mOB.k();
            return;
        }
        this.mOB.m();
        this.mOB.l();
    }

    private float dAQ() {
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
        this.mOR = str;
        R();
        try {
            if (h.isEmpty(str)) {
                jSONObject = new JSONObject();
            } else {
                jSONObject = new JSONObject(str);
            }
            jSONObject.put("_fbroomid", this.P);
            this.mOD.h = jSONObject.toString();
            String optString = jSONObject.optString("_thumb");
            jSONObject.optBoolean("tag_from_game_mic", false);
            if (!h.isEmpty(optString)) {
                this.ab = optString;
            }
        } catch (JSONException e) {
            e.printStackTrace();
            this.mOD.h = str;
        }
        if (nC()) {
            a(this.P, str);
            aO(this.P, z);
            return;
        }
        a = this.P;
        b(this.P, str);
        a(this.P, dBg(), z);
        w();
    }

    private void O() {
        this.m = true;
        j();
        if (this.mOB != null) {
            this.mOB.r();
        }
        s();
    }

    @Subscribe
    public void onStartRoomEvent(o oVar) {
        if (!isFinishing() && oVar.mOe != null && oVar.c != null && !h.isEmpty(oVar.mOe.mTargetKey)) {
            if (oVar.c != this) {
                tv.chushou.zues.utils.e.e(this.v, "different player!");
                return;
            }
            if (this.mOD != null) {
                this.mOD.a();
                this.mOD.a = oVar.mOe.mTargetKey;
                this.mOD.d = oVar.d;
                if (this.mOD.mQe != null) {
                    this.mOD.mQe.e();
                }
                if (this.mOD.mQe != null) {
                    this.mOD.mQe.b();
                }
                this.mOD.mQi = null;
                this.mOD.mQh = null;
                this.mOD.mQl = null;
                this.mOD.mQk = null;
                this.mOD.mQo = null;
                this.mOD.mQm = null;
                this.mOD.mQn = null;
            }
            if (this.mOJ != null) {
                n = this.mOJ.getStreamVolume(3);
            }
            if (!h.isEmpty(oVar.mOe.mType) && oVar.mOe.mType.equals("3")) {
                this.B = false;
                this.mPa = "1";
                r();
                this.P = oVar.mOe.mTargetKey;
                this.R = "3";
                if (this.mOI != null) {
                    this.mOI.a();
                }
                if (this.mOD != null) {
                    this.mOD.a((PlayUrl) null);
                    this.mOD.f();
                    if (this.mOD.c() != null) {
                        this.mOD.c().clear();
                    }
                    this.mOD.i.clear();
                }
                if (this.mOB != null) {
                    this.mOB.j();
                }
                s();
                if (this.mON != null) {
                    this.mON.d();
                    this.mON = null;
                }
                if (this.mPc != null) {
                    this.mPc.dispose();
                    this.mPc = new io.reactivex.disposables.a();
                }
                a(oVar.e, false);
                return;
            }
            boolean z = this.R != null && this.R.equals("1");
            this.R = "1";
            this.mOX.a();
            this.mOW.a();
            this.mOV.a();
            this.mOU.c();
            this.mOZ.a();
            if (this.mPc != null) {
                this.mPc.dispose();
                this.mPc = new io.reactivex.disposables.a();
            }
            if ("1".equals(oVar.f)) {
                this.H = false;
                if (this.mOD != null && !h.isEmpty(this.mOD.t)) {
                    this.mOD.t.clear();
                }
                this.ab = oVar.mOe.mCover;
                this.mOT.setVisibility(0);
                this.mOS.setBlur(true);
                this.mOS.i(oVar.mOe.mCover, 0, 0, 0);
            }
            if (!oVar.mOe.mTargetKey.equals(this.P)) {
                this.aq = oVar.g;
                if (!z) {
                    this.B = false;
                    r();
                } else if (!"2".equals(this.mPa) && ("2".equals(this.aq) || "3".equals(this.aq) || "4".equals(this.aq))) {
                    this.mPa = "2";
                    this.mPb = new com.kascend.chushou.player.feedback.a();
                    if (this.mPb.mXD != null) {
                        this.mPb.mXD.reset();
                        this.mPb.mXD.roomId = oVar.mOe.mTargetKey;
                        this.mPb.mXD.enterType = 1;
                        this.mPb.b = System.currentTimeMillis();
                    }
                }
                this.B = false;
                this.P = oVar.mOe.mTargetKey;
                this.Q = this.P;
                this.ab = oVar.mOe.mCover;
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
                JSONObject M = com.kascend.chushou.d.e.M("_fromView", str, "_sc", oVar.mOe.mSC);
                com.kascend.chushou.toolkit.a.c.a(this.w, M);
                if (this.mOI != null) {
                    this.mOI.a();
                    this.mOI.a(this.P);
                }
                if (this.mOD != null) {
                    this.mOD.a((PlayUrl) null);
                    this.mOD.f();
                    if (this.mOD.c() != null) {
                        this.mOD.c().clear();
                    }
                    this.mOD.i.clear();
                }
                if (this.mOB != null) {
                    this.mOB.j();
                }
                a(M.toString(), false);
                return;
            }
            Toast.makeText(this, a.i.str_same_room, 0).show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dAR() {
        FullRoomInfo dBu;
        String str;
        RoomInfo roomInfo;
        if (nC()) {
            str = null;
            dBu = null;
        } else {
            dBu = this.mOD.dBu();
            str = (dBu == null || (roomInfo = dBu.mRoominfo) == null) ? null : roomInfo.mGameId;
        }
        return !this.L && (dBu == null || h.isEmpty(str));
    }

    @Subscribe
    public void onMessageEvent(i iVar) {
        if (!isFinishing() && iVar.a != 21 && iVar.a != 22) {
            if (iVar.a == 0 && (iVar.b instanceof Boolean)) {
                if (((Boolean) iVar.b).booleanValue() && !isFinishing()) {
                    w();
                    if (this.mOB != null) {
                        this.mOB.f();
                    }
                }
            } else if (iVar.a == 46) {
                if ((iVar.b instanceof String) && this.mOB != null) {
                    this.mOB.c((String) iVar.b);
                }
            } else if (iVar.a == 54) {
                if (iVar.b instanceof String) {
                    this.mOV.a((String) iVar.b);
                }
            } else if (iVar.a == 55) {
                if (this.mOB != null) {
                    this.mOB.O();
                }
            } else if (iVar.a == 56 && this.mOB != null) {
                this.mOB.P();
            }
        }
    }

    @Subscribe
    public void onRefreshSubscribeEvent(m mVar) {
        if (isFinishing() && this.mOD != null && this.mOD.dBw() != null) {
            RoomInfo dBw = this.mOD.dBw();
            if (mVar.a(dBw.mCreatorUID, dBw.mRoomID)) {
                dBw.mIsSubscribed = mVar.c;
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
        if (this.m || this.mOy == null || this.mOz == null) {
            R();
        }
        if (this.mOI != null) {
            this.mOI.d();
        }
        if (!nC()) {
            if (this.mON != null && !this.mON.c()) {
                this.mON.a();
            }
            v();
            if (this.mOD != null && this.mOD.dBu() != null && this.mOD.dBu().cycleLiveRoomInfo != null && !h.isEmpty(this.mOD.dBu().cycleLiveRoomInfo.roomId)) {
                u();
            }
        }
        super.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.view.base.BaseActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        tv.chushou.zues.utils.e.e(this.v, MissionEvent.MESSAGE_DESTROY);
        if (this.mOD != null && this.mOD.dBu() != null && this.mOD.dBu().cycleLiveRoomInfo != null && !h.isEmpty(this.mOD.dBu().cycleLiveRoomInfo.eventName)) {
            j.dAP().a(this.P + dBg());
        }
        if ("2".equals(this.mPa) && this.mPb != null && this.mPb.mXD != null) {
            this.mPb.mXD.time = System.currentTimeMillis() - this.mPb.b;
            this.mPb.a();
            this.mPb.b();
        }
        this.mOU.d();
        this.mOV.b();
        this.mOW.b();
        O();
        this.mOR = null;
        a = null;
        if (this.mPf != null) {
            this.mPf.cp(null);
            this.mPf = null;
        }
        if (this.mON != null) {
            this.mON.d();
            this.mON = null;
        }
        if (this.mOI != null) {
            this.mOI.c();
            this.mOI = null;
        }
        if (this.mOD != null) {
            this.mOD.mQi = null;
            this.mOD.mQh = null;
        }
        if (this.mOD != null) {
            this.mOD.b();
            this.mOD = null;
        }
        this.mOw = null;
        this.mOB = null;
        this.mOC = null;
        this.mOE = null;
        this.mOF = null;
        this.mOG = null;
        this.mOH = null;
        this.aQb = null;
        this.mOJ = null;
        this.mOK = null;
        this.mOL = null;
        this.Z = null;
        this.mOM = null;
        if (this.mOQ != null && this.mOQ.isHeld()) {
            this.mOQ.release();
            this.mOQ = null;
        }
        if (this.mPe != null) {
            unregisterReceiver(this.mPe);
            this.mPe = null;
        }
        h.dPe();
        tv.chushou.zues.a.a.cq(this);
        this.mPc.dispose();
        this.mOW.b();
        this.mOX.b();
        this.mOU.d();
        this.mOV.b();
        this.mOZ.b();
        super.onDestroy();
        System.gc();
    }

    @Subscribe
    public void onSendGameGiftEvent(n nVar) {
        if (!isFinishing() && this.mOB != null) {
            this.mOB.a(nVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.view.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        tv.chushou.zues.utils.e.d(this.v, MissionEvent.MESSAGE_PAUSE);
        if (this.mON != null) {
            this.mON.b();
        }
        if (this.mOI != null) {
            this.mOI.b(false);
        }
        k();
        this.m = true;
        super.onPause();
    }

    @Override // android.app.Activity
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.mOB != null ? this.mOB.a(motionEvent) : super.onTouchEvent(motionEvent);
    }

    public void c() {
        if ("1".equals(this.R)) {
            j.dAP().a(this.P + dBg());
        } else {
            j.dAP().b(this.P);
        }
    }

    private void a(boolean z, boolean z2) {
        int i = 0;
        tv.chushou.zues.utils.e.i(this.v, "startLoadingVideo <------------- mbPrepareingVideo = " + this.K);
        if (this.mOy != null) {
            this.mOy.setHardwearDecod(com.kascend.chushou.d.h.dAK().a);
        }
        if (this.mOz != null) {
            this.mOz.setHardwearDecod(com.kascend.chushou.d.h.dAK().a);
        }
        if (this.mOx != null) {
            this.mOx.setHardwearDecod(com.kascend.chushou.d.h.dAK().a);
        }
        if (!this.K) {
            if (z && this.mOB != null) {
                if (!z2) {
                    this.t = null;
                    this.mOB.e();
                }
            } else if (this.mOB != null && !z2) {
                this.t = null;
                this.mOB.H = false;
                RxExecutor.post(null, EventThread.MAIN_THREAD, new Runnable() { // from class: com.kascend.chushou.player.VideoPlayer.7
                    @Override // java.lang.Runnable
                    public void run() {
                        VideoPlayer.this.mOB.x();
                    }
                });
            }
            this.K = true;
            if (this.mOD != null && this.mOD.dBv() != null) {
                PlayUrl dBv = this.mOD.dBv();
                while (true) {
                    int i2 = i;
                    if (i2 >= dBv.mUrlDetails.size()) {
                        break;
                    }
                    UrlDetails urlDetails = dBv.mUrlDetails.get(i2);
                    if (urlDetails.mUrl.equals(dBv.mSelectedUrl)) {
                        String str = dBv.mUrlDetails.get(i2).mDefinitionType;
                        String str2 = urlDetails.mBitrate;
                    }
                    i = i2 + 1;
                }
            }
            if (z2) {
                if (this.d) {
                    this.mOy.setVideoURI(this.mOw);
                    this.mOy.open();
                    return;
                }
                this.mOz.setVideoURI(this.mOw);
                this.mOz.open();
                return;
            }
            this.mOx.setVideoURI(this.mOw);
            this.mOx.open();
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        try {
            if (motionEvent.getAction() == 0) {
                if (this.mOB != null && this.mOB.b(motionEvent)) {
                    return true;
                }
                if ("2".equals(this.mPa) && this.mOB != null) {
                    this.mOB.a(motionEvent);
                }
            } else if (this.mOB != null && this.mOB.b(motionEvent)) {
                return true;
            }
            return super.dispatchTouchEvent(motionEvent);
        } catch (Exception e) {
            return false;
        }
    }

    @Override // android.support.v7.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.mOB != null && this.mOB.a(i, keyEvent)) {
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
        if (this.mOD != null && this.mOD.dBu() != null && this.mOD.dBu().cycleLiveRoomInfo != null && !h.isEmpty(this.mOD.dBu().cycleLiveRoomInfo.roomId)) {
            this.mOT.setVisibility(0);
            this.mOS.setBlur(true);
            this.mOS.i(this.mOD.dBu().cycleLiveRoomInfo.avatar, 0, 0, 0);
            this.mOS.setVisibility(0);
            j.dAP().a(this.P + dBg());
            this.mOw = null;
            R();
            this.Q = this.mOD.dBu().cycleLiveRoomInfo.roomId;
            a(this.P, dBg(), false);
        }
    }

    public void a(boolean z) {
        if (this.mOB != null) {
            this.mOB.j(z);
        }
    }

    public void a(boolean z, Uri uri, boolean z2) {
        tv.chushou.zues.utils.e.d(this.v, "loadIfNecessary reload=" + z + " isChangeLines-->" + z2);
        if (this.mOy != null && this.mOz != null) {
            if (uri != null) {
                this.mOw = uri;
            }
            if (z2) {
                this.e = z2;
            }
            this.M = false;
            this.N = 0L;
            this.O = 0;
            this.mPf.removeMessages(7);
            if (z) {
                if (z2) {
                    if (!this.d) {
                        this.mOz.setOnActivityCallBack(this.mPj);
                    } else {
                        this.mOy.setOnActivityCallBack(this.mPi);
                    }
                } else if (this.d) {
                    this.mOz.setOnActivityCallBack(this.mPj);
                } else {
                    this.mOy.setOnActivityCallBack(this.mPi);
                }
                this.K = false;
                b(true, z2);
            } else if (!this.J) {
                b(true, z2);
            }
            this.mPf.L(6, 3000L);
        }
    }

    private void b(boolean z, boolean z2) {
        VideoPlayInfo O;
        if ("1".equals(this.R)) {
            O = j.dAP().N(this.P + dBg(), KeepJobService.JOB_CHECK_PERIODIC);
        } else {
            O = j.dAP().O(this.P, KeepJobService.JOB_CHECK_PERIODIC);
        }
        if (O != null) {
            a(z, z2);
        } else if ("1".equals(this.R)) {
            a(this.P, dBg(), false);
        } else {
            aO(this.P, false);
        }
    }

    public tv.chushou.common.player.a dAS() {
        return this.mOx;
    }

    public tv.chushou.common.player.a dAT() {
        return this.mOy;
    }

    public tv.chushou.common.player.a dAU() {
        return this.mOz;
    }

    public void a(tv.chushou.common.player.a aVar) {
        this.mOx = aVar;
    }

    public b dAV() {
        return this.mOD;
    }

    public com.kascend.chushou.widget.a.b dAW() {
        return this.mOI;
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
        FullRoomInfo dBu;
        this.r = -1L;
        if (this.s != -1 && this.s != 0) {
            this.r = this.s;
            this.s = -1L;
        }
        if (nC() && this.mOx != null && this.mOx.getPlayState() == 4) {
            this.r = this.mOx.getCurrentPos();
        }
        this.mPg = false;
        tv.chushou.zues.utils.e.d(this.v, "screenChange()<-----");
        tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard(this);
        if (str != null) {
            this.R = str;
        }
        if (!this.C || !z3 || "3".equals(this.R) || this.mOD == null || (dBu = this.mOD.dBu()) == null || dBu.mRoominfo == null || dBu.mRoominfo.mStyle != 1) {
            z5 = false;
        } else {
            z5 = true;
            i = 0;
        }
        if ("2".equals(this.mPa)) {
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
            if (this.mOK != null) {
                this.mOK.setSystemUiVisibility(1792);
            }
        } else if (1 == i) {
            setRequestedOrientation(1);
            ((VideoPlayer) this.w).f(true);
            if (com.kascend.chushou.b.dAD().d == 1) {
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
        if (this.mOI == null) {
            this.mOI = new com.kascend.chushou.widget.a.b();
        }
        if (this.mOI != null) {
            this.mOI.a(this.P);
        }
        if (this.R.equals("5")) {
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            if (this.mOB != null) {
                beginTransaction.remove(this.mOB);
                this.mOB = null;
            }
            if (this.mOC != null) {
                beginTransaction.remove(this.mOC);
                this.mOC = null;
            }
            this.mOC = new com.kascend.chushou.view.user.b();
            beginTransaction.add(a.f.fl_fragment, this.mOC);
            beginTransaction.commitAllowingStateLoss();
        } else {
            FragmentTransaction beginTransaction2 = getSupportFragmentManager().beginTransaction();
            if (this.mOB != null) {
                beginTransaction2.remove(this.mOB);
                this.mOB = null;
            }
            if (this.mOC != null) {
                beginTransaction2.remove(this.mOC);
                this.mOC = null;
            }
            if ("2".equals(this.mPa)) {
                this.mOB = com.kascend.chushou.player.e.e.a(this.ab, z2, this.aq, this.P);
            } else if (1 == i) {
                if (!this.R.equals("3")) {
                    if (z4) {
                        v();
                    }
                    this.mOB = new com.kascend.chushou.player.d.a();
                    Bundle bundle = new Bundle();
                    bundle.putString("mCover", this.ab);
                    bundle.putBoolean("mInitViewAsync", z2);
                    this.mOB.setArguments(bundle);
                }
            } else {
                this.mOB = new com.kascend.chushou.player.d.b();
                Bundle bundle2 = new Bundle();
                if (z5) {
                    i = 1;
                }
                bundle2.putInt("mExtraOrientation", i);
                bundle2.putString("mViewType", this.R);
                this.mOB.setArguments(bundle2);
            }
            beginTransaction2.add(a.f.fl_fragment, this.mOB);
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
        if (this.mOB != null) {
            this.mOB.mTJ = null;
        }
        if (this.mOx != null) {
            this.mOx.release();
            this.mOx = null;
            this.K = false;
        }
        if (this.mOy != null) {
            this.mOy.release();
            this.mOy = null;
        }
        if (this.mOz != null) {
            this.mOz.release();
            this.mOz = null;
        }
        if (this.mOA != null) {
            this.mOA.c();
        }
        this.d = false;
        this.e = false;
        this.M = false;
        this.mOA = new c();
        this.mOy = this.mOA.dBy();
        this.mOy.setOnActivityCallBack(this.mPi);
        this.mOz = this.mOA.dBz();
        this.mOz.setOnActivityCallBack(this.mPj);
        if (!this.d) {
            this.mOx = this.mOy;
        } else {
            this.mOx = this.mOz;
        }
        if (this.mOB != null) {
            this.mOB.mTJ = this.mOx;
        }
    }

    public void j() {
        if (this.mOx != null) {
            this.mOx.pause();
            this.mOx.stop();
            this.mOx.release();
            this.mOx = null;
        }
        if (this.mOy != null) {
            this.mOy.stop();
            this.mOy.release();
            this.mOy = null;
        }
        if (this.mOz != null) {
            this.mOz.stop();
            this.mOz.release();
            this.mOz = null;
        }
        if (this.mOA != null) {
            this.mOA.c();
        }
    }

    public void k() {
        tv.chushou.common.player.a aVar = this.mOx;
        if (aVar != null) {
            aVar.pause();
            aVar.stop();
        }
        tv.chushou.common.player.a aVar2 = this.mOy;
        if (aVar2 != null) {
            aVar2.stop();
        }
        tv.chushou.common.player.a aVar3 = this.mOz;
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
    public void cWc() {
        if (this.mPg) {
            if (this.mOB != null) {
                this.mOB.s();
            }
        } else if (this.mPf != null) {
            this.mPf.a(this.mPf.Oe(3), 20L);
        }
    }

    private void b(final String str, String str2) {
        com.kascend.chushou.c.c.dAG().a(new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.VideoPlayer.8
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
                    VideoPlayer.this.dBe().a(fullRoomInfo.mBangMap);
                    if (h.isEmpty(fullRoomInfo.mRoominfo.mRoomID)) {
                        fullRoomInfo.mRoominfo.mRoomID = VideoPlayer.this.P;
                    }
                    if (!h.isEmpty(fullRoomInfo.mGeneralTabGifts)) {
                        com.kascend.chushou.d.e.a(VideoPlayer.this.mPc, new ArrayList(fullRoomInfo.mGeneralTabGifts));
                    }
                    if (VideoPlayer.this.mOD != null) {
                        VideoPlayer.this.mOD.a(fullRoomInfo);
                    }
                    VideoPlayer.this.L = false;
                    if (VideoPlayer.this.B) {
                        if (VideoPlayer.this.C && !"3".equals(VideoPlayer.this.R) && fullRoomInfo != null && fullRoomInfo.mRoominfo != null && fullRoomInfo.mRoominfo.mStyle == 1 && !h.isEmpty(fullRoomInfo.mRoominfo.mGameId)) {
                            z = true;
                        }
                        if (!z) {
                            if (VideoPlayer.this.mOB != null) {
                                VideoPlayer.this.mOB.a(VideoPlayer.this.mOD);
                            }
                            if (!h.isEmpty(fullRoomInfo.mRoominfo.mGameId)) {
                                VideoPlayer.this.cWc();
                            } else {
                                if (VideoPlayer.this.mOD != null) {
                                    VideoPlayer.this.mOD.f = null;
                                }
                                VideoPlayer.this.cWc();
                            }
                        } else {
                            VideoPlayer.this.a(1, "1", true);
                            if (VideoPlayer.this.mOB != null) {
                                VideoPlayer.this.mOB.a(VideoPlayer.this.mOD);
                            }
                        }
                    } else {
                        if (h.isEmpty(fullRoomInfo.mRoominfo.mGameId)) {
                            if (VideoPlayer.this.mOD != null) {
                                VideoPlayer.this.mOD.f = null;
                            }
                            VideoPlayer.this.a(1, "1");
                        } else {
                            VideoPlayer.this.a(1, "1", true);
                        }
                        if (VideoPlayer.this.mOB != null) {
                            VideoPlayer.this.mOB.a(VideoPlayer.this.mOD);
                        }
                    }
                    if (VideoPlayer.this.mOD != null && !VideoPlayer.this.mOD.m()) {
                        if (VideoPlayer.this.mON != null) {
                            VideoPlayer.this.mON.d();
                            VideoPlayer.this.mON = null;
                        }
                        VideoPlayer.this.mON = new com.kascend.chushou.toolkit.d(900000L, VideoPlayer.this.mOP, VideoPlayer.this.mPf);
                        VideoPlayer.this.mON.a();
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
        if (this.mOD != null) {
            this.mOD.a((FullRoomInfo) null);
        }
        this.L = false;
        bO(str, i);
        if (this.mOx != null) {
            this.mOx.stop();
        }
        if (this.mOy != null) {
            this.mOy.stop();
        }
        if (this.mOz != null) {
            this.mOz.stop();
        }
    }

    public void l() {
        tv.chushou.zues.utils.e.d(this.v, "retryGetPlayList");
        c();
        if (nC()) {
            aO(this.P, false);
        } else {
            a(this.P, dBg(), false);
        }
    }

    public void m() {
        a(this.mOR, false);
    }

    private void a(final String str, String str2, boolean z) {
        this.J = true;
        VideoPlayInfo N = j.dAP().N(str + str2, KeepJobService.JOB_CHECK_PERIODIC);
        if (N != null) {
            a((ArrayList) N.mPlayUrls);
            this.J = false;
        } else if (z) {
            ParserRet fm = com.kascend.chushou.player.c.a.dBA().fm(str, str2);
            if (fm.mRc != 0) {
                tv.chushou.zues.utils.e.e(this.v, "getPlayUrlSync fail, try to getPlaylist");
                a(str, str2, false);
                return;
            }
            a(fm, str);
        } else {
            com.kascend.chushou.player.c.a.dBA().a(str, str2, new a.InterfaceC0687a() { // from class: com.kascend.chushou.player.VideoPlayer.9
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
        VideoPlayInfo O = j.dAP().O(str, KeepJobService.JOB_CHECK_PERIODIC);
        if (O != null) {
            a((ArrayList) O.mPlayUrls);
            this.J = false;
            return;
        }
        if (!h.isEmpty(this.mOR)) {
            try {
                equals = "1".equals(new JSONObject(this.mOR).optString("auto"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (!z) {
                ParserRet aP = com.kascend.chushou.player.c.a.dBA().aP(str, equals);
                if (aP.mRc != 0) {
                    tv.chushou.zues.utils.e.e(this.v, "getVideoPlayUrlSync fail, try to getVideoPlaylist");
                    aO(str, false);
                    return;
                }
                a(aP, str);
                return;
            }
            com.kascend.chushou.player.c.a.dBA().a(str, new a.InterfaceC0687a() { // from class: com.kascend.chushou.player.VideoPlayer.10
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
                if (this.mOD.f == null) {
                    this.mOD.f = new ArrayList<>();
                }
                this.mOD.f.clear();
                this.mOD.f.addAll(arrayList);
                if ("1".equals(this.R)) {
                    j.dAP().a(str + dBg(), arrayList);
                } else {
                    j.dAP().r(str, arrayList);
                }
                a(arrayList);
                return;
            }
            if (this.mOD != null) {
                this.mOD.f = null;
            }
            if (this.mPf != null) {
                Message Oe = this.mPf.Oe(5);
                Oe.arg1 = 2;
                Oe.arg2 = parserRet.mRc;
                this.mPf.O(Oe);
            }
        }
    }

    private void bO(String str, int i) {
        s();
        if (this.mOI != null) {
            this.mOI.a();
        }
        if (h.isEmpty(str)) {
            str = getString(a.i.str_load_data_failed);
        }
        a(str, i);
    }

    public void n() {
        if (this.mOL != null && this.aQb != null && this.mOM != null) {
            this.mOL.setVisibility(0);
            this.aQb.setVisibility(8);
            this.mOM.setVisibility(8);
        }
    }

    public void o() {
        if (this.mOS != null && this.mOS.getVisibility() == 0) {
            this.mOS.xi(0);
            this.mOS.setVisibility(8);
        }
    }

    public void p() {
        if (this.mOT != null && this.mOT.getVisibility() == 0) {
            this.mOT.setVisibility(8);
        }
    }

    public void q() {
        this.mPg = true;
    }

    protected void r() {
        this.mOL.setVisibility(8);
        this.mOM.setVisibility(0);
        this.aQb.setVisibility(0);
        if (this.mOH != null) {
            this.mOF.setVisibility(8);
            this.mOH.setVisibility(0);
            this.mOG.setText(getString(a.i.str_dialog_loading_content));
            this.mOG.setVisibility(8);
        }
    }

    protected void a(String str, int i) {
        this.mOL.setVisibility(8);
        this.mOM.setVisibility(0);
        this.aQb.setVisibility(0);
        if (this.mOH != null) {
            if (str == null) {
                str = getString(a.i.str_nodata);
            }
            if (str != null) {
                this.mOG.setText(str);
                if (str.equals(getString(a.i.s_no_available_network))) {
                    this.mOF.setImageResource(a.e.commonres_pagestatus_net_error);
                } else if (str.equals(getString(a.i.str_nodata)) || str.equals(getString(a.i.str_nohistory)) || str.equals(getString(a.i.str_nolive)) || str.equals(getString(a.i.str_nosubscribe))) {
                    this.mOF.setClickable(true);
                    this.mOF.setImageResource(a.e.commonres_pagestatus_empty);
                } else if (str.equals(getString(a.i.str_inbox_login_notify)) || str.equals(getString(a.i.push_login)) || str.equals(getString(a.i.str_login_timeout))) {
                    this.mOF.setImageResource(a.e.commonres_pagestatus_need_login);
                    this.mOF.setClickable(true);
                } else {
                    this.mOF.setImageResource(a.e.commonres_pagestatus_unknown_error);
                    this.mOF.setClickable(true);
                }
            }
            if (i == 4001) {
                this.mOF.setImageResource(a.e.commonres_pagestatus_net_error);
                this.mOF.setClickable(false);
                this.mOG.setVisibility(0);
                this.mOG.setText(getString(a.i.str_dissubscribe_btn));
                this.mOG.setOnClickListener(new View.OnClickListener() { // from class: com.kascend.chushou.player.VideoPlayer.11
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (!VideoPlayer.this.j) {
                            com.kascend.chushou.c.c.dAG().b(new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.VideoPlayer.11.1
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
                            }, VideoPlayer.this.P, (String) null, VideoPlayer.this.mOD.h);
                        }
                    }
                });
            } else if (i == 404) {
                this.mOG.setText(str);
                this.mOG.setVisibility(0);
                this.mOF.setClickable(false);
                this.mOF.setImageResource(a.e.commonres_pagestatus_empty);
            } else if (i == 4002) {
                if (h.isEmpty(str)) {
                    this.mOG.setVisibility(8);
                } else {
                    this.mOG.setVisibility(0);
                    this.mOG.setText(str);
                }
            } else {
                this.mOG.setVisibility(8);
            }
            this.mOF.setVisibility(0);
            this.mOH.setVisibility(8);
            this.mOT.setVisibility(8);
        }
    }

    public void s() {
        if (this.mPf != null) {
            this.mPf.removeMessages(1);
        }
    }

    private void a(ArrayList<PlayUrl> arrayList) {
        boolean z;
        if (this.mOD.f == null) {
            this.mOD.f = new ArrayList<>();
        }
        this.mOD.f.clear();
        this.mOD.f.addAll(arrayList);
        if (com.kascend.chushou.d.e.b() && !"4".equals(this.aq)) {
            int c = com.kascend.chushou.d.e.c();
            if (c == -1) {
                b(arrayList);
                return;
            } else if (c == 0) {
                this.mOD.d = false;
                f(arrayList, true);
                return;
            } else {
                if (this.mOD != null && this.mOD.f != null) {
                    Iterator<PlayUrl> it = this.mOD.f.iterator();
                    while (it.hasNext()) {
                        if ("2".equals(it.next().mType)) {
                            z = true;
                            break;
                        }
                    }
                }
                z = false;
                this.mOD.d = z;
                f(arrayList, true);
                return;
            }
        }
        if (this.mOD.e) {
            this.mOD.d = !this.mOD.d;
            this.mOD.e = false;
            this.mPh = true;
        } else {
            this.mOD.d = "4".equals(this.aq);
        }
        f(arrayList, true);
    }

    private void b(ArrayList<PlayUrl> arrayList) {
        if ("1".equals(this.R)) {
            if ("2".equals(this.mPa)) {
                d(false, arrayList);
            } else if (this.mOB != null) {
                this.mOB.f(arrayList, false);
            }
        } else if (this.mOB != null) {
            this.mOB.f(arrayList, false);
        }
    }

    public void b(boolean z) {
        this.mOD.d = false;
        com.kascend.chushou.d.e.a(0);
        ArrayList<PlayUrl> arrayList = this.mOD.f;
        if (!h.isEmpty(arrayList)) {
            if (z) {
                f(arrayList, false);
                if (this.mPf != null) {
                    this.mPf.Oc(2);
                    return;
                }
                return;
            }
            f(arrayList, true);
        }
    }

    public void c(boolean z) {
        this.mOD.d = true;
        com.kascend.chushou.d.e.a(1);
        ArrayList<PlayUrl> arrayList = this.mOD.f;
        if (!h.isEmpty(arrayList)) {
            if (z) {
                f(arrayList, false);
                if (this.mPf != null) {
                    this.mPf.Oc(2);
                    return;
                }
                return;
            }
            f(arrayList, true);
        }
    }

    @Subscribe
    public void onNotifyEvent(com.kascend.chushou.b.a.a.j jVar) {
        if (!isFinishing() && jVar.a == 1 && !"5".equals(this.R) && !dAR()) {
            tv.chushou.zues.utils.e.d(this.v, "onNetworkChangeEvent 3G=" + com.kascend.chushou.b.dAD().b + "  wifi=" + com.kascend.chushou.b.dAD().a);
            if (com.kascend.chushou.d.e.b() && !"4".equals(this.aq)) {
                if (com.kascend.chushou.d.e.c() == -1) {
                    if (this.mOB != null) {
                        this.mOB.e(false);
                    }
                    if ("1".equals(this.R)) {
                        if ("2".equals(this.mPa)) {
                            d(true, null);
                            return;
                        } else if (this.mOB != null) {
                            this.mOB.f(this.mOD.f, true);
                            return;
                        } else {
                            return;
                        }
                    } else if (this.mOB != null) {
                        this.mOB.f(this.mOD.f, true);
                        return;
                    } else {
                        return;
                    }
                }
                RxExecutor.postDelayed(this.mPc, EventThread.MAIN_THREAD, 10L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.VideoPlayer.12
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!VideoPlayer.this.isFinishing() && com.kascend.chushou.b.dAD().b && !com.kascend.chushou.b.dAD().a) {
                            tv.chushou.zues.utils.g.c(VideoPlayer.this.w, VideoPlayer.this.getString(a.i.str_monet_notify));
                        }
                    }
                });
            } else if (com.kascend.chushou.b.dAD().a || com.kascend.chushou.b.dAD().b) {
                t();
                if (this.mPf != null) {
                    this.mPf.Oc(2);
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
            if (this.mOD.d) {
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
            String d = com.kascend.chushou.d.h.dAK().d();
            String str3 = h.isEmpty(d) ? "2" : d;
            if (this.mOD.d) {
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
                if (this.mOD != null) {
                    this.mOD.a(playUrl2);
                    if (this.mPf != null) {
                        Message Oe = this.mPf.Oe(5);
                        Oe.arg1 = 1;
                        this.mPf.O(Oe);
                    }
                }
                String b = com.kascend.chushou.player.c.a.b(playUrl2);
                if (!h.isEmpty(b)) {
                    this.mOw = Uri.parse(b);
                    if (this.mPh) {
                        this.mPh = false;
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (z && this.mOx != null) {
                        a(false, z2);
                    }
                }
            }
        }
    }

    public void d(final boolean z, ArrayList<PlayUrl> arrayList) {
        if (this.mOO == null || this.mOO.a <= 0) {
            this.mOO = com.kascend.chushou.view.b.a.a.dDd();
            this.mOO.a(new a.InterfaceC0706a() { // from class: com.kascend.chushou.player.VideoPlayer.13
                @Override // com.kascend.chushou.view.b.a.a.InterfaceC0706a
                public void a(int i) {
                    if (i == a.f.tv_play_video) {
                        VideoPlayer.this.mOO.dismissAllowingStateLoss();
                        VideoPlayer.this.b(z);
                    } else if (i == a.f.tv_play_audio) {
                        VideoPlayer.this.mOO.dismissAllowingStateLoss();
                        VideoPlayer.this.c(z);
                    } else if (i == a.f.iv_close) {
                        VideoPlayer.this.finish();
                    } else {
                        if (i == a.f.tv_union_proxy) {
                        }
                    }
                }
            });
            this.mOO.show(getSupportFragmentManager(), "showRoom");
        }
    }

    public void t() {
        if (this.mOO != null) {
            this.mOO.dismissAllowingStateLoss();
        }
        if (this.mOB != null) {
            this.mOB.v();
        }
    }

    public void u() {
        com.kascend.chushou.c.c.dAG().c(this.P, new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.VideoPlayer.16
            @Override // com.kascend.chushou.c.b
            public void a() {
            }

            @Override // com.kascend.chushou.c.b
            public void a(String str, JSONObject jSONObject) {
                if (!VideoPlayer.this.isFinishing()) {
                    ParserRet dA = com.kascend.chushou.c.e.dA(jSONObject);
                    if (dA.mRc == 0 && dA.mData != null) {
                        CycleLiveRoomInfo cycleLiveRoomInfo = (CycleLiveRoomInfo) dA.mData;
                        if (VideoPlayer.this.mOD != null && cycleLiveRoomInfo != null && !h.isEmpty(cycleLiveRoomInfo.roomId)) {
                            FullRoomInfo dBu = VideoPlayer.this.mOD.dBu();
                            if (dBu.cycleLiveRoomInfo == null) {
                                dBu.cycleLiveRoomInfo = cycleLiveRoomInfo;
                                VideoPlayer.this.d();
                            } else if (dBu.cycleLiveRoomInfo != null && !cycleLiveRoomInfo.roomId.equals(dBu.cycleLiveRoomInfo.roomId)) {
                                dBu.cycleLiveRoomInfo.copyCycleLiveRoomInfo(cycleLiveRoomInfo);
                                VideoPlayer.this.d();
                            } else {
                                dBu.cycleLiveRoomInfo.copyCycleLiveRoomInfo(cycleLiveRoomInfo);
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
        if (this.mOB != null) {
            this.mOB.N();
        }
    }

    public void v() {
        com.kascend.chushou.c.c.dAG().a(this.P, new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.VideoPlayer.17
            @Override // com.kascend.chushou.c.b
            public void a() {
            }

            @Override // com.kascend.chushou.c.b
            public void a(String str, JSONObject jSONObject) {
                if (!VideoPlayer.this.isFinishing()) {
                    ParserRet dB = com.kascend.chushou.c.e.dB(jSONObject);
                    if (dB.mRc == 0 && dB.mData != null) {
                        PkNotifyInfo pkNotifyInfo = (PkNotifyInfo) dB.mData;
                        VideoPlayer.this.mOY.b = VideoPlayer.this.P;
                        if (pkNotifyInfo != null) {
                            VideoPlayer.this.mOY.mTK = pkNotifyInfo;
                            if (VideoPlayer.this.mOB != null) {
                                VideoPlayer.this.mOB.a(pkNotifyInfo, VideoPlayer.this.P);
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
        if (this.mOE != null) {
            this.mOE.release();
            this.mOE = null;
        }
        com.kascend.chushou.c.c.dAG().a(this.P, new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.VideoPlayer.18
            @Override // com.kascend.chushou.c.b
            public void a() {
            }

            @Override // com.kascend.chushou.c.b
            public void a(String str, JSONObject jSONObject) {
                if (!VideoPlayer.this.isFinishing()) {
                    ParserRet dC = com.kascend.chushou.c.e.dC(jSONObject);
                    if (dC.mRc == 0 && dC.mData != null) {
                        RoomExpandInfo roomExpandInfo = (RoomExpandInfo) dC.mData;
                        if (VideoPlayer.this.mOD != null) {
                            VideoPlayer.this.mOD.mQj = roomExpandInfo.mTopWebAdItem;
                            if (VideoPlayer.this.mOD.s == null) {
                                VideoPlayer.this.mOD.s = new ArrayList();
                            }
                            VideoPlayer.this.mOD.s.clear();
                            VideoPlayer.this.mOD.s.addAll(roomExpandInfo.mGiftTopRightIcons);
                            tv.chushou.zues.a.a.post(new i(50, VideoPlayer.this.mOD.mQj));
                        }
                        if (VideoPlayer.this.mOD != null) {
                            VideoPlayer.this.mOD.fr(roomExpandInfo.mExpandNavList);
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
                            VideoPlayer.this.mOU.a(list);
                        }
                        List<com.kascend.chushou.player.ui.h5.c.c> list2 = roomExpandInfo.mLuckList;
                        if (!h.isEmpty(list2)) {
                            VideoPlayer.this.mOV.a(list2);
                        }
                        com.kascend.chushou.player.ui.h5.c.c cVar = roomExpandInfo.mVoteItem;
                        if (cVar != null) {
                            VideoPlayer.this.mOW.a(cVar);
                        }
                        List<com.kascend.chushou.player.ui.h5.c.b> list3 = roomExpandInfo.mInteractH5Item;
                        if (!h.isEmpty(list3)) {
                            VideoPlayer.this.mOZ.a(list3);
                        }
                        List<com.kascend.chushou.player.ui.h5.c.b> list4 = roomExpandInfo.mInteractNavItem;
                        if (!h.isEmpty(list4)) {
                            VideoPlayer.this.mOZ.a(list4);
                        }
                        VideoPlayer.this.mOE = (PrivilegeInfo) dC.mData1;
                        if (VideoPlayer.this.mOE != null) {
                            tv.chushou.zues.a.a.post(new l());
                        }
                        if (VideoPlayer.this.mOD != null) {
                            VideoPlayer.this.mOD.mQp = roomExpandInfo.mIconConfig;
                            VideoPlayer.this.dBe().a(roomExpandInfo.mIconConfig.bangConfig);
                        }
                        List<SkinConfig> list5 = roomExpandInfo.skinConfig;
                        if (list5 != null && VideoPlayer.this.mOD != null) {
                            VideoPlayer.this.mOD.mQt.clear();
                            int i = 0;
                            while (true) {
                                int i2 = i;
                                if (i2 >= list5.size()) {
                                    break;
                                }
                                SkinConfig skinConfig = list5.get(i2);
                                VideoPlayer.this.mOD.mQt.put(skinConfig.position, skinConfig.resource);
                                i = i2 + 1;
                            }
                            VideoPlayer.this.C();
                        }
                        VideoPlayer.this.a(roomExpandInfo.mIconConfig, VideoPlayer.this.mOD != null ? VideoPlayer.this.mOD.mQt : null);
                        if (roomExpandInfo.mColorMap != null && roomExpandInfo.mColorMap.size() > 0 && com.kascend.chushou.b.dAD().c != null && com.kascend.chushou.b.dAD().c.size() <= 0) {
                            com.kascend.chushou.b.dAD().c.putAll(roomExpandInfo.mColorMap);
                            tv.chushou.zues.a.a.post(new i(52, null));
                        }
                        AutoBang autoBang = roomExpandInfo.mAutoBang;
                        if (autoBang != null && autoBang.currentTime != 0 && autoBang.bangTime != 0) {
                            VideoPlayer.this.dBe().a(autoBang);
                        }
                        if (!h.isEmpty(roomExpandInfo.mRelatedRoomList) && VideoPlayer.this.mOD != null) {
                            VideoPlayer.this.mOD.t = roomExpandInfo.mRelatedRoomList;
                            if (VideoPlayer.this.mOB != null && VideoPlayer.this.H) {
                                VideoPlayer.this.mOB.w();
                            }
                        }
                        if (roomExpandInfo.mRoomNewUserInfo != null && roomExpandInfo.mRoomNewUserInfo.mBarrierNoviceGuide && !com.kascend.chushou.d.h.dAK().k() && VideoPlayer.this.mOB != null) {
                            VideoPlayer.this.mOB.J();
                        }
                        if (roomExpandInfo.mRoomNewUserInfo != null && roomExpandInfo.mRoomNewUserInfo.mRewardNoviceGuide && !com.kascend.chushou.d.h.dAK().l() && VideoPlayer.this.mOB != null) {
                            VideoPlayer.this.mOB.K();
                        }
                        if (!h.isEmpty(roomExpandInfo.mShopWindowInfos)) {
                            if (VideoPlayer.this.mOD != null) {
                                if (VideoPlayer.this.mOD.mQq == null) {
                                    VideoPlayer.this.mOD.mQq = new ArrayList();
                                }
                                VideoPlayer.this.mOD.mQq.addAll(roomExpandInfo.mShopWindowInfos);
                            }
                            if (VideoPlayer.this.mOB != null) {
                                VideoPlayer.this.mOB.L();
                            }
                        }
                        VideoPlayer.this.mOY.b = VideoPlayer.this.P;
                        if (roomExpandInfo.mPkNotifyInfo != null) {
                            VideoPlayer.this.mOY.mTK = roomExpandInfo.mPkNotifyInfo;
                            if (VideoPlayer.this.mOB != null) {
                                VideoPlayer.this.mOB.a(roomExpandInfo.mPkNotifyInfo, VideoPlayer.this.P);
                            }
                        } else {
                            VideoPlayer.this.mOY.mTK = null;
                        }
                        if (roomExpandInfo.mTrumpetPocket != null && VideoPlayer.this.mOD != null) {
                            VideoPlayer.this.mOD.mQs = roomExpandInfo.mTrumpetPocket;
                            if (VideoPlayer.this.mOB != null) {
                                VideoPlayer.this.mOB.M();
                            }
                        }
                        if (!h.isEmpty(roomExpandInfo.hotwordContentList)) {
                            if (VideoPlayer.this.mOD != null) {
                                if (VideoPlayer.this.mOD.mQr == null) {
                                    VideoPlayer.this.mOD.mQr = new ArrayList();
                                }
                                VideoPlayer.this.mOD.mQr.clear();
                                VideoPlayer.this.mOD.mQr.addAll(roomExpandInfo.hotwordContentList);
                            }
                            if (VideoPlayer.this.mOB != null) {
                                VideoPlayer.this.mOB.b(roomExpandInfo.hotwordContentList);
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
        }, this.mOR, this.mPa);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U() {
        if (!h.isEmpty(com.kascend.chushou.a.a.dAE().z)) {
            StringBuilder sb = new StringBuilder();
            if (com.kascend.chushou.a.a.dAE().z.contains(com.kascend.chushou.a.a.f)) {
                if (sb.length() > 0) {
                    sb.append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                sb.append(com.kascend.chushou.a.a.f);
            }
            if (com.kascend.chushou.a.a.dAE().z.contains(com.kascend.chushou.a.a.g)) {
                if (sb.length() > 0) {
                    sb.append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                sb.append(com.kascend.chushou.a.a.g);
            }
            if (com.kascend.chushou.a.a.dAE().z.contains(com.kascend.chushou.a.a.i)) {
                if (sb.length() > 0) {
                    sb.append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                sb.append(com.kascend.chushou.a.a.i);
            }
            if (com.kascend.chushou.a.a.dAE().z.contains(com.kascend.chushou.a.a.h)) {
                if (sb.length() > 0) {
                    sb.append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                sb.append(com.kascend.chushou.a.a.h);
            }
            if (com.kascend.chushou.a.a.dAE().z.contains(com.kascend.chushou.a.a.j)) {
                if (sb.length() > 0) {
                    sb.append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                sb.append(com.kascend.chushou.a.a.j);
            }
            if (com.kascend.chushou.a.a.dAE().z.contains(com.kascend.chushou.a.a.l)) {
                if (sb.length() > 0) {
                    sb.append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                sb.append(com.kascend.chushou.a.a.l);
            }
            if (com.kascend.chushou.a.a.dAE().z.contains(com.kascend.chushou.a.a.m)) {
                if (sb.length() > 0) {
                    sb.append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                sb.append(com.kascend.chushou.a.a.m);
            }
            if (sb.length() != 0) {
                com.kascend.chushou.a.a.dAE().a(sb.toString(), this.P, new a.c() { // from class: com.kascend.chushou.player.VideoPlayer.19
                    @Override // com.kascend.chushou.a.a.c
                    public void a(List<ListItem> list) {
                        if (VideoPlayer.this.mOD != null && list != null) {
                            int i = 0;
                            while (true) {
                                int i2 = i;
                                if (i2 >= list.size()) {
                                    break;
                                }
                                if (list.get(i2).mAdExtraInfo != null) {
                                    if (com.kascend.chushou.a.a.f.equals(list.get(i2).mAdExtraInfo.mCode)) {
                                        VideoPlayer.this.mOD.mQi = list.get(i2);
                                    } else if (com.kascend.chushou.a.a.g.equals(list.get(i2).mAdExtraInfo.mCode)) {
                                        VideoPlayer.this.mOD.mQh = list.get(i2);
                                    } else if (com.kascend.chushou.a.a.i.equals(list.get(i2).mAdExtraInfo.mCode)) {
                                        VideoPlayer.this.mOD.mQk = list.get(i2);
                                    } else if (com.kascend.chushou.a.a.h.equals(list.get(i2).mAdExtraInfo.mCode)) {
                                        VideoPlayer.this.mOD.mQl = list.get(i2);
                                    } else if (com.kascend.chushou.a.a.j.equals(list.get(i2).mAdExtraInfo.mCode)) {
                                        VideoPlayer.this.mOD.mQo = list.get(i2);
                                    } else if (com.kascend.chushou.a.a.l.equals(list.get(i2).mAdExtraInfo.mCode)) {
                                        VideoPlayer.this.mOD.mQm = list.get(i2);
                                    } else if (com.kascend.chushou.a.a.m.equals(list.get(i2).mAdExtraInfo.mCode)) {
                                        VideoPlayer.this.mOD.mQn = list.get(i2);
                                    }
                                }
                                i = i2 + 1;
                            }
                            if (VideoPlayer.this.mOB != null) {
                                VideoPlayer.this.mOB.H();
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
        if (Build.VERSION.SDK_INT >= 11 && this.mOK != null) {
            if (!z) {
                if (Build.VERSION.SDK_INT >= 19) {
                    i = 5894;
                } else {
                    i = 1799;
                }
                this.mOK.setSystemUiVisibility(i);
                return;
            }
            this.mOK.setSystemUiVisibility(1792);
        }
    }

    public void e(boolean z) {
        int i;
        if (com.kascend.chushou.b.dAD().d != 1 && Build.VERSION.SDK_INT >= 11 && this.mOK != null) {
            if (!z) {
                if (Build.VERSION.SDK_INT >= 19) {
                    i = 5892;
                } else {
                    i = 1797;
                }
                this.mOK.setSystemUiVisibility(i);
                return;
            }
            this.mOK.setSystemUiVisibility(1792);
        }
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.mOB != null) {
            this.mOB.a(i, i2, intent);
        }
    }

    public Uri dAX() {
        return this.mOw;
    }

    @Override // com.kascend.chushou.view.base.BaseActivity
    protected int y() {
        return 0;
    }

    public void wd(boolean z) {
        if (this.mOK != null) {
            this.mOK.nYN = z;
        }
    }

    public void dAY() {
        if (this.mOK != null) {
            this.mOK.dAY();
        }
    }

    public boolean dAZ() {
        return this.ae;
    }

    public void f(boolean z) {
        this.ae = z;
    }

    public void g(boolean z) {
        if (this.mOK != null) {
            this.mOK.setIsTranslucentStatus(z);
        }
    }

    public void z() {
        if (this.mOK != null) {
            this.mOK.dPz();
        }
    }

    @Override // com.kascend.chushou.widget.gifts.RoomSendGiftView.a
    public void A() {
        if (this.mOI != null) {
            this.mOI.b();
        }
    }

    @Override // com.kascend.chushou.widget.gifts.RoomSendGiftView.a
    public void B() {
        if (this.mOI != null) {
            this.mOI.b();
        }
    }

    public void a(List<ListItem> list) {
        if (this.mOB != null) {
            this.mOB.a(list);
        }
    }

    public void a(IconConfig iconConfig, Map<String, SkinConfig.SkinRes> map) {
        if (this.mOB != null) {
            this.mOB.a(iconConfig, map);
        }
    }

    public void C() {
        if (this.mOB != null) {
            this.mOB.I();
        }
    }

    @Override // com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC0698a
    public void a(int i) {
        if (this.mOB != null) {
            this.mOB.a(i);
        }
    }

    @Override // com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC0698a
    public void D() {
        if (!isFinishing() && this.mOB != null) {
            this.mOB.D();
        }
    }

    @Override // com.kascend.chushou.player.ui.h5.b.b.a
    public void a(long j) {
        if (!isFinishing() && this.mOB != null) {
            this.mOB.a(j);
        }
    }

    @Override // com.kascend.chushou.player.ui.h5.b.b.a
    public void a(com.kascend.chushou.player.ui.h5.c.a aVar) {
        if (aVar != null && this.mOB != null) {
            this.mOB.a(aVar);
        }
    }

    @Override // com.kascend.chushou.player.ui.h5.b.b.a
    public void b(int i) {
        if (this.mOB != null) {
            this.mOB.b(i);
        }
    }

    @Override // com.kascend.chushou.player.ui.h5.d.a.InterfaceC0697a
    public void b(long j) {
        if (!isFinishing() && this.mOB != null) {
            this.mOB.b(j);
        }
    }

    @Override // com.kascend.chushou.player.ui.h5.a.a.InterfaceC0695a
    public void c(int i) {
        if (!isFinishing() && this.mOB != null) {
            this.mOB.c(i);
        }
    }

    @Override // com.kascend.chushou.player.ui.h5.d.a.InterfaceC0697a
    public void b(com.kascend.chushou.player.ui.h5.c.a aVar) {
        if (aVar != null && this.mOB != null) {
            this.mOB.b(aVar);
        }
    }

    @Override // com.kascend.chushou.player.ui.a.a.InterfaceC0692a
    public void a(IconConfig.Config config) {
        if (this.mOB != null) {
            this.mOB.a(config);
        }
    }

    @Override // com.kascend.chushou.player.ui.a.a.InterfaceC0692a
    public void a(BangInfo bangInfo, String str) {
        if (this.mOB != null) {
            this.mOB.a(bangInfo, str);
        }
    }

    @Override // com.kascend.chushou.player.ui.a.a.InterfaceC0692a
    public void a(long j, BangInfo bangInfo, String str) {
        if (this.mOB != null) {
            this.mOB.a(j, bangInfo, str);
        }
    }

    public com.kascend.chushou.player.ui.h5.redpacket.a dBa() {
        return this.mOU;
    }

    public com.kascend.chushou.player.ui.h5.b.b dBb() {
        return this.mOV;
    }

    public com.kascend.chushou.player.ui.h5.d.a dBc() {
        return this.mOW;
    }

    public com.kascend.chushou.player.ui.h5.a.a dBd() {
        return this.mOZ;
    }

    public com.kascend.chushou.player.ui.a.a dBe() {
        return this.mOX;
    }

    public com.kascend.chushou.player.e.a dBf() {
        return this.mOY;
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
        RxExecutor.postDelayed(this.mPc, EventThread.MAIN_THREAD, aVar.d, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.VideoPlayer.2
            @Override // java.lang.Runnable
            public void run() {
                if (VideoPlayer.this.mOB != null) {
                    VideoPlayer.this.mOB.c(aVar);
                }
            }
        });
    }

    private void e(final com.kascend.chushou.player.ui.h5.c.a aVar) {
        if (!com.kascend.chushou.d.h.dAK().dAN().contains(aVar.b)) {
            if (aVar.d < 0) {
                aVar.d = 0;
            }
            RxExecutor.postDelayed(this.mPc, EventThread.MAIN_THREAD, aVar.d, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.VideoPlayer.3
                @Override // java.lang.Runnable
                public void run() {
                    if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.mOB != null) {
                        VideoPlayer.this.mOB.c(aVar);
                    }
                }
            });
        }
    }

    private String dBg() {
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
                if (VideoPlayer.this.mOJ != null && !VideoPlayer.this.isFinishing()) {
                    VideoPlayer.n = VideoPlayer.this.mOJ.getStreamVolume(3);
                }
                if (!VideoPlayer.this.isFinishing() && (VideoPlayer.this.mOB instanceof f)) {
                    ((f) VideoPlayer.this.mOB).ab();
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

    public boolean dBh() {
        if (this.mOB instanceof com.kascend.chushou.player.d.a) {
            return ((com.kascend.chushou.player.d.a) this.mOB).dCn();
        }
        if (this.mOB instanceof com.kascend.chushou.player.e.e) {
            return true;
        }
        return false;
    }
}

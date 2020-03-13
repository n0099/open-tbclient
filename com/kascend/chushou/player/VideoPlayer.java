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
    public PrivilegeInfo mPA;
    com.kascend.chushou.widget.a.b mPE;
    private KPSwitchRootRelativeLayout mPG;
    private FrameLayout mPH;
    private LinearLayout mPI;
    private com.kascend.chushou.toolkit.d mPJ;
    com.kascend.chushou.view.b.a.a mPK;
    private String mPN;
    private FrescoThumbnailView mPO;
    private FrameLayout mPP;
    public com.kascend.chushou.player.feedback.a mPX;
    private a mPZ;
    private c mPw;
    b mPz;
    private CSTVWifiReceiver mQa;
    private boolean B = true;
    private boolean C = false;
    private Uri mPs = null;
    private tv.chushou.common.player.a mPt = null;
    public tv.chushou.common.player.a mPu = null;
    public tv.chushou.common.player.a mPv = null;
    public boolean d = false;
    public boolean e = false;
    private e mPx = null;
    private boolean H = false;
    private com.kascend.chushou.view.user.b mPy = null;
    private boolean J = false;
    private boolean K = false;
    private boolean L = false;
    private boolean M = false;
    private long N = 0;
    private int O = 0;
    public boolean g = false;
    private ImageView mPB = null;
    private TextView mPC = null;
    private AnimationImageView mPD = null;
    private View aUC = null;
    public boolean j = false;
    public float k = 0.0f;
    public float l = 0.0f;
    public boolean m = false;
    public AudioManager mPF = null;
    private d.a mPL = new d.a() { // from class: com.kascend.chushou.player.VideoPlayer.1
        @Override // com.kascend.chushou.toolkit.d.a
        public void a() {
            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.mQb != null) {
                VideoPlayer.this.mQb.Of(4);
            }
        }
    };
    private boolean ae = false;
    public boolean q = true;
    public long r = -1;
    public long s = -1;
    private PowerManager.WakeLock mPM = null;
    public String t = null;
    private final com.kascend.chushou.player.ui.h5.redpacket.a mPQ = new com.kascend.chushou.player.ui.h5.redpacket.a(this);
    private final com.kascend.chushou.player.ui.h5.b.b mPR = new com.kascend.chushou.player.ui.h5.b.b(this);
    private final com.kascend.chushou.player.ui.h5.d.a mPS = new com.kascend.chushou.player.ui.h5.d.a(this);
    private final com.kascend.chushou.player.ui.a.a mPT = new com.kascend.chushou.player.ui.a.a(this);
    private final com.kascend.chushou.player.e.a mPU = new com.kascend.chushou.player.e.a();
    private final com.kascend.chushou.player.ui.h5.a.a mPV = new com.kascend.chushou.player.ui.h5.a.a(this);
    private String mPW = "1";
    private String aq = "2";
    private io.reactivex.disposables.a mPY = new io.reactivex.disposables.a();
    private tv.chushou.zues.c mQb = new tv.chushou.zues.c(new Handler.Callback() { // from class: com.kascend.chushou.player.VideoPlayer.6
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            try {
                if (!VideoPlayer.this.isFinishing()) {
                    switch (message.what) {
                        case 1:
                            VideoPlayer.this.mQb.removeMessages(1);
                            com.kascend.chushou.c.c.dBR().a(VideoPlayer.this.P, VideoPlayer.this.mPz != null ? VideoPlayer.this.mPz.h : null, System.currentTimeMillis());
                            VideoPlayer.this.mQb.K(1, VideoPlayer.A);
                            break;
                        case 2:
                            VideoPlayer.this.a(true, (Uri) null, false);
                            break;
                        case 3:
                            VideoPlayer.this.cXv();
                            break;
                        case 4:
                            if (VideoPlayer.this.mPx != null) {
                                VideoPlayer.this.mPx.a(true);
                            }
                            if (VideoPlayer.this.mPJ != null) {
                                VideoPlayer.this.mPJ.d();
                                VideoPlayer.this.mPJ = null;
                                break;
                            }
                            break;
                        case 5:
                            int i = message.arg1;
                            if (i == 1) {
                                if (VideoPlayer.this.mPx != null) {
                                    VideoPlayer.this.mPx.p();
                                    break;
                                }
                            } else if (i == 2 && VideoPlayer.this.mPx != null) {
                                VideoPlayer.this.mPx.e(message.arg2);
                                break;
                            }
                            break;
                        case 6:
                            if (!com.kascend.chushou.b.dBO().a && !com.kascend.chushou.b.dBO().b && VideoPlayer.this.mPx != null) {
                                VideoPlayer.this.mPx.g(true);
                                break;
                            } else {
                                VideoPlayer.this.c();
                                break;
                            }
                            break;
                        case 7:
                            tv.chushou.zues.utils.e.d(VideoPlayer.this.v, "MSG_BUFFER_DEALY: ");
                            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.mPx != null && VideoPlayer.this.M && !VideoPlayer.this.e) {
                                VideoPlayer.this.mPx.h(true);
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
    private boolean mQc = false;
    private boolean mQd = true;
    private boolean mQe = false;
    private tv.chushou.common.player.b mQf = new tv.chushou.common.player.b() { // from class: com.kascend.chushou.player.VideoPlayer.14
        @Override // tv.chushou.common.player.b
        public void dCu() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerACallback onSetVideoViewLayout");
            if (!VideoPlayer.this.isFinishing()) {
                if ((VideoPlayer.this.mPx == null || !VideoPlayer.this.mPx.H) && VideoPlayer.this.mPx != null && !VideoPlayer.this.d) {
                    VideoPlayer.this.mPx.y();
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void MI(int i) {
            if (!VideoPlayer.this.isFinishing()) {
                if ((VideoPlayer.this.mPx == null || !VideoPlayer.this.mPx.H) && VideoPlayer.this.mPx != null && !VideoPlayer.this.d) {
                    VideoPlayer.this.mPx.g(i);
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void dCv() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerACallback onCompletePlayback");
            if (!VideoPlayer.this.isFinishing()) {
                if (!h.isEmpty(VideoPlayer.this.P)) {
                    j.dCa().a(VideoPlayer.this.P, 0);
                }
                VideoPlayer.this.K = false;
                if (VideoPlayer.this.mQb != null) {
                    VideoPlayer.this.mQb.removeMessages(1);
                }
                if ((VideoPlayer.this.mPx == null || !VideoPlayer.this.mPx.H) && VideoPlayer.this.mPx != null && !VideoPlayer.this.d) {
                    VideoPlayer.this.mQb.removeMessages(7);
                    VideoPlayer.this.M = false;
                    VideoPlayer.this.mPx.z();
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void dCw() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerACallback onVideoRenderingStart");
            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.mPx != null) {
                VideoPlayer.this.mPx.G();
            }
        }

        @Override // tv.chushou.common.player.b
        public void dCx() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerACallback onPreparedPlayback");
            if (!VideoPlayer.this.isFinishing()) {
                if (VideoPlayer.this.mPx == null || !VideoPlayer.this.mPx.H) {
                    VideoPlayer.this.mQb.removeMessages(6);
                    VideoPlayer.this.N = 0L;
                    VideoPlayer.this.O = 0;
                    if (VideoPlayer.this.mPt != null && VideoPlayer.this.mPx != null) {
                        VideoPlayer.this.mPt.setVolume(VideoPlayer.this.mPx.J, VideoPlayer.this.mPx.J);
                    }
                    if (VideoPlayer.this.mPz != null) {
                        VideoPlayer.this.K = false;
                        FullRoomInfo dCF = VideoPlayer.this.ol() ? null : VideoPlayer.this.mPz.dCF();
                        if (VideoPlayer.this.L || dCF != null) {
                            if (VideoPlayer.this.mPz.e) {
                                VideoPlayer.this.mPz.e = false;
                                VideoPlayer.this.mPz.d = !VideoPlayer.this.mPz.d;
                            }
                            if (VideoPlayer.this.mPx != null) {
                                VideoPlayer.this.c("1", (String) null);
                                if (!VideoPlayer.this.d) {
                                    VideoPlayer.this.mPx.i(true);
                                } else if (VideoPlayer.this.e) {
                                    VideoPlayer.this.e = false;
                                    VideoPlayer.this.mPx.B();
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
                if (VideoPlayer.this.mQb != null) {
                    VideoPlayer.this.mQb.removeMessages(7);
                }
                if (VideoPlayer.this.mQb != null) {
                    VideoPlayer.this.mQb.removeMessages(1);
                }
                if ((VideoPlayer.this.mPx == null || !VideoPlayer.this.mPx.H) && !VideoPlayer.this.dCc()) {
                    if (!"10004".equals(VideoPlayer.this.t)) {
                        if (VideoPlayer.this.mPx != null) {
                            if (VideoPlayer.this.d) {
                                VideoPlayer.this.mPu.stop();
                                VideoPlayer.this.mPu.release();
                                VideoPlayer.this.e = false;
                                VideoPlayer.this.mPx.C();
                            }
                            if (!com.kascend.chushou.b.dBO().a && !com.kascend.chushou.b.dBO().b) {
                                VideoPlayer.this.mPx.g(true);
                            } else if (VideoPlayer.this.d) {
                                VideoPlayer.this.mPx.a(i, true);
                            } else {
                                VideoPlayer.this.mPx.a(i, false);
                            }
                            VideoPlayer.this.c("2", (String) null);
                            return;
                        }
                        return;
                    }
                    dCv();
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void dCy() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerACallback onBufferingStart");
            if (!VideoPlayer.this.isFinishing()) {
                if ((VideoPlayer.this.mPx == null || !VideoPlayer.this.mPx.H) && VideoPlayer.this.mPx != null && !VideoPlayer.this.d) {
                    VideoPlayer.this.mPx.E();
                    VideoPlayer.this.M = true;
                    long currentTimeMillis = System.currentTimeMillis();
                    VideoPlayer.this.mQb.removeMessages(7);
                    if (!VideoPlayer.this.g) {
                        VideoPlayer.y(VideoPlayer.this);
                    }
                    tv.chushou.zues.utils.e.d(VideoPlayer.this.v, "currentTime: -- >" + currentTimeMillis + "  bufferTime-->" + VideoPlayer.this.N + "  bufferCount-->" + VideoPlayer.this.O);
                    if (currentTimeMillis - VideoPlayer.this.N >= 20000 || VideoPlayer.this.O < 2 || VideoPlayer.this.mPx.H) {
                        if (VideoPlayer.this.O == 1) {
                            VideoPlayer.this.N = currentTimeMillis;
                        }
                        VideoPlayer.this.mQb.K(7, 5000L);
                    } else {
                        VideoPlayer.this.mQb.Of(7);
                    }
                    if (VideoPlayer.this.g) {
                        VideoPlayer.this.g = false;
                    }
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void dCz() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerACallback onBufferingEnd");
            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.mPx != null && !VideoPlayer.this.d) {
                VideoPlayer.this.mQb.removeMessages(7);
                VideoPlayer.this.M = false;
                if (VideoPlayer.this.mPx == null || !VideoPlayer.this.mPx.H) {
                    if (VideoPlayer.this.mPt == null) {
                        VideoPlayer.this.mPx.a(false, true, false);
                    } else {
                        VideoPlayer.this.mPx.a(true, VideoPlayer.this.mPt.getPlayState() == 4, VideoPlayer.this.mPt.getPlayState() == 5);
                    }
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void dCA() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerACallback onPlayerStart");
            if (!VideoPlayer.this.isFinishing()) {
                if (VideoPlayer.this.mPx == null || !VideoPlayer.this.mPx.H) {
                    if (VideoPlayer.this.mPx != null && !VideoPlayer.this.d) {
                        if (VideoPlayer.this.mPt != null) {
                            VideoPlayer.this.mPx.F();
                            VideoPlayer.this.mPx.a(true, VideoPlayer.this.mPt.getPlayState() == 4, VideoPlayer.this.mPt.getPlayState() == 5);
                        } else {
                            VideoPlayer.this.mPx.a(false, true, false);
                        }
                    }
                    if (VideoPlayer.this.mQb != null && !VideoPlayer.this.ol()) {
                        VideoPlayer.this.mQb.removeMessages(1);
                        VideoPlayer.this.mQb.K(1, VideoPlayer.A);
                    }
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void dCB() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerACallback onPlayerPause");
            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.mQb != null) {
                VideoPlayer.this.mQb.removeMessages(1);
            }
        }

        @Override // tv.chushou.common.player.b
        public void dCC() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerACallback onPlayerStop");
            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.ol() && VideoPlayer.this.mPu != null && !h.isEmpty(VideoPlayer.this.P) && VideoPlayer.this.mPu.getCurrentPos() > 0) {
                j.dCa().a(VideoPlayer.this.P, VideoPlayer.this.mPu.getCurrentPos());
            }
        }
    };
    private tv.chushou.common.player.b mQg = new tv.chushou.common.player.b() { // from class: com.kascend.chushou.player.VideoPlayer.15
        @Override // tv.chushou.common.player.b
        public void dCu() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerBCallback onSetVideoViewLayout");
            if (!VideoPlayer.this.isFinishing()) {
                if ((VideoPlayer.this.mPx == null || !VideoPlayer.this.mPx.H) && VideoPlayer.this.mPx != null && VideoPlayer.this.d) {
                    VideoPlayer.this.mPx.y();
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void MI(int i) {
            if (!VideoPlayer.this.isFinishing()) {
                if ((VideoPlayer.this.mPx == null || !VideoPlayer.this.mPx.H) && VideoPlayer.this.mPx != null && VideoPlayer.this.d) {
                    VideoPlayer.this.mPx.g(i);
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void dCv() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerBCallback onCompletePlayback");
            if (!VideoPlayer.this.isFinishing()) {
                if (!h.isEmpty(VideoPlayer.this.P)) {
                    j.dCa().a(VideoPlayer.this.P, 0);
                }
                VideoPlayer.this.K = false;
                if (VideoPlayer.this.mQb != null) {
                    VideoPlayer.this.mQb.removeMessages(1);
                }
                if ((VideoPlayer.this.mPx == null || !VideoPlayer.this.mPx.H) && VideoPlayer.this.mPx != null && VideoPlayer.this.d) {
                    VideoPlayer.this.mQb.removeMessages(7);
                    VideoPlayer.this.M = false;
                    VideoPlayer.this.mPx.z();
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void dCw() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerBCallback onVideoRenderingStart");
            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.mPx != null) {
                VideoPlayer.this.mPx.G();
            }
        }

        @Override // tv.chushou.common.player.b
        public void dCx() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerBCallback onPreparedPlayback");
            if (!VideoPlayer.this.isFinishing()) {
                if (VideoPlayer.this.mPx == null || !VideoPlayer.this.mPx.H) {
                    VideoPlayer.this.mQb.removeMessages(6);
                    VideoPlayer.this.N = 0L;
                    VideoPlayer.this.O = 0;
                    if (VideoPlayer.this.mPt != null && VideoPlayer.this.mPx != null) {
                        VideoPlayer.this.mPt.setVolume(VideoPlayer.this.mPx.J, VideoPlayer.this.mPx.J);
                    }
                    if (VideoPlayer.this.mPz != null) {
                        VideoPlayer.this.K = false;
                        FullRoomInfo dCF = VideoPlayer.this.ol() ? null : VideoPlayer.this.mPz.dCF();
                        if (VideoPlayer.this.L || dCF != null) {
                            if (VideoPlayer.this.mPz.e) {
                                VideoPlayer.this.mPz.e = false;
                                VideoPlayer.this.mPz.d = !VideoPlayer.this.mPz.d;
                            }
                            if (VideoPlayer.this.mPx != null) {
                                VideoPlayer.this.c("1", (String) null);
                                if (VideoPlayer.this.d) {
                                    VideoPlayer.this.mPx.i(true);
                                } else if (VideoPlayer.this.e) {
                                    VideoPlayer.this.e = false;
                                    VideoPlayer.this.mPx.B();
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
                if (VideoPlayer.this.mQb != null) {
                    VideoPlayer.this.mQb.removeMessages(7);
                }
                if (VideoPlayer.this.mQb != null) {
                    VideoPlayer.this.mQb.removeMessages(1);
                }
                if ((VideoPlayer.this.mPx == null || !VideoPlayer.this.mPx.H) && !VideoPlayer.this.dCc()) {
                    if (!"10004".equals(VideoPlayer.this.t)) {
                        if (VideoPlayer.this.mPx != null) {
                            if (!VideoPlayer.this.d) {
                                VideoPlayer.this.mPv.stop();
                                VideoPlayer.this.mPv.release();
                                VideoPlayer.this.mPx.C();
                                VideoPlayer.this.e = false;
                            }
                            if (!com.kascend.chushou.b.dBO().a && !com.kascend.chushou.b.dBO().b) {
                                VideoPlayer.this.mPx.g(true);
                            } else if (VideoPlayer.this.d) {
                                VideoPlayer.this.mPx.a(i, false);
                            } else {
                                VideoPlayer.this.mPx.a(i, true);
                            }
                            VideoPlayer.this.c("2", (String) null);
                            return;
                        }
                        return;
                    }
                    dCv();
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void dCy() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerBCallback onBufferingStart");
            if (!VideoPlayer.this.isFinishing()) {
                if ((VideoPlayer.this.mPx == null || !VideoPlayer.this.mPx.H) && VideoPlayer.this.mPx != null && VideoPlayer.this.d) {
                    VideoPlayer.this.mPx.E();
                    VideoPlayer.this.M = true;
                    VideoPlayer.this.mQb.removeMessages(7);
                    long currentTimeMillis = System.currentTimeMillis();
                    if (!VideoPlayer.this.g) {
                        VideoPlayer.y(VideoPlayer.this);
                    }
                    tv.chushou.zues.utils.e.d(VideoPlayer.this.v, "currentTime: -- >" + currentTimeMillis + "  bufferTime-->" + VideoPlayer.this.N + "  bufferCount-->" + VideoPlayer.this.O);
                    if (currentTimeMillis - VideoPlayer.this.N >= 20000 || VideoPlayer.this.O < 2 || VideoPlayer.this.mPx.H) {
                        if (VideoPlayer.this.O == 1) {
                            VideoPlayer.this.N = currentTimeMillis;
                        }
                        VideoPlayer.this.mQb.K(7, 5000L);
                    } else {
                        VideoPlayer.this.N = 0L;
                        VideoPlayer.this.O = 0;
                        VideoPlayer.this.mQb.Of(7);
                    }
                    if (VideoPlayer.this.g) {
                        VideoPlayer.this.g = false;
                    }
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void dCz() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerBCallback onBufferingEnd");
            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.mPx != null && VideoPlayer.this.d) {
                VideoPlayer.this.M = false;
                VideoPlayer.this.mQb.removeMessages(7);
                if (VideoPlayer.this.mPx == null || !VideoPlayer.this.mPx.H) {
                    if (VideoPlayer.this.mPt == null) {
                        VideoPlayer.this.mPx.a(false, true, false);
                    } else {
                        VideoPlayer.this.mPx.a(true, VideoPlayer.this.mPt.getPlayState() == 4, VideoPlayer.this.mPt.getPlayState() == 5);
                    }
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void dCA() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerBCallback onPlayerStart");
            if (!VideoPlayer.this.isFinishing()) {
                if (VideoPlayer.this.mPx == null || !VideoPlayer.this.mPx.H) {
                    if (VideoPlayer.this.mPx != null && VideoPlayer.this.d) {
                        if (VideoPlayer.this.mPt != null) {
                            VideoPlayer.this.mPx.F();
                            VideoPlayer.this.mPx.a(true, VideoPlayer.this.mPt.getPlayState() == 4, VideoPlayer.this.mPt.getPlayState() == 5);
                        } else {
                            VideoPlayer.this.mPx.a(false, true, false);
                        }
                    }
                    if (VideoPlayer.this.mQb != null && !VideoPlayer.this.ol()) {
                        VideoPlayer.this.mQb.removeMessages(1);
                        VideoPlayer.this.mQb.K(1, VideoPlayer.A);
                    }
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void dCB() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerBCallback onPlayerPause");
            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.mQb != null) {
                VideoPlayer.this.mQb.removeMessages(1);
            }
        }

        @Override // tv.chushou.common.player.b
        public void dCC() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerBCallback onPlayerStop");
            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.ol() && VideoPlayer.this.mPv != null && !h.isEmpty(VideoPlayer.this.P) && VideoPlayer.this.mPv.getCurrentPos() > 0) {
                j.dCa().a(VideoPlayer.this.P, VideoPlayer.this.mPv.getCurrentPos());
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
        this.mPs = intent.getData();
        if (this.mPs == null) {
            finish();
            return;
        }
        com.kascend.chushou.d.e.j();
        if (this.mQa == null) {
            this.mQa = new CSTVWifiReceiver();
            registerReceiver(this.mQa, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        }
        com.kascend.chushou.toolkit.d.a.dEo().b();
        tv.chushou.zues.utils.e.i(this.v, "intent.getData=" + this.mPs.toString());
        String scheme = this.mPs.getScheme();
        if (scheme == null || !scheme.equals("chushou")) {
            tv.chushou.zues.utils.e.e(this.v, "not support scheme :" + scheme);
            finish();
            return;
        }
        a(intent);
    }

    private void a(Intent intent) {
        this.P = this.mPs.getQueryParameter("roomId");
        this.Q = this.P;
        this.S = this.mPs.getQueryParameter(WebSocketRequest.PARAM_KEY_PROTOCOLS);
        this.aq = this.mPs.getQueryParameter("liveType");
        if ("2".equals(this.aq) || "3".equals(this.aq) || "4".equals(this.aq)) {
            this.mPW = "2";
            this.mPX = new com.kascend.chushou.player.feedback.a();
            if (this.mPX.mYy != null) {
                this.mPX.mYy.reset();
                this.mPX.mYy.roomId = this.P;
                this.mPX.mYy.enterType = 1;
                this.mPX.b = System.currentTimeMillis();
            }
        }
        if (h.isEmpty(this.P) || h.isEmpty(this.S)) {
            tv.chushou.zues.utils.e.e(this.v, "invalid param mItemID=" + this.P + " protocols=" + this.S);
            finish();
            return;
        }
        if (com.kascend.chushou.b.dBO().d == -1) {
            com.kascend.chushou.b.dBO().d = com.kascend.chushou.d.g.b() ? 1 : 0;
        }
        this.mPM = ((PowerManager) getSystemService("power")).newWakeLock(536870938, this.v);
        this.mPM.acquire();
        this.mPz = new b(this.P);
        this.mPz.d = intent.getBooleanExtra("room_play_audio", false);
        this.mPE = new com.kascend.chushou.widget.a.b();
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
        this.mPG = (KPSwitchRootRelativeLayout) findViewById(a.f.rlRoot);
        if (!"2".equals(this.mPW) && com.kascend.chushou.b.dBO().d == 1) {
            this.mPG.setFitsSystemWindows(true);
        }
        this.mPH = (FrameLayout) this.mPG.findViewById(a.f.fl_fragment);
        this.aUC = this.mPG.findViewById(a.f.rl_empty);
        this.mPB = (ImageView) this.aUC.findViewById(a.f.iv_empty);
        this.mPC = (TextView) this.aUC.findViewById(a.f.tv_empty);
        this.mPI = (LinearLayout) this.mPG.findViewById(a.f.rl_title);
        this.Z = (ImageView) this.mPI.findViewById(a.f.back_icon);
        this.Z.setOnClickListener(new View.OnClickListener() { // from class: com.kascend.chushou.player.VideoPlayer.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayer.this.finish();
            }
        });
        this.mPD = (AnimationImageView) this.aUC.findViewById(a.f.iv_loading);
        this.mPO = (FrescoThumbnailView) this.mPG.findViewById(a.f.live_cover);
        this.mPP = (FrameLayout) this.mPG.findViewById(a.f.fl_cover);
        this.k = dCb();
        try {
            this.mPF = (AudioManager) getApplicationContext().getSystemService("audio");
            n = this.mPF.getStreamVolume(3);
            this.mPF.requestAudioFocus(null, 3, 1);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (this.B) {
            a(1, ol() ? "3" : "1");
        } else {
            r();
        }
        if (com.kascend.chushou.b.dBO().b && !com.kascend.chushou.b.dBO().a) {
            RxExecutor.postDelayed(this.mPY, EventThread.MAIN_THREAD, 60L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.VideoPlayer.5
                @Override // java.lang.Runnable
                public void run() {
                    if (!VideoPlayer.this.isFinishing() && com.kascend.chushou.b.dBO().b && !com.kascend.chushou.b.dBO().a) {
                        tv.chushou.zues.utils.g.c(VideoPlayer.this.w, VideoPlayer.this.getString(a.i.str_monet_notify));
                    }
                }
            });
        }
        com.kascend.chushou.c.c.dBR().a(this.P, stringExtra, System.currentTimeMillis());
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
        if (this.mPZ == null) {
            this.mPZ = new a();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.media.VOLUME_CHANGED_ACTION");
            registerReceiver(this.mPZ, intentFilter);
        }
    }

    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        if (this.mPZ != null) {
            unregisterReceiver(this.mPZ);
            this.mPZ = null;
        }
        super.onStop();
    }

    @Subscribe
    public void onHideGiftEffectEvent(com.kascend.chushou.b.a.a.f fVar) {
        if (fVar.b) {
            this.mPx.k();
            return;
        }
        this.mPx.m();
        this.mPx.l();
    }

    private float dCb() {
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
        this.mPN = str;
        R();
        try {
            if (h.isEmpty(str)) {
                jSONObject = new JSONObject();
            } else {
                jSONObject = new JSONObject(str);
            }
            jSONObject.put("_fbroomid", this.P);
            this.mPz.h = jSONObject.toString();
            String optString = jSONObject.optString("_thumb");
            jSONObject.optBoolean("tag_from_game_mic", false);
            if (!h.isEmpty(optString)) {
                this.ab = optString;
            }
        } catch (JSONException e) {
            e.printStackTrace();
            this.mPz.h = str;
        }
        if (ol()) {
            a(this.P, str);
            aO(this.P, z);
            return;
        }
        a = this.P;
        b(this.P, str);
        a(this.P, dCr(), z);
        w();
    }

    private void O() {
        this.m = true;
        j();
        if (this.mPx != null) {
            this.mPx.r();
        }
        s();
    }

    @Subscribe
    public void onStartRoomEvent(o oVar) {
        if (!isFinishing() && oVar.mOY != null && oVar.c != null && !h.isEmpty(oVar.mOY.mTargetKey)) {
            if (oVar.c != this) {
                tv.chushou.zues.utils.e.e(this.v, "different player!");
                return;
            }
            if (this.mPz != null) {
                this.mPz.a();
                this.mPz.a = oVar.mOY.mTargetKey;
                this.mPz.d = oVar.d;
                if (this.mPz.mQZ != null) {
                    this.mPz.mQZ.e();
                }
                if (this.mPz.mQZ != null) {
                    this.mPz.mQZ.b();
                }
                this.mPz.mRe = null;
                this.mPz.mRd = null;
                this.mPz.mRh = null;
                this.mPz.mRg = null;
                this.mPz.mRk = null;
                this.mPz.mRi = null;
                this.mPz.mRj = null;
            }
            if (this.mPF != null) {
                n = this.mPF.getStreamVolume(3);
            }
            if (!h.isEmpty(oVar.mOY.mType) && oVar.mOY.mType.equals("3")) {
                this.B = false;
                this.mPW = "1";
                r();
                this.P = oVar.mOY.mTargetKey;
                this.R = "3";
                if (this.mPE != null) {
                    this.mPE.a();
                }
                if (this.mPz != null) {
                    this.mPz.a((PlayUrl) null);
                    this.mPz.f();
                    if (this.mPz.c() != null) {
                        this.mPz.c().clear();
                    }
                    this.mPz.i.clear();
                }
                if (this.mPx != null) {
                    this.mPx.j();
                }
                s();
                if (this.mPJ != null) {
                    this.mPJ.d();
                    this.mPJ = null;
                }
                if (this.mPY != null) {
                    this.mPY.dispose();
                    this.mPY = new io.reactivex.disposables.a();
                }
                a(oVar.e, false);
                return;
            }
            boolean z = this.R != null && this.R.equals("1");
            this.R = "1";
            this.mPT.a();
            this.mPS.a();
            this.mPR.a();
            this.mPQ.c();
            this.mPV.a();
            if (this.mPY != null) {
                this.mPY.dispose();
                this.mPY = new io.reactivex.disposables.a();
            }
            if ("1".equals(oVar.f)) {
                this.H = false;
                if (this.mPz != null && !h.isEmpty(this.mPz.t)) {
                    this.mPz.t.clear();
                }
                this.ab = oVar.mOY.mCover;
                this.mPP.setVisibility(0);
                this.mPO.setBlur(true);
                this.mPO.i(oVar.mOY.mCover, 0, 0, 0);
            }
            if (!oVar.mOY.mTargetKey.equals(this.P)) {
                this.aq = oVar.g;
                if (!z) {
                    this.B = false;
                    r();
                } else if (!"2".equals(this.mPW) && ("2".equals(this.aq) || "3".equals(this.aq) || "4".equals(this.aq))) {
                    this.mPW = "2";
                    this.mPX = new com.kascend.chushou.player.feedback.a();
                    if (this.mPX.mYy != null) {
                        this.mPX.mYy.reset();
                        this.mPX.mYy.roomId = oVar.mOY.mTargetKey;
                        this.mPX.mYy.enterType = 1;
                        this.mPX.b = System.currentTimeMillis();
                    }
                }
                this.B = false;
                this.P = oVar.mOY.mTargetKey;
                this.Q = this.P;
                this.ab = oVar.mOY.mCover;
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
                JSONObject M = com.kascend.chushou.d.e.M("_fromView", str, "_sc", oVar.mOY.mSC);
                com.kascend.chushou.toolkit.a.c.a(this.w, M);
                if (this.mPE != null) {
                    this.mPE.a();
                    this.mPE.a(this.P);
                }
                if (this.mPz != null) {
                    this.mPz.a((PlayUrl) null);
                    this.mPz.f();
                    if (this.mPz.c() != null) {
                        this.mPz.c().clear();
                    }
                    this.mPz.i.clear();
                }
                if (this.mPx != null) {
                    this.mPx.j();
                }
                a(M.toString(), false);
                return;
            }
            tv.chushou.zues.utils.g.Om(a.i.str_same_room);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dCc() {
        FullRoomInfo dCF;
        String str;
        RoomInfo roomInfo;
        if (ol()) {
            str = null;
            dCF = null;
        } else {
            dCF = this.mPz.dCF();
            str = (dCF == null || (roomInfo = dCF.mRoominfo) == null) ? null : roomInfo.mGameId;
        }
        return !this.L && (dCF == null || h.isEmpty(str));
    }

    @Subscribe
    public void onMessageEvent(i iVar) {
        if (!isFinishing() && iVar.a != 21 && iVar.a != 22) {
            if (iVar.a == 0 && (iVar.b instanceof Boolean)) {
                if (((Boolean) iVar.b).booleanValue() && !isFinishing()) {
                    w();
                    if (this.mPx != null) {
                        this.mPx.f();
                    }
                }
            } else if (iVar.a == 46) {
                if ((iVar.b instanceof String) && this.mPx != null) {
                    this.mPx.c((String) iVar.b);
                }
            } else if (iVar.a == 54) {
                if (iVar.b instanceof String) {
                    this.mPR.a((String) iVar.b);
                }
            } else if (iVar.a == 55) {
                if (this.mPx != null) {
                    this.mPx.O();
                }
            } else if (iVar.a == 56 && this.mPx != null) {
                this.mPx.P();
            }
        }
    }

    @Subscribe
    public void onRefreshSubscribeEvent(m mVar) {
        if (isFinishing() && this.mPz != null && this.mPz.dCH() != null) {
            RoomInfo dCH = this.mPz.dCH();
            if (mVar.a(dCH.mCreatorUID, dCH.mRoomID)) {
                dCH.mIsSubscribed = mVar.c;
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
        if (this.m || this.mPu == null || this.mPv == null) {
            R();
        }
        if (this.mPE != null) {
            this.mPE.d();
        }
        if (!ol()) {
            if (this.mPJ != null && !this.mPJ.c()) {
                this.mPJ.a();
            }
            v();
            if (this.mPz != null && this.mPz.dCF() != null && this.mPz.dCF().cycleLiveRoomInfo != null && !h.isEmpty(this.mPz.dCF().cycleLiveRoomInfo.roomId)) {
                u();
            }
        }
        super.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.view.base.BaseActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        tv.chushou.zues.utils.e.e(this.v, MissionEvent.MESSAGE_DESTROY);
        if (this.mPz != null && this.mPz.dCF() != null && this.mPz.dCF().cycleLiveRoomInfo != null && !h.isEmpty(this.mPz.dCF().cycleLiveRoomInfo.eventName)) {
            j.dCa().a(this.P + dCr());
        }
        if ("2".equals(this.mPW) && this.mPX != null && this.mPX.mYy != null) {
            this.mPX.mYy.time = System.currentTimeMillis() - this.mPX.b;
            this.mPX.a();
            this.mPX.b();
        }
        this.mPQ.d();
        this.mPR.b();
        this.mPS.b();
        O();
        this.mPN = null;
        a = null;
        if (this.mQb != null) {
            this.mQb.cq(null);
            this.mQb = null;
        }
        if (this.mPJ != null) {
            this.mPJ.d();
            this.mPJ = null;
        }
        if (this.mPE != null) {
            this.mPE.c();
            this.mPE = null;
        }
        if (this.mPz != null) {
            this.mPz.mRe = null;
            this.mPz.mRd = null;
        }
        if (this.mPz != null) {
            this.mPz.b();
            this.mPz = null;
        }
        this.mPs = null;
        this.mPx = null;
        this.mPy = null;
        this.mPA = null;
        this.mPB = null;
        this.mPC = null;
        this.mPD = null;
        this.aUC = null;
        this.mPF = null;
        this.mPG = null;
        this.mPH = null;
        this.Z = null;
        this.mPI = null;
        if (this.mPM != null && this.mPM.isHeld()) {
            this.mPM.release();
            this.mPM = null;
        }
        if (this.mQa != null) {
            unregisterReceiver(this.mQa);
            this.mQa = null;
        }
        h.dQw();
        tv.chushou.zues.a.a.cr(this);
        this.mPY.dispose();
        this.mPS.b();
        this.mPT.b();
        this.mPQ.d();
        this.mPR.b();
        this.mPV.b();
        super.onDestroy();
        System.gc();
    }

    @Subscribe
    public void onSendGameGiftEvent(n nVar) {
        if (!isFinishing() && this.mPx != null) {
            this.mPx.a(nVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.view.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        tv.chushou.zues.utils.e.d(this.v, MissionEvent.MESSAGE_PAUSE);
        if (this.mPJ != null) {
            this.mPJ.b();
        }
        if (this.mPE != null) {
            this.mPE.b(false);
        }
        k();
        this.m = true;
        super.onPause();
    }

    @Override // android.app.Activity
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.mPx != null ? this.mPx.a(motionEvent) : super.onTouchEvent(motionEvent);
    }

    public void c() {
        if ("1".equals(this.R)) {
            j.dCa().a(this.P + dCr());
        } else {
            j.dCa().b(this.P);
        }
    }

    private void a(boolean z, boolean z2) {
        int i = 0;
        tv.chushou.zues.utils.e.i(this.v, "startLoadingVideo <------------- mbPrepareingVideo = " + this.K);
        if (this.mPu != null) {
            this.mPu.setHardwearDecod(com.kascend.chushou.d.h.dBV().a);
        }
        if (this.mPv != null) {
            this.mPv.setHardwearDecod(com.kascend.chushou.d.h.dBV().a);
        }
        if (this.mPt != null) {
            this.mPt.setHardwearDecod(com.kascend.chushou.d.h.dBV().a);
        }
        if (!this.K) {
            if (z && this.mPx != null) {
                if (!z2) {
                    this.t = null;
                    this.mPx.e();
                }
            } else if (this.mPx != null && !z2) {
                this.t = null;
                this.mPx.H = false;
                RxExecutor.post(null, EventThread.MAIN_THREAD, new Runnable() { // from class: com.kascend.chushou.player.VideoPlayer.7
                    @Override // java.lang.Runnable
                    public void run() {
                        VideoPlayer.this.mPx.x();
                    }
                });
            }
            this.K = true;
            if (this.mPz != null && this.mPz.dCG() != null) {
                PlayUrl dCG = this.mPz.dCG();
                while (true) {
                    int i2 = i;
                    if (i2 >= dCG.mUrlDetails.size()) {
                        break;
                    }
                    UrlDetails urlDetails = dCG.mUrlDetails.get(i2);
                    if (urlDetails.mUrl.equals(dCG.mSelectedUrl)) {
                        String str = dCG.mUrlDetails.get(i2).mDefinitionType;
                        String str2 = urlDetails.mBitrate;
                    }
                    i = i2 + 1;
                }
            }
            if (z2) {
                if (this.d) {
                    this.mPu.setVideoURI(this.mPs);
                    this.mPu.open();
                    return;
                }
                this.mPv.setVideoURI(this.mPs);
                this.mPv.open();
                return;
            }
            this.mPt.setVideoURI(this.mPs);
            this.mPt.open();
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        try {
            if (motionEvent.getAction() == 0) {
                if (this.mPx != null && this.mPx.b(motionEvent)) {
                    return true;
                }
                if ("2".equals(this.mPW) && this.mPx != null) {
                    this.mPx.a(motionEvent);
                }
            } else if (this.mPx != null && this.mPx.b(motionEvent)) {
                return true;
            }
            return super.dispatchTouchEvent(motionEvent);
        } catch (Exception e) {
            return false;
        }
    }

    @Override // android.support.v7.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.mPx != null && this.mPx.a(i, keyEvent)) {
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
        if (this.mPz != null && this.mPz.dCF() != null && this.mPz.dCF().cycleLiveRoomInfo != null && !h.isEmpty(this.mPz.dCF().cycleLiveRoomInfo.roomId)) {
            this.mPP.setVisibility(0);
            this.mPO.setBlur(true);
            this.mPO.i(this.mPz.dCF().cycleLiveRoomInfo.avatar, 0, 0, 0);
            this.mPO.setVisibility(0);
            j.dCa().a(this.P + dCr());
            this.mPs = null;
            R();
            this.Q = this.mPz.dCF().cycleLiveRoomInfo.roomId;
            a(this.P, dCr(), false);
        }
    }

    public void a(boolean z) {
        if (this.mPx != null) {
            this.mPx.j(z);
        }
    }

    public void a(boolean z, Uri uri, boolean z2) {
        tv.chushou.zues.utils.e.d(this.v, "loadIfNecessary reload=" + z + " isChangeLines-->" + z2);
        if (this.mPu != null && this.mPv != null) {
            if (uri != null) {
                this.mPs = uri;
            }
            if (z2) {
                this.e = z2;
            }
            this.M = false;
            this.N = 0L;
            this.O = 0;
            this.mQb.removeMessages(7);
            if (z) {
                if (z2) {
                    if (!this.d) {
                        this.mPv.setOnActivityCallBack(this.mQg);
                    } else {
                        this.mPu.setOnActivityCallBack(this.mQf);
                    }
                } else if (this.d) {
                    this.mPv.setOnActivityCallBack(this.mQg);
                } else {
                    this.mPu.setOnActivityCallBack(this.mQf);
                }
                this.K = false;
                b(true, z2);
            } else if (!this.J) {
                b(true, z2);
            }
            this.mQb.K(6, 3000L);
        }
    }

    private void b(boolean z, boolean z2) {
        VideoPlayInfo O;
        if ("1".equals(this.R)) {
            O = j.dCa().N(this.P + dCr(), KeepJobService.JOB_CHECK_PERIODIC);
        } else {
            O = j.dCa().O(this.P, KeepJobService.JOB_CHECK_PERIODIC);
        }
        if (O != null) {
            a(z, z2);
        } else if ("1".equals(this.R)) {
            a(this.P, dCr(), false);
        } else {
            aO(this.P, false);
        }
    }

    public tv.chushou.common.player.a dCd() {
        return this.mPt;
    }

    public tv.chushou.common.player.a dCe() {
        return this.mPu;
    }

    public tv.chushou.common.player.a dCf() {
        return this.mPv;
    }

    public void a(tv.chushou.common.player.a aVar) {
        this.mPt = aVar;
    }

    public b dCg() {
        return this.mPz;
    }

    public com.kascend.chushou.widget.a.b dCh() {
        return this.mPE;
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
        FullRoomInfo dCF;
        this.r = -1L;
        if (this.s != -1 && this.s != 0) {
            this.r = this.s;
            this.s = -1L;
        }
        if (ol() && this.mPt != null && this.mPt.getPlayState() == 4) {
            this.r = this.mPt.getCurrentPos();
        }
        this.mQc = false;
        tv.chushou.zues.utils.e.d(this.v, "screenChange()<-----");
        tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard(this);
        if (str != null) {
            this.R = str;
        }
        if (!this.C || !z3 || "3".equals(this.R) || this.mPz == null || (dCF = this.mPz.dCF()) == null || dCF.mRoominfo == null || dCF.mRoominfo.mStyle != 1) {
            z5 = false;
        } else {
            z5 = true;
            i = 0;
        }
        if ("2".equals(this.mPW)) {
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
            if (com.kascend.chushou.b.dBO().d == 1) {
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
        if (this.mPE == null) {
            this.mPE = new com.kascend.chushou.widget.a.b();
        }
        if (this.mPE != null) {
            this.mPE.a(this.P);
        }
        if (this.R.equals("5")) {
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            if (this.mPx != null) {
                beginTransaction.remove(this.mPx);
                this.mPx = null;
            }
            if (this.mPy != null) {
                beginTransaction.remove(this.mPy);
                this.mPy = null;
            }
            this.mPy = new com.kascend.chushou.view.user.b();
            beginTransaction.add(a.f.fl_fragment, this.mPy);
            beginTransaction.commitAllowingStateLoss();
        } else {
            FragmentTransaction beginTransaction2 = getSupportFragmentManager().beginTransaction();
            if (this.mPx != null) {
                beginTransaction2.remove(this.mPx);
                this.mPx = null;
            }
            if (this.mPy != null) {
                beginTransaction2.remove(this.mPy);
                this.mPy = null;
            }
            if ("2".equals(this.mPW)) {
                this.mPx = com.kascend.chushou.player.e.e.a(this.ab, z2, this.aq, this.P);
            } else if (1 == i) {
                if (!this.R.equals("3")) {
                    if (z4) {
                        v();
                    }
                    this.mPx = new com.kascend.chushou.player.d.a();
                    Bundle bundle = new Bundle();
                    bundle.putString("mCover", this.ab);
                    bundle.putBoolean("mInitViewAsync", z2);
                    this.mPx.setArguments(bundle);
                }
            } else {
                this.mPx = new com.kascend.chushou.player.d.b();
                Bundle bundle2 = new Bundle();
                if (z5) {
                    i = 1;
                }
                bundle2.putInt("mExtraOrientation", i);
                bundle2.putString("mViewType", this.R);
                this.mPx.setArguments(bundle2);
            }
            beginTransaction2.add(a.f.fl_fragment, this.mPx);
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
        if (this.mPx != null) {
            this.mPx.mUF = null;
        }
        if (this.mPt != null) {
            this.mPt.release();
            this.mPt = null;
            this.K = false;
        }
        if (this.mPu != null) {
            this.mPu.release();
            this.mPu = null;
        }
        if (this.mPv != null) {
            this.mPv.release();
            this.mPv = null;
        }
        if (this.mPw != null) {
            this.mPw.c();
        }
        this.d = false;
        this.e = false;
        this.M = false;
        this.mPw = new c();
        this.mPu = this.mPw.dCJ();
        this.mPu.setOnActivityCallBack(this.mQf);
        this.mPv = this.mPw.dCK();
        this.mPv.setOnActivityCallBack(this.mQg);
        if (!this.d) {
            this.mPt = this.mPu;
        } else {
            this.mPt = this.mPv;
        }
        if (this.mPx != null) {
            this.mPx.mUF = this.mPt;
        }
    }

    public void j() {
        if (this.mPt != null) {
            this.mPt.pause();
            this.mPt.stop();
            this.mPt.release();
            this.mPt = null;
        }
        if (this.mPu != null) {
            this.mPu.stop();
            this.mPu.release();
            this.mPu = null;
        }
        if (this.mPv != null) {
            this.mPv.stop();
            this.mPv.release();
            this.mPv = null;
        }
        if (this.mPw != null) {
            this.mPw.c();
        }
    }

    public void k() {
        tv.chushou.common.player.a aVar = this.mPt;
        if (aVar != null) {
            aVar.pause();
            aVar.stop();
        }
        tv.chushou.common.player.a aVar2 = this.mPu;
        if (aVar2 != null) {
            aVar2.stop();
        }
        tv.chushou.common.player.a aVar3 = this.mPv;
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
    public void cXv() {
        if (this.mQc) {
            if (this.mPx != null) {
                this.mPx.s();
            }
        } else if (this.mQb != null) {
            this.mQb.a(this.mQb.Oh(3), 20L);
        }
    }

    private void b(final String str, String str2) {
        com.kascend.chushou.c.c.dBR().a(new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.VideoPlayer.8
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
                    VideoPlayer.this.dCp().a(fullRoomInfo.mBangMap);
                    if (h.isEmpty(fullRoomInfo.mRoominfo.mRoomID)) {
                        fullRoomInfo.mRoominfo.mRoomID = VideoPlayer.this.P;
                    }
                    if (!h.isEmpty(fullRoomInfo.mGeneralTabGifts)) {
                        com.kascend.chushou.d.e.a(VideoPlayer.this.mPY, new ArrayList(fullRoomInfo.mGeneralTabGifts));
                    }
                    if (VideoPlayer.this.mPz != null) {
                        VideoPlayer.this.mPz.a(fullRoomInfo);
                    }
                    VideoPlayer.this.L = false;
                    if (VideoPlayer.this.B) {
                        if (VideoPlayer.this.C && !"3".equals(VideoPlayer.this.R) && fullRoomInfo != null && fullRoomInfo.mRoominfo != null && fullRoomInfo.mRoominfo.mStyle == 1 && !h.isEmpty(fullRoomInfo.mRoominfo.mGameId)) {
                            z = true;
                        }
                        if (!z) {
                            if (VideoPlayer.this.mPx != null) {
                                VideoPlayer.this.mPx.a(VideoPlayer.this.mPz);
                            }
                            if (!h.isEmpty(fullRoomInfo.mRoominfo.mGameId)) {
                                VideoPlayer.this.cXv();
                            } else {
                                if (VideoPlayer.this.mPz != null) {
                                    VideoPlayer.this.mPz.f = null;
                                }
                                VideoPlayer.this.cXv();
                            }
                        } else {
                            VideoPlayer.this.a(1, "1", true);
                            if (VideoPlayer.this.mPx != null) {
                                VideoPlayer.this.mPx.a(VideoPlayer.this.mPz);
                            }
                        }
                    } else {
                        if (h.isEmpty(fullRoomInfo.mRoominfo.mGameId)) {
                            if (VideoPlayer.this.mPz != null) {
                                VideoPlayer.this.mPz.f = null;
                            }
                            VideoPlayer.this.a(1, "1");
                        } else {
                            VideoPlayer.this.a(1, "1", true);
                        }
                        if (VideoPlayer.this.mPx != null) {
                            VideoPlayer.this.mPx.a(VideoPlayer.this.mPz);
                        }
                    }
                    if (VideoPlayer.this.mPz != null && !VideoPlayer.this.mPz.m()) {
                        if (VideoPlayer.this.mPJ != null) {
                            VideoPlayer.this.mPJ.d();
                            VideoPlayer.this.mPJ = null;
                        }
                        VideoPlayer.this.mPJ = new com.kascend.chushou.toolkit.d(900000L, VideoPlayer.this.mPL, VideoPlayer.this.mQb);
                        VideoPlayer.this.mPJ.a();
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
        if (this.mPz != null) {
            this.mPz.a((FullRoomInfo) null);
        }
        this.L = false;
        bN(str, i);
        if (this.mPt != null) {
            this.mPt.stop();
        }
        if (this.mPu != null) {
            this.mPu.stop();
        }
        if (this.mPv != null) {
            this.mPv.stop();
        }
    }

    public void l() {
        tv.chushou.zues.utils.e.d(this.v, "retryGetPlayList");
        c();
        if (ol()) {
            aO(this.P, false);
        } else {
            a(this.P, dCr(), false);
        }
    }

    public void m() {
        a(this.mPN, false);
    }

    private void a(final String str, String str2, boolean z) {
        this.J = true;
        VideoPlayInfo N = j.dCa().N(str + str2, KeepJobService.JOB_CHECK_PERIODIC);
        if (N != null) {
            a((ArrayList) N.mPlayUrls);
            this.J = false;
        } else if (z) {
            ParserRet fu = com.kascend.chushou.player.c.a.dCL().fu(str, str2);
            if (fu.mRc != 0) {
                tv.chushou.zues.utils.e.e(this.v, "getPlayUrlSync fail, try to getPlaylist");
                a(str, str2, false);
                return;
            }
            a(fu, str);
        } else {
            com.kascend.chushou.player.c.a.dCL().a(str, str2, new a.InterfaceC0695a() { // from class: com.kascend.chushou.player.VideoPlayer.9
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
        VideoPlayInfo O = j.dCa().O(str, KeepJobService.JOB_CHECK_PERIODIC);
        if (O != null) {
            a((ArrayList) O.mPlayUrls);
            this.J = false;
            return;
        }
        if (!h.isEmpty(this.mPN)) {
            try {
                equals = "1".equals(new JSONObject(this.mPN).optString("auto"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (!z) {
                ParserRet aP = com.kascend.chushou.player.c.a.dCL().aP(str, equals);
                if (aP.mRc != 0) {
                    tv.chushou.zues.utils.e.e(this.v, "getVideoPlayUrlSync fail, try to getVideoPlaylist");
                    aO(str, false);
                    return;
                }
                a(aP, str);
                return;
            }
            com.kascend.chushou.player.c.a.dCL().a(str, new a.InterfaceC0695a() { // from class: com.kascend.chushou.player.VideoPlayer.10
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
                if (this.mPz.f == null) {
                    this.mPz.f = new ArrayList<>();
                }
                this.mPz.f.clear();
                this.mPz.f.addAll(arrayList);
                if ("1".equals(this.R)) {
                    j.dCa().a(str + dCr(), arrayList);
                } else {
                    j.dCa().s(str, arrayList);
                }
                a(arrayList);
                return;
            }
            if (this.mPz != null) {
                this.mPz.f = null;
            }
            if (this.mQb != null) {
                Message Oh = this.mQb.Oh(5);
                Oh.arg1 = 2;
                Oh.arg2 = parserRet.mRc;
                this.mQb.O(Oh);
            }
        }
    }

    private void bN(String str, int i) {
        s();
        if (this.mPE != null) {
            this.mPE.a();
        }
        if (h.isEmpty(str)) {
            str = getString(a.i.str_load_data_failed);
        }
        a(str, i);
    }

    public void n() {
        if (this.mPH != null && this.aUC != null && this.mPI != null) {
            this.mPH.setVisibility(0);
            this.aUC.setVisibility(8);
            this.mPI.setVisibility(8);
        }
    }

    public void o() {
        if (this.mPO != null && this.mPO.getVisibility() == 0) {
            this.mPO.xo(0);
            this.mPO.setVisibility(8);
        }
    }

    public void p() {
        if (this.mPP != null && this.mPP.getVisibility() == 0) {
            this.mPP.setVisibility(8);
        }
    }

    public void q() {
        this.mQc = true;
    }

    protected void r() {
        this.mPH.setVisibility(8);
        this.mPI.setVisibility(0);
        this.aUC.setVisibility(0);
        if (this.mPD != null) {
            this.mPB.setVisibility(8);
            this.mPD.setVisibility(0);
            this.mPC.setText(getString(a.i.str_dialog_loading_content));
            this.mPC.setVisibility(8);
        }
    }

    protected void a(String str, int i) {
        this.mPH.setVisibility(8);
        this.mPI.setVisibility(0);
        this.aUC.setVisibility(0);
        if (this.mPD != null) {
            if (str == null) {
                str = getString(a.i.str_nodata);
            }
            if (str != null) {
                this.mPC.setText(str);
                if (str.equals(getString(a.i.s_no_available_network))) {
                    this.mPB.setImageResource(a.e.commonres_pagestatus_net_error);
                } else if (str.equals(getString(a.i.str_nodata)) || str.equals(getString(a.i.str_nohistory)) || str.equals(getString(a.i.str_nolive)) || str.equals(getString(a.i.str_nosubscribe))) {
                    this.mPB.setClickable(true);
                    this.mPB.setImageResource(a.e.commonres_pagestatus_empty);
                } else if (str.equals(getString(a.i.str_inbox_login_notify)) || str.equals(getString(a.i.push_login)) || str.equals(getString(a.i.str_login_timeout))) {
                    this.mPB.setImageResource(a.e.commonres_pagestatus_need_login);
                    this.mPB.setClickable(true);
                } else {
                    this.mPB.setImageResource(a.e.commonres_pagestatus_unknown_error);
                    this.mPB.setClickable(true);
                }
            }
            if (i == 4001) {
                this.mPB.setImageResource(a.e.commonres_pagestatus_net_error);
                this.mPB.setClickable(false);
                this.mPC.setVisibility(0);
                this.mPC.setText(getString(a.i.str_dissubscribe_btn));
                this.mPC.setOnClickListener(new View.OnClickListener() { // from class: com.kascend.chushou.player.VideoPlayer.11
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (!VideoPlayer.this.j) {
                            com.kascend.chushou.c.c.dBR().b(new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.VideoPlayer.11.1
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
                            }, VideoPlayer.this.P, (String) null, VideoPlayer.this.mPz.h);
                        }
                    }
                });
            } else if (i == 404) {
                this.mPC.setText(str);
                this.mPC.setVisibility(0);
                this.mPB.setClickable(false);
                this.mPB.setImageResource(a.e.commonres_pagestatus_empty);
            } else if (i == 4002) {
                if (h.isEmpty(str)) {
                    this.mPC.setVisibility(8);
                } else {
                    this.mPC.setVisibility(0);
                    this.mPC.setText(str);
                }
            } else {
                this.mPC.setVisibility(8);
            }
            this.mPB.setVisibility(0);
            this.mPD.setVisibility(8);
            this.mPP.setVisibility(8);
        }
    }

    public void s() {
        if (this.mQb != null) {
            this.mQb.removeMessages(1);
        }
    }

    private void a(ArrayList<PlayUrl> arrayList) {
        boolean z;
        if (this.mPz.f == null) {
            this.mPz.f = new ArrayList<>();
        }
        this.mPz.f.clear();
        this.mPz.f.addAll(arrayList);
        if (com.kascend.chushou.d.e.b() && !"4".equals(this.aq)) {
            int c = com.kascend.chushou.d.e.c();
            if (c == -1) {
                b(arrayList);
                return;
            } else if (this.mQd) {
                this.mQd = false;
                if (c == 0) {
                    this.mPz.d = false;
                    f(arrayList, true);
                    return;
                }
                if (this.mPz != null && this.mPz.f != null) {
                    Iterator<PlayUrl> it = this.mPz.f.iterator();
                    while (it.hasNext()) {
                        if ("2".equals(it.next().mType)) {
                            z = true;
                            break;
                        }
                    }
                }
                z = false;
                this.mPz.d = z;
                f(arrayList, true);
                return;
            } else {
                if (this.mPz.e) {
                    this.mPz.d = !this.mPz.d;
                    this.mPz.e = false;
                    this.mQe = true;
                } else if ("4".equals(this.aq)) {
                    this.mPz.d = true;
                }
                f(arrayList, true);
                return;
            }
        }
        if (this.mPz.e) {
            this.mPz.d = !this.mPz.d;
            this.mPz.e = false;
            this.mQe = true;
        } else if ("4".equals(this.aq)) {
            this.mPz.d = true;
        }
        f(arrayList, true);
    }

    private void b(ArrayList<PlayUrl> arrayList) {
        if ("1".equals(this.R)) {
            if ("2".equals(this.mPW)) {
                d(false, arrayList);
            } else if (this.mPx != null) {
                this.mPx.f(arrayList, false);
            }
        } else if (this.mPx != null) {
            this.mPx.f(arrayList, false);
        }
    }

    public void b(boolean z) {
        this.mPz.d = false;
        com.kascend.chushou.d.e.a(0);
        ArrayList<PlayUrl> arrayList = this.mPz.f;
        if (!h.isEmpty(arrayList)) {
            if (z) {
                f(arrayList, false);
                if (this.mQb != null) {
                    this.mQb.Of(2);
                    return;
                }
                return;
            }
            f(arrayList, true);
        }
    }

    public void c(boolean z) {
        this.mPz.d = true;
        com.kascend.chushou.d.e.a(1);
        ArrayList<PlayUrl> arrayList = this.mPz.f;
        if (!h.isEmpty(arrayList)) {
            if (z) {
                f(arrayList, false);
                if (this.mQb != null) {
                    this.mQb.Of(2);
                    return;
                }
                return;
            }
            f(arrayList, true);
        }
    }

    @Subscribe
    public void onNotifyEvent(com.kascend.chushou.b.a.a.j jVar) {
        if (!isFinishing() && jVar.a == 1 && !"5".equals(this.R) && !dCc()) {
            tv.chushou.zues.utils.e.d(this.v, "onNetworkChangeEvent 3G=" + com.kascend.chushou.b.dBO().b + "  wifi=" + com.kascend.chushou.b.dBO().a);
            if (com.kascend.chushou.d.e.b() && !"4".equals(this.aq)) {
                if (com.kascend.chushou.d.e.c() == -1) {
                    if (this.mPx != null) {
                        this.mPx.e(false);
                    }
                    if ("1".equals(this.R)) {
                        if ("2".equals(this.mPW)) {
                            d(true, null);
                            return;
                        } else if (this.mPx != null) {
                            this.mPx.f(this.mPz.f, true);
                            return;
                        } else {
                            return;
                        }
                    } else if (this.mPx != null) {
                        this.mPx.f(this.mPz.f, true);
                        return;
                    } else {
                        return;
                    }
                }
                RxExecutor.postDelayed(this.mPY, EventThread.MAIN_THREAD, 10L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.VideoPlayer.12
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!VideoPlayer.this.isFinishing() && com.kascend.chushou.b.dBO().b && !com.kascend.chushou.b.dBO().a) {
                            tv.chushou.zues.utils.g.c(VideoPlayer.this.w, VideoPlayer.this.getString(a.i.str_monet_notify));
                        }
                    }
                });
            } else if (com.kascend.chushou.b.dBO().a || com.kascend.chushou.b.dBO().b) {
                t();
                if (this.mQb != null) {
                    this.mQb.Of(2);
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
            if (this.mPz.d) {
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
            String d = com.kascend.chushou.d.h.dBV().d();
            String str3 = h.isEmpty(d) ? "2" : d;
            if (this.mPz.d) {
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
                if (this.mPz != null) {
                    this.mPz.a(playUrl2);
                    if (this.mQb != null) {
                        Message Oh = this.mQb.Oh(5);
                        Oh.arg1 = 1;
                        this.mQb.O(Oh);
                    }
                }
                String b = com.kascend.chushou.player.c.a.b(playUrl2);
                if (!h.isEmpty(b)) {
                    this.mPs = Uri.parse(b);
                    if (this.mQe) {
                        this.mQe = false;
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (z && this.mPt != null) {
                        a(false, z2);
                    }
                }
            }
        }
    }

    public void d(final boolean z, ArrayList<PlayUrl> arrayList) {
        if (this.mPK == null || this.mPK.a <= 0) {
            this.mPK = com.kascend.chushou.view.b.a.a.dEp();
            this.mPK.a(new a.InterfaceC0714a() { // from class: com.kascend.chushou.player.VideoPlayer.13
                @Override // com.kascend.chushou.view.b.a.a.InterfaceC0714a
                public void a(int i) {
                    if (i == a.f.tv_play_video) {
                        VideoPlayer.this.mPK.dismissAllowingStateLoss();
                        VideoPlayer.this.b(z);
                    } else if (i == a.f.tv_play_audio) {
                        VideoPlayer.this.mPK.dismissAllowingStateLoss();
                        VideoPlayer.this.c(z);
                    } else if (i == a.f.iv_close) {
                        VideoPlayer.this.finish();
                    } else {
                        if (i == a.f.tv_union_proxy) {
                        }
                    }
                }
            });
            this.mPK.show(getSupportFragmentManager(), "showRoom");
        }
    }

    public void t() {
        if (this.mPK != null) {
            this.mPK.dismissAllowingStateLoss();
        }
        if (this.mPx != null) {
            this.mPx.v();
        }
    }

    public void u() {
        com.kascend.chushou.c.c.dBR().c(this.P, new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.VideoPlayer.16
            @Override // com.kascend.chushou.c.b
            public void a() {
            }

            @Override // com.kascend.chushou.c.b
            public void a(String str, JSONObject jSONObject) {
                if (!VideoPlayer.this.isFinishing()) {
                    ParserRet dA = com.kascend.chushou.c.e.dA(jSONObject);
                    if (dA.mRc == 0 && dA.mData != null) {
                        CycleLiveRoomInfo cycleLiveRoomInfo = (CycleLiveRoomInfo) dA.mData;
                        if (VideoPlayer.this.mPz != null && cycleLiveRoomInfo != null && !h.isEmpty(cycleLiveRoomInfo.roomId)) {
                            FullRoomInfo dCF = VideoPlayer.this.mPz.dCF();
                            if (dCF.cycleLiveRoomInfo == null) {
                                dCF.cycleLiveRoomInfo = cycleLiveRoomInfo;
                                VideoPlayer.this.d();
                            } else if (dCF.cycleLiveRoomInfo != null && !cycleLiveRoomInfo.roomId.equals(dCF.cycleLiveRoomInfo.roomId)) {
                                dCF.cycleLiveRoomInfo.copyCycleLiveRoomInfo(cycleLiveRoomInfo);
                                VideoPlayer.this.d();
                            } else {
                                dCF.cycleLiveRoomInfo.copyCycleLiveRoomInfo(cycleLiveRoomInfo);
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
        if (this.mPx != null) {
            this.mPx.N();
        }
    }

    public void v() {
        com.kascend.chushou.c.c.dBR().a(this.P, new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.VideoPlayer.17
            @Override // com.kascend.chushou.c.b
            public void a() {
            }

            @Override // com.kascend.chushou.c.b
            public void a(String str, JSONObject jSONObject) {
                if (!VideoPlayer.this.isFinishing()) {
                    ParserRet dB = com.kascend.chushou.c.e.dB(jSONObject);
                    if (dB.mRc == 0 && dB.mData != null) {
                        PkNotifyInfo pkNotifyInfo = (PkNotifyInfo) dB.mData;
                        VideoPlayer.this.mPU.b = VideoPlayer.this.P;
                        if (pkNotifyInfo != null) {
                            VideoPlayer.this.mPU.mUG = pkNotifyInfo;
                            if (VideoPlayer.this.mPx != null) {
                                VideoPlayer.this.mPx.a(pkNotifyInfo, VideoPlayer.this.P);
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
        if (this.mPA != null) {
            this.mPA.release();
            this.mPA = null;
        }
        com.kascend.chushou.c.c.dBR().a(this.P, new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.VideoPlayer.18
            @Override // com.kascend.chushou.c.b
            public void a() {
            }

            @Override // com.kascend.chushou.c.b
            public void a(String str, JSONObject jSONObject) {
                if (!VideoPlayer.this.isFinishing()) {
                    ParserRet dC = com.kascend.chushou.c.e.dC(jSONObject);
                    if (dC.mRc == 0 && dC.mData != null) {
                        RoomExpandInfo roomExpandInfo = (RoomExpandInfo) dC.mData;
                        if (VideoPlayer.this.mPz != null) {
                            VideoPlayer.this.mPz.mRf = roomExpandInfo.mTopWebAdItem;
                            if (VideoPlayer.this.mPz.s == null) {
                                VideoPlayer.this.mPz.s = new ArrayList();
                            }
                            VideoPlayer.this.mPz.s.clear();
                            VideoPlayer.this.mPz.s.addAll(roomExpandInfo.mGiftTopRightIcons);
                            tv.chushou.zues.a.a.post(new i(50, VideoPlayer.this.mPz.mRf));
                        }
                        if (VideoPlayer.this.mPz != null) {
                            VideoPlayer.this.mPz.fm(roomExpandInfo.mExpandNavList);
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
                            VideoPlayer.this.mPQ.a(list);
                        }
                        List<com.kascend.chushou.player.ui.h5.c.c> list2 = roomExpandInfo.mLuckList;
                        if (!h.isEmpty(list2)) {
                            VideoPlayer.this.mPR.a(list2);
                        }
                        com.kascend.chushou.player.ui.h5.c.c cVar = roomExpandInfo.mVoteItem;
                        if (cVar != null) {
                            VideoPlayer.this.mPS.a(cVar);
                        }
                        List<com.kascend.chushou.player.ui.h5.c.b> list3 = roomExpandInfo.mInteractH5Item;
                        if (!h.isEmpty(list3)) {
                            VideoPlayer.this.mPV.a(list3);
                        }
                        List<com.kascend.chushou.player.ui.h5.c.b> list4 = roomExpandInfo.mInteractNavItem;
                        if (!h.isEmpty(list4)) {
                            VideoPlayer.this.mPV.a(list4);
                        }
                        VideoPlayer.this.mPA = (PrivilegeInfo) dC.mData1;
                        if (VideoPlayer.this.mPA != null) {
                            tv.chushou.zues.a.a.post(new l());
                        }
                        if (VideoPlayer.this.mPz != null) {
                            VideoPlayer.this.mPz.mRl = roomExpandInfo.mIconConfig;
                            VideoPlayer.this.dCp().a(roomExpandInfo.mIconConfig.bangConfig);
                        }
                        List<SkinConfig> list5 = roomExpandInfo.skinConfig;
                        if (list5 != null && VideoPlayer.this.mPz != null) {
                            VideoPlayer.this.mPz.mRp.clear();
                            int i = 0;
                            while (true) {
                                int i2 = i;
                                if (i2 >= list5.size()) {
                                    break;
                                }
                                SkinConfig skinConfig = list5.get(i2);
                                VideoPlayer.this.mPz.mRp.put(skinConfig.position, skinConfig.resource);
                                i = i2 + 1;
                            }
                            VideoPlayer.this.C();
                        }
                        VideoPlayer.this.a(roomExpandInfo.mIconConfig, VideoPlayer.this.mPz != null ? VideoPlayer.this.mPz.mRp : null);
                        if (roomExpandInfo.mColorMap != null && roomExpandInfo.mColorMap.size() > 0 && com.kascend.chushou.b.dBO().c != null && com.kascend.chushou.b.dBO().c.size() <= 0) {
                            com.kascend.chushou.b.dBO().c.putAll(roomExpandInfo.mColorMap);
                            tv.chushou.zues.a.a.post(new i(52, null));
                        }
                        AutoBang autoBang = roomExpandInfo.mAutoBang;
                        if (autoBang != null && autoBang.currentTime != 0 && autoBang.bangTime != 0) {
                            VideoPlayer.this.dCp().a(autoBang);
                        }
                        if (!h.isEmpty(roomExpandInfo.mRelatedRoomList) && VideoPlayer.this.mPz != null) {
                            VideoPlayer.this.mPz.t = roomExpandInfo.mRelatedRoomList;
                            if (VideoPlayer.this.mPx != null && VideoPlayer.this.H) {
                                VideoPlayer.this.mPx.w();
                            }
                        }
                        if (roomExpandInfo.mRoomNewUserInfo != null && roomExpandInfo.mRoomNewUserInfo.mBarrierNoviceGuide && !com.kascend.chushou.d.h.dBV().k() && VideoPlayer.this.mPx != null) {
                            VideoPlayer.this.mPx.J();
                        }
                        if (roomExpandInfo.mRoomNewUserInfo != null && roomExpandInfo.mRoomNewUserInfo.mRewardNoviceGuide && !com.kascend.chushou.d.h.dBV().l() && VideoPlayer.this.mPx != null) {
                            VideoPlayer.this.mPx.K();
                        }
                        if (!h.isEmpty(roomExpandInfo.mShopWindowInfos)) {
                            if (VideoPlayer.this.mPz != null) {
                                if (VideoPlayer.this.mPz.mRm == null) {
                                    VideoPlayer.this.mPz.mRm = new ArrayList();
                                }
                                VideoPlayer.this.mPz.mRm.addAll(roomExpandInfo.mShopWindowInfos);
                            }
                            if (VideoPlayer.this.mPx != null) {
                                VideoPlayer.this.mPx.L();
                            }
                        }
                        VideoPlayer.this.mPU.b = VideoPlayer.this.P;
                        if (roomExpandInfo.mPkNotifyInfo != null) {
                            VideoPlayer.this.mPU.mUG = roomExpandInfo.mPkNotifyInfo;
                            if (VideoPlayer.this.mPx != null) {
                                VideoPlayer.this.mPx.a(roomExpandInfo.mPkNotifyInfo, VideoPlayer.this.P);
                            }
                        } else {
                            VideoPlayer.this.mPU.mUG = null;
                        }
                        if (roomExpandInfo.mTrumpetPocket != null && VideoPlayer.this.mPz != null) {
                            VideoPlayer.this.mPz.mRo = roomExpandInfo.mTrumpetPocket;
                            if (VideoPlayer.this.mPx != null) {
                                VideoPlayer.this.mPx.M();
                            }
                        }
                        if (!h.isEmpty(roomExpandInfo.hotwordContentList)) {
                            if (VideoPlayer.this.mPz != null) {
                                if (VideoPlayer.this.mPz.mRn == null) {
                                    VideoPlayer.this.mPz.mRn = new ArrayList();
                                }
                                VideoPlayer.this.mPz.mRn.clear();
                                VideoPlayer.this.mPz.mRn.addAll(roomExpandInfo.hotwordContentList);
                            }
                            if (VideoPlayer.this.mPx != null) {
                                VideoPlayer.this.mPx.b(roomExpandInfo.hotwordContentList);
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
        }, this.mPN, this.mPW);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U() {
        if (!h.isEmpty(com.kascend.chushou.a.a.dBP().z)) {
            StringBuilder sb = new StringBuilder();
            if (com.kascend.chushou.a.a.dBP().z.contains(com.kascend.chushou.a.a.f)) {
                if (sb.length() > 0) {
                    sb.append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                sb.append(com.kascend.chushou.a.a.f);
            }
            if (com.kascend.chushou.a.a.dBP().z.contains(com.kascend.chushou.a.a.g)) {
                if (sb.length() > 0) {
                    sb.append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                sb.append(com.kascend.chushou.a.a.g);
            }
            if (com.kascend.chushou.a.a.dBP().z.contains(com.kascend.chushou.a.a.i)) {
                if (sb.length() > 0) {
                    sb.append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                sb.append(com.kascend.chushou.a.a.i);
            }
            if (com.kascend.chushou.a.a.dBP().z.contains(com.kascend.chushou.a.a.h)) {
                if (sb.length() > 0) {
                    sb.append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                sb.append(com.kascend.chushou.a.a.h);
            }
            if (com.kascend.chushou.a.a.dBP().z.contains(com.kascend.chushou.a.a.j)) {
                if (sb.length() > 0) {
                    sb.append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                sb.append(com.kascend.chushou.a.a.j);
            }
            if (com.kascend.chushou.a.a.dBP().z.contains(com.kascend.chushou.a.a.l)) {
                if (sb.length() > 0) {
                    sb.append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                sb.append(com.kascend.chushou.a.a.l);
            }
            if (com.kascend.chushou.a.a.dBP().z.contains(com.kascend.chushou.a.a.m)) {
                if (sb.length() > 0) {
                    sb.append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                sb.append(com.kascend.chushou.a.a.m);
            }
            if (sb.length() != 0) {
                com.kascend.chushou.a.a.dBP().a(sb.toString(), this.P, new a.c() { // from class: com.kascend.chushou.player.VideoPlayer.19
                    @Override // com.kascend.chushou.a.a.c
                    public void a(List<ListItem> list) {
                        if (VideoPlayer.this.mPz != null && list != null) {
                            int i = 0;
                            while (true) {
                                int i2 = i;
                                if (i2 >= list.size()) {
                                    break;
                                }
                                if (list.get(i2).mAdExtraInfo != null) {
                                    if (com.kascend.chushou.a.a.f.equals(list.get(i2).mAdExtraInfo.mCode)) {
                                        VideoPlayer.this.mPz.mRe = list.get(i2);
                                    } else if (com.kascend.chushou.a.a.g.equals(list.get(i2).mAdExtraInfo.mCode)) {
                                        VideoPlayer.this.mPz.mRd = list.get(i2);
                                    } else if (com.kascend.chushou.a.a.i.equals(list.get(i2).mAdExtraInfo.mCode)) {
                                        VideoPlayer.this.mPz.mRg = list.get(i2);
                                    } else if (com.kascend.chushou.a.a.h.equals(list.get(i2).mAdExtraInfo.mCode)) {
                                        VideoPlayer.this.mPz.mRh = list.get(i2);
                                    } else if (com.kascend.chushou.a.a.j.equals(list.get(i2).mAdExtraInfo.mCode)) {
                                        VideoPlayer.this.mPz.mRk = list.get(i2);
                                    } else if (com.kascend.chushou.a.a.l.equals(list.get(i2).mAdExtraInfo.mCode)) {
                                        VideoPlayer.this.mPz.mRi = list.get(i2);
                                    } else if (com.kascend.chushou.a.a.m.equals(list.get(i2).mAdExtraInfo.mCode)) {
                                        VideoPlayer.this.mPz.mRj = list.get(i2);
                                    }
                                }
                                i = i2 + 1;
                            }
                            if (VideoPlayer.this.mPx != null) {
                                VideoPlayer.this.mPx.H();
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
        Window window;
        int i;
        if (Build.VERSION.SDK_INT >= 11 && (window = getWindow()) != null && window.getDecorView() != null) {
            if (!z) {
                if (Build.VERSION.SDK_INT >= 19) {
                    i = 5894;
                } else {
                    i = 1799;
                }
                this.mPG.setSystemUiVisibility(i);
                return;
            }
            this.mPG.setSystemUiVisibility(1792);
        }
    }

    public void e(boolean z) {
        Window window;
        View decorView;
        if (com.kascend.chushou.b.dBO().d != 1 && (window = getWindow()) != null && (decorView = window.getDecorView()) != null) {
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
        if (this.mPx != null) {
            this.mPx.a(i, i2, intent);
        }
    }

    public Uri dCi() {
        return this.mPs;
    }

    @Override // com.kascend.chushou.view.base.BaseActivity
    protected int y() {
        return 0;
    }

    public void wh(boolean z) {
        if (this.mPG != null) {
            this.mPG.nZT = z;
        }
    }

    public void dCj() {
        if (this.mPG != null) {
            this.mPG.dCj();
        }
    }

    public boolean dCk() {
        return this.ae;
    }

    public void f(boolean z) {
        this.ae = z;
    }

    public void g(boolean z) {
        if (this.mPG != null) {
            this.mPG.setIsTranslucentStatus(z);
        }
    }

    public void z() {
        if (this.mPG != null) {
            this.mPG.dQR();
        }
    }

    @Override // com.kascend.chushou.widget.gifts.RoomSendGiftView.a
    public void A() {
        if (this.mPE != null) {
            this.mPE.b();
        }
    }

    @Override // com.kascend.chushou.widget.gifts.RoomSendGiftView.a
    public void B() {
        if (this.mPE != null) {
            this.mPE.b();
        }
    }

    public void a(List<ListItem> list) {
        if (this.mPx != null) {
            this.mPx.a(list);
        }
    }

    public void a(IconConfig iconConfig, Map<String, SkinConfig.SkinRes> map) {
        if (this.mPx != null) {
            this.mPx.a(iconConfig, map);
        }
    }

    public void C() {
        if (this.mPx != null) {
            this.mPx.I();
        }
    }

    @Override // com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC0706a
    public void a(int i) {
        if (this.mPx != null) {
            this.mPx.a(i);
        }
    }

    @Override // com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC0706a
    public void D() {
        if (!isFinishing() && this.mPx != null) {
            this.mPx.D();
        }
    }

    @Override // com.kascend.chushou.player.ui.h5.b.b.a
    public void a(long j) {
        if (!isFinishing() && this.mPx != null) {
            this.mPx.a(j);
        }
    }

    @Override // com.kascend.chushou.player.ui.h5.b.b.a
    public void a(com.kascend.chushou.player.ui.h5.c.a aVar) {
        if (aVar != null && this.mPx != null) {
            this.mPx.a(aVar);
        }
    }

    @Override // com.kascend.chushou.player.ui.h5.b.b.a
    public void b(int i) {
        if (this.mPx != null) {
            this.mPx.b(i);
        }
    }

    @Override // com.kascend.chushou.player.ui.h5.d.a.InterfaceC0705a
    public void b(long j) {
        if (!isFinishing() && this.mPx != null) {
            this.mPx.b(j);
        }
    }

    @Override // com.kascend.chushou.player.ui.h5.a.a.InterfaceC0703a
    public void c(int i) {
        if (!isFinishing() && this.mPx != null) {
            this.mPx.c(i);
        }
    }

    @Override // com.kascend.chushou.player.ui.h5.d.a.InterfaceC0705a
    public void b(com.kascend.chushou.player.ui.h5.c.a aVar) {
        if (aVar != null && this.mPx != null) {
            this.mPx.b(aVar);
        }
    }

    @Override // com.kascend.chushou.player.ui.a.a.InterfaceC0700a
    public void a(IconConfig.Config config) {
        if (this.mPx != null) {
            this.mPx.a(config);
        }
    }

    @Override // com.kascend.chushou.player.ui.a.a.InterfaceC0700a
    public void a(BangInfo bangInfo, String str) {
        if (this.mPx != null) {
            this.mPx.a(bangInfo, str);
        }
    }

    @Override // com.kascend.chushou.player.ui.a.a.InterfaceC0700a
    public void a(long j, BangInfo bangInfo, String str) {
        if (this.mPx != null) {
            this.mPx.a(j, bangInfo, str);
        }
    }

    public com.kascend.chushou.player.ui.h5.redpacket.a dCl() {
        return this.mPQ;
    }

    public com.kascend.chushou.player.ui.h5.b.b dCm() {
        return this.mPR;
    }

    public com.kascend.chushou.player.ui.h5.d.a dCn() {
        return this.mPS;
    }

    public com.kascend.chushou.player.ui.h5.a.a dCo() {
        return this.mPV;
    }

    public com.kascend.chushou.player.ui.a.a dCp() {
        return this.mPT;
    }

    public com.kascend.chushou.player.e.a dCq() {
        return this.mPU;
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
        RxExecutor.postDelayed(this.mPY, EventThread.MAIN_THREAD, aVar.d, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.VideoPlayer.2
            @Override // java.lang.Runnable
            public void run() {
                if (VideoPlayer.this.mPx != null) {
                    VideoPlayer.this.mPx.c(aVar);
                }
            }
        });
    }

    private void e(final com.kascend.chushou.player.ui.h5.c.a aVar) {
        if (!com.kascend.chushou.d.h.dBV().dBY().contains(aVar.b)) {
            if (aVar.d < 0) {
                aVar.d = 0;
            }
            RxExecutor.postDelayed(this.mPY, EventThread.MAIN_THREAD, aVar.d, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.VideoPlayer.3
                @Override // java.lang.Runnable
                public void run() {
                    if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.mPx != null) {
                        VideoPlayer.this.mPx.c(aVar);
                    }
                }
            });
        }
    }

    private String dCr() {
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
                if (VideoPlayer.this.mPF != null && !VideoPlayer.this.isFinishing()) {
                    VideoPlayer.n = VideoPlayer.this.mPF.getStreamVolume(3);
                }
                if (!VideoPlayer.this.isFinishing() && (VideoPlayer.this.mPx instanceof f)) {
                    ((f) VideoPlayer.this.mPx).ab();
                }
            }
        }
    }

    public String a(String str) {
        HashMap hashMap = new HashMap(tv.chushou.zues.utils.d.SV(str));
        if ("1".equals(this.R)) {
            hashMap.put("roomId", this.P);
        } else if ("3".equals(this.R)) {
            hashMap.put("videoId", this.P);
        }
        return tv.chushou.zues.utils.d.toJson(hashMap);
    }

    public boolean dCs() {
        if (this.mPx instanceof com.kascend.chushou.player.d.a) {
            return ((com.kascend.chushou.player.d.a) this.mPx).dDy();
        }
        if (this.mPx instanceof com.kascend.chushou.player.e.e) {
            return true;
        }
        return false;
    }
}

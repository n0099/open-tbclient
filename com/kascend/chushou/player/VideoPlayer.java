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
    private String mPC;
    private FrescoThumbnailView mPD;
    private FrameLayout mPE;
    public com.kascend.chushou.player.feedback.a mPM;
    private a mPO;
    private CSTVWifiReceiver mPP;
    private c mPj;
    b mPo;
    public PrivilegeInfo mPp;
    com.kascend.chushou.widget.a.b mPt;
    private KPSwitchRootRelativeLayout mPv;
    private FrameLayout mPw;
    private LinearLayout mPx;
    private com.kascend.chushou.toolkit.d mPy;
    com.kascend.chushou.view.b.a.a mPz;
    private boolean B = true;
    private boolean C = false;
    private Uri mPf = null;
    private tv.chushou.common.player.a mPg = null;
    public tv.chushou.common.player.a mPh = null;
    public tv.chushou.common.player.a mPi = null;
    public boolean d = false;
    public boolean e = false;
    private e mPk = null;
    private boolean H = false;
    private com.kascend.chushou.view.user.b mPl = null;
    private boolean J = false;
    private boolean K = false;
    private boolean L = false;
    private boolean M = false;
    private long N = 0;
    private int O = 0;
    public boolean g = false;
    private ImageView mPq = null;
    private TextView mPr = null;
    private AnimationImageView mPs = null;
    private View aUB = null;
    public boolean j = false;
    public float k = 0.0f;
    public float l = 0.0f;
    public boolean m = false;
    public AudioManager mPu = null;
    private d.a mPA = new d.a() { // from class: com.kascend.chushou.player.VideoPlayer.1
        @Override // com.kascend.chushou.toolkit.d.a
        public void a() {
            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.mPQ != null) {
                VideoPlayer.this.mPQ.Of(4);
            }
        }
    };
    private boolean ae = false;
    public boolean q = true;
    public long r = -1;
    public long s = -1;
    private PowerManager.WakeLock mPB = null;
    public String t = null;
    private final com.kascend.chushou.player.ui.h5.redpacket.a mPF = new com.kascend.chushou.player.ui.h5.redpacket.a(this);
    private final com.kascend.chushou.player.ui.h5.b.b mPG = new com.kascend.chushou.player.ui.h5.b.b(this);
    private final com.kascend.chushou.player.ui.h5.d.a mPH = new com.kascend.chushou.player.ui.h5.d.a(this);
    private final com.kascend.chushou.player.ui.a.a mPI = new com.kascend.chushou.player.ui.a.a(this);
    private final com.kascend.chushou.player.e.a mPJ = new com.kascend.chushou.player.e.a();
    private final com.kascend.chushou.player.ui.h5.a.a mPK = new com.kascend.chushou.player.ui.h5.a.a(this);
    private String mPL = "1";
    private String aq = "2";
    private io.reactivex.disposables.a mPN = new io.reactivex.disposables.a();
    private tv.chushou.zues.c mPQ = new tv.chushou.zues.c(new Handler.Callback() { // from class: com.kascend.chushou.player.VideoPlayer.6
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            try {
                if (!VideoPlayer.this.isFinishing()) {
                    switch (message.what) {
                        case 1:
                            VideoPlayer.this.mPQ.removeMessages(1);
                            com.kascend.chushou.c.c.dBQ().a(VideoPlayer.this.P, VideoPlayer.this.mPo != null ? VideoPlayer.this.mPo.h : null, System.currentTimeMillis());
                            VideoPlayer.this.mPQ.K(1, VideoPlayer.A);
                            break;
                        case 2:
                            VideoPlayer.this.a(true, (Uri) null, false);
                            break;
                        case 3:
                            VideoPlayer.this.cXu();
                            break;
                        case 4:
                            if (VideoPlayer.this.mPk != null) {
                                VideoPlayer.this.mPk.a(true);
                            }
                            if (VideoPlayer.this.mPy != null) {
                                VideoPlayer.this.mPy.d();
                                VideoPlayer.this.mPy = null;
                                break;
                            }
                            break;
                        case 5:
                            int i = message.arg1;
                            if (i == 1) {
                                if (VideoPlayer.this.mPk != null) {
                                    VideoPlayer.this.mPk.p();
                                    break;
                                }
                            } else if (i == 2 && VideoPlayer.this.mPk != null) {
                                VideoPlayer.this.mPk.e(message.arg2);
                                break;
                            }
                            break;
                        case 6:
                            if (!com.kascend.chushou.b.dBN().a && !com.kascend.chushou.b.dBN().b && VideoPlayer.this.mPk != null) {
                                VideoPlayer.this.mPk.g(true);
                                break;
                            } else {
                                VideoPlayer.this.c();
                                break;
                            }
                            break;
                        case 7:
                            tv.chushou.zues.utils.e.d(VideoPlayer.this.v, "MSG_BUFFER_DEALY: ");
                            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.mPk != null && VideoPlayer.this.M && !VideoPlayer.this.e) {
                                VideoPlayer.this.mPk.h(true);
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
    private boolean mPR = false;
    private boolean mPS = true;
    private boolean mPT = false;
    private tv.chushou.common.player.b mPU = new tv.chushou.common.player.b() { // from class: com.kascend.chushou.player.VideoPlayer.14
        @Override // tv.chushou.common.player.b
        public void dCt() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerACallback onSetVideoViewLayout");
            if (!VideoPlayer.this.isFinishing()) {
                if ((VideoPlayer.this.mPk == null || !VideoPlayer.this.mPk.H) && VideoPlayer.this.mPk != null && !VideoPlayer.this.d) {
                    VideoPlayer.this.mPk.y();
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void MI(int i) {
            if (!VideoPlayer.this.isFinishing()) {
                if ((VideoPlayer.this.mPk == null || !VideoPlayer.this.mPk.H) && VideoPlayer.this.mPk != null && !VideoPlayer.this.d) {
                    VideoPlayer.this.mPk.g(i);
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void dCu() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerACallback onCompletePlayback");
            if (!VideoPlayer.this.isFinishing()) {
                if (!h.isEmpty(VideoPlayer.this.P)) {
                    j.dBZ().a(VideoPlayer.this.P, 0);
                }
                VideoPlayer.this.K = false;
                if (VideoPlayer.this.mPQ != null) {
                    VideoPlayer.this.mPQ.removeMessages(1);
                }
                if ((VideoPlayer.this.mPk == null || !VideoPlayer.this.mPk.H) && VideoPlayer.this.mPk != null && !VideoPlayer.this.d) {
                    VideoPlayer.this.mPQ.removeMessages(7);
                    VideoPlayer.this.M = false;
                    VideoPlayer.this.mPk.z();
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void dCv() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerACallback onVideoRenderingStart");
            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.mPk != null) {
                VideoPlayer.this.mPk.G();
            }
        }

        @Override // tv.chushou.common.player.b
        public void dCw() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerACallback onPreparedPlayback");
            if (!VideoPlayer.this.isFinishing()) {
                if (VideoPlayer.this.mPk == null || !VideoPlayer.this.mPk.H) {
                    VideoPlayer.this.mPQ.removeMessages(6);
                    VideoPlayer.this.N = 0L;
                    VideoPlayer.this.O = 0;
                    if (VideoPlayer.this.mPg != null && VideoPlayer.this.mPk != null) {
                        VideoPlayer.this.mPg.setVolume(VideoPlayer.this.mPk.J, VideoPlayer.this.mPk.J);
                    }
                    if (VideoPlayer.this.mPo != null) {
                        VideoPlayer.this.K = false;
                        FullRoomInfo dCE = VideoPlayer.this.ol() ? null : VideoPlayer.this.mPo.dCE();
                        if (VideoPlayer.this.L || dCE != null) {
                            if (VideoPlayer.this.mPo.e) {
                                VideoPlayer.this.mPo.e = false;
                                VideoPlayer.this.mPo.d = !VideoPlayer.this.mPo.d;
                            }
                            if (VideoPlayer.this.mPk != null) {
                                VideoPlayer.this.c("1", (String) null);
                                if (!VideoPlayer.this.d) {
                                    VideoPlayer.this.mPk.i(true);
                                } else if (VideoPlayer.this.e) {
                                    VideoPlayer.this.e = false;
                                    VideoPlayer.this.mPk.B();
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
                if (VideoPlayer.this.mPQ != null) {
                    VideoPlayer.this.mPQ.removeMessages(7);
                }
                if (VideoPlayer.this.mPQ != null) {
                    VideoPlayer.this.mPQ.removeMessages(1);
                }
                if ((VideoPlayer.this.mPk == null || !VideoPlayer.this.mPk.H) && !VideoPlayer.this.dCb()) {
                    if (!"10004".equals(VideoPlayer.this.t)) {
                        if (VideoPlayer.this.mPk != null) {
                            if (VideoPlayer.this.d) {
                                VideoPlayer.this.mPh.stop();
                                VideoPlayer.this.mPh.release();
                                VideoPlayer.this.e = false;
                                VideoPlayer.this.mPk.C();
                            }
                            if (!com.kascend.chushou.b.dBN().a && !com.kascend.chushou.b.dBN().b) {
                                VideoPlayer.this.mPk.g(true);
                            } else if (VideoPlayer.this.d) {
                                VideoPlayer.this.mPk.a(i, true);
                            } else {
                                VideoPlayer.this.mPk.a(i, false);
                            }
                            VideoPlayer.this.c("2", (String) null);
                            return;
                        }
                        return;
                    }
                    dCu();
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void dCx() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerACallback onBufferingStart");
            if (!VideoPlayer.this.isFinishing()) {
                if ((VideoPlayer.this.mPk == null || !VideoPlayer.this.mPk.H) && VideoPlayer.this.mPk != null && !VideoPlayer.this.d) {
                    VideoPlayer.this.mPk.E();
                    VideoPlayer.this.M = true;
                    long currentTimeMillis = System.currentTimeMillis();
                    VideoPlayer.this.mPQ.removeMessages(7);
                    if (!VideoPlayer.this.g) {
                        VideoPlayer.y(VideoPlayer.this);
                    }
                    tv.chushou.zues.utils.e.d(VideoPlayer.this.v, "currentTime: -- >" + currentTimeMillis + "  bufferTime-->" + VideoPlayer.this.N + "  bufferCount-->" + VideoPlayer.this.O);
                    if (currentTimeMillis - VideoPlayer.this.N >= 20000 || VideoPlayer.this.O < 2 || VideoPlayer.this.mPk.H) {
                        if (VideoPlayer.this.O == 1) {
                            VideoPlayer.this.N = currentTimeMillis;
                        }
                        VideoPlayer.this.mPQ.K(7, 5000L);
                    } else {
                        VideoPlayer.this.mPQ.Of(7);
                    }
                    if (VideoPlayer.this.g) {
                        VideoPlayer.this.g = false;
                    }
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void dCy() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerACallback onBufferingEnd");
            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.mPk != null && !VideoPlayer.this.d) {
                VideoPlayer.this.mPQ.removeMessages(7);
                VideoPlayer.this.M = false;
                if (VideoPlayer.this.mPk == null || !VideoPlayer.this.mPk.H) {
                    if (VideoPlayer.this.mPg == null) {
                        VideoPlayer.this.mPk.a(false, true, false);
                    } else {
                        VideoPlayer.this.mPk.a(true, VideoPlayer.this.mPg.getPlayState() == 4, VideoPlayer.this.mPg.getPlayState() == 5);
                    }
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void dCz() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerACallback onPlayerStart");
            if (!VideoPlayer.this.isFinishing()) {
                if (VideoPlayer.this.mPk == null || !VideoPlayer.this.mPk.H) {
                    if (VideoPlayer.this.mPk != null && !VideoPlayer.this.d) {
                        if (VideoPlayer.this.mPg != null) {
                            VideoPlayer.this.mPk.F();
                            VideoPlayer.this.mPk.a(true, VideoPlayer.this.mPg.getPlayState() == 4, VideoPlayer.this.mPg.getPlayState() == 5);
                        } else {
                            VideoPlayer.this.mPk.a(false, true, false);
                        }
                    }
                    if (VideoPlayer.this.mPQ != null && !VideoPlayer.this.ol()) {
                        VideoPlayer.this.mPQ.removeMessages(1);
                        VideoPlayer.this.mPQ.K(1, VideoPlayer.A);
                    }
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void dCA() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerACallback onPlayerPause");
            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.mPQ != null) {
                VideoPlayer.this.mPQ.removeMessages(1);
            }
        }

        @Override // tv.chushou.common.player.b
        public void dCB() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerACallback onPlayerStop");
            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.ol() && VideoPlayer.this.mPh != null && !h.isEmpty(VideoPlayer.this.P) && VideoPlayer.this.mPh.getCurrentPos() > 0) {
                j.dBZ().a(VideoPlayer.this.P, VideoPlayer.this.mPh.getCurrentPos());
            }
        }
    };
    private tv.chushou.common.player.b mPV = new tv.chushou.common.player.b() { // from class: com.kascend.chushou.player.VideoPlayer.15
        @Override // tv.chushou.common.player.b
        public void dCt() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerBCallback onSetVideoViewLayout");
            if (!VideoPlayer.this.isFinishing()) {
                if ((VideoPlayer.this.mPk == null || !VideoPlayer.this.mPk.H) && VideoPlayer.this.mPk != null && VideoPlayer.this.d) {
                    VideoPlayer.this.mPk.y();
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void MI(int i) {
            if (!VideoPlayer.this.isFinishing()) {
                if ((VideoPlayer.this.mPk == null || !VideoPlayer.this.mPk.H) && VideoPlayer.this.mPk != null && VideoPlayer.this.d) {
                    VideoPlayer.this.mPk.g(i);
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void dCu() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerBCallback onCompletePlayback");
            if (!VideoPlayer.this.isFinishing()) {
                if (!h.isEmpty(VideoPlayer.this.P)) {
                    j.dBZ().a(VideoPlayer.this.P, 0);
                }
                VideoPlayer.this.K = false;
                if (VideoPlayer.this.mPQ != null) {
                    VideoPlayer.this.mPQ.removeMessages(1);
                }
                if ((VideoPlayer.this.mPk == null || !VideoPlayer.this.mPk.H) && VideoPlayer.this.mPk != null && VideoPlayer.this.d) {
                    VideoPlayer.this.mPQ.removeMessages(7);
                    VideoPlayer.this.M = false;
                    VideoPlayer.this.mPk.z();
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void dCv() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerBCallback onVideoRenderingStart");
            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.mPk != null) {
                VideoPlayer.this.mPk.G();
            }
        }

        @Override // tv.chushou.common.player.b
        public void dCw() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerBCallback onPreparedPlayback");
            if (!VideoPlayer.this.isFinishing()) {
                if (VideoPlayer.this.mPk == null || !VideoPlayer.this.mPk.H) {
                    VideoPlayer.this.mPQ.removeMessages(6);
                    VideoPlayer.this.N = 0L;
                    VideoPlayer.this.O = 0;
                    if (VideoPlayer.this.mPg != null && VideoPlayer.this.mPk != null) {
                        VideoPlayer.this.mPg.setVolume(VideoPlayer.this.mPk.J, VideoPlayer.this.mPk.J);
                    }
                    if (VideoPlayer.this.mPo != null) {
                        VideoPlayer.this.K = false;
                        FullRoomInfo dCE = VideoPlayer.this.ol() ? null : VideoPlayer.this.mPo.dCE();
                        if (VideoPlayer.this.L || dCE != null) {
                            if (VideoPlayer.this.mPo.e) {
                                VideoPlayer.this.mPo.e = false;
                                VideoPlayer.this.mPo.d = !VideoPlayer.this.mPo.d;
                            }
                            if (VideoPlayer.this.mPk != null) {
                                VideoPlayer.this.c("1", (String) null);
                                if (VideoPlayer.this.d) {
                                    VideoPlayer.this.mPk.i(true);
                                } else if (VideoPlayer.this.e) {
                                    VideoPlayer.this.e = false;
                                    VideoPlayer.this.mPk.B();
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
                if (VideoPlayer.this.mPQ != null) {
                    VideoPlayer.this.mPQ.removeMessages(7);
                }
                if (VideoPlayer.this.mPQ != null) {
                    VideoPlayer.this.mPQ.removeMessages(1);
                }
                if ((VideoPlayer.this.mPk == null || !VideoPlayer.this.mPk.H) && !VideoPlayer.this.dCb()) {
                    if (!"10004".equals(VideoPlayer.this.t)) {
                        if (VideoPlayer.this.mPk != null) {
                            if (!VideoPlayer.this.d) {
                                VideoPlayer.this.mPi.stop();
                                VideoPlayer.this.mPi.release();
                                VideoPlayer.this.mPk.C();
                                VideoPlayer.this.e = false;
                            }
                            if (!com.kascend.chushou.b.dBN().a && !com.kascend.chushou.b.dBN().b) {
                                VideoPlayer.this.mPk.g(true);
                            } else if (VideoPlayer.this.d) {
                                VideoPlayer.this.mPk.a(i, false);
                            } else {
                                VideoPlayer.this.mPk.a(i, true);
                            }
                            VideoPlayer.this.c("2", (String) null);
                            return;
                        }
                        return;
                    }
                    dCu();
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void dCx() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerBCallback onBufferingStart");
            if (!VideoPlayer.this.isFinishing()) {
                if ((VideoPlayer.this.mPk == null || !VideoPlayer.this.mPk.H) && VideoPlayer.this.mPk != null && VideoPlayer.this.d) {
                    VideoPlayer.this.mPk.E();
                    VideoPlayer.this.M = true;
                    VideoPlayer.this.mPQ.removeMessages(7);
                    long currentTimeMillis = System.currentTimeMillis();
                    if (!VideoPlayer.this.g) {
                        VideoPlayer.y(VideoPlayer.this);
                    }
                    tv.chushou.zues.utils.e.d(VideoPlayer.this.v, "currentTime: -- >" + currentTimeMillis + "  bufferTime-->" + VideoPlayer.this.N + "  bufferCount-->" + VideoPlayer.this.O);
                    if (currentTimeMillis - VideoPlayer.this.N >= 20000 || VideoPlayer.this.O < 2 || VideoPlayer.this.mPk.H) {
                        if (VideoPlayer.this.O == 1) {
                            VideoPlayer.this.N = currentTimeMillis;
                        }
                        VideoPlayer.this.mPQ.K(7, 5000L);
                    } else {
                        VideoPlayer.this.N = 0L;
                        VideoPlayer.this.O = 0;
                        VideoPlayer.this.mPQ.Of(7);
                    }
                    if (VideoPlayer.this.g) {
                        VideoPlayer.this.g = false;
                    }
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void dCy() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerBCallback onBufferingEnd");
            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.mPk != null && VideoPlayer.this.d) {
                VideoPlayer.this.M = false;
                VideoPlayer.this.mPQ.removeMessages(7);
                if (VideoPlayer.this.mPk == null || !VideoPlayer.this.mPk.H) {
                    if (VideoPlayer.this.mPg == null) {
                        VideoPlayer.this.mPk.a(false, true, false);
                    } else {
                        VideoPlayer.this.mPk.a(true, VideoPlayer.this.mPg.getPlayState() == 4, VideoPlayer.this.mPg.getPlayState() == 5);
                    }
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void dCz() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerBCallback onPlayerStart");
            if (!VideoPlayer.this.isFinishing()) {
                if (VideoPlayer.this.mPk == null || !VideoPlayer.this.mPk.H) {
                    if (VideoPlayer.this.mPk != null && VideoPlayer.this.d) {
                        if (VideoPlayer.this.mPg != null) {
                            VideoPlayer.this.mPk.F();
                            VideoPlayer.this.mPk.a(true, VideoPlayer.this.mPg.getPlayState() == 4, VideoPlayer.this.mPg.getPlayState() == 5);
                        } else {
                            VideoPlayer.this.mPk.a(false, true, false);
                        }
                    }
                    if (VideoPlayer.this.mPQ != null && !VideoPlayer.this.ol()) {
                        VideoPlayer.this.mPQ.removeMessages(1);
                        VideoPlayer.this.mPQ.K(1, VideoPlayer.A);
                    }
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void dCA() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerBCallback onPlayerPause");
            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.mPQ != null) {
                VideoPlayer.this.mPQ.removeMessages(1);
            }
        }

        @Override // tv.chushou.common.player.b
        public void dCB() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerBCallback onPlayerStop");
            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.ol() && VideoPlayer.this.mPi != null && !h.isEmpty(VideoPlayer.this.P) && VideoPlayer.this.mPi.getCurrentPos() > 0) {
                j.dBZ().a(VideoPlayer.this.P, VideoPlayer.this.mPi.getCurrentPos());
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
        this.mPf = intent.getData();
        if (this.mPf == null) {
            finish();
            return;
        }
        com.kascend.chushou.d.e.j();
        if (this.mPP == null) {
            this.mPP = new CSTVWifiReceiver();
            registerReceiver(this.mPP, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        }
        com.kascend.chushou.toolkit.d.a.dEn().b();
        tv.chushou.zues.utils.e.i(this.v, "intent.getData=" + this.mPf.toString());
        String scheme = this.mPf.getScheme();
        if (scheme == null || !scheme.equals("chushou")) {
            tv.chushou.zues.utils.e.e(this.v, "not support scheme :" + scheme);
            finish();
            return;
        }
        a(intent);
    }

    private void a(Intent intent) {
        this.P = this.mPf.getQueryParameter("roomId");
        this.Q = this.P;
        this.S = this.mPf.getQueryParameter(WebSocketRequest.PARAM_KEY_PROTOCOLS);
        this.aq = this.mPf.getQueryParameter("liveType");
        if ("2".equals(this.aq) || "3".equals(this.aq) || "4".equals(this.aq)) {
            this.mPL = "2";
            this.mPM = new com.kascend.chushou.player.feedback.a();
            if (this.mPM.mYn != null) {
                this.mPM.mYn.reset();
                this.mPM.mYn.roomId = this.P;
                this.mPM.mYn.enterType = 1;
                this.mPM.b = System.currentTimeMillis();
            }
        }
        if (h.isEmpty(this.P) || h.isEmpty(this.S)) {
            tv.chushou.zues.utils.e.e(this.v, "invalid param mItemID=" + this.P + " protocols=" + this.S);
            finish();
            return;
        }
        if (com.kascend.chushou.b.dBN().d == -1) {
            com.kascend.chushou.b.dBN().d = com.kascend.chushou.d.g.b() ? 1 : 0;
        }
        this.mPB = ((PowerManager) getSystemService("power")).newWakeLock(536870938, this.v);
        this.mPB.acquire();
        this.mPo = new b(this.P);
        this.mPo.d = intent.getBooleanExtra("room_play_audio", false);
        this.mPt = new com.kascend.chushou.widget.a.b();
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
        this.mPv = (KPSwitchRootRelativeLayout) findViewById(a.f.rlRoot);
        if (!"2".equals(this.mPL) && com.kascend.chushou.b.dBN().d == 1) {
            this.mPv.setFitsSystemWindows(true);
        }
        this.mPw = (FrameLayout) this.mPv.findViewById(a.f.fl_fragment);
        this.aUB = this.mPv.findViewById(a.f.rl_empty);
        this.mPq = (ImageView) this.aUB.findViewById(a.f.iv_empty);
        this.mPr = (TextView) this.aUB.findViewById(a.f.tv_empty);
        this.mPx = (LinearLayout) this.mPv.findViewById(a.f.rl_title);
        this.Z = (ImageView) this.mPx.findViewById(a.f.back_icon);
        this.Z.setOnClickListener(new View.OnClickListener() { // from class: com.kascend.chushou.player.VideoPlayer.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayer.this.finish();
            }
        });
        this.mPs = (AnimationImageView) this.aUB.findViewById(a.f.iv_loading);
        this.mPD = (FrescoThumbnailView) this.mPv.findViewById(a.f.live_cover);
        this.mPE = (FrameLayout) this.mPv.findViewById(a.f.fl_cover);
        this.k = dCa();
        try {
            this.mPu = (AudioManager) getApplicationContext().getSystemService("audio");
            n = this.mPu.getStreamVolume(3);
            this.mPu.requestAudioFocus(null, 3, 1);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (this.B) {
            a(1, ol() ? "3" : "1");
        } else {
            r();
        }
        if (com.kascend.chushou.b.dBN().b && !com.kascend.chushou.b.dBN().a) {
            RxExecutor.postDelayed(this.mPN, EventThread.MAIN_THREAD, 60L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.VideoPlayer.5
                @Override // java.lang.Runnable
                public void run() {
                    if (!VideoPlayer.this.isFinishing() && com.kascend.chushou.b.dBN().b && !com.kascend.chushou.b.dBN().a) {
                        tv.chushou.zues.utils.g.c(VideoPlayer.this.w, VideoPlayer.this.getString(a.i.str_monet_notify));
                    }
                }
            });
        }
        com.kascend.chushou.c.c.dBQ().a(this.P, stringExtra, System.currentTimeMillis());
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
        if (this.mPO == null) {
            this.mPO = new a();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.media.VOLUME_CHANGED_ACTION");
            registerReceiver(this.mPO, intentFilter);
        }
    }

    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        if (this.mPO != null) {
            unregisterReceiver(this.mPO);
            this.mPO = null;
        }
        super.onStop();
    }

    @Subscribe
    public void onHideGiftEffectEvent(com.kascend.chushou.b.a.a.f fVar) {
        if (fVar.b) {
            this.mPk.k();
            return;
        }
        this.mPk.m();
        this.mPk.l();
    }

    private float dCa() {
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
        this.mPC = str;
        R();
        try {
            if (h.isEmpty(str)) {
                jSONObject = new JSONObject();
            } else {
                jSONObject = new JSONObject(str);
            }
            jSONObject.put("_fbroomid", this.P);
            this.mPo.h = jSONObject.toString();
            String optString = jSONObject.optString("_thumb");
            jSONObject.optBoolean("tag_from_game_mic", false);
            if (!h.isEmpty(optString)) {
                this.ab = optString;
            }
        } catch (JSONException e) {
            e.printStackTrace();
            this.mPo.h = str;
        }
        if (ol()) {
            a(this.P, str);
            aO(this.P, z);
            return;
        }
        a = this.P;
        b(this.P, str);
        a(this.P, dCq(), z);
        w();
    }

    private void O() {
        this.m = true;
        j();
        if (this.mPk != null) {
            this.mPk.r();
        }
        s();
    }

    @Subscribe
    public void onStartRoomEvent(o oVar) {
        if (!isFinishing() && oVar.mON != null && oVar.c != null && !h.isEmpty(oVar.mON.mTargetKey)) {
            if (oVar.c != this) {
                tv.chushou.zues.utils.e.e(this.v, "different player!");
                return;
            }
            if (this.mPo != null) {
                this.mPo.a();
                this.mPo.a = oVar.mON.mTargetKey;
                this.mPo.d = oVar.d;
                if (this.mPo.mQO != null) {
                    this.mPo.mQO.e();
                }
                if (this.mPo.mQO != null) {
                    this.mPo.mQO.b();
                }
                this.mPo.mQS = null;
                this.mPo.mQR = null;
                this.mPo.mQV = null;
                this.mPo.mQU = null;
                this.mPo.mQY = null;
                this.mPo.mQW = null;
                this.mPo.mQX = null;
            }
            if (this.mPu != null) {
                n = this.mPu.getStreamVolume(3);
            }
            if (!h.isEmpty(oVar.mON.mType) && oVar.mON.mType.equals("3")) {
                this.B = false;
                this.mPL = "1";
                r();
                this.P = oVar.mON.mTargetKey;
                this.R = "3";
                if (this.mPt != null) {
                    this.mPt.a();
                }
                if (this.mPo != null) {
                    this.mPo.a((PlayUrl) null);
                    this.mPo.f();
                    if (this.mPo.c() != null) {
                        this.mPo.c().clear();
                    }
                    this.mPo.i.clear();
                }
                if (this.mPk != null) {
                    this.mPk.j();
                }
                s();
                if (this.mPy != null) {
                    this.mPy.d();
                    this.mPy = null;
                }
                if (this.mPN != null) {
                    this.mPN.dispose();
                    this.mPN = new io.reactivex.disposables.a();
                }
                a(oVar.e, false);
                return;
            }
            boolean z = this.R != null && this.R.equals("1");
            this.R = "1";
            this.mPI.a();
            this.mPH.a();
            this.mPG.a();
            this.mPF.c();
            this.mPK.a();
            if (this.mPN != null) {
                this.mPN.dispose();
                this.mPN = new io.reactivex.disposables.a();
            }
            if ("1".equals(oVar.f)) {
                this.H = false;
                if (this.mPo != null && !h.isEmpty(this.mPo.t)) {
                    this.mPo.t.clear();
                }
                this.ab = oVar.mON.mCover;
                this.mPE.setVisibility(0);
                this.mPD.setBlur(true);
                this.mPD.i(oVar.mON.mCover, 0, 0, 0);
            }
            if (!oVar.mON.mTargetKey.equals(this.P)) {
                this.aq = oVar.g;
                if (!z) {
                    this.B = false;
                    r();
                } else if (!"2".equals(this.mPL) && ("2".equals(this.aq) || "3".equals(this.aq) || "4".equals(this.aq))) {
                    this.mPL = "2";
                    this.mPM = new com.kascend.chushou.player.feedback.a();
                    if (this.mPM.mYn != null) {
                        this.mPM.mYn.reset();
                        this.mPM.mYn.roomId = oVar.mON.mTargetKey;
                        this.mPM.mYn.enterType = 1;
                        this.mPM.b = System.currentTimeMillis();
                    }
                }
                this.B = false;
                this.P = oVar.mON.mTargetKey;
                this.Q = this.P;
                this.ab = oVar.mON.mCover;
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
                JSONObject M = com.kascend.chushou.d.e.M("_fromView", str, "_sc", oVar.mON.mSC);
                com.kascend.chushou.toolkit.a.c.a(this.w, M);
                if (this.mPt != null) {
                    this.mPt.a();
                    this.mPt.a(this.P);
                }
                if (this.mPo != null) {
                    this.mPo.a((PlayUrl) null);
                    this.mPo.f();
                    if (this.mPo.c() != null) {
                        this.mPo.c().clear();
                    }
                    this.mPo.i.clear();
                }
                if (this.mPk != null) {
                    this.mPk.j();
                }
                a(M.toString(), false);
                return;
            }
            tv.chushou.zues.utils.g.Om(a.i.str_same_room);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dCb() {
        FullRoomInfo dCE;
        String str;
        RoomInfo roomInfo;
        if (ol()) {
            str = null;
            dCE = null;
        } else {
            dCE = this.mPo.dCE();
            str = (dCE == null || (roomInfo = dCE.mRoominfo) == null) ? null : roomInfo.mGameId;
        }
        return !this.L && (dCE == null || h.isEmpty(str));
    }

    @Subscribe
    public void onMessageEvent(i iVar) {
        if (!isFinishing() && iVar.a != 21 && iVar.a != 22) {
            if (iVar.a == 0 && (iVar.b instanceof Boolean)) {
                if (((Boolean) iVar.b).booleanValue() && !isFinishing()) {
                    w();
                    if (this.mPk != null) {
                        this.mPk.f();
                    }
                }
            } else if (iVar.a == 46) {
                if ((iVar.b instanceof String) && this.mPk != null) {
                    this.mPk.c((String) iVar.b);
                }
            } else if (iVar.a == 54) {
                if (iVar.b instanceof String) {
                    this.mPG.a((String) iVar.b);
                }
            } else if (iVar.a == 55) {
                if (this.mPk != null) {
                    this.mPk.O();
                }
            } else if (iVar.a == 56 && this.mPk != null) {
                this.mPk.P();
            }
        }
    }

    @Subscribe
    public void onRefreshSubscribeEvent(m mVar) {
        if (isFinishing() && this.mPo != null && this.mPo.dCG() != null) {
            RoomInfo dCG = this.mPo.dCG();
            if (mVar.a(dCG.mCreatorUID, dCG.mRoomID)) {
                dCG.mIsSubscribed = mVar.c;
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
        if (this.m || this.mPh == null || this.mPi == null) {
            R();
        }
        if (this.mPt != null) {
            this.mPt.d();
        }
        if (!ol()) {
            if (this.mPy != null && !this.mPy.c()) {
                this.mPy.a();
            }
            v();
            if (this.mPo != null && this.mPo.dCE() != null && this.mPo.dCE().cycleLiveRoomInfo != null && !h.isEmpty(this.mPo.dCE().cycleLiveRoomInfo.roomId)) {
                u();
            }
        }
        super.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.view.base.BaseActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        tv.chushou.zues.utils.e.e(this.v, MissionEvent.MESSAGE_DESTROY);
        if (this.mPo != null && this.mPo.dCE() != null && this.mPo.dCE().cycleLiveRoomInfo != null && !h.isEmpty(this.mPo.dCE().cycleLiveRoomInfo.eventName)) {
            j.dBZ().a(this.P + dCq());
        }
        if ("2".equals(this.mPL) && this.mPM != null && this.mPM.mYn != null) {
            this.mPM.mYn.time = System.currentTimeMillis() - this.mPM.b;
            this.mPM.a();
            this.mPM.b();
        }
        this.mPF.d();
        this.mPG.b();
        this.mPH.b();
        O();
        this.mPC = null;
        a = null;
        if (this.mPQ != null) {
            this.mPQ.cq(null);
            this.mPQ = null;
        }
        if (this.mPy != null) {
            this.mPy.d();
            this.mPy = null;
        }
        if (this.mPt != null) {
            this.mPt.c();
            this.mPt = null;
        }
        if (this.mPo != null) {
            this.mPo.mQS = null;
            this.mPo.mQR = null;
        }
        if (this.mPo != null) {
            this.mPo.b();
            this.mPo = null;
        }
        this.mPf = null;
        this.mPk = null;
        this.mPl = null;
        this.mPp = null;
        this.mPq = null;
        this.mPr = null;
        this.mPs = null;
        this.aUB = null;
        this.mPu = null;
        this.mPv = null;
        this.mPw = null;
        this.Z = null;
        this.mPx = null;
        if (this.mPB != null && this.mPB.isHeld()) {
            this.mPB.release();
            this.mPB = null;
        }
        if (this.mPP != null) {
            unregisterReceiver(this.mPP);
            this.mPP = null;
        }
        h.dQv();
        tv.chushou.zues.a.a.cr(this);
        this.mPN.dispose();
        this.mPH.b();
        this.mPI.b();
        this.mPF.d();
        this.mPG.b();
        this.mPK.b();
        super.onDestroy();
        System.gc();
    }

    @Subscribe
    public void onSendGameGiftEvent(n nVar) {
        if (!isFinishing() && this.mPk != null) {
            this.mPk.a(nVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.view.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        tv.chushou.zues.utils.e.d(this.v, MissionEvent.MESSAGE_PAUSE);
        if (this.mPy != null) {
            this.mPy.b();
        }
        if (this.mPt != null) {
            this.mPt.b(false);
        }
        k();
        this.m = true;
        super.onPause();
    }

    @Override // android.app.Activity
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.mPk != null ? this.mPk.a(motionEvent) : super.onTouchEvent(motionEvent);
    }

    public void c() {
        if ("1".equals(this.R)) {
            j.dBZ().a(this.P + dCq());
        } else {
            j.dBZ().b(this.P);
        }
    }

    private void a(boolean z, boolean z2) {
        int i = 0;
        tv.chushou.zues.utils.e.i(this.v, "startLoadingVideo <------------- mbPrepareingVideo = " + this.K);
        if (this.mPh != null) {
            this.mPh.setHardwearDecod(com.kascend.chushou.d.h.dBU().a);
        }
        if (this.mPi != null) {
            this.mPi.setHardwearDecod(com.kascend.chushou.d.h.dBU().a);
        }
        if (this.mPg != null) {
            this.mPg.setHardwearDecod(com.kascend.chushou.d.h.dBU().a);
        }
        if (!this.K) {
            if (z && this.mPk != null) {
                if (!z2) {
                    this.t = null;
                    this.mPk.e();
                }
            } else if (this.mPk != null && !z2) {
                this.t = null;
                this.mPk.H = false;
                RxExecutor.post(null, EventThread.MAIN_THREAD, new Runnable() { // from class: com.kascend.chushou.player.VideoPlayer.7
                    @Override // java.lang.Runnable
                    public void run() {
                        VideoPlayer.this.mPk.x();
                    }
                });
            }
            this.K = true;
            if (this.mPo != null && this.mPo.dCF() != null) {
                PlayUrl dCF = this.mPo.dCF();
                while (true) {
                    int i2 = i;
                    if (i2 >= dCF.mUrlDetails.size()) {
                        break;
                    }
                    UrlDetails urlDetails = dCF.mUrlDetails.get(i2);
                    if (urlDetails.mUrl.equals(dCF.mSelectedUrl)) {
                        String str = dCF.mUrlDetails.get(i2).mDefinitionType;
                        String str2 = urlDetails.mBitrate;
                    }
                    i = i2 + 1;
                }
            }
            if (z2) {
                if (this.d) {
                    this.mPh.setVideoURI(this.mPf);
                    this.mPh.open();
                    return;
                }
                this.mPi.setVideoURI(this.mPf);
                this.mPi.open();
                return;
            }
            this.mPg.setVideoURI(this.mPf);
            this.mPg.open();
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        try {
            if (motionEvent.getAction() == 0) {
                if (this.mPk != null && this.mPk.b(motionEvent)) {
                    return true;
                }
                if ("2".equals(this.mPL) && this.mPk != null) {
                    this.mPk.a(motionEvent);
                }
            } else if (this.mPk != null && this.mPk.b(motionEvent)) {
                return true;
            }
            return super.dispatchTouchEvent(motionEvent);
        } catch (Exception e) {
            return false;
        }
    }

    @Override // android.support.v7.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.mPk != null && this.mPk.a(i, keyEvent)) {
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
        if (this.mPo != null && this.mPo.dCE() != null && this.mPo.dCE().cycleLiveRoomInfo != null && !h.isEmpty(this.mPo.dCE().cycleLiveRoomInfo.roomId)) {
            this.mPE.setVisibility(0);
            this.mPD.setBlur(true);
            this.mPD.i(this.mPo.dCE().cycleLiveRoomInfo.avatar, 0, 0, 0);
            this.mPD.setVisibility(0);
            j.dBZ().a(this.P + dCq());
            this.mPf = null;
            R();
            this.Q = this.mPo.dCE().cycleLiveRoomInfo.roomId;
            a(this.P, dCq(), false);
        }
    }

    public void a(boolean z) {
        if (this.mPk != null) {
            this.mPk.j(z);
        }
    }

    public void a(boolean z, Uri uri, boolean z2) {
        tv.chushou.zues.utils.e.d(this.v, "loadIfNecessary reload=" + z + " isChangeLines-->" + z2);
        if (this.mPh != null && this.mPi != null) {
            if (uri != null) {
                this.mPf = uri;
            }
            if (z2) {
                this.e = z2;
            }
            this.M = false;
            this.N = 0L;
            this.O = 0;
            this.mPQ.removeMessages(7);
            if (z) {
                if (z2) {
                    if (!this.d) {
                        this.mPi.setOnActivityCallBack(this.mPV);
                    } else {
                        this.mPh.setOnActivityCallBack(this.mPU);
                    }
                } else if (this.d) {
                    this.mPi.setOnActivityCallBack(this.mPV);
                } else {
                    this.mPh.setOnActivityCallBack(this.mPU);
                }
                this.K = false;
                b(true, z2);
            } else if (!this.J) {
                b(true, z2);
            }
            this.mPQ.K(6, 3000L);
        }
    }

    private void b(boolean z, boolean z2) {
        VideoPlayInfo O;
        if ("1".equals(this.R)) {
            O = j.dBZ().N(this.P + dCq(), KeepJobService.JOB_CHECK_PERIODIC);
        } else {
            O = j.dBZ().O(this.P, KeepJobService.JOB_CHECK_PERIODIC);
        }
        if (O != null) {
            a(z, z2);
        } else if ("1".equals(this.R)) {
            a(this.P, dCq(), false);
        } else {
            aO(this.P, false);
        }
    }

    public tv.chushou.common.player.a dCc() {
        return this.mPg;
    }

    public tv.chushou.common.player.a dCd() {
        return this.mPh;
    }

    public tv.chushou.common.player.a dCe() {
        return this.mPi;
    }

    public void a(tv.chushou.common.player.a aVar) {
        this.mPg = aVar;
    }

    public b dCf() {
        return this.mPo;
    }

    public com.kascend.chushou.widget.a.b dCg() {
        return this.mPt;
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
        FullRoomInfo dCE;
        this.r = -1L;
        if (this.s != -1 && this.s != 0) {
            this.r = this.s;
            this.s = -1L;
        }
        if (ol() && this.mPg != null && this.mPg.getPlayState() == 4) {
            this.r = this.mPg.getCurrentPos();
        }
        this.mPR = false;
        tv.chushou.zues.utils.e.d(this.v, "screenChange()<-----");
        tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard(this);
        if (str != null) {
            this.R = str;
        }
        if (!this.C || !z3 || "3".equals(this.R) || this.mPo == null || (dCE = this.mPo.dCE()) == null || dCE.mRoominfo == null || dCE.mRoominfo.mStyle != 1) {
            z5 = false;
        } else {
            z5 = true;
            i = 0;
        }
        if ("2".equals(this.mPL)) {
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
            if (com.kascend.chushou.b.dBN().d == 1) {
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
        if (this.mPt == null) {
            this.mPt = new com.kascend.chushou.widget.a.b();
        }
        if (this.mPt != null) {
            this.mPt.a(this.P);
        }
        if (this.R.equals("5")) {
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            if (this.mPk != null) {
                beginTransaction.remove(this.mPk);
                this.mPk = null;
            }
            if (this.mPl != null) {
                beginTransaction.remove(this.mPl);
                this.mPl = null;
            }
            this.mPl = new com.kascend.chushou.view.user.b();
            beginTransaction.add(a.f.fl_fragment, this.mPl);
            beginTransaction.commitAllowingStateLoss();
        } else {
            FragmentTransaction beginTransaction2 = getSupportFragmentManager().beginTransaction();
            if (this.mPk != null) {
                beginTransaction2.remove(this.mPk);
                this.mPk = null;
            }
            if (this.mPl != null) {
                beginTransaction2.remove(this.mPl);
                this.mPl = null;
            }
            if ("2".equals(this.mPL)) {
                this.mPk = com.kascend.chushou.player.e.e.a(this.ab, z2, this.aq, this.P);
            } else if (1 == i) {
                if (!this.R.equals("3")) {
                    if (z4) {
                        v();
                    }
                    this.mPk = new com.kascend.chushou.player.d.a();
                    Bundle bundle = new Bundle();
                    bundle.putString("mCover", this.ab);
                    bundle.putBoolean("mInitViewAsync", z2);
                    this.mPk.setArguments(bundle);
                }
            } else {
                this.mPk = new com.kascend.chushou.player.d.b();
                Bundle bundle2 = new Bundle();
                if (z5) {
                    i = 1;
                }
                bundle2.putInt("mExtraOrientation", i);
                bundle2.putString("mViewType", this.R);
                this.mPk.setArguments(bundle2);
            }
            beginTransaction2.add(a.f.fl_fragment, this.mPk);
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
        if (this.mPk != null) {
            this.mPk.mUu = null;
        }
        if (this.mPg != null) {
            this.mPg.release();
            this.mPg = null;
            this.K = false;
        }
        if (this.mPh != null) {
            this.mPh.release();
            this.mPh = null;
        }
        if (this.mPi != null) {
            this.mPi.release();
            this.mPi = null;
        }
        if (this.mPj != null) {
            this.mPj.c();
        }
        this.d = false;
        this.e = false;
        this.M = false;
        this.mPj = new c();
        this.mPh = this.mPj.dCI();
        this.mPh.setOnActivityCallBack(this.mPU);
        this.mPi = this.mPj.dCJ();
        this.mPi.setOnActivityCallBack(this.mPV);
        if (!this.d) {
            this.mPg = this.mPh;
        } else {
            this.mPg = this.mPi;
        }
        if (this.mPk != null) {
            this.mPk.mUu = this.mPg;
        }
    }

    public void j() {
        if (this.mPg != null) {
            this.mPg.pause();
            this.mPg.stop();
            this.mPg.release();
            this.mPg = null;
        }
        if (this.mPh != null) {
            this.mPh.stop();
            this.mPh.release();
            this.mPh = null;
        }
        if (this.mPi != null) {
            this.mPi.stop();
            this.mPi.release();
            this.mPi = null;
        }
        if (this.mPj != null) {
            this.mPj.c();
        }
    }

    public void k() {
        tv.chushou.common.player.a aVar = this.mPg;
        if (aVar != null) {
            aVar.pause();
            aVar.stop();
        }
        tv.chushou.common.player.a aVar2 = this.mPh;
        if (aVar2 != null) {
            aVar2.stop();
        }
        tv.chushou.common.player.a aVar3 = this.mPi;
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
    public void cXu() {
        if (this.mPR) {
            if (this.mPk != null) {
                this.mPk.s();
            }
        } else if (this.mPQ != null) {
            this.mPQ.a(this.mPQ.Oh(3), 20L);
        }
    }

    private void b(final String str, String str2) {
        com.kascend.chushou.c.c.dBQ().a(new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.VideoPlayer.8
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
                    VideoPlayer.this.dCo().a(fullRoomInfo.mBangMap);
                    if (h.isEmpty(fullRoomInfo.mRoominfo.mRoomID)) {
                        fullRoomInfo.mRoominfo.mRoomID = VideoPlayer.this.P;
                    }
                    if (!h.isEmpty(fullRoomInfo.mGeneralTabGifts)) {
                        com.kascend.chushou.d.e.a(VideoPlayer.this.mPN, new ArrayList(fullRoomInfo.mGeneralTabGifts));
                    }
                    if (VideoPlayer.this.mPo != null) {
                        VideoPlayer.this.mPo.a(fullRoomInfo);
                    }
                    VideoPlayer.this.L = false;
                    if (VideoPlayer.this.B) {
                        if (VideoPlayer.this.C && !"3".equals(VideoPlayer.this.R) && fullRoomInfo != null && fullRoomInfo.mRoominfo != null && fullRoomInfo.mRoominfo.mStyle == 1 && !h.isEmpty(fullRoomInfo.mRoominfo.mGameId)) {
                            z = true;
                        }
                        if (!z) {
                            if (VideoPlayer.this.mPk != null) {
                                VideoPlayer.this.mPk.a(VideoPlayer.this.mPo);
                            }
                            if (!h.isEmpty(fullRoomInfo.mRoominfo.mGameId)) {
                                VideoPlayer.this.cXu();
                            } else {
                                if (VideoPlayer.this.mPo != null) {
                                    VideoPlayer.this.mPo.f = null;
                                }
                                VideoPlayer.this.cXu();
                            }
                        } else {
                            VideoPlayer.this.a(1, "1", true);
                            if (VideoPlayer.this.mPk != null) {
                                VideoPlayer.this.mPk.a(VideoPlayer.this.mPo);
                            }
                        }
                    } else {
                        if (h.isEmpty(fullRoomInfo.mRoominfo.mGameId)) {
                            if (VideoPlayer.this.mPo != null) {
                                VideoPlayer.this.mPo.f = null;
                            }
                            VideoPlayer.this.a(1, "1");
                        } else {
                            VideoPlayer.this.a(1, "1", true);
                        }
                        if (VideoPlayer.this.mPk != null) {
                            VideoPlayer.this.mPk.a(VideoPlayer.this.mPo);
                        }
                    }
                    if (VideoPlayer.this.mPo != null && !VideoPlayer.this.mPo.m()) {
                        if (VideoPlayer.this.mPy != null) {
                            VideoPlayer.this.mPy.d();
                            VideoPlayer.this.mPy = null;
                        }
                        VideoPlayer.this.mPy = new com.kascend.chushou.toolkit.d(900000L, VideoPlayer.this.mPA, VideoPlayer.this.mPQ);
                        VideoPlayer.this.mPy.a();
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
        if (this.mPo != null) {
            this.mPo.a((FullRoomInfo) null);
        }
        this.L = false;
        bN(str, i);
        if (this.mPg != null) {
            this.mPg.stop();
        }
        if (this.mPh != null) {
            this.mPh.stop();
        }
        if (this.mPi != null) {
            this.mPi.stop();
        }
    }

    public void l() {
        tv.chushou.zues.utils.e.d(this.v, "retryGetPlayList");
        c();
        if (ol()) {
            aO(this.P, false);
        } else {
            a(this.P, dCq(), false);
        }
    }

    public void m() {
        a(this.mPC, false);
    }

    private void a(final String str, String str2, boolean z) {
        this.J = true;
        VideoPlayInfo N = j.dBZ().N(str + str2, KeepJobService.JOB_CHECK_PERIODIC);
        if (N != null) {
            a((ArrayList) N.mPlayUrls);
            this.J = false;
        } else if (z) {
            ParserRet fu = com.kascend.chushou.player.c.a.dCK().fu(str, str2);
            if (fu.mRc != 0) {
                tv.chushou.zues.utils.e.e(this.v, "getPlayUrlSync fail, try to getPlaylist");
                a(str, str2, false);
                return;
            }
            a(fu, str);
        } else {
            com.kascend.chushou.player.c.a.dCK().a(str, str2, new a.InterfaceC0695a() { // from class: com.kascend.chushou.player.VideoPlayer.9
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
        VideoPlayInfo O = j.dBZ().O(str, KeepJobService.JOB_CHECK_PERIODIC);
        if (O != null) {
            a((ArrayList) O.mPlayUrls);
            this.J = false;
            return;
        }
        if (!h.isEmpty(this.mPC)) {
            try {
                equals = "1".equals(new JSONObject(this.mPC).optString("auto"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (!z) {
                ParserRet aP = com.kascend.chushou.player.c.a.dCK().aP(str, equals);
                if (aP.mRc != 0) {
                    tv.chushou.zues.utils.e.e(this.v, "getVideoPlayUrlSync fail, try to getVideoPlaylist");
                    aO(str, false);
                    return;
                }
                a(aP, str);
                return;
            }
            com.kascend.chushou.player.c.a.dCK().a(str, new a.InterfaceC0695a() { // from class: com.kascend.chushou.player.VideoPlayer.10
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
                if (this.mPo.f == null) {
                    this.mPo.f = new ArrayList<>();
                }
                this.mPo.f.clear();
                this.mPo.f.addAll(arrayList);
                if ("1".equals(this.R)) {
                    j.dBZ().a(str + dCq(), arrayList);
                } else {
                    j.dBZ().s(str, arrayList);
                }
                a(arrayList);
                return;
            }
            if (this.mPo != null) {
                this.mPo.f = null;
            }
            if (this.mPQ != null) {
                Message Oh = this.mPQ.Oh(5);
                Oh.arg1 = 2;
                Oh.arg2 = parserRet.mRc;
                this.mPQ.O(Oh);
            }
        }
    }

    private void bN(String str, int i) {
        s();
        if (this.mPt != null) {
            this.mPt.a();
        }
        if (h.isEmpty(str)) {
            str = getString(a.i.str_load_data_failed);
        }
        a(str, i);
    }

    public void n() {
        if (this.mPw != null && this.aUB != null && this.mPx != null) {
            this.mPw.setVisibility(0);
            this.aUB.setVisibility(8);
            this.mPx.setVisibility(8);
        }
    }

    public void o() {
        if (this.mPD != null && this.mPD.getVisibility() == 0) {
            this.mPD.xo(0);
            this.mPD.setVisibility(8);
        }
    }

    public void p() {
        if (this.mPE != null && this.mPE.getVisibility() == 0) {
            this.mPE.setVisibility(8);
        }
    }

    public void q() {
        this.mPR = true;
    }

    protected void r() {
        this.mPw.setVisibility(8);
        this.mPx.setVisibility(0);
        this.aUB.setVisibility(0);
        if (this.mPs != null) {
            this.mPq.setVisibility(8);
            this.mPs.setVisibility(0);
            this.mPr.setText(getString(a.i.str_dialog_loading_content));
            this.mPr.setVisibility(8);
        }
    }

    protected void a(String str, int i) {
        this.mPw.setVisibility(8);
        this.mPx.setVisibility(0);
        this.aUB.setVisibility(0);
        if (this.mPs != null) {
            if (str == null) {
                str = getString(a.i.str_nodata);
            }
            if (str != null) {
                this.mPr.setText(str);
                if (str.equals(getString(a.i.s_no_available_network))) {
                    this.mPq.setImageResource(a.e.commonres_pagestatus_net_error);
                } else if (str.equals(getString(a.i.str_nodata)) || str.equals(getString(a.i.str_nohistory)) || str.equals(getString(a.i.str_nolive)) || str.equals(getString(a.i.str_nosubscribe))) {
                    this.mPq.setClickable(true);
                    this.mPq.setImageResource(a.e.commonres_pagestatus_empty);
                } else if (str.equals(getString(a.i.str_inbox_login_notify)) || str.equals(getString(a.i.push_login)) || str.equals(getString(a.i.str_login_timeout))) {
                    this.mPq.setImageResource(a.e.commonres_pagestatus_need_login);
                    this.mPq.setClickable(true);
                } else {
                    this.mPq.setImageResource(a.e.commonres_pagestatus_unknown_error);
                    this.mPq.setClickable(true);
                }
            }
            if (i == 4001) {
                this.mPq.setImageResource(a.e.commonres_pagestatus_net_error);
                this.mPq.setClickable(false);
                this.mPr.setVisibility(0);
                this.mPr.setText(getString(a.i.str_dissubscribe_btn));
                this.mPr.setOnClickListener(new View.OnClickListener() { // from class: com.kascend.chushou.player.VideoPlayer.11
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (!VideoPlayer.this.j) {
                            com.kascend.chushou.c.c.dBQ().b(new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.VideoPlayer.11.1
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
                            }, VideoPlayer.this.P, (String) null, VideoPlayer.this.mPo.h);
                        }
                    }
                });
            } else if (i == 404) {
                this.mPr.setText(str);
                this.mPr.setVisibility(0);
                this.mPq.setClickable(false);
                this.mPq.setImageResource(a.e.commonres_pagestatus_empty);
            } else if (i == 4002) {
                if (h.isEmpty(str)) {
                    this.mPr.setVisibility(8);
                } else {
                    this.mPr.setVisibility(0);
                    this.mPr.setText(str);
                }
            } else {
                this.mPr.setVisibility(8);
            }
            this.mPq.setVisibility(0);
            this.mPs.setVisibility(8);
            this.mPE.setVisibility(8);
        }
    }

    public void s() {
        if (this.mPQ != null) {
            this.mPQ.removeMessages(1);
        }
    }

    private void a(ArrayList<PlayUrl> arrayList) {
        boolean z;
        if (this.mPo.f == null) {
            this.mPo.f = new ArrayList<>();
        }
        this.mPo.f.clear();
        this.mPo.f.addAll(arrayList);
        if (com.kascend.chushou.d.e.b() && !"4".equals(this.aq)) {
            int c = com.kascend.chushou.d.e.c();
            if (c == -1) {
                b(arrayList);
                return;
            } else if (this.mPS) {
                this.mPS = false;
                if (c == 0) {
                    this.mPo.d = false;
                    f(arrayList, true);
                    return;
                }
                if (this.mPo != null && this.mPo.f != null) {
                    Iterator<PlayUrl> it = this.mPo.f.iterator();
                    while (it.hasNext()) {
                        if ("2".equals(it.next().mType)) {
                            z = true;
                            break;
                        }
                    }
                }
                z = false;
                this.mPo.d = z;
                f(arrayList, true);
                return;
            } else {
                if (this.mPo.e) {
                    this.mPo.d = !this.mPo.d;
                    this.mPo.e = false;
                    this.mPT = true;
                } else if ("4".equals(this.aq)) {
                    this.mPo.d = true;
                }
                f(arrayList, true);
                return;
            }
        }
        if (this.mPo.e) {
            this.mPo.d = !this.mPo.d;
            this.mPo.e = false;
            this.mPT = true;
        } else if ("4".equals(this.aq)) {
            this.mPo.d = true;
        }
        f(arrayList, true);
    }

    private void b(ArrayList<PlayUrl> arrayList) {
        if ("1".equals(this.R)) {
            if ("2".equals(this.mPL)) {
                d(false, arrayList);
            } else if (this.mPk != null) {
                this.mPk.f(arrayList, false);
            }
        } else if (this.mPk != null) {
            this.mPk.f(arrayList, false);
        }
    }

    public void b(boolean z) {
        this.mPo.d = false;
        com.kascend.chushou.d.e.a(0);
        ArrayList<PlayUrl> arrayList = this.mPo.f;
        if (!h.isEmpty(arrayList)) {
            if (z) {
                f(arrayList, false);
                if (this.mPQ != null) {
                    this.mPQ.Of(2);
                    return;
                }
                return;
            }
            f(arrayList, true);
        }
    }

    public void c(boolean z) {
        this.mPo.d = true;
        com.kascend.chushou.d.e.a(1);
        ArrayList<PlayUrl> arrayList = this.mPo.f;
        if (!h.isEmpty(arrayList)) {
            if (z) {
                f(arrayList, false);
                if (this.mPQ != null) {
                    this.mPQ.Of(2);
                    return;
                }
                return;
            }
            f(arrayList, true);
        }
    }

    @Subscribe
    public void onNotifyEvent(com.kascend.chushou.b.a.a.j jVar) {
        if (!isFinishing() && jVar.a == 1 && !"5".equals(this.R) && !dCb()) {
            tv.chushou.zues.utils.e.d(this.v, "onNetworkChangeEvent 3G=" + com.kascend.chushou.b.dBN().b + "  wifi=" + com.kascend.chushou.b.dBN().a);
            if (com.kascend.chushou.d.e.b() && !"4".equals(this.aq)) {
                if (com.kascend.chushou.d.e.c() == -1) {
                    if (this.mPk != null) {
                        this.mPk.e(false);
                    }
                    if ("1".equals(this.R)) {
                        if ("2".equals(this.mPL)) {
                            d(true, null);
                            return;
                        } else if (this.mPk != null) {
                            this.mPk.f(this.mPo.f, true);
                            return;
                        } else {
                            return;
                        }
                    } else if (this.mPk != null) {
                        this.mPk.f(this.mPo.f, true);
                        return;
                    } else {
                        return;
                    }
                }
                RxExecutor.postDelayed(this.mPN, EventThread.MAIN_THREAD, 10L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.VideoPlayer.12
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!VideoPlayer.this.isFinishing() && com.kascend.chushou.b.dBN().b && !com.kascend.chushou.b.dBN().a) {
                            tv.chushou.zues.utils.g.c(VideoPlayer.this.w, VideoPlayer.this.getString(a.i.str_monet_notify));
                        }
                    }
                });
            } else if (com.kascend.chushou.b.dBN().a || com.kascend.chushou.b.dBN().b) {
                t();
                if (this.mPQ != null) {
                    this.mPQ.Of(2);
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
            if (this.mPo.d) {
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
            String d = com.kascend.chushou.d.h.dBU().d();
            String str3 = h.isEmpty(d) ? "2" : d;
            if (this.mPo.d) {
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
                if (this.mPo != null) {
                    this.mPo.a(playUrl2);
                    if (this.mPQ != null) {
                        Message Oh = this.mPQ.Oh(5);
                        Oh.arg1 = 1;
                        this.mPQ.O(Oh);
                    }
                }
                String b = com.kascend.chushou.player.c.a.b(playUrl2);
                if (!h.isEmpty(b)) {
                    this.mPf = Uri.parse(b);
                    if (this.mPT) {
                        this.mPT = false;
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (z && this.mPg != null) {
                        a(false, z2);
                    }
                }
            }
        }
    }

    public void d(final boolean z, ArrayList<PlayUrl> arrayList) {
        if (this.mPz == null || this.mPz.a <= 0) {
            this.mPz = com.kascend.chushou.view.b.a.a.dEo();
            this.mPz.a(new a.InterfaceC0714a() { // from class: com.kascend.chushou.player.VideoPlayer.13
                @Override // com.kascend.chushou.view.b.a.a.InterfaceC0714a
                public void a(int i) {
                    if (i == a.f.tv_play_video) {
                        VideoPlayer.this.mPz.dismissAllowingStateLoss();
                        VideoPlayer.this.b(z);
                    } else if (i == a.f.tv_play_audio) {
                        VideoPlayer.this.mPz.dismissAllowingStateLoss();
                        VideoPlayer.this.c(z);
                    } else if (i == a.f.iv_close) {
                        VideoPlayer.this.finish();
                    } else {
                        if (i == a.f.tv_union_proxy) {
                        }
                    }
                }
            });
            this.mPz.show(getSupportFragmentManager(), "showRoom");
        }
    }

    public void t() {
        if (this.mPz != null) {
            this.mPz.dismissAllowingStateLoss();
        }
        if (this.mPk != null) {
            this.mPk.v();
        }
    }

    public void u() {
        com.kascend.chushou.c.c.dBQ().c(this.P, new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.VideoPlayer.16
            @Override // com.kascend.chushou.c.b
            public void a() {
            }

            @Override // com.kascend.chushou.c.b
            public void a(String str, JSONObject jSONObject) {
                if (!VideoPlayer.this.isFinishing()) {
                    ParserRet dA = com.kascend.chushou.c.e.dA(jSONObject);
                    if (dA.mRc == 0 && dA.mData != null) {
                        CycleLiveRoomInfo cycleLiveRoomInfo = (CycleLiveRoomInfo) dA.mData;
                        if (VideoPlayer.this.mPo != null && cycleLiveRoomInfo != null && !h.isEmpty(cycleLiveRoomInfo.roomId)) {
                            FullRoomInfo dCE = VideoPlayer.this.mPo.dCE();
                            if (dCE.cycleLiveRoomInfo == null) {
                                dCE.cycleLiveRoomInfo = cycleLiveRoomInfo;
                                VideoPlayer.this.d();
                            } else if (dCE.cycleLiveRoomInfo != null && !cycleLiveRoomInfo.roomId.equals(dCE.cycleLiveRoomInfo.roomId)) {
                                dCE.cycleLiveRoomInfo.copyCycleLiveRoomInfo(cycleLiveRoomInfo);
                                VideoPlayer.this.d();
                            } else {
                                dCE.cycleLiveRoomInfo.copyCycleLiveRoomInfo(cycleLiveRoomInfo);
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
        if (this.mPk != null) {
            this.mPk.N();
        }
    }

    public void v() {
        com.kascend.chushou.c.c.dBQ().a(this.P, new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.VideoPlayer.17
            @Override // com.kascend.chushou.c.b
            public void a() {
            }

            @Override // com.kascend.chushou.c.b
            public void a(String str, JSONObject jSONObject) {
                if (!VideoPlayer.this.isFinishing()) {
                    ParserRet dB = com.kascend.chushou.c.e.dB(jSONObject);
                    if (dB.mRc == 0 && dB.mData != null) {
                        PkNotifyInfo pkNotifyInfo = (PkNotifyInfo) dB.mData;
                        VideoPlayer.this.mPJ.b = VideoPlayer.this.P;
                        if (pkNotifyInfo != null) {
                            VideoPlayer.this.mPJ.mUv = pkNotifyInfo;
                            if (VideoPlayer.this.mPk != null) {
                                VideoPlayer.this.mPk.a(pkNotifyInfo, VideoPlayer.this.P);
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
        if (this.mPp != null) {
            this.mPp.release();
            this.mPp = null;
        }
        com.kascend.chushou.c.c.dBQ().a(this.P, new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.VideoPlayer.18
            @Override // com.kascend.chushou.c.b
            public void a() {
            }

            @Override // com.kascend.chushou.c.b
            public void a(String str, JSONObject jSONObject) {
                if (!VideoPlayer.this.isFinishing()) {
                    ParserRet dC = com.kascend.chushou.c.e.dC(jSONObject);
                    if (dC.mRc == 0 && dC.mData != null) {
                        RoomExpandInfo roomExpandInfo = (RoomExpandInfo) dC.mData;
                        if (VideoPlayer.this.mPo != null) {
                            VideoPlayer.this.mPo.mQT = roomExpandInfo.mTopWebAdItem;
                            if (VideoPlayer.this.mPo.s == null) {
                                VideoPlayer.this.mPo.s = new ArrayList();
                            }
                            VideoPlayer.this.mPo.s.clear();
                            VideoPlayer.this.mPo.s.addAll(roomExpandInfo.mGiftTopRightIcons);
                            tv.chushou.zues.a.a.post(new i(50, VideoPlayer.this.mPo.mQT));
                        }
                        if (VideoPlayer.this.mPo != null) {
                            VideoPlayer.this.mPo.fm(roomExpandInfo.mExpandNavList);
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
                            VideoPlayer.this.mPF.a(list);
                        }
                        List<com.kascend.chushou.player.ui.h5.c.c> list2 = roomExpandInfo.mLuckList;
                        if (!h.isEmpty(list2)) {
                            VideoPlayer.this.mPG.a(list2);
                        }
                        com.kascend.chushou.player.ui.h5.c.c cVar = roomExpandInfo.mVoteItem;
                        if (cVar != null) {
                            VideoPlayer.this.mPH.a(cVar);
                        }
                        List<com.kascend.chushou.player.ui.h5.c.b> list3 = roomExpandInfo.mInteractH5Item;
                        if (!h.isEmpty(list3)) {
                            VideoPlayer.this.mPK.a(list3);
                        }
                        List<com.kascend.chushou.player.ui.h5.c.b> list4 = roomExpandInfo.mInteractNavItem;
                        if (!h.isEmpty(list4)) {
                            VideoPlayer.this.mPK.a(list4);
                        }
                        VideoPlayer.this.mPp = (PrivilegeInfo) dC.mData1;
                        if (VideoPlayer.this.mPp != null) {
                            tv.chushou.zues.a.a.post(new l());
                        }
                        if (VideoPlayer.this.mPo != null) {
                            VideoPlayer.this.mPo.mQZ = roomExpandInfo.mIconConfig;
                            VideoPlayer.this.dCo().a(roomExpandInfo.mIconConfig.bangConfig);
                        }
                        List<SkinConfig> list5 = roomExpandInfo.skinConfig;
                        if (list5 != null && VideoPlayer.this.mPo != null) {
                            VideoPlayer.this.mPo.mRe.clear();
                            int i = 0;
                            while (true) {
                                int i2 = i;
                                if (i2 >= list5.size()) {
                                    break;
                                }
                                SkinConfig skinConfig = list5.get(i2);
                                VideoPlayer.this.mPo.mRe.put(skinConfig.position, skinConfig.resource);
                                i = i2 + 1;
                            }
                            VideoPlayer.this.C();
                        }
                        VideoPlayer.this.a(roomExpandInfo.mIconConfig, VideoPlayer.this.mPo != null ? VideoPlayer.this.mPo.mRe : null);
                        if (roomExpandInfo.mColorMap != null && roomExpandInfo.mColorMap.size() > 0 && com.kascend.chushou.b.dBN().c != null && com.kascend.chushou.b.dBN().c.size() <= 0) {
                            com.kascend.chushou.b.dBN().c.putAll(roomExpandInfo.mColorMap);
                            tv.chushou.zues.a.a.post(new i(52, null));
                        }
                        AutoBang autoBang = roomExpandInfo.mAutoBang;
                        if (autoBang != null && autoBang.currentTime != 0 && autoBang.bangTime != 0) {
                            VideoPlayer.this.dCo().a(autoBang);
                        }
                        if (!h.isEmpty(roomExpandInfo.mRelatedRoomList) && VideoPlayer.this.mPo != null) {
                            VideoPlayer.this.mPo.t = roomExpandInfo.mRelatedRoomList;
                            if (VideoPlayer.this.mPk != null && VideoPlayer.this.H) {
                                VideoPlayer.this.mPk.w();
                            }
                        }
                        if (roomExpandInfo.mRoomNewUserInfo != null && roomExpandInfo.mRoomNewUserInfo.mBarrierNoviceGuide && !com.kascend.chushou.d.h.dBU().k() && VideoPlayer.this.mPk != null) {
                            VideoPlayer.this.mPk.J();
                        }
                        if (roomExpandInfo.mRoomNewUserInfo != null && roomExpandInfo.mRoomNewUserInfo.mRewardNoviceGuide && !com.kascend.chushou.d.h.dBU().l() && VideoPlayer.this.mPk != null) {
                            VideoPlayer.this.mPk.K();
                        }
                        if (!h.isEmpty(roomExpandInfo.mShopWindowInfos)) {
                            if (VideoPlayer.this.mPo != null) {
                                if (VideoPlayer.this.mPo.mRa == null) {
                                    VideoPlayer.this.mPo.mRa = new ArrayList();
                                }
                                VideoPlayer.this.mPo.mRa.addAll(roomExpandInfo.mShopWindowInfos);
                            }
                            if (VideoPlayer.this.mPk != null) {
                                VideoPlayer.this.mPk.L();
                            }
                        }
                        VideoPlayer.this.mPJ.b = VideoPlayer.this.P;
                        if (roomExpandInfo.mPkNotifyInfo != null) {
                            VideoPlayer.this.mPJ.mUv = roomExpandInfo.mPkNotifyInfo;
                            if (VideoPlayer.this.mPk != null) {
                                VideoPlayer.this.mPk.a(roomExpandInfo.mPkNotifyInfo, VideoPlayer.this.P);
                            }
                        } else {
                            VideoPlayer.this.mPJ.mUv = null;
                        }
                        if (roomExpandInfo.mTrumpetPocket != null && VideoPlayer.this.mPo != null) {
                            VideoPlayer.this.mPo.mRd = roomExpandInfo.mTrumpetPocket;
                            if (VideoPlayer.this.mPk != null) {
                                VideoPlayer.this.mPk.M();
                            }
                        }
                        if (!h.isEmpty(roomExpandInfo.hotwordContentList)) {
                            if (VideoPlayer.this.mPo != null) {
                                if (VideoPlayer.this.mPo.mRb == null) {
                                    VideoPlayer.this.mPo.mRb = new ArrayList();
                                }
                                VideoPlayer.this.mPo.mRb.clear();
                                VideoPlayer.this.mPo.mRb.addAll(roomExpandInfo.hotwordContentList);
                            }
                            if (VideoPlayer.this.mPk != null) {
                                VideoPlayer.this.mPk.b(roomExpandInfo.hotwordContentList);
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
        }, this.mPC, this.mPL);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U() {
        if (!h.isEmpty(com.kascend.chushou.a.a.dBO().z)) {
            StringBuilder sb = new StringBuilder();
            if (com.kascend.chushou.a.a.dBO().z.contains(com.kascend.chushou.a.a.f)) {
                if (sb.length() > 0) {
                    sb.append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                sb.append(com.kascend.chushou.a.a.f);
            }
            if (com.kascend.chushou.a.a.dBO().z.contains(com.kascend.chushou.a.a.g)) {
                if (sb.length() > 0) {
                    sb.append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                sb.append(com.kascend.chushou.a.a.g);
            }
            if (com.kascend.chushou.a.a.dBO().z.contains(com.kascend.chushou.a.a.i)) {
                if (sb.length() > 0) {
                    sb.append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                sb.append(com.kascend.chushou.a.a.i);
            }
            if (com.kascend.chushou.a.a.dBO().z.contains(com.kascend.chushou.a.a.h)) {
                if (sb.length() > 0) {
                    sb.append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                sb.append(com.kascend.chushou.a.a.h);
            }
            if (com.kascend.chushou.a.a.dBO().z.contains(com.kascend.chushou.a.a.j)) {
                if (sb.length() > 0) {
                    sb.append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                sb.append(com.kascend.chushou.a.a.j);
            }
            if (com.kascend.chushou.a.a.dBO().z.contains(com.kascend.chushou.a.a.l)) {
                if (sb.length() > 0) {
                    sb.append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                sb.append(com.kascend.chushou.a.a.l);
            }
            if (com.kascend.chushou.a.a.dBO().z.contains(com.kascend.chushou.a.a.m)) {
                if (sb.length() > 0) {
                    sb.append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                sb.append(com.kascend.chushou.a.a.m);
            }
            if (sb.length() != 0) {
                com.kascend.chushou.a.a.dBO().a(sb.toString(), this.P, new a.c() { // from class: com.kascend.chushou.player.VideoPlayer.19
                    @Override // com.kascend.chushou.a.a.c
                    public void a(List<ListItem> list) {
                        if (VideoPlayer.this.mPo != null && list != null) {
                            int i = 0;
                            while (true) {
                                int i2 = i;
                                if (i2 >= list.size()) {
                                    break;
                                }
                                if (list.get(i2).mAdExtraInfo != null) {
                                    if (com.kascend.chushou.a.a.f.equals(list.get(i2).mAdExtraInfo.mCode)) {
                                        VideoPlayer.this.mPo.mQS = list.get(i2);
                                    } else if (com.kascend.chushou.a.a.g.equals(list.get(i2).mAdExtraInfo.mCode)) {
                                        VideoPlayer.this.mPo.mQR = list.get(i2);
                                    } else if (com.kascend.chushou.a.a.i.equals(list.get(i2).mAdExtraInfo.mCode)) {
                                        VideoPlayer.this.mPo.mQU = list.get(i2);
                                    } else if (com.kascend.chushou.a.a.h.equals(list.get(i2).mAdExtraInfo.mCode)) {
                                        VideoPlayer.this.mPo.mQV = list.get(i2);
                                    } else if (com.kascend.chushou.a.a.j.equals(list.get(i2).mAdExtraInfo.mCode)) {
                                        VideoPlayer.this.mPo.mQY = list.get(i2);
                                    } else if (com.kascend.chushou.a.a.l.equals(list.get(i2).mAdExtraInfo.mCode)) {
                                        VideoPlayer.this.mPo.mQW = list.get(i2);
                                    } else if (com.kascend.chushou.a.a.m.equals(list.get(i2).mAdExtraInfo.mCode)) {
                                        VideoPlayer.this.mPo.mQX = list.get(i2);
                                    }
                                }
                                i = i2 + 1;
                            }
                            if (VideoPlayer.this.mPk != null) {
                                VideoPlayer.this.mPk.H();
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
        if (Build.VERSION.SDK_INT >= 11 && this.mPv != null) {
            if (!z) {
                if (Build.VERSION.SDK_INT >= 19) {
                    i = 5894;
                } else {
                    i = 1799;
                }
                this.mPv.setSystemUiVisibility(i);
                return;
            }
            this.mPv.setSystemUiVisibility(1792);
        }
    }

    public void e(boolean z) {
        Window window;
        View decorView;
        if (com.kascend.chushou.b.dBN().d != 1 && (window = getWindow()) != null && (decorView = window.getDecorView()) != null) {
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
        if (this.mPk != null) {
            this.mPk.a(i, i2, intent);
        }
    }

    public Uri dCh() {
        return this.mPf;
    }

    @Override // com.kascend.chushou.view.base.BaseActivity
    protected int y() {
        return 0;
    }

    public void wh(boolean z) {
        if (this.mPv != null) {
            this.mPv.nZI = z;
        }
    }

    public void dCi() {
        if (this.mPv != null) {
            this.mPv.dCi();
        }
    }

    public boolean dCj() {
        return this.ae;
    }

    public void f(boolean z) {
        this.ae = z;
    }

    public void g(boolean z) {
        if (this.mPv != null) {
            this.mPv.setIsTranslucentStatus(z);
        }
    }

    public void z() {
        if (this.mPv != null) {
            this.mPv.dQQ();
        }
    }

    @Override // com.kascend.chushou.widget.gifts.RoomSendGiftView.a
    public void A() {
        if (this.mPt != null) {
            this.mPt.b();
        }
    }

    @Override // com.kascend.chushou.widget.gifts.RoomSendGiftView.a
    public void B() {
        if (this.mPt != null) {
            this.mPt.b();
        }
    }

    public void a(List<ListItem> list) {
        if (this.mPk != null) {
            this.mPk.a(list);
        }
    }

    public void a(IconConfig iconConfig, Map<String, SkinConfig.SkinRes> map) {
        if (this.mPk != null) {
            this.mPk.a(iconConfig, map);
        }
    }

    public void C() {
        if (this.mPk != null) {
            this.mPk.I();
        }
    }

    @Override // com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC0706a
    public void a(int i) {
        if (this.mPk != null) {
            this.mPk.a(i);
        }
    }

    @Override // com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC0706a
    public void D() {
        if (!isFinishing() && this.mPk != null) {
            this.mPk.D();
        }
    }

    @Override // com.kascend.chushou.player.ui.h5.b.b.a
    public void a(long j) {
        if (!isFinishing() && this.mPk != null) {
            this.mPk.a(j);
        }
    }

    @Override // com.kascend.chushou.player.ui.h5.b.b.a
    public void a(com.kascend.chushou.player.ui.h5.c.a aVar) {
        if (aVar != null && this.mPk != null) {
            this.mPk.a(aVar);
        }
    }

    @Override // com.kascend.chushou.player.ui.h5.b.b.a
    public void b(int i) {
        if (this.mPk != null) {
            this.mPk.b(i);
        }
    }

    @Override // com.kascend.chushou.player.ui.h5.d.a.InterfaceC0705a
    public void b(long j) {
        if (!isFinishing() && this.mPk != null) {
            this.mPk.b(j);
        }
    }

    @Override // com.kascend.chushou.player.ui.h5.a.a.InterfaceC0703a
    public void c(int i) {
        if (!isFinishing() && this.mPk != null) {
            this.mPk.c(i);
        }
    }

    @Override // com.kascend.chushou.player.ui.h5.d.a.InterfaceC0705a
    public void b(com.kascend.chushou.player.ui.h5.c.a aVar) {
        if (aVar != null && this.mPk != null) {
            this.mPk.b(aVar);
        }
    }

    @Override // com.kascend.chushou.player.ui.a.a.InterfaceC0700a
    public void a(IconConfig.Config config) {
        if (this.mPk != null) {
            this.mPk.a(config);
        }
    }

    @Override // com.kascend.chushou.player.ui.a.a.InterfaceC0700a
    public void a(BangInfo bangInfo, String str) {
        if (this.mPk != null) {
            this.mPk.a(bangInfo, str);
        }
    }

    @Override // com.kascend.chushou.player.ui.a.a.InterfaceC0700a
    public void a(long j, BangInfo bangInfo, String str) {
        if (this.mPk != null) {
            this.mPk.a(j, bangInfo, str);
        }
    }

    public com.kascend.chushou.player.ui.h5.redpacket.a dCk() {
        return this.mPF;
    }

    public com.kascend.chushou.player.ui.h5.b.b dCl() {
        return this.mPG;
    }

    public com.kascend.chushou.player.ui.h5.d.a dCm() {
        return this.mPH;
    }

    public com.kascend.chushou.player.ui.h5.a.a dCn() {
        return this.mPK;
    }

    public com.kascend.chushou.player.ui.a.a dCo() {
        return this.mPI;
    }

    public com.kascend.chushou.player.e.a dCp() {
        return this.mPJ;
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
        RxExecutor.postDelayed(this.mPN, EventThread.MAIN_THREAD, aVar.d, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.VideoPlayer.2
            @Override // java.lang.Runnable
            public void run() {
                if (VideoPlayer.this.mPk != null) {
                    VideoPlayer.this.mPk.c(aVar);
                }
            }
        });
    }

    private void e(final com.kascend.chushou.player.ui.h5.c.a aVar) {
        if (!com.kascend.chushou.d.h.dBU().dBX().contains(aVar.b)) {
            if (aVar.d < 0) {
                aVar.d = 0;
            }
            RxExecutor.postDelayed(this.mPN, EventThread.MAIN_THREAD, aVar.d, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.VideoPlayer.3
                @Override // java.lang.Runnable
                public void run() {
                    if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.mPk != null) {
                        VideoPlayer.this.mPk.c(aVar);
                    }
                }
            });
        }
    }

    private String dCq() {
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
                if (VideoPlayer.this.mPu != null && !VideoPlayer.this.isFinishing()) {
                    VideoPlayer.n = VideoPlayer.this.mPu.getStreamVolume(3);
                }
                if (!VideoPlayer.this.isFinishing() && (VideoPlayer.this.mPk instanceof f)) {
                    ((f) VideoPlayer.this.mPk).ab();
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

    public boolean dCr() {
        if (this.mPk instanceof com.kascend.chushou.player.d.a) {
            return ((com.kascend.chushou.player.d.a) this.mPk).dDx();
        }
        if (this.mPk instanceof com.kascend.chushou.player.e.e) {
            return true;
        }
        return false;
    }
}

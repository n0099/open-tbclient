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
public class VideoPlayer extends BaseActivity implements a.InterfaceC0701a, a.InterfaceC0704a, b.a, a.InterfaceC0706a, a.InterfaceC0707a, RoomSendGiftView.a {
    private static int A = 60000;
    public static String a = null;
    public static int n = 0;
    private String P;
    private String Q;
    private String R;
    private String S;
    private ImageView Z;
    private String ab;
    public com.kascend.chushou.player.feedback.a mRE;
    private a mRG;
    private CSTVWifiReceiver mRH;
    private c mRd;
    b mRg;
    public PrivilegeInfo mRh;
    com.kascend.chushou.widget.a.b mRl;
    private KPSwitchRootRelativeLayout mRn;
    private FrameLayout mRo;
    private LinearLayout mRp;
    private com.kascend.chushou.toolkit.d mRq;
    com.kascend.chushou.view.b.a.a mRr;
    private String mRu;
    private FrescoThumbnailView mRv;
    private FrameLayout mRw;
    private boolean B = true;
    private boolean C = false;
    private Uri mQY = null;
    private tv.chushou.common.player.a mQZ = null;
    public tv.chushou.common.player.a mRa = null;
    public tv.chushou.common.player.a mRb = null;
    public boolean d = false;
    public boolean e = false;
    private e mRe = null;
    private boolean H = false;
    private com.kascend.chushou.view.user.b mRf = null;
    private boolean J = false;
    private boolean K = false;
    private boolean L = false;
    private boolean M = false;
    private long N = 0;
    private int O = 0;
    public boolean g = false;
    private ImageView mRi = null;
    private TextView mRj = null;
    private AnimationImageView mRk = null;
    private View aUP = null;
    public boolean j = false;
    public float k = 0.0f;
    public float l = 0.0f;
    public boolean m = false;
    public AudioManager mRm = null;
    private d.a mRs = new d.a() { // from class: com.kascend.chushou.player.VideoPlayer.1
        @Override // com.kascend.chushou.toolkit.d.a
        public void a() {
            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.mRI != null) {
                VideoPlayer.this.mRI.Ol(4);
            }
        }
    };
    private boolean ae = false;
    public boolean q = true;
    public long r = -1;
    public long s = -1;
    private PowerManager.WakeLock mRt = null;
    public String t = null;
    private final com.kascend.chushou.player.ui.h5.redpacket.a mRx = new com.kascend.chushou.player.ui.h5.redpacket.a(this);
    private final com.kascend.chushou.player.ui.h5.b.b mRy = new com.kascend.chushou.player.ui.h5.b.b(this);
    private final com.kascend.chushou.player.ui.h5.d.a mRz = new com.kascend.chushou.player.ui.h5.d.a(this);
    private final com.kascend.chushou.player.ui.a.a mRA = new com.kascend.chushou.player.ui.a.a(this);
    private final com.kascend.chushou.player.e.a mRB = new com.kascend.chushou.player.e.a();
    private final com.kascend.chushou.player.ui.h5.a.a mRC = new com.kascend.chushou.player.ui.h5.a.a(this);
    private String mRD = "1";
    private String aq = "2";
    private io.reactivex.disposables.a mRF = new io.reactivex.disposables.a();
    private tv.chushou.zues.c mRI = new tv.chushou.zues.c(new Handler.Callback() { // from class: com.kascend.chushou.player.VideoPlayer.6
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            try {
                if (!VideoPlayer.this.isFinishing()) {
                    switch (message.what) {
                        case 1:
                            VideoPlayer.this.mRI.removeMessages(1);
                            com.kascend.chushou.c.c.dCo().a(VideoPlayer.this.P, VideoPlayer.this.mRg != null ? VideoPlayer.this.mRg.h : null, System.currentTimeMillis());
                            VideoPlayer.this.mRI.K(1, VideoPlayer.A);
                            break;
                        case 2:
                            VideoPlayer.this.a(true, (Uri) null, false);
                            break;
                        case 3:
                            VideoPlayer.this.cXT();
                            break;
                        case 4:
                            if (VideoPlayer.this.mRe != null) {
                                VideoPlayer.this.mRe.a(true);
                            }
                            if (VideoPlayer.this.mRq != null) {
                                VideoPlayer.this.mRq.d();
                                VideoPlayer.this.mRq = null;
                                break;
                            }
                            break;
                        case 5:
                            int i = message.arg1;
                            if (i == 1) {
                                if (VideoPlayer.this.mRe != null) {
                                    VideoPlayer.this.mRe.p();
                                    break;
                                }
                            } else if (i == 2 && VideoPlayer.this.mRe != null) {
                                VideoPlayer.this.mRe.e(message.arg2);
                                break;
                            }
                            break;
                        case 6:
                            if (!com.kascend.chushou.b.dCl().a && !com.kascend.chushou.b.dCl().b && VideoPlayer.this.mRe != null) {
                                VideoPlayer.this.mRe.g(true);
                                break;
                            } else {
                                VideoPlayer.this.c();
                                break;
                            }
                            break;
                        case 7:
                            tv.chushou.zues.utils.e.d(VideoPlayer.this.v, "MSG_BUFFER_DEALY: ");
                            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.mRe != null && VideoPlayer.this.M && !VideoPlayer.this.e) {
                                VideoPlayer.this.mRe.h(true);
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
    private boolean mRJ = false;
    private boolean mRK = true;
    private boolean mRL = false;
    private tv.chushou.common.player.b mRM = new tv.chushou.common.player.b() { // from class: com.kascend.chushou.player.VideoPlayer.14
        @Override // tv.chushou.common.player.b
        public void dCS() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerACallback onSetVideoViewLayout");
            if (!VideoPlayer.this.isFinishing()) {
                if ((VideoPlayer.this.mRe == null || !VideoPlayer.this.mRe.H) && VideoPlayer.this.mRe != null && !VideoPlayer.this.d) {
                    VideoPlayer.this.mRe.y();
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void MO(int i) {
            if (!VideoPlayer.this.isFinishing()) {
                if ((VideoPlayer.this.mRe == null || !VideoPlayer.this.mRe.H) && VideoPlayer.this.mRe != null && !VideoPlayer.this.d) {
                    VideoPlayer.this.mRe.g(i);
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void dCT() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerACallback onCompletePlayback");
            if (!VideoPlayer.this.isFinishing()) {
                if (!h.isEmpty(VideoPlayer.this.P)) {
                    j.dCx().a(VideoPlayer.this.P, 0);
                }
                VideoPlayer.this.K = false;
                if (VideoPlayer.this.mRI != null) {
                    VideoPlayer.this.mRI.removeMessages(1);
                }
                if ((VideoPlayer.this.mRe == null || !VideoPlayer.this.mRe.H) && VideoPlayer.this.mRe != null && !VideoPlayer.this.d) {
                    VideoPlayer.this.mRI.removeMessages(7);
                    VideoPlayer.this.M = false;
                    VideoPlayer.this.mRe.z();
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void dCU() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerACallback onVideoRenderingStart");
            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.mRe != null) {
                VideoPlayer.this.mRe.G();
            }
        }

        @Override // tv.chushou.common.player.b
        public void dCV() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerACallback onPreparedPlayback");
            if (!VideoPlayer.this.isFinishing()) {
                if (VideoPlayer.this.mRe == null || !VideoPlayer.this.mRe.H) {
                    VideoPlayer.this.mRI.removeMessages(6);
                    VideoPlayer.this.N = 0L;
                    VideoPlayer.this.O = 0;
                    if (VideoPlayer.this.mQZ != null && VideoPlayer.this.mRe != null) {
                        VideoPlayer.this.mQZ.setVolume(VideoPlayer.this.mRe.J, VideoPlayer.this.mRe.J);
                    }
                    if (VideoPlayer.this.mRg != null) {
                        VideoPlayer.this.K = false;
                        FullRoomInfo dDd = VideoPlayer.this.dCF() ? null : VideoPlayer.this.mRg.dDd();
                        if (VideoPlayer.this.L || dDd != null) {
                            if (VideoPlayer.this.mRg.e) {
                                VideoPlayer.this.mRg.e = false;
                                VideoPlayer.this.mRg.d = !VideoPlayer.this.mRg.d;
                            }
                            if (VideoPlayer.this.mRe != null) {
                                VideoPlayer.this.c("1", (String) null);
                                if (!VideoPlayer.this.d) {
                                    VideoPlayer.this.mRe.i(true);
                                } else if (VideoPlayer.this.e) {
                                    VideoPlayer.this.e = false;
                                    VideoPlayer.this.mRe.B();
                                }
                            }
                        }
                    }
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void MP(int i) {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerACallback onErrorAppeared");
            if (!VideoPlayer.this.isFinishing()) {
                VideoPlayer.this.c();
                VideoPlayer.this.K = false;
                if (VideoPlayer.this.mRI != null) {
                    VideoPlayer.this.mRI.removeMessages(7);
                }
                if (VideoPlayer.this.mRI != null) {
                    VideoPlayer.this.mRI.removeMessages(1);
                }
                if ((VideoPlayer.this.mRe == null || !VideoPlayer.this.mRe.H) && !VideoPlayer.this.dCz()) {
                    if (!"10004".equals(VideoPlayer.this.t)) {
                        if (VideoPlayer.this.mRe != null) {
                            if (VideoPlayer.this.d) {
                                VideoPlayer.this.mRa.stop();
                                VideoPlayer.this.mRa.release();
                                VideoPlayer.this.e = false;
                                VideoPlayer.this.mRe.C();
                            }
                            if (!com.kascend.chushou.b.dCl().a && !com.kascend.chushou.b.dCl().b) {
                                VideoPlayer.this.mRe.g(true);
                            } else if (VideoPlayer.this.d) {
                                VideoPlayer.this.mRe.a(i, true);
                            } else {
                                VideoPlayer.this.mRe.a(i, false);
                            }
                            VideoPlayer.this.c("2", (String) null);
                            return;
                        }
                        return;
                    }
                    dCT();
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void dCW() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerACallback onBufferingStart");
            if (!VideoPlayer.this.isFinishing()) {
                if ((VideoPlayer.this.mRe == null || !VideoPlayer.this.mRe.H) && VideoPlayer.this.mRe != null && !VideoPlayer.this.d) {
                    VideoPlayer.this.mRe.E();
                    VideoPlayer.this.M = true;
                    long currentTimeMillis = System.currentTimeMillis();
                    VideoPlayer.this.mRI.removeMessages(7);
                    if (!VideoPlayer.this.g) {
                        VideoPlayer.y(VideoPlayer.this);
                    }
                    tv.chushou.zues.utils.e.d(VideoPlayer.this.v, "currentTime: -- >" + currentTimeMillis + "  bufferTime-->" + VideoPlayer.this.N + "  bufferCount-->" + VideoPlayer.this.O);
                    if (currentTimeMillis - VideoPlayer.this.N >= 20000 || VideoPlayer.this.O < 2 || VideoPlayer.this.mRe.H) {
                        if (VideoPlayer.this.O == 1) {
                            VideoPlayer.this.N = currentTimeMillis;
                        }
                        VideoPlayer.this.mRI.K(7, 5000L);
                    } else {
                        VideoPlayer.this.mRI.Ol(7);
                    }
                    if (VideoPlayer.this.g) {
                        VideoPlayer.this.g = false;
                    }
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void dCX() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerACallback onBufferingEnd");
            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.mRe != null && !VideoPlayer.this.d) {
                VideoPlayer.this.mRI.removeMessages(7);
                VideoPlayer.this.M = false;
                if (VideoPlayer.this.mRe == null || !VideoPlayer.this.mRe.H) {
                    if (VideoPlayer.this.mQZ == null) {
                        VideoPlayer.this.mRe.a(false, true, false);
                    } else {
                        VideoPlayer.this.mRe.a(true, VideoPlayer.this.mQZ.getPlayState() == 4, VideoPlayer.this.mQZ.getPlayState() == 5);
                    }
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void dCY() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerACallback onPlayerStart");
            if (!VideoPlayer.this.isFinishing()) {
                if (VideoPlayer.this.mRe == null || !VideoPlayer.this.mRe.H) {
                    if (VideoPlayer.this.mRe != null && !VideoPlayer.this.d) {
                        if (VideoPlayer.this.mQZ != null) {
                            VideoPlayer.this.mRe.F();
                            VideoPlayer.this.mRe.a(true, VideoPlayer.this.mQZ.getPlayState() == 4, VideoPlayer.this.mQZ.getPlayState() == 5);
                        } else {
                            VideoPlayer.this.mRe.a(false, true, false);
                        }
                    }
                    if (VideoPlayer.this.mRI != null && !VideoPlayer.this.dCF()) {
                        VideoPlayer.this.mRI.removeMessages(1);
                        VideoPlayer.this.mRI.K(1, VideoPlayer.A);
                    }
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void dCZ() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerACallback onPlayerPause");
            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.mRI != null) {
                VideoPlayer.this.mRI.removeMessages(1);
            }
        }

        @Override // tv.chushou.common.player.b
        public void dDa() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerACallback onPlayerStop");
            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.dCF() && VideoPlayer.this.mRa != null && !h.isEmpty(VideoPlayer.this.P) && VideoPlayer.this.mRa.getCurrentPos() > 0) {
                j.dCx().a(VideoPlayer.this.P, VideoPlayer.this.mRa.getCurrentPos());
            }
        }
    };
    private tv.chushou.common.player.b mRN = new tv.chushou.common.player.b() { // from class: com.kascend.chushou.player.VideoPlayer.15
        @Override // tv.chushou.common.player.b
        public void dCS() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerBCallback onSetVideoViewLayout");
            if (!VideoPlayer.this.isFinishing()) {
                if ((VideoPlayer.this.mRe == null || !VideoPlayer.this.mRe.H) && VideoPlayer.this.mRe != null && VideoPlayer.this.d) {
                    VideoPlayer.this.mRe.y();
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void MO(int i) {
            if (!VideoPlayer.this.isFinishing()) {
                if ((VideoPlayer.this.mRe == null || !VideoPlayer.this.mRe.H) && VideoPlayer.this.mRe != null && VideoPlayer.this.d) {
                    VideoPlayer.this.mRe.g(i);
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void dCT() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerBCallback onCompletePlayback");
            if (!VideoPlayer.this.isFinishing()) {
                if (!h.isEmpty(VideoPlayer.this.P)) {
                    j.dCx().a(VideoPlayer.this.P, 0);
                }
                VideoPlayer.this.K = false;
                if (VideoPlayer.this.mRI != null) {
                    VideoPlayer.this.mRI.removeMessages(1);
                }
                if ((VideoPlayer.this.mRe == null || !VideoPlayer.this.mRe.H) && VideoPlayer.this.mRe != null && VideoPlayer.this.d) {
                    VideoPlayer.this.mRI.removeMessages(7);
                    VideoPlayer.this.M = false;
                    VideoPlayer.this.mRe.z();
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void dCU() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerBCallback onVideoRenderingStart");
            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.mRe != null) {
                VideoPlayer.this.mRe.G();
            }
        }

        @Override // tv.chushou.common.player.b
        public void dCV() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerBCallback onPreparedPlayback");
            if (!VideoPlayer.this.isFinishing()) {
                if (VideoPlayer.this.mRe == null || !VideoPlayer.this.mRe.H) {
                    VideoPlayer.this.mRI.removeMessages(6);
                    VideoPlayer.this.N = 0L;
                    VideoPlayer.this.O = 0;
                    if (VideoPlayer.this.mQZ != null && VideoPlayer.this.mRe != null) {
                        VideoPlayer.this.mQZ.setVolume(VideoPlayer.this.mRe.J, VideoPlayer.this.mRe.J);
                    }
                    if (VideoPlayer.this.mRg != null) {
                        VideoPlayer.this.K = false;
                        FullRoomInfo dDd = VideoPlayer.this.dCF() ? null : VideoPlayer.this.mRg.dDd();
                        if (VideoPlayer.this.L || dDd != null) {
                            if (VideoPlayer.this.mRg.e) {
                                VideoPlayer.this.mRg.e = false;
                                VideoPlayer.this.mRg.d = !VideoPlayer.this.mRg.d;
                            }
                            if (VideoPlayer.this.mRe != null) {
                                VideoPlayer.this.c("1", (String) null);
                                if (VideoPlayer.this.d) {
                                    VideoPlayer.this.mRe.i(true);
                                } else if (VideoPlayer.this.e) {
                                    VideoPlayer.this.e = false;
                                    VideoPlayer.this.mRe.B();
                                }
                            }
                        }
                    }
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void MP(int i) {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerBCallback onErrorAppeared");
            if (!VideoPlayer.this.isFinishing()) {
                VideoPlayer.this.c();
                VideoPlayer.this.K = false;
                if (VideoPlayer.this.mRI != null) {
                    VideoPlayer.this.mRI.removeMessages(7);
                }
                if (VideoPlayer.this.mRI != null) {
                    VideoPlayer.this.mRI.removeMessages(1);
                }
                if ((VideoPlayer.this.mRe == null || !VideoPlayer.this.mRe.H) && !VideoPlayer.this.dCz()) {
                    if (!"10004".equals(VideoPlayer.this.t)) {
                        if (VideoPlayer.this.mRe != null) {
                            if (!VideoPlayer.this.d) {
                                VideoPlayer.this.mRb.stop();
                                VideoPlayer.this.mRb.release();
                                VideoPlayer.this.mRe.C();
                                VideoPlayer.this.e = false;
                            }
                            if (!com.kascend.chushou.b.dCl().a && !com.kascend.chushou.b.dCl().b) {
                                VideoPlayer.this.mRe.g(true);
                            } else if (VideoPlayer.this.d) {
                                VideoPlayer.this.mRe.a(i, false);
                            } else {
                                VideoPlayer.this.mRe.a(i, true);
                            }
                            VideoPlayer.this.c("2", (String) null);
                            return;
                        }
                        return;
                    }
                    dCT();
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void dCW() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerBCallback onBufferingStart");
            if (!VideoPlayer.this.isFinishing()) {
                if ((VideoPlayer.this.mRe == null || !VideoPlayer.this.mRe.H) && VideoPlayer.this.mRe != null && VideoPlayer.this.d) {
                    VideoPlayer.this.mRe.E();
                    VideoPlayer.this.M = true;
                    VideoPlayer.this.mRI.removeMessages(7);
                    long currentTimeMillis = System.currentTimeMillis();
                    if (!VideoPlayer.this.g) {
                        VideoPlayer.y(VideoPlayer.this);
                    }
                    tv.chushou.zues.utils.e.d(VideoPlayer.this.v, "currentTime: -- >" + currentTimeMillis + "  bufferTime-->" + VideoPlayer.this.N + "  bufferCount-->" + VideoPlayer.this.O);
                    if (currentTimeMillis - VideoPlayer.this.N >= 20000 || VideoPlayer.this.O < 2 || VideoPlayer.this.mRe.H) {
                        if (VideoPlayer.this.O == 1) {
                            VideoPlayer.this.N = currentTimeMillis;
                        }
                        VideoPlayer.this.mRI.K(7, 5000L);
                    } else {
                        VideoPlayer.this.N = 0L;
                        VideoPlayer.this.O = 0;
                        VideoPlayer.this.mRI.Ol(7);
                    }
                    if (VideoPlayer.this.g) {
                        VideoPlayer.this.g = false;
                    }
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void dCX() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerBCallback onBufferingEnd");
            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.mRe != null && VideoPlayer.this.d) {
                VideoPlayer.this.M = false;
                VideoPlayer.this.mRI.removeMessages(7);
                if (VideoPlayer.this.mRe == null || !VideoPlayer.this.mRe.H) {
                    if (VideoPlayer.this.mQZ == null) {
                        VideoPlayer.this.mRe.a(false, true, false);
                    } else {
                        VideoPlayer.this.mRe.a(true, VideoPlayer.this.mQZ.getPlayState() == 4, VideoPlayer.this.mQZ.getPlayState() == 5);
                    }
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void dCY() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerBCallback onPlayerStart");
            if (!VideoPlayer.this.isFinishing()) {
                if (VideoPlayer.this.mRe == null || !VideoPlayer.this.mRe.H) {
                    if (VideoPlayer.this.mRe != null && VideoPlayer.this.d) {
                        if (VideoPlayer.this.mQZ != null) {
                            VideoPlayer.this.mRe.F();
                            VideoPlayer.this.mRe.a(true, VideoPlayer.this.mQZ.getPlayState() == 4, VideoPlayer.this.mQZ.getPlayState() == 5);
                        } else {
                            VideoPlayer.this.mRe.a(false, true, false);
                        }
                    }
                    if (VideoPlayer.this.mRI != null && !VideoPlayer.this.dCF()) {
                        VideoPlayer.this.mRI.removeMessages(1);
                        VideoPlayer.this.mRI.K(1, VideoPlayer.A);
                    }
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void dCZ() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerBCallback onPlayerPause");
            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.mRI != null) {
                VideoPlayer.this.mRI.removeMessages(1);
            }
        }

        @Override // tv.chushou.common.player.b
        public void dDa() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerBCallback onPlayerStop");
            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.dCF() && VideoPlayer.this.mRb != null && !h.isEmpty(VideoPlayer.this.P) && VideoPlayer.this.mRb.getCurrentPos() > 0) {
                j.dCx().a(VideoPlayer.this.P, VideoPlayer.this.mRb.getCurrentPos());
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
        this.mQY = intent.getData();
        if (this.mQY == null) {
            finish();
            return;
        }
        com.kascend.chushou.d.e.j();
        if (this.mRH == null) {
            this.mRH = new CSTVWifiReceiver();
            registerReceiver(this.mRH, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        }
        com.kascend.chushou.toolkit.d.a.dEO().b();
        tv.chushou.zues.utils.e.i(this.v, "intent.getData=" + this.mQY.toString());
        String scheme = this.mQY.getScheme();
        if (scheme == null || !scheme.equals("chushou")) {
            tv.chushou.zues.utils.e.e(this.v, "not support scheme :" + scheme);
            finish();
            return;
        }
        a(intent);
    }

    private void a(Intent intent) {
        this.P = this.mQY.getQueryParameter("roomId");
        this.Q = this.P;
        this.S = this.mQY.getQueryParameter(WebSocketRequest.PARAM_KEY_PROTOCOLS);
        this.aq = this.mQY.getQueryParameter("liveType");
        if ("2".equals(this.aq) || "3".equals(this.aq) || "4".equals(this.aq)) {
            this.mRD = "2";
            this.mRE = new com.kascend.chushou.player.feedback.a();
            if (this.mRE.naj != null) {
                this.mRE.naj.reset();
                this.mRE.naj.roomId = this.P;
                this.mRE.naj.enterType = 1;
                this.mRE.b = System.currentTimeMillis();
            }
        }
        if (h.isEmpty(this.P) || h.isEmpty(this.S)) {
            tv.chushou.zues.utils.e.e(this.v, "invalid param mItemID=" + this.P + " protocols=" + this.S);
            finish();
            return;
        }
        if (com.kascend.chushou.b.dCl().d == -1) {
            com.kascend.chushou.b.dCl().d = com.kascend.chushou.d.g.b() ? 1 : 0;
        }
        this.mRt = ((PowerManager) getSystemService("power")).newWakeLock(536870938, this.v);
        this.mRt.acquire();
        this.mRg = new b(this.P);
        this.mRg.d = intent.getBooleanExtra("room_play_audio", false);
        this.mRl = new com.kascend.chushou.widget.a.b();
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
        this.mRn = (KPSwitchRootRelativeLayout) findViewById(a.f.rlRoot);
        if (!"2".equals(this.mRD) && com.kascend.chushou.b.dCl().d == 1) {
            this.mRn.setFitsSystemWindows(true);
        }
        this.mRo = (FrameLayout) this.mRn.findViewById(a.f.fl_fragment);
        this.aUP = this.mRn.findViewById(a.f.rl_empty);
        this.mRi = (ImageView) this.aUP.findViewById(a.f.iv_empty);
        this.mRj = (TextView) this.aUP.findViewById(a.f.tv_empty);
        this.mRp = (LinearLayout) this.mRn.findViewById(a.f.rl_title);
        this.Z = (ImageView) this.mRp.findViewById(a.f.back_icon);
        this.Z.setOnClickListener(new View.OnClickListener() { // from class: com.kascend.chushou.player.VideoPlayer.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayer.this.finish();
            }
        });
        this.mRk = (AnimationImageView) this.aUP.findViewById(a.f.iv_loading);
        this.mRv = (FrescoThumbnailView) this.mRn.findViewById(a.f.live_cover);
        this.mRw = (FrameLayout) this.mRn.findViewById(a.f.fl_cover);
        this.k = dCy();
        try {
            this.mRm = (AudioManager) getApplicationContext().getSystemService("audio");
            n = this.mRm.getStreamVolume(3);
            this.mRm.requestAudioFocus(null, 3, 1);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (this.B) {
            a(1, dCF() ? "3" : "1");
        } else {
            r();
        }
        if (com.kascend.chushou.b.dCl().b && !com.kascend.chushou.b.dCl().a) {
            RxExecutor.postDelayed(this.mRF, EventThread.MAIN_THREAD, 60L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.VideoPlayer.5
                @Override // java.lang.Runnable
                public void run() {
                    if (!VideoPlayer.this.isFinishing() && com.kascend.chushou.b.dCl().b && !com.kascend.chushou.b.dCl().a) {
                        tv.chushou.zues.utils.g.c(VideoPlayer.this.w, VideoPlayer.this.getString(a.i.str_monet_notify));
                    }
                }
            });
        }
        com.kascend.chushou.c.c.dCo().a(this.P, stringExtra, System.currentTimeMillis());
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
        if (this.mRG == null) {
            this.mRG = new a();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.media.VOLUME_CHANGED_ACTION");
            registerReceiver(this.mRG, intentFilter);
        }
    }

    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        j(false);
        if (this.mRG != null) {
            unregisterReceiver(this.mRG);
            this.mRG = null;
        }
        super.onStop();
    }

    @Override // com.kascend.chushou.view.base.BaseActivity
    protected void a(boolean z) {
        if (this.mRe != null) {
            this.mRe.k(z);
        }
    }

    @Subscribe
    public void onHideGiftEffectEvent(com.kascend.chushou.b.a.a.f fVar) {
        if (fVar.b) {
            this.mRe.k();
            return;
        }
        this.mRe.m();
        this.mRe.l();
    }

    private float dCy() {
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
        this.mRu = str;
        R();
        try {
            if (h.isEmpty(str)) {
                jSONObject = new JSONObject();
            } else {
                jSONObject = new JSONObject(str);
            }
            jSONObject.put("_fbroomid", this.P);
            this.mRg.h = jSONObject.toString();
            String optString = jSONObject.optString("_thumb");
            jSONObject.optBoolean("tag_from_game_mic", false);
            if (!h.isEmpty(optString)) {
                this.ab = optString;
            }
        } catch (JSONException e) {
            e.printStackTrace();
            this.mRg.h = str;
        }
        if (dCF()) {
            a(this.P, str);
            aO(this.P, z);
            return;
        }
        a = this.P;
        b(this.P, str);
        a(this.P, dCP(), z);
        w();
    }

    private void O() {
        this.m = true;
        j();
        if (this.mRe != null) {
            this.mRe.r();
        }
        s();
    }

    @Subscribe
    public void onStartRoomEvent(o oVar) {
        if (!isFinishing() && oVar.mQG != null && oVar.c != null && !h.isEmpty(oVar.mQG.mTargetKey)) {
            if (oVar.c != this) {
                tv.chushou.zues.utils.e.e(this.v, "different player!");
                return;
            }
            if (this.mRg != null) {
                this.mRg.a();
                this.mRg.a = oVar.mQG.mTargetKey;
                this.mRg.d = oVar.d;
                if (this.mRg.mSJ != null) {
                    this.mRg.mSJ.e();
                }
                if (this.mRg.mSJ != null) {
                    this.mRg.mSJ.b();
                }
                this.mRg.mSN = null;
                this.mRg.mSM = null;
                this.mRg.mSR = null;
                this.mRg.mSQ = null;
                this.mRg.mSU = null;
                this.mRg.mSS = null;
                this.mRg.mST = null;
            }
            if (this.mRm != null) {
                n = this.mRm.getStreamVolume(3);
            }
            if (!h.isEmpty(oVar.mQG.mType) && oVar.mQG.mType.equals("3")) {
                this.B = false;
                this.mRD = "1";
                r();
                this.P = oVar.mQG.mTargetKey;
                this.R = "3";
                if (this.mRl != null) {
                    this.mRl.a();
                }
                if (this.mRg != null) {
                    this.mRg.a((PlayUrl) null);
                    this.mRg.f();
                    if (this.mRg.c() != null) {
                        this.mRg.c().clear();
                    }
                    this.mRg.i.clear();
                }
                if (this.mRe != null) {
                    this.mRe.j();
                }
                s();
                if (this.mRq != null) {
                    this.mRq.d();
                    this.mRq = null;
                }
                if (this.mRF != null) {
                    this.mRF.dispose();
                    this.mRF = new io.reactivex.disposables.a();
                }
                a(oVar.e, false);
                return;
            }
            boolean z = this.R != null && this.R.equals("1");
            this.R = "1";
            this.mRA.a();
            this.mRz.a();
            this.mRy.a();
            this.mRx.c();
            this.mRC.a();
            if (this.mRF != null) {
                this.mRF.dispose();
                this.mRF = new io.reactivex.disposables.a();
            }
            if ("1".equals(oVar.f)) {
                this.H = false;
                if (this.mRg != null && !h.isEmpty(this.mRg.t)) {
                    this.mRg.t.clear();
                }
                this.ab = oVar.mQG.mCover;
                this.mRw.setVisibility(0);
                this.mRv.setBlur(true);
                this.mRv.i(oVar.mQG.mCover, 0, 0, 0);
            }
            if (!oVar.mQG.mTargetKey.equals(this.P)) {
                this.aq = oVar.g;
                if (!z) {
                    this.B = false;
                    r();
                } else if (!"2".equals(this.mRD) && ("2".equals(this.aq) || "3".equals(this.aq) || "4".equals(this.aq))) {
                    this.mRD = "2";
                    this.mRE = new com.kascend.chushou.player.feedback.a();
                    if (this.mRE.naj != null) {
                        this.mRE.naj.reset();
                        this.mRE.naj.roomId = oVar.mQG.mTargetKey;
                        this.mRE.naj.enterType = 1;
                        this.mRE.b = System.currentTimeMillis();
                    }
                }
                this.B = false;
                this.P = oVar.mQG.mTargetKey;
                this.Q = this.P;
                this.ab = oVar.mQG.mCover;
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
                JSONObject N = com.kascend.chushou.d.e.N("_fromView", str, "_sc", oVar.mQG.mSC);
                com.kascend.chushou.toolkit.a.c.a(this.w, N);
                if (this.mRl != null) {
                    this.mRl.a();
                    this.mRl.a(this.P);
                }
                if (this.mRg != null) {
                    this.mRg.a((PlayUrl) null);
                    this.mRg.f();
                    if (this.mRg.c() != null) {
                        this.mRg.c().clear();
                    }
                    this.mRg.i.clear();
                }
                if (this.mRe != null) {
                    this.mRe.j();
                }
                a(N.toString(), false);
                return;
            }
            tv.chushou.zues.utils.g.Os(a.i.str_same_room);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dCz() {
        FullRoomInfo dDd;
        String str;
        RoomInfo roomInfo;
        if (dCF()) {
            str = null;
            dDd = null;
        } else {
            dDd = this.mRg.dDd();
            str = (dDd == null || (roomInfo = dDd.mRoominfo) == null) ? null : roomInfo.mGameId;
        }
        return !this.L && (dDd == null || h.isEmpty(str));
    }

    @Subscribe
    public void onMessageEvent(i iVar) {
        if (!isFinishing() && iVar.a != 21 && iVar.a != 22) {
            if (iVar.a == 0 && (iVar.b instanceof Boolean)) {
                if (((Boolean) iVar.b).booleanValue() && !isFinishing()) {
                    w();
                    if (this.mRe != null) {
                        this.mRe.f();
                    }
                }
            } else if (iVar.a == 46) {
                if ((iVar.b instanceof String) && this.mRe != null) {
                    this.mRe.c((String) iVar.b);
                }
            } else if (iVar.a == 54) {
                if (iVar.b instanceof String) {
                    this.mRy.a((String) iVar.b);
                }
            } else if (iVar.a == 55) {
                if (this.mRe != null) {
                    this.mRe.O();
                }
            } else if (iVar.a == 56 && this.mRe != null) {
                this.mRe.P();
            }
        }
    }

    @Subscribe
    public void onRefreshSubscribeEvent(m mVar) {
        if (isFinishing() && this.mRg != null && this.mRg.dDf() != null) {
            RoomInfo dDf = this.mRg.dDf();
            if (mVar.a(dDf.mCreatorUID, dDf.mRoomID)) {
                dDf.mIsSubscribed = mVar.c;
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
        j(true);
        if (this.m || this.mRa == null || this.mRb == null) {
            R();
        }
        if (this.mRl != null) {
            this.mRl.d();
        }
        if (!dCF()) {
            if (this.mRq != null && !this.mRq.c()) {
                this.mRq.a();
            }
            v();
            if (this.mRg != null && this.mRg.dDd() != null && this.mRg.dDd().cycleLiveRoomInfo != null && !h.isEmpty(this.mRg.dDd().cycleLiveRoomInfo.roomId)) {
                u();
            }
        }
        super.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.view.base.BaseActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        tv.chushou.zues.utils.e.e(this.v, MissionEvent.MESSAGE_DESTROY);
        if (this.mRg != null && this.mRg.dDd() != null && this.mRg.dDd().cycleLiveRoomInfo != null && !h.isEmpty(this.mRg.dDd().cycleLiveRoomInfo.eventName)) {
            j.dCx().a(this.P + dCP());
        }
        if ("2".equals(this.mRD) && this.mRE != null && this.mRE.naj != null) {
            this.mRE.naj.time = System.currentTimeMillis() - this.mRE.b;
            this.mRE.a();
            this.mRE.b();
        }
        this.mRx.d();
        this.mRy.b();
        this.mRz.b();
        O();
        this.mRu = null;
        a = null;
        if (this.mRI != null) {
            this.mRI.cq(null);
            this.mRI = null;
        }
        if (this.mRq != null) {
            this.mRq.d();
            this.mRq = null;
        }
        if (this.mRl != null) {
            this.mRl.c();
            this.mRl = null;
        }
        if (this.mRg != null) {
            this.mRg.mSN = null;
            this.mRg.mSM = null;
        }
        if (this.mRg != null) {
            this.mRg.b();
            this.mRg = null;
        }
        this.mQY = null;
        this.mRe = null;
        this.mRf = null;
        this.mRh = null;
        this.mRi = null;
        this.mRj = null;
        this.mRk = null;
        this.aUP = null;
        this.mRm = null;
        this.mRn = null;
        this.mRo = null;
        this.Z = null;
        this.mRp = null;
        if (this.mRt != null && this.mRt.isHeld()) {
            this.mRt.release();
            this.mRt = null;
        }
        if (this.mRH != null) {
            unregisterReceiver(this.mRH);
            this.mRH = null;
        }
        h.dQW();
        tv.chushou.zues.a.a.cr(this);
        this.mRF.dispose();
        this.mRz.b();
        this.mRA.b();
        this.mRx.d();
        this.mRy.b();
        this.mRC.b();
        super.onDestroy();
        System.gc();
    }

    @Subscribe
    public void onSendGameGiftEvent(n nVar) {
        if (!isFinishing() && this.mRe != null) {
            this.mRe.a(nVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.view.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        tv.chushou.zues.utils.e.d(this.v, MissionEvent.MESSAGE_PAUSE);
        if (this.mRq != null) {
            this.mRq.b();
        }
        if (this.mRl != null) {
            this.mRl.b(false);
        }
        k();
        this.m = true;
        super.onPause();
    }

    @Override // android.app.Activity
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.mRe != null ? this.mRe.a(motionEvent) : super.onTouchEvent(motionEvent);
    }

    public void c() {
        if ("1".equals(this.R)) {
            j.dCx().a(this.P + dCP());
        } else {
            j.dCx().b(this.P);
        }
    }

    private void a(boolean z, boolean z2) {
        int i = 0;
        tv.chushou.zues.utils.e.i(this.v, "startLoadingVideo <------------- mbPrepareingVideo = " + this.K);
        if (this.mRa != null) {
            this.mRa.setHardwearDecod(com.kascend.chushou.d.h.dCs().a);
        }
        if (this.mRb != null) {
            this.mRb.setHardwearDecod(com.kascend.chushou.d.h.dCs().a);
        }
        if (this.mQZ != null) {
            this.mQZ.setHardwearDecod(com.kascend.chushou.d.h.dCs().a);
        }
        if (!this.K) {
            if (z && this.mRe != null) {
                if (!z2) {
                    this.t = null;
                    this.mRe.e();
                }
            } else if (this.mRe != null && !z2) {
                this.t = null;
                this.mRe.H = false;
                RxExecutor.post(null, EventThread.MAIN_THREAD, new Runnable() { // from class: com.kascend.chushou.player.VideoPlayer.7
                    @Override // java.lang.Runnable
                    public void run() {
                        VideoPlayer.this.mRe.x();
                    }
                });
            }
            this.K = true;
            if (this.mRg != null && this.mRg.dDe() != null) {
                PlayUrl dDe = this.mRg.dDe();
                while (true) {
                    int i2 = i;
                    if (i2 >= dDe.mUrlDetails.size()) {
                        break;
                    }
                    UrlDetails urlDetails = dDe.mUrlDetails.get(i2);
                    if (urlDetails.mUrl.equals(dDe.mSelectedUrl)) {
                        String str = dDe.mUrlDetails.get(i2).mDefinitionType;
                        String str2 = urlDetails.mBitrate;
                    }
                    i = i2 + 1;
                }
            }
            if (z2) {
                if (this.d) {
                    this.mRa.setVideoURI(this.mQY);
                    this.mRa.open();
                    return;
                }
                this.mRb.setVideoURI(this.mQY);
                this.mRb.open();
                return;
            }
            this.mQZ.setVideoURI(this.mQY);
            this.mQZ.open();
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        try {
            if (motionEvent.getAction() == 0) {
                if (this.mRe != null && this.mRe.b(motionEvent)) {
                    return true;
                }
                if ("2".equals(this.mRD) && this.mRe != null) {
                    this.mRe.a(motionEvent);
                }
            } else if (this.mRe != null && this.mRe.b(motionEvent)) {
                return true;
            }
            return super.dispatchTouchEvent(motionEvent);
        } catch (Exception e) {
            return false;
        }
    }

    @Override // android.support.v7.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.mRe != null && this.mRe.a(i, keyEvent)) {
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
        if (this.mRg != null && this.mRg.dDd() != null && this.mRg.dDd().cycleLiveRoomInfo != null && !h.isEmpty(this.mRg.dDd().cycleLiveRoomInfo.roomId)) {
            this.mRw.setVisibility(0);
            this.mRv.setBlur(true);
            this.mRv.i(this.mRg.dDd().cycleLiveRoomInfo.avatar, 0, 0, 0);
            this.mRv.setVisibility(0);
            j.dCx().a(this.P + dCP());
            this.mQY = null;
            R();
            this.Q = this.mRg.dDd().cycleLiveRoomInfo.roomId;
            a(this.P, dCP(), false);
        }
    }

    public void b(boolean z) {
        if (this.mRe != null) {
            this.mRe.j(z);
        }
    }

    public void a(boolean z, Uri uri, boolean z2) {
        tv.chushou.zues.utils.e.d(this.v, "loadIfNecessary reload=" + z + " isChangeLines-->" + z2);
        if (this.mRa != null && this.mRb != null) {
            if (uri != null) {
                this.mQY = uri;
            }
            if (z2) {
                this.e = z2;
            }
            this.M = false;
            this.N = 0L;
            this.O = 0;
            this.mRI.removeMessages(7);
            if (z) {
                if (z2) {
                    if (!this.d) {
                        this.mRb.setOnActivityCallBack(this.mRN);
                    } else {
                        this.mRa.setOnActivityCallBack(this.mRM);
                    }
                } else if (this.d) {
                    this.mRb.setOnActivityCallBack(this.mRN);
                } else {
                    this.mRa.setOnActivityCallBack(this.mRM);
                }
                this.K = false;
                b(true, z2);
            } else if (!this.J) {
                b(true, z2);
            }
            this.mRI.K(6, 3000L);
        }
    }

    private void b(boolean z, boolean z2) {
        VideoPlayInfo O;
        if ("1".equals(this.R)) {
            O = j.dCx().N(this.P + dCP(), KeepJobService.JOB_CHECK_PERIODIC);
        } else {
            O = j.dCx().O(this.P, KeepJobService.JOB_CHECK_PERIODIC);
        }
        if (O != null) {
            a(z, z2);
        } else if ("1".equals(this.R)) {
            a(this.P, dCP(), false);
        } else {
            aO(this.P, false);
        }
    }

    public tv.chushou.common.player.a dCA() {
        return this.mQZ;
    }

    public tv.chushou.common.player.a dCB() {
        return this.mRa;
    }

    public tv.chushou.common.player.a dCC() {
        return this.mRb;
    }

    public void a(tv.chushou.common.player.a aVar) {
        this.mQZ = aVar;
    }

    public b dCD() {
        return this.mRg;
    }

    public com.kascend.chushou.widget.a.b dCE() {
        return this.mRl;
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
        FullRoomInfo dDd;
        this.r = -1L;
        if (this.s != -1 && this.s != 0) {
            this.r = this.s;
            this.s = -1L;
        }
        if (dCF() && this.mQZ != null && this.mQZ.getPlayState() == 4) {
            this.r = this.mQZ.getCurrentPos();
        }
        this.mRJ = false;
        tv.chushou.zues.utils.e.d(this.v, "screenChange()<-----");
        tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard(this);
        if (str != null) {
            this.R = str;
        }
        if (!this.C || !z3 || "3".equals(this.R) || this.mRg == null || (dDd = this.mRg.dDd()) == null || dDd.mRoominfo == null || dDd.mRoominfo.mStyle != 1) {
            z5 = false;
        } else {
            z5 = true;
            i = 0;
        }
        if ("2".equals(this.mRD)) {
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
            if (com.kascend.chushou.b.dCl().d == 1) {
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
                decorView2.setSystemUiVisibility(1284);
                if (Build.VERSION.SDK_INT >= 21) {
                    getWindow().setStatusBarColor(0);
                }
            }
        } else {
            ((VideoPlayer) this.w).wo(false);
            ((VideoPlayer) this.w).g(true);
            if (z5) {
                setRequestedOrientation(1);
            } else {
                setRequestedOrientation(6);
            }
            getWindow().addFlags(512);
            getWindow().addFlags(256);
        }
        if (this.mRl == null) {
            this.mRl = new com.kascend.chushou.widget.a.b();
        }
        if (this.mRl != null) {
            this.mRl.a(this.P);
        }
        if (this.R.equals("5")) {
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            if (this.mRe != null) {
                beginTransaction.remove(this.mRe);
                this.mRe = null;
            }
            if (this.mRf != null) {
                beginTransaction.remove(this.mRf);
                this.mRf = null;
            }
            this.mRf = new com.kascend.chushou.view.user.b();
            beginTransaction.add(a.f.fl_fragment, this.mRf);
            beginTransaction.commitAllowingStateLoss();
        } else {
            FragmentTransaction beginTransaction2 = getSupportFragmentManager().beginTransaction();
            if (this.mRe != null) {
                beginTransaction2.remove(this.mRe);
                this.mRe = null;
            }
            if (this.mRf != null) {
                beginTransaction2.remove(this.mRf);
                this.mRf = null;
            }
            if ("2".equals(this.mRD)) {
                this.mRe = com.kascend.chushou.player.e.e.a(this.ab, z2, this.aq, this.P);
            } else if (1 == i) {
                if (!this.R.equals("3")) {
                    if (z4) {
                        v();
                    }
                    this.mRe = new com.kascend.chushou.player.d.a();
                    Bundle bundle = new Bundle();
                    bundle.putString("mCover", this.ab);
                    bundle.putBoolean("mInitViewAsync", z2);
                    this.mRe.setArguments(bundle);
                }
            } else {
                this.mRe = new com.kascend.chushou.player.d.b();
                Bundle bundle2 = new Bundle();
                if (z5) {
                    i = 1;
                }
                bundle2.putInt("mExtraOrientation", i);
                bundle2.putString("mViewType", this.R);
                this.mRe.setArguments(bundle2);
            }
            beginTransaction2.add(a.f.fl_fragment, this.mRe);
            beginTransaction2.commitAllowingStateLoss();
            this.H = true;
        }
        tv.chushou.zues.utils.e.d(this.v, "screenChange()----->");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dCF() {
        return this.R != null && this.R.equals("3");
    }

    private void R() {
        if (this.mRe != null) {
            this.mRe.mWp = null;
        }
        if (this.mQZ != null) {
            this.mQZ.release();
            this.mQZ = null;
            this.K = false;
        }
        if (this.mRa != null) {
            this.mRa.release();
            this.mRa = null;
        }
        if (this.mRb != null) {
            this.mRb.release();
            this.mRb = null;
        }
        if (this.mRd != null) {
            this.mRd.c();
        }
        this.d = false;
        this.e = false;
        this.M = false;
        this.mRd = new c();
        this.mRa = this.mRd.dDh();
        this.mRa.setOnActivityCallBack(this.mRM);
        this.mRb = this.mRd.dDi();
        this.mRb.setOnActivityCallBack(this.mRN);
        if (!this.d) {
            this.mQZ = this.mRa;
        } else {
            this.mQZ = this.mRb;
        }
        if (this.mRe != null) {
            this.mRe.mWp = this.mQZ;
        }
    }

    public void j() {
        if (this.mQZ != null) {
            this.mQZ.pause();
            this.mQZ.stop();
            this.mQZ.release();
            this.mQZ = null;
        }
        if (this.mRa != null) {
            this.mRa.stop();
            this.mRa.release();
            this.mRa = null;
        }
        if (this.mRb != null) {
            this.mRb.stop();
            this.mRb.release();
            this.mRb = null;
        }
        if (this.mRd != null) {
            this.mRd.c();
        }
    }

    public void k() {
        tv.chushou.common.player.a aVar = this.mQZ;
        if (aVar != null) {
            aVar.pause();
            aVar.stop();
        }
        tv.chushou.common.player.a aVar2 = this.mRa;
        if (aVar2 != null) {
            aVar2.stop();
        }
        tv.chushou.common.player.a aVar3 = this.mRb;
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
    public void cXT() {
        if (this.mRJ) {
            if (this.mRe != null) {
                this.mRe.s();
            }
        } else if (this.mRI != null) {
            this.mRI.a(this.mRI.On(3), 20L);
        }
    }

    private void b(final String str, String str2) {
        com.kascend.chushou.c.c.dCo().a(new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.VideoPlayer.8
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
                    VideoPlayer.this.dCN().a(fullRoomInfo.mBangMap);
                    if (h.isEmpty(fullRoomInfo.mRoominfo.mRoomID)) {
                        fullRoomInfo.mRoominfo.mRoomID = VideoPlayer.this.P;
                    }
                    if (!h.isEmpty(fullRoomInfo.mGeneralTabGifts)) {
                        com.kascend.chushou.d.e.a(VideoPlayer.this.mRF, new ArrayList(fullRoomInfo.mGeneralTabGifts));
                    }
                    if (VideoPlayer.this.mRg != null) {
                        VideoPlayer.this.mRg.a(fullRoomInfo);
                    }
                    VideoPlayer.this.L = false;
                    if (VideoPlayer.this.B) {
                        if (VideoPlayer.this.C && !"3".equals(VideoPlayer.this.R) && fullRoomInfo != null && fullRoomInfo.mRoominfo != null && fullRoomInfo.mRoominfo.mStyle == 1 && !h.isEmpty(fullRoomInfo.mRoominfo.mGameId)) {
                            z = true;
                        }
                        if (!z) {
                            if (VideoPlayer.this.mRe != null) {
                                VideoPlayer.this.mRe.a(VideoPlayer.this.mRg);
                            }
                            if (!h.isEmpty(fullRoomInfo.mRoominfo.mGameId)) {
                                VideoPlayer.this.cXT();
                            } else {
                                if (VideoPlayer.this.mRg != null) {
                                    VideoPlayer.this.mRg.f = null;
                                }
                                VideoPlayer.this.cXT();
                            }
                        } else {
                            VideoPlayer.this.a(1, "1", true);
                            if (VideoPlayer.this.mRe != null) {
                                VideoPlayer.this.mRe.a(VideoPlayer.this.mRg);
                            }
                        }
                    } else {
                        if (h.isEmpty(fullRoomInfo.mRoominfo.mGameId)) {
                            if (VideoPlayer.this.mRg != null) {
                                VideoPlayer.this.mRg.f = null;
                            }
                            VideoPlayer.this.a(1, "1");
                        } else {
                            VideoPlayer.this.a(1, "1", true);
                        }
                        if (VideoPlayer.this.mRe != null) {
                            VideoPlayer.this.mRe.a(VideoPlayer.this.mRg);
                        }
                    }
                    if (VideoPlayer.this.mRg != null && !VideoPlayer.this.mRg.m()) {
                        if (VideoPlayer.this.mRq != null) {
                            VideoPlayer.this.mRq.d();
                            VideoPlayer.this.mRq = null;
                        }
                        VideoPlayer.this.mRq = new com.kascend.chushou.toolkit.d(900000L, VideoPlayer.this.mRs, VideoPlayer.this.mRI);
                        VideoPlayer.this.mRq.a();
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
        if (this.mRg != null) {
            this.mRg.a((FullRoomInfo) null);
        }
        this.L = false;
        bN(str, i);
        if (this.mQZ != null) {
            this.mQZ.stop();
        }
        if (this.mRa != null) {
            this.mRa.stop();
        }
        if (this.mRb != null) {
            this.mRb.stop();
        }
    }

    public void l() {
        tv.chushou.zues.utils.e.d(this.v, "retryGetPlayList");
        c();
        if (dCF()) {
            aO(this.P, false);
        } else {
            a(this.P, dCP(), false);
        }
    }

    public void m() {
        a(this.mRu, false);
    }

    private void a(final String str, String str2, boolean z) {
        this.J = true;
        VideoPlayInfo N = j.dCx().N(str + str2, KeepJobService.JOB_CHECK_PERIODIC);
        if (N != null) {
            a((ArrayList) N.mPlayUrls);
            this.J = false;
        } else if (z) {
            ParserRet fs = com.kascend.chushou.player.c.a.dDj().fs(str, str2);
            if (fs.mRc != 0) {
                tv.chushou.zues.utils.e.e(this.v, "getPlayUrlSync fail, try to getPlaylist");
                a(str, str2, false);
                return;
            }
            a(fs, str);
        } else {
            com.kascend.chushou.player.c.a.dDj().a(str, str2, new a.InterfaceC0696a() { // from class: com.kascend.chushou.player.VideoPlayer.9
                @Override // com.kascend.chushou.player.c.a.InterfaceC0696a
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
        VideoPlayInfo O = j.dCx().O(str, KeepJobService.JOB_CHECK_PERIODIC);
        if (O != null) {
            a((ArrayList) O.mPlayUrls);
            this.J = false;
            return;
        }
        if (!h.isEmpty(this.mRu)) {
            try {
                equals = "1".equals(new JSONObject(this.mRu).optString("auto"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (!z) {
                ParserRet aP = com.kascend.chushou.player.c.a.dDj().aP(str, equals);
                if (aP.mRc != 0) {
                    tv.chushou.zues.utils.e.e(this.v, "getVideoPlayUrlSync fail, try to getVideoPlaylist");
                    aO(str, false);
                    return;
                }
                a(aP, str);
                return;
            }
            com.kascend.chushou.player.c.a.dDj().a(str, new a.InterfaceC0696a() { // from class: com.kascend.chushou.player.VideoPlayer.10
                @Override // com.kascend.chushou.player.c.a.InterfaceC0696a
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
                if (this.mRg.f == null) {
                    this.mRg.f = new ArrayList<>();
                }
                this.mRg.f.clear();
                this.mRg.f.addAll(arrayList);
                if ("1".equals(this.R)) {
                    j.dCx().a(str + dCP(), arrayList);
                } else {
                    j.dCx().s(str, arrayList);
                }
                a(arrayList);
                return;
            }
            if (this.mRg != null) {
                this.mRg.f = null;
            }
            if (this.mRI != null) {
                Message On = this.mRI.On(5);
                On.arg1 = 2;
                On.arg2 = parserRet.mRc;
                this.mRI.O(On);
            }
        }
    }

    private void bN(String str, int i) {
        s();
        if (this.mRl != null) {
            this.mRl.a();
        }
        if (h.isEmpty(str)) {
            str = getString(a.i.str_load_data_failed);
        }
        a(str, i);
    }

    public void n() {
        if (this.mRo != null && this.aUP != null && this.mRp != null) {
            this.mRo.setVisibility(0);
            this.aUP.setVisibility(8);
            this.mRp.setVisibility(8);
        }
    }

    public void o() {
        if (this.mRv != null && this.mRv.getVisibility() == 0) {
            this.mRv.xw(0);
            this.mRv.setVisibility(8);
        }
    }

    public void p() {
        if (this.mRw != null && this.mRw.getVisibility() == 0) {
            this.mRw.setVisibility(8);
        }
    }

    public void q() {
        this.mRJ = true;
    }

    protected void r() {
        this.mRo.setVisibility(8);
        this.mRp.setVisibility(0);
        this.aUP.setVisibility(0);
        if (this.mRk != null) {
            this.mRi.setVisibility(8);
            this.mRk.setVisibility(0);
            this.mRj.setText(getString(a.i.str_dialog_loading_content));
            this.mRj.setVisibility(8);
        }
    }

    protected void a(String str, int i) {
        this.mRo.setVisibility(8);
        this.mRp.setVisibility(0);
        this.aUP.setVisibility(0);
        if (this.mRk != null) {
            if (str == null) {
                str = getString(a.i.str_nodata);
            }
            if (str != null) {
                this.mRj.setText(str);
                if (str.equals(getString(a.i.s_no_available_network))) {
                    this.mRi.setImageResource(a.e.commonres_pagestatus_net_error);
                } else if (str.equals(getString(a.i.str_nodata)) || str.equals(getString(a.i.str_nohistory)) || str.equals(getString(a.i.str_nolive)) || str.equals(getString(a.i.str_nosubscribe))) {
                    this.mRi.setClickable(true);
                    this.mRi.setImageResource(a.e.commonres_pagestatus_empty);
                } else if (str.equals(getString(a.i.str_inbox_login_notify)) || str.equals(getString(a.i.push_login)) || str.equals(getString(a.i.str_login_timeout))) {
                    this.mRi.setImageResource(a.e.commonres_pagestatus_need_login);
                    this.mRi.setClickable(true);
                } else {
                    this.mRi.setImageResource(a.e.commonres_pagestatus_unknown_error);
                    this.mRi.setClickable(true);
                }
            }
            if (i == 4001) {
                this.mRi.setImageResource(a.e.commonres_pagestatus_net_error);
                this.mRi.setClickable(false);
                this.mRj.setVisibility(0);
                this.mRj.setText(getString(a.i.str_dissubscribe_btn));
                this.mRj.setOnClickListener(new View.OnClickListener() { // from class: com.kascend.chushou.player.VideoPlayer.11
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (!VideoPlayer.this.j) {
                            com.kascend.chushou.c.c.dCo().b(new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.VideoPlayer.11.1
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
                            }, VideoPlayer.this.P, (String) null, VideoPlayer.this.mRg.h);
                        }
                    }
                });
            } else if (i == 404) {
                this.mRj.setText(str);
                this.mRj.setVisibility(0);
                this.mRi.setClickable(false);
                this.mRi.setImageResource(a.e.commonres_pagestatus_empty);
            } else if (i == 4002) {
                if (h.isEmpty(str)) {
                    this.mRj.setVisibility(8);
                } else {
                    this.mRj.setVisibility(0);
                    this.mRj.setText(str);
                }
            } else {
                this.mRj.setVisibility(8);
            }
            this.mRi.setVisibility(0);
            this.mRk.setVisibility(8);
            this.mRw.setVisibility(8);
        }
    }

    public void s() {
        if (this.mRI != null) {
            this.mRI.removeMessages(1);
        }
    }

    private void a(ArrayList<PlayUrl> arrayList) {
        boolean z;
        if (this.mRg.f == null) {
            this.mRg.f = new ArrayList<>();
        }
        this.mRg.f.clear();
        this.mRg.f.addAll(arrayList);
        if (com.kascend.chushou.d.e.b() && !"4".equals(this.aq)) {
            int c = com.kascend.chushou.d.e.c();
            if (c == -1) {
                b(arrayList);
                return;
            } else if (this.mRK) {
                this.mRK = false;
                if (c == 0) {
                    this.mRg.d = false;
                    f(arrayList, true);
                    return;
                }
                if (this.mRg != null && this.mRg.f != null) {
                    Iterator<PlayUrl> it = this.mRg.f.iterator();
                    while (it.hasNext()) {
                        if ("2".equals(it.next().mType)) {
                            z = true;
                            break;
                        }
                    }
                }
                z = false;
                this.mRg.d = z;
                f(arrayList, true);
                return;
            } else {
                if (this.mRg.e) {
                    this.mRg.d = !this.mRg.d;
                    this.mRg.e = false;
                    this.mRL = true;
                } else if ("4".equals(this.aq)) {
                    this.mRg.d = true;
                }
                f(arrayList, true);
                return;
            }
        }
        if (this.mRg.e) {
            this.mRg.d = !this.mRg.d;
            this.mRg.e = false;
            this.mRL = true;
        } else if ("4".equals(this.aq)) {
            this.mRg.d = true;
        }
        f(arrayList, true);
    }

    private void b(ArrayList<PlayUrl> arrayList) {
        if ("1".equals(this.R)) {
            if ("2".equals(this.mRD)) {
                d(false, arrayList);
            } else if (this.mRe != null) {
                this.mRe.f(arrayList, false);
            }
        } else if (this.mRe != null) {
            this.mRe.f(arrayList, false);
        }
    }

    public void c(boolean z) {
        this.mRg.d = false;
        com.kascend.chushou.d.e.a(0);
        ArrayList<PlayUrl> arrayList = this.mRg.f;
        if (!h.isEmpty(arrayList)) {
            if (z) {
                f(arrayList, false);
                if (this.mRI != null) {
                    this.mRI.Ol(2);
                    return;
                }
                return;
            }
            f(arrayList, true);
        }
    }

    public void d(boolean z) {
        this.mRg.d = true;
        com.kascend.chushou.d.e.a(1);
        ArrayList<PlayUrl> arrayList = this.mRg.f;
        if (!h.isEmpty(arrayList)) {
            if (z) {
                f(arrayList, false);
                if (this.mRI != null) {
                    this.mRI.Ol(2);
                    return;
                }
                return;
            }
            f(arrayList, true);
        }
    }

    @Subscribe
    public void onNotifyEvent(com.kascend.chushou.b.a.a.j jVar) {
        if (!isFinishing() && jVar.a == 1 && !"5".equals(this.R) && !dCz()) {
            tv.chushou.zues.utils.e.d(this.v, "onNetworkChangeEvent 3G=" + com.kascend.chushou.b.dCl().b + "  wifi=" + com.kascend.chushou.b.dCl().a);
            if (com.kascend.chushou.d.e.b() && !"4".equals(this.aq)) {
                if (com.kascend.chushou.d.e.c() == -1) {
                    if (this.mRe != null) {
                        this.mRe.e(false);
                    }
                    if ("1".equals(this.R)) {
                        if ("2".equals(this.mRD)) {
                            d(true, null);
                            return;
                        } else if (this.mRe != null) {
                            this.mRe.f(this.mRg.f, true);
                            return;
                        } else {
                            return;
                        }
                    } else if (this.mRe != null) {
                        this.mRe.f(this.mRg.f, true);
                        return;
                    } else {
                        return;
                    }
                }
                RxExecutor.postDelayed(this.mRF, EventThread.MAIN_THREAD, 10L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.VideoPlayer.12
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!VideoPlayer.this.isFinishing() && com.kascend.chushou.b.dCl().b && !com.kascend.chushou.b.dCl().a) {
                            tv.chushou.zues.utils.g.c(VideoPlayer.this.w, VideoPlayer.this.getString(a.i.str_monet_notify));
                        }
                    }
                });
            } else if (com.kascend.chushou.b.dCl().a || com.kascend.chushou.b.dCl().b) {
                t();
                if (this.mRI != null) {
                    this.mRI.Ol(2);
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
            if (this.mRg.d) {
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
            String d = com.kascend.chushou.d.h.dCs().d();
            String str3 = h.isEmpty(d) ? "2" : d;
            if (this.mRg.d) {
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
                if (this.mRg != null) {
                    this.mRg.a(playUrl2);
                    if (this.mRI != null) {
                        Message On = this.mRI.On(5);
                        On.arg1 = 1;
                        this.mRI.O(On);
                    }
                }
                String b = com.kascend.chushou.player.c.a.b(playUrl2);
                if (!h.isEmpty(b)) {
                    this.mQY = Uri.parse(b);
                    if (this.mRL) {
                        this.mRL = false;
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (z && this.mQZ != null) {
                        a(false, z2);
                    }
                }
            }
        }
    }

    public void d(final boolean z, ArrayList<PlayUrl> arrayList) {
        if (this.mRr == null || this.mRr.a <= 0) {
            this.mRr = com.kascend.chushou.view.b.a.a.dEP();
            this.mRr.a(new a.InterfaceC0715a() { // from class: com.kascend.chushou.player.VideoPlayer.13
                @Override // com.kascend.chushou.view.b.a.a.InterfaceC0715a
                public void a(int i) {
                    if (i == a.f.tv_play_video) {
                        VideoPlayer.this.mRr.dismissAllowingStateLoss();
                        VideoPlayer.this.c(z);
                    } else if (i == a.f.tv_play_audio) {
                        VideoPlayer.this.mRr.dismissAllowingStateLoss();
                        VideoPlayer.this.d(z);
                    } else if (i == a.f.iv_close) {
                        VideoPlayer.this.finish();
                    } else {
                        if (i == a.f.tv_union_proxy) {
                        }
                    }
                }
            });
            this.mRr.show(getSupportFragmentManager(), "showRoom");
        }
    }

    public void t() {
        if (this.mRr != null) {
            this.mRr.dismissAllowingStateLoss();
        }
        if (this.mRe != null) {
            this.mRe.v();
        }
    }

    public void u() {
        com.kascend.chushou.c.c.dCo().c(this.P, new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.VideoPlayer.16
            @Override // com.kascend.chushou.c.b
            public void a() {
            }

            @Override // com.kascend.chushou.c.b
            public void a(String str, JSONObject jSONObject) {
                if (!VideoPlayer.this.isFinishing()) {
                    ParserRet dA = com.kascend.chushou.c.e.dA(jSONObject);
                    if (dA.mRc == 0 && dA.mData != null) {
                        CycleLiveRoomInfo cycleLiveRoomInfo = (CycleLiveRoomInfo) dA.mData;
                        if (VideoPlayer.this.mRg != null && cycleLiveRoomInfo != null && !h.isEmpty(cycleLiveRoomInfo.roomId)) {
                            FullRoomInfo dDd = VideoPlayer.this.mRg.dDd();
                            if (dDd.cycleLiveRoomInfo == null) {
                                dDd.cycleLiveRoomInfo = cycleLiveRoomInfo;
                                VideoPlayer.this.d();
                            } else if (dDd.cycleLiveRoomInfo != null && !cycleLiveRoomInfo.roomId.equals(dDd.cycleLiveRoomInfo.roomId)) {
                                dDd.cycleLiveRoomInfo.copyCycleLiveRoomInfo(cycleLiveRoomInfo);
                                VideoPlayer.this.d();
                            } else {
                                dDd.cycleLiveRoomInfo.copyCycleLiveRoomInfo(cycleLiveRoomInfo);
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
        if (this.mRe != null) {
            this.mRe.N();
        }
    }

    public void v() {
        com.kascend.chushou.c.c.dCo().a(this.P, new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.VideoPlayer.17
            @Override // com.kascend.chushou.c.b
            public void a() {
            }

            @Override // com.kascend.chushou.c.b
            public void a(String str, JSONObject jSONObject) {
                if (!VideoPlayer.this.isFinishing()) {
                    ParserRet dB = com.kascend.chushou.c.e.dB(jSONObject);
                    if (dB.mRc == 0 && dB.mData != null) {
                        PkNotifyInfo pkNotifyInfo = (PkNotifyInfo) dB.mData;
                        VideoPlayer.this.mRB.b = VideoPlayer.this.P;
                        if (pkNotifyInfo != null) {
                            VideoPlayer.this.mRB.mWq = pkNotifyInfo;
                            if (VideoPlayer.this.mRe != null) {
                                VideoPlayer.this.mRe.a(pkNotifyInfo, VideoPlayer.this.P);
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
        if (this.mRh != null) {
            this.mRh.release();
            this.mRh = null;
        }
        com.kascend.chushou.c.c.dCo().a(this.P, new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.VideoPlayer.18
            @Override // com.kascend.chushou.c.b
            public void a() {
            }

            @Override // com.kascend.chushou.c.b
            public void a(String str, JSONObject jSONObject) {
                if (!VideoPlayer.this.isFinishing()) {
                    ParserRet dC = com.kascend.chushou.c.e.dC(jSONObject);
                    if (dC.mRc == 0 && dC.mData != null) {
                        RoomExpandInfo roomExpandInfo = (RoomExpandInfo) dC.mData;
                        if (VideoPlayer.this.mRg != null) {
                            VideoPlayer.this.mRg.mSO = roomExpandInfo.mTopWebAdItem;
                            if (VideoPlayer.this.mRg.s == null) {
                                VideoPlayer.this.mRg.s = new ArrayList();
                            }
                            VideoPlayer.this.mRg.s.clear();
                            VideoPlayer.this.mRg.s.addAll(roomExpandInfo.mGiftTopRightIcons);
                            tv.chushou.zues.a.a.post(new i(50, VideoPlayer.this.mRg.mSO));
                        }
                        if (VideoPlayer.this.mRg != null) {
                            VideoPlayer.this.mRg.fm(roomExpandInfo.mExpandNavList);
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
                            VideoPlayer.this.mRx.a(list);
                        }
                        List<com.kascend.chushou.player.ui.h5.c.c> list2 = roomExpandInfo.mLuckList;
                        if (!h.isEmpty(list2)) {
                            VideoPlayer.this.mRy.a(list2);
                        }
                        com.kascend.chushou.player.ui.h5.c.c cVar = roomExpandInfo.mVoteItem;
                        if (cVar != null) {
                            VideoPlayer.this.mRz.a(cVar);
                        }
                        List<com.kascend.chushou.player.ui.h5.c.b> list3 = roomExpandInfo.mInteractH5Item;
                        if (!h.isEmpty(list3)) {
                            VideoPlayer.this.mRC.a(list3);
                        }
                        List<com.kascend.chushou.player.ui.h5.c.b> list4 = roomExpandInfo.mInteractNavItem;
                        if (!h.isEmpty(list4)) {
                            VideoPlayer.this.mRC.a(list4);
                        }
                        VideoPlayer.this.mRh = (PrivilegeInfo) dC.mData1;
                        if (VideoPlayer.this.mRh != null) {
                            tv.chushou.zues.a.a.post(new l());
                        }
                        if (VideoPlayer.this.mRg != null) {
                            VideoPlayer.this.mRg.mSV = roomExpandInfo.mIconConfig;
                            VideoPlayer.this.dCN().a(roomExpandInfo.mIconConfig.bangConfig);
                        }
                        List<SkinConfig> list5 = roomExpandInfo.skinConfig;
                        if (list5 != null && VideoPlayer.this.mRg != null) {
                            VideoPlayer.this.mRg.mSZ.clear();
                            int i = 0;
                            while (true) {
                                int i2 = i;
                                if (i2 >= list5.size()) {
                                    break;
                                }
                                SkinConfig skinConfig = list5.get(i2);
                                VideoPlayer.this.mRg.mSZ.put(skinConfig.position, skinConfig.resource);
                                i = i2 + 1;
                            }
                            VideoPlayer.this.C();
                        }
                        VideoPlayer.this.a(roomExpandInfo.mIconConfig, VideoPlayer.this.mRg != null ? VideoPlayer.this.mRg.mSZ : null);
                        if (roomExpandInfo.mColorMap != null && roomExpandInfo.mColorMap.size() > 0 && com.kascend.chushou.b.dCl().c != null && com.kascend.chushou.b.dCl().c.size() <= 0) {
                            com.kascend.chushou.b.dCl().c.putAll(roomExpandInfo.mColorMap);
                            tv.chushou.zues.a.a.post(new i(52, null));
                        }
                        AutoBang autoBang = roomExpandInfo.mAutoBang;
                        if (autoBang != null && autoBang.currentTime != 0 && autoBang.bangTime != 0) {
                            VideoPlayer.this.dCN().a(autoBang);
                        }
                        if (!h.isEmpty(roomExpandInfo.mRelatedRoomList) && VideoPlayer.this.mRg != null) {
                            VideoPlayer.this.mRg.t = roomExpandInfo.mRelatedRoomList;
                            if (VideoPlayer.this.mRe != null && VideoPlayer.this.H) {
                                VideoPlayer.this.mRe.w();
                            }
                        }
                        if (roomExpandInfo.mRoomNewUserInfo != null && roomExpandInfo.mRoomNewUserInfo.mBarrierNoviceGuide && !com.kascend.chushou.d.h.dCs().k() && VideoPlayer.this.mRe != null) {
                            VideoPlayer.this.mRe.J();
                        }
                        if (roomExpandInfo.mRoomNewUserInfo != null && roomExpandInfo.mRoomNewUserInfo.mRewardNoviceGuide && !com.kascend.chushou.d.h.dCs().l() && VideoPlayer.this.mRe != null) {
                            VideoPlayer.this.mRe.K();
                        }
                        if (!h.isEmpty(roomExpandInfo.mShopWindowInfos)) {
                            if (VideoPlayer.this.mRg != null) {
                                if (VideoPlayer.this.mRg.mSW == null) {
                                    VideoPlayer.this.mRg.mSW = new ArrayList();
                                }
                                VideoPlayer.this.mRg.mSW.addAll(roomExpandInfo.mShopWindowInfos);
                            }
                            if (VideoPlayer.this.mRe != null) {
                                VideoPlayer.this.mRe.L();
                            }
                        }
                        VideoPlayer.this.mRB.b = VideoPlayer.this.P;
                        if (roomExpandInfo.mPkNotifyInfo != null) {
                            VideoPlayer.this.mRB.mWq = roomExpandInfo.mPkNotifyInfo;
                            if (VideoPlayer.this.mRe != null) {
                                VideoPlayer.this.mRe.a(roomExpandInfo.mPkNotifyInfo, VideoPlayer.this.P);
                            }
                        } else {
                            VideoPlayer.this.mRB.mWq = null;
                        }
                        if (roomExpandInfo.mTrumpetPocket != null && VideoPlayer.this.mRg != null) {
                            VideoPlayer.this.mRg.mSY = roomExpandInfo.mTrumpetPocket;
                            if (VideoPlayer.this.mRe != null) {
                                VideoPlayer.this.mRe.M();
                            }
                        }
                        if (!h.isEmpty(roomExpandInfo.hotwordContentList)) {
                            if (VideoPlayer.this.mRg != null) {
                                if (VideoPlayer.this.mRg.mSX == null) {
                                    VideoPlayer.this.mRg.mSX = new ArrayList();
                                }
                                VideoPlayer.this.mRg.mSX.clear();
                                VideoPlayer.this.mRg.mSX.addAll(roomExpandInfo.hotwordContentList);
                            }
                            if (VideoPlayer.this.mRe != null) {
                                VideoPlayer.this.mRe.b(roomExpandInfo.hotwordContentList);
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
        }, this.mRu, this.mRD);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U() {
        if (!h.isEmpty(com.kascend.chushou.a.a.dCm().z)) {
            StringBuilder sb = new StringBuilder();
            if (com.kascend.chushou.a.a.dCm().z.contains(com.kascend.chushou.a.a.f)) {
                if (sb.length() > 0) {
                    sb.append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                sb.append(com.kascend.chushou.a.a.f);
            }
            if (com.kascend.chushou.a.a.dCm().z.contains(com.kascend.chushou.a.a.g)) {
                if (sb.length() > 0) {
                    sb.append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                sb.append(com.kascend.chushou.a.a.g);
            }
            if (com.kascend.chushou.a.a.dCm().z.contains(com.kascend.chushou.a.a.i)) {
                if (sb.length() > 0) {
                    sb.append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                sb.append(com.kascend.chushou.a.a.i);
            }
            if (com.kascend.chushou.a.a.dCm().z.contains(com.kascend.chushou.a.a.h)) {
                if (sb.length() > 0) {
                    sb.append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                sb.append(com.kascend.chushou.a.a.h);
            }
            if (com.kascend.chushou.a.a.dCm().z.contains(com.kascend.chushou.a.a.j)) {
                if (sb.length() > 0) {
                    sb.append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                sb.append(com.kascend.chushou.a.a.j);
            }
            if (com.kascend.chushou.a.a.dCm().z.contains(com.kascend.chushou.a.a.l)) {
                if (sb.length() > 0) {
                    sb.append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                sb.append(com.kascend.chushou.a.a.l);
            }
            if (com.kascend.chushou.a.a.dCm().z.contains(com.kascend.chushou.a.a.m)) {
                if (sb.length() > 0) {
                    sb.append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                sb.append(com.kascend.chushou.a.a.m);
            }
            if (sb.length() != 0) {
                com.kascend.chushou.a.a.dCm().a(sb.toString(), this.P, new a.c() { // from class: com.kascend.chushou.player.VideoPlayer.19
                    @Override // com.kascend.chushou.a.a.c
                    public void a(List<ListItem> list) {
                        if (VideoPlayer.this.mRg != null && list != null) {
                            int i = 0;
                            while (true) {
                                int i2 = i;
                                if (i2 >= list.size()) {
                                    break;
                                }
                                if (list.get(i2).mAdExtraInfo != null) {
                                    if (com.kascend.chushou.a.a.f.equals(list.get(i2).mAdExtraInfo.mCode)) {
                                        VideoPlayer.this.mRg.mSN = list.get(i2);
                                    } else if (com.kascend.chushou.a.a.g.equals(list.get(i2).mAdExtraInfo.mCode)) {
                                        VideoPlayer.this.mRg.mSM = list.get(i2);
                                    } else if (com.kascend.chushou.a.a.i.equals(list.get(i2).mAdExtraInfo.mCode)) {
                                        VideoPlayer.this.mRg.mSQ = list.get(i2);
                                    } else if (com.kascend.chushou.a.a.h.equals(list.get(i2).mAdExtraInfo.mCode)) {
                                        VideoPlayer.this.mRg.mSR = list.get(i2);
                                    } else if (com.kascend.chushou.a.a.j.equals(list.get(i2).mAdExtraInfo.mCode)) {
                                        VideoPlayer.this.mRg.mSU = list.get(i2);
                                    } else if (com.kascend.chushou.a.a.l.equals(list.get(i2).mAdExtraInfo.mCode)) {
                                        VideoPlayer.this.mRg.mSS = list.get(i2);
                                    } else if (com.kascend.chushou.a.a.m.equals(list.get(i2).mAdExtraInfo.mCode)) {
                                        VideoPlayer.this.mRg.mST = list.get(i2);
                                    }
                                }
                                i = i2 + 1;
                            }
                            if (VideoPlayer.this.mRe != null) {
                                VideoPlayer.this.mRe.H();
                            }
                        }
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str, String str2) {
        if (dCF()) {
            com.kascend.chushou.toolkit.a.a.j("type", "1", "value", str, "desc", str2, "videoId", this.P);
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
                this.mRn.setSystemUiVisibility(i);
                return;
            }
            this.mRn.setSystemUiVisibility(1792);
        }
    }

    public void f(boolean z) {
        Window window;
        View decorView;
        if (com.kascend.chushou.b.dCl().d != 1 && (window = getWindow()) != null && (decorView = window.getDecorView()) != null) {
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
        if (this.mRe != null) {
            this.mRe.a(i, i2, intent);
        }
    }

    public Uri dCG() {
        return this.mQY;
    }

    @Override // com.kascend.chushou.view.base.BaseActivity
    protected int y() {
        return 0;
    }

    public void wo(boolean z) {
        if (this.mRn != null) {
            this.mRn.obH = z;
        }
    }

    public void dCH() {
        if (this.mRn != null) {
            this.mRn.dCH();
        }
    }

    public boolean dCI() {
        return this.ae;
    }

    public void g(boolean z) {
        this.ae = z;
    }

    public void h(boolean z) {
        if (this.mRn != null) {
            this.mRn.setIsTranslucentStatus(z);
        }
    }

    public void z() {
        if (this.mRn != null) {
            this.mRn.dRr();
        }
    }

    @Override // com.kascend.chushou.widget.gifts.RoomSendGiftView.a
    public void A() {
        if (this.mRl != null) {
            this.mRl.b();
        }
    }

    @Override // com.kascend.chushou.widget.gifts.RoomSendGiftView.a
    public void B() {
        if (this.mRl != null) {
            this.mRl.b();
        }
    }

    public void a(List<ListItem> list) {
        if (this.mRe != null) {
            this.mRe.a(list);
        }
    }

    public void a(IconConfig iconConfig, Map<String, SkinConfig.SkinRes> map) {
        if (this.mRe != null) {
            this.mRe.a(iconConfig, map);
        }
    }

    public void C() {
        if (this.mRe != null) {
            this.mRe.I();
        }
    }

    @Override // com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC0707a
    public void a(int i) {
        if (this.mRe != null) {
            this.mRe.a(i);
        }
    }

    @Override // com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC0707a
    public void D() {
        if (!isFinishing() && this.mRe != null) {
            this.mRe.D();
        }
    }

    @Override // com.kascend.chushou.player.ui.h5.b.b.a
    public void a(long j) {
        if (!isFinishing() && this.mRe != null) {
            this.mRe.a(j);
        }
    }

    @Override // com.kascend.chushou.player.ui.h5.b.b.a
    public void a(com.kascend.chushou.player.ui.h5.c.a aVar) {
        if (aVar != null && this.mRe != null) {
            this.mRe.a(aVar);
        }
    }

    @Override // com.kascend.chushou.player.ui.h5.b.b.a
    public void b(int i) {
        if (this.mRe != null) {
            this.mRe.b(i);
        }
    }

    @Override // com.kascend.chushou.player.ui.h5.d.a.InterfaceC0706a
    public void b(long j) {
        if (!isFinishing() && this.mRe != null) {
            this.mRe.b(j);
        }
    }

    @Override // com.kascend.chushou.player.ui.h5.a.a.InterfaceC0704a
    public void c(int i) {
        if (!isFinishing() && this.mRe != null) {
            this.mRe.c(i);
        }
    }

    @Override // com.kascend.chushou.player.ui.h5.d.a.InterfaceC0706a
    public void b(com.kascend.chushou.player.ui.h5.c.a aVar) {
        if (aVar != null && this.mRe != null) {
            this.mRe.b(aVar);
        }
    }

    @Override // com.kascend.chushou.player.ui.a.a.InterfaceC0701a
    public void a(IconConfig.Config config) {
        if (this.mRe != null) {
            this.mRe.a(config);
        }
    }

    @Override // com.kascend.chushou.player.ui.a.a.InterfaceC0701a
    public void a(BangInfo bangInfo, String str) {
        if (this.mRe != null) {
            this.mRe.a(bangInfo, str);
        }
    }

    @Override // com.kascend.chushou.player.ui.a.a.InterfaceC0701a
    public void a(long j, BangInfo bangInfo, String str) {
        if (this.mRe != null) {
            this.mRe.a(j, bangInfo, str);
        }
    }

    public com.kascend.chushou.player.ui.h5.redpacket.a dCJ() {
        return this.mRx;
    }

    public com.kascend.chushou.player.ui.h5.b.b dCK() {
        return this.mRy;
    }

    public com.kascend.chushou.player.ui.h5.d.a dCL() {
        return this.mRz;
    }

    public com.kascend.chushou.player.ui.h5.a.a dCM() {
        return this.mRC;
    }

    public com.kascend.chushou.player.ui.a.a dCN() {
        return this.mRA;
    }

    public com.kascend.chushou.player.e.a dCO() {
        return this.mRB;
    }

    @Override // com.kascend.chushou.view.base.BaseActivity, android.app.Activity
    public void finish() {
        super.finish();
        if ("3".equals(this.R)) {
            overridePendingTransition(17432576, a.C0691a.commonres_activity_exit_bottom);
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
        RxExecutor.postDelayed(this.mRF, EventThread.MAIN_THREAD, aVar.d, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.VideoPlayer.2
            @Override // java.lang.Runnable
            public void run() {
                if (VideoPlayer.this.mRe != null) {
                    VideoPlayer.this.mRe.c(aVar);
                }
            }
        });
    }

    private void e(final com.kascend.chushou.player.ui.h5.c.a aVar) {
        if (!com.kascend.chushou.d.h.dCs().dCv().contains(aVar.b)) {
            if (aVar.d < 0) {
                aVar.d = 0;
            }
            RxExecutor.postDelayed(this.mRF, EventThread.MAIN_THREAD, aVar.d, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.VideoPlayer.3
                @Override // java.lang.Runnable
                public void run() {
                    if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.mRe != null) {
                        VideoPlayer.this.mRe.c(aVar);
                    }
                }
            });
        }
    }

    private String dCP() {
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
                if (VideoPlayer.this.mRm != null && !VideoPlayer.this.isFinishing()) {
                    VideoPlayer.n = VideoPlayer.this.mRm.getStreamVolume(3);
                }
                if (!VideoPlayer.this.isFinishing() && (VideoPlayer.this.mRe instanceof f)) {
                    ((f) VideoPlayer.this.mRe).ab();
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

    public boolean dCQ() {
        if (this.mRe instanceof com.kascend.chushou.player.d.a) {
            return ((com.kascend.chushou.player.d.a) this.mRe).dDX();
        }
        if (this.mRe instanceof com.kascend.chushou.player.e.e) {
            return true;
        }
        return false;
    }
}

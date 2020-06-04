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
public class VideoPlayer extends BaseActivity implements a.InterfaceC0805a, a.InterfaceC0808a, b.a, a.InterfaceC0810a, a.InterfaceC0811a, RoomSendGiftView.a {
    private static int A = 60000;
    public static String a = null;
    public static int n = 0;
    private String P;
    private String Q;
    private String R;
    private String S;
    private ImageView Z;
    private String ab;
    private String ag;
    public com.kascend.chushou.player.feedback.a mJC;
    private a mJE;
    private CSTVWifiReceiver mJF;
    private c mJd;
    b mJg;
    public PrivilegeInfo mJi;
    com.kascend.chushou.widget.a.b mJk;
    private KPSwitchRootRelativeLayout mJm;
    private FrameLayout mJn;
    private LinearLayout mJo;
    private com.kascend.chushou.toolkit.d mJp;
    com.kascend.chushou.view.b.a.a mJq;
    private FrescoThumbnailView mJt;
    private FrameLayout mJu;
    private boolean B = true;
    private boolean C = false;
    private Uri mIZ = null;
    private tv.chushou.common.player.a mJa = null;
    public tv.chushou.common.player.a mJb = null;
    public tv.chushou.common.player.a mJc = null;
    public boolean d = false;
    public boolean e = false;
    private e mJe = null;
    private boolean H = false;
    private com.kascend.chushou.view.user.b mJf = null;
    private boolean J = false;
    private boolean K = false;
    private boolean L = false;
    private boolean M = false;
    private long mJh = 0;
    private int O = 0;
    public boolean g = false;
    private ImageView T = null;
    private TextView U = null;
    private AnimationImageView mJj = null;
    private View byt = null;
    public boolean j = false;
    public float k = 0.0f;
    public float l = 0.0f;
    public boolean m = false;
    public AudioManager mJl = null;
    private d.a mJr = new d.a() { // from class: com.kascend.chushou.player.VideoPlayer.1
        @Override // com.kascend.chushou.toolkit.d.a
        public void a() {
            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.mJG != null) {
                VideoPlayer.this.mJG.Ks(4);
            }
        }
    };
    private boolean ae = false;
    public boolean q = true;
    public long r = -1;
    public long s = -1;
    private PowerManager.WakeLock mJs = null;
    public String t = null;
    private final com.kascend.chushou.player.ui.h5.redpacket.a mJv = new com.kascend.chushou.player.ui.h5.redpacket.a(this);
    private final com.kascend.chushou.player.ui.h5.b.b mJw = new com.kascend.chushou.player.ui.h5.b.b(this);
    private final com.kascend.chushou.player.ui.h5.d.a mJx = new com.kascend.chushou.player.ui.h5.d.a(this);
    private final com.kascend.chushou.player.ui.a.a mJy = new com.kascend.chushou.player.ui.a.a(this);
    private final com.kascend.chushou.player.e.a mJz = new com.kascend.chushou.player.e.a();
    private final com.kascend.chushou.player.ui.h5.a.a mJA = new com.kascend.chushou.player.ui.h5.a.a(this);
    private String mJB = "1";
    private String aq = "2";
    private io.reactivex.disposables.a mJD = new io.reactivex.disposables.a();
    private tv.chushou.zues.c mJG = new tv.chushou.zues.c(new Handler.Callback() { // from class: com.kascend.chushou.player.VideoPlayer.6
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            try {
                if (!VideoPlayer.this.isFinishing()) {
                    switch (message.what) {
                        case 1:
                            VideoPlayer.this.mJG.removeMessages(1);
                            com.kascend.chushou.c.c.dEj().a(VideoPlayer.this.P, VideoPlayer.this.mJg != null ? VideoPlayer.this.mJg.h : null, System.currentTimeMillis());
                            VideoPlayer.this.mJG.A(1, VideoPlayer.A);
                            break;
                        case 2:
                            VideoPlayer.this.a(true, (Uri) null, false);
                            break;
                        case 3:
                            VideoPlayer.this.S();
                            break;
                        case 4:
                            if (VideoPlayer.this.mJe != null) {
                                VideoPlayer.this.mJe.a(true);
                            }
                            if (VideoPlayer.this.mJp != null) {
                                VideoPlayer.this.mJp.d();
                                VideoPlayer.this.mJp = null;
                                break;
                            }
                            break;
                        case 5:
                            int i = message.arg1;
                            if (i == 1) {
                                if (VideoPlayer.this.mJe != null) {
                                    VideoPlayer.this.mJe.p();
                                    break;
                                }
                            } else if (i == 2 && VideoPlayer.this.mJe != null) {
                                VideoPlayer.this.mJe.e(message.arg2);
                                break;
                            }
                            break;
                        case 6:
                            if (!com.kascend.chushou.b.dEg().a && !com.kascend.chushou.b.dEg().b && VideoPlayer.this.mJe != null) {
                                VideoPlayer.this.mJe.g(true);
                                break;
                            } else {
                                VideoPlayer.this.c();
                                break;
                            }
                            break;
                        case 7:
                            tv.chushou.zues.utils.e.d(VideoPlayer.this.v, "MSG_BUFFER_DEALY: ");
                            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.mJe != null && VideoPlayer.this.M && !VideoPlayer.this.e) {
                                VideoPlayer.this.mJe.h(true);
                                VideoPlayer.this.mJh = 0L;
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
    private boolean av = false;
    private boolean mJH = true;
    private boolean mJI = false;
    private tv.chushou.common.player.b mJJ = new tv.chushou.common.player.b() { // from class: com.kascend.chushou.player.VideoPlayer.14
        @Override // tv.chushou.common.player.b
        public void dEO() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerACallback onSetVideoViewLayout");
            if (!VideoPlayer.this.isFinishing()) {
                if ((VideoPlayer.this.mJe == null || !VideoPlayer.this.mJe.H) && VideoPlayer.this.mJe != null && !VideoPlayer.this.d) {
                    VideoPlayer.this.mJe.y();
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void IV(int i) {
            if (!VideoPlayer.this.isFinishing()) {
                if ((VideoPlayer.this.mJe == null || !VideoPlayer.this.mJe.H) && VideoPlayer.this.mJe != null && !VideoPlayer.this.d) {
                    VideoPlayer.this.mJe.g(i);
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void dEP() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerACallback onCompletePlayback");
            if (!VideoPlayer.this.isFinishing()) {
                if (!h.isEmpty(VideoPlayer.this.P)) {
                    j.dEt().a(VideoPlayer.this.P, 0);
                }
                VideoPlayer.this.K = false;
                if (VideoPlayer.this.mJG != null) {
                    VideoPlayer.this.mJG.removeMessages(1);
                }
                if ((VideoPlayer.this.mJe == null || !VideoPlayer.this.mJe.H) && VideoPlayer.this.mJe != null && !VideoPlayer.this.d) {
                    VideoPlayer.this.mJG.removeMessages(7);
                    VideoPlayer.this.M = false;
                    VideoPlayer.this.mJe.z();
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void dEQ() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerACallback onVideoRenderingStart");
            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.mJe != null) {
                VideoPlayer.this.mJe.G();
            }
        }

        @Override // tv.chushou.common.player.b
        public void dER() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerACallback onPreparedPlayback");
            if (!VideoPlayer.this.isFinishing()) {
                if (VideoPlayer.this.mJe == null || !VideoPlayer.this.mJe.H) {
                    VideoPlayer.this.mJG.removeMessages(6);
                    VideoPlayer.this.mJh = 0L;
                    VideoPlayer.this.O = 0;
                    if (VideoPlayer.this.mJa != null && VideoPlayer.this.mJe != null) {
                        VideoPlayer.this.mJa.setVolume(VideoPlayer.this.mJe.J, VideoPlayer.this.mJe.J);
                    }
                    if (VideoPlayer.this.mJg != null) {
                        VideoPlayer.this.K = false;
                        FullRoomInfo dEZ = VideoPlayer.this.dEB() ? null : VideoPlayer.this.mJg.dEZ();
                        if (VideoPlayer.this.L || dEZ != null) {
                            if (VideoPlayer.this.mJg.e) {
                                VideoPlayer.this.mJg.e = false;
                                VideoPlayer.this.mJg.d = !VideoPlayer.this.mJg.d;
                            }
                            if (VideoPlayer.this.mJe != null) {
                                VideoPlayer.this.c("1", (String) null);
                                if (!VideoPlayer.this.d) {
                                    VideoPlayer.this.mJe.i(true);
                                } else if (VideoPlayer.this.e) {
                                    VideoPlayer.this.e = false;
                                    VideoPlayer.this.mJe.B();
                                }
                            }
                        }
                    }
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void IW(int i) {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerACallback onErrorAppeared");
            if (!VideoPlayer.this.isFinishing()) {
                VideoPlayer.this.c();
                VideoPlayer.this.K = false;
                if (VideoPlayer.this.mJG != null) {
                    VideoPlayer.this.mJG.removeMessages(7);
                }
                if (VideoPlayer.this.mJG != null) {
                    VideoPlayer.this.mJG.removeMessages(1);
                }
                if ((VideoPlayer.this.mJe == null || !VideoPlayer.this.mJe.H) && !VideoPlayer.this.dEv()) {
                    if (!"10004".equals(VideoPlayer.this.t)) {
                        if (VideoPlayer.this.mJe != null) {
                            if (VideoPlayer.this.d) {
                                VideoPlayer.this.mJb.stop();
                                VideoPlayer.this.mJb.release();
                                VideoPlayer.this.e = false;
                                VideoPlayer.this.mJe.C();
                            }
                            if (!com.kascend.chushou.b.dEg().a && !com.kascend.chushou.b.dEg().b) {
                                VideoPlayer.this.mJe.g(true);
                            } else if (VideoPlayer.this.d) {
                                VideoPlayer.this.mJe.a(i, true);
                            } else {
                                VideoPlayer.this.mJe.a(i, false);
                            }
                            VideoPlayer.this.c("2", (String) null);
                            return;
                        }
                        return;
                    }
                    dEP();
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void dES() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerACallback onBufferingStart");
            if (!VideoPlayer.this.isFinishing()) {
                if ((VideoPlayer.this.mJe == null || !VideoPlayer.this.mJe.H) && VideoPlayer.this.mJe != null && !VideoPlayer.this.d) {
                    VideoPlayer.this.mJe.E();
                    VideoPlayer.this.M = true;
                    long currentTimeMillis = System.currentTimeMillis();
                    VideoPlayer.this.mJG.removeMessages(7);
                    if (!VideoPlayer.this.g) {
                        VideoPlayer.y(VideoPlayer.this);
                    }
                    tv.chushou.zues.utils.e.d(VideoPlayer.this.v, "currentTime: -- >" + currentTimeMillis + "  bufferTime-->" + VideoPlayer.this.mJh + "  bufferCount-->" + VideoPlayer.this.O);
                    if (currentTimeMillis - VideoPlayer.this.mJh >= 20000 || VideoPlayer.this.O < 2 || VideoPlayer.this.mJe.H) {
                        if (VideoPlayer.this.O == 1) {
                            VideoPlayer.this.mJh = currentTimeMillis;
                        }
                        VideoPlayer.this.mJG.A(7, 5000L);
                    } else {
                        VideoPlayer.this.mJG.Ks(7);
                    }
                    if (VideoPlayer.this.g) {
                        VideoPlayer.this.g = false;
                    }
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void dET() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerACallback onBufferingEnd");
            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.mJe != null && !VideoPlayer.this.d) {
                VideoPlayer.this.mJG.removeMessages(7);
                VideoPlayer.this.M = false;
                if (VideoPlayer.this.mJe == null || !VideoPlayer.this.mJe.H) {
                    if (VideoPlayer.this.mJa == null) {
                        VideoPlayer.this.mJe.a(false, true, false);
                    } else {
                        VideoPlayer.this.mJe.a(true, VideoPlayer.this.mJa.getPlayState() == 4, VideoPlayer.this.mJa.getPlayState() == 5);
                    }
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void dEU() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerACallback onPlayerStart");
            if (!VideoPlayer.this.isFinishing()) {
                if (VideoPlayer.this.mJe == null || !VideoPlayer.this.mJe.H) {
                    if (VideoPlayer.this.mJe != null && !VideoPlayer.this.d) {
                        if (VideoPlayer.this.mJa != null) {
                            VideoPlayer.this.mJe.F();
                            VideoPlayer.this.mJe.a(true, VideoPlayer.this.mJa.getPlayState() == 4, VideoPlayer.this.mJa.getPlayState() == 5);
                        } else {
                            VideoPlayer.this.mJe.a(false, true, false);
                        }
                    }
                    if (VideoPlayer.this.mJG != null && !VideoPlayer.this.dEB()) {
                        VideoPlayer.this.mJG.removeMessages(1);
                        VideoPlayer.this.mJG.A(1, VideoPlayer.A);
                    }
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void dEV() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerACallback onPlayerPause");
            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.mJG != null) {
                VideoPlayer.this.mJG.removeMessages(1);
            }
        }

        @Override // tv.chushou.common.player.b
        public void dEW() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerACallback onPlayerStop");
            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.dEB() && VideoPlayer.this.mJb != null && !h.isEmpty(VideoPlayer.this.P) && VideoPlayer.this.mJb.getCurrentPos() > 0) {
                j.dEt().a(VideoPlayer.this.P, VideoPlayer.this.mJb.getCurrentPos());
            }
        }
    };
    private tv.chushou.common.player.b mJK = new tv.chushou.common.player.b() { // from class: com.kascend.chushou.player.VideoPlayer.15
        @Override // tv.chushou.common.player.b
        public void dEO() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerBCallback onSetVideoViewLayout");
            if (!VideoPlayer.this.isFinishing()) {
                if ((VideoPlayer.this.mJe == null || !VideoPlayer.this.mJe.H) && VideoPlayer.this.mJe != null && VideoPlayer.this.d) {
                    VideoPlayer.this.mJe.y();
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void IV(int i) {
            if (!VideoPlayer.this.isFinishing()) {
                if ((VideoPlayer.this.mJe == null || !VideoPlayer.this.mJe.H) && VideoPlayer.this.mJe != null && VideoPlayer.this.d) {
                    VideoPlayer.this.mJe.g(i);
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void dEP() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerBCallback onCompletePlayback");
            if (!VideoPlayer.this.isFinishing()) {
                if (!h.isEmpty(VideoPlayer.this.P)) {
                    j.dEt().a(VideoPlayer.this.P, 0);
                }
                VideoPlayer.this.K = false;
                if (VideoPlayer.this.mJG != null) {
                    VideoPlayer.this.mJG.removeMessages(1);
                }
                if ((VideoPlayer.this.mJe == null || !VideoPlayer.this.mJe.H) && VideoPlayer.this.mJe != null && VideoPlayer.this.d) {
                    VideoPlayer.this.mJG.removeMessages(7);
                    VideoPlayer.this.M = false;
                    VideoPlayer.this.mJe.z();
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void dEQ() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerBCallback onVideoRenderingStart");
            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.mJe != null) {
                VideoPlayer.this.mJe.G();
            }
        }

        @Override // tv.chushou.common.player.b
        public void dER() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerBCallback onPreparedPlayback");
            if (!VideoPlayer.this.isFinishing()) {
                if (VideoPlayer.this.mJe == null || !VideoPlayer.this.mJe.H) {
                    VideoPlayer.this.mJG.removeMessages(6);
                    VideoPlayer.this.mJh = 0L;
                    VideoPlayer.this.O = 0;
                    if (VideoPlayer.this.mJa != null && VideoPlayer.this.mJe != null) {
                        VideoPlayer.this.mJa.setVolume(VideoPlayer.this.mJe.J, VideoPlayer.this.mJe.J);
                    }
                    if (VideoPlayer.this.mJg != null) {
                        VideoPlayer.this.K = false;
                        FullRoomInfo dEZ = VideoPlayer.this.dEB() ? null : VideoPlayer.this.mJg.dEZ();
                        if (VideoPlayer.this.L || dEZ != null) {
                            if (VideoPlayer.this.mJg.e) {
                                VideoPlayer.this.mJg.e = false;
                                VideoPlayer.this.mJg.d = !VideoPlayer.this.mJg.d;
                            }
                            if (VideoPlayer.this.mJe != null) {
                                VideoPlayer.this.c("1", (String) null);
                                if (VideoPlayer.this.d) {
                                    VideoPlayer.this.mJe.i(true);
                                } else if (VideoPlayer.this.e) {
                                    VideoPlayer.this.e = false;
                                    VideoPlayer.this.mJe.B();
                                }
                            }
                        }
                    }
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void IW(int i) {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerBCallback onErrorAppeared");
            if (!VideoPlayer.this.isFinishing()) {
                VideoPlayer.this.c();
                VideoPlayer.this.K = false;
                if (VideoPlayer.this.mJG != null) {
                    VideoPlayer.this.mJG.removeMessages(7);
                }
                if (VideoPlayer.this.mJG != null) {
                    VideoPlayer.this.mJG.removeMessages(1);
                }
                if ((VideoPlayer.this.mJe == null || !VideoPlayer.this.mJe.H) && !VideoPlayer.this.dEv()) {
                    if (!"10004".equals(VideoPlayer.this.t)) {
                        if (VideoPlayer.this.mJe != null) {
                            if (!VideoPlayer.this.d) {
                                VideoPlayer.this.mJc.stop();
                                VideoPlayer.this.mJc.release();
                                VideoPlayer.this.mJe.C();
                                VideoPlayer.this.e = false;
                            }
                            if (!com.kascend.chushou.b.dEg().a && !com.kascend.chushou.b.dEg().b) {
                                VideoPlayer.this.mJe.g(true);
                            } else if (VideoPlayer.this.d) {
                                VideoPlayer.this.mJe.a(i, false);
                            } else {
                                VideoPlayer.this.mJe.a(i, true);
                            }
                            VideoPlayer.this.c("2", (String) null);
                            return;
                        }
                        return;
                    }
                    dEP();
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void dES() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerBCallback onBufferingStart");
            if (!VideoPlayer.this.isFinishing()) {
                if ((VideoPlayer.this.mJe == null || !VideoPlayer.this.mJe.H) && VideoPlayer.this.mJe != null && VideoPlayer.this.d) {
                    VideoPlayer.this.mJe.E();
                    VideoPlayer.this.M = true;
                    VideoPlayer.this.mJG.removeMessages(7);
                    long currentTimeMillis = System.currentTimeMillis();
                    if (!VideoPlayer.this.g) {
                        VideoPlayer.y(VideoPlayer.this);
                    }
                    tv.chushou.zues.utils.e.d(VideoPlayer.this.v, "currentTime: -- >" + currentTimeMillis + "  bufferTime-->" + VideoPlayer.this.mJh + "  bufferCount-->" + VideoPlayer.this.O);
                    if (currentTimeMillis - VideoPlayer.this.mJh >= 20000 || VideoPlayer.this.O < 2 || VideoPlayer.this.mJe.H) {
                        if (VideoPlayer.this.O == 1) {
                            VideoPlayer.this.mJh = currentTimeMillis;
                        }
                        VideoPlayer.this.mJG.A(7, 5000L);
                    } else {
                        VideoPlayer.this.mJh = 0L;
                        VideoPlayer.this.O = 0;
                        VideoPlayer.this.mJG.Ks(7);
                    }
                    if (VideoPlayer.this.g) {
                        VideoPlayer.this.g = false;
                    }
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void dET() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerBCallback onBufferingEnd");
            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.mJe != null && VideoPlayer.this.d) {
                VideoPlayer.this.M = false;
                VideoPlayer.this.mJG.removeMessages(7);
                if (VideoPlayer.this.mJe == null || !VideoPlayer.this.mJe.H) {
                    if (VideoPlayer.this.mJa == null) {
                        VideoPlayer.this.mJe.a(false, true, false);
                    } else {
                        VideoPlayer.this.mJe.a(true, VideoPlayer.this.mJa.getPlayState() == 4, VideoPlayer.this.mJa.getPlayState() == 5);
                    }
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void dEU() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerBCallback onPlayerStart");
            if (!VideoPlayer.this.isFinishing()) {
                if (VideoPlayer.this.mJe == null || !VideoPlayer.this.mJe.H) {
                    if (VideoPlayer.this.mJe != null && VideoPlayer.this.d) {
                        if (VideoPlayer.this.mJa != null) {
                            VideoPlayer.this.mJe.F();
                            VideoPlayer.this.mJe.a(true, VideoPlayer.this.mJa.getPlayState() == 4, VideoPlayer.this.mJa.getPlayState() == 5);
                        } else {
                            VideoPlayer.this.mJe.a(false, true, false);
                        }
                    }
                    if (VideoPlayer.this.mJG != null && !VideoPlayer.this.dEB()) {
                        VideoPlayer.this.mJG.removeMessages(1);
                        VideoPlayer.this.mJG.A(1, VideoPlayer.A);
                    }
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void dEV() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerBCallback onPlayerPause");
            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.mJG != null) {
                VideoPlayer.this.mJG.removeMessages(1);
            }
        }

        @Override // tv.chushou.common.player.b
        public void dEW() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerBCallback onPlayerStop");
            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.dEB() && VideoPlayer.this.mJc != null && !h.isEmpty(VideoPlayer.this.P) && VideoPlayer.this.mJc.getCurrentPos() > 0) {
                j.dEt().a(VideoPlayer.this.P, VideoPlayer.this.mJc.getCurrentPos());
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
        this.mIZ = intent.getData();
        if (this.mIZ == null) {
            finish();
            return;
        }
        com.kascend.chushou.d.e.j();
        if (this.mJF == null) {
            this.mJF = new CSTVWifiReceiver();
            registerReceiver(this.mJF, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        }
        com.kascend.chushou.toolkit.d.a.dGr().b();
        tv.chushou.zues.utils.e.i(this.v, "intent.getData=" + this.mIZ.toString());
        String scheme = this.mIZ.getScheme();
        if (scheme == null || !scheme.equals("chushou")) {
            tv.chushou.zues.utils.e.e(this.v, "not support scheme :" + scheme);
            finish();
            return;
        }
        a(intent);
    }

    private void a(Intent intent) {
        this.P = this.mIZ.getQueryParameter("roomId");
        this.Q = this.P;
        this.S = this.mIZ.getQueryParameter(WebSocketRequest.PARAM_KEY_PROTOCOLS);
        this.aq = this.mIZ.getQueryParameter("liveType");
        if ("2".equals(this.aq) || "3".equals(this.aq) || "4".equals(this.aq)) {
            this.mJB = "2";
            this.mJC = new com.kascend.chushou.player.feedback.a();
            if (this.mJC.mRQ != null) {
                this.mJC.mRQ.reset();
                this.mJC.mRQ.roomId = this.P;
                this.mJC.mRQ.enterType = 1;
                this.mJC.b = System.currentTimeMillis();
            }
        }
        if (h.isEmpty(this.P) || h.isEmpty(this.S)) {
            tv.chushou.zues.utils.e.e(this.v, "invalid param mItemID=" + this.P + " protocols=" + this.S);
            finish();
            return;
        }
        if (com.kascend.chushou.b.dEg().d == -1) {
            com.kascend.chushou.b.dEg().d = com.kascend.chushou.d.g.b() ? 1 : 0;
        }
        this.mJs = ((PowerManager) getSystemService("power")).newWakeLock(536870938, this.v);
        this.mJs.acquire();
        this.mJg = new b(this.P);
        this.mJg.d = intent.getBooleanExtra("room_play_audio", false);
        this.mJk = new com.kascend.chushou.widget.a.b();
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
        this.mJm = (KPSwitchRootRelativeLayout) findViewById(a.f.rlRoot);
        if (!"2".equals(this.mJB) && com.kascend.chushou.b.dEg().d == 1) {
            this.mJm.setFitsSystemWindows(true);
        }
        this.mJn = (FrameLayout) this.mJm.findViewById(a.f.fl_fragment);
        this.byt = this.mJm.findViewById(a.f.rl_empty);
        this.T = (ImageView) this.byt.findViewById(a.f.iv_empty);
        this.U = (TextView) this.byt.findViewById(a.f.tv_empty);
        this.mJo = (LinearLayout) this.mJm.findViewById(a.f.rl_title);
        this.Z = (ImageView) this.mJo.findViewById(a.f.back_icon);
        this.Z.setOnClickListener(new View.OnClickListener() { // from class: com.kascend.chushou.player.VideoPlayer.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayer.this.finish();
            }
        });
        this.mJj = (AnimationImageView) this.byt.findViewById(a.f.iv_loading);
        this.mJt = (FrescoThumbnailView) this.mJm.findViewById(a.f.live_cover);
        this.mJu = (FrameLayout) this.mJm.findViewById(a.f.fl_cover);
        this.k = dEu();
        try {
            this.mJl = (AudioManager) getApplicationContext().getSystemService("audio");
            n = this.mJl.getStreamVolume(3);
            this.mJl.requestAudioFocus(null, 3, 1);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (this.B) {
            a(1, dEB() ? "3" : "1");
        } else {
            r();
        }
        if (com.kascend.chushou.b.dEg().b && !com.kascend.chushou.b.dEg().a) {
            RxExecutor.postDelayed(this.mJD, EventThread.MAIN_THREAD, 60L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.VideoPlayer.5
                @Override // java.lang.Runnable
                public void run() {
                    if (!VideoPlayer.this.isFinishing() && com.kascend.chushou.b.dEg().b && !com.kascend.chushou.b.dEg().a) {
                        tv.chushou.zues.utils.g.c(VideoPlayer.this.w, VideoPlayer.this.getString(a.i.str_monet_notify));
                    }
                }
            });
        }
        com.kascend.chushou.c.c.dEj().a(this.P, stringExtra, System.currentTimeMillis());
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
        if (this.mJE == null) {
            this.mJE = new a();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.media.VOLUME_CHANGED_ACTION");
            registerReceiver(this.mJE, intentFilter);
        }
    }

    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        j(false);
        if (this.mJE != null) {
            unregisterReceiver(this.mJE);
            this.mJE = null;
        }
        super.onStop();
    }

    @Override // com.kascend.chushou.view.base.BaseActivity
    protected void a(boolean z) {
        if (this.mJe != null) {
            this.mJe.k(z);
        }
    }

    @Subscribe
    public void onHideGiftEffectEvent(com.kascend.chushou.b.a.a.f fVar) {
        if (fVar.b) {
            this.mJe.k();
            return;
        }
        this.mJe.m();
        this.mJe.l();
    }

    private float dEu() {
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
            this.mJg.h = jSONObject.toString();
            String optString = jSONObject.optString("_thumb");
            jSONObject.optBoolean("tag_from_game_mic", false);
            if (!h.isEmpty(optString)) {
                this.ab = optString;
            }
        } catch (JSONException e) {
            e.printStackTrace();
            this.mJg.h = str;
        }
        if (dEB()) {
            a(this.P, str);
            aY(this.P, z);
            return;
        }
        a = this.P;
        b(this.P, str);
        a(this.P, dEL(), z);
        w();
    }

    private void O() {
        this.m = true;
        j();
        if (this.mJe != null) {
            this.mJe.r();
        }
        s();
    }

    @Subscribe
    public void onStartRoomEvent(o oVar) {
        if (!isFinishing() && oVar.mIG != null && oVar.c != null && !h.isEmpty(oVar.mIG.mTargetKey)) {
            if (oVar.c != this) {
                tv.chushou.zues.utils.e.e(this.v, "different player!");
                return;
            }
            if (this.mJg != null) {
                this.mJg.a();
                this.mJg.a = oVar.mIG.mTargetKey;
                this.mJg.d = oVar.d;
                if (this.mJg.mKF != null) {
                    this.mJg.mKF.e();
                }
                if (this.mJg.mKF != null) {
                    this.mJg.mKF.b();
                }
                this.mJg.mKI = null;
                this.mJg.mKH = null;
                this.mJg.mKL = null;
                this.mJg.mKK = null;
                this.mJg.mKO = null;
                this.mJg.mKM = null;
                this.mJg.mKN = null;
            }
            if (this.mJl != null) {
                n = this.mJl.getStreamVolume(3);
            }
            if (!h.isEmpty(oVar.mIG.mType) && oVar.mIG.mType.equals("3")) {
                this.B = false;
                this.mJB = "1";
                r();
                this.P = oVar.mIG.mTargetKey;
                this.R = "3";
                if (this.mJk != null) {
                    this.mJk.a();
                }
                if (this.mJg != null) {
                    this.mJg.a((PlayUrl) null);
                    this.mJg.f();
                    if (this.mJg.c() != null) {
                        this.mJg.c().clear();
                    }
                    this.mJg.i.clear();
                }
                if (this.mJe != null) {
                    this.mJe.j();
                }
                s();
                if (this.mJp != null) {
                    this.mJp.d();
                    this.mJp = null;
                }
                if (this.mJD != null) {
                    this.mJD.dispose();
                    this.mJD = new io.reactivex.disposables.a();
                }
                a(oVar.e, false);
                return;
            }
            boolean z = this.R != null && this.R.equals("1");
            this.R = "1";
            this.mJy.a();
            this.mJx.a();
            this.mJw.a();
            this.mJv.c();
            this.mJA.a();
            if (this.mJD != null) {
                this.mJD.dispose();
                this.mJD = new io.reactivex.disposables.a();
            }
            if ("1".equals(oVar.f)) {
                this.H = false;
                if (this.mJg != null && !h.isEmpty(this.mJg.t)) {
                    this.mJg.t.clear();
                }
                this.ab = oVar.mIG.mCover;
                this.mJu.setVisibility(0);
                this.mJt.setBlur(true);
                this.mJt.i(oVar.mIG.mCover, 0, 0, 0);
            }
            if (!oVar.mIG.mTargetKey.equals(this.P)) {
                this.aq = oVar.g;
                if (!z) {
                    this.B = false;
                    r();
                } else if (!"2".equals(this.mJB) && ("2".equals(this.aq) || "3".equals(this.aq) || "4".equals(this.aq))) {
                    this.mJB = "2";
                    this.mJC = new com.kascend.chushou.player.feedback.a();
                    if (this.mJC.mRQ != null) {
                        this.mJC.mRQ.reset();
                        this.mJC.mRQ.roomId = oVar.mIG.mTargetKey;
                        this.mJC.mRQ.enterType = 1;
                        this.mJC.b = System.currentTimeMillis();
                    }
                }
                this.B = false;
                this.P = oVar.mIG.mTargetKey;
                this.Q = this.P;
                this.ab = oVar.mIG.mCover;
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
                JSONObject P = com.kascend.chushou.d.e.P("_fromView", str, "_sc", oVar.mIG.mSC);
                com.kascend.chushou.toolkit.a.c.a(this.w, P);
                if (this.mJk != null) {
                    this.mJk.a();
                    this.mJk.a(this.P);
                }
                if (this.mJg != null) {
                    this.mJg.a((PlayUrl) null);
                    this.mJg.f();
                    if (this.mJg.c() != null) {
                        this.mJg.c().clear();
                    }
                    this.mJg.i.clear();
                }
                if (this.mJe != null) {
                    this.mJe.j();
                }
                a(P.toString(), false);
                return;
            }
            tv.chushou.zues.utils.g.KB(a.i.str_same_room);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dEv() {
        FullRoomInfo dEZ;
        String str;
        RoomInfo roomInfo;
        if (dEB()) {
            str = null;
            dEZ = null;
        } else {
            dEZ = this.mJg.dEZ();
            str = (dEZ == null || (roomInfo = dEZ.mRoominfo) == null) ? null : roomInfo.mGameId;
        }
        return !this.L && (dEZ == null || h.isEmpty(str));
    }

    @Subscribe
    public void onMessageEvent(i iVar) {
        if (!isFinishing() && iVar.a != 21 && iVar.a != 22) {
            if (iVar.a == 0 && (iVar.b instanceof Boolean)) {
                if (((Boolean) iVar.b).booleanValue() && !isFinishing()) {
                    w();
                    if (this.mJe != null) {
                        this.mJe.f();
                    }
                }
            } else if (iVar.a == 46) {
                if ((iVar.b instanceof String) && this.mJe != null) {
                    this.mJe.c((String) iVar.b);
                }
            } else if (iVar.a == 54) {
                if (iVar.b instanceof String) {
                    this.mJw.a((String) iVar.b);
                }
            } else if (iVar.a == 55) {
                if (this.mJe != null) {
                    this.mJe.O();
                }
            } else if (iVar.a == 56 && this.mJe != null) {
                this.mJe.P();
            }
        }
    }

    @Subscribe
    public void onRefreshSubscribeEvent(m mVar) {
        if (isFinishing() && this.mJg != null && this.mJg.dFc() != null) {
            RoomInfo dFc = this.mJg.dFc();
            if (mVar.a(dFc.mCreatorUID, dFc.mRoomID)) {
                dFc.mIsSubscribed = mVar.c;
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
        if (this.m || this.mJb == null || this.mJc == null) {
            R();
        }
        if (this.mJk != null) {
            this.mJk.d();
        }
        if (!dEB()) {
            if (this.mJp != null && !this.mJp.c()) {
                this.mJp.a();
            }
            v();
            if (this.mJg != null && this.mJg.dEZ() != null && this.mJg.dEZ().cycleLiveRoomInfo != null && !h.isEmpty(this.mJg.dEZ().cycleLiveRoomInfo.roomId)) {
                u();
            }
        }
        super.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.view.base.BaseActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        tv.chushou.zues.utils.e.e(this.v, MissionEvent.MESSAGE_DESTROY);
        if (this.mJg != null && this.mJg.dEZ() != null && this.mJg.dEZ().cycleLiveRoomInfo != null && !h.isEmpty(this.mJg.dEZ().cycleLiveRoomInfo.eventName)) {
            j.dEt().a(this.P + dEL());
        }
        if ("2".equals(this.mJB) && this.mJC != null && this.mJC.mRQ != null) {
            this.mJC.mRQ.time = System.currentTimeMillis() - this.mJC.b;
            this.mJC.a();
            this.mJC.b();
        }
        this.mJv.d();
        this.mJw.b();
        this.mJx.b();
        O();
        this.ag = null;
        a = null;
        if (this.mJG != null) {
            this.mJG.cg(null);
            this.mJG = null;
        }
        if (this.mJp != null) {
            this.mJp.d();
            this.mJp = null;
        }
        if (this.mJk != null) {
            this.mJk.c();
            this.mJk = null;
        }
        if (this.mJg != null) {
            this.mJg.mKI = null;
            this.mJg.mKH = null;
        }
        if (this.mJg != null) {
            this.mJg.b();
            this.mJg = null;
        }
        this.mIZ = null;
        this.mJe = null;
        this.mJf = null;
        this.mJi = null;
        this.T = null;
        this.U = null;
        this.mJj = null;
        this.byt = null;
        this.mJl = null;
        this.mJm = null;
        this.mJn = null;
        this.Z = null;
        this.mJo = null;
        if (this.mJs != null && this.mJs.isHeld()) {
            this.mJs.release();
            this.mJs = null;
        }
        if (this.mJF != null) {
            unregisterReceiver(this.mJF);
            this.mJF = null;
        }
        h.dSd();
        tv.chushou.zues.a.a.ch(this);
        this.mJD.dispose();
        this.mJx.b();
        this.mJy.b();
        this.mJv.d();
        this.mJw.b();
        this.mJA.b();
        super.onDestroy();
        System.gc();
    }

    @Subscribe
    public void onSendGameGiftEvent(n nVar) {
        if (!isFinishing() && this.mJe != null) {
            this.mJe.a(nVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.view.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        tv.chushou.zues.utils.e.d(this.v, MissionEvent.MESSAGE_PAUSE);
        if (this.mJp != null) {
            this.mJp.b();
        }
        if (this.mJk != null) {
            this.mJk.b(false);
        }
        k();
        this.m = true;
        super.onPause();
    }

    @Override // android.app.Activity
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.mJe != null ? this.mJe.a(motionEvent) : super.onTouchEvent(motionEvent);
    }

    public void c() {
        if ("1".equals(this.R)) {
            j.dEt().a(this.P + dEL());
        } else {
            j.dEt().b(this.P);
        }
    }

    private void a(boolean z, boolean z2) {
        int i = 0;
        tv.chushou.zues.utils.e.i(this.v, "startLoadingVideo <------------- mbPrepareingVideo = " + this.K);
        if (this.mJb != null) {
            this.mJb.setHardwearDecod(com.kascend.chushou.d.h.dEn().a);
        }
        if (this.mJc != null) {
            this.mJc.setHardwearDecod(com.kascend.chushou.d.h.dEn().a);
        }
        if (this.mJa != null) {
            this.mJa.setHardwearDecod(com.kascend.chushou.d.h.dEn().a);
        }
        if (!this.K) {
            if (z && this.mJe != null) {
                if (!z2) {
                    this.t = null;
                    this.mJe.e();
                }
            } else if (this.mJe != null && !z2) {
                this.t = null;
                this.mJe.H = false;
                RxExecutor.post(null, EventThread.MAIN_THREAD, new Runnable() { // from class: com.kascend.chushou.player.VideoPlayer.7
                    @Override // java.lang.Runnable
                    public void run() {
                        VideoPlayer.this.mJe.x();
                    }
                });
            }
            this.K = true;
            if (this.mJg != null && this.mJg.dFa() != null) {
                PlayUrl dFa = this.mJg.dFa();
                while (true) {
                    int i2 = i;
                    if (i2 >= dFa.mUrlDetails.size()) {
                        break;
                    }
                    UrlDetails urlDetails = dFa.mUrlDetails.get(i2);
                    if (urlDetails.mUrl.equals(dFa.mSelectedUrl)) {
                        String str = dFa.mUrlDetails.get(i2).mDefinitionType;
                        String str2 = urlDetails.mBitrate;
                    }
                    i = i2 + 1;
                }
            }
            if (z2) {
                if (this.d) {
                    this.mJb.setVideoURI(this.mIZ);
                    this.mJb.open();
                    return;
                }
                this.mJc.setVideoURI(this.mIZ);
                this.mJc.open();
                return;
            }
            this.mJa.setVideoURI(this.mIZ);
            this.mJa.open();
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        try {
            if (motionEvent.getAction() == 0) {
                if (this.mJe != null && this.mJe.b(motionEvent)) {
                    return true;
                }
                if ("2".equals(this.mJB) && this.mJe != null) {
                    this.mJe.a(motionEvent);
                }
            } else if (this.mJe != null && this.mJe.b(motionEvent)) {
                return true;
            }
            return super.dispatchTouchEvent(motionEvent);
        } catch (Exception e) {
            return false;
        }
    }

    @Override // android.support.v7.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.mJe != null && this.mJe.a(i, keyEvent)) {
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
        if (this.mJg != null && this.mJg.dEZ() != null && this.mJg.dEZ().cycleLiveRoomInfo != null && !h.isEmpty(this.mJg.dEZ().cycleLiveRoomInfo.roomId)) {
            this.mJu.setVisibility(0);
            this.mJt.setBlur(true);
            this.mJt.i(this.mJg.dEZ().cycleLiveRoomInfo.avatar, 0, 0, 0);
            this.mJt.setVisibility(0);
            j.dEt().a(this.P + dEL());
            this.mIZ = null;
            R();
            this.Q = this.mJg.dEZ().cycleLiveRoomInfo.roomId;
            a(this.P, dEL(), false);
        }
    }

    public void b(boolean z) {
        if (this.mJe != null) {
            this.mJe.j(z);
        }
    }

    public void a(boolean z, Uri uri, boolean z2) {
        tv.chushou.zues.utils.e.d(this.v, "loadIfNecessary reload=" + z + " isChangeLines-->" + z2);
        if (this.mJb != null && this.mJc != null) {
            if (uri != null) {
                this.mIZ = uri;
            }
            if (z2) {
                this.e = z2;
            }
            this.M = false;
            this.mJh = 0L;
            this.O = 0;
            this.mJG.removeMessages(7);
            if (z) {
                if (z2) {
                    if (!this.d) {
                        this.mJc.setOnActivityCallBack(this.mJK);
                    } else {
                        this.mJb.setOnActivityCallBack(this.mJJ);
                    }
                } else if (this.d) {
                    this.mJc.setOnActivityCallBack(this.mJK);
                } else {
                    this.mJb.setOnActivityCallBack(this.mJJ);
                }
                this.K = false;
                b(true, z2);
            } else if (!this.J) {
                b(true, z2);
            }
            this.mJG.A(6, 3000L);
        }
    }

    private void b(boolean z, boolean z2) {
        VideoPlayInfo M;
        if ("1".equals(this.R)) {
            M = j.dEt().L(this.P + dEL(), KeepJobService.JOB_CHECK_PERIODIC);
        } else {
            M = j.dEt().M(this.P, KeepJobService.JOB_CHECK_PERIODIC);
        }
        if (M != null) {
            a(z, z2);
        } else if ("1".equals(this.R)) {
            a(this.P, dEL(), false);
        } else {
            aY(this.P, false);
        }
    }

    public tv.chushou.common.player.a dEw() {
        return this.mJa;
    }

    public tv.chushou.common.player.a dEx() {
        return this.mJb;
    }

    public tv.chushou.common.player.a dEy() {
        return this.mJc;
    }

    public void a(tv.chushou.common.player.a aVar) {
        this.mJa = aVar;
    }

    public b dEz() {
        return this.mJg;
    }

    public com.kascend.chushou.widget.a.b dEA() {
        return this.mJk;
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
        FullRoomInfo dEZ;
        this.r = -1L;
        if (this.s != -1 && this.s != 0) {
            this.r = this.s;
            this.s = -1L;
        }
        if (dEB() && this.mJa != null && this.mJa.getPlayState() == 4) {
            this.r = this.mJa.getCurrentPos();
        }
        this.av = false;
        tv.chushou.zues.utils.e.d(this.v, "screenChange()<-----");
        tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard(this);
        if (str != null) {
            this.R = str;
        }
        if (!this.C || !z3 || "3".equals(this.R) || this.mJg == null || (dEZ = this.mJg.dEZ()) == null || dEZ.mRoominfo == null || dEZ.mRoominfo.mStyle != 1) {
            z5 = false;
        } else {
            z5 = true;
            i = 0;
        }
        if ("2".equals(this.mJB)) {
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
            if (com.kascend.chushou.b.dEg().d == 1) {
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
            ((VideoPlayer) this.w).wA(false);
            ((VideoPlayer) this.w).g(true);
            if (z5) {
                setRequestedOrientation(1);
            } else {
                setRequestedOrientation(6);
            }
            getWindow().addFlags(512);
            getWindow().addFlags(256);
        }
        if (this.mJk == null) {
            this.mJk = new com.kascend.chushou.widget.a.b();
        }
        if (this.mJk != null) {
            this.mJk.a(this.P);
        }
        if (this.R.equals("5")) {
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            if (this.mJe != null) {
                beginTransaction.remove(this.mJe);
                this.mJe = null;
            }
            if (this.mJf != null) {
                beginTransaction.remove(this.mJf);
                this.mJf = null;
            }
            this.mJf = new com.kascend.chushou.view.user.b();
            beginTransaction.add(a.f.fl_fragment, this.mJf);
            beginTransaction.commitAllowingStateLoss();
        } else {
            FragmentTransaction beginTransaction2 = getSupportFragmentManager().beginTransaction();
            if (this.mJe != null) {
                beginTransaction2.remove(this.mJe);
                this.mJe = null;
            }
            if (this.mJf != null) {
                beginTransaction2.remove(this.mJf);
                this.mJf = null;
            }
            if ("2".equals(this.mJB)) {
                this.mJe = com.kascend.chushou.player.e.e.b(this.ab, z2, this.aq, this.P);
            } else if (1 == i) {
                if (!this.R.equals("3")) {
                    if (z4) {
                        v();
                    }
                    this.mJe = new com.kascend.chushou.player.d.a();
                    Bundle bundle = new Bundle();
                    bundle.putString("mCover", this.ab);
                    bundle.putBoolean("mInitViewAsync", z2);
                    this.mJe.setArguments(bundle);
                }
            } else {
                this.mJe = new com.kascend.chushou.player.d.b();
                Bundle bundle2 = new Bundle();
                if (z5) {
                    i = 1;
                }
                bundle2.putInt("mExtraOrientation", i);
                bundle2.putString("mViewType", this.R);
                this.mJe.setArguments(bundle2);
            }
            beginTransaction2.add(a.f.fl_fragment, this.mJe);
            beginTransaction2.commitAllowingStateLoss();
            this.H = true;
        }
        tv.chushou.zues.utils.e.d(this.v, "screenChange()----->");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dEB() {
        return this.R != null && this.R.equals("3");
    }

    private void R() {
        if (this.mJe != null) {
            this.mJe.mNX = null;
        }
        if (this.mJa != null) {
            this.mJa.release();
            this.mJa = null;
            this.K = false;
        }
        if (this.mJb != null) {
            this.mJb.release();
            this.mJb = null;
        }
        if (this.mJc != null) {
            this.mJc.release();
            this.mJc = null;
        }
        if (this.mJd != null) {
            this.mJd.c();
        }
        this.d = false;
        this.e = false;
        this.M = false;
        this.mJd = new c();
        this.mJb = this.mJd.dFf();
        this.mJb.setOnActivityCallBack(this.mJJ);
        this.mJc = this.mJd.dFg();
        this.mJc.setOnActivityCallBack(this.mJK);
        if (!this.d) {
            this.mJa = this.mJb;
        } else {
            this.mJa = this.mJc;
        }
        if (this.mJe != null) {
            this.mJe.mNX = this.mJa;
        }
    }

    public void j() {
        if (this.mJa != null) {
            this.mJa.pause();
            this.mJa.stop();
            this.mJa.release();
            this.mJa = null;
        }
        if (this.mJb != null) {
            this.mJb.stop();
            this.mJb.release();
            this.mJb = null;
        }
        if (this.mJc != null) {
            this.mJc.stop();
            this.mJc.release();
            this.mJc = null;
        }
        if (this.mJd != null) {
            this.mJd.c();
        }
    }

    public void k() {
        tv.chushou.common.player.a aVar = this.mJa;
        if (aVar != null) {
            aVar.pause();
            aVar.stop();
        }
        tv.chushou.common.player.a aVar2 = this.mJb;
        if (aVar2 != null) {
            aVar2.stop();
        }
        tv.chushou.common.player.a aVar3 = this.mJc;
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
        if (this.av) {
            if (this.mJe != null) {
                this.mJe.s();
            }
        } else if (this.mJG != null) {
            this.mJG.b(this.mJG.Ku(3), 20L);
        }
    }

    private void b(final String str, String str2) {
        com.kascend.chushou.c.c.dEj().a(new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.VideoPlayer.8
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
                        VideoPlayer.this.bP(r.mMessage, r.mRc);
                        return;
                    }
                    FullRoomInfo fullRoomInfo = (FullRoomInfo) r.mData;
                    VideoPlayer.this.dEJ().a(fullRoomInfo.mBangMap);
                    if (h.isEmpty(fullRoomInfo.mRoominfo.mRoomID)) {
                        fullRoomInfo.mRoominfo.mRoomID = VideoPlayer.this.P;
                    }
                    if (!h.isEmpty(fullRoomInfo.mGeneralTabGifts)) {
                        com.kascend.chushou.d.e.a(VideoPlayer.this.mJD, new ArrayList(fullRoomInfo.mGeneralTabGifts));
                    }
                    if (VideoPlayer.this.mJg != null) {
                        VideoPlayer.this.mJg.a(fullRoomInfo);
                    }
                    VideoPlayer.this.L = false;
                    if (VideoPlayer.this.B) {
                        if (VideoPlayer.this.C && !"3".equals(VideoPlayer.this.R) && fullRoomInfo != null && fullRoomInfo.mRoominfo != null && fullRoomInfo.mRoominfo.mStyle == 1 && !h.isEmpty(fullRoomInfo.mRoominfo.mGameId)) {
                            z = true;
                        }
                        if (!z) {
                            if (VideoPlayer.this.mJe != null) {
                                VideoPlayer.this.mJe.a(VideoPlayer.this.mJg);
                            }
                            if (!h.isEmpty(fullRoomInfo.mRoominfo.mGameId)) {
                                VideoPlayer.this.S();
                            } else {
                                if (VideoPlayer.this.mJg != null) {
                                    VideoPlayer.this.mJg.f = null;
                                }
                                VideoPlayer.this.S();
                            }
                        } else {
                            VideoPlayer.this.a(1, "1", true);
                            if (VideoPlayer.this.mJe != null) {
                                VideoPlayer.this.mJe.a(VideoPlayer.this.mJg);
                            }
                        }
                    } else {
                        if (h.isEmpty(fullRoomInfo.mRoominfo.mGameId)) {
                            if (VideoPlayer.this.mJg != null) {
                                VideoPlayer.this.mJg.f = null;
                            }
                            VideoPlayer.this.a(1, "1");
                        } else {
                            VideoPlayer.this.a(1, "1", true);
                        }
                        if (VideoPlayer.this.mJe != null) {
                            VideoPlayer.this.mJe.a(VideoPlayer.this.mJg);
                        }
                    }
                    if (VideoPlayer.this.mJg != null && !VideoPlayer.this.mJg.m()) {
                        if (VideoPlayer.this.mJp != null) {
                            VideoPlayer.this.mJp.d();
                            VideoPlayer.this.mJp = null;
                        }
                        VideoPlayer.this.mJp = new com.kascend.chushou.toolkit.d(900000L, VideoPlayer.this.mJr, VideoPlayer.this.mJG);
                        VideoPlayer.this.mJp.a();
                    }
                }
            }

            @Override // com.kascend.chushou.c.b
            public void a(int i, String str3) {
                if (!VideoPlayer.this.isFinishing()) {
                    VideoPlayer.this.bP(str3, i);
                }
            }
        }, str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bP(String str, int i) {
        if (this.mJg != null) {
            this.mJg.a((FullRoomInfo) null);
        }
        this.L = false;
        c(str, i);
        if (this.mJa != null) {
            this.mJa.stop();
        }
        if (this.mJb != null) {
            this.mJb.stop();
        }
        if (this.mJc != null) {
            this.mJc.stop();
        }
    }

    public void l() {
        tv.chushou.zues.utils.e.d(this.v, "retryGetPlayList");
        c();
        if (dEB()) {
            aY(this.P, false);
        } else {
            a(this.P, dEL(), false);
        }
    }

    public void m() {
        a(this.ag, false);
    }

    private void a(final String str, String str2, boolean z) {
        this.J = true;
        VideoPlayInfo L = j.dEt().L(str + str2, KeepJobService.JOB_CHECK_PERIODIC);
        if (L != null) {
            a((ArrayList) L.mPlayUrls);
            this.J = false;
        } else if (z) {
            ParserRet fL = com.kascend.chushou.player.c.a.dFh().fL(str, str2);
            if (fL.mRc != 0) {
                tv.chushou.zues.utils.e.e(this.v, "getPlayUrlSync fail, try to getPlaylist");
                a(str, str2, false);
                return;
            }
            a(fL, str);
        } else {
            com.kascend.chushou.player.c.a.dFh().a(str, str2, new a.InterfaceC0800a() { // from class: com.kascend.chushou.player.VideoPlayer.9
                @Override // com.kascend.chushou.player.c.a.InterfaceC0800a
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
    private void aY(final String str, boolean z) {
        boolean equals;
        this.J = true;
        VideoPlayInfo M = j.dEt().M(str, KeepJobService.JOB_CHECK_PERIODIC);
        if (M != null) {
            a((ArrayList) M.mPlayUrls);
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
                ParserRet aZ = com.kascend.chushou.player.c.a.dFh().aZ(str, equals);
                if (aZ.mRc != 0) {
                    tv.chushou.zues.utils.e.e(this.v, "getVideoPlayUrlSync fail, try to getVideoPlaylist");
                    aY(str, false);
                    return;
                }
                a(aZ, str);
                return;
            }
            com.kascend.chushou.player.c.a.dFh().a(str, new a.InterfaceC0800a() { // from class: com.kascend.chushou.player.VideoPlayer.10
                @Override // com.kascend.chushou.player.c.a.InterfaceC0800a
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
                if (this.mJg.f == null) {
                    this.mJg.f = new ArrayList<>();
                }
                this.mJg.f.clear();
                this.mJg.f.addAll(arrayList);
                if ("1".equals(this.R)) {
                    j.dEt().a(str + dEL(), arrayList);
                } else {
                    j.dEt().t(str, arrayList);
                }
                a(arrayList);
                return;
            }
            if (this.mJg != null) {
                this.mJg.f = null;
            }
            if (this.mJG != null) {
                Message Ku = this.mJG.Ku(5);
                Ku.arg1 = 2;
                Ku.arg2 = parserRet.mRc;
                this.mJG.R(Ku);
            }
        }
    }

    private void c(String str, int i) {
        s();
        if (this.mJk != null) {
            this.mJk.a();
        }
        if (h.isEmpty(str)) {
            str = getString(a.i.str_load_data_failed);
        }
        a(str, i);
    }

    public void n() {
        if (this.mJn != null && this.byt != null && this.mJo != null) {
            this.mJn.setVisibility(0);
            this.byt.setVisibility(8);
            this.mJo.setVisibility(8);
        }
    }

    public void o() {
        if (this.mJt != null && this.mJt.getVisibility() == 0) {
            this.mJt.yG(0);
            this.mJt.setVisibility(8);
        }
    }

    public void p() {
        if (this.mJu != null && this.mJu.getVisibility() == 0) {
            this.mJu.setVisibility(8);
        }
    }

    public void q() {
        this.av = true;
    }

    protected void r() {
        this.mJn.setVisibility(8);
        this.mJo.setVisibility(0);
        this.byt.setVisibility(0);
        if (this.mJj != null) {
            this.T.setVisibility(8);
            this.mJj.setVisibility(0);
            this.U.setText(getString(a.i.str_dialog_loading_content));
            this.U.setVisibility(8);
        }
    }

    protected void a(String str, int i) {
        this.mJn.setVisibility(8);
        this.mJo.setVisibility(0);
        this.byt.setVisibility(0);
        if (this.mJj != null) {
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
                            com.kascend.chushou.c.c.dEj().b(new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.VideoPlayer.11.1
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
                                        tv.chushou.zues.utils.g.F(VideoPlayer.this, a.i.subscribe_failed);
                                    }
                                }
                            }, VideoPlayer.this.P, (String) null, VideoPlayer.this.mJg.h);
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
            this.mJj.setVisibility(8);
            this.mJu.setVisibility(8);
        }
    }

    public void s() {
        if (this.mJG != null) {
            this.mJG.removeMessages(1);
        }
    }

    private void a(ArrayList<PlayUrl> arrayList) {
        boolean z;
        if (this.mJg.f == null) {
            this.mJg.f = new ArrayList<>();
        }
        this.mJg.f.clear();
        this.mJg.f.addAll(arrayList);
        if (com.kascend.chushou.d.e.b() && !"4".equals(this.aq)) {
            int c = com.kascend.chushou.d.e.c();
            if (c == -1) {
                b(arrayList);
                return;
            } else if (this.mJH) {
                this.mJH = false;
                if (c == 0) {
                    this.mJg.d = false;
                    f(arrayList, true);
                    return;
                }
                if (this.mJg != null && this.mJg.f != null) {
                    Iterator<PlayUrl> it = this.mJg.f.iterator();
                    while (it.hasNext()) {
                        if ("2".equals(it.next().mType)) {
                            z = true;
                            break;
                        }
                    }
                }
                z = false;
                this.mJg.d = z;
                f(arrayList, true);
                return;
            } else {
                if (this.mJg.e) {
                    this.mJg.d = !this.mJg.d;
                    this.mJg.e = false;
                    this.mJI = true;
                } else if ("4".equals(this.aq)) {
                    this.mJg.d = true;
                }
                f(arrayList, true);
                return;
            }
        }
        if (this.mJg.e) {
            this.mJg.d = !this.mJg.d;
            this.mJg.e = false;
            this.mJI = true;
        } else if ("4".equals(this.aq)) {
            this.mJg.d = true;
        }
        f(arrayList, true);
    }

    private void b(ArrayList<PlayUrl> arrayList) {
        if ("1".equals(this.R)) {
            if ("2".equals(this.mJB)) {
                d(false, arrayList);
            } else if (this.mJe != null) {
                this.mJe.f(arrayList, false);
            }
        } else if (this.mJe != null) {
            this.mJe.f(arrayList, false);
        }
    }

    public void c(boolean z) {
        this.mJg.d = false;
        com.kascend.chushou.d.e.a(0);
        ArrayList<PlayUrl> arrayList = this.mJg.f;
        if (!h.isEmpty(arrayList)) {
            if (z) {
                f(arrayList, false);
                if (this.mJG != null) {
                    this.mJG.Ks(2);
                    return;
                }
                return;
            }
            f(arrayList, true);
        }
    }

    public void d(boolean z) {
        this.mJg.d = true;
        com.kascend.chushou.d.e.a(1);
        ArrayList<PlayUrl> arrayList = this.mJg.f;
        if (!h.isEmpty(arrayList)) {
            if (z) {
                f(arrayList, false);
                if (this.mJG != null) {
                    this.mJG.Ks(2);
                    return;
                }
                return;
            }
            f(arrayList, true);
        }
    }

    @Subscribe
    public void onNotifyEvent(com.kascend.chushou.b.a.a.j jVar) {
        if (!isFinishing() && jVar.a == 1 && !"5".equals(this.R) && !dEv()) {
            tv.chushou.zues.utils.e.d(this.v, "onNetworkChangeEvent 3G=" + com.kascend.chushou.b.dEg().b + "  wifi=" + com.kascend.chushou.b.dEg().a);
            if (com.kascend.chushou.d.e.b() && !"4".equals(this.aq)) {
                if (com.kascend.chushou.d.e.c() == -1) {
                    if (this.mJe != null) {
                        this.mJe.e(false);
                    }
                    if ("1".equals(this.R)) {
                        if ("2".equals(this.mJB)) {
                            d(true, null);
                            return;
                        } else if (this.mJe != null) {
                            this.mJe.f(this.mJg.f, true);
                            return;
                        } else {
                            return;
                        }
                    } else if (this.mJe != null) {
                        this.mJe.f(this.mJg.f, true);
                        return;
                    } else {
                        return;
                    }
                }
                RxExecutor.postDelayed(this.mJD, EventThread.MAIN_THREAD, 10L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.VideoPlayer.12
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!VideoPlayer.this.isFinishing() && com.kascend.chushou.b.dEg().b && !com.kascend.chushou.b.dEg().a) {
                            tv.chushou.zues.utils.g.c(VideoPlayer.this.w, VideoPlayer.this.getString(a.i.str_monet_notify));
                        }
                    }
                });
            } else if (com.kascend.chushou.b.dEg().a || com.kascend.chushou.b.dEg().b) {
                t();
                if (this.mJG != null) {
                    this.mJG.Ks(2);
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
            if (this.mJg.d) {
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
            String d = com.kascend.chushou.d.h.dEn().d();
            String str3 = h.isEmpty(d) ? "2" : d;
            if (this.mJg.d) {
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
                if (this.mJg != null) {
                    this.mJg.a(playUrl2);
                    if (this.mJG != null) {
                        Message Ku = this.mJG.Ku(5);
                        Ku.arg1 = 1;
                        this.mJG.R(Ku);
                    }
                }
                String b = com.kascend.chushou.player.c.a.b(playUrl2);
                if (!h.isEmpty(b)) {
                    this.mIZ = Uri.parse(b);
                    if (this.mJI) {
                        this.mJI = false;
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (z && this.mJa != null) {
                        a(false, z2);
                    }
                }
            }
        }
    }

    public void d(final boolean z, ArrayList<PlayUrl> arrayList) {
        if (this.mJq == null || this.mJq.a <= 0) {
            this.mJq = com.kascend.chushou.view.b.a.a.dGs();
            this.mJq.a(new a.InterfaceC0819a() { // from class: com.kascend.chushou.player.VideoPlayer.13
                @Override // com.kascend.chushou.view.b.a.a.InterfaceC0819a
                public void a(int i) {
                    if (i == a.f.tv_play_video) {
                        VideoPlayer.this.mJq.dismissAllowingStateLoss();
                        VideoPlayer.this.c(z);
                    } else if (i == a.f.tv_play_audio) {
                        VideoPlayer.this.mJq.dismissAllowingStateLoss();
                        VideoPlayer.this.d(z);
                    } else if (i == a.f.iv_close) {
                        VideoPlayer.this.finish();
                    } else {
                        if (i == a.f.tv_union_proxy) {
                        }
                    }
                }
            });
            this.mJq.show(getSupportFragmentManager(), "showRoom");
        }
    }

    public void t() {
        if (this.mJq != null) {
            this.mJq.dismissAllowingStateLoss();
        }
        if (this.mJe != null) {
            this.mJe.v();
        }
    }

    public void u() {
        com.kascend.chushou.c.c.dEj().c(this.P, new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.VideoPlayer.16
            @Override // com.kascend.chushou.c.b
            public void a() {
            }

            @Override // com.kascend.chushou.c.b
            public void a(String str, JSONObject jSONObject) {
                if (!VideoPlayer.this.isFinishing()) {
                    ParserRet dK = com.kascend.chushou.c.e.dK(jSONObject);
                    if (dK.mRc == 0 && dK.mData != null) {
                        CycleLiveRoomInfo cycleLiveRoomInfo = (CycleLiveRoomInfo) dK.mData;
                        if (VideoPlayer.this.mJg != null && cycleLiveRoomInfo != null && !h.isEmpty(cycleLiveRoomInfo.roomId)) {
                            FullRoomInfo dEZ = VideoPlayer.this.mJg.dEZ();
                            if (dEZ.cycleLiveRoomInfo == null) {
                                dEZ.cycleLiveRoomInfo = cycleLiveRoomInfo;
                                VideoPlayer.this.d();
                            } else if (dEZ.cycleLiveRoomInfo != null && !cycleLiveRoomInfo.roomId.equals(dEZ.cycleLiveRoomInfo.roomId)) {
                                dEZ.cycleLiveRoomInfo.copyCycleLiveRoomInfo(cycleLiveRoomInfo);
                                VideoPlayer.this.d();
                            } else {
                                dEZ.cycleLiveRoomInfo.copyCycleLiveRoomInfo(cycleLiveRoomInfo);
                            }
                            VideoPlayer.this.Nl();
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
    public void Nl() {
        if (this.mJe != null) {
            this.mJe.N();
        }
    }

    public void v() {
        com.kascend.chushou.c.c.dEj().a(this.P, new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.VideoPlayer.17
            @Override // com.kascend.chushou.c.b
            public void a() {
            }

            @Override // com.kascend.chushou.c.b
            public void a(String str, JSONObject jSONObject) {
                if (!VideoPlayer.this.isFinishing()) {
                    ParserRet dL = com.kascend.chushou.c.e.dL(jSONObject);
                    if (dL.mRc == 0 && dL.mData != null) {
                        PkNotifyInfo pkNotifyInfo = (PkNotifyInfo) dL.mData;
                        VideoPlayer.this.mJz.b = VideoPlayer.this.P;
                        if (pkNotifyInfo != null) {
                            VideoPlayer.this.mJz.mNY = pkNotifyInfo;
                            if (VideoPlayer.this.mJe != null) {
                                VideoPlayer.this.mJe.a(pkNotifyInfo, VideoPlayer.this.P);
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
        if (this.mJi != null) {
            this.mJi.release();
            this.mJi = null;
        }
        com.kascend.chushou.c.c.dEj().a(this.P, new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.VideoPlayer.18
            @Override // com.kascend.chushou.c.b
            public void a() {
            }

            @Override // com.kascend.chushou.c.b
            public void a(String str, JSONObject jSONObject) {
                if (!VideoPlayer.this.isFinishing()) {
                    ParserRet dM = com.kascend.chushou.c.e.dM(jSONObject);
                    if (dM.mRc == 0 && dM.mData != null) {
                        RoomExpandInfo roomExpandInfo = (RoomExpandInfo) dM.mData;
                        if (VideoPlayer.this.mJg != null) {
                            VideoPlayer.this.mJg.mKJ = roomExpandInfo.mTopWebAdItem;
                            if (VideoPlayer.this.mJg.s == null) {
                                VideoPlayer.this.mJg.s = new ArrayList();
                            }
                            VideoPlayer.this.mJg.s.clear();
                            VideoPlayer.this.mJg.s.addAll(roomExpandInfo.mGiftTopRightIcons);
                            tv.chushou.zues.a.a.post(new i(50, VideoPlayer.this.mJg.mKJ));
                        }
                        if (VideoPlayer.this.mJg != null) {
                            VideoPlayer.this.mJg.fj(roomExpandInfo.mExpandNavList);
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
                            VideoPlayer.this.mJv.a(list);
                        }
                        List<com.kascend.chushou.player.ui.h5.c.c> list2 = roomExpandInfo.mLuckList;
                        if (!h.isEmpty(list2)) {
                            VideoPlayer.this.mJw.a(list2);
                        }
                        com.kascend.chushou.player.ui.h5.c.c cVar = roomExpandInfo.mVoteItem;
                        if (cVar != null) {
                            VideoPlayer.this.mJx.a(cVar);
                        }
                        List<com.kascend.chushou.player.ui.h5.c.b> list3 = roomExpandInfo.mInteractH5Item;
                        if (!h.isEmpty(list3)) {
                            VideoPlayer.this.mJA.a(list3);
                        }
                        List<com.kascend.chushou.player.ui.h5.c.b> list4 = roomExpandInfo.mInteractNavItem;
                        if (!h.isEmpty(list4)) {
                            VideoPlayer.this.mJA.a(list4);
                        }
                        VideoPlayer.this.mJi = (PrivilegeInfo) dM.mData1;
                        if (VideoPlayer.this.mJi != null) {
                            tv.chushou.zues.a.a.post(new l());
                        }
                        if (VideoPlayer.this.mJg != null) {
                            VideoPlayer.this.mJg.mKP = roomExpandInfo.mIconConfig;
                            VideoPlayer.this.dEJ().a(roomExpandInfo.mIconConfig.bangConfig);
                        }
                        List<SkinConfig> list5 = roomExpandInfo.skinConfig;
                        if (list5 != null && VideoPlayer.this.mJg != null) {
                            VideoPlayer.this.mJg.mKS.clear();
                            int i = 0;
                            while (true) {
                                int i2 = i;
                                if (i2 >= list5.size()) {
                                    break;
                                }
                                SkinConfig skinConfig = list5.get(i2);
                                VideoPlayer.this.mJg.mKS.put(skinConfig.position, skinConfig.resource);
                                i = i2 + 1;
                            }
                            VideoPlayer.this.C();
                        }
                        VideoPlayer.this.a(roomExpandInfo.mIconConfig, VideoPlayer.this.mJg != null ? VideoPlayer.this.mJg.mKS : null);
                        if (roomExpandInfo.mColorMap != null && roomExpandInfo.mColorMap.size() > 0 && com.kascend.chushou.b.dEg().c != null && com.kascend.chushou.b.dEg().c.size() <= 0) {
                            com.kascend.chushou.b.dEg().c.putAll(roomExpandInfo.mColorMap);
                            tv.chushou.zues.a.a.post(new i(52, null));
                        }
                        AutoBang autoBang = roomExpandInfo.mAutoBang;
                        if (autoBang != null && autoBang.currentTime != 0 && autoBang.bangTime != 0) {
                            VideoPlayer.this.dEJ().a(autoBang);
                        }
                        if (!h.isEmpty(roomExpandInfo.mRelatedRoomList) && VideoPlayer.this.mJg != null) {
                            VideoPlayer.this.mJg.t = roomExpandInfo.mRelatedRoomList;
                            if (VideoPlayer.this.mJe != null && VideoPlayer.this.H) {
                                VideoPlayer.this.mJe.w();
                            }
                        }
                        if (roomExpandInfo.mRoomNewUserInfo != null && roomExpandInfo.mRoomNewUserInfo.mBarrierNoviceGuide && !com.kascend.chushou.d.h.dEn().k() && VideoPlayer.this.mJe != null) {
                            VideoPlayer.this.mJe.J();
                        }
                        if (roomExpandInfo.mRoomNewUserInfo != null && roomExpandInfo.mRoomNewUserInfo.mRewardNoviceGuide && !com.kascend.chushou.d.h.dEn().l() && VideoPlayer.this.mJe != null) {
                            VideoPlayer.this.mJe.K();
                        }
                        if (!h.isEmpty(roomExpandInfo.mShopWindowInfos)) {
                            if (VideoPlayer.this.mJg != null) {
                                if (VideoPlayer.this.mJg.mKQ == null) {
                                    VideoPlayer.this.mJg.mKQ = new ArrayList();
                                }
                                VideoPlayer.this.mJg.mKQ.addAll(roomExpandInfo.mShopWindowInfos);
                            }
                            if (VideoPlayer.this.mJe != null) {
                                VideoPlayer.this.mJe.L();
                            }
                        }
                        VideoPlayer.this.mJz.b = VideoPlayer.this.P;
                        if (roomExpandInfo.mPkNotifyInfo != null) {
                            VideoPlayer.this.mJz.mNY = roomExpandInfo.mPkNotifyInfo;
                            if (VideoPlayer.this.mJe != null) {
                                VideoPlayer.this.mJe.a(roomExpandInfo.mPkNotifyInfo, VideoPlayer.this.P);
                            }
                        } else {
                            VideoPlayer.this.mJz.mNY = null;
                        }
                        if (roomExpandInfo.mTrumpetPocket != null && VideoPlayer.this.mJg != null) {
                            VideoPlayer.this.mJg.mKR = roomExpandInfo.mTrumpetPocket;
                            if (VideoPlayer.this.mJe != null) {
                                VideoPlayer.this.mJe.M();
                            }
                        }
                        if (!h.isEmpty(roomExpandInfo.hotwordContentList)) {
                            if (VideoPlayer.this.mJg != null) {
                                if (VideoPlayer.this.mJg.w == null) {
                                    VideoPlayer.this.mJg.w = new ArrayList();
                                }
                                VideoPlayer.this.mJg.w.clear();
                                VideoPlayer.this.mJg.w.addAll(roomExpandInfo.hotwordContentList);
                            }
                            if (VideoPlayer.this.mJe != null) {
                                VideoPlayer.this.mJe.b(roomExpandInfo.hotwordContentList);
                            }
                        }
                        VideoPlayer.this.U();
                        return;
                    }
                    a(dM.mRc, dM.mMessage);
                }
            }

            @Override // com.kascend.chushou.c.b
            public void a(int i, String str) {
                tv.chushou.zues.utils.e.e(VideoPlayer.this.v, "get room gift popup list failed, rc =" + i + ", errorMsg=" + str);
            }
        }, this.ag, this.mJB);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U() {
        if (!h.isEmpty(com.kascend.chushou.a.a.dEh().mIx)) {
            StringBuilder sb = new StringBuilder();
            if (com.kascend.chushou.a.a.dEh().mIx.contains(com.kascend.chushou.a.a.f)) {
                if (sb.length() > 0) {
                    sb.append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                sb.append(com.kascend.chushou.a.a.f);
            }
            if (com.kascend.chushou.a.a.dEh().mIx.contains(com.kascend.chushou.a.a.g)) {
                if (sb.length() > 0) {
                    sb.append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                sb.append(com.kascend.chushou.a.a.g);
            }
            if (com.kascend.chushou.a.a.dEh().mIx.contains(com.kascend.chushou.a.a.i)) {
                if (sb.length() > 0) {
                    sb.append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                sb.append(com.kascend.chushou.a.a.i);
            }
            if (com.kascend.chushou.a.a.dEh().mIx.contains(com.kascend.chushou.a.a.h)) {
                if (sb.length() > 0) {
                    sb.append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                sb.append(com.kascend.chushou.a.a.h);
            }
            if (com.kascend.chushou.a.a.dEh().mIx.contains(com.kascend.chushou.a.a.j)) {
                if (sb.length() > 0) {
                    sb.append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                sb.append(com.kascend.chushou.a.a.j);
            }
            if (com.kascend.chushou.a.a.dEh().mIx.contains(com.kascend.chushou.a.a.l)) {
                if (sb.length() > 0) {
                    sb.append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                sb.append(com.kascend.chushou.a.a.l);
            }
            if (com.kascend.chushou.a.a.dEh().mIx.contains(com.kascend.chushou.a.a.m)) {
                if (sb.length() > 0) {
                    sb.append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                sb.append(com.kascend.chushou.a.a.m);
            }
            if (sb.length() != 0) {
                com.kascend.chushou.a.a.dEh().a(sb.toString(), this.P, new a.c() { // from class: com.kascend.chushou.player.VideoPlayer.19
                    @Override // com.kascend.chushou.a.a.c
                    public void a(List<ListItem> list) {
                        if (VideoPlayer.this.mJg != null && list != null) {
                            int i = 0;
                            while (true) {
                                int i2 = i;
                                if (i2 >= list.size()) {
                                    break;
                                }
                                if (list.get(i2).mAdExtraInfo != null) {
                                    if (com.kascend.chushou.a.a.f.equals(list.get(i2).mAdExtraInfo.mCode)) {
                                        VideoPlayer.this.mJg.mKI = list.get(i2);
                                    } else if (com.kascend.chushou.a.a.g.equals(list.get(i2).mAdExtraInfo.mCode)) {
                                        VideoPlayer.this.mJg.mKH = list.get(i2);
                                    } else if (com.kascend.chushou.a.a.i.equals(list.get(i2).mAdExtraInfo.mCode)) {
                                        VideoPlayer.this.mJg.mKK = list.get(i2);
                                    } else if (com.kascend.chushou.a.a.h.equals(list.get(i2).mAdExtraInfo.mCode)) {
                                        VideoPlayer.this.mJg.mKL = list.get(i2);
                                    } else if (com.kascend.chushou.a.a.j.equals(list.get(i2).mAdExtraInfo.mCode)) {
                                        VideoPlayer.this.mJg.mKO = list.get(i2);
                                    } else if (com.kascend.chushou.a.a.l.equals(list.get(i2).mAdExtraInfo.mCode)) {
                                        VideoPlayer.this.mJg.mKM = list.get(i2);
                                    } else if (com.kascend.chushou.a.a.m.equals(list.get(i2).mAdExtraInfo.mCode)) {
                                        VideoPlayer.this.mJg.mKN = list.get(i2);
                                    }
                                }
                                i = i2 + 1;
                            }
                            if (VideoPlayer.this.mJe != null) {
                                VideoPlayer.this.mJe.H();
                            }
                        }
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str, String str2) {
        if (dEB()) {
            com.kascend.chushou.toolkit.a.a.l("type", "1", "value", str, "desc", str2, "videoId", this.P);
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
                this.mJm.setSystemUiVisibility(i);
                return;
            }
            this.mJm.setSystemUiVisibility(1792);
        }
    }

    public void f(boolean z) {
        Window window;
        View decorView;
        if (com.kascend.chushou.b.dEg().d != 1 && (window = getWindow()) != null && (decorView = window.getDecorView()) != null) {
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
        if (this.mJe != null) {
            this.mJe.a(i, i2, intent);
        }
    }

    public Uri dEC() {
        return this.mIZ;
    }

    @Override // com.kascend.chushou.view.base.BaseActivity
    protected int y() {
        return 0;
    }

    public void wA(boolean z) {
        if (this.mJm != null) {
            this.mJm.nRO = z;
        }
    }

    public void dED() {
        if (this.mJm != null) {
            this.mJm.dED();
        }
    }

    public boolean dEE() {
        return this.ae;
    }

    public void g(boolean z) {
        this.ae = z;
    }

    public void h(boolean z) {
        if (this.mJm != null) {
            this.mJm.setIsTranslucentStatus(z);
        }
    }

    public void z() {
        if (this.mJm != null) {
            this.mJm.dSy();
        }
    }

    @Override // com.kascend.chushou.widget.gifts.RoomSendGiftView.a
    public void A() {
        if (this.mJk != null) {
            this.mJk.b();
        }
        if (this.mJg != null) {
            this.mJg.z = true;
        }
    }

    @Override // com.kascend.chushou.widget.gifts.RoomSendGiftView.a
    public void B() {
        if (this.mJk != null) {
            this.mJk.b();
        }
    }

    public void a(List<ListItem> list) {
        if (this.mJe != null) {
            this.mJe.a(list);
        }
    }

    public void a(IconConfig iconConfig, Map<String, SkinConfig.SkinRes> map) {
        if (this.mJe != null) {
            this.mJe.a(iconConfig, map);
        }
    }

    public void C() {
        if (this.mJe != null) {
            this.mJe.I();
        }
    }

    @Override // com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC0811a
    public void a(int i) {
        if (this.mJe != null) {
            this.mJe.a(i);
        }
    }

    @Override // com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC0811a
    public void D() {
        if (!isFinishing() && this.mJe != null) {
            this.mJe.D();
        }
    }

    @Override // com.kascend.chushou.player.ui.h5.b.b.a
    public void a(long j) {
        if (!isFinishing() && this.mJe != null) {
            this.mJe.a(j);
        }
    }

    @Override // com.kascend.chushou.player.ui.h5.b.b.a
    public void a(com.kascend.chushou.player.ui.h5.c.a aVar) {
        if (aVar != null && this.mJe != null) {
            this.mJe.a(aVar);
        }
    }

    @Override // com.kascend.chushou.player.ui.h5.b.b.a
    public void b(int i) {
        if (this.mJe != null) {
            this.mJe.b(i);
        }
    }

    @Override // com.kascend.chushou.player.ui.h5.d.a.InterfaceC0810a
    public void b(long j) {
        if (!isFinishing() && this.mJe != null) {
            this.mJe.b(j);
        }
    }

    @Override // com.kascend.chushou.player.ui.h5.a.a.InterfaceC0808a
    public void c(int i) {
        if (!isFinishing() && this.mJe != null) {
            this.mJe.c(i);
        }
    }

    @Override // com.kascend.chushou.player.ui.h5.d.a.InterfaceC0810a
    public void b(com.kascend.chushou.player.ui.h5.c.a aVar) {
        if (aVar != null && this.mJe != null) {
            this.mJe.b(aVar);
        }
    }

    @Override // com.kascend.chushou.player.ui.a.a.InterfaceC0805a
    public void a(IconConfig.Config config) {
        if (this.mJe != null) {
            this.mJe.a(config);
        }
    }

    @Override // com.kascend.chushou.player.ui.a.a.InterfaceC0805a
    public void a(BangInfo bangInfo, String str) {
        if (this.mJe != null) {
            this.mJe.a(bangInfo, str);
        }
    }

    @Override // com.kascend.chushou.player.ui.a.a.InterfaceC0805a
    public void a(long j, BangInfo bangInfo, String str) {
        if (this.mJe != null) {
            this.mJe.a(j, bangInfo, str);
        }
    }

    public com.kascend.chushou.player.ui.h5.redpacket.a dEF() {
        return this.mJv;
    }

    public com.kascend.chushou.player.ui.h5.b.b dEG() {
        return this.mJw;
    }

    public com.kascend.chushou.player.ui.h5.d.a dEH() {
        return this.mJx;
    }

    public com.kascend.chushou.player.ui.h5.a.a dEI() {
        return this.mJA;
    }

    public com.kascend.chushou.player.ui.a.a dEJ() {
        return this.mJy;
    }

    public com.kascend.chushou.player.e.a dEK() {
        return this.mJz;
    }

    @Override // com.kascend.chushou.view.base.BaseActivity, android.app.Activity
    public void finish() {
        super.finish();
        if ("3".equals(this.R)) {
            overridePendingTransition(17432576, a.C0795a.commonres_activity_exit_bottom);
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
        RxExecutor.postDelayed(this.mJD, EventThread.MAIN_THREAD, aVar.d, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.VideoPlayer.2
            @Override // java.lang.Runnable
            public void run() {
                if (VideoPlayer.this.mJe != null) {
                    VideoPlayer.this.mJe.c(aVar);
                }
            }
        });
    }

    private void e(final com.kascend.chushou.player.ui.h5.c.a aVar) {
        if (!com.kascend.chushou.d.h.dEn().dEq().contains(aVar.b)) {
            if (aVar.d < 0) {
                aVar.d = 0;
            }
            RxExecutor.postDelayed(this.mJD, EventThread.MAIN_THREAD, aVar.d, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.VideoPlayer.3
                @Override // java.lang.Runnable
                public void run() {
                    if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.mJe != null) {
                        VideoPlayer.this.mJe.c(aVar);
                    }
                }
            });
        }
    }

    private String dEL() {
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
                if (VideoPlayer.this.mJl != null && !VideoPlayer.this.isFinishing()) {
                    VideoPlayer.n = VideoPlayer.this.mJl.getStreamVolume(3);
                }
                if (!VideoPlayer.this.isFinishing() && (VideoPlayer.this.mJe instanceof f)) {
                    ((f) VideoPlayer.this.mJe).ab();
                }
            }
        }
    }

    public String a(String str) {
        HashMap hashMap = new HashMap(tv.chushou.zues.utils.d.Su(str));
        if ("1".equals(this.R)) {
            hashMap.put("roomId", this.P);
        } else if ("3".equals(this.R)) {
            hashMap.put("videoId", this.P);
        }
        return tv.chushou.zues.utils.d.toJson(hashMap);
    }

    public boolean dEM() {
        if (this.mJe instanceof com.kascend.chushou.player.d.a) {
            return ((com.kascend.chushou.player.d.a) this.mJe).dFD();
        }
        if (this.mJe instanceof com.kascend.chushou.player.e.e) {
            return true;
        }
        return false;
    }
}

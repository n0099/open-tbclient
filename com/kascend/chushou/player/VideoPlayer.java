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
public class VideoPlayer extends BaseActivity implements a.InterfaceC0824a, a.InterfaceC0827a, b.a, a.InterfaceC0829a, a.InterfaceC0830a, RoomSendGiftView.a {
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
    public com.kascend.chushou.player.feedback.a nfA;
    private a nfC;
    private CSTVWifiReceiver nfD;
    private c nfb;
    b nfe;
    public PrivilegeInfo nfg;
    com.kascend.chushou.widget.a.b nfi;
    private KPSwitchRootRelativeLayout nfk;
    private FrameLayout nfl;
    private LinearLayout nfm;
    private com.kascend.chushou.toolkit.d nfn;
    com.kascend.chushou.view.b.a.a nfo;
    private FrescoThumbnailView nfr;
    private FrameLayout nfs;
    private boolean B = true;
    private boolean C = false;
    private Uri neX = null;
    private tv.chushou.common.player.a neY = null;
    public tv.chushou.common.player.a neZ = null;
    public tv.chushou.common.player.a nfa = null;
    public boolean d = false;
    public boolean e = false;
    private e nfc = null;
    private boolean H = false;
    private com.kascend.chushou.view.user.b nfd = null;
    private boolean J = false;
    private boolean K = false;
    private boolean L = false;
    private boolean M = false;
    private long nff = 0;
    private int O = 0;
    public boolean g = false;
    private ImageView T = null;
    private TextView U = null;
    private AnimationImageView nfh = null;
    private View bDj = null;
    public boolean j = false;
    public float k = 0.0f;
    public float l = 0.0f;
    public boolean m = false;
    public AudioManager nfj = null;
    private d.a nfp = new d.a() { // from class: com.kascend.chushou.player.VideoPlayer.1
        @Override // com.kascend.chushou.toolkit.d.a
        public void a() {
            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.nfE != null) {
                VideoPlayer.this.nfE.Lz(4);
            }
        }
    };
    private boolean ae = false;
    public boolean q = true;
    public long r = -1;
    public long s = -1;
    private PowerManager.WakeLock nfq = null;
    public String t = null;
    private final com.kascend.chushou.player.ui.h5.redpacket.a nft = new com.kascend.chushou.player.ui.h5.redpacket.a(this);
    private final com.kascend.chushou.player.ui.h5.b.b nfu = new com.kascend.chushou.player.ui.h5.b.b(this);
    private final com.kascend.chushou.player.ui.h5.d.a nfv = new com.kascend.chushou.player.ui.h5.d.a(this);
    private final com.kascend.chushou.player.ui.a.a nfw = new com.kascend.chushou.player.ui.a.a(this);
    private final com.kascend.chushou.player.e.a nfx = new com.kascend.chushou.player.e.a();
    private final com.kascend.chushou.player.ui.h5.a.a nfy = new com.kascend.chushou.player.ui.h5.a.a(this);
    private String nfz = "1";
    private String aq = "2";
    private io.reactivex.disposables.a nfB = new io.reactivex.disposables.a();
    private tv.chushou.zues.c nfE = new tv.chushou.zues.c(new Handler.Callback() { // from class: com.kascend.chushou.player.VideoPlayer.6
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            try {
                if (!VideoPlayer.this.isFinishing()) {
                    switch (message.what) {
                        case 1:
                            VideoPlayer.this.nfE.removeMessages(1);
                            com.kascend.chushou.c.c.dIL().a(VideoPlayer.this.P, VideoPlayer.this.nfe != null ? VideoPlayer.this.nfe.h : null, System.currentTimeMillis());
                            VideoPlayer.this.nfE.B(1, VideoPlayer.A);
                            break;
                        case 2:
                            VideoPlayer.this.a(true, (Uri) null, false);
                            break;
                        case 3:
                            VideoPlayer.this.S();
                            break;
                        case 4:
                            if (VideoPlayer.this.nfc != null) {
                                VideoPlayer.this.nfc.a(true);
                            }
                            if (VideoPlayer.this.nfn != null) {
                                VideoPlayer.this.nfn.d();
                                VideoPlayer.this.nfn = null;
                                break;
                            }
                            break;
                        case 5:
                            int i = message.arg1;
                            if (i == 1) {
                                if (VideoPlayer.this.nfc != null) {
                                    VideoPlayer.this.nfc.p();
                                    break;
                                }
                            } else if (i == 2 && VideoPlayer.this.nfc != null) {
                                VideoPlayer.this.nfc.e(message.arg2);
                                break;
                            }
                            break;
                        case 6:
                            if (!com.kascend.chushou.b.dII().a && !com.kascend.chushou.b.dII().b && VideoPlayer.this.nfc != null) {
                                VideoPlayer.this.nfc.g(true);
                                break;
                            } else {
                                VideoPlayer.this.c();
                                break;
                            }
                            break;
                        case 7:
                            tv.chushou.zues.utils.e.d(VideoPlayer.this.v, "MSG_BUFFER_DEALY: ");
                            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.nfc != null && VideoPlayer.this.M && !VideoPlayer.this.e) {
                                VideoPlayer.this.nfc.h(true);
                                VideoPlayer.this.nff = 0L;
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
    private boolean nfF = false;
    private boolean aw = true;
    private boolean nfG = false;
    private tv.chushou.common.player.b nfH = new tv.chushou.common.player.b() { // from class: com.kascend.chushou.player.VideoPlayer.14
        @Override // tv.chushou.common.player.b
        public void dJq() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerACallback onSetVideoViewLayout");
            if (!VideoPlayer.this.isFinishing()) {
                if ((VideoPlayer.this.nfc == null || !VideoPlayer.this.nfc.H) && VideoPlayer.this.nfc != null && !VideoPlayer.this.d) {
                    VideoPlayer.this.nfc.y();
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void Kc(int i) {
            if (!VideoPlayer.this.isFinishing()) {
                if ((VideoPlayer.this.nfc == null || !VideoPlayer.this.nfc.H) && VideoPlayer.this.nfc != null && !VideoPlayer.this.d) {
                    VideoPlayer.this.nfc.g(i);
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void dJr() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerACallback onCompletePlayback");
            if (!VideoPlayer.this.isFinishing()) {
                if (!h.isEmpty(VideoPlayer.this.P)) {
                    j.dIV().a(VideoPlayer.this.P, 0);
                }
                VideoPlayer.this.K = false;
                if (VideoPlayer.this.nfE != null) {
                    VideoPlayer.this.nfE.removeMessages(1);
                }
                if ((VideoPlayer.this.nfc == null || !VideoPlayer.this.nfc.H) && VideoPlayer.this.nfc != null && !VideoPlayer.this.d) {
                    VideoPlayer.this.nfE.removeMessages(7);
                    VideoPlayer.this.M = false;
                    VideoPlayer.this.nfc.z();
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void dJs() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerACallback onVideoRenderingStart");
            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.nfc != null) {
                VideoPlayer.this.nfc.G();
            }
        }

        @Override // tv.chushou.common.player.b
        public void dJt() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerACallback onPreparedPlayback");
            if (!VideoPlayer.this.isFinishing()) {
                if (VideoPlayer.this.nfc == null || !VideoPlayer.this.nfc.H) {
                    VideoPlayer.this.nfE.removeMessages(6);
                    VideoPlayer.this.nff = 0L;
                    VideoPlayer.this.O = 0;
                    if (VideoPlayer.this.neY != null && VideoPlayer.this.nfc != null) {
                        VideoPlayer.this.neY.setVolume(VideoPlayer.this.nfc.J, VideoPlayer.this.nfc.J);
                    }
                    if (VideoPlayer.this.nfe != null) {
                        VideoPlayer.this.K = false;
                        FullRoomInfo dJB = VideoPlayer.this.dJd() ? null : VideoPlayer.this.nfe.dJB();
                        if (VideoPlayer.this.L || dJB != null) {
                            if (VideoPlayer.this.nfe.e) {
                                VideoPlayer.this.nfe.e = false;
                                VideoPlayer.this.nfe.d = !VideoPlayer.this.nfe.d;
                            }
                            if (VideoPlayer.this.nfc != null) {
                                VideoPlayer.this.c("1", (String) null);
                                if (!VideoPlayer.this.d) {
                                    VideoPlayer.this.nfc.i(true);
                                } else if (VideoPlayer.this.e) {
                                    VideoPlayer.this.e = false;
                                    VideoPlayer.this.nfc.B();
                                }
                            }
                        }
                    }
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void Kd(int i) {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerACallback onErrorAppeared");
            if (!VideoPlayer.this.isFinishing()) {
                VideoPlayer.this.c();
                VideoPlayer.this.K = false;
                if (VideoPlayer.this.nfE != null) {
                    VideoPlayer.this.nfE.removeMessages(7);
                }
                if (VideoPlayer.this.nfE != null) {
                    VideoPlayer.this.nfE.removeMessages(1);
                }
                if ((VideoPlayer.this.nfc == null || !VideoPlayer.this.nfc.H) && !VideoPlayer.this.dIX()) {
                    if (!"10004".equals(VideoPlayer.this.t)) {
                        if (VideoPlayer.this.nfc != null) {
                            if (VideoPlayer.this.d) {
                                VideoPlayer.this.neZ.stop();
                                VideoPlayer.this.neZ.release();
                                VideoPlayer.this.e = false;
                                VideoPlayer.this.nfc.C();
                            }
                            if (!com.kascend.chushou.b.dII().a && !com.kascend.chushou.b.dII().b) {
                                VideoPlayer.this.nfc.g(true);
                            } else if (VideoPlayer.this.d) {
                                VideoPlayer.this.nfc.a(i, true);
                            } else {
                                VideoPlayer.this.nfc.a(i, false);
                            }
                            VideoPlayer.this.c("2", (String) null);
                            return;
                        }
                        return;
                    }
                    dJr();
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void dJu() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerACallback onBufferingStart");
            if (!VideoPlayer.this.isFinishing()) {
                if ((VideoPlayer.this.nfc == null || !VideoPlayer.this.nfc.H) && VideoPlayer.this.nfc != null && !VideoPlayer.this.d) {
                    VideoPlayer.this.nfc.E();
                    VideoPlayer.this.M = true;
                    long currentTimeMillis = System.currentTimeMillis();
                    VideoPlayer.this.nfE.removeMessages(7);
                    if (!VideoPlayer.this.g) {
                        VideoPlayer.y(VideoPlayer.this);
                    }
                    tv.chushou.zues.utils.e.d(VideoPlayer.this.v, "currentTime: -- >" + currentTimeMillis + "  bufferTime-->" + VideoPlayer.this.nff + "  bufferCount-->" + VideoPlayer.this.O);
                    if (currentTimeMillis - VideoPlayer.this.nff >= 20000 || VideoPlayer.this.O < 2 || VideoPlayer.this.nfc.H) {
                        if (VideoPlayer.this.O == 1) {
                            VideoPlayer.this.nff = currentTimeMillis;
                        }
                        VideoPlayer.this.nfE.B(7, 5000L);
                    } else {
                        VideoPlayer.this.nfE.Lz(7);
                    }
                    if (VideoPlayer.this.g) {
                        VideoPlayer.this.g = false;
                    }
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void dJv() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerACallback onBufferingEnd");
            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.nfc != null && !VideoPlayer.this.d) {
                VideoPlayer.this.nfE.removeMessages(7);
                VideoPlayer.this.M = false;
                if (VideoPlayer.this.nfc == null || !VideoPlayer.this.nfc.H) {
                    if (VideoPlayer.this.neY == null) {
                        VideoPlayer.this.nfc.a(false, true, false);
                    } else {
                        VideoPlayer.this.nfc.a(true, VideoPlayer.this.neY.getPlayState() == 4, VideoPlayer.this.neY.getPlayState() == 5);
                    }
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void dJw() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerACallback onPlayerStart");
            if (!VideoPlayer.this.isFinishing()) {
                if (VideoPlayer.this.nfc == null || !VideoPlayer.this.nfc.H) {
                    if (VideoPlayer.this.nfc != null && !VideoPlayer.this.d) {
                        if (VideoPlayer.this.neY != null) {
                            VideoPlayer.this.nfc.F();
                            VideoPlayer.this.nfc.a(true, VideoPlayer.this.neY.getPlayState() == 4, VideoPlayer.this.neY.getPlayState() == 5);
                        } else {
                            VideoPlayer.this.nfc.a(false, true, false);
                        }
                    }
                    if (VideoPlayer.this.nfE != null && !VideoPlayer.this.dJd()) {
                        VideoPlayer.this.nfE.removeMessages(1);
                        VideoPlayer.this.nfE.B(1, VideoPlayer.A);
                    }
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void dJx() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerACallback onPlayerPause");
            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.nfE != null) {
                VideoPlayer.this.nfE.removeMessages(1);
            }
        }

        @Override // tv.chushou.common.player.b
        public void dJy() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerACallback onPlayerStop");
            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.dJd() && VideoPlayer.this.neZ != null && !h.isEmpty(VideoPlayer.this.P) && VideoPlayer.this.neZ.getCurrentPos() > 0) {
                j.dIV().a(VideoPlayer.this.P, VideoPlayer.this.neZ.getCurrentPos());
            }
        }
    };
    private tv.chushou.common.player.b nfI = new tv.chushou.common.player.b() { // from class: com.kascend.chushou.player.VideoPlayer.15
        @Override // tv.chushou.common.player.b
        public void dJq() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerBCallback onSetVideoViewLayout");
            if (!VideoPlayer.this.isFinishing()) {
                if ((VideoPlayer.this.nfc == null || !VideoPlayer.this.nfc.H) && VideoPlayer.this.nfc != null && VideoPlayer.this.d) {
                    VideoPlayer.this.nfc.y();
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void Kc(int i) {
            if (!VideoPlayer.this.isFinishing()) {
                if ((VideoPlayer.this.nfc == null || !VideoPlayer.this.nfc.H) && VideoPlayer.this.nfc != null && VideoPlayer.this.d) {
                    VideoPlayer.this.nfc.g(i);
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void dJr() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerBCallback onCompletePlayback");
            if (!VideoPlayer.this.isFinishing()) {
                if (!h.isEmpty(VideoPlayer.this.P)) {
                    j.dIV().a(VideoPlayer.this.P, 0);
                }
                VideoPlayer.this.K = false;
                if (VideoPlayer.this.nfE != null) {
                    VideoPlayer.this.nfE.removeMessages(1);
                }
                if ((VideoPlayer.this.nfc == null || !VideoPlayer.this.nfc.H) && VideoPlayer.this.nfc != null && VideoPlayer.this.d) {
                    VideoPlayer.this.nfE.removeMessages(7);
                    VideoPlayer.this.M = false;
                    VideoPlayer.this.nfc.z();
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void dJs() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerBCallback onVideoRenderingStart");
            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.nfc != null) {
                VideoPlayer.this.nfc.G();
            }
        }

        @Override // tv.chushou.common.player.b
        public void dJt() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerBCallback onPreparedPlayback");
            if (!VideoPlayer.this.isFinishing()) {
                if (VideoPlayer.this.nfc == null || !VideoPlayer.this.nfc.H) {
                    VideoPlayer.this.nfE.removeMessages(6);
                    VideoPlayer.this.nff = 0L;
                    VideoPlayer.this.O = 0;
                    if (VideoPlayer.this.neY != null && VideoPlayer.this.nfc != null) {
                        VideoPlayer.this.neY.setVolume(VideoPlayer.this.nfc.J, VideoPlayer.this.nfc.J);
                    }
                    if (VideoPlayer.this.nfe != null) {
                        VideoPlayer.this.K = false;
                        FullRoomInfo dJB = VideoPlayer.this.dJd() ? null : VideoPlayer.this.nfe.dJB();
                        if (VideoPlayer.this.L || dJB != null) {
                            if (VideoPlayer.this.nfe.e) {
                                VideoPlayer.this.nfe.e = false;
                                VideoPlayer.this.nfe.d = !VideoPlayer.this.nfe.d;
                            }
                            if (VideoPlayer.this.nfc != null) {
                                VideoPlayer.this.c("1", (String) null);
                                if (VideoPlayer.this.d) {
                                    VideoPlayer.this.nfc.i(true);
                                } else if (VideoPlayer.this.e) {
                                    VideoPlayer.this.e = false;
                                    VideoPlayer.this.nfc.B();
                                }
                            }
                        }
                    }
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void Kd(int i) {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerBCallback onErrorAppeared");
            if (!VideoPlayer.this.isFinishing()) {
                VideoPlayer.this.c();
                VideoPlayer.this.K = false;
                if (VideoPlayer.this.nfE != null) {
                    VideoPlayer.this.nfE.removeMessages(7);
                }
                if (VideoPlayer.this.nfE != null) {
                    VideoPlayer.this.nfE.removeMessages(1);
                }
                if ((VideoPlayer.this.nfc == null || !VideoPlayer.this.nfc.H) && !VideoPlayer.this.dIX()) {
                    if (!"10004".equals(VideoPlayer.this.t)) {
                        if (VideoPlayer.this.nfc != null) {
                            if (!VideoPlayer.this.d) {
                                VideoPlayer.this.nfa.stop();
                                VideoPlayer.this.nfa.release();
                                VideoPlayer.this.nfc.C();
                                VideoPlayer.this.e = false;
                            }
                            if (!com.kascend.chushou.b.dII().a && !com.kascend.chushou.b.dII().b) {
                                VideoPlayer.this.nfc.g(true);
                            } else if (VideoPlayer.this.d) {
                                VideoPlayer.this.nfc.a(i, false);
                            } else {
                                VideoPlayer.this.nfc.a(i, true);
                            }
                            VideoPlayer.this.c("2", (String) null);
                            return;
                        }
                        return;
                    }
                    dJr();
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void dJu() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerBCallback onBufferingStart");
            if (!VideoPlayer.this.isFinishing()) {
                if ((VideoPlayer.this.nfc == null || !VideoPlayer.this.nfc.H) && VideoPlayer.this.nfc != null && VideoPlayer.this.d) {
                    VideoPlayer.this.nfc.E();
                    VideoPlayer.this.M = true;
                    VideoPlayer.this.nfE.removeMessages(7);
                    long currentTimeMillis = System.currentTimeMillis();
                    if (!VideoPlayer.this.g) {
                        VideoPlayer.y(VideoPlayer.this);
                    }
                    tv.chushou.zues.utils.e.d(VideoPlayer.this.v, "currentTime: -- >" + currentTimeMillis + "  bufferTime-->" + VideoPlayer.this.nff + "  bufferCount-->" + VideoPlayer.this.O);
                    if (currentTimeMillis - VideoPlayer.this.nff >= 20000 || VideoPlayer.this.O < 2 || VideoPlayer.this.nfc.H) {
                        if (VideoPlayer.this.O == 1) {
                            VideoPlayer.this.nff = currentTimeMillis;
                        }
                        VideoPlayer.this.nfE.B(7, 5000L);
                    } else {
                        VideoPlayer.this.nff = 0L;
                        VideoPlayer.this.O = 0;
                        VideoPlayer.this.nfE.Lz(7);
                    }
                    if (VideoPlayer.this.g) {
                        VideoPlayer.this.g = false;
                    }
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void dJv() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerBCallback onBufferingEnd");
            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.nfc != null && VideoPlayer.this.d) {
                VideoPlayer.this.M = false;
                VideoPlayer.this.nfE.removeMessages(7);
                if (VideoPlayer.this.nfc == null || !VideoPlayer.this.nfc.H) {
                    if (VideoPlayer.this.neY == null) {
                        VideoPlayer.this.nfc.a(false, true, false);
                    } else {
                        VideoPlayer.this.nfc.a(true, VideoPlayer.this.neY.getPlayState() == 4, VideoPlayer.this.neY.getPlayState() == 5);
                    }
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void dJw() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerBCallback onPlayerStart");
            if (!VideoPlayer.this.isFinishing()) {
                if (VideoPlayer.this.nfc == null || !VideoPlayer.this.nfc.H) {
                    if (VideoPlayer.this.nfc != null && VideoPlayer.this.d) {
                        if (VideoPlayer.this.neY != null) {
                            VideoPlayer.this.nfc.F();
                            VideoPlayer.this.nfc.a(true, VideoPlayer.this.neY.getPlayState() == 4, VideoPlayer.this.neY.getPlayState() == 5);
                        } else {
                            VideoPlayer.this.nfc.a(false, true, false);
                        }
                    }
                    if (VideoPlayer.this.nfE != null && !VideoPlayer.this.dJd()) {
                        VideoPlayer.this.nfE.removeMessages(1);
                        VideoPlayer.this.nfE.B(1, VideoPlayer.A);
                    }
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void dJx() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerBCallback onPlayerPause");
            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.nfE != null) {
                VideoPlayer.this.nfE.removeMessages(1);
            }
        }

        @Override // tv.chushou.common.player.b
        public void dJy() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerBCallback onPlayerStop");
            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.dJd() && VideoPlayer.this.nfa != null && !h.isEmpty(VideoPlayer.this.P) && VideoPlayer.this.nfa.getCurrentPos() > 0) {
                j.dIV().a(VideoPlayer.this.P, VideoPlayer.this.nfa.getCurrentPos());
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
        this.neX = intent.getData();
        if (this.neX == null) {
            finish();
            return;
        }
        com.kascend.chushou.d.e.j();
        if (this.nfD == null) {
            this.nfD = new CSTVWifiReceiver();
            registerReceiver(this.nfD, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        }
        com.kascend.chushou.toolkit.d.a.dKX().b();
        tv.chushou.zues.utils.e.i(this.v, "intent.getData=" + this.neX.toString());
        String scheme = this.neX.getScheme();
        if (scheme == null || !scheme.equals("chushou")) {
            tv.chushou.zues.utils.e.e(this.v, "not support scheme :" + scheme);
            finish();
            return;
        }
        a(intent);
    }

    private void a(Intent intent) {
        this.P = this.neX.getQueryParameter("roomId");
        this.Q = this.P;
        this.S = this.neX.getQueryParameter(WebSocketRequest.PARAM_KEY_PROTOCOLS);
        this.aq = this.neX.getQueryParameter("liveType");
        if ("2".equals(this.aq) || "3".equals(this.aq) || "4".equals(this.aq)) {
            this.nfz = "2";
            this.nfA = new com.kascend.chushou.player.feedback.a();
            if (this.nfA.nnN != null) {
                this.nfA.nnN.reset();
                this.nfA.nnN.roomId = this.P;
                this.nfA.nnN.enterType = 1;
                this.nfA.b = System.currentTimeMillis();
            }
        }
        if (h.isEmpty(this.P) || h.isEmpty(this.S)) {
            tv.chushou.zues.utils.e.e(this.v, "invalid param mItemID=" + this.P + " protocols=" + this.S);
            finish();
            return;
        }
        if (com.kascend.chushou.b.dII().d == -1) {
            com.kascend.chushou.b.dII().d = com.kascend.chushou.d.g.b() ? 1 : 0;
        }
        this.nfq = ((PowerManager) getSystemService("power")).newWakeLock(536870938, this.v);
        this.nfq.acquire();
        this.nfe = new b(this.P);
        this.nfe.d = intent.getBooleanExtra("room_play_audio", false);
        this.nfi = new com.kascend.chushou.widget.a.b();
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
        this.nfk = (KPSwitchRootRelativeLayout) findViewById(a.f.rlRoot);
        if (!"2".equals(this.nfz) && com.kascend.chushou.b.dII().d == 1) {
            this.nfk.setFitsSystemWindows(true);
        }
        this.nfl = (FrameLayout) this.nfk.findViewById(a.f.fl_fragment);
        this.bDj = this.nfk.findViewById(a.f.rl_empty);
        this.T = (ImageView) this.bDj.findViewById(a.f.iv_empty);
        this.U = (TextView) this.bDj.findViewById(a.f.tv_empty);
        this.nfm = (LinearLayout) this.nfk.findViewById(a.f.rl_title);
        this.Z = (ImageView) this.nfm.findViewById(a.f.back_icon);
        this.Z.setOnClickListener(new View.OnClickListener() { // from class: com.kascend.chushou.player.VideoPlayer.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayer.this.finish();
            }
        });
        this.nfh = (AnimationImageView) this.bDj.findViewById(a.f.iv_loading);
        this.nfr = (FrescoThumbnailView) this.nfk.findViewById(a.f.live_cover);
        this.nfs = (FrameLayout) this.nfk.findViewById(a.f.fl_cover);
        this.k = dIW();
        try {
            this.nfj = (AudioManager) getApplicationContext().getSystemService("audio");
            n = this.nfj.getStreamVolume(3);
            this.nfj.requestAudioFocus(null, 3, 1);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (this.B) {
            a(1, dJd() ? "3" : "1");
        } else {
            r();
        }
        if (com.kascend.chushou.b.dII().b && !com.kascend.chushou.b.dII().a) {
            RxExecutor.postDelayed(this.nfB, EventThread.MAIN_THREAD, 60L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.VideoPlayer.5
                @Override // java.lang.Runnable
                public void run() {
                    if (!VideoPlayer.this.isFinishing() && com.kascend.chushou.b.dII().b && !com.kascend.chushou.b.dII().a) {
                        tv.chushou.zues.utils.g.c(VideoPlayer.this.w, VideoPlayer.this.getString(a.i.str_monet_notify));
                    }
                }
            });
        }
        com.kascend.chushou.c.c.dIL().a(this.P, stringExtra, System.currentTimeMillis());
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
        if (this.nfC == null) {
            this.nfC = new a();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.media.VOLUME_CHANGED_ACTION");
            registerReceiver(this.nfC, intentFilter);
        }
    }

    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        j(false);
        if (this.nfC != null) {
            unregisterReceiver(this.nfC);
            this.nfC = null;
        }
        super.onStop();
    }

    @Override // com.kascend.chushou.view.base.BaseActivity
    protected void a(boolean z) {
        if (this.nfc != null) {
            this.nfc.k(z);
        }
    }

    @Subscribe
    public void onHideGiftEffectEvent(com.kascend.chushou.b.a.a.f fVar) {
        if (fVar.b) {
            this.nfc.k();
            return;
        }
        this.nfc.m();
        this.nfc.l();
    }

    private float dIW() {
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
            this.nfe.h = jSONObject.toString();
            String optString = jSONObject.optString("_thumb");
            jSONObject.optBoolean("tag_from_game_mic", false);
            if (!h.isEmpty(optString)) {
                this.ab = optString;
            }
        } catch (JSONException e) {
            e.printStackTrace();
            this.nfe.h = str;
        }
        if (dJd()) {
            a(this.P, str);
            ba(this.P, z);
            return;
        }
        a = this.P;
        b(this.P, str);
        a(this.P, dJn(), z);
        w();
    }

    private void O() {
        this.m = true;
        j();
        if (this.nfc != null) {
            this.nfc.r();
        }
        s();
    }

    @Subscribe
    public void onStartRoomEvent(o oVar) {
        if (!isFinishing() && oVar.neF != null && oVar.c != null && !h.isEmpty(oVar.neF.mTargetKey)) {
            if (oVar.c != this) {
                tv.chushou.zues.utils.e.e(this.v, "different player!");
                return;
            }
            if (this.nfe != null) {
                this.nfe.a();
                this.nfe.a = oVar.neF.mTargetKey;
                this.nfe.d = oVar.d;
                if (this.nfe.ngD != null) {
                    this.nfe.ngD.e();
                }
                if (this.nfe.ngD != null) {
                    this.nfe.ngD.b();
                }
                this.nfe.ngH = null;
                this.nfe.ngG = null;
                this.nfe.ngK = null;
                this.nfe.ngJ = null;
                this.nfe.ngN = null;
                this.nfe.ngL = null;
                this.nfe.ngM = null;
            }
            if (this.nfj != null) {
                n = this.nfj.getStreamVolume(3);
            }
            if (!h.isEmpty(oVar.neF.mType) && oVar.neF.mType.equals("3")) {
                this.B = false;
                this.nfz = "1";
                r();
                this.P = oVar.neF.mTargetKey;
                this.R = "3";
                if (this.nfi != null) {
                    this.nfi.a();
                }
                if (this.nfe != null) {
                    this.nfe.a((PlayUrl) null);
                    this.nfe.f();
                    if (this.nfe.c() != null) {
                        this.nfe.c().clear();
                    }
                    this.nfe.i.clear();
                }
                if (this.nfc != null) {
                    this.nfc.j();
                }
                s();
                if (this.nfn != null) {
                    this.nfn.d();
                    this.nfn = null;
                }
                if (this.nfB != null) {
                    this.nfB.dispose();
                    this.nfB = new io.reactivex.disposables.a();
                }
                a(oVar.e, false);
                return;
            }
            boolean z = this.R != null && this.R.equals("1");
            this.R = "1";
            this.nfw.a();
            this.nfv.a();
            this.nfu.a();
            this.nft.c();
            this.nfy.a();
            if (this.nfB != null) {
                this.nfB.dispose();
                this.nfB = new io.reactivex.disposables.a();
            }
            if ("1".equals(oVar.f)) {
                this.H = false;
                if (this.nfe != null && !h.isEmpty(this.nfe.t)) {
                    this.nfe.t.clear();
                }
                this.ab = oVar.neF.mCover;
                this.nfs.setVisibility(0);
                this.nfr.setBlur(true);
                this.nfr.i(oVar.neF.mCover, 0, 0, 0);
            }
            if (!oVar.neF.mTargetKey.equals(this.P)) {
                this.aq = oVar.g;
                if (!z) {
                    this.B = false;
                    r();
                } else if (!"2".equals(this.nfz) && ("2".equals(this.aq) || "3".equals(this.aq) || "4".equals(this.aq))) {
                    this.nfz = "2";
                    this.nfA = new com.kascend.chushou.player.feedback.a();
                    if (this.nfA.nnN != null) {
                        this.nfA.nnN.reset();
                        this.nfA.nnN.roomId = oVar.neF.mTargetKey;
                        this.nfA.nnN.enterType = 1;
                        this.nfA.b = System.currentTimeMillis();
                    }
                }
                this.B = false;
                this.P = oVar.neF.mTargetKey;
                this.Q = this.P;
                this.ab = oVar.neF.mCover;
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
                JSONObject P = com.kascend.chushou.d.e.P("_fromView", str, "_sc", oVar.neF.mSC);
                com.kascend.chushou.toolkit.a.c.a(this.w, P);
                if (this.nfi != null) {
                    this.nfi.a();
                    this.nfi.a(this.P);
                }
                if (this.nfe != null) {
                    this.nfe.a((PlayUrl) null);
                    this.nfe.f();
                    if (this.nfe.c() != null) {
                        this.nfe.c().clear();
                    }
                    this.nfe.i.clear();
                }
                if (this.nfc != null) {
                    this.nfc.j();
                }
                a(P.toString(), false);
                return;
            }
            tv.chushou.zues.utils.g.LI(a.i.str_same_room);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dIX() {
        FullRoomInfo dJB;
        String str;
        RoomInfo roomInfo;
        if (dJd()) {
            str = null;
            dJB = null;
        } else {
            dJB = this.nfe.dJB();
            str = (dJB == null || (roomInfo = dJB.mRoominfo) == null) ? null : roomInfo.mGameId;
        }
        return !this.L && (dJB == null || h.isEmpty(str));
    }

    @Subscribe
    public void onMessageEvent(i iVar) {
        if (!isFinishing() && iVar.a != 21 && iVar.a != 22) {
            if (iVar.a == 0 && (iVar.b instanceof Boolean)) {
                if (((Boolean) iVar.b).booleanValue() && !isFinishing()) {
                    w();
                    if (this.nfc != null) {
                        this.nfc.f();
                    }
                }
            } else if (iVar.a == 46) {
                if ((iVar.b instanceof String) && this.nfc != null) {
                    this.nfc.c((String) iVar.b);
                }
            } else if (iVar.a == 54) {
                if (iVar.b instanceof String) {
                    this.nfu.a((String) iVar.b);
                }
            } else if (iVar.a == 55) {
                if (this.nfc != null) {
                    this.nfc.O();
                }
            } else if (iVar.a == 56 && this.nfc != null) {
                this.nfc.P();
            }
        }
    }

    @Subscribe
    public void onRefreshSubscribeEvent(m mVar) {
        if (isFinishing() && this.nfe != null && this.nfe.dJE() != null) {
            RoomInfo dJE = this.nfe.dJE();
            if (mVar.a(dJE.mCreatorUID, dJE.mRoomID)) {
                dJE.mIsSubscribed = mVar.c;
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
        if (this.m || this.neZ == null || this.nfa == null) {
            R();
        }
        if (this.nfi != null) {
            this.nfi.d();
        }
        if (!dJd()) {
            if (this.nfn != null && !this.nfn.c()) {
                this.nfn.a();
            }
            v();
            if (this.nfe != null && this.nfe.dJB() != null && this.nfe.dJB().cycleLiveRoomInfo != null && !h.isEmpty(this.nfe.dJB().cycleLiveRoomInfo.roomId)) {
                u();
            }
        }
        super.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.view.base.BaseActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        tv.chushou.zues.utils.e.e(this.v, MissionEvent.MESSAGE_DESTROY);
        if (this.nfe != null && this.nfe.dJB() != null && this.nfe.dJB().cycleLiveRoomInfo != null && !h.isEmpty(this.nfe.dJB().cycleLiveRoomInfo.eventName)) {
            j.dIV().a(this.P + dJn());
        }
        if ("2".equals(this.nfz) && this.nfA != null && this.nfA.nnN != null) {
            this.nfA.nnN.time = System.currentTimeMillis() - this.nfA.b;
            this.nfA.a();
            this.nfA.b();
        }
        this.nft.d();
        this.nfu.b();
        this.nfv.b();
        O();
        this.ag = null;
        a = null;
        if (this.nfE != null) {
            this.nfE.ch(null);
            this.nfE = null;
        }
        if (this.nfn != null) {
            this.nfn.d();
            this.nfn = null;
        }
        if (this.nfi != null) {
            this.nfi.c();
            this.nfi = null;
        }
        if (this.nfe != null) {
            this.nfe.ngH = null;
            this.nfe.ngG = null;
        }
        if (this.nfe != null) {
            this.nfe.b();
            this.nfe = null;
        }
        this.neX = null;
        this.nfc = null;
        this.nfd = null;
        this.nfg = null;
        this.T = null;
        this.U = null;
        this.nfh = null;
        this.bDj = null;
        this.nfj = null;
        this.nfk = null;
        this.nfl = null;
        this.Z = null;
        this.nfm = null;
        if (this.nfq != null && this.nfq.isHeld()) {
            this.nfq.release();
            this.nfq = null;
        }
        if (this.nfD != null) {
            unregisterReceiver(this.nfD);
            this.nfD = null;
        }
        h.dWJ();
        tv.chushou.zues.a.a.ci(this);
        this.nfB.dispose();
        this.nfv.b();
        this.nfw.b();
        this.nft.d();
        this.nfu.b();
        this.nfy.b();
        super.onDestroy();
        System.gc();
    }

    @Subscribe
    public void onSendGameGiftEvent(n nVar) {
        if (!isFinishing() && this.nfc != null) {
            this.nfc.a(nVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.view.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        tv.chushou.zues.utils.e.d(this.v, MissionEvent.MESSAGE_PAUSE);
        if (this.nfn != null) {
            this.nfn.b();
        }
        if (this.nfi != null) {
            this.nfi.b(false);
        }
        k();
        this.m = true;
        super.onPause();
    }

    @Override // android.app.Activity
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.nfc != null ? this.nfc.a(motionEvent) : super.onTouchEvent(motionEvent);
    }

    public void c() {
        if ("1".equals(this.R)) {
            j.dIV().a(this.P + dJn());
        } else {
            j.dIV().b(this.P);
        }
    }

    private void a(boolean z, boolean z2) {
        int i = 0;
        tv.chushou.zues.utils.e.i(this.v, "startLoadingVideo <------------- mbPrepareingVideo = " + this.K);
        if (this.neZ != null) {
            this.neZ.setHardwearDecod(com.kascend.chushou.d.h.dIP().a);
        }
        if (this.nfa != null) {
            this.nfa.setHardwearDecod(com.kascend.chushou.d.h.dIP().a);
        }
        if (this.neY != null) {
            this.neY.setHardwearDecod(com.kascend.chushou.d.h.dIP().a);
        }
        if (!this.K) {
            if (z && this.nfc != null) {
                if (!z2) {
                    this.t = null;
                    this.nfc.e();
                }
            } else if (this.nfc != null && !z2) {
                this.t = null;
                this.nfc.H = false;
                RxExecutor.post(null, EventThread.MAIN_THREAD, new Runnable() { // from class: com.kascend.chushou.player.VideoPlayer.7
                    @Override // java.lang.Runnable
                    public void run() {
                        VideoPlayer.this.nfc.x();
                    }
                });
            }
            this.K = true;
            if (this.nfe != null && this.nfe.dJC() != null) {
                PlayUrl dJC = this.nfe.dJC();
                while (true) {
                    int i2 = i;
                    if (i2 >= dJC.mUrlDetails.size()) {
                        break;
                    }
                    UrlDetails urlDetails = dJC.mUrlDetails.get(i2);
                    if (urlDetails.mUrl.equals(dJC.mSelectedUrl)) {
                        String str = dJC.mUrlDetails.get(i2).mDefinitionType;
                        String str2 = urlDetails.mBitrate;
                    }
                    i = i2 + 1;
                }
            }
            if (z2) {
                if (this.d) {
                    this.neZ.setVideoURI(this.neX);
                    this.neZ.open();
                    return;
                }
                this.nfa.setVideoURI(this.neX);
                this.nfa.open();
                return;
            }
            this.neY.setVideoURI(this.neX);
            this.neY.open();
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        try {
            if (motionEvent.getAction() == 0) {
                if (this.nfc != null && this.nfc.b(motionEvent)) {
                    return true;
                }
                if ("2".equals(this.nfz) && this.nfc != null) {
                    this.nfc.a(motionEvent);
                }
            } else if (this.nfc != null && this.nfc.b(motionEvent)) {
                return true;
            }
            return super.dispatchTouchEvent(motionEvent);
        } catch (Exception e) {
            return false;
        }
    }

    @Override // android.support.v7.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.nfc != null && this.nfc.a(i, keyEvent)) {
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
        if (this.nfe != null && this.nfe.dJB() != null && this.nfe.dJB().cycleLiveRoomInfo != null && !h.isEmpty(this.nfe.dJB().cycleLiveRoomInfo.roomId)) {
            this.nfs.setVisibility(0);
            this.nfr.setBlur(true);
            this.nfr.i(this.nfe.dJB().cycleLiveRoomInfo.avatar, 0, 0, 0);
            this.nfr.setVisibility(0);
            j.dIV().a(this.P + dJn());
            this.neX = null;
            R();
            this.Q = this.nfe.dJB().cycleLiveRoomInfo.roomId;
            a(this.P, dJn(), false);
        }
    }

    public void b(boolean z) {
        if (this.nfc != null) {
            this.nfc.j(z);
        }
    }

    public void a(boolean z, Uri uri, boolean z2) {
        tv.chushou.zues.utils.e.d(this.v, "loadIfNecessary reload=" + z + " isChangeLines-->" + z2);
        if (this.neZ != null && this.nfa != null) {
            if (uri != null) {
                this.neX = uri;
            }
            if (z2) {
                this.e = z2;
            }
            this.M = false;
            this.nff = 0L;
            this.O = 0;
            this.nfE.removeMessages(7);
            if (z) {
                if (z2) {
                    if (!this.d) {
                        this.nfa.setOnActivityCallBack(this.nfI);
                    } else {
                        this.neZ.setOnActivityCallBack(this.nfH);
                    }
                } else if (this.d) {
                    this.nfa.setOnActivityCallBack(this.nfI);
                } else {
                    this.neZ.setOnActivityCallBack(this.nfH);
                }
                this.K = false;
                b(true, z2);
            } else if (!this.J) {
                b(true, z2);
            }
            this.nfE.B(6, 3000L);
        }
    }

    private void b(boolean z, boolean z2) {
        VideoPlayInfo M;
        if ("1".equals(this.R)) {
            M = j.dIV().L(this.P + dJn(), 600000L);
        } else {
            M = j.dIV().M(this.P, 600000L);
        }
        if (M != null) {
            a(z, z2);
        } else if ("1".equals(this.R)) {
            a(this.P, dJn(), false);
        } else {
            ba(this.P, false);
        }
    }

    public tv.chushou.common.player.a dIY() {
        return this.neY;
    }

    public tv.chushou.common.player.a dIZ() {
        return this.neZ;
    }

    public tv.chushou.common.player.a dJa() {
        return this.nfa;
    }

    public void a(tv.chushou.common.player.a aVar) {
        this.neY = aVar;
    }

    public b dJb() {
        return this.nfe;
    }

    public com.kascend.chushou.widget.a.b dJc() {
        return this.nfi;
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
        FullRoomInfo dJB;
        this.r = -1L;
        if (this.s != -1 && this.s != 0) {
            this.r = this.s;
            this.s = -1L;
        }
        if (dJd() && this.neY != null && this.neY.getPlayState() == 4) {
            this.r = this.neY.getCurrentPos();
        }
        this.nfF = false;
        tv.chushou.zues.utils.e.d(this.v, "screenChange()<-----");
        tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard(this);
        if (str != null) {
            this.R = str;
        }
        if (!this.C || !z3 || "3".equals(this.R) || this.nfe == null || (dJB = this.nfe.dJB()) == null || dJB.mRoominfo == null || dJB.mRoominfo.mStyle != 1) {
            z5 = false;
        } else {
            z5 = true;
            i = 0;
        }
        if ("2".equals(this.nfz)) {
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
            if (com.kascend.chushou.b.dII().d == 1) {
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
            ((VideoPlayer) this.w).wW(false);
            ((VideoPlayer) this.w).g(true);
            if (z5) {
                setRequestedOrientation(1);
            } else {
                setRequestedOrientation(6);
            }
            getWindow().addFlags(512);
            getWindow().addFlags(256);
        }
        if (this.nfi == null) {
            this.nfi = new com.kascend.chushou.widget.a.b();
        }
        if (this.nfi != null) {
            this.nfi.a(this.P);
        }
        if (this.R.equals("5")) {
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            if (this.nfc != null) {
                beginTransaction.remove(this.nfc);
                this.nfc = null;
            }
            if (this.nfd != null) {
                beginTransaction.remove(this.nfd);
                this.nfd = null;
            }
            this.nfd = new com.kascend.chushou.view.user.b();
            beginTransaction.add(a.f.fl_fragment, this.nfd);
            beginTransaction.commitAllowingStateLoss();
        } else {
            FragmentTransaction beginTransaction2 = getSupportFragmentManager().beginTransaction();
            if (this.nfc != null) {
                beginTransaction2.remove(this.nfc);
                this.nfc = null;
            }
            if (this.nfd != null) {
                beginTransaction2.remove(this.nfd);
                this.nfd = null;
            }
            if ("2".equals(this.nfz)) {
                this.nfc = com.kascend.chushou.player.e.e.b(this.ab, z2, this.aq, this.P);
            } else if (1 == i) {
                if (!this.R.equals("3")) {
                    if (z4) {
                        v();
                    }
                    this.nfc = new com.kascend.chushou.player.d.a();
                    Bundle bundle = new Bundle();
                    bundle.putString("mCover", this.ab);
                    bundle.putBoolean("mInitViewAsync", z2);
                    this.nfc.setArguments(bundle);
                }
            } else {
                this.nfc = new com.kascend.chushou.player.d.b();
                Bundle bundle2 = new Bundle();
                if (z5) {
                    i = 1;
                }
                bundle2.putInt("mExtraOrientation", i);
                bundle2.putString("mViewType", this.R);
                this.nfc.setArguments(bundle2);
            }
            beginTransaction2.add(a.f.fl_fragment, this.nfc);
            beginTransaction2.commitAllowingStateLoss();
            this.H = true;
        }
        tv.chushou.zues.utils.e.d(this.v, "screenChange()----->");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dJd() {
        return this.R != null && this.R.equals("3");
    }

    private void R() {
        if (this.nfc != null) {
            this.nfc.nkb = null;
        }
        if (this.neY != null) {
            this.neY.release();
            this.neY = null;
            this.K = false;
        }
        if (this.neZ != null) {
            this.neZ.release();
            this.neZ = null;
        }
        if (this.nfa != null) {
            this.nfa.release();
            this.nfa = null;
        }
        if (this.nfb != null) {
            this.nfb.c();
        }
        this.d = false;
        this.e = false;
        this.M = false;
        this.nfb = new c();
        this.neZ = this.nfb.dJH();
        this.neZ.setOnActivityCallBack(this.nfH);
        this.nfa = this.nfb.dJI();
        this.nfa.setOnActivityCallBack(this.nfI);
        if (!this.d) {
            this.neY = this.neZ;
        } else {
            this.neY = this.nfa;
        }
        if (this.nfc != null) {
            this.nfc.nkb = this.neY;
        }
    }

    public void j() {
        if (this.neY != null) {
            this.neY.pause();
            this.neY.stop();
            this.neY.release();
            this.neY = null;
        }
        if (this.neZ != null) {
            this.neZ.stop();
            this.neZ.release();
            this.neZ = null;
        }
        if (this.nfa != null) {
            this.nfa.stop();
            this.nfa.release();
            this.nfa = null;
        }
        if (this.nfb != null) {
            this.nfb.c();
        }
    }

    public void k() {
        tv.chushou.common.player.a aVar = this.neY;
        if (aVar != null) {
            aVar.pause();
            aVar.stop();
        }
        tv.chushou.common.player.a aVar2 = this.neZ;
        if (aVar2 != null) {
            aVar2.stop();
        }
        tv.chushou.common.player.a aVar3 = this.nfa;
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
        if (this.nfF) {
            if (this.nfc != null) {
                this.nfc.s();
            }
        } else if (this.nfE != null) {
            this.nfE.b(this.nfE.LB(3), 20L);
        }
    }

    private void b(final String str, String str2) {
        com.kascend.chushou.c.c.dIL().a(new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.VideoPlayer.8
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
                        VideoPlayer.this.bO(r.mMessage, r.mRc);
                        return;
                    }
                    FullRoomInfo fullRoomInfo = (FullRoomInfo) r.mData;
                    VideoPlayer.this.dJl().a(fullRoomInfo.mBangMap);
                    if (h.isEmpty(fullRoomInfo.mRoominfo.mRoomID)) {
                        fullRoomInfo.mRoominfo.mRoomID = VideoPlayer.this.P;
                    }
                    if (!h.isEmpty(fullRoomInfo.mGeneralTabGifts)) {
                        com.kascend.chushou.d.e.a(VideoPlayer.this.nfB, new ArrayList(fullRoomInfo.mGeneralTabGifts));
                    }
                    if (VideoPlayer.this.nfe != null) {
                        VideoPlayer.this.nfe.a(fullRoomInfo);
                    }
                    VideoPlayer.this.L = false;
                    if (VideoPlayer.this.B) {
                        if (VideoPlayer.this.C && !"3".equals(VideoPlayer.this.R) && fullRoomInfo != null && fullRoomInfo.mRoominfo != null && fullRoomInfo.mRoominfo.mStyle == 1 && !h.isEmpty(fullRoomInfo.mRoominfo.mGameId)) {
                            z = true;
                        }
                        if (!z) {
                            if (VideoPlayer.this.nfc != null) {
                                VideoPlayer.this.nfc.a(VideoPlayer.this.nfe);
                            }
                            if (!h.isEmpty(fullRoomInfo.mRoominfo.mGameId)) {
                                VideoPlayer.this.S();
                            } else {
                                if (VideoPlayer.this.nfe != null) {
                                    VideoPlayer.this.nfe.f = null;
                                }
                                VideoPlayer.this.S();
                            }
                        } else {
                            VideoPlayer.this.a(1, "1", true);
                            if (VideoPlayer.this.nfc != null) {
                                VideoPlayer.this.nfc.a(VideoPlayer.this.nfe);
                            }
                        }
                    } else {
                        if (h.isEmpty(fullRoomInfo.mRoominfo.mGameId)) {
                            if (VideoPlayer.this.nfe != null) {
                                VideoPlayer.this.nfe.f = null;
                            }
                            VideoPlayer.this.a(1, "1");
                        } else {
                            VideoPlayer.this.a(1, "1", true);
                        }
                        if (VideoPlayer.this.nfc != null) {
                            VideoPlayer.this.nfc.a(VideoPlayer.this.nfe);
                        }
                    }
                    if (VideoPlayer.this.nfe != null && !VideoPlayer.this.nfe.m()) {
                        if (VideoPlayer.this.nfn != null) {
                            VideoPlayer.this.nfn.d();
                            VideoPlayer.this.nfn = null;
                        }
                        VideoPlayer.this.nfn = new com.kascend.chushou.toolkit.d(900000L, VideoPlayer.this.nfp, VideoPlayer.this.nfE);
                        VideoPlayer.this.nfn.a();
                    }
                }
            }

            @Override // com.kascend.chushou.c.b
            public void a(int i, String str3) {
                if (!VideoPlayer.this.isFinishing()) {
                    VideoPlayer.this.bO(str3, i);
                }
            }
        }, str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bO(String str, int i) {
        if (this.nfe != null) {
            this.nfe.a((FullRoomInfo) null);
        }
        this.L = false;
        c(str, i);
        if (this.neY != null) {
            this.neY.stop();
        }
        if (this.neZ != null) {
            this.neZ.stop();
        }
        if (this.nfa != null) {
            this.nfa.stop();
        }
    }

    public void l() {
        tv.chushou.zues.utils.e.d(this.v, "retryGetPlayList");
        c();
        if (dJd()) {
            ba(this.P, false);
        } else {
            a(this.P, dJn(), false);
        }
    }

    public void m() {
        a(this.ag, false);
    }

    private void a(final String str, String str2, boolean z) {
        this.J = true;
        VideoPlayInfo L = j.dIV().L(str + str2, 600000L);
        if (L != null) {
            a((ArrayList) L.mPlayUrls);
            this.J = false;
        } else if (z) {
            ParserRet fV = com.kascend.chushou.player.c.a.dJJ().fV(str, str2);
            if (fV.mRc != 0) {
                tv.chushou.zues.utils.e.e(this.v, "getPlayUrlSync fail, try to getPlaylist");
                a(str, str2, false);
                return;
            }
            a(fV, str);
        } else {
            com.kascend.chushou.player.c.a.dJJ().a(str, str2, new a.InterfaceC0819a() { // from class: com.kascend.chushou.player.VideoPlayer.9
                @Override // com.kascend.chushou.player.c.a.InterfaceC0819a
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
    private void ba(final String str, boolean z) {
        boolean equals;
        this.J = true;
        VideoPlayInfo M = j.dIV().M(str, 600000L);
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
                ParserRet bb = com.kascend.chushou.player.c.a.dJJ().bb(str, equals);
                if (bb.mRc != 0) {
                    tv.chushou.zues.utils.e.e(this.v, "getVideoPlayUrlSync fail, try to getVideoPlaylist");
                    ba(str, false);
                    return;
                }
                a(bb, str);
                return;
            }
            com.kascend.chushou.player.c.a.dJJ().a(str, new a.InterfaceC0819a() { // from class: com.kascend.chushou.player.VideoPlayer.10
                @Override // com.kascend.chushou.player.c.a.InterfaceC0819a
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
                if (this.nfe.f == null) {
                    this.nfe.f = new ArrayList<>();
                }
                this.nfe.f.clear();
                this.nfe.f.addAll(arrayList);
                if ("1".equals(this.R)) {
                    j.dIV().a(str + dJn(), arrayList);
                } else {
                    j.dIV().t(str, arrayList);
                }
                a(arrayList);
                return;
            }
            if (this.nfe != null) {
                this.nfe.f = null;
            }
            if (this.nfE != null) {
                Message LB = this.nfE.LB(5);
                LB.arg1 = 2;
                LB.arg2 = parserRet.mRc;
                this.nfE.R(LB);
            }
        }
    }

    private void c(String str, int i) {
        s();
        if (this.nfi != null) {
            this.nfi.a();
        }
        if (h.isEmpty(str)) {
            str = getString(a.i.str_load_data_failed);
        }
        a(str, i);
    }

    public void n() {
        if (this.nfl != null && this.bDj != null && this.nfm != null) {
            this.nfl.setVisibility(0);
            this.bDj.setVisibility(8);
            this.nfm.setVisibility(8);
        }
    }

    public void o() {
        if (this.nfr != null && this.nfr.getVisibility() == 0) {
            this.nfr.zs(0);
            this.nfr.setVisibility(8);
        }
    }

    public void p() {
        if (this.nfs != null && this.nfs.getVisibility() == 0) {
            this.nfs.setVisibility(8);
        }
    }

    public void q() {
        this.nfF = true;
    }

    protected void r() {
        this.nfl.setVisibility(8);
        this.nfm.setVisibility(0);
        this.bDj.setVisibility(0);
        if (this.nfh != null) {
            this.T.setVisibility(8);
            this.nfh.setVisibility(0);
            this.U.setText(getString(a.i.str_dialog_loading_content));
            this.U.setVisibility(8);
        }
    }

    protected void a(String str, int i) {
        this.nfl.setVisibility(8);
        this.nfm.setVisibility(0);
        this.bDj.setVisibility(0);
        if (this.nfh != null) {
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
                            com.kascend.chushou.c.c.dIL().b(new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.VideoPlayer.11.1
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
                            }, VideoPlayer.this.P, (String) null, VideoPlayer.this.nfe.h);
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
            this.nfh.setVisibility(8);
            this.nfs.setVisibility(8);
        }
    }

    public void s() {
        if (this.nfE != null) {
            this.nfE.removeMessages(1);
        }
    }

    private void a(ArrayList<PlayUrl> arrayList) {
        boolean z;
        if (this.nfe.f == null) {
            this.nfe.f = new ArrayList<>();
        }
        this.nfe.f.clear();
        this.nfe.f.addAll(arrayList);
        if (com.kascend.chushou.d.e.b() && !"4".equals(this.aq)) {
            int c = com.kascend.chushou.d.e.c();
            if (c == -1) {
                b(arrayList);
                return;
            } else if (this.aw) {
                this.aw = false;
                if (c == 0) {
                    this.nfe.d = false;
                    f(arrayList, true);
                    return;
                }
                if (this.nfe != null && this.nfe.f != null) {
                    Iterator<PlayUrl> it = this.nfe.f.iterator();
                    while (it.hasNext()) {
                        if ("2".equals(it.next().mType)) {
                            z = true;
                            break;
                        }
                    }
                }
                z = false;
                this.nfe.d = z;
                f(arrayList, true);
                return;
            } else {
                if (this.nfe.e) {
                    this.nfe.d = !this.nfe.d;
                    this.nfe.e = false;
                    this.nfG = true;
                } else if ("4".equals(this.aq)) {
                    this.nfe.d = true;
                }
                f(arrayList, true);
                return;
            }
        }
        if (this.nfe.e) {
            this.nfe.d = !this.nfe.d;
            this.nfe.e = false;
            this.nfG = true;
        } else if ("4".equals(this.aq)) {
            this.nfe.d = true;
        }
        f(arrayList, true);
    }

    private void b(ArrayList<PlayUrl> arrayList) {
        if ("1".equals(this.R)) {
            if ("2".equals(this.nfz)) {
                d(false, arrayList);
            } else if (this.nfc != null) {
                this.nfc.f(arrayList, false);
            }
        } else if (this.nfc != null) {
            this.nfc.f(arrayList, false);
        }
    }

    public void c(boolean z) {
        this.nfe.d = false;
        com.kascend.chushou.d.e.a(0);
        ArrayList<PlayUrl> arrayList = this.nfe.f;
        if (!h.isEmpty(arrayList)) {
            if (z) {
                f(arrayList, false);
                if (this.nfE != null) {
                    this.nfE.Lz(2);
                    return;
                }
                return;
            }
            f(arrayList, true);
        }
    }

    public void d(boolean z) {
        this.nfe.d = true;
        com.kascend.chushou.d.e.a(1);
        ArrayList<PlayUrl> arrayList = this.nfe.f;
        if (!h.isEmpty(arrayList)) {
            if (z) {
                f(arrayList, false);
                if (this.nfE != null) {
                    this.nfE.Lz(2);
                    return;
                }
                return;
            }
            f(arrayList, true);
        }
    }

    @Subscribe
    public void onNotifyEvent(com.kascend.chushou.b.a.a.j jVar) {
        if (!isFinishing() && jVar.a == 1 && !"5".equals(this.R) && !dIX()) {
            tv.chushou.zues.utils.e.d(this.v, "onNetworkChangeEvent 3G=" + com.kascend.chushou.b.dII().b + "  wifi=" + com.kascend.chushou.b.dII().a);
            if (com.kascend.chushou.d.e.b() && !"4".equals(this.aq)) {
                if (com.kascend.chushou.d.e.c() == -1) {
                    if (this.nfc != null) {
                        this.nfc.e(false);
                    }
                    if ("1".equals(this.R)) {
                        if ("2".equals(this.nfz)) {
                            d(true, null);
                            return;
                        } else if (this.nfc != null) {
                            this.nfc.f(this.nfe.f, true);
                            return;
                        } else {
                            return;
                        }
                    } else if (this.nfc != null) {
                        this.nfc.f(this.nfe.f, true);
                        return;
                    } else {
                        return;
                    }
                }
                RxExecutor.postDelayed(this.nfB, EventThread.MAIN_THREAD, 10L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.VideoPlayer.12
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!VideoPlayer.this.isFinishing() && com.kascend.chushou.b.dII().b && !com.kascend.chushou.b.dII().a) {
                            tv.chushou.zues.utils.g.c(VideoPlayer.this.w, VideoPlayer.this.getString(a.i.str_monet_notify));
                        }
                    }
                });
            } else if (com.kascend.chushou.b.dII().a || com.kascend.chushou.b.dII().b) {
                t();
                if (this.nfE != null) {
                    this.nfE.Lz(2);
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
            if (this.nfe.d) {
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
            String d = com.kascend.chushou.d.h.dIP().d();
            String str3 = h.isEmpty(d) ? "2" : d;
            if (this.nfe.d) {
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
                if (this.nfe != null) {
                    this.nfe.a(playUrl2);
                    if (this.nfE != null) {
                        Message LB = this.nfE.LB(5);
                        LB.arg1 = 1;
                        this.nfE.R(LB);
                    }
                }
                String b = com.kascend.chushou.player.c.a.b(playUrl2);
                if (!h.isEmpty(b)) {
                    this.neX = Uri.parse(b);
                    if (this.nfG) {
                        this.nfG = false;
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (z && this.neY != null) {
                        a(false, z2);
                    }
                }
            }
        }
    }

    public void d(final boolean z, ArrayList<PlayUrl> arrayList) {
        if (this.nfo == null || this.nfo.a <= 0) {
            this.nfo = com.kascend.chushou.view.b.a.a.dKY();
            this.nfo.a(new a.InterfaceC0838a() { // from class: com.kascend.chushou.player.VideoPlayer.13
                @Override // com.kascend.chushou.view.b.a.a.InterfaceC0838a
                public void a(int i) {
                    if (i == a.f.tv_play_video) {
                        VideoPlayer.this.nfo.dismissAllowingStateLoss();
                        VideoPlayer.this.c(z);
                    } else if (i == a.f.tv_play_audio) {
                        VideoPlayer.this.nfo.dismissAllowingStateLoss();
                        VideoPlayer.this.d(z);
                    } else if (i == a.f.iv_close) {
                        VideoPlayer.this.finish();
                    } else {
                        if (i == a.f.tv_union_proxy) {
                        }
                    }
                }
            });
            this.nfo.show(getSupportFragmentManager(), "showRoom");
        }
    }

    public void t() {
        if (this.nfo != null) {
            this.nfo.dismissAllowingStateLoss();
        }
        if (this.nfc != null) {
            this.nfc.v();
        }
    }

    public void u() {
        com.kascend.chushou.c.c.dIL().c(this.P, new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.VideoPlayer.16
            @Override // com.kascend.chushou.c.b
            public void a() {
            }

            @Override // com.kascend.chushou.c.b
            public void a(String str, JSONObject jSONObject) {
                if (!VideoPlayer.this.isFinishing()) {
                    ParserRet dU = com.kascend.chushou.c.e.dU(jSONObject);
                    if (dU.mRc == 0 && dU.mData != null) {
                        CycleLiveRoomInfo cycleLiveRoomInfo = (CycleLiveRoomInfo) dU.mData;
                        if (VideoPlayer.this.nfe != null && cycleLiveRoomInfo != null && !h.isEmpty(cycleLiveRoomInfo.roomId)) {
                            FullRoomInfo dJB = VideoPlayer.this.nfe.dJB();
                            if (dJB.cycleLiveRoomInfo == null) {
                                dJB.cycleLiveRoomInfo = cycleLiveRoomInfo;
                                VideoPlayer.this.d();
                            } else if (dJB.cycleLiveRoomInfo != null && !cycleLiveRoomInfo.roomId.equals(dJB.cycleLiveRoomInfo.roomId)) {
                                dJB.cycleLiveRoomInfo.copyCycleLiveRoomInfo(cycleLiveRoomInfo);
                                VideoPlayer.this.d();
                            } else {
                                dJB.cycleLiveRoomInfo.copyCycleLiveRoomInfo(cycleLiveRoomInfo);
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
        if (this.nfc != null) {
            this.nfc.N();
        }
    }

    public void v() {
        com.kascend.chushou.c.c.dIL().a(this.P, new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.VideoPlayer.17
            @Override // com.kascend.chushou.c.b
            public void a() {
            }

            @Override // com.kascend.chushou.c.b
            public void a(String str, JSONObject jSONObject) {
                if (!VideoPlayer.this.isFinishing()) {
                    ParserRet dV = com.kascend.chushou.c.e.dV(jSONObject);
                    if (dV.mRc == 0 && dV.mData != null) {
                        PkNotifyInfo pkNotifyInfo = (PkNotifyInfo) dV.mData;
                        VideoPlayer.this.nfx.b = VideoPlayer.this.P;
                        if (pkNotifyInfo != null) {
                            VideoPlayer.this.nfx.nkc = pkNotifyInfo;
                            if (VideoPlayer.this.nfc != null) {
                                VideoPlayer.this.nfc.a(pkNotifyInfo, VideoPlayer.this.P);
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
        if (this.nfg != null) {
            this.nfg.release();
            this.nfg = null;
        }
        com.kascend.chushou.c.c.dIL().a(this.P, new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.VideoPlayer.18
            @Override // com.kascend.chushou.c.b
            public void a() {
            }

            @Override // com.kascend.chushou.c.b
            public void a(String str, JSONObject jSONObject) {
                if (!VideoPlayer.this.isFinishing()) {
                    ParserRet dW = com.kascend.chushou.c.e.dW(jSONObject);
                    if (dW.mRc == 0 && dW.mData != null) {
                        RoomExpandInfo roomExpandInfo = (RoomExpandInfo) dW.mData;
                        if (VideoPlayer.this.nfe != null) {
                            VideoPlayer.this.nfe.ngI = roomExpandInfo.mTopWebAdItem;
                            if (VideoPlayer.this.nfe.s == null) {
                                VideoPlayer.this.nfe.s = new ArrayList();
                            }
                            VideoPlayer.this.nfe.s.clear();
                            VideoPlayer.this.nfe.s.addAll(roomExpandInfo.mGiftTopRightIcons);
                            tv.chushou.zues.a.a.post(new i(50, VideoPlayer.this.nfe.ngI));
                        }
                        if (VideoPlayer.this.nfe != null) {
                            VideoPlayer.this.nfe.fv(roomExpandInfo.mExpandNavList);
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
                            VideoPlayer.this.nft.a(list);
                        }
                        List<com.kascend.chushou.player.ui.h5.c.c> list2 = roomExpandInfo.mLuckList;
                        if (!h.isEmpty(list2)) {
                            VideoPlayer.this.nfu.a(list2);
                        }
                        com.kascend.chushou.player.ui.h5.c.c cVar = roomExpandInfo.mVoteItem;
                        if (cVar != null) {
                            VideoPlayer.this.nfv.a(cVar);
                        }
                        List<com.kascend.chushou.player.ui.h5.c.b> list3 = roomExpandInfo.mInteractH5Item;
                        if (!h.isEmpty(list3)) {
                            VideoPlayer.this.nfy.a(list3);
                        }
                        List<com.kascend.chushou.player.ui.h5.c.b> list4 = roomExpandInfo.mInteractNavItem;
                        if (!h.isEmpty(list4)) {
                            VideoPlayer.this.nfy.a(list4);
                        }
                        VideoPlayer.this.nfg = (PrivilegeInfo) dW.mData1;
                        if (VideoPlayer.this.nfg != null) {
                            tv.chushou.zues.a.a.post(new l());
                        }
                        if (VideoPlayer.this.nfe != null) {
                            VideoPlayer.this.nfe.ngO = roomExpandInfo.mIconConfig;
                            VideoPlayer.this.dJl().a(roomExpandInfo.mIconConfig.bangConfig);
                        }
                        List<SkinConfig> list5 = roomExpandInfo.skinConfig;
                        if (list5 != null && VideoPlayer.this.nfe != null) {
                            VideoPlayer.this.nfe.ngR.clear();
                            int i = 0;
                            while (true) {
                                int i2 = i;
                                if (i2 >= list5.size()) {
                                    break;
                                }
                                SkinConfig skinConfig = list5.get(i2);
                                VideoPlayer.this.nfe.ngR.put(skinConfig.position, skinConfig.resource);
                                i = i2 + 1;
                            }
                            VideoPlayer.this.C();
                        }
                        VideoPlayer.this.a(roomExpandInfo.mIconConfig, VideoPlayer.this.nfe != null ? VideoPlayer.this.nfe.ngR : null);
                        if (roomExpandInfo.mColorMap != null && roomExpandInfo.mColorMap.size() > 0 && com.kascend.chushou.b.dII().c != null && com.kascend.chushou.b.dII().c.size() <= 0) {
                            com.kascend.chushou.b.dII().c.putAll(roomExpandInfo.mColorMap);
                            tv.chushou.zues.a.a.post(new i(52, null));
                        }
                        AutoBang autoBang = roomExpandInfo.mAutoBang;
                        if (autoBang != null && autoBang.currentTime != 0 && autoBang.bangTime != 0) {
                            VideoPlayer.this.dJl().a(autoBang);
                        }
                        if (!h.isEmpty(roomExpandInfo.mRelatedRoomList) && VideoPlayer.this.nfe != null) {
                            VideoPlayer.this.nfe.t = roomExpandInfo.mRelatedRoomList;
                            if (VideoPlayer.this.nfc != null && VideoPlayer.this.H) {
                                VideoPlayer.this.nfc.w();
                            }
                        }
                        if (roomExpandInfo.mRoomNewUserInfo != null && roomExpandInfo.mRoomNewUserInfo.mBarrierNoviceGuide && !com.kascend.chushou.d.h.dIP().k() && VideoPlayer.this.nfc != null) {
                            VideoPlayer.this.nfc.J();
                        }
                        if (roomExpandInfo.mRoomNewUserInfo != null && roomExpandInfo.mRoomNewUserInfo.mRewardNoviceGuide && !com.kascend.chushou.d.h.dIP().l() && VideoPlayer.this.nfc != null) {
                            VideoPlayer.this.nfc.K();
                        }
                        if (!h.isEmpty(roomExpandInfo.mShopWindowInfos)) {
                            if (VideoPlayer.this.nfe != null) {
                                if (VideoPlayer.this.nfe.ngP == null) {
                                    VideoPlayer.this.nfe.ngP = new ArrayList();
                                }
                                VideoPlayer.this.nfe.ngP.addAll(roomExpandInfo.mShopWindowInfos);
                            }
                            if (VideoPlayer.this.nfc != null) {
                                VideoPlayer.this.nfc.L();
                            }
                        }
                        VideoPlayer.this.nfx.b = VideoPlayer.this.P;
                        if (roomExpandInfo.mPkNotifyInfo != null) {
                            VideoPlayer.this.nfx.nkc = roomExpandInfo.mPkNotifyInfo;
                            if (VideoPlayer.this.nfc != null) {
                                VideoPlayer.this.nfc.a(roomExpandInfo.mPkNotifyInfo, VideoPlayer.this.P);
                            }
                        } else {
                            VideoPlayer.this.nfx.nkc = null;
                        }
                        if (roomExpandInfo.mTrumpetPocket != null && VideoPlayer.this.nfe != null) {
                            VideoPlayer.this.nfe.ngQ = roomExpandInfo.mTrumpetPocket;
                            if (VideoPlayer.this.nfc != null) {
                                VideoPlayer.this.nfc.M();
                            }
                        }
                        if (!h.isEmpty(roomExpandInfo.hotwordContentList)) {
                            if (VideoPlayer.this.nfe != null) {
                                if (VideoPlayer.this.nfe.w == null) {
                                    VideoPlayer.this.nfe.w = new ArrayList();
                                }
                                VideoPlayer.this.nfe.w.clear();
                                VideoPlayer.this.nfe.w.addAll(roomExpandInfo.hotwordContentList);
                            }
                            if (VideoPlayer.this.nfc != null) {
                                VideoPlayer.this.nfc.b(roomExpandInfo.hotwordContentList);
                            }
                        }
                        VideoPlayer.this.U();
                        return;
                    }
                    a(dW.mRc, dW.mMessage);
                }
            }

            @Override // com.kascend.chushou.c.b
            public void a(int i, String str) {
                tv.chushou.zues.utils.e.e(VideoPlayer.this.v, "get room gift popup list failed, rc =" + i + ", errorMsg=" + str);
            }
        }, this.ag, this.nfz);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U() {
        if (!h.isEmpty(com.kascend.chushou.a.a.dIJ().nex)) {
            StringBuilder sb = new StringBuilder();
            if (com.kascend.chushou.a.a.dIJ().nex.contains(com.kascend.chushou.a.a.f)) {
                if (sb.length() > 0) {
                    sb.append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                sb.append(com.kascend.chushou.a.a.f);
            }
            if (com.kascend.chushou.a.a.dIJ().nex.contains(com.kascend.chushou.a.a.g)) {
                if (sb.length() > 0) {
                    sb.append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                sb.append(com.kascend.chushou.a.a.g);
            }
            if (com.kascend.chushou.a.a.dIJ().nex.contains(com.kascend.chushou.a.a.i)) {
                if (sb.length() > 0) {
                    sb.append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                sb.append(com.kascend.chushou.a.a.i);
            }
            if (com.kascend.chushou.a.a.dIJ().nex.contains(com.kascend.chushou.a.a.h)) {
                if (sb.length() > 0) {
                    sb.append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                sb.append(com.kascend.chushou.a.a.h);
            }
            if (com.kascend.chushou.a.a.dIJ().nex.contains(com.kascend.chushou.a.a.j)) {
                if (sb.length() > 0) {
                    sb.append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                sb.append(com.kascend.chushou.a.a.j);
            }
            if (com.kascend.chushou.a.a.dIJ().nex.contains(com.kascend.chushou.a.a.l)) {
                if (sb.length() > 0) {
                    sb.append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                sb.append(com.kascend.chushou.a.a.l);
            }
            if (com.kascend.chushou.a.a.dIJ().nex.contains(com.kascend.chushou.a.a.m)) {
                if (sb.length() > 0) {
                    sb.append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                sb.append(com.kascend.chushou.a.a.m);
            }
            if (sb.length() != 0) {
                com.kascend.chushou.a.a.dIJ().a(sb.toString(), this.P, new a.c() { // from class: com.kascend.chushou.player.VideoPlayer.19
                    @Override // com.kascend.chushou.a.a.c
                    public void a(List<ListItem> list) {
                        if (VideoPlayer.this.nfe != null && list != null) {
                            int i = 0;
                            while (true) {
                                int i2 = i;
                                if (i2 >= list.size()) {
                                    break;
                                }
                                if (list.get(i2).mAdExtraInfo != null) {
                                    if (com.kascend.chushou.a.a.f.equals(list.get(i2).mAdExtraInfo.mCode)) {
                                        VideoPlayer.this.nfe.ngH = list.get(i2);
                                    } else if (com.kascend.chushou.a.a.g.equals(list.get(i2).mAdExtraInfo.mCode)) {
                                        VideoPlayer.this.nfe.ngG = list.get(i2);
                                    } else if (com.kascend.chushou.a.a.i.equals(list.get(i2).mAdExtraInfo.mCode)) {
                                        VideoPlayer.this.nfe.ngJ = list.get(i2);
                                    } else if (com.kascend.chushou.a.a.h.equals(list.get(i2).mAdExtraInfo.mCode)) {
                                        VideoPlayer.this.nfe.ngK = list.get(i2);
                                    } else if (com.kascend.chushou.a.a.j.equals(list.get(i2).mAdExtraInfo.mCode)) {
                                        VideoPlayer.this.nfe.ngN = list.get(i2);
                                    } else if (com.kascend.chushou.a.a.l.equals(list.get(i2).mAdExtraInfo.mCode)) {
                                        VideoPlayer.this.nfe.ngL = list.get(i2);
                                    } else if (com.kascend.chushou.a.a.m.equals(list.get(i2).mAdExtraInfo.mCode)) {
                                        VideoPlayer.this.nfe.ngM = list.get(i2);
                                    }
                                }
                                i = i2 + 1;
                            }
                            if (VideoPlayer.this.nfc != null) {
                                VideoPlayer.this.nfc.H();
                            }
                        }
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str, String str2) {
        if (dJd()) {
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
                this.nfk.setSystemUiVisibility(i);
                return;
            }
            this.nfk.setSystemUiVisibility(1792);
        }
    }

    public void f(boolean z) {
        Window window;
        View decorView;
        if (com.kascend.chushou.b.dII().d != 1 && (window = getWindow()) != null && (decorView = window.getDecorView()) != null) {
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
        if (this.nfc != null) {
            this.nfc.a(i, i2, intent);
        }
    }

    public Uri dJe() {
        return this.neX;
    }

    @Override // com.kascend.chushou.view.base.BaseActivity
    protected int y() {
        return 0;
    }

    public void wW(boolean z) {
        if (this.nfk != null) {
            this.nfk.onD = z;
        }
    }

    public void dJf() {
        if (this.nfk != null) {
            this.nfk.dJf();
        }
    }

    public boolean dJg() {
        return this.ae;
    }

    public void g(boolean z) {
        this.ae = z;
    }

    public void h(boolean z) {
        if (this.nfk != null) {
            this.nfk.setIsTranslucentStatus(z);
        }
    }

    public void z() {
        if (this.nfk != null) {
            this.nfk.dXe();
        }
    }

    @Override // com.kascend.chushou.widget.gifts.RoomSendGiftView.a
    public void A() {
        if (this.nfi != null) {
            this.nfi.b();
        }
        if (this.nfe != null) {
            this.nfe.z = true;
        }
    }

    @Override // com.kascend.chushou.widget.gifts.RoomSendGiftView.a
    public void B() {
        if (this.nfi != null) {
            this.nfi.b();
        }
    }

    public void a(List<ListItem> list) {
        if (this.nfc != null) {
            this.nfc.a(list);
        }
    }

    public void a(IconConfig iconConfig, Map<String, SkinConfig.SkinRes> map) {
        if (this.nfc != null) {
            this.nfc.a(iconConfig, map);
        }
    }

    public void C() {
        if (this.nfc != null) {
            this.nfc.I();
        }
    }

    @Override // com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC0830a
    public void a(int i) {
        if (this.nfc != null) {
            this.nfc.a(i);
        }
    }

    @Override // com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC0830a
    public void D() {
        if (!isFinishing() && this.nfc != null) {
            this.nfc.D();
        }
    }

    @Override // com.kascend.chushou.player.ui.h5.b.b.a
    public void a(long j) {
        if (!isFinishing() && this.nfc != null) {
            this.nfc.a(j);
        }
    }

    @Override // com.kascend.chushou.player.ui.h5.b.b.a
    public void a(com.kascend.chushou.player.ui.h5.c.a aVar) {
        if (aVar != null && this.nfc != null) {
            this.nfc.a(aVar);
        }
    }

    @Override // com.kascend.chushou.player.ui.h5.b.b.a
    public void b(int i) {
        if (this.nfc != null) {
            this.nfc.b(i);
        }
    }

    @Override // com.kascend.chushou.player.ui.h5.d.a.InterfaceC0829a
    public void b(long j) {
        if (!isFinishing() && this.nfc != null) {
            this.nfc.b(j);
        }
    }

    @Override // com.kascend.chushou.player.ui.h5.a.a.InterfaceC0827a
    public void c(int i) {
        if (!isFinishing() && this.nfc != null) {
            this.nfc.c(i);
        }
    }

    @Override // com.kascend.chushou.player.ui.h5.d.a.InterfaceC0829a
    public void b(com.kascend.chushou.player.ui.h5.c.a aVar) {
        if (aVar != null && this.nfc != null) {
            this.nfc.b(aVar);
        }
    }

    @Override // com.kascend.chushou.player.ui.a.a.InterfaceC0824a
    public void a(IconConfig.Config config) {
        if (this.nfc != null) {
            this.nfc.a(config);
        }
    }

    @Override // com.kascend.chushou.player.ui.a.a.InterfaceC0824a
    public void a(BangInfo bangInfo, String str) {
        if (this.nfc != null) {
            this.nfc.a(bangInfo, str);
        }
    }

    @Override // com.kascend.chushou.player.ui.a.a.InterfaceC0824a
    public void a(long j, BangInfo bangInfo, String str) {
        if (this.nfc != null) {
            this.nfc.a(j, bangInfo, str);
        }
    }

    public com.kascend.chushou.player.ui.h5.redpacket.a dJh() {
        return this.nft;
    }

    public com.kascend.chushou.player.ui.h5.b.b dJi() {
        return this.nfu;
    }

    public com.kascend.chushou.player.ui.h5.d.a dJj() {
        return this.nfv;
    }

    public com.kascend.chushou.player.ui.h5.a.a dJk() {
        return this.nfy;
    }

    public com.kascend.chushou.player.ui.a.a dJl() {
        return this.nfw;
    }

    public com.kascend.chushou.player.e.a dJm() {
        return this.nfx;
    }

    @Override // com.kascend.chushou.view.base.BaseActivity, android.app.Activity
    public void finish() {
        super.finish();
        if ("3".equals(this.R)) {
            overridePendingTransition(17432576, a.C0814a.commonres_activity_exit_bottom);
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
        RxExecutor.postDelayed(this.nfB, EventThread.MAIN_THREAD, aVar.d, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.VideoPlayer.2
            @Override // java.lang.Runnable
            public void run() {
                if (VideoPlayer.this.nfc != null) {
                    VideoPlayer.this.nfc.c(aVar);
                }
            }
        });
    }

    private void e(final com.kascend.chushou.player.ui.h5.c.a aVar) {
        if (!com.kascend.chushou.d.h.dIP().dIS().contains(aVar.b)) {
            if (aVar.d < 0) {
                aVar.d = 0;
            }
            RxExecutor.postDelayed(this.nfB, EventThread.MAIN_THREAD, aVar.d, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.VideoPlayer.3
                @Override // java.lang.Runnable
                public void run() {
                    if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.nfc != null) {
                        VideoPlayer.this.nfc.c(aVar);
                    }
                }
            });
        }
    }

    private String dJn() {
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
                if (VideoPlayer.this.nfj != null && !VideoPlayer.this.isFinishing()) {
                    VideoPlayer.n = VideoPlayer.this.nfj.getStreamVolume(3);
                }
                if (!VideoPlayer.this.isFinishing() && (VideoPlayer.this.nfc instanceof f)) {
                    ((f) VideoPlayer.this.nfc).ab();
                }
            }
        }
    }

    public String a(String str) {
        HashMap hashMap = new HashMap(tv.chushou.zues.utils.d.Tg(str));
        if ("1".equals(this.R)) {
            hashMap.put("roomId", this.P);
        } else if ("3".equals(this.R)) {
            hashMap.put("videoId", this.P);
        }
        return tv.chushou.zues.utils.d.toJson(hashMap);
    }

    public boolean dJo() {
        if (this.nfc instanceof com.kascend.chushou.player.d.a) {
            return ((com.kascend.chushou.player.d.a) this.nfc).dKn();
        }
        if (this.nfc instanceof com.kascend.chushou.player.e.e) {
            return true;
        }
        return false;
    }
}

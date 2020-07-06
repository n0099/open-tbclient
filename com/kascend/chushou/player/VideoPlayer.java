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
public class VideoPlayer extends BaseActivity implements a.InterfaceC0825a, a.InterfaceC0828a, b.a, a.InterfaceC0830a, a.InterfaceC0831a, RoomSendGiftView.a {
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
    public com.kascend.chushou.player.feedback.a nfD;
    private a nfF;
    private CSTVWifiReceiver nfG;
    private c nfe;
    b nfh;
    public PrivilegeInfo nfj;
    com.kascend.chushou.widget.a.b nfl;
    private KPSwitchRootRelativeLayout nfn;
    private FrameLayout nfo;
    private LinearLayout nfp;
    private com.kascend.chushou.toolkit.d nfq;
    com.kascend.chushou.view.b.a.a nfr;
    private FrescoThumbnailView nfu;
    private FrameLayout nfv;
    private boolean B = true;
    private boolean C = false;
    private Uri nfa = null;
    private tv.chushou.common.player.a nfb = null;
    public tv.chushou.common.player.a nfc = null;
    public tv.chushou.common.player.a nfd = null;
    public boolean d = false;
    public boolean e = false;
    private e nff = null;
    private boolean H = false;
    private com.kascend.chushou.view.user.b nfg = null;
    private boolean J = false;
    private boolean K = false;
    private boolean L = false;
    private boolean M = false;
    private long nfi = 0;
    private int O = 0;
    public boolean g = false;
    private ImageView T = null;
    private TextView U = null;
    private AnimationImageView nfk = null;
    private View bDj = null;
    public boolean j = false;
    public float k = 0.0f;
    public float l = 0.0f;
    public boolean m = false;
    public AudioManager nfm = null;
    private d.a nfs = new d.a() { // from class: com.kascend.chushou.player.VideoPlayer.1
        @Override // com.kascend.chushou.toolkit.d.a
        public void a() {
            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.nfH != null) {
                VideoPlayer.this.nfH.Lz(4);
            }
        }
    };
    private boolean ae = false;
    public boolean q = true;
    public long r = -1;
    public long s = -1;
    private PowerManager.WakeLock nft = null;
    public String t = null;
    private final com.kascend.chushou.player.ui.h5.redpacket.a nfw = new com.kascend.chushou.player.ui.h5.redpacket.a(this);
    private final com.kascend.chushou.player.ui.h5.b.b nfx = new com.kascend.chushou.player.ui.h5.b.b(this);
    private final com.kascend.chushou.player.ui.h5.d.a nfy = new com.kascend.chushou.player.ui.h5.d.a(this);
    private final com.kascend.chushou.player.ui.a.a nfz = new com.kascend.chushou.player.ui.a.a(this);
    private final com.kascend.chushou.player.e.a nfA = new com.kascend.chushou.player.e.a();
    private final com.kascend.chushou.player.ui.h5.a.a nfB = new com.kascend.chushou.player.ui.h5.a.a(this);
    private String nfC = "1";
    private String aq = "2";
    private io.reactivex.disposables.a nfE = new io.reactivex.disposables.a();
    private tv.chushou.zues.c nfH = new tv.chushou.zues.c(new Handler.Callback() { // from class: com.kascend.chushou.player.VideoPlayer.6
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            try {
                if (!VideoPlayer.this.isFinishing()) {
                    switch (message.what) {
                        case 1:
                            VideoPlayer.this.nfH.removeMessages(1);
                            com.kascend.chushou.c.c.dIP().a(VideoPlayer.this.P, VideoPlayer.this.nfh != null ? VideoPlayer.this.nfh.h : null, System.currentTimeMillis());
                            VideoPlayer.this.nfH.B(1, VideoPlayer.A);
                            break;
                        case 2:
                            VideoPlayer.this.a(true, (Uri) null, false);
                            break;
                        case 3:
                            VideoPlayer.this.S();
                            break;
                        case 4:
                            if (VideoPlayer.this.nff != null) {
                                VideoPlayer.this.nff.a(true);
                            }
                            if (VideoPlayer.this.nfq != null) {
                                VideoPlayer.this.nfq.d();
                                VideoPlayer.this.nfq = null;
                                break;
                            }
                            break;
                        case 5:
                            int i = message.arg1;
                            if (i == 1) {
                                if (VideoPlayer.this.nff != null) {
                                    VideoPlayer.this.nff.p();
                                    break;
                                }
                            } else if (i == 2 && VideoPlayer.this.nff != null) {
                                VideoPlayer.this.nff.e(message.arg2);
                                break;
                            }
                            break;
                        case 6:
                            if (!com.kascend.chushou.b.dIM().a && !com.kascend.chushou.b.dIM().b && VideoPlayer.this.nff != null) {
                                VideoPlayer.this.nff.g(true);
                                break;
                            } else {
                                VideoPlayer.this.c();
                                break;
                            }
                            break;
                        case 7:
                            tv.chushou.zues.utils.e.d(VideoPlayer.this.v, "MSG_BUFFER_DEALY: ");
                            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.nff != null && VideoPlayer.this.M && !VideoPlayer.this.e) {
                                VideoPlayer.this.nff.h(true);
                                VideoPlayer.this.nfi = 0L;
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
    private boolean nfI = false;
    private boolean aw = true;
    private boolean nfJ = false;
    private tv.chushou.common.player.b nfK = new tv.chushou.common.player.b() { // from class: com.kascend.chushou.player.VideoPlayer.14
        @Override // tv.chushou.common.player.b
        public void dJu() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerACallback onSetVideoViewLayout");
            if (!VideoPlayer.this.isFinishing()) {
                if ((VideoPlayer.this.nff == null || !VideoPlayer.this.nff.H) && VideoPlayer.this.nff != null && !VideoPlayer.this.d) {
                    VideoPlayer.this.nff.y();
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void Kc(int i) {
            if (!VideoPlayer.this.isFinishing()) {
                if ((VideoPlayer.this.nff == null || !VideoPlayer.this.nff.H) && VideoPlayer.this.nff != null && !VideoPlayer.this.d) {
                    VideoPlayer.this.nff.g(i);
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void dJv() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerACallback onCompletePlayback");
            if (!VideoPlayer.this.isFinishing()) {
                if (!h.isEmpty(VideoPlayer.this.P)) {
                    j.dIZ().a(VideoPlayer.this.P, 0);
                }
                VideoPlayer.this.K = false;
                if (VideoPlayer.this.nfH != null) {
                    VideoPlayer.this.nfH.removeMessages(1);
                }
                if ((VideoPlayer.this.nff == null || !VideoPlayer.this.nff.H) && VideoPlayer.this.nff != null && !VideoPlayer.this.d) {
                    VideoPlayer.this.nfH.removeMessages(7);
                    VideoPlayer.this.M = false;
                    VideoPlayer.this.nff.z();
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void dJw() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerACallback onVideoRenderingStart");
            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.nff != null) {
                VideoPlayer.this.nff.G();
            }
        }

        @Override // tv.chushou.common.player.b
        public void dJx() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerACallback onPreparedPlayback");
            if (!VideoPlayer.this.isFinishing()) {
                if (VideoPlayer.this.nff == null || !VideoPlayer.this.nff.H) {
                    VideoPlayer.this.nfH.removeMessages(6);
                    VideoPlayer.this.nfi = 0L;
                    VideoPlayer.this.O = 0;
                    if (VideoPlayer.this.nfb != null && VideoPlayer.this.nff != null) {
                        VideoPlayer.this.nfb.setVolume(VideoPlayer.this.nff.J, VideoPlayer.this.nff.J);
                    }
                    if (VideoPlayer.this.nfh != null) {
                        VideoPlayer.this.K = false;
                        FullRoomInfo dJF = VideoPlayer.this.dJh() ? null : VideoPlayer.this.nfh.dJF();
                        if (VideoPlayer.this.L || dJF != null) {
                            if (VideoPlayer.this.nfh.e) {
                                VideoPlayer.this.nfh.e = false;
                                VideoPlayer.this.nfh.d = !VideoPlayer.this.nfh.d;
                            }
                            if (VideoPlayer.this.nff != null) {
                                VideoPlayer.this.c("1", (String) null);
                                if (!VideoPlayer.this.d) {
                                    VideoPlayer.this.nff.i(true);
                                } else if (VideoPlayer.this.e) {
                                    VideoPlayer.this.e = false;
                                    VideoPlayer.this.nff.B();
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
                if (VideoPlayer.this.nfH != null) {
                    VideoPlayer.this.nfH.removeMessages(7);
                }
                if (VideoPlayer.this.nfH != null) {
                    VideoPlayer.this.nfH.removeMessages(1);
                }
                if ((VideoPlayer.this.nff == null || !VideoPlayer.this.nff.H) && !VideoPlayer.this.dJb()) {
                    if (!"10004".equals(VideoPlayer.this.t)) {
                        if (VideoPlayer.this.nff != null) {
                            if (VideoPlayer.this.d) {
                                VideoPlayer.this.nfc.stop();
                                VideoPlayer.this.nfc.release();
                                VideoPlayer.this.e = false;
                                VideoPlayer.this.nff.C();
                            }
                            if (!com.kascend.chushou.b.dIM().a && !com.kascend.chushou.b.dIM().b) {
                                VideoPlayer.this.nff.g(true);
                            } else if (VideoPlayer.this.d) {
                                VideoPlayer.this.nff.a(i, true);
                            } else {
                                VideoPlayer.this.nff.a(i, false);
                            }
                            VideoPlayer.this.c("2", (String) null);
                            return;
                        }
                        return;
                    }
                    dJv();
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void dJy() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerACallback onBufferingStart");
            if (!VideoPlayer.this.isFinishing()) {
                if ((VideoPlayer.this.nff == null || !VideoPlayer.this.nff.H) && VideoPlayer.this.nff != null && !VideoPlayer.this.d) {
                    VideoPlayer.this.nff.E();
                    VideoPlayer.this.M = true;
                    long currentTimeMillis = System.currentTimeMillis();
                    VideoPlayer.this.nfH.removeMessages(7);
                    if (!VideoPlayer.this.g) {
                        VideoPlayer.y(VideoPlayer.this);
                    }
                    tv.chushou.zues.utils.e.d(VideoPlayer.this.v, "currentTime: -- >" + currentTimeMillis + "  bufferTime-->" + VideoPlayer.this.nfi + "  bufferCount-->" + VideoPlayer.this.O);
                    if (currentTimeMillis - VideoPlayer.this.nfi >= 20000 || VideoPlayer.this.O < 2 || VideoPlayer.this.nff.H) {
                        if (VideoPlayer.this.O == 1) {
                            VideoPlayer.this.nfi = currentTimeMillis;
                        }
                        VideoPlayer.this.nfH.B(7, 5000L);
                    } else {
                        VideoPlayer.this.nfH.Lz(7);
                    }
                    if (VideoPlayer.this.g) {
                        VideoPlayer.this.g = false;
                    }
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void dJz() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerACallback onBufferingEnd");
            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.nff != null && !VideoPlayer.this.d) {
                VideoPlayer.this.nfH.removeMessages(7);
                VideoPlayer.this.M = false;
                if (VideoPlayer.this.nff == null || !VideoPlayer.this.nff.H) {
                    if (VideoPlayer.this.nfb == null) {
                        VideoPlayer.this.nff.a(false, true, false);
                    } else {
                        VideoPlayer.this.nff.a(true, VideoPlayer.this.nfb.getPlayState() == 4, VideoPlayer.this.nfb.getPlayState() == 5);
                    }
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void dJA() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerACallback onPlayerStart");
            if (!VideoPlayer.this.isFinishing()) {
                if (VideoPlayer.this.nff == null || !VideoPlayer.this.nff.H) {
                    if (VideoPlayer.this.nff != null && !VideoPlayer.this.d) {
                        if (VideoPlayer.this.nfb != null) {
                            VideoPlayer.this.nff.F();
                            VideoPlayer.this.nff.a(true, VideoPlayer.this.nfb.getPlayState() == 4, VideoPlayer.this.nfb.getPlayState() == 5);
                        } else {
                            VideoPlayer.this.nff.a(false, true, false);
                        }
                    }
                    if (VideoPlayer.this.nfH != null && !VideoPlayer.this.dJh()) {
                        VideoPlayer.this.nfH.removeMessages(1);
                        VideoPlayer.this.nfH.B(1, VideoPlayer.A);
                    }
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void dJB() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerACallback onPlayerPause");
            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.nfH != null) {
                VideoPlayer.this.nfH.removeMessages(1);
            }
        }

        @Override // tv.chushou.common.player.b
        public void dJC() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerACallback onPlayerStop");
            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.dJh() && VideoPlayer.this.nfc != null && !h.isEmpty(VideoPlayer.this.P) && VideoPlayer.this.nfc.getCurrentPos() > 0) {
                j.dIZ().a(VideoPlayer.this.P, VideoPlayer.this.nfc.getCurrentPos());
            }
        }
    };
    private tv.chushou.common.player.b nfL = new tv.chushou.common.player.b() { // from class: com.kascend.chushou.player.VideoPlayer.15
        @Override // tv.chushou.common.player.b
        public void dJu() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerBCallback onSetVideoViewLayout");
            if (!VideoPlayer.this.isFinishing()) {
                if ((VideoPlayer.this.nff == null || !VideoPlayer.this.nff.H) && VideoPlayer.this.nff != null && VideoPlayer.this.d) {
                    VideoPlayer.this.nff.y();
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void Kc(int i) {
            if (!VideoPlayer.this.isFinishing()) {
                if ((VideoPlayer.this.nff == null || !VideoPlayer.this.nff.H) && VideoPlayer.this.nff != null && VideoPlayer.this.d) {
                    VideoPlayer.this.nff.g(i);
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void dJv() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerBCallback onCompletePlayback");
            if (!VideoPlayer.this.isFinishing()) {
                if (!h.isEmpty(VideoPlayer.this.P)) {
                    j.dIZ().a(VideoPlayer.this.P, 0);
                }
                VideoPlayer.this.K = false;
                if (VideoPlayer.this.nfH != null) {
                    VideoPlayer.this.nfH.removeMessages(1);
                }
                if ((VideoPlayer.this.nff == null || !VideoPlayer.this.nff.H) && VideoPlayer.this.nff != null && VideoPlayer.this.d) {
                    VideoPlayer.this.nfH.removeMessages(7);
                    VideoPlayer.this.M = false;
                    VideoPlayer.this.nff.z();
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void dJw() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerBCallback onVideoRenderingStart");
            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.nff != null) {
                VideoPlayer.this.nff.G();
            }
        }

        @Override // tv.chushou.common.player.b
        public void dJx() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerBCallback onPreparedPlayback");
            if (!VideoPlayer.this.isFinishing()) {
                if (VideoPlayer.this.nff == null || !VideoPlayer.this.nff.H) {
                    VideoPlayer.this.nfH.removeMessages(6);
                    VideoPlayer.this.nfi = 0L;
                    VideoPlayer.this.O = 0;
                    if (VideoPlayer.this.nfb != null && VideoPlayer.this.nff != null) {
                        VideoPlayer.this.nfb.setVolume(VideoPlayer.this.nff.J, VideoPlayer.this.nff.J);
                    }
                    if (VideoPlayer.this.nfh != null) {
                        VideoPlayer.this.K = false;
                        FullRoomInfo dJF = VideoPlayer.this.dJh() ? null : VideoPlayer.this.nfh.dJF();
                        if (VideoPlayer.this.L || dJF != null) {
                            if (VideoPlayer.this.nfh.e) {
                                VideoPlayer.this.nfh.e = false;
                                VideoPlayer.this.nfh.d = !VideoPlayer.this.nfh.d;
                            }
                            if (VideoPlayer.this.nff != null) {
                                VideoPlayer.this.c("1", (String) null);
                                if (VideoPlayer.this.d) {
                                    VideoPlayer.this.nff.i(true);
                                } else if (VideoPlayer.this.e) {
                                    VideoPlayer.this.e = false;
                                    VideoPlayer.this.nff.B();
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
                if (VideoPlayer.this.nfH != null) {
                    VideoPlayer.this.nfH.removeMessages(7);
                }
                if (VideoPlayer.this.nfH != null) {
                    VideoPlayer.this.nfH.removeMessages(1);
                }
                if ((VideoPlayer.this.nff == null || !VideoPlayer.this.nff.H) && !VideoPlayer.this.dJb()) {
                    if (!"10004".equals(VideoPlayer.this.t)) {
                        if (VideoPlayer.this.nff != null) {
                            if (!VideoPlayer.this.d) {
                                VideoPlayer.this.nfd.stop();
                                VideoPlayer.this.nfd.release();
                                VideoPlayer.this.nff.C();
                                VideoPlayer.this.e = false;
                            }
                            if (!com.kascend.chushou.b.dIM().a && !com.kascend.chushou.b.dIM().b) {
                                VideoPlayer.this.nff.g(true);
                            } else if (VideoPlayer.this.d) {
                                VideoPlayer.this.nff.a(i, false);
                            } else {
                                VideoPlayer.this.nff.a(i, true);
                            }
                            VideoPlayer.this.c("2", (String) null);
                            return;
                        }
                        return;
                    }
                    dJv();
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void dJy() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerBCallback onBufferingStart");
            if (!VideoPlayer.this.isFinishing()) {
                if ((VideoPlayer.this.nff == null || !VideoPlayer.this.nff.H) && VideoPlayer.this.nff != null && VideoPlayer.this.d) {
                    VideoPlayer.this.nff.E();
                    VideoPlayer.this.M = true;
                    VideoPlayer.this.nfH.removeMessages(7);
                    long currentTimeMillis = System.currentTimeMillis();
                    if (!VideoPlayer.this.g) {
                        VideoPlayer.y(VideoPlayer.this);
                    }
                    tv.chushou.zues.utils.e.d(VideoPlayer.this.v, "currentTime: -- >" + currentTimeMillis + "  bufferTime-->" + VideoPlayer.this.nfi + "  bufferCount-->" + VideoPlayer.this.O);
                    if (currentTimeMillis - VideoPlayer.this.nfi >= 20000 || VideoPlayer.this.O < 2 || VideoPlayer.this.nff.H) {
                        if (VideoPlayer.this.O == 1) {
                            VideoPlayer.this.nfi = currentTimeMillis;
                        }
                        VideoPlayer.this.nfH.B(7, 5000L);
                    } else {
                        VideoPlayer.this.nfi = 0L;
                        VideoPlayer.this.O = 0;
                        VideoPlayer.this.nfH.Lz(7);
                    }
                    if (VideoPlayer.this.g) {
                        VideoPlayer.this.g = false;
                    }
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void dJz() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerBCallback onBufferingEnd");
            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.nff != null && VideoPlayer.this.d) {
                VideoPlayer.this.M = false;
                VideoPlayer.this.nfH.removeMessages(7);
                if (VideoPlayer.this.nff == null || !VideoPlayer.this.nff.H) {
                    if (VideoPlayer.this.nfb == null) {
                        VideoPlayer.this.nff.a(false, true, false);
                    } else {
                        VideoPlayer.this.nff.a(true, VideoPlayer.this.nfb.getPlayState() == 4, VideoPlayer.this.nfb.getPlayState() == 5);
                    }
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void dJA() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerBCallback onPlayerStart");
            if (!VideoPlayer.this.isFinishing()) {
                if (VideoPlayer.this.nff == null || !VideoPlayer.this.nff.H) {
                    if (VideoPlayer.this.nff != null && VideoPlayer.this.d) {
                        if (VideoPlayer.this.nfb != null) {
                            VideoPlayer.this.nff.F();
                            VideoPlayer.this.nff.a(true, VideoPlayer.this.nfb.getPlayState() == 4, VideoPlayer.this.nfb.getPlayState() == 5);
                        } else {
                            VideoPlayer.this.nff.a(false, true, false);
                        }
                    }
                    if (VideoPlayer.this.nfH != null && !VideoPlayer.this.dJh()) {
                        VideoPlayer.this.nfH.removeMessages(1);
                        VideoPlayer.this.nfH.B(1, VideoPlayer.A);
                    }
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void dJB() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerBCallback onPlayerPause");
            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.nfH != null) {
                VideoPlayer.this.nfH.removeMessages(1);
            }
        }

        @Override // tv.chushou.common.player.b
        public void dJC() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerBCallback onPlayerStop");
            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.dJh() && VideoPlayer.this.nfd != null && !h.isEmpty(VideoPlayer.this.P) && VideoPlayer.this.nfd.getCurrentPos() > 0) {
                j.dIZ().a(VideoPlayer.this.P, VideoPlayer.this.nfd.getCurrentPos());
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
        this.nfa = intent.getData();
        if (this.nfa == null) {
            finish();
            return;
        }
        com.kascend.chushou.d.e.j();
        if (this.nfG == null) {
            this.nfG = new CSTVWifiReceiver();
            registerReceiver(this.nfG, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        }
        com.kascend.chushou.toolkit.d.a.dLb().b();
        tv.chushou.zues.utils.e.i(this.v, "intent.getData=" + this.nfa.toString());
        String scheme = this.nfa.getScheme();
        if (scheme == null || !scheme.equals("chushou")) {
            tv.chushou.zues.utils.e.e(this.v, "not support scheme :" + scheme);
            finish();
            return;
        }
        a(intent);
    }

    private void a(Intent intent) {
        this.P = this.nfa.getQueryParameter("roomId");
        this.Q = this.P;
        this.S = this.nfa.getQueryParameter(WebSocketRequest.PARAM_KEY_PROTOCOLS);
        this.aq = this.nfa.getQueryParameter("liveType");
        if ("2".equals(this.aq) || "3".equals(this.aq) || "4".equals(this.aq)) {
            this.nfC = "2";
            this.nfD = new com.kascend.chushou.player.feedback.a();
            if (this.nfD.nnQ != null) {
                this.nfD.nnQ.reset();
                this.nfD.nnQ.roomId = this.P;
                this.nfD.nnQ.enterType = 1;
                this.nfD.b = System.currentTimeMillis();
            }
        }
        if (h.isEmpty(this.P) || h.isEmpty(this.S)) {
            tv.chushou.zues.utils.e.e(this.v, "invalid param mItemID=" + this.P + " protocols=" + this.S);
            finish();
            return;
        }
        if (com.kascend.chushou.b.dIM().d == -1) {
            com.kascend.chushou.b.dIM().d = com.kascend.chushou.d.g.b() ? 1 : 0;
        }
        this.nft = ((PowerManager) getSystemService("power")).newWakeLock(536870938, this.v);
        this.nft.acquire();
        this.nfh = new b(this.P);
        this.nfh.d = intent.getBooleanExtra("room_play_audio", false);
        this.nfl = new com.kascend.chushou.widget.a.b();
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
        this.nfn = (KPSwitchRootRelativeLayout) findViewById(a.f.rlRoot);
        if (!"2".equals(this.nfC) && com.kascend.chushou.b.dIM().d == 1) {
            this.nfn.setFitsSystemWindows(true);
        }
        this.nfo = (FrameLayout) this.nfn.findViewById(a.f.fl_fragment);
        this.bDj = this.nfn.findViewById(a.f.rl_empty);
        this.T = (ImageView) this.bDj.findViewById(a.f.iv_empty);
        this.U = (TextView) this.bDj.findViewById(a.f.tv_empty);
        this.nfp = (LinearLayout) this.nfn.findViewById(a.f.rl_title);
        this.Z = (ImageView) this.nfp.findViewById(a.f.back_icon);
        this.Z.setOnClickListener(new View.OnClickListener() { // from class: com.kascend.chushou.player.VideoPlayer.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayer.this.finish();
            }
        });
        this.nfk = (AnimationImageView) this.bDj.findViewById(a.f.iv_loading);
        this.nfu = (FrescoThumbnailView) this.nfn.findViewById(a.f.live_cover);
        this.nfv = (FrameLayout) this.nfn.findViewById(a.f.fl_cover);
        this.k = dJa();
        try {
            this.nfm = (AudioManager) getApplicationContext().getSystemService("audio");
            n = this.nfm.getStreamVolume(3);
            this.nfm.requestAudioFocus(null, 3, 1);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (this.B) {
            a(1, dJh() ? "3" : "1");
        } else {
            r();
        }
        if (com.kascend.chushou.b.dIM().b && !com.kascend.chushou.b.dIM().a) {
            RxExecutor.postDelayed(this.nfE, EventThread.MAIN_THREAD, 60L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.VideoPlayer.5
                @Override // java.lang.Runnable
                public void run() {
                    if (!VideoPlayer.this.isFinishing() && com.kascend.chushou.b.dIM().b && !com.kascend.chushou.b.dIM().a) {
                        tv.chushou.zues.utils.g.c(VideoPlayer.this.w, VideoPlayer.this.getString(a.i.str_monet_notify));
                    }
                }
            });
        }
        com.kascend.chushou.c.c.dIP().a(this.P, stringExtra, System.currentTimeMillis());
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
        if (this.nfF == null) {
            this.nfF = new a();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.media.VOLUME_CHANGED_ACTION");
            registerReceiver(this.nfF, intentFilter);
        }
    }

    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        j(false);
        if (this.nfF != null) {
            unregisterReceiver(this.nfF);
            this.nfF = null;
        }
        super.onStop();
    }

    @Override // com.kascend.chushou.view.base.BaseActivity
    protected void a(boolean z) {
        if (this.nff != null) {
            this.nff.k(z);
        }
    }

    @Subscribe
    public void onHideGiftEffectEvent(com.kascend.chushou.b.a.a.f fVar) {
        if (fVar.b) {
            this.nff.k();
            return;
        }
        this.nff.m();
        this.nff.l();
    }

    private float dJa() {
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
            this.nfh.h = jSONObject.toString();
            String optString = jSONObject.optString("_thumb");
            jSONObject.optBoolean("tag_from_game_mic", false);
            if (!h.isEmpty(optString)) {
                this.ab = optString;
            }
        } catch (JSONException e) {
            e.printStackTrace();
            this.nfh.h = str;
        }
        if (dJh()) {
            a(this.P, str);
            ba(this.P, z);
            return;
        }
        a = this.P;
        b(this.P, str);
        a(this.P, dJr(), z);
        w();
    }

    private void O() {
        this.m = true;
        j();
        if (this.nff != null) {
            this.nff.r();
        }
        s();
    }

    @Subscribe
    public void onStartRoomEvent(o oVar) {
        if (!isFinishing() && oVar.neI != null && oVar.c != null && !h.isEmpty(oVar.neI.mTargetKey)) {
            if (oVar.c != this) {
                tv.chushou.zues.utils.e.e(this.v, "different player!");
                return;
            }
            if (this.nfh != null) {
                this.nfh.a();
                this.nfh.a = oVar.neI.mTargetKey;
                this.nfh.d = oVar.d;
                if (this.nfh.ngG != null) {
                    this.nfh.ngG.e();
                }
                if (this.nfh.ngG != null) {
                    this.nfh.ngG.b();
                }
                this.nfh.ngK = null;
                this.nfh.ngJ = null;
                this.nfh.ngN = null;
                this.nfh.ngM = null;
                this.nfh.ngQ = null;
                this.nfh.ngO = null;
                this.nfh.ngP = null;
            }
            if (this.nfm != null) {
                n = this.nfm.getStreamVolume(3);
            }
            if (!h.isEmpty(oVar.neI.mType) && oVar.neI.mType.equals("3")) {
                this.B = false;
                this.nfC = "1";
                r();
                this.P = oVar.neI.mTargetKey;
                this.R = "3";
                if (this.nfl != null) {
                    this.nfl.a();
                }
                if (this.nfh != null) {
                    this.nfh.a((PlayUrl) null);
                    this.nfh.f();
                    if (this.nfh.c() != null) {
                        this.nfh.c().clear();
                    }
                    this.nfh.i.clear();
                }
                if (this.nff != null) {
                    this.nff.j();
                }
                s();
                if (this.nfq != null) {
                    this.nfq.d();
                    this.nfq = null;
                }
                if (this.nfE != null) {
                    this.nfE.dispose();
                    this.nfE = new io.reactivex.disposables.a();
                }
                a(oVar.e, false);
                return;
            }
            boolean z = this.R != null && this.R.equals("1");
            this.R = "1";
            this.nfz.a();
            this.nfy.a();
            this.nfx.a();
            this.nfw.c();
            this.nfB.a();
            if (this.nfE != null) {
                this.nfE.dispose();
                this.nfE = new io.reactivex.disposables.a();
            }
            if ("1".equals(oVar.f)) {
                this.H = false;
                if (this.nfh != null && !h.isEmpty(this.nfh.t)) {
                    this.nfh.t.clear();
                }
                this.ab = oVar.neI.mCover;
                this.nfv.setVisibility(0);
                this.nfu.setBlur(true);
                this.nfu.i(oVar.neI.mCover, 0, 0, 0);
            }
            if (!oVar.neI.mTargetKey.equals(this.P)) {
                this.aq = oVar.g;
                if (!z) {
                    this.B = false;
                    r();
                } else if (!"2".equals(this.nfC) && ("2".equals(this.aq) || "3".equals(this.aq) || "4".equals(this.aq))) {
                    this.nfC = "2";
                    this.nfD = new com.kascend.chushou.player.feedback.a();
                    if (this.nfD.nnQ != null) {
                        this.nfD.nnQ.reset();
                        this.nfD.nnQ.roomId = oVar.neI.mTargetKey;
                        this.nfD.nnQ.enterType = 1;
                        this.nfD.b = System.currentTimeMillis();
                    }
                }
                this.B = false;
                this.P = oVar.neI.mTargetKey;
                this.Q = this.P;
                this.ab = oVar.neI.mCover;
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
                JSONObject P = com.kascend.chushou.d.e.P("_fromView", str, "_sc", oVar.neI.mSC);
                com.kascend.chushou.toolkit.a.c.a(this.w, P);
                if (this.nfl != null) {
                    this.nfl.a();
                    this.nfl.a(this.P);
                }
                if (this.nfh != null) {
                    this.nfh.a((PlayUrl) null);
                    this.nfh.f();
                    if (this.nfh.c() != null) {
                        this.nfh.c().clear();
                    }
                    this.nfh.i.clear();
                }
                if (this.nff != null) {
                    this.nff.j();
                }
                a(P.toString(), false);
                return;
            }
            tv.chushou.zues.utils.g.LI(a.i.str_same_room);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dJb() {
        FullRoomInfo dJF;
        String str;
        RoomInfo roomInfo;
        if (dJh()) {
            str = null;
            dJF = null;
        } else {
            dJF = this.nfh.dJF();
            str = (dJF == null || (roomInfo = dJF.mRoominfo) == null) ? null : roomInfo.mGameId;
        }
        return !this.L && (dJF == null || h.isEmpty(str));
    }

    @Subscribe
    public void onMessageEvent(i iVar) {
        if (!isFinishing() && iVar.a != 21 && iVar.a != 22) {
            if (iVar.a == 0 && (iVar.b instanceof Boolean)) {
                if (((Boolean) iVar.b).booleanValue() && !isFinishing()) {
                    w();
                    if (this.nff != null) {
                        this.nff.f();
                    }
                }
            } else if (iVar.a == 46) {
                if ((iVar.b instanceof String) && this.nff != null) {
                    this.nff.c((String) iVar.b);
                }
            } else if (iVar.a == 54) {
                if (iVar.b instanceof String) {
                    this.nfx.a((String) iVar.b);
                }
            } else if (iVar.a == 55) {
                if (this.nff != null) {
                    this.nff.O();
                }
            } else if (iVar.a == 56 && this.nff != null) {
                this.nff.P();
            }
        }
    }

    @Subscribe
    public void onRefreshSubscribeEvent(m mVar) {
        if (isFinishing() && this.nfh != null && this.nfh.dJI() != null) {
            RoomInfo dJI = this.nfh.dJI();
            if (mVar.a(dJI.mCreatorUID, dJI.mRoomID)) {
                dJI.mIsSubscribed = mVar.c;
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
        if (this.m || this.nfc == null || this.nfd == null) {
            R();
        }
        if (this.nfl != null) {
            this.nfl.d();
        }
        if (!dJh()) {
            if (this.nfq != null && !this.nfq.c()) {
                this.nfq.a();
            }
            v();
            if (this.nfh != null && this.nfh.dJF() != null && this.nfh.dJF().cycleLiveRoomInfo != null && !h.isEmpty(this.nfh.dJF().cycleLiveRoomInfo.roomId)) {
                u();
            }
        }
        super.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.view.base.BaseActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        tv.chushou.zues.utils.e.e(this.v, MissionEvent.MESSAGE_DESTROY);
        if (this.nfh != null && this.nfh.dJF() != null && this.nfh.dJF().cycleLiveRoomInfo != null && !h.isEmpty(this.nfh.dJF().cycleLiveRoomInfo.eventName)) {
            j.dIZ().a(this.P + dJr());
        }
        if ("2".equals(this.nfC) && this.nfD != null && this.nfD.nnQ != null) {
            this.nfD.nnQ.time = System.currentTimeMillis() - this.nfD.b;
            this.nfD.a();
            this.nfD.b();
        }
        this.nfw.d();
        this.nfx.b();
        this.nfy.b();
        O();
        this.ag = null;
        a = null;
        if (this.nfH != null) {
            this.nfH.ch(null);
            this.nfH = null;
        }
        if (this.nfq != null) {
            this.nfq.d();
            this.nfq = null;
        }
        if (this.nfl != null) {
            this.nfl.c();
            this.nfl = null;
        }
        if (this.nfh != null) {
            this.nfh.ngK = null;
            this.nfh.ngJ = null;
        }
        if (this.nfh != null) {
            this.nfh.b();
            this.nfh = null;
        }
        this.nfa = null;
        this.nff = null;
        this.nfg = null;
        this.nfj = null;
        this.T = null;
        this.U = null;
        this.nfk = null;
        this.bDj = null;
        this.nfm = null;
        this.nfn = null;
        this.nfo = null;
        this.Z = null;
        this.nfp = null;
        if (this.nft != null && this.nft.isHeld()) {
            this.nft.release();
            this.nft = null;
        }
        if (this.nfG != null) {
            unregisterReceiver(this.nfG);
            this.nfG = null;
        }
        h.dWN();
        tv.chushou.zues.a.a.ci(this);
        this.nfE.dispose();
        this.nfy.b();
        this.nfz.b();
        this.nfw.d();
        this.nfx.b();
        this.nfB.b();
        super.onDestroy();
        System.gc();
    }

    @Subscribe
    public void onSendGameGiftEvent(n nVar) {
        if (!isFinishing() && this.nff != null) {
            this.nff.a(nVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.view.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        tv.chushou.zues.utils.e.d(this.v, MissionEvent.MESSAGE_PAUSE);
        if (this.nfq != null) {
            this.nfq.b();
        }
        if (this.nfl != null) {
            this.nfl.b(false);
        }
        k();
        this.m = true;
        super.onPause();
    }

    @Override // android.app.Activity
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.nff != null ? this.nff.a(motionEvent) : super.onTouchEvent(motionEvent);
    }

    public void c() {
        if ("1".equals(this.R)) {
            j.dIZ().a(this.P + dJr());
        } else {
            j.dIZ().b(this.P);
        }
    }

    private void a(boolean z, boolean z2) {
        int i = 0;
        tv.chushou.zues.utils.e.i(this.v, "startLoadingVideo <------------- mbPrepareingVideo = " + this.K);
        if (this.nfc != null) {
            this.nfc.setHardwearDecod(com.kascend.chushou.d.h.dIT().a);
        }
        if (this.nfd != null) {
            this.nfd.setHardwearDecod(com.kascend.chushou.d.h.dIT().a);
        }
        if (this.nfb != null) {
            this.nfb.setHardwearDecod(com.kascend.chushou.d.h.dIT().a);
        }
        if (!this.K) {
            if (z && this.nff != null) {
                if (!z2) {
                    this.t = null;
                    this.nff.e();
                }
            } else if (this.nff != null && !z2) {
                this.t = null;
                this.nff.H = false;
                RxExecutor.post(null, EventThread.MAIN_THREAD, new Runnable() { // from class: com.kascend.chushou.player.VideoPlayer.7
                    @Override // java.lang.Runnable
                    public void run() {
                        VideoPlayer.this.nff.x();
                    }
                });
            }
            this.K = true;
            if (this.nfh != null && this.nfh.dJG() != null) {
                PlayUrl dJG = this.nfh.dJG();
                while (true) {
                    int i2 = i;
                    if (i2 >= dJG.mUrlDetails.size()) {
                        break;
                    }
                    UrlDetails urlDetails = dJG.mUrlDetails.get(i2);
                    if (urlDetails.mUrl.equals(dJG.mSelectedUrl)) {
                        String str = dJG.mUrlDetails.get(i2).mDefinitionType;
                        String str2 = urlDetails.mBitrate;
                    }
                    i = i2 + 1;
                }
            }
            if (z2) {
                if (this.d) {
                    this.nfc.setVideoURI(this.nfa);
                    this.nfc.open();
                    return;
                }
                this.nfd.setVideoURI(this.nfa);
                this.nfd.open();
                return;
            }
            this.nfb.setVideoURI(this.nfa);
            this.nfb.open();
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        try {
            if (motionEvent.getAction() == 0) {
                if (this.nff != null && this.nff.b(motionEvent)) {
                    return true;
                }
                if ("2".equals(this.nfC) && this.nff != null) {
                    this.nff.a(motionEvent);
                }
            } else if (this.nff != null && this.nff.b(motionEvent)) {
                return true;
            }
            return super.dispatchTouchEvent(motionEvent);
        } catch (Exception e) {
            return false;
        }
    }

    @Override // android.support.v7.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.nff != null && this.nff.a(i, keyEvent)) {
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
        if (this.nfh != null && this.nfh.dJF() != null && this.nfh.dJF().cycleLiveRoomInfo != null && !h.isEmpty(this.nfh.dJF().cycleLiveRoomInfo.roomId)) {
            this.nfv.setVisibility(0);
            this.nfu.setBlur(true);
            this.nfu.i(this.nfh.dJF().cycleLiveRoomInfo.avatar, 0, 0, 0);
            this.nfu.setVisibility(0);
            j.dIZ().a(this.P + dJr());
            this.nfa = null;
            R();
            this.Q = this.nfh.dJF().cycleLiveRoomInfo.roomId;
            a(this.P, dJr(), false);
        }
    }

    public void b(boolean z) {
        if (this.nff != null) {
            this.nff.j(z);
        }
    }

    public void a(boolean z, Uri uri, boolean z2) {
        tv.chushou.zues.utils.e.d(this.v, "loadIfNecessary reload=" + z + " isChangeLines-->" + z2);
        if (this.nfc != null && this.nfd != null) {
            if (uri != null) {
                this.nfa = uri;
            }
            if (z2) {
                this.e = z2;
            }
            this.M = false;
            this.nfi = 0L;
            this.O = 0;
            this.nfH.removeMessages(7);
            if (z) {
                if (z2) {
                    if (!this.d) {
                        this.nfd.setOnActivityCallBack(this.nfL);
                    } else {
                        this.nfc.setOnActivityCallBack(this.nfK);
                    }
                } else if (this.d) {
                    this.nfd.setOnActivityCallBack(this.nfL);
                } else {
                    this.nfc.setOnActivityCallBack(this.nfK);
                }
                this.K = false;
                b(true, z2);
            } else if (!this.J) {
                b(true, z2);
            }
            this.nfH.B(6, 3000L);
        }
    }

    private void b(boolean z, boolean z2) {
        VideoPlayInfo M;
        if ("1".equals(this.R)) {
            M = j.dIZ().L(this.P + dJr(), 600000L);
        } else {
            M = j.dIZ().M(this.P, 600000L);
        }
        if (M != null) {
            a(z, z2);
        } else if ("1".equals(this.R)) {
            a(this.P, dJr(), false);
        } else {
            ba(this.P, false);
        }
    }

    public tv.chushou.common.player.a dJc() {
        return this.nfb;
    }

    public tv.chushou.common.player.a dJd() {
        return this.nfc;
    }

    public tv.chushou.common.player.a dJe() {
        return this.nfd;
    }

    public void a(tv.chushou.common.player.a aVar) {
        this.nfb = aVar;
    }

    public b dJf() {
        return this.nfh;
    }

    public com.kascend.chushou.widget.a.b dJg() {
        return this.nfl;
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
        FullRoomInfo dJF;
        this.r = -1L;
        if (this.s != -1 && this.s != 0) {
            this.r = this.s;
            this.s = -1L;
        }
        if (dJh() && this.nfb != null && this.nfb.getPlayState() == 4) {
            this.r = this.nfb.getCurrentPos();
        }
        this.nfI = false;
        tv.chushou.zues.utils.e.d(this.v, "screenChange()<-----");
        tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard(this);
        if (str != null) {
            this.R = str;
        }
        if (!this.C || !z3 || "3".equals(this.R) || this.nfh == null || (dJF = this.nfh.dJF()) == null || dJF.mRoominfo == null || dJF.mRoominfo.mStyle != 1) {
            z5 = false;
        } else {
            z5 = true;
            i = 0;
        }
        if ("2".equals(this.nfC)) {
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
            if (com.kascend.chushou.b.dIM().d == 1) {
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
        if (this.nfl == null) {
            this.nfl = new com.kascend.chushou.widget.a.b();
        }
        if (this.nfl != null) {
            this.nfl.a(this.P);
        }
        if (this.R.equals("5")) {
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            if (this.nff != null) {
                beginTransaction.remove(this.nff);
                this.nff = null;
            }
            if (this.nfg != null) {
                beginTransaction.remove(this.nfg);
                this.nfg = null;
            }
            this.nfg = new com.kascend.chushou.view.user.b();
            beginTransaction.add(a.f.fl_fragment, this.nfg);
            beginTransaction.commitAllowingStateLoss();
        } else {
            FragmentTransaction beginTransaction2 = getSupportFragmentManager().beginTransaction();
            if (this.nff != null) {
                beginTransaction2.remove(this.nff);
                this.nff = null;
            }
            if (this.nfg != null) {
                beginTransaction2.remove(this.nfg);
                this.nfg = null;
            }
            if ("2".equals(this.nfC)) {
                this.nff = com.kascend.chushou.player.e.e.b(this.ab, z2, this.aq, this.P);
            } else if (1 == i) {
                if (!this.R.equals("3")) {
                    if (z4) {
                        v();
                    }
                    this.nff = new com.kascend.chushou.player.d.a();
                    Bundle bundle = new Bundle();
                    bundle.putString("mCover", this.ab);
                    bundle.putBoolean("mInitViewAsync", z2);
                    this.nff.setArguments(bundle);
                }
            } else {
                this.nff = new com.kascend.chushou.player.d.b();
                Bundle bundle2 = new Bundle();
                if (z5) {
                    i = 1;
                }
                bundle2.putInt("mExtraOrientation", i);
                bundle2.putString("mViewType", this.R);
                this.nff.setArguments(bundle2);
            }
            beginTransaction2.add(a.f.fl_fragment, this.nff);
            beginTransaction2.commitAllowingStateLoss();
            this.H = true;
        }
        tv.chushou.zues.utils.e.d(this.v, "screenChange()----->");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dJh() {
        return this.R != null && this.R.equals("3");
    }

    private void R() {
        if (this.nff != null) {
            this.nff.nke = null;
        }
        if (this.nfb != null) {
            this.nfb.release();
            this.nfb = null;
            this.K = false;
        }
        if (this.nfc != null) {
            this.nfc.release();
            this.nfc = null;
        }
        if (this.nfd != null) {
            this.nfd.release();
            this.nfd = null;
        }
        if (this.nfe != null) {
            this.nfe.c();
        }
        this.d = false;
        this.e = false;
        this.M = false;
        this.nfe = new c();
        this.nfc = this.nfe.dJL();
        this.nfc.setOnActivityCallBack(this.nfK);
        this.nfd = this.nfe.dJM();
        this.nfd.setOnActivityCallBack(this.nfL);
        if (!this.d) {
            this.nfb = this.nfc;
        } else {
            this.nfb = this.nfd;
        }
        if (this.nff != null) {
            this.nff.nke = this.nfb;
        }
    }

    public void j() {
        if (this.nfb != null) {
            this.nfb.pause();
            this.nfb.stop();
            this.nfb.release();
            this.nfb = null;
        }
        if (this.nfc != null) {
            this.nfc.stop();
            this.nfc.release();
            this.nfc = null;
        }
        if (this.nfd != null) {
            this.nfd.stop();
            this.nfd.release();
            this.nfd = null;
        }
        if (this.nfe != null) {
            this.nfe.c();
        }
    }

    public void k() {
        tv.chushou.common.player.a aVar = this.nfb;
        if (aVar != null) {
            aVar.pause();
            aVar.stop();
        }
        tv.chushou.common.player.a aVar2 = this.nfc;
        if (aVar2 != null) {
            aVar2.stop();
        }
        tv.chushou.common.player.a aVar3 = this.nfd;
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
        if (this.nfI) {
            if (this.nff != null) {
                this.nff.s();
            }
        } else if (this.nfH != null) {
            this.nfH.b(this.nfH.LB(3), 20L);
        }
    }

    private void b(final String str, String str2) {
        com.kascend.chushou.c.c.dIP().a(new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.VideoPlayer.8
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
                    VideoPlayer.this.dJp().a(fullRoomInfo.mBangMap);
                    if (h.isEmpty(fullRoomInfo.mRoominfo.mRoomID)) {
                        fullRoomInfo.mRoominfo.mRoomID = VideoPlayer.this.P;
                    }
                    if (!h.isEmpty(fullRoomInfo.mGeneralTabGifts)) {
                        com.kascend.chushou.d.e.a(VideoPlayer.this.nfE, new ArrayList(fullRoomInfo.mGeneralTabGifts));
                    }
                    if (VideoPlayer.this.nfh != null) {
                        VideoPlayer.this.nfh.a(fullRoomInfo);
                    }
                    VideoPlayer.this.L = false;
                    if (VideoPlayer.this.B) {
                        if (VideoPlayer.this.C && !"3".equals(VideoPlayer.this.R) && fullRoomInfo != null && fullRoomInfo.mRoominfo != null && fullRoomInfo.mRoominfo.mStyle == 1 && !h.isEmpty(fullRoomInfo.mRoominfo.mGameId)) {
                            z = true;
                        }
                        if (!z) {
                            if (VideoPlayer.this.nff != null) {
                                VideoPlayer.this.nff.a(VideoPlayer.this.nfh);
                            }
                            if (!h.isEmpty(fullRoomInfo.mRoominfo.mGameId)) {
                                VideoPlayer.this.S();
                            } else {
                                if (VideoPlayer.this.nfh != null) {
                                    VideoPlayer.this.nfh.f = null;
                                }
                                VideoPlayer.this.S();
                            }
                        } else {
                            VideoPlayer.this.a(1, "1", true);
                            if (VideoPlayer.this.nff != null) {
                                VideoPlayer.this.nff.a(VideoPlayer.this.nfh);
                            }
                        }
                    } else {
                        if (h.isEmpty(fullRoomInfo.mRoominfo.mGameId)) {
                            if (VideoPlayer.this.nfh != null) {
                                VideoPlayer.this.nfh.f = null;
                            }
                            VideoPlayer.this.a(1, "1");
                        } else {
                            VideoPlayer.this.a(1, "1", true);
                        }
                        if (VideoPlayer.this.nff != null) {
                            VideoPlayer.this.nff.a(VideoPlayer.this.nfh);
                        }
                    }
                    if (VideoPlayer.this.nfh != null && !VideoPlayer.this.nfh.m()) {
                        if (VideoPlayer.this.nfq != null) {
                            VideoPlayer.this.nfq.d();
                            VideoPlayer.this.nfq = null;
                        }
                        VideoPlayer.this.nfq = new com.kascend.chushou.toolkit.d(900000L, VideoPlayer.this.nfs, VideoPlayer.this.nfH);
                        VideoPlayer.this.nfq.a();
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
        if (this.nfh != null) {
            this.nfh.a((FullRoomInfo) null);
        }
        this.L = false;
        c(str, i);
        if (this.nfb != null) {
            this.nfb.stop();
        }
        if (this.nfc != null) {
            this.nfc.stop();
        }
        if (this.nfd != null) {
            this.nfd.stop();
        }
    }

    public void l() {
        tv.chushou.zues.utils.e.d(this.v, "retryGetPlayList");
        c();
        if (dJh()) {
            ba(this.P, false);
        } else {
            a(this.P, dJr(), false);
        }
    }

    public void m() {
        a(this.ag, false);
    }

    private void a(final String str, String str2, boolean z) {
        this.J = true;
        VideoPlayInfo L = j.dIZ().L(str + str2, 600000L);
        if (L != null) {
            a((ArrayList) L.mPlayUrls);
            this.J = false;
        } else if (z) {
            ParserRet fV = com.kascend.chushou.player.c.a.dJN().fV(str, str2);
            if (fV.mRc != 0) {
                tv.chushou.zues.utils.e.e(this.v, "getPlayUrlSync fail, try to getPlaylist");
                a(str, str2, false);
                return;
            }
            a(fV, str);
        } else {
            com.kascend.chushou.player.c.a.dJN().a(str, str2, new a.InterfaceC0820a() { // from class: com.kascend.chushou.player.VideoPlayer.9
                @Override // com.kascend.chushou.player.c.a.InterfaceC0820a
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
        VideoPlayInfo M = j.dIZ().M(str, 600000L);
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
                ParserRet bb = com.kascend.chushou.player.c.a.dJN().bb(str, equals);
                if (bb.mRc != 0) {
                    tv.chushou.zues.utils.e.e(this.v, "getVideoPlayUrlSync fail, try to getVideoPlaylist");
                    ba(str, false);
                    return;
                }
                a(bb, str);
                return;
            }
            com.kascend.chushou.player.c.a.dJN().a(str, new a.InterfaceC0820a() { // from class: com.kascend.chushou.player.VideoPlayer.10
                @Override // com.kascend.chushou.player.c.a.InterfaceC0820a
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
                if (this.nfh.f == null) {
                    this.nfh.f = new ArrayList<>();
                }
                this.nfh.f.clear();
                this.nfh.f.addAll(arrayList);
                if ("1".equals(this.R)) {
                    j.dIZ().a(str + dJr(), arrayList);
                } else {
                    j.dIZ().t(str, arrayList);
                }
                a(arrayList);
                return;
            }
            if (this.nfh != null) {
                this.nfh.f = null;
            }
            if (this.nfH != null) {
                Message LB = this.nfH.LB(5);
                LB.arg1 = 2;
                LB.arg2 = parserRet.mRc;
                this.nfH.R(LB);
            }
        }
    }

    private void c(String str, int i) {
        s();
        if (this.nfl != null) {
            this.nfl.a();
        }
        if (h.isEmpty(str)) {
            str = getString(a.i.str_load_data_failed);
        }
        a(str, i);
    }

    public void n() {
        if (this.nfo != null && this.bDj != null && this.nfp != null) {
            this.nfo.setVisibility(0);
            this.bDj.setVisibility(8);
            this.nfp.setVisibility(8);
        }
    }

    public void o() {
        if (this.nfu != null && this.nfu.getVisibility() == 0) {
            this.nfu.zs(0);
            this.nfu.setVisibility(8);
        }
    }

    public void p() {
        if (this.nfv != null && this.nfv.getVisibility() == 0) {
            this.nfv.setVisibility(8);
        }
    }

    public void q() {
        this.nfI = true;
    }

    protected void r() {
        this.nfo.setVisibility(8);
        this.nfp.setVisibility(0);
        this.bDj.setVisibility(0);
        if (this.nfk != null) {
            this.T.setVisibility(8);
            this.nfk.setVisibility(0);
            this.U.setText(getString(a.i.str_dialog_loading_content));
            this.U.setVisibility(8);
        }
    }

    protected void a(String str, int i) {
        this.nfo.setVisibility(8);
        this.nfp.setVisibility(0);
        this.bDj.setVisibility(0);
        if (this.nfk != null) {
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
                            com.kascend.chushou.c.c.dIP().b(new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.VideoPlayer.11.1
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
                            }, VideoPlayer.this.P, (String) null, VideoPlayer.this.nfh.h);
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
            this.nfk.setVisibility(8);
            this.nfv.setVisibility(8);
        }
    }

    public void s() {
        if (this.nfH != null) {
            this.nfH.removeMessages(1);
        }
    }

    private void a(ArrayList<PlayUrl> arrayList) {
        boolean z;
        if (this.nfh.f == null) {
            this.nfh.f = new ArrayList<>();
        }
        this.nfh.f.clear();
        this.nfh.f.addAll(arrayList);
        if (com.kascend.chushou.d.e.b() && !"4".equals(this.aq)) {
            int c = com.kascend.chushou.d.e.c();
            if (c == -1) {
                b(arrayList);
                return;
            } else if (this.aw) {
                this.aw = false;
                if (c == 0) {
                    this.nfh.d = false;
                    f(arrayList, true);
                    return;
                }
                if (this.nfh != null && this.nfh.f != null) {
                    Iterator<PlayUrl> it = this.nfh.f.iterator();
                    while (it.hasNext()) {
                        if ("2".equals(it.next().mType)) {
                            z = true;
                            break;
                        }
                    }
                }
                z = false;
                this.nfh.d = z;
                f(arrayList, true);
                return;
            } else {
                if (this.nfh.e) {
                    this.nfh.d = !this.nfh.d;
                    this.nfh.e = false;
                    this.nfJ = true;
                } else if ("4".equals(this.aq)) {
                    this.nfh.d = true;
                }
                f(arrayList, true);
                return;
            }
        }
        if (this.nfh.e) {
            this.nfh.d = !this.nfh.d;
            this.nfh.e = false;
            this.nfJ = true;
        } else if ("4".equals(this.aq)) {
            this.nfh.d = true;
        }
        f(arrayList, true);
    }

    private void b(ArrayList<PlayUrl> arrayList) {
        if ("1".equals(this.R)) {
            if ("2".equals(this.nfC)) {
                d(false, arrayList);
            } else if (this.nff != null) {
                this.nff.f(arrayList, false);
            }
        } else if (this.nff != null) {
            this.nff.f(arrayList, false);
        }
    }

    public void c(boolean z) {
        this.nfh.d = false;
        com.kascend.chushou.d.e.a(0);
        ArrayList<PlayUrl> arrayList = this.nfh.f;
        if (!h.isEmpty(arrayList)) {
            if (z) {
                f(arrayList, false);
                if (this.nfH != null) {
                    this.nfH.Lz(2);
                    return;
                }
                return;
            }
            f(arrayList, true);
        }
    }

    public void d(boolean z) {
        this.nfh.d = true;
        com.kascend.chushou.d.e.a(1);
        ArrayList<PlayUrl> arrayList = this.nfh.f;
        if (!h.isEmpty(arrayList)) {
            if (z) {
                f(arrayList, false);
                if (this.nfH != null) {
                    this.nfH.Lz(2);
                    return;
                }
                return;
            }
            f(arrayList, true);
        }
    }

    @Subscribe
    public void onNotifyEvent(com.kascend.chushou.b.a.a.j jVar) {
        if (!isFinishing() && jVar.a == 1 && !"5".equals(this.R) && !dJb()) {
            tv.chushou.zues.utils.e.d(this.v, "onNetworkChangeEvent 3G=" + com.kascend.chushou.b.dIM().b + "  wifi=" + com.kascend.chushou.b.dIM().a);
            if (com.kascend.chushou.d.e.b() && !"4".equals(this.aq)) {
                if (com.kascend.chushou.d.e.c() == -1) {
                    if (this.nff != null) {
                        this.nff.e(false);
                    }
                    if ("1".equals(this.R)) {
                        if ("2".equals(this.nfC)) {
                            d(true, null);
                            return;
                        } else if (this.nff != null) {
                            this.nff.f(this.nfh.f, true);
                            return;
                        } else {
                            return;
                        }
                    } else if (this.nff != null) {
                        this.nff.f(this.nfh.f, true);
                        return;
                    } else {
                        return;
                    }
                }
                RxExecutor.postDelayed(this.nfE, EventThread.MAIN_THREAD, 10L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.VideoPlayer.12
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!VideoPlayer.this.isFinishing() && com.kascend.chushou.b.dIM().b && !com.kascend.chushou.b.dIM().a) {
                            tv.chushou.zues.utils.g.c(VideoPlayer.this.w, VideoPlayer.this.getString(a.i.str_monet_notify));
                        }
                    }
                });
            } else if (com.kascend.chushou.b.dIM().a || com.kascend.chushou.b.dIM().b) {
                t();
                if (this.nfH != null) {
                    this.nfH.Lz(2);
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
            if (this.nfh.d) {
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
            String d = com.kascend.chushou.d.h.dIT().d();
            String str3 = h.isEmpty(d) ? "2" : d;
            if (this.nfh.d) {
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
                if (this.nfh != null) {
                    this.nfh.a(playUrl2);
                    if (this.nfH != null) {
                        Message LB = this.nfH.LB(5);
                        LB.arg1 = 1;
                        this.nfH.R(LB);
                    }
                }
                String b = com.kascend.chushou.player.c.a.b(playUrl2);
                if (!h.isEmpty(b)) {
                    this.nfa = Uri.parse(b);
                    if (this.nfJ) {
                        this.nfJ = false;
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (z && this.nfb != null) {
                        a(false, z2);
                    }
                }
            }
        }
    }

    public void d(final boolean z, ArrayList<PlayUrl> arrayList) {
        if (this.nfr == null || this.nfr.a <= 0) {
            this.nfr = com.kascend.chushou.view.b.a.a.dLc();
            this.nfr.a(new a.InterfaceC0839a() { // from class: com.kascend.chushou.player.VideoPlayer.13
                @Override // com.kascend.chushou.view.b.a.a.InterfaceC0839a
                public void a(int i) {
                    if (i == a.f.tv_play_video) {
                        VideoPlayer.this.nfr.dismissAllowingStateLoss();
                        VideoPlayer.this.c(z);
                    } else if (i == a.f.tv_play_audio) {
                        VideoPlayer.this.nfr.dismissAllowingStateLoss();
                        VideoPlayer.this.d(z);
                    } else if (i == a.f.iv_close) {
                        VideoPlayer.this.finish();
                    } else {
                        if (i == a.f.tv_union_proxy) {
                        }
                    }
                }
            });
            this.nfr.show(getSupportFragmentManager(), "showRoom");
        }
    }

    public void t() {
        if (this.nfr != null) {
            this.nfr.dismissAllowingStateLoss();
        }
        if (this.nff != null) {
            this.nff.v();
        }
    }

    public void u() {
        com.kascend.chushou.c.c.dIP().c(this.P, new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.VideoPlayer.16
            @Override // com.kascend.chushou.c.b
            public void a() {
            }

            @Override // com.kascend.chushou.c.b
            public void a(String str, JSONObject jSONObject) {
                if (!VideoPlayer.this.isFinishing()) {
                    ParserRet dU = com.kascend.chushou.c.e.dU(jSONObject);
                    if (dU.mRc == 0 && dU.mData != null) {
                        CycleLiveRoomInfo cycleLiveRoomInfo = (CycleLiveRoomInfo) dU.mData;
                        if (VideoPlayer.this.nfh != null && cycleLiveRoomInfo != null && !h.isEmpty(cycleLiveRoomInfo.roomId)) {
                            FullRoomInfo dJF = VideoPlayer.this.nfh.dJF();
                            if (dJF.cycleLiveRoomInfo == null) {
                                dJF.cycleLiveRoomInfo = cycleLiveRoomInfo;
                                VideoPlayer.this.d();
                            } else if (dJF.cycleLiveRoomInfo != null && !cycleLiveRoomInfo.roomId.equals(dJF.cycleLiveRoomInfo.roomId)) {
                                dJF.cycleLiveRoomInfo.copyCycleLiveRoomInfo(cycleLiveRoomInfo);
                                VideoPlayer.this.d();
                            } else {
                                dJF.cycleLiveRoomInfo.copyCycleLiveRoomInfo(cycleLiveRoomInfo);
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
        if (this.nff != null) {
            this.nff.N();
        }
    }

    public void v() {
        com.kascend.chushou.c.c.dIP().a(this.P, new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.VideoPlayer.17
            @Override // com.kascend.chushou.c.b
            public void a() {
            }

            @Override // com.kascend.chushou.c.b
            public void a(String str, JSONObject jSONObject) {
                if (!VideoPlayer.this.isFinishing()) {
                    ParserRet dV = com.kascend.chushou.c.e.dV(jSONObject);
                    if (dV.mRc == 0 && dV.mData != null) {
                        PkNotifyInfo pkNotifyInfo = (PkNotifyInfo) dV.mData;
                        VideoPlayer.this.nfA.b = VideoPlayer.this.P;
                        if (pkNotifyInfo != null) {
                            VideoPlayer.this.nfA.nkf = pkNotifyInfo;
                            if (VideoPlayer.this.nff != null) {
                                VideoPlayer.this.nff.a(pkNotifyInfo, VideoPlayer.this.P);
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
        if (this.nfj != null) {
            this.nfj.release();
            this.nfj = null;
        }
        com.kascend.chushou.c.c.dIP().a(this.P, new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.VideoPlayer.18
            @Override // com.kascend.chushou.c.b
            public void a() {
            }

            @Override // com.kascend.chushou.c.b
            public void a(String str, JSONObject jSONObject) {
                if (!VideoPlayer.this.isFinishing()) {
                    ParserRet dW = com.kascend.chushou.c.e.dW(jSONObject);
                    if (dW.mRc == 0 && dW.mData != null) {
                        RoomExpandInfo roomExpandInfo = (RoomExpandInfo) dW.mData;
                        if (VideoPlayer.this.nfh != null) {
                            VideoPlayer.this.nfh.ngL = roomExpandInfo.mTopWebAdItem;
                            if (VideoPlayer.this.nfh.s == null) {
                                VideoPlayer.this.nfh.s = new ArrayList();
                            }
                            VideoPlayer.this.nfh.s.clear();
                            VideoPlayer.this.nfh.s.addAll(roomExpandInfo.mGiftTopRightIcons);
                            tv.chushou.zues.a.a.post(new i(50, VideoPlayer.this.nfh.ngL));
                        }
                        if (VideoPlayer.this.nfh != null) {
                            VideoPlayer.this.nfh.fv(roomExpandInfo.mExpandNavList);
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
                            VideoPlayer.this.nfw.a(list);
                        }
                        List<com.kascend.chushou.player.ui.h5.c.c> list2 = roomExpandInfo.mLuckList;
                        if (!h.isEmpty(list2)) {
                            VideoPlayer.this.nfx.a(list2);
                        }
                        com.kascend.chushou.player.ui.h5.c.c cVar = roomExpandInfo.mVoteItem;
                        if (cVar != null) {
                            VideoPlayer.this.nfy.a(cVar);
                        }
                        List<com.kascend.chushou.player.ui.h5.c.b> list3 = roomExpandInfo.mInteractH5Item;
                        if (!h.isEmpty(list3)) {
                            VideoPlayer.this.nfB.a(list3);
                        }
                        List<com.kascend.chushou.player.ui.h5.c.b> list4 = roomExpandInfo.mInteractNavItem;
                        if (!h.isEmpty(list4)) {
                            VideoPlayer.this.nfB.a(list4);
                        }
                        VideoPlayer.this.nfj = (PrivilegeInfo) dW.mData1;
                        if (VideoPlayer.this.nfj != null) {
                            tv.chushou.zues.a.a.post(new l());
                        }
                        if (VideoPlayer.this.nfh != null) {
                            VideoPlayer.this.nfh.ngR = roomExpandInfo.mIconConfig;
                            VideoPlayer.this.dJp().a(roomExpandInfo.mIconConfig.bangConfig);
                        }
                        List<SkinConfig> list5 = roomExpandInfo.skinConfig;
                        if (list5 != null && VideoPlayer.this.nfh != null) {
                            VideoPlayer.this.nfh.ngU.clear();
                            int i = 0;
                            while (true) {
                                int i2 = i;
                                if (i2 >= list5.size()) {
                                    break;
                                }
                                SkinConfig skinConfig = list5.get(i2);
                                VideoPlayer.this.nfh.ngU.put(skinConfig.position, skinConfig.resource);
                                i = i2 + 1;
                            }
                            VideoPlayer.this.C();
                        }
                        VideoPlayer.this.a(roomExpandInfo.mIconConfig, VideoPlayer.this.nfh != null ? VideoPlayer.this.nfh.ngU : null);
                        if (roomExpandInfo.mColorMap != null && roomExpandInfo.mColorMap.size() > 0 && com.kascend.chushou.b.dIM().c != null && com.kascend.chushou.b.dIM().c.size() <= 0) {
                            com.kascend.chushou.b.dIM().c.putAll(roomExpandInfo.mColorMap);
                            tv.chushou.zues.a.a.post(new i(52, null));
                        }
                        AutoBang autoBang = roomExpandInfo.mAutoBang;
                        if (autoBang != null && autoBang.currentTime != 0 && autoBang.bangTime != 0) {
                            VideoPlayer.this.dJp().a(autoBang);
                        }
                        if (!h.isEmpty(roomExpandInfo.mRelatedRoomList) && VideoPlayer.this.nfh != null) {
                            VideoPlayer.this.nfh.t = roomExpandInfo.mRelatedRoomList;
                            if (VideoPlayer.this.nff != null && VideoPlayer.this.H) {
                                VideoPlayer.this.nff.w();
                            }
                        }
                        if (roomExpandInfo.mRoomNewUserInfo != null && roomExpandInfo.mRoomNewUserInfo.mBarrierNoviceGuide && !com.kascend.chushou.d.h.dIT().k() && VideoPlayer.this.nff != null) {
                            VideoPlayer.this.nff.J();
                        }
                        if (roomExpandInfo.mRoomNewUserInfo != null && roomExpandInfo.mRoomNewUserInfo.mRewardNoviceGuide && !com.kascend.chushou.d.h.dIT().l() && VideoPlayer.this.nff != null) {
                            VideoPlayer.this.nff.K();
                        }
                        if (!h.isEmpty(roomExpandInfo.mShopWindowInfos)) {
                            if (VideoPlayer.this.nfh != null) {
                                if (VideoPlayer.this.nfh.ngS == null) {
                                    VideoPlayer.this.nfh.ngS = new ArrayList();
                                }
                                VideoPlayer.this.nfh.ngS.addAll(roomExpandInfo.mShopWindowInfos);
                            }
                            if (VideoPlayer.this.nff != null) {
                                VideoPlayer.this.nff.L();
                            }
                        }
                        VideoPlayer.this.nfA.b = VideoPlayer.this.P;
                        if (roomExpandInfo.mPkNotifyInfo != null) {
                            VideoPlayer.this.nfA.nkf = roomExpandInfo.mPkNotifyInfo;
                            if (VideoPlayer.this.nff != null) {
                                VideoPlayer.this.nff.a(roomExpandInfo.mPkNotifyInfo, VideoPlayer.this.P);
                            }
                        } else {
                            VideoPlayer.this.nfA.nkf = null;
                        }
                        if (roomExpandInfo.mTrumpetPocket != null && VideoPlayer.this.nfh != null) {
                            VideoPlayer.this.nfh.ngT = roomExpandInfo.mTrumpetPocket;
                            if (VideoPlayer.this.nff != null) {
                                VideoPlayer.this.nff.M();
                            }
                        }
                        if (!h.isEmpty(roomExpandInfo.hotwordContentList)) {
                            if (VideoPlayer.this.nfh != null) {
                                if (VideoPlayer.this.nfh.w == null) {
                                    VideoPlayer.this.nfh.w = new ArrayList();
                                }
                                VideoPlayer.this.nfh.w.clear();
                                VideoPlayer.this.nfh.w.addAll(roomExpandInfo.hotwordContentList);
                            }
                            if (VideoPlayer.this.nff != null) {
                                VideoPlayer.this.nff.b(roomExpandInfo.hotwordContentList);
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
        }, this.ag, this.nfC);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U() {
        if (!h.isEmpty(com.kascend.chushou.a.a.dIN().neA)) {
            StringBuilder sb = new StringBuilder();
            if (com.kascend.chushou.a.a.dIN().neA.contains(com.kascend.chushou.a.a.f)) {
                if (sb.length() > 0) {
                    sb.append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                sb.append(com.kascend.chushou.a.a.f);
            }
            if (com.kascend.chushou.a.a.dIN().neA.contains(com.kascend.chushou.a.a.g)) {
                if (sb.length() > 0) {
                    sb.append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                sb.append(com.kascend.chushou.a.a.g);
            }
            if (com.kascend.chushou.a.a.dIN().neA.contains(com.kascend.chushou.a.a.i)) {
                if (sb.length() > 0) {
                    sb.append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                sb.append(com.kascend.chushou.a.a.i);
            }
            if (com.kascend.chushou.a.a.dIN().neA.contains(com.kascend.chushou.a.a.h)) {
                if (sb.length() > 0) {
                    sb.append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                sb.append(com.kascend.chushou.a.a.h);
            }
            if (com.kascend.chushou.a.a.dIN().neA.contains(com.kascend.chushou.a.a.j)) {
                if (sb.length() > 0) {
                    sb.append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                sb.append(com.kascend.chushou.a.a.j);
            }
            if (com.kascend.chushou.a.a.dIN().neA.contains(com.kascend.chushou.a.a.l)) {
                if (sb.length() > 0) {
                    sb.append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                sb.append(com.kascend.chushou.a.a.l);
            }
            if (com.kascend.chushou.a.a.dIN().neA.contains(com.kascend.chushou.a.a.m)) {
                if (sb.length() > 0) {
                    sb.append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                sb.append(com.kascend.chushou.a.a.m);
            }
            if (sb.length() != 0) {
                com.kascend.chushou.a.a.dIN().a(sb.toString(), this.P, new a.c() { // from class: com.kascend.chushou.player.VideoPlayer.19
                    @Override // com.kascend.chushou.a.a.c
                    public void a(List<ListItem> list) {
                        if (VideoPlayer.this.nfh != null && list != null) {
                            int i = 0;
                            while (true) {
                                int i2 = i;
                                if (i2 >= list.size()) {
                                    break;
                                }
                                if (list.get(i2).mAdExtraInfo != null) {
                                    if (com.kascend.chushou.a.a.f.equals(list.get(i2).mAdExtraInfo.mCode)) {
                                        VideoPlayer.this.nfh.ngK = list.get(i2);
                                    } else if (com.kascend.chushou.a.a.g.equals(list.get(i2).mAdExtraInfo.mCode)) {
                                        VideoPlayer.this.nfh.ngJ = list.get(i2);
                                    } else if (com.kascend.chushou.a.a.i.equals(list.get(i2).mAdExtraInfo.mCode)) {
                                        VideoPlayer.this.nfh.ngM = list.get(i2);
                                    } else if (com.kascend.chushou.a.a.h.equals(list.get(i2).mAdExtraInfo.mCode)) {
                                        VideoPlayer.this.nfh.ngN = list.get(i2);
                                    } else if (com.kascend.chushou.a.a.j.equals(list.get(i2).mAdExtraInfo.mCode)) {
                                        VideoPlayer.this.nfh.ngQ = list.get(i2);
                                    } else if (com.kascend.chushou.a.a.l.equals(list.get(i2).mAdExtraInfo.mCode)) {
                                        VideoPlayer.this.nfh.ngO = list.get(i2);
                                    } else if (com.kascend.chushou.a.a.m.equals(list.get(i2).mAdExtraInfo.mCode)) {
                                        VideoPlayer.this.nfh.ngP = list.get(i2);
                                    }
                                }
                                i = i2 + 1;
                            }
                            if (VideoPlayer.this.nff != null) {
                                VideoPlayer.this.nff.H();
                            }
                        }
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str, String str2) {
        if (dJh()) {
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
                this.nfn.setSystemUiVisibility(i);
                return;
            }
            this.nfn.setSystemUiVisibility(1792);
        }
    }

    public void f(boolean z) {
        Window window;
        View decorView;
        if (com.kascend.chushou.b.dIM().d != 1 && (window = getWindow()) != null && (decorView = window.getDecorView()) != null) {
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
        if (this.nff != null) {
            this.nff.a(i, i2, intent);
        }
    }

    public Uri dJi() {
        return this.nfa;
    }

    @Override // com.kascend.chushou.view.base.BaseActivity
    protected int y() {
        return 0;
    }

    public void wW(boolean z) {
        if (this.nfn != null) {
            this.nfn.onG = z;
        }
    }

    public void dJj() {
        if (this.nfn != null) {
            this.nfn.dJj();
        }
    }

    public boolean dJk() {
        return this.ae;
    }

    public void g(boolean z) {
        this.ae = z;
    }

    public void h(boolean z) {
        if (this.nfn != null) {
            this.nfn.setIsTranslucentStatus(z);
        }
    }

    public void z() {
        if (this.nfn != null) {
            this.nfn.dXi();
        }
    }

    @Override // com.kascend.chushou.widget.gifts.RoomSendGiftView.a
    public void A() {
        if (this.nfl != null) {
            this.nfl.b();
        }
        if (this.nfh != null) {
            this.nfh.z = true;
        }
    }

    @Override // com.kascend.chushou.widget.gifts.RoomSendGiftView.a
    public void B() {
        if (this.nfl != null) {
            this.nfl.b();
        }
    }

    public void a(List<ListItem> list) {
        if (this.nff != null) {
            this.nff.a(list);
        }
    }

    public void a(IconConfig iconConfig, Map<String, SkinConfig.SkinRes> map) {
        if (this.nff != null) {
            this.nff.a(iconConfig, map);
        }
    }

    public void C() {
        if (this.nff != null) {
            this.nff.I();
        }
    }

    @Override // com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC0831a
    public void a(int i) {
        if (this.nff != null) {
            this.nff.a(i);
        }
    }

    @Override // com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC0831a
    public void D() {
        if (!isFinishing() && this.nff != null) {
            this.nff.D();
        }
    }

    @Override // com.kascend.chushou.player.ui.h5.b.b.a
    public void a(long j) {
        if (!isFinishing() && this.nff != null) {
            this.nff.a(j);
        }
    }

    @Override // com.kascend.chushou.player.ui.h5.b.b.a
    public void a(com.kascend.chushou.player.ui.h5.c.a aVar) {
        if (aVar != null && this.nff != null) {
            this.nff.a(aVar);
        }
    }

    @Override // com.kascend.chushou.player.ui.h5.b.b.a
    public void b(int i) {
        if (this.nff != null) {
            this.nff.b(i);
        }
    }

    @Override // com.kascend.chushou.player.ui.h5.d.a.InterfaceC0830a
    public void b(long j) {
        if (!isFinishing() && this.nff != null) {
            this.nff.b(j);
        }
    }

    @Override // com.kascend.chushou.player.ui.h5.a.a.InterfaceC0828a
    public void c(int i) {
        if (!isFinishing() && this.nff != null) {
            this.nff.c(i);
        }
    }

    @Override // com.kascend.chushou.player.ui.h5.d.a.InterfaceC0830a
    public void b(com.kascend.chushou.player.ui.h5.c.a aVar) {
        if (aVar != null && this.nff != null) {
            this.nff.b(aVar);
        }
    }

    @Override // com.kascend.chushou.player.ui.a.a.InterfaceC0825a
    public void a(IconConfig.Config config) {
        if (this.nff != null) {
            this.nff.a(config);
        }
    }

    @Override // com.kascend.chushou.player.ui.a.a.InterfaceC0825a
    public void a(BangInfo bangInfo, String str) {
        if (this.nff != null) {
            this.nff.a(bangInfo, str);
        }
    }

    @Override // com.kascend.chushou.player.ui.a.a.InterfaceC0825a
    public void a(long j, BangInfo bangInfo, String str) {
        if (this.nff != null) {
            this.nff.a(j, bangInfo, str);
        }
    }

    public com.kascend.chushou.player.ui.h5.redpacket.a dJl() {
        return this.nfw;
    }

    public com.kascend.chushou.player.ui.h5.b.b dJm() {
        return this.nfx;
    }

    public com.kascend.chushou.player.ui.h5.d.a dJn() {
        return this.nfy;
    }

    public com.kascend.chushou.player.ui.h5.a.a dJo() {
        return this.nfB;
    }

    public com.kascend.chushou.player.ui.a.a dJp() {
        return this.nfz;
    }

    public com.kascend.chushou.player.e.a dJq() {
        return this.nfA;
    }

    @Override // com.kascend.chushou.view.base.BaseActivity, android.app.Activity
    public void finish() {
        super.finish();
        if ("3".equals(this.R)) {
            overridePendingTransition(17432576, a.C0815a.commonres_activity_exit_bottom);
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
        RxExecutor.postDelayed(this.nfE, EventThread.MAIN_THREAD, aVar.d, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.VideoPlayer.2
            @Override // java.lang.Runnable
            public void run() {
                if (VideoPlayer.this.nff != null) {
                    VideoPlayer.this.nff.c(aVar);
                }
            }
        });
    }

    private void e(final com.kascend.chushou.player.ui.h5.c.a aVar) {
        if (!com.kascend.chushou.d.h.dIT().dIW().contains(aVar.b)) {
            if (aVar.d < 0) {
                aVar.d = 0;
            }
            RxExecutor.postDelayed(this.nfE, EventThread.MAIN_THREAD, aVar.d, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.VideoPlayer.3
                @Override // java.lang.Runnable
                public void run() {
                    if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.nff != null) {
                        VideoPlayer.this.nff.c(aVar);
                    }
                }
            });
        }
    }

    private String dJr() {
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
                if (VideoPlayer.this.nfm != null && !VideoPlayer.this.isFinishing()) {
                    VideoPlayer.n = VideoPlayer.this.nfm.getStreamVolume(3);
                }
                if (!VideoPlayer.this.isFinishing() && (VideoPlayer.this.nff instanceof f)) {
                    ((f) VideoPlayer.this.nff).ab();
                }
            }
        }
    }

    public String a(String str) {
        HashMap hashMap = new HashMap(tv.chushou.zues.utils.d.Th(str));
        if ("1".equals(this.R)) {
            hashMap.put("roomId", this.P);
        } else if ("3".equals(this.R)) {
            hashMap.put("videoId", this.P);
        }
        return tv.chushou.zues.utils.d.toJson(hashMap);
    }

    public boolean dJs() {
        if (this.nff instanceof com.kascend.chushou.player.d.a) {
            return ((com.kascend.chushou.player.d.a) this.nff).dKr();
        }
        if (this.nff instanceof com.kascend.chushou.player.e.e) {
            return true;
        }
        return false;
    }
}

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
public class VideoPlayer extends BaseActivity implements a.InterfaceC0725a, a.InterfaceC0728a, b.a, a.InterfaceC0730a, a.InterfaceC0731a, RoomSendGiftView.a {
    private static int A = 60000;
    public static String a = null;
    public static int n = 0;
    private String P;
    private String Q;
    private String R;
    private String S;
    private ImageView Z;
    private String ab;
    private c mnO;
    b mnR;
    public PrivilegeInfo mnT;
    com.kascend.chushou.widget.a.b mnX;
    private KPSwitchRootRelativeLayout mnZ;
    private FrameLayout moa;
    private LinearLayout mob;
    private com.kascend.chushou.toolkit.d moc;
    com.kascend.chushou.view.b.a.a mod;
    private String mog;
    private FrescoThumbnailView moh;
    private FrameLayout moi;
    public com.kascend.chushou.player.feedback.a mor;
    private a mot;
    private CSTVWifiReceiver mou;
    private boolean B = true;
    private boolean C = false;
    private Uri mnK = null;
    private tv.chushou.common.player.a mnL = null;
    public tv.chushou.common.player.a mnM = null;
    public tv.chushou.common.player.a mnN = null;
    public boolean d = false;
    public boolean e = false;
    private e mnP = null;
    private boolean H = false;
    private com.kascend.chushou.view.user.b mnQ = null;
    private boolean J = false;
    private boolean K = false;
    private boolean L = false;
    private boolean M = false;
    private long mnS = 0;
    private int O = 0;
    public boolean g = false;
    private ImageView mnU = null;
    private TextView mnV = null;
    private AnimationImageView mnW = null;
    private View bqO = null;
    public boolean j = false;
    public float k = 0.0f;
    public float l = 0.0f;
    public boolean m = false;
    public AudioManager mnY = null;
    private d.a moe = new d.a() { // from class: com.kascend.chushou.player.VideoPlayer.1
        @Override // com.kascend.chushou.toolkit.d.a
        public void a() {
            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.mov != null) {
                VideoPlayer.this.mov.JF(4);
            }
        }
    };
    private boolean ae = false;
    public boolean q = true;
    public long r = -1;
    public long s = -1;
    private PowerManager.WakeLock mof = null;
    public String t = null;
    private final com.kascend.chushou.player.ui.h5.redpacket.a moj = new com.kascend.chushou.player.ui.h5.redpacket.a(this);
    private final com.kascend.chushou.player.ui.h5.b.b mok = new com.kascend.chushou.player.ui.h5.b.b(this);
    private final com.kascend.chushou.player.ui.h5.d.a mol = new com.kascend.chushou.player.ui.h5.d.a(this);
    private final com.kascend.chushou.player.ui.a.a mom = new com.kascend.chushou.player.ui.a.a(this);
    private final com.kascend.chushou.player.e.a moo = new com.kascend.chushou.player.e.a();
    private final com.kascend.chushou.player.ui.h5.a.a mop = new com.kascend.chushou.player.ui.h5.a.a(this);
    private String moq = "1";
    private String aq = "2";
    private io.reactivex.disposables.a mos = new io.reactivex.disposables.a();
    private tv.chushou.zues.c mov = new tv.chushou.zues.c(new Handler.Callback() { // from class: com.kascend.chushou.player.VideoPlayer.6
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            try {
                if (!VideoPlayer.this.isFinishing()) {
                    switch (message.what) {
                        case 1:
                            VideoPlayer.this.mov.removeMessages(1);
                            com.kascend.chushou.c.c.dwG().a(VideoPlayer.this.P, VideoPlayer.this.mnR != null ? VideoPlayer.this.mnR.h : null, System.currentTimeMillis());
                            VideoPlayer.this.mov.A(1, VideoPlayer.A);
                            break;
                        case 2:
                            VideoPlayer.this.a(true, (Uri) null, false);
                            break;
                        case 3:
                            VideoPlayer.this.dlc();
                            break;
                        case 4:
                            if (VideoPlayer.this.mnP != null) {
                                VideoPlayer.this.mnP.a(true);
                            }
                            if (VideoPlayer.this.moc != null) {
                                VideoPlayer.this.moc.d();
                                VideoPlayer.this.moc = null;
                                break;
                            }
                            break;
                        case 5:
                            int i = message.arg1;
                            if (i == 1) {
                                if (VideoPlayer.this.mnP != null) {
                                    VideoPlayer.this.mnP.p();
                                    break;
                                }
                            } else if (i == 2 && VideoPlayer.this.mnP != null) {
                                VideoPlayer.this.mnP.e(message.arg2);
                                break;
                            }
                            break;
                        case 6:
                            if (!com.kascend.chushou.b.dwD().a && !com.kascend.chushou.b.dwD().b && VideoPlayer.this.mnP != null) {
                                VideoPlayer.this.mnP.g(true);
                                break;
                            } else {
                                VideoPlayer.this.c();
                                break;
                            }
                            break;
                        case 7:
                            tv.chushou.zues.utils.e.d(VideoPlayer.this.v, "MSG_BUFFER_DEALY: ");
                            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.mnP != null && VideoPlayer.this.M && !VideoPlayer.this.e) {
                                VideoPlayer.this.mnP.h(true);
                                VideoPlayer.this.mnS = 0L;
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
    private boolean mow = true;
    private boolean mox = false;
    private tv.chushou.common.player.b moy = new tv.chushou.common.player.b() { // from class: com.kascend.chushou.player.VideoPlayer.14
        @Override // tv.chushou.common.player.b
        public void dxk() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerACallback onSetVideoViewLayout");
            if (!VideoPlayer.this.isFinishing()) {
                if ((VideoPlayer.this.mnP == null || !VideoPlayer.this.mnP.H) && VideoPlayer.this.mnP != null && !VideoPlayer.this.d) {
                    VideoPlayer.this.mnP.y();
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void Ii(int i) {
            if (!VideoPlayer.this.isFinishing()) {
                if ((VideoPlayer.this.mnP == null || !VideoPlayer.this.mnP.H) && VideoPlayer.this.mnP != null && !VideoPlayer.this.d) {
                    VideoPlayer.this.mnP.g(i);
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void dxl() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerACallback onCompletePlayback");
            if (!VideoPlayer.this.isFinishing()) {
                if (!h.isEmpty(VideoPlayer.this.P)) {
                    j.dwP().a(VideoPlayer.this.P, 0);
                }
                VideoPlayer.this.K = false;
                if (VideoPlayer.this.mov != null) {
                    VideoPlayer.this.mov.removeMessages(1);
                }
                if ((VideoPlayer.this.mnP == null || !VideoPlayer.this.mnP.H) && VideoPlayer.this.mnP != null && !VideoPlayer.this.d) {
                    VideoPlayer.this.mov.removeMessages(7);
                    VideoPlayer.this.M = false;
                    VideoPlayer.this.mnP.z();
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void dxm() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerACallback onVideoRenderingStart");
            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.mnP != null) {
                VideoPlayer.this.mnP.G();
            }
        }

        @Override // tv.chushou.common.player.b
        public void dxn() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerACallback onPreparedPlayback");
            if (!VideoPlayer.this.isFinishing()) {
                if (VideoPlayer.this.mnP == null || !VideoPlayer.this.mnP.H) {
                    VideoPlayer.this.mov.removeMessages(6);
                    VideoPlayer.this.mnS = 0L;
                    VideoPlayer.this.O = 0;
                    if (VideoPlayer.this.mnL != null && VideoPlayer.this.mnP != null) {
                        VideoPlayer.this.mnL.setVolume(VideoPlayer.this.mnP.J, VideoPlayer.this.mnP.J);
                    }
                    if (VideoPlayer.this.mnR != null) {
                        VideoPlayer.this.K = false;
                        FullRoomInfo dxv = VideoPlayer.this.dwX() ? null : VideoPlayer.this.mnR.dxv();
                        if (VideoPlayer.this.L || dxv != null) {
                            if (VideoPlayer.this.mnR.e) {
                                VideoPlayer.this.mnR.e = false;
                                VideoPlayer.this.mnR.d = !VideoPlayer.this.mnR.d;
                            }
                            if (VideoPlayer.this.mnP != null) {
                                VideoPlayer.this.c("1", (String) null);
                                if (!VideoPlayer.this.d) {
                                    VideoPlayer.this.mnP.i(true);
                                } else if (VideoPlayer.this.e) {
                                    VideoPlayer.this.e = false;
                                    VideoPlayer.this.mnP.B();
                                }
                            }
                        }
                    }
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void Ij(int i) {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerACallback onErrorAppeared");
            if (!VideoPlayer.this.isFinishing()) {
                VideoPlayer.this.c();
                VideoPlayer.this.K = false;
                if (VideoPlayer.this.mov != null) {
                    VideoPlayer.this.mov.removeMessages(7);
                }
                if (VideoPlayer.this.mov != null) {
                    VideoPlayer.this.mov.removeMessages(1);
                }
                if ((VideoPlayer.this.mnP == null || !VideoPlayer.this.mnP.H) && !VideoPlayer.this.dwR()) {
                    if (!"10004".equals(VideoPlayer.this.t)) {
                        if (VideoPlayer.this.mnP != null) {
                            if (VideoPlayer.this.d) {
                                VideoPlayer.this.mnM.stop();
                                VideoPlayer.this.mnM.release();
                                VideoPlayer.this.e = false;
                                VideoPlayer.this.mnP.C();
                            }
                            if (!com.kascend.chushou.b.dwD().a && !com.kascend.chushou.b.dwD().b) {
                                VideoPlayer.this.mnP.g(true);
                            } else if (VideoPlayer.this.d) {
                                VideoPlayer.this.mnP.a(i, true);
                            } else {
                                VideoPlayer.this.mnP.a(i, false);
                            }
                            VideoPlayer.this.c("2", (String) null);
                            return;
                        }
                        return;
                    }
                    dxl();
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void dxo() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerACallback onBufferingStart");
            if (!VideoPlayer.this.isFinishing()) {
                if ((VideoPlayer.this.mnP == null || !VideoPlayer.this.mnP.H) && VideoPlayer.this.mnP != null && !VideoPlayer.this.d) {
                    VideoPlayer.this.mnP.E();
                    VideoPlayer.this.M = true;
                    long currentTimeMillis = System.currentTimeMillis();
                    VideoPlayer.this.mov.removeMessages(7);
                    if (!VideoPlayer.this.g) {
                        VideoPlayer.y(VideoPlayer.this);
                    }
                    tv.chushou.zues.utils.e.d(VideoPlayer.this.v, "currentTime: -- >" + currentTimeMillis + "  bufferTime-->" + VideoPlayer.this.mnS + "  bufferCount-->" + VideoPlayer.this.O);
                    if (currentTimeMillis - VideoPlayer.this.mnS >= 20000 || VideoPlayer.this.O < 2 || VideoPlayer.this.mnP.H) {
                        if (VideoPlayer.this.O == 1) {
                            VideoPlayer.this.mnS = currentTimeMillis;
                        }
                        VideoPlayer.this.mov.A(7, 5000L);
                    } else {
                        VideoPlayer.this.mov.JF(7);
                    }
                    if (VideoPlayer.this.g) {
                        VideoPlayer.this.g = false;
                    }
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void dxp() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerACallback onBufferingEnd");
            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.mnP != null && !VideoPlayer.this.d) {
                VideoPlayer.this.mov.removeMessages(7);
                VideoPlayer.this.M = false;
                if (VideoPlayer.this.mnP == null || !VideoPlayer.this.mnP.H) {
                    if (VideoPlayer.this.mnL == null) {
                        VideoPlayer.this.mnP.a(false, true, false);
                    } else {
                        VideoPlayer.this.mnP.a(true, VideoPlayer.this.mnL.getPlayState() == 4, VideoPlayer.this.mnL.getPlayState() == 5);
                    }
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void dxq() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerACallback onPlayerStart");
            if (!VideoPlayer.this.isFinishing()) {
                if (VideoPlayer.this.mnP == null || !VideoPlayer.this.mnP.H) {
                    if (VideoPlayer.this.mnP != null && !VideoPlayer.this.d) {
                        if (VideoPlayer.this.mnL != null) {
                            VideoPlayer.this.mnP.F();
                            VideoPlayer.this.mnP.a(true, VideoPlayer.this.mnL.getPlayState() == 4, VideoPlayer.this.mnL.getPlayState() == 5);
                        } else {
                            VideoPlayer.this.mnP.a(false, true, false);
                        }
                    }
                    if (VideoPlayer.this.mov != null && !VideoPlayer.this.dwX()) {
                        VideoPlayer.this.mov.removeMessages(1);
                        VideoPlayer.this.mov.A(1, VideoPlayer.A);
                    }
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void dxr() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerACallback onPlayerPause");
            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.mov != null) {
                VideoPlayer.this.mov.removeMessages(1);
            }
        }

        @Override // tv.chushou.common.player.b
        public void dxs() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerACallback onPlayerStop");
            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.dwX() && VideoPlayer.this.mnM != null && !h.isEmpty(VideoPlayer.this.P) && VideoPlayer.this.mnM.getCurrentPos() > 0) {
                j.dwP().a(VideoPlayer.this.P, VideoPlayer.this.mnM.getCurrentPos());
            }
        }
    };
    private tv.chushou.common.player.b moz = new tv.chushou.common.player.b() { // from class: com.kascend.chushou.player.VideoPlayer.15
        @Override // tv.chushou.common.player.b
        public void dxk() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerBCallback onSetVideoViewLayout");
            if (!VideoPlayer.this.isFinishing()) {
                if ((VideoPlayer.this.mnP == null || !VideoPlayer.this.mnP.H) && VideoPlayer.this.mnP != null && VideoPlayer.this.d) {
                    VideoPlayer.this.mnP.y();
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void Ii(int i) {
            if (!VideoPlayer.this.isFinishing()) {
                if ((VideoPlayer.this.mnP == null || !VideoPlayer.this.mnP.H) && VideoPlayer.this.mnP != null && VideoPlayer.this.d) {
                    VideoPlayer.this.mnP.g(i);
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void dxl() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerBCallback onCompletePlayback");
            if (!VideoPlayer.this.isFinishing()) {
                if (!h.isEmpty(VideoPlayer.this.P)) {
                    j.dwP().a(VideoPlayer.this.P, 0);
                }
                VideoPlayer.this.K = false;
                if (VideoPlayer.this.mov != null) {
                    VideoPlayer.this.mov.removeMessages(1);
                }
                if ((VideoPlayer.this.mnP == null || !VideoPlayer.this.mnP.H) && VideoPlayer.this.mnP != null && VideoPlayer.this.d) {
                    VideoPlayer.this.mov.removeMessages(7);
                    VideoPlayer.this.M = false;
                    VideoPlayer.this.mnP.z();
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void dxm() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerBCallback onVideoRenderingStart");
            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.mnP != null) {
                VideoPlayer.this.mnP.G();
            }
        }

        @Override // tv.chushou.common.player.b
        public void dxn() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerBCallback onPreparedPlayback");
            if (!VideoPlayer.this.isFinishing()) {
                if (VideoPlayer.this.mnP == null || !VideoPlayer.this.mnP.H) {
                    VideoPlayer.this.mov.removeMessages(6);
                    VideoPlayer.this.mnS = 0L;
                    VideoPlayer.this.O = 0;
                    if (VideoPlayer.this.mnL != null && VideoPlayer.this.mnP != null) {
                        VideoPlayer.this.mnL.setVolume(VideoPlayer.this.mnP.J, VideoPlayer.this.mnP.J);
                    }
                    if (VideoPlayer.this.mnR != null) {
                        VideoPlayer.this.K = false;
                        FullRoomInfo dxv = VideoPlayer.this.dwX() ? null : VideoPlayer.this.mnR.dxv();
                        if (VideoPlayer.this.L || dxv != null) {
                            if (VideoPlayer.this.mnR.e) {
                                VideoPlayer.this.mnR.e = false;
                                VideoPlayer.this.mnR.d = !VideoPlayer.this.mnR.d;
                            }
                            if (VideoPlayer.this.mnP != null) {
                                VideoPlayer.this.c("1", (String) null);
                                if (VideoPlayer.this.d) {
                                    VideoPlayer.this.mnP.i(true);
                                } else if (VideoPlayer.this.e) {
                                    VideoPlayer.this.e = false;
                                    VideoPlayer.this.mnP.B();
                                }
                            }
                        }
                    }
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void Ij(int i) {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerBCallback onErrorAppeared");
            if (!VideoPlayer.this.isFinishing()) {
                VideoPlayer.this.c();
                VideoPlayer.this.K = false;
                if (VideoPlayer.this.mov != null) {
                    VideoPlayer.this.mov.removeMessages(7);
                }
                if (VideoPlayer.this.mov != null) {
                    VideoPlayer.this.mov.removeMessages(1);
                }
                if ((VideoPlayer.this.mnP == null || !VideoPlayer.this.mnP.H) && !VideoPlayer.this.dwR()) {
                    if (!"10004".equals(VideoPlayer.this.t)) {
                        if (VideoPlayer.this.mnP != null) {
                            if (!VideoPlayer.this.d) {
                                VideoPlayer.this.mnN.stop();
                                VideoPlayer.this.mnN.release();
                                VideoPlayer.this.mnP.C();
                                VideoPlayer.this.e = false;
                            }
                            if (!com.kascend.chushou.b.dwD().a && !com.kascend.chushou.b.dwD().b) {
                                VideoPlayer.this.mnP.g(true);
                            } else if (VideoPlayer.this.d) {
                                VideoPlayer.this.mnP.a(i, false);
                            } else {
                                VideoPlayer.this.mnP.a(i, true);
                            }
                            VideoPlayer.this.c("2", (String) null);
                            return;
                        }
                        return;
                    }
                    dxl();
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void dxo() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerBCallback onBufferingStart");
            if (!VideoPlayer.this.isFinishing()) {
                if ((VideoPlayer.this.mnP == null || !VideoPlayer.this.mnP.H) && VideoPlayer.this.mnP != null && VideoPlayer.this.d) {
                    VideoPlayer.this.mnP.E();
                    VideoPlayer.this.M = true;
                    VideoPlayer.this.mov.removeMessages(7);
                    long currentTimeMillis = System.currentTimeMillis();
                    if (!VideoPlayer.this.g) {
                        VideoPlayer.y(VideoPlayer.this);
                    }
                    tv.chushou.zues.utils.e.d(VideoPlayer.this.v, "currentTime: -- >" + currentTimeMillis + "  bufferTime-->" + VideoPlayer.this.mnS + "  bufferCount-->" + VideoPlayer.this.O);
                    if (currentTimeMillis - VideoPlayer.this.mnS >= 20000 || VideoPlayer.this.O < 2 || VideoPlayer.this.mnP.H) {
                        if (VideoPlayer.this.O == 1) {
                            VideoPlayer.this.mnS = currentTimeMillis;
                        }
                        VideoPlayer.this.mov.A(7, 5000L);
                    } else {
                        VideoPlayer.this.mnS = 0L;
                        VideoPlayer.this.O = 0;
                        VideoPlayer.this.mov.JF(7);
                    }
                    if (VideoPlayer.this.g) {
                        VideoPlayer.this.g = false;
                    }
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void dxp() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerBCallback onBufferingEnd");
            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.mnP != null && VideoPlayer.this.d) {
                VideoPlayer.this.M = false;
                VideoPlayer.this.mov.removeMessages(7);
                if (VideoPlayer.this.mnP == null || !VideoPlayer.this.mnP.H) {
                    if (VideoPlayer.this.mnL == null) {
                        VideoPlayer.this.mnP.a(false, true, false);
                    } else {
                        VideoPlayer.this.mnP.a(true, VideoPlayer.this.mnL.getPlayState() == 4, VideoPlayer.this.mnL.getPlayState() == 5);
                    }
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void dxq() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerBCallback onPlayerStart");
            if (!VideoPlayer.this.isFinishing()) {
                if (VideoPlayer.this.mnP == null || !VideoPlayer.this.mnP.H) {
                    if (VideoPlayer.this.mnP != null && VideoPlayer.this.d) {
                        if (VideoPlayer.this.mnL != null) {
                            VideoPlayer.this.mnP.F();
                            VideoPlayer.this.mnP.a(true, VideoPlayer.this.mnL.getPlayState() == 4, VideoPlayer.this.mnL.getPlayState() == 5);
                        } else {
                            VideoPlayer.this.mnP.a(false, true, false);
                        }
                    }
                    if (VideoPlayer.this.mov != null && !VideoPlayer.this.dwX()) {
                        VideoPlayer.this.mov.removeMessages(1);
                        VideoPlayer.this.mov.A(1, VideoPlayer.A);
                    }
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void dxr() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerBCallback onPlayerPause");
            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.mov != null) {
                VideoPlayer.this.mov.removeMessages(1);
            }
        }

        @Override // tv.chushou.common.player.b
        public void dxs() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerBCallback onPlayerStop");
            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.dwX() && VideoPlayer.this.mnN != null && !h.isEmpty(VideoPlayer.this.P) && VideoPlayer.this.mnN.getCurrentPos() > 0) {
                j.dwP().a(VideoPlayer.this.P, VideoPlayer.this.mnN.getCurrentPos());
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
        this.mnK = intent.getData();
        if (this.mnK == null) {
            finish();
            return;
        }
        com.kascend.chushou.d.e.j();
        if (this.mou == null) {
            this.mou = new CSTVWifiReceiver();
            registerReceiver(this.mou, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        }
        com.kascend.chushou.toolkit.d.a.dyO().b();
        tv.chushou.zues.utils.e.i(this.v, "intent.getData=" + this.mnK.toString());
        String scheme = this.mnK.getScheme();
        if (scheme == null || !scheme.equals("chushou")) {
            tv.chushou.zues.utils.e.e(this.v, "not support scheme :" + scheme);
            finish();
            return;
        }
        a(intent);
    }

    private void a(Intent intent) {
        this.P = this.mnK.getQueryParameter("roomId");
        this.Q = this.P;
        this.S = this.mnK.getQueryParameter(WebSocketRequest.PARAM_KEY_PROTOCOLS);
        this.aq = this.mnK.getQueryParameter("liveType");
        if ("2".equals(this.aq) || "3".equals(this.aq) || "4".equals(this.aq)) {
            this.moq = "2";
            this.mor = new com.kascend.chushou.player.feedback.a();
            if (this.mor.mwH != null) {
                this.mor.mwH.reset();
                this.mor.mwH.roomId = this.P;
                this.mor.mwH.enterType = 1;
                this.mor.b = System.currentTimeMillis();
            }
        }
        if (h.isEmpty(this.P) || h.isEmpty(this.S)) {
            tv.chushou.zues.utils.e.e(this.v, "invalid param mItemID=" + this.P + " protocols=" + this.S);
            finish();
            return;
        }
        if (com.kascend.chushou.b.dwD().d == -1) {
            com.kascend.chushou.b.dwD().d = com.kascend.chushou.d.g.b() ? 1 : 0;
        }
        this.mof = ((PowerManager) getSystemService("power")).newWakeLock(536870938, this.v);
        this.mof.acquire();
        this.mnR = new b(this.P);
        this.mnR.d = intent.getBooleanExtra("room_play_audio", false);
        this.mnX = new com.kascend.chushou.widget.a.b();
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
        this.mnZ = (KPSwitchRootRelativeLayout) findViewById(a.f.rlRoot);
        if (!"2".equals(this.moq) && com.kascend.chushou.b.dwD().d == 1) {
            this.mnZ.setFitsSystemWindows(true);
        }
        this.moa = (FrameLayout) this.mnZ.findViewById(a.f.fl_fragment);
        this.bqO = this.mnZ.findViewById(a.f.rl_empty);
        this.mnU = (ImageView) this.bqO.findViewById(a.f.iv_empty);
        this.mnV = (TextView) this.bqO.findViewById(a.f.tv_empty);
        this.mob = (LinearLayout) this.mnZ.findViewById(a.f.rl_title);
        this.Z = (ImageView) this.mob.findViewById(a.f.back_icon);
        this.Z.setOnClickListener(new View.OnClickListener() { // from class: com.kascend.chushou.player.VideoPlayer.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayer.this.finish();
            }
        });
        this.mnW = (AnimationImageView) this.bqO.findViewById(a.f.iv_loading);
        this.moh = (FrescoThumbnailView) this.mnZ.findViewById(a.f.live_cover);
        this.moi = (FrameLayout) this.mnZ.findViewById(a.f.fl_cover);
        this.k = dwQ();
        try {
            this.mnY = (AudioManager) getApplicationContext().getSystemService("audio");
            n = this.mnY.getStreamVolume(3);
            this.mnY.requestAudioFocus(null, 3, 1);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (this.B) {
            a(1, dwX() ? "3" : "1");
        } else {
            r();
        }
        if (com.kascend.chushou.b.dwD().b && !com.kascend.chushou.b.dwD().a) {
            RxExecutor.postDelayed(this.mos, EventThread.MAIN_THREAD, 60L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.VideoPlayer.5
                @Override // java.lang.Runnable
                public void run() {
                    if (!VideoPlayer.this.isFinishing() && com.kascend.chushou.b.dwD().b && !com.kascend.chushou.b.dwD().a) {
                        tv.chushou.zues.utils.g.c(VideoPlayer.this.w, VideoPlayer.this.getString(a.i.str_monet_notify));
                    }
                }
            });
        }
        com.kascend.chushou.c.c.dwG().a(this.P, stringExtra, System.currentTimeMillis());
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
        if (this.mot == null) {
            this.mot = new a();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.media.VOLUME_CHANGED_ACTION");
            registerReceiver(this.mot, intentFilter);
        }
    }

    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        j(false);
        if (this.mot != null) {
            unregisterReceiver(this.mot);
            this.mot = null;
        }
        super.onStop();
    }

    @Override // com.kascend.chushou.view.base.BaseActivity
    protected void a(boolean z) {
        if (this.mnP != null) {
            this.mnP.k(z);
        }
    }

    @Subscribe
    public void onHideGiftEffectEvent(com.kascend.chushou.b.a.a.f fVar) {
        if (fVar.b) {
            this.mnP.k();
            return;
        }
        this.mnP.m();
        this.mnP.l();
    }

    private float dwQ() {
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
        this.mog = str;
        R();
        try {
            if (h.isEmpty(str)) {
                jSONObject = new JSONObject();
            } else {
                jSONObject = new JSONObject(str);
            }
            jSONObject.put("_fbroomid", this.P);
            this.mnR.h = jSONObject.toString();
            String optString = jSONObject.optString("_thumb");
            jSONObject.optBoolean("tag_from_game_mic", false);
            if (!h.isEmpty(optString)) {
                this.ab = optString;
            }
        } catch (JSONException e) {
            e.printStackTrace();
            this.mnR.h = str;
        }
        if (dwX()) {
            a(this.P, str);
            aL(this.P, z);
            return;
        }
        a = this.P;
        b(this.P, str);
        a(this.P, dxh(), z);
        w();
    }

    private void O() {
        this.m = true;
        j();
        if (this.mnP != null) {
            this.mnP.r();
        }
        s();
    }

    @Subscribe
    public void onStartRoomEvent(o oVar) {
        if (!isFinishing() && oVar.mnr != null && oVar.c != null && !h.isEmpty(oVar.mnr.mTargetKey)) {
            if (oVar.c != this) {
                tv.chushou.zues.utils.e.e(this.v, "different player!");
                return;
            }
            if (this.mnR != null) {
                this.mnR.a();
                this.mnR.a = oVar.mnr.mTargetKey;
                this.mnR.d = oVar.d;
                if (this.mnR.mpt != null) {
                    this.mnR.mpt.e();
                }
                if (this.mnR.mpt != null) {
                    this.mnR.mpt.b();
                }
                this.mnR.mpw = null;
                this.mnR.mpv = null;
                this.mnR.mpz = null;
                this.mnR.mpy = null;
                this.mnR.mpC = null;
                this.mnR.mpA = null;
                this.mnR.mpB = null;
            }
            if (this.mnY != null) {
                n = this.mnY.getStreamVolume(3);
            }
            if (!h.isEmpty(oVar.mnr.mType) && oVar.mnr.mType.equals("3")) {
                this.B = false;
                this.moq = "1";
                r();
                this.P = oVar.mnr.mTargetKey;
                this.R = "3";
                if (this.mnX != null) {
                    this.mnX.a();
                }
                if (this.mnR != null) {
                    this.mnR.a((PlayUrl) null);
                    this.mnR.f();
                    if (this.mnR.c() != null) {
                        this.mnR.c().clear();
                    }
                    this.mnR.i.clear();
                }
                if (this.mnP != null) {
                    this.mnP.j();
                }
                s();
                if (this.moc != null) {
                    this.moc.d();
                    this.moc = null;
                }
                if (this.mos != null) {
                    this.mos.dispose();
                    this.mos = new io.reactivex.disposables.a();
                }
                a(oVar.e, false);
                return;
            }
            boolean z = this.R != null && this.R.equals("1");
            this.R = "1";
            this.mom.a();
            this.mol.a();
            this.mok.a();
            this.moj.c();
            this.mop.a();
            if (this.mos != null) {
                this.mos.dispose();
                this.mos = new io.reactivex.disposables.a();
            }
            if ("1".equals(oVar.f)) {
                this.H = false;
                if (this.mnR != null && !h.isEmpty(this.mnR.t)) {
                    this.mnR.t.clear();
                }
                this.ab = oVar.mnr.mCover;
                this.moi.setVisibility(0);
                this.moh.setBlur(true);
                this.moh.i(oVar.mnr.mCover, 0, 0, 0);
            }
            if (!oVar.mnr.mTargetKey.equals(this.P)) {
                this.aq = oVar.g;
                if (!z) {
                    this.B = false;
                    r();
                } else if (!"2".equals(this.moq) && ("2".equals(this.aq) || "3".equals(this.aq) || "4".equals(this.aq))) {
                    this.moq = "2";
                    this.mor = new com.kascend.chushou.player.feedback.a();
                    if (this.mor.mwH != null) {
                        this.mor.mwH.reset();
                        this.mor.mwH.roomId = oVar.mnr.mTargetKey;
                        this.mor.mwH.enterType = 1;
                        this.mor.b = System.currentTimeMillis();
                    }
                }
                this.B = false;
                this.P = oVar.mnr.mTargetKey;
                this.Q = this.P;
                this.ab = oVar.mnr.mCover;
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
                JSONObject O = com.kascend.chushou.d.e.O("_fromView", str, "_sc", oVar.mnr.mSC);
                com.kascend.chushou.toolkit.a.c.a(this.w, O);
                if (this.mnX != null) {
                    this.mnX.a();
                    this.mnX.a(this.P);
                }
                if (this.mnR != null) {
                    this.mnR.a((PlayUrl) null);
                    this.mnR.f();
                    if (this.mnR.c() != null) {
                        this.mnR.c().clear();
                    }
                    this.mnR.i.clear();
                }
                if (this.mnP != null) {
                    this.mnP.j();
                }
                a(O.toString(), false);
                return;
            }
            tv.chushou.zues.utils.g.JO(a.i.str_same_room);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dwR() {
        FullRoomInfo dxv;
        String str;
        RoomInfo roomInfo;
        if (dwX()) {
            str = null;
            dxv = null;
        } else {
            dxv = this.mnR.dxv();
            str = (dxv == null || (roomInfo = dxv.mRoominfo) == null) ? null : roomInfo.mGameId;
        }
        return !this.L && (dxv == null || h.isEmpty(str));
    }

    @Subscribe
    public void onMessageEvent(i iVar) {
        if (!isFinishing() && iVar.a != 21 && iVar.a != 22) {
            if (iVar.a == 0 && (iVar.b instanceof Boolean)) {
                if (((Boolean) iVar.b).booleanValue() && !isFinishing()) {
                    w();
                    if (this.mnP != null) {
                        this.mnP.f();
                    }
                }
            } else if (iVar.a == 46) {
                if ((iVar.b instanceof String) && this.mnP != null) {
                    this.mnP.c((String) iVar.b);
                }
            } else if (iVar.a == 54) {
                if (iVar.b instanceof String) {
                    this.mok.a((String) iVar.b);
                }
            } else if (iVar.a == 55) {
                if (this.mnP != null) {
                    this.mnP.O();
                }
            } else if (iVar.a == 56 && this.mnP != null) {
                this.mnP.P();
            }
        }
    }

    @Subscribe
    public void onRefreshSubscribeEvent(m mVar) {
        if (isFinishing() && this.mnR != null && this.mnR.dxz() != null) {
            RoomInfo dxz = this.mnR.dxz();
            if (mVar.a(dxz.mCreatorUID, dxz.mRoomID)) {
                dxz.mIsSubscribed = mVar.c;
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
        if (this.m || this.mnM == null || this.mnN == null) {
            R();
        }
        if (this.mnX != null) {
            this.mnX.d();
        }
        if (!dwX()) {
            if (this.moc != null && !this.moc.c()) {
                this.moc.a();
            }
            v();
            if (this.mnR != null && this.mnR.dxv() != null && this.mnR.dxv().cycleLiveRoomInfo != null && !h.isEmpty(this.mnR.dxv().cycleLiveRoomInfo.roomId)) {
                u();
            }
        }
        super.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.view.base.BaseActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        tv.chushou.zues.utils.e.e(this.v, MissionEvent.MESSAGE_DESTROY);
        if (this.mnR != null && this.mnR.dxv() != null && this.mnR.dxv().cycleLiveRoomInfo != null && !h.isEmpty(this.mnR.dxv().cycleLiveRoomInfo.eventName)) {
            j.dwP().a(this.P + dxh());
        }
        if ("2".equals(this.moq) && this.mor != null && this.mor.mwH != null) {
            this.mor.mwH.time = System.currentTimeMillis() - this.mor.b;
            this.mor.a();
            this.mor.b();
        }
        this.moj.d();
        this.mok.b();
        this.mol.b();
        O();
        this.mog = null;
        a = null;
        if (this.mov != null) {
            this.mov.bZ(null);
            this.mov = null;
        }
        if (this.moc != null) {
            this.moc.d();
            this.moc = null;
        }
        if (this.mnX != null) {
            this.mnX.c();
            this.mnX = null;
        }
        if (this.mnR != null) {
            this.mnR.mpw = null;
            this.mnR.mpv = null;
        }
        if (this.mnR != null) {
            this.mnR.b();
            this.mnR = null;
        }
        this.mnK = null;
        this.mnP = null;
        this.mnQ = null;
        this.mnT = null;
        this.mnU = null;
        this.mnV = null;
        this.mnW = null;
        this.bqO = null;
        this.mnY = null;
        this.mnZ = null;
        this.moa = null;
        this.Z = null;
        this.mob = null;
        if (this.mof != null && this.mof.isHeld()) {
            this.mof.release();
            this.mof = null;
        }
        if (this.mou != null) {
            unregisterReceiver(this.mou);
            this.mou = null;
        }
        h.dJY();
        tv.chushou.zues.a.a.ca(this);
        this.mos.dispose();
        this.mol.b();
        this.mom.b();
        this.moj.d();
        this.mok.b();
        this.mop.b();
        super.onDestroy();
        System.gc();
    }

    @Subscribe
    public void onSendGameGiftEvent(n nVar) {
        if (!isFinishing() && this.mnP != null) {
            this.mnP.a(nVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.view.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        tv.chushou.zues.utils.e.d(this.v, MissionEvent.MESSAGE_PAUSE);
        if (this.moc != null) {
            this.moc.b();
        }
        if (this.mnX != null) {
            this.mnX.b(false);
        }
        k();
        this.m = true;
        super.onPause();
    }

    @Override // android.app.Activity
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.mnP != null ? this.mnP.a(motionEvent) : super.onTouchEvent(motionEvent);
    }

    public void c() {
        if ("1".equals(this.R)) {
            j.dwP().a(this.P + dxh());
        } else {
            j.dwP().b(this.P);
        }
    }

    private void a(boolean z, boolean z2) {
        int i = 0;
        tv.chushou.zues.utils.e.i(this.v, "startLoadingVideo <------------- mbPrepareingVideo = " + this.K);
        if (this.mnM != null) {
            this.mnM.setHardwearDecod(com.kascend.chushou.d.h.dwK().a);
        }
        if (this.mnN != null) {
            this.mnN.setHardwearDecod(com.kascend.chushou.d.h.dwK().a);
        }
        if (this.mnL != null) {
            this.mnL.setHardwearDecod(com.kascend.chushou.d.h.dwK().a);
        }
        if (!this.K) {
            if (z && this.mnP != null) {
                if (!z2) {
                    this.t = null;
                    this.mnP.e();
                }
            } else if (this.mnP != null && !z2) {
                this.t = null;
                this.mnP.H = false;
                RxExecutor.post(null, EventThread.MAIN_THREAD, new Runnable() { // from class: com.kascend.chushou.player.VideoPlayer.7
                    @Override // java.lang.Runnable
                    public void run() {
                        VideoPlayer.this.mnP.x();
                    }
                });
            }
            this.K = true;
            if (this.mnR != null && this.mnR.dxw() != null) {
                PlayUrl dxw = this.mnR.dxw();
                while (true) {
                    int i2 = i;
                    if (i2 >= dxw.mUrlDetails.size()) {
                        break;
                    }
                    UrlDetails urlDetails = dxw.mUrlDetails.get(i2);
                    if (urlDetails.mUrl.equals(dxw.mSelectedUrl)) {
                        String str = dxw.mUrlDetails.get(i2).mDefinitionType;
                        String str2 = urlDetails.mBitrate;
                    }
                    i = i2 + 1;
                }
            }
            if (z2) {
                if (this.d) {
                    this.mnM.setVideoURI(this.mnK);
                    this.mnM.open();
                    return;
                }
                this.mnN.setVideoURI(this.mnK);
                this.mnN.open();
                return;
            }
            this.mnL.setVideoURI(this.mnK);
            this.mnL.open();
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        try {
            if (motionEvent.getAction() == 0) {
                if (this.mnP != null && this.mnP.b(motionEvent)) {
                    return true;
                }
                if ("2".equals(this.moq) && this.mnP != null) {
                    this.mnP.a(motionEvent);
                }
            } else if (this.mnP != null && this.mnP.b(motionEvent)) {
                return true;
            }
            return super.dispatchTouchEvent(motionEvent);
        } catch (Exception e) {
            return false;
        }
    }

    @Override // android.support.v7.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.mnP != null && this.mnP.a(i, keyEvent)) {
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
        if (this.mnR != null && this.mnR.dxv() != null && this.mnR.dxv().cycleLiveRoomInfo != null && !h.isEmpty(this.mnR.dxv().cycleLiveRoomInfo.roomId)) {
            this.moi.setVisibility(0);
            this.moh.setBlur(true);
            this.moh.i(this.mnR.dxv().cycleLiveRoomInfo.avatar, 0, 0, 0);
            this.moh.setVisibility(0);
            j.dwP().a(this.P + dxh());
            this.mnK = null;
            R();
            this.Q = this.mnR.dxv().cycleLiveRoomInfo.roomId;
            a(this.P, dxh(), false);
        }
    }

    public void b(boolean z) {
        if (this.mnP != null) {
            this.mnP.j(z);
        }
    }

    public void a(boolean z, Uri uri, boolean z2) {
        tv.chushou.zues.utils.e.d(this.v, "loadIfNecessary reload=" + z + " isChangeLines-->" + z2);
        if (this.mnM != null && this.mnN != null) {
            if (uri != null) {
                this.mnK = uri;
            }
            if (z2) {
                this.e = z2;
            }
            this.M = false;
            this.mnS = 0L;
            this.O = 0;
            this.mov.removeMessages(7);
            if (z) {
                if (z2) {
                    if (!this.d) {
                        this.mnN.setOnActivityCallBack(this.moz);
                    } else {
                        this.mnM.setOnActivityCallBack(this.moy);
                    }
                } else if (this.d) {
                    this.mnN.setOnActivityCallBack(this.moz);
                } else {
                    this.mnM.setOnActivityCallBack(this.moy);
                }
                this.K = false;
                b(true, z2);
            } else if (!this.J) {
                b(true, z2);
            }
            this.mov.A(6, 3000L);
        }
    }

    private void b(boolean z, boolean z2) {
        VideoPlayInfo N;
        if ("1".equals(this.R)) {
            N = j.dwP().M(this.P + dxh(), KeepJobService.JOB_CHECK_PERIODIC);
        } else {
            N = j.dwP().N(this.P, KeepJobService.JOB_CHECK_PERIODIC);
        }
        if (N != null) {
            a(z, z2);
        } else if ("1".equals(this.R)) {
            a(this.P, dxh(), false);
        } else {
            aL(this.P, false);
        }
    }

    public tv.chushou.common.player.a dwS() {
        return this.mnL;
    }

    public tv.chushou.common.player.a dwT() {
        return this.mnM;
    }

    public tv.chushou.common.player.a dwU() {
        return this.mnN;
    }

    public void a(tv.chushou.common.player.a aVar) {
        this.mnL = aVar;
    }

    public b dwV() {
        return this.mnR;
    }

    public com.kascend.chushou.widget.a.b dwW() {
        return this.mnX;
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
        FullRoomInfo dxv;
        this.r = -1L;
        if (this.s != -1 && this.s != 0) {
            this.r = this.s;
            this.s = -1L;
        }
        if (dwX() && this.mnL != null && this.mnL.getPlayState() == 4) {
            this.r = this.mnL.getCurrentPos();
        }
        this.av = false;
        tv.chushou.zues.utils.e.d(this.v, "screenChange()<-----");
        tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard(this);
        if (str != null) {
            this.R = str;
        }
        if (!this.C || !z3 || "3".equals(this.R) || this.mnR == null || (dxv = this.mnR.dxv()) == null || dxv.mRoominfo == null || dxv.mRoominfo.mStyle != 1) {
            z5 = false;
        } else {
            z5 = true;
            i = 0;
        }
        if ("2".equals(this.moq)) {
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
            if (com.kascend.chushou.b.dwD().d == 1) {
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
            ((VideoPlayer) this.w).wa(false);
            ((VideoPlayer) this.w).g(true);
            if (z5) {
                setRequestedOrientation(1);
            } else {
                setRequestedOrientation(6);
            }
            getWindow().addFlags(512);
            getWindow().addFlags(256);
        }
        if (this.mnX == null) {
            this.mnX = new com.kascend.chushou.widget.a.b();
        }
        if (this.mnX != null) {
            this.mnX.a(this.P);
        }
        if (this.R.equals("5")) {
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            if (this.mnP != null) {
                beginTransaction.remove(this.mnP);
                this.mnP = null;
            }
            if (this.mnQ != null) {
                beginTransaction.remove(this.mnQ);
                this.mnQ = null;
            }
            this.mnQ = new com.kascend.chushou.view.user.b();
            beginTransaction.add(a.f.fl_fragment, this.mnQ);
            beginTransaction.commitAllowingStateLoss();
        } else {
            FragmentTransaction beginTransaction2 = getSupportFragmentManager().beginTransaction();
            if (this.mnP != null) {
                beginTransaction2.remove(this.mnP);
                this.mnP = null;
            }
            if (this.mnQ != null) {
                beginTransaction2.remove(this.mnQ);
                this.mnQ = null;
            }
            if ("2".equals(this.moq)) {
                this.mnP = com.kascend.chushou.player.e.e.a(this.ab, z2, this.aq, this.P);
            } else if (1 == i) {
                if (!this.R.equals("3")) {
                    if (z4) {
                        v();
                    }
                    this.mnP = new com.kascend.chushou.player.d.a();
                    Bundle bundle = new Bundle();
                    bundle.putString("mCover", this.ab);
                    bundle.putBoolean("mInitViewAsync", z2);
                    this.mnP.setArguments(bundle);
                }
            } else {
                this.mnP = new com.kascend.chushou.player.d.b();
                Bundle bundle2 = new Bundle();
                if (z5) {
                    i = 1;
                }
                bundle2.putInt("mExtraOrientation", i);
                bundle2.putString("mViewType", this.R);
                this.mnP.setArguments(bundle2);
            }
            beginTransaction2.add(a.f.fl_fragment, this.mnP);
            beginTransaction2.commitAllowingStateLoss();
            this.H = true;
        }
        tv.chushou.zues.utils.e.d(this.v, "screenChange()----->");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dwX() {
        return this.R != null && this.R.equals("3");
    }

    private void R() {
        if (this.mnP != null) {
            this.mnP.msP = null;
        }
        if (this.mnL != null) {
            this.mnL.release();
            this.mnL = null;
            this.K = false;
        }
        if (this.mnM != null) {
            this.mnM.release();
            this.mnM = null;
        }
        if (this.mnN != null) {
            this.mnN.release();
            this.mnN = null;
        }
        if (this.mnO != null) {
            this.mnO.c();
        }
        this.d = false;
        this.e = false;
        this.M = false;
        this.mnO = new c();
        this.mnM = this.mnO.dxC();
        this.mnM.setOnActivityCallBack(this.moy);
        this.mnN = this.mnO.dxD();
        this.mnN.setOnActivityCallBack(this.moz);
        if (!this.d) {
            this.mnL = this.mnM;
        } else {
            this.mnL = this.mnN;
        }
        if (this.mnP != null) {
            this.mnP.msP = this.mnL;
        }
    }

    public void j() {
        if (this.mnL != null) {
            this.mnL.pause();
            this.mnL.stop();
            this.mnL.release();
            this.mnL = null;
        }
        if (this.mnM != null) {
            this.mnM.stop();
            this.mnM.release();
            this.mnM = null;
        }
        if (this.mnN != null) {
            this.mnN.stop();
            this.mnN.release();
            this.mnN = null;
        }
        if (this.mnO != null) {
            this.mnO.c();
        }
    }

    public void k() {
        tv.chushou.common.player.a aVar = this.mnL;
        if (aVar != null) {
            aVar.pause();
            aVar.stop();
        }
        tv.chushou.common.player.a aVar2 = this.mnM;
        if (aVar2 != null) {
            aVar2.stop();
        }
        tv.chushou.common.player.a aVar3 = this.mnN;
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
    public void dlc() {
        if (this.av) {
            if (this.mnP != null) {
                this.mnP.s();
            }
        } else if (this.mov != null) {
            this.mov.a(this.mov.JH(3), 20L);
        }
    }

    private void b(final String str, String str2) {
        com.kascend.chushou.c.c.dwG().a(new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.VideoPlayer.8
            @Override // com.kascend.chushou.c.b
            public void a() {
                VideoPlayer.this.L = true;
            }

            @Override // com.kascend.chushou.c.b
            public void a(String str3, JSONObject jSONObject) {
                boolean z = false;
                if (!VideoPlayer.this.isFinishing()) {
                    ParserRet q = com.kascend.chushou.c.f.q(str, jSONObject);
                    if (q.mRc != 0 || q.mData == null) {
                        VideoPlayer.this.bO(q.mMessage, q.mRc);
                        return;
                    }
                    FullRoomInfo fullRoomInfo = (FullRoomInfo) q.mData;
                    VideoPlayer.this.dxf().a(fullRoomInfo.mBangMap);
                    if (h.isEmpty(fullRoomInfo.mRoominfo.mRoomID)) {
                        fullRoomInfo.mRoominfo.mRoomID = VideoPlayer.this.P;
                    }
                    if (!h.isEmpty(fullRoomInfo.mGeneralTabGifts)) {
                        com.kascend.chushou.d.e.a(VideoPlayer.this.mos, new ArrayList(fullRoomInfo.mGeneralTabGifts));
                    }
                    if (VideoPlayer.this.mnR != null) {
                        VideoPlayer.this.mnR.a(fullRoomInfo);
                    }
                    VideoPlayer.this.L = false;
                    if (VideoPlayer.this.B) {
                        if (VideoPlayer.this.C && !"3".equals(VideoPlayer.this.R) && fullRoomInfo != null && fullRoomInfo.mRoominfo != null && fullRoomInfo.mRoominfo.mStyle == 1 && !h.isEmpty(fullRoomInfo.mRoominfo.mGameId)) {
                            z = true;
                        }
                        if (!z) {
                            if (VideoPlayer.this.mnP != null) {
                                VideoPlayer.this.mnP.a(VideoPlayer.this.mnR);
                            }
                            if (!h.isEmpty(fullRoomInfo.mRoominfo.mGameId)) {
                                VideoPlayer.this.dlc();
                            } else {
                                if (VideoPlayer.this.mnR != null) {
                                    VideoPlayer.this.mnR.f = null;
                                }
                                VideoPlayer.this.dlc();
                            }
                        } else {
                            VideoPlayer.this.a(1, "1", true);
                            if (VideoPlayer.this.mnP != null) {
                                VideoPlayer.this.mnP.a(VideoPlayer.this.mnR);
                            }
                        }
                    } else {
                        if (h.isEmpty(fullRoomInfo.mRoominfo.mGameId)) {
                            if (VideoPlayer.this.mnR != null) {
                                VideoPlayer.this.mnR.f = null;
                            }
                            VideoPlayer.this.a(1, "1");
                        } else {
                            VideoPlayer.this.a(1, "1", true);
                        }
                        if (VideoPlayer.this.mnP != null) {
                            VideoPlayer.this.mnP.a(VideoPlayer.this.mnR);
                        }
                    }
                    if (VideoPlayer.this.mnR != null && !VideoPlayer.this.mnR.m()) {
                        if (VideoPlayer.this.moc != null) {
                            VideoPlayer.this.moc.d();
                            VideoPlayer.this.moc = null;
                        }
                        VideoPlayer.this.moc = new com.kascend.chushou.toolkit.d(900000L, VideoPlayer.this.moe, VideoPlayer.this.mov);
                        VideoPlayer.this.moc.a();
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
        if (this.mnR != null) {
            this.mnR.a((FullRoomInfo) null);
        }
        this.L = false;
        c(str, i);
        if (this.mnL != null) {
            this.mnL.stop();
        }
        if (this.mnM != null) {
            this.mnM.stop();
        }
        if (this.mnN != null) {
            this.mnN.stop();
        }
    }

    public void l() {
        tv.chushou.zues.utils.e.d(this.v, "retryGetPlayList");
        c();
        if (dwX()) {
            aL(this.P, false);
        } else {
            a(this.P, dxh(), false);
        }
    }

    public void m() {
        a(this.mog, false);
    }

    private void a(final String str, String str2, boolean z) {
        this.J = true;
        VideoPlayInfo M = j.dwP().M(str + str2, KeepJobService.JOB_CHECK_PERIODIC);
        if (M != null) {
            a((ArrayList) M.mPlayUrls);
            this.J = false;
        } else if (z) {
            ParserRet fj = com.kascend.chushou.player.c.a.dxE().fj(str, str2);
            if (fj.mRc != 0) {
                tv.chushou.zues.utils.e.e(this.v, "getPlayUrlSync fail, try to getPlaylist");
                a(str, str2, false);
                return;
            }
            a(fj, str);
        } else {
            com.kascend.chushou.player.c.a.dxE().a(str, str2, new a.InterfaceC0720a() { // from class: com.kascend.chushou.player.VideoPlayer.9
                @Override // com.kascend.chushou.player.c.a.InterfaceC0720a
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
    private void aL(final String str, boolean z) {
        boolean equals;
        this.J = true;
        VideoPlayInfo N = j.dwP().N(str, KeepJobService.JOB_CHECK_PERIODIC);
        if (N != null) {
            a((ArrayList) N.mPlayUrls);
            this.J = false;
            return;
        }
        if (!h.isEmpty(this.mog)) {
            try {
                equals = "1".equals(new JSONObject(this.mog).optString("auto"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (!z) {
                ParserRet aM = com.kascend.chushou.player.c.a.dxE().aM(str, equals);
                if (aM.mRc != 0) {
                    tv.chushou.zues.utils.e.e(this.v, "getVideoPlayUrlSync fail, try to getVideoPlaylist");
                    aL(str, false);
                    return;
                }
                a(aM, str);
                return;
            }
            com.kascend.chushou.player.c.a.dxE().a(str, new a.InterfaceC0720a() { // from class: com.kascend.chushou.player.VideoPlayer.10
                @Override // com.kascend.chushou.player.c.a.InterfaceC0720a
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
                if (this.mnR.f == null) {
                    this.mnR.f = new ArrayList<>();
                }
                this.mnR.f.clear();
                this.mnR.f.addAll(arrayList);
                if ("1".equals(this.R)) {
                    j.dwP().a(str + dxh(), arrayList);
                } else {
                    j.dwP().t(str, arrayList);
                }
                a(arrayList);
                return;
            }
            if (this.mnR != null) {
                this.mnR.f = null;
            }
            if (this.mov != null) {
                Message JH = this.mov.JH(5);
                JH.arg1 = 2;
                JH.arg2 = parserRet.mRc;
                this.mov.N(JH);
            }
        }
    }

    private void c(String str, int i) {
        s();
        if (this.mnX != null) {
            this.mnX.a();
        }
        if (h.isEmpty(str)) {
            str = getString(a.i.str_load_data_failed);
        }
        a(str, i);
    }

    public void n() {
        if (this.moa != null && this.bqO != null && this.mob != null) {
            this.moa.setVisibility(0);
            this.bqO.setVisibility(8);
            this.mob.setVisibility(8);
        }
    }

    public void o() {
        if (this.moh != null && this.moh.getVisibility() == 0) {
            this.moh.xW(0);
            this.moh.setVisibility(8);
        }
    }

    public void p() {
        if (this.moi != null && this.moi.getVisibility() == 0) {
            this.moi.setVisibility(8);
        }
    }

    public void q() {
        this.av = true;
    }

    protected void r() {
        this.moa.setVisibility(8);
        this.mob.setVisibility(0);
        this.bqO.setVisibility(0);
        if (this.mnW != null) {
            this.mnU.setVisibility(8);
            this.mnW.setVisibility(0);
            this.mnV.setText(getString(a.i.str_dialog_loading_content));
            this.mnV.setVisibility(8);
        }
    }

    protected void a(String str, int i) {
        this.moa.setVisibility(8);
        this.mob.setVisibility(0);
        this.bqO.setVisibility(0);
        if (this.mnW != null) {
            if (str == null) {
                str = getString(a.i.str_nodata);
            }
            if (str != null) {
                this.mnV.setText(str);
                if (str.equals(getString(a.i.s_no_available_network))) {
                    this.mnU.setImageResource(a.e.commonres_pagestatus_net_error);
                } else if (str.equals(getString(a.i.str_nodata)) || str.equals(getString(a.i.str_nohistory)) || str.equals(getString(a.i.str_nolive)) || str.equals(getString(a.i.str_nosubscribe))) {
                    this.mnU.setClickable(true);
                    this.mnU.setImageResource(a.e.commonres_pagestatus_empty);
                } else if (str.equals(getString(a.i.str_inbox_login_notify)) || str.equals(getString(a.i.push_login)) || str.equals(getString(a.i.str_login_timeout))) {
                    this.mnU.setImageResource(a.e.commonres_pagestatus_need_login);
                    this.mnU.setClickable(true);
                } else {
                    this.mnU.setImageResource(a.e.commonres_pagestatus_unknown_error);
                    this.mnU.setClickable(true);
                }
            }
            if (i == 4001) {
                this.mnU.setImageResource(a.e.commonres_pagestatus_net_error);
                this.mnU.setClickable(false);
                this.mnV.setVisibility(0);
                this.mnV.setText(getString(a.i.str_dissubscribe_btn));
                this.mnV.setOnClickListener(new View.OnClickListener() { // from class: com.kascend.chushou.player.VideoPlayer.11
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (!VideoPlayer.this.j) {
                            com.kascend.chushou.c.c.dwG().b(new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.VideoPlayer.11.1
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
                            }, VideoPlayer.this.P, (String) null, VideoPlayer.this.mnR.h);
                        }
                    }
                });
            } else if (i == 404) {
                this.mnV.setText(str);
                this.mnV.setVisibility(0);
                this.mnU.setClickable(false);
                this.mnU.setImageResource(a.e.commonres_pagestatus_empty);
            } else if (i == 4002) {
                if (h.isEmpty(str)) {
                    this.mnV.setVisibility(8);
                } else {
                    this.mnV.setVisibility(0);
                    this.mnV.setText(str);
                }
            } else {
                this.mnV.setVisibility(8);
            }
            this.mnU.setVisibility(0);
            this.mnW.setVisibility(8);
            this.moi.setVisibility(8);
        }
    }

    public void s() {
        if (this.mov != null) {
            this.mov.removeMessages(1);
        }
    }

    private void a(ArrayList<PlayUrl> arrayList) {
        boolean z;
        if (this.mnR.f == null) {
            this.mnR.f = new ArrayList<>();
        }
        this.mnR.f.clear();
        this.mnR.f.addAll(arrayList);
        if (com.kascend.chushou.d.e.b() && !"4".equals(this.aq)) {
            int c = com.kascend.chushou.d.e.c();
            if (c == -1) {
                b(arrayList);
                return;
            } else if (this.mow) {
                this.mow = false;
                if (c == 0) {
                    this.mnR.d = false;
                    f(arrayList, true);
                    return;
                }
                if (this.mnR != null && this.mnR.f != null) {
                    Iterator<PlayUrl> it = this.mnR.f.iterator();
                    while (it.hasNext()) {
                        if ("2".equals(it.next().mType)) {
                            z = true;
                            break;
                        }
                    }
                }
                z = false;
                this.mnR.d = z;
                f(arrayList, true);
                return;
            } else {
                if (this.mnR.e) {
                    this.mnR.d = !this.mnR.d;
                    this.mnR.e = false;
                    this.mox = true;
                } else if ("4".equals(this.aq)) {
                    this.mnR.d = true;
                }
                f(arrayList, true);
                return;
            }
        }
        if (this.mnR.e) {
            this.mnR.d = !this.mnR.d;
            this.mnR.e = false;
            this.mox = true;
        } else if ("4".equals(this.aq)) {
            this.mnR.d = true;
        }
        f(arrayList, true);
    }

    private void b(ArrayList<PlayUrl> arrayList) {
        if ("1".equals(this.R)) {
            if ("2".equals(this.moq)) {
                d(false, arrayList);
            } else if (this.mnP != null) {
                this.mnP.f(arrayList, false);
            }
        } else if (this.mnP != null) {
            this.mnP.f(arrayList, false);
        }
    }

    public void c(boolean z) {
        this.mnR.d = false;
        com.kascend.chushou.d.e.a(0);
        ArrayList<PlayUrl> arrayList = this.mnR.f;
        if (!h.isEmpty(arrayList)) {
            if (z) {
                f(arrayList, false);
                if (this.mov != null) {
                    this.mov.JF(2);
                    return;
                }
                return;
            }
            f(arrayList, true);
        }
    }

    public void d(boolean z) {
        this.mnR.d = true;
        com.kascend.chushou.d.e.a(1);
        ArrayList<PlayUrl> arrayList = this.mnR.f;
        if (!h.isEmpty(arrayList)) {
            if (z) {
                f(arrayList, false);
                if (this.mov != null) {
                    this.mov.JF(2);
                    return;
                }
                return;
            }
            f(arrayList, true);
        }
    }

    @Subscribe
    public void onNotifyEvent(com.kascend.chushou.b.a.a.j jVar) {
        if (!isFinishing() && jVar.a == 1 && !"5".equals(this.R) && !dwR()) {
            tv.chushou.zues.utils.e.d(this.v, "onNetworkChangeEvent 3G=" + com.kascend.chushou.b.dwD().b + "  wifi=" + com.kascend.chushou.b.dwD().a);
            if (com.kascend.chushou.d.e.b() && !"4".equals(this.aq)) {
                if (com.kascend.chushou.d.e.c() == -1) {
                    if (this.mnP != null) {
                        this.mnP.e(false);
                    }
                    if ("1".equals(this.R)) {
                        if ("2".equals(this.moq)) {
                            d(true, null);
                            return;
                        } else if (this.mnP != null) {
                            this.mnP.f(this.mnR.f, true);
                            return;
                        } else {
                            return;
                        }
                    } else if (this.mnP != null) {
                        this.mnP.f(this.mnR.f, true);
                        return;
                    } else {
                        return;
                    }
                }
                RxExecutor.postDelayed(this.mos, EventThread.MAIN_THREAD, 10L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.VideoPlayer.12
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!VideoPlayer.this.isFinishing() && com.kascend.chushou.b.dwD().b && !com.kascend.chushou.b.dwD().a) {
                            tv.chushou.zues.utils.g.c(VideoPlayer.this.w, VideoPlayer.this.getString(a.i.str_monet_notify));
                        }
                    }
                });
            } else if (com.kascend.chushou.b.dwD().a || com.kascend.chushou.b.dwD().b) {
                t();
                if (this.mov != null) {
                    this.mov.JF(2);
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
            if (this.mnR.d) {
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
            String d = com.kascend.chushou.d.h.dwK().d();
            String str3 = h.isEmpty(d) ? "2" : d;
            if (this.mnR.d) {
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
                if (this.mnR != null) {
                    this.mnR.a(playUrl2);
                    if (this.mov != null) {
                        Message JH = this.mov.JH(5);
                        JH.arg1 = 1;
                        this.mov.N(JH);
                    }
                }
                String b = com.kascend.chushou.player.c.a.b(playUrl2);
                if (!h.isEmpty(b)) {
                    this.mnK = Uri.parse(b);
                    if (this.mox) {
                        this.mox = false;
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (z && this.mnL != null) {
                        a(false, z2);
                    }
                }
            }
        }
    }

    public void d(final boolean z, ArrayList<PlayUrl> arrayList) {
        if (this.mod == null || this.mod.a <= 0) {
            this.mod = com.kascend.chushou.view.b.a.a.dyP();
            this.mod.a(new a.InterfaceC0739a() { // from class: com.kascend.chushou.player.VideoPlayer.13
                @Override // com.kascend.chushou.view.b.a.a.InterfaceC0739a
                public void a(int i) {
                    if (i == a.f.tv_play_video) {
                        VideoPlayer.this.mod.dismissAllowingStateLoss();
                        VideoPlayer.this.c(z);
                    } else if (i == a.f.tv_play_audio) {
                        VideoPlayer.this.mod.dismissAllowingStateLoss();
                        VideoPlayer.this.d(z);
                    } else if (i == a.f.iv_close) {
                        VideoPlayer.this.finish();
                    } else {
                        if (i == a.f.tv_union_proxy) {
                        }
                    }
                }
            });
            this.mod.show(getSupportFragmentManager(), "showRoom");
        }
    }

    public void t() {
        if (this.mod != null) {
            this.mod.dismissAllowingStateLoss();
        }
        if (this.mnP != null) {
            this.mnP.v();
        }
    }

    public void u() {
        com.kascend.chushou.c.c.dwG().c(this.P, new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.VideoPlayer.16
            @Override // com.kascend.chushou.c.b
            public void a() {
            }

            @Override // com.kascend.chushou.c.b
            public void a(String str, JSONObject jSONObject) {
                if (!VideoPlayer.this.isFinishing()) {
                    ParserRet dD = com.kascend.chushou.c.e.dD(jSONObject);
                    if (dD.mRc == 0 && dD.mData != null) {
                        CycleLiveRoomInfo cycleLiveRoomInfo = (CycleLiveRoomInfo) dD.mData;
                        if (VideoPlayer.this.mnR != null && cycleLiveRoomInfo != null && !h.isEmpty(cycleLiveRoomInfo.roomId)) {
                            FullRoomInfo dxv = VideoPlayer.this.mnR.dxv();
                            if (dxv.cycleLiveRoomInfo == null) {
                                dxv.cycleLiveRoomInfo = cycleLiveRoomInfo;
                                VideoPlayer.this.d();
                            } else if (dxv.cycleLiveRoomInfo != null && !cycleLiveRoomInfo.roomId.equals(dxv.cycleLiveRoomInfo.roomId)) {
                                dxv.cycleLiveRoomInfo.copyCycleLiveRoomInfo(cycleLiveRoomInfo);
                                VideoPlayer.this.d();
                            } else {
                                dxv.cycleLiveRoomInfo.copyCycleLiveRoomInfo(cycleLiveRoomInfo);
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
        if (this.mnP != null) {
            this.mnP.N();
        }
    }

    public void v() {
        com.kascend.chushou.c.c.dwG().a(this.P, new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.VideoPlayer.17
            @Override // com.kascend.chushou.c.b
            public void a() {
            }

            @Override // com.kascend.chushou.c.b
            public void a(String str, JSONObject jSONObject) {
                if (!VideoPlayer.this.isFinishing()) {
                    ParserRet dE = com.kascend.chushou.c.e.dE(jSONObject);
                    if (dE.mRc == 0 && dE.mData != null) {
                        PkNotifyInfo pkNotifyInfo = (PkNotifyInfo) dE.mData;
                        VideoPlayer.this.moo.b = VideoPlayer.this.P;
                        if (pkNotifyInfo != null) {
                            VideoPlayer.this.moo.msQ = pkNotifyInfo;
                            if (VideoPlayer.this.mnP != null) {
                                VideoPlayer.this.mnP.a(pkNotifyInfo, VideoPlayer.this.P);
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
        if (this.mnT != null) {
            this.mnT.release();
            this.mnT = null;
        }
        com.kascend.chushou.c.c.dwG().a(this.P, new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.VideoPlayer.18
            @Override // com.kascend.chushou.c.b
            public void a() {
            }

            @Override // com.kascend.chushou.c.b
            public void a(String str, JSONObject jSONObject) {
                if (!VideoPlayer.this.isFinishing()) {
                    ParserRet dF = com.kascend.chushou.c.e.dF(jSONObject);
                    if (dF.mRc == 0 && dF.mData != null) {
                        RoomExpandInfo roomExpandInfo = (RoomExpandInfo) dF.mData;
                        if (VideoPlayer.this.mnR != null) {
                            VideoPlayer.this.mnR.mpx = roomExpandInfo.mTopWebAdItem;
                            if (VideoPlayer.this.mnR.s == null) {
                                VideoPlayer.this.mnR.s = new ArrayList();
                            }
                            VideoPlayer.this.mnR.s.clear();
                            VideoPlayer.this.mnR.s.addAll(roomExpandInfo.mGiftTopRightIcons);
                            tv.chushou.zues.a.a.post(new i(50, VideoPlayer.this.mnR.mpx));
                        }
                        if (VideoPlayer.this.mnR != null) {
                            VideoPlayer.this.mnR.fa(roomExpandInfo.mExpandNavList);
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
                            VideoPlayer.this.moj.a(list);
                        }
                        List<com.kascend.chushou.player.ui.h5.c.c> list2 = roomExpandInfo.mLuckList;
                        if (!h.isEmpty(list2)) {
                            VideoPlayer.this.mok.a(list2);
                        }
                        com.kascend.chushou.player.ui.h5.c.c cVar = roomExpandInfo.mVoteItem;
                        if (cVar != null) {
                            VideoPlayer.this.mol.a(cVar);
                        }
                        List<com.kascend.chushou.player.ui.h5.c.b> list3 = roomExpandInfo.mInteractH5Item;
                        if (!h.isEmpty(list3)) {
                            VideoPlayer.this.mop.a(list3);
                        }
                        List<com.kascend.chushou.player.ui.h5.c.b> list4 = roomExpandInfo.mInteractNavItem;
                        if (!h.isEmpty(list4)) {
                            VideoPlayer.this.mop.a(list4);
                        }
                        VideoPlayer.this.mnT = (PrivilegeInfo) dF.mData1;
                        if (VideoPlayer.this.mnT != null) {
                            tv.chushou.zues.a.a.post(new l());
                        }
                        if (VideoPlayer.this.mnR != null) {
                            VideoPlayer.this.mnR.mpD = roomExpandInfo.mIconConfig;
                            VideoPlayer.this.dxf().a(roomExpandInfo.mIconConfig.bangConfig);
                        }
                        List<SkinConfig> list5 = roomExpandInfo.skinConfig;
                        if (list5 != null && VideoPlayer.this.mnR != null) {
                            VideoPlayer.this.mnR.mpH.clear();
                            int i = 0;
                            while (true) {
                                int i2 = i;
                                if (i2 >= list5.size()) {
                                    break;
                                }
                                SkinConfig skinConfig = list5.get(i2);
                                VideoPlayer.this.mnR.mpH.put(skinConfig.position, skinConfig.resource);
                                i = i2 + 1;
                            }
                            VideoPlayer.this.C();
                        }
                        VideoPlayer.this.a(roomExpandInfo.mIconConfig, VideoPlayer.this.mnR != null ? VideoPlayer.this.mnR.mpH : null);
                        if (roomExpandInfo.mColorMap != null && roomExpandInfo.mColorMap.size() > 0 && com.kascend.chushou.b.dwD().c != null && com.kascend.chushou.b.dwD().c.size() <= 0) {
                            com.kascend.chushou.b.dwD().c.putAll(roomExpandInfo.mColorMap);
                            tv.chushou.zues.a.a.post(new i(52, null));
                        }
                        AutoBang autoBang = roomExpandInfo.mAutoBang;
                        if (autoBang != null && autoBang.currentTime != 0 && autoBang.bangTime != 0) {
                            VideoPlayer.this.dxf().a(autoBang);
                        }
                        if (!h.isEmpty(roomExpandInfo.mRelatedRoomList) && VideoPlayer.this.mnR != null) {
                            VideoPlayer.this.mnR.t = roomExpandInfo.mRelatedRoomList;
                            if (VideoPlayer.this.mnP != null && VideoPlayer.this.H) {
                                VideoPlayer.this.mnP.w();
                            }
                        }
                        if (roomExpandInfo.mRoomNewUserInfo != null && roomExpandInfo.mRoomNewUserInfo.mBarrierNoviceGuide && !com.kascend.chushou.d.h.dwK().k() && VideoPlayer.this.mnP != null) {
                            VideoPlayer.this.mnP.J();
                        }
                        if (roomExpandInfo.mRoomNewUserInfo != null && roomExpandInfo.mRoomNewUserInfo.mRewardNoviceGuide && !com.kascend.chushou.d.h.dwK().l() && VideoPlayer.this.mnP != null) {
                            VideoPlayer.this.mnP.K();
                        }
                        if (!h.isEmpty(roomExpandInfo.mShopWindowInfos)) {
                            if (VideoPlayer.this.mnR != null) {
                                if (VideoPlayer.this.mnR.mpE == null) {
                                    VideoPlayer.this.mnR.mpE = new ArrayList();
                                }
                                VideoPlayer.this.mnR.mpE.addAll(roomExpandInfo.mShopWindowInfos);
                            }
                            if (VideoPlayer.this.mnP != null) {
                                VideoPlayer.this.mnP.L();
                            }
                        }
                        VideoPlayer.this.moo.b = VideoPlayer.this.P;
                        if (roomExpandInfo.mPkNotifyInfo != null) {
                            VideoPlayer.this.moo.msQ = roomExpandInfo.mPkNotifyInfo;
                            if (VideoPlayer.this.mnP != null) {
                                VideoPlayer.this.mnP.a(roomExpandInfo.mPkNotifyInfo, VideoPlayer.this.P);
                            }
                        } else {
                            VideoPlayer.this.moo.msQ = null;
                        }
                        if (roomExpandInfo.mTrumpetPocket != null && VideoPlayer.this.mnR != null) {
                            VideoPlayer.this.mnR.mpG = roomExpandInfo.mTrumpetPocket;
                            if (VideoPlayer.this.mnP != null) {
                                VideoPlayer.this.mnP.M();
                            }
                        }
                        if (!h.isEmpty(roomExpandInfo.hotwordContentList)) {
                            if (VideoPlayer.this.mnR != null) {
                                if (VideoPlayer.this.mnR.mpF == null) {
                                    VideoPlayer.this.mnR.mpF = new ArrayList();
                                }
                                VideoPlayer.this.mnR.mpF.clear();
                                VideoPlayer.this.mnR.mpF.addAll(roomExpandInfo.hotwordContentList);
                            }
                            if (VideoPlayer.this.mnP != null) {
                                VideoPlayer.this.mnP.b(roomExpandInfo.hotwordContentList);
                            }
                        }
                        VideoPlayer.this.U();
                        return;
                    }
                    a(dF.mRc, dF.mMessage);
                }
            }

            @Override // com.kascend.chushou.c.b
            public void a(int i, String str) {
                tv.chushou.zues.utils.e.e(VideoPlayer.this.v, "get room gift popup list failed, rc =" + i + ", errorMsg=" + str);
            }
        }, this.mog, this.moq);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U() {
        if (!h.isEmpty(com.kascend.chushou.a.a.dwE().z)) {
            StringBuilder sb = new StringBuilder();
            if (com.kascend.chushou.a.a.dwE().z.contains(com.kascend.chushou.a.a.f)) {
                if (sb.length() > 0) {
                    sb.append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                sb.append(com.kascend.chushou.a.a.f);
            }
            if (com.kascend.chushou.a.a.dwE().z.contains(com.kascend.chushou.a.a.g)) {
                if (sb.length() > 0) {
                    sb.append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                sb.append(com.kascend.chushou.a.a.g);
            }
            if (com.kascend.chushou.a.a.dwE().z.contains(com.kascend.chushou.a.a.i)) {
                if (sb.length() > 0) {
                    sb.append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                sb.append(com.kascend.chushou.a.a.i);
            }
            if (com.kascend.chushou.a.a.dwE().z.contains(com.kascend.chushou.a.a.h)) {
                if (sb.length() > 0) {
                    sb.append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                sb.append(com.kascend.chushou.a.a.h);
            }
            if (com.kascend.chushou.a.a.dwE().z.contains(com.kascend.chushou.a.a.j)) {
                if (sb.length() > 0) {
                    sb.append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                sb.append(com.kascend.chushou.a.a.j);
            }
            if (com.kascend.chushou.a.a.dwE().z.contains(com.kascend.chushou.a.a.l)) {
                if (sb.length() > 0) {
                    sb.append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                sb.append(com.kascend.chushou.a.a.l);
            }
            if (com.kascend.chushou.a.a.dwE().z.contains(com.kascend.chushou.a.a.m)) {
                if (sb.length() > 0) {
                    sb.append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                sb.append(com.kascend.chushou.a.a.m);
            }
            if (sb.length() != 0) {
                com.kascend.chushou.a.a.dwE().a(sb.toString(), this.P, new a.c() { // from class: com.kascend.chushou.player.VideoPlayer.19
                    @Override // com.kascend.chushou.a.a.c
                    public void a(List<ListItem> list) {
                        if (VideoPlayer.this.mnR != null && list != null) {
                            int i = 0;
                            while (true) {
                                int i2 = i;
                                if (i2 >= list.size()) {
                                    break;
                                }
                                if (list.get(i2).mAdExtraInfo != null) {
                                    if (com.kascend.chushou.a.a.f.equals(list.get(i2).mAdExtraInfo.mCode)) {
                                        VideoPlayer.this.mnR.mpw = list.get(i2);
                                    } else if (com.kascend.chushou.a.a.g.equals(list.get(i2).mAdExtraInfo.mCode)) {
                                        VideoPlayer.this.mnR.mpv = list.get(i2);
                                    } else if (com.kascend.chushou.a.a.i.equals(list.get(i2).mAdExtraInfo.mCode)) {
                                        VideoPlayer.this.mnR.mpy = list.get(i2);
                                    } else if (com.kascend.chushou.a.a.h.equals(list.get(i2).mAdExtraInfo.mCode)) {
                                        VideoPlayer.this.mnR.mpz = list.get(i2);
                                    } else if (com.kascend.chushou.a.a.j.equals(list.get(i2).mAdExtraInfo.mCode)) {
                                        VideoPlayer.this.mnR.mpC = list.get(i2);
                                    } else if (com.kascend.chushou.a.a.l.equals(list.get(i2).mAdExtraInfo.mCode)) {
                                        VideoPlayer.this.mnR.mpA = list.get(i2);
                                    } else if (com.kascend.chushou.a.a.m.equals(list.get(i2).mAdExtraInfo.mCode)) {
                                        VideoPlayer.this.mnR.mpB = list.get(i2);
                                    }
                                }
                                i = i2 + 1;
                            }
                            if (VideoPlayer.this.mnP != null) {
                                VideoPlayer.this.mnP.H();
                            }
                        }
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str, String str2) {
        if (dwX()) {
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
                this.mnZ.setSystemUiVisibility(i);
                return;
            }
            this.mnZ.setSystemUiVisibility(1792);
        }
    }

    public void f(boolean z) {
        Window window;
        View decorView;
        if (com.kascend.chushou.b.dwD().d != 1 && (window = getWindow()) != null && (decorView = window.getDecorView()) != null) {
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
        if (this.mnP != null) {
            this.mnP.a(i, i2, intent);
        }
    }

    public Uri dwY() {
        return this.mnK;
    }

    @Override // com.kascend.chushou.view.base.BaseActivity
    protected int y() {
        return 0;
    }

    public void wa(boolean z) {
        if (this.mnZ != null) {
            this.mnZ.nvF = z;
        }
    }

    public void dwZ() {
        if (this.mnZ != null) {
            this.mnZ.dwZ();
        }
    }

    public boolean dxa() {
        return this.ae;
    }

    public void g(boolean z) {
        this.ae = z;
    }

    public void h(boolean z) {
        if (this.mnZ != null) {
            this.mnZ.setIsTranslucentStatus(z);
        }
    }

    public void z() {
        if (this.mnZ != null) {
            this.mnZ.dKt();
        }
    }

    @Override // com.kascend.chushou.widget.gifts.RoomSendGiftView.a
    public void A() {
        if (this.mnX != null) {
            this.mnX.b();
        }
    }

    @Override // com.kascend.chushou.widget.gifts.RoomSendGiftView.a
    public void B() {
        if (this.mnX != null) {
            this.mnX.b();
        }
    }

    public void a(List<ListItem> list) {
        if (this.mnP != null) {
            this.mnP.a(list);
        }
    }

    public void a(IconConfig iconConfig, Map<String, SkinConfig.SkinRes> map) {
        if (this.mnP != null) {
            this.mnP.a(iconConfig, map);
        }
    }

    public void C() {
        if (this.mnP != null) {
            this.mnP.I();
        }
    }

    @Override // com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC0731a
    public void a(int i) {
        if (this.mnP != null) {
            this.mnP.a(i);
        }
    }

    @Override // com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC0731a
    public void D() {
        if (!isFinishing() && this.mnP != null) {
            this.mnP.D();
        }
    }

    @Override // com.kascend.chushou.player.ui.h5.b.b.a
    public void a(long j) {
        if (!isFinishing() && this.mnP != null) {
            this.mnP.a(j);
        }
    }

    @Override // com.kascend.chushou.player.ui.h5.b.b.a
    public void a(com.kascend.chushou.player.ui.h5.c.a aVar) {
        if (aVar != null && this.mnP != null) {
            this.mnP.a(aVar);
        }
    }

    @Override // com.kascend.chushou.player.ui.h5.b.b.a
    public void b(int i) {
        if (this.mnP != null) {
            this.mnP.b(i);
        }
    }

    @Override // com.kascend.chushou.player.ui.h5.d.a.InterfaceC0730a
    public void b(long j) {
        if (!isFinishing() && this.mnP != null) {
            this.mnP.b(j);
        }
    }

    @Override // com.kascend.chushou.player.ui.h5.a.a.InterfaceC0728a
    public void c(int i) {
        if (!isFinishing() && this.mnP != null) {
            this.mnP.c(i);
        }
    }

    @Override // com.kascend.chushou.player.ui.h5.d.a.InterfaceC0730a
    public void b(com.kascend.chushou.player.ui.h5.c.a aVar) {
        if (aVar != null && this.mnP != null) {
            this.mnP.b(aVar);
        }
    }

    @Override // com.kascend.chushou.player.ui.a.a.InterfaceC0725a
    public void a(IconConfig.Config config) {
        if (this.mnP != null) {
            this.mnP.a(config);
        }
    }

    @Override // com.kascend.chushou.player.ui.a.a.InterfaceC0725a
    public void a(BangInfo bangInfo, String str) {
        if (this.mnP != null) {
            this.mnP.a(bangInfo, str);
        }
    }

    @Override // com.kascend.chushou.player.ui.a.a.InterfaceC0725a
    public void a(long j, BangInfo bangInfo, String str) {
        if (this.mnP != null) {
            this.mnP.a(j, bangInfo, str);
        }
    }

    public com.kascend.chushou.player.ui.h5.redpacket.a dxb() {
        return this.moj;
    }

    public com.kascend.chushou.player.ui.h5.b.b dxc() {
        return this.mok;
    }

    public com.kascend.chushou.player.ui.h5.d.a dxd() {
        return this.mol;
    }

    public com.kascend.chushou.player.ui.h5.a.a dxe() {
        return this.mop;
    }

    public com.kascend.chushou.player.ui.a.a dxf() {
        return this.mom;
    }

    public com.kascend.chushou.player.e.a dxg() {
        return this.moo;
    }

    @Override // com.kascend.chushou.view.base.BaseActivity, android.app.Activity
    public void finish() {
        super.finish();
        if ("3".equals(this.R)) {
            overridePendingTransition(17432576, a.C0715a.commonres_activity_exit_bottom);
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
        RxExecutor.postDelayed(this.mos, EventThread.MAIN_THREAD, aVar.d, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.VideoPlayer.2
            @Override // java.lang.Runnable
            public void run() {
                if (VideoPlayer.this.mnP != null) {
                    VideoPlayer.this.mnP.c(aVar);
                }
            }
        });
    }

    private void e(final com.kascend.chushou.player.ui.h5.c.a aVar) {
        if (!com.kascend.chushou.d.h.dwK().dwN().contains(aVar.b)) {
            if (aVar.d < 0) {
                aVar.d = 0;
            }
            RxExecutor.postDelayed(this.mos, EventThread.MAIN_THREAD, aVar.d, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.VideoPlayer.3
                @Override // java.lang.Runnable
                public void run() {
                    if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.mnP != null) {
                        VideoPlayer.this.mnP.c(aVar);
                    }
                }
            });
        }
    }

    private String dxh() {
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
                if (VideoPlayer.this.mnY != null && !VideoPlayer.this.isFinishing()) {
                    VideoPlayer.n = VideoPlayer.this.mnY.getStreamVolume(3);
                }
                if (!VideoPlayer.this.isFinishing() && (VideoPlayer.this.mnP instanceof f)) {
                    ((f) VideoPlayer.this.mnP).ab();
                }
            }
        }
    }

    public String a(String str) {
        HashMap hashMap = new HashMap(tv.chushou.zues.utils.d.Qk(str));
        if ("1".equals(this.R)) {
            hashMap.put("roomId", this.P);
        } else if ("3".equals(this.R)) {
            hashMap.put("videoId", this.P);
        }
        return tv.chushou.zues.utils.d.toJson(hashMap);
    }

    public boolean dxi() {
        if (this.mnP instanceof com.kascend.chushou.player.d.a) {
            return ((com.kascend.chushou.player.d.a) this.mnP).dyb();
        }
        if (this.mnP instanceof com.kascend.chushou.player.e.e) {
            return true;
        }
        return false;
    }
}

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
/* loaded from: classes6.dex */
public class VideoPlayer extends BaseActivity implements a.InterfaceC0834a, a.InterfaceC0837a, b.a, a.InterfaceC0839a, a.InterfaceC0840a, RoomSendGiftView.a {
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
    private c nnN;
    b nnQ;
    public PrivilegeInfo nnS;
    com.kascend.chushou.widget.a.b nnV;
    private KPSwitchRootRelativeLayout nnX;
    private FrameLayout nnY;
    private LinearLayout nnZ;
    private com.kascend.chushou.toolkit.d noa;
    com.kascend.chushou.view.b.a.a nob;
    private FrescoThumbnailView noe;
    private FrameLayout nof;
    public com.kascend.chushou.player.feedback.a non;
    private a nop;
    private CSTVWifiReceiver noq;
    private boolean B = true;
    private boolean C = false;
    private Uri nnJ = null;
    private tv.chushou.common.player.a nnK = null;
    public tv.chushou.common.player.a nnL = null;
    public tv.chushou.common.player.a nnM = null;
    public boolean d = false;
    public boolean e = false;
    private e nnO = null;
    private boolean H = false;
    private com.kascend.chushou.view.user.b nnP = null;
    private boolean J = false;
    private boolean K = false;
    private boolean L = false;
    private boolean M = false;
    private long nnR = 0;
    private int O = 0;
    public boolean g = false;
    private ImageView T = null;
    private TextView U = null;
    private AnimationImageView nnT = null;
    private View nnU = null;
    public boolean j = false;
    public float k = 0.0f;
    public float l = 0.0f;
    public boolean m = false;
    public AudioManager nnW = null;
    private d.a noc = new d.a() { // from class: com.kascend.chushou.player.VideoPlayer.1
        @Override // com.kascend.chushou.toolkit.d.a
        public void a() {
            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.nor != null) {
                VideoPlayer.this.nor.LT(4);
            }
        }
    };
    private boolean ae = false;
    public boolean q = true;
    public long r = -1;
    public long s = -1;
    private PowerManager.WakeLock nod = null;
    public String t = null;
    private final com.kascend.chushou.player.ui.h5.redpacket.a nog = new com.kascend.chushou.player.ui.h5.redpacket.a(this);
    private final com.kascend.chushou.player.ui.h5.b.b noh = new com.kascend.chushou.player.ui.h5.b.b(this);
    private final com.kascend.chushou.player.ui.h5.d.a noi = new com.kascend.chushou.player.ui.h5.d.a(this);
    private final com.kascend.chushou.player.ui.a.a noj = new com.kascend.chushou.player.ui.a.a(this);
    private final com.kascend.chushou.player.e.a nok = new com.kascend.chushou.player.e.a();
    private final com.kascend.chushou.player.ui.h5.a.a nol = new com.kascend.chushou.player.ui.h5.a.a(this);
    private String nom = "1";
    private String aq = "2";
    private io.reactivex.disposables.a noo = new io.reactivex.disposables.a();
    private tv.chushou.zues.c nor = new tv.chushou.zues.c(new Handler.Callback() { // from class: com.kascend.chushou.player.VideoPlayer.6
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            try {
                if (!VideoPlayer.this.isFinishing()) {
                    switch (message.what) {
                        case 1:
                            VideoPlayer.this.nor.removeMessages(1);
                            com.kascend.chushou.c.c.dMk().a(VideoPlayer.this.P, VideoPlayer.this.nnQ != null ? VideoPlayer.this.nnQ.h : null, System.currentTimeMillis());
                            VideoPlayer.this.nor.B(1, VideoPlayer.A);
                            break;
                        case 2:
                            VideoPlayer.this.a(true, (Uri) null, false);
                            break;
                        case 3:
                            VideoPlayer.this.S();
                            break;
                        case 4:
                            if (VideoPlayer.this.nnO != null) {
                                VideoPlayer.this.nnO.a(true);
                            }
                            if (VideoPlayer.this.noa != null) {
                                VideoPlayer.this.noa.d();
                                VideoPlayer.this.noa = null;
                                break;
                            }
                            break;
                        case 5:
                            int i = message.arg1;
                            if (i == 1) {
                                if (VideoPlayer.this.nnO != null) {
                                    VideoPlayer.this.nnO.p();
                                    break;
                                }
                            } else if (i == 2 && VideoPlayer.this.nnO != null) {
                                VideoPlayer.this.nnO.e(message.arg2);
                                break;
                            }
                            break;
                        case 6:
                            if (!com.kascend.chushou.b.dMh().a && !com.kascend.chushou.b.dMh().b && VideoPlayer.this.nnO != null) {
                                VideoPlayer.this.nnO.g(true);
                                break;
                            } else {
                                VideoPlayer.this.c();
                                break;
                            }
                            break;
                        case 7:
                            tv.chushou.zues.utils.e.d(VideoPlayer.this.v, "MSG_BUFFER_DEALY: ");
                            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.nnO != null && VideoPlayer.this.M && !VideoPlayer.this.e) {
                                VideoPlayer.this.nnO.h(true);
                                VideoPlayer.this.nnR = 0L;
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
    private boolean nos = false;
    private boolean aw = true;
    private boolean nou = false;
    private tv.chushou.common.player.b nov = new tv.chushou.common.player.b() { // from class: com.kascend.chushou.player.VideoPlayer.14
        @Override // tv.chushou.common.player.b
        public void dMP() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerACallback onSetVideoViewLayout");
            if (!VideoPlayer.this.isFinishing()) {
                if ((VideoPlayer.this.nnO == null || !VideoPlayer.this.nnO.H) && VideoPlayer.this.nnO != null && !VideoPlayer.this.d) {
                    VideoPlayer.this.nnO.y();
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void Kx(int i) {
            if (!VideoPlayer.this.isFinishing()) {
                if ((VideoPlayer.this.nnO == null || !VideoPlayer.this.nnO.H) && VideoPlayer.this.nnO != null && !VideoPlayer.this.d) {
                    VideoPlayer.this.nnO.g(i);
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void dMQ() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerACallback onCompletePlayback");
            if (!VideoPlayer.this.isFinishing()) {
                if (!h.isEmpty(VideoPlayer.this.P)) {
                    j.dMu().a(VideoPlayer.this.P, 0);
                }
                VideoPlayer.this.K = false;
                if (VideoPlayer.this.nor != null) {
                    VideoPlayer.this.nor.removeMessages(1);
                }
                if ((VideoPlayer.this.nnO == null || !VideoPlayer.this.nnO.H) && VideoPlayer.this.nnO != null && !VideoPlayer.this.d) {
                    VideoPlayer.this.nor.removeMessages(7);
                    VideoPlayer.this.M = false;
                    VideoPlayer.this.nnO.z();
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void dMR() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerACallback onVideoRenderingStart");
            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.nnO != null) {
                VideoPlayer.this.nnO.G();
            }
        }

        @Override // tv.chushou.common.player.b
        public void dMS() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerACallback onPreparedPlayback");
            if (!VideoPlayer.this.isFinishing()) {
                if (VideoPlayer.this.nnO == null || !VideoPlayer.this.nnO.H) {
                    VideoPlayer.this.nor.removeMessages(6);
                    VideoPlayer.this.nnR = 0L;
                    VideoPlayer.this.O = 0;
                    if (VideoPlayer.this.nnK != null && VideoPlayer.this.nnO != null) {
                        VideoPlayer.this.nnK.setVolume(VideoPlayer.this.nnO.J, VideoPlayer.this.nnO.J);
                    }
                    if (VideoPlayer.this.nnQ != null) {
                        VideoPlayer.this.K = false;
                        FullRoomInfo dNa = VideoPlayer.this.dMC() ? null : VideoPlayer.this.nnQ.dNa();
                        if (VideoPlayer.this.L || dNa != null) {
                            if (VideoPlayer.this.nnQ.e) {
                                VideoPlayer.this.nnQ.e = false;
                                VideoPlayer.this.nnQ.d = !VideoPlayer.this.nnQ.d;
                            }
                            if (VideoPlayer.this.nnO != null) {
                                VideoPlayer.this.c("1", (String) null);
                                if (!VideoPlayer.this.d) {
                                    VideoPlayer.this.nnO.i(true);
                                } else if (VideoPlayer.this.e) {
                                    VideoPlayer.this.e = false;
                                    VideoPlayer.this.nnO.B();
                                }
                            }
                        }
                    }
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void Ky(int i) {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerACallback onErrorAppeared");
            if (!VideoPlayer.this.isFinishing()) {
                VideoPlayer.this.c();
                VideoPlayer.this.K = false;
                if (VideoPlayer.this.nor != null) {
                    VideoPlayer.this.nor.removeMessages(7);
                }
                if (VideoPlayer.this.nor != null) {
                    VideoPlayer.this.nor.removeMessages(1);
                }
                if ((VideoPlayer.this.nnO == null || !VideoPlayer.this.nnO.H) && !VideoPlayer.this.dMw()) {
                    if (!"10004".equals(VideoPlayer.this.t)) {
                        if (VideoPlayer.this.nnO != null) {
                            if (VideoPlayer.this.d) {
                                VideoPlayer.this.nnL.stop();
                                VideoPlayer.this.nnL.release();
                                VideoPlayer.this.e = false;
                                VideoPlayer.this.nnO.C();
                            }
                            if (!com.kascend.chushou.b.dMh().a && !com.kascend.chushou.b.dMh().b) {
                                VideoPlayer.this.nnO.g(true);
                            } else if (VideoPlayer.this.d) {
                                VideoPlayer.this.nnO.a(i, true);
                            } else {
                                VideoPlayer.this.nnO.a(i, false);
                            }
                            VideoPlayer.this.c("2", (String) null);
                            return;
                        }
                        return;
                    }
                    dMQ();
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void dMT() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerACallback onBufferingStart");
            if (!VideoPlayer.this.isFinishing()) {
                if ((VideoPlayer.this.nnO == null || !VideoPlayer.this.nnO.H) && VideoPlayer.this.nnO != null && !VideoPlayer.this.d) {
                    VideoPlayer.this.nnO.E();
                    VideoPlayer.this.M = true;
                    long currentTimeMillis = System.currentTimeMillis();
                    VideoPlayer.this.nor.removeMessages(7);
                    if (!VideoPlayer.this.g) {
                        VideoPlayer.y(VideoPlayer.this);
                    }
                    tv.chushou.zues.utils.e.d(VideoPlayer.this.v, "currentTime: -- >" + currentTimeMillis + "  bufferTime-->" + VideoPlayer.this.nnR + "  bufferCount-->" + VideoPlayer.this.O);
                    if (currentTimeMillis - VideoPlayer.this.nnR >= 20000 || VideoPlayer.this.O < 2 || VideoPlayer.this.nnO.H) {
                        if (VideoPlayer.this.O == 1) {
                            VideoPlayer.this.nnR = currentTimeMillis;
                        }
                        VideoPlayer.this.nor.B(7, 5000L);
                    } else {
                        VideoPlayer.this.nor.LT(7);
                    }
                    if (VideoPlayer.this.g) {
                        VideoPlayer.this.g = false;
                    }
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void dMU() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerACallback onBufferingEnd");
            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.nnO != null && !VideoPlayer.this.d) {
                VideoPlayer.this.nor.removeMessages(7);
                VideoPlayer.this.M = false;
                if (VideoPlayer.this.nnO == null || !VideoPlayer.this.nnO.H) {
                    if (VideoPlayer.this.nnK == null) {
                        VideoPlayer.this.nnO.a(false, true, false);
                    } else {
                        VideoPlayer.this.nnO.a(true, VideoPlayer.this.nnK.getPlayState() == 4, VideoPlayer.this.nnK.getPlayState() == 5);
                    }
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void dMV() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerACallback onPlayerStart");
            if (!VideoPlayer.this.isFinishing()) {
                if (VideoPlayer.this.nnO == null || !VideoPlayer.this.nnO.H) {
                    if (VideoPlayer.this.nnO != null && !VideoPlayer.this.d) {
                        if (VideoPlayer.this.nnK != null) {
                            VideoPlayer.this.nnO.F();
                            VideoPlayer.this.nnO.a(true, VideoPlayer.this.nnK.getPlayState() == 4, VideoPlayer.this.nnK.getPlayState() == 5);
                        } else {
                            VideoPlayer.this.nnO.a(false, true, false);
                        }
                    }
                    if (VideoPlayer.this.nor != null && !VideoPlayer.this.dMC()) {
                        VideoPlayer.this.nor.removeMessages(1);
                        VideoPlayer.this.nor.B(1, VideoPlayer.A);
                    }
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void dMW() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerACallback onPlayerPause");
            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.nor != null) {
                VideoPlayer.this.nor.removeMessages(1);
            }
        }

        @Override // tv.chushou.common.player.b
        public void dMX() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerACallback onPlayerStop");
            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.dMC() && VideoPlayer.this.nnL != null && !h.isEmpty(VideoPlayer.this.P) && VideoPlayer.this.nnL.getCurrentPos() > 0) {
                j.dMu().a(VideoPlayer.this.P, VideoPlayer.this.nnL.getCurrentPos());
            }
        }
    };
    private tv.chushou.common.player.b nox = new tv.chushou.common.player.b() { // from class: com.kascend.chushou.player.VideoPlayer.15
        @Override // tv.chushou.common.player.b
        public void dMP() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerBCallback onSetVideoViewLayout");
            if (!VideoPlayer.this.isFinishing()) {
                if ((VideoPlayer.this.nnO == null || !VideoPlayer.this.nnO.H) && VideoPlayer.this.nnO != null && VideoPlayer.this.d) {
                    VideoPlayer.this.nnO.y();
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void Kx(int i) {
            if (!VideoPlayer.this.isFinishing()) {
                if ((VideoPlayer.this.nnO == null || !VideoPlayer.this.nnO.H) && VideoPlayer.this.nnO != null && VideoPlayer.this.d) {
                    VideoPlayer.this.nnO.g(i);
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void dMQ() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerBCallback onCompletePlayback");
            if (!VideoPlayer.this.isFinishing()) {
                if (!h.isEmpty(VideoPlayer.this.P)) {
                    j.dMu().a(VideoPlayer.this.P, 0);
                }
                VideoPlayer.this.K = false;
                if (VideoPlayer.this.nor != null) {
                    VideoPlayer.this.nor.removeMessages(1);
                }
                if ((VideoPlayer.this.nnO == null || !VideoPlayer.this.nnO.H) && VideoPlayer.this.nnO != null && VideoPlayer.this.d) {
                    VideoPlayer.this.nor.removeMessages(7);
                    VideoPlayer.this.M = false;
                    VideoPlayer.this.nnO.z();
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void dMR() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerBCallback onVideoRenderingStart");
            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.nnO != null) {
                VideoPlayer.this.nnO.G();
            }
        }

        @Override // tv.chushou.common.player.b
        public void dMS() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerBCallback onPreparedPlayback");
            if (!VideoPlayer.this.isFinishing()) {
                if (VideoPlayer.this.nnO == null || !VideoPlayer.this.nnO.H) {
                    VideoPlayer.this.nor.removeMessages(6);
                    VideoPlayer.this.nnR = 0L;
                    VideoPlayer.this.O = 0;
                    if (VideoPlayer.this.nnK != null && VideoPlayer.this.nnO != null) {
                        VideoPlayer.this.nnK.setVolume(VideoPlayer.this.nnO.J, VideoPlayer.this.nnO.J);
                    }
                    if (VideoPlayer.this.nnQ != null) {
                        VideoPlayer.this.K = false;
                        FullRoomInfo dNa = VideoPlayer.this.dMC() ? null : VideoPlayer.this.nnQ.dNa();
                        if (VideoPlayer.this.L || dNa != null) {
                            if (VideoPlayer.this.nnQ.e) {
                                VideoPlayer.this.nnQ.e = false;
                                VideoPlayer.this.nnQ.d = !VideoPlayer.this.nnQ.d;
                            }
                            if (VideoPlayer.this.nnO != null) {
                                VideoPlayer.this.c("1", (String) null);
                                if (VideoPlayer.this.d) {
                                    VideoPlayer.this.nnO.i(true);
                                } else if (VideoPlayer.this.e) {
                                    VideoPlayer.this.e = false;
                                    VideoPlayer.this.nnO.B();
                                }
                            }
                        }
                    }
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void Ky(int i) {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerBCallback onErrorAppeared");
            if (!VideoPlayer.this.isFinishing()) {
                VideoPlayer.this.c();
                VideoPlayer.this.K = false;
                if (VideoPlayer.this.nor != null) {
                    VideoPlayer.this.nor.removeMessages(7);
                }
                if (VideoPlayer.this.nor != null) {
                    VideoPlayer.this.nor.removeMessages(1);
                }
                if ((VideoPlayer.this.nnO == null || !VideoPlayer.this.nnO.H) && !VideoPlayer.this.dMw()) {
                    if (!"10004".equals(VideoPlayer.this.t)) {
                        if (VideoPlayer.this.nnO != null) {
                            if (!VideoPlayer.this.d) {
                                VideoPlayer.this.nnM.stop();
                                VideoPlayer.this.nnM.release();
                                VideoPlayer.this.nnO.C();
                                VideoPlayer.this.e = false;
                            }
                            if (!com.kascend.chushou.b.dMh().a && !com.kascend.chushou.b.dMh().b) {
                                VideoPlayer.this.nnO.g(true);
                            } else if (VideoPlayer.this.d) {
                                VideoPlayer.this.nnO.a(i, false);
                            } else {
                                VideoPlayer.this.nnO.a(i, true);
                            }
                            VideoPlayer.this.c("2", (String) null);
                            return;
                        }
                        return;
                    }
                    dMQ();
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void dMT() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerBCallback onBufferingStart");
            if (!VideoPlayer.this.isFinishing()) {
                if ((VideoPlayer.this.nnO == null || !VideoPlayer.this.nnO.H) && VideoPlayer.this.nnO != null && VideoPlayer.this.d) {
                    VideoPlayer.this.nnO.E();
                    VideoPlayer.this.M = true;
                    VideoPlayer.this.nor.removeMessages(7);
                    long currentTimeMillis = System.currentTimeMillis();
                    if (!VideoPlayer.this.g) {
                        VideoPlayer.y(VideoPlayer.this);
                    }
                    tv.chushou.zues.utils.e.d(VideoPlayer.this.v, "currentTime: -- >" + currentTimeMillis + "  bufferTime-->" + VideoPlayer.this.nnR + "  bufferCount-->" + VideoPlayer.this.O);
                    if (currentTimeMillis - VideoPlayer.this.nnR >= 20000 || VideoPlayer.this.O < 2 || VideoPlayer.this.nnO.H) {
                        if (VideoPlayer.this.O == 1) {
                            VideoPlayer.this.nnR = currentTimeMillis;
                        }
                        VideoPlayer.this.nor.B(7, 5000L);
                    } else {
                        VideoPlayer.this.nnR = 0L;
                        VideoPlayer.this.O = 0;
                        VideoPlayer.this.nor.LT(7);
                    }
                    if (VideoPlayer.this.g) {
                        VideoPlayer.this.g = false;
                    }
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void dMU() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerBCallback onBufferingEnd");
            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.nnO != null && VideoPlayer.this.d) {
                VideoPlayer.this.M = false;
                VideoPlayer.this.nor.removeMessages(7);
                if (VideoPlayer.this.nnO == null || !VideoPlayer.this.nnO.H) {
                    if (VideoPlayer.this.nnK == null) {
                        VideoPlayer.this.nnO.a(false, true, false);
                    } else {
                        VideoPlayer.this.nnO.a(true, VideoPlayer.this.nnK.getPlayState() == 4, VideoPlayer.this.nnK.getPlayState() == 5);
                    }
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void dMV() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerBCallback onPlayerStart");
            if (!VideoPlayer.this.isFinishing()) {
                if (VideoPlayer.this.nnO == null || !VideoPlayer.this.nnO.H) {
                    if (VideoPlayer.this.nnO != null && VideoPlayer.this.d) {
                        if (VideoPlayer.this.nnK != null) {
                            VideoPlayer.this.nnO.F();
                            VideoPlayer.this.nnO.a(true, VideoPlayer.this.nnK.getPlayState() == 4, VideoPlayer.this.nnK.getPlayState() == 5);
                        } else {
                            VideoPlayer.this.nnO.a(false, true, false);
                        }
                    }
                    if (VideoPlayer.this.nor != null && !VideoPlayer.this.dMC()) {
                        VideoPlayer.this.nor.removeMessages(1);
                        VideoPlayer.this.nor.B(1, VideoPlayer.A);
                    }
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void dMW() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerBCallback onPlayerPause");
            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.nor != null) {
                VideoPlayer.this.nor.removeMessages(1);
            }
        }

        @Override // tv.chushou.common.player.b
        public void dMX() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerBCallback onPlayerStop");
            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.dMC() && VideoPlayer.this.nnM != null && !h.isEmpty(VideoPlayer.this.P) && VideoPlayer.this.nnM.getCurrentPos() > 0) {
                j.dMu().a(VideoPlayer.this.P, VideoPlayer.this.nnM.getCurrentPos());
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
        this.nnJ = intent.getData();
        if (this.nnJ == null) {
            finish();
            return;
        }
        com.kascend.chushou.d.e.j();
        if (this.noq == null) {
            this.noq = new CSTVWifiReceiver();
            registerReceiver(this.noq, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        }
        com.kascend.chushou.toolkit.d.a.dOw().b();
        tv.chushou.zues.utils.e.i(this.v, "intent.getData=" + this.nnJ.toString());
        String scheme = this.nnJ.getScheme();
        if (scheme == null || !scheme.equals("chushou")) {
            tv.chushou.zues.utils.e.e(this.v, "not support scheme :" + scheme);
            finish();
            return;
        }
        a(intent);
    }

    private void a(Intent intent) {
        this.P = this.nnJ.getQueryParameter("roomId");
        this.Q = this.P;
        this.S = this.nnJ.getQueryParameter(WebSocketRequest.PARAM_KEY_PROTOCOLS);
        this.aq = this.nnJ.getQueryParameter("liveType");
        if ("2".equals(this.aq) || "3".equals(this.aq) || "4".equals(this.aq)) {
            this.nom = "2";
            this.non = new com.kascend.chushou.player.feedback.a();
            if (this.non.nwC != null) {
                this.non.nwC.reset();
                this.non.nwC.roomId = this.P;
                this.non.nwC.enterType = 1;
                this.non.b = System.currentTimeMillis();
            }
        }
        if (h.isEmpty(this.P) || h.isEmpty(this.S)) {
            tv.chushou.zues.utils.e.e(this.v, "invalid param mItemID=" + this.P + " protocols=" + this.S);
            finish();
            return;
        }
        if (com.kascend.chushou.b.dMh().d == -1) {
            com.kascend.chushou.b.dMh().d = com.kascend.chushou.d.g.b() ? 1 : 0;
        }
        this.nod = ((PowerManager) getSystemService("power")).newWakeLock(536870938, this.v);
        this.nod.acquire();
        this.nnQ = new b(this.P);
        this.nnQ.d = intent.getBooleanExtra("room_play_audio", false);
        this.nnV = new com.kascend.chushou.widget.a.b();
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
        this.nnX = (KPSwitchRootRelativeLayout) findViewById(a.f.rlRoot);
        if (!"2".equals(this.nom) && com.kascend.chushou.b.dMh().d == 1) {
            this.nnX.setFitsSystemWindows(true);
        }
        this.nnY = (FrameLayout) this.nnX.findViewById(a.f.fl_fragment);
        this.nnU = this.nnX.findViewById(a.f.rl_empty);
        this.T = (ImageView) this.nnU.findViewById(a.f.iv_empty);
        this.U = (TextView) this.nnU.findViewById(a.f.tv_empty);
        this.nnZ = (LinearLayout) this.nnX.findViewById(a.f.rl_title);
        this.Z = (ImageView) this.nnZ.findViewById(a.f.back_icon);
        this.Z.setOnClickListener(new View.OnClickListener() { // from class: com.kascend.chushou.player.VideoPlayer.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayer.this.finish();
            }
        });
        this.nnT = (AnimationImageView) this.nnU.findViewById(a.f.iv_loading);
        this.noe = (FrescoThumbnailView) this.nnX.findViewById(a.f.live_cover);
        this.nof = (FrameLayout) this.nnX.findViewById(a.f.fl_cover);
        this.k = dMv();
        try {
            this.nnW = (AudioManager) getApplicationContext().getSystemService("audio");
            n = this.nnW.getStreamVolume(3);
            this.nnW.requestAudioFocus(null, 3, 1);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (this.B) {
            a(1, dMC() ? "3" : "1");
        } else {
            r();
        }
        if (com.kascend.chushou.b.dMh().b && !com.kascend.chushou.b.dMh().a) {
            RxExecutor.postDelayed(this.noo, EventThread.MAIN_THREAD, 60L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.VideoPlayer.5
                @Override // java.lang.Runnable
                public void run() {
                    if (!VideoPlayer.this.isFinishing() && com.kascend.chushou.b.dMh().b && !com.kascend.chushou.b.dMh().a) {
                        tv.chushou.zues.utils.g.c(VideoPlayer.this.w, VideoPlayer.this.getString(a.i.str_monet_notify));
                    }
                }
            });
        }
        com.kascend.chushou.c.c.dMk().a(this.P, stringExtra, System.currentTimeMillis());
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
        if (this.nop == null) {
            this.nop = new a();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.media.VOLUME_CHANGED_ACTION");
            registerReceiver(this.nop, intentFilter);
        }
    }

    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        j(false);
        if (this.nop != null) {
            unregisterReceiver(this.nop);
            this.nop = null;
        }
        super.onStop();
    }

    @Override // com.kascend.chushou.view.base.BaseActivity
    protected void a(boolean z) {
        if (this.nnO != null) {
            this.nnO.k(z);
        }
    }

    @Subscribe
    public void onHideGiftEffectEvent(com.kascend.chushou.b.a.a.f fVar) {
        if (fVar.b) {
            this.nnO.k();
            return;
        }
        this.nnO.m();
        this.nnO.l();
    }

    private float dMv() {
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
            this.nnQ.h = jSONObject.toString();
            String optString = jSONObject.optString("_thumb");
            jSONObject.optBoolean("tag_from_game_mic", false);
            if (!h.isEmpty(optString)) {
                this.ab = optString;
            }
        } catch (JSONException e) {
            e.printStackTrace();
            this.nnQ.h = str;
        }
        if (dMC()) {
            a(this.P, str);
            aX(this.P, z);
            return;
        }
        a = this.P;
        b(this.P, str);
        a(this.P, dMM(), z);
        w();
    }

    private void O() {
        this.m = true;
        j();
        if (this.nnO != null) {
            this.nnO.r();
        }
        s();
    }

    @Subscribe
    public void onStartRoomEvent(o oVar) {
        if (!isFinishing() && oVar.nnr != null && oVar.c != null && !h.isEmpty(oVar.nnr.mTargetKey)) {
            if (oVar.c != this) {
                tv.chushou.zues.utils.e.e(this.v, "different player!");
                return;
            }
            if (this.nnQ != null) {
                this.nnQ.a();
                this.nnQ.a = oVar.nnr.mTargetKey;
                this.nnQ.d = oVar.d;
                if (this.nnQ.nps != null) {
                    this.nnQ.nps.e();
                }
                if (this.nnQ.nps != null) {
                    this.nnQ.nps.b();
                }
                this.nnQ.npw = null;
                this.nnQ.npv = null;
                this.nnQ.npz = null;
                this.nnQ.npy = null;
                this.nnQ.npC = null;
                this.nnQ.npA = null;
                this.nnQ.npB = null;
            }
            if (this.nnW != null) {
                n = this.nnW.getStreamVolume(3);
            }
            if (!h.isEmpty(oVar.nnr.mType) && oVar.nnr.mType.equals("3")) {
                this.B = false;
                this.nom = "1";
                r();
                this.P = oVar.nnr.mTargetKey;
                this.R = "3";
                if (this.nnV != null) {
                    this.nnV.a();
                }
                if (this.nnQ != null) {
                    this.nnQ.a((PlayUrl) null);
                    this.nnQ.f();
                    if (this.nnQ.c() != null) {
                        this.nnQ.c().clear();
                    }
                    this.nnQ.i.clear();
                }
                if (this.nnO != null) {
                    this.nnO.j();
                }
                s();
                if (this.noa != null) {
                    this.noa.d();
                    this.noa = null;
                }
                if (this.noo != null) {
                    this.noo.dispose();
                    this.noo = new io.reactivex.disposables.a();
                }
                a(oVar.e, false);
                return;
            }
            boolean z = this.R != null && this.R.equals("1");
            this.R = "1";
            this.noj.a();
            this.noi.a();
            this.noh.a();
            this.nog.c();
            this.nol.a();
            if (this.noo != null) {
                this.noo.dispose();
                this.noo = new io.reactivex.disposables.a();
            }
            if ("1".equals(oVar.f)) {
                this.H = false;
                if (this.nnQ != null && !h.isEmpty(this.nnQ.t)) {
                    this.nnQ.t.clear();
                }
                this.ab = oVar.nnr.mCover;
                this.nof.setVisibility(0);
                this.noe.setBlur(true);
                this.noe.i(oVar.nnr.mCover, 0, 0, 0);
            }
            if (!oVar.nnr.mTargetKey.equals(this.P)) {
                this.aq = oVar.g;
                if (!z) {
                    this.B = false;
                    r();
                } else if (!"2".equals(this.nom) && ("2".equals(this.aq) || "3".equals(this.aq) || "4".equals(this.aq))) {
                    this.nom = "2";
                    this.non = new com.kascend.chushou.player.feedback.a();
                    if (this.non.nwC != null) {
                        this.non.nwC.reset();
                        this.non.nwC.roomId = oVar.nnr.mTargetKey;
                        this.non.nwC.enterType = 1;
                        this.non.b = System.currentTimeMillis();
                    }
                }
                this.B = false;
                this.P = oVar.nnr.mTargetKey;
                this.Q = this.P;
                this.ab = oVar.nnr.mCover;
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
                JSONObject P = com.kascend.chushou.d.e.P("_fromView", str, "_sc", oVar.nnr.mSC);
                com.kascend.chushou.toolkit.a.c.a(this.w, P);
                if (this.nnV != null) {
                    this.nnV.a();
                    this.nnV.a(this.P);
                }
                if (this.nnQ != null) {
                    this.nnQ.a((PlayUrl) null);
                    this.nnQ.f();
                    if (this.nnQ.c() != null) {
                        this.nnQ.c().clear();
                    }
                    this.nnQ.i.clear();
                }
                if (this.nnO != null) {
                    this.nnO.j();
                }
                a(P.toString(), false);
                return;
            }
            tv.chushou.zues.utils.g.Mc(a.i.str_same_room);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dMw() {
        FullRoomInfo dNa;
        String str;
        RoomInfo roomInfo;
        if (dMC()) {
            str = null;
            dNa = null;
        } else {
            dNa = this.nnQ.dNa();
            str = (dNa == null || (roomInfo = dNa.mRoominfo) == null) ? null : roomInfo.mGameId;
        }
        return !this.L && (dNa == null || h.isEmpty(str));
    }

    @Subscribe
    public void onMessageEvent(i iVar) {
        if (!isFinishing() && iVar.a != 21 && iVar.a != 22) {
            if (iVar.a == 0 && (iVar.b instanceof Boolean)) {
                if (((Boolean) iVar.b).booleanValue() && !isFinishing()) {
                    w();
                    if (this.nnO != null) {
                        this.nnO.f();
                    }
                }
            } else if (iVar.a == 46) {
                if ((iVar.b instanceof String) && this.nnO != null) {
                    this.nnO.c((String) iVar.b);
                }
            } else if (iVar.a == 54) {
                if (iVar.b instanceof String) {
                    this.noh.a((String) iVar.b);
                }
            } else if (iVar.a == 55) {
                if (this.nnO != null) {
                    this.nnO.O();
                }
            } else if (iVar.a == 56 && this.nnO != null) {
                this.nnO.P();
            }
        }
    }

    @Subscribe
    public void onRefreshSubscribeEvent(m mVar) {
        if (isFinishing() && this.nnQ != null && this.nnQ.dNd() != null) {
            RoomInfo dNd = this.nnQ.dNd();
            if (mVar.a(dNd.mCreatorUID, dNd.mRoomID)) {
                dNd.mIsSubscribed = mVar.c;
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
        if (this.m || this.nnL == null || this.nnM == null) {
            R();
        }
        if (this.nnV != null) {
            this.nnV.d();
        }
        if (!dMC()) {
            if (this.noa != null && !this.noa.c()) {
                this.noa.a();
            }
            v();
            if (this.nnQ != null && this.nnQ.dNa() != null && this.nnQ.dNa().cycleLiveRoomInfo != null && !h.isEmpty(this.nnQ.dNa().cycleLiveRoomInfo.roomId)) {
                u();
            }
        }
        super.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.view.base.BaseActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        tv.chushou.zues.utils.e.e(this.v, MissionEvent.MESSAGE_DESTROY);
        if (this.nnQ != null && this.nnQ.dNa() != null && this.nnQ.dNa().cycleLiveRoomInfo != null && !h.isEmpty(this.nnQ.dNa().cycleLiveRoomInfo.eventName)) {
            j.dMu().a(this.P + dMM());
        }
        if ("2".equals(this.nom) && this.non != null && this.non.nwC != null) {
            this.non.nwC.time = System.currentTimeMillis() - this.non.b;
            this.non.a();
            this.non.b();
        }
        this.nog.d();
        this.noh.b();
        this.noi.b();
        O();
        this.ag = null;
        a = null;
        if (this.nor != null) {
            this.nor.ch(null);
            this.nor = null;
        }
        if (this.noa != null) {
            this.noa.d();
            this.noa = null;
        }
        if (this.nnV != null) {
            this.nnV.c();
            this.nnV = null;
        }
        if (this.nnQ != null) {
            this.nnQ.npw = null;
            this.nnQ.npv = null;
        }
        if (this.nnQ != null) {
            this.nnQ.b();
            this.nnQ = null;
        }
        this.nnJ = null;
        this.nnO = null;
        this.nnP = null;
        this.nnS = null;
        this.T = null;
        this.U = null;
        this.nnT = null;
        this.nnU = null;
        this.nnW = null;
        this.nnX = null;
        this.nnY = null;
        this.Z = null;
        this.nnZ = null;
        if (this.nod != null && this.nod.isHeld()) {
            this.nod.release();
            this.nod = null;
        }
        if (this.noq != null) {
            unregisterReceiver(this.noq);
            this.noq = null;
        }
        h.eaj();
        tv.chushou.zues.a.a.ci(this);
        this.noo.dispose();
        this.noi.b();
        this.noj.b();
        this.nog.d();
        this.noh.b();
        this.nol.b();
        super.onDestroy();
        System.gc();
    }

    @Subscribe
    public void onSendGameGiftEvent(n nVar) {
        if (!isFinishing() && this.nnO != null) {
            this.nnO.a(nVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.view.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        tv.chushou.zues.utils.e.d(this.v, MissionEvent.MESSAGE_PAUSE);
        if (this.noa != null) {
            this.noa.b();
        }
        if (this.nnV != null) {
            this.nnV.b(false);
        }
        k();
        this.m = true;
        super.onPause();
    }

    @Override // android.app.Activity
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.nnO != null ? this.nnO.a(motionEvent) : super.onTouchEvent(motionEvent);
    }

    public void c() {
        if ("1".equals(this.R)) {
            j.dMu().a(this.P + dMM());
        } else {
            j.dMu().b(this.P);
        }
    }

    private void a(boolean z, boolean z2) {
        int i = 0;
        tv.chushou.zues.utils.e.i(this.v, "startLoadingVideo <------------- mbPrepareingVideo = " + this.K);
        if (this.nnL != null) {
            this.nnL.setHardwearDecod(com.kascend.chushou.d.h.dMo().a);
        }
        if (this.nnM != null) {
            this.nnM.setHardwearDecod(com.kascend.chushou.d.h.dMo().a);
        }
        if (this.nnK != null) {
            this.nnK.setHardwearDecod(com.kascend.chushou.d.h.dMo().a);
        }
        if (!this.K) {
            if (z && this.nnO != null) {
                if (!z2) {
                    this.t = null;
                    this.nnO.e();
                }
            } else if (this.nnO != null && !z2) {
                this.t = null;
                this.nnO.H = false;
                RxExecutor.post(null, EventThread.MAIN_THREAD, new Runnable() { // from class: com.kascend.chushou.player.VideoPlayer.7
                    @Override // java.lang.Runnable
                    public void run() {
                        VideoPlayer.this.nnO.x();
                    }
                });
            }
            this.K = true;
            if (this.nnQ != null && this.nnQ.dNb() != null) {
                PlayUrl dNb = this.nnQ.dNb();
                while (true) {
                    int i2 = i;
                    if (i2 >= dNb.mUrlDetails.size()) {
                        break;
                    }
                    UrlDetails urlDetails = dNb.mUrlDetails.get(i2);
                    if (urlDetails.mUrl.equals(dNb.mSelectedUrl)) {
                        String str = dNb.mUrlDetails.get(i2).mDefinitionType;
                        String str2 = urlDetails.mBitrate;
                    }
                    i = i2 + 1;
                }
            }
            if (z2) {
                if (this.d) {
                    this.nnL.setVideoURI(this.nnJ);
                    this.nnL.open();
                    return;
                }
                this.nnM.setVideoURI(this.nnJ);
                this.nnM.open();
                return;
            }
            this.nnK.setVideoURI(this.nnJ);
            this.nnK.open();
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        try {
            if (motionEvent.getAction() == 0) {
                if (this.nnO != null && this.nnO.b(motionEvent)) {
                    return true;
                }
                if ("2".equals(this.nom) && this.nnO != null) {
                    this.nnO.a(motionEvent);
                }
            } else if (this.nnO != null && this.nnO.b(motionEvent)) {
                return true;
            }
            return super.dispatchTouchEvent(motionEvent);
        } catch (Exception e) {
            return false;
        }
    }

    @Override // android.support.v7.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.nnO != null && this.nnO.a(i, keyEvent)) {
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
        if (this.nnQ != null && this.nnQ.dNa() != null && this.nnQ.dNa().cycleLiveRoomInfo != null && !h.isEmpty(this.nnQ.dNa().cycleLiveRoomInfo.roomId)) {
            this.nof.setVisibility(0);
            this.noe.setBlur(true);
            this.noe.i(this.nnQ.dNa().cycleLiveRoomInfo.avatar, 0, 0, 0);
            this.noe.setVisibility(0);
            j.dMu().a(this.P + dMM());
            this.nnJ = null;
            R();
            this.Q = this.nnQ.dNa().cycleLiveRoomInfo.roomId;
            a(this.P, dMM(), false);
        }
    }

    public void b(boolean z) {
        if (this.nnO != null) {
            this.nnO.j(z);
        }
    }

    public void a(boolean z, Uri uri, boolean z2) {
        tv.chushou.zues.utils.e.d(this.v, "loadIfNecessary reload=" + z + " isChangeLines-->" + z2);
        if (this.nnL != null && this.nnM != null) {
            if (uri != null) {
                this.nnJ = uri;
            }
            if (z2) {
                this.e = z2;
            }
            this.M = false;
            this.nnR = 0L;
            this.O = 0;
            this.nor.removeMessages(7);
            if (z) {
                if (z2) {
                    if (!this.d) {
                        this.nnM.setOnActivityCallBack(this.nox);
                    } else {
                        this.nnL.setOnActivityCallBack(this.nov);
                    }
                } else if (this.d) {
                    this.nnM.setOnActivityCallBack(this.nox);
                } else {
                    this.nnL.setOnActivityCallBack(this.nov);
                }
                this.K = false;
                b(true, z2);
            } else if (!this.J) {
                b(true, z2);
            }
            this.nor.B(6, 3000L);
        }
    }

    private void b(boolean z, boolean z2) {
        VideoPlayInfo L;
        if ("1".equals(this.R)) {
            L = j.dMu().K(this.P + dMM(), 600000L);
        } else {
            L = j.dMu().L(this.P, 600000L);
        }
        if (L != null) {
            a(z, z2);
        } else if ("1".equals(this.R)) {
            a(this.P, dMM(), false);
        } else {
            aX(this.P, false);
        }
    }

    public tv.chushou.common.player.a dMx() {
        return this.nnK;
    }

    public tv.chushou.common.player.a dMy() {
        return this.nnL;
    }

    public tv.chushou.common.player.a dMz() {
        return this.nnM;
    }

    public void a(tv.chushou.common.player.a aVar) {
        this.nnK = aVar;
    }

    public b dMA() {
        return this.nnQ;
    }

    public com.kascend.chushou.widget.a.b dMB() {
        return this.nnV;
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
        FullRoomInfo dNa;
        this.r = -1L;
        if (this.s != -1 && this.s != 0) {
            this.r = this.s;
            this.s = -1L;
        }
        if (dMC() && this.nnK != null && this.nnK.getPlayState() == 4) {
            this.r = this.nnK.getCurrentPos();
        }
        this.nos = false;
        tv.chushou.zues.utils.e.d(this.v, "screenChange()<-----");
        tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard(this);
        if (str != null) {
            this.R = str;
        }
        if (!this.C || !z3 || "3".equals(this.R) || this.nnQ == null || (dNa = this.nnQ.dNa()) == null || dNa.mRoominfo == null || dNa.mRoominfo.mStyle != 1) {
            z5 = false;
        } else {
            z5 = true;
            i = 0;
        }
        if ("2".equals(this.nom)) {
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
            if (com.kascend.chushou.b.dMh().d == 1) {
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
            ((VideoPlayer) this.w).xB(false);
            ((VideoPlayer) this.w).g(true);
            if (z5) {
                setRequestedOrientation(1);
            } else {
                setRequestedOrientation(6);
            }
            getWindow().addFlags(512);
            getWindow().addFlags(256);
        }
        if (this.nnV == null) {
            this.nnV = new com.kascend.chushou.widget.a.b();
        }
        if (this.nnV != null) {
            this.nnV.a(this.P);
        }
        if (this.R.equals("5")) {
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            if (this.nnO != null) {
                beginTransaction.remove(this.nnO);
                this.nnO = null;
            }
            if (this.nnP != null) {
                beginTransaction.remove(this.nnP);
                this.nnP = null;
            }
            this.nnP = new com.kascend.chushou.view.user.b();
            beginTransaction.add(a.f.fl_fragment, this.nnP);
            beginTransaction.commitAllowingStateLoss();
        } else {
            FragmentTransaction beginTransaction2 = getSupportFragmentManager().beginTransaction();
            if (this.nnO != null) {
                beginTransaction2.remove(this.nnO);
                this.nnO = null;
            }
            if (this.nnP != null) {
                beginTransaction2.remove(this.nnP);
                this.nnP = null;
            }
            if ("2".equals(this.nom)) {
                this.nnO = com.kascend.chushou.player.e.e.b(this.ab, z2, this.aq, this.P);
            } else if (1 == i) {
                if (!this.R.equals("3")) {
                    if (z4) {
                        v();
                    }
                    this.nnO = new com.kascend.chushou.player.d.a();
                    Bundle bundle = new Bundle();
                    bundle.putString("mCover", this.ab);
                    bundle.putBoolean("mInitViewAsync", z2);
                    this.nnO.setArguments(bundle);
                }
            } else {
                this.nnO = new com.kascend.chushou.player.d.b();
                Bundle bundle2 = new Bundle();
                if (z5) {
                    i = 1;
                }
                bundle2.putInt("mExtraOrientation", i);
                bundle2.putString("mViewType", this.R);
                this.nnO.setArguments(bundle2);
            }
            beginTransaction2.add(a.f.fl_fragment, this.nnO);
            beginTransaction2.commitAllowingStateLoss();
            this.H = true;
        }
        tv.chushou.zues.utils.e.d(this.v, "screenChange()----->");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dMC() {
        return this.R != null && this.R.equals("3");
    }

    private void R() {
        if (this.nnO != null) {
            this.nnO.nsQ = null;
        }
        if (this.nnK != null) {
            this.nnK.release();
            this.nnK = null;
            this.K = false;
        }
        if (this.nnL != null) {
            this.nnL.release();
            this.nnL = null;
        }
        if (this.nnM != null) {
            this.nnM.release();
            this.nnM = null;
        }
        if (this.nnN != null) {
            this.nnN.c();
        }
        this.d = false;
        this.e = false;
        this.M = false;
        this.nnN = new c();
        this.nnL = this.nnN.dNg();
        this.nnL.setOnActivityCallBack(this.nov);
        this.nnM = this.nnN.dNh();
        this.nnM.setOnActivityCallBack(this.nox);
        if (!this.d) {
            this.nnK = this.nnL;
        } else {
            this.nnK = this.nnM;
        }
        if (this.nnO != null) {
            this.nnO.nsQ = this.nnK;
        }
    }

    public void j() {
        if (this.nnK != null) {
            this.nnK.pause();
            this.nnK.stop();
            this.nnK.release();
            this.nnK = null;
        }
        if (this.nnL != null) {
            this.nnL.stop();
            this.nnL.release();
            this.nnL = null;
        }
        if (this.nnM != null) {
            this.nnM.stop();
            this.nnM.release();
            this.nnM = null;
        }
        if (this.nnN != null) {
            this.nnN.c();
        }
    }

    public void k() {
        tv.chushou.common.player.a aVar = this.nnK;
        if (aVar != null) {
            aVar.pause();
            aVar.stop();
        }
        tv.chushou.common.player.a aVar2 = this.nnL;
        if (aVar2 != null) {
            aVar2.stop();
        }
        tv.chushou.common.player.a aVar3 = this.nnM;
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
        if (this.nos) {
            if (this.nnO != null) {
                this.nnO.s();
            }
        } else if (this.nor != null) {
            this.nor.b(this.nor.LV(3), 20L);
        }
    }

    private void b(final String str, String str2) {
        com.kascend.chushou.c.c.dMk().a(new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.VideoPlayer.8
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
                        VideoPlayer.this.bM(r.mMessage, r.mRc);
                        return;
                    }
                    FullRoomInfo fullRoomInfo = (FullRoomInfo) r.mData;
                    VideoPlayer.this.dMK().a(fullRoomInfo.mBangMap);
                    if (h.isEmpty(fullRoomInfo.mRoominfo.mRoomID)) {
                        fullRoomInfo.mRoominfo.mRoomID = VideoPlayer.this.P;
                    }
                    if (!h.isEmpty(fullRoomInfo.mGeneralTabGifts)) {
                        com.kascend.chushou.d.e.a(VideoPlayer.this.noo, new ArrayList(fullRoomInfo.mGeneralTabGifts));
                    }
                    if (VideoPlayer.this.nnQ != null) {
                        VideoPlayer.this.nnQ.a(fullRoomInfo);
                    }
                    VideoPlayer.this.L = false;
                    if (VideoPlayer.this.B) {
                        if (VideoPlayer.this.C && !"3".equals(VideoPlayer.this.R) && fullRoomInfo != null && fullRoomInfo.mRoominfo != null && fullRoomInfo.mRoominfo.mStyle == 1 && !h.isEmpty(fullRoomInfo.mRoominfo.mGameId)) {
                            z = true;
                        }
                        if (!z) {
                            if (VideoPlayer.this.nnO != null) {
                                VideoPlayer.this.nnO.a(VideoPlayer.this.nnQ);
                            }
                            if (!h.isEmpty(fullRoomInfo.mRoominfo.mGameId)) {
                                VideoPlayer.this.S();
                            } else {
                                if (VideoPlayer.this.nnQ != null) {
                                    VideoPlayer.this.nnQ.f = null;
                                }
                                VideoPlayer.this.S();
                            }
                        } else {
                            VideoPlayer.this.a(1, "1", true);
                            if (VideoPlayer.this.nnO != null) {
                                VideoPlayer.this.nnO.a(VideoPlayer.this.nnQ);
                            }
                        }
                    } else {
                        if (h.isEmpty(fullRoomInfo.mRoominfo.mGameId)) {
                            if (VideoPlayer.this.nnQ != null) {
                                VideoPlayer.this.nnQ.f = null;
                            }
                            VideoPlayer.this.a(1, "1");
                        } else {
                            VideoPlayer.this.a(1, "1", true);
                        }
                        if (VideoPlayer.this.nnO != null) {
                            VideoPlayer.this.nnO.a(VideoPlayer.this.nnQ);
                        }
                    }
                    if (VideoPlayer.this.nnQ != null && !VideoPlayer.this.nnQ.m()) {
                        if (VideoPlayer.this.noa != null) {
                            VideoPlayer.this.noa.d();
                            VideoPlayer.this.noa = null;
                        }
                        VideoPlayer.this.noa = new com.kascend.chushou.toolkit.d(900000L, VideoPlayer.this.noc, VideoPlayer.this.nor);
                        VideoPlayer.this.noa.a();
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
        if (this.nnQ != null) {
            this.nnQ.a((FullRoomInfo) null);
        }
        this.L = false;
        c(str, i);
        if (this.nnK != null) {
            this.nnK.stop();
        }
        if (this.nnL != null) {
            this.nnL.stop();
        }
        if (this.nnM != null) {
            this.nnM.stop();
        }
    }

    public void l() {
        tv.chushou.zues.utils.e.d(this.v, "retryGetPlayList");
        c();
        if (dMC()) {
            aX(this.P, false);
        } else {
            a(this.P, dMM(), false);
        }
    }

    public void m() {
        a(this.ag, false);
    }

    private void a(final String str, String str2, boolean z) {
        this.J = true;
        VideoPlayInfo K = j.dMu().K(str + str2, 600000L);
        if (K != null) {
            a((ArrayList) K.mPlayUrls);
            this.J = false;
        } else if (z) {
            ParserRet fX = com.kascend.chushou.player.c.a.dNi().fX(str, str2);
            if (fX.mRc != 0) {
                tv.chushou.zues.utils.e.e(this.v, "getPlayUrlSync fail, try to getPlaylist");
                a(str, str2, false);
                return;
            }
            a(fX, str);
        } else {
            com.kascend.chushou.player.c.a.dNi().a(str, str2, new a.InterfaceC0829a() { // from class: com.kascend.chushou.player.VideoPlayer.9
                @Override // com.kascend.chushou.player.c.a.InterfaceC0829a
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
    private void aX(final String str, boolean z) {
        boolean equals;
        this.J = true;
        VideoPlayInfo L = j.dMu().L(str, 600000L);
        if (L != null) {
            a((ArrayList) L.mPlayUrls);
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
                ParserRet aY = com.kascend.chushou.player.c.a.dNi().aY(str, equals);
                if (aY.mRc != 0) {
                    tv.chushou.zues.utils.e.e(this.v, "getVideoPlayUrlSync fail, try to getVideoPlaylist");
                    aX(str, false);
                    return;
                }
                a(aY, str);
                return;
            }
            com.kascend.chushou.player.c.a.dNi().a(str, new a.InterfaceC0829a() { // from class: com.kascend.chushou.player.VideoPlayer.10
                @Override // com.kascend.chushou.player.c.a.InterfaceC0829a
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
                if (this.nnQ.f == null) {
                    this.nnQ.f = new ArrayList<>();
                }
                this.nnQ.f.clear();
                this.nnQ.f.addAll(arrayList);
                if ("1".equals(this.R)) {
                    j.dMu().a(str + dMM(), arrayList);
                } else {
                    j.dMu().t(str, arrayList);
                }
                a(arrayList);
                return;
            }
            if (this.nnQ != null) {
                this.nnQ.f = null;
            }
            if (this.nor != null) {
                Message LV = this.nor.LV(5);
                LV.arg1 = 2;
                LV.arg2 = parserRet.mRc;
                this.nor.R(LV);
            }
        }
    }

    private void c(String str, int i) {
        s();
        if (this.nnV != null) {
            this.nnV.a();
        }
        if (h.isEmpty(str)) {
            str = getString(a.i.str_load_data_failed);
        }
        a(str, i);
    }

    public void n() {
        if (this.nnY != null && this.nnU != null && this.nnZ != null) {
            this.nnY.setVisibility(0);
            this.nnU.setVisibility(8);
            this.nnZ.setVisibility(8);
        }
    }

    public void o() {
        if (this.noe != null && this.noe.getVisibility() == 0) {
            this.noe.zR(0);
            this.noe.setVisibility(8);
        }
    }

    public void p() {
        if (this.nof != null && this.nof.getVisibility() == 0) {
            this.nof.setVisibility(8);
        }
    }

    public void q() {
        this.nos = true;
    }

    protected void r() {
        this.nnY.setVisibility(8);
        this.nnZ.setVisibility(0);
        this.nnU.setVisibility(0);
        if (this.nnT != null) {
            this.T.setVisibility(8);
            this.nnT.setVisibility(0);
            this.U.setText(getString(a.i.str_dialog_loading_content));
            this.U.setVisibility(8);
        }
    }

    protected void a(String str, int i) {
        this.nnY.setVisibility(8);
        this.nnZ.setVisibility(0);
        this.nnU.setVisibility(0);
        if (this.nnT != null) {
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
                            com.kascend.chushou.c.c.dMk().b(new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.VideoPlayer.11.1
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
                            }, VideoPlayer.this.P, (String) null, VideoPlayer.this.nnQ.h);
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
            this.nnT.setVisibility(8);
            this.nof.setVisibility(8);
        }
    }

    public void s() {
        if (this.nor != null) {
            this.nor.removeMessages(1);
        }
    }

    private void a(ArrayList<PlayUrl> arrayList) {
        boolean z;
        if (this.nnQ.f == null) {
            this.nnQ.f = new ArrayList<>();
        }
        this.nnQ.f.clear();
        this.nnQ.f.addAll(arrayList);
        if (com.kascend.chushou.d.e.b() && !"4".equals(this.aq)) {
            int c = com.kascend.chushou.d.e.c();
            if (c == -1) {
                b(arrayList);
                return;
            } else if (this.aw) {
                this.aw = false;
                if (c == 0) {
                    this.nnQ.d = false;
                    f(arrayList, true);
                    return;
                }
                if (this.nnQ != null && this.nnQ.f != null) {
                    Iterator<PlayUrl> it = this.nnQ.f.iterator();
                    while (it.hasNext()) {
                        if ("2".equals(it.next().mType)) {
                            z = true;
                            break;
                        }
                    }
                }
                z = false;
                this.nnQ.d = z;
                f(arrayList, true);
                return;
            } else {
                if (this.nnQ.e) {
                    this.nnQ.d = !this.nnQ.d;
                    this.nnQ.e = false;
                    this.nou = true;
                } else if ("4".equals(this.aq)) {
                    this.nnQ.d = true;
                }
                f(arrayList, true);
                return;
            }
        }
        if (this.nnQ.e) {
            this.nnQ.d = !this.nnQ.d;
            this.nnQ.e = false;
            this.nou = true;
        } else if ("4".equals(this.aq)) {
            this.nnQ.d = true;
        }
        f(arrayList, true);
    }

    private void b(ArrayList<PlayUrl> arrayList) {
        if ("1".equals(this.R)) {
            if ("2".equals(this.nom)) {
                d(false, arrayList);
            } else if (this.nnO != null) {
                this.nnO.f(arrayList, false);
            }
        } else if (this.nnO != null) {
            this.nnO.f(arrayList, false);
        }
    }

    public void c(boolean z) {
        this.nnQ.d = false;
        com.kascend.chushou.d.e.a(0);
        ArrayList<PlayUrl> arrayList = this.nnQ.f;
        if (!h.isEmpty(arrayList)) {
            if (z) {
                f(arrayList, false);
                if (this.nor != null) {
                    this.nor.LT(2);
                    return;
                }
                return;
            }
            f(arrayList, true);
        }
    }

    public void d(boolean z) {
        this.nnQ.d = true;
        com.kascend.chushou.d.e.a(1);
        ArrayList<PlayUrl> arrayList = this.nnQ.f;
        if (!h.isEmpty(arrayList)) {
            if (z) {
                f(arrayList, false);
                if (this.nor != null) {
                    this.nor.LT(2);
                    return;
                }
                return;
            }
            f(arrayList, true);
        }
    }

    @Subscribe
    public void onNotifyEvent(com.kascend.chushou.b.a.a.j jVar) {
        if (!isFinishing() && jVar.a == 1 && !"5".equals(this.R) && !dMw()) {
            tv.chushou.zues.utils.e.d(this.v, "onNetworkChangeEvent 3G=" + com.kascend.chushou.b.dMh().b + "  wifi=" + com.kascend.chushou.b.dMh().a);
            if (com.kascend.chushou.d.e.b() && !"4".equals(this.aq)) {
                if (com.kascend.chushou.d.e.c() == -1) {
                    if (this.nnO != null) {
                        this.nnO.e(false);
                    }
                    if ("1".equals(this.R)) {
                        if ("2".equals(this.nom)) {
                            d(true, null);
                            return;
                        } else if (this.nnO != null) {
                            this.nnO.f(this.nnQ.f, true);
                            return;
                        } else {
                            return;
                        }
                    } else if (this.nnO != null) {
                        this.nnO.f(this.nnQ.f, true);
                        return;
                    } else {
                        return;
                    }
                }
                RxExecutor.postDelayed(this.noo, EventThread.MAIN_THREAD, 10L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.VideoPlayer.12
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!VideoPlayer.this.isFinishing() && com.kascend.chushou.b.dMh().b && !com.kascend.chushou.b.dMh().a) {
                            tv.chushou.zues.utils.g.c(VideoPlayer.this.w, VideoPlayer.this.getString(a.i.str_monet_notify));
                        }
                    }
                });
            } else if (com.kascend.chushou.b.dMh().a || com.kascend.chushou.b.dMh().b) {
                t();
                if (this.nor != null) {
                    this.nor.LT(2);
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
            if (this.nnQ.d) {
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
            String d = com.kascend.chushou.d.h.dMo().d();
            String str3 = h.isEmpty(d) ? "2" : d;
            if (this.nnQ.d) {
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
                if (this.nnQ != null) {
                    this.nnQ.a(playUrl2);
                    if (this.nor != null) {
                        Message LV = this.nor.LV(5);
                        LV.arg1 = 1;
                        this.nor.R(LV);
                    }
                }
                String b = com.kascend.chushou.player.c.a.b(playUrl2);
                if (!h.isEmpty(b)) {
                    this.nnJ = Uri.parse(b);
                    if (this.nou) {
                        this.nou = false;
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (z && this.nnK != null) {
                        a(false, z2);
                    }
                }
            }
        }
    }

    public void d(final boolean z, ArrayList<PlayUrl> arrayList) {
        if (this.nob == null || this.nob.a <= 0) {
            this.nob = com.kascend.chushou.view.b.a.a.dOx();
            this.nob.a(new a.InterfaceC0848a() { // from class: com.kascend.chushou.player.VideoPlayer.13
                @Override // com.kascend.chushou.view.b.a.a.InterfaceC0848a
                public void a(int i) {
                    if (i == a.f.tv_play_video) {
                        VideoPlayer.this.nob.dismissAllowingStateLoss();
                        VideoPlayer.this.c(z);
                    } else if (i == a.f.tv_play_audio) {
                        VideoPlayer.this.nob.dismissAllowingStateLoss();
                        VideoPlayer.this.d(z);
                    } else if (i == a.f.iv_close) {
                        VideoPlayer.this.finish();
                    } else {
                        if (i == a.f.tv_union_proxy) {
                        }
                    }
                }
            });
            this.nob.show(getSupportFragmentManager(), "showRoom");
        }
    }

    public void t() {
        if (this.nob != null) {
            this.nob.dismissAllowingStateLoss();
        }
        if (this.nnO != null) {
            this.nnO.v();
        }
    }

    public void u() {
        com.kascend.chushou.c.c.dMk().c(this.P, new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.VideoPlayer.16
            @Override // com.kascend.chushou.c.b
            public void a() {
            }

            @Override // com.kascend.chushou.c.b
            public void a(String str, JSONObject jSONObject) {
                if (!VideoPlayer.this.isFinishing()) {
                    ParserRet eb = com.kascend.chushou.c.e.eb(jSONObject);
                    if (eb.mRc == 0 && eb.mData != null) {
                        CycleLiveRoomInfo cycleLiveRoomInfo = (CycleLiveRoomInfo) eb.mData;
                        if (VideoPlayer.this.nnQ != null && cycleLiveRoomInfo != null && !h.isEmpty(cycleLiveRoomInfo.roomId)) {
                            FullRoomInfo dNa = VideoPlayer.this.nnQ.dNa();
                            if (dNa.cycleLiveRoomInfo == null) {
                                dNa.cycleLiveRoomInfo = cycleLiveRoomInfo;
                                VideoPlayer.this.d();
                            } else if (dNa.cycleLiveRoomInfo != null && !cycleLiveRoomInfo.roomId.equals(dNa.cycleLiveRoomInfo.roomId)) {
                                dNa.cycleLiveRoomInfo.copyCycleLiveRoomInfo(cycleLiveRoomInfo);
                                VideoPlayer.this.d();
                            } else {
                                dNa.cycleLiveRoomInfo.copyCycleLiveRoomInfo(cycleLiveRoomInfo);
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
        if (this.nnO != null) {
            this.nnO.N();
        }
    }

    public void v() {
        com.kascend.chushou.c.c.dMk().a(this.P, new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.VideoPlayer.17
            @Override // com.kascend.chushou.c.b
            public void a() {
            }

            @Override // com.kascend.chushou.c.b
            public void a(String str, JSONObject jSONObject) {
                if (!VideoPlayer.this.isFinishing()) {
                    ParserRet ec = com.kascend.chushou.c.e.ec(jSONObject);
                    if (ec.mRc == 0 && ec.mData != null) {
                        PkNotifyInfo pkNotifyInfo = (PkNotifyInfo) ec.mData;
                        VideoPlayer.this.nok.b = VideoPlayer.this.P;
                        if (pkNotifyInfo != null) {
                            VideoPlayer.this.nok.nsR = pkNotifyInfo;
                            if (VideoPlayer.this.nnO != null) {
                                VideoPlayer.this.nnO.a(pkNotifyInfo, VideoPlayer.this.P);
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
        if (this.nnS != null) {
            this.nnS.release();
            this.nnS = null;
        }
        com.kascend.chushou.c.c.dMk().a(this.P, new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.VideoPlayer.18
            @Override // com.kascend.chushou.c.b
            public void a() {
            }

            @Override // com.kascend.chushou.c.b
            public void a(String str, JSONObject jSONObject) {
                if (!VideoPlayer.this.isFinishing()) {
                    ParserRet ed = com.kascend.chushou.c.e.ed(jSONObject);
                    if (ed.mRc == 0 && ed.mData != null) {
                        RoomExpandInfo roomExpandInfo = (RoomExpandInfo) ed.mData;
                        if (VideoPlayer.this.nnQ != null) {
                            VideoPlayer.this.nnQ.npx = roomExpandInfo.mTopWebAdItem;
                            if (VideoPlayer.this.nnQ.s == null) {
                                VideoPlayer.this.nnQ.s = new ArrayList();
                            }
                            VideoPlayer.this.nnQ.s.clear();
                            VideoPlayer.this.nnQ.s.addAll(roomExpandInfo.mGiftTopRightIcons);
                            tv.chushou.zues.a.a.post(new i(50, VideoPlayer.this.nnQ.npx));
                        }
                        if (VideoPlayer.this.nnQ != null) {
                            VideoPlayer.this.nnQ.fE(roomExpandInfo.mExpandNavList);
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
                            VideoPlayer.this.nog.a(list);
                        }
                        List<com.kascend.chushou.player.ui.h5.c.c> list2 = roomExpandInfo.mLuckList;
                        if (!h.isEmpty(list2)) {
                            VideoPlayer.this.noh.a(list2);
                        }
                        com.kascend.chushou.player.ui.h5.c.c cVar = roomExpandInfo.mVoteItem;
                        if (cVar != null) {
                            VideoPlayer.this.noi.a(cVar);
                        }
                        List<com.kascend.chushou.player.ui.h5.c.b> list3 = roomExpandInfo.mInteractH5Item;
                        if (!h.isEmpty(list3)) {
                            VideoPlayer.this.nol.a(list3);
                        }
                        List<com.kascend.chushou.player.ui.h5.c.b> list4 = roomExpandInfo.mInteractNavItem;
                        if (!h.isEmpty(list4)) {
                            VideoPlayer.this.nol.a(list4);
                        }
                        VideoPlayer.this.nnS = (PrivilegeInfo) ed.mData1;
                        if (VideoPlayer.this.nnS != null) {
                            tv.chushou.zues.a.a.post(new l());
                        }
                        if (VideoPlayer.this.nnQ != null) {
                            VideoPlayer.this.nnQ.npD = roomExpandInfo.mIconConfig;
                            VideoPlayer.this.dMK().a(roomExpandInfo.mIconConfig.bangConfig);
                        }
                        List<SkinConfig> list5 = roomExpandInfo.skinConfig;
                        if (list5 != null && VideoPlayer.this.nnQ != null) {
                            VideoPlayer.this.nnQ.npG.clear();
                            int i = 0;
                            while (true) {
                                int i2 = i;
                                if (i2 >= list5.size()) {
                                    break;
                                }
                                SkinConfig skinConfig = list5.get(i2);
                                VideoPlayer.this.nnQ.npG.put(skinConfig.position, skinConfig.resource);
                                i = i2 + 1;
                            }
                            VideoPlayer.this.C();
                        }
                        VideoPlayer.this.a(roomExpandInfo.mIconConfig, VideoPlayer.this.nnQ != null ? VideoPlayer.this.nnQ.npG : null);
                        if (roomExpandInfo.mColorMap != null && roomExpandInfo.mColorMap.size() > 0 && com.kascend.chushou.b.dMh().c != null && com.kascend.chushou.b.dMh().c.size() <= 0) {
                            com.kascend.chushou.b.dMh().c.putAll(roomExpandInfo.mColorMap);
                            tv.chushou.zues.a.a.post(new i(52, null));
                        }
                        AutoBang autoBang = roomExpandInfo.mAutoBang;
                        if (autoBang != null && autoBang.currentTime != 0 && autoBang.bangTime != 0) {
                            VideoPlayer.this.dMK().a(autoBang);
                        }
                        if (!h.isEmpty(roomExpandInfo.mRelatedRoomList) && VideoPlayer.this.nnQ != null) {
                            VideoPlayer.this.nnQ.t = roomExpandInfo.mRelatedRoomList;
                            if (VideoPlayer.this.nnO != null && VideoPlayer.this.H) {
                                VideoPlayer.this.nnO.w();
                            }
                        }
                        if (roomExpandInfo.mRoomNewUserInfo != null && roomExpandInfo.mRoomNewUserInfo.mBarrierNoviceGuide && !com.kascend.chushou.d.h.dMo().k() && VideoPlayer.this.nnO != null) {
                            VideoPlayer.this.nnO.J();
                        }
                        if (roomExpandInfo.mRoomNewUserInfo != null && roomExpandInfo.mRoomNewUserInfo.mRewardNoviceGuide && !com.kascend.chushou.d.h.dMo().l() && VideoPlayer.this.nnO != null) {
                            VideoPlayer.this.nnO.K();
                        }
                        if (!h.isEmpty(roomExpandInfo.mShopWindowInfos)) {
                            if (VideoPlayer.this.nnQ != null) {
                                if (VideoPlayer.this.nnQ.npE == null) {
                                    VideoPlayer.this.nnQ.npE = new ArrayList();
                                }
                                VideoPlayer.this.nnQ.npE.addAll(roomExpandInfo.mShopWindowInfos);
                            }
                            if (VideoPlayer.this.nnO != null) {
                                VideoPlayer.this.nnO.L();
                            }
                        }
                        VideoPlayer.this.nok.b = VideoPlayer.this.P;
                        if (roomExpandInfo.mPkNotifyInfo != null) {
                            VideoPlayer.this.nok.nsR = roomExpandInfo.mPkNotifyInfo;
                            if (VideoPlayer.this.nnO != null) {
                                VideoPlayer.this.nnO.a(roomExpandInfo.mPkNotifyInfo, VideoPlayer.this.P);
                            }
                        } else {
                            VideoPlayer.this.nok.nsR = null;
                        }
                        if (roomExpandInfo.mTrumpetPocket != null && VideoPlayer.this.nnQ != null) {
                            VideoPlayer.this.nnQ.npF = roomExpandInfo.mTrumpetPocket;
                            if (VideoPlayer.this.nnO != null) {
                                VideoPlayer.this.nnO.M();
                            }
                        }
                        if (!h.isEmpty(roomExpandInfo.hotwordContentList)) {
                            if (VideoPlayer.this.nnQ != null) {
                                if (VideoPlayer.this.nnQ.w == null) {
                                    VideoPlayer.this.nnQ.w = new ArrayList();
                                }
                                VideoPlayer.this.nnQ.w.clear();
                                VideoPlayer.this.nnQ.w.addAll(roomExpandInfo.hotwordContentList);
                            }
                            if (VideoPlayer.this.nnO != null) {
                                VideoPlayer.this.nnO.b(roomExpandInfo.hotwordContentList);
                            }
                        }
                        VideoPlayer.this.U();
                        return;
                    }
                    a(ed.mRc, ed.mMessage);
                }
            }

            @Override // com.kascend.chushou.c.b
            public void a(int i, String str) {
                tv.chushou.zues.utils.e.e(VideoPlayer.this.v, "get room gift popup list failed, rc =" + i + ", errorMsg=" + str);
            }
        }, this.ag, this.nom);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U() {
        if (!h.isEmpty(com.kascend.chushou.a.a.dMi().nnj)) {
            StringBuilder sb = new StringBuilder();
            if (com.kascend.chushou.a.a.dMi().nnj.contains(com.kascend.chushou.a.a.f)) {
                if (sb.length() > 0) {
                    sb.append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                sb.append(com.kascend.chushou.a.a.f);
            }
            if (com.kascend.chushou.a.a.dMi().nnj.contains(com.kascend.chushou.a.a.g)) {
                if (sb.length() > 0) {
                    sb.append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                sb.append(com.kascend.chushou.a.a.g);
            }
            if (com.kascend.chushou.a.a.dMi().nnj.contains(com.kascend.chushou.a.a.i)) {
                if (sb.length() > 0) {
                    sb.append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                sb.append(com.kascend.chushou.a.a.i);
            }
            if (com.kascend.chushou.a.a.dMi().nnj.contains(com.kascend.chushou.a.a.h)) {
                if (sb.length() > 0) {
                    sb.append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                sb.append(com.kascend.chushou.a.a.h);
            }
            if (com.kascend.chushou.a.a.dMi().nnj.contains(com.kascend.chushou.a.a.j)) {
                if (sb.length() > 0) {
                    sb.append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                sb.append(com.kascend.chushou.a.a.j);
            }
            if (com.kascend.chushou.a.a.dMi().nnj.contains(com.kascend.chushou.a.a.l)) {
                if (sb.length() > 0) {
                    sb.append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                sb.append(com.kascend.chushou.a.a.l);
            }
            if (com.kascend.chushou.a.a.dMi().nnj.contains(com.kascend.chushou.a.a.m)) {
                if (sb.length() > 0) {
                    sb.append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                sb.append(com.kascend.chushou.a.a.m);
            }
            if (sb.length() != 0) {
                com.kascend.chushou.a.a.dMi().a(sb.toString(), this.P, new a.c() { // from class: com.kascend.chushou.player.VideoPlayer.19
                    @Override // com.kascend.chushou.a.a.c
                    public void a(List<ListItem> list) {
                        if (VideoPlayer.this.nnQ != null && list != null) {
                            int i = 0;
                            while (true) {
                                int i2 = i;
                                if (i2 >= list.size()) {
                                    break;
                                }
                                if (list.get(i2).mAdExtraInfo != null) {
                                    if (com.kascend.chushou.a.a.f.equals(list.get(i2).mAdExtraInfo.mCode)) {
                                        VideoPlayer.this.nnQ.npw = list.get(i2);
                                    } else if (com.kascend.chushou.a.a.g.equals(list.get(i2).mAdExtraInfo.mCode)) {
                                        VideoPlayer.this.nnQ.npv = list.get(i2);
                                    } else if (com.kascend.chushou.a.a.i.equals(list.get(i2).mAdExtraInfo.mCode)) {
                                        VideoPlayer.this.nnQ.npy = list.get(i2);
                                    } else if (com.kascend.chushou.a.a.h.equals(list.get(i2).mAdExtraInfo.mCode)) {
                                        VideoPlayer.this.nnQ.npz = list.get(i2);
                                    } else if (com.kascend.chushou.a.a.j.equals(list.get(i2).mAdExtraInfo.mCode)) {
                                        VideoPlayer.this.nnQ.npC = list.get(i2);
                                    } else if (com.kascend.chushou.a.a.l.equals(list.get(i2).mAdExtraInfo.mCode)) {
                                        VideoPlayer.this.nnQ.npA = list.get(i2);
                                    } else if (com.kascend.chushou.a.a.m.equals(list.get(i2).mAdExtraInfo.mCode)) {
                                        VideoPlayer.this.nnQ.npB = list.get(i2);
                                    }
                                }
                                i = i2 + 1;
                            }
                            if (VideoPlayer.this.nnO != null) {
                                VideoPlayer.this.nnO.H();
                            }
                        }
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str, String str2) {
        if (dMC()) {
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
                this.nnX.setSystemUiVisibility(i);
                return;
            }
            this.nnX.setSystemUiVisibility(1792);
        }
    }

    public void f(boolean z) {
        Window window;
        View decorView;
        if (com.kascend.chushou.b.dMh().d != 1 && (window = getWindow()) != null && (decorView = window.getDecorView()) != null) {
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
        if (this.nnO != null) {
            this.nnO.a(i, i2, intent);
        }
    }

    public Uri dMD() {
        return this.nnJ;
    }

    @Override // com.kascend.chushou.view.base.BaseActivity
    protected int y() {
        return 0;
    }

    public void xB(boolean z) {
        if (this.nnX != null) {
            this.nnX.owl = z;
        }
    }

    public void dME() {
        if (this.nnX != null) {
            this.nnX.dME();
        }
    }

    public boolean dMF() {
        return this.ae;
    }

    public void g(boolean z) {
        this.ae = z;
    }

    public void h(boolean z) {
        if (this.nnX != null) {
            this.nnX.setIsTranslucentStatus(z);
        }
    }

    public void z() {
        if (this.nnX != null) {
            this.nnX.eaE();
        }
    }

    @Override // com.kascend.chushou.widget.gifts.RoomSendGiftView.a
    public void A() {
        if (this.nnV != null) {
            this.nnV.b();
        }
        if (this.nnQ != null) {
            this.nnQ.z = true;
        }
    }

    @Override // com.kascend.chushou.widget.gifts.RoomSendGiftView.a
    public void B() {
        if (this.nnV != null) {
            this.nnV.b();
        }
    }

    public void a(List<ListItem> list) {
        if (this.nnO != null) {
            this.nnO.a(list);
        }
    }

    public void a(IconConfig iconConfig, Map<String, SkinConfig.SkinRes> map) {
        if (this.nnO != null) {
            this.nnO.a(iconConfig, map);
        }
    }

    public void C() {
        if (this.nnO != null) {
            this.nnO.I();
        }
    }

    @Override // com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC0840a
    public void a(int i) {
        if (this.nnO != null) {
            this.nnO.a(i);
        }
    }

    @Override // com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC0840a
    public void D() {
        if (!isFinishing() && this.nnO != null) {
            this.nnO.D();
        }
    }

    @Override // com.kascend.chushou.player.ui.h5.b.b.a
    public void a(long j) {
        if (!isFinishing() && this.nnO != null) {
            this.nnO.a(j);
        }
    }

    @Override // com.kascend.chushou.player.ui.h5.b.b.a
    public void a(com.kascend.chushou.player.ui.h5.c.a aVar) {
        if (aVar != null && this.nnO != null) {
            this.nnO.a(aVar);
        }
    }

    @Override // com.kascend.chushou.player.ui.h5.b.b.a
    public void b(int i) {
        if (this.nnO != null) {
            this.nnO.b(i);
        }
    }

    @Override // com.kascend.chushou.player.ui.h5.d.a.InterfaceC0839a
    public void b(long j) {
        if (!isFinishing() && this.nnO != null) {
            this.nnO.b(j);
        }
    }

    @Override // com.kascend.chushou.player.ui.h5.a.a.InterfaceC0837a
    public void c(int i) {
        if (!isFinishing() && this.nnO != null) {
            this.nnO.c(i);
        }
    }

    @Override // com.kascend.chushou.player.ui.h5.d.a.InterfaceC0839a
    public void b(com.kascend.chushou.player.ui.h5.c.a aVar) {
        if (aVar != null && this.nnO != null) {
            this.nnO.b(aVar);
        }
    }

    @Override // com.kascend.chushou.player.ui.a.a.InterfaceC0834a
    public void a(IconConfig.Config config) {
        if (this.nnO != null) {
            this.nnO.a(config);
        }
    }

    @Override // com.kascend.chushou.player.ui.a.a.InterfaceC0834a
    public void a(BangInfo bangInfo, String str) {
        if (this.nnO != null) {
            this.nnO.a(bangInfo, str);
        }
    }

    @Override // com.kascend.chushou.player.ui.a.a.InterfaceC0834a
    public void a(long j, BangInfo bangInfo, String str) {
        if (this.nnO != null) {
            this.nnO.a(j, bangInfo, str);
        }
    }

    public com.kascend.chushou.player.ui.h5.redpacket.a dMG() {
        return this.nog;
    }

    public com.kascend.chushou.player.ui.h5.b.b dMH() {
        return this.noh;
    }

    public com.kascend.chushou.player.ui.h5.d.a dMI() {
        return this.noi;
    }

    public com.kascend.chushou.player.ui.h5.a.a dMJ() {
        return this.nol;
    }

    public com.kascend.chushou.player.ui.a.a dMK() {
        return this.noj;
    }

    public com.kascend.chushou.player.e.a dML() {
        return this.nok;
    }

    @Override // com.kascend.chushou.view.base.BaseActivity, android.app.Activity
    public void finish() {
        super.finish();
        if ("3".equals(this.R)) {
            overridePendingTransition(17432576, a.C0824a.commonres_activity_exit_bottom);
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
        RxExecutor.postDelayed(this.noo, EventThread.MAIN_THREAD, aVar.d, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.VideoPlayer.2
            @Override // java.lang.Runnable
            public void run() {
                if (VideoPlayer.this.nnO != null) {
                    VideoPlayer.this.nnO.c(aVar);
                }
            }
        });
    }

    private void e(final com.kascend.chushou.player.ui.h5.c.a aVar) {
        if (!com.kascend.chushou.d.h.dMo().dMr().contains(aVar.b)) {
            if (aVar.d < 0) {
                aVar.d = 0;
            }
            RxExecutor.postDelayed(this.noo, EventThread.MAIN_THREAD, aVar.d, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.VideoPlayer.3
                @Override // java.lang.Runnable
                public void run() {
                    if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.nnO != null) {
                        VideoPlayer.this.nnO.c(aVar);
                    }
                }
            });
        }
    }

    private String dMM() {
        if ("4".equals(this.aq)) {
            return TbEnum.SystemMessage.EVENT_ID_GROUP_NAME_MODIFY + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP + TbEnum.SystemMessage.EVENT_ID_NOTICE_MODIFY;
        }
        return "2" + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP + "1" + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP + TbEnum.SystemMessage.EVENT_ID_GROUP_NAME_MODIFY + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP + TbEnum.SystemMessage.EVENT_ID_NOTICE_MODIFY;
    }

    /* loaded from: classes6.dex */
    private class a extends BroadcastReceiver {
        private a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("android.media.VOLUME_CHANGED_ACTION".equals(intent.getAction())) {
                if (VideoPlayer.this.nnW != null && !VideoPlayer.this.isFinishing()) {
                    VideoPlayer.n = VideoPlayer.this.nnW.getStreamVolume(3);
                }
                if (!VideoPlayer.this.isFinishing() && (VideoPlayer.this.nnO instanceof f)) {
                    ((f) VideoPlayer.this.nnO).ab();
                }
            }
        }
    }

    public String a(String str) {
        HashMap hashMap = new HashMap(tv.chushou.zues.utils.d.TS(str));
        if ("1".equals(this.R)) {
            hashMap.put("roomId", this.P);
        } else if ("3".equals(this.R)) {
            hashMap.put("videoId", this.P);
        }
        return tv.chushou.zues.utils.d.toJson(hashMap);
    }

    public boolean dMN() {
        if (this.nnO instanceof com.kascend.chushou.player.d.a) {
            return ((com.kascend.chushou.player.d.a) this.nnO).dNM();
        }
        if (this.nnO instanceof com.kascend.chushou.player.e.e) {
            return true;
        }
        return false;
    }
}

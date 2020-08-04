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
    private c nnP;
    b nnS;
    public PrivilegeInfo nnU;
    com.kascend.chushou.widget.a.b nnX;
    private KPSwitchRootRelativeLayout nnZ;
    private FrameLayout noa;
    private LinearLayout nob;
    private com.kascend.chushou.toolkit.d noc;
    com.kascend.chushou.view.b.a.a nod;
    private FrescoThumbnailView nog;
    private FrameLayout noh;
    public com.kascend.chushou.player.feedback.a nop;
    private a nor;
    private CSTVWifiReceiver nos;
    private boolean B = true;
    private boolean C = false;
    private Uri nnL = null;
    private tv.chushou.common.player.a nnM = null;
    public tv.chushou.common.player.a nnN = null;
    public tv.chushou.common.player.a nnO = null;
    public boolean d = false;
    public boolean e = false;
    private e nnQ = null;
    private boolean H = false;
    private com.kascend.chushou.view.user.b nnR = null;
    private boolean J = false;
    private boolean K = false;
    private boolean L = false;
    private boolean M = false;
    private long nnT = 0;
    private int O = 0;
    public boolean g = false;
    private ImageView T = null;
    private TextView U = null;
    private AnimationImageView nnV = null;
    private View nnW = null;
    public boolean j = false;
    public float k = 0.0f;
    public float l = 0.0f;
    public boolean m = false;
    public AudioManager nnY = null;
    private d.a noe = new d.a() { // from class: com.kascend.chushou.player.VideoPlayer.1
        @Override // com.kascend.chushou.toolkit.d.a
        public void a() {
            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.nou != null) {
                VideoPlayer.this.nou.LT(4);
            }
        }
    };
    private boolean ae = false;
    public boolean q = true;
    public long r = -1;
    public long s = -1;
    private PowerManager.WakeLock nof = null;
    public String t = null;
    private final com.kascend.chushou.player.ui.h5.redpacket.a noi = new com.kascend.chushou.player.ui.h5.redpacket.a(this);
    private final com.kascend.chushou.player.ui.h5.b.b noj = new com.kascend.chushou.player.ui.h5.b.b(this);
    private final com.kascend.chushou.player.ui.h5.d.a nok = new com.kascend.chushou.player.ui.h5.d.a(this);
    private final com.kascend.chushou.player.ui.a.a nol = new com.kascend.chushou.player.ui.a.a(this);
    private final com.kascend.chushou.player.e.a nom = new com.kascend.chushou.player.e.a();
    private final com.kascend.chushou.player.ui.h5.a.a non = new com.kascend.chushou.player.ui.h5.a.a(this);
    private String noo = "1";
    private String aq = "2";
    private io.reactivex.disposables.a noq = new io.reactivex.disposables.a();
    private tv.chushou.zues.c nou = new tv.chushou.zues.c(new Handler.Callback() { // from class: com.kascend.chushou.player.VideoPlayer.6
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            try {
                if (!VideoPlayer.this.isFinishing()) {
                    switch (message.what) {
                        case 1:
                            VideoPlayer.this.nou.removeMessages(1);
                            com.kascend.chushou.c.c.dMl().a(VideoPlayer.this.P, VideoPlayer.this.nnS != null ? VideoPlayer.this.nnS.h : null, System.currentTimeMillis());
                            VideoPlayer.this.nou.B(1, VideoPlayer.A);
                            break;
                        case 2:
                            VideoPlayer.this.a(true, (Uri) null, false);
                            break;
                        case 3:
                            VideoPlayer.this.S();
                            break;
                        case 4:
                            if (VideoPlayer.this.nnQ != null) {
                                VideoPlayer.this.nnQ.a(true);
                            }
                            if (VideoPlayer.this.noc != null) {
                                VideoPlayer.this.noc.d();
                                VideoPlayer.this.noc = null;
                                break;
                            }
                            break;
                        case 5:
                            int i = message.arg1;
                            if (i == 1) {
                                if (VideoPlayer.this.nnQ != null) {
                                    VideoPlayer.this.nnQ.p();
                                    break;
                                }
                            } else if (i == 2 && VideoPlayer.this.nnQ != null) {
                                VideoPlayer.this.nnQ.e(message.arg2);
                                break;
                            }
                            break;
                        case 6:
                            if (!com.kascend.chushou.b.dMi().a && !com.kascend.chushou.b.dMi().b && VideoPlayer.this.nnQ != null) {
                                VideoPlayer.this.nnQ.g(true);
                                break;
                            } else {
                                VideoPlayer.this.c();
                                break;
                            }
                            break;
                        case 7:
                            tv.chushou.zues.utils.e.d(VideoPlayer.this.v, "MSG_BUFFER_DEALY: ");
                            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.nnQ != null && VideoPlayer.this.M && !VideoPlayer.this.e) {
                                VideoPlayer.this.nnQ.h(true);
                                VideoPlayer.this.nnT = 0L;
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
    private boolean nov = false;
    private boolean aw = true;
    private boolean nox = false;
    private tv.chushou.common.player.b noy = new tv.chushou.common.player.b() { // from class: com.kascend.chushou.player.VideoPlayer.14
        @Override // tv.chushou.common.player.b
        public void dMQ() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerACallback onSetVideoViewLayout");
            if (!VideoPlayer.this.isFinishing()) {
                if ((VideoPlayer.this.nnQ == null || !VideoPlayer.this.nnQ.H) && VideoPlayer.this.nnQ != null && !VideoPlayer.this.d) {
                    VideoPlayer.this.nnQ.y();
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void Kx(int i) {
            if (!VideoPlayer.this.isFinishing()) {
                if ((VideoPlayer.this.nnQ == null || !VideoPlayer.this.nnQ.H) && VideoPlayer.this.nnQ != null && !VideoPlayer.this.d) {
                    VideoPlayer.this.nnQ.g(i);
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void dMR() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerACallback onCompletePlayback");
            if (!VideoPlayer.this.isFinishing()) {
                if (!h.isEmpty(VideoPlayer.this.P)) {
                    j.dMv().a(VideoPlayer.this.P, 0);
                }
                VideoPlayer.this.K = false;
                if (VideoPlayer.this.nou != null) {
                    VideoPlayer.this.nou.removeMessages(1);
                }
                if ((VideoPlayer.this.nnQ == null || !VideoPlayer.this.nnQ.H) && VideoPlayer.this.nnQ != null && !VideoPlayer.this.d) {
                    VideoPlayer.this.nou.removeMessages(7);
                    VideoPlayer.this.M = false;
                    VideoPlayer.this.nnQ.z();
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void dMS() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerACallback onVideoRenderingStart");
            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.nnQ != null) {
                VideoPlayer.this.nnQ.G();
            }
        }

        @Override // tv.chushou.common.player.b
        public void dMT() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerACallback onPreparedPlayback");
            if (!VideoPlayer.this.isFinishing()) {
                if (VideoPlayer.this.nnQ == null || !VideoPlayer.this.nnQ.H) {
                    VideoPlayer.this.nou.removeMessages(6);
                    VideoPlayer.this.nnT = 0L;
                    VideoPlayer.this.O = 0;
                    if (VideoPlayer.this.nnM != null && VideoPlayer.this.nnQ != null) {
                        VideoPlayer.this.nnM.setVolume(VideoPlayer.this.nnQ.J, VideoPlayer.this.nnQ.J);
                    }
                    if (VideoPlayer.this.nnS != null) {
                        VideoPlayer.this.K = false;
                        FullRoomInfo dNb = VideoPlayer.this.dMD() ? null : VideoPlayer.this.nnS.dNb();
                        if (VideoPlayer.this.L || dNb != null) {
                            if (VideoPlayer.this.nnS.e) {
                                VideoPlayer.this.nnS.e = false;
                                VideoPlayer.this.nnS.d = !VideoPlayer.this.nnS.d;
                            }
                            if (VideoPlayer.this.nnQ != null) {
                                VideoPlayer.this.c("1", (String) null);
                                if (!VideoPlayer.this.d) {
                                    VideoPlayer.this.nnQ.i(true);
                                } else if (VideoPlayer.this.e) {
                                    VideoPlayer.this.e = false;
                                    VideoPlayer.this.nnQ.B();
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
                if (VideoPlayer.this.nou != null) {
                    VideoPlayer.this.nou.removeMessages(7);
                }
                if (VideoPlayer.this.nou != null) {
                    VideoPlayer.this.nou.removeMessages(1);
                }
                if ((VideoPlayer.this.nnQ == null || !VideoPlayer.this.nnQ.H) && !VideoPlayer.this.dMx()) {
                    if (!"10004".equals(VideoPlayer.this.t)) {
                        if (VideoPlayer.this.nnQ != null) {
                            if (VideoPlayer.this.d) {
                                VideoPlayer.this.nnN.stop();
                                VideoPlayer.this.nnN.release();
                                VideoPlayer.this.e = false;
                                VideoPlayer.this.nnQ.C();
                            }
                            if (!com.kascend.chushou.b.dMi().a && !com.kascend.chushou.b.dMi().b) {
                                VideoPlayer.this.nnQ.g(true);
                            } else if (VideoPlayer.this.d) {
                                VideoPlayer.this.nnQ.a(i, true);
                            } else {
                                VideoPlayer.this.nnQ.a(i, false);
                            }
                            VideoPlayer.this.c("2", (String) null);
                            return;
                        }
                        return;
                    }
                    dMR();
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void dMU() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerACallback onBufferingStart");
            if (!VideoPlayer.this.isFinishing()) {
                if ((VideoPlayer.this.nnQ == null || !VideoPlayer.this.nnQ.H) && VideoPlayer.this.nnQ != null && !VideoPlayer.this.d) {
                    VideoPlayer.this.nnQ.E();
                    VideoPlayer.this.M = true;
                    long currentTimeMillis = System.currentTimeMillis();
                    VideoPlayer.this.nou.removeMessages(7);
                    if (!VideoPlayer.this.g) {
                        VideoPlayer.y(VideoPlayer.this);
                    }
                    tv.chushou.zues.utils.e.d(VideoPlayer.this.v, "currentTime: -- >" + currentTimeMillis + "  bufferTime-->" + VideoPlayer.this.nnT + "  bufferCount-->" + VideoPlayer.this.O);
                    if (currentTimeMillis - VideoPlayer.this.nnT >= 20000 || VideoPlayer.this.O < 2 || VideoPlayer.this.nnQ.H) {
                        if (VideoPlayer.this.O == 1) {
                            VideoPlayer.this.nnT = currentTimeMillis;
                        }
                        VideoPlayer.this.nou.B(7, 5000L);
                    } else {
                        VideoPlayer.this.nou.LT(7);
                    }
                    if (VideoPlayer.this.g) {
                        VideoPlayer.this.g = false;
                    }
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void dMV() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerACallback onBufferingEnd");
            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.nnQ != null && !VideoPlayer.this.d) {
                VideoPlayer.this.nou.removeMessages(7);
                VideoPlayer.this.M = false;
                if (VideoPlayer.this.nnQ == null || !VideoPlayer.this.nnQ.H) {
                    if (VideoPlayer.this.nnM == null) {
                        VideoPlayer.this.nnQ.a(false, true, false);
                    } else {
                        VideoPlayer.this.nnQ.a(true, VideoPlayer.this.nnM.getPlayState() == 4, VideoPlayer.this.nnM.getPlayState() == 5);
                    }
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void dMW() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerACallback onPlayerStart");
            if (!VideoPlayer.this.isFinishing()) {
                if (VideoPlayer.this.nnQ == null || !VideoPlayer.this.nnQ.H) {
                    if (VideoPlayer.this.nnQ != null && !VideoPlayer.this.d) {
                        if (VideoPlayer.this.nnM != null) {
                            VideoPlayer.this.nnQ.F();
                            VideoPlayer.this.nnQ.a(true, VideoPlayer.this.nnM.getPlayState() == 4, VideoPlayer.this.nnM.getPlayState() == 5);
                        } else {
                            VideoPlayer.this.nnQ.a(false, true, false);
                        }
                    }
                    if (VideoPlayer.this.nou != null && !VideoPlayer.this.dMD()) {
                        VideoPlayer.this.nou.removeMessages(1);
                        VideoPlayer.this.nou.B(1, VideoPlayer.A);
                    }
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void dMX() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerACallback onPlayerPause");
            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.nou != null) {
                VideoPlayer.this.nou.removeMessages(1);
            }
        }

        @Override // tv.chushou.common.player.b
        public void dMY() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerACallback onPlayerStop");
            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.dMD() && VideoPlayer.this.nnN != null && !h.isEmpty(VideoPlayer.this.P) && VideoPlayer.this.nnN.getCurrentPos() > 0) {
                j.dMv().a(VideoPlayer.this.P, VideoPlayer.this.nnN.getCurrentPos());
            }
        }
    };
    private tv.chushou.common.player.b noz = new tv.chushou.common.player.b() { // from class: com.kascend.chushou.player.VideoPlayer.15
        @Override // tv.chushou.common.player.b
        public void dMQ() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerBCallback onSetVideoViewLayout");
            if (!VideoPlayer.this.isFinishing()) {
                if ((VideoPlayer.this.nnQ == null || !VideoPlayer.this.nnQ.H) && VideoPlayer.this.nnQ != null && VideoPlayer.this.d) {
                    VideoPlayer.this.nnQ.y();
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void Kx(int i) {
            if (!VideoPlayer.this.isFinishing()) {
                if ((VideoPlayer.this.nnQ == null || !VideoPlayer.this.nnQ.H) && VideoPlayer.this.nnQ != null && VideoPlayer.this.d) {
                    VideoPlayer.this.nnQ.g(i);
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void dMR() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerBCallback onCompletePlayback");
            if (!VideoPlayer.this.isFinishing()) {
                if (!h.isEmpty(VideoPlayer.this.P)) {
                    j.dMv().a(VideoPlayer.this.P, 0);
                }
                VideoPlayer.this.K = false;
                if (VideoPlayer.this.nou != null) {
                    VideoPlayer.this.nou.removeMessages(1);
                }
                if ((VideoPlayer.this.nnQ == null || !VideoPlayer.this.nnQ.H) && VideoPlayer.this.nnQ != null && VideoPlayer.this.d) {
                    VideoPlayer.this.nou.removeMessages(7);
                    VideoPlayer.this.M = false;
                    VideoPlayer.this.nnQ.z();
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void dMS() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerBCallback onVideoRenderingStart");
            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.nnQ != null) {
                VideoPlayer.this.nnQ.G();
            }
        }

        @Override // tv.chushou.common.player.b
        public void dMT() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerBCallback onPreparedPlayback");
            if (!VideoPlayer.this.isFinishing()) {
                if (VideoPlayer.this.nnQ == null || !VideoPlayer.this.nnQ.H) {
                    VideoPlayer.this.nou.removeMessages(6);
                    VideoPlayer.this.nnT = 0L;
                    VideoPlayer.this.O = 0;
                    if (VideoPlayer.this.nnM != null && VideoPlayer.this.nnQ != null) {
                        VideoPlayer.this.nnM.setVolume(VideoPlayer.this.nnQ.J, VideoPlayer.this.nnQ.J);
                    }
                    if (VideoPlayer.this.nnS != null) {
                        VideoPlayer.this.K = false;
                        FullRoomInfo dNb = VideoPlayer.this.dMD() ? null : VideoPlayer.this.nnS.dNb();
                        if (VideoPlayer.this.L || dNb != null) {
                            if (VideoPlayer.this.nnS.e) {
                                VideoPlayer.this.nnS.e = false;
                                VideoPlayer.this.nnS.d = !VideoPlayer.this.nnS.d;
                            }
                            if (VideoPlayer.this.nnQ != null) {
                                VideoPlayer.this.c("1", (String) null);
                                if (VideoPlayer.this.d) {
                                    VideoPlayer.this.nnQ.i(true);
                                } else if (VideoPlayer.this.e) {
                                    VideoPlayer.this.e = false;
                                    VideoPlayer.this.nnQ.B();
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
                if (VideoPlayer.this.nou != null) {
                    VideoPlayer.this.nou.removeMessages(7);
                }
                if (VideoPlayer.this.nou != null) {
                    VideoPlayer.this.nou.removeMessages(1);
                }
                if ((VideoPlayer.this.nnQ == null || !VideoPlayer.this.nnQ.H) && !VideoPlayer.this.dMx()) {
                    if (!"10004".equals(VideoPlayer.this.t)) {
                        if (VideoPlayer.this.nnQ != null) {
                            if (!VideoPlayer.this.d) {
                                VideoPlayer.this.nnO.stop();
                                VideoPlayer.this.nnO.release();
                                VideoPlayer.this.nnQ.C();
                                VideoPlayer.this.e = false;
                            }
                            if (!com.kascend.chushou.b.dMi().a && !com.kascend.chushou.b.dMi().b) {
                                VideoPlayer.this.nnQ.g(true);
                            } else if (VideoPlayer.this.d) {
                                VideoPlayer.this.nnQ.a(i, false);
                            } else {
                                VideoPlayer.this.nnQ.a(i, true);
                            }
                            VideoPlayer.this.c("2", (String) null);
                            return;
                        }
                        return;
                    }
                    dMR();
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void dMU() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerBCallback onBufferingStart");
            if (!VideoPlayer.this.isFinishing()) {
                if ((VideoPlayer.this.nnQ == null || !VideoPlayer.this.nnQ.H) && VideoPlayer.this.nnQ != null && VideoPlayer.this.d) {
                    VideoPlayer.this.nnQ.E();
                    VideoPlayer.this.M = true;
                    VideoPlayer.this.nou.removeMessages(7);
                    long currentTimeMillis = System.currentTimeMillis();
                    if (!VideoPlayer.this.g) {
                        VideoPlayer.y(VideoPlayer.this);
                    }
                    tv.chushou.zues.utils.e.d(VideoPlayer.this.v, "currentTime: -- >" + currentTimeMillis + "  bufferTime-->" + VideoPlayer.this.nnT + "  bufferCount-->" + VideoPlayer.this.O);
                    if (currentTimeMillis - VideoPlayer.this.nnT >= 20000 || VideoPlayer.this.O < 2 || VideoPlayer.this.nnQ.H) {
                        if (VideoPlayer.this.O == 1) {
                            VideoPlayer.this.nnT = currentTimeMillis;
                        }
                        VideoPlayer.this.nou.B(7, 5000L);
                    } else {
                        VideoPlayer.this.nnT = 0L;
                        VideoPlayer.this.O = 0;
                        VideoPlayer.this.nou.LT(7);
                    }
                    if (VideoPlayer.this.g) {
                        VideoPlayer.this.g = false;
                    }
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void dMV() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerBCallback onBufferingEnd");
            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.nnQ != null && VideoPlayer.this.d) {
                VideoPlayer.this.M = false;
                VideoPlayer.this.nou.removeMessages(7);
                if (VideoPlayer.this.nnQ == null || !VideoPlayer.this.nnQ.H) {
                    if (VideoPlayer.this.nnM == null) {
                        VideoPlayer.this.nnQ.a(false, true, false);
                    } else {
                        VideoPlayer.this.nnQ.a(true, VideoPlayer.this.nnM.getPlayState() == 4, VideoPlayer.this.nnM.getPlayState() == 5);
                    }
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void dMW() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerBCallback onPlayerStart");
            if (!VideoPlayer.this.isFinishing()) {
                if (VideoPlayer.this.nnQ == null || !VideoPlayer.this.nnQ.H) {
                    if (VideoPlayer.this.nnQ != null && VideoPlayer.this.d) {
                        if (VideoPlayer.this.nnM != null) {
                            VideoPlayer.this.nnQ.F();
                            VideoPlayer.this.nnQ.a(true, VideoPlayer.this.nnM.getPlayState() == 4, VideoPlayer.this.nnM.getPlayState() == 5);
                        } else {
                            VideoPlayer.this.nnQ.a(false, true, false);
                        }
                    }
                    if (VideoPlayer.this.nou != null && !VideoPlayer.this.dMD()) {
                        VideoPlayer.this.nou.removeMessages(1);
                        VideoPlayer.this.nou.B(1, VideoPlayer.A);
                    }
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void dMX() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerBCallback onPlayerPause");
            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.nou != null) {
                VideoPlayer.this.nou.removeMessages(1);
            }
        }

        @Override // tv.chushou.common.player.b
        public void dMY() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerBCallback onPlayerStop");
            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.dMD() && VideoPlayer.this.nnO != null && !h.isEmpty(VideoPlayer.this.P) && VideoPlayer.this.nnO.getCurrentPos() > 0) {
                j.dMv().a(VideoPlayer.this.P, VideoPlayer.this.nnO.getCurrentPos());
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
        this.nnL = intent.getData();
        if (this.nnL == null) {
            finish();
            return;
        }
        com.kascend.chushou.d.e.j();
        if (this.nos == null) {
            this.nos = new CSTVWifiReceiver();
            registerReceiver(this.nos, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        }
        com.kascend.chushou.toolkit.d.a.dOx().b();
        tv.chushou.zues.utils.e.i(this.v, "intent.getData=" + this.nnL.toString());
        String scheme = this.nnL.getScheme();
        if (scheme == null || !scheme.equals("chushou")) {
            tv.chushou.zues.utils.e.e(this.v, "not support scheme :" + scheme);
            finish();
            return;
        }
        a(intent);
    }

    private void a(Intent intent) {
        this.P = this.nnL.getQueryParameter("roomId");
        this.Q = this.P;
        this.S = this.nnL.getQueryParameter(WebSocketRequest.PARAM_KEY_PROTOCOLS);
        this.aq = this.nnL.getQueryParameter("liveType");
        if ("2".equals(this.aq) || "3".equals(this.aq) || "4".equals(this.aq)) {
            this.noo = "2";
            this.nop = new com.kascend.chushou.player.feedback.a();
            if (this.nop.nwE != null) {
                this.nop.nwE.reset();
                this.nop.nwE.roomId = this.P;
                this.nop.nwE.enterType = 1;
                this.nop.b = System.currentTimeMillis();
            }
        }
        if (h.isEmpty(this.P) || h.isEmpty(this.S)) {
            tv.chushou.zues.utils.e.e(this.v, "invalid param mItemID=" + this.P + " protocols=" + this.S);
            finish();
            return;
        }
        if (com.kascend.chushou.b.dMi().d == -1) {
            com.kascend.chushou.b.dMi().d = com.kascend.chushou.d.g.b() ? 1 : 0;
        }
        this.nof = ((PowerManager) getSystemService("power")).newWakeLock(536870938, this.v);
        this.nof.acquire();
        this.nnS = new b(this.P);
        this.nnS.d = intent.getBooleanExtra("room_play_audio", false);
        this.nnX = new com.kascend.chushou.widget.a.b();
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
        this.nnZ = (KPSwitchRootRelativeLayout) findViewById(a.f.rlRoot);
        if (!"2".equals(this.noo) && com.kascend.chushou.b.dMi().d == 1) {
            this.nnZ.setFitsSystemWindows(true);
        }
        this.noa = (FrameLayout) this.nnZ.findViewById(a.f.fl_fragment);
        this.nnW = this.nnZ.findViewById(a.f.rl_empty);
        this.T = (ImageView) this.nnW.findViewById(a.f.iv_empty);
        this.U = (TextView) this.nnW.findViewById(a.f.tv_empty);
        this.nob = (LinearLayout) this.nnZ.findViewById(a.f.rl_title);
        this.Z = (ImageView) this.nob.findViewById(a.f.back_icon);
        this.Z.setOnClickListener(new View.OnClickListener() { // from class: com.kascend.chushou.player.VideoPlayer.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayer.this.finish();
            }
        });
        this.nnV = (AnimationImageView) this.nnW.findViewById(a.f.iv_loading);
        this.nog = (FrescoThumbnailView) this.nnZ.findViewById(a.f.live_cover);
        this.noh = (FrameLayout) this.nnZ.findViewById(a.f.fl_cover);
        this.k = dMw();
        try {
            this.nnY = (AudioManager) getApplicationContext().getSystemService("audio");
            n = this.nnY.getStreamVolume(3);
            this.nnY.requestAudioFocus(null, 3, 1);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (this.B) {
            a(1, dMD() ? "3" : "1");
        } else {
            r();
        }
        if (com.kascend.chushou.b.dMi().b && !com.kascend.chushou.b.dMi().a) {
            RxExecutor.postDelayed(this.noq, EventThread.MAIN_THREAD, 60L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.VideoPlayer.5
                @Override // java.lang.Runnable
                public void run() {
                    if (!VideoPlayer.this.isFinishing() && com.kascend.chushou.b.dMi().b && !com.kascend.chushou.b.dMi().a) {
                        tv.chushou.zues.utils.g.c(VideoPlayer.this.w, VideoPlayer.this.getString(a.i.str_monet_notify));
                    }
                }
            });
        }
        com.kascend.chushou.c.c.dMl().a(this.P, stringExtra, System.currentTimeMillis());
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
        if (this.nor == null) {
            this.nor = new a();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.media.VOLUME_CHANGED_ACTION");
            registerReceiver(this.nor, intentFilter);
        }
    }

    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        j(false);
        if (this.nor != null) {
            unregisterReceiver(this.nor);
            this.nor = null;
        }
        super.onStop();
    }

    @Override // com.kascend.chushou.view.base.BaseActivity
    protected void a(boolean z) {
        if (this.nnQ != null) {
            this.nnQ.k(z);
        }
    }

    @Subscribe
    public void onHideGiftEffectEvent(com.kascend.chushou.b.a.a.f fVar) {
        if (fVar.b) {
            this.nnQ.k();
            return;
        }
        this.nnQ.m();
        this.nnQ.l();
    }

    private float dMw() {
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
            this.nnS.h = jSONObject.toString();
            String optString = jSONObject.optString("_thumb");
            jSONObject.optBoolean("tag_from_game_mic", false);
            if (!h.isEmpty(optString)) {
                this.ab = optString;
            }
        } catch (JSONException e) {
            e.printStackTrace();
            this.nnS.h = str;
        }
        if (dMD()) {
            a(this.P, str);
            aX(this.P, z);
            return;
        }
        a = this.P;
        b(this.P, str);
        a(this.P, dMN(), z);
        w();
    }

    private void O() {
        this.m = true;
        j();
        if (this.nnQ != null) {
            this.nnQ.r();
        }
        s();
    }

    @Subscribe
    public void onStartRoomEvent(o oVar) {
        if (!isFinishing() && oVar.nnt != null && oVar.c != null && !h.isEmpty(oVar.nnt.mTargetKey)) {
            if (oVar.c != this) {
                tv.chushou.zues.utils.e.e(this.v, "different player!");
                return;
            }
            if (this.nnS != null) {
                this.nnS.a();
                this.nnS.a = oVar.nnt.mTargetKey;
                this.nnS.d = oVar.d;
                if (this.nnS.npu != null) {
                    this.nnS.npu.e();
                }
                if (this.nnS.npu != null) {
                    this.nnS.npu.b();
                }
                this.nnS.npy = null;
                this.nnS.npx = null;
                this.nnS.npB = null;
                this.nnS.npA = null;
                this.nnS.npE = null;
                this.nnS.npC = null;
                this.nnS.npD = null;
            }
            if (this.nnY != null) {
                n = this.nnY.getStreamVolume(3);
            }
            if (!h.isEmpty(oVar.nnt.mType) && oVar.nnt.mType.equals("3")) {
                this.B = false;
                this.noo = "1";
                r();
                this.P = oVar.nnt.mTargetKey;
                this.R = "3";
                if (this.nnX != null) {
                    this.nnX.a();
                }
                if (this.nnS != null) {
                    this.nnS.a((PlayUrl) null);
                    this.nnS.f();
                    if (this.nnS.c() != null) {
                        this.nnS.c().clear();
                    }
                    this.nnS.i.clear();
                }
                if (this.nnQ != null) {
                    this.nnQ.j();
                }
                s();
                if (this.noc != null) {
                    this.noc.d();
                    this.noc = null;
                }
                if (this.noq != null) {
                    this.noq.dispose();
                    this.noq = new io.reactivex.disposables.a();
                }
                a(oVar.e, false);
                return;
            }
            boolean z = this.R != null && this.R.equals("1");
            this.R = "1";
            this.nol.a();
            this.nok.a();
            this.noj.a();
            this.noi.c();
            this.non.a();
            if (this.noq != null) {
                this.noq.dispose();
                this.noq = new io.reactivex.disposables.a();
            }
            if ("1".equals(oVar.f)) {
                this.H = false;
                if (this.nnS != null && !h.isEmpty(this.nnS.t)) {
                    this.nnS.t.clear();
                }
                this.ab = oVar.nnt.mCover;
                this.noh.setVisibility(0);
                this.nog.setBlur(true);
                this.nog.i(oVar.nnt.mCover, 0, 0, 0);
            }
            if (!oVar.nnt.mTargetKey.equals(this.P)) {
                this.aq = oVar.g;
                if (!z) {
                    this.B = false;
                    r();
                } else if (!"2".equals(this.noo) && ("2".equals(this.aq) || "3".equals(this.aq) || "4".equals(this.aq))) {
                    this.noo = "2";
                    this.nop = new com.kascend.chushou.player.feedback.a();
                    if (this.nop.nwE != null) {
                        this.nop.nwE.reset();
                        this.nop.nwE.roomId = oVar.nnt.mTargetKey;
                        this.nop.nwE.enterType = 1;
                        this.nop.b = System.currentTimeMillis();
                    }
                }
                this.B = false;
                this.P = oVar.nnt.mTargetKey;
                this.Q = this.P;
                this.ab = oVar.nnt.mCover;
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
                JSONObject P = com.kascend.chushou.d.e.P("_fromView", str, "_sc", oVar.nnt.mSC);
                com.kascend.chushou.toolkit.a.c.a(this.w, P);
                if (this.nnX != null) {
                    this.nnX.a();
                    this.nnX.a(this.P);
                }
                if (this.nnS != null) {
                    this.nnS.a((PlayUrl) null);
                    this.nnS.f();
                    if (this.nnS.c() != null) {
                        this.nnS.c().clear();
                    }
                    this.nnS.i.clear();
                }
                if (this.nnQ != null) {
                    this.nnQ.j();
                }
                a(P.toString(), false);
                return;
            }
            tv.chushou.zues.utils.g.Mc(a.i.str_same_room);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dMx() {
        FullRoomInfo dNb;
        String str;
        RoomInfo roomInfo;
        if (dMD()) {
            str = null;
            dNb = null;
        } else {
            dNb = this.nnS.dNb();
            str = (dNb == null || (roomInfo = dNb.mRoominfo) == null) ? null : roomInfo.mGameId;
        }
        return !this.L && (dNb == null || h.isEmpty(str));
    }

    @Subscribe
    public void onMessageEvent(i iVar) {
        if (!isFinishing() && iVar.a != 21 && iVar.a != 22) {
            if (iVar.a == 0 && (iVar.b instanceof Boolean)) {
                if (((Boolean) iVar.b).booleanValue() && !isFinishing()) {
                    w();
                    if (this.nnQ != null) {
                        this.nnQ.f();
                    }
                }
            } else if (iVar.a == 46) {
                if ((iVar.b instanceof String) && this.nnQ != null) {
                    this.nnQ.c((String) iVar.b);
                }
            } else if (iVar.a == 54) {
                if (iVar.b instanceof String) {
                    this.noj.a((String) iVar.b);
                }
            } else if (iVar.a == 55) {
                if (this.nnQ != null) {
                    this.nnQ.O();
                }
            } else if (iVar.a == 56 && this.nnQ != null) {
                this.nnQ.P();
            }
        }
    }

    @Subscribe
    public void onRefreshSubscribeEvent(m mVar) {
        if (isFinishing() && this.nnS != null && this.nnS.dNe() != null) {
            RoomInfo dNe = this.nnS.dNe();
            if (mVar.a(dNe.mCreatorUID, dNe.mRoomID)) {
                dNe.mIsSubscribed = mVar.c;
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
        if (this.m || this.nnN == null || this.nnO == null) {
            R();
        }
        if (this.nnX != null) {
            this.nnX.d();
        }
        if (!dMD()) {
            if (this.noc != null && !this.noc.c()) {
                this.noc.a();
            }
            v();
            if (this.nnS != null && this.nnS.dNb() != null && this.nnS.dNb().cycleLiveRoomInfo != null && !h.isEmpty(this.nnS.dNb().cycleLiveRoomInfo.roomId)) {
                u();
            }
        }
        super.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.view.base.BaseActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        tv.chushou.zues.utils.e.e(this.v, MissionEvent.MESSAGE_DESTROY);
        if (this.nnS != null && this.nnS.dNb() != null && this.nnS.dNb().cycleLiveRoomInfo != null && !h.isEmpty(this.nnS.dNb().cycleLiveRoomInfo.eventName)) {
            j.dMv().a(this.P + dMN());
        }
        if ("2".equals(this.noo) && this.nop != null && this.nop.nwE != null) {
            this.nop.nwE.time = System.currentTimeMillis() - this.nop.b;
            this.nop.a();
            this.nop.b();
        }
        this.noi.d();
        this.noj.b();
        this.nok.b();
        O();
        this.ag = null;
        a = null;
        if (this.nou != null) {
            this.nou.ch(null);
            this.nou = null;
        }
        if (this.noc != null) {
            this.noc.d();
            this.noc = null;
        }
        if (this.nnX != null) {
            this.nnX.c();
            this.nnX = null;
        }
        if (this.nnS != null) {
            this.nnS.npy = null;
            this.nnS.npx = null;
        }
        if (this.nnS != null) {
            this.nnS.b();
            this.nnS = null;
        }
        this.nnL = null;
        this.nnQ = null;
        this.nnR = null;
        this.nnU = null;
        this.T = null;
        this.U = null;
        this.nnV = null;
        this.nnW = null;
        this.nnY = null;
        this.nnZ = null;
        this.noa = null;
        this.Z = null;
        this.nob = null;
        if (this.nof != null && this.nof.isHeld()) {
            this.nof.release();
            this.nof = null;
        }
        if (this.nos != null) {
            unregisterReceiver(this.nos);
            this.nos = null;
        }
        h.eak();
        tv.chushou.zues.a.a.ci(this);
        this.noq.dispose();
        this.nok.b();
        this.nol.b();
        this.noi.d();
        this.noj.b();
        this.non.b();
        super.onDestroy();
        System.gc();
    }

    @Subscribe
    public void onSendGameGiftEvent(n nVar) {
        if (!isFinishing() && this.nnQ != null) {
            this.nnQ.a(nVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.view.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        tv.chushou.zues.utils.e.d(this.v, MissionEvent.MESSAGE_PAUSE);
        if (this.noc != null) {
            this.noc.b();
        }
        if (this.nnX != null) {
            this.nnX.b(false);
        }
        k();
        this.m = true;
        super.onPause();
    }

    @Override // android.app.Activity
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.nnQ != null ? this.nnQ.a(motionEvent) : super.onTouchEvent(motionEvent);
    }

    public void c() {
        if ("1".equals(this.R)) {
            j.dMv().a(this.P + dMN());
        } else {
            j.dMv().b(this.P);
        }
    }

    private void a(boolean z, boolean z2) {
        int i = 0;
        tv.chushou.zues.utils.e.i(this.v, "startLoadingVideo <------------- mbPrepareingVideo = " + this.K);
        if (this.nnN != null) {
            this.nnN.setHardwearDecod(com.kascend.chushou.d.h.dMp().a);
        }
        if (this.nnO != null) {
            this.nnO.setHardwearDecod(com.kascend.chushou.d.h.dMp().a);
        }
        if (this.nnM != null) {
            this.nnM.setHardwearDecod(com.kascend.chushou.d.h.dMp().a);
        }
        if (!this.K) {
            if (z && this.nnQ != null) {
                if (!z2) {
                    this.t = null;
                    this.nnQ.e();
                }
            } else if (this.nnQ != null && !z2) {
                this.t = null;
                this.nnQ.H = false;
                RxExecutor.post(null, EventThread.MAIN_THREAD, new Runnable() { // from class: com.kascend.chushou.player.VideoPlayer.7
                    @Override // java.lang.Runnable
                    public void run() {
                        VideoPlayer.this.nnQ.x();
                    }
                });
            }
            this.K = true;
            if (this.nnS != null && this.nnS.dNc() != null) {
                PlayUrl dNc = this.nnS.dNc();
                while (true) {
                    int i2 = i;
                    if (i2 >= dNc.mUrlDetails.size()) {
                        break;
                    }
                    UrlDetails urlDetails = dNc.mUrlDetails.get(i2);
                    if (urlDetails.mUrl.equals(dNc.mSelectedUrl)) {
                        String str = dNc.mUrlDetails.get(i2).mDefinitionType;
                        String str2 = urlDetails.mBitrate;
                    }
                    i = i2 + 1;
                }
            }
            if (z2) {
                if (this.d) {
                    this.nnN.setVideoURI(this.nnL);
                    this.nnN.open();
                    return;
                }
                this.nnO.setVideoURI(this.nnL);
                this.nnO.open();
                return;
            }
            this.nnM.setVideoURI(this.nnL);
            this.nnM.open();
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        try {
            if (motionEvent.getAction() == 0) {
                if (this.nnQ != null && this.nnQ.b(motionEvent)) {
                    return true;
                }
                if ("2".equals(this.noo) && this.nnQ != null) {
                    this.nnQ.a(motionEvent);
                }
            } else if (this.nnQ != null && this.nnQ.b(motionEvent)) {
                return true;
            }
            return super.dispatchTouchEvent(motionEvent);
        } catch (Exception e) {
            return false;
        }
    }

    @Override // android.support.v7.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.nnQ != null && this.nnQ.a(i, keyEvent)) {
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
        if (this.nnS != null && this.nnS.dNb() != null && this.nnS.dNb().cycleLiveRoomInfo != null && !h.isEmpty(this.nnS.dNb().cycleLiveRoomInfo.roomId)) {
            this.noh.setVisibility(0);
            this.nog.setBlur(true);
            this.nog.i(this.nnS.dNb().cycleLiveRoomInfo.avatar, 0, 0, 0);
            this.nog.setVisibility(0);
            j.dMv().a(this.P + dMN());
            this.nnL = null;
            R();
            this.Q = this.nnS.dNb().cycleLiveRoomInfo.roomId;
            a(this.P, dMN(), false);
        }
    }

    public void b(boolean z) {
        if (this.nnQ != null) {
            this.nnQ.j(z);
        }
    }

    public void a(boolean z, Uri uri, boolean z2) {
        tv.chushou.zues.utils.e.d(this.v, "loadIfNecessary reload=" + z + " isChangeLines-->" + z2);
        if (this.nnN != null && this.nnO != null) {
            if (uri != null) {
                this.nnL = uri;
            }
            if (z2) {
                this.e = z2;
            }
            this.M = false;
            this.nnT = 0L;
            this.O = 0;
            this.nou.removeMessages(7);
            if (z) {
                if (z2) {
                    if (!this.d) {
                        this.nnO.setOnActivityCallBack(this.noz);
                    } else {
                        this.nnN.setOnActivityCallBack(this.noy);
                    }
                } else if (this.d) {
                    this.nnO.setOnActivityCallBack(this.noz);
                } else {
                    this.nnN.setOnActivityCallBack(this.noy);
                }
                this.K = false;
                b(true, z2);
            } else if (!this.J) {
                b(true, z2);
            }
            this.nou.B(6, 3000L);
        }
    }

    private void b(boolean z, boolean z2) {
        VideoPlayInfo L;
        if ("1".equals(this.R)) {
            L = j.dMv().K(this.P + dMN(), 600000L);
        } else {
            L = j.dMv().L(this.P, 600000L);
        }
        if (L != null) {
            a(z, z2);
        } else if ("1".equals(this.R)) {
            a(this.P, dMN(), false);
        } else {
            aX(this.P, false);
        }
    }

    public tv.chushou.common.player.a dMy() {
        return this.nnM;
    }

    public tv.chushou.common.player.a dMz() {
        return this.nnN;
    }

    public tv.chushou.common.player.a dMA() {
        return this.nnO;
    }

    public void a(tv.chushou.common.player.a aVar) {
        this.nnM = aVar;
    }

    public b dMB() {
        return this.nnS;
    }

    public com.kascend.chushou.widget.a.b dMC() {
        return this.nnX;
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
        FullRoomInfo dNb;
        this.r = -1L;
        if (this.s != -1 && this.s != 0) {
            this.r = this.s;
            this.s = -1L;
        }
        if (dMD() && this.nnM != null && this.nnM.getPlayState() == 4) {
            this.r = this.nnM.getCurrentPos();
        }
        this.nov = false;
        tv.chushou.zues.utils.e.d(this.v, "screenChange()<-----");
        tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard(this);
        if (str != null) {
            this.R = str;
        }
        if (!this.C || !z3 || "3".equals(this.R) || this.nnS == null || (dNb = this.nnS.dNb()) == null || dNb.mRoominfo == null || dNb.mRoominfo.mStyle != 1) {
            z5 = false;
        } else {
            z5 = true;
            i = 0;
        }
        if ("2".equals(this.noo)) {
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
            if (com.kascend.chushou.b.dMi().d == 1) {
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
        if (this.nnX == null) {
            this.nnX = new com.kascend.chushou.widget.a.b();
        }
        if (this.nnX != null) {
            this.nnX.a(this.P);
        }
        if (this.R.equals("5")) {
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            if (this.nnQ != null) {
                beginTransaction.remove(this.nnQ);
                this.nnQ = null;
            }
            if (this.nnR != null) {
                beginTransaction.remove(this.nnR);
                this.nnR = null;
            }
            this.nnR = new com.kascend.chushou.view.user.b();
            beginTransaction.add(a.f.fl_fragment, this.nnR);
            beginTransaction.commitAllowingStateLoss();
        } else {
            FragmentTransaction beginTransaction2 = getSupportFragmentManager().beginTransaction();
            if (this.nnQ != null) {
                beginTransaction2.remove(this.nnQ);
                this.nnQ = null;
            }
            if (this.nnR != null) {
                beginTransaction2.remove(this.nnR);
                this.nnR = null;
            }
            if ("2".equals(this.noo)) {
                this.nnQ = com.kascend.chushou.player.e.e.b(this.ab, z2, this.aq, this.P);
            } else if (1 == i) {
                if (!this.R.equals("3")) {
                    if (z4) {
                        v();
                    }
                    this.nnQ = new com.kascend.chushou.player.d.a();
                    Bundle bundle = new Bundle();
                    bundle.putString("mCover", this.ab);
                    bundle.putBoolean("mInitViewAsync", z2);
                    this.nnQ.setArguments(bundle);
                }
            } else {
                this.nnQ = new com.kascend.chushou.player.d.b();
                Bundle bundle2 = new Bundle();
                if (z5) {
                    i = 1;
                }
                bundle2.putInt("mExtraOrientation", i);
                bundle2.putString("mViewType", this.R);
                this.nnQ.setArguments(bundle2);
            }
            beginTransaction2.add(a.f.fl_fragment, this.nnQ);
            beginTransaction2.commitAllowingStateLoss();
            this.H = true;
        }
        tv.chushou.zues.utils.e.d(this.v, "screenChange()----->");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dMD() {
        return this.R != null && this.R.equals("3");
    }

    private void R() {
        if (this.nnQ != null) {
            this.nnQ.nsS = null;
        }
        if (this.nnM != null) {
            this.nnM.release();
            this.nnM = null;
            this.K = false;
        }
        if (this.nnN != null) {
            this.nnN.release();
            this.nnN = null;
        }
        if (this.nnO != null) {
            this.nnO.release();
            this.nnO = null;
        }
        if (this.nnP != null) {
            this.nnP.c();
        }
        this.d = false;
        this.e = false;
        this.M = false;
        this.nnP = new c();
        this.nnN = this.nnP.dNh();
        this.nnN.setOnActivityCallBack(this.noy);
        this.nnO = this.nnP.dNi();
        this.nnO.setOnActivityCallBack(this.noz);
        if (!this.d) {
            this.nnM = this.nnN;
        } else {
            this.nnM = this.nnO;
        }
        if (this.nnQ != null) {
            this.nnQ.nsS = this.nnM;
        }
    }

    public void j() {
        if (this.nnM != null) {
            this.nnM.pause();
            this.nnM.stop();
            this.nnM.release();
            this.nnM = null;
        }
        if (this.nnN != null) {
            this.nnN.stop();
            this.nnN.release();
            this.nnN = null;
        }
        if (this.nnO != null) {
            this.nnO.stop();
            this.nnO.release();
            this.nnO = null;
        }
        if (this.nnP != null) {
            this.nnP.c();
        }
    }

    public void k() {
        tv.chushou.common.player.a aVar = this.nnM;
        if (aVar != null) {
            aVar.pause();
            aVar.stop();
        }
        tv.chushou.common.player.a aVar2 = this.nnN;
        if (aVar2 != null) {
            aVar2.stop();
        }
        tv.chushou.common.player.a aVar3 = this.nnO;
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
        if (this.nov) {
            if (this.nnQ != null) {
                this.nnQ.s();
            }
        } else if (this.nou != null) {
            this.nou.b(this.nou.LV(3), 20L);
        }
    }

    private void b(final String str, String str2) {
        com.kascend.chushou.c.c.dMl().a(new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.VideoPlayer.8
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
                    VideoPlayer.this.dML().a(fullRoomInfo.mBangMap);
                    if (h.isEmpty(fullRoomInfo.mRoominfo.mRoomID)) {
                        fullRoomInfo.mRoominfo.mRoomID = VideoPlayer.this.P;
                    }
                    if (!h.isEmpty(fullRoomInfo.mGeneralTabGifts)) {
                        com.kascend.chushou.d.e.a(VideoPlayer.this.noq, new ArrayList(fullRoomInfo.mGeneralTabGifts));
                    }
                    if (VideoPlayer.this.nnS != null) {
                        VideoPlayer.this.nnS.a(fullRoomInfo);
                    }
                    VideoPlayer.this.L = false;
                    if (VideoPlayer.this.B) {
                        if (VideoPlayer.this.C && !"3".equals(VideoPlayer.this.R) && fullRoomInfo != null && fullRoomInfo.mRoominfo != null && fullRoomInfo.mRoominfo.mStyle == 1 && !h.isEmpty(fullRoomInfo.mRoominfo.mGameId)) {
                            z = true;
                        }
                        if (!z) {
                            if (VideoPlayer.this.nnQ != null) {
                                VideoPlayer.this.nnQ.a(VideoPlayer.this.nnS);
                            }
                            if (!h.isEmpty(fullRoomInfo.mRoominfo.mGameId)) {
                                VideoPlayer.this.S();
                            } else {
                                if (VideoPlayer.this.nnS != null) {
                                    VideoPlayer.this.nnS.f = null;
                                }
                                VideoPlayer.this.S();
                            }
                        } else {
                            VideoPlayer.this.a(1, "1", true);
                            if (VideoPlayer.this.nnQ != null) {
                                VideoPlayer.this.nnQ.a(VideoPlayer.this.nnS);
                            }
                        }
                    } else {
                        if (h.isEmpty(fullRoomInfo.mRoominfo.mGameId)) {
                            if (VideoPlayer.this.nnS != null) {
                                VideoPlayer.this.nnS.f = null;
                            }
                            VideoPlayer.this.a(1, "1");
                        } else {
                            VideoPlayer.this.a(1, "1", true);
                        }
                        if (VideoPlayer.this.nnQ != null) {
                            VideoPlayer.this.nnQ.a(VideoPlayer.this.nnS);
                        }
                    }
                    if (VideoPlayer.this.nnS != null && !VideoPlayer.this.nnS.m()) {
                        if (VideoPlayer.this.noc != null) {
                            VideoPlayer.this.noc.d();
                            VideoPlayer.this.noc = null;
                        }
                        VideoPlayer.this.noc = new com.kascend.chushou.toolkit.d(900000L, VideoPlayer.this.noe, VideoPlayer.this.nou);
                        VideoPlayer.this.noc.a();
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
        if (this.nnS != null) {
            this.nnS.a((FullRoomInfo) null);
        }
        this.L = false;
        c(str, i);
        if (this.nnM != null) {
            this.nnM.stop();
        }
        if (this.nnN != null) {
            this.nnN.stop();
        }
        if (this.nnO != null) {
            this.nnO.stop();
        }
    }

    public void l() {
        tv.chushou.zues.utils.e.d(this.v, "retryGetPlayList");
        c();
        if (dMD()) {
            aX(this.P, false);
        } else {
            a(this.P, dMN(), false);
        }
    }

    public void m() {
        a(this.ag, false);
    }

    private void a(final String str, String str2, boolean z) {
        this.J = true;
        VideoPlayInfo K = j.dMv().K(str + str2, 600000L);
        if (K != null) {
            a((ArrayList) K.mPlayUrls);
            this.J = false;
        } else if (z) {
            ParserRet fX = com.kascend.chushou.player.c.a.dNj().fX(str, str2);
            if (fX.mRc != 0) {
                tv.chushou.zues.utils.e.e(this.v, "getPlayUrlSync fail, try to getPlaylist");
                a(str, str2, false);
                return;
            }
            a(fX, str);
        } else {
            com.kascend.chushou.player.c.a.dNj().a(str, str2, new a.InterfaceC0829a() { // from class: com.kascend.chushou.player.VideoPlayer.9
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
        VideoPlayInfo L = j.dMv().L(str, 600000L);
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
                ParserRet aY = com.kascend.chushou.player.c.a.dNj().aY(str, equals);
                if (aY.mRc != 0) {
                    tv.chushou.zues.utils.e.e(this.v, "getVideoPlayUrlSync fail, try to getVideoPlaylist");
                    aX(str, false);
                    return;
                }
                a(aY, str);
                return;
            }
            com.kascend.chushou.player.c.a.dNj().a(str, new a.InterfaceC0829a() { // from class: com.kascend.chushou.player.VideoPlayer.10
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
                if (this.nnS.f == null) {
                    this.nnS.f = new ArrayList<>();
                }
                this.nnS.f.clear();
                this.nnS.f.addAll(arrayList);
                if ("1".equals(this.R)) {
                    j.dMv().a(str + dMN(), arrayList);
                } else {
                    j.dMv().t(str, arrayList);
                }
                a(arrayList);
                return;
            }
            if (this.nnS != null) {
                this.nnS.f = null;
            }
            if (this.nou != null) {
                Message LV = this.nou.LV(5);
                LV.arg1 = 2;
                LV.arg2 = parserRet.mRc;
                this.nou.R(LV);
            }
        }
    }

    private void c(String str, int i) {
        s();
        if (this.nnX != null) {
            this.nnX.a();
        }
        if (h.isEmpty(str)) {
            str = getString(a.i.str_load_data_failed);
        }
        a(str, i);
    }

    public void n() {
        if (this.noa != null && this.nnW != null && this.nob != null) {
            this.noa.setVisibility(0);
            this.nnW.setVisibility(8);
            this.nob.setVisibility(8);
        }
    }

    public void o() {
        if (this.nog != null && this.nog.getVisibility() == 0) {
            this.nog.zR(0);
            this.nog.setVisibility(8);
        }
    }

    public void p() {
        if (this.noh != null && this.noh.getVisibility() == 0) {
            this.noh.setVisibility(8);
        }
    }

    public void q() {
        this.nov = true;
    }

    protected void r() {
        this.noa.setVisibility(8);
        this.nob.setVisibility(0);
        this.nnW.setVisibility(0);
        if (this.nnV != null) {
            this.T.setVisibility(8);
            this.nnV.setVisibility(0);
            this.U.setText(getString(a.i.str_dialog_loading_content));
            this.U.setVisibility(8);
        }
    }

    protected void a(String str, int i) {
        this.noa.setVisibility(8);
        this.nob.setVisibility(0);
        this.nnW.setVisibility(0);
        if (this.nnV != null) {
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
                            com.kascend.chushou.c.c.dMl().b(new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.VideoPlayer.11.1
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
                            }, VideoPlayer.this.P, (String) null, VideoPlayer.this.nnS.h);
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
            this.nnV.setVisibility(8);
            this.noh.setVisibility(8);
        }
    }

    public void s() {
        if (this.nou != null) {
            this.nou.removeMessages(1);
        }
    }

    private void a(ArrayList<PlayUrl> arrayList) {
        boolean z;
        if (this.nnS.f == null) {
            this.nnS.f = new ArrayList<>();
        }
        this.nnS.f.clear();
        this.nnS.f.addAll(arrayList);
        if (com.kascend.chushou.d.e.b() && !"4".equals(this.aq)) {
            int c = com.kascend.chushou.d.e.c();
            if (c == -1) {
                b(arrayList);
                return;
            } else if (this.aw) {
                this.aw = false;
                if (c == 0) {
                    this.nnS.d = false;
                    f(arrayList, true);
                    return;
                }
                if (this.nnS != null && this.nnS.f != null) {
                    Iterator<PlayUrl> it = this.nnS.f.iterator();
                    while (it.hasNext()) {
                        if ("2".equals(it.next().mType)) {
                            z = true;
                            break;
                        }
                    }
                }
                z = false;
                this.nnS.d = z;
                f(arrayList, true);
                return;
            } else {
                if (this.nnS.e) {
                    this.nnS.d = !this.nnS.d;
                    this.nnS.e = false;
                    this.nox = true;
                } else if ("4".equals(this.aq)) {
                    this.nnS.d = true;
                }
                f(arrayList, true);
                return;
            }
        }
        if (this.nnS.e) {
            this.nnS.d = !this.nnS.d;
            this.nnS.e = false;
            this.nox = true;
        } else if ("4".equals(this.aq)) {
            this.nnS.d = true;
        }
        f(arrayList, true);
    }

    private void b(ArrayList<PlayUrl> arrayList) {
        if ("1".equals(this.R)) {
            if ("2".equals(this.noo)) {
                d(false, arrayList);
            } else if (this.nnQ != null) {
                this.nnQ.f(arrayList, false);
            }
        } else if (this.nnQ != null) {
            this.nnQ.f(arrayList, false);
        }
    }

    public void c(boolean z) {
        this.nnS.d = false;
        com.kascend.chushou.d.e.a(0);
        ArrayList<PlayUrl> arrayList = this.nnS.f;
        if (!h.isEmpty(arrayList)) {
            if (z) {
                f(arrayList, false);
                if (this.nou != null) {
                    this.nou.LT(2);
                    return;
                }
                return;
            }
            f(arrayList, true);
        }
    }

    public void d(boolean z) {
        this.nnS.d = true;
        com.kascend.chushou.d.e.a(1);
        ArrayList<PlayUrl> arrayList = this.nnS.f;
        if (!h.isEmpty(arrayList)) {
            if (z) {
                f(arrayList, false);
                if (this.nou != null) {
                    this.nou.LT(2);
                    return;
                }
                return;
            }
            f(arrayList, true);
        }
    }

    @Subscribe
    public void onNotifyEvent(com.kascend.chushou.b.a.a.j jVar) {
        if (!isFinishing() && jVar.a == 1 && !"5".equals(this.R) && !dMx()) {
            tv.chushou.zues.utils.e.d(this.v, "onNetworkChangeEvent 3G=" + com.kascend.chushou.b.dMi().b + "  wifi=" + com.kascend.chushou.b.dMi().a);
            if (com.kascend.chushou.d.e.b() && !"4".equals(this.aq)) {
                if (com.kascend.chushou.d.e.c() == -1) {
                    if (this.nnQ != null) {
                        this.nnQ.e(false);
                    }
                    if ("1".equals(this.R)) {
                        if ("2".equals(this.noo)) {
                            d(true, null);
                            return;
                        } else if (this.nnQ != null) {
                            this.nnQ.f(this.nnS.f, true);
                            return;
                        } else {
                            return;
                        }
                    } else if (this.nnQ != null) {
                        this.nnQ.f(this.nnS.f, true);
                        return;
                    } else {
                        return;
                    }
                }
                RxExecutor.postDelayed(this.noq, EventThread.MAIN_THREAD, 10L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.VideoPlayer.12
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!VideoPlayer.this.isFinishing() && com.kascend.chushou.b.dMi().b && !com.kascend.chushou.b.dMi().a) {
                            tv.chushou.zues.utils.g.c(VideoPlayer.this.w, VideoPlayer.this.getString(a.i.str_monet_notify));
                        }
                    }
                });
            } else if (com.kascend.chushou.b.dMi().a || com.kascend.chushou.b.dMi().b) {
                t();
                if (this.nou != null) {
                    this.nou.LT(2);
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
            if (this.nnS.d) {
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
            String d = com.kascend.chushou.d.h.dMp().d();
            String str3 = h.isEmpty(d) ? "2" : d;
            if (this.nnS.d) {
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
                if (this.nnS != null) {
                    this.nnS.a(playUrl2);
                    if (this.nou != null) {
                        Message LV = this.nou.LV(5);
                        LV.arg1 = 1;
                        this.nou.R(LV);
                    }
                }
                String b = com.kascend.chushou.player.c.a.b(playUrl2);
                if (!h.isEmpty(b)) {
                    this.nnL = Uri.parse(b);
                    if (this.nox) {
                        this.nox = false;
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (z && this.nnM != null) {
                        a(false, z2);
                    }
                }
            }
        }
    }

    public void d(final boolean z, ArrayList<PlayUrl> arrayList) {
        if (this.nod == null || this.nod.a <= 0) {
            this.nod = com.kascend.chushou.view.b.a.a.dOy();
            this.nod.a(new a.InterfaceC0848a() { // from class: com.kascend.chushou.player.VideoPlayer.13
                @Override // com.kascend.chushou.view.b.a.a.InterfaceC0848a
                public void a(int i) {
                    if (i == a.f.tv_play_video) {
                        VideoPlayer.this.nod.dismissAllowingStateLoss();
                        VideoPlayer.this.c(z);
                    } else if (i == a.f.tv_play_audio) {
                        VideoPlayer.this.nod.dismissAllowingStateLoss();
                        VideoPlayer.this.d(z);
                    } else if (i == a.f.iv_close) {
                        VideoPlayer.this.finish();
                    } else {
                        if (i == a.f.tv_union_proxy) {
                        }
                    }
                }
            });
            this.nod.show(getSupportFragmentManager(), "showRoom");
        }
    }

    public void t() {
        if (this.nod != null) {
            this.nod.dismissAllowingStateLoss();
        }
        if (this.nnQ != null) {
            this.nnQ.v();
        }
    }

    public void u() {
        com.kascend.chushou.c.c.dMl().c(this.P, new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.VideoPlayer.16
            @Override // com.kascend.chushou.c.b
            public void a() {
            }

            @Override // com.kascend.chushou.c.b
            public void a(String str, JSONObject jSONObject) {
                if (!VideoPlayer.this.isFinishing()) {
                    ParserRet eb = com.kascend.chushou.c.e.eb(jSONObject);
                    if (eb.mRc == 0 && eb.mData != null) {
                        CycleLiveRoomInfo cycleLiveRoomInfo = (CycleLiveRoomInfo) eb.mData;
                        if (VideoPlayer.this.nnS != null && cycleLiveRoomInfo != null && !h.isEmpty(cycleLiveRoomInfo.roomId)) {
                            FullRoomInfo dNb = VideoPlayer.this.nnS.dNb();
                            if (dNb.cycleLiveRoomInfo == null) {
                                dNb.cycleLiveRoomInfo = cycleLiveRoomInfo;
                                VideoPlayer.this.d();
                            } else if (dNb.cycleLiveRoomInfo != null && !cycleLiveRoomInfo.roomId.equals(dNb.cycleLiveRoomInfo.roomId)) {
                                dNb.cycleLiveRoomInfo.copyCycleLiveRoomInfo(cycleLiveRoomInfo);
                                VideoPlayer.this.d();
                            } else {
                                dNb.cycleLiveRoomInfo.copyCycleLiveRoomInfo(cycleLiveRoomInfo);
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
        if (this.nnQ != null) {
            this.nnQ.N();
        }
    }

    public void v() {
        com.kascend.chushou.c.c.dMl().a(this.P, new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.VideoPlayer.17
            @Override // com.kascend.chushou.c.b
            public void a() {
            }

            @Override // com.kascend.chushou.c.b
            public void a(String str, JSONObject jSONObject) {
                if (!VideoPlayer.this.isFinishing()) {
                    ParserRet ec = com.kascend.chushou.c.e.ec(jSONObject);
                    if (ec.mRc == 0 && ec.mData != null) {
                        PkNotifyInfo pkNotifyInfo = (PkNotifyInfo) ec.mData;
                        VideoPlayer.this.nom.b = VideoPlayer.this.P;
                        if (pkNotifyInfo != null) {
                            VideoPlayer.this.nom.nsT = pkNotifyInfo;
                            if (VideoPlayer.this.nnQ != null) {
                                VideoPlayer.this.nnQ.a(pkNotifyInfo, VideoPlayer.this.P);
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
        if (this.nnU != null) {
            this.nnU.release();
            this.nnU = null;
        }
        com.kascend.chushou.c.c.dMl().a(this.P, new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.VideoPlayer.18
            @Override // com.kascend.chushou.c.b
            public void a() {
            }

            @Override // com.kascend.chushou.c.b
            public void a(String str, JSONObject jSONObject) {
                if (!VideoPlayer.this.isFinishing()) {
                    ParserRet ed = com.kascend.chushou.c.e.ed(jSONObject);
                    if (ed.mRc == 0 && ed.mData != null) {
                        RoomExpandInfo roomExpandInfo = (RoomExpandInfo) ed.mData;
                        if (VideoPlayer.this.nnS != null) {
                            VideoPlayer.this.nnS.npz = roomExpandInfo.mTopWebAdItem;
                            if (VideoPlayer.this.nnS.s == null) {
                                VideoPlayer.this.nnS.s = new ArrayList();
                            }
                            VideoPlayer.this.nnS.s.clear();
                            VideoPlayer.this.nnS.s.addAll(roomExpandInfo.mGiftTopRightIcons);
                            tv.chushou.zues.a.a.post(new i(50, VideoPlayer.this.nnS.npz));
                        }
                        if (VideoPlayer.this.nnS != null) {
                            VideoPlayer.this.nnS.fE(roomExpandInfo.mExpandNavList);
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
                            VideoPlayer.this.noi.a(list);
                        }
                        List<com.kascend.chushou.player.ui.h5.c.c> list2 = roomExpandInfo.mLuckList;
                        if (!h.isEmpty(list2)) {
                            VideoPlayer.this.noj.a(list2);
                        }
                        com.kascend.chushou.player.ui.h5.c.c cVar = roomExpandInfo.mVoteItem;
                        if (cVar != null) {
                            VideoPlayer.this.nok.a(cVar);
                        }
                        List<com.kascend.chushou.player.ui.h5.c.b> list3 = roomExpandInfo.mInteractH5Item;
                        if (!h.isEmpty(list3)) {
                            VideoPlayer.this.non.a(list3);
                        }
                        List<com.kascend.chushou.player.ui.h5.c.b> list4 = roomExpandInfo.mInteractNavItem;
                        if (!h.isEmpty(list4)) {
                            VideoPlayer.this.non.a(list4);
                        }
                        VideoPlayer.this.nnU = (PrivilegeInfo) ed.mData1;
                        if (VideoPlayer.this.nnU != null) {
                            tv.chushou.zues.a.a.post(new l());
                        }
                        if (VideoPlayer.this.nnS != null) {
                            VideoPlayer.this.nnS.npF = roomExpandInfo.mIconConfig;
                            VideoPlayer.this.dML().a(roomExpandInfo.mIconConfig.bangConfig);
                        }
                        List<SkinConfig> list5 = roomExpandInfo.skinConfig;
                        if (list5 != null && VideoPlayer.this.nnS != null) {
                            VideoPlayer.this.nnS.npI.clear();
                            int i = 0;
                            while (true) {
                                int i2 = i;
                                if (i2 >= list5.size()) {
                                    break;
                                }
                                SkinConfig skinConfig = list5.get(i2);
                                VideoPlayer.this.nnS.npI.put(skinConfig.position, skinConfig.resource);
                                i = i2 + 1;
                            }
                            VideoPlayer.this.C();
                        }
                        VideoPlayer.this.a(roomExpandInfo.mIconConfig, VideoPlayer.this.nnS != null ? VideoPlayer.this.nnS.npI : null);
                        if (roomExpandInfo.mColorMap != null && roomExpandInfo.mColorMap.size() > 0 && com.kascend.chushou.b.dMi().c != null && com.kascend.chushou.b.dMi().c.size() <= 0) {
                            com.kascend.chushou.b.dMi().c.putAll(roomExpandInfo.mColorMap);
                            tv.chushou.zues.a.a.post(new i(52, null));
                        }
                        AutoBang autoBang = roomExpandInfo.mAutoBang;
                        if (autoBang != null && autoBang.currentTime != 0 && autoBang.bangTime != 0) {
                            VideoPlayer.this.dML().a(autoBang);
                        }
                        if (!h.isEmpty(roomExpandInfo.mRelatedRoomList) && VideoPlayer.this.nnS != null) {
                            VideoPlayer.this.nnS.t = roomExpandInfo.mRelatedRoomList;
                            if (VideoPlayer.this.nnQ != null && VideoPlayer.this.H) {
                                VideoPlayer.this.nnQ.w();
                            }
                        }
                        if (roomExpandInfo.mRoomNewUserInfo != null && roomExpandInfo.mRoomNewUserInfo.mBarrierNoviceGuide && !com.kascend.chushou.d.h.dMp().k() && VideoPlayer.this.nnQ != null) {
                            VideoPlayer.this.nnQ.J();
                        }
                        if (roomExpandInfo.mRoomNewUserInfo != null && roomExpandInfo.mRoomNewUserInfo.mRewardNoviceGuide && !com.kascend.chushou.d.h.dMp().l() && VideoPlayer.this.nnQ != null) {
                            VideoPlayer.this.nnQ.K();
                        }
                        if (!h.isEmpty(roomExpandInfo.mShopWindowInfos)) {
                            if (VideoPlayer.this.nnS != null) {
                                if (VideoPlayer.this.nnS.npG == null) {
                                    VideoPlayer.this.nnS.npG = new ArrayList();
                                }
                                VideoPlayer.this.nnS.npG.addAll(roomExpandInfo.mShopWindowInfos);
                            }
                            if (VideoPlayer.this.nnQ != null) {
                                VideoPlayer.this.nnQ.L();
                            }
                        }
                        VideoPlayer.this.nom.b = VideoPlayer.this.P;
                        if (roomExpandInfo.mPkNotifyInfo != null) {
                            VideoPlayer.this.nom.nsT = roomExpandInfo.mPkNotifyInfo;
                            if (VideoPlayer.this.nnQ != null) {
                                VideoPlayer.this.nnQ.a(roomExpandInfo.mPkNotifyInfo, VideoPlayer.this.P);
                            }
                        } else {
                            VideoPlayer.this.nom.nsT = null;
                        }
                        if (roomExpandInfo.mTrumpetPocket != null && VideoPlayer.this.nnS != null) {
                            VideoPlayer.this.nnS.npH = roomExpandInfo.mTrumpetPocket;
                            if (VideoPlayer.this.nnQ != null) {
                                VideoPlayer.this.nnQ.M();
                            }
                        }
                        if (!h.isEmpty(roomExpandInfo.hotwordContentList)) {
                            if (VideoPlayer.this.nnS != null) {
                                if (VideoPlayer.this.nnS.w == null) {
                                    VideoPlayer.this.nnS.w = new ArrayList();
                                }
                                VideoPlayer.this.nnS.w.clear();
                                VideoPlayer.this.nnS.w.addAll(roomExpandInfo.hotwordContentList);
                            }
                            if (VideoPlayer.this.nnQ != null) {
                                VideoPlayer.this.nnQ.b(roomExpandInfo.hotwordContentList);
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
        }, this.ag, this.noo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U() {
        if (!h.isEmpty(com.kascend.chushou.a.a.dMj().nnl)) {
            StringBuilder sb = new StringBuilder();
            if (com.kascend.chushou.a.a.dMj().nnl.contains(com.kascend.chushou.a.a.f)) {
                if (sb.length() > 0) {
                    sb.append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                sb.append(com.kascend.chushou.a.a.f);
            }
            if (com.kascend.chushou.a.a.dMj().nnl.contains(com.kascend.chushou.a.a.g)) {
                if (sb.length() > 0) {
                    sb.append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                sb.append(com.kascend.chushou.a.a.g);
            }
            if (com.kascend.chushou.a.a.dMj().nnl.contains(com.kascend.chushou.a.a.i)) {
                if (sb.length() > 0) {
                    sb.append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                sb.append(com.kascend.chushou.a.a.i);
            }
            if (com.kascend.chushou.a.a.dMj().nnl.contains(com.kascend.chushou.a.a.h)) {
                if (sb.length() > 0) {
                    sb.append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                sb.append(com.kascend.chushou.a.a.h);
            }
            if (com.kascend.chushou.a.a.dMj().nnl.contains(com.kascend.chushou.a.a.j)) {
                if (sb.length() > 0) {
                    sb.append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                sb.append(com.kascend.chushou.a.a.j);
            }
            if (com.kascend.chushou.a.a.dMj().nnl.contains(com.kascend.chushou.a.a.l)) {
                if (sb.length() > 0) {
                    sb.append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                sb.append(com.kascend.chushou.a.a.l);
            }
            if (com.kascend.chushou.a.a.dMj().nnl.contains(com.kascend.chushou.a.a.m)) {
                if (sb.length() > 0) {
                    sb.append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                sb.append(com.kascend.chushou.a.a.m);
            }
            if (sb.length() != 0) {
                com.kascend.chushou.a.a.dMj().a(sb.toString(), this.P, new a.c() { // from class: com.kascend.chushou.player.VideoPlayer.19
                    @Override // com.kascend.chushou.a.a.c
                    public void a(List<ListItem> list) {
                        if (VideoPlayer.this.nnS != null && list != null) {
                            int i = 0;
                            while (true) {
                                int i2 = i;
                                if (i2 >= list.size()) {
                                    break;
                                }
                                if (list.get(i2).mAdExtraInfo != null) {
                                    if (com.kascend.chushou.a.a.f.equals(list.get(i2).mAdExtraInfo.mCode)) {
                                        VideoPlayer.this.nnS.npy = list.get(i2);
                                    } else if (com.kascend.chushou.a.a.g.equals(list.get(i2).mAdExtraInfo.mCode)) {
                                        VideoPlayer.this.nnS.npx = list.get(i2);
                                    } else if (com.kascend.chushou.a.a.i.equals(list.get(i2).mAdExtraInfo.mCode)) {
                                        VideoPlayer.this.nnS.npA = list.get(i2);
                                    } else if (com.kascend.chushou.a.a.h.equals(list.get(i2).mAdExtraInfo.mCode)) {
                                        VideoPlayer.this.nnS.npB = list.get(i2);
                                    } else if (com.kascend.chushou.a.a.j.equals(list.get(i2).mAdExtraInfo.mCode)) {
                                        VideoPlayer.this.nnS.npE = list.get(i2);
                                    } else if (com.kascend.chushou.a.a.l.equals(list.get(i2).mAdExtraInfo.mCode)) {
                                        VideoPlayer.this.nnS.npC = list.get(i2);
                                    } else if (com.kascend.chushou.a.a.m.equals(list.get(i2).mAdExtraInfo.mCode)) {
                                        VideoPlayer.this.nnS.npD = list.get(i2);
                                    }
                                }
                                i = i2 + 1;
                            }
                            if (VideoPlayer.this.nnQ != null) {
                                VideoPlayer.this.nnQ.H();
                            }
                        }
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str, String str2) {
        if (dMD()) {
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
                this.nnZ.setSystemUiVisibility(i);
                return;
            }
            this.nnZ.setSystemUiVisibility(1792);
        }
    }

    public void f(boolean z) {
        Window window;
        View decorView;
        if (com.kascend.chushou.b.dMi().d != 1 && (window = getWindow()) != null && (decorView = window.getDecorView()) != null) {
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
        if (this.nnQ != null) {
            this.nnQ.a(i, i2, intent);
        }
    }

    public Uri dME() {
        return this.nnL;
    }

    @Override // com.kascend.chushou.view.base.BaseActivity
    protected int y() {
        return 0;
    }

    public void xB(boolean z) {
        if (this.nnZ != null) {
            this.nnZ.own = z;
        }
    }

    public void dMF() {
        if (this.nnZ != null) {
            this.nnZ.dMF();
        }
    }

    public boolean dMG() {
        return this.ae;
    }

    public void g(boolean z) {
        this.ae = z;
    }

    public void h(boolean z) {
        if (this.nnZ != null) {
            this.nnZ.setIsTranslucentStatus(z);
        }
    }

    public void z() {
        if (this.nnZ != null) {
            this.nnZ.eaF();
        }
    }

    @Override // com.kascend.chushou.widget.gifts.RoomSendGiftView.a
    public void A() {
        if (this.nnX != null) {
            this.nnX.b();
        }
        if (this.nnS != null) {
            this.nnS.z = true;
        }
    }

    @Override // com.kascend.chushou.widget.gifts.RoomSendGiftView.a
    public void B() {
        if (this.nnX != null) {
            this.nnX.b();
        }
    }

    public void a(List<ListItem> list) {
        if (this.nnQ != null) {
            this.nnQ.a(list);
        }
    }

    public void a(IconConfig iconConfig, Map<String, SkinConfig.SkinRes> map) {
        if (this.nnQ != null) {
            this.nnQ.a(iconConfig, map);
        }
    }

    public void C() {
        if (this.nnQ != null) {
            this.nnQ.I();
        }
    }

    @Override // com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC0840a
    public void a(int i) {
        if (this.nnQ != null) {
            this.nnQ.a(i);
        }
    }

    @Override // com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC0840a
    public void D() {
        if (!isFinishing() && this.nnQ != null) {
            this.nnQ.D();
        }
    }

    @Override // com.kascend.chushou.player.ui.h5.b.b.a
    public void a(long j) {
        if (!isFinishing() && this.nnQ != null) {
            this.nnQ.a(j);
        }
    }

    @Override // com.kascend.chushou.player.ui.h5.b.b.a
    public void a(com.kascend.chushou.player.ui.h5.c.a aVar) {
        if (aVar != null && this.nnQ != null) {
            this.nnQ.a(aVar);
        }
    }

    @Override // com.kascend.chushou.player.ui.h5.b.b.a
    public void b(int i) {
        if (this.nnQ != null) {
            this.nnQ.b(i);
        }
    }

    @Override // com.kascend.chushou.player.ui.h5.d.a.InterfaceC0839a
    public void b(long j) {
        if (!isFinishing() && this.nnQ != null) {
            this.nnQ.b(j);
        }
    }

    @Override // com.kascend.chushou.player.ui.h5.a.a.InterfaceC0837a
    public void c(int i) {
        if (!isFinishing() && this.nnQ != null) {
            this.nnQ.c(i);
        }
    }

    @Override // com.kascend.chushou.player.ui.h5.d.a.InterfaceC0839a
    public void b(com.kascend.chushou.player.ui.h5.c.a aVar) {
        if (aVar != null && this.nnQ != null) {
            this.nnQ.b(aVar);
        }
    }

    @Override // com.kascend.chushou.player.ui.a.a.InterfaceC0834a
    public void a(IconConfig.Config config) {
        if (this.nnQ != null) {
            this.nnQ.a(config);
        }
    }

    @Override // com.kascend.chushou.player.ui.a.a.InterfaceC0834a
    public void a(BangInfo bangInfo, String str) {
        if (this.nnQ != null) {
            this.nnQ.a(bangInfo, str);
        }
    }

    @Override // com.kascend.chushou.player.ui.a.a.InterfaceC0834a
    public void a(long j, BangInfo bangInfo, String str) {
        if (this.nnQ != null) {
            this.nnQ.a(j, bangInfo, str);
        }
    }

    public com.kascend.chushou.player.ui.h5.redpacket.a dMH() {
        return this.noi;
    }

    public com.kascend.chushou.player.ui.h5.b.b dMI() {
        return this.noj;
    }

    public com.kascend.chushou.player.ui.h5.d.a dMJ() {
        return this.nok;
    }

    public com.kascend.chushou.player.ui.h5.a.a dMK() {
        return this.non;
    }

    public com.kascend.chushou.player.ui.a.a dML() {
        return this.nol;
    }

    public com.kascend.chushou.player.e.a dMM() {
        return this.nom;
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
        RxExecutor.postDelayed(this.noq, EventThread.MAIN_THREAD, aVar.d, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.VideoPlayer.2
            @Override // java.lang.Runnable
            public void run() {
                if (VideoPlayer.this.nnQ != null) {
                    VideoPlayer.this.nnQ.c(aVar);
                }
            }
        });
    }

    private void e(final com.kascend.chushou.player.ui.h5.c.a aVar) {
        if (!com.kascend.chushou.d.h.dMp().dMs().contains(aVar.b)) {
            if (aVar.d < 0) {
                aVar.d = 0;
            }
            RxExecutor.postDelayed(this.noq, EventThread.MAIN_THREAD, aVar.d, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.VideoPlayer.3
                @Override // java.lang.Runnable
                public void run() {
                    if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.nnQ != null) {
                        VideoPlayer.this.nnQ.c(aVar);
                    }
                }
            });
        }
    }

    private String dMN() {
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
                if (VideoPlayer.this.nnY != null && !VideoPlayer.this.isFinishing()) {
                    VideoPlayer.n = VideoPlayer.this.nnY.getStreamVolume(3);
                }
                if (!VideoPlayer.this.isFinishing() && (VideoPlayer.this.nnQ instanceof f)) {
                    ((f) VideoPlayer.this.nnQ).ab();
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

    public boolean dMO() {
        if (this.nnQ instanceof com.kascend.chushou.player.d.a) {
            return ((com.kascend.chushou.player.d.a) this.nnQ).dNN();
        }
        if (this.nnQ instanceof com.kascend.chushou.player.e.e) {
            return true;
        }
        return false;
    }
}

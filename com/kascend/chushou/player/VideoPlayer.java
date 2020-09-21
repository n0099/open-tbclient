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
import com.baidu.android.imsdk.internal.IMConnection;
import com.baidu.live.tbadk.core.util.TbEnum;
import com.baidu.searchbox.player.event.VideoReceiver;
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
public class VideoPlayer extends BaseActivity implements a.InterfaceC0889a, a.InterfaceC0892a, b.a, a.InterfaceC0894a, a.InterfaceC0895a, RoomSendGiftView.a {
    private static int A = 60000;
    public static String a = null;
    public static int n = 0;
    private String P;
    private String Q;
    private String R;
    private String S;
    private String ab;
    private String ag;
    private c nRT;
    b nRW;
    public PrivilegeInfo nRX;
    com.kascend.chushou.widget.a.b nRZ;
    private KPSwitchRootRelativeLayout nSb;
    private FrameLayout nSc;
    private ImageView nSd;
    private LinearLayout nSe;
    private com.kascend.chushou.toolkit.d nSf;
    com.kascend.chushou.view.b.a.a nSg;
    private FrescoThumbnailView nSj;
    private FrameLayout nSk;
    public com.kascend.chushou.player.feedback.a nSs;
    private a nSu;
    private CSTVWifiReceiver nSv;
    private boolean B = true;
    private boolean C = false;
    private Uri nRP = null;
    private tv.chushou.common.player.a nRQ = null;
    public tv.chushou.common.player.a nRR = null;
    public tv.chushou.common.player.a nRS = null;
    public boolean d = false;
    public boolean e = false;
    private e nRU = null;
    private boolean H = false;
    private com.kascend.chushou.view.user.b nRV = null;
    private boolean J = false;
    private boolean K = false;
    private boolean L = false;
    private boolean M = false;
    private long N = 0;
    private int O = 0;
    public boolean g = false;
    private ImageView T = null;
    private TextView U = null;
    private AnimationImageView nRY = null;
    private View bLf = null;
    public boolean j = false;
    public float k = 0.0f;
    public float l = 0.0f;
    public boolean m = false;
    public AudioManager nSa = null;
    private d.a nSh = new d.a() { // from class: com.kascend.chushou.player.VideoPlayer.1
        @Override // com.kascend.chushou.toolkit.d.a
        public void a() {
            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.nSw != null) {
                VideoPlayer.this.nSw.Pb(4);
            }
        }
    };
    private boolean ae = false;
    public boolean q = true;
    public long r = -1;
    public long s = -1;
    private PowerManager.WakeLock nSi = null;
    public String t = null;
    private final com.kascend.chushou.player.ui.h5.redpacket.a nSl = new com.kascend.chushou.player.ui.h5.redpacket.a(this);
    private final com.kascend.chushou.player.ui.h5.b.b nSm = new com.kascend.chushou.player.ui.h5.b.b(this);
    private final com.kascend.chushou.player.ui.h5.d.a nSn = new com.kascend.chushou.player.ui.h5.d.a(this);
    private final com.kascend.chushou.player.ui.a.a nSo = new com.kascend.chushou.player.ui.a.a(this);
    private final com.kascend.chushou.player.e.a nSp = new com.kascend.chushou.player.e.a();
    private final com.kascend.chushou.player.ui.h5.a.a nSq = new com.kascend.chushou.player.ui.h5.a.a(this);
    private String nSr = "1";
    private String aq = "2";
    private io.reactivex.disposables.a nSt = new io.reactivex.disposables.a();
    private tv.chushou.zues.c nSw = new tv.chushou.zues.c(new Handler.Callback() { // from class: com.kascend.chushou.player.VideoPlayer.6
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            try {
                if (!VideoPlayer.this.isFinishing()) {
                    switch (message.what) {
                        case 1:
                            VideoPlayer.this.nSw.removeMessages(1);
                            com.kascend.chushou.c.c.ect().a(VideoPlayer.this.P, VideoPlayer.this.nRW != null ? VideoPlayer.this.nRW.h : null, System.currentTimeMillis());
                            VideoPlayer.this.nSw.C(1, VideoPlayer.A);
                            break;
                        case 2:
                            VideoPlayer.this.a(true, (Uri) null, false);
                            break;
                        case 3:
                            VideoPlayer.this.S();
                            break;
                        case 4:
                            if (VideoPlayer.this.nRU != null) {
                                VideoPlayer.this.nRU.a(true);
                            }
                            if (VideoPlayer.this.nSf != null) {
                                VideoPlayer.this.nSf.d();
                                VideoPlayer.this.nSf = null;
                                break;
                            }
                            break;
                        case 5:
                            int i = message.arg1;
                            if (i == 1) {
                                if (VideoPlayer.this.nRU != null) {
                                    VideoPlayer.this.nRU.p();
                                    break;
                                }
                            } else if (i == 2 && VideoPlayer.this.nRU != null) {
                                VideoPlayer.this.nRU.e(message.arg2);
                                break;
                            }
                            break;
                        case 6:
                            if (!com.kascend.chushou.b.ecq().a && !com.kascend.chushou.b.ecq().b && VideoPlayer.this.nRU != null) {
                                VideoPlayer.this.nRU.g(true);
                                break;
                            } else {
                                VideoPlayer.this.c();
                                break;
                            }
                            break;
                        case 7:
                            tv.chushou.zues.utils.e.d(VideoPlayer.this.v, "MSG_BUFFER_DEALY: ");
                            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.nRU != null && VideoPlayer.this.M && !VideoPlayer.this.e) {
                                VideoPlayer.this.nRU.h(true);
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
    private boolean nSx = false;
    private boolean aw = true;
    private boolean nSy = false;
    private tv.chushou.common.player.b nSz = new tv.chushou.common.player.b() { // from class: com.kascend.chushou.player.VideoPlayer.14
        @Override // tv.chushou.common.player.b
        public void ecZ() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerACallback onSetVideoViewLayout");
            if (!VideoPlayer.this.isFinishing()) {
                if ((VideoPlayer.this.nRU == null || !VideoPlayer.this.nRU.H) && VideoPlayer.this.nRU != null && !VideoPlayer.this.d) {
                    VideoPlayer.this.nRU.y();
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void NG(int i) {
            if (!VideoPlayer.this.isFinishing()) {
                if ((VideoPlayer.this.nRU == null || !VideoPlayer.this.nRU.H) && VideoPlayer.this.nRU != null && !VideoPlayer.this.d) {
                    VideoPlayer.this.nRU.g(i);
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void eda() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerACallback onCompletePlayback");
            if (!VideoPlayer.this.isFinishing()) {
                if (!h.isEmpty(VideoPlayer.this.P)) {
                    j.ecE().a(VideoPlayer.this.P, 0);
                }
                VideoPlayer.this.K = false;
                if (VideoPlayer.this.nSw != null) {
                    VideoPlayer.this.nSw.removeMessages(1);
                }
                if ((VideoPlayer.this.nRU == null || !VideoPlayer.this.nRU.H) && VideoPlayer.this.nRU != null && !VideoPlayer.this.d) {
                    VideoPlayer.this.nSw.removeMessages(7);
                    VideoPlayer.this.M = false;
                    VideoPlayer.this.nRU.z();
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void edb() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerACallback onVideoRenderingStart");
            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.nRU != null) {
                VideoPlayer.this.nRU.G();
            }
        }

        @Override // tv.chushou.common.player.b
        public void edc() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerACallback onPreparedPlayback");
            if (!VideoPlayer.this.isFinishing()) {
                if (VideoPlayer.this.nRU == null || !VideoPlayer.this.nRU.H) {
                    VideoPlayer.this.nSw.removeMessages(6);
                    VideoPlayer.this.N = 0L;
                    VideoPlayer.this.O = 0;
                    if (VideoPlayer.this.nRQ != null && VideoPlayer.this.nRU != null) {
                        VideoPlayer.this.nRQ.setVolume(VideoPlayer.this.nRU.J, VideoPlayer.this.nRU.J);
                    }
                    if (VideoPlayer.this.nRW != null) {
                        VideoPlayer.this.K = false;
                        FullRoomInfo edj = VideoPlayer.this.ecM() ? null : VideoPlayer.this.nRW.edj();
                        if (VideoPlayer.this.L || edj != null) {
                            if (VideoPlayer.this.nRW.e) {
                                VideoPlayer.this.nRW.e = false;
                                VideoPlayer.this.nRW.d = !VideoPlayer.this.nRW.d;
                            }
                            if (VideoPlayer.this.nRU != null) {
                                VideoPlayer.this.c("1", (String) null);
                                if (!VideoPlayer.this.d) {
                                    VideoPlayer.this.nRU.i(true);
                                } else if (VideoPlayer.this.e) {
                                    VideoPlayer.this.e = false;
                                    VideoPlayer.this.nRU.B();
                                }
                            }
                        }
                    }
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void NH(int i) {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerACallback onErrorAppeared");
            if (!VideoPlayer.this.isFinishing()) {
                VideoPlayer.this.c();
                VideoPlayer.this.K = false;
                if (VideoPlayer.this.nSw != null) {
                    VideoPlayer.this.nSw.removeMessages(7);
                }
                if (VideoPlayer.this.nSw != null) {
                    VideoPlayer.this.nSw.removeMessages(1);
                }
                if ((VideoPlayer.this.nRU == null || !VideoPlayer.this.nRU.H) && !VideoPlayer.this.ecG()) {
                    if (!"10004".equals(VideoPlayer.this.t)) {
                        if (VideoPlayer.this.nRU != null) {
                            if (VideoPlayer.this.d) {
                                VideoPlayer.this.nRR.stop();
                                VideoPlayer.this.nRR.release();
                                VideoPlayer.this.e = false;
                                VideoPlayer.this.nRU.C();
                            }
                            if (!com.kascend.chushou.b.ecq().a && !com.kascend.chushou.b.ecq().b) {
                                VideoPlayer.this.nRU.g(true);
                            } else if (VideoPlayer.this.d) {
                                VideoPlayer.this.nRU.a(i, true);
                            } else {
                                VideoPlayer.this.nRU.a(i, false);
                            }
                            VideoPlayer.this.c("2", (String) null);
                            return;
                        }
                        return;
                    }
                    eda();
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void edd() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerACallback onBufferingStart");
            if (!VideoPlayer.this.isFinishing()) {
                if ((VideoPlayer.this.nRU == null || !VideoPlayer.this.nRU.H) && VideoPlayer.this.nRU != null && !VideoPlayer.this.d) {
                    VideoPlayer.this.nRU.E();
                    VideoPlayer.this.M = true;
                    long currentTimeMillis = System.currentTimeMillis();
                    VideoPlayer.this.nSw.removeMessages(7);
                    if (!VideoPlayer.this.g) {
                        VideoPlayer.y(VideoPlayer.this);
                    }
                    tv.chushou.zues.utils.e.d(VideoPlayer.this.v, "currentTime: -- >" + currentTimeMillis + "  bufferTime-->" + VideoPlayer.this.N + "  bufferCount-->" + VideoPlayer.this.O);
                    if (currentTimeMillis - VideoPlayer.this.N >= 20000 || VideoPlayer.this.O < 2 || VideoPlayer.this.nRU.H) {
                        if (VideoPlayer.this.O == 1) {
                            VideoPlayer.this.N = currentTimeMillis;
                        }
                        VideoPlayer.this.nSw.C(7, 5000L);
                    } else {
                        VideoPlayer.this.nSw.Pb(7);
                    }
                    if (VideoPlayer.this.g) {
                        VideoPlayer.this.g = false;
                    }
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void ede() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerACallback onBufferingEnd");
            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.nRU != null && !VideoPlayer.this.d) {
                VideoPlayer.this.nSw.removeMessages(7);
                VideoPlayer.this.M = false;
                if (VideoPlayer.this.nRU == null || !VideoPlayer.this.nRU.H) {
                    if (VideoPlayer.this.nRQ == null) {
                        VideoPlayer.this.nRU.a(false, true, false);
                    } else {
                        VideoPlayer.this.nRU.a(true, VideoPlayer.this.nRQ.getPlayState() == 4, VideoPlayer.this.nRQ.getPlayState() == 5);
                    }
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void onPlayerStart() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerACallback onPlayerStart");
            if (!VideoPlayer.this.isFinishing()) {
                if (VideoPlayer.this.nRU == null || !VideoPlayer.this.nRU.H) {
                    if (VideoPlayer.this.nRU != null && !VideoPlayer.this.d) {
                        if (VideoPlayer.this.nRQ != null) {
                            VideoPlayer.this.nRU.F();
                            VideoPlayer.this.nRU.a(true, VideoPlayer.this.nRQ.getPlayState() == 4, VideoPlayer.this.nRQ.getPlayState() == 5);
                        } else {
                            VideoPlayer.this.nRU.a(false, true, false);
                        }
                    }
                    if (VideoPlayer.this.nSw != null && !VideoPlayer.this.ecM()) {
                        VideoPlayer.this.nSw.removeMessages(1);
                        VideoPlayer.this.nSw.C(1, VideoPlayer.A);
                    }
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void edf() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerACallback onPlayerPause");
            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.nSw != null) {
                VideoPlayer.this.nSw.removeMessages(1);
            }
        }

        @Override // tv.chushou.common.player.b
        public void edg() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerACallback onPlayerStop");
            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.ecM() && VideoPlayer.this.nRR != null && !h.isEmpty(VideoPlayer.this.P) && VideoPlayer.this.nRR.getCurrentPos() > 0) {
                j.ecE().a(VideoPlayer.this.P, VideoPlayer.this.nRR.getCurrentPos());
            }
        }
    };
    private tv.chushou.common.player.b nSA = new tv.chushou.common.player.b() { // from class: com.kascend.chushou.player.VideoPlayer.15
        @Override // tv.chushou.common.player.b
        public void ecZ() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerBCallback onSetVideoViewLayout");
            if (!VideoPlayer.this.isFinishing()) {
                if ((VideoPlayer.this.nRU == null || !VideoPlayer.this.nRU.H) && VideoPlayer.this.nRU != null && VideoPlayer.this.d) {
                    VideoPlayer.this.nRU.y();
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void NG(int i) {
            if (!VideoPlayer.this.isFinishing()) {
                if ((VideoPlayer.this.nRU == null || !VideoPlayer.this.nRU.H) && VideoPlayer.this.nRU != null && VideoPlayer.this.d) {
                    VideoPlayer.this.nRU.g(i);
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void eda() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerBCallback onCompletePlayback");
            if (!VideoPlayer.this.isFinishing()) {
                if (!h.isEmpty(VideoPlayer.this.P)) {
                    j.ecE().a(VideoPlayer.this.P, 0);
                }
                VideoPlayer.this.K = false;
                if (VideoPlayer.this.nSw != null) {
                    VideoPlayer.this.nSw.removeMessages(1);
                }
                if ((VideoPlayer.this.nRU == null || !VideoPlayer.this.nRU.H) && VideoPlayer.this.nRU != null && VideoPlayer.this.d) {
                    VideoPlayer.this.nSw.removeMessages(7);
                    VideoPlayer.this.M = false;
                    VideoPlayer.this.nRU.z();
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void edb() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerBCallback onVideoRenderingStart");
            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.nRU != null) {
                VideoPlayer.this.nRU.G();
            }
        }

        @Override // tv.chushou.common.player.b
        public void edc() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerBCallback onPreparedPlayback");
            if (!VideoPlayer.this.isFinishing()) {
                if (VideoPlayer.this.nRU == null || !VideoPlayer.this.nRU.H) {
                    VideoPlayer.this.nSw.removeMessages(6);
                    VideoPlayer.this.N = 0L;
                    VideoPlayer.this.O = 0;
                    if (VideoPlayer.this.nRQ != null && VideoPlayer.this.nRU != null) {
                        VideoPlayer.this.nRQ.setVolume(VideoPlayer.this.nRU.J, VideoPlayer.this.nRU.J);
                    }
                    if (VideoPlayer.this.nRW != null) {
                        VideoPlayer.this.K = false;
                        FullRoomInfo edj = VideoPlayer.this.ecM() ? null : VideoPlayer.this.nRW.edj();
                        if (VideoPlayer.this.L || edj != null) {
                            if (VideoPlayer.this.nRW.e) {
                                VideoPlayer.this.nRW.e = false;
                                VideoPlayer.this.nRW.d = !VideoPlayer.this.nRW.d;
                            }
                            if (VideoPlayer.this.nRU != null) {
                                VideoPlayer.this.c("1", (String) null);
                                if (VideoPlayer.this.d) {
                                    VideoPlayer.this.nRU.i(true);
                                } else if (VideoPlayer.this.e) {
                                    VideoPlayer.this.e = false;
                                    VideoPlayer.this.nRU.B();
                                }
                            }
                        }
                    }
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void NH(int i) {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerBCallback onErrorAppeared");
            if (!VideoPlayer.this.isFinishing()) {
                VideoPlayer.this.c();
                VideoPlayer.this.K = false;
                if (VideoPlayer.this.nSw != null) {
                    VideoPlayer.this.nSw.removeMessages(7);
                }
                if (VideoPlayer.this.nSw != null) {
                    VideoPlayer.this.nSw.removeMessages(1);
                }
                if ((VideoPlayer.this.nRU == null || !VideoPlayer.this.nRU.H) && !VideoPlayer.this.ecG()) {
                    if (!"10004".equals(VideoPlayer.this.t)) {
                        if (VideoPlayer.this.nRU != null) {
                            if (!VideoPlayer.this.d) {
                                VideoPlayer.this.nRS.stop();
                                VideoPlayer.this.nRS.release();
                                VideoPlayer.this.nRU.C();
                                VideoPlayer.this.e = false;
                            }
                            if (!com.kascend.chushou.b.ecq().a && !com.kascend.chushou.b.ecq().b) {
                                VideoPlayer.this.nRU.g(true);
                            } else if (VideoPlayer.this.d) {
                                VideoPlayer.this.nRU.a(i, false);
                            } else {
                                VideoPlayer.this.nRU.a(i, true);
                            }
                            VideoPlayer.this.c("2", (String) null);
                            return;
                        }
                        return;
                    }
                    eda();
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void edd() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerBCallback onBufferingStart");
            if (!VideoPlayer.this.isFinishing()) {
                if ((VideoPlayer.this.nRU == null || !VideoPlayer.this.nRU.H) && VideoPlayer.this.nRU != null && VideoPlayer.this.d) {
                    VideoPlayer.this.nRU.E();
                    VideoPlayer.this.M = true;
                    VideoPlayer.this.nSw.removeMessages(7);
                    long currentTimeMillis = System.currentTimeMillis();
                    if (!VideoPlayer.this.g) {
                        VideoPlayer.y(VideoPlayer.this);
                    }
                    tv.chushou.zues.utils.e.d(VideoPlayer.this.v, "currentTime: -- >" + currentTimeMillis + "  bufferTime-->" + VideoPlayer.this.N + "  bufferCount-->" + VideoPlayer.this.O);
                    if (currentTimeMillis - VideoPlayer.this.N >= 20000 || VideoPlayer.this.O < 2 || VideoPlayer.this.nRU.H) {
                        if (VideoPlayer.this.O == 1) {
                            VideoPlayer.this.N = currentTimeMillis;
                        }
                        VideoPlayer.this.nSw.C(7, 5000L);
                    } else {
                        VideoPlayer.this.N = 0L;
                        VideoPlayer.this.O = 0;
                        VideoPlayer.this.nSw.Pb(7);
                    }
                    if (VideoPlayer.this.g) {
                        VideoPlayer.this.g = false;
                    }
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void ede() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerBCallback onBufferingEnd");
            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.nRU != null && VideoPlayer.this.d) {
                VideoPlayer.this.M = false;
                VideoPlayer.this.nSw.removeMessages(7);
                if (VideoPlayer.this.nRU == null || !VideoPlayer.this.nRU.H) {
                    if (VideoPlayer.this.nRQ == null) {
                        VideoPlayer.this.nRU.a(false, true, false);
                    } else {
                        VideoPlayer.this.nRU.a(true, VideoPlayer.this.nRQ.getPlayState() == 4, VideoPlayer.this.nRQ.getPlayState() == 5);
                    }
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void onPlayerStart() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerBCallback onPlayerStart");
            if (!VideoPlayer.this.isFinishing()) {
                if (VideoPlayer.this.nRU == null || !VideoPlayer.this.nRU.H) {
                    if (VideoPlayer.this.nRU != null && VideoPlayer.this.d) {
                        if (VideoPlayer.this.nRQ != null) {
                            VideoPlayer.this.nRU.F();
                            VideoPlayer.this.nRU.a(true, VideoPlayer.this.nRQ.getPlayState() == 4, VideoPlayer.this.nRQ.getPlayState() == 5);
                        } else {
                            VideoPlayer.this.nRU.a(false, true, false);
                        }
                    }
                    if (VideoPlayer.this.nSw != null && !VideoPlayer.this.ecM()) {
                        VideoPlayer.this.nSw.removeMessages(1);
                        VideoPlayer.this.nSw.C(1, VideoPlayer.A);
                    }
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void edf() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerBCallback onPlayerPause");
            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.nSw != null) {
                VideoPlayer.this.nSw.removeMessages(1);
            }
        }

        @Override // tv.chushou.common.player.b
        public void edg() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerBCallback onPlayerStop");
            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.ecM() && VideoPlayer.this.nRS != null && !h.isEmpty(VideoPlayer.this.P) && VideoPlayer.this.nRS.getCurrentPos() > 0) {
                j.ecE().a(VideoPlayer.this.P, VideoPlayer.this.nRS.getCurrentPos());
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
        this.nRP = intent.getData();
        if (this.nRP == null) {
            finish();
            return;
        }
        com.kascend.chushou.d.e.j();
        if (this.nSv == null) {
            this.nSv = new CSTVWifiReceiver();
            registerReceiver(this.nSv, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        }
        com.kascend.chushou.toolkit.d.a.eeG().b();
        tv.chushou.zues.utils.e.i(this.v, "intent.getData=" + this.nRP.toString());
        String scheme = this.nRP.getScheme();
        if (scheme == null || !scheme.equals("chushou")) {
            tv.chushou.zues.utils.e.e(this.v, "not support scheme :" + scheme);
            finish();
            return;
        }
        a(intent);
    }

    private void a(Intent intent) {
        this.P = this.nRP.getQueryParameter("roomId");
        this.Q = this.P;
        this.S = this.nRP.getQueryParameter(WebSocketRequest.PARAM_KEY_PROTOCOLS);
        this.aq = this.nRP.getQueryParameter("liveType");
        if ("2".equals(this.aq) || "3".equals(this.aq) || "4".equals(this.aq)) {
            this.nSr = "2";
            this.nSs = new com.kascend.chushou.player.feedback.a();
            if (this.nSs.oaG != null) {
                this.nSs.oaG.reset();
                this.nSs.oaG.roomId = this.P;
                this.nSs.oaG.enterType = 1;
                this.nSs.b = System.currentTimeMillis();
            }
        }
        if (h.isEmpty(this.P) || h.isEmpty(this.S)) {
            tv.chushou.zues.utils.e.e(this.v, "invalid param mItemID=" + this.P + " protocols=" + this.S);
            finish();
            return;
        }
        if (com.kascend.chushou.b.ecq().d == -1) {
            com.kascend.chushou.b.ecq().d = com.kascend.chushou.d.g.b() ? 1 : 0;
        }
        this.nSi = ((PowerManager) getSystemService("power")).newWakeLock(536870938, this.v);
        this.nSi.acquire();
        this.nRW = new b(this.P);
        this.nRW.d = intent.getBooleanExtra("room_play_audio", false);
        this.nRZ = new com.kascend.chushou.widget.a.b();
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
        this.nSb = (KPSwitchRootRelativeLayout) findViewById(a.f.rlRoot);
        if (!"2".equals(this.nSr) && com.kascend.chushou.b.ecq().d == 1) {
            this.nSb.setFitsSystemWindows(true);
        }
        this.nSc = (FrameLayout) this.nSb.findViewById(a.f.fl_fragment);
        this.bLf = this.nSb.findViewById(a.f.rl_empty);
        this.T = (ImageView) this.bLf.findViewById(a.f.iv_empty);
        this.U = (TextView) this.bLf.findViewById(a.f.tv_empty);
        this.nSe = (LinearLayout) this.nSb.findViewById(a.f.rl_title);
        this.nSd = (ImageView) this.nSe.findViewById(a.f.back_icon);
        this.nSd.setOnClickListener(new View.OnClickListener() { // from class: com.kascend.chushou.player.VideoPlayer.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayer.this.finish();
            }
        });
        this.nRY = (AnimationImageView) this.bLf.findViewById(a.f.iv_loading);
        this.nSj = (FrescoThumbnailView) this.nSb.findViewById(a.f.live_cover);
        this.nSk = (FrameLayout) this.nSb.findViewById(a.f.fl_cover);
        this.k = ecF();
        try {
            this.nSa = (AudioManager) getApplicationContext().getSystemService("audio");
            n = this.nSa.getStreamVolume(3);
            this.nSa.requestAudioFocus(null, 3, 1);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (this.B) {
            a(1, ecM() ? "3" : "1");
        } else {
            r();
        }
        if (com.kascend.chushou.b.ecq().b && !com.kascend.chushou.b.ecq().a) {
            RxExecutor.postDelayed(this.nSt, EventThread.MAIN_THREAD, 60L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.VideoPlayer.5
                @Override // java.lang.Runnable
                public void run() {
                    if (!VideoPlayer.this.isFinishing() && com.kascend.chushou.b.ecq().b && !com.kascend.chushou.b.ecq().a) {
                        tv.chushou.zues.utils.g.c(VideoPlayer.this.w, VideoPlayer.this.getString(a.i.str_monet_notify));
                    }
                }
            });
        }
        com.kascend.chushou.c.c.ect().a(this.P, stringExtra, System.currentTimeMillis());
    }

    @Override // com.kascend.chushou.view.base.BaseActivity
    public void a() {
    }

    @Override // com.kascend.chushou.view.base.BaseActivity
    public void b() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (this.nSu == null) {
            this.nSu = new a();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(VideoReceiver.ACTION_VOLUME_CHANGED);
            registerReceiver(this.nSu, intentFilter);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        j(false);
        if (this.nSu != null) {
            unregisterReceiver(this.nSu);
            this.nSu = null;
        }
        super.onStop();
    }

    @Override // com.kascend.chushou.view.base.BaseActivity
    protected void a(boolean z) {
        if (this.nRU != null) {
            this.nRU.k(z);
        }
    }

    @Subscribe
    public void onHideGiftEffectEvent(com.kascend.chushou.b.a.a.f fVar) {
        if (fVar.b) {
            this.nRU.k();
            return;
        }
        this.nRU.m();
        this.nRU.l();
    }

    private float ecF() {
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
            this.nRW.h = jSONObject.toString();
            String optString = jSONObject.optString("_thumb");
            jSONObject.optBoolean("tag_from_game_mic", false);
            if (!h.isEmpty(optString)) {
                this.ab = optString;
            }
        } catch (JSONException e) {
            e.printStackTrace();
            this.nRW.h = str;
        }
        if (ecM()) {
            a(this.P, str);
            bc(this.P, z);
            return;
        }
        a = this.P;
        b(this.P, str);
        a(this.P, ecW(), z);
        w();
    }

    private void O() {
        this.m = true;
        j();
        if (this.nRU != null) {
            this.nRU.r();
        }
        s();
    }

    @Subscribe
    public void onStartRoomEvent(o oVar) {
        if (!isFinishing() && oVar.nRx != null && oVar.c != null && !h.isEmpty(oVar.nRx.mTargetKey)) {
            if (oVar.c != this) {
                tv.chushou.zues.utils.e.e(this.v, "different player!");
                return;
            }
            if (this.nRW != null) {
                this.nRW.a();
                this.nRW.a = oVar.nRx.mTargetKey;
                this.nRW.d = oVar.d;
                if (this.nRW.nTv != null) {
                    this.nRW.nTv.e();
                }
                if (this.nRW.nTv != null) {
                    this.nRW.nTv.b();
                }
                this.nRW.nTy = null;
                this.nRW.nTx = null;
                this.nRW.nTB = null;
                this.nRW.nTA = null;
                this.nRW.nTE = null;
                this.nRW.nTC = null;
                this.nRW.nTD = null;
            }
            if (this.nSa != null) {
                n = this.nSa.getStreamVolume(3);
            }
            if (!h.isEmpty(oVar.nRx.mType) && oVar.nRx.mType.equals("3")) {
                this.B = false;
                this.nSr = "1";
                r();
                this.P = oVar.nRx.mTargetKey;
                this.R = "3";
                if (this.nRZ != null) {
                    this.nRZ.a();
                }
                if (this.nRW != null) {
                    this.nRW.a((PlayUrl) null);
                    this.nRW.f();
                    if (this.nRW.c() != null) {
                        this.nRW.c().clear();
                    }
                    this.nRW.i.clear();
                }
                if (this.nRU != null) {
                    this.nRU.j();
                }
                s();
                if (this.nSf != null) {
                    this.nSf.d();
                    this.nSf = null;
                }
                if (this.nSt != null) {
                    this.nSt.dispose();
                    this.nSt = new io.reactivex.disposables.a();
                }
                a(oVar.e, false);
                return;
            }
            boolean z = this.R != null && this.R.equals("1");
            this.R = "1";
            this.nSo.a();
            this.nSn.a();
            this.nSm.a();
            this.nSl.c();
            this.nSq.a();
            if (this.nSt != null) {
                this.nSt.dispose();
                this.nSt = new io.reactivex.disposables.a();
            }
            if ("1".equals(oVar.f)) {
                this.H = false;
                if (this.nRW != null && !h.isEmpty(this.nRW.t)) {
                    this.nRW.t.clear();
                }
                this.ab = oVar.nRx.mCover;
                this.nSk.setVisibility(0);
                this.nSj.setBlur(true);
                this.nSj.i(oVar.nRx.mCover, 0, 0, 0);
            }
            if (!oVar.nRx.mTargetKey.equals(this.P)) {
                this.aq = oVar.g;
                if (!z) {
                    this.B = false;
                    r();
                } else if (!"2".equals(this.nSr) && ("2".equals(this.aq) || "3".equals(this.aq) || "4".equals(this.aq))) {
                    this.nSr = "2";
                    this.nSs = new com.kascend.chushou.player.feedback.a();
                    if (this.nSs.oaG != null) {
                        this.nSs.oaG.reset();
                        this.nSs.oaG.roomId = oVar.nRx.mTargetKey;
                        this.nSs.oaG.enterType = 1;
                        this.nSs.b = System.currentTimeMillis();
                    }
                }
                this.B = false;
                this.P = oVar.nRx.mTargetKey;
                this.Q = this.P;
                this.ab = oVar.nRx.mCover;
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
                JSONObject O = com.kascend.chushou.d.e.O("_fromView", str, "_sc", oVar.nRx.mSC);
                com.kascend.chushou.toolkit.a.c.a(this.w, O);
                if (this.nRZ != null) {
                    this.nRZ.a();
                    this.nRZ.a(this.P);
                }
                if (this.nRW != null) {
                    this.nRW.a((PlayUrl) null);
                    this.nRW.f();
                    if (this.nRW.c() != null) {
                        this.nRW.c().clear();
                    }
                    this.nRW.i.clear();
                }
                if (this.nRU != null) {
                    this.nRU.j();
                }
                a(O.toString(), false);
                return;
            }
            tv.chushou.zues.utils.g.Pk(a.i.str_same_room);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ecG() {
        FullRoomInfo edj;
        String str;
        RoomInfo roomInfo;
        if (ecM()) {
            str = null;
            edj = null;
        } else {
            edj = this.nRW.edj();
            str = (edj == null || (roomInfo = edj.mRoominfo) == null) ? null : roomInfo.mGameId;
        }
        return !this.L && (edj == null || h.isEmpty(str));
    }

    @Subscribe
    public void onMessageEvent(i iVar) {
        if (!isFinishing() && iVar.a != 21 && iVar.a != 22) {
            if (iVar.a == 0 && (iVar.b instanceof Boolean)) {
                if (((Boolean) iVar.b).booleanValue() && !isFinishing()) {
                    w();
                    if (this.nRU != null) {
                        this.nRU.f();
                    }
                }
            } else if (iVar.a == 46) {
                if ((iVar.b instanceof String) && this.nRU != null) {
                    this.nRU.c((String) iVar.b);
                }
            } else if (iVar.a == 54) {
                if (iVar.b instanceof String) {
                    this.nSm.a((String) iVar.b);
                }
            } else if (iVar.a == 55) {
                if (this.nRU != null) {
                    this.nRU.O();
                }
            } else if (iVar.a == 56 && this.nRU != null) {
                this.nRU.P();
            }
        }
    }

    @Subscribe
    public void onRefreshSubscribeEvent(m mVar) {
        if (isFinishing() && this.nRW != null && this.nRW.edl() != null) {
            RoomInfo edl = this.nRW.edl();
            if (mVar.a(edl.mCreatorUID, edl.mRoomID)) {
                edl.mIsSubscribed = mVar.c;
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
        if (this.m || this.nRR == null || this.nRS == null) {
            R();
        }
        if (this.nRZ != null) {
            this.nRZ.d();
        }
        if (!ecM()) {
            if (this.nSf != null && !this.nSf.c()) {
                this.nSf.a();
            }
            v();
            if (this.nRW != null && this.nRW.edj() != null && this.nRW.edj().cycleLiveRoomInfo != null && !h.isEmpty(this.nRW.edj().cycleLiveRoomInfo.roomId)) {
                u();
            }
        }
        super.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.view.base.BaseActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        tv.chushou.zues.utils.e.e(this.v, MissionEvent.MESSAGE_DESTROY);
        if (this.nRW != null && this.nRW.edj() != null && this.nRW.edj().cycleLiveRoomInfo != null && !h.isEmpty(this.nRW.edj().cycleLiveRoomInfo.eventName)) {
            j.ecE().a(this.P + ecW());
        }
        if ("2".equals(this.nSr) && this.nSs != null && this.nSs.oaG != null) {
            this.nSs.oaG.time = System.currentTimeMillis() - this.nSs.b;
            this.nSs.a();
            this.nSs.b();
        }
        this.nSl.d();
        this.nSm.b();
        this.nSn.b();
        O();
        this.ag = null;
        a = null;
        if (this.nSw != null) {
            this.nSw.cl(null);
            this.nSw = null;
        }
        if (this.nSf != null) {
            this.nSf.d();
            this.nSf = null;
        }
        if (this.nRZ != null) {
            this.nRZ.c();
            this.nRZ = null;
        }
        if (this.nRW != null) {
            this.nRW.nTy = null;
            this.nRW.nTx = null;
        }
        if (this.nRW != null) {
            this.nRW.b();
            this.nRW = null;
        }
        this.nRP = null;
        this.nRU = null;
        this.nRV = null;
        this.nRX = null;
        this.T = null;
        this.U = null;
        this.nRY = null;
        this.bLf = null;
        this.nSa = null;
        this.nSb = null;
        this.nSc = null;
        this.nSd = null;
        this.nSe = null;
        if (this.nSi != null && this.nSi.isHeld()) {
            this.nSi.release();
            this.nSi = null;
        }
        if (this.nSv != null) {
            unregisterReceiver(this.nSv);
            this.nSv = null;
        }
        h.equ();
        tv.chushou.zues.a.a.cm(this);
        this.nSt.dispose();
        this.nSn.b();
        this.nSo.b();
        this.nSl.d();
        this.nSm.b();
        this.nSq.b();
        super.onDestroy();
        System.gc();
    }

    @Subscribe
    public void onSendGameGiftEvent(n nVar) {
        if (!isFinishing() && this.nRU != null) {
            this.nRU.a(nVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.view.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        tv.chushou.zues.utils.e.d(this.v, MissionEvent.MESSAGE_PAUSE);
        if (this.nSf != null) {
            this.nSf.b();
        }
        if (this.nRZ != null) {
            this.nRZ.b(false);
        }
        k();
        this.m = true;
        super.onPause();
    }

    @Override // android.app.Activity
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.nRU != null ? this.nRU.a(motionEvent) : super.onTouchEvent(motionEvent);
    }

    public void c() {
        if ("1".equals(this.R)) {
            j.ecE().a(this.P + ecW());
        } else {
            j.ecE().b(this.P);
        }
    }

    private void a(boolean z, boolean z2) {
        int i = 0;
        tv.chushou.zues.utils.e.i(this.v, "startLoadingVideo <------------- mbPrepareingVideo = " + this.K);
        if (this.nRR != null) {
            this.nRR.setHardwearDecod(com.kascend.chushou.d.h.ecy().a);
        }
        if (this.nRS != null) {
            this.nRS.setHardwearDecod(com.kascend.chushou.d.h.ecy().a);
        }
        if (this.nRQ != null) {
            this.nRQ.setHardwearDecod(com.kascend.chushou.d.h.ecy().a);
        }
        if (!this.K) {
            if (z && this.nRU != null) {
                if (!z2) {
                    this.t = null;
                    this.nRU.e();
                }
            } else if (this.nRU != null && !z2) {
                this.t = null;
                this.nRU.H = false;
                RxExecutor.post(null, EventThread.MAIN_THREAD, new Runnable() { // from class: com.kascend.chushou.player.VideoPlayer.7
                    @Override // java.lang.Runnable
                    public void run() {
                        VideoPlayer.this.nRU.x();
                    }
                });
            }
            this.K = true;
            if (this.nRW != null && this.nRW.edk() != null) {
                PlayUrl edk = this.nRW.edk();
                while (true) {
                    int i2 = i;
                    if (i2 >= edk.mUrlDetails.size()) {
                        break;
                    }
                    UrlDetails urlDetails = edk.mUrlDetails.get(i2);
                    if (urlDetails.mUrl.equals(edk.mSelectedUrl)) {
                        String str = edk.mUrlDetails.get(i2).mDefinitionType;
                        String str2 = urlDetails.mBitrate;
                    }
                    i = i2 + 1;
                }
            }
            if (z2) {
                if (this.d) {
                    this.nRR.setVideoURI(this.nRP);
                    this.nRR.open();
                    return;
                }
                this.nRS.setVideoURI(this.nRP);
                this.nRS.open();
                return;
            }
            this.nRQ.setVideoURI(this.nRP);
            this.nRQ.open();
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        try {
            if (motionEvent.getAction() == 0) {
                if (this.nRU != null && this.nRU.b(motionEvent)) {
                    return true;
                }
                if ("2".equals(this.nSr) && this.nRU != null) {
                    this.nRU.a(motionEvent);
                }
            } else if (this.nRU != null && this.nRU.b(motionEvent)) {
                return true;
            }
            return super.dispatchTouchEvent(motionEvent);
        } catch (Exception e) {
            return false;
        }
    }

    @Override // android.support.v7.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.nRU != null && this.nRU.a(i, keyEvent)) {
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
        if (this.nRW != null && this.nRW.edj() != null && this.nRW.edj().cycleLiveRoomInfo != null && !h.isEmpty(this.nRW.edj().cycleLiveRoomInfo.roomId)) {
            this.nSk.setVisibility(0);
            this.nSj.setBlur(true);
            this.nSj.i(this.nRW.edj().cycleLiveRoomInfo.avatar, 0, 0, 0);
            this.nSj.setVisibility(0);
            j.ecE().a(this.P + ecW());
            this.nRP = null;
            R();
            this.Q = this.nRW.edj().cycleLiveRoomInfo.roomId;
            a(this.P, ecW(), false);
        }
    }

    public void b(boolean z) {
        if (this.nRU != null) {
            this.nRU.j(z);
        }
    }

    public void a(boolean z, Uri uri, boolean z2) {
        tv.chushou.zues.utils.e.d(this.v, "loadIfNecessary reload=" + z + " isChangeLines-->" + z2);
        if (this.nRR != null && this.nRS != null) {
            if (uri != null) {
                this.nRP = uri;
            }
            if (z2) {
                this.e = z2;
            }
            this.M = false;
            this.N = 0L;
            this.O = 0;
            this.nSw.removeMessages(7);
            if (z) {
                if (z2) {
                    if (!this.d) {
                        this.nRS.setOnActivityCallBack(this.nSA);
                    } else {
                        this.nRR.setOnActivityCallBack(this.nSz);
                    }
                } else if (this.d) {
                    this.nRS.setOnActivityCallBack(this.nSA);
                } else {
                    this.nRR.setOnActivityCallBack(this.nSz);
                }
                this.K = false;
                b(true, z2);
            } else if (!this.J) {
                b(true, z2);
            }
            this.nSw.C(6, IMConnection.RETRY_DELAY_TIMES);
        }
    }

    private void b(boolean z, boolean z2) {
        VideoPlayInfo O;
        if ("1".equals(this.R)) {
            O = j.ecE().N(this.P + ecW(), 600000L);
        } else {
            O = j.ecE().O(this.P, 600000L);
        }
        if (O != null) {
            a(z, z2);
        } else if ("1".equals(this.R)) {
            a(this.P, ecW(), false);
        } else {
            bc(this.P, false);
        }
    }

    public tv.chushou.common.player.a ecH() {
        return this.nRQ;
    }

    public tv.chushou.common.player.a ecI() {
        return this.nRR;
    }

    public tv.chushou.common.player.a ecJ() {
        return this.nRS;
    }

    public void a(tv.chushou.common.player.a aVar) {
        this.nRQ = aVar;
    }

    public b ecK() {
        return this.nRW;
    }

    public com.kascend.chushou.widget.a.b ecL() {
        return this.nRZ;
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
        FullRoomInfo edj;
        this.r = -1L;
        if (this.s != -1 && this.s != 0) {
            this.r = this.s;
            this.s = -1L;
        }
        if (ecM() && this.nRQ != null && this.nRQ.getPlayState() == 4) {
            this.r = this.nRQ.getCurrentPos();
        }
        this.nSx = false;
        tv.chushou.zues.utils.e.d(this.v, "screenChange()<-----");
        tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard(this);
        if (str != null) {
            this.R = str;
        }
        if (!this.C || !z3 || "3".equals(this.R) || this.nRW == null || (edj = this.nRW.edj()) == null || edj.mRoominfo == null || edj.mRoominfo.mStyle != 1) {
            z5 = false;
        } else {
            z5 = true;
            i = 0;
        }
        if ("2".equals(this.nSr)) {
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
            if (com.kascend.chushou.b.ecq().d == 1) {
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
            ((VideoPlayer) this.w).yD(false);
            ((VideoPlayer) this.w).g(true);
            if (z5) {
                setRequestedOrientation(1);
            } else {
                setRequestedOrientation(6);
            }
            getWindow().addFlags(512);
            getWindow().addFlags(256);
        }
        if (this.nRZ == null) {
            this.nRZ = new com.kascend.chushou.widget.a.b();
        }
        if (this.nRZ != null) {
            this.nRZ.a(this.P);
        }
        if (this.R.equals("5")) {
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            if (this.nRU != null) {
                beginTransaction.remove(this.nRU);
                this.nRU = null;
            }
            if (this.nRV != null) {
                beginTransaction.remove(this.nRV);
                this.nRV = null;
            }
            this.nRV = new com.kascend.chushou.view.user.b();
            beginTransaction.add(a.f.fl_fragment, this.nRV);
            beginTransaction.commitAllowingStateLoss();
        } else {
            FragmentTransaction beginTransaction2 = getSupportFragmentManager().beginTransaction();
            if (this.nRU != null) {
                beginTransaction2.remove(this.nRU);
                this.nRU = null;
            }
            if (this.nRV != null) {
                beginTransaction2.remove(this.nRV);
                this.nRV = null;
            }
            if ("2".equals(this.nSr)) {
                this.nRU = com.kascend.chushou.player.e.e.b(this.ab, z2, this.aq, this.P);
            } else if (1 == i) {
                if (!this.R.equals("3")) {
                    if (z4) {
                        v();
                    }
                    this.nRU = new com.kascend.chushou.player.d.a();
                    Bundle bundle = new Bundle();
                    bundle.putString("mCover", this.ab);
                    bundle.putBoolean("mInitViewAsync", z2);
                    this.nRU.setArguments(bundle);
                }
            } else {
                this.nRU = new com.kascend.chushou.player.d.b();
                Bundle bundle2 = new Bundle();
                if (z5) {
                    i = 1;
                }
                bundle2.putInt("mExtraOrientation", i);
                bundle2.putString("mViewType", this.R);
                this.nRU.setArguments(bundle2);
            }
            beginTransaction2.add(a.f.fl_fragment, this.nRU);
            beginTransaction2.commitAllowingStateLoss();
            this.H = true;
        }
        tv.chushou.zues.utils.e.d(this.v, "screenChange()----->");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean ecM() {
        return this.R != null && this.R.equals("3");
    }

    private void R() {
        if (this.nRU != null) {
            this.nRU.nWQ = null;
        }
        if (this.nRQ != null) {
            this.nRQ.release();
            this.nRQ = null;
            this.K = false;
        }
        if (this.nRR != null) {
            this.nRR.release();
            this.nRR = null;
        }
        if (this.nRS != null) {
            this.nRS.release();
            this.nRS = null;
        }
        if (this.nRT != null) {
            this.nRT.c();
        }
        this.d = false;
        this.e = false;
        this.M = false;
        this.nRT = new c();
        this.nRR = this.nRT.edo();
        this.nRR.setOnActivityCallBack(this.nSz);
        this.nRS = this.nRT.edp();
        this.nRS.setOnActivityCallBack(this.nSA);
        if (!this.d) {
            this.nRQ = this.nRR;
        } else {
            this.nRQ = this.nRS;
        }
        if (this.nRU != null) {
            this.nRU.nWQ = this.nRQ;
        }
    }

    public void j() {
        if (this.nRQ != null) {
            this.nRQ.pause();
            this.nRQ.stop();
            this.nRQ.release();
            this.nRQ = null;
        }
        if (this.nRR != null) {
            this.nRR.stop();
            this.nRR.release();
            this.nRR = null;
        }
        if (this.nRS != null) {
            this.nRS.stop();
            this.nRS.release();
            this.nRS = null;
        }
        if (this.nRT != null) {
            this.nRT.c();
        }
    }

    public void k() {
        tv.chushou.common.player.a aVar = this.nRQ;
        if (aVar != null) {
            aVar.pause();
            aVar.stop();
        }
        tv.chushou.common.player.a aVar2 = this.nRR;
        if (aVar2 != null) {
            aVar2.stop();
        }
        tv.chushou.common.player.a aVar3 = this.nRS;
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
        if (this.nSx) {
            if (this.nRU != null) {
                this.nRU.s();
            }
        } else if (this.nSw != null) {
            this.nSw.b(this.nSw.Pd(3), 20L);
        }
    }

    private void b(final String str, String str2) {
        com.kascend.chushou.c.c.ect().a(new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.VideoPlayer.8
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
                        VideoPlayer.this.b(r.mMessage, r.mRc);
                        return;
                    }
                    FullRoomInfo fullRoomInfo = (FullRoomInfo) r.mData;
                    VideoPlayer.this.ecU().a(fullRoomInfo.mBangMap);
                    if (h.isEmpty(fullRoomInfo.mRoominfo.mRoomID)) {
                        fullRoomInfo.mRoominfo.mRoomID = VideoPlayer.this.P;
                    }
                    if (!h.isEmpty(fullRoomInfo.mGeneralTabGifts)) {
                        com.kascend.chushou.d.e.a(VideoPlayer.this.nSt, new ArrayList(fullRoomInfo.mGeneralTabGifts));
                    }
                    if (VideoPlayer.this.nRW != null) {
                        VideoPlayer.this.nRW.a(fullRoomInfo);
                    }
                    VideoPlayer.this.L = false;
                    if (VideoPlayer.this.B) {
                        if (VideoPlayer.this.C && !"3".equals(VideoPlayer.this.R) && fullRoomInfo != null && fullRoomInfo.mRoominfo != null && fullRoomInfo.mRoominfo.mStyle == 1 && !h.isEmpty(fullRoomInfo.mRoominfo.mGameId)) {
                            z = true;
                        }
                        if (!z) {
                            if (VideoPlayer.this.nRU != null) {
                                VideoPlayer.this.nRU.a(VideoPlayer.this.nRW);
                            }
                            if (!h.isEmpty(fullRoomInfo.mRoominfo.mGameId)) {
                                VideoPlayer.this.S();
                            } else {
                                if (VideoPlayer.this.nRW != null) {
                                    VideoPlayer.this.nRW.f = null;
                                }
                                VideoPlayer.this.S();
                            }
                        } else {
                            VideoPlayer.this.a(1, "1", true);
                            if (VideoPlayer.this.nRU != null) {
                                VideoPlayer.this.nRU.a(VideoPlayer.this.nRW);
                            }
                        }
                    } else {
                        if (h.isEmpty(fullRoomInfo.mRoominfo.mGameId)) {
                            if (VideoPlayer.this.nRW != null) {
                                VideoPlayer.this.nRW.f = null;
                            }
                            VideoPlayer.this.a(1, "1");
                        } else {
                            VideoPlayer.this.a(1, "1", true);
                        }
                        if (VideoPlayer.this.nRU != null) {
                            VideoPlayer.this.nRU.a(VideoPlayer.this.nRW);
                        }
                    }
                    if (VideoPlayer.this.nRW != null && !VideoPlayer.this.nRW.m()) {
                        if (VideoPlayer.this.nSf != null) {
                            VideoPlayer.this.nSf.d();
                            VideoPlayer.this.nSf = null;
                        }
                        VideoPlayer.this.nSf = new com.kascend.chushou.toolkit.d(900000L, VideoPlayer.this.nSh, VideoPlayer.this.nSw);
                        VideoPlayer.this.nSf.a();
                    }
                }
            }

            @Override // com.kascend.chushou.c.b
            public void a(int i, String str3) {
                if (!VideoPlayer.this.isFinishing()) {
                    VideoPlayer.this.b(str3, i);
                }
            }
        }, str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(String str, int i) {
        if (this.nRW != null) {
            this.nRW.a((FullRoomInfo) null);
        }
        this.L = false;
        bR(str, i);
        if (this.nRQ != null) {
            this.nRQ.stop();
        }
        if (this.nRR != null) {
            this.nRR.stop();
        }
        if (this.nRS != null) {
            this.nRS.stop();
        }
    }

    public void l() {
        tv.chushou.zues.utils.e.d(this.v, "retryGetPlayList");
        c();
        if (ecM()) {
            bc(this.P, false);
        } else {
            a(this.P, ecW(), false);
        }
    }

    public void m() {
        a(this.ag, false);
    }

    private void a(final String str, String str2, boolean z) {
        this.J = true;
        VideoPlayInfo N = j.ecE().N(str + str2, 600000L);
        if (N != null) {
            a((ArrayList) N.mPlayUrls);
            this.J = false;
        } else if (z) {
            ParserRet gB = com.kascend.chushou.player.c.a.edq().gB(str, str2);
            if (gB.mRc != 0) {
                tv.chushou.zues.utils.e.e(this.v, "getPlayUrlSync fail, try to getPlaylist");
                a(str, str2, false);
                return;
            }
            a(gB, str);
        } else {
            com.kascend.chushou.player.c.a.edq().a(str, str2, new a.InterfaceC0884a() { // from class: com.kascend.chushou.player.VideoPlayer.9
                @Override // com.kascend.chushou.player.c.a.InterfaceC0884a
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
    private void bc(final String str, boolean z) {
        boolean equals;
        this.J = true;
        VideoPlayInfo O = j.ecE().O(str, 600000L);
        if (O != null) {
            a((ArrayList) O.mPlayUrls);
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
                ParserRet bd = com.kascend.chushou.player.c.a.edq().bd(str, equals);
                if (bd.mRc != 0) {
                    tv.chushou.zues.utils.e.e(this.v, "getVideoPlayUrlSync fail, try to getVideoPlaylist");
                    bc(str, false);
                    return;
                }
                a(bd, str);
                return;
            }
            com.kascend.chushou.player.c.a.edq().a(str, new a.InterfaceC0884a() { // from class: com.kascend.chushou.player.VideoPlayer.10
                @Override // com.kascend.chushou.player.c.a.InterfaceC0884a
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
                if (this.nRW.f == null) {
                    this.nRW.f = new ArrayList<>();
                }
                this.nRW.f.clear();
                this.nRW.f.addAll(arrayList);
                if ("1".equals(this.R)) {
                    j.ecE().a(str + ecW(), arrayList);
                } else {
                    j.ecE().s(str, arrayList);
                }
                a(arrayList);
                return;
            }
            if (this.nRW != null) {
                this.nRW.f = null;
            }
            if (this.nSw != null) {
                Message Pd = this.nSw.Pd(5);
                Pd.arg1 = 2;
                Pd.arg2 = parserRet.mRc;
                this.nSw.S(Pd);
            }
        }
    }

    private void bR(String str, int i) {
        s();
        if (this.nRZ != null) {
            this.nRZ.a();
        }
        if (h.isEmpty(str)) {
            str = getString(a.i.str_load_data_failed);
        }
        a(str, i);
    }

    public void n() {
        if (this.nSc != null && this.bLf != null && this.nSe != null) {
            this.nSc.setVisibility(0);
            this.bLf.setVisibility(8);
            this.nSe.setVisibility(8);
        }
    }

    public void o() {
        if (this.nSj != null && this.nSj.getVisibility() == 0) {
            this.nSj.CL(0);
            this.nSj.setVisibility(8);
        }
    }

    public void p() {
        if (this.nSk != null && this.nSk.getVisibility() == 0) {
            this.nSk.setVisibility(8);
        }
    }

    public void q() {
        this.nSx = true;
    }

    protected void r() {
        this.nSc.setVisibility(8);
        this.nSe.setVisibility(0);
        this.bLf.setVisibility(0);
        if (this.nRY != null) {
            this.T.setVisibility(8);
            this.nRY.setVisibility(0);
            this.U.setText(getString(a.i.str_dialog_loading_content));
            this.U.setVisibility(8);
        }
    }

    protected void a(String str, int i) {
        this.nSc.setVisibility(8);
        this.nSe.setVisibility(0);
        this.bLf.setVisibility(0);
        if (this.nRY != null) {
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
                            com.kascend.chushou.c.c.ect().b(new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.VideoPlayer.11.1
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
                                        tv.chushou.zues.utils.g.K(VideoPlayer.this, a.i.subscribe_failed);
                                    }
                                }
                            }, VideoPlayer.this.P, (String) null, VideoPlayer.this.nRW.h);
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
            this.nRY.setVisibility(8);
            this.nSk.setVisibility(8);
        }
    }

    public void s() {
        if (this.nSw != null) {
            this.nSw.removeMessages(1);
        }
    }

    private void a(ArrayList<PlayUrl> arrayList) {
        boolean z;
        if (this.nRW.f == null) {
            this.nRW.f = new ArrayList<>();
        }
        this.nRW.f.clear();
        this.nRW.f.addAll(arrayList);
        if (com.kascend.chushou.d.e.b() && !"4".equals(this.aq)) {
            int c = com.kascend.chushou.d.e.c();
            if (c == -1) {
                b(arrayList);
                return;
            } else if (this.aw) {
                this.aw = false;
                if (c == 0) {
                    this.nRW.d = false;
                    g(arrayList, true);
                    return;
                }
                if (this.nRW != null && this.nRW.f != null) {
                    Iterator<PlayUrl> it = this.nRW.f.iterator();
                    while (it.hasNext()) {
                        if ("2".equals(it.next().mType)) {
                            z = true;
                            break;
                        }
                    }
                }
                z = false;
                this.nRW.d = z;
                g(arrayList, true);
                return;
            } else {
                if (this.nRW.e) {
                    this.nRW.d = !this.nRW.d;
                    this.nRW.e = false;
                    this.nSy = true;
                } else if ("4".equals(this.aq)) {
                    this.nRW.d = true;
                }
                g(arrayList, true);
                return;
            }
        }
        if (this.nRW.e) {
            this.nRW.d = !this.nRW.d;
            this.nRW.e = false;
            this.nSy = true;
        } else if ("4".equals(this.aq)) {
            this.nRW.d = true;
        }
        g(arrayList, true);
    }

    private void b(ArrayList<PlayUrl> arrayList) {
        if ("1".equals(this.R)) {
            if ("2".equals(this.nSr)) {
                d(false, arrayList);
            } else if (this.nRU != null) {
                this.nRU.g(arrayList, false);
            }
        } else if (this.nRU != null) {
            this.nRU.g(arrayList, false);
        }
    }

    public void c(boolean z) {
        this.nRW.d = false;
        com.kascend.chushou.d.e.a(0);
        ArrayList<PlayUrl> arrayList = this.nRW.f;
        if (!h.isEmpty(arrayList)) {
            if (z) {
                g(arrayList, false);
                if (this.nSw != null) {
                    this.nSw.Pb(2);
                    return;
                }
                return;
            }
            g(arrayList, true);
        }
    }

    public void d(boolean z) {
        this.nRW.d = true;
        com.kascend.chushou.d.e.a(1);
        ArrayList<PlayUrl> arrayList = this.nRW.f;
        if (!h.isEmpty(arrayList)) {
            if (z) {
                g(arrayList, false);
                if (this.nSw != null) {
                    this.nSw.Pb(2);
                    return;
                }
                return;
            }
            g(arrayList, true);
        }
    }

    @Subscribe
    public void onNotifyEvent(com.kascend.chushou.b.a.a.j jVar) {
        if (!isFinishing() && jVar.a == 1 && !"5".equals(this.R) && !ecG()) {
            tv.chushou.zues.utils.e.d(this.v, "onNetworkChangeEvent 3G=" + com.kascend.chushou.b.ecq().b + "  wifi=" + com.kascend.chushou.b.ecq().a);
            if (com.kascend.chushou.d.e.b() && !"4".equals(this.aq)) {
                if (com.kascend.chushou.d.e.c() == -1) {
                    if (this.nRU != null) {
                        this.nRU.e(false);
                    }
                    if ("1".equals(this.R)) {
                        if ("2".equals(this.nSr)) {
                            d(true, null);
                            return;
                        } else if (this.nRU != null) {
                            this.nRU.g(this.nRW.f, true);
                            return;
                        } else {
                            return;
                        }
                    } else if (this.nRU != null) {
                        this.nRU.g(this.nRW.f, true);
                        return;
                    } else {
                        return;
                    }
                }
                RxExecutor.postDelayed(this.nSt, EventThread.MAIN_THREAD, 10L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.VideoPlayer.12
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!VideoPlayer.this.isFinishing() && com.kascend.chushou.b.ecq().b && !com.kascend.chushou.b.ecq().a) {
                            tv.chushou.zues.utils.g.c(VideoPlayer.this.w, VideoPlayer.this.getString(a.i.str_monet_notify));
                        }
                    }
                });
            } else if (com.kascend.chushou.b.ecq().a || com.kascend.chushou.b.ecq().b) {
                t();
                if (this.nSw != null) {
                    this.nSw.Pb(2);
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
    private void g(ArrayList<PlayUrl> arrayList, boolean z) {
        PlayUrl playUrl;
        PlayUrl playUrl2;
        String str;
        String str2;
        boolean z2;
        PlayUrl playUrl3;
        if (arrayList.size() > 0) {
            if (this.nRW.d) {
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
            String d = com.kascend.chushou.d.h.ecy().d();
            String str3 = h.isEmpty(d) ? "2" : d;
            if (this.nRW.d) {
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
                if (this.nRW != null) {
                    this.nRW.a(playUrl2);
                    if (this.nSw != null) {
                        Message Pd = this.nSw.Pd(5);
                        Pd.arg1 = 1;
                        this.nSw.S(Pd);
                    }
                }
                String b = com.kascend.chushou.player.c.a.b(playUrl2);
                if (!h.isEmpty(b)) {
                    this.nRP = Uri.parse(b);
                    if (this.nSy) {
                        this.nSy = false;
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (z && this.nRQ != null) {
                        a(false, z2);
                    }
                }
            }
        }
    }

    public void d(final boolean z, ArrayList<PlayUrl> arrayList) {
        if (this.nSg == null || this.nSg.a <= 0) {
            this.nSg = com.kascend.chushou.view.b.a.a.eeH();
            this.nSg.a(new a.InterfaceC0903a() { // from class: com.kascend.chushou.player.VideoPlayer.13
                @Override // com.kascend.chushou.view.b.a.a.InterfaceC0903a
                public void a(int i) {
                    if (i == a.f.tv_play_video) {
                        VideoPlayer.this.nSg.dismissAllowingStateLoss();
                        VideoPlayer.this.c(z);
                    } else if (i == a.f.tv_play_audio) {
                        VideoPlayer.this.nSg.dismissAllowingStateLoss();
                        VideoPlayer.this.d(z);
                    } else if (i == a.f.iv_close) {
                        VideoPlayer.this.finish();
                    } else {
                        if (i == a.f.tv_union_proxy) {
                        }
                    }
                }
            });
            this.nSg.show(getSupportFragmentManager(), "showRoom");
        }
    }

    public void t() {
        if (this.nSg != null) {
            this.nSg.dismissAllowingStateLoss();
        }
        if (this.nRU != null) {
            this.nRU.v();
        }
    }

    public void u() {
        com.kascend.chushou.c.c.ect().c(this.P, new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.VideoPlayer.16
            @Override // com.kascend.chushou.c.b
            public void a() {
            }

            @Override // com.kascend.chushou.c.b
            public void a(String str, JSONObject jSONObject) {
                if (!VideoPlayer.this.isFinishing()) {
                    ParserRet eu = com.kascend.chushou.c.e.eu(jSONObject);
                    if (eu.mRc == 0 && eu.mData != null) {
                        CycleLiveRoomInfo cycleLiveRoomInfo = (CycleLiveRoomInfo) eu.mData;
                        if (VideoPlayer.this.nRW != null && cycleLiveRoomInfo != null && !h.isEmpty(cycleLiveRoomInfo.roomId)) {
                            FullRoomInfo edj = VideoPlayer.this.nRW.edj();
                            if (edj.cycleLiveRoomInfo == null) {
                                edj.cycleLiveRoomInfo = cycleLiveRoomInfo;
                                VideoPlayer.this.d();
                            } else if (edj.cycleLiveRoomInfo != null && !cycleLiveRoomInfo.roomId.equals(edj.cycleLiveRoomInfo.roomId)) {
                                edj.cycleLiveRoomInfo.copyCycleLiveRoomInfo(cycleLiveRoomInfo);
                                VideoPlayer.this.d();
                            } else {
                                edj.cycleLiveRoomInfo.copyCycleLiveRoomInfo(cycleLiveRoomInfo);
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
        if (this.nRU != null) {
            this.nRU.N();
        }
    }

    public void v() {
        com.kascend.chushou.c.c.ect().a(this.P, new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.VideoPlayer.17
            @Override // com.kascend.chushou.c.b
            public void a() {
            }

            @Override // com.kascend.chushou.c.b
            public void a(String str, JSONObject jSONObject) {
                if (!VideoPlayer.this.isFinishing()) {
                    ParserRet ev = com.kascend.chushou.c.e.ev(jSONObject);
                    if (ev.mRc == 0 && ev.mData != null) {
                        PkNotifyInfo pkNotifyInfo = (PkNotifyInfo) ev.mData;
                        VideoPlayer.this.nSp.b = VideoPlayer.this.P;
                        if (pkNotifyInfo != null) {
                            VideoPlayer.this.nSp.nWR = pkNotifyInfo;
                            if (VideoPlayer.this.nRU != null) {
                                VideoPlayer.this.nRU.a(pkNotifyInfo, VideoPlayer.this.P);
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
        if (this.nRX != null) {
            this.nRX.release();
            this.nRX = null;
        }
        com.kascend.chushou.c.c.ect().a(this.P, new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.VideoPlayer.18
            @Override // com.kascend.chushou.c.b
            public void a() {
            }

            @Override // com.kascend.chushou.c.b
            public void a(String str, JSONObject jSONObject) {
                if (!VideoPlayer.this.isFinishing()) {
                    ParserRet ew = com.kascend.chushou.c.e.ew(jSONObject);
                    if (ew.mRc == 0 && ew.mData != null) {
                        RoomExpandInfo roomExpandInfo = (RoomExpandInfo) ew.mData;
                        if (VideoPlayer.this.nRW != null) {
                            VideoPlayer.this.nRW.nTz = roomExpandInfo.mTopWebAdItem;
                            if (VideoPlayer.this.nRW.nTF == null) {
                                VideoPlayer.this.nRW.nTF = new ArrayList();
                            }
                            VideoPlayer.this.nRW.nTF.clear();
                            VideoPlayer.this.nRW.nTF.addAll(roomExpandInfo.mGiftTopRightIcons);
                            tv.chushou.zues.a.a.post(new i(50, VideoPlayer.this.nRW.nTz));
                        }
                        if (VideoPlayer.this.nRW != null) {
                            VideoPlayer.this.nRW.fX(roomExpandInfo.mExpandNavList);
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
                            VideoPlayer.this.nSl.a(list);
                        }
                        List<com.kascend.chushou.player.ui.h5.c.c> list2 = roomExpandInfo.mLuckList;
                        if (!h.isEmpty(list2)) {
                            VideoPlayer.this.nSm.a(list2);
                        }
                        com.kascend.chushou.player.ui.h5.c.c cVar = roomExpandInfo.mVoteItem;
                        if (cVar != null) {
                            VideoPlayer.this.nSn.a(cVar);
                        }
                        List<com.kascend.chushou.player.ui.h5.c.b> list3 = roomExpandInfo.mInteractH5Item;
                        if (!h.isEmpty(list3)) {
                            VideoPlayer.this.nSq.a(list3);
                        }
                        List<com.kascend.chushou.player.ui.h5.c.b> list4 = roomExpandInfo.mInteractNavItem;
                        if (!h.isEmpty(list4)) {
                            VideoPlayer.this.nSq.a(list4);
                        }
                        VideoPlayer.this.nRX = (PrivilegeInfo) ew.mData1;
                        if (VideoPlayer.this.nRX != null) {
                            tv.chushou.zues.a.a.post(new l());
                        }
                        if (VideoPlayer.this.nRW != null) {
                            VideoPlayer.this.nRW.nTG = roomExpandInfo.mIconConfig;
                            VideoPlayer.this.ecU().a(roomExpandInfo.mIconConfig.bangConfig);
                        }
                        List<SkinConfig> list5 = roomExpandInfo.skinConfig;
                        if (list5 != null && VideoPlayer.this.nRW != null) {
                            VideoPlayer.this.nRW.nTJ.clear();
                            int i = 0;
                            while (true) {
                                int i2 = i;
                                if (i2 >= list5.size()) {
                                    break;
                                }
                                SkinConfig skinConfig = list5.get(i2);
                                VideoPlayer.this.nRW.nTJ.put(skinConfig.position, skinConfig.resource);
                                i = i2 + 1;
                            }
                            VideoPlayer.this.C();
                        }
                        VideoPlayer.this.a(roomExpandInfo.mIconConfig, VideoPlayer.this.nRW != null ? VideoPlayer.this.nRW.nTJ : null);
                        if (roomExpandInfo.mColorMap != null && roomExpandInfo.mColorMap.size() > 0 && com.kascend.chushou.b.ecq().c != null && com.kascend.chushou.b.ecq().c.size() <= 0) {
                            com.kascend.chushou.b.ecq().c.putAll(roomExpandInfo.mColorMap);
                            tv.chushou.zues.a.a.post(new i(52, null));
                        }
                        AutoBang autoBang = roomExpandInfo.mAutoBang;
                        if (autoBang != null && autoBang.currentTime != 0 && autoBang.bangTime != 0) {
                            VideoPlayer.this.ecU().a(autoBang);
                        }
                        if (!h.isEmpty(roomExpandInfo.mRelatedRoomList) && VideoPlayer.this.nRW != null) {
                            VideoPlayer.this.nRW.t = roomExpandInfo.mRelatedRoomList;
                            if (VideoPlayer.this.nRU != null && VideoPlayer.this.H) {
                                VideoPlayer.this.nRU.w();
                            }
                        }
                        if (roomExpandInfo.mRoomNewUserInfo != null && roomExpandInfo.mRoomNewUserInfo.mBarrierNoviceGuide && !com.kascend.chushou.d.h.ecy().k() && VideoPlayer.this.nRU != null) {
                            VideoPlayer.this.nRU.J();
                        }
                        if (roomExpandInfo.mRoomNewUserInfo != null && roomExpandInfo.mRoomNewUserInfo.mRewardNoviceGuide && !com.kascend.chushou.d.h.ecy().l() && VideoPlayer.this.nRU != null) {
                            VideoPlayer.this.nRU.K();
                        }
                        if (!h.isEmpty(roomExpandInfo.mShopWindowInfos)) {
                            if (VideoPlayer.this.nRW != null) {
                                if (VideoPlayer.this.nRW.nTH == null) {
                                    VideoPlayer.this.nRW.nTH = new ArrayList();
                                }
                                VideoPlayer.this.nRW.nTH.addAll(roomExpandInfo.mShopWindowInfos);
                            }
                            if (VideoPlayer.this.nRU != null) {
                                VideoPlayer.this.nRU.L();
                            }
                        }
                        VideoPlayer.this.nSp.b = VideoPlayer.this.P;
                        if (roomExpandInfo.mPkNotifyInfo != null) {
                            VideoPlayer.this.nSp.nWR = roomExpandInfo.mPkNotifyInfo;
                            if (VideoPlayer.this.nRU != null) {
                                VideoPlayer.this.nRU.a(roomExpandInfo.mPkNotifyInfo, VideoPlayer.this.P);
                            }
                        } else {
                            VideoPlayer.this.nSp.nWR = null;
                        }
                        if (roomExpandInfo.mTrumpetPocket != null && VideoPlayer.this.nRW != null) {
                            VideoPlayer.this.nRW.nTI = roomExpandInfo.mTrumpetPocket;
                            if (VideoPlayer.this.nRU != null) {
                                VideoPlayer.this.nRU.M();
                            }
                        }
                        if (!h.isEmpty(roomExpandInfo.hotwordContentList)) {
                            if (VideoPlayer.this.nRW != null) {
                                if (VideoPlayer.this.nRW.w == null) {
                                    VideoPlayer.this.nRW.w = new ArrayList();
                                }
                                VideoPlayer.this.nRW.w.clear();
                                VideoPlayer.this.nRW.w.addAll(roomExpandInfo.hotwordContentList);
                            }
                            if (VideoPlayer.this.nRU != null) {
                                VideoPlayer.this.nRU.b(roomExpandInfo.hotwordContentList);
                            }
                        }
                        VideoPlayer.this.U();
                        return;
                    }
                    a(ew.mRc, ew.mMessage);
                }
            }

            @Override // com.kascend.chushou.c.b
            public void a(int i, String str) {
                tv.chushou.zues.utils.e.e(VideoPlayer.this.v, "get room gift popup list failed, rc =" + i + ", errorMsg=" + str);
            }
        }, this.ag, this.nSr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U() {
        if (!h.isEmpty(com.kascend.chushou.a.a.ecr().z)) {
            StringBuilder sb = new StringBuilder();
            if (com.kascend.chushou.a.a.ecr().z.contains(com.kascend.chushou.a.a.f)) {
                if (sb.length() > 0) {
                    sb.append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                sb.append(com.kascend.chushou.a.a.f);
            }
            if (com.kascend.chushou.a.a.ecr().z.contains(com.kascend.chushou.a.a.g)) {
                if (sb.length() > 0) {
                    sb.append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                sb.append(com.kascend.chushou.a.a.g);
            }
            if (com.kascend.chushou.a.a.ecr().z.contains(com.kascend.chushou.a.a.i)) {
                if (sb.length() > 0) {
                    sb.append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                sb.append(com.kascend.chushou.a.a.i);
            }
            if (com.kascend.chushou.a.a.ecr().z.contains(com.kascend.chushou.a.a.h)) {
                if (sb.length() > 0) {
                    sb.append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                sb.append(com.kascend.chushou.a.a.h);
            }
            if (com.kascend.chushou.a.a.ecr().z.contains(com.kascend.chushou.a.a.j)) {
                if (sb.length() > 0) {
                    sb.append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                sb.append(com.kascend.chushou.a.a.j);
            }
            if (com.kascend.chushou.a.a.ecr().z.contains(com.kascend.chushou.a.a.l)) {
                if (sb.length() > 0) {
                    sb.append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                sb.append(com.kascend.chushou.a.a.l);
            }
            if (com.kascend.chushou.a.a.ecr().z.contains(com.kascend.chushou.a.a.m)) {
                if (sb.length() > 0) {
                    sb.append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                sb.append(com.kascend.chushou.a.a.m);
            }
            if (sb.length() != 0) {
                com.kascend.chushou.a.a.ecr().a(sb.toString(), this.P, new a.c() { // from class: com.kascend.chushou.player.VideoPlayer.19
                    @Override // com.kascend.chushou.a.a.c
                    public void a(List<ListItem> list) {
                        if (VideoPlayer.this.nRW != null && list != null) {
                            int i = 0;
                            while (true) {
                                int i2 = i;
                                if (i2 >= list.size()) {
                                    break;
                                }
                                if (list.get(i2).mAdExtraInfo != null) {
                                    if (com.kascend.chushou.a.a.f.equals(list.get(i2).mAdExtraInfo.mCode)) {
                                        VideoPlayer.this.nRW.nTy = list.get(i2);
                                    } else if (com.kascend.chushou.a.a.g.equals(list.get(i2).mAdExtraInfo.mCode)) {
                                        VideoPlayer.this.nRW.nTx = list.get(i2);
                                    } else if (com.kascend.chushou.a.a.i.equals(list.get(i2).mAdExtraInfo.mCode)) {
                                        VideoPlayer.this.nRW.nTA = list.get(i2);
                                    } else if (com.kascend.chushou.a.a.h.equals(list.get(i2).mAdExtraInfo.mCode)) {
                                        VideoPlayer.this.nRW.nTB = list.get(i2);
                                    } else if (com.kascend.chushou.a.a.j.equals(list.get(i2).mAdExtraInfo.mCode)) {
                                        VideoPlayer.this.nRW.nTE = list.get(i2);
                                    } else if (com.kascend.chushou.a.a.l.equals(list.get(i2).mAdExtraInfo.mCode)) {
                                        VideoPlayer.this.nRW.nTC = list.get(i2);
                                    } else if (com.kascend.chushou.a.a.m.equals(list.get(i2).mAdExtraInfo.mCode)) {
                                        VideoPlayer.this.nRW.nTD = list.get(i2);
                                    }
                                }
                                i = i2 + 1;
                            }
                            if (VideoPlayer.this.nRU != null) {
                                VideoPlayer.this.nRU.H();
                            }
                        }
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str, String str2) {
        if (ecM()) {
            com.kascend.chushou.toolkit.a.a.a("type", "1", "value", str, "desc", str2, "videoId", this.P);
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
                this.nSb.setSystemUiVisibility(i);
                return;
            }
            this.nSb.setSystemUiVisibility(1792);
        }
    }

    public void f(boolean z) {
        Window window;
        View decorView;
        if (com.kascend.chushou.b.ecq().d != 1 && (window = getWindow()) != null && (decorView = window.getDecorView()) != null) {
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
        if (this.nRU != null) {
            this.nRU.a(i, i2, intent);
        }
    }

    public Uri ecN() {
        return this.nRP;
    }

    @Override // com.kascend.chushou.view.base.BaseActivity
    protected int y() {
        return 0;
    }

    public void yD(boolean z) {
        if (this.nSb != null) {
            this.nSb.oZL = z;
        }
    }

    public void ecO() {
        if (this.nSb != null) {
            this.nSb.ecO();
        }
    }

    public boolean ecP() {
        return this.ae;
    }

    public void g(boolean z) {
        this.ae = z;
    }

    public void h(boolean z) {
        if (this.nSb != null) {
            this.nSb.setIsTranslucentStatus(z);
        }
    }

    public void z() {
        if (this.nSb != null) {
            this.nSb.eqN();
        }
    }

    @Override // com.kascend.chushou.widget.gifts.RoomSendGiftView.a
    public void A() {
        if (this.nRZ != null) {
            this.nRZ.b();
        }
        if (this.nRW != null) {
            this.nRW.z = true;
        }
    }

    @Override // com.kascend.chushou.widget.gifts.RoomSendGiftView.a
    public void B() {
        if (this.nRZ != null) {
            this.nRZ.b();
        }
    }

    public void a(List<ListItem> list) {
        if (this.nRU != null) {
            this.nRU.a(list);
        }
    }

    public void a(IconConfig iconConfig, Map<String, SkinConfig.SkinRes> map) {
        if (this.nRU != null) {
            this.nRU.a(iconConfig, map);
        }
    }

    public void C() {
        if (this.nRU != null) {
            this.nRU.I();
        }
    }

    @Override // com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC0895a
    public void a(int i) {
        if (this.nRU != null) {
            this.nRU.a(i);
        }
    }

    @Override // com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC0895a
    public void D() {
        if (!isFinishing() && this.nRU != null) {
            this.nRU.D();
        }
    }

    @Override // com.kascend.chushou.player.ui.h5.b.b.a
    public void a(long j) {
        if (!isFinishing() && this.nRU != null) {
            this.nRU.a(j);
        }
    }

    @Override // com.kascend.chushou.player.ui.h5.b.b.a
    public void a(com.kascend.chushou.player.ui.h5.c.a aVar) {
        if (aVar != null && this.nRU != null) {
            this.nRU.a(aVar);
        }
    }

    @Override // com.kascend.chushou.player.ui.h5.b.b.a
    public void b(int i) {
        if (this.nRU != null) {
            this.nRU.b(i);
        }
    }

    @Override // com.kascend.chushou.player.ui.h5.d.a.InterfaceC0894a
    public void b(long j) {
        if (!isFinishing() && this.nRU != null) {
            this.nRU.b(j);
        }
    }

    @Override // com.kascend.chushou.player.ui.h5.a.a.InterfaceC0892a
    public void c(int i) {
        if (!isFinishing() && this.nRU != null) {
            this.nRU.c(i);
        }
    }

    @Override // com.kascend.chushou.player.ui.h5.d.a.InterfaceC0894a
    public void b(com.kascend.chushou.player.ui.h5.c.a aVar) {
        if (aVar != null && this.nRU != null) {
            this.nRU.b(aVar);
        }
    }

    @Override // com.kascend.chushou.player.ui.a.a.InterfaceC0889a
    public void a(IconConfig.Config config) {
        if (this.nRU != null) {
            this.nRU.a(config);
        }
    }

    @Override // com.kascend.chushou.player.ui.a.a.InterfaceC0889a
    public void a(BangInfo bangInfo, String str) {
        if (this.nRU != null) {
            this.nRU.a(bangInfo, str);
        }
    }

    @Override // com.kascend.chushou.player.ui.a.a.InterfaceC0889a
    public void a(long j, BangInfo bangInfo, String str) {
        if (this.nRU != null) {
            this.nRU.a(j, bangInfo, str);
        }
    }

    public com.kascend.chushou.player.ui.h5.redpacket.a ecQ() {
        return this.nSl;
    }

    public com.kascend.chushou.player.ui.h5.b.b ecR() {
        return this.nSm;
    }

    public com.kascend.chushou.player.ui.h5.d.a ecS() {
        return this.nSn;
    }

    public com.kascend.chushou.player.ui.h5.a.a ecT() {
        return this.nSq;
    }

    public com.kascend.chushou.player.ui.a.a ecU() {
        return this.nSo;
    }

    public com.kascend.chushou.player.e.a ecV() {
        return this.nSp;
    }

    @Override // com.kascend.chushou.view.base.BaseActivity, android.app.Activity
    public void finish() {
        super.finish();
        if ("3".equals(this.R)) {
            overridePendingTransition(17432576, a.C0879a.commonres_activity_exit_bottom);
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
        RxExecutor.postDelayed(this.nSt, EventThread.MAIN_THREAD, aVar.d, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.VideoPlayer.2
            @Override // java.lang.Runnable
            public void run() {
                if (VideoPlayer.this.nRU != null) {
                    VideoPlayer.this.nRU.c(aVar);
                }
            }
        });
    }

    private void e(final com.kascend.chushou.player.ui.h5.c.a aVar) {
        if (!com.kascend.chushou.d.h.ecy().ecB().contains(aVar.b)) {
            if (aVar.d < 0) {
                aVar.d = 0;
            }
            RxExecutor.postDelayed(this.nSt, EventThread.MAIN_THREAD, aVar.d, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.VideoPlayer.3
                @Override // java.lang.Runnable
                public void run() {
                    if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.nRU != null) {
                        VideoPlayer.this.nRU.c(aVar);
                    }
                }
            });
        }
    }

    private String ecW() {
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
            if (VideoReceiver.ACTION_VOLUME_CHANGED.equals(intent.getAction())) {
                if (VideoPlayer.this.nSa != null && !VideoPlayer.this.isFinishing()) {
                    VideoPlayer.n = VideoPlayer.this.nSa.getStreamVolume(3);
                }
                if (!VideoPlayer.this.isFinishing() && (VideoPlayer.this.nRU instanceof f)) {
                    ((f) VideoPlayer.this.nRU).ab();
                }
            }
        }
    }

    public String a(String str) {
        HashMap hashMap = new HashMap(tv.chushou.zues.utils.d.Xx(str));
        if ("1".equals(this.R)) {
            hashMap.put("roomId", this.P);
        } else if ("3".equals(this.R)) {
            hashMap.put("videoId", this.P);
        }
        return tv.chushou.zues.utils.d.toJson(hashMap);
    }

    public boolean ecX() {
        if (this.nRU instanceof com.kascend.chushou.player.d.a) {
            return ((com.kascend.chushou.player.d.a) this.nRU).edV();
        }
        if (this.nRU instanceof com.kascend.chushou.player.e.e) {
            return true;
        }
        return false;
    }
}

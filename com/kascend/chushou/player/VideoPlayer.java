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
public class VideoPlayer extends BaseActivity implements a.InterfaceC0892a, a.InterfaceC0895a, b.a, a.InterfaceC0897a, a.InterfaceC0898a, RoomSendGiftView.a {
    private static int A = 60000;
    public static String a = null;
    public static int n = 0;
    private String P;
    private String Q;
    private String R;
    private String S;
    private String ab;
    private String ag;
    private c nHY;
    private CSTVWifiReceiver nIA;
    b nIb;
    public PrivilegeInfo nIc;
    com.kascend.chushou.widget.a.b nIe;
    private KPSwitchRootRelativeLayout nIg;
    private FrameLayout nIh;
    private ImageView nIi;
    private LinearLayout nIj;
    private com.kascend.chushou.toolkit.d nIk;
    com.kascend.chushou.view.b.a.a nIl;
    private FrescoThumbnailView nIo;
    private FrameLayout nIp;
    public com.kascend.chushou.player.feedback.a nIx;
    private a nIz;
    private boolean B = true;
    private boolean C = false;
    private Uri nHU = null;
    private tv.chushou.common.player.a nHV = null;
    public tv.chushou.common.player.a nHW = null;
    public tv.chushou.common.player.a nHX = null;
    public boolean d = false;
    public boolean e = false;
    private e nHZ = null;
    private boolean H = false;
    private com.kascend.chushou.view.user.b nIa = null;
    private boolean J = false;
    private boolean K = false;
    private boolean L = false;
    private boolean M = false;
    private long N = 0;
    private int O = 0;
    public boolean g = false;
    private ImageView T = null;
    private TextView U = null;
    private AnimationImageView nId = null;
    private View bJf = null;
    public boolean j = false;
    public float k = 0.0f;
    public float l = 0.0f;
    public boolean m = false;
    public AudioManager nIf = null;
    private d.a nIm = new d.a() { // from class: com.kascend.chushou.player.VideoPlayer.1
        @Override // com.kascend.chushou.toolkit.d.a
        public void a() {
            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.nIB != null) {
                VideoPlayer.this.nIB.Ow(4);
            }
        }
    };
    private boolean ae = false;
    public boolean q = true;
    public long r = -1;
    public long s = -1;
    private PowerManager.WakeLock nIn = null;
    public String t = null;
    private final com.kascend.chushou.player.ui.h5.redpacket.a nIq = new com.kascend.chushou.player.ui.h5.redpacket.a(this);
    private final com.kascend.chushou.player.ui.h5.b.b nIr = new com.kascend.chushou.player.ui.h5.b.b(this);
    private final com.kascend.chushou.player.ui.h5.d.a nIs = new com.kascend.chushou.player.ui.h5.d.a(this);
    private final com.kascend.chushou.player.ui.a.a nIt = new com.kascend.chushou.player.ui.a.a(this);
    private final com.kascend.chushou.player.e.a nIu = new com.kascend.chushou.player.e.a();
    private final com.kascend.chushou.player.ui.h5.a.a nIv = new com.kascend.chushou.player.ui.h5.a.a(this);
    private String nIw = "1";
    private String aq = "2";
    private io.reactivex.disposables.a nIy = new io.reactivex.disposables.a();
    private tv.chushou.zues.c nIB = new tv.chushou.zues.c(new Handler.Callback() { // from class: com.kascend.chushou.player.VideoPlayer.6
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            try {
                if (!VideoPlayer.this.isFinishing()) {
                    switch (message.what) {
                        case 1:
                            VideoPlayer.this.nIB.removeMessages(1);
                            com.kascend.chushou.c.c.dYv().a(VideoPlayer.this.P, VideoPlayer.this.nIb != null ? VideoPlayer.this.nIb.h : null, System.currentTimeMillis());
                            VideoPlayer.this.nIB.B(1, VideoPlayer.A);
                            break;
                        case 2:
                            VideoPlayer.this.a(true, (Uri) null, false);
                            break;
                        case 3:
                            VideoPlayer.this.S();
                            break;
                        case 4:
                            if (VideoPlayer.this.nHZ != null) {
                                VideoPlayer.this.nHZ.a(true);
                            }
                            if (VideoPlayer.this.nIk != null) {
                                VideoPlayer.this.nIk.d();
                                VideoPlayer.this.nIk = null;
                                break;
                            }
                            break;
                        case 5:
                            int i = message.arg1;
                            if (i == 1) {
                                if (VideoPlayer.this.nHZ != null) {
                                    VideoPlayer.this.nHZ.p();
                                    break;
                                }
                            } else if (i == 2 && VideoPlayer.this.nHZ != null) {
                                VideoPlayer.this.nHZ.e(message.arg2);
                                break;
                            }
                            break;
                        case 6:
                            if (!com.kascend.chushou.b.dYs().a && !com.kascend.chushou.b.dYs().b && VideoPlayer.this.nHZ != null) {
                                VideoPlayer.this.nHZ.g(true);
                                break;
                            } else {
                                VideoPlayer.this.c();
                                break;
                            }
                            break;
                        case 7:
                            tv.chushou.zues.utils.e.d(VideoPlayer.this.v, "MSG_BUFFER_DEALY: ");
                            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.nHZ != null && VideoPlayer.this.M && !VideoPlayer.this.e) {
                                VideoPlayer.this.nHZ.h(true);
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
    private boolean nIC = false;
    private boolean aw = true;
    private boolean nID = false;
    private tv.chushou.common.player.b nIE = new tv.chushou.common.player.b() { // from class: com.kascend.chushou.player.VideoPlayer.14
        @Override // tv.chushou.common.player.b
        public void dZb() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerACallback onSetVideoViewLayout");
            if (!VideoPlayer.this.isFinishing()) {
                if ((VideoPlayer.this.nHZ == null || !VideoPlayer.this.nHZ.H) && VideoPlayer.this.nHZ != null && !VideoPlayer.this.d) {
                    VideoPlayer.this.nHZ.y();
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void Nb(int i) {
            if (!VideoPlayer.this.isFinishing()) {
                if ((VideoPlayer.this.nHZ == null || !VideoPlayer.this.nHZ.H) && VideoPlayer.this.nHZ != null && !VideoPlayer.this.d) {
                    VideoPlayer.this.nHZ.g(i);
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void dZc() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerACallback onCompletePlayback");
            if (!VideoPlayer.this.isFinishing()) {
                if (!h.isEmpty(VideoPlayer.this.P)) {
                    j.dYG().a(VideoPlayer.this.P, 0);
                }
                VideoPlayer.this.K = false;
                if (VideoPlayer.this.nIB != null) {
                    VideoPlayer.this.nIB.removeMessages(1);
                }
                if ((VideoPlayer.this.nHZ == null || !VideoPlayer.this.nHZ.H) && VideoPlayer.this.nHZ != null && !VideoPlayer.this.d) {
                    VideoPlayer.this.nIB.removeMessages(7);
                    VideoPlayer.this.M = false;
                    VideoPlayer.this.nHZ.z();
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void dZd() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerACallback onVideoRenderingStart");
            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.nHZ != null) {
                VideoPlayer.this.nHZ.G();
            }
        }

        @Override // tv.chushou.common.player.b
        public void dZe() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerACallback onPreparedPlayback");
            if (!VideoPlayer.this.isFinishing()) {
                if (VideoPlayer.this.nHZ == null || !VideoPlayer.this.nHZ.H) {
                    VideoPlayer.this.nIB.removeMessages(6);
                    VideoPlayer.this.N = 0L;
                    VideoPlayer.this.O = 0;
                    if (VideoPlayer.this.nHV != null && VideoPlayer.this.nHZ != null) {
                        VideoPlayer.this.nHV.setVolume(VideoPlayer.this.nHZ.J, VideoPlayer.this.nHZ.J);
                    }
                    if (VideoPlayer.this.nIb != null) {
                        VideoPlayer.this.K = false;
                        FullRoomInfo dZl = VideoPlayer.this.dYO() ? null : VideoPlayer.this.nIb.dZl();
                        if (VideoPlayer.this.L || dZl != null) {
                            if (VideoPlayer.this.nIb.e) {
                                VideoPlayer.this.nIb.e = false;
                                VideoPlayer.this.nIb.d = !VideoPlayer.this.nIb.d;
                            }
                            if (VideoPlayer.this.nHZ != null) {
                                VideoPlayer.this.c("1", (String) null);
                                if (!VideoPlayer.this.d) {
                                    VideoPlayer.this.nHZ.i(true);
                                } else if (VideoPlayer.this.e) {
                                    VideoPlayer.this.e = false;
                                    VideoPlayer.this.nHZ.B();
                                }
                            }
                        }
                    }
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void Nc(int i) {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerACallback onErrorAppeared");
            if (!VideoPlayer.this.isFinishing()) {
                VideoPlayer.this.c();
                VideoPlayer.this.K = false;
                if (VideoPlayer.this.nIB != null) {
                    VideoPlayer.this.nIB.removeMessages(7);
                }
                if (VideoPlayer.this.nIB != null) {
                    VideoPlayer.this.nIB.removeMessages(1);
                }
                if ((VideoPlayer.this.nHZ == null || !VideoPlayer.this.nHZ.H) && !VideoPlayer.this.dYI()) {
                    if (!"10004".equals(VideoPlayer.this.t)) {
                        if (VideoPlayer.this.nHZ != null) {
                            if (VideoPlayer.this.d) {
                                VideoPlayer.this.nHW.stop();
                                VideoPlayer.this.nHW.release();
                                VideoPlayer.this.e = false;
                                VideoPlayer.this.nHZ.C();
                            }
                            if (!com.kascend.chushou.b.dYs().a && !com.kascend.chushou.b.dYs().b) {
                                VideoPlayer.this.nHZ.g(true);
                            } else if (VideoPlayer.this.d) {
                                VideoPlayer.this.nHZ.a(i, true);
                            } else {
                                VideoPlayer.this.nHZ.a(i, false);
                            }
                            VideoPlayer.this.c("2", (String) null);
                            return;
                        }
                        return;
                    }
                    dZc();
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void dZf() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerACallback onBufferingStart");
            if (!VideoPlayer.this.isFinishing()) {
                if ((VideoPlayer.this.nHZ == null || !VideoPlayer.this.nHZ.H) && VideoPlayer.this.nHZ != null && !VideoPlayer.this.d) {
                    VideoPlayer.this.nHZ.E();
                    VideoPlayer.this.M = true;
                    long currentTimeMillis = System.currentTimeMillis();
                    VideoPlayer.this.nIB.removeMessages(7);
                    if (!VideoPlayer.this.g) {
                        VideoPlayer.y(VideoPlayer.this);
                    }
                    tv.chushou.zues.utils.e.d(VideoPlayer.this.v, "currentTime: -- >" + currentTimeMillis + "  bufferTime-->" + VideoPlayer.this.N + "  bufferCount-->" + VideoPlayer.this.O);
                    if (currentTimeMillis - VideoPlayer.this.N >= 20000 || VideoPlayer.this.O < 2 || VideoPlayer.this.nHZ.H) {
                        if (VideoPlayer.this.O == 1) {
                            VideoPlayer.this.N = currentTimeMillis;
                        }
                        VideoPlayer.this.nIB.B(7, 5000L);
                    } else {
                        VideoPlayer.this.nIB.Ow(7);
                    }
                    if (VideoPlayer.this.g) {
                        VideoPlayer.this.g = false;
                    }
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void dZg() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerACallback onBufferingEnd");
            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.nHZ != null && !VideoPlayer.this.d) {
                VideoPlayer.this.nIB.removeMessages(7);
                VideoPlayer.this.M = false;
                if (VideoPlayer.this.nHZ == null || !VideoPlayer.this.nHZ.H) {
                    if (VideoPlayer.this.nHV == null) {
                        VideoPlayer.this.nHZ.a(false, true, false);
                    } else {
                        VideoPlayer.this.nHZ.a(true, VideoPlayer.this.nHV.getPlayState() == 4, VideoPlayer.this.nHV.getPlayState() == 5);
                    }
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void onPlayerStart() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerACallback onPlayerStart");
            if (!VideoPlayer.this.isFinishing()) {
                if (VideoPlayer.this.nHZ == null || !VideoPlayer.this.nHZ.H) {
                    if (VideoPlayer.this.nHZ != null && !VideoPlayer.this.d) {
                        if (VideoPlayer.this.nHV != null) {
                            VideoPlayer.this.nHZ.F();
                            VideoPlayer.this.nHZ.a(true, VideoPlayer.this.nHV.getPlayState() == 4, VideoPlayer.this.nHV.getPlayState() == 5);
                        } else {
                            VideoPlayer.this.nHZ.a(false, true, false);
                        }
                    }
                    if (VideoPlayer.this.nIB != null && !VideoPlayer.this.dYO()) {
                        VideoPlayer.this.nIB.removeMessages(1);
                        VideoPlayer.this.nIB.B(1, VideoPlayer.A);
                    }
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void dZh() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerACallback onPlayerPause");
            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.nIB != null) {
                VideoPlayer.this.nIB.removeMessages(1);
            }
        }

        @Override // tv.chushou.common.player.b
        public void dZi() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerACallback onPlayerStop");
            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.dYO() && VideoPlayer.this.nHW != null && !h.isEmpty(VideoPlayer.this.P) && VideoPlayer.this.nHW.getCurrentPos() > 0) {
                j.dYG().a(VideoPlayer.this.P, VideoPlayer.this.nHW.getCurrentPos());
            }
        }
    };
    private tv.chushou.common.player.b nIF = new tv.chushou.common.player.b() { // from class: com.kascend.chushou.player.VideoPlayer.15
        @Override // tv.chushou.common.player.b
        public void dZb() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerBCallback onSetVideoViewLayout");
            if (!VideoPlayer.this.isFinishing()) {
                if ((VideoPlayer.this.nHZ == null || !VideoPlayer.this.nHZ.H) && VideoPlayer.this.nHZ != null && VideoPlayer.this.d) {
                    VideoPlayer.this.nHZ.y();
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void Nb(int i) {
            if (!VideoPlayer.this.isFinishing()) {
                if ((VideoPlayer.this.nHZ == null || !VideoPlayer.this.nHZ.H) && VideoPlayer.this.nHZ != null && VideoPlayer.this.d) {
                    VideoPlayer.this.nHZ.g(i);
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void dZc() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerBCallback onCompletePlayback");
            if (!VideoPlayer.this.isFinishing()) {
                if (!h.isEmpty(VideoPlayer.this.P)) {
                    j.dYG().a(VideoPlayer.this.P, 0);
                }
                VideoPlayer.this.K = false;
                if (VideoPlayer.this.nIB != null) {
                    VideoPlayer.this.nIB.removeMessages(1);
                }
                if ((VideoPlayer.this.nHZ == null || !VideoPlayer.this.nHZ.H) && VideoPlayer.this.nHZ != null && VideoPlayer.this.d) {
                    VideoPlayer.this.nIB.removeMessages(7);
                    VideoPlayer.this.M = false;
                    VideoPlayer.this.nHZ.z();
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void dZd() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerBCallback onVideoRenderingStart");
            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.nHZ != null) {
                VideoPlayer.this.nHZ.G();
            }
        }

        @Override // tv.chushou.common.player.b
        public void dZe() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerBCallback onPreparedPlayback");
            if (!VideoPlayer.this.isFinishing()) {
                if (VideoPlayer.this.nHZ == null || !VideoPlayer.this.nHZ.H) {
                    VideoPlayer.this.nIB.removeMessages(6);
                    VideoPlayer.this.N = 0L;
                    VideoPlayer.this.O = 0;
                    if (VideoPlayer.this.nHV != null && VideoPlayer.this.nHZ != null) {
                        VideoPlayer.this.nHV.setVolume(VideoPlayer.this.nHZ.J, VideoPlayer.this.nHZ.J);
                    }
                    if (VideoPlayer.this.nIb != null) {
                        VideoPlayer.this.K = false;
                        FullRoomInfo dZl = VideoPlayer.this.dYO() ? null : VideoPlayer.this.nIb.dZl();
                        if (VideoPlayer.this.L || dZl != null) {
                            if (VideoPlayer.this.nIb.e) {
                                VideoPlayer.this.nIb.e = false;
                                VideoPlayer.this.nIb.d = !VideoPlayer.this.nIb.d;
                            }
                            if (VideoPlayer.this.nHZ != null) {
                                VideoPlayer.this.c("1", (String) null);
                                if (VideoPlayer.this.d) {
                                    VideoPlayer.this.nHZ.i(true);
                                } else if (VideoPlayer.this.e) {
                                    VideoPlayer.this.e = false;
                                    VideoPlayer.this.nHZ.B();
                                }
                            }
                        }
                    }
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void Nc(int i) {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerBCallback onErrorAppeared");
            if (!VideoPlayer.this.isFinishing()) {
                VideoPlayer.this.c();
                VideoPlayer.this.K = false;
                if (VideoPlayer.this.nIB != null) {
                    VideoPlayer.this.nIB.removeMessages(7);
                }
                if (VideoPlayer.this.nIB != null) {
                    VideoPlayer.this.nIB.removeMessages(1);
                }
                if ((VideoPlayer.this.nHZ == null || !VideoPlayer.this.nHZ.H) && !VideoPlayer.this.dYI()) {
                    if (!"10004".equals(VideoPlayer.this.t)) {
                        if (VideoPlayer.this.nHZ != null) {
                            if (!VideoPlayer.this.d) {
                                VideoPlayer.this.nHX.stop();
                                VideoPlayer.this.nHX.release();
                                VideoPlayer.this.nHZ.C();
                                VideoPlayer.this.e = false;
                            }
                            if (!com.kascend.chushou.b.dYs().a && !com.kascend.chushou.b.dYs().b) {
                                VideoPlayer.this.nHZ.g(true);
                            } else if (VideoPlayer.this.d) {
                                VideoPlayer.this.nHZ.a(i, false);
                            } else {
                                VideoPlayer.this.nHZ.a(i, true);
                            }
                            VideoPlayer.this.c("2", (String) null);
                            return;
                        }
                        return;
                    }
                    dZc();
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void dZf() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerBCallback onBufferingStart");
            if (!VideoPlayer.this.isFinishing()) {
                if ((VideoPlayer.this.nHZ == null || !VideoPlayer.this.nHZ.H) && VideoPlayer.this.nHZ != null && VideoPlayer.this.d) {
                    VideoPlayer.this.nHZ.E();
                    VideoPlayer.this.M = true;
                    VideoPlayer.this.nIB.removeMessages(7);
                    long currentTimeMillis = System.currentTimeMillis();
                    if (!VideoPlayer.this.g) {
                        VideoPlayer.y(VideoPlayer.this);
                    }
                    tv.chushou.zues.utils.e.d(VideoPlayer.this.v, "currentTime: -- >" + currentTimeMillis + "  bufferTime-->" + VideoPlayer.this.N + "  bufferCount-->" + VideoPlayer.this.O);
                    if (currentTimeMillis - VideoPlayer.this.N >= 20000 || VideoPlayer.this.O < 2 || VideoPlayer.this.nHZ.H) {
                        if (VideoPlayer.this.O == 1) {
                            VideoPlayer.this.N = currentTimeMillis;
                        }
                        VideoPlayer.this.nIB.B(7, 5000L);
                    } else {
                        VideoPlayer.this.N = 0L;
                        VideoPlayer.this.O = 0;
                        VideoPlayer.this.nIB.Ow(7);
                    }
                    if (VideoPlayer.this.g) {
                        VideoPlayer.this.g = false;
                    }
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void dZg() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerBCallback onBufferingEnd");
            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.nHZ != null && VideoPlayer.this.d) {
                VideoPlayer.this.M = false;
                VideoPlayer.this.nIB.removeMessages(7);
                if (VideoPlayer.this.nHZ == null || !VideoPlayer.this.nHZ.H) {
                    if (VideoPlayer.this.nHV == null) {
                        VideoPlayer.this.nHZ.a(false, true, false);
                    } else {
                        VideoPlayer.this.nHZ.a(true, VideoPlayer.this.nHV.getPlayState() == 4, VideoPlayer.this.nHV.getPlayState() == 5);
                    }
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void onPlayerStart() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerBCallback onPlayerStart");
            if (!VideoPlayer.this.isFinishing()) {
                if (VideoPlayer.this.nHZ == null || !VideoPlayer.this.nHZ.H) {
                    if (VideoPlayer.this.nHZ != null && VideoPlayer.this.d) {
                        if (VideoPlayer.this.nHV != null) {
                            VideoPlayer.this.nHZ.F();
                            VideoPlayer.this.nHZ.a(true, VideoPlayer.this.nHV.getPlayState() == 4, VideoPlayer.this.nHV.getPlayState() == 5);
                        } else {
                            VideoPlayer.this.nHZ.a(false, true, false);
                        }
                    }
                    if (VideoPlayer.this.nIB != null && !VideoPlayer.this.dYO()) {
                        VideoPlayer.this.nIB.removeMessages(1);
                        VideoPlayer.this.nIB.B(1, VideoPlayer.A);
                    }
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void dZh() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerBCallback onPlayerPause");
            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.nIB != null) {
                VideoPlayer.this.nIB.removeMessages(1);
            }
        }

        @Override // tv.chushou.common.player.b
        public void dZi() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerBCallback onPlayerStop");
            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.dYO() && VideoPlayer.this.nHX != null && !h.isEmpty(VideoPlayer.this.P) && VideoPlayer.this.nHX.getCurrentPos() > 0) {
                j.dYG().a(VideoPlayer.this.P, VideoPlayer.this.nHX.getCurrentPos());
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
        this.nHU = intent.getData();
        if (this.nHU == null) {
            finish();
            return;
        }
        com.kascend.chushou.d.e.j();
        if (this.nIA == null) {
            this.nIA = new CSTVWifiReceiver();
            registerReceiver(this.nIA, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        }
        com.kascend.chushou.toolkit.d.a.eaI().b();
        tv.chushou.zues.utils.e.i(this.v, "intent.getData=" + this.nHU.toString());
        String scheme = this.nHU.getScheme();
        if (scheme == null || !scheme.equals("chushou")) {
            tv.chushou.zues.utils.e.e(this.v, "not support scheme :" + scheme);
            finish();
            return;
        }
        a(intent);
    }

    private void a(Intent intent) {
        this.P = this.nHU.getQueryParameter("roomId");
        this.Q = this.P;
        this.S = this.nHU.getQueryParameter(WebSocketRequest.PARAM_KEY_PROTOCOLS);
        this.aq = this.nHU.getQueryParameter("liveType");
        if ("2".equals(this.aq) || "3".equals(this.aq) || "4".equals(this.aq)) {
            this.nIw = "2";
            this.nIx = new com.kascend.chushou.player.feedback.a();
            if (this.nIx.nQM != null) {
                this.nIx.nQM.reset();
                this.nIx.nQM.roomId = this.P;
                this.nIx.nQM.enterType = 1;
                this.nIx.b = System.currentTimeMillis();
            }
        }
        if (h.isEmpty(this.P) || h.isEmpty(this.S)) {
            tv.chushou.zues.utils.e.e(this.v, "invalid param mItemID=" + this.P + " protocols=" + this.S);
            finish();
            return;
        }
        if (com.kascend.chushou.b.dYs().d == -1) {
            com.kascend.chushou.b.dYs().d = com.kascend.chushou.d.g.b() ? 1 : 0;
        }
        this.nIn = ((PowerManager) getSystemService("power")).newWakeLock(536870938, this.v);
        this.nIn.acquire();
        this.nIb = new b(this.P);
        this.nIb.d = intent.getBooleanExtra("room_play_audio", false);
        this.nIe = new com.kascend.chushou.widget.a.b();
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
        this.nIg = (KPSwitchRootRelativeLayout) findViewById(a.f.rlRoot);
        if (!"2".equals(this.nIw) && com.kascend.chushou.b.dYs().d == 1) {
            this.nIg.setFitsSystemWindows(true);
        }
        this.nIh = (FrameLayout) this.nIg.findViewById(a.f.fl_fragment);
        this.bJf = this.nIg.findViewById(a.f.rl_empty);
        this.T = (ImageView) this.bJf.findViewById(a.f.iv_empty);
        this.U = (TextView) this.bJf.findViewById(a.f.tv_empty);
        this.nIj = (LinearLayout) this.nIg.findViewById(a.f.rl_title);
        this.nIi = (ImageView) this.nIj.findViewById(a.f.back_icon);
        this.nIi.setOnClickListener(new View.OnClickListener() { // from class: com.kascend.chushou.player.VideoPlayer.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayer.this.finish();
            }
        });
        this.nId = (AnimationImageView) this.bJf.findViewById(a.f.iv_loading);
        this.nIo = (FrescoThumbnailView) this.nIg.findViewById(a.f.live_cover);
        this.nIp = (FrameLayout) this.nIg.findViewById(a.f.fl_cover);
        this.k = dYH();
        try {
            this.nIf = (AudioManager) getApplicationContext().getSystemService("audio");
            n = this.nIf.getStreamVolume(3);
            this.nIf.requestAudioFocus(null, 3, 1);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (this.B) {
            a(1, dYO() ? "3" : "1");
        } else {
            r();
        }
        if (com.kascend.chushou.b.dYs().b && !com.kascend.chushou.b.dYs().a) {
            RxExecutor.postDelayed(this.nIy, EventThread.MAIN_THREAD, 60L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.VideoPlayer.5
                @Override // java.lang.Runnable
                public void run() {
                    if (!VideoPlayer.this.isFinishing() && com.kascend.chushou.b.dYs().b && !com.kascend.chushou.b.dYs().a) {
                        tv.chushou.zues.utils.g.c(VideoPlayer.this.w, VideoPlayer.this.getString(a.i.str_monet_notify));
                    }
                }
            });
        }
        com.kascend.chushou.c.c.dYv().a(this.P, stringExtra, System.currentTimeMillis());
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
        if (this.nIz == null) {
            this.nIz = new a();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(VideoReceiver.ACTION_VOLUME_CHANGED);
            registerReceiver(this.nIz, intentFilter);
        }
    }

    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        j(false);
        if (this.nIz != null) {
            unregisterReceiver(this.nIz);
            this.nIz = null;
        }
        super.onStop();
    }

    @Override // com.kascend.chushou.view.base.BaseActivity
    protected void a(boolean z) {
        if (this.nHZ != null) {
            this.nHZ.k(z);
        }
    }

    @Subscribe
    public void onHideGiftEffectEvent(com.kascend.chushou.b.a.a.f fVar) {
        if (fVar.b) {
            this.nHZ.k();
            return;
        }
        this.nHZ.m();
        this.nHZ.l();
    }

    private float dYH() {
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
            this.nIb.h = jSONObject.toString();
            String optString = jSONObject.optString("_thumb");
            jSONObject.optBoolean("tag_from_game_mic", false);
            if (!h.isEmpty(optString)) {
                this.ab = optString;
            }
        } catch (JSONException e) {
            e.printStackTrace();
            this.nIb.h = str;
        }
        if (dYO()) {
            a(this.P, str);
            bb(this.P, z);
            return;
        }
        a = this.P;
        b(this.P, str);
        a(this.P, dYY(), z);
        w();
    }

    private void O() {
        this.m = true;
        j();
        if (this.nHZ != null) {
            this.nHZ.r();
        }
        s();
    }

    @Subscribe
    public void onStartRoomEvent(o oVar) {
        if (!isFinishing() && oVar.nHC != null && oVar.c != null && !h.isEmpty(oVar.nHC.mTargetKey)) {
            if (oVar.c != this) {
                tv.chushou.zues.utils.e.e(this.v, "different player!");
                return;
            }
            if (this.nIb != null) {
                this.nIb.a();
                this.nIb.a = oVar.nHC.mTargetKey;
                this.nIb.d = oVar.d;
                if (this.nIb.nJA != null) {
                    this.nIb.nJA.e();
                }
                if (this.nIb.nJA != null) {
                    this.nIb.nJA.b();
                }
                this.nIb.nJD = null;
                this.nIb.nJC = null;
                this.nIb.nJG = null;
                this.nIb.nJF = null;
                this.nIb.nJJ = null;
                this.nIb.nJH = null;
                this.nIb.nJI = null;
            }
            if (this.nIf != null) {
                n = this.nIf.getStreamVolume(3);
            }
            if (!h.isEmpty(oVar.nHC.mType) && oVar.nHC.mType.equals("3")) {
                this.B = false;
                this.nIw = "1";
                r();
                this.P = oVar.nHC.mTargetKey;
                this.R = "3";
                if (this.nIe != null) {
                    this.nIe.a();
                }
                if (this.nIb != null) {
                    this.nIb.a((PlayUrl) null);
                    this.nIb.f();
                    if (this.nIb.c() != null) {
                        this.nIb.c().clear();
                    }
                    this.nIb.i.clear();
                }
                if (this.nHZ != null) {
                    this.nHZ.j();
                }
                s();
                if (this.nIk != null) {
                    this.nIk.d();
                    this.nIk = null;
                }
                if (this.nIy != null) {
                    this.nIy.dispose();
                    this.nIy = new io.reactivex.disposables.a();
                }
                a(oVar.e, false);
                return;
            }
            boolean z = this.R != null && this.R.equals("1");
            this.R = "1";
            this.nIt.a();
            this.nIs.a();
            this.nIr.a();
            this.nIq.c();
            this.nIv.a();
            if (this.nIy != null) {
                this.nIy.dispose();
                this.nIy = new io.reactivex.disposables.a();
            }
            if ("1".equals(oVar.f)) {
                this.H = false;
                if (this.nIb != null && !h.isEmpty(this.nIb.t)) {
                    this.nIb.t.clear();
                }
                this.ab = oVar.nHC.mCover;
                this.nIp.setVisibility(0);
                this.nIo.setBlur(true);
                this.nIo.i(oVar.nHC.mCover, 0, 0, 0);
            }
            if (!oVar.nHC.mTargetKey.equals(this.P)) {
                this.aq = oVar.g;
                if (!z) {
                    this.B = false;
                    r();
                } else if (!"2".equals(this.nIw) && ("2".equals(this.aq) || "3".equals(this.aq) || "4".equals(this.aq))) {
                    this.nIw = "2";
                    this.nIx = new com.kascend.chushou.player.feedback.a();
                    if (this.nIx.nQM != null) {
                        this.nIx.nQM.reset();
                        this.nIx.nQM.roomId = oVar.nHC.mTargetKey;
                        this.nIx.nQM.enterType = 1;
                        this.nIx.b = System.currentTimeMillis();
                    }
                }
                this.B = false;
                this.P = oVar.nHC.mTargetKey;
                this.Q = this.P;
                this.ab = oVar.nHC.mCover;
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
                JSONObject O = com.kascend.chushou.d.e.O("_fromView", str, "_sc", oVar.nHC.mSC);
                com.kascend.chushou.toolkit.a.c.a(this.w, O);
                if (this.nIe != null) {
                    this.nIe.a();
                    this.nIe.a(this.P);
                }
                if (this.nIb != null) {
                    this.nIb.a((PlayUrl) null);
                    this.nIb.f();
                    if (this.nIb.c() != null) {
                        this.nIb.c().clear();
                    }
                    this.nIb.i.clear();
                }
                if (this.nHZ != null) {
                    this.nHZ.j();
                }
                a(O.toString(), false);
                return;
            }
            tv.chushou.zues.utils.g.OF(a.i.str_same_room);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dYI() {
        FullRoomInfo dZl;
        String str;
        RoomInfo roomInfo;
        if (dYO()) {
            str = null;
            dZl = null;
        } else {
            dZl = this.nIb.dZl();
            str = (dZl == null || (roomInfo = dZl.mRoominfo) == null) ? null : roomInfo.mGameId;
        }
        return !this.L && (dZl == null || h.isEmpty(str));
    }

    @Subscribe
    public void onMessageEvent(i iVar) {
        if (!isFinishing() && iVar.a != 21 && iVar.a != 22) {
            if (iVar.a == 0 && (iVar.b instanceof Boolean)) {
                if (((Boolean) iVar.b).booleanValue() && !isFinishing()) {
                    w();
                    if (this.nHZ != null) {
                        this.nHZ.f();
                    }
                }
            } else if (iVar.a == 46) {
                if ((iVar.b instanceof String) && this.nHZ != null) {
                    this.nHZ.c((String) iVar.b);
                }
            } else if (iVar.a == 54) {
                if (iVar.b instanceof String) {
                    this.nIr.a((String) iVar.b);
                }
            } else if (iVar.a == 55) {
                if (this.nHZ != null) {
                    this.nHZ.O();
                }
            } else if (iVar.a == 56 && this.nHZ != null) {
                this.nHZ.P();
            }
        }
    }

    @Subscribe
    public void onRefreshSubscribeEvent(m mVar) {
        if (isFinishing() && this.nIb != null && this.nIb.dZn() != null) {
            RoomInfo dZn = this.nIb.dZn();
            if (mVar.a(dZn.mCreatorUID, dZn.mRoomID)) {
                dZn.mIsSubscribed = mVar.c;
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
        if (this.m || this.nHW == null || this.nHX == null) {
            R();
        }
        if (this.nIe != null) {
            this.nIe.d();
        }
        if (!dYO()) {
            if (this.nIk != null && !this.nIk.c()) {
                this.nIk.a();
            }
            v();
            if (this.nIb != null && this.nIb.dZl() != null && this.nIb.dZl().cycleLiveRoomInfo != null && !h.isEmpty(this.nIb.dZl().cycleLiveRoomInfo.roomId)) {
                u();
            }
        }
        super.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.view.base.BaseActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        tv.chushou.zues.utils.e.e(this.v, MissionEvent.MESSAGE_DESTROY);
        if (this.nIb != null && this.nIb.dZl() != null && this.nIb.dZl().cycleLiveRoomInfo != null && !h.isEmpty(this.nIb.dZl().cycleLiveRoomInfo.eventName)) {
            j.dYG().a(this.P + dYY());
        }
        if ("2".equals(this.nIw) && this.nIx != null && this.nIx.nQM != null) {
            this.nIx.nQM.time = System.currentTimeMillis() - this.nIx.b;
            this.nIx.a();
            this.nIx.b();
        }
        this.nIq.d();
        this.nIr.b();
        this.nIs.b();
        O();
        this.ag = null;
        a = null;
        if (this.nIB != null) {
            this.nIB.cl(null);
            this.nIB = null;
        }
        if (this.nIk != null) {
            this.nIk.d();
            this.nIk = null;
        }
        if (this.nIe != null) {
            this.nIe.c();
            this.nIe = null;
        }
        if (this.nIb != null) {
            this.nIb.nJD = null;
            this.nIb.nJC = null;
        }
        if (this.nIb != null) {
            this.nIb.b();
            this.nIb = null;
        }
        this.nHU = null;
        this.nHZ = null;
        this.nIa = null;
        this.nIc = null;
        this.T = null;
        this.U = null;
        this.nId = null;
        this.bJf = null;
        this.nIf = null;
        this.nIg = null;
        this.nIh = null;
        this.nIi = null;
        this.nIj = null;
        if (this.nIn != null && this.nIn.isHeld()) {
            this.nIn.release();
            this.nIn = null;
        }
        if (this.nIA != null) {
            unregisterReceiver(this.nIA);
            this.nIA = null;
        }
        h.emw();
        tv.chushou.zues.a.a.cm(this);
        this.nIy.dispose();
        this.nIs.b();
        this.nIt.b();
        this.nIq.d();
        this.nIr.b();
        this.nIv.b();
        super.onDestroy();
        System.gc();
    }

    @Subscribe
    public void onSendGameGiftEvent(n nVar) {
        if (!isFinishing() && this.nHZ != null) {
            this.nHZ.a(nVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.view.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        tv.chushou.zues.utils.e.d(this.v, MissionEvent.MESSAGE_PAUSE);
        if (this.nIk != null) {
            this.nIk.b();
        }
        if (this.nIe != null) {
            this.nIe.b(false);
        }
        k();
        this.m = true;
        super.onPause();
    }

    @Override // android.app.Activity
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.nHZ != null ? this.nHZ.a(motionEvent) : super.onTouchEvent(motionEvent);
    }

    public void c() {
        if ("1".equals(this.R)) {
            j.dYG().a(this.P + dYY());
        } else {
            j.dYG().b(this.P);
        }
    }

    private void a(boolean z, boolean z2) {
        int i = 0;
        tv.chushou.zues.utils.e.i(this.v, "startLoadingVideo <------------- mbPrepareingVideo = " + this.K);
        if (this.nHW != null) {
            this.nHW.setHardwearDecod(com.kascend.chushou.d.h.dYA().a);
        }
        if (this.nHX != null) {
            this.nHX.setHardwearDecod(com.kascend.chushou.d.h.dYA().a);
        }
        if (this.nHV != null) {
            this.nHV.setHardwearDecod(com.kascend.chushou.d.h.dYA().a);
        }
        if (!this.K) {
            if (z && this.nHZ != null) {
                if (!z2) {
                    this.t = null;
                    this.nHZ.e();
                }
            } else if (this.nHZ != null && !z2) {
                this.t = null;
                this.nHZ.H = false;
                RxExecutor.post(null, EventThread.MAIN_THREAD, new Runnable() { // from class: com.kascend.chushou.player.VideoPlayer.7
                    @Override // java.lang.Runnable
                    public void run() {
                        VideoPlayer.this.nHZ.x();
                    }
                });
            }
            this.K = true;
            if (this.nIb != null && this.nIb.dZm() != null) {
                PlayUrl dZm = this.nIb.dZm();
                while (true) {
                    int i2 = i;
                    if (i2 >= dZm.mUrlDetails.size()) {
                        break;
                    }
                    UrlDetails urlDetails = dZm.mUrlDetails.get(i2);
                    if (urlDetails.mUrl.equals(dZm.mSelectedUrl)) {
                        String str = dZm.mUrlDetails.get(i2).mDefinitionType;
                        String str2 = urlDetails.mBitrate;
                    }
                    i = i2 + 1;
                }
            }
            if (z2) {
                if (this.d) {
                    this.nHW.setVideoURI(this.nHU);
                    this.nHW.open();
                    return;
                }
                this.nHX.setVideoURI(this.nHU);
                this.nHX.open();
                return;
            }
            this.nHV.setVideoURI(this.nHU);
            this.nHV.open();
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        try {
            if (motionEvent.getAction() == 0) {
                if (this.nHZ != null && this.nHZ.b(motionEvent)) {
                    return true;
                }
                if ("2".equals(this.nIw) && this.nHZ != null) {
                    this.nHZ.a(motionEvent);
                }
            } else if (this.nHZ != null && this.nHZ.b(motionEvent)) {
                return true;
            }
            return super.dispatchTouchEvent(motionEvent);
        } catch (Exception e) {
            return false;
        }
    }

    @Override // android.support.v7.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.nHZ != null && this.nHZ.a(i, keyEvent)) {
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
        if (this.nIb != null && this.nIb.dZl() != null && this.nIb.dZl().cycleLiveRoomInfo != null && !h.isEmpty(this.nIb.dZl().cycleLiveRoomInfo.roomId)) {
            this.nIp.setVisibility(0);
            this.nIo.setBlur(true);
            this.nIo.i(this.nIb.dZl().cycleLiveRoomInfo.avatar, 0, 0, 0);
            this.nIo.setVisibility(0);
            j.dYG().a(this.P + dYY());
            this.nHU = null;
            R();
            this.Q = this.nIb.dZl().cycleLiveRoomInfo.roomId;
            a(this.P, dYY(), false);
        }
    }

    public void b(boolean z) {
        if (this.nHZ != null) {
            this.nHZ.j(z);
        }
    }

    public void a(boolean z, Uri uri, boolean z2) {
        tv.chushou.zues.utils.e.d(this.v, "loadIfNecessary reload=" + z + " isChangeLines-->" + z2);
        if (this.nHW != null && this.nHX != null) {
            if (uri != null) {
                this.nHU = uri;
            }
            if (z2) {
                this.e = z2;
            }
            this.M = false;
            this.N = 0L;
            this.O = 0;
            this.nIB.removeMessages(7);
            if (z) {
                if (z2) {
                    if (!this.d) {
                        this.nHX.setOnActivityCallBack(this.nIF);
                    } else {
                        this.nHW.setOnActivityCallBack(this.nIE);
                    }
                } else if (this.d) {
                    this.nHX.setOnActivityCallBack(this.nIF);
                } else {
                    this.nHW.setOnActivityCallBack(this.nIE);
                }
                this.K = false;
                b(true, z2);
            } else if (!this.J) {
                b(true, z2);
            }
            this.nIB.B(6, IMConnection.RETRY_DELAY_TIMES);
        }
    }

    private void b(boolean z, boolean z2) {
        VideoPlayInfo N;
        if ("1".equals(this.R)) {
            N = j.dYG().M(this.P + dYY(), 600000L);
        } else {
            N = j.dYG().N(this.P, 600000L);
        }
        if (N != null) {
            a(z, z2);
        } else if ("1".equals(this.R)) {
            a(this.P, dYY(), false);
        } else {
            bb(this.P, false);
        }
    }

    public tv.chushou.common.player.a dYJ() {
        return this.nHV;
    }

    public tv.chushou.common.player.a dYK() {
        return this.nHW;
    }

    public tv.chushou.common.player.a dYL() {
        return this.nHX;
    }

    public void a(tv.chushou.common.player.a aVar) {
        this.nHV = aVar;
    }

    public b dYM() {
        return this.nIb;
    }

    public com.kascend.chushou.widget.a.b dYN() {
        return this.nIe;
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
        FullRoomInfo dZl;
        this.r = -1L;
        if (this.s != -1 && this.s != 0) {
            this.r = this.s;
            this.s = -1L;
        }
        if (dYO() && this.nHV != null && this.nHV.getPlayState() == 4) {
            this.r = this.nHV.getCurrentPos();
        }
        this.nIC = false;
        tv.chushou.zues.utils.e.d(this.v, "screenChange()<-----");
        tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard(this);
        if (str != null) {
            this.R = str;
        }
        if (!this.C || !z3 || "3".equals(this.R) || this.nIb == null || (dZl = this.nIb.dZl()) == null || dZl.mRoominfo == null || dZl.mRoominfo.mStyle != 1) {
            z5 = false;
        } else {
            z5 = true;
            i = 0;
        }
        if ("2".equals(this.nIw)) {
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
            if (com.kascend.chushou.b.dYs().d == 1) {
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
            ((VideoPlayer) this.w).yu(false);
            ((VideoPlayer) this.w).g(true);
            if (z5) {
                setRequestedOrientation(1);
            } else {
                setRequestedOrientation(6);
            }
            getWindow().addFlags(512);
            getWindow().addFlags(256);
        }
        if (this.nIe == null) {
            this.nIe = new com.kascend.chushou.widget.a.b();
        }
        if (this.nIe != null) {
            this.nIe.a(this.P);
        }
        if (this.R.equals("5")) {
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            if (this.nHZ != null) {
                beginTransaction.remove(this.nHZ);
                this.nHZ = null;
            }
            if (this.nIa != null) {
                beginTransaction.remove(this.nIa);
                this.nIa = null;
            }
            this.nIa = new com.kascend.chushou.view.user.b();
            beginTransaction.add(a.f.fl_fragment, this.nIa);
            beginTransaction.commitAllowingStateLoss();
        } else {
            FragmentTransaction beginTransaction2 = getSupportFragmentManager().beginTransaction();
            if (this.nHZ != null) {
                beginTransaction2.remove(this.nHZ);
                this.nHZ = null;
            }
            if (this.nIa != null) {
                beginTransaction2.remove(this.nIa);
                this.nIa = null;
            }
            if ("2".equals(this.nIw)) {
                this.nHZ = com.kascend.chushou.player.e.e.b(this.ab, z2, this.aq, this.P);
            } else if (1 == i) {
                if (!this.R.equals("3")) {
                    if (z4) {
                        v();
                    }
                    this.nHZ = new com.kascend.chushou.player.d.a();
                    Bundle bundle = new Bundle();
                    bundle.putString("mCover", this.ab);
                    bundle.putBoolean("mInitViewAsync", z2);
                    this.nHZ.setArguments(bundle);
                }
            } else {
                this.nHZ = new com.kascend.chushou.player.d.b();
                Bundle bundle2 = new Bundle();
                if (z5) {
                    i = 1;
                }
                bundle2.putInt("mExtraOrientation", i);
                bundle2.putString("mViewType", this.R);
                this.nHZ.setArguments(bundle2);
            }
            beginTransaction2.add(a.f.fl_fragment, this.nHZ);
            beginTransaction2.commitAllowingStateLoss();
            this.H = true;
        }
        tv.chushou.zues.utils.e.d(this.v, "screenChange()----->");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dYO() {
        return this.R != null && this.R.equals("3");
    }

    private void R() {
        if (this.nHZ != null) {
            this.nHZ.nMV = null;
        }
        if (this.nHV != null) {
            this.nHV.release();
            this.nHV = null;
            this.K = false;
        }
        if (this.nHW != null) {
            this.nHW.release();
            this.nHW = null;
        }
        if (this.nHX != null) {
            this.nHX.release();
            this.nHX = null;
        }
        if (this.nHY != null) {
            this.nHY.c();
        }
        this.d = false;
        this.e = false;
        this.M = false;
        this.nHY = new c();
        this.nHW = this.nHY.dZq();
        this.nHW.setOnActivityCallBack(this.nIE);
        this.nHX = this.nHY.dZr();
        this.nHX.setOnActivityCallBack(this.nIF);
        if (!this.d) {
            this.nHV = this.nHW;
        } else {
            this.nHV = this.nHX;
        }
        if (this.nHZ != null) {
            this.nHZ.nMV = this.nHV;
        }
    }

    public void j() {
        if (this.nHV != null) {
            this.nHV.pause();
            this.nHV.stop();
            this.nHV.release();
            this.nHV = null;
        }
        if (this.nHW != null) {
            this.nHW.stop();
            this.nHW.release();
            this.nHW = null;
        }
        if (this.nHX != null) {
            this.nHX.stop();
            this.nHX.release();
            this.nHX = null;
        }
        if (this.nHY != null) {
            this.nHY.c();
        }
    }

    public void k() {
        tv.chushou.common.player.a aVar = this.nHV;
        if (aVar != null) {
            aVar.pause();
            aVar.stop();
        }
        tv.chushou.common.player.a aVar2 = this.nHW;
        if (aVar2 != null) {
            aVar2.stop();
        }
        tv.chushou.common.player.a aVar3 = this.nHX;
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
        if (this.nIC) {
            if (this.nHZ != null) {
                this.nHZ.s();
            }
        } else if (this.nIB != null) {
            this.nIB.b(this.nIB.Oy(3), 20L);
        }
    }

    private void b(final String str, String str2) {
        com.kascend.chushou.c.c.dYv().a(new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.VideoPlayer.8
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
                        VideoPlayer.this.b(q.mMessage, q.mRc);
                        return;
                    }
                    FullRoomInfo fullRoomInfo = (FullRoomInfo) q.mData;
                    VideoPlayer.this.dYW().a(fullRoomInfo.mBangMap);
                    if (h.isEmpty(fullRoomInfo.mRoominfo.mRoomID)) {
                        fullRoomInfo.mRoominfo.mRoomID = VideoPlayer.this.P;
                    }
                    if (!h.isEmpty(fullRoomInfo.mGeneralTabGifts)) {
                        com.kascend.chushou.d.e.a(VideoPlayer.this.nIy, new ArrayList(fullRoomInfo.mGeneralTabGifts));
                    }
                    if (VideoPlayer.this.nIb != null) {
                        VideoPlayer.this.nIb.a(fullRoomInfo);
                    }
                    VideoPlayer.this.L = false;
                    if (VideoPlayer.this.B) {
                        if (VideoPlayer.this.C && !"3".equals(VideoPlayer.this.R) && fullRoomInfo != null && fullRoomInfo.mRoominfo != null && fullRoomInfo.mRoominfo.mStyle == 1 && !h.isEmpty(fullRoomInfo.mRoominfo.mGameId)) {
                            z = true;
                        }
                        if (!z) {
                            if (VideoPlayer.this.nHZ != null) {
                                VideoPlayer.this.nHZ.a(VideoPlayer.this.nIb);
                            }
                            if (!h.isEmpty(fullRoomInfo.mRoominfo.mGameId)) {
                                VideoPlayer.this.S();
                            } else {
                                if (VideoPlayer.this.nIb != null) {
                                    VideoPlayer.this.nIb.f = null;
                                }
                                VideoPlayer.this.S();
                            }
                        } else {
                            VideoPlayer.this.a(1, "1", true);
                            if (VideoPlayer.this.nHZ != null) {
                                VideoPlayer.this.nHZ.a(VideoPlayer.this.nIb);
                            }
                        }
                    } else {
                        if (h.isEmpty(fullRoomInfo.mRoominfo.mGameId)) {
                            if (VideoPlayer.this.nIb != null) {
                                VideoPlayer.this.nIb.f = null;
                            }
                            VideoPlayer.this.a(1, "1");
                        } else {
                            VideoPlayer.this.a(1, "1", true);
                        }
                        if (VideoPlayer.this.nHZ != null) {
                            VideoPlayer.this.nHZ.a(VideoPlayer.this.nIb);
                        }
                    }
                    if (VideoPlayer.this.nIb != null && !VideoPlayer.this.nIb.m()) {
                        if (VideoPlayer.this.nIk != null) {
                            VideoPlayer.this.nIk.d();
                            VideoPlayer.this.nIk = null;
                        }
                        VideoPlayer.this.nIk = new com.kascend.chushou.toolkit.d(900000L, VideoPlayer.this.nIm, VideoPlayer.this.nIB);
                        VideoPlayer.this.nIk.a();
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
        if (this.nIb != null) {
            this.nIb.a((FullRoomInfo) null);
        }
        this.L = false;
        bR(str, i);
        if (this.nHV != null) {
            this.nHV.stop();
        }
        if (this.nHW != null) {
            this.nHW.stop();
        }
        if (this.nHX != null) {
            this.nHX.stop();
        }
    }

    public void l() {
        tv.chushou.zues.utils.e.d(this.v, "retryGetPlayList");
        c();
        if (dYO()) {
            bb(this.P, false);
        } else {
            a(this.P, dYY(), false);
        }
    }

    public void m() {
        a(this.ag, false);
    }

    private void a(final String str, String str2, boolean z) {
        this.J = true;
        VideoPlayInfo M = j.dYG().M(str + str2, 600000L);
        if (M != null) {
            a((ArrayList) M.mPlayUrls);
            this.J = false;
        } else if (z) {
            ParserRet gp = com.kascend.chushou.player.c.a.dZs().gp(str, str2);
            if (gp.mRc != 0) {
                tv.chushou.zues.utils.e.e(this.v, "getPlayUrlSync fail, try to getPlaylist");
                a(str, str2, false);
                return;
            }
            a(gp, str);
        } else {
            com.kascend.chushou.player.c.a.dZs().a(str, str2, new a.InterfaceC0887a() { // from class: com.kascend.chushou.player.VideoPlayer.9
                @Override // com.kascend.chushou.player.c.a.InterfaceC0887a
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
    private void bb(final String str, boolean z) {
        boolean equals;
        this.J = true;
        VideoPlayInfo N = j.dYG().N(str, 600000L);
        if (N != null) {
            a((ArrayList) N.mPlayUrls);
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
                ParserRet bc = com.kascend.chushou.player.c.a.dZs().bc(str, equals);
                if (bc.mRc != 0) {
                    tv.chushou.zues.utils.e.e(this.v, "getVideoPlayUrlSync fail, try to getVideoPlaylist");
                    bb(str, false);
                    return;
                }
                a(bc, str);
                return;
            }
            com.kascend.chushou.player.c.a.dZs().a(str, new a.InterfaceC0887a() { // from class: com.kascend.chushou.player.VideoPlayer.10
                @Override // com.kascend.chushou.player.c.a.InterfaceC0887a
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
                if (this.nIb.f == null) {
                    this.nIb.f = new ArrayList<>();
                }
                this.nIb.f.clear();
                this.nIb.f.addAll(arrayList);
                if ("1".equals(this.R)) {
                    j.dYG().a(str + dYY(), arrayList);
                } else {
                    j.dYG().s(str, arrayList);
                }
                a(arrayList);
                return;
            }
            if (this.nIb != null) {
                this.nIb.f = null;
            }
            if (this.nIB != null) {
                Message Oy = this.nIB.Oy(5);
                Oy.arg1 = 2;
                Oy.arg2 = parserRet.mRc;
                this.nIB.S(Oy);
            }
        }
    }

    private void bR(String str, int i) {
        s();
        if (this.nIe != null) {
            this.nIe.a();
        }
        if (h.isEmpty(str)) {
            str = getString(a.i.str_load_data_failed);
        }
        a(str, i);
    }

    public void n() {
        if (this.nIh != null && this.bJf != null && this.nIj != null) {
            this.nIh.setVisibility(0);
            this.bJf.setVisibility(8);
            this.nIj.setVisibility(8);
        }
    }

    public void o() {
        if (this.nIo != null && this.nIo.getVisibility() == 0) {
            this.nIo.Ck(0);
            this.nIo.setVisibility(8);
        }
    }

    public void p() {
        if (this.nIp != null && this.nIp.getVisibility() == 0) {
            this.nIp.setVisibility(8);
        }
    }

    public void q() {
        this.nIC = true;
    }

    protected void r() {
        this.nIh.setVisibility(8);
        this.nIj.setVisibility(0);
        this.bJf.setVisibility(0);
        if (this.nId != null) {
            this.T.setVisibility(8);
            this.nId.setVisibility(0);
            this.U.setText(getString(a.i.str_dialog_loading_content));
            this.U.setVisibility(8);
        }
    }

    protected void a(String str, int i) {
        this.nIh.setVisibility(8);
        this.nIj.setVisibility(0);
        this.bJf.setVisibility(0);
        if (this.nId != null) {
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
                            com.kascend.chushou.c.c.dYv().b(new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.VideoPlayer.11.1
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
                                        tv.chushou.zues.utils.g.H(VideoPlayer.this, a.i.subscribe_failed);
                                    }
                                }
                            }, VideoPlayer.this.P, (String) null, VideoPlayer.this.nIb.h);
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
            this.nId.setVisibility(8);
            this.nIp.setVisibility(8);
        }
    }

    public void s() {
        if (this.nIB != null) {
            this.nIB.removeMessages(1);
        }
    }

    private void a(ArrayList<PlayUrl> arrayList) {
        boolean z;
        if (this.nIb.f == null) {
            this.nIb.f = new ArrayList<>();
        }
        this.nIb.f.clear();
        this.nIb.f.addAll(arrayList);
        if (com.kascend.chushou.d.e.b() && !"4".equals(this.aq)) {
            int c = com.kascend.chushou.d.e.c();
            if (c == -1) {
                b(arrayList);
                return;
            } else if (this.aw) {
                this.aw = false;
                if (c == 0) {
                    this.nIb.d = false;
                    f(arrayList, true);
                    return;
                }
                if (this.nIb != null && this.nIb.f != null) {
                    Iterator<PlayUrl> it = this.nIb.f.iterator();
                    while (it.hasNext()) {
                        if ("2".equals(it.next().mType)) {
                            z = true;
                            break;
                        }
                    }
                }
                z = false;
                this.nIb.d = z;
                f(arrayList, true);
                return;
            } else {
                if (this.nIb.e) {
                    this.nIb.d = !this.nIb.d;
                    this.nIb.e = false;
                    this.nID = true;
                } else if ("4".equals(this.aq)) {
                    this.nIb.d = true;
                }
                f(arrayList, true);
                return;
            }
        }
        if (this.nIb.e) {
            this.nIb.d = !this.nIb.d;
            this.nIb.e = false;
            this.nID = true;
        } else if ("4".equals(this.aq)) {
            this.nIb.d = true;
        }
        f(arrayList, true);
    }

    private void b(ArrayList<PlayUrl> arrayList) {
        if ("1".equals(this.R)) {
            if ("2".equals(this.nIw)) {
                d(false, arrayList);
            } else if (this.nHZ != null) {
                this.nHZ.f(arrayList, false);
            }
        } else if (this.nHZ != null) {
            this.nHZ.f(arrayList, false);
        }
    }

    public void c(boolean z) {
        this.nIb.d = false;
        com.kascend.chushou.d.e.a(0);
        ArrayList<PlayUrl> arrayList = this.nIb.f;
        if (!h.isEmpty(arrayList)) {
            if (z) {
                f(arrayList, false);
                if (this.nIB != null) {
                    this.nIB.Ow(2);
                    return;
                }
                return;
            }
            f(arrayList, true);
        }
    }

    public void d(boolean z) {
        this.nIb.d = true;
        com.kascend.chushou.d.e.a(1);
        ArrayList<PlayUrl> arrayList = this.nIb.f;
        if (!h.isEmpty(arrayList)) {
            if (z) {
                f(arrayList, false);
                if (this.nIB != null) {
                    this.nIB.Ow(2);
                    return;
                }
                return;
            }
            f(arrayList, true);
        }
    }

    @Subscribe
    public void onNotifyEvent(com.kascend.chushou.b.a.a.j jVar) {
        if (!isFinishing() && jVar.a == 1 && !"5".equals(this.R) && !dYI()) {
            tv.chushou.zues.utils.e.d(this.v, "onNetworkChangeEvent 3G=" + com.kascend.chushou.b.dYs().b + "  wifi=" + com.kascend.chushou.b.dYs().a);
            if (com.kascend.chushou.d.e.b() && !"4".equals(this.aq)) {
                if (com.kascend.chushou.d.e.c() == -1) {
                    if (this.nHZ != null) {
                        this.nHZ.e(false);
                    }
                    if ("1".equals(this.R)) {
                        if ("2".equals(this.nIw)) {
                            d(true, null);
                            return;
                        } else if (this.nHZ != null) {
                            this.nHZ.f(this.nIb.f, true);
                            return;
                        } else {
                            return;
                        }
                    } else if (this.nHZ != null) {
                        this.nHZ.f(this.nIb.f, true);
                        return;
                    } else {
                        return;
                    }
                }
                RxExecutor.postDelayed(this.nIy, EventThread.MAIN_THREAD, 10L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.VideoPlayer.12
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!VideoPlayer.this.isFinishing() && com.kascend.chushou.b.dYs().b && !com.kascend.chushou.b.dYs().a) {
                            tv.chushou.zues.utils.g.c(VideoPlayer.this.w, VideoPlayer.this.getString(a.i.str_monet_notify));
                        }
                    }
                });
            } else if (com.kascend.chushou.b.dYs().a || com.kascend.chushou.b.dYs().b) {
                t();
                if (this.nIB != null) {
                    this.nIB.Ow(2);
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
            if (this.nIb.d) {
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
            String d = com.kascend.chushou.d.h.dYA().d();
            String str3 = h.isEmpty(d) ? "2" : d;
            if (this.nIb.d) {
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
                if (this.nIb != null) {
                    this.nIb.a(playUrl2);
                    if (this.nIB != null) {
                        Message Oy = this.nIB.Oy(5);
                        Oy.arg1 = 1;
                        this.nIB.S(Oy);
                    }
                }
                String b = com.kascend.chushou.player.c.a.b(playUrl2);
                if (!h.isEmpty(b)) {
                    this.nHU = Uri.parse(b);
                    if (this.nID) {
                        this.nID = false;
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (z && this.nHV != null) {
                        a(false, z2);
                    }
                }
            }
        }
    }

    public void d(final boolean z, ArrayList<PlayUrl> arrayList) {
        if (this.nIl == null || this.nIl.a <= 0) {
            this.nIl = com.kascend.chushou.view.b.a.a.eaJ();
            this.nIl.a(new a.InterfaceC0906a() { // from class: com.kascend.chushou.player.VideoPlayer.13
                @Override // com.kascend.chushou.view.b.a.a.InterfaceC0906a
                public void a(int i) {
                    if (i == a.f.tv_play_video) {
                        VideoPlayer.this.nIl.dismissAllowingStateLoss();
                        VideoPlayer.this.c(z);
                    } else if (i == a.f.tv_play_audio) {
                        VideoPlayer.this.nIl.dismissAllowingStateLoss();
                        VideoPlayer.this.d(z);
                    } else if (i == a.f.iv_close) {
                        VideoPlayer.this.finish();
                    } else {
                        if (i == a.f.tv_union_proxy) {
                        }
                    }
                }
            });
            this.nIl.show(getSupportFragmentManager(), "showRoom");
        }
    }

    public void t() {
        if (this.nIl != null) {
            this.nIl.dismissAllowingStateLoss();
        }
        if (this.nHZ != null) {
            this.nHZ.v();
        }
    }

    public void u() {
        com.kascend.chushou.c.c.dYv().c(this.P, new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.VideoPlayer.16
            @Override // com.kascend.chushou.c.b
            public void a() {
            }

            @Override // com.kascend.chushou.c.b
            public void a(String str, JSONObject jSONObject) {
                if (!VideoPlayer.this.isFinishing()) {
                    ParserRet em = com.kascend.chushou.c.e.em(jSONObject);
                    if (em.mRc == 0 && em.mData != null) {
                        CycleLiveRoomInfo cycleLiveRoomInfo = (CycleLiveRoomInfo) em.mData;
                        if (VideoPlayer.this.nIb != null && cycleLiveRoomInfo != null && !h.isEmpty(cycleLiveRoomInfo.roomId)) {
                            FullRoomInfo dZl = VideoPlayer.this.nIb.dZl();
                            if (dZl.cycleLiveRoomInfo == null) {
                                dZl.cycleLiveRoomInfo = cycleLiveRoomInfo;
                                VideoPlayer.this.d();
                            } else if (dZl.cycleLiveRoomInfo != null && !cycleLiveRoomInfo.roomId.equals(dZl.cycleLiveRoomInfo.roomId)) {
                                dZl.cycleLiveRoomInfo.copyCycleLiveRoomInfo(cycleLiveRoomInfo);
                                VideoPlayer.this.d();
                            } else {
                                dZl.cycleLiveRoomInfo.copyCycleLiveRoomInfo(cycleLiveRoomInfo);
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
        if (this.nHZ != null) {
            this.nHZ.N();
        }
    }

    public void v() {
        com.kascend.chushou.c.c.dYv().a(this.P, new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.VideoPlayer.17
            @Override // com.kascend.chushou.c.b
            public void a() {
            }

            @Override // com.kascend.chushou.c.b
            public void a(String str, JSONObject jSONObject) {
                if (!VideoPlayer.this.isFinishing()) {
                    ParserRet en = com.kascend.chushou.c.e.en(jSONObject);
                    if (en.mRc == 0 && en.mData != null) {
                        PkNotifyInfo pkNotifyInfo = (PkNotifyInfo) en.mData;
                        VideoPlayer.this.nIu.b = VideoPlayer.this.P;
                        if (pkNotifyInfo != null) {
                            VideoPlayer.this.nIu.nMW = pkNotifyInfo;
                            if (VideoPlayer.this.nHZ != null) {
                                VideoPlayer.this.nHZ.a(pkNotifyInfo, VideoPlayer.this.P);
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
        if (this.nIc != null) {
            this.nIc.release();
            this.nIc = null;
        }
        com.kascend.chushou.c.c.dYv().a(this.P, new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.VideoPlayer.18
            @Override // com.kascend.chushou.c.b
            public void a() {
            }

            @Override // com.kascend.chushou.c.b
            public void a(String str, JSONObject jSONObject) {
                if (!VideoPlayer.this.isFinishing()) {
                    ParserRet eo = com.kascend.chushou.c.e.eo(jSONObject);
                    if (eo.mRc == 0 && eo.mData != null) {
                        RoomExpandInfo roomExpandInfo = (RoomExpandInfo) eo.mData;
                        if (VideoPlayer.this.nIb != null) {
                            VideoPlayer.this.nIb.nJE = roomExpandInfo.mTopWebAdItem;
                            if (VideoPlayer.this.nIb.nJK == null) {
                                VideoPlayer.this.nIb.nJK = new ArrayList();
                            }
                            VideoPlayer.this.nIb.nJK.clear();
                            VideoPlayer.this.nIb.nJK.addAll(roomExpandInfo.mGiftTopRightIcons);
                            tv.chushou.zues.a.a.post(new i(50, VideoPlayer.this.nIb.nJE));
                        }
                        if (VideoPlayer.this.nIb != null) {
                            VideoPlayer.this.nIb.fO(roomExpandInfo.mExpandNavList);
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
                            VideoPlayer.this.nIq.a(list);
                        }
                        List<com.kascend.chushou.player.ui.h5.c.c> list2 = roomExpandInfo.mLuckList;
                        if (!h.isEmpty(list2)) {
                            VideoPlayer.this.nIr.a(list2);
                        }
                        com.kascend.chushou.player.ui.h5.c.c cVar = roomExpandInfo.mVoteItem;
                        if (cVar != null) {
                            VideoPlayer.this.nIs.a(cVar);
                        }
                        List<com.kascend.chushou.player.ui.h5.c.b> list3 = roomExpandInfo.mInteractH5Item;
                        if (!h.isEmpty(list3)) {
                            VideoPlayer.this.nIv.a(list3);
                        }
                        List<com.kascend.chushou.player.ui.h5.c.b> list4 = roomExpandInfo.mInteractNavItem;
                        if (!h.isEmpty(list4)) {
                            VideoPlayer.this.nIv.a(list4);
                        }
                        VideoPlayer.this.nIc = (PrivilegeInfo) eo.mData1;
                        if (VideoPlayer.this.nIc != null) {
                            tv.chushou.zues.a.a.post(new l());
                        }
                        if (VideoPlayer.this.nIb != null) {
                            VideoPlayer.this.nIb.nJL = roomExpandInfo.mIconConfig;
                            VideoPlayer.this.dYW().a(roomExpandInfo.mIconConfig.bangConfig);
                        }
                        List<SkinConfig> list5 = roomExpandInfo.skinConfig;
                        if (list5 != null && VideoPlayer.this.nIb != null) {
                            VideoPlayer.this.nIb.nJO.clear();
                            int i = 0;
                            while (true) {
                                int i2 = i;
                                if (i2 >= list5.size()) {
                                    break;
                                }
                                SkinConfig skinConfig = list5.get(i2);
                                VideoPlayer.this.nIb.nJO.put(skinConfig.position, skinConfig.resource);
                                i = i2 + 1;
                            }
                            VideoPlayer.this.C();
                        }
                        VideoPlayer.this.a(roomExpandInfo.mIconConfig, VideoPlayer.this.nIb != null ? VideoPlayer.this.nIb.nJO : null);
                        if (roomExpandInfo.mColorMap != null && roomExpandInfo.mColorMap.size() > 0 && com.kascend.chushou.b.dYs().c != null && com.kascend.chushou.b.dYs().c.size() <= 0) {
                            com.kascend.chushou.b.dYs().c.putAll(roomExpandInfo.mColorMap);
                            tv.chushou.zues.a.a.post(new i(52, null));
                        }
                        AutoBang autoBang = roomExpandInfo.mAutoBang;
                        if (autoBang != null && autoBang.currentTime != 0 && autoBang.bangTime != 0) {
                            VideoPlayer.this.dYW().a(autoBang);
                        }
                        if (!h.isEmpty(roomExpandInfo.mRelatedRoomList) && VideoPlayer.this.nIb != null) {
                            VideoPlayer.this.nIb.t = roomExpandInfo.mRelatedRoomList;
                            if (VideoPlayer.this.nHZ != null && VideoPlayer.this.H) {
                                VideoPlayer.this.nHZ.w();
                            }
                        }
                        if (roomExpandInfo.mRoomNewUserInfo != null && roomExpandInfo.mRoomNewUserInfo.mBarrierNoviceGuide && !com.kascend.chushou.d.h.dYA().k() && VideoPlayer.this.nHZ != null) {
                            VideoPlayer.this.nHZ.J();
                        }
                        if (roomExpandInfo.mRoomNewUserInfo != null && roomExpandInfo.mRoomNewUserInfo.mRewardNoviceGuide && !com.kascend.chushou.d.h.dYA().l() && VideoPlayer.this.nHZ != null) {
                            VideoPlayer.this.nHZ.K();
                        }
                        if (!h.isEmpty(roomExpandInfo.mShopWindowInfos)) {
                            if (VideoPlayer.this.nIb != null) {
                                if (VideoPlayer.this.nIb.nJM == null) {
                                    VideoPlayer.this.nIb.nJM = new ArrayList();
                                }
                                VideoPlayer.this.nIb.nJM.addAll(roomExpandInfo.mShopWindowInfos);
                            }
                            if (VideoPlayer.this.nHZ != null) {
                                VideoPlayer.this.nHZ.L();
                            }
                        }
                        VideoPlayer.this.nIu.b = VideoPlayer.this.P;
                        if (roomExpandInfo.mPkNotifyInfo != null) {
                            VideoPlayer.this.nIu.nMW = roomExpandInfo.mPkNotifyInfo;
                            if (VideoPlayer.this.nHZ != null) {
                                VideoPlayer.this.nHZ.a(roomExpandInfo.mPkNotifyInfo, VideoPlayer.this.P);
                            }
                        } else {
                            VideoPlayer.this.nIu.nMW = null;
                        }
                        if (roomExpandInfo.mTrumpetPocket != null && VideoPlayer.this.nIb != null) {
                            VideoPlayer.this.nIb.nJN = roomExpandInfo.mTrumpetPocket;
                            if (VideoPlayer.this.nHZ != null) {
                                VideoPlayer.this.nHZ.M();
                            }
                        }
                        if (!h.isEmpty(roomExpandInfo.hotwordContentList)) {
                            if (VideoPlayer.this.nIb != null) {
                                if (VideoPlayer.this.nIb.w == null) {
                                    VideoPlayer.this.nIb.w = new ArrayList();
                                }
                                VideoPlayer.this.nIb.w.clear();
                                VideoPlayer.this.nIb.w.addAll(roomExpandInfo.hotwordContentList);
                            }
                            if (VideoPlayer.this.nHZ != null) {
                                VideoPlayer.this.nHZ.b(roomExpandInfo.hotwordContentList);
                            }
                        }
                        VideoPlayer.this.U();
                        return;
                    }
                    a(eo.mRc, eo.mMessage);
                }
            }

            @Override // com.kascend.chushou.c.b
            public void a(int i, String str) {
                tv.chushou.zues.utils.e.e(VideoPlayer.this.v, "get room gift popup list failed, rc =" + i + ", errorMsg=" + str);
            }
        }, this.ag, this.nIw);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U() {
        if (!h.isEmpty(com.kascend.chushou.a.a.dYt().nHu)) {
            StringBuilder sb = new StringBuilder();
            if (com.kascend.chushou.a.a.dYt().nHu.contains(com.kascend.chushou.a.a.f)) {
                if (sb.length() > 0) {
                    sb.append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                sb.append(com.kascend.chushou.a.a.f);
            }
            if (com.kascend.chushou.a.a.dYt().nHu.contains(com.kascend.chushou.a.a.g)) {
                if (sb.length() > 0) {
                    sb.append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                sb.append(com.kascend.chushou.a.a.g);
            }
            if (com.kascend.chushou.a.a.dYt().nHu.contains(com.kascend.chushou.a.a.i)) {
                if (sb.length() > 0) {
                    sb.append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                sb.append(com.kascend.chushou.a.a.i);
            }
            if (com.kascend.chushou.a.a.dYt().nHu.contains(com.kascend.chushou.a.a.h)) {
                if (sb.length() > 0) {
                    sb.append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                sb.append(com.kascend.chushou.a.a.h);
            }
            if (com.kascend.chushou.a.a.dYt().nHu.contains(com.kascend.chushou.a.a.j)) {
                if (sb.length() > 0) {
                    sb.append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                sb.append(com.kascend.chushou.a.a.j);
            }
            if (com.kascend.chushou.a.a.dYt().nHu.contains(com.kascend.chushou.a.a.l)) {
                if (sb.length() > 0) {
                    sb.append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                sb.append(com.kascend.chushou.a.a.l);
            }
            if (com.kascend.chushou.a.a.dYt().nHu.contains(com.kascend.chushou.a.a.m)) {
                if (sb.length() > 0) {
                    sb.append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                sb.append(com.kascend.chushou.a.a.m);
            }
            if (sb.length() != 0) {
                com.kascend.chushou.a.a.dYt().a(sb.toString(), this.P, new a.c() { // from class: com.kascend.chushou.player.VideoPlayer.19
                    @Override // com.kascend.chushou.a.a.c
                    public void a(List<ListItem> list) {
                        if (VideoPlayer.this.nIb != null && list != null) {
                            int i = 0;
                            while (true) {
                                int i2 = i;
                                if (i2 >= list.size()) {
                                    break;
                                }
                                if (list.get(i2).mAdExtraInfo != null) {
                                    if (com.kascend.chushou.a.a.f.equals(list.get(i2).mAdExtraInfo.mCode)) {
                                        VideoPlayer.this.nIb.nJD = list.get(i2);
                                    } else if (com.kascend.chushou.a.a.g.equals(list.get(i2).mAdExtraInfo.mCode)) {
                                        VideoPlayer.this.nIb.nJC = list.get(i2);
                                    } else if (com.kascend.chushou.a.a.i.equals(list.get(i2).mAdExtraInfo.mCode)) {
                                        VideoPlayer.this.nIb.nJF = list.get(i2);
                                    } else if (com.kascend.chushou.a.a.h.equals(list.get(i2).mAdExtraInfo.mCode)) {
                                        VideoPlayer.this.nIb.nJG = list.get(i2);
                                    } else if (com.kascend.chushou.a.a.j.equals(list.get(i2).mAdExtraInfo.mCode)) {
                                        VideoPlayer.this.nIb.nJJ = list.get(i2);
                                    } else if (com.kascend.chushou.a.a.l.equals(list.get(i2).mAdExtraInfo.mCode)) {
                                        VideoPlayer.this.nIb.nJH = list.get(i2);
                                    } else if (com.kascend.chushou.a.a.m.equals(list.get(i2).mAdExtraInfo.mCode)) {
                                        VideoPlayer.this.nIb.nJI = list.get(i2);
                                    }
                                }
                                i = i2 + 1;
                            }
                            if (VideoPlayer.this.nHZ != null) {
                                VideoPlayer.this.nHZ.H();
                            }
                        }
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str, String str2) {
        if (dYO()) {
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
                this.nIg.setSystemUiVisibility(i);
                return;
            }
            this.nIg.setSystemUiVisibility(1792);
        }
    }

    public void f(boolean z) {
        Window window;
        View decorView;
        if (com.kascend.chushou.b.dYs().d != 1 && (window = getWindow()) != null && (decorView = window.getDecorView()) != null) {
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
        if (this.nHZ != null) {
            this.nHZ.a(i, i2, intent);
        }
    }

    public Uri dYP() {
        return this.nHU;
    }

    @Override // com.kascend.chushou.view.base.BaseActivity
    protected int y() {
        return 0;
    }

    public void yu(boolean z) {
        if (this.nIg != null) {
            this.nIg.oQw = z;
        }
    }

    public void dYQ() {
        if (this.nIg != null) {
            this.nIg.dYQ();
        }
    }

    public boolean dYR() {
        return this.ae;
    }

    public void g(boolean z) {
        this.ae = z;
    }

    public void h(boolean z) {
        if (this.nIg != null) {
            this.nIg.setIsTranslucentStatus(z);
        }
    }

    public void z() {
        if (this.nIg != null) {
            this.nIg.emR();
        }
    }

    @Override // com.kascend.chushou.widget.gifts.RoomSendGiftView.a
    public void A() {
        if (this.nIe != null) {
            this.nIe.b();
        }
        if (this.nIb != null) {
            this.nIb.z = true;
        }
    }

    @Override // com.kascend.chushou.widget.gifts.RoomSendGiftView.a
    public void B() {
        if (this.nIe != null) {
            this.nIe.b();
        }
    }

    public void a(List<ListItem> list) {
        if (this.nHZ != null) {
            this.nHZ.a(list);
        }
    }

    public void a(IconConfig iconConfig, Map<String, SkinConfig.SkinRes> map) {
        if (this.nHZ != null) {
            this.nHZ.a(iconConfig, map);
        }
    }

    public void C() {
        if (this.nHZ != null) {
            this.nHZ.I();
        }
    }

    @Override // com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC0898a
    public void a(int i) {
        if (this.nHZ != null) {
            this.nHZ.a(i);
        }
    }

    @Override // com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC0898a
    public void D() {
        if (!isFinishing() && this.nHZ != null) {
            this.nHZ.D();
        }
    }

    @Override // com.kascend.chushou.player.ui.h5.b.b.a
    public void a(long j) {
        if (!isFinishing() && this.nHZ != null) {
            this.nHZ.a(j);
        }
    }

    @Override // com.kascend.chushou.player.ui.h5.b.b.a
    public void a(com.kascend.chushou.player.ui.h5.c.a aVar) {
        if (aVar != null && this.nHZ != null) {
            this.nHZ.a(aVar);
        }
    }

    @Override // com.kascend.chushou.player.ui.h5.b.b.a
    public void b(int i) {
        if (this.nHZ != null) {
            this.nHZ.b(i);
        }
    }

    @Override // com.kascend.chushou.player.ui.h5.d.a.InterfaceC0897a
    public void b(long j) {
        if (!isFinishing() && this.nHZ != null) {
            this.nHZ.b(j);
        }
    }

    @Override // com.kascend.chushou.player.ui.h5.a.a.InterfaceC0895a
    public void c(int i) {
        if (!isFinishing() && this.nHZ != null) {
            this.nHZ.c(i);
        }
    }

    @Override // com.kascend.chushou.player.ui.h5.d.a.InterfaceC0897a
    public void b(com.kascend.chushou.player.ui.h5.c.a aVar) {
        if (aVar != null && this.nHZ != null) {
            this.nHZ.b(aVar);
        }
    }

    @Override // com.kascend.chushou.player.ui.a.a.InterfaceC0892a
    public void a(IconConfig.Config config) {
        if (this.nHZ != null) {
            this.nHZ.a(config);
        }
    }

    @Override // com.kascend.chushou.player.ui.a.a.InterfaceC0892a
    public void a(BangInfo bangInfo, String str) {
        if (this.nHZ != null) {
            this.nHZ.a(bangInfo, str);
        }
    }

    @Override // com.kascend.chushou.player.ui.a.a.InterfaceC0892a
    public void a(long j, BangInfo bangInfo, String str) {
        if (this.nHZ != null) {
            this.nHZ.a(j, bangInfo, str);
        }
    }

    public com.kascend.chushou.player.ui.h5.redpacket.a dYS() {
        return this.nIq;
    }

    public com.kascend.chushou.player.ui.h5.b.b dYT() {
        return this.nIr;
    }

    public com.kascend.chushou.player.ui.h5.d.a dYU() {
        return this.nIs;
    }

    public com.kascend.chushou.player.ui.h5.a.a dYV() {
        return this.nIv;
    }

    public com.kascend.chushou.player.ui.a.a dYW() {
        return this.nIt;
    }

    public com.kascend.chushou.player.e.a dYX() {
        return this.nIu;
    }

    @Override // com.kascend.chushou.view.base.BaseActivity, android.app.Activity
    public void finish() {
        super.finish();
        if ("3".equals(this.R)) {
            overridePendingTransition(17432576, a.C0882a.commonres_activity_exit_bottom);
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
        RxExecutor.postDelayed(this.nIy, EventThread.MAIN_THREAD, aVar.d, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.VideoPlayer.2
            @Override // java.lang.Runnable
            public void run() {
                if (VideoPlayer.this.nHZ != null) {
                    VideoPlayer.this.nHZ.c(aVar);
                }
            }
        });
    }

    private void e(final com.kascend.chushou.player.ui.h5.c.a aVar) {
        if (!com.kascend.chushou.d.h.dYA().dYD().contains(aVar.b)) {
            if (aVar.d < 0) {
                aVar.d = 0;
            }
            RxExecutor.postDelayed(this.nIy, EventThread.MAIN_THREAD, aVar.d, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.VideoPlayer.3
                @Override // java.lang.Runnable
                public void run() {
                    if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.nHZ != null) {
                        VideoPlayer.this.nHZ.c(aVar);
                    }
                }
            });
        }
    }

    private String dYY() {
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
                if (VideoPlayer.this.nIf != null && !VideoPlayer.this.isFinishing()) {
                    VideoPlayer.n = VideoPlayer.this.nIf.getStreamVolume(3);
                }
                if (!VideoPlayer.this.isFinishing() && (VideoPlayer.this.nHZ instanceof f)) {
                    ((f) VideoPlayer.this.nHZ).ab();
                }
            }
        }
    }

    public String a(String str) {
        HashMap hashMap = new HashMap(tv.chushou.zues.utils.d.WW(str));
        if ("1".equals(this.R)) {
            hashMap.put("roomId", this.P);
        } else if ("3".equals(this.R)) {
            hashMap.put("videoId", this.P);
        }
        return tv.chushou.zues.utils.d.toJson(hashMap);
    }

    public boolean dYZ() {
        if (this.nHZ instanceof com.kascend.chushou.player.d.a) {
            return ((com.kascend.chushou.player.d.a) this.nHZ).dZX();
        }
        if (this.nHZ instanceof com.kascend.chushou.player.e.e) {
            return true;
        }
        return false;
    }
}

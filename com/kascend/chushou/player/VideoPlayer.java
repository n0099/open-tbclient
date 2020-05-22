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
public class VideoPlayer extends BaseActivity implements a.InterfaceC0804a, a.InterfaceC0807a, b.a, a.InterfaceC0809a, a.InterfaceC0810a, RoomSendGiftView.a {
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
    private c mHP;
    b mHS;
    public PrivilegeInfo mHU;
    com.kascend.chushou.widget.a.b mHW;
    private KPSwitchRootRelativeLayout mHY;
    private FrameLayout mHZ;
    private LinearLayout mIa;
    private com.kascend.chushou.toolkit.d mIb;
    com.kascend.chushou.view.b.a.a mIc;
    private FrescoThumbnailView mIg;
    private FrameLayout mIh;
    public com.kascend.chushou.player.feedback.a mIq;
    private a mIt;
    private CSTVWifiReceiver mIu;
    private boolean B = true;
    private boolean C = false;
    private Uri mHL = null;
    private tv.chushou.common.player.a mHM = null;
    public tv.chushou.common.player.a mHN = null;
    public tv.chushou.common.player.a mHO = null;
    public boolean d = false;
    public boolean e = false;
    private e mHQ = null;
    private boolean H = false;
    private com.kascend.chushou.view.user.b mHR = null;
    private boolean J = false;
    private boolean K = false;
    private boolean L = false;
    private boolean M = false;
    private long mHT = 0;
    private int O = 0;
    public boolean g = false;
    private ImageView T = null;
    private TextView U = null;
    private AnimationImageView mHV = null;
    private View byt = null;
    public boolean j = false;
    public float k = 0.0f;
    public float l = 0.0f;
    public boolean m = false;
    public AudioManager mHX = null;
    private d.a mIe = new d.a() { // from class: com.kascend.chushou.player.VideoPlayer.1
        @Override // com.kascend.chushou.toolkit.d.a
        public void a() {
            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.mIv != null) {
                VideoPlayer.this.mIv.Kq(4);
            }
        }
    };
    private boolean ae = false;
    public boolean q = true;
    public long r = -1;
    public long s = -1;
    private PowerManager.WakeLock mIf = null;
    public String t = null;
    private final com.kascend.chushou.player.ui.h5.redpacket.a mIi = new com.kascend.chushou.player.ui.h5.redpacket.a(this);
    private final com.kascend.chushou.player.ui.h5.b.b mIj = new com.kascend.chushou.player.ui.h5.b.b(this);
    private final com.kascend.chushou.player.ui.h5.d.a mIk = new com.kascend.chushou.player.ui.h5.d.a(this);
    private final com.kascend.chushou.player.ui.a.a mIl = new com.kascend.chushou.player.ui.a.a(this);
    private final com.kascend.chushou.player.e.a mIm = new com.kascend.chushou.player.e.a();
    private final com.kascend.chushou.player.ui.h5.a.a mIn = new com.kascend.chushou.player.ui.h5.a.a(this);
    private String mIo = "1";
    private String aq = "2";
    private io.reactivex.disposables.a mIr = new io.reactivex.disposables.a();
    private tv.chushou.zues.c mIv = new tv.chushou.zues.c(new Handler.Callback() { // from class: com.kascend.chushou.player.VideoPlayer.6
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            try {
                if (!VideoPlayer.this.isFinishing()) {
                    switch (message.what) {
                        case 1:
                            VideoPlayer.this.mIv.removeMessages(1);
                            com.kascend.chushou.c.c.dDV().a(VideoPlayer.this.P, VideoPlayer.this.mHS != null ? VideoPlayer.this.mHS.h : null, System.currentTimeMillis());
                            VideoPlayer.this.mIv.A(1, VideoPlayer.A);
                            break;
                        case 2:
                            VideoPlayer.this.a(true, (Uri) null, false);
                            break;
                        case 3:
                            VideoPlayer.this.S();
                            break;
                        case 4:
                            if (VideoPlayer.this.mHQ != null) {
                                VideoPlayer.this.mHQ.a(true);
                            }
                            if (VideoPlayer.this.mIb != null) {
                                VideoPlayer.this.mIb.d();
                                VideoPlayer.this.mIb = null;
                                break;
                            }
                            break;
                        case 5:
                            int i = message.arg1;
                            if (i == 1) {
                                if (VideoPlayer.this.mHQ != null) {
                                    VideoPlayer.this.mHQ.p();
                                    break;
                                }
                            } else if (i == 2 && VideoPlayer.this.mHQ != null) {
                                VideoPlayer.this.mHQ.e(message.arg2);
                                break;
                            }
                            break;
                        case 6:
                            if (!com.kascend.chushou.b.dDS().a && !com.kascend.chushou.b.dDS().b && VideoPlayer.this.mHQ != null) {
                                VideoPlayer.this.mHQ.g(true);
                                break;
                            } else {
                                VideoPlayer.this.c();
                                break;
                            }
                            break;
                        case 7:
                            tv.chushou.zues.utils.e.d(VideoPlayer.this.v, "MSG_BUFFER_DEALY: ");
                            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.mHQ != null && VideoPlayer.this.M && !VideoPlayer.this.e) {
                                VideoPlayer.this.mHQ.h(true);
                                VideoPlayer.this.mHT = 0L;
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
    private boolean mIw = true;
    private boolean mIx = false;
    private tv.chushou.common.player.b mIy = new tv.chushou.common.player.b() { // from class: com.kascend.chushou.player.VideoPlayer.14
        @Override // tv.chushou.common.player.b
        public void dEA() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerACallback onSetVideoViewLayout");
            if (!VideoPlayer.this.isFinishing()) {
                if ((VideoPlayer.this.mHQ == null || !VideoPlayer.this.mHQ.H) && VideoPlayer.this.mHQ != null && !VideoPlayer.this.d) {
                    VideoPlayer.this.mHQ.y();
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void IT(int i) {
            if (!VideoPlayer.this.isFinishing()) {
                if ((VideoPlayer.this.mHQ == null || !VideoPlayer.this.mHQ.H) && VideoPlayer.this.mHQ != null && !VideoPlayer.this.d) {
                    VideoPlayer.this.mHQ.g(i);
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void dEB() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerACallback onCompletePlayback");
            if (!VideoPlayer.this.isFinishing()) {
                if (!h.isEmpty(VideoPlayer.this.P)) {
                    j.dEf().a(VideoPlayer.this.P, 0);
                }
                VideoPlayer.this.K = false;
                if (VideoPlayer.this.mIv != null) {
                    VideoPlayer.this.mIv.removeMessages(1);
                }
                if ((VideoPlayer.this.mHQ == null || !VideoPlayer.this.mHQ.H) && VideoPlayer.this.mHQ != null && !VideoPlayer.this.d) {
                    VideoPlayer.this.mIv.removeMessages(7);
                    VideoPlayer.this.M = false;
                    VideoPlayer.this.mHQ.z();
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void dEC() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerACallback onVideoRenderingStart");
            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.mHQ != null) {
                VideoPlayer.this.mHQ.G();
            }
        }

        @Override // tv.chushou.common.player.b
        public void dED() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerACallback onPreparedPlayback");
            if (!VideoPlayer.this.isFinishing()) {
                if (VideoPlayer.this.mHQ == null || !VideoPlayer.this.mHQ.H) {
                    VideoPlayer.this.mIv.removeMessages(6);
                    VideoPlayer.this.mHT = 0L;
                    VideoPlayer.this.O = 0;
                    if (VideoPlayer.this.mHM != null && VideoPlayer.this.mHQ != null) {
                        VideoPlayer.this.mHM.setVolume(VideoPlayer.this.mHQ.J, VideoPlayer.this.mHQ.J);
                    }
                    if (VideoPlayer.this.mHS != null) {
                        VideoPlayer.this.K = false;
                        FullRoomInfo dEL = VideoPlayer.this.dEn() ? null : VideoPlayer.this.mHS.dEL();
                        if (VideoPlayer.this.L || dEL != null) {
                            if (VideoPlayer.this.mHS.e) {
                                VideoPlayer.this.mHS.e = false;
                                VideoPlayer.this.mHS.d = !VideoPlayer.this.mHS.d;
                            }
                            if (VideoPlayer.this.mHQ != null) {
                                VideoPlayer.this.c("1", (String) null);
                                if (!VideoPlayer.this.d) {
                                    VideoPlayer.this.mHQ.i(true);
                                } else if (VideoPlayer.this.e) {
                                    VideoPlayer.this.e = false;
                                    VideoPlayer.this.mHQ.B();
                                }
                            }
                        }
                    }
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void IU(int i) {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerACallback onErrorAppeared");
            if (!VideoPlayer.this.isFinishing()) {
                VideoPlayer.this.c();
                VideoPlayer.this.K = false;
                if (VideoPlayer.this.mIv != null) {
                    VideoPlayer.this.mIv.removeMessages(7);
                }
                if (VideoPlayer.this.mIv != null) {
                    VideoPlayer.this.mIv.removeMessages(1);
                }
                if ((VideoPlayer.this.mHQ == null || !VideoPlayer.this.mHQ.H) && !VideoPlayer.this.dEh()) {
                    if (!"10004".equals(VideoPlayer.this.t)) {
                        if (VideoPlayer.this.mHQ != null) {
                            if (VideoPlayer.this.d) {
                                VideoPlayer.this.mHN.stop();
                                VideoPlayer.this.mHN.release();
                                VideoPlayer.this.e = false;
                                VideoPlayer.this.mHQ.C();
                            }
                            if (!com.kascend.chushou.b.dDS().a && !com.kascend.chushou.b.dDS().b) {
                                VideoPlayer.this.mHQ.g(true);
                            } else if (VideoPlayer.this.d) {
                                VideoPlayer.this.mHQ.a(i, true);
                            } else {
                                VideoPlayer.this.mHQ.a(i, false);
                            }
                            VideoPlayer.this.c("2", (String) null);
                            return;
                        }
                        return;
                    }
                    dEB();
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void dEE() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerACallback onBufferingStart");
            if (!VideoPlayer.this.isFinishing()) {
                if ((VideoPlayer.this.mHQ == null || !VideoPlayer.this.mHQ.H) && VideoPlayer.this.mHQ != null && !VideoPlayer.this.d) {
                    VideoPlayer.this.mHQ.E();
                    VideoPlayer.this.M = true;
                    long currentTimeMillis = System.currentTimeMillis();
                    VideoPlayer.this.mIv.removeMessages(7);
                    if (!VideoPlayer.this.g) {
                        VideoPlayer.y(VideoPlayer.this);
                    }
                    tv.chushou.zues.utils.e.d(VideoPlayer.this.v, "currentTime: -- >" + currentTimeMillis + "  bufferTime-->" + VideoPlayer.this.mHT + "  bufferCount-->" + VideoPlayer.this.O);
                    if (currentTimeMillis - VideoPlayer.this.mHT >= 20000 || VideoPlayer.this.O < 2 || VideoPlayer.this.mHQ.H) {
                        if (VideoPlayer.this.O == 1) {
                            VideoPlayer.this.mHT = currentTimeMillis;
                        }
                        VideoPlayer.this.mIv.A(7, 5000L);
                    } else {
                        VideoPlayer.this.mIv.Kq(7);
                    }
                    if (VideoPlayer.this.g) {
                        VideoPlayer.this.g = false;
                    }
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void dEF() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerACallback onBufferingEnd");
            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.mHQ != null && !VideoPlayer.this.d) {
                VideoPlayer.this.mIv.removeMessages(7);
                VideoPlayer.this.M = false;
                if (VideoPlayer.this.mHQ == null || !VideoPlayer.this.mHQ.H) {
                    if (VideoPlayer.this.mHM == null) {
                        VideoPlayer.this.mHQ.a(false, true, false);
                    } else {
                        VideoPlayer.this.mHQ.a(true, VideoPlayer.this.mHM.getPlayState() == 4, VideoPlayer.this.mHM.getPlayState() == 5);
                    }
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void dEG() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerACallback onPlayerStart");
            if (!VideoPlayer.this.isFinishing()) {
                if (VideoPlayer.this.mHQ == null || !VideoPlayer.this.mHQ.H) {
                    if (VideoPlayer.this.mHQ != null && !VideoPlayer.this.d) {
                        if (VideoPlayer.this.mHM != null) {
                            VideoPlayer.this.mHQ.F();
                            VideoPlayer.this.mHQ.a(true, VideoPlayer.this.mHM.getPlayState() == 4, VideoPlayer.this.mHM.getPlayState() == 5);
                        } else {
                            VideoPlayer.this.mHQ.a(false, true, false);
                        }
                    }
                    if (VideoPlayer.this.mIv != null && !VideoPlayer.this.dEn()) {
                        VideoPlayer.this.mIv.removeMessages(1);
                        VideoPlayer.this.mIv.A(1, VideoPlayer.A);
                    }
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void dEH() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerACallback onPlayerPause");
            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.mIv != null) {
                VideoPlayer.this.mIv.removeMessages(1);
            }
        }

        @Override // tv.chushou.common.player.b
        public void dEI() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerACallback onPlayerStop");
            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.dEn() && VideoPlayer.this.mHN != null && !h.isEmpty(VideoPlayer.this.P) && VideoPlayer.this.mHN.getCurrentPos() > 0) {
                j.dEf().a(VideoPlayer.this.P, VideoPlayer.this.mHN.getCurrentPos());
            }
        }
    };
    private tv.chushou.common.player.b mIz = new tv.chushou.common.player.b() { // from class: com.kascend.chushou.player.VideoPlayer.15
        @Override // tv.chushou.common.player.b
        public void dEA() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerBCallback onSetVideoViewLayout");
            if (!VideoPlayer.this.isFinishing()) {
                if ((VideoPlayer.this.mHQ == null || !VideoPlayer.this.mHQ.H) && VideoPlayer.this.mHQ != null && VideoPlayer.this.d) {
                    VideoPlayer.this.mHQ.y();
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void IT(int i) {
            if (!VideoPlayer.this.isFinishing()) {
                if ((VideoPlayer.this.mHQ == null || !VideoPlayer.this.mHQ.H) && VideoPlayer.this.mHQ != null && VideoPlayer.this.d) {
                    VideoPlayer.this.mHQ.g(i);
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void dEB() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerBCallback onCompletePlayback");
            if (!VideoPlayer.this.isFinishing()) {
                if (!h.isEmpty(VideoPlayer.this.P)) {
                    j.dEf().a(VideoPlayer.this.P, 0);
                }
                VideoPlayer.this.K = false;
                if (VideoPlayer.this.mIv != null) {
                    VideoPlayer.this.mIv.removeMessages(1);
                }
                if ((VideoPlayer.this.mHQ == null || !VideoPlayer.this.mHQ.H) && VideoPlayer.this.mHQ != null && VideoPlayer.this.d) {
                    VideoPlayer.this.mIv.removeMessages(7);
                    VideoPlayer.this.M = false;
                    VideoPlayer.this.mHQ.z();
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void dEC() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerBCallback onVideoRenderingStart");
            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.mHQ != null) {
                VideoPlayer.this.mHQ.G();
            }
        }

        @Override // tv.chushou.common.player.b
        public void dED() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerBCallback onPreparedPlayback");
            if (!VideoPlayer.this.isFinishing()) {
                if (VideoPlayer.this.mHQ == null || !VideoPlayer.this.mHQ.H) {
                    VideoPlayer.this.mIv.removeMessages(6);
                    VideoPlayer.this.mHT = 0L;
                    VideoPlayer.this.O = 0;
                    if (VideoPlayer.this.mHM != null && VideoPlayer.this.mHQ != null) {
                        VideoPlayer.this.mHM.setVolume(VideoPlayer.this.mHQ.J, VideoPlayer.this.mHQ.J);
                    }
                    if (VideoPlayer.this.mHS != null) {
                        VideoPlayer.this.K = false;
                        FullRoomInfo dEL = VideoPlayer.this.dEn() ? null : VideoPlayer.this.mHS.dEL();
                        if (VideoPlayer.this.L || dEL != null) {
                            if (VideoPlayer.this.mHS.e) {
                                VideoPlayer.this.mHS.e = false;
                                VideoPlayer.this.mHS.d = !VideoPlayer.this.mHS.d;
                            }
                            if (VideoPlayer.this.mHQ != null) {
                                VideoPlayer.this.c("1", (String) null);
                                if (VideoPlayer.this.d) {
                                    VideoPlayer.this.mHQ.i(true);
                                } else if (VideoPlayer.this.e) {
                                    VideoPlayer.this.e = false;
                                    VideoPlayer.this.mHQ.B();
                                }
                            }
                        }
                    }
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void IU(int i) {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerBCallback onErrorAppeared");
            if (!VideoPlayer.this.isFinishing()) {
                VideoPlayer.this.c();
                VideoPlayer.this.K = false;
                if (VideoPlayer.this.mIv != null) {
                    VideoPlayer.this.mIv.removeMessages(7);
                }
                if (VideoPlayer.this.mIv != null) {
                    VideoPlayer.this.mIv.removeMessages(1);
                }
                if ((VideoPlayer.this.mHQ == null || !VideoPlayer.this.mHQ.H) && !VideoPlayer.this.dEh()) {
                    if (!"10004".equals(VideoPlayer.this.t)) {
                        if (VideoPlayer.this.mHQ != null) {
                            if (!VideoPlayer.this.d) {
                                VideoPlayer.this.mHO.stop();
                                VideoPlayer.this.mHO.release();
                                VideoPlayer.this.mHQ.C();
                                VideoPlayer.this.e = false;
                            }
                            if (!com.kascend.chushou.b.dDS().a && !com.kascend.chushou.b.dDS().b) {
                                VideoPlayer.this.mHQ.g(true);
                            } else if (VideoPlayer.this.d) {
                                VideoPlayer.this.mHQ.a(i, false);
                            } else {
                                VideoPlayer.this.mHQ.a(i, true);
                            }
                            VideoPlayer.this.c("2", (String) null);
                            return;
                        }
                        return;
                    }
                    dEB();
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void dEE() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerBCallback onBufferingStart");
            if (!VideoPlayer.this.isFinishing()) {
                if ((VideoPlayer.this.mHQ == null || !VideoPlayer.this.mHQ.H) && VideoPlayer.this.mHQ != null && VideoPlayer.this.d) {
                    VideoPlayer.this.mHQ.E();
                    VideoPlayer.this.M = true;
                    VideoPlayer.this.mIv.removeMessages(7);
                    long currentTimeMillis = System.currentTimeMillis();
                    if (!VideoPlayer.this.g) {
                        VideoPlayer.y(VideoPlayer.this);
                    }
                    tv.chushou.zues.utils.e.d(VideoPlayer.this.v, "currentTime: -- >" + currentTimeMillis + "  bufferTime-->" + VideoPlayer.this.mHT + "  bufferCount-->" + VideoPlayer.this.O);
                    if (currentTimeMillis - VideoPlayer.this.mHT >= 20000 || VideoPlayer.this.O < 2 || VideoPlayer.this.mHQ.H) {
                        if (VideoPlayer.this.O == 1) {
                            VideoPlayer.this.mHT = currentTimeMillis;
                        }
                        VideoPlayer.this.mIv.A(7, 5000L);
                    } else {
                        VideoPlayer.this.mHT = 0L;
                        VideoPlayer.this.O = 0;
                        VideoPlayer.this.mIv.Kq(7);
                    }
                    if (VideoPlayer.this.g) {
                        VideoPlayer.this.g = false;
                    }
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void dEF() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerBCallback onBufferingEnd");
            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.mHQ != null && VideoPlayer.this.d) {
                VideoPlayer.this.M = false;
                VideoPlayer.this.mIv.removeMessages(7);
                if (VideoPlayer.this.mHQ == null || !VideoPlayer.this.mHQ.H) {
                    if (VideoPlayer.this.mHM == null) {
                        VideoPlayer.this.mHQ.a(false, true, false);
                    } else {
                        VideoPlayer.this.mHQ.a(true, VideoPlayer.this.mHM.getPlayState() == 4, VideoPlayer.this.mHM.getPlayState() == 5);
                    }
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void dEG() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerBCallback onPlayerStart");
            if (!VideoPlayer.this.isFinishing()) {
                if (VideoPlayer.this.mHQ == null || !VideoPlayer.this.mHQ.H) {
                    if (VideoPlayer.this.mHQ != null && VideoPlayer.this.d) {
                        if (VideoPlayer.this.mHM != null) {
                            VideoPlayer.this.mHQ.F();
                            VideoPlayer.this.mHQ.a(true, VideoPlayer.this.mHM.getPlayState() == 4, VideoPlayer.this.mHM.getPlayState() == 5);
                        } else {
                            VideoPlayer.this.mHQ.a(false, true, false);
                        }
                    }
                    if (VideoPlayer.this.mIv != null && !VideoPlayer.this.dEn()) {
                        VideoPlayer.this.mIv.removeMessages(1);
                        VideoPlayer.this.mIv.A(1, VideoPlayer.A);
                    }
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void dEH() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerBCallback onPlayerPause");
            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.mIv != null) {
                VideoPlayer.this.mIv.removeMessages(1);
            }
        }

        @Override // tv.chushou.common.player.b
        public void dEI() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerBCallback onPlayerStop");
            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.dEn() && VideoPlayer.this.mHO != null && !h.isEmpty(VideoPlayer.this.P) && VideoPlayer.this.mHO.getCurrentPos() > 0) {
                j.dEf().a(VideoPlayer.this.P, VideoPlayer.this.mHO.getCurrentPos());
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
        this.mHL = intent.getData();
        if (this.mHL == null) {
            finish();
            return;
        }
        com.kascend.chushou.d.e.j();
        if (this.mIu == null) {
            this.mIu = new CSTVWifiReceiver();
            registerReceiver(this.mIu, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        }
        com.kascend.chushou.toolkit.d.a.dGd().b();
        tv.chushou.zues.utils.e.i(this.v, "intent.getData=" + this.mHL.toString());
        String scheme = this.mHL.getScheme();
        if (scheme == null || !scheme.equals("chushou")) {
            tv.chushou.zues.utils.e.e(this.v, "not support scheme :" + scheme);
            finish();
            return;
        }
        a(intent);
    }

    private void a(Intent intent) {
        this.P = this.mHL.getQueryParameter("roomId");
        this.Q = this.P;
        this.S = this.mHL.getQueryParameter(WebSocketRequest.PARAM_KEY_PROTOCOLS);
        this.aq = this.mHL.getQueryParameter("liveType");
        if ("2".equals(this.aq) || "3".equals(this.aq) || "4".equals(this.aq)) {
            this.mIo = "2";
            this.mIq = new com.kascend.chushou.player.feedback.a();
            if (this.mIq.mQF != null) {
                this.mIq.mQF.reset();
                this.mIq.mQF.roomId = this.P;
                this.mIq.mQF.enterType = 1;
                this.mIq.b = System.currentTimeMillis();
            }
        }
        if (h.isEmpty(this.P) || h.isEmpty(this.S)) {
            tv.chushou.zues.utils.e.e(this.v, "invalid param mItemID=" + this.P + " protocols=" + this.S);
            finish();
            return;
        }
        if (com.kascend.chushou.b.dDS().d == -1) {
            com.kascend.chushou.b.dDS().d = com.kascend.chushou.d.g.b() ? 1 : 0;
        }
        this.mIf = ((PowerManager) getSystemService("power")).newWakeLock(536870938, this.v);
        this.mIf.acquire();
        this.mHS = new b(this.P);
        this.mHS.d = intent.getBooleanExtra("room_play_audio", false);
        this.mHW = new com.kascend.chushou.widget.a.b();
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
        this.mHY = (KPSwitchRootRelativeLayout) findViewById(a.f.rlRoot);
        if (!"2".equals(this.mIo) && com.kascend.chushou.b.dDS().d == 1) {
            this.mHY.setFitsSystemWindows(true);
        }
        this.mHZ = (FrameLayout) this.mHY.findViewById(a.f.fl_fragment);
        this.byt = this.mHY.findViewById(a.f.rl_empty);
        this.T = (ImageView) this.byt.findViewById(a.f.iv_empty);
        this.U = (TextView) this.byt.findViewById(a.f.tv_empty);
        this.mIa = (LinearLayout) this.mHY.findViewById(a.f.rl_title);
        this.Z = (ImageView) this.mIa.findViewById(a.f.back_icon);
        this.Z.setOnClickListener(new View.OnClickListener() { // from class: com.kascend.chushou.player.VideoPlayer.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayer.this.finish();
            }
        });
        this.mHV = (AnimationImageView) this.byt.findViewById(a.f.iv_loading);
        this.mIg = (FrescoThumbnailView) this.mHY.findViewById(a.f.live_cover);
        this.mIh = (FrameLayout) this.mHY.findViewById(a.f.fl_cover);
        this.k = dEg();
        try {
            this.mHX = (AudioManager) getApplicationContext().getSystemService("audio");
            n = this.mHX.getStreamVolume(3);
            this.mHX.requestAudioFocus(null, 3, 1);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (this.B) {
            a(1, dEn() ? "3" : "1");
        } else {
            r();
        }
        if (com.kascend.chushou.b.dDS().b && !com.kascend.chushou.b.dDS().a) {
            RxExecutor.postDelayed(this.mIr, EventThread.MAIN_THREAD, 60L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.VideoPlayer.5
                @Override // java.lang.Runnable
                public void run() {
                    if (!VideoPlayer.this.isFinishing() && com.kascend.chushou.b.dDS().b && !com.kascend.chushou.b.dDS().a) {
                        tv.chushou.zues.utils.g.c(VideoPlayer.this.w, VideoPlayer.this.getString(a.i.str_monet_notify));
                    }
                }
            });
        }
        com.kascend.chushou.c.c.dDV().a(this.P, stringExtra, System.currentTimeMillis());
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
        if (this.mIt == null) {
            this.mIt = new a();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.media.VOLUME_CHANGED_ACTION");
            registerReceiver(this.mIt, intentFilter);
        }
    }

    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        j(false);
        if (this.mIt != null) {
            unregisterReceiver(this.mIt);
            this.mIt = null;
        }
        super.onStop();
    }

    @Override // com.kascend.chushou.view.base.BaseActivity
    protected void a(boolean z) {
        if (this.mHQ != null) {
            this.mHQ.k(z);
        }
    }

    @Subscribe
    public void onHideGiftEffectEvent(com.kascend.chushou.b.a.a.f fVar) {
        if (fVar.b) {
            this.mHQ.k();
            return;
        }
        this.mHQ.m();
        this.mHQ.l();
    }

    private float dEg() {
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
            this.mHS.h = jSONObject.toString();
            String optString = jSONObject.optString("_thumb");
            jSONObject.optBoolean("tag_from_game_mic", false);
            if (!h.isEmpty(optString)) {
                this.ab = optString;
            }
        } catch (JSONException e) {
            e.printStackTrace();
            this.mHS.h = str;
        }
        if (dEn()) {
            a(this.P, str);
            aY(this.P, z);
            return;
        }
        a = this.P;
        b(this.P, str);
        a(this.P, dEx(), z);
        w();
    }

    private void O() {
        this.m = true;
        j();
        if (this.mHQ != null) {
            this.mHQ.r();
        }
        s();
    }

    @Subscribe
    public void onStartRoomEvent(o oVar) {
        if (!isFinishing() && oVar.mHs != null && oVar.c != null && !h.isEmpty(oVar.mHs.mTargetKey)) {
            if (oVar.c != this) {
                tv.chushou.zues.utils.e.e(this.v, "different player!");
                return;
            }
            if (this.mHS != null) {
                this.mHS.a();
                this.mHS.a = oVar.mHs.mTargetKey;
                this.mHS.d = oVar.d;
                if (this.mHS.mJv != null) {
                    this.mHS.mJv.e();
                }
                if (this.mHS.mJv != null) {
                    this.mHS.mJv.b();
                }
                this.mHS.mJy = null;
                this.mHS.mJx = null;
                this.mHS.mJB = null;
                this.mHS.mJA = null;
                this.mHS.mJE = null;
                this.mHS.mJC = null;
                this.mHS.mJD = null;
            }
            if (this.mHX != null) {
                n = this.mHX.getStreamVolume(3);
            }
            if (!h.isEmpty(oVar.mHs.mType) && oVar.mHs.mType.equals("3")) {
                this.B = false;
                this.mIo = "1";
                r();
                this.P = oVar.mHs.mTargetKey;
                this.R = "3";
                if (this.mHW != null) {
                    this.mHW.a();
                }
                if (this.mHS != null) {
                    this.mHS.a((PlayUrl) null);
                    this.mHS.f();
                    if (this.mHS.c() != null) {
                        this.mHS.c().clear();
                    }
                    this.mHS.i.clear();
                }
                if (this.mHQ != null) {
                    this.mHQ.j();
                }
                s();
                if (this.mIb != null) {
                    this.mIb.d();
                    this.mIb = null;
                }
                if (this.mIr != null) {
                    this.mIr.dispose();
                    this.mIr = new io.reactivex.disposables.a();
                }
                a(oVar.e, false);
                return;
            }
            boolean z = this.R != null && this.R.equals("1");
            this.R = "1";
            this.mIl.a();
            this.mIk.a();
            this.mIj.a();
            this.mIi.c();
            this.mIn.a();
            if (this.mIr != null) {
                this.mIr.dispose();
                this.mIr = new io.reactivex.disposables.a();
            }
            if ("1".equals(oVar.f)) {
                this.H = false;
                if (this.mHS != null && !h.isEmpty(this.mHS.t)) {
                    this.mHS.t.clear();
                }
                this.ab = oVar.mHs.mCover;
                this.mIh.setVisibility(0);
                this.mIg.setBlur(true);
                this.mIg.i(oVar.mHs.mCover, 0, 0, 0);
            }
            if (!oVar.mHs.mTargetKey.equals(this.P)) {
                this.aq = oVar.g;
                if (!z) {
                    this.B = false;
                    r();
                } else if (!"2".equals(this.mIo) && ("2".equals(this.aq) || "3".equals(this.aq) || "4".equals(this.aq))) {
                    this.mIo = "2";
                    this.mIq = new com.kascend.chushou.player.feedback.a();
                    if (this.mIq.mQF != null) {
                        this.mIq.mQF.reset();
                        this.mIq.mQF.roomId = oVar.mHs.mTargetKey;
                        this.mIq.mQF.enterType = 1;
                        this.mIq.b = System.currentTimeMillis();
                    }
                }
                this.B = false;
                this.P = oVar.mHs.mTargetKey;
                this.Q = this.P;
                this.ab = oVar.mHs.mCover;
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
                JSONObject P = com.kascend.chushou.d.e.P("_fromView", str, "_sc", oVar.mHs.mSC);
                com.kascend.chushou.toolkit.a.c.a(this.w, P);
                if (this.mHW != null) {
                    this.mHW.a();
                    this.mHW.a(this.P);
                }
                if (this.mHS != null) {
                    this.mHS.a((PlayUrl) null);
                    this.mHS.f();
                    if (this.mHS.c() != null) {
                        this.mHS.c().clear();
                    }
                    this.mHS.i.clear();
                }
                if (this.mHQ != null) {
                    this.mHQ.j();
                }
                a(P.toString(), false);
                return;
            }
            tv.chushou.zues.utils.g.Kz(a.i.str_same_room);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dEh() {
        FullRoomInfo dEL;
        String str;
        RoomInfo roomInfo;
        if (dEn()) {
            str = null;
            dEL = null;
        } else {
            dEL = this.mHS.dEL();
            str = (dEL == null || (roomInfo = dEL.mRoominfo) == null) ? null : roomInfo.mGameId;
        }
        return !this.L && (dEL == null || h.isEmpty(str));
    }

    @Subscribe
    public void onMessageEvent(i iVar) {
        if (!isFinishing() && iVar.a != 21 && iVar.a != 22) {
            if (iVar.a == 0 && (iVar.b instanceof Boolean)) {
                if (((Boolean) iVar.b).booleanValue() && !isFinishing()) {
                    w();
                    if (this.mHQ != null) {
                        this.mHQ.f();
                    }
                }
            } else if (iVar.a == 46) {
                if ((iVar.b instanceof String) && this.mHQ != null) {
                    this.mHQ.c((String) iVar.b);
                }
            } else if (iVar.a == 54) {
                if (iVar.b instanceof String) {
                    this.mIj.a((String) iVar.b);
                }
            } else if (iVar.a == 55) {
                if (this.mHQ != null) {
                    this.mHQ.O();
                }
            } else if (iVar.a == 56 && this.mHQ != null) {
                this.mHQ.P();
            }
        }
    }

    @Subscribe
    public void onRefreshSubscribeEvent(m mVar) {
        if (isFinishing() && this.mHS != null && this.mHS.dEO() != null) {
            RoomInfo dEO = this.mHS.dEO();
            if (mVar.a(dEO.mCreatorUID, dEO.mRoomID)) {
                dEO.mIsSubscribed = mVar.c;
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
        if (this.m || this.mHN == null || this.mHO == null) {
            R();
        }
        if (this.mHW != null) {
            this.mHW.d();
        }
        if (!dEn()) {
            if (this.mIb != null && !this.mIb.c()) {
                this.mIb.a();
            }
            v();
            if (this.mHS != null && this.mHS.dEL() != null && this.mHS.dEL().cycleLiveRoomInfo != null && !h.isEmpty(this.mHS.dEL().cycleLiveRoomInfo.roomId)) {
                u();
            }
        }
        super.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.view.base.BaseActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        tv.chushou.zues.utils.e.e(this.v, MissionEvent.MESSAGE_DESTROY);
        if (this.mHS != null && this.mHS.dEL() != null && this.mHS.dEL().cycleLiveRoomInfo != null && !h.isEmpty(this.mHS.dEL().cycleLiveRoomInfo.eventName)) {
            j.dEf().a(this.P + dEx());
        }
        if ("2".equals(this.mIo) && this.mIq != null && this.mIq.mQF != null) {
            this.mIq.mQF.time = System.currentTimeMillis() - this.mIq.b;
            this.mIq.a();
            this.mIq.b();
        }
        this.mIi.d();
        this.mIj.b();
        this.mIk.b();
        O();
        this.ag = null;
        a = null;
        if (this.mIv != null) {
            this.mIv.cg(null);
            this.mIv = null;
        }
        if (this.mIb != null) {
            this.mIb.d();
            this.mIb = null;
        }
        if (this.mHW != null) {
            this.mHW.c();
            this.mHW = null;
        }
        if (this.mHS != null) {
            this.mHS.mJy = null;
            this.mHS.mJx = null;
        }
        if (this.mHS != null) {
            this.mHS.b();
            this.mHS = null;
        }
        this.mHL = null;
        this.mHQ = null;
        this.mHR = null;
        this.mHU = null;
        this.T = null;
        this.U = null;
        this.mHV = null;
        this.byt = null;
        this.mHX = null;
        this.mHY = null;
        this.mHZ = null;
        this.Z = null;
        this.mIa = null;
        if (this.mIf != null && this.mIf.isHeld()) {
            this.mIf.release();
            this.mIf = null;
        }
        if (this.mIu != null) {
            unregisterReceiver(this.mIu);
            this.mIu = null;
        }
        h.dRP();
        tv.chushou.zues.a.a.ch(this);
        this.mIr.dispose();
        this.mIk.b();
        this.mIl.b();
        this.mIi.d();
        this.mIj.b();
        this.mIn.b();
        super.onDestroy();
        System.gc();
    }

    @Subscribe
    public void onSendGameGiftEvent(n nVar) {
        if (!isFinishing() && this.mHQ != null) {
            this.mHQ.a(nVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.view.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        tv.chushou.zues.utils.e.d(this.v, MissionEvent.MESSAGE_PAUSE);
        if (this.mIb != null) {
            this.mIb.b();
        }
        if (this.mHW != null) {
            this.mHW.b(false);
        }
        k();
        this.m = true;
        super.onPause();
    }

    @Override // android.app.Activity
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.mHQ != null ? this.mHQ.a(motionEvent) : super.onTouchEvent(motionEvent);
    }

    public void c() {
        if ("1".equals(this.R)) {
            j.dEf().a(this.P + dEx());
        } else {
            j.dEf().b(this.P);
        }
    }

    private void a(boolean z, boolean z2) {
        int i = 0;
        tv.chushou.zues.utils.e.i(this.v, "startLoadingVideo <------------- mbPrepareingVideo = " + this.K);
        if (this.mHN != null) {
            this.mHN.setHardwearDecod(com.kascend.chushou.d.h.dDZ().a);
        }
        if (this.mHO != null) {
            this.mHO.setHardwearDecod(com.kascend.chushou.d.h.dDZ().a);
        }
        if (this.mHM != null) {
            this.mHM.setHardwearDecod(com.kascend.chushou.d.h.dDZ().a);
        }
        if (!this.K) {
            if (z && this.mHQ != null) {
                if (!z2) {
                    this.t = null;
                    this.mHQ.e();
                }
            } else if (this.mHQ != null && !z2) {
                this.t = null;
                this.mHQ.H = false;
                RxExecutor.post(null, EventThread.MAIN_THREAD, new Runnable() { // from class: com.kascend.chushou.player.VideoPlayer.7
                    @Override // java.lang.Runnable
                    public void run() {
                        VideoPlayer.this.mHQ.x();
                    }
                });
            }
            this.K = true;
            if (this.mHS != null && this.mHS.dEM() != null) {
                PlayUrl dEM = this.mHS.dEM();
                while (true) {
                    int i2 = i;
                    if (i2 >= dEM.mUrlDetails.size()) {
                        break;
                    }
                    UrlDetails urlDetails = dEM.mUrlDetails.get(i2);
                    if (urlDetails.mUrl.equals(dEM.mSelectedUrl)) {
                        String str = dEM.mUrlDetails.get(i2).mDefinitionType;
                        String str2 = urlDetails.mBitrate;
                    }
                    i = i2 + 1;
                }
            }
            if (z2) {
                if (this.d) {
                    this.mHN.setVideoURI(this.mHL);
                    this.mHN.open();
                    return;
                }
                this.mHO.setVideoURI(this.mHL);
                this.mHO.open();
                return;
            }
            this.mHM.setVideoURI(this.mHL);
            this.mHM.open();
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        try {
            if (motionEvent.getAction() == 0) {
                if (this.mHQ != null && this.mHQ.b(motionEvent)) {
                    return true;
                }
                if ("2".equals(this.mIo) && this.mHQ != null) {
                    this.mHQ.a(motionEvent);
                }
            } else if (this.mHQ != null && this.mHQ.b(motionEvent)) {
                return true;
            }
            return super.dispatchTouchEvent(motionEvent);
        } catch (Exception e) {
            return false;
        }
    }

    @Override // android.support.v7.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.mHQ != null && this.mHQ.a(i, keyEvent)) {
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
        if (this.mHS != null && this.mHS.dEL() != null && this.mHS.dEL().cycleLiveRoomInfo != null && !h.isEmpty(this.mHS.dEL().cycleLiveRoomInfo.roomId)) {
            this.mIh.setVisibility(0);
            this.mIg.setBlur(true);
            this.mIg.i(this.mHS.dEL().cycleLiveRoomInfo.avatar, 0, 0, 0);
            this.mIg.setVisibility(0);
            j.dEf().a(this.P + dEx());
            this.mHL = null;
            R();
            this.Q = this.mHS.dEL().cycleLiveRoomInfo.roomId;
            a(this.P, dEx(), false);
        }
    }

    public void b(boolean z) {
        if (this.mHQ != null) {
            this.mHQ.j(z);
        }
    }

    public void a(boolean z, Uri uri, boolean z2) {
        tv.chushou.zues.utils.e.d(this.v, "loadIfNecessary reload=" + z + " isChangeLines-->" + z2);
        if (this.mHN != null && this.mHO != null) {
            if (uri != null) {
                this.mHL = uri;
            }
            if (z2) {
                this.e = z2;
            }
            this.M = false;
            this.mHT = 0L;
            this.O = 0;
            this.mIv.removeMessages(7);
            if (z) {
                if (z2) {
                    if (!this.d) {
                        this.mHO.setOnActivityCallBack(this.mIz);
                    } else {
                        this.mHN.setOnActivityCallBack(this.mIy);
                    }
                } else if (this.d) {
                    this.mHO.setOnActivityCallBack(this.mIz);
                } else {
                    this.mHN.setOnActivityCallBack(this.mIy);
                }
                this.K = false;
                b(true, z2);
            } else if (!this.J) {
                b(true, z2);
            }
            this.mIv.A(6, 3000L);
        }
    }

    private void b(boolean z, boolean z2) {
        VideoPlayInfo M;
        if ("1".equals(this.R)) {
            M = j.dEf().L(this.P + dEx(), KeepJobService.JOB_CHECK_PERIODIC);
        } else {
            M = j.dEf().M(this.P, KeepJobService.JOB_CHECK_PERIODIC);
        }
        if (M != null) {
            a(z, z2);
        } else if ("1".equals(this.R)) {
            a(this.P, dEx(), false);
        } else {
            aY(this.P, false);
        }
    }

    public tv.chushou.common.player.a dEi() {
        return this.mHM;
    }

    public tv.chushou.common.player.a dEj() {
        return this.mHN;
    }

    public tv.chushou.common.player.a dEk() {
        return this.mHO;
    }

    public void a(tv.chushou.common.player.a aVar) {
        this.mHM = aVar;
    }

    public b dEl() {
        return this.mHS;
    }

    public com.kascend.chushou.widget.a.b dEm() {
        return this.mHW;
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
        FullRoomInfo dEL;
        this.r = -1L;
        if (this.s != -1 && this.s != 0) {
            this.r = this.s;
            this.s = -1L;
        }
        if (dEn() && this.mHM != null && this.mHM.getPlayState() == 4) {
            this.r = this.mHM.getCurrentPos();
        }
        this.av = false;
        tv.chushou.zues.utils.e.d(this.v, "screenChange()<-----");
        tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard(this);
        if (str != null) {
            this.R = str;
        }
        if (!this.C || !z3 || "3".equals(this.R) || this.mHS == null || (dEL = this.mHS.dEL()) == null || dEL.mRoominfo == null || dEL.mRoominfo.mStyle != 1) {
            z5 = false;
        } else {
            z5 = true;
            i = 0;
        }
        if ("2".equals(this.mIo)) {
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
            if (com.kascend.chushou.b.dDS().d == 1) {
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
            ((VideoPlayer) this.w).wy(false);
            ((VideoPlayer) this.w).g(true);
            if (z5) {
                setRequestedOrientation(1);
            } else {
                setRequestedOrientation(6);
            }
            getWindow().addFlags(512);
            getWindow().addFlags(256);
        }
        if (this.mHW == null) {
            this.mHW = new com.kascend.chushou.widget.a.b();
        }
        if (this.mHW != null) {
            this.mHW.a(this.P);
        }
        if (this.R.equals("5")) {
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            if (this.mHQ != null) {
                beginTransaction.remove(this.mHQ);
                this.mHQ = null;
            }
            if (this.mHR != null) {
                beginTransaction.remove(this.mHR);
                this.mHR = null;
            }
            this.mHR = new com.kascend.chushou.view.user.b();
            beginTransaction.add(a.f.fl_fragment, this.mHR);
            beginTransaction.commitAllowingStateLoss();
        } else {
            FragmentTransaction beginTransaction2 = getSupportFragmentManager().beginTransaction();
            if (this.mHQ != null) {
                beginTransaction2.remove(this.mHQ);
                this.mHQ = null;
            }
            if (this.mHR != null) {
                beginTransaction2.remove(this.mHR);
                this.mHR = null;
            }
            if ("2".equals(this.mIo)) {
                this.mHQ = com.kascend.chushou.player.e.e.b(this.ab, z2, this.aq, this.P);
            } else if (1 == i) {
                if (!this.R.equals("3")) {
                    if (z4) {
                        v();
                    }
                    this.mHQ = new com.kascend.chushou.player.d.a();
                    Bundle bundle = new Bundle();
                    bundle.putString("mCover", this.ab);
                    bundle.putBoolean("mInitViewAsync", z2);
                    this.mHQ.setArguments(bundle);
                }
            } else {
                this.mHQ = new com.kascend.chushou.player.d.b();
                Bundle bundle2 = new Bundle();
                if (z5) {
                    i = 1;
                }
                bundle2.putInt("mExtraOrientation", i);
                bundle2.putString("mViewType", this.R);
                this.mHQ.setArguments(bundle2);
            }
            beginTransaction2.add(a.f.fl_fragment, this.mHQ);
            beginTransaction2.commitAllowingStateLoss();
            this.H = true;
        }
        tv.chushou.zues.utils.e.d(this.v, "screenChange()----->");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dEn() {
        return this.R != null && this.R.equals("3");
    }

    private void R() {
        if (this.mHQ != null) {
            this.mHQ.mMN = null;
        }
        if (this.mHM != null) {
            this.mHM.release();
            this.mHM = null;
            this.K = false;
        }
        if (this.mHN != null) {
            this.mHN.release();
            this.mHN = null;
        }
        if (this.mHO != null) {
            this.mHO.release();
            this.mHO = null;
        }
        if (this.mHP != null) {
            this.mHP.c();
        }
        this.d = false;
        this.e = false;
        this.M = false;
        this.mHP = new c();
        this.mHN = this.mHP.dER();
        this.mHN.setOnActivityCallBack(this.mIy);
        this.mHO = this.mHP.dES();
        this.mHO.setOnActivityCallBack(this.mIz);
        if (!this.d) {
            this.mHM = this.mHN;
        } else {
            this.mHM = this.mHO;
        }
        if (this.mHQ != null) {
            this.mHQ.mMN = this.mHM;
        }
    }

    public void j() {
        if (this.mHM != null) {
            this.mHM.pause();
            this.mHM.stop();
            this.mHM.release();
            this.mHM = null;
        }
        if (this.mHN != null) {
            this.mHN.stop();
            this.mHN.release();
            this.mHN = null;
        }
        if (this.mHO != null) {
            this.mHO.stop();
            this.mHO.release();
            this.mHO = null;
        }
        if (this.mHP != null) {
            this.mHP.c();
        }
    }

    public void k() {
        tv.chushou.common.player.a aVar = this.mHM;
        if (aVar != null) {
            aVar.pause();
            aVar.stop();
        }
        tv.chushou.common.player.a aVar2 = this.mHN;
        if (aVar2 != null) {
            aVar2.stop();
        }
        tv.chushou.common.player.a aVar3 = this.mHO;
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
            if (this.mHQ != null) {
                this.mHQ.s();
            }
        } else if (this.mIv != null) {
            this.mIv.b(this.mIv.Ks(3), 20L);
        }
    }

    private void b(final String str, String str2) {
        com.kascend.chushou.c.c.dDV().a(new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.VideoPlayer.8
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
                    VideoPlayer.this.dEv().a(fullRoomInfo.mBangMap);
                    if (h.isEmpty(fullRoomInfo.mRoominfo.mRoomID)) {
                        fullRoomInfo.mRoominfo.mRoomID = VideoPlayer.this.P;
                    }
                    if (!h.isEmpty(fullRoomInfo.mGeneralTabGifts)) {
                        com.kascend.chushou.d.e.a(VideoPlayer.this.mIr, new ArrayList(fullRoomInfo.mGeneralTabGifts));
                    }
                    if (VideoPlayer.this.mHS != null) {
                        VideoPlayer.this.mHS.a(fullRoomInfo);
                    }
                    VideoPlayer.this.L = false;
                    if (VideoPlayer.this.B) {
                        if (VideoPlayer.this.C && !"3".equals(VideoPlayer.this.R) && fullRoomInfo != null && fullRoomInfo.mRoominfo != null && fullRoomInfo.mRoominfo.mStyle == 1 && !h.isEmpty(fullRoomInfo.mRoominfo.mGameId)) {
                            z = true;
                        }
                        if (!z) {
                            if (VideoPlayer.this.mHQ != null) {
                                VideoPlayer.this.mHQ.a(VideoPlayer.this.mHS);
                            }
                            if (!h.isEmpty(fullRoomInfo.mRoominfo.mGameId)) {
                                VideoPlayer.this.S();
                            } else {
                                if (VideoPlayer.this.mHS != null) {
                                    VideoPlayer.this.mHS.f = null;
                                }
                                VideoPlayer.this.S();
                            }
                        } else {
                            VideoPlayer.this.a(1, "1", true);
                            if (VideoPlayer.this.mHQ != null) {
                                VideoPlayer.this.mHQ.a(VideoPlayer.this.mHS);
                            }
                        }
                    } else {
                        if (h.isEmpty(fullRoomInfo.mRoominfo.mGameId)) {
                            if (VideoPlayer.this.mHS != null) {
                                VideoPlayer.this.mHS.f = null;
                            }
                            VideoPlayer.this.a(1, "1");
                        } else {
                            VideoPlayer.this.a(1, "1", true);
                        }
                        if (VideoPlayer.this.mHQ != null) {
                            VideoPlayer.this.mHQ.a(VideoPlayer.this.mHS);
                        }
                    }
                    if (VideoPlayer.this.mHS != null && !VideoPlayer.this.mHS.m()) {
                        if (VideoPlayer.this.mIb != null) {
                            VideoPlayer.this.mIb.d();
                            VideoPlayer.this.mIb = null;
                        }
                        VideoPlayer.this.mIb = new com.kascend.chushou.toolkit.d(900000L, VideoPlayer.this.mIe, VideoPlayer.this.mIv);
                        VideoPlayer.this.mIb.a();
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
        if (this.mHS != null) {
            this.mHS.a((FullRoomInfo) null);
        }
        this.L = false;
        c(str, i);
        if (this.mHM != null) {
            this.mHM.stop();
        }
        if (this.mHN != null) {
            this.mHN.stop();
        }
        if (this.mHO != null) {
            this.mHO.stop();
        }
    }

    public void l() {
        tv.chushou.zues.utils.e.d(this.v, "retryGetPlayList");
        c();
        if (dEn()) {
            aY(this.P, false);
        } else {
            a(this.P, dEx(), false);
        }
    }

    public void m() {
        a(this.ag, false);
    }

    private void a(final String str, String str2, boolean z) {
        this.J = true;
        VideoPlayInfo L = j.dEf().L(str + str2, KeepJobService.JOB_CHECK_PERIODIC);
        if (L != null) {
            a((ArrayList) L.mPlayUrls);
            this.J = false;
        } else if (z) {
            ParserRet fL = com.kascend.chushou.player.c.a.dET().fL(str, str2);
            if (fL.mRc != 0) {
                tv.chushou.zues.utils.e.e(this.v, "getPlayUrlSync fail, try to getPlaylist");
                a(str, str2, false);
                return;
            }
            a(fL, str);
        } else {
            com.kascend.chushou.player.c.a.dET().a(str, str2, new a.InterfaceC0799a() { // from class: com.kascend.chushou.player.VideoPlayer.9
                @Override // com.kascend.chushou.player.c.a.InterfaceC0799a
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
        VideoPlayInfo M = j.dEf().M(str, KeepJobService.JOB_CHECK_PERIODIC);
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
                ParserRet aZ = com.kascend.chushou.player.c.a.dET().aZ(str, equals);
                if (aZ.mRc != 0) {
                    tv.chushou.zues.utils.e.e(this.v, "getVideoPlayUrlSync fail, try to getVideoPlaylist");
                    aY(str, false);
                    return;
                }
                a(aZ, str);
                return;
            }
            com.kascend.chushou.player.c.a.dET().a(str, new a.InterfaceC0799a() { // from class: com.kascend.chushou.player.VideoPlayer.10
                @Override // com.kascend.chushou.player.c.a.InterfaceC0799a
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
                if (this.mHS.f == null) {
                    this.mHS.f = new ArrayList<>();
                }
                this.mHS.f.clear();
                this.mHS.f.addAll(arrayList);
                if ("1".equals(this.R)) {
                    j.dEf().a(str + dEx(), arrayList);
                } else {
                    j.dEf().t(str, arrayList);
                }
                a(arrayList);
                return;
            }
            if (this.mHS != null) {
                this.mHS.f = null;
            }
            if (this.mIv != null) {
                Message Ks = this.mIv.Ks(5);
                Ks.arg1 = 2;
                Ks.arg2 = parserRet.mRc;
                this.mIv.R(Ks);
            }
        }
    }

    private void c(String str, int i) {
        s();
        if (this.mHW != null) {
            this.mHW.a();
        }
        if (h.isEmpty(str)) {
            str = getString(a.i.str_load_data_failed);
        }
        a(str, i);
    }

    public void n() {
        if (this.mHZ != null && this.byt != null && this.mIa != null) {
            this.mHZ.setVisibility(0);
            this.byt.setVisibility(8);
            this.mIa.setVisibility(8);
        }
    }

    public void o() {
        if (this.mIg != null && this.mIg.getVisibility() == 0) {
            this.mIg.yE(0);
            this.mIg.setVisibility(8);
        }
    }

    public void p() {
        if (this.mIh != null && this.mIh.getVisibility() == 0) {
            this.mIh.setVisibility(8);
        }
    }

    public void q() {
        this.av = true;
    }

    protected void r() {
        this.mHZ.setVisibility(8);
        this.mIa.setVisibility(0);
        this.byt.setVisibility(0);
        if (this.mHV != null) {
            this.T.setVisibility(8);
            this.mHV.setVisibility(0);
            this.U.setText(getString(a.i.str_dialog_loading_content));
            this.U.setVisibility(8);
        }
    }

    protected void a(String str, int i) {
        this.mHZ.setVisibility(8);
        this.mIa.setVisibility(0);
        this.byt.setVisibility(0);
        if (this.mHV != null) {
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
                            com.kascend.chushou.c.c.dDV().b(new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.VideoPlayer.11.1
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
                            }, VideoPlayer.this.P, (String) null, VideoPlayer.this.mHS.h);
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
            this.mHV.setVisibility(8);
            this.mIh.setVisibility(8);
        }
    }

    public void s() {
        if (this.mIv != null) {
            this.mIv.removeMessages(1);
        }
    }

    private void a(ArrayList<PlayUrl> arrayList) {
        boolean z;
        if (this.mHS.f == null) {
            this.mHS.f = new ArrayList<>();
        }
        this.mHS.f.clear();
        this.mHS.f.addAll(arrayList);
        if (com.kascend.chushou.d.e.b() && !"4".equals(this.aq)) {
            int c = com.kascend.chushou.d.e.c();
            if (c == -1) {
                b(arrayList);
                return;
            } else if (this.mIw) {
                this.mIw = false;
                if (c == 0) {
                    this.mHS.d = false;
                    f(arrayList, true);
                    return;
                }
                if (this.mHS != null && this.mHS.f != null) {
                    Iterator<PlayUrl> it = this.mHS.f.iterator();
                    while (it.hasNext()) {
                        if ("2".equals(it.next().mType)) {
                            z = true;
                            break;
                        }
                    }
                }
                z = false;
                this.mHS.d = z;
                f(arrayList, true);
                return;
            } else {
                if (this.mHS.e) {
                    this.mHS.d = !this.mHS.d;
                    this.mHS.e = false;
                    this.mIx = true;
                } else if ("4".equals(this.aq)) {
                    this.mHS.d = true;
                }
                f(arrayList, true);
                return;
            }
        }
        if (this.mHS.e) {
            this.mHS.d = !this.mHS.d;
            this.mHS.e = false;
            this.mIx = true;
        } else if ("4".equals(this.aq)) {
            this.mHS.d = true;
        }
        f(arrayList, true);
    }

    private void b(ArrayList<PlayUrl> arrayList) {
        if ("1".equals(this.R)) {
            if ("2".equals(this.mIo)) {
                d(false, arrayList);
            } else if (this.mHQ != null) {
                this.mHQ.f(arrayList, false);
            }
        } else if (this.mHQ != null) {
            this.mHQ.f(arrayList, false);
        }
    }

    public void c(boolean z) {
        this.mHS.d = false;
        com.kascend.chushou.d.e.a(0);
        ArrayList<PlayUrl> arrayList = this.mHS.f;
        if (!h.isEmpty(arrayList)) {
            if (z) {
                f(arrayList, false);
                if (this.mIv != null) {
                    this.mIv.Kq(2);
                    return;
                }
                return;
            }
            f(arrayList, true);
        }
    }

    public void d(boolean z) {
        this.mHS.d = true;
        com.kascend.chushou.d.e.a(1);
        ArrayList<PlayUrl> arrayList = this.mHS.f;
        if (!h.isEmpty(arrayList)) {
            if (z) {
                f(arrayList, false);
                if (this.mIv != null) {
                    this.mIv.Kq(2);
                    return;
                }
                return;
            }
            f(arrayList, true);
        }
    }

    @Subscribe
    public void onNotifyEvent(com.kascend.chushou.b.a.a.j jVar) {
        if (!isFinishing() && jVar.a == 1 && !"5".equals(this.R) && !dEh()) {
            tv.chushou.zues.utils.e.d(this.v, "onNetworkChangeEvent 3G=" + com.kascend.chushou.b.dDS().b + "  wifi=" + com.kascend.chushou.b.dDS().a);
            if (com.kascend.chushou.d.e.b() && !"4".equals(this.aq)) {
                if (com.kascend.chushou.d.e.c() == -1) {
                    if (this.mHQ != null) {
                        this.mHQ.e(false);
                    }
                    if ("1".equals(this.R)) {
                        if ("2".equals(this.mIo)) {
                            d(true, null);
                            return;
                        } else if (this.mHQ != null) {
                            this.mHQ.f(this.mHS.f, true);
                            return;
                        } else {
                            return;
                        }
                    } else if (this.mHQ != null) {
                        this.mHQ.f(this.mHS.f, true);
                        return;
                    } else {
                        return;
                    }
                }
                RxExecutor.postDelayed(this.mIr, EventThread.MAIN_THREAD, 10L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.VideoPlayer.12
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!VideoPlayer.this.isFinishing() && com.kascend.chushou.b.dDS().b && !com.kascend.chushou.b.dDS().a) {
                            tv.chushou.zues.utils.g.c(VideoPlayer.this.w, VideoPlayer.this.getString(a.i.str_monet_notify));
                        }
                    }
                });
            } else if (com.kascend.chushou.b.dDS().a || com.kascend.chushou.b.dDS().b) {
                t();
                if (this.mIv != null) {
                    this.mIv.Kq(2);
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
            if (this.mHS.d) {
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
            String d = com.kascend.chushou.d.h.dDZ().d();
            String str3 = h.isEmpty(d) ? "2" : d;
            if (this.mHS.d) {
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
                if (this.mHS != null) {
                    this.mHS.a(playUrl2);
                    if (this.mIv != null) {
                        Message Ks = this.mIv.Ks(5);
                        Ks.arg1 = 1;
                        this.mIv.R(Ks);
                    }
                }
                String b = com.kascend.chushou.player.c.a.b(playUrl2);
                if (!h.isEmpty(b)) {
                    this.mHL = Uri.parse(b);
                    if (this.mIx) {
                        this.mIx = false;
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (z && this.mHM != null) {
                        a(false, z2);
                    }
                }
            }
        }
    }

    public void d(final boolean z, ArrayList<PlayUrl> arrayList) {
        if (this.mIc == null || this.mIc.a <= 0) {
            this.mIc = com.kascend.chushou.view.b.a.a.dGe();
            this.mIc.a(new a.InterfaceC0818a() { // from class: com.kascend.chushou.player.VideoPlayer.13
                @Override // com.kascend.chushou.view.b.a.a.InterfaceC0818a
                public void a(int i) {
                    if (i == a.f.tv_play_video) {
                        VideoPlayer.this.mIc.dismissAllowingStateLoss();
                        VideoPlayer.this.c(z);
                    } else if (i == a.f.tv_play_audio) {
                        VideoPlayer.this.mIc.dismissAllowingStateLoss();
                        VideoPlayer.this.d(z);
                    } else if (i == a.f.iv_close) {
                        VideoPlayer.this.finish();
                    } else {
                        if (i == a.f.tv_union_proxy) {
                        }
                    }
                }
            });
            this.mIc.show(getSupportFragmentManager(), "showRoom");
        }
    }

    public void t() {
        if (this.mIc != null) {
            this.mIc.dismissAllowingStateLoss();
        }
        if (this.mHQ != null) {
            this.mHQ.v();
        }
    }

    public void u() {
        com.kascend.chushou.c.c.dDV().c(this.P, new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.VideoPlayer.16
            @Override // com.kascend.chushou.c.b
            public void a() {
            }

            @Override // com.kascend.chushou.c.b
            public void a(String str, JSONObject jSONObject) {
                if (!VideoPlayer.this.isFinishing()) {
                    ParserRet dK = com.kascend.chushou.c.e.dK(jSONObject);
                    if (dK.mRc == 0 && dK.mData != null) {
                        CycleLiveRoomInfo cycleLiveRoomInfo = (CycleLiveRoomInfo) dK.mData;
                        if (VideoPlayer.this.mHS != null && cycleLiveRoomInfo != null && !h.isEmpty(cycleLiveRoomInfo.roomId)) {
                            FullRoomInfo dEL = VideoPlayer.this.mHS.dEL();
                            if (dEL.cycleLiveRoomInfo == null) {
                                dEL.cycleLiveRoomInfo = cycleLiveRoomInfo;
                                VideoPlayer.this.d();
                            } else if (dEL.cycleLiveRoomInfo != null && !cycleLiveRoomInfo.roomId.equals(dEL.cycleLiveRoomInfo.roomId)) {
                                dEL.cycleLiveRoomInfo.copyCycleLiveRoomInfo(cycleLiveRoomInfo);
                                VideoPlayer.this.d();
                            } else {
                                dEL.cycleLiveRoomInfo.copyCycleLiveRoomInfo(cycleLiveRoomInfo);
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
        if (this.mHQ != null) {
            this.mHQ.N();
        }
    }

    public void v() {
        com.kascend.chushou.c.c.dDV().a(this.P, new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.VideoPlayer.17
            @Override // com.kascend.chushou.c.b
            public void a() {
            }

            @Override // com.kascend.chushou.c.b
            public void a(String str, JSONObject jSONObject) {
                if (!VideoPlayer.this.isFinishing()) {
                    ParserRet dL = com.kascend.chushou.c.e.dL(jSONObject);
                    if (dL.mRc == 0 && dL.mData != null) {
                        PkNotifyInfo pkNotifyInfo = (PkNotifyInfo) dL.mData;
                        VideoPlayer.this.mIm.b = VideoPlayer.this.P;
                        if (pkNotifyInfo != null) {
                            VideoPlayer.this.mIm.mMO = pkNotifyInfo;
                            if (VideoPlayer.this.mHQ != null) {
                                VideoPlayer.this.mHQ.a(pkNotifyInfo, VideoPlayer.this.P);
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
        if (this.mHU != null) {
            this.mHU.release();
            this.mHU = null;
        }
        com.kascend.chushou.c.c.dDV().a(this.P, new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.VideoPlayer.18
            @Override // com.kascend.chushou.c.b
            public void a() {
            }

            @Override // com.kascend.chushou.c.b
            public void a(String str, JSONObject jSONObject) {
                if (!VideoPlayer.this.isFinishing()) {
                    ParserRet dM = com.kascend.chushou.c.e.dM(jSONObject);
                    if (dM.mRc == 0 && dM.mData != null) {
                        RoomExpandInfo roomExpandInfo = (RoomExpandInfo) dM.mData;
                        if (VideoPlayer.this.mHS != null) {
                            VideoPlayer.this.mHS.mJz = roomExpandInfo.mTopWebAdItem;
                            if (VideoPlayer.this.mHS.s == null) {
                                VideoPlayer.this.mHS.s = new ArrayList();
                            }
                            VideoPlayer.this.mHS.s.clear();
                            VideoPlayer.this.mHS.s.addAll(roomExpandInfo.mGiftTopRightIcons);
                            tv.chushou.zues.a.a.post(new i(50, VideoPlayer.this.mHS.mJz));
                        }
                        if (VideoPlayer.this.mHS != null) {
                            VideoPlayer.this.mHS.fh(roomExpandInfo.mExpandNavList);
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
                            VideoPlayer.this.mIi.a(list);
                        }
                        List<com.kascend.chushou.player.ui.h5.c.c> list2 = roomExpandInfo.mLuckList;
                        if (!h.isEmpty(list2)) {
                            VideoPlayer.this.mIj.a(list2);
                        }
                        com.kascend.chushou.player.ui.h5.c.c cVar = roomExpandInfo.mVoteItem;
                        if (cVar != null) {
                            VideoPlayer.this.mIk.a(cVar);
                        }
                        List<com.kascend.chushou.player.ui.h5.c.b> list3 = roomExpandInfo.mInteractH5Item;
                        if (!h.isEmpty(list3)) {
                            VideoPlayer.this.mIn.a(list3);
                        }
                        List<com.kascend.chushou.player.ui.h5.c.b> list4 = roomExpandInfo.mInteractNavItem;
                        if (!h.isEmpty(list4)) {
                            VideoPlayer.this.mIn.a(list4);
                        }
                        VideoPlayer.this.mHU = (PrivilegeInfo) dM.mData1;
                        if (VideoPlayer.this.mHU != null) {
                            tv.chushou.zues.a.a.post(new l());
                        }
                        if (VideoPlayer.this.mHS != null) {
                            VideoPlayer.this.mHS.mJF = roomExpandInfo.mIconConfig;
                            VideoPlayer.this.dEv().a(roomExpandInfo.mIconConfig.bangConfig);
                        }
                        List<SkinConfig> list5 = roomExpandInfo.skinConfig;
                        if (list5 != null && VideoPlayer.this.mHS != null) {
                            VideoPlayer.this.mHS.mJI.clear();
                            int i = 0;
                            while (true) {
                                int i2 = i;
                                if (i2 >= list5.size()) {
                                    break;
                                }
                                SkinConfig skinConfig = list5.get(i2);
                                VideoPlayer.this.mHS.mJI.put(skinConfig.position, skinConfig.resource);
                                i = i2 + 1;
                            }
                            VideoPlayer.this.C();
                        }
                        VideoPlayer.this.a(roomExpandInfo.mIconConfig, VideoPlayer.this.mHS != null ? VideoPlayer.this.mHS.mJI : null);
                        if (roomExpandInfo.mColorMap != null && roomExpandInfo.mColorMap.size() > 0 && com.kascend.chushou.b.dDS().c != null && com.kascend.chushou.b.dDS().c.size() <= 0) {
                            com.kascend.chushou.b.dDS().c.putAll(roomExpandInfo.mColorMap);
                            tv.chushou.zues.a.a.post(new i(52, null));
                        }
                        AutoBang autoBang = roomExpandInfo.mAutoBang;
                        if (autoBang != null && autoBang.currentTime != 0 && autoBang.bangTime != 0) {
                            VideoPlayer.this.dEv().a(autoBang);
                        }
                        if (!h.isEmpty(roomExpandInfo.mRelatedRoomList) && VideoPlayer.this.mHS != null) {
                            VideoPlayer.this.mHS.t = roomExpandInfo.mRelatedRoomList;
                            if (VideoPlayer.this.mHQ != null && VideoPlayer.this.H) {
                                VideoPlayer.this.mHQ.w();
                            }
                        }
                        if (roomExpandInfo.mRoomNewUserInfo != null && roomExpandInfo.mRoomNewUserInfo.mBarrierNoviceGuide && !com.kascend.chushou.d.h.dDZ().k() && VideoPlayer.this.mHQ != null) {
                            VideoPlayer.this.mHQ.J();
                        }
                        if (roomExpandInfo.mRoomNewUserInfo != null && roomExpandInfo.mRoomNewUserInfo.mRewardNoviceGuide && !com.kascend.chushou.d.h.dDZ().l() && VideoPlayer.this.mHQ != null) {
                            VideoPlayer.this.mHQ.K();
                        }
                        if (!h.isEmpty(roomExpandInfo.mShopWindowInfos)) {
                            if (VideoPlayer.this.mHS != null) {
                                if (VideoPlayer.this.mHS.mJG == null) {
                                    VideoPlayer.this.mHS.mJG = new ArrayList();
                                }
                                VideoPlayer.this.mHS.mJG.addAll(roomExpandInfo.mShopWindowInfos);
                            }
                            if (VideoPlayer.this.mHQ != null) {
                                VideoPlayer.this.mHQ.L();
                            }
                        }
                        VideoPlayer.this.mIm.b = VideoPlayer.this.P;
                        if (roomExpandInfo.mPkNotifyInfo != null) {
                            VideoPlayer.this.mIm.mMO = roomExpandInfo.mPkNotifyInfo;
                            if (VideoPlayer.this.mHQ != null) {
                                VideoPlayer.this.mHQ.a(roomExpandInfo.mPkNotifyInfo, VideoPlayer.this.P);
                            }
                        } else {
                            VideoPlayer.this.mIm.mMO = null;
                        }
                        if (roomExpandInfo.mTrumpetPocket != null && VideoPlayer.this.mHS != null) {
                            VideoPlayer.this.mHS.mJH = roomExpandInfo.mTrumpetPocket;
                            if (VideoPlayer.this.mHQ != null) {
                                VideoPlayer.this.mHQ.M();
                            }
                        }
                        if (!h.isEmpty(roomExpandInfo.hotwordContentList)) {
                            if (VideoPlayer.this.mHS != null) {
                                if (VideoPlayer.this.mHS.w == null) {
                                    VideoPlayer.this.mHS.w = new ArrayList();
                                }
                                VideoPlayer.this.mHS.w.clear();
                                VideoPlayer.this.mHS.w.addAll(roomExpandInfo.hotwordContentList);
                            }
                            if (VideoPlayer.this.mHQ != null) {
                                VideoPlayer.this.mHQ.b(roomExpandInfo.hotwordContentList);
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
        }, this.ag, this.mIo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U() {
        if (!h.isEmpty(com.kascend.chushou.a.a.dDT().mHk)) {
            StringBuilder sb = new StringBuilder();
            if (com.kascend.chushou.a.a.dDT().mHk.contains(com.kascend.chushou.a.a.f)) {
                if (sb.length() > 0) {
                    sb.append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                sb.append(com.kascend.chushou.a.a.f);
            }
            if (com.kascend.chushou.a.a.dDT().mHk.contains(com.kascend.chushou.a.a.g)) {
                if (sb.length() > 0) {
                    sb.append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                sb.append(com.kascend.chushou.a.a.g);
            }
            if (com.kascend.chushou.a.a.dDT().mHk.contains(com.kascend.chushou.a.a.i)) {
                if (sb.length() > 0) {
                    sb.append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                sb.append(com.kascend.chushou.a.a.i);
            }
            if (com.kascend.chushou.a.a.dDT().mHk.contains(com.kascend.chushou.a.a.h)) {
                if (sb.length() > 0) {
                    sb.append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                sb.append(com.kascend.chushou.a.a.h);
            }
            if (com.kascend.chushou.a.a.dDT().mHk.contains(com.kascend.chushou.a.a.j)) {
                if (sb.length() > 0) {
                    sb.append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                sb.append(com.kascend.chushou.a.a.j);
            }
            if (com.kascend.chushou.a.a.dDT().mHk.contains(com.kascend.chushou.a.a.l)) {
                if (sb.length() > 0) {
                    sb.append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                sb.append(com.kascend.chushou.a.a.l);
            }
            if (com.kascend.chushou.a.a.dDT().mHk.contains(com.kascend.chushou.a.a.m)) {
                if (sb.length() > 0) {
                    sb.append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                sb.append(com.kascend.chushou.a.a.m);
            }
            if (sb.length() != 0) {
                com.kascend.chushou.a.a.dDT().a(sb.toString(), this.P, new a.c() { // from class: com.kascend.chushou.player.VideoPlayer.19
                    @Override // com.kascend.chushou.a.a.c
                    public void a(List<ListItem> list) {
                        if (VideoPlayer.this.mHS != null && list != null) {
                            int i = 0;
                            while (true) {
                                int i2 = i;
                                if (i2 >= list.size()) {
                                    break;
                                }
                                if (list.get(i2).mAdExtraInfo != null) {
                                    if (com.kascend.chushou.a.a.f.equals(list.get(i2).mAdExtraInfo.mCode)) {
                                        VideoPlayer.this.mHS.mJy = list.get(i2);
                                    } else if (com.kascend.chushou.a.a.g.equals(list.get(i2).mAdExtraInfo.mCode)) {
                                        VideoPlayer.this.mHS.mJx = list.get(i2);
                                    } else if (com.kascend.chushou.a.a.i.equals(list.get(i2).mAdExtraInfo.mCode)) {
                                        VideoPlayer.this.mHS.mJA = list.get(i2);
                                    } else if (com.kascend.chushou.a.a.h.equals(list.get(i2).mAdExtraInfo.mCode)) {
                                        VideoPlayer.this.mHS.mJB = list.get(i2);
                                    } else if (com.kascend.chushou.a.a.j.equals(list.get(i2).mAdExtraInfo.mCode)) {
                                        VideoPlayer.this.mHS.mJE = list.get(i2);
                                    } else if (com.kascend.chushou.a.a.l.equals(list.get(i2).mAdExtraInfo.mCode)) {
                                        VideoPlayer.this.mHS.mJC = list.get(i2);
                                    } else if (com.kascend.chushou.a.a.m.equals(list.get(i2).mAdExtraInfo.mCode)) {
                                        VideoPlayer.this.mHS.mJD = list.get(i2);
                                    }
                                }
                                i = i2 + 1;
                            }
                            if (VideoPlayer.this.mHQ != null) {
                                VideoPlayer.this.mHQ.H();
                            }
                        }
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str, String str2) {
        if (dEn()) {
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
                this.mHY.setSystemUiVisibility(i);
                return;
            }
            this.mHY.setSystemUiVisibility(1792);
        }
    }

    public void f(boolean z) {
        Window window;
        View decorView;
        if (com.kascend.chushou.b.dDS().d != 1 && (window = getWindow()) != null && (decorView = window.getDecorView()) != null) {
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
        if (this.mHQ != null) {
            this.mHQ.a(i, i2, intent);
        }
    }

    public Uri dEo() {
        return this.mHL;
    }

    @Override // com.kascend.chushou.view.base.BaseActivity
    protected int y() {
        return 0;
    }

    public void wy(boolean z) {
        if (this.mHY != null) {
            this.mHY.nQE = z;
        }
    }

    public void dEp() {
        if (this.mHY != null) {
            this.mHY.dEp();
        }
    }

    public boolean dEq() {
        return this.ae;
    }

    public void g(boolean z) {
        this.ae = z;
    }

    public void h(boolean z) {
        if (this.mHY != null) {
            this.mHY.setIsTranslucentStatus(z);
        }
    }

    public void z() {
        if (this.mHY != null) {
            this.mHY.dSk();
        }
    }

    @Override // com.kascend.chushou.widget.gifts.RoomSendGiftView.a
    public void A() {
        if (this.mHW != null) {
            this.mHW.b();
        }
        if (this.mHS != null) {
            this.mHS.z = true;
        }
    }

    @Override // com.kascend.chushou.widget.gifts.RoomSendGiftView.a
    public void B() {
        if (this.mHW != null) {
            this.mHW.b();
        }
    }

    public void a(List<ListItem> list) {
        if (this.mHQ != null) {
            this.mHQ.a(list);
        }
    }

    public void a(IconConfig iconConfig, Map<String, SkinConfig.SkinRes> map) {
        if (this.mHQ != null) {
            this.mHQ.a(iconConfig, map);
        }
    }

    public void C() {
        if (this.mHQ != null) {
            this.mHQ.I();
        }
    }

    @Override // com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC0810a
    public void a(int i) {
        if (this.mHQ != null) {
            this.mHQ.a(i);
        }
    }

    @Override // com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC0810a
    public void D() {
        if (!isFinishing() && this.mHQ != null) {
            this.mHQ.D();
        }
    }

    @Override // com.kascend.chushou.player.ui.h5.b.b.a
    public void a(long j) {
        if (!isFinishing() && this.mHQ != null) {
            this.mHQ.a(j);
        }
    }

    @Override // com.kascend.chushou.player.ui.h5.b.b.a
    public void a(com.kascend.chushou.player.ui.h5.c.a aVar) {
        if (aVar != null && this.mHQ != null) {
            this.mHQ.a(aVar);
        }
    }

    @Override // com.kascend.chushou.player.ui.h5.b.b.a
    public void b(int i) {
        if (this.mHQ != null) {
            this.mHQ.b(i);
        }
    }

    @Override // com.kascend.chushou.player.ui.h5.d.a.InterfaceC0809a
    public void b(long j) {
        if (!isFinishing() && this.mHQ != null) {
            this.mHQ.b(j);
        }
    }

    @Override // com.kascend.chushou.player.ui.h5.a.a.InterfaceC0807a
    public void c(int i) {
        if (!isFinishing() && this.mHQ != null) {
            this.mHQ.c(i);
        }
    }

    @Override // com.kascend.chushou.player.ui.h5.d.a.InterfaceC0809a
    public void b(com.kascend.chushou.player.ui.h5.c.a aVar) {
        if (aVar != null && this.mHQ != null) {
            this.mHQ.b(aVar);
        }
    }

    @Override // com.kascend.chushou.player.ui.a.a.InterfaceC0804a
    public void a(IconConfig.Config config) {
        if (this.mHQ != null) {
            this.mHQ.a(config);
        }
    }

    @Override // com.kascend.chushou.player.ui.a.a.InterfaceC0804a
    public void a(BangInfo bangInfo, String str) {
        if (this.mHQ != null) {
            this.mHQ.a(bangInfo, str);
        }
    }

    @Override // com.kascend.chushou.player.ui.a.a.InterfaceC0804a
    public void a(long j, BangInfo bangInfo, String str) {
        if (this.mHQ != null) {
            this.mHQ.a(j, bangInfo, str);
        }
    }

    public com.kascend.chushou.player.ui.h5.redpacket.a dEr() {
        return this.mIi;
    }

    public com.kascend.chushou.player.ui.h5.b.b dEs() {
        return this.mIj;
    }

    public com.kascend.chushou.player.ui.h5.d.a dEt() {
        return this.mIk;
    }

    public com.kascend.chushou.player.ui.h5.a.a dEu() {
        return this.mIn;
    }

    public com.kascend.chushou.player.ui.a.a dEv() {
        return this.mIl;
    }

    public com.kascend.chushou.player.e.a dEw() {
        return this.mIm;
    }

    @Override // com.kascend.chushou.view.base.BaseActivity, android.app.Activity
    public void finish() {
        super.finish();
        if ("3".equals(this.R)) {
            overridePendingTransition(17432576, a.C0794a.commonres_activity_exit_bottom);
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
        RxExecutor.postDelayed(this.mIr, EventThread.MAIN_THREAD, aVar.d, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.VideoPlayer.2
            @Override // java.lang.Runnable
            public void run() {
                if (VideoPlayer.this.mHQ != null) {
                    VideoPlayer.this.mHQ.c(aVar);
                }
            }
        });
    }

    private void e(final com.kascend.chushou.player.ui.h5.c.a aVar) {
        if (!com.kascend.chushou.d.h.dDZ().dEc().contains(aVar.b)) {
            if (aVar.d < 0) {
                aVar.d = 0;
            }
            RxExecutor.postDelayed(this.mIr, EventThread.MAIN_THREAD, aVar.d, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.VideoPlayer.3
                @Override // java.lang.Runnable
                public void run() {
                    if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.mHQ != null) {
                        VideoPlayer.this.mHQ.c(aVar);
                    }
                }
            });
        }
    }

    private String dEx() {
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
                if (VideoPlayer.this.mHX != null && !VideoPlayer.this.isFinishing()) {
                    VideoPlayer.n = VideoPlayer.this.mHX.getStreamVolume(3);
                }
                if (!VideoPlayer.this.isFinishing() && (VideoPlayer.this.mHQ instanceof f)) {
                    ((f) VideoPlayer.this.mHQ).ab();
                }
            }
        }
    }

    public String a(String str) {
        HashMap hashMap = new HashMap(tv.chushou.zues.utils.d.St(str));
        if ("1".equals(this.R)) {
            hashMap.put("roomId", this.P);
        } else if ("3".equals(this.R)) {
            hashMap.put("videoId", this.P);
        }
        return tv.chushou.zues.utils.d.toJson(hashMap);
    }

    public boolean dEy() {
        if (this.mHQ instanceof com.kascend.chushou.player.d.a) {
            return ((com.kascend.chushou.player.d.a) this.mHQ).dFp();
        }
        if (this.mHQ instanceof com.kascend.chushou.player.e.e) {
            return true;
        }
        return false;
    }
}

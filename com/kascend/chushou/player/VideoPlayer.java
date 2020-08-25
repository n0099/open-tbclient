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
    private c nHG;
    b nHJ;
    public PrivilegeInfo nHK;
    com.kascend.chushou.widget.a.b nHM;
    private KPSwitchRootRelativeLayout nHO;
    private FrameLayout nHP;
    private ImageView nHQ;
    private LinearLayout nHR;
    private com.kascend.chushou.toolkit.d nHS;
    com.kascend.chushou.view.b.a.a nHT;
    private FrescoThumbnailView nHW;
    private FrameLayout nHX;
    public com.kascend.chushou.player.feedback.a nIf;
    private a nIh;
    private CSTVWifiReceiver nIi;
    private boolean B = true;
    private boolean C = false;
    private Uri nHC = null;
    private tv.chushou.common.player.a nHD = null;
    public tv.chushou.common.player.a nHE = null;
    public tv.chushou.common.player.a nHF = null;
    public boolean d = false;
    public boolean e = false;
    private e nHH = null;
    private boolean H = false;
    private com.kascend.chushou.view.user.b nHI = null;
    private boolean J = false;
    private boolean K = false;
    private boolean L = false;
    private boolean M = false;
    private long N = 0;
    private int O = 0;
    public boolean g = false;
    private ImageView T = null;
    private TextView U = null;
    private AnimationImageView nHL = null;
    private View bJb = null;
    public boolean j = false;
    public float k = 0.0f;
    public float l = 0.0f;
    public boolean m = false;
    public AudioManager nHN = null;
    private d.a nHU = new d.a() { // from class: com.kascend.chushou.player.VideoPlayer.1
        @Override // com.kascend.chushou.toolkit.d.a
        public void a() {
            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.nIj != null) {
                VideoPlayer.this.nIj.Ow(4);
            }
        }
    };
    private boolean ae = false;
    public boolean q = true;
    public long r = -1;
    public long s = -1;
    private PowerManager.WakeLock nHV = null;
    public String t = null;
    private final com.kascend.chushou.player.ui.h5.redpacket.a nHY = new com.kascend.chushou.player.ui.h5.redpacket.a(this);
    private final com.kascend.chushou.player.ui.h5.b.b nHZ = new com.kascend.chushou.player.ui.h5.b.b(this);
    private final com.kascend.chushou.player.ui.h5.d.a nIa = new com.kascend.chushou.player.ui.h5.d.a(this);
    private final com.kascend.chushou.player.ui.a.a nIb = new com.kascend.chushou.player.ui.a.a(this);
    private final com.kascend.chushou.player.e.a nIc = new com.kascend.chushou.player.e.a();
    private final com.kascend.chushou.player.ui.h5.a.a nId = new com.kascend.chushou.player.ui.h5.a.a(this);
    private String nIe = "1";
    private String aq = "2";
    private io.reactivex.disposables.a nIg = new io.reactivex.disposables.a();
    private tv.chushou.zues.c nIj = new tv.chushou.zues.c(new Handler.Callback() { // from class: com.kascend.chushou.player.VideoPlayer.6
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            try {
                if (!VideoPlayer.this.isFinishing()) {
                    switch (message.what) {
                        case 1:
                            VideoPlayer.this.nIj.removeMessages(1);
                            com.kascend.chushou.c.c.dYm().a(VideoPlayer.this.P, VideoPlayer.this.nHJ != null ? VideoPlayer.this.nHJ.h : null, System.currentTimeMillis());
                            VideoPlayer.this.nIj.B(1, VideoPlayer.A);
                            break;
                        case 2:
                            VideoPlayer.this.a(true, (Uri) null, false);
                            break;
                        case 3:
                            VideoPlayer.this.S();
                            break;
                        case 4:
                            if (VideoPlayer.this.nHH != null) {
                                VideoPlayer.this.nHH.a(true);
                            }
                            if (VideoPlayer.this.nHS != null) {
                                VideoPlayer.this.nHS.d();
                                VideoPlayer.this.nHS = null;
                                break;
                            }
                            break;
                        case 5:
                            int i = message.arg1;
                            if (i == 1) {
                                if (VideoPlayer.this.nHH != null) {
                                    VideoPlayer.this.nHH.p();
                                    break;
                                }
                            } else if (i == 2 && VideoPlayer.this.nHH != null) {
                                VideoPlayer.this.nHH.e(message.arg2);
                                break;
                            }
                            break;
                        case 6:
                            if (!com.kascend.chushou.b.dYj().a && !com.kascend.chushou.b.dYj().b && VideoPlayer.this.nHH != null) {
                                VideoPlayer.this.nHH.g(true);
                                break;
                            } else {
                                VideoPlayer.this.c();
                                break;
                            }
                            break;
                        case 7:
                            tv.chushou.zues.utils.e.d(VideoPlayer.this.v, "MSG_BUFFER_DEALY: ");
                            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.nHH != null && VideoPlayer.this.M && !VideoPlayer.this.e) {
                                VideoPlayer.this.nHH.h(true);
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
    private boolean nIk = false;
    private boolean aw = true;
    private boolean nIl = false;
    private tv.chushou.common.player.b nIm = new tv.chushou.common.player.b() { // from class: com.kascend.chushou.player.VideoPlayer.14
        @Override // tv.chushou.common.player.b
        public void dYS() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerACallback onSetVideoViewLayout");
            if (!VideoPlayer.this.isFinishing()) {
                if ((VideoPlayer.this.nHH == null || !VideoPlayer.this.nHH.H) && VideoPlayer.this.nHH != null && !VideoPlayer.this.d) {
                    VideoPlayer.this.nHH.y();
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void Nb(int i) {
            if (!VideoPlayer.this.isFinishing()) {
                if ((VideoPlayer.this.nHH == null || !VideoPlayer.this.nHH.H) && VideoPlayer.this.nHH != null && !VideoPlayer.this.d) {
                    VideoPlayer.this.nHH.g(i);
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void dYT() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerACallback onCompletePlayback");
            if (!VideoPlayer.this.isFinishing()) {
                if (!h.isEmpty(VideoPlayer.this.P)) {
                    j.dYx().a(VideoPlayer.this.P, 0);
                }
                VideoPlayer.this.K = false;
                if (VideoPlayer.this.nIj != null) {
                    VideoPlayer.this.nIj.removeMessages(1);
                }
                if ((VideoPlayer.this.nHH == null || !VideoPlayer.this.nHH.H) && VideoPlayer.this.nHH != null && !VideoPlayer.this.d) {
                    VideoPlayer.this.nIj.removeMessages(7);
                    VideoPlayer.this.M = false;
                    VideoPlayer.this.nHH.z();
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void dYU() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerACallback onVideoRenderingStart");
            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.nHH != null) {
                VideoPlayer.this.nHH.G();
            }
        }

        @Override // tv.chushou.common.player.b
        public void dYV() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerACallback onPreparedPlayback");
            if (!VideoPlayer.this.isFinishing()) {
                if (VideoPlayer.this.nHH == null || !VideoPlayer.this.nHH.H) {
                    VideoPlayer.this.nIj.removeMessages(6);
                    VideoPlayer.this.N = 0L;
                    VideoPlayer.this.O = 0;
                    if (VideoPlayer.this.nHD != null && VideoPlayer.this.nHH != null) {
                        VideoPlayer.this.nHD.setVolume(VideoPlayer.this.nHH.J, VideoPlayer.this.nHH.J);
                    }
                    if (VideoPlayer.this.nHJ != null) {
                        VideoPlayer.this.K = false;
                        FullRoomInfo dZc = VideoPlayer.this.dYF() ? null : VideoPlayer.this.nHJ.dZc();
                        if (VideoPlayer.this.L || dZc != null) {
                            if (VideoPlayer.this.nHJ.e) {
                                VideoPlayer.this.nHJ.e = false;
                                VideoPlayer.this.nHJ.d = !VideoPlayer.this.nHJ.d;
                            }
                            if (VideoPlayer.this.nHH != null) {
                                VideoPlayer.this.c("1", (String) null);
                                if (!VideoPlayer.this.d) {
                                    VideoPlayer.this.nHH.i(true);
                                } else if (VideoPlayer.this.e) {
                                    VideoPlayer.this.e = false;
                                    VideoPlayer.this.nHH.B();
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
                if (VideoPlayer.this.nIj != null) {
                    VideoPlayer.this.nIj.removeMessages(7);
                }
                if (VideoPlayer.this.nIj != null) {
                    VideoPlayer.this.nIj.removeMessages(1);
                }
                if ((VideoPlayer.this.nHH == null || !VideoPlayer.this.nHH.H) && !VideoPlayer.this.dYz()) {
                    if (!"10004".equals(VideoPlayer.this.t)) {
                        if (VideoPlayer.this.nHH != null) {
                            if (VideoPlayer.this.d) {
                                VideoPlayer.this.nHE.stop();
                                VideoPlayer.this.nHE.release();
                                VideoPlayer.this.e = false;
                                VideoPlayer.this.nHH.C();
                            }
                            if (!com.kascend.chushou.b.dYj().a && !com.kascend.chushou.b.dYj().b) {
                                VideoPlayer.this.nHH.g(true);
                            } else if (VideoPlayer.this.d) {
                                VideoPlayer.this.nHH.a(i, true);
                            } else {
                                VideoPlayer.this.nHH.a(i, false);
                            }
                            VideoPlayer.this.c("2", (String) null);
                            return;
                        }
                        return;
                    }
                    dYT();
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void dYW() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerACallback onBufferingStart");
            if (!VideoPlayer.this.isFinishing()) {
                if ((VideoPlayer.this.nHH == null || !VideoPlayer.this.nHH.H) && VideoPlayer.this.nHH != null && !VideoPlayer.this.d) {
                    VideoPlayer.this.nHH.E();
                    VideoPlayer.this.M = true;
                    long currentTimeMillis = System.currentTimeMillis();
                    VideoPlayer.this.nIj.removeMessages(7);
                    if (!VideoPlayer.this.g) {
                        VideoPlayer.y(VideoPlayer.this);
                    }
                    tv.chushou.zues.utils.e.d(VideoPlayer.this.v, "currentTime: -- >" + currentTimeMillis + "  bufferTime-->" + VideoPlayer.this.N + "  bufferCount-->" + VideoPlayer.this.O);
                    if (currentTimeMillis - VideoPlayer.this.N >= 20000 || VideoPlayer.this.O < 2 || VideoPlayer.this.nHH.H) {
                        if (VideoPlayer.this.O == 1) {
                            VideoPlayer.this.N = currentTimeMillis;
                        }
                        VideoPlayer.this.nIj.B(7, 5000L);
                    } else {
                        VideoPlayer.this.nIj.Ow(7);
                    }
                    if (VideoPlayer.this.g) {
                        VideoPlayer.this.g = false;
                    }
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void dYX() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerACallback onBufferingEnd");
            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.nHH != null && !VideoPlayer.this.d) {
                VideoPlayer.this.nIj.removeMessages(7);
                VideoPlayer.this.M = false;
                if (VideoPlayer.this.nHH == null || !VideoPlayer.this.nHH.H) {
                    if (VideoPlayer.this.nHD == null) {
                        VideoPlayer.this.nHH.a(false, true, false);
                    } else {
                        VideoPlayer.this.nHH.a(true, VideoPlayer.this.nHD.getPlayState() == 4, VideoPlayer.this.nHD.getPlayState() == 5);
                    }
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void onPlayerStart() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerACallback onPlayerStart");
            if (!VideoPlayer.this.isFinishing()) {
                if (VideoPlayer.this.nHH == null || !VideoPlayer.this.nHH.H) {
                    if (VideoPlayer.this.nHH != null && !VideoPlayer.this.d) {
                        if (VideoPlayer.this.nHD != null) {
                            VideoPlayer.this.nHH.F();
                            VideoPlayer.this.nHH.a(true, VideoPlayer.this.nHD.getPlayState() == 4, VideoPlayer.this.nHD.getPlayState() == 5);
                        } else {
                            VideoPlayer.this.nHH.a(false, true, false);
                        }
                    }
                    if (VideoPlayer.this.nIj != null && !VideoPlayer.this.dYF()) {
                        VideoPlayer.this.nIj.removeMessages(1);
                        VideoPlayer.this.nIj.B(1, VideoPlayer.A);
                    }
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void dYY() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerACallback onPlayerPause");
            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.nIj != null) {
                VideoPlayer.this.nIj.removeMessages(1);
            }
        }

        @Override // tv.chushou.common.player.b
        public void dYZ() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerACallback onPlayerStop");
            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.dYF() && VideoPlayer.this.nHE != null && !h.isEmpty(VideoPlayer.this.P) && VideoPlayer.this.nHE.getCurrentPos() > 0) {
                j.dYx().a(VideoPlayer.this.P, VideoPlayer.this.nHE.getCurrentPos());
            }
        }
    };
    private tv.chushou.common.player.b nIn = new tv.chushou.common.player.b() { // from class: com.kascend.chushou.player.VideoPlayer.15
        @Override // tv.chushou.common.player.b
        public void dYS() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerBCallback onSetVideoViewLayout");
            if (!VideoPlayer.this.isFinishing()) {
                if ((VideoPlayer.this.nHH == null || !VideoPlayer.this.nHH.H) && VideoPlayer.this.nHH != null && VideoPlayer.this.d) {
                    VideoPlayer.this.nHH.y();
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void Nb(int i) {
            if (!VideoPlayer.this.isFinishing()) {
                if ((VideoPlayer.this.nHH == null || !VideoPlayer.this.nHH.H) && VideoPlayer.this.nHH != null && VideoPlayer.this.d) {
                    VideoPlayer.this.nHH.g(i);
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void dYT() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerBCallback onCompletePlayback");
            if (!VideoPlayer.this.isFinishing()) {
                if (!h.isEmpty(VideoPlayer.this.P)) {
                    j.dYx().a(VideoPlayer.this.P, 0);
                }
                VideoPlayer.this.K = false;
                if (VideoPlayer.this.nIj != null) {
                    VideoPlayer.this.nIj.removeMessages(1);
                }
                if ((VideoPlayer.this.nHH == null || !VideoPlayer.this.nHH.H) && VideoPlayer.this.nHH != null && VideoPlayer.this.d) {
                    VideoPlayer.this.nIj.removeMessages(7);
                    VideoPlayer.this.M = false;
                    VideoPlayer.this.nHH.z();
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void dYU() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerBCallback onVideoRenderingStart");
            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.nHH != null) {
                VideoPlayer.this.nHH.G();
            }
        }

        @Override // tv.chushou.common.player.b
        public void dYV() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerBCallback onPreparedPlayback");
            if (!VideoPlayer.this.isFinishing()) {
                if (VideoPlayer.this.nHH == null || !VideoPlayer.this.nHH.H) {
                    VideoPlayer.this.nIj.removeMessages(6);
                    VideoPlayer.this.N = 0L;
                    VideoPlayer.this.O = 0;
                    if (VideoPlayer.this.nHD != null && VideoPlayer.this.nHH != null) {
                        VideoPlayer.this.nHD.setVolume(VideoPlayer.this.nHH.J, VideoPlayer.this.nHH.J);
                    }
                    if (VideoPlayer.this.nHJ != null) {
                        VideoPlayer.this.K = false;
                        FullRoomInfo dZc = VideoPlayer.this.dYF() ? null : VideoPlayer.this.nHJ.dZc();
                        if (VideoPlayer.this.L || dZc != null) {
                            if (VideoPlayer.this.nHJ.e) {
                                VideoPlayer.this.nHJ.e = false;
                                VideoPlayer.this.nHJ.d = !VideoPlayer.this.nHJ.d;
                            }
                            if (VideoPlayer.this.nHH != null) {
                                VideoPlayer.this.c("1", (String) null);
                                if (VideoPlayer.this.d) {
                                    VideoPlayer.this.nHH.i(true);
                                } else if (VideoPlayer.this.e) {
                                    VideoPlayer.this.e = false;
                                    VideoPlayer.this.nHH.B();
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
                if (VideoPlayer.this.nIj != null) {
                    VideoPlayer.this.nIj.removeMessages(7);
                }
                if (VideoPlayer.this.nIj != null) {
                    VideoPlayer.this.nIj.removeMessages(1);
                }
                if ((VideoPlayer.this.nHH == null || !VideoPlayer.this.nHH.H) && !VideoPlayer.this.dYz()) {
                    if (!"10004".equals(VideoPlayer.this.t)) {
                        if (VideoPlayer.this.nHH != null) {
                            if (!VideoPlayer.this.d) {
                                VideoPlayer.this.nHF.stop();
                                VideoPlayer.this.nHF.release();
                                VideoPlayer.this.nHH.C();
                                VideoPlayer.this.e = false;
                            }
                            if (!com.kascend.chushou.b.dYj().a && !com.kascend.chushou.b.dYj().b) {
                                VideoPlayer.this.nHH.g(true);
                            } else if (VideoPlayer.this.d) {
                                VideoPlayer.this.nHH.a(i, false);
                            } else {
                                VideoPlayer.this.nHH.a(i, true);
                            }
                            VideoPlayer.this.c("2", (String) null);
                            return;
                        }
                        return;
                    }
                    dYT();
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void dYW() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerBCallback onBufferingStart");
            if (!VideoPlayer.this.isFinishing()) {
                if ((VideoPlayer.this.nHH == null || !VideoPlayer.this.nHH.H) && VideoPlayer.this.nHH != null && VideoPlayer.this.d) {
                    VideoPlayer.this.nHH.E();
                    VideoPlayer.this.M = true;
                    VideoPlayer.this.nIj.removeMessages(7);
                    long currentTimeMillis = System.currentTimeMillis();
                    if (!VideoPlayer.this.g) {
                        VideoPlayer.y(VideoPlayer.this);
                    }
                    tv.chushou.zues.utils.e.d(VideoPlayer.this.v, "currentTime: -- >" + currentTimeMillis + "  bufferTime-->" + VideoPlayer.this.N + "  bufferCount-->" + VideoPlayer.this.O);
                    if (currentTimeMillis - VideoPlayer.this.N >= 20000 || VideoPlayer.this.O < 2 || VideoPlayer.this.nHH.H) {
                        if (VideoPlayer.this.O == 1) {
                            VideoPlayer.this.N = currentTimeMillis;
                        }
                        VideoPlayer.this.nIj.B(7, 5000L);
                    } else {
                        VideoPlayer.this.N = 0L;
                        VideoPlayer.this.O = 0;
                        VideoPlayer.this.nIj.Ow(7);
                    }
                    if (VideoPlayer.this.g) {
                        VideoPlayer.this.g = false;
                    }
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void dYX() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerBCallback onBufferingEnd");
            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.nHH != null && VideoPlayer.this.d) {
                VideoPlayer.this.M = false;
                VideoPlayer.this.nIj.removeMessages(7);
                if (VideoPlayer.this.nHH == null || !VideoPlayer.this.nHH.H) {
                    if (VideoPlayer.this.nHD == null) {
                        VideoPlayer.this.nHH.a(false, true, false);
                    } else {
                        VideoPlayer.this.nHH.a(true, VideoPlayer.this.nHD.getPlayState() == 4, VideoPlayer.this.nHD.getPlayState() == 5);
                    }
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void onPlayerStart() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerBCallback onPlayerStart");
            if (!VideoPlayer.this.isFinishing()) {
                if (VideoPlayer.this.nHH == null || !VideoPlayer.this.nHH.H) {
                    if (VideoPlayer.this.nHH != null && VideoPlayer.this.d) {
                        if (VideoPlayer.this.nHD != null) {
                            VideoPlayer.this.nHH.F();
                            VideoPlayer.this.nHH.a(true, VideoPlayer.this.nHD.getPlayState() == 4, VideoPlayer.this.nHD.getPlayState() == 5);
                        } else {
                            VideoPlayer.this.nHH.a(false, true, false);
                        }
                    }
                    if (VideoPlayer.this.nIj != null && !VideoPlayer.this.dYF()) {
                        VideoPlayer.this.nIj.removeMessages(1);
                        VideoPlayer.this.nIj.B(1, VideoPlayer.A);
                    }
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void dYY() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerBCallback onPlayerPause");
            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.nIj != null) {
                VideoPlayer.this.nIj.removeMessages(1);
            }
        }

        @Override // tv.chushou.common.player.b
        public void dYZ() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerBCallback onPlayerStop");
            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.dYF() && VideoPlayer.this.nHF != null && !h.isEmpty(VideoPlayer.this.P) && VideoPlayer.this.nHF.getCurrentPos() > 0) {
                j.dYx().a(VideoPlayer.this.P, VideoPlayer.this.nHF.getCurrentPos());
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
        this.nHC = intent.getData();
        if (this.nHC == null) {
            finish();
            return;
        }
        com.kascend.chushou.d.e.j();
        if (this.nIi == null) {
            this.nIi = new CSTVWifiReceiver();
            registerReceiver(this.nIi, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        }
        com.kascend.chushou.toolkit.d.a.eaz().b();
        tv.chushou.zues.utils.e.i(this.v, "intent.getData=" + this.nHC.toString());
        String scheme = this.nHC.getScheme();
        if (scheme == null || !scheme.equals("chushou")) {
            tv.chushou.zues.utils.e.e(this.v, "not support scheme :" + scheme);
            finish();
            return;
        }
        a(intent);
    }

    private void a(Intent intent) {
        this.P = this.nHC.getQueryParameter("roomId");
        this.Q = this.P;
        this.S = this.nHC.getQueryParameter(WebSocketRequest.PARAM_KEY_PROTOCOLS);
        this.aq = this.nHC.getQueryParameter("liveType");
        if ("2".equals(this.aq) || "3".equals(this.aq) || "4".equals(this.aq)) {
            this.nIe = "2";
            this.nIf = new com.kascend.chushou.player.feedback.a();
            if (this.nIf.nQu != null) {
                this.nIf.nQu.reset();
                this.nIf.nQu.roomId = this.P;
                this.nIf.nQu.enterType = 1;
                this.nIf.b = System.currentTimeMillis();
            }
        }
        if (h.isEmpty(this.P) || h.isEmpty(this.S)) {
            tv.chushou.zues.utils.e.e(this.v, "invalid param mItemID=" + this.P + " protocols=" + this.S);
            finish();
            return;
        }
        if (com.kascend.chushou.b.dYj().d == -1) {
            com.kascend.chushou.b.dYj().d = com.kascend.chushou.d.g.b() ? 1 : 0;
        }
        this.nHV = ((PowerManager) getSystemService("power")).newWakeLock(536870938, this.v);
        this.nHV.acquire();
        this.nHJ = new b(this.P);
        this.nHJ.d = intent.getBooleanExtra("room_play_audio", false);
        this.nHM = new com.kascend.chushou.widget.a.b();
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
        this.nHO = (KPSwitchRootRelativeLayout) findViewById(a.f.rlRoot);
        if (!"2".equals(this.nIe) && com.kascend.chushou.b.dYj().d == 1) {
            this.nHO.setFitsSystemWindows(true);
        }
        this.nHP = (FrameLayout) this.nHO.findViewById(a.f.fl_fragment);
        this.bJb = this.nHO.findViewById(a.f.rl_empty);
        this.T = (ImageView) this.bJb.findViewById(a.f.iv_empty);
        this.U = (TextView) this.bJb.findViewById(a.f.tv_empty);
        this.nHR = (LinearLayout) this.nHO.findViewById(a.f.rl_title);
        this.nHQ = (ImageView) this.nHR.findViewById(a.f.back_icon);
        this.nHQ.setOnClickListener(new View.OnClickListener() { // from class: com.kascend.chushou.player.VideoPlayer.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayer.this.finish();
            }
        });
        this.nHL = (AnimationImageView) this.bJb.findViewById(a.f.iv_loading);
        this.nHW = (FrescoThumbnailView) this.nHO.findViewById(a.f.live_cover);
        this.nHX = (FrameLayout) this.nHO.findViewById(a.f.fl_cover);
        this.k = dYy();
        try {
            this.nHN = (AudioManager) getApplicationContext().getSystemService("audio");
            n = this.nHN.getStreamVolume(3);
            this.nHN.requestAudioFocus(null, 3, 1);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (this.B) {
            a(1, dYF() ? "3" : "1");
        } else {
            r();
        }
        if (com.kascend.chushou.b.dYj().b && !com.kascend.chushou.b.dYj().a) {
            RxExecutor.postDelayed(this.nIg, EventThread.MAIN_THREAD, 60L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.VideoPlayer.5
                @Override // java.lang.Runnable
                public void run() {
                    if (!VideoPlayer.this.isFinishing() && com.kascend.chushou.b.dYj().b && !com.kascend.chushou.b.dYj().a) {
                        tv.chushou.zues.utils.g.c(VideoPlayer.this.w, VideoPlayer.this.getString(a.i.str_monet_notify));
                    }
                }
            });
        }
        com.kascend.chushou.c.c.dYm().a(this.P, stringExtra, System.currentTimeMillis());
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
        if (this.nIh == null) {
            this.nIh = new a();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(VideoReceiver.ACTION_VOLUME_CHANGED);
            registerReceiver(this.nIh, intentFilter);
        }
    }

    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        j(false);
        if (this.nIh != null) {
            unregisterReceiver(this.nIh);
            this.nIh = null;
        }
        super.onStop();
    }

    @Override // com.kascend.chushou.view.base.BaseActivity
    protected void a(boolean z) {
        if (this.nHH != null) {
            this.nHH.k(z);
        }
    }

    @Subscribe
    public void onHideGiftEffectEvent(com.kascend.chushou.b.a.a.f fVar) {
        if (fVar.b) {
            this.nHH.k();
            return;
        }
        this.nHH.m();
        this.nHH.l();
    }

    private float dYy() {
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
            this.nHJ.h = jSONObject.toString();
            String optString = jSONObject.optString("_thumb");
            jSONObject.optBoolean("tag_from_game_mic", false);
            if (!h.isEmpty(optString)) {
                this.ab = optString;
            }
        } catch (JSONException e) {
            e.printStackTrace();
            this.nHJ.h = str;
        }
        if (dYF()) {
            a(this.P, str);
            bb(this.P, z);
            return;
        }
        a = this.P;
        b(this.P, str);
        a(this.P, dYP(), z);
        w();
    }

    private void O() {
        this.m = true;
        j();
        if (this.nHH != null) {
            this.nHH.r();
        }
        s();
    }

    @Subscribe
    public void onStartRoomEvent(o oVar) {
        if (!isFinishing() && oVar.nHk != null && oVar.c != null && !h.isEmpty(oVar.nHk.mTargetKey)) {
            if (oVar.c != this) {
                tv.chushou.zues.utils.e.e(this.v, "different player!");
                return;
            }
            if (this.nHJ != null) {
                this.nHJ.a();
                this.nHJ.a = oVar.nHk.mTargetKey;
                this.nHJ.d = oVar.d;
                if (this.nHJ.nJi != null) {
                    this.nHJ.nJi.e();
                }
                if (this.nHJ.nJi != null) {
                    this.nHJ.nJi.b();
                }
                this.nHJ.nJl = null;
                this.nHJ.nJk = null;
                this.nHJ.nJo = null;
                this.nHJ.nJn = null;
                this.nHJ.nJr = null;
                this.nHJ.nJp = null;
                this.nHJ.nJq = null;
            }
            if (this.nHN != null) {
                n = this.nHN.getStreamVolume(3);
            }
            if (!h.isEmpty(oVar.nHk.mType) && oVar.nHk.mType.equals("3")) {
                this.B = false;
                this.nIe = "1";
                r();
                this.P = oVar.nHk.mTargetKey;
                this.R = "3";
                if (this.nHM != null) {
                    this.nHM.a();
                }
                if (this.nHJ != null) {
                    this.nHJ.a((PlayUrl) null);
                    this.nHJ.f();
                    if (this.nHJ.c() != null) {
                        this.nHJ.c().clear();
                    }
                    this.nHJ.i.clear();
                }
                if (this.nHH != null) {
                    this.nHH.j();
                }
                s();
                if (this.nHS != null) {
                    this.nHS.d();
                    this.nHS = null;
                }
                if (this.nIg != null) {
                    this.nIg.dispose();
                    this.nIg = new io.reactivex.disposables.a();
                }
                a(oVar.e, false);
                return;
            }
            boolean z = this.R != null && this.R.equals("1");
            this.R = "1";
            this.nIb.a();
            this.nIa.a();
            this.nHZ.a();
            this.nHY.c();
            this.nId.a();
            if (this.nIg != null) {
                this.nIg.dispose();
                this.nIg = new io.reactivex.disposables.a();
            }
            if ("1".equals(oVar.f)) {
                this.H = false;
                if (this.nHJ != null && !h.isEmpty(this.nHJ.t)) {
                    this.nHJ.t.clear();
                }
                this.ab = oVar.nHk.mCover;
                this.nHX.setVisibility(0);
                this.nHW.setBlur(true);
                this.nHW.i(oVar.nHk.mCover, 0, 0, 0);
            }
            if (!oVar.nHk.mTargetKey.equals(this.P)) {
                this.aq = oVar.g;
                if (!z) {
                    this.B = false;
                    r();
                } else if (!"2".equals(this.nIe) && ("2".equals(this.aq) || "3".equals(this.aq) || "4".equals(this.aq))) {
                    this.nIe = "2";
                    this.nIf = new com.kascend.chushou.player.feedback.a();
                    if (this.nIf.nQu != null) {
                        this.nIf.nQu.reset();
                        this.nIf.nQu.roomId = oVar.nHk.mTargetKey;
                        this.nIf.nQu.enterType = 1;
                        this.nIf.b = System.currentTimeMillis();
                    }
                }
                this.B = false;
                this.P = oVar.nHk.mTargetKey;
                this.Q = this.P;
                this.ab = oVar.nHk.mCover;
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
                JSONObject O = com.kascend.chushou.d.e.O("_fromView", str, "_sc", oVar.nHk.mSC);
                com.kascend.chushou.toolkit.a.c.a(this.w, O);
                if (this.nHM != null) {
                    this.nHM.a();
                    this.nHM.a(this.P);
                }
                if (this.nHJ != null) {
                    this.nHJ.a((PlayUrl) null);
                    this.nHJ.f();
                    if (this.nHJ.c() != null) {
                        this.nHJ.c().clear();
                    }
                    this.nHJ.i.clear();
                }
                if (this.nHH != null) {
                    this.nHH.j();
                }
                a(O.toString(), false);
                return;
            }
            tv.chushou.zues.utils.g.OF(a.i.str_same_room);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dYz() {
        FullRoomInfo dZc;
        String str;
        RoomInfo roomInfo;
        if (dYF()) {
            str = null;
            dZc = null;
        } else {
            dZc = this.nHJ.dZc();
            str = (dZc == null || (roomInfo = dZc.mRoominfo) == null) ? null : roomInfo.mGameId;
        }
        return !this.L && (dZc == null || h.isEmpty(str));
    }

    @Subscribe
    public void onMessageEvent(i iVar) {
        if (!isFinishing() && iVar.a != 21 && iVar.a != 22) {
            if (iVar.a == 0 && (iVar.b instanceof Boolean)) {
                if (((Boolean) iVar.b).booleanValue() && !isFinishing()) {
                    w();
                    if (this.nHH != null) {
                        this.nHH.f();
                    }
                }
            } else if (iVar.a == 46) {
                if ((iVar.b instanceof String) && this.nHH != null) {
                    this.nHH.c((String) iVar.b);
                }
            } else if (iVar.a == 54) {
                if (iVar.b instanceof String) {
                    this.nHZ.a((String) iVar.b);
                }
            } else if (iVar.a == 55) {
                if (this.nHH != null) {
                    this.nHH.O();
                }
            } else if (iVar.a == 56 && this.nHH != null) {
                this.nHH.P();
            }
        }
    }

    @Subscribe
    public void onRefreshSubscribeEvent(m mVar) {
        if (isFinishing() && this.nHJ != null && this.nHJ.dZe() != null) {
            RoomInfo dZe = this.nHJ.dZe();
            if (mVar.a(dZe.mCreatorUID, dZe.mRoomID)) {
                dZe.mIsSubscribed = mVar.c;
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
        if (this.m || this.nHE == null || this.nHF == null) {
            R();
        }
        if (this.nHM != null) {
            this.nHM.d();
        }
        if (!dYF()) {
            if (this.nHS != null && !this.nHS.c()) {
                this.nHS.a();
            }
            v();
            if (this.nHJ != null && this.nHJ.dZc() != null && this.nHJ.dZc().cycleLiveRoomInfo != null && !h.isEmpty(this.nHJ.dZc().cycleLiveRoomInfo.roomId)) {
                u();
            }
        }
        super.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.view.base.BaseActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        tv.chushou.zues.utils.e.e(this.v, MissionEvent.MESSAGE_DESTROY);
        if (this.nHJ != null && this.nHJ.dZc() != null && this.nHJ.dZc().cycleLiveRoomInfo != null && !h.isEmpty(this.nHJ.dZc().cycleLiveRoomInfo.eventName)) {
            j.dYx().a(this.P + dYP());
        }
        if ("2".equals(this.nIe) && this.nIf != null && this.nIf.nQu != null) {
            this.nIf.nQu.time = System.currentTimeMillis() - this.nIf.b;
            this.nIf.a();
            this.nIf.b();
        }
        this.nHY.d();
        this.nHZ.b();
        this.nIa.b();
        O();
        this.ag = null;
        a = null;
        if (this.nIj != null) {
            this.nIj.cl(null);
            this.nIj = null;
        }
        if (this.nHS != null) {
            this.nHS.d();
            this.nHS = null;
        }
        if (this.nHM != null) {
            this.nHM.c();
            this.nHM = null;
        }
        if (this.nHJ != null) {
            this.nHJ.nJl = null;
            this.nHJ.nJk = null;
        }
        if (this.nHJ != null) {
            this.nHJ.b();
            this.nHJ = null;
        }
        this.nHC = null;
        this.nHH = null;
        this.nHI = null;
        this.nHK = null;
        this.T = null;
        this.U = null;
        this.nHL = null;
        this.bJb = null;
        this.nHN = null;
        this.nHO = null;
        this.nHP = null;
        this.nHQ = null;
        this.nHR = null;
        if (this.nHV != null && this.nHV.isHeld()) {
            this.nHV.release();
            this.nHV = null;
        }
        if (this.nIi != null) {
            unregisterReceiver(this.nIi);
            this.nIi = null;
        }
        h.emn();
        tv.chushou.zues.a.a.cm(this);
        this.nIg.dispose();
        this.nIa.b();
        this.nIb.b();
        this.nHY.d();
        this.nHZ.b();
        this.nId.b();
        super.onDestroy();
        System.gc();
    }

    @Subscribe
    public void onSendGameGiftEvent(n nVar) {
        if (!isFinishing() && this.nHH != null) {
            this.nHH.a(nVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.view.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        tv.chushou.zues.utils.e.d(this.v, MissionEvent.MESSAGE_PAUSE);
        if (this.nHS != null) {
            this.nHS.b();
        }
        if (this.nHM != null) {
            this.nHM.b(false);
        }
        k();
        this.m = true;
        super.onPause();
    }

    @Override // android.app.Activity
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.nHH != null ? this.nHH.a(motionEvent) : super.onTouchEvent(motionEvent);
    }

    public void c() {
        if ("1".equals(this.R)) {
            j.dYx().a(this.P + dYP());
        } else {
            j.dYx().b(this.P);
        }
    }

    private void a(boolean z, boolean z2) {
        int i = 0;
        tv.chushou.zues.utils.e.i(this.v, "startLoadingVideo <------------- mbPrepareingVideo = " + this.K);
        if (this.nHE != null) {
            this.nHE.setHardwearDecod(com.kascend.chushou.d.h.dYr().a);
        }
        if (this.nHF != null) {
            this.nHF.setHardwearDecod(com.kascend.chushou.d.h.dYr().a);
        }
        if (this.nHD != null) {
            this.nHD.setHardwearDecod(com.kascend.chushou.d.h.dYr().a);
        }
        if (!this.K) {
            if (z && this.nHH != null) {
                if (!z2) {
                    this.t = null;
                    this.nHH.e();
                }
            } else if (this.nHH != null && !z2) {
                this.t = null;
                this.nHH.H = false;
                RxExecutor.post(null, EventThread.MAIN_THREAD, new Runnable() { // from class: com.kascend.chushou.player.VideoPlayer.7
                    @Override // java.lang.Runnable
                    public void run() {
                        VideoPlayer.this.nHH.x();
                    }
                });
            }
            this.K = true;
            if (this.nHJ != null && this.nHJ.dZd() != null) {
                PlayUrl dZd = this.nHJ.dZd();
                while (true) {
                    int i2 = i;
                    if (i2 >= dZd.mUrlDetails.size()) {
                        break;
                    }
                    UrlDetails urlDetails = dZd.mUrlDetails.get(i2);
                    if (urlDetails.mUrl.equals(dZd.mSelectedUrl)) {
                        String str = dZd.mUrlDetails.get(i2).mDefinitionType;
                        String str2 = urlDetails.mBitrate;
                    }
                    i = i2 + 1;
                }
            }
            if (z2) {
                if (this.d) {
                    this.nHE.setVideoURI(this.nHC);
                    this.nHE.open();
                    return;
                }
                this.nHF.setVideoURI(this.nHC);
                this.nHF.open();
                return;
            }
            this.nHD.setVideoURI(this.nHC);
            this.nHD.open();
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        try {
            if (motionEvent.getAction() == 0) {
                if (this.nHH != null && this.nHH.b(motionEvent)) {
                    return true;
                }
                if ("2".equals(this.nIe) && this.nHH != null) {
                    this.nHH.a(motionEvent);
                }
            } else if (this.nHH != null && this.nHH.b(motionEvent)) {
                return true;
            }
            return super.dispatchTouchEvent(motionEvent);
        } catch (Exception e) {
            return false;
        }
    }

    @Override // android.support.v7.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.nHH != null && this.nHH.a(i, keyEvent)) {
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
        if (this.nHJ != null && this.nHJ.dZc() != null && this.nHJ.dZc().cycleLiveRoomInfo != null && !h.isEmpty(this.nHJ.dZc().cycleLiveRoomInfo.roomId)) {
            this.nHX.setVisibility(0);
            this.nHW.setBlur(true);
            this.nHW.i(this.nHJ.dZc().cycleLiveRoomInfo.avatar, 0, 0, 0);
            this.nHW.setVisibility(0);
            j.dYx().a(this.P + dYP());
            this.nHC = null;
            R();
            this.Q = this.nHJ.dZc().cycleLiveRoomInfo.roomId;
            a(this.P, dYP(), false);
        }
    }

    public void b(boolean z) {
        if (this.nHH != null) {
            this.nHH.j(z);
        }
    }

    public void a(boolean z, Uri uri, boolean z2) {
        tv.chushou.zues.utils.e.d(this.v, "loadIfNecessary reload=" + z + " isChangeLines-->" + z2);
        if (this.nHE != null && this.nHF != null) {
            if (uri != null) {
                this.nHC = uri;
            }
            if (z2) {
                this.e = z2;
            }
            this.M = false;
            this.N = 0L;
            this.O = 0;
            this.nIj.removeMessages(7);
            if (z) {
                if (z2) {
                    if (!this.d) {
                        this.nHF.setOnActivityCallBack(this.nIn);
                    } else {
                        this.nHE.setOnActivityCallBack(this.nIm);
                    }
                } else if (this.d) {
                    this.nHF.setOnActivityCallBack(this.nIn);
                } else {
                    this.nHE.setOnActivityCallBack(this.nIm);
                }
                this.K = false;
                b(true, z2);
            } else if (!this.J) {
                b(true, z2);
            }
            this.nIj.B(6, IMConnection.RETRY_DELAY_TIMES);
        }
    }

    private void b(boolean z, boolean z2) {
        VideoPlayInfo N;
        if ("1".equals(this.R)) {
            N = j.dYx().M(this.P + dYP(), 600000L);
        } else {
            N = j.dYx().N(this.P, 600000L);
        }
        if (N != null) {
            a(z, z2);
        } else if ("1".equals(this.R)) {
            a(this.P, dYP(), false);
        } else {
            bb(this.P, false);
        }
    }

    public tv.chushou.common.player.a dYA() {
        return this.nHD;
    }

    public tv.chushou.common.player.a dYB() {
        return this.nHE;
    }

    public tv.chushou.common.player.a dYC() {
        return this.nHF;
    }

    public void a(tv.chushou.common.player.a aVar) {
        this.nHD = aVar;
    }

    public b dYD() {
        return this.nHJ;
    }

    public com.kascend.chushou.widget.a.b dYE() {
        return this.nHM;
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
        FullRoomInfo dZc;
        this.r = -1L;
        if (this.s != -1 && this.s != 0) {
            this.r = this.s;
            this.s = -1L;
        }
        if (dYF() && this.nHD != null && this.nHD.getPlayState() == 4) {
            this.r = this.nHD.getCurrentPos();
        }
        this.nIk = false;
        tv.chushou.zues.utils.e.d(this.v, "screenChange()<-----");
        tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard(this);
        if (str != null) {
            this.R = str;
        }
        if (!this.C || !z3 || "3".equals(this.R) || this.nHJ == null || (dZc = this.nHJ.dZc()) == null || dZc.mRoominfo == null || dZc.mRoominfo.mStyle != 1) {
            z5 = false;
        } else {
            z5 = true;
            i = 0;
        }
        if ("2".equals(this.nIe)) {
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
            if (com.kascend.chushou.b.dYj().d == 1) {
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
            ((VideoPlayer) this.w).ys(false);
            ((VideoPlayer) this.w).g(true);
            if (z5) {
                setRequestedOrientation(1);
            } else {
                setRequestedOrientation(6);
            }
            getWindow().addFlags(512);
            getWindow().addFlags(256);
        }
        if (this.nHM == null) {
            this.nHM = new com.kascend.chushou.widget.a.b();
        }
        if (this.nHM != null) {
            this.nHM.a(this.P);
        }
        if (this.R.equals("5")) {
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            if (this.nHH != null) {
                beginTransaction.remove(this.nHH);
                this.nHH = null;
            }
            if (this.nHI != null) {
                beginTransaction.remove(this.nHI);
                this.nHI = null;
            }
            this.nHI = new com.kascend.chushou.view.user.b();
            beginTransaction.add(a.f.fl_fragment, this.nHI);
            beginTransaction.commitAllowingStateLoss();
        } else {
            FragmentTransaction beginTransaction2 = getSupportFragmentManager().beginTransaction();
            if (this.nHH != null) {
                beginTransaction2.remove(this.nHH);
                this.nHH = null;
            }
            if (this.nHI != null) {
                beginTransaction2.remove(this.nHI);
                this.nHI = null;
            }
            if ("2".equals(this.nIe)) {
                this.nHH = com.kascend.chushou.player.e.e.b(this.ab, z2, this.aq, this.P);
            } else if (1 == i) {
                if (!this.R.equals("3")) {
                    if (z4) {
                        v();
                    }
                    this.nHH = new com.kascend.chushou.player.d.a();
                    Bundle bundle = new Bundle();
                    bundle.putString("mCover", this.ab);
                    bundle.putBoolean("mInitViewAsync", z2);
                    this.nHH.setArguments(bundle);
                }
            } else {
                this.nHH = new com.kascend.chushou.player.d.b();
                Bundle bundle2 = new Bundle();
                if (z5) {
                    i = 1;
                }
                bundle2.putInt("mExtraOrientation", i);
                bundle2.putString("mViewType", this.R);
                this.nHH.setArguments(bundle2);
            }
            beginTransaction2.add(a.f.fl_fragment, this.nHH);
            beginTransaction2.commitAllowingStateLoss();
            this.H = true;
        }
        tv.chushou.zues.utils.e.d(this.v, "screenChange()----->");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dYF() {
        return this.R != null && this.R.equals("3");
    }

    private void R() {
        if (this.nHH != null) {
            this.nHH.nMD = null;
        }
        if (this.nHD != null) {
            this.nHD.release();
            this.nHD = null;
            this.K = false;
        }
        if (this.nHE != null) {
            this.nHE.release();
            this.nHE = null;
        }
        if (this.nHF != null) {
            this.nHF.release();
            this.nHF = null;
        }
        if (this.nHG != null) {
            this.nHG.c();
        }
        this.d = false;
        this.e = false;
        this.M = false;
        this.nHG = new c();
        this.nHE = this.nHG.dZh();
        this.nHE.setOnActivityCallBack(this.nIm);
        this.nHF = this.nHG.dZi();
        this.nHF.setOnActivityCallBack(this.nIn);
        if (!this.d) {
            this.nHD = this.nHE;
        } else {
            this.nHD = this.nHF;
        }
        if (this.nHH != null) {
            this.nHH.nMD = this.nHD;
        }
    }

    public void j() {
        if (this.nHD != null) {
            this.nHD.pause();
            this.nHD.stop();
            this.nHD.release();
            this.nHD = null;
        }
        if (this.nHE != null) {
            this.nHE.stop();
            this.nHE.release();
            this.nHE = null;
        }
        if (this.nHF != null) {
            this.nHF.stop();
            this.nHF.release();
            this.nHF = null;
        }
        if (this.nHG != null) {
            this.nHG.c();
        }
    }

    public void k() {
        tv.chushou.common.player.a aVar = this.nHD;
        if (aVar != null) {
            aVar.pause();
            aVar.stop();
        }
        tv.chushou.common.player.a aVar2 = this.nHE;
        if (aVar2 != null) {
            aVar2.stop();
        }
        tv.chushou.common.player.a aVar3 = this.nHF;
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
        if (this.nIk) {
            if (this.nHH != null) {
                this.nHH.s();
            }
        } else if (this.nIj != null) {
            this.nIj.b(this.nIj.Oy(3), 20L);
        }
    }

    private void b(final String str, String str2) {
        com.kascend.chushou.c.c.dYm().a(new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.VideoPlayer.8
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
                    VideoPlayer.this.dYN().a(fullRoomInfo.mBangMap);
                    if (h.isEmpty(fullRoomInfo.mRoominfo.mRoomID)) {
                        fullRoomInfo.mRoominfo.mRoomID = VideoPlayer.this.P;
                    }
                    if (!h.isEmpty(fullRoomInfo.mGeneralTabGifts)) {
                        com.kascend.chushou.d.e.a(VideoPlayer.this.nIg, new ArrayList(fullRoomInfo.mGeneralTabGifts));
                    }
                    if (VideoPlayer.this.nHJ != null) {
                        VideoPlayer.this.nHJ.a(fullRoomInfo);
                    }
                    VideoPlayer.this.L = false;
                    if (VideoPlayer.this.B) {
                        if (VideoPlayer.this.C && !"3".equals(VideoPlayer.this.R) && fullRoomInfo != null && fullRoomInfo.mRoominfo != null && fullRoomInfo.mRoominfo.mStyle == 1 && !h.isEmpty(fullRoomInfo.mRoominfo.mGameId)) {
                            z = true;
                        }
                        if (!z) {
                            if (VideoPlayer.this.nHH != null) {
                                VideoPlayer.this.nHH.a(VideoPlayer.this.nHJ);
                            }
                            if (!h.isEmpty(fullRoomInfo.mRoominfo.mGameId)) {
                                VideoPlayer.this.S();
                            } else {
                                if (VideoPlayer.this.nHJ != null) {
                                    VideoPlayer.this.nHJ.f = null;
                                }
                                VideoPlayer.this.S();
                            }
                        } else {
                            VideoPlayer.this.a(1, "1", true);
                            if (VideoPlayer.this.nHH != null) {
                                VideoPlayer.this.nHH.a(VideoPlayer.this.nHJ);
                            }
                        }
                    } else {
                        if (h.isEmpty(fullRoomInfo.mRoominfo.mGameId)) {
                            if (VideoPlayer.this.nHJ != null) {
                                VideoPlayer.this.nHJ.f = null;
                            }
                            VideoPlayer.this.a(1, "1");
                        } else {
                            VideoPlayer.this.a(1, "1", true);
                        }
                        if (VideoPlayer.this.nHH != null) {
                            VideoPlayer.this.nHH.a(VideoPlayer.this.nHJ);
                        }
                    }
                    if (VideoPlayer.this.nHJ != null && !VideoPlayer.this.nHJ.m()) {
                        if (VideoPlayer.this.nHS != null) {
                            VideoPlayer.this.nHS.d();
                            VideoPlayer.this.nHS = null;
                        }
                        VideoPlayer.this.nHS = new com.kascend.chushou.toolkit.d(900000L, VideoPlayer.this.nHU, VideoPlayer.this.nIj);
                        VideoPlayer.this.nHS.a();
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
        if (this.nHJ != null) {
            this.nHJ.a((FullRoomInfo) null);
        }
        this.L = false;
        bR(str, i);
        if (this.nHD != null) {
            this.nHD.stop();
        }
        if (this.nHE != null) {
            this.nHE.stop();
        }
        if (this.nHF != null) {
            this.nHF.stop();
        }
    }

    public void l() {
        tv.chushou.zues.utils.e.d(this.v, "retryGetPlayList");
        c();
        if (dYF()) {
            bb(this.P, false);
        } else {
            a(this.P, dYP(), false);
        }
    }

    public void m() {
        a(this.ag, false);
    }

    private void a(final String str, String str2, boolean z) {
        this.J = true;
        VideoPlayInfo M = j.dYx().M(str + str2, 600000L);
        if (M != null) {
            a((ArrayList) M.mPlayUrls);
            this.J = false;
        } else if (z) {
            ParserRet go = com.kascend.chushou.player.c.a.dZj().go(str, str2);
            if (go.mRc != 0) {
                tv.chushou.zues.utils.e.e(this.v, "getPlayUrlSync fail, try to getPlaylist");
                a(str, str2, false);
                return;
            }
            a(go, str);
        } else {
            com.kascend.chushou.player.c.a.dZj().a(str, str2, new a.InterfaceC0887a() { // from class: com.kascend.chushou.player.VideoPlayer.9
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
        VideoPlayInfo N = j.dYx().N(str, 600000L);
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
                ParserRet bc = com.kascend.chushou.player.c.a.dZj().bc(str, equals);
                if (bc.mRc != 0) {
                    tv.chushou.zues.utils.e.e(this.v, "getVideoPlayUrlSync fail, try to getVideoPlaylist");
                    bb(str, false);
                    return;
                }
                a(bc, str);
                return;
            }
            com.kascend.chushou.player.c.a.dZj().a(str, new a.InterfaceC0887a() { // from class: com.kascend.chushou.player.VideoPlayer.10
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
                if (this.nHJ.f == null) {
                    this.nHJ.f = new ArrayList<>();
                }
                this.nHJ.f.clear();
                this.nHJ.f.addAll(arrayList);
                if ("1".equals(this.R)) {
                    j.dYx().a(str + dYP(), arrayList);
                } else {
                    j.dYx().s(str, arrayList);
                }
                a(arrayList);
                return;
            }
            if (this.nHJ != null) {
                this.nHJ.f = null;
            }
            if (this.nIj != null) {
                Message Oy = this.nIj.Oy(5);
                Oy.arg1 = 2;
                Oy.arg2 = parserRet.mRc;
                this.nIj.S(Oy);
            }
        }
    }

    private void bR(String str, int i) {
        s();
        if (this.nHM != null) {
            this.nHM.a();
        }
        if (h.isEmpty(str)) {
            str = getString(a.i.str_load_data_failed);
        }
        a(str, i);
    }

    public void n() {
        if (this.nHP != null && this.bJb != null && this.nHR != null) {
            this.nHP.setVisibility(0);
            this.bJb.setVisibility(8);
            this.nHR.setVisibility(8);
        }
    }

    public void o() {
        if (this.nHW != null && this.nHW.getVisibility() == 0) {
            this.nHW.Ck(0);
            this.nHW.setVisibility(8);
        }
    }

    public void p() {
        if (this.nHX != null && this.nHX.getVisibility() == 0) {
            this.nHX.setVisibility(8);
        }
    }

    public void q() {
        this.nIk = true;
    }

    protected void r() {
        this.nHP.setVisibility(8);
        this.nHR.setVisibility(0);
        this.bJb.setVisibility(0);
        if (this.nHL != null) {
            this.T.setVisibility(8);
            this.nHL.setVisibility(0);
            this.U.setText(getString(a.i.str_dialog_loading_content));
            this.U.setVisibility(8);
        }
    }

    protected void a(String str, int i) {
        this.nHP.setVisibility(8);
        this.nHR.setVisibility(0);
        this.bJb.setVisibility(0);
        if (this.nHL != null) {
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
                            com.kascend.chushou.c.c.dYm().b(new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.VideoPlayer.11.1
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
                            }, VideoPlayer.this.P, (String) null, VideoPlayer.this.nHJ.h);
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
            this.nHL.setVisibility(8);
            this.nHX.setVisibility(8);
        }
    }

    public void s() {
        if (this.nIj != null) {
            this.nIj.removeMessages(1);
        }
    }

    private void a(ArrayList<PlayUrl> arrayList) {
        boolean z;
        if (this.nHJ.f == null) {
            this.nHJ.f = new ArrayList<>();
        }
        this.nHJ.f.clear();
        this.nHJ.f.addAll(arrayList);
        if (com.kascend.chushou.d.e.b() && !"4".equals(this.aq)) {
            int c = com.kascend.chushou.d.e.c();
            if (c == -1) {
                b(arrayList);
                return;
            } else if (this.aw) {
                this.aw = false;
                if (c == 0) {
                    this.nHJ.d = false;
                    f(arrayList, true);
                    return;
                }
                if (this.nHJ != null && this.nHJ.f != null) {
                    Iterator<PlayUrl> it = this.nHJ.f.iterator();
                    while (it.hasNext()) {
                        if ("2".equals(it.next().mType)) {
                            z = true;
                            break;
                        }
                    }
                }
                z = false;
                this.nHJ.d = z;
                f(arrayList, true);
                return;
            } else {
                if (this.nHJ.e) {
                    this.nHJ.d = !this.nHJ.d;
                    this.nHJ.e = false;
                    this.nIl = true;
                } else if ("4".equals(this.aq)) {
                    this.nHJ.d = true;
                }
                f(arrayList, true);
                return;
            }
        }
        if (this.nHJ.e) {
            this.nHJ.d = !this.nHJ.d;
            this.nHJ.e = false;
            this.nIl = true;
        } else if ("4".equals(this.aq)) {
            this.nHJ.d = true;
        }
        f(arrayList, true);
    }

    private void b(ArrayList<PlayUrl> arrayList) {
        if ("1".equals(this.R)) {
            if ("2".equals(this.nIe)) {
                d(false, arrayList);
            } else if (this.nHH != null) {
                this.nHH.f(arrayList, false);
            }
        } else if (this.nHH != null) {
            this.nHH.f(arrayList, false);
        }
    }

    public void c(boolean z) {
        this.nHJ.d = false;
        com.kascend.chushou.d.e.a(0);
        ArrayList<PlayUrl> arrayList = this.nHJ.f;
        if (!h.isEmpty(arrayList)) {
            if (z) {
                f(arrayList, false);
                if (this.nIj != null) {
                    this.nIj.Ow(2);
                    return;
                }
                return;
            }
            f(arrayList, true);
        }
    }

    public void d(boolean z) {
        this.nHJ.d = true;
        com.kascend.chushou.d.e.a(1);
        ArrayList<PlayUrl> arrayList = this.nHJ.f;
        if (!h.isEmpty(arrayList)) {
            if (z) {
                f(arrayList, false);
                if (this.nIj != null) {
                    this.nIj.Ow(2);
                    return;
                }
                return;
            }
            f(arrayList, true);
        }
    }

    @Subscribe
    public void onNotifyEvent(com.kascend.chushou.b.a.a.j jVar) {
        if (!isFinishing() && jVar.a == 1 && !"5".equals(this.R) && !dYz()) {
            tv.chushou.zues.utils.e.d(this.v, "onNetworkChangeEvent 3G=" + com.kascend.chushou.b.dYj().b + "  wifi=" + com.kascend.chushou.b.dYj().a);
            if (com.kascend.chushou.d.e.b() && !"4".equals(this.aq)) {
                if (com.kascend.chushou.d.e.c() == -1) {
                    if (this.nHH != null) {
                        this.nHH.e(false);
                    }
                    if ("1".equals(this.R)) {
                        if ("2".equals(this.nIe)) {
                            d(true, null);
                            return;
                        } else if (this.nHH != null) {
                            this.nHH.f(this.nHJ.f, true);
                            return;
                        } else {
                            return;
                        }
                    } else if (this.nHH != null) {
                        this.nHH.f(this.nHJ.f, true);
                        return;
                    } else {
                        return;
                    }
                }
                RxExecutor.postDelayed(this.nIg, EventThread.MAIN_THREAD, 10L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.VideoPlayer.12
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!VideoPlayer.this.isFinishing() && com.kascend.chushou.b.dYj().b && !com.kascend.chushou.b.dYj().a) {
                            tv.chushou.zues.utils.g.c(VideoPlayer.this.w, VideoPlayer.this.getString(a.i.str_monet_notify));
                        }
                    }
                });
            } else if (com.kascend.chushou.b.dYj().a || com.kascend.chushou.b.dYj().b) {
                t();
                if (this.nIj != null) {
                    this.nIj.Ow(2);
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
            if (this.nHJ.d) {
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
            String d = com.kascend.chushou.d.h.dYr().d();
            String str3 = h.isEmpty(d) ? "2" : d;
            if (this.nHJ.d) {
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
                if (this.nHJ != null) {
                    this.nHJ.a(playUrl2);
                    if (this.nIj != null) {
                        Message Oy = this.nIj.Oy(5);
                        Oy.arg1 = 1;
                        this.nIj.S(Oy);
                    }
                }
                String b = com.kascend.chushou.player.c.a.b(playUrl2);
                if (!h.isEmpty(b)) {
                    this.nHC = Uri.parse(b);
                    if (this.nIl) {
                        this.nIl = false;
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (z && this.nHD != null) {
                        a(false, z2);
                    }
                }
            }
        }
    }

    public void d(final boolean z, ArrayList<PlayUrl> arrayList) {
        if (this.nHT == null || this.nHT.a <= 0) {
            this.nHT = com.kascend.chushou.view.b.a.a.eaA();
            this.nHT.a(new a.InterfaceC0906a() { // from class: com.kascend.chushou.player.VideoPlayer.13
                @Override // com.kascend.chushou.view.b.a.a.InterfaceC0906a
                public void a(int i) {
                    if (i == a.f.tv_play_video) {
                        VideoPlayer.this.nHT.dismissAllowingStateLoss();
                        VideoPlayer.this.c(z);
                    } else if (i == a.f.tv_play_audio) {
                        VideoPlayer.this.nHT.dismissAllowingStateLoss();
                        VideoPlayer.this.d(z);
                    } else if (i == a.f.iv_close) {
                        VideoPlayer.this.finish();
                    } else {
                        if (i == a.f.tv_union_proxy) {
                        }
                    }
                }
            });
            this.nHT.show(getSupportFragmentManager(), "showRoom");
        }
    }

    public void t() {
        if (this.nHT != null) {
            this.nHT.dismissAllowingStateLoss();
        }
        if (this.nHH != null) {
            this.nHH.v();
        }
    }

    public void u() {
        com.kascend.chushou.c.c.dYm().c(this.P, new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.VideoPlayer.16
            @Override // com.kascend.chushou.c.b
            public void a() {
            }

            @Override // com.kascend.chushou.c.b
            public void a(String str, JSONObject jSONObject) {
                if (!VideoPlayer.this.isFinishing()) {
                    ParserRet em = com.kascend.chushou.c.e.em(jSONObject);
                    if (em.mRc == 0 && em.mData != null) {
                        CycleLiveRoomInfo cycleLiveRoomInfo = (CycleLiveRoomInfo) em.mData;
                        if (VideoPlayer.this.nHJ != null && cycleLiveRoomInfo != null && !h.isEmpty(cycleLiveRoomInfo.roomId)) {
                            FullRoomInfo dZc = VideoPlayer.this.nHJ.dZc();
                            if (dZc.cycleLiveRoomInfo == null) {
                                dZc.cycleLiveRoomInfo = cycleLiveRoomInfo;
                                VideoPlayer.this.d();
                            } else if (dZc.cycleLiveRoomInfo != null && !cycleLiveRoomInfo.roomId.equals(dZc.cycleLiveRoomInfo.roomId)) {
                                dZc.cycleLiveRoomInfo.copyCycleLiveRoomInfo(cycleLiveRoomInfo);
                                VideoPlayer.this.d();
                            } else {
                                dZc.cycleLiveRoomInfo.copyCycleLiveRoomInfo(cycleLiveRoomInfo);
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
        if (this.nHH != null) {
            this.nHH.N();
        }
    }

    public void v() {
        com.kascend.chushou.c.c.dYm().a(this.P, new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.VideoPlayer.17
            @Override // com.kascend.chushou.c.b
            public void a() {
            }

            @Override // com.kascend.chushou.c.b
            public void a(String str, JSONObject jSONObject) {
                if (!VideoPlayer.this.isFinishing()) {
                    ParserRet en = com.kascend.chushou.c.e.en(jSONObject);
                    if (en.mRc == 0 && en.mData != null) {
                        PkNotifyInfo pkNotifyInfo = (PkNotifyInfo) en.mData;
                        VideoPlayer.this.nIc.b = VideoPlayer.this.P;
                        if (pkNotifyInfo != null) {
                            VideoPlayer.this.nIc.nME = pkNotifyInfo;
                            if (VideoPlayer.this.nHH != null) {
                                VideoPlayer.this.nHH.a(pkNotifyInfo, VideoPlayer.this.P);
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
        if (this.nHK != null) {
            this.nHK.release();
            this.nHK = null;
        }
        com.kascend.chushou.c.c.dYm().a(this.P, new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.VideoPlayer.18
            @Override // com.kascend.chushou.c.b
            public void a() {
            }

            @Override // com.kascend.chushou.c.b
            public void a(String str, JSONObject jSONObject) {
                if (!VideoPlayer.this.isFinishing()) {
                    ParserRet eo = com.kascend.chushou.c.e.eo(jSONObject);
                    if (eo.mRc == 0 && eo.mData != null) {
                        RoomExpandInfo roomExpandInfo = (RoomExpandInfo) eo.mData;
                        if (VideoPlayer.this.nHJ != null) {
                            VideoPlayer.this.nHJ.nJm = roomExpandInfo.mTopWebAdItem;
                            if (VideoPlayer.this.nHJ.nJs == null) {
                                VideoPlayer.this.nHJ.nJs = new ArrayList();
                            }
                            VideoPlayer.this.nHJ.nJs.clear();
                            VideoPlayer.this.nHJ.nJs.addAll(roomExpandInfo.mGiftTopRightIcons);
                            tv.chushou.zues.a.a.post(new i(50, VideoPlayer.this.nHJ.nJm));
                        }
                        if (VideoPlayer.this.nHJ != null) {
                            VideoPlayer.this.nHJ.fO(roomExpandInfo.mExpandNavList);
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
                            VideoPlayer.this.nHY.a(list);
                        }
                        List<com.kascend.chushou.player.ui.h5.c.c> list2 = roomExpandInfo.mLuckList;
                        if (!h.isEmpty(list2)) {
                            VideoPlayer.this.nHZ.a(list2);
                        }
                        com.kascend.chushou.player.ui.h5.c.c cVar = roomExpandInfo.mVoteItem;
                        if (cVar != null) {
                            VideoPlayer.this.nIa.a(cVar);
                        }
                        List<com.kascend.chushou.player.ui.h5.c.b> list3 = roomExpandInfo.mInteractH5Item;
                        if (!h.isEmpty(list3)) {
                            VideoPlayer.this.nId.a(list3);
                        }
                        List<com.kascend.chushou.player.ui.h5.c.b> list4 = roomExpandInfo.mInteractNavItem;
                        if (!h.isEmpty(list4)) {
                            VideoPlayer.this.nId.a(list4);
                        }
                        VideoPlayer.this.nHK = (PrivilegeInfo) eo.mData1;
                        if (VideoPlayer.this.nHK != null) {
                            tv.chushou.zues.a.a.post(new l());
                        }
                        if (VideoPlayer.this.nHJ != null) {
                            VideoPlayer.this.nHJ.nJt = roomExpandInfo.mIconConfig;
                            VideoPlayer.this.dYN().a(roomExpandInfo.mIconConfig.bangConfig);
                        }
                        List<SkinConfig> list5 = roomExpandInfo.skinConfig;
                        if (list5 != null && VideoPlayer.this.nHJ != null) {
                            VideoPlayer.this.nHJ.nJw.clear();
                            int i = 0;
                            while (true) {
                                int i2 = i;
                                if (i2 >= list5.size()) {
                                    break;
                                }
                                SkinConfig skinConfig = list5.get(i2);
                                VideoPlayer.this.nHJ.nJw.put(skinConfig.position, skinConfig.resource);
                                i = i2 + 1;
                            }
                            VideoPlayer.this.C();
                        }
                        VideoPlayer.this.a(roomExpandInfo.mIconConfig, VideoPlayer.this.nHJ != null ? VideoPlayer.this.nHJ.nJw : null);
                        if (roomExpandInfo.mColorMap != null && roomExpandInfo.mColorMap.size() > 0 && com.kascend.chushou.b.dYj().c != null && com.kascend.chushou.b.dYj().c.size() <= 0) {
                            com.kascend.chushou.b.dYj().c.putAll(roomExpandInfo.mColorMap);
                            tv.chushou.zues.a.a.post(new i(52, null));
                        }
                        AutoBang autoBang = roomExpandInfo.mAutoBang;
                        if (autoBang != null && autoBang.currentTime != 0 && autoBang.bangTime != 0) {
                            VideoPlayer.this.dYN().a(autoBang);
                        }
                        if (!h.isEmpty(roomExpandInfo.mRelatedRoomList) && VideoPlayer.this.nHJ != null) {
                            VideoPlayer.this.nHJ.t = roomExpandInfo.mRelatedRoomList;
                            if (VideoPlayer.this.nHH != null && VideoPlayer.this.H) {
                                VideoPlayer.this.nHH.w();
                            }
                        }
                        if (roomExpandInfo.mRoomNewUserInfo != null && roomExpandInfo.mRoomNewUserInfo.mBarrierNoviceGuide && !com.kascend.chushou.d.h.dYr().k() && VideoPlayer.this.nHH != null) {
                            VideoPlayer.this.nHH.J();
                        }
                        if (roomExpandInfo.mRoomNewUserInfo != null && roomExpandInfo.mRoomNewUserInfo.mRewardNoviceGuide && !com.kascend.chushou.d.h.dYr().l() && VideoPlayer.this.nHH != null) {
                            VideoPlayer.this.nHH.K();
                        }
                        if (!h.isEmpty(roomExpandInfo.mShopWindowInfos)) {
                            if (VideoPlayer.this.nHJ != null) {
                                if (VideoPlayer.this.nHJ.nJu == null) {
                                    VideoPlayer.this.nHJ.nJu = new ArrayList();
                                }
                                VideoPlayer.this.nHJ.nJu.addAll(roomExpandInfo.mShopWindowInfos);
                            }
                            if (VideoPlayer.this.nHH != null) {
                                VideoPlayer.this.nHH.L();
                            }
                        }
                        VideoPlayer.this.nIc.b = VideoPlayer.this.P;
                        if (roomExpandInfo.mPkNotifyInfo != null) {
                            VideoPlayer.this.nIc.nME = roomExpandInfo.mPkNotifyInfo;
                            if (VideoPlayer.this.nHH != null) {
                                VideoPlayer.this.nHH.a(roomExpandInfo.mPkNotifyInfo, VideoPlayer.this.P);
                            }
                        } else {
                            VideoPlayer.this.nIc.nME = null;
                        }
                        if (roomExpandInfo.mTrumpetPocket != null && VideoPlayer.this.nHJ != null) {
                            VideoPlayer.this.nHJ.nJv = roomExpandInfo.mTrumpetPocket;
                            if (VideoPlayer.this.nHH != null) {
                                VideoPlayer.this.nHH.M();
                            }
                        }
                        if (!h.isEmpty(roomExpandInfo.hotwordContentList)) {
                            if (VideoPlayer.this.nHJ != null) {
                                if (VideoPlayer.this.nHJ.w == null) {
                                    VideoPlayer.this.nHJ.w = new ArrayList();
                                }
                                VideoPlayer.this.nHJ.w.clear();
                                VideoPlayer.this.nHJ.w.addAll(roomExpandInfo.hotwordContentList);
                            }
                            if (VideoPlayer.this.nHH != null) {
                                VideoPlayer.this.nHH.b(roomExpandInfo.hotwordContentList);
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
        }, this.ag, this.nIe);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U() {
        if (!h.isEmpty(com.kascend.chushou.a.a.dYk().nHc)) {
            StringBuilder sb = new StringBuilder();
            if (com.kascend.chushou.a.a.dYk().nHc.contains(com.kascend.chushou.a.a.f)) {
                if (sb.length() > 0) {
                    sb.append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                sb.append(com.kascend.chushou.a.a.f);
            }
            if (com.kascend.chushou.a.a.dYk().nHc.contains(com.kascend.chushou.a.a.g)) {
                if (sb.length() > 0) {
                    sb.append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                sb.append(com.kascend.chushou.a.a.g);
            }
            if (com.kascend.chushou.a.a.dYk().nHc.contains(com.kascend.chushou.a.a.i)) {
                if (sb.length() > 0) {
                    sb.append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                sb.append(com.kascend.chushou.a.a.i);
            }
            if (com.kascend.chushou.a.a.dYk().nHc.contains(com.kascend.chushou.a.a.h)) {
                if (sb.length() > 0) {
                    sb.append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                sb.append(com.kascend.chushou.a.a.h);
            }
            if (com.kascend.chushou.a.a.dYk().nHc.contains(com.kascend.chushou.a.a.j)) {
                if (sb.length() > 0) {
                    sb.append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                sb.append(com.kascend.chushou.a.a.j);
            }
            if (com.kascend.chushou.a.a.dYk().nHc.contains(com.kascend.chushou.a.a.l)) {
                if (sb.length() > 0) {
                    sb.append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                sb.append(com.kascend.chushou.a.a.l);
            }
            if (com.kascend.chushou.a.a.dYk().nHc.contains(com.kascend.chushou.a.a.m)) {
                if (sb.length() > 0) {
                    sb.append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                sb.append(com.kascend.chushou.a.a.m);
            }
            if (sb.length() != 0) {
                com.kascend.chushou.a.a.dYk().a(sb.toString(), this.P, new a.c() { // from class: com.kascend.chushou.player.VideoPlayer.19
                    @Override // com.kascend.chushou.a.a.c
                    public void a(List<ListItem> list) {
                        if (VideoPlayer.this.nHJ != null && list != null) {
                            int i = 0;
                            while (true) {
                                int i2 = i;
                                if (i2 >= list.size()) {
                                    break;
                                }
                                if (list.get(i2).mAdExtraInfo != null) {
                                    if (com.kascend.chushou.a.a.f.equals(list.get(i2).mAdExtraInfo.mCode)) {
                                        VideoPlayer.this.nHJ.nJl = list.get(i2);
                                    } else if (com.kascend.chushou.a.a.g.equals(list.get(i2).mAdExtraInfo.mCode)) {
                                        VideoPlayer.this.nHJ.nJk = list.get(i2);
                                    } else if (com.kascend.chushou.a.a.i.equals(list.get(i2).mAdExtraInfo.mCode)) {
                                        VideoPlayer.this.nHJ.nJn = list.get(i2);
                                    } else if (com.kascend.chushou.a.a.h.equals(list.get(i2).mAdExtraInfo.mCode)) {
                                        VideoPlayer.this.nHJ.nJo = list.get(i2);
                                    } else if (com.kascend.chushou.a.a.j.equals(list.get(i2).mAdExtraInfo.mCode)) {
                                        VideoPlayer.this.nHJ.nJr = list.get(i2);
                                    } else if (com.kascend.chushou.a.a.l.equals(list.get(i2).mAdExtraInfo.mCode)) {
                                        VideoPlayer.this.nHJ.nJp = list.get(i2);
                                    } else if (com.kascend.chushou.a.a.m.equals(list.get(i2).mAdExtraInfo.mCode)) {
                                        VideoPlayer.this.nHJ.nJq = list.get(i2);
                                    }
                                }
                                i = i2 + 1;
                            }
                            if (VideoPlayer.this.nHH != null) {
                                VideoPlayer.this.nHH.H();
                            }
                        }
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str, String str2) {
        if (dYF()) {
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
                this.nHO.setSystemUiVisibility(i);
                return;
            }
            this.nHO.setSystemUiVisibility(1792);
        }
    }

    public void f(boolean z) {
        Window window;
        View decorView;
        if (com.kascend.chushou.b.dYj().d != 1 && (window = getWindow()) != null && (decorView = window.getDecorView()) != null) {
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
        if (this.nHH != null) {
            this.nHH.a(i, i2, intent);
        }
    }

    public Uri dYG() {
        return this.nHC;
    }

    @Override // com.kascend.chushou.view.base.BaseActivity
    protected int y() {
        return 0;
    }

    public void ys(boolean z) {
        if (this.nHO != null) {
            this.nHO.oQe = z;
        }
    }

    public void dYH() {
        if (this.nHO != null) {
            this.nHO.dYH();
        }
    }

    public boolean dYI() {
        return this.ae;
    }

    public void g(boolean z) {
        this.ae = z;
    }

    public void h(boolean z) {
        if (this.nHO != null) {
            this.nHO.setIsTranslucentStatus(z);
        }
    }

    public void z() {
        if (this.nHO != null) {
            this.nHO.emI();
        }
    }

    @Override // com.kascend.chushou.widget.gifts.RoomSendGiftView.a
    public void A() {
        if (this.nHM != null) {
            this.nHM.b();
        }
        if (this.nHJ != null) {
            this.nHJ.z = true;
        }
    }

    @Override // com.kascend.chushou.widget.gifts.RoomSendGiftView.a
    public void B() {
        if (this.nHM != null) {
            this.nHM.b();
        }
    }

    public void a(List<ListItem> list) {
        if (this.nHH != null) {
            this.nHH.a(list);
        }
    }

    public void a(IconConfig iconConfig, Map<String, SkinConfig.SkinRes> map) {
        if (this.nHH != null) {
            this.nHH.a(iconConfig, map);
        }
    }

    public void C() {
        if (this.nHH != null) {
            this.nHH.I();
        }
    }

    @Override // com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC0898a
    public void a(int i) {
        if (this.nHH != null) {
            this.nHH.a(i);
        }
    }

    @Override // com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC0898a
    public void D() {
        if (!isFinishing() && this.nHH != null) {
            this.nHH.D();
        }
    }

    @Override // com.kascend.chushou.player.ui.h5.b.b.a
    public void a(long j) {
        if (!isFinishing() && this.nHH != null) {
            this.nHH.a(j);
        }
    }

    @Override // com.kascend.chushou.player.ui.h5.b.b.a
    public void a(com.kascend.chushou.player.ui.h5.c.a aVar) {
        if (aVar != null && this.nHH != null) {
            this.nHH.a(aVar);
        }
    }

    @Override // com.kascend.chushou.player.ui.h5.b.b.a
    public void b(int i) {
        if (this.nHH != null) {
            this.nHH.b(i);
        }
    }

    @Override // com.kascend.chushou.player.ui.h5.d.a.InterfaceC0897a
    public void b(long j) {
        if (!isFinishing() && this.nHH != null) {
            this.nHH.b(j);
        }
    }

    @Override // com.kascend.chushou.player.ui.h5.a.a.InterfaceC0895a
    public void c(int i) {
        if (!isFinishing() && this.nHH != null) {
            this.nHH.c(i);
        }
    }

    @Override // com.kascend.chushou.player.ui.h5.d.a.InterfaceC0897a
    public void b(com.kascend.chushou.player.ui.h5.c.a aVar) {
        if (aVar != null && this.nHH != null) {
            this.nHH.b(aVar);
        }
    }

    @Override // com.kascend.chushou.player.ui.a.a.InterfaceC0892a
    public void a(IconConfig.Config config) {
        if (this.nHH != null) {
            this.nHH.a(config);
        }
    }

    @Override // com.kascend.chushou.player.ui.a.a.InterfaceC0892a
    public void a(BangInfo bangInfo, String str) {
        if (this.nHH != null) {
            this.nHH.a(bangInfo, str);
        }
    }

    @Override // com.kascend.chushou.player.ui.a.a.InterfaceC0892a
    public void a(long j, BangInfo bangInfo, String str) {
        if (this.nHH != null) {
            this.nHH.a(j, bangInfo, str);
        }
    }

    public com.kascend.chushou.player.ui.h5.redpacket.a dYJ() {
        return this.nHY;
    }

    public com.kascend.chushou.player.ui.h5.b.b dYK() {
        return this.nHZ;
    }

    public com.kascend.chushou.player.ui.h5.d.a dYL() {
        return this.nIa;
    }

    public com.kascend.chushou.player.ui.h5.a.a dYM() {
        return this.nId;
    }

    public com.kascend.chushou.player.ui.a.a dYN() {
        return this.nIb;
    }

    public com.kascend.chushou.player.e.a dYO() {
        return this.nIc;
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
        RxExecutor.postDelayed(this.nIg, EventThread.MAIN_THREAD, aVar.d, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.VideoPlayer.2
            @Override // java.lang.Runnable
            public void run() {
                if (VideoPlayer.this.nHH != null) {
                    VideoPlayer.this.nHH.c(aVar);
                }
            }
        });
    }

    private void e(final com.kascend.chushou.player.ui.h5.c.a aVar) {
        if (!com.kascend.chushou.d.h.dYr().dYu().contains(aVar.b)) {
            if (aVar.d < 0) {
                aVar.d = 0;
            }
            RxExecutor.postDelayed(this.nIg, EventThread.MAIN_THREAD, aVar.d, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.VideoPlayer.3
                @Override // java.lang.Runnable
                public void run() {
                    if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.nHH != null) {
                        VideoPlayer.this.nHH.c(aVar);
                    }
                }
            });
        }
    }

    private String dYP() {
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
                if (VideoPlayer.this.nHN != null && !VideoPlayer.this.isFinishing()) {
                    VideoPlayer.n = VideoPlayer.this.nHN.getStreamVolume(3);
                }
                if (!VideoPlayer.this.isFinishing() && (VideoPlayer.this.nHH instanceof f)) {
                    ((f) VideoPlayer.this.nHH).ab();
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

    public boolean dYQ() {
        if (this.nHH instanceof com.kascend.chushou.player.d.a) {
            return ((com.kascend.chushou.player.d.a) this.nHH).dZO();
        }
        if (this.nHH instanceof com.kascend.chushou.player.e.e) {
            return true;
        }
        return false;
    }
}

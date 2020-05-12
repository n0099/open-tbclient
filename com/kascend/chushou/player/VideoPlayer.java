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
public class VideoPlayer extends BaseActivity implements a.InterfaceC0746a, a.InterfaceC0749a, b.a, a.InterfaceC0751a, a.InterfaceC0752a, RoomSendGiftView.a {
    private static int A = 60000;
    public static String a = null;
    public static int n = 0;
    private String P;
    private String Q;
    private String R;
    private String S;
    private ImageView Z;
    private String ab;
    private c mnT;
    b mnW;
    public PrivilegeInfo mnY;
    com.kascend.chushou.widget.a.b moc;
    private KPSwitchRootRelativeLayout moe;
    private FrameLayout mof;
    private LinearLayout mog;
    private com.kascend.chushou.toolkit.d moh;
    com.kascend.chushou.view.b.a.a moi;
    private String mol;
    private FrescoThumbnailView mom;
    private FrameLayout moo;
    public com.kascend.chushou.player.feedback.a mow;
    private a moy;
    private CSTVWifiReceiver moz;
    private boolean B = true;
    private boolean C = false;
    private Uri mnP = null;
    private tv.chushou.common.player.a mnQ = null;
    public tv.chushou.common.player.a mnR = null;
    public tv.chushou.common.player.a mnS = null;
    public boolean d = false;
    public boolean e = false;
    private e mnU = null;
    private boolean H = false;
    private com.kascend.chushou.view.user.b mnV = null;
    private boolean J = false;
    private boolean K = false;
    private boolean L = false;
    private boolean M = false;
    private long mnX = 0;
    private int O = 0;
    public boolean g = false;
    private ImageView mnZ = null;
    private TextView moa = null;
    private AnimationImageView mob = null;
    private View bqS = null;
    public boolean j = false;
    public float k = 0.0f;
    public float l = 0.0f;
    public boolean m = false;
    public AudioManager mod = null;
    private d.a moj = new d.a() { // from class: com.kascend.chushou.player.VideoPlayer.1
        @Override // com.kascend.chushou.toolkit.d.a
        public void a() {
            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.moA != null) {
                VideoPlayer.this.moA.JF(4);
            }
        }
    };
    private boolean ae = false;
    public boolean q = true;
    public long r = -1;
    public long s = -1;
    private PowerManager.WakeLock mok = null;
    public String t = null;
    private final com.kascend.chushou.player.ui.h5.redpacket.a mop = new com.kascend.chushou.player.ui.h5.redpacket.a(this);
    private final com.kascend.chushou.player.ui.h5.b.b moq = new com.kascend.chushou.player.ui.h5.b.b(this);
    private final com.kascend.chushou.player.ui.h5.d.a mor = new com.kascend.chushou.player.ui.h5.d.a(this);
    private final com.kascend.chushou.player.ui.a.a mos = new com.kascend.chushou.player.ui.a.a(this);
    private final com.kascend.chushou.player.e.a mot = new com.kascend.chushou.player.e.a();
    private final com.kascend.chushou.player.ui.h5.a.a mou = new com.kascend.chushou.player.ui.h5.a.a(this);
    private String mov = "1";
    private String aq = "2";
    private io.reactivex.disposables.a mox = new io.reactivex.disposables.a();
    private tv.chushou.zues.c moA = new tv.chushou.zues.c(new Handler.Callback() { // from class: com.kascend.chushou.player.VideoPlayer.6
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            try {
                if (!VideoPlayer.this.isFinishing()) {
                    switch (message.what) {
                        case 1:
                            VideoPlayer.this.moA.removeMessages(1);
                            com.kascend.chushou.c.c.dwE().a(VideoPlayer.this.P, VideoPlayer.this.mnW != null ? VideoPlayer.this.mnW.h : null, System.currentTimeMillis());
                            VideoPlayer.this.moA.A(1, VideoPlayer.A);
                            break;
                        case 2:
                            VideoPlayer.this.a(true, (Uri) null, false);
                            break;
                        case 3:
                            VideoPlayer.this.dla();
                            break;
                        case 4:
                            if (VideoPlayer.this.mnU != null) {
                                VideoPlayer.this.mnU.a(true);
                            }
                            if (VideoPlayer.this.moh != null) {
                                VideoPlayer.this.moh.d();
                                VideoPlayer.this.moh = null;
                                break;
                            }
                            break;
                        case 5:
                            int i = message.arg1;
                            if (i == 1) {
                                if (VideoPlayer.this.mnU != null) {
                                    VideoPlayer.this.mnU.p();
                                    break;
                                }
                            } else if (i == 2 && VideoPlayer.this.mnU != null) {
                                VideoPlayer.this.mnU.e(message.arg2);
                                break;
                            }
                            break;
                        case 6:
                            if (!com.kascend.chushou.b.dwB().a && !com.kascend.chushou.b.dwB().b && VideoPlayer.this.mnU != null) {
                                VideoPlayer.this.mnU.g(true);
                                break;
                            } else {
                                VideoPlayer.this.c();
                                break;
                            }
                            break;
                        case 7:
                            tv.chushou.zues.utils.e.d(VideoPlayer.this.v, "MSG_BUFFER_DEALY: ");
                            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.mnU != null && VideoPlayer.this.M && !VideoPlayer.this.e) {
                                VideoPlayer.this.mnU.h(true);
                                VideoPlayer.this.mnX = 0L;
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
    private boolean moB = true;
    private boolean moC = false;
    private tv.chushou.common.player.b moD = new tv.chushou.common.player.b() { // from class: com.kascend.chushou.player.VideoPlayer.14
        @Override // tv.chushou.common.player.b
        public void dxi() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerACallback onSetVideoViewLayout");
            if (!VideoPlayer.this.isFinishing()) {
                if ((VideoPlayer.this.mnU == null || !VideoPlayer.this.mnU.H) && VideoPlayer.this.mnU != null && !VideoPlayer.this.d) {
                    VideoPlayer.this.mnU.y();
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void Ii(int i) {
            if (!VideoPlayer.this.isFinishing()) {
                if ((VideoPlayer.this.mnU == null || !VideoPlayer.this.mnU.H) && VideoPlayer.this.mnU != null && !VideoPlayer.this.d) {
                    VideoPlayer.this.mnU.g(i);
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void dxj() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerACallback onCompletePlayback");
            if (!VideoPlayer.this.isFinishing()) {
                if (!h.isEmpty(VideoPlayer.this.P)) {
                    j.dwN().a(VideoPlayer.this.P, 0);
                }
                VideoPlayer.this.K = false;
                if (VideoPlayer.this.moA != null) {
                    VideoPlayer.this.moA.removeMessages(1);
                }
                if ((VideoPlayer.this.mnU == null || !VideoPlayer.this.mnU.H) && VideoPlayer.this.mnU != null && !VideoPlayer.this.d) {
                    VideoPlayer.this.moA.removeMessages(7);
                    VideoPlayer.this.M = false;
                    VideoPlayer.this.mnU.z();
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void dxk() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerACallback onVideoRenderingStart");
            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.mnU != null) {
                VideoPlayer.this.mnU.G();
            }
        }

        @Override // tv.chushou.common.player.b
        public void dxl() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerACallback onPreparedPlayback");
            if (!VideoPlayer.this.isFinishing()) {
                if (VideoPlayer.this.mnU == null || !VideoPlayer.this.mnU.H) {
                    VideoPlayer.this.moA.removeMessages(6);
                    VideoPlayer.this.mnX = 0L;
                    VideoPlayer.this.O = 0;
                    if (VideoPlayer.this.mnQ != null && VideoPlayer.this.mnU != null) {
                        VideoPlayer.this.mnQ.setVolume(VideoPlayer.this.mnU.J, VideoPlayer.this.mnU.J);
                    }
                    if (VideoPlayer.this.mnW != null) {
                        VideoPlayer.this.K = false;
                        FullRoomInfo dxt = VideoPlayer.this.dwV() ? null : VideoPlayer.this.mnW.dxt();
                        if (VideoPlayer.this.L || dxt != null) {
                            if (VideoPlayer.this.mnW.e) {
                                VideoPlayer.this.mnW.e = false;
                                VideoPlayer.this.mnW.d = !VideoPlayer.this.mnW.d;
                            }
                            if (VideoPlayer.this.mnU != null) {
                                VideoPlayer.this.c("1", (String) null);
                                if (!VideoPlayer.this.d) {
                                    VideoPlayer.this.mnU.i(true);
                                } else if (VideoPlayer.this.e) {
                                    VideoPlayer.this.e = false;
                                    VideoPlayer.this.mnU.B();
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
                if (VideoPlayer.this.moA != null) {
                    VideoPlayer.this.moA.removeMessages(7);
                }
                if (VideoPlayer.this.moA != null) {
                    VideoPlayer.this.moA.removeMessages(1);
                }
                if ((VideoPlayer.this.mnU == null || !VideoPlayer.this.mnU.H) && !VideoPlayer.this.dwP()) {
                    if (!"10004".equals(VideoPlayer.this.t)) {
                        if (VideoPlayer.this.mnU != null) {
                            if (VideoPlayer.this.d) {
                                VideoPlayer.this.mnR.stop();
                                VideoPlayer.this.mnR.release();
                                VideoPlayer.this.e = false;
                                VideoPlayer.this.mnU.C();
                            }
                            if (!com.kascend.chushou.b.dwB().a && !com.kascend.chushou.b.dwB().b) {
                                VideoPlayer.this.mnU.g(true);
                            } else if (VideoPlayer.this.d) {
                                VideoPlayer.this.mnU.a(i, true);
                            } else {
                                VideoPlayer.this.mnU.a(i, false);
                            }
                            VideoPlayer.this.c("2", (String) null);
                            return;
                        }
                        return;
                    }
                    dxj();
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void dxm() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerACallback onBufferingStart");
            if (!VideoPlayer.this.isFinishing()) {
                if ((VideoPlayer.this.mnU == null || !VideoPlayer.this.mnU.H) && VideoPlayer.this.mnU != null && !VideoPlayer.this.d) {
                    VideoPlayer.this.mnU.E();
                    VideoPlayer.this.M = true;
                    long currentTimeMillis = System.currentTimeMillis();
                    VideoPlayer.this.moA.removeMessages(7);
                    if (!VideoPlayer.this.g) {
                        VideoPlayer.y(VideoPlayer.this);
                    }
                    tv.chushou.zues.utils.e.d(VideoPlayer.this.v, "currentTime: -- >" + currentTimeMillis + "  bufferTime-->" + VideoPlayer.this.mnX + "  bufferCount-->" + VideoPlayer.this.O);
                    if (currentTimeMillis - VideoPlayer.this.mnX >= 20000 || VideoPlayer.this.O < 2 || VideoPlayer.this.mnU.H) {
                        if (VideoPlayer.this.O == 1) {
                            VideoPlayer.this.mnX = currentTimeMillis;
                        }
                        VideoPlayer.this.moA.A(7, 5000L);
                    } else {
                        VideoPlayer.this.moA.JF(7);
                    }
                    if (VideoPlayer.this.g) {
                        VideoPlayer.this.g = false;
                    }
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void dxn() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerACallback onBufferingEnd");
            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.mnU != null && !VideoPlayer.this.d) {
                VideoPlayer.this.moA.removeMessages(7);
                VideoPlayer.this.M = false;
                if (VideoPlayer.this.mnU == null || !VideoPlayer.this.mnU.H) {
                    if (VideoPlayer.this.mnQ == null) {
                        VideoPlayer.this.mnU.a(false, true, false);
                    } else {
                        VideoPlayer.this.mnU.a(true, VideoPlayer.this.mnQ.getPlayState() == 4, VideoPlayer.this.mnQ.getPlayState() == 5);
                    }
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void dxo() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerACallback onPlayerStart");
            if (!VideoPlayer.this.isFinishing()) {
                if (VideoPlayer.this.mnU == null || !VideoPlayer.this.mnU.H) {
                    if (VideoPlayer.this.mnU != null && !VideoPlayer.this.d) {
                        if (VideoPlayer.this.mnQ != null) {
                            VideoPlayer.this.mnU.F();
                            VideoPlayer.this.mnU.a(true, VideoPlayer.this.mnQ.getPlayState() == 4, VideoPlayer.this.mnQ.getPlayState() == 5);
                        } else {
                            VideoPlayer.this.mnU.a(false, true, false);
                        }
                    }
                    if (VideoPlayer.this.moA != null && !VideoPlayer.this.dwV()) {
                        VideoPlayer.this.moA.removeMessages(1);
                        VideoPlayer.this.moA.A(1, VideoPlayer.A);
                    }
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void dxp() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerACallback onPlayerPause");
            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.moA != null) {
                VideoPlayer.this.moA.removeMessages(1);
            }
        }

        @Override // tv.chushou.common.player.b
        public void dxq() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerACallback onPlayerStop");
            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.dwV() && VideoPlayer.this.mnR != null && !h.isEmpty(VideoPlayer.this.P) && VideoPlayer.this.mnR.getCurrentPos() > 0) {
                j.dwN().a(VideoPlayer.this.P, VideoPlayer.this.mnR.getCurrentPos());
            }
        }
    };
    private tv.chushou.common.player.b moE = new tv.chushou.common.player.b() { // from class: com.kascend.chushou.player.VideoPlayer.15
        @Override // tv.chushou.common.player.b
        public void dxi() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerBCallback onSetVideoViewLayout");
            if (!VideoPlayer.this.isFinishing()) {
                if ((VideoPlayer.this.mnU == null || !VideoPlayer.this.mnU.H) && VideoPlayer.this.mnU != null && VideoPlayer.this.d) {
                    VideoPlayer.this.mnU.y();
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void Ii(int i) {
            if (!VideoPlayer.this.isFinishing()) {
                if ((VideoPlayer.this.mnU == null || !VideoPlayer.this.mnU.H) && VideoPlayer.this.mnU != null && VideoPlayer.this.d) {
                    VideoPlayer.this.mnU.g(i);
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void dxj() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerBCallback onCompletePlayback");
            if (!VideoPlayer.this.isFinishing()) {
                if (!h.isEmpty(VideoPlayer.this.P)) {
                    j.dwN().a(VideoPlayer.this.P, 0);
                }
                VideoPlayer.this.K = false;
                if (VideoPlayer.this.moA != null) {
                    VideoPlayer.this.moA.removeMessages(1);
                }
                if ((VideoPlayer.this.mnU == null || !VideoPlayer.this.mnU.H) && VideoPlayer.this.mnU != null && VideoPlayer.this.d) {
                    VideoPlayer.this.moA.removeMessages(7);
                    VideoPlayer.this.M = false;
                    VideoPlayer.this.mnU.z();
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void dxk() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerBCallback onVideoRenderingStart");
            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.mnU != null) {
                VideoPlayer.this.mnU.G();
            }
        }

        @Override // tv.chushou.common.player.b
        public void dxl() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerBCallback onPreparedPlayback");
            if (!VideoPlayer.this.isFinishing()) {
                if (VideoPlayer.this.mnU == null || !VideoPlayer.this.mnU.H) {
                    VideoPlayer.this.moA.removeMessages(6);
                    VideoPlayer.this.mnX = 0L;
                    VideoPlayer.this.O = 0;
                    if (VideoPlayer.this.mnQ != null && VideoPlayer.this.mnU != null) {
                        VideoPlayer.this.mnQ.setVolume(VideoPlayer.this.mnU.J, VideoPlayer.this.mnU.J);
                    }
                    if (VideoPlayer.this.mnW != null) {
                        VideoPlayer.this.K = false;
                        FullRoomInfo dxt = VideoPlayer.this.dwV() ? null : VideoPlayer.this.mnW.dxt();
                        if (VideoPlayer.this.L || dxt != null) {
                            if (VideoPlayer.this.mnW.e) {
                                VideoPlayer.this.mnW.e = false;
                                VideoPlayer.this.mnW.d = !VideoPlayer.this.mnW.d;
                            }
                            if (VideoPlayer.this.mnU != null) {
                                VideoPlayer.this.c("1", (String) null);
                                if (VideoPlayer.this.d) {
                                    VideoPlayer.this.mnU.i(true);
                                } else if (VideoPlayer.this.e) {
                                    VideoPlayer.this.e = false;
                                    VideoPlayer.this.mnU.B();
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
                if (VideoPlayer.this.moA != null) {
                    VideoPlayer.this.moA.removeMessages(7);
                }
                if (VideoPlayer.this.moA != null) {
                    VideoPlayer.this.moA.removeMessages(1);
                }
                if ((VideoPlayer.this.mnU == null || !VideoPlayer.this.mnU.H) && !VideoPlayer.this.dwP()) {
                    if (!"10004".equals(VideoPlayer.this.t)) {
                        if (VideoPlayer.this.mnU != null) {
                            if (!VideoPlayer.this.d) {
                                VideoPlayer.this.mnS.stop();
                                VideoPlayer.this.mnS.release();
                                VideoPlayer.this.mnU.C();
                                VideoPlayer.this.e = false;
                            }
                            if (!com.kascend.chushou.b.dwB().a && !com.kascend.chushou.b.dwB().b) {
                                VideoPlayer.this.mnU.g(true);
                            } else if (VideoPlayer.this.d) {
                                VideoPlayer.this.mnU.a(i, false);
                            } else {
                                VideoPlayer.this.mnU.a(i, true);
                            }
                            VideoPlayer.this.c("2", (String) null);
                            return;
                        }
                        return;
                    }
                    dxj();
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void dxm() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerBCallback onBufferingStart");
            if (!VideoPlayer.this.isFinishing()) {
                if ((VideoPlayer.this.mnU == null || !VideoPlayer.this.mnU.H) && VideoPlayer.this.mnU != null && VideoPlayer.this.d) {
                    VideoPlayer.this.mnU.E();
                    VideoPlayer.this.M = true;
                    VideoPlayer.this.moA.removeMessages(7);
                    long currentTimeMillis = System.currentTimeMillis();
                    if (!VideoPlayer.this.g) {
                        VideoPlayer.y(VideoPlayer.this);
                    }
                    tv.chushou.zues.utils.e.d(VideoPlayer.this.v, "currentTime: -- >" + currentTimeMillis + "  bufferTime-->" + VideoPlayer.this.mnX + "  bufferCount-->" + VideoPlayer.this.O);
                    if (currentTimeMillis - VideoPlayer.this.mnX >= 20000 || VideoPlayer.this.O < 2 || VideoPlayer.this.mnU.H) {
                        if (VideoPlayer.this.O == 1) {
                            VideoPlayer.this.mnX = currentTimeMillis;
                        }
                        VideoPlayer.this.moA.A(7, 5000L);
                    } else {
                        VideoPlayer.this.mnX = 0L;
                        VideoPlayer.this.O = 0;
                        VideoPlayer.this.moA.JF(7);
                    }
                    if (VideoPlayer.this.g) {
                        VideoPlayer.this.g = false;
                    }
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void dxn() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerBCallback onBufferingEnd");
            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.mnU != null && VideoPlayer.this.d) {
                VideoPlayer.this.M = false;
                VideoPlayer.this.moA.removeMessages(7);
                if (VideoPlayer.this.mnU == null || !VideoPlayer.this.mnU.H) {
                    if (VideoPlayer.this.mnQ == null) {
                        VideoPlayer.this.mnU.a(false, true, false);
                    } else {
                        VideoPlayer.this.mnU.a(true, VideoPlayer.this.mnQ.getPlayState() == 4, VideoPlayer.this.mnQ.getPlayState() == 5);
                    }
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void dxo() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerBCallback onPlayerStart");
            if (!VideoPlayer.this.isFinishing()) {
                if (VideoPlayer.this.mnU == null || !VideoPlayer.this.mnU.H) {
                    if (VideoPlayer.this.mnU != null && VideoPlayer.this.d) {
                        if (VideoPlayer.this.mnQ != null) {
                            VideoPlayer.this.mnU.F();
                            VideoPlayer.this.mnU.a(true, VideoPlayer.this.mnQ.getPlayState() == 4, VideoPlayer.this.mnQ.getPlayState() == 5);
                        } else {
                            VideoPlayer.this.mnU.a(false, true, false);
                        }
                    }
                    if (VideoPlayer.this.moA != null && !VideoPlayer.this.dwV()) {
                        VideoPlayer.this.moA.removeMessages(1);
                        VideoPlayer.this.moA.A(1, VideoPlayer.A);
                    }
                }
            }
        }

        @Override // tv.chushou.common.player.b
        public void dxp() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerBCallback onPlayerPause");
            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.moA != null) {
                VideoPlayer.this.moA.removeMessages(1);
            }
        }

        @Override // tv.chushou.common.player.b
        public void dxq() {
            tv.chushou.zues.utils.e.i(VideoPlayer.this.v, "mPlayerBCallback onPlayerStop");
            if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.dwV() && VideoPlayer.this.mnS != null && !h.isEmpty(VideoPlayer.this.P) && VideoPlayer.this.mnS.getCurrentPos() > 0) {
                j.dwN().a(VideoPlayer.this.P, VideoPlayer.this.mnS.getCurrentPos());
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
        this.mnP = intent.getData();
        if (this.mnP == null) {
            finish();
            return;
        }
        com.kascend.chushou.d.e.j();
        if (this.moz == null) {
            this.moz = new CSTVWifiReceiver();
            registerReceiver(this.moz, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        }
        com.kascend.chushou.toolkit.d.a.dyL().b();
        tv.chushou.zues.utils.e.i(this.v, "intent.getData=" + this.mnP.toString());
        String scheme = this.mnP.getScheme();
        if (scheme == null || !scheme.equals("chushou")) {
            tv.chushou.zues.utils.e.e(this.v, "not support scheme :" + scheme);
            finish();
            return;
        }
        a(intent);
    }

    private void a(Intent intent) {
        this.P = this.mnP.getQueryParameter("roomId");
        this.Q = this.P;
        this.S = this.mnP.getQueryParameter(WebSocketRequest.PARAM_KEY_PROTOCOLS);
        this.aq = this.mnP.getQueryParameter("liveType");
        if ("2".equals(this.aq) || "3".equals(this.aq) || "4".equals(this.aq)) {
            this.mov = "2";
            this.mow = new com.kascend.chushou.player.feedback.a();
            if (this.mow.mwM != null) {
                this.mow.mwM.reset();
                this.mow.mwM.roomId = this.P;
                this.mow.mwM.enterType = 1;
                this.mow.b = System.currentTimeMillis();
            }
        }
        if (h.isEmpty(this.P) || h.isEmpty(this.S)) {
            tv.chushou.zues.utils.e.e(this.v, "invalid param mItemID=" + this.P + " protocols=" + this.S);
            finish();
            return;
        }
        if (com.kascend.chushou.b.dwB().d == -1) {
            com.kascend.chushou.b.dwB().d = com.kascend.chushou.d.g.b() ? 1 : 0;
        }
        this.mok = ((PowerManager) getSystemService("power")).newWakeLock(536870938, this.v);
        this.mok.acquire();
        this.mnW = new b(this.P);
        this.mnW.d = intent.getBooleanExtra("room_play_audio", false);
        this.moc = new com.kascend.chushou.widget.a.b();
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
        this.moe = (KPSwitchRootRelativeLayout) findViewById(a.f.rlRoot);
        if (!"2".equals(this.mov) && com.kascend.chushou.b.dwB().d == 1) {
            this.moe.setFitsSystemWindows(true);
        }
        this.mof = (FrameLayout) this.moe.findViewById(a.f.fl_fragment);
        this.bqS = this.moe.findViewById(a.f.rl_empty);
        this.mnZ = (ImageView) this.bqS.findViewById(a.f.iv_empty);
        this.moa = (TextView) this.bqS.findViewById(a.f.tv_empty);
        this.mog = (LinearLayout) this.moe.findViewById(a.f.rl_title);
        this.Z = (ImageView) this.mog.findViewById(a.f.back_icon);
        this.Z.setOnClickListener(new View.OnClickListener() { // from class: com.kascend.chushou.player.VideoPlayer.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                VideoPlayer.this.finish();
            }
        });
        this.mob = (AnimationImageView) this.bqS.findViewById(a.f.iv_loading);
        this.mom = (FrescoThumbnailView) this.moe.findViewById(a.f.live_cover);
        this.moo = (FrameLayout) this.moe.findViewById(a.f.fl_cover);
        this.k = dwO();
        try {
            this.mod = (AudioManager) getApplicationContext().getSystemService("audio");
            n = this.mod.getStreamVolume(3);
            this.mod.requestAudioFocus(null, 3, 1);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (this.B) {
            a(1, dwV() ? "3" : "1");
        } else {
            r();
        }
        if (com.kascend.chushou.b.dwB().b && !com.kascend.chushou.b.dwB().a) {
            RxExecutor.postDelayed(this.mox, EventThread.MAIN_THREAD, 60L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.VideoPlayer.5
                @Override // java.lang.Runnable
                public void run() {
                    if (!VideoPlayer.this.isFinishing() && com.kascend.chushou.b.dwB().b && !com.kascend.chushou.b.dwB().a) {
                        tv.chushou.zues.utils.g.c(VideoPlayer.this.w, VideoPlayer.this.getString(a.i.str_monet_notify));
                    }
                }
            });
        }
        com.kascend.chushou.c.c.dwE().a(this.P, stringExtra, System.currentTimeMillis());
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
        if (this.moy == null) {
            this.moy = new a();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.media.VOLUME_CHANGED_ACTION");
            registerReceiver(this.moy, intentFilter);
        }
    }

    @Override // android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        j(false);
        if (this.moy != null) {
            unregisterReceiver(this.moy);
            this.moy = null;
        }
        super.onStop();
    }

    @Override // com.kascend.chushou.view.base.BaseActivity
    protected void a(boolean z) {
        if (this.mnU != null) {
            this.mnU.k(z);
        }
    }

    @Subscribe
    public void onHideGiftEffectEvent(com.kascend.chushou.b.a.a.f fVar) {
        if (fVar.b) {
            this.mnU.k();
            return;
        }
        this.mnU.m();
        this.mnU.l();
    }

    private float dwO() {
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
        this.mol = str;
        R();
        try {
            if (h.isEmpty(str)) {
                jSONObject = new JSONObject();
            } else {
                jSONObject = new JSONObject(str);
            }
            jSONObject.put("_fbroomid", this.P);
            this.mnW.h = jSONObject.toString();
            String optString = jSONObject.optString("_thumb");
            jSONObject.optBoolean("tag_from_game_mic", false);
            if (!h.isEmpty(optString)) {
                this.ab = optString;
            }
        } catch (JSONException e) {
            e.printStackTrace();
            this.mnW.h = str;
        }
        if (dwV()) {
            a(this.P, str);
            aL(this.P, z);
            return;
        }
        a = this.P;
        b(this.P, str);
        a(this.P, dxf(), z);
        w();
    }

    private void O() {
        this.m = true;
        j();
        if (this.mnU != null) {
            this.mnU.r();
        }
        s();
    }

    @Subscribe
    public void onStartRoomEvent(o oVar) {
        if (!isFinishing() && oVar.mnw != null && oVar.c != null && !h.isEmpty(oVar.mnw.mTargetKey)) {
            if (oVar.c != this) {
                tv.chushou.zues.utils.e.e(this.v, "different player!");
                return;
            }
            if (this.mnW != null) {
                this.mnW.a();
                this.mnW.a = oVar.mnw.mTargetKey;
                this.mnW.d = oVar.d;
                if (this.mnW.mpy != null) {
                    this.mnW.mpy.e();
                }
                if (this.mnW.mpy != null) {
                    this.mnW.mpy.b();
                }
                this.mnW.mpB = null;
                this.mnW.mpA = null;
                this.mnW.mpE = null;
                this.mnW.mpD = null;
                this.mnW.mpH = null;
                this.mnW.mpF = null;
                this.mnW.mpG = null;
            }
            if (this.mod != null) {
                n = this.mod.getStreamVolume(3);
            }
            if (!h.isEmpty(oVar.mnw.mType) && oVar.mnw.mType.equals("3")) {
                this.B = false;
                this.mov = "1";
                r();
                this.P = oVar.mnw.mTargetKey;
                this.R = "3";
                if (this.moc != null) {
                    this.moc.a();
                }
                if (this.mnW != null) {
                    this.mnW.a((PlayUrl) null);
                    this.mnW.f();
                    if (this.mnW.c() != null) {
                        this.mnW.c().clear();
                    }
                    this.mnW.i.clear();
                }
                if (this.mnU != null) {
                    this.mnU.j();
                }
                s();
                if (this.moh != null) {
                    this.moh.d();
                    this.moh = null;
                }
                if (this.mox != null) {
                    this.mox.dispose();
                    this.mox = new io.reactivex.disposables.a();
                }
                a(oVar.e, false);
                return;
            }
            boolean z = this.R != null && this.R.equals("1");
            this.R = "1";
            this.mos.a();
            this.mor.a();
            this.moq.a();
            this.mop.c();
            this.mou.a();
            if (this.mox != null) {
                this.mox.dispose();
                this.mox = new io.reactivex.disposables.a();
            }
            if ("1".equals(oVar.f)) {
                this.H = false;
                if (this.mnW != null && !h.isEmpty(this.mnW.t)) {
                    this.mnW.t.clear();
                }
                this.ab = oVar.mnw.mCover;
                this.moo.setVisibility(0);
                this.mom.setBlur(true);
                this.mom.i(oVar.mnw.mCover, 0, 0, 0);
            }
            if (!oVar.mnw.mTargetKey.equals(this.P)) {
                this.aq = oVar.g;
                if (!z) {
                    this.B = false;
                    r();
                } else if (!"2".equals(this.mov) && ("2".equals(this.aq) || "3".equals(this.aq) || "4".equals(this.aq))) {
                    this.mov = "2";
                    this.mow = new com.kascend.chushou.player.feedback.a();
                    if (this.mow.mwM != null) {
                        this.mow.mwM.reset();
                        this.mow.mwM.roomId = oVar.mnw.mTargetKey;
                        this.mow.mwM.enterType = 1;
                        this.mow.b = System.currentTimeMillis();
                    }
                }
                this.B = false;
                this.P = oVar.mnw.mTargetKey;
                this.Q = this.P;
                this.ab = oVar.mnw.mCover;
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
                JSONObject O = com.kascend.chushou.d.e.O("_fromView", str, "_sc", oVar.mnw.mSC);
                com.kascend.chushou.toolkit.a.c.a(this.w, O);
                if (this.moc != null) {
                    this.moc.a();
                    this.moc.a(this.P);
                }
                if (this.mnW != null) {
                    this.mnW.a((PlayUrl) null);
                    this.mnW.f();
                    if (this.mnW.c() != null) {
                        this.mnW.c().clear();
                    }
                    this.mnW.i.clear();
                }
                if (this.mnU != null) {
                    this.mnU.j();
                }
                a(O.toString(), false);
                return;
            }
            tv.chushou.zues.utils.g.JO(a.i.str_same_room);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dwP() {
        FullRoomInfo dxt;
        String str;
        RoomInfo roomInfo;
        if (dwV()) {
            str = null;
            dxt = null;
        } else {
            dxt = this.mnW.dxt();
            str = (dxt == null || (roomInfo = dxt.mRoominfo) == null) ? null : roomInfo.mGameId;
        }
        return !this.L && (dxt == null || h.isEmpty(str));
    }

    @Subscribe
    public void onMessageEvent(i iVar) {
        if (!isFinishing() && iVar.a != 21 && iVar.a != 22) {
            if (iVar.a == 0 && (iVar.b instanceof Boolean)) {
                if (((Boolean) iVar.b).booleanValue() && !isFinishing()) {
                    w();
                    if (this.mnU != null) {
                        this.mnU.f();
                    }
                }
            } else if (iVar.a == 46) {
                if ((iVar.b instanceof String) && this.mnU != null) {
                    this.mnU.c((String) iVar.b);
                }
            } else if (iVar.a == 54) {
                if (iVar.b instanceof String) {
                    this.moq.a((String) iVar.b);
                }
            } else if (iVar.a == 55) {
                if (this.mnU != null) {
                    this.mnU.O();
                }
            } else if (iVar.a == 56 && this.mnU != null) {
                this.mnU.P();
            }
        }
    }

    @Subscribe
    public void onRefreshSubscribeEvent(m mVar) {
        if (isFinishing() && this.mnW != null && this.mnW.dxw() != null) {
            RoomInfo dxw = this.mnW.dxw();
            if (mVar.a(dxw.mCreatorUID, dxw.mRoomID)) {
                dxw.mIsSubscribed = mVar.c;
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
        if (this.m || this.mnR == null || this.mnS == null) {
            R();
        }
        if (this.moc != null) {
            this.moc.d();
        }
        if (!dwV()) {
            if (this.moh != null && !this.moh.c()) {
                this.moh.a();
            }
            v();
            if (this.mnW != null && this.mnW.dxt() != null && this.mnW.dxt().cycleLiveRoomInfo != null && !h.isEmpty(this.mnW.dxt().cycleLiveRoomInfo.roomId)) {
                u();
            }
        }
        super.onResume();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.view.base.BaseActivity, android.support.v7.app.AppCompatActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        tv.chushou.zues.utils.e.e(this.v, MissionEvent.MESSAGE_DESTROY);
        if (this.mnW != null && this.mnW.dxt() != null && this.mnW.dxt().cycleLiveRoomInfo != null && !h.isEmpty(this.mnW.dxt().cycleLiveRoomInfo.eventName)) {
            j.dwN().a(this.P + dxf());
        }
        if ("2".equals(this.mov) && this.mow != null && this.mow.mwM != null) {
            this.mow.mwM.time = System.currentTimeMillis() - this.mow.b;
            this.mow.a();
            this.mow.b();
        }
        this.mop.d();
        this.moq.b();
        this.mor.b();
        O();
        this.mol = null;
        a = null;
        if (this.moA != null) {
            this.moA.ca(null);
            this.moA = null;
        }
        if (this.moh != null) {
            this.moh.d();
            this.moh = null;
        }
        if (this.moc != null) {
            this.moc.c();
            this.moc = null;
        }
        if (this.mnW != null) {
            this.mnW.mpB = null;
            this.mnW.mpA = null;
        }
        if (this.mnW != null) {
            this.mnW.b();
            this.mnW = null;
        }
        this.mnP = null;
        this.mnU = null;
        this.mnV = null;
        this.mnY = null;
        this.mnZ = null;
        this.moa = null;
        this.mob = null;
        this.bqS = null;
        this.mod = null;
        this.moe = null;
        this.mof = null;
        this.Z = null;
        this.mog = null;
        if (this.mok != null && this.mok.isHeld()) {
            this.mok.release();
            this.mok = null;
        }
        if (this.moz != null) {
            unregisterReceiver(this.moz);
            this.moz = null;
        }
        h.dJV();
        tv.chushou.zues.a.a.cb(this);
        this.mox.dispose();
        this.mor.b();
        this.mos.b();
        this.mop.d();
        this.moq.b();
        this.mou.b();
        super.onDestroy();
        System.gc();
    }

    @Subscribe
    public void onSendGameGiftEvent(n nVar) {
        if (!isFinishing() && this.mnU != null) {
            this.mnU.a(nVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kascend.chushou.view.base.BaseActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        tv.chushou.zues.utils.e.d(this.v, MissionEvent.MESSAGE_PAUSE);
        if (this.moh != null) {
            this.moh.b();
        }
        if (this.moc != null) {
            this.moc.b(false);
        }
        k();
        this.m = true;
        super.onPause();
    }

    @Override // android.app.Activity
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.mnU != null ? this.mnU.a(motionEvent) : super.onTouchEvent(motionEvent);
    }

    public void c() {
        if ("1".equals(this.R)) {
            j.dwN().a(this.P + dxf());
        } else {
            j.dwN().b(this.P);
        }
    }

    private void a(boolean z, boolean z2) {
        int i = 0;
        tv.chushou.zues.utils.e.i(this.v, "startLoadingVideo <------------- mbPrepareingVideo = " + this.K);
        if (this.mnR != null) {
            this.mnR.setHardwearDecod(com.kascend.chushou.d.h.dwI().a);
        }
        if (this.mnS != null) {
            this.mnS.setHardwearDecod(com.kascend.chushou.d.h.dwI().a);
        }
        if (this.mnQ != null) {
            this.mnQ.setHardwearDecod(com.kascend.chushou.d.h.dwI().a);
        }
        if (!this.K) {
            if (z && this.mnU != null) {
                if (!z2) {
                    this.t = null;
                    this.mnU.e();
                }
            } else if (this.mnU != null && !z2) {
                this.t = null;
                this.mnU.H = false;
                RxExecutor.post(null, EventThread.MAIN_THREAD, new Runnable() { // from class: com.kascend.chushou.player.VideoPlayer.7
                    @Override // java.lang.Runnable
                    public void run() {
                        VideoPlayer.this.mnU.x();
                    }
                });
            }
            this.K = true;
            if (this.mnW != null && this.mnW.dxu() != null) {
                PlayUrl dxu = this.mnW.dxu();
                while (true) {
                    int i2 = i;
                    if (i2 >= dxu.mUrlDetails.size()) {
                        break;
                    }
                    UrlDetails urlDetails = dxu.mUrlDetails.get(i2);
                    if (urlDetails.mUrl.equals(dxu.mSelectedUrl)) {
                        String str = dxu.mUrlDetails.get(i2).mDefinitionType;
                        String str2 = urlDetails.mBitrate;
                    }
                    i = i2 + 1;
                }
            }
            if (z2) {
                if (this.d) {
                    this.mnR.setVideoURI(this.mnP);
                    this.mnR.open();
                    return;
                }
                this.mnS.setVideoURI(this.mnP);
                this.mnS.open();
                return;
            }
            this.mnQ.setVideoURI(this.mnP);
            this.mnQ.open();
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        try {
            if (motionEvent.getAction() == 0) {
                if (this.mnU != null && this.mnU.b(motionEvent)) {
                    return true;
                }
                if ("2".equals(this.mov) && this.mnU != null) {
                    this.mnU.a(motionEvent);
                }
            } else if (this.mnU != null && this.mnU.b(motionEvent)) {
                return true;
            }
            return super.dispatchTouchEvent(motionEvent);
        } catch (Exception e) {
            return false;
        }
    }

    @Override // android.support.v7.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.mnU != null && this.mnU.a(i, keyEvent)) {
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
        if (this.mnW != null && this.mnW.dxt() != null && this.mnW.dxt().cycleLiveRoomInfo != null && !h.isEmpty(this.mnW.dxt().cycleLiveRoomInfo.roomId)) {
            this.moo.setVisibility(0);
            this.mom.setBlur(true);
            this.mom.i(this.mnW.dxt().cycleLiveRoomInfo.avatar, 0, 0, 0);
            this.mom.setVisibility(0);
            j.dwN().a(this.P + dxf());
            this.mnP = null;
            R();
            this.Q = this.mnW.dxt().cycleLiveRoomInfo.roomId;
            a(this.P, dxf(), false);
        }
    }

    public void b(boolean z) {
        if (this.mnU != null) {
            this.mnU.j(z);
        }
    }

    public void a(boolean z, Uri uri, boolean z2) {
        tv.chushou.zues.utils.e.d(this.v, "loadIfNecessary reload=" + z + " isChangeLines-->" + z2);
        if (this.mnR != null && this.mnS != null) {
            if (uri != null) {
                this.mnP = uri;
            }
            if (z2) {
                this.e = z2;
            }
            this.M = false;
            this.mnX = 0L;
            this.O = 0;
            this.moA.removeMessages(7);
            if (z) {
                if (z2) {
                    if (!this.d) {
                        this.mnS.setOnActivityCallBack(this.moE);
                    } else {
                        this.mnR.setOnActivityCallBack(this.moD);
                    }
                } else if (this.d) {
                    this.mnS.setOnActivityCallBack(this.moE);
                } else {
                    this.mnR.setOnActivityCallBack(this.moD);
                }
                this.K = false;
                b(true, z2);
            } else if (!this.J) {
                b(true, z2);
            }
            this.moA.A(6, 3000L);
        }
    }

    private void b(boolean z, boolean z2) {
        VideoPlayInfo N;
        if ("1".equals(this.R)) {
            N = j.dwN().M(this.P + dxf(), 600000L);
        } else {
            N = j.dwN().N(this.P, 600000L);
        }
        if (N != null) {
            a(z, z2);
        } else if ("1".equals(this.R)) {
            a(this.P, dxf(), false);
        } else {
            aL(this.P, false);
        }
    }

    public tv.chushou.common.player.a dwQ() {
        return this.mnQ;
    }

    public tv.chushou.common.player.a dwR() {
        return this.mnR;
    }

    public tv.chushou.common.player.a dwS() {
        return this.mnS;
    }

    public void a(tv.chushou.common.player.a aVar) {
        this.mnQ = aVar;
    }

    public b dwT() {
        return this.mnW;
    }

    public com.kascend.chushou.widget.a.b dwU() {
        return this.moc;
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
        FullRoomInfo dxt;
        this.r = -1L;
        if (this.s != -1 && this.s != 0) {
            this.r = this.s;
            this.s = -1L;
        }
        if (dwV() && this.mnQ != null && this.mnQ.getPlayState() == 4) {
            this.r = this.mnQ.getCurrentPos();
        }
        this.av = false;
        tv.chushou.zues.utils.e.d(this.v, "screenChange()<-----");
        tv.chushou.zues.widget.kpswitch.b.d.hideKeyboard(this);
        if (str != null) {
            this.R = str;
        }
        if (!this.C || !z3 || "3".equals(this.R) || this.mnW == null || (dxt = this.mnW.dxt()) == null || dxt.mRoominfo == null || dxt.mRoominfo.mStyle != 1) {
            z5 = false;
        } else {
            z5 = true;
            i = 0;
        }
        if ("2".equals(this.mov)) {
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
            if (com.kascend.chushou.b.dwB().d == 1) {
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
        if (this.moc == null) {
            this.moc = new com.kascend.chushou.widget.a.b();
        }
        if (this.moc != null) {
            this.moc.a(this.P);
        }
        if (this.R.equals("5")) {
            FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
            if (this.mnU != null) {
                beginTransaction.remove(this.mnU);
                this.mnU = null;
            }
            if (this.mnV != null) {
                beginTransaction.remove(this.mnV);
                this.mnV = null;
            }
            this.mnV = new com.kascend.chushou.view.user.b();
            beginTransaction.add(a.f.fl_fragment, this.mnV);
            beginTransaction.commitAllowingStateLoss();
        } else {
            FragmentTransaction beginTransaction2 = getSupportFragmentManager().beginTransaction();
            if (this.mnU != null) {
                beginTransaction2.remove(this.mnU);
                this.mnU = null;
            }
            if (this.mnV != null) {
                beginTransaction2.remove(this.mnV);
                this.mnV = null;
            }
            if ("2".equals(this.mov)) {
                this.mnU = com.kascend.chushou.player.e.e.a(this.ab, z2, this.aq, this.P);
            } else if (1 == i) {
                if (!this.R.equals("3")) {
                    if (z4) {
                        v();
                    }
                    this.mnU = new com.kascend.chushou.player.d.a();
                    Bundle bundle = new Bundle();
                    bundle.putString("mCover", this.ab);
                    bundle.putBoolean("mInitViewAsync", z2);
                    this.mnU.setArguments(bundle);
                }
            } else {
                this.mnU = new com.kascend.chushou.player.d.b();
                Bundle bundle2 = new Bundle();
                if (z5) {
                    i = 1;
                }
                bundle2.putInt("mExtraOrientation", i);
                bundle2.putString("mViewType", this.R);
                this.mnU.setArguments(bundle2);
            }
            beginTransaction2.add(a.f.fl_fragment, this.mnU);
            beginTransaction2.commitAllowingStateLoss();
            this.H = true;
        }
        tv.chushou.zues.utils.e.d(this.v, "screenChange()----->");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean dwV() {
        return this.R != null && this.R.equals("3");
    }

    private void R() {
        if (this.mnU != null) {
            this.mnU.msU = null;
        }
        if (this.mnQ != null) {
            this.mnQ.release();
            this.mnQ = null;
            this.K = false;
        }
        if (this.mnR != null) {
            this.mnR.release();
            this.mnR = null;
        }
        if (this.mnS != null) {
            this.mnS.release();
            this.mnS = null;
        }
        if (this.mnT != null) {
            this.mnT.c();
        }
        this.d = false;
        this.e = false;
        this.M = false;
        this.mnT = new c();
        this.mnR = this.mnT.dxz();
        this.mnR.setOnActivityCallBack(this.moD);
        this.mnS = this.mnT.dxA();
        this.mnS.setOnActivityCallBack(this.moE);
        if (!this.d) {
            this.mnQ = this.mnR;
        } else {
            this.mnQ = this.mnS;
        }
        if (this.mnU != null) {
            this.mnU.msU = this.mnQ;
        }
    }

    public void j() {
        if (this.mnQ != null) {
            this.mnQ.pause();
            this.mnQ.stop();
            this.mnQ.release();
            this.mnQ = null;
        }
        if (this.mnR != null) {
            this.mnR.stop();
            this.mnR.release();
            this.mnR = null;
        }
        if (this.mnS != null) {
            this.mnS.stop();
            this.mnS.release();
            this.mnS = null;
        }
        if (this.mnT != null) {
            this.mnT.c();
        }
    }

    public void k() {
        tv.chushou.common.player.a aVar = this.mnQ;
        if (aVar != null) {
            aVar.pause();
            aVar.stop();
        }
        tv.chushou.common.player.a aVar2 = this.mnR;
        if (aVar2 != null) {
            aVar2.stop();
        }
        tv.chushou.common.player.a aVar3 = this.mnS;
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
    public void dla() {
        if (this.av) {
            if (this.mnU != null) {
                this.mnU.s();
            }
        } else if (this.moA != null) {
            this.moA.a(this.moA.JH(3), 20L);
        }
    }

    private void b(final String str, String str2) {
        com.kascend.chushou.c.c.dwE().a(new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.VideoPlayer.8
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
                    VideoPlayer.this.dxd().a(fullRoomInfo.mBangMap);
                    if (h.isEmpty(fullRoomInfo.mRoominfo.mRoomID)) {
                        fullRoomInfo.mRoominfo.mRoomID = VideoPlayer.this.P;
                    }
                    if (!h.isEmpty(fullRoomInfo.mGeneralTabGifts)) {
                        com.kascend.chushou.d.e.a(VideoPlayer.this.mox, new ArrayList(fullRoomInfo.mGeneralTabGifts));
                    }
                    if (VideoPlayer.this.mnW != null) {
                        VideoPlayer.this.mnW.a(fullRoomInfo);
                    }
                    VideoPlayer.this.L = false;
                    if (VideoPlayer.this.B) {
                        if (VideoPlayer.this.C && !"3".equals(VideoPlayer.this.R) && fullRoomInfo != null && fullRoomInfo.mRoominfo != null && fullRoomInfo.mRoominfo.mStyle == 1 && !h.isEmpty(fullRoomInfo.mRoominfo.mGameId)) {
                            z = true;
                        }
                        if (!z) {
                            if (VideoPlayer.this.mnU != null) {
                                VideoPlayer.this.mnU.a(VideoPlayer.this.mnW);
                            }
                            if (!h.isEmpty(fullRoomInfo.mRoominfo.mGameId)) {
                                VideoPlayer.this.dla();
                            } else {
                                if (VideoPlayer.this.mnW != null) {
                                    VideoPlayer.this.mnW.f = null;
                                }
                                VideoPlayer.this.dla();
                            }
                        } else {
                            VideoPlayer.this.a(1, "1", true);
                            if (VideoPlayer.this.mnU != null) {
                                VideoPlayer.this.mnU.a(VideoPlayer.this.mnW);
                            }
                        }
                    } else {
                        if (h.isEmpty(fullRoomInfo.mRoominfo.mGameId)) {
                            if (VideoPlayer.this.mnW != null) {
                                VideoPlayer.this.mnW.f = null;
                            }
                            VideoPlayer.this.a(1, "1");
                        } else {
                            VideoPlayer.this.a(1, "1", true);
                        }
                        if (VideoPlayer.this.mnU != null) {
                            VideoPlayer.this.mnU.a(VideoPlayer.this.mnW);
                        }
                    }
                    if (VideoPlayer.this.mnW != null && !VideoPlayer.this.mnW.m()) {
                        if (VideoPlayer.this.moh != null) {
                            VideoPlayer.this.moh.d();
                            VideoPlayer.this.moh = null;
                        }
                        VideoPlayer.this.moh = new com.kascend.chushou.toolkit.d(900000L, VideoPlayer.this.moj, VideoPlayer.this.moA);
                        VideoPlayer.this.moh.a();
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
        if (this.mnW != null) {
            this.mnW.a((FullRoomInfo) null);
        }
        this.L = false;
        c(str, i);
        if (this.mnQ != null) {
            this.mnQ.stop();
        }
        if (this.mnR != null) {
            this.mnR.stop();
        }
        if (this.mnS != null) {
            this.mnS.stop();
        }
    }

    public void l() {
        tv.chushou.zues.utils.e.d(this.v, "retryGetPlayList");
        c();
        if (dwV()) {
            aL(this.P, false);
        } else {
            a(this.P, dxf(), false);
        }
    }

    public void m() {
        a(this.mol, false);
    }

    private void a(final String str, String str2, boolean z) {
        this.J = true;
        VideoPlayInfo M = j.dwN().M(str + str2, 600000L);
        if (M != null) {
            a((ArrayList) M.mPlayUrls);
            this.J = false;
        } else if (z) {
            ParserRet fj = com.kascend.chushou.player.c.a.dxB().fj(str, str2);
            if (fj.mRc != 0) {
                tv.chushou.zues.utils.e.e(this.v, "getPlayUrlSync fail, try to getPlaylist");
                a(str, str2, false);
                return;
            }
            a(fj, str);
        } else {
            com.kascend.chushou.player.c.a.dxB().a(str, str2, new a.InterfaceC0741a() { // from class: com.kascend.chushou.player.VideoPlayer.9
                @Override // com.kascend.chushou.player.c.a.InterfaceC0741a
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
        VideoPlayInfo N = j.dwN().N(str, 600000L);
        if (N != null) {
            a((ArrayList) N.mPlayUrls);
            this.J = false;
            return;
        }
        if (!h.isEmpty(this.mol)) {
            try {
                equals = "1".equals(new JSONObject(this.mol).optString("auto"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (!z) {
                ParserRet aM = com.kascend.chushou.player.c.a.dxB().aM(str, equals);
                if (aM.mRc != 0) {
                    tv.chushou.zues.utils.e.e(this.v, "getVideoPlayUrlSync fail, try to getVideoPlaylist");
                    aL(str, false);
                    return;
                }
                a(aM, str);
                return;
            }
            com.kascend.chushou.player.c.a.dxB().a(str, new a.InterfaceC0741a() { // from class: com.kascend.chushou.player.VideoPlayer.10
                @Override // com.kascend.chushou.player.c.a.InterfaceC0741a
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
                if (this.mnW.f == null) {
                    this.mnW.f = new ArrayList<>();
                }
                this.mnW.f.clear();
                this.mnW.f.addAll(arrayList);
                if ("1".equals(this.R)) {
                    j.dwN().a(str + dxf(), arrayList);
                } else {
                    j.dwN().t(str, arrayList);
                }
                a(arrayList);
                return;
            }
            if (this.mnW != null) {
                this.mnW.f = null;
            }
            if (this.moA != null) {
                Message JH = this.moA.JH(5);
                JH.arg1 = 2;
                JH.arg2 = parserRet.mRc;
                this.moA.N(JH);
            }
        }
    }

    private void c(String str, int i) {
        s();
        if (this.moc != null) {
            this.moc.a();
        }
        if (h.isEmpty(str)) {
            str = getString(a.i.str_load_data_failed);
        }
        a(str, i);
    }

    public void n() {
        if (this.mof != null && this.bqS != null && this.mog != null) {
            this.mof.setVisibility(0);
            this.bqS.setVisibility(8);
            this.mog.setVisibility(8);
        }
    }

    public void o() {
        if (this.mom != null && this.mom.getVisibility() == 0) {
            this.mom.xW(0);
            this.mom.setVisibility(8);
        }
    }

    public void p() {
        if (this.moo != null && this.moo.getVisibility() == 0) {
            this.moo.setVisibility(8);
        }
    }

    public void q() {
        this.av = true;
    }

    protected void r() {
        this.mof.setVisibility(8);
        this.mog.setVisibility(0);
        this.bqS.setVisibility(0);
        if (this.mob != null) {
            this.mnZ.setVisibility(8);
            this.mob.setVisibility(0);
            this.moa.setText(getString(a.i.str_dialog_loading_content));
            this.moa.setVisibility(8);
        }
    }

    protected void a(String str, int i) {
        this.mof.setVisibility(8);
        this.mog.setVisibility(0);
        this.bqS.setVisibility(0);
        if (this.mob != null) {
            if (str == null) {
                str = getString(a.i.str_nodata);
            }
            if (str != null) {
                this.moa.setText(str);
                if (str.equals(getString(a.i.s_no_available_network))) {
                    this.mnZ.setImageResource(a.e.commonres_pagestatus_net_error);
                } else if (str.equals(getString(a.i.str_nodata)) || str.equals(getString(a.i.str_nohistory)) || str.equals(getString(a.i.str_nolive)) || str.equals(getString(a.i.str_nosubscribe))) {
                    this.mnZ.setClickable(true);
                    this.mnZ.setImageResource(a.e.commonres_pagestatus_empty);
                } else if (str.equals(getString(a.i.str_inbox_login_notify)) || str.equals(getString(a.i.push_login)) || str.equals(getString(a.i.str_login_timeout))) {
                    this.mnZ.setImageResource(a.e.commonres_pagestatus_need_login);
                    this.mnZ.setClickable(true);
                } else {
                    this.mnZ.setImageResource(a.e.commonres_pagestatus_unknown_error);
                    this.mnZ.setClickable(true);
                }
            }
            if (i == 4001) {
                this.mnZ.setImageResource(a.e.commonres_pagestatus_net_error);
                this.mnZ.setClickable(false);
                this.moa.setVisibility(0);
                this.moa.setText(getString(a.i.str_dissubscribe_btn));
                this.moa.setOnClickListener(new View.OnClickListener() { // from class: com.kascend.chushou.player.VideoPlayer.11
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (!VideoPlayer.this.j) {
                            com.kascend.chushou.c.c.dwE().b(new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.VideoPlayer.11.1
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
                            }, VideoPlayer.this.P, (String) null, VideoPlayer.this.mnW.h);
                        }
                    }
                });
            } else if (i == 404) {
                this.moa.setText(str);
                this.moa.setVisibility(0);
                this.mnZ.setClickable(false);
                this.mnZ.setImageResource(a.e.commonres_pagestatus_empty);
            } else if (i == 4002) {
                if (h.isEmpty(str)) {
                    this.moa.setVisibility(8);
                } else {
                    this.moa.setVisibility(0);
                    this.moa.setText(str);
                }
            } else {
                this.moa.setVisibility(8);
            }
            this.mnZ.setVisibility(0);
            this.mob.setVisibility(8);
            this.moo.setVisibility(8);
        }
    }

    public void s() {
        if (this.moA != null) {
            this.moA.removeMessages(1);
        }
    }

    private void a(ArrayList<PlayUrl> arrayList) {
        boolean z;
        if (this.mnW.f == null) {
            this.mnW.f = new ArrayList<>();
        }
        this.mnW.f.clear();
        this.mnW.f.addAll(arrayList);
        if (com.kascend.chushou.d.e.b() && !"4".equals(this.aq)) {
            int c = com.kascend.chushou.d.e.c();
            if (c == -1) {
                b(arrayList);
                return;
            } else if (this.moB) {
                this.moB = false;
                if (c == 0) {
                    this.mnW.d = false;
                    f(arrayList, true);
                    return;
                }
                if (this.mnW != null && this.mnW.f != null) {
                    Iterator<PlayUrl> it = this.mnW.f.iterator();
                    while (it.hasNext()) {
                        if ("2".equals(it.next().mType)) {
                            z = true;
                            break;
                        }
                    }
                }
                z = false;
                this.mnW.d = z;
                f(arrayList, true);
                return;
            } else {
                if (this.mnW.e) {
                    this.mnW.d = !this.mnW.d;
                    this.mnW.e = false;
                    this.moC = true;
                } else if ("4".equals(this.aq)) {
                    this.mnW.d = true;
                }
                f(arrayList, true);
                return;
            }
        }
        if (this.mnW.e) {
            this.mnW.d = !this.mnW.d;
            this.mnW.e = false;
            this.moC = true;
        } else if ("4".equals(this.aq)) {
            this.mnW.d = true;
        }
        f(arrayList, true);
    }

    private void b(ArrayList<PlayUrl> arrayList) {
        if ("1".equals(this.R)) {
            if ("2".equals(this.mov)) {
                d(false, arrayList);
            } else if (this.mnU != null) {
                this.mnU.f(arrayList, false);
            }
        } else if (this.mnU != null) {
            this.mnU.f(arrayList, false);
        }
    }

    public void c(boolean z) {
        this.mnW.d = false;
        com.kascend.chushou.d.e.a(0);
        ArrayList<PlayUrl> arrayList = this.mnW.f;
        if (!h.isEmpty(arrayList)) {
            if (z) {
                f(arrayList, false);
                if (this.moA != null) {
                    this.moA.JF(2);
                    return;
                }
                return;
            }
            f(arrayList, true);
        }
    }

    public void d(boolean z) {
        this.mnW.d = true;
        com.kascend.chushou.d.e.a(1);
        ArrayList<PlayUrl> arrayList = this.mnW.f;
        if (!h.isEmpty(arrayList)) {
            if (z) {
                f(arrayList, false);
                if (this.moA != null) {
                    this.moA.JF(2);
                    return;
                }
                return;
            }
            f(arrayList, true);
        }
    }

    @Subscribe
    public void onNotifyEvent(com.kascend.chushou.b.a.a.j jVar) {
        if (!isFinishing() && jVar.a == 1 && !"5".equals(this.R) && !dwP()) {
            tv.chushou.zues.utils.e.d(this.v, "onNetworkChangeEvent 3G=" + com.kascend.chushou.b.dwB().b + "  wifi=" + com.kascend.chushou.b.dwB().a);
            if (com.kascend.chushou.d.e.b() && !"4".equals(this.aq)) {
                if (com.kascend.chushou.d.e.c() == -1) {
                    if (this.mnU != null) {
                        this.mnU.e(false);
                    }
                    if ("1".equals(this.R)) {
                        if ("2".equals(this.mov)) {
                            d(true, null);
                            return;
                        } else if (this.mnU != null) {
                            this.mnU.f(this.mnW.f, true);
                            return;
                        } else {
                            return;
                        }
                    } else if (this.mnU != null) {
                        this.mnU.f(this.mnW.f, true);
                        return;
                    } else {
                        return;
                    }
                }
                RxExecutor.postDelayed(this.mox, EventThread.MAIN_THREAD, 10L, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.VideoPlayer.12
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!VideoPlayer.this.isFinishing() && com.kascend.chushou.b.dwB().b && !com.kascend.chushou.b.dwB().a) {
                            tv.chushou.zues.utils.g.c(VideoPlayer.this.w, VideoPlayer.this.getString(a.i.str_monet_notify));
                        }
                    }
                });
            } else if (com.kascend.chushou.b.dwB().a || com.kascend.chushou.b.dwB().b) {
                t();
                if (this.moA != null) {
                    this.moA.JF(2);
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
            if (this.mnW.d) {
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
            String d = com.kascend.chushou.d.h.dwI().d();
            String str3 = h.isEmpty(d) ? "2" : d;
            if (this.mnW.d) {
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
                if (this.mnW != null) {
                    this.mnW.a(playUrl2);
                    if (this.moA != null) {
                        Message JH = this.moA.JH(5);
                        JH.arg1 = 1;
                        this.moA.N(JH);
                    }
                }
                String b = com.kascend.chushou.player.c.a.b(playUrl2);
                if (!h.isEmpty(b)) {
                    this.mnP = Uri.parse(b);
                    if (this.moC) {
                        this.moC = false;
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (z && this.mnQ != null) {
                        a(false, z2);
                    }
                }
            }
        }
    }

    public void d(final boolean z, ArrayList<PlayUrl> arrayList) {
        if (this.moi == null || this.moi.a <= 0) {
            this.moi = com.kascend.chushou.view.b.a.a.dyM();
            this.moi.a(new a.InterfaceC0760a() { // from class: com.kascend.chushou.player.VideoPlayer.13
                @Override // com.kascend.chushou.view.b.a.a.InterfaceC0760a
                public void a(int i) {
                    if (i == a.f.tv_play_video) {
                        VideoPlayer.this.moi.dismissAllowingStateLoss();
                        VideoPlayer.this.c(z);
                    } else if (i == a.f.tv_play_audio) {
                        VideoPlayer.this.moi.dismissAllowingStateLoss();
                        VideoPlayer.this.d(z);
                    } else if (i == a.f.iv_close) {
                        VideoPlayer.this.finish();
                    } else {
                        if (i == a.f.tv_union_proxy) {
                        }
                    }
                }
            });
            this.moi.show(getSupportFragmentManager(), "showRoom");
        }
    }

    public void t() {
        if (this.moi != null) {
            this.moi.dismissAllowingStateLoss();
        }
        if (this.mnU != null) {
            this.mnU.v();
        }
    }

    public void u() {
        com.kascend.chushou.c.c.dwE().c(this.P, new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.VideoPlayer.16
            @Override // com.kascend.chushou.c.b
            public void a() {
            }

            @Override // com.kascend.chushou.c.b
            public void a(String str, JSONObject jSONObject) {
                if (!VideoPlayer.this.isFinishing()) {
                    ParserRet dD = com.kascend.chushou.c.e.dD(jSONObject);
                    if (dD.mRc == 0 && dD.mData != null) {
                        CycleLiveRoomInfo cycleLiveRoomInfo = (CycleLiveRoomInfo) dD.mData;
                        if (VideoPlayer.this.mnW != null && cycleLiveRoomInfo != null && !h.isEmpty(cycleLiveRoomInfo.roomId)) {
                            FullRoomInfo dxt = VideoPlayer.this.mnW.dxt();
                            if (dxt.cycleLiveRoomInfo == null) {
                                dxt.cycleLiveRoomInfo = cycleLiveRoomInfo;
                                VideoPlayer.this.d();
                            } else if (dxt.cycleLiveRoomInfo != null && !cycleLiveRoomInfo.roomId.equals(dxt.cycleLiveRoomInfo.roomId)) {
                                dxt.cycleLiveRoomInfo.copyCycleLiveRoomInfo(cycleLiveRoomInfo);
                                VideoPlayer.this.d();
                            } else {
                                dxt.cycleLiveRoomInfo.copyCycleLiveRoomInfo(cycleLiveRoomInfo);
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
        if (this.mnU != null) {
            this.mnU.N();
        }
    }

    public void v() {
        com.kascend.chushou.c.c.dwE().a(this.P, new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.VideoPlayer.17
            @Override // com.kascend.chushou.c.b
            public void a() {
            }

            @Override // com.kascend.chushou.c.b
            public void a(String str, JSONObject jSONObject) {
                if (!VideoPlayer.this.isFinishing()) {
                    ParserRet dE = com.kascend.chushou.c.e.dE(jSONObject);
                    if (dE.mRc == 0 && dE.mData != null) {
                        PkNotifyInfo pkNotifyInfo = (PkNotifyInfo) dE.mData;
                        VideoPlayer.this.mot.b = VideoPlayer.this.P;
                        if (pkNotifyInfo != null) {
                            VideoPlayer.this.mot.msV = pkNotifyInfo;
                            if (VideoPlayer.this.mnU != null) {
                                VideoPlayer.this.mnU.a(pkNotifyInfo, VideoPlayer.this.P);
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
        if (this.mnY != null) {
            this.mnY.release();
            this.mnY = null;
        }
        com.kascend.chushou.c.c.dwE().a(this.P, new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.VideoPlayer.18
            @Override // com.kascend.chushou.c.b
            public void a() {
            }

            @Override // com.kascend.chushou.c.b
            public void a(String str, JSONObject jSONObject) {
                if (!VideoPlayer.this.isFinishing()) {
                    ParserRet dF = com.kascend.chushou.c.e.dF(jSONObject);
                    if (dF.mRc == 0 && dF.mData != null) {
                        RoomExpandInfo roomExpandInfo = (RoomExpandInfo) dF.mData;
                        if (VideoPlayer.this.mnW != null) {
                            VideoPlayer.this.mnW.mpC = roomExpandInfo.mTopWebAdItem;
                            if (VideoPlayer.this.mnW.s == null) {
                                VideoPlayer.this.mnW.s = new ArrayList();
                            }
                            VideoPlayer.this.mnW.s.clear();
                            VideoPlayer.this.mnW.s.addAll(roomExpandInfo.mGiftTopRightIcons);
                            tv.chushou.zues.a.a.post(new i(50, VideoPlayer.this.mnW.mpC));
                        }
                        if (VideoPlayer.this.mnW != null) {
                            VideoPlayer.this.mnW.fa(roomExpandInfo.mExpandNavList);
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
                            VideoPlayer.this.mop.a(list);
                        }
                        List<com.kascend.chushou.player.ui.h5.c.c> list2 = roomExpandInfo.mLuckList;
                        if (!h.isEmpty(list2)) {
                            VideoPlayer.this.moq.a(list2);
                        }
                        com.kascend.chushou.player.ui.h5.c.c cVar = roomExpandInfo.mVoteItem;
                        if (cVar != null) {
                            VideoPlayer.this.mor.a(cVar);
                        }
                        List<com.kascend.chushou.player.ui.h5.c.b> list3 = roomExpandInfo.mInteractH5Item;
                        if (!h.isEmpty(list3)) {
                            VideoPlayer.this.mou.a(list3);
                        }
                        List<com.kascend.chushou.player.ui.h5.c.b> list4 = roomExpandInfo.mInteractNavItem;
                        if (!h.isEmpty(list4)) {
                            VideoPlayer.this.mou.a(list4);
                        }
                        VideoPlayer.this.mnY = (PrivilegeInfo) dF.mData1;
                        if (VideoPlayer.this.mnY != null) {
                            tv.chushou.zues.a.a.post(new l());
                        }
                        if (VideoPlayer.this.mnW != null) {
                            VideoPlayer.this.mnW.mpI = roomExpandInfo.mIconConfig;
                            VideoPlayer.this.dxd().a(roomExpandInfo.mIconConfig.bangConfig);
                        }
                        List<SkinConfig> list5 = roomExpandInfo.skinConfig;
                        if (list5 != null && VideoPlayer.this.mnW != null) {
                            VideoPlayer.this.mnW.mpM.clear();
                            int i = 0;
                            while (true) {
                                int i2 = i;
                                if (i2 >= list5.size()) {
                                    break;
                                }
                                SkinConfig skinConfig = list5.get(i2);
                                VideoPlayer.this.mnW.mpM.put(skinConfig.position, skinConfig.resource);
                                i = i2 + 1;
                            }
                            VideoPlayer.this.C();
                        }
                        VideoPlayer.this.a(roomExpandInfo.mIconConfig, VideoPlayer.this.mnW != null ? VideoPlayer.this.mnW.mpM : null);
                        if (roomExpandInfo.mColorMap != null && roomExpandInfo.mColorMap.size() > 0 && com.kascend.chushou.b.dwB().c != null && com.kascend.chushou.b.dwB().c.size() <= 0) {
                            com.kascend.chushou.b.dwB().c.putAll(roomExpandInfo.mColorMap);
                            tv.chushou.zues.a.a.post(new i(52, null));
                        }
                        AutoBang autoBang = roomExpandInfo.mAutoBang;
                        if (autoBang != null && autoBang.currentTime != 0 && autoBang.bangTime != 0) {
                            VideoPlayer.this.dxd().a(autoBang);
                        }
                        if (!h.isEmpty(roomExpandInfo.mRelatedRoomList) && VideoPlayer.this.mnW != null) {
                            VideoPlayer.this.mnW.t = roomExpandInfo.mRelatedRoomList;
                            if (VideoPlayer.this.mnU != null && VideoPlayer.this.H) {
                                VideoPlayer.this.mnU.w();
                            }
                        }
                        if (roomExpandInfo.mRoomNewUserInfo != null && roomExpandInfo.mRoomNewUserInfo.mBarrierNoviceGuide && !com.kascend.chushou.d.h.dwI().k() && VideoPlayer.this.mnU != null) {
                            VideoPlayer.this.mnU.J();
                        }
                        if (roomExpandInfo.mRoomNewUserInfo != null && roomExpandInfo.mRoomNewUserInfo.mRewardNoviceGuide && !com.kascend.chushou.d.h.dwI().l() && VideoPlayer.this.mnU != null) {
                            VideoPlayer.this.mnU.K();
                        }
                        if (!h.isEmpty(roomExpandInfo.mShopWindowInfos)) {
                            if (VideoPlayer.this.mnW != null) {
                                if (VideoPlayer.this.mnW.mpJ == null) {
                                    VideoPlayer.this.mnW.mpJ = new ArrayList();
                                }
                                VideoPlayer.this.mnW.mpJ.addAll(roomExpandInfo.mShopWindowInfos);
                            }
                            if (VideoPlayer.this.mnU != null) {
                                VideoPlayer.this.mnU.L();
                            }
                        }
                        VideoPlayer.this.mot.b = VideoPlayer.this.P;
                        if (roomExpandInfo.mPkNotifyInfo != null) {
                            VideoPlayer.this.mot.msV = roomExpandInfo.mPkNotifyInfo;
                            if (VideoPlayer.this.mnU != null) {
                                VideoPlayer.this.mnU.a(roomExpandInfo.mPkNotifyInfo, VideoPlayer.this.P);
                            }
                        } else {
                            VideoPlayer.this.mot.msV = null;
                        }
                        if (roomExpandInfo.mTrumpetPocket != null && VideoPlayer.this.mnW != null) {
                            VideoPlayer.this.mnW.mpL = roomExpandInfo.mTrumpetPocket;
                            if (VideoPlayer.this.mnU != null) {
                                VideoPlayer.this.mnU.M();
                            }
                        }
                        if (!h.isEmpty(roomExpandInfo.hotwordContentList)) {
                            if (VideoPlayer.this.mnW != null) {
                                if (VideoPlayer.this.mnW.mpK == null) {
                                    VideoPlayer.this.mnW.mpK = new ArrayList();
                                }
                                VideoPlayer.this.mnW.mpK.clear();
                                VideoPlayer.this.mnW.mpK.addAll(roomExpandInfo.hotwordContentList);
                            }
                            if (VideoPlayer.this.mnU != null) {
                                VideoPlayer.this.mnU.b(roomExpandInfo.hotwordContentList);
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
        }, this.mol, this.mov);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U() {
        if (!h.isEmpty(com.kascend.chushou.a.a.dwC().mnn)) {
            StringBuilder sb = new StringBuilder();
            if (com.kascend.chushou.a.a.dwC().mnn.contains(com.kascend.chushou.a.a.f)) {
                if (sb.length() > 0) {
                    sb.append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                sb.append(com.kascend.chushou.a.a.f);
            }
            if (com.kascend.chushou.a.a.dwC().mnn.contains(com.kascend.chushou.a.a.g)) {
                if (sb.length() > 0) {
                    sb.append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                sb.append(com.kascend.chushou.a.a.g);
            }
            if (com.kascend.chushou.a.a.dwC().mnn.contains(com.kascend.chushou.a.a.i)) {
                if (sb.length() > 0) {
                    sb.append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                sb.append(com.kascend.chushou.a.a.i);
            }
            if (com.kascend.chushou.a.a.dwC().mnn.contains(com.kascend.chushou.a.a.h)) {
                if (sb.length() > 0) {
                    sb.append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                sb.append(com.kascend.chushou.a.a.h);
            }
            if (com.kascend.chushou.a.a.dwC().mnn.contains(com.kascend.chushou.a.a.j)) {
                if (sb.length() > 0) {
                    sb.append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                sb.append(com.kascend.chushou.a.a.j);
            }
            if (com.kascend.chushou.a.a.dwC().mnn.contains(com.kascend.chushou.a.a.l)) {
                if (sb.length() > 0) {
                    sb.append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                sb.append(com.kascend.chushou.a.a.l);
            }
            if (com.kascend.chushou.a.a.dwC().mnn.contains(com.kascend.chushou.a.a.m)) {
                if (sb.length() > 0) {
                    sb.append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
                sb.append(com.kascend.chushou.a.a.m);
            }
            if (sb.length() != 0) {
                com.kascend.chushou.a.a.dwC().a(sb.toString(), this.P, new a.c() { // from class: com.kascend.chushou.player.VideoPlayer.19
                    @Override // com.kascend.chushou.a.a.c
                    public void a(List<ListItem> list) {
                        if (VideoPlayer.this.mnW != null && list != null) {
                            int i = 0;
                            while (true) {
                                int i2 = i;
                                if (i2 >= list.size()) {
                                    break;
                                }
                                if (list.get(i2).mAdExtraInfo != null) {
                                    if (com.kascend.chushou.a.a.f.equals(list.get(i2).mAdExtraInfo.mCode)) {
                                        VideoPlayer.this.mnW.mpB = list.get(i2);
                                    } else if (com.kascend.chushou.a.a.g.equals(list.get(i2).mAdExtraInfo.mCode)) {
                                        VideoPlayer.this.mnW.mpA = list.get(i2);
                                    } else if (com.kascend.chushou.a.a.i.equals(list.get(i2).mAdExtraInfo.mCode)) {
                                        VideoPlayer.this.mnW.mpD = list.get(i2);
                                    } else if (com.kascend.chushou.a.a.h.equals(list.get(i2).mAdExtraInfo.mCode)) {
                                        VideoPlayer.this.mnW.mpE = list.get(i2);
                                    } else if (com.kascend.chushou.a.a.j.equals(list.get(i2).mAdExtraInfo.mCode)) {
                                        VideoPlayer.this.mnW.mpH = list.get(i2);
                                    } else if (com.kascend.chushou.a.a.l.equals(list.get(i2).mAdExtraInfo.mCode)) {
                                        VideoPlayer.this.mnW.mpF = list.get(i2);
                                    } else if (com.kascend.chushou.a.a.m.equals(list.get(i2).mAdExtraInfo.mCode)) {
                                        VideoPlayer.this.mnW.mpG = list.get(i2);
                                    }
                                }
                                i = i2 + 1;
                            }
                            if (VideoPlayer.this.mnU != null) {
                                VideoPlayer.this.mnU.H();
                            }
                        }
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str, String str2) {
        if (dwV()) {
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
                this.moe.setSystemUiVisibility(i);
                return;
            }
            this.moe.setSystemUiVisibility(1792);
        }
    }

    public void f(boolean z) {
        Window window;
        View decorView;
        if (com.kascend.chushou.b.dwB().d != 1 && (window = getWindow()) != null && (decorView = window.getDecorView()) != null) {
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
        if (this.mnU != null) {
            this.mnU.a(i, i2, intent);
        }
    }

    public Uri dwW() {
        return this.mnP;
    }

    @Override // com.kascend.chushou.view.base.BaseActivity
    protected int y() {
        return 0;
    }

    public void wa(boolean z) {
        if (this.moe != null) {
            this.moe.nvI = z;
        }
    }

    public void dwX() {
        if (this.moe != null) {
            this.moe.dwX();
        }
    }

    public boolean dwY() {
        return this.ae;
    }

    public void g(boolean z) {
        this.ae = z;
    }

    public void h(boolean z) {
        if (this.moe != null) {
            this.moe.setIsTranslucentStatus(z);
        }
    }

    public void z() {
        if (this.moe != null) {
            this.moe.dKq();
        }
    }

    @Override // com.kascend.chushou.widget.gifts.RoomSendGiftView.a
    public void A() {
        if (this.moc != null) {
            this.moc.b();
        }
    }

    @Override // com.kascend.chushou.widget.gifts.RoomSendGiftView.a
    public void B() {
        if (this.moc != null) {
            this.moc.b();
        }
    }

    public void a(List<ListItem> list) {
        if (this.mnU != null) {
            this.mnU.a(list);
        }
    }

    public void a(IconConfig iconConfig, Map<String, SkinConfig.SkinRes> map) {
        if (this.mnU != null) {
            this.mnU.a(iconConfig, map);
        }
    }

    public void C() {
        if (this.mnU != null) {
            this.mnU.I();
        }
    }

    @Override // com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC0752a
    public void a(int i) {
        if (this.mnU != null) {
            this.mnU.a(i);
        }
    }

    @Override // com.kascend.chushou.player.ui.h5.redpacket.a.InterfaceC0752a
    public void D() {
        if (!isFinishing() && this.mnU != null) {
            this.mnU.D();
        }
    }

    @Override // com.kascend.chushou.player.ui.h5.b.b.a
    public void a(long j) {
        if (!isFinishing() && this.mnU != null) {
            this.mnU.a(j);
        }
    }

    @Override // com.kascend.chushou.player.ui.h5.b.b.a
    public void a(com.kascend.chushou.player.ui.h5.c.a aVar) {
        if (aVar != null && this.mnU != null) {
            this.mnU.a(aVar);
        }
    }

    @Override // com.kascend.chushou.player.ui.h5.b.b.a
    public void b(int i) {
        if (this.mnU != null) {
            this.mnU.b(i);
        }
    }

    @Override // com.kascend.chushou.player.ui.h5.d.a.InterfaceC0751a
    public void b(long j) {
        if (!isFinishing() && this.mnU != null) {
            this.mnU.b(j);
        }
    }

    @Override // com.kascend.chushou.player.ui.h5.a.a.InterfaceC0749a
    public void c(int i) {
        if (!isFinishing() && this.mnU != null) {
            this.mnU.c(i);
        }
    }

    @Override // com.kascend.chushou.player.ui.h5.d.a.InterfaceC0751a
    public void b(com.kascend.chushou.player.ui.h5.c.a aVar) {
        if (aVar != null && this.mnU != null) {
            this.mnU.b(aVar);
        }
    }

    @Override // com.kascend.chushou.player.ui.a.a.InterfaceC0746a
    public void a(IconConfig.Config config) {
        if (this.mnU != null) {
            this.mnU.a(config);
        }
    }

    @Override // com.kascend.chushou.player.ui.a.a.InterfaceC0746a
    public void a(BangInfo bangInfo, String str) {
        if (this.mnU != null) {
            this.mnU.a(bangInfo, str);
        }
    }

    @Override // com.kascend.chushou.player.ui.a.a.InterfaceC0746a
    public void a(long j, BangInfo bangInfo, String str) {
        if (this.mnU != null) {
            this.mnU.a(j, bangInfo, str);
        }
    }

    public com.kascend.chushou.player.ui.h5.redpacket.a dwZ() {
        return this.mop;
    }

    public com.kascend.chushou.player.ui.h5.b.b dxa() {
        return this.moq;
    }

    public com.kascend.chushou.player.ui.h5.d.a dxb() {
        return this.mor;
    }

    public com.kascend.chushou.player.ui.h5.a.a dxc() {
        return this.mou;
    }

    public com.kascend.chushou.player.ui.a.a dxd() {
        return this.mos;
    }

    public com.kascend.chushou.player.e.a dxe() {
        return this.mot;
    }

    @Override // com.kascend.chushou.view.base.BaseActivity, android.app.Activity
    public void finish() {
        super.finish();
        if ("3".equals(this.R)) {
            overridePendingTransition(17432576, a.C0736a.commonres_activity_exit_bottom);
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
        RxExecutor.postDelayed(this.mox, EventThread.MAIN_THREAD, aVar.d, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.VideoPlayer.2
            @Override // java.lang.Runnable
            public void run() {
                if (VideoPlayer.this.mnU != null) {
                    VideoPlayer.this.mnU.c(aVar);
                }
            }
        });
    }

    private void e(final com.kascend.chushou.player.ui.h5.c.a aVar) {
        if (!com.kascend.chushou.d.h.dwI().dwL().contains(aVar.b)) {
            if (aVar.d < 0) {
                aVar.d = 0;
            }
            RxExecutor.postDelayed(this.mox, EventThread.MAIN_THREAD, aVar.d, TimeUnit.SECONDS, new Runnable() { // from class: com.kascend.chushou.player.VideoPlayer.3
                @Override // java.lang.Runnable
                public void run() {
                    if (!VideoPlayer.this.isFinishing() && VideoPlayer.this.mnU != null) {
                        VideoPlayer.this.mnU.c(aVar);
                    }
                }
            });
        }
    }

    private String dxf() {
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
                if (VideoPlayer.this.mod != null && !VideoPlayer.this.isFinishing()) {
                    VideoPlayer.n = VideoPlayer.this.mod.getStreamVolume(3);
                }
                if (!VideoPlayer.this.isFinishing() && (VideoPlayer.this.mnU instanceof f)) {
                    ((f) VideoPlayer.this.mnU).ab();
                }
            }
        }
    }

    public String a(String str) {
        HashMap hashMap = new HashMap(tv.chushou.zues.utils.d.Qn(str));
        if ("1".equals(this.R)) {
            hashMap.put("roomId", this.P);
        } else if ("3".equals(this.R)) {
            hashMap.put("videoId", this.P);
        }
        return tv.chushou.zues.utils.d.toJson(hashMap);
    }

    public boolean dxg() {
        if (this.mnU instanceof com.kascend.chushou.player.d.a) {
            return ((com.kascend.chushou.player.d.a) this.mnU).dxY();
        }
        if (this.mnU instanceof com.kascend.chushou.player.e.e) {
            return true;
        }
        return false;
    }
}

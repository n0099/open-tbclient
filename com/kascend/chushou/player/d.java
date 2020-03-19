package com.kascend.chushou.player;

import android.animation.Animator;
import android.app.Activity;
import android.graphics.Point;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.android.imsdk.utils.HanziToPinyin;
import com.kascend.chushou.a;
import com.kascend.chushou.b.a.a.n;
import com.kascend.chushou.constants.AutoBang;
import com.kascend.chushou.constants.BangInfo;
import com.kascend.chushou.constants.ChatInfo;
import com.kascend.chushou.constants.ColorPrivileges;
import com.kascend.chushou.constants.CycleLiveRoomInfo;
import com.kascend.chushou.constants.FanItem;
import com.kascend.chushou.constants.FullRoomInfo;
import com.kascend.chushou.constants.GeneralTabGift;
import com.kascend.chushou.constants.ListItem;
import com.kascend.chushou.constants.MicMemberInfo;
import com.kascend.chushou.constants.MicStatus;
import com.kascend.chushou.constants.ParserRet;
import com.kascend.chushou.constants.PlayUrl;
import com.kascend.chushou.constants.PrivilegeInfo;
import com.kascend.chushou.constants.RoomInfo;
import com.kascend.chushou.d.h;
import com.kascend.chushou.player.adapter.DanmuAtSpan;
import com.kascend.chushou.toolkit.LoginManager;
import com.kascend.chushou.widget.VoiceInteractionView;
import com.kascend.chushou.widget.a.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;
import tv.chushou.basis.http.listener.JsonCallbackWrapper;
import tv.chushou.zues.toolkit.richtext.RichText;
import tv.chushou.zues.widget.fresco.FrescoThumbnailView;
/* loaded from: classes5.dex */
public abstract class d extends g implements View.OnClickListener, b.a {
    protected static int q;
    protected static int r;
    protected TextView B;
    protected String G;
    protected GestureDetector c;
    protected a mTk;
    protected com.kascend.chushou.widget.a.b mTm;
    protected tv.chushou.zues.utils.systemBar.a mTp;
    protected com.kascend.chushou.player.e.a mTr;
    protected com.kascend.chushou.player.e.b mTs;
    protected RelativeLayout mTt;
    protected VoiceInteractionView mTw;
    protected String u;
    protected TextView y;
    protected TextView z;
    protected ImageButton a = null;
    protected String b = null;
    private boolean mTl = false;
    protected boolean e = true;
    protected boolean f = false;
    protected TextView h = null;
    protected TextView i = null;
    protected int j = 0;
    protected boolean k = false;
    protected ProgressBar mTn = null;
    protected long m = 0;
    protected int n = 0;
    protected boolean p = false;
    private boolean mTq = false;
    protected boolean v = false;
    protected int w = -1;
    protected CycleLiveRoomInfo mTu = null;
    protected io.reactivex.disposables.b mTv = null;
    protected boolean E = false;
    protected boolean F = false;

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.nab = getActivity();
        if (dEp()) {
            tv.chushou.zues.utils.e.e("VideoPlayerBaseFragment", "killed in backgroud");
            return;
        }
        Point hc = tv.chushou.zues.utils.a.hc(this.nab);
        q = Math.min(hc.x, hc.y) / 5;
        r = 200;
        this.nad = (AudioManager) this.nab.getApplicationContext().getSystemService("audio");
    }

    @Override // android.support.v4.app.Fragment
    public void onViewCreated(View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
    }

    public void a() {
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
    }

    @Override // android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        tv.chushou.zues.utils.e.i("VideoPlayerBaseFragment", "lhh - onResume");
        this.ah = false;
        cXT();
        dDl();
        ((VideoPlayer) this.nab).m = false;
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.ah = true;
        R();
        if (this.N != null && this.mWp != null) {
            this.N.setVisibility(8);
        }
        if (this.nac != null) {
            this.nac.removeMessages(15);
        }
        a(false, false);
        if (this.nac != null) {
            this.nac.removeMessages(1);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // com.kascend.chushou.player.f, android.support.v4.app.Fragment
    public void onDestroy() {
        this.mZK.dispose();
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view) {
        this.mZM = (RelativeLayout) view.findViewById(a.f.rl_audio);
        this.mZN = (FrescoThumbnailView) view.findViewById(a.f.iv_audio_bg);
        this.mZO = (ImageView) view.findViewById(a.f.iv_audio_avator_bg);
        this.mZP = (FrescoThumbnailView) view.findViewById(a.f.iv_audio_avator);
        this.S = (TextView) view.findViewById(a.f.tv_audio_playing);
        this.mZQ = (TextView) view.findViewById(a.f.tv_open_video);
        this.mZQ.setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b() {
        this.mZW = (ProgressBar) this.mZL.findViewById(a.f.LoadingProgressBar);
        this.mZX = (TextView) this.mZL.findViewById(a.f.LoadingPercent);
        this.mZY = (TextView) this.mZL.findViewById(a.f.LoadingBuffer);
        this.mZZ = (TextView) this.mZL.findViewById(a.f.tv_change_lines);
        this.mZW.setVisibility(8);
        this.mZX.setVisibility(8);
        this.mZY.setVisibility(8);
        this.mZZ.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c() {
        this.mTt = (RelativeLayout) this.mZL.findViewById(a.f.rl_pk_name);
        this.y = (TextView) this.mZL.findViewById(a.f.tv_pk_name);
        this.z = (TextView) this.mZL.findViewById(a.f.tv_pk_subscribe);
        this.z.setOnClickListener(this);
        this.y.setOnClickListener(this);
        this.B = (TextView) this.mZL.findViewById(a.f.iv_cyclelive_countdown);
    }

    private void dDl() {
        if (i() || h()) {
            if (this.N != null) {
                this.N.setVisibility(0);
            }
            this.mWp = ((VideoPlayer) this.nab).dCA();
            if (this.mWp != null) {
                Uri uri = this.mWp.getUri();
                Uri dCG = ((VideoPlayer) this.nab).dCG();
                if (!this.nae) {
                    if (dCG != null && uri != null && !uri.equals(dCG)) {
                        ((VideoPlayer) this.nab).a(true, (Uri) null, false);
                    } else if (h.dCs().a) {
                        ((VideoPlayer) this.nab).a(true, (Uri) null, false);
                    } else if (((VideoPlayer) this.nab).m) {
                        if (h() && this.naa.d()) {
                            if (!this.ai) {
                                ((VideoPlayer) this.nab).a(true, (Uri) null, false);
                                return;
                            }
                            return;
                        }
                        ((VideoPlayer) this.nab).a(true, (Uri) null, false);
                    } else {
                        AudioManager audioManager = ((VideoPlayer) this.nab).mRm;
                        VideoPlayer videoPlayer = (VideoPlayer) this.nab;
                        audioManager.setStreamVolume(3, VideoPlayer.n, 0);
                        if (this.naa.d()) {
                            if (!this.ai) {
                                if (this.ap < 0) {
                                    if (this.naa.d) {
                                        T();
                                        if (this.mZT != null) {
                                            this.mZT.setImageResource(a.e.ic_btn_room_video_n);
                                        }
                                    } else {
                                        U();
                                        cXT();
                                        if (this.mZS != null) {
                                            this.mZS.setVisibility(0);
                                        }
                                        if (this.mZT != null) {
                                            this.mZT.setImageResource(a.e.ic_btn_room_audio_n);
                                        }
                                    }
                                }
                                n(true);
                            }
                        } else if (!this.H && !this.al) {
                            ((VideoPlayer) this.nab).a(true, (Uri) null, false);
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d() {
        FullRoomInfo dDd;
        tv.chushou.zues.utils.e.e("VideoPlayerBaseFragment", "release <----------");
        if (this.B != null) {
            this.B.setVisibility(8);
        }
        if (this.mTv != null) {
            this.mTv.dispose();
            this.mTv = null;
        }
        if (this.naa != null && (dDd = this.naa.dDd()) != null && !tv.chushou.zues.utils.h.isEmpty(dDd.mGeneralTabGifts)) {
            for (int i = 0; i < dDd.mGeneralTabGifts.size(); i++) {
                GeneralTabGift generalTabGift = dDd.mGeneralTabGifts.get(i);
                if (generalTabGift != null && !tv.chushou.zues.utils.h.isEmpty(generalTabGift.mGeneralGifts)) {
                    for (int i2 = 0; i2 < generalTabGift.mGeneralGifts.size(); i2++) {
                        if (generalTabGift.mGeneralGifts.get(i2) != null) {
                            generalTabGift.mGeneralGifts.get(i2).mSelectFlag = false;
                        }
                    }
                }
            }
        }
        if (this.naz != null) {
            this.naz.clear();
            this.naz = null;
        }
        if (this.mTp != null) {
            this.mTp.setStatusBarTintEnabled(false);
            this.mTp.setNavigationBarTintEnabled(false);
        }
        if (this.naP != null) {
            this.naP.unInit();
            this.naP = null;
            dEq().removeAllViews();
        }
        if (this.naD != null) {
            ((ViewGroup) this.mZL).removeView(this.naD);
            this.naD = null;
        }
        if (this.naQ != null) {
            this.naQ.cancel();
            ArrayList<Animator> childAnimations = this.naQ.getChildAnimations();
            if (!tv.chushou.zues.utils.h.isEmpty(childAnimations)) {
                Iterator<Animator> it = childAnimations.iterator();
                while (it.hasNext()) {
                    it.next().removeAllListeners();
                }
            }
            this.naQ.removeAllListeners();
            this.naQ = null;
        }
        this.naF = null;
        if (this.N != null) {
            ((ViewGroup) this.mZL).removeView(this.N);
            this.N = null;
        }
        if (this.naL != null) {
            this.naL.a();
            this.naL = null;
        }
        if (this.naV != null) {
            this.naV.dismiss();
        }
        if (this.naU != null) {
            this.naU.dismiss();
        }
        this.a = null;
        this.mZL = null;
        this.nad = null;
        tv.chushou.zues.utils.e.i("VideoPlayerBaseFragment", "release ---------->");
    }

    @Override // com.kascend.chushou.player.e
    public void e() {
        this.H = false;
        this.nae = false;
        ww(true);
        x();
    }

    public void a(PrivilegeInfo privilegeInfo) {
        ((VideoPlayer) this.nab).mRh = privilegeInfo;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(String str) {
        ColorPrivileges colorPrivileges;
        ArrayList<RichText> arrayList = null;
        if (this.naa != null && !tv.chushou.zues.utils.h.isEmpty(this.naa.a) && this.mWp != null) {
            com.kascend.chushou.c.c.dCo().a(new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.d.1
                @Override // com.kascend.chushou.c.b
                public void a() {
                }

                @Override // com.kascend.chushou.c.b
                public void a(String str2, JSONObject jSONObject) {
                    if (jSONObject != null) {
                        int optInt = jSONObject.optInt("code", -1);
                        String optString = jSONObject.optString("message");
                        if (optInt == 0) {
                            tv.chushou.zues.utils.g.M(d.this.nab, a.i.str_send_success);
                        } else {
                            a(optInt, optString);
                        }
                    }
                }

                @Override // com.kascend.chushou.c.b
                public void a(int i, String str2) {
                    if (!tv.chushou.zues.utils.h.isEmpty(str2)) {
                        tv.chushou.zues.utils.g.c(d.this.nab, str2);
                    } else {
                        tv.chushou.zues.utils.g.M(d.this.nab, a.i.str_send_fail);
                    }
                }
            }, this.naa.a, str, (String) null, this.mWp.getCurrentPos());
            if (this.naP != null && this.naP.getVisibility() == 0) {
                if (((VideoPlayer) this.nab).mRh != null && (colorPrivileges = ((VideoPlayer) this.nab).mRh.mColorPrivileges) != null && !tv.chushou.zues.utils.h.isEmpty(colorPrivileges.mColors)) {
                    arrayList = tv.chushou.zues.toolkit.richtext.b.ST(tv.chushou.zues.toolkit.richtext.b.a(str, colorPrivileges.mColors, colorPrivileges.mWholeColor, new Random().nextInt(colorPrivileges.mColors.size())));
                }
                this.naP.j(str, arrayList);
            }
        }
    }

    public void a(String str, String str2, String str3, String str4) {
        ArrayList<RichText> arrayList;
        ColorPrivileges colorPrivileges;
        com.kascend.chushou.c.c.dCo().a(new JsonCallbackWrapper() { // from class: com.kascend.chushou.player.d.2
            @Override // tv.chushou.basis.http.listener.JsonCallbackWrapper
            public void callStart() {
            }

            @Override // tv.chushou.basis.http.listener.JsonCallbackWrapper
            public void callSuccess(String str5, JSONObject jSONObject) {
                if (!d.this.dEp()) {
                    ParserRet dv = com.kascend.chushou.c.e.dv(jSONObject);
                    String str6 = dv.mMessage;
                    if (dv.mRc == 0) {
                        d.this.a((PrivilegeInfo) dv.mData);
                    } else {
                        callFailure(dv.mRc, str6, str5);
                    }
                }
            }

            @Override // tv.chushou.basis.http.listener.JsonCallbackWrapper
            public void callFailure(int i, @Nullable String str5, @Nullable String str6) {
                if (!d.this.dEp()) {
                    if (i == 401) {
                        com.kascend.chushou.d.e.b(d.this.nab, str5);
                    } else if (i == 403) {
                        if (tv.chushou.zues.utils.h.isEmpty(str5)) {
                            str5 = d.this.nab.getString(a.i.str_blacklist);
                        }
                        tv.chushou.zues.utils.g.c(d.this.nab, str5);
                    } else if (i == 21001 && !tv.chushou.zues.utils.h.isEmpty(str6)) {
                        try {
                            ParserRet dv = com.kascend.chushou.c.e.dv(new JSONObject(str6));
                            if ((dv.mData1 instanceof String) && !TextUtils.isEmpty((String) dv.mData1)) {
                                ListItem listItem = new ListItem();
                                listItem.mType = "99";
                                listItem.mUrl = (String) dv.mData1;
                                com.kascend.chushou.d.e.a(d.this.nab, listItem, (JSONObject) null);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }, str, str3, str2, str4);
        boolean z = false;
        if (this.naa != null) {
            if (this.ap < 0) {
                z = h.dCs().d;
            } else {
                z = h.dCs().e;
            }
        }
        if (z && this.naP != null && this.naP.getVisibility() == 0) {
            if (((VideoPlayer) this.nab).mRh == null || (colorPrivileges = ((VideoPlayer) this.nab).mRh.mColorPrivileges) == null || tv.chushou.zues.utils.h.isEmpty(colorPrivileges.mColors)) {
                arrayList = null;
            } else {
                arrayList = tv.chushou.zues.toolkit.richtext.b.ST(tv.chushou.zues.toolkit.richtext.b.a(str2, colorPrivileges.mColors, colorPrivileges.mWholeColor, new Random().nextInt(colorPrivileges.mColors.size())));
            }
            this.naP.j(str2, arrayList);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void f() {
        if (this.naP != null) {
            this.naP.SB(h.dCs().b());
        }
    }

    public void a(PlayUrl playUrl) {
        if (playUrl == null || playUrl.mSelectedUrl.length() == 0) {
            if (this.nat != null) {
                this.nat.dismiss();
                this.nat = null;
            }
        } else if (this.nat != null) {
            LinearLayout linearLayout = (LinearLayout) this.nat.getContentView().findViewById(a.f.ll_pop_root);
            for (int i = 0; i < linearLayout.getChildCount(); i++) {
                RadioGroup radioGroup = (RadioGroup) linearLayout.getChildAt(i).findViewById(a.f.rg_defi);
                if (radioGroup != null) {
                    PlayUrl playUrl2 = (PlayUrl) radioGroup.getTag();
                    for (int i2 = 0; i2 < playUrl2.mUrlDetails.size(); i2++) {
                        if (playUrl2.mUrlDetails.get(i2).mUrl.equals(playUrl.mSelectedUrl)) {
                            radioGroup.check(i2);
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g() {
        if (!c(true) && this.nab != null) {
            ((Activity) this.nab).finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean g(View view, MotionEvent motionEvent) {
        if (view == null) {
            return false;
        }
        int[] iArr = {0, 0};
        view.getLocationOnScreen(iArr);
        int i = iArr[0];
        int i2 = iArr[1];
        return motionEvent.getX() < ((float) i) || motionEvent.getX() > ((float) (view.getWidth() + i)) || motionEvent.getY() < ((float) i2) || motionEvent.getY() > ((float) (view.getHeight() + i2));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean h() {
        if (this.naa == null) {
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean i() {
        FullRoomInfo dDd;
        RoomInfo roomInfo;
        return (this.naa == null || (dDd = this.naa.dDd()) == null || (roomInfo = dDd.mRoominfo) == null || tv.chushou.zues.utils.h.isEmpty(roomInfo.mGameId)) ? false : true;
    }

    @Override // com.kascend.chushou.player.e
    public void j() {
        if (this.naP != null) {
            this.naP.dQf();
        }
        a((PlayUrl) null);
        ww(true);
    }

    @Override // com.kascend.chushou.player.e
    public void a(b bVar) {
        com.kascend.chushou.player.b.a dDO = dDO();
        if (dDO != null) {
            dDO.a(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ParserRet parserRet) {
        SparseArray sparseArray;
        RoomInfo dDf;
        boolean z;
        if (parserRet != null) {
            if (parserRet.mData2 == null) {
                sparseArray = null;
            } else {
                sparseArray = parserRet.mData2;
            }
            if (parserRet.mData3 != null) {
                SparseArray sparseArray2 = parserRet.mData3;
                if (sparseArray2.get(1) != null && (sparseArray2.get(1) instanceof BangInfo)) {
                    BangInfo bangInfo = (BangInfo) sparseArray2.get(1);
                    if (this.nab instanceof VideoPlayer) {
                        ((VideoPlayer) this.nab).dCN().a(bangInfo);
                    }
                }
                if (sparseArray2.get(2) != null && (sparseArray2.get(2) instanceof ArrayList)) {
                    Iterator it = ((ArrayList) sparseArray2.get(2)).iterator();
                    while (it.hasNext()) {
                        com.kascend.chushou.player.ui.h5.c.a aVar = (com.kascend.chushou.player.ui.h5.c.a) it.next();
                        if (this.nab instanceof VideoPlayer) {
                            ((VideoPlayer) this.nab).c(aVar);
                        }
                    }
                }
                if (sparseArray2.get(3) != null && (sparseArray2.get(3) instanceof MicStatus) && this.naa != null && this.naa.dDd() != null) {
                    this.naa.dDd().mMicStatus = (MicStatus) sparseArray2.get(3);
                    if (this.naa.dDd().mMicStatus != null) {
                        if (this.naa.dDd().mMicStatus.onMic) {
                            if (sparseArray2.get(4) != null && (sparseArray2.get(4) instanceof ArrayList) && LoginManager.Instance().getUserInfo() != null && !tv.chushou.zues.utils.h.isEmpty(LoginManager.Instance().getUserInfo().mUserID)) {
                                Iterator it2 = ((ArrayList) sparseArray2.get(4)).iterator();
                                while (true) {
                                    if (!it2.hasNext()) {
                                        z = false;
                                        break;
                                    }
                                    FanItem fanItem = (FanItem) it2.next();
                                    if (fanItem != null && String.valueOf(LoginManager.Instance().getUserInfo().mUserID).equals(fanItem.mUserId) && !String.valueOf(LoginManager.Instance().getUserInfo().mUserID).equals(this.naa.dDd().mRoominfo.mCreatorUID)) {
                                        z = true;
                                        break;
                                    }
                                }
                                if (z) {
                                    this.J = 0.0f;
                                    if (this.mWp != null) {
                                        this.mWp.setVolume(this.J, this.J);
                                    }
                                } else if (this.mTq) {
                                    this.J = 1.0f;
                                    if (this.mWp != null) {
                                        this.mWp.setVolume(this.J, this.J);
                                    }
                                }
                                this.mTq = z;
                            }
                        } else if (this.mWp != null && this.mTq) {
                            this.J = 1.0f;
                            this.mWp.setVolume(this.J, this.J);
                        }
                    }
                }
                if (sparseArray2.get(5) != null) {
                    String obj = sparseArray2.get(5).toString();
                    if ("10003".equals(obj)) {
                        ((VideoPlayer) this.nab).t = "10003";
                        if (this.mWp != null && "1".equals(this.aw) && !"2".equals(this.ay) && this.mWp.getPlayState() != 4) {
                            j();
                            ((VideoPlayer) this.nab).m();
                        }
                    } else if ("10004".equals(obj)) {
                        tv.chushou.zues.utils.e.d("Rancune", "officeLine");
                        if (this.nab instanceof VideoPlayer) {
                            ((VideoPlayer) this.nab).t = "10004";
                            dDH();
                        }
                    }
                }
                if (sparseArray2.get(6) != null) {
                    List<com.kascend.chushou.player.ui.h5.c.e> list = (List) sparseArray2.get(6);
                    if (!tv.chushou.zues.utils.h.isEmpty(list)) {
                        ((VideoPlayer) this.nab).dCJ().a(list);
                    }
                }
                if (sparseArray2.get(7) != null) {
                    ((VideoPlayer) this.nab).dCK().a((List) sparseArray2.get(7));
                }
                if (sparseArray2.get(11) != null) {
                    ((VideoPlayer) this.nab).dCL().a((com.kascend.chushou.player.ui.h5.c.c) sparseArray2.get(11));
                }
                if (sparseArray2.get(12) != null) {
                    AutoBang autoBang = (AutoBang) sparseArray2.get(12);
                    if (this.nab instanceof VideoPlayer) {
                        ((VideoPlayer) this.nab).dCN().a(autoBang);
                    }
                }
                if (sparseArray2.get(16) != null) {
                    com.kascend.chushou.player.ui.h5.c.b bVar = (com.kascend.chushou.player.ui.h5.c.b) sparseArray2.get(16);
                    if (this.nab instanceof VideoPlayer) {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(bVar);
                        ((VideoPlayer) this.nab).dCM().a(arrayList);
                    }
                }
                if (sparseArray2.get(19) != null && ((Boolean) sparseArray2.get(19)).booleanValue() && (this.mTu == null || tv.chushou.zues.utils.h.isEmpty(this.mTu.uid))) {
                    if (this.B != null) {
                        this.B.setVisibility(0);
                    }
                    if (this.mTv != null) {
                        this.mTv.dispose();
                        this.mTv = null;
                    }
                    this.mTv = io.reactivex.g.a(0L, 12L, 0L, 1L, TimeUnit.SECONDS).a(io.reactivex.a.b.a.dJJ()).a(new io.reactivex.c.g<Long>() { // from class: com.kascend.chushou.player.d.3
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // io.reactivex.c.g
                        /* renamed from: a */
                        public void accept(Long l) throws Exception {
                            if (d.this.B != null) {
                                long longValue = 10 - l.longValue();
                                if (longValue == 10) {
                                    d.this.B.setText(a.i.into_live_live);
                                } else if (longValue == 4) {
                                    d.this.B.setText(String.valueOf(longValue + 1));
                                } else if (longValue == 3) {
                                    d.this.B.setText(String.valueOf(longValue + 1));
                                } else if (longValue == 2) {
                                    d.this.B.setText(String.valueOf(longValue + 1));
                                } else if (longValue == 1) {
                                    d.this.B.setText(String.valueOf(longValue + 1));
                                } else if (longValue == 0) {
                                    d.this.B.setText(String.valueOf(longValue + 1));
                                }
                            }
                        }
                    }, new io.reactivex.c.g<Throwable>() { // from class: com.kascend.chushou.player.d.4
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // io.reactivex.c.g
                        /* renamed from: a */
                        public void accept(Throwable th) throws Exception {
                        }
                    }, new io.reactivex.c.a() { // from class: com.kascend.chushou.player.d.5
                        @Override // io.reactivex.c.a
                        public void run() throws Exception {
                            if (d.this.B != null) {
                                d.this.B.setVisibility(8);
                                d.this.B.setText("");
                            }
                        }
                    });
                }
            }
            if (parserRet.mData != null) {
                ArrayList<ChatInfo> arrayList2 = (ArrayList) parserRet.mData;
                if (this.naa != null) {
                    this.naa.a(arrayList2);
                    if (((VideoPlayer) this.nab).q) {
                        if (sparseArray != null) {
                            if (sparseArray.get(1) != null) {
                                this.naa.mSJ.a((ArrayList) sparseArray.get(1));
                                if (this.nac != null && !this.nac.Om(11)) {
                                    this.nac.O(this.nac.On(11));
                                }
                            }
                            if (sparseArray.get(2) != null) {
                                this.naa.mSJ.b((ArrayList) sparseArray.get(2));
                                if (this.nac != null && !this.nac.Om(12)) {
                                    this.nac.O(this.nac.On(12));
                                }
                            }
                        } else if (this.naa.mSJ != null) {
                            if (this.naa.mSJ.d() && this.nac != null && !this.nac.Om(11)) {
                                this.nac.O(this.nac.On(11));
                            }
                            if (this.naa.mSJ.h() && this.nac != null && !this.nac.Om(12)) {
                                this.nac.O(this.nac.On(12));
                            }
                        }
                    }
                }
                if (arrayList2 != null && arrayList2.size() != 0) {
                    boolean z2 = false;
                    if (this.naa != null) {
                        if (this.ap < 0) {
                            z2 = h.dCs().d;
                        } else {
                            z2 = h.dCs().e;
                        }
                    }
                    if (this.naP != null && z2 && this.naP.getVisibility() == 0) {
                        Iterator<ChatInfo> it3 = arrayList2.iterator();
                        while (it3.hasNext()) {
                            ChatInfo next = it3.next();
                            if (tv.chushou.zues.utils.h.isEmpty(next.mDisplayPosition) || next.mDisplayPosition.contains("3")) {
                                tv.chushou.apollo.a.a aVar2 = new tv.chushou.apollo.a.a();
                                aVar2.mContent = next.mContent;
                                aVar2.mType = next.mType;
                                aVar2.mUserID = next.mUserID;
                                aVar2.mUserNickname = next.mUserNickname;
                                aVar2.mContentRichText = next.mContentRichText;
                                aVar2.nWA.icon = next.mGift.icon;
                                if (next.mItem != null && !tv.chushou.zues.utils.h.isEmpty(next.mItem.mType) && this.naa != null && ((dDf = this.naa.dDf()) == null || !next.mItem.mType.equals("1") || !next.mItem.mTargetKey.equals(dDf.mRoomID))) {
                                    aVar2.tag = next.mItem;
                                }
                                this.naP.a(aVar2);
                            }
                        }
                    }
                    if (dDO() != null && (this.nab instanceof VideoPlayer) && ((VideoPlayer) this.nab).q) {
                        dDO().a(arrayList2);
                    }
                }
            }
        }
    }

    @Override // com.kascend.chushou.player.e
    public void k() {
        if (this.nab instanceof VideoPlayer) {
            if (((VideoPlayer) this.nab).q) {
                dDx().setVisibility(0);
            } else {
                dDx().setVisibility(8);
            }
        }
    }

    @Override // com.kascend.chushou.player.e
    public void l() {
        dDx().setVisibility(8);
    }

    @Override // com.kascend.chushou.player.e
    public void m() {
        com.kascend.chushou.player.b.a dDO = dDO();
        if (dDO != null) {
            dDO.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int d(int i) {
        if (Math.abs(i) < this.ar / 100) {
            return 0;
        }
        return (this.at * i) / this.ar;
    }

    protected void n() {
        int i;
        int i2 = 0;
        if (!this.k && this.mTn != null) {
            try {
                if (this.mWp != null) {
                    i = this.mWp.getCurrentPos();
                    i2 = this.mWp.getDuration();
                } else {
                    i = 0;
                }
                if (i2 > 1000) {
                    this.mTn.setProgress(i / (i2 / 1000));
                }
            } catch (NullPointerException e) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(boolean z, int i) {
        if (this.mTp != null) {
            if (z) {
                this.mTp.setStatusBarTintResource(i);
                this.mTp.setTintResource(i);
                this.mTp.setStatusBarTintEnabled(true);
                this.mTp.setNavigationBarTintEnabled(true);
                return;
            }
            this.mTp.setStatusBarTintEnabled(false);
            this.mTp.setNavigationBarTintEnabled(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(String str) {
        if (this.nab instanceof VideoPlayer) {
            str = ((VideoPlayer) this.nab).a(str);
        }
        com.kascend.chushou.d.a.c(this.nab, str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean o() {
        return false;
    }

    @Override // com.kascend.chushou.player.e
    public void e(int i) {
    }

    @Override // com.kascend.chushou.player.e
    public void p() {
    }

    @Override // com.kascend.chushou.player.e
    public void a(boolean z) {
    }

    public void q() {
    }

    @Override // com.kascend.chushou.player.e
    public void a(n nVar) {
    }

    public void a(ListItem listItem) {
    }

    @Override // com.kascend.chushou.player.e
    public void r() {
    }

    @Override // com.kascend.chushou.player.e
    public void s() {
    }

    @Override // com.kascend.chushou.player.g, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        int id = view.getId();
        if (id == a.f.tv_open_video) {
            ai();
        } else if (id == a.f.tv_pk_subscribe) {
            if (this.mTr != null && this.mTr.mWq != null && !tv.chushou.zues.utils.h.isEmpty(this.mTr.mWq.mPkRoomId)) {
                ListItem listItem = new ListItem();
                if (this.mTr.mWq.liveStyle == 0 || this.mTr.mWq.liveStyle == 1) {
                    listItem.mLiveType = "1";
                } else {
                    listItem.mLiveType = "2";
                }
                listItem.mType = "1";
                listItem.mTargetKey = this.mTr.mWq.mPkRoomId;
                com.kascend.chushou.d.e.a(this.nab, listItem, (JSONObject) null);
            }
        } else if (id == a.f.tv_pk_name && this.mTr != null && this.mTr.mWq != null && !tv.chushou.zues.utils.h.isEmpty(this.mTr.mWq.mPkUid)) {
            com.kascend.chushou.d.a.a(this.nab, (JSONObject) null, this.mTr.mWq.mPkRoomId, this.mTr.mWq.mPkUid, LoginManager.Instance().getUserInfo() != null ? String.valueOf(LoginManager.Instance().getUserInfo().mUserID) : "", false);
        }
    }

    @Override // com.kascend.chushou.player.e
    public boolean a(MotionEvent motionEvent) {
        if ((motionEvent.getAction() == 1 || motionEvent.getAction() == 3 || motionEvent.getAction() == 4) && this.k && this.mWp != null) {
            this.k = false;
            this.kXT = Math.min(this.mWp.getDuration(), Math.max(0, this.mWp.getCurrentPos() + this.j));
            if (this.nac != null) {
                this.nac.removeMessages(14);
                this.nac.Ol(14);
            }
            this.j = 0;
        }
        if (this.c != null) {
            return this.c.onTouchEvent(motionEvent);
        }
        return false;
    }

    @Override // com.kascend.chushou.player.e
    public boolean a(int i, KeyEvent keyEvent) {
        if (i == 4) {
            return this.E && c(true);
        }
        return false;
    }

    /* loaded from: classes5.dex */
    public class a implements GestureDetector.OnGestureListener {
        public final int a = 1;
        public final int b = 2;
        public final int c = 5;
        public int d = 0;
        public int e = 0;

        public a() {
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            this.d = 0;
            this.e = 0;
            return false;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            return d.this.a(motionEvent, motionEvent2, f, f2);
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            return d.this.a(this, motionEvent, motionEvent2, f, f2);
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public void onShowPress(MotionEvent motionEvent) {
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            tv.chushou.zues.utils.e.d("VideoPlayerBaseFragment", "[onSingleTapUp]");
            return d.this.a(this, motionEvent);
        }
    }

    protected boolean a(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return true;
    }

    protected boolean a(a aVar, MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return false;
    }

    protected boolean a(a aVar, MotionEvent motionEvent) {
        return false;
    }

    @Override // com.kascend.chushou.player.e
    public void c(String str) {
        ArrayList<RichText> arrayList;
        ColorPrivileges colorPrivileges;
        boolean z = false;
        if (this.naa != null) {
            if (this.ap < 0) {
                z = h.dCs().d;
            } else {
                z = h.dCs().e;
            }
        }
        if (z && this.naP != null && this.naP.getVisibility() == 0) {
            if (((VideoPlayer) this.nab).mRh == null || (colorPrivileges = ((VideoPlayer) this.nab).mRh.mColorPrivileges) == null || tv.chushou.zues.utils.h.isEmpty(colorPrivileges.mColors)) {
                arrayList = null;
            } else {
                arrayList = tv.chushou.zues.toolkit.richtext.b.ST(tv.chushou.zues.toolkit.richtext.b.a(str, colorPrivileges.mColors, colorPrivileges.mWholeColor, new Random().nextInt(colorPrivileges.mColors.size())));
            }
            this.naP.j(str, arrayList);
        }
    }

    public void f(int i) {
        com.kascend.chushou.c.c.dCo().a(i, new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.d.6
            @Override // com.kascend.chushou.c.b
            public void a() {
            }

            @Override // com.kascend.chushou.c.b
            public void a(String str, JSONObject jSONObject) {
                if (!d.this.dEp()) {
                    if (jSONObject != null) {
                        int optInt = jSONObject.optInt("data");
                        if (d.this.naa != null && d.this.naa.mSY != null) {
                            d.this.naa.mSY.count = optInt;
                            d.this.M();
                        }
                        tv.chushou.zues.utils.g.Os(a.i.str_buy_trumpte_success);
                        return;
                    }
                    a(-1, "");
                }
            }

            @Override // com.kascend.chushou.c.b
            public void a(int i2, String str) {
                String str2;
                if (!d.this.dEp()) {
                    if (i2 == 401) {
                        com.kascend.chushou.d.e.b(d.this.nab, str);
                    } else if (i2 == 403) {
                        if (tv.chushou.zues.utils.h.isEmpty(str)) {
                            str = d.this.nab.getString(a.i.str_blacklist);
                        }
                        tv.chushou.zues.utils.g.c(d.this.nab, str);
                    } else if (i2 == 1027) {
                        if (!(d.this.nab instanceof VideoPlayer)) {
                            str2 = null;
                        } else {
                            str2 = ((VideoPlayer) d.this.nab).a((String) null);
                        }
                        com.kascend.chushou.d.e.a(d.this.getActivity(), str2);
                    } else if (tv.chushou.zues.utils.h.isEmpty(str)) {
                        tv.chushou.zues.utils.g.Os(a.i.str_buy_trumpte_failuer);
                    } else {
                        tv.chushou.zues.utils.g.u(str);
                    }
                }
            }
        });
    }

    public void a(String str, String str2) {
        com.kascend.chushou.c.c.dCo().c(str, str2, new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.d.7
            @Override // com.kascend.chushou.c.b
            public void a() {
            }

            @Override // com.kascend.chushou.c.b
            public void a(String str3, JSONObject jSONObject) {
                if (!d.this.dEp() && jSONObject != null) {
                    int optInt = jSONObject.optInt("data");
                    tv.chushou.zues.utils.g.Os(a.i.str_send_success);
                    if (d.this.naa != null && d.this.naa.mSY != null) {
                        d.this.naa.mSY.count = optInt;
                        d.this.M();
                        return;
                    }
                    a(-1, "");
                }
            }

            @Override // com.kascend.chushou.c.b
            public void a(int i, String str3) {
                if (!d.this.dEp()) {
                    if (i == 401) {
                        com.kascend.chushou.d.e.b(d.this.nab, str3);
                    } else if (i == 403 && tv.chushou.zues.utils.h.isEmpty(str3)) {
                        str3 = d.this.nab.getString(a.i.str_blacklist);
                    }
                    if (tv.chushou.zues.utils.h.isEmpty(str3)) {
                        tv.chushou.zues.utils.g.M(d.this.nab, a.i.str_send_fail);
                    } else {
                        tv.chushou.zues.utils.g.c(d.this.nab, str3);
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void t() {
        final int hh = tv.chushou.zues.utils.systemBar.b.hh(getActivity());
        this.mTw.setOnActionListener(new VoiceInteractionView.b() { // from class: com.kascend.chushou.player.d.8
            @Override // com.kascend.chushou.widget.VoiceInteractionView.b
            public void a() {
                ListItem listItem = new ListItem();
                listItem.mUrl = com.kascend.chushou.c.c.a(50);
                d.this.a(listItem);
            }

            @Override // com.kascend.chushou.widget.VoiceInteractionView.b
            public void b() {
                com.kascend.chushou.d.e.a(d.this.nab, com.kascend.chushou.c.c.a(51) + "micRoomId=" + d.this.G);
            }

            @Override // com.kascend.chushou.widget.VoiceInteractionView.b
            public void a(int i, MicMemberInfo micMemberInfo, boolean z) {
                if (micMemberInfo != null) {
                    if (!z) {
                        com.kascend.chushou.d.a.a(d.this.nab, (JSONObject) null, (String) null, micMemberInfo.uid, LoginManager.Instance().getUserInfo() != null ? String.valueOf(LoginManager.Instance().getUserInfo().mUserID) : "", false);
                        return;
                    }
                    micMemberInfo.micRoomId = d.this.G;
                    if (d.this.ap == 0) {
                        boolean z2 = d.this.naH == null;
                        d.this.a(false, false, micMemberInfo);
                        if (z2 && hh > 0 && d.this.naH != null && tv.chushou.zues.utils.systemBar.b.aF(d.this.getActivity()) && tv.chushou.zues.utils.systemBar.b.aG(d.this.getActivity())) {
                            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) d.this.naH.getLayoutParams();
                            layoutParams.rightMargin += hh;
                            d.this.naH.setLayoutParams(layoutParams);
                            return;
                        }
                        return;
                    }
                    boolean z3 = d.this.naH == null;
                    if (d.this.nab.getResources().getDisplayMetrics().density < 2.0f) {
                        d.this.a(true, false, micMemberInfo);
                    } else {
                        d.this.a(true, true, micMemberInfo);
                    }
                    if (z3 && hh > 0 && d.this.naH != null) {
                        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) d.this.naH.getLayoutParams();
                        layoutParams2.bottomMargin += hh;
                        d.this.naH.setLayoutParams(layoutParams2);
                    }
                }
            }
        });
    }

    protected void u() {
    }

    protected void b(boolean z) {
    }

    public boolean c(boolean z) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void i(ArrayList<MicMemberInfo> arrayList, String str) {
        boolean z;
        if (this.naa.dDd().mMicStatus.onMic != this.E) {
            this.E = this.naa.dDd().mMicStatus.onMic;
            u();
        }
        this.E = this.naa.dDd().mMicStatus.onMic;
        if (this.E) {
            if (this.naa.dDd().mMicStatus != null && !tv.chushou.zues.utils.h.isEmpty(this.naa.dDd().mMicStatus.micRoomId) && !this.naa.dDd().mMicStatus.micRoomId.equals("0")) {
                this.G = this.naa.dDd().mMicStatus.micRoomId;
            }
            Iterator<MicMemberInfo> it = arrayList.iterator();
            while (it.hasNext()) {
                if (str.equals(it.next().uid)) {
                    it.remove();
                }
            }
            if (LoginManager.Instance().getUserInfo() != null) {
                String valueOf = String.valueOf(LoginManager.Instance().getUserInfo().mUserID);
                if (!tv.chushou.zues.utils.h.isEmpty(arrayList) && !tv.chushou.zues.utils.h.isEmpty(valueOf)) {
                    Iterator<MicMemberInfo> it2 = arrayList.iterator();
                    while (it2.hasNext()) {
                        if (valueOf.equals(it2.next().uid)) {
                            z = true;
                            break;
                        }
                    }
                }
            }
            z = false;
            this.F = z;
            if (this.mTw != null) {
                b(true);
                this.mTw.setupCount(this.naa.dDd().mMicStatus.capacity - 1);
                this.mTw.a(this.naa.dDd().mMicStatus.isOngoing == 1, z, this.naa.dDd().mMicStatus.displayInteraction == 1);
                this.mTw.a(arrayList);
                return;
            }
            return;
        }
        this.F = false;
        b(false);
    }

    public void a(String str, String str2, EditText editText) {
        if (!tv.chushou.zues.utils.h.isEmpty(str2) && editText != null) {
            String str3 = "@" + str2 + HanziToPinyin.Token.SEPARATOR;
            tv.chushou.zues.widget.a.c cVar = new tv.chushou.zues.widget.a.c();
            cVar.a(str3, new DanmuAtSpan(0, str3.length()));
            editText.setText(cVar);
            editText.setSelection(cVar.length());
        }
    }

    public boolean o(EditText editText) {
        if (editText == null) {
            return false;
        }
        int selectionStart = editText.getSelectionStart();
        int selectionEnd = editText.getSelectionEnd();
        if (selectionStart != selectionEnd) {
            return false;
        }
        Editable text = editText.getText();
        DanmuAtSpan[] danmuAtSpanArr = (DanmuAtSpan[]) text.getSpans(0, text.length(), DanmuAtSpan.class);
        if (danmuAtSpanArr != null) {
            for (DanmuAtSpan danmuAtSpan : danmuAtSpanArr) {
                if (danmuAtSpan.getEnd() == selectionEnd) {
                    SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(text);
                    spannableStringBuilder.delete(danmuAtSpan.getStart(), danmuAtSpan.getEnd());
                    editText.setText(spannableStringBuilder);
                    editText.setSelection(spannableStringBuilder.length());
                    return true;
                }
            }
        }
        return false;
    }
}

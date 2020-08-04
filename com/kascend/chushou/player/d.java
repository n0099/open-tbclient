package com.kascend.chushou.player;

import android.animation.Animator;
import android.graphics.Point;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
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
import com.baidu.searchbox.ugc.model.UgcConstant;
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
import com.kascend.chushou.view.b.d;
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
/* loaded from: classes6.dex */
public abstract class d extends g implements View.OnClickListener, b.a {
    protected static int q;
    protected static int r;
    protected TextView B;
    protected String G;
    protected GestureDetector c;
    protected a npT;
    protected com.kascend.chushou.widget.a.b npV;
    protected tv.chushou.zues.utils.systemBar.a npX;
    protected com.kascend.chushou.player.e.a npZ;
    protected com.kascend.chushou.player.e.b nqa;
    protected RelativeLayout nqb;
    protected VoiceInteractionView nqe;
    protected String u;
    protected TextView y;
    protected TextView z;
    protected ImageButton a = null;
    protected String b = null;
    private boolean npU = false;
    protected boolean e = true;
    protected boolean f = false;
    protected TextView h = null;
    protected TextView i = null;
    protected int j = 0;
    protected boolean k = false;
    protected ProgressBar npW = null;
    protected long m = 0;
    protected int n = 0;
    protected boolean p = false;
    private boolean npY = false;
    protected boolean v = false;
    protected int w = -1;
    protected CycleLiveRoomInfo nqc = null;
    protected io.reactivex.disposables.b nqd = null;
    protected boolean E = false;
    protected boolean F = false;
    private long nqf = 0;

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.nwx = getActivity();
        if (aa()) {
            tv.chushou.zues.utils.e.e("VideoPlayerBaseFragment", "killed in backgroud");
            return;
        }
        Point gE = tv.chushou.zues.utils.a.gE(this.nwx);
        q = Math.min(gE.x, gE.y) / 5;
        r = 200;
        this.nwz = (AudioManager) this.nwx.getApplicationContext().getSystemService("audio");
        this.nqf = System.currentTimeMillis();
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
        S();
        dNl();
        ((VideoPlayer) this.nwx).m = false;
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.ah = true;
        R();
        if (this.N != null && this.nsS != null) {
            this.N.setVisibility(8);
        }
        if (this.nwy != null) {
            this.nwy.removeMessages(15);
        }
        a(false, false);
        if (this.nwy != null) {
            this.nwy.removeMessages(1);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // com.kascend.chushou.player.f, android.support.v4.app.Fragment
    public void onDestroy() {
        this.nwh.dispose();
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view) {
        this.nwj = (RelativeLayout) view.findViewById(a.f.rl_audio);
        this.nwk = (FrescoThumbnailView) view.findViewById(a.f.iv_audio_bg);
        this.Q = (ImageView) view.findViewById(a.f.iv_audio_avator_bg);
        this.nwl = (FrescoThumbnailView) view.findViewById(a.f.iv_audio_avator);
        this.bDz = (TextView) view.findViewById(a.f.tv_audio_playing);
        this.nwm = (TextView) view.findViewById(a.f.tv_open_video);
        this.nwm.setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b() {
        this.nws = (ProgressBar) this.nwi.findViewById(a.f.LoadingProgressBar);
        this.nwt = (TextView) this.nwi.findViewById(a.f.LoadingPercent);
        this.nwu = (TextView) this.nwi.findViewById(a.f.LoadingBuffer);
        this.nwv = (TextView) this.nwi.findViewById(a.f.tv_change_lines);
        this.nws.setVisibility(8);
        this.nwt.setVisibility(8);
        this.nwu.setVisibility(8);
        this.nwv.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c() {
        this.nqb = (RelativeLayout) this.nwi.findViewById(a.f.rl_pk_name);
        this.y = (TextView) this.nwi.findViewById(a.f.tv_pk_name);
        this.z = (TextView) this.nwi.findViewById(a.f.tv_pk_subscribe);
        this.z.setOnClickListener(this);
        this.y.setOnClickListener(this);
        this.B = (TextView) this.nwi.findViewById(a.f.iv_cyclelive_countdown);
    }

    private void dNl() {
        if (i() || h()) {
            if (this.N != null) {
                this.N.setVisibility(0);
            }
            this.nsS = ((VideoPlayer) this.nwx).dMy();
            if (this.nsS != null) {
                Uri uri = this.nsS.getUri();
                Uri dME = ((VideoPlayer) this.nwx).dME();
                if (!this.nwA) {
                    if (dME != null && uri != null && !uri.equals(dME)) {
                        ((VideoPlayer) this.nwx).a(true, (Uri) null, false);
                    } else if (h.dMp().a) {
                        ((VideoPlayer) this.nwx).a(true, (Uri) null, false);
                    } else if (((VideoPlayer) this.nwx).m) {
                        if (h() && this.nww.d()) {
                            if (!this.ai) {
                                ((VideoPlayer) this.nwx).a(true, (Uri) null, false);
                                return;
                            }
                            return;
                        }
                        ((VideoPlayer) this.nwx).a(true, (Uri) null, false);
                    } else {
                        AudioManager audioManager = ((VideoPlayer) this.nwx).nnY;
                        VideoPlayer videoPlayer = (VideoPlayer) this.nwx;
                        audioManager.setStreamVolume(3, VideoPlayer.n, 0);
                        if (this.nww.d()) {
                            if (!this.ai) {
                                if (this.ap < 0) {
                                    if (this.nww.d) {
                                        T();
                                        if (this.nwp != null) {
                                            this.nwp.setImageResource(a.e.ic_btn_room_video_n);
                                        }
                                    } else {
                                        U();
                                        S();
                                        if (this.nwo != null) {
                                            this.nwo.setVisibility(0);
                                        }
                                        if (this.nwp != null) {
                                            this.nwp.setImageResource(a.e.ic_btn_room_audio_n);
                                        }
                                    }
                                }
                                n(true);
                            }
                        } else if (!this.H && !this.al) {
                            ((VideoPlayer) this.nwx).a(true, (Uri) null, false);
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d() {
        FullRoomInfo dNb;
        tv.chushou.zues.utils.e.e("VideoPlayerBaseFragment", "release <----------");
        if (this.B != null) {
            this.B.setVisibility(8);
        }
        if (this.nqd != null) {
            this.nqd.dispose();
            this.nqd = null;
        }
        if (this.nww != null && (dNb = this.nww.dNb()) != null && !tv.chushou.zues.utils.h.isEmpty(dNb.mGeneralTabGifts)) {
            for (int i = 0; i < dNb.mGeneralTabGifts.size(); i++) {
                GeneralTabGift generalTabGift = dNb.mGeneralTabGifts.get(i);
                if (generalTabGift != null && !tv.chushou.zues.utils.h.isEmpty(generalTabGift.mGeneralGifts)) {
                    for (int i2 = 0; i2 < generalTabGift.mGeneralGifts.size(); i2++) {
                        if (generalTabGift.mGeneralGifts.get(i2) != null) {
                            generalTabGift.mGeneralGifts.get(i2).mSelectFlag = false;
                        }
                    }
                }
            }
        }
        if (this.nwU != null) {
            this.nwU.clear();
            this.nwU = null;
        }
        if (this.npX != null) {
            this.npX.setStatusBarTintEnabled(false);
            this.npX.setNavigationBarTintEnabled(false);
        }
        if (this.nxj != null) {
            this.nxj.unInit();
            this.nxj = null;
            dOa().removeAllViews();
        }
        if (this.nwX != null) {
            ((ViewGroup) this.nwi).removeView(this.nwX);
            this.nwX = null;
        }
        if (this.nxk != null) {
            this.nxk.cancel();
            ArrayList<Animator> childAnimations = this.nxk.getChildAnimations();
            if (!tv.chushou.zues.utils.h.isEmpty(childAnimations)) {
                Iterator<Animator> it = childAnimations.iterator();
                while (it.hasNext()) {
                    it.next().removeAllListeners();
                }
            }
            this.nxk.removeAllListeners();
            this.nxk = null;
        }
        this.nwZ = null;
        if (this.N != null) {
            ((ViewGroup) this.nwi).removeView(this.N);
            this.N = null;
        }
        if (this.nxf != null) {
            this.nxf.a();
            this.nxf = null;
        }
        if (this.nxp != null) {
            this.nxp.dismiss();
        }
        if (this.nxo != null) {
            this.nxo.dismiss();
        }
        this.a = null;
        this.nwi = null;
        this.nwz = null;
        tv.chushou.zues.utils.e.i("VideoPlayerBaseFragment", "release ---------->");
    }

    @Override // com.kascend.chushou.player.e
    public void e() {
        this.H = false;
        this.nwA = false;
        m(true);
        x();
    }

    public void a(PrivilegeInfo privilegeInfo) {
        ((VideoPlayer) this.nwx).nnU = privilegeInfo;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(String str) {
        ColorPrivileges colorPrivileges;
        ArrayList<RichText> arrayList = null;
        if (this.nww != null && !tv.chushou.zues.utils.h.isEmpty(this.nww.a) && this.nsS != null) {
            com.kascend.chushou.c.c.dMl().a(new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.d.1
                @Override // com.kascend.chushou.c.b
                public void a() {
                }

                @Override // com.kascend.chushou.c.b
                public void a(String str2, JSONObject jSONObject) {
                    if (jSONObject != null) {
                        int optInt = jSONObject.optInt("code", -1);
                        String optString = jSONObject.optString("message");
                        if (optInt == 0) {
                            tv.chushou.zues.utils.g.F(d.this.nwx, a.i.str_send_success);
                        } else {
                            a(optInt, optString);
                        }
                    }
                }

                @Override // com.kascend.chushou.c.b
                public void a(int i, String str2) {
                    if (!tv.chushou.zues.utils.h.isEmpty(str2)) {
                        tv.chushou.zues.utils.g.c(d.this.nwx, str2);
                    } else {
                        tv.chushou.zues.utils.g.F(d.this.nwx, a.i.str_send_fail);
                    }
                }
            }, this.nww.a, str, (String) null, this.nsS.getCurrentPos());
            if (this.nxj != null && this.nxj.getVisibility() == 0) {
                if (((VideoPlayer) this.nwx).nnU != null && (colorPrivileges = ((VideoPlayer) this.nwx).nnU.mColorPrivileges) != null && !tv.chushou.zues.utils.h.isEmpty(colorPrivileges.mColors)) {
                    arrayList = tv.chushou.zues.toolkit.richtext.b.TQ(tv.chushou.zues.toolkit.richtext.b.a(str, colorPrivileges.mColors, colorPrivileges.mWholeColor, new Random().nextInt(colorPrivileges.mColors.size())));
                }
                this.nxj.h(str, arrayList);
            }
        }
    }

    public void a(String str, String str2, String str3, String str4) {
        ArrayList<RichText> arrayList;
        ColorPrivileges colorPrivileges;
        com.kascend.chushou.c.c.dMl().a(new JsonCallbackWrapper() { // from class: com.kascend.chushou.player.d.2
            @Override // tv.chushou.basis.http.listener.JsonCallbackWrapper
            public void callStart() {
            }

            @Override // tv.chushou.basis.http.listener.JsonCallbackWrapper
            public void callSuccess(String str5, JSONObject jSONObject) {
                if (!d.this.aa()) {
                    ParserRet dW = com.kascend.chushou.c.e.dW(jSONObject);
                    String str6 = dW.mMessage;
                    if (dW.mRc == 0) {
                        d.this.a((PrivilegeInfo) dW.mData);
                    } else {
                        callFailure(dW.mRc, str6, str5);
                    }
                }
            }

            @Override // tv.chushou.basis.http.listener.JsonCallbackWrapper
            public void callFailure(int i, @Nullable String str5, @Nullable String str6) {
                if (!d.this.aa()) {
                    if (i == 401) {
                        com.kascend.chushou.d.e.b(d.this.nwx, str5);
                    } else if (i == 403) {
                        if (tv.chushou.zues.utils.h.isEmpty(str5)) {
                            str5 = d.this.nwx.getString(a.i.str_blacklist);
                        }
                        tv.chushou.zues.utils.g.c(d.this.nwx, str5);
                    } else if (i == 21001 && !tv.chushou.zues.utils.h.isEmpty(str6)) {
                        try {
                            ParserRet dW = com.kascend.chushou.c.e.dW(new JSONObject(str6));
                            if ((dW.mData1 instanceof String) && !TextUtils.isEmpty((String) dW.mData1)) {
                                ListItem listItem = new ListItem();
                                listItem.mType = "99";
                                listItem.mUrl = (String) dW.mData1;
                                com.kascend.chushou.d.e.a(d.this.nwx, listItem, (JSONObject) null);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }, str, str3, str2, str4);
        boolean z = false;
        if (this.nww != null) {
            if (this.ap < 0) {
                z = h.dMp().d;
            } else {
                z = h.dMp().e;
            }
        }
        if (z && this.nxj != null && this.nxj.getVisibility() == 0) {
            if (((VideoPlayer) this.nwx).nnU == null || (colorPrivileges = ((VideoPlayer) this.nwx).nnU.mColorPrivileges) == null || tv.chushou.zues.utils.h.isEmpty(colorPrivileges.mColors)) {
                arrayList = null;
            } else {
                arrayList = tv.chushou.zues.toolkit.richtext.b.TQ(tv.chushou.zues.toolkit.richtext.b.a(str2, colorPrivileges.mColors, colorPrivileges.mWholeColor, new Random().nextInt(colorPrivileges.mColors.size())));
            }
            this.nxj.h(str2, arrayList);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void f() {
        if (this.nxj != null) {
            this.nxj.Ty(h.dMp().b());
        }
    }

    public void a(PlayUrl playUrl) {
        if (playUrl == null || playUrl.mSelectedUrl.length() == 0) {
            if (this.nwO != null) {
                this.nwO.dismiss();
                this.nwO = null;
            }
        } else if (this.nwO != null) {
            LinearLayout linearLayout = (LinearLayout) this.nwO.getContentView().findViewById(a.f.ll_pop_root);
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
        if (!c(true) && !dNn()) {
            dNm();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dNm() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    private boolean dNn() {
        RoomInfo dNe;
        if (this.nww == null || (dNe = this.nww.dNe()) == null || dNe.mIsSubscribed || aa()) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long dMu = h.dMp().dMu();
        if (currentTimeMillis - this.nqf <= 60000 || currentTimeMillis - dMu <= 86400000) {
            return false;
        }
        h.dMp().a(currentTimeMillis);
        final com.kascend.chushou.view.b.d Sd = com.kascend.chushou.view.b.d.Sd(dNe.mCreatorAvatar);
        Sd.show(getChildFragmentManager(), "showUnSubscirbeDialog");
        Sd.a(new d.a() { // from class: com.kascend.chushou.player.d.3
            @Override // com.kascend.chushou.view.b.d.a
            public void a() {
                if (com.kascend.chushou.d.e.c(d.this.nwx, null)) {
                    com.kascend.chushou.c.c.dMl().a(new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.d.3.1
                        @Override // com.kascend.chushou.c.b
                        public void a() {
                        }

                        @Override // com.kascend.chushou.c.b
                        public void a(String str, JSONObject jSONObject) {
                            if (!d.this.aa()) {
                                tv.chushou.zues.utils.g.Mc(a.i.subscribe_success);
                                d.this.dNm();
                            }
                        }

                        @Override // com.kascend.chushou.c.b
                        public void a(int i, String str) {
                            if (!d.this.aa()) {
                                d.this.dNm();
                            }
                        }
                    }, d.this.nww.a, (String) null, "");
                }
            }

            @Override // com.kascend.chushou.view.b.d.a
            public void b() {
                Sd.dismissAllowingStateLoss();
                d.this.dNm();
            }
        });
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean f(View view, MotionEvent motionEvent) {
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
        if (this.nww == null) {
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean i() {
        FullRoomInfo dNb;
        RoomInfo roomInfo;
        return (this.nww == null || (dNb = this.nww.dNb()) == null || (roomInfo = dNb.mRoominfo) == null || tv.chushou.zues.utils.h.isEmpty(roomInfo.mGameId)) ? false : true;
    }

    @Override // com.kascend.chushou.player.e
    public void j() {
        if (this.nxj != null) {
            this.nxj.dZr();
        }
        a((PlayUrl) null);
        m(true);
    }

    @Override // com.kascend.chushou.player.e
    public void a(b bVar) {
        com.kascend.chushou.player.b.a dNJ = dNJ();
        if (dNJ != null) {
            dNJ.a(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ParserRet parserRet) {
        SparseArray sparseArray;
        RoomInfo dNe;
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
                    if (this.nwx instanceof VideoPlayer) {
                        ((VideoPlayer) this.nwx).dML().a(bangInfo);
                    }
                }
                if (sparseArray2.get(2) != null && (sparseArray2.get(2) instanceof ArrayList)) {
                    Iterator it = ((ArrayList) sparseArray2.get(2)).iterator();
                    while (it.hasNext()) {
                        com.kascend.chushou.player.ui.h5.c.a aVar = (com.kascend.chushou.player.ui.h5.c.a) it.next();
                        if (this.nwx instanceof VideoPlayer) {
                            ((VideoPlayer) this.nwx).c(aVar);
                        }
                    }
                }
                if (sparseArray2.get(3) != null && (sparseArray2.get(3) instanceof MicStatus) && this.nww != null && this.nww.dNb() != null) {
                    this.nww.dNb().mMicStatus = (MicStatus) sparseArray2.get(3);
                    if (this.nww.dNb().mMicStatus != null) {
                        if (this.nww.dNb().mMicStatus.onMic) {
                            if (sparseArray2.get(4) != null && (sparseArray2.get(4) instanceof ArrayList) && LoginManager.Instance().getUserInfo() != null && !tv.chushou.zues.utils.h.isEmpty(LoginManager.Instance().getUserInfo().mUserID)) {
                                Iterator it2 = ((ArrayList) sparseArray2.get(4)).iterator();
                                while (true) {
                                    if (!it2.hasNext()) {
                                        z = false;
                                        break;
                                    }
                                    FanItem fanItem = (FanItem) it2.next();
                                    if (fanItem != null && String.valueOf(LoginManager.Instance().getUserInfo().mUserID).equals(fanItem.mUserId) && !String.valueOf(LoginManager.Instance().getUserInfo().mUserID).equals(this.nww.dNb().mRoominfo.mCreatorUID)) {
                                        z = true;
                                        break;
                                    }
                                }
                                if (z) {
                                    this.J = 0.0f;
                                    if (this.nsS != null) {
                                        this.nsS.setVolume(this.J, this.J);
                                    }
                                } else if (this.npY) {
                                    this.J = 1.0f;
                                    if (this.nsS != null) {
                                        this.nsS.setVolume(this.J, this.J);
                                    }
                                }
                                this.npY = z;
                            }
                        } else if (this.nsS != null && this.npY) {
                            this.J = 1.0f;
                            this.nsS.setVolume(this.J, this.J);
                        }
                    }
                }
                if (sparseArray2.get(5) != null) {
                    String obj = sparseArray2.get(5).toString();
                    if ("10003".equals(obj)) {
                        ((VideoPlayer) this.nwx).t = "10003";
                        if (this.nsS != null && "1".equals(this.aw) && !"2".equals(this.ay) && this.nsS.getPlayState() != 4) {
                            j();
                            ((VideoPlayer) this.nwx).m();
                        }
                    } else if ("10004".equals(obj)) {
                        tv.chushou.zues.utils.e.d("Rancune", "officeLine");
                        if (this.nwx instanceof VideoPlayer) {
                            ((VideoPlayer) this.nwx).t = "10004";
                            dNC();
                        }
                    }
                }
                if (sparseArray2.get(6) != null) {
                    List<com.kascend.chushou.player.ui.h5.c.e> list = (List) sparseArray2.get(6);
                    if (!tv.chushou.zues.utils.h.isEmpty(list)) {
                        ((VideoPlayer) this.nwx).dMH().a(list);
                    }
                }
                if (sparseArray2.get(7) != null) {
                    ((VideoPlayer) this.nwx).dMI().a((List) sparseArray2.get(7));
                }
                if (sparseArray2.get(11) != null) {
                    ((VideoPlayer) this.nwx).dMJ().a((com.kascend.chushou.player.ui.h5.c.c) sparseArray2.get(11));
                }
                if (sparseArray2.get(12) != null) {
                    AutoBang autoBang = (AutoBang) sparseArray2.get(12);
                    if (this.nwx instanceof VideoPlayer) {
                        ((VideoPlayer) this.nwx).dML().a(autoBang);
                    }
                }
                if (sparseArray2.get(16) != null) {
                    com.kascend.chushou.player.ui.h5.c.b bVar = (com.kascend.chushou.player.ui.h5.c.b) sparseArray2.get(16);
                    if (this.nwx instanceof VideoPlayer) {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(bVar);
                        ((VideoPlayer) this.nwx).dMK().a(arrayList);
                    }
                }
                if (sparseArray2.get(19) != null && ((Boolean) sparseArray2.get(19)).booleanValue() && (this.nqc == null || tv.chushou.zues.utils.h.isEmpty(this.nqc.uid))) {
                    if (this.B != null) {
                        this.B.setVisibility(0);
                    }
                    if (this.nqd != null) {
                        this.nqd.dispose();
                        this.nqd = null;
                    }
                    this.nqd = io.reactivex.g.a(0L, 12L, 0L, 1L, TimeUnit.SECONDS).a(io.reactivex.a.b.a.dST()).a(new io.reactivex.c.g<Long>() { // from class: com.kascend.chushou.player.d.4
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
                    }, new io.reactivex.c.g<Throwable>() { // from class: com.kascend.chushou.player.d.5
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // io.reactivex.c.g
                        /* renamed from: a */
                        public void accept(Throwable th) throws Exception {
                        }
                    }, new io.reactivex.c.a() { // from class: com.kascend.chushou.player.d.6
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
                if (this.nww != null) {
                    this.nww.a(arrayList2);
                    if (((VideoPlayer) this.nwx).q) {
                        if (sparseArray != null) {
                            if (sparseArray.get(1) != null) {
                                this.nww.npu.a((ArrayList) sparseArray.get(1));
                                if (this.nwy != null && !this.nwy.LU(11)) {
                                    this.nwy.R(this.nwy.LV(11));
                                }
                            }
                            if (sparseArray.get(2) != null) {
                                this.nww.npu.b((ArrayList) sparseArray.get(2));
                                if (this.nwy != null && !this.nwy.LU(12)) {
                                    this.nwy.R(this.nwy.LV(12));
                                }
                            }
                        } else if (this.nww.npu != null) {
                            if (this.nww.npu.d() && this.nwy != null && !this.nwy.LU(11)) {
                                this.nwy.R(this.nwy.LV(11));
                            }
                            if (this.nww.npu.h() && this.nwy != null && !this.nwy.LU(12)) {
                                this.nwy.R(this.nwy.LV(12));
                            }
                        }
                    }
                }
                if (arrayList2 != null && arrayList2.size() != 0) {
                    boolean z2 = false;
                    if (this.nww != null) {
                        if (this.ap < 0) {
                            z2 = h.dMp().d;
                        } else {
                            z2 = h.dMp().e;
                        }
                    }
                    if (this.nxj != null && z2 && this.nxj.getVisibility() == 0) {
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
                                aVar2.oqZ.icon = next.mGift.icon;
                                if (next.mItem != null && !tv.chushou.zues.utils.h.isEmpty(next.mItem.mType) && this.nww != null && ((dNe = this.nww.dNe()) == null || !next.mItem.mType.equals("1") || !next.mItem.mTargetKey.equals(dNe.mRoomID))) {
                                    aVar2.tag = next.mItem;
                                }
                                this.nxj.a(aVar2);
                            }
                        }
                    }
                    if (dNJ() != null && (this.nwx instanceof VideoPlayer) && ((VideoPlayer) this.nwx).q) {
                        dNJ().a(arrayList2);
                    }
                }
            }
        }
    }

    @Override // com.kascend.chushou.player.e
    public void k() {
        if (this.nwx instanceof VideoPlayer) {
            if (((VideoPlayer) this.nwx).q) {
                dNw().setVisibility(0);
            } else {
                dNw().setVisibility(8);
            }
        }
    }

    @Override // com.kascend.chushou.player.e
    public void l() {
        dNw().setVisibility(8);
    }

    @Override // com.kascend.chushou.player.e
    public void m() {
        com.kascend.chushou.player.b.a dNJ = dNJ();
        if (dNJ != null) {
            dNJ.b();
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
        if (!this.k && this.npW != null) {
            try {
                if (this.nsS != null) {
                    i = this.nsS.getCurrentPos();
                    i2 = this.nsS.getDuration();
                } else {
                    i = 0;
                }
                if (i2 > 1000) {
                    this.npW.setProgress(i / (i2 / 1000));
                }
            } catch (NullPointerException e) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(boolean z, int i) {
        if (this.npX != null) {
            if (z) {
                this.npX.setStatusBarTintResource(i);
                this.npX.setTintResource(i);
                this.npX.setStatusBarTintEnabled(true);
                this.npX.setNavigationBarTintEnabled(true);
                return;
            }
            this.npX.setStatusBarTintEnabled(false);
            this.npX.setNavigationBarTintEnabled(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(String str) {
        if (this.nwx instanceof VideoPlayer) {
            str = ((VideoPlayer) this.nwx).a(str);
        }
        com.kascend.chushou.d.a.c(this.nwx, str);
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
            if (this.npZ != null && this.npZ.nsT != null && !tv.chushou.zues.utils.h.isEmpty(this.npZ.nsT.mPkRoomId)) {
                ListItem listItem = new ListItem();
                if (this.npZ.nsT.liveStyle == 0 || this.npZ.nsT.liveStyle == 1) {
                    listItem.mLiveType = "1";
                } else {
                    listItem.mLiveType = "2";
                }
                listItem.mType = "1";
                listItem.mTargetKey = this.npZ.nsT.mPkRoomId;
                com.kascend.chushou.d.e.a(this.nwx, listItem, (JSONObject) null);
            }
        } else if (id == a.f.tv_pk_name && this.npZ != null && this.npZ.nsT != null && !tv.chushou.zues.utils.h.isEmpty(this.npZ.nsT.mPkUid)) {
            com.kascend.chushou.d.a.a(this.nwx, (JSONObject) null, this.npZ.nsT.mPkRoomId, this.npZ.nsT.mPkUid, LoginManager.Instance().getUserInfo() != null ? String.valueOf(LoginManager.Instance().getUserInfo().mUserID) : "", false);
        }
    }

    @Override // com.kascend.chushou.player.e
    public boolean a(MotionEvent motionEvent) {
        if ((motionEvent.getAction() == 1 || motionEvent.getAction() == 3 || motionEvent.getAction() == 4) && this.k && this.nsS != null) {
            this.k = false;
            this.mNe = Math.min(this.nsS.getDuration(), Math.max(0, this.nsS.getCurrentPos() + this.j));
            if (this.nwy != null) {
                this.nwy.removeMessages(14);
                this.nwy.LT(14);
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
            return (this.E && c(true)) || dNn();
        }
        return false;
    }

    /* loaded from: classes6.dex */
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
        if (this.nww != null) {
            if (this.ap < 0) {
                z = h.dMp().d;
            } else {
                z = h.dMp().e;
            }
        }
        if (z && this.nxj != null && this.nxj.getVisibility() == 0) {
            if (((VideoPlayer) this.nwx).nnU == null || (colorPrivileges = ((VideoPlayer) this.nwx).nnU.mColorPrivileges) == null || tv.chushou.zues.utils.h.isEmpty(colorPrivileges.mColors)) {
                arrayList = null;
            } else {
                arrayList = tv.chushou.zues.toolkit.richtext.b.TQ(tv.chushou.zues.toolkit.richtext.b.a(str, colorPrivileges.mColors, colorPrivileges.mWholeColor, new Random().nextInt(colorPrivileges.mColors.size())));
            }
            this.nxj.h(str, arrayList);
        }
    }

    public void f(int i) {
        com.kascend.chushou.c.c.dMl().a(i, new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.d.7
            @Override // com.kascend.chushou.c.b
            public void a() {
            }

            @Override // com.kascend.chushou.c.b
            public void a(String str, JSONObject jSONObject) {
                if (!d.this.aa()) {
                    if (jSONObject != null) {
                        int optInt = jSONObject.optInt("data");
                        if (d.this.nww != null && d.this.nww.npH != null) {
                            d.this.nww.npH.count = optInt;
                            d.this.M();
                        }
                        tv.chushou.zues.utils.g.Mc(a.i.str_buy_trumpte_success);
                        return;
                    }
                    a(-1, "");
                }
            }

            @Override // com.kascend.chushou.c.b
            public void a(int i2, String str) {
                String str2;
                if (!d.this.aa()) {
                    if (i2 == 401) {
                        com.kascend.chushou.d.e.b(d.this.nwx, str);
                    } else if (i2 == 403) {
                        if (tv.chushou.zues.utils.h.isEmpty(str)) {
                            str = d.this.nwx.getString(a.i.str_blacklist);
                        }
                        tv.chushou.zues.utils.g.c(d.this.nwx, str);
                    } else if (i2 == 1027) {
                        if (!(d.this.nwx instanceof VideoPlayer)) {
                            str2 = null;
                        } else {
                            str2 = ((VideoPlayer) d.this.nwx).a((String) null);
                        }
                        com.kascend.chushou.d.e.a(d.this.getActivity(), str2);
                    } else if (tv.chushou.zues.utils.h.isEmpty(str)) {
                        tv.chushou.zues.utils.g.Mc(a.i.str_buy_trumpte_failuer);
                    } else {
                        tv.chushou.zues.utils.g.y(str);
                    }
                }
            }
        });
    }

    public void a(String str, String str2) {
        com.kascend.chushou.c.c.dMl().c(str, str2, new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.d.8
            @Override // com.kascend.chushou.c.b
            public void a() {
            }

            @Override // com.kascend.chushou.c.b
            public void a(String str3, JSONObject jSONObject) {
                if (!d.this.aa() && jSONObject != null) {
                    int optInt = jSONObject.optInt("data");
                    tv.chushou.zues.utils.g.Mc(a.i.str_send_success);
                    if (d.this.nww != null && d.this.nww.npH != null) {
                        d.this.nww.npH.count = optInt;
                        d.this.M();
                        return;
                    }
                    a(-1, "");
                }
            }

            @Override // com.kascend.chushou.c.b
            public void a(int i, String str3) {
                if (!d.this.aa()) {
                    if (i == 401) {
                        com.kascend.chushou.d.e.b(d.this.nwx, str3);
                    } else if (i == 403 && tv.chushou.zues.utils.h.isEmpty(str3)) {
                        str3 = d.this.nwx.getString(a.i.str_blacklist);
                    }
                    if (tv.chushou.zues.utils.h.isEmpty(str3)) {
                        tv.chushou.zues.utils.g.F(d.this.nwx, a.i.str_send_fail);
                    } else {
                        tv.chushou.zues.utils.g.c(d.this.nwx, str3);
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void t() {
        final int gJ = tv.chushou.zues.utils.systemBar.b.gJ(getActivity());
        this.nqe.setOnActionListener(new VoiceInteractionView.b() { // from class: com.kascend.chushou.player.d.9
            @Override // com.kascend.chushou.widget.VoiceInteractionView.b
            public void a() {
                ListItem listItem = new ListItem();
                listItem.mUrl = com.kascend.chushou.c.c.a(50);
                d.this.a(listItem);
            }

            @Override // com.kascend.chushou.widget.VoiceInteractionView.b
            public void b() {
                com.kascend.chushou.d.e.a(d.this.nwx, com.kascend.chushou.c.c.a(51) + "micRoomId=" + d.this.G);
            }

            @Override // com.kascend.chushou.widget.VoiceInteractionView.b
            public void a(int i, MicMemberInfo micMemberInfo, boolean z) {
                if (micMemberInfo != null) {
                    if (!z) {
                        com.kascend.chushou.d.a.a(d.this.nwx, (JSONObject) null, (String) null, micMemberInfo.uid, LoginManager.Instance().getUserInfo() != null ? String.valueOf(LoginManager.Instance().getUserInfo().mUserID) : "", false);
                        return;
                    }
                    micMemberInfo.micRoomId = d.this.G;
                    if (d.this.ap == 0) {
                        boolean z2 = d.this.nxb == null;
                        d.this.a(false, false, micMemberInfo);
                        if (z2 && gJ > 0 && d.this.nxb != null && tv.chushou.zues.utils.systemBar.b.ay(d.this.getActivity()) && tv.chushou.zues.utils.systemBar.b.az(d.this.getActivity())) {
                            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) d.this.nxb.getLayoutParams();
                            layoutParams.rightMargin += gJ;
                            d.this.nxb.setLayoutParams(layoutParams);
                            return;
                        }
                        return;
                    }
                    boolean z3 = d.this.nxb == null;
                    if (d.this.nwx.getResources().getDisplayMetrics().density < 2.0f) {
                        d.this.a(true, false, micMemberInfo);
                    } else {
                        d.this.a(true, true, micMemberInfo);
                    }
                    if (z3 && gJ > 0 && d.this.nxb != null) {
                        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) d.this.nxb.getLayoutParams();
                        layoutParams2.bottomMargin += gJ;
                        d.this.nxb.setLayoutParams(layoutParams2);
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
    public void g(ArrayList<MicMemberInfo> arrayList, String str) {
        boolean z;
        if (this.nww.dNb().mMicStatus.onMic != this.E) {
            this.E = this.nww.dNb().mMicStatus.onMic;
            u();
        }
        this.E = this.nww.dNb().mMicStatus.onMic;
        if (this.E) {
            if (this.nww.dNb().mMicStatus != null && !tv.chushou.zues.utils.h.isEmpty(this.nww.dNb().mMicStatus.micRoomId) && !this.nww.dNb().mMicStatus.micRoomId.equals("0")) {
                this.G = this.nww.dNb().mMicStatus.micRoomId;
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
            if (this.nqe != null) {
                b(true);
                this.nqe.setupCount(this.nww.dNb().mMicStatus.capacity - 1);
                this.nqe.a(this.nww.dNb().mMicStatus.isOngoing == 1, z, this.nww.dNb().mMicStatus.displayInteraction == 1);
                this.nqe.a(arrayList);
                return;
            }
            return;
        }
        this.F = false;
        b(false);
    }

    public void a(String str, String str2, EditText editText) {
        if (!tv.chushou.zues.utils.h.isEmpty(str2) && editText != null) {
            String str3 = UgcConstant.AT_RULE_TAG + str2 + " ";
            tv.chushou.zues.widget.a.c cVar = new tv.chushou.zues.widget.a.c();
            cVar.a(str3, new DanmuAtSpan(0, str3.length()));
            editText.setText(cVar);
            editText.setSelection(cVar.length());
        }
    }

    public boolean n(EditText editText) {
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

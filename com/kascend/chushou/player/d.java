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
    protected a npR;
    protected com.kascend.chushou.widget.a.b npT;
    protected tv.chushou.zues.utils.systemBar.a npV;
    protected com.kascend.chushou.player.e.a npX;
    protected com.kascend.chushou.player.e.b npY;
    protected RelativeLayout npZ;
    protected VoiceInteractionView nqc;
    protected String u;
    protected TextView y;
    protected TextView z;
    protected ImageButton a = null;
    protected String b = null;
    private boolean npS = false;
    protected boolean e = true;
    protected boolean f = false;
    protected TextView h = null;
    protected TextView i = null;
    protected int j = 0;
    protected boolean k = false;
    protected ProgressBar npU = null;
    protected long m = 0;
    protected int n = 0;
    protected boolean p = false;
    private boolean npW = false;
    protected boolean v = false;
    protected int w = -1;
    protected CycleLiveRoomInfo nqa = null;
    protected io.reactivex.disposables.b nqb = null;
    protected boolean E = false;
    protected boolean F = false;
    private long nqd = 0;

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.nwv = getActivity();
        if (aa()) {
            tv.chushou.zues.utils.e.e("VideoPlayerBaseFragment", "killed in backgroud");
            return;
        }
        Point gE = tv.chushou.zues.utils.a.gE(this.nwv);
        q = Math.min(gE.x, gE.y) / 5;
        r = 200;
        this.nwx = (AudioManager) this.nwv.getApplicationContext().getSystemService("audio");
        this.nqd = System.currentTimeMillis();
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
        dNk();
        ((VideoPlayer) this.nwv).m = false;
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.ah = true;
        R();
        if (this.N != null && this.nsQ != null) {
            this.N.setVisibility(8);
        }
        if (this.nww != null) {
            this.nww.removeMessages(15);
        }
        a(false, false);
        if (this.nww != null) {
            this.nww.removeMessages(1);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // com.kascend.chushou.player.f, android.support.v4.app.Fragment
    public void onDestroy() {
        this.nwf.dispose();
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view) {
        this.nwh = (RelativeLayout) view.findViewById(a.f.rl_audio);
        this.nwi = (FrescoThumbnailView) view.findViewById(a.f.iv_audio_bg);
        this.Q = (ImageView) view.findViewById(a.f.iv_audio_avator_bg);
        this.nwj = (FrescoThumbnailView) view.findViewById(a.f.iv_audio_avator);
        this.bDz = (TextView) view.findViewById(a.f.tv_audio_playing);
        this.nwk = (TextView) view.findViewById(a.f.tv_open_video);
        this.nwk.setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b() {
        this.nwq = (ProgressBar) this.nwg.findViewById(a.f.LoadingProgressBar);
        this.nwr = (TextView) this.nwg.findViewById(a.f.LoadingPercent);
        this.nws = (TextView) this.nwg.findViewById(a.f.LoadingBuffer);
        this.nwt = (TextView) this.nwg.findViewById(a.f.tv_change_lines);
        this.nwq.setVisibility(8);
        this.nwr.setVisibility(8);
        this.nws.setVisibility(8);
        this.nwt.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c() {
        this.npZ = (RelativeLayout) this.nwg.findViewById(a.f.rl_pk_name);
        this.y = (TextView) this.nwg.findViewById(a.f.tv_pk_name);
        this.z = (TextView) this.nwg.findViewById(a.f.tv_pk_subscribe);
        this.z.setOnClickListener(this);
        this.y.setOnClickListener(this);
        this.B = (TextView) this.nwg.findViewById(a.f.iv_cyclelive_countdown);
    }

    private void dNk() {
        if (i() || h()) {
            if (this.N != null) {
                this.N.setVisibility(0);
            }
            this.nsQ = ((VideoPlayer) this.nwv).dMx();
            if (this.nsQ != null) {
                Uri uri = this.nsQ.getUri();
                Uri dMD = ((VideoPlayer) this.nwv).dMD();
                if (!this.nwy) {
                    if (dMD != null && uri != null && !uri.equals(dMD)) {
                        ((VideoPlayer) this.nwv).a(true, (Uri) null, false);
                    } else if (h.dMo().a) {
                        ((VideoPlayer) this.nwv).a(true, (Uri) null, false);
                    } else if (((VideoPlayer) this.nwv).m) {
                        if (h() && this.nwu.d()) {
                            if (!this.ai) {
                                ((VideoPlayer) this.nwv).a(true, (Uri) null, false);
                                return;
                            }
                            return;
                        }
                        ((VideoPlayer) this.nwv).a(true, (Uri) null, false);
                    } else {
                        AudioManager audioManager = ((VideoPlayer) this.nwv).nnW;
                        VideoPlayer videoPlayer = (VideoPlayer) this.nwv;
                        audioManager.setStreamVolume(3, VideoPlayer.n, 0);
                        if (this.nwu.d()) {
                            if (!this.ai) {
                                if (this.ap < 0) {
                                    if (this.nwu.d) {
                                        T();
                                        if (this.nwn != null) {
                                            this.nwn.setImageResource(a.e.ic_btn_room_video_n);
                                        }
                                    } else {
                                        U();
                                        S();
                                        if (this.nwm != null) {
                                            this.nwm.setVisibility(0);
                                        }
                                        if (this.nwn != null) {
                                            this.nwn.setImageResource(a.e.ic_btn_room_audio_n);
                                        }
                                    }
                                }
                                n(true);
                            }
                        } else if (!this.H && !this.al) {
                            ((VideoPlayer) this.nwv).a(true, (Uri) null, false);
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d() {
        FullRoomInfo dNa;
        tv.chushou.zues.utils.e.e("VideoPlayerBaseFragment", "release <----------");
        if (this.B != null) {
            this.B.setVisibility(8);
        }
        if (this.nqb != null) {
            this.nqb.dispose();
            this.nqb = null;
        }
        if (this.nwu != null && (dNa = this.nwu.dNa()) != null && !tv.chushou.zues.utils.h.isEmpty(dNa.mGeneralTabGifts)) {
            for (int i = 0; i < dNa.mGeneralTabGifts.size(); i++) {
                GeneralTabGift generalTabGift = dNa.mGeneralTabGifts.get(i);
                if (generalTabGift != null && !tv.chushou.zues.utils.h.isEmpty(generalTabGift.mGeneralGifts)) {
                    for (int i2 = 0; i2 < generalTabGift.mGeneralGifts.size(); i2++) {
                        if (generalTabGift.mGeneralGifts.get(i2) != null) {
                            generalTabGift.mGeneralGifts.get(i2).mSelectFlag = false;
                        }
                    }
                }
            }
        }
        if (this.nwS != null) {
            this.nwS.clear();
            this.nwS = null;
        }
        if (this.npV != null) {
            this.npV.setStatusBarTintEnabled(false);
            this.npV.setNavigationBarTintEnabled(false);
        }
        if (this.nxh != null) {
            this.nxh.unInit();
            this.nxh = null;
            dNZ().removeAllViews();
        }
        if (this.nwV != null) {
            ((ViewGroup) this.nwg).removeView(this.nwV);
            this.nwV = null;
        }
        if (this.nxi != null) {
            this.nxi.cancel();
            ArrayList<Animator> childAnimations = this.nxi.getChildAnimations();
            if (!tv.chushou.zues.utils.h.isEmpty(childAnimations)) {
                Iterator<Animator> it = childAnimations.iterator();
                while (it.hasNext()) {
                    it.next().removeAllListeners();
                }
            }
            this.nxi.removeAllListeners();
            this.nxi = null;
        }
        this.nwX = null;
        if (this.N != null) {
            ((ViewGroup) this.nwg).removeView(this.N);
            this.N = null;
        }
        if (this.nxd != null) {
            this.nxd.a();
            this.nxd = null;
        }
        if (this.nxn != null) {
            this.nxn.dismiss();
        }
        if (this.nxm != null) {
            this.nxm.dismiss();
        }
        this.a = null;
        this.nwg = null;
        this.nwx = null;
        tv.chushou.zues.utils.e.i("VideoPlayerBaseFragment", "release ---------->");
    }

    @Override // com.kascend.chushou.player.e
    public void e() {
        this.H = false;
        this.nwy = false;
        m(true);
        x();
    }

    public void a(PrivilegeInfo privilegeInfo) {
        ((VideoPlayer) this.nwv).nnS = privilegeInfo;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(String str) {
        ColorPrivileges colorPrivileges;
        ArrayList<RichText> arrayList = null;
        if (this.nwu != null && !tv.chushou.zues.utils.h.isEmpty(this.nwu.a) && this.nsQ != null) {
            com.kascend.chushou.c.c.dMk().a(new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.d.1
                @Override // com.kascend.chushou.c.b
                public void a() {
                }

                @Override // com.kascend.chushou.c.b
                public void a(String str2, JSONObject jSONObject) {
                    if (jSONObject != null) {
                        int optInt = jSONObject.optInt("code", -1);
                        String optString = jSONObject.optString("message");
                        if (optInt == 0) {
                            tv.chushou.zues.utils.g.F(d.this.nwv, a.i.str_send_success);
                        } else {
                            a(optInt, optString);
                        }
                    }
                }

                @Override // com.kascend.chushou.c.b
                public void a(int i, String str2) {
                    if (!tv.chushou.zues.utils.h.isEmpty(str2)) {
                        tv.chushou.zues.utils.g.c(d.this.nwv, str2);
                    } else {
                        tv.chushou.zues.utils.g.F(d.this.nwv, a.i.str_send_fail);
                    }
                }
            }, this.nwu.a, str, (String) null, this.nsQ.getCurrentPos());
            if (this.nxh != null && this.nxh.getVisibility() == 0) {
                if (((VideoPlayer) this.nwv).nnS != null && (colorPrivileges = ((VideoPlayer) this.nwv).nnS.mColorPrivileges) != null && !tv.chushou.zues.utils.h.isEmpty(colorPrivileges.mColors)) {
                    arrayList = tv.chushou.zues.toolkit.richtext.b.TQ(tv.chushou.zues.toolkit.richtext.b.a(str, colorPrivileges.mColors, colorPrivileges.mWholeColor, new Random().nextInt(colorPrivileges.mColors.size())));
                }
                this.nxh.h(str, arrayList);
            }
        }
    }

    public void a(String str, String str2, String str3, String str4) {
        ArrayList<RichText> arrayList;
        ColorPrivileges colorPrivileges;
        com.kascend.chushou.c.c.dMk().a(new JsonCallbackWrapper() { // from class: com.kascend.chushou.player.d.2
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
                        com.kascend.chushou.d.e.b(d.this.nwv, str5);
                    } else if (i == 403) {
                        if (tv.chushou.zues.utils.h.isEmpty(str5)) {
                            str5 = d.this.nwv.getString(a.i.str_blacklist);
                        }
                        tv.chushou.zues.utils.g.c(d.this.nwv, str5);
                    } else if (i == 21001 && !tv.chushou.zues.utils.h.isEmpty(str6)) {
                        try {
                            ParserRet dW = com.kascend.chushou.c.e.dW(new JSONObject(str6));
                            if ((dW.mData1 instanceof String) && !TextUtils.isEmpty((String) dW.mData1)) {
                                ListItem listItem = new ListItem();
                                listItem.mType = "99";
                                listItem.mUrl = (String) dW.mData1;
                                com.kascend.chushou.d.e.a(d.this.nwv, listItem, (JSONObject) null);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }, str, str3, str2, str4);
        boolean z = false;
        if (this.nwu != null) {
            if (this.ap < 0) {
                z = h.dMo().d;
            } else {
                z = h.dMo().e;
            }
        }
        if (z && this.nxh != null && this.nxh.getVisibility() == 0) {
            if (((VideoPlayer) this.nwv).nnS == null || (colorPrivileges = ((VideoPlayer) this.nwv).nnS.mColorPrivileges) == null || tv.chushou.zues.utils.h.isEmpty(colorPrivileges.mColors)) {
                arrayList = null;
            } else {
                arrayList = tv.chushou.zues.toolkit.richtext.b.TQ(tv.chushou.zues.toolkit.richtext.b.a(str2, colorPrivileges.mColors, colorPrivileges.mWholeColor, new Random().nextInt(colorPrivileges.mColors.size())));
            }
            this.nxh.h(str2, arrayList);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void f() {
        if (this.nxh != null) {
            this.nxh.Ty(h.dMo().b());
        }
    }

    public void a(PlayUrl playUrl) {
        if (playUrl == null || playUrl.mSelectedUrl.length() == 0) {
            if (this.nwM != null) {
                this.nwM.dismiss();
                this.nwM = null;
            }
        } else if (this.nwM != null) {
            LinearLayout linearLayout = (LinearLayout) this.nwM.getContentView().findViewById(a.f.ll_pop_root);
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
        if (!c(true) && !dNm()) {
            dNl();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dNl() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    private boolean dNm() {
        RoomInfo dNd;
        if (this.nwu == null || (dNd = this.nwu.dNd()) == null || dNd.mIsSubscribed || aa()) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long dMt = h.dMo().dMt();
        if (currentTimeMillis - this.nqd <= 60000 || currentTimeMillis - dMt <= 86400000) {
            return false;
        }
        h.dMo().a(currentTimeMillis);
        final com.kascend.chushou.view.b.d Sd = com.kascend.chushou.view.b.d.Sd(dNd.mCreatorAvatar);
        Sd.show(getChildFragmentManager(), "showUnSubscirbeDialog");
        Sd.a(new d.a() { // from class: com.kascend.chushou.player.d.3
            @Override // com.kascend.chushou.view.b.d.a
            public void a() {
                if (com.kascend.chushou.d.e.c(d.this.nwv, null)) {
                    com.kascend.chushou.c.c.dMk().a(new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.d.3.1
                        @Override // com.kascend.chushou.c.b
                        public void a() {
                        }

                        @Override // com.kascend.chushou.c.b
                        public void a(String str, JSONObject jSONObject) {
                            if (!d.this.aa()) {
                                tv.chushou.zues.utils.g.Mc(a.i.subscribe_success);
                                d.this.dNl();
                            }
                        }

                        @Override // com.kascend.chushou.c.b
                        public void a(int i, String str) {
                            if (!d.this.aa()) {
                                d.this.dNl();
                            }
                        }
                    }, d.this.nwu.a, (String) null, "");
                }
            }

            @Override // com.kascend.chushou.view.b.d.a
            public void b() {
                Sd.dismissAllowingStateLoss();
                d.this.dNl();
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
        if (this.nwu == null) {
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean i() {
        FullRoomInfo dNa;
        RoomInfo roomInfo;
        return (this.nwu == null || (dNa = this.nwu.dNa()) == null || (roomInfo = dNa.mRoominfo) == null || tv.chushou.zues.utils.h.isEmpty(roomInfo.mGameId)) ? false : true;
    }

    @Override // com.kascend.chushou.player.e
    public void j() {
        if (this.nxh != null) {
            this.nxh.dZq();
        }
        a((PlayUrl) null);
        m(true);
    }

    @Override // com.kascend.chushou.player.e
    public void a(b bVar) {
        com.kascend.chushou.player.b.a dNI = dNI();
        if (dNI != null) {
            dNI.a(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ParserRet parserRet) {
        SparseArray sparseArray;
        RoomInfo dNd;
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
                    if (this.nwv instanceof VideoPlayer) {
                        ((VideoPlayer) this.nwv).dMK().a(bangInfo);
                    }
                }
                if (sparseArray2.get(2) != null && (sparseArray2.get(2) instanceof ArrayList)) {
                    Iterator it = ((ArrayList) sparseArray2.get(2)).iterator();
                    while (it.hasNext()) {
                        com.kascend.chushou.player.ui.h5.c.a aVar = (com.kascend.chushou.player.ui.h5.c.a) it.next();
                        if (this.nwv instanceof VideoPlayer) {
                            ((VideoPlayer) this.nwv).c(aVar);
                        }
                    }
                }
                if (sparseArray2.get(3) != null && (sparseArray2.get(3) instanceof MicStatus) && this.nwu != null && this.nwu.dNa() != null) {
                    this.nwu.dNa().mMicStatus = (MicStatus) sparseArray2.get(3);
                    if (this.nwu.dNa().mMicStatus != null) {
                        if (this.nwu.dNa().mMicStatus.onMic) {
                            if (sparseArray2.get(4) != null && (sparseArray2.get(4) instanceof ArrayList) && LoginManager.Instance().getUserInfo() != null && !tv.chushou.zues.utils.h.isEmpty(LoginManager.Instance().getUserInfo().mUserID)) {
                                Iterator it2 = ((ArrayList) sparseArray2.get(4)).iterator();
                                while (true) {
                                    if (!it2.hasNext()) {
                                        z = false;
                                        break;
                                    }
                                    FanItem fanItem = (FanItem) it2.next();
                                    if (fanItem != null && String.valueOf(LoginManager.Instance().getUserInfo().mUserID).equals(fanItem.mUserId) && !String.valueOf(LoginManager.Instance().getUserInfo().mUserID).equals(this.nwu.dNa().mRoominfo.mCreatorUID)) {
                                        z = true;
                                        break;
                                    }
                                }
                                if (z) {
                                    this.J = 0.0f;
                                    if (this.nsQ != null) {
                                        this.nsQ.setVolume(this.J, this.J);
                                    }
                                } else if (this.npW) {
                                    this.J = 1.0f;
                                    if (this.nsQ != null) {
                                        this.nsQ.setVolume(this.J, this.J);
                                    }
                                }
                                this.npW = z;
                            }
                        } else if (this.nsQ != null && this.npW) {
                            this.J = 1.0f;
                            this.nsQ.setVolume(this.J, this.J);
                        }
                    }
                }
                if (sparseArray2.get(5) != null) {
                    String obj = sparseArray2.get(5).toString();
                    if ("10003".equals(obj)) {
                        ((VideoPlayer) this.nwv).t = "10003";
                        if (this.nsQ != null && "1".equals(this.aw) && !"2".equals(this.ay) && this.nsQ.getPlayState() != 4) {
                            j();
                            ((VideoPlayer) this.nwv).m();
                        }
                    } else if ("10004".equals(obj)) {
                        tv.chushou.zues.utils.e.d("Rancune", "officeLine");
                        if (this.nwv instanceof VideoPlayer) {
                            ((VideoPlayer) this.nwv).t = "10004";
                            dNB();
                        }
                    }
                }
                if (sparseArray2.get(6) != null) {
                    List<com.kascend.chushou.player.ui.h5.c.e> list = (List) sparseArray2.get(6);
                    if (!tv.chushou.zues.utils.h.isEmpty(list)) {
                        ((VideoPlayer) this.nwv).dMG().a(list);
                    }
                }
                if (sparseArray2.get(7) != null) {
                    ((VideoPlayer) this.nwv).dMH().a((List) sparseArray2.get(7));
                }
                if (sparseArray2.get(11) != null) {
                    ((VideoPlayer) this.nwv).dMI().a((com.kascend.chushou.player.ui.h5.c.c) sparseArray2.get(11));
                }
                if (sparseArray2.get(12) != null) {
                    AutoBang autoBang = (AutoBang) sparseArray2.get(12);
                    if (this.nwv instanceof VideoPlayer) {
                        ((VideoPlayer) this.nwv).dMK().a(autoBang);
                    }
                }
                if (sparseArray2.get(16) != null) {
                    com.kascend.chushou.player.ui.h5.c.b bVar = (com.kascend.chushou.player.ui.h5.c.b) sparseArray2.get(16);
                    if (this.nwv instanceof VideoPlayer) {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(bVar);
                        ((VideoPlayer) this.nwv).dMJ().a(arrayList);
                    }
                }
                if (sparseArray2.get(19) != null && ((Boolean) sparseArray2.get(19)).booleanValue() && (this.nqa == null || tv.chushou.zues.utils.h.isEmpty(this.nqa.uid))) {
                    if (this.B != null) {
                        this.B.setVisibility(0);
                    }
                    if (this.nqb != null) {
                        this.nqb.dispose();
                        this.nqb = null;
                    }
                    this.nqb = io.reactivex.g.a(0L, 12L, 0L, 1L, TimeUnit.SECONDS).a(io.reactivex.a.b.a.dSS()).a(new io.reactivex.c.g<Long>() { // from class: com.kascend.chushou.player.d.4
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
                if (this.nwu != null) {
                    this.nwu.a(arrayList2);
                    if (((VideoPlayer) this.nwv).q) {
                        if (sparseArray != null) {
                            if (sparseArray.get(1) != null) {
                                this.nwu.nps.a((ArrayList) sparseArray.get(1));
                                if (this.nww != null && !this.nww.LU(11)) {
                                    this.nww.R(this.nww.LV(11));
                                }
                            }
                            if (sparseArray.get(2) != null) {
                                this.nwu.nps.b((ArrayList) sparseArray.get(2));
                                if (this.nww != null && !this.nww.LU(12)) {
                                    this.nww.R(this.nww.LV(12));
                                }
                            }
                        } else if (this.nwu.nps != null) {
                            if (this.nwu.nps.d() && this.nww != null && !this.nww.LU(11)) {
                                this.nww.R(this.nww.LV(11));
                            }
                            if (this.nwu.nps.h() && this.nww != null && !this.nww.LU(12)) {
                                this.nww.R(this.nww.LV(12));
                            }
                        }
                    }
                }
                if (arrayList2 != null && arrayList2.size() != 0) {
                    boolean z2 = false;
                    if (this.nwu != null) {
                        if (this.ap < 0) {
                            z2 = h.dMo().d;
                        } else {
                            z2 = h.dMo().e;
                        }
                    }
                    if (this.nxh != null && z2 && this.nxh.getVisibility() == 0) {
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
                                aVar2.oqX.icon = next.mGift.icon;
                                if (next.mItem != null && !tv.chushou.zues.utils.h.isEmpty(next.mItem.mType) && this.nwu != null && ((dNd = this.nwu.dNd()) == null || !next.mItem.mType.equals("1") || !next.mItem.mTargetKey.equals(dNd.mRoomID))) {
                                    aVar2.tag = next.mItem;
                                }
                                this.nxh.a(aVar2);
                            }
                        }
                    }
                    if (dNI() != null && (this.nwv instanceof VideoPlayer) && ((VideoPlayer) this.nwv).q) {
                        dNI().a(arrayList2);
                    }
                }
            }
        }
    }

    @Override // com.kascend.chushou.player.e
    public void k() {
        if (this.nwv instanceof VideoPlayer) {
            if (((VideoPlayer) this.nwv).q) {
                dNv().setVisibility(0);
            } else {
                dNv().setVisibility(8);
            }
        }
    }

    @Override // com.kascend.chushou.player.e
    public void l() {
        dNv().setVisibility(8);
    }

    @Override // com.kascend.chushou.player.e
    public void m() {
        com.kascend.chushou.player.b.a dNI = dNI();
        if (dNI != null) {
            dNI.b();
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
        if (!this.k && this.npU != null) {
            try {
                if (this.nsQ != null) {
                    i = this.nsQ.getCurrentPos();
                    i2 = this.nsQ.getDuration();
                } else {
                    i = 0;
                }
                if (i2 > 1000) {
                    this.npU.setProgress(i / (i2 / 1000));
                }
            } catch (NullPointerException e) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(boolean z, int i) {
        if (this.npV != null) {
            if (z) {
                this.npV.setStatusBarTintResource(i);
                this.npV.setTintResource(i);
                this.npV.setStatusBarTintEnabled(true);
                this.npV.setNavigationBarTintEnabled(true);
                return;
            }
            this.npV.setStatusBarTintEnabled(false);
            this.npV.setNavigationBarTintEnabled(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(String str) {
        if (this.nwv instanceof VideoPlayer) {
            str = ((VideoPlayer) this.nwv).a(str);
        }
        com.kascend.chushou.d.a.c(this.nwv, str);
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
            if (this.npX != null && this.npX.nsR != null && !tv.chushou.zues.utils.h.isEmpty(this.npX.nsR.mPkRoomId)) {
                ListItem listItem = new ListItem();
                if (this.npX.nsR.liveStyle == 0 || this.npX.nsR.liveStyle == 1) {
                    listItem.mLiveType = "1";
                } else {
                    listItem.mLiveType = "2";
                }
                listItem.mType = "1";
                listItem.mTargetKey = this.npX.nsR.mPkRoomId;
                com.kascend.chushou.d.e.a(this.nwv, listItem, (JSONObject) null);
            }
        } else if (id == a.f.tv_pk_name && this.npX != null && this.npX.nsR != null && !tv.chushou.zues.utils.h.isEmpty(this.npX.nsR.mPkUid)) {
            com.kascend.chushou.d.a.a(this.nwv, (JSONObject) null, this.npX.nsR.mPkRoomId, this.npX.nsR.mPkUid, LoginManager.Instance().getUserInfo() != null ? String.valueOf(LoginManager.Instance().getUserInfo().mUserID) : "", false);
        }
    }

    @Override // com.kascend.chushou.player.e
    public boolean a(MotionEvent motionEvent) {
        if ((motionEvent.getAction() == 1 || motionEvent.getAction() == 3 || motionEvent.getAction() == 4) && this.k && this.nsQ != null) {
            this.k = false;
            this.mNc = Math.min(this.nsQ.getDuration(), Math.max(0, this.nsQ.getCurrentPos() + this.j));
            if (this.nww != null) {
                this.nww.removeMessages(14);
                this.nww.LT(14);
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
            return (this.E && c(true)) || dNm();
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
        if (this.nwu != null) {
            if (this.ap < 0) {
                z = h.dMo().d;
            } else {
                z = h.dMo().e;
            }
        }
        if (z && this.nxh != null && this.nxh.getVisibility() == 0) {
            if (((VideoPlayer) this.nwv).nnS == null || (colorPrivileges = ((VideoPlayer) this.nwv).nnS.mColorPrivileges) == null || tv.chushou.zues.utils.h.isEmpty(colorPrivileges.mColors)) {
                arrayList = null;
            } else {
                arrayList = tv.chushou.zues.toolkit.richtext.b.TQ(tv.chushou.zues.toolkit.richtext.b.a(str, colorPrivileges.mColors, colorPrivileges.mWholeColor, new Random().nextInt(colorPrivileges.mColors.size())));
            }
            this.nxh.h(str, arrayList);
        }
    }

    public void f(int i) {
        com.kascend.chushou.c.c.dMk().a(i, new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.d.7
            @Override // com.kascend.chushou.c.b
            public void a() {
            }

            @Override // com.kascend.chushou.c.b
            public void a(String str, JSONObject jSONObject) {
                if (!d.this.aa()) {
                    if (jSONObject != null) {
                        int optInt = jSONObject.optInt("data");
                        if (d.this.nwu != null && d.this.nwu.npF != null) {
                            d.this.nwu.npF.count = optInt;
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
                        com.kascend.chushou.d.e.b(d.this.nwv, str);
                    } else if (i2 == 403) {
                        if (tv.chushou.zues.utils.h.isEmpty(str)) {
                            str = d.this.nwv.getString(a.i.str_blacklist);
                        }
                        tv.chushou.zues.utils.g.c(d.this.nwv, str);
                    } else if (i2 == 1027) {
                        if (!(d.this.nwv instanceof VideoPlayer)) {
                            str2 = null;
                        } else {
                            str2 = ((VideoPlayer) d.this.nwv).a((String) null);
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
        com.kascend.chushou.c.c.dMk().c(str, str2, new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.d.8
            @Override // com.kascend.chushou.c.b
            public void a() {
            }

            @Override // com.kascend.chushou.c.b
            public void a(String str3, JSONObject jSONObject) {
                if (!d.this.aa() && jSONObject != null) {
                    int optInt = jSONObject.optInt("data");
                    tv.chushou.zues.utils.g.Mc(a.i.str_send_success);
                    if (d.this.nwu != null && d.this.nwu.npF != null) {
                        d.this.nwu.npF.count = optInt;
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
                        com.kascend.chushou.d.e.b(d.this.nwv, str3);
                    } else if (i == 403 && tv.chushou.zues.utils.h.isEmpty(str3)) {
                        str3 = d.this.nwv.getString(a.i.str_blacklist);
                    }
                    if (tv.chushou.zues.utils.h.isEmpty(str3)) {
                        tv.chushou.zues.utils.g.F(d.this.nwv, a.i.str_send_fail);
                    } else {
                        tv.chushou.zues.utils.g.c(d.this.nwv, str3);
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void t() {
        final int gJ = tv.chushou.zues.utils.systemBar.b.gJ(getActivity());
        this.nqc.setOnActionListener(new VoiceInteractionView.b() { // from class: com.kascend.chushou.player.d.9
            @Override // com.kascend.chushou.widget.VoiceInteractionView.b
            public void a() {
                ListItem listItem = new ListItem();
                listItem.mUrl = com.kascend.chushou.c.c.a(50);
                d.this.a(listItem);
            }

            @Override // com.kascend.chushou.widget.VoiceInteractionView.b
            public void b() {
                com.kascend.chushou.d.e.a(d.this.nwv, com.kascend.chushou.c.c.a(51) + "micRoomId=" + d.this.G);
            }

            @Override // com.kascend.chushou.widget.VoiceInteractionView.b
            public void a(int i, MicMemberInfo micMemberInfo, boolean z) {
                if (micMemberInfo != null) {
                    if (!z) {
                        com.kascend.chushou.d.a.a(d.this.nwv, (JSONObject) null, (String) null, micMemberInfo.uid, LoginManager.Instance().getUserInfo() != null ? String.valueOf(LoginManager.Instance().getUserInfo().mUserID) : "", false);
                        return;
                    }
                    micMemberInfo.micRoomId = d.this.G;
                    if (d.this.ap == 0) {
                        boolean z2 = d.this.nwZ == null;
                        d.this.a(false, false, micMemberInfo);
                        if (z2 && gJ > 0 && d.this.nwZ != null && tv.chushou.zues.utils.systemBar.b.ay(d.this.getActivity()) && tv.chushou.zues.utils.systemBar.b.az(d.this.getActivity())) {
                            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) d.this.nwZ.getLayoutParams();
                            layoutParams.rightMargin += gJ;
                            d.this.nwZ.setLayoutParams(layoutParams);
                            return;
                        }
                        return;
                    }
                    boolean z3 = d.this.nwZ == null;
                    if (d.this.nwv.getResources().getDisplayMetrics().density < 2.0f) {
                        d.this.a(true, false, micMemberInfo);
                    } else {
                        d.this.a(true, true, micMemberInfo);
                    }
                    if (z3 && gJ > 0 && d.this.nwZ != null) {
                        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) d.this.nwZ.getLayoutParams();
                        layoutParams2.bottomMargin += gJ;
                        d.this.nwZ.setLayoutParams(layoutParams2);
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
        if (this.nwu.dNa().mMicStatus.onMic != this.E) {
            this.E = this.nwu.dNa().mMicStatus.onMic;
            u();
        }
        this.E = this.nwu.dNa().mMicStatus.onMic;
        if (this.E) {
            if (this.nwu.dNa().mMicStatus != null && !tv.chushou.zues.utils.h.isEmpty(this.nwu.dNa().mMicStatus.micRoomId) && !this.nwu.dNa().mMicStatus.micRoomId.equals("0")) {
                this.G = this.nwu.dNa().mMicStatus.micRoomId;
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
            if (this.nqc != null) {
                b(true);
                this.nqc.setupCount(this.nwu.dNa().mMicStatus.capacity - 1);
                this.nqc.a(this.nwu.dNa().mMicStatus.isOngoing == 1, z, this.nwu.dNa().mMicStatus.displayInteraction == 1);
                this.nqc.a(arrayList);
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

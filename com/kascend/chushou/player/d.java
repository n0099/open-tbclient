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
/* loaded from: classes5.dex */
public abstract class d extends g implements View.OnClickListener, b.a {
    protected static int q;
    protected static int r;
    protected TextView B;
    protected String G;
    protected GestureDetector c;
    protected a mJT;
    protected com.kascend.chushou.widget.a.b mJV;
    protected tv.chushou.zues.utils.systemBar.a mJX;
    protected com.kascend.chushou.player.e.a mJZ;
    protected com.kascend.chushou.player.e.b mKa;
    protected RelativeLayout mKb;
    protected VoiceInteractionView mKe;
    protected String u;
    protected TextView y;
    protected TextView z;
    protected ImageButton a = null;
    protected String b = null;
    private boolean mJU = false;
    protected boolean e = true;
    protected boolean f = false;
    protected TextView h = null;
    protected TextView i = null;
    protected int j = 0;
    protected boolean k = false;
    protected ProgressBar mJW = null;
    protected long m = 0;
    protected int n = 0;
    protected boolean p = false;
    private boolean mJY = false;
    protected boolean v = false;
    protected int w = -1;
    protected CycleLiveRoomInfo mKc = null;
    protected io.reactivex.disposables.b mKd = null;
    protected boolean E = false;
    protected boolean F = false;
    private long mKf = 0;

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mQy = getActivity();
        if (dFE()) {
            tv.chushou.zues.utils.e.e("VideoPlayerBaseFragment", "killed in backgroud");
            return;
        }
        Point gv = tv.chushou.zues.utils.a.gv(this.mQy);
        q = Math.min(gv.x, gv.y) / 5;
        r = 200;
        this.mQA = (AudioManager) this.mQy.getApplicationContext().getSystemService("audio");
        this.mKf = System.currentTimeMillis();
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
        dEV();
        ((VideoPlayer) this.mQy).m = false;
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.ah = true;
        R();
        if (this.N != null && this.mMN != null) {
            this.N.setVisibility(8);
        }
        if (this.mQz != null) {
            this.mQz.removeMessages(15);
        }
        a(false, false);
        if (this.mQz != null) {
            this.mQz.removeMessages(1);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // com.kascend.chushou.player.f, android.support.v4.app.Fragment
    public void onDestroy() {
        this.mQh.dispose();
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view) {
        this.mQj = (RelativeLayout) view.findViewById(a.f.rl_audio);
        this.mQk = (FrescoThumbnailView) view.findViewById(a.f.iv_audio_bg);
        this.Q = (ImageView) view.findViewById(a.f.iv_audio_avator_bg);
        this.mQl = (FrescoThumbnailView) view.findViewById(a.f.iv_audio_avator);
        this.mQm = (TextView) view.findViewById(a.f.tv_audio_playing);
        this.mQn = (TextView) view.findViewById(a.f.tv_open_video);
        this.mQn.setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b() {
        this.mQt = (ProgressBar) this.mQi.findViewById(a.f.LoadingProgressBar);
        this.mQu = (TextView) this.mQi.findViewById(a.f.LoadingPercent);
        this.mQv = (TextView) this.mQi.findViewById(a.f.LoadingBuffer);
        this.mQw = (TextView) this.mQi.findViewById(a.f.tv_change_lines);
        this.mQt.setVisibility(8);
        this.mQu.setVisibility(8);
        this.mQv.setVisibility(8);
        this.mQw.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c() {
        this.mKb = (RelativeLayout) this.mQi.findViewById(a.f.rl_pk_name);
        this.y = (TextView) this.mQi.findViewById(a.f.tv_pk_name);
        this.z = (TextView) this.mQi.findViewById(a.f.tv_pk_subscribe);
        this.z.setOnClickListener(this);
        this.y.setOnClickListener(this);
        this.B = (TextView) this.mQi.findViewById(a.f.iv_cyclelive_countdown);
    }

    private void dEV() {
        if (i() || h()) {
            if (this.N != null) {
                this.N.setVisibility(0);
            }
            this.mMN = ((VideoPlayer) this.mQy).dEi();
            if (this.mMN != null) {
                Uri uri = this.mMN.getUri();
                Uri dEo = ((VideoPlayer) this.mQy).dEo();
                if (!this.mQB) {
                    if (dEo != null && uri != null && !uri.equals(dEo)) {
                        ((VideoPlayer) this.mQy).a(true, (Uri) null, false);
                    } else if (h.dDZ().a) {
                        ((VideoPlayer) this.mQy).a(true, (Uri) null, false);
                    } else if (((VideoPlayer) this.mQy).m) {
                        if (h() && this.mQx.d()) {
                            if (!this.ai) {
                                ((VideoPlayer) this.mQy).a(true, (Uri) null, false);
                                return;
                            }
                            return;
                        }
                        ((VideoPlayer) this.mQy).a(true, (Uri) null, false);
                    } else {
                        AudioManager audioManager = ((VideoPlayer) this.mQy).mHX;
                        VideoPlayer videoPlayer = (VideoPlayer) this.mQy;
                        audioManager.setStreamVolume(3, VideoPlayer.n, 0);
                        if (this.mQx.d()) {
                            if (!this.ai) {
                                if (this.ap < 0) {
                                    if (this.mQx.d) {
                                        Nl();
                                        if (this.mQq != null) {
                                            this.mQq.setImageResource(a.e.ic_btn_room_video_n);
                                        }
                                    } else {
                                        U();
                                        S();
                                        if (this.mQp != null) {
                                            this.mQp.setVisibility(0);
                                        }
                                        if (this.mQq != null) {
                                            this.mQq.setImageResource(a.e.ic_btn_room_audio_n);
                                        }
                                    }
                                }
                                n(true);
                            }
                        } else if (!this.H && !this.al) {
                            ((VideoPlayer) this.mQy).a(true, (Uri) null, false);
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d() {
        FullRoomInfo dEL;
        tv.chushou.zues.utils.e.e("VideoPlayerBaseFragment", "release <----------");
        if (this.B != null) {
            this.B.setVisibility(8);
        }
        if (this.mKd != null) {
            this.mKd.dispose();
            this.mKd = null;
        }
        if (this.mQx != null && (dEL = this.mQx.dEL()) != null && !tv.chushou.zues.utils.h.isEmpty(dEL.mGeneralTabGifts)) {
            for (int i = 0; i < dEL.mGeneralTabGifts.size(); i++) {
                GeneralTabGift generalTabGift = dEL.mGeneralTabGifts.get(i);
                if (generalTabGift != null && !tv.chushou.zues.utils.h.isEmpty(generalTabGift.mGeneralGifts)) {
                    for (int i2 = 0; i2 < generalTabGift.mGeneralGifts.size(); i2++) {
                        if (generalTabGift.mGeneralGifts.get(i2) != null) {
                            generalTabGift.mGeneralGifts.get(i2).mSelectFlag = false;
                        }
                    }
                }
            }
        }
        if (this.mQV != null) {
            this.mQV.clear();
            this.mQV = null;
        }
        if (this.mJX != null) {
            this.mJX.setStatusBarTintEnabled(false);
            this.mJX.setNavigationBarTintEnabled(false);
        }
        if (this.mRl != null) {
            this.mRl.unInit();
            this.mRl = null;
            dFF().removeAllViews();
        }
        if (this.mQY != null) {
            ((ViewGroup) this.mQi).removeView(this.mQY);
            this.mQY = null;
        }
        if (this.mRm != null) {
            this.mRm.cancel();
            ArrayList<Animator> childAnimations = this.mRm.getChildAnimations();
            if (!tv.chushou.zues.utils.h.isEmpty(childAnimations)) {
                Iterator<Animator> it = childAnimations.iterator();
                while (it.hasNext()) {
                    it.next().removeAllListeners();
                }
            }
            this.mRm.removeAllListeners();
            this.mRm = null;
        }
        this.mRa = null;
        if (this.N != null) {
            ((ViewGroup) this.mQi).removeView(this.N);
            this.N = null;
        }
        if (this.mRh != null) {
            this.mRh.a();
            this.mRh = null;
        }
        if (this.mRs != null) {
            this.mRs.dismiss();
        }
        if (this.mRr != null) {
            this.mRr.dismiss();
        }
        this.a = null;
        this.mQi = null;
        this.mQA = null;
        tv.chushou.zues.utils.e.i("VideoPlayerBaseFragment", "release ---------->");
    }

    @Override // com.kascend.chushou.player.e
    public void e() {
        this.H = false;
        this.mQB = false;
        wC(true);
        x();
    }

    public void a(PrivilegeInfo privilegeInfo) {
        ((VideoPlayer) this.mQy).mHU = privilegeInfo;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(String str) {
        ColorPrivileges colorPrivileges;
        ArrayList<RichText> arrayList = null;
        if (this.mQx != null && !tv.chushou.zues.utils.h.isEmpty(this.mQx.a) && this.mMN != null) {
            com.kascend.chushou.c.c.dDV().a(new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.d.1
                @Override // com.kascend.chushou.c.b
                public void a() {
                }

                @Override // com.kascend.chushou.c.b
                public void a(String str2, JSONObject jSONObject) {
                    if (jSONObject != null) {
                        int optInt = jSONObject.optInt("code", -1);
                        String optString = jSONObject.optString("message");
                        if (optInt == 0) {
                            tv.chushou.zues.utils.g.F(d.this.mQy, a.i.str_send_success);
                        } else {
                            a(optInt, optString);
                        }
                    }
                }

                @Override // com.kascend.chushou.c.b
                public void a(int i, String str2) {
                    if (!tv.chushou.zues.utils.h.isEmpty(str2)) {
                        tv.chushou.zues.utils.g.c(d.this.mQy, str2);
                    } else {
                        tv.chushou.zues.utils.g.F(d.this.mQy, a.i.str_send_fail);
                    }
                }
            }, this.mQx.a, str, (String) null, this.mMN.getCurrentPos());
            if (this.mRl != null && this.mRl.getVisibility() == 0) {
                if (((VideoPlayer) this.mQy).mHU != null && (colorPrivileges = ((VideoPlayer) this.mQy).mHU.mColorPrivileges) != null && !tv.chushou.zues.utils.h.isEmpty(colorPrivileges.mColors)) {
                    arrayList = tv.chushou.zues.toolkit.richtext.b.Sr(tv.chushou.zues.toolkit.richtext.b.a(str, colorPrivileges.mColors, colorPrivileges.mWholeColor, new Random().nextInt(colorPrivileges.mColors.size())));
                }
                this.mRl.h(str, arrayList);
            }
        }
    }

    public void a(String str, String str2, String str3, String str4) {
        ArrayList<RichText> arrayList;
        ColorPrivileges colorPrivileges;
        com.kascend.chushou.c.c.dDV().a(new JsonCallbackWrapper() { // from class: com.kascend.chushou.player.d.2
            @Override // tv.chushou.basis.http.listener.JsonCallbackWrapper
            public void callStart() {
            }

            @Override // tv.chushou.basis.http.listener.JsonCallbackWrapper
            public void callSuccess(String str5, JSONObject jSONObject) {
                if (!d.this.dFE()) {
                    ParserRet dF = com.kascend.chushou.c.e.dF(jSONObject);
                    String str6 = dF.mMessage;
                    if (dF.mRc == 0) {
                        d.this.a((PrivilegeInfo) dF.mData);
                    } else {
                        callFailure(dF.mRc, str6, str5);
                    }
                }
            }

            @Override // tv.chushou.basis.http.listener.JsonCallbackWrapper
            public void callFailure(int i, @Nullable String str5, @Nullable String str6) {
                if (!d.this.dFE()) {
                    if (i == 401) {
                        com.kascend.chushou.d.e.b(d.this.mQy, str5);
                    } else if (i == 403) {
                        if (tv.chushou.zues.utils.h.isEmpty(str5)) {
                            str5 = d.this.mQy.getString(a.i.str_blacklist);
                        }
                        tv.chushou.zues.utils.g.c(d.this.mQy, str5);
                    } else if (i == 21001 && !tv.chushou.zues.utils.h.isEmpty(str6)) {
                        try {
                            ParserRet dF = com.kascend.chushou.c.e.dF(new JSONObject(str6));
                            if ((dF.mData1 instanceof String) && !TextUtils.isEmpty((String) dF.mData1)) {
                                ListItem listItem = new ListItem();
                                listItem.mType = "99";
                                listItem.mUrl = (String) dF.mData1;
                                com.kascend.chushou.d.e.a(d.this.mQy, listItem, (JSONObject) null);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }, str, str3, str2, str4);
        boolean z = false;
        if (this.mQx != null) {
            if (this.ap < 0) {
                z = h.dDZ().d;
            } else {
                z = h.dDZ().e;
            }
        }
        if (z && this.mRl != null && this.mRl.getVisibility() == 0) {
            if (((VideoPlayer) this.mQy).mHU == null || (colorPrivileges = ((VideoPlayer) this.mQy).mHU.mColorPrivileges) == null || tv.chushou.zues.utils.h.isEmpty(colorPrivileges.mColors)) {
                arrayList = null;
            } else {
                arrayList = tv.chushou.zues.toolkit.richtext.b.Sr(tv.chushou.zues.toolkit.richtext.b.a(str2, colorPrivileges.mColors, colorPrivileges.mWholeColor, new Random().nextInt(colorPrivileges.mColors.size())));
            }
            this.mRl.h(str2, arrayList);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void f() {
        if (this.mRl != null) {
            this.mRl.RZ(h.dDZ().b());
        }
    }

    public void a(PlayUrl playUrl) {
        if (playUrl == null || playUrl.mSelectedUrl.length() == 0) {
            if (this.mQP != null) {
                this.mQP.dismiss();
                this.mQP = null;
            }
        } else if (this.mQP != null) {
            LinearLayout linearLayout = (LinearLayout) this.mQP.getContentView().findViewById(a.f.ll_pop_root);
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
        if (!c(true) && !dEW()) {
            az();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void az() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    private boolean dEW() {
        RoomInfo dEO;
        if (this.mQx == null || (dEO = this.mQx.dEO()) == null || dEO.mIsSubscribed || dFE()) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long dEe = h.dDZ().dEe();
        if (currentTimeMillis - this.mKf <= 60000 || currentTimeMillis - dEe <= 86400000) {
            return false;
        }
        h.dDZ().a(currentTimeMillis);
        final com.kascend.chushou.view.b.d QE = com.kascend.chushou.view.b.d.QE(dEO.mCreatorAvatar);
        QE.show(getChildFragmentManager(), "showUnSubscirbeDialog");
        QE.a(new d.a() { // from class: com.kascend.chushou.player.d.3
            @Override // com.kascend.chushou.view.b.d.a
            public void a() {
                if (com.kascend.chushou.d.e.c(d.this.mQy, null)) {
                    com.kascend.chushou.c.c.dDV().a(new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.d.3.1
                        @Override // com.kascend.chushou.c.b
                        public void a() {
                        }

                        @Override // com.kascend.chushou.c.b
                        public void a(String str, JSONObject jSONObject) {
                            if (!d.this.dFE()) {
                                tv.chushou.zues.utils.g.Kz(a.i.subscribe_success);
                                d.this.az();
                            }
                        }

                        @Override // com.kascend.chushou.c.b
                        public void a(int i, String str) {
                            if (!d.this.dFE()) {
                                d.this.az();
                            }
                        }
                    }, d.this.mQx.a, (String) null, "");
                }
            }

            @Override // com.kascend.chushou.view.b.d.a
            public void b() {
                QE.dismissAllowingStateLoss();
                d.this.az();
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
        if (this.mQx == null) {
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean i() {
        FullRoomInfo dEL;
        RoomInfo roomInfo;
        return (this.mQx == null || (dEL = this.mQx.dEL()) == null || (roomInfo = dEL.mRoominfo) == null || tv.chushou.zues.utils.h.isEmpty(roomInfo.mGameId)) ? false : true;
    }

    @Override // com.kascend.chushou.player.e
    public void j() {
        if (this.mRl != null) {
            this.mRl.dQW();
        }
        a((PlayUrl) null);
        wC(true);
    }

    @Override // com.kascend.chushou.player.e
    public void a(b bVar) {
        com.kascend.chushou.player.b.a dFl = dFl();
        if (dFl != null) {
            dFl.a(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ParserRet parserRet) {
        SparseArray sparseArray;
        RoomInfo dEO;
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
                    if (this.mQy instanceof VideoPlayer) {
                        ((VideoPlayer) this.mQy).dEv().a(bangInfo);
                    }
                }
                if (sparseArray2.get(2) != null && (sparseArray2.get(2) instanceof ArrayList)) {
                    Iterator it = ((ArrayList) sparseArray2.get(2)).iterator();
                    while (it.hasNext()) {
                        com.kascend.chushou.player.ui.h5.c.a aVar = (com.kascend.chushou.player.ui.h5.c.a) it.next();
                        if (this.mQy instanceof VideoPlayer) {
                            ((VideoPlayer) this.mQy).c(aVar);
                        }
                    }
                }
                if (sparseArray2.get(3) != null && (sparseArray2.get(3) instanceof MicStatus) && this.mQx != null && this.mQx.dEL() != null) {
                    this.mQx.dEL().mMicStatus = (MicStatus) sparseArray2.get(3);
                    if (this.mQx.dEL().mMicStatus != null) {
                        if (this.mQx.dEL().mMicStatus.onMic) {
                            if (sparseArray2.get(4) != null && (sparseArray2.get(4) instanceof ArrayList) && LoginManager.Instance().getUserInfo() != null && !tv.chushou.zues.utils.h.isEmpty(LoginManager.Instance().getUserInfo().mUserID)) {
                                Iterator it2 = ((ArrayList) sparseArray2.get(4)).iterator();
                                while (true) {
                                    if (!it2.hasNext()) {
                                        z = false;
                                        break;
                                    }
                                    FanItem fanItem = (FanItem) it2.next();
                                    if (fanItem != null && String.valueOf(LoginManager.Instance().getUserInfo().mUserID).equals(fanItem.mUserId) && !String.valueOf(LoginManager.Instance().getUserInfo().mUserID).equals(this.mQx.dEL().mRoominfo.mCreatorUID)) {
                                        z = true;
                                        break;
                                    }
                                }
                                if (z) {
                                    this.J = 0.0f;
                                    if (this.mMN != null) {
                                        this.mMN.setVolume(this.J, this.J);
                                    }
                                } else if (this.mJY) {
                                    this.J = 1.0f;
                                    if (this.mMN != null) {
                                        this.mMN.setVolume(this.J, this.J);
                                    }
                                }
                                this.mJY = z;
                            }
                        } else if (this.mMN != null && this.mJY) {
                            this.J = 1.0f;
                            this.mMN.setVolume(this.J, this.J);
                        }
                    }
                }
                if (sparseArray2.get(5) != null) {
                    String obj = sparseArray2.get(5).toString();
                    if ("10003".equals(obj)) {
                        ((VideoPlayer) this.mQy).t = "10003";
                        if (this.mMN != null && "1".equals(this.aw) && !"2".equals(this.ay) && this.mMN.getPlayState() != 4) {
                            j();
                            ((VideoPlayer) this.mQy).m();
                        }
                    } else if ("10004".equals(obj)) {
                        tv.chushou.zues.utils.e.d("Rancune", "officeLine");
                        if (this.mQy instanceof VideoPlayer) {
                            ((VideoPlayer) this.mQy).t = "10004";
                            dFi();
                        }
                    }
                }
                if (sparseArray2.get(6) != null) {
                    List<com.kascend.chushou.player.ui.h5.c.e> list = (List) sparseArray2.get(6);
                    if (!tv.chushou.zues.utils.h.isEmpty(list)) {
                        ((VideoPlayer) this.mQy).dEr().a(list);
                    }
                }
                if (sparseArray2.get(7) != null) {
                    ((VideoPlayer) this.mQy).dEs().a((List) sparseArray2.get(7));
                }
                if (sparseArray2.get(11) != null) {
                    ((VideoPlayer) this.mQy).dEt().a((com.kascend.chushou.player.ui.h5.c.c) sparseArray2.get(11));
                }
                if (sparseArray2.get(12) != null) {
                    AutoBang autoBang = (AutoBang) sparseArray2.get(12);
                    if (this.mQy instanceof VideoPlayer) {
                        ((VideoPlayer) this.mQy).dEv().a(autoBang);
                    }
                }
                if (sparseArray2.get(16) != null) {
                    com.kascend.chushou.player.ui.h5.c.b bVar = (com.kascend.chushou.player.ui.h5.c.b) sparseArray2.get(16);
                    if (this.mQy instanceof VideoPlayer) {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(bVar);
                        ((VideoPlayer) this.mQy).dEu().a(arrayList);
                    }
                }
                if (sparseArray2.get(19) != null && ((Boolean) sparseArray2.get(19)).booleanValue() && (this.mKc == null || tv.chushou.zues.utils.h.isEmpty(this.mKc.uid))) {
                    if (this.B != null) {
                        this.B.setVisibility(0);
                    }
                    if (this.mKd != null) {
                        this.mKd.dispose();
                        this.mKd = null;
                    }
                    this.mKd = io.reactivex.g.a(0L, 12L, 0L, 1L, TimeUnit.SECONDS).a(io.reactivex.a.b.a.dKy()).a(new io.reactivex.c.g<Long>() { // from class: com.kascend.chushou.player.d.4
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
                if (this.mQx != null) {
                    this.mQx.a(arrayList2);
                    if (((VideoPlayer) this.mQy).q) {
                        if (sparseArray != null) {
                            if (sparseArray.get(1) != null) {
                                this.mQx.mJv.a((ArrayList) sparseArray.get(1));
                                if (this.mQz != null && !this.mQz.Kr(11)) {
                                    this.mQz.R(this.mQz.Ks(11));
                                }
                            }
                            if (sparseArray.get(2) != null) {
                                this.mQx.mJv.b((ArrayList) sparseArray.get(2));
                                if (this.mQz != null && !this.mQz.Kr(12)) {
                                    this.mQz.R(this.mQz.Ks(12));
                                }
                            }
                        } else if (this.mQx.mJv != null) {
                            if (this.mQx.mJv.d() && this.mQz != null && !this.mQz.Kr(11)) {
                                this.mQz.R(this.mQz.Ks(11));
                            }
                            if (this.mQx.mJv.h() && this.mQz != null && !this.mQz.Kr(12)) {
                                this.mQz.R(this.mQz.Ks(12));
                            }
                        }
                    }
                }
                if (arrayList2 != null && arrayList2.size() != 0) {
                    boolean z2 = false;
                    if (this.mQx != null) {
                        if (this.ap < 0) {
                            z2 = h.dDZ().d;
                        } else {
                            z2 = h.dDZ().e;
                        }
                    }
                    if (this.mRl != null && z2 && this.mRl.getVisibility() == 0) {
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
                                aVar2.nLn.icon = next.mGift.icon;
                                if (next.mItem != null && !tv.chushou.zues.utils.h.isEmpty(next.mItem.mType) && this.mQx != null && ((dEO = this.mQx.dEO()) == null || !next.mItem.mType.equals("1") || !next.mItem.mTargetKey.equals(dEO.mRoomID))) {
                                    aVar2.tag = next.mItem;
                                }
                                this.mRl.a(aVar2);
                            }
                        }
                    }
                    if (dFl() != null && (this.mQy instanceof VideoPlayer) && ((VideoPlayer) this.mQy).q) {
                        dFl().a(arrayList2);
                    }
                }
            }
        }
    }

    @Override // com.kascend.chushou.player.e
    public void k() {
        if (this.mQy instanceof VideoPlayer) {
            if (((VideoPlayer) this.mQy).q) {
                dFc().setVisibility(0);
            } else {
                dFc().setVisibility(8);
            }
        }
    }

    @Override // com.kascend.chushou.player.e
    public void l() {
        dFc().setVisibility(8);
    }

    @Override // com.kascend.chushou.player.e
    public void m() {
        com.kascend.chushou.player.b.a dFl = dFl();
        if (dFl != null) {
            dFl.b();
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
        if (!this.k && this.mJW != null) {
            try {
                if (this.mMN != null) {
                    i = this.mMN.getCurrentPos();
                    i2 = this.mMN.getDuration();
                } else {
                    i = 0;
                }
                if (i2 > 1000) {
                    this.mJW.setProgress(i / (i2 / 1000));
                }
            } catch (NullPointerException e) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(boolean z, int i) {
        if (this.mJX != null) {
            if (z) {
                this.mJX.setStatusBarTintResource(i);
                this.mJX.setTintResource(i);
                this.mJX.setStatusBarTintEnabled(true);
                this.mJX.setNavigationBarTintEnabled(true);
                return;
            }
            this.mJX.setStatusBarTintEnabled(false);
            this.mJX.setNavigationBarTintEnabled(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(String str) {
        if (this.mQy instanceof VideoPlayer) {
            str = ((VideoPlayer) this.mQy).a(str);
        }
        com.kascend.chushou.d.a.c(this.mQy, str);
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
            if (this.mJZ != null && this.mJZ.mMO != null && !tv.chushou.zues.utils.h.isEmpty(this.mJZ.mMO.mPkRoomId)) {
                ListItem listItem = new ListItem();
                if (this.mJZ.mMO.liveStyle == 0 || this.mJZ.mMO.liveStyle == 1) {
                    listItem.mLiveType = "1";
                } else {
                    listItem.mLiveType = "2";
                }
                listItem.mType = "1";
                listItem.mTargetKey = this.mJZ.mMO.mPkRoomId;
                com.kascend.chushou.d.e.a(this.mQy, listItem, (JSONObject) null);
            }
        } else if (id == a.f.tv_pk_name && this.mJZ != null && this.mJZ.mMO != null && !tv.chushou.zues.utils.h.isEmpty(this.mJZ.mMO.mPkUid)) {
            com.kascend.chushou.d.a.a(this.mQy, (JSONObject) null, this.mJZ.mMO.mPkRoomId, this.mJZ.mMO.mPkUid, LoginManager.Instance().getUserInfo() != null ? String.valueOf(LoginManager.Instance().getUserInfo().mUserID) : "", false);
        }
    }

    @Override // com.kascend.chushou.player.e
    public boolean a(MotionEvent motionEvent) {
        if ((motionEvent.getAction() == 1 || motionEvent.getAction() == 3 || motionEvent.getAction() == 4) && this.k && this.mMN != null) {
            this.k = false;
            this.mhQ = Math.min(this.mMN.getDuration(), Math.max(0, this.mMN.getCurrentPos() + this.j));
            if (this.mQz != null) {
                this.mQz.removeMessages(14);
                this.mQz.Kq(14);
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
            return (this.E && c(true)) || dEW();
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
        if (this.mQx != null) {
            if (this.ap < 0) {
                z = h.dDZ().d;
            } else {
                z = h.dDZ().e;
            }
        }
        if (z && this.mRl != null && this.mRl.getVisibility() == 0) {
            if (((VideoPlayer) this.mQy).mHU == null || (colorPrivileges = ((VideoPlayer) this.mQy).mHU.mColorPrivileges) == null || tv.chushou.zues.utils.h.isEmpty(colorPrivileges.mColors)) {
                arrayList = null;
            } else {
                arrayList = tv.chushou.zues.toolkit.richtext.b.Sr(tv.chushou.zues.toolkit.richtext.b.a(str, colorPrivileges.mColors, colorPrivileges.mWholeColor, new Random().nextInt(colorPrivileges.mColors.size())));
            }
            this.mRl.h(str, arrayList);
        }
    }

    public void f(int i) {
        com.kascend.chushou.c.c.dDV().a(i, new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.d.7
            @Override // com.kascend.chushou.c.b
            public void a() {
            }

            @Override // com.kascend.chushou.c.b
            public void a(String str, JSONObject jSONObject) {
                if (!d.this.dFE()) {
                    if (jSONObject != null) {
                        int optInt = jSONObject.optInt("data");
                        if (d.this.mQx != null && d.this.mQx.mJH != null) {
                            d.this.mQx.mJH.count = optInt;
                            d.this.M();
                        }
                        tv.chushou.zues.utils.g.Kz(a.i.str_buy_trumpte_success);
                        return;
                    }
                    a(-1, "");
                }
            }

            @Override // com.kascend.chushou.c.b
            public void a(int i2, String str) {
                String str2;
                if (!d.this.dFE()) {
                    if (i2 == 401) {
                        com.kascend.chushou.d.e.b(d.this.mQy, str);
                    } else if (i2 == 403) {
                        if (tv.chushou.zues.utils.h.isEmpty(str)) {
                            str = d.this.mQy.getString(a.i.str_blacklist);
                        }
                        tv.chushou.zues.utils.g.c(d.this.mQy, str);
                    } else if (i2 == 1027) {
                        if (!(d.this.mQy instanceof VideoPlayer)) {
                            str2 = null;
                        } else {
                            str2 = ((VideoPlayer) d.this.mQy).a((String) null);
                        }
                        com.kascend.chushou.d.e.a(d.this.getActivity(), str2);
                    } else if (tv.chushou.zues.utils.h.isEmpty(str)) {
                        tv.chushou.zues.utils.g.Kz(a.i.str_buy_trumpte_failuer);
                    } else {
                        tv.chushou.zues.utils.g.u(str);
                    }
                }
            }
        });
    }

    public void a(String str, String str2) {
        com.kascend.chushou.c.c.dDV().c(str, str2, new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.d.8
            @Override // com.kascend.chushou.c.b
            public void a() {
            }

            @Override // com.kascend.chushou.c.b
            public void a(String str3, JSONObject jSONObject) {
                if (!d.this.dFE() && jSONObject != null) {
                    int optInt = jSONObject.optInt("data");
                    tv.chushou.zues.utils.g.Kz(a.i.str_send_success);
                    if (d.this.mQx != null && d.this.mQx.mJH != null) {
                        d.this.mQx.mJH.count = optInt;
                        d.this.M();
                        return;
                    }
                    a(-1, "");
                }
            }

            @Override // com.kascend.chushou.c.b
            public void a(int i, String str3) {
                if (!d.this.dFE()) {
                    if (i == 401) {
                        com.kascend.chushou.d.e.b(d.this.mQy, str3);
                    } else if (i == 403 && tv.chushou.zues.utils.h.isEmpty(str3)) {
                        str3 = d.this.mQy.getString(a.i.str_blacklist);
                    }
                    if (tv.chushou.zues.utils.h.isEmpty(str3)) {
                        tv.chushou.zues.utils.g.F(d.this.mQy, a.i.str_send_fail);
                    } else {
                        tv.chushou.zues.utils.g.c(d.this.mQy, str3);
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void t() {
        final int gB = tv.chushou.zues.utils.systemBar.b.gB(getActivity());
        this.mKe.setOnActionListener(new VoiceInteractionView.b() { // from class: com.kascend.chushou.player.d.9
            @Override // com.kascend.chushou.widget.VoiceInteractionView.b
            public void a() {
                ListItem listItem = new ListItem();
                listItem.mUrl = com.kascend.chushou.c.c.a(50);
                d.this.a(listItem);
            }

            @Override // com.kascend.chushou.widget.VoiceInteractionView.b
            public void b() {
                com.kascend.chushou.d.e.a(d.this.mQy, com.kascend.chushou.c.c.a(51) + "micRoomId=" + d.this.G);
            }

            @Override // com.kascend.chushou.widget.VoiceInteractionView.b
            public void a(int i, MicMemberInfo micMemberInfo, boolean z) {
                if (micMemberInfo != null) {
                    if (!z) {
                        com.kascend.chushou.d.a.a(d.this.mQy, (JSONObject) null, (String) null, micMemberInfo.uid, LoginManager.Instance().getUserInfo() != null ? String.valueOf(LoginManager.Instance().getUserInfo().mUserID) : "", false);
                        return;
                    }
                    micMemberInfo.micRoomId = d.this.G;
                    if (d.this.ap == 0) {
                        boolean z2 = d.this.mRd == null;
                        d.this.a(false, false, micMemberInfo);
                        if (z2 && gB > 0 && d.this.mRd != null && tv.chushou.zues.utils.systemBar.b.ax(d.this.getActivity()) && tv.chushou.zues.utils.systemBar.b.ay(d.this.getActivity())) {
                            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) d.this.mRd.getLayoutParams();
                            layoutParams.rightMargin += gB;
                            d.this.mRd.setLayoutParams(layoutParams);
                            return;
                        }
                        return;
                    }
                    boolean z3 = d.this.mRd == null;
                    if (d.this.mQy.getResources().getDisplayMetrics().density < 2.0f) {
                        d.this.a(true, false, micMemberInfo);
                    } else {
                        d.this.a(true, true, micMemberInfo);
                    }
                    if (z3 && gB > 0 && d.this.mRd != null) {
                        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) d.this.mRd.getLayoutParams();
                        layoutParams2.bottomMargin += gB;
                        d.this.mRd.setLayoutParams(layoutParams2);
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
        if (this.mQx.dEL().mMicStatus.onMic != this.E) {
            this.E = this.mQx.dEL().mMicStatus.onMic;
            u();
        }
        this.E = this.mQx.dEL().mMicStatus.onMic;
        if (this.E) {
            if (this.mQx.dEL().mMicStatus != null && !tv.chushou.zues.utils.h.isEmpty(this.mQx.dEL().mMicStatus.micRoomId) && !this.mQx.dEL().mMicStatus.micRoomId.equals("0")) {
                this.G = this.mQx.dEL().mMicStatus.micRoomId;
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
            if (this.mKe != null) {
                b(true);
                this.mKe.setupCount(this.mQx.dEL().mMicStatus.capacity - 1);
                this.mKe.a(this.mQx.dEL().mMicStatus.isOngoing == 1, z, this.mQx.dEL().mMicStatus.displayInteraction == 1);
                this.mKe.a(arrayList);
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

    public boolean m(EditText editText) {
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

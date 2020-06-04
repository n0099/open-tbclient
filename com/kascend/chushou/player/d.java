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
    protected a mLd;
    protected com.kascend.chushou.widget.a.b mLf;
    protected tv.chushou.zues.utils.systemBar.a mLh;
    protected com.kascend.chushou.player.e.a mLj;
    protected com.kascend.chushou.player.e.b mLk;
    protected RelativeLayout mLl;
    protected VoiceInteractionView mLo;
    protected String u;
    protected TextView y;
    protected TextView z;
    protected ImageButton a = null;
    protected String b = null;
    private boolean mLe = false;
    protected boolean e = true;
    protected boolean f = false;
    protected TextView h = null;
    protected TextView i = null;
    protected int j = 0;
    protected boolean k = false;
    protected ProgressBar mLg = null;
    protected long m = 0;
    protected int n = 0;
    protected boolean p = false;
    private boolean mLi = false;
    protected boolean v = false;
    protected int w = -1;
    protected CycleLiveRoomInfo mLm = null;
    protected io.reactivex.disposables.b mLn = null;
    protected boolean E = false;
    protected boolean F = false;
    private long mLp = 0;

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mRJ = getActivity();
        if (dFS()) {
            tv.chushou.zues.utils.e.e("VideoPlayerBaseFragment", "killed in backgroud");
            return;
        }
        Point gv = tv.chushou.zues.utils.a.gv(this.mRJ);
        q = Math.min(gv.x, gv.y) / 5;
        r = 200;
        this.mRL = (AudioManager) this.mRJ.getApplicationContext().getSystemService("audio");
        this.mLp = System.currentTimeMillis();
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
        dFj();
        ((VideoPlayer) this.mRJ).m = false;
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.ah = true;
        R();
        if (this.N != null && this.mNX != null) {
            this.N.setVisibility(8);
        }
        if (this.mRK != null) {
            this.mRK.removeMessages(15);
        }
        a(false, false);
        if (this.mRK != null) {
            this.mRK.removeMessages(1);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // com.kascend.chushou.player.f, android.support.v4.app.Fragment
    public void onDestroy() {
        this.mRs.dispose();
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view) {
        this.mRu = (RelativeLayout) view.findViewById(a.f.rl_audio);
        this.mRv = (FrescoThumbnailView) view.findViewById(a.f.iv_audio_bg);
        this.Q = (ImageView) view.findViewById(a.f.iv_audio_avator_bg);
        this.mRw = (FrescoThumbnailView) view.findViewById(a.f.iv_audio_avator);
        this.mRx = (TextView) view.findViewById(a.f.tv_audio_playing);
        this.mRy = (TextView) view.findViewById(a.f.tv_open_video);
        this.mRy.setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b() {
        this.mRE = (ProgressBar) this.mRt.findViewById(a.f.LoadingProgressBar);
        this.mRF = (TextView) this.mRt.findViewById(a.f.LoadingPercent);
        this.mRG = (TextView) this.mRt.findViewById(a.f.LoadingBuffer);
        this.mRH = (TextView) this.mRt.findViewById(a.f.tv_change_lines);
        this.mRE.setVisibility(8);
        this.mRF.setVisibility(8);
        this.mRG.setVisibility(8);
        this.mRH.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c() {
        this.mLl = (RelativeLayout) this.mRt.findViewById(a.f.rl_pk_name);
        this.y = (TextView) this.mRt.findViewById(a.f.tv_pk_name);
        this.z = (TextView) this.mRt.findViewById(a.f.tv_pk_subscribe);
        this.z.setOnClickListener(this);
        this.y.setOnClickListener(this);
        this.B = (TextView) this.mRt.findViewById(a.f.iv_cyclelive_countdown);
    }

    private void dFj() {
        if (i() || h()) {
            if (this.N != null) {
                this.N.setVisibility(0);
            }
            this.mNX = ((VideoPlayer) this.mRJ).dEw();
            if (this.mNX != null) {
                Uri uri = this.mNX.getUri();
                Uri dEC = ((VideoPlayer) this.mRJ).dEC();
                if (!this.mRM) {
                    if (dEC != null && uri != null && !uri.equals(dEC)) {
                        ((VideoPlayer) this.mRJ).a(true, (Uri) null, false);
                    } else if (h.dEn().a) {
                        ((VideoPlayer) this.mRJ).a(true, (Uri) null, false);
                    } else if (((VideoPlayer) this.mRJ).m) {
                        if (h() && this.mRI.d()) {
                            if (!this.ai) {
                                ((VideoPlayer) this.mRJ).a(true, (Uri) null, false);
                                return;
                            }
                            return;
                        }
                        ((VideoPlayer) this.mRJ).a(true, (Uri) null, false);
                    } else {
                        AudioManager audioManager = ((VideoPlayer) this.mRJ).mJl;
                        VideoPlayer videoPlayer = (VideoPlayer) this.mRJ;
                        audioManager.setStreamVolume(3, VideoPlayer.n, 0);
                        if (this.mRI.d()) {
                            if (!this.ai) {
                                if (this.ap < 0) {
                                    if (this.mRI.d) {
                                        Nl();
                                        if (this.mRB != null) {
                                            this.mRB.setImageResource(a.e.ic_btn_room_video_n);
                                        }
                                    } else {
                                        U();
                                        S();
                                        if (this.mRA != null) {
                                            this.mRA.setVisibility(0);
                                        }
                                        if (this.mRB != null) {
                                            this.mRB.setImageResource(a.e.ic_btn_room_audio_n);
                                        }
                                    }
                                }
                                n(true);
                            }
                        } else if (!this.H && !this.al) {
                            ((VideoPlayer) this.mRJ).a(true, (Uri) null, false);
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d() {
        FullRoomInfo dEZ;
        tv.chushou.zues.utils.e.e("VideoPlayerBaseFragment", "release <----------");
        if (this.B != null) {
            this.B.setVisibility(8);
        }
        if (this.mLn != null) {
            this.mLn.dispose();
            this.mLn = null;
        }
        if (this.mRI != null && (dEZ = this.mRI.dEZ()) != null && !tv.chushou.zues.utils.h.isEmpty(dEZ.mGeneralTabGifts)) {
            for (int i = 0; i < dEZ.mGeneralTabGifts.size(); i++) {
                GeneralTabGift generalTabGift = dEZ.mGeneralTabGifts.get(i);
                if (generalTabGift != null && !tv.chushou.zues.utils.h.isEmpty(generalTabGift.mGeneralGifts)) {
                    for (int i2 = 0; i2 < generalTabGift.mGeneralGifts.size(); i2++) {
                        if (generalTabGift.mGeneralGifts.get(i2) != null) {
                            generalTabGift.mGeneralGifts.get(i2).mSelectFlag = false;
                        }
                    }
                }
            }
        }
        if (this.mSg != null) {
            this.mSg.clear();
            this.mSg = null;
        }
        if (this.mLh != null) {
            this.mLh.setStatusBarTintEnabled(false);
            this.mLh.setNavigationBarTintEnabled(false);
        }
        if (this.mSw != null) {
            this.mSw.unInit();
            this.mSw = null;
            dFT().removeAllViews();
        }
        if (this.mSj != null) {
            ((ViewGroup) this.mRt).removeView(this.mSj);
            this.mSj = null;
        }
        if (this.mSx != null) {
            this.mSx.cancel();
            ArrayList<Animator> childAnimations = this.mSx.getChildAnimations();
            if (!tv.chushou.zues.utils.h.isEmpty(childAnimations)) {
                Iterator<Animator> it = childAnimations.iterator();
                while (it.hasNext()) {
                    it.next().removeAllListeners();
                }
            }
            this.mSx.removeAllListeners();
            this.mSx = null;
        }
        this.mSl = null;
        if (this.N != null) {
            ((ViewGroup) this.mRt).removeView(this.N);
            this.N = null;
        }
        if (this.mSs != null) {
            this.mSs.a();
            this.mSs = null;
        }
        if (this.mSE != null) {
            this.mSE.dismiss();
        }
        if (this.mSD != null) {
            this.mSD.dismiss();
        }
        this.a = null;
        this.mRt = null;
        this.mRL = null;
        tv.chushou.zues.utils.e.i("VideoPlayerBaseFragment", "release ---------->");
    }

    @Override // com.kascend.chushou.player.e
    public void e() {
        this.H = false;
        this.mRM = false;
        wE(true);
        x();
    }

    public void a(PrivilegeInfo privilegeInfo) {
        ((VideoPlayer) this.mRJ).mJi = privilegeInfo;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(String str) {
        ColorPrivileges colorPrivileges;
        ArrayList<RichText> arrayList = null;
        if (this.mRI != null && !tv.chushou.zues.utils.h.isEmpty(this.mRI.a) && this.mNX != null) {
            com.kascend.chushou.c.c.dEj().a(new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.d.1
                @Override // com.kascend.chushou.c.b
                public void a() {
                }

                @Override // com.kascend.chushou.c.b
                public void a(String str2, JSONObject jSONObject) {
                    if (jSONObject != null) {
                        int optInt = jSONObject.optInt("code", -1);
                        String optString = jSONObject.optString("message");
                        if (optInt == 0) {
                            tv.chushou.zues.utils.g.F(d.this.mRJ, a.i.str_send_success);
                        } else {
                            a(optInt, optString);
                        }
                    }
                }

                @Override // com.kascend.chushou.c.b
                public void a(int i, String str2) {
                    if (!tv.chushou.zues.utils.h.isEmpty(str2)) {
                        tv.chushou.zues.utils.g.c(d.this.mRJ, str2);
                    } else {
                        tv.chushou.zues.utils.g.F(d.this.mRJ, a.i.str_send_fail);
                    }
                }
            }, this.mRI.a, str, (String) null, this.mNX.getCurrentPos());
            if (this.mSw != null && this.mSw.getVisibility() == 0) {
                if (((VideoPlayer) this.mRJ).mJi != null && (colorPrivileges = ((VideoPlayer) this.mRJ).mJi.mColorPrivileges) != null && !tv.chushou.zues.utils.h.isEmpty(colorPrivileges.mColors)) {
                    arrayList = tv.chushou.zues.toolkit.richtext.b.Ss(tv.chushou.zues.toolkit.richtext.b.a(str, colorPrivileges.mColors, colorPrivileges.mWholeColor, new Random().nextInt(colorPrivileges.mColors.size())));
                }
                this.mSw.h(str, arrayList);
            }
        }
    }

    public void a(String str, String str2, String str3, String str4) {
        ArrayList<RichText> arrayList;
        ColorPrivileges colorPrivileges;
        com.kascend.chushou.c.c.dEj().a(new JsonCallbackWrapper() { // from class: com.kascend.chushou.player.d.2
            @Override // tv.chushou.basis.http.listener.JsonCallbackWrapper
            public void callStart() {
            }

            @Override // tv.chushou.basis.http.listener.JsonCallbackWrapper
            public void callSuccess(String str5, JSONObject jSONObject) {
                if (!d.this.dFS()) {
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
                if (!d.this.dFS()) {
                    if (i == 401) {
                        com.kascend.chushou.d.e.b(d.this.mRJ, str5);
                    } else if (i == 403) {
                        if (tv.chushou.zues.utils.h.isEmpty(str5)) {
                            str5 = d.this.mRJ.getString(a.i.str_blacklist);
                        }
                        tv.chushou.zues.utils.g.c(d.this.mRJ, str5);
                    } else if (i == 21001 && !tv.chushou.zues.utils.h.isEmpty(str6)) {
                        try {
                            ParserRet dF = com.kascend.chushou.c.e.dF(new JSONObject(str6));
                            if ((dF.mData1 instanceof String) && !TextUtils.isEmpty((String) dF.mData1)) {
                                ListItem listItem = new ListItem();
                                listItem.mType = "99";
                                listItem.mUrl = (String) dF.mData1;
                                com.kascend.chushou.d.e.a(d.this.mRJ, listItem, (JSONObject) null);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }, str, str3, str2, str4);
        boolean z = false;
        if (this.mRI != null) {
            if (this.ap < 0) {
                z = h.dEn().d;
            } else {
                z = h.dEn().e;
            }
        }
        if (z && this.mSw != null && this.mSw.getVisibility() == 0) {
            if (((VideoPlayer) this.mRJ).mJi == null || (colorPrivileges = ((VideoPlayer) this.mRJ).mJi.mColorPrivileges) == null || tv.chushou.zues.utils.h.isEmpty(colorPrivileges.mColors)) {
                arrayList = null;
            } else {
                arrayList = tv.chushou.zues.toolkit.richtext.b.Ss(tv.chushou.zues.toolkit.richtext.b.a(str2, colorPrivileges.mColors, colorPrivileges.mWholeColor, new Random().nextInt(colorPrivileges.mColors.size())));
            }
            this.mSw.h(str2, arrayList);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void f() {
        if (this.mSw != null) {
            this.mSw.Sa(h.dEn().b());
        }
    }

    public void a(PlayUrl playUrl) {
        if (playUrl == null || playUrl.mSelectedUrl.length() == 0) {
            if (this.mSa != null) {
                this.mSa.dismiss();
                this.mSa = null;
            }
        } else if (this.mSa != null) {
            LinearLayout linearLayout = (LinearLayout) this.mSa.getContentView().findViewById(a.f.ll_pop_root);
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
        if (!c(true) && !dFk()) {
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

    private boolean dFk() {
        RoomInfo dFc;
        if (this.mRI == null || (dFc = this.mRI.dFc()) == null || dFc.mIsSubscribed || dFS()) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long dEs = h.dEn().dEs();
        if (currentTimeMillis - this.mLp <= 60000 || currentTimeMillis - dEs <= 86400000) {
            return false;
        }
        h.dEn().a(currentTimeMillis);
        final com.kascend.chushou.view.b.d QF = com.kascend.chushou.view.b.d.QF(dFc.mCreatorAvatar);
        QF.show(getChildFragmentManager(), "showUnSubscirbeDialog");
        QF.a(new d.a() { // from class: com.kascend.chushou.player.d.3
            @Override // com.kascend.chushou.view.b.d.a
            public void a() {
                if (com.kascend.chushou.d.e.c(d.this.mRJ, null)) {
                    com.kascend.chushou.c.c.dEj().a(new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.d.3.1
                        @Override // com.kascend.chushou.c.b
                        public void a() {
                        }

                        @Override // com.kascend.chushou.c.b
                        public void a(String str, JSONObject jSONObject) {
                            if (!d.this.dFS()) {
                                tv.chushou.zues.utils.g.KB(a.i.subscribe_success);
                                d.this.az();
                            }
                        }

                        @Override // com.kascend.chushou.c.b
                        public void a(int i, String str) {
                            if (!d.this.dFS()) {
                                d.this.az();
                            }
                        }
                    }, d.this.mRI.a, (String) null, "");
                }
            }

            @Override // com.kascend.chushou.view.b.d.a
            public void b() {
                QF.dismissAllowingStateLoss();
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
        if (this.mRI == null) {
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean i() {
        FullRoomInfo dEZ;
        RoomInfo roomInfo;
        return (this.mRI == null || (dEZ = this.mRI.dEZ()) == null || (roomInfo = dEZ.mRoominfo) == null || tv.chushou.zues.utils.h.isEmpty(roomInfo.mGameId)) ? false : true;
    }

    @Override // com.kascend.chushou.player.e
    public void j() {
        if (this.mSw != null) {
            this.mSw.dRk();
        }
        a((PlayUrl) null);
        wE(true);
    }

    @Override // com.kascend.chushou.player.e
    public void a(b bVar) {
        com.kascend.chushou.player.b.a dFz = dFz();
        if (dFz != null) {
            dFz.a(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ParserRet parserRet) {
        SparseArray sparseArray;
        RoomInfo dFc;
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
                    if (this.mRJ instanceof VideoPlayer) {
                        ((VideoPlayer) this.mRJ).dEJ().a(bangInfo);
                    }
                }
                if (sparseArray2.get(2) != null && (sparseArray2.get(2) instanceof ArrayList)) {
                    Iterator it = ((ArrayList) sparseArray2.get(2)).iterator();
                    while (it.hasNext()) {
                        com.kascend.chushou.player.ui.h5.c.a aVar = (com.kascend.chushou.player.ui.h5.c.a) it.next();
                        if (this.mRJ instanceof VideoPlayer) {
                            ((VideoPlayer) this.mRJ).c(aVar);
                        }
                    }
                }
                if (sparseArray2.get(3) != null && (sparseArray2.get(3) instanceof MicStatus) && this.mRI != null && this.mRI.dEZ() != null) {
                    this.mRI.dEZ().mMicStatus = (MicStatus) sparseArray2.get(3);
                    if (this.mRI.dEZ().mMicStatus != null) {
                        if (this.mRI.dEZ().mMicStatus.onMic) {
                            if (sparseArray2.get(4) != null && (sparseArray2.get(4) instanceof ArrayList) && LoginManager.Instance().getUserInfo() != null && !tv.chushou.zues.utils.h.isEmpty(LoginManager.Instance().getUserInfo().mUserID)) {
                                Iterator it2 = ((ArrayList) sparseArray2.get(4)).iterator();
                                while (true) {
                                    if (!it2.hasNext()) {
                                        z = false;
                                        break;
                                    }
                                    FanItem fanItem = (FanItem) it2.next();
                                    if (fanItem != null && String.valueOf(LoginManager.Instance().getUserInfo().mUserID).equals(fanItem.mUserId) && !String.valueOf(LoginManager.Instance().getUserInfo().mUserID).equals(this.mRI.dEZ().mRoominfo.mCreatorUID)) {
                                        z = true;
                                        break;
                                    }
                                }
                                if (z) {
                                    this.J = 0.0f;
                                    if (this.mNX != null) {
                                        this.mNX.setVolume(this.J, this.J);
                                    }
                                } else if (this.mLi) {
                                    this.J = 1.0f;
                                    if (this.mNX != null) {
                                        this.mNX.setVolume(this.J, this.J);
                                    }
                                }
                                this.mLi = z;
                            }
                        } else if (this.mNX != null && this.mLi) {
                            this.J = 1.0f;
                            this.mNX.setVolume(this.J, this.J);
                        }
                    }
                }
                if (sparseArray2.get(5) != null) {
                    String obj = sparseArray2.get(5).toString();
                    if ("10003".equals(obj)) {
                        ((VideoPlayer) this.mRJ).t = "10003";
                        if (this.mNX != null && "1".equals(this.aw) && !"2".equals(this.ay) && this.mNX.getPlayState() != 4) {
                            j();
                            ((VideoPlayer) this.mRJ).m();
                        }
                    } else if ("10004".equals(obj)) {
                        tv.chushou.zues.utils.e.d("Rancune", "officeLine");
                        if (this.mRJ instanceof VideoPlayer) {
                            ((VideoPlayer) this.mRJ).t = "10004";
                            dFw();
                        }
                    }
                }
                if (sparseArray2.get(6) != null) {
                    List<com.kascend.chushou.player.ui.h5.c.e> list = (List) sparseArray2.get(6);
                    if (!tv.chushou.zues.utils.h.isEmpty(list)) {
                        ((VideoPlayer) this.mRJ).dEF().a(list);
                    }
                }
                if (sparseArray2.get(7) != null) {
                    ((VideoPlayer) this.mRJ).dEG().a((List) sparseArray2.get(7));
                }
                if (sparseArray2.get(11) != null) {
                    ((VideoPlayer) this.mRJ).dEH().a((com.kascend.chushou.player.ui.h5.c.c) sparseArray2.get(11));
                }
                if (sparseArray2.get(12) != null) {
                    AutoBang autoBang = (AutoBang) sparseArray2.get(12);
                    if (this.mRJ instanceof VideoPlayer) {
                        ((VideoPlayer) this.mRJ).dEJ().a(autoBang);
                    }
                }
                if (sparseArray2.get(16) != null) {
                    com.kascend.chushou.player.ui.h5.c.b bVar = (com.kascend.chushou.player.ui.h5.c.b) sparseArray2.get(16);
                    if (this.mRJ instanceof VideoPlayer) {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(bVar);
                        ((VideoPlayer) this.mRJ).dEI().a(arrayList);
                    }
                }
                if (sparseArray2.get(19) != null && ((Boolean) sparseArray2.get(19)).booleanValue() && (this.mLm == null || tv.chushou.zues.utils.h.isEmpty(this.mLm.uid))) {
                    if (this.B != null) {
                        this.B.setVisibility(0);
                    }
                    if (this.mLn != null) {
                        this.mLn.dispose();
                        this.mLn = null;
                    }
                    this.mLn = io.reactivex.g.a(0L, 12L, 0L, 1L, TimeUnit.SECONDS).a(io.reactivex.a.b.a.dKM()).a(new io.reactivex.c.g<Long>() { // from class: com.kascend.chushou.player.d.4
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
                if (this.mRI != null) {
                    this.mRI.a(arrayList2);
                    if (((VideoPlayer) this.mRJ).q) {
                        if (sparseArray != null) {
                            if (sparseArray.get(1) != null) {
                                this.mRI.mKF.a((ArrayList) sparseArray.get(1));
                                if (this.mRK != null && !this.mRK.Kt(11)) {
                                    this.mRK.R(this.mRK.Ku(11));
                                }
                            }
                            if (sparseArray.get(2) != null) {
                                this.mRI.mKF.b((ArrayList) sparseArray.get(2));
                                if (this.mRK != null && !this.mRK.Kt(12)) {
                                    this.mRK.R(this.mRK.Ku(12));
                                }
                            }
                        } else if (this.mRI.mKF != null) {
                            if (this.mRI.mKF.d() && this.mRK != null && !this.mRK.Kt(11)) {
                                this.mRK.R(this.mRK.Ku(11));
                            }
                            if (this.mRI.mKF.h() && this.mRK != null && !this.mRK.Kt(12)) {
                                this.mRK.R(this.mRK.Ku(12));
                            }
                        }
                    }
                }
                if (arrayList2 != null && arrayList2.size() != 0) {
                    boolean z2 = false;
                    if (this.mRI != null) {
                        if (this.ap < 0) {
                            z2 = h.dEn().d;
                        } else {
                            z2 = h.dEn().e;
                        }
                    }
                    if (this.mSw != null && z2 && this.mSw.getVisibility() == 0) {
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
                                aVar2.nMx.icon = next.mGift.icon;
                                if (next.mItem != null && !tv.chushou.zues.utils.h.isEmpty(next.mItem.mType) && this.mRI != null && ((dFc = this.mRI.dFc()) == null || !next.mItem.mType.equals("1") || !next.mItem.mTargetKey.equals(dFc.mRoomID))) {
                                    aVar2.tag = next.mItem;
                                }
                                this.mSw.a(aVar2);
                            }
                        }
                    }
                    if (dFz() != null && (this.mRJ instanceof VideoPlayer) && ((VideoPlayer) this.mRJ).q) {
                        dFz().a(arrayList2);
                    }
                }
            }
        }
    }

    @Override // com.kascend.chushou.player.e
    public void k() {
        if (this.mRJ instanceof VideoPlayer) {
            if (((VideoPlayer) this.mRJ).q) {
                dFq().setVisibility(0);
            } else {
                dFq().setVisibility(8);
            }
        }
    }

    @Override // com.kascend.chushou.player.e
    public void l() {
        dFq().setVisibility(8);
    }

    @Override // com.kascend.chushou.player.e
    public void m() {
        com.kascend.chushou.player.b.a dFz = dFz();
        if (dFz != null) {
            dFz.b();
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
        if (!this.k && this.mLg != null) {
            try {
                if (this.mNX != null) {
                    i = this.mNX.getCurrentPos();
                    i2 = this.mNX.getDuration();
                } else {
                    i = 0;
                }
                if (i2 > 1000) {
                    this.mLg.setProgress(i / (i2 / 1000));
                }
            } catch (NullPointerException e) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(boolean z, int i) {
        if (this.mLh != null) {
            if (z) {
                this.mLh.setStatusBarTintResource(i);
                this.mLh.setTintResource(i);
                this.mLh.setStatusBarTintEnabled(true);
                this.mLh.setNavigationBarTintEnabled(true);
                return;
            }
            this.mLh.setStatusBarTintEnabled(false);
            this.mLh.setNavigationBarTintEnabled(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(String str) {
        if (this.mRJ instanceof VideoPlayer) {
            str = ((VideoPlayer) this.mRJ).a(str);
        }
        com.kascend.chushou.d.a.c(this.mRJ, str);
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
            if (this.mLj != null && this.mLj.mNY != null && !tv.chushou.zues.utils.h.isEmpty(this.mLj.mNY.mPkRoomId)) {
                ListItem listItem = new ListItem();
                if (this.mLj.mNY.liveStyle == 0 || this.mLj.mNY.liveStyle == 1) {
                    listItem.mLiveType = "1";
                } else {
                    listItem.mLiveType = "2";
                }
                listItem.mType = "1";
                listItem.mTargetKey = this.mLj.mNY.mPkRoomId;
                com.kascend.chushou.d.e.a(this.mRJ, listItem, (JSONObject) null);
            }
        } else if (id == a.f.tv_pk_name && this.mLj != null && this.mLj.mNY != null && !tv.chushou.zues.utils.h.isEmpty(this.mLj.mNY.mPkUid)) {
            com.kascend.chushou.d.a.a(this.mRJ, (JSONObject) null, this.mLj.mNY.mPkRoomId, this.mLj.mNY.mPkUid, LoginManager.Instance().getUserInfo() != null ? String.valueOf(LoginManager.Instance().getUserInfo().mUserID) : "", false);
        }
    }

    @Override // com.kascend.chushou.player.e
    public boolean a(MotionEvent motionEvent) {
        if ((motionEvent.getAction() == 1 || motionEvent.getAction() == 3 || motionEvent.getAction() == 4) && this.k && this.mNX != null) {
            this.k = false;
            this.mjc = Math.min(this.mNX.getDuration(), Math.max(0, this.mNX.getCurrentPos() + this.j));
            if (this.mRK != null) {
                this.mRK.removeMessages(14);
                this.mRK.Ks(14);
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
            return (this.E && c(true)) || dFk();
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
        if (this.mRI != null) {
            if (this.ap < 0) {
                z = h.dEn().d;
            } else {
                z = h.dEn().e;
            }
        }
        if (z && this.mSw != null && this.mSw.getVisibility() == 0) {
            if (((VideoPlayer) this.mRJ).mJi == null || (colorPrivileges = ((VideoPlayer) this.mRJ).mJi.mColorPrivileges) == null || tv.chushou.zues.utils.h.isEmpty(colorPrivileges.mColors)) {
                arrayList = null;
            } else {
                arrayList = tv.chushou.zues.toolkit.richtext.b.Ss(tv.chushou.zues.toolkit.richtext.b.a(str, colorPrivileges.mColors, colorPrivileges.mWholeColor, new Random().nextInt(colorPrivileges.mColors.size())));
            }
            this.mSw.h(str, arrayList);
        }
    }

    public void f(int i) {
        com.kascend.chushou.c.c.dEj().a(i, new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.d.7
            @Override // com.kascend.chushou.c.b
            public void a() {
            }

            @Override // com.kascend.chushou.c.b
            public void a(String str, JSONObject jSONObject) {
                if (!d.this.dFS()) {
                    if (jSONObject != null) {
                        int optInt = jSONObject.optInt("data");
                        if (d.this.mRI != null && d.this.mRI.mKR != null) {
                            d.this.mRI.mKR.count = optInt;
                            d.this.M();
                        }
                        tv.chushou.zues.utils.g.KB(a.i.str_buy_trumpte_success);
                        return;
                    }
                    a(-1, "");
                }
            }

            @Override // com.kascend.chushou.c.b
            public void a(int i2, String str) {
                String str2;
                if (!d.this.dFS()) {
                    if (i2 == 401) {
                        com.kascend.chushou.d.e.b(d.this.mRJ, str);
                    } else if (i2 == 403) {
                        if (tv.chushou.zues.utils.h.isEmpty(str)) {
                            str = d.this.mRJ.getString(a.i.str_blacklist);
                        }
                        tv.chushou.zues.utils.g.c(d.this.mRJ, str);
                    } else if (i2 == 1027) {
                        if (!(d.this.mRJ instanceof VideoPlayer)) {
                            str2 = null;
                        } else {
                            str2 = ((VideoPlayer) d.this.mRJ).a((String) null);
                        }
                        com.kascend.chushou.d.e.a(d.this.getActivity(), str2);
                    } else if (tv.chushou.zues.utils.h.isEmpty(str)) {
                        tv.chushou.zues.utils.g.KB(a.i.str_buy_trumpte_failuer);
                    } else {
                        tv.chushou.zues.utils.g.u(str);
                    }
                }
            }
        });
    }

    public void a(String str, String str2) {
        com.kascend.chushou.c.c.dEj().c(str, str2, new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.d.8
            @Override // com.kascend.chushou.c.b
            public void a() {
            }

            @Override // com.kascend.chushou.c.b
            public void a(String str3, JSONObject jSONObject) {
                if (!d.this.dFS() && jSONObject != null) {
                    int optInt = jSONObject.optInt("data");
                    tv.chushou.zues.utils.g.KB(a.i.str_send_success);
                    if (d.this.mRI != null && d.this.mRI.mKR != null) {
                        d.this.mRI.mKR.count = optInt;
                        d.this.M();
                        return;
                    }
                    a(-1, "");
                }
            }

            @Override // com.kascend.chushou.c.b
            public void a(int i, String str3) {
                if (!d.this.dFS()) {
                    if (i == 401) {
                        com.kascend.chushou.d.e.b(d.this.mRJ, str3);
                    } else if (i == 403 && tv.chushou.zues.utils.h.isEmpty(str3)) {
                        str3 = d.this.mRJ.getString(a.i.str_blacklist);
                    }
                    if (tv.chushou.zues.utils.h.isEmpty(str3)) {
                        tv.chushou.zues.utils.g.F(d.this.mRJ, a.i.str_send_fail);
                    } else {
                        tv.chushou.zues.utils.g.c(d.this.mRJ, str3);
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void t() {
        final int gB = tv.chushou.zues.utils.systemBar.b.gB(getActivity());
        this.mLo.setOnActionListener(new VoiceInteractionView.b() { // from class: com.kascend.chushou.player.d.9
            @Override // com.kascend.chushou.widget.VoiceInteractionView.b
            public void a() {
                ListItem listItem = new ListItem();
                listItem.mUrl = com.kascend.chushou.c.c.a(50);
                d.this.a(listItem);
            }

            @Override // com.kascend.chushou.widget.VoiceInteractionView.b
            public void b() {
                com.kascend.chushou.d.e.a(d.this.mRJ, com.kascend.chushou.c.c.a(51) + "micRoomId=" + d.this.G);
            }

            @Override // com.kascend.chushou.widget.VoiceInteractionView.b
            public void a(int i, MicMemberInfo micMemberInfo, boolean z) {
                if (micMemberInfo != null) {
                    if (!z) {
                        com.kascend.chushou.d.a.a(d.this.mRJ, (JSONObject) null, (String) null, micMemberInfo.uid, LoginManager.Instance().getUserInfo() != null ? String.valueOf(LoginManager.Instance().getUserInfo().mUserID) : "", false);
                        return;
                    }
                    micMemberInfo.micRoomId = d.this.G;
                    if (d.this.ap == 0) {
                        boolean z2 = d.this.mSn == null;
                        d.this.a(false, false, micMemberInfo);
                        if (z2 && gB > 0 && d.this.mSn != null && tv.chushou.zues.utils.systemBar.b.ax(d.this.getActivity()) && tv.chushou.zues.utils.systemBar.b.ay(d.this.getActivity())) {
                            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) d.this.mSn.getLayoutParams();
                            layoutParams.rightMargin += gB;
                            d.this.mSn.setLayoutParams(layoutParams);
                            return;
                        }
                        return;
                    }
                    boolean z3 = d.this.mSn == null;
                    if (d.this.mRJ.getResources().getDisplayMetrics().density < 2.0f) {
                        d.this.a(true, false, micMemberInfo);
                    } else {
                        d.this.a(true, true, micMemberInfo);
                    }
                    if (z3 && gB > 0 && d.this.mSn != null) {
                        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) d.this.mSn.getLayoutParams();
                        layoutParams2.bottomMargin += gB;
                        d.this.mSn.setLayoutParams(layoutParams2);
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
        if (this.mRI.dEZ().mMicStatus.onMic != this.E) {
            this.E = this.mRI.dEZ().mMicStatus.onMic;
            u();
        }
        this.E = this.mRI.dEZ().mMicStatus.onMic;
        if (this.E) {
            if (this.mRI.dEZ().mMicStatus != null && !tv.chushou.zues.utils.h.isEmpty(this.mRI.dEZ().mMicStatus.micRoomId) && !this.mRI.dEZ().mMicStatus.micRoomId.equals("0")) {
                this.G = this.mRI.dEZ().mMicStatus.micRoomId;
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
            if (this.mLo != null) {
                b(true);
                this.mLo.setupCount(this.mRI.dEZ().mMicStatus.capacity - 1);
                this.mLo.a(this.mRI.dEZ().mMicStatus.isOngoing == 1, z, this.mRI.dEZ().mMicStatus.displayInteraction == 1);
                this.mLo.a(arrayList);
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

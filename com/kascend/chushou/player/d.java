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
    protected a nhf;
    protected com.kascend.chushou.widget.a.b nhh;
    protected tv.chushou.zues.utils.systemBar.a nhj;
    protected com.kascend.chushou.player.e.a nhl;
    protected com.kascend.chushou.player.e.b nhm;
    protected RelativeLayout nhn;
    protected VoiceInteractionView nhq;
    protected String u;
    protected TextView y;
    protected TextView z;
    protected ImageButton a = null;
    protected String b = null;
    private boolean nhg = false;
    protected boolean e = true;
    protected boolean f = false;
    protected TextView h = null;
    protected TextView i = null;
    protected int j = 0;
    protected boolean k = false;
    protected ProgressBar nhi = null;
    protected long m = 0;
    protected int n = 0;
    protected boolean p = false;
    private boolean nhk = false;
    protected boolean v = false;
    protected int w = -1;
    protected CycleLiveRoomInfo nho = null;
    protected io.reactivex.disposables.b nhp = null;
    protected boolean E = false;
    protected boolean F = false;
    private long nhr = 0;

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.nnJ = getActivity();
        if (aa()) {
            tv.chushou.zues.utils.e.e("VideoPlayerBaseFragment", "killed in backgroud");
            return;
        }
        Point gw = tv.chushou.zues.utils.a.gw(this.nnJ);
        q = Math.min(gw.x, gw.y) / 5;
        r = 200;
        this.nnL = (AudioManager) this.nnJ.getApplicationContext().getSystemService("audio");
        this.nhr = System.currentTimeMillis();
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
        dJP();
        ((VideoPlayer) this.nnJ).m = false;
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.ah = true;
        R();
        if (this.N != null && this.nke != null) {
            this.N.setVisibility(8);
        }
        if (this.nnK != null) {
            this.nnK.removeMessages(15);
        }
        a(false, false);
        if (this.nnK != null) {
            this.nnK.removeMessages(1);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // com.kascend.chushou.player.f, android.support.v4.app.Fragment
    public void onDestroy() {
        this.nns.dispose();
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view) {
        this.nnu = (RelativeLayout) view.findViewById(a.f.rl_audio);
        this.nnv = (FrescoThumbnailView) view.findViewById(a.f.iv_audio_bg);
        this.Q = (ImageView) view.findViewById(a.f.iv_audio_avator_bg);
        this.nnw = (FrescoThumbnailView) view.findViewById(a.f.iv_audio_avator);
        this.nnx = (TextView) view.findViewById(a.f.tv_audio_playing);
        this.nny = (TextView) view.findViewById(a.f.tv_open_video);
        this.nny.setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b() {
        this.nnE = (ProgressBar) this.nnt.findViewById(a.f.LoadingProgressBar);
        this.nnF = (TextView) this.nnt.findViewById(a.f.LoadingPercent);
        this.nnG = (TextView) this.nnt.findViewById(a.f.LoadingBuffer);
        this.nnH = (TextView) this.nnt.findViewById(a.f.tv_change_lines);
        this.nnE.setVisibility(8);
        this.nnF.setVisibility(8);
        this.nnG.setVisibility(8);
        this.nnH.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c() {
        this.nhn = (RelativeLayout) this.nnt.findViewById(a.f.rl_pk_name);
        this.y = (TextView) this.nnt.findViewById(a.f.tv_pk_name);
        this.z = (TextView) this.nnt.findViewById(a.f.tv_pk_subscribe);
        this.z.setOnClickListener(this);
        this.y.setOnClickListener(this);
        this.B = (TextView) this.nnt.findViewById(a.f.iv_cyclelive_countdown);
    }

    private void dJP() {
        if (i() || h()) {
            if (this.N != null) {
                this.N.setVisibility(0);
            }
            this.nke = ((VideoPlayer) this.nnJ).dJc();
            if (this.nke != null) {
                Uri uri = this.nke.getUri();
                Uri dJi = ((VideoPlayer) this.nnJ).dJi();
                if (!this.nnM) {
                    if (dJi != null && uri != null && !uri.equals(dJi)) {
                        ((VideoPlayer) this.nnJ).a(true, (Uri) null, false);
                    } else if (h.dIT().a) {
                        ((VideoPlayer) this.nnJ).a(true, (Uri) null, false);
                    } else if (((VideoPlayer) this.nnJ).m) {
                        if (h() && this.nnI.d()) {
                            if (!this.ai) {
                                ((VideoPlayer) this.nnJ).a(true, (Uri) null, false);
                                return;
                            }
                            return;
                        }
                        ((VideoPlayer) this.nnJ).a(true, (Uri) null, false);
                    } else {
                        AudioManager audioManager = ((VideoPlayer) this.nnJ).nfm;
                        VideoPlayer videoPlayer = (VideoPlayer) this.nnJ;
                        audioManager.setStreamVolume(3, VideoPlayer.n, 0);
                        if (this.nnI.d()) {
                            if (!this.ai) {
                                if (this.ap < 0) {
                                    if (this.nnI.d) {
                                        T();
                                        if (this.nnB != null) {
                                            this.nnB.setImageResource(a.e.ic_btn_room_video_n);
                                        }
                                    } else {
                                        U();
                                        S();
                                        if (this.nnA != null) {
                                            this.nnA.setVisibility(0);
                                        }
                                        if (this.nnB != null) {
                                            this.nnB.setImageResource(a.e.ic_btn_room_audio_n);
                                        }
                                    }
                                }
                                n(true);
                            }
                        } else if (!this.H && !this.al) {
                            ((VideoPlayer) this.nnJ).a(true, (Uri) null, false);
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d() {
        FullRoomInfo dJF;
        tv.chushou.zues.utils.e.e("VideoPlayerBaseFragment", "release <----------");
        if (this.B != null) {
            this.B.setVisibility(8);
        }
        if (this.nhp != null) {
            this.nhp.dispose();
            this.nhp = null;
        }
        if (this.nnI != null && (dJF = this.nnI.dJF()) != null && !tv.chushou.zues.utils.h.isEmpty(dJF.mGeneralTabGifts)) {
            for (int i = 0; i < dJF.mGeneralTabGifts.size(); i++) {
                GeneralTabGift generalTabGift = dJF.mGeneralTabGifts.get(i);
                if (generalTabGift != null && !tv.chushou.zues.utils.h.isEmpty(generalTabGift.mGeneralGifts)) {
                    for (int i2 = 0; i2 < generalTabGift.mGeneralGifts.size(); i2++) {
                        if (generalTabGift.mGeneralGifts.get(i2) != null) {
                            generalTabGift.mGeneralGifts.get(i2).mSelectFlag = false;
                        }
                    }
                }
            }
        }
        if (this.nog != null) {
            this.nog.clear();
            this.nog = null;
        }
        if (this.nhj != null) {
            this.nhj.setStatusBarTintEnabled(false);
            this.nhj.setNavigationBarTintEnabled(false);
        }
        if (this.nox != null) {
            this.nox.unInit();
            this.nox = null;
            dKE().removeAllViews();
        }
        if (this.noj != null) {
            ((ViewGroup) this.nnt).removeView(this.noj);
            this.noj = null;
        }
        if (this.noy != null) {
            this.noy.cancel();
            ArrayList<Animator> childAnimations = this.noy.getChildAnimations();
            if (!tv.chushou.zues.utils.h.isEmpty(childAnimations)) {
                Iterator<Animator> it = childAnimations.iterator();
                while (it.hasNext()) {
                    it.next().removeAllListeners();
                }
            }
            this.noy.removeAllListeners();
            this.noy = null;
        }
        this.nol = null;
        if (this.N != null) {
            ((ViewGroup) this.nnt).removeView(this.N);
            this.N = null;
        }
        if (this.nor != null) {
            this.nor.a();
            this.nor = null;
        }
        if (this.noD != null) {
            this.noD.dismiss();
        }
        if (this.noC != null) {
            this.noC.dismiss();
        }
        this.a = null;
        this.nnt = null;
        this.nnL = null;
        tv.chushou.zues.utils.e.i("VideoPlayerBaseFragment", "release ---------->");
    }

    @Override // com.kascend.chushou.player.e
    public void e() {
        this.H = false;
        this.nnM = false;
        m(true);
        x();
    }

    public void a(PrivilegeInfo privilegeInfo) {
        ((VideoPlayer) this.nnJ).nfj = privilegeInfo;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(String str) {
        ColorPrivileges colorPrivileges;
        ArrayList<RichText> arrayList = null;
        if (this.nnI != null && !tv.chushou.zues.utils.h.isEmpty(this.nnI.a) && this.nke != null) {
            com.kascend.chushou.c.c.dIP().a(new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.d.1
                @Override // com.kascend.chushou.c.b
                public void a() {
                }

                @Override // com.kascend.chushou.c.b
                public void a(String str2, JSONObject jSONObject) {
                    if (jSONObject != null) {
                        int optInt = jSONObject.optInt("code", -1);
                        String optString = jSONObject.optString("message");
                        if (optInt == 0) {
                            tv.chushou.zues.utils.g.F(d.this.nnJ, a.i.str_send_success);
                        } else {
                            a(optInt, optString);
                        }
                    }
                }

                @Override // com.kascend.chushou.c.b
                public void a(int i, String str2) {
                    if (!tv.chushou.zues.utils.h.isEmpty(str2)) {
                        tv.chushou.zues.utils.g.c(d.this.nnJ, str2);
                    } else {
                        tv.chushou.zues.utils.g.F(d.this.nnJ, a.i.str_send_fail);
                    }
                }
            }, this.nnI.a, str, (String) null, this.nke.getCurrentPos());
            if (this.nox != null && this.nox.getVisibility() == 0) {
                if (((VideoPlayer) this.nnJ).nfj != null && (colorPrivileges = ((VideoPlayer) this.nnJ).nfj.mColorPrivileges) != null && !tv.chushou.zues.utils.h.isEmpty(colorPrivileges.mColors)) {
                    arrayList = tv.chushou.zues.toolkit.richtext.b.Tf(tv.chushou.zues.toolkit.richtext.b.a(str, colorPrivileges.mColors, colorPrivileges.mWholeColor, new Random().nextInt(colorPrivileges.mColors.size())));
                }
                this.nox.h(str, arrayList);
            }
        }
    }

    public void a(String str, String str2, String str3, String str4) {
        ArrayList<RichText> arrayList;
        ColorPrivileges colorPrivileges;
        com.kascend.chushou.c.c.dIP().a(new JsonCallbackWrapper() { // from class: com.kascend.chushou.player.d.2
            @Override // tv.chushou.basis.http.listener.JsonCallbackWrapper
            public void callStart() {
            }

            @Override // tv.chushou.basis.http.listener.JsonCallbackWrapper
            public void callSuccess(String str5, JSONObject jSONObject) {
                if (!d.this.aa()) {
                    ParserRet dP = com.kascend.chushou.c.e.dP(jSONObject);
                    String str6 = dP.mMessage;
                    if (dP.mRc == 0) {
                        d.this.a((PrivilegeInfo) dP.mData);
                    } else {
                        callFailure(dP.mRc, str6, str5);
                    }
                }
            }

            @Override // tv.chushou.basis.http.listener.JsonCallbackWrapper
            public void callFailure(int i, @Nullable String str5, @Nullable String str6) {
                if (!d.this.aa()) {
                    if (i == 401) {
                        com.kascend.chushou.d.e.b(d.this.nnJ, str5);
                    } else if (i == 403) {
                        if (tv.chushou.zues.utils.h.isEmpty(str5)) {
                            str5 = d.this.nnJ.getString(a.i.str_blacklist);
                        }
                        tv.chushou.zues.utils.g.c(d.this.nnJ, str5);
                    } else if (i == 21001 && !tv.chushou.zues.utils.h.isEmpty(str6)) {
                        try {
                            ParserRet dP = com.kascend.chushou.c.e.dP(new JSONObject(str6));
                            if ((dP.mData1 instanceof String) && !TextUtils.isEmpty((String) dP.mData1)) {
                                ListItem listItem = new ListItem();
                                listItem.mType = "99";
                                listItem.mUrl = (String) dP.mData1;
                                com.kascend.chushou.d.e.a(d.this.nnJ, listItem, (JSONObject) null);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }, str, str3, str2, str4);
        boolean z = false;
        if (this.nnI != null) {
            if (this.ap < 0) {
                z = h.dIT().d;
            } else {
                z = h.dIT().e;
            }
        }
        if (z && this.nox != null && this.nox.getVisibility() == 0) {
            if (((VideoPlayer) this.nnJ).nfj == null || (colorPrivileges = ((VideoPlayer) this.nnJ).nfj.mColorPrivileges) == null || tv.chushou.zues.utils.h.isEmpty(colorPrivileges.mColors)) {
                arrayList = null;
            } else {
                arrayList = tv.chushou.zues.toolkit.richtext.b.Tf(tv.chushou.zues.toolkit.richtext.b.a(str2, colorPrivileges.mColors, colorPrivileges.mWholeColor, new Random().nextInt(colorPrivileges.mColors.size())));
            }
            this.nox.h(str2, arrayList);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void f() {
        if (this.nox != null) {
            this.nox.SN(h.dIT().b());
        }
    }

    public void a(PlayUrl playUrl) {
        if (playUrl == null || playUrl.mSelectedUrl.length() == 0) {
            if (this.noa != null) {
                this.noa.dismiss();
                this.noa = null;
            }
        } else if (this.noa != null) {
            LinearLayout linearLayout = (LinearLayout) this.noa.getContentView().findViewById(a.f.ll_pop_root);
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
        if (!c(true) && !dJR()) {
            dJQ();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dJQ() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    private boolean dJR() {
        RoomInfo dJI;
        if (this.nnI == null || (dJI = this.nnI.dJI()) == null || dJI.mIsSubscribed || aa()) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long dIY = h.dIT().dIY();
        if (currentTimeMillis - this.nhr <= 60000 || currentTimeMillis - dIY <= 86400000) {
            return false;
        }
        h.dIT().a(currentTimeMillis);
        final com.kascend.chushou.view.b.d Rs = com.kascend.chushou.view.b.d.Rs(dJI.mCreatorAvatar);
        Rs.show(getChildFragmentManager(), "showUnSubscirbeDialog");
        Rs.a(new d.a() { // from class: com.kascend.chushou.player.d.3
            @Override // com.kascend.chushou.view.b.d.a
            public void a() {
                if (com.kascend.chushou.d.e.c(d.this.nnJ, null)) {
                    com.kascend.chushou.c.c.dIP().a(new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.d.3.1
                        @Override // com.kascend.chushou.c.b
                        public void a() {
                        }

                        @Override // com.kascend.chushou.c.b
                        public void a(String str, JSONObject jSONObject) {
                            if (!d.this.aa()) {
                                tv.chushou.zues.utils.g.LI(a.i.subscribe_success);
                                d.this.dJQ();
                            }
                        }

                        @Override // com.kascend.chushou.c.b
                        public void a(int i, String str) {
                            if (!d.this.aa()) {
                                d.this.dJQ();
                            }
                        }
                    }, d.this.nnI.a, (String) null, "");
                }
            }

            @Override // com.kascend.chushou.view.b.d.a
            public void b() {
                Rs.dismissAllowingStateLoss();
                d.this.dJQ();
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
        if (this.nnI == null) {
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean i() {
        FullRoomInfo dJF;
        RoomInfo roomInfo;
        return (this.nnI == null || (dJF = this.nnI.dJF()) == null || (roomInfo = dJF.mRoominfo) == null || tv.chushou.zues.utils.h.isEmpty(roomInfo.mGameId)) ? false : true;
    }

    @Override // com.kascend.chushou.player.e
    public void j() {
        if (this.nox != null) {
            this.nox.dVU();
        }
        a((PlayUrl) null);
        m(true);
    }

    @Override // com.kascend.chushou.player.e
    public void a(b bVar) {
        com.kascend.chushou.player.b.a dKn = dKn();
        if (dKn != null) {
            dKn.a(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ParserRet parserRet) {
        SparseArray sparseArray;
        RoomInfo dJI;
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
                    if (this.nnJ instanceof VideoPlayer) {
                        ((VideoPlayer) this.nnJ).dJp().a(bangInfo);
                    }
                }
                if (sparseArray2.get(2) != null && (sparseArray2.get(2) instanceof ArrayList)) {
                    Iterator it = ((ArrayList) sparseArray2.get(2)).iterator();
                    while (it.hasNext()) {
                        com.kascend.chushou.player.ui.h5.c.a aVar = (com.kascend.chushou.player.ui.h5.c.a) it.next();
                        if (this.nnJ instanceof VideoPlayer) {
                            ((VideoPlayer) this.nnJ).c(aVar);
                        }
                    }
                }
                if (sparseArray2.get(3) != null && (sparseArray2.get(3) instanceof MicStatus) && this.nnI != null && this.nnI.dJF() != null) {
                    this.nnI.dJF().mMicStatus = (MicStatus) sparseArray2.get(3);
                    if (this.nnI.dJF().mMicStatus != null) {
                        if (this.nnI.dJF().mMicStatus.onMic) {
                            if (sparseArray2.get(4) != null && (sparseArray2.get(4) instanceof ArrayList) && LoginManager.Instance().getUserInfo() != null && !tv.chushou.zues.utils.h.isEmpty(LoginManager.Instance().getUserInfo().mUserID)) {
                                Iterator it2 = ((ArrayList) sparseArray2.get(4)).iterator();
                                while (true) {
                                    if (!it2.hasNext()) {
                                        z = false;
                                        break;
                                    }
                                    FanItem fanItem = (FanItem) it2.next();
                                    if (fanItem != null && String.valueOf(LoginManager.Instance().getUserInfo().mUserID).equals(fanItem.mUserId) && !String.valueOf(LoginManager.Instance().getUserInfo().mUserID).equals(this.nnI.dJF().mRoominfo.mCreatorUID)) {
                                        z = true;
                                        break;
                                    }
                                }
                                if (z) {
                                    this.J = 0.0f;
                                    if (this.nke != null) {
                                        this.nke.setVolume(this.J, this.J);
                                    }
                                } else if (this.nhk) {
                                    this.J = 1.0f;
                                    if (this.nke != null) {
                                        this.nke.setVolume(this.J, this.J);
                                    }
                                }
                                this.nhk = z;
                            }
                        } else if (this.nke != null && this.nhk) {
                            this.J = 1.0f;
                            this.nke.setVolume(this.J, this.J);
                        }
                    }
                }
                if (sparseArray2.get(5) != null) {
                    String obj = sparseArray2.get(5).toString();
                    if ("10003".equals(obj)) {
                        ((VideoPlayer) this.nnJ).t = "10003";
                        if (this.nke != null && "1".equals(this.aw) && !"2".equals(this.ay) && this.nke.getPlayState() != 4) {
                            j();
                            ((VideoPlayer) this.nnJ).m();
                        }
                    } else if ("10004".equals(obj)) {
                        tv.chushou.zues.utils.e.d("Rancune", "officeLine");
                        if (this.nnJ instanceof VideoPlayer) {
                            ((VideoPlayer) this.nnJ).t = "10004";
                            dKg();
                        }
                    }
                }
                if (sparseArray2.get(6) != null) {
                    List<com.kascend.chushou.player.ui.h5.c.e> list = (List) sparseArray2.get(6);
                    if (!tv.chushou.zues.utils.h.isEmpty(list)) {
                        ((VideoPlayer) this.nnJ).dJl().a(list);
                    }
                }
                if (sparseArray2.get(7) != null) {
                    ((VideoPlayer) this.nnJ).dJm().a((List) sparseArray2.get(7));
                }
                if (sparseArray2.get(11) != null) {
                    ((VideoPlayer) this.nnJ).dJn().a((com.kascend.chushou.player.ui.h5.c.c) sparseArray2.get(11));
                }
                if (sparseArray2.get(12) != null) {
                    AutoBang autoBang = (AutoBang) sparseArray2.get(12);
                    if (this.nnJ instanceof VideoPlayer) {
                        ((VideoPlayer) this.nnJ).dJp().a(autoBang);
                    }
                }
                if (sparseArray2.get(16) != null) {
                    com.kascend.chushou.player.ui.h5.c.b bVar = (com.kascend.chushou.player.ui.h5.c.b) sparseArray2.get(16);
                    if (this.nnJ instanceof VideoPlayer) {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(bVar);
                        ((VideoPlayer) this.nnJ).dJo().a(arrayList);
                    }
                }
                if (sparseArray2.get(19) != null && ((Boolean) sparseArray2.get(19)).booleanValue() && (this.nho == null || tv.chushou.zues.utils.h.isEmpty(this.nho.uid))) {
                    if (this.B != null) {
                        this.B.setVisibility(0);
                    }
                    if (this.nhp != null) {
                        this.nhp.dispose();
                        this.nhp = null;
                    }
                    this.nhp = io.reactivex.g.a(0L, 12L, 0L, 1L, TimeUnit.SECONDS).a(io.reactivex.a.b.a.dPw()).a(new io.reactivex.c.g<Long>() { // from class: com.kascend.chushou.player.d.4
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
                if (this.nnI != null) {
                    this.nnI.a(arrayList2);
                    if (((VideoPlayer) this.nnJ).q) {
                        if (sparseArray != null) {
                            if (sparseArray.get(1) != null) {
                                this.nnI.ngG.a((ArrayList) sparseArray.get(1));
                                if (this.nnK != null && !this.nnK.LA(11)) {
                                    this.nnK.R(this.nnK.LB(11));
                                }
                            }
                            if (sparseArray.get(2) != null) {
                                this.nnI.ngG.b((ArrayList) sparseArray.get(2));
                                if (this.nnK != null && !this.nnK.LA(12)) {
                                    this.nnK.R(this.nnK.LB(12));
                                }
                            }
                        } else if (this.nnI.ngG != null) {
                            if (this.nnI.ngG.d() && this.nnK != null && !this.nnK.LA(11)) {
                                this.nnK.R(this.nnK.LB(11));
                            }
                            if (this.nnI.ngG.h() && this.nnK != null && !this.nnK.LA(12)) {
                                this.nnK.R(this.nnK.LB(12));
                            }
                        }
                    }
                }
                if (arrayList2 != null && arrayList2.size() != 0) {
                    boolean z2 = false;
                    if (this.nnI != null) {
                        if (this.ap < 0) {
                            z2 = h.dIT().d;
                        } else {
                            z2 = h.dIT().e;
                        }
                    }
                    if (this.nox != null && z2 && this.nox.getVisibility() == 0) {
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
                                aVar2.oio.icon = next.mGift.icon;
                                if (next.mItem != null && !tv.chushou.zues.utils.h.isEmpty(next.mItem.mType) && this.nnI != null && ((dJI = this.nnI.dJI()) == null || !next.mItem.mType.equals("1") || !next.mItem.mTargetKey.equals(dJI.mRoomID))) {
                                    aVar2.tag = next.mItem;
                                }
                                this.nox.a(aVar2);
                            }
                        }
                    }
                    if (dKn() != null && (this.nnJ instanceof VideoPlayer) && ((VideoPlayer) this.nnJ).q) {
                        dKn().a(arrayList2);
                    }
                }
            }
        }
    }

    @Override // com.kascend.chushou.player.e
    public void k() {
        if (this.nnJ instanceof VideoPlayer) {
            if (((VideoPlayer) this.nnJ).q) {
                dKa().setVisibility(0);
            } else {
                dKa().setVisibility(8);
            }
        }
    }

    @Override // com.kascend.chushou.player.e
    public void l() {
        dKa().setVisibility(8);
    }

    @Override // com.kascend.chushou.player.e
    public void m() {
        com.kascend.chushou.player.b.a dKn = dKn();
        if (dKn != null) {
            dKn.b();
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
        if (!this.k && this.nhi != null) {
            try {
                if (this.nke != null) {
                    i = this.nke.getCurrentPos();
                    i2 = this.nke.getDuration();
                } else {
                    i = 0;
                }
                if (i2 > 1000) {
                    this.nhi.setProgress(i / (i2 / 1000));
                }
            } catch (NullPointerException e) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(boolean z, int i) {
        if (this.nhj != null) {
            if (z) {
                this.nhj.setStatusBarTintResource(i);
                this.nhj.setTintResource(i);
                this.nhj.setStatusBarTintEnabled(true);
                this.nhj.setNavigationBarTintEnabled(true);
                return;
            }
            this.nhj.setStatusBarTintEnabled(false);
            this.nhj.setNavigationBarTintEnabled(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(String str) {
        if (this.nnJ instanceof VideoPlayer) {
            str = ((VideoPlayer) this.nnJ).a(str);
        }
        com.kascend.chushou.d.a.c(this.nnJ, str);
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
            if (this.nhl != null && this.nhl.nkf != null && !tv.chushou.zues.utils.h.isEmpty(this.nhl.nkf.mPkRoomId)) {
                ListItem listItem = new ListItem();
                if (this.nhl.nkf.liveStyle == 0 || this.nhl.nkf.liveStyle == 1) {
                    listItem.mLiveType = "1";
                } else {
                    listItem.mLiveType = "2";
                }
                listItem.mType = "1";
                listItem.mTargetKey = this.nhl.nkf.mPkRoomId;
                com.kascend.chushou.d.e.a(this.nnJ, listItem, (JSONObject) null);
            }
        } else if (id == a.f.tv_pk_name && this.nhl != null && this.nhl.nkf != null && !tv.chushou.zues.utils.h.isEmpty(this.nhl.nkf.mPkUid)) {
            com.kascend.chushou.d.a.a(this.nnJ, (JSONObject) null, this.nhl.nkf.mPkRoomId, this.nhl.nkf.mPkUid, LoginManager.Instance().getUserInfo() != null ? String.valueOf(LoginManager.Instance().getUserInfo().mUserID) : "", false);
        }
    }

    @Override // com.kascend.chushou.player.e
    public boolean a(MotionEvent motionEvent) {
        if ((motionEvent.getAction() == 1 || motionEvent.getAction() == 3 || motionEvent.getAction() == 4) && this.k && this.nke != null) {
            this.k = false;
            this.mEY = Math.min(this.nke.getDuration(), Math.max(0, this.nke.getCurrentPos() + this.j));
            if (this.nnK != null) {
                this.nnK.removeMessages(14);
                this.nnK.Lz(14);
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
            return (this.E && c(true)) || dJR();
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
        if (this.nnI != null) {
            if (this.ap < 0) {
                z = h.dIT().d;
            } else {
                z = h.dIT().e;
            }
        }
        if (z && this.nox != null && this.nox.getVisibility() == 0) {
            if (((VideoPlayer) this.nnJ).nfj == null || (colorPrivileges = ((VideoPlayer) this.nnJ).nfj.mColorPrivileges) == null || tv.chushou.zues.utils.h.isEmpty(colorPrivileges.mColors)) {
                arrayList = null;
            } else {
                arrayList = tv.chushou.zues.toolkit.richtext.b.Tf(tv.chushou.zues.toolkit.richtext.b.a(str, colorPrivileges.mColors, colorPrivileges.mWholeColor, new Random().nextInt(colorPrivileges.mColors.size())));
            }
            this.nox.h(str, arrayList);
        }
    }

    public void f(int i) {
        com.kascend.chushou.c.c.dIP().a(i, new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.d.7
            @Override // com.kascend.chushou.c.b
            public void a() {
            }

            @Override // com.kascend.chushou.c.b
            public void a(String str, JSONObject jSONObject) {
                if (!d.this.aa()) {
                    if (jSONObject != null) {
                        int optInt = jSONObject.optInt("data");
                        if (d.this.nnI != null && d.this.nnI.ngT != null) {
                            d.this.nnI.ngT.count = optInt;
                            d.this.M();
                        }
                        tv.chushou.zues.utils.g.LI(a.i.str_buy_trumpte_success);
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
                        com.kascend.chushou.d.e.b(d.this.nnJ, str);
                    } else if (i2 == 403) {
                        if (tv.chushou.zues.utils.h.isEmpty(str)) {
                            str = d.this.nnJ.getString(a.i.str_blacklist);
                        }
                        tv.chushou.zues.utils.g.c(d.this.nnJ, str);
                    } else if (i2 == 1027) {
                        if (!(d.this.nnJ instanceof VideoPlayer)) {
                            str2 = null;
                        } else {
                            str2 = ((VideoPlayer) d.this.nnJ).a((String) null);
                        }
                        com.kascend.chushou.d.e.a(d.this.getActivity(), str2);
                    } else if (tv.chushou.zues.utils.h.isEmpty(str)) {
                        tv.chushou.zues.utils.g.LI(a.i.str_buy_trumpte_failuer);
                    } else {
                        tv.chushou.zues.utils.g.y(str);
                    }
                }
            }
        });
    }

    public void a(String str, String str2) {
        com.kascend.chushou.c.c.dIP().c(str, str2, new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.d.8
            @Override // com.kascend.chushou.c.b
            public void a() {
            }

            @Override // com.kascend.chushou.c.b
            public void a(String str3, JSONObject jSONObject) {
                if (!d.this.aa() && jSONObject != null) {
                    int optInt = jSONObject.optInt("data");
                    tv.chushou.zues.utils.g.LI(a.i.str_send_success);
                    if (d.this.nnI != null && d.this.nnI.ngT != null) {
                        d.this.nnI.ngT.count = optInt;
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
                        com.kascend.chushou.d.e.b(d.this.nnJ, str3);
                    } else if (i == 403 && tv.chushou.zues.utils.h.isEmpty(str3)) {
                        str3 = d.this.nnJ.getString(a.i.str_blacklist);
                    }
                    if (tv.chushou.zues.utils.h.isEmpty(str3)) {
                        tv.chushou.zues.utils.g.F(d.this.nnJ, a.i.str_send_fail);
                    } else {
                        tv.chushou.zues.utils.g.c(d.this.nnJ, str3);
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void t() {
        final int gC = tv.chushou.zues.utils.systemBar.b.gC(getActivity());
        this.nhq.setOnActionListener(new VoiceInteractionView.b() { // from class: com.kascend.chushou.player.d.9
            @Override // com.kascend.chushou.widget.VoiceInteractionView.b
            public void a() {
                ListItem listItem = new ListItem();
                listItem.mUrl = com.kascend.chushou.c.c.a(50);
                d.this.a(listItem);
            }

            @Override // com.kascend.chushou.widget.VoiceInteractionView.b
            public void b() {
                com.kascend.chushou.d.e.a(d.this.nnJ, com.kascend.chushou.c.c.a(51) + "micRoomId=" + d.this.G);
            }

            @Override // com.kascend.chushou.widget.VoiceInteractionView.b
            public void a(int i, MicMemberInfo micMemberInfo, boolean z) {
                if (micMemberInfo != null) {
                    if (!z) {
                        com.kascend.chushou.d.a.a(d.this.nnJ, (JSONObject) null, (String) null, micMemberInfo.uid, LoginManager.Instance().getUserInfo() != null ? String.valueOf(LoginManager.Instance().getUserInfo().mUserID) : "", false);
                        return;
                    }
                    micMemberInfo.micRoomId = d.this.G;
                    if (d.this.ap == 0) {
                        boolean z2 = d.this.non == null;
                        d.this.a(false, false, micMemberInfo);
                        if (z2 && gC > 0 && d.this.non != null && tv.chushou.zues.utils.systemBar.b.ax(d.this.getActivity()) && tv.chushou.zues.utils.systemBar.b.ay(d.this.getActivity())) {
                            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) d.this.non.getLayoutParams();
                            layoutParams.rightMargin += gC;
                            d.this.non.setLayoutParams(layoutParams);
                            return;
                        }
                        return;
                    }
                    boolean z3 = d.this.non == null;
                    if (d.this.nnJ.getResources().getDisplayMetrics().density < 2.0f) {
                        d.this.a(true, false, micMemberInfo);
                    } else {
                        d.this.a(true, true, micMemberInfo);
                    }
                    if (z3 && gC > 0 && d.this.non != null) {
                        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) d.this.non.getLayoutParams();
                        layoutParams2.bottomMargin += gC;
                        d.this.non.setLayoutParams(layoutParams2);
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
        if (this.nnI.dJF().mMicStatus.onMic != this.E) {
            this.E = this.nnI.dJF().mMicStatus.onMic;
            u();
        }
        this.E = this.nnI.dJF().mMicStatus.onMic;
        if (this.E) {
            if (this.nnI.dJF().mMicStatus != null && !tv.chushou.zues.utils.h.isEmpty(this.nnI.dJF().mMicStatus.micRoomId) && !this.nnI.dJF().mMicStatus.micRoomId.equals("0")) {
                this.G = this.nnI.dJF().mMicStatus.micRoomId;
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
            if (this.nhq != null) {
                b(true);
                this.nhq.setupCount(this.nnI.dJF().mMicStatus.capacity - 1);
                this.nhq.a(this.nnI.dJF().mMicStatus.isOngoing == 1, z, this.nnI.dJF().mMicStatus.displayInteraction == 1);
                this.nhq.a(arrayList);
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

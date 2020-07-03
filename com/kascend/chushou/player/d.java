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
    protected a nhc;
    protected com.kascend.chushou.widget.a.b nhe;
    protected tv.chushou.zues.utils.systemBar.a nhg;
    protected com.kascend.chushou.player.e.a nhi;
    protected com.kascend.chushou.player.e.b nhj;
    protected RelativeLayout nhk;
    protected VoiceInteractionView nhn;
    protected String u;
    protected TextView y;
    protected TextView z;
    protected ImageButton a = null;
    protected String b = null;
    private boolean nhd = false;
    protected boolean e = true;
    protected boolean f = false;
    protected TextView h = null;
    protected TextView i = null;
    protected int j = 0;
    protected boolean k = false;
    protected ProgressBar nhf = null;
    protected long m = 0;
    protected int n = 0;
    protected boolean p = false;
    private boolean nhh = false;
    protected boolean v = false;
    protected int w = -1;
    protected CycleLiveRoomInfo nhl = null;
    protected io.reactivex.disposables.b nhm = null;
    protected boolean E = false;
    protected boolean F = false;
    private long nho = 0;

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.nnG = getActivity();
        if (aa()) {
            tv.chushou.zues.utils.e.e("VideoPlayerBaseFragment", "killed in backgroud");
            return;
        }
        Point gw = tv.chushou.zues.utils.a.gw(this.nnG);
        q = Math.min(gw.x, gw.y) / 5;
        r = 200;
        this.nnI = (AudioManager) this.nnG.getApplicationContext().getSystemService("audio");
        this.nho = System.currentTimeMillis();
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
        dJL();
        ((VideoPlayer) this.nnG).m = false;
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.ah = true;
        R();
        if (this.N != null && this.nkb != null) {
            this.N.setVisibility(8);
        }
        if (this.nnH != null) {
            this.nnH.removeMessages(15);
        }
        a(false, false);
        if (this.nnH != null) {
            this.nnH.removeMessages(1);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // com.kascend.chushou.player.f, android.support.v4.app.Fragment
    public void onDestroy() {
        this.nnp.dispose();
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view) {
        this.nnr = (RelativeLayout) view.findViewById(a.f.rl_audio);
        this.nns = (FrescoThumbnailView) view.findViewById(a.f.iv_audio_bg);
        this.Q = (ImageView) view.findViewById(a.f.iv_audio_avator_bg);
        this.nnt = (FrescoThumbnailView) view.findViewById(a.f.iv_audio_avator);
        this.nnu = (TextView) view.findViewById(a.f.tv_audio_playing);
        this.nnv = (TextView) view.findViewById(a.f.tv_open_video);
        this.nnv.setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b() {
        this.nnB = (ProgressBar) this.nnq.findViewById(a.f.LoadingProgressBar);
        this.nnC = (TextView) this.nnq.findViewById(a.f.LoadingPercent);
        this.nnD = (TextView) this.nnq.findViewById(a.f.LoadingBuffer);
        this.nnE = (TextView) this.nnq.findViewById(a.f.tv_change_lines);
        this.nnB.setVisibility(8);
        this.nnC.setVisibility(8);
        this.nnD.setVisibility(8);
        this.nnE.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c() {
        this.nhk = (RelativeLayout) this.nnq.findViewById(a.f.rl_pk_name);
        this.y = (TextView) this.nnq.findViewById(a.f.tv_pk_name);
        this.z = (TextView) this.nnq.findViewById(a.f.tv_pk_subscribe);
        this.z.setOnClickListener(this);
        this.y.setOnClickListener(this);
        this.B = (TextView) this.nnq.findViewById(a.f.iv_cyclelive_countdown);
    }

    private void dJL() {
        if (i() || h()) {
            if (this.N != null) {
                this.N.setVisibility(0);
            }
            this.nkb = ((VideoPlayer) this.nnG).dIY();
            if (this.nkb != null) {
                Uri uri = this.nkb.getUri();
                Uri dJe = ((VideoPlayer) this.nnG).dJe();
                if (!this.nnJ) {
                    if (dJe != null && uri != null && !uri.equals(dJe)) {
                        ((VideoPlayer) this.nnG).a(true, (Uri) null, false);
                    } else if (h.dIP().a) {
                        ((VideoPlayer) this.nnG).a(true, (Uri) null, false);
                    } else if (((VideoPlayer) this.nnG).m) {
                        if (h() && this.nnF.d()) {
                            if (!this.ai) {
                                ((VideoPlayer) this.nnG).a(true, (Uri) null, false);
                                return;
                            }
                            return;
                        }
                        ((VideoPlayer) this.nnG).a(true, (Uri) null, false);
                    } else {
                        AudioManager audioManager = ((VideoPlayer) this.nnG).nfj;
                        VideoPlayer videoPlayer = (VideoPlayer) this.nnG;
                        audioManager.setStreamVolume(3, VideoPlayer.n, 0);
                        if (this.nnF.d()) {
                            if (!this.ai) {
                                if (this.ap < 0) {
                                    if (this.nnF.d) {
                                        T();
                                        if (this.nny != null) {
                                            this.nny.setImageResource(a.e.ic_btn_room_video_n);
                                        }
                                    } else {
                                        U();
                                        S();
                                        if (this.nnx != null) {
                                            this.nnx.setVisibility(0);
                                        }
                                        if (this.nny != null) {
                                            this.nny.setImageResource(a.e.ic_btn_room_audio_n);
                                        }
                                    }
                                }
                                n(true);
                            }
                        } else if (!this.H && !this.al) {
                            ((VideoPlayer) this.nnG).a(true, (Uri) null, false);
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d() {
        FullRoomInfo dJB;
        tv.chushou.zues.utils.e.e("VideoPlayerBaseFragment", "release <----------");
        if (this.B != null) {
            this.B.setVisibility(8);
        }
        if (this.nhm != null) {
            this.nhm.dispose();
            this.nhm = null;
        }
        if (this.nnF != null && (dJB = this.nnF.dJB()) != null && !tv.chushou.zues.utils.h.isEmpty(dJB.mGeneralTabGifts)) {
            for (int i = 0; i < dJB.mGeneralTabGifts.size(); i++) {
                GeneralTabGift generalTabGift = dJB.mGeneralTabGifts.get(i);
                if (generalTabGift != null && !tv.chushou.zues.utils.h.isEmpty(generalTabGift.mGeneralGifts)) {
                    for (int i2 = 0; i2 < generalTabGift.mGeneralGifts.size(); i2++) {
                        if (generalTabGift.mGeneralGifts.get(i2) != null) {
                            generalTabGift.mGeneralGifts.get(i2).mSelectFlag = false;
                        }
                    }
                }
            }
        }
        if (this.nod != null) {
            this.nod.clear();
            this.nod = null;
        }
        if (this.nhg != null) {
            this.nhg.setStatusBarTintEnabled(false);
            this.nhg.setNavigationBarTintEnabled(false);
        }
        if (this.nos != null) {
            this.nos.unInit();
            this.nos = null;
            dKA().removeAllViews();
        }
        if (this.nog != null) {
            ((ViewGroup) this.nnq).removeView(this.nog);
            this.nog = null;
        }
        if (this.nou != null) {
            this.nou.cancel();
            ArrayList<Animator> childAnimations = this.nou.getChildAnimations();
            if (!tv.chushou.zues.utils.h.isEmpty(childAnimations)) {
                Iterator<Animator> it = childAnimations.iterator();
                while (it.hasNext()) {
                    it.next().removeAllListeners();
                }
            }
            this.nou.removeAllListeners();
            this.nou = null;
        }
        this.noi = null;
        if (this.N != null) {
            ((ViewGroup) this.nnq).removeView(this.N);
            this.N = null;
        }
        if (this.noo != null) {
            this.noo.a();
            this.noo = null;
        }
        if (this.noA != null) {
            this.noA.dismiss();
        }
        if (this.noz != null) {
            this.noz.dismiss();
        }
        this.a = null;
        this.nnq = null;
        this.nnI = null;
        tv.chushou.zues.utils.e.i("VideoPlayerBaseFragment", "release ---------->");
    }

    @Override // com.kascend.chushou.player.e
    public void e() {
        this.H = false;
        this.nnJ = false;
        m(true);
        x();
    }

    public void a(PrivilegeInfo privilegeInfo) {
        ((VideoPlayer) this.nnG).nfg = privilegeInfo;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(String str) {
        ColorPrivileges colorPrivileges;
        ArrayList<RichText> arrayList = null;
        if (this.nnF != null && !tv.chushou.zues.utils.h.isEmpty(this.nnF.a) && this.nkb != null) {
            com.kascend.chushou.c.c.dIL().a(new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.d.1
                @Override // com.kascend.chushou.c.b
                public void a() {
                }

                @Override // com.kascend.chushou.c.b
                public void a(String str2, JSONObject jSONObject) {
                    if (jSONObject != null) {
                        int optInt = jSONObject.optInt("code", -1);
                        String optString = jSONObject.optString("message");
                        if (optInt == 0) {
                            tv.chushou.zues.utils.g.F(d.this.nnG, a.i.str_send_success);
                        } else {
                            a(optInt, optString);
                        }
                    }
                }

                @Override // com.kascend.chushou.c.b
                public void a(int i, String str2) {
                    if (!tv.chushou.zues.utils.h.isEmpty(str2)) {
                        tv.chushou.zues.utils.g.c(d.this.nnG, str2);
                    } else {
                        tv.chushou.zues.utils.g.F(d.this.nnG, a.i.str_send_fail);
                    }
                }
            }, this.nnF.a, str, (String) null, this.nkb.getCurrentPos());
            if (this.nos != null && this.nos.getVisibility() == 0) {
                if (((VideoPlayer) this.nnG).nfg != null && (colorPrivileges = ((VideoPlayer) this.nnG).nfg.mColorPrivileges) != null && !tv.chushou.zues.utils.h.isEmpty(colorPrivileges.mColors)) {
                    arrayList = tv.chushou.zues.toolkit.richtext.b.Te(tv.chushou.zues.toolkit.richtext.b.a(str, colorPrivileges.mColors, colorPrivileges.mWholeColor, new Random().nextInt(colorPrivileges.mColors.size())));
                }
                this.nos.h(str, arrayList);
            }
        }
    }

    public void a(String str, String str2, String str3, String str4) {
        ArrayList<RichText> arrayList;
        ColorPrivileges colorPrivileges;
        com.kascend.chushou.c.c.dIL().a(new JsonCallbackWrapper() { // from class: com.kascend.chushou.player.d.2
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
                        com.kascend.chushou.d.e.b(d.this.nnG, str5);
                    } else if (i == 403) {
                        if (tv.chushou.zues.utils.h.isEmpty(str5)) {
                            str5 = d.this.nnG.getString(a.i.str_blacklist);
                        }
                        tv.chushou.zues.utils.g.c(d.this.nnG, str5);
                    } else if (i == 21001 && !tv.chushou.zues.utils.h.isEmpty(str6)) {
                        try {
                            ParserRet dP = com.kascend.chushou.c.e.dP(new JSONObject(str6));
                            if ((dP.mData1 instanceof String) && !TextUtils.isEmpty((String) dP.mData1)) {
                                ListItem listItem = new ListItem();
                                listItem.mType = "99";
                                listItem.mUrl = (String) dP.mData1;
                                com.kascend.chushou.d.e.a(d.this.nnG, listItem, (JSONObject) null);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }, str, str3, str2, str4);
        boolean z = false;
        if (this.nnF != null) {
            if (this.ap < 0) {
                z = h.dIP().d;
            } else {
                z = h.dIP().e;
            }
        }
        if (z && this.nos != null && this.nos.getVisibility() == 0) {
            if (((VideoPlayer) this.nnG).nfg == null || (colorPrivileges = ((VideoPlayer) this.nnG).nfg.mColorPrivileges) == null || tv.chushou.zues.utils.h.isEmpty(colorPrivileges.mColors)) {
                arrayList = null;
            } else {
                arrayList = tv.chushou.zues.toolkit.richtext.b.Te(tv.chushou.zues.toolkit.richtext.b.a(str2, colorPrivileges.mColors, colorPrivileges.mWholeColor, new Random().nextInt(colorPrivileges.mColors.size())));
            }
            this.nos.h(str2, arrayList);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void f() {
        if (this.nos != null) {
            this.nos.SM(h.dIP().b());
        }
    }

    public void a(PlayUrl playUrl) {
        if (playUrl == null || playUrl.mSelectedUrl.length() == 0) {
            if (this.nnX != null) {
                this.nnX.dismiss();
                this.nnX = null;
            }
        } else if (this.nnX != null) {
            LinearLayout linearLayout = (LinearLayout) this.nnX.getContentView().findViewById(a.f.ll_pop_root);
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
        if (!c(true) && !dJN()) {
            dJM();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dJM() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    private boolean dJN() {
        RoomInfo dJE;
        if (this.nnF == null || (dJE = this.nnF.dJE()) == null || dJE.mIsSubscribed || aa()) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long dIU = h.dIP().dIU();
        if (currentTimeMillis - this.nho <= 60000 || currentTimeMillis - dIU <= 86400000) {
            return false;
        }
        h.dIP().a(currentTimeMillis);
        final com.kascend.chushou.view.b.d Rr = com.kascend.chushou.view.b.d.Rr(dJE.mCreatorAvatar);
        Rr.show(getChildFragmentManager(), "showUnSubscirbeDialog");
        Rr.a(new d.a() { // from class: com.kascend.chushou.player.d.3
            @Override // com.kascend.chushou.view.b.d.a
            public void a() {
                if (com.kascend.chushou.d.e.c(d.this.nnG, null)) {
                    com.kascend.chushou.c.c.dIL().a(new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.d.3.1
                        @Override // com.kascend.chushou.c.b
                        public void a() {
                        }

                        @Override // com.kascend.chushou.c.b
                        public void a(String str, JSONObject jSONObject) {
                            if (!d.this.aa()) {
                                tv.chushou.zues.utils.g.LI(a.i.subscribe_success);
                                d.this.dJM();
                            }
                        }

                        @Override // com.kascend.chushou.c.b
                        public void a(int i, String str) {
                            if (!d.this.aa()) {
                                d.this.dJM();
                            }
                        }
                    }, d.this.nnF.a, (String) null, "");
                }
            }

            @Override // com.kascend.chushou.view.b.d.a
            public void b() {
                Rr.dismissAllowingStateLoss();
                d.this.dJM();
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
        if (this.nnF == null) {
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean i() {
        FullRoomInfo dJB;
        RoomInfo roomInfo;
        return (this.nnF == null || (dJB = this.nnF.dJB()) == null || (roomInfo = dJB.mRoominfo) == null || tv.chushou.zues.utils.h.isEmpty(roomInfo.mGameId)) ? false : true;
    }

    @Override // com.kascend.chushou.player.e
    public void j() {
        if (this.nos != null) {
            this.nos.dVQ();
        }
        a((PlayUrl) null);
        m(true);
    }

    @Override // com.kascend.chushou.player.e
    public void a(b bVar) {
        com.kascend.chushou.player.b.a dKj = dKj();
        if (dKj != null) {
            dKj.a(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ParserRet parserRet) {
        SparseArray sparseArray;
        RoomInfo dJE;
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
                    if (this.nnG instanceof VideoPlayer) {
                        ((VideoPlayer) this.nnG).dJl().a(bangInfo);
                    }
                }
                if (sparseArray2.get(2) != null && (sparseArray2.get(2) instanceof ArrayList)) {
                    Iterator it = ((ArrayList) sparseArray2.get(2)).iterator();
                    while (it.hasNext()) {
                        com.kascend.chushou.player.ui.h5.c.a aVar = (com.kascend.chushou.player.ui.h5.c.a) it.next();
                        if (this.nnG instanceof VideoPlayer) {
                            ((VideoPlayer) this.nnG).c(aVar);
                        }
                    }
                }
                if (sparseArray2.get(3) != null && (sparseArray2.get(3) instanceof MicStatus) && this.nnF != null && this.nnF.dJB() != null) {
                    this.nnF.dJB().mMicStatus = (MicStatus) sparseArray2.get(3);
                    if (this.nnF.dJB().mMicStatus != null) {
                        if (this.nnF.dJB().mMicStatus.onMic) {
                            if (sparseArray2.get(4) != null && (sparseArray2.get(4) instanceof ArrayList) && LoginManager.Instance().getUserInfo() != null && !tv.chushou.zues.utils.h.isEmpty(LoginManager.Instance().getUserInfo().mUserID)) {
                                Iterator it2 = ((ArrayList) sparseArray2.get(4)).iterator();
                                while (true) {
                                    if (!it2.hasNext()) {
                                        z = false;
                                        break;
                                    }
                                    FanItem fanItem = (FanItem) it2.next();
                                    if (fanItem != null && String.valueOf(LoginManager.Instance().getUserInfo().mUserID).equals(fanItem.mUserId) && !String.valueOf(LoginManager.Instance().getUserInfo().mUserID).equals(this.nnF.dJB().mRoominfo.mCreatorUID)) {
                                        z = true;
                                        break;
                                    }
                                }
                                if (z) {
                                    this.J = 0.0f;
                                    if (this.nkb != null) {
                                        this.nkb.setVolume(this.J, this.J);
                                    }
                                } else if (this.nhh) {
                                    this.J = 1.0f;
                                    if (this.nkb != null) {
                                        this.nkb.setVolume(this.J, this.J);
                                    }
                                }
                                this.nhh = z;
                            }
                        } else if (this.nkb != null && this.nhh) {
                            this.J = 1.0f;
                            this.nkb.setVolume(this.J, this.J);
                        }
                    }
                }
                if (sparseArray2.get(5) != null) {
                    String obj = sparseArray2.get(5).toString();
                    if ("10003".equals(obj)) {
                        ((VideoPlayer) this.nnG).t = "10003";
                        if (this.nkb != null && "1".equals(this.aw) && !"2".equals(this.ay) && this.nkb.getPlayState() != 4) {
                            j();
                            ((VideoPlayer) this.nnG).m();
                        }
                    } else if ("10004".equals(obj)) {
                        tv.chushou.zues.utils.e.d("Rancune", "officeLine");
                        if (this.nnG instanceof VideoPlayer) {
                            ((VideoPlayer) this.nnG).t = "10004";
                            dKc();
                        }
                    }
                }
                if (sparseArray2.get(6) != null) {
                    List<com.kascend.chushou.player.ui.h5.c.e> list = (List) sparseArray2.get(6);
                    if (!tv.chushou.zues.utils.h.isEmpty(list)) {
                        ((VideoPlayer) this.nnG).dJh().a(list);
                    }
                }
                if (sparseArray2.get(7) != null) {
                    ((VideoPlayer) this.nnG).dJi().a((List) sparseArray2.get(7));
                }
                if (sparseArray2.get(11) != null) {
                    ((VideoPlayer) this.nnG).dJj().a((com.kascend.chushou.player.ui.h5.c.c) sparseArray2.get(11));
                }
                if (sparseArray2.get(12) != null) {
                    AutoBang autoBang = (AutoBang) sparseArray2.get(12);
                    if (this.nnG instanceof VideoPlayer) {
                        ((VideoPlayer) this.nnG).dJl().a(autoBang);
                    }
                }
                if (sparseArray2.get(16) != null) {
                    com.kascend.chushou.player.ui.h5.c.b bVar = (com.kascend.chushou.player.ui.h5.c.b) sparseArray2.get(16);
                    if (this.nnG instanceof VideoPlayer) {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(bVar);
                        ((VideoPlayer) this.nnG).dJk().a(arrayList);
                    }
                }
                if (sparseArray2.get(19) != null && ((Boolean) sparseArray2.get(19)).booleanValue() && (this.nhl == null || tv.chushou.zues.utils.h.isEmpty(this.nhl.uid))) {
                    if (this.B != null) {
                        this.B.setVisibility(0);
                    }
                    if (this.nhm != null) {
                        this.nhm.dispose();
                        this.nhm = null;
                    }
                    this.nhm = io.reactivex.g.a(0L, 12L, 0L, 1L, TimeUnit.SECONDS).a(io.reactivex.a.b.a.dPs()).a(new io.reactivex.c.g<Long>() { // from class: com.kascend.chushou.player.d.4
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
                if (this.nnF != null) {
                    this.nnF.a(arrayList2);
                    if (((VideoPlayer) this.nnG).q) {
                        if (sparseArray != null) {
                            if (sparseArray.get(1) != null) {
                                this.nnF.ngD.a((ArrayList) sparseArray.get(1));
                                if (this.nnH != null && !this.nnH.LA(11)) {
                                    this.nnH.R(this.nnH.LB(11));
                                }
                            }
                            if (sparseArray.get(2) != null) {
                                this.nnF.ngD.b((ArrayList) sparseArray.get(2));
                                if (this.nnH != null && !this.nnH.LA(12)) {
                                    this.nnH.R(this.nnH.LB(12));
                                }
                            }
                        } else if (this.nnF.ngD != null) {
                            if (this.nnF.ngD.d() && this.nnH != null && !this.nnH.LA(11)) {
                                this.nnH.R(this.nnH.LB(11));
                            }
                            if (this.nnF.ngD.h() && this.nnH != null && !this.nnH.LA(12)) {
                                this.nnH.R(this.nnH.LB(12));
                            }
                        }
                    }
                }
                if (arrayList2 != null && arrayList2.size() != 0) {
                    boolean z2 = false;
                    if (this.nnF != null) {
                        if (this.ap < 0) {
                            z2 = h.dIP().d;
                        } else {
                            z2 = h.dIP().e;
                        }
                    }
                    if (this.nos != null && z2 && this.nos.getVisibility() == 0) {
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
                                aVar2.oil.icon = next.mGift.icon;
                                if (next.mItem != null && !tv.chushou.zues.utils.h.isEmpty(next.mItem.mType) && this.nnF != null && ((dJE = this.nnF.dJE()) == null || !next.mItem.mType.equals("1") || !next.mItem.mTargetKey.equals(dJE.mRoomID))) {
                                    aVar2.tag = next.mItem;
                                }
                                this.nos.a(aVar2);
                            }
                        }
                    }
                    if (dKj() != null && (this.nnG instanceof VideoPlayer) && ((VideoPlayer) this.nnG).q) {
                        dKj().a(arrayList2);
                    }
                }
            }
        }
    }

    @Override // com.kascend.chushou.player.e
    public void k() {
        if (this.nnG instanceof VideoPlayer) {
            if (((VideoPlayer) this.nnG).q) {
                dJW().setVisibility(0);
            } else {
                dJW().setVisibility(8);
            }
        }
    }

    @Override // com.kascend.chushou.player.e
    public void l() {
        dJW().setVisibility(8);
    }

    @Override // com.kascend.chushou.player.e
    public void m() {
        com.kascend.chushou.player.b.a dKj = dKj();
        if (dKj != null) {
            dKj.b();
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
        if (!this.k && this.nhf != null) {
            try {
                if (this.nkb != null) {
                    i = this.nkb.getCurrentPos();
                    i2 = this.nkb.getDuration();
                } else {
                    i = 0;
                }
                if (i2 > 1000) {
                    this.nhf.setProgress(i / (i2 / 1000));
                }
            } catch (NullPointerException e) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(boolean z, int i) {
        if (this.nhg != null) {
            if (z) {
                this.nhg.setStatusBarTintResource(i);
                this.nhg.setTintResource(i);
                this.nhg.setStatusBarTintEnabled(true);
                this.nhg.setNavigationBarTintEnabled(true);
                return;
            }
            this.nhg.setStatusBarTintEnabled(false);
            this.nhg.setNavigationBarTintEnabled(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(String str) {
        if (this.nnG instanceof VideoPlayer) {
            str = ((VideoPlayer) this.nnG).a(str);
        }
        com.kascend.chushou.d.a.c(this.nnG, str);
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
            if (this.nhi != null && this.nhi.nkc != null && !tv.chushou.zues.utils.h.isEmpty(this.nhi.nkc.mPkRoomId)) {
                ListItem listItem = new ListItem();
                if (this.nhi.nkc.liveStyle == 0 || this.nhi.nkc.liveStyle == 1) {
                    listItem.mLiveType = "1";
                } else {
                    listItem.mLiveType = "2";
                }
                listItem.mType = "1";
                listItem.mTargetKey = this.nhi.nkc.mPkRoomId;
                com.kascend.chushou.d.e.a(this.nnG, listItem, (JSONObject) null);
            }
        } else if (id == a.f.tv_pk_name && this.nhi != null && this.nhi.nkc != null && !tv.chushou.zues.utils.h.isEmpty(this.nhi.nkc.mPkUid)) {
            com.kascend.chushou.d.a.a(this.nnG, (JSONObject) null, this.nhi.nkc.mPkRoomId, this.nhi.nkc.mPkUid, LoginManager.Instance().getUserInfo() != null ? String.valueOf(LoginManager.Instance().getUserInfo().mUserID) : "", false);
        }
    }

    @Override // com.kascend.chushou.player.e
    public boolean a(MotionEvent motionEvent) {
        if ((motionEvent.getAction() == 1 || motionEvent.getAction() == 3 || motionEvent.getAction() == 4) && this.k && this.nkb != null) {
            this.k = false;
            this.mEV = Math.min(this.nkb.getDuration(), Math.max(0, this.nkb.getCurrentPos() + this.j));
            if (this.nnH != null) {
                this.nnH.removeMessages(14);
                this.nnH.Lz(14);
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
            return (this.E && c(true)) || dJN();
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
        if (this.nnF != null) {
            if (this.ap < 0) {
                z = h.dIP().d;
            } else {
                z = h.dIP().e;
            }
        }
        if (z && this.nos != null && this.nos.getVisibility() == 0) {
            if (((VideoPlayer) this.nnG).nfg == null || (colorPrivileges = ((VideoPlayer) this.nnG).nfg.mColorPrivileges) == null || tv.chushou.zues.utils.h.isEmpty(colorPrivileges.mColors)) {
                arrayList = null;
            } else {
                arrayList = tv.chushou.zues.toolkit.richtext.b.Te(tv.chushou.zues.toolkit.richtext.b.a(str, colorPrivileges.mColors, colorPrivileges.mWholeColor, new Random().nextInt(colorPrivileges.mColors.size())));
            }
            this.nos.h(str, arrayList);
        }
    }

    public void f(int i) {
        com.kascend.chushou.c.c.dIL().a(i, new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.d.7
            @Override // com.kascend.chushou.c.b
            public void a() {
            }

            @Override // com.kascend.chushou.c.b
            public void a(String str, JSONObject jSONObject) {
                if (!d.this.aa()) {
                    if (jSONObject != null) {
                        int optInt = jSONObject.optInt("data");
                        if (d.this.nnF != null && d.this.nnF.ngQ != null) {
                            d.this.nnF.ngQ.count = optInt;
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
                        com.kascend.chushou.d.e.b(d.this.nnG, str);
                    } else if (i2 == 403) {
                        if (tv.chushou.zues.utils.h.isEmpty(str)) {
                            str = d.this.nnG.getString(a.i.str_blacklist);
                        }
                        tv.chushou.zues.utils.g.c(d.this.nnG, str);
                    } else if (i2 == 1027) {
                        if (!(d.this.nnG instanceof VideoPlayer)) {
                            str2 = null;
                        } else {
                            str2 = ((VideoPlayer) d.this.nnG).a((String) null);
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
        com.kascend.chushou.c.c.dIL().c(str, str2, new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.d.8
            @Override // com.kascend.chushou.c.b
            public void a() {
            }

            @Override // com.kascend.chushou.c.b
            public void a(String str3, JSONObject jSONObject) {
                if (!d.this.aa() && jSONObject != null) {
                    int optInt = jSONObject.optInt("data");
                    tv.chushou.zues.utils.g.LI(a.i.str_send_success);
                    if (d.this.nnF != null && d.this.nnF.ngQ != null) {
                        d.this.nnF.ngQ.count = optInt;
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
                        com.kascend.chushou.d.e.b(d.this.nnG, str3);
                    } else if (i == 403 && tv.chushou.zues.utils.h.isEmpty(str3)) {
                        str3 = d.this.nnG.getString(a.i.str_blacklist);
                    }
                    if (tv.chushou.zues.utils.h.isEmpty(str3)) {
                        tv.chushou.zues.utils.g.F(d.this.nnG, a.i.str_send_fail);
                    } else {
                        tv.chushou.zues.utils.g.c(d.this.nnG, str3);
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void t() {
        final int gC = tv.chushou.zues.utils.systemBar.b.gC(getActivity());
        this.nhn.setOnActionListener(new VoiceInteractionView.b() { // from class: com.kascend.chushou.player.d.9
            @Override // com.kascend.chushou.widget.VoiceInteractionView.b
            public void a() {
                ListItem listItem = new ListItem();
                listItem.mUrl = com.kascend.chushou.c.c.a(50);
                d.this.a(listItem);
            }

            @Override // com.kascend.chushou.widget.VoiceInteractionView.b
            public void b() {
                com.kascend.chushou.d.e.a(d.this.nnG, com.kascend.chushou.c.c.a(51) + "micRoomId=" + d.this.G);
            }

            @Override // com.kascend.chushou.widget.VoiceInteractionView.b
            public void a(int i, MicMemberInfo micMemberInfo, boolean z) {
                if (micMemberInfo != null) {
                    if (!z) {
                        com.kascend.chushou.d.a.a(d.this.nnG, (JSONObject) null, (String) null, micMemberInfo.uid, LoginManager.Instance().getUserInfo() != null ? String.valueOf(LoginManager.Instance().getUserInfo().mUserID) : "", false);
                        return;
                    }
                    micMemberInfo.micRoomId = d.this.G;
                    if (d.this.ap == 0) {
                        boolean z2 = d.this.nok == null;
                        d.this.a(false, false, micMemberInfo);
                        if (z2 && gC > 0 && d.this.nok != null && tv.chushou.zues.utils.systemBar.b.ax(d.this.getActivity()) && tv.chushou.zues.utils.systemBar.b.ay(d.this.getActivity())) {
                            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) d.this.nok.getLayoutParams();
                            layoutParams.rightMargin += gC;
                            d.this.nok.setLayoutParams(layoutParams);
                            return;
                        }
                        return;
                    }
                    boolean z3 = d.this.nok == null;
                    if (d.this.nnG.getResources().getDisplayMetrics().density < 2.0f) {
                        d.this.a(true, false, micMemberInfo);
                    } else {
                        d.this.a(true, true, micMemberInfo);
                    }
                    if (z3 && gC > 0 && d.this.nok != null) {
                        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) d.this.nok.getLayoutParams();
                        layoutParams2.bottomMargin += gC;
                        d.this.nok.setLayoutParams(layoutParams2);
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
        if (this.nnF.dJB().mMicStatus.onMic != this.E) {
            this.E = this.nnF.dJB().mMicStatus.onMic;
            u();
        }
        this.E = this.nnF.dJB().mMicStatus.onMic;
        if (this.E) {
            if (this.nnF.dJB().mMicStatus != null && !tv.chushou.zues.utils.h.isEmpty(this.nnF.dJB().mMicStatus.micRoomId) && !this.nnF.dJB().mMicStatus.micRoomId.equals("0")) {
                this.G = this.nnF.dJB().mMicStatus.micRoomId;
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
            if (this.nhn != null) {
                b(true);
                this.nhn.setupCount(this.nnF.dJB().mMicStatus.capacity - 1);
                this.nhn.a(this.nnF.dJB().mMicStatus.isOngoing == 1, z, this.nnF.dJB().mMicStatus.displayInteraction == 1);
                this.nhn.a(arrayList);
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

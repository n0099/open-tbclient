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
import org.webrtc.MediaStreamTrack;
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
    protected a pjZ;
    protected com.kascend.chushou.widget.a.b pkb;
    protected tv.chushou.zues.utils.systemBar.a pkd;
    protected com.kascend.chushou.player.e.a pkf;
    protected com.kascend.chushou.player.e.b pkh;
    protected RelativeLayout pki;
    protected VoiceInteractionView pkl;
    protected String u;
    protected TextView y;
    protected TextView z;

    /* renamed from: a  reason: collision with root package name */
    protected ImageButton f4123a = null;
    protected String b = null;
    private boolean pka = false;
    protected boolean e = true;
    protected boolean f = false;
    protected TextView h = null;
    protected TextView i = null;
    protected int j = 0;
    protected boolean k = false;
    protected ProgressBar pkc = null;
    protected long m = 0;
    protected int n = 0;
    protected boolean p = false;
    private boolean pke = false;
    protected boolean v = false;
    protected int w = -1;
    protected CycleLiveRoomInfo pkj = null;
    protected io.reactivex.disposables.b pkk = null;
    protected boolean E = false;
    protected boolean F = false;
    private long pkm = 0;

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.pqI = getActivity();
        if (aa()) {
            tv.chushou.zues.utils.e.e("VideoPlayerBaseFragment", "killed in backgroud");
            return;
        }
        Point hD = tv.chushou.zues.utils.a.hD(this.pqI);
        q = Math.min(hD.x, hD.y) / 5;
        r = 200;
        this.pqK = (AudioManager) this.pqI.getApplicationContext().getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
        this.pkm = System.currentTimeMillis();
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
        euS();
        ((VideoPlayer) this.pqI).m = false;
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.ah = true;
        R();
        if (this.pqu != null && this.pmW != null) {
            this.pqu.setVisibility(8);
        }
        if (this.pqJ != null) {
            this.pqJ.removeMessages(15);
        }
        a(false, false);
        if (this.pqJ != null) {
            this.pqJ.removeMessages(1);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // com.kascend.chushou.player.f, android.support.v4.app.Fragment
    public void onDestroy() {
        this.pqs.dispose();
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view) {
        this.pqv = (RelativeLayout) view.findViewById(a.f.rl_audio);
        this.pqw = (FrescoThumbnailView) view.findViewById(a.f.iv_audio_bg);
        this.Q = (ImageView) view.findViewById(a.f.iv_audio_avator_bg);
        this.pqx = (FrescoThumbnailView) view.findViewById(a.f.iv_audio_avator);
        this.S = (TextView) view.findViewById(a.f.tv_audio_playing);
        this.T = (TextView) view.findViewById(a.f.tv_open_video);
        this.T.setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b() {
        this.pqD = (ProgressBar) this.pqt.findViewById(a.f.LoadingProgressBar);
        this.pqE = (TextView) this.pqt.findViewById(a.f.LoadingPercent);
        this.pqF = (TextView) this.pqt.findViewById(a.f.LoadingBuffer);
        this.pqG = (TextView) this.pqt.findViewById(a.f.tv_change_lines);
        this.pqD.setVisibility(8);
        this.pqE.setVisibility(8);
        this.pqF.setVisibility(8);
        this.pqG.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c() {
        this.pki = (RelativeLayout) this.pqt.findViewById(a.f.rl_pk_name);
        this.y = (TextView) this.pqt.findViewById(a.f.tv_pk_name);
        this.z = (TextView) this.pqt.findViewById(a.f.tv_pk_subscribe);
        this.z.setOnClickListener(this);
        this.y.setOnClickListener(this);
        this.B = (TextView) this.pqt.findViewById(a.f.iv_cyclelive_countdown);
    }

    private void euS() {
        if (i() || h()) {
            if (this.pqu != null) {
                this.pqu.setVisibility(0);
            }
            this.pmW = ((VideoPlayer) this.pqI).euh();
            if (this.pmW != null) {
                Uri uri = this.pmW.getUri();
                Uri eun = ((VideoPlayer) this.pqI).eun();
                if (!this.pqL) {
                    if (eun != null && uri != null && !uri.equals(eun)) {
                        ((VideoPlayer) this.pqI).a(true, (Uri) null, false);
                    } else if (h.etY().f4087a) {
                        ((VideoPlayer) this.pqI).a(true, (Uri) null, false);
                    } else if (((VideoPlayer) this.pqI).m) {
                        if (h() && this.pqH.d()) {
                            if (!this.ai) {
                                ((VideoPlayer) this.pqI).a(true, (Uri) null, false);
                                return;
                            }
                            return;
                        }
                        ((VideoPlayer) this.pqI).a(true, (Uri) null, false);
                    } else {
                        AudioManager audioManager = ((VideoPlayer) this.pqI).pie;
                        VideoPlayer videoPlayer = (VideoPlayer) this.pqI;
                        audioManager.setStreamVolume(3, VideoPlayer.n, 0);
                        if (this.pqH.d()) {
                            if (!this.ai) {
                                if (this.ap < 0) {
                                    if (this.pqH.d) {
                                        T();
                                        if (this.pqA != null) {
                                            this.pqA.setImageResource(a.e.ic_btn_room_video_n);
                                        }
                                    } else {
                                        U();
                                        S();
                                        if (this.pqz != null) {
                                            this.pqz.setVisibility(0);
                                        }
                                        if (this.pqA != null) {
                                            this.pqA.setImageResource(a.e.ic_btn_room_audio_n);
                                        }
                                    }
                                }
                                n(true);
                            }
                        } else if (!this.H && !this.al) {
                            ((VideoPlayer) this.pqI).a(true, (Uri) null, false);
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d() {
        FullRoomInfo euJ;
        tv.chushou.zues.utils.e.e("VideoPlayerBaseFragment", "release <----------");
        if (this.B != null) {
            this.B.setVisibility(8);
        }
        if (this.pkk != null) {
            this.pkk.dispose();
            this.pkk = null;
        }
        if (this.pqH != null && (euJ = this.pqH.euJ()) != null && !tv.chushou.zues.utils.h.isEmpty(euJ.mGeneralTabGifts)) {
            for (int i = 0; i < euJ.mGeneralTabGifts.size(); i++) {
                GeneralTabGift generalTabGift = euJ.mGeneralTabGifts.get(i);
                if (generalTabGift != null && !tv.chushou.zues.utils.h.isEmpty(generalTabGift.mGeneralGifts)) {
                    for (int i2 = 0; i2 < generalTabGift.mGeneralGifts.size(); i2++) {
                        if (generalTabGift.mGeneralGifts.get(i2) != null) {
                            generalTabGift.mGeneralGifts.get(i2).mSelectFlag = false;
                        }
                    }
                }
            }
        }
        if (this.prg != null) {
            this.prg.clear();
            this.prg = null;
        }
        if (this.pkd != null) {
            this.pkd.setStatusBarTintEnabled(false);
            this.pkd.setNavigationBarTintEnabled(false);
        }
        if (this.prv != null) {
            this.prv.unInit();
            this.prv = null;
            evH().removeAllViews();
        }
        if (this.prj != null) {
            ((ViewGroup) this.pqt).removeView(this.prj);
            this.prj = null;
        }
        if (this.prw != null) {
            this.prw.cancel();
            ArrayList<Animator> childAnimations = this.prw.getChildAnimations();
            if (!tv.chushou.zues.utils.h.isEmpty(childAnimations)) {
                Iterator<Animator> it = childAnimations.iterator();
                while (it.hasNext()) {
                    it.next().removeAllListeners();
                }
            }
            this.prw.removeAllListeners();
            this.prw = null;
        }
        this.prl = null;
        if (this.pqu != null) {
            ((ViewGroup) this.pqt).removeView(this.pqu);
            this.pqu = null;
        }
        if (this.prr != null) {
            this.prr.a();
            this.prr = null;
        }
        if (this.prC != null) {
            this.prC.dismiss();
        }
        if (this.prB != null) {
            this.prB.dismiss();
        }
        this.f4123a = null;
        this.pqt = null;
        this.pqK = null;
        tv.chushou.zues.utils.e.i("VideoPlayerBaseFragment", "release ---------->");
    }

    @Override // com.kascend.chushou.player.e
    public void e() {
        this.H = false;
        this.pqL = false;
        AG(true);
        x();
    }

    public void a(PrivilegeInfo privilegeInfo) {
        ((VideoPlayer) this.pqI).phZ = privilegeInfo;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(String str) {
        ColorPrivileges colorPrivileges;
        ArrayList<RichText> arrayList = null;
        if (this.pqH != null && !tv.chushou.zues.utils.h.isEmpty(this.pqH.f4119a) && this.pmW != null) {
            com.kascend.chushou.c.c.etT().a(new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.d.1
                @Override // com.kascend.chushou.c.b
                public void a() {
                }

                @Override // com.kascend.chushou.c.b
                public void a(String str2, JSONObject jSONObject) {
                    if (jSONObject != null) {
                        int optInt = jSONObject.optInt("code", -1);
                        String optString = jSONObject.optString("message");
                        if (optInt == 0) {
                            tv.chushou.zues.utils.g.O(d.this.pqI, a.i.str_send_success);
                        } else {
                            a(optInt, optString);
                        }
                    }
                }

                @Override // com.kascend.chushou.c.b
                public void a(int i, String str2) {
                    if (!tv.chushou.zues.utils.h.isEmpty(str2)) {
                        tv.chushou.zues.utils.g.d(d.this.pqI, str2);
                    } else {
                        tv.chushou.zues.utils.g.O(d.this.pqI, a.i.str_send_fail);
                    }
                }
            }, this.pqH.f4119a, str, (String) null, this.pmW.getCurrentPos());
            if (this.prv != null && this.prv.getVisibility() == 0) {
                if (((VideoPlayer) this.pqI).phZ != null && (colorPrivileges = ((VideoPlayer) this.pqI).phZ.mColorPrivileges) != null && !tv.chushou.zues.utils.h.isEmpty(colorPrivileges.mColors)) {
                    arrayList = tv.chushou.zues.toolkit.richtext.b.aaA(tv.chushou.zues.toolkit.richtext.b.a(str, colorPrivileges.mColors, colorPrivileges.mWholeColor, new Random().nextInt(colorPrivileges.mColors.size())));
                }
                this.prv.h(str, arrayList);
            }
        }
    }

    public void a(String str, String str2, String str3, String str4) {
        ArrayList<RichText> arrayList;
        ColorPrivileges colorPrivileges;
        com.kascend.chushou.c.c.etT().a(new JsonCallbackWrapper() { // from class: com.kascend.chushou.player.d.2
            @Override // tv.chushou.basis.http.listener.JsonCallbackWrapper
            public void callStart() {
            }

            @Override // tv.chushou.basis.http.listener.JsonCallbackWrapper
            public void callSuccess(String str5, JSONObject jSONObject) {
                if (!d.this.aa()) {
                    ParserRet eH = com.kascend.chushou.c.e.eH(jSONObject);
                    String str6 = eH.mMessage;
                    if (eH.mRc == 0) {
                        d.this.a((PrivilegeInfo) eH.mData);
                    } else {
                        callFailure(eH.mRc, str6, str5);
                    }
                }
            }

            @Override // tv.chushou.basis.http.listener.JsonCallbackWrapper
            public void callFailure(int i, @Nullable String str5, @Nullable String str6) {
                if (!d.this.aa()) {
                    if (i == 401) {
                        com.kascend.chushou.d.e.b(d.this.pqI, str5);
                    } else if (i == 403) {
                        if (tv.chushou.zues.utils.h.isEmpty(str5)) {
                            str5 = d.this.pqI.getString(a.i.str_blacklist);
                        }
                        tv.chushou.zues.utils.g.d(d.this.pqI, str5);
                    } else if (i == 21001 && !tv.chushou.zues.utils.h.isEmpty(str6)) {
                        try {
                            ParserRet eH = com.kascend.chushou.c.e.eH(new JSONObject(str6));
                            if ((eH.mData1 instanceof String) && !TextUtils.isEmpty((String) eH.mData1)) {
                                ListItem listItem = new ListItem();
                                listItem.mType = "99";
                                listItem.mUrl = (String) eH.mData1;
                                com.kascend.chushou.d.e.a(d.this.pqI, listItem, (JSONObject) null);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }, str, str3, str2, str4);
        boolean z = false;
        if (this.pqH != null) {
            if (this.ap < 0) {
                z = h.etY().d;
            } else {
                z = h.etY().e;
            }
        }
        if (z && this.prv != null && this.prv.getVisibility() == 0) {
            if (((VideoPlayer) this.pqI).phZ == null || (colorPrivileges = ((VideoPlayer) this.pqI).phZ.mColorPrivileges) == null || tv.chushou.zues.utils.h.isEmpty(colorPrivileges.mColors)) {
                arrayList = null;
            } else {
                arrayList = tv.chushou.zues.toolkit.richtext.b.aaA(tv.chushou.zues.toolkit.richtext.b.a(str2, colorPrivileges.mColors, colorPrivileges.mWholeColor, new Random().nextInt(colorPrivileges.mColors.size())));
            }
            this.prv.h(str2, arrayList);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void f() {
        if (this.prv != null) {
            this.prv.aaj(h.etY().b());
        }
    }

    public void a(PlayUrl playUrl) {
        if (playUrl == null || playUrl.mSelectedUrl.length() == 0) {
            if (this.pra != null) {
                this.pra.dismiss();
                this.pra = null;
            }
        } else if (this.pra != null) {
            LinearLayout linearLayout = (LinearLayout) this.pra.getContentView().findViewById(a.f.ll_pop_root);
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
        if (!c(true) && !euU()) {
            euT();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void euT() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    private boolean euU() {
        RoomInfo euL;
        if (this.pqH == null || (euL = this.pqH.euL()) == null || euL.mIsSubscribed || aa()) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long eud = h.etY().eud();
        if (currentTimeMillis - this.pkm <= 60000 || currentTimeMillis - eud <= 86400000) {
            return false;
        }
        h.etY().a(currentTimeMillis);
        final com.kascend.chushou.view.b.d YO = com.kascend.chushou.view.b.d.YO(euL.mCreatorAvatar);
        YO.show(getChildFragmentManager(), "showUnSubscirbeDialog");
        YO.a(new d.a() { // from class: com.kascend.chushou.player.d.3
            @Override // com.kascend.chushou.view.b.d.a
            public void a() {
                if (com.kascend.chushou.d.e.c(d.this.pqI, null)) {
                    com.kascend.chushou.c.c.etT().a(new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.d.3.1
                        @Override // com.kascend.chushou.c.b
                        public void a() {
                        }

                        @Override // com.kascend.chushou.c.b
                        public void a(String str, JSONObject jSONObject) {
                            if (!d.this.aa()) {
                                tv.chushou.zues.utils.g.Sc(a.i.subscribe_success);
                                d.this.euT();
                            }
                        }

                        @Override // com.kascend.chushou.c.b
                        public void a(int i, String str) {
                            if (!d.this.aa()) {
                                d.this.euT();
                            }
                        }
                    }, d.this.pqH.f4119a, (String) null, "");
                }
            }

            @Override // com.kascend.chushou.view.b.d.a
            public void b() {
                YO.dismissAllowingStateLoss();
                d.this.euT();
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
        if (this.pqH == null) {
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean i() {
        FullRoomInfo euJ;
        RoomInfo roomInfo;
        return (this.pqH == null || (euJ = this.pqH.euJ()) == null || (roomInfo = euJ.mRoominfo) == null || tv.chushou.zues.utils.h.isEmpty(roomInfo.mGameId)) ? false : true;
    }

    @Override // com.kascend.chushou.player.e
    public void j() {
        if (this.prv != null) {
            this.prv.eHa();
        }
        a((PlayUrl) null);
        AG(true);
    }

    @Override // com.kascend.chushou.player.e
    public void a(b bVar) {
        com.kascend.chushou.player.b.a evo = evo();
        if (evo != null) {
            evo.a(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ParserRet parserRet) {
        SparseArray sparseArray;
        RoomInfo euL;
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
                    if (this.pqI instanceof VideoPlayer) {
                        ((VideoPlayer) this.pqI).euu().a(bangInfo);
                    }
                }
                if (sparseArray2.get(2) != null && (sparseArray2.get(2) instanceof ArrayList)) {
                    Iterator it = ((ArrayList) sparseArray2.get(2)).iterator();
                    while (it.hasNext()) {
                        com.kascend.chushou.player.ui.h5.c.a aVar = (com.kascend.chushou.player.ui.h5.c.a) it.next();
                        if (this.pqI instanceof VideoPlayer) {
                            ((VideoPlayer) this.pqI).c(aVar);
                        }
                    }
                }
                if (sparseArray2.get(3) != null && (sparseArray2.get(3) instanceof MicStatus) && this.pqH != null && this.pqH.euJ() != null) {
                    this.pqH.euJ().mMicStatus = (MicStatus) sparseArray2.get(3);
                    if (this.pqH.euJ().mMicStatus != null) {
                        if (this.pqH.euJ().mMicStatus.onMic) {
                            if (sparseArray2.get(4) != null && (sparseArray2.get(4) instanceof ArrayList) && LoginManager.Instance().getUserInfo() != null && !tv.chushou.zues.utils.h.isEmpty(LoginManager.Instance().getUserInfo().mUserID)) {
                                Iterator it2 = ((ArrayList) sparseArray2.get(4)).iterator();
                                while (true) {
                                    if (!it2.hasNext()) {
                                        z = false;
                                        break;
                                    }
                                    FanItem fanItem = (FanItem) it2.next();
                                    if (fanItem != null && String.valueOf(LoginManager.Instance().getUserInfo().mUserID).equals(fanItem.mUserId) && !String.valueOf(LoginManager.Instance().getUserInfo().mUserID).equals(this.pqH.euJ().mRoominfo.mCreatorUID)) {
                                        z = true;
                                        break;
                                    }
                                }
                                if (z) {
                                    this.J = 0.0f;
                                    if (this.pmW != null) {
                                        this.pmW.setVolume(this.J, this.J);
                                    }
                                } else if (this.pke) {
                                    this.J = 1.0f;
                                    if (this.pmW != null) {
                                        this.pmW.setVolume(this.J, this.J);
                                    }
                                }
                                this.pke = z;
                            }
                        } else if (this.pmW != null && this.pke) {
                            this.J = 1.0f;
                            this.pmW.setVolume(this.J, this.J);
                        }
                    }
                }
                if (sparseArray2.get(5) != null) {
                    String obj = sparseArray2.get(5).toString();
                    if ("10003".equals(obj)) {
                        ((VideoPlayer) this.pqI).t = "10003";
                        if (this.pmW != null && "1".equals(this.pqO) && !"2".equals(this.ay) && this.pmW.getPlayState() != 4) {
                            j();
                            ((VideoPlayer) this.pqI).m();
                        }
                    } else if ("10004".equals(obj)) {
                        tv.chushou.zues.utils.e.d("Rancune", "officeLine");
                        if (this.pqI instanceof VideoPlayer) {
                            ((VideoPlayer) this.pqI).t = "10004";
                            ac();
                        }
                    }
                }
                if (sparseArray2.get(6) != null) {
                    List<com.kascend.chushou.player.ui.h5.c.e> list = (List) sparseArray2.get(6);
                    if (!tv.chushou.zues.utils.h.isEmpty(list)) {
                        ((VideoPlayer) this.pqI).euq().a(list);
                    }
                }
                if (sparseArray2.get(7) != null) {
                    ((VideoPlayer) this.pqI).eur().a((List) sparseArray2.get(7));
                }
                if (sparseArray2.get(11) != null) {
                    ((VideoPlayer) this.pqI).eus().a((com.kascend.chushou.player.ui.h5.c.c) sparseArray2.get(11));
                }
                if (sparseArray2.get(12) != null) {
                    AutoBang autoBang = (AutoBang) sparseArray2.get(12);
                    if (this.pqI instanceof VideoPlayer) {
                        ((VideoPlayer) this.pqI).euu().a(autoBang);
                    }
                }
                if (sparseArray2.get(16) != null) {
                    com.kascend.chushou.player.ui.h5.c.b bVar = (com.kascend.chushou.player.ui.h5.c.b) sparseArray2.get(16);
                    if (this.pqI instanceof VideoPlayer) {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(bVar);
                        ((VideoPlayer) this.pqI).eut().a(arrayList);
                    }
                }
                if (sparseArray2.get(19) != null && ((Boolean) sparseArray2.get(19)).booleanValue() && (this.pkj == null || tv.chushou.zues.utils.h.isEmpty(this.pkj.uid))) {
                    if (this.B != null) {
                        this.B.setVisibility(0);
                    }
                    if (this.pkk != null) {
                        this.pkk.dispose();
                        this.pkk = null;
                    }
                    this.pkk = io.reactivex.g.a(0L, 12L, 0L, 1L, TimeUnit.SECONDS).a(io.reactivex.a.b.a.eAB()).a(new io.reactivex.c.g<Long>() { // from class: com.kascend.chushou.player.d.4
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
                if (this.pqH != null) {
                    this.pqH.a(arrayList2);
                    if (((VideoPlayer) this.pqI).q) {
                        if (sparseArray != null) {
                            if (sparseArray.get(1) != null) {
                                this.pqH.pjA.a((ArrayList) sparseArray.get(1));
                                if (this.pqJ != null && !this.pqJ.RU(11)) {
                                    this.pqJ.X(this.pqJ.RV(11));
                                }
                            }
                            if (sparseArray.get(2) != null) {
                                this.pqH.pjA.b((ArrayList) sparseArray.get(2));
                                if (this.pqJ != null && !this.pqJ.RU(12)) {
                                    this.pqJ.X(this.pqJ.RV(12));
                                }
                            }
                        } else if (this.pqH.pjA != null) {
                            if (this.pqH.pjA.d() && this.pqJ != null && !this.pqJ.RU(11)) {
                                this.pqJ.X(this.pqJ.RV(11));
                            }
                            if (this.pqH.pjA.h() && this.pqJ != null && !this.pqJ.RU(12)) {
                                this.pqJ.X(this.pqJ.RV(12));
                            }
                        }
                    }
                }
                if (arrayList2 != null && arrayList2.size() != 0) {
                    boolean z2 = false;
                    if (this.pqH != null) {
                        if (this.ap < 0) {
                            z2 = h.etY().d;
                        } else {
                            z2 = h.etY().e;
                        }
                    }
                    if (this.prv != null && z2 && this.prv.getVisibility() == 0) {
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
                                aVar2.qkT.icon = next.mGift.icon;
                                if (next.mItem != null && !tv.chushou.zues.utils.h.isEmpty(next.mItem.mType) && this.pqH != null && ((euL = this.pqH.euL()) == null || !next.mItem.mType.equals("1") || !next.mItem.mTargetKey.equals(euL.mRoomID))) {
                                    aVar2.tag = next.mItem;
                                }
                                this.prv.a(aVar2);
                            }
                        }
                    }
                    if (evo() != null && (this.pqI instanceof VideoPlayer) && ((VideoPlayer) this.pqI).q) {
                        evo().a(arrayList2);
                    }
                }
            }
        }
    }

    @Override // com.kascend.chushou.player.e
    public void k() {
        if (this.pqI instanceof VideoPlayer) {
            if (((VideoPlayer) this.pqI).q) {
                evd().setVisibility(0);
            } else {
                evd().setVisibility(8);
            }
        }
    }

    @Override // com.kascend.chushou.player.e
    public void l() {
        evd().setVisibility(8);
    }

    @Override // com.kascend.chushou.player.e
    public void m() {
        com.kascend.chushou.player.b.a evo = evo();
        if (evo != null) {
            evo.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int d(int i) {
        if (Math.abs(i) < this.ar / 100) {
            return 0;
        }
        return (this.pqM * i) / this.ar;
    }

    protected void n() {
        int i;
        int i2 = 0;
        if (!this.k && this.pkc != null) {
            try {
                if (this.pmW != null) {
                    i = this.pmW.getCurrentPos();
                    i2 = this.pmW.getDuration();
                } else {
                    i = 0;
                }
                if (i2 > 1000) {
                    this.pkc.setProgress(i / (i2 / 1000));
                }
            } catch (NullPointerException e) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(boolean z, int i) {
        if (this.pkd != null) {
            if (z) {
                this.pkd.setStatusBarTintResource(i);
                this.pkd.setTintResource(i);
                this.pkd.setStatusBarTintEnabled(true);
                this.pkd.setNavigationBarTintEnabled(true);
                return;
            }
            this.pkd.setStatusBarTintEnabled(false);
            this.pkd.setNavigationBarTintEnabled(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(String str) {
        if (this.pqI instanceof VideoPlayer) {
            str = ((VideoPlayer) this.pqI).a(str);
        }
        com.kascend.chushou.d.a.c(this.pqI, str);
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
            edO();
        } else if (id == a.f.tv_pk_subscribe) {
            if (this.pkf != null && this.pkf.pmX != null && !tv.chushou.zues.utils.h.isEmpty(this.pkf.pmX.mPkRoomId)) {
                ListItem listItem = new ListItem();
                if (this.pkf.pmX.liveStyle == 0 || this.pkf.pmX.liveStyle == 1) {
                    listItem.mLiveType = "1";
                } else {
                    listItem.mLiveType = "2";
                }
                listItem.mType = "1";
                listItem.mTargetKey = this.pkf.pmX.mPkRoomId;
                com.kascend.chushou.d.e.a(this.pqI, listItem, (JSONObject) null);
            }
        } else if (id == a.f.tv_pk_name && this.pkf != null && this.pkf.pmX != null && !tv.chushou.zues.utils.h.isEmpty(this.pkf.pmX.mPkUid)) {
            com.kascend.chushou.d.a.a(this.pqI, (JSONObject) null, this.pkf.pmX.mPkRoomId, this.pkf.pmX.mPkUid, LoginManager.Instance().getUserInfo() != null ? String.valueOf(LoginManager.Instance().getUserInfo().mUserID) : "", false);
        }
    }

    @Override // com.kascend.chushou.player.e
    public boolean a(MotionEvent motionEvent) {
        if ((motionEvent.getAction() == 1 || motionEvent.getAction() == 3 || motionEvent.getAction() == 4) && this.k && this.pmW != null) {
            this.k = false;
            this.orw = Math.min(this.pmW.getDuration(), Math.max(0, this.pmW.getCurrentPos() + this.j));
            if (this.pqJ != null) {
                this.pqJ.removeMessages(14);
                this.pqJ.RT(14);
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
            return (this.E && c(true)) || euU();
        }
        return false;
    }

    /* loaded from: classes6.dex */
    public class a implements GestureDetector.OnGestureListener {

        /* renamed from: a  reason: collision with root package name */
        public final int f4125a = 1;
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
        if (this.pqH != null) {
            if (this.ap < 0) {
                z = h.etY().d;
            } else {
                z = h.etY().e;
            }
        }
        if (z && this.prv != null && this.prv.getVisibility() == 0) {
            if (((VideoPlayer) this.pqI).phZ == null || (colorPrivileges = ((VideoPlayer) this.pqI).phZ.mColorPrivileges) == null || tv.chushou.zues.utils.h.isEmpty(colorPrivileges.mColors)) {
                arrayList = null;
            } else {
                arrayList = tv.chushou.zues.toolkit.richtext.b.aaA(tv.chushou.zues.toolkit.richtext.b.a(str, colorPrivileges.mColors, colorPrivileges.mWholeColor, new Random().nextInt(colorPrivileges.mColors.size())));
            }
            this.prv.h(str, arrayList);
        }
    }

    public void f(int i) {
        com.kascend.chushou.c.c.etT().a(i, new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.d.7
            @Override // com.kascend.chushou.c.b
            public void a() {
            }

            @Override // com.kascend.chushou.c.b
            public void a(String str, JSONObject jSONObject) {
                if (!d.this.aa()) {
                    if (jSONObject != null) {
                        int optInt = jSONObject.optInt("data");
                        if (d.this.pqH != null && d.this.pqH.pjN != null) {
                            d.this.pqH.pjN.count = optInt;
                            d.this.M();
                        }
                        tv.chushou.zues.utils.g.Sc(a.i.str_buy_trumpte_success);
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
                        com.kascend.chushou.d.e.b(d.this.pqI, str);
                    } else if (i2 == 403) {
                        if (tv.chushou.zues.utils.h.isEmpty(str)) {
                            str = d.this.pqI.getString(a.i.str_blacklist);
                        }
                        tv.chushou.zues.utils.g.d(d.this.pqI, str);
                    } else if (i2 == 1027) {
                        if (!(d.this.pqI instanceof VideoPlayer)) {
                            str2 = null;
                        } else {
                            str2 = ((VideoPlayer) d.this.pqI).a((String) null);
                        }
                        com.kascend.chushou.d.e.a(d.this.getActivity(), str2);
                    } else if (tv.chushou.zues.utils.h.isEmpty(str)) {
                        tv.chushou.zues.utils.g.Sc(a.i.str_buy_trumpte_failuer);
                    } else {
                        tv.chushou.zues.utils.g.A(str);
                    }
                }
            }
        });
    }

    public void a(String str, String str2) {
        com.kascend.chushou.c.c.etT().c(str, str2, new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.d.8
            @Override // com.kascend.chushou.c.b
            public void a() {
            }

            @Override // com.kascend.chushou.c.b
            public void a(String str3, JSONObject jSONObject) {
                if (!d.this.aa() && jSONObject != null) {
                    int optInt = jSONObject.optInt("data");
                    tv.chushou.zues.utils.g.Sc(a.i.str_send_success);
                    if (d.this.pqH != null && d.this.pqH.pjN != null) {
                        d.this.pqH.pjN.count = optInt;
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
                        com.kascend.chushou.d.e.b(d.this.pqI, str3);
                    } else if (i == 403 && tv.chushou.zues.utils.h.isEmpty(str3)) {
                        str3 = d.this.pqI.getString(a.i.str_blacklist);
                    }
                    if (tv.chushou.zues.utils.h.isEmpty(str3)) {
                        tv.chushou.zues.utils.g.O(d.this.pqI, a.i.str_send_fail);
                    } else {
                        tv.chushou.zues.utils.g.d(d.this.pqI, str3);
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void t() {
        final int hI = tv.chushou.zues.utils.systemBar.b.hI(getActivity());
        this.pkl.setOnActionListener(new VoiceInteractionView.b() { // from class: com.kascend.chushou.player.d.9
            @Override // com.kascend.chushou.widget.VoiceInteractionView.b
            public void a() {
                ListItem listItem = new ListItem();
                listItem.mUrl = com.kascend.chushou.c.c.a(50);
                d.this.a(listItem);
            }

            @Override // com.kascend.chushou.widget.VoiceInteractionView.b
            public void b() {
                com.kascend.chushou.d.e.a(d.this.pqI, com.kascend.chushou.c.c.a(51) + "micRoomId=" + d.this.G);
            }

            @Override // com.kascend.chushou.widget.VoiceInteractionView.b
            public void a(int i, MicMemberInfo micMemberInfo, boolean z) {
                if (micMemberInfo != null) {
                    if (!z) {
                        com.kascend.chushou.d.a.a(d.this.pqI, (JSONObject) null, (String) null, micMemberInfo.uid, LoginManager.Instance().getUserInfo() != null ? String.valueOf(LoginManager.Instance().getUserInfo().mUserID) : "", false);
                        return;
                    }
                    micMemberInfo.micRoomId = d.this.G;
                    if (d.this.ap == 0) {
                        boolean z2 = d.this.prn == null;
                        d.this.a(false, false, micMemberInfo);
                        if (z2 && hI > 0 && d.this.prn != null && tv.chushou.zues.utils.systemBar.b.aJ(d.this.getActivity()) && tv.chushou.zues.utils.systemBar.b.aK(d.this.getActivity())) {
                            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) d.this.prn.getLayoutParams();
                            layoutParams.rightMargin += hI;
                            d.this.prn.setLayoutParams(layoutParams);
                            return;
                        }
                        return;
                    }
                    boolean z3 = d.this.prn == null;
                    if (d.this.pqI.getResources().getDisplayMetrics().density < 2.0f) {
                        d.this.a(true, false, micMemberInfo);
                    } else {
                        d.this.a(true, true, micMemberInfo);
                    }
                    if (z3 && hI > 0 && d.this.prn != null) {
                        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) d.this.prn.getLayoutParams();
                        layoutParams2.bottomMargin += hI;
                        d.this.prn.setLayoutParams(layoutParams2);
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
        if (this.pqH.euJ().mMicStatus.onMic != this.E) {
            this.E = this.pqH.euJ().mMicStatus.onMic;
            u();
        }
        this.E = this.pqH.euJ().mMicStatus.onMic;
        if (this.E) {
            if (this.pqH.euJ().mMicStatus != null && !tv.chushou.zues.utils.h.isEmpty(this.pqH.euJ().mMicStatus.micRoomId) && !this.pqH.euJ().mMicStatus.micRoomId.equals("0")) {
                this.G = this.pqH.euJ().mMicStatus.micRoomId;
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
            if (this.pkl != null) {
                b(true);
                this.pkl.setupCount(this.pqH.euJ().mMicStatus.capacity - 1);
                this.pkl.a(this.pqH.euJ().mMicStatus.isOngoing == 1, z, this.pqH.euJ().mMicStatus.displayInteraction == 1);
                this.pkl.a(arrayList);
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

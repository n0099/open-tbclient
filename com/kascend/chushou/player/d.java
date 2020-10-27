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
    protected a paD;
    protected com.kascend.chushou.widget.a.b paF;
    protected tv.chushou.zues.utils.systemBar.a paH;
    protected com.kascend.chushou.player.e.a paJ;
    protected com.kascend.chushou.player.e.b paK;
    protected RelativeLayout paL;
    protected VoiceInteractionView paO;
    protected String u;
    protected TextView y;
    protected TextView z;

    /* renamed from: a  reason: collision with root package name */
    protected ImageButton f4121a = null;
    protected String b = null;
    private boolean paE = false;
    protected boolean e = true;
    protected boolean f = false;
    protected TextView h = null;
    protected TextView i = null;
    protected int j = 0;
    protected boolean k = false;
    protected ProgressBar paG = null;
    protected long m = 0;
    protected int n = 0;
    protected boolean p = false;
    private boolean paI = false;
    protected boolean v = false;
    protected int w = -1;
    protected CycleLiveRoomInfo paM = null;
    protected io.reactivex.disposables.b paN = null;
    protected boolean E = false;
    protected boolean F = false;
    private long paP = 0;

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.phh = getActivity();
        if (aa()) {
            tv.chushou.zues.utils.e.e("VideoPlayerBaseFragment", "killed in backgroud");
            return;
        }
        Point hD = tv.chushou.zues.utils.a.hD(this.phh);
        q = Math.min(hD.x, hD.y) / 5;
        r = 200;
        this.phj = (AudioManager) this.phh.getApplicationContext().getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
        this.paP = System.currentTimeMillis();
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
        erd();
        ((VideoPlayer) this.phh).m = false;
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.ah = true;
        R();
        if (this.pgT != null && this.pdz != null) {
            this.pgT.setVisibility(8);
        }
        if (this.phi != null) {
            this.phi.removeMessages(15);
        }
        a(false, false);
        if (this.phi != null) {
            this.phi.removeMessages(1);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // com.kascend.chushou.player.f, android.support.v4.app.Fragment
    public void onDestroy() {
        this.pgR.dispose();
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view) {
        this.pgU = (RelativeLayout) view.findViewById(a.f.rl_audio);
        this.pgV = (FrescoThumbnailView) view.findViewById(a.f.iv_audio_bg);
        this.Q = (ImageView) view.findViewById(a.f.iv_audio_avator_bg);
        this.pgW = (FrescoThumbnailView) view.findViewById(a.f.iv_audio_avator);
        this.S = (TextView) view.findViewById(a.f.tv_audio_playing);
        this.T = (TextView) view.findViewById(a.f.tv_open_video);
        this.T.setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b() {
        this.phc = (ProgressBar) this.pgS.findViewById(a.f.LoadingProgressBar);
        this.phd = (TextView) this.pgS.findViewById(a.f.LoadingPercent);
        this.phe = (TextView) this.pgS.findViewById(a.f.LoadingBuffer);
        this.phf = (TextView) this.pgS.findViewById(a.f.tv_change_lines);
        this.phc.setVisibility(8);
        this.phd.setVisibility(8);
        this.phe.setVisibility(8);
        this.phf.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c() {
        this.paL = (RelativeLayout) this.pgS.findViewById(a.f.rl_pk_name);
        this.y = (TextView) this.pgS.findViewById(a.f.tv_pk_name);
        this.z = (TextView) this.pgS.findViewById(a.f.tv_pk_subscribe);
        this.z.setOnClickListener(this);
        this.y.setOnClickListener(this);
        this.B = (TextView) this.pgS.findViewById(a.f.iv_cyclelive_countdown);
    }

    private void erd() {
        if (i() || h()) {
            if (this.pgT != null) {
                this.pgT.setVisibility(0);
            }
            this.pdz = ((VideoPlayer) this.phh).eqs();
            if (this.pdz != null) {
                Uri uri = this.pdz.getUri();
                Uri eqy = ((VideoPlayer) this.phh).eqy();
                if (!this.phk) {
                    if (eqy != null && uri != null && !uri.equals(eqy)) {
                        ((VideoPlayer) this.phh).a(true, (Uri) null, false);
                    } else if (h.eqj().f4085a) {
                        ((VideoPlayer) this.phh).a(true, (Uri) null, false);
                    } else if (((VideoPlayer) this.phh).m) {
                        if (h() && this.phg.d()) {
                            if (!this.ai) {
                                ((VideoPlayer) this.phh).a(true, (Uri) null, false);
                                return;
                            }
                            return;
                        }
                        ((VideoPlayer) this.phh).a(true, (Uri) null, false);
                    } else {
                        AudioManager audioManager = ((VideoPlayer) this.phh).oYH;
                        VideoPlayer videoPlayer = (VideoPlayer) this.phh;
                        audioManager.setStreamVolume(3, VideoPlayer.n, 0);
                        if (this.phg.d()) {
                            if (!this.ai) {
                                if (this.ap < 0) {
                                    if (this.phg.d) {
                                        T();
                                        if (this.pgZ != null) {
                                            this.pgZ.setImageResource(a.e.ic_btn_room_video_n);
                                        }
                                    } else {
                                        U();
                                        S();
                                        if (this.pgY != null) {
                                            this.pgY.setVisibility(0);
                                        }
                                        if (this.pgZ != null) {
                                            this.pgZ.setImageResource(a.e.ic_btn_room_audio_n);
                                        }
                                    }
                                }
                                n(true);
                            }
                        } else if (!this.H && !this.al) {
                            ((VideoPlayer) this.phh).a(true, (Uri) null, false);
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d() {
        FullRoomInfo eqU;
        tv.chushou.zues.utils.e.e("VideoPlayerBaseFragment", "release <----------");
        if (this.B != null) {
            this.B.setVisibility(8);
        }
        if (this.paN != null) {
            this.paN.dispose();
            this.paN = null;
        }
        if (this.phg != null && (eqU = this.phg.eqU()) != null && !tv.chushou.zues.utils.h.isEmpty(eqU.mGeneralTabGifts)) {
            for (int i = 0; i < eqU.mGeneralTabGifts.size(); i++) {
                GeneralTabGift generalTabGift = eqU.mGeneralTabGifts.get(i);
                if (generalTabGift != null && !tv.chushou.zues.utils.h.isEmpty(generalTabGift.mGeneralGifts)) {
                    for (int i2 = 0; i2 < generalTabGift.mGeneralGifts.size(); i2++) {
                        if (generalTabGift.mGeneralGifts.get(i2) != null) {
                            generalTabGift.mGeneralGifts.get(i2).mSelectFlag = false;
                        }
                    }
                }
            }
        }
        if (this.phF != null) {
            this.phF.clear();
            this.phF = null;
        }
        if (this.paH != null) {
            this.paH.setStatusBarTintEnabled(false);
            this.paH.setNavigationBarTintEnabled(false);
        }
        if (this.phU != null) {
            this.phU.unInit();
            this.phU = null;
            erS().removeAllViews();
        }
        if (this.phI != null) {
            ((ViewGroup) this.pgS).removeView(this.phI);
            this.phI = null;
        }
        if (this.phV != null) {
            this.phV.cancel();
            ArrayList<Animator> childAnimations = this.phV.getChildAnimations();
            if (!tv.chushou.zues.utils.h.isEmpty(childAnimations)) {
                Iterator<Animator> it = childAnimations.iterator();
                while (it.hasNext()) {
                    it.next().removeAllListeners();
                }
            }
            this.phV.removeAllListeners();
            this.phV = null;
        }
        this.phK = null;
        if (this.pgT != null) {
            ((ViewGroup) this.pgS).removeView(this.pgT);
            this.pgT = null;
        }
        if (this.phQ != null) {
            this.phQ.a();
            this.phQ = null;
        }
        if (this.pib != null) {
            this.pib.dismiss();
        }
        if (this.pia != null) {
            this.pia.dismiss();
        }
        this.f4121a = null;
        this.pgS = null;
        this.phj = null;
        tv.chushou.zues.utils.e.i("VideoPlayerBaseFragment", "release ---------->");
    }

    @Override // com.kascend.chushou.player.e
    public void e() {
        this.H = false;
        this.phk = false;
        Av(true);
        x();
    }

    public void a(PrivilegeInfo privilegeInfo) {
        ((VideoPlayer) this.phh).oYE = privilegeInfo;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(String str) {
        ColorPrivileges colorPrivileges;
        ArrayList<RichText> arrayList = null;
        if (this.phg != null && !tv.chushou.zues.utils.h.isEmpty(this.phg.f4117a) && this.pdz != null) {
            com.kascend.chushou.c.c.eqe().a(new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.d.1
                @Override // com.kascend.chushou.c.b
                public void a() {
                }

                @Override // com.kascend.chushou.c.b
                public void a(String str2, JSONObject jSONObject) {
                    if (jSONObject != null) {
                        int optInt = jSONObject.optInt("code", -1);
                        String optString = jSONObject.optString("message");
                        if (optInt == 0) {
                            tv.chushou.zues.utils.g.N(d.this.phh, a.i.str_send_success);
                        } else {
                            a(optInt, optString);
                        }
                    }
                }

                @Override // com.kascend.chushou.c.b
                public void a(int i, String str2) {
                    if (!tv.chushou.zues.utils.h.isEmpty(str2)) {
                        tv.chushou.zues.utils.g.d(d.this.phh, str2);
                    } else {
                        tv.chushou.zues.utils.g.N(d.this.phh, a.i.str_send_fail);
                    }
                }
            }, this.phg.f4117a, str, (String) null, this.pdz.getCurrentPos());
            if (this.phU != null && this.phU.getVisibility() == 0) {
                if (((VideoPlayer) this.phh).oYE != null && (colorPrivileges = ((VideoPlayer) this.phh).oYE.mColorPrivileges) != null && !tv.chushou.zues.utils.h.isEmpty(colorPrivileges.mColors)) {
                    arrayList = tv.chushou.zues.toolkit.richtext.b.ZW(tv.chushou.zues.toolkit.richtext.b.a(str, colorPrivileges.mColors, colorPrivileges.mWholeColor, new Random().nextInt(colorPrivileges.mColors.size())));
                }
                this.phU.h(str, arrayList);
            }
        }
    }

    public void a(String str, String str2, String str3, String str4) {
        ArrayList<RichText> arrayList;
        ColorPrivileges colorPrivileges;
        com.kascend.chushou.c.c.eqe().a(new JsonCallbackWrapper() { // from class: com.kascend.chushou.player.d.2
            @Override // tv.chushou.basis.http.listener.JsonCallbackWrapper
            public void callStart() {
            }

            @Override // tv.chushou.basis.http.listener.JsonCallbackWrapper
            public void callSuccess(String str5, JSONObject jSONObject) {
                if (!d.this.aa()) {
                    ParserRet eB = com.kascend.chushou.c.e.eB(jSONObject);
                    String str6 = eB.mMessage;
                    if (eB.mRc == 0) {
                        d.this.a((PrivilegeInfo) eB.mData);
                    } else {
                        callFailure(eB.mRc, str6, str5);
                    }
                }
            }

            @Override // tv.chushou.basis.http.listener.JsonCallbackWrapper
            public void callFailure(int i, @Nullable String str5, @Nullable String str6) {
                if (!d.this.aa()) {
                    if (i == 401) {
                        com.kascend.chushou.d.e.b(d.this.phh, str5);
                    } else if (i == 403) {
                        if (tv.chushou.zues.utils.h.isEmpty(str5)) {
                            str5 = d.this.phh.getString(a.i.str_blacklist);
                        }
                        tv.chushou.zues.utils.g.d(d.this.phh, str5);
                    } else if (i == 21001 && !tv.chushou.zues.utils.h.isEmpty(str6)) {
                        try {
                            ParserRet eB = com.kascend.chushou.c.e.eB(new JSONObject(str6));
                            if ((eB.mData1 instanceof String) && !TextUtils.isEmpty((String) eB.mData1)) {
                                ListItem listItem = new ListItem();
                                listItem.mType = "99";
                                listItem.mUrl = (String) eB.mData1;
                                com.kascend.chushou.d.e.a(d.this.phh, listItem, (JSONObject) null);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }, str, str3, str2, str4);
        boolean z = false;
        if (this.phg != null) {
            if (this.ap < 0) {
                z = h.eqj().d;
            } else {
                z = h.eqj().e;
            }
        }
        if (z && this.phU != null && this.phU.getVisibility() == 0) {
            if (((VideoPlayer) this.phh).oYE == null || (colorPrivileges = ((VideoPlayer) this.phh).oYE.mColorPrivileges) == null || tv.chushou.zues.utils.h.isEmpty(colorPrivileges.mColors)) {
                arrayList = null;
            } else {
                arrayList = tv.chushou.zues.toolkit.richtext.b.ZW(tv.chushou.zues.toolkit.richtext.b.a(str2, colorPrivileges.mColors, colorPrivileges.mWholeColor, new Random().nextInt(colorPrivileges.mColors.size())));
            }
            this.phU.h(str2, arrayList);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void f() {
        if (this.phU != null) {
            this.phU.ZF(h.eqj().b());
        }
    }

    public void a(PlayUrl playUrl) {
        if (playUrl == null || playUrl.mSelectedUrl.length() == 0) {
            if (this.phz != null) {
                this.phz.dismiss();
                this.phz = null;
            }
        } else if (this.phz != null) {
            LinearLayout linearLayout = (LinearLayout) this.phz.getContentView().findViewById(a.f.ll_pop_root);
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
        if (!c(true) && !erf()) {
            ere();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ere() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    private boolean erf() {
        RoomInfo eqW;
        if (this.phg == null || (eqW = this.phg.eqW()) == null || eqW.mIsSubscribed || aa()) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long eqo = h.eqj().eqo();
        if (currentTimeMillis - this.paP <= 60000 || currentTimeMillis - eqo <= 86400000) {
            return false;
        }
        h.eqj().a(currentTimeMillis);
        final com.kascend.chushou.view.b.d Yk = com.kascend.chushou.view.b.d.Yk(eqW.mCreatorAvatar);
        Yk.show(getChildFragmentManager(), "showUnSubscirbeDialog");
        Yk.a(new d.a() { // from class: com.kascend.chushou.player.d.3
            @Override // com.kascend.chushou.view.b.d.a
            public void a() {
                if (com.kascend.chushou.d.e.c(d.this.phh, null)) {
                    com.kascend.chushou.c.c.eqe().a(new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.d.3.1
                        @Override // com.kascend.chushou.c.b
                        public void a() {
                        }

                        @Override // com.kascend.chushou.c.b
                        public void a(String str, JSONObject jSONObject) {
                            if (!d.this.aa()) {
                                tv.chushou.zues.utils.g.RH(a.i.subscribe_success);
                                d.this.ere();
                            }
                        }

                        @Override // com.kascend.chushou.c.b
                        public void a(int i, String str) {
                            if (!d.this.aa()) {
                                d.this.ere();
                            }
                        }
                    }, d.this.phg.f4117a, (String) null, "");
                }
            }

            @Override // com.kascend.chushou.view.b.d.a
            public void b() {
                Yk.dismissAllowingStateLoss();
                d.this.ere();
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
        if (this.phg == null) {
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean i() {
        FullRoomInfo eqU;
        RoomInfo roomInfo;
        return (this.phg == null || (eqU = this.phg.eqU()) == null || (roomInfo = eqU.mRoominfo) == null || tv.chushou.zues.utils.h.isEmpty(roomInfo.mGameId)) ? false : true;
    }

    @Override // com.kascend.chushou.player.e
    public void j() {
        if (this.phU != null) {
            this.phU.eDl();
        }
        a((PlayUrl) null);
        Av(true);
    }

    @Override // com.kascend.chushou.player.e
    public void a(b bVar) {
        com.kascend.chushou.player.b.a erz = erz();
        if (erz != null) {
            erz.a(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ParserRet parserRet) {
        SparseArray sparseArray;
        RoomInfo eqW;
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
                    if (this.phh instanceof VideoPlayer) {
                        ((VideoPlayer) this.phh).eqF().a(bangInfo);
                    }
                }
                if (sparseArray2.get(2) != null && (sparseArray2.get(2) instanceof ArrayList)) {
                    Iterator it = ((ArrayList) sparseArray2.get(2)).iterator();
                    while (it.hasNext()) {
                        com.kascend.chushou.player.ui.h5.c.a aVar = (com.kascend.chushou.player.ui.h5.c.a) it.next();
                        if (this.phh instanceof VideoPlayer) {
                            ((VideoPlayer) this.phh).c(aVar);
                        }
                    }
                }
                if (sparseArray2.get(3) != null && (sparseArray2.get(3) instanceof MicStatus) && this.phg != null && this.phg.eqU() != null) {
                    this.phg.eqU().mMicStatus = (MicStatus) sparseArray2.get(3);
                    if (this.phg.eqU().mMicStatus != null) {
                        if (this.phg.eqU().mMicStatus.onMic) {
                            if (sparseArray2.get(4) != null && (sparseArray2.get(4) instanceof ArrayList) && LoginManager.Instance().getUserInfo() != null && !tv.chushou.zues.utils.h.isEmpty(LoginManager.Instance().getUserInfo().mUserID)) {
                                Iterator it2 = ((ArrayList) sparseArray2.get(4)).iterator();
                                while (true) {
                                    if (!it2.hasNext()) {
                                        z = false;
                                        break;
                                    }
                                    FanItem fanItem = (FanItem) it2.next();
                                    if (fanItem != null && String.valueOf(LoginManager.Instance().getUserInfo().mUserID).equals(fanItem.mUserId) && !String.valueOf(LoginManager.Instance().getUserInfo().mUserID).equals(this.phg.eqU().mRoominfo.mCreatorUID)) {
                                        z = true;
                                        break;
                                    }
                                }
                                if (z) {
                                    this.J = 0.0f;
                                    if (this.pdz != null) {
                                        this.pdz.setVolume(this.J, this.J);
                                    }
                                } else if (this.paI) {
                                    this.J = 1.0f;
                                    if (this.pdz != null) {
                                        this.pdz.setVolume(this.J, this.J);
                                    }
                                }
                                this.paI = z;
                            }
                        } else if (this.pdz != null && this.paI) {
                            this.J = 1.0f;
                            this.pdz.setVolume(this.J, this.J);
                        }
                    }
                }
                if (sparseArray2.get(5) != null) {
                    String obj = sparseArray2.get(5).toString();
                    if ("10003".equals(obj)) {
                        ((VideoPlayer) this.phh).t = "10003";
                        if (this.pdz != null && "1".equals(this.phn) && !"2".equals(this.ay) && this.pdz.getPlayState() != 4) {
                            j();
                            ((VideoPlayer) this.phh).m();
                        }
                    } else if ("10004".equals(obj)) {
                        tv.chushou.zues.utils.e.d("Rancune", "officeLine");
                        if (this.phh instanceof VideoPlayer) {
                            ((VideoPlayer) this.phh).t = "10004";
                            ac();
                        }
                    }
                }
                if (sparseArray2.get(6) != null) {
                    List<com.kascend.chushou.player.ui.h5.c.e> list = (List) sparseArray2.get(6);
                    if (!tv.chushou.zues.utils.h.isEmpty(list)) {
                        ((VideoPlayer) this.phh).eqB().a(list);
                    }
                }
                if (sparseArray2.get(7) != null) {
                    ((VideoPlayer) this.phh).eqC().a((List) sparseArray2.get(7));
                }
                if (sparseArray2.get(11) != null) {
                    ((VideoPlayer) this.phh).eqD().a((com.kascend.chushou.player.ui.h5.c.c) sparseArray2.get(11));
                }
                if (sparseArray2.get(12) != null) {
                    AutoBang autoBang = (AutoBang) sparseArray2.get(12);
                    if (this.phh instanceof VideoPlayer) {
                        ((VideoPlayer) this.phh).eqF().a(autoBang);
                    }
                }
                if (sparseArray2.get(16) != null) {
                    com.kascend.chushou.player.ui.h5.c.b bVar = (com.kascend.chushou.player.ui.h5.c.b) sparseArray2.get(16);
                    if (this.phh instanceof VideoPlayer) {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(bVar);
                        ((VideoPlayer) this.phh).eqE().a(arrayList);
                    }
                }
                if (sparseArray2.get(19) != null && ((Boolean) sparseArray2.get(19)).booleanValue() && (this.paM == null || tv.chushou.zues.utils.h.isEmpty(this.paM.uid))) {
                    if (this.B != null) {
                        this.B.setVisibility(0);
                    }
                    if (this.paN != null) {
                        this.paN.dispose();
                        this.paN = null;
                    }
                    this.paN = io.reactivex.g.a(0L, 12L, 0L, 1L, TimeUnit.SECONDS).a(io.reactivex.a.b.a.ewM()).a(new io.reactivex.c.g<Long>() { // from class: com.kascend.chushou.player.d.4
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
                if (this.phg != null) {
                    this.phg.a(arrayList2);
                    if (((VideoPlayer) this.phh).q) {
                        if (sparseArray != null) {
                            if (sparseArray.get(1) != null) {
                                this.phg.pac.a((ArrayList) sparseArray.get(1));
                                if (this.phi != null && !this.phi.Rz(11)) {
                                    this.phi.X(this.phi.RA(11));
                                }
                            }
                            if (sparseArray.get(2) != null) {
                                this.phg.pac.b((ArrayList) sparseArray.get(2));
                                if (this.phi != null && !this.phi.Rz(12)) {
                                    this.phi.X(this.phi.RA(12));
                                }
                            }
                        } else if (this.phg.pac != null) {
                            if (this.phg.pac.d() && this.phi != null && !this.phi.Rz(11)) {
                                this.phi.X(this.phi.RA(11));
                            }
                            if (this.phg.pac.h() && this.phi != null && !this.phi.Rz(12)) {
                                this.phi.X(this.phi.RA(12));
                            }
                        }
                    }
                }
                if (arrayList2 != null && arrayList2.size() != 0) {
                    boolean z2 = false;
                    if (this.phg != null) {
                        if (this.ap < 0) {
                            z2 = h.eqj().d;
                        } else {
                            z2 = h.eqj().e;
                        }
                    }
                    if (this.phU != null && z2 && this.phU.getVisibility() == 0) {
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
                                aVar2.qby.icon = next.mGift.icon;
                                if (next.mItem != null && !tv.chushou.zues.utils.h.isEmpty(next.mItem.mType) && this.phg != null && ((eqW = this.phg.eqW()) == null || !next.mItem.mType.equals("1") || !next.mItem.mTargetKey.equals(eqW.mRoomID))) {
                                    aVar2.tag = next.mItem;
                                }
                                this.phU.a(aVar2);
                            }
                        }
                    }
                    if (erz() != null && (this.phh instanceof VideoPlayer) && ((VideoPlayer) this.phh).q) {
                        erz().a(arrayList2);
                    }
                }
            }
        }
    }

    @Override // com.kascend.chushou.player.e
    public void k() {
        if (this.phh instanceof VideoPlayer) {
            if (((VideoPlayer) this.phh).q) {
                ero().setVisibility(0);
            } else {
                ero().setVisibility(8);
            }
        }
    }

    @Override // com.kascend.chushou.player.e
    public void l() {
        ero().setVisibility(8);
    }

    @Override // com.kascend.chushou.player.e
    public void m() {
        com.kascend.chushou.player.b.a erz = erz();
        if (erz != null) {
            erz.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int d(int i) {
        if (Math.abs(i) < this.ar / 100) {
            return 0;
        }
        return (this.phl * i) / this.ar;
    }

    protected void n() {
        int i;
        int i2 = 0;
        if (!this.k && this.paG != null) {
            try {
                if (this.pdz != null) {
                    i = this.pdz.getCurrentPos();
                    i2 = this.pdz.getDuration();
                } else {
                    i = 0;
                }
                if (i2 > 1000) {
                    this.paG.setProgress(i / (i2 / 1000));
                }
            } catch (NullPointerException e) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(boolean z, int i) {
        if (this.paH != null) {
            if (z) {
                this.paH.setStatusBarTintResource(i);
                this.paH.setTintResource(i);
                this.paH.setStatusBarTintEnabled(true);
                this.paH.setNavigationBarTintEnabled(true);
                return;
            }
            this.paH.setStatusBarTintEnabled(false);
            this.paH.setNavigationBarTintEnabled(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(String str) {
        if (this.phh instanceof VideoPlayer) {
            str = ((VideoPlayer) this.phh).a(str);
        }
        com.kascend.chushou.d.a.c(this.phh, str);
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
            eag();
        } else if (id == a.f.tv_pk_subscribe) {
            if (this.paJ != null && this.paJ.pdA != null && !tv.chushou.zues.utils.h.isEmpty(this.paJ.pdA.mPkRoomId)) {
                ListItem listItem = new ListItem();
                if (this.paJ.pdA.liveStyle == 0 || this.paJ.pdA.liveStyle == 1) {
                    listItem.mLiveType = "1";
                } else {
                    listItem.mLiveType = "2";
                }
                listItem.mType = "1";
                listItem.mTargetKey = this.paJ.pdA.mPkRoomId;
                com.kascend.chushou.d.e.a(this.phh, listItem, (JSONObject) null);
            }
        } else if (id == a.f.tv_pk_name && this.paJ != null && this.paJ.pdA != null && !tv.chushou.zues.utils.h.isEmpty(this.paJ.pdA.mPkUid)) {
            com.kascend.chushou.d.a.a(this.phh, (JSONObject) null, this.paJ.pdA.mPkRoomId, this.paJ.pdA.mPkUid, LoginManager.Instance().getUserInfo() != null ? String.valueOf(LoginManager.Instance().getUserInfo().mUserID) : "", false);
        }
    }

    @Override // com.kascend.chushou.player.e
    public boolean a(MotionEvent motionEvent) {
        if ((motionEvent.getAction() == 1 || motionEvent.getAction() == 3 || motionEvent.getAction() == 4) && this.k && this.pdz != null) {
            this.k = false;
            this.oiq = Math.min(this.pdz.getDuration(), Math.max(0, this.pdz.getCurrentPos() + this.j));
            if (this.phi != null) {
                this.phi.removeMessages(14);
                this.phi.Ry(14);
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
            return (this.E && c(true)) || erf();
        }
        return false;
    }

    /* loaded from: classes6.dex */
    public class a implements GestureDetector.OnGestureListener {

        /* renamed from: a  reason: collision with root package name */
        public final int f4123a = 1;
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
        if (this.phg != null) {
            if (this.ap < 0) {
                z = h.eqj().d;
            } else {
                z = h.eqj().e;
            }
        }
        if (z && this.phU != null && this.phU.getVisibility() == 0) {
            if (((VideoPlayer) this.phh).oYE == null || (colorPrivileges = ((VideoPlayer) this.phh).oYE.mColorPrivileges) == null || tv.chushou.zues.utils.h.isEmpty(colorPrivileges.mColors)) {
                arrayList = null;
            } else {
                arrayList = tv.chushou.zues.toolkit.richtext.b.ZW(tv.chushou.zues.toolkit.richtext.b.a(str, colorPrivileges.mColors, colorPrivileges.mWholeColor, new Random().nextInt(colorPrivileges.mColors.size())));
            }
            this.phU.h(str, arrayList);
        }
    }

    public void f(int i) {
        com.kascend.chushou.c.c.eqe().a(i, new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.d.7
            @Override // com.kascend.chushou.c.b
            public void a() {
            }

            @Override // com.kascend.chushou.c.b
            public void a(String str, JSONObject jSONObject) {
                if (!d.this.aa()) {
                    if (jSONObject != null) {
                        int optInt = jSONObject.optInt("data");
                        if (d.this.phg != null && d.this.phg.paq != null) {
                            d.this.phg.paq.count = optInt;
                            d.this.M();
                        }
                        tv.chushou.zues.utils.g.RH(a.i.str_buy_trumpte_success);
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
                        com.kascend.chushou.d.e.b(d.this.phh, str);
                    } else if (i2 == 403) {
                        if (tv.chushou.zues.utils.h.isEmpty(str)) {
                            str = d.this.phh.getString(a.i.str_blacklist);
                        }
                        tv.chushou.zues.utils.g.d(d.this.phh, str);
                    } else if (i2 == 1027) {
                        if (!(d.this.phh instanceof VideoPlayer)) {
                            str2 = null;
                        } else {
                            str2 = ((VideoPlayer) d.this.phh).a((String) null);
                        }
                        com.kascend.chushou.d.e.a(d.this.getActivity(), str2);
                    } else if (tv.chushou.zues.utils.h.isEmpty(str)) {
                        tv.chushou.zues.utils.g.RH(a.i.str_buy_trumpte_failuer);
                    } else {
                        tv.chushou.zues.utils.g.A(str);
                    }
                }
            }
        });
    }

    public void a(String str, String str2) {
        com.kascend.chushou.c.c.eqe().c(str, str2, new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.d.8
            @Override // com.kascend.chushou.c.b
            public void a() {
            }

            @Override // com.kascend.chushou.c.b
            public void a(String str3, JSONObject jSONObject) {
                if (!d.this.aa() && jSONObject != null) {
                    int optInt = jSONObject.optInt("data");
                    tv.chushou.zues.utils.g.RH(a.i.str_send_success);
                    if (d.this.phg != null && d.this.phg.paq != null) {
                        d.this.phg.paq.count = optInt;
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
                        com.kascend.chushou.d.e.b(d.this.phh, str3);
                    } else if (i == 403 && tv.chushou.zues.utils.h.isEmpty(str3)) {
                        str3 = d.this.phh.getString(a.i.str_blacklist);
                    }
                    if (tv.chushou.zues.utils.h.isEmpty(str3)) {
                        tv.chushou.zues.utils.g.N(d.this.phh, a.i.str_send_fail);
                    } else {
                        tv.chushou.zues.utils.g.d(d.this.phh, str3);
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void t() {
        final int hI = tv.chushou.zues.utils.systemBar.b.hI(getActivity());
        this.paO.setOnActionListener(new VoiceInteractionView.b() { // from class: com.kascend.chushou.player.d.9
            @Override // com.kascend.chushou.widget.VoiceInteractionView.b
            public void a() {
                ListItem listItem = new ListItem();
                listItem.mUrl = com.kascend.chushou.c.c.a(50);
                d.this.a(listItem);
            }

            @Override // com.kascend.chushou.widget.VoiceInteractionView.b
            public void b() {
                com.kascend.chushou.d.e.a(d.this.phh, com.kascend.chushou.c.c.a(51) + "micRoomId=" + d.this.G);
            }

            @Override // com.kascend.chushou.widget.VoiceInteractionView.b
            public void a(int i, MicMemberInfo micMemberInfo, boolean z) {
                if (micMemberInfo != null) {
                    if (!z) {
                        com.kascend.chushou.d.a.a(d.this.phh, (JSONObject) null, (String) null, micMemberInfo.uid, LoginManager.Instance().getUserInfo() != null ? String.valueOf(LoginManager.Instance().getUserInfo().mUserID) : "", false);
                        return;
                    }
                    micMemberInfo.micRoomId = d.this.G;
                    if (d.this.ap == 0) {
                        boolean z2 = d.this.phM == null;
                        d.this.a(false, false, micMemberInfo);
                        if (z2 && hI > 0 && d.this.phM != null && tv.chushou.zues.utils.systemBar.b.aH(d.this.getActivity()) && tv.chushou.zues.utils.systemBar.b.aI(d.this.getActivity())) {
                            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) d.this.phM.getLayoutParams();
                            layoutParams.rightMargin += hI;
                            d.this.phM.setLayoutParams(layoutParams);
                            return;
                        }
                        return;
                    }
                    boolean z3 = d.this.phM == null;
                    if (d.this.phh.getResources().getDisplayMetrics().density < 2.0f) {
                        d.this.a(true, false, micMemberInfo);
                    } else {
                        d.this.a(true, true, micMemberInfo);
                    }
                    if (z3 && hI > 0 && d.this.phM != null) {
                        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) d.this.phM.getLayoutParams();
                        layoutParams2.bottomMargin += hI;
                        d.this.phM.setLayoutParams(layoutParams2);
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
        if (this.phg.eqU().mMicStatus.onMic != this.E) {
            this.E = this.phg.eqU().mMicStatus.onMic;
            u();
        }
        this.E = this.phg.eqU().mMicStatus.onMic;
        if (this.E) {
            if (this.phg.eqU().mMicStatus != null && !tv.chushou.zues.utils.h.isEmpty(this.phg.eqU().mMicStatus.micRoomId) && !this.phg.eqU().mMicStatus.micRoomId.equals("0")) {
                this.G = this.phg.eqU().mMicStatus.micRoomId;
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
            if (this.paO != null) {
                b(true);
                this.paO.setupCount(this.phg.eqU().mMicStatus.capacity - 1);
                this.paO.a(this.phg.eqU().mMicStatus.isOngoing == 1, z, this.phg.eqU().mMicStatus.displayInteraction == 1);
                this.paO.a(arrayList);
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

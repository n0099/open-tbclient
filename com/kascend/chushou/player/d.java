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
    protected a nJH;
    protected com.kascend.chushou.widget.a.b nJJ;
    protected tv.chushou.zues.utils.systemBar.a nJL;
    protected com.kascend.chushou.player.e.a nJN;
    protected com.kascend.chushou.player.e.b nJO;
    protected RelativeLayout nJP;
    protected VoiceInteractionView nJS;
    protected String u;
    protected TextView y;
    protected TextView z;
    protected ImageButton a = null;
    protected String b = null;
    private boolean nJI = false;
    protected boolean e = true;
    protected boolean f = false;
    protected TextView h = null;
    protected TextView i = null;
    protected int j = 0;
    protected boolean k = false;
    protected ProgressBar nJK = null;
    protected long m = 0;
    protected int n = 0;
    protected boolean p = false;
    private boolean nJM = false;
    protected boolean v = false;
    protected int w = -1;
    protected CycleLiveRoomInfo nJQ = null;
    protected io.reactivex.disposables.b nJR = null;
    protected boolean E = false;
    protected boolean F = false;
    private long nJT = 0;

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.nQl = getActivity();
        if (aa()) {
            tv.chushou.zues.utils.e.e("VideoPlayerBaseFragment", "killed in backgroud");
            return;
        }
        Point gW = tv.chushou.zues.utils.a.gW(this.nQl);
        q = Math.min(gW.x, gW.y) / 5;
        r = 200;
        this.nQn = (AudioManager) this.nQl.getApplicationContext().getSystemService("audio");
        this.nJT = System.currentTimeMillis();
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
        dZl();
        ((VideoPlayer) this.nQl).m = false;
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.ah = true;
        R();
        if (this.nPX != null && this.nMD != null) {
            this.nPX.setVisibility(8);
        }
        if (this.nQm != null) {
            this.nQm.removeMessages(15);
        }
        a(false, false);
        if (this.nQm != null) {
            this.nQm.removeMessages(1);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // com.kascend.chushou.player.f, android.support.v4.app.Fragment
    public void onDestroy() {
        this.nPV.dispose();
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view) {
        this.nPY = (RelativeLayout) view.findViewById(a.f.rl_audio);
        this.nPZ = (FrescoThumbnailView) view.findViewById(a.f.iv_audio_bg);
        this.Q = (ImageView) view.findViewById(a.f.iv_audio_avator_bg);
        this.nQa = (FrescoThumbnailView) view.findViewById(a.f.iv_audio_avator);
        this.bJa = (TextView) view.findViewById(a.f.tv_audio_playing);
        this.T = (TextView) view.findViewById(a.f.tv_open_video);
        this.T.setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b() {
        this.nQg = (ProgressBar) this.nPW.findViewById(a.f.LoadingProgressBar);
        this.nQh = (TextView) this.nPW.findViewById(a.f.LoadingPercent);
        this.nQi = (TextView) this.nPW.findViewById(a.f.LoadingBuffer);
        this.nQj = (TextView) this.nPW.findViewById(a.f.tv_change_lines);
        this.nQg.setVisibility(8);
        this.nQh.setVisibility(8);
        this.nQi.setVisibility(8);
        this.nQj.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c() {
        this.nJP = (RelativeLayout) this.nPW.findViewById(a.f.rl_pk_name);
        this.y = (TextView) this.nPW.findViewById(a.f.tv_pk_name);
        this.z = (TextView) this.nPW.findViewById(a.f.tv_pk_subscribe);
        this.z.setOnClickListener(this);
        this.y.setOnClickListener(this);
        this.B = (TextView) this.nPW.findViewById(a.f.iv_cyclelive_countdown);
    }

    private void dZl() {
        if (i() || h()) {
            if (this.nPX != null) {
                this.nPX.setVisibility(0);
            }
            this.nMD = ((VideoPlayer) this.nQl).dYA();
            if (this.nMD != null) {
                Uri uri = this.nMD.getUri();
                Uri dYG = ((VideoPlayer) this.nQl).dYG();
                if (!this.nQo) {
                    if (dYG != null && uri != null && !uri.equals(dYG)) {
                        ((VideoPlayer) this.nQl).a(true, (Uri) null, false);
                    } else if (h.dYr().a) {
                        ((VideoPlayer) this.nQl).a(true, (Uri) null, false);
                    } else if (((VideoPlayer) this.nQl).m) {
                        if (h() && this.nQk.d()) {
                            if (!this.ai) {
                                ((VideoPlayer) this.nQl).a(true, (Uri) null, false);
                                return;
                            }
                            return;
                        }
                        ((VideoPlayer) this.nQl).a(true, (Uri) null, false);
                    } else {
                        AudioManager audioManager = ((VideoPlayer) this.nQl).nHN;
                        VideoPlayer videoPlayer = (VideoPlayer) this.nQl;
                        audioManager.setStreamVolume(3, VideoPlayer.n, 0);
                        if (this.nQk.d()) {
                            if (!this.ai) {
                                if (this.ap < 0) {
                                    if (this.nQk.d) {
                                        T();
                                        if (this.nQd != null) {
                                            this.nQd.setImageResource(a.e.ic_btn_room_video_n);
                                        }
                                    } else {
                                        U();
                                        S();
                                        if (this.nQc != null) {
                                            this.nQc.setVisibility(0);
                                        }
                                        if (this.nQd != null) {
                                            this.nQd.setImageResource(a.e.ic_btn_room_audio_n);
                                        }
                                    }
                                }
                                n(true);
                            }
                        } else if (!this.H && !this.al) {
                            ((VideoPlayer) this.nQl).a(true, (Uri) null, false);
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d() {
        FullRoomInfo dZc;
        tv.chushou.zues.utils.e.e("VideoPlayerBaseFragment", "release <----------");
        if (this.B != null) {
            this.B.setVisibility(8);
        }
        if (this.nJR != null) {
            this.nJR.dispose();
            this.nJR = null;
        }
        if (this.nQk != null && (dZc = this.nQk.dZc()) != null && !tv.chushou.zues.utils.h.isEmpty(dZc.mGeneralTabGifts)) {
            for (int i = 0; i < dZc.mGeneralTabGifts.size(); i++) {
                GeneralTabGift generalTabGift = dZc.mGeneralTabGifts.get(i);
                if (generalTabGift != null && !tv.chushou.zues.utils.h.isEmpty(generalTabGift.mGeneralGifts)) {
                    for (int i2 = 0; i2 < generalTabGift.mGeneralGifts.size(); i2++) {
                        if (generalTabGift.mGeneralGifts.get(i2) != null) {
                            generalTabGift.mGeneralGifts.get(i2).mSelectFlag = false;
                        }
                    }
                }
            }
        }
        if (this.nQK != null) {
            this.nQK.clear();
            this.nQK = null;
        }
        if (this.nJL != null) {
            this.nJL.setStatusBarTintEnabled(false);
            this.nJL.setNavigationBarTintEnabled(false);
        }
        if (this.nQZ != null) {
            this.nQZ.unInit();
            this.nQZ = null;
            eaa().removeAllViews();
        }
        if (this.nQN != null) {
            ((ViewGroup) this.nPW).removeView(this.nQN);
            this.nQN = null;
        }
        if (this.nRa != null) {
            this.nRa.cancel();
            ArrayList<Animator> childAnimations = this.nRa.getChildAnimations();
            if (!tv.chushou.zues.utils.h.isEmpty(childAnimations)) {
                Iterator<Animator> it = childAnimations.iterator();
                while (it.hasNext()) {
                    it.next().removeAllListeners();
                }
            }
            this.nRa.removeAllListeners();
            this.nRa = null;
        }
        this.nQP = null;
        if (this.nPX != null) {
            ((ViewGroup) this.nPW).removeView(this.nPX);
            this.nPX = null;
        }
        if (this.nQV != null) {
            this.nQV.a();
            this.nQV = null;
        }
        if (this.nRg != null) {
            this.nRg.dismiss();
        }
        if (this.nRf != null) {
            this.nRf.dismiss();
        }
        this.a = null;
        this.nPW = null;
        this.nQn = null;
        tv.chushou.zues.utils.e.i("VideoPlayerBaseFragment", "release ---------->");
    }

    @Override // com.kascend.chushou.player.e
    public void e() {
        this.H = false;
        this.nQo = false;
        yw(true);
        x();
    }

    public void a(PrivilegeInfo privilegeInfo) {
        ((VideoPlayer) this.nQl).nHK = privilegeInfo;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(String str) {
        ColorPrivileges colorPrivileges;
        ArrayList<RichText> arrayList = null;
        if (this.nQk != null && !tv.chushou.zues.utils.h.isEmpty(this.nQk.a) && this.nMD != null) {
            com.kascend.chushou.c.c.dYm().a(new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.d.1
                @Override // com.kascend.chushou.c.b
                public void a() {
                }

                @Override // com.kascend.chushou.c.b
                public void a(String str2, JSONObject jSONObject) {
                    if (jSONObject != null) {
                        int optInt = jSONObject.optInt("code", -1);
                        String optString = jSONObject.optString("message");
                        if (optInt == 0) {
                            tv.chushou.zues.utils.g.H(d.this.nQl, a.i.str_send_success);
                        } else {
                            a(optInt, optString);
                        }
                    }
                }

                @Override // com.kascend.chushou.c.b
                public void a(int i, String str2) {
                    if (!tv.chushou.zues.utils.h.isEmpty(str2)) {
                        tv.chushou.zues.utils.g.c(d.this.nQl, str2);
                    } else {
                        tv.chushou.zues.utils.g.H(d.this.nQl, a.i.str_send_fail);
                    }
                }
            }, this.nQk.a, str, (String) null, this.nMD.getCurrentPos());
            if (this.nQZ != null && this.nQZ.getVisibility() == 0) {
                if (((VideoPlayer) this.nQl).nHK != null && (colorPrivileges = ((VideoPlayer) this.nQl).nHK.mColorPrivileges) != null && !tv.chushou.zues.utils.h.isEmpty(colorPrivileges.mColors)) {
                    arrayList = tv.chushou.zues.toolkit.richtext.b.WU(tv.chushou.zues.toolkit.richtext.b.a(str, colorPrivileges.mColors, colorPrivileges.mWholeColor, new Random().nextInt(colorPrivileges.mColors.size())));
                }
                this.nQZ.h(str, arrayList);
            }
        }
    }

    public void a(String str, String str2, String str3, String str4) {
        ArrayList<RichText> arrayList;
        ColorPrivileges colorPrivileges;
        com.kascend.chushou.c.c.dYm().a(new JsonCallbackWrapper() { // from class: com.kascend.chushou.player.d.2
            @Override // tv.chushou.basis.http.listener.JsonCallbackWrapper
            public void callStart() {
            }

            @Override // tv.chushou.basis.http.listener.JsonCallbackWrapper
            public void callSuccess(String str5, JSONObject jSONObject) {
                if (!d.this.aa()) {
                    ParserRet eh = com.kascend.chushou.c.e.eh(jSONObject);
                    String str6 = eh.mMessage;
                    if (eh.mRc == 0) {
                        d.this.a((PrivilegeInfo) eh.mData);
                    } else {
                        callFailure(eh.mRc, str6, str5);
                    }
                }
            }

            @Override // tv.chushou.basis.http.listener.JsonCallbackWrapper
            public void callFailure(int i, @Nullable String str5, @Nullable String str6) {
                if (!d.this.aa()) {
                    if (i == 401) {
                        com.kascend.chushou.d.e.b(d.this.nQl, str5);
                    } else if (i == 403) {
                        if (tv.chushou.zues.utils.h.isEmpty(str5)) {
                            str5 = d.this.nQl.getString(a.i.str_blacklist);
                        }
                        tv.chushou.zues.utils.g.c(d.this.nQl, str5);
                    } else if (i == 21001 && !tv.chushou.zues.utils.h.isEmpty(str6)) {
                        try {
                            ParserRet eh = com.kascend.chushou.c.e.eh(new JSONObject(str6));
                            if ((eh.mData1 instanceof String) && !TextUtils.isEmpty((String) eh.mData1)) {
                                ListItem listItem = new ListItem();
                                listItem.mType = "99";
                                listItem.mUrl = (String) eh.mData1;
                                com.kascend.chushou.d.e.a(d.this.nQl, listItem, (JSONObject) null);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }, str, str3, str2, str4);
        boolean z = false;
        if (this.nQk != null) {
            if (this.ap < 0) {
                z = h.dYr().d;
            } else {
                z = h.dYr().e;
            }
        }
        if (z && this.nQZ != null && this.nQZ.getVisibility() == 0) {
            if (((VideoPlayer) this.nQl).nHK == null || (colorPrivileges = ((VideoPlayer) this.nQl).nHK.mColorPrivileges) == null || tv.chushou.zues.utils.h.isEmpty(colorPrivileges.mColors)) {
                arrayList = null;
            } else {
                arrayList = tv.chushou.zues.toolkit.richtext.b.WU(tv.chushou.zues.toolkit.richtext.b.a(str2, colorPrivileges.mColors, colorPrivileges.mWholeColor, new Random().nextInt(colorPrivileges.mColors.size())));
            }
            this.nQZ.h(str2, arrayList);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void f() {
        if (this.nQZ != null) {
            this.nQZ.WC(h.dYr().b());
        }
    }

    public void a(PlayUrl playUrl) {
        if (playUrl == null || playUrl.mSelectedUrl.length() == 0) {
            if (this.nQE != null) {
                this.nQE.dismiss();
                this.nQE = null;
            }
        } else if (this.nQE != null) {
            LinearLayout linearLayout = (LinearLayout) this.nQE.getContentView().findViewById(a.f.ll_pop_root);
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
        if (!c(true) && !dZn()) {
            dZm();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dZm() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    private boolean dZn() {
        RoomInfo dZe;
        if (this.nQk == null || (dZe = this.nQk.dZe()) == null || dZe.mIsSubscribed || aa()) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long dYw = h.dYr().dYw();
        if (currentTimeMillis - this.nJT <= 60000 || currentTimeMillis - dYw <= 86400000) {
            return false;
        }
        h.dYr().a(currentTimeMillis);
        final com.kascend.chushou.view.b.d Vh = com.kascend.chushou.view.b.d.Vh(dZe.mCreatorAvatar);
        Vh.show(getChildFragmentManager(), "showUnSubscirbeDialog");
        Vh.a(new d.a() { // from class: com.kascend.chushou.player.d.3
            @Override // com.kascend.chushou.view.b.d.a
            public void a() {
                if (com.kascend.chushou.d.e.c(d.this.nQl, null)) {
                    com.kascend.chushou.c.c.dYm().a(new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.d.3.1
                        @Override // com.kascend.chushou.c.b
                        public void a() {
                        }

                        @Override // com.kascend.chushou.c.b
                        public void a(String str, JSONObject jSONObject) {
                            if (!d.this.aa()) {
                                tv.chushou.zues.utils.g.OF(a.i.subscribe_success);
                                d.this.dZm();
                            }
                        }

                        @Override // com.kascend.chushou.c.b
                        public void a(int i, String str) {
                            if (!d.this.aa()) {
                                d.this.dZm();
                            }
                        }
                    }, d.this.nQk.a, (String) null, "");
                }
            }

            @Override // com.kascend.chushou.view.b.d.a
            public void b() {
                Vh.dismissAllowingStateLoss();
                d.this.dZm();
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
        if (this.nQk == null) {
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean i() {
        FullRoomInfo dZc;
        RoomInfo roomInfo;
        return (this.nQk == null || (dZc = this.nQk.dZc()) == null || (roomInfo = dZc.mRoominfo) == null || tv.chushou.zues.utils.h.isEmpty(roomInfo.mGameId)) ? false : true;
    }

    @Override // com.kascend.chushou.player.e
    public void j() {
        if (this.nQZ != null) {
            this.nQZ.elv();
        }
        a((PlayUrl) null);
        yw(true);
    }

    @Override // com.kascend.chushou.player.e
    public void a(b bVar) {
        com.kascend.chushou.player.b.a dZH = dZH();
        if (dZH != null) {
            dZH.a(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ParserRet parserRet) {
        SparseArray sparseArray;
        RoomInfo dZe;
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
                    if (this.nQl instanceof VideoPlayer) {
                        ((VideoPlayer) this.nQl).dYN().a(bangInfo);
                    }
                }
                if (sparseArray2.get(2) != null && (sparseArray2.get(2) instanceof ArrayList)) {
                    Iterator it = ((ArrayList) sparseArray2.get(2)).iterator();
                    while (it.hasNext()) {
                        com.kascend.chushou.player.ui.h5.c.a aVar = (com.kascend.chushou.player.ui.h5.c.a) it.next();
                        if (this.nQl instanceof VideoPlayer) {
                            ((VideoPlayer) this.nQl).c(aVar);
                        }
                    }
                }
                if (sparseArray2.get(3) != null && (sparseArray2.get(3) instanceof MicStatus) && this.nQk != null && this.nQk.dZc() != null) {
                    this.nQk.dZc().mMicStatus = (MicStatus) sparseArray2.get(3);
                    if (this.nQk.dZc().mMicStatus != null) {
                        if (this.nQk.dZc().mMicStatus.onMic) {
                            if (sparseArray2.get(4) != null && (sparseArray2.get(4) instanceof ArrayList) && LoginManager.Instance().getUserInfo() != null && !tv.chushou.zues.utils.h.isEmpty(LoginManager.Instance().getUserInfo().mUserID)) {
                                Iterator it2 = ((ArrayList) sparseArray2.get(4)).iterator();
                                while (true) {
                                    if (!it2.hasNext()) {
                                        z = false;
                                        break;
                                    }
                                    FanItem fanItem = (FanItem) it2.next();
                                    if (fanItem != null && String.valueOf(LoginManager.Instance().getUserInfo().mUserID).equals(fanItem.mUserId) && !String.valueOf(LoginManager.Instance().getUserInfo().mUserID).equals(this.nQk.dZc().mRoominfo.mCreatorUID)) {
                                        z = true;
                                        break;
                                    }
                                }
                                if (z) {
                                    this.J = 0.0f;
                                    if (this.nMD != null) {
                                        this.nMD.setVolume(this.J, this.J);
                                    }
                                } else if (this.nJM) {
                                    this.J = 1.0f;
                                    if (this.nMD != null) {
                                        this.nMD.setVolume(this.J, this.J);
                                    }
                                }
                                this.nJM = z;
                            }
                        } else if (this.nMD != null && this.nJM) {
                            this.J = 1.0f;
                            this.nMD.setVolume(this.J, this.J);
                        }
                    }
                }
                if (sparseArray2.get(5) != null) {
                    String obj = sparseArray2.get(5).toString();
                    if ("10003".equals(obj)) {
                        ((VideoPlayer) this.nQl).t = "10003";
                        if (this.nMD != null && "1".equals(this.nQs) && !"2".equals(this.ay) && this.nMD.getPlayState() != 4) {
                            j();
                            ((VideoPlayer) this.nQl).m();
                        }
                    } else if ("10004".equals(obj)) {
                        tv.chushou.zues.utils.e.d("Rancune", "officeLine");
                        if (this.nQl instanceof VideoPlayer) {
                            ((VideoPlayer) this.nQl).t = "10004";
                            ac();
                        }
                    }
                }
                if (sparseArray2.get(6) != null) {
                    List<com.kascend.chushou.player.ui.h5.c.e> list = (List) sparseArray2.get(6);
                    if (!tv.chushou.zues.utils.h.isEmpty(list)) {
                        ((VideoPlayer) this.nQl).dYJ().a(list);
                    }
                }
                if (sparseArray2.get(7) != null) {
                    ((VideoPlayer) this.nQl).dYK().a((List) sparseArray2.get(7));
                }
                if (sparseArray2.get(11) != null) {
                    ((VideoPlayer) this.nQl).dYL().a((com.kascend.chushou.player.ui.h5.c.c) sparseArray2.get(11));
                }
                if (sparseArray2.get(12) != null) {
                    AutoBang autoBang = (AutoBang) sparseArray2.get(12);
                    if (this.nQl instanceof VideoPlayer) {
                        ((VideoPlayer) this.nQl).dYN().a(autoBang);
                    }
                }
                if (sparseArray2.get(16) != null) {
                    com.kascend.chushou.player.ui.h5.c.b bVar = (com.kascend.chushou.player.ui.h5.c.b) sparseArray2.get(16);
                    if (this.nQl instanceof VideoPlayer) {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(bVar);
                        ((VideoPlayer) this.nQl).dYM().a(arrayList);
                    }
                }
                if (sparseArray2.get(19) != null && ((Boolean) sparseArray2.get(19)).booleanValue() && (this.nJQ == null || tv.chushou.zues.utils.h.isEmpty(this.nJQ.uid))) {
                    if (this.B != null) {
                        this.B.setVisibility(0);
                    }
                    if (this.nJR != null) {
                        this.nJR.dispose();
                        this.nJR = null;
                    }
                    this.nJR = io.reactivex.g.a(0L, 12L, 0L, 1L, TimeUnit.SECONDS).a(io.reactivex.a.b.a.eeV()).a(new io.reactivex.c.g<Long>() { // from class: com.kascend.chushou.player.d.4
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
                if (this.nQk != null) {
                    this.nQk.a(arrayList2);
                    if (((VideoPlayer) this.nQl).q) {
                        if (sparseArray != null) {
                            if (sparseArray.get(1) != null) {
                                this.nQk.nJi.a((ArrayList) sparseArray.get(1));
                                if (this.nQm != null && !this.nQm.Ox(11)) {
                                    this.nQm.S(this.nQm.Oy(11));
                                }
                            }
                            if (sparseArray.get(2) != null) {
                                this.nQk.nJi.b((ArrayList) sparseArray.get(2));
                                if (this.nQm != null && !this.nQm.Ox(12)) {
                                    this.nQm.S(this.nQm.Oy(12));
                                }
                            }
                        } else if (this.nQk.nJi != null) {
                            if (this.nQk.nJi.d() && this.nQm != null && !this.nQm.Ox(11)) {
                                this.nQm.S(this.nQm.Oy(11));
                            }
                            if (this.nQk.nJi.h() && this.nQm != null && !this.nQm.Ox(12)) {
                                this.nQm.S(this.nQm.Oy(12));
                            }
                        }
                    }
                }
                if (arrayList2 != null && arrayList2.size() != 0) {
                    boolean z2 = false;
                    if (this.nQk != null) {
                        if (this.ap < 0) {
                            z2 = h.dYr().d;
                        } else {
                            z2 = h.dYr().e;
                        }
                    }
                    if (this.nQZ != null && z2 && this.nQZ.getVisibility() == 0) {
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
                                aVar2.oKT.icon = next.mGift.icon;
                                if (next.mItem != null && !tv.chushou.zues.utils.h.isEmpty(next.mItem.mType) && this.nQk != null && ((dZe = this.nQk.dZe()) == null || !next.mItem.mType.equals("1") || !next.mItem.mTargetKey.equals(dZe.mRoomID))) {
                                    aVar2.tag = next.mItem;
                                }
                                this.nQZ.a(aVar2);
                            }
                        }
                    }
                    if (dZH() != null && (this.nQl instanceof VideoPlayer) && ((VideoPlayer) this.nQl).q) {
                        dZH().a(arrayList2);
                    }
                }
            }
        }
    }

    @Override // com.kascend.chushou.player.e
    public void k() {
        if (this.nQl instanceof VideoPlayer) {
            if (((VideoPlayer) this.nQl).q) {
                dZw().setVisibility(0);
            } else {
                dZw().setVisibility(8);
            }
        }
    }

    @Override // com.kascend.chushou.player.e
    public void l() {
        dZw().setVisibility(8);
    }

    @Override // com.kascend.chushou.player.e
    public void m() {
        com.kascend.chushou.player.b.a dZH = dZH();
        if (dZH != null) {
            dZH.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int d(int i) {
        if (Math.abs(i) < this.ar / 100) {
            return 0;
        }
        return (this.nQq * i) / this.ar;
    }

    protected void n() {
        int i;
        int i2 = 0;
        if (!this.k && this.nJK != null) {
            try {
                if (this.nMD != null) {
                    i = this.nMD.getCurrentPos();
                    i2 = this.nMD.getDuration();
                } else {
                    i = 0;
                }
                if (i2 > 1000) {
                    this.nJK.setProgress(i / (i2 / 1000));
                }
            } catch (NullPointerException e) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(boolean z, int i) {
        if (this.nJL != null) {
            if (z) {
                this.nJL.setStatusBarTintResource(i);
                this.nJL.setTintResource(i);
                this.nJL.setStatusBarTintEnabled(true);
                this.nJL.setNavigationBarTintEnabled(true);
                return;
            }
            this.nJL.setStatusBarTintEnabled(false);
            this.nJL.setNavigationBarTintEnabled(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(String str) {
        if (this.nQl instanceof VideoPlayer) {
            str = ((VideoPlayer) this.nQl).a(str);
        }
        com.kascend.chushou.d.a.c(this.nQl, str);
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
            dMw();
        } else if (id == a.f.tv_pk_subscribe) {
            if (this.nJN != null && this.nJN.nME != null && !tv.chushou.zues.utils.h.isEmpty(this.nJN.nME.mPkRoomId)) {
                ListItem listItem = new ListItem();
                if (this.nJN.nME.liveStyle == 0 || this.nJN.nME.liveStyle == 1) {
                    listItem.mLiveType = "1";
                } else {
                    listItem.mLiveType = "2";
                }
                listItem.mType = "1";
                listItem.mTargetKey = this.nJN.nME.mPkRoomId;
                com.kascend.chushou.d.e.a(this.nQl, listItem, (JSONObject) null);
            }
        } else if (id == a.f.tv_pk_name && this.nJN != null && this.nJN.nME != null && !tv.chushou.zues.utils.h.isEmpty(this.nJN.nME.mPkUid)) {
            com.kascend.chushou.d.a.a(this.nQl, (JSONObject) null, this.nJN.nME.mPkRoomId, this.nJN.nME.mPkUid, LoginManager.Instance().getUserInfo() != null ? String.valueOf(LoginManager.Instance().getUserInfo().mUserID) : "", false);
        }
    }

    @Override // com.kascend.chushou.player.e
    public boolean a(MotionEvent motionEvent) {
        if ((motionEvent.getAction() == 1 || motionEvent.getAction() == 3 || motionEvent.getAction() == 4) && this.k && this.nMD != null) {
            this.k = false;
            this.nga = Math.min(this.nMD.getDuration(), Math.max(0, this.nMD.getCurrentPos() + this.j));
            if (this.nQm != null) {
                this.nQm.removeMessages(14);
                this.nQm.Ow(14);
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
            return (this.E && c(true)) || dZn();
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
        if (this.nQk != null) {
            if (this.ap < 0) {
                z = h.dYr().d;
            } else {
                z = h.dYr().e;
            }
        }
        if (z && this.nQZ != null && this.nQZ.getVisibility() == 0) {
            if (((VideoPlayer) this.nQl).nHK == null || (colorPrivileges = ((VideoPlayer) this.nQl).nHK.mColorPrivileges) == null || tv.chushou.zues.utils.h.isEmpty(colorPrivileges.mColors)) {
                arrayList = null;
            } else {
                arrayList = tv.chushou.zues.toolkit.richtext.b.WU(tv.chushou.zues.toolkit.richtext.b.a(str, colorPrivileges.mColors, colorPrivileges.mWholeColor, new Random().nextInt(colorPrivileges.mColors.size())));
            }
            this.nQZ.h(str, arrayList);
        }
    }

    public void f(int i) {
        com.kascend.chushou.c.c.dYm().a(i, new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.d.7
            @Override // com.kascend.chushou.c.b
            public void a() {
            }

            @Override // com.kascend.chushou.c.b
            public void a(String str, JSONObject jSONObject) {
                if (!d.this.aa()) {
                    if (jSONObject != null) {
                        int optInt = jSONObject.optInt("data");
                        if (d.this.nQk != null && d.this.nQk.nJv != null) {
                            d.this.nQk.nJv.count = optInt;
                            d.this.M();
                        }
                        tv.chushou.zues.utils.g.OF(a.i.str_buy_trumpte_success);
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
                        com.kascend.chushou.d.e.b(d.this.nQl, str);
                    } else if (i2 == 403) {
                        if (tv.chushou.zues.utils.h.isEmpty(str)) {
                            str = d.this.nQl.getString(a.i.str_blacklist);
                        }
                        tv.chushou.zues.utils.g.c(d.this.nQl, str);
                    } else if (i2 == 1027) {
                        if (!(d.this.nQl instanceof VideoPlayer)) {
                            str2 = null;
                        } else {
                            str2 = ((VideoPlayer) d.this.nQl).a((String) null);
                        }
                        com.kascend.chushou.d.e.a(d.this.getActivity(), str2);
                    } else if (tv.chushou.zues.utils.h.isEmpty(str)) {
                        tv.chushou.zues.utils.g.OF(a.i.str_buy_trumpte_failuer);
                    } else {
                        tv.chushou.zues.utils.g.y(str);
                    }
                }
            }
        });
    }

    public void a(String str, String str2) {
        com.kascend.chushou.c.c.dYm().c(str, str2, new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.d.8
            @Override // com.kascend.chushou.c.b
            public void a() {
            }

            @Override // com.kascend.chushou.c.b
            public void a(String str3, JSONObject jSONObject) {
                if (!d.this.aa() && jSONObject != null) {
                    int optInt = jSONObject.optInt("data");
                    tv.chushou.zues.utils.g.OF(a.i.str_send_success);
                    if (d.this.nQk != null && d.this.nQk.nJv != null) {
                        d.this.nQk.nJv.count = optInt;
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
                        com.kascend.chushou.d.e.b(d.this.nQl, str3);
                    } else if (i == 403 && tv.chushou.zues.utils.h.isEmpty(str3)) {
                        str3 = d.this.nQl.getString(a.i.str_blacklist);
                    }
                    if (tv.chushou.zues.utils.h.isEmpty(str3)) {
                        tv.chushou.zues.utils.g.H(d.this.nQl, a.i.str_send_fail);
                    } else {
                        tv.chushou.zues.utils.g.c(d.this.nQl, str3);
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void t() {
        final int hb = tv.chushou.zues.utils.systemBar.b.hb(getActivity());
        this.nJS.setOnActionListener(new VoiceInteractionView.b() { // from class: com.kascend.chushou.player.d.9
            @Override // com.kascend.chushou.widget.VoiceInteractionView.b
            public void a() {
                ListItem listItem = new ListItem();
                listItem.mUrl = com.kascend.chushou.c.c.a(50);
                d.this.a(listItem);
            }

            @Override // com.kascend.chushou.widget.VoiceInteractionView.b
            public void b() {
                com.kascend.chushou.d.e.a(d.this.nQl, com.kascend.chushou.c.c.a(51) + "micRoomId=" + d.this.G);
            }

            @Override // com.kascend.chushou.widget.VoiceInteractionView.b
            public void a(int i, MicMemberInfo micMemberInfo, boolean z) {
                if (micMemberInfo != null) {
                    if (!z) {
                        com.kascend.chushou.d.a.a(d.this.nQl, (JSONObject) null, (String) null, micMemberInfo.uid, LoginManager.Instance().getUserInfo() != null ? String.valueOf(LoginManager.Instance().getUserInfo().mUserID) : "", false);
                        return;
                    }
                    micMemberInfo.micRoomId = d.this.G;
                    if (d.this.ap == 0) {
                        boolean z2 = d.this.nQR == null;
                        d.this.a(false, false, micMemberInfo);
                        if (z2 && hb > 0 && d.this.nQR != null && tv.chushou.zues.utils.systemBar.b.az(d.this.getActivity()) && tv.chushou.zues.utils.systemBar.b.aA(d.this.getActivity())) {
                            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) d.this.nQR.getLayoutParams();
                            layoutParams.rightMargin += hb;
                            d.this.nQR.setLayoutParams(layoutParams);
                            return;
                        }
                        return;
                    }
                    boolean z3 = d.this.nQR == null;
                    if (d.this.nQl.getResources().getDisplayMetrics().density < 2.0f) {
                        d.this.a(true, false, micMemberInfo);
                    } else {
                        d.this.a(true, true, micMemberInfo);
                    }
                    if (z3 && hb > 0 && d.this.nQR != null) {
                        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) d.this.nQR.getLayoutParams();
                        layoutParams2.bottomMargin += hb;
                        d.this.nQR.setLayoutParams(layoutParams2);
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
        if (this.nQk.dZc().mMicStatus.onMic != this.E) {
            this.E = this.nQk.dZc().mMicStatus.onMic;
            u();
        }
        this.E = this.nQk.dZc().mMicStatus.onMic;
        if (this.E) {
            if (this.nQk.dZc().mMicStatus != null && !tv.chushou.zues.utils.h.isEmpty(this.nQk.dZc().mMicStatus.micRoomId) && !this.nQk.dZc().mMicStatus.micRoomId.equals("0")) {
                this.G = this.nQk.dZc().mMicStatus.micRoomId;
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
            if (this.nJS != null) {
                b(true);
                this.nJS.setupCount(this.nQk.dZc().mMicStatus.capacity - 1);
                this.nJS.a(this.nQk.dZc().mMicStatus.isOngoing == 1, z, this.nQk.dZc().mMicStatus.displayInteraction == 1);
                this.nJS.a(arrayList);
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

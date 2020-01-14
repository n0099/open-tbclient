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
/* loaded from: classes4.dex */
public abstract class d extends g implements View.OnClickListener, b.a {
    protected static int q;
    protected static int r;
    protected TextView B;
    protected String G;
    protected GestureDetector c;
    protected a mQI;
    protected com.kascend.chushou.widget.a.b mQK;
    protected tv.chushou.zues.utils.systemBar.a mQM;
    protected com.kascend.chushou.player.e.a mQN;
    protected com.kascend.chushou.player.e.b mQO;
    protected RelativeLayout mQP;
    protected VoiceInteractionView mQS;
    protected String u;
    protected TextView y;
    protected TextView z;
    protected ImageButton a = null;
    protected String b = null;
    private boolean mQJ = false;
    protected boolean e = true;
    protected boolean f = false;
    protected TextView h = null;
    protected TextView i = null;
    protected int j = 0;
    protected boolean k = false;
    protected ProgressBar mQL = null;
    protected long m = 0;
    protected int n = 0;
    protected boolean p = false;
    private boolean QJ = false;
    protected boolean v = false;
    protected int w = -1;
    protected CycleLiveRoomInfo mQQ = null;
    protected io.reactivex.disposables.b mQR = null;
    protected boolean E = false;
    protected boolean F = false;

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mXB = getActivity();
        if (dCG()) {
            tv.chushou.zues.utils.e.e("VideoPlayerBaseFragment", "killed in backgroud");
            return;
        }
        Point he = tv.chushou.zues.utils.a.he(this.mXB);
        q = Math.min(he.x, he.y) / 5;
        r = 200;
        this.mXD = (AudioManager) this.mXB.getApplicationContext().getSystemService("audio");
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
        cWe();
        dBE();
        ((VideoPlayer) this.mXB).m = false;
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.ah = true;
        R();
        if (this.N != null && this.mTO != null) {
            this.N.setVisibility(8);
        }
        if (this.mXC != null) {
            this.mXC.removeMessages(15);
        }
        a(false, false);
        if (this.mXC != null) {
            this.mXC.removeMessages(1);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // com.kascend.chushou.player.f, android.support.v4.app.Fragment
    public void onDestroy() {
        this.mXk.dispose();
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view) {
        this.mXm = (RelativeLayout) view.findViewById(a.f.rl_audio);
        this.mXn = (FrescoThumbnailView) view.findViewById(a.f.iv_audio_bg);
        this.mXo = (ImageView) view.findViewById(a.f.iv_audio_avator_bg);
        this.mXp = (FrescoThumbnailView) view.findViewById(a.f.iv_audio_avator);
        this.S = (TextView) view.findViewById(a.f.tv_audio_playing);
        this.mXq = (TextView) view.findViewById(a.f.tv_open_video);
        this.mXq.setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b() {
        this.mXw = (ProgressBar) this.mXl.findViewById(a.f.LoadingProgressBar);
        this.mXx = (TextView) this.mXl.findViewById(a.f.LoadingPercent);
        this.mXy = (TextView) this.mXl.findViewById(a.f.LoadingBuffer);
        this.mXz = (TextView) this.mXl.findViewById(a.f.tv_change_lines);
        this.mXw.setVisibility(8);
        this.mXx.setVisibility(8);
        this.mXy.setVisibility(8);
        this.mXz.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c() {
        this.mQP = (RelativeLayout) this.mXl.findViewById(a.f.rl_pk_name);
        this.y = (TextView) this.mXl.findViewById(a.f.tv_pk_name);
        this.z = (TextView) this.mXl.findViewById(a.f.tv_pk_subscribe);
        this.z.setOnClickListener(this);
        this.y.setOnClickListener(this);
        this.B = (TextView) this.mXl.findViewById(a.f.iv_cyclelive_countdown);
    }

    private void dBE() {
        if (i() || h()) {
            if (this.N != null) {
                this.N.setVisibility(0);
            }
            this.mTO = ((VideoPlayer) this.mXB).dAU();
            if (this.mTO != null) {
                Uri uri = this.mTO.getUri();
                Uri dAZ = ((VideoPlayer) this.mXB).dAZ();
                if (!this.mXE) {
                    if (dAZ != null && uri != null && !uri.equals(dAZ)) {
                        ((VideoPlayer) this.mXB).a(true, (Uri) null, false);
                    } else if (h.dAM().a) {
                        ((VideoPlayer) this.mXB).a(true, (Uri) null, false);
                    } else if (((VideoPlayer) this.mXB).m) {
                        if (h() && this.mXA.d()) {
                            if (!this.ai) {
                                ((VideoPlayer) this.mXB).a(true, (Uri) null, false);
                                return;
                            }
                            return;
                        }
                        ((VideoPlayer) this.mXB).a(true, (Uri) null, false);
                    } else {
                        AudioManager audioManager = ((VideoPlayer) this.mXB).mOO;
                        VideoPlayer videoPlayer = (VideoPlayer) this.mXB;
                        audioManager.setStreamVolume(3, VideoPlayer.n, 0);
                        if (this.mXA.d()) {
                            if (!this.ai) {
                                if (this.ap < 0) {
                                    if (this.mXA.d) {
                                        T();
                                        if (this.mXt != null) {
                                            this.mXt.setImageResource(a.e.ic_btn_room_video_n);
                                        }
                                    } else {
                                        U();
                                        cWe();
                                        if (this.mXs != null) {
                                            this.mXs.setVisibility(0);
                                        }
                                        if (this.mXt != null) {
                                            this.mXt.setImageResource(a.e.ic_btn_room_audio_n);
                                        }
                                    }
                                }
                                m(true);
                            }
                        } else if (!this.H && !this.al) {
                            ((VideoPlayer) this.mXB).a(true, (Uri) null, false);
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d() {
        FullRoomInfo dBw;
        tv.chushou.zues.utils.e.e("VideoPlayerBaseFragment", "release <----------");
        if (this.B != null) {
            this.B.setVisibility(8);
        }
        if (this.mQR != null) {
            this.mQR.dispose();
            this.mQR = null;
        }
        if (this.mXA != null && (dBw = this.mXA.dBw()) != null && !tv.chushou.zues.utils.h.isEmpty(dBw.mGeneralTabGifts)) {
            for (int i = 0; i < dBw.mGeneralTabGifts.size(); i++) {
                GeneralTabGift generalTabGift = dBw.mGeneralTabGifts.get(i);
                if (generalTabGift != null && !tv.chushou.zues.utils.h.isEmpty(generalTabGift.mGeneralGifts)) {
                    for (int i2 = 0; i2 < generalTabGift.mGeneralGifts.size(); i2++) {
                        if (generalTabGift.mGeneralGifts.get(i2) != null) {
                            generalTabGift.mGeneralGifts.get(i2).mSelectFlag = false;
                        }
                    }
                }
            }
        }
        if (this.mXY != null) {
            this.mXY.clear();
            this.mXY = null;
        }
        if (this.mQM != null) {
            this.mQM.setStatusBarTintEnabled(false);
            this.mQM.setNavigationBarTintEnabled(false);
        }
        if (this.mYo != null) {
            this.mYo.unInit();
            this.mYo = null;
            dCH().removeAllViews();
        }
        if (this.mYc != null) {
            ((ViewGroup) this.mXl).removeView(this.mYc);
            this.mYc = null;
        }
        if (this.mYp != null) {
            this.mYp.cancel();
            ArrayList<Animator> childAnimations = this.mYp.getChildAnimations();
            if (!tv.chushou.zues.utils.h.isEmpty(childAnimations)) {
                Iterator<Animator> it = childAnimations.iterator();
                while (it.hasNext()) {
                    it.next().removeAllListeners();
                }
            }
            this.mYp.removeAllListeners();
            this.mYp = null;
        }
        this.mYe = null;
        if (this.N != null) {
            ((ViewGroup) this.mXl).removeView(this.N);
            this.N = null;
        }
        if (this.mYk != null) {
            this.mYk.a();
            this.mYk = null;
        }
        if (this.mYu != null) {
            this.mYu.dismiss();
        }
        if (this.mYt != null) {
            this.mYt.dismiss();
        }
        this.a = null;
        this.mXl = null;
        this.mXD = null;
        tv.chushou.zues.utils.e.i("VideoPlayerBaseFragment", "release ---------->");
    }

    @Override // com.kascend.chushou.player.e
    public void e() {
        this.H = false;
        this.mXE = false;
        wk(true);
        x();
    }

    public void a(PrivilegeInfo privilegeInfo) {
        ((VideoPlayer) this.mXB).mOJ = privilegeInfo;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(String str) {
        ColorPrivileges colorPrivileges;
        ArrayList<RichText> arrayList = null;
        if (this.mXA != null && !tv.chushou.zues.utils.h.isEmpty(this.mXA.a) && this.mTO != null) {
            com.kascend.chushou.c.c.dAI().a(new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.d.1
                @Override // com.kascend.chushou.c.b
                public void a() {
                }

                @Override // com.kascend.chushou.c.b
                public void a(String str2, JSONObject jSONObject) {
                    if (jSONObject != null) {
                        int optInt = jSONObject.optInt("code", -1);
                        String optString = jSONObject.optString("message");
                        if (optInt == 0) {
                            tv.chushou.zues.utils.g.M(d.this.mXB, a.i.str_send_success);
                        } else {
                            a(optInt, optString);
                        }
                    }
                }

                @Override // com.kascend.chushou.c.b
                public void a(int i, String str2) {
                    if (!tv.chushou.zues.utils.h.isEmpty(str2)) {
                        tv.chushou.zues.utils.g.c(d.this.mXB, str2);
                    } else {
                        tv.chushou.zues.utils.g.M(d.this.mXB, a.i.str_send_fail);
                    }
                }
            }, this.mXA.a, str, (String) null, this.mTO.getCurrentPos());
            if (this.mYo != null && this.mYo.getVisibility() == 0) {
                if (((VideoPlayer) this.mXB).mOJ != null && (colorPrivileges = ((VideoPlayer) this.mXB).mOJ.mColorPrivileges) != null && !tv.chushou.zues.utils.h.isEmpty(colorPrivileges.mColors)) {
                    arrayList = tv.chushou.zues.toolkit.richtext.b.SH(tv.chushou.zues.toolkit.richtext.b.a(str, colorPrivileges.mColors, colorPrivileges.mWholeColor, new Random().nextInt(colorPrivileges.mColors.size())));
                }
                this.mYo.k(str, arrayList);
            }
        }
    }

    public void a(String str, String str2, String str3, String str4) {
        ArrayList<RichText> arrayList;
        ColorPrivileges colorPrivileges;
        com.kascend.chushou.c.c.dAI().a(new JsonCallbackWrapper() { // from class: com.kascend.chushou.player.d.2
            @Override // tv.chushou.basis.http.listener.JsonCallbackWrapper
            public void callStart() {
            }

            @Override // tv.chushou.basis.http.listener.JsonCallbackWrapper
            public void callSuccess(String str5, JSONObject jSONObject) {
                if (!d.this.dCG()) {
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
                if (!d.this.dCG()) {
                    if (i == 401) {
                        com.kascend.chushou.d.e.b(d.this.mXB, str5);
                    } else if (i == 403) {
                        if (tv.chushou.zues.utils.h.isEmpty(str5)) {
                            str5 = d.this.mXB.getString(a.i.str_blacklist);
                        }
                        tv.chushou.zues.utils.g.c(d.this.mXB, str5);
                    } else if (i == 21001 && !tv.chushou.zues.utils.h.isEmpty(str6)) {
                        try {
                            ParserRet dv = com.kascend.chushou.c.e.dv(new JSONObject(str6));
                            if ((dv.mData1 instanceof String) && !TextUtils.isEmpty((String) dv.mData1)) {
                                ListItem listItem = new ListItem();
                                listItem.mType = "99";
                                listItem.mUrl = (String) dv.mData1;
                                com.kascend.chushou.d.e.a(d.this.mXB, listItem, (JSONObject) null);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }, str, str3, str2, str4);
        boolean z = false;
        if (this.mXA != null) {
            if (this.ap < 0) {
                z = h.dAM().d;
            } else {
                z = h.dAM().e;
            }
        }
        if (z && this.mYo != null && this.mYo.getVisibility() == 0) {
            if (((VideoPlayer) this.mXB).mOJ == null || (colorPrivileges = ((VideoPlayer) this.mXB).mOJ.mColorPrivileges) == null || tv.chushou.zues.utils.h.isEmpty(colorPrivileges.mColors)) {
                arrayList = null;
            } else {
                arrayList = tv.chushou.zues.toolkit.richtext.b.SH(tv.chushou.zues.toolkit.richtext.b.a(str2, colorPrivileges.mColors, colorPrivileges.mWholeColor, new Random().nextInt(colorPrivileges.mColors.size())));
            }
            this.mYo.k(str2, arrayList);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void f() {
        if (this.mYo != null) {
            this.mYo.Sp(h.dAM().b());
        }
    }

    public void a(PlayUrl playUrl) {
        if (playUrl == null || playUrl.mSelectedUrl.length() == 0) {
            if (this.mXS != null) {
                this.mXS.dismiss();
                this.mXS = null;
            }
        } else if (this.mXS != null) {
            LinearLayout linearLayout = (LinearLayout) this.mXS.getContentView().findViewById(a.f.ll_pop_root);
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
        if (!c(true) && this.mXB != null) {
            ((Activity) this.mXB).finish();
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
        if (this.mXA == null) {
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean i() {
        FullRoomInfo dBw;
        RoomInfo roomInfo;
        return (this.mXA == null || (dBw = this.mXA.dBw()) == null || (roomInfo = dBw.mRoominfo) == null || tv.chushou.zues.utils.h.isEmpty(roomInfo.mGameId)) ? false : true;
    }

    @Override // com.kascend.chushou.player.e
    public void j() {
        if (this.mYo != null) {
            this.mYo.dOp();
        }
        a((PlayUrl) null);
        wk(true);
    }

    @Override // com.kascend.chushou.player.e
    public void a(b bVar) {
        com.kascend.chushou.player.b.a dCg = dCg();
        if (dCg != null) {
            dCg.a(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ParserRet parserRet) {
        SparseArray sparseArray;
        RoomInfo dBy;
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
                    if (this.mXB instanceof VideoPlayer) {
                        ((VideoPlayer) this.mXB).dBg().a(bangInfo);
                    }
                }
                if (sparseArray2.get(2) != null && (sparseArray2.get(2) instanceof ArrayList)) {
                    Iterator it = ((ArrayList) sparseArray2.get(2)).iterator();
                    while (it.hasNext()) {
                        com.kascend.chushou.player.ui.h5.c.a aVar = (com.kascend.chushou.player.ui.h5.c.a) it.next();
                        if (this.mXB instanceof VideoPlayer) {
                            ((VideoPlayer) this.mXB).c(aVar);
                        }
                    }
                }
                if (sparseArray2.get(3) != null && (sparseArray2.get(3) instanceof MicStatus) && this.mXA != null && this.mXA.dBw() != null) {
                    this.mXA.dBw().mMicStatus = (MicStatus) sparseArray2.get(3);
                    if (this.mXA.dBw().mMicStatus != null) {
                        if (this.mXA.dBw().mMicStatus.onMic) {
                            if (sparseArray2.get(4) != null && (sparseArray2.get(4) instanceof ArrayList) && LoginManager.Instance().getUserInfo() != null && !tv.chushou.zues.utils.h.isEmpty(LoginManager.Instance().getUserInfo().mUserID)) {
                                Iterator it2 = ((ArrayList) sparseArray2.get(4)).iterator();
                                while (true) {
                                    if (!it2.hasNext()) {
                                        z = false;
                                        break;
                                    }
                                    FanItem fanItem = (FanItem) it2.next();
                                    if (fanItem != null && String.valueOf(LoginManager.Instance().getUserInfo().mUserID).equals(fanItem.mUserId) && !String.valueOf(LoginManager.Instance().getUserInfo().mUserID).equals(this.mXA.dBw().mRoominfo.mCreatorUID)) {
                                        z = true;
                                        break;
                                    }
                                }
                                if (z) {
                                    this.J = 0.0f;
                                    if (this.mTO != null) {
                                        this.mTO.setVolume(this.J, this.J);
                                    }
                                } else if (this.QJ) {
                                    this.J = 1.0f;
                                    if (this.mTO != null) {
                                        this.mTO.setVolume(this.J, this.J);
                                    }
                                }
                                this.QJ = z;
                            }
                        } else if (this.mTO != null && this.QJ) {
                            this.J = 1.0f;
                            this.mTO.setVolume(this.J, this.J);
                        }
                    }
                }
                if (sparseArray2.get(5) != null) {
                    String obj = sparseArray2.get(5).toString();
                    if ("10003".equals(obj)) {
                        ((VideoPlayer) this.mXB).t = "10003";
                        if (this.mTO != null && "1".equals(this.aw) && !"2".equals(this.ay) && this.mTO.getPlayState() != 4) {
                            j();
                            ((VideoPlayer) this.mXB).m();
                        }
                    } else if ("10004".equals(obj)) {
                        tv.chushou.zues.utils.e.d("Rancune", "officeLine");
                        if (this.mXB instanceof VideoPlayer) {
                            ((VideoPlayer) this.mXB).t = "10004";
                            nO();
                        }
                    }
                }
                if (sparseArray2.get(6) != null) {
                    List<com.kascend.chushou.player.ui.h5.c.e> list = (List) sparseArray2.get(6);
                    if (!tv.chushou.zues.utils.h.isEmpty(list)) {
                        ((VideoPlayer) this.mXB).dBc().a(list);
                    }
                }
                if (sparseArray2.get(7) != null) {
                    ((VideoPlayer) this.mXB).dBd().a((List) sparseArray2.get(7));
                }
                if (sparseArray2.get(11) != null) {
                    ((VideoPlayer) this.mXB).dBe().a((com.kascend.chushou.player.ui.h5.c.c) sparseArray2.get(11));
                }
                if (sparseArray2.get(12) != null) {
                    AutoBang autoBang = (AutoBang) sparseArray2.get(12);
                    if (this.mXB instanceof VideoPlayer) {
                        ((VideoPlayer) this.mXB).dBg().a(autoBang);
                    }
                }
                if (sparseArray2.get(16) != null) {
                    com.kascend.chushou.player.ui.h5.c.b bVar = (com.kascend.chushou.player.ui.h5.c.b) sparseArray2.get(16);
                    if (this.mXB instanceof VideoPlayer) {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(bVar);
                        ((VideoPlayer) this.mXB).dBf().a(arrayList);
                    }
                }
                if (sparseArray2.get(19) != null && ((Boolean) sparseArray2.get(19)).booleanValue() && (this.mQQ == null || tv.chushou.zues.utils.h.isEmpty(this.mQQ.uid))) {
                    if (this.B != null) {
                        this.B.setVisibility(0);
                    }
                    if (this.mQR != null) {
                        this.mQR.dispose();
                        this.mQR = null;
                    }
                    this.mQR = io.reactivex.g.a(0L, 12L, 0L, 1L, TimeUnit.SECONDS).a(io.reactivex.a.b.a.dHZ()).a(new io.reactivex.c.g<Long>() { // from class: com.kascend.chushou.player.d.3
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
                if (this.mXA != null) {
                    this.mXA.a(arrayList2);
                    if (((VideoPlayer) this.mXB).q) {
                        if (sparseArray != null) {
                            if (sparseArray.get(1) != null) {
                                this.mXA.mQj.a((ArrayList) sparseArray.get(1));
                                if (this.mXC != null && !this.mXC.Od(11)) {
                                    this.mXC.O(this.mXC.Oe(11));
                                }
                            }
                            if (sparseArray.get(2) != null) {
                                this.mXA.mQj.b((ArrayList) sparseArray.get(2));
                                if (this.mXC != null && !this.mXC.Od(12)) {
                                    this.mXC.O(this.mXC.Oe(12));
                                }
                            }
                        } else if (this.mXA.mQj != null) {
                            if (this.mXA.mQj.d() && this.mXC != null && !this.mXC.Od(11)) {
                                this.mXC.O(this.mXC.Oe(11));
                            }
                            if (this.mXA.mQj.h() && this.mXC != null && !this.mXC.Od(12)) {
                                this.mXC.O(this.mXC.Oe(12));
                            }
                        }
                    }
                }
                if (arrayList2 != null && arrayList2.size() != 0) {
                    boolean z2 = false;
                    if (this.mXA != null) {
                        if (this.ap < 0) {
                            z2 = h.dAM().d;
                        } else {
                            z2 = h.dAM().e;
                        }
                    }
                    if (this.mYo != null && z2 && this.mYo.getVisibility() == 0) {
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
                                aVar2.nTM.icon = next.mGift.icon;
                                if (next.mItem != null && !tv.chushou.zues.utils.h.isEmpty(next.mItem.mType) && this.mXA != null && ((dBy = this.mXA.dBy()) == null || !next.mItem.mType.equals("1") || !next.mItem.mTargetKey.equals(dBy.mRoomID))) {
                                    aVar2.tag = next.mItem;
                                }
                                this.mYo.a(aVar2);
                            }
                        }
                    }
                    if (dCg() != null && (this.mXB instanceof VideoPlayer) && ((VideoPlayer) this.mXB).q) {
                        dCg().a(arrayList2);
                    }
                }
            }
        }
    }

    @Override // com.kascend.chushou.player.e
    public void k() {
        if (this.mXB instanceof VideoPlayer) {
            if (((VideoPlayer) this.mXB).q) {
                dBQ().setVisibility(0);
            } else {
                dBQ().setVisibility(8);
            }
        }
    }

    @Override // com.kascend.chushou.player.e
    public void l() {
        dBQ().setVisibility(8);
    }

    @Override // com.kascend.chushou.player.e
    public void m() {
        com.kascend.chushou.player.b.a dCg = dCg();
        if (dCg != null) {
            dCg.b();
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
        if (!this.k && this.mQL != null) {
            try {
                if (this.mTO != null) {
                    i = this.mTO.getCurrentPos();
                    i2 = this.mTO.getDuration();
                } else {
                    i = 0;
                }
                if (i2 > 1000) {
                    this.mQL.setProgress(i / (i2 / 1000));
                }
            } catch (NullPointerException e) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(boolean z, int i) {
        if (this.mQM != null) {
            if (z) {
                this.mQM.setStatusBarTintResource(i);
                this.mQM.setTintResource(i);
                this.mQM.setStatusBarTintEnabled(true);
                this.mQM.setNavigationBarTintEnabled(true);
                return;
            }
            this.mQM.setStatusBarTintEnabled(false);
            this.mQM.setNavigationBarTintEnabled(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(String str) {
        if (this.mXB instanceof VideoPlayer) {
            str = ((VideoPlayer) this.mXB).a(str);
        }
        com.kascend.chushou.d.a.c(this.mXB, str);
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
            if (this.mQN != null && this.mQN.mTP != null && !tv.chushou.zues.utils.h.isEmpty(this.mQN.mTP.mPkRoomId)) {
                ListItem listItem = new ListItem();
                if (this.mQN.mTP.liveStyle == 0 || this.mQN.mTP.liveStyle == 1) {
                    listItem.mLiveType = "1";
                } else {
                    listItem.mLiveType = "2";
                }
                listItem.mType = "1";
                listItem.mTargetKey = this.mQN.mTP.mPkRoomId;
                com.kascend.chushou.d.e.a(this.mXB, listItem, (JSONObject) null);
            }
        } else if (id == a.f.tv_pk_name && this.mQN != null && this.mQN.mTP != null && !tv.chushou.zues.utils.h.isEmpty(this.mQN.mTP.mPkUid)) {
            com.kascend.chushou.d.a.a(this.mXB, (JSONObject) null, this.mQN.mTP.mPkRoomId, this.mQN.mTP.mPkUid, LoginManager.Instance().getUserInfo() != null ? String.valueOf(LoginManager.Instance().getUserInfo().mUserID) : "", false);
        }
    }

    @Override // com.kascend.chushou.player.e
    public boolean a(MotionEvent motionEvent) {
        if ((motionEvent.getAction() == 1 || motionEvent.getAction() == 3 || motionEvent.getAction() == 4) && this.k && this.mTO != null) {
            this.k = false;
            this.kVw = Math.min(this.mTO.getDuration(), Math.max(0, this.mTO.getCurrentPos() + this.j));
            if (this.mXC != null) {
                this.mXC.removeMessages(14);
                this.mXC.Oc(14);
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

    /* loaded from: classes4.dex */
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
        if (this.mXA != null) {
            if (this.ap < 0) {
                z = h.dAM().d;
            } else {
                z = h.dAM().e;
            }
        }
        if (z && this.mYo != null && this.mYo.getVisibility() == 0) {
            if (((VideoPlayer) this.mXB).mOJ == null || (colorPrivileges = ((VideoPlayer) this.mXB).mOJ.mColorPrivileges) == null || tv.chushou.zues.utils.h.isEmpty(colorPrivileges.mColors)) {
                arrayList = null;
            } else {
                arrayList = tv.chushou.zues.toolkit.richtext.b.SH(tv.chushou.zues.toolkit.richtext.b.a(str, colorPrivileges.mColors, colorPrivileges.mWholeColor, new Random().nextInt(colorPrivileges.mColors.size())));
            }
            this.mYo.k(str, arrayList);
        }
    }

    public void f(int i) {
        com.kascend.chushou.c.c.dAI().a(i, new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.d.6
            @Override // com.kascend.chushou.c.b
            public void a() {
            }

            @Override // com.kascend.chushou.c.b
            public void a(String str, JSONObject jSONObject) {
                if (!d.this.dCG()) {
                    if (jSONObject != null) {
                        int optInt = jSONObject.optInt("data");
                        if (d.this.mXA != null && d.this.mXA.mQx != null) {
                            d.this.mXA.mQx.count = optInt;
                            d.this.M();
                        }
                        tv.chushou.zues.utils.g.Oj(a.i.str_buy_trumpte_success);
                        return;
                    }
                    a(-1, "");
                }
            }

            @Override // com.kascend.chushou.c.b
            public void a(int i2, String str) {
                String str2;
                if (!d.this.dCG()) {
                    if (i2 == 401) {
                        com.kascend.chushou.d.e.b(d.this.mXB, str);
                    } else if (i2 == 403) {
                        if (tv.chushou.zues.utils.h.isEmpty(str)) {
                            str = d.this.mXB.getString(a.i.str_blacklist);
                        }
                        tv.chushou.zues.utils.g.c(d.this.mXB, str);
                    } else if (i2 == 1027) {
                        if (!(d.this.mXB instanceof VideoPlayer)) {
                            str2 = null;
                        } else {
                            str2 = ((VideoPlayer) d.this.mXB).a((String) null);
                        }
                        com.kascend.chushou.d.e.a(d.this.getActivity(), str2);
                    } else if (tv.chushou.zues.utils.h.isEmpty(str)) {
                        tv.chushou.zues.utils.g.Oj(a.i.str_buy_trumpte_failuer);
                    } else {
                        tv.chushou.zues.utils.g.u(str);
                    }
                }
            }
        });
    }

    public void a(String str, String str2) {
        com.kascend.chushou.c.c.dAI().c(str, str2, new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.d.7
            @Override // com.kascend.chushou.c.b
            public void a() {
            }

            @Override // com.kascend.chushou.c.b
            public void a(String str3, JSONObject jSONObject) {
                if (!d.this.dCG() && jSONObject != null) {
                    int optInt = jSONObject.optInt("data");
                    tv.chushou.zues.utils.g.Oj(a.i.str_send_success);
                    if (d.this.mXA != null && d.this.mXA.mQx != null) {
                        d.this.mXA.mQx.count = optInt;
                        d.this.M();
                        return;
                    }
                    a(-1, "");
                }
            }

            @Override // com.kascend.chushou.c.b
            public void a(int i, String str3) {
                if (!d.this.dCG()) {
                    if (i == 401) {
                        com.kascend.chushou.d.e.b(d.this.mXB, str3);
                    } else if (i == 403 && tv.chushou.zues.utils.h.isEmpty(str3)) {
                        str3 = d.this.mXB.getString(a.i.str_blacklist);
                    }
                    if (tv.chushou.zues.utils.h.isEmpty(str3)) {
                        tv.chushou.zues.utils.g.M(d.this.mXB, a.i.str_send_fail);
                    } else {
                        tv.chushou.zues.utils.g.c(d.this.mXB, str3);
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void t() {
        final int hj = tv.chushou.zues.utils.systemBar.b.hj(getActivity());
        this.mQS.setOnActionListener(new VoiceInteractionView.b() { // from class: com.kascend.chushou.player.d.8
            @Override // com.kascend.chushou.widget.VoiceInteractionView.b
            public void a() {
                ListItem listItem = new ListItem();
                listItem.mUrl = com.kascend.chushou.c.c.a(50);
                d.this.a(listItem);
            }

            @Override // com.kascend.chushou.widget.VoiceInteractionView.b
            public void b() {
                com.kascend.chushou.d.e.a(d.this.mXB, com.kascend.chushou.c.c.a(51) + "micRoomId=" + d.this.G);
            }

            @Override // com.kascend.chushou.widget.VoiceInteractionView.b
            public void a(int i, MicMemberInfo micMemberInfo, boolean z) {
                if (micMemberInfo != null) {
                    if (!z) {
                        com.kascend.chushou.d.a.a(d.this.mXB, (JSONObject) null, (String) null, micMemberInfo.uid, LoginManager.Instance().getUserInfo() != null ? String.valueOf(LoginManager.Instance().getUserInfo().mUserID) : "", false);
                        return;
                    }
                    micMemberInfo.micRoomId = d.this.G;
                    if (d.this.ap == 0) {
                        boolean z2 = d.this.mYg == null;
                        d.this.a(false, false, micMemberInfo);
                        if (z2 && hj > 0 && d.this.mYg != null && tv.chushou.zues.utils.systemBar.b.aC(d.this.getActivity()) && tv.chushou.zues.utils.systemBar.b.aD(d.this.getActivity())) {
                            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) d.this.mYg.getLayoutParams();
                            layoutParams.rightMargin += hj;
                            d.this.mYg.setLayoutParams(layoutParams);
                            return;
                        }
                        return;
                    }
                    boolean z3 = d.this.mYg == null;
                    if (d.this.mXB.getResources().getDisplayMetrics().density < 2.0f) {
                        d.this.a(true, false, micMemberInfo);
                    } else {
                        d.this.a(true, true, micMemberInfo);
                    }
                    if (z3 && hj > 0 && d.this.mYg != null) {
                        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) d.this.mYg.getLayoutParams();
                        layoutParams2.bottomMargin += hj;
                        d.this.mYg.setLayoutParams(layoutParams2);
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
        if (this.mXA.dBw().mMicStatus.onMic != this.E) {
            this.E = this.mXA.dBw().mMicStatus.onMic;
            u();
        }
        this.E = this.mXA.dBw().mMicStatus.onMic;
        if (this.E) {
            if (this.mXA.dBw().mMicStatus != null && !tv.chushou.zues.utils.h.isEmpty(this.mXA.dBw().mMicStatus.micRoomId) && !this.mXA.dBw().mMicStatus.micRoomId.equals("0")) {
                this.G = this.mXA.dBw().mMicStatus.micRoomId;
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
            if (this.mQS != null) {
                b(true);
                this.mQS.setupCount(this.mXA.dBw().mMicStatus.capacity - 1);
                this.mQS.a(this.mXA.dBw().mMicStatus.isOngoing == 1, z, this.mXA.dBw().mMicStatus.displayInteraction == 1);
                this.mQS.a(arrayList);
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

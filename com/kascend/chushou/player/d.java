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
/* loaded from: classes5.dex */
public abstract class d extends g implements View.OnClickListener, b.a {
    protected static int q;
    protected static int r;
    protected TextView B;
    protected String G;
    protected GestureDetector c;
    protected a mRo;
    protected com.kascend.chushou.widget.a.b mRq;
    protected tv.chushou.zues.utils.systemBar.a mRs;
    protected com.kascend.chushou.player.e.a mRt;
    protected com.kascend.chushou.player.e.b mRu;
    protected RelativeLayout mRv;
    protected VoiceInteractionView mRy;
    protected String u;
    protected TextView y;
    protected TextView z;
    protected ImageButton a = null;
    protected String b = null;
    private boolean mRp = false;
    protected boolean e = true;
    protected boolean f = false;
    protected TextView h = null;
    protected TextView i = null;
    protected int j = 0;
    protected boolean k = false;
    protected ProgressBar mRr = null;
    protected long m = 0;
    protected int n = 0;
    protected boolean p = false;
    private boolean Sp = false;
    protected boolean v = false;
    protected int w = -1;
    protected CycleLiveRoomInfo mRw = null;
    protected io.reactivex.disposables.b mRx = null;
    protected boolean E = false;
    protected boolean F = false;

    @Override // android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mYg = getActivity();
        if (dDO()) {
            tv.chushou.zues.utils.e.e("VideoPlayerBaseFragment", "killed in backgroud");
            return;
        }
        Point hd = tv.chushou.zues.utils.a.hd(this.mYg);
        q = Math.min(hd.x, hd.y) / 5;
        r = 200;
        this.mYi = (AudioManager) this.mYg.getApplicationContext().getSystemService("audio");
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
        cXu();
        dCM();
        ((VideoPlayer) this.mYg).m = false;
    }

    @Override // android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        this.ah = true;
        R();
        if (this.N != null && this.mUu != null) {
            this.N.setVisibility(8);
        }
        if (this.mYh != null) {
            this.mYh.removeMessages(15);
        }
        a(false, false);
        if (this.mYh != null) {
            this.mYh.removeMessages(1);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // com.kascend.chushou.player.f, android.support.v4.app.Fragment
    public void onDestroy() {
        this.mXP.dispose();
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(View view) {
        this.mXR = (RelativeLayout) view.findViewById(a.f.rl_audio);
        this.mXS = (FrescoThumbnailView) view.findViewById(a.f.iv_audio_bg);
        this.mXT = (ImageView) view.findViewById(a.f.iv_audio_avator_bg);
        this.mXU = (FrescoThumbnailView) view.findViewById(a.f.iv_audio_avator);
        this.S = (TextView) view.findViewById(a.f.tv_audio_playing);
        this.mXV = (TextView) view.findViewById(a.f.tv_open_video);
        this.mXV.setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b() {
        this.mYb = (ProgressBar) this.mXQ.findViewById(a.f.LoadingProgressBar);
        this.mYc = (TextView) this.mXQ.findViewById(a.f.LoadingPercent);
        this.mYd = (TextView) this.mXQ.findViewById(a.f.LoadingBuffer);
        this.mYe = (TextView) this.mXQ.findViewById(a.f.tv_change_lines);
        this.mYb.setVisibility(8);
        this.mYc.setVisibility(8);
        this.mYd.setVisibility(8);
        this.mYe.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c() {
        this.mRv = (RelativeLayout) this.mXQ.findViewById(a.f.rl_pk_name);
        this.y = (TextView) this.mXQ.findViewById(a.f.tv_pk_name);
        this.z = (TextView) this.mXQ.findViewById(a.f.tv_pk_subscribe);
        this.z.setOnClickListener(this);
        this.y.setOnClickListener(this);
        this.B = (TextView) this.mXQ.findViewById(a.f.iv_cyclelive_countdown);
    }

    private void dCM() {
        if (i() || h()) {
            if (this.N != null) {
                this.N.setVisibility(0);
            }
            this.mUu = ((VideoPlayer) this.mYg).dCc();
            if (this.mUu != null) {
                Uri uri = this.mUu.getUri();
                Uri dCh = ((VideoPlayer) this.mYg).dCh();
                if (!this.mYj) {
                    if (dCh != null && uri != null && !uri.equals(dCh)) {
                        ((VideoPlayer) this.mYg).a(true, (Uri) null, false);
                    } else if (h.dBU().a) {
                        ((VideoPlayer) this.mYg).a(true, (Uri) null, false);
                    } else if (((VideoPlayer) this.mYg).m) {
                        if (h() && this.mYf.d()) {
                            if (!this.ai) {
                                ((VideoPlayer) this.mYg).a(true, (Uri) null, false);
                                return;
                            }
                            return;
                        }
                        ((VideoPlayer) this.mYg).a(true, (Uri) null, false);
                    } else {
                        AudioManager audioManager = ((VideoPlayer) this.mYg).mPu;
                        VideoPlayer videoPlayer = (VideoPlayer) this.mYg;
                        audioManager.setStreamVolume(3, VideoPlayer.n, 0);
                        if (this.mYf.d()) {
                            if (!this.ai) {
                                if (this.ap < 0) {
                                    if (this.mYf.d) {
                                        T();
                                        if (this.mXY != null) {
                                            this.mXY.setImageResource(a.e.ic_btn_room_video_n);
                                        }
                                    } else {
                                        U();
                                        cXu();
                                        if (this.mXX != null) {
                                            this.mXX.setVisibility(0);
                                        }
                                        if (this.mXY != null) {
                                            this.mXY.setImageResource(a.e.ic_btn_room_audio_n);
                                        }
                                    }
                                }
                                m(true);
                            }
                        } else if (!this.H && !this.al) {
                            ((VideoPlayer) this.mYg).a(true, (Uri) null, false);
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d() {
        FullRoomInfo dCE;
        tv.chushou.zues.utils.e.e("VideoPlayerBaseFragment", "release <----------");
        if (this.B != null) {
            this.B.setVisibility(8);
        }
        if (this.mRx != null) {
            this.mRx.dispose();
            this.mRx = null;
        }
        if (this.mYf != null && (dCE = this.mYf.dCE()) != null && !tv.chushou.zues.utils.h.isEmpty(dCE.mGeneralTabGifts)) {
            for (int i = 0; i < dCE.mGeneralTabGifts.size(); i++) {
                GeneralTabGift generalTabGift = dCE.mGeneralTabGifts.get(i);
                if (generalTabGift != null && !tv.chushou.zues.utils.h.isEmpty(generalTabGift.mGeneralGifts)) {
                    for (int i2 = 0; i2 < generalTabGift.mGeneralGifts.size(); i2++) {
                        if (generalTabGift.mGeneralGifts.get(i2) != null) {
                            generalTabGift.mGeneralGifts.get(i2).mSelectFlag = false;
                        }
                    }
                }
            }
        }
        if (this.mYD != null) {
            this.mYD.clear();
            this.mYD = null;
        }
        if (this.mRs != null) {
            this.mRs.setStatusBarTintEnabled(false);
            this.mRs.setNavigationBarTintEnabled(false);
        }
        if (this.mYT != null) {
            this.mYT.unInit();
            this.mYT = null;
            dDP().removeAllViews();
        }
        if (this.mYH != null) {
            ((ViewGroup) this.mXQ).removeView(this.mYH);
            this.mYH = null;
        }
        if (this.mYU != null) {
            this.mYU.cancel();
            ArrayList<Animator> childAnimations = this.mYU.getChildAnimations();
            if (!tv.chushou.zues.utils.h.isEmpty(childAnimations)) {
                Iterator<Animator> it = childAnimations.iterator();
                while (it.hasNext()) {
                    it.next().removeAllListeners();
                }
            }
            this.mYU.removeAllListeners();
            this.mYU = null;
        }
        this.mYJ = null;
        if (this.N != null) {
            ((ViewGroup) this.mXQ).removeView(this.N);
            this.N = null;
        }
        if (this.mYP != null) {
            this.mYP.a();
            this.mYP = null;
        }
        if (this.mYZ != null) {
            this.mYZ.dismiss();
        }
        if (this.mYY != null) {
            this.mYY.dismiss();
        }
        this.a = null;
        this.mXQ = null;
        this.mYi = null;
        tv.chushou.zues.utils.e.i("VideoPlayerBaseFragment", "release ---------->");
    }

    @Override // com.kascend.chushou.player.e
    public void e() {
        this.H = false;
        this.mYj = false;
        wo(true);
        x();
    }

    public void a(PrivilegeInfo privilegeInfo) {
        ((VideoPlayer) this.mYg).mPp = privilegeInfo;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(String str) {
        ColorPrivileges colorPrivileges;
        ArrayList<RichText> arrayList = null;
        if (this.mYf != null && !tv.chushou.zues.utils.h.isEmpty(this.mYf.a) && this.mUu != null) {
            com.kascend.chushou.c.c.dBQ().a(new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.d.1
                @Override // com.kascend.chushou.c.b
                public void a() {
                }

                @Override // com.kascend.chushou.c.b
                public void a(String str2, JSONObject jSONObject) {
                    if (jSONObject != null) {
                        int optInt = jSONObject.optInt("code", -1);
                        String optString = jSONObject.optString("message");
                        if (optInt == 0) {
                            tv.chushou.zues.utils.g.M(d.this.mYg, a.i.str_send_success);
                        } else {
                            a(optInt, optString);
                        }
                    }
                }

                @Override // com.kascend.chushou.c.b
                public void a(int i, String str2) {
                    if (!tv.chushou.zues.utils.h.isEmpty(str2)) {
                        tv.chushou.zues.utils.g.c(d.this.mYg, str2);
                    } else {
                        tv.chushou.zues.utils.g.M(d.this.mYg, a.i.str_send_fail);
                    }
                }
            }, this.mYf.a, str, (String) null, this.mUu.getCurrentPos());
            if (this.mYT != null && this.mYT.getVisibility() == 0) {
                if (((VideoPlayer) this.mYg).mPp != null && (colorPrivileges = ((VideoPlayer) this.mYg).mPp.mColorPrivileges) != null && !tv.chushou.zues.utils.h.isEmpty(colorPrivileges.mColors)) {
                    arrayList = tv.chushou.zues.toolkit.richtext.b.SS(tv.chushou.zues.toolkit.richtext.b.a(str, colorPrivileges.mColors, colorPrivileges.mWholeColor, new Random().nextInt(colorPrivileges.mColors.size())));
                }
                this.mYT.j(str, arrayList);
            }
        }
    }

    public void a(String str, String str2, String str3, String str4) {
        ArrayList<RichText> arrayList;
        ColorPrivileges colorPrivileges;
        com.kascend.chushou.c.c.dBQ().a(new JsonCallbackWrapper() { // from class: com.kascend.chushou.player.d.2
            @Override // tv.chushou.basis.http.listener.JsonCallbackWrapper
            public void callStart() {
            }

            @Override // tv.chushou.basis.http.listener.JsonCallbackWrapper
            public void callSuccess(String str5, JSONObject jSONObject) {
                if (!d.this.dDO()) {
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
                if (!d.this.dDO()) {
                    if (i == 401) {
                        com.kascend.chushou.d.e.b(d.this.mYg, str5);
                    } else if (i == 403) {
                        if (tv.chushou.zues.utils.h.isEmpty(str5)) {
                            str5 = d.this.mYg.getString(a.i.str_blacklist);
                        }
                        tv.chushou.zues.utils.g.c(d.this.mYg, str5);
                    } else if (i == 21001 && !tv.chushou.zues.utils.h.isEmpty(str6)) {
                        try {
                            ParserRet dv = com.kascend.chushou.c.e.dv(new JSONObject(str6));
                            if ((dv.mData1 instanceof String) && !TextUtils.isEmpty((String) dv.mData1)) {
                                ListItem listItem = new ListItem();
                                listItem.mType = "99";
                                listItem.mUrl = (String) dv.mData1;
                                com.kascend.chushou.d.e.a(d.this.mYg, listItem, (JSONObject) null);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }, str, str3, str2, str4);
        boolean z = false;
        if (this.mYf != null) {
            if (this.ap < 0) {
                z = h.dBU().d;
            } else {
                z = h.dBU().e;
            }
        }
        if (z && this.mYT != null && this.mYT.getVisibility() == 0) {
            if (((VideoPlayer) this.mYg).mPp == null || (colorPrivileges = ((VideoPlayer) this.mYg).mPp.mColorPrivileges) == null || tv.chushou.zues.utils.h.isEmpty(colorPrivileges.mColors)) {
                arrayList = null;
            } else {
                arrayList = tv.chushou.zues.toolkit.richtext.b.SS(tv.chushou.zues.toolkit.richtext.b.a(str2, colorPrivileges.mColors, colorPrivileges.mWholeColor, new Random().nextInt(colorPrivileges.mColors.size())));
            }
            this.mYT.j(str2, arrayList);
        }
    }

    @Override // com.kascend.chushou.player.e
    public void f() {
        if (this.mYT != null) {
            this.mYT.SA(h.dBU().b());
        }
    }

    public void a(PlayUrl playUrl) {
        if (playUrl == null || playUrl.mSelectedUrl.length() == 0) {
            if (this.mYx != null) {
                this.mYx.dismiss();
                this.mYx = null;
            }
        } else if (this.mYx != null) {
            LinearLayout linearLayout = (LinearLayout) this.mYx.getContentView().findViewById(a.f.ll_pop_root);
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
        if (!c(true) && this.mYg != null) {
            ((Activity) this.mYg).finish();
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
        if (this.mYf == null) {
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean i() {
        FullRoomInfo dCE;
        RoomInfo roomInfo;
        return (this.mYf == null || (dCE = this.mYf.dCE()) == null || (roomInfo = dCE.mRoominfo) == null || tv.chushou.zues.utils.h.isEmpty(roomInfo.mGameId)) ? false : true;
    }

    @Override // com.kascend.chushou.player.e
    public void j() {
        if (this.mYT != null) {
            this.mYT.dPE();
        }
        a((PlayUrl) null);
        wo(true);
    }

    @Override // com.kascend.chushou.player.e
    public void a(b bVar) {
        com.kascend.chushou.player.b.a dDo = dDo();
        if (dDo != null) {
            dDo.a(bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(ParserRet parserRet) {
        SparseArray sparseArray;
        RoomInfo dCG;
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
                    if (this.mYg instanceof VideoPlayer) {
                        ((VideoPlayer) this.mYg).dCo().a(bangInfo);
                    }
                }
                if (sparseArray2.get(2) != null && (sparseArray2.get(2) instanceof ArrayList)) {
                    Iterator it = ((ArrayList) sparseArray2.get(2)).iterator();
                    while (it.hasNext()) {
                        com.kascend.chushou.player.ui.h5.c.a aVar = (com.kascend.chushou.player.ui.h5.c.a) it.next();
                        if (this.mYg instanceof VideoPlayer) {
                            ((VideoPlayer) this.mYg).c(aVar);
                        }
                    }
                }
                if (sparseArray2.get(3) != null && (sparseArray2.get(3) instanceof MicStatus) && this.mYf != null && this.mYf.dCE() != null) {
                    this.mYf.dCE().mMicStatus = (MicStatus) sparseArray2.get(3);
                    if (this.mYf.dCE().mMicStatus != null) {
                        if (this.mYf.dCE().mMicStatus.onMic) {
                            if (sparseArray2.get(4) != null && (sparseArray2.get(4) instanceof ArrayList) && LoginManager.Instance().getUserInfo() != null && !tv.chushou.zues.utils.h.isEmpty(LoginManager.Instance().getUserInfo().mUserID)) {
                                Iterator it2 = ((ArrayList) sparseArray2.get(4)).iterator();
                                while (true) {
                                    if (!it2.hasNext()) {
                                        z = false;
                                        break;
                                    }
                                    FanItem fanItem = (FanItem) it2.next();
                                    if (fanItem != null && String.valueOf(LoginManager.Instance().getUserInfo().mUserID).equals(fanItem.mUserId) && !String.valueOf(LoginManager.Instance().getUserInfo().mUserID).equals(this.mYf.dCE().mRoominfo.mCreatorUID)) {
                                        z = true;
                                        break;
                                    }
                                }
                                if (z) {
                                    this.J = 0.0f;
                                    if (this.mUu != null) {
                                        this.mUu.setVolume(this.J, this.J);
                                    }
                                } else if (this.Sp) {
                                    this.J = 1.0f;
                                    if (this.mUu != null) {
                                        this.mUu.setVolume(this.J, this.J);
                                    }
                                }
                                this.Sp = z;
                            }
                        } else if (this.mUu != null && this.Sp) {
                            this.J = 1.0f;
                            this.mUu.setVolume(this.J, this.J);
                        }
                    }
                }
                if (sparseArray2.get(5) != null) {
                    String obj = sparseArray2.get(5).toString();
                    if ("10003".equals(obj)) {
                        ((VideoPlayer) this.mYg).t = "10003";
                        if (this.mUu != null && "1".equals(this.aw) && !"2".equals(this.ay) && this.mUu.getPlayState() != 4) {
                            j();
                            ((VideoPlayer) this.mYg).m();
                        }
                    } else if ("10004".equals(obj)) {
                        tv.chushou.zues.utils.e.d("Rancune", "officeLine");
                        if (this.mYg instanceof VideoPlayer) {
                            ((VideoPlayer) this.mYg).t = "10004";
                            ox();
                        }
                    }
                }
                if (sparseArray2.get(6) != null) {
                    List<com.kascend.chushou.player.ui.h5.c.e> list = (List) sparseArray2.get(6);
                    if (!tv.chushou.zues.utils.h.isEmpty(list)) {
                        ((VideoPlayer) this.mYg).dCk().a(list);
                    }
                }
                if (sparseArray2.get(7) != null) {
                    ((VideoPlayer) this.mYg).dCl().a((List) sparseArray2.get(7));
                }
                if (sparseArray2.get(11) != null) {
                    ((VideoPlayer) this.mYg).dCm().a((com.kascend.chushou.player.ui.h5.c.c) sparseArray2.get(11));
                }
                if (sparseArray2.get(12) != null) {
                    AutoBang autoBang = (AutoBang) sparseArray2.get(12);
                    if (this.mYg instanceof VideoPlayer) {
                        ((VideoPlayer) this.mYg).dCo().a(autoBang);
                    }
                }
                if (sparseArray2.get(16) != null) {
                    com.kascend.chushou.player.ui.h5.c.b bVar = (com.kascend.chushou.player.ui.h5.c.b) sparseArray2.get(16);
                    if (this.mYg instanceof VideoPlayer) {
                        ArrayList arrayList = new ArrayList();
                        arrayList.add(bVar);
                        ((VideoPlayer) this.mYg).dCn().a(arrayList);
                    }
                }
                if (sparseArray2.get(19) != null && ((Boolean) sparseArray2.get(19)).booleanValue() && (this.mRw == null || tv.chushou.zues.utils.h.isEmpty(this.mRw.uid))) {
                    if (this.B != null) {
                        this.B.setVisibility(0);
                    }
                    if (this.mRx != null) {
                        this.mRx.dispose();
                        this.mRx = null;
                    }
                    this.mRx = io.reactivex.g.a(0L, 12L, 0L, 1L, TimeUnit.SECONDS).a(io.reactivex.a.b.a.dJi()).a(new io.reactivex.c.g<Long>() { // from class: com.kascend.chushou.player.d.3
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
                if (this.mYf != null) {
                    this.mYf.a(arrayList2);
                    if (((VideoPlayer) this.mYg).q) {
                        if (sparseArray != null) {
                            if (sparseArray.get(1) != null) {
                                this.mYf.mQO.a((ArrayList) sparseArray.get(1));
                                if (this.mYh != null && !this.mYh.Og(11)) {
                                    this.mYh.O(this.mYh.Oh(11));
                                }
                            }
                            if (sparseArray.get(2) != null) {
                                this.mYf.mQO.b((ArrayList) sparseArray.get(2));
                                if (this.mYh != null && !this.mYh.Og(12)) {
                                    this.mYh.O(this.mYh.Oh(12));
                                }
                            }
                        } else if (this.mYf.mQO != null) {
                            if (this.mYf.mQO.d() && this.mYh != null && !this.mYh.Og(11)) {
                                this.mYh.O(this.mYh.Oh(11));
                            }
                            if (this.mYf.mQO.h() && this.mYh != null && !this.mYh.Og(12)) {
                                this.mYh.O(this.mYh.Oh(12));
                            }
                        }
                    }
                }
                if (arrayList2 != null && arrayList2.size() != 0) {
                    boolean z2 = false;
                    if (this.mYf != null) {
                        if (this.ap < 0) {
                            z2 = h.dBU().d;
                        } else {
                            z2 = h.dBU().e;
                        }
                    }
                    if (this.mYT != null && z2 && this.mYT.getVisibility() == 0) {
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
                                aVar2.nUC.icon = next.mGift.icon;
                                if (next.mItem != null && !tv.chushou.zues.utils.h.isEmpty(next.mItem.mType) && this.mYf != null && ((dCG = this.mYf.dCG()) == null || !next.mItem.mType.equals("1") || !next.mItem.mTargetKey.equals(dCG.mRoomID))) {
                                    aVar2.tag = next.mItem;
                                }
                                this.mYT.a(aVar2);
                            }
                        }
                    }
                    if (dDo() != null && (this.mYg instanceof VideoPlayer) && ((VideoPlayer) this.mYg).q) {
                        dDo().a(arrayList2);
                    }
                }
            }
        }
    }

    @Override // com.kascend.chushou.player.e
    public void k() {
        if (this.mYg instanceof VideoPlayer) {
            if (((VideoPlayer) this.mYg).q) {
                dCY().setVisibility(0);
            } else {
                dCY().setVisibility(8);
            }
        }
    }

    @Override // com.kascend.chushou.player.e
    public void l() {
        dCY().setVisibility(8);
    }

    @Override // com.kascend.chushou.player.e
    public void m() {
        com.kascend.chushou.player.b.a dDo = dDo();
        if (dDo != null) {
            dDo.b();
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
        if (!this.k && this.mRr != null) {
            try {
                if (this.mUu != null) {
                    i = this.mUu.getCurrentPos();
                    i2 = this.mUu.getDuration();
                } else {
                    i = 0;
                }
                if (i2 > 1000) {
                    this.mRr.setProgress(i / (i2 / 1000));
                }
            } catch (NullPointerException e) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(boolean z, int i) {
        if (this.mRs != null) {
            if (z) {
                this.mRs.setStatusBarTintResource(i);
                this.mRs.setTintResource(i);
                this.mRs.setStatusBarTintEnabled(true);
                this.mRs.setNavigationBarTintEnabled(true);
                return;
            }
            this.mRs.setStatusBarTintEnabled(false);
            this.mRs.setNavigationBarTintEnabled(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(String str) {
        if (this.mYg instanceof VideoPlayer) {
            str = ((VideoPlayer) this.mYg).a(str);
        }
        com.kascend.chushou.d.a.c(this.mYg, str);
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
            if (this.mRt != null && this.mRt.mUv != null && !tv.chushou.zues.utils.h.isEmpty(this.mRt.mUv.mPkRoomId)) {
                ListItem listItem = new ListItem();
                if (this.mRt.mUv.liveStyle == 0 || this.mRt.mUv.liveStyle == 1) {
                    listItem.mLiveType = "1";
                } else {
                    listItem.mLiveType = "2";
                }
                listItem.mType = "1";
                listItem.mTargetKey = this.mRt.mUv.mPkRoomId;
                com.kascend.chushou.d.e.a(this.mYg, listItem, (JSONObject) null);
            }
        } else if (id == a.f.tv_pk_name && this.mRt != null && this.mRt.mUv != null && !tv.chushou.zues.utils.h.isEmpty(this.mRt.mUv.mPkUid)) {
            com.kascend.chushou.d.a.a(this.mYg, (JSONObject) null, this.mRt.mUv.mPkRoomId, this.mRt.mUv.mPkUid, LoginManager.Instance().getUserInfo() != null ? String.valueOf(LoginManager.Instance().getUserInfo().mUserID) : "", false);
        }
    }

    @Override // com.kascend.chushou.player.e
    public boolean a(MotionEvent motionEvent) {
        if ((motionEvent.getAction() == 1 || motionEvent.getAction() == 3 || motionEvent.getAction() == 4) && this.k && this.mUu != null) {
            this.k = false;
            this.kWe = Math.min(this.mUu.getDuration(), Math.max(0, this.mUu.getCurrentPos() + this.j));
            if (this.mYh != null) {
                this.mYh.removeMessages(14);
                this.mYh.Of(14);
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
        if (this.mYf != null) {
            if (this.ap < 0) {
                z = h.dBU().d;
            } else {
                z = h.dBU().e;
            }
        }
        if (z && this.mYT != null && this.mYT.getVisibility() == 0) {
            if (((VideoPlayer) this.mYg).mPp == null || (colorPrivileges = ((VideoPlayer) this.mYg).mPp.mColorPrivileges) == null || tv.chushou.zues.utils.h.isEmpty(colorPrivileges.mColors)) {
                arrayList = null;
            } else {
                arrayList = tv.chushou.zues.toolkit.richtext.b.SS(tv.chushou.zues.toolkit.richtext.b.a(str, colorPrivileges.mColors, colorPrivileges.mWholeColor, new Random().nextInt(colorPrivileges.mColors.size())));
            }
            this.mYT.j(str, arrayList);
        }
    }

    public void f(int i) {
        com.kascend.chushou.c.c.dBQ().a(i, new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.d.6
            @Override // com.kascend.chushou.c.b
            public void a() {
            }

            @Override // com.kascend.chushou.c.b
            public void a(String str, JSONObject jSONObject) {
                if (!d.this.dDO()) {
                    if (jSONObject != null) {
                        int optInt = jSONObject.optInt("data");
                        if (d.this.mYf != null && d.this.mYf.mRd != null) {
                            d.this.mYf.mRd.count = optInt;
                            d.this.M();
                        }
                        tv.chushou.zues.utils.g.Om(a.i.str_buy_trumpte_success);
                        return;
                    }
                    a(-1, "");
                }
            }

            @Override // com.kascend.chushou.c.b
            public void a(int i2, String str) {
                String str2;
                if (!d.this.dDO()) {
                    if (i2 == 401) {
                        com.kascend.chushou.d.e.b(d.this.mYg, str);
                    } else if (i2 == 403) {
                        if (tv.chushou.zues.utils.h.isEmpty(str)) {
                            str = d.this.mYg.getString(a.i.str_blacklist);
                        }
                        tv.chushou.zues.utils.g.c(d.this.mYg, str);
                    } else if (i2 == 1027) {
                        if (!(d.this.mYg instanceof VideoPlayer)) {
                            str2 = null;
                        } else {
                            str2 = ((VideoPlayer) d.this.mYg).a((String) null);
                        }
                        com.kascend.chushou.d.e.a(d.this.getActivity(), str2);
                    } else if (tv.chushou.zues.utils.h.isEmpty(str)) {
                        tv.chushou.zues.utils.g.Om(a.i.str_buy_trumpte_failuer);
                    } else {
                        tv.chushou.zues.utils.g.u(str);
                    }
                }
            }
        });
    }

    public void a(String str, String str2) {
        com.kascend.chushou.c.c.dBQ().c(str, str2, new com.kascend.chushou.c.b() { // from class: com.kascend.chushou.player.d.7
            @Override // com.kascend.chushou.c.b
            public void a() {
            }

            @Override // com.kascend.chushou.c.b
            public void a(String str3, JSONObject jSONObject) {
                if (!d.this.dDO() && jSONObject != null) {
                    int optInt = jSONObject.optInt("data");
                    tv.chushou.zues.utils.g.Om(a.i.str_send_success);
                    if (d.this.mYf != null && d.this.mYf.mRd != null) {
                        d.this.mYf.mRd.count = optInt;
                        d.this.M();
                        return;
                    }
                    a(-1, "");
                }
            }

            @Override // com.kascend.chushou.c.b
            public void a(int i, String str3) {
                if (!d.this.dDO()) {
                    if (i == 401) {
                        com.kascend.chushou.d.e.b(d.this.mYg, str3);
                    } else if (i == 403 && tv.chushou.zues.utils.h.isEmpty(str3)) {
                        str3 = d.this.mYg.getString(a.i.str_blacklist);
                    }
                    if (tv.chushou.zues.utils.h.isEmpty(str3)) {
                        tv.chushou.zues.utils.g.M(d.this.mYg, a.i.str_send_fail);
                    } else {
                        tv.chushou.zues.utils.g.c(d.this.mYg, str3);
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void t() {
        final int hi = tv.chushou.zues.utils.systemBar.b.hi(getActivity());
        this.mRy.setOnActionListener(new VoiceInteractionView.b() { // from class: com.kascend.chushou.player.d.8
            @Override // com.kascend.chushou.widget.VoiceInteractionView.b
            public void a() {
                ListItem listItem = new ListItem();
                listItem.mUrl = com.kascend.chushou.c.c.a(50);
                d.this.a(listItem);
            }

            @Override // com.kascend.chushou.widget.VoiceInteractionView.b
            public void b() {
                com.kascend.chushou.d.e.a(d.this.mYg, com.kascend.chushou.c.c.a(51) + "micRoomId=" + d.this.G);
            }

            @Override // com.kascend.chushou.widget.VoiceInteractionView.b
            public void a(int i, MicMemberInfo micMemberInfo, boolean z) {
                if (micMemberInfo != null) {
                    if (!z) {
                        com.kascend.chushou.d.a.a(d.this.mYg, (JSONObject) null, (String) null, micMemberInfo.uid, LoginManager.Instance().getUserInfo() != null ? String.valueOf(LoginManager.Instance().getUserInfo().mUserID) : "", false);
                        return;
                    }
                    micMemberInfo.micRoomId = d.this.G;
                    if (d.this.ap == 0) {
                        boolean z2 = d.this.mYL == null;
                        d.this.a(false, false, micMemberInfo);
                        if (z2 && hi > 0 && d.this.mYL != null && tv.chushou.zues.utils.systemBar.b.aD(d.this.getActivity()) && tv.chushou.zues.utils.systemBar.b.aE(d.this.getActivity())) {
                            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) d.this.mYL.getLayoutParams();
                            layoutParams.rightMargin += hi;
                            d.this.mYL.setLayoutParams(layoutParams);
                            return;
                        }
                        return;
                    }
                    boolean z3 = d.this.mYL == null;
                    if (d.this.mYg.getResources().getDisplayMetrics().density < 2.0f) {
                        d.this.a(true, false, micMemberInfo);
                    } else {
                        d.this.a(true, true, micMemberInfo);
                    }
                    if (z3 && hi > 0 && d.this.mYL != null) {
                        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) d.this.mYL.getLayoutParams();
                        layoutParams2.bottomMargin += hi;
                        d.this.mYL.setLayoutParams(layoutParams2);
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
        if (this.mYf.dCE().mMicStatus.onMic != this.E) {
            this.E = this.mYf.dCE().mMicStatus.onMic;
            u();
        }
        this.E = this.mYf.dCE().mMicStatus.onMic;
        if (this.E) {
            if (this.mYf.dCE().mMicStatus != null && !tv.chushou.zues.utils.h.isEmpty(this.mYf.dCE().mMicStatus.micRoomId) && !this.mYf.dCE().mMicStatus.micRoomId.equals("0")) {
                this.G = this.mYf.dCE().mMicStatus.micRoomId;
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
            if (this.mRy != null) {
                b(true);
                this.mRy.setupCount(this.mYf.dCE().mMicStatus.capacity - 1);
                this.mRy.a(this.mYf.dCE().mMicStatus.isOngoing == 1, z, this.mYf.dCE().mMicStatus.displayInteraction == 1);
                this.mRy.a(arrayList);
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

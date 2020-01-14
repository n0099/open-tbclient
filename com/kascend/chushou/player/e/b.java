package com.kascend.chushou.player.e;

import android.content.Context;
import android.view.View;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.kascend.chushou.a;
import com.kascend.chushou.constants.ListItem;
import com.kascend.chushou.constants.MyUserInfo;
import com.kascend.chushou.constants.PkNotifyInfo;
import com.kascend.chushou.constants.PkUpdateInfo;
import com.kascend.chushou.player.ui.pk.LivePKBar;
import com.kascend.chushou.player.ui.pk.LivePKBarStatus;
import com.kascend.chushou.player.ui.pk.LivePKBarUserValue;
import com.kascend.chushou.player.ui.pk.LivePKMvpView;
import com.kascend.chushou.player.ui.pk.LivePKPrepareAnimView;
import com.kascend.chushou.player.ui.pk.LivePKResultView;
import com.kascend.chushou.player.ui.pk.LivePkFirstKillView;
import java.util.LinkedHashMap;
import org.json.JSONObject;
import tv.chushou.zues.utils.h;
/* loaded from: classes4.dex */
public class b {
    private Context a;
    private ImageView h;
    private View l;
    private LivePKBar mTQ;
    private LivePKBarUserValue mTR;
    private LivePKBarStatus mTS;
    private AnimationSet mTT;
    private LivePKResultView mTU;
    private LivePKMvpView mTV;
    private LivePkFirstKillView mTW;
    private LivePKPrepareAnimView mTX;
    private a mTY;
    private final int b = 30;
    private final int c = 10;
    private final float d = 0.2f;
    private int[] m = {a.e.icon_live_pk_countdown_1, a.e.icon_live_pk_countdown_2, a.e.icon_live_pk_countdown_3, a.e.icon_live_pk_countdown_4, a.e.icon_live_pk_countdown_5, a.e.icon_live_pk_countdown_6, a.e.icon_live_pk_countdown_7, a.e.icon_live_pk_countdown_8, a.e.icon_live_pk_countdown_9, a.e.icon_live_pk_countdown_10};

    /* loaded from: classes4.dex */
    public interface a {
        void a(int i);
    }

    public void a(View view, View view2, Context context, a aVar) {
        this.a = context;
        this.mTQ = (LivePKBar) view.findViewById(a.f.live_pk_bar);
        this.mTU = (LivePKResultView) view.findViewById(a.f.live_pk_result_anim_view);
        this.mTV = (LivePKMvpView) view.findViewById(a.f.live_pk_mvp_anim_view);
        this.h = (ImageView) view.findViewById(a.f.img_live_pk_last_ten);
        this.mTW = (LivePkFirstKillView) view.findViewById(a.f.live_pk_first_blood_view);
        this.mTX = (LivePKPrepareAnimView) view.findViewById(a.f.live_pk_prepare);
        this.l = view2;
        this.mTY = aVar;
        d();
    }

    public void a(LivePKBarUserValue livePKBarUserValue, View view, View view2, Context context, a aVar) {
        this.a = context;
        this.mTR = livePKBarUserValue;
        this.mTS = (LivePKBarStatus) view.findViewById(a.f.live_pk_bar_status);
        this.mTU = (LivePKResultView) view.findViewById(a.f.live_pk_result_anim_view);
        this.mTV = (LivePKMvpView) view.findViewById(a.f.live_pk_mvp_anim_view);
        this.h = (ImageView) view.findViewById(a.f.img_live_pk_last_ten);
        this.mTW = (LivePkFirstKillView) view.findViewById(a.f.live_pk_first_blood_view);
        this.mTX = (LivePKPrepareAnimView) view.findViewById(a.f.live_pk_prepare);
        this.l = view2;
        this.mTY = aVar;
        d();
    }

    private void d() {
        this.mTT = (AnimationSet) AnimationUtils.loadAnimation(this.a, a.C0682a.pk_live_online_count_down_last_three);
        LivePKBar.b bVar = new LivePKBar.b() { // from class: com.kascend.chushou.player.e.b.1
            @Override // com.kascend.chushou.player.ui.pk.LivePKBar.b
            public void a(long j) {
                if (j <= 10 && j > 0) {
                    b.this.a((int) j);
                } else if (j <= 0) {
                    b.this.a(-1);
                }
            }

            @Override // com.kascend.chushou.player.ui.pk.LivePKBar.b
            public void b(long j) {
            }
        };
        if (this.mTQ != null) {
            this.mTQ.setClickListener(new LivePKBar.a() { // from class: com.kascend.chushou.player.e.b.2
                @Override // com.kascend.chushou.player.ui.pk.LivePKBar.a
                public void w(long j, int i) {
                    if (b.this.mTY != null) {
                        b.this.mTY.a(i);
                    }
                }

                @Override // com.kascend.chushou.player.ui.pk.LivePKBar.a
                public void a() {
                }

                @Override // com.kascend.chushou.player.ui.pk.LivePKBar.a
                public void b() {
                    if (b.this.a != null) {
                        ListItem listItem = new ListItem();
                        listItem.mUrl = com.kascend.chushou.c.c.a(48);
                        listItem.mType = "98";
                        listItem.mName = b.this.a.getString(a.i.pk_rule);
                        com.kascend.chushou.d.e.a(b.this.a, listItem, (JSONObject) null);
                    }
                }

                @Override // com.kascend.chushou.player.ui.pk.LivePKBar.a
                public void c() {
                    if (b.this.a != null) {
                        ListItem listItem = new ListItem();
                        listItem.mUrl = com.kascend.chushou.c.c.a(52);
                        listItem.mType = "98";
                        com.kascend.chushou.d.e.a(b.this.a, listItem, (JSONObject) null);
                    }
                }
            });
            this.mTQ.setCounterListener(bVar);
        }
        if (this.mTS != null) {
            this.mTS.setCounterListener(bVar);
        }
        if (this.mTR != null) {
            this.mTR.setClickListener(new LivePKBarUserValue.a() { // from class: com.kascend.chushou.player.e.b.3
                @Override // com.kascend.chushou.player.ui.pk.LivePKBarUserValue.a
                public void w(long j, int i) {
                    if (b.this.mTY != null) {
                        b.this.mTY.a(i);
                    }
                }

                @Override // com.kascend.chushou.player.ui.pk.LivePKBarUserValue.a
                public void a() {
                    if (b.this.a != null) {
                        ListItem listItem = new ListItem();
                        listItem.mUrl = com.kascend.chushou.c.c.a(48);
                        listItem.mType = "98";
                        listItem.mName = b.this.a.getString(a.i.pk_rule);
                        com.kascend.chushou.d.e.a(b.this.a, listItem, (JSONObject) null);
                    }
                }

                @Override // com.kascend.chushou.player.ui.pk.LivePKBarUserValue.a
                public void b() {
                    if (b.this.a != null) {
                        ListItem listItem = new ListItem();
                        listItem.mUrl = com.kascend.chushou.c.c.a(52);
                        listItem.mType = "98";
                        com.kascend.chushou.d.e.a(b.this.a, listItem, (JSONObject) null);
                    }
                }
            });
        }
    }

    public void a(int i, int i2) {
        if (this.mTQ != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mTQ.getLayoutParams();
            layoutParams.bottomMargin = i;
            this.mTQ.setLayoutParams(layoutParams);
        }
    }

    public void a(int i, long j, long j2, int i2, int i3) {
        if (this.mTW != null) {
            this.mTW.a();
        }
        if (i2 == 2) {
            if (this.mTQ != null) {
                this.mTQ.b();
            }
            if (this.mTS != null) {
                this.mTS.b();
            }
        }
        if (this.mTQ != null) {
            this.mTQ.a(j);
        }
        if (this.mTS != null) {
            this.mTS.a(j);
        }
        if (i == 0) {
            if (this.mTQ != null) {
                this.mTQ.b(i3, false);
            }
            if (this.mTS != null) {
                this.mTS.b(i3, false);
            }
            if (i2 == 2) {
                this.mTU.d();
            } else {
                this.mTU.b(false);
            }
            b();
        } else if (i == 1) {
            if (this.mTQ != null) {
                this.mTQ.b(i3, j2, false);
            }
            if (this.mTR != null) {
                this.mTR.b(j2);
            }
            if (this.mTS != null) {
                this.mTS.a(i3, false);
            }
            if (i2 == 2) {
                this.mTU.c(true);
            } else {
                this.mTU.a(true, false);
            }
            b();
        } else {
            if (this.mTQ != null) {
                this.mTQ.a(i3, j2, false);
            }
            if (this.mTR != null) {
                this.mTR.a(j2);
            }
            if (this.mTS != null) {
                this.mTS.a(i3, false);
            }
            if (i2 == 2) {
                this.mTU.c(false);
            } else {
                this.mTU.a(false, false);
            }
            b();
        }
    }

    public void w(long j, int i) {
        tv.chushou.zues.utils.e.d("guohe", "PkViewController.updateLivePkStop(): maxTime = " + j);
        if (i == 2) {
            if (this.mTQ != null) {
                this.mTQ.b();
            }
            if (this.mTS != null) {
                this.mTS.b();
            }
        } else {
            if (this.mTQ != null) {
                this.mTQ.a(j);
            }
            if (this.mTS != null) {
                this.mTS.a(j);
            }
        }
        a(-1);
        a(false, false, 0.0f);
        a(false, 0.0f, 0);
    }

    public void a(int i, long j, final String str, final String str2, long j2, int i2, int i3) {
        tv.chushou.zues.utils.e.d("guohe", "PkViewController.updateLivePkResult(): result = " + i);
        if (this.mTW != null) {
            this.mTW.a();
        }
        if (i2 == 2) {
            if (this.mTQ != null) {
                this.mTQ.b();
            }
            if (this.mTS != null) {
                this.mTS.b();
            }
        }
        if (i == 0) {
            if (this.mTQ != null) {
                this.mTQ.b(i3, false);
            }
            if (this.mTS != null) {
                this.mTS.b(i3, false);
            }
            this.mTU.setCallback(new LivePKResultView.a() { // from class: com.kascend.chushou.player.e.b.4
                @Override // com.kascend.chushou.player.ui.pk.LivePKResultView.a
                public void a() {
                    b.this.a();
                }
            });
            if (i2 == 2) {
                this.mTU.d();
            } else {
                this.mTU.a();
            }
            b();
        } else if (i == 1) {
            if (this.mTQ != null) {
                this.mTQ.b(i3, j, false);
            }
            if (this.mTR != null) {
                this.mTR.b(j);
            }
            if (this.mTS != null) {
                this.mTS.a(i3, false);
            }
            this.mTV.setCallback(new LivePKMvpView.a() { // from class: com.kascend.chushou.player.e.b.5
                @Override // com.kascend.chushou.player.ui.pk.LivePKMvpView.a
                public void a() {
                    b.this.a();
                }
            });
            this.mTU.setCallback(new LivePKResultView.a() { // from class: com.kascend.chushou.player.e.b.6
                @Override // com.kascend.chushou.player.ui.pk.LivePKResultView.a
                public void a() {
                    b.this.mTV.a(str, str2);
                }
            });
            if (i2 == 2) {
                this.mTU.c(true);
            } else {
                this.mTU.a(true);
            }
            b();
        } else {
            if (this.mTQ != null) {
                this.mTQ.a(i3, j, false);
            }
            if (this.mTR != null) {
                this.mTR.a(j);
            }
            if (this.mTS != null) {
                this.mTS.a(i3, false);
            }
            this.mTV.setCallback(new LivePKMvpView.a() { // from class: com.kascend.chushou.player.e.b.7
                @Override // com.kascend.chushou.player.ui.pk.LivePKMvpView.a
                public void a() {
                    b.this.a();
                }
            });
            this.mTU.setCallback(new LivePKResultView.a() { // from class: com.kascend.chushou.player.e.b.8
                @Override // com.kascend.chushou.player.ui.pk.LivePKResultView.a
                public void a() {
                    b.this.mTV.a(str, str2);
                }
            });
            if (i2 == 2) {
                this.mTU.c(false);
            } else {
                this.mTU.a(false);
            }
            b();
        }
    }

    public void a(PkNotifyInfo pkNotifyInfo, boolean z) {
        if (pkNotifyInfo != null && pkNotifyInfo.mPkUpdateInfo != null && !h.isEmpty(pkNotifyInfo.mPkUpdateInfo.specialMomentList)) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < pkNotifyInfo.mPkUpdateInfo.specialMomentList.size()) {
                    PkUpdateInfo.SpecialMoment specialMoment = pkNotifyInfo.mPkUpdateInfo.specialMomentList.get(i2);
                    if (specialMoment.type == 1 && !z) {
                        a(true, specialMoment.mineFirstblood, h.parseFloat(specialMoment.addition));
                    } else if (specialMoment.type == 2) {
                        a(true, h.parseFloat(specialMoment.addition), (int) specialMoment.remainDuration);
                    } else if (specialMoment.type == 3) {
                        if (this.mTR != null) {
                            this.mTR.c(h.parseFloat(specialMoment.addition), (int) specialMoment.remainDuration);
                        }
                        if (this.mTQ != null) {
                            this.mTQ.c(h.parseFloat(specialMoment.addition), (int) specialMoment.remainDuration);
                        }
                    } else if (specialMoment.type == 4) {
                        if (this.mTR != null) {
                            this.mTR.c(h.parseFloat(specialMoment.addition), (int) specialMoment.remainDuration);
                        }
                        if (this.mTQ != null) {
                            this.mTQ.c(h.parseFloat(specialMoment.addition), (int) specialMoment.remainDuration);
                        }
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        }
    }

    public void a(PkNotifyInfo pkNotifyInfo) {
        tv.chushou.zues.utils.e.d("guohe", "PkViewController.updateLivePkBar(): ");
        if (pkNotifyInfo != null && pkNotifyInfo.mPkUpdateInfo != null) {
            if (this.mTQ != null) {
                this.mTQ.a(h.parseLong(pkNotifyInfo.mPkUpdateInfo.receiveCount), h.parseLong(pkNotifyInfo.mPkUpdateInfo.opponentReceiveCount));
            }
            if (this.mTR != null) {
                this.mTR.a(h.parseLong(pkNotifyInfo.mPkUpdateInfo.receiveCount), h.parseLong(pkNotifyInfo.mPkUpdateInfo.opponentReceiveCount));
            }
            LinkedHashMap<Long, String> linkedHashMap = new LinkedHashMap<>();
            if (!h.isEmpty(pkNotifyInfo.mPkUpdateInfo.rewardList)) {
                for (int i = 0; i < pkNotifyInfo.mPkUpdateInfo.rewardList.size(); i++) {
                    MyUserInfo myUserInfo = pkNotifyInfo.mPkUpdateInfo.rewardList.get(i);
                    if (myUserInfo != null) {
                        linkedHashMap.put(Long.valueOf(h.parseLong(myUserInfo.mUserID)), myUserInfo.mHeadiconUrl);
                    }
                }
            }
            LinkedHashMap<Long, String> linkedHashMap2 = new LinkedHashMap<>();
            if (!h.isEmpty(pkNotifyInfo.mPkUpdateInfo.opponentRewardList)) {
                for (int i2 = 0; i2 < pkNotifyInfo.mPkUpdateInfo.opponentRewardList.size(); i2++) {
                    MyUserInfo myUserInfo2 = pkNotifyInfo.mPkUpdateInfo.opponentRewardList.get(i2);
                    if (myUserInfo2 != null) {
                        linkedHashMap2.put(Long.valueOf(h.parseLong(myUserInfo2.mUserID)), myUserInfo2.mHeadiconUrl);
                    }
                }
            }
            if (this.mTQ != null) {
                this.mTQ.a(linkedHashMap, linkedHashMap2);
            }
            if (this.mTR != null) {
                this.mTR.a(linkedHashMap, linkedHashMap2);
            }
        }
    }

    public void b(PkNotifyInfo pkNotifyInfo, boolean z) {
        tv.chushou.zues.utils.e.d("guohe", "PkViewController.showLivePkStartAnim(): pkNotifyInfo.mMaxPKDuration = " + pkNotifyInfo.mMaxPKDuration + ", pkNotifyInfo.mPkUpdateInfo.remainDuration = " + pkNotifyInfo.mPkUpdateInfo.remainDuration + ", inner = " + z);
        if (this.mTQ != null) {
            this.mTQ.setVisibility(0);
            this.mTQ.c();
            if (!z) {
                a(pkNotifyInfo);
            }
            this.mTQ.e();
            if (pkNotifyInfo.destinyInfo != null && pkNotifyInfo.destinyInfo.destinyId != 0) {
                this.mTQ.a(2, pkNotifyInfo.destinyInfo.pkBarIcon, pkNotifyInfo.destinyInfo.pkBarKey);
                this.mTQ.b(2);
            } else {
                this.mTQ.a(1, "", "");
                this.mTQ.d();
            }
            this.mTQ.a(30);
            this.mTQ.a(0.2f);
            if (z) {
                this.mTQ.b(pkNotifyInfo.mMaxPKDuration);
            } else {
                this.mTQ.b(pkNotifyInfo.mPkUpdateInfo.remainDuration);
            }
        }
        if (this.mTS != null && this.mTR != null) {
            this.mTS.setVisibility(0);
            this.mTS.c();
            if (!z) {
                a(pkNotifyInfo);
            }
            this.mTR.b();
            if (pkNotifyInfo.destinyInfo != null && pkNotifyInfo.destinyInfo.destinyId != 0) {
                this.mTR.a(2, pkNotifyInfo.destinyInfo.pkBarIcon, pkNotifyInfo.destinyInfo.pkBarKey);
                this.mTR.a(2);
            } else {
                this.mTR.a(1, "", "");
                this.mTR.e();
            }
            this.mTS.a(30);
            this.mTR.a(0.2f);
            if (z) {
                this.mTS.b(pkNotifyInfo.mMaxPKDuration);
            } else {
                this.mTS.b(pkNotifyInfo.mPkUpdateInfo.remainDuration);
            }
        }
    }

    public void a(int i, String str) {
    }

    public void a(int i) {
        if (i <= 10 && i > 0) {
            this.h.setVisibility(0);
            this.h.setImageResource(this.m[i - 1]);
            this.h.startAnimation(this.mTT);
        } else if (i <= 0) {
            this.h.clearAnimation();
            this.h.setVisibility(8);
        }
    }

    public void a(boolean z, boolean z2, float f) {
        if (this.mTW != null) {
            if (z) {
                this.mTW.a(z2, f);
            } else {
                this.mTW.a();
            }
        }
    }

    public void a(boolean z, float f, int i) {
    }

    public void g(boolean z, long j) {
        if (this.mTX != null) {
            if (z) {
                this.mTX.a(j);
            } else {
                this.mTX.a();
            }
        }
    }

    public void a() {
        if (this.l != null) {
            this.l.setVisibility(0);
        }
    }

    public void b() {
        if (this.l != null) {
            this.l.setVisibility(8);
        }
    }

    public void c() {
        if (this.mTQ != null) {
            this.mTQ.a();
        }
        if (this.mTR != null) {
            this.mTR.a();
        }
        if (this.mTS != null) {
            this.mTS.a();
        }
        if (this.mTU != null) {
            this.mTU.clearAnimation();
            this.mTU.b();
        }
        if (this.h != null) {
            this.h.clearAnimation();
            this.h.setVisibility(8);
        }
        if (this.mTW != null) {
            this.mTW.a();
        }
        if (this.mTV != null) {
            this.mTV.a();
        }
        if (this.mTX != null) {
            this.mTX.a();
        }
        a();
    }
}

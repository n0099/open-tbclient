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
/* loaded from: classes6.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private Context f4126a;
    private ImageView h;
    private View l;
    private LivePKBar pdB;
    private LivePKBarUserValue pdC;
    private LivePKBarStatus pdD;
    private AnimationSet pdE;
    private LivePKResultView pdF;
    private LivePKMvpView pdG;
    private LivePkFirstKillView pdH;
    private LivePKPrepareAnimView pdI;
    private a pdJ;
    private final int b = 30;
    private final int c = 10;
    private final float d = 0.2f;
    private int[] ado = {a.e.icon_live_pk_countdown_1, a.e.icon_live_pk_countdown_2, a.e.icon_live_pk_countdown_3, a.e.icon_live_pk_countdown_4, a.e.icon_live_pk_countdown_5, a.e.icon_live_pk_countdown_6, a.e.icon_live_pk_countdown_7, a.e.icon_live_pk_countdown_8, a.e.icon_live_pk_countdown_9, a.e.icon_live_pk_countdown_10};

    /* loaded from: classes6.dex */
    public interface a {
        void a(int i);
    }

    public void a(View view, View view2, Context context, a aVar) {
        this.f4126a = context;
        this.pdB = (LivePKBar) view.findViewById(a.f.live_pk_bar);
        this.pdF = (LivePKResultView) view.findViewById(a.f.live_pk_result_anim_view);
        this.pdG = (LivePKMvpView) view.findViewById(a.f.live_pk_mvp_anim_view);
        this.h = (ImageView) view.findViewById(a.f.img_live_pk_last_ten);
        this.pdH = (LivePkFirstKillView) view.findViewById(a.f.live_pk_first_blood_view);
        this.pdI = (LivePKPrepareAnimView) view.findViewById(a.f.live_pk_prepare);
        this.l = view2;
        this.pdJ = aVar;
        d();
    }

    public void a(LivePKBarUserValue livePKBarUserValue, View view, View view2, Context context, a aVar) {
        this.f4126a = context;
        this.pdC = livePKBarUserValue;
        this.pdD = (LivePKBarStatus) view.findViewById(a.f.live_pk_bar_status);
        this.pdF = (LivePKResultView) view.findViewById(a.f.live_pk_result_anim_view);
        this.pdG = (LivePKMvpView) view.findViewById(a.f.live_pk_mvp_anim_view);
        this.h = (ImageView) view.findViewById(a.f.img_live_pk_last_ten);
        this.pdH = (LivePkFirstKillView) view.findViewById(a.f.live_pk_first_blood_view);
        this.pdI = (LivePKPrepareAnimView) view.findViewById(a.f.live_pk_prepare);
        this.l = view2;
        this.pdJ = aVar;
        d();
    }

    private void d() {
        this.pdE = (AnimationSet) AnimationUtils.loadAnimation(this.f4126a, a.C0969a.pk_live_online_count_down_last_three);
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
        if (this.pdB != null) {
            this.pdB.setClickListener(new LivePKBar.a() { // from class: com.kascend.chushou.player.e.b.2
                @Override // com.kascend.chushou.player.ui.pk.LivePKBar.a
                public void J(long j, int i) {
                    if (b.this.pdJ != null) {
                        b.this.pdJ.a(i);
                    }
                }

                @Override // com.kascend.chushou.player.ui.pk.LivePKBar.a
                public void a() {
                }

                @Override // com.kascend.chushou.player.ui.pk.LivePKBar.a
                public void b() {
                    if (b.this.f4126a != null) {
                        ListItem listItem = new ListItem();
                        listItem.mUrl = com.kascend.chushou.c.c.a(48);
                        listItem.mType = "98";
                        listItem.mName = b.this.f4126a.getString(a.i.pk_rule);
                        com.kascend.chushou.d.e.a(b.this.f4126a, listItem, (JSONObject) null);
                    }
                }

                @Override // com.kascend.chushou.player.ui.pk.LivePKBar.a
                public void c() {
                    if (b.this.f4126a != null) {
                        ListItem listItem = new ListItem();
                        listItem.mUrl = com.kascend.chushou.c.c.a(52);
                        listItem.mType = "98";
                        com.kascend.chushou.d.e.a(b.this.f4126a, listItem, (JSONObject) null);
                    }
                }
            });
            this.pdB.setCounterListener(bVar);
        }
        if (this.pdD != null) {
            this.pdD.setCounterListener(bVar);
        }
        if (this.pdC != null) {
            this.pdC.setClickListener(new LivePKBarUserValue.a() { // from class: com.kascend.chushou.player.e.b.3
                @Override // com.kascend.chushou.player.ui.pk.LivePKBarUserValue.a
                public void J(long j, int i) {
                    if (b.this.pdJ != null) {
                        b.this.pdJ.a(i);
                    }
                }

                @Override // com.kascend.chushou.player.ui.pk.LivePKBarUserValue.a
                public void a() {
                    if (b.this.f4126a != null) {
                        ListItem listItem = new ListItem();
                        listItem.mUrl = com.kascend.chushou.c.c.a(48);
                        listItem.mType = "98";
                        listItem.mName = b.this.f4126a.getString(a.i.pk_rule);
                        com.kascend.chushou.d.e.a(b.this.f4126a, listItem, (JSONObject) null);
                    }
                }

                @Override // com.kascend.chushou.player.ui.pk.LivePKBarUserValue.a
                public void b() {
                    if (b.this.f4126a != null) {
                        ListItem listItem = new ListItem();
                        listItem.mUrl = com.kascend.chushou.c.c.a(52);
                        listItem.mType = "98";
                        com.kascend.chushou.d.e.a(b.this.f4126a, listItem, (JSONObject) null);
                    }
                }
            });
        }
    }

    public void a(int i, int i2) {
        if (this.pdB != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.pdB.getLayoutParams();
            layoutParams.bottomMargin = i;
            this.pdB.setLayoutParams(layoutParams);
        }
    }

    public void a(int i, long j, long j2, int i2, int i3) {
        if (this.pdH != null) {
            this.pdH.a();
        }
        if (i2 == 2) {
            if (this.pdB != null) {
                this.pdB.b();
            }
            if (this.pdD != null) {
                this.pdD.b();
            }
        }
        if (this.pdB != null) {
            this.pdB.a(j);
        }
        if (this.pdD != null) {
            this.pdD.a(j);
        }
        if (i == 0) {
            if (this.pdB != null) {
                this.pdB.b(i3, false);
            }
            if (this.pdD != null) {
                this.pdD.b(i3, false);
            }
            if (i2 == 2) {
                this.pdF.d();
            } else {
                this.pdF.b(false);
            }
            b();
        } else if (i == 1) {
            if (this.pdB != null) {
                this.pdB.b(i3, j2, false);
            }
            if (this.pdC != null) {
                this.pdC.b(j2);
            }
            if (this.pdD != null) {
                this.pdD.a(i3, false);
            }
            if (i2 == 2) {
                this.pdF.c(true);
            } else {
                this.pdF.a(true, false);
            }
            b();
        } else {
            if (this.pdB != null) {
                this.pdB.a(i3, j2, false);
            }
            if (this.pdC != null) {
                this.pdC.a(j2);
            }
            if (this.pdD != null) {
                this.pdD.a(i3, false);
            }
            if (i2 == 2) {
                this.pdF.c(false);
            } else {
                this.pdF.a(false, false);
            }
            b();
        }
    }

    public void J(long j, int i) {
        tv.chushou.zues.utils.e.d("guohe", "PkViewController.updateLivePkStop(): maxTime = " + j);
        if (i == 2) {
            if (this.pdB != null) {
                this.pdB.b();
            }
            if (this.pdD != null) {
                this.pdD.b();
            }
        } else {
            if (this.pdB != null) {
                this.pdB.a(j);
            }
            if (this.pdD != null) {
                this.pdD.a(j);
            }
        }
        a(-1);
        a(false, false, 0.0f);
        a(false, 0.0f, 0);
    }

    public void a(int i, long j, final String str, final String str2, long j2, int i2, int i3) {
        tv.chushou.zues.utils.e.d("guohe", "PkViewController.updateLivePkResult(): result = " + i);
        if (this.pdH != null) {
            this.pdH.a();
        }
        if (i2 == 2) {
            if (this.pdB != null) {
                this.pdB.b();
            }
            if (this.pdD != null) {
                this.pdD.b();
            }
        }
        if (i == 0) {
            if (this.pdB != null) {
                this.pdB.b(i3, false);
            }
            if (this.pdD != null) {
                this.pdD.b(i3, false);
            }
            this.pdF.setCallback(new LivePKResultView.a() { // from class: com.kascend.chushou.player.e.b.4
                @Override // com.kascend.chushou.player.ui.pk.LivePKResultView.a
                public void a() {
                    b.this.a();
                }
            });
            if (i2 == 2) {
                this.pdF.d();
            } else {
                this.pdF.a();
            }
            b();
        } else if (i == 1) {
            if (this.pdB != null) {
                this.pdB.b(i3, j, false);
            }
            if (this.pdC != null) {
                this.pdC.b(j);
            }
            if (this.pdD != null) {
                this.pdD.a(i3, false);
            }
            this.pdG.setCallback(new LivePKMvpView.a() { // from class: com.kascend.chushou.player.e.b.5
                @Override // com.kascend.chushou.player.ui.pk.LivePKMvpView.a
                public void a() {
                    b.this.a();
                }
            });
            this.pdF.setCallback(new LivePKResultView.a() { // from class: com.kascend.chushou.player.e.b.6
                @Override // com.kascend.chushou.player.ui.pk.LivePKResultView.a
                public void a() {
                    b.this.pdG.a(str, str2);
                }
            });
            if (i2 == 2) {
                this.pdF.c(true);
            } else {
                this.pdF.a(true);
            }
            b();
        } else {
            if (this.pdB != null) {
                this.pdB.a(i3, j, false);
            }
            if (this.pdC != null) {
                this.pdC.a(j);
            }
            if (this.pdD != null) {
                this.pdD.a(i3, false);
            }
            this.pdG.setCallback(new LivePKMvpView.a() { // from class: com.kascend.chushou.player.e.b.7
                @Override // com.kascend.chushou.player.ui.pk.LivePKMvpView.a
                public void a() {
                    b.this.a();
                }
            });
            this.pdF.setCallback(new LivePKResultView.a() { // from class: com.kascend.chushou.player.e.b.8
                @Override // com.kascend.chushou.player.ui.pk.LivePKResultView.a
                public void a() {
                    b.this.pdG.a(str, str2);
                }
            });
            if (i2 == 2) {
                this.pdF.c(false);
            } else {
                this.pdF.a(false);
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
                        if (this.pdC != null) {
                            this.pdC.d(h.parseFloat(specialMoment.addition), (int) specialMoment.remainDuration);
                        }
                        if (this.pdB != null) {
                            this.pdB.d(h.parseFloat(specialMoment.addition), (int) specialMoment.remainDuration);
                        }
                    } else if (specialMoment.type == 4) {
                        if (this.pdC != null) {
                            this.pdC.d(h.parseFloat(specialMoment.addition), (int) specialMoment.remainDuration);
                        }
                        if (this.pdB != null) {
                            this.pdB.d(h.parseFloat(specialMoment.addition), (int) specialMoment.remainDuration);
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
            if (this.pdB != null) {
                this.pdB.a(h.parseLong(pkNotifyInfo.mPkUpdateInfo.receiveCount), h.parseLong(pkNotifyInfo.mPkUpdateInfo.opponentReceiveCount));
            }
            if (this.pdC != null) {
                this.pdC.a(h.parseLong(pkNotifyInfo.mPkUpdateInfo.receiveCount), h.parseLong(pkNotifyInfo.mPkUpdateInfo.opponentReceiveCount));
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
            if (this.pdB != null) {
                this.pdB.a(linkedHashMap, linkedHashMap2);
            }
            if (this.pdC != null) {
                this.pdC.a(linkedHashMap, linkedHashMap2);
            }
        }
    }

    public void b(PkNotifyInfo pkNotifyInfo, boolean z) {
        tv.chushou.zues.utils.e.d("guohe", "PkViewController.showLivePkStartAnim(): pkNotifyInfo.mMaxPKDuration = " + pkNotifyInfo.mMaxPKDuration + ", pkNotifyInfo.mPkUpdateInfo.remainDuration = " + pkNotifyInfo.mPkUpdateInfo.remainDuration + ", inner = " + z);
        if (this.pdB != null) {
            this.pdB.setVisibility(0);
            this.pdB.c();
            if (!z) {
                a(pkNotifyInfo);
            }
            this.pdB.e();
            if (pkNotifyInfo.destinyInfo != null && pkNotifyInfo.destinyInfo.destinyId != 0) {
                this.pdB.a(2, pkNotifyInfo.destinyInfo.pkBarIcon, pkNotifyInfo.destinyInfo.pkBarKey);
                this.pdB.b(2);
            } else {
                this.pdB.a(1, "", "");
                this.pdB.d();
            }
            this.pdB.a(30);
            this.pdB.a(0.2f);
            if (z) {
                this.pdB.b(pkNotifyInfo.mMaxPKDuration);
            } else {
                this.pdB.b(pkNotifyInfo.mPkUpdateInfo.remainDuration);
            }
        }
        if (this.pdD != null && this.pdC != null) {
            this.pdD.setVisibility(0);
            this.pdD.c();
            if (!z) {
                a(pkNotifyInfo);
            }
            this.pdC.b();
            if (pkNotifyInfo.destinyInfo != null && pkNotifyInfo.destinyInfo.destinyId != 0) {
                this.pdC.a(2, pkNotifyInfo.destinyInfo.pkBarIcon, pkNotifyInfo.destinyInfo.pkBarKey);
                this.pdC.a(2);
            } else {
                this.pdC.a(1, "", "");
                this.pdC.e();
            }
            this.pdD.a(30);
            this.pdC.a(0.2f);
            if (z) {
                this.pdD.b(pkNotifyInfo.mMaxPKDuration);
            } else {
                this.pdD.b(pkNotifyInfo.mPkUpdateInfo.remainDuration);
            }
        }
    }

    public void a(int i, String str) {
    }

    public void a(int i) {
        if (i <= 10 && i > 0) {
            this.h.setVisibility(0);
            this.h.setImageResource(this.ado[i - 1]);
            this.h.startAnimation(this.pdE);
        } else if (i <= 0) {
            this.h.clearAnimation();
            this.h.setVisibility(8);
        }
    }

    public void a(boolean z, boolean z2, float f) {
        if (this.pdH != null) {
            if (z) {
                this.pdH.a(z2, f);
            } else {
                this.pdH.a();
            }
        }
    }

    public void a(boolean z, float f, int i) {
    }

    public void k(boolean z, long j) {
        if (this.pdI != null) {
            if (z) {
                this.pdI.a(j);
            } else {
                this.pdI.a();
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
        if (this.pdB != null) {
            this.pdB.a();
        }
        if (this.pdC != null) {
            this.pdC.a();
        }
        if (this.pdD != null) {
            this.pdD.a();
        }
        if (this.pdF != null) {
            this.pdF.clearAnimation();
            this.pdF.b();
        }
        if (this.h != null) {
            this.h.clearAnimation();
            this.h.setVisibility(8);
        }
        if (this.pdH != null) {
            this.pdH.a();
        }
        if (this.pdG != null) {
            this.pdG.a();
        }
        if (this.pdI != null) {
            this.pdI.a();
        }
        a();
    }
}

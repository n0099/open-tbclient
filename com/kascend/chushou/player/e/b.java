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
    private Context a;
    private ImageView h;
    private View l;
    private LivePKBar nsS;
    private LivePKBarUserValue nsT;
    private LivePKBarStatus nsU;
    private AnimationSet nsV;
    private LivePKResultView nsW;
    private LivePKMvpView nsX;
    private LivePkFirstKillView nsY;
    private LivePKPrepareAnimView nsZ;
    private a nta;
    private final int b = 30;
    private final int c = 10;
    private final float d = 0.2f;
    private int[] akm = {a.e.icon_live_pk_countdown_1, a.e.icon_live_pk_countdown_2, a.e.icon_live_pk_countdown_3, a.e.icon_live_pk_countdown_4, a.e.icon_live_pk_countdown_5, a.e.icon_live_pk_countdown_6, a.e.icon_live_pk_countdown_7, a.e.icon_live_pk_countdown_8, a.e.icon_live_pk_countdown_9, a.e.icon_live_pk_countdown_10};

    /* loaded from: classes6.dex */
    public interface a {
        void a(int i);
    }

    public void a(View view, View view2, Context context, a aVar) {
        this.a = context;
        this.nsS = (LivePKBar) view.findViewById(a.f.live_pk_bar);
        this.nsW = (LivePKResultView) view.findViewById(a.f.live_pk_result_anim_view);
        this.nsX = (LivePKMvpView) view.findViewById(a.f.live_pk_mvp_anim_view);
        this.h = (ImageView) view.findViewById(a.f.img_live_pk_last_ten);
        this.nsY = (LivePkFirstKillView) view.findViewById(a.f.live_pk_first_blood_view);
        this.nsZ = (LivePKPrepareAnimView) view.findViewById(a.f.live_pk_prepare);
        this.l = view2;
        this.nta = aVar;
        d();
    }

    public void a(LivePKBarUserValue livePKBarUserValue, View view, View view2, Context context, a aVar) {
        this.a = context;
        this.nsT = livePKBarUserValue;
        this.nsU = (LivePKBarStatus) view.findViewById(a.f.live_pk_bar_status);
        this.nsW = (LivePKResultView) view.findViewById(a.f.live_pk_result_anim_view);
        this.nsX = (LivePKMvpView) view.findViewById(a.f.live_pk_mvp_anim_view);
        this.h = (ImageView) view.findViewById(a.f.img_live_pk_last_ten);
        this.nsY = (LivePkFirstKillView) view.findViewById(a.f.live_pk_first_blood_view);
        this.nsZ = (LivePKPrepareAnimView) view.findViewById(a.f.live_pk_prepare);
        this.l = view2;
        this.nta = aVar;
        d();
    }

    private void d() {
        this.nsV = (AnimationSet) AnimationUtils.loadAnimation(this.a, a.C0824a.pk_live_online_count_down_last_three);
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
        if (this.nsS != null) {
            this.nsS.setClickListener(new LivePKBar.a() { // from class: com.kascend.chushou.player.e.b.2
                @Override // com.kascend.chushou.player.ui.pk.LivePKBar.a
                public void B(long j, int i) {
                    if (b.this.nta != null) {
                        b.this.nta.a(i);
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
            this.nsS.setCounterListener(bVar);
        }
        if (this.nsU != null) {
            this.nsU.setCounterListener(bVar);
        }
        if (this.nsT != null) {
            this.nsT.setClickListener(new LivePKBarUserValue.a() { // from class: com.kascend.chushou.player.e.b.3
                @Override // com.kascend.chushou.player.ui.pk.LivePKBarUserValue.a
                public void B(long j, int i) {
                    if (b.this.nta != null) {
                        b.this.nta.a(i);
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
        if (this.nsS != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.nsS.getLayoutParams();
            layoutParams.bottomMargin = i;
            this.nsS.setLayoutParams(layoutParams);
        }
    }

    public void a(int i, long j, long j2, int i2, int i3) {
        if (this.nsY != null) {
            this.nsY.a();
        }
        if (i2 == 2) {
            if (this.nsS != null) {
                this.nsS.b();
            }
            if (this.nsU != null) {
                this.nsU.b();
            }
        }
        if (this.nsS != null) {
            this.nsS.a(j);
        }
        if (this.nsU != null) {
            this.nsU.a(j);
        }
        if (i == 0) {
            if (this.nsS != null) {
                this.nsS.b(i3, false);
            }
            if (this.nsU != null) {
                this.nsU.b(i3, false);
            }
            if (i2 == 2) {
                this.nsW.d();
            } else {
                this.nsW.b(false);
            }
            b();
        } else if (i == 1) {
            if (this.nsS != null) {
                this.nsS.b(i3, j2, false);
            }
            if (this.nsT != null) {
                this.nsT.b(j2);
            }
            if (this.nsU != null) {
                this.nsU.a(i3, false);
            }
            if (i2 == 2) {
                this.nsW.c(true);
            } else {
                this.nsW.a(true, false);
            }
            b();
        } else {
            if (this.nsS != null) {
                this.nsS.a(i3, j2, false);
            }
            if (this.nsT != null) {
                this.nsT.a(j2);
            }
            if (this.nsU != null) {
                this.nsU.a(i3, false);
            }
            if (i2 == 2) {
                this.nsW.c(false);
            } else {
                this.nsW.a(false, false);
            }
            b();
        }
    }

    public void B(long j, int i) {
        tv.chushou.zues.utils.e.d("guohe", "PkViewController.updateLivePkStop(): maxTime = " + j);
        if (i == 2) {
            if (this.nsS != null) {
                this.nsS.b();
            }
            if (this.nsU != null) {
                this.nsU.b();
            }
        } else {
            if (this.nsS != null) {
                this.nsS.a(j);
            }
            if (this.nsU != null) {
                this.nsU.a(j);
            }
        }
        a(-1);
        a(false, false, 0.0f);
        a(false, 0.0f, 0);
    }

    public void a(int i, long j, final String str, final String str2, long j2, int i2, int i3) {
        tv.chushou.zues.utils.e.d("guohe", "PkViewController.updateLivePkResult(): result = " + i);
        if (this.nsY != null) {
            this.nsY.a();
        }
        if (i2 == 2) {
            if (this.nsS != null) {
                this.nsS.b();
            }
            if (this.nsU != null) {
                this.nsU.b();
            }
        }
        if (i == 0) {
            if (this.nsS != null) {
                this.nsS.b(i3, false);
            }
            if (this.nsU != null) {
                this.nsU.b(i3, false);
            }
            this.nsW.setCallback(new LivePKResultView.a() { // from class: com.kascend.chushou.player.e.b.4
                @Override // com.kascend.chushou.player.ui.pk.LivePKResultView.a
                public void a() {
                    b.this.a();
                }
            });
            if (i2 == 2) {
                this.nsW.d();
            } else {
                this.nsW.a();
            }
            b();
        } else if (i == 1) {
            if (this.nsS != null) {
                this.nsS.b(i3, j, false);
            }
            if (this.nsT != null) {
                this.nsT.b(j);
            }
            if (this.nsU != null) {
                this.nsU.a(i3, false);
            }
            this.nsX.setCallback(new LivePKMvpView.a() { // from class: com.kascend.chushou.player.e.b.5
                @Override // com.kascend.chushou.player.ui.pk.LivePKMvpView.a
                public void a() {
                    b.this.a();
                }
            });
            this.nsW.setCallback(new LivePKResultView.a() { // from class: com.kascend.chushou.player.e.b.6
                @Override // com.kascend.chushou.player.ui.pk.LivePKResultView.a
                public void a() {
                    b.this.nsX.a(str, str2);
                }
            });
            if (i2 == 2) {
                this.nsW.c(true);
            } else {
                this.nsW.a(true);
            }
            b();
        } else {
            if (this.nsS != null) {
                this.nsS.a(i3, j, false);
            }
            if (this.nsT != null) {
                this.nsT.a(j);
            }
            if (this.nsU != null) {
                this.nsU.a(i3, false);
            }
            this.nsX.setCallback(new LivePKMvpView.a() { // from class: com.kascend.chushou.player.e.b.7
                @Override // com.kascend.chushou.player.ui.pk.LivePKMvpView.a
                public void a() {
                    b.this.a();
                }
            });
            this.nsW.setCallback(new LivePKResultView.a() { // from class: com.kascend.chushou.player.e.b.8
                @Override // com.kascend.chushou.player.ui.pk.LivePKResultView.a
                public void a() {
                    b.this.nsX.a(str, str2);
                }
            });
            if (i2 == 2) {
                this.nsW.c(false);
            } else {
                this.nsW.a(false);
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
                        if (this.nsT != null) {
                            this.nsT.c(h.parseFloat(specialMoment.addition), (int) specialMoment.remainDuration);
                        }
                        if (this.nsS != null) {
                            this.nsS.c(h.parseFloat(specialMoment.addition), (int) specialMoment.remainDuration);
                        }
                    } else if (specialMoment.type == 4) {
                        if (this.nsT != null) {
                            this.nsT.c(h.parseFloat(specialMoment.addition), (int) specialMoment.remainDuration);
                        }
                        if (this.nsS != null) {
                            this.nsS.c(h.parseFloat(specialMoment.addition), (int) specialMoment.remainDuration);
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
            if (this.nsS != null) {
                this.nsS.a(h.parseLong(pkNotifyInfo.mPkUpdateInfo.receiveCount), h.parseLong(pkNotifyInfo.mPkUpdateInfo.opponentReceiveCount));
            }
            if (this.nsT != null) {
                this.nsT.a(h.parseLong(pkNotifyInfo.mPkUpdateInfo.receiveCount), h.parseLong(pkNotifyInfo.mPkUpdateInfo.opponentReceiveCount));
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
            if (this.nsS != null) {
                this.nsS.a(linkedHashMap, linkedHashMap2);
            }
            if (this.nsT != null) {
                this.nsT.a(linkedHashMap, linkedHashMap2);
            }
        }
    }

    public void b(PkNotifyInfo pkNotifyInfo, boolean z) {
        tv.chushou.zues.utils.e.d("guohe", "PkViewController.showLivePkStartAnim(): pkNotifyInfo.mMaxPKDuration = " + pkNotifyInfo.mMaxPKDuration + ", pkNotifyInfo.mPkUpdateInfo.remainDuration = " + pkNotifyInfo.mPkUpdateInfo.remainDuration + ", inner = " + z);
        if (this.nsS != null) {
            this.nsS.setVisibility(0);
            this.nsS.c();
            if (!z) {
                a(pkNotifyInfo);
            }
            this.nsS.e();
            if (pkNotifyInfo.destinyInfo != null && pkNotifyInfo.destinyInfo.destinyId != 0) {
                this.nsS.a(2, pkNotifyInfo.destinyInfo.pkBarIcon, pkNotifyInfo.destinyInfo.pkBarKey);
                this.nsS.b(2);
            } else {
                this.nsS.a(1, "", "");
                this.nsS.d();
            }
            this.nsS.a(30);
            this.nsS.a(0.2f);
            if (z) {
                this.nsS.b(pkNotifyInfo.mMaxPKDuration);
            } else {
                this.nsS.b(pkNotifyInfo.mPkUpdateInfo.remainDuration);
            }
        }
        if (this.nsU != null && this.nsT != null) {
            this.nsU.setVisibility(0);
            this.nsU.c();
            if (!z) {
                a(pkNotifyInfo);
            }
            this.nsT.b();
            if (pkNotifyInfo.destinyInfo != null && pkNotifyInfo.destinyInfo.destinyId != 0) {
                this.nsT.a(2, pkNotifyInfo.destinyInfo.pkBarIcon, pkNotifyInfo.destinyInfo.pkBarKey);
                this.nsT.a(2);
            } else {
                this.nsT.a(1, "", "");
                this.nsT.e();
            }
            this.nsU.a(30);
            this.nsT.a(0.2f);
            if (z) {
                this.nsU.b(pkNotifyInfo.mMaxPKDuration);
            } else {
                this.nsU.b(pkNotifyInfo.mPkUpdateInfo.remainDuration);
            }
        }
    }

    public void a(int i, String str) {
    }

    public void a(int i) {
        if (i <= 10 && i > 0) {
            this.h.setVisibility(0);
            this.h.setImageResource(this.akm[i - 1]);
            this.h.startAnimation(this.nsV);
        } else if (i <= 0) {
            this.h.clearAnimation();
            this.h.setVisibility(8);
        }
    }

    public void a(boolean z, boolean z2, float f) {
        if (this.nsY != null) {
            if (z) {
                this.nsY.a(z2, f);
            } else {
                this.nsY.a();
            }
        }
    }

    public void a(boolean z, float f, int i) {
    }

    public void g(boolean z, long j) {
        if (this.nsZ != null) {
            if (z) {
                this.nsZ.a(j);
            } else {
                this.nsZ.a();
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
        if (this.nsS != null) {
            this.nsS.a();
        }
        if (this.nsT != null) {
            this.nsT.a();
        }
        if (this.nsU != null) {
            this.nsU.a();
        }
        if (this.nsW != null) {
            this.nsW.clearAnimation();
            this.nsW.b();
        }
        if (this.h != null) {
            this.h.clearAnimation();
            this.h.setVisibility(8);
        }
        if (this.nsY != null) {
            this.nsY.a();
        }
        if (this.nsX != null) {
            this.nsX.a();
        }
        if (this.nsZ != null) {
            this.nsZ.a();
        }
        a();
    }
}

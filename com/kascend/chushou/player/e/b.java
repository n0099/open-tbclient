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
/* loaded from: classes5.dex */
public class b {
    private Context a;
    private ImageView h;
    private View l;
    private LivePKResultView mUA;
    private LivePKMvpView mUB;
    private LivePkFirstKillView mUC;
    private LivePKPrepareAnimView mUD;
    private a mUE;
    private LivePKBar mUw;
    private LivePKBarUserValue mUx;
    private LivePKBarStatus mUy;
    private AnimationSet mUz;
    private final int b = 30;
    private final int c = 10;
    private final float d = 0.2f;
    private int[] m = {a.e.icon_live_pk_countdown_1, a.e.icon_live_pk_countdown_2, a.e.icon_live_pk_countdown_3, a.e.icon_live_pk_countdown_4, a.e.icon_live_pk_countdown_5, a.e.icon_live_pk_countdown_6, a.e.icon_live_pk_countdown_7, a.e.icon_live_pk_countdown_8, a.e.icon_live_pk_countdown_9, a.e.icon_live_pk_countdown_10};

    /* loaded from: classes5.dex */
    public interface a {
        void a(int i);
    }

    public void a(View view, View view2, Context context, a aVar) {
        this.a = context;
        this.mUw = (LivePKBar) view.findViewById(a.f.live_pk_bar);
        this.mUA = (LivePKResultView) view.findViewById(a.f.live_pk_result_anim_view);
        this.mUB = (LivePKMvpView) view.findViewById(a.f.live_pk_mvp_anim_view);
        this.h = (ImageView) view.findViewById(a.f.img_live_pk_last_ten);
        this.mUC = (LivePkFirstKillView) view.findViewById(a.f.live_pk_first_blood_view);
        this.mUD = (LivePKPrepareAnimView) view.findViewById(a.f.live_pk_prepare);
        this.l = view2;
        this.mUE = aVar;
        d();
    }

    public void a(LivePKBarUserValue livePKBarUserValue, View view, View view2, Context context, a aVar) {
        this.a = context;
        this.mUx = livePKBarUserValue;
        this.mUy = (LivePKBarStatus) view.findViewById(a.f.live_pk_bar_status);
        this.mUA = (LivePKResultView) view.findViewById(a.f.live_pk_result_anim_view);
        this.mUB = (LivePKMvpView) view.findViewById(a.f.live_pk_mvp_anim_view);
        this.h = (ImageView) view.findViewById(a.f.img_live_pk_last_ten);
        this.mUC = (LivePkFirstKillView) view.findViewById(a.f.live_pk_first_blood_view);
        this.mUD = (LivePKPrepareAnimView) view.findViewById(a.f.live_pk_prepare);
        this.l = view2;
        this.mUE = aVar;
        d();
    }

    private void d() {
        this.mUz = (AnimationSet) AnimationUtils.loadAnimation(this.a, a.C0690a.pk_live_online_count_down_last_three);
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
        if (this.mUw != null) {
            this.mUw.setClickListener(new LivePKBar.a() { // from class: com.kascend.chushou.player.e.b.2
                @Override // com.kascend.chushou.player.ui.pk.LivePKBar.a
                public void w(long j, int i) {
                    if (b.this.mUE != null) {
                        b.this.mUE.a(i);
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
            this.mUw.setCounterListener(bVar);
        }
        if (this.mUy != null) {
            this.mUy.setCounterListener(bVar);
        }
        if (this.mUx != null) {
            this.mUx.setClickListener(new LivePKBarUserValue.a() { // from class: com.kascend.chushou.player.e.b.3
                @Override // com.kascend.chushou.player.ui.pk.LivePKBarUserValue.a
                public void w(long j, int i) {
                    if (b.this.mUE != null) {
                        b.this.mUE.a(i);
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
        if (this.mUw != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mUw.getLayoutParams();
            layoutParams.bottomMargin = i;
            this.mUw.setLayoutParams(layoutParams);
        }
    }

    public void a(int i, long j, long j2, int i2, int i3) {
        if (this.mUC != null) {
            this.mUC.a();
        }
        if (i2 == 2) {
            if (this.mUw != null) {
                this.mUw.b();
            }
            if (this.mUy != null) {
                this.mUy.b();
            }
        }
        if (this.mUw != null) {
            this.mUw.a(j);
        }
        if (this.mUy != null) {
            this.mUy.a(j);
        }
        if (i == 0) {
            if (this.mUw != null) {
                this.mUw.b(i3, false);
            }
            if (this.mUy != null) {
                this.mUy.b(i3, false);
            }
            if (i2 == 2) {
                this.mUA.d();
            } else {
                this.mUA.b(false);
            }
            b();
        } else if (i == 1) {
            if (this.mUw != null) {
                this.mUw.b(i3, j2, false);
            }
            if (this.mUx != null) {
                this.mUx.b(j2);
            }
            if (this.mUy != null) {
                this.mUy.a(i3, false);
            }
            if (i2 == 2) {
                this.mUA.c(true);
            } else {
                this.mUA.a(true, false);
            }
            b();
        } else {
            if (this.mUw != null) {
                this.mUw.a(i3, j2, false);
            }
            if (this.mUx != null) {
                this.mUx.a(j2);
            }
            if (this.mUy != null) {
                this.mUy.a(i3, false);
            }
            if (i2 == 2) {
                this.mUA.c(false);
            } else {
                this.mUA.a(false, false);
            }
            b();
        }
    }

    public void w(long j, int i) {
        tv.chushou.zues.utils.e.d("guohe", "PkViewController.updateLivePkStop(): maxTime = " + j);
        if (i == 2) {
            if (this.mUw != null) {
                this.mUw.b();
            }
            if (this.mUy != null) {
                this.mUy.b();
            }
        } else {
            if (this.mUw != null) {
                this.mUw.a(j);
            }
            if (this.mUy != null) {
                this.mUy.a(j);
            }
        }
        a(-1);
        a(false, false, 0.0f);
        a(false, 0.0f, 0);
    }

    public void a(int i, long j, final String str, final String str2, long j2, int i2, int i3) {
        tv.chushou.zues.utils.e.d("guohe", "PkViewController.updateLivePkResult(): result = " + i);
        if (this.mUC != null) {
            this.mUC.a();
        }
        if (i2 == 2) {
            if (this.mUw != null) {
                this.mUw.b();
            }
            if (this.mUy != null) {
                this.mUy.b();
            }
        }
        if (i == 0) {
            if (this.mUw != null) {
                this.mUw.b(i3, false);
            }
            if (this.mUy != null) {
                this.mUy.b(i3, false);
            }
            this.mUA.setCallback(new LivePKResultView.a() { // from class: com.kascend.chushou.player.e.b.4
                @Override // com.kascend.chushou.player.ui.pk.LivePKResultView.a
                public void a() {
                    b.this.a();
                }
            });
            if (i2 == 2) {
                this.mUA.d();
            } else {
                this.mUA.a();
            }
            b();
        } else if (i == 1) {
            if (this.mUw != null) {
                this.mUw.b(i3, j, false);
            }
            if (this.mUx != null) {
                this.mUx.b(j);
            }
            if (this.mUy != null) {
                this.mUy.a(i3, false);
            }
            this.mUB.setCallback(new LivePKMvpView.a() { // from class: com.kascend.chushou.player.e.b.5
                @Override // com.kascend.chushou.player.ui.pk.LivePKMvpView.a
                public void a() {
                    b.this.a();
                }
            });
            this.mUA.setCallback(new LivePKResultView.a() { // from class: com.kascend.chushou.player.e.b.6
                @Override // com.kascend.chushou.player.ui.pk.LivePKResultView.a
                public void a() {
                    b.this.mUB.a(str, str2);
                }
            });
            if (i2 == 2) {
                this.mUA.c(true);
            } else {
                this.mUA.a(true);
            }
            b();
        } else {
            if (this.mUw != null) {
                this.mUw.a(i3, j, false);
            }
            if (this.mUx != null) {
                this.mUx.a(j);
            }
            if (this.mUy != null) {
                this.mUy.a(i3, false);
            }
            this.mUB.setCallback(new LivePKMvpView.a() { // from class: com.kascend.chushou.player.e.b.7
                @Override // com.kascend.chushou.player.ui.pk.LivePKMvpView.a
                public void a() {
                    b.this.a();
                }
            });
            this.mUA.setCallback(new LivePKResultView.a() { // from class: com.kascend.chushou.player.e.b.8
                @Override // com.kascend.chushou.player.ui.pk.LivePKResultView.a
                public void a() {
                    b.this.mUB.a(str, str2);
                }
            });
            if (i2 == 2) {
                this.mUA.c(false);
            } else {
                this.mUA.a(false);
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
                        if (this.mUx != null) {
                            this.mUx.c(h.parseFloat(specialMoment.addition), (int) specialMoment.remainDuration);
                        }
                        if (this.mUw != null) {
                            this.mUw.c(h.parseFloat(specialMoment.addition), (int) specialMoment.remainDuration);
                        }
                    } else if (specialMoment.type == 4) {
                        if (this.mUx != null) {
                            this.mUx.c(h.parseFloat(specialMoment.addition), (int) specialMoment.remainDuration);
                        }
                        if (this.mUw != null) {
                            this.mUw.c(h.parseFloat(specialMoment.addition), (int) specialMoment.remainDuration);
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
            if (this.mUw != null) {
                this.mUw.a(h.parseLong(pkNotifyInfo.mPkUpdateInfo.receiveCount), h.parseLong(pkNotifyInfo.mPkUpdateInfo.opponentReceiveCount));
            }
            if (this.mUx != null) {
                this.mUx.a(h.parseLong(pkNotifyInfo.mPkUpdateInfo.receiveCount), h.parseLong(pkNotifyInfo.mPkUpdateInfo.opponentReceiveCount));
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
            if (this.mUw != null) {
                this.mUw.a(linkedHashMap, linkedHashMap2);
            }
            if (this.mUx != null) {
                this.mUx.a(linkedHashMap, linkedHashMap2);
            }
        }
    }

    public void b(PkNotifyInfo pkNotifyInfo, boolean z) {
        tv.chushou.zues.utils.e.d("guohe", "PkViewController.showLivePkStartAnim(): pkNotifyInfo.mMaxPKDuration = " + pkNotifyInfo.mMaxPKDuration + ", pkNotifyInfo.mPkUpdateInfo.remainDuration = " + pkNotifyInfo.mPkUpdateInfo.remainDuration + ", inner = " + z);
        if (this.mUw != null) {
            this.mUw.setVisibility(0);
            this.mUw.c();
            if (!z) {
                a(pkNotifyInfo);
            }
            this.mUw.e();
            if (pkNotifyInfo.destinyInfo != null && pkNotifyInfo.destinyInfo.destinyId != 0) {
                this.mUw.a(2, pkNotifyInfo.destinyInfo.pkBarIcon, pkNotifyInfo.destinyInfo.pkBarKey);
                this.mUw.b(2);
            } else {
                this.mUw.a(1, "", "");
                this.mUw.d();
            }
            this.mUw.a(30);
            this.mUw.a(0.2f);
            if (z) {
                this.mUw.b(pkNotifyInfo.mMaxPKDuration);
            } else {
                this.mUw.b(pkNotifyInfo.mPkUpdateInfo.remainDuration);
            }
        }
        if (this.mUy != null && this.mUx != null) {
            this.mUy.setVisibility(0);
            this.mUy.c();
            if (!z) {
                a(pkNotifyInfo);
            }
            this.mUx.b();
            if (pkNotifyInfo.destinyInfo != null && pkNotifyInfo.destinyInfo.destinyId != 0) {
                this.mUx.a(2, pkNotifyInfo.destinyInfo.pkBarIcon, pkNotifyInfo.destinyInfo.pkBarKey);
                this.mUx.a(2);
            } else {
                this.mUx.a(1, "", "");
                this.mUx.e();
            }
            this.mUy.a(30);
            this.mUx.a(0.2f);
            if (z) {
                this.mUy.b(pkNotifyInfo.mMaxPKDuration);
            } else {
                this.mUy.b(pkNotifyInfo.mPkUpdateInfo.remainDuration);
            }
        }
    }

    public void a(int i, String str) {
    }

    public void a(int i) {
        if (i <= 10 && i > 0) {
            this.h.setVisibility(0);
            this.h.setImageResource(this.m[i - 1]);
            this.h.startAnimation(this.mUz);
        } else if (i <= 0) {
            this.h.clearAnimation();
            this.h.setVisibility(8);
        }
    }

    public void a(boolean z, boolean z2, float f) {
        if (this.mUC != null) {
            if (z) {
                this.mUC.a(z2, f);
            } else {
                this.mUC.a();
            }
        }
    }

    public void a(boolean z, float f, int i) {
    }

    public void g(boolean z, long j) {
        if (this.mUD != null) {
            if (z) {
                this.mUD.a(j);
            } else {
                this.mUD.a();
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
        if (this.mUw != null) {
            this.mUw.a();
        }
        if (this.mUx != null) {
            this.mUx.a();
        }
        if (this.mUy != null) {
            this.mUy.a();
        }
        if (this.mUA != null) {
            this.mUA.clearAnimation();
            this.mUA.b();
        }
        if (this.h != null) {
            this.h.clearAnimation();
            this.h.setVisibility(8);
        }
        if (this.mUC != null) {
            this.mUC.a();
        }
        if (this.mUB != null) {
            this.mUB.a();
        }
        if (this.mUD != null) {
            this.mUD.a();
        }
        a();
    }
}

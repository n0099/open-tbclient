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
    private Context f4128a;
    private ImageView h;
    private View l;
    private LivePKBar omk;
    private LivePKBarUserValue oml;
    private LivePKBarStatus omm;
    private AnimationSet omn;
    private LivePKResultView omo;
    private LivePKMvpView omp;
    private LivePkFirstKillView omq;
    private LivePKPrepareAnimView omr;
    private a oms;
    private final int b = 30;
    private final int c = 10;
    private final float d = 0.2f;
    private int[] adn = {a.e.icon_live_pk_countdown_1, a.e.icon_live_pk_countdown_2, a.e.icon_live_pk_countdown_3, a.e.icon_live_pk_countdown_4, a.e.icon_live_pk_countdown_5, a.e.icon_live_pk_countdown_6, a.e.icon_live_pk_countdown_7, a.e.icon_live_pk_countdown_8, a.e.icon_live_pk_countdown_9, a.e.icon_live_pk_countdown_10};

    /* loaded from: classes6.dex */
    public interface a {
        void a(int i);
    }

    public void a(View view, View view2, Context context, a aVar) {
        this.f4128a = context;
        this.omk = (LivePKBar) view.findViewById(a.f.live_pk_bar);
        this.omo = (LivePKResultView) view.findViewById(a.f.live_pk_result_anim_view);
        this.omp = (LivePKMvpView) view.findViewById(a.f.live_pk_mvp_anim_view);
        this.h = (ImageView) view.findViewById(a.f.img_live_pk_last_ten);
        this.omq = (LivePkFirstKillView) view.findViewById(a.f.live_pk_first_blood_view);
        this.omr = (LivePKPrepareAnimView) view.findViewById(a.f.live_pk_prepare);
        this.l = view2;
        this.oms = aVar;
        d();
    }

    public void a(LivePKBarUserValue livePKBarUserValue, View view, View view2, Context context, a aVar) {
        this.f4128a = context;
        this.oml = livePKBarUserValue;
        this.omm = (LivePKBarStatus) view.findViewById(a.f.live_pk_bar_status);
        this.omo = (LivePKResultView) view.findViewById(a.f.live_pk_result_anim_view);
        this.omp = (LivePKMvpView) view.findViewById(a.f.live_pk_mvp_anim_view);
        this.h = (ImageView) view.findViewById(a.f.img_live_pk_last_ten);
        this.omq = (LivePkFirstKillView) view.findViewById(a.f.live_pk_first_blood_view);
        this.omr = (LivePKPrepareAnimView) view.findViewById(a.f.live_pk_prepare);
        this.l = view2;
        this.oms = aVar;
        d();
    }

    private void d() {
        this.omn = (AnimationSet) AnimationUtils.loadAnimation(this.f4128a, a.C0897a.pk_live_online_count_down_last_three);
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
        if (this.omk != null) {
            this.omk.setClickListener(new LivePKBar.a() { // from class: com.kascend.chushou.player.e.b.2
                @Override // com.kascend.chushou.player.ui.pk.LivePKBar.a
                public void I(long j, int i) {
                    if (b.this.oms != null) {
                        b.this.oms.a(i);
                    }
                }

                @Override // com.kascend.chushou.player.ui.pk.LivePKBar.a
                public void a() {
                }

                @Override // com.kascend.chushou.player.ui.pk.LivePKBar.a
                public void b() {
                    if (b.this.f4128a != null) {
                        ListItem listItem = new ListItem();
                        listItem.mUrl = com.kascend.chushou.c.c.a(48);
                        listItem.mType = "98";
                        listItem.mName = b.this.f4128a.getString(a.i.pk_rule);
                        com.kascend.chushou.d.e.a(b.this.f4128a, listItem, (JSONObject) null);
                    }
                }

                @Override // com.kascend.chushou.player.ui.pk.LivePKBar.a
                public void c() {
                    if (b.this.f4128a != null) {
                        ListItem listItem = new ListItem();
                        listItem.mUrl = com.kascend.chushou.c.c.a(52);
                        listItem.mType = "98";
                        com.kascend.chushou.d.e.a(b.this.f4128a, listItem, (JSONObject) null);
                    }
                }
            });
            this.omk.setCounterListener(bVar);
        }
        if (this.omm != null) {
            this.omm.setCounterListener(bVar);
        }
        if (this.oml != null) {
            this.oml.setClickListener(new LivePKBarUserValue.a() { // from class: com.kascend.chushou.player.e.b.3
                @Override // com.kascend.chushou.player.ui.pk.LivePKBarUserValue.a
                public void I(long j, int i) {
                    if (b.this.oms != null) {
                        b.this.oms.a(i);
                    }
                }

                @Override // com.kascend.chushou.player.ui.pk.LivePKBarUserValue.a
                public void a() {
                    if (b.this.f4128a != null) {
                        ListItem listItem = new ListItem();
                        listItem.mUrl = com.kascend.chushou.c.c.a(48);
                        listItem.mType = "98";
                        listItem.mName = b.this.f4128a.getString(a.i.pk_rule);
                        com.kascend.chushou.d.e.a(b.this.f4128a, listItem, (JSONObject) null);
                    }
                }

                @Override // com.kascend.chushou.player.ui.pk.LivePKBarUserValue.a
                public void b() {
                    if (b.this.f4128a != null) {
                        ListItem listItem = new ListItem();
                        listItem.mUrl = com.kascend.chushou.c.c.a(52);
                        listItem.mType = "98";
                        com.kascend.chushou.d.e.a(b.this.f4128a, listItem, (JSONObject) null);
                    }
                }
            });
        }
    }

    public void a(int i, int i2) {
        if (this.omk != null) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.omk.getLayoutParams();
            layoutParams.bottomMargin = i;
            this.omk.setLayoutParams(layoutParams);
        }
    }

    public void a(int i, long j, long j2, int i2, int i3) {
        if (this.omq != null) {
            this.omq.a();
        }
        if (i2 == 2) {
            if (this.omk != null) {
                this.omk.b();
            }
            if (this.omm != null) {
                this.omm.b();
            }
        }
        if (this.omk != null) {
            this.omk.a(j);
        }
        if (this.omm != null) {
            this.omm.a(j);
        }
        if (i == 0) {
            if (this.omk != null) {
                this.omk.b(i3, false);
            }
            if (this.omm != null) {
                this.omm.b(i3, false);
            }
            if (i2 == 2) {
                this.omo.d();
            } else {
                this.omo.b(false);
            }
            b();
        } else if (i == 1) {
            if (this.omk != null) {
                this.omk.b(i3, j2, false);
            }
            if (this.oml != null) {
                this.oml.b(j2);
            }
            if (this.omm != null) {
                this.omm.a(i3, false);
            }
            if (i2 == 2) {
                this.omo.c(true);
            } else {
                this.omo.a(true, false);
            }
            b();
        } else {
            if (this.omk != null) {
                this.omk.a(i3, j2, false);
            }
            if (this.oml != null) {
                this.oml.a(j2);
            }
            if (this.omm != null) {
                this.omm.a(i3, false);
            }
            if (i2 == 2) {
                this.omo.c(false);
            } else {
                this.omo.a(false, false);
            }
            b();
        }
    }

    public void I(long j, int i) {
        tv.chushou.zues.utils.e.d("guohe", "PkViewController.updateLivePkStop(): maxTime = " + j);
        if (i == 2) {
            if (this.omk != null) {
                this.omk.b();
            }
            if (this.omm != null) {
                this.omm.b();
            }
        } else {
            if (this.omk != null) {
                this.omk.a(j);
            }
            if (this.omm != null) {
                this.omm.a(j);
            }
        }
        a(-1);
        a(false, false, 0.0f);
        a(false, 0.0f, 0);
    }

    public void a(int i, long j, final String str, final String str2, long j2, int i2, int i3) {
        tv.chushou.zues.utils.e.d("guohe", "PkViewController.updateLivePkResult(): result = " + i);
        if (this.omq != null) {
            this.omq.a();
        }
        if (i2 == 2) {
            if (this.omk != null) {
                this.omk.b();
            }
            if (this.omm != null) {
                this.omm.b();
            }
        }
        if (i == 0) {
            if (this.omk != null) {
                this.omk.b(i3, false);
            }
            if (this.omm != null) {
                this.omm.b(i3, false);
            }
            this.omo.setCallback(new LivePKResultView.a() { // from class: com.kascend.chushou.player.e.b.4
                @Override // com.kascend.chushou.player.ui.pk.LivePKResultView.a
                public void a() {
                    b.this.a();
                }
            });
            if (i2 == 2) {
                this.omo.d();
            } else {
                this.omo.a();
            }
            b();
        } else if (i == 1) {
            if (this.omk != null) {
                this.omk.b(i3, j, false);
            }
            if (this.oml != null) {
                this.oml.b(j);
            }
            if (this.omm != null) {
                this.omm.a(i3, false);
            }
            this.omp.setCallback(new LivePKMvpView.a() { // from class: com.kascend.chushou.player.e.b.5
                @Override // com.kascend.chushou.player.ui.pk.LivePKMvpView.a
                public void a() {
                    b.this.a();
                }
            });
            this.omo.setCallback(new LivePKResultView.a() { // from class: com.kascend.chushou.player.e.b.6
                @Override // com.kascend.chushou.player.ui.pk.LivePKResultView.a
                public void a() {
                    b.this.omp.a(str, str2);
                }
            });
            if (i2 == 2) {
                this.omo.c(true);
            } else {
                this.omo.a(true);
            }
            b();
        } else {
            if (this.omk != null) {
                this.omk.a(i3, j, false);
            }
            if (this.oml != null) {
                this.oml.a(j);
            }
            if (this.omm != null) {
                this.omm.a(i3, false);
            }
            this.omp.setCallback(new LivePKMvpView.a() { // from class: com.kascend.chushou.player.e.b.7
                @Override // com.kascend.chushou.player.ui.pk.LivePKMvpView.a
                public void a() {
                    b.this.a();
                }
            });
            this.omo.setCallback(new LivePKResultView.a() { // from class: com.kascend.chushou.player.e.b.8
                @Override // com.kascend.chushou.player.ui.pk.LivePKResultView.a
                public void a() {
                    b.this.omp.a(str, str2);
                }
            });
            if (i2 == 2) {
                this.omo.c(false);
            } else {
                this.omo.a(false);
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
                        if (this.oml != null) {
                            this.oml.c(h.parseFloat(specialMoment.addition), (int) specialMoment.remainDuration);
                        }
                        if (this.omk != null) {
                            this.omk.c(h.parseFloat(specialMoment.addition), (int) specialMoment.remainDuration);
                        }
                    } else if (specialMoment.type == 4) {
                        if (this.oml != null) {
                            this.oml.c(h.parseFloat(specialMoment.addition), (int) specialMoment.remainDuration);
                        }
                        if (this.omk != null) {
                            this.omk.c(h.parseFloat(specialMoment.addition), (int) specialMoment.remainDuration);
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
            if (this.omk != null) {
                this.omk.a(h.parseLong(pkNotifyInfo.mPkUpdateInfo.receiveCount), h.parseLong(pkNotifyInfo.mPkUpdateInfo.opponentReceiveCount));
            }
            if (this.oml != null) {
                this.oml.a(h.parseLong(pkNotifyInfo.mPkUpdateInfo.receiveCount), h.parseLong(pkNotifyInfo.mPkUpdateInfo.opponentReceiveCount));
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
            if (this.omk != null) {
                this.omk.a(linkedHashMap, linkedHashMap2);
            }
            if (this.oml != null) {
                this.oml.a(linkedHashMap, linkedHashMap2);
            }
        }
    }

    public void b(PkNotifyInfo pkNotifyInfo, boolean z) {
        tv.chushou.zues.utils.e.d("guohe", "PkViewController.showLivePkStartAnim(): pkNotifyInfo.mMaxPKDuration = " + pkNotifyInfo.mMaxPKDuration + ", pkNotifyInfo.mPkUpdateInfo.remainDuration = " + pkNotifyInfo.mPkUpdateInfo.remainDuration + ", inner = " + z);
        if (this.omk != null) {
            this.omk.setVisibility(0);
            this.omk.c();
            if (!z) {
                a(pkNotifyInfo);
            }
            this.omk.e();
            if (pkNotifyInfo.destinyInfo != null && pkNotifyInfo.destinyInfo.destinyId != 0) {
                this.omk.a(2, pkNotifyInfo.destinyInfo.pkBarIcon, pkNotifyInfo.destinyInfo.pkBarKey);
                this.omk.b(2);
            } else {
                this.omk.a(1, "", "");
                this.omk.d();
            }
            this.omk.a(30);
            this.omk.a(0.2f);
            if (z) {
                this.omk.b(pkNotifyInfo.mMaxPKDuration);
            } else {
                this.omk.b(pkNotifyInfo.mPkUpdateInfo.remainDuration);
            }
        }
        if (this.omm != null && this.oml != null) {
            this.omm.setVisibility(0);
            this.omm.c();
            if (!z) {
                a(pkNotifyInfo);
            }
            this.oml.b();
            if (pkNotifyInfo.destinyInfo != null && pkNotifyInfo.destinyInfo.destinyId != 0) {
                this.oml.a(2, pkNotifyInfo.destinyInfo.pkBarIcon, pkNotifyInfo.destinyInfo.pkBarKey);
                this.oml.a(2);
            } else {
                this.oml.a(1, "", "");
                this.oml.e();
            }
            this.omm.a(30);
            this.oml.a(0.2f);
            if (z) {
                this.omm.b(pkNotifyInfo.mMaxPKDuration);
            } else {
                this.omm.b(pkNotifyInfo.mPkUpdateInfo.remainDuration);
            }
        }
    }

    public void a(int i, String str) {
    }

    public void a(int i) {
        if (i <= 10 && i > 0) {
            this.h.setVisibility(0);
            this.h.setImageResource(this.adn[i - 1]);
            this.h.startAnimation(this.omn);
        } else if (i <= 0) {
            this.h.clearAnimation();
            this.h.setVisibility(8);
        }
    }

    public void a(boolean z, boolean z2, float f) {
        if (this.omq != null) {
            if (z) {
                this.omq.a(z2, f);
            } else {
                this.omq.a();
            }
        }
    }

    public void a(boolean z, float f, int i) {
    }

    public void j(boolean z, long j) {
        if (this.omr != null) {
            if (z) {
                this.omr.a(j);
            } else {
                this.omr.a();
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
        if (this.omk != null) {
            this.omk.a();
        }
        if (this.oml != null) {
            this.oml.a();
        }
        if (this.omm != null) {
            this.omm.a();
        }
        if (this.omo != null) {
            this.omo.clearAnimation();
            this.omo.b();
        }
        if (this.h != null) {
            this.h.clearAnimation();
            this.h.setVisibility(8);
        }
        if (this.omq != null) {
            this.omq.a();
        }
        if (this.omp != null) {
            this.omp.a();
        }
        if (this.omr != null) {
            this.omr.a();
        }
        a();
    }
}

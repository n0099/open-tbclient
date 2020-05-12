package com.kascend.chushou.player.b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.ActivityChooserView;
import com.kascend.chushou.a;
import com.kascend.chushou.constants.ChatInfo;
import com.kascend.chushou.constants.GeneralTabGift;
import com.kascend.chushou.constants.GiftComboConfig;
import com.kascend.chushou.player.b;
import com.kascend.chushou.widget.GiftAnimationLayout;
import java.util.ArrayList;
import java.util.List;
import tv.chushou.basis.rxjava.annotation.Subscribe;
import tv.chushou.zues.utils.h;
import tv.chushou.zues.widget.gift.view.GiftFrameLayout;
/* loaded from: classes5.dex */
public class a {
    private Context b;
    private List<GeneralTabGift> c;
    private List<tv.chushou.zues.widget.gift.a.a> d;
    private List<tv.chushou.zues.widget.gift.a.a> e;
    private GiftComboConfig mpN;
    private static final float[] mpO = new float[40];
    private static final float[] k = new float[40];
    private String a = "GiftShowManager";
    private boolean g = false;
    @SuppressLint({"HandlerLeak"})
    private Handler h = new Handler() { // from class: com.kascend.chushou.player.b.a.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == Integer.MAX_VALUE) {
                tv.chushou.zues.widget.gift.a.a dxx = a.this.dxx();
                if (dxx == null) {
                    a.this.h.sendEmptyMessageDelayed(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, 500L);
                    return;
                }
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < a.this.f.size()) {
                        if (!((GiftFrameLayout) a.this.f.get(i2)).isShowing()) {
                            ((GiftFrameLayout) a.this.f.get(i2)).b(dxx);
                            return;
                        }
                        i = i2 + 1;
                    } else {
                        return;
                    }
                }
            }
        }
    };
    private List<GiftFrameLayout> f = new ArrayList();

    @Subscribe
    public void onGiftAnimationEvent(tv.chushou.zues.widget.gift.b.a aVar) {
        if (aVar.type == tv.chushou.zues.widget.gift.b.a.REMOVE) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < this.f.size()) {
                    if (this.f.get(i2).getGift() == aVar.nur) {
                        this.f.get(i2).a(aVar.nur.bBZ / 1000, fW(aVar.nur.nup));
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        } else if (aVar.type == tv.chushou.zues.widget.gift.b.a.GET) {
            this.h.sendEmptyMessageDelayed(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, 20L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public tv.chushou.zues.widget.gift.a.a dxx() {
        if (this.d == null || this.d.size() <= 0) {
            return null;
        }
        tv.chushou.zues.widget.gift.a.a aVar = this.d.get(0);
        this.d.remove(0);
        e();
        return aVar;
    }

    public a(Context context, GiftAnimationLayout giftAnimationLayout) {
        int i = 0;
        this.b = context;
        while (true) {
            int i2 = i;
            if (i2 < giftAnimationLayout.getChildCount()) {
                this.f.add((GiftFrameLayout) giftAnimationLayout.getChildAt(i2));
                i = i2 + 1;
            } else {
                this.d = new ArrayList();
                this.c = new ArrayList();
                tv.chushou.zues.a.a.register(this);
                return;
            }
        }
    }

    public void a(b bVar) {
        if (this.c != null) {
            this.c.clear();
        } else {
            this.c = new ArrayList();
        }
        if (bVar.j.size() > 0) {
            this.c.addAll(bVar.j);
        } else {
            if (bVar != null && bVar.dxt() != null && bVar.dxt().mGeneralTabGifts != null) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= bVar.dxt().mGeneralTabGifts.size()) {
                        break;
                    }
                    bVar.j.add(bVar.dxt().mGeneralTabGifts.get(i2).deepClone());
                    i = i2 + 1;
                }
            }
            this.c.addAll(bVar.j);
        }
        if (bVar.dxt() != null) {
            this.mpN = bVar.dxt().mGiftComboConfig;
        }
    }

    public void a() {
        tv.chushou.zues.a.a.cb(this);
        if (this.h != null) {
            this.h.removeMessages(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
            for (int i = 0; i < this.f.size(); i++) {
                if (this.h.hasMessages(i)) {
                    this.h.removeMessages(i);
                }
            }
            this.h = null;
            this.f.clear();
            this.f = null;
            if (this.e != null) {
                this.e.clear();
                this.e = null;
            }
        }
    }

    private void d() {
        if (!this.g) {
            this.g = true;
            for (int i = 0; i < this.f.size(); i++) {
                this.h.sendEmptyMessageDelayed(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED, (i * 20) + 500);
            }
        }
    }

    private void b(List<tv.chushou.zues.widget.gift.a.a> list) {
        boolean z;
        if (list != null && list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                tv.chushou.zues.widget.gift.a.a aVar = list.get(i);
                int size = this.d.size() - 1;
                while (true) {
                    if (size < 0) {
                        z = false;
                        break;
                    }
                    tv.chushou.zues.widget.gift.a.a aVar2 = this.d.get(size);
                    if (!aVar2.equals(aVar)) {
                        size--;
                    } else if (aVar.nuo > aVar2.nuo) {
                        aVar2.nuo = aVar.nuo;
                        aVar2.bBZ = aVar.bBZ;
                        aVar2.nul = aVar.nul;
                        z = true;
                    } else {
                        a(aVar);
                        z = true;
                    }
                }
                if (!z) {
                    long j = 0;
                    boolean z2 = true;
                    int i2 = 0;
                    for (int i3 = 0; i3 < this.f.size(); i3++) {
                        GiftFrameLayout giftFrameLayout = this.f.get(i3);
                        if (giftFrameLayout.getGift() != null && giftFrameLayout.getGift().equals(aVar) && !giftFrameLayout.dKk() && aVar.nuo > giftFrameLayout.getGift().nuo && giftFrameLayout.updateTime > j) {
                            j = giftFrameLayout.updateTime;
                            i2 = i3;
                            z2 = false;
                        }
                    }
                    if (z2) {
                        a(aVar);
                    } else {
                        this.f.get(i2).JY(aVar.nuo);
                    }
                }
            }
            d();
        }
    }

    private void a(tv.chushou.zues.widget.gift.a.a aVar) {
        int i;
        if (!h.isEmpty(com.kascend.chushou.d.h.dwI().b()) && com.kascend.chushou.d.h.dwI().b().equals(aVar.mUserId)) {
            int size = this.d.size();
            int size2 = this.d.size() - 1;
            while (true) {
                if (size2 < 0) {
                    i = size;
                    break;
                } else if (!this.d.get(size2).mUserId.equals(aVar.mUserId)) {
                    size2--;
                } else {
                    i = size2 + 1;
                    break;
                }
            }
            this.d.add(i, aVar);
            return;
        }
        this.d.add(aVar);
    }

    public void b() {
        if (this.d != null) {
            this.d.clear();
        }
    }

    public void a(List<ChatInfo> list) {
        boolean z;
        this.e = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            ChatInfo chatInfo = list.get(i);
            if (chatInfo.mType.equals("3") && chatInfo.mUserComboCount > 0) {
                tv.chushou.zues.widget.gift.a.a aVar = new tv.chushou.zues.widget.gift.a.a();
                aVar.mUserId = chatInfo.mUserID;
                aVar.nui = chatInfo.mPrivilegeInfo.mAvatarFrame;
                if (chatInfo.mGift != null) {
                    aVar.aty = String.valueOf(chatInfo.mGift.id);
                    aVar.nuj = this.b.getString(a.i.str_gift_send_out) + chatInfo.mGift.name;
                    if (this.c != null && this.c.size() > 0) {
                        int i2 = 0;
                        boolean z2 = false;
                        while (i2 < this.c.size()) {
                            GeneralTabGift generalTabGift = this.c.get(i2);
                            if (generalTabGift != null && generalTabGift.mGeneralGifts != null) {
                                for (int i3 = 0; i3 < generalTabGift.mGeneralGifts.size(); i3++) {
                                    if (aVar.aty.equals(String.valueOf(generalTabGift.mGeneralGifts.get(i3).mId))) {
                                        aVar.nul = generalTabGift.mGeneralGifts.get(i3).mRepeatedBg;
                                        aVar.bBZ = generalTabGift.mGeneralGifts.get(i3).mDuration;
                                        aVar.nup = generalTabGift.mGeneralGifts.get(i3).mPoint;
                                        z = true;
                                        break;
                                    }
                                }
                            }
                            z = z2;
                            if (z) {
                                break;
                            }
                            i2++;
                            z2 = z;
                        }
                    }
                    if (!h.isEmpty(chatInfo.mGift.mRepeatedBg)) {
                        aVar.nul = chatInfo.mGift.mRepeatedBg;
                    }
                } else {
                    aVar.aty = "";
                    aVar.nuj = "";
                }
                aVar.mShowAvatar = chatInfo.mPrivilegeInfo.mShowAvatar;
                aVar.nuh = chatInfo.mHeadIcon;
                aVar.nuk = chatInfo.mGift.icon;
                aVar.nun = chatInfo.mUserComboCount;
                aVar.nuo = chatInfo.mUserComboCount;
                aVar.mNickName = chatInfo.mUserNickname;
                long a = a(chatInfo.mUserComboCount * aVar.nup);
                if (a != -1) {
                    aVar.bBZ = a;
                }
                this.e.add(aVar);
            }
        }
        b(this.e);
    }

    private long a(long j) {
        if (this.mpN != null && !h.isEmpty(this.mpN.durationList)) {
            for (GiftComboConfig.Duration duration : this.mpN.durationList) {
                if (duration.startPoint <= j && duration.endPoint > j) {
                    return duration.duration * 1000;
                }
            }
        }
        return -1L;
    }

    private void e() {
        if (h.isEmpty(this.d)) {
            GiftFrameLayout.nuv = 1.0d;
            return;
        }
        int size = this.d.size();
        if (size <= 1) {
            GiftFrameLayout.nuv = 1.0d;
        } else if (size >= 20) {
            GiftFrameLayout.nuv = 0.1d;
        } else if (size >= 10) {
            GiftFrameLayout.nuv = 0.2d;
        } else {
            GiftFrameLayout.nuv = 0.3d;
        }
    }

    static {
        mpO[0] = 0.98f;
        k[0] = 0.95f;
        for (int i = 1; i < 40; i++) {
            mpO[i] = mpO[i - 1] * 0.98f;
            k[i] = k[i - 1] * 0.95f;
        }
    }

    private float dxy() {
        int size = this.d.size();
        if (size >= 50) {
            return mpO[39];
        }
        if (size <= 10) {
            return 1.0f;
        }
        return mpO[size - 11];
    }

    private float g() {
        int size = this.d.size();
        if (size >= 50) {
            return k[39];
        }
        if (size <= 10) {
            return 1.0f;
        }
        return k[size - 11];
    }

    private float fW(long j) {
        return j < 100000 ? g() : dxy();
    }
}

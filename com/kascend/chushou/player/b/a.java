package com.kascend.chushou.player.b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
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
/* loaded from: classes4.dex */
public class a {
    private static final float[] j = new float[40];
    private static final float[] k = new float[40];
    private Context b;
    private List<GeneralTabGift> c;
    private List<tv.chushou.zues.widget.gift.a.a> d;
    private List<tv.chushou.zues.widget.gift.a.a> e;
    private GiftComboConfig mQz;
    private String a = "GiftShowManager";
    private boolean g = false;
    @SuppressLint({"HandlerLeak"})
    private Handler h = new Handler() { // from class: com.kascend.chushou.player.b.a.1
        @Override // android.os.Handler
        public void handleMessage(Message message) {
            if (message.what == Integer.MAX_VALUE) {
                tv.chushou.zues.widget.gift.a.a dBz = a.this.dBz();
                if (dBz == null) {
                    a.this.h.sendEmptyMessageDelayed(Integer.MAX_VALUE, 500L);
                    return;
                }
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 < a.this.f.size()) {
                        if (!((GiftFrameLayout) a.this.f.get(i2)).isShowing()) {
                            ((GiftFrameLayout) a.this.f.get(i2)).b(dBz);
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
                    if (this.f.get(i2).getGift() == aVar.nXE) {
                        this.f.get(i2).a(aVar.nXE.aZh / 1000, gU(aVar.nXE.nXC));
                    }
                    i = i2 + 1;
                } else {
                    return;
                }
            }
        } else if (aVar.type == tv.chushou.zues.widget.gift.b.a.GET) {
            this.h.sendEmptyMessageDelayed(Integer.MAX_VALUE, 20L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public tv.chushou.zues.widget.gift.a.a dBz() {
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
            if (bVar != null && bVar.dBw() != null && bVar.dBw().mGeneralTabGifts != null) {
                int i = 0;
                while (true) {
                    int i2 = i;
                    if (i2 >= bVar.dBw().mGeneralTabGifts.size()) {
                        break;
                    }
                    bVar.j.add(bVar.dBw().mGeneralTabGifts.get(i2).deepClone());
                    i = i2 + 1;
                }
            }
            this.c.addAll(bVar.j);
        }
        if (bVar.dBw() != null) {
            this.mQz = bVar.dBw().mGiftComboConfig;
        }
    }

    public void a() {
        tv.chushou.zues.a.a.cq(this);
        if (this.h != null) {
            this.h.removeMessages(Integer.MAX_VALUE);
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
                this.h.sendEmptyMessageDelayed(Integer.MAX_VALUE, (i * 20) + 500);
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
                    } else if (aVar.nXB > aVar2.nXB) {
                        aVar2.nXB = aVar.nXB;
                        aVar2.aZh = aVar.aZh;
                        aVar2.nXz = aVar.nXz;
                        z = true;
                    } else {
                        a(aVar);
                        z = true;
                    }
                }
                if (!z) {
                    long j2 = 0;
                    boolean z2 = true;
                    int i2 = 0;
                    for (int i3 = 0; i3 < this.f.size(); i3++) {
                        GiftFrameLayout giftFrameLayout = this.f.get(i3);
                        if (giftFrameLayout.getGift() != null && giftFrameLayout.getGift().equals(aVar) && !giftFrameLayout.dPv() && aVar.nXB > giftFrameLayout.getGift().nXB && giftFrameLayout.updateTime > j2) {
                            j2 = giftFrameLayout.updateTime;
                            i2 = i3;
                            z2 = false;
                        }
                    }
                    if (z2) {
                        a(aVar);
                    } else {
                        this.f.get(i2).Ot(aVar.nXB);
                    }
                }
            }
            d();
        }
    }

    private void a(tv.chushou.zues.widget.gift.a.a aVar) {
        int i;
        if (!h.isEmpty(com.kascend.chushou.d.h.dAM().b()) && com.kascend.chushou.d.h.dAM().b().equals(aVar.mUserId)) {
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
                aVar.nXw = chatInfo.mPrivilegeInfo.mAvatarFrame;
                if (chatInfo.mGift != null) {
                    aVar.Zb = String.valueOf(chatInfo.mGift.id);
                    aVar.nXx = this.b.getString(a.i.str_gift_send_out) + chatInfo.mGift.name;
                    if (this.c != null && this.c.size() > 0) {
                        int i2 = 0;
                        boolean z2 = false;
                        while (i2 < this.c.size()) {
                            GeneralTabGift generalTabGift = this.c.get(i2);
                            if (generalTabGift != null && generalTabGift.mGeneralGifts != null) {
                                for (int i3 = 0; i3 < generalTabGift.mGeneralGifts.size(); i3++) {
                                    if (aVar.Zb.equals(String.valueOf(generalTabGift.mGeneralGifts.get(i3).mId))) {
                                        aVar.nXz = generalTabGift.mGeneralGifts.get(i3).mRepeatedBg;
                                        aVar.aZh = generalTabGift.mGeneralGifts.get(i3).mDuration;
                                        aVar.nXC = generalTabGift.mGeneralGifts.get(i3).mPoint;
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
                        aVar.nXz = chatInfo.mGift.mRepeatedBg;
                    }
                } else {
                    aVar.Zb = "";
                    aVar.nXx = "";
                }
                aVar.mShowAvatar = chatInfo.mPrivilegeInfo.mShowAvatar;
                aVar.nXv = chatInfo.mHeadIcon;
                aVar.nXy = chatInfo.mGift.icon;
                aVar.nXA = chatInfo.mUserComboCount;
                aVar.nXB = chatInfo.mUserComboCount;
                aVar.mNickName = chatInfo.mUserNickname;
                long a = a(chatInfo.mUserComboCount * aVar.nXC);
                if (a != -1) {
                    aVar.aZh = a;
                }
                this.e.add(aVar);
            }
        }
        b(this.e);
    }

    private long a(long j2) {
        if (this.mQz != null && !h.isEmpty(this.mQz.durationList)) {
            for (GiftComboConfig.Duration duration : this.mQz.durationList) {
                if (duration.startPoint <= j2 && duration.endPoint > j2) {
                    return duration.duration * 1000;
                }
            }
        }
        return -1L;
    }

    private void e() {
        if (h.isEmpty(this.d)) {
            GiftFrameLayout.nXI = 1.0d;
            return;
        }
        int size = this.d.size();
        if (size <= 1) {
            GiftFrameLayout.nXI = 1.0d;
        } else if (size >= 20) {
            GiftFrameLayout.nXI = 0.1d;
        } else if (size >= 10) {
            GiftFrameLayout.nXI = 0.2d;
        } else {
            GiftFrameLayout.nXI = 0.3d;
        }
    }

    static {
        j[0] = 0.98f;
        k[0] = 0.95f;
        for (int i = 1; i < 40; i++) {
            j[i] = j[i - 1] * 0.98f;
            k[i] = k[i - 1] * 0.95f;
        }
    }

    private float f() {
        int size = this.d.size();
        if (size >= 50) {
            return j[39];
        }
        if (size <= 10) {
            return 1.0f;
        }
        return j[size - 11];
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

    private float gU(long j2) {
        return j2 < 100000 ? g() : f();
    }
}

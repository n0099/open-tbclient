package com.yy.mobile.framework.revenuesdk.giftapi;

import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import d.r.b.a.a.g.a;
import d.r.b.a.a.g.b;
import d.r.b.a.a.g.e.c;
import d.r.b.a.a.g.e.d;
import d.r.b.a.a.g.e.e;
import d.r.b.a.a.g.e.f;
import d.r.b.a.a.g.e.g;
import d.r.b.a.a.g.e.h;
import d.r.b.a.a.g.e.i;
import d.r.b.a.a.g.e.j;
import java.util.List;
@Keep
/* loaded from: classes7.dex */
public interface IGiftService {
    void addGiftEventCallback(@NonNull a aVar);

    void clearAllGiftCache();

    void clearGiftCacheByChannelAndCategoryId(int i2, int i3);

    @Deprecated
    d.r.b.a.a.g.c.a findGiftById(int i2);

    d.r.b.a.a.g.c.a findGiftById(int i2, int i3);

    @Deprecated
    List<d.r.b.a.a.g.c.a> getAllChannelGift();

    List<d.r.b.a.a.g.c.a> getAllGift(int i2);

    List<d.r.b.a.a.g.c.a> getAllGift(int i2, int i3);

    void getGiftBagInfo(@NonNull d.r.b.a.a.g.e.a aVar, @NonNull b<Object> bVar);

    void getRankEntranceInfo(@NonNull h hVar, @NonNull b<Object> bVar);

    void getToInfo(@NonNull d.r.b.a.a.g.e.b bVar, @NonNull b<Object> bVar2);

    void loadAllGift(@NonNull d dVar, @NonNull b<Object> bVar, boolean z);

    void loadAllGiftJsonData(@NonNull c cVar, @NonNull b<String> bVar, boolean z);

    void loadPackageGift(@NonNull e eVar, @NonNull b<Object> bVar);

    void loadReceiveGiftAmount(@NonNull f fVar, @NonNull b<Object> bVar);

    void queryUserCouponStore(@NonNull g gVar, @NonNull b<Object> bVar);

    void registerGiftReporter(d.r.b.a.a.g.d.a aVar);

    void removeGiftEventCallback(@NonNull a aVar);

    void sendGiftToMultiUser(@NonNull j jVar, @NonNull b<Object> bVar);

    void sendGiftToUser(@NonNull i iVar, @NonNull b<Object> bVar);

    void setCountryCode(String str);

    void setCurrentUsedChannel(int i2);
}

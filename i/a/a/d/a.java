package i.a.a.d;

import com.yy.mobile.framework.revenuesdk.giftapi.IGiftService;
import d.r.b.a.a.g.e.d;
import d.r.b.a.a.g.e.e;
import d.r.b.a.a.g.e.f;
import d.r.b.a.a.g.e.g;
import d.r.b.a.a.g.e.h;
import d.r.b.a.a.g.e.i;
import d.r.b.a.a.g.e.j;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import tv.athena.revenue.api.MiddleRevenueConfig;
/* loaded from: classes8.dex */
public final class a implements IGiftService {

    /* renamed from: a  reason: collision with root package name */
    public final MiddleRevenueConfig f68784a;

    /* renamed from: b  reason: collision with root package name */
    public final IGiftService f68785b;

    public a(MiddleRevenueConfig middleRevenueConfig, IGiftService iGiftService) {
        this.f68784a = middleRevenueConfig;
        this.f68785b = iGiftService;
    }

    @Override // com.yy.mobile.framework.revenuesdk.giftapi.IGiftService
    public void addGiftEventCallback(d.r.b.a.a.g.a aVar) {
        this.f68785b.addGiftEventCallback(aVar);
    }

    @Override // com.yy.mobile.framework.revenuesdk.giftapi.IGiftService
    public void clearAllGiftCache() {
        this.f68785b.clearAllGiftCache();
    }

    @Override // com.yy.mobile.framework.revenuesdk.giftapi.IGiftService
    public void clearGiftCacheByChannelAndCategoryId(int i2, int i3) {
        this.f68785b.clearGiftCacheByChannelAndCategoryId(i2, i3);
    }

    @Override // com.yy.mobile.framework.revenuesdk.giftapi.IGiftService
    public d.r.b.a.a.g.c.a findGiftById(int i2) {
        return this.f68785b.findGiftById(i2);
    }

    @Override // com.yy.mobile.framework.revenuesdk.giftapi.IGiftService
    public List<d.r.b.a.a.g.c.a> getAllChannelGift() {
        List<d.r.b.a.a.g.c.a> allChannelGift = this.f68785b.getAllChannelGift();
        Intrinsics.checkExpressionValueIsNotNull(allChannelGift, "giftService.allChannelGift");
        return allChannelGift;
    }

    @Override // com.yy.mobile.framework.revenuesdk.giftapi.IGiftService
    public List<d.r.b.a.a.g.c.a> getAllGift(int i2) {
        List<d.r.b.a.a.g.c.a> allGift = this.f68785b.getAllGift(i2);
        Intrinsics.checkExpressionValueIsNotNull(allGift, "giftService.getAllGift(usedChannel)");
        return allGift;
    }

    @Override // com.yy.mobile.framework.revenuesdk.giftapi.IGiftService
    public void getGiftBagInfo(d.r.b.a.a.g.e.a aVar, d.r.b.a.a.g.b<Object> bVar) {
        aVar.f67771a = this.f68784a.getAppId();
        this.f68785b.getGiftBagInfo(aVar, bVar);
    }

    @Override // com.yy.mobile.framework.revenuesdk.giftapi.IGiftService
    public void getRankEntranceInfo(h hVar, d.r.b.a.a.g.b<Object> bVar) {
        hVar.f67779a = this.f68784a.getAppId();
        this.f68785b.getRankEntranceInfo(hVar, bVar);
    }

    @Override // com.yy.mobile.framework.revenuesdk.giftapi.IGiftService
    public void getToInfo(d.r.b.a.a.g.e.b bVar, d.r.b.a.a.g.b<Object> bVar2) {
        bVar.f67772a = this.f68784a.getAppId();
        this.f68785b.getToInfo(bVar, bVar2);
    }

    @Override // com.yy.mobile.framework.revenuesdk.giftapi.IGiftService
    public void loadAllGift(d dVar, d.r.b.a.a.g.b<Object> bVar, boolean z) {
        dVar.f67773a = this.f68784a.getAppId();
        dVar.f67775c = this.f68784a.getCountry();
        dVar.f67776d = this.f68784a.getVersion();
        this.f68785b.loadAllGift(dVar, bVar, z);
        IGiftService iGiftService = this.f68785b;
        if (iGiftService != null) {
            iGiftService.setCurrentUsedChannel(dVar.f67774b);
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.giftapi.IGiftService
    public void loadAllGiftJsonData(d.r.b.a.a.g.e.c cVar, d.r.b.a.a.g.b<String> bVar, boolean z) {
        cVar.f67773a = this.f68784a.getAppId();
        cVar.f67775c = this.f68784a.getCountry();
        cVar.f67776d = this.f68784a.getVersion();
        this.f68785b.loadAllGiftJsonData(cVar, bVar, z);
        IGiftService iGiftService = this.f68785b;
        if (iGiftService != null) {
            iGiftService.setCurrentUsedChannel(cVar.f67774b);
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.giftapi.IGiftService
    public void loadPackageGift(e eVar, d.r.b.a.a.g.b<Object> bVar) {
        eVar.f67777a = this.f68784a.getAppId();
        this.f68785b.loadPackageGift(eVar, bVar);
    }

    @Override // com.yy.mobile.framework.revenuesdk.giftapi.IGiftService
    public void loadReceiveGiftAmount(f fVar, d.r.b.a.a.g.b<Object> bVar) {
        fVar.f67778a = this.f68784a.getAppId();
        this.f68785b.loadReceiveGiftAmount(fVar, bVar);
    }

    @Override // com.yy.mobile.framework.revenuesdk.giftapi.IGiftService
    public void queryUserCouponStore(g gVar, d.r.b.a.a.g.b<Object> bVar) {
        this.f68785b.queryUserCouponStore(gVar, bVar);
    }

    @Override // com.yy.mobile.framework.revenuesdk.giftapi.IGiftService
    public void registerGiftReporter(d.r.b.a.a.g.d.a aVar) {
        this.f68785b.registerGiftReporter(aVar);
    }

    @Override // com.yy.mobile.framework.revenuesdk.giftapi.IGiftService
    public void removeGiftEventCallback(d.r.b.a.a.g.a aVar) {
        this.f68785b.removeGiftEventCallback(aVar);
    }

    @Override // com.yy.mobile.framework.revenuesdk.giftapi.IGiftService
    public void sendGiftToMultiUser(j jVar, d.r.b.a.a.g.b<Object> bVar) {
        jVar.f67781a = this.f68784a.getAppId();
        this.f68785b.sendGiftToMultiUser(jVar, bVar);
    }

    @Override // com.yy.mobile.framework.revenuesdk.giftapi.IGiftService
    public void sendGiftToUser(i iVar, d.r.b.a.a.g.b<Object> bVar) {
        iVar.f67780a = this.f68784a.getAppId();
        this.f68785b.sendGiftToUser(iVar, bVar);
    }

    @Override // com.yy.mobile.framework.revenuesdk.giftapi.IGiftService
    public void setCountryCode(String str) {
        this.f68785b.setCountryCode(str);
    }

    @Override // com.yy.mobile.framework.revenuesdk.giftapi.IGiftService
    public void setCurrentUsedChannel(int i2) {
        this.f68785b.setCurrentUsedChannel(i2);
    }

    @Override // com.yy.mobile.framework.revenuesdk.giftapi.IGiftService
    public d.r.b.a.a.g.c.a findGiftById(int i2, int i3) {
        return this.f68785b.findGiftById(i2, i3);
    }

    @Override // com.yy.mobile.framework.revenuesdk.giftapi.IGiftService
    public List<d.r.b.a.a.g.c.a> getAllGift(int i2, int i3) {
        List<d.r.b.a.a.g.c.a> allGift = this.f68785b.getAllGift(i2, i3);
        Intrinsics.checkExpressionValueIsNotNull(allGift, "giftService.getAllGift(u…dChannel, liveCategoryId)");
        return allGift;
    }
}

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
/* loaded from: classes7.dex */
public final class a implements IGiftService {

    /* renamed from: a  reason: collision with root package name */
    public final MiddleRevenueConfig f68061a;

    /* renamed from: b  reason: collision with root package name */
    public final IGiftService f68062b;

    public a(MiddleRevenueConfig middleRevenueConfig, IGiftService iGiftService) {
        this.f68061a = middleRevenueConfig;
        this.f68062b = iGiftService;
    }

    @Override // com.yy.mobile.framework.revenuesdk.giftapi.IGiftService
    public void addGiftEventCallback(d.r.b.a.a.g.a aVar) {
        this.f68062b.addGiftEventCallback(aVar);
    }

    @Override // com.yy.mobile.framework.revenuesdk.giftapi.IGiftService
    public void clearAllGiftCache() {
        this.f68062b.clearAllGiftCache();
    }

    @Override // com.yy.mobile.framework.revenuesdk.giftapi.IGiftService
    public void clearGiftCacheByChannelAndCategoryId(int i2, int i3) {
        this.f68062b.clearGiftCacheByChannelAndCategoryId(i2, i3);
    }

    @Override // com.yy.mobile.framework.revenuesdk.giftapi.IGiftService
    public d.r.b.a.a.g.c.a findGiftById(int i2) {
        return this.f68062b.findGiftById(i2);
    }

    @Override // com.yy.mobile.framework.revenuesdk.giftapi.IGiftService
    public List<d.r.b.a.a.g.c.a> getAllChannelGift() {
        List<d.r.b.a.a.g.c.a> allChannelGift = this.f68062b.getAllChannelGift();
        Intrinsics.checkExpressionValueIsNotNull(allChannelGift, "giftService.allChannelGift");
        return allChannelGift;
    }

    @Override // com.yy.mobile.framework.revenuesdk.giftapi.IGiftService
    public List<d.r.b.a.a.g.c.a> getAllGift(int i2) {
        List<d.r.b.a.a.g.c.a> allGift = this.f68062b.getAllGift(i2);
        Intrinsics.checkExpressionValueIsNotNull(allGift, "giftService.getAllGift(usedChannel)");
        return allGift;
    }

    @Override // com.yy.mobile.framework.revenuesdk.giftapi.IGiftService
    public void getGiftBagInfo(d.r.b.a.a.g.e.a aVar, d.r.b.a.a.g.b<Object> bVar) {
        aVar.f67042a = this.f68061a.getAppId();
        this.f68062b.getGiftBagInfo(aVar, bVar);
    }

    @Override // com.yy.mobile.framework.revenuesdk.giftapi.IGiftService
    public void getRankEntranceInfo(h hVar, d.r.b.a.a.g.b<Object> bVar) {
        hVar.f67050a = this.f68061a.getAppId();
        this.f68062b.getRankEntranceInfo(hVar, bVar);
    }

    @Override // com.yy.mobile.framework.revenuesdk.giftapi.IGiftService
    public void getToInfo(d.r.b.a.a.g.e.b bVar, d.r.b.a.a.g.b<Object> bVar2) {
        bVar.f67043a = this.f68061a.getAppId();
        this.f68062b.getToInfo(bVar, bVar2);
    }

    @Override // com.yy.mobile.framework.revenuesdk.giftapi.IGiftService
    public void loadAllGift(d dVar, d.r.b.a.a.g.b<Object> bVar, boolean z) {
        dVar.f67044a = this.f68061a.getAppId();
        dVar.f67046c = this.f68061a.getCountry();
        dVar.f67047d = this.f68061a.getVersion();
        this.f68062b.loadAllGift(dVar, bVar, z);
        IGiftService iGiftService = this.f68062b;
        if (iGiftService != null) {
            iGiftService.setCurrentUsedChannel(dVar.f67045b);
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.giftapi.IGiftService
    public void loadAllGiftJsonData(d.r.b.a.a.g.e.c cVar, d.r.b.a.a.g.b<String> bVar, boolean z) {
        cVar.f67044a = this.f68061a.getAppId();
        cVar.f67046c = this.f68061a.getCountry();
        cVar.f67047d = this.f68061a.getVersion();
        this.f68062b.loadAllGiftJsonData(cVar, bVar, z);
        IGiftService iGiftService = this.f68062b;
        if (iGiftService != null) {
            iGiftService.setCurrentUsedChannel(cVar.f67045b);
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.giftapi.IGiftService
    public void loadPackageGift(e eVar, d.r.b.a.a.g.b<Object> bVar) {
        eVar.f67048a = this.f68061a.getAppId();
        this.f68062b.loadPackageGift(eVar, bVar);
    }

    @Override // com.yy.mobile.framework.revenuesdk.giftapi.IGiftService
    public void loadReceiveGiftAmount(f fVar, d.r.b.a.a.g.b<Object> bVar) {
        fVar.f67049a = this.f68061a.getAppId();
        this.f68062b.loadReceiveGiftAmount(fVar, bVar);
    }

    @Override // com.yy.mobile.framework.revenuesdk.giftapi.IGiftService
    public void queryUserCouponStore(g gVar, d.r.b.a.a.g.b<Object> bVar) {
        this.f68062b.queryUserCouponStore(gVar, bVar);
    }

    @Override // com.yy.mobile.framework.revenuesdk.giftapi.IGiftService
    public void registerGiftReporter(d.r.b.a.a.g.d.a aVar) {
        this.f68062b.registerGiftReporter(aVar);
    }

    @Override // com.yy.mobile.framework.revenuesdk.giftapi.IGiftService
    public void removeGiftEventCallback(d.r.b.a.a.g.a aVar) {
        this.f68062b.removeGiftEventCallback(aVar);
    }

    @Override // com.yy.mobile.framework.revenuesdk.giftapi.IGiftService
    public void sendGiftToMultiUser(j jVar, d.r.b.a.a.g.b<Object> bVar) {
        jVar.f67052a = this.f68061a.getAppId();
        this.f68062b.sendGiftToMultiUser(jVar, bVar);
    }

    @Override // com.yy.mobile.framework.revenuesdk.giftapi.IGiftService
    public void sendGiftToUser(i iVar, d.r.b.a.a.g.b<Object> bVar) {
        iVar.f67051a = this.f68061a.getAppId();
        this.f68062b.sendGiftToUser(iVar, bVar);
    }

    @Override // com.yy.mobile.framework.revenuesdk.giftapi.IGiftService
    public void setCountryCode(String str) {
        this.f68062b.setCountryCode(str);
    }

    @Override // com.yy.mobile.framework.revenuesdk.giftapi.IGiftService
    public void setCurrentUsedChannel(int i2) {
        this.f68062b.setCurrentUsedChannel(i2);
    }

    @Override // com.yy.mobile.framework.revenuesdk.giftapi.IGiftService
    public d.r.b.a.a.g.c.a findGiftById(int i2, int i3) {
        return this.f68062b.findGiftById(i2, i3);
    }

    @Override // com.yy.mobile.framework.revenuesdk.giftapi.IGiftService
    public List<d.r.b.a.a.g.c.a> getAllGift(int i2, int i3) {
        List<d.r.b.a.a.g.c.a> allGift = this.f68062b.getAllGift(i2, i3);
        Intrinsics.checkExpressionValueIsNotNull(allGift, "giftService.getAllGift(u…dChannel, liveCategoryId)");
        return allGift;
    }
}

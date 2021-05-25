package d.a.n0.v.d.c.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.ala.data.SdkLiveInfoData;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes4.dex */
public class e extends BaseCardInfo {

    /* renamed from: g  reason: collision with root package name */
    public static final BdUniqueId f61502g = BdUniqueId.gen();

    /* renamed from: h  reason: collision with root package name */
    public static final BdUniqueId f61503h = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public d.a.n0.v.d.a.a f61504e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.n0.v.d.a.a f61505f;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.a.c.j.e.n
    public BdUniqueId getType() {
        SdkLiveInfoData sdkLiveInfoData;
        SdkLiveInfoData.AlaLiveInfo alaLiveInfo;
        SdkLiveInfoData.YYExt yYExt;
        d.a.n0.v.d.a.a aVar = this.f61504e;
        if (aVar != null && (sdkLiveInfoData = aVar.f61409e) != null && (alaLiveInfo = sdkLiveInfoData.liveInfo) != null && (yYExt = alaLiveInfo.yyExt) != null && yYExt.isYYGame == 1) {
            return f61503h;
        }
        return f61502g;
    }
}

package d.a.n0.v.d.c.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.ala.data.SdkLiveInfoData;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes4.dex */
public class e extends BaseCardInfo {

    /* renamed from: g  reason: collision with root package name */
    public static final BdUniqueId f65215g = BdUniqueId.gen();

    /* renamed from: h  reason: collision with root package name */
    public static final BdUniqueId f65216h = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public d.a.n0.v.d.a.a f65217e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.n0.v.d.a.a f65218f;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.a.c.k.e.n
    public BdUniqueId getType() {
        SdkLiveInfoData sdkLiveInfoData;
        SdkLiveInfoData.AlaLiveInfo alaLiveInfo;
        SdkLiveInfoData.YYExt yYExt;
        d.a.n0.v.d.a.a aVar = this.f65217e;
        if (aVar != null && (sdkLiveInfoData = aVar.f65122e) != null && (alaLiveInfo = sdkLiveInfoData.liveInfo) != null && (yYExt = alaLiveInfo.yyExt) != null && yYExt.isYYGame == 1) {
            return f65216h;
        }
        return f65215g;
    }
}

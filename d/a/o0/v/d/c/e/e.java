package d.a.o0.v.d.c.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.ala.data.SdkLiveInfoData;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes4.dex */
public class e extends BaseCardInfo {

    /* renamed from: g  reason: collision with root package name */
    public static final BdUniqueId f65340g = BdUniqueId.gen();

    /* renamed from: h  reason: collision with root package name */
    public static final BdUniqueId f65341h = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public d.a.o0.v.d.a.a f65342e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.o0.v.d.a.a f65343f;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.a.c.k.e.n
    public BdUniqueId getType() {
        SdkLiveInfoData sdkLiveInfoData;
        SdkLiveInfoData.AlaLiveInfo alaLiveInfo;
        SdkLiveInfoData.YYExt yYExt;
        d.a.o0.v.d.a.a aVar = this.f65342e;
        if (aVar != null && (sdkLiveInfoData = aVar.f65247e) != null && (alaLiveInfo = sdkLiveInfoData.liveInfo) != null && (yYExt = alaLiveInfo.yyExt) != null && yYExt.isYYGame == 1) {
            return f65341h;
        }
        return f65340g;
    }
}

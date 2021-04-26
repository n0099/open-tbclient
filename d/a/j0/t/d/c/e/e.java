package d.a.j0.t.d.c.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.ala.data.SdkLiveInfoData;
import com.baidu.tieba.card.data.BaseCardInfo;
/* loaded from: classes4.dex */
public class e extends BaseCardInfo {

    /* renamed from: g  reason: collision with root package name */
    public static final BdUniqueId f60490g = BdUniqueId.gen();

    /* renamed from: h  reason: collision with root package name */
    public static final BdUniqueId f60491h = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public d.a.j0.t.d.a.a f60492e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.j0.t.d.a.a f60493f;

    @Override // com.baidu.tieba.card.data.BaseCardInfo, d.a.c.j.e.n
    public BdUniqueId getType() {
        SdkLiveInfoData sdkLiveInfoData;
        SdkLiveInfoData.AlaLiveInfo alaLiveInfo;
        SdkLiveInfoData.YYExt yYExt;
        d.a.j0.t.d.a.a aVar = this.f60492e;
        if (aVar != null && (sdkLiveInfoData = aVar.f60397e) != null && (alaLiveInfo = sdkLiveInfoData.liveInfo) != null && (yYExt = alaLiveInfo.yyExt) != null && yYExt.isYYGame == 1) {
            return f60491h;
        }
        return f60490g;
    }
}

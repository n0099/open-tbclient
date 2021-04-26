package d.a.j0.s2;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.WebViewActivityConfig;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.recapp.AdDebugService;
import com.baidu.tieba.recapp.activity.AdWebVideoActivity;
import com.baidu.tieba.recapp.activity.AdWebVideoActivityConfig;
import com.baidu.tieba.recapp.constants.Cmatch;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.request.ShowStatisticUploadRequest;
import com.baidu.tieba.tbadkCore.data.AppData;
import d.a.j0.d3.j0.a;
import java.util.ArrayList;
import java.util.List;
import tbclient.App;
import tbclient.VideoInfo;
/* loaded from: classes3.dex */
public class y implements u {

    /* renamed from: a  reason: collision with root package name */
    public List<AppData> f60366a;

    @Override // d.a.j0.s2.u
    public d.a.c.j.e.a<?, ?> a(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        if (baseFragmentActivity == null) {
            return null;
        }
        if (bdUniqueId == AdvertAppInfo.k4) {
            return new d.a.j0.s2.a0.f(baseFragmentActivity, bdUniqueId);
        }
        if (bdUniqueId == AdvertAppInfo.i4) {
            return new d.a.j0.s2.a0.e(baseFragmentActivity, bdUniqueId);
        }
        return null;
    }

    @Override // d.a.j0.s2.u
    public p b() {
        return d.t();
    }

    @Override // d.a.j0.s2.u
    public App c(App app, Cmatch cmatch) {
        return d.a.j0.o.e.a.i().n(app, cmatch);
    }

    @Override // d.a.j0.s2.u
    public void d(boolean z, String str, String str2, String str3, String str4, List<a.c> list, String str5) {
        ShowStatisticUploadRequest.sendPB(z, str, str2, str3, str4, list, str5);
    }

    @Override // d.a.j0.s2.u
    public j e() {
        return new d.a.j0.s2.g0.a();
    }

    @Override // d.a.j0.s2.u
    public k f(@NonNull TbPageContext<?> tbPageContext, @NonNull AdvertAppInfo.ILegoAdvert iLegoAdvert, int i2, boolean z, String str, String str2) {
        if (iLegoAdvert instanceof AdCard) {
            return new d.a.j0.s2.e0.d.a.d(tbPageContext, iLegoAdvert, i2, z, str, str2);
        }
        return null;
    }

    @Override // d.a.j0.s2.u
    public l g() {
        return d.a.j0.o.a.l();
    }

    @Override // d.a.j0.s2.u
    public d.a.c.j.e.a<?, ?> h(t tVar, BdUniqueId bdUniqueId) {
        if (tVar == null || bdUniqueId == null) {
            return null;
        }
        if (bdUniqueId == AdvertAppInfo.h4) {
            return new d.a.j0.s2.a0.c(tVar, bdUniqueId);
        }
        return new d.a.j0.s2.a0.d(tVar, bdUniqueId);
    }

    @Override // d.a.j0.s2.u
    public void i() {
        List<AppData> list = this.f60366a;
        AdDebugService.updateFloatView(list != null ? StringUtils.string(Integer.valueOf(list.size())) : "0");
    }

    @Override // d.a.j0.s2.u
    public List<AppData> j() {
        if (this.f60366a == null) {
            this.f60366a = new ArrayList();
        }
        return this.f60366a;
    }

    @Override // d.a.j0.s2.u
    public void k(AdvertAppInfo advertAppInfo, Context context) {
        VideoInfo videoInfo;
        if (advertAppInfo == null) {
            return;
        }
        AdvertAppInfo.ILegoAdvert iLegoAdvert = advertAppInfo.W3;
        AdCard adCard = null;
        if (iLegoAdvert instanceof AdCard) {
            adCard = (AdCard) iLegoAdvert;
            videoInfo = adCard.videoInfo;
        } else {
            videoInfo = null;
        }
        if (adCard == null || videoInfo == null) {
            return;
        }
        AdWebVideoActivity.setStaticInfo(advertAppInfo, 0, "DETAIL");
        String m = x.m(adCard.getScheme());
        Bundle bundle = new Bundle();
        bundle.putString("video_url", videoInfo.video_url);
        bundle.putString(AdWebVideoActivityConfig.KEY_VIDEO_THUMB_URL, videoInfo.thumbnail_url);
        bundle.putFloat(AdWebVideoActivityConfig.KEY_VIDEO_RATIO, videoInfo.video_width.intValue() / videoInfo.video_height.intValue());
        bundle.putInt(AdWebVideoActivityConfig.KEY_VIDEO_DURATION, videoInfo.video_duration.intValue());
        String str = TextUtils.isEmpty(advertAppInfo.J3) ? advertAppInfo.E3 : advertAppInfo.J3;
        if (advertAppInfo.D4()) {
            str = "";
        }
        bundle.putString(WebViewActivityConfig.TAG_DOWNLOAD_AD_ID, str);
        bundle.putString(WebViewActivityConfig.TAG_AD_EXT_INFO, advertAppInfo.T3);
        bundle.putInt(AdWebVideoActivityConfig.KEY_GOOD_STYLE, adCard.goodsStyle);
        bundle.putString(WebViewActivityConfig.TAG_AD_DEEPLINK_URL, adCard.scheme);
        d.a.j0.s2.e0.b.e eVar = adCard.tailFrame;
        if (eVar != null) {
            eVar.f60234e = adCard.buttonText;
            bundle.putString(AdWebVideoActivityConfig.KEY_TAIL_FRAME, eVar.e());
        }
        AdWebVideoActivity.setConfigAndJump(new AdWebVideoActivityConfig(context, "", m, true, true, true, bundle));
    }

    @Override // d.a.j0.s2.u
    public d.a.c.j.e.a<?, ?> l(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, String str) {
        if (bdUniqueId == AdvertAppInfo.j4) {
            return new d.a.j0.s2.a0.a(tbPageContext, bdUniqueId, str);
        }
        if (bdUniqueId != null) {
            return new d.a.j0.s2.a0.b(tbPageContext, bdUniqueId, str);
        }
        return null;
    }

    @Override // d.a.j0.s2.u
    public d.a.j0.b3.a m() {
        return d.a.j0.o.f.a.g();
    }

    @Override // d.a.j0.s2.u
    public void n(boolean z, String str, String str2, String str3, List<a.c> list, String str4) {
        ShowStatisticUploadRequest.sendFRS(z, str, str2, str3, list, str4);
    }

    @Override // d.a.j0.s2.u
    public r o() {
        return d.t();
    }
}

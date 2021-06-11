package d.a.n0.t2;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.atomData.WebViewActivityConfig;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.recapp.activity.AdWebVideoActivity;
import com.baidu.tieba.recapp.activity.AdWebVideoActivityConfig;
import com.baidu.tieba.recapp.constants.Cmatch;
import com.baidu.tieba.recapp.lego.model.AdCard;
import com.baidu.tieba.recapp.request.ShowStatisticUploadRequest;
import d.a.n0.e3.j0.a;
import java.util.ArrayList;
import java.util.List;
import tbclient.App;
import tbclient.VideoInfo;
/* loaded from: classes5.dex */
public class z implements v {

    /* renamed from: a  reason: collision with root package name */
    public List<AdvertAppInfo> f64895a;

    @Override // d.a.n0.t2.v
    public d.a.c.k.e.a<?, ?> a(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        if (baseFragmentActivity == null) {
            return null;
        }
        if (bdUniqueId == AdvertAppInfo.g4) {
            return new d.a.n0.t2.b0.f(baseFragmentActivity, bdUniqueId);
        }
        if (bdUniqueId == AdvertAppInfo.e4) {
            return new d.a.n0.t2.b0.e(baseFragmentActivity, bdUniqueId);
        }
        return null;
    }

    @Override // d.a.n0.t2.v
    public q b() {
        return e.t();
    }

    @Override // d.a.n0.t2.v
    public App c(App app, Cmatch cmatch) {
        return d.a.n0.q.e.a.i().n(app, cmatch);
    }

    @Override // d.a.n0.t2.v
    public void d(boolean z, String str, String str2, String str3, String str4, List<a.c> list, String str5) {
        ShowStatisticUploadRequest.sendPB(z, str, str2, str3, str4, list, str5);
    }

    @Override // d.a.n0.t2.v
    public k e() {
        return new d.a.n0.t2.h0.a();
    }

    @Override // d.a.n0.t2.v
    public l f(@NonNull TbPageContext<?> tbPageContext, @NonNull AdvertAppInfo.ILegoAdvert iLegoAdvert, int i2, boolean z, String str, String str2) {
        if (iLegoAdvert instanceof AdCard) {
            return new d.a.n0.t2.f0.d.a.d(tbPageContext, iLegoAdvert, i2, z, str, str2);
        }
        return null;
    }

    @Override // d.a.n0.t2.v
    public m g() {
        return d.a.n0.q.a.l();
    }

    @Override // d.a.n0.t2.v
    public d.a.c.k.e.a<?, ?> h(u uVar, BdUniqueId bdUniqueId) {
        if (uVar == null || bdUniqueId == null) {
            return null;
        }
        if (bdUniqueId == AdvertAppInfo.d4) {
            return new d.a.n0.t2.b0.c(uVar, bdUniqueId);
        }
        return new d.a.n0.t2.b0.d(uVar, bdUniqueId);
    }

    @Override // d.a.n0.t2.v
    public void i() {
        List<AdvertAppInfo> list = this.f64895a;
        if (list != null) {
            StringUtils.string(Integer.valueOf(list.size()));
        }
    }

    @Override // d.a.n0.t2.v
    public List<AdvertAppInfo> j() {
        if (this.f64895a == null) {
            this.f64895a = new ArrayList();
        }
        return this.f64895a;
    }

    @Override // d.a.n0.t2.v
    public void k(AdvertAppInfo advertAppInfo, Context context) {
        VideoInfo videoInfo;
        if (advertAppInfo == null) {
            return;
        }
        AdvertAppInfo.ILegoAdvert iLegoAdvert = advertAppInfo.R3;
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
        String m = y.m(adCard.getScheme());
        Bundle bundle = new Bundle();
        bundle.putString("video_url", videoInfo.video_url);
        bundle.putString(AdWebVideoActivityConfig.KEY_VIDEO_THUMB_URL, videoInfo.thumbnail_url);
        bundle.putFloat(AdWebVideoActivityConfig.KEY_VIDEO_RATIO, videoInfo.video_width.intValue() / videoInfo.video_height.intValue());
        bundle.putInt(AdWebVideoActivityConfig.KEY_VIDEO_DURATION, videoInfo.video_duration.intValue());
        bundle.putString(WebViewActivityConfig.TAG_DOWNLOAD_AD_ID, advertAppInfo.getDownloadId());
        bundle.putString(WebViewActivityConfig.TAG_AD_EXT_INFO, advertAppInfo.Q3);
        bundle.putInt(AdWebVideoActivityConfig.KEY_GOOD_STYLE, adCard.goodsStyle);
        bundle.putString(WebViewActivityConfig.TAG_AD_DEEPLINK_URL, adCard.scheme);
        d.a.n0.t2.f0.b.f fVar = adCard.tailFrame;
        if (fVar != null) {
            fVar.f64773e = adCard.getButtonText();
            bundle.putString(AdWebVideoActivityConfig.KEY_TAIL_FRAME, adCard.tailFrame.e());
        }
        AdWebVideoActivity.setConfigAndJump(new AdWebVideoActivityConfig(context, "", m, true, true, true, bundle));
    }

    @Override // d.a.n0.t2.v
    public d.a.c.k.e.a<?, ?> l(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, String str) {
        if (bdUniqueId == AdvertAppInfo.f4) {
            return new d.a.n0.t2.b0.a(tbPageContext, bdUniqueId, str);
        }
        if (bdUniqueId != null) {
            return new d.a.n0.t2.b0.b(tbPageContext, bdUniqueId, str);
        }
        return null;
    }

    @Override // d.a.n0.t2.v
    public d.a.n0.c3.a m() {
        return d.a.n0.q.f.a.g();
    }

    @Override // d.a.n0.t2.v
    public void n(boolean z, String str, String str2, String str3, List<a.c> list, String str4) {
        ShowStatisticUploadRequest.sendFRS(z, str, str2, str3, list, str4);
    }

    @Override // d.a.n0.t2.v
    public s o() {
        return e.t();
    }
}

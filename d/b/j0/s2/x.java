package d.b.j0.s2;

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
import d.b.j0.d3.j0.a;
import java.util.ArrayList;
import java.util.List;
import tbclient.App;
import tbclient.VideoInfo;
/* loaded from: classes4.dex */
public class x implements u {

    /* renamed from: a  reason: collision with root package name */
    public List<AppData> f62170a;

    @Override // d.b.j0.s2.u
    public d.b.c.j.e.a<?, ?> a(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        if (baseFragmentActivity == null) {
            return null;
        }
        if (bdUniqueId == AdvertAppInfo.k4) {
            return new d.b.j0.s2.z.f(baseFragmentActivity, bdUniqueId);
        }
        if (bdUniqueId == AdvertAppInfo.i4) {
            return new d.b.j0.s2.z.e(baseFragmentActivity, bdUniqueId);
        }
        return null;
    }

    @Override // d.b.j0.s2.u
    public p b() {
        return d.t();
    }

    @Override // d.b.j0.s2.u
    public App c(App app, Cmatch cmatch) {
        return d.b.j0.o.e.a.i().n(app, cmatch);
    }

    @Override // d.b.j0.s2.u
    public void d(AdvertAppInfo advertAppInfo, Context context) {
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
        String m = w.m(adCard.getScheme());
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
        d.b.j0.s2.c0.b.e eVar = adCard.tailFrame;
        if (eVar != null) {
            eVar.f62021e = adCard.buttonText;
            bundle.putString(AdWebVideoActivityConfig.KEY_TAIL_FRAME, eVar.e());
        }
        AdWebVideoActivity.setConfigAndJump(new AdWebVideoActivityConfig(context, "", m, true, true, true, bundle));
    }

    @Override // d.b.j0.s2.u
    public void e(boolean z, String str, String str2, String str3, String str4, List<a.c> list, String str5) {
        ShowStatisticUploadRequest.sendPB(z, str, str2, str3, str4, list, str5);
    }

    @Override // d.b.j0.s2.u
    public d.b.c.j.e.a<?, ?> f(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, String str) {
        if (bdUniqueId == AdvertAppInfo.j4) {
            return new d.b.j0.s2.z.a(tbPageContext, bdUniqueId, str);
        }
        if (bdUniqueId != null) {
            return new d.b.j0.s2.z.b(tbPageContext, bdUniqueId, str);
        }
        return null;
    }

    @Override // d.b.j0.s2.u
    public j g() {
        return new d.b.j0.s2.e0.a();
    }

    @Override // d.b.j0.s2.u
    public k h(@NonNull TbPageContext<?> tbPageContext, @NonNull AdvertAppInfo.ILegoAdvert iLegoAdvert, int i, boolean z, String str, String str2) {
        if (iLegoAdvert instanceof AdCard) {
            return new d.b.j0.s2.c0.d.a.d(tbPageContext, iLegoAdvert, i, z, str, str2);
        }
        return null;
    }

    @Override // d.b.j0.s2.u
    public l i() {
        return d.b.j0.o.a.l();
    }

    @Override // d.b.j0.s2.u
    public d.b.c.j.e.a<?, ?> j(t tVar, BdUniqueId bdUniqueId) {
        if (tVar == null || bdUniqueId == null) {
            return null;
        }
        if (bdUniqueId == AdvertAppInfo.h4) {
            return new d.b.j0.s2.z.c(tVar, bdUniqueId);
        }
        return new d.b.j0.s2.z.d(tVar, bdUniqueId);
    }

    @Override // d.b.j0.s2.u
    public d.b.j0.b3.a k() {
        return d.b.j0.o.f.a.g();
    }

    @Override // d.b.j0.s2.u
    public void l(boolean z, String str, String str2, String str3, List<a.c> list, String str4) {
        ShowStatisticUploadRequest.sendFRS(z, str, str2, str3, list, str4);
    }

    @Override // d.b.j0.s2.u
    public r m() {
        return d.t();
    }

    @Override // d.b.j0.s2.u
    public void n() {
        List<AppData> list = this.f62170a;
        AdDebugService.updateFloatView(list != null ? StringUtils.string(Integer.valueOf(list.size())) : "0");
    }

    @Override // d.b.j0.s2.u
    public List<AppData> o() {
        if (this.f62170a == null) {
            this.f62170a = new ArrayList();
        }
        return this.f62170a;
    }
}

package d.b.i0.r2;

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
import d.b.i0.c3.j0.a;
import java.util.ArrayList;
import java.util.List;
import tbclient.App;
import tbclient.VideoInfo;
/* loaded from: classes5.dex */
public class u implements r {

    /* renamed from: a  reason: collision with root package name */
    public List<AppData> f59856a;

    @Override // d.b.i0.r2.r
    public d.b.b.j.e.a<?, ?> a(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId) {
        if (baseFragmentActivity == null) {
            return null;
        }
        if (bdUniqueId == AdvertAppInfo.k4) {
            return new d.b.i0.r2.w.f(baseFragmentActivity, bdUniqueId);
        }
        if (bdUniqueId == AdvertAppInfo.i4) {
            return new d.b.i0.r2.w.e(baseFragmentActivity, bdUniqueId);
        }
        return null;
    }

    @Override // d.b.i0.r2.r
    public m b() {
        return c.t();
    }

    @Override // d.b.i0.r2.r
    public App c(App app, Cmatch cmatch) {
        return d.b.i0.o.d.a.i().n(app, cmatch);
    }

    @Override // d.b.i0.r2.r
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
        String m = t.m(adCard.getScheme());
        Bundle bundle = new Bundle();
        bundle.putString("video_url", videoInfo.video_url);
        bundle.putString(AdWebVideoActivityConfig.KEY_VIDEO_THUMB_URL, videoInfo.thumbnail_url);
        bundle.putFloat(AdWebVideoActivityConfig.KEY_VIDEO_RATIO, videoInfo.video_width.intValue() / videoInfo.video_height.intValue());
        bundle.putInt(AdWebVideoActivityConfig.KEY_VIDEO_DURATION, videoInfo.video_duration.intValue());
        String str = TextUtils.isEmpty(advertAppInfo.J3) ? advertAppInfo.E3 : advertAppInfo.J3;
        if (advertAppInfo.C4()) {
            str = "";
        }
        bundle.putString(WebViewActivityConfig.TAG_DOWNLOAD_AD_ID, str);
        bundle.putInt(AdWebVideoActivityConfig.KEY_GOOD_STYLE, adCard.goodsStyle);
        AdCard.g gVar = adCard.tailFrame;
        if (gVar != null) {
            gVar.f20722e = adCard.buttonText;
            bundle.putString(AdWebVideoActivityConfig.KEY_TAIL_FRAME, gVar.e());
        }
        AdWebVideoActivity.setConfigAndJump(new AdWebVideoActivityConfig(context, "", m, true, true, true, bundle));
    }

    @Override // d.b.i0.r2.r
    public void e(boolean z, String str, String str2, String str3, String str4, List<a.c> list, String str5) {
        ShowStatisticUploadRequest.sendPB(z, str, str2, str3, str4, list, str5);
    }

    @Override // d.b.i0.r2.r
    public d.b.b.j.e.a<?, ?> f(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, String str) {
        if (bdUniqueId == AdvertAppInfo.j4) {
            return new d.b.i0.r2.w.a(tbPageContext, bdUniqueId, str);
        }
        if (bdUniqueId != null) {
            return new d.b.i0.r2.w.b(tbPageContext, bdUniqueId, str);
        }
        return null;
    }

    @Override // d.b.i0.r2.r
    public i g(@NonNull TbPageContext<?> tbPageContext, @NonNull AdvertAppInfo.ILegoAdvert iLegoAdvert, int i, boolean z, String str, String str2) {
        if (iLegoAdvert instanceof AdCard) {
            return new d.b.i0.r2.z.c.a.c(tbPageContext, iLegoAdvert, i, z, str, str2);
        }
        return null;
    }

    @Override // d.b.i0.r2.r
    public j h() {
        return d.b.i0.o.a.l();
    }

    @Override // d.b.i0.r2.r
    public d.b.b.j.e.a<?, ?> i(q qVar, BdUniqueId bdUniqueId) {
        if (qVar == null || bdUniqueId == null) {
            return null;
        }
        if (bdUniqueId == AdvertAppInfo.h4) {
            return new d.b.i0.r2.w.c(qVar, bdUniqueId);
        }
        return new d.b.i0.r2.w.d(qVar, bdUniqueId);
    }

    @Override // d.b.i0.r2.r
    public d.b.i0.a3.a j() {
        return d.b.i0.o.e.a.g();
    }

    @Override // d.b.i0.r2.r
    public void k(boolean z, String str, String str2, String str3, List<a.c> list, String str4) {
        ShowStatisticUploadRequest.sendFRS(z, str, str2, str3, list, str4);
    }

    @Override // d.b.i0.r2.r
    public o l() {
        return c.t();
    }

    @Override // d.b.i0.r2.r
    public void m() {
        List<AppData> list = this.f59856a;
        AdDebugService.updateFloatView(list != null ? StringUtils.string(Integer.valueOf(list.size())) : "0");
    }

    @Override // d.b.i0.r2.r
    public List<AppData> n() {
        if (this.f59856a == null) {
            this.f59856a = new ArrayList();
        }
        return this.f59856a;
    }
}

package com.kascend.cstvsdk.utils;

import android.content.Context;
import com.kascend.chushou.a;
import com.kascend.chushou.c.c;
import com.kascend.chushou.constants.ShareInfo;
import com.kascend.chushou.d.f;
import com.kascend.cstvsdk.bean.ShareParam;
import com.kascend.cstvsdk.interfaces.ShareListener;
import com.kascend.cstvsdk.interfaces.ThirdParty;
import com.tencent.connect.common.Constants;
import kotlin.h;
import kotlin.jvm.internal.q;
import org.json.JSONObject;
import tv.chushou.zues.utils.g;
@h
/* loaded from: classes5.dex */
public final class b {
    public static final b ncX = new b();

    private b() {
    }

    @h
    /* loaded from: classes5.dex */
    public static final class a implements com.kascend.chushou.c.b {
        final /* synthetic */ Context a;
        final /* synthetic */ String b;

        a(Context context, String str) {
            this.a = context;
            this.b = str;
        }

        @Override // com.kascend.chushou.c.b
        public void a() {
        }

        @Override // com.kascend.chushou.c.b
        public void a(String str, JSONObject jSONObject) {
            JSONObject optJSONObject;
            q.m(str, "responseString");
            JSONObject optJSONObject2 = (jSONObject == null || (optJSONObject = jSONObject.optJSONObject("data")) == null) ? null : optJSONObject.optJSONObject("shareInfo");
            if (optJSONObject2 != null) {
                ShareInfo dG = com.kascend.chushou.c.a.dG(optJSONObject2);
                b bVar = b.ncX;
                Context context = this.a;
                q.l((Object) dG, "shareInfo");
                bVar.a(context, dG, this.b);
                return;
            }
            a(-1, "");
        }

        @Override // com.kascend.chushou.c.b
        public void a(int i, String str) {
            g.u(f.b(str, a.i.share_failed));
        }
    }

    public final void a(Context context, String str, String str2, ShareInfo shareInfo, String str3, boolean z) {
        q.m(context, "context");
        c.dDV().c(new a(context, str3), str, str2);
    }

    public final void a(Context context, ShareInfo shareInfo, String str) {
        q.m(context, "context");
        q.m(shareInfo, "shareInfo");
        ShareParam shareParam = new ShareParam(null, null, null, null, null, 31, null);
        shareParam.setTitle(shareInfo.mTitle);
        shareParam.setContent(shareInfo.mContent);
        shareParam.setThumbnail(shareInfo.mThumbnail);
        shareParam.setUrl(shareInfo.mUrl);
        shareParam.setPic(shareInfo.mPic);
        ThirdParty thirdParty = (ThirdParty) tv.chushou.basis.d.b.dRm().S(ThirdParty.class);
        if (thirdParty != null) {
            thirdParty.share(context, shareParam, new C0830b(shareParam, str));
        }
    }

    @h
    /* renamed from: com.kascend.cstvsdk.utils.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public static final class C0830b implements ShareListener {
        final /* synthetic */ String b;
        final /* synthetic */ ShareParam ncY;

        C0830b(ShareParam shareParam, String str) {
            this.ncY = shareParam;
            this.b = str;
        }

        @Override // com.kascend.cstvsdk.interfaces.ShareListener
        public void onSuccess(int i) {
            com.kascend.chushou.toolkit.a.a.a(b.ncX.a(i), this.ncY.getUrl(), this.b, "1009");
        }

        @Override // com.kascend.cstvsdk.interfaces.ShareListener
        public void onFailure() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String a(int i) {
        switch (i) {
            case 1:
                return "SinaWeibo";
            case 2:
                return Constants.SOURCE_QQ;
            case 3:
                return "QZone";
            case 4:
                return "Wechat";
            case 5:
                return "WechatMoments";
            default:
                return "Baidu_Other_Platform";
        }
    }
}

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
/* loaded from: classes6.dex */
public final class b {
    public static final b oCb = new b();

    private b() {
    }

    @h
    /* loaded from: classes6.dex */
    public static final class a implements com.kascend.chushou.c.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f4295a;
        final /* synthetic */ String b;

        a(Context context, String str) {
            this.f4295a = context;
            this.b = str;
        }

        @Override // com.kascend.chushou.c.b
        public void a() {
        }

        @Override // com.kascend.chushou.c.b
        public void a(String str, JSONObject jSONObject) {
            JSONObject optJSONObject;
            q.n(str, "responseString");
            JSONObject optJSONObject2 = (jSONObject == null || (optJSONObject = jSONObject.optJSONObject("data")) == null) ? null : optJSONObject.optJSONObject("shareInfo");
            if (optJSONObject2 != null) {
                ShareInfo eu = com.kascend.chushou.c.a.eu(optJSONObject2);
                b bVar = b.oCb;
                Context context = this.f4295a;
                q.m(eu, "shareInfo");
                bVar.a(context, eu, this.b);
                return;
            }
            a(-1, "");
        }

        @Override // com.kascend.chushou.c.b
        public void a(int i, String str) {
            g.x(f.b(str, a.i.share_failed));
        }
    }

    public final void a(Context context, String str, String str2, ShareInfo shareInfo, String str3, boolean z) {
        q.n(context, "context");
        c.ege().c(new a(context, str3), str, str2);
    }

    public final void a(Context context, ShareInfo shareInfo, String str) {
        q.n(context, "context");
        q.n(shareInfo, "shareInfo");
        ShareParam shareParam = new ShareParam(null, null, null, null, null, 31, null);
        shareParam.setTitle(shareInfo.mTitle);
        shareParam.setContent(shareInfo.mContent);
        shareParam.setThumbnail(shareInfo.mThumbnail);
        shareParam.setUrl(shareInfo.mUrl);
        shareParam.setPic(shareInfo.mPic);
        ThirdParty thirdParty = (ThirdParty) tv.chushou.basis.d.b.etD().S(ThirdParty.class);
        if (thirdParty != null) {
            thirdParty.share(context, shareParam, new C0933b(shareParam, str));
        }
    }

    @h
    /* renamed from: com.kascend.cstvsdk.utils.b$b  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static final class C0933b implements ShareListener {
        final /* synthetic */ String b;
        final /* synthetic */ ShareParam oCc;

        C0933b(ShareParam shareParam, String str) {
            this.oCc = shareParam;
            this.b = str;
        }

        @Override // com.kascend.cstvsdk.interfaces.ShareListener
        public void onSuccess(int i) {
            com.kascend.chushou.toolkit.a.a.a(b.oCb.a(i), this.oCc.getUrl(), this.b, "1009");
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

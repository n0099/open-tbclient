package d.a.k0.w2.d;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.pass.biometrics.base.utils.PassBioEnv;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tieba.sharesdk.bean.ShareEntity;
import com.sina.weibo.sdk.WbSdk;
import com.sina.weibo.sdk.api.ImageObject;
import com.sina.weibo.sdk.api.TextObject;
import com.sina.weibo.sdk.api.WebpageObject;
import com.sina.weibo.sdk.api.WeiboMultiMessage;
import com.sina.weibo.sdk.auth.AuthInfo;
import com.sina.weibo.sdk.share.WbShareCallback;
import com.sina.weibo.sdk.share.WbShareHandler;
import com.sina.weibo.sdk.utils.Utility;
/* loaded from: classes5.dex */
public class e extends d.a.k0.w2.d.a {

    /* renamed from: h  reason: collision with root package name */
    public ShareEntity f63129h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.k0.w2.e.b f63130i;
    public WbShareHandler j;
    public WbShareCallback k;
    public final d.a.c.e.l.c<d.a.c.j.d.a> l;

    /* loaded from: classes5.dex */
    public class a extends d.a.c.e.l.c<d.a.c.j.d.a> {
        public a() {
        }

        @Override // d.a.c.e.l.c
        public void onCancelled(String str) {
            super.onCancelled(str);
            if (e.this.f63130i != null) {
                e.this.f63130i.onShare(6, 3);
            }
            e.this.w(3, 6);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.l.c
        public void onLoaded(d.a.c.j.d.a aVar, String str, int i2) {
            super.onLoaded((a) aVar, str, i2);
            if (aVar != null) {
                Bitmap p = aVar.p();
                e eVar = e.this;
                eVar.L(eVar.f63129h, p);
                return;
            }
            e eVar2 = e.this;
            eVar2.L(eVar2.f63129h, null);
        }
    }

    public e(Activity activity, d.a.k0.w2.e.b bVar, WbShareCallback wbShareCallback) {
        super(activity);
        this.l = new a();
        try {
            WbSdk.install(activity, new AuthInfo(activity, "1511099634", PassBioEnv.PASSPORT_DOMAIN, "invitation_write"));
        } catch (Exception e2) {
            BdLog.e(e2);
        }
        this.f63118b = activity;
        this.f63130i = bVar;
        this.k = wbShareCallback;
        WbShareHandler wbShareHandler = new WbShareHandler(activity);
        this.j = wbShareHandler;
        if (wbShareHandler != null) {
            wbShareHandler.registerApp();
        }
    }

    public final String C(String str) {
        return str == null ? "" : str;
    }

    public final ImageObject D(Bitmap bitmap) {
        ImageObject imageObject = new ImageObject();
        imageObject.setThumbImage(i(bitmap, 120));
        imageObject.setImageObject(bitmap);
        return imageObject;
    }

    public final WebpageObject E(Bitmap bitmap, String str, String str2, String str3) {
        if (bitmap == null) {
            return null;
        }
        WebpageObject webpageObject = new WebpageObject();
        webpageObject.setThumbImage(bitmap);
        webpageObject.identify = Utility.generateGUID();
        webpageObject.title = C(str);
        webpageObject.description = C(str2);
        webpageObject.actionUrl = C(str3);
        return webpageObject;
    }

    public final WebpageObject F(byte[] bArr, String str) {
        if (bArr == null) {
            return null;
        }
        WebpageObject webpageObject = new WebpageObject();
        webpageObject.thumbData = bArr;
        webpageObject.identify = Utility.generateGUID();
        webpageObject.title = "";
        webpageObject.description = "";
        webpageObject.actionUrl = C(str);
        return webpageObject;
    }

    public final TextObject G() {
        if (this.f63129h == null) {
            return null;
        }
        TextObject textObject = new TextObject();
        textObject.title = C(this.f63129h.n());
        textObject.text = C(this.f63129h.topic) + C(this.f63129h.b());
        return textObject;
    }

    public final WebpageObject H(WeiboMultiMessage weiboMultiMessage, ShareEntity shareEntity, Bitmap bitmap) {
        byte[] bArr;
        byte[] bArr2 = null;
        if (weiboMultiMessage != null && shareEntity != null) {
            String g2 = shareEntity.g();
            if (TextUtils.isEmpty(g2)) {
                return null;
            }
            if (weiboMultiMessage.textObject != null) {
                ImageObject imageObject = weiboMultiMessage.imageObject;
                if (imageObject != null && (bArr = imageObject.thumbData) != null) {
                    bArr2 = bArr;
                } else if (bitmap != null) {
                    bArr2 = BitmapHelper.Bitmap2Bytes(i(bitmap, 120), 100);
                }
                return F(bArr2, g2);
            } else if (bitmap != null) {
                return E(i(bitmap, 120), shareEntity.n(), shareEntity.b(), g2);
            }
        }
        return null;
    }

    public void I() {
        d.a.k0.w2.e.b bVar = this.f63130i;
        if (bVar != null) {
            bVar.onShare(6, 3);
        }
        w(3, 6);
    }

    public void J() {
        d.a.k0.w2.e.b bVar = this.f63130i;
        if (bVar != null) {
            bVar.onShare(6, 2);
        }
        w(2, 6);
    }

    public void K() {
        d.a.k0.w2.e.b bVar = this.f63130i;
        if (bVar != null) {
            bVar.onShare(6, 1);
        }
        w(1, 6);
    }

    public final void L(ShareEntity shareEntity, Bitmap bitmap) {
        if (this.f63129h != null && this.j != null && (this.f63118b instanceof Activity)) {
            WeiboMultiMessage weiboMultiMessage = new WeiboMultiMessage();
            if (!TextUtils.isEmpty(shareEntity.b()) || !TextUtils.isEmpty(shareEntity.topic)) {
                weiboMultiMessage.textObject = G();
            }
            if (bitmap != null) {
                weiboMultiMessage.imageObject = D(bitmap);
            }
            WebpageObject H = H(weiboMultiMessage, shareEntity, bitmap);
            if (H != null) {
                weiboMultiMessage.mediaObject = H;
            }
            this.j.shareMessage(weiboMultiMessage, false);
            return;
        }
        d.a.k0.w2.e.b bVar = this.f63130i;
        if (bVar != null) {
            bVar.onShare(6, 2);
        }
        w(2, 6);
    }

    @Override // d.a.k0.w2.e.a
    public void a(ShareEntity shareEntity, d.a.k0.w2.e.b bVar) {
        if (shareEntity != null && this.j != null) {
            this.f63129h = shareEntity;
            this.f63130i = bVar;
            d.a.c.j.d.a o = o(shareEntity);
            if (o != null && o.p() != null) {
                L(this.f63129h, o.p());
                return;
            }
            String e2 = shareEntity.e();
            if (n(shareEntity.h())) {
                L(this.f63129h, g(shareEntity.h()));
                return;
            } else if (!TextUtils.isEmpty(e2) && (e2.startsWith("http://") || e2.startsWith("https://"))) {
                d.a.c.e.l.d.h().k(e2, 10, this.l, 0, 0, h(), new Object[0]);
                return;
            } else if (m(shareEntity.d())) {
                L(this.f63129h, f(shareEntity.d()));
                return;
            } else {
                L(this.f63129h, d());
                return;
            }
        }
        w(2, 6);
        if (bVar != null) {
            bVar.onShare(6, 2);
        }
    }

    @Override // d.a.k0.w2.d.a
    public void l(Intent intent) {
        WbShareCallback wbShareCallback;
        WbShareHandler wbShareHandler = this.j;
        if (wbShareHandler == null || (wbShareCallback = this.k) == null) {
            return;
        }
        wbShareHandler.doResultIntent(intent, wbShareCallback);
        if (intent == null || intent.getExtras() != null) {
            return;
        }
        this.k.onWbShareSuccess();
    }
}

package d.b.i0.v2.d;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.content.FileProvider;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.WXEntryActivityConfig;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.resourceLoaderProc.EmotionShareLoaderProc;
import com.baidu.tieba.R;
import com.baidu.tieba.sharesdk.ShareHandlerActivity;
import com.baidu.tieba.sharesdk.bean.ShareEntity;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX;
import com.tencent.mm.opensdk.modelmsg.WXEmojiObject;
import com.tencent.mm.opensdk.modelmsg.WXImageObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.opensdk.modelmsg.WXMiniProgramObject;
import com.tencent.mm.opensdk.modelmsg.WXTextObject;
import com.tencent.mm.opensdk.modelmsg.WXVideoObject;
import com.tencent.mm.opensdk.modelmsg.WXWebpageObject;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import d.b.b.e.p.k;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.net.URLEncoder;
/* loaded from: classes5.dex */
public class f extends d.b.i0.v2.d.a {

    /* renamed from: h  reason: collision with root package name */
    public int f62064h;
    public ShareEntity i;
    public d.b.i0.v2.e.b j;
    public IWXAPI k;
    public d l;
    public final d.b.b.e.l.c<EmotionShareLoaderProc.EmotionShare> m;
    public final c n;

    /* loaded from: classes5.dex */
    public class a extends d.b.b.e.l.c<EmotionShareLoaderProc.EmotionShare> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.b.e.l.c
        /* renamed from: a */
        public void onLoaded(EmotionShareLoaderProc.EmotionShare emotionShare, String str, int i) {
            super.onLoaded(emotionShare, str, i);
            if (emotionShare != null && emotionShare.image != null) {
                f fVar = f.this;
                if (fVar.a0(fVar.i, emotionShare)) {
                    return;
                }
            }
            f.this.n.onLoaded((d.b.b.j.d.a) null, str, i);
        }

        @Override // d.b.b.e.l.c
        public void onCancelled(String str) {
            super.onCancelled(str);
            f.this.n.onCancelled(str);
        }
    }

    /* loaded from: classes5.dex */
    public class b extends BdAsyncTask<Bitmap, Void, Bitmap> {
        public b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Bitmap doInBackground(Bitmap... bitmapArr) {
            if (bitmapArr.length <= 0 || bitmapArr[0] == null) {
                return null;
            }
            f fVar = f.this;
            return fVar.r(bitmapArr[0], fVar.i, false);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public void onPostExecute(Bitmap bitmap) {
            super.onPostExecute((b) bitmap);
            f fVar = f.this;
            fVar.g0(fVar.i, bitmap);
        }
    }

    /* loaded from: classes5.dex */
    public final class c extends d.b.b.e.l.c<d.b.b.j.d.a> {
        public c() {
        }

        @Override // d.b.b.e.l.c
        public void onCancelled(String str) {
            super.onCancelled(str);
            if (f.this.j != null) {
                f.this.j.onShare(f.this.f62064h, 3);
            }
            f fVar = f.this;
            fVar.w(3, fVar.f62064h);
        }

        public /* synthetic */ c(f fVar, a aVar) {
            this();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.b.e.l.c
        public void onLoaded(d.b.b.j.d.a aVar, String str, int i) {
            super.onLoaded((c) aVar, str, i);
            if (aVar == null) {
                f.this.i0();
                return;
            }
            Bitmap p = aVar.p();
            if (!TextUtils.isEmpty(f.this.i.g())) {
                if (f.this.f62064h != 2) {
                    String m = f.this.i.m();
                    int o = f.this.i.o();
                    if ((o != 2 && o != 4 && (StringUtils.isNull(m) || m.equals("0"))) || !f.this.i.canShareBySmartApp) {
                        f fVar = f.this;
                        fVar.h0(fVar.i, p);
                        return;
                    }
                    f fVar2 = f.this;
                    fVar2.d0(fVar2.i, p);
                    return;
                }
                f fVar3 = f.this;
                fVar3.h0(fVar3.i, p);
            } else if (TextUtils.isEmpty(f.this.i.p())) {
                if (!TextUtils.isEmpty(f.this.i.b())) {
                    f.this.i0();
                    return;
                }
                f fVar4 = f.this;
                fVar4.b0(fVar4.i, p);
            } else {
                f fVar5 = f.this;
                fVar5.f0(fVar5.i, p);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d extends BroadcastReceiver {
        public d() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent.hasExtra("weixin_result_errCode")) {
                int intExtra = intent.getIntExtra("weixin_result_errCode", 0);
                if (intExtra == 0) {
                    if (f.this.j != null) {
                        f.this.j.onShare(f.this.f62064h, 1);
                    }
                    f fVar = f.this;
                    fVar.w(1, fVar.f62064h);
                } else if (intExtra == -2) {
                    if (f.this.j != null) {
                        f.this.j.onShare(f.this.f62064h, 3);
                    }
                    f fVar2 = f.this;
                    fVar2.w(3, fVar2.f62064h);
                } else {
                    f.this.l0(intExtra, intent.getStringExtra("weixin_result_errMsg"));
                    if (f.this.j != null) {
                        f.this.j.onShare(f.this.f62064h, 2);
                    }
                    f fVar3 = f.this;
                    fVar3.w(2, fVar3.f62064h);
                }
                f.this.T();
            }
        }

        public /* synthetic */ d(f fVar, a aVar) {
            this();
        }
    }

    public f(Context context, int i) {
        super(context);
        this.m = new a();
        this.n = new c(this, null);
        this.f62052b = context.getApplicationContext();
        this.f62064h = i;
        this.k = WXAPIFactory.createWXAPI(context.getApplicationContext(), TbConfig.WEIXIN_SHARE_APP_ID);
    }

    public byte[] M(Bitmap bitmap) {
        try {
            Bitmap i = i(bitmap, 120);
            if (i == null) {
                i = d();
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            i.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            return byteArray;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public byte[] N(Bitmap bitmap, int i, boolean z) {
        Bitmap i2;
        try {
            if (z) {
                i2 = e(R.drawable.miniprogram_share_defaults);
            } else {
                i2 = i(bitmap, i);
            }
            if (i2 == null) {
                i2 = e(R.drawable.miniprogram_share_defaults);
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            i2.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            return byteArray;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public final int O() {
        int i = this.f62064h;
        if (i == 3) {
            return 0;
        }
        return i == 2 ? 1 : -1;
    }

    public final String P(String str) {
        if (str == null) {
            return String.valueOf(System.currentTimeMillis());
        }
        return str + System.currentTimeMillis();
    }

    public boolean Q() {
        return Build.VERSION.SDK_INT >= 24;
    }

    public boolean R(Context context) {
        return this.k.getWXAppSupportAPI() >= 654314752;
    }

    public byte[] S() {
        try {
            Bitmap e2 = e(R.drawable.miniprogram_share_defaults);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            e2.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            return byteArray;
        } catch (Exception e3) {
            e3.printStackTrace();
            return null;
        }
    }

    public final void T() {
        FileHelper.deleteFile(new File(d.b.i0.v2.d.a.f62048e + d.b.i0.v2.d.a.f62050g));
    }

    public String U(Context context, File file) {
        if (file == null || !file.exists()) {
            return null;
        }
        Uri uriForFile = FileProvider.getUriForFile(context, context.getPackageName() + ".fileprovider", file);
        context.grantUriPermission("com.tencent.mm", uriForFile, 1);
        return uriForFile.toString();
    }

    public final boolean V(WXImageObject wXImageObject, Bitmap bitmap) {
        Context context = this.f62052b;
        if (context != null && wXImageObject != null && bitmap != null && R(context) && Q()) {
            try {
                X(wXImageObject, FileHelper.saveFileAsPNG(d.b.i0.v2.d.a.f62048e, d.b.i0.v2.d.a.f62050g, bitmap, 100), bitmap);
                return true;
            } catch (Exception e2) {
                BdLog.e(e2);
            }
        }
        return false;
    }

    public final void W() {
        if (this.f62052b != null) {
            this.l = new d(this, null);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction(WXEntryActivityConfig.ACTION_WX_SHARE_RESULT);
            this.f62052b.registerReceiver(this.l, intentFilter);
        }
    }

    public final void X(@NonNull WXImageObject wXImageObject, @NonNull String str, @NonNull Bitmap bitmap) {
        wXImageObject.setImagePath(U(this.f62052b, new File(str)));
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.mediaObject = wXImageObject;
        wXMediaMessage.thumbData = M(bitmap);
        SendMessageToWX.Req req = new SendMessageToWX.Req();
        req.transaction = P("imageShare");
        req.message = wXMediaMessage;
        req.scene = O();
        this.k.sendReq(req);
    }

    public final boolean Y(ShareEntity shareEntity, EmotionShareLoaderProc.EmotionShare emotionShare) {
        if (shareEntity == null || this.k == null || emotionShare == null || emotionShare.image == null || StringUtils.isNull(emotionShare.path)) {
            return false;
        }
        WXEmojiObject wXEmojiObject = new WXEmojiObject();
        wXEmojiObject.emojiPath = emotionShare.path;
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.mediaObject = wXEmojiObject;
        wXMediaMessage.thumbData = M(emotionShare.image.p());
        SendMessageToWX.Req req = new SendMessageToWX.Req();
        req.transaction = P("imageShare");
        req.message = wXMediaMessage;
        req.scene = O();
        this.k.sendReq(req);
        return true;
    }

    public final void Z(ShareEntity shareEntity, Bitmap bitmap) {
        if (shareEntity == null || this.k == null || bitmap == null) {
            return;
        }
        WXEmojiObject wXEmojiObject = new WXEmojiObject();
        wXEmojiObject.emojiData = N(bitmap, 512, false);
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.mediaObject = wXEmojiObject;
        wXMediaMessage.thumbData = M(bitmap);
        SendMessageToWX.Req req = new SendMessageToWX.Req();
        req.transaction = P("imageShare");
        req.message = wXMediaMessage;
        req.scene = O();
        this.k.sendReq(req);
    }

    @Override // d.b.i0.v2.e.a
    public void a(ShareEntity shareEntity, d.b.i0.v2.e.b bVar) {
        if (shareEntity != null && this.k != null) {
            this.i = shareEntity;
            this.j = bVar;
            this.f62064h = shareEntity.j();
            if (!this.k.isWXAppInstalled()) {
                d.b.i0.v2.e.b bVar2 = this.j;
                if (bVar2 != null) {
                    bVar2.onShare(this.f62064h, 2);
                }
                BdToast.e(c(), c().getText(R.string.share_weixin_not_installed_yet), 0, ShareHandlerActivity.skinType).q();
                return;
            }
            d.b.b.j.d.a o = o(shareEntity);
            if (o != null && o.p() != null) {
                if (this.i.k() == 2) {
                    Z(this.i, o.p());
                    return;
                } else {
                    b0(this.i, o.p());
                    return;
                }
            } else if (n(shareEntity.h())) {
                j0(shareEntity.h());
                return;
            } else {
                String e2 = shareEntity.e();
                if (!TextUtils.isEmpty(e2) && (e2.startsWith("http://") || e2.startsWith("https://"))) {
                    if (this.i.k() != 0) {
                        d.b.b.e.l.d.h().k(e2, 34, this.m, 0, 0, h(), new Object[0]);
                        return;
                    } else {
                        d.b.b.e.l.d.h().k(e2, 10, this.n, 0, 0, h(), new Object[0]);
                        return;
                    }
                } else if (m(shareEntity.d())) {
                    j0(shareEntity.d().getPath());
                    return;
                } else {
                    i0();
                    return;
                }
            }
        }
        w(2, this.f62064h);
        if (bVar != null) {
            bVar.onShare(0, 2);
        }
    }

    public final boolean a0(ShareEntity shareEntity, EmotionShareLoaderProc.EmotionShare emotionShare) {
        if (this.f62064h != 2 && this.i.k() != 1) {
            return Y(shareEntity, emotionShare);
        }
        return c0(shareEntity, emotionShare);
    }

    public final void b0(ShareEntity shareEntity, Bitmap bitmap) {
        if (shareEntity == null || this.k == null || bitmap == null) {
            return;
        }
        WXImageObject wXImageObject = new WXImageObject(bitmap);
        if (V(wXImageObject, bitmap)) {
            return;
        }
        wXImageObject.imageData = d.b.b.e.p.d.d().a(bitmap, 85);
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.mediaObject = wXImageObject;
        wXMediaMessage.thumbData = M(bitmap);
        SendMessageToWX.Req req = new SendMessageToWX.Req();
        req.transaction = P("imageShare");
        req.message = wXMediaMessage;
        req.scene = O();
        this.k.sendReq(req);
    }

    public final boolean c0(ShareEntity shareEntity, EmotionShareLoaderProc.EmotionShare emotionShare) {
        d.b.b.j.d.a aVar;
        if (shareEntity == null || this.k == null || emotionShare == null || StringUtils.isNull(emotionShare.path) || (aVar = emotionShare.image) == null || aVar.p() == null) {
            return false;
        }
        WXImageObject wXImageObject = new WXImageObject();
        wXImageObject.setImagePath(emotionShare.path);
        if (V(wXImageObject, emotionShare.image.p())) {
            return false;
        }
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.mediaObject = wXImageObject;
        wXMediaMessage.thumbData = M(emotionShare.image.p());
        SendMessageToWX.Req req = new SendMessageToWX.Req();
        req.transaction = P("imageShare");
        req.message = wXMediaMessage;
        req.scene = O();
        this.k.sendReq(req);
        return true;
    }

    public final void d0(ShareEntity shareEntity, Bitmap bitmap) {
        if (shareEntity == null || this.k == null) {
            return;
        }
        WXMiniProgramObject wXMiniProgramObject = new WXMiniProgramObject();
        wXMiniProgramObject.webpageUrl = shareEntity.g();
        wXMiniProgramObject.miniprogramType = 0;
        wXMiniProgramObject.userName = "gh_213e5678c5bf";
        if (shareEntity.o() != 2 && shareEntity.o() != 4) {
            String m = shareEntity.m();
            wXMiniProgramObject.path = "/pages/pb/pb?tid=" + m;
        } else {
            String q = shareEntity.q();
            if (k.isEmpty(q)) {
                q = "";
            }
            String encode = URLEncoder.encode(q);
            wXMiniProgramObject.path = "/pages/frs/frs?kw=" + encode;
        }
        WXMediaMessage wXMediaMessage = new WXMediaMessage(wXMiniProgramObject);
        String n = shareEntity.n();
        if (StringUtils.isNull(n)) {
            n = shareEntity.b();
        }
        wXMediaMessage.title = n;
        wXMediaMessage.description = shareEntity.b();
        if ("https://tb5.bdstatic.com/yunying/tieba_logo.jpg".equals(shareEntity.e())) {
            wXMediaMessage.thumbData = m0(bitmap, true);
        } else {
            wXMediaMessage.thumbData = m0(bitmap, false);
        }
        SendMessageToWX.Req req = new SendMessageToWX.Req();
        req.transaction = P("miniProgram");
        req.message = wXMediaMessage;
        req.scene = 0;
        this.k.sendReq(req);
    }

    public final void e0(ShareEntity shareEntity) {
        if (shareEntity == null || this.k == null) {
            return;
        }
        String b2 = shareEntity.b();
        WXTextObject wXTextObject = new WXTextObject();
        wXTextObject.text = b2;
        WXMediaMessage wXMediaMessage = new WXMediaMessage();
        wXMediaMessage.mediaObject = wXTextObject;
        wXMediaMessage.description = b2;
        SendMessageToWX.Req req = new SendMessageToWX.Req();
        req.transaction = P("textShare");
        req.message = wXMediaMessage;
        req.scene = O();
        this.k.sendReq(req);
    }

    public final void f0(ShareEntity shareEntity, Bitmap bitmap) {
        if (shareEntity == null || this.k == null) {
            return;
        }
        WXVideoObject wXVideoObject = new WXVideoObject();
        wXVideoObject.videoUrl = shareEntity.p();
        WXMediaMessage wXMediaMessage = new WXMediaMessage(wXVideoObject);
        wXMediaMessage.title = shareEntity.n();
        wXMediaMessage.description = shareEntity.b();
        wXMediaMessage.thumbData = M(bitmap);
        SendMessageToWX.Req req = new SendMessageToWX.Req();
        req.transaction = P("videoShare");
        req.message = wXMediaMessage;
        req.scene = O();
        this.k.sendReq(req);
    }

    public final void g0(ShareEntity shareEntity, Bitmap bitmap) {
        if (shareEntity == null || this.k == null) {
            return;
        }
        WXWebpageObject wXWebpageObject = new WXWebpageObject();
        wXWebpageObject.webpageUrl = shareEntity.g();
        WXMediaMessage wXMediaMessage = new WXMediaMessage(wXWebpageObject);
        wXMediaMessage.title = shareEntity.n();
        wXMediaMessage.description = shareEntity.b();
        wXMediaMessage.thumbData = M(bitmap);
        SendMessageToWX.Req req = new SendMessageToWX.Req();
        req.transaction = P("webpageShare");
        req.message = wXMediaMessage;
        req.scene = O();
        this.k.sendReq(req);
    }

    public final void h0(ShareEntity shareEntity, Bitmap bitmap) {
        if (shareEntity.f()) {
            b bVar = new b();
            bVar.setPriority(3);
            bVar.execute(bitmap);
            return;
        }
        g0(this.i, bitmap);
    }

    public final void i0() {
        Bitmap d2 = d();
        if (d2 != null) {
            b0(this.i, d2);
        } else {
            e0(this.i);
        }
    }

    public final void j0(String str) {
        Bitmap g2 = g(str);
        if (g2 == null) {
            g2 = d();
        }
        if (g2 != null) {
            b0(this.i, g2);
        } else {
            e0(this.i);
        }
    }

    public final void k0() {
        d dVar;
        Context context = this.f62052b;
        if (context == null || (dVar = this.l) == null) {
            return;
        }
        context.unregisterReceiver(dVar);
    }

    public final void l0(int i, String str) {
        ShareEntity shareEntity = this.i;
        if (shareEntity == null || StringUtils.isNull(shareEntity.e())) {
            return;
        }
        d.b.h0.r.z.a.a("socail_share", -1L, 0, WXEntryActivityConfig.WX_SHARE_FAIL, i, "", "share_fail_exception", str + "&" + this.i.e());
    }

    public byte[] m0(Bitmap bitmap, boolean z) {
        try {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            if (!z && bitmap != null) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                double length = byteArray.length / 1024;
                if (length <= 125.0d) {
                    return byteArray;
                }
                while (length > 125.0d) {
                    Double valueOf = Double.valueOf(length / 125.0d);
                    Double valueOf2 = Double.valueOf(width / Math.sqrt(valueOf.doubleValue()));
                    Double valueOf3 = Double.valueOf(height / Math.sqrt(valueOf.doubleValue()));
                    width = valueOf2.intValue();
                    height = valueOf3.intValue();
                    bitmap = j(bitmap, width, height);
                    ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
                    bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream2);
                    byteArray = byteArrayOutputStream2.toByteArray();
                    length = byteArray.length / 1024;
                }
                byteArrayOutputStream.close();
                return bitmap == null ? S() : byteArray;
            }
            return S();
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    @Override // d.b.i0.v2.d.a
    public void p() {
        k0();
        super.p();
    }

    @Override // d.b.i0.v2.d.a
    public void q(BdUniqueId bdUniqueId) {
        super.q(bdUniqueId);
        W();
    }
}

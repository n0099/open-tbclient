package d.a.n0.x2.d;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import com.alibaba.fastjson.asm.Label;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.resourceLoaderProc.EmotionShareLoaderProc;
import com.baidu.tieba.R;
import com.baidu.tieba.sharesdk.bean.ShareEntity;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.Tencent;
import com.tencent.tauth.UiError;
import java.io.File;
import java.util.Iterator;
/* loaded from: classes5.dex */
public class b extends d.a.n0.x2.d.a {

    /* renamed from: h  reason: collision with root package name */
    public Tencent f67021h;

    /* renamed from: i  reason: collision with root package name */
    public int f67022i;
    public IUiListener j;
    public ShareEntity k;
    public final d.a.c.e.l.c<EmotionShareLoaderProc.EmotionShare> l;
    public d.a.c.e.l.c<d.a.c.k.d.a> m;

    /* loaded from: classes5.dex */
    public class a extends d.a.c.e.l.c<EmotionShareLoaderProc.EmotionShare> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.l.c
        /* renamed from: a */
        public void onLoaded(EmotionShareLoaderProc.EmotionShare emotionShare, String str, int i2) {
            super.onLoaded(emotionShare, str, i2);
            if (emotionShare != null && emotionShare.image != null && !TextUtils.isEmpty(emotionShare.path)) {
                b bVar = b.this;
                bVar.D(emotionShare.path, bVar.j);
                return;
            }
            b bVar2 = b.this;
            bVar2.w(2, bVar2.f67022i);
        }

        @Override // d.a.c.e.l.c
        public void onCancelled(String str) {
            super.onCancelled(str);
            b bVar = b.this;
            bVar.w(3, bVar.f67022i);
        }
    }

    /* renamed from: d.a.n0.x2.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1798b extends d.a.c.e.l.c<d.a.c.k.d.a> {

        /* renamed from: d.a.n0.x2.d.b$b$a */
        /* loaded from: classes5.dex */
        public class a extends BdAsyncTask<d.a.c.k.d.a, Void, Bitmap> {
            public a() {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            /* renamed from: b */
            public Bitmap doInBackground(d.a.c.k.d.a... aVarArr) {
                if (aVarArr.length <= 0 || aVarArr[0] == null) {
                    return null;
                }
                Bitmap p = aVarArr[0].p();
                b bVar = b.this;
                return bVar.r(p, bVar.k, true);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            public void onPostExecute(Bitmap bitmap) {
                super.onPostExecute((a) bitmap);
                b bVar = b.this;
                bVar.C(bVar.k, bVar.j);
            }
        }

        public C1798b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.l.c
        public void onLoaded(d.a.c.k.d.a aVar, String str, int i2) {
            super.onLoaded((C1798b) aVar, str, i2);
            if (aVar != null) {
                a aVar2 = new a();
                aVar2.setPriority(3);
                aVar2.execute(aVar);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c implements IUiListener {

        /* renamed from: a  reason: collision with root package name */
        public d.a.n0.x2.e.b f67026a;

        public c(d.a.n0.x2.e.b bVar) {
            this.f67026a = bVar;
        }

        public final void a() {
            FileHelper.deleteFile(new File(d.a.n0.x2.d.a.f67014e + d.a.n0.x2.d.a.f67015f));
        }

        @Override // com.tencent.tauth.IUiListener
        public void onCancel() {
            d.a.n0.x2.e.b bVar = this.f67026a;
            if (bVar != null) {
                bVar.onShare(b.this.f67022i, 3);
            }
            int i2 = b.this.f67022i;
            a();
        }

        @Override // com.tencent.tauth.IUiListener
        public void onComplete(Object obj) {
            d.a.n0.x2.e.b bVar = this.f67026a;
            if (bVar != null) {
                bVar.onShare(b.this.f67022i, 1);
            }
            b bVar2 = b.this;
            bVar2.w(1, bVar2.f67022i);
            a();
        }

        @Override // com.tencent.tauth.IUiListener
        public void onError(UiError uiError) {
            d.a.n0.x2.e.b bVar = this.f67026a;
            if (bVar != null) {
                bVar.onShare(b.this.f67022i, 2);
            }
            String str = uiError != null ? uiError.errorMessage : null;
            b bVar2 = b.this;
            bVar2.x(2, str, bVar2.f67022i);
            a();
        }
    }

    public b(Context context) {
        super(context);
        this.f67022i = 8;
        this.l = new a();
        this.m = new C1798b();
        this.f67021h = Tencent.createInstance("101462192", context.getApplicationContext());
    }

    public final void B(ShareEntity shareEntity, d.a.n0.x2.e.b bVar) {
        String str;
        if (shareEntity == null) {
            return;
        }
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("text/plain");
        Iterator<ResolveInfo> it = this.f67018b.getPackageManager().queryIntentActivities(intent, 0).iterator();
        while (true) {
            if (!it.hasNext()) {
                str = "";
                break;
            }
            ResolveInfo next = it.next();
            if (TextUtils.equals("com.tencent.mobileqq", next.activityInfo.packageName)) {
                str = next.activityInfo.name;
                break;
            }
        }
        Intent intent2 = new Intent("android.intent.action.SEND");
        intent2.setType("text/plain");
        intent2.putExtra("android.intent.extra.SUBJECT", shareEntity.n());
        intent2.putExtra("android.intent.extra.TEXT", shareEntity.b());
        intent2.setClassName("com.tencent.mobileqq", str);
        intent2.setFlags(Label.FORWARD_REFERENCE_TYPE_SHORT);
        if (d.a.n0.x2.f.a.a(this.f67018b, intent2)) {
            if (bVar != null) {
                bVar.onShare(this.f67022i, 1);
                return;
            }
            return;
        }
        if (bVar != null) {
            bVar.onShare(this.f67022i, 2);
        }
        w(2, this.f67022i);
    }

    public final void C(ShareEntity shareEntity, IUiListener iUiListener) {
        if (shareEntity == null || iUiListener == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("title", shareEntity.n());
        if (shareEntity.i() >= 0) {
            if (shareEntity.i() < 10000) {
                bundle.putString("summary", this.f67018b.getString(R.string.share_qq_default_content));
            } else {
                bundle.putString("summary", StringHelper.numberUniformFormatExtra(shareEntity.i()) + this.f67018b.getString(R.string.share_qq_content));
            }
        } else {
            bundle.putString("summary", shareEntity.b());
        }
        bundle.putString("targetUrl", shareEntity.g());
        bundle.putInt("req_type", 1);
        if (shareEntity.f() && !StringUtils.isNull(shareEntity.e()) && !shareEntity.e().startsWith("http")) {
            bundle.putString("imageLocalUrl", shareEntity.e());
        } else {
            bundle.putString("imageUrl", shareEntity.e());
        }
        this.f67021h.shareToQQ((Activity) this.f67018b, bundle, iUiListener);
    }

    public final void D(String str, IUiListener iUiListener) {
        if (TextUtils.isEmpty(str) || iUiListener == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("imageLocalUrl", str);
        bundle.putInt("req_type", 5);
        bundle.putInt("cflag", 2);
        this.f67021h.shareToQQ((Activity) this.f67018b, bundle, iUiListener);
    }

    @Override // d.a.n0.x2.e.a
    public void a(ShareEntity shareEntity, d.a.n0.x2.e.b bVar) {
        if (shareEntity != null && this.f67021h != null) {
            Context context = this.f67018b;
            if (context != null && (context instanceof Activity)) {
                this.j = new c(bVar);
                String e2 = shareEntity.e();
                if (n(shareEntity.h())) {
                    D(shareEntity.h(), this.j);
                    return;
                } else if (shareEntity.k() != 0 && !TextUtils.isEmpty(e2) && (e2.startsWith("http://") || e2.startsWith("https://"))) {
                    d.a.c.e.l.d.h().k(e2, 34, this.l, 0, 0, h(), new Object[0]);
                    return;
                } else if (!TextUtils.isEmpty(shareEntity.g()) && !TextUtils.isEmpty(shareEntity.n())) {
                    this.k = shareEntity;
                    if (shareEntity.f()) {
                        d.a.c.e.l.d.h().k(shareEntity.e(), 10, this.m, 0, 0, h(), new Object[0]);
                        return;
                    } else {
                        C(shareEntity, this.j);
                        return;
                    }
                } else if (m(shareEntity.d())) {
                    D(shareEntity.d().getPath(), this.j);
                    return;
                } else {
                    B(shareEntity, bVar);
                    return;
                }
            }
            w(2, this.f67022i);
            if (bVar != null) {
                bVar.onShare(0, 2);
                return;
            }
            return;
        }
        w(2, this.f67022i);
        if (bVar != null) {
            bVar.onShare(0, 2);
        }
    }
}

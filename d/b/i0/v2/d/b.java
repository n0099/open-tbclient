package d.b.i0.v2.d;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
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
public class b extends d.b.i0.v2.d.a {

    /* renamed from: h  reason: collision with root package name */
    public Tencent f62055h;
    public int i;
    public IUiListener j;
    public ShareEntity k;
    public final d.b.b.e.l.c<EmotionShareLoaderProc.EmotionShare> l;
    public d.b.b.e.l.c<d.b.b.j.d.a> m;

    /* loaded from: classes5.dex */
    public class a extends d.b.b.e.l.c<EmotionShareLoaderProc.EmotionShare> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.b.e.l.c
        /* renamed from: a */
        public void onLoaded(EmotionShareLoaderProc.EmotionShare emotionShare, String str, int i) {
            super.onLoaded(emotionShare, str, i);
            if (emotionShare != null && emotionShare.image != null && !TextUtils.isEmpty(emotionShare.path)) {
                b bVar = b.this;
                bVar.D(emotionShare.path, bVar.j);
                return;
            }
            b bVar2 = b.this;
            bVar2.w(2, bVar2.i);
        }

        @Override // d.b.b.e.l.c
        public void onCancelled(String str) {
            super.onCancelled(str);
            b bVar = b.this;
            bVar.w(3, bVar.i);
        }
    }

    /* renamed from: d.b.i0.v2.d.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1642b extends d.b.b.e.l.c<d.b.b.j.d.a> {

        /* renamed from: d.b.i0.v2.d.b$b$a */
        /* loaded from: classes5.dex */
        public class a extends BdAsyncTask<d.b.b.j.d.a, Void, Bitmap> {
            public a() {
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            /* renamed from: b */
            public Bitmap doInBackground(d.b.b.j.d.a... aVarArr) {
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

        public C1642b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.b.e.l.c
        public void onLoaded(d.b.b.j.d.a aVar, String str, int i) {
            super.onLoaded((C1642b) aVar, str, i);
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
        public d.b.i0.v2.e.b f62059a;

        public c(d.b.i0.v2.e.b bVar) {
            this.f62059a = bVar;
        }

        public final void a() {
            FileHelper.deleteFile(new File(d.b.i0.v2.d.a.f62048e + d.b.i0.v2.d.a.f62049f));
        }

        @Override // com.tencent.tauth.IUiListener
        public void onCancel() {
            d.b.i0.v2.e.b bVar = this.f62059a;
            if (bVar != null) {
                bVar.onShare(b.this.i, 3);
            }
            int i = b.this.i;
            a();
        }

        @Override // com.tencent.tauth.IUiListener
        public void onComplete(Object obj) {
            d.b.i0.v2.e.b bVar = this.f62059a;
            if (bVar != null) {
                bVar.onShare(b.this.i, 1);
            }
            b bVar2 = b.this;
            bVar2.w(1, bVar2.i);
            a();
        }

        @Override // com.tencent.tauth.IUiListener
        public void onError(UiError uiError) {
            d.b.i0.v2.e.b bVar = this.f62059a;
            if (bVar != null) {
                bVar.onShare(b.this.i, 2);
            }
            String str = uiError != null ? uiError.errorMessage : null;
            b bVar2 = b.this;
            bVar2.x(2, str, bVar2.i);
            a();
        }
    }

    public b(Context context) {
        super(context);
        this.i = 8;
        this.l = new a();
        this.m = new C1642b();
        this.f62055h = Tencent.createInstance("101462192", context.getApplicationContext());
    }

    public final void B(ShareEntity shareEntity, d.b.i0.v2.e.b bVar) {
        String str;
        if (shareEntity == null) {
            return;
        }
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("text/plain");
        Iterator<ResolveInfo> it = this.f62052b.getPackageManager().queryIntentActivities(intent, 0).iterator();
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
        intent2.setFlags(268435456);
        if (d.b.i0.v2.f.a.a(this.f62052b, intent2)) {
            if (bVar != null) {
                bVar.onShare(this.i, 1);
                return;
            }
            return;
        }
        if (bVar != null) {
            bVar.onShare(this.i, 2);
        }
        w(2, this.i);
    }

    public final void C(ShareEntity shareEntity, IUiListener iUiListener) {
        if (shareEntity == null || iUiListener == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("title", shareEntity.n());
        if (shareEntity.i() >= 0) {
            if (shareEntity.i() < 10000) {
                bundle.putString("summary", this.f62052b.getString(R.string.share_qq_default_content));
            } else {
                bundle.putString("summary", StringHelper.numberUniformFormatExtra(shareEntity.i()) + this.f62052b.getString(R.string.share_qq_content));
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
        this.f62055h.shareToQQ((Activity) this.f62052b, bundle, iUiListener);
    }

    public final void D(String str, IUiListener iUiListener) {
        if (TextUtils.isEmpty(str) || iUiListener == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("imageLocalUrl", str);
        bundle.putInt("req_type", 5);
        bundle.putInt("cflag", 2);
        this.f62055h.shareToQQ((Activity) this.f62052b, bundle, iUiListener);
    }

    @Override // d.b.i0.v2.e.a
    public void a(ShareEntity shareEntity, d.b.i0.v2.e.b bVar) {
        if (shareEntity != null && this.f62055h != null) {
            Context context = this.f62052b;
            if (context != null && (context instanceof Activity)) {
                this.j = new c(bVar);
                String e2 = shareEntity.e();
                if (n(shareEntity.h())) {
                    D(shareEntity.h(), this.j);
                    return;
                } else if (shareEntity.k() != 0 && !TextUtils.isEmpty(e2) && (e2.startsWith("http://") || e2.startsWith("https://"))) {
                    d.b.b.e.l.d.h().k(e2, 34, this.l, 0, 0, h(), new Object[0]);
                    return;
                } else if (!TextUtils.isEmpty(shareEntity.g()) && !TextUtils.isEmpty(shareEntity.n())) {
                    this.k = shareEntity;
                    if (shareEntity.f()) {
                        d.b.b.e.l.d.h().k(shareEntity.e(), 10, this.m, 0, 0, h(), new Object[0]);
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
            w(2, this.i);
            if (bVar != null) {
                bVar.onShare(0, 2);
                return;
            }
            return;
        }
        w(2, this.i);
        if (bVar != null) {
            bVar.onShare(0, 2);
        }
    }
}

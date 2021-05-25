package d.a.n0.x2.d;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.tbadk.core.util.resourceLoaderProc.EmotionShareLoaderProc;
import com.baidu.tieba.sharesdk.bean.ShareEntity;
import com.tencent.tauth.IUiListener;
import d.a.n0.x2.d.b;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class c extends b {
    public IUiListener n;
    public final d.a.c.e.l.c<EmotionShareLoaderProc.EmotionShare> o;

    /* loaded from: classes5.dex */
    public class a extends d.a.c.e.l.c<EmotionShareLoaderProc.EmotionShare> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.c.e.l.c
        /* renamed from: a */
        public void onLoaded(EmotionShareLoaderProc.EmotionShare emotionShare, String str, int i2) {
            super.onLoaded(emotionShare, str, i2);
            if (emotionShare == null || emotionShare.image == null || TextUtils.isEmpty(emotionShare.path)) {
                c.this.w(2, 4);
            }
            c.this.G(emotionShare.path);
        }

        @Override // d.a.c.e.l.c
        public void onCancelled(String str) {
            super.onCancelled(str);
            c.this.w(3, 4);
        }
    }

    public c(Context context) {
        super(context);
        this.o = new a();
        this.f63307i = 4;
    }

    public final void F(ShareEntity shareEntity) {
        Bundle bundle = new Bundle();
        bundle.putInt("req_type", 1);
        bundle.putString("title", shareEntity.n());
        bundle.putString("summary", shareEntity.b());
        bundle.putString("targetUrl", shareEntity.g());
        ArrayList<String> arrayList = new ArrayList<>();
        if (!TextUtils.isEmpty(shareEntity.e())) {
            arrayList.add(shareEntity.e());
        }
        bundle.putStringArrayList("imageUrl", arrayList);
        IUiListener iUiListener = this.n;
        if (iUiListener != null) {
            this.f63306h.shareToQzone((Activity) this.f63303b, bundle, iUiListener);
        }
    }

    public final void G(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("imageLocalUrl", str);
        bundle.putInt("req_type", 5);
        bundle.putInt("cflag", 1);
        IUiListener iUiListener = this.n;
        if (iUiListener != null) {
            this.f63306h.shareToQQ((Activity) this.f63303b, bundle, iUiListener);
        }
    }

    public final void H(ShareEntity shareEntity) {
        if (n(shareEntity.h())) {
            G(shareEntity.h());
        } else if (m(shareEntity.d())) {
            G(shareEntity.d().getPath());
        } else {
            d.a.c.e.l.d.h().k(shareEntity.e(), 34, this.o, 0, 0, h(), new Object[0]);
        }
    }

    @Override // d.a.n0.x2.d.b, d.a.n0.x2.e.a
    public void a(ShareEntity shareEntity, d.a.n0.x2.e.b bVar) {
        if (shareEntity != null && this.f63306h != null) {
            Context context = this.f63303b;
            if (context != null && (context instanceof Activity)) {
                this.n = new b.c(bVar);
                if (shareEntity.k() != 0) {
                    H(shareEntity);
                    return;
                } else {
                    F(shareEntity);
                    return;
                }
            }
            w(2, 4);
            if (bVar != null) {
                bVar.onShare(0, 2);
                return;
            }
            return;
        }
        w(2, 4);
        if (bVar != null) {
            bVar.onShare(0, 2);
        }
    }
}

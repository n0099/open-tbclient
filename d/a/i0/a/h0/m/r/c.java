package d.a.i0.a.h0.m.r;

import android.graphics.Bitmap;
import android.net.Uri;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.facebook.common.executors.UiThreadImmediateExecutorService;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import d.a.i0.a.j2.k;
import d.a.i0.a.j2.p.d;
import d.a.i0.a.q2.e;
import d.a.i0.a.v2.q0;
/* loaded from: classes2.dex */
public class c {

    /* loaded from: classes2.dex */
    public static class a extends BaseBitmapDataSubscriber {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f42244a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f42245b;

        public a(b bVar, int i2) {
            this.f42244a = bVar;
            this.f42245b = i2;
        }

        @Override // com.facebook.datasource.BaseDataSubscriber, com.facebook.datasource.DataSubscriber
        public void onCancellation(DataSource<CloseableReference<CloseableImage>> dataSource) {
            super.onCancellation(dataSource);
            c.b(this.f42245b, this.f42244a, "download icon fail: onCancellation");
        }

        @Override // com.facebook.datasource.BaseDataSubscriber
        public void onFailureImpl(DataSource<CloseableReference<CloseableImage>> dataSource) {
            c.b(this.f42245b, this.f42244a, "download icon fail: onFailureImpl");
        }

        @Override // com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber
        public void onNewResultImpl(Bitmap bitmap) {
            Bitmap copy;
            if (bitmap == null || bitmap.isRecycled()) {
                c.b(this.f42245b, this.f42244a, "download icon fail: bitmap is null or is recycled");
                return;
            }
            try {
                if (bitmap.getConfig() == null) {
                    copy = bitmap.copy(Bitmap.Config.ARGB_8888, true);
                } else {
                    copy = bitmap.copy(bitmap.getConfig(), true);
                }
                if (this.f42244a != null) {
                    this.f42244a.a(copy);
                }
            } catch (Exception e2) {
                int i2 = this.f42245b;
                b bVar = this.f42244a;
                c.b(i2, bVar, "download icon fail: " + e2.getMessage());
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface b {
        void a(Bitmap bitmap);
    }

    public static void b(int i2, b bVar, String str) {
        d.a.i0.a.q2.a aVar = new d.a.i0.a.q2.a();
        aVar.j(4L);
        aVar.h(10L);
        aVar.e(str);
        e.a().f(aVar);
        d dVar = new d();
        dVar.p(aVar);
        dVar.q(k.m(i2));
        k.L(dVar);
        if (bVar != null) {
            bVar.a(null);
        }
    }

    public static void c(String str, int i2, b bVar) {
        Uri C = q0.C(str);
        if (C == null) {
            b(i2, bVar, "download icon fail: icon url is null");
            return;
        }
        Fresco.getImagePipeline().fetchDecodedImage(ImageRequestBuilder.newBuilderWithSource(C).build(), AppRuntime.getAppContext()).subscribe(new a(bVar, i2), UiThreadImmediateExecutorService.getInstance());
    }
}

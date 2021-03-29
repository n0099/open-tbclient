package d.b.g0.a.e0.p.r;

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
import d.b.g0.a.f2.e;
import d.b.g0.a.i2.k0;
import d.b.g0.a.z1.h;
import d.b.g0.a.z1.k.d;
/* loaded from: classes2.dex */
public class c {

    /* loaded from: classes2.dex */
    public static class a extends BaseBitmapDataSubscriber {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f44235a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f44236b;

        public a(b bVar, int i) {
            this.f44235a = bVar;
            this.f44236b = i;
        }

        @Override // com.facebook.datasource.BaseDataSubscriber, com.facebook.datasource.DataSubscriber
        public void onCancellation(DataSource<CloseableReference<CloseableImage>> dataSource) {
            super.onCancellation(dataSource);
            c.b(this.f44236b, this.f44235a, "download icon fail: onCancellation");
        }

        @Override // com.facebook.datasource.BaseDataSubscriber
        public void onFailureImpl(DataSource<CloseableReference<CloseableImage>> dataSource) {
            c.b(this.f44236b, this.f44235a, "download icon fail: onFailureImpl");
        }

        @Override // com.facebook.imagepipeline.datasource.BaseBitmapDataSubscriber
        public void onNewResultImpl(Bitmap bitmap) {
            Bitmap copy;
            if (bitmap == null || bitmap.isRecycled()) {
                c.b(this.f44236b, this.f44235a, "download icon fail: bitmap is null or is recycled");
                return;
            }
            try {
                if (bitmap.getConfig() == null) {
                    copy = bitmap.copy(Bitmap.Config.ARGB_8888, true);
                } else {
                    copy = bitmap.copy(bitmap.getConfig(), true);
                }
                if (this.f44235a != null) {
                    this.f44235a.a(copy);
                }
            } catch (Exception e2) {
                int i = this.f44236b;
                b bVar = this.f44235a;
                c.b(i, bVar, "download icon fail: " + e2.getMessage());
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface b {
        void a(Bitmap bitmap);
    }

    public static void b(int i, b bVar, String str) {
        d.b.g0.a.f2.a aVar = new d.b.g0.a.f2.a();
        aVar.j(4L);
        aVar.h(10L);
        aVar.e(str);
        e.a().f(aVar);
        d dVar = new d();
        dVar.p(aVar);
        dVar.q(h.n(i));
        h.H(dVar);
        if (bVar != null) {
            bVar.a(null);
        }
    }

    public static void c(String str, int i, b bVar) {
        Uri y = k0.y(str);
        if (y == null) {
            b(i, bVar, "download icon fail: icon url is null");
            return;
        }
        Fresco.getImagePipeline().fetchDecodedImage(ImageRequestBuilder.newBuilderWithSource(y).build(), AppRuntime.getAppContext()).subscribe(new a(bVar, i), UiThreadImmediateExecutorService.getInstance());
    }
}

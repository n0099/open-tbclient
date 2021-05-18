package d.a.i0.a.h0.o.h.f;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.facebook.binaryresource.BinaryResource;
import com.facebook.binaryresource.FileBinaryResource;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.common.WriterCallbacks;
import com.facebook.datasource.DataSource;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.cache.DefaultCacheKeyFactory;
import com.facebook.imagepipeline.core.ImagePipeline;
import com.facebook.imagepipeline.core.ImagePipelineFactory;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes2.dex */
public class a implements d.a.i0.a.h0.o.h.c.a, d.a.i0.a.h0.o.h.e.a {

    /* renamed from: b  reason: collision with root package name */
    public d.a.i0.a.h0.o.h.f.b f42293b;

    /* renamed from: d.a.i0.a.h0.o.h.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0679a implements d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.a.h0.o.h.c.b f42294a;

        public C0679a(a aVar, d.a.i0.a.h0.o.h.c.b bVar) {
            this.f42294a = bVar;
        }

        @Override // d.a.i0.a.h0.o.h.f.d
        public void a(ImageRequest imageRequest) {
        }

        @Override // d.a.i0.a.h0.o.h.f.d
        public void b(ImageRequest imageRequest) {
            d.a.i0.a.h0.o.h.c.b bVar = this.f42294a;
            if (bVar != null) {
                bVar.a();
            }
        }

        @Override // d.a.i0.a.h0.o.h.f.d
        public void c(ImageRequest imageRequest, Throwable th) {
            d.a.i0.a.h0.o.h.c.b bVar = this.f42294a;
            if (bVar != null) {
                bVar.a();
            }
        }

        @Override // d.a.i0.a.h0.o.h.f.d
        public void onCancel(String str) {
            d.a.i0.a.h0.o.h.c.b bVar = this.f42294a;
            if (bVar != null) {
                bVar.a();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements d.a.i0.a.h0.o.h.f.b {
        public b(a aVar) {
        }

        @Override // d.a.i0.a.h0.o.h.f.b
        public CacheKey a(String str) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return DefaultCacheKeyFactory.getInstance().getEncodedCacheKey(ImageRequest.fromUri(Uri.parse(str)), null);
        }
    }

    /* loaded from: classes2.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public static a f42295a = new a(null);
    }

    public /* synthetic */ a(C0679a c0679a) {
        this();
    }

    public static a d() {
        return c.f42295a;
    }

    @Override // d.a.i0.a.h0.o.h.c.a
    public void a(String str, File file, d.a.i0.a.h0.o.h.c.b bVar) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        boolean z = false;
        if (file != null && file.exists()) {
            z = b(str, file);
        }
        if (z) {
            bVar.a();
        } else {
            e(str, new C0679a(this, bVar));
        }
    }

    public final boolean b(String str, File file) {
        FileInputStream fileInputStream;
        CacheKey a2 = this.f42293b.a(str);
        boolean z = false;
        FileInputStream fileInputStream2 = null;
        try {
            try {
                fileInputStream = new FileInputStream(file);
            } catch (Throwable th) {
                th = th;
            }
        } catch (IOException e2) {
            e = e2;
        }
        try {
            BinaryResource insert = Fresco.getImagePipelineFactory().getMainFileCache().insert(a2, WriterCallbacks.from(fileInputStream));
            if (insert != null) {
                if (insert.size() > 0) {
                    z = true;
                }
            }
            d.a.i0.t.d.d(fileInputStream);
            return z;
        } catch (IOException e3) {
            e = e3;
            fileInputStream2 = fileInputStream;
            if (d.a.i0.a.h0.o.h.e.a.f42292a) {
                Log.e("HybridIntercept", Log.getStackTraceString(e));
            }
            d.a.i0.t.d.d(fileInputStream2);
            return false;
        } catch (Throwable th2) {
            th = th2;
            fileInputStream2 = fileInputStream;
            d.a.i0.t.d.d(fileInputStream2);
            throw th;
        }
    }

    public final File c(String str) {
        BinaryResource resource;
        CacheKey a2 = this.f42293b.a(str);
        if (a2 == null) {
            return null;
        }
        if (ImagePipelineFactory.getInstance().getMainFileCache().hasKey(a2)) {
            BinaryResource resource2 = ImagePipelineFactory.getInstance().getMainFileCache().getResource(a2);
            if (resource2 != null) {
                return ((FileBinaryResource) resource2).getFile();
            }
            return null;
        } else if (!ImagePipelineFactory.getInstance().getSmallImageFileCache().hasKey(a2) || (resource = ImagePipelineFactory.getInstance().getSmallImageFileCache().getResource(a2)) == null) {
            return null;
        } else {
            return ((FileBinaryResource) resource).getFile();
        }
    }

    public final DataSource<Void> e(String str, d dVar) {
        if (TextUtils.isEmpty(str)) {
            if (dVar != null) {
                dVar.c(null, new Exception("url is empty"));
            }
            return null;
        }
        ImagePipeline imagePipeline = Fresco.getImagePipeline();
        ImageRequestBuilder newBuilderWithSource = ImageRequestBuilder.newBuilderWithSource(Uri.parse(str));
        if (dVar != null) {
            newBuilderWithSource.setRequestListener(d.a.i0.a.c1.a.x().a(dVar));
        }
        return imagePipeline.prefetchToDiskCache(newBuilderWithSource.build(), null);
    }

    @Override // d.a.i0.a.h0.o.h.c.a
    public InputStream get(String str) {
        File c2 = c(str);
        if (c2 == null || !c2.exists()) {
            return null;
        }
        try {
            return new FileInputStream(c2);
        } catch (IOException e2) {
            if (d.a.i0.a.h0.o.h.e.a.f42292a) {
                Log.e("HybridIntercept", Log.getStackTraceString(e2));
                return null;
            }
            return null;
        }
    }

    @Override // d.a.i0.a.h0.o.h.c.a
    public boolean isClosed() {
        return false;
    }

    public a() {
        this.f42293b = new b(this);
    }
}

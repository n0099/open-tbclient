package com.facebook.imagepipeline.request;

import android.net.Uri;
import com.facebook.common.internal.g;
import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.common.e;
import com.facebook.imagepipeline.d.h;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.Map;
import javax.annotation.Nullable;
/* loaded from: classes12.dex */
public class ImageRequestBuilder {
    @Nullable
    private com.facebook.imagepipeline.h.c lSf;
    private Uri lXr = null;
    private ImageRequest.RequestLevel lVp = ImageRequest.RequestLevel.FULL_FETCH;
    @Nullable
    private com.facebook.imagepipeline.common.d lQL = null;
    @Nullable
    private e lQM = null;
    private com.facebook.imagepipeline.common.b lQN = com.facebook.imagepipeline.common.b.don();
    private ImageRequest.CacheChoice lXq = ImageRequest.CacheChoice.DEFAULT;
    private boolean lSO = h.doP().dpj();
    private boolean lXu = false;
    private Priority lXv = Priority.HIGH;
    @Nullable
    private b lWI = null;
    private boolean lSJ = true;
    private boolean lXz = true;
    @Nullable
    private com.facebook.imagepipeline.common.a lUg = null;
    private Map<String, String> lXx = null;
    private String mTag = null;
    private String lXy = null;

    public static ImageRequestBuilder Y(Uri uri) {
        return new ImageRequestBuilder().Z(uri);
    }

    public static ImageRequestBuilder IQ(int i) {
        return Y(com.facebook.common.util.d.Hv(i));
    }

    public static ImageRequestBuilder p(ImageRequest imageRequest) {
        return Y(imageRequest.dsr()).a(imageRequest.dsv()).d(imageRequest.dqB()).a(imageRequest.dsq()).vw(imageRequest.dsx()).a(imageRequest.drA()).a(imageRequest.dsA()).vv(imageRequest.dsw()).b(imageRequest.drC()).c(imageRequest.dst()).c(imageRequest.dlF()).a(imageRequest.dsu()).c(imageRequest.dlF()).z(imageRequest.drP()).Pj(imageRequest.mTag).Pk(imageRequest.lXy);
    }

    private ImageRequestBuilder() {
    }

    public Map<String, String> drP() {
        return this.lXx;
    }

    public ImageRequestBuilder z(Map<String, String> map) {
        this.lXx = map;
        return this;
    }

    public String getTag() {
        return this.mTag;
    }

    public ImageRequestBuilder Pj(String str) {
        this.mTag = str;
        return this;
    }

    public String getLogTag() {
        return this.lXy;
    }

    public ImageRequestBuilder Pk(String str) {
        this.lXy = str;
        return this;
    }

    public ImageRequestBuilder Z(Uri uri) {
        g.checkNotNull(uri);
        this.lXr = uri;
        return this;
    }

    public Uri dsr() {
        return this.lXr;
    }

    public ImageRequestBuilder a(ImageRequest.RequestLevel requestLevel) {
        this.lVp = requestLevel;
        return this;
    }

    public ImageRequest.RequestLevel drA() {
        return this.lVp;
    }

    public ImageRequestBuilder c(@Nullable com.facebook.imagepipeline.common.d dVar) {
        this.lQL = dVar;
        return this;
    }

    @Nullable
    public com.facebook.imagepipeline.common.d dst() {
        return this.lQL;
    }

    public ImageRequestBuilder a(@Nullable e eVar) {
        this.lQM = eVar;
        return this;
    }

    @Nullable
    public e dsu() {
        return this.lQM;
    }

    public ImageRequestBuilder d(@Nullable com.facebook.imagepipeline.common.a aVar) {
        this.lUg = aVar;
        return this;
    }

    @Nullable
    public com.facebook.imagepipeline.common.a dqB() {
        return this.lUg;
    }

    public ImageRequestBuilder a(com.facebook.imagepipeline.common.b bVar) {
        this.lQN = bVar;
        return this;
    }

    public com.facebook.imagepipeline.common.b dsv() {
        return this.lQN;
    }

    public ImageRequestBuilder a(ImageRequest.CacheChoice cacheChoice) {
        this.lXq = cacheChoice;
        return this;
    }

    public ImageRequest.CacheChoice dsq() {
        return this.lXq;
    }

    public ImageRequestBuilder vv(boolean z) {
        this.lSO = z;
        return this;
    }

    public boolean dpj() {
        return this.lSO;
    }

    public ImageRequestBuilder vw(boolean z) {
        this.lXu = z;
        return this;
    }

    public boolean dsB() {
        return this.lXu;
    }

    public boolean doS() {
        return this.lSJ && com.facebook.common.util.d.C(this.lXr);
    }

    public boolean dsy() {
        return this.lXz;
    }

    public ImageRequestBuilder b(Priority priority) {
        this.lXv = priority;
        return this;
    }

    public Priority dsC() {
        return this.lXv;
    }

    public ImageRequestBuilder a(b bVar) {
        this.lWI = bVar;
        return this;
    }

    @Nullable
    public b dsA() {
        return this.lWI;
    }

    public ImageRequestBuilder c(com.facebook.imagepipeline.h.c cVar) {
        this.lSf = cVar;
        return this;
    }

    @Nullable
    public com.facebook.imagepipeline.h.c dlF() {
        return this.lSf;
    }

    public ImageRequest dsD() {
        validate();
        return new ImageRequest(this);
    }

    /* loaded from: classes12.dex */
    public static class BuilderException extends RuntimeException {
        public BuilderException(String str) {
            super("Invalid request builder: " + str);
        }
    }

    protected void validate() {
        if (this.lXr == null) {
            throw new BuilderException("Source must be set!");
        }
        if (com.facebook.common.util.d.G(this.lXr)) {
            if (!this.lXr.isAbsolute()) {
                throw new BuilderException("Resource URI path must be absolute.");
            }
            if (this.lXr.getPath().isEmpty()) {
                throw new BuilderException("Resource URI must not be empty");
            }
            try {
                Integer.parseInt(this.lXr.getPath().substring(1));
            } catch (NumberFormatException e) {
                throw new BuilderException("Resource URI path must be a resource id.");
            }
        }
        if (com.facebook.common.util.d.F(this.lXr) && !this.lXr.isAbsolute()) {
            throw new BuilderException("Asset URI path must be absolute.");
        }
    }
}

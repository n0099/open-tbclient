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
    private com.facebook.imagepipeline.h.c lRU;
    private Uri lXg = null;
    private ImageRequest.RequestLevel lVe = ImageRequest.RequestLevel.FULL_FETCH;
    @Nullable
    private com.facebook.imagepipeline.common.d lQA = null;
    @Nullable
    private e lQB = null;
    private com.facebook.imagepipeline.common.b lQC = com.facebook.imagepipeline.common.b.dom();
    private ImageRequest.CacheChoice lXf = ImageRequest.CacheChoice.DEFAULT;
    private boolean lSD = h.doO().dpi();
    private boolean lXj = false;
    private Priority lXk = Priority.HIGH;
    @Nullable
    private b lWx = null;
    private boolean lSy = true;
    private boolean lXo = true;
    @Nullable
    private com.facebook.imagepipeline.common.a lTV = null;
    private Map<String, String> lXm = null;
    private String mTag = null;
    private String lXn = null;

    public static ImageRequestBuilder Y(Uri uri) {
        return new ImageRequestBuilder().Z(uri);
    }

    public static ImageRequestBuilder IQ(int i) {
        return Y(com.facebook.common.util.d.Hv(i));
    }

    public static ImageRequestBuilder p(ImageRequest imageRequest) {
        return Y(imageRequest.dsq()).a(imageRequest.dsu()).d(imageRequest.dqA()).a(imageRequest.dsp()).vw(imageRequest.dsw()).a(imageRequest.drz()).a(imageRequest.dsz()).vv(imageRequest.dsv()).b(imageRequest.drB()).c(imageRequest.dss()).c(imageRequest.dlE()).a(imageRequest.dst()).c(imageRequest.dlE()).z(imageRequest.drO()).Pi(imageRequest.mTag).Pj(imageRequest.lXn);
    }

    private ImageRequestBuilder() {
    }

    public Map<String, String> drO() {
        return this.lXm;
    }

    public ImageRequestBuilder z(Map<String, String> map) {
        this.lXm = map;
        return this;
    }

    public String getTag() {
        return this.mTag;
    }

    public ImageRequestBuilder Pi(String str) {
        this.mTag = str;
        return this;
    }

    public String getLogTag() {
        return this.lXn;
    }

    public ImageRequestBuilder Pj(String str) {
        this.lXn = str;
        return this;
    }

    public ImageRequestBuilder Z(Uri uri) {
        g.checkNotNull(uri);
        this.lXg = uri;
        return this;
    }

    public Uri dsq() {
        return this.lXg;
    }

    public ImageRequestBuilder a(ImageRequest.RequestLevel requestLevel) {
        this.lVe = requestLevel;
        return this;
    }

    public ImageRequest.RequestLevel drz() {
        return this.lVe;
    }

    public ImageRequestBuilder c(@Nullable com.facebook.imagepipeline.common.d dVar) {
        this.lQA = dVar;
        return this;
    }

    @Nullable
    public com.facebook.imagepipeline.common.d dss() {
        return this.lQA;
    }

    public ImageRequestBuilder a(@Nullable e eVar) {
        this.lQB = eVar;
        return this;
    }

    @Nullable
    public e dst() {
        return this.lQB;
    }

    public ImageRequestBuilder d(@Nullable com.facebook.imagepipeline.common.a aVar) {
        this.lTV = aVar;
        return this;
    }

    @Nullable
    public com.facebook.imagepipeline.common.a dqA() {
        return this.lTV;
    }

    public ImageRequestBuilder a(com.facebook.imagepipeline.common.b bVar) {
        this.lQC = bVar;
        return this;
    }

    public com.facebook.imagepipeline.common.b dsu() {
        return this.lQC;
    }

    public ImageRequestBuilder a(ImageRequest.CacheChoice cacheChoice) {
        this.lXf = cacheChoice;
        return this;
    }

    public ImageRequest.CacheChoice dsp() {
        return this.lXf;
    }

    public ImageRequestBuilder vv(boolean z) {
        this.lSD = z;
        return this;
    }

    public boolean dpi() {
        return this.lSD;
    }

    public ImageRequestBuilder vw(boolean z) {
        this.lXj = z;
        return this;
    }

    public boolean dsA() {
        return this.lXj;
    }

    public boolean doR() {
        return this.lSy && com.facebook.common.util.d.C(this.lXg);
    }

    public boolean dsx() {
        return this.lXo;
    }

    public ImageRequestBuilder b(Priority priority) {
        this.lXk = priority;
        return this;
    }

    public Priority dsB() {
        return this.lXk;
    }

    public ImageRequestBuilder a(b bVar) {
        this.lWx = bVar;
        return this;
    }

    @Nullable
    public b dsz() {
        return this.lWx;
    }

    public ImageRequestBuilder c(com.facebook.imagepipeline.h.c cVar) {
        this.lRU = cVar;
        return this;
    }

    @Nullable
    public com.facebook.imagepipeline.h.c dlE() {
        return this.lRU;
    }

    public ImageRequest dsC() {
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
        if (this.lXg == null) {
            throw new BuilderException("Source must be set!");
        }
        if (com.facebook.common.util.d.G(this.lXg)) {
            if (!this.lXg.isAbsolute()) {
                throw new BuilderException("Resource URI path must be absolute.");
            }
            if (this.lXg.getPath().isEmpty()) {
                throw new BuilderException("Resource URI must not be empty");
            }
            try {
                Integer.parseInt(this.lXg.getPath().substring(1));
            } catch (NumberFormatException e) {
                throw new BuilderException("Resource URI path must be a resource id.");
            }
        }
        if (com.facebook.common.util.d.F(this.lXg) && !this.lXg.isAbsolute()) {
            throw new BuilderException("Asset URI path must be absolute.");
        }
    }
}

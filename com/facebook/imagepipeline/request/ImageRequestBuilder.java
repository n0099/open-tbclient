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
    private com.facebook.imagepipeline.h.c lRS;
    private Uri lXe = null;
    private ImageRequest.RequestLevel lVc = ImageRequest.RequestLevel.FULL_FETCH;
    @Nullable
    private com.facebook.imagepipeline.common.d lQy = null;
    @Nullable
    private e lQz = null;
    private com.facebook.imagepipeline.common.b lQA = com.facebook.imagepipeline.common.b.dok();
    private ImageRequest.CacheChoice lXd = ImageRequest.CacheChoice.DEFAULT;
    private boolean lSB = h.doM().dpg();
    private boolean lXh = false;
    private Priority lXi = Priority.HIGH;
    @Nullable
    private b lWv = null;
    private boolean lSw = true;
    private boolean lXm = true;
    @Nullable
    private com.facebook.imagepipeline.common.a lTT = null;
    private Map<String, String> lXk = null;
    private String mTag = null;
    private String lXl = null;

    public static ImageRequestBuilder Y(Uri uri) {
        return new ImageRequestBuilder().Z(uri);
    }

    public static ImageRequestBuilder IQ(int i) {
        return Y(com.facebook.common.util.d.Hv(i));
    }

    public static ImageRequestBuilder p(ImageRequest imageRequest) {
        return Y(imageRequest.dso()).a(imageRequest.dss()).d(imageRequest.dqy()).a(imageRequest.dsn()).vw(imageRequest.dsu()).a(imageRequest.drx()).a(imageRequest.dsx()).vv(imageRequest.dst()).b(imageRequest.drz()).c(imageRequest.dsq()).c(imageRequest.dlC()).a(imageRequest.dsr()).c(imageRequest.dlC()).z(imageRequest.drM()).Pi(imageRequest.mTag).Pj(imageRequest.lXl);
    }

    private ImageRequestBuilder() {
    }

    public Map<String, String> drM() {
        return this.lXk;
    }

    public ImageRequestBuilder z(Map<String, String> map) {
        this.lXk = map;
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
        return this.lXl;
    }

    public ImageRequestBuilder Pj(String str) {
        this.lXl = str;
        return this;
    }

    public ImageRequestBuilder Z(Uri uri) {
        g.checkNotNull(uri);
        this.lXe = uri;
        return this;
    }

    public Uri dso() {
        return this.lXe;
    }

    public ImageRequestBuilder a(ImageRequest.RequestLevel requestLevel) {
        this.lVc = requestLevel;
        return this;
    }

    public ImageRequest.RequestLevel drx() {
        return this.lVc;
    }

    public ImageRequestBuilder c(@Nullable com.facebook.imagepipeline.common.d dVar) {
        this.lQy = dVar;
        return this;
    }

    @Nullable
    public com.facebook.imagepipeline.common.d dsq() {
        return this.lQy;
    }

    public ImageRequestBuilder a(@Nullable e eVar) {
        this.lQz = eVar;
        return this;
    }

    @Nullable
    public e dsr() {
        return this.lQz;
    }

    public ImageRequestBuilder d(@Nullable com.facebook.imagepipeline.common.a aVar) {
        this.lTT = aVar;
        return this;
    }

    @Nullable
    public com.facebook.imagepipeline.common.a dqy() {
        return this.lTT;
    }

    public ImageRequestBuilder a(com.facebook.imagepipeline.common.b bVar) {
        this.lQA = bVar;
        return this;
    }

    public com.facebook.imagepipeline.common.b dss() {
        return this.lQA;
    }

    public ImageRequestBuilder a(ImageRequest.CacheChoice cacheChoice) {
        this.lXd = cacheChoice;
        return this;
    }

    public ImageRequest.CacheChoice dsn() {
        return this.lXd;
    }

    public ImageRequestBuilder vv(boolean z) {
        this.lSB = z;
        return this;
    }

    public boolean dpg() {
        return this.lSB;
    }

    public ImageRequestBuilder vw(boolean z) {
        this.lXh = z;
        return this;
    }

    public boolean dsy() {
        return this.lXh;
    }

    public boolean doP() {
        return this.lSw && com.facebook.common.util.d.C(this.lXe);
    }

    public boolean dsv() {
        return this.lXm;
    }

    public ImageRequestBuilder b(Priority priority) {
        this.lXi = priority;
        return this;
    }

    public Priority dsz() {
        return this.lXi;
    }

    public ImageRequestBuilder a(b bVar) {
        this.lWv = bVar;
        return this;
    }

    @Nullable
    public b dsx() {
        return this.lWv;
    }

    public ImageRequestBuilder c(com.facebook.imagepipeline.h.c cVar) {
        this.lRS = cVar;
        return this;
    }

    @Nullable
    public com.facebook.imagepipeline.h.c dlC() {
        return this.lRS;
    }

    public ImageRequest dsA() {
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
        if (this.lXe == null) {
            throw new BuilderException("Source must be set!");
        }
        if (com.facebook.common.util.d.G(this.lXe)) {
            if (!this.lXe.isAbsolute()) {
                throw new BuilderException("Resource URI path must be absolute.");
            }
            if (this.lXe.getPath().isEmpty()) {
                throw new BuilderException("Resource URI must not be empty");
            }
            try {
                Integer.parseInt(this.lXe.getPath().substring(1));
            } catch (NumberFormatException e) {
                throw new BuilderException("Resource URI path must be a resource id.");
            }
        }
        if (com.facebook.common.util.d.F(this.lXe) && !this.lXe.isAbsolute()) {
            throw new BuilderException("Asset URI path must be absolute.");
        }
    }
}

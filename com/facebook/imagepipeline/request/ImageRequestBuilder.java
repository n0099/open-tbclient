package com.facebook.imagepipeline.request;

import android.net.Uri;
import com.facebook.common.internal.g;
import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.common.e;
import com.facebook.imagepipeline.d.h;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.Map;
import javax.annotation.Nullable;
/* loaded from: classes10.dex */
public class ImageRequestBuilder {
    @Nullable
    private com.facebook.imagepipeline.h.c lRg;
    private Uri lWs = null;
    private ImageRequest.RequestLevel lUq = ImageRequest.RequestLevel.FULL_FETCH;
    @Nullable
    private com.facebook.imagepipeline.common.d lPM = null;
    @Nullable
    private e lPN = null;
    private com.facebook.imagepipeline.common.b lPO = com.facebook.imagepipeline.common.b.dmV();
    private ImageRequest.CacheChoice lWr = ImageRequest.CacheChoice.DEFAULT;
    private boolean lRP = h.dny().dnS();
    private boolean lWv = false;
    private Priority lWw = Priority.HIGH;
    @Nullable
    private b lVJ = null;
    private boolean lRK = true;
    private boolean lWA = true;
    @Nullable
    private com.facebook.imagepipeline.common.a lTh = null;
    private Map<String, String> lWy = null;
    private String mTag = null;
    private String lWz = null;

    public static ImageRequestBuilder X(Uri uri) {
        return new ImageRequestBuilder().Y(uri);
    }

    public static ImageRequestBuilder IL(int i) {
        return X(com.facebook.common.util.d.Hq(i));
    }

    public static ImageRequestBuilder p(ImageRequest imageRequest) {
        return X(imageRequest.dra()).a(imageRequest.dre()).d(imageRequest.dpk()).a(imageRequest.dqZ()).vs(imageRequest.drg()).a(imageRequest.dqj()).a(imageRequest.drj()).vr(imageRequest.drf()).b(imageRequest.dql()).c(imageRequest.drc()).c(imageRequest.dkn()).a(imageRequest.drd()).c(imageRequest.dkn()).z(imageRequest.dqy()).OV(imageRequest.mTag).OW(imageRequest.lWz);
    }

    private ImageRequestBuilder() {
    }

    public Map<String, String> dqy() {
        return this.lWy;
    }

    public ImageRequestBuilder z(Map<String, String> map) {
        this.lWy = map;
        return this;
    }

    public String getTag() {
        return this.mTag;
    }

    public ImageRequestBuilder OV(String str) {
        this.mTag = str;
        return this;
    }

    public String alk() {
        return this.lWz;
    }

    public ImageRequestBuilder OW(String str) {
        this.lWz = str;
        return this;
    }

    public ImageRequestBuilder Y(Uri uri) {
        g.checkNotNull(uri);
        this.lWs = uri;
        return this;
    }

    public Uri dra() {
        return this.lWs;
    }

    public ImageRequestBuilder a(ImageRequest.RequestLevel requestLevel) {
        this.lUq = requestLevel;
        return this;
    }

    public ImageRequest.RequestLevel dqj() {
        return this.lUq;
    }

    public ImageRequestBuilder c(@Nullable com.facebook.imagepipeline.common.d dVar) {
        this.lPM = dVar;
        return this;
    }

    @Nullable
    public com.facebook.imagepipeline.common.d drc() {
        return this.lPM;
    }

    public ImageRequestBuilder a(@Nullable e eVar) {
        this.lPN = eVar;
        return this;
    }

    @Nullable
    public e drd() {
        return this.lPN;
    }

    public ImageRequestBuilder d(@Nullable com.facebook.imagepipeline.common.a aVar) {
        this.lTh = aVar;
        return this;
    }

    @Nullable
    public com.facebook.imagepipeline.common.a dpk() {
        return this.lTh;
    }

    public ImageRequestBuilder a(com.facebook.imagepipeline.common.b bVar) {
        this.lPO = bVar;
        return this;
    }

    public com.facebook.imagepipeline.common.b dre() {
        return this.lPO;
    }

    public ImageRequestBuilder a(ImageRequest.CacheChoice cacheChoice) {
        this.lWr = cacheChoice;
        return this;
    }

    public ImageRequest.CacheChoice dqZ() {
        return this.lWr;
    }

    public ImageRequestBuilder vr(boolean z) {
        this.lRP = z;
        return this;
    }

    public boolean dnS() {
        return this.lRP;
    }

    public ImageRequestBuilder vs(boolean z) {
        this.lWv = z;
        return this;
    }

    public boolean drk() {
        return this.lWv;
    }

    public boolean dnB() {
        return this.lRK && com.facebook.common.util.d.B(this.lWs);
    }

    public boolean drh() {
        return this.lWA;
    }

    public ImageRequestBuilder b(Priority priority) {
        this.lWw = priority;
        return this;
    }

    public Priority drl() {
        return this.lWw;
    }

    public ImageRequestBuilder a(b bVar) {
        this.lVJ = bVar;
        return this;
    }

    @Nullable
    public b drj() {
        return this.lVJ;
    }

    public ImageRequestBuilder c(com.facebook.imagepipeline.h.c cVar) {
        this.lRg = cVar;
        return this;
    }

    @Nullable
    public com.facebook.imagepipeline.h.c dkn() {
        return this.lRg;
    }

    public ImageRequest drm() {
        validate();
        return new ImageRequest(this);
    }

    /* loaded from: classes10.dex */
    public static class BuilderException extends RuntimeException {
        public BuilderException(String str) {
            super("Invalid request builder: " + str);
        }
    }

    protected void validate() {
        if (this.lWs == null) {
            throw new BuilderException("Source must be set!");
        }
        if (com.facebook.common.util.d.F(this.lWs)) {
            if (!this.lWs.isAbsolute()) {
                throw new BuilderException("Resource URI path must be absolute.");
            }
            if (this.lWs.getPath().isEmpty()) {
                throw new BuilderException("Resource URI must not be empty");
            }
            try {
                Integer.parseInt(this.lWs.getPath().substring(1));
            } catch (NumberFormatException e) {
                throw new BuilderException("Resource URI path must be a resource id.");
            }
        }
        if (com.facebook.common.util.d.E(this.lWs) && !this.lWs.isAbsolute()) {
            throw new BuilderException("Asset URI path must be absolute.");
        }
    }
}

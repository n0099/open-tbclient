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
    private com.facebook.imagepipeline.h.c lRl;
    private Uri lWx = null;
    private ImageRequest.RequestLevel lUv = ImageRequest.RequestLevel.FULL_FETCH;
    @Nullable
    private com.facebook.imagepipeline.common.d lPR = null;
    @Nullable
    private e lPS = null;
    private com.facebook.imagepipeline.common.b lPT = com.facebook.imagepipeline.common.b.dmX();
    private ImageRequest.CacheChoice lWw = ImageRequest.CacheChoice.DEFAULT;
    private boolean lRU = h.dnA().dnU();
    private boolean lWA = false;
    private Priority lWB = Priority.HIGH;
    @Nullable
    private b lVO = null;
    private boolean lRP = true;
    private boolean lWF = true;
    @Nullable
    private com.facebook.imagepipeline.common.a lTm = null;
    private Map<String, String> lWD = null;
    private String mTag = null;
    private String lWE = null;

    public static ImageRequestBuilder X(Uri uri) {
        return new ImageRequestBuilder().Y(uri);
    }

    public static ImageRequestBuilder IL(int i) {
        return X(com.facebook.common.util.d.Hq(i));
    }

    public static ImageRequestBuilder p(ImageRequest imageRequest) {
        return X(imageRequest.drc()).a(imageRequest.drg()).d(imageRequest.dpm()).a(imageRequest.drb()).vs(imageRequest.dri()).a(imageRequest.dql()).a(imageRequest.drl()).vr(imageRequest.drh()).b(imageRequest.dqn()).c(imageRequest.dre()).c(imageRequest.dkp()).a(imageRequest.drf()).c(imageRequest.dkp()).z(imageRequest.dqA()).OV(imageRequest.mTag).OW(imageRequest.lWE);
    }

    private ImageRequestBuilder() {
    }

    public Map<String, String> dqA() {
        return this.lWD;
    }

    public ImageRequestBuilder z(Map<String, String> map) {
        this.lWD = map;
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
        return this.lWE;
    }

    public ImageRequestBuilder OW(String str) {
        this.lWE = str;
        return this;
    }

    public ImageRequestBuilder Y(Uri uri) {
        g.checkNotNull(uri);
        this.lWx = uri;
        return this;
    }

    public Uri drc() {
        return this.lWx;
    }

    public ImageRequestBuilder a(ImageRequest.RequestLevel requestLevel) {
        this.lUv = requestLevel;
        return this;
    }

    public ImageRequest.RequestLevel dql() {
        return this.lUv;
    }

    public ImageRequestBuilder c(@Nullable com.facebook.imagepipeline.common.d dVar) {
        this.lPR = dVar;
        return this;
    }

    @Nullable
    public com.facebook.imagepipeline.common.d dre() {
        return this.lPR;
    }

    public ImageRequestBuilder a(@Nullable e eVar) {
        this.lPS = eVar;
        return this;
    }

    @Nullable
    public e drf() {
        return this.lPS;
    }

    public ImageRequestBuilder d(@Nullable com.facebook.imagepipeline.common.a aVar) {
        this.lTm = aVar;
        return this;
    }

    @Nullable
    public com.facebook.imagepipeline.common.a dpm() {
        return this.lTm;
    }

    public ImageRequestBuilder a(com.facebook.imagepipeline.common.b bVar) {
        this.lPT = bVar;
        return this;
    }

    public com.facebook.imagepipeline.common.b drg() {
        return this.lPT;
    }

    public ImageRequestBuilder a(ImageRequest.CacheChoice cacheChoice) {
        this.lWw = cacheChoice;
        return this;
    }

    public ImageRequest.CacheChoice drb() {
        return this.lWw;
    }

    public ImageRequestBuilder vr(boolean z) {
        this.lRU = z;
        return this;
    }

    public boolean dnU() {
        return this.lRU;
    }

    public ImageRequestBuilder vs(boolean z) {
        this.lWA = z;
        return this;
    }

    public boolean drm() {
        return this.lWA;
    }

    public boolean dnD() {
        return this.lRP && com.facebook.common.util.d.B(this.lWx);
    }

    public boolean drj() {
        return this.lWF;
    }

    public ImageRequestBuilder b(Priority priority) {
        this.lWB = priority;
        return this;
    }

    public Priority drn() {
        return this.lWB;
    }

    public ImageRequestBuilder a(b bVar) {
        this.lVO = bVar;
        return this;
    }

    @Nullable
    public b drl() {
        return this.lVO;
    }

    public ImageRequestBuilder c(com.facebook.imagepipeline.h.c cVar) {
        this.lRl = cVar;
        return this;
    }

    @Nullable
    public com.facebook.imagepipeline.h.c dkp() {
        return this.lRl;
    }

    public ImageRequest dro() {
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
        if (this.lWx == null) {
            throw new BuilderException("Source must be set!");
        }
        if (com.facebook.common.util.d.F(this.lWx)) {
            if (!this.lWx.isAbsolute()) {
                throw new BuilderException("Resource URI path must be absolute.");
            }
            if (this.lWx.getPath().isEmpty()) {
                throw new BuilderException("Resource URI must not be empty");
            }
            try {
                Integer.parseInt(this.lWx.getPath().substring(1));
            } catch (NumberFormatException e) {
                throw new BuilderException("Resource URI path must be a resource id.");
            }
        }
        if (com.facebook.common.util.d.E(this.lWx) && !this.lWx.isAbsolute()) {
            throw new BuilderException("Asset URI path must be absolute.");
        }
    }
}

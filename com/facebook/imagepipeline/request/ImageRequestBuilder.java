package com.facebook.imagepipeline.request;

import android.net.Uri;
import com.facebook.common.internal.g;
import com.facebook.imagepipeline.c.h;
import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.common.e;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.Map;
import javax.annotation.Nullable;
/* loaded from: classes5.dex */
public class ImageRequestBuilder {
    @Nullable
    private com.facebook.imagepipeline.g.c pKO;
    private Uri pPZ = null;
    private ImageRequest.RequestLevel pNW = ImageRequest.RequestLevel.FULL_FETCH;
    @Nullable
    private com.facebook.imagepipeline.common.d pJx = null;
    @Nullable
    private e pJy = null;
    private com.facebook.imagepipeline.common.b pJz = com.facebook.imagepipeline.common.b.ewt();
    private ImageRequest.CacheChoice pPY = ImageRequest.CacheChoice.DEFAULT;
    private boolean pLx = h.ewU().exo();
    private boolean pQb = false;
    private Priority pQc = Priority.HIGH;
    @Nullable
    private b pPq = null;
    private boolean pLs = true;
    private boolean pQg = true;
    @Nullable
    private com.facebook.imagepipeline.common.a pMN = null;
    private Map<String, String> pQe = null;
    private String mTag = null;
    private String pQf = null;

    public static ImageRequestBuilder ag(Uri uri) {
        return new ImageRequestBuilder().ah(uri);
    }

    public static ImageRequestBuilder Qu(int i) {
        return ag(com.facebook.common.util.d.Pb(i));
    }

    public static ImageRequestBuilder o(ImageRequest imageRequest) {
        return ag(imageRequest.eAo()).a(imageRequest.eAs()).c(imageRequest.eyG()).a(imageRequest.eAn()).Bw(imageRequest.eAu()).a(imageRequest.ezA()).a(imageRequest.eAw()).Bv(imageRequest.eAt()).b(imageRequest.ezC()).c(imageRequest.eAq()).c(imageRequest.etL()).a(imageRequest.eAr()).c(imageRequest.etL()).P(imageRequest.eAm()).ZS(imageRequest.mTag).ZT(imageRequest.pQf);
    }

    private ImageRequestBuilder() {
    }

    public Map<String, String> eAm() {
        return this.pQe;
    }

    public ImageRequestBuilder P(Map<String, String> map) {
        this.pQe = map;
        return this;
    }

    public String getTag() {
        return this.mTag;
    }

    public ImageRequestBuilder ZS(String str) {
        this.mTag = str;
        return this;
    }

    public String getLogTag() {
        return this.pQf;
    }

    public ImageRequestBuilder ZT(String str) {
        this.pQf = str;
        return this;
    }

    public ImageRequestBuilder ah(Uri uri) {
        g.checkNotNull(uri);
        this.pPZ = uri;
        return this;
    }

    public Uri eAo() {
        return this.pPZ;
    }

    public ImageRequestBuilder a(ImageRequest.RequestLevel requestLevel) {
        this.pNW = requestLevel;
        return this;
    }

    public ImageRequest.RequestLevel ezA() {
        return this.pNW;
    }

    public ImageRequestBuilder c(@Nullable com.facebook.imagepipeline.common.d dVar) {
        this.pJx = dVar;
        return this;
    }

    @Nullable
    public com.facebook.imagepipeline.common.d eAq() {
        return this.pJx;
    }

    public ImageRequestBuilder a(@Nullable e eVar) {
        this.pJy = eVar;
        return this;
    }

    @Nullable
    public e eAr() {
        return this.pJy;
    }

    public ImageRequestBuilder c(@Nullable com.facebook.imagepipeline.common.a aVar) {
        this.pMN = aVar;
        return this;
    }

    @Nullable
    public com.facebook.imagepipeline.common.a eyG() {
        return this.pMN;
    }

    public ImageRequestBuilder a(com.facebook.imagepipeline.common.b bVar) {
        this.pJz = bVar;
        return this;
    }

    public com.facebook.imagepipeline.common.b eAs() {
        return this.pJz;
    }

    public ImageRequestBuilder a(ImageRequest.CacheChoice cacheChoice) {
        this.pPY = cacheChoice;
        return this;
    }

    public ImageRequest.CacheChoice eAn() {
        return this.pPY;
    }

    public ImageRequestBuilder Bv(boolean z) {
        this.pLx = z;
        return this;
    }

    public boolean exo() {
        return this.pLx;
    }

    public ImageRequestBuilder Bw(boolean z) {
        this.pQb = z;
        return this;
    }

    public boolean eAx() {
        return this.pQb;
    }

    public boolean ewX() {
        return this.pLs && com.facebook.common.util.d.K(this.pPZ);
    }

    public boolean eAv() {
        return this.pQg;
    }

    public ImageRequestBuilder b(Priority priority) {
        this.pQc = priority;
        return this;
    }

    public Priority eAy() {
        return this.pQc;
    }

    public ImageRequestBuilder a(b bVar) {
        this.pPq = bVar;
        return this;
    }

    @Nullable
    public b eAw() {
        return this.pPq;
    }

    public ImageRequestBuilder c(com.facebook.imagepipeline.g.c cVar) {
        this.pKO = cVar;
        return this;
    }

    @Nullable
    public com.facebook.imagepipeline.g.c etL() {
        return this.pKO;
    }

    public ImageRequest eAz() {
        validate();
        return new ImageRequest(this);
    }

    /* loaded from: classes5.dex */
    public static class BuilderException extends RuntimeException {
        public BuilderException(String str) {
            super("Invalid request builder: " + str);
        }
    }

    protected void validate() {
        if (this.pPZ == null) {
            throw new BuilderException("Source must be set!");
        }
        if (com.facebook.common.util.d.Q(this.pPZ)) {
            if (!this.pPZ.isAbsolute()) {
                throw new BuilderException("Resource URI path must be absolute.");
            }
            if (this.pPZ.getPath().isEmpty()) {
                throw new BuilderException("Resource URI must not be empty");
            }
            try {
                Integer.parseInt(this.pPZ.getPath().substring(1));
            } catch (NumberFormatException e) {
                throw new BuilderException("Resource URI path must be a resource id.");
            }
        }
        if (com.facebook.common.util.d.P(this.pPZ) && !this.pPZ.isAbsolute()) {
            throw new BuilderException("Asset URI path must be absolute.");
        }
    }
}

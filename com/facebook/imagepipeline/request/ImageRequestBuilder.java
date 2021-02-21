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
    private com.facebook.imagepipeline.g.c pIJ;
    private Uri pNU = null;
    private ImageRequest.RequestLevel pLR = ImageRequest.RequestLevel.FULL_FETCH;
    @Nullable
    private com.facebook.imagepipeline.common.d pHs = null;
    @Nullable
    private e pHt = null;
    private com.facebook.imagepipeline.common.b pHu = com.facebook.imagepipeline.common.b.ewk();
    private ImageRequest.CacheChoice pNT = ImageRequest.CacheChoice.DEFAULT;
    private boolean pJs = h.ewL().exf();
    private boolean pNW = false;
    private Priority pNX = Priority.HIGH;
    @Nullable
    private b pNl = null;
    private boolean pJn = true;
    private boolean pOb = true;
    @Nullable
    private com.facebook.imagepipeline.common.a pKI = null;
    private Map<String, String> pNZ = null;
    private String mTag = null;
    private String pOa = null;

    public static ImageRequestBuilder ag(Uri uri) {
        return new ImageRequestBuilder().ah(uri);
    }

    public static ImageRequestBuilder Qq(int i) {
        return ag(com.facebook.common.util.d.OX(i));
    }

    public static ImageRequestBuilder o(ImageRequest imageRequest) {
        return ag(imageRequest.eAf()).a(imageRequest.eAj()).c(imageRequest.eyx()).a(imageRequest.eAe()).By(imageRequest.eAl()).a(imageRequest.ezr()).a(imageRequest.eAn()).Bx(imageRequest.eAk()).b(imageRequest.ezt()).c(imageRequest.eAh()).c(imageRequest.etC()).a(imageRequest.eAi()).c(imageRequest.etC()).P(imageRequest.eAd()).ZM(imageRequest.mTag).ZN(imageRequest.pOa);
    }

    private ImageRequestBuilder() {
    }

    public Map<String, String> eAd() {
        return this.pNZ;
    }

    public ImageRequestBuilder P(Map<String, String> map) {
        this.pNZ = map;
        return this;
    }

    public String getTag() {
        return this.mTag;
    }

    public ImageRequestBuilder ZM(String str) {
        this.mTag = str;
        return this;
    }

    public String getLogTag() {
        return this.pOa;
    }

    public ImageRequestBuilder ZN(String str) {
        this.pOa = str;
        return this;
    }

    public ImageRequestBuilder ah(Uri uri) {
        g.checkNotNull(uri);
        this.pNU = uri;
        return this;
    }

    public Uri eAf() {
        return this.pNU;
    }

    public ImageRequestBuilder a(ImageRequest.RequestLevel requestLevel) {
        this.pLR = requestLevel;
        return this;
    }

    public ImageRequest.RequestLevel ezr() {
        return this.pLR;
    }

    public ImageRequestBuilder c(@Nullable com.facebook.imagepipeline.common.d dVar) {
        this.pHs = dVar;
        return this;
    }

    @Nullable
    public com.facebook.imagepipeline.common.d eAh() {
        return this.pHs;
    }

    public ImageRequestBuilder a(@Nullable e eVar) {
        this.pHt = eVar;
        return this;
    }

    @Nullable
    public e eAi() {
        return this.pHt;
    }

    public ImageRequestBuilder c(@Nullable com.facebook.imagepipeline.common.a aVar) {
        this.pKI = aVar;
        return this;
    }

    @Nullable
    public com.facebook.imagepipeline.common.a eyx() {
        return this.pKI;
    }

    public ImageRequestBuilder a(com.facebook.imagepipeline.common.b bVar) {
        this.pHu = bVar;
        return this;
    }

    public com.facebook.imagepipeline.common.b eAj() {
        return this.pHu;
    }

    public ImageRequestBuilder a(ImageRequest.CacheChoice cacheChoice) {
        this.pNT = cacheChoice;
        return this;
    }

    public ImageRequest.CacheChoice eAe() {
        return this.pNT;
    }

    public ImageRequestBuilder Bx(boolean z) {
        this.pJs = z;
        return this;
    }

    public boolean exf() {
        return this.pJs;
    }

    public ImageRequestBuilder By(boolean z) {
        this.pNW = z;
        return this;
    }

    public boolean eAo() {
        return this.pNW;
    }

    public boolean ewO() {
        return this.pJn && com.facebook.common.util.d.K(this.pNU);
    }

    public boolean eAm() {
        return this.pOb;
    }

    public ImageRequestBuilder b(Priority priority) {
        this.pNX = priority;
        return this;
    }

    public Priority eAp() {
        return this.pNX;
    }

    public ImageRequestBuilder a(b bVar) {
        this.pNl = bVar;
        return this;
    }

    @Nullable
    public b eAn() {
        return this.pNl;
    }

    public ImageRequestBuilder c(com.facebook.imagepipeline.g.c cVar) {
        this.pIJ = cVar;
        return this;
    }

    @Nullable
    public com.facebook.imagepipeline.g.c etC() {
        return this.pIJ;
    }

    public ImageRequest eAq() {
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
        if (this.pNU == null) {
            throw new BuilderException("Source must be set!");
        }
        if (com.facebook.common.util.d.Q(this.pNU)) {
            if (!this.pNU.isAbsolute()) {
                throw new BuilderException("Resource URI path must be absolute.");
            }
            if (this.pNU.getPath().isEmpty()) {
                throw new BuilderException("Resource URI must not be empty");
            }
            try {
                Integer.parseInt(this.pNU.getPath().substring(1));
            } catch (NumberFormatException e) {
                throw new BuilderException("Resource URI path must be a resource id.");
            }
        }
        if (com.facebook.common.util.d.P(this.pNU) && !this.pNU.isAbsolute()) {
            throw new BuilderException("Asset URI path must be absolute.");
        }
    }
}

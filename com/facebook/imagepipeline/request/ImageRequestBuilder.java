package com.facebook.imagepipeline.request;

import android.net.Uri;
import com.facebook.common.internal.g;
import com.facebook.imagepipeline.c.h;
import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.common.e;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.Map;
import javax.annotation.Nullable;
/* loaded from: classes3.dex */
public class ImageRequestBuilder {
    @Nullable
    private com.facebook.imagepipeline.g.c pCB;
    private Uri pHM = null;
    private ImageRequest.RequestLevel pFJ = ImageRequest.RequestLevel.FULL_FETCH;
    @Nullable
    private com.facebook.imagepipeline.common.d pBk = null;
    @Nullable
    private e pBl = null;
    private com.facebook.imagepipeline.common.b pBm = com.facebook.imagepipeline.common.b.exC();
    private ImageRequest.CacheChoice pHL = ImageRequest.CacheChoice.DEFAULT;
    private boolean pDk = h.eyc().eyw();
    private boolean pHO = false;
    private Priority pHP = Priority.HIGH;
    @Nullable
    private b pHd = null;
    private boolean pDf = true;
    private boolean pHT = true;
    @Nullable
    private com.facebook.imagepipeline.common.a pEA = null;
    private Map<String, String> pHR = null;
    private String mTag = null;
    private String pHS = null;

    public static ImageRequestBuilder aj(Uri uri) {
        return new ImageRequestBuilder().ak(uri);
    }

    public static ImageRequestBuilder RB(int i) {
        return aj(com.facebook.common.util.d.Qi(i));
    }

    public static ImageRequestBuilder o(ImageRequest imageRequest) {
        return aj(imageRequest.eBx()).a(imageRequest.eBB()).c(imageRequest.ezO()).a(imageRequest.eBw()).Bj(imageRequest.eBD()).a(imageRequest.eAJ()).a(imageRequest.eBF()).Bi(imageRequest.eBC()).b(imageRequest.eAL()).c(imageRequest.eBz()).c(imageRequest.euV()).a(imageRequest.eBA()).c(imageRequest.euV()).N(imageRequest.eBv()).ZG(imageRequest.mTag).ZH(imageRequest.pHS);
    }

    private ImageRequestBuilder() {
    }

    public Map<String, String> eBv() {
        return this.pHR;
    }

    public ImageRequestBuilder N(Map<String, String> map) {
        this.pHR = map;
        return this;
    }

    public String getTag() {
        return this.mTag;
    }

    public ImageRequestBuilder ZG(String str) {
        this.mTag = str;
        return this;
    }

    public String getLogTag() {
        return this.pHS;
    }

    public ImageRequestBuilder ZH(String str) {
        this.pHS = str;
        return this;
    }

    public ImageRequestBuilder ak(Uri uri) {
        g.checkNotNull(uri);
        this.pHM = uri;
        return this;
    }

    public Uri eBx() {
        return this.pHM;
    }

    public ImageRequestBuilder a(ImageRequest.RequestLevel requestLevel) {
        this.pFJ = requestLevel;
        return this;
    }

    public ImageRequest.RequestLevel eAJ() {
        return this.pFJ;
    }

    public ImageRequestBuilder c(@Nullable com.facebook.imagepipeline.common.d dVar) {
        this.pBk = dVar;
        return this;
    }

    @Nullable
    public com.facebook.imagepipeline.common.d eBz() {
        return this.pBk;
    }

    public ImageRequestBuilder a(@Nullable e eVar) {
        this.pBl = eVar;
        return this;
    }

    @Nullable
    public e eBA() {
        return this.pBl;
    }

    public ImageRequestBuilder c(@Nullable com.facebook.imagepipeline.common.a aVar) {
        this.pEA = aVar;
        return this;
    }

    @Nullable
    public com.facebook.imagepipeline.common.a ezO() {
        return this.pEA;
    }

    public ImageRequestBuilder a(com.facebook.imagepipeline.common.b bVar) {
        this.pBm = bVar;
        return this;
    }

    public com.facebook.imagepipeline.common.b eBB() {
        return this.pBm;
    }

    public ImageRequestBuilder a(ImageRequest.CacheChoice cacheChoice) {
        this.pHL = cacheChoice;
        return this;
    }

    public ImageRequest.CacheChoice eBw() {
        return this.pHL;
    }

    public ImageRequestBuilder Bi(boolean z) {
        this.pDk = z;
        return this;
    }

    public boolean eyw() {
        return this.pDk;
    }

    public ImageRequestBuilder Bj(boolean z) {
        this.pHO = z;
        return this;
    }

    public boolean eBG() {
        return this.pHO;
    }

    public boolean eyf() {
        return this.pDf && com.facebook.common.util.d.N(this.pHM);
    }

    public boolean eBE() {
        return this.pHT;
    }

    public ImageRequestBuilder b(Priority priority) {
        this.pHP = priority;
        return this;
    }

    public Priority eBH() {
        return this.pHP;
    }

    public ImageRequestBuilder a(b bVar) {
        this.pHd = bVar;
        return this;
    }

    @Nullable
    public b eBF() {
        return this.pHd;
    }

    public ImageRequestBuilder c(com.facebook.imagepipeline.g.c cVar) {
        this.pCB = cVar;
        return this;
    }

    @Nullable
    public com.facebook.imagepipeline.g.c euV() {
        return this.pCB;
    }

    public ImageRequest eBI() {
        validate();
        return new ImageRequest(this);
    }

    /* loaded from: classes3.dex */
    public static class BuilderException extends RuntimeException {
        public BuilderException(String str) {
            super("Invalid request builder: " + str);
        }
    }

    protected void validate() {
        if (this.pHM == null) {
            throw new BuilderException("Source must be set!");
        }
        if (com.facebook.common.util.d.T(this.pHM)) {
            if (!this.pHM.isAbsolute()) {
                throw new BuilderException("Resource URI path must be absolute.");
            }
            if (this.pHM.getPath().isEmpty()) {
                throw new BuilderException("Resource URI must not be empty");
            }
            try {
                Integer.parseInt(this.pHM.getPath().substring(1));
            } catch (NumberFormatException e) {
                throw new BuilderException("Resource URI path must be a resource id.");
            }
        }
        if (com.facebook.common.util.d.S(this.pHM) && !this.pHM.isAbsolute()) {
            throw new BuilderException("Asset URI path must be absolute.");
        }
    }
}

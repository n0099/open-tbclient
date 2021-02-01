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
    private com.facebook.imagepipeline.g.c pIj;
    private Uri pNu = null;
    private ImageRequest.RequestLevel pLr = ImageRequest.RequestLevel.FULL_FETCH;
    @Nullable
    private com.facebook.imagepipeline.common.d pGS = null;
    @Nullable
    private e pGT = null;
    private com.facebook.imagepipeline.common.b pGU = com.facebook.imagepipeline.common.b.ewc();
    private ImageRequest.CacheChoice pNt = ImageRequest.CacheChoice.DEFAULT;
    private boolean pIS = h.ewD().ewX();
    private boolean pNw = false;
    private Priority pNx = Priority.HIGH;
    @Nullable
    private b pML = null;
    private boolean pIN = true;
    private boolean pNB = true;
    @Nullable
    private com.facebook.imagepipeline.common.a pKi = null;
    private Map<String, String> pNz = null;
    private String mTag = null;
    private String pNA = null;

    public static ImageRequestBuilder ag(Uri uri) {
        return new ImageRequestBuilder().ah(uri);
    }

    public static ImageRequestBuilder Qp(int i) {
        return ag(com.facebook.common.util.d.OW(i));
    }

    public static ImageRequestBuilder o(ImageRequest imageRequest) {
        return ag(imageRequest.ezX()).a(imageRequest.eAb()).c(imageRequest.eyp()).a(imageRequest.ezW()).By(imageRequest.eAd()).a(imageRequest.ezj()).a(imageRequest.eAf()).Bx(imageRequest.eAc()).b(imageRequest.ezl()).c(imageRequest.ezZ()).c(imageRequest.etu()).a(imageRequest.eAa()).c(imageRequest.etu()).P(imageRequest.ezV()).ZA(imageRequest.mTag).ZB(imageRequest.pNA);
    }

    private ImageRequestBuilder() {
    }

    public Map<String, String> ezV() {
        return this.pNz;
    }

    public ImageRequestBuilder P(Map<String, String> map) {
        this.pNz = map;
        return this;
    }

    public String getTag() {
        return this.mTag;
    }

    public ImageRequestBuilder ZA(String str) {
        this.mTag = str;
        return this;
    }

    public String getLogTag() {
        return this.pNA;
    }

    public ImageRequestBuilder ZB(String str) {
        this.pNA = str;
        return this;
    }

    public ImageRequestBuilder ah(Uri uri) {
        g.checkNotNull(uri);
        this.pNu = uri;
        return this;
    }

    public Uri ezX() {
        return this.pNu;
    }

    public ImageRequestBuilder a(ImageRequest.RequestLevel requestLevel) {
        this.pLr = requestLevel;
        return this;
    }

    public ImageRequest.RequestLevel ezj() {
        return this.pLr;
    }

    public ImageRequestBuilder c(@Nullable com.facebook.imagepipeline.common.d dVar) {
        this.pGS = dVar;
        return this;
    }

    @Nullable
    public com.facebook.imagepipeline.common.d ezZ() {
        return this.pGS;
    }

    public ImageRequestBuilder a(@Nullable e eVar) {
        this.pGT = eVar;
        return this;
    }

    @Nullable
    public e eAa() {
        return this.pGT;
    }

    public ImageRequestBuilder c(@Nullable com.facebook.imagepipeline.common.a aVar) {
        this.pKi = aVar;
        return this;
    }

    @Nullable
    public com.facebook.imagepipeline.common.a eyp() {
        return this.pKi;
    }

    public ImageRequestBuilder a(com.facebook.imagepipeline.common.b bVar) {
        this.pGU = bVar;
        return this;
    }

    public com.facebook.imagepipeline.common.b eAb() {
        return this.pGU;
    }

    public ImageRequestBuilder a(ImageRequest.CacheChoice cacheChoice) {
        this.pNt = cacheChoice;
        return this;
    }

    public ImageRequest.CacheChoice ezW() {
        return this.pNt;
    }

    public ImageRequestBuilder Bx(boolean z) {
        this.pIS = z;
        return this;
    }

    public boolean ewX() {
        return this.pIS;
    }

    public ImageRequestBuilder By(boolean z) {
        this.pNw = z;
        return this;
    }

    public boolean eAg() {
        return this.pNw;
    }

    public boolean ewG() {
        return this.pIN && com.facebook.common.util.d.K(this.pNu);
    }

    public boolean eAe() {
        return this.pNB;
    }

    public ImageRequestBuilder b(Priority priority) {
        this.pNx = priority;
        return this;
    }

    public Priority eAh() {
        return this.pNx;
    }

    public ImageRequestBuilder a(b bVar) {
        this.pML = bVar;
        return this;
    }

    @Nullable
    public b eAf() {
        return this.pML;
    }

    public ImageRequestBuilder c(com.facebook.imagepipeline.g.c cVar) {
        this.pIj = cVar;
        return this;
    }

    @Nullable
    public com.facebook.imagepipeline.g.c etu() {
        return this.pIj;
    }

    public ImageRequest eAi() {
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
        if (this.pNu == null) {
            throw new BuilderException("Source must be set!");
        }
        if (com.facebook.common.util.d.Q(this.pNu)) {
            if (!this.pNu.isAbsolute()) {
                throw new BuilderException("Resource URI path must be absolute.");
            }
            if (this.pNu.getPath().isEmpty()) {
                throw new BuilderException("Resource URI must not be empty");
            }
            try {
                Integer.parseInt(this.pNu.getPath().substring(1));
            } catch (NumberFormatException e) {
                throw new BuilderException("Resource URI path must be a resource id.");
            }
        }
        if (com.facebook.common.util.d.P(this.pNu) && !this.pNu.isAbsolute()) {
            throw new BuilderException("Asset URI path must be absolute.");
        }
    }
}

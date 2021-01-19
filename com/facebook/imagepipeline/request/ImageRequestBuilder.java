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
    private com.facebook.imagepipeline.g.c pyb;
    private Uri pDm = null;
    private ImageRequest.RequestLevel pBj = ImageRequest.RequestLevel.FULL_FETCH;
    @Nullable
    private com.facebook.imagepipeline.common.d pwK = null;
    @Nullable
    private e pwL = null;
    private com.facebook.imagepipeline.common.b pwM = com.facebook.imagepipeline.common.b.etK();
    private ImageRequest.CacheChoice pDl = ImageRequest.CacheChoice.DEFAULT;
    private boolean pyK = h.euk().euE();
    private boolean pDo = false;
    private Priority pDp = Priority.HIGH;
    @Nullable
    private b pCD = null;
    private boolean pyF = true;
    private boolean pDt = true;
    @Nullable
    private com.facebook.imagepipeline.common.a pAa = null;
    private Map<String, String> pDr = null;
    private String mTag = null;
    private String pDs = null;

    public static ImageRequestBuilder ag(Uri uri) {
        return new ImageRequestBuilder().ah(uri);
    }

    public static ImageRequestBuilder PU(int i) {
        return ag(com.facebook.common.util.d.OB(i));
    }

    public static ImageRequestBuilder o(ImageRequest imageRequest) {
        return ag(imageRequest.exF()).a(imageRequest.exJ()).c(imageRequest.evW()).a(imageRequest.exE()).Bf(imageRequest.exL()).a(imageRequest.ewR()).a(imageRequest.exN()).Be(imageRequest.exK()).b(imageRequest.ewT()).c(imageRequest.exH()).c(imageRequest.erb()).a(imageRequest.exI()).c(imageRequest.erb()).N(imageRequest.exD()).Yz(imageRequest.mTag).YA(imageRequest.pDs);
    }

    private ImageRequestBuilder() {
    }

    public Map<String, String> exD() {
        return this.pDr;
    }

    public ImageRequestBuilder N(Map<String, String> map) {
        this.pDr = map;
        return this;
    }

    public String getTag() {
        return this.mTag;
    }

    public ImageRequestBuilder Yz(String str) {
        this.mTag = str;
        return this;
    }

    public String getLogTag() {
        return this.pDs;
    }

    public ImageRequestBuilder YA(String str) {
        this.pDs = str;
        return this;
    }

    public ImageRequestBuilder ah(Uri uri) {
        g.checkNotNull(uri);
        this.pDm = uri;
        return this;
    }

    public Uri exF() {
        return this.pDm;
    }

    public ImageRequestBuilder a(ImageRequest.RequestLevel requestLevel) {
        this.pBj = requestLevel;
        return this;
    }

    public ImageRequest.RequestLevel ewR() {
        return this.pBj;
    }

    public ImageRequestBuilder c(@Nullable com.facebook.imagepipeline.common.d dVar) {
        this.pwK = dVar;
        return this;
    }

    @Nullable
    public com.facebook.imagepipeline.common.d exH() {
        return this.pwK;
    }

    public ImageRequestBuilder a(@Nullable e eVar) {
        this.pwL = eVar;
        return this;
    }

    @Nullable
    public e exI() {
        return this.pwL;
    }

    public ImageRequestBuilder c(@Nullable com.facebook.imagepipeline.common.a aVar) {
        this.pAa = aVar;
        return this;
    }

    @Nullable
    public com.facebook.imagepipeline.common.a evW() {
        return this.pAa;
    }

    public ImageRequestBuilder a(com.facebook.imagepipeline.common.b bVar) {
        this.pwM = bVar;
        return this;
    }

    public com.facebook.imagepipeline.common.b exJ() {
        return this.pwM;
    }

    public ImageRequestBuilder a(ImageRequest.CacheChoice cacheChoice) {
        this.pDl = cacheChoice;
        return this;
    }

    public ImageRequest.CacheChoice exE() {
        return this.pDl;
    }

    public ImageRequestBuilder Be(boolean z) {
        this.pyK = z;
        return this;
    }

    public boolean euE() {
        return this.pyK;
    }

    public ImageRequestBuilder Bf(boolean z) {
        this.pDo = z;
        return this;
    }

    public boolean exO() {
        return this.pDo;
    }

    public boolean eun() {
        return this.pyF && com.facebook.common.util.d.K(this.pDm);
    }

    public boolean exM() {
        return this.pDt;
    }

    public ImageRequestBuilder b(Priority priority) {
        this.pDp = priority;
        return this;
    }

    public Priority exP() {
        return this.pDp;
    }

    public ImageRequestBuilder a(b bVar) {
        this.pCD = bVar;
        return this;
    }

    @Nullable
    public b exN() {
        return this.pCD;
    }

    public ImageRequestBuilder c(com.facebook.imagepipeline.g.c cVar) {
        this.pyb = cVar;
        return this;
    }

    @Nullable
    public com.facebook.imagepipeline.g.c erb() {
        return this.pyb;
    }

    public ImageRequest exQ() {
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
        if (this.pDm == null) {
            throw new BuilderException("Source must be set!");
        }
        if (com.facebook.common.util.d.Q(this.pDm)) {
            if (!this.pDm.isAbsolute()) {
                throw new BuilderException("Resource URI path must be absolute.");
            }
            if (this.pDm.getPath().isEmpty()) {
                throw new BuilderException("Resource URI must not be empty");
            }
            try {
                Integer.parseInt(this.pDm.getPath().substring(1));
            } catch (NumberFormatException e) {
                throw new BuilderException("Resource URI path must be a resource id.");
            }
        }
        if (com.facebook.common.util.d.P(this.pDm) && !this.pDm.isAbsolute()) {
            throw new BuilderException("Asset URI path must be absolute.");
        }
    }
}

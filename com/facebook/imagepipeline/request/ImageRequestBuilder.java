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
    private com.facebook.imagepipeline.g.c pya;
    private Uri pDl = null;
    private ImageRequest.RequestLevel pBi = ImageRequest.RequestLevel.FULL_FETCH;
    @Nullable
    private com.facebook.imagepipeline.common.d pwJ = null;
    @Nullable
    private e pwK = null;
    private com.facebook.imagepipeline.common.b pwL = com.facebook.imagepipeline.common.b.etK();
    private ImageRequest.CacheChoice pDk = ImageRequest.CacheChoice.DEFAULT;
    private boolean pyJ = h.euk().euE();
    private boolean pDn = false;
    private Priority pDo = Priority.HIGH;
    @Nullable
    private b pCC = null;
    private boolean pyE = true;
    private boolean pDs = true;
    @Nullable
    private com.facebook.imagepipeline.common.a pzZ = null;
    private Map<String, String> pDq = null;
    private String mTag = null;
    private String pDr = null;

    public static ImageRequestBuilder ag(Uri uri) {
        return new ImageRequestBuilder().ah(uri);
    }

    public static ImageRequestBuilder PU(int i) {
        return ag(com.facebook.common.util.d.OB(i));
    }

    public static ImageRequestBuilder o(ImageRequest imageRequest) {
        return ag(imageRequest.exF()).a(imageRequest.exJ()).c(imageRequest.evW()).a(imageRequest.exE()).Bf(imageRequest.exL()).a(imageRequest.ewR()).a(imageRequest.exN()).Be(imageRequest.exK()).b(imageRequest.ewT()).c(imageRequest.exH()).c(imageRequest.erb()).a(imageRequest.exI()).c(imageRequest.erb()).N(imageRequest.exD()).Yy(imageRequest.mTag).Yz(imageRequest.pDr);
    }

    private ImageRequestBuilder() {
    }

    public Map<String, String> exD() {
        return this.pDq;
    }

    public ImageRequestBuilder N(Map<String, String> map) {
        this.pDq = map;
        return this;
    }

    public String getTag() {
        return this.mTag;
    }

    public ImageRequestBuilder Yy(String str) {
        this.mTag = str;
        return this;
    }

    public String getLogTag() {
        return this.pDr;
    }

    public ImageRequestBuilder Yz(String str) {
        this.pDr = str;
        return this;
    }

    public ImageRequestBuilder ah(Uri uri) {
        g.checkNotNull(uri);
        this.pDl = uri;
        return this;
    }

    public Uri exF() {
        return this.pDl;
    }

    public ImageRequestBuilder a(ImageRequest.RequestLevel requestLevel) {
        this.pBi = requestLevel;
        return this;
    }

    public ImageRequest.RequestLevel ewR() {
        return this.pBi;
    }

    public ImageRequestBuilder c(@Nullable com.facebook.imagepipeline.common.d dVar) {
        this.pwJ = dVar;
        return this;
    }

    @Nullable
    public com.facebook.imagepipeline.common.d exH() {
        return this.pwJ;
    }

    public ImageRequestBuilder a(@Nullable e eVar) {
        this.pwK = eVar;
        return this;
    }

    @Nullable
    public e exI() {
        return this.pwK;
    }

    public ImageRequestBuilder c(@Nullable com.facebook.imagepipeline.common.a aVar) {
        this.pzZ = aVar;
        return this;
    }

    @Nullable
    public com.facebook.imagepipeline.common.a evW() {
        return this.pzZ;
    }

    public ImageRequestBuilder a(com.facebook.imagepipeline.common.b bVar) {
        this.pwL = bVar;
        return this;
    }

    public com.facebook.imagepipeline.common.b exJ() {
        return this.pwL;
    }

    public ImageRequestBuilder a(ImageRequest.CacheChoice cacheChoice) {
        this.pDk = cacheChoice;
        return this;
    }

    public ImageRequest.CacheChoice exE() {
        return this.pDk;
    }

    public ImageRequestBuilder Be(boolean z) {
        this.pyJ = z;
        return this;
    }

    public boolean euE() {
        return this.pyJ;
    }

    public ImageRequestBuilder Bf(boolean z) {
        this.pDn = z;
        return this;
    }

    public boolean exO() {
        return this.pDn;
    }

    public boolean eun() {
        return this.pyE && com.facebook.common.util.d.K(this.pDl);
    }

    public boolean exM() {
        return this.pDs;
    }

    public ImageRequestBuilder b(Priority priority) {
        this.pDo = priority;
        return this;
    }

    public Priority exP() {
        return this.pDo;
    }

    public ImageRequestBuilder a(b bVar) {
        this.pCC = bVar;
        return this;
    }

    @Nullable
    public b exN() {
        return this.pCC;
    }

    public ImageRequestBuilder c(com.facebook.imagepipeline.g.c cVar) {
        this.pya = cVar;
        return this;
    }

    @Nullable
    public com.facebook.imagepipeline.g.c erb() {
        return this.pya;
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
        if (this.pDl == null) {
            throw new BuilderException("Source must be set!");
        }
        if (com.facebook.common.util.d.Q(this.pDl)) {
            if (!this.pDl.isAbsolute()) {
                throw new BuilderException("Resource URI path must be absolute.");
            }
            if (this.pDl.getPath().isEmpty()) {
                throw new BuilderException("Resource URI must not be empty");
            }
            try {
                Integer.parseInt(this.pDl.getPath().substring(1));
            } catch (NumberFormatException e) {
                throw new BuilderException("Resource URI path must be a resource id.");
            }
        }
        if (com.facebook.common.util.d.P(this.pDl) && !this.pDl.isAbsolute()) {
            throw new BuilderException("Asset URI path must be absolute.");
        }
    }
}

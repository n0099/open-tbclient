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
    private com.facebook.imagepipeline.h.c mbC;
    private Uri mgM = null;
    private ImageRequest.RequestLevel meK = ImageRequest.RequestLevel.FULL_FETCH;
    @Nullable
    private com.facebook.imagepipeline.common.d maf = null;
    @Nullable
    private e mag = null;
    private com.facebook.imagepipeline.common.b mah = com.facebook.imagepipeline.common.b.dqG();
    private ImageRequest.CacheChoice mgL = ImageRequest.CacheChoice.DEFAULT;
    private boolean mcl = h.drh().drB();
    private boolean mgO = false;
    private Priority mgP = Priority.HIGH;
    @Nullable
    private b mgd = null;
    private boolean mcg = true;
    private boolean mgT = true;
    @Nullable
    private com.facebook.imagepipeline.common.a mdB = null;
    private Map<String, String> mgR = null;
    private String mTag = null;
    private String mgS = null;

    public static ImageRequestBuilder Z(Uri uri) {
        return new ImageRequestBuilder().aa(uri);
    }

    public static ImageRequestBuilder Hz(int i) {
        return Z(com.facebook.common.util.d.Gc(i));
    }

    public static ImageRequestBuilder o(ImageRequest imageRequest) {
        return Z(imageRequest.duI()).a(imageRequest.duM()).d(imageRequest.dsT()).a(imageRequest.duH()).vQ(imageRequest.duO()).a(imageRequest.dtS()).a(imageRequest.duQ()).vP(imageRequest.duN()).b(imageRequest.dtU()).c(imageRequest.duK()).c(imageRequest.dnS()).a(imageRequest.duL()).c(imageRequest.dnS()).x(imageRequest.duh()).Ou(imageRequest.mTag).Ov(imageRequest.mgS);
    }

    private ImageRequestBuilder() {
    }

    public Map<String, String> duh() {
        return this.mgR;
    }

    public ImageRequestBuilder x(Map<String, String> map) {
        this.mgR = map;
        return this;
    }

    public String getTag() {
        return this.mTag;
    }

    public ImageRequestBuilder Ou(String str) {
        this.mTag = str;
        return this;
    }

    public String getLogTag() {
        return this.mgS;
    }

    public ImageRequestBuilder Ov(String str) {
        this.mgS = str;
        return this;
    }

    public ImageRequestBuilder aa(Uri uri) {
        g.checkNotNull(uri);
        this.mgM = uri;
        return this;
    }

    public Uri duI() {
        return this.mgM;
    }

    public ImageRequestBuilder a(ImageRequest.RequestLevel requestLevel) {
        this.meK = requestLevel;
        return this;
    }

    public ImageRequest.RequestLevel dtS() {
        return this.meK;
    }

    public ImageRequestBuilder c(@Nullable com.facebook.imagepipeline.common.d dVar) {
        this.maf = dVar;
        return this;
    }

    @Nullable
    public com.facebook.imagepipeline.common.d duK() {
        return this.maf;
    }

    public ImageRequestBuilder a(@Nullable e eVar) {
        this.mag = eVar;
        return this;
    }

    @Nullable
    public e duL() {
        return this.mag;
    }

    public ImageRequestBuilder d(@Nullable com.facebook.imagepipeline.common.a aVar) {
        this.mdB = aVar;
        return this;
    }

    @Nullable
    public com.facebook.imagepipeline.common.a dsT() {
        return this.mdB;
    }

    public ImageRequestBuilder a(com.facebook.imagepipeline.common.b bVar) {
        this.mah = bVar;
        return this;
    }

    public com.facebook.imagepipeline.common.b duM() {
        return this.mah;
    }

    public ImageRequestBuilder a(ImageRequest.CacheChoice cacheChoice) {
        this.mgL = cacheChoice;
        return this;
    }

    public ImageRequest.CacheChoice duH() {
        return this.mgL;
    }

    public ImageRequestBuilder vP(boolean z) {
        this.mcl = z;
        return this;
    }

    public boolean drB() {
        return this.mcl;
    }

    public ImageRequestBuilder vQ(boolean z) {
        this.mgO = z;
        return this;
    }

    public boolean duR() {
        return this.mgO;
    }

    public boolean drk() {
        return this.mcg && com.facebook.common.util.d.G(this.mgM);
    }

    public boolean duP() {
        return this.mgT;
    }

    public ImageRequestBuilder b(Priority priority) {
        this.mgP = priority;
        return this;
    }

    public Priority duS() {
        return this.mgP;
    }

    public ImageRequestBuilder a(b bVar) {
        this.mgd = bVar;
        return this;
    }

    @Nullable
    public b duQ() {
        return this.mgd;
    }

    public ImageRequestBuilder c(com.facebook.imagepipeline.h.c cVar) {
        this.mbC = cVar;
        return this;
    }

    @Nullable
    public com.facebook.imagepipeline.h.c dnS() {
        return this.mbC;
    }

    public ImageRequest duT() {
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
        if (this.mgM == null) {
            throw new BuilderException("Source must be set!");
        }
        if (com.facebook.common.util.d.K(this.mgM)) {
            if (!this.mgM.isAbsolute()) {
                throw new BuilderException("Resource URI path must be absolute.");
            }
            if (this.mgM.getPath().isEmpty()) {
                throw new BuilderException("Resource URI must not be empty");
            }
            try {
                Integer.parseInt(this.mgM.getPath().substring(1));
            } catch (NumberFormatException e) {
                throw new BuilderException("Resource URI path must be a resource id.");
            }
        }
        if (com.facebook.common.util.d.J(this.mgM) && !this.mgM.isAbsolute()) {
            throw new BuilderException("Asset URI path must be absolute.");
        }
    }
}

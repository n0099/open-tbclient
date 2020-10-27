package com.facebook.imagepipeline.request;

import android.net.Uri;
import com.facebook.common.internal.g;
import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.common.e;
import com.facebook.imagepipeline.d.h;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.Map;
import javax.annotation.Nullable;
/* loaded from: classes18.dex */
public class ImageRequestBuilder {
    @Nullable
    private com.facebook.imagepipeline.h.c oLE;
    private Uri oQO = null;
    private ImageRequest.RequestLevel oOM = ImageRequest.RequestLevel.FULL_FETCH;
    @Nullable
    private com.facebook.imagepipeline.common.d oKk = null;
    @Nullable
    private e oKl = null;
    private com.facebook.imagepipeline.common.b oKm = com.facebook.imagepipeline.common.b.ejV();
    private ImageRequest.CacheChoice oQN = ImageRequest.CacheChoice.DEFAULT;
    private boolean oMn = h.ekw().ekQ();
    private boolean oQQ = false;
    private Priority oQR = Priority.HIGH;
    @Nullable
    private b oQf = null;
    private boolean oMi = true;
    private boolean oQV = true;
    @Nullable
    private com.facebook.imagepipeline.common.a oND = null;
    private Map<String, String> oQT = null;
    private String mTag = null;
    private String oQU = null;

    public static ImageRequestBuilder ad(Uri uri) {
        return new ImageRequestBuilder().ae(uri);
    }

    public static ImageRequestBuilder Pv(int i) {
        return ad(com.facebook.common.util.d.NY(i));
    }

    public static ImageRequestBuilder o(ImageRequest imageRequest) {
        return ad(imageRequest.enX()).a(imageRequest.eob()).d(imageRequest.emi()).a(imageRequest.enW()).Ai(imageRequest.eod()).a(imageRequest.enh()).a(imageRequest.eog()).Ah(imageRequest.eoc()).b(imageRequest.enj()).c(imageRequest.enZ()).c(imageRequest.ehj()).a(imageRequest.eoa()).c(imageRequest.ehj()).I(imageRequest.enw()).XO(imageRequest.mTag).XP(imageRequest.oQU);
    }

    private ImageRequestBuilder() {
    }

    public Map<String, String> enw() {
        return this.oQT;
    }

    public ImageRequestBuilder I(Map<String, String> map) {
        this.oQT = map;
        return this;
    }

    public String getTag() {
        return this.mTag;
    }

    public ImageRequestBuilder XO(String str) {
        this.mTag = str;
        return this;
    }

    public String getLogTag() {
        return this.oQU;
    }

    public ImageRequestBuilder XP(String str) {
        this.oQU = str;
        return this;
    }

    public ImageRequestBuilder ae(Uri uri) {
        g.checkNotNull(uri);
        this.oQO = uri;
        return this;
    }

    public Uri enX() {
        return this.oQO;
    }

    public ImageRequestBuilder a(ImageRequest.RequestLevel requestLevel) {
        this.oOM = requestLevel;
        return this;
    }

    public ImageRequest.RequestLevel enh() {
        return this.oOM;
    }

    public ImageRequestBuilder c(@Nullable com.facebook.imagepipeline.common.d dVar) {
        this.oKk = dVar;
        return this;
    }

    @Nullable
    public com.facebook.imagepipeline.common.d enZ() {
        return this.oKk;
    }

    public ImageRequestBuilder a(@Nullable e eVar) {
        this.oKl = eVar;
        return this;
    }

    @Nullable
    public e eoa() {
        return this.oKl;
    }

    public ImageRequestBuilder d(@Nullable com.facebook.imagepipeline.common.a aVar) {
        this.oND = aVar;
        return this;
    }

    @Nullable
    public com.facebook.imagepipeline.common.a emi() {
        return this.oND;
    }

    public ImageRequestBuilder a(com.facebook.imagepipeline.common.b bVar) {
        this.oKm = bVar;
        return this;
    }

    public com.facebook.imagepipeline.common.b eob() {
        return this.oKm;
    }

    public ImageRequestBuilder a(ImageRequest.CacheChoice cacheChoice) {
        this.oQN = cacheChoice;
        return this;
    }

    public ImageRequest.CacheChoice enW() {
        return this.oQN;
    }

    public ImageRequestBuilder Ah(boolean z) {
        this.oMn = z;
        return this;
    }

    public boolean ekQ() {
        return this.oMn;
    }

    public ImageRequestBuilder Ai(boolean z) {
        this.oQQ = z;
        return this;
    }

    public boolean eoh() {
        return this.oQQ;
    }

    public boolean ekz() {
        return this.oMi && com.facebook.common.util.d.K(this.oQO);
    }

    public boolean eoe() {
        return this.oQV;
    }

    public ImageRequestBuilder b(Priority priority) {
        this.oQR = priority;
        return this;
    }

    public Priority eoi() {
        return this.oQR;
    }

    public ImageRequestBuilder a(b bVar) {
        this.oQf = bVar;
        return this;
    }

    @Nullable
    public b eog() {
        return this.oQf;
    }

    public ImageRequestBuilder c(com.facebook.imagepipeline.h.c cVar) {
        this.oLE = cVar;
        return this;
    }

    @Nullable
    public com.facebook.imagepipeline.h.c ehj() {
        return this.oLE;
    }

    public ImageRequest eoj() {
        validate();
        return new ImageRequest(this);
    }

    /* loaded from: classes18.dex */
    public static class BuilderException extends RuntimeException {
        public BuilderException(String str) {
            super("Invalid request builder: " + str);
        }
    }

    protected void validate() {
        if (this.oQO == null) {
            throw new BuilderException("Source must be set!");
        }
        if (com.facebook.common.util.d.O(this.oQO)) {
            if (!this.oQO.isAbsolute()) {
                throw new BuilderException("Resource URI path must be absolute.");
            }
            if (this.oQO.getPath().isEmpty()) {
                throw new BuilderException("Resource URI must not be empty");
            }
            try {
                Integer.parseInt(this.oQO.getPath().substring(1));
            } catch (NumberFormatException e) {
                throw new BuilderException("Resource URI path must be a resource id.");
            }
        }
        if (com.facebook.common.util.d.N(this.oQO) && !this.oQO.isAbsolute()) {
            throw new BuilderException("Asset URI path must be absolute.");
        }
    }
}

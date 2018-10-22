package com.facebook.imagepipeline.request;

import android.net.Uri;
import com.facebook.common.internal.f;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;
@Immutable
/* loaded from: classes2.dex */
public class a {
    @Nullable
    private final List<b> iiS;
    private final boolean iiT;
    private final String mMediaId;
    private final String mSource;

    private a(C0324a c0324a) {
        this.mMediaId = c0324a.mMediaId;
        this.iiS = c0324a.iiS;
        this.iiT = c0324a.iiT;
        this.mSource = c0324a.mSource;
    }

    public String getMediaId() {
        return this.mMediaId;
    }

    public int bYs() {
        if (this.iiS == null) {
            return 0;
        }
        return this.iiS.size();
    }

    public List<b> a(Comparator<b> comparator) {
        int bYs = bYs();
        if (bYs == 0) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(bYs);
        for (int i = 0; i < bYs; i++) {
            arrayList.add(this.iiS.get(i));
        }
        Collections.sort(arrayList, comparator);
        return arrayList;
    }

    public boolean bYt() {
        return this.iiT;
    }

    public String getSource() {
        return this.mSource;
    }

    public boolean equals(Object obj) {
        if (obj instanceof a) {
            a aVar = (a) obj;
            return f.equal(this.mMediaId, aVar.mMediaId) && this.iiT == aVar.iiT && f.equal(this.iiS, aVar.iiS);
        }
        return false;
    }

    public int hashCode() {
        return f.hashCode(this.mMediaId, Boolean.valueOf(this.iiT), this.iiS, this.mSource);
    }

    public String toString() {
        return String.format(null, "%s-%b-%s-%s", this.mMediaId, Boolean.valueOf(this.iiT), this.iiS, this.mSource);
    }

    /* loaded from: classes2.dex */
    public static final class b {
        @Nullable
        private final ImageRequest.CacheChoice iiJ;
        private final int mHeight;
        private final Uri mUri;
        private final int mWidth;

        public b(Uri uri, int i, int i2, @Nullable ImageRequest.CacheChoice cacheChoice) {
            this.mUri = uri;
            this.mWidth = i;
            this.mHeight = i2;
            this.iiJ = cacheChoice;
        }

        public Uri getUri() {
            return this.mUri;
        }

        public int getWidth() {
            return this.mWidth;
        }

        public int getHeight() {
            return this.mHeight;
        }

        @Nullable
        public ImageRequest.CacheChoice bYc() {
            return this.iiJ;
        }

        public boolean equals(Object obj) {
            if (obj instanceof b) {
                b bVar = (b) obj;
                return f.equal(this.mUri, bVar.mUri) && this.mWidth == bVar.mWidth && this.mHeight == bVar.mHeight && this.iiJ == bVar.iiJ;
            }
            return false;
        }

        public int hashCode() {
            return (((this.mUri.hashCode() * 31) + this.mWidth) * 31) + this.mHeight;
        }

        public String toString() {
            return String.format(null, "%dx%d %s %s", Integer.valueOf(this.mWidth), Integer.valueOf(this.mHeight), this.mUri, this.iiJ);
        }
    }

    public static C0324a yI(String str) {
        return new C0324a(str);
    }

    /* renamed from: com.facebook.imagepipeline.request.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0324a {
        private List<b> iiS;
        private boolean iiT;
        private final String mMediaId;
        private String mSource;

        private C0324a(String str) {
            this.iiT = false;
            this.mSource = "request";
            this.mMediaId = str;
        }

        public C0324a a(Uri uri, int i, int i2, ImageRequest.CacheChoice cacheChoice) {
            if (this.iiS == null) {
                this.iiS = new ArrayList();
            }
            this.iiS.add(new b(uri, i, i2, cacheChoice));
            return this;
        }

        public C0324a oK(boolean z) {
            this.iiT = z;
            return this;
        }

        public C0324a yJ(String str) {
            this.mSource = str;
            return this;
        }

        public a bYu() {
            return new a(this);
        }
    }
}

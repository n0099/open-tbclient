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
    private final List<b> kms;
    private final boolean kmt;
    private final String mMediaId;
    private final String mSource;

    private a(C0562a c0562a) {
        this.mMediaId = c0562a.mMediaId;
        this.kms = c0562a.kms;
        this.kmt = c0562a.kmt;
        this.mSource = c0562a.mSource;
    }

    public String getMediaId() {
        return this.mMediaId;
    }

    public int cJH() {
        if (this.kms == null) {
            return 0;
        }
        return this.kms.size();
    }

    public List<b> a(Comparator<b> comparator) {
        int cJH = cJH();
        if (cJH == 0) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(cJH);
        for (int i = 0; i < cJH; i++) {
            arrayList.add(this.kms.get(i));
        }
        Collections.sort(arrayList, comparator);
        return arrayList;
    }

    public boolean cJI() {
        return this.kmt;
    }

    public String getSource() {
        return this.mSource;
    }

    public boolean equals(Object obj) {
        if (obj instanceof a) {
            a aVar = (a) obj;
            return f.equal(this.mMediaId, aVar.mMediaId) && this.kmt == aVar.kmt && f.equal(this.kms, aVar.kms);
        }
        return false;
    }

    public int hashCode() {
        return f.I(this.mMediaId, Boolean.valueOf(this.kmt), this.kms, this.mSource);
    }

    public String toString() {
        return String.format(null, "%s-%b-%s-%s", this.mMediaId, Boolean.valueOf(this.kmt), this.kms, this.mSource);
    }

    /* loaded from: classes2.dex */
    public static final class b {
        @Nullable
        private final ImageRequest.CacheChoice kmj;
        private final int mHeight;
        private final Uri mUri;
        private final int mWidth;

        public b(Uri uri, int i, int i2, @Nullable ImageRequest.CacheChoice cacheChoice) {
            this.mUri = uri;
            this.mWidth = i;
            this.mHeight = i2;
            this.kmj = cacheChoice;
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
        public ImageRequest.CacheChoice cJr() {
            return this.kmj;
        }

        public boolean equals(Object obj) {
            if (obj instanceof b) {
                b bVar = (b) obj;
                return f.equal(this.mUri, bVar.mUri) && this.mWidth == bVar.mWidth && this.mHeight == bVar.mHeight && this.kmj == bVar.kmj;
            }
            return false;
        }

        public int hashCode() {
            return (((this.mUri.hashCode() * 31) + this.mWidth) * 31) + this.mHeight;
        }

        public String toString() {
            return String.format(null, "%dx%d %s %s", Integer.valueOf(this.mWidth), Integer.valueOf(this.mHeight), this.mUri, this.kmj);
        }
    }

    public static C0562a GM(String str) {
        return new C0562a(str);
    }

    /* renamed from: com.facebook.imagepipeline.request.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0562a {
        private List<b> kms;
        private boolean kmt;
        private final String mMediaId;
        private String mSource;

        private C0562a(String str) {
            this.kmt = false;
            this.mSource = "request";
            this.mMediaId = str;
        }

        public C0562a a(Uri uri, int i, int i2, ImageRequest.CacheChoice cacheChoice) {
            if (this.kms == null) {
                this.kms = new ArrayList();
            }
            this.kms.add(new b(uri, i, i2, cacheChoice));
            return this;
        }

        public C0562a sm(boolean z) {
            this.kmt = z;
            return this;
        }

        public C0562a GN(String str) {
            this.mSource = str;
            return this;
        }

        public a cJJ() {
            return new a(this);
        }
    }
}

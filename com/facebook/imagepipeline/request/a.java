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
    private final List<b> jLv;
    private final boolean jLw;
    private final String mMediaId;
    private final String mSource;

    private a(C0437a c0437a) {
        this.mMediaId = c0437a.mMediaId;
        this.jLv = c0437a.jLv;
        this.jLw = c0437a.jLw;
        this.mSource = c0437a.mSource;
    }

    public String getMediaId() {
        return this.mMediaId;
    }

    public int cAC() {
        if (this.jLv == null) {
            return 0;
        }
        return this.jLv.size();
    }

    public List<b> a(Comparator<b> comparator) {
        int cAC = cAC();
        if (cAC == 0) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(cAC);
        for (int i = 0; i < cAC; i++) {
            arrayList.add(this.jLv.get(i));
        }
        Collections.sort(arrayList, comparator);
        return arrayList;
    }

    public boolean cAD() {
        return this.jLw;
    }

    public String getSource() {
        return this.mSource;
    }

    public boolean equals(Object obj) {
        if (obj instanceof a) {
            a aVar = (a) obj;
            return f.equal(this.mMediaId, aVar.mMediaId) && this.jLw == aVar.jLw && f.equal(this.jLv, aVar.jLv);
        }
        return false;
    }

    public int hashCode() {
        return f.hashCode(this.mMediaId, Boolean.valueOf(this.jLw), this.jLv, this.mSource);
    }

    public String toString() {
        return String.format(null, "%s-%b-%s-%s", this.mMediaId, Boolean.valueOf(this.jLw), this.jLv, this.mSource);
    }

    /* loaded from: classes2.dex */
    public static final class b {
        @Nullable
        private final ImageRequest.CacheChoice jLm;
        private final int mHeight;
        private final Uri mUri;
        private final int mWidth;

        public b(Uri uri, int i, int i2, @Nullable ImageRequest.CacheChoice cacheChoice) {
            this.mUri = uri;
            this.mWidth = i;
            this.mHeight = i2;
            this.jLm = cacheChoice;
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
        public ImageRequest.CacheChoice cAm() {
            return this.jLm;
        }

        public boolean equals(Object obj) {
            if (obj instanceof b) {
                b bVar = (b) obj;
                return f.equal(this.mUri, bVar.mUri) && this.mWidth == bVar.mWidth && this.mHeight == bVar.mHeight && this.jLm == bVar.jLm;
            }
            return false;
        }

        public int hashCode() {
            return (((this.mUri.hashCode() * 31) + this.mWidth) * 31) + this.mHeight;
        }

        public String toString() {
            return String.format(null, "%dx%d %s %s", Integer.valueOf(this.mWidth), Integer.valueOf(this.mHeight), this.mUri, this.jLm);
        }
    }

    public static C0437a FD(String str) {
        return new C0437a(str);
    }

    /* renamed from: com.facebook.imagepipeline.request.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0437a {
        private List<b> jLv;
        private boolean jLw;
        private final String mMediaId;
        private String mSource;

        private C0437a(String str) {
            this.jLw = false;
            this.mSource = "request";
            this.mMediaId = str;
        }

        public C0437a a(Uri uri, int i, int i2, ImageRequest.CacheChoice cacheChoice) {
            if (this.jLv == null) {
                this.jLv = new ArrayList();
            }
            this.jLv.add(new b(uri, i, i2, cacheChoice));
            return this;
        }

        public C0437a ry(boolean z) {
            this.jLw = z;
            return this;
        }

        public C0437a FE(String str) {
            this.mSource = str;
            return this;
        }

        public a cAE() {
            return new a(this);
        }
    }
}

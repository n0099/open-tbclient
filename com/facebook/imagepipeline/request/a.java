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
    private final List<b> iuY;
    private final boolean iuZ;
    private final String mMediaId;
    private final String mSource;

    private a(C0366a c0366a) {
        this.mMediaId = c0366a.mMediaId;
        this.iuY = c0366a.iuY;
        this.iuZ = c0366a.iuZ;
        this.mSource = c0366a.mSource;
    }

    public String getMediaId() {
        return this.mMediaId;
    }

    public int caJ() {
        if (this.iuY == null) {
            return 0;
        }
        return this.iuY.size();
    }

    public List<b> a(Comparator<b> comparator) {
        int caJ = caJ();
        if (caJ == 0) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(caJ);
        for (int i = 0; i < caJ; i++) {
            arrayList.add(this.iuY.get(i));
        }
        Collections.sort(arrayList, comparator);
        return arrayList;
    }

    public boolean caK() {
        return this.iuZ;
    }

    public String getSource() {
        return this.mSource;
    }

    public boolean equals(Object obj) {
        if (obj instanceof a) {
            a aVar = (a) obj;
            return f.equal(this.mMediaId, aVar.mMediaId) && this.iuZ == aVar.iuZ && f.equal(this.iuY, aVar.iuY);
        }
        return false;
    }

    public int hashCode() {
        return f.hashCode(this.mMediaId, Boolean.valueOf(this.iuZ), this.iuY, this.mSource);
    }

    public String toString() {
        return String.format(null, "%s-%b-%s-%s", this.mMediaId, Boolean.valueOf(this.iuZ), this.iuY, this.mSource);
    }

    /* loaded from: classes2.dex */
    public static final class b {
        @Nullable
        private final ImageRequest.CacheChoice iuP;
        private final int mHeight;
        private final Uri mUri;
        private final int mWidth;

        public b(Uri uri, int i, int i2, @Nullable ImageRequest.CacheChoice cacheChoice) {
            this.mUri = uri;
            this.mWidth = i;
            this.mHeight = i2;
            this.iuP = cacheChoice;
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
        public ImageRequest.CacheChoice cat() {
            return this.iuP;
        }

        public boolean equals(Object obj) {
            if (obj instanceof b) {
                b bVar = (b) obj;
                return f.equal(this.mUri, bVar.mUri) && this.mWidth == bVar.mWidth && this.mHeight == bVar.mHeight && this.iuP == bVar.iuP;
            }
            return false;
        }

        public int hashCode() {
            return (((this.mUri.hashCode() * 31) + this.mWidth) * 31) + this.mHeight;
        }

        public String toString() {
            return String.format(null, "%dx%d %s %s", Integer.valueOf(this.mWidth), Integer.valueOf(this.mHeight), this.mUri, this.iuP);
        }
    }

    public static C0366a zt(String str) {
        return new C0366a(str);
    }

    /* renamed from: com.facebook.imagepipeline.request.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0366a {
        private List<b> iuY;
        private boolean iuZ;
        private final String mMediaId;
        private String mSource;

        private C0366a(String str) {
            this.iuZ = false;
            this.mSource = "request";
            this.mMediaId = str;
        }

        public C0366a a(Uri uri, int i, int i2, ImageRequest.CacheChoice cacheChoice) {
            if (this.iuY == null) {
                this.iuY = new ArrayList();
            }
            this.iuY.add(new b(uri, i, i2, cacheChoice));
            return this;
        }

        public C0366a pd(boolean z) {
            this.iuZ = z;
            return this;
        }

        public C0366a zu(String str) {
            this.mSource = str;
            return this;
        }

        public a caL() {
            return new a(this);
        }
    }
}

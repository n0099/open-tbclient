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
    private final List<b> kej;
    private final boolean kek;
    private final String mMediaId;
    private final String mSource;

    private a(C0456a c0456a) {
        this.mMediaId = c0456a.mMediaId;
        this.kej = c0456a.kej;
        this.kek = c0456a.kek;
        this.mSource = c0456a.mSource;
    }

    public String getMediaId() {
        return this.mMediaId;
    }

    public int cIy() {
        if (this.kej == null) {
            return 0;
        }
        return this.kej.size();
    }

    public List<b> a(Comparator<b> comparator) {
        int cIy = cIy();
        if (cIy == 0) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(cIy);
        for (int i = 0; i < cIy; i++) {
            arrayList.add(this.kej.get(i));
        }
        Collections.sort(arrayList, comparator);
        return arrayList;
    }

    public boolean cIz() {
        return this.kek;
    }

    public String getSource() {
        return this.mSource;
    }

    public boolean equals(Object obj) {
        if (obj instanceof a) {
            a aVar = (a) obj;
            return f.equal(this.mMediaId, aVar.mMediaId) && this.kek == aVar.kek && f.equal(this.kej, aVar.kej);
        }
        return false;
    }

    public int hashCode() {
        return f.hashCode(this.mMediaId, Boolean.valueOf(this.kek), this.kej, this.mSource);
    }

    public String toString() {
        return String.format(null, "%s-%b-%s-%s", this.mMediaId, Boolean.valueOf(this.kek), this.kej, this.mSource);
    }

    /* loaded from: classes2.dex */
    public static final class b {
        @Nullable
        private final ImageRequest.CacheChoice kea;
        private final int mHeight;
        private final Uri mUri;
        private final int mWidth;

        public b(Uri uri, int i, int i2, @Nullable ImageRequest.CacheChoice cacheChoice) {
            this.mUri = uri;
            this.mWidth = i;
            this.mHeight = i2;
            this.kea = cacheChoice;
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
        public ImageRequest.CacheChoice cIi() {
            return this.kea;
        }

        public boolean equals(Object obj) {
            if (obj instanceof b) {
                b bVar = (b) obj;
                return f.equal(this.mUri, bVar.mUri) && this.mWidth == bVar.mWidth && this.mHeight == bVar.mHeight && this.kea == bVar.kea;
            }
            return false;
        }

        public int hashCode() {
            return (((this.mUri.hashCode() * 31) + this.mWidth) * 31) + this.mHeight;
        }

        public String toString() {
            return String.format(null, "%dx%d %s %s", Integer.valueOf(this.mWidth), Integer.valueOf(this.mHeight), this.mUri, this.kea);
        }
    }

    public static C0456a GY(String str) {
        return new C0456a(str);
    }

    /* renamed from: com.facebook.imagepipeline.request.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0456a {
        private List<b> kej;
        private boolean kek;
        private final String mMediaId;
        private String mSource;

        private C0456a(String str) {
            this.kek = false;
            this.mSource = "request";
            this.mMediaId = str;
        }

        public C0456a a(Uri uri, int i, int i2, ImageRequest.CacheChoice cacheChoice) {
            if (this.kej == null) {
                this.kej = new ArrayList();
            }
            this.kej.add(new b(uri, i, i2, cacheChoice));
            return this;
        }

        public C0456a sn(boolean z) {
            this.kek = z;
            return this;
        }

        public C0456a GZ(String str) {
            this.mSource = str;
            return this;
        }

        public a cIA() {
            return new a(this);
        }
    }
}

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
    private final List<b> kmA;
    private final boolean kmB;
    private final String mMediaId;
    private final String mSource;

    private a(C0461a c0461a) {
        this.mMediaId = c0461a.mMediaId;
        this.kmA = c0461a.kmA;
        this.kmB = c0461a.kmB;
        this.mSource = c0461a.mSource;
    }

    public String getMediaId() {
        return this.mMediaId;
    }

    public int cLY() {
        if (this.kmA == null) {
            return 0;
        }
        return this.kmA.size();
    }

    public List<b> a(Comparator<b> comparator) {
        int cLY = cLY();
        if (cLY == 0) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(cLY);
        for (int i = 0; i < cLY; i++) {
            arrayList.add(this.kmA.get(i));
        }
        Collections.sort(arrayList, comparator);
        return arrayList;
    }

    public boolean cLZ() {
        return this.kmB;
    }

    public String getSource() {
        return this.mSource;
    }

    public boolean equals(Object obj) {
        if (obj instanceof a) {
            a aVar = (a) obj;
            return f.equal(this.mMediaId, aVar.mMediaId) && this.kmB == aVar.kmB && f.equal(this.kmA, aVar.kmA);
        }
        return false;
    }

    public int hashCode() {
        return f.L(this.mMediaId, Boolean.valueOf(this.kmB), this.kmA, this.mSource);
    }

    public String toString() {
        return String.format(null, "%s-%b-%s-%s", this.mMediaId, Boolean.valueOf(this.kmB), this.kmA, this.mSource);
    }

    /* loaded from: classes2.dex */
    public static final class b {
        @Nullable
        private final ImageRequest.CacheChoice kmr;
        private final int mHeight;
        private final Uri mUri;
        private final int mWidth;

        public b(Uri uri, int i, int i2, @Nullable ImageRequest.CacheChoice cacheChoice) {
            this.mUri = uri;
            this.mWidth = i;
            this.mHeight = i2;
            this.kmr = cacheChoice;
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
        public ImageRequest.CacheChoice cLI() {
            return this.kmr;
        }

        public boolean equals(Object obj) {
            if (obj instanceof b) {
                b bVar = (b) obj;
                return f.equal(this.mUri, bVar.mUri) && this.mWidth == bVar.mWidth && this.mHeight == bVar.mHeight && this.kmr == bVar.kmr;
            }
            return false;
        }

        public int hashCode() {
            return (((this.mUri.hashCode() * 31) + this.mWidth) * 31) + this.mHeight;
        }

        public String toString() {
            return String.format(null, "%dx%d %s %s", Integer.valueOf(this.mWidth), Integer.valueOf(this.mHeight), this.mUri, this.kmr);
        }
    }

    public static C0461a HV(String str) {
        return new C0461a(str);
    }

    /* renamed from: com.facebook.imagepipeline.request.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0461a {
        private List<b> kmA;
        private boolean kmB;
        private final String mMediaId;
        private String mSource;

        private C0461a(String str) {
            this.kmB = false;
            this.mSource = "request";
            this.mMediaId = str;
        }

        public C0461a a(Uri uri, int i, int i2, ImageRequest.CacheChoice cacheChoice) {
            if (this.kmA == null) {
                this.kmA = new ArrayList();
            }
            this.kmA.add(new b(uri, i, i2, cacheChoice));
            return this;
        }

        public C0461a sE(boolean z) {
            this.kmB = z;
            return this;
        }

        public C0461a HW(String str) {
            this.mSource = str;
            return this;
        }

        public a cMa() {
            return new a(this);
        }
    }
}

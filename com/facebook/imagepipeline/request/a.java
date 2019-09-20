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
    private final List<b> koX;
    private final boolean koY;
    private final String mMediaId;
    private final String mSource;

    private a(C0472a c0472a) {
        this.mMediaId = c0472a.mMediaId;
        this.koX = c0472a.koX;
        this.koY = c0472a.koY;
        this.mSource = c0472a.mSource;
    }

    public String getMediaId() {
        return this.mMediaId;
    }

    public int cMM() {
        if (this.koX == null) {
            return 0;
        }
        return this.koX.size();
    }

    public List<b> a(Comparator<b> comparator) {
        int cMM = cMM();
        if (cMM == 0) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(cMM);
        for (int i = 0; i < cMM; i++) {
            arrayList.add(this.koX.get(i));
        }
        Collections.sort(arrayList, comparator);
        return arrayList;
    }

    public boolean cMN() {
        return this.koY;
    }

    public String getSource() {
        return this.mSource;
    }

    public boolean equals(Object obj) {
        if (obj instanceof a) {
            a aVar = (a) obj;
            return f.equal(this.mMediaId, aVar.mMediaId) && this.koY == aVar.koY && f.equal(this.koX, aVar.koX);
        }
        return false;
    }

    public int hashCode() {
        return f.L(this.mMediaId, Boolean.valueOf(this.koY), this.koX, this.mSource);
    }

    public String toString() {
        return String.format(null, "%s-%b-%s-%s", this.mMediaId, Boolean.valueOf(this.koY), this.koX, this.mSource);
    }

    /* loaded from: classes2.dex */
    public static final class b {
        @Nullable
        private final ImageRequest.CacheChoice koO;
        private final int mHeight;
        private final Uri mUri;
        private final int mWidth;

        public b(Uri uri, int i, int i2, @Nullable ImageRequest.CacheChoice cacheChoice) {
            this.mUri = uri;
            this.mWidth = i;
            this.mHeight = i2;
            this.koO = cacheChoice;
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
        public ImageRequest.CacheChoice cMw() {
            return this.koO;
        }

        public boolean equals(Object obj) {
            if (obj instanceof b) {
                b bVar = (b) obj;
                return f.equal(this.mUri, bVar.mUri) && this.mWidth == bVar.mWidth && this.mHeight == bVar.mHeight && this.koO == bVar.koO;
            }
            return false;
        }

        public int hashCode() {
            return (((this.mUri.hashCode() * 31) + this.mWidth) * 31) + this.mHeight;
        }

        public String toString() {
            return String.format(null, "%dx%d %s %s", Integer.valueOf(this.mWidth), Integer.valueOf(this.mHeight), this.mUri, this.koO);
        }
    }

    public static C0472a Iv(String str) {
        return new C0472a(str);
    }

    /* renamed from: com.facebook.imagepipeline.request.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0472a {
        private List<b> koX;
        private boolean koY;
        private final String mMediaId;
        private String mSource;

        private C0472a(String str) {
            this.koY = false;
            this.mSource = "request";
            this.mMediaId = str;
        }

        public C0472a a(Uri uri, int i, int i2, ImageRequest.CacheChoice cacheChoice) {
            if (this.koX == null) {
                this.koX = new ArrayList();
            }
            this.koX.add(new b(uri, i, i2, cacheChoice));
            return this;
        }

        public C0472a sH(boolean z) {
            this.koY = z;
            return this;
        }

        public C0472a Iw(String str) {
            this.mSource = str;
            return this;
        }

        public a cMO() {
            return new a(this);
        }
    }
}

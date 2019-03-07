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
    private final List<b> jLQ;
    private final boolean jLR;
    private final String mMediaId;
    private final String mSource;

    private a(C0341a c0341a) {
        this.mMediaId = c0341a.mMediaId;
        this.jLQ = c0341a.jLQ;
        this.jLR = c0341a.jLR;
        this.mSource = c0341a.mSource;
    }

    public String getMediaId() {
        return this.mMediaId;
    }

    public int cAw() {
        if (this.jLQ == null) {
            return 0;
        }
        return this.jLQ.size();
    }

    public List<b> a(Comparator<b> comparator) {
        int cAw = cAw();
        if (cAw == 0) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(cAw);
        for (int i = 0; i < cAw; i++) {
            arrayList.add(this.jLQ.get(i));
        }
        Collections.sort(arrayList, comparator);
        return arrayList;
    }

    public boolean cAx() {
        return this.jLR;
    }

    public String getSource() {
        return this.mSource;
    }

    public boolean equals(Object obj) {
        if (obj instanceof a) {
            a aVar = (a) obj;
            return f.equal(this.mMediaId, aVar.mMediaId) && this.jLR == aVar.jLR && f.equal(this.jLQ, aVar.jLQ);
        }
        return false;
    }

    public int hashCode() {
        return f.hashCode(this.mMediaId, Boolean.valueOf(this.jLR), this.jLQ, this.mSource);
    }

    public String toString() {
        return String.format(null, "%s-%b-%s-%s", this.mMediaId, Boolean.valueOf(this.jLR), this.jLQ, this.mSource);
    }

    /* loaded from: classes2.dex */
    public static final class b {
        @Nullable
        private final ImageRequest.CacheChoice jLH;
        private final int mHeight;
        private final Uri mUri;
        private final int mWidth;

        public b(Uri uri, int i, int i2, @Nullable ImageRequest.CacheChoice cacheChoice) {
            this.mUri = uri;
            this.mWidth = i;
            this.mHeight = i2;
            this.jLH = cacheChoice;
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
        public ImageRequest.CacheChoice cAg() {
            return this.jLH;
        }

        public boolean equals(Object obj) {
            if (obj instanceof b) {
                b bVar = (b) obj;
                return f.equal(this.mUri, bVar.mUri) && this.mWidth == bVar.mWidth && this.mHeight == bVar.mHeight && this.jLH == bVar.jLH;
            }
            return false;
        }

        public int hashCode() {
            return (((this.mUri.hashCode() * 31) + this.mWidth) * 31) + this.mHeight;
        }

        public String toString() {
            return String.format(null, "%dx%d %s %s", Integer.valueOf(this.mWidth), Integer.valueOf(this.mHeight), this.mUri, this.jLH);
        }
    }

    public static C0341a FM(String str) {
        return new C0341a(str);
    }

    /* renamed from: com.facebook.imagepipeline.request.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0341a {
        private List<b> jLQ;
        private boolean jLR;
        private final String mMediaId;
        private String mSource;

        private C0341a(String str) {
            this.jLR = false;
            this.mSource = "request";
            this.mMediaId = str;
        }

        public C0341a a(Uri uri, int i, int i2, ImageRequest.CacheChoice cacheChoice) {
            if (this.jLQ == null) {
                this.jLQ = new ArrayList();
            }
            this.jLQ.add(new b(uri, i, i2, cacheChoice));
            return this;
        }

        public C0341a ry(boolean z) {
            this.jLR = z;
            return this;
        }

        public C0341a FN(String str) {
            this.mSource = str;
            return this;
        }

        public a cAy() {
            return new a(this);
        }
    }
}

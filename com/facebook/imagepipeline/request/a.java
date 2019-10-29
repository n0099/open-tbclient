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
    private final List<b> knj;
    private final boolean knk;
    private final String mMediaId;
    private final String mSource;

    private a(C0567a c0567a) {
        this.mMediaId = c0567a.mMediaId;
        this.knj = c0567a.knj;
        this.knk = c0567a.knk;
        this.mSource = c0567a.mSource;
    }

    public String getMediaId() {
        return this.mMediaId;
    }

    public int cJJ() {
        if (this.knj == null) {
            return 0;
        }
        return this.knj.size();
    }

    public List<b> a(Comparator<b> comparator) {
        int cJJ = cJJ();
        if (cJJ == 0) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(cJJ);
        for (int i = 0; i < cJJ; i++) {
            arrayList.add(this.knj.get(i));
        }
        Collections.sort(arrayList, comparator);
        return arrayList;
    }

    public boolean cJK() {
        return this.knk;
    }

    public String getSource() {
        return this.mSource;
    }

    public boolean equals(Object obj) {
        if (obj instanceof a) {
            a aVar = (a) obj;
            return f.equal(this.mMediaId, aVar.mMediaId) && this.knk == aVar.knk && f.equal(this.knj, aVar.knj);
        }
        return false;
    }

    public int hashCode() {
        return f.I(this.mMediaId, Boolean.valueOf(this.knk), this.knj, this.mSource);
    }

    public String toString() {
        return String.format(null, "%s-%b-%s-%s", this.mMediaId, Boolean.valueOf(this.knk), this.knj, this.mSource);
    }

    /* loaded from: classes2.dex */
    public static final class b {
        @Nullable
        private final ImageRequest.CacheChoice kna;
        private final int mHeight;
        private final Uri mUri;
        private final int mWidth;

        public b(Uri uri, int i, int i2, @Nullable ImageRequest.CacheChoice cacheChoice) {
            this.mUri = uri;
            this.mWidth = i;
            this.mHeight = i2;
            this.kna = cacheChoice;
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
        public ImageRequest.CacheChoice cJt() {
            return this.kna;
        }

        public boolean equals(Object obj) {
            if (obj instanceof b) {
                b bVar = (b) obj;
                return f.equal(this.mUri, bVar.mUri) && this.mWidth == bVar.mWidth && this.mHeight == bVar.mHeight && this.kna == bVar.kna;
            }
            return false;
        }

        public int hashCode() {
            return (((this.mUri.hashCode() * 31) + this.mWidth) * 31) + this.mHeight;
        }

        public String toString() {
            return String.format(null, "%dx%d %s %s", Integer.valueOf(this.mWidth), Integer.valueOf(this.mHeight), this.mUri, this.kna);
        }
    }

    public static C0567a GM(String str) {
        return new C0567a(str);
    }

    /* renamed from: com.facebook.imagepipeline.request.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0567a {
        private List<b> knj;
        private boolean knk;
        private final String mMediaId;
        private String mSource;

        private C0567a(String str) {
            this.knk = false;
            this.mSource = "request";
            this.mMediaId = str;
        }

        public C0567a a(Uri uri, int i, int i2, ImageRequest.CacheChoice cacheChoice) {
            if (this.knj == null) {
                this.knj = new ArrayList();
            }
            this.knj.add(new b(uri, i, i2, cacheChoice));
            return this;
        }

        public C0567a sm(boolean z) {
            this.knk = z;
            return this;
        }

        public C0567a GN(String str) {
            this.mSource = str;
            return this;
        }

        public a cJL() {
            return new a(this);
        }
    }
}

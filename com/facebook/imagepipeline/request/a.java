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
    private final List<b> jMj;
    private final boolean jMk;
    private final String mMediaId;
    private final String mSource;

    private a(C0344a c0344a) {
        this.mMediaId = c0344a.mMediaId;
        this.jMj = c0344a.jMj;
        this.jMk = c0344a.jMk;
        this.mSource = c0344a.mSource;
    }

    public String getMediaId() {
        return this.mMediaId;
    }

    public int cAG() {
        if (this.jMj == null) {
            return 0;
        }
        return this.jMj.size();
    }

    public List<b> a(Comparator<b> comparator) {
        int cAG = cAG();
        if (cAG == 0) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(cAG);
        for (int i = 0; i < cAG; i++) {
            arrayList.add(this.jMj.get(i));
        }
        Collections.sort(arrayList, comparator);
        return arrayList;
    }

    public boolean cAH() {
        return this.jMk;
    }

    public String getSource() {
        return this.mSource;
    }

    public boolean equals(Object obj) {
        if (obj instanceof a) {
            a aVar = (a) obj;
            return f.equal(this.mMediaId, aVar.mMediaId) && this.jMk == aVar.jMk && f.equal(this.jMj, aVar.jMj);
        }
        return false;
    }

    public int hashCode() {
        return f.hashCode(this.mMediaId, Boolean.valueOf(this.jMk), this.jMj, this.mSource);
    }

    public String toString() {
        return String.format(null, "%s-%b-%s-%s", this.mMediaId, Boolean.valueOf(this.jMk), this.jMj, this.mSource);
    }

    /* loaded from: classes2.dex */
    public static final class b {
        @Nullable
        private final ImageRequest.CacheChoice jMa;
        private final int mHeight;
        private final Uri mUri;
        private final int mWidth;

        public b(Uri uri, int i, int i2, @Nullable ImageRequest.CacheChoice cacheChoice) {
            this.mUri = uri;
            this.mWidth = i;
            this.mHeight = i2;
            this.jMa = cacheChoice;
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
        public ImageRequest.CacheChoice cAq() {
            return this.jMa;
        }

        public boolean equals(Object obj) {
            if (obj instanceof b) {
                b bVar = (b) obj;
                return f.equal(this.mUri, bVar.mUri) && this.mWidth == bVar.mWidth && this.mHeight == bVar.mHeight && this.jMa == bVar.jMa;
            }
            return false;
        }

        public int hashCode() {
            return (((this.mUri.hashCode() * 31) + this.mWidth) * 31) + this.mHeight;
        }

        public String toString() {
            return String.format(null, "%dx%d %s %s", Integer.valueOf(this.mWidth), Integer.valueOf(this.mHeight), this.mUri, this.jMa);
        }
    }

    public static C0344a FP(String str) {
        return new C0344a(str);
    }

    /* renamed from: com.facebook.imagepipeline.request.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0344a {
        private List<b> jMj;
        private boolean jMk;
        private final String mMediaId;
        private String mSource;

        private C0344a(String str) {
            this.jMk = false;
            this.mSource = "request";
            this.mMediaId = str;
        }

        public C0344a a(Uri uri, int i, int i2, ImageRequest.CacheChoice cacheChoice) {
            if (this.jMj == null) {
                this.jMj = new ArrayList();
            }
            this.jMj.add(new b(uri, i, i2, cacheChoice));
            return this;
        }

        public C0344a ry(boolean z) {
            this.jMk = z;
            return this;
        }

        public C0344a FQ(String str) {
            this.mSource = str;
            return this;
        }

        public a cAI() {
            return new a(this);
        }
    }
}

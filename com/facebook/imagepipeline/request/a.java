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
    private final List<b> jMb;
    private final boolean jMc;
    private final String mMediaId;
    private final String mSource;

    private a(C0437a c0437a) {
        this.mMediaId = c0437a.mMediaId;
        this.jMb = c0437a.jMb;
        this.jMc = c0437a.jMc;
        this.mSource = c0437a.mSource;
    }

    public String getMediaId() {
        return this.mMediaId;
    }

    public int cAJ() {
        if (this.jMb == null) {
            return 0;
        }
        return this.jMb.size();
    }

    public List<b> a(Comparator<b> comparator) {
        int cAJ = cAJ();
        if (cAJ == 0) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(cAJ);
        for (int i = 0; i < cAJ; i++) {
            arrayList.add(this.jMb.get(i));
        }
        Collections.sort(arrayList, comparator);
        return arrayList;
    }

    public boolean cAK() {
        return this.jMc;
    }

    public String getSource() {
        return this.mSource;
    }

    public boolean equals(Object obj) {
        if (obj instanceof a) {
            a aVar = (a) obj;
            return f.equal(this.mMediaId, aVar.mMediaId) && this.jMc == aVar.jMc && f.equal(this.jMb, aVar.jMb);
        }
        return false;
    }

    public int hashCode() {
        return f.hashCode(this.mMediaId, Boolean.valueOf(this.jMc), this.jMb, this.mSource);
    }

    public String toString() {
        return String.format(null, "%s-%b-%s-%s", this.mMediaId, Boolean.valueOf(this.jMc), this.jMb, this.mSource);
    }

    /* loaded from: classes2.dex */
    public static final class b {
        @Nullable
        private final ImageRequest.CacheChoice jLS;
        private final int mHeight;
        private final Uri mUri;
        private final int mWidth;

        public b(Uri uri, int i, int i2, @Nullable ImageRequest.CacheChoice cacheChoice) {
            this.mUri = uri;
            this.mWidth = i;
            this.mHeight = i2;
            this.jLS = cacheChoice;
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
        public ImageRequest.CacheChoice cAt() {
            return this.jLS;
        }

        public boolean equals(Object obj) {
            if (obj instanceof b) {
                b bVar = (b) obj;
                return f.equal(this.mUri, bVar.mUri) && this.mWidth == bVar.mWidth && this.mHeight == bVar.mHeight && this.jLS == bVar.jLS;
            }
            return false;
        }

        public int hashCode() {
            return (((this.mUri.hashCode() * 31) + this.mWidth) * 31) + this.mHeight;
        }

        public String toString() {
            return String.format(null, "%dx%d %s %s", Integer.valueOf(this.mWidth), Integer.valueOf(this.mHeight), this.mUri, this.jLS);
        }
    }

    public static C0437a FN(String str) {
        return new C0437a(str);
    }

    /* renamed from: com.facebook.imagepipeline.request.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0437a {
        private List<b> jMb;
        private boolean jMc;
        private final String mMediaId;
        private String mSource;

        private C0437a(String str) {
            this.jMc = false;
            this.mSource = "request";
            this.mMediaId = str;
        }

        public C0437a a(Uri uri, int i, int i2, ImageRequest.CacheChoice cacheChoice) {
            if (this.jMb == null) {
                this.jMb = new ArrayList();
            }
            this.jMb.add(new b(uri, i, i2, cacheChoice));
            return this;
        }

        public C0437a ry(boolean z) {
            this.jMc = z;
            return this;
        }

        public C0437a FO(String str) {
            this.mSource = str;
            return this;
        }

        public a cAL() {
            return new a(this);
        }
    }
}

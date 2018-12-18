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
    private final List<b> irO;
    private final boolean irP;
    private final String mMediaId;
    private final String mSource;

    private a(C0366a c0366a) {
        this.mMediaId = c0366a.mMediaId;
        this.irO = c0366a.irO;
        this.irP = c0366a.irP;
        this.mSource = c0366a.mSource;
    }

    public String getMediaId() {
        return this.mMediaId;
    }

    public int bZS() {
        if (this.irO == null) {
            return 0;
        }
        return this.irO.size();
    }

    public List<b> a(Comparator<b> comparator) {
        int bZS = bZS();
        if (bZS == 0) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(bZS);
        for (int i = 0; i < bZS; i++) {
            arrayList.add(this.irO.get(i));
        }
        Collections.sort(arrayList, comparator);
        return arrayList;
    }

    public boolean bZT() {
        return this.irP;
    }

    public String getSource() {
        return this.mSource;
    }

    public boolean equals(Object obj) {
        if (obj instanceof a) {
            a aVar = (a) obj;
            return f.equal(this.mMediaId, aVar.mMediaId) && this.irP == aVar.irP && f.equal(this.irO, aVar.irO);
        }
        return false;
    }

    public int hashCode() {
        return f.hashCode(this.mMediaId, Boolean.valueOf(this.irP), this.irO, this.mSource);
    }

    public String toString() {
        return String.format(null, "%s-%b-%s-%s", this.mMediaId, Boolean.valueOf(this.irP), this.irO, this.mSource);
    }

    /* loaded from: classes2.dex */
    public static final class b {
        @Nullable
        private final ImageRequest.CacheChoice irF;
        private final int mHeight;
        private final Uri mUri;
        private final int mWidth;

        public b(Uri uri, int i, int i2, @Nullable ImageRequest.CacheChoice cacheChoice) {
            this.mUri = uri;
            this.mWidth = i;
            this.mHeight = i2;
            this.irF = cacheChoice;
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
        public ImageRequest.CacheChoice bZC() {
            return this.irF;
        }

        public boolean equals(Object obj) {
            if (obj instanceof b) {
                b bVar = (b) obj;
                return f.equal(this.mUri, bVar.mUri) && this.mWidth == bVar.mWidth && this.mHeight == bVar.mHeight && this.irF == bVar.irF;
            }
            return false;
        }

        public int hashCode() {
            return (((this.mUri.hashCode() * 31) + this.mWidth) * 31) + this.mHeight;
        }

        public String toString() {
            return String.format(null, "%dx%d %s %s", Integer.valueOf(this.mWidth), Integer.valueOf(this.mHeight), this.mUri, this.irF);
        }
    }

    public static C0366a zq(String str) {
        return new C0366a(str);
    }

    /* renamed from: com.facebook.imagepipeline.request.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0366a {
        private List<b> irO;
        private boolean irP;
        private final String mMediaId;
        private String mSource;

        private C0366a(String str) {
            this.irP = false;
            this.mSource = "request";
            this.mMediaId = str;
        }

        public C0366a a(Uri uri, int i, int i2, ImageRequest.CacheChoice cacheChoice) {
            if (this.irO == null) {
                this.irO = new ArrayList();
            }
            this.irO.add(new b(uri, i, i2, cacheChoice));
            return this;
        }

        public C0366a pa(boolean z) {
            this.irP = z;
            return this;
        }

        public C0366a zr(String str) {
            this.mSource = str;
            return this;
        }

        public a bZU() {
            return new a(this);
        }
    }
}

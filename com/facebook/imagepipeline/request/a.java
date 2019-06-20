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
    private final List<b> ken;
    private final boolean keo;
    private final String mMediaId;
    private final String mSource;

    private a(C0456a c0456a) {
        this.mMediaId = c0456a.mMediaId;
        this.ken = c0456a.ken;
        this.keo = c0456a.keo;
        this.mSource = c0456a.mSource;
    }

    public String getMediaId() {
        return this.mMediaId;
    }

    public int cIz() {
        if (this.ken == null) {
            return 0;
        }
        return this.ken.size();
    }

    public List<b> a(Comparator<b> comparator) {
        int cIz = cIz();
        if (cIz == 0) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(cIz);
        for (int i = 0; i < cIz; i++) {
            arrayList.add(this.ken.get(i));
        }
        Collections.sort(arrayList, comparator);
        return arrayList;
    }

    public boolean cIA() {
        return this.keo;
    }

    public String getSource() {
        return this.mSource;
    }

    public boolean equals(Object obj) {
        if (obj instanceof a) {
            a aVar = (a) obj;
            return f.equal(this.mMediaId, aVar.mMediaId) && this.keo == aVar.keo && f.equal(this.ken, aVar.ken);
        }
        return false;
    }

    public int hashCode() {
        return f.hashCode(this.mMediaId, Boolean.valueOf(this.keo), this.ken, this.mSource);
    }

    public String toString() {
        return String.format(null, "%s-%b-%s-%s", this.mMediaId, Boolean.valueOf(this.keo), this.ken, this.mSource);
    }

    /* loaded from: classes2.dex */
    public static final class b {
        @Nullable
        private final ImageRequest.CacheChoice kee;
        private final int mHeight;
        private final Uri mUri;
        private final int mWidth;

        public b(Uri uri, int i, int i2, @Nullable ImageRequest.CacheChoice cacheChoice) {
            this.mUri = uri;
            this.mWidth = i;
            this.mHeight = i2;
            this.kee = cacheChoice;
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
        public ImageRequest.CacheChoice cIj() {
            return this.kee;
        }

        public boolean equals(Object obj) {
            if (obj instanceof b) {
                b bVar = (b) obj;
                return f.equal(this.mUri, bVar.mUri) && this.mWidth == bVar.mWidth && this.mHeight == bVar.mHeight && this.kee == bVar.kee;
            }
            return false;
        }

        public int hashCode() {
            return (((this.mUri.hashCode() * 31) + this.mWidth) * 31) + this.mHeight;
        }

        public String toString() {
            return String.format(null, "%dx%d %s %s", Integer.valueOf(this.mWidth), Integer.valueOf(this.mHeight), this.mUri, this.kee);
        }
    }

    public static C0456a Ha(String str) {
        return new C0456a(str);
    }

    /* renamed from: com.facebook.imagepipeline.request.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0456a {
        private List<b> ken;
        private boolean keo;
        private final String mMediaId;
        private String mSource;

        private C0456a(String str) {
            this.keo = false;
            this.mSource = "request";
            this.mMediaId = str;
        }

        public C0456a a(Uri uri, int i, int i2, ImageRequest.CacheChoice cacheChoice) {
            if (this.ken == null) {
                this.ken = new ArrayList();
            }
            this.ken.add(new b(uri, i, i2, cacheChoice));
            return this;
        }

        public C0456a so(boolean z) {
            this.keo = z;
            return this;
        }

        public C0456a Hb(String str) {
            this.mSource = str;
            return this;
        }

        public a cIB() {
            return new a(this);
        }
    }
}

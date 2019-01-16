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
    private final List<b> iwf;
    private final boolean iwg;
    private final String mMediaId;
    private final String mSource;

    private a(C0365a c0365a) {
        this.mMediaId = c0365a.mMediaId;
        this.iwf = c0365a.iwf;
        this.iwg = c0365a.iwg;
        this.mSource = c0365a.mSource;
    }

    public String getMediaId() {
        return this.mMediaId;
    }

    public int cbr() {
        if (this.iwf == null) {
            return 0;
        }
        return this.iwf.size();
    }

    public List<b> a(Comparator<b> comparator) {
        int cbr = cbr();
        if (cbr == 0) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(cbr);
        for (int i = 0; i < cbr; i++) {
            arrayList.add(this.iwf.get(i));
        }
        Collections.sort(arrayList, comparator);
        return arrayList;
    }

    public boolean cbs() {
        return this.iwg;
    }

    public String getSource() {
        return this.mSource;
    }

    public boolean equals(Object obj) {
        if (obj instanceof a) {
            a aVar = (a) obj;
            return f.equal(this.mMediaId, aVar.mMediaId) && this.iwg == aVar.iwg && f.equal(this.iwf, aVar.iwf);
        }
        return false;
    }

    public int hashCode() {
        return f.hashCode(this.mMediaId, Boolean.valueOf(this.iwg), this.iwf, this.mSource);
    }

    public String toString() {
        return String.format(null, "%s-%b-%s-%s", this.mMediaId, Boolean.valueOf(this.iwg), this.iwf, this.mSource);
    }

    /* loaded from: classes2.dex */
    public static final class b {
        @Nullable
        private final ImageRequest.CacheChoice ivW;
        private final int mHeight;
        private final Uri mUri;
        private final int mWidth;

        public b(Uri uri, int i, int i2, @Nullable ImageRequest.CacheChoice cacheChoice) {
            this.mUri = uri;
            this.mWidth = i;
            this.mHeight = i2;
            this.ivW = cacheChoice;
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
        public ImageRequest.CacheChoice cbb() {
            return this.ivW;
        }

        public boolean equals(Object obj) {
            if (obj instanceof b) {
                b bVar = (b) obj;
                return f.equal(this.mUri, bVar.mUri) && this.mWidth == bVar.mWidth && this.mHeight == bVar.mHeight && this.ivW == bVar.ivW;
            }
            return false;
        }

        public int hashCode() {
            return (((this.mUri.hashCode() * 31) + this.mWidth) * 31) + this.mHeight;
        }

        public String toString() {
            return String.format(null, "%dx%d %s %s", Integer.valueOf(this.mWidth), Integer.valueOf(this.mHeight), this.mUri, this.ivW);
        }
    }

    public static C0365a zJ(String str) {
        return new C0365a(str);
    }

    /* renamed from: com.facebook.imagepipeline.request.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0365a {
        private List<b> iwf;
        private boolean iwg;
        private final String mMediaId;
        private String mSource;

        private C0365a(String str) {
            this.iwg = false;
            this.mSource = "request";
            this.mMediaId = str;
        }

        public C0365a a(Uri uri, int i, int i2, ImageRequest.CacheChoice cacheChoice) {
            if (this.iwf == null) {
                this.iwf = new ArrayList();
            }
            this.iwf.add(new b(uri, i, i2, cacheChoice));
            return this;
        }

        public C0365a pe(boolean z) {
            this.iwg = z;
            return this;
        }

        public C0365a zK(String str) {
            this.mSource = str;
            return this;
        }

        public a cbt() {
            return new a(this);
        }
    }
}

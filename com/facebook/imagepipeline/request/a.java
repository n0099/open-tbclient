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
    private final List<b> ikC;
    private final boolean ikD;
    private final String mMediaId;
    private final String mSource;

    private a(C0352a c0352a) {
        this.mMediaId = c0352a.mMediaId;
        this.ikC = c0352a.ikC;
        this.ikD = c0352a.ikD;
        this.mSource = c0352a.mSource;
    }

    public String getMediaId() {
        return this.mMediaId;
    }

    public int bXN() {
        if (this.ikC == null) {
            return 0;
        }
        return this.ikC.size();
    }

    public List<b> a(Comparator<b> comparator) {
        int bXN = bXN();
        if (bXN == 0) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(bXN);
        for (int i = 0; i < bXN; i++) {
            arrayList.add(this.ikC.get(i));
        }
        Collections.sort(arrayList, comparator);
        return arrayList;
    }

    public boolean bXO() {
        return this.ikD;
    }

    public String getSource() {
        return this.mSource;
    }

    public boolean equals(Object obj) {
        if (obj instanceof a) {
            a aVar = (a) obj;
            return f.equal(this.mMediaId, aVar.mMediaId) && this.ikD == aVar.ikD && f.equal(this.ikC, aVar.ikC);
        }
        return false;
    }

    public int hashCode() {
        return f.hashCode(this.mMediaId, Boolean.valueOf(this.ikD), this.ikC, this.mSource);
    }

    public String toString() {
        return String.format(null, "%s-%b-%s-%s", this.mMediaId, Boolean.valueOf(this.ikD), this.ikC, this.mSource);
    }

    /* loaded from: classes2.dex */
    public static final class b {
        @Nullable
        private final ImageRequest.CacheChoice ikt;
        private final int mHeight;
        private final Uri mUri;
        private final int mWidth;

        public b(Uri uri, int i, int i2, @Nullable ImageRequest.CacheChoice cacheChoice) {
            this.mUri = uri;
            this.mWidth = i;
            this.mHeight = i2;
            this.ikt = cacheChoice;
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
        public ImageRequest.CacheChoice bXx() {
            return this.ikt;
        }

        public boolean equals(Object obj) {
            if (obj instanceof b) {
                b bVar = (b) obj;
                return f.equal(this.mUri, bVar.mUri) && this.mWidth == bVar.mWidth && this.mHeight == bVar.mHeight && this.ikt == bVar.ikt;
            }
            return false;
        }

        public int hashCode() {
            return (((this.mUri.hashCode() * 31) + this.mWidth) * 31) + this.mHeight;
        }

        public String toString() {
            return String.format(null, "%dx%d %s %s", Integer.valueOf(this.mWidth), Integer.valueOf(this.mHeight), this.mUri, this.ikt);
        }
    }

    public static C0352a yN(String str) {
        return new C0352a(str);
    }

    /* renamed from: com.facebook.imagepipeline.request.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0352a {
        private List<b> ikC;
        private boolean ikD;
        private final String mMediaId;
        private String mSource;

        private C0352a(String str) {
            this.ikD = false;
            this.mSource = "request";
            this.mMediaId = str;
        }

        public C0352a a(Uri uri, int i, int i2, ImageRequest.CacheChoice cacheChoice) {
            if (this.ikC == null) {
                this.ikC = new ArrayList();
            }
            this.ikC.add(new b(uri, i, i2, cacheChoice));
            return this;
        }

        public C0352a oY(boolean z) {
            this.ikD = z;
            return this;
        }

        public C0352a yO(String str) {
            this.mSource = str;
            return this;
        }

        public a bXP() {
            return new a(this);
        }
    }
}

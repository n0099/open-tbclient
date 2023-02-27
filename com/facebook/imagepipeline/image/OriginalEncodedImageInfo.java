package com.facebook.imagepipeline.image;

import android.net.Uri;
import javax.annotation.Nullable;
/* loaded from: classes7.dex */
public class OriginalEncodedImageInfo {
    public static final OriginalEncodedImageInfo EMPTY = new OriginalEncodedImageInfo();
    @Nullable
    public final Object mCallerContext;
    public final int mHeight;
    @Nullable
    public final EncodedImageOrigin mOrigin;
    public final int mSize;
    @Nullable
    public final Uri mUri;
    public final int mWidth;

    public OriginalEncodedImageInfo() {
        this.mUri = null;
        this.mOrigin = EncodedImageOrigin.NOT_SET;
        this.mCallerContext = null;
        this.mWidth = -1;
        this.mHeight = -1;
        this.mSize = -1;
    }

    @Nullable
    public Object getCallerContext() {
        return this.mCallerContext;
    }

    public int getHeight() {
        return this.mHeight;
    }

    public EncodedImageOrigin getOrigin() {
        return this.mOrigin;
    }

    public int getSize() {
        return this.mSize;
    }

    @Nullable
    public Uri getUri() {
        return this.mUri;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public OriginalEncodedImageInfo(Uri uri, EncodedImageOrigin encodedImageOrigin, @Nullable Object obj, int i, int i2, int i3) {
        this.mUri = uri;
        this.mOrigin = encodedImageOrigin;
        this.mCallerContext = obj;
        this.mWidth = i;
        this.mHeight = i2;
        this.mSize = i3;
    }
}

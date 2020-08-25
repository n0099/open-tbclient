package com.tb.airbnb.lottie;

import android.graphics.Bitmap;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
/* loaded from: classes7.dex */
public class g {
    private final String BD;
    @Nullable
    private Bitmap bitmap;
    private final String fileName;
    private final int height;
    private final String id;
    private final int width;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public g(int i, int i2, String str, String str2, String str3) {
        this.width = i;
        this.height = i2;
        this.id = str;
        this.fileName = str2;
        this.BD = str3;
    }

    public String getId() {
        return this.id;
    }

    public String getFileName() {
        return this.fileName;
    }

    public String iL() {
        return this.BD;
    }

    @Nullable
    public Bitmap getBitmap() {
        return this.bitmap;
    }

    public void setBitmap(@Nullable Bitmap bitmap) {
        this.bitmap = bitmap;
    }
}

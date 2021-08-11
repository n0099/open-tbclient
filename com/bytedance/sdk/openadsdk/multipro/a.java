package com.bytedance.sdk.openadsdk.multipro;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
/* loaded from: classes9.dex */
public interface a {
    int a(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String str, @Nullable String[] strArr);

    int a(@NonNull Uri uri, @Nullable String str, @Nullable String[] strArr);

    Cursor a(@NonNull Uri uri, @Nullable String[] strArr, @Nullable String str, @Nullable String[] strArr2, @Nullable String str2);

    Uri a(@NonNull Uri uri, @Nullable ContentValues contentValues);

    @NonNull
    String a();

    String a(@NonNull Uri uri);

    void a(Context context);

    void b();
}

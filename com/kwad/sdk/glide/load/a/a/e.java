package com.kwad.sdk.glide.load.a.a;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.webkit.sdk.LoadErrorCode;
import com.bumptech.glide.load.data.mediastore.ThumbnailStreamOpener;
import com.kwad.sdk.glide.load.ImageHeaderParser;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
/* loaded from: classes7.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public static final a f36021a = new a();

    /* renamed from: b  reason: collision with root package name */
    public final a f36022b;

    /* renamed from: c  reason: collision with root package name */
    public final d f36023c;

    /* renamed from: d  reason: collision with root package name */
    public final com.kwad.sdk.glide.load.engine.bitmap_recycle.b f36024d;

    /* renamed from: e  reason: collision with root package name */
    public final ContentResolver f36025e;

    /* renamed from: f  reason: collision with root package name */
    public final List<ImageHeaderParser> f36026f;

    public e(List<ImageHeaderParser> list, a aVar, d dVar, com.kwad.sdk.glide.load.engine.bitmap_recycle.b bVar, ContentResolver contentResolver) {
        this.f36022b = aVar;
        this.f36023c = dVar;
        this.f36024d = bVar;
        this.f36025e = contentResolver;
        this.f36026f = list;
    }

    public e(List<ImageHeaderParser> list, d dVar, com.kwad.sdk.glide.load.engine.bitmap_recycle.b bVar, ContentResolver contentResolver) {
        this(list, f36021a, dVar, bVar, contentResolver);
    }

    private boolean a(File file) {
        return this.f36022b.a(file) && 0 < this.f36022b.b(file);
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE] complete} */
    @Nullable
    private String c(@NonNull Uri uri) {
        Cursor a2 = this.f36023c.a(uri);
        if (a2 != null) {
            try {
                if (a2.moveToFirst()) {
                    return a2.getString(0);
                }
            } finally {
                if (a2 != null) {
                    a2.close();
                }
            }
        }
        if (a2 != null) {
            a2.close();
        }
        return null;
    }

    public int a(Uri uri) {
        InputStream inputStream = null;
        try {
            try {
                inputStream = this.f36025e.openInputStream(uri);
                int b2 = com.kwad.sdk.glide.load.b.b(this.f36026f, inputStream, this.f36024d);
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException unused) {
                    }
                }
                return b2;
            } catch (Throwable th) {
                if (0 != 0) {
                    try {
                        inputStream.close();
                    } catch (IOException unused2) {
                    }
                }
                throw th;
            }
        } catch (IOException | NullPointerException e2) {
            if (Log.isLoggable(ThumbnailStreamOpener.TAG, 3)) {
                Log.d(ThumbnailStreamOpener.TAG, "Failed to open uri: " + uri, e2);
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                    return -1;
                } catch (IOException unused3) {
                    return -1;
                }
            }
            return -1;
        }
    }

    public InputStream b(Uri uri) {
        String c2 = c(uri);
        if (TextUtils.isEmpty(c2)) {
            return null;
        }
        File a2 = this.f36022b.a(c2);
        if (a(a2)) {
            Uri fromFile = Uri.fromFile(a2);
            try {
                return this.f36025e.openInputStream(fromFile);
            } catch (NullPointerException e2) {
                throw ((FileNotFoundException) new FileNotFoundException("NPE opening uri: " + uri + LoadErrorCode.TOKEN_NEXT + fromFile).initCause(e2));
            }
        }
        return null;
    }
}

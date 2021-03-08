package com.kwad.sdk.glide.load.a.a;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.glide.load.ImageHeaderParser;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
/* loaded from: classes3.dex */
class e {

    /* renamed from: a  reason: collision with root package name */
    private static final a f6643a = new a();
    private final a b;
    private final d c;
    private final com.kwad.sdk.glide.load.engine.bitmap_recycle.b d;
    private final ContentResolver e;
    private final List<ImageHeaderParser> f;

    e(List<ImageHeaderParser> list, a aVar, d dVar, com.kwad.sdk.glide.load.engine.bitmap_recycle.b bVar, ContentResolver contentResolver) {
        this.b = aVar;
        this.c = dVar;
        this.d = bVar;
        this.e = contentResolver;
        this.f = list;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(List<ImageHeaderParser> list, d dVar, com.kwad.sdk.glide.load.engine.bitmap_recycle.b bVar, ContentResolver contentResolver) {
        this(list, f6643a, dVar, bVar, contentResolver);
    }

    private boolean a(File file) {
        return this.b.a(file) && 0 < this.b.b(file);
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[IF]}, finally: {[IF, INVOKE] complete} */
    @Nullable
    private String c(@NonNull Uri uri) {
        String string;
        Cursor a2 = this.c.a(uri);
        if (a2 != null) {
            try {
                if (a2.moveToFirst()) {
                    string = a2.getString(0);
                    return string;
                }
            } finally {
                if (a2 != null) {
                    a2.close();
                }
            }
        }
        string = null;
        if (a2 != null) {
            a2.close();
        }
        return string;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a(Uri uri) {
        InputStream inputStream = null;
        try {
            try {
                inputStream = this.e.openInputStream(uri);
                int b = com.kwad.sdk.glide.load.b.b(this.f, inputStream, this.d);
                if (inputStream != null) {
                    try {
                        inputStream.close();
                        return b;
                    } catch (IOException e) {
                        return b;
                    }
                }
                return b;
            } finally {
                if (0 != 0) {
                    try {
                        inputStream.close();
                    } catch (IOException e2) {
                    }
                }
            }
        } catch (IOException | NullPointerException e3) {
            if (Log.isLoggable("ThumbStreamOpener", 3)) {
                Log.d("ThumbStreamOpener", "Failed to open uri: " + uri, e3);
            }
            return -1;
        }
    }

    public InputStream b(Uri uri) {
        String c = c(uri);
        if (TextUtils.isEmpty(c)) {
            return null;
        }
        File a2 = this.b.a(c);
        if (a(a2)) {
            Uri fromFile = Uri.fromFile(a2);
            try {
                return this.e.openInputStream(fromFile);
            } catch (NullPointerException e) {
                throw ((FileNotFoundException) new FileNotFoundException("NPE opening uri: " + uri + " -> " + fromFile).initCause(e));
            }
        }
        return null;
    }
}

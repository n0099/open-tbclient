package com.facebook.imagepipeline.producers;

import android.content.ContentResolver;
import android.database.Cursor;
import android.graphics.Rect;
import android.media.ExifInterface;
import android.net.Uri;
import android.provider.MediaStore;
import com.facebook.imagepipeline.request.ImageRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class w extends y implements at<com.facebook.imagepipeline.f.d> {
    private final ContentResolver mContentResolver;
    private static final Class<?> iiR = w.class;
    private static final String[] PROJECTION = {"_id", "_data"};
    private static final String[] iuS = {"_data"};
    private static final Rect iuT = new Rect(0, 0, 512, 384);
    private static final Rect iuU = new Rect(0, 0, 96, 96);

    public w(Executor executor, com.facebook.common.memory.g gVar, ContentResolver contentResolver) {
        super(executor, gVar);
        this.mContentResolver = contentResolver;
    }

    @Override // com.facebook.imagepipeline.producers.at
    public boolean a(com.facebook.imagepipeline.common.c cVar) {
        return au.a(iuT.width(), iuT.height(), cVar);
    }

    @Override // com.facebook.imagepipeline.producers.y
    protected com.facebook.imagepipeline.f.d e(ImageRequest imageRequest) throws IOException {
        com.facebook.imagepipeline.f.d a;
        Uri cbc = imageRequest.cbc();
        if (!com.facebook.common.util.d.o(cbc) || (a = a(cbc, imageRequest.cbf())) == null) {
            return null;
        }
        return a;
    }

    @Nullable
    private com.facebook.imagepipeline.f.d a(Uri uri, com.facebook.imagepipeline.common.c cVar) throws IOException {
        com.facebook.imagepipeline.f.d a;
        Cursor query = this.mContentResolver.query(uri, PROJECTION, null, null, null);
        if (query == null) {
            return null;
        }
        try {
            if (query.getCount() == 0) {
                return null;
            }
            query.moveToFirst();
            String string = query.getString(query.getColumnIndex("_data"));
            if (cVar == null || (a = a(cVar, query.getInt(query.getColumnIndex("_id")))) == null) {
                return null;
            }
            a.yE(zH(string));
            return a;
        } finally {
            query.close();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [144=5, 145=4] */
    private com.facebook.imagepipeline.f.d a(com.facebook.imagepipeline.common.c cVar, int i) throws IOException {
        Cursor cursor;
        Throwable th;
        com.facebook.imagepipeline.f.d dVar = null;
        int b = b(cVar);
        if (b != 0) {
            try {
                cursor = MediaStore.Images.Thumbnails.queryMiniThumbnail(this.mContentResolver, i, b, iuS);
                if (cursor != null) {
                    try {
                        cursor.moveToFirst();
                        if (cursor.getCount() > 0) {
                            String string = cursor.getString(cursor.getColumnIndex("_data"));
                            if (new File(string).exists()) {
                                dVar = d(new FileInputStream(string), getLength(string));
                                if (cursor != null) {
                                    cursor.close();
                                }
                            }
                        }
                        if (cursor != null) {
                            cursor.close();
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        if (cursor != null) {
                            cursor.close();
                        }
                        throw th;
                    }
                } else if (cursor != null) {
                    cursor.close();
                }
            } catch (Throwable th3) {
                cursor = null;
                th = th3;
            }
        }
        return dVar;
    }

    private static int b(com.facebook.imagepipeline.common.c cVar) {
        if (au.a(iuU.width(), iuU.height(), cVar)) {
            return 3;
        }
        if (au.a(iuT.width(), iuT.height(), cVar)) {
            return 1;
        }
        return 0;
    }

    private static int getLength(String str) {
        if (str == null) {
            return -1;
        }
        return (int) new File(str).length();
    }

    @Override // com.facebook.imagepipeline.producers.y
    protected String caA() {
        return "LocalContentUriThumbnailFetchProducer";
    }

    private static int zH(String str) {
        if (str != null) {
            try {
                return com.facebook.d.b.ze(new ExifInterface(str).getAttributeInt("Orientation", 1));
            } catch (IOException e) {
                com.facebook.common.c.a.b(iiR, e, "Unable to retrieve thumbnail rotation for %s", str);
                return 0;
            }
        }
        return 0;
    }
}

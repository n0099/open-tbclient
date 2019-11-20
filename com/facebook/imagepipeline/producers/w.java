package com.facebook.imagepipeline.producers;

import android.content.ContentResolver;
import android.database.Cursor;
import android.graphics.Rect;
import android.media.ExifInterface;
import android.net.Uri;
import android.provider.MediaStore;
import com.baidu.android.imsdk.IMConstants;
import com.facebook.imagepipeline.request.ImageRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class w extends y implements au<com.facebook.imagepipeline.f.d> {
    private final ContentResolver mContentResolver;
    private static final Class<?> jYW = w.class;
    private static final String[] aVr = {IMConstants.MSG_ROW_ID, "_data"};
    private static final String[] klc = {"_data"};
    private static final Rect kld = new Rect(0, 0, 512, 384);
    private static final Rect kle = new Rect(0, 0, 96, 96);

    public w(Executor executor, com.facebook.common.memory.g gVar, ContentResolver contentResolver) {
        super(executor, gVar);
        this.mContentResolver = contentResolver;
    }

    @Override // com.facebook.imagepipeline.producers.au
    public boolean a(com.facebook.imagepipeline.common.c cVar) {
        return av.a(kld.width(), kld.height(), cVar);
    }

    @Override // com.facebook.imagepipeline.producers.y
    protected com.facebook.imagepipeline.f.d h(ImageRequest imageRequest) throws IOException {
        com.facebook.imagepipeline.f.d a;
        Uri cJs = imageRequest.cJs();
        if (!com.facebook.common.util.d.z(cJs) || (a = a(cJs, imageRequest.cJv())) == null) {
            return null;
        }
        return a;
    }

    @Nullable
    private com.facebook.imagepipeline.f.d a(Uri uri, com.facebook.imagepipeline.common.c cVar) throws IOException {
        com.facebook.imagepipeline.f.d a;
        Cursor query = this.mContentResolver.query(uri, aVr, null, null, null);
        if (query == null) {
            return null;
        }
        try {
            if (query.getCount() == 0) {
                return null;
            }
            query.moveToFirst();
            String string = query.getString(query.getColumnIndex("_data"));
            if (cVar == null || (a = a(cVar, query.getInt(query.getColumnIndex(IMConstants.MSG_ROW_ID)))) == null) {
                return null;
            }
            a.Ct(GK(string));
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
                cursor = MediaStore.Images.Thumbnails.queryMiniThumbnail(this.mContentResolver, i, b, klc);
                if (cursor != null) {
                    try {
                        cursor.moveToFirst();
                        if (cursor.getCount() > 0) {
                            String string = cursor.getString(cursor.getColumnIndex("_data"));
                            if (new File(string).exists()) {
                                dVar = e(new FileInputStream(string), getLength(string));
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
        if (av.a(kle.width(), kle.height(), cVar)) {
            return 3;
        }
        if (av.a(kld.width(), kld.height(), cVar)) {
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
    protected String cIQ() {
        return "LocalContentUriThumbnailFetchProducer";
    }

    private static int GK(String str) {
        if (str != null) {
            try {
                return com.facebook.d.b.CT(new ExifInterface(str).getAttributeInt("Orientation", 1));
            } catch (IOException e) {
                com.facebook.common.c.a.b(jYW, e, "Unable to retrieve thumbnail rotation for %s", str);
                return 0;
            }
        }
        return 0;
    }
}

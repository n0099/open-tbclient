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
/* loaded from: classes10.dex */
public class x extends z implements aw<com.facebook.imagepipeline.g.e> {
    private final ContentResolver mContentResolver;
    private static final Class<?> lGm = x.class;
    private static final String[] PROJECTION = {IMConstants.MSG_ROW_ID, "_data"};
    private static final String[] lVj = {"_data"};
    private static final Rect lVk = new Rect(0, 0, 512, 384);
    private static final Rect lVl = new Rect(0, 0, 96, 96);

    public x(Executor executor, com.facebook.common.memory.g gVar, ContentResolver contentResolver) {
        super(executor, gVar);
        this.mContentResolver = contentResolver;
    }

    @Override // com.facebook.imagepipeline.producers.aw
    public boolean a(com.facebook.imagepipeline.common.d dVar) {
        return ax.a(lVk.width(), lVk.height(), dVar);
    }

    @Override // com.facebook.imagepipeline.producers.z
    protected com.facebook.imagepipeline.g.e h(ImageRequest imageRequest) throws IOException {
        com.facebook.imagepipeline.g.e a;
        Uri dra = imageRequest.dra();
        if (!com.facebook.common.util.d.D(dra) || (a = a(dra, imageRequest.drc())) == null) {
            return null;
        }
        return a;
    }

    @Nullable
    private com.facebook.imagepipeline.g.e a(Uri uri, com.facebook.imagepipeline.common.d dVar) throws IOException {
        com.facebook.imagepipeline.g.e a;
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
            if (dVar == null || (a = a(dVar, query.getInt(query.getColumnIndex(IMConstants.MSG_ROW_ID)))) == null) {
                return null;
            }
            a.Ig(OS(string));
            return a;
        } finally {
            query.close();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [139=5, 140=4] */
    private com.facebook.imagepipeline.g.e a(com.facebook.imagepipeline.common.d dVar, int i) throws IOException {
        Cursor cursor;
        Throwable th;
        com.facebook.imagepipeline.g.e eVar = null;
        int b = b(dVar);
        if (b != 0) {
            try {
                cursor = MediaStore.Images.Thumbnails.queryMiniThumbnail(this.mContentResolver, i, b, lVj);
                if (cursor != null) {
                    try {
                        cursor.moveToFirst();
                        if (cursor.getCount() > 0) {
                            String string = cursor.getString(cursor.getColumnIndex("_data"));
                            if (new File(string).exists()) {
                                eVar = f(new FileInputStream(string), getLength(string));
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
        return eVar;
    }

    private static int b(com.facebook.imagepipeline.common.d dVar) {
        if (ax.a(lVl.width(), lVl.height(), dVar)) {
            return 3;
        }
        if (ax.a(lVk.width(), lVk.height(), dVar)) {
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

    @Override // com.facebook.imagepipeline.producers.z
    protected String dqr() {
        return "LocalContentUriThumbnailFetchProducer";
    }

    private static int OS(String str) {
        if (str != null) {
            try {
                return com.facebook.d.b.IM(new ExifInterface(str).getAttributeInt(android.support.media.ExifInterface.TAG_ORIENTATION, 1));
            } catch (IOException e) {
                com.facebook.common.c.a.b(lGm, e, "Unable to retrieve thumbnail rotation for %s", str);
                return 0;
            }
        }
        return 0;
    }
}

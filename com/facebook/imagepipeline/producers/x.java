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
/* loaded from: classes12.dex */
public class x extends z implements aw<com.facebook.imagepipeline.g.e> {
    private final ContentResolver mContentResolver;
    private static final Class<?> mki = x.class;
    private static final String[] cDy = {IMConstants.MSG_ROW_ID, "_data"};
    private static final String[] mzu = {"_data"};
    private static final Rect mzv = new Rect(0, 0, 512, 384);
    private static final Rect mzw = new Rect(0, 0, 96, 96);

    public x(Executor executor, com.facebook.common.memory.g gVar, ContentResolver contentResolver) {
        super(executor, gVar);
        this.mContentResolver = contentResolver;
    }

    @Override // com.facebook.imagepipeline.producers.aw
    public boolean a(com.facebook.imagepipeline.common.d dVar) {
        return ax.a(mzv.width(), mzv.height(), dVar);
    }

    @Override // com.facebook.imagepipeline.producers.z
    protected com.facebook.imagepipeline.g.e g(ImageRequest imageRequest) throws IOException {
        com.facebook.imagepipeline.g.e a;
        Uri dCa = imageRequest.dCa();
        if (!com.facebook.common.util.d.K(dCa) || (a = a(dCa, imageRequest.dCc())) == null) {
            return null;
        }
        return a;
    }

    @Nullable
    private com.facebook.imagepipeline.g.e a(Uri uri, com.facebook.imagepipeline.common.d dVar) throws IOException {
        com.facebook.imagepipeline.g.e a;
        Cursor query = this.mContentResolver.query(uri, cDy, null, null, null);
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
            a.HF(Qf(string));
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
                cursor = MediaStore.Images.Thumbnails.queryMiniThumbnail(this.mContentResolver, i, b, mzu);
                if (cursor != null) {
                    try {
                        cursor.moveToFirst();
                        if (cursor.getCount() > 0) {
                            String string = cursor.getString(cursor.getColumnIndex("_data"));
                            if (new File(string).exists()) {
                                eVar = f(new FileInputStream(string), Qe(string));
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
        if (ax.a(mzw.width(), mzw.height(), dVar)) {
            return 3;
        }
        if (ax.a(mzv.width(), mzv.height(), dVar)) {
            return 1;
        }
        return 0;
    }

    private static int Qe(String str) {
        if (str == null) {
            return -1;
        }
        return (int) new File(str).length();
    }

    @Override // com.facebook.imagepipeline.producers.z
    protected String dBs() {
        return "LocalContentUriThumbnailFetchProducer";
    }

    private static int Qf(String str) {
        if (str != null) {
            try {
                return com.facebook.d.b.Im(new ExifInterface(str).getAttributeInt(android.support.media.ExifInterface.TAG_ORIENTATION, 1));
            } catch (IOException e) {
                com.facebook.common.c.a.b(mki, e, "Unable to retrieve thumbnail rotation for %s", str);
                return 0;
            }
        }
        return 0;
    }
}

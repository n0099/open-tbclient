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
/* loaded from: classes3.dex */
public class x extends z implements aw<com.facebook.imagepipeline.f.e> {
    private final ContentResolver mContentResolver;
    private static final Class<?> pnn = x.class;
    private static final String[] PROJECTION = {IMConstants.MSG_ROW_ID, "_data"};
    private static final String[] pCd = {"_data"};
    private static final Rect pCe = new Rect(0, 0, 512, 384);
    private static final Rect pCf = new Rect(0, 0, 96, 96);

    public x(Executor executor, com.facebook.common.memory.g gVar, ContentResolver contentResolver) {
        super(executor, gVar);
        this.mContentResolver = contentResolver;
    }

    @Override // com.facebook.imagepipeline.producers.aw
    public boolean a(com.facebook.imagepipeline.common.d dVar) {
        return ax.a(pCe.width(), pCe.height(), dVar);
    }

    @Override // com.facebook.imagepipeline.producers.z
    protected com.facebook.imagepipeline.f.e g(ImageRequest imageRequest) throws IOException {
        com.facebook.imagepipeline.f.e a2;
        Uri exF = imageRequest.exF();
        if (!com.facebook.common.util.d.O(exF) || (a2 = a(exF, imageRequest.exH())) == null) {
            return null;
        }
        return a2;
    }

    @Nullable
    private com.facebook.imagepipeline.f.e a(Uri uri, com.facebook.imagepipeline.common.d dVar) throws IOException {
        com.facebook.imagepipeline.f.e a2;
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
            if (dVar == null || (a2 = a(dVar, query.getInt(query.getColumnIndex(IMConstants.MSG_ROW_ID)))) == null) {
                return null;
            }
            a2.Pq(Yw(string));
            return a2;
        } finally {
            query.close();
        }
    }

    /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [139=5, 140=4] */
    private com.facebook.imagepipeline.f.e a(com.facebook.imagepipeline.common.d dVar, int i) throws IOException {
        Cursor cursor;
        com.facebook.imagepipeline.f.e eVar = null;
        int b2 = b(dVar);
        if (b2 != 0) {
            try {
                cursor = MediaStore.Images.Thumbnails.queryMiniThumbnail(this.mContentResolver, i, b2, pCd);
                if (cursor != null) {
                    try {
                        cursor.moveToFirst();
                        if (cursor.getCount() > 0) {
                            String string = cursor.getString(cursor.getColumnIndex("_data"));
                            if (new File(string).exists()) {
                                eVar = e(new FileInputStream(string), Yv(string));
                                if (cursor != null) {
                                    cursor.close();
                                }
                            }
                        }
                        if (cursor != null) {
                            cursor.close();
                        }
                    } catch (Throwable th) {
                        th = th;
                        if (cursor != null) {
                            cursor.close();
                        }
                        throw th;
                    }
                } else if (cursor != null) {
                    cursor.close();
                }
            } catch (Throwable th2) {
                th = th2;
                cursor = null;
            }
        }
        return eVar;
    }

    private static int b(com.facebook.imagepipeline.common.d dVar) {
        if (ax.a(pCf.width(), pCf.height(), dVar)) {
            return 3;
        }
        if (ax.a(pCe.width(), pCe.height(), dVar)) {
            return 1;
        }
        return 0;
    }

    private static int Yv(String str) {
        if (str == null) {
            return -1;
        }
        return (int) new File(str).length();
    }

    @Override // com.facebook.imagepipeline.producers.z
    protected String exa() {
        return "LocalContentUriThumbnailFetchProducer";
    }

    private static int Yw(String str) {
        if (str != null) {
            try {
                return com.facebook.d.b.PV(new ExifInterface(str).getAttributeInt("Orientation", 1));
            } catch (IOException e) {
                com.facebook.common.c.a.b(pnn, e, "Unable to retrieve thumbnail rotation for %s", str);
                return 0;
            }
        }
        return 0;
    }
}

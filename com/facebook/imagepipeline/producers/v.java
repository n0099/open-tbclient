package com.facebook.imagepipeline.producers;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import com.facebook.imagepipeline.request.ImageRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class v extends y {
    private static final String[] PROJECTION = {"_id", "_data"};
    private final ContentResolver mContentResolver;

    public v(Executor executor, com.facebook.common.memory.g gVar, ContentResolver contentResolver) {
        super(executor, gVar);
        this.mContentResolver = contentResolver;
    }

    @Override // com.facebook.imagepipeline.producers.y
    protected com.facebook.imagepipeline.f.d e(ImageRequest imageRequest) throws IOException {
        com.facebook.imagepipeline.f.d B;
        InputStream openContactPhotoInputStream;
        Uri bXy = imageRequest.bXy();
        if (!com.facebook.common.util.d.m(bXy)) {
            return (!com.facebook.common.util.d.n(bXy) || (B = B(bXy)) == null) ? d(this.mContentResolver.openInputStream(bXy), -1) : B;
        }
        if (bXy.toString().endsWith("/photo")) {
            openContactPhotoInputStream = this.mContentResolver.openInputStream(bXy);
        } else {
            openContactPhotoInputStream = ContactsContract.Contacts.openContactPhotoInputStream(this.mContentResolver, bXy);
            if (openContactPhotoInputStream == null) {
                throw new IOException("Contact photo does not exist: " + bXy);
            }
        }
        return d(openContactPhotoInputStream, -1);
    }

    @Nullable
    private com.facebook.imagepipeline.f.d B(Uri uri) throws IOException {
        com.facebook.imagepipeline.f.d dVar = null;
        Cursor query = this.mContentResolver.query(uri, PROJECTION, null, null, null);
        if (query != null) {
            try {
                if (query.getCount() != 0) {
                    query.moveToFirst();
                    String string = query.getString(query.getColumnIndex("_data"));
                    if (string != null) {
                        dVar = d(new FileInputStream(string), getLength(string));
                    }
                }
            } finally {
                query.close();
            }
        }
        return dVar;
    }

    private static int getLength(String str) {
        if (str == null) {
            return -1;
        }
        return (int) new File(str).length();
    }

    @Override // com.facebook.imagepipeline.producers.y
    protected String bWW() {
        return "LocalContentUriFetchProducer";
    }
}

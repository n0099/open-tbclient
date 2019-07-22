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
    private static final String[] aBW = {"_id", "_data"};
    private final ContentResolver mContentResolver;

    public v(Executor executor, com.facebook.common.memory.g gVar, ContentResolver contentResolver) {
        super(executor, gVar);
        this.mContentResolver = contentResolver;
    }

    @Override // com.facebook.imagepipeline.producers.y
    protected com.facebook.imagepipeline.f.d h(ImageRequest imageRequest) throws IOException {
        com.facebook.imagepipeline.f.d Q;
        InputStream openContactPhotoInputStream;
        Uri cLo = imageRequest.cLo();
        if (!com.facebook.common.util.d.B(cLo)) {
            return (!com.facebook.common.util.d.C(cLo) || (Q = Q(cLo)) == null) ? e(this.mContentResolver.openInputStream(cLo), -1) : Q;
        }
        if (cLo.toString().endsWith("/photo")) {
            openContactPhotoInputStream = this.mContentResolver.openInputStream(cLo);
        } else {
            openContactPhotoInputStream = ContactsContract.Contacts.openContactPhotoInputStream(this.mContentResolver, cLo);
            if (openContactPhotoInputStream == null) {
                throw new IOException("Contact photo does not exist: " + cLo);
            }
        }
        return e(openContactPhotoInputStream, -1);
    }

    @Nullable
    private com.facebook.imagepipeline.f.d Q(Uri uri) throws IOException {
        com.facebook.imagepipeline.f.d dVar = null;
        Cursor query = this.mContentResolver.query(uri, aBW, null, null, null);
        if (query != null) {
            try {
                if (query.getCount() != 0) {
                    query.moveToFirst();
                    String string = query.getString(query.getColumnIndex("_data"));
                    if (string != null) {
                        dVar = e(new FileInputStream(string), getLength(string));
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
    protected String cKM() {
        return "LocalContentUriFetchProducer";
    }
}

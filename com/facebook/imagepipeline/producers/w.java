package com.facebook.imagepipeline.producers;

import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import com.baidu.android.imsdk.IMConstants;
import com.facebook.imagepipeline.request.ImageRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
/* loaded from: classes10.dex */
public class w extends z {
    private static final String[] PROJECTION = {IMConstants.MSG_ROW_ID, "_data"};
    private final ContentResolver mContentResolver;

    public w(Executor executor, com.facebook.common.memory.g gVar, ContentResolver contentResolver) {
        super(executor, gVar);
        this.mContentResolver = contentResolver;
    }

    @Override // com.facebook.imagepipeline.producers.z
    protected com.facebook.imagepipeline.g.e h(ImageRequest imageRequest) throws IOException {
        com.facebook.imagepipeline.g.e T;
        InputStream createInputStream;
        Uri dra = imageRequest.dra();
        if (!com.facebook.common.util.d.C(dra)) {
            return (!com.facebook.common.util.d.D(dra) || (T = T(dra)) == null) ? f(this.mContentResolver.openInputStream(dra), -1) : T;
        }
        if (dra.toString().endsWith("/photo")) {
            createInputStream = this.mContentResolver.openInputStream(dra);
        } else if (dra.toString().endsWith("/display_photo")) {
            try {
                createInputStream = this.mContentResolver.openAssetFileDescriptor(dra, "r").createInputStream();
            } catch (IOException e) {
                throw new IOException("Contact photo does not exist: " + dra);
            }
        } else {
            createInputStream = ContactsContract.Contacts.openContactPhotoInputStream(this.mContentResolver, dra);
            if (createInputStream == null) {
                throw new IOException("Contact photo does not exist: " + dra);
            }
        }
        return f(createInputStream, -1);
    }

    @Nullable
    private com.facebook.imagepipeline.g.e T(Uri uri) throws IOException {
        com.facebook.imagepipeline.g.e eVar = null;
        Cursor query = this.mContentResolver.query(uri, PROJECTION, null, null, null);
        if (query != null) {
            try {
                if (query.getCount() != 0) {
                    query.moveToFirst();
                    String string = query.getString(query.getColumnIndex("_data"));
                    if (string != null) {
                        eVar = f(new FileInputStream(string), getLength(string));
                    }
                }
            } finally {
                query.close();
            }
        }
        return eVar;
    }

    private static int getLength(String str) {
        if (str == null) {
            return -1;
        }
        return (int) new File(str).length();
    }

    @Override // com.facebook.imagepipeline.producers.z
    protected String dqr() {
        return "LocalContentUriFetchProducer";
    }
}

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
/* loaded from: classes12.dex */
public class w extends z {
    private static final String[] crA = {IMConstants.MSG_ROW_ID, "_data"};
    private final ContentResolver mContentResolver;

    public w(Executor executor, com.facebook.common.memory.g gVar, ContentResolver contentResolver) {
        super(executor, gVar);
        this.mContentResolver = contentResolver;
    }

    @Override // com.facebook.imagepipeline.producers.z
    protected com.facebook.imagepipeline.g.e g(ImageRequest imageRequest) throws IOException {
        com.facebook.imagepipeline.g.e V;
        InputStream createInputStream;
        Uri duI = imageRequest.duI();
        if (!com.facebook.common.util.d.H(duI)) {
            return (!com.facebook.common.util.d.I(duI) || (V = V(duI)) == null) ? f(this.mContentResolver.openInputStream(duI), -1) : V;
        }
        if (duI.toString().endsWith("/photo")) {
            createInputStream = this.mContentResolver.openInputStream(duI);
        } else if (duI.toString().endsWith("/display_photo")) {
            try {
                createInputStream = this.mContentResolver.openAssetFileDescriptor(duI, "r").createInputStream();
            } catch (IOException e) {
                throw new IOException("Contact photo does not exist: " + duI);
            }
        } else {
            createInputStream = ContactsContract.Contacts.openContactPhotoInputStream(this.mContentResolver, duI);
            if (createInputStream == null) {
                throw new IOException("Contact photo does not exist: " + duI);
            }
        }
        return f(createInputStream, -1);
    }

    @Nullable
    private com.facebook.imagepipeline.g.e V(Uri uri) throws IOException {
        com.facebook.imagepipeline.g.e eVar = null;
        Cursor query = this.mContentResolver.query(uri, crA, null, null, null);
        if (query != null) {
            try {
                if (query.getCount() != 0) {
                    query.moveToFirst();
                    String string = query.getString(query.getColumnIndex("_data"));
                    if (string != null) {
                        eVar = f(new FileInputStream(string), Oq(string));
                    }
                }
            } finally {
                query.close();
            }
        }
        return eVar;
    }

    private static int Oq(String str) {
        if (str == null) {
            return -1;
        }
        return (int) new File(str).length();
    }

    @Override // com.facebook.imagepipeline.producers.z
    protected String dua() {
        return "LocalContentUriFetchProducer";
    }
}

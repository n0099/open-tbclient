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
/* loaded from: classes18.dex */
public class w extends z {
    private static final String[] drb = {IMConstants.MSG_ROW_ID, "_data"};
    private final ContentResolver mContentResolver;

    public w(Executor executor, com.facebook.common.memory.g gVar, ContentResolver contentResolver) {
        super(executor, gVar);
        this.mContentResolver = contentResolver;
    }

    @Override // com.facebook.imagepipeline.producers.z
    protected com.facebook.imagepipeline.g.e g(ImageRequest imageRequest) throws IOException {
        com.facebook.imagepipeline.g.e Z;
        InputStream createInputStream;
        Uri enX = imageRequest.enX();
        if (!com.facebook.common.util.d.L(enX)) {
            return (!com.facebook.common.util.d.M(enX) || (Z = Z(enX)) == null) ? e(this.mContentResolver.openInputStream(enX), -1) : Z;
        }
        if (enX.toString().endsWith("/photo")) {
            createInputStream = this.mContentResolver.openInputStream(enX);
        } else if (enX.toString().endsWith("/display_photo")) {
            try {
                createInputStream = this.mContentResolver.openAssetFileDescriptor(enX, "r").createInputStream();
            } catch (IOException e) {
                throw new IOException("Contact photo does not exist: " + enX);
            }
        } else {
            createInputStream = ContactsContract.Contacts.openContactPhotoInputStream(this.mContentResolver, enX);
            if (createInputStream == null) {
                throw new IOException("Contact photo does not exist: " + enX);
            }
        }
        return e(createInputStream, -1);
    }

    @Nullable
    private com.facebook.imagepipeline.g.e Z(Uri uri) throws IOException {
        com.facebook.imagepipeline.g.e eVar = null;
        Cursor query = this.mContentResolver.query(uri, drb, null, null, null);
        if (query != null) {
            try {
                if (query.getCount() != 0) {
                    query.moveToFirst();
                    String string = query.getString(query.getColumnIndex("_data"));
                    if (string != null) {
                        eVar = e(new FileInputStream(string), XK(string));
                    }
                }
            } finally {
                query.close();
            }
        }
        return eVar;
    }

    private static int XK(String str) {
        if (str == null) {
            return -1;
        }
        return (int) new File(str).length();
    }

    @Override // com.facebook.imagepipeline.producers.z
    protected String enp() {
        return "LocalContentUriFetchProducer";
    }
}

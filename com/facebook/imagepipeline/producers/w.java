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
/* loaded from: classes8.dex */
public class w extends z {
    private static final String[] cUo = {IMConstants.MSG_ROW_ID, "_data"};
    private final ContentResolver mContentResolver;

    public w(Executor executor, com.facebook.common.memory.g gVar, ContentResolver contentResolver) {
        super(executor, gVar);
        this.mContentResolver = contentResolver;
    }

    @Override // com.facebook.imagepipeline.producers.z
    protected com.facebook.imagepipeline.g.e g(ImageRequest imageRequest) throws IOException {
        com.facebook.imagepipeline.g.e X;
        InputStream createInputStream;
        Uri dWg = imageRequest.dWg();
        if (!com.facebook.common.util.d.J(dWg)) {
            return (!com.facebook.common.util.d.K(dWg) || (X = X(dWg)) == null) ? e(this.mContentResolver.openInputStream(dWg), -1) : X;
        }
        if (dWg.toString().endsWith("/photo")) {
            createInputStream = this.mContentResolver.openInputStream(dWg);
        } else if (dWg.toString().endsWith("/display_photo")) {
            try {
                createInputStream = this.mContentResolver.openAssetFileDescriptor(dWg, "r").createInputStream();
            } catch (IOException e) {
                throw new IOException("Contact photo does not exist: " + dWg);
            }
        } else {
            createInputStream = ContactsContract.Contacts.openContactPhotoInputStream(this.mContentResolver, dWg);
            if (createInputStream == null) {
                throw new IOException("Contact photo does not exist: " + dWg);
            }
        }
        return e(createInputStream, -1);
    }

    @Nullable
    private com.facebook.imagepipeline.g.e X(Uri uri) throws IOException {
        com.facebook.imagepipeline.g.e eVar = null;
        Cursor query = this.mContentResolver.query(uri, cUo, null, null, null);
        if (query != null) {
            try {
                if (query.getCount() != 0) {
                    query.moveToFirst();
                    String string = query.getString(query.getColumnIndex("_data"));
                    if (string != null) {
                        eVar = e(new FileInputStream(string), UH(string));
                    }
                }
            } finally {
                query.close();
            }
        }
        return eVar;
    }

    private static int UH(String str) {
        if (str == null) {
            return -1;
        }
        return (int) new File(str).length();
    }

    @Override // com.facebook.imagepipeline.producers.z
    protected String dVy() {
        return "LocalContentUriFetchProducer";
    }
}

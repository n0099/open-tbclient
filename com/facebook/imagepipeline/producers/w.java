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
/* loaded from: classes3.dex */
public class w extends z {
    private static final String[] PROJECTION = {IMConstants.MSG_ROW_ID, "_data"};
    private final ContentResolver mContentResolver;

    public w(Executor executor, com.facebook.common.memory.g gVar, ContentResolver contentResolver) {
        super(executor, gVar);
        this.mContentResolver = contentResolver;
    }

    @Override // com.facebook.imagepipeline.producers.z
    protected com.facebook.imagepipeline.f.e g(ImageRequest imageRequest) throws IOException {
        com.facebook.imagepipeline.f.e af;
        InputStream createInputStream;
        Uri eBx = imageRequest.eBx();
        if (!com.facebook.common.util.d.Q(eBx)) {
            return (!com.facebook.common.util.d.R(eBx) || (af = af(eBx)) == null) ? e(this.mContentResolver.openInputStream(eBx), -1) : af;
        }
        if (eBx.toString().endsWith("/photo")) {
            createInputStream = this.mContentResolver.openInputStream(eBx);
        } else if (eBx.toString().endsWith("/display_photo")) {
            try {
                createInputStream = this.mContentResolver.openAssetFileDescriptor(eBx, "r").createInputStream();
            } catch (IOException e) {
                throw new IOException("Contact photo does not exist: " + eBx);
            }
        } else {
            createInputStream = ContactsContract.Contacts.openContactPhotoInputStream(this.mContentResolver, eBx);
            if (createInputStream == null) {
                throw new IOException("Contact photo does not exist: " + eBx);
            }
        }
        return e(createInputStream, -1);
    }

    @Nullable
    private com.facebook.imagepipeline.f.e af(Uri uri) throws IOException {
        com.facebook.imagepipeline.f.e eVar = null;
        Cursor query = this.mContentResolver.query(uri, PROJECTION, null, null, null);
        if (query != null) {
            try {
                if (query.getCount() != 0) {
                    query.moveToFirst();
                    String string = query.getString(query.getColumnIndex("_data"));
                    if (string != null) {
                        eVar = e(new FileInputStream(string), ZC(string));
                    }
                }
            } finally {
                query.close();
            }
        }
        return eVar;
    }

    private static int ZC(String str) {
        if (str == null) {
            return -1;
        }
        return (int) new File(str).length();
    }

    @Override // com.facebook.imagepipeline.producers.z
    protected String eAS() {
        return "LocalContentUriFetchProducer";
    }
}

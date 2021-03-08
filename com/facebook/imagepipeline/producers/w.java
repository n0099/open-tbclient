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
/* loaded from: classes5.dex */
public class w extends z {
    private static final String[] PROJECTION = {IMConstants.MSG_ROW_ID, "_data"};
    private final ContentResolver mContentResolver;

    public w(Executor executor, com.facebook.common.memory.g gVar, ContentResolver contentResolver) {
        super(executor, gVar);
        this.mContentResolver = contentResolver;
    }

    @Override // com.facebook.imagepipeline.producers.z
    protected com.facebook.imagepipeline.f.e g(ImageRequest imageRequest) throws IOException {
        com.facebook.imagepipeline.f.e ac;
        InputStream createInputStream;
        Uri eAo = imageRequest.eAo();
        if (!com.facebook.common.util.d.N(eAo)) {
            return (!com.facebook.common.util.d.O(eAo) || (ac = ac(eAo)) == null) ? e(this.mContentResolver.openInputStream(eAo), -1) : ac;
        }
        if (eAo.toString().endsWith("/photo")) {
            createInputStream = this.mContentResolver.openInputStream(eAo);
        } else if (eAo.toString().endsWith("/display_photo")) {
            try {
                createInputStream = this.mContentResolver.openAssetFileDescriptor(eAo, "r").createInputStream();
            } catch (IOException e) {
                throw new IOException("Contact photo does not exist: " + eAo);
            }
        } else {
            createInputStream = ContactsContract.Contacts.openContactPhotoInputStream(this.mContentResolver, eAo);
            if (createInputStream == null) {
                throw new IOException("Contact photo does not exist: " + eAo);
            }
        }
        return e(createInputStream, -1);
    }

    @Nullable
    private com.facebook.imagepipeline.f.e ac(Uri uri) throws IOException {
        com.facebook.imagepipeline.f.e eVar = null;
        Cursor query = this.mContentResolver.query(uri, PROJECTION, null, null, null);
        if (query != null) {
            try {
                if (query.getCount() != 0) {
                    query.moveToFirst();
                    String string = query.getString(query.getColumnIndex("_data"));
                    if (string != null) {
                        eVar = e(new FileInputStream(string), ZO(string));
                    }
                }
            } finally {
                query.close();
            }
        }
        return eVar;
    }

    private static int ZO(String str) {
        if (str == null) {
            return -1;
        }
        return (int) new File(str).length();
    }

    @Override // com.facebook.imagepipeline.producers.z
    protected String ezJ() {
        return "LocalContentUriFetchProducer";
    }
}

package com.kwad.sdk.glide.load.a;

import android.content.ContentResolver;
import android.content.UriMatcher;
import android.net.Uri;
import androidx.annotation.NonNull;
import java.io.FileNotFoundException;
import java.io.InputStream;
/* loaded from: classes5.dex */
public class n extends l<InputStream> {

    /* renamed from: a  reason: collision with root package name */
    private static final UriMatcher f10356a = new UriMatcher(-1);

    public n(ContentResolver contentResolver, Uri uri) {
        super(contentResolver, uri);
    }

    private InputStream c(Uri uri, ContentResolver contentResolver) {
        return contentResolver.openInputStream(uri);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.glide.load.a.l
    /* renamed from: a */
    public InputStream b(Uri uri, ContentResolver contentResolver) {
        InputStream c = c(uri, contentResolver);
        if (c == null) {
            throw new FileNotFoundException("InputStream is null for " + uri);
        }
        return c;
    }

    @Override // com.kwad.sdk.glide.load.a.d
    @NonNull
    public Class<InputStream> a() {
        return InputStream.class;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.kwad.sdk.glide.load.a.l
    public void a(InputStream inputStream) {
        inputStream.close();
    }
}

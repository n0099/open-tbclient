package com.kwad.sdk.glide.load.a;

import android.content.ContentResolver;
import android.content.UriMatcher;
import android.net.Uri;
import androidx.annotation.NonNull;
import java.io.FileNotFoundException;
import java.io.InputStream;
/* loaded from: classes6.dex */
public class n extends l<InputStream> {

    /* renamed from: a  reason: collision with root package name */
    public static final UriMatcher f35562a = new UriMatcher(-1);

    public n(ContentResolver contentResolver, Uri uri) {
        super(contentResolver, uri);
    }

    private InputStream c(Uri uri, ContentResolver contentResolver) {
        return contentResolver.openInputStream(uri);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.load.a.l
    /* renamed from: a */
    public InputStream b(Uri uri, ContentResolver contentResolver) {
        InputStream c2 = c(uri, contentResolver);
        if (c2 != null) {
            return c2;
        }
        throw new FileNotFoundException("InputStream is null for " + uri);
    }

    @Override // com.kwad.sdk.glide.load.a.d
    @NonNull
    public Class<InputStream> a() {
        return InputStream.class;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.load.a.l
    public void a(InputStream inputStream) {
        inputStream.close();
    }
}

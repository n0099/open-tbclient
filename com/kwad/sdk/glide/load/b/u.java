package com.kwad.sdk.glide.load.b;

import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.glide.load.b.n;
import java.io.File;
import java.io.InputStream;
/* loaded from: classes3.dex */
public class u<Data> implements n<String, Data> {

    /* renamed from: a  reason: collision with root package name */
    private final n<Uri, Data> f10123a;

    /* loaded from: classes3.dex */
    public static final class a implements o<String, AssetFileDescriptor> {
        @Override // com.kwad.sdk.glide.load.b.o
        public n<String, AssetFileDescriptor> a(@NonNull r rVar) {
            return new u(rVar.a(Uri.class, AssetFileDescriptor.class));
        }
    }

    /* loaded from: classes3.dex */
    public static class b implements o<String, ParcelFileDescriptor> {
        @Override // com.kwad.sdk.glide.load.b.o
        @NonNull
        public n<String, ParcelFileDescriptor> a(@NonNull r rVar) {
            return new u(rVar.a(Uri.class, ParcelFileDescriptor.class));
        }
    }

    /* loaded from: classes3.dex */
    public static class c implements o<String, InputStream> {
        @Override // com.kwad.sdk.glide.load.b.o
        @NonNull
        public n<String, InputStream> a(@NonNull r rVar) {
            return new u(rVar.a(Uri.class, InputStream.class));
        }
    }

    public u(n<Uri, Data> nVar) {
        this.f10123a = nVar;
    }

    @Nullable
    private static Uri b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.charAt(0) == '/') {
            return c(str);
        }
        Uri parse = Uri.parse(str);
        return parse.getScheme() == null ? c(str) : parse;
    }

    private static Uri c(String str) {
        return Uri.fromFile(new File(str));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.load.b.n
    public n.a<Data> a(@NonNull String str, int i, int i2, @NonNull com.kwad.sdk.glide.load.e eVar) {
        Uri b2 = b(str);
        if (b2 == null || !this.f10123a.a(b2)) {
            return null;
        }
        return this.f10123a.a(b2, i, i2, eVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.load.b.n
    public boolean a(@NonNull String str) {
        return true;
    }
}

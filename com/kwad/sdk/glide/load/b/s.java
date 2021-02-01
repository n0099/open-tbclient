package com.kwad.sdk.glide.load.b;

import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.glide.load.b.n;
import java.io.InputStream;
/* loaded from: classes3.dex */
public class s<Data> implements n<Integer, Data> {

    /* renamed from: a  reason: collision with root package name */
    private final n<Uri, Data> f10116a;

    /* renamed from: b  reason: collision with root package name */
    private final Resources f10117b;

    /* loaded from: classes3.dex */
    public static final class a implements o<Integer, AssetFileDescriptor> {

        /* renamed from: a  reason: collision with root package name */
        private final Resources f10118a;

        public a(Resources resources) {
            this.f10118a = resources;
        }

        @Override // com.kwad.sdk.glide.load.b.o
        public n<Integer, AssetFileDescriptor> a(r rVar) {
            return new s(this.f10118a, rVar.a(Uri.class, AssetFileDescriptor.class));
        }
    }

    /* loaded from: classes3.dex */
    public static class b implements o<Integer, ParcelFileDescriptor> {

        /* renamed from: a  reason: collision with root package name */
        private final Resources f10119a;

        public b(Resources resources) {
            this.f10119a = resources;
        }

        @Override // com.kwad.sdk.glide.load.b.o
        @NonNull
        public n<Integer, ParcelFileDescriptor> a(r rVar) {
            return new s(this.f10119a, rVar.a(Uri.class, ParcelFileDescriptor.class));
        }
    }

    /* loaded from: classes3.dex */
    public static class c implements o<Integer, InputStream> {

        /* renamed from: a  reason: collision with root package name */
        private final Resources f10120a;

        public c(Resources resources) {
            this.f10120a = resources;
        }

        @Override // com.kwad.sdk.glide.load.b.o
        @NonNull
        public n<Integer, InputStream> a(r rVar) {
            return new s(this.f10120a, rVar.a(Uri.class, InputStream.class));
        }
    }

    /* loaded from: classes3.dex */
    public static class d implements o<Integer, Uri> {

        /* renamed from: a  reason: collision with root package name */
        private final Resources f10121a;

        public d(Resources resources) {
            this.f10121a = resources;
        }

        @Override // com.kwad.sdk.glide.load.b.o
        @NonNull
        public n<Integer, Uri> a(r rVar) {
            return new s(this.f10121a, v.a());
        }
    }

    public s(Resources resources, n<Uri, Data> nVar) {
        this.f10117b = resources;
        this.f10116a = nVar;
    }

    @Nullable
    private Uri b(Integer num) {
        try {
            return Uri.parse("android.resource://" + this.f10117b.getResourcePackageName(num.intValue()) + '/' + this.f10117b.getResourceTypeName(num.intValue()) + '/' + this.f10117b.getResourceEntryName(num.intValue()));
        } catch (Resources.NotFoundException e) {
            if (Log.isLoggable("ResourceLoader", 5)) {
                Log.w("ResourceLoader", "Received invalid resource id: " + num, e);
            }
            return null;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.load.b.n
    public n.a<Data> a(@NonNull Integer num, int i, int i2, @NonNull com.kwad.sdk.glide.load.e eVar) {
        Uri b2 = b(num);
        if (b2 == null) {
            return null;
        }
        return this.f10116a.a(b2, i, i2, eVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.load.b.n
    public boolean a(@NonNull Integer num) {
        return true;
    }
}

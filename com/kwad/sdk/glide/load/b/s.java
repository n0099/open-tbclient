package com.kwad.sdk.glide.load.b;

import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.model.ResourceLoader;
import com.kwad.sdk.glide.load.b.n;
import java.io.InputStream;
/* loaded from: classes6.dex */
public class s<Data> implements n<Integer, Data> {

    /* renamed from: a  reason: collision with root package name */
    public final n<Uri, Data> f35743a;

    /* renamed from: b  reason: collision with root package name */
    public final Resources f35744b;

    /* loaded from: classes6.dex */
    public static final class a implements o<Integer, AssetFileDescriptor> {

        /* renamed from: a  reason: collision with root package name */
        public final Resources f35745a;

        public a(Resources resources) {
            this.f35745a = resources;
        }

        @Override // com.kwad.sdk.glide.load.b.o
        public n<Integer, AssetFileDescriptor> a(r rVar) {
            return new s(this.f35745a, rVar.a(Uri.class, AssetFileDescriptor.class));
        }
    }

    /* loaded from: classes6.dex */
    public static class b implements o<Integer, ParcelFileDescriptor> {

        /* renamed from: a  reason: collision with root package name */
        public final Resources f35746a;

        public b(Resources resources) {
            this.f35746a = resources;
        }

        @Override // com.kwad.sdk.glide.load.b.o
        @NonNull
        public n<Integer, ParcelFileDescriptor> a(r rVar) {
            return new s(this.f35746a, rVar.a(Uri.class, ParcelFileDescriptor.class));
        }
    }

    /* loaded from: classes6.dex */
    public static class c implements o<Integer, InputStream> {

        /* renamed from: a  reason: collision with root package name */
        public final Resources f35747a;

        public c(Resources resources) {
            this.f35747a = resources;
        }

        @Override // com.kwad.sdk.glide.load.b.o
        @NonNull
        public n<Integer, InputStream> a(r rVar) {
            return new s(this.f35747a, rVar.a(Uri.class, InputStream.class));
        }
    }

    /* loaded from: classes6.dex */
    public static class d implements o<Integer, Uri> {

        /* renamed from: a  reason: collision with root package name */
        public final Resources f35748a;

        public d(Resources resources) {
            this.f35748a = resources;
        }

        @Override // com.kwad.sdk.glide.load.b.o
        @NonNull
        public n<Integer, Uri> a(r rVar) {
            return new s(this.f35748a, v.a());
        }
    }

    public s(Resources resources, n<Uri, Data> nVar) {
        this.f35744b = resources;
        this.f35743a = nVar;
    }

    @Nullable
    private Uri b(Integer num) {
        try {
            return Uri.parse("android.resource://" + this.f35744b.getResourcePackageName(num.intValue()) + '/' + this.f35744b.getResourceTypeName(num.intValue()) + '/' + this.f35744b.getResourceEntryName(num.intValue()));
        } catch (Resources.NotFoundException e2) {
            if (Log.isLoggable(ResourceLoader.TAG, 5)) {
                Log.w(ResourceLoader.TAG, "Received invalid resource id: " + num, e2);
                return null;
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
        return this.f35743a.a(b2, i, i2, eVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.load.b.n
    public boolean a(@NonNull Integer num) {
        return true;
    }
}

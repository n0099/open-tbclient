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
    private final n<Uri, Data> f6694a;
    private final Resources b;

    /* loaded from: classes3.dex */
    public static final class a implements o<Integer, AssetFileDescriptor> {

        /* renamed from: a  reason: collision with root package name */
        private final Resources f6695a;

        public a(Resources resources) {
            this.f6695a = resources;
        }

        @Override // com.kwad.sdk.glide.load.b.o
        public n<Integer, AssetFileDescriptor> a(r rVar) {
            return new s(this.f6695a, rVar.a(Uri.class, AssetFileDescriptor.class));
        }
    }

    /* loaded from: classes3.dex */
    public static class b implements o<Integer, ParcelFileDescriptor> {

        /* renamed from: a  reason: collision with root package name */
        private final Resources f6696a;

        public b(Resources resources) {
            this.f6696a = resources;
        }

        @Override // com.kwad.sdk.glide.load.b.o
        @NonNull
        public n<Integer, ParcelFileDescriptor> a(r rVar) {
            return new s(this.f6696a, rVar.a(Uri.class, ParcelFileDescriptor.class));
        }
    }

    /* loaded from: classes3.dex */
    public static class c implements o<Integer, InputStream> {

        /* renamed from: a  reason: collision with root package name */
        private final Resources f6697a;

        public c(Resources resources) {
            this.f6697a = resources;
        }

        @Override // com.kwad.sdk.glide.load.b.o
        @NonNull
        public n<Integer, InputStream> a(r rVar) {
            return new s(this.f6697a, rVar.a(Uri.class, InputStream.class));
        }
    }

    /* loaded from: classes3.dex */
    public static class d implements o<Integer, Uri> {

        /* renamed from: a  reason: collision with root package name */
        private final Resources f6698a;

        public d(Resources resources) {
            this.f6698a = resources;
        }

        @Override // com.kwad.sdk.glide.load.b.o
        @NonNull
        public n<Integer, Uri> a(r rVar) {
            return new s(this.f6698a, v.a());
        }
    }

    public s(Resources resources, n<Uri, Data> nVar) {
        this.b = resources;
        this.f6694a = nVar;
    }

    @Nullable
    private Uri b(Integer num) {
        try {
            return Uri.parse("android.resource://" + this.b.getResourcePackageName(num.intValue()) + '/' + this.b.getResourceTypeName(num.intValue()) + '/' + this.b.getResourceEntryName(num.intValue()));
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
        return this.f6694a.a(b2, i, i2, eVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.load.b.n
    public boolean a(@NonNull Integer num) {
        return true;
    }
}

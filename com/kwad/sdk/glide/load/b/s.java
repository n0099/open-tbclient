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
/* loaded from: classes7.dex */
public class s<Data> implements n<Integer, Data> {

    /* renamed from: a  reason: collision with root package name */
    public final n<Uri, Data> f36042a;

    /* renamed from: b  reason: collision with root package name */
    public final Resources f36043b;

    /* loaded from: classes7.dex */
    public static final class a implements o<Integer, AssetFileDescriptor> {

        /* renamed from: a  reason: collision with root package name */
        public final Resources f36044a;

        public a(Resources resources) {
            this.f36044a = resources;
        }

        @Override // com.kwad.sdk.glide.load.b.o
        public n<Integer, AssetFileDescriptor> a(r rVar) {
            return new s(this.f36044a, rVar.a(Uri.class, AssetFileDescriptor.class));
        }
    }

    /* loaded from: classes7.dex */
    public static class b implements o<Integer, ParcelFileDescriptor> {

        /* renamed from: a  reason: collision with root package name */
        public final Resources f36045a;

        public b(Resources resources) {
            this.f36045a = resources;
        }

        @Override // com.kwad.sdk.glide.load.b.o
        @NonNull
        public n<Integer, ParcelFileDescriptor> a(r rVar) {
            return new s(this.f36045a, rVar.a(Uri.class, ParcelFileDescriptor.class));
        }
    }

    /* loaded from: classes7.dex */
    public static class c implements o<Integer, InputStream> {

        /* renamed from: a  reason: collision with root package name */
        public final Resources f36046a;

        public c(Resources resources) {
            this.f36046a = resources;
        }

        @Override // com.kwad.sdk.glide.load.b.o
        @NonNull
        public n<Integer, InputStream> a(r rVar) {
            return new s(this.f36046a, rVar.a(Uri.class, InputStream.class));
        }
    }

    /* loaded from: classes7.dex */
    public static class d implements o<Integer, Uri> {

        /* renamed from: a  reason: collision with root package name */
        public final Resources f36047a;

        public d(Resources resources) {
            this.f36047a = resources;
        }

        @Override // com.kwad.sdk.glide.load.b.o
        @NonNull
        public n<Integer, Uri> a(r rVar) {
            return new s(this.f36047a, v.a());
        }
    }

    public s(Resources resources, n<Uri, Data> nVar) {
        this.f36043b = resources;
        this.f36042a = nVar;
    }

    @Nullable
    private Uri b(Integer num) {
        try {
            return Uri.parse("android.resource://" + this.f36043b.getResourcePackageName(num.intValue()) + '/' + this.f36043b.getResourceTypeName(num.intValue()) + '/' + this.f36043b.getResourceEntryName(num.intValue()));
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
    public n.a<Data> a(@NonNull Integer num, int i2, int i3, @NonNull com.kwad.sdk.glide.load.e eVar) {
        Uri b2 = b(num);
        if (b2 == null) {
            return null;
        }
        return this.f36042a.a(b2, i2, i3, eVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.load.b.n
    public boolean a(@NonNull Integer num) {
        return true;
    }
}

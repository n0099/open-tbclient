package com.kwad.sdk.glide;

import android.content.ComponentCallbacks2;
import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.api.core.fragment.KsFragment;
import com.kwad.sdk.glide.c.k;
import com.kwad.sdk.glide.load.DecodeFormat;
import com.kwad.sdk.glide.load.ImageHeaderParser;
import com.kwad.sdk.glide.load.a.e;
import com.kwad.sdk.glide.load.a.k;
import com.kwad.sdk.glide.load.b.a;
import com.kwad.sdk.glide.load.b.a.a;
import com.kwad.sdk.glide.load.b.a.b;
import com.kwad.sdk.glide.load.b.a.c;
import com.kwad.sdk.glide.load.b.a.d;
import com.kwad.sdk.glide.load.b.a.e;
import com.kwad.sdk.glide.load.b.b;
import com.kwad.sdk.glide.load.b.d;
import com.kwad.sdk.glide.load.b.e;
import com.kwad.sdk.glide.load.b.f;
import com.kwad.sdk.glide.load.b.k;
import com.kwad.sdk.glide.load.b.s;
import com.kwad.sdk.glide.load.b.t;
import com.kwad.sdk.glide.load.b.u;
import com.kwad.sdk.glide.load.b.v;
import com.kwad.sdk.glide.load.b.w;
import com.kwad.sdk.glide.load.b.x;
import com.kwad.sdk.glide.load.engine.i;
import com.kwad.sdk.glide.load.resource.a.a;
import com.kwad.sdk.glide.load.resource.bitmap.j;
import com.kwad.sdk.glide.load.resource.bitmap.n;
import com.kwad.sdk.glide.load.resource.bitmap.r;
import com.kwad.sdk.glide.load.resource.bitmap.s;
import com.kwad.sdk.glide.load.resource.bitmap.u;
import com.kwad.sdk.glide.load.resource.bitmap.v;
import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/* loaded from: classes6.dex */
public class c implements ComponentCallbacks2 {

    /* renamed from: a  reason: collision with root package name */
    public static volatile c f35088a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile boolean f35089b;

    /* renamed from: c  reason: collision with root package name */
    public final i f35090c;

    /* renamed from: d  reason: collision with root package name */
    public final com.kwad.sdk.glide.load.engine.bitmap_recycle.e f35091d;

    /* renamed from: e  reason: collision with root package name */
    public final com.kwad.sdk.glide.load.engine.a.h f35092e;

    /* renamed from: f  reason: collision with root package name */
    public final com.kwad.sdk.glide.load.engine.c.a f35093f;

    /* renamed from: g  reason: collision with root package name */
    public final e f35094g;

    /* renamed from: h  reason: collision with root package name */
    public final Registry f35095h;
    public final com.kwad.sdk.glide.load.engine.bitmap_recycle.b i;
    public final k j;
    public final com.kwad.sdk.glide.c.d k;
    public final List<g> l = new ArrayList();
    public MemoryCategory m = MemoryCategory.NORMAL;

    public c(@NonNull Context context, @NonNull i iVar, @NonNull com.kwad.sdk.glide.load.engine.a.h hVar, @NonNull com.kwad.sdk.glide.load.engine.bitmap_recycle.e eVar, @NonNull com.kwad.sdk.glide.load.engine.bitmap_recycle.b bVar, @NonNull k kVar, @NonNull com.kwad.sdk.glide.c.d dVar, int i, @NonNull com.kwad.sdk.glide.request.f fVar, @NonNull Map<Class<?>, h<?, ?>> map, @NonNull List<com.kwad.sdk.glide.request.e<Object>> list, boolean z) {
        this.f35090c = iVar;
        this.f35091d = eVar;
        this.i = bVar;
        this.f35092e = hVar;
        this.j = kVar;
        this.k = dVar;
        this.f35093f = new com.kwad.sdk.glide.load.engine.c.a(hVar, eVar, (DecodeFormat) fVar.m().a(com.kwad.sdk.glide.load.resource.bitmap.k.f35668a));
        Resources resources = context.getResources();
        Registry registry = new Registry();
        this.f35095h = registry;
        registry.a((ImageHeaderParser) new j());
        if (Build.VERSION.SDK_INT >= 27) {
            this.f35095h.a((ImageHeaderParser) new n());
        }
        List<ImageHeaderParser> a2 = this.f35095h.a();
        com.kwad.sdk.glide.load.resource.bitmap.k kVar2 = new com.kwad.sdk.glide.load.resource.bitmap.k(a2, resources.getDisplayMetrics(), eVar, bVar);
        com.kwad.sdk.glide.load.resource.d.a aVar = new com.kwad.sdk.glide.load.resource.d.a(context, a2, eVar, bVar);
        com.kwad.sdk.glide.load.f<ParcelFileDescriptor, Bitmap> b2 = v.b(eVar);
        com.kwad.sdk.glide.load.resource.bitmap.f fVar2 = new com.kwad.sdk.glide.load.resource.bitmap.f(kVar2);
        s sVar = new s(kVar2, bVar);
        com.kwad.sdk.glide.load.resource.b.d dVar2 = new com.kwad.sdk.glide.load.resource.b.d(context);
        s.c cVar = new s.c(resources);
        s.d dVar3 = new s.d(resources);
        s.b bVar2 = new s.b(resources);
        s.a aVar2 = new s.a(resources);
        com.kwad.sdk.glide.load.resource.bitmap.c cVar2 = new com.kwad.sdk.glide.load.resource.bitmap.c(bVar);
        com.kwad.sdk.glide.load.resource.e.a aVar3 = new com.kwad.sdk.glide.load.resource.e.a();
        com.kwad.sdk.glide.load.resource.e.d dVar4 = new com.kwad.sdk.glide.load.resource.e.d();
        ContentResolver contentResolver = context.getContentResolver();
        this.f35095h.a(ByteBuffer.class, new com.kwad.sdk.glide.load.b.c()).a(InputStream.class, new t(bVar)).a(com.bumptech.glide.Registry.BUCKET_BITMAP, ByteBuffer.class, Bitmap.class, fVar2).a(com.bumptech.glide.Registry.BUCKET_BITMAP, InputStream.class, Bitmap.class, sVar).a(com.bumptech.glide.Registry.BUCKET_BITMAP, ParcelFileDescriptor.class, Bitmap.class, b2).a(com.bumptech.glide.Registry.BUCKET_BITMAP, AssetFileDescriptor.class, Bitmap.class, v.a(eVar)).a(Bitmap.class, Bitmap.class, v.a.a()).a(com.bumptech.glide.Registry.BUCKET_BITMAP, Bitmap.class, Bitmap.class, new u()).a(Bitmap.class, (com.kwad.sdk.glide.load.g) cVar2).a(com.bumptech.glide.Registry.BUCKET_BITMAP_DRAWABLE, ByteBuffer.class, BitmapDrawable.class, new com.kwad.sdk.glide.load.resource.bitmap.a(resources, fVar2)).a(com.bumptech.glide.Registry.BUCKET_BITMAP_DRAWABLE, InputStream.class, BitmapDrawable.class, new com.kwad.sdk.glide.load.resource.bitmap.a(resources, sVar)).a(com.bumptech.glide.Registry.BUCKET_BITMAP_DRAWABLE, ParcelFileDescriptor.class, BitmapDrawable.class, new com.kwad.sdk.glide.load.resource.bitmap.a(resources, b2)).a(BitmapDrawable.class, (com.kwad.sdk.glide.load.g) new com.kwad.sdk.glide.load.resource.bitmap.b(eVar, cVar2)).a(com.bumptech.glide.Registry.BUCKET_GIF, InputStream.class, com.kwad.sdk.glide.load.resource.d.c.class, new com.kwad.sdk.glide.load.resource.d.j(a2, aVar, bVar)).a(com.bumptech.glide.Registry.BUCKET_GIF, ByteBuffer.class, com.kwad.sdk.glide.load.resource.d.c.class, aVar).a(com.kwad.sdk.glide.load.resource.d.c.class, (com.kwad.sdk.glide.load.g) new com.kwad.sdk.glide.load.resource.d.d()).a(com.kwad.sdk.glide.b.a.class, com.kwad.sdk.glide.b.a.class, v.a.a()).a(com.bumptech.glide.Registry.BUCKET_BITMAP, com.kwad.sdk.glide.b.a.class, Bitmap.class, new com.kwad.sdk.glide.load.resource.d.h(eVar)).a(Uri.class, Drawable.class, dVar2).a(Uri.class, Bitmap.class, new r(dVar2, eVar)).a((e.a<?>) new a.C0419a()).a(File.class, ByteBuffer.class, new d.b()).a(File.class, InputStream.class, new f.e()).a(File.class, File.class, new com.kwad.sdk.glide.load.resource.c.a()).a(File.class, ParcelFileDescriptor.class, new f.b()).a(File.class, File.class, v.a.a()).a((e.a<?>) new k.a(bVar)).a(Integer.TYPE, InputStream.class, cVar).a(Integer.TYPE, ParcelFileDescriptor.class, bVar2).a(Integer.class, InputStream.class, cVar).a(Integer.class, ParcelFileDescriptor.class, bVar2).a(Integer.class, Uri.class, dVar3).a(Integer.TYPE, AssetFileDescriptor.class, aVar2).a(Integer.class, AssetFileDescriptor.class, aVar2).a(Integer.TYPE, Uri.class, dVar3).a(String.class, InputStream.class, new e.c()).a(Uri.class, InputStream.class, new e.c()).a(String.class, InputStream.class, new u.c()).a(String.class, ParcelFileDescriptor.class, new u.b()).a(String.class, AssetFileDescriptor.class, new u.a()).a(Uri.class, InputStream.class, new b.a()).a(Uri.class, InputStream.class, new a.c(context.getAssets())).a(Uri.class, ParcelFileDescriptor.class, new a.b(context.getAssets())).a(Uri.class, InputStream.class, new c.a(context)).a(Uri.class, InputStream.class, new d.a(context)).a(Uri.class, InputStream.class, new w.d(contentResolver)).a(Uri.class, ParcelFileDescriptor.class, new w.b(contentResolver)).a(Uri.class, AssetFileDescriptor.class, new w.a(contentResolver)).a(Uri.class, InputStream.class, new x.a()).a(URL.class, InputStream.class, new e.a()).a(Uri.class, File.class, new k.a(context)).a(com.kwad.sdk.glide.load.b.g.class, InputStream.class, new a.C0412a()).a(byte[].class, ByteBuffer.class, new b.a()).a(byte[].class, InputStream.class, new b.d()).a(Uri.class, Uri.class, v.a.a()).a(Drawable.class, Drawable.class, v.a.a()).a(Drawable.class, Drawable.class, new com.kwad.sdk.glide.load.resource.b.e()).a(Bitmap.class, BitmapDrawable.class, new com.kwad.sdk.glide.load.resource.e.b(resources)).a(Bitmap.class, byte[].class, aVar3).a(Drawable.class, byte[].class, new com.kwad.sdk.glide.load.resource.e.c(eVar, aVar3, dVar4)).a(com.kwad.sdk.glide.load.resource.d.c.class, byte[].class, dVar4);
        this.f35094g = new e(context, bVar, this.f35095h, new com.kwad.sdk.glide.request.a.f(), fVar, map, list, iVar, z, i);
    }

    @NonNull
    public static c a(@NonNull Context context) {
        if (f35088a == null) {
            synchronized (c.class) {
                if (f35088a == null) {
                    c(context);
                }
            }
        }
        return f35088a;
    }

    @NonNull
    public static g a(@NonNull KsFragment ksFragment) {
        return e(ksFragment.getActivity()).a(ksFragment);
    }

    public static void a(@NonNull Context context, @NonNull d dVar) {
        Context applicationContext = context.getApplicationContext();
        a i = i();
        dVar.a(i != null ? i.a() : null);
        if (i != null) {
            i.a(applicationContext, dVar);
        }
        c a2 = dVar.a(applicationContext);
        if (i != null) {
            i.a(applicationContext, a2, a2.f35095h);
        }
        applicationContext.registerComponentCallbacks(a2);
        f35088a = a2;
    }

    @NonNull
    @Deprecated
    public static g b(@NonNull Context context) {
        return e(context).a(context.getApplicationContext());
    }

    public static void c(@NonNull Context context) {
        if (f35089b) {
            throw new IllegalStateException("You cannot call Glide.get() in registerComponents(), use the provided Glide instance instead");
        }
        f35089b = true;
        d(context);
        f35089b = false;
    }

    public static void d(@NonNull Context context) {
        a(context, new d());
    }

    @NonNull
    public static com.kwad.sdk.glide.c.k e(@Nullable Context context) {
        com.kwad.sdk.glide.g.j.a(context, "You cannot start a load on a not yet attached View or a Fragment where getActivity() returns null (which usually occurs when getActivity() is called before the Fragment is attached or after the Fragment is destroyed).");
        return a(context).g();
    }

    @Nullable
    public static a i() {
        return new com.kwad.sdk.glide.webp.a();
    }

    @NonNull
    public com.kwad.sdk.glide.load.engine.bitmap_recycle.e a() {
        return this.f35091d;
    }

    public void a(int i) {
        com.kwad.sdk.glide.g.k.a();
        this.f35092e.a(i);
        this.f35091d.a(i);
        this.i.a(i);
    }

    public void a(g gVar) {
        synchronized (this.l) {
            if (this.l.contains(gVar)) {
                throw new IllegalStateException("Cannot register already registered manager");
            }
            this.l.add(gVar);
        }
    }

    public boolean a(@NonNull com.kwad.sdk.glide.request.a.j<?> jVar) {
        synchronized (this.l) {
            for (g gVar : this.l) {
                if (gVar.b(jVar)) {
                    return true;
                }
            }
            return false;
        }
    }

    @NonNull
    public com.kwad.sdk.glide.load.engine.bitmap_recycle.b b() {
        return this.i;
    }

    public void b(g gVar) {
        synchronized (this.l) {
            if (!this.l.contains(gVar)) {
                throw new IllegalStateException("Cannot unregister not yet registered manager");
            }
            this.l.remove(gVar);
        }
    }

    @NonNull
    public Context c() {
        return this.f35094g.getBaseContext();
    }

    public com.kwad.sdk.glide.c.d d() {
        return this.k;
    }

    @NonNull
    public e e() {
        return this.f35094g;
    }

    public void f() {
        com.kwad.sdk.glide.g.k.a();
        this.f35092e.a();
        this.f35091d.a();
        this.i.a();
    }

    @NonNull
    public com.kwad.sdk.glide.c.k g() {
        return this.j;
    }

    @NonNull
    public Registry h() {
        return this.f35095h;
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
        f();
    }

    @Override // android.content.ComponentCallbacks2
    public void onTrimMemory(int i) {
        a(i);
    }
}

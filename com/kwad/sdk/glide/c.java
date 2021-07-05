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
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
/* loaded from: classes7.dex */
public class c implements ComponentCallbacks2 {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static volatile c f37626a;

    /* renamed from: b  reason: collision with root package name */
    public static volatile boolean f37627b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public final i f37628c;

    /* renamed from: d  reason: collision with root package name */
    public final com.kwad.sdk.glide.load.engine.bitmap_recycle.e f37629d;

    /* renamed from: e  reason: collision with root package name */
    public final com.kwad.sdk.glide.load.engine.a.h f37630e;

    /* renamed from: f  reason: collision with root package name */
    public final com.kwad.sdk.glide.load.engine.c.a f37631f;

    /* renamed from: g  reason: collision with root package name */
    public final e f37632g;

    /* renamed from: h  reason: collision with root package name */
    public final Registry f37633h;

    /* renamed from: i  reason: collision with root package name */
    public final com.kwad.sdk.glide.load.engine.bitmap_recycle.b f37634i;
    public final k j;
    public final com.kwad.sdk.glide.c.d k;
    public final List<g> l;
    public MemoryCategory m;

    public c(@NonNull Context context, @NonNull i iVar, @NonNull com.kwad.sdk.glide.load.engine.a.h hVar, @NonNull com.kwad.sdk.glide.load.engine.bitmap_recycle.e eVar, @NonNull com.kwad.sdk.glide.load.engine.bitmap_recycle.b bVar, @NonNull k kVar, @NonNull com.kwad.sdk.glide.c.d dVar, int i2, @NonNull com.kwad.sdk.glide.request.f fVar, @NonNull Map<Class<?>, h<?, ?>> map, @NonNull List<com.kwad.sdk.glide.request.e<Object>> list, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r3;
            Object[] objArr = {context, iVar, hVar, eVar, bVar, kVar, dVar, Integer.valueOf(i2), fVar, map, list, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.l = new ArrayList();
        this.m = MemoryCategory.NORMAL;
        this.f37628c = iVar;
        this.f37629d = eVar;
        this.f37634i = bVar;
        this.f37630e = hVar;
        this.j = kVar;
        this.k = dVar;
        this.f37631f = new com.kwad.sdk.glide.load.engine.c.a(hVar, eVar, (DecodeFormat) fVar.m().a(com.kwad.sdk.glide.load.resource.bitmap.k.f38222a));
        Resources resources = context.getResources();
        Registry registry = new Registry();
        this.f37633h = registry;
        registry.a((ImageHeaderParser) new j());
        if (Build.VERSION.SDK_INT >= 27) {
            this.f37633h.a((ImageHeaderParser) new n());
        }
        List<ImageHeaderParser> a2 = this.f37633h.a();
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
        this.f37633h.a(ByteBuffer.class, new com.kwad.sdk.glide.load.b.c()).a(InputStream.class, new t(bVar)).a(com.bumptech.glide.Registry.BUCKET_BITMAP, ByteBuffer.class, Bitmap.class, fVar2).a(com.bumptech.glide.Registry.BUCKET_BITMAP, InputStream.class, Bitmap.class, sVar).a(com.bumptech.glide.Registry.BUCKET_BITMAP, ParcelFileDescriptor.class, Bitmap.class, b2).a(com.bumptech.glide.Registry.BUCKET_BITMAP, AssetFileDescriptor.class, Bitmap.class, v.a(eVar)).a(Bitmap.class, Bitmap.class, v.a.a()).a(com.bumptech.glide.Registry.BUCKET_BITMAP, Bitmap.class, Bitmap.class, new u()).a(Bitmap.class, (com.kwad.sdk.glide.load.g) cVar2).a(com.bumptech.glide.Registry.BUCKET_BITMAP_DRAWABLE, ByteBuffer.class, BitmapDrawable.class, new com.kwad.sdk.glide.load.resource.bitmap.a(resources, fVar2)).a(com.bumptech.glide.Registry.BUCKET_BITMAP_DRAWABLE, InputStream.class, BitmapDrawable.class, new com.kwad.sdk.glide.load.resource.bitmap.a(resources, sVar)).a(com.bumptech.glide.Registry.BUCKET_BITMAP_DRAWABLE, ParcelFileDescriptor.class, BitmapDrawable.class, new com.kwad.sdk.glide.load.resource.bitmap.a(resources, b2)).a(BitmapDrawable.class, (com.kwad.sdk.glide.load.g) new com.kwad.sdk.glide.load.resource.bitmap.b(eVar, cVar2)).a(com.bumptech.glide.Registry.BUCKET_GIF, InputStream.class, com.kwad.sdk.glide.load.resource.d.c.class, new com.kwad.sdk.glide.load.resource.d.j(a2, aVar, bVar)).a(com.bumptech.glide.Registry.BUCKET_GIF, ByteBuffer.class, com.kwad.sdk.glide.load.resource.d.c.class, aVar).a(com.kwad.sdk.glide.load.resource.d.c.class, (com.kwad.sdk.glide.load.g) new com.kwad.sdk.glide.load.resource.d.d()).a(com.kwad.sdk.glide.b.a.class, com.kwad.sdk.glide.b.a.class, v.a.a()).a(com.bumptech.glide.Registry.BUCKET_BITMAP, com.kwad.sdk.glide.b.a.class, Bitmap.class, new com.kwad.sdk.glide.load.resource.d.h(eVar)).a(Uri.class, Drawable.class, dVar2).a(Uri.class, Bitmap.class, new r(dVar2, eVar)).a((e.a<?>) new a.C0466a()).a(File.class, ByteBuffer.class, new d.b()).a(File.class, InputStream.class, new f.e()).a(File.class, File.class, new com.kwad.sdk.glide.load.resource.c.a()).a(File.class, ParcelFileDescriptor.class, new f.b()).a(File.class, File.class, v.a.a()).a((e.a<?>) new k.a(bVar)).a(Integer.TYPE, InputStream.class, cVar).a(Integer.TYPE, ParcelFileDescriptor.class, bVar2).a(Integer.class, InputStream.class, cVar).a(Integer.class, ParcelFileDescriptor.class, bVar2).a(Integer.class, Uri.class, dVar3).a(Integer.TYPE, AssetFileDescriptor.class, aVar2).a(Integer.class, AssetFileDescriptor.class, aVar2).a(Integer.TYPE, Uri.class, dVar3).a(String.class, InputStream.class, new e.c()).a(Uri.class, InputStream.class, new e.c()).a(String.class, InputStream.class, new u.c()).a(String.class, ParcelFileDescriptor.class, new u.b()).a(String.class, AssetFileDescriptor.class, new u.a()).a(Uri.class, InputStream.class, new b.a()).a(Uri.class, InputStream.class, new a.c(context.getAssets())).a(Uri.class, ParcelFileDescriptor.class, new a.b(context.getAssets())).a(Uri.class, InputStream.class, new c.a(context)).a(Uri.class, InputStream.class, new d.a(context)).a(Uri.class, InputStream.class, new w.d(contentResolver)).a(Uri.class, ParcelFileDescriptor.class, new w.b(contentResolver)).a(Uri.class, AssetFileDescriptor.class, new w.a(contentResolver)).a(Uri.class, InputStream.class, new x.a()).a(URL.class, InputStream.class, new e.a()).a(Uri.class, File.class, new k.a(context)).a(com.kwad.sdk.glide.load.b.g.class, InputStream.class, new a.C0459a()).a(byte[].class, ByteBuffer.class, new b.a()).a(byte[].class, InputStream.class, new b.d()).a(Uri.class, Uri.class, v.a.a()).a(Drawable.class, Drawable.class, v.a.a()).a(Drawable.class, Drawable.class, new com.kwad.sdk.glide.load.resource.b.e()).a(Bitmap.class, BitmapDrawable.class, new com.kwad.sdk.glide.load.resource.e.b(resources)).a(Bitmap.class, byte[].class, aVar3).a(Drawable.class, byte[].class, new com.kwad.sdk.glide.load.resource.e.c(eVar, aVar3, dVar4)).a(com.kwad.sdk.glide.load.resource.d.c.class, byte[].class, dVar4);
        this.f37632g = new e(context, bVar, this.f37633h, new com.kwad.sdk.glide.request.a.f(), fVar, map, list, iVar, z, i2);
    }

    @NonNull
    public static c a(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            if (f37626a == null) {
                synchronized (c.class) {
                    if (f37626a == null) {
                        c(context);
                    }
                }
            }
            return f37626a;
        }
        return (c) invokeL.objValue;
    }

    @NonNull
    public static g a(@NonNull KsFragment ksFragment) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, ksFragment)) == null) ? e(ksFragment.getActivity()).a(ksFragment) : (g) invokeL.objValue;
    }

    public static void a(@NonNull Context context, @NonNull d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, null, context, dVar) == null) {
            Context applicationContext = context.getApplicationContext();
            a i2 = i();
            dVar.a(i2 != null ? i2.a() : null);
            if (i2 != null) {
                i2.a(applicationContext, dVar);
            }
            c a2 = dVar.a(applicationContext);
            if (i2 != null) {
                i2.a(applicationContext, a2, a2.f37633h);
            }
            applicationContext.registerComponentCallbacks(a2);
            f37626a = a2;
        }
    }

    @NonNull
    @Deprecated
    public static g b(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65540, null, context)) == null) ? e(context).a(context.getApplicationContext()) : (g) invokeL.objValue;
    }

    public static void c(@NonNull Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, context) == null) {
            if (f37627b) {
                throw new IllegalStateException("You cannot call Glide.get() in registerComponents(), use the provided Glide instance instead");
            }
            f37627b = true;
            d(context);
            f37627b = false;
        }
    }

    public static void d(@NonNull Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, context) == null) {
            a(context, new d());
        }
    }

    @NonNull
    public static com.kwad.sdk.glide.c.k e(@Nullable Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, context)) == null) {
            com.kwad.sdk.glide.g.j.a(context, "You cannot start a load on a not yet attached View or a Fragment where getActivity() returns null (which usually occurs when getActivity() is called before the Fragment is attached or after the Fragment is destroyed).");
            return a(context).g();
        }
        return (com.kwad.sdk.glide.c.k) invokeL.objValue;
    }

    @Nullable
    public static a i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65544, null)) == null) ? new com.kwad.sdk.glide.webp.a() : (a) invokeV.objValue;
    }

    @NonNull
    public com.kwad.sdk.glide.load.engine.bitmap_recycle.e a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f37629d : (com.kwad.sdk.glide.load.engine.bitmap_recycle.e) invokeV.objValue;
    }

    public void a(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            com.kwad.sdk.glide.g.k.a();
            this.f37630e.a(i2);
            this.f37629d.a(i2);
            this.f37634i.a(i2);
        }
    }

    public void a(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, gVar) == null) {
            synchronized (this.l) {
                if (this.l.contains(gVar)) {
                    throw new IllegalStateException("Cannot register already registered manager");
                }
                this.l.add(gVar);
            }
        }
    }

    public boolean a(@NonNull com.kwad.sdk.glide.request.a.j<?> jVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, jVar)) == null) {
            synchronized (this.l) {
                for (g gVar : this.l) {
                    if (gVar.b(jVar)) {
                        return true;
                    }
                }
                return false;
            }
        }
        return invokeL.booleanValue;
    }

    @NonNull
    public com.kwad.sdk.glide.load.engine.bitmap_recycle.b b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.f37634i : (com.kwad.sdk.glide.load.engine.bitmap_recycle.b) invokeV.objValue;
    }

    public void b(g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, gVar) == null) {
            synchronized (this.l) {
                if (!this.l.contains(gVar)) {
                    throw new IllegalStateException("Cannot unregister not yet registered manager");
                }
                this.l.remove(gVar);
            }
        }
    }

    @NonNull
    public Context c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f37632g.getBaseContext() : (Context) invokeV.objValue;
    }

    public com.kwad.sdk.glide.c.d d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? this.k : (com.kwad.sdk.glide.c.d) invokeV.objValue;
    }

    @NonNull
    public e e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.f37632g : (e) invokeV.objValue;
    }

    public void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            com.kwad.sdk.glide.g.k.a();
            this.f37630e.a();
            this.f37629d.a();
            this.f37634i.a();
        }
    }

    @NonNull
    public com.kwad.sdk.glide.c.k g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.j : (com.kwad.sdk.glide.c.k) invokeV.objValue;
    }

    @NonNull
    public Registry h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) ? this.f37633h : (Registry) invokeV.objValue;
    }

    @Override // android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, configuration) == null) {
        }
    }

    @Override // android.content.ComponentCallbacks
    public void onLowMemory() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            f();
        }
    }

    @Override // android.content.ComponentCallbacks2
    public void onTrimMemory(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i2) == null) {
            a(i2);
        }
    }
}

package com.kwad.sdk.glide.load.resource.d;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bumptech.glide.load.resource.gif.ByteBufferGifDecoder;
import com.kwad.sdk.glide.b.a;
import com.kwad.sdk.glide.g.k;
import com.kwad.sdk.glide.load.DecodeFormat;
import com.kwad.sdk.glide.load.ImageHeaderParser;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Queue;
/* loaded from: classes7.dex */
public class a implements com.kwad.sdk.glide.load.f<ByteBuffer, c> {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final C0467a f38261a;

    /* renamed from: b  reason: collision with root package name */
    public static final b f38262b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public final Context f38263c;

    /* renamed from: d  reason: collision with root package name */
    public final List<ImageHeaderParser> f38264d;

    /* renamed from: e  reason: collision with root package name */
    public final b f38265e;

    /* renamed from: f  reason: collision with root package name */
    public final C0467a f38266f;

    /* renamed from: g  reason: collision with root package name */
    public final com.kwad.sdk.glide.load.resource.d.b f38267g;

    @VisibleForTesting
    /* renamed from: com.kwad.sdk.glide.load.resource.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C0467a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C0467a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public com.kwad.sdk.glide.b.a a(a.InterfaceC0454a interfaceC0454a, com.kwad.sdk.glide.b.c cVar, ByteBuffer byteBuffer, int i2) {
            InterceptResult invokeLLLI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLLLI = interceptable.invokeLLLI(1048576, this, interfaceC0454a, cVar, byteBuffer, i2)) == null) ? new com.kwad.sdk.glide.b.e(interfaceC0454a, cVar, byteBuffer, i2) : (com.kwad.sdk.glide.b.a) invokeLLLI.objValue;
        }
    }

    @VisibleForTesting
    /* loaded from: classes7.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final Queue<com.kwad.sdk.glide.b.d> f38268a;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f38268a = k.a(0);
        }

        public synchronized com.kwad.sdk.glide.b.d a(ByteBuffer byteBuffer) {
            InterceptResult invokeL;
            com.kwad.sdk.glide.b.d a2;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, byteBuffer)) == null) {
                synchronized (this) {
                    com.kwad.sdk.glide.b.d poll = this.f38268a.poll();
                    if (poll == null) {
                        poll = new com.kwad.sdk.glide.b.d();
                    }
                    a2 = poll.a(byteBuffer);
                }
                return a2;
            }
            return (com.kwad.sdk.glide.b.d) invokeL.objValue;
        }

        public synchronized void a(com.kwad.sdk.glide.b.d dVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, dVar) == null) {
                synchronized (this) {
                    dVar.a();
                    this.f38268a.offer(dVar);
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1242149378, "Lcom/kwad/sdk/glide/load/resource/d/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1242149378, "Lcom/kwad/sdk/glide/load/resource/d/a;");
                return;
            }
        }
        f38261a = new C0467a();
        f38262b = new b();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public a(Context context, List<ImageHeaderParser> list, com.kwad.sdk.glide.load.engine.bitmap_recycle.e eVar, com.kwad.sdk.glide.load.engine.bitmap_recycle.b bVar) {
        this(context, list, eVar, bVar, f38262b, f38261a);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, list, eVar, bVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((Context) objArr2[0], (List) objArr2[1], (com.kwad.sdk.glide.load.engine.bitmap_recycle.e) objArr2[2], (com.kwad.sdk.glide.load.engine.bitmap_recycle.b) objArr2[3], (b) objArr2[4], (C0467a) objArr2[5]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    @VisibleForTesting
    public a(Context context, List<ImageHeaderParser> list, com.kwad.sdk.glide.load.engine.bitmap_recycle.e eVar, com.kwad.sdk.glide.load.engine.bitmap_recycle.b bVar, b bVar2, C0467a c0467a) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, list, eVar, bVar, bVar2, c0467a};
            interceptable.invokeUnInit(65538, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.f38263c = context.getApplicationContext();
        this.f38264d = list;
        this.f38266f = c0467a;
        this.f38267g = new com.kwad.sdk.glide.load.resource.d.b(eVar, bVar);
        this.f38265e = bVar2;
    }

    public static int a(com.kwad.sdk.glide.b.c cVar, int i2, int i3) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65539, null, cVar, i2, i3)) == null) {
            int min = Math.min(cVar.a() / i3, cVar.b() / i2);
            int max = Math.max(1, min == 0 ? 0 : Integer.highestOneBit(min));
            if (Log.isLoggable(ByteBufferGifDecoder.TAG, 2) && max > 1) {
                Log.v(ByteBufferGifDecoder.TAG, "Downsampling GIF, sampleSize: " + max + ", target dimens: [" + i2 + "x" + i3 + "], actual dimens: [" + cVar.b() + "x" + cVar.a() + PreferencesUtil.RIGHT_MOUNT);
            }
            return max;
        }
        return invokeLII.intValue;
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[INVOKE]}, finally: {[INVOKE, CONSTRUCTOR, INVOKE, INVOKE, INVOKE, INVOKE, INVOKE, IF] complete} */
    @Nullable
    private e a(ByteBuffer byteBuffer, int i2, int i3, com.kwad.sdk.glide.b.d dVar, com.kwad.sdk.glide.load.e eVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65540, this, new Object[]{byteBuffer, Integer.valueOf(i2), Integer.valueOf(i3), dVar, eVar})) == null) {
            long a2 = com.kwad.sdk.glide.g.f.a();
            try {
                com.kwad.sdk.glide.b.c b2 = dVar.b();
                if (b2.c() > 0 && b2.d() == 0) {
                    Bitmap.Config config = eVar.a(i.f38297a) == DecodeFormat.PREFER_RGB_565 ? Bitmap.Config.RGB_565 : Bitmap.Config.ARGB_8888;
                    com.kwad.sdk.glide.b.a a3 = this.f38266f.a(this.f38267g, b2, byteBuffer, a(b2, i2, i3));
                    a3.a(config);
                    a3.b();
                    Bitmap h2 = a3.h();
                    if (h2 == null) {
                        return null;
                    }
                    e eVar2 = new e(new c(this.f38263c, a3, com.kwad.sdk.glide.load.resource.b.a(), i2, i3, h2));
                    if (Log.isLoggable(ByteBufferGifDecoder.TAG, 2)) {
                        Log.v(ByteBufferGifDecoder.TAG, "Decoded GIF from stream in " + com.kwad.sdk.glide.g.f.a(a2));
                    }
                    return eVar2;
                }
                if (Log.isLoggable(ByteBufferGifDecoder.TAG, 2)) {
                    Log.v(ByteBufferGifDecoder.TAG, "Decoded GIF from stream in " + com.kwad.sdk.glide.g.f.a(a2));
                }
                return null;
            } finally {
                if (Log.isLoggable(ByteBufferGifDecoder.TAG, 2)) {
                    Log.v(ByteBufferGifDecoder.TAG, "Decoded GIF from stream in " + com.kwad.sdk.glide.g.f.a(a2));
                }
            }
        }
        return (e) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.load.f
    public e a(@NonNull ByteBuffer byteBuffer, int i2, int i3, @NonNull com.kwad.sdk.glide.load.e eVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{byteBuffer, Integer.valueOf(i2), Integer.valueOf(i3), eVar})) == null) {
            com.kwad.sdk.glide.b.d a2 = this.f38265e.a(byteBuffer);
            try {
                return a(byteBuffer, i2, i3, a2, eVar);
            } finally {
                this.f38265e.a(a2);
            }
        }
        return (e) invokeCommon.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.kwad.sdk.glide.load.f
    public boolean a(@NonNull ByteBuffer byteBuffer, @NonNull com.kwad.sdk.glide.load.e eVar) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, byteBuffer, eVar)) == null) ? !((Boolean) eVar.a(i.f38298b)).booleanValue() && com.kwad.sdk.glide.load.b.a(this.f38264d, byteBuffer) == ImageHeaderParser.ImageType.GIF : invokeLL.booleanValue;
    }
}

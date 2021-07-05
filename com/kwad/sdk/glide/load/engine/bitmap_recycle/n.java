package com.kwad.sdk.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap;
import android.os.Build;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;
@RequiresApi(19)
/* loaded from: classes7.dex */
public class n implements l {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static final Bitmap.Config[] f38050a;

    /* renamed from: b  reason: collision with root package name */
    public static final Bitmap.Config[] f38051b;

    /* renamed from: c  reason: collision with root package name */
    public static final Bitmap.Config[] f38052c;

    /* renamed from: d  reason: collision with root package name */
    public static final Bitmap.Config[] f38053d;

    /* renamed from: e  reason: collision with root package name */
    public static final Bitmap.Config[] f38054e;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public final b f38055f;

    /* renamed from: g  reason: collision with root package name */
    public final h<a, Bitmap> f38056g;

    /* renamed from: h  reason: collision with root package name */
    public final Map<Bitmap.Config, NavigableMap<Integer, Integer>> f38057h;

    /* renamed from: com.kwad.sdk.glide.load.engine.bitmap_recycle.n$1  reason: invalid class name */
    /* loaded from: classes7.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f38058a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1634000829, "Lcom/kwad/sdk/glide/load/engine/bitmap_recycle/n$1;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1634000829, "Lcom/kwad/sdk/glide/load/engine/bitmap_recycle/n$1;");
                    return;
                }
            }
            int[] iArr = new int[Bitmap.Config.values().length];
            f38058a = iArr;
            try {
                iArr[Bitmap.Config.ARGB_8888.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f38058a[Bitmap.Config.RGB_565.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f38058a[Bitmap.Config.ARGB_4444.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f38058a[Bitmap.Config.ALPHA_8.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    @VisibleForTesting
    /* loaded from: classes7.dex */
    public static final class a implements m {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f38059a;

        /* renamed from: b  reason: collision with root package name */
        public final b f38060b;

        /* renamed from: c  reason: collision with root package name */
        public Bitmap.Config f38061c;

        public a(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f38060b = bVar;
        }

        @Override // com.kwad.sdk.glide.load.engine.bitmap_recycle.m
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f38060b.a(this);
            }
        }

        public void a(int i2, Bitmap.Config config) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, config) == null) {
                this.f38059a = i2;
                this.f38061c = config;
            }
        }

        public boolean equals(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, obj)) == null) {
                if (obj instanceof a) {
                    a aVar = (a) obj;
                    return this.f38059a == aVar.f38059a && com.kwad.sdk.glide.g.k.a(this.f38061c, aVar.f38061c);
                }
                return false;
            }
            return invokeL.booleanValue;
        }

        public int hashCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
                int i2 = this.f38059a * 31;
                Bitmap.Config config = this.f38061c;
                return i2 + (config != null ? config.hashCode() : 0);
            }
            return invokeV.intValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? n.a(this.f38059a, this.f38061c) : (String) invokeV.objValue;
        }
    }

    @VisibleForTesting
    /* loaded from: classes7.dex */
    public static class b extends d<a> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

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
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.kwad.sdk.glide.load.engine.bitmap_recycle.d
        /* renamed from: a */
        public a b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? new a(this) : (a) invokeV.objValue;
        }

        public a a(int i2, Bitmap.Config config) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIL = interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, config)) == null) {
                a c2 = c();
                c2.a(i2, config);
                return c2;
            }
            return (a) invokeIL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-761475984, "Lcom/kwad/sdk/glide/load/engine/bitmap_recycle/n;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-761475984, "Lcom/kwad/sdk/glide/load/engine/bitmap_recycle/n;");
                return;
            }
        }
        Bitmap.Config[] configArr = {Bitmap.Config.ARGB_8888, null};
        if (Build.VERSION.SDK_INT >= 26) {
            configArr = (Bitmap.Config[]) Arrays.copyOf(configArr, 3);
            configArr[configArr.length - 1] = Bitmap.Config.RGBA_F16;
        }
        f38050a = configArr;
        f38051b = configArr;
        f38052c = new Bitmap.Config[]{Bitmap.Config.RGB_565};
        f38053d = new Bitmap.Config[]{Bitmap.Config.ARGB_4444};
        f38054e = new Bitmap.Config[]{Bitmap.Config.ALPHA_8};
    }

    public n() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f38055f = new b();
        this.f38056g = new h<>();
        this.f38057h = new HashMap();
    }

    public static String a(int i2, Bitmap.Config config) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(65538, null, i2, config)) == null) {
            return PreferencesUtil.LEFT_MOUNT + i2 + "](" + config + SmallTailInfo.EMOTION_SUFFIX;
        }
        return (String) invokeIL.objValue;
    }

    private NavigableMap<Integer, Integer> a(Bitmap.Config config) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, this, config)) == null) {
            NavigableMap<Integer, Integer> navigableMap = this.f38057h.get(config);
            if (navigableMap == null) {
                TreeMap treeMap = new TreeMap();
                this.f38057h.put(config, treeMap);
                return treeMap;
            }
            return navigableMap;
        }
        return (NavigableMap) invokeL.objValue;
    }

    private void a(Integer num, Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65540, this, num, bitmap) == null) {
            NavigableMap<Integer, Integer> a2 = a(bitmap.getConfig());
            Integer num2 = (Integer) a2.get(num);
            if (num2 != null) {
                if (num2.intValue() == 1) {
                    a2.remove(num);
                    return;
                } else {
                    a2.put(num, Integer.valueOf(num2.intValue() - 1));
                    return;
                }
            }
            throw new NullPointerException("Tried to decrement empty size, size: " + num + ", removed: " + b(bitmap) + ", this: " + this);
        }
    }

    private a b(int i2, Bitmap.Config config) {
        InterceptResult invokeIL;
        Bitmap.Config[] b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(AdIconUtil.AD_TEXT_ID, this, i2, config)) == null) {
            a a2 = this.f38055f.a(i2, config);
            for (Bitmap.Config config2 : b(config)) {
                Integer ceilingKey = a(config2).ceilingKey(Integer.valueOf(i2));
                if (ceilingKey != null && ceilingKey.intValue() <= i2 * 8) {
                    if (ceilingKey.intValue() == i2) {
                        if (config2 == null) {
                            if (config == null) {
                                return a2;
                            }
                        } else if (config2.equals(config)) {
                            return a2;
                        }
                    }
                    this.f38055f.a(a2);
                    return this.f38055f.a(ceilingKey.intValue(), config2);
                }
            }
            return a2;
        }
        return (a) invokeIL.objValue;
    }

    public static Bitmap.Config[] b(Bitmap.Config config) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, null, config)) == null) {
            if (Build.VERSION.SDK_INT < 26 || !Bitmap.Config.RGBA_F16.equals(config)) {
                int i2 = AnonymousClass1.f38058a[config.ordinal()];
                return i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? new Bitmap.Config[]{config} : f38054e : f38053d : f38052c : f38050a;
            }
            return f38051b;
        }
        return (Bitmap.Config[]) invokeL.objValue;
    }

    @Override // com.kwad.sdk.glide.load.engine.bitmap_recycle.l
    @Nullable
    public Bitmap a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            Bitmap a2 = this.f38056g.a();
            if (a2 != null) {
                a(Integer.valueOf(com.kwad.sdk.glide.g.k.a(a2)), a2);
            }
            return a2;
        }
        return (Bitmap) invokeV.objValue;
    }

    @Override // com.kwad.sdk.glide.load.engine.bitmap_recycle.l
    @Nullable
    public Bitmap a(int i2, int i3, Bitmap.Config config) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, i3, config)) == null) {
            a b2 = b(com.kwad.sdk.glide.g.k.a(i2, i3, config), config);
            Bitmap a2 = this.f38056g.a((h<a, Bitmap>) b2);
            if (a2 != null) {
                a(Integer.valueOf(b2.f38059a), a2);
                a2.reconfigure(i2, i3, config);
            }
            return a2;
        }
        return (Bitmap) invokeIIL.objValue;
    }

    @Override // com.kwad.sdk.glide.load.engine.bitmap_recycle.l
    public void a(Bitmap bitmap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bitmap) == null) {
            a a2 = this.f38055f.a(com.kwad.sdk.glide.g.k.a(bitmap), bitmap.getConfig());
            this.f38056g.a(a2, bitmap);
            NavigableMap<Integer, Integer> a3 = a(bitmap.getConfig());
            Integer num = (Integer) a3.get(Integer.valueOf(a2.f38059a));
            a3.put(Integer.valueOf(a2.f38059a), Integer.valueOf(num != null ? 1 + num.intValue() : 1));
        }
    }

    @Override // com.kwad.sdk.glide.load.engine.bitmap_recycle.l
    public String b(int i2, int i3, Bitmap.Config config) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIIL = interceptable.invokeIIL(1048579, this, i2, i3, config)) == null) ? a(com.kwad.sdk.glide.g.k.a(i2, i3, config), config) : (String) invokeIIL.objValue;
    }

    @Override // com.kwad.sdk.glide.load.engine.bitmap_recycle.l
    public String b(Bitmap bitmap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, bitmap)) == null) ? a(com.kwad.sdk.glide.g.k.a(bitmap), bitmap.getConfig()) : (String) invokeL.objValue;
    }

    @Override // com.kwad.sdk.glide.load.engine.bitmap_recycle.l
    public int c(Bitmap bitmap) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, bitmap)) == null) ? com.kwad.sdk.glide.g.k.a(bitmap) : invokeL.intValue;
    }

    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("SizeConfigStrategy{groupedMap=");
            sb.append(this.f38056g);
            sb.append(", sortedSizes=(");
            for (Map.Entry<Bitmap.Config, NavigableMap<Integer, Integer>> entry : this.f38057h.entrySet()) {
                sb.append(entry.getKey());
                sb.append('[');
                sb.append(entry.getValue());
                sb.append("], ");
            }
            if (!this.f38057h.isEmpty()) {
                sb.replace(sb.length() - 2, sb.length(), "");
            }
            sb.append(")}");
            return sb.toString();
        }
        return (String) invokeV.objValue;
    }
}

package com.ss.android.downloadlib.addownload.compliance;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ss.android.socialbase.downloader.i.h;
import d.l.a.d.b.l;
import d.l.a.d.e;
import d.l.a.d.f;
import d.l.a.d.h;
import d.l.a.e.b.g.e;
import d.l.a.e.b.l.f;
import d.l.a.e.b.o.k;
import java.io.BufferedInputStream;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class d extends h<Long, Bitmap> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Map<Long, SoftReference<c>> f38516a;

    /* loaded from: classes6.dex */
    public class a implements h.i.a<Object, Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ long f38517a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d f38518b;

        public a(d dVar, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f38518b = dVar;
            this.f38517a = j;
        }

        @Override // d.l.a.d.h.i.a
        public Object a(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
                SoftReference softReference = (SoftReference) this.f38518b.f38516a.remove(Long.valueOf(this.f38517a));
                if (softReference == null || softReference.get() == null) {
                    return null;
                }
                ((c) softReference.get()).a(this.f38518b.get(Long.valueOf(this.f38517a)));
                return null;
            }
            return invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class b implements h.i.a<Object, Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f38519a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ long f38520b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f38521c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d f38522d;

        public b(d dVar, String str, long j, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, str, Long.valueOf(j), Long.valueOf(j2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f38522d = dVar;
            this.f38519a = str;
            this.f38520b = j;
            this.f38521c = j2;
        }

        @Override // d.l.a.d.h.i.a
        public Object a(Object obj) {
            InterceptResult invokeL;
            BufferedInputStream bufferedInputStream;
            Throwable th;
            k B;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
                try {
                    B = e.B(true, 0, this.f38519a, null);
                } catch (Exception e2) {
                    e = e2;
                    bufferedInputStream = null;
                } catch (Throwable th2) {
                    bufferedInputStream = null;
                    th = th2;
                    f.E(bufferedInputStream);
                    throw th;
                }
                if (B == null) {
                    f.E(null);
                    return null;
                }
                bufferedInputStream = new BufferedInputStream(B.a());
                try {
                    try {
                        bufferedInputStream.mark(bufferedInputStream.available());
                        BitmapFactory.Options options = new BitmapFactory.Options();
                        options.inJustDecodeBounds = true;
                        BitmapFactory.decodeStream(bufferedInputStream, null, options);
                        int i2 = options.outWidth;
                        int i3 = options.outHeight;
                        int b2 = h.r.b(l.a(), 60.0f);
                        options.inSampleSize = d.b(b2, b2, options);
                        options.inJustDecodeBounds = false;
                        bufferedInputStream.reset();
                        Bitmap decodeStream = BitmapFactory.decodeStream(bufferedInputStream, null, options);
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.putOpt("ttdownloader_type", "load_bitmap");
                            jSONObject.putOpt("bm_original_w", Integer.valueOf(i2));
                            jSONObject.putOpt("bm_original_h", Integer.valueOf(i3));
                            jSONObject.putOpt("bm_bytes", Integer.valueOf(decodeStream == null ? -1 : decodeStream.getByteCount()));
                        } catch (Exception e3) {
                            e3.printStackTrace();
                        }
                        e.c.a().q("ttd_pref_monitor", jSONObject, this.f38520b);
                        this.f38522d.put(Long.valueOf(this.f38521c), decodeStream);
                        f.E(bufferedInputStream);
                    } catch (Exception e4) {
                        e = e4;
                        f.e.b().a(e, "BitmapCache loadBitmap");
                        d.l.a.e.b.l.f.E(bufferedInputStream);
                        return null;
                    }
                    return null;
                } catch (Throwable th3) {
                    th = th3;
                    d.l.a.e.b.l.f.E(bufferedInputStream);
                    throw th;
                }
            }
            return invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public interface c {
        void a(Bitmap bitmap);
    }

    /* renamed from: com.ss.android.downloadlib.addownload.compliance.d$d  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public static class C0487d {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static d f38523a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(213244750, "Lcom/ss/android/downloadlib/addownload/compliance/d$d;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(213244750, "Lcom/ss/android/downloadlib/addownload/compliance/d$d;");
                    return;
                }
            }
            f38523a = new d(null);
        }
    }

    public /* synthetic */ d(a aVar) {
        this();
    }

    public static int b(int i2, int i3, BitmapFactory.Options options) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(AdIconUtil.AD_TEXT_ID, null, i2, i3, options)) == null) {
            if (options.outWidth > i2 || options.outHeight > i3) {
                return Math.min(Math.round(options.outWidth / i2), Math.round(options.outHeight / i3));
            }
            return 1;
        }
        return invokeIIL.intValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d() {
        super(8, 8);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr = newInitContext.callArgs;
                super(((Integer) objArr[0]).intValue(), ((Integer) objArr[1]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f38516a = new HashMap();
    }

    public static d a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? C0487d.f38523a : (d) invokeV.objValue;
    }

    public void a(long j, @NonNull c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j, cVar) == null) {
            if (get(Long.valueOf(j)) != null) {
                cVar.a(get(Long.valueOf(j)));
            } else {
                this.f38516a.put(Long.valueOf(j), new SoftReference<>(cVar));
            }
        }
    }

    public void a(long j, long j2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j), Long.valueOf(j2), str}) == null) {
            if (get(Long.valueOf(j)) != null) {
                SoftReference<c> remove = this.f38516a.remove(Long.valueOf(j));
                if (remove == null || remove.get() == null) {
                    return;
                }
                remove.get().a(get(Long.valueOf(j)));
            } else if (TextUtils.isEmpty(str)) {
                d.l.a.d.b.e.c.a(12, j2);
            } else {
                h.i.c(new b(this, str, j2, j), null).b(new a(this, j)).d();
            }
        }
    }
}

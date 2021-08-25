package com.ss.android.downloadlib.addownload.compliance;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import c.p.a.d.b.l;
import c.p.a.d.e;
import c.p.a.d.f;
import c.p.a.d.h;
import c.p.a.e.b.g.e;
import c.p.a.e.b.l.f;
import c.p.a.e.b.o.k;
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
import java.io.BufferedInputStream;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class d extends h<Long, Bitmap> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final Map<Long, SoftReference<c>> f75529a;

    /* loaded from: classes10.dex */
    public class a implements h.i.a<Object, Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ long f75530a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d f75531b;

        public a(d dVar, long j2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, Long.valueOf(j2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f75531b = dVar;
            this.f75530a = j2;
        }

        @Override // c.p.a.d.h.i.a
        public Object a(Object obj) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
                SoftReference softReference = (SoftReference) this.f75531b.f75529a.remove(Long.valueOf(this.f75530a));
                if (softReference == null || softReference.get() == null) {
                    return null;
                }
                ((c) softReference.get()).a(this.f75531b.get(Long.valueOf(this.f75530a)));
                return null;
            }
            return invokeL.objValue;
        }
    }

    /* loaded from: classes10.dex */
    public class b implements h.i.a<Object, Object> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f75532a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ long f75533b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f75534c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ d f75535d;

        public b(d dVar, String str, long j2, long j3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dVar, str, Long.valueOf(j2), Long.valueOf(j3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f75535d = dVar;
            this.f75532a = str;
            this.f75533b = j2;
            this.f75534c = j3;
        }

        @Override // c.p.a.d.h.i.a
        public Object a(Object obj) {
            InterceptResult invokeL;
            BufferedInputStream bufferedInputStream;
            Throwable th;
            k B;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, obj)) == null) {
                try {
                    B = e.B(true, 0, this.f75532a, null);
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
                        e.c.a().q("ttd_pref_monitor", jSONObject, this.f75533b);
                        this.f75535d.put(Long.valueOf(this.f75534c), decodeStream);
                        f.E(bufferedInputStream);
                    } catch (Exception e4) {
                        e = e4;
                        f.e.b().a(e, "BitmapCache loadBitmap");
                        c.p.a.e.b.l.f.E(bufferedInputStream);
                        return null;
                    }
                    return null;
                } catch (Throwable th3) {
                    th = th3;
                    c.p.a.e.b.l.f.E(bufferedInputStream);
                    throw th;
                }
            }
            return invokeL.objValue;
        }
    }

    /* loaded from: classes10.dex */
    public interface c {
        void a(Bitmap bitmap);
    }

    /* renamed from: com.ss.android.downloadlib.addownload.compliance.d$d  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C2051d {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static d f75536a;
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
            f75536a = new d(null);
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
        this.f75529a = new HashMap();
    }

    public static d a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? C2051d.f75536a : (d) invokeV.objValue;
    }

    public void a(long j2, @NonNull c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2, cVar) == null) {
            if (get(Long.valueOf(j2)) != null) {
                cVar.a(get(Long.valueOf(j2)));
            } else {
                this.f75529a.put(Long.valueOf(j2), new SoftReference<>(cVar));
            }
        }
    }

    public void a(long j2, long j3, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3), str}) == null) {
            if (get(Long.valueOf(j2)) != null) {
                SoftReference<c> remove = this.f75529a.remove(Long.valueOf(j2));
                if (remove == null || remove.get() == null) {
                    return;
                }
                remove.get().a(get(Long.valueOf(j2)));
            } else if (TextUtils.isEmpty(str)) {
                c.p.a.d.b.e.b.a(12, j3);
            } else {
                h.i.c(new b(this, str, j3, j2), null).b(new a(this, j2)).d();
            }
        }
    }
}

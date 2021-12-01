package com.ss.android.downloadlib.addownload.compliance;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.ss.android.downloadlib.addownload.j;
import com.ss.android.downloadlib.g.c;
import com.ss.android.downloadlib.g.l;
import com.ss.android.socialbase.downloader.i.f;
import com.ss.android.socialbase.downloader.i.h;
import com.ss.android.socialbase.downloader.network.i;
import java.io.BufferedInputStream;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class d extends h<Long, Bitmap> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Map<Long, SoftReference<a>> a;

    /* loaded from: classes2.dex */
    public interface a {
        void a(Bitmap bitmap);
    }

    /* loaded from: classes2.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public static d a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(213244688, "Lcom/ss/android/downloadlib/addownload/compliance/d$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(213244688, "Lcom/ss/android/downloadlib/addownload/compliance/d$b;");
                    return;
                }
            }
            a = new d();
        }
    }

    public static int b(int i2, int i3, BitmapFactory.Options options) {
        InterceptResult invokeIIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIL = interceptable.invokeIIL(65541, null, i2, i3, options)) == null) {
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
        this.a = new HashMap();
    }

    public static d a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? b.a : (d) invokeV.objValue;
    }

    public void a(long j2, @NonNull a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, j2, aVar) == null) {
            if (get(Long.valueOf(j2)) != null) {
                aVar.a(get(Long.valueOf(j2)));
            } else {
                this.a.put(Long.valueOf(j2), new SoftReference<>(aVar));
            }
        }
    }

    public void a(long j2, long j3, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Long.valueOf(j2), Long.valueOf(j3), str}) == null) {
            if (get(Long.valueOf(j2)) != null) {
                SoftReference<a> remove = this.a.remove(Long.valueOf(j2));
                if (remove == null || remove.get() == null) {
                    return;
                }
                remove.get().a(get(Long.valueOf(j2)));
            } else if (TextUtils.isEmpty(str)) {
                e.a(12, j3);
            } else {
                com.ss.android.downloadlib.g.c.a((c.a<Object, R>) new c.a<Object, Object>(this, str, j3, j2) { // from class: com.ss.android.downloadlib.addownload.compliance.d.2
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ String a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ long f61270b;

                    /* renamed from: c  reason: collision with root package name */
                    public final /* synthetic */ long f61271c;

                    /* renamed from: d  reason: collision with root package name */
                    public final /* synthetic */ d f61272d;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, str, Long.valueOf(j3), Long.valueOf(j2)};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f61272d = this;
                        this.a = str;
                        this.f61270b = j3;
                        this.f61271c = j2;
                    }

                    @Override // com.ss.android.downloadlib.g.c.a
                    public Object a(Object obj) {
                        InterceptResult invokeL;
                        BufferedInputStream bufferedInputStream;
                        Throwable th;
                        i a2;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, obj)) == null) {
                            try {
                                a2 = com.ss.android.socialbase.downloader.downloader.c.a(true, 0, this.a, null);
                            } catch (Exception e2) {
                                e = e2;
                                bufferedInputStream = null;
                            } catch (Throwable th2) {
                                bufferedInputStream = null;
                                th = th2;
                                f.a(bufferedInputStream);
                                throw th;
                            }
                            if (a2 == null) {
                                f.a(null);
                                return null;
                            }
                            bufferedInputStream = new BufferedInputStream(a2.a());
                            try {
                                try {
                                    bufferedInputStream.mark(bufferedInputStream.available());
                                    BitmapFactory.Options options = new BitmapFactory.Options();
                                    options.inJustDecodeBounds = true;
                                    BitmapFactory.decodeStream(bufferedInputStream, null, options);
                                    int i2 = options.outWidth;
                                    int i3 = options.outHeight;
                                    int a3 = l.a(j.getContext(), 60.0f);
                                    options.inSampleSize = d.b(a3, a3, options);
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
                                    com.ss.android.downloadlib.d.a.a().a("ttd_pref_monitor", jSONObject, this.f61270b);
                                    this.f61272d.put(Long.valueOf(this.f61271c), decodeStream);
                                    f.a(bufferedInputStream);
                                } catch (Exception e4) {
                                    e = e4;
                                    com.ss.android.downloadlib.e.c.a().a(e, "BitmapCache loadBitmap");
                                    f.a(bufferedInputStream);
                                    return null;
                                }
                                return null;
                            } catch (Throwable th3) {
                                th = th3;
                                f.a(bufferedInputStream);
                                throw th;
                            }
                        }
                        return invokeL.objValue;
                    }
                }, (Object) null).a(new c.a<Object, Object>(this, j2) { // from class: com.ss.android.downloadlib.addownload.compliance.d.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ long a;

                    /* renamed from: b  reason: collision with root package name */
                    public final /* synthetic */ d f61269b;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, Long.valueOf(j2)};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.f61269b = this;
                        this.a = j2;
                    }

                    @Override // com.ss.android.downloadlib.g.c.a
                    public Object a(Object obj) {
                        InterceptResult invokeL;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, obj)) == null) {
                            SoftReference softReference = (SoftReference) this.f61269b.a.remove(Long.valueOf(this.a));
                            if (softReference == null || softReference.get() == null) {
                                return null;
                            }
                            ((a) softReference.get()).a(this.f61269b.get(Long.valueOf(this.a)));
                            return null;
                        }
                        return invokeL.objValue;
                    }
                }).a();
            }
        }
    }
}

package com.bytedance.sdk.openadsdk.l.a;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.widget.ImageView;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.component.adnet.core.Request;
import com.bytedance.sdk.component.adnet.core.e;
import com.bytedance.sdk.component.adnet.core.i;
import com.bytedance.sdk.component.adnet.core.m;
import com.bytedance.sdk.component.utils.j;
import com.bytedance.sdk.openadsdk.core.e.t;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class c extends Request<d> {
    public static /* synthetic */ Interceptable $ic;
    public static final Object l;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public final Object f31439c;
    @Nullable
    @GuardedBy("mLock")

    /* renamed from: d  reason: collision with root package name */
    public a f31440d;

    /* renamed from: e  reason: collision with root package name */
    public final Bitmap.Config f31441e;

    /* renamed from: f  reason: collision with root package name */
    public final int f31442f;

    /* renamed from: g  reason: collision with root package name */
    public final int f31443g;

    /* renamed from: h  reason: collision with root package name */
    public final ImageView.ScaleType f31444h;

    /* renamed from: i  reason: collision with root package name */
    public t f31445i;
    public long j;
    public String k;

    /* loaded from: classes5.dex */
    public interface a extends m.a<d> {
        void a();

        void a(String str, d dVar);
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-349404098, "Lcom/bytedance/sdk/openadsdk/l/a/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-349404098, "Lcom/bytedance/sdk/openadsdk/l/a/c;");
                return;
            }
        }
        l = new Object();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(String str, a aVar, int i2, int i3, ImageView.ScaleType scaleType, Bitmap.Config config, String str2) {
        super(0, str, aVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, aVar, Integer.valueOf(i2), Integer.valueOf(i3), scaleType, config, str2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super(((Integer) objArr2[0]).intValue(), (String) objArr2[1], (m.a) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f31439c = new Object();
        setRetryPolicy(new e(1000, 2, 2.0f));
        this.f31440d = aVar;
        this.f31441e = config;
        this.f31442f = i2;
        this.f31443g = i3;
        this.f31444h = scaleType;
        this.k = str2;
        setShouldCache(false);
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00d3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private m<d> b(i iVar) {
        InterceptResult invokeL;
        String str;
        Bitmap decodeByteArray;
        Bitmap bitmap;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(AdIconUtil.BAIDU_LOGO_ID, this, iVar)) != null) {
            return (m) invokeL.objValue;
        }
        byte[] bArr = iVar.f28015b;
        f();
        if (TextUtils.isEmpty(this.k)) {
            str = com.bytedance.sdk.openadsdk.l.a.a.a().a(getUrl(), this.f31442f, this.f31443g, this.f31444h);
        } else {
            str = this.k;
        }
        if (bArr.length >= 3 && bArr[0] == 71 && bArr[1] == 73 && bArr[2] == 70) {
            try {
                com.bytedance.sdk.openadsdk.l.a.a.a().a(str, bArr);
                if (this.f31440d != null) {
                    this.f27947b.postAtFrontOfQueue(new Runnable(this, bArr, iVar) { // from class: com.bytedance.sdk.openadsdk.l.a.c.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ byte[] f31446a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ i f31447b;

                        /* renamed from: c  reason: collision with root package name */
                        public final /* synthetic */ c f31448c;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, bArr, iVar};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f31448c = this;
                            this.f31446a = bArr;
                            this.f31447b = iVar;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.f31448c.f31440d == null) {
                                return;
                            }
                            d dVar = new d(this.f31446a);
                            dVar.a(this.f31447b.f28017d);
                            dVar.a(this.f31447b.f28016c);
                            this.f31448c.f31440d.a(this.f31448c.getUrl(), dVar);
                        }
                    });
                }
                d dVar = new d(bArr);
                dVar.a(iVar.f28017d);
                dVar.a(iVar.f28016c);
                return m.a(dVar, com.bytedance.sdk.component.adnet.d.c.a(iVar));
            } catch (Exception unused) {
            }
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        if (this.f31442f == 0 && this.f31443g == 0) {
            options.inPreferredConfig = this.f31441e;
            decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
        } else {
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            int i2 = options.outWidth;
            int i3 = options.outHeight;
            int a2 = a(this.f31442f, this.f31443g, i2, i3, this.f31444h);
            int a3 = a(this.f31443g, this.f31442f, i3, i2, this.f31444h);
            options.inJustDecodeBounds = false;
            options.inSampleSize = a(i2, i3, a2, a3);
            decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
            if (decodeByteArray != null && (decodeByteArray.getWidth() > a2 || decodeByteArray.getHeight() > a3)) {
                Bitmap createScaledBitmap = Bitmap.createScaledBitmap(decodeByteArray, a2, a3, true);
                decodeByteArray.recycle();
                bitmap = createScaledBitmap;
                if (bitmap != null) {
                    return m.a(new com.bytedance.sdk.component.adnet.err.e(iVar));
                }
                if (this.f31440d != null) {
                    this.f27947b.postAtFrontOfQueue(new Runnable(this, bitmap, iVar) { // from class: com.bytedance.sdk.openadsdk.l.a.c.2
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ Bitmap f31449a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ i f31450b;

                        /* renamed from: c  reason: collision with root package name */
                        public final /* synthetic */ c f31451c;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, bitmap, iVar};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i4 = newInitContext.flag;
                                if ((i4 & 1) != 0) {
                                    int i5 = i4 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f31451c = this;
                            this.f31449a = bitmap;
                            this.f31450b = iVar;
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            Interceptable interceptable2 = $ic;
                            if (!(interceptable2 == null || interceptable2.invokeV(1048576, this) == null) || this.f31451c.f31440d == null) {
                                return;
                            }
                            d dVar2 = new d(this.f31449a);
                            dVar2.a(this.f31450b.f28017d);
                            dVar2.a(this.f31450b.f28016c);
                            this.f31451c.f31440d.a(this.f31451c.getUrl(), dVar2);
                        }
                    });
                }
                byte[] b2 = com.bytedance.sdk.component.utils.d.b(bitmap);
                com.bytedance.sdk.openadsdk.l.a.a.a().a(str, b2);
                if (this.f31440d != null) {
                    a(this.j, b2, bitmap, iVar.f28016c);
                    this.f31440d.a();
                }
                d dVar2 = new d(b2);
                dVar2.a(iVar.f28017d);
                dVar2.a(iVar.f28016c);
                return m.a(dVar2, com.bytedance.sdk.component.adnet.d.c.a(iVar));
            }
        }
        bitmap = decodeByteArray;
        if (bitmap != null) {
        }
    }

    private void f() {
        t tVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(65543, this) == null) && (tVar = this.f31445i) != null && tVar.z()) {
            long currentTimeMillis = System.currentTimeMillis();
            this.j = currentTimeMillis;
            this.f31445i.p(currentTimeMillis);
            t tVar2 = this.f31445i;
            tVar2.i(this.j - tVar2.v());
        }
    }

    @Override // com.bytedance.sdk.component.adnet.core.Request
    public void cancel() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.cancel();
            synchronized (this.f31439c) {
                this.f31440d = null;
            }
        }
    }

    @Override // com.bytedance.sdk.component.adnet.core.Request
    public Request.b getPriority() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? Request.b.f27958a : (Request.b) invokeV.objValue;
    }

    public static int a(int i2, int i3, int i4, int i5, ImageView.ScaleType scaleType) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), scaleType})) == null) {
            if (i2 == 0 && i3 == 0) {
                return i4;
            }
            if (scaleType == ImageView.ScaleType.FIT_XY) {
                return i2 == 0 ? i4 : i2;
            } else if (i2 == 0) {
                return (int) (i4 * (i3 / i5));
            } else {
                if (i3 == 0) {
                    return i2;
                }
                double d2 = i5 / i4;
                if (scaleType == ImageView.ScaleType.CENTER_CROP) {
                    double d3 = i3;
                    return ((double) i2) * d2 < d3 ? (int) (d3 / d2) : i2;
                }
                double d4 = i3;
                return ((double) i2) * d2 > d4 ? (int) (d4 / d2) : i2;
            }
        }
        return invokeCommon.intValue;
    }

    @Override // com.bytedance.sdk.component.adnet.core.Request
    public m<d> a(i iVar) {
        InterceptResult invokeL;
        m<d> b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, iVar)) == null) {
            synchronized (l) {
                try {
                    try {
                        b2 = b(iVar);
                    } catch (OutOfMemoryError e2) {
                        j.c("GifRequest", "Caught OOM for byte image", e2);
                        return m.a(new com.bytedance.sdk.component.adnet.err.e(e2, 612));
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            return b2;
        }
        return (m) invokeL.objValue;
    }

    @Override // com.bytedance.sdk.component.adnet.core.Request
    public void a(m<d> mVar) {
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, mVar) == null) {
            synchronized (this.f31439c) {
                aVar = this.f31440d;
            }
            if (aVar != null) {
                aVar.a(mVar);
            }
        }
    }

    public void a(t tVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, tVar) == null) {
            this.f31445i = tVar;
        }
    }

    private void a(long j, byte[] bArr, Bitmap bitmap, Map<String, String> map) {
        t tVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(AdIconUtil.AD_TEXT_ID, this, new Object[]{Long.valueOf(j), bArr, bitmap, map}) == null) && (tVar = this.f31445i) != null && tVar.z()) {
            if (bArr != null && this.f31445i.i() == 0.0d) {
                this.f31445i.a(bArr.length / 1024.0f);
            }
            if (bitmap != null && TextUtils.isEmpty(this.f31445i.j())) {
                this.f31445i.b(bitmap.getWidth() + "X" + bitmap.getHeight());
            }
            if (map != null && map.size() > 0 && this.f31445i.k() == null) {
                JSONObject jSONObject = new JSONObject();
                for (String str : map.keySet()) {
                    if (!TextUtils.isEmpty(str)) {
                        try {
                            jSONObject.put(str, map.get(str));
                        } catch (Exception e2) {
                            j.f("GifRequest", e2.getMessage());
                        }
                    }
                }
                this.f31445i.a(jSONObject);
            }
            this.f31445i.j(System.currentTimeMillis() - j);
            this.f31445i.b(System.currentTimeMillis() - this.f31445i.t());
        }
    }

    @VisibleForTesting
    public static int a(int i2, int i3, int i4, int i5) {
        InterceptResult invokeIIII;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeIIII = interceptable.invokeIIII(65538, null, i2, i3, i4, i5)) != null) {
            return invokeIIII.intValue;
        }
        double min = Math.min(i2 / i4, i3 / i5);
        float f2 = 1.0f;
        while (true) {
            float f3 = 2.0f * f2;
            if (f3 > min) {
                return (int) f2;
            }
            f2 = f3;
        }
    }
}

package d.a.q0.a.u.e.g;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.ExifInterface;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.a.v2.q0;
import d.a.q0.a.z1.b.f.e;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class h extends d.a.q0.a.u.c.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f50908e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f50909f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ boolean f50910g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ h f50911h;

        public a(h hVar, String str, int i2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar, str, Integer.valueOf(i2), Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50911h = hVar;
            this.f50908e = str;
            this.f50909f = i2;
            this.f50910g = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                h hVar = this.f50911h;
                hVar.J(hVar.i(), this.f50908e, this.f50909f, this.f50910g);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f50912e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f50913f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Drawable f50914g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ boolean f50915h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ h f50916i;

        public b(h hVar, String str, int i2, Drawable drawable, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar, str, Integer.valueOf(i2), drawable, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50916i = hVar;
            this.f50912e = str;
            this.f50913f = i2;
            this.f50914g = drawable;
            this.f50915h = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                h hVar = this.f50916i;
                hVar.H(hVar.i(), this.f50912e, this.f50913f, this.f50914g, this.f50915h);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f50917e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f50918f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ boolean f50919g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ h f50920h;

        public c(h hVar, String str, int i2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar, str, Integer.valueOf(i2), Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50920h = hVar;
            this.f50917e = str;
            this.f50918f = i2;
            this.f50919g = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                h hVar = this.f50920h;
                hVar.I(hVar.i(), this.f50917e, this.f50918f, this.f50919g);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f50921e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f50922f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f50923g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f50924h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ h f50925i;

        public d(h hVar, String str, int i2, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar, str, Integer.valueOf(i2), str2, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50925i = hVar;
            this.f50921e = str;
            this.f50922f = i2;
            this.f50923g = str2;
            this.f50924h = str3;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                h hVar = this.f50925i;
                hVar.G(hVar.i(), this.f50921e, this.f50922f, this.f50923g, this.f50924h);
            }
        }
    }

    /* loaded from: classes8.dex */
    public class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public e(h hVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d.a.q0.a.z1.b.f.e.a();
            }
        }
    }

    /* loaded from: classes8.dex */
    public class f implements e.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f50926a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ h f50927b;

        public f(h hVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50927b = hVar;
            this.f50926a = str;
        }

        @Override // d.a.q0.a.z1.b.f.e.c
        public void a() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || TextUtils.isEmpty(this.f50926a)) {
                return;
            }
            this.f50927b.d(this.f50926a, new d.a.q0.a.u.h.b(0));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(@NonNull d.a.q0.a.u.c.b bVar) {
        super(bVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((d.a.q0.a.u.c.b) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static ExifInterface A(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            try {
                return new ExifInterface(str);
            } catch (Exception unused) {
                return null;
            }
        }
        return (ExifInterface) invokeL.objValue;
    }

    public static String B(String str, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(65538, null, str, i2)) == null) ? C(str, i2, false) : (String) invokeLI.objValue;
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x004a, code lost:
        r0.append(com.baidu.tbadk.core.util.StringHelper.STRING_MORE);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String C(String str, int i2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65539, null, new Object[]{str, Integer.valueOf(i2), Boolean.valueOf(z)})) == null) {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            StringBuffer stringBuffer = new StringBuffer();
            char[] charArray = str.trim().toCharArray();
            int i3 = z ? i2 : i2 - 2;
            int i4 = z ? i2 : i2 - 1;
            int length = charArray.length;
            int i5 = 0;
            int i6 = 0;
            while (true) {
                if (i5 < length) {
                    char c2 = charArray[i5];
                    int i7 = c2 > 161 ? 2 : 1;
                    int i8 = i7 + i6;
                    if (i8 == i2 && i5 == length - 1) {
                        stringBuffer.append(c2);
                        break;
                    } else if ((i7 != 2 || i6 < i3) && (i7 != 1 || i6 < i4)) {
                        stringBuffer.append(c2);
                        i5++;
                        i6 = i8;
                    }
                } else {
                    break;
                }
            }
            return stringBuffer.toString();
        }
        return (String) invokeCommon.objValue;
    }

    public static Drawable F(Context context, String str, d.a.q0.a.a2.e eVar) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65540, null, context, str, eVar)) == null) {
            if (!TextUtils.isEmpty(str) && eVar != null && context != null) {
                if (d.a.q0.a.u.c.d.f50740c) {
                    Log.e("Api-ToastApi", "imagePath = " + str);
                }
                ExifInterface A = A(str);
                if (A == null) {
                    if (d.a.q0.a.u.c.d.f50740c) {
                        Log.e("Api-ToastApi", "exifInterface is null");
                    }
                    return null;
                }
                int intValue = Integer.valueOf(A.getAttribute("ImageWidth")).intValue();
                int intValue2 = Integer.valueOf(A.getAttribute("ImageLength")).intValue();
                if (d.a.q0.a.u.c.d.f50740c) {
                    Log.e("Api-ToastApi", "width = " + intValue + "， height = " + intValue2);
                }
                File file = new File(str);
                if (file.exists() && file.isFile()) {
                    try {
                        return new BitmapDrawable(context.getResources(), BitmapFactory.decodeStream(new FileInputStream(file)));
                    } catch (FileNotFoundException e2) {
                        if (d.a.q0.a.u.c.d.f50740c) {
                            Log.e("Api-ToastApi", "FileNotFoundException");
                            e2.printStackTrace();
                            return null;
                        }
                        return null;
                    }
                } else if (d.a.q0.a.u.c.d.f50740c) {
                    Log.e("Api-ToastApi", "image file not exists");
                }
            }
            return null;
        }
        return (Drawable) invokeLLL.objValue;
    }

    public static int L(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(AdIconUtil.AD_TEXT_ID, null, str)) == null) {
            if (TextUtils.isEmpty(str)) {
                return -1;
            }
            try {
                return (int) Float.parseFloat(str);
            } catch (NumberFormatException unused) {
                return -1;
            }
        }
        return invokeL.intValue;
    }

    public static int z(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, jSONObject)) == null) {
            int L = L(jSONObject.optString("time")) / 1000;
            if (L < 1) {
                return 2;
            }
            return L;
        }
        return invokeL.intValue;
    }

    public final void D() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && d.a.q0.a.u.c.d.f50740c) {
            Log.w("Api-ToastApi", "the toast type is unknown");
        }
    }

    public d.a.q0.a.u.h.b E() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            if (d.a.q0.a.u.c.d.f50740c) {
                Log.d("Api-ToastApi", "handle");
            }
            if (d.a.q0.a.a2.e.Q() == null) {
                return new d.a.q0.a.u.h.b(1001, "SwanApp is null");
            }
            q0.b0(new e(this));
            return new d.a.q0.a.u.h.b(0);
        }
        return (d.a.q0.a.u.h.b) invokeV.objValue;
    }

    public final void G(Context context, @NonNull String str, int i2, @NonNull String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{context, str, Integer.valueOf(i2), str2, str3}) == null) {
            d.a.q0.a.z1.b.f.e e2 = d.a.q0.a.z1.b.f.e.e(context);
            e2.q(str);
            e2.k(str2);
            e2.l(i2);
            e2.t(new f(this, str3));
            e2.v();
        }
    }

    public final void H(Context context, @NonNull String str, int i2, Drawable drawable, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{context, str, Integer.valueOf(i2), drawable, Boolean.valueOf(z)}) == null) {
            d.a.q0.a.z1.b.f.e g2 = d.a.q0.a.z1.b.f.e.g(context, B(str, 14));
            g2.n(drawable);
            g2.l(i2);
            g2.r(z);
            g2.A();
        }
    }

    public final void I(Context context, @NonNull String str, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048580, this, new Object[]{context, str, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            d.a.q0.a.z1.b.f.e g2 = d.a.q0.a.z1.b.f.e.g(context, B(str, 14));
            g2.l(i2);
            g2.r(z);
            g2.y();
        }
    }

    public final void J(Context context, @NonNull String str, int i2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{context, str, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) {
            d.a.q0.a.z1.b.f.e g2 = d.a.q0.a.z1.b.f.e.g(context, str);
            g2.l(i2);
            g2.r(z);
            g2.p(2);
            g2.F();
        }
    }

    public d.a.q0.a.u.h.b K(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) {
            if (d.a.q0.a.u.c.d.f50740c) {
                Log.d("Api-ToastApi", "handle: " + str);
            }
            if (l()) {
                d.a.q0.a.e0.d.b("Api-ToastApi", "Api-ToastApi does not supported when app is invisible.");
                return new d.a.q0.a.u.h.b(1001, "Api-ToastApi does not supported when app is invisible.");
            }
            d.a.q0.a.a2.e Q = d.a.q0.a.a2.e.Q();
            if (Q == null) {
                return new d.a.q0.a.u.h.b(1001, "SwanApp is null");
            }
            Pair<d.a.q0.a.u.h.b, JSONObject> b2 = d.a.q0.a.u.i.b.b("Api-ToastApi", str);
            d.a.q0.a.u.h.b bVar = (d.a.q0.a.u.h.b) b2.first;
            if (!bVar.isSuccess()) {
                if (d.a.q0.a.u.c.d.f50740c) {
                    d.a.q0.a.e0.d.b("Api-ToastApi", "parse fail");
                }
                return bVar;
            }
            JSONObject jSONObject = (JSONObject) b2.second;
            String optString = jSONObject.optString("type", "1");
            int z = z(jSONObject);
            String optString2 = jSONObject.optString("message");
            if (TextUtils.isEmpty(optString2)) {
                d.a.q0.a.e0.d.b("Api-ToastApi", "message is null");
                return new d.a.q0.a.u.h.b(202, "message is null");
            }
            boolean optBoolean = jSONObject.optBoolean("mask");
            String optString3 = jSONObject.optString("image", "-1");
            if (!TextUtils.equals(optString3, "-1") && !optString3.startsWith(q0.x(Q).getPath())) {
                optString3 = q0.w(Q, optString3);
            }
            Drawable F = F(i(), optString3, Q);
            if (d.a.q0.a.u.c.d.f50740c) {
                Log.e("Api-ToastApi", "imagepath = " + optString3);
            }
            if (!TextUtils.equals(optString3, "-1") && F == null && TextUtils.equals(optString, "2")) {
                optString = "1";
            }
            String optString4 = jSONObject.optString("cb");
            String optString5 = jSONObject.optString("buttonText");
            char c2 = 65535;
            switch (optString.hashCode()) {
                case 49:
                    if (optString.equals("1")) {
                        c2 = 0;
                        break;
                    }
                    break;
                case 50:
                    if (optString.equals("2")) {
                        c2 = 1;
                        break;
                    }
                    break;
                case 51:
                    if (optString.equals("3")) {
                        c2 = 2;
                        break;
                    }
                    break;
                case 52:
                    if (optString.equals("4")) {
                        c2 = 3;
                        break;
                    }
                    break;
            }
            if (c2 == 0) {
                q0.b0(new a(this, optString2, z, optBoolean));
            } else if (c2 == 1) {
                q0.b0(new b(this, optString2, z, F, optBoolean));
            } else if (c2 == 2) {
                q0.b0(new c(this, optString2, z, optBoolean));
            } else if (c2 != 3) {
                D();
                return new d.a.q0.a.u.h.b(302, "the toast type is unknown");
            } else {
                q0.b0(new d(this, optString2, z, optString5, optString4));
            }
            return new d.a.q0.a.u.h.b(0);
        }
        return (d.a.q0.a.u.h.b) invokeL.objValue;
    }
}

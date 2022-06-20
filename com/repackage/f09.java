package com.repackage;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Base64InputStream;
import android.util.Base64OutputStream;
import android.util.Log;
import android.util.SparseArray;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.im.model.IMUserListModel;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.repackage.l19;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class f09 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean y;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public long b;
    public boolean c;
    public Context d;
    public b19 e;
    public e09 f;
    public int g;
    public long h;
    public List<q09> i;
    public long j;
    public long k;
    public long l;
    public int m;
    public SparseArray<ArrayList> n;
    public HashMap<String, Long> o;
    public x09 p;
    public j09 q;
    public int r;
    public int s;
    public int t;
    public l19 u;
    public boolean v;
    public int w;
    public Runnable x;

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f09 a;

        public a(f09 f09Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f09Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = f09Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.a.g == 1) {
                    long uptimeMillis = SystemClock.uptimeMillis() - this.a.h;
                    if (uptimeMillis >= 5000) {
                        if (f09.y) {
                            Log.d("UBCBehaviorModel", String.format("***saveCache after %d ms***", Long.valueOf(uptimeMillis)));
                        }
                        this.a.z();
                        this.a.g = 0;
                        return;
                    }
                    g09.w().J(this, 5000 - uptimeMillis);
                } else if (this.a.g == 2) {
                    this.a.g = 0;
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements w09 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ f09 a;

        public b(f09 f09Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f09Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = f09Var;
        }

        @Override // com.repackage.w09
        public void a(boolean z, q09 q09Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, q09Var) == null) {
                if (!z) {
                    this.a.e.z(q09Var);
                    return;
                }
                this.a.e.h();
                a19.f().a(q09Var.l(), false);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public boolean a;
        public q09 b;
        public File c;
        public JSONObject d;
        public String e;
        public long f;
        public boolean g;
        public boolean h;
        public w09 i;

        public c() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = true;
            this.b = null;
            this.c = null;
            this.d = null;
            this.e = null;
            this.f = -1L;
            this.g = false;
            this.h = false;
            this.i = null;
        }
    }

    /* loaded from: classes5.dex */
    public class d implements l19.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d(f09 f09Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {f09Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.repackage.l19.e
        public void a() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                g09.w().P();
                g09.w().K();
            }
        }

        @Override // com.repackage.l19.e
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                g09.w().P();
                g09.w().K();
                g09.w().E();
            }
        }

        @Override // com.repackage.l19.e
        public void c() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                g09.w().K();
            }
        }

        @Override // com.repackage.l19.e
        public void d() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
                g09.w().P();
                g09.w().K();
                g09.w().E();
            }
        }

        @Override // com.repackage.l19.e
        public void e() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
                g09.w().P();
                g09.w().K();
                g09.w().E();
            }
        }

        public /* synthetic */ d(f09 f09Var, a aVar) {
            this(f09Var);
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755761502, "Lcom/repackage/f09;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755761502, "Lcom/repackage/f09;");
                return;
            }
        }
        y = e19.m();
    }

    public f09(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.c = false;
        this.g = 0;
        this.h = 0L;
        this.x = new a(this);
        this.d = context;
        n19 a2 = n19.a();
        this.e = new b19(context);
        this.f = new e09(context);
        this.p = e19.j();
        this.i = new ArrayList(20);
        this.j = a2.c("ubc_last_upload_non_real", 0L);
        this.k = a2.c("ubc_reset_real_time_count_time", 0L);
        this.l = a2.c("ubc_last_upload_failed_data_time", 0L);
        this.m = a2.b("ubc_real_time_count", 0);
        j09 o = j09.o();
        this.q = o;
        o.D(this, context);
        this.b = System.currentTimeMillis();
        this.a = new Random().nextInt(31) + 60;
        this.v = j09.o().I();
        this.w = j09.o().x();
        a19.f().g(this.e);
        l19 m = l19.m();
        this.u = m;
        m.n(this.d, this.e, new d(this, null));
    }

    public void A(q09 q09Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, q09Var) == null) {
            boolean equals = TextUtils.equals(q09Var.l(), q09Var.k());
            boolean z = (equals && (this.q.e(q09Var.l()) && (q09Var.n() & 64) == 0)) || (equals && ((q09Var.n() & 128) != 0));
            if (e19.i().d()) {
                if (!z) {
                    this.e.z(q09Var);
                    return;
                }
                List<String> j = e19.i().j();
                if (j != null && j.contains(q09Var.l())) {
                    if (!this.c) {
                        if ((System.currentTimeMillis() - this.b) / 1000 >= this.a) {
                            this.c = true;
                        } else {
                            this.e.z(q09Var);
                            return;
                        }
                    }
                } else {
                    this.e.z(q09Var);
                    return;
                }
            }
            if (z && !V(q09Var)) {
                if (this.q.K(q09Var.l())) {
                    this.e.z(q09Var);
                    return;
                }
                return;
            }
            if (z) {
                a19.f().a(q09Var.l(), false);
            }
            if (e19.i().d()) {
                this.e.e();
            } else if (Math.abs(System.currentTimeMillis() - this.j) >= j09.o().t()) {
                if (!z && this.q.K(q09Var.l())) {
                    g(q09Var);
                }
                U();
            } else if ((q09Var.n() & 1) == 0) {
                if (!z && this.q.K(q09Var.l())) {
                    g(q09Var);
                }
                if (this.i.size() >= 20) {
                    z();
                }
            } else if (z || !this.q.K(q09Var.l())) {
            } else {
                this.e.z(q09Var);
            }
        }
    }

    public void B(q09 q09Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, q09Var) == null) {
            this.f.g(q09Var, this.q.e(q09Var.l()));
        }
    }

    public void C(q09 q09Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, q09Var) == null) && db1.g()) {
            this.f.i(q09Var);
        }
    }

    public final void D(String str, String str2) {
        OutputStream fileOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, str, str2) == null) {
            String str3 = this.d.getFilesDir() + File.separator + "ubcsenddir";
            File file = new File(str3);
            if (!file.exists()) {
                file.mkdir();
            }
            File file2 = new File(str3, str2);
            if (file2.exists()) {
                return;
            }
            OutputStream outputStream = null;
            try {
                try {
                    fileOutputStream = new FileOutputStream(file2);
                } catch (Exception e) {
                    e = e;
                }
            } catch (Throwable th) {
                th = th;
            }
            try {
                outputStream = new Base64OutputStream(fileOutputStream, 0);
                outputStream.write(str.getBytes());
                outputStream.flush();
                d19.b("save to file suc");
                try {
                    outputStream.close();
                } catch (Exception e2) {
                    e = e2;
                    if (!y) {
                        return;
                    }
                    e.printStackTrace();
                }
            } catch (Exception e3) {
                e = e3;
                outputStream = fileOutputStream;
                if (y) {
                    e.printStackTrace();
                }
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (Exception e4) {
                        e = e4;
                        if (!y) {
                            return;
                        }
                        e.printStackTrace();
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                outputStream = fileOutputStream;
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (Exception e5) {
                        if (y) {
                            e5.printStackTrace();
                        }
                    }
                }
                throw th;
            }
        }
    }

    public void E() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && m19.a(this.d)) {
            if (this.n == null) {
                r();
            }
            o19 h = o19.h(this.d);
            if (!a19.f().d(h) || h == null || h.y()) {
                return;
            }
            h.L(true);
            J(h);
        }
    }

    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            o19 i = o19.i();
            if (this.f.e(i)) {
                JSONObject u = i.u();
                if (y) {
                    Log.d("UBCBehaviorModel", "sendQualityData:" + u.toString());
                }
                g09.w().R(u);
            }
        }
    }

    public final void G(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            o19 i = o19.i();
            i.L(z);
            if (this.f.f(i, z)) {
                JSONObject u = i.u();
                if (y) {
                    Log.d("UBCBehaviorModel", "checkFileData:" + u.toString());
                }
                this.f.c(z);
                g09.w().R(u);
            }
        }
    }

    public void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.e.C();
        }
    }

    public void I(s09 s09Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, s09Var) == null) {
            this.e.B(s09Var);
        }
    }

    public final void J(o19 o19Var) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, o19Var) == null) {
            o19Var.k();
            if (o19Var.y()) {
                return;
            }
            if (o19Var.x()) {
                str = o19Var.p();
            } else {
                try {
                    JSONObject u = o19Var.u();
                    String c2 = m19.c(u.toString().getBytes(), true);
                    D(u.toString(), c2);
                    if (y) {
                        d19.a(o19Var);
                        Log.d("UBCBehaviorModel", "save send data to file " + c2);
                    }
                    str = c2;
                } catch (OutOfMemoryError unused) {
                    o19Var.e();
                    return;
                }
            }
            if (!this.e.g(o19Var, str)) {
                o19Var.e();
                File file = new File(this.d.getFilesDir() + File.separator + "ubcsenddir", str);
                if (file.exists() && file.delete()) {
                    Log.d("UBCBehaviorModel", "db fail deleteUploadFile file suc");
                }
                this.e.l(str);
                return;
            }
            g19.a().m(o19Var.B(), o19Var.v());
            g09.w().Q(o19Var, str);
            o19Var.e();
            long currentTimeMillis = System.currentTimeMillis();
            if (Math.abs(currentTimeMillis - this.l) < IMUserListModel.REQUEST_SPACE) {
                return;
            }
            this.l = currentTimeMillis;
            n19.a().e("ubc_last_upload_failed_data_time", this.l);
            g09.w().E();
            g09.w().K();
        }
    }

    public void K(z09 z09Var, boolean z, v09 v09Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{z09Var, Boolean.valueOf(z), v09Var}) == null) {
            JSONArray jSONArray = new JSONArray();
            this.r = 0;
            this.s = 0;
            this.t = 0;
            k(z09Var, z, jSONArray);
            s(z09Var, z, jSONArray);
            if (v09Var != null && jSONArray.length() > 0) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("items", jSONArray);
                    int i = this.r + this.s + this.t;
                    jSONObject.put("count", i + "," + this.r + "," + this.t);
                    v09Var.setUBCConfigStatisticData(jSONObject);
                } catch (JSONException e) {
                    if (y) {
                        e.printStackTrace();
                    }
                }
            }
            this.q.Y(z09Var.b());
            this.q.P(z09Var.i() * 86400000);
            this.q.Q(z09Var.h());
            this.q.R(z09Var.c());
            this.q.U(z09Var.f());
            this.q.T(z09Var.e());
            this.q.S(z09Var.d());
            this.q.W(z09Var.j());
            this.q.X(z09Var.k());
            SparseArray<ArrayList> sparseArray = this.n;
            if (sparseArray == null) {
                this.n = new SparseArray<>();
            } else {
                sparseArray.clear();
            }
            HashMap<String, Long> hashMap = this.o;
            if (hashMap == null) {
                this.o = new HashMap<>();
            } else {
                hashMap.clear();
            }
            this.e.x(this.n);
            if (y) {
                Log.d("UBCBehaviorModel", "mIdArray: " + this.n.toString());
            }
            int i2 = 0;
            for (int i3 = 0; i3 < this.n.size(); i3++) {
                int keyAt = this.n.keyAt(i3);
                if (keyAt != 0 && i2 == 0) {
                    i2 = keyAt;
                }
                HashMap<String, Long> hashMap2 = this.o;
                hashMap2.put("ubc_last_upload_time_level_" + keyAt, 0L);
            }
            this.q.V(i2);
            z09Var.b().clear();
        }
    }

    public void L(String str, int i, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048587, this, str, i, str2) == null) {
            this.e.E(str, i, str2);
        }
    }

    public void M() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048588, this) == null) && m19.a(this.d)) {
            o19 h = o19.h(this.d);
            int p = this.q.p();
            h.L(false);
            if (this.v) {
                h.M(this.w);
                this.e.b(h);
            } else {
                h.M(p);
                this.e.a(h);
            }
            int v = h.v();
            if (v > 0) {
                if (y) {
                    Log.d("UBCBehaviorModel", "uploadBackLog size=" + v);
                }
                J(h);
            }
        }
    }

    public final void N(c cVar) {
        boolean a2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, cVar) == null) || cVar == null) {
            return;
        }
        if (l19.m().p() && !m19.a(this.d)) {
            g09.w().V(cVar.e, false);
            return;
        }
        if (cVar.a) {
            a2 = this.p.b(cVar.c, cVar.f, cVar.g, cVar.h);
        } else {
            a2 = this.p.a(cVar.d, cVar.g, cVar.h);
        }
        w09 w09Var = cVar.i;
        if (w09Var != null) {
            w09Var.a(a2, cVar.b);
        }
        if (TextUtils.isEmpty(cVar.e)) {
            return;
        }
        g09.w().V(cVar.e, a2);
    }

    public void O(r09 r09Var) {
        InputStream fileInputStream;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, r09Var) == null) || r09Var == null) {
            return;
        }
        String a2 = r09Var.a();
        File file = new File(this.d.getFilesDir() + File.separator + "ubcsenddir", a2);
        if (file.exists()) {
            if (r09Var.c()) {
                g09.w().Q(o19.g(file, (int) file.length()), a2);
                return;
            }
            InputStream inputStream = null;
            try {
                try {
                    if (y) {
                        Log.d("UBCBehaviorModel", "uploadFile fileName:" + a2);
                    }
                    fileInputStream = new FileInputStream(file);
                } catch (Throwable th) {
                    th = th;
                }
            } catch (Exception e) {
                e = e;
            } catch (OutOfMemoryError e2) {
                e = e2;
            }
            try {
                if (fileInputStream.available() > 0) {
                    inputStream = new Base64InputStream(fileInputStream, 0);
                    JSONObject jSONObject = new JSONObject(j29.b(inputStream));
                    JSONObject jSONObject2 = jSONObject.getJSONObject(TtmlNode.TAG_METADATA);
                    jSONObject2.put("uploadtime", Long.toString(System.currentTimeMillis()));
                    jSONObject.put(TtmlNode.TAG_METADATA, jSONObject2);
                    g09.w().S(jSONObject, a2);
                    fileInputStream = inputStream;
                }
                try {
                    fileInputStream.close();
                } catch (IOException e3) {
                    e = e3;
                    if (!y) {
                        return;
                    }
                    e.printStackTrace();
                }
            } catch (Exception e4) {
                e = e4;
                inputStream = fileInputStream;
                if (y) {
                    Log.d("UBCBehaviorModel", "error:" + e.getMessage());
                }
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e5) {
                        e = e5;
                        if (!y) {
                            return;
                        }
                        e.printStackTrace();
                    }
                }
            } catch (OutOfMemoryError e6) {
                e = e6;
                inputStream = fileInputStream;
                if (y) {
                    Log.d("UBCBehaviorModel", "OutOfMemoryError:" + e.getMessage());
                }
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e7) {
                        e = e7;
                        if (!y) {
                            return;
                        }
                        e.printStackTrace();
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                inputStream = fileInputStream;
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e8) {
                        if (y) {
                            e8.printStackTrace();
                        }
                    }
                }
                throw th;
            }
        }
    }

    public void P(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, str) == null) {
            if (y) {
                Log.d("UBCBehaviorModel", "upload file fail:" + str);
            }
            d19.b("upload file fail");
            this.e.F(str);
        }
    }

    public void Q(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, str) == null) {
            File file = new File(this.d.getFilesDir() + File.separator + "ubcsenddir", str);
            if (y) {
                Log.d("UBCBehaviorModel", "deleteUploadFile file:" + file.getAbsolutePath());
            }
            d19.b("delete file");
            if (file.exists() && file.delete()) {
                Log.d("UBCBehaviorModel", "deleteUploadFile file suc");
                d19.b("delete file suc");
            }
            this.e.l(str);
        }
    }

    public final void R(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048593, this, str) == null) && m19.a(this.d) && j()) {
            o19 h = o19.h(this.d);
            h.L(true);
            h.C();
            ArrayList<String> arrayList = new ArrayList<>(1);
            arrayList.add(str);
            this.e.r(arrayList, true, h);
            J(h);
            y();
        }
    }

    public void S() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048594, this) == null) && m19.a(this.d)) {
            this.e.e();
            o19 h = o19.h(this.d);
            int p = this.q.p();
            h.M(p);
            h.L(true);
            o19 h2 = o19.h(this.d);
            h2.M(p);
            h2.L(false);
            this.e.n(h, h2);
            int v = h.v();
            int v2 = h2.v();
            if (y) {
                Log.d("UBCBehaviorModel", "real size = " + v + "   no real  = " + v2);
            }
            if (v > 0) {
                if (h.z()) {
                    g19.a().l("uploadAll", String.valueOf(p), String.valueOf(v));
                }
                J(h);
            }
            if (v2 > 0) {
                if (h2.z()) {
                    g19.a().l("uploadAll", String.valueOf(p), String.valueOf(v2));
                }
                J(h2);
            }
        }
    }

    public final void T(SparseArray<ArrayList> sparseArray, o19 o19Var) {
        boolean z;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048595, this, sparseArray, o19Var) == null) || sparseArray == null) {
            return;
        }
        boolean H = this.q.H();
        boolean G = this.q.G();
        int m = this.q.m();
        if (H && !G && sparseArray.get(m, null) == null) {
            sparseArray.put(m, new ArrayList(0));
            z = true;
        } else {
            z = false;
        }
        for (int i = 0; i < sparseArray.size() && !o19Var.d(51200); i++) {
            int keyAt = sparseArray.keyAt(i);
            if (keyAt == 0) {
                if (H && G) {
                    this.e.r(new ArrayList<>(this.q.u()), false, o19Var);
                } else {
                    this.e.r(sparseArray.valueAt(i), true, o19Var);
                }
            } else if (this.v) {
                o19Var.M(this.w);
                if (H && !G && keyAt == m) {
                    ArrayList<String> o = o(sparseArray, keyAt);
                    if (o != null) {
                        this.e.t(o, false, o19Var);
                    }
                } else {
                    this.e.t(sparseArray.valueAt(i), true, o19Var);
                }
            } else if (H && !G && keyAt == m) {
                ArrayList<String> o2 = o(sparseArray, keyAt);
                if (o2 != null) {
                    this.e.r(o2, false, o19Var);
                }
            } else {
                this.e.r(sparseArray.valueAt(i), true, o19Var);
            }
            if (o19Var.w()) {
                break;
            }
        }
        if (z) {
            sparseArray.remove(m);
        }
    }

    public final void U() {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048596, this) == null) && m19.a(this.d)) {
            if (y) {
                Log.d("UBCBehaviorModel", " upload no real data");
            }
            this.j = System.currentTimeMillis();
            n19.a().e("ubc_last_upload_non_real", this.j);
            i();
            z();
            this.e.e();
            HashSet hashSet = new HashSet();
            if (this.n == null) {
                r();
            }
            o19 h = o19.h(this.d);
            h.L(false);
            for (int i = 0; i < this.n.size(); i++) {
                int keyAt = this.n.keyAt(i);
                if (keyAt != 0) {
                    HashMap<String, Long> hashMap = this.o;
                    long longValue = hashMap.get("ubc_last_upload_time_level_" + keyAt).longValue();
                    long j = (long) keyAt;
                    long j2 = 60000 * j;
                    if (this.v) {
                        j2 = 1000 * j;
                    }
                    if (longValue == 0 || (longValue + j2) - System.currentTimeMillis() < this.q.t()) {
                        if (this.v) {
                            h.M(this.w);
                            this.e.t(this.n.valueAt(i), true, h);
                        } else {
                            this.e.r(this.n.valueAt(i), true, h);
                        }
                        if (h.w()) {
                            break;
                        }
                        HashMap<String, Long> hashMap2 = this.o;
                        hashMap2.put("ubc_last_upload_time_level_" + keyAt, Long.valueOf(System.currentTimeMillis()));
                        hashSet.add(Integer.valueOf(keyAt));
                    }
                }
            }
            if (h.y()) {
                return;
            }
            boolean H = this.q.H();
            boolean G = this.q.G();
            int m = this.q.m();
            if (H && !G && this.n.get(m, null) == null) {
                this.n.put(m, new ArrayList(0));
                z = true;
            } else {
                z = false;
            }
            if (!this.v) {
                for (int i2 = 0; i2 < this.n.size(); i2++) {
                    int keyAt2 = this.n.keyAt(i2);
                    if (keyAt2 != 0 && !hashSet.contains(Integer.valueOf(keyAt2))) {
                        if (h.d(51200)) {
                            break;
                        }
                        if (H && !G && keyAt2 == m) {
                            ArrayList<String> o = o(this.n, keyAt2);
                            if (o != null) {
                                this.e.r(o, false, h);
                            }
                        } else {
                            this.e.r(this.n.valueAt(i2), true, h);
                        }
                        if (h.w()) {
                            break;
                        }
                    }
                }
            }
            if (z) {
                this.n.remove(m);
            }
            if (y) {
                Log.d("UBCBehaviorModel", "UBC non real time:");
            }
            J(h);
        }
    }

    public final boolean V(q09 q09Var) {
        InterceptResult invokeL;
        SparseArray<ArrayList> sparseArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048597, this, q09Var)) == null) {
            if (m19.a(this.d) && j()) {
                z();
                o19 p = p(q09Var, false);
                if (p == null || p.y()) {
                    return false;
                }
                if ((q09Var.n() & 128) != 0) {
                    ArrayList arrayList = new ArrayList(1);
                    arrayList.add(q09Var.l());
                    sparseArray = new SparseArray<>(1);
                    sparseArray.put(0, arrayList);
                } else {
                    if (this.n == null) {
                        r();
                    }
                    if (Y(p, "0")) {
                        return true;
                    }
                    sparseArray = this.n;
                }
                T(sparseArray, p);
                J(p);
                y();
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void W() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048598, this) == null) && m19.a(this.d) && j()) {
            o19 h = o19.h(this.d);
            h.L(true);
            if (this.n == null) {
                r();
            }
            if (Y(h, "1")) {
                return;
            }
            T(this.n, h);
            J(h);
            y();
        }
    }

    public boolean X(q09 q09Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048599, this, q09Var)) == null) {
            if (m19.a(this.d)) {
                q09Var.A("1");
                o19 p = p(q09Var, true);
                if (p == null || p.y()) {
                    return false;
                }
                this.e.u(p);
                g09.w().U(p.u(), true, q09Var, new b(this));
                p.e();
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final boolean Y(o19 o19Var, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048600, this, o19Var, str)) == null) {
            if (e19.i().d()) {
                List<String> j = e19.i().j();
                if (j != null && j.size() != 0) {
                    ArrayList<String> arrayList = new ArrayList<>();
                    arrayList.addAll(j);
                    if (arrayList.size() == 0) {
                        return true;
                    }
                    this.e.r(arrayList, true, o19Var);
                    J(o19Var);
                    y();
                }
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final void g(q09 q09Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, q09Var) == null) {
            this.i.add(q09Var);
            int i = this.g;
            if (i == 0) {
                this.h = SystemClock.uptimeMillis();
                g09.w().J(this.x, 5000L);
                this.g = 1;
            } else if (i == 2) {
                this.h = SystemClock.uptimeMillis();
                this.g = 1;
            }
        }
    }

    public void h(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048602, this, str, i) == null) {
            z();
            this.e.d(str, i);
            if (!e19.i().d() && Math.abs(System.currentTimeMillis() - this.j) >= j09.o().t()) {
                if (y) {
                    Log.d("UBCBehaviorModel", "cancel flow " + str + " invoke ->uploadNonRealTimeData ");
                }
                U();
            }
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048603, this) == null) {
            G(true);
            G(false);
        }
    }

    public final boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            if (y) {
                return true;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (Math.abs(currentTimeMillis - this.k) > 86400000) {
                this.m = 0;
                this.k = currentTimeMillis;
                n19.a().e("ubc_reset_real_time_count_time", this.k);
                n19.a().d("ubc_real_time_count", this.m);
            }
            if (this.m >= 10000) {
                if (y) {
                    Log.d("UBCBehaviorModel", "real time upload total count check fail");
                }
                int i = this.m;
                if (i == 10000) {
                    this.m = i + 1;
                    if (!y) {
                        g19.a().f(String.valueOf(10000));
                    }
                }
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void k(z09 z09Var, boolean z, JSONArray jSONArray) {
        JSONObject a2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048605, this, new Object[]{z09Var, Boolean.valueOf(z), jSONArray}) == null) || (a2 = z09Var.a()) == null) {
            return;
        }
        Iterator<String> keys = a2.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            try {
                JSONObject jSONObject = new JSONObject();
                m09 p = this.e.p(next);
                String optString = a2.optString(next, "0");
                String j = p != null ? p.j() : "0";
                boolean z2 = Integer.parseInt(j) >= Integer.parseInt(optString);
                if (z && j != null && z2) {
                    jSONObject.put("product", String.format("del/%s", next));
                    jSONObject.put("valid", "2");
                    jSONObject.put("version", optString);
                    jSONArray.put(jSONObject);
                    this.t++;
                } else {
                    jSONObject.put("product", String.format("del/%s", next));
                    jSONObject.put("version", optString);
                    jSONObject.put("valid", "1");
                    if (!this.e.j(next)) {
                        jSONObject.put("valid", "0");
                        this.s++;
                    } else {
                        this.r++;
                    }
                    jSONArray.put(jSONObject);
                }
            } catch (Exception e) {
                if (y) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void l(String str, int i, int i2, long j, JSONArray jSONArray) {
        List<String> j2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048606, this, new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j), jSONArray}) == null) {
            z();
            this.e.m(str, i, j, jSONArray);
            if ((i2 & 128) != 0) {
                R(str);
                return;
            }
            boolean e = this.q.e(str);
            if (e19.i().d()) {
                if (!e || (j2 = e19.i().j()) == null || !j2.contains(str)) {
                    return;
                }
                if (!this.c) {
                    if ((System.currentTimeMillis() - this.b) / 1000 < this.a) {
                        return;
                    }
                    this.c = true;
                }
            }
            if (e) {
                if (y) {
                    Log.d("UBCBehaviorModel", "endFlow flow " + str + " invoke ->uploadRealTimeFlow ");
                }
                W();
            }
            if (!e19.i().d() && Math.abs(System.currentTimeMillis() - this.j) >= j09.o().t()) {
                if (y) {
                    Log.d("UBCBehaviorModel", "endFlow flow " + str + " invoke ->uploadNonRealTimeData ");
                }
                U();
            }
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048607, this) == null) {
            try {
                z();
            } catch (RuntimeException unused) {
                if (y) {
                    Log.d("UBCBehaviorModel", "save cache error!");
                }
            }
        }
    }

    public b19 n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048608, this)) == null) ? this.e : (b19) invokeV.objValue;
    }

    public final ArrayList o(SparseArray<ArrayList> sparseArray, int i) {
        InterceptResult invokeLI;
        ArrayList valueAt;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048609, this, sparseArray, i)) == null) {
            if (sparseArray == null || sparseArray.size() == 0) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < sparseArray.size(); i2++) {
                if (sparseArray.keyAt(i2) != i && (valueAt = sparseArray.valueAt(i2)) != null && valueAt.size() != 0) {
                    arrayList.addAll(valueAt);
                }
            }
            return arrayList;
        }
        return (ArrayList) invokeLI.objValue;
    }

    public final o19 p(q09 q09Var, boolean z) {
        InterceptResult invokeLZ;
        o19 h;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048610, this, q09Var, z)) == null) {
            if (z) {
                h = o19.i();
            } else {
                h = o19.h(this.d);
            }
            if (h.c(q09Var, q09Var.g())) {
                h.L(true);
                if ((q09Var.n() & 128) != 0) {
                    h.C();
                }
                if (!TextUtils.isEmpty(q09Var.h())) {
                    h.K("1");
                }
                return h;
            }
            return null;
        }
        return (o19) invokeLZ.objValue;
    }

    public int q(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048611, this, str)) == null) {
            j09 j09Var = this.q;
            if (j09Var != null) {
                return j09Var.C(str);
            }
            return -1;
        }
        return invokeL.intValue;
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048612, this) == null) && this.n == null) {
            if (y) {
                Log.d("UBCBehaviorModel", "BehaviorModel initCache");
            }
            SparseArray<ArrayList> sparseArray = new SparseArray<>();
            this.n = sparseArray;
            this.e.x(sparseArray);
            if (y) {
                Log.d("UBCBehaviorModel", "mIdArray: " + this.n.toString());
            }
            this.o = new HashMap<>();
            int i = 0;
            for (int i2 = 0; i2 < this.n.size(); i2++) {
                int keyAt = this.n.keyAt(i2);
                if (keyAt != 0 && i == 0) {
                    i = keyAt;
                }
                HashMap<String, Long> hashMap = this.o;
                hashMap.put("ubc_last_upload_time_level_" + keyAt, 0L);
            }
            this.q.V(i);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0119  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void s(z09 z09Var, boolean z, JSONArray jSONArray) {
        List<m09> b2;
        HashMap<String, String> hashMap;
        ArrayList arrayList;
        String str;
        String str2;
        String str3;
        String str4;
        JSONObject jSONObject;
        String optString;
        String j;
        JSONObject jSONObject2;
        boolean z2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048613, this, new Object[]{z09Var, Boolean.valueOf(z), jSONArray}) == null) || (b2 = z09Var.b()) == null || b2.size() == 0) {
            return;
        }
        ArrayList arrayList2 = new ArrayList(b2);
        String str5 = "Json格式转化失败";
        String str6 = "1";
        String str7 = "UBCBehaviorModel";
        if (this.e.q() > 0) {
            ArrayList<String> arrayList3 = new ArrayList<>();
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                arrayList3.add(((m09) it.next()).c());
            }
            HashMap<String, String> o = this.e.o(arrayList3);
            Iterator it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                m09 m09Var = (m09) it2.next();
                String c2 = m09Var.c();
                String str8 = o.get(c2);
                if (!TextUtils.isEmpty(str8)) {
                    try {
                        jSONObject = new JSONObject(str8);
                        optString = jSONObject.optString("version");
                        hashMap = o;
                        try {
                            j = m09Var.j();
                            arrayList = arrayList2;
                        } catch (NumberFormatException unused) {
                            arrayList = arrayList2;
                            str2 = str5;
                            str3 = str7;
                            if (y) {
                                Log.d(str3, "数据转换失败");
                            }
                            str5 = str2;
                            str7 = str3;
                            o = hashMap;
                            arrayList2 = arrayList;
                        } catch (JSONException unused2) {
                            arrayList = arrayList2;
                            str = str5;
                            str4 = str7;
                            if (y) {
                                str2 = str;
                                str3 = str4;
                                Log.d(str3, str2);
                                str5 = str2;
                                str7 = str3;
                                o = hashMap;
                                arrayList2 = arrayList;
                            }
                            str2 = str;
                            str3 = str4;
                            str5 = str2;
                            str7 = str3;
                            o = hashMap;
                            arrayList2 = arrayList;
                        }
                    } catch (NumberFormatException unused3) {
                        hashMap = o;
                    } catch (JSONException unused4) {
                        hashMap = o;
                    }
                    try {
                        jSONObject2 = new JSONObject();
                        str = str5;
                        try {
                            str4 = str7;
                        } catch (NumberFormatException unused5) {
                            str3 = str7;
                            str2 = str;
                        } catch (JSONException unused6) {
                            str4 = str7;
                            if (y) {
                            }
                            str2 = str;
                            str3 = str4;
                            str5 = str2;
                            str7 = str3;
                            o = hashMap;
                            arrayList2 = arrayList;
                        }
                    } catch (NumberFormatException unused7) {
                        str2 = str5;
                        str3 = str7;
                        if (y) {
                        }
                        str5 = str2;
                        str7 = str3;
                        o = hashMap;
                        arrayList2 = arrayList;
                    } catch (JSONException unused8) {
                        str = str5;
                        str4 = str7;
                        if (y) {
                        }
                        str2 = str;
                        str3 = str4;
                        str5 = str2;
                        str7 = str3;
                        o = hashMap;
                        arrayList2 = arrayList;
                    }
                    try {
                        z2 = Integer.parseInt(optString) >= Integer.parseInt(j);
                    } catch (NumberFormatException unused9) {
                        str2 = str;
                        str3 = str4;
                        if (y) {
                        }
                        str5 = str2;
                        str7 = str3;
                        o = hashMap;
                        arrayList2 = arrayList;
                    } catch (JSONException unused10) {
                        if (y) {
                        }
                        str2 = str;
                        str3 = str4;
                        str5 = str2;
                        str7 = str3;
                        o = hashMap;
                        arrayList2 = arrayList;
                    }
                    if (z && optString != null && j != null && z2) {
                        it2.remove();
                        jSONObject2.put("product", "set/" + c2);
                        jSONObject2.put("valid", "2");
                        jSONObject2.put("version", j);
                        jSONArray.put(jSONObject2);
                        this.t++;
                        o = hashMap;
                        arrayList2 = arrayList;
                        str5 = str;
                        str7 = str4;
                    } else {
                        if (!TextUtils.equals(jSONObject.optString("dfc"), "1") && m09Var.l()) {
                            it2.remove();
                        }
                        str2 = str;
                        str3 = str4;
                        str5 = str2;
                        str7 = str3;
                        o = hashMap;
                        arrayList2 = arrayList;
                    }
                }
            }
        }
        ArrayList arrayList4 = arrayList2;
        String str9 = str5;
        String str10 = str7;
        boolean D = this.e.D(arrayList4);
        int size = arrayList4.size();
        if (D) {
            this.r += size;
        } else {
            this.s += size;
            str6 = "0";
        }
        Iterator it3 = arrayList4.iterator();
        while (it3.hasNext()) {
            m09 m09Var2 = (m09) it3.next();
            JSONObject jSONObject3 = new JSONObject();
            String c3 = m09Var2.c();
            String j2 = m09Var2.j();
            try {
                jSONObject3.put("product", "set/" + c3);
                jSONObject3.put("version", j2);
                jSONObject3.put("valid", str6);
            } catch (JSONException unused11) {
                if (y) {
                    Log.d(str10, str9);
                }
            }
            jSONArray.put(jSONObject3);
        }
        z09Var.m(arrayList4);
    }

    public void t(q09 q09Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, q09Var) == null) {
            boolean equals = TextUtils.equals(q09Var.l(), q09Var.k());
            boolean z = false;
            boolean z2 = this.q.e(q09Var.l()) && (q09Var.n() & 64) == 0;
            boolean z3 = (q09Var.n() & 128) != 0;
            if ((equals && z2) || (equals && z3)) {
                z = true;
            }
            if (e19.i().d()) {
                if (!z) {
                    this.e.z(q09Var);
                    return;
                }
                List<String> j = e19.i().j();
                if (j != null && j.contains(q09Var.l())) {
                    if (!this.c) {
                        if ((System.currentTimeMillis() - this.b) / 1000 >= this.a) {
                            this.c = true;
                        } else {
                            this.e.z(q09Var);
                            return;
                        }
                    }
                } else {
                    this.e.z(q09Var);
                    return;
                }
            }
            if (z) {
                this.e.z(q09Var);
            } else if ((q09Var.n() & 1) == 0) {
                if (this.q.K(q09Var.l())) {
                    g(q09Var);
                }
                if (this.i.size() >= 20) {
                    z();
                }
            } else if (this.q.K(q09Var.l())) {
                this.e.z(q09Var);
            }
            g09.w().I(q09Var, z);
        }
    }

    public void u() {
        File[] listFiles;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048615, this) == null) && m19.a(this.d)) {
            if (!j09.o().M() || System.currentTimeMillis() >= j09.o().v()) {
                File file = new File(this.d.getFilesDir() + File.separator + "ubcsenddir");
                if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null) {
                    if (listFiles.length > 1000) {
                        if (!y) {
                            g19.a().d(String.valueOf(1000), listFiles.length);
                        }
                        for (File file2 : listFiles) {
                            file2.delete();
                        }
                        this.e.i();
                    }
                    for (int i = 0; i < listFiles.length; i++) {
                        if (y) {
                            Log.d("UBCBehaviorModel", "uploadFailedData fileName:" + listFiles[i].getAbsolutePath());
                        }
                        r09 w = this.e.w(listFiles[i].getName());
                        if (w != null && TextUtils.equals("0", w.b())) {
                            if (y) {
                                Log.d("UBCBehaviorModel", "processFailedData sending, not send again");
                            }
                            d19.b("processFailedData file, no need to send");
                        } else if (w != null && TextUtils.equals("1", w.b())) {
                            d19.b("processFailedData file, send");
                            this.e.G(listFiles[i].getName(), "0");
                            O(w);
                        } else {
                            if (y) {
                                Log.d("UBCBehaviorModel", "processFailedData data in db");
                            }
                            d19.b("processFailedData file, data in db, delete file");
                            listFiles[i].delete();
                        }
                    }
                }
            }
        }
    }

    public void v() {
        File[] listFiles;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048616, this) == null) && m19.a(this.d)) {
            File file = new File(this.d.getFilesDir() + File.separator + "ubcsenddir");
            if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null) {
                for (int i = 0; i < listFiles.length; i++) {
                    r09 w = this.e.w(listFiles[i].getName());
                    if (w != null && TextUtils.equals("1", w.b())) {
                        if (y) {
                            Log.d("UBCBehaviorModel", "processOneFailedData send " + listFiles[i].getAbsolutePath());
                        }
                        d19.b("processOneFailedData file, send");
                        this.e.G(listFiles[i].getName(), "0");
                        O(w);
                        return;
                    }
                }
            }
        }
    }

    public void w(q09 q09Var, boolean z) {
        SparseArray<ArrayList> sparseArray;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048617, this, q09Var, z) == null) {
            if (z) {
                if (!m19.a(this.d) || !j()) {
                    return;
                }
                z();
                o19 h = o19.h(this.d);
                h.L(true);
                if ((q09Var.n() & 128) != 0) {
                    h.C();
                    ArrayList arrayList = new ArrayList(1);
                    arrayList.add(q09Var.l());
                    sparseArray = new SparseArray<>(1);
                    sparseArray.put(0, arrayList);
                } else {
                    if (this.n == null) {
                        r();
                    }
                    if (Y(h, "0")) {
                        return;
                    }
                    sparseArray = this.n;
                }
                T(sparseArray, h);
                if (h.y()) {
                    return;
                }
                J(h);
                y();
            }
            x();
        }
    }

    public final void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
            if (e19.i().d()) {
                this.e.e();
            } else if (Math.abs(System.currentTimeMillis() - this.j) >= j09.o().t()) {
                U();
            }
        }
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048619, this) == null) {
            this.m++;
            n19.a().d("ubc_real_time_count", this.m);
        }
    }

    public final void z() {
        List<q09> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048620, this) == null) || (list = this.i) == null || list.size() == 0) {
            return;
        }
        this.e.A(this.i);
        this.i.clear();
        if (this.g == 1) {
            this.g = 2;
        }
    }
}

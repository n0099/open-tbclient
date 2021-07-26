package d.a.s0;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.logsystem.basic.upload.Constant;
import com.baidu.tieba.tblauncher.MainTabActivity;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.ubc.UBC;
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
import org.apache.commons.codec.binary4util.bdapp.Base64InputStream;
import org.apache.commons.codec.binary4util.bdapp.Base64OutputStream;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean v;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f68021a;

    /* renamed from: b  reason: collision with root package name */
    public long f68022b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f68023c;

    /* renamed from: d  reason: collision with root package name */
    public Context f68024d;

    /* renamed from: e  reason: collision with root package name */
    public y f68025e;

    /* renamed from: f  reason: collision with root package name */
    public d.a.s0.b f68026f;

    /* renamed from: g  reason: collision with root package name */
    public int f68027g;

    /* renamed from: h  reason: collision with root package name */
    public long f68028h;

    /* renamed from: i  reason: collision with root package name */
    public List<o> f68029i;
    public long j;
    public long k;
    public long l;
    public int m;
    public SparseArray<ArrayList> n;
    public HashMap<String, Long> o;
    public v p;
    public g q;
    public int r;
    public int s;
    public int t;
    public Runnable u;

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f68030e;

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f68030e = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f68030e.f68027g == 1) {
                    long uptimeMillis = SystemClock.uptimeMillis() - this.f68030e.f68028h;
                    if (uptimeMillis >= 5000) {
                        if (c.v) {
                            Log.d("UBCBehaviorModel", String.format("***saveCache after %d ms***", Long.valueOf(uptimeMillis)));
                        }
                        this.f68030e.v();
                        this.f68030e.f68027g = 0;
                        return;
                    }
                    d.q().z(this, 5000 - uptimeMillis);
                } else if (this.f68030e.f68027g == 2) {
                    this.f68030e.f68027g = 0;
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements u {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f68031a;

        public b(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f68031a = cVar;
        }

        @Override // d.a.s0.u
        public void a(boolean z, o oVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, oVar) == null) {
                if (!z) {
                    this.f68031a.f68025e.r(oVar);
                } else {
                    this.f68031a.f68025e.d();
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-457472827, "Ld/a/s0/c;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-457472827, "Ld/a/s0/c;");
                return;
            }
        }
        v = AppConfig.isDebug();
    }

    public c(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f68023c = false;
        this.f68027g = 0;
        this.f68028h = 0L;
        this.u = new a(this);
        this.f68024d = context;
        h0 e2 = h0.e();
        this.f68025e = new y(context);
        this.f68026f = new d.a.s0.b(context);
        this.p = f0.a();
        this.f68029i = new ArrayList(20);
        this.j = e2.getLong("ubc_last_upload_non_real", 0L);
        this.k = e2.getLong("ubc_reset_real_time_count_time", 0L);
        this.l = e2.getLong("ubc_last_upload_failed_data_time", 0L);
        this.m = e2.getInt("ubc_real_time_count", 0);
        g m = g.m();
        this.q = m;
        m.t(this, context);
        this.f68022b = System.currentTimeMillis();
        this.f68021a = new Random().nextInt(31) + 60;
    }

    public void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            i0 i0Var = new i0();
            if (this.f68026f.e(i0Var)) {
                JSONObject i2 = i0Var.i();
                if (v) {
                    Log.d("UBCBehaviorModel", "sendQualityData:" + i2.toString());
                }
                d.q().E(i2);
            }
        }
    }

    public final void B(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            i0 i0Var = new i0();
            i0Var.r(z);
            if (this.f68026f.f(i0Var, z)) {
                JSONObject i2 = i0Var.i();
                if (v) {
                    Log.d("UBCBehaviorModel", "checkFileData:" + i2.toString());
                }
                this.f68026f.c(z);
                d.q().E(i2);
            }
        }
    }

    public void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f68025e.u();
        }
    }

    public void D(q qVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, qVar) == null) {
            this.f68025e.t(qVar);
        }
    }

    public final void E(i0 i0Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, i0Var) == null) || i0Var.j()) {
            return;
        }
        try {
            JSONObject i2 = i0Var.i();
            String b2 = g0.b(i2.toString().getBytes(), true);
            z(i2.toString(), b2);
            if (v) {
                a0.a(i0Var);
                Log.d("UBCBehaviorModel", "save send data to file " + b2);
            }
            if (!this.f68025e.c(i0Var.f(), i0Var.e(), i0Var.l(), b2)) {
                i0Var.c();
                File file = new File(this.f68024d.getFilesDir() + File.separator + "ubcsenddir", b2);
                if (file.exists() && file.delete()) {
                    Log.d("UBCBehaviorModel", "db fail deleteUploadFile file suc");
                }
                this.f68025e.g(b2);
                return;
            }
            d.q().F(i2, b2);
            i0Var.c();
            long currentTimeMillis = System.currentTimeMillis();
            if (Math.abs(currentTimeMillis - this.l) < MainTabActivity.SERVICE_BETWEEN_TIME) {
                return;
            }
            this.l = currentTimeMillis;
            h0.e().putLong("ubc_last_upload_failed_data_time", this.l);
            d.q().w();
        } catch (OutOfMemoryError unused) {
            i0Var.c();
        }
    }

    public void F(x xVar, boolean z, t tVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{xVar, Boolean.valueOf(z), tVar}) == null) {
            JSONArray jSONArray = new JSONArray();
            this.r = 0;
            this.s = 0;
            this.t = 0;
            k(xVar, z, jSONArray);
            r(xVar, z, jSONArray);
            if (tVar != null && jSONArray.length() > 0) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("items", jSONArray);
                    jSONObject.put("count", String.format("%d,%d,%d", Integer.valueOf(this.r + this.s + this.t), Integer.valueOf(this.r), Integer.valueOf(this.t)));
                    tVar.setUBCConfigStatisticData(jSONObject);
                } catch (JSONException e2) {
                    if (v) {
                        e2.printStackTrace();
                    }
                }
            }
            this.q.F(xVar.b());
            int g2 = xVar.g();
            if (g2 > 0) {
                this.q.A(g2 * 86400000);
            }
            if (xVar.f() > 0) {
                this.q.B(xVar.f());
            }
            int c2 = xVar.c();
            if (c2 > 307200) {
                this.q.C(c2);
            }
            int d2 = xVar.d();
            if (d2 > 30720) {
                this.q.D(d2);
            }
            if (this.n == null) {
                this.n = new SparseArray<>();
            }
            this.n.clear();
            if (this.o == null) {
                this.o = new HashMap<>();
            }
            this.o.clear();
            this.f68025e.p(this.n);
            int i2 = 0;
            for (int i3 = 0; i3 < this.n.size(); i3++) {
                int keyAt = this.n.keyAt(i3);
                if (keyAt != 0 && i2 == 0) {
                    i2 = keyAt;
                }
                HashMap<String, Long> hashMap = this.o;
                hashMap.put("ubc_last_upload_time_level_" + keyAt, 0L);
            }
            this.q.E(i2);
            xVar.b().clear();
        }
    }

    public void G(String str, int i2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048582, this, str, i2, str2) == null) {
            this.f68025e.w(str, i2, str2);
        }
    }

    public final void H(JSONObject jSONObject, String str, boolean z, o oVar, u uVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048583, this, new Object[]{jSONObject, str, Boolean.valueOf(z), oVar, uVar}) == null) {
            boolean a2 = this.p.a(jSONObject, z);
            if (uVar != null) {
                uVar.a(a2, oVar);
            }
            if (TextUtils.isEmpty(str)) {
                return;
            }
            d.q().I(str, a2);
        }
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:39:0x00ce -> B:53:0x00d1). Please submit an issue!!! */
    public void I(String str) {
        InputStream fileInputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            File file = new File(this.f68024d.getFilesDir() + File.separator + "ubcsenddir", str);
            InputStream inputStream = null;
            try {
                try {
                    try {
                        if (v) {
                            Log.d("UBCBehaviorModel", "uploadFile fileName:" + str);
                        }
                        fileInputStream = new FileInputStream(file);
                    } catch (Throwable th) {
                        th = th;
                    }
                } catch (Exception e2) {
                    e = e2;
                } catch (OutOfMemoryError e3) {
                    e = e3;
                }
            } catch (IOException e4) {
                e4.printStackTrace();
            }
            try {
                if (fileInputStream.available() > 0) {
                    inputStream = new Base64InputStream(fileInputStream, 0);
                    JSONObject jSONObject = new JSONObject(StringUtil.getStringFromInput(inputStream));
                    JSONObject jSONObject2 = jSONObject.getJSONObject("metadata");
                    jSONObject2.put("uploadtime", Long.toString(System.currentTimeMillis()));
                    jSONObject.put("metadata", jSONObject2);
                    d.q().F(jSONObject, str);
                    fileInputStream = inputStream;
                }
                fileInputStream.close();
            } catch (Exception e5) {
                e = e5;
                inputStream = fileInputStream;
                if (v) {
                    Log.d("UBCBehaviorModel", "error:" + e.getMessage());
                }
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (OutOfMemoryError e6) {
                e = e6;
                inputStream = fileInputStream;
                if (v) {
                    Log.d("UBCBehaviorModel", "OutOfMemoryError:" + e.getMessage());
                }
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (Throwable th2) {
                th = th2;
                inputStream = fileInputStream;
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e7) {
                        e7.printStackTrace();
                    }
                }
                throw th;
            }
        }
    }

    public void J(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            if (v) {
                Log.d("UBCBehaviorModel", "upload file fail:" + str);
            }
            a0.b("upload file fail");
            this.f68025e.x(str);
        }
    }

    public void K(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            File file = new File(this.f68024d.getFilesDir() + File.separator + "ubcsenddir", str);
            if (v) {
                Log.d("UBCBehaviorModel", "deleteUploadFile file:" + file.getAbsolutePath());
            }
            a0.b("delete file");
            if (file.exists() && file.delete()) {
                Log.d("UBCBehaviorModel", "deleteUploadFile file suc");
                a0.b("delete file suc");
            }
            this.f68025e.g(str);
        }
    }

    public void L() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && s(this.f68024d)) {
            this.f68025e.b();
            i0 i0Var = new i0();
            i0Var.s(this.q.n());
            i0Var.r(true);
            i0 i0Var2 = new i0();
            i0Var2.s(this.q.n());
            i0Var2.r(false);
            if (this.f68025e.i(i0Var, i0Var2) == 0) {
                return;
            }
            if (v) {
                int length = i0Var.d().length();
                int length2 = i0Var2.d().length();
                Log.d("UBCBehaviorModel", "real size = " + length + "   no real  = " + length2);
            }
            if (i0Var.d().length() > 0) {
                E(i0Var);
            }
            if (i0Var2.d().length() > 0) {
                E(i0Var2);
            }
        }
    }

    public final void M(SparseArray<ArrayList> sparseArray, i0 i0Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, sparseArray, i0Var) == null) {
            for (int i2 = 0; i2 < sparseArray.size() && !i0Var.b(51200); i2++) {
                this.f68025e.m(sparseArray.valueAt(i2), i0Var);
            }
        }
    }

    public final void N() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048589, this) == null) && s(this.f68024d)) {
            if (v) {
                Log.d("UBCBehaviorModel", " upload no real data");
            }
            this.j = System.currentTimeMillis();
            h0.e().putLong("ubc_last_upload_non_real", this.j);
            i();
            v();
            this.f68025e.b();
            HashSet hashSet = new HashSet();
            if (this.n == null) {
                q();
            }
            i0 i0Var = new i0();
            i0Var.r(false);
            int i2 = 0;
            for (int i3 = 0; i3 < this.n.size(); i3++) {
                int keyAt = this.n.keyAt(i3);
                if (keyAt != 0) {
                    HashMap<String, Long> hashMap = this.o;
                    long longValue = hashMap.get("ubc_last_upload_time_level_" + keyAt).longValue();
                    if (longValue == 0 || (longValue + (keyAt * 60000)) - System.currentTimeMillis() < this.q.p()) {
                        i2 |= this.f68025e.m(this.n.valueAt(i3), i0Var);
                        HashMap<String, Long> hashMap2 = this.o;
                        hashMap2.put("ubc_last_upload_time_level_" + keyAt, Long.valueOf(System.currentTimeMillis()));
                        hashSet.add(Integer.valueOf(keyAt));
                    }
                }
            }
            if (i2 == 0) {
                return;
            }
            for (int i4 = 0; i4 < this.n.size(); i4++) {
                int keyAt2 = this.n.keyAt(i4);
                if (keyAt2 != 0 && !hashSet.contains(Integer.valueOf(keyAt2))) {
                    if (i0Var.b(51200)) {
                        break;
                    }
                    this.f68025e.m(this.n.valueAt(i4), i0Var);
                }
            }
            if (v) {
                Log.d("UBCBehaviorModel", "UBC non real time:");
            }
            E(i0Var);
        }
    }

    public final boolean O(o oVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, oVar)) == null) {
            if (s(this.f68024d) && j()) {
                v();
                i0 o = o(oVar);
                if (o == null) {
                    return false;
                }
                if (this.n == null) {
                    q();
                }
                if (R(o, "0")) {
                    return true;
                }
                M(this.n, o);
                E(o);
                u();
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void P() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048591, this) == null) && s(this.f68024d) && j()) {
            i0 i0Var = new i0();
            i0Var.r(true);
            if (this.n == null) {
                q();
            }
            if (R(i0Var, "1")) {
                return;
            }
            M(this.n, i0Var);
            E(i0Var);
            u();
        }
    }

    public boolean Q(o oVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, oVar)) == null) {
            if (s(this.f68024d)) {
                oVar.q("1");
                i0 o = o(oVar);
                if (o.j()) {
                    return false;
                }
                this.f68025e.n(o);
                d.q().H(o.i(), true, oVar, new b(this));
                o.c();
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final boolean R(i0 i0Var, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048593, this, i0Var, str)) == null) {
            if (UBC.getUBCContext().a()) {
                List<String> b2 = UBC.getUBCContext().b();
                if (b2 != null && b2.size() != 0) {
                    ArrayList<j> arrayList = new ArrayList<>();
                    for (int i2 = 0; i2 < b2.size(); i2++) {
                        arrayList.add(new j(b2.get(i2), str));
                    }
                    if (arrayList.size() == 0) {
                        return true;
                    }
                    this.f68025e.m(arrayList, i0Var);
                    E(i0Var);
                    u();
                }
                return true;
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public final void g(o oVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, oVar) == null) {
            this.f68029i.add(oVar);
            int i2 = this.f68027g;
            if (i2 == 0) {
                this.f68028h = SystemClock.uptimeMillis();
                d.q().z(this.u, 5000L);
                this.f68027g = 1;
            } else if (i2 == 2) {
                this.f68028h = SystemClock.uptimeMillis();
                this.f68027g = 1;
            }
        }
    }

    public void h(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048595, this, str, i2) == null) {
            v();
            this.f68025e.a(str, i2);
            if (!UBC.getUBCContext().a() && Math.abs(System.currentTimeMillis() - this.j) >= g.m().p()) {
                if (v) {
                    Log.d("UBCBehaviorModel", "cancel flow " + str + " invoke ->uploadNonRealTimeData ");
                }
                N();
            }
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            B(true);
            B(false);
        }
    }

    public final boolean j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            if (AppConfig.isDebug()) {
                return true;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (Math.abs(currentTimeMillis - this.k) > 86400000) {
                this.m = 0;
                this.k = currentTimeMillis;
                h0.e().putLong("ubc_reset_real_time_count_time", this.k);
                h0.e().putInt("ubc_real_time_count", this.m);
            }
            if (this.m >= 10000) {
                if (v) {
                    Log.d("UBCBehaviorModel", "real time upload total count check fail");
                }
                int i2 = this.m;
                if (i2 == 10000) {
                    this.m = i2 + 1;
                    if (!v) {
                        b0.a().f(String.valueOf(10000));
                    }
                }
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void k(x xVar, boolean z, JSONArray jSONArray) {
        JSONObject a2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048598, this, new Object[]{xVar, Boolean.valueOf(z), jSONArray}) == null) || (a2 = xVar.a()) == null) {
            return;
        }
        Iterator<String> keys = a2.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            try {
                JSONObject jSONObject = new JSONObject();
                k k = this.f68025e.k(next);
                String optString = a2.optString(next, "0");
                String h2 = k != null ? k.h() : "0";
                boolean z2 = Integer.parseInt(h2) >= Integer.parseInt(optString);
                if (z && h2 != null && z2) {
                    jSONObject.put("product", String.format("del/%s", next));
                    jSONObject.put("valid", "2");
                    jSONObject.put("version", optString);
                    jSONArray.put(jSONObject);
                    this.t++;
                } else {
                    jSONObject.put("product", String.format("del/%s", next));
                    jSONObject.put("version", optString);
                    jSONObject.put("valid", "1");
                    if (!this.f68025e.f(next)) {
                        jSONObject.put("valid", "0");
                        this.s++;
                    } else {
                        this.r++;
                    }
                    jSONArray.put(jSONObject);
                }
            } catch (Exception e2) {
                if (v) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public void l(String str, int i2, long j, JSONArray jSONArray) {
        List<String> b2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048599, this, new Object[]{str, Integer.valueOf(i2), Long.valueOf(j), jSONArray}) == null) {
            v();
            this.f68025e.h(str, i2, j, jSONArray);
            boolean e2 = this.q.e(str);
            if (UBC.getUBCContext().a()) {
                if (!e2 || (b2 = UBC.getUBCContext().b()) == null || !b2.contains(str)) {
                    return;
                }
                if (!this.f68023c) {
                    if ((System.currentTimeMillis() - this.f68022b) / 1000 < this.f68021a) {
                        return;
                    }
                    this.f68023c = true;
                }
            }
            if (e2) {
                if (v) {
                    Log.d("UBCBehaviorModel", "endFlow flow " + str + " invoke ->uploadRealTimeFlow ");
                }
                P();
            }
            if (!UBC.getUBCContext().a() && Math.abs(System.currentTimeMillis() - this.j) >= g.m().p()) {
                if (v) {
                    Log.d("UBCBehaviorModel", "endFlow flow " + str + " invoke ->uploadNonRealTimeData ");
                }
                N();
            }
        }
    }

    public void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            try {
                v();
            } catch (RuntimeException unused) {
                if (v) {
                    Log.d("UBCBehaviorModel", "save cache error!");
                }
            }
        }
    }

    public y n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) ? this.f68025e : (y) invokeV.objValue;
    }

    public final i0 o(o oVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048602, this, oVar)) == null) {
            i0 i0Var = new i0();
            i0Var.r(true);
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("id", oVar.g());
                jSONObject.put("timestamp", Long.toString(oVar.k()));
                if (oVar.h() != null) {
                    jSONObject.put("content", oVar.h().toString());
                } else {
                    jSONObject.put("content", oVar.b());
                }
                jSONObject.put("type", "0");
                String str = "1";
                if (!TextUtils.isEmpty(oVar.c())) {
                    jSONObject.put("abtest", oVar.c());
                    i0Var.q("1");
                }
                if (!TextUtils.isEmpty(oVar.a())) {
                    jSONObject.put("c", oVar.a());
                }
                if (oVar.l()) {
                    jSONObject.put("of", "1");
                }
                jSONObject.put(Constant.ID_TYPE, this.q.r(oVar.g()));
                if (!this.q.z(oVar.g())) {
                    str = "0";
                }
                jSONObject.put(Constant.IS_REAL, str);
                String l = this.q.l(oVar.g());
                if (!TextUtils.isEmpty(l) && !TextUtils.equals(l, "0")) {
                    jSONObject.put("gflow", l);
                }
                i0Var.a(jSONObject);
                i0Var.p(oVar.k(), oVar.k());
                return i0Var;
            } catch (JSONException e2) {
                e2.printStackTrace();
                return null;
            }
        }
        return (i0) invokeL.objValue;
    }

    public String p(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, str)) == null) {
            g gVar = this.q;
            return gVar != null ? gVar.s(str) : "";
        }
        return (String) invokeL.objValue;
    }

    public final void q() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048604, this) == null) && this.n == null) {
            if (v) {
                Log.d("UBCBehaviorModel", "BehaviorModel initCache");
            }
            SparseArray<ArrayList> sparseArray = new SparseArray<>();
            this.n = sparseArray;
            this.f68025e.p(sparseArray);
            this.o = new HashMap<>();
            int i2 = 0;
            for (int i3 = 0; i3 < this.n.size(); i3++) {
                int keyAt = this.n.keyAt(i3);
                if (keyAt != 0 && i2 == 0) {
                    i2 = keyAt;
                }
                HashMap<String, Long> hashMap = this.o;
                hashMap.put("ubc_last_upload_time_level_" + keyAt, 0L);
            }
            this.q.E(i2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x0104  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x011b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void r(x xVar, boolean z, JSONArray jSONArray) {
        List<k> b2;
        HashMap<String, String> hashMap;
        ArrayList arrayList;
        String str;
        String str2;
        String str3;
        String str4;
        JSONObject jSONObject;
        String optString;
        String h2;
        JSONObject jSONObject2;
        boolean z2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048605, this, new Object[]{xVar, Boolean.valueOf(z), jSONArray}) == null) || (b2 = xVar.b()) == null || b2.size() == 0) {
            return;
        }
        ArrayList arrayList2 = new ArrayList(b2);
        String str5 = "Json格式转化失败";
        String str6 = "UBCBehaviorModel";
        if (this.f68025e.l() > 0) {
            ArrayList<String> arrayList3 = new ArrayList<>();
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                arrayList3.add(((k) it.next()).b());
            }
            HashMap<String, String> j = this.f68025e.j(arrayList3);
            Iterator it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                k kVar = (k) it2.next();
                String b3 = kVar.b();
                String str7 = j.get(b3);
                if (!TextUtils.isEmpty(str7)) {
                    try {
                        jSONObject = new JSONObject(str7);
                        optString = jSONObject.optString("version");
                        hashMap = j;
                    } catch (NumberFormatException unused) {
                        hashMap = j;
                    } catch (JSONException unused2) {
                        hashMap = j;
                    }
                    try {
                        h2 = kVar.h();
                        arrayList = arrayList2;
                        try {
                            jSONObject2 = new JSONObject();
                            str = str5;
                        } catch (NumberFormatException unused3) {
                            str2 = str5;
                            str3 = str6;
                            if (v) {
                                Log.d(str3, "数据转换失败");
                            }
                            str5 = str2;
                            str6 = str3;
                            j = hashMap;
                            arrayList2 = arrayList;
                        } catch (JSONException unused4) {
                            str = str5;
                            str4 = str6;
                            if (v) {
                                str2 = str;
                                str3 = str4;
                                Log.d(str3, str2);
                                str5 = str2;
                                str6 = str3;
                                j = hashMap;
                                arrayList2 = arrayList;
                            }
                            str2 = str;
                            str3 = str4;
                            str5 = str2;
                            str6 = str3;
                            j = hashMap;
                            arrayList2 = arrayList;
                        }
                    } catch (NumberFormatException unused5) {
                        arrayList = arrayList2;
                        str2 = str5;
                        str3 = str6;
                        if (v) {
                        }
                        str5 = str2;
                        str6 = str3;
                        j = hashMap;
                        arrayList2 = arrayList;
                    } catch (JSONException unused6) {
                        arrayList = arrayList2;
                        str = str5;
                        str4 = str6;
                        if (v) {
                        }
                        str2 = str;
                        str3 = str4;
                        str5 = str2;
                        str6 = str3;
                        j = hashMap;
                        arrayList2 = arrayList;
                    }
                    try {
                        str4 = str6;
                    } catch (NumberFormatException unused7) {
                        str3 = str6;
                        str2 = str;
                    } catch (JSONException unused8) {
                        str4 = str6;
                        if (v) {
                        }
                        str2 = str;
                        str3 = str4;
                        str5 = str2;
                        str6 = str3;
                        j = hashMap;
                        arrayList2 = arrayList;
                    }
                    try {
                        z2 = Integer.parseInt(optString) >= Integer.parseInt(h2);
                    } catch (NumberFormatException unused9) {
                        str2 = str;
                        str3 = str4;
                        if (v) {
                        }
                        str5 = str2;
                        str6 = str3;
                        j = hashMap;
                        arrayList2 = arrayList;
                    } catch (JSONException unused10) {
                        if (v) {
                        }
                        str2 = str;
                        str3 = str4;
                        str5 = str2;
                        str6 = str3;
                        j = hashMap;
                        arrayList2 = arrayList;
                    }
                    if (z && optString != null && h2 != null && z2) {
                        it2.remove();
                        jSONObject2.put("product", "set/" + b3);
                        jSONObject2.put("valid", "2");
                        jSONObject2.put("version", h2);
                        jSONArray.put(jSONObject2);
                        this.t++;
                        j = hashMap;
                        arrayList2 = arrayList;
                        str5 = str;
                        str6 = str4;
                    } else {
                        if (!TextUtils.equals(jSONObject.optString("dfc"), "1") && TextUtils.equals(kVar.getIsDefaultConfig(), "1")) {
                            it2.remove();
                        }
                        str2 = str;
                        str3 = str4;
                        str5 = str2;
                        str6 = str3;
                        j = hashMap;
                        arrayList2 = arrayList;
                    }
                }
            }
        }
        ArrayList arrayList4 = arrayList2;
        String str8 = str5;
        String str9 = str6;
        boolean v2 = this.f68025e.v(arrayList4);
        Iterator it3 = arrayList4.iterator();
        while (it3.hasNext()) {
            k kVar2 = (k) it3.next();
            JSONObject jSONObject3 = new JSONObject();
            try {
                jSONObject3.put("product", "set/" + kVar2.b());
                jSONObject3.put("version", kVar2.h());
                if (v2) {
                    jSONObject3.put("valid", "1");
                    this.r++;
                } else {
                    jSONObject3.put("valid", "0");
                    try {
                        this.s++;
                    } catch (JSONException unused11) {
                        if (v) {
                            Log.d(str9, str8);
                        }
                        jSONArray.put(jSONObject3);
                    }
                }
            } catch (JSONException unused12) {
            }
            jSONArray.put(jSONObject3);
        }
        xVar.i(arrayList4);
    }

    @SuppressLint({"MissingPermission"})
    public final boolean s(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048606, this, context)) == null) {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity");
            if (connectivityManager == null) {
                return false;
            }
            NetworkInfo networkInfo = null;
            try {
                networkInfo = connectivityManager.getActiveNetworkInfo();
            } catch (Exception unused) {
                if (v) {
                    Log.d("UBCBehaviorModel", "get network info error!");
                }
            }
            return networkInfo != null && networkInfo.isAvailable();
        }
        return invokeL.booleanValue;
    }

    public void t() {
        File[] listFiles;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048607, this) == null) && s(this.f68024d)) {
            File file = new File(this.f68024d.getFilesDir() + File.separator + "ubcsenddir");
            if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null) {
                if (listFiles.length > 1000) {
                    if (!v) {
                        b0.a().d(String.valueOf(1000), listFiles.length);
                    }
                    for (File file2 : listFiles) {
                        file2.delete();
                    }
                    this.f68025e.e();
                }
                for (int i2 = 0; i2 < listFiles.length; i2++) {
                    if (v) {
                        Log.d("UBCBehaviorModel", "uploadFailedData fileName:" + listFiles[i2].getAbsolutePath());
                    }
                    p o = this.f68025e.o(listFiles[i2].getName());
                    if (o != null && TextUtils.equals("0", o.a())) {
                        if (v) {
                            Log.d("UBCBehaviorModel", "processFailedData sending, not send again");
                        }
                        a0.b("processFailedData file, no need to send");
                    } else if (o != null && TextUtils.equals("1", o.a())) {
                        a0.b("processFailedData file, send");
                        this.f68025e.y(listFiles[i2].getName(), "0");
                        I(listFiles[i2].getName());
                    } else {
                        if (v) {
                            Log.d("UBCBehaviorModel", "processFailedData data in db");
                        }
                        a0.b("processFailedData file, data in db, delete file");
                        listFiles[i2].delete();
                    }
                }
            }
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048608, this) == null) {
            this.m++;
            h0.e().putInt("ubc_real_time_count", this.m);
        }
    }

    public final void v() {
        List<o> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048609, this) == null) || (list = this.f68029i) == null || list.size() == 0) {
            return;
        }
        this.f68025e.s(this.f68029i);
        this.f68029i.clear();
        if (this.f68027g == 1) {
            this.f68027g = 2;
        }
    }

    public void w(o oVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048610, this, oVar) == null) {
            boolean z = TextUtils.equals(oVar.g(), oVar.f()) && this.q.e(oVar.g()) && (oVar.i() & 64) == 0;
            if (UBC.getUBCContext().a()) {
                if (!z) {
                    this.f68025e.r(oVar);
                    return;
                }
                List<String> b2 = UBC.getUBCContext().b();
                if (b2 != null && b2.contains(oVar.g())) {
                    if (!this.f68023c) {
                        if ((System.currentTimeMillis() - this.f68022b) / 1000 >= this.f68021a) {
                            this.f68023c = true;
                        } else {
                            this.f68025e.r(oVar);
                            return;
                        }
                    }
                } else {
                    this.f68025e.r(oVar);
                    return;
                }
            }
            if (z && !O(oVar)) {
                if (this.q.x(oVar.g())) {
                    this.f68025e.r(oVar);
                }
            } else if (UBC.getUBCContext().a()) {
                this.f68025e.b();
            } else if (Math.abs(System.currentTimeMillis() - this.j) >= g.m().p()) {
                if (!z && this.q.x(oVar.g())) {
                    g(oVar);
                }
                N();
            } else if ((1 & oVar.i()) == 0) {
                if (!z && this.q.x(oVar.g())) {
                    g(oVar);
                }
                if (this.f68029i.size() >= 20) {
                    v();
                }
            } else if (z || !this.q.x(oVar.g())) {
            } else {
                this.f68025e.r(oVar);
            }
        }
    }

    public void x(o oVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048611, this, oVar) == null) {
            this.f68026f.g(oVar, this.q.e(oVar.g()));
        }
    }

    public void y(o oVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048612, this, oVar) == null) && d.a.h0.b.a.a.g()) {
            this.f68026f.i(oVar);
        }
    }

    public final void z(String str, String str2) {
        OutputStream fileOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048613, this, str, str2) == null) {
            String str3 = this.f68024d.getFilesDir() + File.separator + "ubcsenddir";
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
                    try {
                        fileOutputStream = new FileOutputStream(file2);
                    } catch (Exception e2) {
                        e = e2;
                    }
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    outputStream = new Base64OutputStream(fileOutputStream, 0);
                    outputStream.write(str.getBytes());
                    outputStream.flush();
                    a0.b("save to file suc");
                    outputStream.close();
                } catch (Exception e3) {
                    e = e3;
                    outputStream = fileOutputStream;
                    e.printStackTrace();
                    if (outputStream != null) {
                        outputStream.close();
                    }
                } catch (Throwable th2) {
                    th = th2;
                    outputStream = fileOutputStream;
                    if (outputStream != null) {
                        try {
                            outputStream.close();
                        } catch (Exception e4) {
                            e4.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (Exception e5) {
                e5.printStackTrace();
            }
        }
    }
}

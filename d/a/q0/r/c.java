package d.a.q0.r;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import android.util.Base64InputStream;
import android.util.Base64OutputStream;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.live.interfaces.DI;
import com.baidu.searchbox.logsystem.basic.upload.Constant;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f54287a;

    /* renamed from: b  reason: collision with root package name */
    public a f54288b;

    /* renamed from: c  reason: collision with root package name */
    public b f54289c;

    /* renamed from: d  reason: collision with root package name */
    public List<i> f54290d;

    /* renamed from: e  reason: collision with root package name */
    public long f54291e;

    /* renamed from: f  reason: collision with root package name */
    public long f54292f;

    /* renamed from: g  reason: collision with root package name */
    public long f54293g;

    /* renamed from: h  reason: collision with root package name */
    public int f54294h;

    /* renamed from: i  reason: collision with root package name */
    public SparseArray<ArrayList> f54295i;
    public HashMap<String, Long> j;
    public m k;
    public d l;

    public c(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f54287a = context;
        this.f54288b = new a(context);
        this.f54289c = new b(context);
        this.k = e.h().m();
        this.f54290d = new ArrayList(20);
        t g2 = t.g();
        this.f54291e = g2.getLong("ubc_last_upload_all_time", 0L);
        this.f54292f = g2.getLong("ubc_last_upload_non_real", 0L);
        this.f54293g = g2.getLong("ubc_reset_real_time_count_time", 0L);
        this.f54294h = g2.getInt("ubc_real_time_count", 0);
        d g3 = d.g();
        this.l = g3;
        g3.k(this, context);
    }

    public final boolean A(i iVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, iVar)) == null) {
            if (g(this.f54287a) && c()) {
                j();
                u uVar = new u();
                uVar.f54413g = true;
                JSONObject jSONObject = iVar.f54328e;
                try {
                    if (jSONObject != null && jSONObject.has("bizId")) {
                        r.a(jSONObject);
                        uVar.a(jSONObject);
                        long j = iVar.f54329f;
                        uVar.g(j, j);
                        JSONObject jSONObject2 = jSONObject.getJSONObject("content");
                        JSONObject jSONObject3 = jSONObject.getJSONObject(DI.APP_INFO_NAME);
                        if (jSONObject2 != null && jSONObject3 != null) {
                            jSONObject2.put(DI.APP_INFO_NAME, jSONObject3);
                            jSONObject.remove(DI.APP_INFO_NAME);
                        }
                    } else {
                        JSONObject e2 = new r(iVar.a()).e();
                        e2.put("bizId", iVar.f54324a);
                        e2.put("timestamp", Long.toString(iVar.f54329f));
                        if (iVar.f54328e != null) {
                            e2.put("content", iVar.f54328e);
                        } else {
                            e2.put("content", iVar.f54327d);
                        }
                        e2.put("eventType", "0");
                        if (!TextUtils.isEmpty(iVar.f54331h)) {
                            e2.put("abtest", iVar.f54331h);
                            uVar.f54412f = "1";
                        }
                        if (!TextUtils.isEmpty(iVar.f54332i)) {
                            e2.put("c", iVar.f54332i);
                        }
                        if (iVar.j) {
                            e2.put("of", "1");
                        }
                        e2.put(Constant.ID_TYPE, this.l.j(iVar.f54324a));
                        uVar.a(e2);
                        uVar.g(iVar.f54329f, iVar.f54329f);
                    }
                } catch (JSONException unused) {
                }
                if (this.f54295i == null) {
                    f();
                }
                if (this.f54295i.size() > 0) {
                    this.f54288b.m(this.f54295i.valueAt(0), uVar);
                }
                q(uVar);
                i();
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && g(this.f54287a) && c()) {
            u uVar = new u();
            uVar.f54413g = true;
            if (this.f54295i == null) {
                f();
            }
            if (this.f54295i.size() > 0) {
                if (e.h().s()) {
                    this.f54288b.l(uVar);
                } else {
                    this.f54288b.m(this.f54295i.valueAt(0), uVar);
                }
            }
            q(uVar);
            i();
        }
    }

    public void a(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, str, i2) == null) {
            j();
            this.f54288b.d(str, i2);
            if (Math.abs(System.currentTimeMillis() - this.f54292f) >= d.g().h()) {
                z();
            }
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            n(true);
            n(false);
        }
    }

    public final boolean c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (e.h().s()) {
                return true;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (Math.abs(currentTimeMillis - this.f54293g) > 86400000) {
                this.f54294h = 0;
                this.f54293g = currentTimeMillis;
                t.g().putLong("ubc_reset_real_time_count_time", this.f54293g);
                t.g().putInt("ubc_real_time_count", this.f54294h);
            }
            int i2 = this.f54294h;
            if (i2 >= 1000) {
                if (i2 == 1000) {
                    this.f54294h = i2 + 1;
                    e.i(com.tencent.connect.common.Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, "realLimit");
                }
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void d(String str, int i2, long j, JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{str, Integer.valueOf(i2), Long.valueOf(j), jSONArray}) == null) {
            j();
            this.f54288b.j(str, i2, j, jSONArray);
            if (this.l.b(str)) {
                B();
            }
            if (Math.abs(System.currentTimeMillis() - this.f54292f) >= d.g().h()) {
                z();
            }
        }
    }

    public a e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.f54288b : (a) invokeV.objValue;
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && this.f54295i == null) {
            SparseArray<ArrayList> sparseArray = new SparseArray<>();
            this.f54295i = sparseArray;
            this.f54288b.v(sparseArray);
            this.j = new HashMap<>();
            int i2 = 0;
            for (int i3 = 0; i3 < this.f54295i.size(); i3++) {
                int keyAt = this.f54295i.keyAt(i3);
                if (keyAt != 0 && i2 == 0) {
                    i2 = keyAt;
                }
                HashMap<String, Long> hashMap = this.j;
                hashMap.put("ubc_last_upload_time_level_" + keyAt, 0L);
            }
            this.l.p(i2);
        }
    }

    @SuppressLint({"MissingPermission"})
    public final boolean g(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, context)) == null) {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity");
            if (connectivityManager == null) {
                return false;
            }
            NetworkInfo networkInfo = null;
            try {
                networkInfo = connectivityManager.getActiveNetworkInfo();
            } catch (Exception unused) {
            }
            return networkInfo != null && networkInfo.isAvailable();
        }
        return invokeL.booleanValue;
    }

    public void h() {
        File[] listFiles;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && g(this.f54287a)) {
            File file = new File(this.f54287a.getFilesDir() + File.separator + "statistics_data");
            if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null) {
                if (listFiles.length > 50) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("type", "del_file");
                        jSONObject.put("del_file_size", listFiles.length);
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                    e.i(com.tencent.connect.common.Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, jSONObject.toString());
                    for (File file2 : listFiles) {
                        file2.delete();
                    }
                    this.f54288b.h();
                }
                for (int i2 = 0; i2 < listFiles.length; i2++) {
                    j u = this.f54288b.u(listFiles[i2].getName());
                    if (u != null && TextUtils.equals("0", u.a())) {
                        s.a("processFailedData file, no need to send");
                    } else if (u != null && TextUtils.equals("1", u.a())) {
                        s.a("processFailedData file, send");
                        this.f54288b.G(listFiles[i2].getName(), "0");
                        v(listFiles[i2].getName());
                    } else {
                        s.a("processFailedData file, data in db, delete file");
                        listFiles[i2].delete();
                    }
                }
            }
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.f54294h++;
            t.g().putInt("ubc_real_time_count", this.f54294h);
        }
    }

    public final void j() {
        List<i> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (list = this.f54290d) == null || list.size() == 0) {
            return;
        }
        this.f54288b.z(this.f54290d);
        this.f54290d.clear();
    }

    public void k(i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, iVar) == null) {
            boolean z = TextUtils.equals(iVar.f54324a, iVar.f54325b) && this.l.b(iVar.f54324a) && (iVar.f54330g & 64) == 0;
            if (z && !A(iVar)) {
                this.f54288b.y(iVar);
            } else if (Math.abs(System.currentTimeMillis() - this.f54292f) >= d.g().h()) {
                if (!z) {
                    this.f54290d.add(iVar);
                }
                z();
            } else if ((1 & iVar.f54330g) != 0) {
                if (z) {
                    return;
                }
                this.f54288b.y(iVar);
            } else {
                if (!z) {
                    this.f54290d.add(iVar);
                }
                if (this.f54290d.size() >= 20) {
                    j();
                }
            }
        }
    }

    public void l(i iVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, iVar) == null) {
            this.f54289c.d(iVar, this.l.b(iVar.f54324a));
        }
    }

    public final void m(String str, String str2) {
        OutputStream fileOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048590, this, str, str2) == null) {
            String str3 = this.f54287a.getFilesDir() + File.separator + "statistics_data";
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
                s.a("save to file suc");
            } catch (Exception e3) {
                e = e3;
                outputStream = fileOutputStream;
                e.printStackTrace();
                d.a.q0.t.d.d(outputStream);
            } catch (Throwable th2) {
                th = th2;
                outputStream = fileOutputStream;
                d.a.q0.t.d.d(outputStream);
                throw th;
            }
            d.a.q0.t.d.d(outputStream);
        }
    }

    public final void n(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            u uVar = new u();
            uVar.f54413g = z;
            if (this.f54289c.c(uVar, z)) {
                JSONArray jSONArray = uVar.f54407a;
                this.f54289c.b(z);
                n.f().s(jSONArray);
            }
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.f54288b.C();
        }
    }

    public void p(k kVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, kVar) == null) {
            this.f54288b.B(kVar);
        }
    }

    public final void q(u uVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048594, this, uVar) == null) || uVar.d()) {
            return;
        }
        JSONArray jSONArray = uVar.f54407a;
        String d2 = d.a.q0.t.f.d(jSONArray.toString().getBytes(), true);
        m(jSONArray.toString(), d2);
        this.f54288b.A(d2, uVar.f54413g);
        if (!this.f54288b.g(uVar.f54408b, uVar.f54409c, uVar.f54413g, d2)) {
            uVar.c();
            File file = new File(this.f54287a.getFilesDir() + File.separator + "statistics_data", d2);
            if (file.exists() && file.delete()) {
                Log.d("CeresBehaviorModel", "db fail deleteUploadFile file suc");
            }
            this.f54288b.i(d2);
            return;
        }
        n.f().r(jSONArray, d2);
        uVar.c();
    }

    public void r(q qVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, qVar) == null) {
            this.l.q(qVar.a());
            this.l.n(qVar.d() * 86400000);
            this.l.o(qVar.c());
            t.g().putString("ubc_version_md5", qVar.b());
            this.f54288b.D(qVar.a());
            qVar.a().clear();
            if (this.f54295i == null) {
                this.f54295i = new SparseArray<>();
            }
            this.f54295i.clear();
            if (this.j == null) {
                this.j = new HashMap<>();
            }
            this.j.clear();
            this.f54288b.v(this.f54295i);
            int i2 = 0;
            for (int i3 = 0; i3 < this.f54295i.size(); i3++) {
                int keyAt = this.f54295i.keyAt(i3);
                if (keyAt != 0 && i2 == 0) {
                    i2 = keyAt;
                }
                HashMap<String, Long> hashMap = this.j;
                hashMap.put("ubc_last_upload_time_level_" + keyAt, 0L);
            }
            this.l.p(i2);
        }
    }

    public void s(String str, int i2, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048596, this, str, i2, str2) == null) {
            this.f54288b.E(str, i2, str2);
        }
    }

    public void t() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048597, this) == null) && g(this.f54287a) && Math.abs(System.currentTimeMillis() - this.f54291e) >= 3600000) {
            this.f54288b.f();
            u uVar = new u();
            if (this.f54288b.l(uVar) == 0) {
                return;
            }
            u uVar2 = new u();
            uVar2.g(uVar.f54410d, uVar.f54411e);
            uVar2.f54412f = uVar.f54412f;
            uVar2.f54413g = true;
            u uVar3 = new u();
            uVar3.g(uVar.f54410d, uVar.f54411e);
            uVar3.f54412f = uVar.f54412f;
            uVar3.f54413g = false;
            SparseIntArray sparseIntArray = uVar.f54408b;
            int size = sparseIntArray.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (this.l.b(String.valueOf(sparseIntArray.valueAt(i2)))) {
                    uVar2.f(sparseIntArray.keyAt(i2), sparseIntArray.valueAt(i2));
                } else {
                    uVar3.f(sparseIntArray.keyAt(i2), sparseIntArray.valueAt(i2));
                }
            }
            ArrayList<String> arrayList = uVar.f54409c;
            int size2 = arrayList.size();
            for (int i3 = 0; i3 < size2; i3++) {
                String str = arrayList.get(i3);
                if (this.l.b(str)) {
                    uVar2.e(str);
                } else {
                    uVar3.e(str);
                }
            }
            JSONArray jSONArray = uVar.f54407a;
            int length = jSONArray.length();
            for (int i4 = 0; i4 < length; i4++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i4);
                if (optJSONObject.has("bizId")) {
                    String str2 = null;
                    try {
                        str2 = optJSONObject.getString("bizId");
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                    if (!TextUtils.isEmpty(str2)) {
                        if (this.l.b(str2)) {
                            uVar2.a(optJSONObject);
                        } else {
                            uVar3.a(optJSONObject);
                        }
                    }
                }
            }
            if (uVar2.f54407a.length() > 0) {
                q(uVar2);
            }
            if (uVar3.f54407a.length() > 0) {
                q(uVar3);
            }
            this.f54291e = System.currentTimeMillis();
            t.g().putLong("ubc_last_upload_all_time", this.f54291e);
            this.f54292f = this.f54291e;
            t.g().putLong("ubc_last_upload_non_real", this.f54292f);
        }
    }

    public final void u(JSONArray jSONArray, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048598, this, jSONArray, str) == null) {
            n.f().t(str, this.k.a(jSONArray));
        }
    }

    public void v(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(1048599, this, str) != null) {
            return;
        }
        File file = new File(this.f54287a.getFilesDir() + File.separator + "statistics_data", str);
        InputStream inputStream = null;
        try {
            InputStream fileInputStream = new FileInputStream(file);
            try {
                if (fileInputStream.available() > 0) {
                    inputStream = new Base64InputStream(fileInputStream, 0);
                    n.f().r(new JSONArray(d.a.q0.t.h.c(inputStream)), str);
                    fileInputStream = inputStream;
                }
                d.a.q0.t.d.d(fileInputStream);
            } catch (Exception unused) {
                inputStream = fileInputStream;
                d.a.q0.t.d.d(inputStream);
            } catch (Throwable th) {
                th = th;
                inputStream = fileInputStream;
                d.a.q0.t.d.d(inputStream);
                throw th;
            }
        } catch (Exception unused2) {
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public void w(JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048600, this, jSONArray) == null) || this.k.a(jSONArray)) {
            return;
        }
        e.i(com.tencent.connect.common.Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, "sendFail");
    }

    public void x(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, str) == null) {
            s.a("upload file fail");
            this.f54288b.F(str);
        }
    }

    public void y(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, str) == null) {
            File file = new File(this.f54287a.getFilesDir() + File.separator + "statistics_data", str);
            s.a("delete file");
            if (file.exists() && file.delete()) {
                Log.d("CeresBehaviorModel", "deleteUploadFile file suc");
                s.a("delete file suc");
            }
            this.f54288b.i(str);
        }
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048603, this) == null) && g(this.f54287a)) {
            this.f54292f = System.currentTimeMillis();
            t.g().putLong("ubc_last_upload_non_real", this.f54292f);
            b();
            j();
            this.f54288b.f();
            HashSet hashSet = new HashSet();
            if (this.f54295i == null) {
                f();
            }
            u uVar = new u();
            uVar.f54413g = false;
            int i2 = 0;
            for (int i3 = 0; i3 < this.f54295i.size(); i3++) {
                int keyAt = this.f54295i.keyAt(i3);
                if (keyAt != 0) {
                    HashMap<String, Long> hashMap = this.j;
                    long longValue = hashMap.get("ubc_last_upload_time_level_" + keyAt).longValue();
                    if (longValue == 0 || (longValue + (keyAt * 60000)) - System.currentTimeMillis() < this.l.h()) {
                        i2 |= this.f54288b.m(this.f54295i.valueAt(i3), uVar);
                        HashMap<String, Long> hashMap2 = this.j;
                        hashMap2.put("ubc_last_upload_time_level_" + keyAt, Long.valueOf(System.currentTimeMillis()));
                        hashSet.add(Integer.valueOf(keyAt));
                    }
                }
            }
            if (i2 == 0) {
                return;
            }
            for (int i4 = 0; i4 < this.f54295i.size(); i4++) {
                int keyAt2 = this.f54295i.keyAt(i4);
                if (keyAt2 != 0 && !hashSet.contains(Integer.valueOf(keyAt2))) {
                    if (uVar.b(51200)) {
                        break;
                    }
                    this.f54288b.m(this.f54295i.valueAt(i4), uVar);
                }
            }
            q(uVar);
        }
    }
}

package com.repackage;

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
/* loaded from: classes7.dex */
public class xf4 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public vf4 b;
    public wf4 c;
    public List<dg4> d;
    public long e;
    public long f;
    public long g;
    public int h;
    public SparseArray<ArrayList> i;
    public HashMap<String, Long> j;
    public hg4 k;
    public yf4 l;

    public xf4(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = context;
        this.b = new vf4(context);
        this.c = new wf4(context);
        this.k = zf4.g().m();
        this.d = new ArrayList(20);
        og4 f = og4.f();
        this.e = f.getLong("ubc_last_upload_all_time", 0L);
        this.f = f.getLong("ubc_last_upload_non_real", 0L);
        this.g = f.getLong("ubc_reset_real_time_count_time", 0L);
        this.h = f.getInt("ubc_real_time_count", 0);
        yf4 g = yf4.g();
        this.l = g;
        g.k(this, context);
    }

    public final boolean A(dg4 dg4Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, dg4Var)) == null) {
            if (g(this.a) && c()) {
                j();
                pg4 pg4Var = new pg4();
                pg4Var.g = true;
                JSONObject jSONObject = dg4Var.e;
                try {
                    if (jSONObject != null && jSONObject.has("bizId")) {
                        mg4.a(jSONObject);
                        pg4Var.a(jSONObject);
                        long j = dg4Var.f;
                        pg4Var.g(j, j);
                        JSONObject jSONObject2 = jSONObject.getJSONObject("content");
                        JSONObject jSONObject3 = jSONObject.getJSONObject(DI.APP_INFO_NAME);
                        if (jSONObject2 != null && jSONObject3 != null) {
                            jSONObject2.put(DI.APP_INFO_NAME, jSONObject3);
                            jSONObject.remove(DI.APP_INFO_NAME);
                        }
                    } else {
                        JSONObject e = new mg4(dg4Var.a()).e();
                        e.put("bizId", dg4Var.a);
                        e.put("timestamp", Long.toString(dg4Var.f));
                        if (dg4Var.e != null) {
                            e.put("content", dg4Var.e);
                        } else {
                            e.put("content", dg4Var.d);
                        }
                        e.put("eventType", "0");
                        if (!TextUtils.isEmpty(dg4Var.h)) {
                            e.put("abtest", dg4Var.h);
                            pg4Var.f = "1";
                        }
                        if (!TextUtils.isEmpty(dg4Var.i)) {
                            e.put("c", dg4Var.i);
                        }
                        if (dg4Var.j) {
                            e.put("of", "1");
                        }
                        e.put(Constant.ID_TYPE, this.l.j(dg4Var.a));
                        pg4Var.a(e);
                        pg4Var.g(dg4Var.f, dg4Var.f);
                    }
                } catch (JSONException unused) {
                }
                if (this.i == null) {
                    f();
                }
                if (this.i.size() > 0) {
                    this.b.m(this.i.valueAt(0), pg4Var);
                }
                q(pg4Var);
                i();
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && g(this.a) && c()) {
            pg4 pg4Var = new pg4();
            pg4Var.g = true;
            if (this.i == null) {
                f();
            }
            if (this.i.size() > 0) {
                if (zf4.g().s()) {
                    this.b.l(pg4Var);
                } else {
                    this.b.m(this.i.valueAt(0), pg4Var);
                }
            }
            q(pg4Var);
            i();
        }
    }

    public void a(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, str, i) == null) {
            j();
            this.b.d(str, i);
            if (Math.abs(System.currentTimeMillis() - this.f) >= yf4.g().h()) {
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
            if (zf4.g().s()) {
                return true;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (Math.abs(currentTimeMillis - this.g) > 86400000) {
                this.h = 0;
                this.g = currentTimeMillis;
                og4.f().putLong("ubc_reset_real_time_count_time", this.g);
                og4.f().putInt("ubc_real_time_count", this.h);
            }
            int i = this.h;
            if (i >= 1000) {
                if (i == 1000) {
                    this.h = i + 1;
                    zf4.h("23", "realLimit");
                }
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void d(String str, int i, long j, JSONArray jSONArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048581, this, new Object[]{str, Integer.valueOf(i), Long.valueOf(j), jSONArray}) == null) {
            j();
            this.b.j(str, i, j, jSONArray);
            if (this.l.b(str)) {
                B();
            }
            if (Math.abs(System.currentTimeMillis() - this.f) >= yf4.g().h()) {
                z();
            }
        }
    }

    public vf4 e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.b : (vf4) invokeV.objValue;
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && this.i == null) {
            SparseArray<ArrayList> sparseArray = new SparseArray<>();
            this.i = sparseArray;
            this.b.v(sparseArray);
            this.j = new HashMap<>();
            int i = 0;
            for (int i2 = 0; i2 < this.i.size(); i2++) {
                int keyAt = this.i.keyAt(i2);
                if (keyAt != 0 && i == 0) {
                    i = keyAt;
                }
                HashMap<String, Long> hashMap = this.j;
                hashMap.put("ubc_last_upload_time_level_" + keyAt, 0L);
            }
            this.l.p(i);
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
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && g(this.a)) {
            File file = new File(this.a.getFilesDir() + File.separator + "statistics_data");
            if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null) {
                if (listFiles.length > 50) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("type", "del_file");
                        jSONObject.put("del_file_size", listFiles.length);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    zf4.h("23", jSONObject.toString());
                    for (File file2 : listFiles) {
                        file2.delete();
                    }
                    this.b.h();
                }
                for (int i = 0; i < listFiles.length; i++) {
                    eg4 u = this.b.u(listFiles[i].getName());
                    if (u != null && TextUtils.equals("0", u.a())) {
                        ng4.a("processFailedData file, no need to send");
                    } else if (u != null && TextUtils.equals("1", u.a())) {
                        ng4.a("processFailedData file, send");
                        this.b.G(listFiles[i].getName(), "0");
                        v(listFiles[i].getName());
                    } else {
                        ng4.a("processFailedData file, data in db, delete file");
                        listFiles[i].delete();
                    }
                }
            }
        }
    }

    public final void i() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.h++;
            og4.f().putInt("ubc_real_time_count", this.h);
        }
    }

    public final void j() {
        List<dg4> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048587, this) == null) || (list = this.d) == null || list.size() == 0) {
            return;
        }
        this.b.z(this.d);
        this.d.clear();
    }

    public void k(dg4 dg4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, dg4Var) == null) {
            boolean z = TextUtils.equals(dg4Var.a, dg4Var.b) && this.l.b(dg4Var.a) && (dg4Var.g & 64) == 0;
            if (z && !A(dg4Var)) {
                this.b.y(dg4Var);
            } else if (Math.abs(System.currentTimeMillis() - this.f) >= yf4.g().h()) {
                if (!z) {
                    this.d.add(dg4Var);
                }
                z();
            } else if ((1 & dg4Var.g) != 0) {
                if (z) {
                    return;
                }
                this.b.y(dg4Var);
            } else {
                if (!z) {
                    this.d.add(dg4Var);
                }
                if (this.d.size() >= 20) {
                    j();
                }
            }
        }
    }

    public void l(dg4 dg4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, dg4Var) == null) {
            this.c.d(dg4Var, this.l.b(dg4Var.a));
        }
    }

    public final void m(String str, String str2) {
        OutputStream fileOutputStream;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048590, this, str, str2) == null) {
            String str3 = this.a.getFilesDir() + File.separator + "statistics_data";
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
                ng4.a("save to file suc");
            } catch (Exception e2) {
                e = e2;
                outputStream = fileOutputStream;
                e.printStackTrace();
                xg4.d(outputStream);
            } catch (Throwable th2) {
                th = th2;
                outputStream = fileOutputStream;
                xg4.d(outputStream);
                throw th;
            }
            xg4.d(outputStream);
        }
    }

    public final void n(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048591, this, z) == null) {
            pg4 pg4Var = new pg4();
            pg4Var.g = z;
            if (this.c.c(pg4Var, z)) {
                JSONArray jSONArray = pg4Var.a;
                this.c.b(z);
                ig4.f().s(jSONArray);
            }
        }
    }

    public void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.b.C();
        }
    }

    public void p(fg4 fg4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, fg4Var) == null) {
            this.b.B(fg4Var);
        }
    }

    public final void q(pg4 pg4Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048594, this, pg4Var) == null) || pg4Var.d()) {
            return;
        }
        JSONArray jSONArray = pg4Var.a;
        String d = zg4.d(jSONArray.toString().getBytes(), true);
        m(jSONArray.toString(), d);
        this.b.A(d, pg4Var.g);
        if (!this.b.g(pg4Var.b, pg4Var.c, pg4Var.g, d)) {
            pg4Var.c();
            File file = new File(this.a.getFilesDir() + File.separator + "statistics_data", d);
            if (file.exists() && file.delete()) {
                Log.d("CeresBehaviorModel", "db fail deleteUploadFile file suc");
            }
            this.b.i(d);
            return;
        }
        ig4.f().r(jSONArray, d);
        pg4Var.c();
    }

    public void r(lg4 lg4Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, lg4Var) == null) {
            this.l.q(lg4Var.a());
            this.l.n(lg4Var.d() * 86400000);
            this.l.o(lg4Var.c());
            og4.f().putString("ubc_version_md5", lg4Var.b());
            this.b.D(lg4Var.a());
            lg4Var.a().clear();
            if (this.i == null) {
                this.i = new SparseArray<>();
            }
            this.i.clear();
            if (this.j == null) {
                this.j = new HashMap<>();
            }
            this.j.clear();
            this.b.v(this.i);
            int i = 0;
            for (int i2 = 0; i2 < this.i.size(); i2++) {
                int keyAt = this.i.keyAt(i2);
                if (keyAt != 0 && i == 0) {
                    i = keyAt;
                }
                HashMap<String, Long> hashMap = this.j;
                hashMap.put("ubc_last_upload_time_level_" + keyAt, 0L);
            }
            this.l.p(i);
        }
    }

    public void s(String str, int i, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(1048596, this, str, i, str2) == null) {
            this.b.E(str, i, str2);
        }
    }

    public void t() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048597, this) == null) && g(this.a) && Math.abs(System.currentTimeMillis() - this.e) >= 3600000) {
            this.b.f();
            pg4 pg4Var = new pg4();
            if (this.b.l(pg4Var) == 0) {
                return;
            }
            pg4 pg4Var2 = new pg4();
            pg4Var2.g(pg4Var.d, pg4Var.e);
            pg4Var2.f = pg4Var.f;
            pg4Var2.g = true;
            pg4 pg4Var3 = new pg4();
            pg4Var3.g(pg4Var.d, pg4Var.e);
            pg4Var3.f = pg4Var.f;
            pg4Var3.g = false;
            SparseIntArray sparseIntArray = pg4Var.b;
            int size = sparseIntArray.size();
            for (int i = 0; i < size; i++) {
                if (this.l.b(String.valueOf(sparseIntArray.valueAt(i)))) {
                    pg4Var2.f(sparseIntArray.keyAt(i), sparseIntArray.valueAt(i));
                } else {
                    pg4Var3.f(sparseIntArray.keyAt(i), sparseIntArray.valueAt(i));
                }
            }
            ArrayList<String> arrayList = pg4Var.c;
            int size2 = arrayList.size();
            for (int i2 = 0; i2 < size2; i2++) {
                String str = arrayList.get(i2);
                if (this.l.b(str)) {
                    pg4Var2.e(str);
                } else {
                    pg4Var3.e(str);
                }
            }
            JSONArray jSONArray = pg4Var.a;
            int length = jSONArray.length();
            for (int i3 = 0; i3 < length; i3++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i3);
                if (optJSONObject.has("bizId")) {
                    String str2 = null;
                    try {
                        str2 = optJSONObject.getString("bizId");
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    if (!TextUtils.isEmpty(str2)) {
                        if (this.l.b(str2)) {
                            pg4Var2.a(optJSONObject);
                        } else {
                            pg4Var3.a(optJSONObject);
                        }
                    }
                }
            }
            if (pg4Var2.a.length() > 0) {
                q(pg4Var2);
            }
            if (pg4Var3.a.length() > 0) {
                q(pg4Var3);
            }
            this.e = System.currentTimeMillis();
            og4.f().putLong("ubc_last_upload_all_time", this.e);
            this.f = this.e;
            og4.f().putLong("ubc_last_upload_non_real", this.f);
        }
    }

    public final void u(JSONArray jSONArray, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048598, this, jSONArray, str) == null) {
            ig4.f().t(str, this.k.a(jSONArray));
        }
    }

    public void v(String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null && interceptable.invokeL(1048599, this, str) != null) {
            return;
        }
        File file = new File(this.a.getFilesDir() + File.separator + "statistics_data", str);
        InputStream inputStream = null;
        try {
            InputStream fileInputStream = new FileInputStream(file);
            try {
                if (fileInputStream.available() > 0) {
                    inputStream = new Base64InputStream(fileInputStream, 0);
                    ig4.f().r(new JSONArray(bh4.c(inputStream)), str);
                    fileInputStream = inputStream;
                }
                xg4.d(fileInputStream);
            } catch (Exception unused) {
                inputStream = fileInputStream;
                xg4.d(inputStream);
            } catch (Throwable th) {
                th = th;
                inputStream = fileInputStream;
                xg4.d(inputStream);
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
        zf4.h("23", "sendFail");
    }

    public void x(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, str) == null) {
            ng4.a("upload file fail");
            this.b.F(str);
        }
    }

    public void y(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, str) == null) {
            File file = new File(this.a.getFilesDir() + File.separator + "statistics_data", str);
            ng4.a("delete file");
            if (file.exists() && file.delete()) {
                Log.d("CeresBehaviorModel", "deleteUploadFile file suc");
                ng4.a("delete file suc");
            }
            this.b.i(str);
        }
    }

    public final void z() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048603, this) == null) && g(this.a)) {
            this.f = System.currentTimeMillis();
            og4.f().putLong("ubc_last_upload_non_real", this.f);
            b();
            j();
            this.b.f();
            HashSet hashSet = new HashSet();
            if (this.i == null) {
                f();
            }
            pg4 pg4Var = new pg4();
            pg4Var.g = false;
            int i = 0;
            for (int i2 = 0; i2 < this.i.size(); i2++) {
                int keyAt = this.i.keyAt(i2);
                if (keyAt != 0) {
                    HashMap<String, Long> hashMap = this.j;
                    long longValue = hashMap.get("ubc_last_upload_time_level_" + keyAt).longValue();
                    if (longValue == 0 || (longValue + (keyAt * 60000)) - System.currentTimeMillis() < this.l.h()) {
                        i |= this.b.m(this.i.valueAt(i2), pg4Var);
                        HashMap<String, Long> hashMap2 = this.j;
                        hashMap2.put("ubc_last_upload_time_level_" + keyAt, Long.valueOf(System.currentTimeMillis()));
                        hashSet.add(Integer.valueOf(keyAt));
                    }
                }
            }
            if (i == 0) {
                return;
            }
            for (int i3 = 0; i3 < this.i.size(); i3++) {
                int keyAt2 = this.i.keyAt(i3);
                if (keyAt2 != 0 && !hashSet.contains(Integer.valueOf(keyAt2))) {
                    if (pg4Var.b(51200)) {
                        break;
                    }
                    this.b.m(this.i.valueAt(i3), pg4Var);
                }
            }
            q(pg4Var);
        }
    }
}

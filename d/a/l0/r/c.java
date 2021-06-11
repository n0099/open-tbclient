package d.a.l0.r;

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
import com.baidu.searchbox.live.interfaces.DI;
import com.baidu.searchbox.logsystem.basic.upload.Constant;
import com.tencent.connect.common.Constants;
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
/* loaded from: classes3.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public Context f52035a;

    /* renamed from: b  reason: collision with root package name */
    public a f52036b;

    /* renamed from: c  reason: collision with root package name */
    public b f52037c;

    /* renamed from: e  reason: collision with root package name */
    public long f52039e;

    /* renamed from: f  reason: collision with root package name */
    public long f52040f;

    /* renamed from: g  reason: collision with root package name */
    public long f52041g;

    /* renamed from: h  reason: collision with root package name */
    public int f52042h;

    /* renamed from: i  reason: collision with root package name */
    public SparseArray<ArrayList> f52043i;
    public HashMap<String, Long> j;
    public d l;
    public m k = e.h().m();

    /* renamed from: d  reason: collision with root package name */
    public List<i> f52038d = new ArrayList(20);

    public c(Context context) {
        this.f52035a = context;
        this.f52036b = new a(context);
        this.f52037c = new b(context);
        t g2 = t.g();
        this.f52039e = g2.getLong("ubc_last_upload_all_time", 0L);
        this.f52040f = g2.getLong("ubc_last_upload_non_real", 0L);
        this.f52041g = g2.getLong("ubc_reset_real_time_count_time", 0L);
        this.f52042h = g2.getInt("ubc_real_time_count", 0);
        d g3 = d.g();
        this.l = g3;
        g3.k(this, context);
    }

    public final boolean A(i iVar) {
        if (g(this.f52035a) && c()) {
            j();
            u uVar = new u();
            uVar.f52161g = true;
            JSONObject jSONObject = iVar.f52076e;
            try {
                if (jSONObject != null && jSONObject.has("bizId")) {
                    r.a(jSONObject);
                    uVar.a(jSONObject);
                    long j = iVar.f52077f;
                    uVar.g(j, j);
                    JSONObject jSONObject2 = jSONObject.getJSONObject("content");
                    JSONObject jSONObject3 = jSONObject.getJSONObject(DI.APP_INFO_NAME);
                    if (jSONObject2 != null && jSONObject3 != null) {
                        jSONObject2.put(DI.APP_INFO_NAME, jSONObject3);
                        jSONObject.remove(DI.APP_INFO_NAME);
                    }
                } else {
                    JSONObject e2 = new r(iVar.a()).e();
                    e2.put("bizId", iVar.f52072a);
                    e2.put("timestamp", Long.toString(iVar.f52077f));
                    if (iVar.f52076e != null) {
                        e2.put("content", iVar.f52076e);
                    } else {
                        e2.put("content", iVar.f52075d);
                    }
                    e2.put("eventType", "0");
                    if (!TextUtils.isEmpty(iVar.f52079h)) {
                        e2.put("abtest", iVar.f52079h);
                        uVar.f52160f = "1";
                    }
                    if (!TextUtils.isEmpty(iVar.f52080i)) {
                        e2.put("c", iVar.f52080i);
                    }
                    if (iVar.j) {
                        e2.put("of", "1");
                    }
                    e2.put(Constant.ID_TYPE, this.l.j(iVar.f52072a));
                    uVar.a(e2);
                    uVar.g(iVar.f52077f, iVar.f52077f);
                }
            } catch (JSONException unused) {
            }
            if (this.f52043i == null) {
                f();
            }
            if (this.f52043i.size() > 0) {
                this.f52036b.m(this.f52043i.valueAt(0), uVar);
            }
            q(uVar);
            i();
            return true;
        }
        return false;
    }

    public final void B() {
        if (g(this.f52035a) && c()) {
            u uVar = new u();
            uVar.f52161g = true;
            if (this.f52043i == null) {
                f();
            }
            if (this.f52043i.size() > 0) {
                if (e.h().s()) {
                    this.f52036b.l(uVar);
                } else {
                    this.f52036b.m(this.f52043i.valueAt(0), uVar);
                }
            }
            q(uVar);
            i();
        }
    }

    public void a(String str, int i2) {
        j();
        this.f52036b.d(str, i2);
        if (Math.abs(System.currentTimeMillis() - this.f52040f) >= d.g().h()) {
            z();
        }
    }

    public final void b() {
        n(true);
        n(false);
    }

    public final boolean c() {
        if (e.h().s()) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (Math.abs(currentTimeMillis - this.f52041g) > 86400000) {
            this.f52042h = 0;
            this.f52041g = currentTimeMillis;
            t.g().putLong("ubc_reset_real_time_count_time", this.f52041g);
            t.g().putInt("ubc_real_time_count", this.f52042h);
        }
        int i2 = this.f52042h;
        if (i2 >= 1000) {
            if (i2 == 1000) {
                this.f52042h = i2 + 1;
                e.i(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, "realLimit");
            }
            return false;
        }
        return true;
    }

    public void d(String str, int i2, long j, JSONArray jSONArray) {
        j();
        this.f52036b.j(str, i2, j, jSONArray);
        if (this.l.b(str)) {
            B();
        }
        if (Math.abs(System.currentTimeMillis() - this.f52040f) >= d.g().h()) {
            z();
        }
    }

    public a e() {
        return this.f52036b;
    }

    public final void f() {
        if (this.f52043i != null) {
            return;
        }
        SparseArray<ArrayList> sparseArray = new SparseArray<>();
        this.f52043i = sparseArray;
        this.f52036b.v(sparseArray);
        this.j = new HashMap<>();
        int i2 = 0;
        for (int i3 = 0; i3 < this.f52043i.size(); i3++) {
            int keyAt = this.f52043i.keyAt(i3);
            if (keyAt != 0 && i2 == 0) {
                i2 = keyAt;
            }
            HashMap<String, Long> hashMap = this.j;
            hashMap.put("ubc_last_upload_time_level_" + keyAt, 0L);
        }
        this.l.p(i2);
    }

    @SuppressLint({"MissingPermission"})
    public final boolean g(Context context) {
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

    public void h() {
        File[] listFiles;
        if (g(this.f52035a)) {
            File file = new File(this.f52035a.getFilesDir() + File.separator + "statistics_data");
            if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null) {
                if (listFiles.length > 50) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("type", "del_file");
                        jSONObject.put("del_file_size", listFiles.length);
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                    e.i(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, jSONObject.toString());
                    for (File file2 : listFiles) {
                        file2.delete();
                    }
                    this.f52036b.h();
                }
                for (int i2 = 0; i2 < listFiles.length; i2++) {
                    j u = this.f52036b.u(listFiles[i2].getName());
                    if (u != null && TextUtils.equals("0", u.a())) {
                        s.a("processFailedData file, no need to send");
                    } else if (u != null && TextUtils.equals("1", u.a())) {
                        s.a("processFailedData file, send");
                        this.f52036b.G(listFiles[i2].getName(), "0");
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
        this.f52042h++;
        t.g().putInt("ubc_real_time_count", this.f52042h);
    }

    public final void j() {
        List<i> list = this.f52038d;
        if (list == null || list.size() == 0) {
            return;
        }
        this.f52036b.z(this.f52038d);
        this.f52038d.clear();
    }

    public void k(i iVar) {
        boolean z = TextUtils.equals(iVar.f52072a, iVar.f52073b) && this.l.b(iVar.f52072a) && (iVar.f52078g & 64) == 0;
        if (z && !A(iVar)) {
            this.f52036b.y(iVar);
        } else if (Math.abs(System.currentTimeMillis() - this.f52040f) >= d.g().h()) {
            if (!z) {
                this.f52038d.add(iVar);
            }
            z();
        } else if ((1 & iVar.f52078g) != 0) {
            if (z) {
                return;
            }
            this.f52036b.y(iVar);
        } else {
            if (!z) {
                this.f52038d.add(iVar);
            }
            if (this.f52038d.size() >= 20) {
                j();
            }
        }
    }

    public void l(i iVar) {
        this.f52037c.d(iVar, this.l.b(iVar.f52072a));
    }

    public final void m(String str, String str2) {
        OutputStream fileOutputStream;
        String str3 = this.f52035a.getFilesDir() + File.separator + "statistics_data";
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
            d.a.l0.t.d.d(outputStream);
        } catch (Throwable th2) {
            th = th2;
            outputStream = fileOutputStream;
            d.a.l0.t.d.d(outputStream);
            throw th;
        }
        d.a.l0.t.d.d(outputStream);
    }

    public final void n(boolean z) {
        u uVar = new u();
        uVar.f52161g = z;
        if (this.f52037c.c(uVar, z)) {
            JSONArray jSONArray = uVar.f52155a;
            this.f52037c.b(z);
            n.f().s(jSONArray);
        }
    }

    public void o() {
        this.f52036b.C();
    }

    public void p(k kVar) {
        this.f52036b.B(kVar);
    }

    public final void q(u uVar) {
        if (uVar.d()) {
            return;
        }
        JSONArray jSONArray = uVar.f52155a;
        String d2 = d.a.l0.t.f.d(jSONArray.toString().getBytes(), true);
        m(jSONArray.toString(), d2);
        this.f52036b.A(d2, uVar.f52161g);
        if (!this.f52036b.g(uVar.f52156b, uVar.f52157c, uVar.f52161g, d2)) {
            uVar.c();
            File file = new File(this.f52035a.getFilesDir() + File.separator + "statistics_data", d2);
            if (file.exists() && file.delete()) {
                Log.d("CeresBehaviorModel", "db fail deleteUploadFile file suc");
            }
            this.f52036b.i(d2);
            return;
        }
        n.f().r(jSONArray, d2);
        uVar.c();
    }

    public void r(q qVar) {
        this.l.q(qVar.a());
        this.l.n(qVar.d() * 86400000);
        this.l.o(qVar.c());
        t.g().putString("ubc_version_md5", qVar.b());
        this.f52036b.D(qVar.a());
        qVar.a().clear();
        if (this.f52043i == null) {
            this.f52043i = new SparseArray<>();
        }
        this.f52043i.clear();
        if (this.j == null) {
            this.j = new HashMap<>();
        }
        this.j.clear();
        this.f52036b.v(this.f52043i);
        int i2 = 0;
        for (int i3 = 0; i3 < this.f52043i.size(); i3++) {
            int keyAt = this.f52043i.keyAt(i3);
            if (keyAt != 0 && i2 == 0) {
                i2 = keyAt;
            }
            HashMap<String, Long> hashMap = this.j;
            hashMap.put("ubc_last_upload_time_level_" + keyAt, 0L);
        }
        this.l.p(i2);
    }

    public void s(String str, int i2, String str2) {
        this.f52036b.E(str, i2, str2);
    }

    public void t() {
        if (g(this.f52035a) && Math.abs(System.currentTimeMillis() - this.f52039e) >= 3600000) {
            this.f52036b.f();
            u uVar = new u();
            if (this.f52036b.l(uVar) == 0) {
                return;
            }
            u uVar2 = new u();
            uVar2.g(uVar.f52158d, uVar.f52159e);
            uVar2.f52160f = uVar.f52160f;
            uVar2.f52161g = true;
            u uVar3 = new u();
            uVar3.g(uVar.f52158d, uVar.f52159e);
            uVar3.f52160f = uVar.f52160f;
            uVar3.f52161g = false;
            SparseIntArray sparseIntArray = uVar.f52156b;
            int size = sparseIntArray.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (this.l.b(String.valueOf(sparseIntArray.valueAt(i2)))) {
                    uVar2.f(sparseIntArray.keyAt(i2), sparseIntArray.valueAt(i2));
                } else {
                    uVar3.f(sparseIntArray.keyAt(i2), sparseIntArray.valueAt(i2));
                }
            }
            ArrayList<String> arrayList = uVar.f52157c;
            int size2 = arrayList.size();
            for (int i3 = 0; i3 < size2; i3++) {
                String str = arrayList.get(i3);
                if (this.l.b(str)) {
                    uVar2.e(str);
                } else {
                    uVar3.e(str);
                }
            }
            JSONArray jSONArray = uVar.f52155a;
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
            if (uVar2.f52155a.length() > 0) {
                q(uVar2);
            }
            if (uVar3.f52155a.length() > 0) {
                q(uVar3);
            }
            this.f52039e = System.currentTimeMillis();
            t.g().putLong("ubc_last_upload_all_time", this.f52039e);
            this.f52040f = this.f52039e;
            t.g().putLong("ubc_last_upload_non_real", this.f52040f);
        }
    }

    public final void u(JSONArray jSONArray, String str) {
        n.f().t(str, this.k.a(jSONArray));
    }

    public void v(String str) {
        File file = new File(this.f52035a.getFilesDir() + File.separator + "statistics_data", str);
        InputStream inputStream = null;
        try {
            InputStream fileInputStream = new FileInputStream(file);
            try {
                if (fileInputStream.available() > 0) {
                    inputStream = new Base64InputStream(fileInputStream, 0);
                    n.f().r(new JSONArray(d.a.l0.t.h.c(inputStream)), str);
                    fileInputStream = inputStream;
                }
                d.a.l0.t.d.d(fileInputStream);
            } catch (Exception unused) {
                inputStream = fileInputStream;
                d.a.l0.t.d.d(inputStream);
            } catch (Throwable th) {
                th = th;
                inputStream = fileInputStream;
                d.a.l0.t.d.d(inputStream);
                throw th;
            }
        } catch (Exception unused2) {
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public void w(JSONArray jSONArray) {
        if (this.k.a(jSONArray)) {
            return;
        }
        e.i(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, "sendFail");
    }

    public void x(String str) {
        s.a("upload file fail");
        this.f52036b.F(str);
    }

    public void y(String str) {
        File file = new File(this.f52035a.getFilesDir() + File.separator + "statistics_data", str);
        s.a("delete file");
        if (file.exists() && file.delete()) {
            Log.d("CeresBehaviorModel", "deleteUploadFile file suc");
            s.a("delete file suc");
        }
        this.f52036b.i(str);
    }

    public final void z() {
        if (g(this.f52035a)) {
            this.f52040f = System.currentTimeMillis();
            t.g().putLong("ubc_last_upload_non_real", this.f52040f);
            b();
            j();
            this.f52036b.f();
            HashSet hashSet = new HashSet();
            if (this.f52043i == null) {
                f();
            }
            u uVar = new u();
            uVar.f52161g = false;
            int i2 = 0;
            for (int i3 = 0; i3 < this.f52043i.size(); i3++) {
                int keyAt = this.f52043i.keyAt(i3);
                if (keyAt != 0) {
                    HashMap<String, Long> hashMap = this.j;
                    long longValue = hashMap.get("ubc_last_upload_time_level_" + keyAt).longValue();
                    if (longValue == 0 || (longValue + (keyAt * 60000)) - System.currentTimeMillis() < this.l.h()) {
                        i2 |= this.f52036b.m(this.f52043i.valueAt(i3), uVar);
                        HashMap<String, Long> hashMap2 = this.j;
                        hashMap2.put("ubc_last_upload_time_level_" + keyAt, Long.valueOf(System.currentTimeMillis()));
                        hashSet.add(Integer.valueOf(keyAt));
                    }
                }
            }
            if (i2 == 0) {
                return;
            }
            for (int i4 = 0; i4 < this.f52043i.size(); i4++) {
                int keyAt2 = this.f52043i.keyAt(i4);
                if (keyAt2 != 0 && !hashSet.contains(Integer.valueOf(keyAt2))) {
                    if (uVar.b(51200)) {
                        break;
                    }
                    this.f52036b.m(this.f52043i.valueAt(i4), uVar);
                }
            }
            q(uVar);
        }
    }
}

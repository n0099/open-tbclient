package d.a.h0.n;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import android.util.Base64InputStream;
import android.util.Base64OutputStream;
import android.util.Log;
import android.util.SparseArray;
import com.baidu.searchbox.live.interfaces.DI;
import com.baidu.searchbox.logsystem.basic.upload.Constant;
import com.baidu.webkit.sdk.VideoCloudSetting;
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
    public Context f47458a;

    /* renamed from: b  reason: collision with root package name */
    public a f47459b;

    /* renamed from: c  reason: collision with root package name */
    public b f47460c;

    /* renamed from: e  reason: collision with root package name */
    public long f47462e;

    /* renamed from: f  reason: collision with root package name */
    public long f47463f;

    /* renamed from: g  reason: collision with root package name */
    public long f47464g;

    /* renamed from: h  reason: collision with root package name */
    public int f47465h;

    /* renamed from: i  reason: collision with root package name */
    public SparseArray<ArrayList> f47466i;
    public HashMap<String, Long> j;
    public d l;
    public m k = e.g().k();

    /* renamed from: d  reason: collision with root package name */
    public List<i> f47461d = new ArrayList(20);

    public c(Context context) {
        this.f47458a = context;
        this.f47459b = new a(context);
        this.f47460c = new b(context);
        t f2 = t.f();
        this.f47462e = f2.getLong("ubc_last_upload_all_time", 0L);
        this.f47463f = f2.getLong("ubc_last_upload_non_real", 0L);
        this.f47464g = f2.getLong("ubc_reset_real_time_count_time", 0L);
        this.f47465h = f2.getInt("ubc_real_time_count", 0);
        d g2 = d.g();
        this.l = g2;
        g2.k(this, context);
    }

    public final boolean A(i iVar) {
        if (g(this.f47458a) && c()) {
            j();
            u uVar = new u();
            uVar.q(true);
            JSONObject i2 = iVar.i();
            try {
                if (i2 != null && i2.has("bizId")) {
                    r.a(i2);
                    uVar.a(i2);
                    uVar.o(iVar.k(), iVar.k());
                    JSONObject jSONObject = i2.getJSONObject("content");
                    JSONObject jSONObject2 = i2.getJSONObject(DI.APP_INFO_NAME);
                    if (jSONObject != null && jSONObject2 != null) {
                        jSONObject.put(DI.APP_INFO_NAME, jSONObject2);
                        i2.remove(DI.APP_INFO_NAME);
                    }
                } else {
                    JSONObject e2 = new r(iVar.a()).e();
                    e2.put("bizId", iVar.h());
                    e2.put("timestamp", Long.toString(iVar.k()));
                    if (iVar.i() != null) {
                        e2.put("content", iVar.i());
                    } else {
                        e2.put("content", iVar.c());
                    }
                    e2.put("eventType", "0");
                    if (!TextUtils.isEmpty(iVar.d())) {
                        e2.put("abtest", iVar.d());
                        uVar.p("1");
                    }
                    if (!TextUtils.isEmpty(iVar.b())) {
                        e2.put("c", iVar.b());
                    }
                    if (iVar.l()) {
                        e2.put("of", "1");
                    }
                    e2.put(Constant.ID_TYPE, this.l.j(iVar.h()));
                    uVar.a(e2);
                    uVar.o(iVar.k(), iVar.k());
                }
            } catch (JSONException unused) {
            }
            if (this.f47466i == null) {
                f();
            }
            if (this.f47466i.size() > 0) {
                this.f47459b.l(this.f47466i.valueAt(0), uVar);
            }
            q(uVar);
            i();
            return true;
        }
        return false;
    }

    public final void B() {
        if (g(this.f47458a) && c()) {
            u uVar = new u();
            uVar.q(true);
            if (this.f47466i == null) {
                f();
            }
            if (this.f47466i.size() > 0) {
                if (e.g().q()) {
                    this.f47459b.k(uVar);
                } else {
                    this.f47459b.l(this.f47466i.valueAt(0), uVar);
                }
            }
            q(uVar);
            i();
        }
    }

    public void a(String str, int i2) {
        j();
        this.f47459b.c(str, i2);
        if (Math.abs(System.currentTimeMillis() - this.f47463f) >= d.g().h()) {
            z();
        }
    }

    public final void b() {
        n(true);
        n(false);
    }

    public final boolean c() {
        if (e.g().q()) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (Math.abs(currentTimeMillis - this.f47464g) > 86400000) {
            this.f47465h = 0;
            this.f47464g = currentTimeMillis;
            t.f().putLong("ubc_reset_real_time_count_time", this.f47464g);
            t.f().putInt("ubc_real_time_count", this.f47465h);
        }
        int i2 = this.f47465h;
        if (i2 >= 1000) {
            if (i2 == 1000) {
                this.f47465h = i2 + 1;
                e.h(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, "realLimit");
            }
            return false;
        }
        return true;
    }

    public void d(String str, int i2, long j, JSONArray jSONArray) {
        j();
        this.f47459b.i(str, i2, j, jSONArray);
        if (this.l.b(str)) {
            B();
        }
        if (Math.abs(System.currentTimeMillis() - this.f47463f) >= d.g().h()) {
            z();
        }
    }

    public a e() {
        return this.f47459b;
    }

    public final void f() {
        if (this.f47466i != null) {
            return;
        }
        SparseArray<ArrayList> sparseArray = new SparseArray<>();
        this.f47466i = sparseArray;
        this.f47459b.u(sparseArray);
        this.j = new HashMap<>();
        int i2 = 0;
        for (int i3 = 0; i3 < this.f47466i.size(); i3++) {
            int keyAt = this.f47466i.keyAt(i3);
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
        if (g(this.f47458a)) {
            File file = new File(this.f47458a.getFilesDir() + File.separator + "statistics_data");
            if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null) {
                if (listFiles.length > 50) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("type", "del_file");
                        jSONObject.put("del_file_size", listFiles.length);
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                    e.h(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, jSONObject.toString());
                    for (File file2 : listFiles) {
                        file2.delete();
                    }
                    this.f47459b.g();
                }
                for (int i2 = 0; i2 < listFiles.length; i2++) {
                    j t = this.f47459b.t(listFiles[i2].getName());
                    if (t != null && TextUtils.equals("0", t.a())) {
                        s.a("processFailedData file, no need to send");
                    } else if (t != null && TextUtils.equals("1", t.a())) {
                        s.a("processFailedData file, send");
                        this.f47459b.E(listFiles[i2].getName(), "0");
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
        this.f47465h++;
        t.f().putInt("ubc_real_time_count", this.f47465h);
    }

    public final void j() {
        List<i> list = this.f47461d;
        if (list == null || list.size() == 0) {
            return;
        }
        this.f47459b.x(this.f47461d);
        this.f47461d.clear();
    }

    public void k(i iVar) {
        boolean z = TextUtils.equals(iVar.h(), iVar.g()) && this.l.b(iVar.h()) && (iVar.j() & 64) == 0;
        if (z && !A(iVar)) {
            this.f47459b.w(iVar);
        } else if (Math.abs(System.currentTimeMillis() - this.f47463f) >= d.g().h()) {
            if (!z) {
                this.f47461d.add(iVar);
            }
            z();
        } else if ((1 & iVar.j()) != 0) {
            if (z) {
                return;
            }
            this.f47459b.w(iVar);
        } else {
            if (!z) {
                this.f47461d.add(iVar);
            }
            if (this.f47461d.size() >= 20) {
                j();
            }
        }
    }

    public void l(i iVar) {
        this.f47460c.d(iVar, this.l.b(iVar.h()));
    }

    public final void m(String str, String str2) {
        OutputStream fileOutputStream;
        String str3 = this.f47458a.getFilesDir() + File.separator + "statistics_data";
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
            d.a.h0.p.d.a(outputStream);
        } catch (Throwable th2) {
            th = th2;
            outputStream = fileOutputStream;
            d.a.h0.p.d.a(outputStream);
            throw th;
        }
        d.a.h0.p.d.a(outputStream);
    }

    public final void n(boolean z) {
        u uVar = new u();
        uVar.q(z);
        if (this.f47460c.c(uVar, z)) {
            JSONArray j = uVar.j();
            this.f47460c.b(z);
            n.k().w(j);
        }
    }

    public void o() {
        this.f47459b.A();
    }

    public void p(k kVar) {
        this.f47459b.z(kVar);
    }

    public final void q(u uVar) {
        if (uVar.k()) {
            return;
        }
        JSONArray j = uVar.j();
        String d2 = d.a.h0.p.e.d(j.toString().getBytes(), true);
        m(j.toString(), d2);
        this.f47459b.y(d2, uVar.l());
        if (!this.f47459b.f(uVar.g(), uVar.f(), uVar.l(), d2)) {
            uVar.c();
            File file = new File(this.f47458a.getFilesDir() + File.separator + "statistics_data", d2);
            if (file.exists() && file.delete()) {
                Log.d("CeresBehaviorModel", "db fail deleteUploadFile file suc");
            }
            this.f47459b.h(d2);
            return;
        }
        n.k().v(j, d2);
        uVar.c();
    }

    public void r(q qVar) {
        this.l.q(qVar.a());
        this.l.n(qVar.d() * 86400000);
        this.l.o(qVar.c());
        t.f().putString("ubc_version_md5", qVar.b());
        this.f47459b.B(qVar.a());
        qVar.a().clear();
        if (this.f47466i == null) {
            this.f47466i = new SparseArray<>();
        }
        this.f47466i.clear();
        if (this.j == null) {
            this.j = new HashMap<>();
        }
        this.j.clear();
        this.f47459b.u(this.f47466i);
        int i2 = 0;
        for (int i3 = 0; i3 < this.f47466i.size(); i3++) {
            int keyAt = this.f47466i.keyAt(i3);
            if (keyAt != 0 && i2 == 0) {
                i2 = keyAt;
            }
            HashMap<String, Long> hashMap = this.j;
            hashMap.put("ubc_last_upload_time_level_" + keyAt, 0L);
        }
        this.l.p(i2);
    }

    public void s(String str, int i2, String str2) {
        this.f47459b.C(str, i2, str2);
    }

    public void t() {
        if (g(this.f47458a) && Math.abs(System.currentTimeMillis() - this.f47462e) >= VideoCloudSetting.HOUR_MILLISECOND) {
            this.f47459b.e();
            u uVar = new u();
            if (this.f47459b.k(uVar) == 0) {
                return;
            }
            u uVar2 = new u();
            uVar2.o(uVar.i(), uVar.h());
            uVar2.p(uVar.d());
            uVar2.q(true);
            u uVar3 = new u();
            uVar3.o(uVar.i(), uVar.h());
            uVar3.p(uVar.d());
            uVar3.q(false);
            SparseArray<Integer> g2 = uVar.g();
            int size = g2.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (this.l.b(String.valueOf(g2.valueAt(i2).intValue()))) {
                    uVar2.n(g2.keyAt(i2), g2.valueAt(i2).intValue());
                } else {
                    uVar3.n(g2.keyAt(i2), g2.valueAt(i2).intValue());
                }
            }
            ArrayList f2 = uVar.f();
            int size2 = f2.size();
            for (int i3 = 0; i3 < size2; i3++) {
                String str = (String) f2.get(i3);
                if (this.l.b(str)) {
                    uVar2.m(str);
                } else {
                    uVar3.m(str);
                }
            }
            JSONArray e2 = uVar.e();
            int length = e2.length();
            for (int i4 = 0; i4 < length; i4++) {
                JSONObject optJSONObject = e2.optJSONObject(i4);
                if (optJSONObject.has("bizId")) {
                    String str2 = null;
                    try {
                        str2 = optJSONObject.getString("bizId");
                    } catch (JSONException e3) {
                        e3.printStackTrace();
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
            if (uVar2.e().length() > 0) {
                q(uVar2);
            }
            if (uVar3.e().length() > 0) {
                q(uVar3);
            }
            this.f47462e = System.currentTimeMillis();
            t.f().putLong("ubc_last_upload_all_time", this.f47462e);
            this.f47463f = this.f47462e;
            t.f().putLong("ubc_last_upload_non_real", this.f47463f);
        }
    }

    public final void u(JSONArray jSONArray, String str) {
        if (this.k.a(jSONArray)) {
            n.k().x(str, true);
        } else {
            n.k().x(str, false);
        }
    }

    public void v(String str) {
        File file = new File(this.f47458a.getFilesDir() + File.separator + "statistics_data", str);
        InputStream inputStream = null;
        try {
            InputStream fileInputStream = new FileInputStream(file);
            try {
                if (fileInputStream.available() > 0) {
                    inputStream = new Base64InputStream(fileInputStream, 0);
                    n.k().v(new JSONArray(d.a.h0.p.g.c(inputStream)), str);
                    fileInputStream = inputStream;
                }
                d.a.h0.p.d.a(fileInputStream);
            } catch (Exception unused) {
                inputStream = fileInputStream;
                d.a.h0.p.d.a(inputStream);
            } catch (Throwable th) {
                th = th;
                inputStream = fileInputStream;
                d.a.h0.p.d.a(inputStream);
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
        e.h(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, "sendFail");
    }

    public void x(String str) {
        s.a("upload file fail");
        this.f47459b.D(str);
    }

    public void y(String str) {
        File file = new File(this.f47458a.getFilesDir() + File.separator + "statistics_data", str);
        s.a("delete file");
        if (file.exists() && file.delete()) {
            Log.d("CeresBehaviorModel", "deleteUploadFile file suc");
            s.a("delete file suc");
        }
        this.f47459b.h(str);
    }

    public final void z() {
        if (g(this.f47458a)) {
            this.f47463f = System.currentTimeMillis();
            t.f().putLong("ubc_last_upload_non_real", this.f47463f);
            b();
            j();
            this.f47459b.e();
            HashSet hashSet = new HashSet();
            if (this.f47466i == null) {
                f();
            }
            u uVar = new u();
            uVar.q(false);
            int i2 = 0;
            for (int i3 = 0; i3 < this.f47466i.size(); i3++) {
                int keyAt = this.f47466i.keyAt(i3);
                if (keyAt != 0) {
                    HashMap<String, Long> hashMap = this.j;
                    long longValue = hashMap.get("ubc_last_upload_time_level_" + keyAt).longValue();
                    if (longValue == 0 || (longValue + (keyAt * 60000)) - System.currentTimeMillis() < this.l.h()) {
                        i2 |= this.f47459b.l(this.f47466i.valueAt(i3), uVar);
                        HashMap<String, Long> hashMap2 = this.j;
                        hashMap2.put("ubc_last_upload_time_level_" + keyAt, Long.valueOf(System.currentTimeMillis()));
                        hashSet.add(Integer.valueOf(keyAt));
                    }
                }
            }
            if (i2 == 0) {
                return;
            }
            for (int i4 = 0; i4 < this.f47466i.size(); i4++) {
                int keyAt2 = this.f47466i.keyAt(i4);
                if (keyAt2 != 0 && !hashSet.contains(Integer.valueOf(keyAt2))) {
                    if (uVar.b(51200)) {
                        break;
                    }
                    this.f47459b.l(this.f47466i.valueAt(i4), uVar);
                }
            }
            q(uVar);
        }
    }
}

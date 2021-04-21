package d.b.h0.n;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import android.util.Base64InputStream;
import android.util.Base64OutputStream;
import android.util.Log;
import android.util.SparseArray;
import com.baidu.ala.view.AlaAttentionManager;
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
    public Context f49933a;

    /* renamed from: b  reason: collision with root package name */
    public a f49934b;

    /* renamed from: c  reason: collision with root package name */
    public b f49935c;

    /* renamed from: e  reason: collision with root package name */
    public long f49937e;

    /* renamed from: f  reason: collision with root package name */
    public long f49938f;

    /* renamed from: g  reason: collision with root package name */
    public long f49939g;

    /* renamed from: h  reason: collision with root package name */
    public int f49940h;
    public SparseArray<ArrayList> i;
    public HashMap<String, Long> j;
    public d l;
    public m k = e.g().j();

    /* renamed from: d  reason: collision with root package name */
    public List<i> f49936d = new ArrayList(20);

    public c(Context context) {
        this.f49933a = context;
        this.f49934b = new a(context);
        this.f49935c = new b(context);
        t f2 = t.f();
        this.f49937e = f2.getLong("ubc_last_upload_all_time", 0L);
        this.f49938f = f2.getLong("ubc_last_upload_non_real", 0L);
        this.f49939g = f2.getLong("ubc_reset_real_time_count_time", 0L);
        this.f49940h = f2.getInt("ubc_real_time_count", 0);
        d g2 = d.g();
        this.l = g2;
        g2.k(this, context);
    }

    public final boolean A(i iVar) {
        if (g(this.f49933a) && c()) {
            j();
            u uVar = new u();
            uVar.q(true);
            JSONObject i = iVar.i();
            try {
                if (i != null && i.has("bizId")) {
                    r.a(i);
                    uVar.a(i);
                    uVar.o(iVar.k(), iVar.k());
                    JSONObject jSONObject = i.getJSONObject("content");
                    JSONObject jSONObject2 = i.getJSONObject(DI.APP_INFO_NAME);
                    if (jSONObject != null && jSONObject2 != null) {
                        jSONObject.put(DI.APP_INFO_NAME, jSONObject2);
                        i.remove(DI.APP_INFO_NAME);
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
            if (this.i == null) {
                f();
            }
            if (this.i.size() > 0) {
                this.f49934b.l(this.i.valueAt(0), uVar);
            }
            q(uVar);
            i();
            return true;
        }
        return false;
    }

    public final void B() {
        if (g(this.f49933a) && c()) {
            u uVar = new u();
            uVar.q(true);
            if (this.i == null) {
                f();
            }
            if (this.i.size() > 0) {
                if (e.g().s()) {
                    this.f49934b.k(uVar);
                } else {
                    this.f49934b.l(this.i.valueAt(0), uVar);
                }
            }
            q(uVar);
            i();
        }
    }

    public void a(String str, int i) {
        j();
        this.f49934b.c(str, i);
        if (Math.abs(System.currentTimeMillis() - this.f49938f) >= d.g().h()) {
            z();
        }
    }

    public final void b() {
        n(true);
        n(false);
    }

    public final boolean c() {
        if (e.g().s()) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (Math.abs(currentTimeMillis - this.f49939g) > 86400000) {
            this.f49940h = 0;
            this.f49939g = currentTimeMillis;
            t.f().putLong("ubc_reset_real_time_count_time", this.f49939g);
            t.f().putInt("ubc_real_time_count", this.f49940h);
        }
        int i = this.f49940h;
        if (i >= 1000) {
            if (i == 1000) {
                this.f49940h = i + 1;
                e.h(Constants.VIA_REPORT_TYPE_SHARE_TO_TROOPBAR, "realLimit");
            }
            return false;
        }
        return true;
    }

    public void d(String str, int i, long j, JSONArray jSONArray) {
        j();
        this.f49934b.i(str, i, j, jSONArray);
        if (this.l.b(str)) {
            B();
        }
        if (Math.abs(System.currentTimeMillis() - this.f49938f) >= d.g().h()) {
            z();
        }
    }

    public a e() {
        return this.f49934b;
    }

    public final void f() {
        if (this.i != null) {
            return;
        }
        SparseArray<ArrayList> sparseArray = new SparseArray<>();
        this.i = sparseArray;
        this.f49934b.u(sparseArray);
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
        if (g(this.f49933a)) {
            File file = new File(this.f49933a.getFilesDir() + File.separator + "statistics_data");
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
                    this.f49934b.g();
                }
                for (int i = 0; i < listFiles.length; i++) {
                    j t = this.f49934b.t(listFiles[i].getName());
                    if (t != null && TextUtils.equals("0", t.a())) {
                        s.a("processFailedData file, no need to send");
                    } else if (t != null && TextUtils.equals("1", t.a())) {
                        s.a("processFailedData file, send");
                        this.f49934b.E(listFiles[i].getName(), "0");
                        v(listFiles[i].getName());
                    } else {
                        s.a("processFailedData file, data in db, delete file");
                        listFiles[i].delete();
                    }
                }
            }
        }
    }

    public final void i() {
        this.f49940h++;
        t.f().putInt("ubc_real_time_count", this.f49940h);
    }

    public final void j() {
        List<i> list = this.f49936d;
        if (list == null || list.size() == 0) {
            return;
        }
        this.f49934b.x(this.f49936d);
        this.f49936d.clear();
    }

    public void k(i iVar) {
        boolean z = TextUtils.equals(iVar.h(), iVar.g()) && this.l.b(iVar.h()) && (iVar.j() & 64) == 0;
        if (z && !A(iVar)) {
            this.f49934b.w(iVar);
        } else if (Math.abs(System.currentTimeMillis() - this.f49938f) >= d.g().h()) {
            if (!z) {
                this.f49936d.add(iVar);
            }
            z();
        } else if ((1 & iVar.j()) != 0) {
            if (z) {
                return;
            }
            this.f49934b.w(iVar);
        } else {
            if (!z) {
                this.f49936d.add(iVar);
            }
            if (this.f49936d.size() >= 20) {
                j();
            }
        }
    }

    public void l(i iVar) {
        this.f49935c.d(iVar, this.l.b(iVar.h()));
    }

    public final void m(String str, String str2) {
        OutputStream fileOutputStream;
        String str3 = this.f49933a.getFilesDir() + File.separator + "statistics_data";
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
            d.b.h0.p.d.a(outputStream);
        } catch (Throwable th2) {
            th = th2;
            outputStream = fileOutputStream;
            d.b.h0.p.d.a(outputStream);
            throw th;
        }
        d.b.h0.p.d.a(outputStream);
    }

    public final void n(boolean z) {
        u uVar = new u();
        uVar.q(z);
        if (this.f49935c.c(uVar, z)) {
            JSONArray j = uVar.j();
            this.f49935c.b(z);
            n.k().w(j);
        }
    }

    public void o() {
        this.f49934b.A();
    }

    public void p(k kVar) {
        this.f49934b.z(kVar);
    }

    public final void q(u uVar) {
        if (uVar.k()) {
            return;
        }
        JSONArray j = uVar.j();
        String d2 = d.b.h0.p.e.d(j.toString().getBytes(), true);
        m(j.toString(), d2);
        this.f49934b.y(d2, uVar.l());
        if (!this.f49934b.f(uVar.g(), uVar.f(), uVar.l(), d2)) {
            uVar.c();
            File file = new File(this.f49933a.getFilesDir() + File.separator + "statistics_data", d2);
            if (file.exists() && file.delete()) {
                Log.d("CeresBehaviorModel", "db fail deleteUploadFile file suc");
            }
            this.f49934b.h(d2);
            return;
        }
        n.k().v(j, d2);
        uVar.c();
    }

    public void r(q qVar) {
        this.l.q(qVar.a());
        this.l.n(qVar.d() * AlaAttentionManager.ALA_LIVE_PUSH_REMIND_TIME_INTERVAL);
        this.l.o(qVar.c());
        t.f().putString("ubc_version_md5", qVar.b());
        this.f49934b.B(qVar.a());
        qVar.a().clear();
        if (this.i == null) {
            this.i = new SparseArray<>();
        }
        this.i.clear();
        if (this.j == null) {
            this.j = new HashMap<>();
        }
        this.j.clear();
        this.f49934b.u(this.i);
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

    public void s(String str, int i, String str2) {
        this.f49934b.C(str, i, str2);
    }

    public void t() {
        if (g(this.f49933a) && Math.abs(System.currentTimeMillis() - this.f49937e) >= VideoCloudSetting.HOUR_MILLISECOND) {
            this.f49934b.e();
            u uVar = new u();
            if (this.f49934b.k(uVar) == 0) {
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
            for (int i = 0; i < size; i++) {
                if (this.l.b(String.valueOf(g2.valueAt(i).intValue()))) {
                    uVar2.n(g2.keyAt(i), g2.valueAt(i).intValue());
                } else {
                    uVar3.n(g2.keyAt(i), g2.valueAt(i).intValue());
                }
            }
            ArrayList f2 = uVar.f();
            int size2 = f2.size();
            for (int i2 = 0; i2 < size2; i2++) {
                String str = (String) f2.get(i2);
                if (this.l.b(str)) {
                    uVar2.m(str);
                } else {
                    uVar3.m(str);
                }
            }
            JSONArray e2 = uVar.e();
            int length = e2.length();
            for (int i3 = 0; i3 < length; i3++) {
                JSONObject optJSONObject = e2.optJSONObject(i3);
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
            this.f49937e = System.currentTimeMillis();
            t.f().putLong("ubc_last_upload_all_time", this.f49937e);
            this.f49938f = this.f49937e;
            t.f().putLong("ubc_last_upload_non_real", this.f49938f);
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
        File file = new File(this.f49933a.getFilesDir() + File.separator + "statistics_data", str);
        InputStream inputStream = null;
        try {
            InputStream fileInputStream = new FileInputStream(file);
            try {
                if (fileInputStream.available() > 0) {
                    inputStream = new Base64InputStream(fileInputStream, 0);
                    n.k().v(new JSONArray(d.b.h0.p.g.c(inputStream)), str);
                    fileInputStream = inputStream;
                }
                d.b.h0.p.d.a(fileInputStream);
            } catch (Exception unused) {
                inputStream = fileInputStream;
                d.b.h0.p.d.a(inputStream);
            } catch (Throwable th) {
                th = th;
                inputStream = fileInputStream;
                d.b.h0.p.d.a(inputStream);
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
        this.f49934b.D(str);
    }

    public void y(String str) {
        File file = new File(this.f49933a.getFilesDir() + File.separator + "statistics_data", str);
        s.a("delete file");
        if (file.exists() && file.delete()) {
            Log.d("CeresBehaviorModel", "deleteUploadFile file suc");
            s.a("delete file suc");
        }
        this.f49934b.h(str);
    }

    public final void z() {
        if (g(this.f49933a)) {
            this.f49938f = System.currentTimeMillis();
            t.f().putLong("ubc_last_upload_non_real", this.f49938f);
            b();
            j();
            this.f49934b.e();
            HashSet hashSet = new HashSet();
            if (this.i == null) {
                f();
            }
            u uVar = new u();
            uVar.q(false);
            int i = 0;
            for (int i2 = 0; i2 < this.i.size(); i2++) {
                int keyAt = this.i.keyAt(i2);
                if (keyAt != 0) {
                    HashMap<String, Long> hashMap = this.j;
                    long longValue = hashMap.get("ubc_last_upload_time_level_" + keyAt).longValue();
                    if (longValue == 0 || (longValue + (keyAt * 60000)) - System.currentTimeMillis() < this.l.h()) {
                        i |= this.f49934b.l(this.i.valueAt(i2), uVar);
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
                    if (uVar.b(51200)) {
                        break;
                    }
                    this.f49934b.l(this.i.valueAt(i3), uVar);
                }
            }
            q(uVar);
        }
    }
}

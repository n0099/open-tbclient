package d.b.k0;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import com.baidu.ala.view.AlaAttentionManager;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.logsystem.basic.upload.Constant;
import com.baidu.tieba.tblauncher.MainTabActivity;
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
/* loaded from: classes5.dex */
public class c {
    public static final boolean v = AppConfig.isDebug();

    /* renamed from: a  reason: collision with root package name */
    public int f63875a;

    /* renamed from: b  reason: collision with root package name */
    public long f63876b;

    /* renamed from: d  reason: collision with root package name */
    public Context f63878d;

    /* renamed from: e  reason: collision with root package name */
    public x f63879e;

    /* renamed from: f  reason: collision with root package name */
    public d.b.k0.b f63880f;
    public List<n> i;
    public long j;
    public long k;
    public long l;
    public int m;
    public SparseArray<ArrayList> n;
    public HashMap<String, Long> o;
    public u p;
    public g q;
    public int r;
    public int s;
    public int t;

    /* renamed from: c  reason: collision with root package name */
    public boolean f63877c = false;

    /* renamed from: g  reason: collision with root package name */
    public int f63881g = 0;

    /* renamed from: h  reason: collision with root package name */
    public long f63882h = 0;
    public Runnable u = new a();

    /* loaded from: classes5.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (c.this.f63881g == 1) {
                long uptimeMillis = SystemClock.uptimeMillis() - c.this.f63882h;
                if (uptimeMillis >= 5000) {
                    if (c.v) {
                        Log.d("UBCBehaviorModel", String.format("***saveCache after %d ms***", Long.valueOf(uptimeMillis)));
                    }
                    c.this.v();
                    c.this.f63881g = 0;
                    return;
                }
                d.q().z(this, 5000 - uptimeMillis);
            } else if (c.this.f63881g == 2) {
                c.this.f63881g = 0;
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements t {
        public b() {
        }

        @Override // d.b.k0.t
        public void a(boolean z, n nVar) {
            if (!z) {
                c.this.f63879e.r(nVar);
            } else {
                c.this.f63879e.d();
            }
        }
    }

    public c(Context context) {
        this.f63878d = context;
        g0 e2 = g0.e();
        this.f63879e = new x(context);
        this.f63880f = new d.b.k0.b(context);
        this.p = e0.a();
        this.i = new ArrayList(20);
        this.j = e2.getLong("ubc_last_upload_non_real", 0L);
        this.k = e2.getLong("ubc_reset_real_time_count_time", 0L);
        this.l = e2.getLong("ubc_last_upload_failed_data_time", 0L);
        this.m = e2.getInt("ubc_real_time_count", 0);
        g m = g.m();
        this.q = m;
        m.t(this, context);
        this.f63876b = System.currentTimeMillis();
        this.f63875a = new Random().nextInt(31) + 60;
    }

    public void A() {
        h0 h0Var = new h0();
        if (this.f63880f.e(h0Var)) {
            JSONObject i = h0Var.i();
            if (v) {
                Log.d("UBCBehaviorModel", "sendQualityData:" + i.toString());
            }
            d.q().E(i);
        }
    }

    public final void B(boolean z) {
        h0 h0Var = new h0();
        h0Var.r(z);
        if (this.f63880f.f(h0Var, z)) {
            JSONObject i = h0Var.i();
            if (v) {
                Log.d("UBCBehaviorModel", "checkFileData:" + i.toString());
            }
            this.f63880f.c(z);
            d.q().E(i);
        }
    }

    public void C() {
        this.f63879e.u();
    }

    public void D(p pVar) {
        this.f63879e.t(pVar);
    }

    public final void E(h0 h0Var) {
        if (h0Var.j()) {
            return;
        }
        try {
            JSONObject i = h0Var.i();
            String b2 = f0.b(i.toString().getBytes(), true);
            z(i.toString(), b2);
            if (v) {
                z.a(h0Var);
                Log.d("UBCBehaviorModel", "save send data to file " + b2);
            }
            if (!this.f63879e.c(h0Var.f(), h0Var.e(), h0Var.l(), b2)) {
                h0Var.c();
                File file = new File(this.f63878d.getFilesDir() + File.separator + "ubcsenddir", b2);
                if (file.exists() && file.delete()) {
                    Log.d("UBCBehaviorModel", "db fail deleteUploadFile file suc");
                }
                this.f63879e.g(b2);
                return;
            }
            d.q().F(i, b2);
            h0Var.c();
            long currentTimeMillis = System.currentTimeMillis();
            if (Math.abs(currentTimeMillis - this.l) < MainTabActivity.SERVICE_BETWEEN_TIME) {
                return;
            }
            this.l = currentTimeMillis;
            g0.e().putLong("ubc_last_upload_failed_data_time", this.l);
            d.q().w();
        } catch (OutOfMemoryError unused) {
            h0Var.c();
        }
    }

    public void F(w wVar, boolean z, s sVar) {
        JSONArray jSONArray = new JSONArray();
        this.r = 0;
        this.s = 0;
        this.t = 0;
        k(wVar, z, jSONArray);
        r(wVar, z, jSONArray);
        if (sVar != null && jSONArray.length() > 0) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("items", jSONArray);
                jSONObject.put("count", String.format("%d,%d,%d", Integer.valueOf(this.r + this.s + this.t), Integer.valueOf(this.r), Integer.valueOf(this.t)));
                sVar.setUBCConfigStatisticData(jSONObject);
            } catch (JSONException e2) {
                if (v) {
                    e2.printStackTrace();
                }
            }
        }
        this.q.F(wVar.b());
        int g2 = wVar.g();
        if (g2 > 0) {
            this.q.A(g2 * AlaAttentionManager.ALA_LIVE_PUSH_REMIND_TIME_INTERVAL);
        }
        if (wVar.f() > 0) {
            this.q.B(wVar.f());
        }
        int c2 = wVar.c();
        if (c2 > 307200) {
            this.q.C(c2);
        }
        int d2 = wVar.d();
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
        this.f63879e.p(this.n);
        int i = 0;
        for (int i2 = 0; i2 < this.n.size(); i2++) {
            int keyAt = this.n.keyAt(i2);
            if (keyAt != 0 && i == 0) {
                i = keyAt;
            }
            HashMap<String, Long> hashMap = this.o;
            hashMap.put("ubc_last_upload_time_level_" + keyAt, 0L);
        }
        this.q.E(i);
        wVar.b().clear();
    }

    public void G(String str, int i, String str2) {
        this.f63879e.w(str, i, str2);
    }

    public final void H(JSONObject jSONObject, String str, boolean z, n nVar, t tVar) {
        boolean a2 = this.p.a(jSONObject, z);
        if (tVar != null) {
            tVar.a(a2, nVar);
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        d.q().I(str, a2);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:37:0x00ca -> B:45:0x00cd). Please submit an issue!!! */
    public void I(String str) {
        InputStream fileInputStream;
        File file = new File(this.f63878d.getFilesDir() + File.separator + "ubcsenddir", str);
        InputStream inputStream = null;
        try {
            try {
                try {
                    if (v) {
                        Log.d("UBCBehaviorModel", "uploadFile fileName:" + str);
                    }
                    fileInputStream = new FileInputStream(file);
                } catch (IOException e2) {
                    e2.printStackTrace();
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
                } catch (Exception e3) {
                    e = e3;
                    inputStream = fileInputStream;
                    if (v) {
                        Log.d("UBCBehaviorModel", "error:" + e.getMessage());
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                } catch (OutOfMemoryError e4) {
                    e = e4;
                    inputStream = fileInputStream;
                    if (v) {
                        Log.d("UBCBehaviorModel", "OutOfMemoryError:" + e.getMessage());
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                } catch (Throwable th) {
                    th = th;
                    inputStream = fileInputStream;
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (IOException e5) {
                            e5.printStackTrace();
                        }
                    }
                    throw th;
                }
            } catch (Exception e6) {
                e = e6;
            } catch (OutOfMemoryError e7) {
                e = e7;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public void J(String str) {
        if (v) {
            Log.d("UBCBehaviorModel", "upload file fail:" + str);
        }
        z.b("upload file fail");
        this.f63879e.x(str);
    }

    public void K(String str) {
        File file = new File(this.f63878d.getFilesDir() + File.separator + "ubcsenddir", str);
        if (v) {
            Log.d("UBCBehaviorModel", "deleteUploadFile file:" + file.getAbsolutePath());
        }
        z.b("delete file");
        if (file.exists() && file.delete()) {
            Log.d("UBCBehaviorModel", "deleteUploadFile file suc");
            z.b("delete file suc");
        }
        this.f63879e.g(str);
    }

    public void L() {
        if (s(this.f63878d)) {
            this.f63879e.b();
            h0 h0Var = new h0();
            h0Var.s(this.q.n());
            h0Var.r(true);
            h0 h0Var2 = new h0();
            h0Var2.s(this.q.n());
            h0Var2.r(false);
            if (this.f63879e.i(h0Var, h0Var2) == 0) {
                return;
            }
            if (v) {
                int length = h0Var.d().length();
                int length2 = h0Var2.d().length();
                Log.d("UBCBehaviorModel", "real size = " + length + "   no real  = " + length2);
            }
            if (h0Var.d().length() > 0) {
                E(h0Var);
            }
            if (h0Var2.d().length() > 0) {
                E(h0Var2);
            }
        }
    }

    public final void M(SparseArray<ArrayList> sparseArray, h0 h0Var) {
        for (int i = 0; i < sparseArray.size() && !h0Var.b(51200); i++) {
            this.f63879e.m(sparseArray.valueAt(i), h0Var);
        }
    }

    public final void N() {
        if (s(this.f63878d)) {
            if (v) {
                Log.d("UBCBehaviorModel", " upload no real data");
            }
            this.j = System.currentTimeMillis();
            g0.e().putLong("ubc_last_upload_non_real", this.j);
            i();
            v();
            this.f63879e.b();
            HashSet hashSet = new HashSet();
            if (this.n == null) {
                q();
            }
            h0 h0Var = new h0();
            h0Var.r(false);
            int i = 0;
            for (int i2 = 0; i2 < this.n.size(); i2++) {
                int keyAt = this.n.keyAt(i2);
                if (keyAt != 0) {
                    HashMap<String, Long> hashMap = this.o;
                    long longValue = hashMap.get("ubc_last_upload_time_level_" + keyAt).longValue();
                    if (longValue == 0 || (longValue + (keyAt * 60000)) - System.currentTimeMillis() < this.q.p()) {
                        i |= this.f63879e.m(this.n.valueAt(i2), h0Var);
                        HashMap<String, Long> hashMap2 = this.o;
                        hashMap2.put("ubc_last_upload_time_level_" + keyAt, Long.valueOf(System.currentTimeMillis()));
                        hashSet.add(Integer.valueOf(keyAt));
                    }
                }
            }
            if (i == 0) {
                return;
            }
            for (int i3 = 0; i3 < this.n.size(); i3++) {
                int keyAt2 = this.n.keyAt(i3);
                if (keyAt2 != 0 && !hashSet.contains(Integer.valueOf(keyAt2))) {
                    if (h0Var.b(51200)) {
                        break;
                    }
                    this.f63879e.m(this.n.valueAt(i3), h0Var);
                }
            }
            if (v) {
                Log.d("UBCBehaviorModel", "UBC non real time:");
            }
            E(h0Var);
        }
    }

    public final boolean O(n nVar) {
        if (s(this.f63878d) && j()) {
            v();
            h0 o = o(nVar);
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

    public final void P() {
        if (s(this.f63878d) && j()) {
            h0 h0Var = new h0();
            h0Var.r(true);
            if (this.n == null) {
                q();
            }
            if (R(h0Var, "1")) {
                return;
            }
            M(this.n, h0Var);
            E(h0Var);
            u();
        }
    }

    public boolean Q(n nVar) {
        if (s(this.f63878d)) {
            nVar.q("1");
            h0 o = o(nVar);
            if (o.j()) {
                return false;
            }
            this.f63879e.n(o);
            d.q().H(o.i(), true, nVar, new b());
            o.c();
            return true;
        }
        return false;
    }

    public final boolean R(h0 h0Var, String str) {
        if (UBC.getUBCContext().b()) {
            List<String> d2 = UBC.getUBCContext().d();
            if (d2 != null && d2.size() != 0) {
                ArrayList<j> arrayList = new ArrayList<>();
                for (int i = 0; i < d2.size(); i++) {
                    arrayList.add(new j(d2.get(i), str));
                }
                if (arrayList.size() == 0) {
                    return true;
                }
                this.f63879e.m(arrayList, h0Var);
                E(h0Var);
                u();
            }
            return true;
        }
        return false;
    }

    public final void g(n nVar) {
        this.i.add(nVar);
        int i = this.f63881g;
        if (i == 0) {
            this.f63882h = SystemClock.uptimeMillis();
            d.q().z(this.u, 5000L);
            this.f63881g = 1;
        } else if (i == 2) {
            this.f63882h = SystemClock.uptimeMillis();
            this.f63881g = 1;
        }
    }

    public void h(String str, int i) {
        v();
        this.f63879e.a(str, i);
        if (!UBC.getUBCContext().b() && Math.abs(System.currentTimeMillis() - this.j) >= g.m().p()) {
            if (v) {
                Log.d("UBCBehaviorModel", "cancel flow " + str + " invoke ->uploadNonRealTimeData ");
            }
            N();
        }
    }

    public final void i() {
        B(true);
        B(false);
    }

    public final boolean j() {
        if (AppConfig.isDebug()) {
            return true;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (Math.abs(currentTimeMillis - this.k) > 86400000) {
            this.m = 0;
            this.k = currentTimeMillis;
            g0.e().putLong("ubc_reset_real_time_count_time", this.k);
            g0.e().putInt("ubc_real_time_count", this.m);
        }
        if (this.m >= 10000) {
            if (v) {
                Log.d("UBCBehaviorModel", "real time upload total count check fail");
            }
            int i = this.m;
            if (i == 10000) {
                this.m = i + 1;
                if (!v) {
                    a0.a().f(String.valueOf(10000));
                }
            }
            return false;
        }
        return true;
    }

    public void k(w wVar, boolean z, JSONArray jSONArray) {
        JSONObject a2 = wVar.a();
        if (a2 == null) {
            return;
        }
        Iterator<String> keys = a2.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            try {
                JSONObject jSONObject = new JSONObject();
                k k = this.f63879e.k(next);
                String optString = a2.optString(next, "0");
                String r = k != null ? k.r() : "0";
                boolean z2 = Integer.parseInt(r) >= Integer.parseInt(optString);
                if (z && r != null && z2) {
                    jSONObject.put("product", String.format("del/%s", next));
                    jSONObject.put("valid", "2");
                    jSONObject.put("version", optString);
                    jSONArray.put(jSONObject);
                    this.t++;
                } else {
                    jSONObject.put("product", String.format("del/%s", next));
                    jSONObject.put("version", optString);
                    jSONObject.put("valid", "1");
                    if (!this.f63879e.f(next)) {
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

    public void l(String str, int i, long j, JSONArray jSONArray) {
        List<String> d2;
        v();
        this.f63879e.h(str, i, j, jSONArray);
        boolean e2 = this.q.e(str);
        if (UBC.getUBCContext().b()) {
            if (!e2 || (d2 = UBC.getUBCContext().d()) == null || !d2.contains(str)) {
                return;
            }
            if (!this.f63877c) {
                if ((System.currentTimeMillis() - this.f63876b) / 1000 < this.f63875a) {
                    return;
                }
                this.f63877c = true;
            }
        }
        if (e2) {
            if (v) {
                Log.d("UBCBehaviorModel", "endFlow flow " + str + " invoke ->uploadRealTimeFlow ");
            }
            P();
        }
        if (!UBC.getUBCContext().b() && Math.abs(System.currentTimeMillis() - this.j) >= g.m().p()) {
            if (v) {
                Log.d("UBCBehaviorModel", "endFlow flow " + str + " invoke ->uploadNonRealTimeData ");
            }
            N();
        }
    }

    public void m() {
        try {
            v();
        } catch (RuntimeException unused) {
            if (v) {
                Log.d("UBCBehaviorModel", "save cache error!");
            }
        }
    }

    public x n() {
        return this.f63879e;
    }

    public final h0 o(n nVar) {
        h0 h0Var = new h0();
        h0Var.r(true);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("id", nVar.g());
            jSONObject.put("timestamp", Long.toString(nVar.k()));
            if (nVar.h() != null) {
                jSONObject.put("content", nVar.h().toString());
            } else {
                jSONObject.put("content", nVar.b());
            }
            jSONObject.put("type", "0");
            String str = "1";
            if (!TextUtils.isEmpty(nVar.c())) {
                jSONObject.put("abtest", nVar.c());
                h0Var.q("1");
            }
            if (!TextUtils.isEmpty(nVar.a())) {
                jSONObject.put("c", nVar.a());
            }
            if (nVar.l()) {
                jSONObject.put("of", "1");
            }
            jSONObject.put(Constant.ID_TYPE, this.q.r(nVar.g()));
            if (!this.q.z(nVar.g())) {
                str = "0";
            }
            jSONObject.put(Constant.IS_REAL, str);
            String l = this.q.l(nVar.g());
            if (!TextUtils.isEmpty(l) && !TextUtils.equals(l, "0")) {
                jSONObject.put("gflow", l);
            }
            h0Var.a(jSONObject);
            h0Var.p(nVar.k(), nVar.k());
            return h0Var;
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public String p(String str) {
        g gVar = this.q;
        return gVar != null ? gVar.s(str) : "";
    }

    public final void q() {
        if (this.n != null) {
            return;
        }
        if (v) {
            Log.d("UBCBehaviorModel", "BehaviorModel initCache");
        }
        SparseArray<ArrayList> sparseArray = new SparseArray<>();
        this.n = sparseArray;
        this.f63879e.p(sparseArray);
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
        this.q.E(i);
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0117  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void r(w wVar, boolean z, JSONArray jSONArray) {
        HashMap<String, String> hashMap;
        ArrayList arrayList;
        String str;
        String str2;
        String str3;
        String str4;
        JSONObject jSONObject;
        String optString;
        String r;
        JSONObject jSONObject2;
        boolean z2;
        List<k> b2 = wVar.b();
        if (b2 == null || b2.size() == 0) {
            return;
        }
        ArrayList arrayList2 = new ArrayList(b2);
        String str5 = "Json格式转化失败";
        String str6 = "UBCBehaviorModel";
        if (this.f63879e.l() > 0) {
            ArrayList<String> arrayList3 = new ArrayList<>();
            Iterator it = arrayList2.iterator();
            while (it.hasNext()) {
                arrayList3.add(((k) it.next()).d());
            }
            HashMap<String, String> j = this.f63879e.j(arrayList3);
            Iterator it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                k kVar = (k) it2.next();
                String d2 = kVar.d();
                String str7 = j.get(d2);
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
                        r = kVar.r();
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
                        try {
                            z2 = Integer.parseInt(optString) >= Integer.parseInt(r);
                        } catch (NumberFormatException unused7) {
                            str2 = str;
                            str3 = str4;
                            if (v) {
                            }
                            str5 = str2;
                            str6 = str3;
                            j = hashMap;
                            arrayList2 = arrayList;
                        } catch (JSONException unused8) {
                            if (v) {
                            }
                            str2 = str;
                            str3 = str4;
                            str5 = str2;
                            str6 = str3;
                            j = hashMap;
                            arrayList2 = arrayList;
                        }
                    } catch (NumberFormatException unused9) {
                        str3 = str6;
                        str2 = str;
                    } catch (JSONException unused10) {
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
                    if (z && optString != null && r != null && z2) {
                        it2.remove();
                        jSONObject2.put("product", "set/" + d2);
                        jSONObject2.put("valid", "2");
                        jSONObject2.put("version", r);
                        jSONArray.put(jSONObject2);
                        this.t++;
                        j = hashMap;
                        arrayList2 = arrayList;
                        str5 = str;
                        str6 = str4;
                    } else {
                        if (!TextUtils.equals(jSONObject.optString("dfc"), "1") && TextUtils.equals(kVar.f(), "1")) {
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
        boolean v2 = this.f63879e.v(arrayList4);
        Iterator it3 = arrayList4.iterator();
        while (it3.hasNext()) {
            k kVar2 = (k) it3.next();
            JSONObject jSONObject3 = new JSONObject();
            try {
                jSONObject3.put("product", "set/" + kVar2.d());
                jSONObject3.put("version", kVar2.r());
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
        wVar.i(arrayList4);
    }

    @SuppressLint({"MissingPermission"})
    public final boolean s(Context context) {
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

    public void t() {
        File[] listFiles;
        if (s(this.f63878d)) {
            File file = new File(this.f63878d.getFilesDir() + File.separator + "ubcsenddir");
            if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null) {
                if (listFiles.length > 1000) {
                    if (!v) {
                        a0.a().d(String.valueOf(1000), listFiles.length);
                    }
                    for (File file2 : listFiles) {
                        file2.delete();
                    }
                    this.f63879e.e();
                }
                for (int i = 0; i < listFiles.length; i++) {
                    if (v) {
                        Log.d("UBCBehaviorModel", "uploadFailedData fileName:" + listFiles[i].getAbsolutePath());
                    }
                    o o = this.f63879e.o(listFiles[i].getName());
                    if (o != null && TextUtils.equals("0", o.a())) {
                        if (v) {
                            Log.d("UBCBehaviorModel", "processFailedData sending, not send again");
                        }
                        z.b("processFailedData file, no need to send");
                    } else if (o != null && TextUtils.equals("1", o.a())) {
                        z.b("processFailedData file, send");
                        this.f63879e.y(listFiles[i].getName(), "0");
                        I(listFiles[i].getName());
                    } else {
                        if (v) {
                            Log.d("UBCBehaviorModel", "processFailedData data in db");
                        }
                        z.b("processFailedData file, data in db, delete file");
                        listFiles[i].delete();
                    }
                }
            }
        }
    }

    public final void u() {
        this.m++;
        g0.e().putInt("ubc_real_time_count", this.m);
    }

    public final void v() {
        List<n> list = this.i;
        if (list == null || list.size() == 0) {
            return;
        }
        this.f63879e.s(this.i);
        this.i.clear();
        if (this.f63881g == 1) {
            this.f63881g = 2;
        }
    }

    public void w(n nVar) {
        boolean z = TextUtils.equals(nVar.g(), nVar.f()) && this.q.e(nVar.g()) && (nVar.i() & 64) == 0;
        if (UBC.getUBCContext().b()) {
            if (!z) {
                this.f63879e.r(nVar);
                return;
            }
            List<String> d2 = UBC.getUBCContext().d();
            if (d2 != null && d2.contains(nVar.g())) {
                if (!this.f63877c) {
                    if ((System.currentTimeMillis() - this.f63876b) / 1000 >= this.f63875a) {
                        this.f63877c = true;
                    } else {
                        this.f63879e.r(nVar);
                        return;
                    }
                }
            } else {
                this.f63879e.r(nVar);
                return;
            }
        }
        if (z && !O(nVar)) {
            if (this.q.x(nVar.g())) {
                this.f63879e.r(nVar);
            }
        } else if (UBC.getUBCContext().b()) {
            this.f63879e.b();
        } else if (Math.abs(System.currentTimeMillis() - this.j) >= g.m().p()) {
            if (!z && this.q.x(nVar.g())) {
                g(nVar);
            }
            N();
        } else if ((1 & nVar.i()) == 0) {
            if (!z && this.q.x(nVar.g())) {
                g(nVar);
            }
            if (this.i.size() >= 20) {
                v();
            }
        } else if (z || !this.q.x(nVar.g())) {
        } else {
            this.f63879e.r(nVar);
        }
    }

    public void x(n nVar) {
        this.f63880f.g(nVar, this.q.e(nVar.g()));
    }

    public void y(n nVar) {
        if (d.b.d0.b.a.a.g()) {
            this.f63880f.i(nVar);
        }
    }

    public final void z(String str, String str2) {
        OutputStream fileOutputStream;
        String str3 = this.f63878d.getFilesDir() + File.separator + "ubcsenddir";
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
                z.b("save to file suc");
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

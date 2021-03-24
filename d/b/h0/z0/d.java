package d.b.h0.z0;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.android.util.io.FileUtils;
import com.baidu.tbadk.commonReceiver.PackageChangedReceiver;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import rx.schedulers.Schedulers;
/* loaded from: classes3.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public static JSONObject f51659a;

    /* renamed from: b  reason: collision with root package name */
    public static ArrayList<Long> f51660b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    public static final Hashtable<String, ArrayList<c<Integer, Integer>>> f51661c = new Hashtable<>();

    /* renamed from: d  reason: collision with root package name */
    public static boolean f51662d = true;

    /* loaded from: classes3.dex */
    public static class a implements h.n.b<String> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f51663e;

        public a(String str) {
            this.f51663e = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        /* renamed from: a */
        public void call(String str) {
            String o = d.b.h0.r.d0.b.i().o("old_sniff_url", "");
            if (TextUtils.isEmpty(this.f51663e) || this.f51663e.equals(o)) {
                d.q(false);
                return;
            }
            File file = new File(BdBaseApplication.getInst().getApp().getApplicationContext().getFilesDir(), "sniff");
            if (!file.exists()) {
                file.mkdir();
            }
            if (d.b.h0.z0.b.c().a(new File(file, "sniff.json"), this.f51663e) > 0) {
                d.b.h0.r.d0.b.i().w("old_sniff_url", "");
            }
            d.q(true);
        }
    }

    /* loaded from: classes3.dex */
    public static class b implements h.n.b<String> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f51664e;

        public b(boolean z) {
            this.f51664e = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        /* renamed from: a */
        public void call(String str) {
            if (d.f51659a == null || this.f51664e) {
                d.h();
            }
            d.p();
        }
    }

    /* loaded from: classes3.dex */
    public static class c<X, Y> {

        /* renamed from: a  reason: collision with root package name */
        public final X f51665a;

        /* renamed from: b  reason: collision with root package name */
        public final Y f51666b;

        public c(X x, Y y) {
            this.f51665a = x;
            this.f51666b = y;
        }
    }

    public static String e() {
        if (f51660b.size() > 0) {
            return j();
        }
        return g();
    }

    public static void f(PackageManager packageManager, String str, int i, int i2) {
        try {
            packageManager.getApplicationInfo(str, 0);
            k(i, i2);
        } catch (PackageManager.NameNotFoundException unused) {
            l(i, i2);
        }
    }

    public static String g() {
        String o = d.b.h0.r.d0.b.i().o("AD_SNIFF_RESULT_KEY", "");
        if (!TextUtils.isEmpty(o)) {
            ArrayList<Long> arrayList = new ArrayList<>();
            for (String str : o.split(",")) {
                arrayList.add(Long.valueOf(str));
            }
            f51660b = arrayList;
        } else {
            q(false);
        }
        return o;
    }

    public static void h() {
        File file = new File(BdBaseApplication.getInst().getApp().getApplicationContext().getFilesDir(), "sniff");
        if (file.exists()) {
            File file2 = new File(file, "sniff.json");
            if (file2.exists()) {
                String readFileData = FileUtils.readFileData(file2);
                if (TextUtils.isEmpty(readFileData)) {
                    return;
                }
                synchronized (d.class) {
                    try {
                        f51659a = new JSONObject(readFileData);
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                }
            }
        }
    }

    public static void i(String str) {
        h.d.j("").p(Schedulers.io()).D(new a(str));
    }

    public static String j() {
        ArrayList<Long> arrayList = f51660b;
        if (arrayList == null || arrayList.size() == 0) {
            return "";
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator<Long> it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(String.valueOf(it.next()));
        }
        return TextUtils.join(",", arrayList2);
    }

    public static void k(int i, int i2) {
        ArrayList<Long> arrayList = f51660b;
        if (i < arrayList.size()) {
            arrayList.set(i, Long.valueOf(arrayList.get(i).longValue() | (1 << i2)));
        }
    }

    public static void l(int i, int i2) {
        ArrayList<Long> arrayList = f51660b;
        if (i < arrayList.size()) {
            arrayList.set(i, Long.valueOf(arrayList.get(i).longValue() & ((1 << i2) ^ (-1))));
        }
    }

    public static void m(int i) {
        l(i, 0);
    }

    public static void n(int i) {
        k(i, 0);
    }

    public static void o(int i, JSONArray jSONArray) {
        if (i >= f51660b.size()) {
            Log.e("AD_SNIFF_RESULT_KEY", "group index should NOT greater or equal group size!!!");
            return;
        }
        PackageManager packageManager = BdBaseApplication.getInst().getApp().getApplicationContext().getPackageManager();
        m(i);
        int i2 = 0;
        while (i2 < jSONArray.length()) {
            String optString = jSONArray.optString(i2);
            i2++;
            c<Integer, Integer> cVar = new c<>(Integer.valueOf(i), Integer.valueOf(i2));
            ArrayList<c<Integer, Integer>> arrayList = f51661c.get(optString);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
            }
            arrayList.add(cVar);
            f51661c.put(optString, arrayList);
            f(packageManager, optString, i, i2);
        }
        n(i);
        d.b.h0.r.d0.b.i().w("AD_SNIFF_RESULT_KEY", j());
    }

    public static void p() {
        JSONArray optJSONArray;
        JSONObject jSONObject = f51659a;
        if (jSONObject == null || (optJSONArray = jSONObject.optJSONArray("data")) == null) {
            return;
        }
        int length = optJSONArray.length();
        int size = f51660b.size();
        ArrayList<Long> arrayList = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            if (i < size) {
                arrayList.add(f51660b.get(i));
            } else {
                arrayList.add(0L);
            }
        }
        f51660b = arrayList;
        for (int i2 = 0; i2 < length; i2++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
            if (optJSONObject == null) {
                return;
            }
            r(i2, optJSONObject.optString("name"), optJSONObject.optInt("interval"), optJSONObject.optJSONArray("list"), f51662d);
        }
        if (f51662d) {
            f51662d = false;
        }
    }

    public static void q(boolean z) {
        h.d.j("").p(Schedulers.io()).D(new b(z));
    }

    public static void r(int i, String str, int i2, JSONArray jSONArray, boolean z) {
        if (i < 0 || TextUtils.isEmpty(str) || i2 < 0 || jSONArray == null || jSONArray.length() == 0) {
            return;
        }
        long time = new Date().getTime();
        String str2 = "AD_SNIFF_RESULT_KEY_" + str + "_TS";
        long k = d.b.h0.r.d0.b.i().k(str2, 0L);
        long millis = TimeUnit.MINUTES.toMillis(i2);
        boolean z2 = true;
        boolean z3 = k == 0;
        z2 = (k <= 0 || time - k <= millis) ? false : false;
        if (z || z3 || z2) {
            d.b.h0.r.d0.b.i().v(str2, time);
            o(i, jSONArray);
        }
    }

    public static void s(Intent intent) {
        if (TextUtils.isEmpty(intent.getDataString())) {
            return;
        }
        String substring = intent.getDataString().length() > 8 ? intent.getDataString().substring(8) : "";
        String action = intent.getAction();
        ArrayList<c<Integer, Integer>> arrayList = f51661c.get(substring);
        if (arrayList == null || arrayList.size() == 0) {
            return;
        }
        Iterator<c<Integer, Integer>> it = arrayList.iterator();
        while (it.hasNext()) {
            c<Integer, Integer> next = it.next();
            if (next != null) {
                int intValue = next.f51665a.intValue();
                int intValue2 = next.f51666b.intValue();
                if (PackageChangedReceiver.ACTION_INSTALL.equals(action)) {
                    k(intValue, intValue2);
                } else {
                    l(intValue, intValue2);
                }
            }
        }
    }
}

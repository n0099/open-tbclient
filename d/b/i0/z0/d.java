package d.b.i0.z0;

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
    public static JSONObject f52420a;

    /* renamed from: b  reason: collision with root package name */
    public static ArrayList<Long> f52421b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    public static final Hashtable<String, ArrayList<c<Integer, Integer>>> f52422c = new Hashtable<>();

    /* renamed from: d  reason: collision with root package name */
    public static boolean f52423d = true;

    /* loaded from: classes3.dex */
    public static class a implements h.n.b<String> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f52424e;

        public a(String str) {
            this.f52424e = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        /* renamed from: a */
        public void call(String str) {
            String p = d.b.i0.r.d0.b.j().p("old_sniff_url", "");
            if (TextUtils.isEmpty(this.f52424e) || this.f52424e.equals(p)) {
                d.q(false);
                return;
            }
            File file = new File(BdBaseApplication.getInst().getApp().getApplicationContext().getFilesDir(), "sniff");
            if (!file.exists()) {
                file.mkdir();
            }
            if (d.b.i0.z0.b.c().a(new File(file, "sniff.json"), this.f52424e) > 0) {
                d.b.i0.r.d0.b.j().x("old_sniff_url", "");
            }
            d.q(true);
        }
    }

    /* loaded from: classes3.dex */
    public static class b implements h.n.b<String> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f52425e;

        public b(boolean z) {
            this.f52425e = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        /* renamed from: a */
        public void call(String str) {
            if (d.f52420a == null || this.f52425e) {
                d.h();
            }
            d.p();
        }
    }

    /* loaded from: classes3.dex */
    public static class c<X, Y> {

        /* renamed from: a  reason: collision with root package name */
        public final X f52426a;

        /* renamed from: b  reason: collision with root package name */
        public final Y f52427b;

        public c(X x, Y y) {
            this.f52426a = x;
            this.f52427b = y;
        }
    }

    public static String e() {
        if (f52421b.size() > 0) {
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
        String p = d.b.i0.r.d0.b.j().p("AD_SNIFF_RESULT_KEY", "");
        if (!TextUtils.isEmpty(p)) {
            ArrayList<Long> arrayList = new ArrayList<>();
            for (String str : p.split(",")) {
                arrayList.add(Long.valueOf(str));
            }
            f52421b = arrayList;
        } else {
            q(false);
        }
        return p;
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
                        f52420a = new JSONObject(readFileData);
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
        ArrayList<Long> arrayList = f52421b;
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
        ArrayList<Long> arrayList = f52421b;
        if (i < arrayList.size()) {
            arrayList.set(i, Long.valueOf(arrayList.get(i).longValue() | (1 << i2)));
        }
    }

    public static void l(int i, int i2) {
        ArrayList<Long> arrayList = f52421b;
        if (i < arrayList.size()) {
            arrayList.set(i, Long.valueOf(arrayList.get(i).longValue() & (~(1 << i2))));
        }
    }

    public static void m(int i) {
        l(i, 0);
    }

    public static void n(int i) {
        k(i, 0);
    }

    public static void o(int i, JSONArray jSONArray) {
        if (i >= f52421b.size()) {
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
            ArrayList<c<Integer, Integer>> arrayList = f52422c.get(optString);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
            }
            arrayList.add(cVar);
            f52422c.put(optString, arrayList);
            f(packageManager, optString, i, i2);
        }
        n(i);
        d.b.i0.r.d0.b.j().x("AD_SNIFF_RESULT_KEY", j());
    }

    public static void p() {
        JSONArray optJSONArray;
        JSONObject jSONObject = f52420a;
        if (jSONObject == null || (optJSONArray = jSONObject.optJSONArray("data")) == null) {
            return;
        }
        int length = optJSONArray.length();
        int size = f52421b.size();
        ArrayList<Long> arrayList = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            if (i < size) {
                arrayList.add(f52421b.get(i));
            } else {
                arrayList.add(0L);
            }
        }
        f52421b = arrayList;
        for (int i2 = 0; i2 < length; i2++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
            if (optJSONObject == null) {
                return;
            }
            r(i2, optJSONObject.optString("name"), optJSONObject.optInt("interval"), optJSONObject.optJSONArray("list"), f52423d);
        }
        if (f52423d) {
            f52423d = false;
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
        long l = d.b.i0.r.d0.b.j().l(str2, 0L);
        long millis = TimeUnit.MINUTES.toMillis(i2);
        boolean z2 = true;
        int i3 = (l > 0L ? 1 : (l == 0L ? 0 : -1));
        boolean z3 = i3 == 0;
        z2 = (i3 <= 0 || time - l <= millis) ? false : false;
        if (z || z3 || z2) {
            d.b.i0.r.d0.b.j().w(str2, time);
            o(i, jSONArray);
        }
    }

    public static void s(Intent intent) {
        if (TextUtils.isEmpty(intent.getDataString())) {
            return;
        }
        String substring = intent.getDataString().length() > 8 ? intent.getDataString().substring(8) : "";
        String action = intent.getAction();
        ArrayList<c<Integer, Integer>> arrayList = f52422c.get(substring);
        if (arrayList == null || arrayList.size() == 0) {
            return;
        }
        Iterator<c<Integer, Integer>> it = arrayList.iterator();
        while (it.hasNext()) {
            c<Integer, Integer> next = it.next();
            if (next != null) {
                int intValue = next.f52426a.intValue();
                int intValue2 = next.f52427b.intValue();
                if (PackageChangedReceiver.ACTION_INSTALL.equals(action)) {
                    k(intValue, intValue2);
                } else {
                    l(intValue, intValue2);
                }
            }
        }
    }
}

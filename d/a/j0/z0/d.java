package d.a.j0.z0;

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
    public static JSONObject f50917a;

    /* renamed from: b  reason: collision with root package name */
    public static ArrayList<Long> f50918b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    public static final Hashtable<String, ArrayList<c<Integer, Integer>>> f50919c = new Hashtable<>();

    /* renamed from: d  reason: collision with root package name */
    public static boolean f50920d = true;

    /* loaded from: classes3.dex */
    public static class a implements h.n.b<String> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f50921e;

        public a(String str) {
            this.f50921e = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        /* renamed from: a */
        public void call(String str) {
            String p = d.a.j0.r.d0.b.j().p("old_sniff_url", "");
            if (TextUtils.isEmpty(this.f50921e) || this.f50921e.equals(p)) {
                d.q(false);
                return;
            }
            File file = new File(BdBaseApplication.getInst().getApp().getApplicationContext().getFilesDir(), "sniff");
            if (!file.exists()) {
                file.mkdir();
            }
            if (d.a.j0.z0.b.c().a(new File(file, "sniff.json"), this.f50921e) > 0) {
                d.a.j0.r.d0.b.j().x("old_sniff_url", "");
            }
            d.q(true);
        }
    }

    /* loaded from: classes3.dex */
    public static class b implements h.n.b<String> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f50922e;

        public b(boolean z) {
            this.f50922e = z;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        /* renamed from: a */
        public void call(String str) {
            if (d.f50917a == null || this.f50922e) {
                d.h();
            }
            d.p();
        }
    }

    /* loaded from: classes3.dex */
    public static class c<X, Y> {

        /* renamed from: a  reason: collision with root package name */
        public final X f50923a;

        /* renamed from: b  reason: collision with root package name */
        public final Y f50924b;

        public c(X x, Y y) {
            this.f50923a = x;
            this.f50924b = y;
        }
    }

    public static String e() {
        if (f50918b.size() > 0) {
            return j();
        }
        return g();
    }

    public static void f(PackageManager packageManager, String str, int i2, int i3) {
        try {
            packageManager.getApplicationInfo(str, 0);
            k(i2, i3);
        } catch (PackageManager.NameNotFoundException unused) {
            l(i2, i3);
        }
    }

    public static String g() {
        String p = d.a.j0.r.d0.b.j().p("AD_SNIFF_RESULT_KEY", "");
        if (!TextUtils.isEmpty(p)) {
            ArrayList<Long> arrayList = new ArrayList<>();
            for (String str : p.split(",")) {
                arrayList.add(Long.valueOf(str));
            }
            f50918b = arrayList;
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
                        f50917a = new JSONObject(readFileData);
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                }
            }
        }
    }

    public static void i(String str) {
        h.d.i("").o(Schedulers.io()).B(new a(str));
    }

    public static String j() {
        ArrayList<Long> arrayList = f50918b;
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

    public static void k(int i2, int i3) {
        ArrayList<Long> arrayList = f50918b;
        if (i2 < arrayList.size()) {
            arrayList.set(i2, Long.valueOf(arrayList.get(i2).longValue() | (1 << i3)));
        }
    }

    public static void l(int i2, int i3) {
        ArrayList<Long> arrayList = f50918b;
        if (i2 < arrayList.size()) {
            arrayList.set(i2, Long.valueOf(arrayList.get(i2).longValue() & (~(1 << i3))));
        }
    }

    public static void m(int i2) {
        l(i2, 0);
    }

    public static void n(int i2) {
        k(i2, 0);
    }

    public static void o(int i2, JSONArray jSONArray) {
        if (i2 >= f50918b.size()) {
            Log.e("AD_SNIFF_RESULT_KEY", "group index should NOT greater or equal group size!!!");
            return;
        }
        PackageManager packageManager = BdBaseApplication.getInst().getApp().getApplicationContext().getPackageManager();
        m(i2);
        int i3 = 0;
        while (i3 < jSONArray.length()) {
            String optString = jSONArray.optString(i3);
            i3++;
            c<Integer, Integer> cVar = new c<>(Integer.valueOf(i2), Integer.valueOf(i3));
            ArrayList<c<Integer, Integer>> arrayList = f50919c.get(optString);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
            }
            arrayList.add(cVar);
            f50919c.put(optString, arrayList);
            f(packageManager, optString, i2, i3);
        }
        n(i2);
        d.a.j0.r.d0.b.j().x("AD_SNIFF_RESULT_KEY", j());
    }

    public static void p() {
        JSONArray optJSONArray;
        JSONObject jSONObject = f50917a;
        if (jSONObject == null || (optJSONArray = jSONObject.optJSONArray("data")) == null) {
            return;
        }
        int length = optJSONArray.length();
        int size = f50918b.size();
        ArrayList<Long> arrayList = new ArrayList<>();
        for (int i2 = 0; i2 < length; i2++) {
            if (i2 < size) {
                arrayList.add(f50918b.get(i2));
            } else {
                arrayList.add(0L);
            }
        }
        f50918b = arrayList;
        for (int i3 = 0; i3 < length; i3++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i3);
            if (optJSONObject == null) {
                return;
            }
            r(i3, optJSONObject.optString("name"), optJSONObject.optInt("interval"), optJSONObject.optJSONArray("list"), f50920d);
        }
        if (f50920d) {
            f50920d = false;
        }
    }

    public static void q(boolean z) {
        h.d.i("").o(Schedulers.io()).B(new b(z));
    }

    public static void r(int i2, String str, int i3, JSONArray jSONArray, boolean z) {
        if (i2 < 0 || TextUtils.isEmpty(str) || i3 < 0 || jSONArray == null || jSONArray.length() == 0) {
            return;
        }
        long time = new Date().getTime();
        String str2 = "AD_SNIFF_RESULT_KEY_" + str + "_TS";
        long l = d.a.j0.r.d0.b.j().l(str2, 0L);
        long millis = TimeUnit.MINUTES.toMillis(i3);
        boolean z2 = true;
        int i4 = (l > 0L ? 1 : (l == 0L ? 0 : -1));
        boolean z3 = i4 == 0;
        z2 = (i4 <= 0 || time - l <= millis) ? false : false;
        if (z || z3 || z2) {
            d.a.j0.r.d0.b.j().w(str2, time);
            o(i2, jSONArray);
        }
    }

    public static void s(Intent intent) {
        if (TextUtils.isEmpty(intent.getDataString())) {
            return;
        }
        String substring = intent.getDataString().length() > 8 ? intent.getDataString().substring(8) : "";
        String action = intent.getAction();
        ArrayList<c<Integer, Integer>> arrayList = f50919c.get(substring);
        if (arrayList == null || arrayList.size() == 0) {
            return;
        }
        Iterator<c<Integer, Integer>> it = arrayList.iterator();
        while (it.hasNext()) {
            c<Integer, Integer> next = it.next();
            if (next != null) {
                int intValue = next.f50923a.intValue();
                int intValue2 = next.f50924b.intValue();
                if (PackageChangedReceiver.ACTION_INSTALL.equals(action)) {
                    k(intValue, intValue2);
                } else {
                    l(intValue, intValue2);
                }
            }
        }
    }
}

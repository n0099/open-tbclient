package d.a.l0.a.i2.c;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import d.a.l0.a.a2.e;
import d.a.l0.a.k;
import d.a.l0.t.d;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f43024b = k.f43199a;

    /* renamed from: a  reason: collision with root package name */
    public final String f43025a;

    /* renamed from: d.a.l0.a.i2.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0719a implements Comparator<File> {
        public C0719a(a aVar) {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(File file, File file2) {
            long lastModified = file.lastModified();
            long lastModified2 = file2.lastModified();
            if (lastModified == lastModified2) {
                return 0;
            }
            return lastModified - lastModified2 > 0 ? 1 : -1;
        }
    }

    public a() {
        String str;
        try {
            str = AppRuntime.getAppContext().getFilesDir().getPath();
        } catch (Exception e2) {
            if (f43024b) {
                throw e2;
            }
            str = "";
        }
        if (!TextUtils.isEmpty(str)) {
            this.f43025a = str + File.separator + "aiapps_folder/stability";
            return;
        }
        this.f43025a = "";
    }

    public final void a(int i2) {
        File[] c2 = c();
        if (c2 == null || c2.length == 0) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        Arrays.sort(c2, new C0719a(this));
        ArrayList<File> arrayList = new ArrayList(c2.length);
        int i3 = 0;
        for (File file : c2) {
            if (i3 < i2) {
                if (file.lastModified() - currentTimeMillis > 172800000) {
                    arrayList.add(file);
                }
            } else {
                arrayList.add(file);
            }
            i3++;
        }
        for (File file2 : arrayList) {
            d.i(file2);
        }
    }

    public final File b(long j) {
        if (TextUtils.isEmpty(this.f43025a)) {
            return null;
        }
        String V = e.V() == null ? "" : e.V();
        return new File(this.f43025a + File.separator + V + "_" + j + "_swan_stability_traces.log");
    }

    public File[] c() {
        if (TextUtils.isEmpty(this.f43025a)) {
            return null;
        }
        try {
            return new File(this.f43025a).listFiles();
        } catch (Exception e2) {
            if (f43024b) {
                Log.e("SwanStabilityTraceCache", "TraceCache Exception:", e2);
            }
            return null;
        }
    }

    public File d(JSONArray jSONArray) {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            a(9);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("_app_id", e.V() == null ? "" : e.V());
            jSONObject.put("_date", d.a.l0.a.v2.k.b(new Date(currentTimeMillis), "yyyy-MM-dd HH:mm:ss"));
            jSONArray.put(jSONObject);
            File b2 = b(currentTimeMillis);
            if (b2 != null) {
                if (d.a.l0.a.b1.a.b(b2.getPath(), jSONArray.toString(), false)) {
                    return b2;
                }
                return null;
            }
            return null;
        } catch (Exception e2) {
            if (f43024b) {
                Log.e("SwanStabilityTraceCache", "TraceCache Exception:", e2);
            }
            return null;
        }
    }
}

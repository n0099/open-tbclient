package d.b.h0.a.y1.c;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import d.b.h0.a.i2.j;
import d.b.h0.a.k;
import d.b.h0.a.r1.e;
import d.b.h0.p.d;
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
    public static final boolean f47853b = k.f45772a;

    /* renamed from: a  reason: collision with root package name */
    public final String f47854a;

    /* renamed from: d.b.h0.a.y1.c.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0921a implements Comparator<File> {
        public C0921a(a aVar) {
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
            if (f47853b) {
                throw e2;
            }
            str = "";
        }
        if (!TextUtils.isEmpty(str)) {
            this.f47854a = str + File.separator + "aiapps_folder/stability";
            return;
        }
        this.f47854a = "";
    }

    public final void a(int i) {
        File[] c2 = c();
        if (c2 == null || c2.length == 0) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        Arrays.sort(c2, new C0921a(this));
        ArrayList<File> arrayList = new ArrayList(c2.length);
        int i2 = 0;
        for (File file : c2) {
            if (i2 < i) {
                if (file.lastModified() - currentTimeMillis > 172800000) {
                    arrayList.add(file);
                }
            } else {
                arrayList.add(file);
            }
            i2++;
        }
        for (File file2 : arrayList) {
            d.f(file2);
        }
    }

    public final File b(long j) {
        if (TextUtils.isEmpty(this.f47854a)) {
            return null;
        }
        String T = e.T() == null ? "" : e.T();
        return new File(this.f47854a + File.separator + T + "_" + j + "_swan_stability_traces.log");
    }

    public File[] c() {
        if (TextUtils.isEmpty(this.f47854a)) {
            return null;
        }
        try {
            return new File(this.f47854a).listFiles();
        } catch (Exception e2) {
            if (f47853b) {
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
            jSONObject.put("_app_id", e.T() == null ? "" : e.T());
            jSONObject.put("_date", j.b(new Date(currentTimeMillis), "yyyy-MM-dd HH:mm:ss"));
            jSONArray.put(jSONObject);
            File b2 = b(currentTimeMillis);
            if (b2 != null) {
                if (d.b.h0.a.v0.a.b(b2.getPath(), jSONArray.toString(), false)) {
                    return b2;
                }
                return null;
            }
            return null;
        } catch (Exception e2) {
            if (f47853b) {
                Log.e("SwanStabilityTraceCache", "TraceCache Exception:", e2);
            }
            return null;
        }
    }
}

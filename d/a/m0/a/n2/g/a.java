package d.a.m0.a.n2.g;

import android.text.TextUtils;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import d.a.m0.a.a2.d;
import d.a.m0.a.j2.c;
import d.a.m0.a.k;
import d.a.m0.a.v2.o0;
import d.a.m0.a.v2.q;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.Stack;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f47595a = k.f46983a;

    /* renamed from: b  reason: collision with root package name */
    public static int f47596b = -1;

    /* renamed from: d.a.m0.a.n2.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class RunnableC0833a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f47597e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f47598f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f47599g;

        public RunnableC0833a(String str, String str2, String str3) {
            this.f47597e = str;
            this.f47598f = str2;
            this.f47599g = str3;
        }

        @Override // java.lang.Runnable
        public void run() {
            JSONObject jSONObject = new JSONObject();
            File file = new File(this.f47597e);
            try {
                jSONObject.put("file_name", this.f47598f);
                jSONObject.put("file_tree", a.d(file));
                jSONObject.put("file_stack_info", this.f47599g);
                jSONObject.put("file_free_space", file.getFreeSpace());
                jSONObject.put("file_total_space", file.getTotalSpace());
            } catch (JSONException e2) {
                if (a.f47595a) {
                    e2.printStackTrace();
                }
            }
            c.b bVar = new c.b(10018);
            bVar.j(this.f47598f);
            bVar.h(d.g().getAppId());
            bVar.i(jSONObject.toString());
            bVar.m();
        }
    }

    /* loaded from: classes3.dex */
    public static class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f47600e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f47601f;

        public b(String str, String str2) {
            this.f47600e = str;
            this.f47601f = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(PrefetchEvent.EVENT_KEY_APP_PATH, this.f47600e);
                jSONObject.put("pagePath", this.f47601f);
            } catch (JSONException e2) {
                if (a.f47595a) {
                    e2.printStackTrace();
                }
            }
            c.b bVar = new c.b(10018);
            bVar.i(jSONObject.toString());
            bVar.h(d.g().getAppId());
            bVar.m();
        }
    }

    public static void b(String str, String str2) {
        if (c() <= 0) {
            return;
        }
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            String f2 = o0.f(str2);
            if (new File(str, f2 + ".swan.js").exists()) {
                return;
            }
            f(str, f2);
            return;
        }
        e(str, str2);
    }

    public static int c() {
        if (f47596b < 0) {
            d.a.m0.a.c1.a.Z().getSwitch("swan_app_file_analysis_switch", 0);
            f47596b = 0;
        }
        d.a.m0.a.e0.d.g("FileNotFoundReporter", "getSwitch:" + f47596b);
        return f47596b;
    }

    public static String d(File file) {
        File[] listFiles;
        if (file != null && file.exists() && file.isDirectory()) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            Stack stack = new Stack();
            stack.push(file);
            while (!stack.isEmpty()) {
                File file2 = (File) stack.pop();
                if (file2 != null) {
                    if (file2.isFile()) {
                        arrayList.add(file2);
                    } else if (file2.isDirectory() && (listFiles = file2.listFiles()) != null && listFiles.length > 0) {
                        Collections.addAll(stack, listFiles);
                    }
                }
            }
            if (arrayList.size() > 0) {
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    File file3 = (File) arrayList.get(i2);
                    arrayList2.add(file3.getAbsolutePath() + "|" + new Date(file3.lastModified()));
                }
            }
            return Arrays.toString(arrayList2.toArray());
        }
        return "";
    }

    public static void e(String str, String str2) {
        q.e().execute(new b(str, str2));
    }

    public static void f(String str, String str2) {
        q.e().execute(new RunnableC0833a(str, str2, Arrays.toString(new Exception().getStackTrace())));
    }
}

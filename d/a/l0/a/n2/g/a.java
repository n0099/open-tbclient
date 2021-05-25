package d.a.l0.a.n2.g;

import android.text.TextUtils;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.tbadk.core.util.FieldBuilder;
import d.a.l0.a.a2.d;
import d.a.l0.a.j2.c;
import d.a.l0.a.k;
import d.a.l0.a.v2.o0;
import d.a.l0.a.v2.q;
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
    public static final boolean f43811a = k.f43199a;

    /* renamed from: b  reason: collision with root package name */
    public static int f43812b = -1;

    /* renamed from: d.a.l0.a.n2.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class RunnableC0774a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f43813e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f43814f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f43815g;

        public RunnableC0774a(String str, String str2, String str3) {
            this.f43813e = str;
            this.f43814f = str2;
            this.f43815g = str3;
        }

        @Override // java.lang.Runnable
        public void run() {
            JSONObject jSONObject = new JSONObject();
            File file = new File(this.f43813e);
            try {
                jSONObject.put("file_name", this.f43814f);
                jSONObject.put("file_tree", a.d(file));
                jSONObject.put("file_stack_info", this.f43815g);
                jSONObject.put("file_free_space", file.getFreeSpace());
                jSONObject.put("file_total_space", file.getTotalSpace());
            } catch (JSONException e2) {
                if (a.f43811a) {
                    e2.printStackTrace();
                }
            }
            c.b bVar = new c.b(10018);
            bVar.j(this.f43814f);
            bVar.h(d.g().getAppId());
            bVar.i(jSONObject.toString());
            bVar.m();
        }
    }

    /* loaded from: classes3.dex */
    public static class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f43816e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f43817f;

        public b(String str, String str2) {
            this.f43816e = str;
            this.f43817f = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(PrefetchEvent.EVENT_KEY_APP_PATH, this.f43816e);
                jSONObject.put("pagePath", this.f43817f);
            } catch (JSONException e2) {
                if (a.f43811a) {
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
        if (f43812b < 0) {
            d.a.l0.a.c1.a.Z().getSwitch("swan_app_file_analysis_switch", 0);
            f43812b = 0;
        }
        d.a.l0.a.e0.d.g("FileNotFoundReporter", "getSwitch:" + f43812b);
        return f43812b;
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
                    arrayList2.add(file3.getAbsolutePath() + FieldBuilder.SE + new Date(file3.lastModified()));
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
        q.e().execute(new RunnableC0774a(str, str2, Arrays.toString(new Exception().getStackTrace())));
    }
}

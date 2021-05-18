package d.a.i0.a.m2;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import d.a.i0.a.g1.f;
import d.a.i0.a.k;
import d.a.i0.a.k2.g.h;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: d.a.i0.a.m2.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0733a implements Comparator<c> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(c cVar, c cVar2) {
            if (cVar == null) {
                return -1;
            }
            if (cVar2 == null) {
                return 1;
            }
            return String.valueOf(cVar.f43320a).compareTo(String.valueOf(cVar2.f43320a));
        }
    }

    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static final a f43319a = new a(null);
    }

    /* loaded from: classes3.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public long f43320a;

        /* renamed from: b  reason: collision with root package name */
        public long f43321b;

        public c(long j, long j2) {
            this.f43320a = j;
            this.f43321b = j2;
        }

        public String a() {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("time", this.f43320a);
                jSONObject.put("version", this.f43321b);
                return jSONObject.toString();
            } catch (JSONException e2) {
                if (k.f43025a) {
                    e2.printStackTrace();
                }
                return null;
            }
        }

        @NonNull
        public String toString() {
            String str;
            try {
                str = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date(this.f43320a));
            } catch (Exception e2) {
                if (k.f43025a) {
                    e2.printStackTrace();
                }
                str = null;
            }
            return str + " ---> " + this.f43321b;
        }
    }

    public /* synthetic */ a(C0733a c0733a) {
        this();
    }

    public static String b(int i2) {
        return i2 == 1 ? "aigames_core_ver_list_key" : "aiapps_core_ver_list_key";
    }

    public static a c() {
        return b.f43319a;
    }

    public static String d(int i2) {
        return i2 == 1 ? "installed_game_swan_js_md5" : "installed_swan_js_md5";
    }

    public static void h(List<c> list) {
        Collections.sort(list, new C0733a());
    }

    public void a(long j, int i2) {
        List<c> f2 = f(i2);
        boolean z = false;
        if (f2.size() >= 10) {
            f2.remove(0);
        }
        Iterator<c> it = f2.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            c next = it.next();
            if (next != null && next.f43321b == j) {
                z = true;
                break;
            }
        }
        if (z) {
            return;
        }
        f2.add(new c(Calendar.getInstance().getTimeInMillis(), j));
        HashSet hashSet = new HashSet();
        for (c cVar : f2) {
            if (cVar != null) {
                hashSet.add(cVar.a());
            }
        }
        h.a().putStringSet(b(i2), hashSet);
    }

    public String e(int i2) {
        StringBuilder sb = new StringBuilder();
        String string = h.a().getString(d(i2), "");
        if (!TextUtils.isEmpty(string)) {
            sb.append("md5: ");
            sb.append(string);
            sb.append("\n");
            sb.append("\n");
        }
        List<c> f2 = f(i2);
        int size = f2.size();
        boolean z = false;
        for (int i3 = 0; i3 < size; i3++) {
            c cVar = f2.get(i3);
            if (cVar != null) {
                sb.append(cVar.toString());
                if (i3 < size - 1) {
                    sb.append("\n");
                }
                z = true;
            }
        }
        if (!z) {
            sb.append(new c(System.currentTimeMillis(), d.a.i0.a.m2.e.a.f(i2)).toString());
        } else {
            SwanCoreVersion N = f.V().N();
            c cVar2 = f2.get(size - 1);
            if (cVar2 != null && N != null && N.swanCoreVersionCode > cVar2.f43321b) {
                sb.append("\n");
                sb.append(new c(System.currentTimeMillis(), N.swanCoreVersionCode).toString());
            }
        }
        return sb.toString();
    }

    public final List<c> f(int i2) {
        ArrayList arrayList = new ArrayList();
        Set<String> stringSet = h.a().getStringSet(b(i2), null);
        if (stringSet != null && stringSet.size() != 0) {
            for (String str : stringSet) {
                c g2 = g(str);
                if (g2 != null) {
                    arrayList.add(g2);
                }
            }
            h(arrayList);
        }
        return arrayList;
    }

    public final c g(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            return new c(jSONObject.optLong("time"), jSONObject.optLong("version"));
        } catch (JSONException e2) {
            if (k.f43025a) {
                e2.printStackTrace();
                return null;
            }
            return null;
        }
    }

    public a() {
    }
}

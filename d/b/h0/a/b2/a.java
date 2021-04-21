package d.b.h0.a.b2;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import d.b.h0.a.a2.g.h;
import d.b.h0.a.k;
import d.b.h0.a.z0.f;
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

    /* renamed from: d.b.h0.a.b2.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0645a implements Comparator<c> {
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
            return String.valueOf(cVar.f44287a).compareTo(String.valueOf(cVar2.f44287a));
        }
    }

    /* loaded from: classes3.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static final a f44286a = new a(null);
    }

    /* loaded from: classes3.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public long f44287a;

        /* renamed from: b  reason: collision with root package name */
        public long f44288b;

        public c(long j, long j2) {
            this.f44287a = j;
            this.f44288b = j2;
        }

        public String a() {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("time", this.f44287a);
                jSONObject.put("version", this.f44288b);
                return jSONObject.toString();
            } catch (JSONException e2) {
                if (k.f45772a) {
                    e2.printStackTrace();
                }
                return null;
            }
        }

        @NonNull
        public String toString() {
            String str;
            String str2 = null;
            try {
                str = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(new Date(this.f44287a));
            } catch (Exception e2) {
                e = e2;
                str = null;
            }
            try {
                str2 = d.b.h0.a.b2.b.q(this.f44288b);
            } catch (Exception e3) {
                e = e3;
                if (k.f45772a) {
                    e.printStackTrace();
                }
                return str + " ---> " + str2;
            }
            return str + " ---> " + str2;
        }
    }

    public /* synthetic */ a(C0645a c0645a) {
        this();
    }

    public static String b(int i) {
        return i == 1 ? "aigames_core_ver_list_key" : "aiapps_core_ver_list_key";
    }

    public static a c() {
        return b.f44286a;
    }

    public static String d(int i) {
        return i == 1 ? "installed_game_swan_js_md5" : "installed_swan_js_md5";
    }

    public static void h(List<c> list) {
        Collections.sort(list, new C0645a());
    }

    public void a(long j, int i) {
        List<c> f2 = f(i);
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
            if (next != null && next.f44288b == j) {
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
        h.a().putStringSet(b(i), hashSet);
    }

    public String e(int i) {
        StringBuilder sb = new StringBuilder();
        String string = h.a().getString(d(i), "");
        if (!TextUtils.isEmpty(string)) {
            sb.append("md5: ");
            sb.append(string);
            sb.append("\n");
            sb.append("\n");
        }
        List<c> f2 = f(i);
        int size = f2.size();
        boolean z = false;
        for (int i2 = 0; i2 < size; i2++) {
            c cVar = f2.get(i2);
            if (cVar != null) {
                sb.append(cVar.toString());
                if (i2 < size - 1) {
                    sb.append("\n");
                }
                z = true;
            }
        }
        if (!z) {
            sb.append(new c(System.currentTimeMillis(), d.b.h0.a.b2.e.a.e(i)).toString());
        } else {
            SwanCoreVersion L = f.V().L();
            c cVar2 = f2.get(size - 1);
            if (cVar2 != null && L != null && L.swanCoreVersion > cVar2.f44288b) {
                sb.append("\n");
                sb.append(new c(System.currentTimeMillis(), L.swanCoreVersion).toString());
            }
        }
        return sb.toString();
    }

    public final List<c> f(int i) {
        ArrayList arrayList = new ArrayList();
        Set<String> stringSet = h.a().getStringSet(b(i), null);
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
            if (k.f45772a) {
                e2.printStackTrace();
                return null;
            }
            return null;
        }
    }

    public a() {
    }
}

package d.a.d0.b.g;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.URLUtil;
import androidx.annotation.Nullable;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import d.a.d0.a.c.e;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f43432a = d.a.d0.a.a.a.f43372a;

    /* renamed from: b  reason: collision with root package name */
    public static d f43433b;

    /* renamed from: c  reason: collision with root package name */
    public static List<h> f43434c;

    /* loaded from: classes2.dex */
    public static class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ File f43435e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f43436f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f43437g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ File f43438h;

        /* renamed from: d.a.d0.b.g.f$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C0580a implements e.b {
            public C0580a() {
            }

            @Override // d.a.d0.a.c.e.b
            public void a() {
                if (!TextUtils.isEmpty(a.this.f43437g) && !TextUtils.equals(d.a.d0.a.c.f.b(a.this.f43435e), a.this.f43437g)) {
                    if (f.f43432a) {
                        Log.d("SourceManager", "md5 check fail  url:" + a.this.f43436f);
                    }
                    a.this.f43435e.delete();
                    return;
                }
                a aVar = a.this;
                f.v(aVar.f43435e, aVar.f43438h);
            }
        }

        public a(File file, String str, String str2, File file2) {
            this.f43435e = file;
            this.f43436f = str;
            this.f43437g = str2;
            this.f43438h = file2;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                d.a.d0.a.c.e.b(this.f43435e, this.f43436f, new C0580a());
            } catch (Exception e2) {
                if (d.a.d0.a.b.a.f43374a.get().s()) {
                    Log.e("SourceManager", e2.toString());
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ h f43440e;

        public b(h hVar) {
            this.f43440e = hVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            f.x(this.f43440e);
        }
    }

    /* loaded from: classes2.dex */
    public static class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ List f43441e;

        public c(List list) {
            this.f43441e = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (f.f43432a) {
                Log.d("SourceManager", "SourceManager scheduleDownloadSplashSource");
            }
            List list = this.f43441e;
            if (list == null || list.size() == 0) {
                return;
            }
            ArrayList arrayList = new ArrayList(3);
            Iterator it = this.f43441e.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                h hVar = (h) it.next();
                if (hVar == null) {
                    if (f.f43432a) {
                        Log.d("SourceManager", "SourceManager scheduleDownloadSplashSource() dataItem == null");
                    }
                } else if (d.a.d0.a.c.h.a(hVar.v)) {
                    f.h(hVar);
                } else {
                    arrayList.add(hVar);
                }
            }
            if (arrayList.size() > 0) {
                if (f.f43433b == null) {
                    d unused = f.f43433b = new d(arrayList, null);
                    d.a.d0.a.b.a.f43374a.get().o().registerReceiver(f.f43433b, f.f43433b.getIntentFilter());
                    return;
                }
                f.f43433b.setNeedDownloadList(arrayList);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class d extends BroadcastReceiver {
        public List<h> mNeedDownloadList;

        public /* synthetic */ d(List list, a aVar) {
            this(list);
        }

        public IntentFilter getIntentFilter() {
            return new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
        }

        public List<h> getNeedDownloadList() {
            return this.mNeedDownloadList;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Log.d("SourceManager", "onReceive: receiver");
            if (TextUtils.equals(intent.getAction(), "android.net.conn.CONNECTIVITY_CHANGE")) {
                ArrayList arrayList = new ArrayList();
                for (h hVar : this.mNeedDownloadList) {
                    if (d.a.d0.a.c.h.a(hVar.v)) {
                        Log.d("SourceManager", "onReceive: " + hVar);
                        f.h(hVar);
                    } else {
                        arrayList.add(hVar);
                    }
                }
                this.mNeedDownloadList = arrayList;
            }
        }

        public void setNeedDownloadList(List<h> list) {
            this.mNeedDownloadList = list;
        }

        public d(List<h> list) {
            this.mNeedDownloadList = list;
        }
    }

    public static int e(h hVar) {
        return f(hVar, false);
    }

    public static int f(h hVar, boolean z) {
        int i2 = 0;
        if (hVar.x) {
            return 0;
        }
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        long a2 = j.a();
        i2 = (currentTimeMillis < hVar.r || currentTimeMillis > hVar.s) ? 2 : 2;
        if (z) {
            int i3 = hVar.w;
            int i4 = hVar.u;
            if (i3 >= i4 || i4 == 0) {
                i2 |= 8;
            }
        }
        if (currentTimeMillis - a2 < hVar.t * 60000) {
            i2 |= 16;
        }
        if (hVar.f43442a == 0) {
            i2 |= 32;
        }
        File o = o(hVar.f43448g);
        if (o == null || !o.exists()) {
            i2 |= 4;
        }
        if (f43432a) {
            Log.d("SourceManager", "物料不满足展示条件 reason ：" + i2);
        }
        return i2;
    }

    public static void g(@Nullable List<h> list) {
        if (list != null && !list.isEmpty()) {
            File[] listFiles = m().listFiles();
            if (listFiles == null || listFiles.length == 0) {
                return;
            }
            ArrayList arrayList = new ArrayList(list.size());
            for (h hVar : list) {
                if (hVar != null) {
                    arrayList.add(k(hVar.f43448g));
                    arrayList.add(k(hVar.y));
                }
            }
            for (File file : listFiles) {
                if (!arrayList.contains(file.getName())) {
                    file.delete();
                }
            }
            return;
        }
        d.a.d0.a.c.e.a(m());
    }

    public static void h(h hVar) {
        if (URLUtil.isNetworkUrl(hVar.f43448g)) {
            i(hVar.f43448g, hVar.j);
            if (TextUtils.isEmpty(hVar.y)) {
                return;
            }
            i(hVar.y, "");
        }
    }

    public static void i(String str, String str2) {
        File o = o(str);
        if (o == null || !o.exists()) {
            File r = r(d.a.d0.a.c.f.c(str));
            if (r.exists()) {
                r.delete();
            }
            d.a.d0.d.a.a.b(new a(r, str, str2, o), "download splash resource");
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0021, code lost:
        if (d.a.d0.b.g.f.f43432a == false) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0023, code lost:
        r4.printStackTrace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0040, code lost:
        if (d.a.d0.b.g.f.f43432a == false) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String j(File file) {
        StringBuilder sb = new StringBuilder();
        BufferedReader bufferedReader = null;
        try {
            try {
                BufferedReader bufferedReader2 = new BufferedReader(new FileReader(file));
                while (true) {
                    try {
                        String readLine = bufferedReader2.readLine();
                        if (readLine != null) {
                            sb.append(readLine);
                        } else {
                            try {
                                break;
                            } catch (Exception e2) {
                                e = e2;
                            }
                        }
                    } catch (Exception e3) {
                        e = e3;
                        bufferedReader = bufferedReader2;
                        if (f43432a) {
                            e.printStackTrace();
                        }
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (Exception e4) {
                                e = e4;
                            }
                        }
                        return sb.toString();
                    } catch (Throwable th) {
                        th = th;
                        bufferedReader = bufferedReader2;
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (Exception e5) {
                                if (f43432a) {
                                    e5.printStackTrace();
                                }
                            }
                        }
                        throw th;
                    }
                }
                bufferedReader2.close();
            } catch (Exception e6) {
                e = e6;
            }
            return sb.toString();
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static String k(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(d.a.d0.a.c.f.c(str));
        int lastIndexOf = str.lastIndexOf(".");
        int lastIndexOf2 = str.lastIndexOf("/");
        if (lastIndexOf < lastIndexOf2 || lastIndexOf == -1 || lastIndexOf2 == -1) {
            return null;
        }
        sb.append(str.substring(lastIndexOf));
        return sb.toString();
    }

    @Nullable
    public static h l() {
        List<h> t = t(true);
        if (t == null || t.size() <= 0) {
            return null;
        }
        return t.get(0);
    }

    public static File m() {
        File file = new File(d.a.d0.a.b.b.a().getFilesDir(), "splash");
        file.mkdirs();
        return file;
    }

    public static File n() {
        return new File(m(), "splash.dat");
    }

    public static File o(String str) {
        String k = k(str);
        if (TextUtils.isEmpty(k)) {
            return null;
        }
        return new File(m(), k);
    }

    public static List<h> p() {
        String j;
        if (f43434c != null) {
            if (f43432a) {
                Log.d("SourceManager", "from cache splashDataItemList:" + f43434c.size());
            }
            return f43434c;
        }
        f43434c = Collections.synchronizedList(new ArrayList());
        File n = n();
        if (n.exists() && (j = j(n)) != null) {
            if (f43432a) {
                Log.d("SourceManager", "from local content:" + j);
            }
            try {
                JSONArray jSONArray = new JSONArray(j);
                if (f43432a) {
                    Log.d("SourceManager", "JSONArray" + jSONArray.length());
                }
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    f43434c.add(h.b(jSONArray.optJSONObject(i2)));
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            if (f43432a) {
                Log.d("SourceManager", "from local splashDataItemList:" + f43434c.size());
            }
            return f43434c;
        }
        return null;
    }

    public static HashMap<String, h> q() {
        HashMap<String, h> hashMap = new HashMap<>();
        File n = n();
        if (n.exists()) {
            try {
                JSONArray jSONArray = new JSONArray(j(n));
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    h b2 = h.b((JSONObject) jSONArray.get(i2));
                    hashMap.put(b2.f43443b, b2);
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return hashMap;
        }
        return null;
    }

    public static File r(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);
        stringBuffer.append(".tmp");
        return new File(m(), stringBuffer.toString());
    }

    public static List<h> s() {
        return t(false);
    }

    public static List<h> t(boolean z) {
        List<h> p = p();
        if (p != null && p.size() != 0) {
            ArrayList arrayList = new ArrayList();
            JSONObject jSONObject = new JSONObject();
            int i2 = 0;
            for (int i3 = 0; i3 < p.size(); i3++) {
                h hVar = p.get(i3);
                int f2 = f(hVar, z);
                if (f2 == 0) {
                    arrayList.add(hVar);
                } else {
                    i2 |= f2;
                    try {
                        jSONObject.put(hVar.f43444c, f2);
                    } catch (JSONException e2) {
                        if (f43432a) {
                            e2.printStackTrace();
                        }
                    }
                }
            }
            if (arrayList.size() == 0) {
                d.a.d0.b.g.b.g(i2, jSONObject.toString());
                return null;
            }
            return arrayList;
        }
        d.a.d0.b.g.b.f(1);
        return null;
    }

    public static boolean u(List<h> list, File file) {
        StringBuffer stringBuffer;
        int i2;
        FileWriter fileWriter;
        if (f43432a) {
            Log.d("SourceManager", "persistListToFile size:" + list.size());
        }
        int i3 = 0;
        if (list.size() <= 0) {
            return false;
        }
        FileWriter fileWriter2 = null;
        try {
            try {
                h[] hVarArr = (h[]) list.toArray(new h[list.size() - 1]);
                stringBuffer = new StringBuffer();
                stringBuffer.append(PreferencesUtil.LEFT_MOUNT);
                int length = hVarArr.length;
                while (true) {
                    i2 = length - 1;
                    if (i3 >= i2) {
                        break;
                    }
                    stringBuffer.append(hVarArr[i3].i());
                    stringBuffer.append(",");
                    i3++;
                }
                stringBuffer.append(hVarArr[i2].i());
                stringBuffer.append(PreferencesUtil.RIGHT_MOUNT);
                if (f43432a) {
                    Log.d("SourceManager", "persistListToFile:" + stringBuffer.toString());
                }
                fileWriter = new FileWriter(file);
            } catch (IOException e2) {
                e = e2;
            }
        } catch (Throwable th) {
            th = th;
        }
        try {
            fileWriter.write(stringBuffer.toString());
            try {
                fileWriter.close();
            } catch (Exception e3) {
                if (f43432a) {
                    Log.d("SourceManager", "persistListToFile() writer.close() Exception e: ");
                    e3.printStackTrace();
                }
            }
            return true;
        } catch (IOException e4) {
            fileWriter2 = fileWriter;
            e = e4;
            if (f43432a) {
                Log.d("SourceManager", "persistListToFile() Exception e: ");
                e.printStackTrace();
            }
            if (fileWriter2 != null) {
                try {
                    fileWriter2.close();
                } catch (Exception e5) {
                    if (f43432a) {
                        Log.d("SourceManager", "persistListToFile() writer.close() Exception e: ");
                        e5.printStackTrace();
                    }
                }
            }
            return true;
        } catch (Throwable th2) {
            fileWriter2 = fileWriter;
            th = th2;
            if (fileWriter2 != null) {
                try {
                    fileWriter2.close();
                } catch (Exception e6) {
                    if (f43432a) {
                        Log.d("SourceManager", "persistListToFile() writer.close() Exception e: ");
                        e6.printStackTrace();
                    }
                }
            }
            throw th;
        }
    }

    public static boolean v(File file, File file2) {
        if (file == null || file2 == null) {
            return false;
        }
        return file.renameTo(file2);
    }

    public static void w(List<h> list) {
        d.a.d0.d.a.a.b(new c(list), "ScheduleDownloadSplashSourceThread");
    }

    public static void x(h hVar) {
        ArrayList arrayList = new ArrayList();
        File n = n();
        List<h> p = p();
        if (p == null || p.size() == 0) {
            return;
        }
        if (f43432a) {
            Log.d("SourceManager", "updateSplashDataItem--->getSplashDataItemList:" + p.size());
        }
        for (int i2 = 0; i2 < p.size(); i2++) {
            h hVar2 = p.get(i2);
            if (TextUtils.equals(hVar.f43443b, hVar2.f43443b)) {
                h.j(hVar2, hVar);
                arrayList.add(hVar2);
            } else {
                arrayList.add(hVar2);
            }
        }
        u(arrayList, n);
    }

    public static void y(h hVar) {
        if (hVar.u >= 1) {
            int i2 = hVar.w;
            if (i2 < Integer.MAX_VALUE) {
                hVar.w = i2 + 1;
            }
            d.a.d0.d.a.a.b(new b(hVar), "updateSplashDataItemRate");
        }
    }

    public static void z(List<h> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        f43434c = Collections.synchronizedList(list);
        u(list, n());
    }
}

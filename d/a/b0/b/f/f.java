package d.a.b0.b.f;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.URLUtil;
import androidx.annotation.Nullable;
import d.a.b0.a.c.e;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f38580a = d.a.b0.a.a.a.f38531a;

    /* renamed from: b  reason: collision with root package name */
    public static d f38581b;

    /* loaded from: classes2.dex */
    public static class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ File f38582e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f38583f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f38584g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ File f38585h;

        /* renamed from: d.a.b0.b.f.f$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class C0492a implements e.b {
            public C0492a() {
            }

            @Override // d.a.b0.a.c.e.b
            public void a() {
                if (!TextUtils.isEmpty(a.this.f38584g) && !TextUtils.equals(d.a.b0.a.c.f.b(a.this.f38582e), a.this.f38584g)) {
                    if (f.f38580a) {
                        Log.d("SourceManager", "md5 check fail  url:" + a.this.f38583f);
                    }
                    a.this.f38582e.delete();
                    return;
                }
                a aVar = a.this;
                f.r(aVar.f38582e, aVar.f38585h);
            }
        }

        public a(File file, String str, String str2, File file2) {
            this.f38582e = file;
            this.f38583f = str;
            this.f38584g = str2;
            this.f38585h = file2;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                d.a.b0.a.c.e.b(this.f38582e, this.f38583f, new C0492a());
            } catch (Exception e2) {
                if (d.a.b0.a.b.a.f38533a.get().s()) {
                    Log.e("SourceManager", e2.toString());
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ g f38587e;

        public b(g gVar) {
            this.f38587e = gVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            f.t(this.f38587e);
        }
    }

    /* loaded from: classes2.dex */
    public static class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ List f38588e;

        public c(List list) {
            this.f38588e = list;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (f.f38580a) {
                Log.d("SourceManager", "SourceManager scheduleDownloadSplashSource");
            }
            List list = this.f38588e;
            if (list == null || list.size() == 0) {
                return;
            }
            ArrayList arrayList = new ArrayList(3);
            Iterator it = this.f38588e.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                g gVar = (g) it.next();
                if (gVar == null) {
                    if (f.f38580a) {
                        Log.d("SourceManager", "SourceManager scheduleDownloadSplashSource() dataItem == null");
                    }
                } else if (d.a.b0.a.c.h.a(gVar.v)) {
                    f.g(gVar);
                } else {
                    arrayList.add(gVar);
                }
            }
            if (arrayList.size() > 0) {
                if (f.f38581b == null) {
                    d unused = f.f38581b = new d(arrayList, null);
                    d.a.b0.a.b.a.f38533a.get().o().registerReceiver(f.f38581b, f.f38581b.getIntentFilter());
                    return;
                }
                f.f38581b.setNeedDownloadList(arrayList);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class d extends BroadcastReceiver {
        public List<g> mNeedDownloadList;

        public /* synthetic */ d(List list, a aVar) {
            this(list);
        }

        public IntentFilter getIntentFilter() {
            return new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
        }

        public List<g> getNeedDownloadList() {
            return this.mNeedDownloadList;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Log.d("SourceManager", "onReceive: receiver");
            if (TextUtils.equals(intent.getAction(), "android.net.conn.CONNECTIVITY_CHANGE")) {
                ArrayList arrayList = new ArrayList();
                for (g gVar : this.mNeedDownloadList) {
                    if (d.a.b0.a.c.h.a(gVar.v)) {
                        Log.d("SourceManager", "onReceive: " + gVar);
                        f.g(gVar);
                    } else {
                        arrayList.add(gVar);
                    }
                }
                this.mNeedDownloadList = arrayList;
            }
        }

        public void setNeedDownloadList(List<g> list) {
            this.mNeedDownloadList = list;
        }

        public d(List<g> list) {
            this.mNeedDownloadList = list;
        }
    }

    public static int e(g gVar) {
        int i2 = 0;
        if (gVar.x) {
            return 0;
        }
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        long a2 = i.a();
        i2 = (currentTimeMillis < gVar.r || currentTimeMillis > gVar.s) ? 2 : 2;
        int i3 = gVar.w;
        int i4 = gVar.u;
        if (i3 >= i4 && i4 >= 1) {
            i2 |= 8;
        }
        if (currentTimeMillis - a2 < gVar.t * 60000) {
            i2 |= 16;
        }
        if (gVar.f38589a == 0) {
            i2 |= 32;
            if (f38580a) {
                throw new IllegalStateException("空订单有ukey了 ～～～～～");
            }
        }
        File m = m(gVar.f38595g);
        if (m == null || !m.exists()) {
            i2 |= 4;
        }
        if (f38580a) {
            Log.d("SourceManager", "物料不满足展示条件 reason ：" + i2);
        }
        return i2;
    }

    public static void f(@Nullable List<g> list) {
        if (list != null && !list.isEmpty()) {
            File[] listFiles = k().listFiles();
            if (listFiles == null || listFiles.length == 0) {
                return;
            }
            ArrayList arrayList = new ArrayList(list.size());
            for (g gVar : list) {
                if (gVar != null) {
                    arrayList.add(j(gVar.f38595g));
                    arrayList.add(j(gVar.y));
                }
            }
            for (File file : listFiles) {
                if (!arrayList.contains(file.getName())) {
                    file.delete();
                }
            }
            return;
        }
        d.a.b0.a.c.e.a(k());
    }

    public static void g(g gVar) {
        if (URLUtil.isNetworkUrl(gVar.f38595g)) {
            h(gVar.f38595g, gVar.j);
            if (TextUtils.isEmpty(gVar.y)) {
                return;
            }
            h(gVar.y, "");
        }
    }

    public static void h(String str, String str2) {
        File m = m(str);
        if (m == null || !m.exists()) {
            File p = p(d.a.b0.a.c.f.c(str));
            if (p.exists()) {
                p.delete();
            }
            d.a.b0.d.a.a.b(new a(p, str, str2, m), "download splash resource");
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x0021, code lost:
        if (d.a.b0.b.f.f.f38580a == false) goto L11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0023, code lost:
        r4.printStackTrace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0040, code lost:
        if (d.a.b0.b.f.f.f38580a == false) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String i(File file) {
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
                        if (f38580a) {
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
                                if (f38580a) {
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

    public static String j(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(d.a.b0.a.c.f.c(str));
        int lastIndexOf = str.lastIndexOf(".");
        int lastIndexOf2 = str.lastIndexOf("/");
        if (lastIndexOf < lastIndexOf2 || lastIndexOf == -1 || lastIndexOf2 == -1) {
            return null;
        }
        sb.append(str.substring(lastIndexOf));
        return sb.toString();
    }

    public static File k() {
        File file = new File(d.a.b0.a.b.b.a().getFilesDir(), "splash");
        file.mkdirs();
        return file;
    }

    public static File l() {
        return new File(k(), "splash.dat");
    }

    public static File m(String str) {
        String j = j(str);
        if (TextUtils.isEmpty(j)) {
            return null;
        }
        return new File(k(), j);
    }

    public static List<g> n() {
        String i2;
        ArrayList arrayList = new ArrayList();
        File l = l();
        if (l.exists() && (i2 = i(l)) != null) {
            if (f38580a) {
                Log.d("SourceManager", "from local content:" + i2);
            }
            try {
                JSONArray jSONArray = new JSONArray(i2);
                if (f38580a) {
                    Log.d("SourceManager", "JSONArray" + jSONArray.length());
                }
                for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                    arrayList.add(g.b((JSONObject) jSONArray.get(i3)));
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            if (f38580a) {
                Log.d("SourceManager", "from local splashDataItemList:" + arrayList.size());
            }
            return arrayList;
        }
        return null;
    }

    public static HashMap<String, g> o() {
        HashMap<String, g> hashMap = new HashMap<>();
        File l = l();
        if (l.exists()) {
            try {
                JSONArray jSONArray = new JSONArray(i(l));
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    g b2 = g.b((JSONObject) jSONArray.get(i2));
                    hashMap.put(b2.f38590b, b2);
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return hashMap;
        }
        return null;
    }

    public static File p(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);
        stringBuffer.append(".tmp");
        return new File(k(), stringBuffer.toString());
    }

    public static boolean q(List<g> list, File file) {
        StringBuffer stringBuffer;
        int i2;
        FileWriter fileWriter;
        if (f38580a) {
            Log.d("SourceManager", "persistListToFile size:" + list.size());
        }
        int i3 = 0;
        if (list.size() <= 0) {
            return false;
        }
        FileWriter fileWriter2 = null;
        try {
            try {
                g[] gVarArr = (g[]) list.toArray(new g[list.size() - 1]);
                stringBuffer = new StringBuffer();
                stringBuffer.append("[");
                int length = gVarArr.length;
                while (true) {
                    i2 = length - 1;
                    if (i3 >= i2) {
                        break;
                    }
                    stringBuffer.append(gVarArr[i3].i());
                    stringBuffer.append(",");
                    i3++;
                }
                stringBuffer.append(gVarArr[i2].i());
                stringBuffer.append("]");
                if (f38580a) {
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
                if (f38580a) {
                    Log.d("SourceManager", "persistListToFile() writer.close() Exception e: ");
                    e3.printStackTrace();
                }
            }
            return true;
        } catch (IOException e4) {
            fileWriter2 = fileWriter;
            e = e4;
            if (f38580a) {
                Log.d("SourceManager", "persistListToFile() Exception e: ");
                e.printStackTrace();
            }
            if (fileWriter2 != null) {
                try {
                    fileWriter2.close();
                } catch (Exception e5) {
                    if (f38580a) {
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
                    if (f38580a) {
                        Log.d("SourceManager", "persistListToFile() writer.close() Exception e: ");
                        e6.printStackTrace();
                    }
                }
            }
            throw th;
        }
    }

    public static boolean r(File file, File file2) {
        if (file == null || file2 == null) {
            return false;
        }
        return file.renameTo(file2);
    }

    public static void s(List<g> list) {
        d.a.b0.d.a.a.b(new c(list), "ScheduleDownloadSplashSourceThread");
    }

    public static void t(g gVar) {
        ArrayList arrayList = new ArrayList();
        File l = l();
        List<g> n = n();
        if (n == null || n.size() == 0) {
            return;
        }
        if (f38580a) {
            Log.d("SourceManager", "updateSplashDataItem--->getSplashDataItemList:" + n.size());
        }
        for (int i2 = 0; i2 < n.size(); i2++) {
            g gVar2 = n.get(i2);
            if (TextUtils.equals(gVar.f38590b, gVar2.f38590b)) {
                g.j(gVar2, gVar);
                arrayList.add(gVar2);
            } else {
                arrayList.add(gVar2);
            }
        }
        q(arrayList, l);
    }

    public static void u(g gVar) {
        if (gVar.u >= 1) {
            int i2 = gVar.w;
            if (i2 < Integer.MAX_VALUE) {
                gVar.w = i2 + 1;
            }
            d.a.b0.d.a.a.b(new b(gVar), "updateSplashDataItemRate");
        }
    }

    public static void v(List<g> list) {
        q(list, l());
    }
}

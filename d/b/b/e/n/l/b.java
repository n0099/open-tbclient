package d.b.b.e.n.l;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.task.HttpMessageTask;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.stats.BdStatisticsManager;
import com.baidu.adp.lib.stats.BdStatisticsSwitchStatic;
import com.baidu.adp.lib.stats.upload.BdUploadingLogInfo;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
import d.b.b.e.p.g;
import d.b.b.e.p.j;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class b {

    /* renamed from: f  reason: collision with root package name */
    public static b f41941f;

    /* renamed from: a  reason: collision with root package name */
    public d.b.b.e.n.c f41942a;

    /* renamed from: b  reason: collision with root package name */
    public String f41943b;

    /* renamed from: c  reason: collision with root package name */
    public String f41944c;

    /* renamed from: d  reason: collision with root package name */
    public C0540b f41945d;

    /* renamed from: e  reason: collision with root package name */
    public CustomMessageListener f41946e = new a(2000994);

    /* loaded from: classes.dex */
    public class a extends CustomMessageListener {
        public a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                b.this.f();
            }
        }
    }

    /* renamed from: d.b.b.e.n.l.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0540b extends BroadcastReceiver {
        public C0540b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null) {
                return;
            }
            b.this.o(intent.getStringExtra("intent_data_userid"), intent.getStringExtra("intent_data_username"), intent.getStringExtra("intent_data_bduss"));
        }

        public /* synthetic */ C0540b(b bVar, a aVar) {
            this();
        }
    }

    /* loaded from: classes.dex */
    public class c extends BdAsyncTask<Object, Integer, Void> {

        /* renamed from: a  reason: collision with root package name */
        public d.b.b.e.n.h.a f41948a;

        public c(@NonNull d.b.b.e.n.h.a aVar) {
            this.f41948a = null;
            this.f41948a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Void doInBackground(Object... objArr) {
            d(this.f41948a);
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(Void r2) {
            this.f41948a.J(false);
        }

        public final void d(d.b.b.e.n.h.a aVar) {
            try {
                BdUploadingLogInfo b2 = d.b.b.e.n.l.c.b(aVar);
                int size = b2.size();
                if (b2 == null || size <= 0) {
                    return;
                }
                for (int i = size - 1; i >= 0; i--) {
                    ArrayList<String> trackLogStringByIndex = b2.getTrackLogStringByIndex(i);
                    if (trackLogStringByIndex != null && trackLogStringByIndex.size() != 0) {
                        b.this.i(aVar, trackLogStringByIndex, b2.get(i));
                    }
                }
            } catch (Exception e2) {
                BdLog.e(e2);
            }
        }
    }

    /* loaded from: classes.dex */
    public class d extends BdAsyncTask<Object, Integer, Void> {

        /* renamed from: a  reason: collision with root package name */
        public d.b.b.e.n.h.a f41950a;

        /* renamed from: b  reason: collision with root package name */
        public String f41951b;

        public d(d.b.b.e.n.h.a aVar, String str) {
            this.f41950a = aVar;
            this.f41951b = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Void doInBackground(Object... objArr) {
            String e2 = d.b.b.e.n.l.d.e(this.f41950a, b.this.f41942a);
            String str = this.f41951b;
            ArrayList arrayList = new ArrayList();
            arrayList.add(str);
            BdLog.i("commonHeader = " + e2);
            BdLog.i("cache = " + str);
            this.f41950a.d();
            b.this.h(this.f41950a, e2, arrayList, null, true);
            return null;
        }
    }

    /* loaded from: classes.dex */
    public class e extends BdAsyncTask<Object, Integer, Void> {

        /* renamed from: a  reason: collision with root package name */
        public d.b.b.e.n.h.a f41953a;

        /* renamed from: b  reason: collision with root package name */
        public String f41954b;

        public e(d.b.b.e.n.h.a aVar, String str) {
            this.f41953a = aVar;
            this.f41954b = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Void doInBackground(Object... objArr) {
            String str = this.f41954b;
            ArrayList arrayList = new ArrayList();
            arrayList.add(str);
            this.f41953a.f();
            b.this.i(this.f41953a, arrayList, null);
            return null;
        }
    }

    /* loaded from: classes.dex */
    public class f extends BdAsyncTask<Object, Integer, Void> {

        /* renamed from: a  reason: collision with root package name */
        public d.b.b.e.n.h.a f41956a;

        /* renamed from: b  reason: collision with root package name */
        public ArrayList<String> f41957b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f41958c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f41959d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f41960e;

        public f(d.b.b.e.n.h.a aVar, ArrayList<String> arrayList, boolean z, boolean z2, boolean z3) {
            this.f41956a = null;
            this.f41957b = null;
            this.f41958c = false;
            this.f41959d = false;
            this.f41960e = false;
            this.f41956a = aVar;
            this.f41957b = arrayList;
            this.f41958c = z;
            this.f41959d = z2;
            this.f41960e = z3;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Void doInBackground(Object... objArr) {
            d(this.f41956a, this.f41958c, this.f41959d, this.f41960e);
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(Void r2) {
            this.f41956a.K(false);
        }

        public final void d(d.b.b.e.n.h.a aVar, boolean z, boolean z2, boolean z3) {
            int i;
            try {
                String e2 = d.b.b.e.n.l.d.e(aVar, b.this.f41942a);
                BdUploadingLogInfo b2 = d.b.b.e.n.l.a.b(aVar, z2);
                int size = b2.size();
                if (b2 == null || size <= 0) {
                    return;
                }
                if (!z) {
                    int i2 = 0;
                    while (i2 < size) {
                        ArrayList<String> logStringByIndex = b2.getLogStringByIndex(i2, this.f41957b);
                        if (logStringByIndex != null && logStringByIndex.size() != 0) {
                            if (!z2) {
                                i = i2;
                                b.this.h(aVar, e2, logStringByIndex, b2.get(i), z3);
                            } else {
                                ArrayList<d.b.b.e.n.h.d> arrayList = b2.get(i2);
                                for (int i3 = 0; i3 < arrayList.size(); i3++) {
                                    if (arrayList.get(i3).f41926b.contains("notUpload/")) {
                                        arrayList.get(i3).f41926b = arrayList.get(i3).f41926b.replace("notUpload/", "");
                                    }
                                }
                                i = i2;
                                b.this.h(aVar, e2, logStringByIndex, arrayList, z3);
                            }
                            i2 = i + 1;
                        }
                        i = i2;
                        i2 = i + 1;
                    }
                    return;
                }
                int i4 = 0;
                for (int i5 = size - 1; i5 >= 0; i5--) {
                    ArrayList<String> logStringByIndex2 = b2.getLogStringByIndex(i5, this.f41957b);
                    if (logStringByIndex2 != null && logStringByIndex2.size() != 0) {
                        if (!j.H() && (i4 = i4 + logStringByIndex2.toString().length()) > 102400) {
                            return;
                        }
                        int i6 = i4;
                        if (!z2) {
                            b.this.h(aVar, e2, logStringByIndex2, b2.get(i5), z3);
                        } else {
                            ArrayList<d.b.b.e.n.h.d> arrayList2 = b2.get(i5);
                            for (int i7 = 0; i7 < arrayList2.size(); i7++) {
                                if (arrayList2.get(i7).f41926b.contains("notUpload/")) {
                                    arrayList2.get(i7).f41926b = arrayList2.get(i7).f41926b.replace("notUpload/", "");
                                }
                            }
                            b.this.h(aVar, e2, logStringByIndex2, arrayList2, z3);
                        }
                        i4 = i6;
                    }
                }
            } catch (Exception e3) {
                BdLog.e(e3);
            }
        }
    }

    public static b m() {
        if (f41941f == null) {
            synchronized (b.class) {
                if (f41941f == null) {
                    f41941f = new b();
                }
            }
        }
        return f41941f;
    }

    public final void e(ArrayList<String> arrayList, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (arrayList == null) {
            arrayList = new ArrayList<>();
        }
        if (arrayList.contains(str)) {
            return;
        }
        arrayList.add(str);
    }

    public final void f() {
        this.f41942a.o = d.b.b.e.n.d.a(BdBaseApplication.getInst());
        this.f41942a.p = String.valueOf(j.I());
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0041 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0042  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String g(String str, d.b.b.e.n.h.a aVar, String str2, ArrayList<String> arrayList, ArrayList<d.b.b.e.n.h.d> arrayList2, boolean z, boolean z2) {
        byte[] l;
        ByteArrayOutputStream byteArrayOutputStream;
        byte[] bArr;
        String str3 = str;
        if (str3 != null && aVar != null && (l = l(str2, arrayList)) != null && l.length > 0) {
            ByteArrayOutputStream byteArrayOutputStream2 = null;
            try {
                try {
                    byteArrayOutputStream = new ByteArrayOutputStream(l.length / 2);
                    try {
                        g.b(l, byteArrayOutputStream);
                        bArr = byteArrayOutputStream.toByteArray();
                        d.b.b.e.m.a.d(byteArrayOutputStream);
                    } catch (Exception e2) {
                        e = e2;
                        BdLog.e(e);
                        d.b.b.e.m.a.d(byteArrayOutputStream);
                        bArr = null;
                        if (bArr != null) {
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    byteArrayOutputStream2 = byteArrayOutputStream;
                    d.b.b.e.m.a.d(byteArrayOutputStream2);
                    throw th;
                }
            } catch (Exception e3) {
                e = e3;
                byteArrayOutputStream = null;
            } catch (Throwable th2) {
                th = th2;
                d.b.b.e.m.a.d(byteArrayOutputStream2);
                throw th;
            }
            if (bArr != null) {
                return "";
            }
            HashMap hashMap = new HashMap();
            hashMap.put(aVar.p(), bArr);
            ArrayList arrayList3 = new ArrayList(hashMap.entrySet());
            if (aVar != null) {
                try {
                    if (aVar.o().equals("pfmonitor") && BdStatisticsSwitchStatic.isOn()) {
                        try {
                            d.b.b.e.j.a.e eVar = new d.b.b.e.j.a.e();
                            String str4 = this.f41943b;
                            if (z2 && str4.contains("c.tieba.baidu.com")) {
                                str4 = str4.replace("c.tieba.baidu.com", "123.125.115.120");
                                eVar.b().a("Host", "c.tieba.baidu.com");
                            }
                            eVar.b().s(str4);
                            eVar.b().q(HttpMessageTask.HTTP_METHOD.POST);
                            HashMap<String, Object> f2 = d.b.b.e.n.l.d.f(this.f41942a, z);
                            if (f2 != null) {
                                eVar.b().r(new ArrayList(f2.entrySet()));
                            }
                            hashMap.clear();
                            hashMap.put("pf", bArr);
                            arrayList3.clear();
                            arrayList3.addAll(hashMap.entrySet());
                            eVar.b().r(arrayList3);
                            try {
                                new d.b.b.e.j.a.c(eVar).m(3, -1, -1);
                            } catch (Exception e4) {
                                BdLog.detailException(e4);
                            }
                            j(arrayList2, aVar.E());
                            return null;
                        } catch (Exception e5) {
                            BdLog.e(e5);
                            return e5.getMessage();
                        }
                    }
                } catch (Exception e6) {
                    BdLog.e(e6);
                    return e6.getMessage();
                }
            }
            d.b.b.e.j.a.e eVar2 = new d.b.b.e.j.a.e();
            if (z2 && str3.contains("c.tieba.baidu.com")) {
                str3 = str3.replace("c.tieba.baidu.com", "123.125.115.120");
                eVar2.b().a("Host", "c.tieba.baidu.com");
            }
            eVar2.b().s(str3);
            eVar2.b().q(HttpMessageTask.HTTP_METHOD.POST);
            HashMap<String, Object> f3 = d.b.b.e.n.l.d.f(this.f41942a, z);
            if (f3 != null) {
                eVar2.b().r(new ArrayList(f3.entrySet()));
            }
            eVar2.b().r(arrayList3);
            try {
                new d.b.b.e.j.a.c(eVar2).m(3, -1, -1);
                int i = eVar2.c().f41797b;
                byte[] bArr2 = eVar2.c().f41803h;
                if (bArr2 != null && i == 200) {
                    try {
                        if (new JSONObject(new String(bArr2, "utf-8")).optInt("error_code", -1) == 0) {
                            j(arrayList2, aVar.E());
                            return null;
                        }
                    } catch (Exception e7) {
                        BdLog.e(e7);
                        return e7.getMessage();
                    }
                }
                List<d.b.b.e.j.a.d> d2 = eVar2.d();
                if (d2 != null && d2.size() > 0) {
                    StringBuilder sb = new StringBuilder();
                    for (int i2 = 0; i2 < d2.size(); i2++) {
                        d.b.b.e.j.a.d dVar = d2.get(i2);
                        if (dVar != null && !TextUtils.isEmpty(dVar.f41784h)) {
                            if (sb.length() > 0) {
                                sb.append(",");
                            }
                            sb.append(dVar.f41784h);
                        }
                    }
                    if (sb.length() > 0) {
                        return sb.toString();
                    }
                }
            } catch (Exception e8) {
                BdLog.detailException(e8);
                return e8.getMessage();
            }
        }
        return "";
    }

    public final void h(d.b.b.e.n.h.a aVar, String str, ArrayList<String> arrayList, ArrayList<d.b.b.e.n.h.d> arrayList2, boolean z) {
        if (g(this.f41943b, aVar, str, arrayList, arrayList2, z, false) != null && j.z()) {
            String g2 = g(this.f41943b, aVar, str, arrayList, arrayList2, z, true);
            if (g2 == null) {
                d.b.b.e.n.a statsItem = BdStatisticsManager.getInstance().getStatsItem("dbg");
                statsItem.b("issuc", "true");
                BdStatisticsManager.getInstance().debug("STAT_UPLOAD_USEIP", statsItem);
                return;
            }
            d.b.b.e.n.a statsItem2 = BdStatisticsManager.getInstance().getStatsItem("dbg");
            statsItem2.b("issuc", "false");
            statsItem2.b("reason", g2);
            BdStatisticsManager.getInstance().debug("STAT_UPLOAD_USEIP", statsItem2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0038 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0039  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final boolean i(d.b.b.e.n.h.a aVar, ArrayList<String> arrayList, ArrayList<d.b.b.e.n.h.d> arrayList2) {
        byte[] k;
        ByteArrayOutputStream byteArrayOutputStream;
        if (aVar == null || arrayList == null || arrayList.isEmpty() || (k = k(arrayList)) == null || k.length == 0) {
            return false;
        }
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        byte[] bArr = null;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream(k.length / 2);
            try {
                try {
                    g.b(k, byteArrayOutputStream);
                    bArr = byteArrayOutputStream.toByteArray();
                } catch (Exception e2) {
                    e = e2;
                    BdLog.e(e);
                    d.b.b.e.m.a.d(byteArrayOutputStream);
                    if (bArr != null) {
                    }
                }
            } catch (Throwable th) {
                th = th;
                byteArrayOutputStream2 = byteArrayOutputStream;
                d.b.b.e.m.a.d(byteArrayOutputStream2);
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            byteArrayOutputStream = null;
        } catch (Throwable th2) {
            th = th2;
            d.b.b.e.m.a.d(byteArrayOutputStream2);
            throw th;
        }
        d.b.b.e.m.a.d(byteArrayOutputStream);
        if (bArr != null) {
            return false;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(aVar.q(), bArr);
        ArrayList arrayList3 = new ArrayList(hashMap.entrySet());
        d.b.b.e.j.a.e eVar = new d.b.b.e.j.a.e();
        eVar.b().a("Host", "c.tieba.baidu.com");
        eVar.b().s(this.f41944c);
        eVar.b().q(HttpMessageTask.HTTP_METHOD.POST);
        HashMap<String, Object> f2 = d.b.b.e.n.l.d.f(this.f41942a, false);
        if (f2 != null) {
            eVar.b().r(new ArrayList(f2.entrySet()));
        }
        eVar.b().r(arrayList3);
        try {
            new d.b.b.e.j.a.c(eVar).m(3, -1, -1);
            if (eVar.c().f41797b == 200) {
                try {
                    if (new JSONObject(new String(eVar.c().f41803h, "utf-8")).optString("error_code").equals("0")) {
                        ArrayList arrayList4 = new ArrayList();
                        Iterator<d.b.b.e.n.h.d> it = arrayList2.iterator();
                        while (it.hasNext()) {
                            arrayList4.add(it.next().f41926b);
                        }
                        if (arrayList4.size() > 0) {
                            d.b.b.e.n.h.c.a(arrayList4, aVar.C());
                            return true;
                        }
                        return true;
                    }
                    return true;
                } catch (Exception e4) {
                    BdLog.e(e4);
                    return false;
                }
            }
            return true;
        } catch (Exception e5) {
            BdLog.detailException(e5);
            return false;
        }
    }

    public final void j(ArrayList<d.b.b.e.n.h.d> arrayList, boolean z) {
        if (arrayList == null || arrayList.size() == 0) {
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator<d.b.b.e.n.h.d> it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(it.next().f41926b);
        }
        if (arrayList2.size() > 0) {
            d.b.b.e.n.h.b.a(arrayList2, z);
        }
    }

    public final byte[] k(ArrayList<String> arrayList) {
        if (arrayList != null && arrayList.size() != 0) {
            try {
                StringBuilder sb = new StringBuilder();
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    if (i != 0) {
                        sb.append("&");
                    }
                    sb.append(URLEncoder.encode(arrayList.get(i), "utf-8"));
                }
                return sb.toString().getBytes();
            } catch (Exception e2) {
                BdLog.e(e2);
            }
        }
        return null;
    }

    public final byte[] l(String str, ArrayList<String> arrayList) {
        if (arrayList != null && arrayList.size() != 0) {
            try {
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    sb.append("&rec");
                    sb.append(i);
                    sb.append(com.alipay.sdk.encrypt.a.f1897h);
                    try {
                        sb.append(URLEncoder.encode(arrayList.get(i), "utf-8"));
                    } catch (UnsupportedEncodingException e2) {
                        BdLog.e(e2);
                    }
                }
                return sb.toString().getBytes();
            } catch (Exception e3) {
                BdLog.e(e3);
            }
        }
        return null;
    }

    public void n(d.b.b.e.n.c cVar, String str, String str2) {
        this.f41943b = str;
        this.f41944c = str2;
        this.f41942a = cVar;
        if (cVar != null) {
            cVar.k = Build.MODEL;
            cVar.q = Build.VERSION.RELEASE;
            cVar.o = d.b.b.e.n.d.a(BdBaseApplication.getInst());
            this.f41942a.p = String.valueOf(j.I());
        }
        try {
            MessageManager.getInstance().registerListener(this.f41946e);
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
        if (this.f41945d == null) {
            this.f41945d = new C0540b(this, null);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("adp.bdstatisticsmanager.account_changed");
            BdBaseApplication.getInst().registerReceiver(this.f41945d, intentFilter);
        }
    }

    public void o(String str, String str2, String str3) {
        if (this.f41942a.l == null && str == null) {
            return;
        }
        String str4 = this.f41942a.l;
        if (str4 == null || !str4.equals(str)) {
            d.b.b.e.n.c cVar = this.f41942a;
            cVar.l = str;
            cVar.m = str2;
            cVar.n = str3;
        }
    }

    public void p(d.b.b.e.n.h.a aVar, String str) {
        new d(aVar, str).execute(new Object[0]);
    }

    public void q(d.b.b.e.n.h.a aVar, String str) {
        new e(aVar, str).execute(new Object[0]);
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:65:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void r(d.b.b.e.n.h.a aVar, boolean z, boolean z2, boolean z3) {
        ArrayList<String> arrayList;
        if (!BdStatisticsManager.getInstance().isMainProcess() || aVar == null) {
            return;
        }
        ArrayList<String> n = d.b.b.e.n.k.a.o().n(aVar.o());
        ArrayList arrayList2 = null;
        if (!z) {
            boolean x = d.b.b.e.n.k.a.o().x(aVar.o(), null);
            boolean H = j.H();
            if (x && !H) {
                return;
            }
            if (n != null && n.size() > 0) {
                arrayList = new ArrayList<>();
                Iterator<String> it = n.iterator();
                while (it.hasNext()) {
                    String next = it.next();
                    if (!d.b.b.e.n.k.a.o().u(aVar.o(), next)) {
                        e(arrayList, next);
                    } else if (!d.b.b.e.n.k.a.o().A(aVar.o(), next)) {
                        e(arrayList, next);
                    } else {
                        boolean x2 = d.b.b.e.n.k.a.o().x(aVar.o(), next);
                        boolean H2 = j.H();
                        if (x2 && !H2) {
                            e(arrayList, next);
                        }
                    }
                }
                if (aVar.D()) {
                    aVar.K(true);
                    if (arrayList != null && arrayList.size() > 0) {
                        arrayList2 = new ArrayList();
                        Iterator<String> it2 = arrayList.iterator();
                        while (it2.hasNext()) {
                            String next2 = it2.next();
                            try {
                                arrayList2.add("st=" + URLEncoder.encode(d.b.b.e.n.a.h(next2), "utf-8") + "&");
                            } catch (UnsupportedEncodingException e2) {
                                e2.printStackTrace();
                            }
                        }
                    }
                    new f(aVar, arrayList2, z, z2, z3).execute(new Object[0]);
                    return;
                }
                return;
            }
        }
        arrayList = null;
        if (aVar.D()) {
        }
    }

    public void s(d.b.b.e.n.h.a aVar) {
        if (aVar.B()) {
            return;
        }
        aVar.J(true);
        new c(aVar).execute(new Object[0]);
    }
}

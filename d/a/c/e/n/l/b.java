package d.a.c.e.n.l;

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
import d.a.c.e.p.g;
import d.a.c.e.p.j;
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
    public static b f38795f;

    /* renamed from: a  reason: collision with root package name */
    public d.a.c.e.n.c f38796a;

    /* renamed from: b  reason: collision with root package name */
    public String f38797b;

    /* renamed from: c  reason: collision with root package name */
    public String f38798c;

    /* renamed from: d  reason: collision with root package name */
    public C0488b f38799d;

    /* renamed from: e  reason: collision with root package name */
    public CustomMessageListener f38800e = new a(2000994);

    /* loaded from: classes.dex */
    public class a extends CustomMessageListener {
        public a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError()) {
                b.this.f();
            }
        }
    }

    /* renamed from: d.a.c.e.n.l.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0488b extends BroadcastReceiver {
        public C0488b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent == null) {
                return;
            }
            b.this.o(intent.getStringExtra("intent_data_userid"), intent.getStringExtra("intent_data_username"), intent.getStringExtra("intent_data_bduss"));
        }

        public /* synthetic */ C0488b(b bVar, a aVar) {
            this();
        }
    }

    /* loaded from: classes.dex */
    public class c extends BdAsyncTask<Object, Integer, Void> {

        /* renamed from: a  reason: collision with root package name */
        public d.a.c.e.n.h.a f38802a;

        public c(@NonNull d.a.c.e.n.h.a aVar) {
            this.f38802a = null;
            this.f38802a = aVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Void doInBackground(Object... objArr) {
            d(this.f38802a);
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(Void r2) {
            this.f38802a.J(false);
        }

        public final void d(d.a.c.e.n.h.a aVar) {
            try {
                BdUploadingLogInfo b2 = d.a.c.e.n.l.c.b(aVar);
                int size = b2.size();
                if (b2 == null || size <= 0) {
                    return;
                }
                for (int i2 = size - 1; i2 >= 0; i2--) {
                    ArrayList<String> trackLogStringByIndex = b2.getTrackLogStringByIndex(i2);
                    if (trackLogStringByIndex != null && trackLogStringByIndex.size() != 0) {
                        b.this.i(aVar, trackLogStringByIndex, b2.get(i2));
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
        public d.a.c.e.n.h.a f38804a;

        /* renamed from: b  reason: collision with root package name */
        public String f38805b;

        public d(d.a.c.e.n.h.a aVar, String str) {
            this.f38804a = aVar;
            this.f38805b = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Void doInBackground(Object... objArr) {
            String e2 = d.a.c.e.n.l.d.e(this.f38804a, b.this.f38796a);
            String str = this.f38805b;
            ArrayList arrayList = new ArrayList();
            arrayList.add(str);
            BdLog.i("commonHeader = " + e2);
            BdLog.i("cache = " + str);
            this.f38804a.d();
            b.this.h(this.f38804a, e2, arrayList, null, true);
            return null;
        }
    }

    /* loaded from: classes.dex */
    public class e extends BdAsyncTask<Object, Integer, Void> {

        /* renamed from: a  reason: collision with root package name */
        public d.a.c.e.n.h.a f38807a;

        /* renamed from: b  reason: collision with root package name */
        public String f38808b;

        public e(d.a.c.e.n.h.a aVar, String str) {
            this.f38807a = aVar;
            this.f38808b = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Void doInBackground(Object... objArr) {
            String str = this.f38808b;
            ArrayList arrayList = new ArrayList();
            arrayList.add(str);
            this.f38807a.f();
            b.this.i(this.f38807a, arrayList, null);
            return null;
        }
    }

    /* loaded from: classes.dex */
    public class f extends BdAsyncTask<Object, Integer, Void> {

        /* renamed from: a  reason: collision with root package name */
        public d.a.c.e.n.h.a f38810a;

        /* renamed from: b  reason: collision with root package name */
        public ArrayList<String> f38811b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f38812c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f38813d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f38814e;

        public f(d.a.c.e.n.h.a aVar, ArrayList<String> arrayList, boolean z, boolean z2, boolean z3) {
            this.f38810a = null;
            this.f38811b = null;
            this.f38812c = false;
            this.f38813d = false;
            this.f38814e = false;
            this.f38810a = aVar;
            this.f38811b = arrayList;
            this.f38812c = z;
            this.f38813d = z2;
            this.f38814e = z3;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Void doInBackground(Object... objArr) {
            d(this.f38810a, this.f38812c, this.f38813d, this.f38814e);
            return null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(Void r2) {
            this.f38810a.K(false);
        }

        public final void d(d.a.c.e.n.h.a aVar, boolean z, boolean z2, boolean z3) {
            int i2;
            try {
                String e2 = d.a.c.e.n.l.d.e(aVar, b.this.f38796a);
                BdUploadingLogInfo b2 = d.a.c.e.n.l.a.b(aVar, z2);
                int size = b2.size();
                if (b2 == null || size <= 0) {
                    return;
                }
                if (!z) {
                    int i3 = 0;
                    while (i3 < size) {
                        ArrayList<String> logStringByIndex = b2.getLogStringByIndex(i3, this.f38811b);
                        if (logStringByIndex != null && logStringByIndex.size() != 0) {
                            if (!z2) {
                                i2 = i3;
                                b.this.h(aVar, e2, logStringByIndex, b2.get(i2), z3);
                            } else {
                                ArrayList<d.a.c.e.n.h.d> arrayList = b2.get(i3);
                                for (int i4 = 0; i4 < arrayList.size(); i4++) {
                                    if (arrayList.get(i4).f38779b.contains("notUpload/")) {
                                        arrayList.get(i4).f38779b = arrayList.get(i4).f38779b.replace("notUpload/", "");
                                    }
                                }
                                i2 = i3;
                                b.this.h(aVar, e2, logStringByIndex, arrayList, z3);
                            }
                            i3 = i2 + 1;
                        }
                        i2 = i3;
                        i3 = i2 + 1;
                    }
                    return;
                }
                int i5 = 0;
                for (int i6 = size - 1; i6 >= 0; i6--) {
                    ArrayList<String> logStringByIndex2 = b2.getLogStringByIndex(i6, this.f38811b);
                    if (logStringByIndex2 != null && logStringByIndex2.size() != 0) {
                        if (!j.H() && (i5 = i5 + logStringByIndex2.toString().length()) > 102400) {
                            return;
                        }
                        int i7 = i5;
                        if (!z2) {
                            b.this.h(aVar, e2, logStringByIndex2, b2.get(i6), z3);
                        } else {
                            ArrayList<d.a.c.e.n.h.d> arrayList2 = b2.get(i6);
                            for (int i8 = 0; i8 < arrayList2.size(); i8++) {
                                if (arrayList2.get(i8).f38779b.contains("notUpload/")) {
                                    arrayList2.get(i8).f38779b = arrayList2.get(i8).f38779b.replace("notUpload/", "");
                                }
                            }
                            b.this.h(aVar, e2, logStringByIndex2, arrayList2, z3);
                        }
                        i5 = i7;
                    }
                }
            } catch (Exception e3) {
                BdLog.e(e3);
            }
        }
    }

    public static b m() {
        if (f38795f == null) {
            synchronized (b.class) {
                if (f38795f == null) {
                    f38795f = new b();
                }
            }
        }
        return f38795f;
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
        this.f38796a.o = d.a.c.e.n.d.a(BdBaseApplication.getInst());
        this.f38796a.p = String.valueOf(j.I());
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0041 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0042  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String g(String str, d.a.c.e.n.h.a aVar, String str2, ArrayList<String> arrayList, ArrayList<d.a.c.e.n.h.d> arrayList2, boolean z, boolean z2) {
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
                        d.a.c.e.m.a.d(byteArrayOutputStream);
                    } catch (Exception e2) {
                        e = e2;
                        BdLog.e(e);
                        d.a.c.e.m.a.d(byteArrayOutputStream);
                        bArr = null;
                        if (bArr != null) {
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    byteArrayOutputStream2 = byteArrayOutputStream;
                    d.a.c.e.m.a.d(byteArrayOutputStream2);
                    throw th;
                }
            } catch (Exception e3) {
                e = e3;
                byteArrayOutputStream = null;
            } catch (Throwable th2) {
                th = th2;
                d.a.c.e.m.a.d(byteArrayOutputStream2);
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
                            d.a.c.e.j.a.e eVar = new d.a.c.e.j.a.e();
                            String str4 = this.f38797b;
                            if (z2 && str4.contains("c.tieba.baidu.com")) {
                                str4 = str4.replace("c.tieba.baidu.com", "123.125.115.120");
                                eVar.b().a("Host", "c.tieba.baidu.com");
                            }
                            eVar.b().s(str4);
                            eVar.b().q(HttpMessageTask.HTTP_METHOD.POST);
                            HashMap<String, Object> f2 = d.a.c.e.n.l.d.f(this.f38796a, z);
                            if (f2 != null) {
                                eVar.b().r(new ArrayList(f2.entrySet()));
                            }
                            hashMap.clear();
                            hashMap.put("pf", bArr);
                            arrayList3.clear();
                            arrayList3.addAll(hashMap.entrySet());
                            eVar.b().r(arrayList3);
                            try {
                                new d.a.c.e.j.a.c(eVar).n(3, -1, -1);
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
            d.a.c.e.j.a.e eVar2 = new d.a.c.e.j.a.e();
            if (z2 && str3.contains("c.tieba.baidu.com")) {
                str3 = str3.replace("c.tieba.baidu.com", "123.125.115.120");
                eVar2.b().a("Host", "c.tieba.baidu.com");
            }
            eVar2.b().s(str3);
            eVar2.b().q(HttpMessageTask.HTTP_METHOD.POST);
            HashMap<String, Object> f3 = d.a.c.e.n.l.d.f(this.f38796a, z);
            if (f3 != null) {
                eVar2.b().r(new ArrayList(f3.entrySet()));
            }
            eVar2.b().r(arrayList3);
            try {
                new d.a.c.e.j.a.c(eVar2).n(3, -1, -1);
                int i2 = eVar2.c().f38642b;
                byte[] bArr2 = eVar2.c().f38648h;
                if (bArr2 != null && i2 == 200) {
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
                List<d.a.c.e.j.a.d> d2 = eVar2.d();
                if (d2 != null && d2.size() > 0) {
                    StringBuilder sb = new StringBuilder();
                    for (int i3 = 0; i3 < d2.size(); i3++) {
                        d.a.c.e.j.a.d dVar = d2.get(i3);
                        if (dVar != null && !TextUtils.isEmpty(dVar.f38628h)) {
                            if (sb.length() > 0) {
                                sb.append(",");
                            }
                            sb.append(dVar.f38628h);
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

    public final void h(d.a.c.e.n.h.a aVar, String str, ArrayList<String> arrayList, ArrayList<d.a.c.e.n.h.d> arrayList2, boolean z) {
        if (g(this.f38797b, aVar, str, arrayList, arrayList2, z, false) != null && j.z()) {
            String g2 = g(this.f38797b, aVar, str, arrayList, arrayList2, z, true);
            if (g2 == null) {
                d.a.c.e.n.a statsItem = BdStatisticsManager.getInstance().getStatsItem("dbg");
                statsItem.b("issuc", "true");
                BdStatisticsManager.getInstance().debug("STAT_UPLOAD_USEIP", statsItem);
                return;
            }
            d.a.c.e.n.a statsItem2 = BdStatisticsManager.getInstance().getStatsItem("dbg");
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
    public final boolean i(d.a.c.e.n.h.a aVar, ArrayList<String> arrayList, ArrayList<d.a.c.e.n.h.d> arrayList2) {
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
                    d.a.c.e.m.a.d(byteArrayOutputStream);
                    if (bArr != null) {
                    }
                }
            } catch (Throwable th) {
                th = th;
                byteArrayOutputStream2 = byteArrayOutputStream;
                d.a.c.e.m.a.d(byteArrayOutputStream2);
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
            byteArrayOutputStream = null;
        } catch (Throwable th2) {
            th = th2;
            d.a.c.e.m.a.d(byteArrayOutputStream2);
            throw th;
        }
        d.a.c.e.m.a.d(byteArrayOutputStream);
        if (bArr != null) {
            return false;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(aVar.q(), bArr);
        ArrayList arrayList3 = new ArrayList(hashMap.entrySet());
        d.a.c.e.j.a.e eVar = new d.a.c.e.j.a.e();
        eVar.b().a("Host", "c.tieba.baidu.com");
        eVar.b().s(this.f38798c);
        eVar.b().q(HttpMessageTask.HTTP_METHOD.POST);
        HashMap<String, Object> f2 = d.a.c.e.n.l.d.f(this.f38796a, false);
        if (f2 != null) {
            eVar.b().r(new ArrayList(f2.entrySet()));
        }
        eVar.b().r(arrayList3);
        try {
            new d.a.c.e.j.a.c(eVar).n(3, -1, -1);
            if (eVar.c().f38642b == 200) {
                try {
                    if (new JSONObject(new String(eVar.c().f38648h, "utf-8")).optString("error_code").equals("0")) {
                        ArrayList arrayList4 = new ArrayList();
                        Iterator<d.a.c.e.n.h.d> it = arrayList2.iterator();
                        while (it.hasNext()) {
                            arrayList4.add(it.next().f38779b);
                        }
                        if (arrayList4.size() > 0) {
                            d.a.c.e.n.h.c.a(arrayList4, aVar.C());
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

    public final void j(ArrayList<d.a.c.e.n.h.d> arrayList, boolean z) {
        if (arrayList == null || arrayList.size() == 0) {
            return;
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator<d.a.c.e.n.h.d> it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(it.next().f38779b);
        }
        if (arrayList2.size() > 0) {
            d.a.c.e.n.h.b.a(arrayList2, z);
        }
    }

    public final byte[] k(ArrayList<String> arrayList) {
        if (arrayList != null && arrayList.size() != 0) {
            try {
                StringBuilder sb = new StringBuilder();
                int size = arrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    if (i2 != 0) {
                        sb.append("&");
                    }
                    sb.append(URLEncoder.encode(arrayList.get(i2), "utf-8"));
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
                for (int i2 = 0; i2 < size; i2++) {
                    sb.append("&rec");
                    sb.append(i2);
                    sb.append(com.alipay.sdk.encrypt.a.f1873h);
                    try {
                        sb.append(URLEncoder.encode(arrayList.get(i2), "utf-8"));
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

    public void n(d.a.c.e.n.c cVar, String str, String str2) {
        this.f38797b = str;
        this.f38798c = str2;
        this.f38796a = cVar;
        if (cVar != null) {
            cVar.k = Build.MODEL;
            cVar.q = Build.VERSION.RELEASE;
            cVar.o = d.a.c.e.n.d.a(BdBaseApplication.getInst());
            this.f38796a.p = String.valueOf(j.I());
        }
        try {
            MessageManager.getInstance().registerListener(this.f38800e);
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
        if (this.f38799d == null) {
            this.f38799d = new C0488b(this, null);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("adp.bdstatisticsmanager.account_changed");
            BdBaseApplication.getInst().registerReceiver(this.f38799d, intentFilter);
        }
    }

    public void o(String str, String str2, String str3) {
        if (this.f38796a.l == null && str == null) {
            return;
        }
        String str4 = this.f38796a.l;
        if (str4 == null || !str4.equals(str)) {
            d.a.c.e.n.c cVar = this.f38796a;
            cVar.l = str;
            cVar.m = str2;
            cVar.n = str3;
        }
    }

    public void p(d.a.c.e.n.h.a aVar, String str) {
        new d(aVar, str).execute(new Object[0]);
    }

    public void q(d.a.c.e.n.h.a aVar, String str) {
        new e(aVar, str).execute(new Object[0]);
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:65:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void r(d.a.c.e.n.h.a aVar, boolean z, boolean z2, boolean z3) {
        ArrayList<String> arrayList;
        if (!BdStatisticsManager.getInstance().isMainProcess() || aVar == null) {
            return;
        }
        ArrayList<String> n = d.a.c.e.n.k.a.o().n(aVar.o());
        ArrayList arrayList2 = null;
        if (!z) {
            boolean x = d.a.c.e.n.k.a.o().x(aVar.o(), null);
            boolean H = j.H();
            if (x && !H) {
                return;
            }
            if (n != null && n.size() > 0) {
                arrayList = new ArrayList<>();
                Iterator<String> it = n.iterator();
                while (it.hasNext()) {
                    String next = it.next();
                    if (!d.a.c.e.n.k.a.o().u(aVar.o(), next)) {
                        e(arrayList, next);
                    } else if (!d.a.c.e.n.k.a.o().A(aVar.o(), next)) {
                        e(arrayList, next);
                    } else {
                        boolean x2 = d.a.c.e.n.k.a.o().x(aVar.o(), next);
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
                                arrayList2.add("st=" + URLEncoder.encode(d.a.c.e.n.a.h(next2), "utf-8") + "&");
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

    public void s(d.a.c.e.n.h.a aVar) {
        if (aVar.B()) {
            return;
        }
        aVar.J(true);
        new c(aVar).execute(new Object[0]);
    }
}

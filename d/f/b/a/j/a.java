package d.f.b.a.j;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.os.Process;
import android.os.SystemClock;
import android.util.Log;
import com.android.internal.http.multipart.Part;
import com.heytap.mcssdk.PushManager;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
/* loaded from: classes6.dex */
public class a {
    public static String A;
    public static int B;

    /* renamed from: a  reason: collision with root package name */
    public String f65439a;

    /* renamed from: b  reason: collision with root package name */
    public String f65440b;

    /* renamed from: e  reason: collision with root package name */
    public String f65443e;

    /* renamed from: f  reason: collision with root package name */
    public String f65444f;

    /* renamed from: h  reason: collision with root package name */
    public int f65446h;

    /* renamed from: i  reason: collision with root package name */
    public String f65447i;
    public String j;
    public String k;
    public long l;
    public long m;
    public String n;
    public String o;
    public boolean p;
    public String q;
    public static final SimpleDateFormat x = new SimpleDateFormat("MM-dd HH:mm:ss.SSS", Locale.US);
    public static String z = Build.MODEL;
    public static String y = d.f.b.a.c.d().provideQualifier();

    /* renamed from: c  reason: collision with root package name */
    public String f65441c = "";

    /* renamed from: d  reason: collision with root package name */
    public int f65442d = -1;

    /* renamed from: g  reason: collision with root package name */
    public String f65445g = "";
    public String r = "-1";
    public ArrayList<String> s = new ArrayList<>();
    public StringBuilder t = new StringBuilder();
    public StringBuilder u = new StringBuilder();
    public StringBuilder v = new StringBuilder();
    public StringBuilder w = new StringBuilder();

    static {
        A = "";
        B = -1;
        B = b.b();
        A = Build.VERSION.SDK_INT + " " + Build.VERSION.RELEASE;
    }

    public static a b() {
        a aVar = new a();
        Context provideContext = d.f.b.a.c.d().provideContext();
        String str = aVar.f65445g;
        if (str == null || str.length() == 0) {
            try {
                PackageInfo packageInfo = provideContext.getPackageManager().getPackageInfo(provideContext.getPackageName(), 0);
                aVar.f65446h = packageInfo.versionCode;
                aVar.f65445g = packageInfo.versionName;
            } catch (Throwable th) {
                Log.e("BlockInfo", "newInstance: ", th);
            }
        }
        aVar.f65442d = B;
        aVar.f65440b = z;
        aVar.f65441c = A;
        aVar.f65439a = y;
        aVar.f65443e = d.f.b.a.c.d().provideUid();
        aVar.f65444f = c.a();
        aVar.f65447i = d.f.b.a.c.d().provideNetworkType();
        aVar.j = String.valueOf(b.a());
        aVar.k = String.valueOf(b.c());
        if (Build.VERSION.SDK_INT >= 24) {
            aVar.r = Long.toString(SystemClock.elapsedRealtime() - Process.getStartElapsedRealtime());
        }
        return aVar;
    }

    public a a() {
        StringBuilder sb = this.t;
        sb.append("qua");
        sb.append(" = ");
        sb.append(this.f65439a);
        sb.append(Part.CRLF);
        StringBuilder sb2 = this.t;
        sb2.append(PushManager.APP_VERSION_NAME);
        sb2.append(" = ");
        sb2.append(this.f65445g);
        sb2.append(Part.CRLF);
        StringBuilder sb3 = this.t;
        sb3.append(PushManager.APP_VERSION_CODE);
        sb3.append(" = ");
        sb3.append(this.f65446h);
        sb3.append(Part.CRLF);
        StringBuilder sb4 = this.t;
        sb4.append("uid");
        sb4.append(" = ");
        sb4.append(this.f65443e);
        sb4.append(Part.CRLF);
        StringBuilder sb5 = this.t;
        sb5.append("network");
        sb5.append(" = ");
        sb5.append(this.f65447i);
        sb5.append(Part.CRLF);
        StringBuilder sb6 = this.t;
        sb6.append("model");
        sb6.append(" = ");
        sb6.append(this.f65440b);
        sb6.append(Part.CRLF);
        StringBuilder sb7 = this.t;
        sb7.append("api-level");
        sb7.append(" = ");
        sb7.append(this.f65441c);
        sb7.append(Part.CRLF);
        StringBuilder sb8 = this.t;
        sb8.append("cpu-core");
        sb8.append(" = ");
        sb8.append(this.f65442d);
        sb8.append(Part.CRLF);
        StringBuilder sb9 = this.t;
        sb9.append("process");
        sb9.append(" = ");
        sb9.append(this.f65444f);
        sb9.append(Part.CRLF);
        StringBuilder sb10 = this.t;
        sb10.append("freeMemory");
        sb10.append(" = ");
        sb10.append(this.j);
        sb10.append(Part.CRLF);
        StringBuilder sb11 = this.t;
        sb11.append("totalMemory");
        sb11.append(" = ");
        sb11.append(this.k);
        sb11.append(Part.CRLF);
        StringBuilder sb12 = this.v;
        sb12.append("time");
        sb12.append(" = ");
        sb12.append(this.l);
        sb12.append(Part.CRLF);
        StringBuilder sb13 = this.v;
        sb13.append("thread-time");
        sb13.append(" = ");
        sb13.append(this.m);
        sb13.append(Part.CRLF);
        StringBuilder sb14 = this.v;
        sb14.append("time-start");
        sb14.append(" = ");
        sb14.append(this.n);
        sb14.append(Part.CRLF);
        StringBuilder sb15 = this.v;
        sb15.append("time-end");
        sb15.append(" = ");
        sb15.append(this.o);
        sb15.append(Part.CRLF);
        StringBuilder sb16 = this.u;
        sb16.append("cpu-busy");
        sb16.append(" = ");
        sb16.append(this.p);
        sb16.append(Part.CRLF);
        StringBuilder sb17 = this.u;
        sb17.append("cpu-rate");
        sb17.append(" = ");
        sb17.append(this.q);
        sb17.append(Part.CRLF);
        ArrayList<String> arrayList = this.s;
        if (arrayList != null && !arrayList.isEmpty()) {
            StringBuilder sb18 = new StringBuilder();
            Iterator<String> it = this.s.iterator();
            while (it.hasNext()) {
                sb18.append(it.next());
                sb18.append(Part.CRLF);
            }
            StringBuilder sb19 = this.w;
            sb19.append("stack");
            sb19.append(" = ");
            sb19.append(sb18.toString());
            sb19.append(Part.CRLF);
        }
        return this;
    }

    public a c(long j, long j2, long j3, long j4) {
        this.l = j2 - j;
        this.m = j4 - j3;
        this.n = Long.toString(j);
        this.o = Long.toString(j2);
        return this;
    }

    public a d(String str) {
        this.q = str;
        return this;
    }

    public a e(ArrayList<String> arrayList) {
        this.s = arrayList;
        return this;
    }

    public String toString() {
        return String.valueOf(this.t) + ((Object) this.v) + ((Object) this.u) + ((Object) this.w);
    }
}

package d.o.a.d.f;

import android.text.TextUtils;
import com.baidu.wallet.paysdk.banksign.datamodel.QueryResponse;
import com.kwai.video.player.KsMediaMeta;
import com.ss.android.downloadlib.activity.TTDelegateActivity;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import d.o.a.d.j;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public static c f67586a;

    /* renamed from: b  reason: collision with root package name */
    public static d f67587b;

    /* loaded from: classes6.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f67588a;

        static {
            int[] iArr = new int[com.ss.android.socialbase.downloader.network.l.values().length];
            f67588a = iArr;
            try {
                iArr[com.ss.android.socialbase.downloader.network.l.POOR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f67588a[com.ss.android.socialbase.downloader.network.l.MODERATE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f67588a[com.ss.android.socialbase.downloader.network.l.GOOD.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f67588a[com.ss.android.socialbase.downloader.network.l.EXCELLENT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f67588a[com.ss.android.socialbase.downloader.network.l.UNKNOWN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b implements d.o.a.e.b.g.i {

        /* renamed from: a  reason: collision with root package name */
        public final String f67589a;

        /* renamed from: b  reason: collision with root package name */
        public c f67590b;

        public b(c cVar, String str) {
            this.f67590b = cVar;
            this.f67589a = str;
        }

        @Override // d.o.a.e.b.g.i
        public int a(long j) {
            c cVar;
            if (!d.o.a.d.n.k.J(this.f67589a) || (cVar = this.f67590b) == null) {
                return 1;
            }
            return cVar.a(j);
        }
    }

    /* loaded from: classes6.dex */
    public static class d implements d.o.a.e.b.g.h {

        /* renamed from: a  reason: collision with root package name */
        public int f67593a;

        /* renamed from: b  reason: collision with root package name */
        public ArrayList<int[]> f67594b = new ArrayList<>();

        public d(JSONObject jSONObject) {
            b(jSONObject);
        }

        @Override // d.o.a.e.b.g.h
        public int a(int i, com.ss.android.socialbase.downloader.network.l lVar) {
            return c() ? d(i, lVar) : i;
        }

        public final void b(JSONObject jSONObject) {
            this.f67593a = jSONObject.optInt("is_open_exp", 0);
            e(jSONObject);
        }

        public boolean c() {
            int i = this.f67593a;
            return i == 2 || i == 3;
        }

        public final int d(int i, com.ss.android.socialbase.downloader.network.l lVar) {
            if (this.f67594b.size() < 5) {
                return i;
            }
            int[] iArr = null;
            int i2 = a.f67588a[lVar.ordinal()];
            if (i2 == 1) {
                iArr = this.f67594b.get(0);
            } else if (i2 == 2) {
                iArr = this.f67594b.get(1);
            } else if (i2 == 3) {
                iArr = this.f67594b.get(2);
            } else if (i2 == 4) {
                iArr = this.f67594b.get(3);
            } else if (i2 == 5) {
                iArr = this.f67594b.get(4);
            }
            if (iArr == null || iArr.length < 2) {
                return i;
            }
            int i3 = iArr[0];
            if (i3 == 1) {
                i += iArr[1];
            } else if (i3 == 2) {
                i -= iArr[1];
            } else if (i3 == 3) {
                i = iArr[1];
            }
            if (i > 1) {
                return i;
            }
            return 1;
        }

        public final void e(JSONObject jSONObject) {
            if (jSONObject == null || !jSONObject.has("download_chunk_config")) {
                return;
            }
            String obj = jSONObject.opt("download_chunk_config").toString();
            if (TextUtils.isEmpty(obj)) {
                return;
            }
            JSONObject jSONObject2 = null;
            try {
                jSONObject2 = new JSONObject(obj);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            if (jSONObject2 == null) {
                return;
            }
            String optString = jSONObject2.optString("network_quality_operation");
            String optString2 = jSONObject2.optString("network_quality_operand");
            if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                try {
                    String[] split = optString.split(",");
                    String[] split2 = optString2.split(",");
                    if (split.length >= 5 && split2.length >= 5) {
                        for (int i = 0; i < 5; i++) {
                            this.f67594b.add(new int[]{Integer.parseInt(split[i]), Integer.parseInt(split2[i])});
                        }
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements h {

        /* renamed from: a  reason: collision with root package name */
        public static d.o.a.d.f.a.c f67595a;

        /* loaded from: classes6.dex */
        public class a implements d.o.a.d.f.a.c {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ d.o.a.b.a.c.b f67596a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ InterfaceC1863g f67597b;

            public a(e eVar, d.o.a.b.a.c.b bVar, InterfaceC1863g interfaceC1863g) {
                this.f67596a = bVar;
                this.f67597b = interfaceC1863g;
            }

            @Override // d.o.a.d.f.a.c
            public void a() {
                d.o.a.d.f.a.c unused = e.f67595a = null;
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt("pause_optimise_type", "apk_size");
                    jSONObject.putOpt("pause_optimise_action", "confirm");
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                j.c.a().t("pause_optimise", jSONObject, this.f67596a);
            }

            @Override // d.o.a.d.f.a.c
            public void b() {
                d.o.a.d.f.a.c unused = e.f67595a = null;
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt("pause_optimise_type", "apk_size");
                    jSONObject.putOpt("pause_optimise_action", QueryResponse.Options.CANCEL);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                j.c.a().t("pause_optimise", jSONObject, this.f67596a);
                this.f67597b.a(this.f67596a);
            }
        }

        public static d.o.a.d.f.a.c c() {
            return f67595a;
        }

        public static String e(long j) {
            DecimalFormat decimalFormat = new DecimalFormat("0.00");
            if (j >= KsMediaMeta.AV_CH_STEREO_RIGHT) {
                return (j / KsMediaMeta.AV_CH_STEREO_RIGHT) + "G";
            } else if (j >= 1048576) {
                return (j / 1048576) + "M";
            } else {
                return decimalFormat.format(((float) j) / 1048576.0f) + "M";
            }
        }

        @Override // d.o.a.d.f.g.h
        public boolean a(d.o.a.b.a.c.b bVar, int i, InterfaceC1863g interfaceC1863g) {
            DownloadInfo c2;
            if (bVar == null || bVar.c0() || !f(bVar) || (c2 = d.o.a.d.l.b(null).c(bVar.a())) == null) {
                return false;
            }
            long b2 = m.b(c2.c0(), c2.E(), c2.Q0());
            long Q0 = c2.Q0();
            if (b2 <= 0 || Q0 <= 0 || Q0 > b(bVar.s())) {
                return false;
            }
            f67595a = new a(this, bVar, interfaceC1863g);
            TTDelegateActivity.a(bVar, String.format("该下载任务仅需%s，即将下载完成，是否继续下载？", e(Q0 - b2)), "继续", "暂停");
            bVar.a1(true);
            return true;
        }

        public final int b(int i) {
            return d.o.a.e.b.j.a.d(i).b("pause_optimise_apk_size", 100) * 1024 * 1024;
        }

        public final boolean f(d.o.a.b.a.c.a aVar) {
            return d.o.a.d.n.e.c(aVar).b("pause_optimise_apk_size_switch", 0) == 1 && aVar.q();
        }
    }

    /* loaded from: classes6.dex */
    public class f implements h {

        /* renamed from: a  reason: collision with root package name */
        public static d.o.a.d.f.a.c f67598a;

        /* loaded from: classes6.dex */
        public class a implements d.o.a.d.f.a.c {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ d.o.a.b.a.c.b f67599a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ InterfaceC1863g f67600b;

            public a(f fVar, d.o.a.b.a.c.b bVar, InterfaceC1863g interfaceC1863g) {
                this.f67599a = bVar;
                this.f67600b = interfaceC1863g;
            }

            @Override // d.o.a.d.f.a.c
            public void a() {
                d.o.a.d.f.a.c unused = f.f67598a = null;
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt("pause_optimise_type", "download_percent");
                    jSONObject.putOpt("pause_optimise_action", "confirm");
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                j.c.a().t("pause_optimise", jSONObject, this.f67599a);
            }

            @Override // d.o.a.d.f.a.c
            public void b() {
                d.o.a.d.f.a.c unused = f.f67598a = null;
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.putOpt("pause_optimise_type", "download_percent");
                    jSONObject.putOpt("pause_optimise_action", QueryResponse.Options.CANCEL);
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
                j.c.a().t("pause_optimise", jSONObject, this.f67599a);
                this.f67600b.a(this.f67599a);
            }
        }

        public static d.o.a.d.f.a.c c() {
            return f67598a;
        }

        @Override // d.o.a.d.f.g.h
        public boolean a(d.o.a.b.a.c.b bVar, int i, InterfaceC1863g interfaceC1863g) {
            DownloadInfo c2;
            if (bVar == null || bVar.d0() || !e(bVar) || (c2 = d.o.a.d.l.b(null).c(bVar.a())) == null) {
                return false;
            }
            long E = c2.E();
            long Q0 = c2.Q0();
            if (E > 0 && Q0 > 0) {
                int a2 = m.a(c2.c0(), (int) ((E * 100) / Q0));
                if (a2 > b(bVar.s())) {
                    f67598a = new a(this, bVar, interfaceC1863g);
                    TTDelegateActivity.b(bVar, String.format("已下载%s%%，即将下载完成，是否继续下载？", Integer.valueOf(a2)), "继续", "暂停");
                    bVar.b1(true);
                    return true;
                }
            }
            return false;
        }

        public final int b(int i) {
            return d.o.a.e.b.j.a.d(i).b("pause_optimise_download_percent", 50);
        }

        public final boolean e(d.o.a.b.a.c.a aVar) {
            return d.o.a.d.n.e.c(aVar).b("pause_optimise_download_percent_switch", 0) == 1 && aVar.q();
        }
    }

    /* renamed from: d.o.a.d.f.g$g  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public interface InterfaceC1863g {
        void a(d.o.a.b.a.c.b bVar);
    }

    /* loaded from: classes6.dex */
    public interface h {
        boolean a(d.o.a.b.a.c.b bVar, int i, InterfaceC1863g interfaceC1863g);
    }

    /* loaded from: classes6.dex */
    public class i implements h {
        @Override // d.o.a.d.f.g.h
        public boolean a(d.o.a.b.a.c.b bVar, int i, InterfaceC1863g interfaceC1863g) {
            if (bVar != null && c(bVar.s())) {
                if (System.currentTimeMillis() - bVar.O() <= b(bVar.s())) {
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.putOpt("pause_optimise_type", "mistake_click");
                    } catch (JSONException e2) {
                        e2.printStackTrace();
                    }
                    j.c.a().t("pause_optimise", jSONObject, bVar);
                    return true;
                }
                return false;
            }
            return false;
        }

        public final long b(int i) {
            return d.o.a.e.b.j.a.d(i).b("pause_optimise_mistake_click_interval", 300);
        }

        public final boolean c(int i) {
            return d.o.a.e.b.j.a.d(i).b("pause_optimise_mistake_click_interval_switch", 0) == 1;
        }
    }

    /* loaded from: classes6.dex */
    public class j {

        /* renamed from: b  reason: collision with root package name */
        public static j f67601b;

        /* renamed from: a  reason: collision with root package name */
        public List<h> f67602a;

        public j() {
            ArrayList arrayList = new ArrayList();
            this.f67602a = arrayList;
            arrayList.add(new i());
            this.f67602a.add(new k());
            this.f67602a.add(new f());
            this.f67602a.add(new e());
        }

        public static j a() {
            if (f67601b == null) {
                synchronized (j.class) {
                    if (f67601b == null) {
                        f67601b = new j();
                    }
                }
            }
            return f67601b;
        }

        public void b(d.o.a.b.a.c.b bVar, int i, InterfaceC1863g interfaceC1863g) {
            List<h> list = this.f67602a;
            if (list != null && list.size() != 0 && bVar != null) {
                DownloadInfo c2 = d.o.a.d.l.b(null).c(bVar.a());
                if (c2 != null && "application/vnd.android.package-archive".equals(c2.m0())) {
                    boolean z = d.o.a.e.b.j.a.d(bVar.s()).b("pause_optimise_switch", 0) == 1;
                    for (h hVar : this.f67602a) {
                        if (z || (hVar instanceof k)) {
                            if (hVar.a(bVar, i, interfaceC1863g)) {
                                return;
                            }
                        }
                    }
                    interfaceC1863g.a(bVar);
                    return;
                }
                interfaceC1863g.a(bVar);
                return;
            }
            interfaceC1863g.a(bVar);
        }
    }

    /* loaded from: classes6.dex */
    public class k implements h {
        @Override // d.o.a.d.f.g.h
        public boolean a(d.o.a.b.a.c.b bVar, int i, InterfaceC1863g interfaceC1863g) {
            if (bVar == null) {
                return false;
            }
            return p.d(bVar, d.o.a.d.l.b(null).c(bVar.a()), i, interfaceC1863g);
        }
    }

    public static d.o.a.e.b.g.h a() {
        if (f67587b == null) {
            f67587b = new d(n.s());
        }
        return f67587b;
    }

    public static d.o.a.e.b.g.h b(JSONObject jSONObject) {
        if (jSONObject == null || !jSONObject.has("download_chunk_config") || d.o.a.e.b.j.a.w("download_chunk_config")) {
            return null;
        }
        return f(jSONObject);
    }

    public static d.o.a.e.b.g.i c(String str) {
        if (f67586a == null) {
            f67586a = new c(n.s());
        }
        return new b(f67586a, str);
    }

    public static d.o.a.e.b.g.i d(String str, JSONObject jSONObject) {
        if (jSONObject != null && jSONObject.has("download_chunk_config") && !d.o.a.e.b.j.a.w("download_chunk_config")) {
            return e(jSONObject);
        }
        return c(str);
    }

    public static d.o.a.e.b.g.i e(JSONObject jSONObject) {
        return new c(jSONObject);
    }

    public static d.o.a.e.b.g.h f(JSONObject jSONObject) {
        return new d(jSONObject);
    }

    /* loaded from: classes6.dex */
    public static class c implements d.o.a.e.b.g.i {

        /* renamed from: a  reason: collision with root package name */
        public int f67591a;

        /* renamed from: b  reason: collision with root package name */
        public ArrayList<int[]> f67592b = new ArrayList<>();

        public c(JSONObject jSONObject) {
            b(jSONObject);
        }

        @Override // d.o.a.e.b.g.i
        public int a(long j) {
            if (c() && e(j)) {
                return a((int) (j / 1048576));
            }
            return 1;
        }

        public final void b(JSONObject jSONObject) {
            this.f67591a = jSONObject.optInt("is_open_exp", 0);
            d(jSONObject);
        }

        public boolean c() {
            int i = this.f67591a;
            return i == 1 || i == 3;
        }

        public final void d(JSONObject jSONObject) {
            if (jSONObject == null || !jSONObject.has("download_chunk_config")) {
                return;
            }
            String obj = jSONObject.opt("download_chunk_config").toString();
            if (TextUtils.isEmpty(obj)) {
                return;
            }
            JSONObject jSONObject2 = null;
            try {
                jSONObject2 = new JSONObject(obj);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            if (jSONObject2 == null) {
                return;
            }
            String[] strArr = new String[5];
            String[][] strArr2 = new String[5];
            strArr[1] = jSONObject2.optString("download_chunk_1");
            strArr[2] = jSONObject2.optString("download_chunk_2");
            strArr[3] = jSONObject2.optString("download_chunk_3");
            strArr[4] = jSONObject2.optString("download_chunk_4");
            for (int i = 1; i < 5; i++) {
                if (!TextUtils.isEmpty(strArr[i])) {
                    try {
                        strArr2[i] = strArr[i].split(",");
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                    for (int i2 = 0; i2 < strArr2[i].length - 1; i2 += 2) {
                        try {
                            this.f67592b.add(new int[]{i, Integer.parseInt(strArr2[i][i2]), Integer.parseInt(strArr2[i][i2 + 1])});
                        } catch (Throwable th2) {
                            th2.printStackTrace();
                        }
                    }
                }
            }
        }

        public boolean e(long j) {
            return true;
        }

        public final int a(int i) {
            for (int i2 = 0; i2 < this.f67592b.size(); i2++) {
                int[] iArr = this.f67592b.get(i2);
                if (i >= iArr[1] && i < iArr[2]) {
                    return iArr[0];
                }
            }
            return 1;
        }
    }
}

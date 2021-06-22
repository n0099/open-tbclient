package d.a.o0.q.e;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.ad.download.mvp.IDownloadModel;
import com.baidu.tieba.ad.download.state.DownloadStatus;
import com.baidu.tieba.recapp.constants.Cmatch;
import d.a.o0.t2.y;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.App;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public final d.a.o0.t2.c0.l.a f62049a;

    /* renamed from: b  reason: collision with root package name */
    public final int f62050b;

    /* renamed from: c  reason: collision with root package name */
    public final int f62051c;

    /* renamed from: d  reason: collision with root package name */
    public final int f62052d;

    /* renamed from: e  reason: collision with root package name */
    public final List<String> f62053e;

    /* renamed from: f  reason: collision with root package name */
    public final List<d.a.o0.t2.c0.l.b> f62054f;

    /* loaded from: classes4.dex */
    public class b extends BdAsyncTask<Integer, Integer, Void> {
        public b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Void doInBackground(Integer... numArr) {
            if (numArr == null || numArr.length <= 1 || numArr[0] == null || numArr[1] == null) {
                return null;
            }
            a.this.f62049a.c(numArr[0], numArr[1]);
            return null;
        }
    }

    /* loaded from: classes4.dex */
    public class c extends BdAsyncTask<String, Integer, Void> {
        public c() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        public Void doInBackground(String... strArr) {
            if (strArr == null || strArr.length <= 0 || strArr[0] == null) {
                return null;
            }
            a.this.f62049a.d(strArr[0]);
            return null;
        }
    }

    /* loaded from: classes4.dex */
    public class d extends BdAsyncTask<Integer, Integer, List<d.a.o0.t2.c0.l.b>> {
        public d() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public List<d.a.o0.t2.c0.l.b> doInBackground(Integer... numArr) {
            if (numArr == null || numArr.length <= 1 || numArr[0] == null || numArr[1] == null) {
                return null;
            }
            return a.this.f62049a.f(numArr[0], numArr[1]);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(List<d.a.o0.t2.c0.l.b> list) {
            super.onPostExecute(list);
            if (d.a.o0.k1.o.k.a.e(list)) {
                return;
            }
            a.this.f62054f.addAll(list);
        }
    }

    /* loaded from: classes4.dex */
    public static class e {

        /* renamed from: a  reason: collision with root package name */
        public static final a f62058a = new a();
    }

    /* loaded from: classes4.dex */
    public class f extends BdAsyncTask<d.a.o0.t2.c0.l.b, Integer, Void> {
        public f() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Void doInBackground(d.a.o0.t2.c0.l.b... bVarArr) {
            if (bVarArr == null || bVarArr.length <= 0 || bVarArr[0] == null) {
                return null;
            }
            a.this.f62049a.g(bVarArr[0]);
            return null;
        }
    }

    public static String g(AdvertAppInfo advertAppInfo) {
        AdvertAppInfo.ILegoAdvert iLegoAdvert;
        if (advertAppInfo == null || (iLegoAdvert = advertAppInfo.R3) == null) {
            return null;
        }
        return iLegoAdvert.getDownloadKey();
    }

    public static a i() {
        return e.f62058a;
    }

    public final d.a.o0.t2.c0.l.b c(IDownloadModel iDownloadModel) {
        d.a.o0.t2.c0.l.b bVar = new d.a.o0.t2.c0.l.b();
        bVar.f64793f = iDownloadModel.getAppJson();
        bVar.f64789b = iDownloadModel.getPkgName();
        bVar.f64788a = iDownloadModel.getDownloadKey();
        bVar.f64791d = 0;
        bVar.f64792e = System.currentTimeMillis();
        bVar.f64790c = System.currentTimeMillis();
        return bVar;
    }

    public final boolean d(@NonNull Cmatch cmatch) {
        d.a.o0.t2.c0.l.b bVar;
        if (!this.f62053e.contains(cmatch.value) || d.a.o0.k1.o.k.a.e(this.f62054f) || (bVar = (d.a.o0.t2.c0.l.b) d.a.o0.k1.o.k.a.d(this.f62054f, 0)) == null) {
            return false;
        }
        return this.f62051c <= ((int) ((System.currentTimeMillis() - bVar.f64792e) / 60000));
    }

    public final void e(String str) {
        new c().execute(str);
    }

    public final void f(String str) {
        Iterator<d.a.o0.t2.c0.l.b> it = this.f62054f.iterator();
        while (it.hasNext()) {
            if (TextUtils.equals(it.next().f64788a, str)) {
                it.remove();
            }
        }
        e(str);
    }

    public final App h(@NonNull App app, @NonNull Cmatch cmatch) {
        d.a.o0.t2.c0.l.b bVar;
        if (d.a.o0.k1.o.k.a.e(this.f62054f)) {
            return null;
        }
        Iterator<d.a.o0.t2.c0.l.b> it = this.f62054f.iterator();
        while (true) {
            if (!it.hasNext()) {
                bVar = null;
                break;
            }
            bVar = it.next();
            if (!y.q(bVar.f64789b)) {
                break;
            }
            bVar.f64795h = 2;
            o(bVar);
            it.remove();
        }
        if (bVar == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(bVar.f64793f);
            jSONObject.put("pos_name", app.pos_name);
            App parseFromJson = App.parseFromJson(jSONObject);
            if (j(cmatch, parseFromJson)) {
                return parseFromJson;
            }
            return null;
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public final boolean j(Cmatch cmatch, App app) {
        if (cmatch == Cmatch.PB_BANNER && d.a.o0.t2.a.h(app) == 14 && !d.a.o0.t2.a.o(app)) {
            return false;
        }
        if (cmatch == Cmatch.VIDEO_PB_COMMENT) {
            return (d.a.o0.t2.a.h(app) == 14 || d.a.o0.t2.a.h(app) == 7) ? false : true;
        }
        return true;
    }

    public void k(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        for (d.a.o0.t2.c0.l.b bVar : this.f62054f) {
            if (bVar != null && TextUtils.equals(bVar.f64788a, str)) {
                p(bVar);
            }
        }
    }

    public void l(DownloadStatus downloadStatus, IDownloadModel iDownloadModel) {
        if (TextUtils.isEmpty(iDownloadModel.getDownloadKey()) || TextUtils.isEmpty(iDownloadModel.getPkgName())) {
            return;
        }
        d.a.o0.t2.c0.l.b c2 = c(iDownloadModel);
        if (downloadStatus == DownloadStatus.STATUS_INSTALL_SUCCESS) {
            c2.f64795h = 2;
            this.f62054f.remove(c2);
        } else {
            c2.f64795h = 1;
            if (!this.f62054f.contains(c2)) {
                this.f62054f.add(0, c2);
            }
        }
        o(c2);
    }

    public final void m(int i2, int i3) {
        try {
            new d().execute(Integer.valueOf(i2), Integer.valueOf(i3));
        } catch (Exception unused) {
        }
    }

    public App n(App app, Cmatch cmatch) {
        if (d(cmatch) && app != null && d.a.o0.t2.a.m(app)) {
            return h(app, cmatch);
        }
        return null;
    }

    public final void o(d.a.o0.t2.c0.l.b bVar) {
        new f().execute(bVar);
    }

    public final void p(@NonNull d.a.o0.t2.c0.l.b bVar) {
        int i2 = bVar.f64791d + 1;
        bVar.f64791d = i2;
        if (i2 >= this.f62050b) {
            f(bVar.f64788a);
            return;
        }
        bVar.f64792e = System.currentTimeMillis();
        o(bVar);
    }

    public a() {
        this.f62049a = d.a.o0.t2.c0.l.a.e();
        this.f62050b = d.a.o0.a.h().f();
        this.f62051c = d.a.o0.a.h().e();
        this.f62052d = d.a.o0.a.h().d();
        String g2 = d.a.o0.a.h().g();
        if (TextUtils.isEmpty(g2)) {
            this.f62053e = new ArrayList();
        } else {
            this.f62053e = Arrays.asList(g2.split("_"));
        }
        this.f62054f = Collections.synchronizedList(new ArrayList());
        m(this.f62052d, this.f62050b);
        new b().execute(Integer.valueOf(this.f62052d), Integer.valueOf(this.f62050b));
    }
}

package d.a.n0.q.e;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.ad.download.mvp.IDownloadModel;
import com.baidu.tieba.ad.download.state.DownloadStatus;
import com.baidu.tieba.recapp.constants.Cmatch;
import d.a.n0.t2.y;
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
    public final d.a.n0.t2.c0.l.a f58233a;

    /* renamed from: b  reason: collision with root package name */
    public final int f58234b;

    /* renamed from: c  reason: collision with root package name */
    public final int f58235c;

    /* renamed from: d  reason: collision with root package name */
    public final int f58236d;

    /* renamed from: e  reason: collision with root package name */
    public final List<String> f58237e;

    /* renamed from: f  reason: collision with root package name */
    public final List<d.a.n0.t2.c0.l.b> f58238f;

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
            a.this.f58233a.c(numArr[0], numArr[1]);
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
            a.this.f58233a.d(strArr[0]);
            return null;
        }
    }

    /* loaded from: classes4.dex */
    public class d extends BdAsyncTask<Integer, Integer, List<d.a.n0.t2.c0.l.b>> {
        public d() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public List<d.a.n0.t2.c0.l.b> doInBackground(Integer... numArr) {
            if (numArr == null || numArr.length <= 1 || numArr[0] == null || numArr[1] == null) {
                return null;
            }
            return a.this.f58233a.f(numArr[0], numArr[1]);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(List<d.a.n0.t2.c0.l.b> list) {
            super.onPostExecute(list);
            if (d.a.n0.k1.o.k.a.e(list)) {
                return;
            }
            a.this.f58238f.addAll(list);
        }
    }

    /* loaded from: classes4.dex */
    public static class e {

        /* renamed from: a  reason: collision with root package name */
        public static final a f58242a = new a();
    }

    /* loaded from: classes4.dex */
    public class f extends BdAsyncTask<d.a.n0.t2.c0.l.b, Integer, Void> {
        public f() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public Void doInBackground(d.a.n0.t2.c0.l.b... bVarArr) {
            if (bVarArr == null || bVarArr.length <= 0 || bVarArr[0] == null) {
                return null;
            }
            a.this.f58233a.g(bVarArr[0]);
            return null;
        }
    }

    public static String g(AdvertAppInfo advertAppInfo) {
        AdvertAppInfo.ILegoAdvert iLegoAdvert;
        if (advertAppInfo == null || (iLegoAdvert = advertAppInfo.O3) == null) {
            return null;
        }
        return iLegoAdvert.getDownloadKey();
    }

    public static a i() {
        return e.f58242a;
    }

    public final d.a.n0.t2.c0.l.b c(IDownloadModel iDownloadModel) {
        d.a.n0.t2.c0.l.b bVar = new d.a.n0.t2.c0.l.b();
        bVar.f60976f = iDownloadModel.getAppJson();
        bVar.f60972b = iDownloadModel.getPkgName();
        bVar.f60971a = iDownloadModel.getDownloadKey();
        bVar.f60974d = 0;
        bVar.f60975e = System.currentTimeMillis();
        bVar.f60973c = System.currentTimeMillis();
        return bVar;
    }

    public final boolean d(@NonNull Cmatch cmatch) {
        d.a.n0.t2.c0.l.b bVar;
        if (!this.f58237e.contains(cmatch.value) || d.a.n0.k1.o.k.a.e(this.f58238f) || (bVar = (d.a.n0.t2.c0.l.b) d.a.n0.k1.o.k.a.d(this.f58238f, 0)) == null) {
            return false;
        }
        return this.f58235c <= ((int) ((System.currentTimeMillis() - bVar.f60975e) / 60000));
    }

    public final void e(String str) {
        new c().execute(str);
    }

    public final void f(String str) {
        Iterator<d.a.n0.t2.c0.l.b> it = this.f58238f.iterator();
        while (it.hasNext()) {
            if (TextUtils.equals(it.next().f60971a, str)) {
                it.remove();
            }
        }
        e(str);
    }

    public final App h(@NonNull App app, @NonNull Cmatch cmatch) {
        d.a.n0.t2.c0.l.b bVar;
        if (d.a.n0.k1.o.k.a.e(this.f58238f)) {
            return null;
        }
        Iterator<d.a.n0.t2.c0.l.b> it = this.f58238f.iterator();
        while (true) {
            if (!it.hasNext()) {
                bVar = null;
                break;
            }
            bVar = it.next();
            if (!y.q(bVar.f60972b)) {
                break;
            }
            bVar.f60978h = 2;
            o(bVar);
            it.remove();
        }
        if (bVar == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(bVar.f60976f);
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
        if (cmatch == Cmatch.PB_BANNER && d.a.n0.t2.a.h(app) == 14 && !d.a.n0.t2.a.o(app)) {
            return false;
        }
        if (cmatch == Cmatch.VIDEO_PB_COMMENT) {
            return (d.a.n0.t2.a.h(app) == 14 || d.a.n0.t2.a.h(app) == 7) ? false : true;
        }
        return true;
    }

    public void k(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        for (d.a.n0.t2.c0.l.b bVar : this.f58238f) {
            if (bVar != null && TextUtils.equals(bVar.f60971a, str)) {
                p(bVar);
            }
        }
    }

    public void l(DownloadStatus downloadStatus, IDownloadModel iDownloadModel) {
        if (TextUtils.isEmpty(iDownloadModel.getDownloadKey()) || TextUtils.isEmpty(iDownloadModel.getPkgName())) {
            return;
        }
        d.a.n0.t2.c0.l.b c2 = c(iDownloadModel);
        if (downloadStatus == DownloadStatus.STATUS_INSTALL_SUCCESS) {
            c2.f60978h = 2;
            this.f58238f.remove(c2);
        } else {
            c2.f60978h = 1;
            if (!this.f58238f.contains(c2)) {
                this.f58238f.add(0, c2);
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
        if (d(cmatch) && app != null && d.a.n0.t2.a.m(app)) {
            return h(app, cmatch);
        }
        return null;
    }

    public final void o(d.a.n0.t2.c0.l.b bVar) {
        new f().execute(bVar);
    }

    public final void p(@NonNull d.a.n0.t2.c0.l.b bVar) {
        int i2 = bVar.f60974d + 1;
        bVar.f60974d = i2;
        if (i2 >= this.f58234b) {
            f(bVar.f60971a);
            return;
        }
        bVar.f60975e = System.currentTimeMillis();
        o(bVar);
    }

    public a() {
        this.f58233a = d.a.n0.t2.c0.l.a.e();
        this.f58234b = d.a.n0.a.h().f();
        this.f58235c = d.a.n0.a.h().e();
        this.f58236d = d.a.n0.a.h().d();
        String g2 = d.a.n0.a.h().g();
        if (TextUtils.isEmpty(g2)) {
            this.f58237e = new ArrayList();
        } else {
            this.f58237e = Arrays.asList(g2.split("_"));
        }
        this.f58238f = Collections.synchronizedList(new ArrayList());
        m(this.f58236d, this.f58234b);
        new b().execute(Integer.valueOf(this.f58236d), Integer.valueOf(this.f58234b));
    }
}

package d.a.l0.a.n0.l;

import android.database.Cursor;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.mobads.container.adrequest.AdParamInfo;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.xiaomi.mipush.sdk.Constants;
import d.a.l0.a.j2.k;
import d.a.l0.a.j2.p.e;
import d.a.l0.a.n0.l.b;
import d.a.l0.a.v2.k0;
import d.a.l0.t.d;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class c implements b {

    /* renamed from: e  reason: collision with root package name */
    public final b.C0763b f43684e;

    /* loaded from: classes2.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.f();
        }
    }

    public c(b.C0763b c0763b) {
        this.f43684e = c0763b == null ? new b.C0763b() : c0763b;
    }

    public static boolean d(b.a aVar) {
        return aVar != null && aVar.isValid();
    }

    public static c l() {
        return m(null);
    }

    public static c m(b.C0763b c0763b) {
        return new c(c0763b);
    }

    public c b(@Nullable String str) {
        if (e() && !TextUtils.isEmpty(str) && !d(this.f43684e.f43680a.get(str))) {
            d.a.l0.a.n0.l.a c2 = d.a.l0.a.n0.l.a.c(str);
            if (d(c2)) {
                this.f43684e.f43680a.put(c2.a(), c2);
            }
        }
        return this;
    }

    public int c() {
        b.C0763b c0763b = this.f43684e;
        int i2 = c0763b.f43683d;
        return i2 == 0 ? c0763b.f43682c : i2;
    }

    public boolean e() {
        boolean z;
        synchronized (this.f43684e) {
            z = this.f43684e.f43681b;
        }
        return z;
    }

    public final void f() {
        String str;
        b.a value;
        synchronized (this.f43684e) {
            if (e()) {
                this.f43684e.f43681b = false;
                e eVar = new e();
                eVar.f43185a = "swan";
                eVar.f43187c = AdParamInfo.AdClickActionString.AD_CLICK_ACTION_NA;
                int c2 = c();
                eVar.f43186b = String.valueOf(c2);
                JSONArray jSONArray = new JSONArray();
                for (Map.Entry<String, b.a> entry : this.f43684e.f43680a.entrySet()) {
                    if (!TextUtils.isEmpty(entry.getKey()) && (value = entry.getValue()) != null && value.isValid()) {
                        jSONArray.put(value.b());
                    }
                }
                eVar.a("purged_list", jSONArray);
                if (7 == c2) {
                    eVar.a("history_list", h());
                    eVar.a("disk_size", g());
                }
                if (b.G0) {
                    JSONObject f2 = eVar.f();
                    if (f2 == null) {
                        str = StringUtil.NULL_STRING;
                    } else {
                        try {
                            str = f2.toString(4);
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                            str = "" + eVar;
                        }
                    }
                    BufferedReader bufferedReader = new BufferedReader(new StringReader(str));
                    while (true) {
                        try {
                            try {
                                String readLine = bufferedReader.readLine();
                                if (readLine == null) {
                                    break;
                                }
                                Log.i("PurgerStatistic", "report event => " + readLine);
                            } catch (IOException e3) {
                                e3.printStackTrace();
                            }
                        } finally {
                            d.d(bufferedReader);
                        }
                    }
                }
                k.u("1377", eVar);
            }
        }
    }

    @NonNull
    public final JSONObject g() {
        JSONObject jSONObject = new JSONObject();
        int a2 = k0.a();
        int i2 = d.a.l0.a.k2.b.i();
        int b2 = d.a.l0.a.k2.b.b();
        int k = d.a.l0.a.k2.b.k();
        try {
            jSONObject.put("device", a2);
            jSONObject.put("swan_pkg", i2);
            jSONObject.put("app_pkg", b2);
            jSONObject.put("app_third", k);
        } catch (JSONException e2) {
            if (b.G0) {
                e2.printStackTrace();
                Log.i("PurgerStatistic", "queryDiskSize: e=" + e2);
            }
        }
        return jSONObject;
    }

    @NonNull
    public final JSONArray h() {
        JSONArray jSONArray = new JSONArray();
        try {
            Cursor l = d.a.l0.a.j0.c.b.l();
            int count = l.getCount();
            while (l.moveToNext()) {
                String string = l.getString(l.getColumnIndex(Constants.APP_ID));
                long j = l.getLong(l.getColumnIndex("visit_time"));
                if (!TextUtils.isEmpty(string)) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(IntentConfig.PKG_ID, string);
                    jSONObject.put("last_launch_time", j);
                    jSONArray.put(jSONObject);
                }
            }
            if (b.G0) {
                Log.i("PurgerStatistic", "queryHisList: cursor=" + count + " items=" + jSONArray.length());
            }
            if (l != null) {
                l.close();
            }
        } catch (JSONException e2) {
            if (b.G0) {
                e2.printStackTrace();
                Log.i("PurgerStatistic", "queryHisList: e=" + e2);
            }
        }
        return jSONArray;
    }

    public c i(int i2) {
        b.C0763b c0763b;
        int i3;
        if (e() && i2 != (i3 = (c0763b = this.f43684e).f43683d) && (i3 == 0 || i3 == c0763b.f43682c)) {
            this.f43684e.f43683d = i2;
        }
        return this;
    }

    public void j() {
        if (b.G0) {
            Log.i("PurgerStatistic", "performReport: " + this.f43684e);
        }
        if (e()) {
            ExecutorUtilsExt.postOnElastic(new a(), "PurgerStatistic", 3);
        }
    }

    public b.C0763b k() {
        return this.f43684e;
    }

    public c n(int i2) {
        if (e()) {
            this.f43684e.f43682c = i2;
        }
        return this;
    }
}

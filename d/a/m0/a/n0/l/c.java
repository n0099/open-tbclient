package d.a.m0.a.n0.l;

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
import d.a.m0.a.j2.k;
import d.a.m0.a.j2.p.e;
import d.a.m0.a.n0.l.b;
import d.a.m0.a.v2.k0;
import d.a.m0.t.d;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public final class c implements b {

    /* renamed from: e  reason: collision with root package name */
    public final b.C0822b f47468e;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.f();
        }
    }

    public c(b.C0822b c0822b) {
        this.f47468e = c0822b == null ? new b.C0822b() : c0822b;
    }

    public static boolean d(b.a aVar) {
        return aVar != null && aVar.isValid();
    }

    public static c l() {
        return m(null);
    }

    public static c m(b.C0822b c0822b) {
        return new c(c0822b);
    }

    public c b(@Nullable String str) {
        if (e() && !TextUtils.isEmpty(str) && !d(this.f47468e.f47464a.get(str))) {
            d.a.m0.a.n0.l.a c2 = d.a.m0.a.n0.l.a.c(str);
            if (d(c2)) {
                this.f47468e.f47464a.put(c2.a(), c2);
            }
        }
        return this;
    }

    public int c() {
        b.C0822b c0822b = this.f47468e;
        int i2 = c0822b.f47467d;
        return i2 == 0 ? c0822b.f47466c : i2;
    }

    public boolean e() {
        boolean z;
        synchronized (this.f47468e) {
            z = this.f47468e.f47465b;
        }
        return z;
    }

    public final void f() {
        String str;
        b.a value;
        synchronized (this.f47468e) {
            if (e()) {
                this.f47468e.f47465b = false;
                e eVar = new e();
                eVar.f46969a = "swan";
                eVar.f46971c = AdParamInfo.AdClickActionString.AD_CLICK_ACTION_NA;
                int c2 = c();
                eVar.f46970b = String.valueOf(c2);
                JSONArray jSONArray = new JSONArray();
                for (Map.Entry<String, b.a> entry : this.f47468e.f47464a.entrySet()) {
                    if (!TextUtils.isEmpty(entry.getKey()) && (value = entry.getValue()) != null && value.isValid()) {
                        jSONArray.put(value.b());
                    }
                }
                eVar.a("purged_list", jSONArray);
                if (7 == c2) {
                    eVar.a("history_list", h());
                    eVar.a("disk_size", g());
                }
                if (b.e0) {
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
        int i2 = d.a.m0.a.k2.b.i();
        int b2 = d.a.m0.a.k2.b.b();
        int k = d.a.m0.a.k2.b.k();
        try {
            jSONObject.put("device", a2);
            jSONObject.put("swan_pkg", i2);
            jSONObject.put("app_pkg", b2);
            jSONObject.put("app_third", k);
        } catch (JSONException e2) {
            if (b.e0) {
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
            Cursor l = d.a.m0.a.j0.c.b.l();
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
            if (b.e0) {
                Log.i("PurgerStatistic", "queryHisList: cursor=" + count + " items=" + jSONArray.length());
            }
            if (l != null) {
                l.close();
            }
        } catch (JSONException e2) {
            if (b.e0) {
                e2.printStackTrace();
                Log.i("PurgerStatistic", "queryHisList: e=" + e2);
            }
        }
        return jSONArray;
    }

    public c i(int i2) {
        b.C0822b c0822b;
        int i3;
        if (e() && i2 != (i3 = (c0822b = this.f47468e).f47467d) && (i3 == 0 || i3 == c0822b.f47466c)) {
            this.f47468e.f47467d = i2;
        }
        return this;
    }

    public void j() {
        if (b.e0) {
            Log.i("PurgerStatistic", "performReport: " + this.f47468e);
        }
        if (e()) {
            ExecutorUtilsExt.postOnElastic(new a(), "PurgerStatistic", 3);
        }
    }

    public b.C0822b k() {
        return this.f47468e;
    }

    public c n(int i2) {
        if (e()) {
            this.f47468e.f47466c = i2;
        }
        return this;
    }
}

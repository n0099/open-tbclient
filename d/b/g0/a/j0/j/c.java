package d.b.g0.a.j0.j;

import android.database.Cursor;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.xiaomi.mipush.sdk.Constants;
import d.b.g0.a.j0.j.b;
import d.b.g0.a.z1.h;
import d.b.g0.a.z1.k.e;
import d.b.g0.p.d;
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
    public final b.C0707b f44868e;

    /* loaded from: classes3.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.f();
        }
    }

    public c(b.C0707b c0707b) {
        this.f44868e = c0707b == null ? new b.C0707b() : c0707b;
    }

    public static boolean d(b.a aVar) {
        return aVar != null && aVar.isValid();
    }

    public static c k() {
        return l(null);
    }

    public static c l(b.C0707b c0707b) {
        return new c(c0707b);
    }

    public c b(@Nullable String str) {
        if (e() && !TextUtils.isEmpty(str) && !d(this.f44868e.f44864a.get(str))) {
            d.b.g0.a.j0.j.a c2 = d.b.g0.a.j0.j.a.c(str);
            if (d(c2)) {
                this.f44868e.f44864a.put(c2.a(), c2);
            }
        }
        return this;
    }

    public int c() {
        b.C0707b c0707b = this.f44868e;
        int i = c0707b.f44867d;
        return i == 0 ? c0707b.f44866c : i;
    }

    public boolean e() {
        boolean z;
        synchronized (this.f44868e) {
            z = this.f44868e.f44865b;
        }
        return z;
    }

    public final void f() {
        String str;
        b.a value;
        synchronized (this.f44868e) {
            if (e()) {
                this.f44868e.f44865b = false;
                e eVar = new e();
                eVar.f47250a = "swan";
                eVar.f47252c = "NA";
                int c2 = c();
                eVar.f47251b = String.valueOf(c2);
                JSONArray jSONArray = new JSONArray();
                for (Map.Entry<String, b.a> entry : this.f44868e.f44864a.entrySet()) {
                    if (!TextUtils.isEmpty(entry.getKey()) && (value = entry.getValue()) != null && value.isValid()) {
                        jSONArray.put(value.b());
                    }
                }
                eVar.a("purged_list", jSONArray);
                if (7 == c2) {
                    eVar.a("history_list", g());
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
                            d.a(bufferedReader);
                        }
                    }
                }
                h.u("1377", eVar);
            }
        }
    }

    @NonNull
    public final JSONArray g() {
        JSONArray jSONArray = new JSONArray();
        try {
            Cursor m = d.b.g0.a.g0.d.b.m("", 400);
            int count = m.getCount();
            while (m.moveToNext()) {
                String string = m.getString(m.getColumnIndex(Constants.APP_ID));
                if (!TextUtils.isEmpty(string)) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(IntentConfig.PKG_ID, string);
                    jSONArray.put(jSONObject);
                }
            }
            if (b.G0) {
                Log.i("PurgerStatistic", "queryHisList: cursor=" + count + " items=" + jSONArray.length());
            }
            if (m != null) {
                m.close();
            }
        } catch (JSONException e2) {
            if (b.G0) {
                e2.printStackTrace();
                Log.i("PurgerStatistic", "queryHisList: e=" + e2);
            }
        }
        return jSONArray;
    }

    public c h(int i) {
        b.C0707b c0707b;
        int i2;
        if (e() && i != (i2 = (c0707b = this.f44868e).f44867d) && (i2 == 0 || i2 == c0707b.f44866c)) {
            this.f44868e.f44867d = i;
        }
        return this;
    }

    public void i() {
        if (b.G0) {
            Log.i("PurgerStatistic", "performReport: " + this.f44868e);
        }
        if (e()) {
            ExecutorUtilsExt.postOnElastic(new a(), "PurgerStatistic", 3);
        }
    }

    public b.C0707b j() {
        return this.f44868e;
    }

    public c m(int i) {
        if (e()) {
            this.f44868e.f44866c = i;
        }
        return this;
    }
}

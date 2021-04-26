package d.a.h0.a.j0.j;

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
import d.a.h0.a.j0.j.b;
import d.a.h0.a.z1.h;
import d.a.h0.a.z1.k.e;
import d.a.h0.p.d;
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
    public final b.C0679b f42913e;

    /* loaded from: classes2.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.f();
        }
    }

    public c(b.C0679b c0679b) {
        this.f42913e = c0679b == null ? new b.C0679b() : c0679b;
    }

    public static boolean d(b.a aVar) {
        return aVar != null && aVar.isValid();
    }

    public static c k() {
        return l(null);
    }

    public static c l(b.C0679b c0679b) {
        return new c(c0679b);
    }

    public c b(@Nullable String str) {
        if (e() && !TextUtils.isEmpty(str) && !d(this.f42913e.f42909a.get(str))) {
            d.a.h0.a.j0.j.a c2 = d.a.h0.a.j0.j.a.c(str);
            if (d(c2)) {
                this.f42913e.f42909a.put(c2.a(), c2);
            }
        }
        return this;
    }

    public int c() {
        b.C0679b c0679b = this.f42913e;
        int i2 = c0679b.f42912d;
        return i2 == 0 ? c0679b.f42911c : i2;
    }

    public boolean e() {
        boolean z;
        synchronized (this.f42913e) {
            z = this.f42913e.f42910b;
        }
        return z;
    }

    public final void f() {
        String str;
        b.a value;
        synchronized (this.f42913e) {
            if (e()) {
                this.f42913e.f42910b = false;
                e eVar = new e();
                eVar.f45411a = "swan";
                eVar.f45413c = AdParamInfo.AdClickActionString.AD_CLICK_ACTION_NA;
                int c2 = c();
                eVar.f45412b = String.valueOf(c2);
                JSONArray jSONArray = new JSONArray();
                for (Map.Entry<String, b.a> entry : this.f42913e.f42909a.entrySet()) {
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
            Cursor m = d.a.h0.a.g0.d.b.m("", 400);
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

    public c h(int i2) {
        b.C0679b c0679b;
        int i3;
        if (e() && i2 != (i3 = (c0679b = this.f42913e).f42912d) && (i3 == 0 || i3 == c0679b.f42911c)) {
            this.f42913e.f42912d = i2;
        }
        return this;
    }

    public void i() {
        if (b.G0) {
            Log.i("PurgerStatistic", "performReport: " + this.f42913e);
        }
        if (e()) {
            ExecutorUtilsExt.postOnElastic(new a(), "PurgerStatistic", 3);
        }
    }

    public b.C0679b j() {
        return this.f42913e;
    }

    public c m(int i2) {
        if (e()) {
            this.f42913e.f42911c = i2;
        }
        return this;
    }
}

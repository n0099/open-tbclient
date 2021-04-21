package d.b.h0.a.j0.j;

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
import d.b.h0.a.j0.j.b;
import d.b.h0.a.z1.h;
import d.b.h0.a.z1.k.e;
import d.b.h0.p.d;
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
    public final b.C0740b f45590e;

    /* loaded from: classes2.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.f();
        }
    }

    public c(b.C0740b c0740b) {
        this.f45590e = c0740b == null ? new b.C0740b() : c0740b;
    }

    public static boolean d(b.a aVar) {
        return aVar != null && aVar.isValid();
    }

    public static c k() {
        return l(null);
    }

    public static c l(b.C0740b c0740b) {
        return new c(c0740b);
    }

    public c b(@Nullable String str) {
        if (e() && !TextUtils.isEmpty(str) && !d(this.f45590e.f45586a.get(str))) {
            d.b.h0.a.j0.j.a c2 = d.b.h0.a.j0.j.a.c(str);
            if (d(c2)) {
                this.f45590e.f45586a.put(c2.a(), c2);
            }
        }
        return this;
    }

    public int c() {
        b.C0740b c0740b = this.f45590e;
        int i = c0740b.f45589d;
        return i == 0 ? c0740b.f45588c : i;
    }

    public boolean e() {
        boolean z;
        synchronized (this.f45590e) {
            z = this.f45590e.f45587b;
        }
        return z;
    }

    public final void f() {
        String str;
        b.a value;
        synchronized (this.f45590e) {
            if (e()) {
                this.f45590e.f45587b = false;
                e eVar = new e();
                eVar.f47972a = "swan";
                eVar.f47974c = AdParamInfo.AdClickActionString.AD_CLICK_ACTION_NA;
                int c2 = c();
                eVar.f47973b = String.valueOf(c2);
                JSONArray jSONArray = new JSONArray();
                for (Map.Entry<String, b.a> entry : this.f45590e.f45586a.entrySet()) {
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
            Cursor m = d.b.h0.a.g0.d.b.m("", 400);
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
        b.C0740b c0740b;
        int i2;
        if (e() && i != (i2 = (c0740b = this.f45590e).f45589d) && (i2 == 0 || i2 == c0740b.f45588c)) {
            this.f45590e.f45589d = i;
        }
        return this;
    }

    public void i() {
        if (b.G0) {
            Log.i("PurgerStatistic", "performReport: " + this.f45590e);
        }
        if (e()) {
            ExecutorUtilsExt.postOnElastic(new a(), "PurgerStatistic", 3);
        }
    }

    public b.C0740b j() {
        return this.f45590e;
    }

    public c m(int i) {
        if (e()) {
            this.f45590e.f45588c = i;
        }
        return this;
    }
}

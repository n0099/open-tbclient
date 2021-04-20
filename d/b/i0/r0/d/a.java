package d.b.i0.r0.d;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.compatible.EditorHelper;
import com.baidu.tieba.funAd.strategy.FunAdHistoryData;
import d.b.h0.b.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: b  reason: collision with root package name */
    public static volatile a f60953b;

    /* renamed from: a  reason: collision with root package name */
    public Map<String, ArrayList<FunAdHistoryData>> f60954a;

    public a() {
        HashMap hashMap = new HashMap();
        this.f60954a = hashMap;
        hashMap.clear();
        this.f60954a.putAll(d());
    }

    public static a f() {
        if (f60953b == null) {
            synchronized (a.class) {
                if (f60953b == null) {
                    f60953b = new a();
                }
            }
        }
        return f60953b;
    }

    public void a(String str, FunAdHistoryData funAdHistoryData) {
        if (!d.i() || TextUtils.isEmpty(str) || funAdHistoryData == null) {
            return;
        }
        ArrayList<FunAdHistoryData> c2 = c(str);
        if (c2 == null) {
            c2 = new ArrayList<>();
        }
        c2.add(funAdHistoryData);
        g(c2);
        c.e().a(str);
        j(str);
    }

    public final ArrayList<FunAdHistoryData> b(JSONArray jSONArray) {
        if (jSONArray == null) {
            return null;
        }
        ArrayList<FunAdHistoryData> arrayList = new ArrayList<>();
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            FunAdHistoryData funAdHistoryData = new FunAdHistoryData();
            try {
                funAdHistoryData.parserJson(jSONArray.getJSONObject(i));
                arrayList.add(funAdHistoryData);
            } catch (JSONException e2) {
                BdLog.detailException(e2);
            }
        }
        return arrayList;
    }

    public ArrayList<FunAdHistoryData> c(String str) {
        if (this.f60954a == null || TextUtils.isEmpty(str) || !this.f60954a.containsKey(str)) {
            return null;
        }
        return this.f60954a.get(str);
    }

    public final Map<String, ArrayList<FunAdHistoryData>> d() {
        HashMap hashMap = new HashMap();
        for (String str : c.e().c()) {
            if (!TextUtils.isEmpty(str)) {
                ArrayList<FunAdHistoryData> e2 = e(str);
                if (e2 == null) {
                    e2 = new ArrayList<>();
                }
                hashMap.put(str, e2);
            }
        }
        return hashMap;
    }

    public final ArrayList<FunAdHistoryData> e(String str) {
        JSONArray jSONArray = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        SharedPreferences g2 = c.g();
        String string = g2.getString(str + "_fun_ad_history_key_suffix", "");
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        try {
            jSONArray = new JSONArray(string);
        } catch (JSONException e2) {
            BdLog.detailException(e2);
        }
        return b(jSONArray);
    }

    public final void g(ArrayList<FunAdHistoryData> arrayList) {
        if (arrayList == null) {
            return;
        }
        h(arrayList);
        i(arrayList);
    }

    public final void h(ArrayList<FunAdHistoryData> arrayList) {
        int size;
        if (arrayList != null && (size = arrayList.size()) > 600) {
            ListUtils.removeSubList(arrayList, 0, size - 600);
        }
    }

    public final void i(ArrayList<FunAdHistoryData> arrayList) {
        FunAdHistoryData next;
        if (arrayList == null) {
            return;
        }
        Iterator<FunAdHistoryData> it = arrayList.iterator();
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        while (it.hasNext() && (next = it.next()) != null && currentTimeMillis - next.getShowTime() > 86400) {
            it.remove();
        }
    }

    public final void j(String str) {
        ArrayList<FunAdHistoryData> arrayList;
        if (this.f60954a == null || TextUtils.isEmpty(str) || !this.f60954a.containsKey(str) || (arrayList = this.f60954a.get(str)) == null) {
            return;
        }
        JSONArray jSONArray = new JSONArray();
        Iterator<FunAdHistoryData> it = arrayList.iterator();
        while (it.hasNext()) {
            JSONObject json = it.next().toJson();
            if (json != null) {
                jSONArray.put(json);
            }
        }
        SharedPreferences g2 = c.g();
        EditorHelper.putString(g2, str + "_fun_ad_history_key_suffix", jSONArray.toString());
    }
}

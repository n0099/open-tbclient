package d.b.j0.r0.d;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.compatible.EditorHelper;
import com.baidu.tieba.funAd.strategy.FunAdHistoryData;
import com.baidu.tieba.funAd.strategy.FunAdSidConfigData;
import d.b.i0.b.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: b  reason: collision with root package name */
    public static volatile c f61378b;

    /* renamed from: a  reason: collision with root package name */
    public List<String> f61379a;

    public c() {
        ArrayList arrayList = new ArrayList();
        this.f61379a = arrayList;
        arrayList.add("pb_banner");
        this.f61379a.add("frs_feed");
    }

    public static boolean b() {
        SharedPreferences.Editor edit = g().edit();
        edit.clear();
        return edit.commit();
    }

    public static c e() {
        if (f61378b == null) {
            synchronized (b.class) {
                if (f61378b == null) {
                    f61378b = new c();
                }
            }
        }
        return f61378b;
    }

    public static SharedPreferences g() {
        return TbadkCoreApplication.getInst().getSharedPreferences("fun_ad_sid_strategy_shaedpref_name", 0);
    }

    public void a(String str) {
        FunAdSidConfigData b2;
        ArrayList<FunAdHistoryData> c2 = a.f().c(str);
        if (ListUtils.isEmpty(c2) || (b2 = b.e().b(str)) == null) {
            return;
        }
        List<FunAdHistoryData> h2 = h(c2, b2.getRecordNum(), b2.getExpiryTime());
        SharedPreferences g2 = g();
        if (i(h2, b2.getThreshold(), b2.getSpace(), g2.getLong(str + "_fun_ad_last_change_sid_time", 0L))) {
            j(str, b2);
        }
    }

    public List<String> c() {
        return this.f61379a;
    }

    public String d(String str) {
        if (!d.i()) {
            return f(str);
        }
        FunAdSidConfigData b2 = b.e().b(str);
        if (b2 == null) {
            return f(str);
        }
        if (ListUtils.isEmpty(b2.getBearSidList())) {
            return f(str);
        }
        SharedPreferences g2 = g();
        return g2.getString(str + "_fun_ad_current_sid_suffix", f(str));
    }

    public String f(String str) {
        return "pb_banner".equals(str) ? "6051001308-627527144" : "frs_feed".equals(str) ? "6051001001-2043781376" : "pic".equals(str) ? "6051001643-679358748" : "";
    }

    public final List<FunAdHistoryData> h(List<FunAdHistoryData> list, int i, long j) {
        int size = list.size();
        if (size > i) {
            list = ListUtils.subList(list, size - i, size);
        }
        int size2 = list.size();
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        int i2 = 0;
        Iterator<FunAdHistoryData> it = list.iterator();
        while (it.hasNext() && currentTimeMillis - it.next().getShowTime() > j) {
            i2++;
        }
        return ListUtils.subList(list, i2, size2);
    }

    public final boolean i(List<FunAdHistoryData> list, int i, long j, long j2) {
        if ((System.currentTimeMillis() / 1000) - j2 <= j) {
            return false;
        }
        HashMap hashMap = new HashMap();
        for (FunAdHistoryData funAdHistoryData : list) {
            if (funAdHistoryData != null) {
                String funAdKey = funAdHistoryData.getFunAdKey();
                if (TextUtils.isEmpty(funAdKey)) {
                    continue;
                } else {
                    Integer num = (Integer) hashMap.get(funAdKey);
                    if (num == null) {
                        num = 0;
                    }
                    if (num.intValue() + 1 >= i) {
                        return true;
                    }
                    hashMap.put(funAdKey, Integer.valueOf(num.intValue() + 1));
                }
            }
        }
        return false;
    }

    public final void j(String str, FunAdSidConfigData funAdSidConfigData) {
        SharedPreferences g2 = g();
        int i = g2.getInt(str + "_fun_ad_current_sid_index_suffix", -1);
        List<String> bearSidList = funAdSidConfigData.getBearSidList();
        if (ListUtils.isEmpty(bearSidList)) {
            return;
        }
        int size = (i + 1) % bearSidList.size();
        String str2 = (String) ListUtils.getItem(bearSidList, size);
        SharedPreferences g3 = g();
        EditorHelper.putInt(g3, str + "_fun_ad_current_sid_index_suffix", size);
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        SharedPreferences g4 = g();
        EditorHelper.putString(g4, str + "_fun_ad_current_sid_suffix", str2);
        SharedPreferences g5 = g();
        EditorHelper.putLong(g5, str + "_fun_ad_last_change_sid_time", System.currentTimeMillis() / 1000);
    }

    public void k(JSONObject jSONObject) {
        if (jSONObject != null && d.i()) {
            for (String str : this.f61379a) {
                if (!TextUtils.isEmpty(str)) {
                    FunAdSidConfigData funAdSidConfigData = new FunAdSidConfigData();
                    JSONObject jSONObject2 = null;
                    if (jSONObject.has(str)) {
                        try {
                            jSONObject2 = jSONObject.getJSONObject(str);
                        } catch (JSONException e2) {
                            BdLog.e(e2.getMessage());
                        }
                    }
                    if (jSONObject2 != null) {
                        funAdSidConfigData.parserJson(jSONObject2);
                        if (funAdSidConfigData.getForce() == 1) {
                            b.e().f(str, funAdSidConfigData);
                            SharedPreferences g2 = g();
                            EditorHelper.putInt(g2, str + "_fun_ad_current_sid_index_suffix", -1);
                            j(str, funAdSidConfigData);
                        } else {
                            SharedPreferences g3 = g();
                            if ((System.currentTimeMillis() / 1000) - g3.getLong(str + "_fun_ad_last_change_sid_time", 0L) > funAdSidConfigData.getSpace()) {
                                b.e().f(str, funAdSidConfigData);
                                SharedPreferences g4 = g();
                                EditorHelper.putInt(g4, str + "_fun_ad_current_sid_index_suffix", -1);
                                j(str, funAdSidConfigData);
                            }
                        }
                    }
                }
            }
            return;
        }
        b();
    }
}

package d.a.j0.r.o;

import android.text.format.DateUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BdToken.completeTask.CompleteTaskReqMsg;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.RecordVideoActivityConfig;
import com.baidu.tieba.compatible.EditorHelper;
import d.a.c.e.p.j;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: b  reason: collision with root package name */
    public static a f49858b;

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<d.a.j0.a.d0.a> f49859a = new ArrayList<>();

    public static a b() {
        if (f49858b == null) {
            synchronized (a.class) {
                if (f49858b == null) {
                    f49858b = new a();
                }
            }
        }
        return f49858b;
    }

    public void a() {
        TbadkCoreApplication.getInst().getSharedPreferences("business_workspace", 0).edit().clear();
    }

    public int c(String str) {
        return TbadkCoreApplication.getInst().getSharedPreferences("business_workspace", 0).getInt(str, 0);
    }

    public long d(String str) {
        return TbadkCoreApplication.getInst().getSharedPreferences("business_workspace", 0).getLong(str, 0L);
    }

    public final ArrayList<d.a.j0.a.d0.a> e() {
        return this.f49859a;
    }

    public void f(JSONArray jSONArray) {
        if (jSONArray != null) {
            h(jSONArray);
        }
    }

    public boolean g(String str) {
        return TbadkCoreApplication.getInst().getSharedPreferences("business_workspace", 0).contains(str);
    }

    public final void h(JSONArray jSONArray) {
        String currentAccount = TbadkCoreApplication.getCurrentAccount();
        if (StringUtils.isNull(currentAccount) || jSONArray == null) {
            return;
        }
        this.f49859a.clear();
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            JSONObject jSONObject = null;
            try {
                jSONObject = jSONArray.getJSONObject(i2);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            d.a.j0.a.d0.a aVar = new d.a.j0.a.d0.a();
            aVar.f48659a = jSONObject.optInt("active_id");
            aVar.f48660b = jSONObject.optInt("mission_id");
            aVar.f48661c = jSONObject.optInt(RecordVideoActivityConfig.SHOW_TYPE);
            long d2 = d("business_update_time" + currentAccount + aVar.f48659a);
            if (g("business_count_hint" + currentAccount + aVar.f48659a) && DateUtils.isToday(d2)) {
                aVar.s = c("business_count_hint" + currentAccount + aVar.f48659a);
            } else {
                aVar.s = jSONObject.optInt("show_num");
                a();
                i("business_count_hint" + currentAccount + aVar.f48659a, aVar.s);
                j("business_update_time" + currentAccount + aVar.f48659a, System.currentTimeMillis());
            }
            aVar.t = jSONObject.optInt("show_time_begin");
            aVar.u = jSONObject.optInt("show_time_end");
            JSONArray optJSONArray = jSONObject.optJSONArray("forumIds");
            for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
                try {
                    aVar.w.add((String) optJSONArray.get(i3));
                } catch (JSONException e3) {
                    e3.printStackTrace();
                }
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("show_page");
            for (int i4 = 0; i4 < optJSONArray2.length(); i4++) {
                try {
                    aVar.v.add((String) optJSONArray2.get(i4));
                } catch (JSONException e4) {
                    e4.printStackTrace();
                }
            }
            this.f49859a.add(aVar);
        }
    }

    public void i(String str, int i2) {
        EditorHelper.putInt(TbadkCoreApplication.getInst().getSharedPreferences("business_workspace", 0), str, i2);
    }

    public void j(String str, long j) {
        EditorHelper.putLong(TbadkCoreApplication.getInst().getSharedPreferences("business_workspace", 0), str, j);
    }

    public final void k(String str) {
        CompleteTaskReqMsg completeTaskReqMsg = new CompleteTaskReqMsg(0);
        completeTaskReqMsg.completeId = str;
        MessageManager.getInstance().sendMessage(completeTaskReqMsg);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(8:31|(5:33|(4:36|(2:38|39)(1:41)|40|34)|42|43|(2:54|50))(1:55)|45|46|47|48|49|50) */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00e6, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00e7, code lost:
        r0.printStackTrace();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void l(String str, String str2) {
        int i2;
        ArrayList<d.a.j0.a.d0.a> e2 = e();
        if (e2 != null && j.z()) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (StringUtils.isNull(currentAccount)) {
                return;
            }
            while (i2 < e2.size()) {
                int i3 = e2.get(i2).f48659a;
                int i4 = e2.get(i2).f48660b;
                int i5 = e2.get(i2).f48661c;
                int c2 = c("business_count_hint" + currentAccount + i3);
                long j = e2.get(i2).t;
                long j2 = e2.get(i2).u;
                ArrayList<String> arrayList = e2.get(i2).v;
                ArrayList<String> arrayList2 = e2.get(i2).w;
                if (c2 != 0 && System.currentTimeMillis() / 1000 > j && System.currentTimeMillis() / 1000 < j2) {
                    boolean z = false;
                    for (int i6 = 0; i6 < arrayList.size(); i6++) {
                        if (arrayList.get(i6).equals(str)) {
                            z = true;
                        }
                    }
                    if (z) {
                        if (str.equals("2")) {
                            boolean z2 = false;
                            for (int i7 = 0; i7 < arrayList2.size(); i7++) {
                                if (arrayList2.get(i7).equals(str2)) {
                                    z2 = true;
                                }
                            }
                            i2 = z2 ? 0 : i2 + 1;
                        }
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put(String.valueOf(i3), String.valueOf(i4));
                        k(jSONObject.toString());
                    }
                }
            }
        }
    }
}

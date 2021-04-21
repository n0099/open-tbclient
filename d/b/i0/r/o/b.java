package d.b.i0.r.o;

import android.text.format.DateUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BdToken.completeTask.CompleteTaskReqMsg;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.RecordVideoActivityConfig;
import com.baidu.tieba.compatible.EditorHelper;
import d.b.c.e.p.j;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b {

    /* renamed from: b  reason: collision with root package name */
    public static b f51420b;

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<d.b.i0.a.b0.a> f51421a = new ArrayList<>();

    public static b b() {
        if (f51420b == null) {
            synchronized (b.class) {
                if (f51420b == null) {
                    f51420b = new b();
                }
            }
        }
        return f51420b;
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

    public final ArrayList<d.b.i0.a.b0.a> e() {
        return this.f51421a;
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
        this.f51421a.clear();
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject = null;
            try {
                jSONObject = jSONArray.getJSONObject(i);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            d.b.i0.a.b0.a aVar = new d.b.i0.a.b0.a();
            aVar.f50239a = jSONObject.optInt("active_id");
            aVar.f50240b = jSONObject.optInt("mission_id");
            aVar.f50241c = jSONObject.optInt(RecordVideoActivityConfig.SHOW_TYPE);
            long d2 = d("business_update_time" + currentAccount + aVar.f50239a);
            if (g("business_count_hint" + currentAccount + aVar.f50239a) && DateUtils.isToday(d2)) {
                aVar.s = c("business_count_hint" + currentAccount + aVar.f50239a);
            } else {
                aVar.s = jSONObject.optInt("show_num");
                a();
                i("business_count_hint" + currentAccount + aVar.f50239a, aVar.s);
                j("business_update_time" + currentAccount + aVar.f50239a, System.currentTimeMillis());
            }
            aVar.t = jSONObject.optInt("show_time_begin");
            aVar.u = jSONObject.optInt("show_time_end");
            JSONArray optJSONArray = jSONObject.optJSONArray("forumIds");
            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                try {
                    aVar.w.add((String) optJSONArray.get(i2));
                } catch (JSONException e3) {
                    e3.printStackTrace();
                }
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("show_page");
            for (int i3 = 0; i3 < optJSONArray2.length(); i3++) {
                try {
                    aVar.v.add((String) optJSONArray2.get(i3));
                } catch (JSONException e4) {
                    e4.printStackTrace();
                }
            }
            this.f51421a.add(aVar);
        }
    }

    public void i(String str, int i) {
        EditorHelper.putInt(TbadkCoreApplication.getInst().getSharedPreferences("business_workspace", 0), str, i);
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
        int i;
        ArrayList<d.b.i0.a.b0.a> e2 = e();
        if (e2 != null && j.z()) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (StringUtils.isNull(currentAccount)) {
                return;
            }
            while (i < e2.size()) {
                int i2 = e2.get(i).f50239a;
                int i3 = e2.get(i).f50240b;
                int i4 = e2.get(i).f50241c;
                int c2 = c("business_count_hint" + currentAccount + i2);
                long j = e2.get(i).t;
                long j2 = e2.get(i).u;
                ArrayList<String> arrayList = e2.get(i).v;
                ArrayList<String> arrayList2 = e2.get(i).w;
                if (c2 != 0 && System.currentTimeMillis() / 1000 > j && System.currentTimeMillis() / 1000 < j2) {
                    boolean z = false;
                    for (int i5 = 0; i5 < arrayList.size(); i5++) {
                        if (arrayList.get(i5).equals(str)) {
                            z = true;
                        }
                    }
                    if (z) {
                        if (str.equals("2")) {
                            boolean z2 = false;
                            for (int i6 = 0; i6 < arrayList2.size(); i6++) {
                                if (arrayList2.get(i6).equals(str2)) {
                                    z2 = true;
                                }
                            }
                            i = z2 ? 0 : i + 1;
                        }
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put(String.valueOf(i2), String.valueOf(i3));
                        k(jSONObject.toString());
                    }
                }
            }
        }
    }
}

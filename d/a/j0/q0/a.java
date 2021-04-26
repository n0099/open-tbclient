package d.a.j0.q0;

import android.util.SparseArray;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import d.a.i0.r.q.a2;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.FrsTabInfo;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public final List<a2> f57472a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f57473b;

    /* renamed from: c  reason: collision with root package name */
    public String f57474c;

    /* renamed from: d  reason: collision with root package name */
    public int f57475d;

    /* renamed from: e  reason: collision with root package name */
    public List<FrsTabInfo> f57476e;

    /* renamed from: f  reason: collision with root package name */
    public SparseArray<FrsTabInfo> f57477f;

    /* renamed from: g  reason: collision with root package name */
    public x0 f57478g;

    /* loaded from: classes4.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static a f57479a = new a();
    }

    public static a h() {
        return b.f57479a;
    }

    public boolean a(a2 a2Var) {
        if (a2Var == null) {
            return false;
        }
        if (this.f57472a.size() > 29) {
            x0 x0Var = this.f57478g;
            if (x0Var != null) {
                x0Var.b(2);
            }
            return false;
        }
        this.f57472a.add(a2Var);
        x0 x0Var2 = this.f57478g;
        if (x0Var2 != null) {
            x0Var2.c(this.f57472a.size(), 2);
            return true;
        }
        return true;
    }

    public void b() {
        for (a2 a2Var : this.f57472a) {
            if (a2Var != null) {
                a2Var.U3(false);
            }
        }
        this.f57472a.clear();
        x0 x0Var = this.f57478g;
        if (x0Var != null) {
            x0Var.c(0, 2);
        }
    }

    public void c() {
        this.f57474c = null;
        this.f57475d = -1;
        List<FrsTabInfo> list = this.f57476e;
        if (list != null) {
            list.clear();
        }
        SparseArray<FrsTabInfo> sparseArray = this.f57477f;
        if (sparseArray != null) {
            sparseArray.clear();
        }
    }

    public void d() {
        if (ListUtils.isEmpty(this.f57472a)) {
            return;
        }
        this.f57472a.clear();
        x0 x0Var = this.f57478g;
        if (x0Var != null) {
            x0Var.c(this.f57472a.size(), 2);
        }
    }

    public int e() {
        return this.f57475d;
    }

    public String f() {
        return this.f57474c;
    }

    public List<FrsTabInfo> g() {
        return this.f57476e;
    }

    public List<a2> i() {
        return this.f57472a;
    }

    public boolean j() {
        return this.f57473b;
    }

    public boolean k(int i2) {
        return this.f57477f.get(i2) != null && this.f57477f.get(i2).is_general_tab.intValue() == 1;
    }

    public void l(a2 a2Var) {
        this.f57472a.remove(a2Var);
        x0 x0Var = this.f57478g;
        if (x0Var != null) {
            x0Var.c(this.f57472a.size(), 2);
        }
    }

    public void m(int i2, int i3) {
        try {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_FRS_MOVE_AREA);
            JSONArray jSONArray = new JSONArray();
            for (a2 a2Var : h().i()) {
                if (a2Var != null) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("thread_id", a2Var.o0());
                    jSONObject.put("from_tab_id", a2Var.m1());
                    jSONObject.put("to_tab_id", i3);
                    jSONArray.put(jSONObject);
                }
            }
            httpMessage.addParam("threads", jSONArray.toString());
            httpMessage.addParam("forum_id", h().f());
            MessageManager.getInstance().sendMessage(httpMessage);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public void n() {
        p(false, false);
        b();
    }

    public void o(int i2) {
        this.f57475d = i2;
    }

    public void p(boolean z, boolean z2) {
        this.f57473b = z;
        x0 x0Var = this.f57478g;
        if (x0Var != null) {
            x0Var.a(z, z2, 2);
        }
    }

    public void q(String str) {
        this.f57474c = str;
    }

    public void r(List<FrsTabInfo> list) {
        this.f57476e = new ArrayList(list);
        this.f57477f = new SparseArray<>();
        for (FrsTabInfo frsTabInfo : this.f57476e) {
            if (frsTabInfo != null) {
                this.f57477f.append(frsTabInfo.tab_id.intValue(), frsTabInfo);
            }
        }
    }

    public void s(x0 x0Var) {
        this.f57478g = x0Var;
    }

    public a() {
        this.f57475d = -1;
        this.f57472a = new ArrayList();
    }
}

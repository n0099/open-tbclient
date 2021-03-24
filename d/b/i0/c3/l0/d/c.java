package d.b.i0.c3.l0.d;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tieba.R;
import d.b.b.e.p.k;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public String f53492a;

    /* renamed from: c  reason: collision with root package name */
    public String f53494c;

    /* renamed from: d  reason: collision with root package name */
    public String f53495d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f53496e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f53497f;

    /* renamed from: b  reason: collision with root package name */
    public int f53493b = -1;

    /* renamed from: g  reason: collision with root package name */
    public boolean f53498g = true;

    public String a() {
        return this.f53495d;
    }

    public String b() {
        return this.f53494c;
    }

    public String c() {
        return this.f53492a;
    }

    public String d() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("status", this.f53493b);
            jSONObject.put("message", this.f53494c);
            if (StringHelper.isJSONObject(this.f53495d)) {
                jSONObject.put("data", new JSONObject(this.f53495d));
            } else if (StringHelper.isJSONArray(this.f53495d)) {
                jSONObject.put("data", new JSONArray(this.f53495d));
            } else {
                jSONObject.put("data", this.f53495d);
            }
        } catch (JSONException e2) {
            BdLog.e(e2);
        }
        return jSONObject.toString();
    }

    public int e() {
        return this.f53493b;
    }

    public boolean f() {
        return this.f53498g;
    }

    public boolean g() {
        return this.f53493b > 0;
    }

    public boolean h() {
        return this.f53496e;
    }

    public boolean i() {
        return this.f53497f;
    }

    public boolean j() {
        return this.f53493b != -1;
    }

    public void k(boolean z) {
        this.f53498g = z;
    }

    public void l(String str) {
        this.f53495d = str;
    }

    public void m() {
        r(TbadkCoreApplication.getInst().getString(R.string.na_business_error));
        u(401);
    }

    public void n(String str) {
        r(str);
        u(401);
    }

    public void o(boolean z) {
        this.f53496e = z;
    }

    public void p(boolean z) {
        this.f53497f = z;
    }

    public void q(String str) {
        this.f53494c = str;
    }

    public void r(String str) {
        if (k.isEmpty(this.f53494c)) {
            this.f53494c = str;
        }
    }

    public void s(String str) {
        this.f53492a = str;
    }

    public void t(int i) {
        this.f53493b = i;
        if (i == 0) {
            r(TbadkCoreApplication.getInst().getString(R.string.scheme_action_status_ok));
        } else if (i == 101) {
            r(TbadkCoreApplication.getInst().getString(R.string.scheme_action_status_scheme_parse_fail));
        } else if (i == 301) {
            r(TbadkCoreApplication.getInst().getString(R.string.scheme_action_security_check_fail));
        } else if (i == 201) {
            r(TbadkCoreApplication.getInst().getString(R.string.scheme_action_can_not_find_module));
        } else if (i != 202) {
        } else {
            r(TbadkCoreApplication.getInst().getString(R.string.scheme_action_can_not_find_action));
        }
    }

    public void u(int i) {
        if (this.f53493b == -1) {
            t(i);
        }
    }
}

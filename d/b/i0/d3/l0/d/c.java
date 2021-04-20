package d.b.i0.d3.l0.d;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tieba.R;
import d.b.c.e.p.k;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public String f54937a;

    /* renamed from: c  reason: collision with root package name */
    public String f54939c;

    /* renamed from: d  reason: collision with root package name */
    public String f54940d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f54941e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f54942f;

    /* renamed from: b  reason: collision with root package name */
    public int f54938b = -1;

    /* renamed from: g  reason: collision with root package name */
    public boolean f54943g = true;

    public String a() {
        return this.f54940d;
    }

    public String b() {
        return this.f54939c;
    }

    public String c() {
        return this.f54937a;
    }

    public String d() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("status", this.f54938b);
            jSONObject.put("message", this.f54939c);
            if (StringHelper.isJSONObject(this.f54940d)) {
                jSONObject.put("data", new JSONObject(this.f54940d));
            } else if (StringHelper.isJSONArray(this.f54940d)) {
                jSONObject.put("data", new JSONArray(this.f54940d));
            } else {
                jSONObject.put("data", this.f54940d);
            }
        } catch (JSONException e2) {
            BdLog.e(e2);
        }
        return jSONObject.toString();
    }

    public int e() {
        return this.f54938b;
    }

    public boolean f() {
        return this.f54943g;
    }

    public boolean g() {
        return this.f54938b > 0;
    }

    public boolean h() {
        return this.f54941e;
    }

    public boolean i() {
        return this.f54942f;
    }

    public boolean j() {
        return this.f54938b != -1;
    }

    public void k(boolean z) {
        this.f54943g = z;
    }

    public void l(String str) {
        this.f54940d = str;
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
        this.f54941e = z;
    }

    public void p(boolean z) {
        this.f54942f = z;
    }

    public void q(String str) {
        this.f54939c = str;
    }

    public void r(String str) {
        if (k.isEmpty(this.f54939c)) {
            this.f54939c = str;
        }
    }

    public void s(String str) {
        this.f54937a = str;
    }

    public void t(int i) {
        this.f54938b = i;
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
        if (this.f54938b == -1) {
            t(i);
        }
    }
}

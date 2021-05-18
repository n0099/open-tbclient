package d.a.k0.d3.l0.d;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tieba.R;
import d.a.c.e.p.k;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public String f53906a;

    /* renamed from: c  reason: collision with root package name */
    public String f53908c;

    /* renamed from: d  reason: collision with root package name */
    public String f53909d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f53910e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f53911f;

    /* renamed from: b  reason: collision with root package name */
    public int f53907b = -1;

    /* renamed from: g  reason: collision with root package name */
    public boolean f53912g = true;

    public String a() {
        return this.f53909d;
    }

    public String b() {
        return this.f53908c;
    }

    public String c() {
        return this.f53906a;
    }

    public String d() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("status", this.f53907b);
            jSONObject.put("message", this.f53908c);
            if (StringHelper.isJSONObject(this.f53909d)) {
                jSONObject.put("data", new JSONObject(this.f53909d));
            } else if (StringHelper.isJSONArray(this.f53909d)) {
                jSONObject.put("data", new JSONArray(this.f53909d));
            } else {
                jSONObject.put("data", this.f53909d);
            }
        } catch (JSONException e2) {
            BdLog.e(e2);
        }
        return jSONObject.toString();
    }

    public int e() {
        return this.f53907b;
    }

    public boolean f() {
        return this.f53912g;
    }

    public boolean g() {
        return this.f53907b > 0;
    }

    public boolean h() {
        return this.f53910e;
    }

    public boolean i() {
        return this.f53911f;
    }

    public boolean j() {
        return this.f53907b != -1;
    }

    public void k(boolean z) {
        this.f53912g = z;
    }

    public void l(String str) {
        this.f53909d = str;
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
        this.f53910e = z;
    }

    public void p(boolean z) {
        this.f53911f = z;
    }

    public void q(String str) {
        this.f53908c = str;
    }

    public void r(String str) {
        if (k.isEmpty(this.f53908c)) {
            this.f53908c = str;
        }
    }

    public void s(String str) {
        this.f53906a = str;
    }

    public void t(int i2) {
        this.f53907b = i2;
        if (i2 == 0) {
            r(TbadkCoreApplication.getInst().getString(R.string.scheme_action_status_ok));
        } else if (i2 == 101) {
            r(TbadkCoreApplication.getInst().getString(R.string.scheme_action_status_scheme_parse_fail));
        } else if (i2 == 301) {
            r(TbadkCoreApplication.getInst().getString(R.string.scheme_action_security_check_fail));
        } else if (i2 == 201) {
            r(TbadkCoreApplication.getInst().getString(R.string.scheme_action_can_not_find_module));
        } else if (i2 != 202) {
        } else {
            r(TbadkCoreApplication.getInst().getString(R.string.scheme_action_can_not_find_action));
        }
    }

    public void u(int i2) {
        if (this.f53907b == -1) {
            t(i2);
        }
    }
}

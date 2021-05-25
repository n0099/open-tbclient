package d.a.n0.i2;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.ForumData;
import d.a.m0.r.q.z0;
import java.util.ArrayList;
import java.util.Date;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: h  reason: collision with root package name */
    public int f55713h;

    /* renamed from: i  reason: collision with root package name */
    public int f55714i = 0;
    public int j = 0;

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<ForumData> f55706a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<ForumData> f55707b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<ForumData> f55708c = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    public ArrayList<ForumData> f55709d = new ArrayList<>();

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<ForumData> f55711f = new ArrayList<>();

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<ForumData> f55710e = new ArrayList<>();

    /* renamed from: g  reason: collision with root package name */
    public z0 f55712g = new z0();

    public b() {
        s(false);
    }

    public void a(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.f55709d == null) {
            this.f55709d = new ArrayList<>();
        }
        ArrayList<ForumData> arrayList3 = this.f55710e;
        if (arrayList3 != null && arrayList != null) {
            arrayList3.addAll(arrayList);
        }
        ArrayList<ForumData> arrayList4 = this.f55711f;
        if (arrayList4 != null && arrayList2 != null) {
            arrayList4.addAll(arrayList2);
        }
        if (this.f55710e == null && this.f55711f == null) {
            return;
        }
        this.f55709d.clear();
        ArrayList<ForumData> arrayList5 = this.f55710e;
        if (arrayList5 != null) {
            this.f55709d.addAll(arrayList5);
        }
        ArrayList<ForumData> arrayList6 = this.f55711f;
        if (arrayList6 != null) {
            this.f55709d.addAll(arrayList6);
        }
    }

    public void b(int i2) {
        this.j += i2;
    }

    public void c(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.f55706a == null) {
            this.f55706a = new ArrayList<>();
        }
        ArrayList<ForumData> arrayList3 = this.f55707b;
        if (arrayList3 != null && arrayList != null) {
            arrayList3.addAll(arrayList);
        }
        ArrayList<ForumData> arrayList4 = this.f55708c;
        if (arrayList4 != null && arrayList2 != null) {
            arrayList4.addAll(arrayList2);
        }
        if (this.f55707b == null && this.f55708c == null) {
            return;
        }
        this.f55706a.clear();
        ArrayList<ForumData> arrayList5 = this.f55707b;
        if (arrayList5 != null) {
            this.f55706a.addAll(arrayList5);
        }
        ArrayList<ForumData> arrayList6 = this.f55708c;
        if (arrayList6 != null) {
            this.f55706a.addAll(arrayList6);
        }
    }

    public void d(int i2) {
        this.f55714i += i2;
    }

    public ArrayList<ForumData> e() {
        return this.f55709d;
    }

    public ArrayList<ForumData> f() {
        return this.f55711f;
    }

    public int g() {
        return this.j;
    }

    public ArrayList<ForumData> h() {
        return this.f55710e;
    }

    public ArrayList<ForumData> i() {
        return this.f55706a;
    }

    public ArrayList<ForumData> j() {
        return this.f55708c;
    }

    public int k() {
        return this.f55714i;
    }

    public ArrayList<ForumData> l() {
        return this.f55707b;
    }

    public boolean m() {
        return this.f55713h == 1;
    }

    public void n(String str) {
        if (str == null) {
            return;
        }
        try {
            o(new JSONObject(str));
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    public void o(JSONObject jSONObject) {
        try {
            this.f55712g.i(jSONObject.optJSONObject("page"));
            this.f55713h = jSONObject.optInt("has_more", 1);
            long optLong = jSONObject.optLong("ctime", 0L);
            if (optLong > 0) {
                new Date(optLong);
            } else {
                new Date();
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("forum_list");
            if (optJSONObject == null) {
                return;
            }
            JSONArray optJSONArray = optJSONObject.optJSONArray("gconforum");
            if (optJSONArray != null) {
                this.f55714i = optJSONArray.length();
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    ForumData forumData = new ForumData();
                    forumData.parserJson(optJSONArray.getJSONObject(i2));
                    this.f55707b.add(forumData);
                }
            }
            JSONArray optJSONArray2 = optJSONObject.optJSONArray("non-gconforum");
            if (optJSONArray2 != null) {
                for (int i3 = 0; i3 < optJSONArray2.length(); i3++) {
                    ForumData forumData2 = new ForumData();
                    forumData2.parserJson(optJSONArray2.getJSONObject(i3));
                    this.f55708c.add(forumData2);
                }
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("common_forum_list");
            if (optJSONObject2 == null) {
                return;
            }
            JSONArray optJSONArray3 = optJSONObject2.optJSONArray("gconforum");
            if (optJSONArray3 != null) {
                this.j = optJSONArray3.length();
                for (int i4 = 0; i4 < optJSONArray3.length(); i4++) {
                    ForumData forumData3 = new ForumData();
                    forumData3.parserJson(optJSONArray3.getJSONObject(i4));
                    this.f55710e.add(forumData3);
                }
            }
            JSONArray optJSONArray4 = optJSONObject2.optJSONArray("non-gconforum");
            if (optJSONArray4 != null) {
                for (int i5 = 0; i5 < optJSONArray4.length(); i5++) {
                    ForumData forumData4 = new ForumData();
                    forumData4.parserJson(optJSONArray4.getJSONObject(i5));
                    this.f55711f.add(forumData4);
                }
            }
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    public void p(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.f55709d == null) {
            this.f55709d = new ArrayList<>();
        }
        ArrayList<ForumData> arrayList3 = this.f55710e;
        if (arrayList3 != null && arrayList != null) {
            arrayList3.clear();
            this.f55710e.addAll(arrayList);
        }
        ArrayList<ForumData> arrayList4 = this.f55711f;
        if (arrayList4 != null && arrayList2 != null) {
            arrayList4.clear();
            this.f55711f.addAll(arrayList2);
        }
        if (this.f55710e == null && this.f55711f == null) {
            return;
        }
        this.f55709d.clear();
        ArrayList<ForumData> arrayList5 = this.f55710e;
        if (arrayList5 != null) {
            this.f55709d.addAll(arrayList5);
        }
        ArrayList<ForumData> arrayList6 = this.f55711f;
        if (arrayList6 != null) {
            this.f55709d.addAll(arrayList6);
        }
    }

    public void q(int i2) {
        this.j = i2;
    }

    public void r(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.f55706a == null) {
            this.f55706a = new ArrayList<>();
        }
        ArrayList<ForumData> arrayList3 = this.f55707b;
        if (arrayList3 != null && arrayList != null) {
            arrayList3.clear();
            this.f55707b.addAll(arrayList);
        }
        ArrayList<ForumData> arrayList4 = this.f55708c;
        if (arrayList4 != null && arrayList2 != null) {
            arrayList4.clear();
            this.f55708c.addAll(arrayList2);
        }
        if (this.f55707b == null && this.f55708c == null) {
            return;
        }
        this.f55706a.clear();
        ArrayList<ForumData> arrayList5 = this.f55707b;
        if (arrayList5 != null) {
            this.f55706a.addAll(arrayList5);
        }
        ArrayList<ForumData> arrayList6 = this.f55708c;
        if (arrayList6 != null) {
            this.f55706a.addAll(arrayList6);
        }
    }

    public void s(boolean z) {
        this.f55713h = z ? 1 : 0;
    }

    public void t(int i2) {
        this.f55714i = i2;
    }
}

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
    public int f59402h;

    /* renamed from: i  reason: collision with root package name */
    public int f59403i = 0;
    public int j = 0;

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<ForumData> f59395a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<ForumData> f59396b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<ForumData> f59397c = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    public ArrayList<ForumData> f59398d = new ArrayList<>();

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<ForumData> f59400f = new ArrayList<>();

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<ForumData> f59399e = new ArrayList<>();

    /* renamed from: g  reason: collision with root package name */
    public z0 f59401g = new z0();

    public b() {
        s(false);
    }

    public void a(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.f59398d == null) {
            this.f59398d = new ArrayList<>();
        }
        ArrayList<ForumData> arrayList3 = this.f59399e;
        if (arrayList3 != null && arrayList != null) {
            arrayList3.addAll(arrayList);
        }
        ArrayList<ForumData> arrayList4 = this.f59400f;
        if (arrayList4 != null && arrayList2 != null) {
            arrayList4.addAll(arrayList2);
        }
        if (this.f59399e == null && this.f59400f == null) {
            return;
        }
        this.f59398d.clear();
        ArrayList<ForumData> arrayList5 = this.f59399e;
        if (arrayList5 != null) {
            this.f59398d.addAll(arrayList5);
        }
        ArrayList<ForumData> arrayList6 = this.f59400f;
        if (arrayList6 != null) {
            this.f59398d.addAll(arrayList6);
        }
    }

    public void b(int i2) {
        this.j += i2;
    }

    public void c(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.f59395a == null) {
            this.f59395a = new ArrayList<>();
        }
        ArrayList<ForumData> arrayList3 = this.f59396b;
        if (arrayList3 != null && arrayList != null) {
            arrayList3.addAll(arrayList);
        }
        ArrayList<ForumData> arrayList4 = this.f59397c;
        if (arrayList4 != null && arrayList2 != null) {
            arrayList4.addAll(arrayList2);
        }
        if (this.f59396b == null && this.f59397c == null) {
            return;
        }
        this.f59395a.clear();
        ArrayList<ForumData> arrayList5 = this.f59396b;
        if (arrayList5 != null) {
            this.f59395a.addAll(arrayList5);
        }
        ArrayList<ForumData> arrayList6 = this.f59397c;
        if (arrayList6 != null) {
            this.f59395a.addAll(arrayList6);
        }
    }

    public void d(int i2) {
        this.f59403i += i2;
    }

    public ArrayList<ForumData> e() {
        return this.f59398d;
    }

    public ArrayList<ForumData> f() {
        return this.f59400f;
    }

    public int g() {
        return this.j;
    }

    public ArrayList<ForumData> h() {
        return this.f59399e;
    }

    public ArrayList<ForumData> i() {
        return this.f59395a;
    }

    public ArrayList<ForumData> j() {
        return this.f59397c;
    }

    public int k() {
        return this.f59403i;
    }

    public ArrayList<ForumData> l() {
        return this.f59396b;
    }

    public boolean m() {
        return this.f59402h == 1;
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
            this.f59401g.i(jSONObject.optJSONObject("page"));
            this.f59402h = jSONObject.optInt("has_more", 1);
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
                this.f59403i = optJSONArray.length();
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    ForumData forumData = new ForumData();
                    forumData.parserJson(optJSONArray.getJSONObject(i2));
                    this.f59396b.add(forumData);
                }
            }
            JSONArray optJSONArray2 = optJSONObject.optJSONArray("non-gconforum");
            if (optJSONArray2 != null) {
                for (int i3 = 0; i3 < optJSONArray2.length(); i3++) {
                    ForumData forumData2 = new ForumData();
                    forumData2.parserJson(optJSONArray2.getJSONObject(i3));
                    this.f59397c.add(forumData2);
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
                    this.f59399e.add(forumData3);
                }
            }
            JSONArray optJSONArray4 = optJSONObject2.optJSONArray("non-gconforum");
            if (optJSONArray4 != null) {
                for (int i5 = 0; i5 < optJSONArray4.length(); i5++) {
                    ForumData forumData4 = new ForumData();
                    forumData4.parserJson(optJSONArray4.getJSONObject(i5));
                    this.f59400f.add(forumData4);
                }
            }
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    public void p(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.f59398d == null) {
            this.f59398d = new ArrayList<>();
        }
        ArrayList<ForumData> arrayList3 = this.f59399e;
        if (arrayList3 != null && arrayList != null) {
            arrayList3.clear();
            this.f59399e.addAll(arrayList);
        }
        ArrayList<ForumData> arrayList4 = this.f59400f;
        if (arrayList4 != null && arrayList2 != null) {
            arrayList4.clear();
            this.f59400f.addAll(arrayList2);
        }
        if (this.f59399e == null && this.f59400f == null) {
            return;
        }
        this.f59398d.clear();
        ArrayList<ForumData> arrayList5 = this.f59399e;
        if (arrayList5 != null) {
            this.f59398d.addAll(arrayList5);
        }
        ArrayList<ForumData> arrayList6 = this.f59400f;
        if (arrayList6 != null) {
            this.f59398d.addAll(arrayList6);
        }
    }

    public void q(int i2) {
        this.j = i2;
    }

    public void r(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.f59395a == null) {
            this.f59395a = new ArrayList<>();
        }
        ArrayList<ForumData> arrayList3 = this.f59396b;
        if (arrayList3 != null && arrayList != null) {
            arrayList3.clear();
            this.f59396b.addAll(arrayList);
        }
        ArrayList<ForumData> arrayList4 = this.f59397c;
        if (arrayList4 != null && arrayList2 != null) {
            arrayList4.clear();
            this.f59397c.addAll(arrayList2);
        }
        if (this.f59396b == null && this.f59397c == null) {
            return;
        }
        this.f59395a.clear();
        ArrayList<ForumData> arrayList5 = this.f59396b;
        if (arrayList5 != null) {
            this.f59395a.addAll(arrayList5);
        }
        ArrayList<ForumData> arrayList6 = this.f59397c;
        if (arrayList6 != null) {
            this.f59395a.addAll(arrayList6);
        }
    }

    public void s(boolean z) {
        this.f59402h = z ? 1 : 0;
    }

    public void t(int i2) {
        this.f59403i = i2;
    }
}

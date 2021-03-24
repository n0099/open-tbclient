package d.b.i0.g2;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.ForumData;
import d.b.h0.r.q.z0;
import java.util.ArrayList;
import java.util.Date;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class b {

    /* renamed from: h  reason: collision with root package name */
    public int f54948h;
    public int i = 0;
    public int j = 0;

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<ForumData> f54941a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<ForumData> f54942b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<ForumData> f54943c = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    public ArrayList<ForumData> f54944d = new ArrayList<>();

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<ForumData> f54946f = new ArrayList<>();

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<ForumData> f54945e = new ArrayList<>();

    /* renamed from: g  reason: collision with root package name */
    public z0 f54947g = new z0();

    public b() {
        s(false);
    }

    public void a(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.f54944d == null) {
            this.f54944d = new ArrayList<>();
        }
        ArrayList<ForumData> arrayList3 = this.f54945e;
        if (arrayList3 != null && arrayList != null) {
            arrayList3.addAll(arrayList);
        }
        ArrayList<ForumData> arrayList4 = this.f54946f;
        if (arrayList4 != null && arrayList2 != null) {
            arrayList4.addAll(arrayList2);
        }
        if (this.f54945e == null && this.f54946f == null) {
            return;
        }
        this.f54944d.clear();
        ArrayList<ForumData> arrayList5 = this.f54945e;
        if (arrayList5 != null) {
            this.f54944d.addAll(arrayList5);
        }
        ArrayList<ForumData> arrayList6 = this.f54946f;
        if (arrayList6 != null) {
            this.f54944d.addAll(arrayList6);
        }
    }

    public void b(int i) {
        this.j += i;
    }

    public void c(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.f54941a == null) {
            this.f54941a = new ArrayList<>();
        }
        ArrayList<ForumData> arrayList3 = this.f54942b;
        if (arrayList3 != null && arrayList != null) {
            arrayList3.addAll(arrayList);
        }
        ArrayList<ForumData> arrayList4 = this.f54943c;
        if (arrayList4 != null && arrayList2 != null) {
            arrayList4.addAll(arrayList2);
        }
        if (this.f54942b == null && this.f54943c == null) {
            return;
        }
        this.f54941a.clear();
        ArrayList<ForumData> arrayList5 = this.f54942b;
        if (arrayList5 != null) {
            this.f54941a.addAll(arrayList5);
        }
        ArrayList<ForumData> arrayList6 = this.f54943c;
        if (arrayList6 != null) {
            this.f54941a.addAll(arrayList6);
        }
    }

    public void d(int i) {
        this.i += i;
    }

    public ArrayList<ForumData> e() {
        return this.f54944d;
    }

    public ArrayList<ForumData> f() {
        return this.f54946f;
    }

    public int g() {
        return this.j;
    }

    public ArrayList<ForumData> h() {
        return this.f54945e;
    }

    public ArrayList<ForumData> i() {
        return this.f54941a;
    }

    public ArrayList<ForumData> j() {
        return this.f54943c;
    }

    public int k() {
        return this.i;
    }

    public ArrayList<ForumData> l() {
        return this.f54942b;
    }

    public boolean m() {
        return this.f54948h == 1;
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
            this.f54947g.i(jSONObject.optJSONObject("page"));
            this.f54948h = jSONObject.optInt("has_more", 1);
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
                this.i = optJSONArray.length();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    ForumData forumData = new ForumData();
                    forumData.parserJson(optJSONArray.getJSONObject(i));
                    this.f54942b.add(forumData);
                }
            }
            JSONArray optJSONArray2 = optJSONObject.optJSONArray("non-gconforum");
            if (optJSONArray2 != null) {
                for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                    ForumData forumData2 = new ForumData();
                    forumData2.parserJson(optJSONArray2.getJSONObject(i2));
                    this.f54943c.add(forumData2);
                }
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("common_forum_list");
            if (optJSONObject2 == null) {
                return;
            }
            JSONArray optJSONArray3 = optJSONObject2.optJSONArray("gconforum");
            if (optJSONArray3 != null) {
                this.j = optJSONArray3.length();
                for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                    ForumData forumData3 = new ForumData();
                    forumData3.parserJson(optJSONArray3.getJSONObject(i3));
                    this.f54945e.add(forumData3);
                }
            }
            JSONArray optJSONArray4 = optJSONObject2.optJSONArray("non-gconforum");
            if (optJSONArray4 != null) {
                for (int i4 = 0; i4 < optJSONArray4.length(); i4++) {
                    ForumData forumData4 = new ForumData();
                    forumData4.parserJson(optJSONArray4.getJSONObject(i4));
                    this.f54946f.add(forumData4);
                }
            }
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    public void p(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.f54944d == null) {
            this.f54944d = new ArrayList<>();
        }
        ArrayList<ForumData> arrayList3 = this.f54945e;
        if (arrayList3 != null && arrayList != null) {
            arrayList3.clear();
            this.f54945e.addAll(arrayList);
        }
        ArrayList<ForumData> arrayList4 = this.f54946f;
        if (arrayList4 != null && arrayList2 != null) {
            arrayList4.clear();
            this.f54946f.addAll(arrayList2);
        }
        if (this.f54945e == null && this.f54946f == null) {
            return;
        }
        this.f54944d.clear();
        ArrayList<ForumData> arrayList5 = this.f54945e;
        if (arrayList5 != null) {
            this.f54944d.addAll(arrayList5);
        }
        ArrayList<ForumData> arrayList6 = this.f54946f;
        if (arrayList6 != null) {
            this.f54944d.addAll(arrayList6);
        }
    }

    public void q(int i) {
        this.j = i;
    }

    public void r(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.f54941a == null) {
            this.f54941a = new ArrayList<>();
        }
        ArrayList<ForumData> arrayList3 = this.f54942b;
        if (arrayList3 != null && arrayList != null) {
            arrayList3.clear();
            this.f54942b.addAll(arrayList);
        }
        ArrayList<ForumData> arrayList4 = this.f54943c;
        if (arrayList4 != null && arrayList2 != null) {
            arrayList4.clear();
            this.f54943c.addAll(arrayList2);
        }
        if (this.f54942b == null && this.f54943c == null) {
            return;
        }
        this.f54941a.clear();
        ArrayList<ForumData> arrayList5 = this.f54942b;
        if (arrayList5 != null) {
            this.f54941a.addAll(arrayList5);
        }
        ArrayList<ForumData> arrayList6 = this.f54943c;
        if (arrayList6 != null) {
            this.f54941a.addAll(arrayList6);
        }
    }

    public void s(boolean z) {
        this.f54948h = z ? 1 : 0;
    }

    public void t(int i) {
        this.i = i;
    }
}

package d.a.j0.h2;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.core.data.ForumData;
import d.a.i0.r.q.z0;
import java.util.ArrayList;
import java.util.Date;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: h  reason: collision with root package name */
    public int f54818h;

    /* renamed from: i  reason: collision with root package name */
    public int f54819i = 0;
    public int j = 0;

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<ForumData> f54811a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<ForumData> f54812b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<ForumData> f54813c = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    public ArrayList<ForumData> f54814d = new ArrayList<>();

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<ForumData> f54816f = new ArrayList<>();

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<ForumData> f54815e = new ArrayList<>();

    /* renamed from: g  reason: collision with root package name */
    public z0 f54817g = new z0();

    public b() {
        s(false);
    }

    public void a(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.f54814d == null) {
            this.f54814d = new ArrayList<>();
        }
        ArrayList<ForumData> arrayList3 = this.f54815e;
        if (arrayList3 != null && arrayList != null) {
            arrayList3.addAll(arrayList);
        }
        ArrayList<ForumData> arrayList4 = this.f54816f;
        if (arrayList4 != null && arrayList2 != null) {
            arrayList4.addAll(arrayList2);
        }
        if (this.f54815e == null && this.f54816f == null) {
            return;
        }
        this.f54814d.clear();
        ArrayList<ForumData> arrayList5 = this.f54815e;
        if (arrayList5 != null) {
            this.f54814d.addAll(arrayList5);
        }
        ArrayList<ForumData> arrayList6 = this.f54816f;
        if (arrayList6 != null) {
            this.f54814d.addAll(arrayList6);
        }
    }

    public void b(int i2) {
        this.j += i2;
    }

    public void c(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.f54811a == null) {
            this.f54811a = new ArrayList<>();
        }
        ArrayList<ForumData> arrayList3 = this.f54812b;
        if (arrayList3 != null && arrayList != null) {
            arrayList3.addAll(arrayList);
        }
        ArrayList<ForumData> arrayList4 = this.f54813c;
        if (arrayList4 != null && arrayList2 != null) {
            arrayList4.addAll(arrayList2);
        }
        if (this.f54812b == null && this.f54813c == null) {
            return;
        }
        this.f54811a.clear();
        ArrayList<ForumData> arrayList5 = this.f54812b;
        if (arrayList5 != null) {
            this.f54811a.addAll(arrayList5);
        }
        ArrayList<ForumData> arrayList6 = this.f54813c;
        if (arrayList6 != null) {
            this.f54811a.addAll(arrayList6);
        }
    }

    public void d(int i2) {
        this.f54819i += i2;
    }

    public ArrayList<ForumData> e() {
        return this.f54814d;
    }

    public ArrayList<ForumData> f() {
        return this.f54816f;
    }

    public int g() {
        return this.j;
    }

    public ArrayList<ForumData> h() {
        return this.f54815e;
    }

    public ArrayList<ForumData> i() {
        return this.f54811a;
    }

    public ArrayList<ForumData> j() {
        return this.f54813c;
    }

    public int k() {
        return this.f54819i;
    }

    public ArrayList<ForumData> l() {
        return this.f54812b;
    }

    public boolean m() {
        return this.f54818h == 1;
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
            this.f54817g.i(jSONObject.optJSONObject("page"));
            this.f54818h = jSONObject.optInt("has_more", 1);
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
                this.f54819i = optJSONArray.length();
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    ForumData forumData = new ForumData();
                    forumData.parserJson(optJSONArray.getJSONObject(i2));
                    this.f54812b.add(forumData);
                }
            }
            JSONArray optJSONArray2 = optJSONObject.optJSONArray("non-gconforum");
            if (optJSONArray2 != null) {
                for (int i3 = 0; i3 < optJSONArray2.length(); i3++) {
                    ForumData forumData2 = new ForumData();
                    forumData2.parserJson(optJSONArray2.getJSONObject(i3));
                    this.f54813c.add(forumData2);
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
                    this.f54815e.add(forumData3);
                }
            }
            JSONArray optJSONArray4 = optJSONObject2.optJSONArray("non-gconforum");
            if (optJSONArray4 != null) {
                for (int i5 = 0; i5 < optJSONArray4.length(); i5++) {
                    ForumData forumData4 = new ForumData();
                    forumData4.parserJson(optJSONArray4.getJSONObject(i5));
                    this.f54816f.add(forumData4);
                }
            }
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    public void p(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.f54814d == null) {
            this.f54814d = new ArrayList<>();
        }
        ArrayList<ForumData> arrayList3 = this.f54815e;
        if (arrayList3 != null && arrayList != null) {
            arrayList3.clear();
            this.f54815e.addAll(arrayList);
        }
        ArrayList<ForumData> arrayList4 = this.f54816f;
        if (arrayList4 != null && arrayList2 != null) {
            arrayList4.clear();
            this.f54816f.addAll(arrayList2);
        }
        if (this.f54815e == null && this.f54816f == null) {
            return;
        }
        this.f54814d.clear();
        ArrayList<ForumData> arrayList5 = this.f54815e;
        if (arrayList5 != null) {
            this.f54814d.addAll(arrayList5);
        }
        ArrayList<ForumData> arrayList6 = this.f54816f;
        if (arrayList6 != null) {
            this.f54814d.addAll(arrayList6);
        }
    }

    public void q(int i2) {
        this.j = i2;
    }

    public void r(ArrayList<ForumData> arrayList, ArrayList<ForumData> arrayList2) {
        if (this.f54811a == null) {
            this.f54811a = new ArrayList<>();
        }
        ArrayList<ForumData> arrayList3 = this.f54812b;
        if (arrayList3 != null && arrayList != null) {
            arrayList3.clear();
            this.f54812b.addAll(arrayList);
        }
        ArrayList<ForumData> arrayList4 = this.f54813c;
        if (arrayList4 != null && arrayList2 != null) {
            arrayList4.clear();
            this.f54813c.addAll(arrayList2);
        }
        if (this.f54812b == null && this.f54813c == null) {
            return;
        }
        this.f54811a.clear();
        ArrayList<ForumData> arrayList5 = this.f54812b;
        if (arrayList5 != null) {
            this.f54811a.addAll(arrayList5);
        }
        ArrayList<ForumData> arrayList6 = this.f54813c;
        if (arrayList6 != null) {
            this.f54811a.addAll(arrayList6);
        }
    }

    public void s(boolean z) {
        this.f54818h = z ? 1 : 0;
    }

    public void t(int i2) {
        this.f54819i = i2;
    }
}

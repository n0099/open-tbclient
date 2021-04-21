package d.b.j0.a3.j;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import d.b.i0.r.q.x1;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class f {

    /* renamed from: e  reason: collision with root package name */
    public long f53615e;

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<x1> f53611a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<a> f53612b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<b> f53613c = new ArrayList<>();

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<d> f53616f = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    public boolean f53614d = true;

    /* loaded from: classes4.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f53617a;

        /* renamed from: b  reason: collision with root package name */
        public String f53618b;

        /* renamed from: c  reason: collision with root package name */
        public String f53619c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f53620d;
    }

    /* loaded from: classes4.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public boolean f53621a;

        /* renamed from: b  reason: collision with root package name */
        public String f53622b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f53623c;

        /* renamed from: d  reason: collision with root package name */
        public int f53624d;

        /* renamed from: e  reason: collision with root package name */
        public String f53625e;

        /* renamed from: f  reason: collision with root package name */
        public String f53626f;

        /* renamed from: g  reason: collision with root package name */
        public String f53627g;

        /* renamed from: h  reason: collision with root package name */
        public String f53628h;
        public String i;
        public long j;
        public long k;
        public String l;
        public int m;
        public int n;
    }

    /* loaded from: classes4.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public int f53629a;

        /* renamed from: b  reason: collision with root package name */
        public String f53630b;

        /* renamed from: c  reason: collision with root package name */
        public String f53631c;

        /* renamed from: d  reason: collision with root package name */
        public long f53632d;

        /* renamed from: e  reason: collision with root package name */
        public long f53633e;

        /* renamed from: f  reason: collision with root package name */
        public String f53634f;

        /* renamed from: g  reason: collision with root package name */
        public String f53635g;

        /* renamed from: h  reason: collision with root package name */
        public String f53636h;
        public String i;
    }

    /* loaded from: classes4.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public String f53637a;

        /* renamed from: b  reason: collision with root package name */
        public int f53638b;

        /* renamed from: c  reason: collision with root package name */
        public String f53639c;

        /* renamed from: d  reason: collision with root package name */
        public String f53640d;

        /* renamed from: e  reason: collision with root package name */
        public ArrayList<c> f53641e;
    }

    public ArrayList<a> a() {
        return this.f53612b;
    }

    public ArrayList<b> b() {
        return this.f53613c;
    }

    public boolean c() {
        return true;
    }

    public String d() {
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        JSONArray jSONArray2 = new JSONArray();
        try {
            if (this.f53611a != null && this.f53611a.size() != 0) {
                Iterator<x1> it = this.f53611a.iterator();
                while (it.hasNext()) {
                    x1 next = it.next();
                    if (next != null) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("pic_url_bigger", next.a());
                        jSONObject2.put("link", next.b());
                        jSONArray2.put(jSONObject2);
                    }
                }
                jSONObject.put("banner", jSONArray2);
            }
            jSONObject.put("prevtime", this.f53615e);
        } catch (Exception e2) {
            BdLog.e(e2.toString());
        }
        if (this.f53616f != null && this.f53616f.size() != 0) {
            Iterator<d> it2 = this.f53616f.iterator();
            while (it2.hasNext()) {
                d next2 = it2.next();
                if (next2 != null) {
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("title", next2.f53637a);
                    jSONObject3.put("type", next2.f53638b);
                    jSONObject3.put("pic", next2.f53639c);
                    jSONObject3.put("link", next2.f53640d);
                    ArrayList<c> arrayList = next2.f53641e;
                    if (arrayList != null && arrayList.size() != 0) {
                        JSONArray jSONArray3 = new JSONArray();
                        Iterator<c> it3 = arrayList.iterator();
                        while (it3.hasNext()) {
                            c next3 = it3.next();
                            if (next3 != null) {
                                JSONObject jSONObject4 = new JSONObject();
                                jSONObject4.put("forum_id", next3.f53629a);
                                jSONObject4.put("forum_name", next3.f53630b);
                                jSONObject4.put("avatar", next3.f53631c);
                                jSONObject4.put("explain", next3.f53634f);
                                jSONObject4.put("desc", next3.f53635g);
                                jSONObject4.put("tag", next3.f53636h);
                                jSONObject4.put("thread_num", next3.f53633e);
                                jSONObject4.put("member_count", next3.f53632d);
                                jSONObject4.put("link", next3.i);
                                jSONArray3.put(jSONObject4);
                            }
                        }
                        jSONObject3.put("forum_list", jSONArray3);
                        jSONArray.put(jSONObject3);
                    }
                    jSONArray.put(jSONObject3);
                }
            }
            JSONObject jSONObject5 = new JSONObject();
            jSONObject5.put("new_list", jSONArray);
            jSONObject.put("new_recommend_topic", jSONObject5);
            return jSONObject.toString();
        }
        return jSONObject.toString();
    }

    public ArrayList<x1> e() {
        return this.f53611a;
    }

    public long f() {
        return this.f53615e;
    }

    public boolean g() {
        ArrayList<a> arrayList;
        ArrayList<b> arrayList2;
        if (this.f53614d) {
            ArrayList<x1> arrayList3 = this.f53611a;
            return (arrayList3 == null || arrayList3.size() == 0) && ((arrayList = this.f53612b) == null || arrayList.size() == 0) && ((arrayList2 = this.f53613c) == null || arrayList2.size() == 0);
        }
        return true;
    }

    public final void h(JSONArray jSONArray) {
        if (jSONArray != null) {
            try {
                if (jSONArray.length() == 0) {
                    return;
                }
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    if (jSONObject != null) {
                        String optString = jSONObject.optString("pic_url_bigger", "");
                        String optString2 = jSONObject.optString("link", "");
                        String optString3 = jSONObject.optString("template_id", "");
                        if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                            x1 x1Var = new x1();
                            x1Var.d(optString);
                            x1Var.e(optString2);
                            x1Var.f(optString3);
                            this.f53611a.add(x1Var);
                        }
                    }
                }
            } catch (Exception e2) {
                BdLog.e(e2.toString());
            }
        }
    }

    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v3, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r2v8 */
    public final void i(JSONArray jSONArray) {
        int optInt;
        JSONArray optJSONArray;
        int i;
        String str;
        if (jSONArray != null) {
            try {
                if (jSONArray.length() == 0) {
                    return;
                }
                boolean z = false;
                int i2 = 0;
                int i3 = 0;
                while (i2 < jSONArray.length()) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i2);
                    if (jSONObject != null && (optInt = jSONObject.optInt("type", -1)) != -1) {
                        boolean z2 = true;
                        String str2 = "";
                        if (optInt == 1) {
                            i3++;
                            a aVar = new a();
                            aVar.f53617a = jSONObject.optString("title", "");
                            aVar.f53618b = jSONObject.optString("link", "");
                            aVar.f53619c = jSONObject.optString("pic", "");
                            aVar.f53620d = z;
                            this.f53612b.add(aVar);
                        } else if (optInt == 3) {
                            i3++;
                            a aVar2 = new a();
                            aVar2.f53617a = jSONObject.optString("title", "");
                            aVar2.f53618b = jSONObject.optString("link", "");
                            aVar2.f53619c = jSONObject.optString("pic", "");
                            aVar2.f53620d = true;
                            this.f53612b.add(aVar2);
                        } else if ((optInt == 2 || optInt == 0) && (optJSONArray = jSONObject.optJSONArray("forum_list")) != null && optJSONArray.length() != 0) {
                            b bVar = new b();
                            bVar.f53621a = true;
                            int i4 = i2 - i3;
                            bVar.m = i4;
                            if (optInt == 2) {
                                bVar.f53623c = true;
                            } else {
                                bVar.f53623c = z;
                            }
                            bVar.l = jSONObject.optString("link", "");
                            bVar.f53622b = jSONObject.optString("title", "");
                            this.f53613c.add(bVar);
                            int i5 = 0;
                            ?? r2 = z;
                            while (i5 < optJSONArray.length()) {
                                JSONObject jSONObject2 = optJSONArray.getJSONObject(i5);
                                if (jSONObject2 == null) {
                                    i = i2;
                                    str = str2;
                                } else {
                                    b bVar2 = new b();
                                    if (optInt == 2) {
                                        bVar2.f53623c = z2;
                                    } else {
                                        bVar2.f53623c = r2;
                                    }
                                    bVar2.f53621a = r2;
                                    bVar2.m = i4;
                                    bVar2.n = i5;
                                    bVar2.f53624d = jSONObject2.optInt("forum_id", r2);
                                    bVar2.f53625e = jSONObject2.optString("forum_name", str2);
                                    bVar2.f53626f = jSONObject2.optString("avatar", str2);
                                    bVar2.f53628h = jSONObject2.optString("explain", str2);
                                    bVar2.i = jSONObject2.optString("desc", str2);
                                    bVar2.f53627g = jSONObject2.optString("tag", str2);
                                    i = i2;
                                    bVar2.j = jSONObject2.optLong("member_count", 0L);
                                    bVar2.k = jSONObject2.optLong("thread_num", 0L);
                                    str = str2;
                                    bVar2.l = jSONObject2.optString("link", str);
                                    this.f53613c.add(bVar2);
                                }
                                i5++;
                                str2 = str;
                                i2 = i;
                                r2 = 0;
                                z2 = true;
                            }
                        }
                    }
                    i2++;
                    z = false;
                }
            } catch (Exception e2) {
                BdLog.e(e2.toString());
            }
        }
    }

    public void j(String str) {
        if (str != null && str.length() >= 1) {
            try {
                k(new JSONObject(str));
                l(str);
                return;
            } catch (Exception e2) {
                this.f53614d = false;
                BdLog.e(e2.toString());
                return;
            }
        }
        this.f53614d = false;
    }

    public void k(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            h(jSONObject.optJSONArray("banner"));
            this.f53615e = jSONObject.optLong("prevtime");
            JSONObject optJSONObject = jSONObject.optJSONObject("new_recommend_topic");
            if (optJSONObject == null) {
                return;
            }
            i(optJSONObject.optJSONArray("new_list"));
        } catch (Exception e2) {
            this.f53614d = false;
            BdLog.e(e2.toString());
        }
    }

    public final void l(String str) {
        JSONArray optJSONArray;
        if (str == null) {
            return;
        }
        try {
            JSONObject optJSONObject = new JSONObject(str).optJSONObject("new_recommend_topic");
            if (optJSONObject != null && (optJSONArray = optJSONObject.optJSONArray("new_list")) != null && optJSONArray.length() != 0) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject jSONObject = optJSONArray.getJSONObject(i);
                    if (jSONObject != null) {
                        d dVar = new d();
                        this.f53616f.add(dVar);
                        dVar.f53641e = new ArrayList<>();
                        dVar.f53637a = jSONObject.optString("title", "");
                        dVar.f53638b = jSONObject.optInt("type", -1);
                        dVar.f53639c = jSONObject.optString("pic", "");
                        dVar.f53640d = jSONObject.optString("link", "");
                        JSONArray optJSONArray2 = jSONObject.optJSONArray("forum_list");
                        if (optJSONArray2 != null && optJSONArray2.length() != 0) {
                            for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                                JSONObject jSONObject2 = optJSONArray2.getJSONObject(i2);
                                if (jSONObject2 != null) {
                                    c cVar = new c();
                                    cVar.f53629a = jSONObject2.optInt("forum_id", 0);
                                    cVar.f53630b = jSONObject2.optString("forum_name", "");
                                    cVar.f53631c = jSONObject2.optString("avatar", "");
                                    cVar.f53634f = jSONObject2.optString("explain", "");
                                    cVar.f53635g = jSONObject2.optString("desc", "");
                                    cVar.f53636h = jSONObject2.optString("tag", "");
                                    cVar.f53632d = jSONObject2.optLong("member_count", 0L);
                                    cVar.f53633e = jSONObject2.optLong("thread_num", 0L);
                                    cVar.i = jSONObject2.optString("link", "");
                                    dVar.f53641e.add(cVar);
                                }
                            }
                        }
                    }
                }
            }
        } catch (Exception e2) {
            BdLog.e(e2.toString());
        }
    }

    public void m(ArrayList<x1> arrayList) {
        this.f53611a = arrayList;
    }

    public void n(long j) {
        this.f53615e = j;
    }
}

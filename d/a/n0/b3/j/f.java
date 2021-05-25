package d.a.n0.b3.j;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import d.a.m0.r.q.x1;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class f {

    /* renamed from: e  reason: collision with root package name */
    public long f52219e;

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<x1> f52215a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<a> f52216b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<b> f52217c = new ArrayList<>();

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<d> f52220f = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    public boolean f52218d = true;

    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f52221a;

        /* renamed from: b  reason: collision with root package name */
        public String f52222b;

        /* renamed from: c  reason: collision with root package name */
        public String f52223c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f52224d;
    }

    /* loaded from: classes5.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public boolean f52225a;

        /* renamed from: b  reason: collision with root package name */
        public String f52226b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f52227c;

        /* renamed from: d  reason: collision with root package name */
        public int f52228d;

        /* renamed from: e  reason: collision with root package name */
        public String f52229e;

        /* renamed from: f  reason: collision with root package name */
        public String f52230f;

        /* renamed from: g  reason: collision with root package name */
        public String f52231g;

        /* renamed from: h  reason: collision with root package name */
        public String f52232h;

        /* renamed from: i  reason: collision with root package name */
        public String f52233i;
        public long j;
        public long k;
        public String l;
        public int m;
        public int n;
    }

    /* loaded from: classes5.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public int f52234a;

        /* renamed from: b  reason: collision with root package name */
        public String f52235b;

        /* renamed from: c  reason: collision with root package name */
        public String f52236c;

        /* renamed from: d  reason: collision with root package name */
        public long f52237d;

        /* renamed from: e  reason: collision with root package name */
        public long f52238e;

        /* renamed from: f  reason: collision with root package name */
        public String f52239f;

        /* renamed from: g  reason: collision with root package name */
        public String f52240g;

        /* renamed from: h  reason: collision with root package name */
        public String f52241h;

        /* renamed from: i  reason: collision with root package name */
        public String f52242i;
    }

    /* loaded from: classes5.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public String f52243a;

        /* renamed from: b  reason: collision with root package name */
        public int f52244b;

        /* renamed from: c  reason: collision with root package name */
        public String f52245c;

        /* renamed from: d  reason: collision with root package name */
        public String f52246d;

        /* renamed from: e  reason: collision with root package name */
        public ArrayList<c> f52247e;
    }

    public ArrayList<a> a() {
        return this.f52216b;
    }

    public ArrayList<b> b() {
        return this.f52217c;
    }

    public boolean c() {
        return true;
    }

    public String d() {
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        JSONArray jSONArray2 = new JSONArray();
        try {
            if (this.f52215a != null && this.f52215a.size() != 0) {
                Iterator<x1> it = this.f52215a.iterator();
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
            jSONObject.put("prevtime", this.f52219e);
        } catch (Exception e2) {
            BdLog.e(e2.toString());
        }
        if (this.f52220f != null && this.f52220f.size() != 0) {
            Iterator<d> it2 = this.f52220f.iterator();
            while (it2.hasNext()) {
                d next2 = it2.next();
                if (next2 != null) {
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("title", next2.f52243a);
                    jSONObject3.put("type", next2.f52244b);
                    jSONObject3.put("pic", next2.f52245c);
                    jSONObject3.put("link", next2.f52246d);
                    ArrayList<c> arrayList = next2.f52247e;
                    if (arrayList != null && arrayList.size() != 0) {
                        JSONArray jSONArray3 = new JSONArray();
                        Iterator<c> it3 = arrayList.iterator();
                        while (it3.hasNext()) {
                            c next3 = it3.next();
                            if (next3 != null) {
                                JSONObject jSONObject4 = new JSONObject();
                                jSONObject4.put("forum_id", next3.f52234a);
                                jSONObject4.put("forum_name", next3.f52235b);
                                jSONObject4.put("avatar", next3.f52236c);
                                jSONObject4.put("explain", next3.f52239f);
                                jSONObject4.put("desc", next3.f52240g);
                                jSONObject4.put("tag", next3.f52241h);
                                jSONObject4.put("thread_num", next3.f52238e);
                                jSONObject4.put("member_count", next3.f52237d);
                                jSONObject4.put("link", next3.f52242i);
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
        return this.f52215a;
    }

    public long f() {
        return this.f52219e;
    }

    public boolean g() {
        ArrayList<a> arrayList;
        ArrayList<b> arrayList2;
        if (this.f52218d) {
            ArrayList<x1> arrayList3 = this.f52215a;
            return (arrayList3 == null || arrayList3.size() == 0) && ((arrayList = this.f52216b) == null || arrayList.size() == 0) && ((arrayList2 = this.f52217c) == null || arrayList2.size() == 0);
        }
        return true;
    }

    public final void h(JSONArray jSONArray) {
        if (jSONArray != null) {
            try {
                if (jSONArray.length() == 0) {
                    return;
                }
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i2);
                    if (jSONObject != null) {
                        String optString = jSONObject.optString("pic_url_bigger", "");
                        String optString2 = jSONObject.optString("link", "");
                        String optString3 = jSONObject.optString("template_id", "");
                        if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                            x1 x1Var = new x1();
                            x1Var.d(optString);
                            x1Var.e(optString2);
                            x1Var.f(optString3);
                            this.f52215a.add(x1Var);
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
        int i2;
        String str;
        if (jSONArray != null) {
            try {
                if (jSONArray.length() == 0) {
                    return;
                }
                boolean z = false;
                int i3 = 0;
                int i4 = 0;
                while (i3 < jSONArray.length()) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i3);
                    if (jSONObject != null && (optInt = jSONObject.optInt("type", -1)) != -1) {
                        boolean z2 = true;
                        String str2 = "";
                        if (optInt == 1) {
                            i4++;
                            a aVar = new a();
                            aVar.f52221a = jSONObject.optString("title", "");
                            aVar.f52222b = jSONObject.optString("link", "");
                            aVar.f52223c = jSONObject.optString("pic", "");
                            aVar.f52224d = z;
                            this.f52216b.add(aVar);
                        } else if (optInt == 3) {
                            i4++;
                            a aVar2 = new a();
                            aVar2.f52221a = jSONObject.optString("title", "");
                            aVar2.f52222b = jSONObject.optString("link", "");
                            aVar2.f52223c = jSONObject.optString("pic", "");
                            aVar2.f52224d = true;
                            this.f52216b.add(aVar2);
                        } else if ((optInt == 2 || optInt == 0) && (optJSONArray = jSONObject.optJSONArray("forum_list")) != null && optJSONArray.length() != 0) {
                            b bVar = new b();
                            bVar.f52225a = true;
                            int i5 = i3 - i4;
                            bVar.m = i5;
                            if (optInt == 2) {
                                bVar.f52227c = true;
                            } else {
                                bVar.f52227c = z;
                            }
                            bVar.l = jSONObject.optString("link", "");
                            bVar.f52226b = jSONObject.optString("title", "");
                            this.f52217c.add(bVar);
                            int i6 = 0;
                            ?? r2 = z;
                            while (i6 < optJSONArray.length()) {
                                JSONObject jSONObject2 = optJSONArray.getJSONObject(i6);
                                if (jSONObject2 == null) {
                                    i2 = i3;
                                    str = str2;
                                } else {
                                    b bVar2 = new b();
                                    if (optInt == 2) {
                                        bVar2.f52227c = z2;
                                    } else {
                                        bVar2.f52227c = r2;
                                    }
                                    bVar2.f52225a = r2;
                                    bVar2.m = i5;
                                    bVar2.n = i6;
                                    bVar2.f52228d = jSONObject2.optInt("forum_id", r2);
                                    bVar2.f52229e = jSONObject2.optString("forum_name", str2);
                                    bVar2.f52230f = jSONObject2.optString("avatar", str2);
                                    bVar2.f52232h = jSONObject2.optString("explain", str2);
                                    bVar2.f52233i = jSONObject2.optString("desc", str2);
                                    bVar2.f52231g = jSONObject2.optString("tag", str2);
                                    i2 = i3;
                                    bVar2.j = jSONObject2.optLong("member_count", 0L);
                                    bVar2.k = jSONObject2.optLong("thread_num", 0L);
                                    str = str2;
                                    bVar2.l = jSONObject2.optString("link", str);
                                    this.f52217c.add(bVar2);
                                }
                                i6++;
                                str2 = str;
                                i3 = i2;
                                r2 = 0;
                                z2 = true;
                            }
                        }
                    }
                    i3++;
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
                this.f52218d = false;
                BdLog.e(e2.toString());
                return;
            }
        }
        this.f52218d = false;
    }

    public void k(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            h(jSONObject.optJSONArray("banner"));
            this.f52219e = jSONObject.optLong("prevtime");
            JSONObject optJSONObject = jSONObject.optJSONObject("new_recommend_topic");
            if (optJSONObject == null) {
                return;
            }
            i(optJSONObject.optJSONArray("new_list"));
        } catch (Exception e2) {
            this.f52218d = false;
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
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    JSONObject jSONObject = optJSONArray.getJSONObject(i2);
                    if (jSONObject != null) {
                        d dVar = new d();
                        this.f52220f.add(dVar);
                        dVar.f52247e = new ArrayList<>();
                        dVar.f52243a = jSONObject.optString("title", "");
                        dVar.f52244b = jSONObject.optInt("type", -1);
                        dVar.f52245c = jSONObject.optString("pic", "");
                        dVar.f52246d = jSONObject.optString("link", "");
                        JSONArray optJSONArray2 = jSONObject.optJSONArray("forum_list");
                        if (optJSONArray2 != null && optJSONArray2.length() != 0) {
                            for (int i3 = 0; i3 < optJSONArray2.length(); i3++) {
                                JSONObject jSONObject2 = optJSONArray2.getJSONObject(i3);
                                if (jSONObject2 != null) {
                                    c cVar = new c();
                                    cVar.f52234a = jSONObject2.optInt("forum_id", 0);
                                    cVar.f52235b = jSONObject2.optString("forum_name", "");
                                    cVar.f52236c = jSONObject2.optString("avatar", "");
                                    cVar.f52239f = jSONObject2.optString("explain", "");
                                    cVar.f52240g = jSONObject2.optString("desc", "");
                                    cVar.f52241h = jSONObject2.optString("tag", "");
                                    cVar.f52237d = jSONObject2.optLong("member_count", 0L);
                                    cVar.f52238e = jSONObject2.optLong("thread_num", 0L);
                                    cVar.f52242i = jSONObject2.optString("link", "");
                                    dVar.f52247e.add(cVar);
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
        this.f52215a = arrayList;
    }

    public void n(long j) {
        this.f52219e = j;
    }
}

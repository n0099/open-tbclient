package d.b.i0.z2.j;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import d.b.h0.r.q.x1;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class f {

    /* renamed from: e  reason: collision with root package name */
    public long f63574e;

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<x1> f63570a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<a> f63571b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<b> f63572c = new ArrayList<>();

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<d> f63575f = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    public boolean f63573d = true;

    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f63576a;

        /* renamed from: b  reason: collision with root package name */
        public String f63577b;

        /* renamed from: c  reason: collision with root package name */
        public String f63578c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f63579d;
    }

    /* loaded from: classes5.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public boolean f63580a;

        /* renamed from: b  reason: collision with root package name */
        public String f63581b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f63582c;

        /* renamed from: d  reason: collision with root package name */
        public int f63583d;

        /* renamed from: e  reason: collision with root package name */
        public String f63584e;

        /* renamed from: f  reason: collision with root package name */
        public String f63585f;

        /* renamed from: g  reason: collision with root package name */
        public String f63586g;

        /* renamed from: h  reason: collision with root package name */
        public String f63587h;
        public String i;
        public long j;
        public long k;
        public String l;
        public int m;
        public int n;
    }

    /* loaded from: classes5.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public int f63588a;

        /* renamed from: b  reason: collision with root package name */
        public String f63589b;

        /* renamed from: c  reason: collision with root package name */
        public String f63590c;

        /* renamed from: d  reason: collision with root package name */
        public long f63591d;

        /* renamed from: e  reason: collision with root package name */
        public long f63592e;

        /* renamed from: f  reason: collision with root package name */
        public String f63593f;

        /* renamed from: g  reason: collision with root package name */
        public String f63594g;

        /* renamed from: h  reason: collision with root package name */
        public String f63595h;
        public String i;
    }

    /* loaded from: classes5.dex */
    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public String f63596a;

        /* renamed from: b  reason: collision with root package name */
        public int f63597b;

        /* renamed from: c  reason: collision with root package name */
        public String f63598c;

        /* renamed from: d  reason: collision with root package name */
        public String f63599d;

        /* renamed from: e  reason: collision with root package name */
        public ArrayList<c> f63600e;
    }

    public ArrayList<a> a() {
        return this.f63571b;
    }

    public ArrayList<b> b() {
        return this.f63572c;
    }

    public boolean c() {
        return true;
    }

    public String d() {
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        JSONArray jSONArray2 = new JSONArray();
        try {
            if (this.f63570a != null && this.f63570a.size() != 0) {
                Iterator<x1> it = this.f63570a.iterator();
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
            jSONObject.put("prevtime", this.f63574e);
        } catch (Exception e2) {
            BdLog.e(e2.toString());
        }
        if (this.f63575f != null && this.f63575f.size() != 0) {
            Iterator<d> it2 = this.f63575f.iterator();
            while (it2.hasNext()) {
                d next2 = it2.next();
                if (next2 != null) {
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("title", next2.f63596a);
                    jSONObject3.put("type", next2.f63597b);
                    jSONObject3.put("pic", next2.f63598c);
                    jSONObject3.put("link", next2.f63599d);
                    ArrayList<c> arrayList = next2.f63600e;
                    if (arrayList != null && arrayList.size() != 0) {
                        JSONArray jSONArray3 = new JSONArray();
                        Iterator<c> it3 = arrayList.iterator();
                        while (it3.hasNext()) {
                            c next3 = it3.next();
                            if (next3 != null) {
                                JSONObject jSONObject4 = new JSONObject();
                                jSONObject4.put("forum_id", next3.f63588a);
                                jSONObject4.put("forum_name", next3.f63589b);
                                jSONObject4.put("avatar", next3.f63590c);
                                jSONObject4.put("explain", next3.f63593f);
                                jSONObject4.put("desc", next3.f63594g);
                                jSONObject4.put("tag", next3.f63595h);
                                jSONObject4.put("thread_num", next3.f63592e);
                                jSONObject4.put("member_count", next3.f63591d);
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
        return this.f63570a;
    }

    public long f() {
        return this.f63574e;
    }

    public boolean g() {
        ArrayList<a> arrayList;
        ArrayList<b> arrayList2;
        if (this.f63573d) {
            ArrayList<x1> arrayList3 = this.f63570a;
            return (arrayList3 == null || arrayList3.size() == 0) && ((arrayList = this.f63571b) == null || arrayList.size() == 0) && ((arrayList2 = this.f63572c) == null || arrayList2.size() == 0);
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
                            this.f63570a.add(x1Var);
                        }
                    }
                }
            } catch (Exception e2) {
                BdLog.e(e2.toString());
            }
        }
    }

    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v3, types: [int, boolean] */
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
                            aVar.f63576a = jSONObject.optString("title", "");
                            aVar.f63577b = jSONObject.optString("link", "");
                            aVar.f63578c = jSONObject.optString("pic", "");
                            aVar.f63579d = z;
                            this.f63571b.add(aVar);
                        } else if (optInt == 3) {
                            i3++;
                            a aVar2 = new a();
                            aVar2.f63576a = jSONObject.optString("title", "");
                            aVar2.f63577b = jSONObject.optString("link", "");
                            aVar2.f63578c = jSONObject.optString("pic", "");
                            aVar2.f63579d = true;
                            this.f63571b.add(aVar2);
                        } else if ((optInt == 2 || optInt == 0) && (optJSONArray = jSONObject.optJSONArray("forum_list")) != null && optJSONArray.length() != 0) {
                            b bVar = new b();
                            bVar.f63580a = true;
                            int i4 = i2 - i3;
                            bVar.m = i4;
                            if (optInt == 2) {
                                bVar.f63582c = true;
                            } else {
                                bVar.f63582c = z;
                            }
                            bVar.l = jSONObject.optString("link", "");
                            bVar.f63581b = jSONObject.optString("title", "");
                            this.f63572c.add(bVar);
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
                                        bVar2.f63582c = z2;
                                    } else {
                                        bVar2.f63582c = r2;
                                    }
                                    bVar2.f63580a = r2;
                                    bVar2.m = i4;
                                    bVar2.n = i5;
                                    bVar2.f63583d = jSONObject2.optInt("forum_id", r2);
                                    bVar2.f63584e = jSONObject2.optString("forum_name", str2);
                                    bVar2.f63585f = jSONObject2.optString("avatar", str2);
                                    bVar2.f63587h = jSONObject2.optString("explain", str2);
                                    bVar2.i = jSONObject2.optString("desc", str2);
                                    bVar2.f63586g = jSONObject2.optString("tag", str2);
                                    i = i2;
                                    bVar2.j = jSONObject2.optLong("member_count", 0L);
                                    bVar2.k = jSONObject2.optLong("thread_num", 0L);
                                    str = str2;
                                    bVar2.l = jSONObject2.optString("link", str);
                                    this.f63572c.add(bVar2);
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
                this.f63573d = false;
                BdLog.e(e2.toString());
                return;
            }
        }
        this.f63573d = false;
    }

    public void k(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            h(jSONObject.optJSONArray("banner"));
            this.f63574e = jSONObject.optLong("prevtime");
            JSONObject optJSONObject = jSONObject.optJSONObject("new_recommend_topic");
            if (optJSONObject == null) {
                return;
            }
            i(optJSONObject.optJSONArray("new_list"));
        } catch (Exception e2) {
            this.f63573d = false;
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
                        this.f63575f.add(dVar);
                        dVar.f63600e = new ArrayList<>();
                        dVar.f63596a = jSONObject.optString("title", "");
                        dVar.f63597b = jSONObject.optInt("type", -1);
                        dVar.f63598c = jSONObject.optString("pic", "");
                        dVar.f63599d = jSONObject.optString("link", "");
                        JSONArray optJSONArray2 = jSONObject.optJSONArray("forum_list");
                        if (optJSONArray2 != null && optJSONArray2.length() != 0) {
                            for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                                JSONObject jSONObject2 = optJSONArray2.getJSONObject(i2);
                                if (jSONObject2 != null) {
                                    c cVar = new c();
                                    cVar.f63588a = jSONObject2.optInt("forum_id", 0);
                                    cVar.f63589b = jSONObject2.optString("forum_name", "");
                                    cVar.f63590c = jSONObject2.optString("avatar", "");
                                    cVar.f63593f = jSONObject2.optString("explain", "");
                                    cVar.f63594g = jSONObject2.optString("desc", "");
                                    cVar.f63595h = jSONObject2.optString("tag", "");
                                    cVar.f63591d = jSONObject2.optLong("member_count", 0L);
                                    cVar.f63592e = jSONObject2.optLong("thread_num", 0L);
                                    cVar.i = jSONObject2.optString("link", "");
                                    dVar.f63600e.add(cVar);
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
        this.f63570a = arrayList;
    }

    public void n(long j) {
        this.f63574e = j;
    }
}

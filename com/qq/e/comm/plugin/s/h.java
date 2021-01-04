package com.qq.e.comm.plugin.s;

import android.graphics.Point;
import com.qq.e.comm.util.GDTLogger;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    private String f12752a;

    /* renamed from: b  reason: collision with root package name */
    private List<Integer> f12753b;
    private List<Point> c;
    private List<String> d;
    private boolean e;

    public static h a(JSONObject jSONObject) {
        if (jSONObject != null) {
            h hVar = new h();
            hVar.a(jSONObject.optString("date"));
            hVar.a(d.b(jSONObject.optJSONArray("index")));
            JSONArray optJSONArray = jSONObject.optJSONArray("effectivetime");
            ArrayList arrayList = new ArrayList();
            if (optJSONArray != null && optJSONArray.length() > 0) {
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        Point point = new Point();
                        point.x = optJSONObject.optInt("start");
                        point.y = optJSONObject.optInt("end");
                        arrayList.add(point);
                    }
                }
            }
            hVar.b(arrayList);
            hVar.c(d.a(jSONObject.optJSONArray("server_data")));
            hVar.a(jSONObject.optInt("is_first_play") == 1);
            return hVar;
        }
        return null;
    }

    public static List<h> a(JSONArray jSONArray) {
        ArrayList arrayList = new ArrayList();
        if (jSONArray != null) {
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 >= jSONArray.length()) {
                    break;
                }
                Object opt = jSONArray.opt(i2);
                if (opt instanceof JSONObject) {
                    h a2 = a((JSONObject) opt);
                    if (a2 != null) {
                        arrayList.add(a2);
                    }
                } else {
                    GDTLogger.e("Slot.parseList error !");
                }
                i = i2 + 1;
            }
        }
        return arrayList;
    }

    public String a() {
        return this.f12752a;
    }

    public String a(Integer num) {
        int indexOf;
        List<Integer> b2 = b();
        List<String> d = d();
        if (b2 == null || d == null || (indexOf = b2.indexOf(num)) < 0 || indexOf >= d.size()) {
            if (d == null || d.size() <= 0) {
                return null;
            }
            return d.get(0);
        }
        return d.get(indexOf);
    }

    public void a(String str) {
        this.f12752a = str;
    }

    public void a(List<Integer> list) {
        this.f12753b = list;
    }

    public void a(boolean z) {
        this.e = z;
    }

    public List<Integer> b() {
        return this.f12753b;
    }

    public void b(List<Point> list) {
        this.c = list;
    }

    public List<Point> c() {
        return this.c;
    }

    public void c(List<String> list) {
        this.d = list;
    }

    public List<String> d() {
        return this.d;
    }

    public boolean e() {
        return this.e;
    }
}

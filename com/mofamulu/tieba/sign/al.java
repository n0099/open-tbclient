package com.mofamulu.tieba.sign;

import com.mofamulu.tieba.ch.bf;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;
import java.util.TimeZone;
import org.json.JSONArray;
import org.json.JSONException;
/* loaded from: classes.dex */
public class al {
    public static TimeZone k;
    protected String a;
    protected String b;
    protected String c;
    protected String d;
    protected String e;
    protected int g;
    protected List h;
    protected List i;
    private boolean l;
    protected int f = 0;
    protected int j = 0;

    public String a() {
        if (this.i == null) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        for (as asVar : this.i) {
            jSONArray.put(asVar.a());
        }
        return jSONArray.toString();
    }

    public void a(String str) {
        if (!bf.a(str)) {
            LinkedList linkedList = new LinkedList();
            try {
                JSONArray jSONArray = new JSONArray(str);
                for (int i = 0; i < jSONArray.length(); i++) {
                    linkedList.addLast(new as(jSONArray.getJSONObject(i)));
                }
            } catch (JSONException e) {
            }
            this.i = linkedList;
        }
    }

    public String b() {
        if (this.h == null) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        for (String str : this.h) {
            jSONArray.put(str);
        }
        return jSONArray.toString();
    }

    public void b(String str) {
        if (!bf.a(str)) {
            LinkedList linkedList = new LinkedList();
            try {
                JSONArray jSONArray = new JSONArray(str);
                for (int i = 0; i < jSONArray.length(); i++) {
                    linkedList.addLast(jSONArray.getString(i));
                }
            } catch (JSONException e) {
            }
            this.h = linkedList;
        }
    }

    static {
        try {
            k = TimeZone.getTimeZone("GMT+8");
        } catch (Throwable th) {
            k = TimeZone.getDefault();
        }
    }

    public static int c() {
        Calendar calendar = Calendar.getInstance(k);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        simpleDateFormat.setCalendar(calendar);
        simpleDateFormat.setTimeZone(k);
        return Integer.parseInt(simpleDateFormat.format(calendar.getTime()));
    }

    public String d() {
        return this.a;
    }

    public String e() {
        return this.b;
    }

    public String f() {
        return this.c;
    }

    public void c(String str) {
        this.c = str;
    }

    public void a(List list) {
        this.i = list;
    }

    public List g() {
        return this.h;
    }

    public void b(List list) {
        this.h = list;
    }

    public void d(String str) {
        this.e = str;
    }

    public String h() {
        return this.d;
    }

    public void e(String str) {
        this.d = str;
    }

    private String m() {
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        for (as asVar : this.i) {
            if (asVar.c() == 10) {
                i4++;
            } else if (asVar.c() == 2) {
                i3++;
            } else if (asVar.c() == 1) {
                i2++;
            } else {
                i++;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("成功").append(i4).append("个，失败").append(i2).append("个，不支持").append(i3).append("个；剩余").append(i).append("个。");
        return sb.toString();
    }

    public String i() {
        if (this.f != 0) {
            return "签到出错，请重新登录[" + this.e + "]；最后一次成功：" + (this.g == 0 ? "没有成功过" : String.valueOf(this.g));
        } else if (this.l) {
            if (this.i == null) {
                return "正在签到中：读取要签到的贴吧列表……";
            }
            return "正在签到中：" + m();
        } else if (this.g == 0) {
            return "无法检测状态，尚未签完过";
        } else {
            if (c() == this.g) {
                return "今天已经签完。结果：" + m();
            }
            return "正常等待签到。上次签到：" + this.g + ", 结果：" + m();
        }
    }

    public void a(int i) {
        this.f = i;
    }

    public int j() {
        return this.g;
    }

    public void b(int i) {
        this.g = i;
    }

    public boolean k() {
        return this.l;
    }

    public void a(boolean z) {
        this.l = z;
    }

    public int l() {
        return this.j;
    }
}

package com.qq.e.comm.plugin.ab;

import android.text.TextUtils;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.plugin.util.af;
import com.qq.e.comm.plugin.util.ai;
import com.qq.e.comm.plugin.y.u;
import java.net.URL;
import java.net.URLEncoder;
import org.json.JSONObject;
/* loaded from: classes15.dex */
public class b {

    /* renamed from: b  reason: collision with root package name */
    public static int f11705b = 1;
    public static int c = 2;
    public static int d = 3;
    public static int e = 10;
    public static int f = 11;
    public static int g = 12;

    /* renamed from: a  reason: collision with root package name */
    String f11706a;
    int h = 100;
    a i = a.BEFORE;
    long j;

    /* loaded from: classes15.dex */
    enum a {
        BEFORE,
        LOADING,
        LOAD_SUCCESS,
        LOAD_FAIL,
        REPORT_FINISH
    }

    public b(String str, long j) {
        this.f11706a = str;
        this.j = j;
        a();
        ai.b("CGIWebReporter", ":report url = %s", this.f11706a);
    }

    private void a() {
        if (TextUtils.isEmpty(this.f11706a)) {
            return;
        }
        this.f11706a = this.f11706a.replaceAll("__VERSION__", GDTADManager.getInstance().getAppStatus().getAPPVersion()).replaceAll("__CLICK_LPP__", c()).replaceAll("__OS_TYPE__", "2");
    }

    public static void a(int i, long j, com.qq.e.comm.plugin.y.c cVar, String str, String str2) {
        com.qq.e.comm.plugin.y.g b2 = new com.qq.e.comm.plugin.y.g(i).b(System.currentTimeMillis() - j);
        b2.a(cVar);
        b2.a(new com.qq.e.comm.plugin.y.d().a("url", str).a("msg", str2));
        u.a(b2);
    }

    public static boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return new URL(str).getHost().contains("gdt.qq.com");
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    private long b() {
        return System.currentTimeMillis() - this.j;
    }

    private String c() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("click_time", this.j > 0 ? this.j : System.currentTimeMillis());
            return URLEncoder.encode(jSONObject.toString(), "UTF-8");
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    void a(int i, long j) {
        String str = this.f11706a;
        if (!TextUtils.isEmpty(str)) {
            str = str.replaceAll("__PAGE_ACTION_ID__", String.valueOf(i)).replaceAll("__PAGE_TIME__", String.valueOf(j));
        }
        ai.b("CGIWebReporter", ":report now,action is %d ", Integer.valueOf(i));
        ai.b("CGIWebReporter", ":report time %d ", Long.valueOf(j));
        ai.b("CGIWebReporter", ":report last url %s", str);
        af.a(str);
    }

    public void a(String str, int i) {
        if (TextUtils.isEmpty(this.f11706a)) {
            return;
        }
        ai.b("CGIWebReporter", ":cur load url = %s", str);
        switch (this.i) {
            case BEFORE:
                if (i == f11705b) {
                    if (a(str) && this.h == 100) {
                        this.h = 101;
                    }
                    if (this.j <= 0) {
                        this.j = System.currentTimeMillis();
                    }
                    this.i = a.LOADING;
                    break;
                }
                break;
            case LOADING:
                if (i != c) {
                    if (i != d) {
                        if (i != e) {
                            if (i == f) {
                                this.i = a.REPORT_FINISH;
                                a(6, b());
                                break;
                            }
                        } else {
                            this.i = a.REPORT_FINISH;
                            a(5, b());
                            break;
                        }
                    } else {
                        this.i = a.LOAD_FAIL;
                        if (!a(str)) {
                            a(4, b());
                            break;
                        }
                    }
                } else {
                    this.i = a.LOAD_SUCCESS;
                    a(3, b());
                    break;
                }
                break;
            case LOAD_SUCCESS:
                if (i == e || i == f) {
                    this.i = a.REPORT_FINISH;
                    a(7, b());
                    break;
                }
                break;
            case LOAD_FAIL:
                if (i != f11705b) {
                    if (i == f) {
                        this.i = a.REPORT_FINISH;
                        a(7, b());
                        break;
                    }
                } else {
                    this.i = a.REPORT_FINISH;
                    a(4, b());
                    this.j = System.currentTimeMillis();
                    break;
                }
                break;
        }
        if (this.h == 101) {
            if (i == f11705b && this.i == a.LOADING && !a(str)) {
                a(1, b());
                this.h = 102;
            } else if (a(str)) {
                if (i == g || i == d) {
                    this.h = 102;
                    a(2, b());
                }
            }
        }
    }
}

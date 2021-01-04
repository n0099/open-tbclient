package com.qq.e.comm.plugin.ab.c;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.os.PowerManager;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import com.qq.e.comm.plugin.util.af;
import com.qq.e.comm.plugin.util.t;
import com.qq.e.comm.plugin.w.d;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.StringUtil;
import java.util.ArrayList;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d implements e {

    /* renamed from: a  reason: collision with root package name */
    private Point f12028a;

    /* loaded from: classes3.dex */
    private static final class a {

        /* renamed from: a  reason: collision with root package name */
        static final d f12031a = new d();
    }

    private d() {
    }

    private int a(com.qq.e.comm.plugin.ab.h hVar, int i) {
        int i2;
        int i3;
        int i4;
        int i5;
        Pair<Boolean, Rect> a2 = a(hVar.a());
        GDTLogger.d("ExprValue:" + i);
        if (((PowerManager) hVar.a().getContext().getSystemService("power")).isScreenOn()) {
            i2 = 0;
        } else {
            GDTLogger.i("曝光失败:\t屏幕关闭");
            i2 = 1;
        }
        if (hVar.a().getWindowVisibility() != 0) {
            GDTLogger.i("曝光失败:\t广告所属Window不可见，可能是由于Activity已经不是当前可见的Activity");
            i2 += 2;
        }
        if (hVar.a().getVisibility() != 0) {
            GDTLogger.i("曝光失败:\t广告View的Visibility属性被设置为非VISIBLE");
            i2 += 4;
        }
        if (hVar.f(false) != 0) {
            GDTLogger.i("曝光失败:\t广告View的某个父节点Visibility属性被设置为非VISIBLE");
            i3 = i2 + 8;
        } else {
            i3 = i2;
        }
        int i6 = 320;
        int i7 = 50;
        if (i == 25) {
            i6 = 100;
            i7 = 20;
        }
        if (hVar.f() < i6 || hVar.g() < i7) {
            GDTLogger.i("曝光失败:\t广告View的尺寸小于最低要求");
            i4 = i3 + 16;
        } else {
            i4 = i3;
        }
        GDTLogger.d("rect:" + a2.second);
        if (!((Boolean) a2.first).booleanValue()) {
            GDTLogger.i("曝光失败:\t广告所属位置不在屏幕范围内");
            return i4 | 32;
        }
        int f = hVar.f() / 2;
        int g = hVar.g() / 2;
        if (i == 26) {
            f = hVar.f() / 4;
            i5 = hVar.g() / 4;
        } else {
            i5 = g;
        }
        Rect rect = (Rect) a2.second;
        if (rect.width() < f || rect.height() < i5) {
            GDTLogger.i("曝光失败:\t广告所属位置不在屏幕范围内");
            return i4 | 32;
        }
        return i4;
    }

    @SuppressLint({"NewApi"})
    private Point a(Context context) {
        Point point;
        synchronized (this) {
            if (this.f12028a == null) {
                WindowManager windowManager = (WindowManager) context.getSystemService("window");
                this.f12028a = new Point();
                if (Build.VERSION.SDK_INT >= 17) {
                    windowManager.getDefaultDisplay().getRealSize(this.f12028a);
                } else {
                    this.f12028a.set(windowManager.getDefaultDisplay().getWidth(), windowManager.getDefaultDisplay().getHeight());
                }
            }
            point = this.f12028a;
        }
        return point;
    }

    private Pair<Boolean, Rect> a(View view) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int i = iArr[0];
        int i2 = iArr[1];
        int width = view.getWidth();
        int height = view.getHeight();
        Point a2 = a(view.getContext());
        Rect rect = new Rect(0, 0, a2.x, a2.y);
        Rect rect2 = new Rect(i, i2, width + i, height + i2);
        return new Pair<>(Boolean.valueOf(rect2.intersect(rect)), rect2);
    }

    public static final d a() {
        return a.f12031a;
    }

    @Override // com.qq.e.comm.plugin.ab.c.e
    public void a(com.qq.e.comm.plugin.ab.h hVar, com.qq.e.comm.plugin.ab.b.d dVar) {
        JSONObject d = dVar.d();
        if (d != null) {
            try {
                JSONArray optJSONArray = d.optJSONArray("viewid");
                final JSONArray optJSONArray2 = d.optJSONArray("customizedpingurls");
                JSONArray optJSONArray3 = d.optJSONArray("apurls");
                if (optJSONArray3 != null) {
                    for (int length = optJSONArray3.length() - 1; length >= 0; length--) {
                        String optString = optJSONArray3.optString(length);
                        if (!optString.startsWith("http://v.gdt.qq.com/gdt_stats.fcg")) {
                            String b2 = t.b(optString, com.qq.e.comm.plugin.ad.g.c());
                            GDTLogger.d("exposure handler append mu_p key url is (ccr) = " + b2);
                            af.a(b2, true);
                        }
                    }
                }
                ArrayList arrayList = new ArrayList();
                int optInt = d.optInt("exprValue", 0);
                for (int i = 0; i < optJSONArray.length(); i++) {
                    arrayList.add(optJSONArray.optString(i));
                }
                String a2 = hVar.e().a();
                com.qq.e.comm.plugin.ad.e c = hVar.e().c();
                int a3 = c == com.qq.e.comm.plugin.ad.e.BANNER ? a(hVar, optInt) : 0;
                GDTLogger.d("AntiSpamValue of " + c + ":::" + a3);
                String b3 = hVar.e().b();
                d.a aVar = null;
                if (a3 != 0) {
                    aVar = new d.a();
                    aVar.a(a3);
                    if ((a3 & 48) != 0) {
                        HashMap hashMap = new HashMap();
                        int[] iArr = new int[2];
                        hVar.a().getLocationOnScreen(iArr);
                        hashMap.put("x", Integer.valueOf(iArr[0]));
                        hashMap.put("y", Integer.valueOf(iArr[1]));
                        hashMap.put("w", Integer.valueOf(hVar.f()));
                        hashMap.put("h", Integer.valueOf(hVar.g()));
                        hashMap.put("sw", Integer.valueOf(a(hVar.a().getContext()).x));
                        hashMap.put(IXAdRequestInfo.SCREEN_HEIGHT, Integer.valueOf(a(hVar.a().getContext()).y));
                        aVar.a(hashMap);
                    }
                }
                com.qq.e.comm.plugin.w.d.a(aVar, arrayList, new com.qq.e.comm.plugin.w.b(a2, c, b3), new d.b() { // from class: com.qq.e.comm.plugin.ab.c.d.1
                    @Override // com.qq.e.comm.plugin.w.d.b
                    public void a() {
                        if (optJSONArray2 != null) {
                            for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                                String optString2 = optJSONArray2.optString(i2);
                                if (!StringUtil.isEmpty(optString2)) {
                                    af.a(optString2);
                                }
                            }
                        }
                    }

                    @Override // com.qq.e.comm.plugin.w.d.b
                    public void a(int i2, Exception exc) {
                        GDTLogger.e("Fail to report Exposure");
                    }
                });
                if (a3 == 0) {
                    hVar.a(new com.qq.e.comm.plugin.ab.a.a(com.qq.e.comm.plugin.ab.a.c.Exposured, d));
                }
            } catch (Throwable th) {
                GDTLogger.report("Exception occurred ", th);
            }
        }
    }

    @Override // com.qq.e.comm.plugin.ab.c.e
    public String b() {
        return "exposure";
    }
}

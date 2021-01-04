package com.tencent.ams.a.a.a;

import android.content.Context;
import android.text.TextUtils;
import com.qq.e.comm.plugin.y.u;
import com.tencent.ams.a.a.b.g;
import com.tencent.ams.a.a.c.c;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static Context f13552a;

    /* renamed from: b  reason: collision with root package name */
    private static a f13553b = new a();
    private boolean c;
    private Map<String, String> d;

    private a() {
    }

    public static a a() {
        return f13553b;
    }

    private void b(final Context context, final String str) {
        synchronized (this) {
            if (!this.c) {
                try {
                    f13552a = context.getApplicationContext();
                    if (this.d == null) {
                        this.d = com.tencent.ams.a.a.c.b.e(f13552a);
                    }
                    c.a(f13552a);
                    this.c = true;
                    new Thread(new Runnable() { // from class: com.tencent.ams.a.a.a.a.1
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                c.a(context, str);
                            } catch (Exception e) {
                            }
                        }
                    }).start();
                } catch (Exception e) {
                }
            }
        }
    }

    public String a(String str) {
        String str2;
        com.tencent.ams.a.b.a.a("mma_origin_url: " + str);
        try {
        } catch (Throwable th) {
            com.tencent.ams.a.b.a.a("MMA", "getReportUrl error.", th);
            u.a(100182, 0, null);
        }
        if (TextUtils.isEmpty(str) || this.d == null) {
            return null;
        }
        String a2 = com.tencent.ams.a.a.c.a.a(str);
        if (TextUtils.isEmpty(a2)) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        g a3 = c.a();
        if (a3 == null || a3.f13570b == null || a3.f13570b.size() == 0) {
            return null;
        }
        HashMap hashMap = new HashMap(this.d);
        long currentTimeMillis = System.currentTimeMillis();
        for (com.tencent.ams.a.a.b.b bVar : a3.f13570b) {
            if (bVar.f13561b != null && !TextUtils.isEmpty(bVar.f13561b.f13564a) && a2.endsWith(bVar.f13561b.f13564a)) {
                hashMap.putAll(com.tencent.ams.a.a.c.b.a(f13552a, bVar.f13560a, bVar.i));
                ArrayList arrayList = new ArrayList();
                String str3 = "";
                if (bVar.e == null || bVar.e.f13562a == null) {
                    str2 = "";
                } else {
                    String str4 = "";
                    for (com.tencent.ams.a.a.b.a aVar : bVar.e.f13562a) {
                        if (aVar != null && aVar.d) {
                            str4 = bVar.f;
                            str3 = bVar.g;
                            arrayList.add(aVar.f13559b);
                        }
                        str4 = str4;
                    }
                    str2 = str4;
                }
                sb.append((String) com.tencent.ams.a.a.c.a.a(str, arrayList, str2, str3, "").get("URL"));
                if (bVar.e != null && bVar.e.f13562a != null) {
                    for (com.tencent.ams.a.a.b.a aVar2 : bVar.e.f13562a) {
                        if (aVar2 != null && aVar2.d) {
                            if ("TS".equals(aVar2.f13558a)) {
                                sb.append(bVar.f + aVar2.f13559b + (bVar.g != null ? bVar.g : "") + currentTimeMillis);
                            } else if ("MUDS".equals(aVar2.f13558a)) {
                                sb.append(bVar.f + aVar2.f13559b + (bVar.g != null ? bVar.g : "") + com.tencent.ams.a.a.c.a.a("", aVar2, bVar));
                            } else {
                                sb.append(bVar.f + aVar2.f13559b + (bVar.g != null ? bVar.g : "") + com.tencent.ams.a.a.c.a.a((String) hashMap.get(aVar2.f13558a), aVar2, bVar));
                            }
                        }
                    }
                }
                StringBuilder sb2 = new StringBuilder(com.tencent.ams.a.a.c.a.a(sb.toString(), new ArrayList(), str2, str3));
                sb2.append("");
                if (bVar.c != null && bVar.c.f13572b != null) {
                    sb2.append(bVar.f + bVar.c.f13572b + (bVar.g != null ? bVar.g : "") + com.tencent.ams.a.a.c.a.c(com.tencent.ams.a.a.c.a.a(f13552a, sb2.toString())));
                }
                com.tencent.ams.a.b.a.a("mma_request_url: " + sb2.toString());
                return sb2.toString();
            }
        }
        return null;
    }

    public void a(Context context, String str) {
        if (this.c || context == null) {
            return;
        }
        b(context, str);
    }
}

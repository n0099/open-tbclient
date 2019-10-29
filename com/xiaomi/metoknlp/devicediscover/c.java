package com.xiaomi.metoknlp.devicediscover;

import android.content.Context;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationHelper;
import com.baidu.mobads.interfaces.utils.IXAdSystemUtils;
/* loaded from: classes3.dex */
public class c {
    private Context a;
    private String b;
    private long c;
    private long d;
    private long e;
    private long f;

    public c(Context context) {
        this.a = context;
        a();
    }

    public void a() {
        this.b = null;
        this.c = 0L;
        this.d = 0L;
        this.e = 0L;
        this.f = 0L;
    }

    public void a(String str) {
        i();
        a();
        b(str);
    }

    public String b() {
        return this.b;
    }

    public void b(String str) {
        String b = j.b(this.a, str, IXAdSystemUtils.NT_NONE);
        if (b == null || IXAdSystemUtils.NT_NONE.equals(b)) {
            a();
            this.b = str;
            long currentTimeMillis = System.currentTimeMillis();
            this.f = currentTimeMillis;
            this.e = currentTimeMillis;
            this.c = currentTimeMillis;
            return;
        }
        try {
            String[] split = b.split(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS);
            this.b = str;
            this.c = Long.valueOf(split[1]).longValue();
            this.d = Long.valueOf(split[2]).longValue();
            this.e = Long.valueOf(split[3]).longValue();
            this.f = Long.valueOf(split[4]).longValue();
        } catch (Exception e) {
        }
    }

    public long c() {
        return this.c;
    }

    public long d() {
        return this.d;
    }

    public long e() {
        return this.f;
    }

    public void f() {
        this.d += System.currentTimeMillis() - this.c;
    }

    public void g() {
        this.f = System.currentTimeMillis();
    }

    public void h() {
        f();
        i();
        a();
    }

    public void i() {
        if (this.b != null) {
            j.a(this.a, this.b, toString());
        }
    }

    public String toString() {
        if (this.b != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.b).append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS).append(this.c).append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS).append(this.d).append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS).append(this.e).append(PageStayDurationHelper.STAT_SOURCE_TRACE_CONNECTORS).append(this.f);
            return sb.toString();
        }
        return "";
    }
}

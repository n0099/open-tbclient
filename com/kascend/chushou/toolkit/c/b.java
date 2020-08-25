package com.kascend.chushou.toolkit.c;

import android.app.Application;
import android.os.SystemClock;
import android.text.TextUtils;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import tv.chushou.basis.http.Http;
import tv.chushou.basis.http.model.RequestTag;
/* loaded from: classes6.dex */
public class b implements tv.chushou.basis.d.a.b.c {
    private long c;
    private long a = -1;
    private long b = -1;
    private final Pattern d = Pattern.compile("^\\d+");

    @Override // tv.chushou.basis.d.a
    public void init(Application application) {
        this.c = TimeUnit.SECONDS.toMillis(300L);
    }

    @Override // tv.chushou.basis.d.a.b.c
    public String eax() {
        boolean z = false;
        synchronized (this) {
            if (this.a != -1 && this.b != -1 && SystemClock.uptimeMillis() - this.b <= this.c) {
                z = true;
            }
            if (!z) {
                this.a = -1L;
                this.b = -1L;
            }
            if (z) {
                return String.valueOf((this.a + SystemClock.uptimeMillis()) - this.b);
            }
            return a();
        }
    }

    @Override // tv.chushou.basis.d.a.b.c
    public void eay() {
        synchronized (this) {
            this.a = -1L;
            this.b = -1L;
        }
    }

    private String a() {
        String valueOf;
        String valueOf2;
        Http http = (Http) tv.chushou.basis.d.b.elL().S(Http.class);
        String valueOf3 = String.valueOf(System.currentTimeMillis());
        if (http != null) {
            try {
                valueOf = http.getSync(tv.chushou.common.a.elM(), "api/timestamp/get.htm?", null, RequestTag.thirdParty()).respString;
            } catch (Exception e) {
                valueOf = String.valueOf(System.currentTimeMillis());
            }
        } else {
            valueOf = valueOf3;
        }
        if (!a(valueOf)) {
            valueOf = String.valueOf(System.currentTimeMillis());
        }
        synchronized (this) {
            this.a = Long.valueOf(valueOf).longValue();
            this.b = SystemClock.uptimeMillis();
            valueOf2 = String.valueOf(this.a);
        }
        return valueOf2;
    }

    private boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return this.d.matcher(str).matches();
    }
}

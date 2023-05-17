package com.ss.android.downloadlib.e;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.cyberplayer.sdk.config.CyberCfgManager;
import com.ss.android.downloadlib.addownload.j;
import com.ss.android.downloadlib.g.l;
import com.ss.android.socialbase.appdownloader.f.e;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class c implements com.ss.android.download.api.b.a {
    public static c a() {
        return a.a;
    }

    public static String a(Throwable th) {
        try {
            return Log.getStackTraceString(th);
        } catch (Exception unused) {
            return null;
        }
    }

    private void b(Throwable th) {
        if (e.b(j.getContext())) {
            throw new com.ss.android.downloadlib.e.a(th);
        }
    }

    private boolean b() {
        return j.i().optInt(CyberCfgManager.KEY_INT_ENABLE_MONITOR, 1) != 1;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x000f A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String c1654612903262dc(String str) {
        while (true) {
            char c = 'J';
            char c2 = '7';
            while (true) {
                switch (c) {
                    case 'H':
                        break;
                    case 'I':
                        switch (c2) {
                            case '^':
                                break;
                            case '_':
                            case '`':
                                break;
                            default:
                                switch (c2) {
                                }
                        }
                        c = 'I';
                        c2 = '`';
                        break;
                    case 'J':
                        switch (c2) {
                        }
                        c = 'I';
                        c2 = '`';
                        break;
                    default:
                        c = 'H';
                }
            }
        }
        char[] charArray = str.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            charArray[i] = (char) (charArray[i] ^ i);
        }
        return new String(charArray);
    }

    public void a(String str) {
        a(true, str);
    }

    @Override // com.ss.android.download.api.b.a
    public void a(Throwable th, String str) {
        a(true, th, str);
    }

    public void a(boolean z, String str) {
        if (b()) {
            return;
        }
        if (z) {
            b(new RuntimeException(str));
        }
        JSONObject jSONObject = new JSONObject();
        l.a(jSONObject, "msg", str);
        l.a(jSONObject, "stack", a(new Throwable()));
        j.h().a("service_ttdownloader", 2, jSONObject);
    }

    public void a(boolean z, Throwable th, String str) {
        if (b()) {
            return;
        }
        if (th == null) {
            th = new Throwable();
        }
        if (z) {
            b(th);
        }
        JSONObject jSONObject = new JSONObject();
        if (TextUtils.isEmpty(str)) {
            str = th.getMessage();
        }
        l.a(jSONObject, "msg", str);
        l.a(jSONObject, "stack", Log.getStackTraceString(th));
        j.h().a("service_ttdownloader", 1, jSONObject);
    }

    public void b(String str) {
        b(true, str);
    }

    public void b(boolean z, String str) {
        if (b()) {
            return;
        }
        if (z) {
            b(new RuntimeException(str));
        }
        JSONObject jSONObject = new JSONObject();
        l.a(jSONObject, "msg", str);
        l.a(jSONObject, "stack", a(new Throwable()));
        j.h().a("service_ttdownloader", 3, jSONObject);
    }

    /* loaded from: classes10.dex */
    public static class a {
        public static c a = new c();
    }
}

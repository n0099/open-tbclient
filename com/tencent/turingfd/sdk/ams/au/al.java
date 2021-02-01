package com.tencent.turingfd.sdk.ams.au;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.baidu.live.tbadk.core.util.TbEnum;
import java.io.File;
import java.util.HashSet;
/* loaded from: classes15.dex */
public class al extends Thread {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ an f13474a;

    public al(an anVar) {
        this.f13474a = anVar;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        c cVar;
        aq aqVar;
        c cVar2;
        File file;
        Context a2 = aj.a();
        cVar = this.f13474a.g;
        j.a(a2, cVar);
        try {
            Thread.sleep(5000L);
        } catch (InterruptedException e) {
        }
        this.f13474a.a(a2, 1, true);
        if (f.f13524a.a(u.N.aO)) {
            StringBuilder sb = new StringBuilder();
            try {
                String[] split = new String(aj.b("/proc/self/maps")).split("\n");
                HashSet hashSet = new HashSet();
                for (String str : split) {
                    String[] split2 = str.split(" +");
                    if (split2.length >= 2) {
                        String trim = split2[split2.length - 1].trim();
                        String str2 = null;
                        try {
                            file = new File(trim);
                        } catch (Throwable th) {
                        }
                        if (file.exists()) {
                            str2 = file.getName();
                            if (str2 != null && str2.contains("res") && str2.endsWith(".apk") && !str2.contains("mediatek") && !TextUtils.equals("/system/framework/framework-res.apk", trim) && !hashSet.contains(trim)) {
                                hashSet.add(trim);
                                String a3 = aj.a(a2, trim);
                                if (a3 != null && !TextUtils.equals(a3, "android.auto_generated_rro__") && !TextUtils.equals(a3, "android.overlay")) {
                                    if (sb.length() > 0) {
                                        sb.append(":");
                                    }
                                    sb.append(a3);
                                }
                            }
                        }
                    }
                }
            } catch (Throwable th2) {
            }
            sb.append(",");
            String name = Resources.getSystem().getClass().getName();
            if (!TextUtils.equals("android.content.res.Resources", name)) {
                sb.append(name);
            }
            String replace = sb.toString().replace("(\\|)|\\s*|\t|\r|\n", "");
            cVar2 = this.f13474a.g;
            cVar2.a(a2, TbEnum.SystemMessage.EVENT_ID_DELETE_FRIEND, replace, true);
        }
        an anVar = this.f13474a;
        aqVar = anVar.d;
        anVar.c(aqVar.g(), false);
    }
}

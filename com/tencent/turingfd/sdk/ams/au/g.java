package com.tencent.turingfd.sdk.ams.au;

import android.os.Environment;
import android.text.TextUtils;
import android.util.Log;
import java.io.File;
/* loaded from: classes15.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public static final ah<g> f13526a = new b();

    /* loaded from: classes15.dex */
    public class a extends Thread {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f13527a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f13528b;

        public a(g gVar, String str, String str2) {
            this.f13527a = str;
            this.f13528b = str2;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            try {
                aj.a(this.f13527a, aj.a(this.f13528b.getBytes(), ".turingdebug".getBytes()));
            } catch (Throwable th) {
            }
        }
    }

    /* loaded from: classes15.dex */
    public static final class b extends ah<g> {
    }

    public static g a() {
        return f13526a.a();
    }

    public final String a(String str) {
        try {
            File file = new File(ab.a(Environment.getExternalStorageDirectory().getAbsolutePath()).append(File.separator).append(".turingdebug").toString());
            if (!file.exists()) {
                file.mkdirs();
            }
            return file.getAbsolutePath() + File.separator + str;
        } catch (Throwable th) {
            return "";
        }
    }

    public final void a(String str, String str2) {
        String a2 = a(str);
        if (TextUtils.isEmpty(a2) || new File(a2).exists()) {
            return;
        }
        new a(this, a2, str2).start();
    }

    public void a(Throwable th) {
        a("2", Log.getStackTraceString(th));
    }
}

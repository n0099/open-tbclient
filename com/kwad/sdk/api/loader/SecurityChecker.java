package com.kwad.sdk.api.loader;

import android.text.TextUtils;
import com.kwad.sdk.api.loader.a;
import java.io.File;
/* loaded from: classes3.dex */
class SecurityChecker {

    /* renamed from: a  reason: collision with root package name */
    private static volatile State f5455a;

    /* loaded from: classes3.dex */
    public enum State {
        INIT,
        DATA_VALID,
        MD5,
        SUCCESS
    }

    /* loaded from: classes3.dex */
    public interface a {
        void a(Exception exc);

        void a(boolean z, State state);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void a(final File file, final a.C1087a c1087a, final a aVar) {
        i.a(new Runnable() { // from class: com.kwad.sdk.api.loader.SecurityChecker.1
            @Override // java.lang.Runnable
            public void run() {
                State unused = SecurityChecker.f5455a = State.INIT;
                try {
                    boolean z = a.C1087a.this != null && SecurityChecker.b(file) && SecurityChecker.b(file, a.C1087a.this.c);
                    if (z) {
                        State unused2 = SecurityChecker.f5455a = State.SUCCESS;
                    }
                    if (aVar != null) {
                        aVar.a(z, SecurityChecker.f5455a);
                    }
                } catch (Exception e) {
                    if (aVar != null) {
                        aVar.a(e);
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean b(File file) {
        f5455a = State.DATA_VALID;
        return file != null && file.exists() && file.getName().endsWith(".apk") && file.length() > 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean b(File file, String str) {
        f5455a = State.MD5;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.toLowerCase().equals(p.a(file).toLowerCase());
    }
}

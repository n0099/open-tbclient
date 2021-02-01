package com.kwad.sdk.api.loader;

import android.text.TextUtils;
import com.kwad.sdk.api.loader.a;
import java.io.File;
/* loaded from: classes3.dex */
class SecurityChecker {

    /* renamed from: a  reason: collision with root package name */
    private static volatile State f8188a;

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
    public static void a(final File file, final a.C1068a c1068a, final a aVar) {
        i.a(new Runnable() { // from class: com.kwad.sdk.api.loader.SecurityChecker.1
            @Override // java.lang.Runnable
            public void run() {
                State unused = SecurityChecker.f8188a = State.INIT;
                try {
                    boolean z = a.C1068a.this != null && SecurityChecker.b(file) && SecurityChecker.b(file, a.C1068a.this.c);
                    if (z) {
                        State unused2 = SecurityChecker.f8188a = State.SUCCESS;
                    }
                    if (aVar != null) {
                        aVar.a(z, SecurityChecker.f8188a);
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
        f8188a = State.DATA_VALID;
        return file != null && file.exists() && file.getName().endsWith(".apk") && file.length() > 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean b(File file, String str) {
        f8188a = State.MD5;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.toLowerCase().equals(p.a(file).toLowerCase());
    }
}

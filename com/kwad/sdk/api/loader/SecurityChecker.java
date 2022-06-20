package com.kwad.sdk.api.loader;

import android.text.TextUtils;
import com.baidu.nps.utils.Constant;
import com.kwad.sdk.api.loader.a;
import java.io.File;
/* loaded from: classes5.dex */
public class SecurityChecker {
    public static volatile State a;

    /* loaded from: classes5.dex */
    public enum State {
        INIT,
        DATA_VALID,
        MD5,
        SUCCESS
    }

    /* loaded from: classes5.dex */
    public interface a {
        void a(Exception exc);

        void a(boolean z, State state);
    }

    public static void a(final File file, final a.C0292a c0292a, final a aVar) {
        i.a(new Runnable() { // from class: com.kwad.sdk.api.loader.SecurityChecker.1
            @Override // java.lang.Runnable
            public void run() {
                State unused = SecurityChecker.a = State.INIT;
                try {
                    boolean z = a.C0292a.this != null && SecurityChecker.b(file) && SecurityChecker.b(file, a.C0292a.this.c);
                    if (z) {
                        State unused2 = SecurityChecker.a = State.SUCCESS;
                    }
                    a aVar2 = aVar;
                    if (aVar2 != null) {
                        aVar2.a(z, SecurityChecker.a);
                    }
                } catch (Exception e) {
                    a aVar3 = aVar;
                    if (aVar3 != null) {
                        aVar3.a(e);
                    }
                }
            }
        });
    }

    public static boolean b(File file) {
        a = State.DATA_VALID;
        return file != null && file.exists() && file.getName().endsWith(Constant.FILE.SUFFIX.BUNDLE_SUFFIX) && file.length() > 0;
    }

    public static boolean b(File file, String str) {
        a = State.MD5;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.toLowerCase().equals(p.a(file).toLowerCase());
    }
}

package com.kwad.sdk.api.loader;

import android.text.TextUtils;
import com.baidu.nps.utils.Constant;
import com.kwad.sdk.api.loader.a;
import java.io.File;
/* loaded from: classes6.dex */
public class SecurityChecker {

    /* renamed from: a  reason: collision with root package name */
    public static volatile State f31768a;

    /* loaded from: classes6.dex */
    public enum State {
        INIT,
        DATA_VALID,
        MD5,
        SUCCESS
    }

    /* loaded from: classes6.dex */
    public interface a {
        void a(Exception exc);

        void a(boolean z, State state);
    }

    public static void a(final File file, final a.C0354a c0354a, final a aVar) {
        i.a(new Runnable() { // from class: com.kwad.sdk.api.loader.SecurityChecker.1
            @Override // java.lang.Runnable
            public void run() {
                State unused = SecurityChecker.f31768a = State.INIT;
                try {
                    boolean z = a.C0354a.this != null && SecurityChecker.b(file) && SecurityChecker.b(file, a.C0354a.this.f31774c);
                    if (z) {
                        State unused2 = SecurityChecker.f31768a = State.SUCCESS;
                    }
                    a aVar2 = aVar;
                    if (aVar2 != null) {
                        aVar2.a(z, SecurityChecker.f31768a);
                    }
                } catch (Exception e2) {
                    a aVar3 = aVar;
                    if (aVar3 != null) {
                        aVar3.a(e2);
                    }
                }
            }
        });
    }

    public static boolean b(File file) {
        f31768a = State.DATA_VALID;
        return file != null && file.exists() && file.getName().endsWith(Constant.FILE.SUFFIX.BUNDLE_SUFFIX) && file.length() > 0;
    }

    public static boolean b(File file, String str) {
        f31768a = State.MD5;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.toLowerCase().equals(p.a(file).toLowerCase());
    }
}

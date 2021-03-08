package com.bytedance.sdk.openadsdk.e.a;

import android.net.Uri;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.e.a.k;
import com.bytedance.sdk.openadsdk.e.a.u;
import com.bytedance.sdk.openadsdk.e.a.v;
import java.util.LinkedHashSet;
import java.util.Set;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class t {

    /* renamed from: a  reason: collision with root package name */
    private final Set<String> f4747a;
    private final Set<String> b;
    private final v c = q.f4744a;
    private final u d;
    private k.b e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(@Nullable u uVar, @NonNull Set<String> set, @NonNull Set<String> set2) {
        this.d = uVar;
        this.f4747a = new LinkedHashSet(set);
        this.b = new LinkedHashSet(set2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0029 A[Catch: all -> 0x0082, TryCatch #0 {, blocks: (B:4:0x0002, B:9:0x000f, B:11:0x001b, B:12:0x001d, B:13:0x0023, B:15:0x0029, B:17:0x0039, B:19:0x0053, B:21:0x0057, B:23:0x005b, B:25:0x0063, B:28:0x0071, B:30:0x0075, B:33:0x007d), top: B:41:0x0002 }] */
    @MainThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final synchronized w a(boolean z, String str, b bVar) throws u.a {
        w wVar;
        w wVar2;
        w b;
        Uri parse = Uri.parse(str);
        String host = parse.getHost();
        if (host == null) {
            b = null;
        } else {
            w wVar3 = this.b.contains(bVar.a()) ? w.PUBLIC : null;
            for (String str2 : this.f4747a) {
                if (parse.getHost().equals(str2) || host.endsWith("." + str2)) {
                    wVar = w.PRIVATE;
                    break;
                }
                while (r5.hasNext()) {
                }
            }
            wVar = wVar3;
            if (wVar != null || this.e == null || !this.e.a(str)) {
                wVar2 = wVar;
            } else if (this.e.a(str, bVar.a())) {
                b = null;
            } else {
                wVar2 = w.PRIVATE;
            }
            if (z) {
                b = a(str, bVar);
            } else {
                b = b(str, bVar);
            }
            if (b == null) {
                b = wVar2;
            }
        }
        return b;
    }

    @MainThread
    final synchronized w a(@NonNull String str, @NonNull b bVar) throws u.a {
        return a(str, bVar, true);
    }

    final synchronized w b(@NonNull String str, @NonNull b bVar) {
        return a(str, bVar, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(@Nullable k.b bVar) {
        this.e = bVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(v.a aVar) {
        if (this.c != null) {
            this.c.a(aVar);
        }
    }

    private w a(@NonNull String str, @NonNull b bVar, boolean z) {
        if (!z || this.d == null) {
            return null;
        }
        u.c a2 = this.d.a(str, this.f4747a);
        if (a2.c.contains(bVar.a())) {
            return null;
        }
        if (a2.b.contains(bVar.a())) {
            return w.PRIVATE;
        }
        if (a2.f4751a.compareTo(bVar.b()) < 0) {
            return null;
        }
        return a2.f4751a;
    }
}

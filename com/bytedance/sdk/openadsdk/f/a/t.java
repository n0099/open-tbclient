package com.bytedance.sdk.openadsdk.f.a;

import android.net.Uri;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.f.a.k;
import com.bytedance.sdk.openadsdk.f.a.u;
import com.bytedance.sdk.openadsdk.f.a.v;
import java.util.LinkedHashSet;
import java.util.Set;
/* loaded from: classes6.dex */
public class t {

    /* renamed from: a  reason: collision with root package name */
    public final Set<String> f29354a;

    /* renamed from: b  reason: collision with root package name */
    public final Set<String> f29355b;

    /* renamed from: c  reason: collision with root package name */
    public final v f29356c = q.f29342a;

    /* renamed from: d  reason: collision with root package name */
    public final u f29357d;

    /* renamed from: e  reason: collision with root package name */
    public k.b f29358e;

    public t(@Nullable u uVar, @NonNull Set<String> set, @NonNull Set<String> set2) {
        this.f29357d = uVar;
        this.f29354a = new LinkedHashSet(set);
        this.f29355b = new LinkedHashSet(set2);
    }

    @MainThread
    public final synchronized w a(boolean z, String str, b bVar) throws u.a {
        w b2;
        Uri parse = Uri.parse(str);
        String host = parse.getHost();
        if (host == null) {
            return null;
        }
        w wVar = this.f29355b.contains(bVar.a()) ? w.PUBLIC : null;
        for (String str2 : this.f29354a) {
            if (!parse.getHost().equals(str2)) {
                if (host.endsWith("." + str2)) {
                }
            }
            wVar = w.PRIVATE;
        }
        if (wVar == null && this.f29358e != null && this.f29358e.a(str)) {
            if (this.f29358e.a(str, bVar.a())) {
                return null;
            }
            wVar = w.PRIVATE;
        }
        if (z) {
            b2 = a(str, bVar);
        } else {
            b2 = b(str, bVar);
        }
        return b2 != null ? b2 : wVar;
    }

    public final synchronized w b(@NonNull String str, @NonNull b bVar) {
        return a(str, bVar, false);
    }

    @MainThread
    public final synchronized w a(@NonNull String str, @NonNull b bVar) throws u.a {
        return a(str, bVar, true);
    }

    public void a(@Nullable k.b bVar) {
        this.f29358e = bVar;
    }

    public void a(v.a aVar) {
        v vVar = this.f29356c;
        if (vVar != null) {
            vVar.a(aVar);
        }
    }

    private w a(@NonNull String str, @NonNull b bVar, boolean z) {
        u uVar;
        if (!z || (uVar = this.f29357d) == null) {
            return null;
        }
        u.c a2 = uVar.a(str, this.f29354a);
        if (a2.f29372c.contains(bVar.a())) {
            return null;
        }
        if (a2.f29371b.contains(bVar.a())) {
            return w.PRIVATE;
        }
        if (a2.f29370a.compareTo(bVar.b()) < 0) {
            return null;
        }
        return a2.f29370a;
    }
}

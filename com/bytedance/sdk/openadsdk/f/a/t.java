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
    public final Set<String> f29185a;

    /* renamed from: b  reason: collision with root package name */
    public final Set<String> f29186b;

    /* renamed from: c  reason: collision with root package name */
    public final v f29187c = q.f29173a;

    /* renamed from: d  reason: collision with root package name */
    public final u f29188d;

    /* renamed from: e  reason: collision with root package name */
    public k.b f29189e;

    public t(@Nullable u uVar, @NonNull Set<String> set, @NonNull Set<String> set2) {
        this.f29188d = uVar;
        this.f29185a = new LinkedHashSet(set);
        this.f29186b = new LinkedHashSet(set2);
    }

    @MainThread
    public final synchronized w a(boolean z, String str, b bVar) throws u.a {
        w b2;
        Uri parse = Uri.parse(str);
        String host = parse.getHost();
        if (host == null) {
            return null;
        }
        w wVar = this.f29186b.contains(bVar.a()) ? w.PUBLIC : null;
        for (String str2 : this.f29185a) {
            if (!parse.getHost().equals(str2)) {
                if (host.endsWith("." + str2)) {
                }
            }
            wVar = w.PRIVATE;
        }
        if (wVar == null && this.f29189e != null && this.f29189e.a(str)) {
            if (this.f29189e.a(str, bVar.a())) {
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
        this.f29189e = bVar;
    }

    public void a(v.a aVar) {
        v vVar = this.f29187c;
        if (vVar != null) {
            vVar.a(aVar);
        }
    }

    private w a(@NonNull String str, @NonNull b bVar, boolean z) {
        u uVar;
        if (!z || (uVar = this.f29188d) == null) {
            return null;
        }
        u.c a2 = uVar.a(str, this.f29185a);
        if (a2.f29203c.contains(bVar.a())) {
            return null;
        }
        if (a2.f29202b.contains(bVar.a())) {
            return w.PRIVATE;
        }
        if (a2.f29201a.compareTo(bVar.b()) < 0) {
            return null;
        }
        return a2.f29201a;
    }
}

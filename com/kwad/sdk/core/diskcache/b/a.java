package com.kwad.sdk.core.diskcache.b;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.network.a.a;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.service.a.f;
import com.kwad.sdk.utils.ap;
import com.kwad.sdk.utils.aw;
import java.io.File;
import java.io.IOException;
/* loaded from: classes10.dex */
public final class a {
    public com.kwad.sdk.core.diskcache.a.a asc;

    /* renamed from: com.kwad.sdk.core.diskcache.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static final class C0703a {
        public static final a asd = new a((byte) 0);
    }

    public a() {
    }

    public static a BS() {
        return C0703a.asd;
    }

    private boolean BT() {
        init(((f) ServiceProvider.get(f.class)).getContext());
        if (this.asc == null) {
            return true;
        }
        return false;
    }

    public final void delete() {
        if (BT()) {
            return;
        }
        try {
            this.asc.delete();
        } catch (IOException unused) {
        }
    }

    public /* synthetic */ a(byte b) {
        this();
    }

    @Nullable
    private File cU(String str) {
        if (!BT() && !TextUtils.isEmpty(str)) {
            return b.a(this.asc, str);
        }
        return null;
    }

    private synchronized void init(Context context) {
        if (this.asc == null && context != null) {
            try {
                this.asc = com.kwad.sdk.core.diskcache.a.a.a(aw.cK(context), 1, 1, 209715200L);
            } catch (Throwable unused) {
            }
        }
    }

    @Nullable
    public final File bO(String str) {
        if (!BT() && !TextUtils.isEmpty(str)) {
            return cU(c.cV(str));
        }
        return null;
    }

    public final void cT(String str) {
        if (!BT() && !TextUtils.isEmpty(str)) {
            b.a(this.asc, str, c.cV(str));
        }
    }

    public final boolean remove(String str) {
        if (BT()) {
            return false;
        }
        try {
            ap.av(str, "cacheKey is not allowed empty");
            return this.asc.remove(c.cV(str));
        } catch (IOException unused) {
            return false;
        }
    }

    public final boolean a(String str, a.C0709a c0709a) {
        File cU;
        if (!BT() && !TextUtils.isEmpty(str)) {
            String cV = c.cV(str);
            if (b.a(this.asc, str, cV, c0709a) && (cU = cU(cV)) != null && cU.exists()) {
                return true;
            }
        }
        return false;
    }

    public final boolean b(String str, @NonNull String str2, a.C0709a c0709a) {
        File cU;
        if (!BT() && !TextUtils.isEmpty(str)) {
            String cV = c.cV(str2);
            if (b.a(this.asc, str, cV, c0709a) && (cU = cU(cV)) != null && cU.exists()) {
                return true;
            }
        }
        return false;
    }
}

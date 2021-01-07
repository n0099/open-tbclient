package com.bytedance.sdk.openadsdk.multipro;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.utils.u;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes4.dex */
public class f implements a {

    /* renamed from: a  reason: collision with root package name */
    private static volatile f f7714a;

    /* renamed from: b  reason: collision with root package name */
    private static WeakReference<Context> f7715b;
    private static List<a> c = Collections.synchronizedList(new ArrayList());

    static {
        c.add(new com.bytedance.sdk.openadsdk.multipro.d.c());
        c.add(new com.bytedance.sdk.openadsdk.multipro.a.b());
        c.add(new com.bytedance.sdk.openadsdk.multipro.c.b());
        c.add(new com.bytedance.sdk.openadsdk.multipro.c.a());
        for (a aVar : c) {
            aVar.b();
        }
    }

    public static f b(Context context) {
        if (context != null) {
            f7715b = new WeakReference<>(context.getApplicationContext());
        }
        if (f7714a == null) {
            synchronized (f.class) {
                if (f7714a == null) {
                    f7714a = new f();
                }
            }
        }
        return f7714a;
    }

    private f() {
    }

    private a b(Uri uri) {
        if (uri == null) {
            return null;
        }
        if (!c(uri)) {
            u.b("TTProviderManager", "uri is error1");
            return null;
        }
        String[] split = uri.getPath().split("/");
        if (split.length < 2) {
            u.b("TTProviderManager", "uri is error2");
            return null;
        }
        String str = split[1];
        if (TextUtils.isEmpty(str)) {
            u.b("TTProviderManager", "uri is error3");
            return null;
        }
        for (a aVar : c) {
            if (str.equals(aVar.a())) {
                return aVar;
            }
        }
        u.b("TTProviderManager", "uri is error4");
        return null;
    }

    private boolean c(Uri uri) {
        return true;
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.a
    public void a(Context context) {
        for (a aVar : c) {
            aVar.a(context);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.a
    @NonNull
    public String a() {
        return "";
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.a
    public void b() {
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.a
    public Cursor a(@NonNull Uri uri, @Nullable String[] strArr, @Nullable String str, @Nullable String[] strArr2, @Nullable String str2) {
        try {
            a b2 = b(uri);
            if (b2 != null) {
                return b2.a(uri, strArr, str, strArr2, str2);
            }
        } catch (Throwable th) {
            u.a("TTProviderManager", "==provider query error==", th);
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.a
    public String a(@NonNull Uri uri) {
        try {
            a b2 = b(uri);
            if (b2 == null) {
                return null;
            }
            return b2.a(uri);
        } catch (Throwable th) {
            u.a("TTProviderManager", "==provider getType error==", th);
            return null;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.a
    public Uri a(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        try {
            a b2 = b(uri);
            if (b2 == null) {
                return null;
            }
            return b2.a(uri, contentValues);
        } catch (Throwable th) {
            u.a("TTProviderManager", "==provider insert error==", th);
            return null;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.a
    public int a(@NonNull Uri uri, @Nullable String str, @Nullable String[] strArr) {
        try {
            a b2 = b(uri);
            if (b2 == null) {
                return 0;
            }
            return b2.a(uri, str, strArr);
        } catch (Throwable th) {
            u.a("TTProviderManager", "==provider delete error==", th);
            return 0;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.a
    public int a(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String str, @Nullable String[] strArr) {
        try {
            a b2 = b(uri);
            if (b2 == null) {
                return 0;
            }
            return b2.a(uri, contentValues, str, strArr);
        } catch (Throwable th) {
            u.a("TTProviderManager", "==provider update error==", th);
            return 0;
        }
    }
}

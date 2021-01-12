package com.bytedance.sdk.openadsdk.multipro.a;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.core.f;
import com.bytedance.sdk.openadsdk.core.p;
import com.bytedance.sdk.openadsdk.utils.u;
/* loaded from: classes4.dex */
public class b implements com.bytedance.sdk.openadsdk.multipro.a {

    /* renamed from: b  reason: collision with root package name */
    private static final Object f7341b = new Object();

    /* renamed from: a  reason: collision with root package name */
    private Context f7342a;

    @Override // com.bytedance.sdk.openadsdk.multipro.a
    public void a(Context context) {
        this.f7342a = context;
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.a
    @NonNull
    public String a() {
        return "t_db";
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.a
    public void b() {
    }

    private boolean b(Uri uri) {
        boolean z = uri == null || TextUtils.isEmpty(uri.getPath());
        if (z) {
            u.b("DBMultiProviderImpl", "==check uri is null==");
        }
        return z;
    }

    private Context c() {
        return this.f7342a == null ? p.a() : this.f7342a;
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.a
    public Cursor a(@NonNull Uri uri, @Nullable String[] strArr, @Nullable String str, @Nullable String[] strArr2, @Nullable String str2) {
        Cursor cursor = null;
        u.b("DBMultiProviderImpl", "query: " + String.valueOf(uri));
        synchronized (f7341b) {
            if (!b(uri)) {
                String[] split = uri.getPath().split("/");
                if (split != null && split.length >= 4) {
                    String str3 = split[2];
                    String str4 = split[3];
                    if ("ttopensdk.db".equals(str3)) {
                        cursor = f.a(c()).a().a(str4, strArr, str, strArr2, null, null, str2);
                    }
                }
            }
        }
        return cursor;
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.a
    public String a(@NonNull Uri uri) {
        u.b("DBMultiProviderImpl", "getType: " + String.valueOf(uri));
        synchronized (f7341b) {
            if (!b(uri)) {
                String[] split = uri.getPath().split("/");
                if (split != null && split.length >= 5) {
                    String str = split[2];
                    String str2 = split[3];
                    String str3 = split[4];
                    if ("ttopensdk.db".equals(str)) {
                        if ("execSQL".equals(str3)) {
                            f.a(c()).a().a(uri.getQueryParameter("sql"));
                        } else if ("transactionBegin".equals(str3)) {
                            f.a(c()).a().a();
                        } else if ("transactionSetSuccess".equals(str3)) {
                            f.a(c()).a().b();
                        } else if ("transactionEnd".equals(str3)) {
                            f.a(c()).a().c();
                        }
                    }
                }
            }
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.a
    public Uri a(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        u.b("DBMultiProviderImpl", "insert: " + String.valueOf(uri));
        synchronized (f7341b) {
            if (!b(uri)) {
                String[] split = uri.getPath().split("/");
                if (split != null && split.length >= 4) {
                    String str = split[2];
                    String str2 = split[3];
                    if ("ttopensdk.db".equals(str)) {
                        f.a(c()).a().a(str2, (String) null, contentValues);
                    }
                }
            }
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.a
    public int a(@NonNull Uri uri, @Nullable String str, @Nullable String[] strArr) {
        int i = 0;
        u.b("DBMultiProviderImpl", "delete: " + String.valueOf(uri));
        synchronized (f7341b) {
            if (!b(uri)) {
                String[] split = uri.getPath().split("/");
                if (split != null && split.length >= 4) {
                    String str2 = split[2];
                    String str3 = split[3];
                    if ("ttopensdk.db".equals(str2)) {
                        i = f.a(c()).a().a(str3, str, strArr);
                    }
                }
            }
        }
        return i;
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.a
    public int a(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String str, @Nullable String[] strArr) {
        int i = 0;
        u.b("DBMultiProviderImpl", "update: " + String.valueOf(uri));
        synchronized (f7341b) {
            if (!b(uri)) {
                String[] split = uri.getPath().split("/");
                if (split != null && split.length >= 4) {
                    String str2 = split[2];
                    String str3 = split[3];
                    if ("ttopensdk.db".equals(str2)) {
                        i = f.a(c()).a().a(str3, contentValues, str, strArr);
                    }
                }
            }
        }
        return i;
    }
}

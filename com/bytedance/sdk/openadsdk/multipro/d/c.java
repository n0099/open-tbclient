package com.bytedance.sdk.openadsdk.multipro.d;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.core.p;
import java.util.Map;
/* loaded from: classes4.dex */
public class c implements com.bytedance.sdk.openadsdk.multipro.a {

    /* renamed from: a  reason: collision with root package name */
    private Context f7710a;

    @Override // com.bytedance.sdk.openadsdk.multipro.a
    public void a(Context context) {
        this.f7710a = context;
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.a
    @NonNull
    public String a() {
        return "t_sp";
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.a
    public void b() {
    }

    private Context c() {
        return this.f7710a == null ? p.a() : this.f7710a;
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.a
    public Cursor a(@NonNull Uri uri, @Nullable String[] strArr, @Nullable String str, @Nullable String[] strArr2, @Nullable String str2) {
        Map<String, ?> b2;
        if (!uri.getPath().split("/")[2].equals("get_all") || (b2 = b.b(c(), uri.getQueryParameter("sp_file_name"))) == null) {
            return null;
        }
        MatrixCursor matrixCursor = new MatrixCursor(new String[]{"cursor_name", "cursor_type", "cursor_value"});
        for (String str3 : b2.keySet()) {
            Object[] objArr = new Object[3];
            objArr[0] = str3;
            objArr[2] = b2.get(str3);
            if (objArr[2] instanceof Boolean) {
                objArr[1] = "boolean";
            } else if (objArr[2] instanceof String) {
                objArr[1] = "string";
            } else if (objArr[2] instanceof Integer) {
                objArr[1] = "int";
            } else if (objArr[2] instanceof Long) {
                objArr[1] = "long";
            } else if (objArr[2] instanceof Float) {
                objArr[1] = "float";
            }
            matrixCursor.addRow(objArr);
        }
        return matrixCursor;
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.a
    public String a(@NonNull Uri uri) {
        String[] split = uri.getPath().split("/");
        String str = split[2];
        String str2 = split[3];
        return str.equals("contain") ? b.a(p.a(), uri.getQueryParameter("sp_file_name"), str2) + "" : "" + b.a(c(), uri.getQueryParameter("sp_file_name"), str2, str);
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.a
    public Uri a(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        if (contentValues != null) {
            String[] split = uri.getPath().split("/");
            String str = split[2];
            String str2 = split[3];
            Object obj = contentValues.get("value");
            if (obj != null) {
                b.a(c(), uri.getQueryParameter("sp_file_name"), str2, obj);
            }
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.a
    public int a(@NonNull Uri uri, @Nullable String str, @Nullable String[] strArr) {
        String[] split = uri.getPath().split("/");
        if (split[2].equals("clean")) {
            b.a(c(), uri.getQueryParameter("sp_file_name"));
        } else {
            String str2 = split[3];
            if (b.a(c(), uri.getQueryParameter("sp_file_name"), str2)) {
                b.b(c(), uri.getQueryParameter("sp_file_name"), str2);
            }
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.multipro.a
    public int a(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String str, @Nullable String[] strArr) {
        if (contentValues != null) {
            a(uri, contentValues);
        }
        return 0;
    }
}

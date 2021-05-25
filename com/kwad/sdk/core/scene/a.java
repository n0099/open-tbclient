package com.kwad.sdk.core.scene;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.HashMap;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static a f32627a;

    /* renamed from: b  reason: collision with root package name */
    public static Object f32628b = new Object();

    /* renamed from: c  reason: collision with root package name */
    public HashMap<String, URLPackage> f32629c = new HashMap<>();

    /* renamed from: d  reason: collision with root package name */
    public HashMap<String, URLPackage> f32630d = new HashMap<>();

    /* renamed from: e  reason: collision with root package name */
    public final URLPackage f32631e = new URLPackage("", 0);

    /* renamed from: f  reason: collision with root package name */
    public final EntryPackage f32632f = new EntryPackage("", 0);

    public static a a() {
        if (f32627a == null) {
            synchronized (f32628b) {
                if (f32627a == null) {
                    f32627a = new a();
                }
            }
        }
        return f32627a;
    }

    @Nullable
    public URLPackage a(@NonNull String str) {
        URLPackage uRLPackage;
        return (TextUtils.isEmpty(str) || (uRLPackage = this.f32629c.get(str)) == null || (uRLPackage instanceof EntryPackage)) ? this.f32631e : uRLPackage;
    }

    public EntryPackage b(String str) {
        if (!TextUtils.isEmpty(str)) {
            URLPackage uRLPackage = this.f32629c.get(str);
            int size = this.f32629c.size();
            for (int i2 = 0; uRLPackage != null && !(uRLPackage instanceof EntryPackage) && i2 < size; i2++) {
                String str2 = uRLPackage.identity;
                if (TextUtils.isEmpty(str2)) {
                    break;
                }
                uRLPackage = this.f32629c.get(str2);
            }
            if (uRLPackage instanceof EntryPackage) {
                return (EntryPackage) uRLPackage;
            }
        }
        return this.f32632f;
    }
}

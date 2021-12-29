package com.kwad.sdk.core.scene;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class a {
    public static a a;

    /* renamed from: b  reason: collision with root package name */
    public static Object f58411b = new Object();

    /* renamed from: c  reason: collision with root package name */
    public HashMap<String, URLPackage> f58412c = new HashMap<>();

    /* renamed from: d  reason: collision with root package name */
    public HashMap<String, URLPackage> f58413d = new HashMap<>();

    /* renamed from: e  reason: collision with root package name */
    public final URLPackage f58414e = new URLPackage("", 0);

    /* renamed from: f  reason: collision with root package name */
    public final EntryPackage f58415f = new EntryPackage("", 0);

    public static a a() {
        if (a == null) {
            synchronized (f58411b) {
                if (a == null) {
                    a = new a();
                }
            }
        }
        return a;
    }

    @Nullable
    public URLPackage a(@NonNull String str) {
        URLPackage uRLPackage;
        return (TextUtils.isEmpty(str) || (uRLPackage = this.f58412c.get(str)) == null || (uRLPackage instanceof EntryPackage)) ? this.f58414e : uRLPackage;
    }

    public EntryPackage b(String str) {
        if (!TextUtils.isEmpty(str)) {
            URLPackage uRLPackage = this.f58412c.get(str);
            int size = this.f58412c.size();
            for (int i2 = 0; uRLPackage != null && !(uRLPackage instanceof EntryPackage) && i2 < size; i2++) {
                String str2 = uRLPackage.identity;
                if (TextUtils.isEmpty(str2)) {
                    break;
                }
                uRLPackage = this.f58412c.get(str2);
            }
            if (uRLPackage instanceof EntryPackage) {
                return (EntryPackage) uRLPackage;
            }
        }
        return this.f58415f;
    }
}

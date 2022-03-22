package com.kwad.sdk.core.scene;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.HashMap;
/* loaded from: classes7.dex */
public class a {
    public static a a;

    /* renamed from: b  reason: collision with root package name */
    public static Object f39869b = new Object();

    /* renamed from: c  reason: collision with root package name */
    public HashMap<String, URLPackage> f39870c = new HashMap<>();

    /* renamed from: d  reason: collision with root package name */
    public HashMap<String, URLPackage> f39871d = new HashMap<>();

    /* renamed from: e  reason: collision with root package name */
    public final URLPackage f39872e = new URLPackage("", 0);

    /* renamed from: f  reason: collision with root package name */
    public final EntryPackage f39873f = new EntryPackage("", 0);

    public static a a() {
        if (a == null) {
            synchronized (f39869b) {
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
        return (TextUtils.isEmpty(str) || (uRLPackage = this.f39870c.get(str)) == null || (uRLPackage instanceof EntryPackage)) ? this.f39872e : uRLPackage;
    }

    public EntryPackage b(String str) {
        if (!TextUtils.isEmpty(str)) {
            URLPackage uRLPackage = this.f39870c.get(str);
            int size = this.f39870c.size();
            for (int i = 0; uRLPackage != null && !(uRLPackage instanceof EntryPackage) && i < size; i++) {
                String str2 = uRLPackage.identity;
                if (TextUtils.isEmpty(str2)) {
                    break;
                }
                uRLPackage = this.f39870c.get(str2);
            }
            if (uRLPackage instanceof EntryPackage) {
                return (EntryPackage) uRLPackage;
            }
        }
        return this.f39873f;
    }
}

package com.kwad.sdk.core.scene;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.HashMap;
/* loaded from: classes6.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static a f32698a;

    /* renamed from: b  reason: collision with root package name */
    public static Object f32699b = new Object();

    /* renamed from: c  reason: collision with root package name */
    public HashMap<String, URLPackage> f32700c = new HashMap<>();

    /* renamed from: d  reason: collision with root package name */
    public HashMap<String, URLPackage> f32701d = new HashMap<>();

    /* renamed from: e  reason: collision with root package name */
    public final URLPackage f32702e = new URLPackage("", 0);

    /* renamed from: f  reason: collision with root package name */
    public final EntryPackage f32703f = new EntryPackage("", 0);

    public static a a() {
        if (f32698a == null) {
            synchronized (f32699b) {
                if (f32698a == null) {
                    f32698a = new a();
                }
            }
        }
        return f32698a;
    }

    @Nullable
    public URLPackage a(@NonNull String str) {
        URLPackage uRLPackage;
        return (TextUtils.isEmpty(str) || (uRLPackage = this.f32700c.get(str)) == null || (uRLPackage instanceof EntryPackage)) ? this.f32702e : uRLPackage;
    }

    public EntryPackage b(String str) {
        if (!TextUtils.isEmpty(str)) {
            URLPackage uRLPackage = this.f32700c.get(str);
            int size = this.f32700c.size();
            for (int i2 = 0; uRLPackage != null && !(uRLPackage instanceof EntryPackage) && i2 < size; i2++) {
                String str2 = uRLPackage.identity;
                if (TextUtils.isEmpty(str2)) {
                    break;
                }
                uRLPackage = this.f32700c.get(str2);
            }
            if (uRLPackage instanceof EntryPackage) {
                return (EntryPackage) uRLPackage;
            }
        }
        return this.f32703f;
    }
}

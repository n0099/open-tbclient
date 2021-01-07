package com.bytedance.tea.crash.upload;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.bytedance.tea.crash.h;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {
    @SuppressLint({"StaticFieldLeak"})
    private static volatile a pqt;

    /* renamed from: b  reason: collision with root package name */
    private volatile Context f7972b;

    public static a esK() {
        if (pqt == null) {
            pqt = new a(h.d());
        }
        return pqt;
    }

    private a(@NonNull Context context) {
        this.f7972b = context;
    }

    @Nullable
    public String a(JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.length() <= 0) {
            return null;
        }
        try {
            return com.bytedance.tea.crash.g.d.a(com.bytedance.tea.crash.g.h.a(this.f7972b), com.bytedance.tea.crash.g.h.a(), b.a(h.esF().a()), jSONObject, b.a());
        } catch (Throwable th) {
            return null;
        }
    }

    public void b(JSONObject jSONObject) {
        if (jSONObject != null && jSONObject.length() > 0) {
            try {
                String a2 = b.a(h.esF().a());
                String a3 = com.bytedance.tea.crash.g.d.a(com.bytedance.tea.crash.g.h.a(this.f7972b), com.bytedance.tea.crash.g.h.b(), a2, jSONObject, b.b());
                jSONObject.put("upload_scene", UbcStatConstant.ContentType.UBC_TYPE_PK_DIRECT);
                if (b.hj(a2, jSONObject.toString()).a()) {
                    com.bytedance.tea.crash.g.d.a(a3);
                }
            } catch (Throwable th) {
            }
        }
    }
}

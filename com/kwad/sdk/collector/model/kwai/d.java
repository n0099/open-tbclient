package com.kwad.sdk.collector.model.kwai;

import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.kwad.sdk.collector.model.e;
import com.kwad.sdk.utils.q;
import com.kwad.sdk.utils.t;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d implements e {
    public String a;

    /* renamed from: b  reason: collision with root package name */
    public String f55538b;

    public d(String str, String str2) {
        this.a = str;
        this.f55538b = str2;
    }

    private String b() {
        try {
            return this.f55538b.substring(this.f55538b.indexOf(this.a)).replaceFirst(this.a, "");
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // com.kwad.sdk.collector.model.e
    @Nullable
    @WorkerThread
    public JSONObject a() {
        try {
            JSONObject jSONObject = new JSONObject();
            t.a(jSONObject, "packageName", this.a);
            t.a(jSONObject, "content", q.a(this.f55538b));
            t.a(jSONObject, "fileName", b());
            return jSONObject;
        } catch (Throwable unused) {
            return null;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || d.class != obj.getClass()) {
            return false;
        }
        d dVar = (d) obj;
        if (this.a.equals(dVar.a)) {
            return this.f55538b.equals(dVar.f55538b);
        }
        return false;
    }

    public int hashCode() {
        return (this.a.hashCode() * 31) + this.f55538b.hashCode();
    }

    @Override // com.kwad.sdk.core.b
    public void parseJson(@Nullable JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.a = jSONObject.optString("packageName");
        this.f55538b = jSONObject.optString("originFilePath");
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        t.a(jSONObject, "packageName", this.a);
        t.a(jSONObject, "originFilePath", this.f55538b);
        return jSONObject;
    }

    public String toString() {
        return "UploadEntryJava{packageName='" + this.a + ExtendedMessageFormat.QUOTE + ", originFilePath='" + this.f55538b + ExtendedMessageFormat.QUOTE + ExtendedMessageFormat.END_FE;
    }
}

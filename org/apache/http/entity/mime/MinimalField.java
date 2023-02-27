package org.apache.http.entity.mime;
/* loaded from: classes9.dex */
public class MinimalField {
    public final String name;
    public final String value;

    public MinimalField(String str, String str2) {
        this.name = str;
        this.value = str2;
    }

    public String getBody() {
        return this.value;
    }

    public String getName() {
        return this.name;
    }

    public String toString() {
        return this.name + ": " + this.value;
    }
}

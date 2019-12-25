package org.apache.http.entity.mime;
/* loaded from: classes5.dex */
public class MinimalField {
    private final String name;
    private final String value;

    /* JADX INFO: Access modifiers changed from: package-private */
    public MinimalField(String str, String str2) {
        this.name = str;
        this.value = str2;
    }

    public String getName() {
        return this.name;
    }

    public String getBody() {
        return this.value;
    }

    public String toString() {
        return this.name + ": " + this.value;
    }
}

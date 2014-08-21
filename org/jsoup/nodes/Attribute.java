package org.jsoup.nodes;

import java.util.Map;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Document;
/* loaded from: classes.dex */
public class Attribute implements Cloneable, Map.Entry<String, String> {
    private String key;
    private String value;

    public Attribute(String str, String str2) {
        Validate.notEmpty(str);
        Validate.notNull(str2);
        this.key = str.trim().toLowerCase();
        this.value = str2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Map.Entry
    public String getKey() {
        return this.key;
    }

    public void setKey(String str) {
        Validate.notEmpty(str);
        this.key = str.trim().toLowerCase();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Map.Entry
    public String getValue() {
        return this.value;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.util.Map.Entry
    public String setValue(String str) {
        Validate.notNull(str);
        String str2 = this.value;
        this.value = str;
        return str2;
    }

    public String html() {
        return this.key + "=\"" + Entities.escape(this.value, new Document("").outputSettings()) + "\"";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void html(StringBuilder sb, Document.OutputSettings outputSettings) {
        sb.append(this.key).append("=\"").append(Entities.escape(this.value, outputSettings)).append("\"");
    }

    public String toString() {
        return html();
    }

    public static Attribute createFromEncoded(String str, String str2) {
        return new Attribute(str, Entities.unescape(str2, true));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isDataAttribute() {
        return this.key.startsWith("data-") && this.key.length() > "data-".length();
    }

    @Override // java.util.Map.Entry
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Attribute) {
            Attribute attribute = (Attribute) obj;
            if (this.key == null ? attribute.key != null : !this.key.equals(attribute.key)) {
                return false;
            }
            if (this.value != null) {
                if (this.value.equals(attribute.value)) {
                    return true;
                }
            } else if (attribute.value == null) {
                return true;
            }
            return false;
        }
        return false;
    }

    @Override // java.util.Map.Entry
    public int hashCode() {
        return ((this.key != null ? this.key.hashCode() : 0) * 31) + (this.value != null ? this.value.hashCode() : 0);
    }

    /* JADX DEBUG: Method merged with bridge method */
    public Attribute clone() {
        try {
            return (Attribute) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}

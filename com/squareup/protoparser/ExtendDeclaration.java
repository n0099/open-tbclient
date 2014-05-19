package com.squareup.protoparser;

import com.squareup.protoparser.MessageType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes.dex */
public final class ExtendDeclaration {
    private final String documentation;
    private final List<MessageType.Field> fields;
    private final String fqname;
    private final String name;

    public ExtendDeclaration(String str, String str2, String str3, List<MessageType.Field> list) {
        this.name = str;
        this.fqname = str2;
        this.documentation = str3;
        this.fields = Collections.unmodifiableList(new ArrayList(list));
    }

    public String getName() {
        return this.name;
    }

    public String getFullyQualifiedName() {
        return this.fqname;
    }

    public String getDocumentation() {
        return this.documentation;
    }

    public List<MessageType.Field> getFields() {
        return this.fields;
    }

    public boolean equals(Object obj) {
        if (obj instanceof ExtendDeclaration) {
            ExtendDeclaration extendDeclaration = (ExtendDeclaration) obj;
            return this.name.equals(extendDeclaration.name) && this.documentation.equals(extendDeclaration.documentation) && this.fields.equals(extendDeclaration.fields);
        }
        return false;
    }

    public int hashCode() {
        return this.name.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("extend %s %s %s", this.name, this.fqname, this.documentation));
        for (MessageType.Field field : this.fields) {
            sb.append("\n  ").append(field);
        }
        return sb.toString();
    }
}

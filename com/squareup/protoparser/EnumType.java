package com.squareup.protoparser;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes.dex */
public final class EnumType implements Type {
    private final String documentation;
    private final String fqname;
    private final String name;
    private final List<Value> values;

    /* JADX INFO: Access modifiers changed from: package-private */
    public EnumType(String str, String str2, String str3, List<Value> list) {
        if (str == null) {
            throw new NullPointerException("name");
        }
        if (str2 == null) {
            throw new NullPointerException("fqname");
        }
        if (str3 == null) {
            throw new NullPointerException("documentation");
        }
        if (list == null) {
            throw new NullPointerException("values");
        }
        this.name = str;
        this.fqname = str2;
        this.documentation = str3;
        this.values = Collections.unmodifiableList(new ArrayList(list));
    }

    @Override // com.squareup.protoparser.Type
    public String getName() {
        return this.name;
    }

    @Override // com.squareup.protoparser.Type
    public String getFullyQualifiedName() {
        return this.fqname;
    }

    public String getDocumentation() {
        return this.documentation;
    }

    public List<Value> getValues() {
        return this.values;
    }

    @Override // com.squareup.protoparser.Type
    public List<Type> getNestedTypes() {
        return Collections.emptyList();
    }

    public boolean equals(Object obj) {
        if (obj instanceof EnumType) {
            EnumType enumType = (EnumType) obj;
            return this.name.equals(enumType.name) && this.documentation.equals(enumType.documentation) && this.values.equals(enumType.values);
        }
        return false;
    }

    public int hashCode() {
        return this.name.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.name);
        for (Value value : this.values) {
            sb.append("\n  ").append(value);
        }
        return sb.toString();
    }

    /* loaded from: classes.dex */
    public final class Value {
        private final String documentation;
        private final String name;
        private final List<Option> options;
        private final int tag;

        /* JADX INFO: Access modifiers changed from: package-private */
        public Value(String str, int i, String str2, List<Option> list) {
            if (str == null) {
                throw new NullPointerException("name");
            }
            if (str2 == null) {
                throw new NullPointerException("documentation");
            }
            if (list == null) {
                throw new NullPointerException("options");
            }
            this.name = str;
            this.tag = i;
            this.documentation = str2;
            this.options = Collections.unmodifiableList(new ArrayList(list));
        }

        public String getName() {
            return this.name;
        }

        public int getTag() {
            return this.tag;
        }

        public String getDocumentation() {
            return this.documentation;
        }

        public List<Option> getOptions() {
            return this.options;
        }

        public boolean equals(Object obj) {
            if (obj instanceof Value) {
                Value value = (Value) obj;
                return this.name.equals(value.name) && this.tag == value.tag && this.documentation.equals(value.documentation) && this.options.equals(value.options);
            }
            return false;
        }

        public int hashCode() {
            return this.name.hashCode();
        }

        public String toString() {
            StringBuilder sb = new StringBuilder(String.format("%s = %d", this.name, Integer.valueOf(this.tag)));
            for (Option option : this.options) {
                sb.append("\n    option: ").append(option);
            }
            return sb.toString();
        }
    }
}

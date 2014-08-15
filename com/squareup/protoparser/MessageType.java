package com.squareup.protoparser;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public final class MessageType implements Type {
    private final String documentation;
    private final List<Extensions> extensions;
    private final List<Field> fields;
    private final String fqname;
    private final String name;
    private final List<Type> nestedTypes;
    private final List<Option> options;

    /* loaded from: classes.dex */
    public enum Label {
        OPTIONAL,
        REQUIRED,
        REPEATED
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MessageType(String str, String str2, String str3, List<Field> list, List<Type> list2, List<Extensions> list3, List<Option> list4) {
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
            throw new NullPointerException("fields");
        }
        if (list2 == null) {
            throw new NullPointerException("nestedTypes");
        }
        if (list3 == null) {
            throw new NullPointerException("extensions");
        }
        if (list4 == null) {
            throw new NullPointerException("options");
        }
        this.name = str;
        this.fqname = str2;
        this.documentation = str3;
        this.fields = Collections.unmodifiableList(new ArrayList(list));
        this.nestedTypes = Collections.unmodifiableList(new ArrayList(list2));
        this.extensions = Collections.unmodifiableList(new ArrayList(list3));
        this.options = Collections.unmodifiableList(new ArrayList(list4));
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

    public List<Field> getFields() {
        return this.fields;
    }

    @Override // com.squareup.protoparser.Type
    public List<Type> getNestedTypes() {
        return this.nestedTypes;
    }

    public List<Extensions> getExtensions() {
        return this.extensions;
    }

    public List<Option> getOptions() {
        return this.options;
    }

    public boolean equals(Object obj) {
        if (obj instanceof MessageType) {
            MessageType messageType = (MessageType) obj;
            return this.name.equals(messageType.name) && this.documentation.equals(messageType.documentation) && this.fields.equals(messageType.fields) && this.nestedTypes.equals(messageType.nestedTypes) && this.options.equals(messageType.options);
        }
        return false;
    }

    public int hashCode() {
        return this.name.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.name);
        for (Option option : this.options) {
            sb.append("\n  option: ").append(option);
        }
        for (Field field : this.fields) {
            sb.append("\n  ").append(field);
        }
        for (Type type : this.nestedTypes) {
            sb.append(type).append("\n");
        }
        return sb.toString();
    }

    /* loaded from: classes.dex */
    public final class Field {
        private final String documentation;
        private final Label label;
        private final String name;
        private final List<Option> options;
        private final int tag;
        private final String type;

        /* JADX INFO: Access modifiers changed from: package-private */
        public Field(Label label, String str, String str2, int i, String str3, List<Option> list) {
            if (label == null) {
                throw new NullPointerException("label");
            }
            if (str == null) {
                throw new NullPointerException("type");
            }
            if (str2 == null) {
                throw new NullPointerException("name");
            }
            if (str3 == null) {
                throw new NullPointerException("documentation");
            }
            if (list == null) {
                throw new NullPointerException("options");
            }
            this.label = label;
            this.type = str;
            this.name = str2;
            this.tag = i;
            this.documentation = str3;
            this.options = Collections.unmodifiableList(new ArrayList(list));
        }

        public Label getLabel() {
            return this.label;
        }

        public String getType() {
            return this.type;
        }

        public String getName() {
            return this.name;
        }

        public int getTag() {
            return this.tag;
        }

        public List<Option> getOptions() {
            return this.options;
        }

        public Map<String, Object> getExtensions() {
            return optionsToMap(this.options);
        }

        private Map<String, Object> optionsToMap(List<Option> list) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Option option : list) {
                String name = option.getName();
                Object value = option.getValue();
                if ((value instanceof String) || (value instanceof List)) {
                    linkedHashMap.put(name, value);
                } else if (value instanceof Option) {
                    Map<String, Object> optionsToMap = optionsToMap(Arrays.asList((Option) value));
                    Object obj = linkedHashMap.get(name);
                    if (obj instanceof Map) {
                        Map map = (Map) obj;
                        for (Map.Entry<String, Object> entry : optionsToMap.entrySet()) {
                            map.put(entry.getKey(), entry.getValue());
                        }
                    } else {
                        linkedHashMap.put(name, optionsToMap);
                    }
                } else if (value instanceof Map) {
                    Object obj2 = linkedHashMap.get(name);
                    if (obj2 instanceof Map) {
                        ((Map) obj2).putAll((Map) value);
                    } else {
                        linkedHashMap.put(name, value);
                    }
                } else {
                    throw new AssertionError("Option value must be String, List, or Map<String, ?>");
                }
            }
            return linkedHashMap;
        }

        public String getDocumentation() {
            return this.documentation;
        }

        public boolean isDeprecated() {
            return "true".equals(getOptionValue("deprecated"));
        }

        public boolean isPacked() {
            return "true".equals(getOptionValue("packed"));
        }

        public String getDefault() {
            return (String) getOptionValue("default");
        }

        private Object getOptionValue(String str) {
            for (Option option : this.options) {
                if (option.getName().equals(str)) {
                    return option.getValue();
                }
            }
            return null;
        }

        public boolean equals(Object obj) {
            if (obj instanceof Field) {
                Field field = (Field) obj;
                return this.label.equals(field.label) && this.type.equals(field.type) && this.name.equals(field.name) && this.tag == field.tag && this.options.equals(field.options) && this.documentation.equals(field.documentation);
            }
            return false;
        }

        public int hashCode() {
            return this.name.hashCode() + (this.type.hashCode() * 37);
        }

        public String toString() {
            return String.format("%s %s %s = %d %s", this.label, this.type, this.name, Integer.valueOf(this.tag), this.options);
        }
    }
}

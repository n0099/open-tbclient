package com.squareup.wire;

import com.squareup.protoparser.MessageType;
import com.squareup.protoparser.Option;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public class OptionsMapMaker {
    private final WireCompiler compiler;

    public OptionsMapMaker(WireCompiler wireCompiler) {
        this.compiler = wireCompiler;
    }

    public Map<String, ?> createMessageOptionsMap(MessageType messageType) {
        List<Option> options = messageType.getOptions();
        if (options.isEmpty()) {
            return null;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Option option : options) {
            insertOption(option.getName(), option.getValue(), messageType.getFullyQualifiedName(), linkedHashMap);
        }
        return linkedHashMap;
    }

    public Map<String, ?> createFieldOptionsMap(MessageType messageType, List<Option> list) {
        if (list.isEmpty()) {
            return null;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Option option : list) {
            String name = option.getName();
            if (!WireCompiler.DEFAULT_FIELD_OPTION_KEYS.contains(name)) {
                insertOption(name, option.getValue(), messageType.getFullyQualifiedName(), linkedHashMap);
            }
        }
        return linkedHashMap;
    }

    private void insertOption(String str, Object obj, String str2, Map<String, Object> map) {
        if (getExtensionPrefix(str).isEmpty()) {
            str = this.compiler.prefixWithPackageName(str);
        }
        insertOptionHelper(str, obj, str2, map);
    }

    private void insertOptionHelper(String str, Object obj, String str2, Map<String, Object> map) {
        Object obj2;
        String stripSquareBrackets = stripSquareBrackets(str);
        int indexOf = stripSquareBrackets.indexOf(46, getExtensionPrefix(stripSquareBrackets).length());
        if (indexOf != -1) {
            String substring = stripSquareBrackets.substring(0, indexOf);
            insertOptionHelper(substring, new Option(stripSquareBrackets.substring(indexOf + 1), obj), getFieldType(str2, substring), map);
            return;
        }
        ExtensionInfo extensionInfo = this.compiler.isEnum(str2) ? null : getExtensionInfo(stripSquareBrackets);
        if (extensionInfo == null && this.compiler.getProtoFile().getPackageName().endsWith("." + stripSquareBrackets) && (obj instanceof Option)) {
            stripSquareBrackets = this.compiler.prefixWithPackageName(((Option) obj).getName());
            extensionInfo = this.compiler.getExtension(stripSquareBrackets);
            obj2 = ((Option) obj).getValue();
        } else {
            obj2 = obj;
        }
        String str3 = extensionInfo != null ? extensionInfo.fqType : str2;
        String fieldType = extensionInfo == null ? getFieldType(str3, stripSquareBrackets) : extensionInfo.type;
        if (fieldType == null) {
            fieldType = str3;
        }
        if (obj2 instanceof String) {
            MessageType.Label fieldLabel = getFieldLabel(str3, stripSquareBrackets);
            if (extensionInfo != null) {
                fieldLabel = extensionInfo.label;
            }
            insertStringOption(stripSquareBrackets, (String) obj2, map, fieldType, fieldLabel);
        } else if (obj2 instanceof List) {
            insertListOption(stripSquareBrackets, (List) obj2, str3, map, fieldType);
        } else if (obj2 instanceof Option) {
            insertOptionOption(stripSquareBrackets, (Option) obj2, str3, map);
        } else if (obj2 instanceof Map) {
            insertMapOption(stripSquareBrackets, (Map) obj2, str3, map);
        } else {
            throw new RuntimeException("value is not an Option, String, List, or Map");
        }
    }

    private ExtensionInfo getExtensionInfo(String str) {
        ExtensionInfo extension = this.compiler.getExtension(str);
        if (extension == null) {
            return this.compiler.getExtension(this.compiler.prefixWithPackageName(str));
        }
        return extension;
    }

    private MessageType.Label getFieldLabel(String str, String str2) {
        FieldInfo field = this.compiler.getField(String.valueOf(str) + "$" + str2);
        if (field == null) {
            return null;
        }
        return field.label;
    }

    private String stripSquareBrackets(String str) {
        int length = str.length() - 1;
        if (str.charAt(0) == '[' && str.charAt(length) == ']') {
            String substring = str.substring(1, length);
            if (!substring.contains(".")) {
                return this.compiler.prefixWithPackageName(substring);
            }
            return substring;
        }
        return str;
    }

    private String getFieldType(String str, String str2) {
        return getFieldType(this.compiler.getField(String.valueOf(str) + "$" + str2));
    }

    private String getExtensionPrefix(String str) {
        int length = str.length();
        while (true) {
            int i = length;
            if (i != -1) {
                String substring = str.substring(0, i);
                if (this.compiler.getExtension(substring) != null) {
                    return substring;
                }
                length = str.lastIndexOf(46, i - 1);
            } else {
                return "";
            }
        }
    }

    private String getFieldType(FieldInfo fieldInfo) {
        if (fieldInfo == null) {
            return null;
        }
        return fieldInfo.name;
    }

    private void insertStringOption(String str, String str2, Map<String, Object> map, String str3, MessageType.Label label) {
        String optionInitializer = getOptionInitializer(str2, str3);
        if (label == MessageType.Label.REPEATED) {
            List list = (List) map.get(str);
            if (list == null) {
                list = new ArrayList();
                map.put(str, list);
            }
            list.add(optionInitializer);
            return;
        }
        map.put(str, optionInitializer);
    }

    private void insertListOption(String str, List<?> list, String str2, Map<String, Object> map, String str3) {
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (obj instanceof String) {
                arrayList.add(getOptionInitializer((String) obj, str3));
            } else if (obj instanceof Map) {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put("@type", str2);
                insertOptionsFromMap(str2, (Map) obj, linkedHashMap);
                arrayList.add(linkedHashMap);
            } else {
                throw new RuntimeException("List contains " + obj.getClass().getName() + ", not String or Map");
            }
        }
        map.put(str, arrayList);
    }

    private String getOptionInitializer(String str, String str2) {
        if (TypeInfo.isScalar(str2)) {
            return this.compiler.getInitializerForType(str, TypeInfo.scalarType(str2));
        } else if (this.compiler.isEnum(str2)) {
            String javaName = this.compiler.javaName(str2);
            String javaPackage = this.compiler.getJavaPackage();
            if (javaName.startsWith(String.valueOf(javaPackage) + ".")) {
                javaName = javaName.substring(javaPackage.length() + 1);
            }
            String typeBeingGenerated = this.compiler.getTypeBeingGenerated();
            if (javaName.startsWith(String.valueOf(typeBeingGenerated) + ".")) {
                javaName = javaName.substring(typeBeingGenerated.length() + 1);
            }
            return String.valueOf(javaName) + "." + this.compiler.getTrailingSegment(str);
        } else {
            return str;
        }
    }

    private void insertOptionsFromMap(String str, Map<String, ?> map, Map<String, Object> map2) {
        for (Map.Entry<String, ?> entry : map.entrySet()) {
            String key = entry.getKey();
            String fieldType = getFieldType(str, key);
            insertOptionHelper(key, qualifyEnum(str, key, fieldType, entry.getValue()), fieldType, map2);
        }
    }

    private void insertOptionOption(String str, Option option, String str2, Map<String, Object> map) {
        Map<String, Object> orCreateFromMap = getOrCreateFromMap(map, str);
        orCreateFromMap.put("@type", str2);
        String name = option.getName();
        insertOptionHelper(name, qualifyEnum(str2, name, getFieldType(str2, name), option.getValue()), str2, orCreateFromMap);
    }

    private Object qualifyEnum(String str, String str2, String str3, Object obj) {
        if (this.compiler.isEnum(getFieldType(str, str2))) {
            return String.valueOf(str3) + "." + obj;
        }
        return obj;
    }

    private void insertMapOption(String str, Map<String, ?> map, String str2, Map<String, Object> map2) {
        Map<String, Object> orCreateFromMap = getOrCreateFromMap(map2, str);
        orCreateFromMap.put("@type", str2);
        insertOptionsFromMap(str2, map, orCreateFromMap);
    }

    private Map<String, Object> getOrCreateFromMap(Map<String, Object> map, String str) {
        Object obj = map.get(str);
        if (obj == null) {
            obj = new LinkedHashMap();
            map.put(str, obj);
        }
        return (Map) obj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String createOptionInitializer(Object obj, String str, String str2, String str3, boolean z, int i) {
        String str4;
        String fieldType;
        int i2 = i + 1;
        StringBuilder sb = new StringBuilder();
        if (obj instanceof Map) {
            Map map = (Map) obj;
            String javaName = this.compiler.javaName(str3);
            FieldInfo field = this.compiler.getField(String.valueOf(str) + "$" + str2);
            boolean z2 = (z || field == null || !field.isRepeated()) ? false : true;
            if (z2) {
                sb.append("asList(");
            }
            sb.append("new ").append(this.compiler.shortenJavaName(javaName)).append(".Builder()");
            for (Map.Entry entry : map.entrySet()) {
                String str5 = (String) entry.getKey();
                if (!isMetadata(str5)) {
                    sb.append("\n");
                    indent(sb, i2);
                    sb.append(".");
                    ExtensionInfo extension = this.compiler.getExtension(str5);
                    if (extension != null) {
                        str4 = this.compiler.getTrailingSegment(str5);
                        sb.append(String.format("setExtension(Ext_%s.%s, ", extension.location, str4));
                    } else {
                        sb.append(str5).append("(");
                        str4 = str5;
                    }
                    FieldInfo field2 = this.compiler.getField(String.valueOf(str3) + "$" + str4);
                    if (field2 == null) {
                        ExtensionInfo extension2 = this.compiler.getExtension((String) entry.getKey());
                        if (extension2 != null) {
                            fieldType = extension2.fqType;
                        } else {
                            throw new RuntimeException("Unknown name " + ((String) entry.getKey()));
                        }
                    } else {
                        fieldType = getFieldType(field2);
                    }
                    sb.append(createOptionInitializer(entry.getValue(), str3, str4, fieldType, false, i2)).append(")");
                }
            }
            sb.append("\n");
            indent(sb, i2);
            sb.append(".build()");
            if (z2) {
                sb.append(")");
            }
        } else if (obj instanceof List) {
            sb.append("asList(");
            String str6 = "\n";
            for (Object obj2 : (List) obj) {
                sb.append(str6);
                indent(sb, i2);
                if (obj2 instanceof String) {
                    sb.append((String) obj2);
                } else if (obj2 instanceof Map) {
                    sb.append(createOptionInitializer(obj2, str, str2, str3, true, i2));
                }
                str6 = ",\n";
            }
            sb.append(")");
        } else {
            sb.append((String) obj);
        }
        return sb.toString();
    }

    private void indent(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            sb.append("    ");
        }
    }

    private boolean isMetadata(String str) {
        return str.charAt(0) == '@';
    }

    public void getOptionTypes(Map<String, ?> map, List<String> list) {
        if (map != null) {
            for (Map.Entry<String, ?> entry : map.entrySet()) {
                String key = entry.getKey();
                ExtensionInfo extension = this.compiler.getExtension(key);
                if (extension != null && !extension.fqLocation.startsWith(this.compiler.getJavaPackage())) {
                    list.add(extension.fqLocation);
                }
                if ("@type".equals(key)) {
                    String javaName = this.compiler.javaName((String) entry.getValue());
                    if (this.compiler.fullyQualifiedNameIsOutsidePackage(javaName)) {
                        list.add(javaName);
                    }
                } else if (entry.getValue() instanceof List) {
                    for (Object obj : (List) entry.getValue()) {
                        if (obj instanceof Map) {
                            getOptionTypes((Map) obj, list);
                        }
                    }
                } else if (entry.getValue() instanceof Map) {
                    getOptionTypes((Map) entry.getValue(), list);
                }
            }
        }
    }
}

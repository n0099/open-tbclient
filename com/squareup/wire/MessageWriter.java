package com.squareup.wire;

import com.squareup.javawriter.JavaWriter;
import com.squareup.protoparser.EnumType;
import com.squareup.protoparser.MessageType;
import com.squareup.protoparser.Option;
import com.squareup.protoparser.ProtoFile;
import com.squareup.protoparser.Type;
import com.squareup.wire.Message;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import javax.lang.model.element.Modifier;
import org.apache.commons.io.IOUtils;
/* loaded from: classes.dex */
public class MessageWriter {
    private static final Set<String> JAVA_KEYWORDS = new LinkedHashSet(Arrays.asList("abstract", "assert", "boolean", "break", "byte", "case", "catch", "char", "class", "const", "continue", "default", "do", "double", "else", "enum", "extends", "final", "finally", "float", "for", "goto", "if", "implements", "import", "instanceof", "int", "interface", "long", "native", "new", "package", "private", "protected", "public", "return", "short", "static", "strictfp", "super", "switch", "synchronized", "this", "throw", "throws", "transient", "try", "void", "volatile", "while"));
    private static final String URL_CHARS = "[-!#$%&'()*+,./0-9:;=?@A-Z\\[\\]_a-z~]";
    private final WireCompiler compiler;
    private final JavaWriter writer;

    public MessageWriter(WireCompiler wireCompiler) {
        this.compiler = wireCompiler;
        this.writer = wireCompiler.getWriter();
    }

    public static void emitDocumentation(JavaWriter javaWriter, String str) {
        if (hasDocumentation(str)) {
            javaWriter.emitJavadoc(sanitizeJavadoc(str), new Object[0]);
        }
    }

    static String sanitizeJavadoc(String str) {
        return str.replace("%", "%%").replaceAll("[^\\S\n]+\n", IOUtils.LINE_SEPARATOR_UNIX).replaceAll("\\s+$", "").replaceAll("@see (http:[-!#$%&'()*+,./0-9:;=?@A-Z\\[\\]_a-z~]+)", "@see <a href=\"$1\">$1</a>");
    }

    public void emitHeader(Set<String> set, Collection<Message.Datatype> collection, Collection<Message.Label> collection2) {
        this.writer.emitImports(set);
        if (!collection.isEmpty() || !collection2.isEmpty()) {
            this.writer.emitEmptyLine();
        }
        Iterator<Message.Datatype> it = collection.iterator();
        while (it.hasNext()) {
            this.writer.emitStaticImports("com.squareup.wire.Message.Datatype." + it.next().toString());
        }
        Iterator<Message.Label> it2 = collection2.iterator();
        while (it2.hasNext()) {
            this.writer.emitStaticImports("com.squareup.wire.Message.Label." + it2.next().toString());
        }
    }

    public void emitType(Type type, String str, Map<String, ?> map, boolean z) {
        EnumType.Value value;
        this.writer.emitEmptyLine();
        if (type instanceof MessageType) {
            emitAll((MessageType) type, map, z);
            for (Type type2 : type.getNestedTypes()) {
                emitType(type2, String.valueOf(str) + type2.getName() + ".", map, false);
            }
            this.writer.endType();
        } else if (type instanceof EnumType) {
            EnumType enumType = (EnumType) type;
            this.writer.beginType(enumType.getName(), "enum", EnumSet.of(Modifier.PUBLIC), null, "ProtoEnum");
            List<EnumType.Value> values = enumType.getValues();
            int size = values.size();
            int i = 0;
            while (i < size) {
                emitDocumentation(this.writer, values.get(i).getDocumentation());
                this.writer.emitEnumValue(String.valueOf(value.getName()) + "(" + value.getTag() + ")", i == size + (-1));
                i++;
            }
            this.writer.emitEmptyLine();
            this.writer.emitField("int", "value", EnumSet.of(Modifier.PRIVATE, Modifier.FINAL));
            this.writer.emitEmptyLine();
            this.writer.beginConstructor(EnumSet.of(Modifier.PRIVATE), "int", "value");
            this.writer.emitStatement("this.value = value", new Object[0]);
            this.writer.endConstructor();
            this.writer.emitEmptyLine();
            this.writer.emitAnnotation(Override.class);
            this.writer.beginMethod("int", "getValue", EnumSet.of(Modifier.PUBLIC), new String[0]);
            this.writer.emitStatement("return value", new Object[0]);
            this.writer.endMethod();
            this.writer.endType();
        }
    }

    private void emitAll(MessageType messageType, Map<String, ?> map, boolean z) {
        EnumSet of = EnumSet.of(Modifier.PUBLIC, Modifier.FINAL);
        if (!z) {
            of.add(Modifier.STATIC);
        }
        String name = messageType.getName();
        emitDocumentation(this.writer, messageType.getDocumentation());
        this.writer.beginType(name, "class", of, this.compiler.hasExtensions(messageType) ? "ExtendableMessage<" + name + ">" : "Message", new String[0]);
        emitMessageOptions(map);
        if (this.compiler.emitOptions()) {
            emitMessageFieldOptions(messageType);
        }
        emitMessageFieldDefaults(messageType);
        emitMessageFields(messageType);
        emitMessageConstructor(messageType);
        emitBuilder(messageType);
    }

    private void emitMessageOptions(Map<String, ?> map) {
        if (map != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("new MessageOptions.Builder()");
            for (Map.Entry<String, ?> entry : map.entrySet()) {
                String key = entry.getKey();
                ExtensionInfo extension = this.compiler.getExtension(key);
                sb.append(String.format("%n.setExtension(Ext_%s.%s, %s)", extension.location, this.compiler.getTrailingSegment(key), this.compiler.getOptionsMapMaker().createOptionInitializer(entry.getValue(), "", "", extension.fqType, false, 0)));
            }
            sb.append("\n.build()");
            this.writer.emitEmptyLine();
            this.writer.emitField("MessageOptions", "MESSAGE_OPTIONS", EnumSet.of(Modifier.PUBLIC, Modifier.STATIC, Modifier.FINAL), sb.toString());
        }
    }

    private void emitMessageFieldOptions(MessageType messageType) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (MessageType.Field field : messageType.getFields()) {
            ArrayList arrayList = new ArrayList(field.getOptions());
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                if (WireCompiler.DEFAULT_FIELD_OPTION_KEYS.contains(((Option) it.next()).getName())) {
                    it.remove();
                }
            }
            if (!arrayList.isEmpty()) {
                linkedHashMap.put(field.getName(), arrayList);
            }
        }
        if (!linkedHashMap.isEmpty()) {
            this.writer.emitEmptyLine();
        }
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            emitFieldOptions((String) entry.getKey(), this.compiler.getOptionsMapMaker().createFieldOptionsMap(messageType, (List) entry.getValue()));
        }
    }

    private void emitFieldOptions(String str, Map<String, ?> map) {
        if (map != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("new FieldOptions.Builder()");
            for (Map.Entry<String, ?> entry : map.entrySet()) {
                String key = entry.getKey();
                ExtensionInfo extension = this.compiler.getExtension(key);
                if (extension == null) {
                    throw new WireCompilerException("No extension info for " + key);
                }
                sb.append(String.format("%n.setExtension(Ext_%s.%s, %s)", extension.location, this.compiler.getTrailingSegment(key), this.compiler.getOptionsMapMaker().createOptionInitializer(entry.getValue(), "", "", extension.fqType, false, 0)));
            }
            sb.append("\n.build()");
            this.writer.emitField("FieldOptions", "FIELD_OPTIONS_" + str.toUpperCase(Locale.US), EnumSet.of(Modifier.PUBLIC, Modifier.STATIC, Modifier.FINAL), sb.toString());
        }
    }

    private void emitMessageFieldDefaults(MessageType messageType) {
        ArrayList<MessageType.Field> arrayList = new ArrayList();
        for (MessageType.Field field : messageType.getFields()) {
            if (!isMessageType(messageType, field) || FieldInfo.isRepeated(field)) {
                arrayList.add(field);
            }
        }
        if (!arrayList.isEmpty()) {
            this.writer.emitEmptyLine();
        }
        for (MessageType.Field field2 : arrayList) {
            String javaFieldType = getJavaFieldType(messageType, field2);
            if (javaFieldType == null) {
                throw new WireCompilerException("Unknown type for field " + field2 + " in message " + messageType.getName());
            }
            this.writer.emitField(javaFieldType, "DEFAULT_" + field2.getName().toUpperCase(Locale.US), EnumSet.of(Modifier.PUBLIC, Modifier.STATIC, Modifier.FINAL), getDefaultValue(messageType, field2));
        }
    }

    private void emitMessageFields(MessageType messageType) {
        HashSet hashSet = new HashSet();
        for (MessageType.Field field : messageType.getFields()) {
            int tag = field.getTag();
            if (hashSet.contains(Integer.valueOf(tag))) {
                throw new WireCompilerException("Duplicate tag value for field " + messageType.getFullyQualifiedName() + "." + field.getName());
            }
            hashSet.add(Integer.valueOf(tag));
            String type = field.getType();
            String javaName = this.compiler.javaName(messageType, type);
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("tag", String.valueOf(tag));
            boolean z = false;
            if (TypeInfo.isScalar(type)) {
                linkedHashMap.put("type", scalarTypeConstant(type));
            } else {
                z = this.compiler.isEnum(this.compiler.fullyQualifiedName(messageType, type));
                if (z) {
                    linkedHashMap.put("type", "ENUM");
                }
            }
            if (!FieldInfo.isOptional(field)) {
                if (FieldInfo.isPacked(field, z)) {
                    linkedHashMap.put("label", "PACKED");
                } else {
                    linkedHashMap.put("label", field.getLabel().toString());
                }
            }
            if (field.isDeprecated()) {
                linkedHashMap.put("deprecated", "true");
            }
            this.writer.emitEmptyLine();
            emitDocumentation(this.writer, field.getDocumentation());
            this.writer.emitAnnotation(ProtoField.class, (Map<String, ?>) linkedHashMap);
            if (field.isDeprecated()) {
                this.writer.emitAnnotation(Deprecated.class);
            }
            this.writer.emitField(FieldInfo.isRepeated(field) ? "List<" + javaName + ">" : javaName, sanitize(field.getName()), EnumSet.of(Modifier.PUBLIC, Modifier.FINAL));
        }
    }

    private void emitMessageConstructor(MessageType messageType) {
        this.writer.emitEmptyLine();
        this.writer.beginMethod(null, messageType.getName(), EnumSet.of(Modifier.PRIVATE), "Builder", "builder", "boolean", "addDefault");
        this.writer.emitStatement("super(builder)", new Object[0]);
        this.writer.beginControlFlow("if (addDefault == true)");
        for (MessageType.Field field : messageType.getFields()) {
            String name = field.getName();
            if (FieldInfo.isRepeated(field)) {
                this.writer.beginControlFlow("if (builder." + sanitize(name) + " == null)");
                this.writer.emitStatement("this.%1$s = %2$s", sanitize(name), "DEFAULT_" + name.toUpperCase(Locale.US));
                this.writer.nextControlFlow("else");
                this.writer.emitStatement("this.%1$s = immutableCopyOf(builder.%1$s)", sanitize(name));
                this.writer.endControlFlow();
            } else if (!isMessageType(messageType, field)) {
                this.writer.beginControlFlow("if (builder." + sanitize(name) + " == null)");
                this.writer.emitStatement("this.%1$s = %2$s", sanitize(name), "DEFAULT_" + name.toUpperCase(Locale.US));
                this.writer.nextControlFlow("else");
                this.writer.emitStatement("this.%1$s = builder.%1$s", sanitize(name));
                this.writer.endControlFlow();
            } else {
                this.writer.emitStatement("this.%1$s = builder.%1$s", sanitize(name));
            }
        }
        this.writer.nextControlFlow("else");
        for (MessageType.Field field2 : messageType.getFields()) {
            if (FieldInfo.isRepeated(field2)) {
                this.writer.emitStatement("this.%1$s = immutableCopyOf(builder.%1$s)", sanitize(field2.getName()));
            } else {
                this.writer.emitStatement("this.%1$s = builder.%1$s", sanitize(field2.getName()));
            }
        }
        this.writer.endControlFlow();
        this.writer.endMethod();
    }

    private void emitMessageEquals(MessageType messageType) {
        this.writer.emitEmptyLine();
        this.writer.emitAnnotation(Override.class);
        this.writer.beginMethod("boolean", "equals", EnumSet.of(Modifier.PUBLIC), "Object", "other");
        List<MessageType.Field> fields = messageType.getFields();
        if (fields.isEmpty()) {
            this.writer.emitStatement("return other instanceof %s", messageType.getName());
        } else {
            this.writer.emitStatement("if (other == this) return true", new Object[0]);
            this.writer.emitStatement("if (!(other instanceof %s)) return false", messageType.getName());
            if (hasOnlyOneField(messageType)) {
                String sanitize = sanitize(fields.get(0).getName());
                this.writer.emitStatement("return equals(%1$s, ((%2$s) other).%3$s)", addThisIfOneOf(sanitize, "other", "o"), messageType.getName(), sanitize);
            } else {
                this.writer.emitStatement("%1$s o = (%1$s) other", messageType.getName());
                if (this.compiler.hasExtensions(messageType)) {
                    this.writer.emitStatement("if (!extensionsEqual(o)) return false", new Object[0]);
                }
                StringBuilder sb = new StringBuilder();
                String str = "return ";
                for (MessageType.Field field : fields) {
                    sb.append(str);
                    str = "\n&& ";
                    String sanitize2 = sanitize(field.getName());
                    sb.append(String.format("equals(%1$s, o.%2$s)", addThisIfOneOf(sanitize2, "other", "o"), sanitize2));
                }
                this.writer.emitStatement(sb.toString(), new Object[0]);
            }
        }
        this.writer.endMethod();
    }

    private void emitMessageHashCode(MessageType messageType) {
        boolean z;
        this.writer.emitEmptyLine();
        this.writer.emitAnnotation(Override.class);
        this.writer.beginMethod("int", "hashCode", EnumSet.of(Modifier.PUBLIC), new String[0]);
        if (!this.compiler.hasFields(messageType) && !this.compiler.hasExtensions(messageType)) {
            this.writer.emitStatement("return 0", new Object[0]);
        } else if (hasOnlyOneField(messageType)) {
            MessageType.Field field = messageType.getFields().get(0);
            String addThisIfOneOf = addThisIfOneOf(sanitize(field.getName()), "result");
            this.writer.emitStatement("int result = hashCode", new Object[0]);
            this.writer.emitStatement("return result != 0 ? result : (hashCode = %1$s != null ? %1$s.hashCode() : %2$s)", addThisIfOneOf, Integer.valueOf(nullHashValue(field)));
        } else {
            this.writer.emitStatement("int result = hashCode", new Object[0]);
            this.writer.beginControlFlow("if (result == 0)");
            if (this.compiler.hasExtensions(messageType)) {
                this.writer.emitStatement("result = extensionsHashCode()", new Object[0]);
                z = true;
            } else {
                z = false;
            }
            boolean z2 = z;
            for (MessageType.Field field2 : messageType.getFields()) {
                String addThisIfOneOf2 = addThisIfOneOf(sanitize(field2.getName()), "result");
                if (z2) {
                    this.writer.emitStatement("result = result * 37 + (%1$s != null ? %1$s.hashCode() : %2$s)", addThisIfOneOf2, Integer.valueOf(nullHashValue(field2)));
                } else {
                    this.writer.emitStatement("result = %1$s != null ? %1$s.hashCode() : %2$s", addThisIfOneOf2, Integer.valueOf(nullHashValue(field2)));
                    z2 = true;
                }
            }
            this.writer.emitStatement("hashCode = result", new Object[0]);
            this.writer.endControlFlow();
            this.writer.emitStatement("return result", new Object[0]);
        }
        this.writer.endMethod();
    }

    private int nullHashValue(MessageType.Field field) {
        return FieldInfo.isRepeated(field) ? 1 : 0;
    }

    private void emitBuilder(MessageType messageType) {
        this.writer.emitEmptyLine();
        this.writer.beginType("Builder", "class", EnumSet.of(Modifier.PUBLIC, Modifier.STATIC, Modifier.FINAL), String.valueOf(this.compiler.hasExtensions(messageType) ? "ExtendableBuilder<" : "Message.Builder<") + messageType.getName() + ">", new String[0]);
        emitBuilderFields(messageType);
        emitBuilderConstructors(messageType);
        if (this.compiler.hasExtensions(messageType)) {
            emitBuilderSetExtension(messageType);
        }
        emitBuilderBuild(messageType);
        this.writer.endType();
    }

    private void emitBuilderFields(MessageType messageType) {
        List<MessageType.Field> fields = messageType.getFields();
        if (!fields.isEmpty()) {
            this.writer.emitEmptyLine();
        }
        for (MessageType.Field field : fields) {
            this.writer.emitField(getJavaFieldType(messageType, field), sanitize(field.getName()), EnumSet.of(Modifier.PUBLIC));
        }
    }

    private void emitBuilderConstructors(MessageType messageType) {
        this.writer.emitEmptyLine();
        this.writer.beginMethod(null, "Builder", EnumSet.of(Modifier.PUBLIC), new String[0]);
        this.writer.endMethod();
        this.writer.emitEmptyLine();
        this.writer.beginMethod(null, "Builder", EnumSet.of(Modifier.PUBLIC), messageType.getName(), "message");
        this.writer.emitStatement("super(message)", new Object[0]);
        List<MessageType.Field> fields = messageType.getFields();
        if (!fields.isEmpty()) {
            this.writer.emitStatement("if (message == null) return", new Object[0]);
        }
        for (MessageType.Field field : fields) {
            if (FieldInfo.isRepeated(field)) {
                this.writer.emitStatement("this.%1$s = copyOf(message.%1$s)", sanitize(field.getName()));
            } else {
                this.writer.emitStatement("this.%1$s = message.%1$s", sanitize(field.getName()));
            }
        }
        this.writer.endMethod();
    }

    private void emitBuilderSetters(MessageType messageType) {
        for (MessageType.Field field : messageType.getFields()) {
            String javaFieldType = getJavaFieldType(messageType, field);
            ArrayList arrayList = new ArrayList();
            arrayList.add(javaFieldType);
            String sanitize = sanitize(field.getName());
            arrayList.add(sanitize);
            this.writer.emitEmptyLine();
            emitDocumentation(this.writer, field.getDocumentation());
            if (field.isDeprecated()) {
                this.writer.emitAnnotation(Deprecated.class);
            }
            this.writer.beginMethod("Builder", sanitize, EnumSet.of(Modifier.PUBLIC), arrayList, null);
            if (FieldInfo.isRepeated(field)) {
                this.writer.emitStatement("this.%1$s = checkForNulls(%1$s)", sanitize);
            } else {
                this.writer.emitStatement("this.%1$s = %1$s", sanitize);
            }
            this.writer.emitStatement("return this", new Object[0]);
            this.writer.endMethod();
        }
    }

    private void emitBuilderSetExtension(MessageType messageType) {
        this.writer.emitEmptyLine();
        this.writer.emitAnnotation(Override.class);
        this.writer.beginMethod("<E> Builder", "setExtension", EnumSet.of(Modifier.PUBLIC), "Extension<" + messageType.getName() + ", E>", "extension", "E", "value");
        this.writer.emitStatement("super.setExtension(extension, value)", new Object[0]);
        this.writer.emitStatement("return this", new Object[0]);
        this.writer.endMethod();
    }

    private void emitBuilderBuild(MessageType messageType) {
        this.writer.emitEmptyLine();
        this.writer.emitAnnotation(Override.class);
        this.writer.beginMethod(messageType.getName(), "build", EnumSet.of(Modifier.PUBLIC), "boolean", "addDefault");
        if (hasRequiredFields(messageType)) {
            this.writer.emitStatement("checkRequiredFields()", new Object[0]);
        }
        this.writer.emitStatement("return new %s(this, addDefault)", messageType.getName());
        this.writer.endMethod();
    }

    private String addThisIfOneOf(String str, String... strArr) {
        for (String str2 : strArr) {
            if (str2.equals(str)) {
                return "this." + str;
            }
        }
        return str;
    }

    private String getDefaultValue(MessageType messageType, MessageType.Field field) {
        String str = field.getDefault();
        if (FieldInfo.isRepeated(field)) {
            return "Collections.emptyList()";
        }
        String javaName = this.compiler.javaName(messageType, field.getType());
        if (TypeInfo.isScalar(field.getType())) {
            return this.compiler.getInitializerForType(str, javaName);
        }
        if (str != null) {
            return String.valueOf(javaName) + "." + str;
        }
        String fullyQualifiedName = this.compiler.fullyQualifiedName(messageType, field.getType());
        if (this.compiler.isEnum(fullyQualifiedName)) {
            return String.valueOf(javaName) + "." + this.compiler.getEnumDefault(fullyQualifiedName);
        }
        throw new WireCompilerException("Field " + field + " cannot have default value");
    }

    private String getJavaFieldType(MessageType messageType, MessageType.Field field) {
        return getJavaFieldType(this.compiler.getProtoFile(), messageType, field);
    }

    private String getJavaFieldType(ProtoFile protoFile, MessageType messageType, MessageType.Field field) {
        String javaName = this.compiler.javaName(protoFile, messageType, field.getType());
        return FieldInfo.isRepeated(field) ? "List<" + javaName + ">" : javaName;
    }

    private static boolean hasDocumentation(String str) {
        return (str == null || str.isEmpty()) ? false : true;
    }

    private boolean hasOnlyOneField(MessageType messageType) {
        return messageType.getFields().size() == 1 && !this.compiler.hasExtensions(messageType);
    }

    private boolean hasRequiredFields(Type type) {
        if (type instanceof MessageType) {
            for (MessageType.Field field : ((MessageType) type).getFields()) {
                if (FieldInfo.isRequired(field)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isMessageType(MessageType messageType, MessageType.Field field) {
        return (TypeInfo.isScalar(field.getType()) || this.compiler.isEnum(this.compiler.fullyQualifiedName(messageType, field.getType()))) ? false : true;
    }

    private String sanitize(String str) {
        return JAVA_KEYWORDS.contains(str) ? "_" + str : str;
    }

    private String scalarTypeConstant(String str) {
        return str.toUpperCase(Locale.US);
    }
}

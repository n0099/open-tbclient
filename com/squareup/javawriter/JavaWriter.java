package com.squareup.javawriter;

import java.io.Closeable;
import java.io.Writer;
import java.lang.annotation.Annotation;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Deque;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.lang.model.element.Modifier;
import org.apache.commons.io.IOUtils;
/* loaded from: classes.dex */
public class JavaWriter implements Closeable {
    private static final String INDENT = "  ";
    private static final int MAX_SINGLE_LINE_ATTRIBUTES = 3;
    private final Writer out;
    private String packagePrefix;
    private static final Pattern TYPE_PATTERN = Pattern.compile("(?:[\\w$]+\\.)*([\\w\\.*$]+)");
    private static final EnumSet<Scope> METHOD_SCOPES = EnumSet.of(Scope.NON_ABSTRACT_METHOD, Scope.CONSTRUCTOR, Scope.CONTROL_FLOW, Scope.INITIALIZER);
    private final Map<String, String> importedTypes = new LinkedHashMap();
    private final Deque<Scope> scopes = new ArrayDeque();
    private final Deque<String> types = new ArrayDeque();
    private boolean isCompressingTypes = true;
    private String indent = INDENT;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public enum Scope {
        TYPE_DECLARATION,
        ABSTRACT_METHOD,
        NON_ABSTRACT_METHOD,
        CONSTRUCTOR,
        CONTROL_FLOW,
        ANNOTATION_ATTRIBUTE,
        ANNOTATION_ARRAY_VALUE,
        INITIALIZER
    }

    public JavaWriter(Writer writer) {
        this.out = writer;
    }

    public void setCompressingTypes(boolean z) {
        this.isCompressingTypes = z;
    }

    public boolean isCompressingTypes() {
        return this.isCompressingTypes;
    }

    public void setIndent(String str) {
        this.indent = str;
    }

    public String getIndent() {
        return this.indent;
    }

    public JavaWriter emitPackage(String str) {
        if (this.packagePrefix != null) {
            throw new IllegalStateException();
        }
        if (str.isEmpty()) {
            this.packagePrefix = "";
        } else {
            this.out.write("package ");
            this.out.write(str);
            this.out.write(";\n\n");
            this.packagePrefix = str + ".";
        }
        return this;
    }

    public JavaWriter emitImports(String... strArr) {
        return emitImports(Arrays.asList(strArr));
    }

    public JavaWriter emitImports(Class<?>... clsArr) {
        ArrayList arrayList = new ArrayList(clsArr.length);
        for (Class<?> cls : clsArr) {
            arrayList.add(cls.getName());
        }
        return emitImports(arrayList);
    }

    public JavaWriter emitImports(Collection<String> collection) {
        Iterator it = new TreeSet(collection).iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            Matcher matcher = TYPE_PATTERN.matcher(str);
            if (!matcher.matches()) {
                throw new IllegalArgumentException(str);
            }
            if (this.importedTypes.put(str, matcher.group(1)) != null) {
                throw new IllegalArgumentException(str);
            }
            this.out.write("import ");
            this.out.write(str);
            this.out.write(";\n");
        }
        return this;
    }

    public JavaWriter emitStaticImports(String... strArr) {
        return emitStaticImports(Arrays.asList(strArr));
    }

    public JavaWriter emitStaticImports(Collection<String> collection) {
        Iterator it = new TreeSet(collection).iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            Matcher matcher = TYPE_PATTERN.matcher(str);
            if (!matcher.matches()) {
                throw new IllegalArgumentException(str);
            }
            if (this.importedTypes.put(str, matcher.group(1)) != null) {
                throw new IllegalArgumentException(str);
            }
            this.out.write("import static ");
            this.out.write(str);
            this.out.write(";\n");
        }
        return this;
    }

    private JavaWriter emitCompressedType(String str) {
        if (this.isCompressingTypes) {
            this.out.write(compressType(str));
        } else {
            this.out.write(str);
        }
        return this;
    }

    public String compressType(String str) {
        StringBuilder sb = new StringBuilder();
        if (this.packagePrefix == null) {
            throw new IllegalStateException();
        }
        Matcher matcher = TYPE_PATTERN.matcher(str);
        int i = 0;
        while (true) {
            boolean find = matcher.find(i);
            sb.append((CharSequence) str, i, find ? matcher.start() : str.length());
            if (find) {
                String group = matcher.group(0);
                String str2 = this.importedTypes.get(group);
                if (str2 != null) {
                    sb.append(str2);
                } else if (isClassInPackage(group, this.packagePrefix)) {
                    String substring = group.substring(this.packagePrefix.length());
                    if (isAmbiguous(substring)) {
                        sb.append(group);
                    } else {
                        sb.append(substring);
                    }
                } else if (isClassInPackage(group, "java.lang.")) {
                    sb.append(group.substring("java.lang.".length()));
                } else {
                    sb.append(group);
                }
                i = matcher.end();
            } else {
                return sb.toString();
            }
        }
    }

    private static boolean isClassInPackage(String str, String str2) {
        return str.startsWith(str2) && (str.indexOf(46, str2.length()) == -1 || Character.isUpperCase(str.charAt(str2.length())));
    }

    private boolean isAmbiguous(String str) {
        return this.importedTypes.values().contains(str);
    }

    public JavaWriter beginInitializer(boolean z) {
        indent();
        if (z) {
            this.out.write("static");
            this.out.write(" {\n");
        } else {
            this.out.write("{\n");
        }
        this.scopes.push(Scope.INITIALIZER);
        return this;
    }

    public JavaWriter endInitializer() {
        popScope(Scope.INITIALIZER);
        indent();
        this.out.write("}\n");
        return this;
    }

    public JavaWriter beginType(String str, String str2) {
        return beginType(str, str2, EnumSet.noneOf(Modifier.class), null, new String[0]);
    }

    public JavaWriter beginType(String str, String str2, Set<Modifier> set) {
        return beginType(str, str2, set, null, new String[0]);
    }

    public JavaWriter beginType(String str, String str2, Set<Modifier> set, String str3, String... strArr) {
        indent();
        emitModifiers(set);
        this.out.write(str2);
        this.out.write(" ");
        emitCompressedType(str);
        if (str3 != null) {
            this.out.write(" extends ");
            emitCompressedType(str3);
        }
        if (strArr.length > 0) {
            this.out.write(IOUtils.LINE_SEPARATOR_UNIX);
            indent();
            this.out.write("    implements ");
            for (int i = 0; i < strArr.length; i++) {
                if (i != 0) {
                    this.out.write(", ");
                }
                emitCompressedType(strArr[i]);
            }
        }
        this.out.write(" {\n");
        this.scopes.push(Scope.TYPE_DECLARATION);
        this.types.push(str);
        return this;
    }

    public JavaWriter endType() {
        popScope(Scope.TYPE_DECLARATION);
        this.types.pop();
        indent();
        this.out.write("}\n");
        return this;
    }

    public JavaWriter emitField(String str, String str2) {
        return emitField(str, str2, EnumSet.noneOf(Modifier.class), null);
    }

    public JavaWriter emitField(String str, String str2, Set<Modifier> set) {
        return emitField(str, str2, set, null);
    }

    public JavaWriter emitField(String str, String str2, Set<Modifier> set, String str3) {
        indent();
        emitModifiers(set);
        emitCompressedType(str);
        this.out.write(" ");
        this.out.write(str2);
        if (str3 != null) {
            this.out.write(" = ");
            String[] split = str3.split(IOUtils.LINE_SEPARATOR_UNIX, -1);
            this.out.write(split[0]);
            for (int i = 1; i < split.length; i++) {
                this.out.write(IOUtils.LINE_SEPARATOR_UNIX);
                hangingIndent();
                this.out.write(split[i]);
            }
        }
        this.out.write(";\n");
        return this;
    }

    public JavaWriter beginMethod(String str, String str2, Set<Modifier> set, String... strArr) {
        return beginMethod(str, str2, set, Arrays.asList(strArr), null);
    }

    public JavaWriter beginMethod(String str, String str2, Set<Modifier> set, List<String> list, List<String> list2) {
        indent();
        emitModifiers(set);
        if (str != null) {
            emitCompressedType(str);
            this.out.write(" ");
            this.out.write(str2);
        } else {
            emitCompressedType(str2);
        }
        this.out.write("(");
        if (list != null) {
            int i = 0;
            while (i < list.size()) {
                if (i != 0) {
                    this.out.write(", ");
                }
                int i2 = i + 1;
                emitCompressedType(list.get(i));
                this.out.write(" ");
                emitCompressedType(list.get(i2));
                i = i2 + 1;
            }
        }
        this.out.write(")");
        if (list2 != null && list2.size() > 0) {
            this.out.write(IOUtils.LINE_SEPARATOR_UNIX);
            indent();
            this.out.write("    throws ");
            for (int i3 = 0; i3 < list2.size(); i3++) {
                if (i3 != 0) {
                    this.out.write(", ");
                }
                emitCompressedType(list2.get(i3));
            }
        }
        if (set.contains(Modifier.ABSTRACT)) {
            this.out.write(";\n");
            this.scopes.push(Scope.ABSTRACT_METHOD);
        } else {
            this.out.write(" {\n");
            this.scopes.push(str == null ? Scope.CONSTRUCTOR : Scope.NON_ABSTRACT_METHOD);
        }
        return this;
    }

    public JavaWriter beginConstructor(Set<Modifier> set, String... strArr) {
        beginMethod(null, this.types.peekFirst(), set, strArr);
        return this;
    }

    public JavaWriter beginConstructor(Set<Modifier> set, List<String> list, List<String> list2) {
        beginMethod(null, this.types.peekFirst(), set, list, list2);
        return this;
    }

    public JavaWriter emitJavadoc(String str, Object... objArr) {
        String format = String.format(str, objArr);
        indent();
        this.out.write("/**\n");
        String[] split = format.split(IOUtils.LINE_SEPARATOR_UNIX);
        for (String str2 : split) {
            indent();
            this.out.write(" *");
            if (!str2.isEmpty()) {
                this.out.write(" ");
                this.out.write(str2);
            }
            this.out.write(IOUtils.LINE_SEPARATOR_UNIX);
        }
        indent();
        this.out.write(" */\n");
        return this;
    }

    public JavaWriter emitSingleLineComment(String str, Object... objArr) {
        indent();
        this.out.write("// ");
        this.out.write(String.format(str, objArr));
        this.out.write(IOUtils.LINE_SEPARATOR_UNIX);
        return this;
    }

    public JavaWriter emitEmptyLine() {
        this.out.write(IOUtils.LINE_SEPARATOR_UNIX);
        return this;
    }

    public JavaWriter emitEnumValue(String str) {
        indent();
        this.out.write(str);
        this.out.write(",\n");
        return this;
    }

    public JavaWriter emitEnumValue(String str, boolean z) {
        return z ? emitLastEnumValue(str) : emitEnumValue(str);
    }

    private JavaWriter emitLastEnumValue(String str) {
        indent();
        this.out.write(str);
        this.out.write(";\n");
        return this;
    }

    public JavaWriter emitEnumValues(Iterable<String> iterable) {
        Iterator<String> it = iterable.iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (it.hasNext()) {
                emitEnumValue(next);
            } else {
                emitLastEnumValue(next);
            }
        }
        return this;
    }

    public JavaWriter emitAnnotation(String str) {
        return emitAnnotation(str, Collections.emptyMap());
    }

    public JavaWriter emitAnnotation(Class<? extends Annotation> cls) {
        return emitAnnotation(type(cls, new String[0]), Collections.emptyMap());
    }

    public JavaWriter emitAnnotation(Class<? extends Annotation> cls, Object obj) {
        return emitAnnotation(type(cls, new String[0]), obj);
    }

    public JavaWriter emitAnnotation(String str, Object obj) {
        indent();
        this.out.write("@");
        emitCompressedType(str);
        this.out.write("(");
        emitAnnotationValue(obj);
        this.out.write(")");
        this.out.write(IOUtils.LINE_SEPARATOR_UNIX);
        return this;
    }

    public JavaWriter emitAnnotation(Class<? extends Annotation> cls, Map<String, ?> map) {
        return emitAnnotation(type(cls, new String[0]), map);
    }

    public JavaWriter emitAnnotation(String str, Map<String, ?> map) {
        indent();
        this.out.write("@");
        emitCompressedType(str);
        switch (map.size()) {
            case 0:
                break;
            case 1:
                Map.Entry<String, ?> next = map.entrySet().iterator().next();
                this.out.write("(");
                if (!"value".equals(next.getKey())) {
                    this.out.write(next.getKey());
                    this.out.write(" = ");
                }
                emitAnnotationValue(next.getValue());
                this.out.write(")");
                break;
            default:
                boolean z = map.size() > 3 || containsArray(map.values());
                this.out.write("(");
                this.scopes.push(Scope.ANNOTATION_ATTRIBUTE);
                String str2 = z ? IOUtils.LINE_SEPARATOR_UNIX : "";
                String str3 = str2;
                for (Map.Entry<String, ?> entry : map.entrySet()) {
                    this.out.write(str3);
                    String str4 = z ? ",\n" : ", ";
                    if (z) {
                        indent();
                    }
                    this.out.write(entry.getKey());
                    this.out.write(" = ");
                    emitAnnotationValue(entry.getValue());
                    str3 = str4;
                }
                popScope(Scope.ANNOTATION_ATTRIBUTE);
                if (z) {
                    this.out.write(IOUtils.LINE_SEPARATOR_UNIX);
                    indent();
                }
                this.out.write(")");
                break;
        }
        this.out.write(IOUtils.LINE_SEPARATOR_UNIX);
        return this;
    }

    private boolean containsArray(Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            if (it.next() instanceof Object[]) {
                return true;
            }
        }
        return false;
    }

    private JavaWriter emitAnnotationValue(Object obj) {
        Object[] objArr;
        if (obj instanceof Object[]) {
            this.out.write("{");
            boolean z = true;
            this.scopes.push(Scope.ANNOTATION_ARRAY_VALUE);
            for (Object obj2 : (Object[]) obj) {
                if (z) {
                    this.out.write(IOUtils.LINE_SEPARATOR_UNIX);
                    z = false;
                } else {
                    this.out.write(",\n");
                }
                indent();
                this.out.write(obj2.toString());
            }
            popScope(Scope.ANNOTATION_ARRAY_VALUE);
            this.out.write(IOUtils.LINE_SEPARATOR_UNIX);
            indent();
            this.out.write("}");
        } else {
            this.out.write(obj.toString());
        }
        return this;
    }

    public JavaWriter emitStatement(String str, Object... objArr) {
        checkInMethod();
        String[] split = String.format(str, objArr).split(IOUtils.LINE_SEPARATOR_UNIX, -1);
        indent();
        this.out.write(split[0]);
        for (int i = 1; i < split.length; i++) {
            this.out.write(IOUtils.LINE_SEPARATOR_UNIX);
            hangingIndent();
            this.out.write(split[i]);
        }
        this.out.write(";\n");
        return this;
    }

    public JavaWriter beginControlFlow(String str) {
        checkInMethod();
        indent();
        this.out.write(str);
        this.out.write(" {\n");
        this.scopes.push(Scope.CONTROL_FLOW);
        return this;
    }

    public JavaWriter nextControlFlow(String str) {
        popScope(Scope.CONTROL_FLOW);
        indent();
        this.scopes.push(Scope.CONTROL_FLOW);
        this.out.write("} ");
        this.out.write(str);
        this.out.write(" {\n");
        return this;
    }

    public JavaWriter endControlFlow() {
        return endControlFlow(null);
    }

    public JavaWriter endControlFlow(String str) {
        popScope(Scope.CONTROL_FLOW);
        indent();
        if (str != null) {
            this.out.write("} ");
            this.out.write(str);
            this.out.write(";\n");
        } else {
            this.out.write("}\n");
        }
        return this;
    }

    public JavaWriter endMethod() {
        Scope pop = this.scopes.pop();
        if (pop == Scope.NON_ABSTRACT_METHOD || pop == Scope.CONSTRUCTOR) {
            indent();
            this.out.write("}\n");
        } else if (pop != Scope.ABSTRACT_METHOD) {
            throw new IllegalStateException();
        }
        return this;
    }

    public JavaWriter endConstructor() {
        popScope(Scope.CONSTRUCTOR);
        indent();
        this.out.write("}\n");
        return this;
    }

    public static String stringLiteral(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append('\"');
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            switch (charAt) {
                case '\b':
                    sb.append("\\b");
                    break;
                case '\t':
                    sb.append("\\t");
                    break;
                case '\n':
                    sb.append("\\n");
                    break;
                case '\f':
                    sb.append("\\f");
                    break;
                case '\r':
                    sb.append("\\r");
                    break;
                case '\"':
                    sb.append("\\\"");
                    break;
                case '\\':
                    sb.append("\\\\");
                    break;
                default:
                    if (Character.isISOControl(charAt)) {
                        sb.append(String.format("\\u%04x", Integer.valueOf(charAt)));
                        break;
                    } else {
                        sb.append(charAt);
                        break;
                    }
            }
        }
        sb.append('\"');
        return sb.toString();
    }

    public static String type(Class<?> cls, String... strArr) {
        if (strArr.length == 0) {
            return cls.getCanonicalName();
        }
        if (cls.getTypeParameters().length != strArr.length) {
            throw new IllegalArgumentException();
        }
        StringBuilder sb = new StringBuilder();
        sb.append(cls.getCanonicalName());
        sb.append("<");
        sb.append(strArr[0]);
        for (int i = 1; i < strArr.length; i++) {
            sb.append(", ");
            sb.append(strArr[i]);
        }
        sb.append(">");
        return sb.toString();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.out.close();
    }

    private void emitModifiers(Set<Modifier> set) {
        if (!(set instanceof EnumSet)) {
            set = EnumSet.copyOf((Collection) set);
        }
        for (Modifier modifier : set) {
            this.out.append((CharSequence) modifier.toString()).append(' ');
        }
    }

    private void indent() {
        int size = this.scopes.size();
        for (int i = 0; i < size; i++) {
            this.out.write(this.indent);
        }
    }

    private void hangingIndent() {
        int size = this.scopes.size() + 2;
        for (int i = 0; i < size; i++) {
            this.out.write(this.indent);
        }
    }

    private void checkInMethod() {
        if (!METHOD_SCOPES.contains(this.scopes.peekFirst())) {
            throw new IllegalArgumentException();
        }
    }

    private void popScope(Scope scope) {
        if (this.scopes.pop() != scope) {
            throw new IllegalStateException();
        }
    }
}

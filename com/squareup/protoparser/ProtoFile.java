package com.squareup.protoparser;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public final class ProtoFile {
    private final List<String> dependencies;
    private final List<ExtendDeclaration> extendDeclarations;
    private final String fileName;
    private final Map<String, Object> options;
    private final String packageName;
    private final List<Service> services;
    private final List<Type> types;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ProtoFile(String str, String str2, List<String> list, List<Type> list2, List<Service> list3, Map<String, Object> map, List<ExtendDeclaration> list4) {
        if (str == null) {
            throw new NullPointerException("fileName");
        }
        if (list == null) {
            throw new NullPointerException("dependencies");
        }
        if (list2 == null) {
            throw new NullPointerException("types");
        }
        if (list3 == null) {
            throw new NullPointerException("services");
        }
        if (map == null) {
            throw new NullPointerException("options");
        }
        if (list4 == null) {
            throw new NullPointerException("extendDeclarations");
        }
        this.fileName = str;
        this.packageName = str2;
        this.dependencies = Collections.unmodifiableList(new ArrayList(list));
        this.types = Collections.unmodifiableList(new ArrayList(list2));
        this.services = Collections.unmodifiableList(new ArrayList(list3));
        this.options = Collections.unmodifiableMap(new LinkedHashMap(map));
        this.extendDeclarations = Collections.unmodifiableList(new ArrayList(list4));
    }

    public String getJavaPackage() {
        Object obj = this.options.get("java_package");
        return obj != null ? (String) obj : this.packageName;
    }

    public String getFileName() {
        return this.fileName;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public List<String> getDependencies() {
        return this.dependencies;
    }

    public List<Type> getTypes() {
        return this.types;
    }

    public List<Service> getServices() {
        return this.services;
    }

    public Map<String, Object> getOptions() {
        return this.options;
    }

    public List<ExtendDeclaration> getExtendDeclarations() {
        return this.extendDeclarations;
    }

    public boolean equals(Object obj) {
        if (obj instanceof ProtoFile) {
            ProtoFile protoFile = (ProtoFile) obj;
            return eq(this.fileName, protoFile.fileName) && eq(this.packageName, protoFile.packageName) && eq(this.dependencies, protoFile.dependencies) && eq(this.types, protoFile.types) && eq(this.services, protoFile.services) && eq(this.options, protoFile.options) && eq(this.extendDeclarations, protoFile.extendDeclarations);
        }
        return false;
    }

    private static boolean eq(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public int hashCode() {
        return this.fileName.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("fileName: ").append(this.fileName).append('\n');
        sb.append("packageName: ").append(this.packageName).append('\n');
        for (Map.Entry<String, Object> entry : this.options.entrySet()) {
            sb.append("option ").append(entry.getKey()).append(" = ").append(entry.getValue()).append('\n');
        }
        for (String str : this.dependencies) {
            sb.append("import ").append(str).append('\n');
        }
        for (Type type : this.types) {
            sb.append(type).append('\n');
        }
        for (Service service : this.services) {
            sb.append(service).append('\n');
        }
        for (ExtendDeclaration extendDeclaration : this.extendDeclarations) {
            sb.append(extendDeclaration).append('\n');
        }
        return sb.toString();
    }
}

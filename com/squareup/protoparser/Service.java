package com.squareup.protoparser;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes.dex */
public final class Service {
    private final String documentation;
    private final List<Method> methods;
    private final String name;

    /* JADX INFO: Access modifiers changed from: package-private */
    public Service(String str, String str2, List<Method> list) {
        if (str == null) {
            throw new NullPointerException("name");
        }
        if (str2 == null) {
            throw new NullPointerException("documentation");
        }
        if (list == null) {
            throw new NullPointerException("methods");
        }
        this.name = str;
        this.documentation = str2;
        this.methods = Collections.unmodifiableList(new ArrayList(list));
    }

    public String getName() {
        return this.name;
    }

    public String getDocumentation() {
        return this.documentation;
    }

    public List<Method> getMethods() {
        return this.methods;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Service) {
            Service service = (Service) obj;
            return this.name.equals(service.name) && this.documentation.equals(service.documentation) && this.methods.equals(service.methods);
        }
        return false;
    }

    public int hashCode() {
        return this.name.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.name);
        for (Method method : this.methods) {
            sb.append("\n  ").append(method);
        }
        return sb.toString();
    }

    /* loaded from: classes.dex */
    public final class Method {
        private final String documentation;
        private final String name;
        private final Map<String, Object> options;
        private final String requestType;
        private final String responseType;

        public Method(String str, String str2, String str3, String str4, Map<String, Object> map) {
            if (str == null) {
                throw new NullPointerException("name");
            }
            if (str2 == null) {
                throw new NullPointerException("documentation");
            }
            if (str3 == null) {
                throw new NullPointerException("requestType");
            }
            if (str4 == null) {
                throw new NullPointerException("responseType");
            }
            if (map == null) {
                throw new NullPointerException("options");
            }
            this.name = str;
            this.documentation = str2;
            this.requestType = str3;
            this.responseType = str4;
            this.options = Collections.unmodifiableMap(new LinkedHashMap(map));
        }

        public String getName() {
            return this.name;
        }

        public String getDocumentation() {
            return this.documentation;
        }

        public String getRequestType() {
            return this.requestType;
        }

        public String getResponseType() {
            return this.responseType;
        }

        public Map<String, Object> getOptions() {
            return this.options;
        }

        public boolean equals(Object obj) {
            if (obj instanceof Method) {
                Method method = (Method) obj;
                return this.name.equals(method.name) && this.documentation.equals(method.documentation) && this.requestType.equals(method.requestType) && this.responseType.equals(method.responseType) && this.options.equals(method.options);
            }
            return false;
        }

        public int hashCode() {
            return this.name.hashCode();
        }

        public String toString() {
            return String.format("rpc %s (%s) returns (%s) %s", this.name, this.requestType, this.responseType, this.options);
        }
    }
}

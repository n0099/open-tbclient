package com.squareup.protoparser;
/* loaded from: classes.dex */
public final class Option {
    private final String name;
    private final Object value;

    public Option(String str, Object obj) {
        if (str == null) {
            throw new NullPointerException("name");
        }
        if (obj == null) {
            throw new NullPointerException("value");
        }
        this.name = str;
        this.value = obj;
    }

    public String getName() {
        return this.name;
    }

    public Object getValue() {
        return this.value;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Option) {
            Option option = (Option) obj;
            return this.name.equals(option.name) && this.value.equals(option.value);
        }
        return false;
    }

    public int hashCode() {
        return this.name.hashCode() + (this.value.hashCode() * 37);
    }

    public String toString() {
        return String.format("%s=%s", this.name, this.value);
    }
}

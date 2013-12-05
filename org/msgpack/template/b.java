package org.msgpack.template;
/* loaded from: classes.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private String f3099a;
    private FieldOption b;

    public b() {
        this(null, FieldOption.IGNORE);
    }

    public b(String str, FieldOption fieldOption) {
        this.f3099a = str;
        this.b = fieldOption;
    }

    public String a() {
        return this.f3099a;
    }

    public FieldOption b() {
        return this.b;
    }

    public boolean c() {
        return this.b != FieldOption.IGNORE;
    }
}

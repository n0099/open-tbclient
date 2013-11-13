package org.msgpack.template;
/* loaded from: classes.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private String f2934a;
    private FieldOption b;

    public b() {
        this(null, FieldOption.IGNORE);
    }

    public b(String str, FieldOption fieldOption) {
        this.f2934a = str;
        this.b = fieldOption;
    }

    public String a() {
        return this.f2934a;
    }

    public FieldOption b() {
        return this.b;
    }

    public boolean c() {
        return this.b != FieldOption.IGNORE;
    }
}

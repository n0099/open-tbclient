package javassist.bytecode.analysis;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/* loaded from: classes.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    private List f2938a = new ArrayList();
    private Set b = new HashSet();
    private int c;

    public g(int i, int i2) {
        this.c = i;
        this.f2938a.add(new Integer(i2));
    }

    public void a(int i) {
        this.f2938a.add(new Integer(i));
    }

    public void b(int i) {
        this.b.add(new Integer(i));
    }

    public boolean c(int i) {
        return this.b.contains(new Integer(i));
    }

    public Collection a() {
        return this.b;
    }

    public Collection b() {
        return this.f2938a;
    }

    public String toString() {
        return "start = " + this.c + " callers = " + this.f2938a.toString();
    }
}

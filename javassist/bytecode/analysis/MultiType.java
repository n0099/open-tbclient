package javassist.bytecode.analysis;

import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class MultiType extends h {
    private Map r;
    private h s;
    private h t;
    private MultiType u;
    private boolean v;

    public MultiType(Map map) {
        this(map, null);
    }

    public MultiType(Map map, h hVar) {
        super(null);
        this.v = false;
        this.r = map;
        this.t = hVar;
    }

    @Override // javassist.bytecode.analysis.h
    public javassist.h a() {
        return this.s != null ? this.s.a() : h.n.a();
    }

    @Override // javassist.bytecode.analysis.h
    public h d() {
        return null;
    }

    @Override // javassist.bytecode.analysis.h
    public int e() {
        return 1;
    }

    @Override // javassist.bytecode.analysis.h
    public boolean f() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // javassist.bytecode.analysis.h
    public boolean b() {
        boolean z = this.v;
        this.v = false;
        return z;
    }

    @Override // javassist.bytecode.analysis.h
    public boolean a(h hVar) {
        throw new UnsupportedOperationException("Not implemented");
    }

    public boolean b(h hVar) {
        if (this.s != null) {
            return hVar.a(this.s);
        }
        if (h.n.equals(hVar)) {
            return true;
        }
        if (this.t != null && !hVar.a(this.t)) {
            this.t = null;
        }
        Map a2 = a(this, hVar);
        if (a2.size() == 1 && this.t == null) {
            this.s = h.a((javassist.h) a2.values().iterator().next());
            i();
            return true;
        } else if (a2.size() >= 1) {
            this.r = a2;
            h();
            return true;
        } else if (this.t != null) {
            this.s = this.t;
            i();
            return true;
        } else {
            return false;
        }
    }

    private void h() {
        for (MultiType multiType = this.u; multiType != null; multiType = multiType.u) {
            multiType.r = this.r;
            multiType.t = this.t;
        }
    }

    private void i() {
        for (MultiType multiType = this.u; multiType != null; multiType = multiType.u) {
            multiType.s = this.s;
        }
    }

    @Override // javassist.bytecode.analysis.h
    public boolean g() {
        return true;
    }

    private Map a(MultiType multiType) {
        HashMap hashMap = new HashMap();
        for (javassist.h hVar : multiType.r.values()) {
            hashMap.put(hVar.n(), hVar);
            a(hVar, hashMap);
        }
        return hashMap;
    }

    private Map a(MultiType multiType, MultiType multiType2) {
        return a(a(multiType), a(multiType2));
    }

    private Map a(MultiType multiType, h hVar) {
        return a(a(multiType), a(hVar.a(), (Map) null));
    }

    private boolean b(MultiType multiType) {
        while (multiType != null) {
            if (multiType == this) {
                return true;
            }
            multiType = multiType.u;
        }
        return false;
    }

    @Override // javassist.bytecode.analysis.h
    public h c(h hVar) {
        Map a2;
        if (this != hVar && hVar != j) {
            if (hVar == m) {
                return m;
            }
            if (hVar != null) {
                if (this.s != null) {
                    return this.s.c(hVar);
                }
                if (this.t != null) {
                    h c = this.t.c(hVar);
                    if (!c.equals(this.t) || c.b()) {
                        if (h.n.equals(c)) {
                            c = null;
                        }
                        this.t = c;
                        this.v = true;
                    }
                }
                if (hVar instanceof MultiType) {
                    MultiType multiType = (MultiType) hVar;
                    if (multiType.s != null) {
                        a2 = a(this, multiType.s);
                    } else {
                        a2 = a(multiType, this);
                        if (!b(multiType)) {
                            this.u = multiType;
                        }
                    }
                } else {
                    a2 = a(this, hVar);
                }
                if (a2.size() > 1 || (a2.size() == 1 && this.t != null)) {
                    if (a2.size() != this.r.size()) {
                        this.v = true;
                    } else if (!this.v) {
                        for (Object obj : a2.keySet()) {
                            if (!this.r.containsKey(obj)) {
                                this.v = true;
                            }
                        }
                    }
                    this.r = a2;
                    h();
                    return this;
                }
                if (a2.size() == 1) {
                    this.s = h.a((javassist.h) a2.values().iterator().next());
                } else if (this.t != null) {
                    this.s = this.t;
                } else {
                    this.s = n;
                }
                i();
                return this.s;
            }
            return this;
        }
        return this;
    }

    @Override // javassist.bytecode.analysis.h
    public boolean equals(Object obj) {
        if (obj instanceof MultiType) {
            MultiType multiType = (MultiType) obj;
            if (this.s != null) {
                return this.s.equals(multiType.s);
            }
            if (multiType.s == null) {
                return this.r.keySet().equals(multiType.r.keySet());
            }
            return false;
        }
        return false;
    }

    @Override // javassist.bytecode.analysis.h
    public String toString() {
        if (this.s != null) {
            return this.s.toString();
        }
        StringBuffer stringBuffer = new StringBuffer("{");
        for (Object obj : this.r.keySet()) {
            stringBuffer.append(obj);
            stringBuffer.append(", ");
        }
        stringBuffer.setLength(stringBuffer.length() - 2);
        if (this.t != null) {
            stringBuffer.append(", *").append(this.t.toString());
        }
        stringBuffer.append("}");
        return stringBuffer.toString();
    }
}

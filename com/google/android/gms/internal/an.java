package com.google.android.gms.internal;

import android.os.Parcel;
import java.util.ArrayList;
import java.util.HashMap;
/* loaded from: classes.dex */
public abstract class an {

    /* loaded from: classes.dex */
    public class a implements ae {
        public static final ao i = new ao();
        protected final int a;
        protected final boolean b;
        protected final int c;
        protected final boolean d;
        protected final String e;
        protected final int f;
        protected final Class g;
        protected final String h;
        private final int j;
        private aq k;
        private b l;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(int i2, int i3, boolean z, int i4, boolean z2, String str, int i5, String str2, ai aiVar) {
            this.j = i2;
            this.a = i3;
            this.b = z;
            this.c = i4;
            this.d = z2;
            this.e = str;
            this.f = i5;
            if (str2 == null) {
                this.g = null;
                this.h = null;
            } else {
                this.g = at.class;
                this.h = str2;
            }
            if (aiVar == null) {
                this.l = null;
            } else {
                this.l = aiVar.c();
            }
        }

        protected a(int i2, boolean z, int i3, boolean z2, String str, int i4, Class cls, b bVar) {
            this.j = 1;
            this.a = i2;
            this.b = z;
            this.c = i3;
            this.d = z2;
            this.e = str;
            this.f = i4;
            this.g = cls;
            if (cls == null) {
                this.h = null;
            } else {
                this.h = cls.getCanonicalName();
            }
            this.l = bVar;
        }

        public static a a(String str, int i2) {
            return new a(0, false, 0, false, str, i2, null, null);
        }

        public static a a(String str, int i2, b bVar, boolean z) {
            return new a(bVar.c(), z, bVar.d(), false, str, i2, null, bVar);
        }

        public static a a(String str, int i2, Class cls) {
            return new a(11, false, 11, false, str, i2, cls, null);
        }

        public static a b(String str, int i2) {
            return new a(4, false, 4, false, str, i2, null, null);
        }

        public static a b(String str, int i2, Class cls) {
            return new a(11, true, 11, true, str, i2, cls, null);
        }

        public static a c(String str, int i2) {
            return new a(6, false, 6, false, str, i2, null, null);
        }

        public static a d(String str, int i2) {
            return new a(7, false, 7, false, str, i2, null, null);
        }

        public static a e(String str, int i2) {
            return new a(7, true, 7, true, str, i2, null, null);
        }

        public int a() {
            return this.j;
        }

        public Object a(Object obj) {
            return this.l.a(obj);
        }

        public void a(aq aqVar) {
            this.k = aqVar;
        }

        public int b() {
            return this.a;
        }

        public boolean c() {
            return this.b;
        }

        public int d() {
            return this.c;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            ao aoVar = i;
            return 0;
        }

        public boolean e() {
            return this.d;
        }

        public String f() {
            return this.e;
        }

        public int g() {
            return this.f;
        }

        public Class h() {
            return this.g;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public String i() {
            if (this.h == null) {
                return null;
            }
            return this.h;
        }

        public boolean j() {
            return this.l != null;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public ai k() {
            if (this.l == null) {
                return null;
            }
            return ai.a(this.l);
        }

        public HashMap l() {
            x.a(this.h);
            x.a(this.k);
            return this.k.a(this.h);
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("Field\n");
            sb.append("            versionCode=").append(this.j).append('\n');
            sb.append("                 typeIn=").append(this.a).append('\n');
            sb.append("            typeInArray=").append(this.b).append('\n');
            sb.append("                typeOut=").append(this.c).append('\n');
            sb.append("           typeOutArray=").append(this.d).append('\n');
            sb.append("        outputFieldName=").append(this.e).append('\n');
            sb.append("      safeParcelFieldId=").append(this.f).append('\n');
            sb.append("       concreteTypeName=").append(i()).append('\n');
            if (h() != null) {
                sb.append("     concreteType.class=").append(h().getCanonicalName()).append('\n');
            }
            sb.append("          converterName=").append(this.l == null ? "null" : this.l.getClass().getCanonicalName()).append('\n');
            return sb.toString();
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            ao aoVar = i;
            ao.a(this, parcel, i2);
        }
    }

    /* loaded from: classes.dex */
    public interface b {
        Object a(Object obj);

        int c();

        int d();
    }

    private void a(StringBuilder sb, a aVar, Object obj) {
        if (aVar.b() == 11) {
            sb.append(((an) aVar.h().cast(obj)).toString());
        } else if (aVar.b() != 7) {
            sb.append(obj);
        } else {
            sb.append("\"");
            sb.append(ay.a((String) obj));
            sb.append("\"");
        }
    }

    private void a(StringBuilder sb, a aVar, ArrayList arrayList) {
        sb.append("[");
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                sb.append(",");
            }
            Object obj = arrayList.get(i);
            if (obj != null) {
                a(sb, aVar, obj);
            }
        }
        sb.append("]");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Object a(a aVar, Object obj) {
        return aVar.l != null ? aVar.a(obj) : obj;
    }

    protected abstract Object a(String str);

    public abstract HashMap a();

    protected boolean a(a aVar) {
        return aVar.d() == 11 ? aVar.e() ? d(aVar.f()) : c(aVar.f()) : b(aVar.f());
    }

    protected Object b(a aVar) {
        String f = aVar.f();
        if (aVar.h() != null) {
            x.a(a(aVar.f()) == null, "Concrete field shouldn't be value object: " + aVar.f());
            HashMap c = aVar.e() ? c() : b();
            if (c != null) {
                return c.get(f);
            }
            try {
                return getClass().getMethod("get" + Character.toUpperCase(f.charAt(0)) + f.substring(1), new Class[0]).invoke(this, new Object[0]);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return a(aVar.f());
    }

    public HashMap b() {
        return null;
    }

    protected abstract boolean b(String str);

    public HashMap c() {
        return null;
    }

    protected boolean c(String str) {
        throw new UnsupportedOperationException("Concrete types not supported");
    }

    protected boolean d(String str) {
        throw new UnsupportedOperationException("Concrete type arrays not supported");
    }

    public String toString() {
        HashMap a2 = a();
        StringBuilder sb = new StringBuilder(100);
        for (String str : a2.keySet()) {
            a aVar = (a) a2.get(str);
            if (a(aVar)) {
                Object a3 = a(aVar, b(aVar));
                if (sb.length() == 0) {
                    sb.append("{");
                } else {
                    sb.append(",");
                }
                sb.append("\"").append(str).append("\":");
                if (a3 == null) {
                    sb.append("null");
                } else {
                    switch (aVar.d()) {
                        case 8:
                            sb.append("\"").append(aw.a((byte[]) a3)).append("\"");
                            continue;
                        case 9:
                            sb.append("\"").append(aw.b((byte[]) a3)).append("\"");
                            continue;
                        case 10:
                            az.a(sb, (HashMap) a3);
                            continue;
                        default:
                            if (aVar.c()) {
                                a(sb, aVar, (ArrayList) a3);
                                break;
                            } else {
                                a(sb, aVar, a3);
                                continue;
                            }
                    }
                }
            }
        }
        if (sb.length() > 0) {
            sb.append("}");
        } else {
            sb.append("{}");
        }
        return sb.toString();
    }
}

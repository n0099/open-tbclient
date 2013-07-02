package com.google.android.gms.internal;

import android.os.Parcel;
import com.baidu.zeus.Headers;
import com.baidu.zeus.bouncycastle.DERTags;
import com.google.android.gms.internal.an;
import com.google.android.gms.plus.model.people.Person;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
/* loaded from: classes.dex */
public final class eq extends an implements ae, Person {
    public static final er a = new er();
    private static final HashMap b = new HashMap();
    private int A;
    private String B;
    private String C;
    private List D;
    private boolean E;
    private final Set c;
    private final int d;
    private String e;
    private a f;
    private String g;
    private String h;
    private int i;
    private b j;
    private String k;
    private String l;
    private List m;
    private String n;
    private int o;
    private boolean p;
    private String q;
    private d r;
    private boolean s;
    private String t;
    private e u;
    private String v;
    private int w;
    private List x;
    private List y;
    private int z;

    /* loaded from: classes.dex */
    public final class a extends an implements ae, Person.AgeRange {
        public static final ei a = new ei();
        private static final HashMap b = new HashMap();
        private final Set c;
        private final int d;
        private int e;
        private int f;

        static {
            b.put("max", an.a.a("max", 2));
            b.put("min", an.a.a("min", 3));
        }

        public a() {
            this.d = 1;
            this.c = new HashSet();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(Set set, int i, int i2, int i3) {
            this.c = set;
            this.d = i;
            this.e = i2;
            this.f = i3;
        }

        @Override // com.google.android.gms.internal.an
        protected Object a(String str) {
            return null;
        }

        @Override // com.google.android.gms.internal.an
        public HashMap a() {
            return b;
        }

        @Override // com.google.android.gms.internal.an
        protected boolean a(an.a aVar) {
            return this.c.contains(Integer.valueOf(aVar.g()));
        }

        @Override // com.google.android.gms.internal.an
        protected Object b(an.a aVar) {
            switch (aVar.g()) {
                case 2:
                    return Integer.valueOf(this.e);
                case 3:
                    return Integer.valueOf(this.f);
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + aVar.g());
            }
        }

        @Override // com.google.android.gms.internal.an
        protected boolean b(String str) {
            return false;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Set d() {
            return this.c;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            ei eiVar = a;
            return 0;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public int e() {
            return this.d;
        }

        public int f() {
            return this.e;
        }

        public int h() {
            return this.f;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.android.gms.common.data.Freezable
        /* renamed from: i */
        public a g() {
            return this;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            ei eiVar = a;
            ei.a(this, parcel, i);
        }
    }

    /* loaded from: classes.dex */
    public final class b extends an implements ae, Person.Cover {
        public static final ej a = new ej();
        private static final HashMap b = new HashMap();
        private final Set c;
        private final int d;
        private a e;
        private C0034b f;
        private int g;

        /* loaded from: classes.dex */
        public final class a extends an implements ae, Person.Cover.CoverInfo {
            public static final ek a = new ek();
            private static final HashMap b = new HashMap();
            private final Set c;
            private final int d;
            private int e;
            private int f;

            static {
                b.put("leftImageOffset", an.a.a("leftImageOffset", 2));
                b.put("topImageOffset", an.a.a("topImageOffset", 3));
            }

            public a() {
                this.d = 1;
                this.c = new HashSet();
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            public a(Set set, int i, int i2, int i3) {
                this.c = set;
                this.d = i;
                this.e = i2;
                this.f = i3;
            }

            @Override // com.google.android.gms.internal.an
            protected Object a(String str) {
                return null;
            }

            @Override // com.google.android.gms.internal.an
            public HashMap a() {
                return b;
            }

            @Override // com.google.android.gms.internal.an
            protected boolean a(an.a aVar) {
                return this.c.contains(Integer.valueOf(aVar.g()));
            }

            @Override // com.google.android.gms.internal.an
            protected Object b(an.a aVar) {
                switch (aVar.g()) {
                    case 2:
                        return Integer.valueOf(this.e);
                    case 3:
                        return Integer.valueOf(this.f);
                    default:
                        throw new IllegalStateException("Unknown safe parcelable id=" + aVar.g());
                }
            }

            @Override // com.google.android.gms.internal.an
            protected boolean b(String str) {
                return false;
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            public Set d() {
                return this.c;
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                ek ekVar = a;
                return 0;
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            public int e() {
                return this.d;
            }

            public boolean equals(Object obj) {
                if (obj instanceof a) {
                    if (this == obj) {
                        return true;
                    }
                    a aVar = (a) obj;
                    for (an.a aVar2 : b.values()) {
                        if (a(aVar2)) {
                            if (aVar.a(aVar2) && b(aVar2).equals(aVar.b(aVar2))) {
                            }
                            return false;
                        } else if (aVar.a(aVar2)) {
                            return false;
                        }
                    }
                    return true;
                }
                return false;
            }

            public int f() {
                return this.e;
            }

            public int h() {
                return this.f;
            }

            public int hashCode() {
                int i = 0;
                Iterator it = b.values().iterator();
                while (true) {
                    int i2 = i;
                    if (!it.hasNext()) {
                        return i2;
                    }
                    an.a aVar = (an.a) it.next();
                    if (a(aVar)) {
                        i = b(aVar).hashCode() + i2 + aVar.g();
                    } else {
                        i = i2;
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.android.gms.common.data.Freezable
            /* renamed from: i */
            public a g() {
                return this;
            }

            @Override // android.os.Parcelable
            public void writeToParcel(Parcel parcel, int i) {
                ek ekVar = a;
                ek.a(this, parcel, i);
            }
        }

        /* renamed from: com.google.android.gms.internal.eq$b$b  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public final class C0034b extends an implements ae, Person.Cover.CoverPhoto {
            public static final el a = new el();
            private static final HashMap b = new HashMap();
            private final Set c;
            private final int d;
            private int e;
            private String f;
            private int g;

            static {
                b.put("height", an.a.a("height", 2));
                b.put("url", an.a.d("url", 3));
                b.put("width", an.a.a("width", 4));
            }

            public C0034b() {
                this.d = 1;
                this.c = new HashSet();
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            public C0034b(Set set, int i, int i2, String str, int i3) {
                this.c = set;
                this.d = i;
                this.e = i2;
                this.f = str;
                this.g = i3;
            }

            @Override // com.google.android.gms.internal.an
            protected Object a(String str) {
                return null;
            }

            @Override // com.google.android.gms.internal.an
            public HashMap a() {
                return b;
            }

            @Override // com.google.android.gms.internal.an
            protected boolean a(an.a aVar) {
                return this.c.contains(Integer.valueOf(aVar.g()));
            }

            @Override // com.google.android.gms.internal.an
            protected Object b(an.a aVar) {
                switch (aVar.g()) {
                    case 2:
                        return Integer.valueOf(this.e);
                    case 3:
                        return this.f;
                    case 4:
                        return Integer.valueOf(this.g);
                    default:
                        throw new IllegalStateException("Unknown safe parcelable id=" + aVar.g());
                }
            }

            @Override // com.google.android.gms.internal.an
            protected boolean b(String str) {
                return false;
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            public Set d() {
                return this.c;
            }

            @Override // android.os.Parcelable
            public int describeContents() {
                el elVar = a;
                return 0;
            }

            /* JADX INFO: Access modifiers changed from: package-private */
            public int e() {
                return this.d;
            }

            public boolean equals(Object obj) {
                if (obj instanceof C0034b) {
                    if (this == obj) {
                        return true;
                    }
                    C0034b c0034b = (C0034b) obj;
                    for (an.a aVar : b.values()) {
                        if (a(aVar)) {
                            if (c0034b.a(aVar) && b(aVar).equals(c0034b.b(aVar))) {
                            }
                            return false;
                        } else if (c0034b.a(aVar)) {
                            return false;
                        }
                    }
                    return true;
                }
                return false;
            }

            public int f() {
                return this.e;
            }

            public String h() {
                return this.f;
            }

            public int hashCode() {
                int i = 0;
                Iterator it = b.values().iterator();
                while (true) {
                    int i2 = i;
                    if (!it.hasNext()) {
                        return i2;
                    }
                    an.a aVar = (an.a) it.next();
                    if (a(aVar)) {
                        i = b(aVar).hashCode() + i2 + aVar.g();
                    } else {
                        i = i2;
                    }
                }
            }

            public int i() {
                return this.g;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.android.gms.common.data.Freezable
            /* renamed from: j */
            public C0034b g() {
                return this;
            }

            @Override // android.os.Parcelable
            public void writeToParcel(Parcel parcel, int i) {
                el elVar = a;
                el.a(this, parcel, i);
            }
        }

        static {
            b.put("coverInfo", an.a.a("coverInfo", 2, a.class));
            b.put("coverPhoto", an.a.a("coverPhoto", 3, C0034b.class));
            b.put("layout", an.a.a("layout", 4, new ak().a("banner", 0), false));
        }

        public b() {
            this.d = 1;
            this.c = new HashSet();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public b(Set set, int i, a aVar, C0034b c0034b, int i2) {
            this.c = set;
            this.d = i;
            this.e = aVar;
            this.f = c0034b;
            this.g = i2;
        }

        @Override // com.google.android.gms.internal.an
        protected Object a(String str) {
            return null;
        }

        @Override // com.google.android.gms.internal.an
        public HashMap a() {
            return b;
        }

        @Override // com.google.android.gms.internal.an
        protected boolean a(an.a aVar) {
            return this.c.contains(Integer.valueOf(aVar.g()));
        }

        @Override // com.google.android.gms.internal.an
        protected Object b(an.a aVar) {
            switch (aVar.g()) {
                case 2:
                    return this.e;
                case 3:
                    return this.f;
                case 4:
                    return Integer.valueOf(this.g);
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + aVar.g());
            }
        }

        @Override // com.google.android.gms.internal.an
        protected boolean b(String str) {
            return false;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Set d() {
            return this.c;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            ej ejVar = a;
            return 0;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public int e() {
            return this.d;
        }

        public boolean equals(Object obj) {
            if (obj instanceof b) {
                if (this == obj) {
                    return true;
                }
                b bVar = (b) obj;
                for (an.a aVar : b.values()) {
                    if (a(aVar)) {
                        if (bVar.a(aVar) && b(aVar).equals(bVar.b(aVar))) {
                        }
                        return false;
                    } else if (bVar.a(aVar)) {
                        return false;
                    }
                }
                return true;
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public a f() {
            return this.e;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public C0034b h() {
            return this.f;
        }

        public int hashCode() {
            int i = 0;
            Iterator it = b.values().iterator();
            while (true) {
                int i2 = i;
                if (!it.hasNext()) {
                    return i2;
                }
                an.a aVar = (an.a) it.next();
                if (a(aVar)) {
                    i = b(aVar).hashCode() + i2 + aVar.g();
                } else {
                    i = i2;
                }
            }
        }

        public int i() {
            return this.g;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.android.gms.common.data.Freezable
        /* renamed from: j */
        public b g() {
            return this;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            ej ejVar = a;
            ej.a(this, parcel, i);
        }
    }

    /* loaded from: classes.dex */
    public final class c extends an implements ae, Person.Emails {
        public static final em a = new em();
        private static final HashMap b = new HashMap();
        private final Set c;
        private final int d;
        private boolean e;
        private int f;
        private String g;

        static {
            b.put("primary", an.a.c("primary", 2));
            b.put("type", an.a.a("type", 3, new ak().a("home", 0).a("work", 1).a("other", 2), false));
            b.put("value", an.a.d("value", 4));
        }

        public c() {
            this.d = 1;
            this.c = new HashSet();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public c(Set set, int i, boolean z, int i2, String str) {
            this.c = set;
            this.d = i;
            this.e = z;
            this.f = i2;
            this.g = str;
        }

        @Override // com.google.android.gms.internal.an
        protected Object a(String str) {
            return null;
        }

        @Override // com.google.android.gms.internal.an
        public HashMap a() {
            return b;
        }

        @Override // com.google.android.gms.internal.an
        protected boolean a(an.a aVar) {
            return this.c.contains(Integer.valueOf(aVar.g()));
        }

        @Override // com.google.android.gms.internal.an
        protected Object b(an.a aVar) {
            switch (aVar.g()) {
                case 2:
                    return Boolean.valueOf(this.e);
                case 3:
                    return Integer.valueOf(this.f);
                case 4:
                    return this.g;
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + aVar.g());
            }
        }

        @Override // com.google.android.gms.internal.an
        protected boolean b(String str) {
            return false;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Set d() {
            return this.c;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            em emVar = a;
            return 0;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public int e() {
            return this.d;
        }

        public boolean equals(Object obj) {
            if (obj instanceof c) {
                if (this == obj) {
                    return true;
                }
                c cVar = (c) obj;
                for (an.a aVar : b.values()) {
                    if (a(aVar)) {
                        if (cVar.a(aVar) && b(aVar).equals(cVar.b(aVar))) {
                        }
                        return false;
                    } else if (cVar.a(aVar)) {
                        return false;
                    }
                }
                return true;
            }
            return false;
        }

        public boolean f() {
            return this.e;
        }

        public int h() {
            return this.f;
        }

        public int hashCode() {
            int i = 0;
            Iterator it = b.values().iterator();
            while (true) {
                int i2 = i;
                if (!it.hasNext()) {
                    return i2;
                }
                an.a aVar = (an.a) it.next();
                if (a(aVar)) {
                    i = b(aVar).hashCode() + i2 + aVar.g();
                } else {
                    i = i2;
                }
            }
        }

        public String i() {
            return this.g;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.android.gms.common.data.Freezable
        /* renamed from: j */
        public c g() {
            return this;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            em emVar = a;
            em.a(this, parcel, i);
        }
    }

    /* loaded from: classes.dex */
    public final class d extends an implements ae, Person.Image {
        public static final en a = new en();
        private static final HashMap b = new HashMap();
        private final Set c;
        private final int d;
        private String e;

        static {
            b.put("url", an.a.d("url", 2));
        }

        public d() {
            this.d = 1;
            this.c = new HashSet();
        }

        public d(String str) {
            this.c = new HashSet();
            this.d = 1;
            this.e = str;
            this.c.add(2);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public d(Set set, int i, String str) {
            this.c = set;
            this.d = i;
            this.e = str;
        }

        @Override // com.google.android.gms.internal.an
        protected Object a(String str) {
            return null;
        }

        @Override // com.google.android.gms.internal.an
        public HashMap a() {
            return b;
        }

        @Override // com.google.android.gms.internal.an
        protected boolean a(an.a aVar) {
            return this.c.contains(Integer.valueOf(aVar.g()));
        }

        @Override // com.google.android.gms.internal.an
        protected Object b(an.a aVar) {
            switch (aVar.g()) {
                case 2:
                    return this.e;
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + aVar.g());
            }
        }

        @Override // com.google.android.gms.internal.an
        protected boolean b(String str) {
            return false;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Set d() {
            return this.c;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            en enVar = a;
            return 0;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public int e() {
            return this.d;
        }

        public boolean equals(Object obj) {
            if (obj instanceof d) {
                if (this == obj) {
                    return true;
                }
                d dVar = (d) obj;
                for (an.a aVar : b.values()) {
                    if (a(aVar)) {
                        if (dVar.a(aVar) && b(aVar).equals(dVar.b(aVar))) {
                        }
                        return false;
                    } else if (dVar.a(aVar)) {
                        return false;
                    }
                }
                return true;
            }
            return false;
        }

        public String f() {
            return this.e;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.android.gms.common.data.Freezable
        /* renamed from: h */
        public d g() {
            return this;
        }

        public int hashCode() {
            int i = 0;
            Iterator it = b.values().iterator();
            while (true) {
                int i2 = i;
                if (!it.hasNext()) {
                    return i2;
                }
                an.a aVar = (an.a) it.next();
                if (a(aVar)) {
                    i = b(aVar).hashCode() + i2 + aVar.g();
                } else {
                    i = i2;
                }
            }
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            en enVar = a;
            en.a(this, parcel, i);
        }
    }

    /* loaded from: classes.dex */
    public final class e extends an implements ae, Person.Name {
        public static final eo a = new eo();
        private static final HashMap b = new HashMap();
        private final Set c;
        private final int d;
        private String e;
        private String f;
        private String g;
        private String h;
        private String i;
        private String j;

        static {
            b.put("familyName", an.a.d("familyName", 2));
            b.put("formatted", an.a.d("formatted", 3));
            b.put("givenName", an.a.d("givenName", 4));
            b.put("honorificPrefix", an.a.d("honorificPrefix", 5));
            b.put("honorificSuffix", an.a.d("honorificSuffix", 6));
            b.put("middleName", an.a.d("middleName", 7));
        }

        public e() {
            this.d = 1;
            this.c = new HashSet();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public e(Set set, int i, String str, String str2, String str3, String str4, String str5, String str6) {
            this.c = set;
            this.d = i;
            this.e = str;
            this.f = str2;
            this.g = str3;
            this.h = str4;
            this.i = str5;
            this.j = str6;
        }

        @Override // com.google.android.gms.internal.an
        protected Object a(String str) {
            return null;
        }

        @Override // com.google.android.gms.internal.an
        public HashMap a() {
            return b;
        }

        @Override // com.google.android.gms.internal.an
        protected boolean a(an.a aVar) {
            return this.c.contains(Integer.valueOf(aVar.g()));
        }

        @Override // com.google.android.gms.internal.an
        protected Object b(an.a aVar) {
            switch (aVar.g()) {
                case 2:
                    return this.e;
                case 3:
                    return this.f;
                case 4:
                    return this.g;
                case 5:
                    return this.h;
                case 6:
                    return this.i;
                case 7:
                    return this.j;
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + aVar.g());
            }
        }

        @Override // com.google.android.gms.internal.an
        protected boolean b(String str) {
            return false;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Set d() {
            return this.c;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            eo eoVar = a;
            return 0;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public int e() {
            return this.d;
        }

        public boolean equals(Object obj) {
            if (obj instanceof e) {
                if (this == obj) {
                    return true;
                }
                e eVar = (e) obj;
                for (an.a aVar : b.values()) {
                    if (a(aVar)) {
                        if (eVar.a(aVar) && b(aVar).equals(eVar.b(aVar))) {
                        }
                        return false;
                    } else if (eVar.a(aVar)) {
                        return false;
                    }
                }
                return true;
            }
            return false;
        }

        public String f() {
            return this.e;
        }

        public String h() {
            return this.f;
        }

        public int hashCode() {
            int i = 0;
            Iterator it = b.values().iterator();
            while (true) {
                int i2 = i;
                if (!it.hasNext()) {
                    return i2;
                }
                an.a aVar = (an.a) it.next();
                if (a(aVar)) {
                    i = b(aVar).hashCode() + i2 + aVar.g();
                } else {
                    i = i2;
                }
            }
        }

        public String i() {
            return this.g;
        }

        public String j() {
            return this.h;
        }

        public String k() {
            return this.i;
        }

        public String l() {
            return this.j;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.android.gms.common.data.Freezable
        /* renamed from: m */
        public e g() {
            return this;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            eo eoVar = a;
            eo.a(this, parcel, i);
        }
    }

    /* loaded from: classes.dex */
    public class f {
        public static int a(String str) {
            if (str.equals("person")) {
                return 0;
            }
            if (str.equals("page")) {
                return 1;
            }
            throw new IllegalArgumentException("Unknown objectType string: " + str);
        }
    }

    /* loaded from: classes.dex */
    public final class g extends an implements ae, Person.Organizations {
        public static final ep a = new ep();
        private static final HashMap b = new HashMap();
        private final Set c;
        private final int d;
        private String e;
        private String f;
        private String g;
        private String h;
        private String i;
        private boolean j;
        private String k;
        private String l;
        private int m;

        static {
            b.put("department", an.a.d("department", 2));
            b.put("description", an.a.d("description", 3));
            b.put("endDate", an.a.d("endDate", 4));
            b.put(Headers.LOCATION, an.a.d(Headers.LOCATION, 5));
            b.put("name", an.a.d("name", 6));
            b.put("primary", an.a.c("primary", 7));
            b.put("startDate", an.a.d("startDate", 8));
            b.put("title", an.a.d("title", 9));
            b.put("type", an.a.a("type", 10, new ak().a("work", 0).a("school", 1), false));
        }

        public g() {
            this.d = 1;
            this.c = new HashSet();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public g(Set set, int i, String str, String str2, String str3, String str4, String str5, boolean z, String str6, String str7, int i2) {
            this.c = set;
            this.d = i;
            this.e = str;
            this.f = str2;
            this.g = str3;
            this.h = str4;
            this.i = str5;
            this.j = z;
            this.k = str6;
            this.l = str7;
            this.m = i2;
        }

        @Override // com.google.android.gms.internal.an
        protected Object a(String str) {
            return null;
        }

        @Override // com.google.android.gms.internal.an
        public HashMap a() {
            return b;
        }

        @Override // com.google.android.gms.internal.an
        protected boolean a(an.a aVar) {
            return this.c.contains(Integer.valueOf(aVar.g()));
        }

        @Override // com.google.android.gms.internal.an
        protected Object b(an.a aVar) {
            switch (aVar.g()) {
                case 2:
                    return this.e;
                case 3:
                    return this.f;
                case 4:
                    return this.g;
                case 5:
                    return this.h;
                case 6:
                    return this.i;
                case 7:
                    return Boolean.valueOf(this.j);
                case 8:
                    return this.k;
                case 9:
                    return this.l;
                case 10:
                    return Integer.valueOf(this.m);
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + aVar.g());
            }
        }

        @Override // com.google.android.gms.internal.an
        protected boolean b(String str) {
            return false;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Set d() {
            return this.c;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            ep epVar = a;
            return 0;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public int e() {
            return this.d;
        }

        public boolean equals(Object obj) {
            if (obj instanceof g) {
                if (this == obj) {
                    return true;
                }
                g gVar = (g) obj;
                for (an.a aVar : b.values()) {
                    if (a(aVar)) {
                        if (gVar.a(aVar) && b(aVar).equals(gVar.b(aVar))) {
                        }
                        return false;
                    } else if (gVar.a(aVar)) {
                        return false;
                    }
                }
                return true;
            }
            return false;
        }

        public String f() {
            return this.e;
        }

        public String h() {
            return this.f;
        }

        public int hashCode() {
            int i = 0;
            Iterator it = b.values().iterator();
            while (true) {
                int i2 = i;
                if (!it.hasNext()) {
                    return i2;
                }
                an.a aVar = (an.a) it.next();
                if (a(aVar)) {
                    i = b(aVar).hashCode() + i2 + aVar.g();
                } else {
                    i = i2;
                }
            }
        }

        public String i() {
            return this.g;
        }

        public String j() {
            return this.h;
        }

        public String k() {
            return this.i;
        }

        public boolean l() {
            return this.j;
        }

        public String m() {
            return this.k;
        }

        public String n() {
            return this.l;
        }

        public int o() {
            return this.m;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.android.gms.common.data.Freezable
        /* renamed from: p */
        public g g() {
            return this;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            ep epVar = a;
            ep.a(this, parcel, i);
        }
    }

    /* loaded from: classes.dex */
    public final class h extends an implements ae, Person.PlacesLived {
        public static final et a = new et();
        private static final HashMap b = new HashMap();
        private final Set c;
        private final int d;
        private boolean e;
        private String f;

        static {
            b.put("primary", an.a.c("primary", 2));
            b.put("value", an.a.d("value", 3));
        }

        public h() {
            this.d = 1;
            this.c = new HashSet();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public h(Set set, int i, boolean z, String str) {
            this.c = set;
            this.d = i;
            this.e = z;
            this.f = str;
        }

        @Override // com.google.android.gms.internal.an
        protected Object a(String str) {
            return null;
        }

        @Override // com.google.android.gms.internal.an
        public HashMap a() {
            return b;
        }

        @Override // com.google.android.gms.internal.an
        protected boolean a(an.a aVar) {
            return this.c.contains(Integer.valueOf(aVar.g()));
        }

        @Override // com.google.android.gms.internal.an
        protected Object b(an.a aVar) {
            switch (aVar.g()) {
                case 2:
                    return Boolean.valueOf(this.e);
                case 3:
                    return this.f;
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + aVar.g());
            }
        }

        @Override // com.google.android.gms.internal.an
        protected boolean b(String str) {
            return false;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Set d() {
            return this.c;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            et etVar = a;
            return 0;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public int e() {
            return this.d;
        }

        public boolean equals(Object obj) {
            if (obj instanceof h) {
                if (this == obj) {
                    return true;
                }
                h hVar = (h) obj;
                for (an.a aVar : b.values()) {
                    if (a(aVar)) {
                        if (hVar.a(aVar) && b(aVar).equals(hVar.b(aVar))) {
                        }
                        return false;
                    } else if (hVar.a(aVar)) {
                        return false;
                    }
                }
                return true;
            }
            return false;
        }

        public boolean f() {
            return this.e;
        }

        public String h() {
            return this.f;
        }

        public int hashCode() {
            int i = 0;
            Iterator it = b.values().iterator();
            while (true) {
                int i2 = i;
                if (!it.hasNext()) {
                    return i2;
                }
                an.a aVar = (an.a) it.next();
                if (a(aVar)) {
                    i = b(aVar).hashCode() + i2 + aVar.g();
                } else {
                    i = i2;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.android.gms.common.data.Freezable
        /* renamed from: i */
        public h g() {
            return this;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            et etVar = a;
            et.a(this, parcel, i);
        }
    }

    /* loaded from: classes.dex */
    public final class i extends an implements ae, Person.Urls {
        public static final eu a = new eu();
        private static final HashMap b = new HashMap();
        private final Set c;
        private final int d;
        private boolean e;
        private int f;
        private String g;

        static {
            b.put("primary", an.a.c("primary", 2));
            b.put("type", an.a.a("type", 3, new ak().a("home", 0).a("work", 1).a("blog", 2).a("profile", 3).a("other", 4), false));
            b.put("value", an.a.d("value", 4));
        }

        public i() {
            this.d = 1;
            this.c = new HashSet();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public i(Set set, int i, boolean z, int i2, String str) {
            this.c = set;
            this.d = i;
            this.e = z;
            this.f = i2;
            this.g = str;
        }

        @Override // com.google.android.gms.internal.an
        protected Object a(String str) {
            return null;
        }

        @Override // com.google.android.gms.internal.an
        public HashMap a() {
            return b;
        }

        @Override // com.google.android.gms.internal.an
        protected boolean a(an.a aVar) {
            return this.c.contains(Integer.valueOf(aVar.g()));
        }

        @Override // com.google.android.gms.internal.an
        protected Object b(an.a aVar) {
            switch (aVar.g()) {
                case 2:
                    return Boolean.valueOf(this.e);
                case 3:
                    return Integer.valueOf(this.f);
                case 4:
                    return this.g;
                default:
                    throw new IllegalStateException("Unknown safe parcelable id=" + aVar.g());
            }
        }

        @Override // com.google.android.gms.internal.an
        protected boolean b(String str) {
            return false;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Set d() {
            return this.c;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            eu euVar = a;
            return 0;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public int e() {
            return this.d;
        }

        public boolean equals(Object obj) {
            if (obj instanceof i) {
                if (this == obj) {
                    return true;
                }
                i iVar = (i) obj;
                for (an.a aVar : b.values()) {
                    if (a(aVar)) {
                        if (iVar.a(aVar) && b(aVar).equals(iVar.b(aVar))) {
                        }
                        return false;
                    } else if (iVar.a(aVar)) {
                        return false;
                    }
                }
                return true;
            }
            return false;
        }

        public boolean f() {
            return this.e;
        }

        public int h() {
            return this.f;
        }

        public int hashCode() {
            int i = 0;
            Iterator it = b.values().iterator();
            while (true) {
                int i2 = i;
                if (!it.hasNext()) {
                    return i2;
                }
                an.a aVar = (an.a) it.next();
                if (a(aVar)) {
                    i = b(aVar).hashCode() + i2 + aVar.g();
                } else {
                    i = i2;
                }
            }
        }

        public String i() {
            return this.g;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.android.gms.common.data.Freezable
        /* renamed from: j */
        public i g() {
            return this;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            eu euVar = a;
            eu.a(this, parcel, i);
        }
    }

    static {
        b.put("aboutMe", an.a.d("aboutMe", 2));
        b.put("ageRange", an.a.a("ageRange", 3, a.class));
        b.put("birthday", an.a.d("birthday", 4));
        b.put("braggingRights", an.a.d("braggingRights", 5));
        b.put("circledByCount", an.a.a("circledByCount", 6));
        b.put("cover", an.a.a("cover", 7, b.class));
        b.put("currentLocation", an.a.d("currentLocation", 8));
        b.put("displayName", an.a.d("displayName", 9));
        b.put("emails", an.a.b("emails", 10, c.class));
        b.put(Headers.ETAG, an.a.d(Headers.ETAG, 11));
        b.put("gender", an.a.a("gender", 12, new ak().a("male", 0).a("female", 1).a("other", 2), false));
        b.put("hasApp", an.a.c("hasApp", 13));
        b.put("id", an.a.d("id", 14));
        b.put("image", an.a.a("image", 15, d.class));
        b.put("isPlusUser", an.a.c("isPlusUser", 16));
        b.put("language", an.a.d("language", 18));
        b.put("name", an.a.a("name", 19, e.class));
        b.put("nickname", an.a.d("nickname", 20));
        b.put("objectType", an.a.a("objectType", 21, new ak().a("person", 0).a("page", 1), false));
        b.put("organizations", an.a.b("organizations", 22, g.class));
        b.put("placesLived", an.a.b("placesLived", 23, h.class));
        b.put("plusOneCount", an.a.a("plusOneCount", 24));
        b.put("relationshipStatus", an.a.a("relationshipStatus", 25, new ak().a("single", 0).a("in_a_relationship", 1).a("engaged", 2).a("married", 3).a("its_complicated", 4).a("open_relationship", 5).a("widowed", 6).a("in_domestic_partnership", 7).a("in_civil_union", 8), false));
        b.put("tagline", an.a.d("tagline", 26));
        b.put("url", an.a.d("url", 27));
        b.put("urls", an.a.b("urls", 28, i.class));
        b.put("verified", an.a.c("verified", 29));
    }

    public eq() {
        this.d = 1;
        this.c = new HashSet();
    }

    public eq(String str, String str2, d dVar, int i2, String str3) {
        this.d = 1;
        this.c = new HashSet();
        this.l = str;
        this.c.add(9);
        this.q = str2;
        this.c.add(14);
        this.r = dVar;
        this.c.add(15);
        this.w = i2;
        this.c.add(21);
        this.C = str3;
        this.c.add(27);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public eq(Set set, int i2, String str, a aVar, String str2, String str3, int i3, b bVar, String str4, String str5, List list, String str6, int i4, boolean z, String str7, d dVar, boolean z2, String str8, e eVar, String str9, int i5, List list2, List list3, int i6, int i7, String str10, String str11, List list4, boolean z3) {
        this.c = set;
        this.d = i2;
        this.e = str;
        this.f = aVar;
        this.g = str2;
        this.h = str3;
        this.i = i3;
        this.j = bVar;
        this.k = str4;
        this.l = str5;
        this.m = list;
        this.n = str6;
        this.o = i4;
        this.p = z;
        this.q = str7;
        this.r = dVar;
        this.s = z2;
        this.t = str8;
        this.u = eVar;
        this.v = str9;
        this.w = i5;
        this.x = list2;
        this.y = list3;
        this.z = i6;
        this.A = i7;
        this.B = str10;
        this.C = str11;
        this.D = list4;
        this.E = z3;
    }

    public static eq a(byte[] bArr) {
        Parcel obtain = Parcel.obtain();
        obtain.unmarshall(bArr, 0, bArr.length);
        obtain.setDataPosition(0);
        eq createFromParcel = a.createFromParcel(obtain);
        obtain.recycle();
        return createFromParcel;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List A() {
        return this.y;
    }

    public int B() {
        return this.z;
    }

    public int C() {
        return this.A;
    }

    public String D() {
        return this.B;
    }

    public String E() {
        return this.C;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List F() {
        return this.D;
    }

    public boolean G() {
        return this.E;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.android.gms.common.data.Freezable
    /* renamed from: H */
    public eq g() {
        return this;
    }

    @Override // com.google.android.gms.internal.an
    protected Object a(String str) {
        return null;
    }

    @Override // com.google.android.gms.internal.an
    public HashMap a() {
        return b;
    }

    @Override // com.google.android.gms.internal.an
    protected boolean a(an.a aVar) {
        return this.c.contains(Integer.valueOf(aVar.g()));
    }

    @Override // com.google.android.gms.internal.an
    protected Object b(an.a aVar) {
        switch (aVar.g()) {
            case 2:
                return this.e;
            case 3:
                return this.f;
            case 4:
                return this.g;
            case 5:
                return this.h;
            case 6:
                return Integer.valueOf(this.i);
            case 7:
                return this.j;
            case 8:
                return this.k;
            case 9:
                return this.l;
            case 10:
                return this.m;
            case 11:
                return this.n;
            case 12:
                return Integer.valueOf(this.o);
            case 13:
                return Boolean.valueOf(this.p);
            case 14:
                return this.q;
            case 15:
                return this.r;
            case 16:
                return Boolean.valueOf(this.s);
            case 17:
            default:
                throw new IllegalStateException("Unknown safe parcelable id=" + aVar.g());
            case 18:
                return this.t;
            case 19:
                return this.u;
            case 20:
                return this.v;
            case 21:
                return Integer.valueOf(this.w);
            case DERTags.IA5_STRING /* 22 */:
                return this.x;
            case DERTags.UTC_TIME /* 23 */:
                return this.y;
            case DERTags.GENERALIZED_TIME /* 24 */:
                return Integer.valueOf(this.z);
            case DERTags.GRAPHIC_STRING /* 25 */:
                return Integer.valueOf(this.A);
            case DERTags.VISIBLE_STRING /* 26 */:
                return this.B;
            case DERTags.GENERAL_STRING /* 27 */:
                return this.C;
            case DERTags.UNIVERSAL_STRING /* 28 */:
                return this.D;
            case 29:
                return Boolean.valueOf(this.E);
        }
    }

    @Override // com.google.android.gms.internal.an
    protected boolean b(String str) {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Set d() {
        return this.c;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        er erVar = a;
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int e() {
        return this.d;
    }

    public boolean equals(Object obj) {
        if (obj instanceof eq) {
            if (this == obj) {
                return true;
            }
            eq eqVar = (eq) obj;
            for (an.a aVar : b.values()) {
                if (a(aVar)) {
                    if (eqVar.a(aVar) && b(aVar).equals(eqVar.b(aVar))) {
                    }
                    return false;
                } else if (eqVar.a(aVar)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public String f() {
        return this.e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a h() {
        return this.f;
    }

    public int hashCode() {
        int i2 = 0;
        Iterator it = b.values().iterator();
        while (true) {
            int i3 = i2;
            if (!it.hasNext()) {
                return i3;
            }
            an.a aVar = (an.a) it.next();
            if (a(aVar)) {
                i2 = b(aVar).hashCode() + i3 + aVar.g();
            } else {
                i2 = i3;
            }
        }
    }

    public String i() {
        return this.g;
    }

    public String j() {
        return this.h;
    }

    public int k() {
        return this.i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b l() {
        return this.j;
    }

    public String m() {
        return this.k;
    }

    public String n() {
        return this.l;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List o() {
        return this.m;
    }

    public String p() {
        return this.n;
    }

    public int q() {
        return this.o;
    }

    public boolean r() {
        return this.p;
    }

    public String s() {
        return this.q;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public d t() {
        return this.r;
    }

    public boolean u() {
        return this.s;
    }

    public String v() {
        return this.t;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e w() {
        return this.u;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        er erVar = a;
        er.a(this, parcel, i2);
    }

    public String x() {
        return this.v;
    }

    public int y() {
        return this.w;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List z() {
        return this.x;
    }
}

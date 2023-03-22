package kotlin.reflect.jvm.internal.impl.name;
/* loaded from: classes9.dex */
public final class Name implements Comparable<Name> {
    public final String name;
    public final boolean special;

    public static /* synthetic */ void $$$reportNull$$$0(int i) {
        String str = (i == 1 || i == 2) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i == 1 || i == 2) ? 2 : 3];
        if (i == 1 || i == 2) {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/name/Name";
        } else {
            objArr[0] = "name";
        }
        if (i == 1) {
            objArr[1] = "asString";
        } else if (i != 2) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/name/Name";
        } else {
            objArr[1] = "getIdentifier";
        }
        switch (i) {
            case 1:
            case 2:
                break;
            case 3:
                objArr[2] = "identifier";
                break;
            case 4:
                objArr[2] = "isValidIdentifier";
                break;
            case 5:
                objArr[2] = "special";
                break;
            case 6:
                objArr[2] = "guessByFirstCharacter";
                break;
            default:
                objArr[2] = "<init>";
                break;
        }
        String format = String.format(str, objArr);
        if (i != 1 && i != 2) {
            throw new IllegalArgumentException(format);
        }
        throw new IllegalStateException(format);
    }

    public Name(String str, boolean z) {
        if (str == null) {
            $$$reportNull$$$0(0);
        }
        this.name = str;
        this.special = z;
    }

    public static Name guessByFirstCharacter(String str) {
        if (str == null) {
            $$$reportNull$$$0(6);
        }
        if (str.startsWith("<")) {
            return special(str);
        }
        return identifier(str);
    }

    public static Name identifier(String str) {
        if (str == null) {
            $$$reportNull$$$0(3);
        }
        return new Name(str, false);
    }

    public static Name special(String str) {
        if (str == null) {
            $$$reportNull$$$0(5);
        }
        if (str.startsWith("<")) {
            return new Name(str, true);
        }
        throw new IllegalArgumentException("special name must start with '<': " + str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Name)) {
            return false;
        }
        Name name = (Name) obj;
        if (this.special == name.special && this.name.equals(name.name)) {
            return true;
        }
        return false;
    }

    public static boolean isValidIdentifier(String str) {
        if (str == null) {
            $$$reportNull$$$0(4);
        }
        if (str.isEmpty() || str.startsWith("<")) {
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (charAt == '.' || charAt == '/' || charAt == '\\') {
                return false;
            }
        }
        return true;
    }

    public String asString() {
        String str = this.name;
        if (str == null) {
            $$$reportNull$$$0(1);
        }
        return str;
    }

    public String getIdentifier() {
        if (!this.special) {
            String asString = asString();
            if (asString == null) {
                $$$reportNull$$$0(2);
            }
            return asString;
        }
        throw new IllegalStateException("not identifier: " + this);
    }

    public int hashCode() {
        return (this.name.hashCode() * 31) + (this.special ? 1 : 0);
    }

    public boolean isSpecial() {
        return this.special;
    }

    public String toString() {
        return this.name;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    public int compareTo(Name name) {
        return this.name.compareTo(name.name);
    }
}

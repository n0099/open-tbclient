package com.facebook.imagepipeline.common;

import com.facebook.common.internal.g;
import java.util.Locale;
import java.util.regex.Pattern;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;
@Immutable
/* loaded from: classes11.dex */
public class a {
    @Nullable
    private static Pattern lMT;
    public final int from;
    public final int to;

    public a(int i, int i2) {
        this.from = i;
        this.to = i2;
    }

    public String dlP() {
        return String.format(null, "bytes=%s-%s", HQ(this.from), HQ(this.to));
    }

    public boolean a(@Nullable a aVar) {
        return aVar != null && this.from <= aVar.from && this.to >= aVar.to;
    }

    public String toString() {
        return String.format(null, "%s-%s", HQ(this.from), HQ(this.to));
    }

    private static String HQ(int i) {
        return i == Integer.MAX_VALUE ? "" : Integer.toString(i);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof a) {
            a aVar = (a) obj;
            return this.from == aVar.from && this.to == aVar.to;
        }
        return false;
    }

    public int hashCode() {
        return com.facebook.common.util.a.hashCode(this.from, this.to);
    }

    public static a HR(int i) {
        g.checkArgument(i >= 0);
        return new a(i, Integer.MAX_VALUE);
    }

    public static a HS(int i) {
        g.checkArgument(i > 0);
        return new a(0, i);
    }

    @Nullable
    public static a OE(@Nullable String str) throws IllegalArgumentException {
        a aVar = null;
        if (str != null) {
            if (lMT == null) {
                lMT = Pattern.compile("[-/ ]");
            }
            try {
                String[] split = lMT.split(str);
                g.checkArgument(split.length == 4);
                g.checkArgument(split[0].equals("bytes"));
                int parseInt = Integer.parseInt(split[1]);
                int parseInt2 = Integer.parseInt(split[2]);
                int parseInt3 = Integer.parseInt(split[3]);
                g.checkArgument(parseInt2 > parseInt);
                g.checkArgument(parseInt3 > parseInt2);
                if (parseInt2 < parseInt3 - 1) {
                    aVar = new a(parseInt, parseInt2);
                } else {
                    aVar = new a(parseInt, Integer.MAX_VALUE);
                }
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException(String.format((Locale) aVar, "Invalid Content-Range header value: \"%s\"", str), e);
            }
        }
        return aVar;
    }
}

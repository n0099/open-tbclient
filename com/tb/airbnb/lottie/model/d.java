package com.tb.airbnb.lottie.model;

import android.support.annotation.RestrictTo;
import com.tb.airbnb.lottie.model.content.j;
import java.util.List;
@RestrictTo({RestrictTo.Scope.LIBRARY})
/* loaded from: classes5.dex */
public class d {
    private final double ho;
    private final char hy;
    private final String hz;
    private final List<j> shapes;
    private final String style;
    private final double width;

    public static int a(char c, String str, String str2) {
        return ((((c + 0) * 31) + str.hashCode()) * 31) + str2.hashCode();
    }

    public d(List<j> list, char c, double d, double d2, String str, String str2) {
        this.shapes = list;
        this.hy = c;
        this.ho = d;
        this.width = d2;
        this.style = str;
        this.hz = str2;
    }

    public List<j> ci() {
        return this.shapes;
    }

    public double getWidth() {
        return this.width;
    }

    public int hashCode() {
        return a(this.hy, this.hz, this.style);
    }
}

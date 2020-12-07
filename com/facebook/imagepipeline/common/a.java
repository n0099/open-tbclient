package com.facebook.imagepipeline.common;

import android.support.v7.widget.ActivityChooserView;
import com.facebook.common.internal.g;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;
@Immutable
/* loaded from: classes7.dex */
public class a {
    public final int from;
    public final int to;

    public a(int i, int i2) {
        this.from = i;
        this.to = i2;
    }

    public boolean a(@Nullable a aVar) {
        return aVar != null && this.from <= aVar.from && this.to >= aVar.to;
    }

    public String toString() {
        return String.format(null, "%s-%s", QC(this.from), QC(this.to));
    }

    private static String QC(int i) {
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

    public static a QD(int i) {
        g.checkArgument(i >= 0);
        return new a(i, ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
    }

    public static a QE(int i) {
        g.checkArgument(i > 0);
        return new a(0, i);
    }
}

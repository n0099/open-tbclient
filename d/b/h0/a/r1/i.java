package d.b.h0.a.r1;

import android.os.Bundle;
import android.text.TextUtils;
import d.b.h0.a.r1.i;
/* loaded from: classes3.dex */
public abstract class i<SelfT extends i<SelfT>> extends d.b.h0.a.y0.e.f.c<SelfT> {

    /* renamed from: g  reason: collision with root package name */
    public final String f46466g;

    /* loaded from: classes3.dex */
    public static final class a extends i<a> {
        public a(String str) {
            super(str);
        }

        public a D() {
            return this;
        }

        @Override // d.b.h0.a.i2.u0.d
        public /* bridge */ /* synthetic */ d.b.h0.a.i2.u0.d a() {
            D();
            return this;
        }

        public a(String str, Bundle bundle) {
            super(str, bundle);
        }
    }

    public i(String str) {
        this(str, null);
    }

    @Override // d.b.h0.a.y0.e.f.c
    public String toString() {
        return String.format("Event(%s) Ext => %s", this.f46466g, super.toString());
    }

    public i(String str, Bundle bundle) {
        super(bundle);
        this.f46466g = TextUtils.isEmpty(str) ? "" : str;
    }
}

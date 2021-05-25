package d.a.l0.a.a2;

import android.os.Bundle;
import android.text.TextUtils;
import d.a.l0.a.a2.i;
/* loaded from: classes3.dex */
public abstract class i<SelfT extends i<SelfT>> extends d.a.l0.a.f1.e.f.c<SelfT> {

    /* renamed from: f  reason: collision with root package name */
    public final String f40755f;

    /* loaded from: classes3.dex */
    public static final class a extends i<a> {
        public a(String str) {
            super(str);
        }

        public a E() {
            return this;
        }

        @Override // d.a.l0.a.v2.e1.d
        public /* bridge */ /* synthetic */ d.a.l0.a.v2.e1.d a() {
            E();
            return this;
        }

        public a(String str, Bundle bundle) {
            super(str, bundle);
        }
    }

    public i(String str) {
        this(str, null);
    }

    @Override // d.a.l0.a.f1.e.f.c
    public String toString() {
        return String.format("Event(%s) Ext => %s", this.f40755f, super.toString());
    }

    public i(String str, Bundle bundle) {
        super(bundle);
        this.f40755f = TextUtils.isEmpty(str) ? "" : str;
    }
}

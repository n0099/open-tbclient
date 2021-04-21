package com.google.common.base;

import d.h.c.a.d;
import d.h.c.a.e;
import d.h.c.a.n;
import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* loaded from: classes6.dex */
public final class JdkPattern extends e implements Serializable {
    public static final long serialVersionUID = 0;
    public final Pattern pattern;

    /* loaded from: classes6.dex */
    public static final class a extends d {

        /* renamed from: a  reason: collision with root package name */
        public final Matcher f30684a;

        public a(Matcher matcher) {
            n.p(matcher);
            this.f30684a = matcher;
        }

        @Override // d.h.c.a.d
        public boolean a() {
            return this.f30684a.find();
        }
    }

    public JdkPattern(Pattern pattern) {
        n.p(pattern);
        this.pattern = pattern;
    }

    @Override // d.h.c.a.e
    public int flags() {
        return this.pattern.flags();
    }

    @Override // d.h.c.a.e
    public d matcher(CharSequence charSequence) {
        return new a(this.pattern.matcher(charSequence));
    }

    @Override // d.h.c.a.e
    public String pattern() {
        return this.pattern.pattern();
    }

    @Override // d.h.c.a.e
    public String toString() {
        return this.pattern.toString();
    }
}

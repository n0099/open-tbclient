package com.google.common.base;

import d.g.c.a.d;
import d.g.c.a.e;
import d.g.c.a.n;
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
        public final Matcher f30866a;

        public a(Matcher matcher) {
            n.p(matcher);
            this.f30866a = matcher;
        }

        @Override // d.g.c.a.d
        public boolean a() {
            return this.f30866a.find();
        }
    }

    public JdkPattern(Pattern pattern) {
        n.p(pattern);
        this.pattern = pattern;
    }

    @Override // d.g.c.a.e
    public int flags() {
        return this.pattern.flags();
    }

    @Override // d.g.c.a.e
    public d matcher(CharSequence charSequence) {
        return new a(this.pattern.matcher(charSequence));
    }

    @Override // d.g.c.a.e
    public String pattern() {
        return this.pattern.pattern();
    }

    @Override // d.g.c.a.e
    public String toString() {
        return this.pattern.toString();
    }
}

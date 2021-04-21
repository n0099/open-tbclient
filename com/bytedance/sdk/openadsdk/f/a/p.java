package com.bytedance.sdk.openadsdk.f.a;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.android.common.others.lang.StringUtil;
/* loaded from: classes5.dex */
public class p {

    /* renamed from: a  reason: collision with root package name */
    public final int f29021a;

    /* renamed from: b  reason: collision with root package name */
    public final String f29022b;

    /* renamed from: c  reason: collision with root package name */
    public final String f29023c;

    /* renamed from: d  reason: collision with root package name */
    public final String f29024d;

    /* renamed from: e  reason: collision with root package name */
    public final String f29025e;

    /* renamed from: f  reason: collision with root package name */
    public final String f29026f;

    /* renamed from: g  reason: collision with root package name */
    public final String f29027g;

    /* renamed from: h  reason: collision with root package name */
    public final String f29028h;

    /* loaded from: classes5.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public String f29029a;

        /* renamed from: b  reason: collision with root package name */
        public String f29030b;

        /* renamed from: c  reason: collision with root package name */
        public String f29031c;

        /* renamed from: d  reason: collision with root package name */
        public String f29032d;

        /* renamed from: e  reason: collision with root package name */
        public String f29033e;

        /* renamed from: f  reason: collision with root package name */
        public String f29034f;

        /* renamed from: g  reason: collision with root package name */
        public String f29035g;

        public a() {
        }

        public a a(String str) {
            this.f29029a = str;
            return this;
        }

        public a b(String str) {
            this.f29030b = str;
            return this;
        }

        public a c(String str) {
            this.f29031c = str;
            return this;
        }

        public a d(String str) {
            this.f29032d = str;
            return this;
        }

        public a e(String str) {
            this.f29033e = str;
            return this;
        }

        public a f(String str) {
            this.f29034f = str;
            return this;
        }

        public a g(String str) {
            this.f29035g = str;
            return this;
        }

        public p a() {
            return new p(this);
        }
    }

    public static a a() {
        return new a();
    }

    @NonNull
    public String toString() {
        return "methodName: " + this.f29024d + ", params: " + this.f29025e + ", callbackId: " + this.f29026f + ", type: " + this.f29023c + ", version: " + this.f29022b + StringUtil.ARRAY_ELEMENT_SEPARATOR;
    }

    public p(String str, int i) {
        this.f29022b = null;
        this.f29023c = null;
        this.f29024d = null;
        this.f29025e = null;
        this.f29026f = str;
        this.f29027g = null;
        this.f29021a = i;
        this.f29028h = null;
    }

    public static p a(String str, int i) {
        return new p(str, i);
    }

    public static boolean a(p pVar) {
        return pVar == null || pVar.f29021a != 1 || TextUtils.isEmpty(pVar.f29024d) || TextUtils.isEmpty(pVar.f29025e);
    }

    public p(a aVar) {
        this.f29022b = aVar.f29029a;
        this.f29023c = aVar.f29030b;
        this.f29024d = aVar.f29031c;
        this.f29025e = aVar.f29032d;
        this.f29026f = aVar.f29033e;
        this.f29027g = aVar.f29034f;
        this.f29021a = 1;
        this.f29028h = aVar.f29035g;
    }
}

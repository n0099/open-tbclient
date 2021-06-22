package com.bytedance.sdk.openadsdk.f.a;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.android.common.others.lang.StringUtil;
/* loaded from: classes6.dex */
public class p {

    /* renamed from: a  reason: collision with root package name */
    public final int f29272a;

    /* renamed from: b  reason: collision with root package name */
    public final String f29273b;

    /* renamed from: c  reason: collision with root package name */
    public final String f29274c;

    /* renamed from: d  reason: collision with root package name */
    public final String f29275d;

    /* renamed from: e  reason: collision with root package name */
    public final String f29276e;

    /* renamed from: f  reason: collision with root package name */
    public final String f29277f;

    /* renamed from: g  reason: collision with root package name */
    public final String f29278g;

    /* renamed from: h  reason: collision with root package name */
    public final String f29279h;

    /* loaded from: classes6.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public String f29280a;

        /* renamed from: b  reason: collision with root package name */
        public String f29281b;

        /* renamed from: c  reason: collision with root package name */
        public String f29282c;

        /* renamed from: d  reason: collision with root package name */
        public String f29283d;

        /* renamed from: e  reason: collision with root package name */
        public String f29284e;

        /* renamed from: f  reason: collision with root package name */
        public String f29285f;

        /* renamed from: g  reason: collision with root package name */
        public String f29286g;

        public a() {
        }

        public a a(String str) {
            this.f29280a = str;
            return this;
        }

        public a b(String str) {
            this.f29281b = str;
            return this;
        }

        public a c(String str) {
            this.f29282c = str;
            return this;
        }

        public a d(String str) {
            this.f29283d = str;
            return this;
        }

        public a e(String str) {
            this.f29284e = str;
            return this;
        }

        public a f(String str) {
            this.f29285f = str;
            return this;
        }

        public a g(String str) {
            this.f29286g = str;
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
        return "methodName: " + this.f29275d + ", params: " + this.f29276e + ", callbackId: " + this.f29277f + ", type: " + this.f29274c + ", version: " + this.f29273b + StringUtil.ARRAY_ELEMENT_SEPARATOR;
    }

    public p(String str, int i2) {
        this.f29273b = null;
        this.f29274c = null;
        this.f29275d = null;
        this.f29276e = null;
        this.f29277f = str;
        this.f29278g = null;
        this.f29272a = i2;
        this.f29279h = null;
    }

    public static p a(String str, int i2) {
        return new p(str, i2);
    }

    public static boolean a(p pVar) {
        return pVar == null || pVar.f29272a != 1 || TextUtils.isEmpty(pVar.f29275d) || TextUtils.isEmpty(pVar.f29276e);
    }

    public p(a aVar) {
        this.f29273b = aVar.f29280a;
        this.f29274c = aVar.f29281b;
        this.f29275d = aVar.f29282c;
        this.f29276e = aVar.f29283d;
        this.f29277f = aVar.f29284e;
        this.f29278g = aVar.f29285f;
        this.f29272a = 1;
        this.f29279h = aVar.f29286g;
    }
}

package com.ss.android.download.api.model;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.view.View;
/* loaded from: classes4.dex */
public class b {
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public String f59369b;

    /* renamed from: c  reason: collision with root package name */
    public String f59370c;

    /* renamed from: d  reason: collision with root package name */
    public String f59371d;

    /* renamed from: e  reason: collision with root package name */
    public String f59372e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f59373f;

    /* renamed from: g  reason: collision with root package name */
    public Drawable f59374g;

    /* renamed from: h  reason: collision with root package name */
    public InterfaceC2185b f59375h;

    /* renamed from: i  reason: collision with root package name */
    public View f59376i;

    /* renamed from: j  reason: collision with root package name */
    public int f59377j;

    /* loaded from: classes4.dex */
    public static final class a {
        public View a;

        /* renamed from: b  reason: collision with root package name */
        public int f59378b;

        /* renamed from: c  reason: collision with root package name */
        public Context f59379c;

        /* renamed from: d  reason: collision with root package name */
        public String f59380d;

        /* renamed from: e  reason: collision with root package name */
        public String f59381e;

        /* renamed from: f  reason: collision with root package name */
        public String f59382f;

        /* renamed from: g  reason: collision with root package name */
        public String f59383g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f59384h;

        /* renamed from: i  reason: collision with root package name */
        public Drawable f59385i;

        /* renamed from: j  reason: collision with root package name */
        public InterfaceC2185b f59386j;

        public a(Context context) {
            this.f59379c = context;
        }

        public a a(String str) {
            this.f59380d = str;
            return this;
        }

        public a b(String str) {
            this.f59381e = str;
            return this;
        }

        public a c(String str) {
            this.f59382f = str;
            return this;
        }

        public a d(String str) {
            this.f59383g = str;
            return this;
        }

        public a a(boolean z) {
            this.f59384h = z;
            return this;
        }

        public a a(Drawable drawable) {
            this.f59385i = drawable;
            return this;
        }

        public a a(InterfaceC2185b interfaceC2185b) {
            this.f59386j = interfaceC2185b;
            return this;
        }

        public a a(int i2) {
            this.f59378b = i2;
            return this;
        }

        public b a() {
            return new b(this);
        }
    }

    /* renamed from: com.ss.android.download.api.model.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC2185b {
        void a(DialogInterface dialogInterface);

        void b(DialogInterface dialogInterface);

        void c(DialogInterface dialogInterface);
    }

    public b(a aVar) {
        this.f59373f = true;
        this.a = aVar.f59379c;
        this.f59369b = aVar.f59380d;
        this.f59370c = aVar.f59381e;
        this.f59371d = aVar.f59382f;
        this.f59372e = aVar.f59383g;
        this.f59373f = aVar.f59384h;
        this.f59374g = aVar.f59385i;
        this.f59375h = aVar.f59386j;
        this.f59376i = aVar.a;
        this.f59377j = aVar.f59378b;
    }
}

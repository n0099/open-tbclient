package com.ss.android.download.api.model;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.view.View;
/* loaded from: classes8.dex */
public class b {
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public String f57886b;

    /* renamed from: c  reason: collision with root package name */
    public String f57887c;

    /* renamed from: d  reason: collision with root package name */
    public String f57888d;

    /* renamed from: e  reason: collision with root package name */
    public String f57889e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f57890f;

    /* renamed from: g  reason: collision with root package name */
    public Drawable f57891g;

    /* renamed from: h  reason: collision with root package name */
    public InterfaceC2174b f57892h;

    /* renamed from: i  reason: collision with root package name */
    public View f57893i;

    /* renamed from: j  reason: collision with root package name */
    public int f57894j;

    /* loaded from: classes8.dex */
    public static final class a {
        public View a;

        /* renamed from: b  reason: collision with root package name */
        public int f57895b;

        /* renamed from: c  reason: collision with root package name */
        public Context f57896c;

        /* renamed from: d  reason: collision with root package name */
        public String f57897d;

        /* renamed from: e  reason: collision with root package name */
        public String f57898e;

        /* renamed from: f  reason: collision with root package name */
        public String f57899f;

        /* renamed from: g  reason: collision with root package name */
        public String f57900g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f57901h;

        /* renamed from: i  reason: collision with root package name */
        public Drawable f57902i;

        /* renamed from: j  reason: collision with root package name */
        public InterfaceC2174b f57903j;

        public a(Context context) {
            this.f57896c = context;
        }

        public a a(String str) {
            this.f57897d = str;
            return this;
        }

        public a b(String str) {
            this.f57898e = str;
            return this;
        }

        public a c(String str) {
            this.f57899f = str;
            return this;
        }

        public a d(String str) {
            this.f57900g = str;
            return this;
        }

        public a a(boolean z) {
            this.f57901h = z;
            return this;
        }

        public a a(Drawable drawable) {
            this.f57902i = drawable;
            return this;
        }

        public a a(InterfaceC2174b interfaceC2174b) {
            this.f57903j = interfaceC2174b;
            return this;
        }

        public a a(int i2) {
            this.f57895b = i2;
            return this;
        }

        public b a() {
            return new b(this);
        }
    }

    /* renamed from: com.ss.android.download.api.model.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC2174b {
        void a(DialogInterface dialogInterface);

        void b(DialogInterface dialogInterface);

        void c(DialogInterface dialogInterface);
    }

    public b(a aVar) {
        this.f57890f = true;
        this.a = aVar.f57896c;
        this.f57886b = aVar.f57897d;
        this.f57887c = aVar.f57898e;
        this.f57888d = aVar.f57899f;
        this.f57889e = aVar.f57900g;
        this.f57890f = aVar.f57901h;
        this.f57891g = aVar.f57902i;
        this.f57892h = aVar.f57903j;
        this.f57893i = aVar.a;
        this.f57894j = aVar.f57895b;
    }
}

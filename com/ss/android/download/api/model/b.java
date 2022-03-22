package com.ss.android.download.api.model;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.view.View;
/* loaded from: classes7.dex */
public class b {
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public String f42649b;

    /* renamed from: c  reason: collision with root package name */
    public String f42650c;

    /* renamed from: d  reason: collision with root package name */
    public String f42651d;

    /* renamed from: e  reason: collision with root package name */
    public String f42652e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f42653f;

    /* renamed from: g  reason: collision with root package name */
    public Drawable f42654g;

    /* renamed from: h  reason: collision with root package name */
    public InterfaceC2035b f42655h;
    public View i;
    public int j;

    /* loaded from: classes7.dex */
    public static final class a {
        public View a;

        /* renamed from: b  reason: collision with root package name */
        public int f42656b;

        /* renamed from: c  reason: collision with root package name */
        public Context f42657c;

        /* renamed from: d  reason: collision with root package name */
        public String f42658d;

        /* renamed from: e  reason: collision with root package name */
        public String f42659e;

        /* renamed from: f  reason: collision with root package name */
        public String f42660f;

        /* renamed from: g  reason: collision with root package name */
        public String f42661g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f42662h;
        public Drawable i;
        public InterfaceC2035b j;

        public a(Context context) {
            this.f42657c = context;
        }

        public a a(String str) {
            this.f42658d = str;
            return this;
        }

        public a b(String str) {
            this.f42659e = str;
            return this;
        }

        public a c(String str) {
            this.f42660f = str;
            return this;
        }

        public a d(String str) {
            this.f42661g = str;
            return this;
        }

        public a a(boolean z) {
            this.f42662h = z;
            return this;
        }

        public a a(Drawable drawable) {
            this.i = drawable;
            return this;
        }

        public a a(InterfaceC2035b interfaceC2035b) {
            this.j = interfaceC2035b;
            return this;
        }

        public a a(int i) {
            this.f42656b = i;
            return this;
        }

        public b a() {
            return new b(this);
        }
    }

    /* renamed from: com.ss.android.download.api.model.b$b  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC2035b {
        void a(DialogInterface dialogInterface);

        void b(DialogInterface dialogInterface);

        void c(DialogInterface dialogInterface);
    }

    public b(a aVar) {
        this.f42653f = true;
        this.a = aVar.f42657c;
        this.f42649b = aVar.f42658d;
        this.f42650c = aVar.f42659e;
        this.f42651d = aVar.f42660f;
        this.f42652e = aVar.f42661g;
        this.f42653f = aVar.f42662h;
        this.f42654g = aVar.i;
        this.f42655h = aVar.j;
        this.i = aVar.a;
        this.j = aVar.f42656b;
    }
}

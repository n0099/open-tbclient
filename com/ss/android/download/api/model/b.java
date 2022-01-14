package com.ss.android.download.api.model;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.view.View;
/* loaded from: classes3.dex */
public class b {
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public String f59324b;

    /* renamed from: c  reason: collision with root package name */
    public String f59325c;

    /* renamed from: d  reason: collision with root package name */
    public String f59326d;

    /* renamed from: e  reason: collision with root package name */
    public String f59327e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f59328f;

    /* renamed from: g  reason: collision with root package name */
    public Drawable f59329g;

    /* renamed from: h  reason: collision with root package name */
    public InterfaceC2179b f59330h;

    /* renamed from: i  reason: collision with root package name */
    public View f59331i;

    /* renamed from: j  reason: collision with root package name */
    public int f59332j;

    /* loaded from: classes3.dex */
    public static final class a {
        public View a;

        /* renamed from: b  reason: collision with root package name */
        public int f59333b;

        /* renamed from: c  reason: collision with root package name */
        public Context f59334c;

        /* renamed from: d  reason: collision with root package name */
        public String f59335d;

        /* renamed from: e  reason: collision with root package name */
        public String f59336e;

        /* renamed from: f  reason: collision with root package name */
        public String f59337f;

        /* renamed from: g  reason: collision with root package name */
        public String f59338g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f59339h;

        /* renamed from: i  reason: collision with root package name */
        public Drawable f59340i;

        /* renamed from: j  reason: collision with root package name */
        public InterfaceC2179b f59341j;

        public a(Context context) {
            this.f59334c = context;
        }

        public a a(String str) {
            this.f59335d = str;
            return this;
        }

        public a b(String str) {
            this.f59336e = str;
            return this;
        }

        public a c(String str) {
            this.f59337f = str;
            return this;
        }

        public a d(String str) {
            this.f59338g = str;
            return this;
        }

        public a a(boolean z) {
            this.f59339h = z;
            return this;
        }

        public a a(Drawable drawable) {
            this.f59340i = drawable;
            return this;
        }

        public a a(InterfaceC2179b interfaceC2179b) {
            this.f59341j = interfaceC2179b;
            return this;
        }

        public a a(int i2) {
            this.f59333b = i2;
            return this;
        }

        public b a() {
            return new b(this);
        }
    }

    /* renamed from: com.ss.android.download.api.model.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC2179b {
        void a(DialogInterface dialogInterface);

        void b(DialogInterface dialogInterface);

        void c(DialogInterface dialogInterface);
    }

    public b(a aVar) {
        this.f59328f = true;
        this.a = aVar.f59334c;
        this.f59324b = aVar.f59335d;
        this.f59325c = aVar.f59336e;
        this.f59326d = aVar.f59337f;
        this.f59327e = aVar.f59338g;
        this.f59328f = aVar.f59339h;
        this.f59329g = aVar.f59340i;
        this.f59330h = aVar.f59341j;
        this.f59331i = aVar.a;
        this.f59332j = aVar.f59333b;
    }
}

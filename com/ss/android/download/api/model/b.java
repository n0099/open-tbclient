package com.ss.android.download.api.model;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.view.View;
/* loaded from: classes4.dex */
public class b {
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public String f59536b;

    /* renamed from: c  reason: collision with root package name */
    public String f59537c;

    /* renamed from: d  reason: collision with root package name */
    public String f59538d;

    /* renamed from: e  reason: collision with root package name */
    public String f59539e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f59540f;

    /* renamed from: g  reason: collision with root package name */
    public Drawable f59541g;

    /* renamed from: h  reason: collision with root package name */
    public InterfaceC2195b f59542h;

    /* renamed from: i  reason: collision with root package name */
    public View f59543i;

    /* renamed from: j  reason: collision with root package name */
    public int f59544j;

    /* loaded from: classes4.dex */
    public static final class a {
        public View a;

        /* renamed from: b  reason: collision with root package name */
        public int f59545b;

        /* renamed from: c  reason: collision with root package name */
        public Context f59546c;

        /* renamed from: d  reason: collision with root package name */
        public String f59547d;

        /* renamed from: e  reason: collision with root package name */
        public String f59548e;

        /* renamed from: f  reason: collision with root package name */
        public String f59549f;

        /* renamed from: g  reason: collision with root package name */
        public String f59550g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f59551h;

        /* renamed from: i  reason: collision with root package name */
        public Drawable f59552i;

        /* renamed from: j  reason: collision with root package name */
        public InterfaceC2195b f59553j;

        public a(Context context) {
            this.f59546c = context;
        }

        public a a(String str) {
            this.f59547d = str;
            return this;
        }

        public a b(String str) {
            this.f59548e = str;
            return this;
        }

        public a c(String str) {
            this.f59549f = str;
            return this;
        }

        public a d(String str) {
            this.f59550g = str;
            return this;
        }

        public a a(boolean z) {
            this.f59551h = z;
            return this;
        }

        public a a(Drawable drawable) {
            this.f59552i = drawable;
            return this;
        }

        public a a(InterfaceC2195b interfaceC2195b) {
            this.f59553j = interfaceC2195b;
            return this;
        }

        public a a(int i2) {
            this.f59545b = i2;
            return this;
        }

        public b a() {
            return new b(this);
        }
    }

    /* renamed from: com.ss.android.download.api.model.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC2195b {
        void a(DialogInterface dialogInterface);

        void b(DialogInterface dialogInterface);

        void c(DialogInterface dialogInterface);
    }

    public b(a aVar) {
        this.f59540f = true;
        this.a = aVar.f59546c;
        this.f59536b = aVar.f59547d;
        this.f59537c = aVar.f59548e;
        this.f59538d = aVar.f59549f;
        this.f59539e = aVar.f59550g;
        this.f59540f = aVar.f59551h;
        this.f59541g = aVar.f59552i;
        this.f59542h = aVar.f59553j;
        this.f59543i = aVar.a;
        this.f59544j = aVar.f59545b;
    }
}

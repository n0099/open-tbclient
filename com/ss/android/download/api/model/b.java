package com.ss.android.download.api.model;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.view.View;
/* loaded from: classes3.dex */
public class b {
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public String f61660b;

    /* renamed from: c  reason: collision with root package name */
    public String f61661c;

    /* renamed from: d  reason: collision with root package name */
    public String f61662d;

    /* renamed from: e  reason: collision with root package name */
    public String f61663e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f61664f;

    /* renamed from: g  reason: collision with root package name */
    public Drawable f61665g;

    /* renamed from: h  reason: collision with root package name */
    public InterfaceC2162b f61666h;

    /* renamed from: i  reason: collision with root package name */
    public View f61667i;

    /* renamed from: j  reason: collision with root package name */
    public int f61668j;

    /* loaded from: classes3.dex */
    public static final class a {
        public View a;

        /* renamed from: b  reason: collision with root package name */
        public int f61669b;

        /* renamed from: c  reason: collision with root package name */
        public Context f61670c;

        /* renamed from: d  reason: collision with root package name */
        public String f61671d;

        /* renamed from: e  reason: collision with root package name */
        public String f61672e;

        /* renamed from: f  reason: collision with root package name */
        public String f61673f;

        /* renamed from: g  reason: collision with root package name */
        public String f61674g;

        /* renamed from: h  reason: collision with root package name */
        public boolean f61675h;

        /* renamed from: i  reason: collision with root package name */
        public Drawable f61676i;

        /* renamed from: j  reason: collision with root package name */
        public InterfaceC2162b f61677j;

        public a(Context context) {
            this.f61670c = context;
        }

        public a a(String str) {
            this.f61671d = str;
            return this;
        }

        public a b(String str) {
            this.f61672e = str;
            return this;
        }

        public a c(String str) {
            this.f61673f = str;
            return this;
        }

        public a d(String str) {
            this.f61674g = str;
            return this;
        }

        public a a(boolean z) {
            this.f61675h = z;
            return this;
        }

        public a a(Drawable drawable) {
            this.f61676i = drawable;
            return this;
        }

        public a a(InterfaceC2162b interfaceC2162b) {
            this.f61677j = interfaceC2162b;
            return this;
        }

        public a a(int i2) {
            this.f61669b = i2;
            return this;
        }

        public b a() {
            return new b(this);
        }
    }

    /* renamed from: com.ss.android.download.api.model.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC2162b {
        void a(DialogInterface dialogInterface);

        void b(DialogInterface dialogInterface);

        void c(DialogInterface dialogInterface);
    }

    public b(a aVar) {
        this.f61664f = true;
        this.a = aVar.f61670c;
        this.f61660b = aVar.f61671d;
        this.f61661c = aVar.f61672e;
        this.f61662d = aVar.f61673f;
        this.f61663e = aVar.f61674g;
        this.f61664f = aVar.f61675h;
        this.f61665g = aVar.f61676i;
        this.f61666h = aVar.f61677j;
        this.f61667i = aVar.a;
        this.f61668j = aVar.f61669b;
    }
}

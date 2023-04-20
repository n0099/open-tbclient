package com.ss.android.download.api.model;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.view.View;
/* loaded from: classes8.dex */
public class b {
    public Context a;
    public String b;
    public String c;
    public String d;
    public String e;
    public boolean f;
    public Drawable g;
    public InterfaceC0678b h;
    public View i;
    public int j;

    /* renamed from: com.ss.android.download.api.model.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC0678b {
        void a(DialogInterface dialogInterface);

        void b(DialogInterface dialogInterface);

        void c(DialogInterface dialogInterface);
    }

    /* loaded from: classes8.dex */
    public static final class a {
        public View a;
        public int b;
        public Context c;
        public String d;
        public String e;
        public String f;
        public String g;
        public boolean h;
        public Drawable i;
        public InterfaceC0678b j;

        public a(Context context) {
            this.c = context;
        }

        public a a(int i) {
            this.b = i;
            return this;
        }

        public a b(String str) {
            this.e = str;
            return this;
        }

        public a c(String str) {
            this.f = str;
            return this;
        }

        public a d(String str) {
            this.g = str;
            return this;
        }

        public a a(Drawable drawable) {
            this.i = drawable;
            return this;
        }

        public a a(InterfaceC0678b interfaceC0678b) {
            this.j = interfaceC0678b;
            return this;
        }

        public a a(String str) {
            this.d = str;
            return this;
        }

        public a a(boolean z) {
            this.h = z;
            return this;
        }

        public b a() {
            return new b(this);
        }
    }

    public b(a aVar) {
        this.f = true;
        this.a = aVar.c;
        this.b = aVar.d;
        this.c = aVar.e;
        this.d = aVar.f;
        this.e = aVar.g;
        this.f = aVar.h;
        this.g = aVar.i;
        this.h = aVar.j;
        this.i = aVar.a;
        this.j = aVar.b;
    }
}

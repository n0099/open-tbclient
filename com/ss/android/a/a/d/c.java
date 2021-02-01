package com.ss.android.a.a.d;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.view.View;
/* loaded from: classes6.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public Context f12899a;

    /* renamed from: b  reason: collision with root package name */
    public String f12900b;
    public String c;
    public String d;
    public String e;
    public boolean f;
    public Drawable g;
    public View i;
    public int j;
    public b qay;

    /* loaded from: classes6.dex */
    public interface b {
        void a(DialogInterface dialogInterface);

        void b(DialogInterface dialogInterface);

        void c(DialogInterface dialogInterface);
    }

    private c(a aVar) {
        this.f = true;
        this.f12899a = aVar.c;
        this.f12900b = aVar.d;
        this.c = aVar.e;
        this.d = aVar.f;
        this.e = aVar.g;
        this.f = aVar.h;
        this.g = aVar.i;
        this.qay = aVar.qaz;
        this.i = aVar.f12901a;
        this.j = aVar.f12902b;
    }

    /* loaded from: classes6.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public View f12901a;

        /* renamed from: b  reason: collision with root package name */
        public int f12902b;
        private Context c;
        private String d;
        private String e;
        private String f;
        private String g;
        private boolean h;
        private Drawable i;
        private b qaz;

        public a(Context context) {
            this.c = context;
        }

        public a aaf(String str) {
            this.d = str;
            return this;
        }

        public a aag(String str) {
            this.e = str;
            return this;
        }

        public a aah(String str) {
            this.f = str;
            return this;
        }

        public a aai(String str) {
            this.g = str;
            return this;
        }

        public a BJ(boolean z) {
            this.h = z;
            return this;
        }

        public a I(Drawable drawable) {
            this.i = drawable;
            return this;
        }

        public a a(b bVar) {
            this.qaz = bVar;
            return this;
        }

        public a QL(int i) {
            this.f12902b = i;
            return this;
        }

        public c eEc() {
            return new c(this);
        }
    }
}

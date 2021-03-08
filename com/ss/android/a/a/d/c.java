package com.ss.android.a.a.d;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.view.View;
/* loaded from: classes6.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public Context f7674a;
    public String b;
    public String c;
    public String d;
    public String e;
    public boolean f;
    public Drawable g;
    public View i;
    public int j;
    public b qbM;

    /* loaded from: classes6.dex */
    public interface b {
        void a(DialogInterface dialogInterface);

        void b(DialogInterface dialogInterface);

        void c(DialogInterface dialogInterface);
    }

    private c(a aVar) {
        this.f = true;
        this.f7674a = aVar.c;
        this.b = aVar.d;
        this.c = aVar.e;
        this.d = aVar.f;
        this.e = aVar.g;
        this.f = aVar.h;
        this.g = aVar.i;
        this.qbM = aVar.qbN;
        this.i = aVar.f7675a;
        this.j = aVar.b;
    }

    /* loaded from: classes6.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public View f7675a;
        public int b;
        private Context c;
        private String d;
        private String e;
        private String f;
        private String g;
        private boolean h;
        private Drawable i;
        private b qbN;

        public a(Context context) {
            this.c = context;
        }

        public a aaw(String str) {
            this.d = str;
            return this;
        }

        public a aax(String str) {
            this.e = str;
            return this;
        }

        public a aay(String str) {
            this.f = str;
            return this;
        }

        public a aaz(String str) {
            this.g = str;
            return this;
        }

        public a BH(boolean z) {
            this.h = z;
            return this;
        }

        public a I(Drawable drawable) {
            this.i = drawable;
            return this;
        }

        public a a(b bVar) {
            this.qbN = bVar;
            return this;
        }

        public a QQ(int i) {
            this.b = i;
            return this;
        }

        public c eEo() {
            return new c(this);
        }
    }
}

package com.ss.android.a.a.d;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.view.View;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public Context f12897a;

    /* renamed from: b  reason: collision with root package name */
    public String f12898b;
    public String c;
    public String d;
    public String e;
    public boolean f;
    public Drawable g;
    public View i;
    public int j;
    public b pQu;

    /* loaded from: classes4.dex */
    public interface b {
        void a(DialogInterface dialogInterface);

        void b(DialogInterface dialogInterface);

        void c(DialogInterface dialogInterface);
    }

    private c(a aVar) {
        this.f = true;
        this.f12897a = aVar.c;
        this.f12898b = aVar.d;
        this.c = aVar.e;
        this.d = aVar.f;
        this.e = aVar.g;
        this.f = aVar.h;
        this.g = aVar.i;
        this.pQu = aVar.pQv;
        this.i = aVar.f12899a;
        this.j = aVar.f12900b;
    }

    /* loaded from: classes4.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public View f12899a;

        /* renamed from: b  reason: collision with root package name */
        public int f12900b;
        private Context c;
        private String d;
        private String e;
        private String f;
        private String g;
        private boolean h;
        private Drawable i;
        private b pQv;

        public a(Context context) {
            this.c = context;
        }

        public a Ze(String str) {
            this.d = str;
            return this;
        }

        public a Zf(String str) {
            this.e = str;
            return this;
        }

        public a Zg(String str) {
            this.f = str;
            return this;
        }

        public a Zh(String str) {
            this.g = str;
            return this;
        }

        public a Bp(boolean z) {
            this.h = z;
            return this;
        }

        public a I(Drawable drawable) {
            this.i = drawable;
            return this;
        }

        public a a(b bVar) {
            this.pQv = bVar;
            return this;
        }

        public a Qq(int i) {
            this.f12900b = i;
            return this;
        }

        public c eBL() {
            return new c(this);
        }
    }
}

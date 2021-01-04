package com.ss.android.a.a.d;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.view.View;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public Context f13196a;

    /* renamed from: b  reason: collision with root package name */
    public String f13197b;
    public String c;
    public String d;
    public String e;
    public boolean f;
    public Drawable g;
    public View i;
    public int j;
    public b pTl;

    /* loaded from: classes4.dex */
    public interface b {
        void a(DialogInterface dialogInterface);

        void b(DialogInterface dialogInterface);

        void c(DialogInterface dialogInterface);
    }

    private c(a aVar) {
        this.f = true;
        this.f13196a = aVar.c;
        this.f13197b = aVar.d;
        this.c = aVar.e;
        this.d = aVar.f;
        this.e = aVar.g;
        this.f = aVar.h;
        this.g = aVar.i;
        this.pTl = aVar.pTm;
        this.i = aVar.f13198a;
        this.j = aVar.f13199b;
    }

    /* loaded from: classes4.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public View f13198a;

        /* renamed from: b  reason: collision with root package name */
        public int f13199b;
        private Context c;
        private String d;
        private String e;
        private String f;
        private String g;
        private boolean h;
        private Drawable i;
        private b pTm;

        public a(Context context) {
            this.c = context;
        }

        public a aak(String str) {
            this.d = str;
            return this;
        }

        public a aal(String str) {
            this.e = str;
            return this;
        }

        public a aam(String str) {
            this.f = str;
            return this;
        }

        public a aan(String str) {
            this.g = str;
            return this;
        }

        public a Bt(boolean z) {
            this.h = z;
            return this;
        }

        public a I(Drawable drawable) {
            this.i = drawable;
            return this;
        }

        public a a(b bVar) {
            this.pTm = bVar;
            return this;
        }

        public a RH(int i) {
            this.f13199b = i;
            return this;
        }

        public c eEY() {
            return new c(this);
        }
    }
}

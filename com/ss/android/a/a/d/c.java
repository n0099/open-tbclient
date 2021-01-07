package com.ss.android.a.a.d;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.view.View;
/* loaded from: classes4.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public Context f13197a;

    /* renamed from: b  reason: collision with root package name */
    public String f13198b;
    public String c;
    public String d;
    public String e;
    public boolean f;
    public Drawable g;
    public View i;
    public int j;
    public b pUT;

    /* loaded from: classes4.dex */
    public interface b {
        void a(DialogInterface dialogInterface);

        void b(DialogInterface dialogInterface);

        void c(DialogInterface dialogInterface);
    }

    private c(a aVar) {
        this.f = true;
        this.f13197a = aVar.c;
        this.f13198b = aVar.d;
        this.c = aVar.e;
        this.d = aVar.f;
        this.e = aVar.g;
        this.f = aVar.h;
        this.g = aVar.i;
        this.pUT = aVar.pUU;
        this.i = aVar.f13199a;
        this.j = aVar.f13200b;
    }

    /* loaded from: classes4.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public View f13199a;

        /* renamed from: b  reason: collision with root package name */
        public int f13200b;
        private Context c;
        private String d;
        private String e;
        private String f;
        private String g;
        private boolean h;
        private Drawable i;
        private b pUU;

        public a(Context context) {
            this.c = context;
        }

        public a aal(String str) {
            this.d = str;
            return this;
        }

        public a aam(String str) {
            this.e = str;
            return this;
        }

        public a aan(String str) {
            this.f = str;
            return this;
        }

        public a aao(String str) {
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
            this.pUU = bVar;
            return this;
        }

        public a RX(int i) {
            this.f13200b = i;
            return this;
        }

        public c eFC() {
            return new c(this);
        }
    }
}

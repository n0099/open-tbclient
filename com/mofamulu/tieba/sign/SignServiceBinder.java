package com.mofamulu.tieba.sign;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Binder;
import com.mofamulu.tieba.ch.bg;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class SignServiceBinder extends Binder {
    protected final bg a;
    protected final ak b;
    protected final HashMap c = new HashMap();
    private final ap d;
    private SignService e;

    /* JADX INFO: Access modifiers changed from: package-private */
    public SignServiceBinder(SignService signService) {
        this.e = signService;
        this.a = new bg(signService);
        this.b = new ak(signService);
        this.d = new ap(signService, this.b, this.a);
        this.d.start();
    }

    public void a() {
        this.e.stopSelf();
    }

    public void b() {
        this.d.c();
        this.b.c();
    }

    public boolean c() {
        return this.d.d();
    }

    public List d() {
        return this.d.g();
    }

    public List e() {
        List<al> b = this.b.b();
        if (!b.isEmpty() && c()) {
            LinkedList linkedList = new LinkedList();
            for (al alVar : b) {
                ar c = c(alVar.a);
                if (c != null) {
                    linkedList.addLast(c.t());
                } else {
                    linkedList.addLast(alVar);
                }
            }
            return linkedList;
        }
        return b;
    }

    public ar a(String str) {
        ar c = c(str);
        if (c == null) {
            al b = this.b.b(str);
            if (b == null) {
                return null;
            }
            ar a = ar.a(this.a, b, b.d(), b.e(), b.f());
            a.b(b.h());
            a.a(this.a.r());
            a.b(b.g());
            return a;
        }
        return c;
    }

    public al b(String str) {
        ar c = c(str);
        return c != null ? c.t() : this.b.b(str);
    }

    protected ar c(String str) {
        List<ar> d = d();
        if (d == null) {
            return null;
        }
        for (ar arVar : d) {
            if (str.equals(arVar.s())) {
                return arVar;
            }
        }
        return null;
    }

    public void d(String str) {
        this.b.c(str);
        Iterator it = this.d.f.iterator();
        while (it.hasNext()) {
            ((am) it.next()).a();
        }
    }

    public void a(AccountAddActivity accountAddActivity, al alVar, String str) {
        new ao(this, alVar, str, accountAddActivity).start();
    }

    public void f() {
        this.d.a(true);
    }

    public void g() {
        this.d.a(false);
    }

    public void e(String str) {
        this.d.a(str);
    }

    public void a(am amVar) {
        this.d.f.add(amVar);
    }

    public void b(am amVar) {
        this.d.f.remove(amVar);
    }

    public void a(Activity activity) {
        this.d.f();
        Iterator it = this.d.f.iterator();
        while (it.hasNext()) {
            ((am) it.next()).a();
        }
    }

    public Bitmap f(String str) {
        InputStream inputStream = null;
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setRequestProperty("Accept-Encoding", "");
            httpURLConnection.setDoInput(true);
            httpURLConnection.connect();
            inputStream = httpURLConnection.getInputStream();
            Bitmap decodeStream = BitmapFactory.decodeStream(inputStream);
            httpURLConnection.disconnect();
            return decodeStream;
        } finally {
            com.mofamulu.tieba.ch.ac.a(inputStream);
        }
    }
}

package com.mofamulu.tieba.ch;

import android.content.SharedPreferences;
import android.util.Log;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class bj {
    private static long e = 259200000;
    public JSONObject a;
    protected long b;
    protected volatile Boolean c = false;
    private final SharedPreferences d;

    public bj(SharedPreferences sharedPreferences) {
        this.d = sharedPreferences;
        a();
    }

    protected void a() {
        try {
            String string = this.d.getString("vs", null);
            this.b = this.d.getLong("vs_ut", System.currentTimeMillis());
            this.a = new JSONObject(string);
        } catch (Throwable th) {
            this.a = new JSONObject();
        }
    }

    public Iterator b() {
        return this.a.keys();
    }

    public void c() {
        Iterator<String> keys = this.a.keys();
        LinkedList linkedList = new LinkedList();
        while (keys.hasNext()) {
            String next = keys.next();
            if (next instanceof String) {
                linkedList.addLast(next);
            }
        }
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            this.a.remove((String) it.next());
        }
        e();
    }

    public boolean d() {
        Iterator<String> keys = this.a.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            if ((next instanceof String) && this.a.optInt(next, 0) > 0) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e() {
        try {
            SharedPreferences.Editor edit = this.d.edit();
            edit.putString("vs", this.a.toString());
            edit.putLong("vs_ut", this.b);
            edit.commit();
        } catch (Throwable th) {
            Log.e("tbhp_vip", "failed to saveToProperties", th);
        }
    }

    public boolean a(String str, boolean z) {
        if (str == null) {
            return false;
        }
        if (!this.a.has(str)) {
            try {
                this.a.putOpt(str, Integer.valueOf(z ? 1 : 0));
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            a(str);
            return z;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis < this.b) {
            a((String) null);
        } else if (currentTimeMillis - this.b > e) {
            a((String) null);
        }
        return this.a.optInt(str, z ? 1 : 0) > 0;
    }

    private void a(String str) {
        if (str != null || !this.c.booleanValue()) {
            try {
                a.a(new bk(this, str));
            } catch (Throwable th) {
            }
        }
    }

    public void a(bl blVar) {
        try {
            a.a(new bk(this, blVar));
        } catch (Throwable th) {
        }
    }
}

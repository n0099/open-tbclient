package com.win.opensdk;

import android.content.Context;
/* loaded from: classes14.dex */
public class r {
    public static r qkx;
    public j qky = j.eIX();
    public be qkz;

    public static r eIZ() {
        synchronized (r.class) {
            if (qkx == null) {
                qkx = new r();
            }
        }
        return qkx;
    }

    public void a(Context context, String str, K0 k0, String str2, m mVar) {
        try {
            this.qkz = (be) this.qky.abV(str);
            if (this.qkz == null) {
                this.qkz = new be(context, k0);
            }
            this.qkz.a(str2, null);
            this.qkz.qkZ = mVar;
            this.qky.a(str, this.qkz);
        } catch (Exception e) {
        }
    }
}

package com.win.opensdk;

import java.util.Map;
import org.json.JSONException;
/* loaded from: classes7.dex */
public final class c1 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f39908a;

    public c1(String str) {
        this.f39908a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            G.a(new T0(this.f39908a, "GET", G.a((Map) null)).a(), new u1());
        } catch (JSONException e2) {
            e2.getMessage();
        } catch (Exception e3) {
            e3.getMessage();
        }
    }
}

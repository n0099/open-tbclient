package com.win.opensdk;

import java.util.Map;
import org.json.JSONException;
/* loaded from: classes7.dex */
public final class z0 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f40865a;

    public z0(String str) {
        this.f40865a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            z.a(new s0(this.f40865a, "GET", z.a((Map) null)).a(), new R0());
        } catch (JSONException e2) {
            e2.getMessage();
        } catch (Exception e3) {
            e3.getMessage();
        }
    }
}

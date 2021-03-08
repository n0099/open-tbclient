package com.win.opensdk;

import java.util.Map;
import org.json.JSONException;
/* loaded from: classes14.dex */
public final class cg implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f8143a;

    public cg(String str) {
        this.f8143a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            v.a(new bk(this.f8143a, "GET", v.a((Map) null)).eJc(), new ep());
        } catch (JSONException e) {
            e.getMessage();
        } catch (Exception e2) {
            e2.getMessage();
        }
    }
}

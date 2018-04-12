package com.xiaomi.network;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class Fallbacks {
    private String host;
    private final ArrayList<Fallback> mFallbacks = new ArrayList<>();

    public Fallbacks() {
    }

    public Fallbacks(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("the host is empty");
        }
        this.host = str;
    }

    public synchronized void addFallback(Fallback fallback) {
        int i;
        int i2 = 0;
        while (true) {
            i = i2;
            if (i >= this.mFallbacks.size()) {
                break;
            } else if (this.mFallbacks.get(i).a(fallback)) {
                this.mFallbacks.set(i, fallback);
                break;
            } else {
                i2 = i + 1;
            }
        }
        if (i >= this.mFallbacks.size()) {
            this.mFallbacks.add(fallback);
        }
    }

    public synchronized Fallbacks fromJSON(JSONObject jSONObject) {
        this.host = jSONObject.getString("host");
        JSONArray jSONArray = jSONObject.getJSONArray("fbs");
        for (int i = 0; i < jSONArray.length(); i++) {
            this.mFallbacks.add(new Fallback(this.host).a(jSONArray.getJSONObject(i)));
        }
        return this;
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x001a, code lost:
        com.xiaomi.network.HostManager.getInstance().setCurrentISP(r0.e());
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized Fallback getFallback() {
        Fallback fallback;
        int size = this.mFallbacks.size() - 1;
        while (true) {
            if (size < 0) {
                fallback = null;
                break;
            }
            fallback = this.mFallbacks.get(size);
            if (fallback.a()) {
                break;
            }
            size--;
        }
        return fallback;
    }

    public ArrayList<Fallback> getFallbacks() {
        return this.mFallbacks;
    }

    public String getHost() {
        return this.host;
    }

    public synchronized void purge(boolean z) {
        for (int size = this.mFallbacks.size() - 1; size >= 0; size--) {
            Fallback fallback = this.mFallbacks.get(size);
            if (z) {
                if (fallback.c()) {
                    this.mFallbacks.remove(size);
                }
            } else if (!fallback.b()) {
                this.mFallbacks.remove(size);
            }
        }
    }

    public synchronized JSONObject toJSON() {
        JSONObject jSONObject;
        jSONObject = new JSONObject();
        jSONObject.put("host", this.host);
        JSONArray jSONArray = new JSONArray();
        Iterator<Fallback> it = this.mFallbacks.iterator();
        while (it.hasNext()) {
            jSONArray.put(it.next().f());
        }
        jSONObject.put("fbs", jSONArray);
        return jSONObject;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.host);
        sb.append("\n");
        Iterator<Fallback> it = this.mFallbacks.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
        }
        return sb.toString();
    }
}

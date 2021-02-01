package com.kwai.video.ksvodplayerkit;

import android.content.Context;
import android.text.TextUtils;
import com.kwai.video.player.kwai_player.KwaiPlayerVodBuilder;
import java.util.List;
import java.util.Map;
/* loaded from: classes3.dex */
public class KSVodPlayerBuilder {

    /* renamed from: a  reason: collision with root package name */
    public Context f11038a;

    /* renamed from: b  reason: collision with root package name */
    public String f11039b;
    public List<String> c;
    public Map<String, String> d;
    public l e;
    public com.kwai.video.ksvodplayerkit.b.h h;
    public int j;
    public Map<String, String> k;
    public com.kwai.video.ksvodplayerkit.c.b m;
    public boolean n;
    public long o;
    private KwaiPlayerVodBuilder p;
    public VodPlayEnterType f = VodPlayEnterType.CLICK;
    public boolean g = true;
    public int i = 0;
    public String l = "N/A";

    /* loaded from: classes3.dex */
    public enum VodPlayEnterType {
        SLIDE,
        CLICK
    }

    public KSVodPlayerBuilder(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("Wrong Input Arguments! Context con't be null!");
        }
        this.p = new KwaiPlayerVodBuilder(context);
        this.f11038a = context;
    }

    public KSVodPlayerBuilder a(String str) {
        this.f11039b = str;
        return this;
    }

    public KSVodPlayerBuilder a(Map<String, String> map) {
        this.k = map;
        return this;
    }

    public KSVodPlayerBuilder a(boolean z) {
        this.n = z;
        return this;
    }

    public KwaiPlayerVodBuilder a() {
        return this.p;
    }

    public g b() {
        if (this.f11038a == null) {
            throw new IllegalArgumentException("Wrong Input Arguments! Please set context!");
        }
        if ((this.f11039b == null || TextUtils.isEmpty(this.f11039b)) && ((this.c == null || this.c.isEmpty()) && (this.h == null || this.h.f11051b == null || this.h.f11051b.isEmpty()))) {
            throw new IllegalArgumentException("Wrong Input Arguments! Please SetDatasource!");
        }
        return new g(this);
    }
}
